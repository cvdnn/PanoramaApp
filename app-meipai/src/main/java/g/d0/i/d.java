package g.d0.i;

import e.a.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod */
public class d<T> {

    /* renamed from: a reason: collision with root package name */
    public final Class<?> f9458a;

    /* renamed from: b reason: collision with root package name */
    public final String f9459b;

    /* renamed from: c reason: collision with root package name */
    public final Class[] f9460c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.f9458a = cls;
        this.f9459b = str;
        this.f9460c = clsArr;
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpectedly could not call: ");
                sb.append(a2);
                AssertionError assertionError = new AssertionError(sb.toString());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } else {
            StringBuilder a3 = a.a("Method ");
            a3.append(this.f9459b);
            a3.append(" not supported for object ");
            a3.append(t);
            throw new AssertionError(a3.toString());
        }
    }

    public Object b(T t, Object... objArr) {
        try {
            Method a2 = a(t.getClass());
            if (a2 == null) {
                return null;
            }
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r4.getModifiers() & 1) == 0) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method a(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.f9459b
            r1 = 0
            if (r0 == 0) goto L_0x0026
            java.lang.Class[] r2 = r3.f9460c
            java.lang.reflect.Method r4 = r4.getMethod(r0, r2)     // Catch:{ NoSuchMethodException -> 0x0013 }
            int r0 = r4.getModifiers()     // Catch:{ NoSuchMethodException -> 0x0014 }
            r0 = r0 & 1
            if (r0 != 0) goto L_0x0014
        L_0x0013:
            r4 = r1
        L_0x0014:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<?> r0 = r3.f9458a
            if (r0 == 0) goto L_0x0025
            java.lang.Class r2 = r4.getReturnType()
            boolean r0 = r0.isAssignableFrom(r2)
            if (r0 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.i.d.a(java.lang.Class):java.lang.reflect.Method");
    }
}
