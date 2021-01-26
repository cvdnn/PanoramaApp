package com.youth.banner.transformer;

import android.view.View;

public class ScaleInTransformer extends BasePageTransformer {
    public static final float DEFAULT_MIN_SCALE = 0.85f;
    public float mMinScale = 0.85f;

    public ScaleInTransformer() {
    }

    public void transformPage(View view, float f2) {
        int width = view.getWidth();
        view.setPivotY((float) (view.getHeight() / 2));
        view.setPivotX((float) (width / 2));
        if (f2 < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            view.setPivotX((float) width);
        } else if (f2 > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
        } else if (f2 < 0.0f) {
            float f3 = f2 + 1.0f;
            float f4 = this.mMinScale;
            float f5 = ((1.0f - f4) * f3) + f4;
            view.setScaleX(f5);
            view.setScaleY(f5);
            view.setPivotX((((-f2) * 0.5f) + 0.5f) * ((float) width));
        } else {
            float f6 = 1.0f - f2;
            float f7 = this.mMinScale;
            float f8 = ((1.0f - f7) * f6) + f7;
            view.setScaleX(f8);
            view.setScaleY(f8);
            view.setPivotX(f6 * 0.5f * ((float) width));
        }
    }

    public ScaleInTransformer(float f2) {
        this.mMinScale = f2;
    }
}
