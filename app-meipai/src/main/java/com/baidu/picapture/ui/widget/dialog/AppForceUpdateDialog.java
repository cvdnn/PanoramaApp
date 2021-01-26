package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import e.c.d.e.e0;

public class AppForceUpdateDialog extends Dialog {

    /* renamed from: a reason: collision with root package name */
    public String f2020a;

    public AppForceUpdateDialog(Context context, String str) {
        super(context);
        this.f2020a = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        e0 a2 = e0.a(getLayoutInflater());
        a2.a(this);
        setContentView(a2.f926d);
        setCancelable(false);
    }
}
