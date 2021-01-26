package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.X.c;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.sapi2.utils.enums.a;
import com.baidu.sofire.ac.FH;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SapiConfiguration implements NoProguard {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_NAME_PHONE_EMAIL_LOGIN = 6;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;

    /* renamed from: a reason: collision with root package name */
    public final LoginShareStrategy f2216a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b reason: collision with root package name */
    public boolean f2217b;
    public final String bdOauthAppId;

    /* renamed from: c reason: collision with root package name */
    public boolean f2218c;
    public String chinaMobileAppID;
    public String chinaMobileAppKey;
    public String chinaTelecomAppKey;
    public String chinaTelecomAppSecret;
    public String chinaUnicomAppKey;
    public String chinaUnicomAppPublicKey;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public boolean isDarkMode;
    public boolean isNightMode;
    public final Language language;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public boolean needOpenid;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final String realnameAuthenticateStoken;
    public boolean showBottomBack;
    public boolean showCloseBtn;
    public final boolean silentShareOnUpgrade;
    public final String sinaAppId;
    public final String sinaRedirectUri;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public boolean supportFaceLogin;
    public boolean supportGestureSlide;
    public boolean supportGuestAccountLogin;
    public boolean supportMultipleAccounts;
    public final boolean supportPhoto;
    public boolean syncOneKeyLoginInfo;
    public final String tpl;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;

    public static class Builder implements NoProguard {
        public String A = "a7968de484f90a9036b5f2b40382ea43";
        public int B = 1;
        public String C;
        public String D;
        public boolean E;
        public boolean F = false;
        public boolean G = false;
        public boolean H = false;
        public boolean I = true;
        public Switch J = Switch.OFF;
        public boolean K = false;
        public SmsLoginConfig L;
        public boolean M = false;
        public boolean N = true;
        public boolean O = true;
        public boolean P = false;
        public boolean Q = true;
        public boolean R = true;
        public String S;
        public String T;
        public boolean U = false;
        public boolean V = false;
        public int W = 0;
        public int X = 0;
        public boolean Y = false;
        public boolean Z = true;

        /* renamed from: a reason: collision with root package name */
        public Context f2219a;
        public boolean aa;

        /* renamed from: b reason: collision with root package name */
        public String f2220b;
        public boolean ba = true;

        /* renamed from: c reason: collision with root package name */
        public String f2221c;
        public boolean ca = true;

        /* renamed from: d reason: collision with root package name */
        public String f2222d;
        public boolean da = true;

        /* renamed from: e reason: collision with root package name */
        public String f2223e;
        public boolean ea = true;

        /* renamed from: f reason: collision with root package name */
        public Domain f2224f;
        public boolean fa = true;

        /* renamed from: g reason: collision with root package name */
        public BindType f2225g;

        /* renamed from: h reason: collision with root package name */
        public Language f2226h;

        /* renamed from: i reason: collision with root package name */
        public LoginShareStrategy f2227i;

        /* renamed from: j reason: collision with root package name */
        public List<FastLoginFeature> f2228j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public boolean v = true;
        public String w;
        public String x;
        public String y;
        public String z = "740000";

        public Builder(Context context) {
            this.f2219a = context.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            this.o = str;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.f2220b) || TextUtils.isEmpty(this.f2221c) || TextUtils.isEmpty(this.f2222d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.f2224f == null) {
                this.f2224f = Domain.DOMAIN_ONLINE;
            }
            if (this.f2226h == null) {
                this.f2226h = Language.CHINESE;
            }
            if (this.f2225g == null) {
                this.f2225g = BindType.BIND_MOBILE;
            }
            if (this.f2227i == null) {
                this.f2227i = LoginShareStrategy.getDefault();
            }
            if (this.f2228j == null) {
                this.f2228j = new ArrayList();
            }
            if (this.L == null) {
                Switch switchR = Switch.OFF;
                this.L = new SmsLoginConfig(switchR, switchR, switchR);
            }
            if (this.J == null) {
                this.J = Switch.OFF;
            }
            if (this.G) {
                this.F = true;
            }
            Log.enable(this.K);
            return new SapiConfiguration(this);
        }

        public Builder chinaMobileOauthConfig(String str, String str2) {
            this.p = str;
            this.q = str2;
            return this;
        }

        public Builder chinaTelecomOauthConfig(String str, String str2) {
            this.r = str;
            this.s = str2;
            return this;
        }

        public Builder chinaUnicomOauthConfig(String str, String str2) {
            this.t = str;
            this.u = str2;
            return this;
        }

        public Builder configurableViewLayout(Switch switchR) {
            this.J = switchR;
            return this;
        }

        public Builder customActionBar(boolean z2) {
            this.F = z2;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.T = str;
            return this;
        }

        public Builder debug(boolean z2) {
            this.K = z2;
            return this;
        }

        public Builder enableShare(boolean z2) {
            this.Q = z2;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            ArrayList arrayList = new ArrayList();
            this.f2228j = arrayList;
            if (fastLoginFeatureArr == null) {
                return this;
            }
            Collections.addAll(arrayList, fastLoginFeatureArr);
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z2) {
            this.E = z2;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z2) {
            this.P = z2;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.f2227i = loginShareStrategy;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.m = str;
            this.x = str2;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.D = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.l = str;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.w = str;
            return this;
        }

        public Builder setActivityAnim(int i2, int i3) {
            this.W = i2;
            this.X = i3;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z2) {
            this.v = z2;
            try {
                FH.setAgreePolicy(this.f2219a, z2);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return this;
        }

        public Builder setDarkMode(boolean z2) {
            this.V = z2;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z2) {
            this.Z = z2;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.f2226h = language;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z2) {
            return this;
        }

        public Builder setNeedOpenid(boolean z2) {
            this.aa = z2;
            SapiContext.MAX_SHARE_ACCOUNTS = Integer.MAX_VALUE;
            return this;
        }

        public Builder setNightMode(boolean z2) {
            this.U = z2;
            return this;
        }

        public Builder setProcessName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            boolean z2 = false;
            Iterator it = X.m().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.matches((String) it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z2) {
                this.S = str;
            }
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f2220b = str;
            this.f2221c = str2;
            this.f2222d = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.f2224f = domain;
            return this;
        }

        public Builder setShowCloseBtn(boolean z2) {
            this.H = z2;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.f2225g = bindType;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z2) {
            this.Y = z2;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z2) {
            this.ba = z2;
            return this;
        }

        public Builder setSupportGestureSlide(boolean z2) {
            this.da = z2;
            return this;
        }

        public Builder setSupportMultipleAccounts(boolean z2) {
            this.fa = z2;
            return this;
        }

        public Builder setSupportPhoto(boolean z2) {
            this.R = z2;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z2) {
            this.ca = z2;
            return this;
        }

        public Builder showBottomBack(boolean z2) {
            this.G = z2;
            return this;
        }

        public Builder showRegLink(boolean z2) {
            this.I = z2;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z2) {
            this.N = z2;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.n = str;
            this.y = str2;
            return this;
        }

        public Builder skin(String str) {
            this.C = str;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.L = smsLoginConfig;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i2) {
            this.z = str;
            this.A = str2;
            this.B = i2;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z2) {
            this.O = z2;
            return this;
        }

        public Builder syncOneKeyLoginInfo(boolean z2) {
            this.ea = z2;
            return this;
        }

        public Builder uniteVerify(boolean z2) {
            this.M = z2;
            return this;
        }

        public Builder wxAppID(String str) {
            this.k = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }
    }

    public static class SmsLoginConfig implements NoProguard {
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch switchR, Switch switchR2, @Deprecated Switch switchR3) {
            if (switchR == null) {
                switchR = Switch.OFF;
            }
            if (switchR2 == null) {
                switchR2 = Switch.OFF;
            }
            if (switchR3 == null) {
                switchR3 = Switch.OFF;
            }
            this.flagShowLoginLink = switchR;
            this.flagShowSmsLoginLink = switchR2;
            this.flagLoginBtnType = switchR3;
            Switch switchR4 = Switch.OFF;
            this.flagShowFastRegLink = switchR4;
            this.flagHideExtraEntry = switchR4;
        }

        public SmsLoginConfig(Switch switchR, Switch switchR2, Switch switchR3, @Deprecated Switch switchR4, Switch switchR5) {
            if (switchR == null) {
                switchR = Switch.OFF;
            }
            if (switchR2 == null) {
                switchR2 = Switch.OFF;
            }
            if (switchR3 == null) {
                switchR3 = Switch.OFF;
            }
            if (switchR4 == null) {
                switchR4 = Switch.OFF;
            }
            if (switchR5 == null) {
                switchR5 = Switch.OFF;
            }
            this.flagHideExtraEntry = switchR;
            this.flagShowLoginLink = switchR2;
            this.flagShowSmsLoginLink = switchR3;
            this.flagLoginBtnType = switchR4;
            this.flagShowFastRegLink = switchR5;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSignKey() {
        return this.appSignKey;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public Domain getEnvironment() {
        return this.environment;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    public Language getLanguage() {
        return this.language;
    }

    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    public String getMzAppID() {
        return this.mzAppID;
    }

    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    public String getQqAppID() {
        return this.qqAppID;
    }

    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    public boolean getSilentShareOnUpgrade() {
        return this.silentShareOnUpgrade;
    }

    public String getSkin() {
        return this.skin;
    }

    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    public String getTpl() {
        return this.tpl;
    }

    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    public String getWxAppID() {
        return this.wxAppID;
    }

    public boolean isAgreeDangerousProtocol() {
        return this.f2217b;
    }

    public boolean isSupportTouchLogin() {
        if (this.f2218c && SapiContext.getInstance().getSapiOptions().ba.a(c.f2490a).f2502c) {
            return true;
        }
        return false;
    }

    public String loginShareDirection() {
        String str = (String) SapiContext.getInstance().getSapiOptions().Q.get(this.tpl);
        return TextUtils.isEmpty(str) ? a.f3070c : str;
    }

    public LoginShareStrategy loginShareStrategy() {
        X sapiOptions = SapiContext.getInstance().getSapiOptions();
        LoginShareStrategy loginShareStrategy = (LoginShareStrategy) sapiOptions.t().get(this.tpl);
        if (loginShareStrategy != null) {
            return loginShareStrategy;
        }
        if (sapiOptions.h() != null) {
            return sapiOptions.h();
        }
        return this.f2216a;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        this.f2217b = z;
        try {
            FH.setAgreePolicy(this.context, z);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public SapiConfiguration(Builder builder) {
        this.context = builder.f2219a;
        this.tpl = builder.f2220b;
        this.appId = builder.f2221c;
        this.appSignKey = builder.f2222d;
        this.environment = builder.f2224f;
        this.language = builder.f2226h;
        this.socialBindType = builder.f2225g;
        this.f2216a = builder.f2227i;
        this.fastLoginFeatureList = builder.f2228j;
        this.wxAppID = builder.k;
        this.qqAppID = builder.l;
        this.mzAppID = builder.m;
        this.sinaAppId = builder.n;
        this.bdOauthAppId = builder.o;
        this.meizuRedirectUri = builder.x;
        this.sinaRedirectUri = builder.y;
        this.chinaMobileAppID = builder.p;
        this.chinaMobileAppKey = builder.q;
        this.chinaTelecomAppKey = builder.r;
        this.chinaTelecomAppSecret = builder.s;
        this.f2217b = builder.v;
        this.chinaUnicomAppKey = builder.t;
        this.chinaUnicomAppPublicKey = builder.u;
        this.sofireAppKey = builder.z;
        this.sofireSecKey = builder.A;
        this.sofireHostID = builder.B;
        this.realnameAuthenticateStoken = builder.w;
        this.skin = builder.C;
        this.presetPhoneNumber = builder.D;
        this.forbidPresetPhoneNumber = builder.E;
        this.customActionBarEnabled = builder.F;
        this.showBottomBack = builder.G;
        this.configurableViewLayout = builder.J;
        this.debug = builder.K;
        this.smsLoginConfig = builder.L;
        this.uniteVerify = builder.M;
        this.silentShareOnUpgrade = builder.N;
        this.accountCenterRealAutnen = builder.O;
        this.forbidSslErrorDialog = builder.P;
        this.enableShare = builder.Q;
        this.supportPhoto = builder.R;
        this.processName = builder.S;
        this.isNightMode = builder.U;
        this.isDarkMode = builder.V;
        this.showCloseBtn = builder.H;
        this.userAgent = builder.T;
        this.activityOpenAnimId = builder.W;
        this.activityExitAnimId = builder.X;
        this.disableVoiceVerify = builder.Z;
        this.needOpenid = builder.aa;
        this.supportFaceLogin = builder.ba;
        this.f2218c = builder.ca;
        this.supportGestureSlide = builder.da;
        this.syncOneKeyLoginInfo = builder.ea;
        this.supportMultipleAccounts = builder.fa;
    }
}
