package e.g.a.a.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ClearTextEndIconDelegate */
public class b extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f8166a;

    public b(a aVar) {
        this.f8166a = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f8166a.f8189a.setEndIconVisible(true);
    }
}
