package com.baidu.picapture.ui.widget.bdwebview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebView;
import d.p.e;
import d.p.g;
import d.p.o;
import e.c.d.m.i.h.h.a;
import e.c.d.m.i.h.h.c;

public class BDWebView extends WebView implements g {

    /* renamed from: a reason: collision with root package name */
    public NativeBridge f2015a;

    public BDWebView(Context context) {
        super(context);
        a();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setSupportMultipleWindows(true);
        StringBuilder sb = new StringBuilder();
        sb.append(getSettings().getUserAgentString());
        sb.append(" bdvrpct/4.1.3.511");
        getSettings().setUserAgentString(sb.toString());
        NativeBridge nativeBridge = new NativeBridge(this);
        this.f2015a = nativeBridge;
        addJavascriptInterface(nativeBridge, "NativeBridge");
        e.c.d.m.i.h.g gVar = new e.c.d.m.i.h.g();
        gVar.f6818a.add(new a());
        gVar.f6818a.add(new c());
        setWebViewClient(gVar);
    }

    @o(e.a.ON_DESTROY)
    public void destroyResources() {
        NativeBridge nativeBridge = this.f2015a;
        if (nativeBridge != null) {
            nativeBridge.f2017b.clear();
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        clearHistory();
    }

    public NativeBridge getBridge() {
        return this.f2015a;
    }

    @o(e.a.ON_PAUSE)
    public void pause() {
        NativeBridge nativeBridge = this.f2015a;
        if (nativeBridge != null) {
            nativeBridge.a("Page.pause", null, null);
        }
    }

    @o(e.a.ON_RESUME)
    public void resume() {
        NativeBridge nativeBridge = this.f2015a;
        if (nativeBridge != null) {
            nativeBridge.a("Page.resume", null, null);
        }
    }

    public void setLifecycle(e eVar) {
        eVar.a(this);
    }

    public BDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BDWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
