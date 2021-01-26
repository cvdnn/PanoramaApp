package com.arashivision.onestream;

import android.view.Surface;

public class JniUtils {
    static {
        System.loadLibrary("c++_shared");
        NativePlayerLibLoader.load();
    }

    public static long getCurrentEglContextNativeHandle() {
        return nativeGetCurrentEglContextNativeHandle();
    }

    public static int getSurfaceHeight(Surface surface) {
        return nativeGetSurfaceHeight(surface);
    }

    public static int getSurfaceWidth(Surface surface) {
        return nativeGetSurfaceWidth(surface);
    }

    public static native long nativeGetCurrentEglContextNativeHandle();

    public static native int nativeGetSurfaceHeight(Surface surface);

    public static native int nativeGetSurfaceWidth(Surface surface);

    public static native int nativeSetSurfaceBufferSize(Surface surface, int i2, int i3);

    public static int setSurfaceBufferSize(Surface surface, int i2, int i3) {
        return nativeSetSurfaceBufferSize(surface, i2, i3);
    }
}
