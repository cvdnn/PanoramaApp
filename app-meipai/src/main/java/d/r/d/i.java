package d.r.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;
import d.r.d.k.a;

/* compiled from: DefaultItemAnimator */
public class i extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f5335a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5336b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5337c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ k f5338d;

    public i(k kVar, a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f5338d = kVar;
        this.f5335a = aVar;
        this.f5336b = viewPropertyAnimator;
        this.f5337c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f5336b.setListener(null);
        this.f5337c.setAlpha(1.0f);
        this.f5337c.setTranslationX(0.0f);
        this.f5337c.setTranslationY(0.0f);
        this.f5338d.a(this.f5335a.f5346a);
        this.f5338d.r.remove(this.f5335a.f5346a);
        this.f5338d.d();
    }

    public void onAnimationStart(Animator animator) {
        k kVar = this.f5338d;
        d0 d0Var = this.f5335a.f5346a;
        if (kVar == null) {
            throw null;
        }
    }
}
