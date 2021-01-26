package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import e.c.d.e.i0;

public class CaptureGuideDialog extends Dialog {

    /* renamed from: a reason: collision with root package name */
    public i0 f2024a;

    /* renamed from: b reason: collision with root package name */
    public boolean f2025b = true;

    /* renamed from: c reason: collision with root package name */
    public a f2026c;

    public interface a {
        void a();
    }

    public CaptureGuideDialog(Context context) {
        super(context);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.f2025b = z;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        i0 a2 = i0.a(getLayoutInflater());
        this.f2024a = a2;
        setContentView(a2.f926d);
        setCancelable(false);
        this.f2024a.a(this);
        this.f2024a.o.setOnCheckedChangeListener(new e.c.d.m.i.i.a(this));
    }
}
