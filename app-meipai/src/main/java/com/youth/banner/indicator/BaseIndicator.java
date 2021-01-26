package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.youth.banner.config.IndicatorConfig;

public class BaseIndicator extends View implements Indicator {
    public IndicatorConfig config;
    public Paint mPaint;
    public float positionOffset;

    public BaseIndicator(Context context) {
        this(context, null);
    }

    public IndicatorConfig getIndicatorConfig() {
        return this.config;
    }

    public View getIndicatorView() {
        if (this.config.isAttachToBanner()) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            int gravity = this.config.getGravity();
            if (gravity == 0) {
                layoutParams.gravity = 8388691;
            } else if (gravity == 1) {
                layoutParams.gravity = 81;
            } else if (gravity == 2) {
                layoutParams.gravity = 8388693;
            }
            layoutParams.leftMargin = this.config.getMargins().leftMargin;
            layoutParams.rightMargin = this.config.getMargins().rightMargin;
            layoutParams.topMargin = this.config.getMargins().topMargin;
            layoutParams.bottomMargin = this.config.getMargins().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    public void onPageChanged(int i2, int i3) {
        this.config.setIndicatorSize(i2);
        this.config.setCurrentPosition(i3);
        requestLayout();
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.positionOffset = f2;
    }

    public void onPageSelected(int i2) {
        this.config.setCurrentPosition(i2);
        postInvalidate();
    }

    public BaseIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.config = new IndicatorConfig();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(this.config.getNormalColor());
    }
}
