package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import com.gyf.immersionbar.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtility implements NoProguard {
    public static boolean a(Activity activity, boolean z) {
        try {
            LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(8192);
        Class cls = activity.getWindow().getClass();
        try {
            Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField(Constants.IMMERSION_MIUI_STATUS_BAR_DARK).getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window2, objArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        } else if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[Catch:{ Exception -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void enableStatusBarTint(android.app.Activity r3, int r4) {
        /*
            com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x005d }
            com.baidu.sapi2.SapiConfiguration r0 = r0.getConfignation()     // Catch:{ Exception -> 0x005d }
            boolean r0 = r0.isNightMode     // Catch:{ Exception -> 0x005d }
            com.baidu.sapi2.SapiAccountManager r1 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ Exception -> 0x005d }
            com.baidu.sapi2.SapiConfiguration r1 = r1.getConfignation()     // Catch:{ Exception -> 0x005d }
            boolean r1 = r1.isDarkMode     // Catch:{ Exception -> 0x005d }
            r2 = 1
            if (r0 != 0) goto L_0x001c
            if (r1 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            if (r0 == 0) goto L_0x0025
            int r4 = e.c.c.a.b.sapi_sdk_dark_mode_title_color     // Catch:{ Exception -> 0x005d }
            int r4 = r3.getColor(r4)     // Catch:{ Exception -> 0x005d }
        L_0x0025:
            boolean r1 = b(r3, r2)     // Catch:{ Exception -> 0x005d }
            if (r1 != 0) goto L_0x002e
            a(r3, r2)     // Catch:{ Exception -> 0x005d }
        L_0x002e:
            android.view.Window r3 = r3.getWindow()     // Catch:{ Exception -> 0x005d }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlags(r1)     // Catch:{ Exception -> 0x005d }
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r3.clearFlags(r1)     // Catch:{ Exception -> 0x005d }
            r3.setStatusBarColor(r4)     // Catch:{ Exception -> 0x005d }
            if (r0 != 0) goto L_0x004b
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x005d }
            r4 = 9216(0x2400, float:1.2914E-41)
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x004b:
            android.view.View r4 = r3.getDecorView()     // Catch:{ Exception -> 0x005d }
            int r4 = r4.getSystemUiVisibility()     // Catch:{ Exception -> 0x005d }
            r4 = r4 & -8193(0xffffffffffffdfff, float:NaN)
            android.view.View r3 = r3.getDecorView()     // Catch:{ Exception -> 0x005d }
            r3.setSystemUiVisibility(r4)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r3 = move-exception
            com.baidu.sapi2.utils.Log.e(r3)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ViewUtility.enableStatusBarTint(android.app.Activity, int):void");
    }

    public static void setViewClickAlpha(View view, float f2) {
        view.setOnTouchListener(new s(f2));
    }
}
