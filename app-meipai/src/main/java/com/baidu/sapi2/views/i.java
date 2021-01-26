package com.baidu.sapi2.views;

import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.SmsLoginView.f;

/* compiled from: SmsLoginView */
public class i extends DynamicPwdLoginCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SmsLoginView f3218a;

    public i(SmsLoginView smsLoginView) {
        this.f3218a = smsLoginView;
    }

    /* renamed from: a */
    public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(dynamicPwdLoginResult.getResultCode());
        String str = "";
        sb.append(str);
        SmsLoginView.b(f.l, sb.toString());
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
        webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
        if (dynamicPwdLoginResult.noNeedBack) {
            this.f3218a.k.setText(dynamicPwdLoginResult.getResultMsg());
            this.f3218a.k.setVisibility(0);
            this.f3218a.f3171i.setText(str);
            if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                PassportSDK.getInstance().getSmsViewLoginCallback().onFailure(webAuthResult);
                return;
            }
            return;
        }
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.f3218a.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            this.f3218a.p = str;
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* renamed from: b */
    public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
        SmsLoginView.b(f.k, (String) null);
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
        webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
        webAuthResult.accountType = AccountType.NORMAL;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, this.f3218a.p);
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
            PassportSDK.getInstance().getSmsViewLoginCallback().onSuccess(webAuthResult);
        }
        new b().a(b.f3025b);
    }

    public void onFinish() {
        this.f3218a.a();
    }

    public void onStart() {
        this.f3218a.b();
    }
}
