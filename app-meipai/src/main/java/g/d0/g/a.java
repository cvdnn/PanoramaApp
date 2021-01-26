package g.d0.g;

import com.arashivision.insbase.arlog.MultipartUtility;
import com.baidu.mobstat.Config;
import com.baidubce.http.Headers;
import e.c.f.n.n;
import g.a0;
import g.d0.f.i;
import g.q;
import g.r;
import g.u;
import g.z;
import h.k;
import h.o;
import h.w;
import h.x;
import h.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

/* compiled from: Http1Codec */
public final class a implements g.d0.f.c {

    /* renamed from: a reason: collision with root package name */
    public final u f9258a;

    /* renamed from: b reason: collision with root package name */
    public final g.d0.e.g f9259b;

    /* renamed from: c reason: collision with root package name */
    public final h.g f9260c;

    /* renamed from: d reason: collision with root package name */
    public final h.f f9261d;

    /* renamed from: e reason: collision with root package name */
    public int f9262e = 0;

    /* compiled from: Http1Codec */
    public abstract class b implements x {

        /* renamed from: a reason: collision with root package name */
        public final k f9263a = new k(a.this.f9260c.timeout());

        /* renamed from: b reason: collision with root package name */
        public boolean f9264b;

        /* renamed from: c reason: collision with root package name */
        public long f9265c = 0;

        public /* synthetic */ b(C0139a aVar) {
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f9262e;
            if (i2 != 6) {
                if (i2 == 5) {
                    aVar.a(this.f9263a);
                    a aVar2 = a.this;
                    aVar2.f9262e = 6;
                    g.d0.e.g gVar = aVar2.f9259b;
                    if (gVar != null) {
                        gVar.a(!z, (g.d0.f.c) aVar2, this.f9265c, iOException);
                    }
                    return;
                }
                StringBuilder a2 = e.a.a.a.a.a("state: ");
                a2.append(a.this.f9262e);
                throw new IllegalStateException(a2.toString());
            }
        }

