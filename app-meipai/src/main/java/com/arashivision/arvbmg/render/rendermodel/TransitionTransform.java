package com.arashivision.arvbmg.render.rendermodel;

public class TransitionTransform extends BMGNativeObjectRef {
    public TransitionTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this(createNativeWrap(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17);

    public TransitionTransform(long j2) {
        super(j2, "TransitionTransform");
    }
}
