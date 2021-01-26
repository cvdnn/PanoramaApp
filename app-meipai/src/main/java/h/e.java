package h;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
public final class e implements g, f, Cloneable, ByteChannel {

    /* renamed from: c reason: collision with root package name */
    public static final byte[] f9645c = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a reason: collision with root package name */
    public t f9646a;

    /* renamed from: b reason: collision with root package name */
    public long f9647b;

    /* compiled from: Buffer */
    public class a extends InputStream {
        public a() {
        }

        public int available() {
            return (int) Math.min(e.this.f9647b, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            e eVar = e.this;
            if (eVar.f9647b > 0) {
                return eVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(e.this);
            sb.append(".inputStream()");
            return sb.toString();
        }

        public int read(byte[] bArr, int i2, int i3) {
            return e.this.a(bArr, i2, i3);
        }
    }

    public final e a(e eVar, long j2, long j3) {
        if (eVar != null) {
            z.a(this.f9647b, j2, j3);
            if (j3 == 0) {
                return this;
            }
            eVar.f9647b += j3;
            t tVar = this.f9646a;
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
                t b2 = tVar.b();
                int i4 = (int) (((long) b2.f9680b) + j2);
                b2.f9680b = i4;
                b2.f9681c = Math.min(i4 + ((int) j3), b2.f9681c);
                t tVar2 = eVar.f9646a;
                if (tVar2 == null) {
                    b2.f9685g = b2;
                    b2.f9684f = b2;
                    eVar.f9646a = b2;
                } else {
                    tVar2.f9685g.a(b2);
                }
                j3 -= (long) (b2.f9681c - b2.f9680b);
                tVar = tVar.f9684f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public e c() {
        return this;
    }

    public void close() {
    }

    public boolean e(long j2) {
        return this.f9647b >= j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        long j2 = this.f9647b;
        if (j2 != eVar.f9647b) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        t tVar = this.f9646a;
        t tVar2 = eVar.f9646a;
        int i2 = tVar.f9680b;
        int i3 = tVar2.f9680b;
        while (j3 < this.f9647b) {
            long min = (long) Math.min(tVar.f9681c - i2, tVar2.f9681c - i3);
            int i4 = 0;
            while (((long) i4) < min) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (tVar.f9679a[i2] != tVar2.f9679a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == tVar.f9681c) {
                tVar = tVar.f9684f;
                i2 = tVar.f9680b;
            }
            if (i3 == tVar2.f9681c) {
                tVar2 = tVar2.f9684f;
                i3 = tVar2.f9680b;
            }
            j3 += min;
        }
        return true;
    }

    public byte[] f() {
        try {
            return f(this.f9647b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void flush() {
    }

    public boolean g() {
        return this.f9647b == 0;
    }

    public e getBuffer() {
        return this;
    }

    public f h() throws IOException {
        return this;
    }

    public String h(long j2) throws EOFException {
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (a(j3) == 13) {
                String b2 = b(j3);
                skip(2);
                return b2;
            }
        }
        String b3 = b(j2);
        skip(1);
        return b3;
    }

    public int hashCode() {
        t tVar = this.f9646a;
        if (tVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            for (int i3 = tVar.f9680b; i3 < tVar.f9681c; i3++) {
                i2 = (i2 * 31) + tVar.f9679a[i3];
            }
            tVar = tVar.f9684f;
        } while (tVar != this.f9646a);
        return i2;
    }

    public boolean isOpen() {
        return true;
    }

    public String j() throws EOFException {
        long a2 = a(10, 0, (long) RecyclerView.FOREVER_NS);
        if (a2 != -1) {
            return h(a2);
        }
        if (RecyclerView.FOREVER_NS < this.f9647b && a(9223372036854775806L) == 13 && a((long) RecyclerView.FOREVER_NS) == 10) {
            return h(RecyclerView.FOREVER_NS);
        }
        e eVar = new e();
        a(eVar, 0, Math.min(32, this.f9647b));
        StringBuilder a3 = e.a.a.a.a.a("\\n not found: limit=");
        a3.append(Math.min(this.f9647b, RecyclerView.FOREVER_NS));
        a3.append(" content=");
        a3.append(eVar.b().b());
        a3.append(8230);
        throw new EOFException(a3.toString());
    }

    public int k() {
        return z.a(readInt());
    }

    public short n() {
        return z.a(readShort());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r8 != r9) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        r14.f9646a = r6.a();
        h.u.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        r6.f9680b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        if (r1 != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long o() {
        /*
            r14 = this;
            long r0 = r14.f9647b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a1
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            h.t r6 = r14.f9646a
            byte[] r7 = r6.f9679a
            int r8 = r6.f9680b
            int r9 = r6.f9681c
        L_0x0013:
            if (r8 >= r9) goto L_0x0086
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0039
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -97
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006b
            r11 = 70
            if (r10 > r11) goto L_0x006b
            int r11 = r10 + -65
        L_0x0037:
            int r11 = r11 + 10
        L_0x0039:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0049
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0049:
            h.e r0 = new h.e
            r0.<init>()
            r0.d(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            java.lang.String r0 = r0.e()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006b:
            if (r0 == 0) goto L_0x006f
            r1 = 1
            goto L_0x0086
        L_0x006f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0086:
            if (r8 != r9) goto L_0x0092
            h.t r7 = r6.a()
            r14.f9646a = r7
            h.u.a(r6)
            goto L_0x0094
        L_0x0092:
            r6.f9680b = r8
        L_0x0094:
            if (r1 != 0) goto L_0x009a
            h.t r6 = r14.f9646a
            if (r6 != 0) goto L_0x000b
        L_0x009a:
            long r1 = r14.f9647b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f9647b = r1
            return r4
        L_0x00a1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e.o():long");
    }

    public InputStream p() {
        return new a();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        t tVar = this.f9646a;
        if (tVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), tVar.f9681c - tVar.f9680b);
        byteBuffer.put(tVar.f9679a, tVar.f9680b, min);
        int i2 = tVar.f9680b + min;
        tVar.f9680b = i2;
        this.f9647b -= (long) min;
        if (i2 == tVar.f9681c) {
            this.f9646a = tVar.a();
            u.a(tVar);
        }
        return min;
    }

    public byte readByte() {
        long j2 = this.f9647b;
        if (j2 != 0) {
            t tVar = this.f9646a;
            int i2 = tVar.f9680b;
            int i3 = tVar.f9681c;
            int i4 = i2 + 1;
            byte b2 = tVar.f9679a[i2];
            this.f9647b = j2 - 1;
            if (i4 == i3) {
                this.f9646a = tVar.a();
                u.a(tVar);
            } else {
                tVar.f9680b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public int readInt() {
        long j2 = this.f9647b;
        if (j2 >= 4) {
            t tVar = this.f9646a;
            int i2 = tVar.f9680b;
            int i3 = tVar.f9681c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = tVar.f9679a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.f9647b = j2 - 4;
            if (i7 == i3) {
                this.f9646a = tVar.a();
                u.a(tVar);
            } else {
                tVar.f9680b = i7;
            }
            return b4;
        }
        StringBuilder a2 = e.a.a.a.a.a("size < 4: ");
        a2.append(this.f9647b);
        throw new IllegalStateException(a2.toString());
    }

    public short readShort() {
        long j2 = this.f9647b;
        if (j2 >= 2) {
            t tVar = this.f9646a;
            int i2 = tVar.f9680b;
            int i3 = tVar.f9681c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = tVar.f9679a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f9647b = j2 - 2;
            if (i5 == i3) {
                this.f9646a = tVar.a();
                u.a(tVar);
            } else {
                tVar.f9680b = i5;
            }
            return (short) b2;
        }
        StringBuilder a2 = e.a.a.a.a.a("size < 2: ");
        a2.append(this.f9647b);
        throw new IllegalStateException(a2.toString());
    }

    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            t tVar = this.f9646a;
            if (tVar != null) {
                int min = (int) Math.min(j2, (long) (tVar.f9681c - tVar.f9680b));
                long j3 = (long) min;
                this.f9647b -= j3;
                j2 -= j3;
                t tVar2 = this.f9646a;
                int i2 = tVar2.f9680b + min;
                tVar2.f9680b = i2;
                if (i2 == tVar2.f9681c) {
                    this.f9646a = tVar2.a();
                    u.a(tVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public y timeout() {
        return y.f9690d;
    }

    public String toString() {
        h hVar;
        long j2 = this.f9647b;
        if (j2 <= 2147483647L) {
            int i2 = (int) j2;
            if (i2 == 0) {
                hVar = h.f9650e;
            } else {
                hVar = new v(this, i2);
            }
            return hVar.toString();
        }
        StringBuilder a2 = e.a.a.a.a.a("size > Integer.MAX_VALUE: ");
        a2.append(this.f9647b);
        throw new IllegalArgumentException(a2.toString());
    }

    public h b() {
        return new h(f());
    }

    public e clone() {
        e eVar = new e();
        if (this.f9647b == 0) {
            return eVar;
        }
        t b2 = this.f9646a.b();
        eVar.f9646a = b2;
        b2.f9685g = b2;
        b2.f9684f = b2;
        t tVar = this.f9646a;
        while (true) {
            tVar = tVar.f9684f;
            if (tVar != this.f9646a) {
                eVar.f9646a.f9685g.a(tVar.b());
            } else {
                eVar.f9647b = this.f9647b;
                return eVar;
            }
        }
    }

    public e d(long j2) {
        if (j2 == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        t a2 = a(numberOfTrailingZeros);
        byte[] bArr = a2.f9679a;
        int i2 = a2.f9681c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f9645c[(int) (15 & j2)];
            j2 >>>= 4;
        }
        a2.f9681c += numberOfTrailingZeros;
        this.f9647b += (long) numberOfTrailingZeros;
        return this;
    }

    public String e() {
        try {
            return a(this.f9647b, z.f9694a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void g(long j2) throws EOFException {
        if (this.f9647b < j2) {
            throw new EOFException();
        }
    }

    public e writeByte(int i2) {
        t a2 = a(1);
        byte[] bArr = a2.f9679a;
        int i3 = a2.f9681c;
        a2.f9681c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f9647b++;
        return this;
    }

    public e writeInt(int i2) {
        t a2 = a(4);
        byte[] bArr = a2.f9679a;
        int i3 = a2.f9681c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i2 & 255);
        a2.f9681c = i7;
        this.f9647b += 4;
        return this;
    }

    public e writeShort(int i2) {
        t a2 = a(2);
        byte[] bArr = a2.f9679a;
        int i3 = a2.f9681c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 & 255);
        a2.f9681c = i5;
        this.f9647b += 2;
        return this;
    }

    public String b(long j2) throws EOFException {
        return a(j2, z.f9694a);
    }

    public h c(long j2) throws EOFException {
        return new h(f(j2));
    }

    public byte[] f(long j2) throws EOFException {
        z.a(this.f9647b, 0, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[((int) j2)];
            a(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    public e write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public e b(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException(e.a.a.a.a.a("beginIndex < 0: ", i2));
        } else if (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("endIndex < beginIndex: ");
            sb.append(i3);
            sb.append(" < ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    t a2 = a(1);
                    byte[] bArr = a2.f9679a;
                    int i4 = a2.f9681c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (true) {
                        i2 = i5;
                        if (i2 >= min) {
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        if (charAt2 >= 128) {
                            break;
                        }
                        i5 = i2 + 1;
                        bArr[i2 + i4] = (byte) charAt2;
                    }
                    int i6 = i4 + i2;
                    int i7 = a2.f9681c;
                    int i8 = i6 - i7;
                    a2.f9681c = i7 + i8;
                    this.f9647b += (long) i8;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | PassBiometricUtil.STANDARD_MIN_FACE_WIDTH);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? str.charAt(i9) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i2 = i9;
                        } else {
                            int i10 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i10 >> 18) | SapiAccountManager.VERSION_CODE);
                            writeByte(((i10 >> 12) & 63) | 128);
                            writeByte(((i10 >> 6) & 63) | 128);
                            writeByte((i10 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
            return this;
        } else {
            StringBuilder a3 = e.a.a.a.a.a("endIndex > string.length: ", i3, " > ");
            a3.append(str.length());
            throw new IllegalArgumentException(a3.toString());
        }
    }

    public e c(h hVar) {
        if (hVar != null) {
            hVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public e write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            z.a((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                t a2 = a(1);
                int min = Math.min(i4 - i2, 8192 - a2.f9681c);
                System.arraycopy(bArr, i2, a2.f9679a, a2.f9681c, min);
                i2 += min;
                a2.f9681c += min;
            }
            this.f9647b += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public e c(String str) {
        b(str, 0, str.length());
        return this;
    }

    public long read(e eVar, long j2) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.f9647b;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            eVar.a(this, j2);
            return j2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                t a2 = a(1);
                int min = Math.min(i2, 8192 - a2.f9681c);
                byteBuffer.get(a2.f9679a, a2.f9681c, min);
                i2 -= min;
                a2.f9681c += min;
            }
            this.f9647b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final byte a(long j2) {
        int i2;
        z.a(this.f9647b, j2, 1);
        long j3 = this.f9647b;
        if (j3 - j2 > j2) {
            t tVar = this.f9646a;
            while (true) {
                int i3 = tVar.f9681c;
                int i4 = tVar.f9680b;
                long j4 = (long) (i3 - i4);
                if (j2 < j4) {
                    return tVar.f9679a[i4 + ((int) j2)];
                }
                j2 -= j4;
                tVar = tVar.f9684f;
            }
        } else {
            long j5 = j2 - j3;
            t tVar2 = this.f9646a;
            do {
                tVar2 = tVar2.f9685g;
                int i5 = tVar2.f9681c;
                i2 = tVar2.f9680b;
                j5 += (long) (i5 - i2);
            } while (j5 < 0);
            return tVar2.f9679a[i2 + ((int) j5)];
        }
    }

    public int a(q qVar) {
        int a2 = a(qVar, false);
        if (a2 == -1) {
            return -1;
        }
        try {
            skip((long) qVar.f9670a[a2].d());
            return a2;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public int a(q qVar, boolean z) {
        int i2;
        int i3;
        int i4;
        t tVar;
        int i5;
        q qVar2 = qVar;
        t tVar2 = this.f9646a;
        int i6 = -2;
        if (tVar2 != null) {
            byte[] bArr = tVar2.f9679a;
            int i7 = tVar2.f9680b;
            int i8 = tVar2.f9681c;
            int[] iArr = qVar2.f9671b;
            t tVar3 = tVar2;
            int i9 = 0;
            int i10 = -1;
            loop0:
            while (true) {
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                int i13 = i11 + 1;
                int i14 = iArr[i11];
                if (i14 != -1) {
                    i10 = i14;
                }
                if (tVar3 == null) {
                    break;
                }
                if (i12 < 0) {
                    int i15 = (i12 * -1) + i13;
                    while (true) {
                        int i16 = i7 + 1;
                        int i17 = i13 + 1;
                        if ((bArr[i7] & 255) != iArr[i13]) {
                            return i10;
                        }
                        boolean z2 = i17 == i15;
                        if (i16 == i8) {
                            t tVar4 = tVar3.f9684f;
                            i5 = tVar4.f9680b;
                            byte[] bArr2 = tVar4.f9679a;
                            i4 = tVar4.f9681c;
                            if (tVar4 != tVar2) {
                                byte[] bArr3 = bArr2;
                                tVar = tVar4;
                                bArr = bArr3;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                tVar = null;
                            }
                        } else {
                            t tVar5 = tVar3;
                            i4 = i8;
                            i5 = i16;
                            tVar = tVar5;
                        }
                        if (z2) {
                            i2 = iArr[i17];
                            i3 = i5;
                            i8 = i4;
                            tVar3 = tVar;
                            break;
                        }
                        i7 = i5;
                        i8 = i4;
                        i13 = i17;
                        tVar3 = tVar;
                    }
                } else {
                    int i18 = i7 + 1;
                    byte b2 = bArr[i7] & 255;
                    int i19 = i13 + i12;
                    while (i13 != i19) {
                        if (b2 == iArr[i13]) {
                            i2 = iArr[i13 + i12];
                            if (i18 == i8) {
                                tVar3 = tVar3.f9684f;
                                i3 = tVar3.f9680b;
                                bArr = tVar3.f9679a;
                                i8 = tVar3.f9681c;
                                if (tVar3 == tVar2) {
                                    tVar3 = null;
                                }
                            } else {
                                i3 = i18;
                            }
                        } else {
                            i13++;
                        }
                    }
                    return i10;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i9 = -i2;
                i7 = i3;
                i6 = -2;
            }
            return z ? i6 : i10;
        } else if (z) {
            return -2;
        } else {
            return qVar2.indexOf(h.f9650e);
        }
    }

    public e b(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | PassBiometricUtil.STANDARD_MIN_FACE_WIDTH);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i2 <= 1114111) {
            writeByte((i2 >> 18) | SapiAccountManager.VERSION_CODE);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Unexpected code point: ");
            a2.append(Integer.toHexString(i2));
            throw new IllegalArgumentException(a2.toString());
        }
        return this;
    }

    public long b(h hVar) {
        return b(hVar, 0);
    }

    public long b(h hVar, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 >= 0) {
            t tVar = this.f9646a;
            if (tVar == null) {
                return -1;
            }
            long j4 = this.f9647b;
            if (j4 - j2 < j2) {
                while (j4 > j2) {
                    tVar = tVar.f9685g;
                    j4 -= (long) (tVar.f9681c - tVar.f9680b);
                }
            } else {
                while (true) {
                    long j5 = ((long) (tVar.f9681c - tVar.f9680b)) + j3;
                    if (j5 >= j2) {
                        break;
                    }
                    tVar = tVar.f9684f;
                    j3 = j5;
                }
                j4 = j3;
            }
            if (hVar.d() == 2) {
                byte a2 = hVar.a(0);
                byte a3 = hVar.a(1);
                while (j4 < this.f9647b) {
                    byte[] bArr = tVar.f9679a;
                    i2 = (int) ((((long) tVar.f9680b) + j2) - j4);
                    int i4 = tVar.f9681c;
                    while (i2 < i4) {
                        byte b2 = bArr[i2];
                        if (b2 == a2 || b2 == a3) {
                            i3 = tVar.f9680b;
                        } else {
                            i2++;
                        }
                    }
                    j4 += (long) (tVar.f9681c - tVar.f9680b);
                    tVar = tVar.f9684f;
                    j2 = j4;
                }
                return -1;
            }
            byte[] c2 = hVar.c();
            while (j4 < this.f9647b) {
                byte[] bArr2 = tVar.f9679a;
                int i5 = (int) ((((long) tVar.f9680b) + j2) - j4);
                int i6 = tVar.f9681c;
                while (i2 < i6) {
                    byte b3 = bArr2[i2];
                    int length = c2.length;
                    int i7 = 0;
                    while (i7 < length) {
                        if (b3 == c2[i7]) {
                            i3 = tVar.f9680b;
                        } else {
                            i7++;
                        }
                    }
                    i5 = i2 + 1;
                }
                j4 += (long) (tVar.f9681c - tVar.f9680b);
                tVar = tVar.f9684f;
                j2 = j4;
            }
            return -1;
            return ((long) (i2 - i3)) + j4;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public String a(Charset charset) {
        try {
            return a(this.f9647b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j2, Charset charset) throws EOFException {
        z.a(this.f9647b, 0, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j2 > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (j2 == 0) {
            return "";
        } else {
            t tVar = this.f9646a;
            if (((long) tVar.f9680b) + j2 > ((long) tVar.f9681c)) {
                return new String(f(j2), charset);
            }
            String str = new String(tVar.f9679a, tVar.f9680b, (int) j2, charset);
            int i2 = (int) (((long) tVar.f9680b) + j2);
            tVar.f9680b = i2;
            this.f9647b -= j2;
            if (i2 == tVar.f9681c) {
                this.f9646a = tVar.a();
                u.a(tVar);
            }
            return str;
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 != -1) {
                i2 += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        z.a((long) bArr.length, (long) i2, (long) i3);
        t tVar = this.f9646a;
        if (tVar == null) {
            return -1;
        }
        int min = Math.min(i3, tVar.f9681c - tVar.f9680b);
        System.arraycopy(tVar.f9679a, tVar.f9680b, bArr, i2, min);
        int i4 = tVar.f9680b + min;
        tVar.f9680b = i4;
        this.f9647b -= (long) min;
        if (i4 == tVar.f9681c) {
            this.f9646a = tVar.a();
            u.a(tVar);
        }
        return min;
    }

    public final void a() {
        try {
            skip(this.f9647b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public e a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalAccessError(e.a.a.a.a.a("beginIndex < 0: ", i2));
        } else if (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("endIndex < beginIndex: ");
            sb.append(i3);
            sb.append(" < ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > str.length()) {
            StringBuilder a2 = e.a.a.a.a.a("endIndex > string.length: ", i3, " > ");
            a2.append(str.length());
            throw new IllegalArgumentException(a2.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(z.f9694a)) {
            b(str, i2, i3);
            return this;
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public long a(x xVar) throws IOException {
        if (xVar != null) {
            long j2 = 0;
            while (true) {
                long read = xVar.read(this, 8192);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public t a(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        t tVar = this.f9646a;
        if (tVar == null) {
            t a2 = u.a();
            this.f9646a = a2;
            a2.f9685g = a2;
            a2.f9684f = a2;
            return a2;
        }
        t tVar2 = tVar.f9685g;
        if (tVar2.f9681c + i2 > 8192 || !tVar2.f9683e) {
            t a3 = u.a();
            tVar2.a(a3);
            tVar2 = a3;
        }
        return tVar2;
    }

    public void a(e eVar, long j2) {
        t tVar;
        int i2;
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (eVar != this) {
            z.a(eVar.f9647b, 0, j2);
            while (j2 > 0) {
                t tVar2 = eVar.f9646a;
                int i3 = 0;
                if (j2 < ((long) (tVar2.f9681c - tVar2.f9680b))) {
                    t tVar3 = this.f9646a;
                    t tVar4 = tVar3 != null ? tVar3.f9685g : null;
                    if (tVar4 != null && tVar4.f9683e) {
                        long j3 = ((long) tVar4.f9681c) + j2;
                        if (tVar4.f9682d) {
                            i2 = 0;
                        } else {
                            i2 = tVar4.f9680b;
                        }
                        if (j3 - ((long) i2) <= 8192) {
                            eVar.f9646a.a(tVar4, (int) j2);
                            eVar.f9647b -= j2;
                            this.f9647b += j2;
                            return;
                        }
                    }
                    t tVar5 = eVar.f9646a;
                    int i4 = (int) j2;
                    if (tVar5 == null) {
                        throw null;
                    } else if (i4 <= 0 || i4 > tVar5.f9681c - tVar5.f9680b) {
                        throw new IllegalArgumentException();
                    } else {
                        if (i4 >= 1024) {
                            tVar = tVar5.b();
                        } else {
                            tVar = u.a();
                            System.arraycopy(tVar5.f9679a, tVar5.f9680b, tVar.f9679a, 0, i4);
                        }
                        tVar.f9681c = tVar.f9680b + i4;
                        tVar5.f9680b += i4;
                        tVar5.f9685g.a(tVar);
                        eVar.f9646a = tVar;
                    }
                }
                t tVar6 = eVar.f9646a;
                long j4 = (long) (tVar6.f9681c - tVar6.f9680b);
                eVar.f9646a = tVar6.a();
                t tVar7 = this.f9646a;
                if (tVar7 == null) {
                    this.f9646a = tVar6;
                    tVar6.f9685g = tVar6;
                    tVar6.f9684f = tVar6;
                } else {
                    tVar7.f9685g.a(tVar6);
                    t tVar8 = tVar6.f9685g;
                    if (tVar8 == tVar6) {
                        throw new IllegalStateException();
                    } else if (tVar8.f9683e) {
                        int i5 = tVar6.f9681c - tVar6.f9680b;
                        int i6 = 8192 - tVar8.f9681c;
                        if (!tVar8.f9682d) {
                            i3 = tVar8.f9680b;
                        }
                        if (i5 <= i6 + i3) {
                            tVar6.a(tVar6.f9685g, i5);
                            tVar6.a();
                            u.a(tVar6);
                        }
                    }
                }
                eVar.f9647b -= j4;
                this.f9647b += j4;
                j2 -= j4;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long a(byte b2) {
        return a(b2, 0, (long) RecyclerView.FOREVER_NS);
    }

    public long a(byte b2, long j2, long j3) {
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f9647b), Long.valueOf(j2), Long.valueOf(j3)}));
        }
        long j5 = this.f9647b;
        if (j3 <= j5) {
            j5 = j3;
        }
        if (j2 == j5) {
            return -1;
        }
        t tVar = this.f9646a;
        if (tVar == null) {
            return -1;
        }
        long j6 = this.f9647b;
        if (j6 - j2 < j2) {
            while (j6 > j2) {
                tVar = tVar.f9685g;
                j6 -= (long) (tVar.f9681c - tVar.f9680b);
            }
        } else {
            while (true) {
                long j7 = ((long) (tVar.f9681c - tVar.f9680b)) + j4;
                if (j7 >= j2) {
                    break;
                }
                tVar = tVar.f9684f;
                j4 = j7;
            }
            j6 = j4;
        }
        long j8 = j2;
        while (j6 < j5) {
            byte[] bArr = tVar.f9679a;
            int min = (int) Math.min((long) tVar.f9681c, (((long) tVar.f9680b) + j5) - j6);
            for (int i2 = (int) ((((long) tVar.f9680b) + j8) - j6); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - tVar.f9680b)) + j6;
                }
            }
            byte b3 = b2;
            j6 += (long) (tVar.f9681c - tVar.f9680b);
            tVar = tVar.f9684f;
            j8 = j6;
        }
        return -1;
    }

    public long a(h hVar) throws IOException {
        return a(hVar, 0);
    }

    public long a(h hVar, long j2) throws IOException {
        int i2;
        boolean z;
        t tVar;
        h hVar2 = hVar;
        if (hVar.d() != 0) {
            long j3 = 0;
            if (j2 >= 0) {
                t tVar2 = this.f9646a;
                long j4 = -1;
                if (tVar2 == null) {
                    return -1;
                }
                long j5 = this.f9647b;
                if (j5 - j2 < j2) {
                    while (j5 > j2) {
                        tVar2 = tVar2.f9685g;
                        j5 -= (long) (tVar2.f9681c - tVar2.f9680b);
                    }
                } else {
                    while (true) {
                        long j6 = ((long) (tVar2.f9681c - tVar2.f9680b)) + j3;
                        if (j6 >= j2) {
                            break;
                        }
                        tVar2 = tVar2.f9684f;
                        j3 = j6;
                    }
                    j5 = j3;
                }
                byte a2 = hVar2.a(0);
                int d2 = hVar.d();
                long j7 = (this.f9647b - ((long) d2)) + 1;
                long j8 = j5;
                long j9 = j2;
                while (j8 < j7) {
                    byte[] bArr = tVar2.f9679a;
                    byte b2 = a2;
                    int min = (int) Math.min((long) tVar2.f9681c, (((long) tVar2.f9680b) + j7) - j8);
                    int i3 = (int) ((((long) tVar2.f9680b) + j9) - j8);
                    while (i3 < min) {
                        byte b3 = b2;
                        if (bArr[i3] == b3) {
                            int i4 = i3 + 1;
                            int i5 = tVar2.f9681c;
                            byte[] bArr2 = tVar2.f9679a;
                            t tVar3 = tVar2;
                            int i6 = 1;
                            while (true) {
                                if (i6 >= d2) {
                                    i2 = min;
                                    z = true;
                                    break;
                                }
                                if (i4 == i5) {
                                    t tVar4 = tVar3.f9684f;
                                    byte[] bArr3 = tVar4.f9679a;
                                    int i7 = tVar4.f9680b;
                                    tVar = tVar4;
                                    bArr2 = bArr3;
                                    i4 = i7;
                                    i5 = tVar4.f9681c;
                                } else {
                                    tVar = tVar3;
                                }
                                i2 = min;
                                if (bArr2[i4] != hVar2.a(i6)) {
                                    z = false;
                                    break;
                                }
                                i4++;
                                i6++;
                                tVar3 = tVar;
                                min = i2;
                            }
                            if (z) {
                                return ((long) (i3 - tVar2.f9680b)) + j8;
                            }
                        } else {
                            i2 = min;
                        }
                        i3++;
                        min = i2;
                        b2 = b3;
                    }
                    byte b4 = b2;
                    j8 += (long) (tVar2.f9681c - tVar2.f9680b);
                    tVar2 = tVar2.f9684f;
                    a2 = b4;
                    j9 = j8;
                    j4 = -1;
                }
                return j4;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public boolean a(long j2, h hVar) {
        int d2 = hVar.d();
        if (j2 < 0 || d2 < 0 || this.f9647b - j2 < ((long) d2) || hVar.d() - 0 < d2) {
            return false;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            if (a(((long) i2) + j2) != hVar.a(0 + i2)) {
                return false;
            }
        }
        return true;
    }
}
