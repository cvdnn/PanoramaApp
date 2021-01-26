package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;

/* compiled from: SapiAccountRepository */
public class C extends GetUserInfoCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Web2NativeLoginResult f2113a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Web2NativeLoginCallback f2114b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ String f2115c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ String f2116d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ L f2117e;

    public C(L l, Web2NativeLoginResult web2NativeLoginResult, Web2NativeLoginCallback web2NativeLoginCallback, String str, String str2) {
        this.f2117e = l;
        this.f2113a = web2NativeLoginResult;
        this.f2114b = web2NativeLoginCallback;
        this.f2115c = str;
        this.f2116d = str2;
    }

    public void onFinish() {
        this.f2114b.onFinish();
    }

    public void onStart() {
        this.f2114b.onStart();
    }

    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        this.f2113a.setResultCode(400021);
        this.f2114b.onBdussExpired(this.f2113a);
    }

    public void onFailure(GetUserInfoResult getUserInfoResult) {
        this.f2113a.setResultCode(-202);
        this.f2114b.onFailure(this.f2113a);
    }

    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = getUserInfoResult.uid;
        sapiAccount.username = getUserInfoResult.username;
        sapiAccount.displayname = getUserInfoResult.displayname;
        sapiAccount.bduss = this.f2115c;
        if (!TextUtils.isEmpty(this.f2116d)) {
            sapiAccount.ptoken = this.f2116d;
        }
        sapiAccount.app = SapiUtils.getAppName(this.f2117e.f2155d.context);
        SapiShareClient.getInstance().validate(sapiAccount);
        this.f2113a.setResultCode(0);
        this.f2114b.onSuccess(this.f2113a);
        new b().a(b.f3030g);
    }
}
