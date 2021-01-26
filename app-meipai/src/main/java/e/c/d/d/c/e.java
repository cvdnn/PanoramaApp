package e.c.d.d.c;

import com.baidu.picapture.App;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration.Builder;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import e.c.b.e.Utils;

/* compiled from: PassportManager */
public class e {

    /* renamed from: d reason: collision with root package name */
    public static final e f6006d = new e();

    /* renamed from: a reason: collision with root package name */
    public PassportSDK f6007a;

    /* renamed from: b reason: collision with root package name */
    public WebLoginDTO f6008b = new WebLoginDTO();

    /* renamed from: c reason: collision with root package name */
    public String f6009c;

    /* compiled from: PassportManager */
    public interface a {
    }

    public SapiAccount a() {
        return SapiAccountManager.getInstance().getSession();
    }

    public void b() {
        this.f6008b.extraParams.add(SapiWebView.EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER);
        Language language = Language.CHINESE;
        if (!LanguageUtils.isChineseLanguage()) {
            language = Language.ENGLISH;
        }
        SapiAccountManager.getInstance().init(new Builder(App.f1954b).setProductLineInfo("baidu_vr", "1", "7d231a54c9e5f1de2d3324c93ff12673").sofireSdkConfig("292615", "42792fb99669c9f8732529e3e0547fb5", 292615).setRuntimeEnvironment(Domain.DOMAIN_ONLINE.forceHttps(true)).fastLoginSupport(FastLoginFeature.TX_WEIXIN_SSO).wxAppID("wxf4d91e07aec514ad").debug(false).setSupportTouchLogin(true).setLanguage(language).build());
        this.f6007a = PassportSDK.getInstance();
        if (c()) {
            this.f6009c = Utils.i(f6006d.a().uid);
        }
    }

    public boolean c() {
        return SapiAccountManager.getInstance().isLogin();
    }
}
