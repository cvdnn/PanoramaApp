package e.g.a.a.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.transformation.FabTransformationBehavior;
import e.g.a.a.t.c.e;

/* compiled from: FabTransformationBehavior */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ e.g.a.a.t.c f8216a;

    public c(FabTransformationBehavior fabTransformationBehavior, e.g.a.a.t.c cVar) {
        this.f8216a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        e revealInfo = this.f8216a.getRevealInfo();
        revealInfo.f8313c = Float.MAX_VALUE;
        this.f8216a.setRevealInfo(revealInfo);
    }
}
