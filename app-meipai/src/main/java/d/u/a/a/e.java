package d.u.a.a;

import android.animation.TypeEvaluator;
import e.a.a.a.a;

/* compiled from: ArgbEvaluator */
public class e implements TypeEvaluator {

    /* renamed from: a reason: collision with root package name */
    public static final e f5549a = new e();

    public Object evaluate(float f2, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        float f4 = ((float) ((intValue >> 16) & 255)) / 255.0f;
        float f5 = ((float) ((intValue >> 8) & 255)) / 255.0f;
        float f6 = ((float) (intValue & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f7 = ((float) ((intValue2 >> 24) & 255)) / 255.0f;
        float f8 = ((float) ((intValue2 >> 16) & 255)) / 255.0f;
        float f9 = ((float) ((intValue2 >> 8) & 255)) / 255.0f;
        float pow = (float) Math.pow((double) f4, 2.2d);
        float pow2 = (float) Math.pow((double) f5, 2.2d);
        float pow3 = (float) Math.pow((double) f6, 2.2d);
        float pow4 = (float) Math.pow((double) f8, 2.2d);
        float pow5 = (float) Math.pow((double) f9, 2.2d);
        float pow6 = (float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d);
        float e2 = a.e(f7, f3, f2, f3);
        float e3 = a.e(pow4, pow, f2, pow);
        float e4 = a.e(pow5, pow2, f2, pow2);
        float e5 = a.e(pow6, pow3, f2, pow3);
        int round = Math.round(e2 * 255.0f) << 24;
        return Integer.valueOf(Math.round(((float) Math.pow((double) e5, 0.45454545454545453d)) * 255.0f) | (Math.round(((float) Math.pow((double) e3, 0.45454545454545453d)) * 255.0f) << 16) | round | (Math.round(((float) Math.pow((double) e4, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
