package d.d.a;

import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawableWithShadow */
public class f extends Drawable {

    /* renamed from: a reason: collision with root package name */
    public static final double f4552a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        return (float) (((1.0d - f4552a) * ((double) f3)) + ((double) f2));
    }

    public static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        return (float) (((1.0d - f4552a) * ((double) f3)) + ((double) (f2 * 1.5f)));
    }
}
