package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum FastLoginFeature {
    TX_WEIXIN_SSO("tweixin_sso"),
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO("qq_sso"),
    QR_LOGIN("qr_app_login"),
    HUAWEI_LOGIN("huawei_login"),
    MEIZU_SSO("meizu_sso");
    

    /* renamed from: b reason: collision with root package name */
    public String f3056b;

    /* access modifiers changed from: public */
    FastLoginFeature(String str) {
        this.f3056b = str;
    }

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    public static FastLoginFeature mapStrToValue(String str) {
        FastLoginFeature[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (FastLoginFeature fastLoginFeature : values()) {
            if (str.equals(fastLoginFeature.getStrValue())) {
                return fastLoginFeature;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.f3056b;
    }
}
