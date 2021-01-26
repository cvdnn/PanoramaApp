package e.c.f.f;

import dalvik.system.DexClassLoader;
import e.c.f.c;

/* compiled from: PluginloaderDexClassLoader */
public final class f extends DexClassLoader {
    public f(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (Throwable unused) {
            c.d();
            return findLoadedClass;
        }
    }

    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (Throwable unused) {
            }
            if (findLoadedClass == null) {
                try {
                    if (getParent() != null) {
                        findLoadedClass = getParent().loadClass(str);
                    } else {
                        findLoadedClass = (Class) getClass().getDeclaredMethod("findBootstrapClassOrNull", new Class[]{String.class}).invoke(this, new Object[]{str});
                    }
                } catch (Throwable unused2) {
                    c.d();
                }
            }
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z);
            } catch (Throwable unused3) {
                c.d();
            }
        }
        return findLoadedClass;
    }
}
