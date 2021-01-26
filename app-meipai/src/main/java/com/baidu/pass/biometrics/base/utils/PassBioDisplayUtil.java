package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class PassBioDisplayUtil {
    public static void enableNavigationBarTint(Activity activity, int i2) {
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.flags |= 134217728;
        window.setAttributes(attributes);
        SapiSystemBarTintManager sapiSystemBarTintManager = new SapiSystemBarTintManager(activity);
        sapiSystemBarTintManager.setNavigationBarTintEnabled(true);
        sapiSystemBarTintManager.setNavigationBarTintColor(i2);
    }

    public static int getNavigationBarHeight(Activity activity) {
        if (hasSoftKeys(activity.getWindowManager())) {
            return new SapiSystemBarTintManager(activity).getConfig().getNavigationBarHeight();
        }
        return 0;
    }

    public static boolean hasSoftKeys(WindowManager windowManager) {
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i3 - displayMetrics2.widthPixels > 0 || i2 - displayMetrics2.heightPixels > 0;
    }
}
