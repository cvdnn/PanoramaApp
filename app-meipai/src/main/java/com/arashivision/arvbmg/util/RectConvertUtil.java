package com.arashivision.arvbmg.util;

public class RectConvertUtil {

    public class ViewportRatio {
        public static final float RATIO_16_9 = 1.7777778f;
        public static final float RATIO_1_1 = 1.0f;
        public static final float RATIO_235_1 = 2.35f;
        public static final float RATIO_9_16 = 0.5625f;

        public ViewportRatio() {
        }
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public static float[] convertRects(float[] fArr, float[] fArr2, float f2, float f3, float f4, float[] fArr3, float f5, float f6, float f7) {
        return nativeConvertRects(fArr, fArr2, f2, f3, f4, fArr3, f5, f6, f7);
    }

    public static native float[] nativeConvertRects(float[] fArr, float[] fArr2, float f2, float f3, float f4, float[] fArr3, float f5, float f6, float f7);
}
