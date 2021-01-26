package com.arashivision.bmgmedia.test;

import com.arashivision.bmgmedia.NativeLibsLoader;

public class Misc {
    static {
        NativeLibsLoader.load();
    }

    public static native void dnsLookUp(String str, int i2);

    public static native void jniDetachAttachTest();

    public static native void panoInfoSaveXMP(String str);
}
