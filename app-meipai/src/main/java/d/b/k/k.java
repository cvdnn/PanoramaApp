package d.b.k;

import android.view.View;
import d.h.k.m;
import d.h.k.r;
import d.h.k.s;
import d.h.k.t;

/* compiled from: AppCompatDelegateImpl */
public class k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ g f4030a;

    /* compiled from: AppCompatDelegateImpl */
    public class a extends t {
        public a() {
        }

        public void b(View view) {
            k.this.f4030a.o.setAlpha(1.0f);
            k.this.f4030a.r.a((s) null);
            k.this.f4030a.r = null;
        }

        public void c(View view) {
            k.this.f4030a.o.setVisibility(0);
        }
    }

    public k(g gVar) {
        this.f4030a = gVar;
    }

    public void run() {
        g gVar = this.f4030a;
        gVar.p.showAtLocation(gVar.o, 55, 0, 0);
        this.f4030a.e();
        if (this.f4030a.k()) {
            this.f4030a.o.setAlpha(0.0f);
            g gVar2 = this.f4030a;
            r a2 = m.a(gVar2.o);
            a2.a(1.0f);
            gVar2.r = a2;
            r rVar = this.f4030a.r;
            a aVar = new a();
            View view = (View) rVar.f4940a.get();
            if (view != null) {
                rVar.a(view, aVar);
                return;
            }
            return;
        }
        this.f4030a.o.setAlpha(1.0f);
        this.f4030a.o.setVisibility(0);
    }
}
