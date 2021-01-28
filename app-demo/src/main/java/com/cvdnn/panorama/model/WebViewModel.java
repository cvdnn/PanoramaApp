package com.cvdnn.panorama.model;

import android.Loople;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.cvdnn.panorama.databinding.ActWebviewBinding;

import static android.webkit.WebSettings.LOAD_DEFAULT;

public final class WebViewModel extends ModelBinding<ActWebviewBinding> {
    private static final String TAG = "WebViewModel";

    public static String url;

    private Context mContext;

    @Override
    protected void onCreate(LifecycleOwner owner) {
        super.onCreate(owner);

        mContext = mBinding.webView.getContext();

        mBinding.webView.setOnKeyListener(mWebKeyListener);
        mBinding.webView.setWebViewClient(mWebClient);
        onWebSetting();

        mBinding.webView.loadUrl(url);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mBinding.webView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mBinding.webView.onPause();
    }

    @Override
    protected void onDestroy(Lifecycle lifecycle) {
        super.onDestroy(lifecycle);

        mBinding.webView.destroy();
    }

    public void onLoad() {
        Loople.Main.post(() -> mBinding.webView.loadUrl(url));
    }

    public void onReloadWebView() {
        Loople.Main.post(() -> {
            mBinding.webView.stopLoading();

            mBinding.webView.getSettings().setCacheMode(LOAD_DEFAULT);
            mBinding.webView.reload();
        });
    }

    private void onWebSetting() {
        WebSettings webSettings = mBinding.webView.getSettings();
        Log.i(TAG, ">>>>>: " + webSettings.getUserAgentString());

        // 设置 缓存模式
        webSettings.setCacheMode(LOAD_DEFAULT);

        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，将图片调整到适合webview的大小
        webSettings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAppCacheEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCachePath(mContext.getCacheDir().getAbsolutePath());

        //支持通过JS打开新窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //设置编码格式
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setUserAgentString("Mozilla/5.0 (Linux; Intel XUbuntu 16.04; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Mobile Safari/537.36");
    }

    private final WebViewClient mWebClient = new WebViewClient() {

        @Override
        public synchronized void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public synchronized void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);

            if (request.isForMainFrame()) {
                delayReloadWebView();
            }
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);

            delayReloadWebView();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);

            if (request.isForMainFrame()) {
                delayReloadWebView();
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());

            return true;
        }

        private void delayReloadWebView() {
            Loople.Task.schedule(() -> onReloadWebView(), 120000);
        }
    };

    private View.OnKeyListener mWebKeyListener = (v, keyCode, event) -> {
        boolean result = false;

        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mBinding.webView.canGoBack()) {
            // 返回键退回
            mBinding.webView.goBack();

            result = true;
        }

        return result;
    };
}
