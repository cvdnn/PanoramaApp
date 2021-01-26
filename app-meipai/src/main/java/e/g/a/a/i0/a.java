package e.g.a.a.i0;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

/* compiled from: FabTransformationBehavior */
public class a implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ View f8213a;

    public a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f8213a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8213a.invalidate();
    }
}
