package e.g.a.a.h0;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ClearTextEndIconDelegate */
public class e implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f8169a;

    public e(a aVar) {
        this.f8169a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f8169a.f8191c.setScaleX(floatValue);
        this.f8169a.f8191c.setScaleY(floatValue);
    }
}
