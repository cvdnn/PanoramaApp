package e.g.a.a.i0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;
import e.g.a.a.t.c;

/* compiled from: FabTransformationBehavior */
public class b extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ c f8214a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Drawable f8215b;

    public b(FabTransformationBehavior fabTransformationBehavior, c cVar, Drawable drawable) {
        this.f8214a = cVar;
        this.f8215b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f8214a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.f8214a.setCircularRevealOverlayDrawable(this.f8215b);
    }
}
