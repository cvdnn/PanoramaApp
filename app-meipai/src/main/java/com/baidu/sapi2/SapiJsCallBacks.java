package com.baidu.sapi2;

import android.app.Activity;
import android.os.Handler;
import android.webkit.JsPromptResult;
import com.baidu.sapi2.SapiWebView.AccountDestoryCallback;
import com.baidu.sapi2.SapiWebView.AccountFreezeCallback;
import com.baidu.sapi2.SapiWebView.BdussChangeCallback;
import com.baidu.sapi2.SapiWebView.BindWidgetCallback;
import com.baidu.sapi2.SapiWebView.BioScanFaceCallback;
import com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback;
import com.baidu.sapi2.SapiWebView.CoverWebBdussCallback;
import com.baidu.sapi2.SapiWebView.InvokeScAppCallback;
import com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback;
import com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback;
import com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback;
import com.baidu.sapi2.SapiWebView.LocalConfigCallback;
import com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback;
import com.baidu.sapi2.SapiWebView.PickPhotoCallback;
import com.baidu.sapi2.SapiWebView.PreFillUserNameCallback;
import com.baidu.sapi2.SapiWebView.QrLoginCallback;
import com.baidu.sapi2.SapiWebView.QuickLoginHandler;
import com.baidu.sapi2.SapiWebView.RealnameAuthenticateCallback;
import com.baidu.sapi2.SapiWebView.ShareAccountClickCallback;
import com.baidu.sapi2.SapiWebView.SmsHandler;
import com.baidu.sapi2.SapiWebView.SwitchAccountCallback;
import com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback;
import com.baidu.sapi2.SapiWebView.UniteVerifyCallback;
import com.baidu.sapi2.SapiWebView.WebViewTitleCallback;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class SapiJsCallBacks {

    public interface AddressManageCallback {
        void onCallback(String str);
    }

    public interface BdOauthCallback {
        void onCallback(String str);
    }

    public static class BdOauthLoginParams {
        public BdOauthCallback callback;
        public String callingAppId;
        public String callingPkg;
        public String redirectUrl;
    }

    public interface BuildCustomAlertDialog {
        AlertDialogInterface buildDialog(Activity activity);
    }

    public static class CallBacks {
        public WebviewPageFinishCallback A;
        public RealNameStatusCallback B;
        public LoginStatusChangeCallback C;
        public GrantWebCallback D;
        public CurrentAccountBdussExpiredCallback E;
        public StopSlideWebviewCallback F;
        public GetCurrentPageNameCallback G;
        public OnSlidePageFinishCallback H;
        public AuthorizationListener I;
        public PageStateCallback J;
        public BuildCustomAlertDialog K;
        public AddressManageCallback L;
        public InvoiceBuildCallback M;
        public FingerprintCallback N;
        public String[] O = new String[2];
        public Runnable P;
        public JsPromptResult Q;
        public int R = 1;
        public boolean S;
        public String T;
        public SocialResponse U;
        public JoinLoginParams V;
        public String W;
        public DirectedLoginParams X;
        public boolean Y;
        public BdOauthLoginParams Z;

        /* renamed from: a reason: collision with root package name */
        public Handler f2239a;
        public ShareV2LoginParams aa;

        /* renamed from: b reason: collision with root package name */
        public SmsHandler f2240b;

        /* renamed from: c reason: collision with root package name */
        public WebViewTitleCallback f2241c;

        /* renamed from: d reason: collision with root package name */
        public BioScanFaceCallback f2242d;

        /* renamed from: e reason: collision with root package name */
        public BiometricsIdentifyCallback f2243e;

        /* renamed from: f reason: collision with root package name */
        public UniteVerifyCallback f2244f;

        /* renamed from: g reason: collision with root package name */
        public QuickLoginHandler f2245g;

        /* renamed from: h reason: collision with root package name */
        public BindWidgetCallback f2246h;

        /* renamed from: i reason: collision with root package name */
        public LoadExternalWebViewCallback f2247i;

        /* renamed from: j reason: collision with root package name */
        public PickPhotoCallback f2248j;
        public BdussChangeCallback k;
        public SwitchAccountCallback l;
        public LeftBtnVisibleCallback m;
        public RealnameAuthenticateCallback n;
        public CoverWebBdussCallback o;
        public PreFillUserNameCallback p;
        public AccountDestoryCallback q;
        public AccountFreezeCallback r;
        public ShareAccountClickCallback s;
        public QrLoginCallback t;
        public SystemUpwardSmsCallback u;
        public InvokeScAppCallback v;
        public LocalConfigCallback w;
        public LoadSlideWebViewCallback x;
        public SpeechRecognitionCallback y;
        public NormalizeGuestAccountCallback z;
    }

    public interface CurrentAccountBdussExpiredCallback {
        void onBdussExpired();
    }

    public static class DirectedLoginParams {
        public String displayname;
        public String encryptedId;
        public String uid;
    }

    public static abstract class FingerprintCallback {
        public abstract void onCallback(FingerprintResult fingerprintResult);
    }

    public static abstract class FingerprintResult {
        public int authType;
        public String portrait;

        public abstract void setResult(int i2);
    }

    public interface GetCurrentPageNameCallback {
        public static final String ADDRESS_EDIT_PAGE = "address_edit";
        public static final String ADDRESS_LIST_PAGE = "address_list";

        void getCurrentPageName(String str);
    }

    public interface GrantWebCallback {
        public static final int backWap = 0;
        public static final int remainNa = 1;

        void onGrant(int i2);
    }

    public interface InvoiceBuildCallback {
        void onCallback(String str);
    }

    public static class JoinLoginParams {
        public LinkedHashMap<String, String> agreement;
        public boolean hasThirdAccount;
    }

    public interface LoginStatusChangeCallback {
        void onChange();
    }

    public interface NormalizeGuestAccountCallback {
        public static final int MERGE_ACCOUNT = 1;

        void onFailure(int i2, String str);

        void onSuccess(boolean z, String str);
    }

    public interface PageStateCallback {
        public static final int STATE_FIRST = 1;
        public static final int STATE_OTHER = 2;

        void pageState(int i2);
    }

    public interface RealNameStatusCallback {
        public static final int STATE_JUNIOR_REALNAME = 1;
        public static final int STATE_SENIOR_REALNAME = 2;

        void onFinish(AccountRealNameResult accountRealNameResult);
    }

    public static abstract class ShareV2LoginParams {
        public JSONObject pageParams;

        public abstract void onError();

        public abstract void onSuccess();
    }

    public interface SpeechRecognitionCallback {
        void onSpeechRecognition(SpeechRecognitionResult speechRecognitionResult);
    }

    public static abstract class SpeechRecognitionResult {
        public void setSpeechData(int i2, String str) {
        }
    }

    public interface StopSlideWebviewCallback {
        void onStopSlide(boolean z);
    }

    public interface WebviewPageFinishCallback {
        void onFinish(String str);
    }
}
