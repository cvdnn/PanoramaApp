package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import e.a.a.a.a;
import org.json.JSONObject;

public abstract class AbstractService implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final String f2107a = "3";
    public SapiConfiguration configuration;
    public String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        this.configuration = sapiConfiguration;
        this.versionName = str;
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put("di", deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, "3");
        return httpHashMapWrap;
    }

    public void cancelRequest(HttpClientWrap httpClientWrap) {
        if (httpClientWrap != null) {
            httpClientWrap.cancelRequest();
        }
    }

    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            Log.e(e2);
            return -100;
        }
    }

    public String getErrorMsg(String str) {
        try {
            return new JSONObject(str).optString("errmsg");
        } catch (Exception e2) {
            Log.e(e2);
            return SapiResult.ERROR_MSG_UNKNOWN;
        }
    }

    public String getUaInfo() {
        StringBuilder a2 = a.a("tpl:");
        a2.append(this.configuration.tpl);
        a2.append(";android_sapi_v");
        a2.append(this.versionName);
        return a2.toString();
    }

    public SapiAccount parseAccount(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString(SapiAccount.f2188h);
        sapiAccount.ptoken = jSONObject.optString(SapiAccount.f2187g);
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }
}
