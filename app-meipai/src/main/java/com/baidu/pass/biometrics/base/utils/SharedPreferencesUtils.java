package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class SharedPreferencesUtils {
    public static Object getParam(Context context, String str, String str2, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void setParam(Context context, String str, String str2, Object obj) {
        if (obj != null) {
            String simpleName = obj.getClass().getSimpleName();
            Editor edit = context.getSharedPreferences(str, 0).edit();
            if ("String".equals(simpleName)) {
                edit.putString(str2, (String) obj);
            } else if ("Integer".equals(simpleName)) {
                edit.putInt(str2, ((Integer) obj).intValue());
            } else if ("Boolean".equals(simpleName)) {
                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
            } else if ("Float".equals(simpleName)) {
                edit.putFloat(str2, ((Float) obj).floatValue());
            } else if ("Long".equals(simpleName)) {
                edit.putLong(str2, ((Long) obj).longValue());
            }
            edit.commit();
        }
    }
}
