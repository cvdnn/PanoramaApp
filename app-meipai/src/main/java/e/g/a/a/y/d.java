package e.g.a.a.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.g.a.a.y.e.f;

/* compiled from: FloatingActionButtonImpl */
public class d extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ boolean f8409a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f8410b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ e f8411c;

    public d(e eVar, boolean z, f fVar) {
        this.f8411c = eVar;
        this.f8409a = z;
        this.f8410b = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f8411c;
        eVar.p = 0;
        eVar.k = null;
        f fVar = this.f8410b;
        if (fVar != null) {
            b bVar = (b) fVar;
            bVar.f8403a.b(bVar.f8404b);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f8411c.t.a(0, this.f8409a);
        e eVar = this.f8411c;
        eVar.p = 2;
        eVar.k = animator;
    }
}
