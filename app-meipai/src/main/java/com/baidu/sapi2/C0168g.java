package com.baidu.sapi2;

import com.baidu.sapi2.share.m.a;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;

/* renamed from: com.baidu.sapi2.g reason: case insensitive filesystem */
/* compiled from: PassportSDK */
public class C0168g extends a {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ PassportSDK f2738a;

    public C0168g(PassportSDK passportSDK) {
        this.f2738a = passportSDK;
    }

    public void onFailed(int i2, String str) {
        super.onFailed(i2, str);
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(i2);
        webAuthResult.setResultMsg(str);
        if (this.f2738a.f2167d != null) {
            this.f2738a.f2167d.onFailure(webAuthResult);
        }
        PassportSDK.getInstance().release();
    }

    public void onSuccess() {
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.accountType = AccountType.NORMAL;
        webAuthResult.setResultCode(0);
        if (this.f2738a.f2167d != null) {
            this.f2738a.f2167d.onSuccess(webAuthResult);
        }
        PassportSDK.getInstance().release();
    }
}
