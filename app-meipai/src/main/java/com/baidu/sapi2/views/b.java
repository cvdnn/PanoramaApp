package com.baidu.sapi2.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomAlertDialog */
public class b implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OnClickListener f3199a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ CustomAlertDialog f3200b;

    public b(CustomAlertDialog customAlertDialog, OnClickListener onClickListener) {
        this.f3200b = customAlertDialog;
        this.f3199a = onClickListener;
    }

    public void onClick(View view) {
        try {
            ViewUtility.dismissDialog((Activity) this.f3200b.f3147e, this.f3200b);
        } catch (Exception unused) {
        }
        this.f3199a.onClick(view);
    }
}
