package e.d.a.n.n;

import e.c.f.n.n;
import e.d.a.n.f;
import e.d.a.r.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob */
public class m<R> implements e.d.a.n.n.i.a<R>, e.d.a.t.k.a.d {
    public static final c y = new c();

    /* renamed from: a reason: collision with root package name */
    public final e f7464a = new e();

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.t.k.d f7465b = new e.d.a.t.k.d.b();

    /* renamed from: c reason: collision with root package name */
    public final e.d.a.n.n.q.a f7466c;

    /* renamed from: d reason: collision with root package name */
    public final d.h.j.c<m<?>> f7467d;

    /* renamed from: e reason: collision with root package name */
    public final c f7468e;

    /* renamed from: f reason: collision with root package name */
    public final n f7469f;

    /* renamed from: g reason: collision with root package name */
    public final e.d.a.n.n.e0.a f7470g;

    /* renamed from: h reason: collision with root package name */
    public final e.d.a.n.n.e0.a f7471h;

    /* renamed from: i reason: collision with root package name */
    public final e.d.a.n.n.e0.a f7472i;

    /* renamed from: j reason: collision with root package name */
    public final e.d.a.n.n.e0.a f7473j;
    public final AtomicInteger k = new AtomicInteger();
    public f l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public w<?> q;
    public e.d.a.n.a r;
    public boolean s;
    public r t;
    public boolean u;
    public q<?> v;
    public i<R> w;
    public volatile boolean x;

    /* compiled from: EngineJob */
    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.r.f f7474a;

        public a(e.d.a.r.f fVar) {
            this.f7474a = fVar;
        }

