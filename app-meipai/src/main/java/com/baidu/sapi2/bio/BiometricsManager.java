package com.baidu.sapi2.bio;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometric;
import com.baidu.pass.biometrics.base.PassBiometricFactory;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation;
import com.baidu.pass.biometrics.face.liveness.PassFaceOperation.OperationType;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiometricsManager implements NoProguard {
    public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
    public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
    public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_REG = "faceDetect";
    public static final String LIVENESS_RECOGNIZE_TYPE_UN_REALNAME_VERIFY = "outer";
    public static final String PASS_PRODUCT_ID = "pp";
    public static final String TAG = "BiometricsManager";

    /* renamed from: a reason: collision with root package name */
    public static BiometricsManager f2709a = null;

    /* renamed from: b reason: collision with root package name */
    public static final String f2710b = "scene:certlogin";

    /* renamed from: c reason: collision with root package name */
    public static final String f2711c = "scene:uncertlogin";

    public class a {

        /* renamed from: a reason: collision with root package name */
        public static final String f2712a = "bduss";

        /* renamed from: b reason: collision with root package name */
        public static final String f2713b = "certinfo";

        /* renamed from: c reason: collision with root package name */
        public static final String f2714c = "authtoken";

        /* renamed from: d reason: collision with root package name */
        public static final String f2715d = "faceDetect";

        /* renamed from: e reason: collision with root package name */
        public static final String f2716e = "outer";

        /* renamed from: f reason: collision with root package name */
        public String f2717f;

        /* renamed from: g reason: collision with root package name */
        public int f2718g;

        /* renamed from: h reason: collision with root package name */
        public int f2719h;

        /* renamed from: i reason: collision with root package name */
        public String f2720i;

        /* renamed from: j reason: collision with root package name */
        public int f2721j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public List<PassNameValuePair> s = new ArrayList();

        public a() {
        }
    }

    public static String buildSubPro(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("pp-pp-");
        sb.append(str);
        sb.append("-{tpl:");
        sb.append(SapiAccountManager.getInstance().getConfignation().tpl);
        sb.append(",scene:");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public static BiometricsManager getInstance() {
        if (f2709a == null) {
            f2709a = new BiometricsManager();
        }
        return f2709a;
    }

    public void livenessRecognize(Context context, PassFaceRecogType passFaceRecogType, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, PassFaceRecogCallback passFaceRecogCallback) {
        PassFaceRecogType passFaceRecogType2 = passFaceRecogType;
        String str10 = str;
        Map<String, String> map2 = map;
        String str11 = str6;
        PassBiometric biometric = PassBiometricFactory.getDefaultFactory().getBiometric(4);
        PassFaceRecogDTO passFaceRecogDTO = new PassFaceRecogDTO();
        PassFaceOperation passFaceOperation = new PassFaceOperation();
        passFaceOperation.operationType = OperationType.RECOGNIZE;
        passFaceRecogDTO.extraParamsMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, str);
        passFaceRecogDTO.extraParamsMap.put("cuid", SapiUtils.getClientId(context));
        passFaceRecogDTO.imageFlag = str2;
        if (map2 != null) {
            passFaceRecogDTO.extraParamsMap.putAll(map);
        }
        passFaceRecogDTO.livenessType = passFaceRecogType2;
        if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            passFaceRecogDTO.realName = str7;
            passFaceRecogDTO.idCardNum = str8;
            passFaceRecogDTO.phoneNum = str9;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str3);
            if (accountFromBduss != null) {
                passFaceRecogDTO.bduss = accountFromBduss.bduss;
                passFaceRecogDTO.uid = accountFromBduss.uid;
                passFaceRecogDTO.stoken = str4;
            }
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            passFaceRecogDTO.authToken = str5;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
            passFaceRecogDTO.exUid = str11;
        } else if (passFaceRecogType2 == PassFaceRecogType.RECOG_TYPE_OUTER) {
            passFaceRecogDTO.exUid = str11;
        }
        passFaceRecogDTO.passProductId = str10;
        if (!TextUtils.isEmpty(str) && (str.contains(f2710b) || str.contains(f2711c))) {
            try {
                passFaceRecogDTO.guideLiveness = false;
            } catch (Throwable unused) {
            }
        }
        Context context2 = context;
        biometric.execute(passFaceOperation, new a(this, passFaceRecogCallback), passFaceRecogDTO, context);
    }

    public void recogWithAuthToken(Context context, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_AUTHTOKEN, str, map, str2, "", "", str3, "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithBduss(Context context, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_BDUSS, str, map, str2, str3, str4, "", "", "", "", "", passFaceRecogCallback);
    }

    public void recogWithCertInfo(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_CERTINFO, str, map, str2, "", "", "", "", str3, str4, str5, passFaceRecogCallback);
    }

    public void recogWithFaceDetect(Context context, String str, Map<String, String> map, String str2, String str3, String str4, PassFaceRecogCallback passFaceRecogCallback) {
        Map<String, String> hashMap = map == null ? new HashMap<>() : map;
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("authsid", str4);
        }
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_FACEDETECT, str, hashMap, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }

    public void recogWithFaceOuter(Context context, String str, Map<String, String> map, String str2, String str3, PassFaceRecogCallback passFaceRecogCallback) {
        livenessRecognize(context, PassFaceRecogType.RECOG_TYPE_OUTER, str, map, str2, "", "", "", str3, "", "", "", passFaceRecogCallback);
    }
}
