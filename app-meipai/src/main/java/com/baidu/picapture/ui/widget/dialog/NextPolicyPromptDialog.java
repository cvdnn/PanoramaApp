package com.baidu.picapture.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import e.c.d.m.i.i.h;
import e.c.d.m.i.i.k;

public class NextPolicyPromptDialog extends Dialog implements k {

    /* renamed from: a reason: collision with root package name */
    public b f2076a;

    /* renamed from: b reason: collision with root package name */
    public TextView f2077b;

    /* renamed from: c reason: collision with root package name */
    public TextView f2078c;

    /* renamed from: d reason: collision with root package name */
    public TextView f2079d;

    /* renamed from: e reason: collision with root package name */
    public e.c.d.m.i.i.k.a f2080e;

    public static class b {

        /* renamed from: a reason: collision with root package name */
        public String f2081a = App.f1954b.getString(R.string.policy_prompt);

        /* renamed from: b reason: collision with root package name */
        public String f2082b = App.f1954b.getString(R.string.prompt_content);

        /* renamed from: c reason: collision with root package name */
        public String f2083c = App.f1954b.getString(R.string.next);

        /* renamed from: d reason: collision with root package name */
        public int f2084d = R.drawable.light_blue_text_color_selector;

        /* renamed from: e reason: collision with root package name */
        public boolean f2085e = true;

        /* renamed from: f reason: collision with root package name */
        public e.c.d.m.i.i.k.a f2086f;

        public /* synthetic */ b(a aVar) {
        }
    }

    public /* synthetic */ NextPolicyPromptDialog(Context context, a aVar) {
        super(context);
    }

    public /* synthetic */ void a(View view) {
        e.c.d.m.i.i.k.a aVar = this.f2080e;
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
        setContentView(R.layout.next_policy_prompt_dialog);
        this.f2077b = (TextView) findViewById(R.id.title);
        this.f2078c = (TextView) findViewById(R.id.content);
        TextView textView = (TextView) findViewById(R.id.btn_next);
        this.f2079d = textView;
        textView.setVisibility(8);
        this.f2079d.setOnClickListener(new h(this));
        this.f2077b.setText(this.f2076a.f2081a);
        this.f2078c.setText(this.f2076a.f2082b);
        this.f2079d.setText(this.f2076a.f2083c);
        this.f2079d.setTextColor(getContext().getColorStateList(this.f2076a.f2084d));
        e.c.d.m.i.i.k.a aVar = this.f2076a.f2086f;
        if (aVar != null) {
            this.f2079d.setVisibility(0);
            this.f2080e = aVar;
        }
        setCancelable(this.f2076a.f2085e);
    }
}
