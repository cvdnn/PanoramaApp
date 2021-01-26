package d.o.a.a;

import android.view.animation.Interpolator;
import e.a.a.a.a;

/* compiled from: LookupTableInterpolator */
public abstract class d implements Interpolator {

    /* renamed from: a reason: collision with root package name */
    public final float[] f5265a;

    /* renamed from: b reason: collision with root package name */
    public final float f5266b;

    public d(float[] fArr) {
        this.f5265a = fArr;
        this.f5266b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5265a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f2), fArr.length - 2);
        float f3 = (float) min;
        float f4 = this.f5266b;
        float f5 = (f2 - (f3 * f4)) / f4;
        float[] fArr2 = this.f5265a;
        return a.e(fArr2[min + 1], fArr2[min], f5, fArr2[min]);
    }
}
