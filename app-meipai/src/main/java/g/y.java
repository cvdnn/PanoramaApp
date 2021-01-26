package g;

import h.f;
import h.h;
import h.o;
import h.x;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* compiled from: RequestBody */
public abstract class y {

    /* compiled from: RequestBody */
    public class a extends y {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ t f9606a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ h f9607b;

        public a(t tVar, h hVar) {
            this.f9606a = tVar;
            this.f9607b = hVar;
        }

        public long contentLength() throws IOException {
            return (long) this.f9607b.d();
        }

        public t contentType() {
            return this.f9606a;
        }

        public void writeTo(f fVar) throws IOException {
            fVar.c(this.f9607b);
        }
    }

    /* compiled from: RequestBody */
    public class b extends y {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ t f9608a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f9609b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ byte[] f9610c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ int f9611d;

        public b(t tVar, int i2, byte[] bArr, int i3) {
            this.f9608a = tVar;
            this.f9609b = i2;
            this.f9610c = bArr;
            this.f9611d = i3;
        }

        public long contentLength() {
            return (long) this.f9609b;
        }

        public t contentType() {
            return this.f9608a;
        }

        public void writeTo(f fVar) throws IOException {
            fVar.write(this.f9610c, this.f9611d, this.f9609b);
        }
    }

    /* compiled from: RequestBody */
    public class c extends y {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ t f9612a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ File f9613b;

        public c(t tVar, File file) {
            this.f9612a = tVar;
            this.f9613b = file;
        }

        public long contentLength() {
            return this.f9613b.length();
        }

        public t contentType() {
            return this.f9612a;
        }

        public void writeTo(f fVar) throws IOException {
            x xVar = null;
            try {
                xVar = o.a(this.f9613b);
                fVar.a(xVar);
            } finally {
                g.d0.c.a((Closeable) xVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static g.y create(g.t r2, java.lang.String r3) {
        /*
            java.nio.charset.Charset r0 = g.d0.c.f9183j
            if (r2 == 0) goto L_0x0029
            java.lang.String r0 = r2.f9560b     // Catch:{ IllegalArgumentException -> 0x000f }
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r2.f9560b     // Catch:{ IllegalArgumentException -> 0x000f }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ IllegalArgumentException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0029
            java.nio.charset.Charset r0 = g.d0.c.f9183j
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "; charset=utf-8"
            r1.append(r2)
            java.lang.String r2 = r1.toString()
            g.t r2 = g.t.a(r2)
        L_0x0029:
            byte[] r3 = r3.getBytes(r0)
            g.y r2 = create(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.y.create(g.t, java.lang.String):g.y");
    }

    public abstract long contentLength() throws IOException;

    public abstract t contentType();

    public abstract void writeTo(f fVar) throws IOException;

    public static y create(t tVar, h hVar) {
        return new a(tVar, hVar);
    }

    public static y create(t tVar, byte[] bArr) {
        return create(tVar, bArr, 0, bArr.length);
    }

    public static y create(t tVar, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            g.d0.c.a((long) bArr.length, (long) i2, (long) i3);
            return new b(tVar, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }

    public static y create(t tVar, File file) {
        if (file != null) {
            return new c(tVar, file);
        }
        throw new NullPointerException("content == null");
    }
}
