package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetContactsCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.a.b;
import com.baidu.sapi2.dto.GetContactDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SendSmsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.outsdk.c;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.interfaces.a;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.i;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class SapiAccountService implements a {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";

    /* renamed from: a reason: collision with root package name */
    public static final String f2212a = "SapiAccountService";

    /* renamed from: b reason: collision with root package name */
    public static final String f2213b = "native";

    /* renamed from: c reason: collision with root package name */
    public SapiConfiguration f2214c = SapiAccountManager.getInstance().getSapiConfiguration();

    /* renamed from: d reason: collision with root package name */
    public L f2215d = new L();

    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2215d.a(bindWidgetAction));
            sb.append("?");
            sb.append(g());
            sb.append("&");
            sb.append(SapiUtils.createRequestParams(arrayList));
            return sb.toString();
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("client", SapiDeviceInfo.f3010c));
        arrayList.add(new PassNameValuePair("clientfrom", f2213b));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.q());
        sb.append("?");
        sb.append(a(false));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(arrayList));
        return sb.toString();
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.k());
        sb.append("?");
        sb.append(a(true));
        return sb.toString();
    }

    public void cancelRequest() {
        this.f2215d.b();
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.f2215d.a(sapiCallback, str);
    }

    public void checkOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        if (oneKeyLoginCallback == null) {
            Log.d(f2212a, "OneKeyLoginCallback is null, because this is an init process");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(f2212a, "encryptPhoneNum is null or empty, unkown error occured");
            new c().b(oneKeyLoginCallback, -100, null);
        } else {
            this.f2215d.a(oneKeyLoginCallback, str);
        }
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.f2215d.a(sapiCallback, str, null);
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.r());
        sb.append("?");
        sb.append(g());
        return sb.toString();
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.f2215d.a(sapiCallBack, str, str2, true);
    }

    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.s());
        sb.append("?");
        sb.append(a(false));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(arrayList));
        return sb.toString();
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.f2215d.a(sapiCallback, str, str2);
    }

    public String f() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        StringBuilder sb = new StringBuilder();
        sb.append(sapiConfiguration.environment.getWap());
        sb.append("/wp/");
        String sb2 = sb.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        StringBuilder b2 = e.a.a.a.a.b(sb2, "?");
        b2.append(g());
        b2.append("&");
        b2.append(SapiUtils.createRequestParams(arrayList));
        return b2.toString();
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.f2215d.a(sapiCallback, str, z, str2);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.f2215d.a(fillUsernameCallback, str, str2);
    }

    public String g() {
        return a(true);
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.f2215d.a(ssoHashCallback, str, str2);
    }

    public int getBdussState() {
        return new OpenBdussService(this.f2214c, SapiAccountManager.VERSION_NAME).getBdussState();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getCaptcha(sapiCallback);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getCaptchaKey();
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactDTO getContactDTO) {
        GetContactsService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getContacts(getContactsCallback, getContactDTO);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.f2215d.a(sapiCallBack, str);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.f2214c, SapiAccountManager.VERSION_NAME).getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public String getIqiyiAccessToken() {
        return SapiContext.getInstance().getIqiyiAccesstoken();
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.f2214c, SapiAccountManager.VERSION_NAME).getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.f2214c, SapiAccountManager.VERSION_NAME).getPopularPortraitsInfo(getPopularPortraitsCallback, str);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.f2215d.a(getUserInfoCallback, str);
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.o());
        sb.append("?");
        sb.append(g());
        return sb.toString();
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        SapiAccountResponse b2 = g.b("business_from_one_key_login", str);
        if (b2 != null) {
            SapiShareClient.getInstance().validate(a(b2));
            a(oneKeyLoginCallback, b2.accountType);
            return;
        }
        new c().a(oneKeyLoginCallback, -103, (String) null);
    }

    public String i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.p());
        sb.append("?");
        sb.append(g());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(arrayList));
        return sb.toString();
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.f2215d.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.f2215d.a(str, list);
    }

    public String j() {
        return this.f2215d.g();
    }

    public String k() {
        return this.f2215d.h();
    }

    public String l() {
        return this.f2215d.i();
    }

    public String m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.t());
        sb.append("?");
        sb.append(a(false));
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(arrayList));
        return sb.toString();
    }

    public String n() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.u());
        sb.append("?");
        sb.append(g());
        return sb.toString();
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.f2215d.b(sapiCallback, str, null);
    }

    public void preGetPhoneInfo() {
        new c().a(this.f2214c, c.n);
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).qrAppLogin(sapiCallback, str, str2);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void refreshOpenidToUid() {
        if (this.f2214c.needOpenid) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            loginAccounts.addAll(SapiAccountManager.getInstance().getShareAccounts());
            int size = loginAccounts.size();
            String str = SapiContext.KEY_OPENID_UID_LIST;
            if (size == 0) {
                SapiContext.getInstance().put(str, "");
                return;
            }
            Map urlParamsToMap = SapiUtils.urlParamsToMap(SapiContext.getInstance().getString(str));
            Collection values = urlParamsToMap.values();
            for (SapiAccount sapiAccount : loginAccounts) {
                if (!values.contains(sapiAccount.uid)) {
                    values.remove(sapiAccount.uid);
                }
            }
            SapiContext.getInstance().put(str, SapiUtils.mapToUrlParams(urlParamsToMap, false));
            for (SapiAccount sapiAccount2 : loginAccounts) {
                if (!urlParamsToMap.containsValue(sapiAccount2.uid)) {
                    oauth(new N(this, urlParamsToMap, sapiAccount2), sapiAccount2.bduss);
                }
            }
        }
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).relaseContactsSource();
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).sendSMS(sendSmsDTO);
    }

    public void setIqiyiAccessToken(String str) {
        SapiContext.getInstance().setIqiyiAccesstoken(str);
        if (SapiShareClient.isInShareOtherInfoWhiteList()) {
            this.f2215d.c(str);
            SapiShareClient.getInstance().validateOtherInfo();
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.f2214c, SapiAccountManager.VERSION_NAME).setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    @Deprecated
    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        SetPortraitDTO setPortraitDTO = new SetPortraitDTO();
        setPortraitDTO.bduss = str;
        setPortraitDTO.file = bArr;
        setPortraitDTO.contentType = str2;
        setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).stopLoginStatusCheck();
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.f2215d.a(web2NativeLoginCallback, false);
    }

    public boolean webLogin(Context context) {
        if (context == null) {
            return false;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
        }
        return false;
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.f2215d.a(sapiCallback, str, map);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(sapiCallback, str, str2, null);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getDynamicPwd(sapiCallback, str);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.f2215d.b(sapiCallback, str, str2);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.f2215d.a(web2NativeLoginCallback, z);
    }

    public boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new M(this, context), str, arrayList);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null) {
            return a(context, accountFromBduss.bduss, accountFromBduss.ptoken);
        }
        return a(context, str, (String) null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        getDynamicPwd(getDynamicPwdCallback, str, str2, null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f2214c, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        new PortraitService(this.f2214c, SapiAccountManager.VERSION_NAME).setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.m());
        sb.append("?");
        sb.append(g());
        sb.append("&");
        sb.append(SapiUtils.createRequestParams(arrayList));
        return sb.toString();
    }

    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2215d.f());
        sb.append("?");
        sb.append(g());
        return sb.toString();
    }

    public String a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        String str3 = "1";
        String str4 = "realName";
        if (this.f2214c.accountCenterRealAutnen) {
            e.a.a.a.a.a(str4, str3, arrayList);
        } else {
            e.a.a.a.a.a(str4, "0", arrayList);
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            str2 = this.f2215d.e();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            e.a.a.a.a.a("hidebtmback", str3, arrayList);
            str2 = this.f2215d.d();
        } else {
            str2 = this.f2215d.c();
        }
        StringBuilder b2 = e.a.a.a.a.b(str2, "?");
        b2.append(a(false));
        b2.append("&");
        b2.append(SapiUtils.createRequestParams(arrayList));
        return b2.toString();
    }

    public String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", f2213b));
        arrayList.add(new PassNameValuePair("tpl", this.f2214c.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.f2214c.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair("client", SapiDeviceInfo.f3010c));
        if (z) {
            arrayList.add(new PassNameValuePair("adapter", this.f2214c.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair(SocialConstants.PARAM_ACT, this.f2214c.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.f2214c.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.f2214c.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.f2214c.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.f2214c.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.f2214c.configurableViewLayout.ordinal())));
        String str = "1";
        if (this.f2214c.uniteVerify) {
            e.a.a.a.a.a("connect", str, arrayList);
        }
        if (this.f2214c.language == Language.ENGLISH) {
            e.a.a.a.a.a("lang", LanguageUtils.EN_REGION, arrayList);
        }
        e.a.a.a.a.a("suppcheck", str, arrayList);
        if (this.f2214c.supportFaceLogin) {
            e.a.a.a.a.a("scanface", str, arrayList);
        }
        if (this.f2214c.disableVoiceVerify) {
            e.a.a.a.a.a("disable_voice_vcode", str, arrayList);
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    public String a(SocialType socialType, String str, String str2) {
        return a(socialType, str, str2, (String) null);
    }

    public String a(SocialType socialType, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("display", f2213b));
        StringBuilder sb = new StringBuilder();
        sb.append(socialType.getType());
        sb.append("");
        arrayList.add(new PassNameValuePair("type", sb.toString()));
        arrayList.add(new PassNameValuePair(SocialConstants.PARAM_ACT, this.f2214c.socialBindType.getName()));
        if (!TextUtils.isEmpty(str3)) {
            e.a.a.a.a.a("appid", str3, arrayList);
        }
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2215d.j());
        sb2.append("?");
        sb2.append(g());
        sb2.append("&");
        sb2.append(SapiUtils.createRequestParams(arrayList));
        return sb2.toString();
    }

    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(SocialType.QQ_SSO.getType());
        sb.append("");
        arrayList.add(new PassNameValuePair("type", sb.toString()));
        arrayList.add(new PassNameValuePair("appid", this.f2214c.qqAppID));
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        arrayList.add(new PassNameValuePair(SocialOperation.GAME_UNION_ID, str3));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2215d.j());
        sb2.append("?");
        sb2.append(g());
        sb2.append("&");
        sb2.append(SapiUtils.createRequestParams(arrayList));
        return sb2.toString();
    }

    public String a(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList(4);
        StringBuilder sb = new StringBuilder();
        sb.append(SocialType.WEIXIN.getType());
        sb.append("");
        arrayList.add(new PassNameValuePair("type", sb.toString()));
        arrayList.add(new PassNameValuePair("mkey", str2));
        arrayList.add(new PassNameValuePair("code", str));
        if (SapiAccountManager.getInstance().getConfignation().supportGuestAccountLogin) {
            e.a.a.a.a.a("supportGuestAccount", "1", arrayList);
        }
        if (z) {
            arrayList.add(new PassNameValuePair("wapsec", "center"));
            arrayList.add(new PassNameValuePair("adapter", "3"));
        }
        arrayList.add(new PassNameValuePair("appid", this.f2214c.wxAppID));
        arrayList.add(new PassNameValuePair("display", f2213b));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2215d.j());
        sb2.append("?");
        sb2.append(g());
        sb2.append("&");
        sb2.append(SapiUtils.createRequestParams(arrayList));
        return sb2.toString();
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.f2215d.a(sapiCallBack, str, str2, false);
    }

    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.f2215d.a(sapiAccount, list);
    }

    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.f2215d.a(getTplStokenCallback, str, list, z);
    }

    private boolean a(Context context, String str, String str2) {
        String str3 = "https://";
        String str4 = SapiUtils.COOKIE_URL_PREFIX;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str5 : SapiUtils.getAuthorizedDomains()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(str5);
                    if (!str.equals(SapiUtils.getCookie(sb.toString(), "BDUSS"))) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append(str5);
                        arrayList.add(new PassNameValuePair(sb2.toString(), SapiUtils.buildBDUSSCookie(str5, str)));
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    for (String str6 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str3);
                        sb3.append(str6);
                        if (!str2.equals(SapiUtils.getCookie(sb3.toString(), "PTOKEN"))) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str3);
                            sb4.append(str6);
                            arrayList.add(new PassNameValuePair(sb4.toString(), SapiUtils.buildPtokenCookie(str6, str2)));
                        }
                    }
                }
                SapiUtils.syncCookies(context, arrayList);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        String str2 = "https://";
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (String str3 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(str3);
                        if (!str.equals(SapiUtils.getCookie(sb.toString(), "STOKEN"))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append(str3);
                            arrayList.add(new PassNameValuePair(sb2.toString(), SapiUtils.buildStokenCookie(str3, str)));
                        }
                    }
                }
                SapiUtils.syncCookies(context, arrayList);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, b bVar) {
        this.f2215d.a(oneKeyLoginCallback, str, str2, bVar);
    }

    private SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(this.f2214c.context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.f2214c.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.f2214c.context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    private void a(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        SapiUtils.reportGid(i.f3087b);
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
    }
}
