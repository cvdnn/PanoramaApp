package d.h.l;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import d.h.k.m;

/* compiled from: AutoScrollHelper */
public abstract class a implements OnTouchListener {
    public static final int q = ViewConfiguration.getTapTimeout();

    /* renamed from: a reason: collision with root package name */
    public final C0043a f4970a = new C0043a();

    /* renamed from: b reason: collision with root package name */
    public final Interpolator f4971b = new AccelerateInterpolator();

    /* renamed from: c reason: collision with root package name */
    public final View f4972c;

    /* renamed from: d reason: collision with root package name */
    public Runnable f4973d;

    /* renamed from: e reason: collision with root package name */
    public float[] f4974e = {0.0f, 0.0f};

    /* renamed from: f reason: collision with root package name */
    public float[] f4975f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g reason: collision with root package name */
    public int f4976g;

    /* renamed from: h reason: collision with root package name */
    public int f4977h;

    /* renamed from: i reason: collision with root package name */
    public float[] f4978i = {0.0f, 0.0f};

    /* renamed from: j reason: collision with root package name */
    public float[] f4979j = {0.0f, 0.0f};
    public float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* renamed from: d.h.l.a$a reason: collision with other inner class name */
    /* compiled from: AutoScrollHelper */
    public static class C0043a {

        /* renamed from: a reason: collision with root package name */
        public int f4980a;

        /* renamed from: b reason: collision with root package name */
        public int f4981b;

        /* renamed from: c reason: collision with root package name */
        public float f4982c;

        /* renamed from: d reason: collision with root package name */
        public float f4983d;

        /* renamed from: e reason: collision with root package name */
        public long f4984e = Long.MIN_VALUE;

        /* renamed from: f reason: collision with root package name */
        public long f4985f = 0;

        /* renamed from: g reason: collision with root package name */
        public int f4986g = 0;

        /* renamed from: h reason: collision with root package name */
        public int f4987h = 0;

        /* renamed from: i reason: collision with root package name */
        public long f4988i = -1;

        /* renamed from: j reason: collision with root package name */
        public float f4989j;
        public int k;

