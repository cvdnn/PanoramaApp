package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.SapiAccount.DispersionCertification;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class G extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ FillUsernameCallback f2131a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ FillUsernameResult f2132b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ SapiDataEncryptor f2133c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ L f2134d;

    public G(L l, Looper looper, FillUsernameCallback fillUsernameCallback, FillUsernameResult fillUsernameResult, SapiDataEncryptor sapiDataEncryptor) {
        this.f2134d = l;
        this.f2131a = fillUsernameCallback;
        this.f2132b = fillUsernameResult;
        this.f2133c = sapiDataEncryptor;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2132b.setResultCode(i2);
        this.f2131a.onFailure(this.f2132b);
    }

    public void onFinish() {
        this.f2131a.onFinish();
    }

    public void onStart() {
        this.f2131a.onStart();
    }

    public void onSuccess(int i2, String str) {
        int b2 = this.f2134d.b(str);
        this.f2132b.setResultCode(b2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2132b.setResultMsg(jSONObject.optString("errmsg"));
            JSONObject jSONObject2 = new JSONObject(this.f2133c.decrypt(jSONObject.optString("userinfo")));
            if (b2 == 0 || b2 == 110000) {
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.bduss = jSONObject2.optString("bduss");
                sapiAccount.ptoken = jSONObject2.optString(SapiAccount.f2187g);
                sapiAccount.stoken = jSONObject2.optString(SapiAccount.f2188h);
                sapiAccount.displayname = jSONObject2.optString("displayname");
                sapiAccount.username = jSONObject2.optString("uname");
                sapiAccount.uid = jSONObject2.optString("uid");
                sapiAccount.app = SapiUtils.getAppName(this.f2134d.f2155d.context);
                sapiAccount.addDispersionCertification(DispersionCertification.fromJSONObject(jSONObject2).tplStokenMap);
                sapiAccount.putExtra("tpl", this.f2134d.f2155d.tpl);
                SapiShareClient.getInstance().validate(sapiAccount);
                this.f2132b.session = sapiAccount;
                this.f2131a.onSuccess(this.f2132b);
                new b().a(b.f3029f);
            } else if (b2 == 160103) {
                this.f2131a.onBdussExpired(this.f2132b);
            } else if (b2 != 160104) {
                this.f2131a.onFailure(this.f2132b);
            } else {
                this.f2131a.onUserHaveUsername(this.f2132b);
            }
        } catch (Throwable th) {
            this.f2131a.onFailure(this.f2132b);
            Log.e(th);
        }
    }
}
