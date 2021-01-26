package i.b.a;

/* compiled from: PendingPostQueue */
public final class k {

    /* renamed from: a reason: collision with root package name */
    public j f9759a;

    /* renamed from: b reason: collision with root package name */
    public j f9760b;

    public synchronized void a(j jVar) {
        if (jVar != null) {
            try {
                if (this.f9760b != null) {
                    this.f9760b.f9758c = jVar;
                    this.f9760b = jVar;
                } else if (this.f9759a == null) {
                    this.f9760b = jVar;
                    this.f9759a = jVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } finally {
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized j a() {
        j jVar;
        jVar = this.f9759a;
        if (this.f9759a != null) {
            j jVar2 = this.f9759a.f9758c;
            this.f9759a = jVar2;
            if (jVar2 == null) {
                this.f9760b = null;
            }
        }
        return jVar;
    }

    public synchronized j a(int i2) throws InterruptedException {
        if (this.f9759a == null) {
            wait((long) i2);
        }
        return a();
    }
}
