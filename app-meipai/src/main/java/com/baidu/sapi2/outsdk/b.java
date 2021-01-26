package com.baidu.sapi2.outsdk;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.c.a;
import com.baidu.sapi2.utils.Log;
import com.sdk.base.api.ToolUtils;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChinaUnicomSdkWrap */
public class b {

    /* renamed from: a reason: collision with root package name */
    public static final int f2811a = 15;

    /* renamed from: b reason: collision with root package name */
    public static final String f2812b = "baidu_passport_cu_onekey_login";

    /* renamed from: c reason: collision with root package name */
    public static String f2813c = "";

    private void b(SapiConfiguration sapiConfiguration, a aVar) {
        Log.i(c.f2814a, "in getAsynToken");
        ToolUtils.clearCache(sapiConfiguration.context);
        UiOauthManager.getInstance(sapiConfiguration.context).login(15, new ChinaUnicomSdkWrap$1(this, sapiConfiguration, aVar));
    }

    public void a(SapiConfiguration sapiConfiguration, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        Log.i(c.f2814a, "in china unicom login pre get phone info");
        SDKManager.init(sapiConfiguration.context, sapiConfiguration.chinaUnicomAppKey, sapiConfiguration.chinaUnicomAppPublicKey);
        SDKManager.closePermission(true);
        SDKManager.setUserAgent(f2812b);
        f2813c = str2;
        a(sapiConfiguration.context, str, str2, oneKeyLoginCallback);
    }

    public void a(SapiConfiguration sapiConfiguration, a aVar) {
        Log.i(c.f2814a, "in getToken");
        String str = "china_telecom_expired_time";
        if ((System.currentTimeMillis() / 1000) - SapiContext.getInstance().getLong(str, 0) < 3300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("appid", sapiConfiguration.context.getPackageName());
                jSONObject.put("token", c.s);
                jSONObject.put("code", 0);
                jSONObject.put("CUVersion", "2");
            } catch (JSONException e2) {
                Log.e(e2);
            }
            aVar.onGetTokenComplete(jSONObject);
            SapiContext.getInstance().put(str, 0);
            return;
        }
        b(sapiConfiguration, aVar);
    }

    private void a(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        ToolUtils.clearCache(context);
        UiOauthManager.getInstance(context).login(15, new ChinaUnicomSdkWrap$2(this, oneKeyLoginCallback, str, str2));
    }
}
