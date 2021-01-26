package com.deepai.paipai;

public class NativeMatting {
    public native int BigImgCompose(String str, String str2, String str3, double d, int i, int i2, String str4, String str5);

    public native int ImgCompose(String str, String str2, String str3, double d, int i, int i2, String str4, String str5);

    static {
        System.loadLibrary("mattingImg");
    }
}
