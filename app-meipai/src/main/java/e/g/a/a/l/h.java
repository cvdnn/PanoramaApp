package e.g.a.a.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import e.a.a.a.a;

/* compiled from: MotionTiming */
public class h {

    /* renamed from: a reason: collision with root package name */
    public long f8232a = 0;

    /* renamed from: b reason: collision with root package name */
    public long f8233b = 300;

    /* renamed from: c reason: collision with root package name */
    public TimeInterpolator f8234c = null;

    /* renamed from: d reason: collision with root package name */
    public int f8235d = 0;

    /* renamed from: e reason: collision with root package name */
    public int f8236e = 1;

    public h(long j2, long j3) {
        this.f8232a = j2;
        this.f8233b = j3;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.f8232a);
        animator.setDuration(this.f8233b);
        animator.setInterpolator(a());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f8235d);
            valueAnimator.setRepeatMode(this.f8236e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f8232a == hVar.f8232a && this.f8233b == hVar.f8233b && this.f8235d == hVar.f8235d && this.f8236e == hVar.f8236e) {
            return a().getClass().equals(hVar.a().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f8232a;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        long j3 = this.f8233b;
        return ((((a().getClass().hashCode() + ((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31)) * 31) + this.f8235d) * 31) + this.f8236e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(10);
        sb.append(h.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f8232a);
        sb.append(" duration: ");
        sb.append(this.f8233b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f8235d);
        sb.append(" repeatMode: ");
        return a.a(sb, this.f8236e, "}\n");
    }

    public h(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.f8232a = j2;
        this.f8233b = j3;
        this.f8234c = timeInterpolator;
    }

    public TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f8234c;
        return timeInterpolator != null ? timeInterpolator : a.f8218b;
    }
}