        public void run() {
            g gVar = (g) this.f7474a;
            gVar.f7866b.a();
            synchronized (gVar.f7867c) {
                synchronized (m.this) {
                    if (m.this.f7464a.f7480a.contains(new d(this.f7474a, e.d.a.t.e.f7911b))) {
                        m mVar = m.this;
                        e.d.a.r.f fVar = this.f7474a;
                        if (mVar != null) {
                            try {
                                ((g) fVar).a(mVar.t, 5);
                            } catch (Throwable th) {
                                throw new c(th);
                            }
                        } else {
                            throw null;
                        }
                    }
                    m.this.b();
                }
            }
        }
    }

    /* compiled from: EngineJob */
    public class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.r.f f7476a;

        public b(e.d.a.r.f fVar) {
            this.f7476a = fVar;
        }

        public void run() {
            g gVar = (g) this.f7476a;
            gVar.f7866b.a();
            synchronized (gVar.f7867c) {
                synchronized (m.this) {
                    if (m.this.f7464a.f7480a.contains(new d(this.f7476a, e.d.a.t.e.f7911b))) {
                        m.this.v.a();
                        m mVar = m.this;
                        e.d.a.r.f fVar = this.f7476a;
                        if (mVar != null) {
                            try {
                                ((g) fVar).a((w<?>) mVar.v, mVar.r);
                                m.this.a(this.f7476a);
                            } catch (Throwable th) {
                                throw new c(th);
                            }
                        } else {
                            throw null;
                        }
                    }
                    m.this.b();
                }
            }
        }
    }

    /* compiled from: EngineJob */
    public static class c {
    }

    /* compiled from: EngineJob */
    public static final class d {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.r.f f7478a;

        /* renamed from: b reason: collision with root package name */
        public final Executor f7479b;

        public d(e.d.a.r.f fVar, Executor executor) {
            this.f7478a = fVar;
            this.f7479b = executor;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            return this.f7478a.equals(((d) obj).f7478a);
        }

        public int hashCode() {
            return this.f7478a.hashCode();
        }
    }

    /* compiled from: EngineJob */
    public static final class e implements Iterable<d> {

        /* renamed from: a reason: collision with root package name */
        public final List<d> f7480a = new ArrayList(2);

        public boolean isEmpty() {
            return this.f7480a.isEmpty();
        }

        public Iterator<d> iterator() {
            return this.f7480a.iterator();
        }
    }

    public m(e.d.a.n.n.e0.a aVar, e.d.a.n.n.e0.a aVar2, e.d.a.n.n.e0.a aVar3, e.d.a.n.n.e0.a aVar4, n nVar, e.d.a.n.n.q.a aVar5, d.h.j.c<m<?>> cVar) {
        c cVar2 = y;
        this.f7470g = aVar;
        this.f7471h = aVar2;
        this.f7472i = aVar3;
        this.f7473j = aVar4;
        this.f7469f = nVar;
        this.f7466c = aVar5;
        this.f7467d = cVar;
        this.f7468e = cVar2;
    }

    public synchronized m<R> a(f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.l = fVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(e.d.a.n.n.i<R> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.w = r3     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0033
            e.d.a.n.n.i$g r0 = e.d.a.n.n.i.g.INITIALIZE     // Catch:{ all -> 0x0035 }
            e.d.a.n.n.i$g r0 = r3.a(r0)     // Catch:{ all -> 0x0035 }
            e.d.a.n.n.i$g r1 = e.d.a.n.n.i.g.RESOURCE_CACHE     // Catch:{ all -> 0x0035 }
            if (r0 == r1) goto L_0x0016
            e.d.a.n.n.i$g r1 = e.d.a.n.n.i.g.DATA_CACHE     // Catch:{ all -> 0x0035 }
            if (r0 != r1) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            if (r0 == 0) goto L_0x001c
            e.d.a.n.n.e0.a r0 = r2.f7470g     // Catch:{ all -> 0x0035 }
            goto L_0x002c
        L_0x001c:
            boolean r0 = r2.n     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0023
            e.d.a.n.n.e0.a r0 = r2.f7472i     // Catch:{ all -> 0x0035 }
            goto L_0x002c
        L_0x0023:
            boolean r0 = r2.o     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x002a
            e.d.a.n.n.e0.a r0 = r2.f7473j     // Catch:{ all -> 0x0035 }
            goto L_0x002c
        L_0x002a:
            e.d.a.n.n.e0.a r0 = r2.f7471h     // Catch:{ all -> 0x0035 }
        L_0x002c:
            java.util.concurrent.ExecutorService r0 = r0.f7380a     // Catch:{ all -> 0x0035 }
            r0.execute(r3)     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            return
        L_0x0033:
            r3 = 0
            throw r3     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.m.b(e.d.a.n.n.i):void");
    }

    public final boolean c() {
        return this.u || this.s || this.x;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        ((e.d.a.n.n.l) r5.f7469f).a(r5, r1, null);
        r0 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r0.hasNext() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        r1 = (e.d.a.n.n.m.d) r0.next();
        r1.f7479b.execute(new e.d.a.n.n.m.a(r5, r1.f7478a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r5 = this;
            monitor-enter(r5)
            e.d.a.t.k.d r0 = r5.f7465b     // Catch:{ all -> 0x006e }
            r0.a()     // Catch:{ all -> 0x006e }
            boolean r0 = r5.x     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x000f
            r5.f()     // Catch:{ all -> 0x006e }
            monitor-exit(r5)     // Catch:{ all -> 0x006e }
            return
        L_0x000f:
            e.d.a.n.n.m$e r0 = r5.f7464a     // Catch:{ all -> 0x006e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x0066
            boolean r0 = r5.u     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x005e
            r0 = 1
            r5.u = r0     // Catch:{ all -> 0x006e }
            e.d.a.n.f r1 = r5.l     // Catch:{ all -> 0x006e }
            e.d.a.n.n.m$e r2 = r5.f7464a     // Catch:{ all -> 0x006e }
            r3 = 0
            if (r2 == 0) goto L_0x005d
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x006e }
            java.util.List<e.d.a.n.n.m$d> r2 = r2.f7480a     // Catch:{ all -> 0x006e }
            r4.<init>(r2)     // Catch:{ all -> 0x006e }
            int r2 = r4.size()     // Catch:{ all -> 0x006e }
            int r2 = r2 + r0
            r5.a(r2)     // Catch:{ all -> 0x006e }
            monitor-exit(r5)     // Catch:{ all -> 0x006e }
            e.d.a.n.n.n r0 = r5.f7469f
            e.d.a.n.n.l r0 = (e.d.a.n.n.l) r0
            r0.a(r5, r1, r3)
            java.util.Iterator r0 = r4.iterator()
        L_0x0040:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r0.next()
            e.d.a.n.n.m$d r1 = (e.d.a.n.n.m.d) r1
            java.util.concurrent.Executor r2 = r1.f7479b
            e.d.a.n.n.m$a r3 = new e.d.a.n.n.m$a
            e.d.a.r.f r1 = r1.f7478a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0040
        L_0x0059:
            r5.b()
            return
        L_0x005d:
            throw r3     // Catch:{ all -> 0x006e }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x006e }
            throw r0     // Catch:{ all -> 0x006e }
        L_0x0066:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x006e }
            throw r0     // Catch:{ all -> 0x006e }
        L_0x006e:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.m.d():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        ((e.d.a.n.n.l) r8.f7469f).a(r8, r0, r1);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r0.hasNext() == false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        r1 = (e.d.a.n.n.m.d) r0.next();
        r1.f7479b.execute(new e.d.a.n.n.m.b(r8, r1.f7478a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            monitor-enter(r8)
            e.d.a.t.k.d r0 = r8.f7465b     // Catch:{ all -> 0x008b }
            r0.a()     // Catch:{ all -> 0x008b }
            boolean r0 = r8.x     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x0014
            e.d.a.n.n.w<?> r0 = r8.q     // Catch:{ all -> 0x008b }
            r0.b()     // Catch:{ all -> 0x008b }
            r8.f()     // Catch:{ all -> 0x008b }
            monitor-exit(r8)     // Catch:{ all -> 0x008b }
            return
        L_0x0014:
            e.d.a.n.n.m$e r0 = r8.f7464a     // Catch:{ all -> 0x008b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0083
            boolean r0 = r8.s     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x007b
            e.d.a.n.n.m$c r0 = r8.f7468e     // Catch:{ all -> 0x008b }
            e.d.a.n.n.w<?> r2 = r8.q     // Catch:{ all -> 0x008b }
            boolean r3 = r8.m     // Catch:{ all -> 0x008b }
            e.d.a.n.f r5 = r8.l     // Catch:{ all -> 0x008b }
            e.d.a.n.n.q$a r6 = r8.f7466c     // Catch:{ all -> 0x008b }
            r7 = 0
            if (r0 == 0) goto L_0x007a
            e.d.a.n.n.q r0 = new e.d.a.n.n.q     // Catch:{ all -> 0x008b }
            r4 = 1
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x008b }
            r8.v = r0     // Catch:{ all -> 0x008b }
            r0 = 1
            r8.s = r0     // Catch:{ all -> 0x008b }
            e.d.a.n.n.m$e r1 = r8.f7464a     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0079
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x008b }
            java.util.List<e.d.a.n.n.m$d> r1 = r1.f7480a     // Catch:{ all -> 0x008b }
            r2.<init>(r1)     // Catch:{ all -> 0x008b }
            int r1 = r2.size()     // Catch:{ all -> 0x008b }
            int r1 = r1 + r0
            r8.a(r1)     // Catch:{ all -> 0x008b }
            e.d.a.n.f r0 = r8.l     // Catch:{ all -> 0x008b }
            e.d.a.n.n.q<?> r1 = r8.v     // Catch:{ all -> 0x008b }
            monitor-exit(r8)     // Catch:{ all -> 0x008b }
            e.d.a.n.n.n r3 = r8.f7469f
            e.d.a.n.n.l r3 = (e.d.a.n.n.l) r3
            r3.a(r8, r0, r1)
            java.util.Iterator r0 = r2.iterator()
        L_0x005c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0075
            java.lang.Object r1 = r0.next()
            e.d.a.n.n.m$d r1 = (e.d.a.n.n.m.d) r1
            java.util.concurrent.Executor r2 = r1.f7479b
            e.d.a.n.n.m$b r3 = new e.d.a.n.n.m$b
            e.d.a.r.f r1 = r1.f7478a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x005c
        L_0x0075:
            r8.b()
            return
        L_0x0079:
            throw r7     // Catch:{ all -> 0x008b }
        L_0x007a:
            throw r7     // Catch:{ all -> 0x008b }
        L_0x007b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x008b }
            throw r0     // Catch:{ all -> 0x008b }
        L_0x0083:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008b }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x008b }
            throw r0     // Catch:{ all -> 0x008b }
        L_0x008b:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x008b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.m.e():void");
    }

    public final synchronized void f() {
        if (this.l != null) {
            this.f7464a.f7480a.clear();
            this.l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            i<R> iVar = this.w;
            if (iVar.f7407g.b(false)) {
                iVar.f();
            }
            this.w = null;
            this.t = null;
            this.r = null;
            this.f7467d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void a(e.d.a.r.f fVar, Executor executor) {
        this.f7465b.a();
        this.f7464a.f7480a.add(new d(fVar, executor));
        boolean z = true;
        if (this.s) {
            a(1);
            executor.execute(new b(fVar));
        } else if (this.u) {
            a(1);
            executor.execute(new a(fVar));
        } else {
            if (this.x) {
                z = false;
            }
            n.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public void b() {
        q<?> qVar;
        synchronized (this) {
            this.f7465b.a();
            n.a(c(), "Not yet complete!");
            int decrementAndGet = this.k.decrementAndGet();
            n.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                qVar = this.v;
                f();
            } else {
                qVar = null;
            }
        }
        if (qVar != null) {
            qVar.d();
        }
    }

    public synchronized void a(e.d.a.r.f fVar) {
        this.f7465b.a();
        this.f7464a.f7480a.remove(new d(fVar, e.d.a.t.e.f7911b));
        if (this.f7464a.isEmpty()) {
            boolean z = true;
            if (!c()) {
                this.x = true;
                i<R> iVar = this.w;
                iVar.E = true;
                g gVar = iVar.C;
                if (gVar != null) {
                    gVar.cancel();
                }
                ((l) this.f7469f).a(this, this.l);
            }
            if (!this.s) {
                if (!this.u) {
                    z = false;
                }
            }
            if (z && this.k.get() == 0) {
                f();
            }
        }
    }

    public void a(i<?> iVar) {
        e.d.a.n.n.e0.a aVar = this.n ? this.f7472i : this.o ? this.f7473j : this.f7471h;
        aVar.f7380a.execute(iVar);
    }

    public synchronized void a(int i2) {
        n.a(c(), "Not yet complete!");
        if (this.k.getAndAdd(i2) == 0 && this.v != null) {
            this.v.a();
        }
    }

    public void a(w<R> wVar, e.d.a.n.a aVar) {
        synchronized (this) {
            this.q = wVar;
            this.r = aVar;
        }
        e();
    }

    public void a(r rVar) {
        synchronized (this) {
            this.t = rVar;
        }
        d();
    }

    public e.d.a.t.k.d a() {
        return this.f7465b;
    }
}
