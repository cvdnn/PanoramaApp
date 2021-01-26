package e.c.e.a;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import e.c.d.n.e;
import java.lang.ref.WeakReference;

/* compiled from: CustomSlidingPanelLayout */
public class a extends e {
    public boolean A = true;
    public boolean B = false;
    public double C = 1.0d;
    public d D;
    public WeakReference<Activity> E;
    public b F;

    /* renamed from: e.c.e.a.a$a reason: collision with other inner class name */
    /* compiled from: CustomSlidingPanelLayout */
    public class C0072a implements b {
        public C0072a() {
        }

        public void onTranslucent(boolean z) {
            a.this.setActivityIsTranslucent(z);
            b bVar = a.this.F;
            if (bVar != null) {
                bVar.onTranslucent(z);
            }
        }
    }

    public a(Context context) {
        super(context);
        setCanSlideRegionFactor(1.0d);
        setActivityIsTranslucent(true);
    }

    public void a() {
        WeakReference<Activity> weakReference = this.E;
        if (weakReference == null || weakReference.get() == null) {
            b bVar = this.F;
            if (bVar != null) {
                bVar.onTranslucent(false);
            }
            return;
        }
        Activity activity = (Activity) this.E.get();
        C0072a aVar = new C0072a();
        try {
            e.a(activity, (b) aVar);
        } catch (Throwable unused) {
            aVar.onTranslucent(false);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2) {
            if (!this.A) {
                return false;
            }
            try {
                if (this.D != null && !this.D.isSlidable(motionEvent)) {
                    return false;
                }
            } catch (AbstractMethodError e2) {
                e2.printStackTrace();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCanSlidable(boolean z) {
        this.A = z;
    }

    public void setOnTransparentListener(b bVar) {
        this.F = bVar;
    }

    public void setSlideInterceptor(d dVar) {
        this.D = dVar;
    }
}
