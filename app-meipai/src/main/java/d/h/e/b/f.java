package d.h.e.b;

import java.util.List;

/* compiled from: GradientColorInflaterCompat */
public final class f {

    /* renamed from: a reason: collision with root package name */
    public final int[] f4802a;

    /* renamed from: b reason: collision with root package name */
    public final float[] f4803b;

    public f(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.f4802a = new int[size];
        this.f4803b = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            this.f4802a[i2] = ((Integer) list.get(i2)).intValue();
            this.f4803b[i2] = ((Float) list2.get(i2)).floatValue();
        }
    }

    public f(int i2, int i3) {
        this.f4802a = new int[]{i2, i3};
        this.f4803b = new float[]{0.0f, 1.0f};
    }

    public f(int i2, int i3, int i4) {
        this.f4802a = new int[]{i2, i3, i4};
        this.f4803b = new float[]{0.0f, 0.5f, 1.0f};
    }
}
