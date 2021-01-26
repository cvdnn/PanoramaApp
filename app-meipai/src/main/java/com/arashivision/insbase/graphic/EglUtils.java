package com.arashivision.insbase.graphic;

public class EglUtils {
    public static long getCurrentEglContextNativeHandle() {
        return nativeGetCurrentEglContextNativeHandle();
    }

    public static native long nativeGetCurrentEglContextNativeHandle();
}