        public long read(h.e eVar, long j2) throws IOException {
            try {
                long read = a.this.f9260c.read(eVar, j2);
                if (read > 0) {
                    this.f9265c += read;
                }
                return read;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        public y timeout() {
            return this.f9263a;
        }
    }

    /* compiled from: Http1Codec */
    public final class c implements w {

        /* renamed from: a reason: collision with root package name */
        public final k f9267a = new k(a.this.f9261d.timeout());

        /* renamed from: b reason: collision with root package name */
        public boolean f9268b;

        public c() {
        }

        public void a(h.e eVar, long j2) throws IOException {
            if (this.f9268b) {
                throw new IllegalStateException("closed");
            } else if (j2 != 0) {
                a.this.f9261d.d(j2);
                h.f fVar = a.this.f9261d;
                String str = MultipartUtility.CTRLF;
                fVar.c(str);
                a.this.f9261d.a(eVar, j2);
                a.this.f9261d.c(str);
            }
        }

        public synchronized void close() throws IOException {
            if (!this.f9268b) {
                this.f9268b = true;
                a.this.f9261d.c("0\r\n\r\n");
                a.this.a(this.f9267a);
                a.this.f9262e = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f9268b) {
                a.this.f9261d.flush();
            }
        }

        public y timeout() {
            return this.f9267a;
        }
    }

    /* compiled from: Http1Codec */
    public class d extends b {

        /* renamed from: e reason: collision with root package name */
        public final r f9270e;

        /* renamed from: f reason: collision with root package name */
        public long f9271f = -1;

        /* renamed from: g reason: collision with root package name */
        public boolean f9272g = true;

        public d(r rVar) {
            super(null);
            this.f9270e = rVar;
        }

        public void close() throws IOException {
            if (!this.f9264b) {
                if (this.f9272g && !g.d0.c.a((x) this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f9264b = true;
            }
        }

        public long read(h.e eVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f9264b) {
                throw new IllegalStateException("closed");
            } else if (!this.f9272g) {
                return -1;
            } else {
                long j3 = this.f9271f;
                if (j3 == 0 || j3 == -1) {
                    if (this.f9271f != -1) {
                        a.this.f9260c.j();
                    }
                    try {
                        this.f9271f = a.this.f9260c.o();
                        String trim = a.this.f9260c.j().trim();
                        if (this.f9271f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("expected chunk size and optional extensions but was \"");
                            sb2.append(this.f9271f);
                            sb2.append(trim);
                            sb2.append("\"");
                            throw new ProtocolException(sb2.toString());
                        }
                        if (this.f9271f == 0) {
                            this.f9272g = false;
                            a aVar = a.this;
                            g.d0.f.e.a(aVar.f9258a.f9569i, this.f9270e, aVar.c());
                            a(true, null);
                        }
                        if (!this.f9272g) {
                            return -1;
                        }
                    } catch (NumberFormatException e2) {
                        throw new ProtocolException(e2.getMessage());
                    }
                }
                long read = super.read(eVar, Math.min(j2, this.f9271f));
                if (read != -1) {
                    this.f9271f -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }
    }

    /* compiled from: Http1Codec */
    public final class e implements w {

        /* renamed from: a reason: collision with root package name */
        public final k f9274a = new k(a.this.f9261d.timeout());

        /* renamed from: b reason: collision with root package name */
        public boolean f9275b;

        /* renamed from: c reason: collision with root package name */
        public long f9276c;

        public e(long j2) {
            this.f9276c = j2;
        }

        public void a(h.e eVar, long j2) throws IOException {
            if (!this.f9275b) {
                g.d0.c.a(eVar.f9647b, 0, j2);
                if (j2 <= this.f9276c) {
                    a.this.f9261d.a(eVar, j2);
                    this.f9276c -= j2;
                    return;
                }
                StringBuilder a2 = e.a.a.a.a.a("expected ");
                a2.append(this.f9276c);
                a2.append(" bytes but received ");
                a2.append(j2);
                throw new ProtocolException(a2.toString());
            }
            throw new IllegalStateException("closed");
        }

        public void close() throws IOException {
            if (!this.f9275b) {
                this.f9275b = true;
                if (this.f9276c <= 0) {
                    a.this.a(this.f9274a);
                    a.this.f9262e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.f9275b) {
                a.this.f9261d.flush();
            }
        }

        public y timeout() {
            return this.f9274a;
        }
    }

    /* compiled from: Http1Codec */
    public class f extends b {

        /* renamed from: e reason: collision with root package name */
        public long f9278e;

        public f(a aVar, long j2) throws IOException {
            super(null);
            this.f9278e = j2;
            if (j2 == 0) {
                a(true, null);
            }
        }

        public void close() throws IOException {
            if (!this.f9264b) {
                if (this.f9278e != 0 && !g.d0.c.a((x) this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, null);
                }
                this.f9264b = true;
            }
        }

        public long read(h.e eVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.f9264b) {
                long j3 = this.f9278e;
                if (j3 == 0) {
                    return -1;
                }
                long read = super.read(eVar, Math.min(j3, j2));
                if (read != -1) {
                    long j4 = this.f9278e - read;
                    this.f9278e = j4;
                    if (j4 == 0) {
                        a(true, null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* compiled from: Http1Codec */
    public class g extends b {

        /* renamed from: e reason: collision with root package name */
        public boolean f9279e;

        public g(a aVar) {
            super(null);
        }

        public void close() throws IOException {
            if (!this.f9264b) {
                if (!this.f9279e) {
                    a(false, null);
                }
                this.f9264b = true;
            }
        }

        public long read(h.e eVar, long j2) throws IOException {
            if (j2 < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(j2);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.f9264b) {
                throw new IllegalStateException("closed");
            } else if (this.f9279e) {
                return -1;
            } else {
                long read = super.read(eVar, j2);
                if (read != -1) {
                    return read;
                }
                this.f9279e = true;
                a(true, null);
                return -1;
            }
        }
    }

    public a(u uVar, g.d0.e.g gVar, h.g gVar2, h.f fVar) {
        this.f9258a = uVar;
        this.f9259b = gVar;
        this.f9260c = gVar2;
        this.f9261d = fVar;
    }

    public void a(k kVar) {
        y yVar = kVar.f9655e;
        kVar.f9655e = y.f9690d;
        yVar.a();
        yVar.b();
    }

    public void b() throws IOException {
        this.f9261d.flush();
    }

    public q c() throws IOException {
        g.q.a aVar = new g.q.a();
        while (true) {
            String j2 = this.f9260c.j();
            if (j2.length() == 0) {
                return new q(aVar);
            }
            if (((g.u.a) g.d0.a.f9172a) != null) {
                String str = Config.TRACE_TODAY_VISIT_SPLIT;
                int indexOf = j2.indexOf(str, 1);
                if (indexOf != -1) {
                    aVar.a(j2.substring(0, indexOf), j2.substring(indexOf + 1));
                } else {
                    String str2 = "";
                    if (j2.startsWith(str)) {
                        String substring = j2.substring(1);
                        aVar.f9533a.add(str2);
                        aVar.f9533a.add(substring.trim());
                    } else {
                        aVar.f9533a.add(str2);
                        aVar.f9533a.add(j2.trim());
                    }
                }
            } else {
                throw null;
            }
        }
    }

    public void cancel() {
        g.d0.e.c c2 = this.f9259b.c();
        if (c2 != null) {
            g.d0.c.a(c2.f9200d);
        }
    }

    public w a(g.x xVar, long j2) {
        String str = "state: ";
        if ("chunked".equalsIgnoreCase(xVar.f9597c.a(Headers.TRANSFER_ENCODING))) {
            if (this.f9262e == 1) {
                this.f9262e = 2;
                return new c();
            }
            StringBuilder a2 = e.a.a.a.a.a(str);
            a2.append(this.f9262e);
            throw new IllegalStateException(a2.toString());
        } else if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f9262e == 1) {
            this.f9262e = 2;
            return new e(j2);
        } else {
            StringBuilder a3 = e.a.a.a.a.a(str);
            a3.append(this.f9262e);
            throw new IllegalStateException(a3.toString());
        }
    }

    public void a(g.x xVar) throws IOException {
        Type type = this.f9259b.c().f9199c.f9145b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.f9596b);
        sb.append(' ');
        if (!xVar.f9595a.f9535a.equals("https") && type == Type.HTTP) {
            sb.append(xVar.f9595a);
        } else {
            sb.append(n.a(xVar.f9595a));
        }
        sb.append(" HTTP/1.1");
        a(xVar.f9597c, sb.toString());
    }

    public a0 a(z zVar) throws IOException {
        String str = null;
        if (this.f9259b.f9225f != null) {
            String a2 = zVar.f9619f.a("Content-Type");
            if (a2 == null) {
                a2 = null;
            }
            if (!g.d0.f.e.b(zVar)) {
                return new g.d0.f.g(a2, 0, o.a(a(0)));
            }
            String a3 = zVar.f9619f.a(Headers.TRANSFER_ENCODING);
            if (a3 != null) {
                str = a3;
            }
            String str2 = "state: ";
            if ("chunked".equalsIgnoreCase(str)) {
                r rVar = zVar.f9614a.f9595a;
                if (this.f9262e == 4) {
                    this.f9262e = 5;
                    return new g.d0.f.g(a2, -1, o.a((x) new d(rVar)));
                }
                StringBuilder a4 = e.a.a.a.a.a(str2);
                a4.append(this.f9262e);
                throw new IllegalStateException(a4.toString());
            }
            long a5 = g.d0.f.e.a(zVar);
            if (a5 != -1) {
                return new g.d0.f.g(a2, a5, o.a(a(a5)));
            }
            if (this.f9262e == 4) {
                g.d0.e.g gVar = this.f9259b;
                if (gVar != null) {
                    this.f9262e = 5;
                    gVar.d();
                    return new g.d0.f.g(a2, -1, o.a((x) new g(this)));
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            StringBuilder a6 = e.a.a.a.a.a(str2);
            a6.append(this.f9262e);
            throw new IllegalStateException(a6.toString());
        }
        throw null;
    }

    public void a() throws IOException {
        this.f9261d.flush();
    }

    public void a(q qVar, String str) throws IOException {
        if (this.f9262e == 0) {
            h.f c2 = this.f9261d.c(str);
            String str2 = MultipartUtility.CTRLF;
            c2.c(str2);
            int b2 = qVar.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f9261d.c(qVar.a(i2)).c(": ").c(qVar.b(i2)).c(str2);
            }
            this.f9261d.c(str2);
            this.f9262e = 1;
            return;
        }
        StringBuilder a2 = e.a.a.a.a.a("state: ");
        a2.append(this.f9262e);
        throw new IllegalStateException(a2.toString());
    }

    public g.z.a a(boolean z) throws IOException {
        int i2 = this.f9262e;
        if (i2 == 1 || i2 == 3) {
            try {
                i a2 = i.a(this.f9260c.j());
                g.z.a aVar = new g.z.a();
                aVar.f9625b = a2.f9255a;
                aVar.f9626c = a2.f9256b;
                aVar.f9627d = a2.f9257c;
                aVar.a(c());
                if (z && a2.f9256b == 100) {
                    return null;
                }
                this.f9262e = 4;
                return aVar;
            } catch (EOFException e2) {
                StringBuilder a3 = e.a.a.a.a.a("unexpected end of stream on ");
                a3.append(this.f9259b);
                IOException iOException = new IOException(a3.toString());
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            StringBuilder a4 = e.a.a.a.a.a("state: ");
            a4.append(this.f9262e);
            throw new IllegalStateException(a4.toString());
        }
    }

    public x a(long j2) throws IOException {
        if (this.f9262e == 4) {
            this.f9262e = 5;
            return new f(this, j2);
        }
        StringBuilder a2 = e.a.a.a.a.a("state: ");
        a2.append(this.f9262e);
        throw new IllegalStateException(a2.toString());
    }
}
