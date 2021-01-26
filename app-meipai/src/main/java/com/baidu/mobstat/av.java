package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback;
import com.baidu.mobstat.BaiduStatJSInterface.IWebviewPageLoadCallback;
import com.baidu.mobstat.MtjConfig.FeedTrackStrategy;
import org.json.JSONObject;

public class av {

    public static class a implements IActivityLifeCallback {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("onActivityPaused");
                }
                az.a().b(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("onActivityResumed");
                }
                az.a().a(activity);
            }
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
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("WebView onPageFinished");
                }
                webView.addJavascriptInterface(blVar, "WebViewInterface");
                az.a().a(webView, str, blVar);
            }
        }

        public void onPageStarted(WebView webView, String str, bl blVar) {
            if (af.a() && !ax.a().b()) {
                if (bh.c().b()) {
                    bh.c().a("WebView onPageStarted");
                }
                webView.addJavascriptInterface(blVar, "WebViewInterface");
            }
        }
    }

    public static void a(String str) {
        if (af.a() && !ax.a().b()) {
            az.a().b(str);
        }
    }

    public static void b(String str) {
        if (af.a()) {
            az.a().a(str);
        }
    }

    public static void a(FeedTrackStrategy feedTrackStrategy) {
        if (!ax.a().b()) {
            ar.a(feedTrackStrategy);
        }
    }

    public static void a(JSONObject jSONObject) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(jSONObject);
        }
    }

    public static void a(Context context) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(context);
        }
    }

    public static void a(Context context, boolean z) {
        if (af.a() && !ax.a().b()) {
            aw.a().a(context, z);
        }
    }
}
