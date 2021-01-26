package d.h.k;

import android.view.View;
import d.h.k.m.b;

/* compiled from: ViewCompat */
public final class n extends b<Boolean> {
    public n(int i2, Class cls, int i3) {
        super(i2, cls, i3);
    }

    public void a(View view, Object obj) {
        view.setScreenReaderFocusable(((Boolean) obj).booleanValue());
    }

    public boolean a(Object obj, Object obj2) {
        return !a((Boolean) obj, (Boolean) obj2);
    }

    public Object a(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }
}
