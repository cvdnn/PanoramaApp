package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.WeixinHandler;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.LoadingDialog.Builder;
import e.a.a.a.a;
import e.c.c.a.j.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class WXLoginActivity extends BaseSSOLoginActivity {
    public static final String KEY_BASE_RESP_CODE = "code";
    public static final String KEY_BASE_RESP_ERROR_CODE = "error_code";
    public static final String KEY_BASE_RESP_STATE = "state";
    public static final String KEY_FROM_WX_AUTH = "from_wx_auth";
    public static final String TAG = "WXLoginActivity";
    public static int businessFrom;
    public static String mWxExtraJson;
    public String wxRespCode;
    public int wxRespErrorCode;
    public String wxRespState;

    private void handleWxResp() {
        this.businessFrom = businessFrom;
        this.extraJson = mWxExtraJson;
        mWxExtraJson = null;
        this.wxRespCode = getIntent().getStringExtra("code");
        this.wxRespState = getIntent().getStringExtra(KEY_BASE_RESP_STATE);
        int intExtra = getIntent().getIntExtra(KEY_BASE_RESP_ERROR_CODE, -1);
        this.wxRespErrorCode = intExtra;
        if (intExtra == 0) {
            loadWeiXinSSOLoginInNA(this.wxRespCode, this.wxRespState);
        } else {
            handleBack(businessFrom);
        }
    }

    private void initView() {
        setupViews();
        setTitleText(c.sapi_sdk_title_login_wx);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        LoadingDialog createDialog = new Builder(this).setMessage("授权微信账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
        this.loadingDialog = createDialog;
        if (!createDialog.isShowing()) {
            this.loadingDialog.show();
        }
        this.sapiWebView.setWeixinHandler(new WeixinHandler() {
            public void handleNotInstall() {
                Toast.makeText(WXLoginActivity.this, SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            public void handleServerError(String str) {
                Toast.makeText(WXLoginActivity.this, "服务错误", 1).show();
                WXLoginActivity.this.handleBack(WXLoginActivity.businessFrom);
            }

            public void onFinish() {
                WXLoginActivity.this.finish();
            }
        });
        if (!getIntent().getBooleanExtra(KEY_FROM_WX_AUTH, false)) {
            businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            mWxExtraJson = this.extraJson;
            this.sapiWebView.loadWeixinSSOLogin();
            return;
        }
        handleWxResp();
    }

    private void loadWeiXinSSOLoginInNA(String str, String str2) {
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
        httpClientWrap.get(this.sapiWebView.getWeiXinSSOLoginUrl(str, str2, false, arrayList), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                String str2 = WXLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure error = ");
                sb.append(th);
                sb.append(" errorCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(str2, sb.toString());
                AuthorizationListener authorizationListener = WXLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                }
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                String str2 = WXLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onSuccess statusCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(str2, sb.toString());
                String str3 = Web2NativeLoginResult.ERROR_MSG_UNKNOWN;
                if (str == null) {
                    AuthorizationListener authorizationListener = WXLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, str3);
                    }
                    return;
                }
                try {
                    WXLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = WXLoginActivity.this.authorizationListener;
                    if (authorizationListener2 != null) {
                        authorizationListener2.onFailed(-100, str3);
                    }
                }
            }
        });
    }

    private void setInvokeResult(int i2, Intent intent) {
        if (SocialLoginBase.getWXinvokeCallback() != null) {
            SocialLoginBase.getWXinvokeCallback().onResult(i2, intent);
        }
    }

    public void handleBack(int i2) {
        super.handleBack(i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void setActivtyResult(int i2) {
        super.setActivtyResult(i2);
        setInvokeResult(i2, null);
    }

    public void setActivtyResult(int i2, Intent intent) {
        super.setActivtyResult(i2, intent);
        setInvokeResult(i2, intent);
    }
}
