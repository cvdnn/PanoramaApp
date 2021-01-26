package d.h.k;

import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat */
public class v {

    /* renamed from: a reason: collision with root package name */
    public final Object f4948a;

    public v(Object obj) {
        this.f4948a = obj;
    }

    public int a() {
        return ((WindowInsets) this.f4948a).getSystemWindowInsetBottom();
    }

    public int b() {
        return ((WindowInsets) this.f4948a).getSystemWindowInsetLeft();
    }

    public int c() {
        return ((WindowInsets) this.f4948a).getSystemWindowInsetRight();
    }

    public int d() {
        return ((WindowInsets) this.f4948a).getSystemWindowInsetTop();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        Object obj2 = this.f4948a;
        Object obj3 = vVar.f4948a;
        if (obj2 != null) {
            z = obj2.equals(obj3);
        } else if (obj3 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Object obj = this.f4948a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
