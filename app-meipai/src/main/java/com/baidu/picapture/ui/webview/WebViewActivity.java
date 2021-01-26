package com.baidu.picapture.ui.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.picapture.R;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.d0;
import e.c.d.e.k0;
import e.c.d.m.a.a;
import e.c.d.m.h.b;
import e.c.d.m.i.h.f;

public class WebViewActivity extends a<d0> {
    public String s;

    public /* synthetic */ void a(View view) {
        finish();
    }

    public d.w.a f0() {
        String str;
        View inflate = getLayoutInflater().inflate(R.layout.activity_web_view, null, false);
        View findViewById = inflate.findViewById(R.id.header);
        if (findViewById != null) {
            k0 a2 = k0.a(findViewById);
            WebView webView = (WebView) inflate.findViewById(R.id.webview);
            if (webView != null) {
                return new d0((ConstraintLayout) inflate, a2, webView);
            }
            str = "webview";
        } else {
            str = "header";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void g0() {
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((d0) this.r).f6041b.n.setOnClickListener(new e.c.d.m.h.a(this));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("URL");
        this.s = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            String str = "http://";
            if (!this.s.toLowerCase().startsWith(str) && !this.s.toLowerCase().startsWith("https://") && !this.s.toLowerCase().startsWith("file://")) {
                StringBuilder a2 = e.a.a.a.a.a(str);
                a2.append(this.s);
                this.s = a2.toString();
            }
            String stringExtra2 = intent.getStringExtra("title");
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = getString(R.string.title);
            }
            ((d0) this.r).f6041b.q.setText(stringExtra2);
            WebSettings settings = ((d0) this.r).f6042c.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportMultipleWindows(true);
            String userAgentString = settings.getUserAgentString();
            StringBuilder sb = new StringBuilder();
            sb.append(userAgentString);
            sb.append(" bdvrpct/4.1.3.511");
            settings.setUserAgentString(sb.toString());
            ((d0) this.r).f6042c.setWebChromeClient(new f());
            ((d0) this.r).f6042c.setWebViewClient(new b(this));
            ((d0) this.r).f6042c.loadUrl(this.s);
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        ViewGroup viewGroup = (ViewGroup) ((d0) this.r).f6042c.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(((d0) this.r).f6042c);
        }
        ((d0) this.r).f6042c.removeAllViews();
        ((d0) this.r).f6042c.clearHistory();
        ((d0) this.r).f6042c.destroy();
    }
}
