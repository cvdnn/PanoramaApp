package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.GetUserInfoResult;
import org.json.JSONObject;

/* compiled from: SapiAccountRepository */
public class F extends HttpHandlerWrap {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ GetUserInfoCallback f2128a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ GetUserInfoResult f2129b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ L f2130c;

    public F(L l, Looper looper, GetUserInfoCallback getUserInfoCallback, GetUserInfoResult getUserInfoResult) {
        this.f2130c = l;
        this.f2128a = getUserInfoCallback;
        this.f2129b = getUserInfoResult;
        super(looper);
    }

    public void onFailure(Throwable th, int i2, String str) {
        this.f2129b.setResultCode(i2);
        this.f2128a.onFailure(this.f2129b);
    }

    public void onFinish() {
        this.f2128a.onFinish();
    }

    public void onStart() {
        this.f2128a.onStart();
    }

    public void onSuccess(int i2, String str) {
        String str2 = "1";
        int b2 = this.f2130c.b(str);
        this.f2129b.setResultCode(b2);
        if (b2 == 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f2129b.portraitSign = jSONObject.optString("portrait_tag");
                this.f2129b.isInitialPortrait = "0".equals(this.f2129b.portraitSign);
                String optString = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                if (!TextUtils.isEmpty(optString)) {
                    this.f2129b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString, this.f2129b.portraitSign});
                    this.f2129b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{optString, this.f2129b.portraitSign});
                }
                this.f2129b.username = jSONObject.optString("username");
                this.f2129b.uid = jSONObject.optString("userid");
                this.f2129b.displayname = jSONObject.optString("displayname");
                this.f2129b.incompleteUser = str2.equals(jSONObject.optString("incomplete_user"));
                this.f2129b.secureMobile = jSONObject.optString("securemobil");
                this.f2129b.secureEmail = jSONObject.optString("secureemail");
                this.f2129b.havePwd = str2.equals(jSONObject.optString("have_psw"));
                this.f2129b.carSdkFace = jSONObject.optInt("carSdkFace");
                this.f2129b.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                this.f2128a.onSuccess(this.f2129b);
            } catch (Exception unused) {
                this.f2128a.onFailure(this.f2129b);
            }
        } else if (b2 != 400021) {
            this.f2128a.onFailure(this.f2129b);
        } else {
            this.f2128a.onBdussExpired(this.f2129b);
        }
    }
}
