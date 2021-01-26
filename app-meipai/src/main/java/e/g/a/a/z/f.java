package e.g.a.a.z;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
public final class f {

    /* renamed from: a reason: collision with root package name */
    public final ArrayList<b> f8448a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    public b f8449b = null;

    /* renamed from: c reason: collision with root package name */
    public ValueAnimator f8450c = null;

    /* renamed from: d reason: collision with root package name */
    public final AnimatorListener f8451d = new a();

    /* compiled from: StateListAnimator */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f8450c == animator) {
                fVar.f8450c = null;
            }
        }
    }

    /* compiled from: StateListAnimator */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final int[] f8453a;

        /* renamed from: b reason: collision with root package name */
        public final ValueAnimator f8454b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f8453a = iArr;
            this.f8454b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f8451d);
        this.f8448a.add(bVar);
    }
}
