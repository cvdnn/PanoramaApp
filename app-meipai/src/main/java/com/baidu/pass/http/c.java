package com.baidu.pass.http;

import android.util.Log;
import java.util.regex.Pattern;

/* compiled from: PassHttpUtils */
public class c {

    /* renamed from: a reason: collision with root package name */
    public static boolean f1951a = false;

    /* renamed from: b reason: collision with root package name */
    public static final String f1952b = "c";

    /* renamed from: c reason: collision with root package name */
    public static final Pattern f1953c = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static void a(String str, String str2) {
        if (f1951a) {
            Log.e(str, str2);
        }
    }

    public static boolean b(String str) {
        return f1953c.matcher(str).matches();
    }

    public static void a(String str) {
        a(f1952b, str);
    }
}
