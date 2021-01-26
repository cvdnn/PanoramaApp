package com.baidu.sapi2.views;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FingerprintDialog */
public class e implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ OnClickListener f3205a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f3206b;

    public e(f fVar, OnClickListener onClickListener) {
        this.f3206b = fVar;
        this.f3205a = onClickListener;
    }

    public void onClick(View view) {
        try {
            ViewUtility.dismissDialog((Activity) this.f3206b.f3215i, this.f3206b);
            this.f3205a.onClick(view);
        } catch (Exception unused) {
        }
    }
}
