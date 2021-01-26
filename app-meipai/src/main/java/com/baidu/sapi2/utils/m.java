package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.p;
import e.c.c.a.b;
import e.c.c.a.d;
import e.c.c.a.e;
import e.c.c.a.f;

/* compiled from: SapiWebViewUtil */
public class m {
    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        b(context, sapiWebView);
        e(context, sapiWebView);
        if (z) {
            d(context, sapiWebView);
        } else {
            c(context, sapiWebView);
        }
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(a(context, sapiWebView));
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            progressBar.setBackgroundColor(context.getResources().getColor(b.sapi_sdk_dark_mode_color));
            sapiWebView.setProgressBar(progressBar);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        sapiWebView.setWebviewLoadingView(new p(context));
    }

    public static void e(Context context, SapiWebView sapiWebView) {
        sapiWebView.setTimeoutView(a(context, sapiWebView));
    }

    public static View a(Context context, SapiWebView sapiWebView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_loading_timeout, null);
        Button button = (Button) inflate.findViewById(e.btn_retry);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            ImageView imageView = (ImageView) inflate.findViewById(e.sapi_sdk_loading_timeout_iv);
            TextView textView = (TextView) inflate.findViewById(e.sapi_sdk_loading_timeout_tv);
            ((LinearLayout) inflate.findViewById(e.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(b.sapi_sdk_dark_mode_color));
            textView.setTextColor(context.getResources().getColor(b.sapi_sdk_dark_mode_no_network_tv_color));
            imageView.setImageResource(d.sapi_sdk_icon_connection_failed_dark);
            button.setBackgroundResource(d.sapi_sdk_btn_gray);
            Resources resources = context.getResources();
            if (resources != null) {
                button.setTextColor(resources.getColorStateList(b.sapi_sdk_text_white));
            }
        }
        button.setOnClickListener(new l(sapiWebView, inflate));
        return inflate;
    }
}
