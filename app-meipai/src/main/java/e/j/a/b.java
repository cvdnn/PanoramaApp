package e.j.a;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

/* compiled from: RoundedDrawable */
public class b extends Drawable {

    /* renamed from: a reason: collision with root package name */
    public final RectF f8902a = new RectF();

    /* renamed from: b reason: collision with root package name */
    public final RectF f8903b = new RectF();

    /* renamed from: c reason: collision with root package name */
    public final RectF f8904c = new RectF();

    /* renamed from: d reason: collision with root package name */
    public final Bitmap f8905d;

    /* renamed from: e reason: collision with root package name */
    public final Paint f8906e;

    /* renamed from: f reason: collision with root package name */
    public final int f8907f;

    /* renamed from: g reason: collision with root package name */
    public final int f8908g;

    /* renamed from: h reason: collision with root package name */
    public final RectF f8909h = new RectF();

    /* renamed from: i reason: collision with root package name */
    public final Paint f8910i;

    /* renamed from: j reason: collision with root package name */
    public final Matrix f8911j = new Matrix();
    public final RectF k = new RectF();
    public TileMode l;
    public TileMode m;
    public boolean n;
    public float o;
    public final boolean[] p;
    public boolean q;
    public float r;
    public ColorStateList s;
    public ScaleType t;

