package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.LoadingDialog.Builder;
import e.a.a.a.a;
import e.c.c.a.j.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;

public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String TAG = "MeizuSSOLoginActivity";

    /* access modifiers changed from: private */
    public void loadMeizuSSOLoginInNA(String str, String str2) {
        if (this.sapiWebView == null) {
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
            return;
        }
        HttpClientWrap httpClientWrap = new HttpClientWrap();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getStatParamList());
        PassNameValuePair sceneFromParam = getSceneFromParam();
        if (sceneFromParam != null) {
            arrayList.add(sceneFromParam);
        }
        a.a("json", "1", arrayList);
        httpClientWrap.get(this.sapiWebView.getMeizuSSOLoginUrl(arrayList, str, str2), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                String access$100 = MeizuSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure error = ");
                sb.append(th);
                sb.append(" errorCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$100, sb.toString());
                AuthorizationListener authorizationListener = MeizuSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                }
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                String access$100 = MeizuSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onSuccess statusCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$100, sb.toString());
                String str2 = Web2NativeLoginResult.ERROR_MSG_UNKNOWN;
                if (str == null) {
                    AuthorizationListener authorizationListener = MeizuSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, str2);
                    }
                    return;
                }
                try {
                    MeizuSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = MeizuSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, str2);
                    }
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(c.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        LoadingDialog createDialog = new Builder(this).setMessage("授权魅族账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
        this.loadingDialog = createDialog;
        if (!createDialog.isShowing()) {
            this.loadingDialog.show();
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        new MzAuthenticator(confignation.mzAppID, confignation.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new ImplictCallback() {
            public void onError(OAuthError oAuthError) {
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
            }

            public void onGetToken(OAuthToken oAuthToken) {
                String accessToken = oAuthToken.getAccessToken();
                String openId = oAuthToken.getOpenId();
                if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId)) {
                    MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                    meizuSSOLoginActivity.handleBack(meizuSSOLoginActivity.businessFrom);
                    return;
                }
                MeizuSSOLoginActivity.this.loadMeizuSSOLoginInNA(accessToken, openId);
            }
        });
    }
}
