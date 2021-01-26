package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.ChangePwdCallback;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebModifyPwdResult;
import com.baidu.sapi2.utils.b;
import e.c.c.a.f;
import e.c.c.a.g;

public class ModifyPwdActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public WebModifyPwdResult r = new WebModifyPwdResult();
    public String s;

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.goBack();
        }
    }

    private void finishActivity() {
        WebModifyPwdCallback webModifyPwdCallback = PassportSDK.getInstance().getWebModifyPwdCallback();
        if (webModifyPwdCallback != null) {
            webModifyPwdCallback.onFinish(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    public void init() {
        super.init();
        String stringExtra = getIntent().getStringExtra("EXTRA_BDUSS");
        this.s = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.r.setResultCode(-204);
            this.r.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            finishActivity();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        this.r.setResultCode(-301);
        this.r.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.r.setResultCode(-202);
            this.r.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
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
        setBtnVisibility(4, 0, 4);
        setTitleText(g.sapi_sdk_title_modify_pwd);
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                ModifyPwdActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                ModifyPwdActivity.this.onClose();
            }
        });
        this.sapiWebView.setChangePwdCallback(new ChangePwdCallback() {
            public void onSuccess() {
                ModifyPwdActivity.this.onClose();
                new b().a(b.f3026c);
            }
        });
        this.sapiWebView.loadModifyPwd(this.s);
    }
}
