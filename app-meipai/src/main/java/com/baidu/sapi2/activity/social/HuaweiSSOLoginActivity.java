package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient.Builder;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.hwid.HuaweiId;
import com.huawei.hms.support.api.hwid.HuaweiIdSignInOptions;
import com.huawei.hms.support.api.hwid.SignInHuaweiId;
import com.huawei.hms.support.api.hwid.SignInResult;
import e.a.a.a.a;
import e.c.c.a.j.a.c;

public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    public static final int REQUEST_HMS_RESOLVE_ERROR = 1000;
    public static final int REQUEST_SIGN_IN_AUTH = 1003;
    public static final int REQUEST_SIGN_IN_CHECK_PASSWORD = 1005;
    public static final int REQUEST_SIGN_IN_UNLOGIN = 1002;
    public static final int SIGN_IN_NETWORK_CONTROL = 2007;
    public static final String TAG = "HuaweiSSOLoginActivity";
    public HuaweiApiClient client;
    public boolean mResolvingError = false;

    /* access modifiers changed from: private */
    public void handleSignInResult(SignInResult signInResult) {
        if (signInResult.isSuccess()) {
            SignInHuaweiId signInHuaweiId = signInResult.getSignInHuaweiId();
            Log.e(TAG, "account", signInHuaweiId.toString());
            loadSSOLogin(signInHuaweiId.getAccessToken());
        } else {
            Intent data = signInResult.getData();
            if (data == null) {
                onFail(signInResult.getStatus().getStatusCode(), getString(c.sapi_sdk_third_error_hw));
            } else if (signInResult.getStatus().getStatusCode() == 2001) {
                Log.i(TAG, "帐号未登录");
                startActivityForResult(data, 1002);
            } else if (signInResult.getStatus().getStatusCode() == 2002) {
                Log.i(TAG, "帐号已登录，需要用户授权");
                startActivityForResult(data, 1003);
            } else if (signInResult.getStatus().getStatusCode() == 2004) {
                startActivityForResult(data, 1005);
            } else if (signInResult.getStatus().getStatusCode() == 2007) {
                startActivityForResult(data, SIGN_IN_NETWORK_CONTROL);
            } else {
                onFail(signInResult.getStatus().getStatusCode(), getString(c.sapi_sdk_third_error_hw));
            }
        }
    }

    private void loadSSOLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            onFail(-204, getString(c.sapi_sdk_third_error_hw));
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.loadHuaWeiSSOLogin(str, getStatParamList());
        }
    }

    /* access modifiers changed from: private */
    public void onFail(int i2, String str) {
        if (this.businessFrom == 2001) {
            Intent intent = new Intent();
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_CODE, i2);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setResult(1002, intent);
        } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
            this.webAuthResult.setResultCode(i2);
            this.webAuthResult.setResultMsg(str);
            PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            PassportSDK.getInstance().release();
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void signIn() {
        if (!this.client.isConnected()) {
            Log.i(TAG, "登录帐号失败，原因：HUAWEIApiClient未连接");
            this.client.connect(this);
            return;
        }
        HuaweiId.HuaweiIdApi.signIn(this, this.client).setResultCallback(new ResultCallback<SignInResult>() {
            public void onResult(SignInResult signInResult) {
                HuaweiSSOLoginActivity.this.handleSignInResult(signInResult);
            }
        });
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            onFail(-202, getString(c.sapi_sdk_third_error_hw));
            return;
        }
        if (i2 == 1002) {
            signIn();
        } else if (i2 == 1003) {
            Log.i(TAG, "用户已经授权");
            SignInResult signInResultFromIntent = HuaweiId.HuaweiIdApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent.isSuccess()) {
                SignInHuaweiId signInHuaweiId = signInResultFromIntent.getSignInHuaweiId();
                String str = TAG;
                StringBuilder a2 = a.a("用户授权成功，直接返回帐号信息:");
                a2.append(signInHuaweiId.toString());
                Log.i(str, a2.toString());
                loadSSOLogin(signInHuaweiId.getAccessToken());
            } else {
                onFail(signInResultFromIntent.getStatus().getStatusCode(), getString(c.sapi_sdk_third_error_hw));
            }
        } else if (i2 == 1005) {
            signIn();
        } else if (i2 == 2007) {
            handleSignInResult(HuaweiId.HuaweiIdApi.getSignInResultFromIntent(intent));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void onDestroy() {
        super.onDestroy();
        HuaweiApiClient huaweiApiClient = this.client;
        if (huaweiApiClient != null) {
            huaweiApiClient.disconnect();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(c.sapi_sdk_title_login_hw);
        AnonymousClass1 r0 = new ConnectionCallbacks() {
            public void onConnected() {
                Log.e(HuaweiSSOLoginActivity.TAG, "onConnected");
                HuaweiSSOLoginActivity.this.signIn();
            }

            public void onConnectionSuspended(int i2) {
                Log.e(HuaweiSSOLoginActivity.TAG, "onConnectionSuspended");
                if (!HuaweiSSOLoginActivity.this.isFinishing()) {
                    HuaweiSSOLoginActivity.this.client.connect(HuaweiSSOLoginActivity.this);
                }
            }
        };
        HuaweiApiClient build = new Builder(this).addApi(HuaweiId.SIGN_IN_API, new HuaweiIdSignInOptions.Builder(HuaweiIdSignInOptions.DEFAULT_SIGN_IN).build()).addConnectionCallbacks(r0).addOnConnectionFailedListener(new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult connectionResult) {
                String str = "onConnectionFailed";
                Log.e(HuaweiSSOLoginActivity.TAG, str, Integer.valueOf(connectionResult.getErrorCode()));
                if (!HuaweiSSOLoginActivity.this.mResolvingError) {
                    if (HuaweiApiAvailability.getInstance().isUserResolvableError(connectionResult.getErrorCode())) {
                        android.util.Log.e("hmssdk", str);
                        HuaweiSSOLoginActivity.this.mResolvingError = true;
                        HuaweiApiAvailability.getInstance().resolveError(HuaweiSSOLoginActivity.this, connectionResult.getErrorCode(), 1000);
                    } else {
                        HuaweiSSOLoginActivity.this.onFail(connectionResult.getErrorCode(), HuaweiSSOLoginActivity.this.getString(c.sapi_sdk_third_error_hw));
                    }
                }
            }
        }).build();
        this.client = build;
        build.connect(this);
    }
}
