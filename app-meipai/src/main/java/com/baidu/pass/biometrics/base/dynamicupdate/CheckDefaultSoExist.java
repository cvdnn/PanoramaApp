package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

public class CheckDefaultSoExist {
    public static String findLibrary1(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            return null;
        }
        try {
            Method method = classLoader.getClass().getMethod("findLibrary", new Class[]{String.class});
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(classLoader, new Object[]{str});
            if (invoke == null || !(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Exception e2) {
            Log.e("findLibrary1", e2.toString());
            return "catch Exception";
        }
    }

    public static String findLibrary2(Context context, String str) {
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            return null;
        }
        try {
            Method declaredMethod = classLoader.getClass().getDeclaredMethod("findLibrary", new Class[]{String.class});
            if (declaredMethod == null) {
                return null;
            }
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            Object invoke = declaredMethod.invoke(classLoader, new Object[]{str});
            if (invoke == null || !(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Exception e2) {
            Log.e("findLibrary2", e2.toString());
            return "catch Exception";
        }
    }

    public static void isExist(Context context) {
        String[] strArr;
        for (String str : LoadSo.SO_NAME_ARRAY) {
            if (TextUtils.isEmpty(findLibrary1(context, str))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" so is not exist ,please put the ");
                sb.append(str);
                sb.append(" so file in the right folder");
                Log.e("CheckDefaultSoExist", sb.toString());
            }
        }
    }
}
