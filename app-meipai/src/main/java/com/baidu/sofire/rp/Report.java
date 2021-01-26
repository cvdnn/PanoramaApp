package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import e.c.f.c;
import e.c.f.n.a;
import e.c.f.n.b;

public class Report {

    /* renamed from: b reason: collision with root package name */
    public static Report f3278b;

    /* renamed from: a reason: collision with root package name */
    public Context f3279a;

    public Report(Context context) {
        this.f3279a = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f3278b == null) {
                f3278b = new Report(context);
            }
            report = f3278b;
        }
        return report;
    }

    public void fr() {
        try {
            b a2 = b.a(this.f3279a);
            Message message = new Message();
            message.what = 9;
            a2.f7048a.f7030a.sendMessage(message);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            a.a(this.f3279a, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void n() {
        try {
            b a2 = b.a(this.f3279a);
            Message message = new Message();
            message.what = 6;
            a2.f7048a.f7030a.sendMessage(message);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void r(boolean z) {
        try {
            b.a(this.f3279a).a();
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void s(String str) {
        try {
            new StringBuilder().append(str);
            c.a();
            a.a(this.f3279a, str);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void sr(String str) {
        try {
            new StringBuilder().append(str);
            c.a();
            b a2 = b.a(this.f3279a);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.f7048a.f7030a.sendMessage(message);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public void w(String str) {
        try {
            a.b(this.f3279a, str);
        } catch (Throwable unused) {
            c.d();
        }
    }
}
