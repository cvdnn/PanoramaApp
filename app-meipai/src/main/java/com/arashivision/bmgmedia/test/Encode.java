package com.arashivision.bmgmedia.test;

import com.arashivision.bmgmedia.NativeLibsLoader;

public class Encode {
    public static final String MODE_OUTPUT_DEBUG = "output debug";
    public static final String MODE_SPEED_TEST = "speed test";

    static {
        NativeLibsLoader.load();
    }

    public static native void encodeToFile(String str, int i2, int i3, int i4, double d2, boolean z, String str2, String str3);
}
