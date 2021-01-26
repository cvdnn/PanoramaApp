package com.youth.banner.transformer;

import android.view.View;

public class DepthPageTransformer extends BasePageTransformer {
    public static final float DEFAULT_MIN_SCALE = 0.75f;
    public float mMinScale = 0.75f;

    public DepthPageTransformer() {
    }

    public void transformPage(View view, float f2) {
        int width = view.getWidth();
        if (f2 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f2 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f2 <= 1.0f) {
            view.setAlpha(1.0f - f2);
            view.setTranslationX(((float) width) * (-f2));
            float f3 = this.mMinScale;
            float abs = ((1.0f - Math.abs(f2)) * (1.0f - f3)) + f3;
            view.setScaleX(abs);
            view.setScaleY(abs);
        } else {
            view.setAlpha(0.0f);
        }
    }

    public DepthPageTransformer(float f2) {
        this.mMinScale = f2;
    }
}
