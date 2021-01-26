package d.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;

/* compiled from: DefaultItemAnimator */
public class h extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ d0 f5329a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ int f5330b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5331c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ int f5332d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5333e;

    /* renamed from: f reason: collision with root package name */
    public final /* synthetic */ k f5334f;

    public h(k kVar, d0 d0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
        this.f5334f = kVar;
        this.f5329a = d0Var;
        this.f5330b = i2;
        this.f5331c = view;
        this.f5332d = i3;
        this.f5333e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f5330b != 0) {
            this.f5331c.setTranslationX(0.0f);
        }
        if (this.f5332d != 0) {
            this.f5331c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f5333e.setListener(null);
        this.f5334f.a(this.f5329a);
        this.f5334f.p.remove(this.f5329a);
        this.f5334f.d();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f5334f == null) {
            throw null;
        }
    }
}
