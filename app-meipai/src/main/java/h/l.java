package h;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class l implements x {

    /* renamed from: a reason: collision with root package name */
    public int f9656a = 0;

    /* renamed from: b reason: collision with root package name */
    public final g f9657b;

    /* renamed from: c reason: collision with root package name */
    public final Inflater f9658c;

    /* renamed from: d reason: collision with root package name */
    public final m f9659d;

    /* renamed from: e reason: collision with root package name */
    public final CRC32 f9660e = new CRC32();

    public l(x xVar) {
        if (xVar != null) {
            this.f9658c = new Inflater(true);
            g a2 = o.a(xVar);
            this.f9657b = a2;
            this.f9659d = new m(a2, this.f9658c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final void a(e eVar, long j2, long j3) {
        t tVar = eVar.f9646a;
        while (true) {
            int i2 = tVar.f9681c;
            int i3 = tVar.f9680b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            tVar = tVar.f9684f;
        }
        while (j3 > 0) {
            int i4 = (int) (((long) tVar.f9680b) + j2);
            int min = (int) Math.min((long) (tVar.f9681c - i4), j3);
            this.f9660e.update(tVar.f9679a, i4, min);
            j3 -= (long) min;
            tVar = tVar.f9684f;
            j2 = 0;
        }
    }

    public void close() throws IOException {
        this.f9659d.close();
    }

    public long read(e eVar, long j2) throws IOException {
        long j3;
        e eVar2 = eVar;
        long j4 = j2;
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f9656a == 0) {
                this.f9657b.g(10);
                byte a2 = this.f9657b.c().a(3);
                boolean z = ((a2 >> 1) & 1) == 1;
                if (z) {
                    a(this.f9657b.c(), 0, 10);
                }
                a("ID1ID2", 8075, (int) this.f9657b.readShort());
                this.f9657b.skip(8);
                if (((a2 >> 2) & 1) == 1) {
                    this.f9657b.g(2);
                    if (z) {
                        a(this.f9657b.c(), 0, 2);
                    }
                    long n = (long) this.f9657b.c().n();
                    this.f9657b.g(n);
                    if (z) {
                        j3 = n;
                        a(this.f9657b.c(), 0, n);
                    } else {
                        j3 = n;
                    }
                    this.f9657b.skip(j3);
                }
                if (((a2 >> 3) & 1) == 1) {
                    long a3 = this.f9657b.a(0);
                    if (a3 != -1) {
                        if (z) {
                            a(this.f9657b.c(), 0, a3 + 1);
                        }
                        this.f9657b.skip(a3 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((a2 >> 4) & 1) == 1) {
                    long a4 = this.f9657b.a(0);
                    if (a4 != -1) {
                        if (z) {
                            a(this.f9657b.c(), 0, a4 + 1);
                        }
                        this.f9657b.skip(a4 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    a("FHCRC", (int) this.f9657b.n(), (int) (short) ((int) this.f9660e.getValue()));
                    this.f9660e.reset();
                }
                this.f9656a = 1;
            }
            if (this.f9656a == 1) {
                long j5 = eVar2.f9647b;
                long read = this.f9659d.read(eVar2, j4);
                if (read != -1) {
                    a(eVar, j5, read);
                    return read;
                }
                this.f9656a = 2;
            }
            if (this.f9656a == 2) {
                a("CRC", this.f9657b.k(), (int) this.f9660e.getValue());
                a("ISIZE", this.f9657b.k(), (int) this.f9658c.getBytesWritten());
                this.f9656a = 3;
                if (!this.f9657b.g()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public y timeout() {
        return this.f9657b.timeout();
    }

    public final void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        }
    }
}
