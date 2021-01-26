package com.arashivision.arvbmg.hdr;

public class HdrUtils {
    public static boolean doHdr(String str, String str2, String str3, String str4) {
        return doHdr(str, str2, str3, str4, false);
    }

    public static native boolean hdr(String str, String str2, String str3, String str4, boolean z);

    public static boolean doHdr(String str, String str2, String str3, String str4, boolean z) {
        return hdr(str, str2, str3, str4, z);
    }
}
