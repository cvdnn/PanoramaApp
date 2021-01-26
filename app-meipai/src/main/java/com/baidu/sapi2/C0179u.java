package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.u reason: case insensitive filesystem */
/* compiled from: SapiAccountRepository */
public class C0179u extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallback f2994a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ FaceLoginStatusResult f2995b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2996c;

    public C0179u(L l, Looper looper, SapiCallback sapiCallback, FaceLoginStatusResult faceLoginStatusResult) {
        this.f2996c = l;
        this.f2994a = sapiCallback;
        this.f2995b = faceLoginStatusResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2995b.setResultCode(i2);
        this.f2994a.onFailure(this.f2995b);
    }

    public void onFinish() {
        this.f2994a.onFinish();
    }

    public void onStart() {
        this.f2994a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.f2995b.setResultCode(parseInt);
            this.f2995b.setResultMsg(jSONObject.optString("errmsg"));
            if (parseInt == 0) {
                this.f2995b.status = jSONObject.optInt("status");
                this.f2995b.livingUname = jSONObject.optString("livinguname");
                this.f2995b.authsid = jSONObject.optString("authsid");
                this.f2995b.authWidgetURL = jSONObject.optString("authurl");
                FaceLoginStatusResult faceLoginStatusResult = this.f2995b;
                boolean z = true;
                if (jSONObject.optInt("faceLoginEnabled") != 1) {
                    z = false;
                }
                faceLoginStatusResult.faceLoginSwitch = z;
                this.f2994a.onSuccess(this.f2995b);
                return;
            }
            this.f2994a.onFailure(this.f2995b);
        } catch (Throwable unused) {
            this.f2995b.setResultCode(-202);
            this.f2994a.onFailure(this.f2995b);
        }
    }
}
