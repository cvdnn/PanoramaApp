package com.arashivision.bmgmedia.test;

import com.arashivision.bmgmedia.NativeLibsLoader;

public class Export {
    static {
        NativeLibsLoader.load();
    }

    public static native void exportFile(int i2, int i3, int i4, double d2, boolean z, boolean z2, boolean z3, String str, long j2, String str2, String str3);
}
