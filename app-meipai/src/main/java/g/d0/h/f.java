package g.d0.h;

import com.baidubce.http.Headers;
import e.c.f.n.n;
import g.a0;
import g.d0.e.g;
import g.d0.f.c;
import g.d0.f.i;
import g.q;
import g.u;
import g.v;
import g.z;
import h.e;
import h.h;
import h.j;
import h.o;
import h.w;
import h.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec */
public final class f implements c {

    /* renamed from: e reason: collision with root package name */
    public static final h f9320e = h.c("connection");

    /* renamed from: f reason: collision with root package name */
    public static final h f9321f = h.c("host");

    /* renamed from: g reason: collision with root package name */
    public static final h f9322g = h.c("keep-alive");

    /* renamed from: h reason: collision with root package name */
    public static final h f9323h = h.c("proxy-connection");

    /* renamed from: i reason: collision with root package name */
    public static final h f9324i = h.c("transfer-encoding");

    /* renamed from: j reason: collision with root package name */
    public static final h f9325j = h.c("te");
    public static final h k = h.c("encoding");
    public static final h l;
    public static final List<h> m;
    public static final List<h> n = g.d0.c.a((T[]) new h[]{f9320e, f9321f, f9322g, f9323h, f9325j, f9324i, k, l});

    /* renamed from: a reason: collision with root package name */
    public final g.s.a f9326a;

    /* renamed from: b reason: collision with root package name */
    public final g f9327b;

    /* renamed from: c reason: collision with root package name */
    public final g f9328c;

    /* renamed from: d reason: collision with root package name */
    public n f9329d;

    /* compiled from: Http2Codec */
    public class a extends j {

        /* renamed from: a reason: collision with root package name */
        public boolean f9330a = false;

        /* renamed from: b reason: collision with root package name */
        public long f9331b = 0;

        public a(x xVar) {
            super(xVar);
        }

        public final void a(IOException iOException) {
            if (!this.f9330a) {
                this.f9330a = true;
                f fVar = f.this;
                fVar.f9327b.a(false, (c) fVar, this.f9331b, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            a(null);
        }

        public long read(e eVar, long j2) throws IOException {
            try {
                long read = delegate().read(eVar, j2);
                if (read > 0) {
                    this.f9331b += read;
                }
                return read;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }
    }

    static {
        h c2 = h.c("upgrade");
        l = c2;
        m = g.d0.c.a((T[]) new h[]{f9320e, f9321f, f9322g, f9323h, f9325j, f9324i, k, c2, c.f9290f, c.f9291g, c.f9292h, c.f9293i});
    }

    public f(u uVar, g.s.a aVar, g gVar, g gVar2) {
        this.f9326a = aVar;
        this.f9327b = gVar;
        this.f9328c = gVar2;
    }

    public w a(g.x xVar, long j2) {
        return this.f9329d.c();
    }

    public void b() throws IOException {
        this.f9328c.q.flush();
    }

    public void cancel() {
        n nVar = this.f9329d;
        if (nVar != null) {
            nVar.c(b.CANCEL);
        }
    }

    public void a(g.x xVar) throws IOException {
        if (this.f9329d == null) {
            boolean z = xVar.f9598d != null;
            q qVar = xVar.f9597c;
            ArrayList arrayList = new ArrayList(qVar.b() + 4);
            arrayList.add(new c(c.f9290f, xVar.f9596b));
            arrayList.add(new c(c.f9291g, n.a(xVar.f9595a)));
            String a2 = xVar.f9597c.a(Headers.HOST);
            if (a2 != null) {
                arrayList.add(new c(c.f9293i, a2));
            }
            arrayList.add(new c(c.f9292h, xVar.f9595a.f9535a));
            int b2 = qVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                h c2 = h.c(qVar.a(i2).toLowerCase(Locale.US));
                if (!m.contains(c2)) {
                    arrayList.add(new c(c2, qVar.b(i2)));
                }
            }
            n a3 = this.f9328c.a(0, arrayList, z);
            this.f9329d = a3;
            a3.f9403i.a((long) ((g.d0.f.f) this.f9326a).f9246j, TimeUnit.MILLISECONDS);
            this.f9329d.f9404j.a((long) ((g.d0.f.f) this.f9326a).k, TimeUnit.MILLISECONDS);
        }
    }

    public void a() throws IOException {
        ((g.d0.h.n.a) this.f9329d.c()).close();
    }

    public g.z.a a(boolean z) throws IOException {
        List g2 = this.f9329d.g();
        g.q.a aVar = new g.q.a();
        int size = g2.size();
        i iVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = (c) g2.get(i2);
            if (cVar != null) {
                h hVar = cVar.f9294a;
                String g3 = cVar.f9295b.g();
                if (hVar.equals(c.f9289e)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(g3);
                    iVar = i.a(sb.toString());
                } else if (!n.contains(hVar)) {
                    g.d0.a.f9172a.a(aVar, hVar.g(), g3);
                }
            } else if (iVar != null && iVar.f9256b == 100) {
                aVar = new g.q.a();
                iVar = null;
            }
        }
        if (iVar != null) {
            g.z.a aVar2 = new g.z.a();
            aVar2.f9625b = v.HTTP_2;
            aVar2.f9626c = iVar.f9256b;
            aVar2.f9627d = iVar.f9257c;
            List<String> list = aVar.f9533a;
            String[] strArr = (String[]) list.toArray(new String[list.size()]);
            g.q.a aVar3 = new g.q.a();
            Collections.addAll(aVar3.f9533a, strArr);
            aVar2.f9629f = aVar3;
            if (z) {
                if (((g.u.a) g.d0.a.f9172a) == null) {
                    throw null;
                } else if (aVar2.f9626c == 100) {
                    return null;
                }
            }
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public a0 a(z zVar) throws IOException {
        String str = null;
        if (this.f9327b.f9225f != null) {
            String a2 = zVar.f9619f.a("Content-Type");
            if (a2 != null) {
                str = a2;
            }
            return new g.d0.f.g(str, g.d0.f.e.a(zVar), o.a((x) new a(this.f9329d.f9401g)));
        }
        throw null;
    }
}
