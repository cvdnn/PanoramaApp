package com.baidu.picapture.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import e.c.b.e.Utils;

public class GuideView extends View {

    /* renamed from: a reason: collision with root package name */
    public Paint f1999a;

    /* renamed from: b reason: collision with root package name */
    public boolean f2000b = false;

    /* renamed from: c reason: collision with root package name */
    public boolean f2001c = false;

    /* renamed from: d reason: collision with root package name */
    public Paint f2002d;

    /* renamed from: e reason: collision with root package name */
    public PorterDuffXfermode f2003e;

    /* renamed from: f reason: collision with root package name */
    public Point f2004f;

    /* renamed from: g reason: collision with root package name */
    public Rect f2005g = new Rect();

    /* renamed from: h reason: collision with root package name */
    public int f2006h = Color.parseColor("#515151");

    public GuideView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f1999a = paint;
        paint.setAntiAlias(true);
        if (1 == getResources().getConfiguration().orientation) {
            this.f2001c = true;
        }
        Paint paint2 = new Paint();
        this.f2002d = paint2;
        paint2.setAntiAlias(true);
        this.f2003e = new PorterDuffXfermode(Mode.SRC_OUT);
        Point point = new Point();
        this.f2004f = point;
        if (this.f2001c) {
            point.x = Utils.b(44.0f);
            this.f2004f.y = Utils.b(48.0f);
            return;
        }
        point.x = Utils.b(48.0f);
        this.f2004f.y = Utils.b(44.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2000b) {
            canvas.drawRect(this.f2005g, this.f2002d);
            this.f2002d.setXfermode(this.f2003e);
            this.f2002d.setColor(this.f2006h);
            this.f2002d.setAlpha(100);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f2002d);
            this.f1999a.setColor(-1);
            this.f1999a.setStyle(Style.STROKE);
            this.f1999a.setAlpha(51);
            this.f1999a.setStrokeWidth(2.0f);
            Canvas canvas2 = canvas;
            canvas2.drawLine(0.0f, (float) (getHeight() >> 1), (float) getWidth(), (float) (getHeight() >> 1), this.f1999a);
            canvas2.drawLine((float) (getWidth() >> 1), 0.0f, (float) (getWidth() >> 1), (float) getHeight(), this.f1999a);
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int a2 = a(i2);
        int a3 = a(i3);
        if (!this.f2000b) {
            Rect rect = this.f2005g;
            Point point = this.f2004f;
            int i4 = point.x;
            int i5 = point.y;
            rect.set(i4, i5, a2 - i4, a3 - i5);
            this.f2000b = true;
        }
    }

    public GuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public final int a(int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return size;
        }
        if (mode == 0 || mode != 1073741824) {
            return 0;
        }
        return size;
    }
}
