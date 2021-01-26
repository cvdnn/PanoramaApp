package d.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d.e.a;

/* compiled from: Transition */
public class j extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f5498a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ i f5499b;

    public j(i iVar, a aVar) {
        this.f5499b = iVar;
        this.f5498a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5498a.remove(animator);
        this.f5499b.w.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f5499b.w.add(animator);
    }
}
