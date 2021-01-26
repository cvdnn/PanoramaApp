package e.g.b.c0;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
public final class w extends y {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Method f8526a;

    public w(Method method) {
        this.f8526a = method;
    }

    public <T> T a(Class<T> cls) throws Exception {
        y.b(cls);
        return this.f8526a.invoke(null, new Object[]{cls, Object.class});
    }
}
