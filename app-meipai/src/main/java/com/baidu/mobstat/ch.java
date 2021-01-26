package com.baidu.mobstat;

public class ch extends Exception {

    /* renamed from: a reason: collision with root package name */
    public int f1816a;

    public ch(int i2) {
        this.f1816a = i2;
    }

    public int a() {
        return this.f1816a;
    }

    public ch(int i2, String str) {
        super(str);
        this.f1816a = i2;
    }

    public ch(int i2, Throwable th) {
        super(th);
        this.f1816a = i2;
    }
}
