package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class CircleIndicator extends BaseIndicator {
    public float mNormalRadius;
    public float mSelectedRadius;
    public float maxRadius;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            this.mPaint.setColor(this.config.getNormalColor());
            for (int i2 = 0; i2 < indicatorSize; i2++) {
                canvas.drawCircle(((this.config.getIndicatorSpace() + this.config.getNormalWidth()) * ((float) i2)) + this.maxRadius, this.maxRadius, this.mNormalRadius, this.mPaint);
            }
            this.mPaint.setColor(this.config.getSelectedColor());
            canvas.drawCircle(((this.config.getIndicatorSpace() + this.config.getNormalWidth()) * ((float) this.config.getCurrentPosition())) + this.maxRadius, this.maxRadius, this.mSelectedRadius, this.mPaint);
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            this.mNormalRadius = this.config.getNormalWidth() / 2.0f;
            float selectedWidth = this.config.getSelectedWidth() / 2.0f;
            this.mSelectedRadius = selectedWidth;
            this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
            float f2 = (float) (indicatorSize - 1);
            float indicatorSpace = this.config.getIndicatorSpace() * f2;
            float f3 = this.maxRadius;
            setMeasuredDimension((int) ((((this.mNormalRadius * f2) + f3) * 2.0f) + indicatorSpace), (int) (f3 * 2.0f));
        }
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mNormalRadius = this.config.getNormalWidth() / 2.0f;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2.0f;
    }
}
