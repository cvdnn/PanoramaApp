package e.c.e.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: TranslucentInvocationHandler */
public class f implements InvocationHandler {

    /* renamed from: a reason: collision with root package name */
    public b f6901a;

    public f(b bVar) {
        this.f6901a = bVar;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.f6901a != null) {
            try {
                this.f6901a.onTranslucent(objArr[0].booleanValue());
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f6901a.onTranslucent(false);
            }
        }
        return null;
    }
}
