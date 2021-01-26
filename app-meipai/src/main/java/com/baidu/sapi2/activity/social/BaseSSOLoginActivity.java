package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.views.ViewUtility;
import e.c.c.a.j.a.a;
import e.c.c.a.j.a.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSSOLoginActivity extends SocialLoginBase {
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String LOAD_THIRD_PARTY_SCENE_FROM = "sceneFrom";
    public AuthorizationListener authorizationListener = new AuthorizationListener() {
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                PassportSDK.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        public void onFailed(int i2, String str) {
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                Intent intent = new Intent();
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_CODE, i2);
                intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
                BaseSSOLoginActivity.this.setActivtyResult(1002, intent);
            } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.webAuthResult.setResultCode(i2);
                BaseSSOLoginActivity.this.webAuthResult.setResultMsg(str);
                PassportSDK.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.webAuthResult);
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            if (!BaseSSOLoginActivity.this.isClose) {
                WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    WebAuthResult webAuthResult = BaseSSOLoginActivity.this.webAuthResult;
                    webAuthResult.accountType = accountType;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(BaseSSOLoginActivity.this.webAuthResult);
                }
                int i2 = BaseSSOLoginActivity.this.businessFrom;
                if (i2 == 2001) {
                    WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                    if (webRegDTO == null) {
                        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                        if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                            BaseSSOLoginActivity.this.setActivtyResult(1001);
                            BaseSSOLoginActivity.this.finish();
                        }
                    } else if (webRegDTO.finishActivityAfterSuc) {
                        BaseSSOLoginActivity.this.setActivtyResult(1001);
                        BaseSSOLoginActivity.this.finish();
                    }
                } else if (i2 == 2003 || i2 == 2004) {
                    BaseSSOLoginActivity.this.setActivtyResult(1001);
                    BaseSSOLoginActivity.this.finish();
                } else {
                    WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
                    if (socialLoginDTO != null && socialLoginDTO.finishActivityAfterSuc) {
                        PassportSDK.getInstance().release();
                        BaseSSOLoginActivity.this.finish();
                    }
                }
            }
        }
    };
    public int businessFrom;
    public String extraJson;
    public boolean isClose;
    public Dialog loadingDialog;
    public Handler mainHandler;
    public RelativeLayout rootView;
    public WebAuthResult webAuthResult = new WebAuthResult() {
        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.businessFrom == 2001) {
                baseSSOLoginActivity.setActivtyResult(1001);
            } else {
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }
    };

    /* access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && !TextUtils.isEmpty(sapiWebView.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.sapiWebView.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        SapiUtils.reportGid(i.f3087b);
        if (this.authorizationListener != null) {
            ViewUtility.dismissDialog(this, this.loadingDialog);
            try {
                if (!AuthorizationListener.class.equals(this.authorizationListener.getClass().getMethod("onSuccess", new Class[]{AccountType.class}).getDeclaringClass())) {
                    this.authorizationListener.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.authorizationListener.onSuccess();
        }
    }

    private void initData() {
        super.init();
        this.businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.extraJson = getIntent().getStringExtra("extraJson");
        this.webAuthResult.activity = this;
        this.mainHandler = new Handler();
    }

    private void setOrientationToUndefined() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public PassNameValuePair getSceneFromParam() {
        String str = LOAD_THIRD_PARTY_SCENE_FROM;
        if (!TextUtils.isEmpty(this.extraJson)) {
            try {
                return new PassNameValuePair(str, new JSONObject(this.extraJson).optString(str));
            } catch (JSONException e2) {
                Log.e(e2);
            } catch (Exception e3) {
                Log.e(e3);
            }
        }
        return null;
    }

    public List<PassNameValuePair> getStatParamList() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
        String str = "extrajson";
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair(str, WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair(str, WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
        }
        return arrayList;
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getSocialLoginDTO();
    }

    public void handleBack(int i2) {
        String str = SapiResult.ERROR_MSG_PROCESSED_END;
        if (i2 == 2001) {
            Intent intent = new Intent();
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_CODE, -301);
            intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_MSG, str);
            setActivtyResult(1002, intent);
        } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
            this.isClose = true;
            this.webAuthResult.setResultCode(-301);
            this.webAuthResult.setResultMsg(str);
            PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            PassportSDK.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    public void handleOpenApiAuthorizeResponse(final SocialResponse socialResponse, HashMap<String, String> hashMap) {
        if (socialResponse.errorCode == 302) {
            ViewUtility.dismissDialog(this, this.loadingDialog);
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = (String) hashMap.get("mkey");
            String str2 = (String) hashMap.get("BAIDUID");
            String str3 = (String) hashMap.get("BDUSS");
            String str4 = (String) hashMap.get("PTOKEN");
            String str5 = (String) hashMap.get("STOKEN");
            String str6 = socialResponse.userInfoXmlContent;
            this.sapiWebView.loadThirdPartySSOLogin(socialResponse.nextUrl, str6, str, str2, str3, str4, str5);
            return;
        }
        final SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiUtils.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (this.authorizationListener != null) {
            int i2 = socialResponse.errorCode;
            if (i2 == 0 || i2 == 110000) {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        try {
                            if (BaseSSOLoginActivity.this.authorizationListener != null) {
                                BaseSSOLoginActivity.this.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiShareClient.getInstance().validate(sapiAccountResponseToAccount);
                        BaseSSOLoginActivity.this.authorizeSuccess(AccountType.UNKNOWN);
                    }
                });
            } else {
                this.mainHandler.post(new Runnable() {
                    public void run() {
                        BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                        if (baseSSOLoginActivity.authorizationListener != null) {
                            ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.loadingDialog);
                            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.authorizationListener;
                            SocialResponse socialResponse = socialResponse;
                            authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                        }
                    }
                });
            }
        }
    }

    public void onBottomBackBtnClick() {
        this.sapiWebView.onKeyUp(4);
    }

    public void onClose() {
        super.onClose();
        handleBack(this.businessFrom);
    }

    public void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT == 26) {
            setOrientationToUndefined();
        }
        super.onCreate(bundle);
        try {
            setContentView(b.layout_sapi_sdk_webview_with_title_bar);
            initData();
        } catch (Throwable th) {
            reportWebviewError(th);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.onKeyUp(4);
        }
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setActivtyResult(int i2, Intent intent) {
        setResult(i2, intent);
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        this.rootView = (RelativeLayout) findViewById(a.root_view);
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                if (BaseSSOLoginActivity.this.sapiWebView == null || !BaseSSOLoginActivity.this.sapiWebView.canGoBack()) {
                    BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                    baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
                    return;
                }
                BaseSSOLoginActivity.this.sapiWebView.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.handleBack(baseSSOLoginActivity.businessFrom);
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
    }

    public void setActivtyResult(int i2) {
        setResult(i2);
    }
}
