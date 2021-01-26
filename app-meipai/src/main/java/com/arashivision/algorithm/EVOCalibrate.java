package com.arashivision.algorithm;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class EVOCalibrate {
    public static final String TAG = "EVOCalibrate";

    static {
        ARVBMGLibsLoader.load();
    }

    public static native String nativeSelfCalibrate(String str, String str2);

    public static String selfCalibrate(String str, String str2) {
        return nativeSelfCalibrate(str, str2);
    }
}
