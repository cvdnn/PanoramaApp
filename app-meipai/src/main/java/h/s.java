package h;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
public final class s implements g {

    /* renamed from: a reason: collision with root package name */
    public final e f9675a = new e();

    /* renamed from: b reason: collision with root package name */
    public final x f9676b;

    /* renamed from: c reason: collision with root package name */
    public boolean f9677c;

    /* compiled from: RealBufferedSource */
    public class a extends InputStream {
        public a() {
        }

        public int available() throws IOException {
            s sVar = s.this;
            if (!sVar.f9677c) {
                return (int) Math.min(sVar.f9675a.f9647b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            s.this.close();
        }

        public int read() throws IOException {
            s sVar = s.this;
            if (!sVar.f9677c) {
                e eVar = sVar.f9675a;
                if (eVar.f9647b == 0 && sVar.f9676b.read(eVar, 8192) == -1) {
                    return -1;
                }
                return s.this.f9675a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(s.this);
            sb.append(".inputStream()");
            return sb.toString();
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!s.this.f9677c) {
                z.a((long) bArr.length, (long) i2, (long) i3);
                s sVar = s.this;
                e eVar = sVar.f9675a;
                if (eVar.f9647b == 0 && sVar.f9676b.read(eVar, 8192) == -1) {
                    return -1;
                }
                return s.this.f9675a.a(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    public s(x xVar) {
        if (xVar != null) {
            this.f9676b = xVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public int a(q qVar) throws IOException {
        if (!this.f9677c) {
            do {
                int a2 = this.f9675a.a(qVar, true);
                if (a2 == -1) {
                    return -1;
                }
                if (a2 != -2) {
                    this.f9675a.skip((long) qVar.f9670a[a2].d());
                    return a2;
                }
            } while (this.f9676b.read(this.f9675a, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public long b(h hVar) throws IOException {
        if (!this.f9677c) {
            long j2 = 0;
            while (true) {
                long b2 = this.f9675a.b(hVar, j2);
                if (b2 != -1) {
                    return b2;
                }
                e eVar = this.f9675a;
                long j3 = eVar.f9647b;
                if (this.f9676b.read(eVar, 8192) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, j3);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public e c() {
        return this.f9675a;
    }

    public void close() throws IOException {
        if (!this.f9677c) {
            this.f9677c = true;
            this.f9676b.close();
            this.f9675a.a();
        }
    }

    public boolean e(long j2) throws IOException {
        e eVar;
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f9677c) {
            do {
                eVar = this.f9675a;
                if (eVar.f9647b >= j2) {
                    return true;
                }
            } while (this.f9676b.read(eVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte[] f(long j2) throws IOException {
        if (e(j2)) {
            return this.f9675a.f(j2);
        }
        throw new EOFException();
    }

    public boolean g() throws IOException {
        if (!this.f9677c) {
            return this.f9675a.g() && this.f9676b.read(this.f9675a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public e getBuffer() {
        return this.f9675a;
    }

    public boolean isOpen() {
        return !this.f9677c;
    }

    public String j() throws IOException {
        long a2 = a(10, 0, RecyclerView.FOREVER_NS);
        if (a2 != -1) {
            return this.f9675a.h(a2);
        }
        e eVar = new e();
        e eVar2 = this.f9675a;
        eVar2.a(eVar, 0, Math.min(32, eVar2.f9647b));
        StringBuilder a3 = e.a.a.a.a.a("\\n not found: limit=");
        a3.append(Math.min(this.f9675a.f9647b, RecyclerView.FOREVER_NS));
        a3.append(" content=");
        a3.append(eVar.b().b());
        a3.append(8230);
        throw new EOFException(a3.toString());
    }

    public int k() throws IOException {
        g(4);
        return this.f9675a.k();
    }

    public short n() throws IOException {
        g(2);
        return this.f9675a.n();
    }

    public long o() throws IOException {
        g(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!e((long) i3)) {
                break;
            }
            byte a2 = this.f9675a.a((long) i2);
            if ((a2 >= 48 && a2 <= 57) || ((a2 >= 97 && a2 <= 102) || (a2 >= 65 && a2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(a2)}));
            }
        }
        return this.f9675a.o();
    }

    public InputStream p() {
        return new a();
    }

    public long read(e eVar, long j2) throws IOException {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f9677c) {
            e eVar2 = this.f9675a;
            if (eVar2.f9647b == 0 && this.f9676b.read(eVar2, 8192) == -1) {
                return -1;
            }
            return this.f9675a.read(eVar, Math.min(j2, this.f9675a.f9647b));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() throws IOException {
        g(1);
        return this.f9675a.readByte();
    }

    public int readInt() throws IOException {
        g(4);
        return this.f9675a.readInt();
    }

    public short readShort() throws IOException {
        g(2);
        return this.f9675a.readShort();
    }

    public void skip(long j2) throws IOException {
        if (!this.f9677c) {
            while (j2 > 0) {
                e eVar = this.f9675a;
                if (eVar.f9647b == 0 && this.f9676b.read(eVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f9675a.f9647b);
                this.f9675a.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public y timeout() {
        return this.f9676b.timeout();
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("buffer(");
        a2.append(this.f9676b);
        a2.append(")");
        return a2.toString();
    }

    public h c(long j2) throws IOException {
        if (e(j2)) {
            return this.f9675a.c(j2);
        }
        throw new EOFException();
    }

    public byte[] f() throws IOException {
        this.f9675a.a(this.f9676b);
        return this.f9675a.f();
    }

    public void g(long j2) throws IOException {
        if (!e(j2)) {
            throw new EOFException();
        }
    }

    public void a(byte[] bArr) throws IOException {
        try {
            g((long) bArr.length);
            this.f9675a.a(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                e eVar = this.f9675a;
                long j2 = eVar.f9647b;
                if (j2 > 0) {
                    int a2 = eVar.a(bArr, i2, (int) j2);
                    if (a2 != -1) {
                        i2 += a2;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        e eVar = this.f9675a;
        if (eVar.f9647b == 0 && this.f9676b.read(eVar, 8192) == -1) {
            return -1;
        }
        return this.f9675a.read(byteBuffer);
    }

    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f9675a.a(this.f9676b);
            return this.f9675a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, RecyclerView.FOREVER_NS);
    }

    public long a(byte b2, long j2, long j3) throws IOException {
        if (this.f9677c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3)}));
        } else {
            while (j2 < j3) {
                long a2 = this.f9675a.a(b2, j2, j3);
                if (a2 == -1) {
                    e eVar = this.f9675a;
                    long j4 = eVar.f9647b;
                    if (j4 >= j3 || this.f9676b.read(eVar, 8192) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    public long a(h hVar) throws IOException {
        if (!this.f9677c) {
            long j2 = 0;
            while (true) {
                long a2 = this.f9675a.a(hVar, j2);
                if (a2 != -1) {
                    return a2;
                }
                e eVar = this.f9675a;
                long j3 = eVar.f9647b;
                if (this.f9676b.read(eVar, 8192) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, (j3 - ((long) hVar.d())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean a(long j2, h hVar) throws IOException {
        int d2 = hVar.d();
        if (this.f9677c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || d2 < 0 || hVar.d() - 0 < d2) {
            return false;
        } else {
            for (int i2 = 0; i2 < d2; i2++) {
                long j3 = ((long) i2) + j2;
                if (!e(1 + j3) || this.f9675a.a(j3) != hVar.a(0 + i2)) {
                    return false;
                }
            }
            return true;
        }
    }
}
