package e.g.a.a.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.c;

/* compiled from: ExtendedFloatingActionButton */
public class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public boolean f8399a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ i f8400b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ c f8401c = null;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ ExtendedFloatingActionButton f8402d;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton, i iVar) {
        this.f8402d = extendedFloatingActionButton;
        this.f8400b = iVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f8399a = true;
        this.f8400b.a();
    }

    public void onAnimationEnd(Animator animator) {
        this.f8400b.d();
        if (!this.f8399a) {
            this.f8400b.a(null);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f8400b.onAnimationStart(animator);
        this.f8399a = false;
    }
}
