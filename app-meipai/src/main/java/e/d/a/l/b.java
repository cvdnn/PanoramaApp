package e.d.a.l;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public class b implements Closeable {

    /* renamed from: a reason: collision with root package name */
    public final InputStream f7170a;

    /* renamed from: b reason: collision with root package name */
    public final Charset f7171b;

    /* renamed from: c reason: collision with root package name */
    public byte[] f7172c;

    /* renamed from: d reason: collision with root package name */
    public int f7173d;

    /* renamed from: e reason: collision with root package name */
    public int f7174e;

    /* compiled from: StrictLineReader */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        public String toString() {
            int i2 = this.count;
            try {
                return new String(this.buf, 0, (i2 <= 0 || this.buf[i2 + -1] != 13) ? this.count : i2 - 1, b.this.f7171b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (charset.equals(c.f7176a)) {
            this.f7170a = inputStream;
            this.f7171b = charset;
            this.f7172c = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void a() throws IOException {
        InputStream inputStream = this.f7170a;
        byte[] bArr = this.f7172c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f7173d = 0;
            this.f7174e = read;
            return;
        }
        throw new EOFException();
    }

    public String b() throws IOException {
        int i2;
        int i3;
        synchronized (this.f7170a) {
            if (this.f7172c != null) {
                if (this.f7173d >= this.f7174e) {
                    a();
                }
                for (int i4 = this.f7173d; i4 != this.f7174e; i4++) {
                    if (this.f7172c[i4] == 10) {
                        if (i4 != this.f7173d) {
                            i3 = i4 - 1;
                            if (this.f7172c[i3] == 13) {
                                String str = new String(this.f7172c, this.f7173d, i3 - this.f7173d, this.f7171b.name());
                                this.f7173d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f7172c, this.f7173d, i3 - this.f7173d, this.f7171b.name());
                        this.f7173d = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f7174e - this.f7173d) + 80);
                loop1:
                while (true) {
                    aVar.write(this.f7172c, this.f7173d, this.f7174e - this.f7173d);
                    this.f7174e = -1;
                    a();
                    i2 = this.f7173d;
                    while (true) {
                        if (i2 != this.f7174e) {
                            if (this.f7172c[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                if (i2 != this.f7173d) {
                    aVar.write(this.f7172c, this.f7173d, i2 - this.f7173d);
                }
                this.f7173d = i2 + 1;
                String aVar2 = aVar.toString();
                return aVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public void close() throws IOException {
        synchronized (this.f7170a) {
            if (this.f7172c != null) {
                this.f7172c = null;
                this.f7170a.close();
            }
        }
    }
}
