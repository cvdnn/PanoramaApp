package e.c.d.m.i.j;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;

/* compiled from: PhotoViewAttacher */
public class l implements OnTouchListener, OnLayoutChangeListener {
    public static float G = 3.0f;
    public static float H = 1.75f;
    public static float I = 1.0f;
    public int A = 2;
    public int B = 2;
    public float C;
    public boolean D = true;
    public ScaleType E = ScaleType.FIT_CENTER;
    public b F = new a();

    /* renamed from: a reason: collision with root package name */
    public final Matrix f6846a = new Matrix();

    /* renamed from: b reason: collision with root package name */
    public final Matrix f6847b = new Matrix();

    /* renamed from: c reason: collision with root package name */
    public final Matrix f6848c = new Matrix();

    /* renamed from: d reason: collision with root package name */
    public final RectF f6849d = new RectF();

    /* renamed from: e reason: collision with root package name */
    public final float[] f6850e = new float[9];

    /* renamed from: f reason: collision with root package name */
    public Interpolator f6851f = new AccelerateDecelerateInterpolator();

    /* renamed from: g reason: collision with root package name */
    public int f6852g = 200;

    /* renamed from: h reason: collision with root package name */
    public float f6853h = I;

    /* renamed from: i reason: collision with root package name */
    public float f6854i = H;

    /* renamed from: j reason: collision with root package name */
    public float f6855j = G;
    public boolean k = true;
    public boolean l = false;
    public ImageView m;
    public GestureDetector n;
    public a o;
    public f p;
    public c q;
    public e r;
    public d s;
    public j t;
    public OnClickListener u;
    public OnLongClickListener v;
    public g w;
    public h x;
    public i y;
    public f z;

    /* compiled from: PhotoViewAttacher */
    public class a implements b {
        public a() {
        }

        public void a(float f2, float f3, float f4) {
            if (l.this.e() < l.this.f6855j || f2 < 1.0f) {
                g gVar = l.this.w;
                if (gVar != null) {
                    gVar.a(f2, f3, f4);
                }
                l.this.f6848c.postScale(f2, f2, f3, f4);
                l.this.a();
            }
        }
    }

    /* compiled from: PhotoViewAttacher */
    public class b extends SimpleOnGestureListener {
        public b() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            l lVar = l.this;
            if (lVar.x == null || lVar.e() > l.I || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            return l.this.x.onFling(motionEvent, motionEvent2, f2, f3);
        }

