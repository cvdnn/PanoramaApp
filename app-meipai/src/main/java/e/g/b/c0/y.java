package e.g.b.c0;

import e.a.a.a.a;
import java.lang.reflect.Modifier;

/* compiled from: UnsafeAllocator */
public abstract class y {
    public static void b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder a2 = a.a("Interface can't be instantiated! Interface name: ");
            a2.append(cls.getName());
            throw new UnsupportedOperationException(a2.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder a3 = a.a("Abstract class can't be instantiated! Class name: ");
            a3.append(cls.getName());
            throw new UnsupportedOperationException(a3.toString());
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
