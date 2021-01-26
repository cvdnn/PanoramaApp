package e.d.a.n.n;

import android.util.Log;
import e.c.f.n.n;
import e.d.a.n.n.d0.a.C0083a;
import e.d.a.n.n.d0.e;
import e.d.a.n.n.d0.f;
import e.d.a.n.n.d0.h;
import e.d.a.n.n.d0.i;
import e.d.a.r.g;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine */
public class l implements n, e.d.a.n.n.d0.i.a, e.d.a.n.n.q.a {

    /* renamed from: i reason: collision with root package name */
    public static final boolean f7438i = Log.isLoggable("Engine", 2);

    /* renamed from: a reason: collision with root package name */
    public final t f7439a = new t();

    /* renamed from: b reason: collision with root package name */
    public final p f7440b = new p();

    /* renamed from: c reason: collision with root package name */
    public final i f7441c;

    /* renamed from: d reason: collision with root package name */
    public final b f7442d;

    /* renamed from: e reason: collision with root package name */
    public final z f7443e;

    /* renamed from: f reason: collision with root package name */
    public final c f7444f;

    /* renamed from: g reason: collision with root package name */
    public final a f7445g;

    /* renamed from: h reason: collision with root package name */
    public final a f7446h;

    /* compiled from: Engine */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.n.n.i.d f7447a;

        /* renamed from: b reason: collision with root package name */
        public final d.h.j.c<i<?>> f7448b = e.d.a.t.k.a.a(150, new C0087a());

        /* renamed from: c reason: collision with root package name */
        public int f7449c;

        /* renamed from: e.d.a.n.n.l$a$a reason: collision with other inner class name */
        /* compiled from: Engine */
        public class C0087a implements e.d.a.t.k.a.b<i<?>> {
            public C0087a() {
            }

            public Object create() {
                a aVar = a.this;
                return new i(aVar.f7447a, aVar.f7448b);
            }
        }

