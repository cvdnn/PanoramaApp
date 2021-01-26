package h;

import e.a.a.a.a;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString */
public class h implements Serializable, Comparable<h> {

    /* renamed from: d reason: collision with root package name */
    public static final char[] f9649d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e reason: collision with root package name */
    public static final h f9650e = a(new byte[0]);

    /* renamed from: a reason: collision with root package name */
    public final byte[] f9651a;

    /* renamed from: b reason: collision with root package name */
    public transient int f9652b;

    /* renamed from: c reason: collision with root package name */
    public transient String f9653c;

    public h(byte[] bArr) {
        this.f9651a = bArr;
    }

    public static h a(byte... bArr) {
        if (bArr != null) {
            return new h((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static h c(String str) {
        if (str != null) {
            h hVar = new h(str.getBytes(z.f9694a));
            hVar.f9653c = str;
            return hVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String b() {
        byte[] bArr = this.f9651a;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f9649d;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 < r1) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r7 < r8) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.lang.Object r10) {
        /*
            r9 = this;
            h.h r10 = (h.h) r10
            int r0 = r9.d()
            int r1 = r10.d()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x0010:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.a(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.a(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0025
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0025:
            if (r7 >= r8) goto L_0x0029
        L_0x0027:
            r3 = r5
            goto L_0x0031
        L_0x0029:
            r3 = r6
            goto L_0x0031
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            if (r0 >= r1) goto L_0x0029
            goto L_0x0027
        L_0x0031:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h.h.compareTo(java.lang.Object):int");
    }

    public int d() {
        return this.f9651a.length;
    }

    public h e() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f9651a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new h(bArr2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r6.a(0, r3, 0, r3.length) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof h.h
            r2 = 0
            if (r1 == 0) goto L_0x001c
            h.h r6 = (h.h) r6
            int r1 = r6.d()
            byte[] r3 = r5.f9651a
            int r4 = r3.length
            if (r1 != r4) goto L_0x001c
            int r1 = r3.length
            boolean r6 = r6.a(r2, r3, r2, r1)
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.h.equals(java.lang.Object):boolean");
    }

    public byte[] f() {
        return (byte[]) this.f9651a.clone();
    }

    public String g() {
        String str = this.f9653c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f9651a, z.f9694a);
        this.f9653c = str2;
        return str2;
    }

    public int hashCode() {
        int i2 = this.f9652b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f9651a);
        this.f9652b = hashCode;
        return hashCode;
    }

    public String toString() {
        String str;
        String str2;
        if (this.f9651a.length == 0) {
            return "[size=0]";
        }
        String g2 = g();
        int length = g2.length();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = g2.length();
                break;
            } else if (i3 == 64) {
                break;
            } else {
                int codePointAt = g2.codePointAt(i2);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i3++;
                    i2 += Character.charCount(codePointAt);
                }
            }
        }
        i2 = -1;
        String str3 = "…]";
        String str4 = "[size=";
        String str5 = "]";
        if (i2 == -1) {
            if (this.f9651a.length <= 64) {
                StringBuilder a2 = a.a("[hex=");
                a2.append(b());
                a2.append(str5);
                str2 = a2.toString();
            } else {
                StringBuilder a3 = a.a(str4);
                a3.append(this.f9651a.length);
                a3.append(" hex=");
                a3.append(a(0, 64).b());
                a3.append(str3);
                str2 = a3.toString();
            }
            return str2;
        }
        String replace = g2.substring(0, i2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i2 < g2.length()) {
            StringBuilder a4 = a.a(str4);
            a4.append(this.f9651a.length);
            a4.append(" text=");
            a4.append(replace);
            a4.append(str3);
            str = a4.toString();
        } else {
            str = a.a("[text=", replace, str5);
        }
        return str;
    }

    public String a() {
        byte[] bArr = this.f9651a;
        byte[] bArr2 = d.f9644a;
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int i4 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr3[i4] = bArr2[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            int i8 = i3 + 2;
            bArr3[i5] = bArr2[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
            i2 = i7 + 1;
            bArr3[i7] = bArr2[bArr[i8] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(bArr[length] & 3) << 4];
            int i11 = i10 + 1;
            bArr3[i10] = 61;
            bArr3[i11] = 61;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
            int i13 = i12 + 1;
            int i14 = (bArr[length] & 3) << 4;
            int i15 = length + 1;
            bArr3[i12] = bArr2[((bArr[i15] & 255) >> 4) | i14];
            int i16 = i13 + 1;
            bArr3[i13] = bArr2[(bArr[i15] & 15) << 2];
            bArr3[i16] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] c() {
        return this.f9651a;
    }

    public static h b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (a(str.charAt(i3 + 1)) + (a(str.charAt(i3)) << 4));
            }
            return a(bArr);
        } else {
            throw new IllegalArgumentException(a.a("Unexpected hex string: ", str));
        }
    }

    public final h a(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f9651a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected hex digit: ");
                sb.append(c2);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return (c2 - c3) + 10;
    }

    public h a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.f9651a;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.f9651a, i2, bArr2, 0, i4);
                    return new h(bArr2);
                }
            } else {
                throw new IllegalArgumentException(a.a(a.a("endIndex > length("), this.f9651a.length, ")"));
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte a(int i2) {
        return this.f9651a[i2];
    }

    public void a(e eVar) {
        byte[] bArr = this.f9651a;
        eVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i2, h hVar, int i3, int i4) {
        return hVar.a(i3, this.f9651a, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f9651a;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && z.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }
}
