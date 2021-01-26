package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.baidu.sapi2.utils.SapiUtils;

public class ClipBoxView extends View {

    /* renamed from: a reason: collision with root package name */
    public static int f3133a = 0;

    /* renamed from: b reason: collision with root package name */
    public static int f3134b = 1;

    /* renamed from: c reason: collision with root package name */
    public static final int f3135c = 1;

    /* renamed from: d reason: collision with root package name */
    public static final int f3136d = 20;

    /* renamed from: e reason: collision with root package name */
    public static final int f3137e = 4;

    /* renamed from: f reason: collision with root package name */
    public static final int f3138f = -1;

    /* renamed from: g reason: collision with root package name */
    public static final int f3139g = 1;

    /* renamed from: h reason: collision with root package name */
    public static final int f3140h = 2;

    /* renamed from: i reason: collision with root package name */
    public static final int f3141i = 3;

    /* renamed from: j reason: collision with root package name */
    public static final int f3142j = 4;
    public static final int k = 5;
    public static final int l = 6;
    public static final int m = 7;
    public static final int n = 8;
    public static final float o = 50.0f;
    public static final float p = 50.0f;
    public static final float q = 1.01f;
    public static final float r = 0.99f;
    public static ClipBoxView s;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public float G;
    public ValueAnimator H;
    public float I;
    public float J;
    public float K;
    public float L;
    public boolean M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public boolean W;
    public int aa;
    public boolean ba;
    public Paint t;
    public Paint u;
    public int v;
    public int w;
    public RectF x;
    public RectF y;
    public float z;

    public ClipBoxView(Context context) {
        this(context, null);
    }

