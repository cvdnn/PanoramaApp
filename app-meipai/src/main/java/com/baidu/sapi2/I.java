package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.OAuthResult;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class I extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallback f2142a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ OAuthResult f2143b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2144c;

    public I(L l, Looper looper, SapiCallback sapiCallback, OAuthResult oAuthResult) {
        this.f2144c = l;
        this.f2142a = sapiCallback;
        this.f2143b = oAuthResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2143b.setResultCode(i2);
        this.f2142a.onFailure(this.f2143b);
    }

    public void onFinish() {
        this.f2142a.onFinish();
    }

    public void onStart() {
        this.f2142a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.f2143b.setResultCode(parseInt);
            if (parseInt != 0) {
                this.f2142a.onFailure(this.f2143b);
                return;
            }
            this.f2143b.accessToken = jSONObject.optString("access_token");
            this.f2143b.expiresIn = jSONObject.optInt("expires_in");
            this.f2143b.scope = jSONObject.optString("scope");
            this.f2143b.refreshToken = jSONObject.optString("refresh_token");
            this.f2143b.sessionKey = jSONObject.optString("session_key");
            this.f2143b.sessionSecret = jSONObject.optString("session_secret");
            this.f2143b.extra = str;
            this.f2143b.openid = jSONObject.optString("openid");
            this.f2142a.onSuccess(this.f2143b);
        } catch (Throwable unused) {
            this.f2143b.setResultCode(-202);
            this.f2142a.onFailure(this.f2143b);
        }
    }
}
