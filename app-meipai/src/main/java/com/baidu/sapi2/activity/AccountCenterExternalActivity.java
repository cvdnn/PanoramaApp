package com.baidu.sapi2.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback.Result;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.utils.Log;

public class AccountCenterExternalActivity extends AccountCenterActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String G = "AccountCenterExternalActivity";
    public String H;

    /* access modifiers changed from: private */
    public void h() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    /* access modifiers changed from: private */
    public void i() {
        Intent intent = new Intent(this, AccountCenterActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("action", SlideActiviy.SLIDE_ACTION_QUIT);
        PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
        startActivity(intent);
    }

    public void finishActivity() {
        super.finish();
    }

    public void loadAccountCenter(String str) {
        String stringExtra = getIntent().getStringExtra("extra_external_url");
        this.H = stringExtra;
        this.sapiWebView.loadUrl(stringExtra);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            i();
            this.loginStatusChange = true;
        }
    }

    public void onBottomBackBtnClick() {
        h();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(G, "AccountCenterExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                AccountCenterExternalActivity.this.h();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AccountCenterExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new OnSlidePageFinishCallback() {
            public void onFinish(String str) {
                if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str)) {
                    Intent intent = new Intent(AccountCenterExternalActivity.this, AccountCenterActivity.class);
                    intent.setFlags(67108864);
                    AccountCenterExternalActivity.this.startActivity(intent);
                }
                if (SlideActiviy.SLIDE_ACTION_QUIT.equals(str)) {
                    AccountCenterExternalActivity.this.i();
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SwitchAccountCallback() {
            public void onAccountSwitch(Result result) {
                AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO == null || !accountCenterDTO.handleLogin || accountCenterCallback == null) {
                    Intent intent = new Intent(AccountCenterExternalActivity.this, LoginActivity.class);
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
                    AccountCenterExternalActivity.this.startActivityForResult(intent, 1004);
                    return;
                }
                AnonymousClass1 r1 = new AccountCenterResult() {
                    public void loginSuc() {
                        super.loginSuc();
                        AccountCenterExternalActivity.this.i();
                        AccountCenterExternalActivity.this.loginStatusChange = true;
                    }
                };
                if (result.switchAccountType == 1) {
                    r1.preSetUserName = result.userName;
                }
                if (result.switchAccountType == 2) {
                    r1.preSetUserName = result.displayName;
                    r1.encryptedId = result.encryptedUid;
                }
                r1.setResultCode(-10001);
                r1.setResultMsg("请登录");
                accountCenterCallback.onFinish(r1);
            }
        });
    }

    public void onLeftBtnClick() {
        h();
    }
}
