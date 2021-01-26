package e.g.a.a.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ClearTextEndIconDelegate */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f8167a;

    public c(a aVar) {
        this.f8167a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f8167a.f8189a.setEndIconVisible(false);
    }
}
