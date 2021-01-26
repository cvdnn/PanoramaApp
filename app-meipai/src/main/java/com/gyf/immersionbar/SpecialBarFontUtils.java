package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SpecialBarFontUtils {
    public static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    public static Method mSetStatusBarColorIcon;
    public static Method mSetStatusBarDarkIcon;
    public static Field mStatusBarColorFiled;

    static {
        String str = "setStatusBarDarkIcon";
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod(str, new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod(str, new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean changeMeizuFlag(LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i4 = z ? i2 | i3 : (~i2) & i3;
            if (i3 != i4) {
                declaredField2.setInt(layoutParams, i4);
                return true;
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean isBlackColor(int i2, int i3) {
        return toGrey(i2) < i3;
    }

    @SuppressLint({"PrivateApi"})
    public static void setMIUIBarDark(Window window, String str, boolean z) {
        if (window != null) {
            Class cls = window.getClass();
            try {
                Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i2), Integer.valueOf(i2)});
                    return;
                }
                method.invoke(window, new Object[]{Integer.valueOf(0), Integer.valueOf(i2)});
            } catch (Exception unused) {
            }
        }
    }

    public static void setStatusBarColor(Window window, int i2) {
        LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i2) {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i2)});
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } else {
            boolean isBlackColor = isBlackColor(i2, 50);
            if (mStatusBarColorFiled != null) {
                setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i2);
                return;
            }
            setStatusBarDarkIcon(activity, isBlackColor);
        }
    }

    public static int toGrey(int i2) {
        return (((i2 & 255) * 15) + ((((65280 & i2) >> 8) * 75) + (((i2 & 16711680) >> 16) * 38))) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i2) {
        try {
            setStatusBarColor(window, i2);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        setStatusBarDarkIcon(activity, z, true);
    }

    public static void setStatusBarDarkIcon(View view, boolean z) {
        int i2;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i2 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i2 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        setStatusBarDarkIcon(window.getDecorView(), z);
        setStatusBarColor(window, 0);
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        Method method = mSetStatusBarDarkIcon;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        } else if (z2) {
            setStatusBarDarkIcon(activity.getWindow(), z);
        }
    }
}
