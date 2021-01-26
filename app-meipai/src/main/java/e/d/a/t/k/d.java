package e.d.a.t.k;

/* compiled from: StateVerifier */
public abstract class d {

    /* compiled from: StateVerifier */
    public static class b extends d {

        /* renamed from: a reason: collision with root package name */
        public volatile boolean f7928a;

        public b() {
            super(null);
        }

        public void a() {
            if (this.f7928a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public /* synthetic */ d(a aVar) {
    }

    public abstract void a();
}
