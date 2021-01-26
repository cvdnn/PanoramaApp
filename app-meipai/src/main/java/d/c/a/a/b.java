package d.c.a.a;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultTaskExecutor */
public class b extends c {

    /* renamed from: a reason: collision with root package name */
    public final Object f4524a = new Object();

    /* renamed from: b reason: collision with root package name */
    public final ExecutorService f4525b = Executors.newFixedThreadPool(2, new a(this));

    /* compiled from: DefaultTaskExecutor */
    public class a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        public final AtomicInteger f4526a = new AtomicInteger(0);

        public a(b bVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f4526a.getAndIncrement())}));
            return thread;
        }
    }

    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
