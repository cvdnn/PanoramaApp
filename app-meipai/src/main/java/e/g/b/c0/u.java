package e.g.b.c0;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
public final class u extends y {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Method f8522a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Object f8523b;

    public u(Method method, Object obj) {
        this.f8522a = method;
        this.f8523b = obj;
    }

    public <T> T a(Class<T> cls) throws Exception {
        y.b(cls);
        return this.f8522a.invoke(this.f8523b, new Object[]{cls});
    }
}
