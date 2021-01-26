package e.d.a.n.m;

import e.d.a.n.n.c0.b;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream */
public final class c extends OutputStream {

    /* renamed from: a reason: collision with root package name */
    public final OutputStream f7238a;

    /* renamed from: b reason: collision with root package name */
    public byte[] f7239b;

    /* renamed from: c reason: collision with root package name */
    public b f7240c;

    /* renamed from: d reason: collision with root package name */
    public int f7241d;

    public c(OutputStream outputStream, b bVar) {
        this.f7238a = outputStream;
        this.f7240c = bVar;
        this.f7239b = (byte[]) bVar.b(65536, byte[].class);
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f7238a.close();
            byte[] bArr = this.f7239b;
            if (bArr != null) {
                this.f7240c.a(bArr);
                this.f7239b = null;
            }
        } catch (Throwable th) {
            this.f7238a.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        int i2 = this.f7241d;
        if (i2 > 0) {
            this.f7238a.write(this.f7239b, 0, i2);
            this.f7241d = 0;
        }
        this.f7238a.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f7239b;
        int i3 = this.f7241d;
        int i4 = i3 + 1;
        this.f7241d = i4;
        bArr[i3] = (byte) i2;
        if (i4 == bArr.length && i4 > 0) {
            this.f7238a.write(bArr, 0, i4);
            this.f7241d = 0;
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f7241d != 0 || i5 < this.f7239b.length) {
                int min = Math.min(i5, this.f7239b.length - this.f7241d);
                System.arraycopy(bArr, i6, this.f7239b, this.f7241d, min);
                int i7 = this.f7241d + min;
                this.f7241d = i7;
                i4 += min;
                byte[] bArr2 = this.f7239b;
                if (i7 == bArr2.length && i7 > 0) {
                    this.f7238a.write(bArr2, 0, i7);
                    this.f7241d = 0;
                    continue;
                }
            } else {
                this.f7238a.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
