package g;

import g.d0.b;
import g.d0.e.g;
import g.d0.f.f;
import g.d0.f.h;
import g.d0.i.e;
import g.r.a.C0141a;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: RealCall */
public final class w implements e {

    /* renamed from: a reason: collision with root package name */
    public final u f9587a;

    /* renamed from: b reason: collision with root package name */
    public final h f9588b;

    /* renamed from: c reason: collision with root package name */
    public n f9589c;

    /* renamed from: d reason: collision with root package name */
    public final x f9590d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f9591e;

    /* renamed from: f reason: collision with root package name */
    public boolean f9592f;

    /* compiled from: RealCall */
    public final class a extends b {

        /* renamed from: b reason: collision with root package name */
        public final e.c.d.l.b.a f9593b;

        public a(e.c.d.l.b.a aVar) {
            super("OkHttp %s", w.this.b());
            this.f9593b = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[SYNTHETIC, Splitter:B:14:0x0034] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0052 A[Catch:{ all -> 0x002e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                g.w r2 = g.w.this     // Catch:{ IOException -> 0x0030 }
                g.z r2 = r2.a()     // Catch:{ IOException -> 0x0030 }
                g.w r3 = g.w.this     // Catch:{ IOException -> 0x0030 }
                g.d0.f.h r3 = r3.f9588b     // Catch:{ IOException -> 0x0030 }
                boolean r3 = r3.f9254e     // Catch:{ IOException -> 0x0030 }
                if (r3 == 0) goto L_0x001f
                e.c.d.l.b.a r2 = r6.f9593b     // Catch:{ IOException -> 0x002b }
                g.w r3 = g.w.this     // Catch:{ IOException -> 0x002b }
                java.io.IOException r4 = new java.io.IOException     // Catch:{ IOException -> 0x002b }
                java.lang.String r5 = "Canceled"
                r4.<init>(r5)     // Catch:{ IOException -> 0x002b }
                r2.a(r3, r0, r1)     // Catch:{ IOException -> 0x002b }
                goto L_0x0026
            L_0x001f:
                e.c.d.l.b.a r3 = r6.f9593b     // Catch:{ IOException -> 0x002b }
                g.w r4 = g.w.this     // Catch:{ IOException -> 0x002b }
                r3.a(r4, r2)     // Catch:{ IOException -> 0x002b }
            L_0x0026:
                g.w r0 = g.w.this
                g.u r0 = r0.f9587a
                goto L_0x0060
            L_0x002b:
                r2 = move-exception
                r3 = r1
                goto L_0x0032
            L_0x002e:
                r0 = move-exception
                goto L_0x0069
            L_0x0030:
                r2 = move-exception
                r3 = 0
            L_0x0032:
                if (r3 == 0) goto L_0x0052
                g.d0.i.e r0 = g.d0.i.e.f9461a     // Catch:{ all -> 0x002e }
                r3 = 4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
                r4.<init>()     // Catch:{ all -> 0x002e }
                java.lang.String r5 = "Callback failure for "
                r4.append(r5)     // Catch:{ all -> 0x002e }
                g.w r5 = g.w.this     // Catch:{ all -> 0x002e }
                java.lang.String r5 = r5.c()     // Catch:{ all -> 0x002e }
                r4.append(r5)     // Catch:{ all -> 0x002e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002e }
                r0.a(r3, r4, r2)     // Catch:{ all -> 0x002e }
                goto L_0x0026
            L_0x0052:
                g.w r2 = g.w.this     // Catch:{ all -> 0x002e }
                g.n r2 = r2.f9589c     // Catch:{ all -> 0x002e }
                if (r2 == 0) goto L_0x0068
                e.c.d.l.b.a r2 = r6.f9593b     // Catch:{ all -> 0x002e }
                g.w r3 = g.w.this     // Catch:{ all -> 0x002e }
                r2.a(r3, r0, r1)     // Catch:{ all -> 0x002e }
                goto L_0x0026
            L_0x0060:
                g.l r0 = r0.f9561a
                java.util.Deque<g.w$a> r2 = r0.f9523e
                r0.a(r2, r6, r1)
                return
            L_0x0068:
                throw r0     // Catch:{ all -> 0x002e }
            L_0x0069:
                g.w r2 = g.w.this
                g.u r2 = r2.f9587a
                g.l r2 = r2.f9561a
                java.util.Deque<g.w$a> r3 = r2.f9523e
                r2.a(r3, r6, r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: g.w.a.a():void");
        }
    }

    public w(u uVar, x xVar, boolean z) {
        this.f9587a = uVar;
        this.f9590d = xVar;
        this.f9591e = z;
        this.f9588b = new h(uVar, z);
    }

    public void a(e.c.d.l.b.a aVar) {
        synchronized (this) {
            if (!this.f9592f) {
                this.f9592f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f9588b.f9253d = e.f9461a.a("response.body().close()");
        if (this.f9589c != null) {
            this.f9587a.f9561a.a(new a(aVar));
            return;
        }
        throw null;
    }

    public String b() {
        r rVar = this.f9590d.f9595a;
        if (rVar != null) {
            g.r.a aVar = new g.r.a();
            if (aVar.a(rVar, "/...") != C0141a.SUCCESS) {
                aVar = null;
            }
            if (aVar != null) {
                aVar.f9544b = r.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                aVar.f9545c = r.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return aVar.a().f9542h;
            }
            throw null;
        }
        throw null;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9588b.f9254e ? "canceled " : "");
        sb.append(this.f9591e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(b());
        return sb.toString();
    }

    public void cancel() {
        h hVar = this.f9588b;
        hVar.f9254e = true;
        g gVar = hVar.f9252c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        u uVar = this.f9587a;
        w wVar = new w(uVar, this.f9590d, this.f9591e);
        wVar.f9589c = ((o) uVar.f9567g).f9527a;
        return wVar;
    }

    public z d() throws IOException {
        synchronized (this) {
            if (!this.f9592f) {
                this.f9592f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f9588b.f9253d = e.f9461a.a("response.body().close()");
        if (this.f9589c != null) {
            try {
                this.f9587a.f9561a.a(this);
                z a2 = a();
                if (a2 != null) {
                    l lVar = this.f9587a.f9561a;
                    lVar.a(lVar.f9524f, this, false);
                    return a2;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                if (this.f9589c != null) {
                    throw e2;
                }
                throw null;
            } catch (Throwable th) {
                l lVar2 = this.f9587a.f9561a;
                lVar2.a(lVar2.f9524f, this, false);
                throw th;
            }
        } else {
            throw null;
        }
    }

    public boolean i() {
        return this.f9588b.f9254e;
    }

    public z a() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f9587a.f9565e);
        arrayList.add(this.f9588b);
        arrayList.add(new g.d0.f.a(this.f9587a.f9569i));
        arrayList.add(new g.d0.d.b(this.f9587a.k));
        arrayList.add(new g.d0.e.a(this.f9587a));
        if (!this.f9591e) {
            arrayList.addAll(this.f9587a.f9566f);
        }
        arrayList.add(new g.d0.f.b(this.f9591e));
        x xVar = this.f9590d;
        n nVar = this.f9589c;
        u uVar = this.f9587a;
        f fVar = new f(arrayList, null, null, null, 0, xVar, this, nVar, uVar.x, uVar.y, uVar.z);
        return fVar.a(this.f9590d);
    }
}
