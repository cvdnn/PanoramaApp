package g;

import java.io.Closeable;

/* compiled from: Response */
public final class z implements Closeable {

    /* renamed from: a reason: collision with root package name */
    public final x f9614a;

    /* renamed from: b reason: collision with root package name */
    public final v f9615b;

    /* renamed from: c reason: collision with root package name */
    public final int f9616c;

    /* renamed from: d reason: collision with root package name */
    public final String f9617d;

    /* renamed from: e reason: collision with root package name */
    public final p f9618e;

    /* renamed from: f reason: collision with root package name */
    public final q f9619f;

    /* renamed from: g reason: collision with root package name */
    public final a0 f9620g;

    /* renamed from: h reason: collision with root package name */
    public final z f9621h;

    /* renamed from: i reason: collision with root package name */
    public final z f9622i;

    /* renamed from: j reason: collision with root package name */
    public final z f9623j;
    public final long k;
    public final long l;
    public volatile d m;

    /* compiled from: Response */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public x f9624a;

        /* renamed from: b reason: collision with root package name */
        public v f9625b;

        /* renamed from: c reason: collision with root package name */
        public int f9626c;

        /* renamed from: d reason: collision with root package name */
        public String f9627d;

        /* renamed from: e reason: collision with root package name */
        public p f9628e;

        /* renamed from: f reason: collision with root package name */
        public g.q.a f9629f;

        /* renamed from: g reason: collision with root package name */
        public a0 f9630g;

        /* renamed from: h reason: collision with root package name */
        public z f9631h;

        /* renamed from: i reason: collision with root package name */
        public z f9632i;

        /* renamed from: j reason: collision with root package name */
        public z f9633j;
        public long k;
        public long l;

        public a() {
            this.f9626c = -1;
            this.f9629f = new g.q.a();
        }

        public a a(q qVar) {
            this.f9629f = qVar.a();
            return this;
        }

        public a a(z zVar) {
            if (zVar != null) {
                a("cacheResponse", zVar);
            }
            this.f9632i = zVar;
            return this;
        }

        public a(z zVar) {
            this.f9626c = -1;
            this.f9624a = zVar.f9614a;
            this.f9625b = zVar.f9615b;
            this.f9626c = zVar.f9616c;
            this.f9627d = zVar.f9617d;
            this.f9628e = zVar.f9618e;
            this.f9629f = zVar.f9619f.a();
            this.f9630g = zVar.f9620g;
            this.f9631h = zVar.f9621h;
            this.f9632i = zVar.f9622i;
            this.f9633j = zVar.f9623j;
            this.k = zVar.k;
            this.l = zVar.l;
        }

        public final void a(String str, z zVar) {
            if (zVar.f9620g != null) {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, ".body != null"));
            } else if (zVar.f9621h != null) {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, ".networkResponse != null"));
            } else if (zVar.f9622i != null) {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, ".cacheResponse != null"));
            } else if (zVar.f9623j != null) {
                throw new IllegalArgumentException(e.a.a.a.a.a(str, ".priorResponse != null"));
            }
        }

        public z a() {
            if (this.f9624a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f9625b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f9626c < 0) {
                StringBuilder a2 = e.a.a.a.a.a("code < 0: ");
                a2.append(this.f9626c);
                throw new IllegalStateException(a2.toString());
            } else if (this.f9627d != null) {
                return new z(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    public z(a aVar) {
        this.f9614a = aVar.f9624a;
        this.f9615b = aVar.f9625b;
        this.f9616c = aVar.f9626c;
        this.f9617d = aVar.f9627d;
        this.f9618e = aVar.f9628e;
        g.q.a aVar2 = aVar.f9629f;
        if (aVar2 != null) {
            this.f9619f = new q(aVar2);
            this.f9620g = aVar.f9630g;
            this.f9621h = aVar.f9631h;
            this.f9622i = aVar.f9632i;
            this.f9623j = aVar.f9633j;
            this.k = aVar.k;
            this.l = aVar.l;
            return;
        }
        throw null;
    }

    public d a() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f9619f);
        this.m = a2;
        return a2;
    }

    public void close() {
        a0 a0Var = this.f9620g;
        if (a0Var != null) {
            a0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Response{protocol=");
        a2.append(this.f9615b);
        a2.append(", code=");
        a2.append(this.f9616c);
        a2.append(", message=");
        a2.append(this.f9617d);
        a2.append(", url=");
        a2.append(this.f9614a.f9595a);
        a2.append('}');
        return a2.toString();
    }
}
