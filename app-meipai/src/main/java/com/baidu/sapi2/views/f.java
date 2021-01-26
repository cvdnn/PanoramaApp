package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.b.b;
import e.c.c.a.d;
import e.c.c.a.e;
import e.c.c.a.h;

/* compiled from: FingerprintDialog */
public class f extends Dialog implements b {

    /* renamed from: a reason: collision with root package name */
    public LinearLayout f3207a = ((LinearLayout) findViewById(e.bg_layout));

    /* renamed from: b reason: collision with root package name */
    public TextView f3208b = ((TextView) findViewById(e.title));

    /* renamed from: c reason: collision with root package name */
    public TextView f3209c = ((TextView) findViewById(e.sub_title));

    /* renamed from: d reason: collision with root package name */
    public TextView f3210d = ((TextView) findViewById(e.negative_btn));

    /* renamed from: e reason: collision with root package name */
    public TextView f3211e = ((TextView) findViewById(e.positive_btn));

    /* renamed from: f reason: collision with root package name */
    public ImageView f3212f = ((ImageView) findViewById(e.icon));

    /* renamed from: g reason: collision with root package name */
    public View f3213g = findViewById(e.transverse_divider_line);

    /* renamed from: h reason: collision with root package name */
    public View f3214h = findViewById(e.divider_line);

    /* renamed from: i reason: collision with root package name */
    public Context f3215i;

    public f(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f3215i = context;
        setContentView(e.c.c.a.f.layout_sapi_sdk_fingerprint_dialog);
        b();
        ViewUtility.setViewClickAlpha(this.f3210d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f3211e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private void b() {
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f3207a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f3212f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f3208b.setTextColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f3209c.setTextColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f3213g.setBackgroundColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.f3214h.setBackgroundColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_fingerprint_dialog_divider_line));
            this.f3210d.setTextColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f3211e.setTextColor(this.f3215i.getResources().getColor(e.c.c.a.b.sapi_sdk_dark_mode_edit_text_color));
        }
    }

    public b setNegativeBtn(String str, OnClickListener onClickListener) {
        this.f3210d.setText(str);
        this.f3210d.setOnClickListener(new d(this, onClickListener));
        return this;
    }

    public b setPositiveBtn(String str, OnClickListener onClickListener) {
        this.f3211e.setText(str);
        this.f3211e.setOnClickListener(new e(this, onClickListener));
        return this;
    }

    public void showDialog() {
        show();
    }

    public b a(int i2) {
        if (i2 > 2) {
            i2 = 2;
        } else if (i2 < 1) {
            i2 = 1;
        }
        if (i2 == 1) {
            this.f3211e.setVisibility(8);
            findViewById(e.divider_line).setVisibility(8);
        } else {
            this.f3211e.setVisibility(0);
            findViewById(e.divider_line).setVisibility(0);
        }
        return this;
    }

    public b a(String str, String str2) {
        this.f3208b.setText(str);
        this.f3209c.setText(str2);
        return this;
    }

    public b a() {
        findViewById(e.icon).setVisibility(8);
        return this;
    }
}
