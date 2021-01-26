package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccount.ExtraProperty;
import com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback;
import com.baidu.sapi2.SapiJsCallBacks.BdOauthLoginParams;
import com.baidu.sapi2.SapiJsCallBacks.BuildCustomAlertDialog;
import com.baidu.sapi2.SapiJsCallBacks.CallBacks;
import com.baidu.sapi2.SapiJsCallBacks.CurrentAccountBdussExpiredCallback;
import com.baidu.sapi2.SapiJsCallBacks.DirectedLoginParams;
import com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback;
import com.baidu.sapi2.SapiJsCallBacks.GetCurrentPageNameCallback;
import com.baidu.sapi2.SapiJsCallBacks.GrantWebCallback;
import com.baidu.sapi2.SapiJsCallBacks.InvoiceBuildCallback;
import com.baidu.sapi2.SapiJsCallBacks.JoinLoginParams;
import com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback;
import com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback;
import com.baidu.sapi2.SapiJsCallBacks.PageStateCallback;
import com.baidu.sapi2.SapiJsCallBacks.RealNameStatusCallback;
import com.baidu.sapi2.SapiJsCallBacks.ShareV2LoginParams;
import com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionCallback;
import com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback;
import com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback;
import com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.outsdk.e;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.utils.j;
import com.baidu.sapi2.utils.q;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import e.a.a.a.a;
import e.c.b.e.Utils;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

public final class SapiWebView extends WebView {
    public static final String A = "取消";
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final String B = "立即设置时间";
    public static final String C = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    public static final String D = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String DEFAULT_WEIXIN_NOT_INSTALL_ERROR = "微信未安装";
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT;
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN;
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN;
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER;
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE;
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";

    /* renamed from: a reason: collision with root package name */
    public static final String f2386a = "prompt_on_cancel";

    /* renamed from: b reason: collision with root package name */
    public static final String f2387b = "css/sapi_theme/style.css";

    /* renamed from: c reason: collision with root package name */
    public static final int f2388c = 1;

    /* renamed from: d reason: collision with root package name */
    public static final int f2389d = 0;

    /* renamed from: e reason: collision with root package name */
    public static final String f2390e = "renren-offline";

    /* renamed from: f reason: collision with root package name */
    public static final String f2391f = "__wp-action";

    /* renamed from: g reason: collision with root package name */
    public static final String f2392g = "forget-pwd";

    /* renamed from: h reason: collision with root package name */
    public static final String f2393h = "modify-pwd";

    /* renamed from: i reason: collision with root package name */
    public static final String f2394i = "text/html";

