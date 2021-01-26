package e.g.b.c0;

import e.a.a.a.a;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: ConstructorConstructor */
public class f implements s<T> {

    /* renamed from: a reason: collision with root package name */
    public final y f8485a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Class f8486b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ Type f8487c;

    public f(g gVar, Class cls, Type type) {
        y yVar;
        this.f8486b = cls;
        this.f8487c = type;
        String str = "newInstance";
        try {
            Class cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            yVar = new u(cls2.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod(str, new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                yVar = new v(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod(str, new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    yVar = new w(declaredMethod3);
                } catch (Exception unused3) {
                    yVar = new x();
                }
            }
        }
        this.f8485a = yVar;
    }

    public T a() {
        try {
            return this.f8485a.a(this.f8486b);
        } catch (Exception e2) {
            StringBuilder a2 = a.a("Unable to invoke no-args constructor for ");
            a2.append(this.f8487c);
            a2.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(a2.toString(), e2);
        }
    }
}
