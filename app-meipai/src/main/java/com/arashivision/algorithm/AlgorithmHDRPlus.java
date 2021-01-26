package com.arashivision.algorithm;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class AlgorithmHDRPlus extends BMGNativeObjectRef {
    public AlgorithmHDRPlus() {
        this(createNativeWrap());
    }

    public static int DNGToJpeg(String str, String str2) {
        return nativeDNGToJpeg(str, str2);
    }

    public static native long createNativeWrap();

    public static native int nativeDNGToJpeg(String str, String str2);

    private native int nativeInputImage(String str);

    private native int nativeOutputJpg(String str);

    public int inputImage(String str) {
        return nativeInputImage(str);
    }

    public int outputJpg(String str) {
        return nativeOutputJpg(str);
    }

    public AlgorithmHDRPlus(long j2) {
        super(j2, "AlgorithmHDRPlus");
    }
}
