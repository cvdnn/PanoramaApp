package e.b.c.b.b.a.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView.IL;

/* compiled from: lambda */
public final /* synthetic */ class c implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ IL f5773a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ float f5774b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ float f5775c;

    public /* synthetic */ c(IL r1, float f2, float f3) {
        this.f5773a = r1;
        this.f5774b = f2;
        this.f5775c = f3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f5773a.IL1Iii(this.f5774b, this.f5775c, valueAnimator);
    }
}
