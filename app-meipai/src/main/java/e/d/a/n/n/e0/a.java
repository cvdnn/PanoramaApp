package e.d.a.n.n.e0;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor */
public final class a implements ExecutorService {

    /* renamed from: b reason: collision with root package name */
    public static final long f7378b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c reason: collision with root package name */
    public static volatile int f7379c;

    /* renamed from: a reason: collision with root package name */
    public final ExecutorService f7380a;

    /* renamed from: e.d.a.n.n.e0.a$a reason: collision with other inner class name */
    /* compiled from: GlideExecutor */
    public static final class C0084a implements ThreadFactory {

        /* renamed from: a reason: collision with root package name */
        public final String f7381a;

        /* renamed from: b reason: collision with root package name */
        public final b f7382b;

        /* renamed from: c reason: collision with root package name */
        public final boolean f7383c;

        /* renamed from: d reason: collision with root package name */
        public int f7384d;

        /* renamed from: e.d.a.n.n.e0.a$a$a reason: collision with other inner class name */
        /* compiled from: GlideExecutor */
        public class C0085a extends Thread {
            public C0085a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (C0084a.this.f7383c) {
                    StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    C0084a.this.f7382b.a(th);
                }
            }
        }

        public C0084a(String str, b bVar, boolean z) {
            this.f7381a = str;
            this.f7382b = bVar;
            this.f7383c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C0085a aVar;
            StringBuilder sb = new StringBuilder();
            sb.append("glide-");
            sb.append(this.f7381a);
            sb.append("-thread-");
            sb.append(this.f7384d);
            aVar = new C0085a(runnable, sb.toString());
            this.f7384d++;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor */
    public interface b {

        /* renamed from: a reason: collision with root package name */
        public static final b f7386a = new C0086a();

        /* renamed from: b reason: collision with root package name */
        public static final b f7387b = f7386a;

        /* renamed from: e.d.a.n.n.e0.a$b$a reason: collision with other inner class name */
        /* compiled from: GlideExecutor */
        public class C0086a implements b {
            public void a(Throwable th) {
                if (th != null) {
                    String str = "GlideExecutor";
                    if (Log.isLoggable(str, 6)) {
                        Log.e(str, "Request threw uncaught throwable", th);
                    }
                }
            }
        }

        void a(Throwable th);
    }

    public a(ExecutorService executorService) {
        this.f7380a = executorService;
    }

    public static int a() {
        if (f7379c == 0) {
            f7379c = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        return f7379c;
    }

    public static a b() {
        b bVar = b.f7387b;
        String str = "disk-cache";
        if (!TextUtils.isEmpty(str)) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0084a(str, bVar, true));
            return new a(threadPoolExecutor);
        }
        throw new IllegalArgumentException(e.a.a.a.a.a("Name must be non-null and non-empty, but given: ", str));
    }

    public static a c() {
        b bVar = b.f7387b;
        int a2 = a();
        String str = SocialConstants.PARAM_SOURCE;
        if (!TextUtils.isEmpty(str)) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a2, a2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0084a(str, bVar, false));
            return new a(threadPoolExecutor);
        }
        throw new IllegalArgumentException(e.a.a.a.a.a("Name must be non-null and non-empty, but given: ", str));
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f7380a.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f7380a.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f7380a.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f7380a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f7380a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f7380a.isTerminated();
    }

    public void shutdown() {
        this.f7380a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f7380a.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f7380a.submit(runnable);
    }

    public String toString() {
        return this.f7380a.toString();
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f7380a.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f7380a.invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f7380a.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f7380a.submit(callable);
    }
}
