package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RectangleIndicator extends BaseIndicator {
    public RectangleIndicator(Context context) {
        this(context, null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i2 = 0;
            float f2 = 0.0f;
            while (i2 < indicatorSize) {
                this.mPaint.setColor(this.config.getCurrentPosition() == i2 ? this.config.getSelectedColor() : this.config.getNormalColor());
                RectF rectF = new RectF(f2, 0.0f, this.config.getNormalWidth() + f2, (float) this.config.getHeight());
                i2++;
                f2 = ((float) i2) * (this.config.getIndicatorSpace() + this.config.getNormalWidth());
                canvas.drawRoundRect(rectF, (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            setMeasuredDimension((int) ((this.config.getNormalWidth() * ((float) indicatorSize)) + (this.config.getIndicatorSpace() * ((float) (indicatorSize - 1)))), this.config.getHeight());
        }
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
