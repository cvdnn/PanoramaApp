package e.g.a.a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* compiled from: BottomAppBar */
public class d extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public boolean f8274a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f8275b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ int f8276c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ boolean f8277d;

    /* renamed from: e reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f8278e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i2, boolean z) {
        this.f8278e = bottomAppBar;
        this.f8275b = actionMenuView;
        this.f8276c = i2;
        this.f8277d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f8274a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f8274a) {
            this.f8275b.setTranslationX((float) this.f8278e.a(this.f8275b, this.f8276c, this.f8277d));
        }
    }
}
