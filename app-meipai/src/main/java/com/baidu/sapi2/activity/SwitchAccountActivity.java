package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback.Result;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import e.a.a.a.a;
import e.c.c.a.d;
import e.c.c.a.f;
import e.c.c.a.g;
import java.util.ArrayList;

public class SwitchAccountActivity extends BaseActivity {
    public static final String r = "SwitchAccountActivity";
    public static final String s = "https://wappass.baidu.com/v6/changeAccount";
    public WebAuthResult t = new WebAuthResult();
    public WebAuthListener u;
    public SwitchAccountDTO v;

    /* access modifiers changed from: private */
    public void e() {
        f();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
            return;
        }
        String f2 = f();
        if (f2 == null || !f2.startsWith(s)) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private String f() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            WebBackForwardList copyBackForwardList = sapiWebView.copyBackForwardList();
            if (!(copyBackForwardList == null || copyBackForwardList.getSize() == 0)) {
                WebHistoryItem currentItem = copyBackForwardList.getCurrentItem();
                if (currentItem != null) {
                    return currentItem.getUrl();
                }
            }
        }
        return null;
    }

    public void configTitle() {
        setTitleText(g.sapi_sdk_title_switch);
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    public void init() {
        super.init();
        this.u = PassportSDK.getInstance().getWebAuthListener();
        SwitchAccountDTO switchAccountDTO = PassportSDK.getInstance().getSwitchAccountDTO();
        this.v = switchAccountDTO;
        if (switchAccountDTO == null || this.u == null) {
            this.t.setResultCode(-204);
            a(this.t);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1 && this.sapiWebView != null) {
            ArrayList arrayList = new ArrayList();
            a.a("changeAccountSuc", "1", arrayList);
            this.sapiWebView.loadSwitchAccount(arrayList);
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        this.t.setResultCode(-301);
        a(this.t);
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
            a(this.t);
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
        SapiWebView sapiWebView = this.sapiWebView;
        sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
        sapiWebView.showLinkAccount = this.v.supportQueryAssociatedAccount;
        sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                SwitchAccountActivity.this.onClose();
            }
        });
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                SwitchAccountActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
                SwitchAccountActivity.this.a(i2, str);
            }

            public void onSuccess(AccountType accountType) {
                super.onSuccess();
                SwitchAccountActivity.this.a(accountType);
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SwitchAccountCallback() {
            public void onAccountSwitch(Result result) {
                Intent intent = new Intent(SwitchAccountActivity.this, LoginActivity.class);
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
                if (!TextUtils.isEmpty(result.extraJson)) {
                    intent.putExtra("extraJson", result.extraJson);
                }
                SwitchAccountActivity.this.startActivityForResult(intent, 1004);
            }
        });
        this.sapiWebView.loadSwitchAccount(new ArrayList());
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType) {
        this.t.setResultCode(0);
        WebAuthResult webAuthResult = this.t;
        webAuthResult.accountType = accountType;
        this.u.onSuccess(webAuthResult);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        this.t.setResultCode(i2);
        this.t.setResultMsg(str);
        this.u.onFailure(this.t);
    }

    private void a(WebAuthResult webAuthResult) {
        WebAuthListener webAuthListener = this.u;
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
