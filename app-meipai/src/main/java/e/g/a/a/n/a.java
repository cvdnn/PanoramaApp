package e.g.a.a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;

/* compiled from: BottomAppBar */
public class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f8269a;

    public a(BottomAppBar bottomAppBar) {
        this.f8269a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        BottomAppBar.c(this.f8269a);
    }

    public void onAnimationStart(Animator animator) {
        this.f8269a.S++;
    }
}
