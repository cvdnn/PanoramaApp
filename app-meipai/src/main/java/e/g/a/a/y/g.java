package e.g.a.a.y;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: FloatingActionButtonImpl */
public class g implements OnPreDrawListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ e f8431a;

    public g(e eVar) {
        this.f8431a = eVar;
    }

    public boolean onPreDraw() {
        e eVar = this.f8431a;
        float rotation = eVar.t.getRotation();
        if (eVar.n != rotation) {
            eVar.n = rotation;
            eVar.l();
        }
        return true;
    }
}
