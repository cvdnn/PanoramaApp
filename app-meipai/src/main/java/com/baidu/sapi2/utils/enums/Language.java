package com.baidu.sapi2.utils.enums;

public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    

    /* renamed from: b reason: collision with root package name */
    public int f3058b;

    /* renamed from: c reason: collision with root package name */
    public String f3059c;

    /* access modifiers changed from: public */
    Language(int i2, String str) {
        this.f3058b = i2;
        this.f3059c = str;
    }

    public int getType() {
        return this.f3058b;
    }
}
