package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

public class ad implements UncaughtExceptionHandler {

    /* renamed from: a reason: collision with root package name */
    public static final ad f1501a = new ad();

    /* renamed from: b reason: collision with root package name */
    public UncaughtExceptionHandler f1502b;

    /* renamed from: c reason: collision with root package name */
    public Context f1503c;

    public static ad a() {
        return f1501a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f1503c, th, true);
        if (!this.f1502b.equals(this)) {
            this.f1502b.uncaughtException(thread, th);
        }
    }

    public void a(Context context) {
        this.f1503c = context;
        if (this.f1502b == null) {
            this.f1502b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
