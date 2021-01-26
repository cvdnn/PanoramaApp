package d.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentManagerImpl */
public class l extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5160a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ View f5161b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Fragment f5162c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ j f5163d;

    public l(j jVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f5163d = jVar;
        this.f5160a = viewGroup;
        this.f5161b = view;
        this.f5162c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5160a.endViewTransition(this.f5161b);
        Animator animator2 = this.f5162c.getAnimator();
        this.f5162c.setAnimator(null);
        if (animator2 != null && this.f5160a.indexOfChild(this.f5161b) < 0) {
            j jVar = this.f5163d;
            Fragment fragment = this.f5162c;
            jVar.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
