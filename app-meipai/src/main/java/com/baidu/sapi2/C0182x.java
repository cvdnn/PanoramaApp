package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.x reason: case insensitive filesystem */
/* compiled from: SapiAccountRepository */
public class C0182x extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallback f3251a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ SapiResult f3252b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f3253c;

    public C0182x(L l, Looper looper, SapiCallback sapiCallback, SapiResult sapiResult) {
        this.f3253c = l;
        this.f3251a = sapiCallback;
        this.f3252b = sapiResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f3252b.setResultCode(i2);
        this.f3252b.setResultMsg(str);
        this.f3251a.onFailure(this.f3252b);
    }

    public void onFinish() {
        this.f3251a.onFinish();
    }

    public void onStart() {
        this.f3251a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3252b.setResultCode(jSONObject.optInt("errno"));
            this.f3252b.setResultMsg(jSONObject.optString("errmsg"));
        } catch (JSONException e2) {
            Log.e(e2);
        }
        if (this.f3252b.getResultCode() == 0) {
            this.f3251a.onSuccess(this.f3252b);
        } else {
            this.f3251a.onFailure(this.f3252b);
        }
    }
}
