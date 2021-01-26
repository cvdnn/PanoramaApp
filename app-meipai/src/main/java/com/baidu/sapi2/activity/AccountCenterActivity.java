package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.AccountChangeCallback;
import com.baidu.sapi2.SapiWebView.AccountDestoryCallback;
import com.baidu.sapi2.SapiWebView.AccountDestoryCallback.AccountDestoryResult;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback.AccountFreezeResult;
import com.baidu.sapi2.SapiWebView.BdussChangeCallback;
import com.baidu.sapi2.SapiWebView.CoverWebBdussCallback;
import com.baidu.sapi2.SapiWebView.CoverWebBdussResult;
import com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback.Result;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import e.c.c.a.d;
import e.c.c.a.f;
import e.c.c.a.g;
import java.util.ArrayList;
import java.util.List;

public class AccountCenterActivity extends SlideActiviy {
    public static final String A = "AccountCenterActivity";
    public static final String B = "AccountCenterActivity";
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    public List<PassNameValuePair> C;
    public String D;
    public String E;
    public AccountCenterResult F = new AccountCenterResult();

    /* access modifiers changed from: private */
    public void g() {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() {
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onFinish() {
            }

            public void onStart() {
            }

            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                    accountCenterCallback.onBdussChange();
                }
            }
        }, true);
    }

    public void configTitle() {
        setTitleText(g.sapi_sdk_title_account_center);
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

    public void finishActivityAfterSlideOver() {
        if ("AccountCenterActivity".equals(getClass().getSimpleName())) {
            this.F.setResultCode(-301);
            this.F.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            a(this.F);
            return;
        }
        super.finish();
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAccountCenterDTO();
    }

    public void init() {
        super.init();
        AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
        if (accountCenterDTO == null) {
            this.F.setResultCode(-204);
            this.F.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            a(this.F);
            return;
        }
        this.D = accountCenterDTO.bduss;
        this.E = accountCenterDTO.refer;
        List<PassNameValuePair> list = accountCenterDTO.paramsList;
        this.C = list;
        if (list != null) {
            list.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
        }
    }

    public void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                    SapiWebView sapiWebView = accountCenterActivity.sapiWebView;
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountCenter(accountCenterActivity.C, null, AccountCenterActivity.this.E);
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountCenterActivity.this.sapiWebView != null) {
                        String str = (String) getTplStokenResult.tplStokenMap.get("pp");
                        AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                        accountCenterActivity.sapiWebView.loadAccountCenter(accountCenterActivity.C, str, AccountCenterActivity.this.E);
                    }
                }
            }, str, arrayList);
            return;
        }
        this.F.setResultCode(-204);
        this.F.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
        a(this.F);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            String stringExtra = intent.getStringExtra("bduss");
            this.D = stringExtra;
            loadAccountCenter(stringExtra);
            this.loginStatusChange = true;
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        this.sapiWebView.back();
    }

    public void onClose() {
        super.onClose();
        this.F.setResultCode(-301);
        this.F.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        a(this.F);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.F.setResultCode(-202);
            this.F.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            a(this.F);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    public void onNewIntent(Intent intent) {
        String str;
        super.onNewIntent(intent);
        setIntent(intent);
        String str2 = A;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" onNewintent");
        Log.d(str2, sb.toString());
        if (AccountCenterActivity.class.getSimpleName().equals(getClass().getSimpleName())) {
            if (intent == null) {
                str = "";
            } else {
                str = intent.getStringExtra("action");
            }
            String str3 = A;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this);
            sb2.append(" slide action is ");
            sb2.append(str);
            Log.d(str3, sb2.toString());
            if (SlideActiviy.SLIDE_ACTION_QUIT.equals(str)) {
                finishActivityAfterSlideOver();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        final AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AccountCenterActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AccountCenterActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AccountCenterActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SwitchAccountCallback() {
            public void onAccountSwitch(Result result) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO == null || !accountCenterDTO.handleLogin || accountCenterCallback == null) {
                    Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
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
                    AccountCenterActivity.this.startActivityForResult(intent, 1004);
                    return;
                }
                AnonymousClass1 r0 = new AccountCenterResult() {
                    public void loginSuc() {
                        super.loginSuc();
                        AccountCenterActivity.this.D = SapiContext.getInstance().getCurrentAccount().bduss;
                        AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                        accountCenterActivity.loadAccountCenter(accountCenterActivity.D);
                        AccountCenterActivity.this.loginStatusChange = true;
                    }
                };
                if (result.switchAccountType == 1) {
                    r0.preSetUserName = result.userName;
                }
                if (result.switchAccountType == 2) {
                    r0.preSetUserName = result.displayName;
                    r0.encryptedId = result.encryptedUid;
                }
                r0.setResultCode(-10001);
                r0.setResultMsg("请登录");
                accountCenterCallback.onFinish(r0);
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new CoverWebBdussCallback() {
            public void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult) {
                if (!TextUtils.isEmpty(str) && !str.equals(AccountCenterActivity.this.D)) {
                    coverWebBdussResult.setWebBduss(AccountCenterActivity.this.D);
                }
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new AccountDestoryCallback() {
            public void onAccountDestory(AccountDestoryResult accountDestoryResult) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                    SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountDestory = true;
                AccountCenterActivity.this.a(accountCenterResult);
            }
        });
        this.sapiWebView.setAccountChangeCallback(new AccountChangeCallback() {
            public void onAccountChange() {
                AccountCenterCallback accountCenterCallback = accountCenterCallback;
                if (accountCenterCallback != null) {
                    accountCenterCallback.onBdussChange();
                }
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new AccountFreezeCallback() {
            public void onAccountFreeze(AccountFreezeResult accountFreezeResult) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                    SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountFreeze = true;
                AccountCenterActivity.this.a(accountCenterResult);
            }
        });
        this.sapiWebView.setBdussChangeCallback(new BdussChangeCallback() {
            public void onBdussChange() {
                AccountCenterActivity.this.g();
            }
        });
        loadAccountCenter(this.D);
    }

    /* access modifiers changed from: private */
    public void a(AccountCenterResult accountCenterResult) {
        SocialLoginBase.setWXLoginCallback(null);
        if (PassportSDK.getInstance().getAccountCenterCallback() != null) {
            if (accountCenterResult == null) {
                accountCenterResult = new AccountCenterResult();
            }
            PassportSDK.getInstance().getAccountCenterCallback().onFinish(accountCenterResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
