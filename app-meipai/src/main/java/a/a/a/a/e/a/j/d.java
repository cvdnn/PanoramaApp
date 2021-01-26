package a.a.a.a.e.a.j;

import java.io.Serializable;

public class d implements b, Serializable {
    public float getInterpolation(float f2) {
        if (((double) f2) < 0.5d) {
            return 8.0f * f2 * f2 * f2 * f2;
        }
        float f3 = f2 - 1.0f;
        return (-8.0f * f3 * f3 * f3 * f3) + 1.0f;
    }

    public String getName() {
        return c.QUARTIC_EASE_IN_OUT.f633a;
    }
}
