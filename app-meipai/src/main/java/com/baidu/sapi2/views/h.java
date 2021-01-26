package com.baidu.sapi2.views;

import android.view.inputmethod.InputMethodManager;

/* compiled from: SmsLoginView */
public class h implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ SmsLoginView f3217a;

    public h(SmsLoginView smsLoginView) {
        this.f3217a = smsLoginView;
    }

    public void run() {
        this.f3217a.f3171i.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f3217a.f3167e.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f3217a.f3170h, 0);
        }
    }
}
