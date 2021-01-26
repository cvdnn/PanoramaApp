package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.LoadingDialog.Builder;
import com.tencent.connect.UnionInfo;
import com.tencent.open.SocialOperation;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import e.a.a.a.a;
import e.c.c.a.j.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String DEFAULT_QQ_NOT_INSTALL_ERROR = "QQ未安装";
    public static final int SUCCESS_RESULTCODE = -1;
    public static final String TAG = "QQSSOLoginActivity";
    public IUiListener qqLoginListener;

    public interface QrCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    private void getQQSSOToken(final QrCallback qrCallback) {
        final Tencent createInstance = Tencent.createInstance(SapiAccountManager.getInstance().getConfignation().qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this, DEFAULT_QQ_NOT_INSTALL_ERROR, 1).show();
            qrCallback.onFailure();
            return;
        }
        AnonymousClass2 r1 = new IUiListener() {
            public void onCancel() {
                qrCallback.onFailure();
            }

            public void onComplete(Object obj) {
                if (obj == null) {
                    qrCallback.onFailure();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() == 0) {
                    qrCallback.onFailure();
                    return;
                }
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                        qrCallback.onFailure();
                    } else {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                        QQSSOLoginActivity.this.getQQUnionId(createInstance, qrCallback);
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    qrCallback.onFailure();
                }
            }

            public void onError(UiError uiError) {
                qrCallback.onFailure();
            }
        };
        this.qqLoginListener = r1;
        createInstance.login((Activity) this, "all", (IUiListener) r1);
    }

    /* access modifiers changed from: private */
    public void getQQUnionId(final Tencent tencent, final QrCallback qrCallback) {
        if (tencent == null || !tencent.isSessionValid()) {
            qrCallback.onFailure();
            return;
        }
        new UnionInfo(this, tencent.getQQToken()).getUnionId(new IUiListener() {
            public void onCancel() {
                qrCallback.onFailure();
            }

            public void onComplete(Object obj) {
                if (obj != null) {
                    qrCallback.onSuccess(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString(SocialOperation.GAME_UNION_ID));
                    return;
                }
                qrCallback.onFailure();
            }

            public void onError(UiError uiError) {
                qrCallback.onFailure();
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadQQSSOLoginInNA(String str, String str2, String str3) {
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
        httpClientWrap.get(this.sapiWebView.getQQSSOLoginUrl(arrayList, str, str2, str3), ((ThirdPartyService) PassportSDK.getInstance().getThirdPartyService()).getCookies(this, this.configuration), new HttpHandlerWrap(Looper.getMainLooper()) {
            public void onFailure(Throwable th, int i2, String str) {
                String access$300 = QQSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onFailure error = ");
                sb.append(th);
                sb.append(" errorCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$300, sb.toString());
                AuthorizationListener authorizationListener = QQSSOLoginActivity.this.authorizationListener;
                if (authorizationListener != null) {
                    authorizationListener.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                }
            }

            public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                String access$300 = QQSSOLoginActivity.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("onSuccess statusCode = ");
                sb.append(i2);
                sb.append(" responseBody = ");
                sb.append(str);
                Log.d(access$300, sb.toString());
                String str2 = Web2NativeLoginResult.ERROR_MSG_UNKNOWN;
                if (str == null) {
                    AuthorizationListener authorizationListener = QQSSOLoginActivity.this.authorizationListener;
                    if (authorizationListener != null) {
                        authorizationListener.onFailed(-100, str2);
                    }
                    return;
                }
                try {
                    QQSSOLoginActivity.this.handleOpenApiAuthorizeResponse(SocialResponse.fromJSONObject(new JSONObject(str)), hashMap);
                } catch (Throwable th) {
                    Log.e(th);
                    AuthorizationListener authorizationListener2 = QQSSOLoginActivity.this.authorizationListener;
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
            LoadingDialog createDialog = new Builder(this).setMessage("授权QQ账号登录中").setCancelable(false).setCancelOutside(false).createDialog();
            this.loadingDialog = createDialog;
            if (!createDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
        if (i2 == 11101 || i2 == 10102) {
            Tencent.onActivityResultData(i2, i3, intent, this.qqLoginListener);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText(c.sapi_sdk_title_login_qq);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        LoadingDialog createDialog = new Builder(this).setMessage("").setCancelable(false).setCancelOutside(false).createDialog();
        this.loadingDialog = createDialog;
        if (!createDialog.isShowing()) {
            this.loadingDialog.show();
        }
        getQQSSOToken(new QrCallback() {
            public void onFailure() {
                QQSSOLoginActivity qQSSOLoginActivity = QQSSOLoginActivity.this;
                qQSSOLoginActivity.handleBack(qQSSOLoginActivity.businessFrom);
            }

            public void onSuccess(String str, String str2, String str3) {
                if (QQSSOLoginActivity.this.sapiWebView != null) {
                    QQSSOLoginActivity.this.loadQQSSOLoginInNA(str, str2, str3);
                }
            }
        });
    }
}
