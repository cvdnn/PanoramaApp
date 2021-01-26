package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.BindWidgetCallback;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import e.c.c.a.f;
import java.util.Collections;

public class BindWidgetActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_BIND_WIDGET_ACTION = "EXTRA_BIND_WIDGET_ACTION";
    public static final int REQUEST_CODE_LOGIN = 200001;
    public BindWidgetAction r;
    public String s;
    public WebBindWidgetResult t = new WebBindWidgetResult() {
        public void loginSuc() {
            super.loginSuc();
            BindWidgetActivity.this.onClose();
        }
    };

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
        if (PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
            PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(this.t);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebBindWidgetDTO();
    }

    public void init() {
        super.init();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 200001 && i3 == -1) {
            onClose();
        }
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
            this.r = (BindWidgetAction) getIntent().getSerializableExtra(EXTRA_BIND_WIDGET_ACTION);
            String stringExtra = getIntent().getStringExtra("EXTRA_BDUSS");
            this.s = stringExtra;
            if (this.r == null || TextUtils.isEmpty(stringExtra)) {
                this.t.setResultCode(-204);
                this.t.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                finishActivity();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            onClose();
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
        setTitleText(this.r.getName());
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                BindWidgetActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                BindWidgetActivity.this.onClose();
            }
        });
        this.sapiWebView.setBindWidgetCallback(new BindWidgetCallback() {
            public void onPhoneNumberExist(String str) {
                SapiAccountManager.getInstance().getSapiConfiguration().presetPhoneNumber = str;
                if (!PassportSDK.getInstance().getWebBindWidgetDTO().handleLogin || PassportSDK.getInstance().getWebBindWidgetCallback() == null) {
                    Intent intent = new Intent(BindWidgetActivity.this, LoginActivity.class);
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER);
                    BindWidgetActivity.this.startActivityForResult(intent, BindWidgetActivity.REQUEST_CODE_LOGIN);
                    return;
                }
                BindWidgetActivity.this.t.setResultCode(-10001);
                BindWidgetActivity.this.t.setResultMsg("请登录");
                PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(BindWidgetActivity.this.t);
            }
        });
        this.sapiWebView.loadBindWidget(this.r, this.s, null, true, Collections.singletonList(SapiWebView.EXTRA_BIND_WIDGET_CONFLICT_DETECT));
    }
}
