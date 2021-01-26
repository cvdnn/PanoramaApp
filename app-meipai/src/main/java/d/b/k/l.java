package d.b.k;

import android.view.View;
import d.h.k.m;
import d.h.k.s;
import d.h.k.t;

/* compiled from: AppCompatDelegateImpl */
public class l extends t {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ g f4032a;

    public l(g gVar) {
        this.f4032a = gVar;
    }

    public void b(View view) {
        this.f4032a.o.setAlpha(1.0f);
        this.f4032a.r.a((s) null);
        this.f4032a.r = null;
    }

    public void c(View view) {
        this.f4032a.o.setVisibility(0);
        this.f4032a.o.sendAccessibilityEvent(32);
        if (this.f4032a.o.getParent() instanceof View) {
            m.E((View) this.f4032a.o.getParent());
        }
    }
}
