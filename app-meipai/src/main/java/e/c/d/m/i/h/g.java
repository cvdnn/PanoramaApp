package e.c.d.m.i.h;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import e.c.d.g.a;
import e.c.d.m.i.h.h.d;
import i.b.a.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BDWebViewClient */
public class g extends WebViewClient {

    /* renamed from: a reason: collision with root package name */
    public List<d> f6818a = new ArrayList();

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        for (d a2 : this.f6818a) {
            WebResourceResponse a3 = a2.a(webView, webResourceRequest);
            if (a3 != null) {
                return a3;
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("tel:")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        c.b().a((Object) new a(str));
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
