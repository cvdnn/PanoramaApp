package com.youth.banner.transformer;

import android.view.View;

public class RotateYTransformer extends BasePageTransformer {
    public static final float DEFAULT_MAX_ROTATE = 35.0f;
    public float mMaxRotate = 35.0f;

    public RotateYTransformer() {
    }

    public void transformPage(View view, float f2) {
        view.setPivotY((float) (view.getHeight() / 2));
        if (f2 < -1.0f) {
            view.setRotationY(this.mMaxRotate * -1.0f);
            view.setPivotX((float) view.getWidth());
        } else if (f2 <= 1.0f) {
            view.setRotationY(this.mMaxRotate * f2);
            if (f2 < 0.0f) {
                view.setPivotX((((-f2) * 0.5f) + 0.5f) * ((float) view.getWidth()));
                view.setPivotX((float) view.getWidth());
                return;
            }
            view.setPivotX((1.0f - f2) * ((float) view.getWidth()) * 0.5f);
            view.setPivotX(0.0f);
        } else {
            view.setRotationY(this.mMaxRotate * 1.0f);
            view.setPivotX(0.0f);
        }
    }

    public RotateYTransformer(float f2) {
        this.mMaxRotate = f2;
    }
}
