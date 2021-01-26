package com.baidu.mobstat;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public abstract class ba {

    /* renamed from: a reason: collision with root package name */
    public static int f1692a = 2;

    public abstract String a();

    public void a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(d(th));
        a(2, sb.toString());
    }

    public void b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(d(th));
        a(3, sb.toString());
    }

    public abstract boolean b();

    public void c(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(d(th));
        a(4, sb.toString());
    }

    public void d(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(10);
        sb.append(d(th));
        a(6, sb.toString());
    }

    private String d(Throwable th) {
        String str = "";
        if (th == null) {
            return str;
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return str;
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void a(String str) {
        a(3, str);
    }

    public void b(String str) {
        a(5, str);
    }

    public void c(String str) {
        a(6, str);
    }

    public void a(Throwable th) {
        a(3, d(th));
    }

    public void b(Throwable th) {
        a(5, d(th));
    }

    public void c(Throwable th) {
        a(6, d(th));
    }

    private void a(int i2, String str) {
        if (b() && i2 >= f1692a) {
            Log.println(i2, a(), str);
        }
    }
}
