package com.arashivision.bmgmedia.test;

import com.arashivision.bmgmedia.NativeLibsLoader;

public class TextureUpload {
    static {
        NativeLibsLoader.load();
    }

    public static native void upload(int i2, int i3, String str, String str2);
}
