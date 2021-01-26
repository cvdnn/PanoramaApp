package com.arashivision.algorithm;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class RoiDetect {
    public static final String TAG = "RoiDetect";
    public boolean mReleased;

    static {
        ARVBMGLibsLoader.load();
    }

    public static int detect(String str, String str2, String str3, String str4, float[] fArr) {
        return detect(str, str2, str3, "person", str4, fArr);
    }

    public static native int nativeDetect(String str, String str2, String str3, String str4, String str5, float[] fArr, boolean z);

    public static int detect(String str, String str2, String str3, String str4, String str5, float[] fArr) {
        return detect(str, str2, str3, str4, str5, fArr, false);
    }

    public static int detect(String str, String str2, String str3, String str4, String str5, float[] fArr, boolean z) {
        return nativeDetect(str, str2, str3, str4, str5, fArr, z);
    }
}
