package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: RippleSurfaceView */
public class g implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ RippleSurfaceView f3216a;

    public g(RippleSurfaceView rippleSurfaceView) {
        this.f3216a = rippleSurfaceView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3216a.f3161i = Integer.parseInt(String.valueOf(valueAnimator.getAnimatedValue()));
    }
}
