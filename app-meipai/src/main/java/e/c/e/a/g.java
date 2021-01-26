package e.c.e.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.youth.banner.config.BannerConfig;
import d.h.l.d;
import e.c.e.a.e.C0073e;
import e.c.e.a.e.f;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
public class g {
    public static final Interpolator w = new a();

    /* renamed from: a reason: collision with root package name */
    public int f6902a;

    /* renamed from: b reason: collision with root package name */
    public int f6903b;

    /* renamed from: c reason: collision with root package name */
    public int f6904c = -1;

    /* renamed from: d reason: collision with root package name */
    public float[] f6905d;

    /* renamed from: e reason: collision with root package name */
    public float[] f6906e;

    /* renamed from: f reason: collision with root package name */
    public float[] f6907f;

    /* renamed from: g reason: collision with root package name */
    public float[] f6908g;

    /* renamed from: h reason: collision with root package name */
    public int[] f6909h;

    /* renamed from: i reason: collision with root package name */
    public int[] f6910i;

    /* renamed from: j reason: collision with root package name */
    public int[] f6911j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public d q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public final Runnable v = new b();

    /* compiled from: ViewDragHelper */
    public static class a implements Interpolator {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            g.this.b(0);
        }
    }

    /* compiled from: ViewDragHelper */
    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract void a(View view, int i2, int i3, int i4, int i5);
    }

    public g(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.u = viewGroup;
            this.r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f6903b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = new d(context, w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public void a(MotionEvent motionEvent) {
        int i2;
        int i3;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent2);
        int i4 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent2.getPointerId(0);
            View a2 = a((int) x, (int) y);
            b(x, y, pointerId);
            b(a2, pointerId);
            if ((this.f6909h[pointerId] & this.p) != 0 && this.r == null) {
                throw null;
            }
        } else if (actionMasked == 1) {
            if (this.f6902a == 1) {
                c();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f6902a == 1) {
                    a(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent2.getPointerId(actionIndex);
                float a3 = a(motionEvent2, actionIndex);
                float b2 = b(motionEvent2, actionIndex);
                if (a3 != -1.0f && b2 != -1.0f) {
                    b(a3, b2, pointerId2);
                    if (this.f6902a == 0) {
                        b(a((int) a3, (int) b2), pointerId2);
                        if ((this.f6909h[pointerId2] & this.p) != 0 && this.r == null) {
                            throw null;
                        }
                    } else {
                        if (a(this.s, (int) a3, (int) b2)) {
                            b(this.s, pointerId2);
                        }
                    }
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent2.getPointerId(actionIndex);
                if (this.f6902a == 1 && pointerId3 == this.f6904c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i4 >= pointerCount) {
                            i3 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent2.getPointerId(i4);
                        if (pointerId4 != this.f6904c) {
                            float a4 = a(motionEvent2, i4);
                            float b3 = b(motionEvent2, i4);
                            if (a4 != -1.0f && b3 != -1.0f) {
                                View a5 = a((int) a4, (int) b3);
                                View view = this.s;
                                if (a5 == view && b(view, pointerId4)) {
                                    i3 = this.f6904c;
                                    break;
                                }
                            } else {
                                return;
                            }
                        }
                        i4++;
                    }
                    if (i3 == -1) {
                        c();
                    }
                }
                a(pointerId3);
            }
        } else if (this.f6902a == 1) {
            int findPointerIndex = motionEvent2.findPointerIndex(this.f6904c);
            float a6 = a(motionEvent2, findPointerIndex);
            float b4 = b(motionEvent2, findPointerIndex);
            if (a6 != -1.0f && b4 != -1.0f) {
                float[] fArr = this.f6907f;
                int i5 = this.f6904c;
                int i6 = (int) (a6 - fArr[i5]);
                int i7 = (int) (b4 - this.f6908g[i5]);
                int left = this.s.getLeft() + i6;
                int top = this.s.getTop() + i7;
                int left2 = this.s.getLeft();
                int top2 = this.s.getTop();
                if (i6 != 0) {
                    left = this.r.a(this.s, left, i6);
                    if (e.this.f6884f) {
                        this.s.offsetLeftAndRight(left - left2);
                    }
                }
                int i8 = left;
                if (i7 != 0) {
                    c cVar = this.r;
                    View view2 = this.s;
                    if (cVar != null) {
                        view2.offsetTopAndBottom(0 - top2);
                        i2 = 0;
                    } else {
                        throw null;
                    }
                } else {
                    i2 = top;
                }
                if (!(i6 == 0 && i7 == 0)) {
                    int i9 = i8 - left2;
                    int i10 = i2 - top2;
                    c cVar2 = this.r;
                    if (e.this.f6884f) {
                        cVar2.a(this.s, i8, i2, i9, i10);
                    }
                }
                b(motionEvent);
            }
        } else {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i4 < pointerCount2) {
                int pointerId5 = motionEvent2.getPointerId(i4);
                float a7 = a(motionEvent2, i4);
                float b5 = b(motionEvent2, i4);
                if (a7 != -1.0f && b5 != -1.0f) {
                    float f2 = a7 - this.f6905d[pointerId5];
                    float f3 = b5 - this.f6906e[pointerId5];
                    a(f2, f3, pointerId5);
                    if (this.f6902a != 1) {
                        View a8 = a((int) a7, (int) b5);
                        if (a(a8, f2, f3) && b(a8, pointerId5)) {
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                } else {
                    return;
                }
            }
            b(motionEvent);
        }
    }

    public final float b(MotionEvent motionEvent, int i2) {
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getY(findPointerIndex);
    }

    public boolean c(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent2);
        boolean z = false;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                float f2 = -1.0f;
                if (actionMasked == 2) {
                    int pointerCount = motionEvent.getPointerCount();
                    int i2 = 0;
                    while (i2 < pointerCount) {
                        int pointerId = motionEvent2.getPointerId(i2);
                        float a2 = a(motionEvent2, i2);
                        float b2 = b(motionEvent2, i2);
                        if (a2 != f2 && b2 != f2) {
                            float f3 = a2 - this.f6905d[pointerId];
                            float f4 = b2 - this.f6906e[pointerId];
                            View a3 = a((int) a2, (int) b2);
                            boolean z2 = a3 != null && a(a3, f3, f4);
                            if (z2) {
                                int left = a3.getLeft();
                                int i3 = (int) f3;
                                int a4 = this.r.a(a3, left + i3, i3);
                                a3.getTop();
                                c cVar = this.r;
                                if (cVar != null) {
                                    int i4 = e.this.f6888j;
                                    if (i4 != 0) {
                                        if (i4 > 0 && a4 == left) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    throw null;
                                }
                            }
                            a(f3, f4, pointerId);
                            if (this.f6902a == 1 || (z2 && b(a3, pointerId))) {
                                break;
                            }
                            i2++;
                            f2 = -1.0f;
                        } else {
                            return false;
                        }
                    }
                    b(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent2.getPointerId(actionIndex);
                        float a5 = a(motionEvent2, actionIndex);
                        float b3 = b(motionEvent2, actionIndex);
                        if (a5 == -1.0f || b3 == -1.0f) {
                            return false;
                        }
                        b(a5, b3, pointerId2);
                        int i5 = this.f6902a;
                        if (i5 == 0) {
                            if ((this.f6909h[pointerId2] & this.p) != 0 && this.r == null) {
                                throw null;
                            }
                        } else if (i5 == 2) {
                            View a6 = a((int) a5, (int) b3);
                            if (a6 == this.s) {
                                b(a6, pointerId2);
                            }
                        }
                    } else if (actionMasked == 6) {
                        a(motionEvent2.getPointerId(actionIndex));
                    }
                }
            }
            b();
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId3 = motionEvent2.getPointerId(0);
            b(x, y, pointerId3);
            View a7 = a((int) x, (int) y);
            if (a7 == this.s && this.f6902a == 2) {
                b(a7, pointerId3);
            }
            if ((this.f6909h[pointerId3] & this.p) != 0 && this.r == null) {
                throw null;
            }
        }
        if (this.f6902a == 1) {
            z = true;
        }
        return z;
    }

    public void b() {
        this.f6904c = -1;
        float[] fArr = this.f6905d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f6906e, 0.0f);
            Arrays.fill(this.f6907f, 0.0f);
            Arrays.fill(this.f6908g, 0.0f);
            Arrays.fill(this.f6909h, 0);
            Arrays.fill(this.f6910i, 0);
            Arrays.fill(this.f6911j, 0);
            this.k = 0;
        }
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public final void b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int i2 = 0;
        while (i2 < pointerCount) {
            int pointerId = motionEvent.getPointerId(i2);
            float a2 = a(motionEvent, i2);
            float b2 = b(motionEvent, i2);
            if (a2 != -1.0f && b2 != -1.0f) {
                this.f6907f[pointerId] = a2;
                this.f6908g[pointerId] = b2;
                i2++;
            } else {
                return;
            }
        }
    }

    public boolean b(int i2, int i3) {
        if (this.t) {
            return a(i2, i3, (int) this.l.getXVelocity(this.f6904c), (int) this.l.getYVelocity(this.f6904c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public final int b(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * f2) + f2;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, BannerConfig.SCROLL_TIME);
    }

    public final void b(float f2, float f3, int i2) {
        float[] fArr = this.f6905d;
        int i3 = 0;
        if (fArr == null || fArr.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            float[] fArr6 = this.f6905d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f6906e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f6907f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f6908g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f6909h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6910i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6911j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6905d = fArr2;
            this.f6906e = fArr3;
            this.f6907f = fArr4;
            this.f6908g = fArr5;
            this.f6909h = iArr;
            this.f6910i = iArr2;
            this.f6911j = iArr3;
        }
        float[] fArr10 = this.f6905d;
        this.f6907f[i2] = f2;
        fArr10[i2] = f2;
        float[] fArr11 = this.f6906e;
        this.f6908g[i2] = f3;
        fArr11[i2] = f3;
        int[] iArr7 = this.f6909h;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.u.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.u.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr7[i2] = i3;
        this.k |= 1 << i2;
    }

    public final void c() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f6904c), this.n, this.m), a(this.l.getYVelocity(this.f6904c), this.n, this.m));
    }

    public void b(int i2) {
        if (this.f6902a != i2) {
            this.f6902a = i2;
            e.d dVar = (e.d) this.r;
            e eVar = e.this;
            if (eVar.q.f6902a == 0) {
                if (eVar.f6886h == 0.0f) {
                    eVar.b(eVar.f6885g);
                    e eVar2 = e.this;
                    View view = eVar2.f6885g;
                    f fVar = eVar2.p;
                    if (fVar != null) {
                        fVar.onPanelClosed(view);
                    }
                    eVar2.sendAccessibilityEvent(32);
                    e.this.u = false;
                } else {
                    View view2 = eVar.f6885g;
                    f fVar2 = eVar.p;
                    if (fVar2 != null) {
                        fVar2.onPanelOpened(view2);
                    }
                    eVar.sendAccessibilityEvent(32);
                    e.this.u = true;
                }
            }
            if (this.f6902a == 0) {
                this.s = null;
            }
        }
    }

    public void a(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.f6904c = i2;
            e.this.b();
            b(1);
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        a2.append(this.u);
        a2.append(")");
        throw new IllegalArgumentException(a2.toString());
    }

    public final float a(MotionEvent motionEvent, int i2) {
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getX(findPointerIndex);
    }

    public void a() {
        b();
        if (this.f6902a == 2) {
            int a2 = this.q.a();
            int b2 = this.q.b();
            this.q.f4991a.abortAnimation();
            int a3 = this.q.a();
            int b3 = this.q.b();
            this.r.a(this.s, a3, b3, a3 - a2, b3 - b2);
        }
        b(0);
    }

    public boolean b(View view, int i2) {
        boolean z;
        if (view == this.s && this.f6904c == i2) {
            return true;
        }
        if (view != null) {
            e eVar = e.this;
            if (eVar.k) {
                z = false;
            } else {
                if (!eVar.f6884f) {
                    eVar.a();
                }
                z = ((C0073e) view.getLayoutParams()).f6897b;
            }
            if (z) {
                this.f6904c = i2;
                a(view, i2);
                return true;
            }
        }
        return false;
    }

    public final boolean a(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.f4991a.abortAnimation();
            b(0);
            return false;
        }
        int a2 = a(i4, (int) this.n, (int) this.m);
        int a3 = a(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(a2);
        int abs4 = Math.abs(a3);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (a2 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f6 = f2 / f3;
        if (a3 != 0) {
            f5 = (float) abs4;
            f4 = (float) i8;
        } else {
            f5 = (float) abs2;
            f4 = (float) i9;
        }
        float f7 = f5 / f4;
        int b2 = b(i6, a2, e.this.f6888j);
        if (this.r != null) {
            this.q.f4991a.startScroll(left, top, i6, i7, (int) ((((float) b(i7, a3, 0)) * f7) + (((float) b2) * f6)));
            b(2);
            return true;
        }
        throw null;
    }

    public final int a(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs <= i4) {
            return i2;
        }
        if (i2 <= 0) {
            i4 = -i4;
        }
        return i4;
    }

    public final float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs <= f4) {
            return f2;
        }
        if (f2 <= 0.0f) {
            f4 = -f4;
        }
        return f4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(float r7, float r8) {
        /*
            r6 = this;
            r8 = 1
            r6.t = r8
            e.c.e.a.g$c r0 = r6.r
            android.view.View r1 = r6.s
            e.c.e.a.e$d r0 = (e.c.e.a.e.d) r0
            if (r0 == 0) goto L_0x0069
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            e.c.e.a.e$e r2 = (e.c.e.a.e.C0073e) r2
            e.c.e.a.e r3 = e.c.e.a.e.this
            int r3 = r3.getPaddingLeft()
            int r2 = r2.leftMargin
            int r3 = r3 + r2
            r2 = 0
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0047
            e.c.e.a.e r2 = e.c.e.a.e.this
            float r4 = r2.f6886h
            r5 = 1048576000(0x3e800000, float:0.25)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0047
            boolean r7 = r2.y
            if (r7 == 0) goto L_0x0031
            int r7 = r2.f6888j
            int r3 = r3 + r7
            goto L_0x0036
        L_0x0031:
            int r7 = r0.f6893a
            int r7 = r7 + 10
            int r3 = r3 + r7
        L_0x0036:
            e.c.e.a.e r7 = e.c.e.a.e.this
            e.c.e.a.g r7 = r7.q
            int r1 = r1.getTop()
            r7.b(r3, r1)
            e.c.e.a.e r7 = e.c.e.a.e.this
            r7.invalidate()
            goto L_0x005e
        L_0x0047:
            if (r7 <= 0) goto L_0x004e
            e.c.e.a.e r7 = e.c.e.a.e.this
            int r7 = r7.f6888j
            int r3 = r3 + r7
        L_0x004e:
            e.c.e.a.e r7 = e.c.e.a.e.this
            e.c.e.a.g r7 = r7.q
            int r1 = r1.getTop()
            r7.b(r3, r1)
            e.c.e.a.e r7 = e.c.e.a.e.this
            r7.invalidate()
        L_0x005e:
            r7 = 0
            r6.t = r7
            int r0 = r6.f6902a
            if (r0 != r8) goto L_0x0068
            r6.b(r7)
        L_0x0068:
            return
        L_0x0069:
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.a.g.a(float, float):void");
    }

    public final void a(int i2) {
        float[] fArr = this.f6905d;
        if (fArr != null) {
            fArr[i2] = 0.0f;
            this.f6906e[i2] = 0.0f;
            this.f6907f[i2] = 0.0f;
            this.f6908g[i2] = 0.0f;
            this.f6909h[i2] = 0;
            this.f6910i[i2] = 0;
            this.f6911j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    public final void a(float f2, float f3, int i2) {
        int i3 = 1;
        if (!a(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f6910i;
            iArr[i2] = iArr[i2] | i3;
            e.d dVar = (e.d) this.r;
            e eVar = e.this;
            if (!eVar.f6884f) {
                eVar.a();
            }
            e eVar2 = e.this;
            eVar2.q.a(eVar2.f6885g, i2);
        }
    }

    public final boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f6909h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.f6911j[i2] & i3) == i3 || (this.f6910i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f6903b;
        if (abs <= ((float) i4) && abs2 <= ((float) i4)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.r == null) {
            throw null;
        } else if ((this.f6910i[i2] & i3) != 0 || abs <= ((float) this.f6903b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean a(View view, float f2, float f3) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        boolean z2 = e.this.f6888j > 0;
        if (this.r != null) {
            if (z2 && Math.abs(f2) > ((float) this.f6903b)) {
                z = true;
            }
            return z;
        }
        throw null;
    }

    public boolean a(View view, int i2, int i3) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom()) {
            z = true;
        }
        return z;
    }

    public View a(int i2, int i3) {
        int childCount = this.u.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return null;
            }
            ViewGroup viewGroup = this.u;
            if (this.r != null) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                    return childAt;
                }
            } else {
                throw null;
            }
        }
    }
}
