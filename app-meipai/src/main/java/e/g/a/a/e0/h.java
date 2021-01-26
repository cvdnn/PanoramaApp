package e.g.a.a.e0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize */
public final class h implements c {

    /* renamed from: a reason: collision with root package name */
    public final float f8093a;

    public h(float f2) {
        this.f8093a = f2;
    }

    public float a(RectF rectF) {
        return rectF.height() * this.f8093a;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        if (this.f8093a != ((h) obj).f8093a) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8093a)});
    }
}
