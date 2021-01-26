package com.youth.banner.transformer;

import android.view.View;

public class ZoomOutPageTransformer extends BasePageTransformer {
    public static final float DEFAULT_MIN_ALPHA = 0.5f;
    public static final float DEFAULT_MIN_SCALE = 0.85f;
    public float mMinAlpha = 0.5f;
    public float mMinScale = 0.85f;

    public ZoomOutPageTransformer() {
    }

    public void transformPage(View view, float f2) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f2 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f2 <= 1.0f) {
            float max = Math.max(this.mMinScale, 1.0f - Math.abs(f2));
            float f3 = 1.0f - max;
            float f4 = (((float) height) * f3) / 2.0f;
            float f5 = (((float) width) * f3) / 2.0f;
            if (f2 < 0.0f) {
                view.setTranslationX(f5 - (f4 / 2.0f));
            } else {
                view.setTranslationX((f4 / 2.0f) + (-f5));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            float f6 = this.mMinAlpha;
            float f7 = this.mMinScale;
            view.setAlpha(((1.0f - f6) * ((max - f7) / (1.0f - f7))) + f6);
        } else {
            view.setAlpha(0.0f);
        }
    }

    public ZoomOutPageTransformer(float f2, float f3) {
        this.mMinScale = f2;
        this.mMinAlpha = f3;
    }
}