        public void onLongPress(MotionEvent motionEvent) {
            l lVar = l.this;
            OnLongClickListener onLongClickListener = lVar.v;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(lVar.m);
            }
        }
    }

    /* compiled from: PhotoViewAttacher */
    public class c implements OnDoubleTapListener {
        public c() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float e2 = l.this.e();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (e2 < l.this.f6854i) {
                    l.this.a(l.this.f6854i, x, y, true);
                } else if (e2 < l.this.f6854i || e2 >= l.this.f6855j) {
                    l.this.a(l.this.f6853h, x, y, true);
                } else {
                    l.this.a(l.this.f6855j, x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            l lVar = l.this;
            OnClickListener onClickListener = lVar.u;
            if (onClickListener != null) {
                onClickListener.onClick(lVar.m);
            }
            RectF c2 = l.this.c();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            l lVar2 = l.this;
            j jVar = lVar2.t;
            if (jVar != null) {
                jVar.a(lVar2.m, x, y);
            }
            if (c2 != null) {
                if (c2.contains(x, y)) {
                    float width = (x - c2.left) / c2.width();
                    float height = (y - c2.top) / c2.height();
                    l lVar3 = l.this;
                    e eVar = lVar3.r;
                    if (eVar != null) {
                        eVar.a(lVar3.m, width, height);
                    }
                    return true;
                }
                l lVar4 = l.this;
                d dVar = lVar4.s;
                if (dVar != null) {
                    dVar.a(lVar4.m);
                }
            }
            return false;
        }
    }

    /* compiled from: PhotoViewAttacher */
    public static /* synthetic */ class d {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f6859a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6859a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6859a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6859a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6859a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.d.m.i.j.l.d.<clinit>():void");
        }
    }

    /* compiled from: PhotoViewAttacher */
    public class e implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final float f6860a;

        /* renamed from: b reason: collision with root package name */
        public final float f6861b;

        /* renamed from: c reason: collision with root package name */
        public final long f6862c = System.currentTimeMillis();

        /* renamed from: d reason: collision with root package name */
        public final float f6863d;

        /* renamed from: e reason: collision with root package name */
        public final float f6864e;

        public e(float f2, float f3, float f4, float f5) {
            this.f6860a = f4;
            this.f6861b = f5;
            this.f6863d = f2;
            this.f6864e = f3;
        }

        public void run() {
            float interpolation = l.this.f6851f.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f6862c)) * 1.0f) / ((float) l.this.f6852g)));
            float f2 = this.f6863d;
            float e2 = e.a.a.a.a.e(this.f6864e, f2, interpolation, f2) / l.this.e();
            ((a) l.this.F).a(e2, this.f6860a, this.f6861b);
            if (interpolation < 1.0f) {
                l.this.m.postOnAnimation(this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher */
    public class f implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final OverScroller f6866a;

        /* renamed from: b reason: collision with root package name */
        public int f6867b;

        /* renamed from: c reason: collision with root package name */
        public int f6868c;

        public f(Context context) {
            this.f6866a = new OverScroller(context);
        }

        public void run() {
            if (!this.f6866a.isFinished() && this.f6866a.computeScrollOffset()) {
                int currX = this.f6866a.getCurrX();
                int currY = this.f6866a.getCurrY();
                l.this.f6848c.postTranslate((float) (this.f6867b - currX), (float) (this.f6868c - currY));
                l.this.a();
                this.f6867b = currX;
                this.f6868c = currY;
                l.this.m.postOnAnimation(this);
            }
        }
    }

    public l(ImageView imageView) {
        this.m = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.C = 0.0f;
            this.o = new a(imageView.getContext(), this.F);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
            this.n = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new c());
        }
    }

    public void a(float f2, boolean z2) {
        a(f2, (float) (this.m.getRight() >> 1), (float) (this.m.getBottom() >> 1), z2);
    }

    public final boolean b() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF a2 = a(d());
        if (a2 == null) {
            return false;
        }
        float height = a2.height();
        float width = a2.width();
        float a3 = (float) a(this.m);
        float f7 = 0.0f;
        if (height <= a3) {
            int i2 = d.f6859a[this.E.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (a3 - height) / 2.0f;
                    f6 = a2.top;
                } else {
                    f5 = a3 - height;
                    f6 = a2.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -a2.top;
            }
            this.B = 2;
        } else {
            float f8 = a2.top;
            if (f8 > 0.0f) {
                this.B = 0;
                f2 = -f8;
            } else {
                float f9 = a2.bottom;
                if (f9 < a3) {
                    this.B = 1;
                    f2 = a3 - f9;
                } else {
                    this.B = -1;
                    f2 = 0.0f;
                }
            }
        }
        float b2 = (float) b(this.m);
        if (width <= b2) {
            int i3 = d.f6859a[this.E.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (b2 - width) / 2.0f;
                    f4 = a2.left;
                } else {
                    f3 = b2 - width;
                    f4 = a2.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -a2.left;
            }
            this.A = 2;
        } else {
            float f10 = a2.left;
            if (f10 > 0.0f) {
                this.A = 0;
                f7 = -f10;
            } else {
                float f11 = a2.right;
                if (f11 < b2) {
                    f7 = b2 - f11;
                    this.A = 1;
                } else {
                    this.A = -1;
                }
            }
        }
        this.f6848c.postTranslate(f7, f2);
        return true;
    }

    public RectF c() {
        b();
        return a(d());
    }

    public final Matrix d() {
        this.f6847b.set(this.f6846a);
        this.f6847b.postConcat(this.f6848c);
        return this.f6847b;
    }

    public float e() {
        this.f6848c.getValues(this.f6850e);
        float pow = (float) Math.pow((double) this.f6850e[0], 2.0d);
        this.f6848c.getValues(this.f6850e);
        return (float) Math.sqrt((double) (pow + ((float) Math.pow((double) this.f6850e[3], 2.0d))));
    }

    public void f() {
        this.f6848c.reset();
        this.f6848c.postRotate(this.C % 360.0f);
        a();
        Matrix d2 = d();
        this.m.setImageMatrix(d2);
        if (this.q != null) {
            RectF a2 = a(d2);
            if (a2 != null) {
                this.q.a(a2);
            }
        }
        b();
    }

    public void g() {
        if (this.D) {
            a(this.m.getDrawable());
        } else {
            f();
        }
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            a(this.m.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            e.c.d.m.i.j.f r0 = r10.p
            if (r0 == 0) goto L_0x0007
            r0.onTouch(r11, r12)
        L_0x0007:
            boolean r0 = r10.D
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00d1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            if (r0 == 0) goto L_0x0018
            r0 = r2
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 == 0) goto L_0x00d1
            int r0 = r12.getAction()
            r3 = 0
            if (r0 == 0) goto L_0x007b
            if (r0 == r2) goto L_0x0028
            r3 = 3
            if (r0 == r3) goto L_0x0028
            goto L_0x008f
        L_0x0028:
            float r0 = r10.e()
            float r3 = r10.f6853h
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0051
            android.graphics.RectF r0 = r10.c()
            if (r0 == 0) goto L_0x008f
            e.c.d.m.i.j.l$e r9 = new e.c.d.m.i.j.l$e
            float r5 = r10.e()
            float r6 = r10.f6853h
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x0079
        L_0x0051:
            float r0 = r10.e()
            float r3 = r10.f6855j
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            android.graphics.RectF r0 = r10.c()
            if (r0 == 0) goto L_0x008f
            e.c.d.m.i.j.l$e r9 = new e.c.d.m.i.j.l$e
            float r5 = r10.e()
            float r6 = r10.f6855j
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L_0x0079:
            r11 = r2
            goto L_0x0090
        L_0x007b:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0084
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0084:
            e.c.d.m.i.j.l$f r11 = r10.z
            if (r11 == 0) goto L_0x008f
            android.widget.OverScroller r11 = r11.f6866a
            r11.forceFinished(r2)
            r10.z = r3
        L_0x008f:
            r11 = r1
        L_0x0090:
            e.c.d.m.i.j.a r0 = r10.o
            if (r0 == 0) goto L_0x00c5
            boolean r11 = r0.a()
            e.c.d.m.i.j.a r0 = r10.o
            boolean r3 = r0.f6839g
            android.view.ScaleGestureDetector r4 = r0.f6833a     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r4.onTouchEvent(r12)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r0.c(r12)     // Catch:{ IllegalArgumentException -> 0x00a4 }
        L_0x00a4:
            if (r11 != 0) goto L_0x00b0
            e.c.d.m.i.j.a r11 = r10.o
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x00b0
            r11 = r2
            goto L_0x00b1
        L_0x00b0:
            r11 = r1
        L_0x00b1:
            if (r3 != 0) goto L_0x00bb
            e.c.d.m.i.j.a r0 = r10.o
            boolean r0 = r0.f6839g
            if (r0 != 0) goto L_0x00bb
            r0 = r2
            goto L_0x00bc
        L_0x00bb:
            r0 = r1
        L_0x00bc:
            if (r11 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x00c1
            r1 = r2
        L_0x00c1:
            r10.l = r1
            r1 = r2
            goto L_0x00c6
        L_0x00c5:
            r1 = r11
        L_0x00c6:
            android.view.GestureDetector r11 = r10.n
            if (r11 == 0) goto L_0x00d1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00d1
            r1 = r2
        L_0x00d1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.m.i.j.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.f6853h || f2 > this.f6855j) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            ImageView imageView = this.m;
            e eVar = new e(e(), f2, f3, f4);
            imageView.post(eVar);
        } else {
            this.f6848c.setScale(f2, f2, f3, f4);
            a();
        }
    }

    public final void a() {
        if (b()) {
            Matrix d2 = d();
            this.m.setImageMatrix(d2);
            if (this.q != null) {
                RectF a2 = a(d2);
                if (a2 != null) {
                    this.q.a(a2);
                }
            }
        }
    }

    public final RectF a(Matrix matrix) {
        Drawable drawable = this.m.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.f6849d.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f6849d);
        return this.f6849d;
    }

    public final void a(Drawable drawable) {
        if (drawable != null) {
            float b2 = (float) b(this.m);
            float a2 = (float) a(this.m);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f6846a.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = b2 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = a2 / f4;
            ScaleType scaleType = this.E;
            if (scaleType == ScaleType.CENTER) {
                this.f6846a.postTranslate((b2 - f2) / 2.0f, (a2 - f4) / 2.0f);
            } else if (scaleType == ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.f6846a.postScale(max, max);
                this.f6846a.postTranslate((b2 - (f2 * max)) / 2.0f, (a2 - (f4 * max)) / 2.0f);
            } else if (scaleType == ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.f6846a.postScale(min, min);
                this.f6846a.postTranslate((b2 - (f2 * min)) / 2.0f, (a2 - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, b2, a2);
                if (((int) this.C) % HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT != 0) {
                    rectF = new RectF(0.0f, 0.0f, f4, f2);
                }
                int i2 = d.f6859a[this.E.ordinal()];
                if (i2 == 1) {
                    this.f6846a.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                } else if (i2 == 2) {
                    this.f6846a.setRectToRect(rectF, rectF2, ScaleToFit.START);
                } else if (i2 == 3) {
                    this.f6846a.setRectToRect(rectF, rectF2, ScaleToFit.END);
                } else if (i2 == 4) {
                    this.f6846a.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                }
            }
            f();
        }
    }

    public final int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
