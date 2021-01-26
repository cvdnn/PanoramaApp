package e.d.a.n.n;

import android.os.Build.VERSION;
import android.util.Log;
import e.d.a.n.h;
import e.d.a.n.k;
import e.d.a.n.p.c.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodeJob */
public class i<R> implements e.d.a.n.n.g.a, Runnable, Comparable<i<?>>, e.d.a.t.k.a.d {
    public e.d.a.n.a A;
    public e.d.a.n.m.d<?> B;
    public volatile g C;
    public volatile boolean D;
    public volatile boolean E;

    /* renamed from: a reason: collision with root package name */
    public final h<R> f7401a = new h<>();

    /* renamed from: b reason: collision with root package name */
    public final List<Throwable> f7402b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public final e.d.a.t.k.d f7403c = new e.d.a.t.k.d.b();

    /* renamed from: d reason: collision with root package name */
    public final d f7404d;

    /* renamed from: e reason: collision with root package name */
    public final d.h.j.c<i<?>> f7405e;

    /* renamed from: f reason: collision with root package name */
    public final c<?> f7406f = new c<>();

    /* renamed from: g reason: collision with root package name */
    public final e f7407g = new e();

    /* renamed from: h reason: collision with root package name */
    public e.d.a.d f7408h;

    /* renamed from: i reason: collision with root package name */
    public e.d.a.n.f f7409i;

    /* renamed from: j reason: collision with root package name */
    public e.d.a.f f7410j;
    public o k;
    public int l;
    public int m;
    public k n;
    public h o;
    public a<R> p;
    public int q;
    public g r;
    public f s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public e.d.a.n.f x;
    public e.d.a.n.f y;
    public Object z;

    /* compiled from: DecodeJob */
    public interface a<R> {
    }

    /* compiled from: DecodeJob */
    public final class b<Z> implements e.d.a.n.n.j.a<Z> {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.n.a f7411a;

        public b(e.d.a.n.a aVar) {
            this.f7411a = aVar;
        }
    }

    /* compiled from: DecodeJob */
    public static class c<Z> {

        /* renamed from: a reason: collision with root package name */
        public e.d.a.n.f f7413a;

        /* renamed from: b reason: collision with root package name */
        public k<Z> f7414b;

        /* renamed from: c reason: collision with root package name */
        public v<Z> f7415c;
    }

    /* compiled from: DecodeJob */
    public interface d {
    }

    /* compiled from: DecodeJob */
    public static class e {

        /* renamed from: a reason: collision with root package name */
        public boolean f7416a;

        /* renamed from: b reason: collision with root package name */
        public boolean f7417b;

        /* renamed from: c reason: collision with root package name */
        public boolean f7418c;

        public synchronized boolean a() {
            this.f7417b = true;
            return a(false);
        }

        public synchronized boolean b(boolean z) {
            this.f7416a = true;
            return a(z);
        }

        public synchronized void c() {
            this.f7417b = false;
            this.f7416a = false;
            this.f7418c = false;
        }

        public final boolean a(boolean z) {
            return (this.f7418c || z || this.f7417b) && this.f7416a;
        }

        public synchronized boolean b() {
            this.f7418c = true;
            return a(false);
        }
    }

    /* compiled from: DecodeJob */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: DecodeJob */
    public enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public i(d dVar, d.h.j.c<i<?>> cVar) {
        this.f7404d = dVar;
        this.f7405e = cVar;
    }

