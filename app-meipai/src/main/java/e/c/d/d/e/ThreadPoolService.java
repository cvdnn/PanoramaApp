package e.c.d.d.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolService */
public class ThreadPoolService {

    /* renamed from: a reason: collision with root package name */
    public static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    /* renamed from: b reason: collision with root package name */
    public static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    /* renamed from: c reason: collision with root package name */
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: d reason: collision with root package name */
    public static final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

    public static void post(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mainHandler.post(runnable);
        }
    }

    public static ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return scheduledThreadPool.scheduleAtFixedRate(runnable, j2, j3, timeUnit);
    }

    public static ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        return scheduledThreadPool.schedule(runnable, j2, timeUnit);
    }
}
