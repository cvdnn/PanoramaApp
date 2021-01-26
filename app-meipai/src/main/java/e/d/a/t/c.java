package e.d.a.t;

import e.a.a.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream */
public final class c extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    public final long f7905a;

    /* renamed from: b reason: collision with root package name */
    public int f7906b;

    public c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f7905a = j2;
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f7906b += i2;
        } else if (this.f7905a - ((long) this.f7906b) > 0) {
            StringBuilder a2 = a.a("Failed to read all expected data, expected: ");
            a2.append(this.f7905a);
            a2.append(", but read: ");
            a2.append(this.f7906b);
            throw new IOException(a2.toString());
        }
        return i2;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f7905a - ((long) this.f7906b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        a(read);
        return read;
    }
}
