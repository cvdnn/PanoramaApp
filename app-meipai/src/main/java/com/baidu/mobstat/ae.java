package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;

public class ae extends bn {

    /* renamed from: a reason: collision with root package name */
    public static final String f1504a = "baidu_mtj_sdk_record";

    /* renamed from: b reason: collision with root package name */
    public static ae f1505b = new ae();

    public static ae a() {
        return f1505b;
    }

    public Long b(Context context) {
        return Long.valueOf(a(context, "session_first_visit_time", 0));
    }

    public Long c(Context context) {
        return Long.valueOf(a(context, "session_last_visit_time", 0));
    }

    public Long d(Context context) {
        return Long.valueOf(a(context, "session_visit_interval", 0));
    }

    public String e(Context context) {
        return a(context, "session_today_visit_count", "");
    }

    public String f(Context context) {
        return a(context, "session_recent_visit", "");
    }

    public SharedPreferences a(Context context) {
        return context.getSharedPreferences(f1504a, 4);
    }

    public void b(Context context, long j2) {
        b(context, "session_last_visit_time", j2);
    }

    public void c(Context context, long j2) {
        b(context, "session_visit_interval", j2);
    }

    public void a(Context context, long j2) {
        b(context, "session_first_visit_time", j2);
    }

    public void b(Context context, String str) {
        b(context, "session_recent_visit", str);
    }

    public void a(Context context, String str) {
        b(context, "session_today_visit_count", str);
    }
}
