package com.baidu.picapture.nativeapi;

import android.webkit.JavascriptInterface;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import e.c.d.d.c.e;
import e.c.d.g.b;
import i.b.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class Account {
    public static /* synthetic */ void a(Account account, a aVar, GetUserInfoResult getUserInfoResult) {
        if (account != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uid", e.f6006d.a().uid);
                jSONObject.put("userName", e.f6006d.a().displayname);
                jSONObject.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, getUserInfoResult.portraitHttps);
                jSONObject.put("secureMobile", getUserInfoResult.secureMobile);
                jSONObject.put("secureEmail", getUserInfoResult.secureEmail);
                aVar.a(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
                aVar.a("");
            }
        } else {
            throw null;
        }
    }

    @JavascriptInterface
    public void accountInfo(final a aVar) {
        if (!e.f6006d.c()) {
            aVar.a("");
        } else {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    Account.a(Account.this, aVar, getUserInfoResult);
                }

                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    Account.a(Account.this, aVar, getUserInfoResult);
                }

                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    Account.a(Account.this, aVar, getUserInfoResult);
                }
            }, SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    @JavascriptInterface
    public void logOut() {
        c.b().a((Object) new b());
    }
}
