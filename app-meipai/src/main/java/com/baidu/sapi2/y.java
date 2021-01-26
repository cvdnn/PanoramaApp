package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class y extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginResult f3254a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f3255b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ OneKeyLoginCallback f3256c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ L f3257d;

    public y(L l, Looper looper, OneKeyLoginResult oneKeyLoginResult, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        this.f3257d = l;
        this.f3254a = oneKeyLoginResult;
        this.f3255b = str;
        this.f3256c = oneKeyLoginCallback;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        String a2 = L.f2152a;
        StringBuilder sb = new StringBuilder();
        sb.append("onFailure, error = ");
        sb.append(th);
        sb.append(", errorCode = ");
        sb.append(i2);
        sb.append(", responseBody = ");
        sb.append(str);
        Log.d(a2, sb.toString());
        new c().b(this.f3256c, i2, null);
    }

    public void onSuccess(int i2, String str) {
        String a2 = L.f2152a;
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        sb.append("onSuccess, statusCode = ");
        sb.append(i2);
        sb.append(", response = ");
        sb.append(str);
        Log.d(a2, sb.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno");
            String optString = jSONObject.optString("errmsg");
            if (optInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA);
                if (optJSONObject != null) {
                    this.f3254a.enable = optJSONObject.optInt(SdkConfigOptions.KEY_SO_ENABLE, -1) == 1;
                    OneKeyLoginResult oneKeyLoginResult = this.f3254a;
                    if (optJSONObject.optInt("hasHistory", -1) != 1) {
                        z = false;
                    }
                    oneKeyLoginResult.hasHistory = z;
                    this.f3254a.encryptPhoneNum = this.f3255b;
                    this.f3254a.sign = optJSONObject.optString("sign");
                    this.f3254a.operator = new c().c();
                    String optString2 = optJSONObject.optString("js");
                    String optString3 = optJSONObject.optString("md5");
                    String optString4 = optJSONObject.optString("url");
                    String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
                    if (optString3 == null || !optString3.equals(onekeyLoginJsMd5)) {
                        this.f3257d.a(this.f3256c, optString4, optString3, optString2, this.f3254a);
                    } else {
                        OneKeyLoginResult.secondJsCode = optString2;
                        this.f3256c.available(this.f3254a);
                    }
                    return;
                }
            }
            new c().b(this.f3256c, optInt, optString);
        } catch (Exception e2) {
            Log.e(e2);
            new c().b(this.f3256c, -100, null);
        }
    }
}
