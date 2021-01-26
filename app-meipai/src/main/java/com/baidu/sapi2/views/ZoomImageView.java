package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@TargetApi(8)
public class ZoomImageView extends ImageView implements OnScaleGestureListener, OnTouchListener, OnGlobalLayoutListener {

    /* renamed from: a reason: collision with root package name */
    public static final float f3188a = 12.0f;

    /* renamed from: b reason: collision with root package name */
    public static ZoomImageView f3189b;

    /* renamed from: c reason: collision with root package name */
    public float f3190c;

    /* renamed from: d reason: collision with root package name */
    public final float[] f3191d;

    /* renamed from: e reason: collision with root package name */
    public boolean f3192e;

    /* renamed from: f reason: collision with root package name */
    public ScaleGestureDetector f3193f;

    /* renamed from: g reason: collision with root package name */
    public final Matrix f3194g;

    /* renamed from: h reason: collision with root package name */
    public int f3195h;

    /* renamed from: i reason: collision with root package name */
    public float f3196i;

    /* renamed from: j reason: collision with root package name */
    public float f3197j;
    public boolean k;
    public double l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public static void a() {
        f3189b = null;
    }

    private void c() {
        Rect rect;
        RectF matrixRectF = getMatrixRectF();
        ClipBoxView instance = ClipBoxView.getInstance();
        if (instance != null) {
            rect = instance.getmFrameRectF();
        } else {
            rect = new Rect();
        }
        getWidth();
        getHeight();
        float f2 = matrixRectF.top;
        float f3 = (float) rect.top;
        float f4 = 0.0f;
        float f5 = (f2 <= f3 || !this.n) ? 0.0f : -(f2 - f3);
        float f6 = matrixRectF.bottom;
        float f7 = (float) rect.bottom;
        if (f6 < f7 && this.n) {
            f5 = f7 - f6;
        }
        float f8 = matrixRectF.left;
        float f9 = (float) rect.left;
        if (f8 > f9 && this.m) {
            f4 = -(f8 - f9);
        }
        float f10 = matrixRectF.right;
        float f11 = (float) rect.right;
        if (f10 < f11 && this.m) {
            f4 = f11 - f10;
        }
        this.f3194g.postTranslate(f4, f5);
    }

    public static ZoomImageView getInstance() {
        ZoomImageView zoomImageView = f3189b;
        if (zoomImageView != null) {
            return zoomImageView;
        }
        return null;
    }

