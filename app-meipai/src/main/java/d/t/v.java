package d.t;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import d.h.k.m;

/* compiled from: ViewUtils */
public class v {

    /* renamed from: a reason: collision with root package name */
    public static final b0 f5520a;

    /* renamed from: b reason: collision with root package name */
    public static final Property<View, Float> f5521b = new a(Float.class, "translationAlpha");

    /* compiled from: ViewUtils */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            return Float.valueOf(v.b((View) obj));
        }

        public void set(Object obj, Object obj2) {
            v.f5520a.a((View) obj, ((Float) obj2).floatValue());
        }
    }

    /* compiled from: ViewUtils */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        public Object get(Object obj) {
            return m.f((View) obj);
        }

        public void set(Object obj, Object obj2) {
            m.a((View) obj, (Rect) obj2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 29) {
            f5520a = new a0();
        } else {
            f5520a = new z();
        }
        new b(Rect.class, "clipBounds");
    }

    public static u a(View view) {
        return new t(view);
    }

    public static float b(View view) {
        return f5520a.b(view);
    }

    public static f0 c(View view) {
        return new e0(view);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f5520a.a(view, i2, i3, i4, i5);
    }
}
