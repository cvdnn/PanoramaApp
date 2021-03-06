package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class bn {
    public abstract SharedPreferences a(Context context);

    public boolean a(Context context, String str, boolean z) {
        return a(context).getBoolean(str, z);
    }

    public void b(Context context, String str, boolean z) {
        a(context).edit().putBoolean(str, z).commit();
    }

    public void c(Context context, String str) {
        a(context).edit().remove(str).commit();
    }

    public int a(Context context, String str, int i2) {
        return a(context).getInt(str, i2);
    }

    public void b(Context context, String str, int i2) {
        a(context).edit().putInt(str, i2).commit();
    }

    public long a(Context context, String str, long j2) {
        return a(context).getLong(str, j2);
    }

    public void b(Context context, String str, long j2) {
        a(context).edit().putLong(str, j2).commit();
    }

    public String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }

    public void b(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).commit();
    }
}
