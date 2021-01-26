package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import e.c.d.e.g0;

public class AppUpdateDialog extends Dialog {

    /* renamed from: a reason: collision with root package name */
    public g0 f2021a;

    /* renamed from: b reason: collision with root package name */
    public String f2022b;

    /* renamed from: c reason: collision with root package name */
    public String f2023c;

    public AppUpdateDialog(Context context, String str, String str2) {
        super(context);
        this.f2022b = str;
        this.f2023c = str2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        g0 a2 = g0.a(getLayoutInflater());
        this.f2021a = a2;
        a2.a(this);
        setContentView(this.f2021a.f926d);
        setCancelable(false);
        if (!TextUtils.isEmpty(this.f2023c)) {
            this.f2021a.n.setText(this.f2023c);
        }
        this.f2021a.n.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
