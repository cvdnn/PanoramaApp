package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public final class MultiViewRectInfo extends BMGNativeObjectRef {

    public static final class MultiViewMode {
        public static final int MULTIVIEW_CIRCLE = 2;
        public static final int MULTIVIEW_DOUBLE_ASTEROID = 3;
        public static final int MULTIVIEW_DOUBLE_WATCH = 4;
        public static final int MULTIVIEW_RECTANGLE = 1;
    }

    public static final class Rect {
        public float mHeight = 1.0f;
        public float mWidth = 1.0f;
        public float mX = 0.0f;
        public float mY = 0.0f;
    }

    public MultiViewRectInfo(Rect rect, Rect rect2, int i2, boolean z) {
        super(createNativeWrap(rect.mX, rect.mY, rect.mWidth, rect.mHeight, rect2.mX, rect2.mY, rect2.mWidth, rect2.mHeight, i2, z), "MultiViewRectInfo");
        setRequireFreeManually();
    }

    public static native long createNativeWrap(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i2, boolean z);
}
