package d.h.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import d.e.f;
import d.h.e.b.b;
import d.h.e.b.e;
import d.h.e.b.g;

/* compiled from: TypefaceCompat */
public class c {

    /* renamed from: a reason: collision with root package name */
    public static final h f4810a;

    /* renamed from: b reason: collision with root package name */
    public static final f<String, Typeface> f4811b = new f<>(16);

    static {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 28) {
            f4810a = new g();
        } else if (i2 >= 26) {
            f4810a = new f();
        } else {
            if (i2 >= 24) {
                if (e.f4819d == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (e.f4819d != null) {
                    f4810a = new e();
                }
            }
            f4810a = new d();
        }
    }

    public static String a(Resources resources, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(i2));
        String str = "-";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }

    public static Typeface a(Context context, b bVar, Resources resources, int i2, int i3, g gVar, Handler handler, boolean z) {
        Typeface typeface;
        if (bVar instanceof e) {
            e eVar = (e) bVar;
            boolean z2 = false;
            if (!z ? gVar == null : eVar.f4801c == 0) {
                z2 = true;
            }
            typeface = d.h.h.b.a(context, eVar.f4799a, gVar, handler, z2, z ? eVar.f4800b : -1, i3);
        } else {
            typeface = f4810a.a(context, (d.h.e.b.c) bVar, resources, i3);
            if (gVar != null) {
                if (typeface != null) {
                    gVar.a(typeface, handler);
                } else {
                    gVar.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f4811b.a(a(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f4810a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f4811b.a(a(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
