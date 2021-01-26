package d.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;

/* compiled from: DefaultItemAnimator */
public class g extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ d0 f5325a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ View f5326b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5327c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ k f5328d;

    public g(k kVar, d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f5328d = kVar;
        this.f5325a = d0Var;
        this.f5326b = view;
        this.f5327c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f5326b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f5327c.setListener(null);
        this.f5328d.a(this.f5325a);
        this.f5328d.o.remove(this.f5325a);
        this.f5328d.d();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f5328d == null) {
            throw null;
        }
    }
}
