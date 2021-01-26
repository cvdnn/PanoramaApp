package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks.RealNameStatusCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import e.c.c.a.f;
import e.c.c.a.g;
import java.util.ArrayList;

public class AccountRealNameActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_NEED_CB_KEY = "EXTRA_NEED_CB_KEY";
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public String r;
    public String s;
    public boolean t;
    public AccountRealNameResult u = new AccountRealNameResult();

    private void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void f() {
        if (!TextUtils.isEmpty(this.r)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                    SapiWebView sapiWebView = accountRealNameActivity.sapiWebView;
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountRealName(null, accountRealNameActivity.s, AccountRealNameActivity.this.t);
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountRealNameActivity.this.sapiWebView != null) {
                        String str = (String) getTplStokenResult.tplStokenMap.get("pp");
                        AccountRealNameActivity accountRealNameActivity = AccountRealNameActivity.this;
                        accountRealNameActivity.sapiWebView.loadAccountRealName(str, accountRealNameActivity.s, AccountRealNameActivity.this.t);
                    }
                }
            }, this.r, arrayList);
            return;
        }
        Toast.makeText(this, getString(g.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAccountRealNameCallback() != null) {
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish();
            PassportSDK.getInstance().getAccountRealNameCallback().onFinish(this.u);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getRealNameDTO();
    }

    public void init() {
        super.init();
        this.r = getIntent().getStringExtra("EXTRA_BDUSS");
        this.s = getIntent().getStringExtra(EXTRA_SCENE);
        this.t = getIntent().getBooleanExtra(EXTRA_NEED_CB_KEY, false);
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        AccountRealNameResult accountRealNameResult = this.u;
        if (accountRealNameResult.juniorRealNameSuc || accountRealNameResult.seniorRealNameSuc) {
            this.u.setResultCode(0);
            this.u.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
        } else {
            accountRealNameResult.setResultCode(-301);
            this.u.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        }
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
            this.u.setResultCode(-202);
            this.u.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
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
        setTitleText(g.sapi_sdk_title_real_name);
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                SapiWebView sapiWebView = AccountRealNameActivity.this.sapiWebView;
                if (sapiWebView == null || !sapiWebView.canGoBack()) {
                    AccountRealNameActivity.this.onClose();
                } else {
                    AccountRealNameActivity.this.sapiWebView.goBack();
                }
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AccountRealNameActivity.this.onClose();
            }
        });
        this.sapiWebView.setRealNameStateCallback(new RealNameStatusCallback() {
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                AccountRealNameActivity.this.u = accountRealNameResult;
            }
        });
        f();
    }
}
