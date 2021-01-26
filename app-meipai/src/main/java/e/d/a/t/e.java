package e.d.a.t;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: Executors */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static final Executor f7910a = new a();

    /* renamed from: b reason: collision with root package name */
    public static final Executor f7911b = new b();

    /* compiled from: Executors */
    public class a implements Executor {

        /* renamed from: a reason: collision with root package name */
        public final Handler f7912a = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f7912a.post(runnable);
        }
    }

    /* compiled from: Executors */
    public class b implements Executor {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
}
