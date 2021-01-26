package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
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
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import e.a.a.a.a;
import e.c.c.a.j.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static final int SUCCESS_RESULTCODE = -1;
    public static final String TAG = "SinaSSOLoginActivity";
    public SsoHandler sinaSsoHandler;

    /* access modifiers changed from: private */
    public void loadSinaSSOLoginInNA(String str, String str2) {
        String str3 = TAG;
        StringBuilder a2 = a.a("Current Thread:");
        a2.append(Thread.currentThread().getName());
        Log.d(str3, a2.toString());
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
        httpClientWrap.get(this.sapiWebView.getSinaSSOLoginUrl(arrayList, str, str2), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                String access$100 = SinaSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure error = ");
                sb.append(th);
                sb.append(" errorCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$100, sb.toString());
                AuthorizationListener authorizationListener = SinaSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                }
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                String access$100 = SinaSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onSuccess statusCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$100, sb.toString());
                String str2 = Web2NativeLoginResult.ERROR_MSG_UNKNOWN;
                if (str == null) {
                    AuthorizationListener authorizationListener = SinaSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, str2);
                    }
                    return;
                }
                try {
                    SinaSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = SinaSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, str2);
                    }
                }
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str = TAG;
        StringBuilder a2 = a.a("requestCode = ", i2, " resultCode = ", i3, " data = ");
        a2.append(intent);
        Log.d(str, a2.toString());
        this.loadingDialog.dismiss();
        if (i3 == -1) {
            LoadingDialog createDialog = new Builder(this).setMessage("授权微博账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
            this.loadingDialog = createDialog;
            if (!createDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
        super.onActivityResult(i2, i3, intent);
        this.sinaSsoHandler.authorizeCallBack(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(c.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        LoadingDialog createDialog = new Builder(this).setMessage("").setCancelable(false).setCancelOutside(false).createDialog();
        this.loadingDialog = createDialog;
        if (!createDialog.isShowing()) {
            this.loadingDialog.show();
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        WbSdk.install(this, new AuthInfo(this, confignation.sinaAppId, confignation.sinaRedirectUri, SapiAccount.f2184d));
        SsoHandler ssoHandler = new SsoHandler(this);
        this.sinaSsoHandler = ssoHandler;
        ssoHandler.authorize(new WbAuthListener() {
            public void cancel() {
                SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
                sinaSSOLoginActivity.handleBack(sinaSSOLoginActivity.businessFrom);
            }

            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Toast.makeText(SinaSSOLoginActivity.this, wbConnectErrorMessage.getErrorMessage(), 0).show();
            }

            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                SinaSSOLoginActivity.this.loadSinaSSOLoginInNA(oauth2AccessToken.getToken(), oauth2AccessToken.getUid());
            }
        });
    }
}
