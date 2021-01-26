package e.c.d.m.i.h.h;

import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.picapture.App;
import com.baidubce.BceConfig;
import java.io.IOException;

/* compiled from: CacheIntercept */
public class c extends b {
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        String a2 = a(webResourceRequest.getRequestHeaders());
        if (this.f6819a != null && !TextUtils.isEmpty(uri) && !TextUtils.isEmpty(a2) && a(webResourceRequest.getUrl())) {
            String a3 = a(webResourceRequest.getUrl().toString());
            if (a3.endsWith(".svg")) {
                a2 = "image/svg+xml";
            }
            try {
                if (TextUtils.isEmpty(a3) || a3.startsWith("#/") || a3.startsWith(BceConfig.BOS_DELIMITER)) {
                    a3 = "index.html";
                }
                AssetManager assets = App.f1954b.getAssets();
                StringBuilder sb = new StringBuilder();
                sb.append("webcache/");
                sb.append(a3);
                return new WebResourceResponse(a2, "utf-8", assets.open(sb.toString()));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
