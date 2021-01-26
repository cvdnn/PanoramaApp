package com.arashivision.arvbmg.util;

public class TestNativeCrashFabric {
    static {
        ARVBMGLibsLoader.load();
    }

    public static native void nativeTestNativeCrash();
}
