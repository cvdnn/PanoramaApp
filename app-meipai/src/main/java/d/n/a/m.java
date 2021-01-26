package d.n.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentManagerImpl */
public class m extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5164a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ View f5165b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Fragment f5166c;

    public m(j jVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f5164a = viewGroup;
        this.f5165b = view;
        this.f5166c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5164a.endViewTransition(this.f5165b);
        animator.removeListener(this);
        Fragment fragment = this.f5166c;
        View view = fragment.mView;
        if (view != null && fragment.mHidden) {
            view.setVisibility(8);
        }
    }
}
