package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks.CurrentAccountBdussExpiredCallback;
import com.baidu.sapi2.SapiJsCallBacks.GrantWebCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebLoginDTO.Config;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.t;
import e.a.a.a.a;
import e.c.c.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrantWebActivity extends BaseActivity {
    public static final String r = "GrantWebActivity";
    public static final String s = "openapp";
    public static final String t = "/passport/grantweb";
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            t.a("grant_web_cancel", (Map<String, String>) new HashMap<String,String>());
            finish();
            return;
        }
        this.sapiWebView.goBack();
    }

    private boolean f() {
        Intent intent = getIntent();
        String scheme = intent.getScheme();
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null) {
                String host = data.getHost();
                String path = data.getPath();
                String packageName = SapiAccountManager.getInstance().getConfignation().getContext().getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    packageName = "";
                }
                if (s.equals(scheme) && packageName.equals(host) && t.equals(path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean g() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            return true;
        }
        Log.e(Log.TAG, "pass sdk has not been initialized");
        return false;
    }

    /* access modifiers changed from: private */
    public void h() {
        boolean z;
        if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
            if (TextUtils.isEmpty(this.w)) {
                this.w = this.v;
            }
            z = SapiAccountManager.getCheckUrlIsAvailablelister().onCheckUrlIsAvailable(this.w);
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getConfignation().environment.getWap());
        sb.append("/passport/login");
        String sb2 = sb.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("client", SapiDeviceInfo.f3010c);
        hashMap.put("clientfrom", SapiAccountService.f2213b);
        hashMap.put("suppcheck", "1");
        hashMap.put("adapter", "3");
        hashMap.put("channel_id", this.u);
        hashMap.put("wap_tpl", this.y);
        hashMap.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
        hashMap.put("u", this.v);
        String str = "true";
        String str2 = "force";
        if (!z || str.equals(this.x)) {
            hashMap.put(str2, str);
        } else {
            hashMap.put(str2, "false");
        }
        StringBuilder a2 = a.a(sb2);
        a2.append(SapiUtils.mapToUrlParams(hashMap, false));
        a2.append("#app_auth");
        String sb3 = a2.toString();
        Log.d(r, a.a("url = ", sb3));
        this.sapiWebView.loadUrl(sb3);
    }

    public void init() {
        super.init();
        Uri data = getIntent().getData();
        if (data != null) {
            this.u = data.getQueryParameter("channel_id");
            this.v = data.getQueryParameter("u");
            this.w = data.getQueryParameter("nu");
            this.x = data.getQueryParameter("force");
            this.y = data.getQueryParameter("wap_tpl");
        }
        if (TextUtils.isEmpty(this.u)) {
            finish();
        }
    }

    public void onBottomBackBtnClick() {
        e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (!g() || !f()) {
                finish();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th) {
            Log.e(th);
            finish();
        }
    }

    public void onLeftBtnClick() {
        e();
    }

    public void onNewIntent(Intent intent) {
        String str = r;
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" onNewIntent");
        Log.d(str, sb.toString());
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            b(false);
        } else {
            h();
        }
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                GrantWebActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                GrantWebActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
                Log.d(GrantWebActivity.r, "GrantWebPage login failed");
                GrantWebActivity.this.finish();
            }

            public void onSuccess(AccountType accountType) {
                GrantWebActivity.this.h();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
            }
        });
        this.sapiWebView.setGrantWebCallback(new GrantWebCallback() {
            public void onGrant(int i2) {
                if (i2 == 0) {
                    Log.d(GrantWebActivity.r, "after grant web, then back to wap");
                    GrantWebActivity.this.finish();
                    return;
                }
                Log.d(GrantWebActivity.r, "after grant web, still stay in app");
                if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                    if (TextUtils.isEmpty(GrantWebActivity.this.w)) {
                        GrantWebActivity grantWebActivity = GrantWebActivity.this;
                        grantWebActivity.w = grantWebActivity.v;
                    }
                    SapiAccountManager.getCheckUrlIsAvailablelister().handleWebPageUrl(GrantWebActivity.this.w);
                }
                GrantWebActivity.this.finish();
            }
        });
        this.sapiWebView.setCurrentAccountBdussExpiredCallback(new CurrentAccountBdussExpiredCallback() {
            public void onBdussExpired() {
                GrantWebActivity.this.b(true);
            }
        });
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            b(false);
        } else {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        Config config = new Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        webLoginDTO.businessType = 2005;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (z && currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        PassportSDK.getInstance().startLogin(this, new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                GrantWebActivity.this.finish();
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                GrantWebActivity.this.h();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }
        }, webLoginDTO);
    }
}
