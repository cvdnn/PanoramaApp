package g.d0.e;

import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: RouteException */
public final class e extends RuntimeException {

    /* renamed from: b reason: collision with root package name */
    public static final Method f9208b;

    /* renamed from: a reason: collision with root package name */
    public IOException f9209a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f9208b = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f9209a = iOException;
    }
}
