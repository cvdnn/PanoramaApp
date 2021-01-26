package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AddressManageActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.InvoiceBuildActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.ModifyPwdActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.OperationRecordActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.activity.SwitchAccountActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AddressManageCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.InvoiceBuildCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.InvoiceBuildDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareStorage.StorageModel;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.q;
import com.baidu.sapi2.utils.t;
import com.baidu.sapi2.views.SmsLoginView;
import e.a.a.a.a;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class PassportSDK {

    /* renamed from: a reason: collision with root package name */
    public static PassportSDK f2164a;

    /* renamed from: b reason: collision with root package name */
    public static LoginStatusChangeCallback f2165b;
    public AddressManageCallback A;
    public InvoiceBuildCallback B;
    public OneKeyLoginCallback C;
    public String D;
    public Context E = SapiAccountManager.getInstance().getSapiConfiguration().context;

    /* renamed from: c reason: collision with root package name */
    public AbstractThirdPartyService f2166c;

    /* renamed from: d reason: collision with root package name */
    public WebAuthListener f2167d;

    /* renamed from: e reason: collision with root package name */
    public WebLoginDTO f2168e;

    /* renamed from: f reason: collision with root package name */
    public WebRegDTO f2169f;

    /* renamed from: g reason: collision with root package name */
    public WebBindWidgetDTO f2170g;

    /* renamed from: h reason: collision with root package name */
    public WebSocialLoginDTO f2171h;

    /* renamed from: i reason: collision with root package name */
    public AccountCenterDTO f2172i;

    /* renamed from: j reason: collision with root package name */
    public NormalizeGuestAccountDTO f2173j;
    public AddressManageDTO k;
    public RealNameDTO l;
    public InvoiceBuildDTO m;
    public SwitchAccountDTO n;
    public AccountCenterCallback o;
    public AccountRealNameCallback p;
    public WebBindWidgetCallback q;
    public WebModifyPwdCallback r;
    public SapiWebCallback s;
    public ImageCropCallback t;
    public ActivityResultCallback u;
    public QrLoginCallback v;
    public SmsViewLoginCallback w;
    public NormalizeGuestAccountCallback x;
    public AuthWidgetCallback y;
    public ExtendSysWebViewMethodCallback z;

    public static synchronized PassportSDK getInstance() {
        PassportSDK passportSDK;
        synchronized (PassportSDK.class) {
            if (f2164a == null) {
                f2164a = new PassportSDK();
            }
            passportSDK = f2164a;
        }
        return passportSDK;
    }

    public static LoginStatusChangeCallback getLoginStatusChangeCallback() {
        return f2165b;
    }

    public static void setLoginStatusChangeCallback(LoginStatusChangeCallback loginStatusChangeCallback) {
        f2165b = loginStatusChangeCallback;
    }

    public void extendSysWebViewMethod(Context context, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        String str2 = "retMsg";
        String str3 = "retCode";
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String optString = optJSONObject.optString("open_appid");
            String optString2 = optJSONObject.optString("open_apikey");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                extendSysWebViewMethodResult.params.put(str3, "-310");
                extendSysWebViewMethodResult.params.put(str2, "因安全原因，操作失败");
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                return;
            }
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            C0175n nVar = new C0175n(this, optInt, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult, context);
            accountService.extendSysWebViewMethodCheck(nVar, optString, optString2);
        } catch (JSONException e2) {
            Log.e(e2);
            extendSysWebViewMethodResult.params.put(str3, "-3");
            extendSysWebViewMethodResult.params.put(str2, "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.o;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.f2172i;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.p;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.u;
    }

    public AddressManageCallback getAddressManageCallback() {
        return this.A;
    }

    public AddressManageDTO getAddressManageDTO() {
        return this.k;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.y;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.z;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.t;
    }

    public InvoiceBuildCallback getInvoiceBuildCallback() {
        return this.B;
    }

    public InvoiceBuildDTO getInvoiceBuildDTO() {
        return this.m;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.x;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.f2173j;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        return this.C;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.v;
    }

    public RealNameDTO getRealNameDTO() {
        return this.l;
    }

    public SapiWebCallback getSapiWebCallback() {
        return this.s;
    }

    public String getSmsLoginStatExtra() {
        return WebLoginDTO.getStatExtraDecode(this.D);
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.w;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.f2171h;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.n;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.f2166c == null) {
            a();
        }
        return this.f2166c;
    }

    public WebAuthListener getWebAuthListener() {
        return this.f2167d;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.q;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.f2170g;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.f2168e;
    }

    public WebModifyPwdCallback getWebModifyPwdCallback() {
        return this.r;
    }

    public WebRegDTO getWebRegDTO() {
        return this.f2169f;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f2166c = thirdPartyService;
        if (thirdPartyService != null) {
            thirdPartyService.handleWXLoginResp(activity, str, str2, i2);
        }
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, StorageModel storageModel) {
        invokeV2ShareLogin(activity, webAuthListener, storageModel, "");
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                accountCenterDTO.bduss = currentAccount.bduss;
            }
        }
        this.o = accountCenterCallback;
        this.f2172i = accountCenterDTO;
        Intent intent = new Intent(this.E, AccountCenterActivity.class);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void loadAccountRealName(AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        loadAccountRealName(this.E, accountRealNameCallback, realNameDTO);
    }

    public void loadAddressManage(Context context, AddressManageDTO addressManageDTO, AddressManageCallback addressManageCallback) {
        this.k = addressManageDTO;
        this.A = addressManageCallback;
        if (context == null) {
            context = this.E;
        }
        Intent intent = new Intent(context, AddressManageActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        this.q = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                webBindWidgetDTO.bduss = currentAccount.bduss;
            }
        }
        this.f2170g = webBindWidgetDTO;
        Intent intent = new Intent(this.E, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void loadInvoiceBuild(Context context, InvoiceBuildDTO invoiceBuildDTO, InvoiceBuildCallback invoiceBuildCallback) {
        this.m = invoiceBuildDTO;
        this.B = invoiceBuildCallback;
        if (context == null) {
            context = this.E;
        }
        Intent intent = new Intent(context, InvoiceBuildActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadModifyPwd(WebModifyPwdCallback webModifyPwdCallback, String str) {
        this.r = webModifyPwdCallback;
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                str = currentAccount.bduss;
            }
        }
        Intent intent = new Intent(this.E, ModifyPwdActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
    }

    public void loadOperationRecord(SapiWebCallback sapiWebCallback, String str) {
        this.s = sapiWebCallback;
        Intent intent = new Intent(this.E, OperationRecordActivity.class);
        intent.putExtra("EXTRA_BDUSS", str);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, null, true);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.n = switchAccountDTO;
        this.f2167d = webAuthListener;
        Intent intent = new Intent(this.E, SwitchAccountActivity.class);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        t.a(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        this.f2171h = webSocialLoginDTO;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        onActivityResult(i2, i3, intent, "");
    }

    public void registerUserFaceID(RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new C0171j(this, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            return;
        }
        RegisterUserFaceIDCallback registerUserFaceIDCallback2 = registerUserFaceIDCallback;
        b(registerUserFaceIDCallback2, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence);
    }

    public void release() {
        SapiWebView.statLoadLogin = null;
        this.f2167d = null;
        this.f2168e = null;
        this.f2170g = null;
        this.f2171h = null;
        this.f2173j = null;
        this.o = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.f2172i = null;
        this.p = null;
        this.v = null;
        this.w = null;
        this.D = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.k = null;
        this.A = null;
        this.C = null;
        this.n = null;
        PassportViewManager.getInstance().release();
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.u = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.t = imageCropCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.f2166c = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.y = authWidgetCallback;
        Intent intent = new Intent(this.E, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.E, webAuthListener, webLoginDTO);
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.x = normalizeGuestAccountCallback;
        this.f2173j = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.f2167d = webAuthListener;
        this.f2169f = webRegDTO;
        Intent intent = new Intent(this.E, RegisterActivity.class);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.w = smsViewLoginCallback;
        this.D = str;
        SmsLoginView.notifyStartLogin();
    }

    public void verifyUserFaceId(VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        verifyUserFaceId(this.E, verifyUserFaceIDCallback, faceIDVerifyDTO);
    }

    /* access modifiers changed from: private */
    public void b(FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5) {
        a(faceIDCallback, str, str2, str3, z2, str4, str5);
    }

    public void invokeV2ShareLogin(Activity activity, WebAuthListener webAuthListener, StorageModel storageModel, String str) {
        if (storageModel == null || webAuthListener == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(StorageModel.class.getSimpleName());
            sb.append("or");
            sb.append(WebAuthListener.class.getSimpleName());
            sb.append("can't be null");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f2167d = webAuthListener;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            a.a("extrajson", str, arrayList);
        }
        new m().a(activity, storageModel.pkg, storageModel.url, null, null, arrayList);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.p = accountRealNameCallback;
        this.l = realNameDTO;
        Intent intent = new Intent(context, AccountRealNameActivity.class);
        if (realNameDTO != null) {
            intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
            intent.putExtra(AccountRealNameActivity.EXTRA_SCENE, realNameDTO.scene);
            intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, String str, boolean z2, OneKeyLoginCallback oneKeyLoginCallback) {
        String str2 = Log.TAG;
        if (oneKeyLoginCallback == null) {
            Log.e(str2, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(str2, "oneKeyLogin sign is empty!");
            new c().a(oneKeyLoginCallback, (int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL, (String) null);
        } else {
            this.C = oneKeyLoginCallback;
            c cVar = new c();
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            C0167f fVar = new C0167f(this, oneKeyLoginCallback, str, z2, context);
            cVar.a(sapiConfiguration, (c.a) fVar);
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void onActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            a.a("extrajson", str, arrayList);
        }
        new m().a(new C0168g(this), i2, i3, intent, arrayList);
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        q qVar = new q();
        SapiWebView.statLoadLogin = qVar;
        qVar.f3119g = System.currentTimeMillis();
        this.f2167d = webAuthListener;
        this.f2168e = webLoginDTO;
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, webLoginDTO.loginType);
        intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, webLoginDTO.finishActivityAfterSuc);
        if (!TextUtils.isEmpty(webLoginDTO.preSetUname)) {
            intent.putExtra("username", webLoginDTO.preSetUname);
        }
        int i2 = webLoginDTO.businessType;
        if (i2 != 0) {
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    public void verifyUserFaceId(Context context, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        FaceIDVerifyDTO faceIDVerifyDTO2 = faceIDVerifyDTO;
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                faceIDVerifyDTO2.bduss = currentAccount.bduss;
                faceIDVerifyDTO2.uid = currentAccount.uid;
            }
        }
        if (TextUtils.isEmpty(faceIDVerifyDTO2.livingUname)) {
            RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            C0172k kVar = new C0172k(this, context, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult);
            accountService.getTplStoken(kVar, faceIDVerifyDTO2.bduss, arrayList);
            return;
        }
        VerifyUserFaceIDCallback verifyUserFaceIDCallback2 = verifyUserFaceIDCallback;
        b(verifyUserFaceIDCallback2, "outer", "", faceIDVerifyDTO2.livingUname, faceIDVerifyDTO2.showGuidePage, faceIDVerifyDTO2.subpro, faceIDVerifyDTO2.businessSence);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z2) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.v = new C0169h(this, qrLoginCallback, arrayList);
        if (SapiAccountManager.getInstance().isLogin()) {
            a(str, z2);
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(URLDecoder.decode(str2));
            }
            jSONObject.put("scenario", "1");
            webLoginDTO.statExtra = URLEncoder.encode(jSONObject.toString());
        } catch (JSONException unused) {
        }
        startLogin(new C0170i(this, arrayList, str, z2), webLoginDTO);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        this.f2167d = webAuthListener;
        this.f2171h = webSocialLoginDTO;
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f2166c = thirdPartyService;
        if (thirdPartyService != null) {
            Context context = webSocialLoginDTO.context;
            if (context == null) {
                context = this.E;
            }
            thirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO.socialType, 2002);
            webSocialLoginDTO.context = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        Intent intent = new Intent(this.E, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z2);
        intent.setFlags(268435456);
        this.E.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
        String str6 = str;
        BiometricsManager.getInstance().recogWithBduss(context, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, new C0173l(this, realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5) {
        if (!TextUtils.isEmpty(str5)) {
            BiometricsManager instance = BiometricsManager.getInstance();
            String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
            HashMap hashMap = new HashMap();
            C0174m mVar = new C0174m(this, new UnRealNameFaceIDResult(), str, faceIDCallback);
            String str6 = "0";
            if (str.equals("faceDetect")) {
                instance.recogWithFaceDetect(this.E, buildSubPro, hashMap, str6, str3, str2, mVar);
            } else if (str.equals("outer")) {
                instance.recogWithFaceOuter(this.E, buildSubPro, hashMap, str6, str3, mVar);
            }
        } else {
            throw new IllegalArgumentException("scene can't be empty");
        }
    }

    /* access modifiers changed from: private */
    public void a(ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i2, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        String str;
        C0176o oVar;
        String str2;
        BiometricsManager biometricsManager;
        C0176o oVar2;
        HashMap hashMap;
        int i3;
        int i4;
        String str3;
        String str4;
        int i5;
        JSONObject jSONObject2 = jSONObject;
        int i6 = i2;
        BiometricsManager instance = BiometricsManager.getInstance();
        C0176o oVar3 = new C0176o(this, extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
        int optInt = jSONObject2.optInt("imageFlag", 0);
        String str5 = "subpro";
        if (TextUtils.isEmpty(jSONObject2.optString(str5))) {
            str = "pp";
        } else {
            str = jSONObject2.optString(str5);
        }
        String str6 = str;
        HashMap hashMap2 = new HashMap();
        JSONObject optJSONObject = jSONObject2.optJSONObject("transParams");
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str7 = (String) keys.next();
                String optString = optJSONObject.optString(str7);
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(optString)) {
                    hashMap2.put(str7, optString);
                }
            }
        }
        String str8 = "";
        if (i6 == 1) {
            instance.getClass();
            BiometricsManager.a aVar = new BiometricsManager.a();
            StringBuilder sb = new StringBuilder();
            sb.append(optInt);
            sb.append(str8);
            oVar = oVar3;
            str2 = str8;
            a(extendSysWebViewMethodCallback, aVar, extendSysWebViewMethodResult, (PassFaceRecogCallback) oVar3, str6, (Map<String, String>) hashMap2, sb.toString());
        } else {
            oVar = oVar3;
            str2 = str8;
        }
        if (i6 == 2) {
            Context context = this.E;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(optInt);
            sb2.append(str2);
            String sb3 = sb2.toString();
            i3 = 1;
            BiometricsManager biometricsManager2 = instance;
            hashMap = hashMap2;
            Context context2 = context;
            i4 = optInt;
            String str9 = str6;
            str3 = str2;
            oVar2 = oVar;
            HashMap hashMap3 = hashMap;
            biometricsManager = instance;
            String str10 = sb3;
            biometricsManager2.recogWithCertInfo(context2, str9, hashMap3, str10, jSONObject2.optString("realname"), jSONObject2.optString("idcardnum"), jSONObject2.optString("bankmobile"), oVar2);
        } else {
            i3 = 1;
            hashMap = hashMap2;
            i4 = optInt;
            str3 = str2;
            biometricsManager = instance;
            oVar2 = oVar;
        }
        if (i6 == 3) {
            Context context3 = this.E;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i4);
            sb4.append(str3);
            String sb5 = sb4.toString();
            str4 = str3;
            String optString2 = jSONObject2.optString("authtoken");
            i5 = i4;
            biometricsManager.recogWithAuthToken(context3, str6, hashMap, sb5, optString2, oVar2);
        } else {
            str4 = str3;
            i5 = i4;
        }
        if (i6 == 4) {
            String str11 = "uid";
            if (jSONObject2.optInt("type") == i3) {
                Context context4 = this.E;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(i5);
                sb6.append(str4);
                biometricsManager.recogWithFaceDetect(context4, str6, hashMap, sb6.toString(), jSONObject2.optString(str11), "", oVar2);
                return;
            }
            Context context5 = this.E;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(i5);
            sb7.append(str4);
            biometricsManager.recogWithFaceOuter(context5, str6, hashMap, sb7.toString(), jSONObject2.optString(str11), oVar2);
        }
    }

    private void a(ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.a aVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        BiometricsManager.a aVar2 = aVar;
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult2 = extendSysWebViewMethodResult;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            extendSysWebViewMethodResult2.params.put("retCode", "-302");
            extendSysWebViewMethodResult2.params.put("retMsg", "please login first");
            ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback2 = extendSysWebViewMethodCallback;
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult2);
            return;
        }
        ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback3 = extendSysWebViewMethodCallback;
        aVar2.o = currentAccount.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
        C0165d dVar = new C0165d(this, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback3);
        accountService.getTplStoken(dVar, aVar2.o, arrayList);
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }
}
