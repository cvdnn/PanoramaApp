package i.b.a;

/* compiled from: Subscription */
public final class q {

    /* renamed from: a reason: collision with root package name */
    public final Object f9782a;

    /* renamed from: b reason: collision with root package name */
    public final o f9783b;

    /* renamed from: c reason: collision with root package name */
    public volatile boolean f9784c = true;

    public q(Object obj, o oVar) {
        this.f9782a = obj;
        this.f9783b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f9782a != qVar.f9782a || !this.f9783b.equals(qVar.f9783b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9783b.f9769f.hashCode() + this.f9782a.hashCode();
    }
}
