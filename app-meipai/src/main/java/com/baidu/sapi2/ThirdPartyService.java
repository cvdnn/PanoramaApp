package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity;
import com.baidu.sapi2.activity.social.MeizuSSOLoginActivity;
import com.baidu.sapi2.activity.social.QQSSOLoginActivity;
import com.baidu.sapi2.activity.social.SinaSSOLoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidubce.BceConfig;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public class ThirdPartyService implements AbstractThirdPartyService {
    public static final long MIN_INVOKE_INTER_TIME = 500;
    public long lastInvokeTime = 0;

    public ThirdPartyService() {
        PassportSDK.getInstance().setThirdPartyService(this);
    }

    public List<HttpCookie> getCookies(Context context, SapiConfiguration sapiConfiguration) {
        ArrayList arrayList = new ArrayList();
        String deviceInfo = SapiContext.getInstance().getDeviceInfo();
        HttpCookie httpCookie = new HttpCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context));
        String str = "";
        if (deviceInfo == null) {
            deviceInfo = str;
        }
        HttpCookie httpCookie2 = new HttpCookie("DVIF", deviceInfo);
        String str2 = "http://";
        String str3 = "https://";
        String str4 = "(:[0-9]{1,4})?";
        String replaceAll = sapiConfiguration.environment.getURL().replace(str2, str).replace(str3, str).replaceAll(str4, str);
        String replaceAll2 = sapiConfiguration.environment.getWap().replace(str2, str).replace(str3, str).replaceAll(str4, str);
        httpCookie.setDomain(replaceAll);
        String str5 = BceConfig.BOS_DELIMITER;
        httpCookie.setPath(str5);
        httpCookie2.setDomain(replaceAll2);
        httpCookie2.setPath(str5);
        arrayList.add(httpCookie);
        arrayList.add(httpCookie2);
        return arrayList;
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        Intent intent = new Intent(activity, WXLoginActivity.class);
        intent.putExtra(WXLoginActivity.KEY_FROM_WX_AUTH, true);
        intent.putExtra(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, i2);
        intent.putExtra(WXLoginActivity.KEY_BASE_RESP_STATE, str);
        intent.putExtra("code", str2);
        activity.startActivity(intent);
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2) {
        loadThirdPartyLogin(context, socialType, i2, null);
    }

    public SapiAccount sapiAccountResponseToAccount(Context context, SapiAccountResponse sapiAccountResponse) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", sapiConfiguration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    public void socialBind(Activity activity, SocialType socialType, int i2, String str) {
        if (socialType == SocialType.WEIXIN) {
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            activity.startActivity(intent);
        }
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str) {
        Intent intent;
        if (System.currentTimeMillis() - this.lastInvokeTime >= 500) {
            this.lastInvokeTime = System.currentTimeMillis();
            SapiStatUtil.statThirdLoginEnter(socialType);
            boolean z = context instanceof Activity;
            if (socialType == SocialType.SINA_WEIBO_SSO) {
                intent = new Intent(context, SinaSSOLoginActivity.class);
            } else if (socialType == SocialType.HUAWEI) {
                intent = new Intent(context, HuaweiSSOLoginActivity.class);
            } else if (socialType == SocialType.WEIXIN) {
                intent = new Intent(context, WXLoginActivity.class);
            } else if (socialType == SocialType.QQ_SSO) {
                intent = new Intent(context, QQSSOLoginActivity.class);
            } else if (socialType == SocialType.MEIZU) {
                intent = new Intent(context, MeizuSSOLoginActivity.class);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(socialType.getName());
                sb.append(" type login not support");
                throw new IllegalArgumentException(sb.toString());
            }
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("extraJson", str);
            }
            if (!z) {
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            }
            ((Activity) context).startActivityForResult(intent, 2001);
        }
    }
}
