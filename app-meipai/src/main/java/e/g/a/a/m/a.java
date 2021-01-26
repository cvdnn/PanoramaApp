package e.g.a.a.m;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.google.android.material.appbar.AppBarLayout;
import e.g.a.a.e0.g;

/* compiled from: AppBarLayout */
public class a implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ g f8240a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f8241b;

    public a(AppBarLayout appBarLayout, g gVar) {
        this.f8241b = appBarLayout;
        this.f8240a = gVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8240a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
