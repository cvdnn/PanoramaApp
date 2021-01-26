package com.baidu.mobstat;

public class cv extends cy implements ct {

    /* renamed from: a reason: collision with root package name */
    public String f1832a = "*";

    public void a(String str) throws IllegalArgumentException {
        if (str != null) {
            this.f1832a = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }

    public String a() {
        return this.f1832a;
    }
}
