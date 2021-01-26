package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.widget.TextView;

public class ag extends TextView {

    /* renamed from: a reason: collision with root package name */
    public Paint f1508a = new Paint();

    /* renamed from: b reason: collision with root package name */
    public PaintFlagsDrawFilter f1509b = new PaintFlagsDrawFilter(0, 3);

    public ag(Context context) {
        super(context);
        this.f1508a.setColor(-1);
        this.f1508a.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        canvas.setDrawFilter(this.f1509b);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (Math.max(getWidth(), getHeight()) / 2), this.f1508a);
        super.draw(canvas);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int max = Math.max(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(max, max);
    }

    public void setBackgroundColor(int i2) {
        this.f1508a.setColor(i2);
    }
}
