package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    

    /* renamed from: b reason: collision with root package name */
    public String f3061b;

    /* access modifiers changed from: public */
    LoginShareStrategy(String str) {
        this.f3061b = str;
    }

    public static LoginShareStrategy getDefault() {
        return SILENT;
    }

    public static LoginShareStrategy mapStrToValue(String str) {
        LoginShareStrategy[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (LoginShareStrategy loginShareStrategy : values()) {
            if (str.equals(loginShareStrategy.getStrValue())) {
                return loginShareStrategy;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.f3061b;
    }
}
