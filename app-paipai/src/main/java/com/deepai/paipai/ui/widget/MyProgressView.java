package com.deepai.paipai.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class MyProgressView extends View {
    Paint mPaint;
    public float max;
    int myH;
    int myW;
    public float start;

    public MyProgressView(Context context) {
        super(context);
        this.myW = 0;
        this.myH = 0;
        this.start = 0.0f;
        this.max = 100.0f;
    }

    public MyProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.myW = 0;
        this.myH = 0;
        this.start = 0.0f;
        this.max = 100.0f;
        this.mPaint = new Paint();
        this.mPaint.setColor(-16777216);
        this.myW = getWidth();
        this.myH = getHeight();
    }

    public void setNum(int num) {
        this.start = (float) num;
        invalidate();
    }

    public void setNumAndMax(int num, int max2) {
        this.start = (float) num;
        this.max = (float) max2;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(-9342607);
        this.mPaint.setStyle(Style.FILL);
        canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.mPaint);
        this.mPaint.setColor(-58113);
        canvas.drawRect(0.0f, 0.0f, ((float) canvas.getWidth()) * (this.start / this.max), (float) canvas.getHeight(), this.mPaint);
    }
}
