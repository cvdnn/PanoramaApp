package com.baidu.sapi2.views;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.sapi2.views.SmsLoginView.c;
import e.c.c.a.g;

/* compiled from: SmsLoginView */
public class k extends CountDownTimer {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ c f3220a;

    public k(c cVar, long j2, long j3) {
        this.f3220a = cVar;
        super(j2, j3);
    }

    public void onFinish() {
        if (SmsLoginView.this.f3170h.getText().toString().length() == 11) {
            SmsLoginView.this.f3172j.setEnabled(true);
            SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_re_get_check_code);
            SmsLoginView.this.a(true);
            return;
        }
        SmsLoginView.this.f3172j.setText(g.sapi_sdk_sms_get_check_code);
        SmsLoginView.this.a(false);
    }

    public void onTick(long j2) {
        TextView a2 = SmsLoginView.this.f3172j;
        StringBuilder sb = new StringBuilder();
        sb.append(j2 / 1000);
        sb.append(SmsLoginView.this.f3167e.getString(g.sapi_sdk_sms_second));
        a2.setText(sb.toString());
        SmsLoginView.this.f3172j.setEnabled(false);
        SmsLoginView.this.a(false);
    }
}
