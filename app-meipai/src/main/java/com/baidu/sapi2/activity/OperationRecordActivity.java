package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.result.SapiResult;
import e.c.c.a.f;
import e.c.c.a.g;

public class OperationRecordActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public SapiResult r = new SapiResult();
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
        SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
        if (sapiWebCallback != null) {
            sapiWebCallback.onFinish(this.r);
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
        setTitleText(g.sapi_sdk_title_operation_record);
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                OperationRecordActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                OperationRecordActivity.this.onClose();
            }
        });
        this.sapiWebView.loadOperationRecord(this.s);
    }
}
