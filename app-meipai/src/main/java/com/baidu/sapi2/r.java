package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class r extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ IqiyiLoginCallback f2848a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ IqiyiLoginResult f2849b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2850c;

    public r(L l, Looper looper, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginResult iqiyiLoginResult) {
        this.f2850c = l;
        this.f2848a = iqiyiLoginCallback;
        this.f2849b = iqiyiLoginResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2849b.setResultCode(i2);
        this.f2848a.onFailure(this.f2849b);
    }

    public void onFinish() {
        this.f2848a.onFinish();
    }

    public void onStart() {
    }

    public void onSuccess(int i2, String str) {
        if (this.f2850c.b(str) == 302) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f2849b.nextUrl = jSONObject.optString("next_url");
                this.f2848a.onBindWebview(this.f2849b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            SocialResponse b2 = SapiWebView.b(str, this.f2850c.f2155d.context);
            String str2 = Web2NativeLoginResult.ERROR_MSG_UNKNOWN;
            if (b2 == null) {
                this.f2849b.setResultCode(-100);
                this.f2849b.setResultMsg(str2);
                this.f2848a.onFailure(this.f2849b);
            } else if (b2.errorCode != -100) {
                this.f2849b.setResultCode(-100);
                this.f2849b.setResultMsg(str2);
                this.f2848a.onFailure(this.f2849b);
            } else {
                SapiAccount a2 = this.f2850c.a((SapiAccountResponse) b2);
                a2.addSocialInfo(b2.socialType, b2.socialPortraitUrl);
                a2.putExtra("account_type", Integer.valueOf(b2.accountType.getType()));
                a2.addDispersionCertification(b2.tplStokenMap);
                a2.addIsGuestAccount(b2.isGuestAccount);
                a2.putExtra("tpl", this.f2850c.f2155d.tpl);
                SapiShareClient.getInstance().validate(a2);
                this.f2848a.onSuccess(this.f2849b);
            }
        }
    }
}
