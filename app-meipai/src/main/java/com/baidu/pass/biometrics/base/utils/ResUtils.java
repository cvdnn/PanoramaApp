package com.baidu.pass.biometrics.base.utils;

import android.content.Context;

public final class ResUtils {
    public static Context appContext;

    public static String getString(int i2) {
        Context context = appContext;
        return context != null ? context.getString(i2) : "";
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            appContext = context.getApplicationContext();
        }
    }
}