    private boolean b(MotionEvent motionEvent) {
        switch (this.E) {
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF = this.x;
                b(x2, y2, rectF.right, rectF.bottom);
                break;
            case 2:
                b(this.x.left, motionEvent.getY(), motionEvent.getX(), this.x.bottom);
                break;
            case 3:
                float x3 = motionEvent.getX();
                RectF rectF2 = this.x;
                b(x3, rectF2.top, rectF2.right, motionEvent.getY());
                break;
            case 4:
                RectF rectF3 = this.x;
                b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                float f2 = this.x.left;
                float y3 = motionEvent.getY();
                RectF rectF4 = this.x;
                b(f2, y3, rectF4.right, rectF4.bottom);
                break;
            case 6:
                float x4 = motionEvent.getX();
                RectF rectF5 = this.x;
                b(x4, rectF5.top, rectF5.right, rectF5.bottom);
                break;
            case 7:
                RectF rectF6 = this.x;
                b(rectF6.left, rectF6.top, motionEvent.getX(), this.x.bottom);
                break;
            case 8:
                RectF rectF7 = this.x;
                b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean c(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        int i2 = this.E;
        if (i2 == 1) {
            float x2 = motionEvent.getX() - this.x.left;
            float y2 = motionEvent.getY();
            RectF rectF = this.x;
            float f2 = rectF.top;
            float f3 = ((y2 - f2) + x2) / 2.0f;
            b(rectF.left + f3, f2 + f3, rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            float x3 = this.x.right - motionEvent.getX();
            float y3 = motionEvent.getY();
            RectF rectF2 = this.x;
            float f4 = rectF2.top;
            float f5 = ((y3 - f4) + x3) / 2.0f;
            b(rectF2.left, f4 + f5, rectF2.right - f5, rectF2.bottom);
        } else if (i2 == 3) {
            float x4 = motionEvent.getX();
            RectF rectF3 = this.x;
            float y4 = ((rectF3.bottom - motionEvent.getY()) + (x4 - rectF3.left)) / 2.0f;
            RectF rectF4 = this.x;
            b(rectF4.left + y4, rectF4.top, rectF4.right, rectF4.bottom - y4);
        } else if (i2 != 4) {
            return false;
        } else {
            float y5 = ((this.x.bottom - motionEvent.getY()) + (this.x.right - motionEvent.getX())) / 2.0f;
            RectF rectF5 = this.x;
            b(rectF5.left, rectF5.top, rectF5.right - y5, rectF5.bottom - y5);
        }
        return true;
    }

    @TargetApi(11)
    private void d() {
        setLayerType(1, null);
        this.t = new Paint();
        this.u = new Paint();
        this.t.setColor(-1);
        this.t.setStyle(Style.STROKE);
        this.t.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
        this.t.setAntiAlias(true);
        this.u.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.u.setAntiAlias(true);
        this.v = SapiUtils.dip2px(getContext(), 20.0f);
        this.w = SapiUtils.dip2px(getContext(), 4.0f);
        this.B = SapiUtils.dip2px(getContext(), (float) this.B);
        this.D = SapiUtils.dip2px(getContext(), (float) this.D);
        this.F = SapiUtils.dip2px(getContext(), (float) this.F);
        this.x = new RectF();
        this.y = new RectF();
        this.aa = f3134b;
        this.ba = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.H = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.H.addUpdateListener(new a(this));
    }

    public static ClipBoxView getInstance() {
        ClipBoxView clipBoxView = s;
        if (clipBoxView != null) {
            return clipBoxView;
        }
        return null;
    }

    public Rect getmFrameRectF() {
        Rect rect = new Rect();
        RectF rectF = this.x;
        rect.left = (int) rectF.left;
        rect.right = (int) rectF.right;
        rect.top = (int) rectF.top;
        rect.bottom = (int) rectF.bottom;
        return rect;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int argb = Color.argb(HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT, 0, 0, 0);
        this.t.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
        canvas.drawColor(argb);
        b(canvas);
        if (this.G == 1.0f) {
            this.M = false;
            this.W = false;
            this.G = 0.0f;
        }
        canvas.drawRect(this.x, this.u);
        if (this.W) {
            a(canvas);
        }
        c(canvas);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.B;
        int i7 = i2 - (i6 * 2);
        int i8 = (i3 - i7) / 2;
        this.C = i8;
        RectF rectF = this.x;
        float f2 = (float) i6;
        rectF.left = f2;
        float f3 = (float) i8;
        rectF.top = f3;
        float f4 = (float) i7;
        rectF.right = f2 + f4;
        rectF.bottom = f3 + f4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            int r0 = r11.getAction()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r5) goto L_0x0022
            if (r0 == r3) goto L_0x0012
            if (r0 == r2) goto L_0x0022
            goto L_0x0038
        L_0x0012:
            int r0 = r10.aa
            int r1 = f3133a
            if (r0 != r1) goto L_0x001d
            boolean r11 = r10.b(r11)
            return r11
        L_0x001d:
            boolean r11 = r10.c(r11)
            return r11
        L_0x0022:
            int r11 = r10.E
            if (r11 < r5) goto L_0x0030
            if (r11 > r1) goto L_0x0030
            boolean r11 = r10.ba
            if (r11 == 0) goto L_0x0030
            r10.b()
            goto L_0x0035
        L_0x0030:
            r10.W = r4
            r10.invalidate()
        L_0x0035:
            r11 = -1
            r10.E = r11
        L_0x0038:
            return r4
        L_0x0039:
            r10.W = r5
            android.graphics.RectF r0 = r10.y
            float r6 = r11.getX()
            int r7 = r10.v
            float r7 = (float) r7
            float r6 = r6 - r7
            float r7 = r11.getY()
            int r8 = r10.v
            float r8 = (float) r8
            float r7 = r7 - r8
            float r8 = r11.getX()
            int r9 = r10.v
            float r9 = (float) r9
            float r8 = r8 + r9
            float r11 = r11.getY()
            int r9 = r10.v
            float r9 = (float) r9
            float r11 = r11 + r9
            r0.set(r6, r7, r8, r11)
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r6 = r0.left
            float r0 = r0.top
            boolean r11 = r11.contains(r6, r0)
            if (r11 == 0) goto L_0x0071
            r10.E = r5
            return r5
        L_0x0071:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r6 = r0.right
            float r0 = r0.top
            boolean r11 = r11.contains(r6, r0)
            if (r11 == 0) goto L_0x0082
            r10.E = r3
            return r5
        L_0x0082:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r3 = r0.left
            float r0 = r0.bottom
            boolean r11 = r11.contains(r3, r0)
            if (r11 == 0) goto L_0x0093
            r10.E = r2
            return r5
        L_0x0093:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r2 = r0.right
            float r0 = r0.bottom
            boolean r11 = r11.contains(r2, r0)
            if (r11 == 0) goto L_0x00a4
            r10.E = r1
            return r5
        L_0x00a4:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r1 = r0.left
            float r2 = r0.top
            float r0 = r0.right
            boolean r11 = r11.intersect(r1, r2, r0, r2)
            if (r11 == 0) goto L_0x00b8
            r11 = 5
            r10.E = r11
            return r5
        L_0x00b8:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r1 = r0.left
            float r2 = r0.top
            float r0 = r0.bottom
            boolean r11 = r11.intersect(r1, r2, r1, r0)
            if (r11 == 0) goto L_0x00cc
            r11 = 6
            r10.E = r11
            return r5
        L_0x00cc:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r1 = r0.right
            float r2 = r0.top
            float r0 = r0.bottom
            boolean r11 = r11.intersect(r1, r2, r1, r0)
            if (r11 == 0) goto L_0x00e0
            r11 = 7
            r10.E = r11
            return r5
        L_0x00e0:
            android.graphics.RectF r11 = r10.y
            android.graphics.RectF r0 = r10.x
            float r1 = r0.left
            float r2 = r0.bottom
            float r0 = r0.right
            boolean r11 = r11.intersect(r1, r2, r0, r2)
            if (r11 == 0) goto L_0x00f5
            r11 = 8
            r10.E = r11
            return r5
        L_0x00f5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ClipBoxView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipBoxView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = 22;
        this.D = 2;
        this.E = -1;
        this.F = 20;
        this.G = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = false;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.W = false;
        if (s == null) {
            s = this;
        }
        d();
    }

    public static void a() {
        s = null;
    }

    public void a(Canvas canvas) {
        RectF rectF = this.x;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        float f6 = (f5 - f3) / 3.0f;
        float f7 = f3 + f6;
        Canvas canvas2 = canvas;
        float f8 = f2;
        float f9 = f4;
        canvas2.drawLine(f8, f7, f9, f7, this.t);
        float f10 = (f6 * 2.0f) + f3;
        canvas2.drawLine(f8, f10, f9, f10, this.t);
        float f11 = (f4 - f2) / 3.0f;
        float f12 = f2 + f11;
        float f13 = f3;
        float f14 = f5;
        canvas2.drawLine(f12, f13, f12, f14, this.t);
        float f15 = (f11 * 2.0f) + f2;
        canvas2.drawLine(f15, f13, f15, f14, this.t);
    }

    private void b(float f2, float f3, float f4, float f5) {
        if (f5 - f3 < 50.0f) {
            RectF rectF = this.x;
            float f6 = rectF.top;
            f5 = rectF.bottom;
            f3 = f6;
        }
        if (f4 - f2 < 50.0f) {
            RectF rectF2 = this.x;
            float f7 = rectF2.left;
            f4 = rectF2.right;
            f2 = f7;
        }
        a(f2, f3, f4, f5);
        invalidate();
    }

    private void a(float f2, float f3, float f4, float f5) {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (instance != null) {
            RectF matrixRectF = instance.getMatrixRectF();
            f2 = Math.max(Math.max((float) this.F, f2), matrixRectF.left);
            f3 = Math.max(Math.max((float) this.F, f3), matrixRectF.top);
            f4 = Math.min(Math.min((float) (getWidth() - this.F), f4), matrixRectF.right);
            f5 = Math.min(Math.min((float) (getHeight() - this.F), f5), matrixRectF.bottom);
        }
        this.J = this.N - f3;
        this.L = f5 - this.O;
        this.I = this.P - f2;
        this.K = f4 - this.Q;
        this.x.set(f2, f3, f4, f5);
    }

    private void c(Canvas canvas) {
        this.t.setStrokeWidth((float) this.w);
        RectF rectF = this.x;
        float f2 = rectF.left;
        float f3 = f2 - ((float) this.D);
        float f4 = rectF.top;
        canvas.drawLine(f3, f4, f2 + ((float) this.v), f4, this.t);
        RectF rectF2 = this.x;
        float f5 = rectF2.left;
        float f6 = rectF2.top;
        canvas.drawLine(f5, f6, f5, f6 + ((float) this.v), this.t);
        RectF rectF3 = this.x;
        float f7 = rectF3.right;
        float f8 = f7 + ((float) this.D);
        float f9 = rectF3.top;
        canvas.drawLine(f8, f9, f7 - ((float) this.v), f9, this.t);
        RectF rectF4 = this.x;
        float f10 = rectF4.right;
        float f11 = rectF4.top;
        canvas.drawLine(f10, f11, f10, f11 + ((float) this.v), this.t);
        RectF rectF5 = this.x;
        float f12 = rectF5.left;
        float f13 = f12 - ((float) this.D);
        float f14 = rectF5.bottom;
        canvas.drawLine(f13, f14, f12 + ((float) this.v), f14, this.t);
        RectF rectF6 = this.x;
        float f15 = rectF6.left;
        float f16 = rectF6.bottom;
        canvas.drawLine(f15, f16, f15, f16 - ((float) this.v), this.t);
        RectF rectF7 = this.x;
        float f17 = rectF7.right;
        float f18 = f17 + ((float) this.D);
        float f19 = rectF7.bottom;
        canvas.drawLine(f18, f19, f17 - ((float) this.v), f19, this.t);
        RectF rectF8 = this.x;
        float f20 = rectF8.right;
        float f21 = rectF8.bottom;
        canvas.drawLine(f20, f21, f20, f21 - ((float) this.v), this.t);
    }

    private void b(Canvas canvas) {
        if (this.M) {
            RectF rectF = this.x;
            float f2 = this.P;
            float f3 = this.G;
            rectF.left = f2 - (this.I * f3);
            rectF.top = this.N - (this.J * f3);
            rectF.right = (this.K * f3) + this.Q;
            rectF.bottom = (f3 * this.L) + this.O;
            canvas.drawRect(rectF, this.t);
            return;
        }
        canvas.drawRect(this.x, this.t);
    }

    private void a(float f2, float f3, float f4, float f5, float f6) {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (instance != null) {
            RectF matrixRectF = instance.getMatrixRectF();
            f2 = Math.max(Math.max((float) this.F, f2), matrixRectF.left);
            f3 = Math.max(Math.max((float) this.F, f3), matrixRectF.top);
            f4 = Math.min(Math.min((float) (getWidth() - this.F), f4), matrixRectF.right);
            f5 = Math.min(Math.min((float) (getHeight() - this.F), f5), matrixRectF.bottom);
        }
        float f7 = f4 - f2;
        float f8 = f5 - f3;
        float f9 = f7 / f8;
        if (f9 > f6) {
            while (f9 / f6 > 1.01f) {
                f4 -= 1.0f;
                f2 += 1.0f;
                f9 = (f4 - f2) / f8;
            }
        } else {
            while (f9 / f6 < 0.99f) {
                f5 -= 1.0f;
                f3 += 1.0f;
                f9 = f7 / (f5 - f3);
            }
        }
        this.J = this.N - f3;
        this.L = f5 - this.O;
        this.I = this.P - f2;
        this.K = f4 - this.Q;
        this.x.set(f2, f3, f4, f5);
    }

    @TargetApi(11)
    private void b() {
        int width = getWidth() - (this.B * 2);
        RectF rectF = this.x;
        float f2 = rectF.right;
        float f3 = rectF.left;
        float f4 = f2 - f3;
        float f5 = (float) width;
        if (f4 < f5) {
            float f6 = rectF.top;
            this.N = f6;
            float f7 = rectF.bottom;
            this.O = f7;
            this.P = f3;
            this.Q = f2;
            float f8 = (f2 - f3) / (f7 - f6);
            this.S = f5 / f4;
            float height = (float) (getHeight() - (this.F * 2));
            RectF rectF2 = this.x;
            float f9 = height / (rectF2.bottom - rectF2.top);
            this.T = f9;
            float min = Math.min(this.S, f9);
            this.R = min;
            float f10 = 1.0f;
            float f11 = min - 1.0f;
            if (f11 <= 1.0f) {
                f10 = f11;
            }
            float width2 = (float) (getWidth() / 2);
            RectF rectF3 = this.x;
            this.U = (width2 - ((rectF3.left + rectF3.right) / 2.0f)) * f10;
            float height2 = (float) (getHeight() / 2);
            RectF rectF4 = this.x;
            float f12 = rectF4.top;
            float f13 = rectF4.bottom;
            this.V = (height2 - ((f12 + f13) / 2.0f)) * f10;
            float f14 = rectF4.left;
            float f15 = this.R;
            float f16 = f14 / f15;
            rectF4.left = f16;
            float f17 = f12 / f15;
            rectF4.top = f17;
            float f18 = rectF4.right * f15;
            rectF4.right = f18;
            float f19 = f13 * f15;
            rectF4.bottom = f19;
            if (this.aa == f3133a) {
                a(f16, f17, f18, f19, f8);
            } else {
                int i2 = this.B;
                float f20 = (float) i2;
                int i3 = this.C;
                a(f20, (float) i3, (float) (i2 + width), (float) (i3 + width));
            }
            this.H.setDuration(500).start();
            this.M = true;
            return;
        }
        this.W = false;
        invalidate();
    }

    /* access modifiers changed from: private */
    public void c() {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (this.M && instance != null && instance.getScale() <= 12.0f) {
            float f2 = ((this.R - 1.0f) / 20.0f) + 1.0f;
            instance.f3194g.postTranslate(this.U / 20.0f, this.V / 20.0f);
            Matrix matrix = instance.f3194g;
            RectF rectF = this.x;
            matrix.postScale(f2, f2, (rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f);
            RectF rectF2 = this.x;
            instance.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
            instance.setImageMatrix(instance.f3194g);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int width = getWidth() - (this.B * 2);
        RectF rectF = this.x;
        float f2 = (float) width;
        return rectF.right - rectF.left >= f2 && rectF.bottom - rectF.top >= f2 && (motionEvent.getX() < ((float) this.B) || motionEvent.getX() > ((float) (this.B + width)) || motionEvent.getY() < ((float) this.C) || motionEvent.getY() > ((float) (this.C + width)));
    }
}
