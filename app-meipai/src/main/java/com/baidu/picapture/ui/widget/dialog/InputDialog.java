package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.google.android.material.textfield.TextInputEditText;
import e.c.d.m.i.i.c;
import e.c.d.m.i.i.k;
import e.c.d.m.i.i.l;

public class InputDialog extends Dialog implements k {

    /* renamed from: a reason: collision with root package name */
    public b f2027a;

    /* renamed from: b reason: collision with root package name */
    public TextView f2028b;

    /* renamed from: c reason: collision with root package name */
    public TextInputEditText f2029c;

    /* renamed from: d reason: collision with root package name */
    public Button f2030d;

    /* renamed from: e reason: collision with root package name */
    public Button f2031e;

    /* renamed from: f reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2032f;

    /* renamed from: g reason: collision with root package name */
    public e.c.d.m.i.i.k.b f2033g;

    /* renamed from: h reason: collision with root package name */
    public Handler f2034h = new Handler();

    /* renamed from: i reason: collision with root package name */
    public Runnable f2035i = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            InputDialog.this.f2029c.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) InputDialog.this.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(InputDialog.this.f2029c, 0);
            }
        }
    }

    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f2037a = "Title";

        /* renamed from: b reason: collision with root package name */
        public String f2038b;

        /* renamed from: c reason: collision with root package name */
        public String f2039c;

        /* renamed from: d reason: collision with root package name */
        public String f2040d;

        /* renamed from: e reason: collision with root package name */
        public String f2041e;

        /* renamed from: f reason: collision with root package name */
        public boolean f2042f;

        /* renamed from: g reason: collision with root package name */
        public int f2043g;

        /* renamed from: h reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2044h;

        /* renamed from: i reason: collision with root package name */
        public e.c.d.m.i.i.k.b f2045i;

        public /* synthetic */ b(a aVar) {
            String str = "";
            this.f2038b = str;
            this.f2039c = str;
            this.f2040d = App.f1954b.getString(R.string.cancel);
            this.f2041e = App.f1954b.getString(R.string.confirm);
            this.f2042f = true;
            this.f2043g = 10;
        }
    }

    public /* synthetic */ InputDialog(Context context, a aVar) {
        super(context);
    }

    public /* synthetic */ void a(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2032f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public /* synthetic */ void b(View view) {
        if (this.f2033g != null && this.f2029c.getText() != null) {
            this.f2033g.a(this, this.f2029c.getText().toString().trim());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(R.layout.input_dialog);
        this.f2028b = (TextView) findViewById(R.id.title);
        Button button = (Button) findViewById(R.id.btn_cancel);
        this.f2030d = button;
        button.setOnClickListener(new e.c.d.m.i.i.b(this));
        Button button2 = (Button) findViewById(R.id.btn_confirm);
        this.f2031e = button2;
        button2.setOnClickListener(new c(this));
        TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.input);
        this.f2029c = textInputEditText;
        textInputEditText.addTextChangedListener(new l(this));
        this.f2029c.setSelectAllOnFocus(true);
        this.f2028b.setText(this.f2027a.f2037a);
        this.f2029c.setText(this.f2027a.f2039c);
        this.f2030d.setText(this.f2027a.f2040d);
        this.f2031e.setText(this.f2027a.f2041e);
        this.f2029c.setHint(this.f2027a.f2038b);
        int i2 = this.f2027a.f2043g;
        this.f2029c.setFilters(new InputFilter[]{new LengthFilter(i2)});
        b bVar = this.f2027a;
        this.f2032f = bVar.f2044h;
        this.f2033g = bVar.f2045i;
        setCancelable(bVar.f2042f);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2034h.removeCallbacks(this.f2035i);
    }
}
