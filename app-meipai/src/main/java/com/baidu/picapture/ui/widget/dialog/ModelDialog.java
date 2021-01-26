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
import e.c.d.m.i.i.f;
import e.c.d.m.i.i.g;
import e.c.d.m.i.i.k;

public class ModelDialog extends Dialog implements k {

    /* renamed from: a reason: collision with root package name */
    public b f2060a;

    /* renamed from: b reason: collision with root package name */
    public TextView f2061b;

    /* renamed from: c reason: collision with root package name */
    public TextView f2062c;

    /* renamed from: d reason: collision with root package name */
    public Button f2063d;

    /* renamed from: e reason: collision with root package name */
    public Button f2064e;

    /* renamed from: f reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2065f;

    /* renamed from: g reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2066g;

    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f2067a = "Title";

        /* renamed from: b reason: collision with root package name */
        public String f2068b = "Content";

        /* renamed from: c reason: collision with root package name */
        public String f2069c;

        /* renamed from: d reason: collision with root package name */
        public int f2070d;

        /* renamed from: e reason: collision with root package name */
        public String f2071e;

        /* renamed from: f reason: collision with root package name */
        public int f2072f;

        /* renamed from: g reason: collision with root package name */
        public boolean f2073g;

        /* renamed from: h reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2074h;

        /* renamed from: i reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2075i;

        public /* synthetic */ b(a aVar) {
            String str = "";
            this.f2069c = str;
            this.f2070d = R.drawable.black_text_color_selector;
            this.f2071e = str;
            this.f2072f = R.drawable.light_blue_text_color_selector;
            this.f2073g = true;
        }
    }

    public /* synthetic */ ModelDialog(Context context, a aVar) {
        super(context);
    }

    public /* synthetic */ void a(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2065f;
        if (aVar != null) {
            aVar.a(this);
        } else {
            dismiss();
        }
    }

    public /* synthetic */ void b(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2066g;
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
        setContentView(R.layout.model_dialog);
        this.f2061b = (TextView) findViewById(R.id.title);
        this.f2062c = (TextView) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.btn_cancel);
        this.f2063d = button;
        button.setVisibility(8);
        this.f2063d.setOnClickListener(new f(this));
        Button button2 = (Button) findViewById(R.id.btn_confirm);
        this.f2064e = button2;
        button2.setVisibility(8);
        this.f2064e.setOnClickListener(new g(this));
        this.f2061b.setText(this.f2060a.f2067a);
        this.f2062c.setText(this.f2060a.f2068b);
        String str = this.f2060a.f2069c;
        if (!TextUtils.isEmpty(str)) {
            this.f2063d.setVisibility(0);
            this.f2063d.setText(str);
        }
        this.f2063d.setTextColor(getContext().getColorStateList(this.f2060a.f2070d));
        b bVar = this.f2060a;
        this.f2065f = bVar.f2074h;
        String str2 = bVar.f2071e;
        if (!TextUtils.isEmpty(str2)) {
            this.f2064e.setVisibility(0);
            this.f2064e.setText(str2);
        }
        this.f2064e.setTextColor(getContext().getColorStateList(this.f2060a.f2072f));
        b bVar2 = this.f2060a;
        this.f2066g = bVar2.f2075i;
        setCancelable(bVar2.f2073g);
        if (this.f2063d.getVisibility() != 0 || this.f2064e.getVisibility() != 0) {
            if (this.f2063d.getVisibility() == 8) {
                this.f2064e.setBackground(getContext().getDrawable(R.drawable.dialog_button_selector));
            } else {
                this.f2063d.setBackground(getContext().getDrawable(R.drawable.dialog_button_selector));
            }
        }
    }
}
