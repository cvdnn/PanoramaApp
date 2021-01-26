package e.g.a.a.e0;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize */
public final class b implements c {

    /* renamed from: a reason: collision with root package name */
    public final c f8069a;

    /* renamed from: b reason: collision with root package name */
    public final float f8070b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f8069a;
            f2 += ((b) cVar).f8070b;
        }
        this.f8069a = cVar;
        this.f8070b = f2;
    }

    public float a(RectF rectF) {
        return Math.max(0.0f, this.f8069a.a(rectF) + this.f8070b);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f8069a.equals(bVar.f8069a) || this.f8070b != bVar.f8070b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8069a, Float.valueOf(this.f8070b)});
    }
}
