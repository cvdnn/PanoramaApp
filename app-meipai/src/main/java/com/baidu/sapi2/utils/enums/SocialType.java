package com.baidu.sapi2.utils.enums;

public enum SocialType {
    UNKNOWN(0, "未知"),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    QQ_SSO(15, r4),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族");
    

    /* renamed from: b reason: collision with root package name */
    public int f3065b;

    /* renamed from: c reason: collision with root package name */
    public String f3066c;

    /* access modifiers changed from: public */
    SocialType(int i2, String str) {
        this.f3065b = i2;
        this.f3066c = str;
    }

    public static SocialType getSocialType(int i2) {
        if (i2 == 2) {
            return SINA_WEIBO_SSO;
        }
        if (i2 == 15) {
            return QQ_SSO;
        }
        if (i2 == 42) {
            return WEIXIN;
        }
        if (i2 == 45) {
            return HUAWEI;
        }
        if (i2 == 47) {
            return IQIYI;
        }
        if (i2 == 49) {
            return XIAOMI;
        }
        if (i2 != 50) {
            return UNKNOWN;
        }
        return MEIZU;
    }

    public String getName() {
        return this.f3066c;
    }

    public int getType() {
        return this.f3065b;
    }
}
