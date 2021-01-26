package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount.DispersionCertification;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.a.b;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetTplStokenResult.FailureType;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.h;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import e.a.a.a.a;
import e.c.b.e.Utils;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public final class L {

    /* renamed from: a reason: collision with root package name */
    public static final String f2152a = "L";

    /* renamed from: b reason: collision with root package name */
    public static final int f2153b = 6;

    /* renamed from: c reason: collision with root package name */
    public static final String f2154c = "3";

    /* renamed from: d reason: collision with root package name */
    public SapiConfiguration f2155d = SapiAccountManager.getInstance().getSapiConfiguration();

    private Domain v() {
        return this.f2155d.environment;
    }

    private String w() {
        return "/sslcrypt/get_last_cert";
    }

    /* access modifiers changed from: private */
    public String x() {
        StringBuilder a2 = a.a("tpl:");
        a2.append(this.f2155d.tpl);
        a2.append(";android_sapi_v");
        a2.append(SapiAccountManager.VERSION_NAME);
        return a2.toString();
    }

    public void b() {
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("accesstoken", str);
            new HttpClientWrap().post(h.z, httpHashMapWrap, null, x(), new SapiAccountRepository(this, Looper.getMainLooper()));
        }
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/v4/security");
        return sb.toString();
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/wp/v3/ucenter/realnameverify");
        return sb.toString();
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/v6/shippingAddress");
        return sb.toString();
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getURL());
        sb.append(h.f3082g);
        return sb.toString();
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getURL());
        sb.append(h.f3083h);
        return sb.toString();
    }

    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getURL());
        sb.append("/phoenix/account/ssologin");
        return sb.toString();
    }

    public String j() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getURL());
        sb.append("/phoenix/account/ssologin");
        return sb.toString();
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/v6/invoiceManage");
        return sb.toString();
    }

    public String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append(h.L);
        return sb.toString();
    }

    public String m() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getURL());
        sb.append(h.B);
        return sb.toString();
    }

    public String n() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append(h.K);
        return sb.toString();
    }

    public String o() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append(h.M);
        return sb.toString();
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/wp/unitewidget");
        return sb.toString();
    }

    public String q() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/passport/getpass");
        return sb.toString();
    }

    public String r() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/passport/login");
        return sb.toString();
    }

    public String s() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/wp/wappassword");
        return sb.toString();
    }

    public String t() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/wp/recordindex");
        return sb.toString();
    }

    public String u() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/v3/login/api/login");
        return sb.toString();
    }

    public void b(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(sapiCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        OAuthResult oAuthResult = new OAuthResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(h.u, httpHashMapWrap, null, x(), new I(this, Looper.getMainLooper(), sapiCallback, oAuthResult));
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append("/wp/v3/ucenter/index");
        return sb.toString();
    }

    public void a(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Web2NativeLoginCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(web2NativeLoginCallback, sb.toString());
        Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        String cookieBduss = SapiUtils.getCookieBduss();
        String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String str2 = "";
        if (currentAccount != null) {
            str2 = currentAccount.bduss;
            str = currentAccount.ptoken;
        } else {
            str = str2;
        }
        if (!cookieBduss.equals(str2) || TextUtils.isEmpty(cookiePtoken) || !cookiePtoken.equals(str)) {
            if (!SapiAccountManager.getInstance().isLogin() || z) {
                C c2 = new C(this, web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken);
                a((GetUserInfoCallback) c2, cookieBduss);
            } else {
                SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
                if (!cookieBduss.equals(currentAccount2.bduss)) {
                    SapiAccountManager.getInstance().getAccountService().webLogin(this.f2155d.context, currentAccount2.bduss);
                }
                web2NativeLoginResult.setResultCode(0);
                web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
            }
            return;
        }
        web2NativeLoginResult.setResultCode(0);
        web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
    }

    public void b(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
                return;
            }
            SapiResponse sapiResponse = new SapiResponse();
            sapiResponse.errorCode = parseInt;
            sapiResponse.errorMsg = "短信验证码发送成功";
            sapiCallBack.onSuccess(sapiResponse);
        } catch (Exception unused) {
            sapiCallBack.onSystemError(-100);
        }
    }

    public int b(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            Log.e(e2);
            return -100;
        }
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        SapiConfiguration sapiConfiguration = this.f2155d;
        if (sapiConfiguration == null || sapiConfiguration.context == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiCallBack.class.getSimpleName());
        sb.append(" can't be null");
        SapiCallBack<SapiAccountResponse> sapiCallBack2 = sapiCallBack;
        SapiUtils.notNull(sapiCallBack2, sb.toString());
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        String w = w();
        String x = x();
        D d2 = new D(this, Looper.getMainLooper(), sapiCallBack2, z, sapiDataEncryptor, str, str2);
        httpClientWrap.get(w, null, null, x, d2);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", Constants.VIA_SHARE_TYPE_INFO);
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(h.f3076a);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        String str5 = "1";
        httpHashMapWrap.put("isdpass", str5);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", str5);
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, "2");
        jSONObject.put("pinfo", SapiDeviceUtils.b());
        httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        String x = x();
        E e2 = new E(this, Looper.getMainLooper(), sapiCallBack, z, sapiDataEncryptor);
        httpClientWrap.post(h.f3076a, httpHashMapWrap, null, x, e2);
    }

    public void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                    sapiAccountResponse.displayname = jSONObject.optString("displayname");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString(SapiAccount.f2184d);
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccount.f2187g);
                    sapiAccountResponse.stoken = jSONObject.optString(SapiAccount.f2188h);
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack == null) {
                    return;
                }
                if (i2 != 0) {
                    sapiCallBack.onSystemError(i2);
                    return;
                }
                if (z) {
                    SapiAccount a2 = a(sapiAccountResponse);
                    a2.addDispersionCertification(DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                    a2.putExtra("tpl", this.f2155d.tpl);
                    SapiShareClient.getInstance().validate(a2);
                }
                sapiCallBack.onSuccess(sapiAccountResponse);
            } catch (Exception e2) {
                Log.e(e2);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    public void a(GetUserInfoCallback getUserInfoCallback, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(GetUserInfoCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(getUserInfoCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            httpHashMapWrap.put(SapiAccount.f2187g, accountFromBduss.ptoken);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(h.f3077b);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        new HttpClientWrap().post(h.f3077b, httpHashMapWrap, null, x(), new F(this, Looper.getMainLooper(), getUserInfoCallback, getUserInfoResult));
    }

    public void a(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(FillUsernameCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(fillUsernameCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiUtils.notEmpty(str2, "username can't be empty");
        FillUsernameResult fillUsernameResult = new FillUsernameResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("cert_id", String.valueOf(1));
        httpHashMapWrap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            if (!TextUtils.isEmpty(this.f2155d.clientId)) {
                jSONObject.put("clientid", this.f2155d.clientId);
            }
            if (!TextUtils.isEmpty(this.f2155d.clientIp)) {
                jSONObject.put("clientip", this.f2155d.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(SapiDataEncryptor.a.f3007b, jSONObject.toString()));
            HttpClientWrap httpClientWrap = new HttpClientWrap();
            String str3 = h.n;
            String x = x();
            G g2 = new G(this, Looper.getMainLooper(), fillUsernameCallback, fillUsernameResult, sapiDataEncryptor);
            httpClientWrap.post(str3, httpHashMapWrap, null, x, g2);
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    public boolean a(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return a(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
    }

    public boolean a(SapiAccount sapiAccount, List<String> list) {
        boolean z = false;
        if (sapiAccount != null && !TextUtils.isEmpty(sapiAccount.extra)) {
            try {
                DispersionCertification fromJSONObject = DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!fromJSONObject.tplStokenMap.containsKey((String) it.next())) {
                        break;
                    }
                }
                return z;
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        return false;
    }

    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        GetTplStokenCallback getTplStokenCallback2 = getTplStokenCallback;
        String str2 = str;
        List<String> list2 = list;
        StringBuilder sb = new StringBuilder();
        sb.append(GetTplStokenCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(getTplStokenCallback2, sb.toString());
        GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list2 == null || list.isEmpty()) {
            getTplStokenResult.setResultCode(-302);
            getTplStokenResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            getTplStokenCallback2.onFailure(getTplStokenResult);
            return getTplStokenResult.tplStokenMap;
        }
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str2);
        if (accountFromBduss == null) {
            getTplStokenResult.setResultCode(-301);
            getTplStokenCallback2.onFailure(getTplStokenResult);
            return getTplStokenResult.tplStokenMap;
        }
        String str3 = accountFromBduss.ptoken;
        if (a(str2, list2)) {
            try {
                DispersionCertification fromJSONObject = DispersionCertification.fromJSONObject(new JSONObject(accountFromBduss.extra));
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str4 = (String) it.next();
                    if (!fromJSONObject.tplStokenMap.containsKey(str4)) {
                        getTplStokenResult.tplStokenMap.clear();
                        break;
                    }
                    getTplStokenResult.tplStokenMap.put(str4, fromJSONObject.tplStokenMap.get(str4));
                }
                if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                    getTplStokenResult.setResultCode(0);
                    getTplStokenResult.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
                    getTplStokenCallback2.onSuccess(getTplStokenResult);
                    return getTplStokenResult.tplStokenMap;
                }
            } catch (JSONException e2) {
                Log.e(e2);
                getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL);
                getTplStokenCallback2.onFailure(getTplStokenResult);
                return getTplStokenResult.tplStokenMap;
            }
        }
        String str5 = (String) list2.get(0);
        for (int i2 = 1; i2 < list.size(); i2++) {
            StringBuilder b2 = a.b(str5, "|");
            b2.append((String) list2.get(i2));
            str5 = b2.toString();
        }
        if (TextUtils.isEmpty(str3)) {
            getTplStokenResult.setResultCode(-305);
            getTplStokenResult.failureType = FailureType.PTOKEN_EMPTY;
            getTplStokenCallback2.onFailure(getTplStokenResult);
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2155d.appId);
        sb2.append(this.f2155d.tpl);
        sb2.append(str2);
        sb2.append(this.f2155d.appSignKey);
        httpHashMapWrap.put("sign", Utils.a(sb2.toString().getBytes(), false));
        httpHashMapWrap.put("return_type", "1");
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put(SapiAccount.f2187g, str3);
        }
        httpHashMapWrap.put("tpl_list", str5);
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        String x = x();
        H h2 = new H(this, Looper.getMainLooper(), getTplStokenCallback, getTplStokenResult, accountFromBduss, list, z, str3);
        httpClientWrap.post(h.v, httpHashMapWrap, null, x, h2);
        return getTplStokenResult.tplStokenMap;
    }

    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        SapiConfiguration sapiConfiguration = this.f2155d;
        if (sapiConfiguration != null) {
            Context context = sapiConfiguration.context;
            if (context != null) {
                if (!SapiUtils.hasActiveNetwork(context)) {
                    if (sapiCallBack != null) {
                        sapiCallBack.onNetworkFailed();
                    }
                    return false;
                } else if (TextUtils.isEmpty(str)) {
                    if (sapiCallBack != null) {
                        sapiCallBack.onSystemError(SapiErrorCode.PHONE_NULL);
                    }
                    return false;
                } else {
                    HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                    httpHashMapWrap.put("username", str);
                    new HttpClientWrap().post(h.o, httpHashMapWrap, null, x(), new J(this, Looper.getMainLooper(), sapiCallBack));
                    return true;
                }
            }
        }
        return false;
    }

    public HttpHashMapWrap a(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, "3");
        return httpHashMapWrap;
    }

    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback != null) {
            iqiyiLoginCallback.onStart();
            String str = iqiyiLoginDTO.accessToken;
            String str2 = iqiyiLoginDTO.phoneNum;
            String str3 = iqiyiLoginDTO.openID;
            IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            boolean z = !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3);
            if (!z && currentAccount == null) {
                iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            } else if (!z || currentAccount != null) {
                SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
                K k = new K(this, iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2);
                accountService.getUserInfo(k, currentAccount.bduss);
            } else {
                a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult) {
        if (TextUtils.isEmpty(iqiyiLoginDTO.accessToken) || TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            return;
        }
        HttpHashMapWrap a2 = a(j());
        if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
            a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
        }
        a2.put("access_token", iqiyiLoginDTO.accessToken);
        a2.put("osuid", iqiyiLoginDTO.openID);
        a2.put("json", "1");
        StringBuilder sb = new StringBuilder();
        sb.append(SocialType.IQIYI.getType());
        sb.append("");
        a2.put("type", sb.toString());
        a2.put(SocialConstants.PARAM_ACT, "special");
        a2.put("display", SapiAccountService.f2213b);
        new HttpClientWrap().get(j(), a2, null, x(), new r(this, Looper.getMainLooper(), iqiyiLoginCallback, iqiyiLoginResult));
    }

    public void a(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(sapiCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(h.C);
        a2.put("clientfrom", SapiAccountService.f2213b);
        a2.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            a2.putAll(map);
        }
        CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(h.C, a2, null, x(), new C0178t(this, Looper.getMainLooper(), sapiCallback, checkUserFaceIdResult));
    }

    public void a(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                str = currentAccount.bduss;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(sapiCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(h.E);
        a2.put("clientfrom", SapiAccountService.f2213b);
        a2.put("bduss", str);
        FaceLoginStatusResult faceLoginStatusResult = new FaceLoginStatusResult();
        new HttpClientWrap().post(h.E, a2, null, x(), new C0179u(this, Looper.getMainLooper(), sapiCallback, faceLoginStatusResult));
    }

    public void a(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                str = currentAccount.bduss;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiCallback.class.getSimpleName());
        sb.append(" can't be null");
        SapiUtils.notNull(sapiCallback, sb.toString());
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(h.E);
        String str3 = "action";
        if (z) {
            a2.put(str3, "enable_face_login");
        } else {
            a2.put(str3, "disable_face_login");
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("callbackKey", str2);
        }
        a2.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
        a2.put("clientfrom", SapiAccountService.f2213b);
        a2.put("bduss", str);
        CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        String x = x();
        C0180v vVar = new C0180v(this, Looper.getMainLooper(), sapiCallback, checkUserFaceIdResult, z);
        httpClientWrap.post(h.D, a2, null, x, vVar);
    }

    @SuppressLint({"NewApi"})
    public void a(SsoHashCallback ssoHashCallback, String str, String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new C0181w(this, str, str2, ssoHashCallback).execute(new String[]{h.F});
    }

    public void a(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        httpHashMapWrap.put(LogBuilder.KEY_TIME, sb.toString());
        SapiResult sapiResult = new SapiResult();
        new HttpClientWrap().post(h.G, httpHashMapWrap, null, x(), new C0182x(this, Looper.getMainLooper(), sapiCallback, sapiResult));
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("ability", "onekeylogin");
        httpHashMapWrap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "api");
        httpHashMapWrap.put("clientfrom", SapiAccountService.f2213b);
        httpHashMapWrap.put(AddressManageResult.KEY_MOBILE, str);
        SapiConfiguration sapiConfiguration = this.f2155d;
        List a2 = a(sapiConfiguration.context, sapiConfiguration);
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        String n = n();
        String x = x();
        y yVar = new y(this, Looper.getMainLooper(), oneKeyLoginResult, str, oneKeyLoginCallback);
        httpClientWrap.get(n, httpHashMapWrap, a2, x, yVar);
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, b bVar) {
        String str3;
        String str4 = "appid";
        JSONObject jSONObject = new JSONObject();
        try {
            String c2 = new c().c();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.f2155d.tpl);
            jSONObject.put("client", SapiDeviceInfo.f3010c);
            jSONObject.put("clientfrom", SapiAccountService.f2213b);
            jSONObject.put(str4, this.f2155d.appId);
            jSONObject.put("operator", c2);
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "api");
            jSONObject.put("sign", str2);
            if (c.f2818e.equals(c2)) {
                str3 = this.f2155d.chinaMobileAppID;
            } else if (c.f2820g.equals(c2)) {
                str3 = this.f2155d.chinaTelecomAppKey;
            } else {
                str3 = this.f2155d.context.getPackageName();
                jSONObject.put("CUVersion", "2");
            }
            jSONObject.put(str4, str3);
        } catch (JSONException e2) {
            Log.e(e2);
        }
        g.a(SapiContext.getInstance().getOneKeyLoginJsCode(), OneKeyLoginResult.secondJsCode, jSONObject.toString(), this.f2155d.context, new A(this, oneKeyLoginCallback, bVar));
    }

    /* access modifiers changed from: private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, String str3, OneKeyLoginResult oneKeyLoginResult) {
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        B b2 = new B(this, Looper.getMainLooper(), str2, oneKeyLoginCallback, str3, oneKeyLoginResult);
        httpClientWrap.get(str, (HttpHandlerWrap) b2);
    }

    /* access modifiers changed from: private */
    public List<HttpCookie> a(Context context, SapiConfiguration sapiConfiguration) {
        ArrayList arrayList = new ArrayList();
        String deviceInfo = SapiContext.getInstance().getDeviceInfo();
        String str = "HISTORY";
        String cookie = SapiUtils.getCookie(sapiConfiguration.environment.getWap(), str);
        String str2 = "BAIDUID";
        String str3 = "https://baidu.com";
        String cookie2 = SapiUtils.getCookie(str3, str2);
        HttpCookie httpCookie = new HttpCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context));
        String str4 = "";
        if (deviceInfo == null) {
            deviceInfo = str4;
        }
        HttpCookie httpCookie2 = new HttpCookie("DVIF", deviceInfo);
        HttpCookie httpCookie3 = new HttpCookie(str, cookie);
        HttpCookie httpCookie4 = new HttpCookie(str2, cookie2);
        String str5 = "http://";
        String str6 = "https://";
        String str7 = "(:[0-9]{1,4})?";
        String replaceAll = sapiConfiguration.environment.getURL().replace(str5, str4).replace(str6, str4).replaceAll(str7, str4);
        String replaceAll2 = sapiConfiguration.environment.getWap().replace(str5, str4).replace(str6, str4).replaceAll(str7, str4);
        httpCookie.setDomain(replaceAll);
        String str8 = BceConfig.BOS_DELIMITER;
        httpCookie.setPath(str8);
        httpCookie2.setDomain(replaceAll2);
        httpCookie2.setPath(str8);
        httpCookie3.setDomain(replaceAll2);
        httpCookie3.setPath(str8);
        httpCookie4.setDomain(str3);
        httpCookie4.setPath(str8);
        arrayList.add(httpCookie);
        arrayList.add(httpCookie2);
        arrayList.add(httpCookie3);
        arrayList.add(httpCookie4);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("HISTORY");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.f2155d.environment.getWap(), str));
        SapiUtils.syncCookies(this.f2155d.context, arrayList);
    }

    public SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString(SapiAccount.f2188h);
        sapiAccount.ptoken = jSONObject.optString(SapiAccount.f2187g);
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.f2155d.context);
        return sapiAccount;
    }

    public SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.f2155d.context);
        return sapiAccount;
    }

    public String a(BindWidgetAction bindWidgetAction) {
        StringBuilder sb = new StringBuilder();
        sb.append(v().getWap());
        sb.append(bindWidgetAction.getUri());
        return sb.toString();
    }
}
