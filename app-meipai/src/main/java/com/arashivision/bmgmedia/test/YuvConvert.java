package com.arashivision.bmgmedia.test;

import com.arashivision.bmgmedia.NativeLibsLoader;

public class YuvConvert {
    static {
        NativeLibsLoader.load();
    }

    public static native void yuvCopy(int i2, int i3);
}