    public final g a(g gVar) {
        g gVar2;
        g gVar3;
        int ordinal = gVar.ordinal();
        if (ordinal == 0) {
            if (this.n.b()) {
                gVar2 = g.RESOURCE_CACHE;
            } else {
                gVar2 = a(g.RESOURCE_CACHE);
            }
            return gVar2;
        } else if (ordinal == 1) {
            if (this.n.a()) {
                gVar3 = g.DATA_CACHE;
            } else {
                gVar3 = a(g.DATA_CACHE);
            }
            return gVar3;
        } else if (ordinal == 2) {
            return this.u ? g.FINISHED : g.SOURCE;
        } else if (ordinal == 3 || ordinal == 5) {
            return g.FINISHED;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(gVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void b() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        ((m) this.p).a(this);
    }

    public final void c() {
        w wVar;
        v vVar;
        w wVar2;
        c<?> cVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.t;
            StringBuilder a2 = e.a.a.a.a.a("data: ");
            a2.append(this.z);
            a2.append(", cache key: ");
            a2.append(this.x);
            a2.append(", fetcher: ");
            a2.append(this.B);
            a("Retrieved data", j2, a2.toString());
        }
        try {
            wVar = a(this.B, (Data) this.z, this.A);
        } catch (r e2) {
            e.d.a.n.f fVar = this.y;
            e.d.a.n.a aVar = this.A;
            e2.f7499b = fVar;
            e2.f7500c = aVar;
            e2.f7501d = null;
            this.f7402b.add(e2);
            wVar = 0;
        }
        if (wVar != 0) {
            e.d.a.n.a aVar2 = this.A;
            if (wVar instanceof s) {
                ((s) wVar).a();
            }
            boolean z2 = true;
            if (this.f7406f.f7415c != null) {
                v a3 = v.a(wVar);
                vVar = a3;
                wVar2 = a3;
            } else {
                vVar = 0;
                wVar2 = wVar;
            }
            i();
            ((m) this.p).a(wVar2, aVar2);
            this.r = g.ENCODE;
            try {
                if (this.f7406f.f7415c == null) {
                    z2 = false;
                }
                if (z2) {
                    cVar = this.f7406f;
                    d dVar = this.f7404d;
                    h hVar = this.o;
                    if (cVar != null) {
                        ((e.d.a.n.n.l.c) dVar).a().a(cVar.f7413a, new f(cVar.f7414b, cVar.f7415c, hVar));
                        cVar.f7415c.d();
                    } else {
                        throw null;
                    }
                }
                if (vVar != 0) {
                    vVar.d();
                }
                if (this.f7407g.a()) {
                    f();
                }
            } catch (Throwable th) {
                if (vVar != 0) {
                    vVar.d();
                }
                throw th;
            }
        } else {
            g();
        }
    }

    public int compareTo(Object obj) {
        i iVar = (i) obj;
        int ordinal = this.f7410j.ordinal() - iVar.f7410j.ordinal();
        return ordinal == 0 ? this.q - iVar.q : ordinal;
    }

    public final g d() {
        int ordinal = this.r.ordinal();
        if (ordinal == 1) {
            return new x(this.f7401a, this);
        }
        if (ordinal == 2) {
            return new d(this.f7401a, this);
        }
        if (ordinal == 3) {
            return new b0(this.f7401a, this);
        }
        if (ordinal == 5) {
            return null;
        }
        StringBuilder a2 = e.a.a.a.a.a("Unrecognized stage: ");
        a2.append(this.r);
        throw new IllegalStateException(a2.toString());
    }

    public final void e() {
        i();
        ((m) this.p).a(new r("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.f7402b)));
        if (this.f7407g.b()) {
            f();
        }
    }

    public final void f() {
        this.f7407g.c();
        c<?> cVar = this.f7406f;
        cVar.f7413a = null;
        cVar.f7414b = null;
        cVar.f7415c = null;
        h<R> hVar = this.f7401a;
        hVar.f7393c = null;
        hVar.f7394d = null;
        hVar.n = null;
        hVar.f7397g = null;
        hVar.k = null;
        hVar.f7399i = null;
        hVar.o = null;
        hVar.f7400j = null;
        hVar.p = null;
        hVar.f7391a.clear();
        hVar.l = false;
        hVar.f7392b.clear();
        hVar.m = false;
        this.D = false;
        this.f7408h = null;
        this.f7409i = null;
        this.o = null;
        this.f7410j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0;
        this.E = false;
        this.v = null;
        this.f7402b.clear();
        this.f7405e.a(this);
    }

    public final void g() {
        this.w = Thread.currentThread();
        this.t = e.d.a.t.f.a();
        boolean z2 = false;
        while (!this.E && this.C != null) {
            z2 = this.C.a();
            if (z2) {
                break;
            }
            this.r = a(this.r);
            this.C = d();
            if (this.r == g.SOURCE) {
                this.s = f.SWITCH_TO_SOURCE_SERVICE;
                ((m) this.p).a(this);
                return;
            }
        }
        if ((this.r == g.FINISHED || this.E) && !z2) {
            e();
        }
    }

    public final void h() {
        int ordinal = this.s.ordinal();
        if (ordinal == 0) {
            this.r = a(g.INITIALIZE);
            this.C = d();
            g();
        } else if (ordinal == 1) {
            g();
        } else if (ordinal == 2) {
            c();
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Unrecognized run reason: ");
            a2.append(this.s);
            throw new IllegalStateException(a2.toString());
        }
    }

    public final void i() {
        Throwable th;
        this.f7403c.a();
        if (this.D) {
            if (this.f7402b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f7402b;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    public void run() {
        String str = "DecodeJob";
        e.d.a.n.m.d<?> dVar = this.B;
        try {
            if (this.E) {
                e();
                if (dVar != null) {
                    dVar.b();
                }
                return;
            }
            h();
            if (dVar != null) {
                dVar.b();
            }
        } catch (c e2) {
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            throw th;
        }
    }

    public void a(e.d.a.n.f fVar, Object obj, e.d.a.n.m.d<?> dVar, e.d.a.n.a aVar, e.d.a.n.f fVar2) {
        this.x = fVar;
        this.z = obj;
        this.B = dVar;
        this.A = aVar;
        this.y = fVar2;
        if (Thread.currentThread() != this.w) {
            this.s = f.DECODE_DATA;
            ((m) this.p).a(this);
            return;
        }
        c();
    }

    public void a(e.d.a.n.f fVar, Exception exc, e.d.a.n.m.d<?> dVar, e.d.a.n.a aVar) {
        dVar.b();
        r rVar = new r("Fetching data failed", (Throwable) exc);
        Class<?> a2 = dVar.a();
        rVar.f7499b = fVar;
        rVar.f7500c = aVar;
        rVar.f7501d = a2;
        this.f7402b.add(rVar);
        if (Thread.currentThread() != this.w) {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            ((m) this.p).a(this);
            return;
        }
        g();
    }

    public final <Data> w<R> a(e.d.a.n.m.d<?> dVar, Data data, e.d.a.n.a aVar) throws r {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long a2 = e.d.a.t.f.a();
            w<R> a3 = a(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(a3);
                a(sb.toString(), a2, (String) null);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    public final <Data> w<R> a(Data data, e.d.a.n.a aVar) throws r {
        u a2 = this.f7401a.a(data.getClass());
        h hVar = this.o;
        if (VERSION.SDK_INT >= 26) {
            boolean z2 = aVar == e.d.a.n.a.RESOURCE_DISK_CACHE || this.f7401a.r;
            Boolean bool = (Boolean) hVar.a(m.f7698i);
            if (bool == null || (bool.booleanValue() && !z2)) {
                hVar = new h();
                hVar.a(this.o);
                hVar.f7231b.put(m.f7698i, Boolean.valueOf(z2));
            }
        }
        h hVar2 = hVar;
        e.d.a.n.m.e a3 = this.f7408h.f7102b.f7124e.a(data);
        try {
            return a2.a(a3, hVar2, this.l, this.m, new b(aVar));
        } finally {
            a3.b();
        }
    }

    public final void a(String str, long j2, String str2) {
        StringBuilder b2 = e.a.a.a.a.b(str, " in ");
        b2.append(e.d.a.t.f.a(j2));
        b2.append(", load key: ");
        b2.append(this.k);
        b2.append(str2 != null ? e.a.a.a.a.a(", ", str2) : "");
        b2.append(", thread: ");
        b2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", b2.toString());
    }

    public e.d.a.t.k.d a() {
        return this.f7403c;
    }
}
