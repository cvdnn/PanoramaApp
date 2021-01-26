package e.g.a.a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* compiled from: BottomAppBar */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f8273a;

    public c(BottomAppBar bottomAppBar) {
        this.f8273a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.c(this.f8273a);
        this.f8273a.O = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f8273a.S++;
    }
}