        public a(e.d.a.n.n.i.d dVar) {
            this.f7447a = dVar;
        }
    }

    /* compiled from: Engine */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final e.d.a.n.n.e0.a f7451a;

        /* renamed from: b reason: collision with root package name */
        public final e.d.a.n.n.e0.a f7452b;

        /* renamed from: c reason: collision with root package name */
        public final e.d.a.n.n.e0.a f7453c;

        /* renamed from: d reason: collision with root package name */
        public final e.d.a.n.n.e0.a f7454d;

        /* renamed from: e reason: collision with root package name */
        public final n f7455e;

        /* renamed from: f reason: collision with root package name */
        public final e.d.a.n.n.q.a f7456f;

        /* renamed from: g reason: collision with root package name */
        public final d.h.j.c<m<?>> f7457g = e.d.a.t.k.a.a(150, new a());

        /* compiled from: Engine */
        public class a implements e.d.a.t.k.a.b<m<?>> {
            public a() {
            }

            public Object create() {
                b bVar = b.this;
                m mVar = new m(bVar.f7451a, bVar.f7452b, bVar.f7453c, bVar.f7454d, bVar.f7455e, bVar.f7456f, bVar.f7457g);
                return mVar;
            }
        }

        public b(e.d.a.n.n.e0.a aVar, e.d.a.n.n.e0.a aVar2, e.d.a.n.n.e0.a aVar3, e.d.a.n.n.e0.a aVar4, n nVar, e.d.a.n.n.q.a aVar5) {
            this.f7451a = aVar;
            this.f7452b = aVar2;
            this.f7453c = aVar3;
            this.f7454d = aVar4;
            this.f7455e = nVar;
            this.f7456f = aVar5;
        }
    }

    /* compiled from: Engine */
    public static class c implements e.d.a.n.n.i.d {

        /* renamed from: a reason: collision with root package name */
        public final C0083a f7459a;

        /* renamed from: b reason: collision with root package name */
        public volatile e.d.a.n.n.d0.a f7460b;

        public c(C0083a aVar) {
            this.f7459a = aVar;
        }

        public e.d.a.n.n.d0.a a() {
            if (this.f7460b == null) {
                synchronized (this) {
                    if (this.f7460b == null) {
                        e.d.a.n.n.d0.d dVar = (e.d.a.n.n.d0.d) this.f7459a;
                        f fVar = (f) dVar.f7349b;
                        File cacheDir = fVar.f7355a.getCacheDir();
                        e eVar = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else if (fVar.f7356b != null) {
                            cacheDir = new File(cacheDir, fVar.f7356b);
                        }
                        if (cacheDir != null) {
                            if (!cacheDir.mkdirs()) {
                                if (cacheDir.exists()) {
                                    if (!cacheDir.isDirectory()) {
                                    }
                                }
                            }
                            eVar = new e(cacheDir, dVar.f7348a);
                        }
                        this.f7460b = eVar;
                    }
                    if (this.f7460b == null) {
                        this.f7460b = new e.d.a.n.n.d0.b();
                    }
                }
            }
            return this.f7460b;
        }
    }

    /* compiled from: Engine */
    public class d {

        /* renamed from: a reason: collision with root package name */
        public final m<?> f7461a;

        /* renamed from: b reason: collision with root package name */
        public final e.d.a.r.f f7462b;

        public d(e.d.a.r.f fVar, m<?> mVar) {
            this.f7462b = fVar;
            this.f7461a = mVar;
        }

        public void a() {
            synchronized (l.this) {
                this.f7461a.a(this.f7462b);
            }
        }
    }

    public l(i iVar, C0083a aVar, e.d.a.n.n.e0.a aVar2, e.d.a.n.n.e0.a aVar3, e.d.a.n.n.e0.a aVar4, e.d.a.n.n.e0.a aVar5, boolean z) {
        this.f7441c = iVar;
        this.f7444f = new c(aVar);
        a aVar6 = new a(z);
        this.f7446h = aVar6;
        aVar6.a((e.d.a.n.n.q.a) this);
        b bVar = new b(aVar2, aVar3, aVar4, aVar5, this, this);
        this.f7442d = bVar;
        this.f7445g = new a(this.f7444f);
        this.f7443e = new z();
        ((h) iVar).f7357d = this;
    }

    public synchronized void a(m<?> mVar, e.d.a.n.f fVar, q<?> qVar) {
        if (qVar != null) {
            if (qVar.f7490a) {
                this.f7446h.a(fVar, qVar);
            }
        }
        t tVar = this.f7439a;
        if (tVar != null) {
            Map a2 = tVar.a(mVar.p);
            if (mVar.equals(a2.get(fVar))) {
                a2.remove(fVar);
            }
        } else {
            throw null;
        }
    }

    public <R> d a(e.d.a.d dVar, Object obj, e.d.a.n.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, e.d.a.f fVar2, k kVar, Map<Class<?>, e.d.a.n.l<?>> map, boolean z, boolean z2, e.d.a.n.h hVar, boolean z3, boolean z4, boolean z5, boolean z6, e.d.a.r.f fVar3, Executor executor) {
        long a2 = f7438i ? e.d.a.t.f.a() : 0;
        if (this.f7440b != null) {
            o oVar = new o(obj, fVar, i2, i3, map, cls, cls2, hVar);
            synchronized (this) {
                q a3 = a(oVar, z3, a2);
                if (a3 == null) {
                    d a4 = a(dVar, obj, fVar, i2, i3, cls, cls2, fVar2, kVar, map, z, z2, hVar, z3, z4, z5, z6, fVar3, executor, oVar, a2);
                    return a4;
                }
                ((g) fVar3).a((w<?>) a3, e.d.a.n.a.MEMORY_CACHE);
                return null;
            }
        }
        throw null;
    }

    public final <R> d a(e.d.a.d dVar, Object obj, e.d.a.n.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, e.d.a.f fVar2, k kVar, Map<Class<?>, e.d.a.n.l<?>> map, boolean z, boolean z2, e.d.a.n.h hVar, boolean z3, boolean z4, boolean z5, boolean z6, e.d.a.r.f fVar3, Executor executor, o oVar, long j2) {
        e.d.a.d dVar2 = dVar;
        Object obj2 = obj;
        e.d.a.n.f fVar4 = fVar;
        int i4 = i2;
        int i5 = i3;
        e.d.a.f fVar5 = fVar2;
        k kVar2 = kVar;
        e.d.a.n.h hVar2 = hVar;
        boolean z7 = z6;
        e.d.a.r.f fVar6 = fVar3;
        Executor executor2 = executor;
        o oVar2 = oVar;
        long j3 = j2;
        t tVar = this.f7439a;
        m mVar = (m) (z7 ? tVar.f7506b : tVar.f7505a).get(oVar2);
        if (mVar != null) {
            mVar.a(fVar6, executor2);
            if (f7438i) {
                a("Added to existing load", j3, (e.d.a.n.f) oVar2);
            }
            return new d(fVar6, mVar);
        }
        m mVar2 = (m) this.f7442d.f7457g.a();
        String str = "Argument must not be null";
        n.a(mVar2, str);
        m mVar3 = mVar2;
        mVar2.a(oVar, z3, z4, z5, z6);
        a aVar = this.f7445g;
        i iVar = (i) aVar.f7448b.a();
        n.a(iVar, str);
        int i6 = aVar.f7449c;
        aVar.f7449c = i6 + 1;
        h<R> hVar3 = iVar.f7401a;
        e.d.a.n.n.i.d dVar3 = iVar.f7404d;
        hVar3.f7393c = dVar2;
        hVar3.f7394d = obj2;
        hVar3.n = fVar4;
        hVar3.f7395e = i4;
        hVar3.f7396f = i5;
        hVar3.p = kVar2;
        hVar3.f7397g = cls;
        hVar3.f7398h = dVar3;
        hVar3.k = cls2;
        hVar3.o = fVar5;
        hVar3.f7399i = hVar2;
        hVar3.f7400j = map;
        hVar3.q = z;
        hVar3.r = z2;
        iVar.f7408h = dVar2;
        iVar.f7409i = fVar4;
        iVar.f7410j = fVar5;
        o oVar3 = oVar;
        iVar.k = oVar3;
        iVar.l = i4;
        iVar.m = i5;
        iVar.n = kVar2;
        iVar.u = z6;
        iVar.o = hVar2;
        m mVar4 = mVar3;
        iVar.p = mVar4;
        iVar.q = i6;
        iVar.s = i.f.INITIALIZE;
        iVar.v = obj2;
        t tVar2 = this.f7439a;
        if (tVar2 != null) {
            tVar2.a(mVar4.p).put(oVar3, mVar4);
            e.d.a.r.f fVar7 = fVar3;
            mVar4.a(fVar7, executor);
            mVar4.b(iVar);
            if (f7438i) {
                a("Started new load", j2, (e.d.a.n.f) oVar3);
            }
            return new d(fVar7, mVar4);
        }
        throw null;
    }

    public static void a(String str, long j2, e.d.a.n.f fVar) {
        StringBuilder b2 = e.a.a.a.a.b(str, " in ");
        b2.append(e.d.a.t.f.a(j2));
        b2.append("ms, key: ");
        b2.append(fVar);
        Log.v("Engine", b2.toString());
    }

    public final q<?> a(o oVar, boolean z, long j2) {
        q<?> qVar;
        if (!z) {
            return null;
        }
        q<?> b2 = this.f7446h.b(oVar);
        if (b2 != null) {
            b2.a();
        }
        if (b2 != null) {
            if (f7438i) {
                a("Loaded resource from active resources", j2, (e.d.a.n.f) oVar);
            }
            return b2;
        }
        w a2 = ((h) this.f7441c).a(oVar);
        if (a2 == null) {
            qVar = null;
        } else if (a2 instanceof q) {
            qVar = (q) a2;
        } else {
            q<?> qVar2 = new q<>(a2, true, true, oVar, this);
            qVar = qVar2;
        }
        if (qVar != null) {
            qVar.a();
            this.f7446h.a(oVar, qVar);
        }
        if (qVar == null) {
            return null;
        }
        if (f7438i) {
            a("Loaded resource from cache", j2, (e.d.a.n.f) oVar);
        }
        return qVar;
    }

    public void a(w<?> wVar) {
        if (wVar instanceof q) {
            ((q) wVar).d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public synchronized void a(m<?> mVar, e.d.a.n.f fVar) {
        t tVar = this.f7439a;
        if (tVar != null) {
            Map a2 = tVar.a(mVar.p);
            if (mVar.equals(a2.get(fVar))) {
                a2.remove(fVar);
            }
        } else {
            throw null;
        }
    }

    public void a(e.d.a.n.f fVar, q<?> qVar) {
        this.f7446h.a(fVar);
        if (qVar.f7490a) {
            ((h) this.f7441c).a(fVar, (w) qVar);
        } else {
            this.f7443e.a(qVar, false);
        }
    }
}
