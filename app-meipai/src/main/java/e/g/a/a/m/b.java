package e.g.a.a.m;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;

/* compiled from: AppBarLayout */
public class b implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f8242a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f8243b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f8244c;

    public b(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f8244c = baseBehavior;
        this.f8242a = coordinatorLayout;
        this.f8243b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8244c.c(this.f8242a, this.f8243b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
