package e.c.d.m.h;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.picapture.ui.webview.WebViewActivity;

/* compiled from: WebViewActivity */
public class b extends WebViewClient {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ WebViewActivity f6791a;

    public b(WebViewActivity webViewActivity) {
        this.f6791a = webViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
