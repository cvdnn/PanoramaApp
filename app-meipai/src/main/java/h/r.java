package h;

import e.a.a.a.a;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
public final class r implements f {

    /* renamed from: a reason: collision with root package name */
    public final e f9672a = new e();

    /* renamed from: b reason: collision with root package name */
    public final w f9673b;

    /* renamed from: c reason: collision with root package name */
    public boolean f9674c;

    public r(w wVar) {
        if (wVar != null) {
            this.f9673b = wVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public void a(e eVar, long j2) throws IOException {
        if (!this.f9674c) {
            this.f9672a.a(eVar, j2);
            h();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public f b(String str, int i2, int i3) throws IOException {
        if (!this.f9674c) {
            this.f9672a.b(str, i2, i3);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public e c() {
        return this.f9672a;
    }

    public void close() throws IOException {
        if (!this.f9674c) {
            try {
                if (this.f9672a.f9647b > 0) {
                    this.f9673b.a(this.f9672a, this.f9672a.f9647b);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f9673b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f9674c = true;
            if (th != null) {
                z.a(th);
                throw null;
            }
        }
    }

    public f d(long j2) throws IOException {
        if (!this.f9674c) {
            this.f9672a.d(j2);
            return h();
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.f9674c) {
            e eVar = this.f9672a;
            long j2 = eVar.f9647b;
            if (j2 > 0) {
                this.f9673b.a(eVar, j2);
            }
            this.f9673b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public f h() throws IOException {
        if (!this.f9674c) {
            e eVar = this.f9672a;
            long j2 = eVar.f9647b;
            if (j2 == 0) {
                j2 = 0;
            } else {
                t tVar = eVar.f9646a.f9685g;
                int i2 = tVar.f9681c;
                if (i2 < 8192 && tVar.f9683e) {
                    j2 -= (long) (i2 - tVar.f9680b);
                }
            }
            if (j2 > 0) {
                this.f9673b.a(this.f9672a, j2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f9674c;
    }

    public y timeout() {
        return this.f9673b.timeout();
    }

    public String toString() {
        StringBuilder a2 = a.a("buffer(");
        a2.append(this.f9673b);
        a2.append(")");
        return a2.toString();
    }

    public f write(byte[] bArr) throws IOException {
        if (!this.f9674c) {
            this.f9672a.write(bArr);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public f writeByte(int i2) throws IOException {
        if (!this.f9674c) {
            this.f9672a.writeByte(i2);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public f writeInt(int i2) throws IOException {
        if (!this.f9674c) {
            this.f9672a.writeInt(i2);
            return h();
        }
        throw new IllegalStateException("closed");
    }

    public f writeShort(int i2) throws IOException {
        if (!this.f9674c) {
            this.f9672a.writeShort(i2);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public f c(h hVar) throws IOException {
        if (!this.f9674c) {
            this.f9672a.c(hVar);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public long a(x xVar) throws IOException {
        if (xVar != null) {
            long j2 = 0;
            while (true) {
                long read = xVar.read(this.f9672a, 8192);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
                h();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public f write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f9674c) {
            this.f9672a.write(bArr, i2, i3);
            h();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public f c(String str) throws IOException {
        if (!this.f9674c) {
            this.f9672a.c(str);
            return h();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f9674c) {
            int write = this.f9672a.write(byteBuffer);
            h();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
