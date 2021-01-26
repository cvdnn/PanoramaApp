package com.baidu.pass.biometrics.base.http;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.http.utils.HttpUtils;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.utils.Crypto;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.PhoneUtils;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.sina.weibo.sdk.statistic.LogBuilder;
import e.c.b.e.Utils;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClientWrap {
    public static final String KEY_REQID = "reqid";
    public static final String PARAM_CUID_2 = "cuid_2";
    public static final String PARAM_ENCODE = "encode";
    public static final String PARAM_UA = "ua";
    public static final String SING_SHA1 = "s1";
    public static final String SP_PARAMETER = "sp_params";
    public Context context;
    public PassHttpClient passHttpClient = new PassHttpClient();

    public HttpClientWrap(Context context2) {
        this.context = context2;
    }

    public static Map<String, String> appendCertification(Context context2) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_ENCODE, "utf-8");
        hashMap.put(PARAM_UA, PassBiometricUtil.getUA(context2, BeanConstants.tpl));
        hashMap.put(LogBuilder.KEY_TIME, String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("appid", BeanConstants.appid);
        hashMap.put("tpl", BeanConstants.tpl);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_CUID_2, PhoneUtils.getCUID2(context2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("wcp", PassBioDataEncryptor.encryptParams(new String(jSONObject.toString().getBytes())));
        return hashMap;
    }

    private PassHttpParamDTO buildParamDTO(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        passHttpParamDTO.url = str;
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = PassBiometricUtil.getUA(this.context, BeanConstants.tpl);
        passHttpParamDTO.connectTimeout = i2;
        passHttpParamDTO.asyncCookie = true;
        return passHttpParamDTO;
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
        ArrayList arrayList = new ArrayList();
        for (Object add : map.keySet()) {
            arrayList.add(add);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            try {
                String str3 = (String) map.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append("&");
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        sb.append("sign_key=");
        sb.append(str);
        return Utils.a(sb.toString().getBytes(), false);
    }

    public static String getAppSignatureSha1(Context context2, String str) {
        try {
            PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null)) {
                return Crypto.sha1(packageInfo.signatures[0].toByteArray());
            }
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return "";
    }

    public static String getNonce(Context context2, String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(PhoneUtils.getCUID2(context2));
        sb.append(System.currentTimeMillis());
        sb.append(UUID.randomUUID());
        map.put(KEY_REQID, sb.toString());
        map.put(SP_PARAMETER, PassBioDataEncryptor.encryptParams(str));
        map.put(SING_SHA1, getAppSignatureSha1(context2, context2.getPackageName()));
        ArrayList arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            arrayList.add(new RestNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return PassBioDataEncryptor.encryptParams(HttpUtils.getNonce(context2, arrayList));
    }

    public void cancelRequest() {
        PassHttpClient passHttpClient2 = this.passHttpClient;
        if (passHttpClient2 != null) {
            passHttpClient2.cancelRequests(true);
        }
    }

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, list, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.get(this.context, buildParamDTO(str, httpHashMap, list, i2), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
            public void onFailure(Throwable th, String str) {
                httpHandlerWrap.onFailure(th, -1, str);
            }

            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            public void onStart() {
                httpHandlerWrap.onStart();
            }

            public void onSuccess(int i2, String str) {
                httpHandlerWrap.onSuccess(i2, str);
            }
        });
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, final HttpHandlerWrap httpHandlerWrap) {
        this.passHttpClient.post(this.context, buildParamDTO(str, httpHashMap, list, i2), new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
            public void onFailure(Throwable th, String str) {
                httpHandlerWrap.onFailure(th, -1, str);
            }

            public void onFinish() {
                httpHandlerWrap.onFinish();
            }

            public void onStart() {
                httpHandlerWrap.onStart();
            }

            public void onSuccess(int i2, String str) {
                httpHandlerWrap.onSuccess(i2, str);
            }
        });
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, int i2, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        PassHttpClient passHttpClient2 = this.passHttpClient;
        Context context2 = this.context;
        PassHttpParamDTO buildParamDTO = buildParamDTO(str, httpHashMap, list, i2);
        final BinaryHttpHandlerWrap binaryHttpHandlerWrap2 = binaryHttpHandlerWrap;
        AnonymousClass2 r2 = new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) {
            public void onFailure(Throwable th, String str) {
                binaryHttpHandlerWrap2.onFailure(th, -1, str);
            }

            public void onFinish() {
                binaryHttpHandlerWrap2.onFinish();
            }

            public void onStart() {
                binaryHttpHandlerWrap2.onStart();
            }

            public void onSuccess(int i2, byte[] bArr) {
                binaryHttpHandlerWrap2.onSuccess(i2, bArr);
            }
        };
        passHttpClient2.get(context2, buildParamDTO, r2);
    }
}
