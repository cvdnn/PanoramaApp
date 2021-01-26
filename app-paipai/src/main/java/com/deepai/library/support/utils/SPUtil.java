package com.deepai.library.support.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPUtil {
    protected static Object get(Context context, String fileName, String key, Object defaultObject) {
        String type = defaultObject.getClass().getSimpleName();
        SharedPreferences sp = context.getSharedPreferences(fileName, 32768);
        if ("String".equals(type)) {
            return sp.getString(key, (String) defaultObject);
        }
        if ("Integer".equals(type)) {
            return Integer.valueOf(sp.getInt(key, ((Integer) defaultObject).intValue()));
        }
        if ("Boolean".equals(type)) {
            return Boolean.valueOf(sp.getBoolean(key, ((Boolean) defaultObject).booleanValue()));
        }
        if ("Float".equals(type)) {
            return Float.valueOf(sp.getFloat(key, ((Float) defaultObject).floatValue()));
        }
        if ("Long".equals(type)) {
            return Long.valueOf(sp.getLong(key, ((Long) defaultObject).longValue()));
        }
        return defaultObject;
    }

    protected static boolean set(Context context, String fileName, String key, Object object) {
        String type = object.getClass().getSimpleName();
        Editor editor = context.getApplicationContext().getSharedPreferences(fileName, 32768).edit();
        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, ((Integer) object).intValue());
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, ((Boolean) object).booleanValue());
        } else if ("Float".equals(type)) {
            editor.putFloat(key, ((Float) object).floatValue());
        } else if ("Long".equals(type)) {
            editor.putLong(key, ((Long) object).longValue());
        }
        return editor.commit();
    }
}
