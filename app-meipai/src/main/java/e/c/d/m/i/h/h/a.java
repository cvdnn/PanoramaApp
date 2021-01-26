package e.c.d.m.i.h.h;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import e.c.d.n.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: AppFileIntercept */
public class a extends b {
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        String a2 = a(webResourceRequest.getRequestHeaders());
        if (this.f6819a != null && !TextUtils.isEmpty(uri) && !TextUtils.isEmpty(a2) && a(webResourceRequest.getUrl())) {
            String a3 = a(webResourceRequest.getUrl().toString());
            if (!a3.startsWith("picapture/appfile/pano_thumb/")) {
                return null;
            }
            String h2 = e.h(a3.substring(29));
            if (!e.m(h2)) {
                return null;
            }
            try {
                return new WebResourceResponse(a2, "utf-8", new FileInputStream(h2));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
