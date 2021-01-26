package e.g.a.a.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: CircularRevealCompat */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ c f8306a;

    public a(c cVar) {
        this.f8306a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f8306a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f8306a.a();
    }
}
