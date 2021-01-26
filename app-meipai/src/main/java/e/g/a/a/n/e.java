package e.g.a.a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: BottomAppBar */
public class e extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f8279a;

    public e(BottomAppBar bottomAppBar) {
        this.f8279a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        this.f8279a.V.onAnimationStart(animator);
        FloatingActionButton h2 = this.f8279a.h();
        if (h2 != null) {
            h2.setTranslationX(this.f8279a.getFabTranslationX());
        }
    }
}
