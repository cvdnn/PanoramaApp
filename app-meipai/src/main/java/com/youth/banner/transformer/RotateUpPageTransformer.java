package com.youth.banner.transformer;

import android.view.View;

public class RotateUpPageTransformer extends BasePageTransformer {
    public static final float DEFAULT_MAX_ROTATE = 15.0f;
    public float mMaxRotate = 15.0f;

    public RotateUpPageTransformer() {
    }

    public void transformPage(View view, float f2) {
        if (f2 < -1.0f) {
            view.setRotation(this.mMaxRotate);
            view.setPivotX((float) view.getWidth());
            view.setPivotY(0.0f);
        } else if (f2 > 1.0f) {
            view.setRotation(-this.mMaxRotate);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
        } else if (f2 < 0.0f) {
            view.setPivotX((((-f2) * 0.5f) + 0.5f) * ((float) view.getWidth()));
            view.setPivotY(0.0f);
            view.setRotation((-this.mMaxRotate) * f2);
        } else {
            view.setPivotX((1.0f - f2) * ((float) view.getWidth()) * 0.5f);
            view.setPivotY(0.0f);
            view.setRotation((-this.mMaxRotate) * f2);
        }
    }

    public RotateUpPageTransformer(float f2) {
        this.mMaxRotate = f2;
    }
}
