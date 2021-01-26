package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.t reason: case insensitive filesystem */
/* compiled from: SapiAccountRepository */
public class C0178t extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallback f2991a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ CheckUserFaceIdResult f2992b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2993c;

    public C0178t(L l, Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult) {
        this.f2993c = l;
        this.f2991a = sapiCallback;
        this.f2992b = checkUserFaceIdResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2992b.setResultCode(i2);
        this.f2991a.onFailure(this.f2992b);
    }

    public void onFinish() {
        this.f2991a.onFinish();
    }

    public void onStart() {
        this.f2991a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.f2992b.setResultCode(parseInt);
            this.f2992b.setResultMsg(jSONObject.optString("errmsg"));
            if (parseInt == 0) {
                this.f2992b.status = jSONObject.optInt("status");
                this.f2992b.livingUname = jSONObject.optString("livinguname");
                this.f2992b.authsid = jSONObject.optString("authsid");
                this.f2992b.authWidgetURL = jSONObject.optString("authurl");
                this.f2991a.onSuccess(this.f2992b);
                return;
            }
            this.f2991a.onFailure(this.f2992b);
        } catch (Throwable unused) {
            this.f2992b.setResultCode(-202);
            this.f2991a.onFailure(this.f2992b);
        }
    }
}