    public Bitmap b() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        if (ClipBoxView.getInstance() == null) {
            return null;
        }
        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
        return Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
    }

    public RectF getMatrixRectF() {
        Matrix matrix = this.f3194g;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public final float getScale() {
        this.f3194g.getValues(this.f3191d);
        return this.f3191d[0];
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    public void onGlobalLayout() {
        float f2;
        float height;
        float f3;
        if (this.f3192e) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                this.o = (int) TypedValue.applyDimension(1, (float) this.o, getResources().getDisplayMetrics());
                this.p = (getHeight() - (getWidth() - (this.o * 2))) / 2;
                int width = getWidth();
                int height2 = getHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth < getWidth() - (this.o * 2) && intrinsicHeight > getHeight() - (this.p * 2)) {
                    height = (((float) getWidth()) * 1.0f) - ((float) (this.o * 2));
                    f3 = (float) intrinsicWidth;
                } else if (intrinsicHeight >= getHeight() - (this.p * 2) || intrinsicWidth <= getWidth() - (this.o * 2)) {
                    f2 = Math.max(((((float) getWidth()) * 1.0f) - ((float) (this.o * 2))) / ((float) intrinsicWidth), ((((float) getHeight()) * 1.0f) - ((float) (this.p * 2))) / ((float) intrinsicHeight));
                    this.f3190c = f2;
                    this.f3194g.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height2 - intrinsicHeight) / 2));
                    this.f3194g.postScale(f2, f2, (float) (width / 2), (float) (height2 / 2));
                    setImageMatrix(this.f3194g);
                    this.f3192e = false;
                } else {
                    height = (((float) getHeight()) * 1.0f) - ((float) (this.p * 2));
                    f3 = (float) intrinsicHeight;
                }
                f2 = height / f3;
                this.f3190c = f2;
                this.f3194g.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height2 - intrinsicHeight) / 2));
                this.f3194g.postScale(f2, f2, (float) (width / 2), (float) (height2 / 2));
                setImageMatrix(this.f3194g);
                this.f3192e = false;
            }
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        if ((scale < 12.0f && scaleFactor > 1.0f) || scaleFactor < 1.0f) {
            if (scaleFactor * scale > 12.0f) {
                scaleFactor = 12.0f / scale;
            }
            this.f3194g.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            setImageMatrix(this.f3194g);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r11 != 3) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            android.view.ScaleGestureDetector r11 = r10.f3193f
            r11.onTouchEvent(r12)
            int r11 = r12.getPointerCount()
            r0 = 0
            r1 = 0
            r3 = r0
            r4 = r3
            r2 = r1
        L_0x000e:
            if (r2 >= r11) goto L_0x001d
            float r5 = r12.getX(r2)
            float r4 = r4 + r5
            float r5 = r12.getY(r2)
            float r3 = r3 + r5
            int r2 = r2 + 1
            goto L_0x000e
        L_0x001d:
            float r2 = (float) r11
            float r4 = r4 / r2
            float r3 = r3 / r2
            int r2 = r10.f3195h
            if (r11 == r2) goto L_0x002a
            r10.k = r1
            r10.f3196i = r4
            r10.f3197j = r3
        L_0x002a:
            r10.f3195h = r11
            int r11 = r12.getAction()
            r12 = 1
            if (r11 == r12) goto L_0x00b3
            r2 = 2
            if (r11 == r2) goto L_0x003b
            r0 = 3
            if (r11 == r0) goto L_0x00b3
            goto L_0x00b5
        L_0x003b:
            float r11 = r10.f3196i
            float r11 = r4 - r11
            float r2 = r10.f3197j
            float r2 = r3 - r2
            boolean r5 = r10.k
            if (r5 != 0) goto L_0x005c
            float r5 = r11 * r11
            float r6 = r2 * r2
            float r6 = r6 + r5
            double r5 = (double) r6
            double r5 = java.lang.Math.sqrt(r5)
            double r7 = r10.l
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0059
            r5 = r12
            goto L_0x005a
        L_0x0059:
            r5 = r1
        L_0x005a:
            r10.k = r5
        L_0x005c:
            boolean r5 = r10.k
            if (r5 == 0) goto L_0x00ae
            android.graphics.RectF r5 = r10.getMatrixRectF()
            android.graphics.drawable.Drawable r6 = r10.getDrawable()
            if (r6 == 0) goto L_0x00ae
            r10.m = r12
            r10.n = r12
            com.baidu.sapi2.views.ClipBoxView r6 = com.baidu.sapi2.views.ClipBoxView.getInstance()
            if (r6 == 0) goto L_0x0079
            android.graphics.Rect r6 = r6.getmFrameRectF()
            goto L_0x007e
        L_0x0079:
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
        L_0x007e:
            float r7 = r5.width()
            int r8 = r6.right
            int r9 = r6.left
            int r8 = r8 - r9
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x008f
            r10.m = r1
            r11 = r0
        L_0x008f:
            float r5 = r5.height()
            int r7 = r6.bottom
            int r6 = r6.top
            int r7 = r7 - r6
            float r6 = (float) r7
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a0
            r10.n = r1
            goto L_0x00a1
        L_0x00a0:
            r0 = r2
        L_0x00a1:
            android.graphics.Matrix r1 = r10.f3194g
            r1.postTranslate(r11, r0)
            r10.c()
            android.graphics.Matrix r11 = r10.f3194g
            r10.setImageMatrix(r11)
        L_0x00ae:
            r10.f3196i = r4
            r10.f3197j = r3
            goto L_0x00b5
        L_0x00b3:
            r10.f3195h = r1
        L_0x00b5:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ZoomImageView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3190c = 1.0f;
        this.f3191d = new float[9];
        this.f3192e = true;
        this.f3194g = new Matrix();
        this.f3195h = 0;
        this.f3196i = 0.0f;
        this.f3197j = 0.0f;
        this.o = 22;
        super.setScaleType(ScaleType.MATRIX);
        this.f3193f = new ScaleGestureDetector(context, this);
        this.l = (double) ViewConfiguration.get(context).getScaledTouchSlop();
        setOnTouchListener(this);
        if (f3189b == null) {
            f3189b = this;
        }
    }

    public void a(float f2, float f3) {
        Rect rect;
        float f4;
        RectF matrixRectF = getMatrixRectF();
        ClipBoxView instance = ClipBoxView.getInstance();
        if (instance != null) {
            rect = instance.getmFrameRectF();
        } else {
            rect = new Rect();
        }
        int i2 = rect.bottom - rect.top;
        float f5 = (float) (rect.right - rect.left);
        float f6 = 0.0f;
        if (matrixRectF.width() >= f5) {
            float f7 = matrixRectF.left;
            float f8 = (float) rect.left;
            f4 = f7 > f8 ? -(f7 - f8) : 0.0f;
            float f9 = matrixRectF.right;
            float f10 = (float) rect.right;
            if (f9 < f10) {
                f4 = f10 - f9;
            }
        } else {
            f4 = 0.0f;
        }
        float f11 = (float) i2;
        if (matrixRectF.height() >= f11) {
            float f12 = matrixRectF.top;
            float f13 = (float) rect.top;
            if (f12 > f13) {
                f6 = -(f12 - f13);
            }
            float f14 = matrixRectF.bottom;
            float f15 = (float) rect.bottom;
            if (f14 < f15) {
                f6 = f15 - f14;
            }
        }
        this.f3194g.postTranslate(f4, f6);
        if (matrixRectF.width() < f5 || matrixRectF.height() < f11) {
            float max = Math.max(f5 / matrixRectF.width(), f11 / matrixRectF.height());
            this.f3194g.postScale(max, max, f2, f3);
        }
    }
}
