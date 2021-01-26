package com.youth.banner.transformer;

import android.view.View;

public class AlphaPageTransformer extends BasePageTransformer {
    public static final float DEFAULT_MIN_ALPHA = 0.5f;
    public float mMinAlpha = 0.5f;

    public AlphaPageTransformer() {
    }

    public void transformPage(View view, float f2) {
        view.setScaleX(0.999f);
        if (f2 < -1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f2 > 1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f2 < 0.0f) {
            float f3 = this.mMinAlpha;
            view.setAlpha(((f2 + 1.0f) * (1.0f - f3)) + f3);
        } else {
            float f4 = this.mMinAlpha;
            view.setAlpha(((1.0f - f2) * (1.0f - f4)) + f4);
        }
    }

    public AlphaPageTransformer(float f2) {
        this.mMinAlpha = f2;
    }
}
