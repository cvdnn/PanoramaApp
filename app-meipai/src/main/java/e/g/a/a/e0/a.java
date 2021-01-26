package e.g.a.a.e0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AbsoluteCornerSize */
public final class a implements c {

    /* renamed from: a reason: collision with root package name */
    public final float f8068a;

    public a(float f2) {
        this.f8068a = f2;
    }

    public float a(RectF rectF) {
        return this.f8068a;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        if (this.f8068a != ((a) obj).f8068a) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8068a)});
    }
}
