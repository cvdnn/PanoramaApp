package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;

/* compiled from: SapiAccountRepository */
public class K extends GetUserInfoCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ IqiyiLoginCallback f2147a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ IqiyiLoginDTO f2148b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ IqiyiLoginResult f2149c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ String f2150d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ L f2151e;

    public K(L l, IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult, String str) {
        this.f2151e = l;
        this.f2147a = iqiyiLoginCallback;
        this.f2148b = iqiyiLoginDTO;
        this.f2149c = iqiyiLoginResult;
        this.f2150d = str;
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
        this.f2151e.a(this.f2147a, this.f2148b, this.f2149c);
    }

    public void onFailure(GetUserInfoResult getUserInfoResult) {
        this.f2149c.setResultCode(getUserInfoResult.getResultCode());
        this.f2149c.setResultMsg(getUserInfoResult.getResultMsg());
        this.f2147a.onFailure(this.f2149c);
    }

    public void onSuccess(GetUserInfoResult getUserInfoResult) {
        String str = getUserInfoResult.secureMobile;
        boolean z = getUserInfoResult.incompleteUser;
        if (!TextUtils.isEmpty(str)) {
            this.f2147a.onSuccess(this.f2149c);
        } else if (z) {
            this.f2151e.a(this.f2147a, this.f2148b, this.f2149c);
        } else if (TextUtils.isEmpty(this.f2150d)) {
            this.f2147a.onSuccess(this.f2149c);
        } else {
            this.f2151e.a(this.f2147a, this.f2148b, this.f2149c);
        }
    }
}
