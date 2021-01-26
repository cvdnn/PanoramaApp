package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebLoginDTO.Config;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.share.p;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import e.c.c.a.f;
import java.util.ArrayList;
import org.json.JSONObject;

public class ShareActivity extends BaseActivity {
    public static final String r = "share_fail_reason";
    public static final String s = "share_account";
    public String t = "0";
    public p u = new p();
    public WebAuthListener v;
    public String w;

    /* access modifiers changed from: private */
    public void h() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            this.u.setResultCode(p.l);
            g();
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        SapiStatUtil.statShareV2OauthSuc();
        if (this.t.equals("1")) {
            SapiStatUtil.statShareV2ActiveLoginSuc();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("share_account", currentAccount);
        bundle.putInt("SDK_VERSION", SapiAccountManager.VERSION_CODE);
        bundle.putString("PKG", getPackageName());
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void i() {
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        Config config = new Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        this.v = new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                ShareActivity.this.u.setResultCode(p.f2963g);
                ShareActivity.this.u.setResultMsg(String.format(p.f2957a, new Object[]{ShareActivity.this.w}));
                ShareActivity.this.g();
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
                SapiWebView sapiWebView = ShareActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.reload();
                }
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
            }
        };
        PassportSDK.getInstance().startLogin(this, this.v, webLoginDTO);
    }

    /* access modifiers changed from: private */
    public void j() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.u.setResultCode(p.f2963g);
            this.u.setResultMsg(String.format(p.f2957a, new Object[]{this.w}));
            g();
            return;
        }
        this.sapiWebView.goBack();
    }

    public void finish() {
        super.finish();
        SapiStatUtil.statShareV2Invoke(this.t);
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        j();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (f()) {
                SapiStatUtil.statShareV2Oauth();
                if (e()) {
                    init();
                    setupViews();
                }
            }
        } catch (Throwable th) {
            reportWebviewError(th);
            this.u.setResultCode(p.l);
            g();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        j();
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                ShareActivity.this.j();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        try {
            jSONObject.put("errno", "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            jSONObject.put("currentAPPName", pkgIconAndName[1]);
            this.w = pkgIconAndName[1];
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            jSONObject.put("originAPPName", pkgIconAndName2[1]);
            if (currentAccount == null) {
                this.t = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put("session_id", getIntent().getStringExtra(m.f2941b));
            jSONObject.put("trace_id", getIntent().getStringExtra(m.f2940a));
        } catch (Exception e2) {
            Log.e(e2);
        }
        AnonymousClass2 r1 = new ShareV2LoginParams() {
            public void onError() {
                if (!ShareActivity.this.t.equals("1")) {
                    ShareActivity.this.t = "2";
                }
                ShareActivity.this.i();
            }

            public void onSuccess() {
                ShareActivity.this.h();
            }
        };
        r1.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(r1);
        this.sapiWebView.loadShareV2Login();
    }

    private boolean e() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            this.u.setResultCode(p.f2964h);
            g();
            return false;
        } else if (new m().a(this, callingPackage)) {
            return true;
        } else {
            this.u.setResultCode(p.f2964h);
            g();
            return false;
        }
    }

    private boolean f() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            return true;
        }
        Log.e("pass sdk have not been initialized", new Object[0]);
        this.u.setResultCode(p.k);
        g();
        return false;
    }

    /* access modifiers changed from: private */
    public void g() {
        SapiStatUtil.statShareV2OtherFail(this.u.getResultCode());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("share_fail_reason", this.u.getResultMsg());
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }
}
