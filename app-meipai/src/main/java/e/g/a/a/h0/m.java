package e.g.a.a.h0;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: DropdownMenuEndIconDelegate */
public class m implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ h f8188a;

    public m(h hVar) {
        this.f8188a = hVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8188a.f8191c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
