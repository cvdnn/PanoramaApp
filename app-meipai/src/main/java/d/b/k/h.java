package d.b.k;

import android.view.View;
import android.view.WindowInsets;
import d.h.k.k;
import d.h.k.m;
import d.h.k.v;

/* compiled from: AppCompatDelegateImpl */
public class h implements k {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ g f4027a;

    public h(g gVar) {
        this.f4027a = gVar;
    }

    public v a(View view, v vVar) {
        int d2 = vVar.d();
        int f2 = this.f4027a.f(d2);
        if (d2 != f2) {
            vVar = new v(((WindowInsets) vVar.f4948a).replaceSystemWindowInsets(vVar.b(), f2, vVar.c(), vVar.a()));
        }
        return m.a(view, vVar);
    }
}
