package e.g.b.c0.a0;

import e.g.b.p;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: UnsafeReflectionAccessor */
public final class c extends b {

    /* renamed from: d reason: collision with root package name */
    public static Class f8482d;

    /* renamed from: b reason: collision with root package name */
    public final Object f8483b;

    /* renamed from: c reason: collision with root package name */
    public final Field f8484c;

    public c() {
        Object obj;
        Field field = null;
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            f8482d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f8483b = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.f8484c = field;
    }

    public void a(AccessibleObject accessibleObject) {
        boolean z = false;
        if (!(this.f8483b == null || this.f8484c == null)) {
            try {
                long longValue = ((Long) f8482d.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.f8483b, new Object[]{this.f8484c})).longValue();
                f8482d.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.f8483b, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.valueOf(true)});
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Gson couldn't modify fields for ");
                sb.append(accessibleObject);
                sb.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
                throw new p(sb.toString(), e2);
            }
        }
    }
}
