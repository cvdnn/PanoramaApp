package e.g.a.a.h0;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ClearTextEndIconDelegate */
public class d implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f8168a;

    public d(a aVar) {
        this.f8168a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8168a.f8191c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
