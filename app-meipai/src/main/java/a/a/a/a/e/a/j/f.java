package a.a.a.a.e.a.j;

import java.io.Serializable;

public class f implements b, Serializable {

    /* renamed from: a reason: collision with root package name */
    public e f634a = new e();

    /* renamed from: b reason: collision with root package name */
    public g f635b = new g();

    public float getInterpolation(float f2) {
        return ((double) f2) < 0.5d ? this.f635b.getInterpolation(f2 * 2.0f) / 2.0f : (this.f634a.getInterpolation((f2 - 0.5f) * 2.0f) / 2.0f) + 0.5f;
    }

    public String getName() {
        return c.SLIP_IN_SLIP_OUT_INTERPOLATOR.f633a;
    }
}
