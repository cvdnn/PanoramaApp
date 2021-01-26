package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks.DirectedLoginParams;
import com.baidu.sapi2.SapiJsCallBacks.JoinLoginParams;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback;
import com.baidu.sapi2.SapiWebView.LoadExternalWebViewResult;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.ShareAccountClickCallback;
import com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback;
import com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback.Result;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebLoginDTO.Config;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.share.m.a;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import e.c.c.a.e;
import e.c.c.a.f;
import e.c.c.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static final int r = 2004;
    public static final int s = 2005;
    public static boolean supportShareLogin = true;
    public String A;
    public List<PassNameValuePair> B;
    public Result C;
    public AuthorizationListener D = new AuthorizationListener() {
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.beforeSuccess(sapiAccount);
            }
        }

        public void onFailed(int i2, String str) {
            if (LoginActivity.this.w == 2003) {
                LoginActivity.this.setResult(0);
                return;
            }
            LoginActivity.this.u.setResultCode(i2);
            LoginActivity.this.u.setResultMsg(str);
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.a(loginActivity.u);
        }

        public boolean onForgetPwd() {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
            return true;
        }

        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            LoginActivity.this.a(accountType, false);
        }
    };
    public SapiWebView sapiWebView;
    public boolean t = false;
    public WebAuthResult u = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            LoginActivity.this.b(true);
        }

        public void finishActivity(boolean z) {
            super.finishActivity();
            LoginActivity.this.b(false);
        }
    };
    public boolean v;
    public int w;
    public String x;
    public String y;
    public String z;

    private boolean e() {
        if (this.w != 2003 && PassportSDK.getInstance().getWebBindWidgetDTO() == null && PassportSDK.getInstance().getAccountCenterDTO() == null) {
            return true;
        }
        return false;
    }

    @TargetApi(5)
    public void finish() {
        super.finish();
        if (this.w == 2005) {
            startActivity(new Intent(this, GrantWebActivity.class));
        }
        SocialLoginBase.setWXLoginCallback(null);
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebLoginDTO();
    }

    public void init() {
        super.init();
        this.u.activity = this;
        this.v = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        int i4;
        super.onActivityResult(i2, i3, intent);
        new m().a(new a() {
            public void onSuccess() {
                LoginActivity.this.a(AccountType.NORMAL, false);
            }
        }, i2, i3, intent, this.B);
        if ((i2 == 2001 && i3 == 1001) || this.t) {
            a((AccountType) null, true);
            this.t = false;
        } else if (i2 == 2005) {
            if (i3 == -1) {
                String str2 = "";
                if (intent != null) {
                    str2 = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                    str = intent.getStringExtra("username");
                } else {
                    str = str2;
                }
                if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str2)) {
                    this.sapiWebView.preSetUserName(str);
                } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str2)) {
                    this.u.isAccountFreeze = true;
                } else {
                    if (intent == null) {
                        i4 = AccountType.UNKNOWN.getType();
                    } else {
                        i4 = intent.getIntExtra("account_type", AccountType.UNKNOWN.getType());
                    }
                    a(AccountType.getAccountType(i4), false);
                }
            }
        } else if (i2 == 2004) {
            Result result = this.C;
            if (result != null) {
                result.onFinish();
            }
        }
    }

    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    public void onClose() {
        super.onClose();
        this.u.setResultCode(-301);
        this.u.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        a(this.u);
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
            a(this.u);
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        this.B = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
        this.w = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.x = getIntent().getStringExtra("username");
        this.y = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
        this.z = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
        this.A = getIntent().getStringExtra("extraJson");
        SapiWebView sapiWebView2 = (SapiWebView) findViewById(e.sapi_webview);
        this.sapiWebView = sapiWebView2;
        sapiWebView2.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                LoginActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.D);
        this.sapiWebView.setSocialLoginHandler(new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = PassportSDK.getInstance().getThirdPartyService();
                LoginActivity loginActivity = LoginActivity.this;
                thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.w, LoginActivity.this.A);
                SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() {
                    public void onResult(int i2, Intent intent) {
                        LoginActivity.this.t = true;
                    }
                });
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new LoadExternalWebViewCallback() {
            public void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(LoginActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                LoginActivity.this.startActivityForResult(intent, 2005);
            }
        });
        if (supportShareLogin) {
            this.sapiWebView.setShareAccountClickCallback(new ShareAccountClickCallback() {
                public void onClick(String str, String str2, String str3, String str4) {
                    m mVar = new m();
                    LoginActivity loginActivity = LoginActivity.this;
                    mVar.a(loginActivity, str, str2, str3, str4, loginActivity.B);
                }
            });
        }
        this.sapiWebView.setSystemUpwardSmsCallback(new SystemUpwardSmsCallback() {
            public void onResult(Result result) {
                LoginActivity.this.C = result;
                if (result != null) {
                    StringBuilder a2 = e.a.a.a.a.a("smsto:");
                    a2.append(result.destination);
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(a2.toString()));
                    intent.putExtra("sms_body", result.content);
                    if (intent.resolveActivity(LoginActivity.this.getPackageManager()) != null) {
                        LoginActivity.this.startActivityForResult(intent, 2004);
                        return;
                    }
                    LoginActivity loginActivity = LoginActivity.this;
                    Toast.makeText(loginActivity, loginActivity.getString(g.sapi_sdk_account_center_please_download_message_app), 1).show();
                }
            }
        });
        JoinLoginParams joinLoginParams = new JoinLoginParams();
        if (!TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.x)) {
            if (webLoginDTO == null) {
                webLoginDTO = new WebLoginDTO();
            }
            webLoginDTO.encryptedId = this.z;
            webLoginDTO.preSetUname = this.x;
        }
        if (webLoginDTO != null) {
            if ((!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid)) && !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                DirectedLoginParams directedLoginParams = new DirectedLoginParams();
                directedLoginParams.uid = webLoginDTO.uid;
                directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                directedLoginParams.displayname = webLoginDTO.preSetUname;
                this.B.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                this.sapiWebView.setDirectedLoginParams(directedLoginParams);
            }
            if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                this.B.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
            }
            SapiWebView sapiWebView3 = this.sapiWebView;
            sapiWebView3.shareV2Disable = webLoginDTO.shareV2Disable;
            joinLoginParams.agreement = webLoginDTO.agreement;
            sapiWebView3.setHideSuccessTip(webLoginDTO.hideSuccessTip);
            Config config = webLoginDTO.config;
            if (config != null) {
                this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
            }
        }
        if (!TextUtils.isEmpty(this.A)) {
            try {
                JSONObject jSONObject = new JSONObject(this.A);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    this.B.add(new PassNameValuePair(str, jSONObject.getString(str)));
                }
            } catch (JSONException e2) {
                Log.e(e2);
            }
        }
        String str2 = this.y;
        String str3 = WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT;
        if (str3.equals(str2)) {
            joinLoginParams.hasThirdAccount = true;
        } else {
            joinLoginParams.hasThirdAccount = false;
        }
        this.sapiWebView.setJoinLoingParams(joinLoginParams);
        if (!str3.equals(this.y)) {
            if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.y)) {
                if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.y)) {
                    setTitleText(g.sapi_sdk_title_sms_login);
                    this.sapiWebView.loadLogin(1, this.B);
                    return;
                }
                if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.y)) {
                    this.sapiWebView.loadLogin(6, this.B);
                    return;
                }
                if (!TextUtils.isEmpty(this.x)) {
                    this.B.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.x));
                }
                setTitleText(g.sapi_sdk_title_login);
                this.sapiWebView.loadLogin(this.B);
                return;
            }
        }
        this.sapiWebView.loadLogin(4, this.B);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        finish();
        if (e() && z2) {
            PassportSDK.getInstance().release();
        }
    }

    /* access modifiers changed from: private */
    public void a(WebAuthResult webAuthResult) {
        if (this.w == 2003) {
            finish();
            return;
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        if (e()) {
            PassportSDK.getInstance().release();
        }
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType, boolean z2) {
        b bVar = new b();
        StringBuilder a2 = e.a.a.a.a.a(b.f3024a);
        a2.append(SapiUtils.getLastLoginType());
        bVar.a(a2.toString());
        if (this.w == 2003) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            Intent intent = new Intent();
            intent.putExtra("bduss", currentAccount.bduss);
            setResult(-1, intent);
            if (this.v) {
                finish();
            }
        } else if (z2) {
            finish();
            if (e()) {
                PassportSDK.getInstance().release();
            }
        } else {
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = this.u;
                webAuthResult.accountType = accountType;
                webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(this.u);
            }
            if (this.v) {
                finish();
                if (e()) {
                    PassportSDK.getInstance().release();
                }
            }
        }
    }
}
