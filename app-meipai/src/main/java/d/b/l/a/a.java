package d.b.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import d.b.p.n0;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* compiled from: AppCompatResources */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f4061a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<Object>> f4062b = new WeakHashMap<>(0);

    /* renamed from: c reason: collision with root package name */
    public static final Object f4063c = new Object();

    public static ColorStateList a(Context context, int i2) {
        return context.getColorStateList(i2);
    }

    public static Drawable b(Context context, int i2) {
        return n0.a().b(context, i2);
    }
}
