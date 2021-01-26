package com.baidu.sapi2.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FingerprintDialog */
public class d implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OnClickListener f3203a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f3204b;

    public d(f fVar, OnClickListener onClickListener) {
        this.f3204b = fVar;
        this.f3203a = onClickListener;
    }

    public void onClick(View view) {
        try {
            ViewUtility.dismissDialog((Activity) this.f3204b.f3215i, this.f3204b);
            this.f3203a.onClick(view);
        } catch (Exception unused) {
        }
    }
}
