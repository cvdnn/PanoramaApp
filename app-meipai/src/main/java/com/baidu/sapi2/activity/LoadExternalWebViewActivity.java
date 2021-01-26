package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback.AccountFreezeResult;
import com.baidu.sapi2.SapiWebView.CoverWebBdussCallback;
import com.baidu.sapi2.SapiWebView.CoverWebBdussResult;
import com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.SapiWebView.PreFillUserNameCallback;
import com.baidu.sapi2.SapiWebView.PreFillUserNameCallback.PreFillUserNameResult;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback.Result;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.utils.enums.AccountType;
import e.c.c.a.f;
import java.util.ArrayList;

public class LoadExternalWebViewActivity extends BaseActivity {
    public static final String EXTRA_BUSINESS_FROM = "business_from";
    public static final String EXTRA_BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String EXTRA_BUSINESS_TYPE = "business_type";
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final int REQUEST_CODE_LOGIN = 2001;
    public static final String RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE = "business_account_freeze";
    public static final String RESULT_BUSINESS_TYPE_PRE_SET_UNAME = "business_pre_set_username";
    public String r;
    public String s;
    public String t;
    public AuthorizationListener u = new AuthorizationListener() {
        public void onFailed(int i2, String str) {
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.t)) {
                new c().a(PassportSDK.getInstance().getOneKeyLoginCallback(), -103, (String) null);
            }
            LoadExternalWebViewActivity.this.setResult(0);
            LoadExternalWebViewActivity.this.finish();
        }

        public void onSuccess(AccountType accountType) {
            if ("business_from_one_key_login".equals(LoadExternalWebViewActivity.this.t)) {
                OneKeyLoginCallback oneKeyLoginCallback = PassportSDK.getInstance().getOneKeyLoginCallback();
                OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                oneKeyLoginResult.setResultCode(0);
                if (oneKeyLoginCallback != null) {
                    oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
                }
            }
            Intent intent = new Intent();
            intent.putExtra("account_type", accountType.getType());
            LoadExternalWebViewActivity.this.setResult(-1, intent);
            LoadExternalWebViewActivity.this.finish();
        }
    };

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            finish();
        } else {
            this.sapiWebView.goBack();
        }
    }

    public void configTitle() {
        setTitleText(this.r);
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        if (this.configuration.showBottomBack) {
            setLeftBtnDrawable(null, null, null, null);
        }
    }

    public void finish() {
        super.finish();
        if (PassportSDK.getInstance().getExtendSysWebViewMethodCallback() != null) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
            extendSysWebViewMethodResult.params.put("retCode", Integer.valueOf(-301));
            extendSysWebViewMethodResult.params.put("retMsg", SapiResult.ERROR_MSG_PROCESSED_END);
            PassportSDK.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
        }
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebLoginDTO();
    }

    public void init() {
        super.init();
        this.r = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
        this.s = getIntent().getStringExtra("extra_external_url");
        this.t = getIntent().getStringExtra(EXTRA_BUSINESS_FROM);
        if (TextUtils.isEmpty(this.s)) {
            setResult(0);
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2001 && i3 == -1) {
            this.loginStatusChange = true;
            setResult(-1, new Intent());
            finish();
        }
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

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setAuthorizationListener(this.u);
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                LoadExternalWebViewActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    LoadExternalWebViewActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new CoverWebBdussCallback() {
            public void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                if (currentAccount != null && !TextUtils.isEmpty(str) && !str.equals(currentAccount.bduss)) {
                    coverWebBdussResult.setWebBduss(currentAccount.bduss);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SwitchAccountCallback() {
            public void onAccountSwitch(Result result) {
                Intent intent = new Intent(LoadExternalWebViewActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER);
                int i2 = result.switchAccountType;
                String str = "username";
                if (i2 == 1) {
                    intent.putExtra(str, result.userName);
                } else if (i2 == 2) {
                    int i3 = result.loginType;
                    String str2 = LoginActivity.EXTRA_LOGIN_TYPE;
                    if (i3 == 0) {
                        intent.putExtra(str2, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                    } else {
                        intent.putExtra(str2, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    }
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                    if (!TextUtils.isEmpty(result.displayName)) {
                        intent.putExtra(str, result.displayName);
                    }
                    intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                }
                LoadExternalWebViewActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new AccountFreezeCallback() {
            public void onAccountFreeze(AccountFreezeResult accountFreezeResult) {
                Intent intent = new Intent();
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
                LoadExternalWebViewActivity.this.finish();
            }
        });
        this.sapiWebView.setPreFillUserNameCallback(new PreFillUserNameCallback() {
            public void onPreFillUserName(PreFillUserNameResult preFillUserNameResult) {
                Intent intent = new Intent();
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME);
                intent.putExtra("username", preFillUserNameResult.userName);
                LoadExternalWebViewActivity.this.setResult(-1, intent);
            }
        });
        this.sapiWebView.setWebviewPageFinishCallback(new WebviewPageFinishCallback() {
            public void onFinish(String str) {
                if (PassportSDK.getInstance().getExtendSysWebViewMethodCallback() != null) {
                    ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                    extendSysWebViewMethodResult.params.put("result", str);
                    PassportSDK.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", webLoginDTO.statExtra));
        }
        this.sapiWebView.loadExternalUrl(this.s, arrayList);
    }
}