    /* compiled from: RoundedDrawable */
    public static /* synthetic */ class a {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f8912a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8912a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8912a     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.a.<clinit>():void");
        }
    }

    public b(Bitmap bitmap) {
        TileMode tileMode = TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ScaleType.FIT_CENTER;
        this.f8905d = bitmap;
        this.f8907f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f8908g = height;
        this.f8904c.set(0.0f, 0.0f, (float) this.f8907f, (float) height);
        Paint paint = new Paint();
        this.f8906e = paint;
        paint.setStyle(Style.FILL);
        this.f8906e.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f8910i = paint2;
        paint2.setStyle(Style.STROKE);
        this.f8910i.setAntiAlias(true);
        this.f8910i.setColor(this.s.getColorForState(getState(), -16777216));
        this.f8910i.setStrokeWidth(this.r);
    }

    public static b a(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public void draw(Canvas canvas) {
        boolean z;
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.f8905d, this.l, this.m);
            TileMode tileMode = this.l;
            TileMode tileMode2 = TileMode.CLAMP;
            if (tileMode == tileMode2 && this.m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f8911j);
            }
            this.f8906e.setShader(bitmapShader);
            this.n = false;
        }
        if (!this.q) {
            boolean[] zArr = this.p;
            int length = zArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (zArr[i2]) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                float f2 = this.o;
                if (this.r > 0.0f) {
                    canvas.drawRoundRect(this.f8903b, f2, f2, this.f8906e);
                    canvas.drawRoundRect(this.f8909h, f2, f2, this.f8910i);
                    a(canvas);
                    if (!a(this.p) && this.o != 0.0f) {
                        RectF rectF = this.f8903b;
                        float f3 = rectF.left;
                        float f4 = rectF.top;
                        float width = rectF.width() + f3;
                        float height = this.f8903b.height() + f4;
                        float f5 = this.o;
                        float f6 = this.r / 2.0f;
                        if (!this.p[0]) {
                            Canvas canvas2 = canvas;
                            canvas2.drawLine(f3 - f6, f4, f3 + f5, f4, this.f8910i);
                            canvas2.drawLine(f3, f4 - f6, f3, f4 + f5, this.f8910i);
                        }
                        if (!this.p[1]) {
                            Canvas canvas3 = canvas;
                            float f7 = width;
                            canvas3.drawLine((width - f5) - f6, f4, f7, f4, this.f8910i);
                            canvas3.drawLine(width, f4 - f6, f7, f4 + f5, this.f8910i);
                        }
                        if (!this.p[2]) {
                            Canvas canvas4 = canvas;
                            float f8 = height;
                            canvas4.drawLine((width - f5) - f6, height, width + f6, f8, this.f8910i);
                            canvas4.drawLine(width, height - f5, width, f8, this.f8910i);
                        }
                        if (!this.p[3]) {
                            Canvas canvas5 = canvas;
                            float f9 = height;
                            canvas5.drawLine(f3 - f6, height, f3 + f5, f9, this.f8910i);
                            canvas5.drawLine(f3, height - f5, f3, f9, this.f8910i);
                            return;
                        }
                        return;
                    }
                    return;
                }
                canvas.drawRoundRect(this.f8903b, f2, f2, this.f8906e);
                a(canvas);
                return;
            }
            canvas.drawRect(this.f8903b, this.f8906e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f8909h, this.f8910i);
            }
        } else if (this.r > 0.0f) {
            canvas.drawOval(this.f8903b, this.f8906e);
            canvas.drawOval(this.f8909h, this.f8910i);
        } else {
            canvas.drawOval(this.f8903b, this.f8906e);
        }
    }

    public int getAlpha() {
        return this.f8906e.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f8906e.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f8908g;
    }

    public int getIntrinsicWidth() {
        return this.f8907f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.s.isStateful();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f8902a.set(rect);
        a();
    }

    public boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f8910i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f8910i.setColor(colorForState);
        return true;
    }

    public void setAlpha(int i2) {
        this.f8906e.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f8906e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f8906e.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f8906e.setFilterBitmap(z);
        invalidateSelf();
    }

    public static Drawable a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable != null) {
            if (drawable instanceof b) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), a(layerDrawable.getDrawable(i2)));
                }
                return layerDrawable;
            }
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                try {
                    bitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
                    bitmap = null;
                }
            }
            if (bitmap != null) {
                drawable = new b(bitmap);
            }
        }
        return drawable;
    }

    public final void a() {
        float f2;
        float f3;
        float f4;
        int i2 = a.f8912a[this.t.ordinal()];
        if (i2 == 1) {
            this.f8909h.set(this.f8902a);
            RectF rectF = this.f8909h;
            float f5 = this.r;
            rectF.inset(f5 / 2.0f, f5 / 2.0f);
            this.f8911j.reset();
            this.f8911j.setTranslate((float) ((int) e.a.a.a.a.e(this.f8909h.width(), (float) this.f8907f, 0.5f, 0.5f)), (float) ((int) e.a.a.a.a.e(this.f8909h.height(), (float) this.f8908g, 0.5f, 0.5f)));
        } else if (i2 == 2) {
            this.f8909h.set(this.f8902a);
            RectF rectF2 = this.f8909h;
            float f6 = this.r;
            rectF2.inset(f6 / 2.0f, f6 / 2.0f);
            this.f8911j.reset();
            float f7 = 0.0f;
            if (this.f8909h.height() * ((float) this.f8907f) > this.f8909h.width() * ((float) this.f8908g)) {
                f3 = this.f8909h.height() / ((float) this.f8908g);
                float i3 = e.a.a.a.a.i((float) this.f8907f, f3, this.f8909h.width(), 0.5f);
                f2 = 0.0f;
                f7 = i3;
            } else {
                f3 = this.f8909h.width() / ((float) this.f8907f);
                f2 = e.a.a.a.a.i((float) this.f8908g, f3, this.f8909h.height(), 0.5f);
            }
            this.f8911j.setScale(f3, f3);
            Matrix matrix = this.f8911j;
            float f8 = (float) ((int) (f7 + 0.5f));
            float f9 = this.r;
            matrix.postTranslate((f9 / 2.0f) + f8, (f9 / 2.0f) + ((float) ((int) (f2 + 0.5f))));
        } else if (i2 == 3) {
            this.f8911j.reset();
            if (((float) this.f8907f) > this.f8902a.width() || ((float) this.f8908g) > this.f8902a.height()) {
                f4 = Math.min(this.f8902a.width() / ((float) this.f8907f), this.f8902a.height() / ((float) this.f8908g));
            } else {
                f4 = 1.0f;
            }
            float a2 = (float) ((int) e.a.a.a.a.a((float) this.f8907f, f4, this.f8902a.width(), 0.5f, 0.5f));
            float a3 = (float) ((int) e.a.a.a.a.a((float) this.f8908g, f4, this.f8902a.height(), 0.5f, 0.5f));
            this.f8911j.setScale(f4, f4);
            this.f8911j.postTranslate(a2, a3);
            this.f8909h.set(this.f8904c);
            this.f8911j.mapRect(this.f8909h);
            RectF rectF3 = this.f8909h;
            float f10 = this.r;
            rectF3.inset(f10 / 2.0f, f10 / 2.0f);
            this.f8911j.setRectToRect(this.f8904c, this.f8909h, ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f8909h.set(this.f8904c);
            this.f8911j.setRectToRect(this.f8904c, this.f8902a, ScaleToFit.END);
            this.f8911j.mapRect(this.f8909h);
            RectF rectF4 = this.f8909h;
            float f11 = this.r;
            rectF4.inset(f11 / 2.0f, f11 / 2.0f);
            this.f8911j.setRectToRect(this.f8904c, this.f8909h, ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f8909h.set(this.f8904c);
            this.f8911j.setRectToRect(this.f8904c, this.f8902a, ScaleToFit.START);
            this.f8911j.mapRect(this.f8909h);
            RectF rectF5 = this.f8909h;
            float f12 = this.r;
            rectF5.inset(f12 / 2.0f, f12 / 2.0f);
            this.f8911j.setRectToRect(this.f8904c, this.f8909h, ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f8909h.set(this.f8904c);
            this.f8911j.setRectToRect(this.f8904c, this.f8902a, ScaleToFit.CENTER);
            this.f8911j.mapRect(this.f8909h);
            RectF rectF6 = this.f8909h;
            float f13 = this.r;
            rectF6.inset(f13 / 2.0f, f13 / 2.0f);
            this.f8911j.setRectToRect(this.f8904c, this.f8909h, ScaleToFit.FILL);
        } else {
            this.f8909h.set(this.f8902a);
            RectF rectF7 = this.f8909h;
            float f14 = this.r;
            rectF7.inset(f14 / 2.0f, f14 / 2.0f);
            this.f8911j.reset();
            this.f8911j.setRectToRect(this.f8904c, this.f8909h, ScaleToFit.FILL);
        }
        this.f8903b.set(this.f8909h);
    }

    public final void a(Canvas canvas) {
        if (!a(this.p) && this.o != 0.0f) {
            RectF rectF = this.f8903b;
            float f2 = rectF.left;
            float f3 = rectF.top;
            float width = rectF.width() + f2;
            float height = this.f8903b.height() + f3;
            float f4 = this.o;
            if (!this.p[0]) {
                this.k.set(f2, f3, f2 + f4, f3 + f4);
                canvas.drawRect(this.k, this.f8906e);
            }
            if (!this.p[1]) {
                this.k.set(width - f4, f3, width, f4);
                canvas.drawRect(this.k, this.f8906e);
            }
            if (!this.p[2]) {
                this.k.set(width - f4, height - f4, width, height);
                canvas.drawRect(this.k, this.f8906e);
            }
            if (!this.p[3]) {
                this.k.set(f2, height - f4, f4 + f2, height);
                canvas.drawRect(this.k, this.f8906e);
            }
        }
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
