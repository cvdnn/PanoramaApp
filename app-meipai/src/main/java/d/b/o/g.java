package d.b.o;

import android.view.View;
import android.view.animation.Interpolator;
import d.h.k.r;
import d.h.k.s;
import d.h.k.t;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet */
public class g {

    /* renamed from: a reason: collision with root package name */
    public final ArrayList<r> f4131a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    public long f4132b = -1;

    /* renamed from: c reason: collision with root package name */
    public Interpolator f4133c;

    /* renamed from: d reason: collision with root package name */
    public s f4134d;

    /* renamed from: e reason: collision with root package name */
    public boolean f4135e;

    /* renamed from: f reason: collision with root package name */
    public final t f4136f = new a();

    /* compiled from: ViewPropertyAnimatorCompatSet */
    public class a extends t {

        /* renamed from: a reason: collision with root package name */
        public boolean f4137a = false;

        /* renamed from: b reason: collision with root package name */
        public int f4138b = 0;

        public a() {
        }

        public void b(View view) {
            int i2 = this.f4138b + 1;
            this.f4138b = i2;
            if (i2 == g.this.f4131a.size()) {
                s sVar = g.this.f4134d;
                if (sVar != null) {
                    sVar.b(null);
                }
                this.f4138b = 0;
                this.f4137a = false;
                g.this.f4135e = false;
            }
        }

        public void c(View view) {
            if (!this.f4137a) {
                this.f4137a = true;
                s sVar = g.this.f4134d;
                if (sVar != null) {
                    sVar.c(null);
                }
            }
        }
    }

    public void a() {
        if (this.f4135e) {
            Iterator it = this.f4131a.iterator();
            while (it.hasNext()) {
                ((r) it.next()).a();
            }
            this.f4135e = false;
        }
    }

    public void b() {
        if (!this.f4135e) {
            Iterator it = this.f4131a.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                long j2 = this.f4132b;
                if (j2 >= 0) {
                    rVar.a(j2);
                }
                Interpolator interpolator = this.f4133c;
                if (interpolator != null) {
                    View view = (View) rVar.f4940a.get();
                    if (view != null) {
                        view.animate().setInterpolator(interpolator);
                    }
                }
                if (this.f4134d != null) {
                    rVar.a((s) this.f4136f);
                }
                View view2 = (View) rVar.f4940a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f4135e = true;
        }
    }
}
