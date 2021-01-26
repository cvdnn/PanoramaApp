package e.g.b.c0;

import e.a.a.a.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor */
public class h implements s<T> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Constructor f8494a;

    public h(g gVar, Constructor constructor) {
        this.f8494a = constructor;
    }

    public T a() {
        String str = " with no args";
        String str2 = "Failed to invoke ";
        try {
            return this.f8494a.newInstance(null);
        } catch (InstantiationException e2) {
            StringBuilder a2 = a.a(str2);
            a2.append(this.f8494a);
            a2.append(str);
            throw new RuntimeException(a2.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder a3 = a.a(str2);
            a3.append(this.f8494a);
            a3.append(str);
            throw new RuntimeException(a3.toString(), e3.getTargetException());
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        }
    }
}
