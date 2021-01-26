package a.a.a.a.e.a.j;

import e.a.a.a.a;
import java.io.Serializable;

public class g implements b, Serializable {
    public float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return a.e(1.0f, f2, f3 * f3 * f3, 1.0f);
    }

    public String getName() {
        return c.QUARTIC_EASE_OUT.f633a;
    }
}
