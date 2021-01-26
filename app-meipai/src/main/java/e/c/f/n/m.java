package e.c.f.n;

import e.c.f.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolManager */
public class m {

    /* renamed from: b reason: collision with root package name */
    public static final int f7078b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c reason: collision with root package name */
    public static volatile m f7079c;

    /* renamed from: a reason: collision with root package name */
    public ThreadPoolExecutor f7080a = null;

    public m() {
        int max = Math.max(7, (f7078b * 2) + 3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f7080a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public final void a(Runnable runnable) {
        try {
            this.f7080a.execute(runnable);
        } catch (Throwable unused) {
            c.d();
        }
    }

    public static m a() {
        if (f7079c == null) {
            try {
                synchronized (m.class) {
                    if (f7079c == null) {
                        f7079c = new m();
                    }
                }
            } catch (Throwable unused) {
                c.d();
            }
        }
        return f7079c;
    }
}
