package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.ChangePwdCallback;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import e.c.c.a.f;
import e.c.c.a.g;

public class ForgetPwdActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            finish();
        } else {
            this.sapiWebView.goBack();
        }
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebLoginDTO();
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
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            finish();
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
        setTitleText(g.sapi_sdk_title_forget_pwd);
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                ForgetPwdActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.sapiWebView.setChangePwdCallback(new ChangePwdCallback() {
            public void onSuccess() {
                ForgetPwdActivity.this.finish();
            }
        });
        this.sapiWebView.loadForgetPwd();
    }
}
