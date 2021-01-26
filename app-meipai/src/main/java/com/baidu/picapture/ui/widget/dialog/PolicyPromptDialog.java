package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import e.c.d.m.i.i.i;
import e.c.d.m.i.i.j;
import e.c.d.m.i.i.k;
import e.c.d.m.i.i.m;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PolicyPromptDialog extends Dialog implements k {

    /* renamed from: a reason: collision with root package name */
    public a f2087a;

    /* renamed from: b reason: collision with root package name */
    public Context f2088b;

    /* renamed from: c reason: collision with root package name */
    public TextView f2089c;

    /* renamed from: d reason: collision with root package name */
    public TextView f2090d;

    /* renamed from: e reason: collision with root package name */
    public TextView f2091e;

    /* renamed from: f reason: collision with root package name */
    public TextView f2092f;

    /* renamed from: g reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2093g;

    /* renamed from: h reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2094h;

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f2095a = App.f1954b.getString(R.string.policy_prompt);

        /* renamed from: b reason: collision with root package name */
        public String f2096b = App.f1954b.getString(R.string.prompt_content);

        /* renamed from: c reason: collision with root package name */
        public String f2097c = App.f1954b.getString(R.string.disagree);

        /* renamed from: d reason: collision with root package name */
        public String f2098d = App.f1954b.getString(R.string.agree);

        /* renamed from: e reason: collision with root package name */
        public boolean f2099e = true;

        /* renamed from: f reason: collision with root package name */
        public Map<String, List<String>> f2100f = new Hashtable();

        /* renamed from: g reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2101g;

        /* renamed from: h reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2102h;

        public /* synthetic */ a(m mVar) {
        }
    }

    public /* synthetic */ PolicyPromptDialog(Context context, m mVar) {
        super(context);
        this.f2088b = context;
    }

    public /* synthetic */ void a(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2093g;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public /* synthetic */ void b(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2094h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(R.layout.policy_prompt_dialog);
        this.f2089c = (TextView) findViewById(R.id.title);
        this.f2090d = (TextView) findViewById(R.id.content);
        TextView textView = (TextView) findViewById(R.id.btn_disagree);
        this.f2091e = textView;
        textView.setVisibility(8);
        this.f2091e.setOnClickListener(new j(this));
        TextView textView2 = (TextView) findViewById(R.id.btn_agree);
        this.f2092f = textView2;
        textView2.setVisibility(8);
        this.f2092f.setOnClickListener(new i(this));
        this.f2089c.setText(this.f2087a.f2095a);
        this.f2090d.setText(this.f2087a.f2096b);
        this.f2091e.setText(this.f2087a.f2097c);
        e.c.d.m.i.i.k.a aVar = this.f2087a.f2101g;
        if (aVar != null) {
            this.f2091e.setVisibility(0);
            this.f2093g = aVar;
        }
        this.f2092f.setText(this.f2087a.f2098d);
        e.c.d.m.i.i.k.a aVar2 = this.f2087a.f2102h;
        if (aVar2 != null) {
            this.f2092f.setVisibility(0);
            this.f2094h = aVar2;
        }
        setCancelable(this.f2087a.f2099e);
        Map<String, List<String>> map = this.f2087a.f2100f;
        if (map != null && !map.isEmpty()) {
            String str = (String) this.f2090d.getText();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            for (Entry entry : map.entrySet()) {
                int indexOf = str.indexOf((String) entry.getKey());
                while (indexOf >= 0) {
                    int length = ((String) entry.getKey()).length() + indexOf;
                    spannableStringBuilder.setSpan(new m(this, entry), indexOf, length, 33);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f2088b.getColor(R.color.link)), indexOf, length, 33);
                    indexOf = str.indexOf((String) entry.getKey(), length);
                }
            }
            this.f2090d.setText(spannableStringBuilder);
            this.f2090d.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
