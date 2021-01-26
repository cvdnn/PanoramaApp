package e.c.b.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.youth.banner.config.BannerConfig;
import e.c.b.f.a;
import java.lang.ref.SoftReference;

public final class d extends Thread {

    /* renamed from: h reason: collision with root package name */
    public static boolean f5926h = false;

    /* renamed from: a reason: collision with root package name */
    public final Context f5927a;

    /* renamed from: b reason: collision with root package name */
    public final SoftReference<Looper> f5928b = new SoftReference<>(Looper.getMainLooper());

    /* renamed from: c reason: collision with root package name */
    public SoftReference<Handler> f5929c;

    /* renamed from: d reason: collision with root package name */
    public final int f5930d;

    /* renamed from: e reason: collision with root package name */
    public volatile int f5931e = 0;

    /* renamed from: f reason: collision with root package name */
    public a f5932f;

    /* renamed from: g reason: collision with root package name */
    public final Runnable f5933g = new e(this);

    public d(Context context, int i2, byte b2) {
        a bVar;
        this.f5927a = context;
        this.f5930d = BannerConfig.LOOP_TIME;
        if (i2 == 1) {
            bVar = new b(context);
        } else if (i2 == 2) {
            bVar = new c(context);
        } else {
            return;
        }
        this.f5932f = bVar;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder("***isRunning = ");
        sb.append(f5926h);
        sb.append("***");
        a.b(sb.toString());
        if (!f5926h) {
            f5926h = true;
            setName("|AnrWatchThread|");
            a.a("AnrWatchThread start!");
            while (true) {
                if (isInterrupted()) {
                    break;
                }
                int i2 = this.f5931e;
                if (this.f5928b.get() == null) {
                    break;
                }
                try {
                    if (this.f5929c == null || this.f5929c.get() == null) {
                        this.f5929c = new SoftReference<>(new Handler((Looper) this.f5928b.get()));
                    }
                    ((Handler) this.f5929c.get()).post(this.f5933g);
                    Thread.sleep((long) this.f5930d);
                    if (e.c.b.d.D == 0) {
                        f5926h = false;
                        a.d("anr watch thread is breakdown!");
                        break;
                    } else if (this.f5931e == i2) {
                        if (this.f5927a != null && !e.c.b.d.E) {
                            a.a("onAppNotResponding!");
                            a aVar = this.f5932f;
                            if (aVar != null) {
                                aVar.a("/data/anr/traces.txt");
                            }
                        }
                    }
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder("AnrWatchThread Exception: ");
                    sb2.append(e2.getMessage());
                    a.c(sb2.toString());
                }
            }
            f5926h = false;
            f5926h = false;
            a.d("anr watch thread is over!");
        }
    }
}
