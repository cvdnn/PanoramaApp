package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import e.c.c.a.e;
import e.c.c.a.f;
import e.c.c.a.h;

public class CustomAlertDialog extends Dialog implements AlertDialogInterface, NoProguard {

    /* renamed from: a reason: collision with root package name */
    public TextView f3143a;

    /* renamed from: b reason: collision with root package name */
    public TextView f3144b;

    /* renamed from: c reason: collision with root package name */
    public TextView f3145c;

    /* renamed from: d reason: collision with root package name */
    public TextView f3146d;

    /* renamed from: e reason: collision with root package name */
    public Context f3147e;

    public CustomAlertDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        a(context);
    }

    public void setCancel(boolean z) {
        setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public void setMessageText(String str) {
        this.f3144b.setText(str);
    }

    public void setMessageVisible(int i2) {
        this.f3144b.setVisibility(i2);
    }

    public void setNegativeBtn(String str, OnClickListener onClickListener) {
        this.f3146d.setText(str);
        this.f3146d.setOnClickListener(new c(this, onClickListener));
    }

    public void setPositiveBtn(String str, OnClickListener onClickListener) {
        this.f3145c.setText(str);
        this.f3145c.setOnClickListener(new b(this, onClickListener));
    }

    public void setTitleText(String str) {
        this.f3143a.setText(str);
    }

    public void setTitleVisible(int i2) {
        this.f3143a.setVisibility(i2);
    }

    public void showDialog() {
        show();
    }

    private void a(Context context) {
        this.f3147e = context;
        setContentView(f.layout_sapi_sdk_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.f3143a = (TextView) findViewById(e.title_text);
        this.f3144b = (TextView) findViewById(e.msg_text);
        this.f3145c = (TextView) findViewById(e.positive_btn);
        this.f3146d = (TextView) findViewById(e.negative_btn);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            ((ViewGroup) this.f3143a.getRootView()).addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_night_mode_mask, null), new LayoutParams(-1, -1, 0, 0));
        }
    }
}