        public final float a(long j2) {
            if (j2 < this.f4984e) {
                return 0.0f;
            }
            long j3 = this.f4988i;
            if (j3 < 0 || j2 < j3) {
                return a.a(((float) (j2 - this.f4984e)) / ((float) this.f4980a), 0.0f, 1.0f) * 0.5f;
            }
            long j4 = j2 - j3;
            float f2 = this.f4989j;
            return (a.a(((float) j4) / ((float) this.k), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    /* compiled from: AutoScrollHelper */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.o) {
                if (aVar.m) {
                    aVar.m = false;
                    C0043a aVar2 = aVar.f4970a;
                    if (aVar2 != null) {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar2.f4984e = currentAnimationTimeMillis;
                        aVar2.f4988i = -1;
                        aVar2.f4985f = currentAnimationTimeMillis;
                        aVar2.f4989j = 0.5f;
                        aVar2.f4986g = 0;
                        aVar2.f4987h = 0;
                    } else {
                        throw null;
                    }
                }
                C0043a aVar3 = a.this.f4970a;
                if ((aVar3.f4988i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f4988i + ((long) aVar3.k)) || !a.this.b()) {
                    a.this.o = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.n) {
                    aVar4.n = false;
                    if (aVar4 != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        aVar4.f4972c.onTouchEvent(obtain);
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
                if (aVar3.f4985f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a2 = aVar3.a(currentAnimationTimeMillis2);
                    float f2 = (a2 * 4.0f) + (-4.0f * a2 * a2);
                    long j2 = currentAnimationTimeMillis2 - aVar3.f4985f;
                    aVar3.f4985f = currentAnimationTimeMillis2;
                    float f3 = ((float) j2) * f2;
                    aVar3.f4986g = (int) (aVar3.f4982c * f3);
                    int i2 = (int) (f3 * aVar3.f4983d);
                    aVar3.f4987h = i2;
                    ((c) a.this).r.scrollListBy(i2);
                    m.a(a.this.f4972c, (Runnable) this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        this.f4972c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        int i2 = (int) ((f2 * 315.0f) + 0.5f);
        float f3 = (float) ((int) ((1575.0f * f2) + 0.5f));
        float[] fArr = this.k;
        float f4 = f3 / 1000.0f;
        fArr[0] = f4;
        fArr[1] = f4;
        float f5 = (float) i2;
        float[] fArr2 = this.f4979j;
        float f6 = f5 / 1000.0f;
        fArr2[0] = f6;
        fArr2[1] = f6;
        this.f4976g = 1;
        float[] fArr3 = this.f4975f;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f4974e;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f4978i;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f4977h = q;
        C0043a aVar = this.f4970a;
        aVar.f4980a = 500;
        aVar.f4981b = 500;
    }

    public static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public final void a() {
        int i2 = 0;
        if (this.m) {
            this.o = false;
            return;
        }
        C0043a aVar = this.f4970a;
        if (aVar != null) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i3 = (int) (currentAnimationTimeMillis - aVar.f4984e);
            int i4 = aVar.f4981b;
            if (i3 > i4) {
                i2 = i4;
            } else if (i3 >= 0) {
                i2 = i3;
            }
            aVar.k = i2;
            aVar.f4989j = aVar.a(currentAnimationTimeMillis);
            aVar.f4988i = currentAnimationTimeMillis;
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r9 = this;
            d.h.l.a$a r0 = r9.f4970a
            float r1 = r0.f4983d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f4982c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0053
            r4 = r9
            d.h.l.c r4 = (d.h.l.c) r4
            android.widget.ListView r4 = r4.r
            int r5 = r4.getCount()
            if (r5 != 0) goto L_0x0023
        L_0x0021:
            r1 = r3
            goto L_0x0051
        L_0x0023:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L_0x0041
            if (r8 < r5) goto L_0x0050
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L_0x0050
            goto L_0x0021
        L_0x0041:
            if (r1 >= 0) goto L_0x0021
            if (r7 > 0) goto L_0x0050
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0050
            goto L_0x0021
        L_0x0050:
            r1 = r2
        L_0x0051:
            if (r1 != 0) goto L_0x0054
        L_0x0053:
            r2 = r3
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.l.a.b():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x007d
        L_0x0016:
            r5.a()
            goto L_0x007d
        L_0x001a:
            r5.n = r2
            r5.l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f4972c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f4972c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            d.h.l.a$a r7 = r5.f4970a
            r7.f4982c = r0
            r7.f4983d = r6
            boolean r6 = r5.o
            if (r6 != 0) goto L_0x007d
            boolean r6 = r5.b()
            if (r6 == 0) goto L_0x007d
            java.lang.Runnable r6 = r5.f4973d
            if (r6 != 0) goto L_0x0061
            d.h.l.a$b r6 = new d.h.l.a$b
            r6.<init>()
            r5.f4973d = r6
        L_0x0061:
            r5.o = r2
            r5.m = r2
            boolean r6 = r5.l
            if (r6 != 0) goto L_0x0076
            int r6 = r5.f4977h
            if (r6 <= 0) goto L_0x0076
            android.view.View r7 = r5.f4972c
            java.lang.Runnable r0 = r5.f4973d
            long r3 = (long) r6
            d.h.k.m.a(r7, r0, r3)
            goto L_0x007b
        L_0x0076:
            java.lang.Runnable r6 = r5.f4973d
            r6.run()
        L_0x007b:
            r5.l = r2
        L_0x007d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.l.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f4974e
            r0 = r0[r4]
            float[] r1 = r3.f4975f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = a(r0, r2, r1)
            float r1 = r3.a(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.a(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0025
            android.view.animation.Interpolator r6 = r3.f4971b
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L_0x002f
        L_0x0025:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0038
            android.view.animation.Interpolator r6 = r3.f4971b
            float r5 = r6.getInterpolation(r5)
        L_0x002f:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = a(r5, r6, r0)
            goto L_0x0039
        L_0x0038:
            r5 = r2
        L_0x0039:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x003e
            return r2
        L_0x003e:
            float[] r0 = r3.f4978i
            r0 = r0[r4]
            float[] r1 = r3.f4979j
            r1 = r1[r4]
            float[] r2 = r3.k
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L_0x0053
            float r5 = r5 * r0
            float r4 = a(r5, r1, r4)
            return r4
        L_0x0053:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = a(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.l.a.a(int, float, float, float):float");
    }

    public final float a(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f4976g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                return (!this.o || this.f4976g != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }
}
