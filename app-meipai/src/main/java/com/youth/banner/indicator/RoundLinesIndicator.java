package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.config.getIndicatorSize() > 1) {
            this.mPaint.setColor(this.config.getNormalColor());
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
            this.mPaint.setColor(this.config.getSelectedColor());
            float selectedWidth = (float) ((int) (this.config.getSelectedWidth() * ((float) this.config.getCurrentPosition())));
            canvas.drawRoundRect(new RectF(selectedWidth, 0.0f, this.config.getSelectedWidth() + selectedWidth, (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            setMeasuredDimension((int) (this.config.getSelectedWidth() * ((float) indicatorSize)), this.config.getHeight());
        }
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint.setStyle(Style.FILL);
    }
}
