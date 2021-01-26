package com.baidu.sapi2.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomAlertDialog */
public class c implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OnClickListener f3201a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ CustomAlertDialog f3202b;

    public c(CustomAlertDialog customAlertDialog, OnClickListener onClickListener) {
        this.f3202b = customAlertDialog;
        this.f3201a = onClickListener;
    }

    public void onClick(View view) {
        try {
            ViewUtility.dismissDialog((Activity) this.f3202b.f3147e, this.f3202b);
        } catch (Exception unused) {
        }
        this.f3201a.onClick(view);
    }
}
