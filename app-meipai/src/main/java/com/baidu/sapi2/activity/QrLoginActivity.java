package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import e.c.c.a.f;
import e.c.c.a.g;

public class QrLoginActivity extends BaseActivity {
    public static final String EXTRA_BOOLEAN_FINISH_PAGE = "EXTRA_BOOLEAN_FINISH_PAGE";
    public static final String EXTRA_STRING_QR_LOGIN_URL = "EXTRA_STRING_QR_LOGIN_URL";
    public String r;
    public boolean s;
    public QrLoginResult t = new QrLoginResult();

    /* access modifiers changed from: private */
    public void b(boolean z) {
        QrLoginCallback qrLoginCallback = PassportSDK.getInstance().getQrLoginCallback();
        if (qrLoginCallback != null) {
            qrLoginCallback.onFinish(this.t);
        }
        if (z) {
            finish();
        }
        PassportSDK.getInstance().release();
    }

    private void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void finishActivity() {
        b(true);
    }

    public void init() {
        super.init();
        this.r = getIntent().getStringExtra(EXTRA_STRING_QR_LOGIN_URL);
        this.s = getIntent().getBooleanExtra(EXTRA_BOOLEAN_FINISH_PAGE, true);
        if (!SapiUtils.isQrLoginSchema(this.r)) {
            Toast.makeText(this, "抱歉，您扫描的二维码有误，请重新扫描", 0).show();
            this.t.setResultCode(-204);
            this.t.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            finishActivity();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() {
            public void onFailure(QrAppLoginResult qrAppLoginResult) {
            }

            public void onFinish() {
            }

            public void onStart() {
            }

            public void onSuccess(QrAppLoginResult qrAppLoginResult) {
            }
        }, this.r, QrLoginAction.CANCEL.getName());
        this.t.setResultCode(-301);
        this.t.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
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
            this.t.setResultCode(-202);
            this.t.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
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
        setTitle(g.sapi_sdk_title_qr_login);
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                SapiWebView sapiWebView = QrLoginActivity.this.sapiWebView;
                if (sapiWebView == null || !sapiWebView.canGoBack()) {
                    QrLoginActivity.this.onClose();
                } else {
                    QrLoginActivity.this.sapiWebView.goBack();
                }
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                QrLoginActivity.this.onClose();
            }
        });
        this.sapiWebView.loadQrLogin(new SapiWebView.QrLoginCallback() {
            public void loginStatusChange(boolean z) {
                QrLoginResult qrLoginResult = QrLoginActivity.this.t;
                qrLoginResult.loginStatusChange = z;
                qrLoginResult.setResultCode(0);
                QrLoginActivity.this.t.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
                QrLoginActivity qrLoginActivity = QrLoginActivity.this;
                qrLoginActivity.b(qrLoginActivity.s);
            }
        }, this.r, false);
    }
}
