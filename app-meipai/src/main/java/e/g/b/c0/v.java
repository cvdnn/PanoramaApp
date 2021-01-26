package e.g.b.c0;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
public final class v extends y {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Method f8524a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ int f8525b;

    public v(Method method, int i2) {
        this.f8524a = method;
        this.f8525b = i2;
    }

    public <T> T a(Class<T> cls) throws Exception {
        y.b(cls);
        return this.f8524a.invoke(null, new Object[]{cls, Integer.valueOf(this.f8525b)});
    }
}
