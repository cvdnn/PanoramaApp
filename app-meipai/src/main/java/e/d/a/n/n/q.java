package e.d.a.n.n;

import e.c.f.n.n;
import e.d.a.n.f;

/* compiled from: EngineResource */
public class q<Z> implements w<Z> {

    /* renamed from: a reason: collision with root package name */
    public final boolean f7490a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f7491b;

    /* renamed from: c reason: collision with root package name */
    public final w<Z> f7492c;

    /* renamed from: d reason: collision with root package name */
    public final a f7493d;

    /* renamed from: e reason: collision with root package name */
    public final f f7494e;

    /* renamed from: f reason: collision with root package name */
    public int f7495f;

    /* renamed from: g reason: collision with root package name */
    public boolean f7496g;

    /* compiled from: EngineResource */
    public interface a {
        void a(f fVar, q<?> qVar);
    }

    public q(w<Z> wVar, boolean z, boolean z2, f fVar, a aVar) {
        String str = "Argument must not be null";
        n.a(wVar, str);
        this.f7492c = wVar;
        this.f7490a = z;
        this.f7491b = z2;
        this.f7494e = fVar;
        n.a(aVar, str);
        this.f7493d = aVar;
    }

    public synchronized void a() {
        if (!this.f7496g) {
            this.f7495f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public synchronized void b() {
        if (this.f7495f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f7496g) {
            this.f7496g = true;
            if (this.f7491b) {
                this.f7492c.b();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public Class<Z> c() {
        return this.f7492c.c();
    }

    public void d() {
        boolean z;
        synchronized (this) {
            if (this.f7495f > 0) {
                z = true;
                int i2 = this.f7495f - 1;
                this.f7495f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f7493d.a(this.f7494e, this);
        }
    }

    public Z get() {
        return this.f7492c.get();
    }

    public int getSize() {
        return this.f7492c.getSize();
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("EngineResource{isMemoryCacheable=");
        sb.append(this.f7490a);
        sb.append(", listener=");
        sb.append(this.f7493d);
        sb.append(", key=");
        sb.append(this.f7494e);
        sb.append(", acquired=");
        sb.append(this.f7495f);
        sb.append(", isRecycled=");
        sb.append(this.f7496g);
        sb.append(", resource=");
        sb.append(this.f7492c);
        sb.append('}');
        return sb.toString();
    }
}
