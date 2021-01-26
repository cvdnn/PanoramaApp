package com.arashivision.arvbmg.util;

public class Insta360Key {
    static {
        ARVBMGLibsLoader.load();
    }

    public static native String nativeGenerateKey(String str, String str2);
}
