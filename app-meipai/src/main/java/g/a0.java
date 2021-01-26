package g;

import g.d0.c;
import h.e;
import h.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: ResponseBody */
public abstract class a0 implements Closeable {
    public Reader reader;

    /* compiled from: ResponseBody */
    public class a extends a0 {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ t f9136a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ long f9137b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ g f9138c;

        public a(t tVar, long j2, g gVar) {
            this.f9136a = tVar;
            this.f9137b = j2;
            this.f9138c = gVar;
        }

        public long contentLength() {
            return this.f9137b;
        }

        public t contentType() {
            return this.f9136a;
        }

        public g source() {
            return this.f9138c;
        }
    }

    /* compiled from: ResponseBody */
    public static final class b extends Reader {

        /* renamed from: a reason: collision with root package name */
        public final g f9139a;

        /* renamed from: b reason: collision with root package name */
        public final Charset f9140b;

        /* renamed from: c reason: collision with root package name */
        public boolean f9141c;

        /* renamed from: d reason: collision with root package name */
        public Reader f9142d;

        public b(g gVar, Charset charset) {
            this.f9139a = gVar;
            this.f9140b = charset;
        }

        public void close() throws IOException {
            this.f9141c = true;
            Reader reader = this.f9142d;
            if (reader != null) {
                reader.close();
            } else {
                this.f9139a.close();
            }
        }

        public int read(char[] cArr, int i2, int i3) throws IOException {
            if (!this.f9141c) {
                Reader reader = this.f9142d;
                if (reader == null) {
                    Reader inputStreamReader = new InputStreamReader(this.f9139a.p(), c.a(this.f9139a, this.f9140b));
                    this.f9142d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        t contentType = contentType();
        Charset charset = c.f9183j;
        if (contentType == null) {
            return charset;
        }
        try {
            return contentType.f9560b != null ? Charset.forName(contentType.f9560b) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static g.a0 create(g.t r4, java.lang.String r5) {
        /*
            java.nio.charset.Charset r0 = g.d0.c.f9183j
            if (r4 == 0) goto L_0x0029
            java.lang.String r0 = r4.f9560b     // Catch:{ IllegalArgumentException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r4.f9560b     // Catch:{ IllegalArgumentException -> 0x000f }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ IllegalArgumentException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0029
            java.nio.charset.Charset r0 = g.d0.c.f9183j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r4 = "; charset=utf-8"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            g.t r4 = g.t.a(r4)
        L_0x0029:
            h.e r1 = new h.e
            r1.<init>()
            int r2 = r5.length()
            r3 = 0
            r1.a(r5, r3, r2, r0)
            long r2 = r1.f9647b
            g.a0 r4 = create(r4, r2, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a0.create(g.t, java.lang.String):g.a0");
    }

    public final InputStream byteStream() {
        return source().p();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            g source = source();
            try {
                byte[] f2 = source.f();
                c.a((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) f2.length)) {
                    return f2;
                }
                throw new IOException(e.a.a.a.a.a(e.a.a.a.a.a("Content-Length (", contentLength, ") and stream length ("), f2.length, ") disagree"));
            } catch (Throwable th) {
                c.a((Closeable) source);
                throw th;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot buffer entire body for content length: ");
            sb.append(contentLength);
            throw new IOException(sb.toString());
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        b bVar = new b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    public void close() {
        c.a((Closeable) source());
    }

    public abstract long contentLength();

    public abstract t contentType();

    public abstract g source();

    public final String string() throws IOException {
        g source = source();
        try {
            return source.a(c.a(source, charset()));
        } finally {
            c.a((Closeable) source);
        }
    }

    public static a0 create(t tVar, byte[] bArr) {
        e eVar = new e();
        eVar.write(bArr);
        return create(tVar, (long) bArr.length, eVar);
    }

    public static a0 create(t tVar, long j2, g gVar) {
        if (gVar != null) {
            return new a(tVar, j2, gVar);
        }
        throw new NullPointerException("source == null");
    }
}
