package com.deepai.paipai;

public class NativeStitcherWrapper {
    public native void cutImage(String str, String str2);

    public native int findFeatures(String str, long j, int i, double d, double d2, double d3, double d4, double d5, double d6);

    public native void initialize(int i, long[] jArr, long[] jArr2);

    public native void match2ImgPairwise(long j, long j2, int i, int i2, int i3, int i4, float f, int i5);

    public native int performStitcher(String str, Object[] objArr, int i, long j, long j2, int i2);

    static {
        System.loadLibrary("matchImgs");
    }
}
