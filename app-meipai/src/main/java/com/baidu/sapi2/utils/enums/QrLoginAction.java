package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.outsdk.c;

public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN(c.k),
    CANCEL("cancel");
    

    /* renamed from: b reason: collision with root package name */
    public String f3063b;

    /* access modifiers changed from: public */
    QrLoginAction(String str) {
        this.f3063b = str;
    }

    public String getName() {
        return this.f3063b;
    }
}
