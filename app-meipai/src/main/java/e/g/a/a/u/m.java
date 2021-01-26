package e.g.a.a.u;

import android.content.Context;
import android.content.res.TypedArray;
import d.n.a.c;
import e.c.f.n.n;
import e.g.a.a.b;

/* compiled from: MaterialDatePicker */
public final class m<S> extends c {
    public static boolean a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(n.a(context, b.materialCalendarStyle, f.class.getCanonicalName()), new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }
}
