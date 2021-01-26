package e.g.a.a.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import e.g.a.a.y.e.f;

/* compiled from: FloatingActionButtonImpl */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public boolean f8405a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ boolean f8406b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ f f8407c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ e f8408d;

    public c(e eVar, boolean z, f fVar) {
        this.f8408d = eVar;
        this.f8406b = z;
        this.f8407c = fVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f8405a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f8408d;
        eVar.p = 0;
        eVar.k = null;
        if (!this.f8405a) {
            eVar.t.a(this.f8406b ? 8 : 4, this.f8406b);
            f fVar = this.f8407c;
            if (fVar != null) {
                b bVar = (b) fVar;
                bVar.f8403a.a(bVar.f8404b);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f8408d.t.a(0, this.f8406b);
        e eVar = this.f8408d;
        eVar.p = 1;
        eVar.k = animator;
        this.f8405a = false;
    }
}
