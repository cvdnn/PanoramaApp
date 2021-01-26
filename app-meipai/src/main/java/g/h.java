package g;

import g.d0.e.c;
import g.d0.e.d;
import g.d0.e.g;
import g.d0.i.e;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool */
public final class h {

    /* renamed from: g reason: collision with root package name */
    public static final Executor f9489g;

    /* renamed from: a reason: collision with root package name */
    public final int f9490a;

    /* renamed from: b reason: collision with root package name */
    public final long f9491b;

    /* renamed from: c reason: collision with root package name */
    public final Runnable f9492c = new a();

    /* renamed from: d reason: collision with root package name */
    public final Deque<c> f9493d = new ArrayDeque();

    /* renamed from: e reason: collision with root package name */
    public final d f9494e = new d();

    /* renamed from: f reason: collision with root package name */
    public boolean f9495f;

    /* compiled from: ConnectionPool */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                g.h r0 = g.h.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.a(r1)
                r2 = -1
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                g.h r2 = g.h.this
                monitor-enter(r2)
                g.h r3 = g.h.this     // Catch:{ InterruptedException -> 0x002a }
                int r0 = (int) r0     // Catch:{ InterruptedException -> 0x002a }
                r3.wait(r4, r0)     // Catch:{ InterruptedException -> 0x002a }
                goto L_0x002a
            L_0x0028:
                r0 = move-exception
                goto L_0x002c
            L_0x002a:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                goto L_0x0000
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0028 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: g.h.a.run():void");
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), g.d0.c.a("OkHttp ConnectionPool", true));
        f9489g = threadPoolExecutor;
    }

    public h(int i2, long j2, TimeUnit timeUnit) {
        this.f9490a = i2;
        this.f9491b = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("keepAliveDuration <= 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public long a(long j2) {
        synchronized (this) {
            c cVar = null;
            long j3 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (c cVar2 : this.f9493d) {
                if (a(cVar2, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - cVar2.o;
                    if (j4 > j3) {
                        cVar = cVar2;
                        j3 = j4;
                    }
                }
            }
            if (j3 < this.f9491b) {
                if (i2 <= this.f9490a) {
                    if (i2 > 0) {
                        long j5 = this.f9491b - j3;
                        return j5;
                    } else if (i3 > 0) {
                        long j6 = this.f9491b;
                        return j6;
                    } else {
                        this.f9495f = false;
                        return -1;
                    }
                }
            }
            this.f9493d.remove(cVar);
            g.d0.c.a(cVar.f9201e);
            return 0;
        }
    }

    public final int a(c cVar, long j2) {
        List<Reference<g>> list = cVar.n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = (Reference) list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                g.d0.e.g.a aVar = (g.d0.e.g.a) reference;
                StringBuilder a2 = e.a.a.a.a.a("A connection to ");
                a2.append(cVar.f9199c.f9144a.f9126a);
                a2.append(" was leaked. Did you forget to close a response body?");
                e.f9461a.a(a2.toString(), aVar.f9230a);
                list.remove(i2);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j2 - this.f9491b;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
