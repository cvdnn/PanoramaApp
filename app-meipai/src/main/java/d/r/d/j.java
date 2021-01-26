package d.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;
import d.r.d.k.a;

/* compiled from: DefaultItemAnimator */
public class j extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f5339a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5340b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5341c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ k f5342d;

    public j(k kVar, a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f5342d = kVar;
        this.f5339a = aVar;
        this.f5340b = viewPropertyAnimator;
        this.f5341c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5340b.setListener(null);
        this.f5341c.setAlpha(1.0f);
        this.f5341c.setTranslationX(0.0f);
        this.f5341c.setTranslationY(0.0f);
        this.f5342d.a(this.f5339a.f5347b);
        this.f5342d.r.remove(this.f5339a.f5347b);
        this.f5342d.d();
    }

    public void onAnimationStart(Animator animator) {
        k kVar = this.f5342d;
        d0 d0Var = this.f5339a.f5347b;
        if (kVar == null) {
            throw null;
        }
    }
}
