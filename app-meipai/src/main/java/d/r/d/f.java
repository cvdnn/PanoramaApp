package d.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;

/* compiled from: DefaultItemAnimator */
public class f extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ d0 f5321a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5322b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5323c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ k f5324d;

    public f(k kVar, d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f5324d = kVar;
        this.f5321a = d0Var;
        this.f5322b = viewPropertyAnimator;
        this.f5323c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5322b.setListener(null);
        this.f5323c.setAlpha(1.0f);
        this.f5324d.a(this.f5321a);
        this.f5324d.q.remove(this.f5321a);
        this.f5324d.d();
    }

    public void onAnimationStart(Animator animator) {
        if (this.f5324d == null) {
            throw null;
        }
    }
}
