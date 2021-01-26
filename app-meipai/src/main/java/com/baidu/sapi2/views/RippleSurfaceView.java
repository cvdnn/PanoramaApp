package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.animation.LinearInterpolator;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;

public class RippleSurfaceView extends SurfaceView implements Callback, Runnable {

    /* renamed from: a reason: collision with root package name */
    public SurfaceHolder f3153a;

    /* renamed from: b reason: collision with root package name */
    public Canvas f3154b;

    /* renamed from: c reason: collision with root package name */
    public Paint f3155c;

    /* renamed from: d reason: collision with root package name */
    public boolean f3156d;

    /* renamed from: e reason: collision with root package name */
    public Path[] f3157e;

    /* renamed from: f reason: collision with root package name */
    public int f3158f;

    /* renamed from: g reason: collision with root package name */
    public int f3159g;

    /* renamed from: h reason: collision with root package name */
    public int f3160h;

    /* renamed from: i reason: collision with root package name */
    public int f3161i;

    /* renamed from: j reason: collision with root package name */
    public ValueAnimator f3162j;

    public RippleSurfaceView(Context context) {
        this(context, null);
    }

    @TargetApi(5)
    private void b() {
        SurfaceHolder holder = getHolder();
        this.f3153a = holder;
        holder.addCallback(this);
        setZOrderOnTop(true);
        this.f3153a.setFormat(-3);
        this.f3157e = new Path[]{new Path(), new Path(), new Path()};
        Paint paint = new Paint();
        this.f3155c = paint;
        paint.setAntiAlias(true);
        this.f3155c.setColor(Color.parseColor("#3388FF"));
        this.f3155c.setStyle(Style.STROKE);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    public void run() {
        while (this.f3156d) {
            int i2 = this.f3160h + 50;
            this.f3160h = i2;
            a(i2);
            a();
        }
    }

    @TargetApi(11)
    public void setAmplitude(int i2) {
        int i3 = 100;
        int i4 = i2 / 100;
        if (i4 < 5) {
            i4 = 5;
        }
        if (i4 <= 100) {
            i3 = i4;
        }
        ValueAnimator valueAnimator = this.f3162j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f3161i, i3});
            this.f3162j = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.f3162j.addUpdateListener(new g(this));
            this.f3162j.setDuration(500).start();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f3156d = true;
        new Thread(this).start();
    }

    @TargetApi(11)
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3156d = false;
        ValueAnimator valueAnimator = this.f3162j;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    public RippleSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void a(int i2) {
        char c2;
        int i3 = 0;
        this.f3157e[0] = new Path();
        int i4 = 1;
        this.f3157e[1] = new Path();
        this.f3157e[2] = new Path();
        int i5 = 0;
        while (i5 < 2000) {
            int i6 = this.f3158f + i4;
            this.f3158f = i6;
            double d2 = (double) i2;
            int sin = (int) ((Math.sin((((((double) i6) * 0.7d) * 3.141592653589793d) / 180.0d) + d2) * ((double) this.f3161i)) + 100.0d);
            this.f3159g = sin;
            int i7 = this.f3158f;
            if (i7 == i4) {
                this.f3157e[i3].moveTo((float) i7, (float) sin);
            }
            this.f3157e[i3].lineTo((float) this.f3158f, (float) this.f3159g);
            int sin2 = (int) ((Math.sin((d2 - 0.3d) + (((((double) this.f3158f) * 0.7d) * 3.141592653589793d) / 180.0d)) * ((double) (this.f3161i - 5))) + 100.0d);
            this.f3159g = sin2;
            int i8 = this.f3158f;
            if (i8 == 1) {
                this.f3157e[1].moveTo((float) i8, (float) sin2);
            }
            this.f3157e[1].lineTo((float) this.f3158f, (float) this.f3159g);
            int sin3 = (int) ((Math.sin((d2 - 0.6d) + (((((double) this.f3158f) * 0.7d) * 3.141592653589793d) / 180.0d)) * ((double) (this.f3161i - 10))) + 100.0d);
            this.f3159g = sin3;
            int i9 = this.f3158f;
            if (i9 == 1) {
                c2 = 2;
                this.f3157e[2].moveTo((float) i9, (float) sin3);
            } else {
                c2 = 2;
            }
            this.f3157e[c2].lineTo((float) this.f3158f, (float) this.f3159g);
            i5++;
            i4 = 1;
            char c3 = c2;
            i3 = 0;
        }
        this.f3158f = i3;
    }

    public RippleSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a() {
        Canvas canvas;
        try {
            Canvas lockCanvas = this.f3153a.lockCanvas();
            this.f3154b = lockCanvas;
            if (lockCanvas != null) {
                lockCanvas.drawColor(-1);
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 == 0) {
                        this.f3155c.setAlpha(255);
                        this.f3155c.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 2.0f));
                        this.f3154b.drawPath(this.f3157e[0], this.f3155c);
                    }
                    if (i2 == 1) {
                        this.f3155c.setAlpha(102);
                        this.f3155c.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
                        this.f3154b.drawPath(this.f3157e[1], this.f3155c);
                    }
                    if (i2 == 2) {
                        this.f3155c.setAlpha(102);
                        this.f3155c.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
                        this.f3154b.drawPath(this.f3157e[2], this.f3155c);
                    }
                }
            }
            canvas = this.f3154b;
            if (canvas == null) {
                return;
            }
        } catch (Exception e2) {
            Log.e(e2);
            canvas = this.f3154b;
            if (canvas == null) {
                return;
            }
        } catch (Throwable th) {
            Canvas canvas2 = this.f3154b;
            if (canvas2 != null) {
                this.f3153a.unlockCanvasAndPost(canvas2);
            }
            throw th;
        }
        this.f3153a.unlockCanvasAndPost(canvas);
    }
}
