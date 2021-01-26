package com.gyf.immersionbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.baidu.sapi2.utils.SapiDeviceInfo;

public class NotchUtils {
    public static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    public static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    public static final String NOTCH_VIVO = "android.util.FtFeature";
    public static final String NOTCH_XIAO_MI = "ro.miui.notch";
    public static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    public static int dp2px(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static DisplayCutout getDisplayCutout(Activity activity) {
        if (VERSION.SDK_INT >= 28 && activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    return rootWindowInsets.getDisplayCutout();
                }
            }
        }
        return null;
    }

    public static int[] getHuaWeiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }

    public static int getNotchHeight(Activity activity) {
        int statusBarHeight = ImmersionBar.getStatusBarHeight(activity);
        DisplayCutout displayCutout = getDisplayCutout(activity);
        if (VERSION.SDK_INT < 28 || displayCutout == null) {
            int xiaoMiNotchHeight = hasNotchAtXiaoMi(activity) ? getXiaoMiNotchHeight(activity) : 0;
            if (hasNotchAtHuaWei(activity)) {
                xiaoMiNotchHeight = getHuaWeiNotchSize(activity)[1];
            }
            if (hasNotchAtVIVO(activity)) {
                xiaoMiNotchHeight = dp2px(activity, 32);
                if (xiaoMiNotchHeight < statusBarHeight) {
                    xiaoMiNotchHeight = statusBarHeight;
                }
            }
            if (!hasNotchAtOPPO(activity)) {
                return xiaoMiNotchHeight;
            }
            if (80 < statusBarHeight) {
                return statusBarHeight;
            }
            return 80;
        } else if (activity.getResources().getConfiguration().orientation == 1) {
            return displayCutout.getSafeInsetTop();
        } else {
            if (displayCutout.getSafeInsetLeft() == 0) {
                return displayCutout.getSafeInsetRight();
            }
            return displayCutout.getSafeInsetLeft();
        }
    }

    public static int getXiaoMiNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", SapiDeviceInfo.f3010c);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    public static boolean hasNotchAtHuaWei(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasNotchAtVIVO(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean hasNotchAtXiaoMi(android.content.Context r6) {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = "Xiaomi"
            boolean r0 = r1.equals(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003e
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r6 = r6.loadClass(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r0 = "getInt"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            r4[r1] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r4 = "ro.miui.notch"
            r3[r2] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            r3[r1] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Object r6 = r0.invoke(r6, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            int r6 = r6.intValue()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r6 = r2
        L_0x003f:
            if (r6 != r1) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r1 = r2
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.NotchUtils.hasNotchAtXiaoMi(android.content.Context):boolean");
    }

    public static boolean hasNotchScreen(Activity activity) {
        return activity != null && (hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtAndroidP(activity));
    }

    public static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    public static DisplayCutout getDisplayCutout(View view) {
        if (VERSION.SDK_INT >= 28 && view != null) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets != null) {
                return rootWindowInsets.getDisplayCutout();
            }
        }
        return null;
    }

    public static boolean hasNotchScreen(View view) {
        return view != null && (hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext()) || hasNotchAtAndroidP(view));
    }
}
