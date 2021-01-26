package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import e.c.a.a.b.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class bx {
    public static String a(Context context) {
        String str;
        String str2 = "";
        try {
            str = a.a(context);
        } catch (Throwable unused) {
            str = str2;
        }
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        if (map != null) {
            return new HashMap<>(map);
        }
        return null;
    }

    public static String a(long j2) {
        Date date = new Date(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        return simpleDateFormat.format(date);
    }

    public static boolean a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String methodName = stackTraceElement.getMethodName();
            if (!TextUtils.isEmpty(methodName) && cls != null && methodName.equals(str)) {
                Class cls2 = null;
                try {
                    cls2 = Class.forName(stackTraceElement.getClassName());
                } catch (Throwable unused) {
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return str.length() > i2 ? str.substring(0, i2) : str;
    }
}
