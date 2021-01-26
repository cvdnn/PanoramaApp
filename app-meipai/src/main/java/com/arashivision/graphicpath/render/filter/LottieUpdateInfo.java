package com.arashivision.graphicpath.render.filter;

import com.arashivision.insbase.nativeref.NativeObjectRef;
import java.nio.ByteBuffer;

public class LottieUpdateInfo extends NativeObjectRef {
    public LottieUpdateInfo(float f2, float f3, LottieTransitionTransform lottieTransitionTransform, LottieTransitionEffect lottieTransitionEffect) {
        this(f2, f3, lottieTransitionTransform, lottieTransitionEffect, 0, 0, null);
    }

    public static long createNativeWrap(float f2, float f3, LottieTransitionTransform lottieTransitionTransform, LottieTransitionEffect lottieTransitionEffect, int i2, int i3, ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return nativeCreateNativeWrap(f2, f3, lottieTransitionTransform, lottieTransitionEffect, i2, i3, byteBuffer);
        }
        return nativeCreateNativeWrap(f2, f3, lottieTransitionTransform, lottieTransitionEffect, 0, 0, null);
    }

    public static native long nativeCreateNativeWrap(float f2, float f3, LottieTransitionTransform lottieTransitionTransform, LottieTransitionEffect lottieTransitionEffect, int i2, int i3, ByteBuffer byteBuffer);

    public LottieUpdateInfo(float f2, float f3, LottieTransitionTransform lottieTransitionTransform, LottieTransitionEffect lottieTransitionEffect, int i2, int i3, ByteBuffer byteBuffer) {
        super(createNativeWrap(f2, f3, lottieTransitionTransform, lottieTransitionEffect, i2, i3, byteBuffer), "LottieUpdateInfo");
    }
}
