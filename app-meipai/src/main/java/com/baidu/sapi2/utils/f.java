package com.baidu.sapi2.utils;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.sapi2.callback.a.a;

/* compiled from: SapiCoreUtil */
public class f extends WebViewClient {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ WebView f3071a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ String f3072b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ a f3073c;

    public f(WebView webView, String str, a aVar) {
        this.f3071a = webView;
        this.f3072b = str;
        this.f3073c = aVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f3071a.evaluateJavascript(this.f3072b, new e(this));
    }
}
