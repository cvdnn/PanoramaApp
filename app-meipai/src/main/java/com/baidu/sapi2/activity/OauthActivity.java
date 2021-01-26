package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiJsCallBacks.BdOauthCallback;
import com.baidu.sapi2.SapiJsCallBacks.BdOauthLoginParams;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebLoginDTO.Config;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.views.LoadingDialog.Builder;
import com.baidu.sapi2.views.ViewUtility;
import com.sina.weibo.sdk.constant.WBConstants;
import e.a.a.a.a;
import e.c.c.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OauthActivity extends BaseActivity {
    public static final String A = "2.0.0";
    public static final int B = -201;
    public static final int C = -202;
    public static final int D = -204;
    public static final int E = -205;
    public static final int F = -208;
    public static final String r = "extra_calling_app_id";
    public static final String s = "extra_oauth_result_json";
    public static final String t = "extra_redirect_url";
    public static final String u = "extra_scope";
    public static final String v = "extra_oauth_type";
    public static final String w = "extra_qr_code_url";
    public static final String x = "extra_oauth_sdk_version";
    public static final String y = "extra_pass_sdk_version";
    public static final String z = "extra_oauth_state";
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public Dialog N;
    public int O = 0;
    public String P;
    public boolean Q;

    public void init() {
        super.init();
        this.G = getCallingPackage();
        Intent intent = getIntent();
        this.H = intent.getStringExtra(r);
        this.I = intent.getStringExtra(t);
        this.J = intent.getStringExtra(u);
        this.O = intent.getIntExtra(v, 0);
        this.P = intent.getStringExtra(w);
        this.K = intent.getStringExtra(z);
        this.L = intent.getStringExtra(x);
        if (TextUtils.isEmpty(this.G) || TextUtils.isEmpty(this.H) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.J)) {
            setResult(0, a(-202));
            finish();
            this.Q = true;
        }
        if (!TextUtils.isEmpty(this.P) && !a(this.P)) {
            setResult(0, a(-202));
            finish();
            this.Q = true;
        }
        String stringExtra = intent.getStringExtra(y);
        this.M = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && SapiUtils.versionCompareTo(this.M, SapiAccountManager.VERSION_NAME) > 0) {
            setResult(0, a((int) F));
            finish();
            this.Q = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            if (f()) {
                init();
                if (!this.Q) {
                    setupViews();
                }
            }
        } catch (Throwable unused) {
            setResult(0, a(-201));
            finish();
        }
    }

    public void onLeftBtnClick() {
        if (this.O == 1) {
            SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() {
                public void onFailure(QrAppLoginResult qrAppLoginResult) {
                }

                public void onFinish() {
                }

                public void onStart() {
                }

                public void onSuccess(QrAppLoginResult qrAppLoginResult) {
                }
            }, this.P, QrLoginAction.CANCEL.getName());
        }
        e();
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                OauthActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.setResult(0, oauthActivity.a(-205));
                OauthActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() {
            public void onFailed(int i2, String str) {
            }

            public void onSuccess() {
                OauthActivity.this.g();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
            }
        });
        AnonymousClass5 r0 = new BdOauthCallback() {
            public void onCallback(String str) {
                String str2 = str;
                String str3 = "openid";
                String str4 = SapiAccount.SAPI_ACCOUNT_EXTRA;
                Intent intent = new Intent();
                int f2 = OauthActivity.this.O;
                String str5 = OauthActivity.s;
                String str6 = "expires_in";
                String str7 = "expiresIn";
                String str8 = "access_token";
                String str9 = "accessToken";
                String str10 = "code";
                String str11 = "scope";
                String str12 = WXLoginActivity.KEY_BASE_RESP_STATE;
                if (f2 == 0) {
                    Map urlParamsToMap = SapiUtils.urlParamsToMap(str2.substring(str2.indexOf("#") + 1, str.length()));
                    String str13 = SapiUtils.f3014b;
                    if (urlParamsToMap.containsKey(str13)) {
                        OauthActivity oauthActivity = OauthActivity.this;
                        oauthActivity.setResult(0, oauthActivity.a(-204, (String) urlParamsToMap.get(str13)));
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("refreshToken", urlParamsToMap.get("refresh_token"));
                            jSONObject.put(str9, urlParamsToMap.get(str8));
                            jSONObject.put(str7, urlParamsToMap.get(str6));
                            jSONObject.put(str11, urlParamsToMap.get(str11));
                            jSONObject.put(str4, urlParamsToMap.get(str4));
                            jSONObject.put(str10, urlParamsToMap.get(str10));
                            jSONObject.put(str12, urlParamsToMap.get(str12));
                            intent.putExtra(str5, jSONObject.toString());
                            OauthActivity.this.setResult(-1, intent);
                        } catch (JSONException e2) {
                            Log.e(e2);
                            OauthActivity oauthActivity2 = OauthActivity.this;
                            oauthActivity2.setResult(0, oauthActivity2.a(-201));
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        int optInt = jSONObject2.optInt("errNo");
                        jSONObject2.optInt("msg");
                        if (optInt == -301) {
                            OauthActivity.this.setResult(0, OauthActivity.this.a(-205));
                            OauthActivity.this.finish();
                            return;
                        }
                        if (optInt != 400021) {
                            if (optInt != 400022) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(str9, jSONObject2.optString(str8));
                                jSONObject3.put(str3, jSONObject2.optString(str3));
                                jSONObject3.put(str7, jSONObject2.optString(str6));
                                jSONObject3.put(str11, OauthActivity.this.J);
                                jSONObject3.put(str10, jSONObject2.optString("authorization_code"));
                                jSONObject2.put(str12, jSONObject2.optString(str12));
                                intent.putExtra(str5, jSONObject3.toString());
                                OauthActivity.this.setResult(-1, intent);
                            }
                        }
                        OauthActivity.this.h();
                        return;
                    } catch (JSONException e3) {
                        Log.e(e3);
                        OauthActivity oauthActivity3 = OauthActivity.this;
                        oauthActivity3.setResult(0, oauthActivity3.a(-201));
                    }
                }
                OauthActivity.this.finish();
            }
        };
        BdOauthLoginParams bdOauthLoginParams = new BdOauthLoginParams();
        bdOauthLoginParams.callingPkg = this.G;
        bdOauthLoginParams.callingAppId = this.H;
        bdOauthLoginParams.redirectUrl = this.I;
        bdOauthLoginParams.callback = r0;
        this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
        if (!SapiAccountManager.getInstance().isLogin() || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
            h();
        } else {
            g();
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            setResult(0, a(-205));
            finish();
            return;
        }
        this.sapiWebView.goBack();
    }

    private boolean f() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            return true;
        }
        Log.e("pass sdk have not been initialized", new Object[0]);
        setResult(0, a(-201));
        return false;
    }

    /* access modifiers changed from: private */
    public void g() {
        SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() {
            public void onFinish() {
                OauthActivity oauthActivity = OauthActivity.this;
                ViewUtility.dismissDialog(oauthActivity, oauthActivity.N);
            }

            public void onStart() {
                OauthActivity oauthActivity = OauthActivity.this;
                oauthActivity.N = new Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (!OauthActivity.this.isFinishing() && !OauthActivity.this.N.isShowing()) {
                    OauthActivity.this.N.show();
                }
            }

            public void onSuccess(SsoHashResult ssoHashResult) {
                String str;
                HashMap hashMap = new HashMap();
                hashMap.put("client", SapiDeviceInfo.f3010c);
                hashMap.put("clientfrom", SapiAccountService.f2213b);
                String str2 = "1";
                hashMap.put("suppcheck", str2);
                int f2 = OauthActivity.this.O;
                String str3 = OauthActivity.A;
                if (f2 == 0) {
                    int versionCompareTo = SapiUtils.versionCompareTo(OauthActivity.this.L, str3);
                    String str4 = WBConstants.AUTH_PARAMS_RESPONSE_TYPE;
                    if (versionCompareTo >= 0) {
                        hashMap.put(str4, "sso_auth_code");
                        hashMap.put(WXLoginActivity.KEY_BASE_RESP_STATE, OauthActivity.this.K);
                    } else {
                        hashMap.put(str4, "sso_token");
                    }
                    hashMap.put("display", AddressManageResult.KEY_MOBILE);
                    hashMap.put("scope", OauthActivity.this.J);
                    hashMap.put("sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("client_id", OauthActivity.this.H);
                    hashMap.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, OauthActivity.this.I);
                    StringBuilder sb = new StringBuilder();
                    sb.append(SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl());
                    sb.append("/oauth/2.0/authorize");
                    StringBuilder a2 = a.a(sb.toString());
                    a2.append(SapiUtils.mapToUrlParams(hashMap, false));
                    str = a2.toString();
                } else {
                    hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                    hashMap.put("oauth_redirect_uri", OauthActivity.this.I);
                    if (SapiUtils.versionCompareTo(OauthActivity.this.L, str3) >= 0) {
                        hashMap.put("getauthorizationcode", str2);
                    } else {
                        hashMap.put("getaccesstoken", str2);
                    }
                    StringBuilder a3 = a.a(OauthActivity.this.P);
                    a3.append(SapiUtils.mapToUrlParams(hashMap, true));
                    str = a3.toString();
                }
                OauthActivity.this.sapiWebView.loadUrl(str);
            }
        }, this.G, this.H);
    }

    /* access modifiers changed from: private */
    public void h() {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        Config config = new Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        PassportSDK.getInstance().startLogin(this, new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                if (webAuthResult.getResultCode() == -301) {
                    OauthActivity oauthActivity = OauthActivity.this;
                    oauthActivity.setResult(0, oauthActivity.a(-205));
                    OauthActivity.this.finish();
                } else {
                    OauthActivity oauthActivity2 = OauthActivity.this;
                    oauthActivity2.setResult(0, oauthActivity2.a(-201));
                    OauthActivity.this.finish();
                }
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                OauthActivity.this.g();
                LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        SapiUtils.hideSoftInput(OauthActivity.this);
                    }
                }, 300);
            }
        }, webLoginDTO);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        parse.getHost();
        String[] strArr = {Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter("client_id")), Uri.decode(parse.getQueryParameter(SapiUtils.f3013a)), Uri.decode(parse.getQueryParameter("tpl"))};
        for (int i2 = 0; i2 < 4; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                return false;
            }
        }
        String wap = SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap();
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getScheme());
        sb.append("://");
        sb.append(parse.getHost());
        if (!wap.equals(sb.toString())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public Intent a(int i2, String str) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        intent.putExtra(s, jSONObject.toString());
        return intent;
    }

    /* access modifiers changed from: private */
    public Intent a(int i2) {
        return a(i2, "");
    }
}
