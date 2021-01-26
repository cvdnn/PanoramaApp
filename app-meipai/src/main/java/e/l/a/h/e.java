package e.l.a.h;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: RequestManager */
public class e {

    /* renamed from: b reason: collision with root package name */
    public static e f8936b;

    /* renamed from: a reason: collision with root package name */
    public final Executor f8937a = Executors.newCachedThreadPool();

    public static e a() {
        if (f8936b == null) {
            synchronized (e.class) {
                if (f8936b == null) {
                    f8936b = new e();
                }
            }
        }
        return f8936b;
    }
}
