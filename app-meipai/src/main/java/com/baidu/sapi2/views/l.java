package com.baidu.sapi2.views;

import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.views.SmsLoginView.c;
import com.baidu.sapi2.views.SmsLoginView.f;
import e.c.c.a.g;

/* compiled from: SmsLoginView */
public class l extends GetDynamicPwdCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ c f3221a;

    public l(c cVar) {
        this.f3221a = cVar;
    }

    /* renamed from: a */
    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
        String str = "";
        if (SmsLoginView.this.q) {
            StringBuilder sb = new StringBuilder();
            sb.append(getDynamicPwdResult.getResultCode());
            sb.append(str);
            SmsLoginView.b(f.f3183f, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getDynamicPwdResult.getResultCode());
            sb2.append(str);
            SmsLoginView.b(f.f3186i, sb2.toString());
        }
        if (SmsLoginView.this.o != null) {
            SmsLoginView.this.o.cancel();
        }
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SmsLoginView.this.p = str;
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* renamed from: b */
    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
        String str = "";
        if (SmsLoginView.this.q) {
            StringBuilder sb = new StringBuilder();
            sb.append(getDynamicPwdResult.getResultCode());
            sb.append(str);
            SmsLoginView.b(f.f3183f, sb.toString());
            SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_get_check_code);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getDynamicPwdResult.getResultCode());
            sb2.append(str);
            SmsLoginView.b(f.f3186i, sb2.toString());
            SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_re_get_check_code);
        }
        if (SmsLoginView.this.o != null) {
            SmsLoginView.this.o.cancel();
        }
        SmsLoginView.this.f3172j.setEnabled(true);
        SmsLoginView.this.a(true);
        if (getDynamicPwdResult.noNeedBack) {
            SmsLoginView.this.k.setText(getDynamicPwdResult.getResultMsg());
            SmsLoginView.this.k.setVisibility(0);
            return;
        }
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SmsLoginView.this.p = str;
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* renamed from: c */
    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
        if (SmsLoginView.this.q) {
            SmsLoginView.b(f.f3182e, (String) null);
        } else {
            SmsLoginView.b(f.f3185h, (String) null);
        }
    }

    public void onFinish() {
    }

    public void onStart() {
    }
}
