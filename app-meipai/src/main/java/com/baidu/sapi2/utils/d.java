package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;

/* compiled from: SafeService */
public class d {

    /* renamed from: a reason: collision with root package name */
    public static final String f3033a = "SafeService";

    /* renamed from: b reason: collision with root package name */
    public static final int f3034b = 120;

    /* renamed from: c reason: collision with root package name */
    public static final int f3035c = 122;

    /* renamed from: d reason: collision with root package name */
    public static final int f3036d = 1;

    /* compiled from: SafeService */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static d f3037a = new d();
    }

    public static d a() {
        return a.f3037a;
    }

    public d() {
    }

    public boolean a(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(f3033a, "init()", th.toString());
            return false;
        }
    }

    public String a(Context context, String str, int i2) {
        String gzfi = FH.gzfi(context, str, i2);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public String a(Context context, String str, String str2, int i2) {
        return FH.gt(context, str, str2, i2, null);
    }
}
