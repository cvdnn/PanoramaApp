package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.picapture.R;
import e.c.d.m.i.i.d;
import e.c.d.m.i.i.e;
import e.c.d.m.i.i.k;

public class Model1Dialog extends Dialog implements k {

    /* renamed from: a reason: collision with root package name */
    public b f2046a;

    /* renamed from: b reason: collision with root package name */
    public TextView f2047b;

    /* renamed from: c reason: collision with root package name */
    public Button f2048c;

    /* renamed from: d reason: collision with root package name */
    public Button f2049d;

    /* renamed from: e reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2050e;

    /* renamed from: f reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2051f;

    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f2052a = "Content";

        /* renamed from: b reason: collision with root package name */
        public String f2053b;

        /* renamed from: c reason: collision with root package name */
        public int f2054c;

        /* renamed from: d reason: collision with root package name */
        public String f2055d;

        /* renamed from: e reason: collision with root package name */
        public int f2056e;

        /* renamed from: f reason: collision with root package name */
        public boolean f2057f;

        /* renamed from: g reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2058g;

        /* renamed from: h reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2059h;

        public /* synthetic */ b(a aVar) {
            String str = "";
            this.f2053b = str;
            this.f2054c = R.drawable.black_text_color_selector;
            this.f2055d = str;
            this.f2056e = R.drawable.light_blue_text_color_selector;
            this.f2057f = true;
        }
    }

    public /* synthetic */ Model1Dialog(Context context, a aVar) {
        super(context);
    }

    public /* synthetic */ void a(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2050e;
        if (aVar != null) {
            aVar.a(this);
        } else {
            dismiss();
        }
    }

    public /* synthetic */ void b(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2051f;
        if (aVar != null) {
            aVar.a(this);
        } else {
            dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(R.layout.model1_dialog);
        this.f2047b = (TextView) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.btn_cancel);
        this.f2048c = button;
        button.setVisibility(8);
        this.f2048c.setOnClickListener(new d(this));
        Button button2 = (Button) findViewById(R.id.btn_confirm);
        this.f2049d = button2;
        button2.setVisibility(8);
        this.f2049d.setOnClickListener(new e(this));
        this.f2047b.setText(this.f2046a.f2052a);
        String str = this.f2046a.f2053b;
        if (!TextUtils.isEmpty(str)) {
            this.f2048c.setVisibility(0);
            this.f2048c.setText(str);
        }
        this.f2048c.setTextColor(getContext().getColorStateList(this.f2046a.f2054c));
        b bVar = this.f2046a;
        this.f2050e = bVar.f2058g;
        String str2 = bVar.f2055d;
        if (!TextUtils.isEmpty(str2)) {
            this.f2049d.setVisibility(0);
            this.f2049d.setText(str2);
        }
        this.f2049d.setTextColor(getContext().getColorStateList(this.f2046a.f2056e));
        b bVar2 = this.f2046a;
        this.f2051f = bVar2.f2059h;
        setCancelable(bVar2.f2057f);
        if (this.f2048c.getVisibility() != 0 || this.f2049d.getVisibility() != 0) {
            if (this.f2048c.getVisibility() == 8) {
                this.f2049d.setBackground(getContext().getDrawable(R.drawable.dialog_button_selector));
            } else {
                this.f2048c.setBackground(getContext().getDrawable(R.drawable.dialog_button_selector));
            }
        }
    }
}
