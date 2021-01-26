package com.baidu.picapture.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import e.c.d.c;

public class CircleProgressBar extends View {

    /* renamed from: a reason: collision with root package name */
    public int f1989a;

    /* renamed from: b reason: collision with root package name */
    public int f1990b;

    /* renamed from: c reason: collision with root package name */
    public Paint f1991c;

    /* renamed from: d reason: collision with root package name */
    public int f1992d;

    /* renamed from: e reason: collision with root package name */
    public RectF f1993e;

    /* renamed from: f reason: collision with root package name */
    public int f1994f;

    /* renamed from: g reason: collision with root package name */
    public int f1995g;

    /* renamed from: h reason: collision with root package name */
    public int f1996h;

    /* renamed from: i reason: collision with root package name */
    public float f1997i;

    /* renamed from: j reason: collision with root package name */
    public int f1998j;
    public String k;
    public Paint l;
    public Style m;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public void a(int i2, String str) {
        this.f1998j = i2;
        this.k = str;
        postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1991c.setColor(this.f1994f);
        int i2 = this.f1998j;
        if (i2 < 360) {
            canvas.drawArc(this.f1993e, (float) (i2 + HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE), (float) (360 - i2), this.m == Style.FILL, this.f1991c);
        }
        this.f1991c.setColor(this.f1995g);
        canvas.drawArc(this.f1993e, 270.0f, (float) this.f1998j, this.m == Style.FILL, this.f1991c);
        this.l.getFontMetrics();
        canvas.drawText(this.k, (((float) this.f1990b) / 2.0f) - (this.l.measureText(this.k) / 2.0f), (((float) this.f1989a) / 2.0f) - ((this.l.descent() + this.l.ascent()) / 2.0f), this.l);
    }

    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        this.f1989a = MeasureSpec.getSize(i3);
        int size = MeasureSpec.getSize(i2);
        this.f1990b = size;
        int i4 = this.f1989a;
        if (i4 > size) {
            int i5 = this.f1992d;
            float f2 = (float) i5;
            int i6 = this.f1989a;
            int i7 = i6 / 2;
            int i8 = this.f1990b;
            this.f1993e = new RectF(f2, ((float) (i7 - (i8 / 2))) + ((float) i5), (float) (i8 - i5), ((float) ((i8 / 2) + (i6 / 2))) - ((float) i5));
        } else if (size > i4) {
            int i9 = this.f1990b;
            int i10 = i9 / 2;
            int i11 = this.f1989a;
            float f3 = (float) (i10 - (i11 / 2));
            int i12 = this.f1992d;
            this.f1993e = new RectF(f3 + ((float) i12), (float) i12, ((float) ((i11 / 2) + (i9 / 2))) - ((float) i12), (float) (i11 - i12));
        } else {
            int i13 = this.f1992d;
            this.f1993e = new RectF((float) i13, (float) i13, (float) (this.f1990b - i13), (float) (this.f1989a - i13));
        }
        super.onMeasure(i2, i3);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
        String str;
        super(context, attributeSet, i2);
        this.f1992d = 5;
        this.f1994f = Color.parseColor("#A5A5A5");
        this.f1995g = Color.parseColor("#FA9025");
        this.f1996h = this.f1994f;
        this.f1997i = 20.0f;
        this.f1998j = 0;
        this.k = "100%";
        this.l = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.CircleProgressBar);
        this.f1997i = obtainStyledAttributes.getDimension(7, this.f1997i);
        this.f1996h = obtainStyledAttributes.getColor(6, this.f1996h);
        if (obtainStyledAttributes.getString(5) == null) {
            str = this.k;
        } else {
            str = obtainStyledAttributes.getString(5);
        }
        this.k = str;
        this.f1992d = obtainStyledAttributes.getDimensionPixelSize(4, this.f1992d);
        this.f1994f = obtainStyledAttributes.getColor(0, this.f1994f);
        this.f1995g = obtainStyledAttributes.getColor(2, this.f1995g);
        this.f1998j = obtainStyledAttributes.getInt(1, this.f1998j);
        this.m = obtainStyledAttributes.getInt(3, 0) == 0 ? Style.STROKE : Style.FILL;
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f1991c = paint;
        paint.setColor(this.f1994f);
        this.f1991c.setAntiAlias(true);
        this.f1991c.setStyle(this.m);
        this.f1991c.setStrokeWidth((float) this.f1992d);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setTextSize(this.f1997i);
        this.l.setAntiAlias(true);
        this.l.setColor(this.f1996h);
    }
}
