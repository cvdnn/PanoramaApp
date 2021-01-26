package e.c.d.m.i.h;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;

/* compiled from: BDWebChromeClient */
public class f extends WebChromeClient {

    /* renamed from: a reason: collision with root package name */
    public b f6817a;

    /* compiled from: BDWebChromeClient */
    public class a extends WebViewClient {
        public a(f fVar) {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            webView.getContext().startActivity(intent);
            return true;
        }
    }

    /* compiled from: BDWebChromeClient */
    public interface b {
        boolean a(ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams);
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(new a(this));
        ((WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        b bVar = this.f6817a;
        if (bVar != null) {
            return bVar.a(valueCallback, fileChooserParams);
        }
        return false;
    }
}