    /* renamed from: j reason: collision with root package name */
    public static final String f2395j = "UTF-8";
    public static final String k = "#login";
    public static final String l = "#insert_account";
    public static final String m = "#canshareAi";
    public static final String n = "#authPwd";
    public static final String o = "#reg";
    public static final String p = "#canshare_accounts";
    public static final String q = "#sms_login";
    public static final String r = "#fastReg";
    public static final String s = "#oneKeyLogin";
    public static q statLoadLogin = null;
    public static final String t = "#share_auth";
    public static final String u = "#face_login";
    public static final String v = "服务错误，请稍后重试";
    public static final String w = "系统时间错误";
    public static final String x = "证书安全警告";
    public static final String y = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    public static final String z = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public SapiConfiguration E;
    public WeixinHandler F;
    public WebviewClientCallback G;
    public WebChromeClientCallback H;
    public FileChooserCallback I;
    public ChangePwdCallback J;
    public AccountChangeCallback K;
    public boolean L;
    public ReloadConfig M = new ReloadConfig();
    public SapiJsInterpreters N;
    public CallBacks O;
    public List<String> P;
    public View Q;
    public View R;
    public View S;
    public ProgressBar T;
    public ProgressDialog U;
    public Dialog V;
    public V W;
    public boolean aa;
    public long ba;
    public Handler ca = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                SapiWebView.this.h();
            }
        }
    };
    public TimeoutTask da = new TimeoutTask();
    public BroadcastReceiver ea;
    public List<PassNameValuePair> extras;
    public OnFinishCallback fa;
    public OnBackCallback ga;
    public OnNewBackCallback ha;
    public boolean ia;
    public int ja = 1;
    public boolean ka;
    public volatile boolean la;
    public volatile String ma;
    public boolean shareV2Disable = false;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide = true;
    public String[] touchidPortraitAndSign = new String[2];

    public interface AccountChangeCallback {
        void onAccountChange();
    }

    public static abstract class AccountDestoryCallback {

        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    public static abstract class AccountFreezeCallback {

        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        

        /* renamed from: b reason: collision with root package name */
        public String f2444b;

        /* access modifiers changed from: public */
        ActivityLifeCycle(String str) {
            this.f2444b = str;
        }
    }

    public interface BdussChangeCallback {
        void onBdussChange();
    }

    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        public static abstract class BioScanFaceResult {
            public int showGuidePage;
            public String subpro;
            public List<PassNameValuePair> transParamsList = new ArrayList();
            public Map<String, String> transParamsMap = new HashMap();
            public int type;
            public String uid;

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;
        public static final int RECORD_VIDEO = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    public static abstract class BiometricsIdentifyResult {
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;
        public static final String ERROR_MSG_GET_STOKEN_FAILED = "服务异常，请稍后再试";
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public String authToken;
        public int biometricType;
        public String idCardNum;
        public String livenessRecogType;
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String subPro;

        public abstract void setIdentifyToken(String str);
    }

    public interface ChangePwdCallback {
        void onSuccess();
    }

    public static class Command {

        /* renamed from: a reason: collision with root package name */
        public String f2445a;

        /* renamed from: b reason: collision with root package name */
        public List<String> f2446b = new ArrayList();

        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.f2445a = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            command.f2446b.add(optJSONArray.optString(i2));
                        }
                    }
                }
                return command;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }

        public String getActionName() {
            return this.f2445a;
        }

        public List<String> getActionParams() {
            return this.f2446b;
        }
    }

    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    public class DefaultAuthorizationListener extends AuthorizationListener {
        public DefaultAuthorizationListener() {
        }

        public void onFailed(int i2, String str) {
            SapiWebView.this.finish();
        }

        public void onSuccess() {
            SapiWebView.this.finish();
        }
    }

    public class DefaultWeixinHandler implements WeixinHandler {
        public DefaultWeixinHandler() {
        }

        public void handleNotInstall() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
        }

        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 1).show();
        }

        public void onFinish() {
            if (SapiWebView.this.getContext() instanceof Activity) {
                ((Activity) SapiWebView.this.getContext()).finish();
            }
        }
    }

    public interface ErrorCode {
        public static final int WEIXIN_NOT_INTALL = -404;
    }

    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    public interface InvokeScAppCallback {

        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i2);
    }

    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    public static class LoadSlideWebViewResult {
        public String page;
        public String placeholderTitle;
        public String url;
    }

    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    public interface OnBackCallback {
        void onBack();
    }

    public interface OnFinishCallback {
        void onFinish();
    }

    public interface OnNewBackCallback {
        boolean onBack();
    }

    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i2, int i3, int i4, PickPhotoResult pickPhotoResult);
    }

    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    public static abstract class PreFillUserNameCallback {

        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    public class ReloadConfig {

        /* renamed from: a reason: collision with root package name */
        public String f2449a;

        /* renamed from: b reason: collision with root package name */
        public boolean f2450b;

        /* renamed from: c reason: collision with root package name */
        public boolean f2451c;

        /* renamed from: d reason: collision with root package name */
        public String f2452d;

        /* renamed from: e reason: collision with root package name */
        public List<PassNameValuePair> f2453e;

        public ReloadConfig() {
            this.f2449a = null;
            this.f2450b = false;
        }

        public void a() {
            this.f2449a = null;
            this.f2450b = false;
        }
    }

    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4);
    }

    public class SmsHandler extends Handler {

        /* renamed from: a reason: collision with root package name */
        public String f2455a;

        /* renamed from: b reason: collision with root package name */
        public String f2456b;

        public SmsHandler() {
        }

        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(this.f2455a) && !TextUtils.isEmpty(this.f2456b)) {
                    SapiWebView.this.loadUrl(String.format("javascript:%s('%s','%s');", new Object[]{this.f2455a, str, this.f2456b}));
                }
                SapiWebView.this.l();
                removeCallbacks(SapiWebView.this.O.P);
            }
        }
    }

    public static abstract class SwitchAccountCallback {

        public static class Result {
            public String displayName;
            public String encryptedUid;
            public String extraJson;
            public int loginType;
            public int switchAccountType;
            public String userName;
        }

        public abstract void onAccountSwitch(Result result);
    }

    public static abstract class SystemUpwardSmsCallback {

        public static abstract class Result {
            public String content;
            public String destination;

            public abstract void onFinish();
        }

        public abstract void onResult(Result result);
    }

    public class TimeoutTask implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public String f2458a;

        public TimeoutTask() {
        }

        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.f2458a;
                SapiWebView.this.ca.sendMessage(message);
                SapiWebView.this.ca.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.f2458a = str;
        }
    }

    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    public interface UpwardSmsCallback {
        void onResult(boolean z, boolean z2, boolean z3);
    }

    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i2, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface WeixinHandler {
        void handleNotInstall();

        void handleServerError(String str);

        void onFinish();
    }

    static {
        String str = "1";
        EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", str);
        EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", str);
        EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", str);
        EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", str);
        EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", str);
    }

    public SapiWebView(Context context) {
        super(context);
        i();
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (!getSettings().getBlockNetworkLoads()) {
            loadUrl(b(activityLifeCycle.f2444b));
        }
    }

    public void back() {
        if (this.ia) {
            ProgressBar progressBar = this.T;
            if (progressBar != null && progressBar.getVisibility() == 0) {
                finish();
                View view = this.R;
                if (view == null || view.getVisibility() != 0) {
                    View view2 = this.S;
                    if (view2 == null || view2.getVisibility() != 0) {
                        return;
                    }
                }
                finish();
                return;
            }
        }
        if (this.ia) {
            View view3 = this.Q;
            if (view3 != null && view3.getVisibility() == 0) {
                finish();
                View view4 = this.R;
                View view22 = this.S;
            }
        }
        if (this.ha == null || this.O.U != null) {
            super.loadUrl(FN_SWITCH_VIEW);
            a(this.O.U);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.ha.onBack();
        }
        View view42 = this.R;
        View view222 = this.S;
    }

    public void destroy() {
        super.destroy();
        this.aa = true;
        this.ca.removeCallbacks(this.da);
        l();
        CookieManager.getInstance().flush();
    }

    public void dismissProgress() {
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.U != null && SapiWebView.this.U.isShowing()) {
                    try {
                        SapiWebView.this.U.dismiss();
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                }
            }
        });
    }

    public void finish() {
        finish("");
    }

    public String getAddressManageUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getForgetPwdUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().b());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getInvoiceBuildUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().c());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getLocalPhoneNumber() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService(SapiAccount.f2185e)).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    public String getLoginUrl() {
        return SapiAccountManager.getInstance().getAccountService().d();
    }

    public String getMeizuSSOLoginUrl(List<PassNameValuePair> list, String str, String str2) {
        String str3 = "UTF-8";
        String str4 = null;
        try {
            str4 = a(SocialType.MEIZU, URLEncoder.encode(str, str3), URLEncoder.encode(str2, str3), null);
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        return a(str4, list);
    }

    public String getModifyPwdUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().e());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getQQSSOLoginUrl(List<PassNameValuePair> list, String str, String str2, String str3) {
        return a(a(str, str2, str3), list);
    }

    public String getRealnameAuthenticateUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().f());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getSinaSSOLoginUrl(List<PassNameValuePair> list, String str, String str2) {
        return a(a(SocialType.SINA_WEIBO_SSO, str, str2, this.E.sinaAppId), list);
    }

    public String getSwitchAccountUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().h());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public long getTimeoutMillis() {
        return this.ba;
    }

    public String getUaInfo() {
        String str = "";
        String str2 = !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : str;
        if (!TextUtils.isEmpty(VERSION.RELEASE)) {
            str = VERSION.RELEASE;
        }
        StringBuilder a2 = a.a("Sapi_8.9.5.5_Android_");
        a2.append(SapiUtils.getAppName(getContext()));
        String str3 = "_";
        a2.append(str3);
        a2.append(SapiUtils.getVersionName(getContext()));
        a2.append(str3);
        a2.append(str2);
        a2.append(str3);
        a2.append(str);
        a2.append("_Sapi");
        String encode = URLEncoder.encode(a2.toString());
        if (!j() || TextUtils.isEmpty(this.E.userAgent)) {
            return encode;
        }
        StringBuilder b2 = a.b(encode, " ");
        b2.append(this.E.userAgent);
        return b2.toString();
    }

    public String getUniteVerifyUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().i());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getWapOpRecordUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().m());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String getWeiXinSSOLoginUrl(String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (!TextUtils.isEmpty(str)) {
            return a(a(str, str2, z2), list);
        }
        throw new IllegalArgumentException();
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountRealName(String str, String str2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", j.a(j.m)));
        if (!TextUtils.isEmpty(str2)) {
            a.a(FaceBaseDTO.KEY_BUSINESS_SCENE, str2, arrayList);
        }
        arrayList.add(new PassNameValuePair("needcbkey", z2 ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(a(getAddressManageUrl(), list));
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        } else if (!TextUtils.isEmpty(str)) {
            a(getContext(), str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                a.a("skin", str2, arrayList);
            }
            String str3 = "1";
            if (z2) {
                a.a("skip", str3, arrayList);
            }
            if (this.E.supportFaceLogin) {
                a.a("liveAbility", str3, arrayList);
            }
            String a2 = a(bindWidgetAction);
            if (arrayList.size() > 0) {
                StringBuilder b2 = a.b(a2, "&");
                b2.append(SapiUtils.createRequestParams(arrayList));
                a2 = b2.toString();
            }
            String a3 = a(a2, list);
            String a4 = a();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new PassNameValuePair(this.E.environment.getWap(), a4));
            loadUrl(a3, arrayList2);
        } else {
            throw new IllegalArgumentException("bduss can't be empty");
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        getSettings().setBlockNetworkLoads(true);
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        AnonymousClass7 r2 = new Runnable() {
            public void run() {
                String str;
                if (!SapiWebView.this.aa) {
                    String str2 = "#";
                    String[] split = str6.split(str2);
                    String str3 = "&loadDataWithBaseUrl=1";
                    if (split.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(split[0]);
                        sb.append(str3);
                        sb.append(str2);
                        sb.append(split[1]);
                        str = sb.toString();
                    } else {
                        str = a.a(new StringBuilder(), str6, str3);
                    }
                    String str4 = str;
                    SapiWebView.this.a(str6, true);
                    SapiWebView.super.loadDataWithBaseURL(str4, str7, str8, str9, str10);
                }
            }
        };
        post(r2);
    }

    public void loadExternalUrl(String str) {
        loadExternalUrl(str, null);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        String str2;
        try {
            str2 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), "");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
            str2 = null;
        }
        loadUrl(a(str2, list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(a(getInvoiceBuildUrl(), list));
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String str2 = "mkey";
            String str3 = "";
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.E.environment.getURL().replace("http://", str3).replace("https://", str3).replaceAll("(:[0-9]{1,4})?", str3), str2, Uri.parse(str).getQueryParameter(str2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadLoginWithUserName(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            loadLogin();
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("disusername=");
            sb.append(URLEncoder.encode(str, "UTF-8"));
            str2 = sb.toString();
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getLoginUrl());
            sb2.append("&");
            sb2.append(str2);
            sb2.append(n);
            loadUrl(sb2.toString());
            return;
        }
        loadLogin();
    }

    public void loadModifyPwd(String str) {
        loadModifyPwd(str, null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadOperationRecord(String str) {
        loadOperationRecord(str, null);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z2) {
        CallBacks callBacks = this.O;
        callBacks.t = qrLoginCallback;
        callBacks.S = z2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&suppcheck=1");
        loadUrl(sb.toString());
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (!TextUtils.isEmpty(this.E.realnameAuthenticateStoken)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onFinish() {
                }

                public void onStart() {
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (SapiWebView.this.O.n != null) {
                        SapiWebView.this.O.n.onFailure();
                    }
                }

                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new PassNameValuePair("bduss", str));
                    arrayList.add(new PassNameValuePair(SapiAccount.f2188h, (String) getTplStokenResult.tplStokenMap.get("pp")));
                    arrayList.add(new PassNameValuePair("bdstoken", SapiWebView.this.E.realnameAuthenticateStoken));
                    StringBuilder sb = new StringBuilder();
                    sb.append(realnameAuthenticateUrl);
                    sb.append("&");
                    sb.append(SapiUtils.createRequestParams(arrayList));
                    sb.append("#idcardverify");
                    SapiWebView.this.loadUrl(sb.toString());
                }
            }, str, arrayList);
        } else {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
    }

    public void loadRegist(List<PassNameValuePair> list) {
        String loginUrl = getLoginUrl();
        StringBuilder sb = new StringBuilder();
        sb.append(a(loginUrl, list));
        sb.append(o);
        loadUrl(sb.toString());
        this.ka = false;
    }

    public void loadShareV2Login() {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().n());
        sb.append("&adapter=3");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(t);
        loadUrl(sb3.toString());
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(a(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.la = true;
        this.ma = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str3));
        String str8 = "https://baidu.com";
        arrayList.add(new PassNameValuePair(str8, str4));
        arrayList.add(new PassNameValuePair(str8, str5));
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str6));
        arrayList.add(new PassNameValuePair(this.E.environment.getURL(), str7));
        loadUrl(str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        String str4 = "UTF-8";
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("token", URLEncoder.encode(str, str4)));
                if (str2 != null) {
                    arrayList.add(new PassNameValuePair("u", str2));
                }
                if (str3 != null) {
                    arrayList.add(new PassNameValuePair("adtext", URLEncoder.encode(str3, str4)));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            StringBuilder b2 = a.b(getUniteVerifyUrl(), "&");
            b2.append(SapiUtils.createRequestParams(arrayList));
            loadUrl(b2.toString());
            return;
        }
        throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
    }

    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadWeixinSSOLogin() {
        if (this.F == null) {
            this.F = new DefaultWeixinHandler();
        }
        new e().a(getContext(), this.E, this.F);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onKeyUp(int i2) {
        if (i2 != 4 || this.ja != 1) {
            return false;
        }
        OnBackCallback onBackCallback = this.ga;
        if (onBackCallback != null && this.O.U == null) {
            onBackCallback.onBack();
        }
        back();
        return true;
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ProgressBar progressBar = this.T;
        if (progressBar != null) {
            LayoutParams layoutParams = (LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.T.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        View view = this.R;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.S;
            if (view2 == null || view2.getVisibility() != 0) {
                return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
            }
        }
        return false;
    }

    public void preSetUserName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('");
        sb.append(str);
        sb.append("')}}())");
        loadUrl(sb.toString());
    }

    public void reload() {
        String str = this.M.f2449a;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.M.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0.getVisibility() == 0) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scrollTo(int r2, int r3) {
        /*
            r1 = this;
            android.view.View r0 = r1.R
            if (r0 == 0) goto L_0x000a
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x0014
        L_0x000a:
            android.view.View r0 = r1.S
            if (r0 == 0) goto L_0x0018
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0018
        L_0x0014:
            r0 = 0
            super.scrollTo(r0, r0)
        L_0x0018:
            super.scrollTo(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiWebView.scrollTo(int, int):void");
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.K = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.O.q = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.O.r = accountFreezeCallback;
    }

    public void setAddressManageCallback(AddressManageCallback addressManageCallback) {
        this.O.L = addressManageCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.O.I = authorizationListener;
    }

    public void setBdOauthLoginParams(BdOauthLoginParams bdOauthLoginParams) {
        this.O.Z = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.O.k = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.O.f2246h = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.O.f2242d = bioScanFaceCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.O.f2243e = biometricsIdentifyCallback;
    }

    public void setBuildCustomAlertDialog(BuildCustomAlertDialog buildCustomAlertDialog) {
        this.O.K = buildCustomAlertDialog;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.J = changePwdCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.O.o = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.O.E = currentAccountBdussExpiredCallback;
    }

    public void setDirectedLoginParams(DirectedLoginParams directedLoginParams) {
        this.O.X = directedLoginParams;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.I = fileChooserCallback;
    }

    public void setFingerprintCallback(FingerprintCallback fingerprintCallback) {
        this.O.N = fingerprintCallback;
    }

    public void setGetCurrentPageNameCallback(GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.O.G = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(GrantWebCallback grantWebCallback) {
        this.O.D = grantWebCallback;
    }

    public void setHideSuccessTip(boolean z2) {
        this.O.Y = z2;
    }

    public void setInvoiceBuildCallback(InvoiceBuildCallback invoiceBuildCallback) {
        this.O.M = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.O.v = invokeScAppCallback;
    }

    public void setJoinLoingParams(JoinLoginParams joinLoginParams) {
        this.O.V = joinLoginParams;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.O.m = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.O.f2247i = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.O.x = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.O.w = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(LoginStatusChangeCallback loginStatusChangeCallback) {
        this.O.C = loginStatusChangeCallback;
    }

    public final void setNoNetworkView(View view) {
        if (this.R == null) {
            this.R = view;
            view.setVisibility(4);
            addView(this.R, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        CallBacks callBacks = this.O;
        callBacks.z = normalizeGuestAccountCallback;
        callBacks.W = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ga = onBackCallback;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.fa = onFinishCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.ha = onNewBackCallback;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.O.H = onSlidePageFinishCallback;
    }

    public void setPageStateCallback(PageStateCallback pageStateCallback) {
        this.O.J = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.O.f2248j = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.O.p = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.T == null) {
            this.T = progressBar;
            if (progressBar != null) {
                addView(progressBar);
            }
        }
    }

    public void setRealNameStateCallback(RealNameStatusCallback realNameStatusCallback) {
        this.O.B = realNameStatusCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.O.n = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.O.s = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(ShareV2LoginParams shareV2LoginParams) {
        this.O.aa = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.O.f2239a = handler;
    }

    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.O.y = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.O.F = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.O.l = switchAccountCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.O.u = systemUpwardSmsCallback;
    }

    public void setTimeoutMillis(long j2) {
        this.ba = j2;
    }

    public final void setTimeoutView(View view) {
        if (this.S == null) {
            this.S = view;
            view.setVisibility(4);
            addView(this.S, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.O.f2244f = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.H = webChromeClientCallback;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.O.f2241c = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.G = webviewClientCallback;
    }

    public void setWebviewLoadingView(View view) {
        if (this.Q == null) {
            this.Q = view;
            view.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(WebviewPageFinishCallback webviewPageFinishCallback) {
        this.O.A = webviewPageFinishCallback;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.F = weixinHandler;
    }

    public void showProgress() {
        post(new Runnable() {
            public void run() {
                try {
                    SapiWebView.this.U = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException unused) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void e() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        StringBuilder b2 = a.b(settings.getUserAgentString(), " ");
        b2.append(getUaInfo());
        settings.setUserAgentString(b2.toString());
        settings.setTextSize(TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        View view = this.R;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.S;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() {
                    public void run() {
                        if (SapiWebView.this.Q != null) {
                            SapiWebView.this.Q.setVisibility(0);
                            if (SapiWebView.this.T != null) {
                                SapiWebView.this.T.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.T != null) {
                    SapiWebView.this.T.setVisibility(8);
                }
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void h() {
        stopLoading();
        post(new Runnable() {
            public void run() {
                if (SapiWebView.this.T != null) {
                    SapiWebView.this.T.setVisibility(8);
                }
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                SapiWebView.this.M.f2449a = SapiWebView.this.da.f2458a;
                if (SapiWebView.this.S != null) {
                    SapiWebView.this.S.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void i() {
        CallBacks callBacks = new CallBacks();
        this.O = callBacks;
        this.N = new SapiJsInterpreters(this, callBacks);
        this.ba = 90000;
        this.E = SapiAccountManager.getInstance().getSapiConfiguration();
        this.W = new V();
        this.L = new FaceLoginService().isSupFaceLogin();
        e();
        k();
        setWebViewClient(new WebViewClient() {
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0154, code lost:
                if (r10.contains(r0.toString()) != false) goto L_0x0156;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onPageFinished(android.webkit.WebView r9, java.lang.String r10) {
                /*
                    r8 = this;
                    super.onPageFinished(r9, r10)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.webkit.WebSettings r0 = r0.getSettings()
                    r1 = 0
                    r0.setBlockNetworkLoads(r1)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.Q
                    if (r0 == 0) goto L_0x0020
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.Q
                    r2 = 8
                    r0.setVisibility(r2)
                L_0x0020:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.content.Context r0 = r0.getContext()
                    boolean r0 = com.baidu.sapi2.utils.SapiUtils.hasActiveNetwork(r0)
                    if (r0 == 0) goto L_0x004a
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.R
                    if (r0 == 0) goto L_0x004a
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.R
                    int r0 = r0.getVisibility()
                    r2 = 4
                    if (r0 == r2) goto L_0x004a
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.view.View r0 = r0.R
                    r0.setVisibility(r2)
                L_0x004a:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r2 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())"
                    r0.loadUrl(r2)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiJsCallBacks$CallBacks r0 = r0.O
                    com.baidu.sapi2.SapiWebView$WebViewTitleCallback r0 = r0.f2241c
                    if (r0 == 0) goto L_0x0062
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r2 = "javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));"
                    r0.loadUrl(r2)
                L_0x0062:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    boolean r0 = r0.la
                    r2 = 1
                    if (r0 == 0) goto L_0x0095
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r0 = r0.ma
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L_0x0095
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.Object[] r3 = new java.lang.Object[r2]
                    java.lang.String r4 = r0.ma
                    r3[r1] = r4
                    java.lang.String r4 = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())"
                    java.lang.String r3 = java.lang.String.format(r4, r3)
                    com.baidu.sapi2.SapiWebView.super.loadUrl(r3)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    r0.la = r1
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    r3 = 0
                    r0.ma = r3
                L_0x0095:
                    com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r0 = r0.getAccountService()
                    java.lang.String r0 = r0.j()
                    android.net.Uri r0 = android.net.Uri.parse(r0)
                    com.baidu.sapi2.SapiAccountManager r3 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r3 = r3.getAccountService()
                    java.lang.String r3 = r3.k()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    com.baidu.sapi2.SapiAccountManager r4 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r4 = r4.getAccountService()
                    java.lang.String r4 = r4.l()
                    android.net.Uri r4 = android.net.Uri.parse(r4)
                    com.baidu.sapi2.SapiAccountManager r5 = com.baidu.sapi2.SapiAccountManager.getInstance()
                    com.baidu.sapi2.SapiAccountService r5 = r5.getAccountService()
                    java.lang.String r6 = "account_center"
                    java.lang.String r5 = r5.a(r6)
                    android.net.Uri r5 = android.net.Uri.parse(r5)
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = r5.getHost()
                    r6.append(r7)
                    java.lang.String r5 = r5.getPath()
                    r6.append(r5)
                    java.lang.String r5 = r6.toString()
                    boolean r5 = r10.contains(r5)
                    if (r5 == 0) goto L_0x00fa
                    com.baidu.sapi2.SapiWebView r1 = com.baidu.sapi2.SapiWebView.this
                    r1.ia = r2
                    goto L_0x00ff
                L_0x00fa:
                    com.baidu.sapi2.SapiWebView r2 = com.baidu.sapi2.SapiWebView.this
                    r2.ia = r1
                L_0x00ff:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = r0.getHost()
                    r1.append(r2)
                    java.lang.String r0 = r0.getPath()
                    r1.append(r0)
                    java.lang.String r0 = r1.toString()
                    boolean r0 = r10.contains(r0)
                    if (r0 != 0) goto L_0x0156
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = r3.getHost()
                    r0.append(r1)
                    java.lang.String r1 = r3.getPath()
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    boolean r0 = r10.contains(r0)
                    if (r0 != 0) goto L_0x0156
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = r4.getHost()
                    r0.append(r1)
                    java.lang.String r1 = r4.getPath()
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    boolean r0 = r10.contains(r0)
                    if (r0 == 0) goto L_0x016f
                L_0x0156:
                    android.net.Uri r0 = android.net.Uri.parse(r10)
                    java.lang.String r1 = "wapsec"
                    java.lang.String r0 = r0.getQueryParameter(r1)
                    java.lang.String r1 = "center"
                    boolean r0 = r1.equals(r0)
                    if (r0 != 0) goto L_0x016f
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    java.lang.String r1 = "javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));"
                    r0.loadUrl(r1)
                L_0x016f:
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    android.os.Handler r0 = r0.ca
                    com.baidu.sapi2.SapiWebView r1 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$TimeoutTask r1 = r1.da
                    r0.removeCallbacks(r1)
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$WebviewClientCallback r0 = r0.G
                    if (r0 == 0) goto L_0x018f
                    com.baidu.sapi2.SapiWebView r0 = com.baidu.sapi2.SapiWebView.this
                    com.baidu.sapi2.SapiWebView$WebviewClientCallback r0 = r0.G
                    r0.onPageFinished(r9, r10)
                L_0x018f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiWebView.AnonymousClass2.onPageFinished(android.webkit.WebView, java.lang.String):void");
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (SapiWebView.this.O.J != null) {
                    Uri parse = Uri.parse(SapiWebView.this.getLoginUrl());
                    Uri parse2 = Uri.parse(str);
                    if (parse2 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(parse2.getHost());
                        sb.append(parse2.getPath());
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(parse.getHost());
                        sb3.append(parse.getPath());
                        if (sb2.equals(sb3.toString())) {
                            SapiWebView.this.O.J.pageState(1);
                        }
                    }
                    SapiWebView.this.O.J.pageState(2);
                }
                if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                    SapiWebView.this.g();
                }
                SapiWebView.this.da.setUrl(str);
                SapiWebView.this.ca.postDelayed(SapiWebView.this.da, SapiWebView.this.ba);
                SapiWebView.this.f();
                if (str != null) {
                    String str2 = SapiWebView.f2392g;
                    boolean contains = str.contains(str2);
                    String str3 = SapiWebView.f2393h;
                    String str4 = SapiWebView.f2391f;
                    if (contains || str.contains(str3)) {
                        String queryParameter = Uri.parse(str).getQueryParameter(str4);
                        if (str2.equals(queryParameter) && SapiWebView.this.J != null) {
                            SapiWebView.this.post(new Runnable() {
                                public void run() {
                                    SapiWebView.this.stopLoading();
                                    if (SapiWebView.this.J != null) {
                                        SapiWebView.this.J.onSuccess();
                                    }
                                }
                            });
                        }
                        if (str3.equals(queryParameter) && SapiWebView.this.J != null) {
                            SapiWebView.this.post(new Runnable() {
                                public void run() {
                                    SapiWebView.this.stopLoading();
                                    final String cookieBduss = SapiUtils.getCookieBduss();
                                    final String cookiePtoken = SapiUtils.getCookiePtoken();
                                    if (!TextUtils.isEmpty(cookieBduss)) {
                                        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                                            public void onFinish() {
                                                SapiWebView.this.dismissProgress();
                                            }

                                            public void onStart() {
                                                SapiWebView.this.showProgress();
                                            }

                                            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                                if (SapiWebView.this.J != null) {
                                                    SapiWebView.this.J.onSuccess();
                                                }
                                            }

                                            public void onFailure(GetUserInfoResult getUserInfoResult) {
                                                if (SapiWebView.this.J != null) {
                                                    SapiWebView.this.J.onSuccess();
                                                }
                                            }

                                            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                                                if (currentAccount != null) {
                                                    if (currentAccount.uid.equals(getUserInfoResult.uid)) {
                                                        currentAccount.bduss = cookieBduss;
                                                    }
                                                    if (!TextUtils.isEmpty(cookiePtoken)) {
                                                        currentAccount.ptoken = cookiePtoken;
                                                    }
                                                    currentAccount.deleteStokens();
                                                }
                                                SapiAccountManager.getInstance().validate(currentAccount);
                                                SapiAccountManager.getInstance().preFetchStoken(currentAccount, true);
                                                if (SapiWebView.this.J != null) {
                                                    SapiWebView.this.J.onSuccess();
                                                }
                                            }
                                        }, cookieBduss);
                                    } else if (SapiWebView.this.J != null) {
                                        SapiWebView.this.J.onSuccess();
                                    }
                                }
                            });
                        }
                    }
                    if (str.contains("__wp-action=renren-offline")) {
                        if (SapiWebView.f2390e.equals(Uri.parse(str).getQueryParameter(str4))) {
                            if (SapiWebView.this.O.U != null) {
                                SapiWebView sapiWebView = SapiWebView.this;
                                sapiWebView.a(sapiWebView.O.U);
                            } else if (SapiWebView.this.O.I != null) {
                                SapiWebView.this.post(new Runnable() {
                                    public void run() {
                                        if (SapiWebView.this.O.I != null) {
                                            SapiWebView.this.O.I.onFailed(-100, Web2NativeLoginResult.ERROR_MSG_UNKNOWN);
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.onPageStarted(webView, str, bitmap);
                }
            }

            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                if (i2 == -8 || i2 == -6 || i2 == -2 || i2 == -5) {
                    SapiWebView.this.h();
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                StringBuilder sb = new StringBuilder();
                sb.append(sslError.getPrimaryError());
                sb.append("");
                t.a("sslerr_view", Collections.singletonMap("na_err_code", sb.toString()));
                if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) && !(!SapiWebView.this.E.forbidSslErrorDialog)) {
                    if (SapiWebView.this.V == null) {
                        String format = new SimpleDateFormat(SapiWebView.y).format(new Date(System.currentTimeMillis()));
                        Builder builder = new Builder(SapiWebView.this.getContext());
                        builder.setTitle(SapiWebView.w);
                        builder.setMessage(format);
                        builder.setPositiveButton(SapiWebView.B, new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                intent.setFlags(268435456);
                                SapiWebView.this.getContext().startActivity(intent);
                                dialogInterface.dismiss();
                                t.a("sslerr_date_setting", null);
                            }
                        });
                        builder.setNegativeButton(SapiWebView.A, new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                                t.a("sslerr_date_cancel", null);
                            }
                        });
                        SapiWebView.this.V = builder.create();
                    }
                    if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.V.isShowing()) {
                        SapiWebView.this.V.show();
                    }
                }
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.f2387b)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", "utf-8", g.a(SapiWebView.this.getContext(), str));
                        }
                    }
                } catch (Exception unused) {
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    if (str.startsWith("sms") || str.startsWith("tel") || str.startsWith("bdscenter")) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            SapiWebView.this.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        return true;
                    } else if (str.startsWith("wtloginmqq")) {
                        return true;
                    } else {
                        if (j.a(j.m).equals(str)) {
                            SapiWebView.this.finish();
                        }
                        if (!(SapiWebView.this.O.Z == null || SapiWebView.this.O.Z.redirectUrl == null || !str.contains(SapiWebView.this.O.Z.redirectUrl))) {
                            SapiWebView.this.O.Z.callback.onCallback(str);
                            return true;
                        }
                    }
                }
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.shouldOverrideUrlLoading(webView, str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }
        });
        setWebChromeClient(new WebChromeClient() {
            public void onConsoleMessage(String str, int i2, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" -- From line ");
                sb.append(i2);
                sb.append(" of ");
                sb.append(str2);
                Log.d(sb.toString(), new Object[0]);
                if (SapiWebView.this.H != null) {
                    SapiWebView.this.H.onConsoleMessage(str, i2, str2);
                }
            }

            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                Builder positiveButton = new Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        jsResult.confirm();
                    }
                });
                positiveButton.setCancelable(false);
                positiveButton.create();
                positiveButton.show();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.H != null && SapiWebView.this.H.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.H.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.e(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.O.Q = jsPromptResult;
                SapiWebView.this.post(new Runnable() {
                    public void run() {
                        String str = "msg";
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.P.contains(actionName)) {
                                SapiWebView.this.O.Q = jsPromptResult;
                            }
                            AbstractInterpreter a2 = SapiWebView.this.N.a(actionName);
                            if (a2 != null) {
                                try {
                                    strArr[0] = a2.interpret(parse);
                                } catch (Throwable th) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("errno", 0);
                                        jSONObject.put(str, "native function error");
                                        strArr[0] = jSONObject.toString();
                                        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                        linkedHashMap.put("name", "native_fun_error");
                                        HashMap hashMap = new HashMap(2);
                                        hashMap.put(str, android.util.Log.getStackTraceString(th));
                                        hashMap.put("action_name", actionName);
                                        t.a(linkedHashMap, (Map<String, String>) hashMap);
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            if (parse.getActionParams().size() > 2) {
                                if (SapiWebView.f2386a.equals(parse.getActionParams().get(2))) {
                                    jsPromptResult.cancel();
                                    return;
                                }
                            }
                            if (!SapiWebView.this.P.contains(actionName)) {
                                jsPromptResult.confirm(strArr[0]);
                            }
                            return;
                        }
                        jsPromptResult.cancel();
                    }
                });
                return true;
            }

            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.T != null) {
                    if (i2 == 100) {
                        SapiWebView.this.T.setVisibility(8);
                    } else {
                        if (SapiWebView.this.T.getVisibility() == 8) {
                            SapiWebView.this.T.setVisibility(0);
                        }
                        SapiWebView.this.T.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }

            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j2, long j3, QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(j2 * 2);
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooserForOSVersion5(valueCallback);
                }
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.I != null) {
                    SapiWebView.this.I.onFileChooser(valueCallback);
                }
            }
        });
        CallBacks callBacks2 = this.O;
        if (callBacks2.I == null) {
            callBacks2.I = new DefaultAuthorizationListener();
        }
        if (this.F == null) {
            this.F = new DefaultWeixinHandler();
        }
        this.O.f2240b = new SmsHandler();
        this.O.P = new Runnable() {
            public void run() {
                SapiWebView.this.l();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        q qVar = statLoadLogin;
        if (qVar != null) {
            qVar.f3120h = System.currentTimeMillis();
        }
    }

    private boolean j() {
        for (String matches : SapiContext.getInstance().getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(matches)) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        this.P = arrayList;
        arrayList.add("sapi_action_pick_image");
        this.P.add("sapi_action_pick_date");
        this.P.add("sapi_biometrics_identification");
        this.P.add("sapi_biometrics_identification_no_bduss");
        this.P.add("sapi_biometrics_identification_with_authtoken");
        this.P.add("sapi_biometrics_identification_with_uid");
        this.P.add("sapi_action_sc_app_invoke");
        this.P.add("oauth_sso_hash");
        this.P.add("sapi_action_china_mobile_oauth");
        this.P.add("sapi_action_upsms");
        this.P.add("address_manage_get_contact");
        this.P.add("touchid_open_guide");
        this.P.add("touchid_change_status");
        this.P.add("touchid_login");
        this.P.add("speech_recognition_get_content");
    }

    /* access modifiers changed from: private */
    public void l() {
        if (this.ea != null) {
            try {
                getContext().unregisterReceiver(this.ea);
            } catch (Throwable unused) {
            }
        }
        this.ea = null;
    }

    public void finish(final String str) {
        l();
        post(new Runnable() {
            public void run() {
                if (!SapiWebView.this.aa) {
                    SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                    if (TextUtils.isEmpty(str)) {
                        if (SapiWebView.this.fa != null) {
                            SapiWebView.this.fa.onFinish();
                        }
                    } else if (SapiWebView.this.O.H != null) {
                        SapiWebView.this.O.H.onFinish(str);
                    }
                }
            }
        });
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(new PassNameValuePair("clientfrom", SapiAccountService.f2213b));
            list.add(new PassNameValuePair("client", SapiDeviceInfo.f3010c));
            String str3 = "1";
            list.add(new PassNameValuePair("deliverParams", str3));
            if (this.E.supportFaceLogin) {
                list.add(new PassNameValuePair("scanface", str3));
            }
            if (this.O.f2248j != null && this.E.supportPhoto) {
                list.add(new PassNameValuePair("support_photo", str3));
            }
            String str4 = "?";
            int indexOf = str.indexOf(str4);
            if (indexOf > 0) {
                int i2 = indexOf + 1;
                String substring = str.substring(0, i2);
                String substring2 = str.substring(i2, str.length());
                StringBuilder a2 = a.a(substring);
                a2.append(SapiUtils.createRequestParams(list));
                a2.append("&");
                a2.append(substring2);
                str2 = a2.toString();
            } else {
                StringBuilder b2 = a.b(str, str4);
                b2.append(SapiUtils.createRequestParams(list));
                str2 = b2.toString();
            }
            loadUrl(str2);
            return;
        }
        throw new IllegalArgumentException("externalUrl can't be empty");
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String str2 = "u";
            StringBuilder sb = new StringBuilder();
            sb.append(j.a(j.l));
            sb.append("?");
            sb.append(f2391f);
            sb.append("=");
            sb.append(f2392g);
            arrayList.add(new PassNameValuePair(str2, URLEncoder.encode(sb.toString(), "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String forgetPwdUrl = getForgetPwdUrl();
        if (arrayList.size() > 0) {
            StringBuilder b2 = a.b(forgetPwdUrl, "&");
            b2.append(SapiUtils.createRequestParams(arrayList));
            forgetPwdUrl = b2.toString();
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadLogin(int i2) {
        loadLogin(i2, null);
    }

    public void loadModifyPwd(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(getContext(), str);
            ArrayList arrayList = new ArrayList();
            try {
                String str3 = "u";
                StringBuilder sb = new StringBuilder();
                sb.append(j.a(j.l));
                sb.append("?");
                sb.append(f2391f);
                sb.append("=");
                sb.append(f2393h);
                arrayList.add(new PassNameValuePair(str3, URLEncoder.encode(sb.toString(), "UTF-8")));
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            String modifyPwdUrl = getModifyPwdUrl();
            if (arrayList.size() > 0) {
                StringBuilder b2 = a.b(modifyPwdUrl, "&");
                b2.append(SapiUtils.createRequestParams(arrayList));
                modifyPwdUrl = b2.toString();
            }
            String a2 = a();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new PassNameValuePair(this.E.environment.getWap(), a2));
            loadUrl(modifyPwdUrl, arrayList2);
            return;
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadOperationRecord(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(getContext(), str);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str2)) {
                a.a("skin", str2, arrayList);
            }
            String wapOpRecordUrl = getWapOpRecordUrl();
            if (arrayList.size() > 0) {
                StringBuilder b2 = a.b(wapOpRecordUrl, "&");
                b2.append(SapiUtils.createRequestParams(arrayList));
                wapOpRecordUrl = b2.toString();
            }
            loadUrl(wapOpRecordUrl);
            return;
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        String str2;
        d(str);
        if (TextUtils.isEmpty(str) || str.contains("javascript:")) {
            str2 = null;
        } else {
            a(list);
            str2 = this.W.b(getContext(), str);
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            String a2 = a(str3, str);
            loadDataWithBaseURL(a2, str3, f2394i, "UTF-8", a2);
            return;
        }
        c(str);
    }

    private void c(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.O.f2247i != null) {
            a2 = a.a(a2, "&enableExternalWeb=1");
        }
        if (this.E.supportFaceLogin) {
            a2 = a.a(a2, "&liveAbility=1");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(m);
        loadUrl(sb.toString());
    }

    private void d(String str) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(p) || str.contains(m) || str.contains(r) || str.contains(q) || (this.L && str.contains(u))) {
                statLoadLogin.f3122j = System.currentTimeMillis();
            }
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a2 = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        String str3 = "1";
        if (this.O.f2248j != null && this.E.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", str3));
        }
        if (this.O.f2243e != null && this.E.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", str3));
        }
        loadUrl(a(a2, list));
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    private String b(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", new Object[]{str, str});
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        if (!this.E.supportFaceLogin || this.O.f2243e != null) {
            q qVar = statLoadLogin;
            if (qVar != null) {
                qVar.f3121i = System.currentTimeMillis();
            }
            this.extras = list;
            boolean z2 = true;
            this.ka = true;
            if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
                b(i2, list);
            } else if (4 == i2) {
                c(list);
            } else if (i2 == 6) {
                a(i2);
            } else {
                List shareStorageModel = SapiShareClient.getInstance().getShareStorageModel(this.E.context);
                if (!SapiShareClient.isInV2ShareDisableWhiteList() || !this.shareV2Disable) {
                    z2 = false;
                }
                this.shareV2Disable = z2;
                if (this.O.s != null && shareStorageModel != null && shareStorageModel.size() > 0 && !this.shareV2Disable) {
                    list.add(new PassNameValuePair("share_version", "2"));
                    c(i2, list);
                } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                    c(i2, list);
                } else if (this.L) {
                    b(list);
                } else if (new c().a()) {
                    a(i2, list);
                } else {
                    b(i2, list);
                }
            }
            SapiStatUtil.statLoadLogin(null);
            return;
        }
        throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
    }

    private void b(List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        if (this.O.f2247i != null) {
            a2 = a.a(a2, "&enableExternalWeb=1");
        }
        String a3 = a.a(a2, "&liveAbility=1");
        StringBuilder sb = new StringBuilder();
        sb.append(a3);
        sb.append(u);
        loadUrl(sb.toString());
    }

    public List<PassNameValuePair> d() {
        String str;
        List n2 = SapiContext.getInstance().getSapiOptions().n();
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        String replaceAll = this.E.environment.getWap().replace("http://", str2).replace("https://", str2).replaceAll("(:[0-9]{1,4})?", str2);
        if (n2.size() != 1 || !((String) n2.get(0)).equals("di")) {
            str = SapiDeviceInfo.getDiCookieInfo(n2);
        } else {
            str = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        }
        String wap = this.E.environment.getWap();
        if (str != null) {
            str2 = str;
        }
        arrayList.add(new PassNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", str2)));
        return arrayList;
    }

    private void c(int i2, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.O.f2247i != null) {
            loginUrl = a.a(loginUrl, "&enableExternalWeb=1");
        }
        if (this.E.supportFaceLogin) {
            loginUrl = a.a(loginUrl, "&liveAbility=1");
        }
        if (this.L && this.O.f2243e != null) {
            str = a.a(loginUrl, "&loginInitType=4");
        } else if (new c().a()) {
            str = a.a(loginUrl, "&loginInitType=5");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(loginUrl);
            sb.append("&loginInitType=");
            sb.append(i2);
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a(str, list));
        sb2.append(p);
        loadUrl(sb2.toString());
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    private void a(int i2) {
        String a2 = a(getLoginUrl(), this.extras);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("&loginInitType=");
        sb.append(i2);
        String sb2 = sb.toString();
        if (this.O.f2247i != null) {
            sb2 = a.a(sb2, "&enableExternalWeb=1");
        }
        if (this.E.supportFaceLogin) {
            sb2 = a.a(sb2, "&liveAbility=1");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(l);
        loadUrl(sb3.toString());
    }

    private void b(int i2, List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("&loginInitType=");
        sb.append(i2);
        String sb2 = sb.toString();
        String str = "&liveAbility=1";
        String str2 = k;
        String str3 = "&enableExternalWeb=1";
        if (i2 == 0) {
            if (this.O.f2247i != null) {
                sb2 = a.a(sb2, str3);
            }
            if (this.E.supportFaceLogin) {
                sb2 = a.a(sb2, str);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str2);
            loadUrl(sb3.toString());
        } else if (i2 != 1) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(str2);
            loadUrl(sb4.toString());
        } else {
            if (this.O.f2247i != null) {
                sb2 = a.a(sb2, str3);
            }
            if (this.E.supportFaceLogin) {
                sb2 = a.a(sb2, str);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(q);
            loadUrl(sb5.toString());
        }
    }

    private void a(int i2, List<PassNameValuePair> list) {
        String a2 = a(getLoginUrl(), list);
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("&loginInitType=");
        sb.append(i2);
        String sb2 = sb.toString();
        if (this.O.f2247i != null) {
            sb2 = a.a(sb2, "&enableExternalWeb=1");
        }
        if (this.E.supportFaceLogin) {
            sb2 = a.a(sb2, "&liveAbility=1");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(s);
        loadUrl(sb3.toString());
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        i();
    }

    private void c(final String str) {
        post(new Runnable() {
            public void run() {
                if (!SapiWebView.this.aa) {
                    SapiWebView.this.a(str, false);
                    SapiWebView.super.loadUrl(str);
                }
            }
        });
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            g();
        }
    }

    public static SocialResponse b(String str, Context context) {
        SocialResponse socialResponse;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        SocialResponse socialResponse2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA)) {
                        String str2 = WXLoginActivity.KEY_BASE_RESP_ERROR_CODE;
                        if (socialResponse2 == null) {
                            if (name.equalsIgnoreCase(str2)) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        }
                        String str3 = "error_description";
                        if (socialResponse2 == null) {
                            if (name.equalsIgnoreCase(str3)) {
                                socialResponse = new SocialResponse();
                                socialResponse.errorMsg = newPullParser.nextText();
                            }
                        }
                        if (socialResponse2 != null) {
                            if (name.equalsIgnoreCase(str2)) {
                                socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase(str3)) {
                                socialResponse2.errorMsg = newPullParser.nextText();
                            } else {
                                String str4 = "1";
                                if (name.equalsIgnoreCase("is_binded")) {
                                    socialResponse2.isBinded = str4.equals(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase("display_name")) {
                                    socialResponse2.displayname = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("passport_uname")) {
                                    socialResponse2.username = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("bduid")) {
                                    socialResponse2.uid = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("bduss")) {
                                    socialResponse2.bduss = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase(SapiAccount.f2187g)) {
                                    socialResponse2.ptoken = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("os_username")) {
                                    socialResponse2.socialUname = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("os_headurl")) {
                                    socialResponse2.socialPortraitUrl = newPullParser.nextText();
                                } else if (name.equalsIgnoreCase("os_type")) {
                                    socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                } else if (name.equalsIgnoreCase("notice_offline")) {
                                    socialResponse2.offlineNotice = str4.equals(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase("guidebind")) {
                                    socialResponse2.bindGuide = str4.equals(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase("bind_conflict")) {
                                    socialResponse2.bindConflict = str4.equals(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase("wapsec")) {
                                    socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                                } else if (name.equalsIgnoreCase("next_url_related")) {
                                    String nextText = newPullParser.nextText();
                                    if (socialResponse2.accountCenterFlag) {
                                        socialResponse2.nextUrl = nextText;
                                    }
                                } else if (name.equalsIgnoreCase("incomplete_user")) {
                                    String nextText2 = newPullParser.nextText();
                                    if ("0".equals(nextText2)) {
                                        socialResponse2.accountType = AccountType.NORMAL;
                                    } else if (str4.equals(nextText2)) {
                                        socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                    } else {
                                        socialResponse2.accountType = AccountType.UNKNOWN;
                                    }
                                } else if (name.equalsIgnoreCase(SapiAccount.f2188h)) {
                                    String[] split = newPullParser.nextText().split("#");
                                    socialResponse2.tplStokenMap.put(split[0], split[1]);
                                } else if (name.equalsIgnoreCase("actiontype")) {
                                    socialResponse2.actionType = newPullParser.nextText();
                                } else if (name.equals("livinguname")) {
                                    socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                } else if (name.equals("guest_account")) {
                                    socialResponse2.isGuestAccount = newPullParser.nextText();
                                }
                            }
                        }
                    } else if (socialResponse2 == null) {
                        socialResponse = new SocialResponse();
                    }
                    socialResponse2 = socialResponse;
                }
                try {
                    eventType = newPullParser.next();
                } catch (Exception e3) {
                    e = e3;
                    socialResponse = socialResponse2;
                    socialResponse2 = socialResponse;
                    Log.e(e);
                    return socialResponse2;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        return socialResponse2;
    }

    public List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        String str = "http://";
        String str2 = "";
        String str3 = "https://";
        String str4 = "(:[0-9]{1,4})?";
        String replaceAll = this.E.environment.getWap().replace(str, str2).replace(str3, str2).replaceAll(str4, str2);
        String replaceAll2 = this.E.environment.getURL().replace(str, str2).replace(str3, str2).replaceAll(str4, str2);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            String str5 = "dark";
            arrayList.add(new PassNameValuePair(this.E.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, str5)));
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, str5)));
        } else {
            String str6 = "light";
            arrayList.add(new PassNameValuePair(this.E.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, str6)));
            arrayList.add(new PassNameValuePair(this.E.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, str6)));
        }
        return arrayList;
    }

    private String a(String str, List<PassNameValuePair> list) {
        String str2 = "UTF-8";
        if (list == null) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        for (PassNameValuePair passNameValuePair : list) {
            if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                try {
                    arrayList.add(new PassNameValuePair(URLEncoder.encode(passNameValuePair.getName(), str2), URLEncoder.encode(passNameValuePair.getValue(), str2)));
                } catch (UnsupportedEncodingException e2) {
                    Log.e(e2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return str;
        }
        StringBuilder b2 = a.b(str, "&");
        b2.append(SapiUtils.createRequestParams(arrayList));
        return b2.toString();
    }

    public void a(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(p) || str.contains(m) || str.contains(r) || str.contains(q) || (this.L && str.contains(u))) {
                statLoadLogin.k = System.currentTimeMillis();
                statLoadLogin.l = z2;
            }
        }
    }

    public SapiAccountResponse a(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        String str2 = "";
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            boolean z2 = false;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA)) {
                        if (sapiAccountResponse2 == null) {
                            if (name.equalsIgnoreCase(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE)) {
                                sapiAccountResponse = new SapiAccountResponse();
                                try {
                                    sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                        }
                        if (sapiAccountResponse2 == null) {
                            if (name.equalsIgnoreCase("error_description")) {
                                sapiAccountResponse = new SapiAccountResponse();
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                            }
                        }
                        if (sapiAccountResponse2 != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse2.username = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bduss")) {
                                sapiAccountResponse2.bduss = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.f2187g)) {
                                sapiAccountResponse2.ptoken = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase(SapiAccount.f2188h)) {
                                if (z2) {
                                    String[] split = newPullParser.nextText().split("#");
                                    if (split != null && split.length > 1) {
                                        sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                    }
                                } else {
                                    sapiAccountResponse2.stoken = newPullParser.nextText();
                                }
                            } else if (name.equalsIgnoreCase("displayname")) {
                                sapiAccountResponse2.displayname = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("uid")) {
                                sapiAccountResponse2.uid = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("authsid")) {
                                String nextText = newPullParser.nextText();
                                sapiAccountResponse2.authSid = nextText;
                                sapiAccountResponse2.newReg = !TextUtils.isEmpty(nextText);
                            } else if (name.equalsIgnoreCase(ExtraProperty.EXTRA_TPL_STOKEN_LIST)) {
                                z2 = true;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("os_type")) {
                                sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            } else if (name.equalsIgnoreCase("incomplete_user")) {
                                String nextText2 = newPullParser.nextText();
                                if ("0".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.NORMAL;
                                } else if ("1".equals(nextText2)) {
                                    sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                } else {
                                    sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                }
                            } else if (name.equalsIgnoreCase("actiontype")) {
                                sapiAccountResponse2.actionType = newPullParser.nextText();
                            } else if (name.equals("livinguname")) {
                                sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            } else if ("loginType".equals(name)) {
                                String nextText3 = newPullParser.nextText();
                                if ("oneKeyLogin".equals(nextText3)) {
                                    nextText3 = new c().c();
                                }
                                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
                            } else if (name.equals("mobilephone")) {
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            } else if (name.equals("app")) {
                                sapiAccountResponse2.app = newPullParser.nextText();
                            } else if (name.equals(SapiAccount.SAPI_ACCOUNT_EXTRA)) {
                                sapiAccountResponse2.extra = newPullParser.nextText();
                            } else if (name.equals("portraitSign")) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText();
                            } else if (name.equals(SapiAccount.SAPI_ACCOUNT_PORTRAIT)) {
                                sapiAccountResponse2.portraitSign = newPullParser.nextText().replace("https://himg.bdimg.com/sys/portrait/item/", str2).replace("http://himg.bdimg.com/sys/portrait/item/", str2).replace(".jpg", str2);
                            }
                        }
                    } else if (sapiAccountResponse2 == null) {
                        sapiAccountResponse = new SapiAccountResponse();
                    }
                    sapiAccountResponse2 = sapiAccountResponse;
                }
                try {
                    eventType = newPullParser.next();
                } catch (Throwable th2) {
                    th = th2;
                    sapiAccountResponse = sapiAccountResponse2;
                    sapiAccountResponse2 = sapiAccountResponse;
                    Log.e(th);
                    sapiAccountResponse2.errorCode = 0;
                    return sapiAccountResponse2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

    public SapiAccount b(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(getContext()) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        sapiAccount.portrait = sapiAccountResponse.portraitSign;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.E.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    public static String b(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    public void a(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount b2 = b(sapiAccountResponse);
            if (this.O.I != null) {
                post(new Runnable() {
                    public void run() {
                        try {
                            SapiWebView.this.O.I.beforeSuccess(b2);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiShareClient.getInstance().validate(b2);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(b2, SapiWebView.this.extras);
                    }
                });
            }
        }
    }

    public List<PassNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        if (this.E.supportFaceLogin) {
            CallBacks callBacks = this.O;
            if (!(callBacks.f2242d == null || callBacks.f2243e == null)) {
                a.a("liveAbility", "1", arrayList);
            }
        }
        return arrayList;
    }

    public void a(final SocialResponse socialResponse) {
        if (socialResponse != null) {
            final SapiAccount b2 = b((SapiAccountResponse) socialResponse);
            if (SapiUtils.isValidAccount(b2)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag) {
                int i2 = socialResponse.errorCode;
                if (i2 == 0 || i2 == 110000) {
                    post(new Runnable() {
                        public void run() {
                            SapiWebView.this.loadUrl(socialResponse.nextUrl);
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            SapiShareClient.getInstance().validate(b2);
                            if (SapiWebView.this.K != null && !currentAccount.uid.equals(b2.uid)) {
                                SapiWebView.this.K.onAccountChange();
                            }
                        }
                    });
                    return;
                }
            }
            if (this.O.I != null) {
                int i3 = socialResponse.errorCode;
                if (i3 == 0 || i3 == 110000) {
                    post(new Runnable() {
                        public void run() {
                            try {
                                if (SapiWebView.this.O.I != null) {
                                    SapiWebView.this.O.I.beforeSuccess(b2);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            SapiShareClient.getInstance().validate(b2);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.O.U = null;
                        }
                    });
                } else {
                    post(new Runnable() {
                        public void run() {
                            if (SapiWebView.this.O.I != null) {
                                AuthorizationListener authorizationListener = SapiWebView.this.O.I;
                                SocialResponse socialResponse = socialResponse;
                                authorizationListener.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                            }
                            SapiWebView.this.O.U = null;
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (!TextUtils.isEmpty(this.O.O[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.O.O;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        SapiUtils.reportGid(this.ka ? i.f3087b : i.f3088c);
        AuthorizationListener authorizationListener = this.O.I;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", new Class[]{AccountType.class}).getDeclaringClass())) {
                    this.O.I.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.O.I.onSuccess();
        }
    }

    public void a(Handler handler) {
        if (this.ea == null) {
            g.a(getContext(), handler, new RequestSMSCallback() {
                public void receiverResult(BroadcastReceiver broadcastReceiver) {
                    SapiWebView.this.ea = broadcastReceiver;
                }
            });
        }
    }

    public String a(String str, String str2) {
        String str3 = "#";
        String[] split = str2.split(str3);
        if (split.length <= 1) {
            return str2;
        }
        String str4 = "";
        X sapiOptions = SapiContext.getInstance().getSapiOptions();
        String a2 = this.W.a(str2);
        if (this.W.c(getContext(), a2) != null) {
            String str5 = this.W.c(getContext(), a2).f2487c;
            String a3 = Utils.a(str.getBytes(), false);
            String b2 = sapiOptions.e().b();
            boolean equals = str5.equals(a3);
            String str6 = "&passAppHash=";
            if (equals) {
                if (!TextUtils.isEmpty(b2)) {
                    str4 = a.a(str4, "&passAppVersion=", b2);
                }
                StringBuilder b3 = a.b(str4, str6);
                b3.append(this.W.c(getContext(), a2).f2487c);
                str4 = b3.toString();
            } else {
                StringBuilder b4 = a.b(str4, str6);
                b4.append(Utils.a(str.getBytes(), false));
                str4 = b4.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        sb.append(str4);
        sb.append(str3);
        sb.append(split[1]);
        return sb.toString();
    }

    public String a() {
        String str = "";
        return SapiUtils.buildBDUSSCookie(this.E.environment.getWap().replace("http://", str).replace("https://", str).replaceAll("(:[0-9]{1,4})?", str), "BIND_BDUSS", str);
    }

    public void a(List<PassNameValuePair> list) {
        List d2 = d();
        List c2 = c();
        if (list != null && !list.isEmpty()) {
            d2.addAll(list);
        }
        if (c2 != null && !c2.isEmpty()) {
            d2.addAll(c2);
        }
        SapiUtils.syncCookies(getContext(), d2);
    }

    public String a(BindWidgetAction bindWidgetAction) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String a(SocialType socialType) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(socialType));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(str));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String a(SocialType socialType, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(socialType, str, str2, str3));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(str, str2, str3));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }

    public String a(String str, String str2, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SapiAccountManager.getInstance().getAccountService().a(str, str2, z2));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(b()));
        return sb.toString();
    }
}
