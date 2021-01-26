package com.arashivision.arvbmg.render.lottie.transform;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.arvbmg.render.rendermodel.TransitionEffect;
import com.arashivision.arvbmg.render.rendermodel.TransitionTransform;
import java.nio.ByteBuffer;

public class LottieUpdateInfo extends BMGNativeObjectRef {

    public static class LottieMaskData {
        public ByteBuffer data;
        public int height;
        public int width;
    }

    public LottieUpdateInfo(float f2, float f3, TransitionTransform transitionTransform, TransitionEffect transitionEffect) {
        this(f2, f3, transitionTransform, transitionEffect, null);
    }

    public static long createNativeWrap(float f2, float f3, TransitionTransform transitionTransform, TransitionEffect transitionEffect, LottieMaskData lottieMaskData) {
        if (lottieMaskData == null) {
            return nativeCreateNativeWrap(f2, f3, transitionTransform, transitionEffect, 0, 0, null);
        }
        return nativeCreateNativeWrap(f2, f3, transitionTransform, transitionEffect, lottieMaskData.width, lottieMaskData.height, lottieMaskData.data);
    }

    public static native long nativeCreateNativeWrap(float f2, float f3, TransitionTransform transitionTransform, TransitionEffect transitionEffect, int i2, int i3, ByteBuffer byteBuffer);

    public LottieUpdateInfo(float f2, float f3, TransitionTransform transitionTransform, TransitionEffect transitionEffect, LottieMaskData lottieMaskData) {
        super(createNativeWrap(f2, f3, transitionTransform, transitionEffect, lottieMaskData), "LottieUpdateInfo");
        setRequireFreeManually();
    }
}
