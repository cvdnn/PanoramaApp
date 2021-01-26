package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ClipBoxView */
public class a implements AnimatorUpdateListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ClipBoxView f3198a;

    public a(ClipBoxView clipBoxView) {
        this.f3198a = clipBoxView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f3198a.G = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
        this.f3198a.invalidate();
        this.f3198a.c();
    }
}
