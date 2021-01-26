package com.baidu.mobstat;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback;
import com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback;
import org.json.JSONArray;

public class af {

    /* renamed from: a reason: collision with root package name */
    public static volatile boolean f1506a = true;

    /* renamed from: b reason: collision with root package name */
    public static volatile boolean f1507b = false;

    public static class a implements IActivityLifeCallback {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (bd.c().b()) {
                bd.c().a("onActivityCreated");
            }
            am.a().a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (bd.c().b()) {
                bd.c().a("onActivityPaused");
            }
            am.a().c(activity);
        }

        public void onActivityResumed(Activity activity) {
            if (bd.c().b()) {
                bd.c().a("onActivityResumed");
            }
            am.a().b(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static class b implements IWebviewPageLoadCallback {
        public void onPageFinished(WebView webView, String str, bl blVar) {
            if (bd.c().b()) {
                bd.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(blVar, "WebViewInterface");
            am.a().a(webView, str, blVar);
        }

        public void onPageStarted(WebView webView, String str, bl blVar) {
            if (bd.c().b()) {
                bd.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(blVar, "WebViewInterface");
        }
    }

    public static boolean a() {
        return f1507b;
    }

    public static boolean b() {
        return f1506a;
    }

    public static JSONArray c() {
        return am.a().e();
    }

    public static void a(String str) {
        f1507b = true;
        am.a().a(str);
    }

    public static void a(boolean z) {
        am.a().a(z);
    }
}
