package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.pass.biometrics.face.R;

public class ConstrastLoadingView extends LinearLayout {
    public ImageView recogCircleIv;
    public ImageView recogLogoIv;

    public ConstrastLoadingView(Context context) {
        super(context);
        init(context);
    }

    private RotateAnimation getRotateAnimaton(boolean z, long j2) {
        RotateAnimation rotateAnimation;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z) {
            rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        } else {
            rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
        }
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(j2);
        rotateAnimation.setInterpolator(linearInterpolator);
        return rotateAnimation;
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_pass_liveness_constrast_loading, this);
        this.recogCircleIv = (ImageView) findViewById(R.id.iv_recog_circle);
        this.recogLogoIv = (ImageView) findViewById(R.id.iv_recog_logo);
        startLoadingAnim();
    }

    private void startLoadingAnim() {
        this.recogCircleIv.startAnimation(getRotateAnimaton(true, 1200));
    }

    public void clearAnim() {
        this.recogCircleIv.clearAnimation();
        clearAnimation();
        setVisibility(4);
    }

    public void setVisible(int i2) {
        setVisibility(i2);
        startLoadingAnim();
    }

    public ConstrastLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
