package e.d.a.n.m;

import com.facebook.stetho.dumpapp.Framer;
import e.a.a.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExifOrientationStream */
public final class g extends FilterInputStream {

    /* renamed from: c reason: collision with root package name */
    public static final byte[] f7245c;

    /* renamed from: d reason: collision with root package name */
    public static final int f7246d;

    /* renamed from: e reason: collision with root package name */
    public static final int f7247e;

    /* renamed from: a reason: collision with root package name */
    public final byte f7248a;

    /* renamed from: b reason: collision with root package name */
    public int f7249b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f7245c = bArr;
        int length = bArr.length;
        f7246d = length;
        f7247e = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(a.a("Cannot add invalid orientation: ", i2));
        }
        this.f7248a = (byte) i2;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.f7249b
            r1 = 2
            if (r0 < r1) goto L_0x0017
            int r2 = f7247e
            if (r0 <= r2) goto L_0x000a
            goto L_0x0017
        L_0x000a:
            if (r0 != r2) goto L_0x000f
            byte r0 = r3.f7248a
            goto L_0x001b
        L_0x000f:
            byte[] r2 = f7245c
            int r0 = r0 - r1
            byte r0 = r2[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            goto L_0x001b
        L_0x0017:
            int r0 = super.read()
        L_0x001b:
            r1 = -1
            if (r0 == r1) goto L_0x0024
            int r1 = r3.f7249b
            int r1 = r1 + 1
            r3.f7249b = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.m.g.read():int");
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f7249b = (int) (((long) this.f7249b) + skip);
        }
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f7249b;
        int i6 = f7247e;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f7248a;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f7245c, this.f7249b - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f7249b += i4;
        }
        return i4;
    }
}
