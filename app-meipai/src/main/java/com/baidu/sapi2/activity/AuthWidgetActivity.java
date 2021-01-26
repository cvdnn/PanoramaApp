package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.WebviewClientCallback;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import e.c.c.a.f;
import java.net.URLDecoder;

public class AuthWidgetActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_URL = "auth_url";
    public String r;
    public String s;
    public SapiResult t = new SapiResult();

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.t.setResultCode(-301);
            this.t.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            finishActivity();
            return;
        }
        this.sapiWebView.goBack();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAuthWidgetCallback() != null) {
            PassportSDK.getInstance().getAuthWidgetCallback().onFailure(this.t);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    public void init() {
        super.init();
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        this.t.setResultCode(-301);
        this.t.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            String stringExtra = getIntent().getStringExtra(EXTRA_PARAM_AUTH_URL);
            this.r = stringExtra;
            this.s = (String) SapiUtils.urlParamsToMap(stringExtra).get("u");
            if (TextUtils.isEmpty(this.r) || TextUtils.isEmpty(this.s)) {
                this.t.setResultCode(-204);
                this.t.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                finishActivity();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            finishActivity();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            e();
        }
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                AuthWidgetActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AuthWidgetActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AuthWidgetActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new WebviewClientCallback() {
            public void onPageFinished(WebView webView, String str) {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(URLDecoder.decode(AuthWidgetActivity.this.s))) {
                    PassportSDK.getInstance().getAuthWidgetCallback().onSuccess((String) SapiUtils.urlParamsToMap(str).get("authsid"));
                    AuthWidgetActivity.this.finish();
                }
            }
        });
        this.sapiWebView.loadUrl(this.r);
    }
}
