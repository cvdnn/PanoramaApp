package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import e.c.c.a.f;
import e.c.c.a.g;

public class RegisterActivity extends BaseActivity {
    public WebAuthResult r = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            RegisterActivity.this.finish();
            PassportSDK.getInstance().release();
        }
    };

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebRegDTO();
    }

    public void init() {
        super.init();
        this.r.activity = this;
    }

    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    public void onClose() {
        super.onClose();
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.r.setResultCode(-301);
        this.r.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.r.setResultCode(-202);
                this.r.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                webAuthListener.onFailure(this.r);
            }
            finish();
            PassportSDK.getInstance().release();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(g.sapi_sdk_title_register);
        configTitle();
        final WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                RegisterActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void beforeSuccess(SapiAccount sapiAccount) {
                super.beforeSuccess(sapiAccount);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.beforeSuccess(sapiAccount);
                }
            }

            public void onFailed(int i2, String str) {
                RegisterActivity.this.r.setResultCode(i2);
                RegisterActivity.this.r.setResultMsg(str);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.onFailure(RegisterActivity.this.r);
                }
                RegisterActivity.this.finish();
                PassportSDK.getInstance().release();
            }

            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.r.accountType = accountType;
                RegisterActivity.this.r.setResultCode(0);
                WebAuthListener webAuthListener = webAuthListener;
                if (webAuthListener != null) {
                    webAuthListener.onSuccess(RegisterActivity.this.r);
                }
                WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                if (webRegDTO != null && webRegDTO.finishActivityAfterSuc) {
                    RegisterActivity.this.finish();
                    PassportSDK.getInstance().release();
                }
            }
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
