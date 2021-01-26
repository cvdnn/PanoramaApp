package e.d.a.n.n;

import android.os.Process;
import e.c.f.n.n;
import e.d.a.n.f;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public final boolean f7278a;

    /* renamed from: b reason: collision with root package name */
    public final Map<f, b> f7279b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public final ReferenceQueue<q<?>> f7280c = new ReferenceQueue<>();

    /* renamed from: d reason: collision with root package name */
    public e.d.a.n.n.q.a f7281d;

    /* renamed from: e.d.a.n.n.a$a reason: collision with other inner class name */
    /* compiled from: ActiveResources */
    public class C0081a implements ThreadFactory {

        /* renamed from: e.d.a.n.n.a$a$a reason: collision with other inner class name */
        /* compiled from: ActiveResources */
        public class C0082a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ Runnable f7282a;

            public C0082a(C0081a aVar, Runnable runnable) {
                this.f7282a = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f7282a.run();
            }
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(new C0082a(this, runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources */
    public static final class b extends WeakReference<q<?>> {

        /* renamed from: a reason: collision with root package name */
        public final f f7283a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f7284b;

        /* renamed from: c reason: collision with root package name */
        public w<?> f7285c;

        public b(f fVar, q<?> qVar, ReferenceQueue<? super q<?>> referenceQueue, boolean z) {
            w<Z> wVar;
            super(qVar, referenceQueue);
            String str = "Argument must not be null";
            n.a(fVar, str);
            this.f7283a = fVar;
            if (!qVar.f7490a || !z) {
                wVar = null;
            } else {
                wVar = qVar.f7492c;
                n.a(wVar, str);
            }
            this.f7285c = wVar;
            this.f7284b = qVar.f7490a;
        }
    }

    public a(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new C0081a());
        this.f7278a = z;
        newSingleThreadExecutor.execute(new b(this));
    }

    public void a(e.d.a.n.n.q.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f7281d = aVar;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized e.d.a.n.n.q<?> b(e.d.a.n.f r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<e.d.a.n.f, e.d.a.n.n.a$b> r0 = r1.f7279b     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            e.d.a.n.n.a$b r2 = (e.d.a.n.n.a.b) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            e.d.a.n.n.q r0 = (e.d.a.n.n.q) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.a(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.a.b(e.d.a.n.f):e.d.a.n.n.q");
    }

    public synchronized void a(f fVar, q<?> qVar) {
        b bVar = (b) this.f7279b.put(fVar, new b(fVar, qVar, this.f7280c, this.f7278a));
        if (bVar != null) {
            bVar.f7285c = null;
            bVar.clear();
        }
    }

    public synchronized void a(f fVar) {
        b bVar = (b) this.f7279b.remove(fVar);
        if (bVar != null) {
            bVar.f7285c = null;
            bVar.clear();
        }
    }

    public void a(b bVar) {
        synchronized (this) {
            this.f7279b.remove(bVar.f7283a);
            if (bVar.f7284b) {
                if (bVar.f7285c != null) {
                    q qVar = new q(bVar.f7285c, true, false, bVar.f7283a, this.f7281d);
                    this.f7281d.a(bVar.f7283a, qVar);
                }
            }
        }
    }
}
