package e.c.d.m.i.j;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import e.c.d.m.i.j.l.f;

/* compiled from: CustomGestureDetector */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final ScaleGestureDetector f6833a;

    /* renamed from: b reason: collision with root package name */
    public final float f6834b;

    /* renamed from: c reason: collision with root package name */
    public final float f6835c;

    /* renamed from: d reason: collision with root package name */
    public int f6836d = -1;

    /* renamed from: e reason: collision with root package name */
    public int f6837e = 0;

    /* renamed from: f reason: collision with root package name */
    public VelocityTracker f6838f;

    /* renamed from: g reason: collision with root package name */
    public boolean f6839g;

    /* renamed from: h reason: collision with root package name */
    public float f6840h;

    /* renamed from: i reason: collision with root package name */
    public float f6841i;

    /* renamed from: j reason: collision with root package name */
    public b f6842j;

    /* renamed from: e.c.d.m.i.j.a$a reason: collision with other inner class name */
    /* compiled from: CustomGestureDetector */
    public class C0071a implements OnScaleGestureListener {
        public C0071a() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor >= 0.0f) {
                ((e.c.d.m.i.j.l.a) a.this.f6842j).a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public a(Context context, b bVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6835c = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6834b = (float) viewConfiguration.getScaledTouchSlop();
        this.f6842j = bVar;
        this.f6833a = new ScaleGestureDetector(context, new C0071a());
    }

    public final float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f6837e);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f6837e);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public final boolean c(MotionEvent motionEvent) {
        int i2;
        int i3;
        int i4;
        int i5;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        int i6 = 0;
        if (action == 0) {
            this.f6836d = motionEvent2.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f6838f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent2);
            }
            this.f6840h = a(motionEvent);
            this.f6841i = b(motionEvent);
            this.f6839g = false;
        } else if (action == 1) {
            this.f6836d = -1;
            if (this.f6839g && this.f6838f != null) {
                this.f6840h = a(motionEvent);
                this.f6841i = b(motionEvent);
                this.f6838f.addMovement(motionEvent2);
                this.f6838f.computeCurrentVelocity(1000);
                float xVelocity = this.f6838f.getXVelocity();
                float yVelocity = this.f6838f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f6835c) {
                    float f2 = -xVelocity;
                    float f3 = -yVelocity;
                    e.c.d.m.i.j.l.a aVar = (e.c.d.m.i.j.l.a) this.f6842j;
                    l lVar = l.this;
                    lVar.z = new f(lVar.m.getContext());
                    l lVar2 = l.this;
                    f fVar = lVar2.z;
                    int b2 = lVar2.b(lVar2.m);
                    l lVar3 = l.this;
                    int a2 = lVar3.a(lVar3.m);
                    int i7 = (int) f2;
                    int i8 = (int) f3;
                    RectF c2 = l.this.c();
                    if (c2 != null) {
                        int round = Math.round(-c2.left);
                        float f4 = (float) b2;
                        if (f4 < c2.width()) {
                            i3 = Math.round(c2.width() - f4);
                            i2 = 0;
                        } else {
                            i3 = round;
                            i2 = i3;
                        }
                        int round2 = Math.round(-c2.top);
                        float f5 = (float) a2;
                        if (f5 < c2.height()) {
                            i5 = Math.round(c2.height() - f5);
                            i4 = 0;
                        } else {
                            i5 = round2;
                            i4 = i5;
                        }
                        fVar.f6867b = round;
                        fVar.f6868c = round2;
                        if (!(round == i3 && round2 == i5)) {
                            fVar.f6866a.fling(round, round2, i7, i8, i2, i3, i4, i5, 0, 0);
                        }
                    }
                    l lVar4 = l.this;
                    lVar4.m.post(lVar4.z);
                }
            }
            VelocityTracker velocityTracker = this.f6838f;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f6838f = null;
            }
        } else if (action == 2) {
            float a3 = a(motionEvent);
            float b3 = b(motionEvent);
            float f6 = a3 - this.f6840h;
            float f7 = b3 - this.f6841i;
            if (!this.f6839g) {
                this.f6839g = Math.sqrt((double) ((f7 * f7) + (f6 * f6))) >= ((double) this.f6834b);
            }
            if (this.f6839g) {
                e.c.d.m.i.j.l.a aVar2 = (e.c.d.m.i.j.l.a) this.f6842j;
                if (!l.this.o.a()) {
                    i iVar = l.this.y;
                    if (iVar != null) {
                        iVar.a(f6, f7);
                    }
                    l.this.f6848c.postTranslate(f6, f7);
                    l.this.a();
                    ViewParent parent = l.this.m.getParent();
                    l lVar5 = l.this;
                    if (lVar5.k && !lVar5.o.a()) {
                        l lVar6 = l.this;
                        if (!lVar6.l) {
                            int i9 = lVar6.A;
                            if ((i9 == 2 || ((i9 == 0 && f6 >= 1.0f) || ((l.this.A == 1 && f6 <= -1.0f) || ((l.this.B == 0 && f7 >= 1.0f) || (l.this.B == 1 && f7 <= -1.0f))))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    }
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                this.f6840h = a3;
                this.f6841i = b3;
                VelocityTracker velocityTracker2 = this.f6838f;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent2);
                }
            }
        } else if (action == 3) {
            this.f6836d = -1;
            VelocityTracker velocityTracker3 = this.f6838f;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f6838f = null;
            }
        } else if (action == 6) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            if (motionEvent2.getPointerId(action2) == this.f6836d) {
                int i10 = action2 == 0 ? 1 : 0;
                this.f6836d = motionEvent2.getPointerId(i10);
                this.f6840h = motionEvent2.getX(i10);
                this.f6841i = motionEvent2.getY(i10);
            }
        }
        int i11 = this.f6836d;
        if (i11 != -1) {
            i6 = i11;
        }
        this.f6837e = motionEvent2.findPointerIndex(i6);
        return true;
    }

    public boolean a() {
        return this.f6833a.isInProgress();
    }
}
