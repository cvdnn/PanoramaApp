package com.baidu.sapi2.utils.enums;

public enum AccountType {
    NORMAL(0),
    INCOMPLETE_USER(1),
    UNKNOWN(2);
    

    /* renamed from: b reason: collision with root package name */
    public int f3040b;

    /* access modifiers changed from: public */
    AccountType(int i2) {
        this.f3040b = i2;
    }

    public static AccountType getAccountType(int i2) {
        if (i2 == 0) {
            return NORMAL;
        }
        if (i2 != 1) {
            return UNKNOWN;
        }
        return INCOMPLETE_USER;
    }

    public int getType() {
        return this.f3040b;
    }
}
