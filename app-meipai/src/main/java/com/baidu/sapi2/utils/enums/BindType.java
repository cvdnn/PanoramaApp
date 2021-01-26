package com.baidu.sapi2.utils.enums;

public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS("sms", "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: b reason: collision with root package name */
    public String f3042b;

    /* renamed from: c reason: collision with root package name */
    public String f3043c;

    /* renamed from: d reason: collision with root package name */
    public String f3044d;

    /* access modifiers changed from: public */
    BindType(String str, String str2, String str3) {
        this.f3042b = "";
        this.f3042b = str;
        this.f3043c = str2;
        this.f3044d = str3;
    }

    public String getCallbackPage() {
        return this.f3043c;
    }

    public String getFinishBindPage() {
        return this.f3044d;
    }

    public String getName() {
        return this.f3042b;
    }
}
