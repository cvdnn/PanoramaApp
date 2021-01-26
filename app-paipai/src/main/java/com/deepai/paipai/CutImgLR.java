package com.deepai.paipai;

public class CutImgLR {
    public native void cutImageLR(String str, String str2, int i, int i2);

    static {
        System.loadLibrary("cuttingImg");
    }
}
