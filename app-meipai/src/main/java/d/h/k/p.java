package d.h.k;

import android.view.View;
import d.h.k.m.b;

/* compiled from: ViewCompat */
public final class p extends b<Boolean> {
    public p(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    public void a(View view, Object obj) {
        view.setAccessibilityHeading(((Boolean) obj).booleanValue());
    }

    public boolean a(Object obj, Object obj2) {
        return !a((Boolean) obj, (Boolean) obj2);
    }

    public Object a(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }
}
