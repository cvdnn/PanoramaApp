package e.g.a.a.o;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.g.a.a.e0.g;

/* compiled from: BottomSheetBehavior */
public class a implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f8284a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f8284a = bottomSheetBehavior;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        g gVar = this.f8284a.f3333h;
        if (gVar != null) {
            gVar.b(floatValue);
        }
    }
}
