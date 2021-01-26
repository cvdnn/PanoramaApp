package d.n.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.e;
import d.e.h;
import e.a.a.a.a;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FragmentFactory */
public class g {

    /* renamed from: a reason: collision with root package name */
    public static final h<String, Class<?>> f5120a = new h<>();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = (Class) f5120a.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f5120a.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        String str2 = "Unable to instantiate fragment ";
        try {
            return c(classLoader, str);
        } catch (ClassNotFoundException e2) {
            throw new e(a.a(str2, str, ": make sure class name exists"), e2);
        } catch (ClassCastException e3) {
            throw new e(a.a(str2, str, ": make sure class is a valid subclass of Fragment"), e3);
        }
    }

    public Fragment a(ClassLoader classLoader, String str) {
        String str2 = ": make sure class name exists, is public, and has an empty constructor that is public";
        String str3 = "Unable to instantiate fragment ";
        try {
            return (Fragment) d(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e2) {
            throw new e(a.a(str3, str, str2), e2);
        } catch (IllegalAccessException e3) {
            throw new e(a.a(str3, str, str2), e3);
        } catch (NoSuchMethodException e4) {
            throw new e(a.a(str3, str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new e(a.a(str3, str, ": calling Fragment constructor caused an exception"), e5);
        }
    }
}
