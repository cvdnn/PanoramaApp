package d.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition */
public class k extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ i f5500a;

    public k(i iVar) {
        this.f5500a = iVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5500a.a();
        animator.removeListener(this);
    }
}
