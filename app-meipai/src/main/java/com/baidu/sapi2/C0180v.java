package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.share.face.FaceLoginService;
import org.json.JSONObject;

/* renamed from: com.baidu.sapi2.v reason: case insensitive filesystem */
/* compiled from: SapiAccountRepository */
public class C0180v extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SapiCallback f3129a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ CheckUserFaceIdResult f3130b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ boolean f3131c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ L f3132d;

    public C0180v(L l, Looper looper, SapiCallback sapiCallback, CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
        this.f3132d = l;
        this.f3129a = sapiCallback;
        this.f3130b = checkUserFaceIdResult;
        this.f3131c = z;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f3130b.setResultCode(i2);
        this.f3129a.onFailure(this.f3130b);
    }

    public void onFinish() {
        this.f3129a.onFinish();
    }

    public void onStart() {
        this.f3129a.onStart();
    }

    public void onSuccess(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            this.f3130b.setResultCode(parseInt);
            this.f3130b.setResultMsg(jSONObject.optString("errmsg"));
            if (parseInt == 0) {
                if (this.f3131c) {
                    String optString = jSONObject.optString("livinguname");
                    if (!TextUtils.isEmpty(optString)) {
                        new FaceLoginService().syncFaceLoginUID(this.f3132d.f2155d.context, optString);
                    }
                }
                this.f3129a.onSuccess(this.f3130b);
                return;
            }
            this.f3129a.onFailure(this.f3130b);
        } catch (Throwable unused) {
            this.f3130b.setResultCode(-202);
            this.f3129a.onFailure(this.f3130b);
        }
    }
}
