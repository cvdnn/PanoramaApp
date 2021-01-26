package e.d.a.n.n;

import d.h.j.c;
import e.c.f.n.n;
import e.d.a.t.k.a.d;
import e.d.a.t.k.d.b;

/* compiled from: LockedResource */
public final class v<Z> implements w<Z>, d {

    /* renamed from: e reason: collision with root package name */
    public static final c<v<?>> f7510e = e.d.a.t.k.a.a(20, new a());

    /* renamed from: a reason: collision with root package name */
    public final e.d.a.t.k.d f7511a = new b();

    /* renamed from: b reason: collision with root package name */
    public w<Z> f7512b;

    /* renamed from: c reason: collision with root package name */
    public boolean f7513c;

    /* renamed from: d reason: collision with root package name */
    public boolean f7514d;

    /* compiled from: LockedResource */
    public class a implements e.d.a.t.k.a.b<v<?>> {
        public Object create() {
            return new v();
        }
    }

    public static <Z> v<Z> a(w<Z> wVar) {
        v<Z> vVar = (v) f7510e.a();
        n.a(vVar, "Argument must not be null");
        vVar.f7514d = false;
        vVar.f7513c = true;
        vVar.f7512b = wVar;
        return vVar;
    }

    public synchronized void b() {
        this.f7511a.a();
        this.f7514d = true;
        if (!this.f7513c) {
            this.f7512b.b();
            this.f7512b = null;
            f7510e.a(this);
        }
    }

    public Class<Z> c() {
        return this.f7512b.c();
    }

    public synchronized void d() {
        this.f7511a.a();
        if (this.f7513c) {
            this.f7513c = false;
            if (this.f7514d) {
                b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.f7512b.get();
    }

    public int getSize() {
        return this.f7512b.getSize();
    }

    public e.d.a.t.k.d a() {
        return this.f7511a;
    }
}
