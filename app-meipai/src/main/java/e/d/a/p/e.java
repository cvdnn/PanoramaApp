package e.d.a.p;

import e.a.a.a.a;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* compiled from: ManifestParser */
public final class e {
    public static c a(String str) {
        try {
            Class cls = Class.forName(str);
            try {
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof c) {
                    return (c) newInstance;
                }
                throw new RuntimeException(a.a("Expected instanceof GlideModule, but found: ", newInstance));
            } catch (InstantiationException e2) {
                a(cls, e2);
                throw null;
            } catch (IllegalAccessException e3) {
                a(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                a(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                a(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    public static void a(Class<?> cls, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to instantiate GlideModule implementation for ");
        sb.append(cls);
        throw new RuntimeException(sb.toString(), exc);
    }
}
