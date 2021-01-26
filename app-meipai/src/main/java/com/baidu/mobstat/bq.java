package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class bq extends bn {

    /* renamed from: a reason: collision with root package name */
    public static final String f1762a = "__Baidu_Stat_SDK_SendRem";

    /* renamed from: b reason: collision with root package name */
    public static bq f1763b = new bq();

    public static bq a() {
        return f1763b;
    }

    public int b(Context context) {
        return a(context, "sendLogtype", 0);
    }

    public int c(Context context) {
        return a(context, "timeinterval", 1);
    }

    public boolean d(Context context) {
        return a(context, "onlywifi", false);
    }

    public String e(Context context) {
        return a(context, "device_id_1", (String) null);
    }

    public String f(Context context) {
        return a(context, "setchannelwithcodevalue", (String) null);
    }

    public boolean g(Context context) {
        return a(context, "setchannelwithcode", false);
    }

    public String h(Context context) {
        return a(context, "mtjsdkmacss2_1", (String) null);
    }

    public boolean i(Context context) {
        return a(context, "mtjtv", false);
    }

    public String j(Context context) {
        return a(context, "mtjsdkmacsstv_1", (String) null);
    }

    public String k(Context context) {
        return a(context, "he.ext", (String) null);
    }

    public String l(Context context) {
        return a(context, "he.push", (String) null);
    }

    public boolean m(Context context) {
        return a(context, "mtjsdkmactrick", true);
    }

    public long n(Context context) {
        return a(context, "autotrace_track_js_fetch_time", 0);
    }

    public long o(Context context) {
        return a(context, "autotrace_track_js_fetch_interval", 0);
    }

    public long p(Context context) {
        return a(context, "autotrace_config_fetch_time", 0);
    }

    public String q(Context context) {
        return a(context, "custom_userid", "");
    }

    public String r(Context context) {
        return a(context, "last_custom_userid", "");
    }

    public String s(Context context) {
        return a(context, "scheme_time", "");
    }

    public String t(Context context) {
        return a(context, "encrypt_device_id", "");
    }

    public String u(Context context) {
        return a(context, Config.USER_PROPERTY, "");
    }

    public SharedPreferences a(Context context) {
        return context.getSharedPreferences(f1762a, 0);
    }

    public void b(Context context, int i2) {
        b(context, "timeinterval", i2);
    }

    public void c(Context context, boolean z) {
        b(context, "mtjtv", z);
    }

    public void d(Context context, String str) {
        b(context, "setchannelwithcodevalue", str);
    }

    public void e(Context context, String str) {
        b(context, "mtjsdkmacss2_1", str);
    }

    public void f(Context context, String str) {
        b(context, "mtjsdkmacsstv_1", str);
    }

    public void g(Context context, String str) {
        b(context, "he.ext", str);
    }

    public void h(Context context, String str) {
        b(context, "he.push", str);
    }

    public void i(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        b(context, "custom_userid", str);
    }

    public void j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        b(context, "last_custom_userid", str);
    }

    public void k(Context context, String str) {
        b(context, "scheme_time", str);
    }

    public void l(Context context, String str) {
        b(context, "encrypt_device_id", str);
    }

    public void m(Context context, String str) {
        b(context, Config.USER_PROPERTY, str);
    }

    public void a(Context context, int i2) {
        b(context, "sendLogtype", i2);
    }

    public void b(Context context, String str) {
        String str2 = "cuid";
        if (a(context, str2, (String) null) != null) {
            c(context, str2);
        }
        String str3 = "cuidsec_1";
        b(context, str3, str);
        c(context, str3);
        c(context, str3);
        c(context, "cuidsec_2");
    }

    public void c(Context context, long j2) {
        b(context, "autotrace_config_fetch_time", j2);
    }

    public void d(Context context, boolean z) {
        b(context, "mtjsdkmactrick", z);
    }

    public void a(Context context, boolean z) {
        b(context, "onlywifi", z);
    }

    public void a(Context context, String str) {
        b(context, "device_id_1", str);
    }

    public void a(Context context, long j2) {
        b(context, "autotrace_track_js_fetch_time", j2);
    }

    public void b(Context context, boolean z) {
        b(context, "setchannelwithcode", z);
    }

    public void b(Context context, long j2) {
        b(context, "autotrace_track_js_fetch_interval", j2);
    }
}
