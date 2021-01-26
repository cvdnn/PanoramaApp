package com.gyf.immersionbar;

import android.text.TextUtils;

public class OSUtils {
    public static final String KEY_DISPLAY = "ro.build.display.id";
    public static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static String getEMUIVersion() {
        String str = "";
        return isEMUI() ? getSystemProperty(KEY_EMUI_VERSION_NAME, str) : str;
    }

    public static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    public static String getFlymeOSVersion() {
        String str = "";
        return isFlymeOS() ? getSystemProperty(KEY_DISPLAY, str) : str;
    }

    public static String getMIUIVersion() {
        String str = "";
        return isMIUI() ? getSystemProperty(KEY_MIUI_VERSION_NAME, str) : str;
    }

    public static String getSystemProperty(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class cls2 = Class.forName(NotchUtils.SYSTEM_PROPERTIES);
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME, ""));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        int i2;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i2 = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i2 = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i2 >= 4) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int i2;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i2 = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i2 = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i2 == 5) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME, ""));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            if (Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
