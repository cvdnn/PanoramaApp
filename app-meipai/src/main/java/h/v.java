package h;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
public final class v extends h {

    /* renamed from: f reason: collision with root package name */
    public final transient byte[][] f9688f;

    /* renamed from: g reason: collision with root package name */
    public final transient int[] f9689g;

    public v(e eVar, int i2) {
        super(null);
        z.a(eVar.f9647b, 0, (long) i2);
        t tVar = eVar.f9646a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = tVar.f9681c;
            int i7 = tVar.f9680b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                tVar = tVar.f9684f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f9688f = new byte[i5][];
        this.f9689g = new int[(i5 * 2)];
        t tVar2 = eVar.f9646a;
        int i8 = 0;
        while (i3 < i2) {
            this.f9688f[i8] = tVar2.f9679a;
            int i9 = (tVar2.f9681c - tVar2.f9680b) + i3;
            i3 = i9 > i2 ? i2 : i9;
            int[] iArr = this.f9689g;
            iArr[i8] = i3;
            iArr[this.f9688f.length + i8] = tVar2.f9680b;
            tVar2.f9682d = true;
            i8++;
            tVar2 = tVar2.f9684f;
        }
    }

    public String a() {
        return h().a();
    }

    public String b() {
        return h().b();
    }

    public byte[] c() {
        return f();
    }

    public int d() {
        return this.f9689g[this.f9688f.length - 1];
    }

    public h e() {
        return h().e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (a(0, r5, 0, d()) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof h.h
            r2 = 0
            if (r1 == 0) goto L_0x0020
            h.h r5 = (h.h) r5
            int r1 = r5.d()
            int r3 = r4.d()
            if (r1 != r3) goto L_0x0020
            int r1 = r4.d()
            boolean r5 = r4.a(r2, r5, r2, r1)
            if (r5 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r2
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.v.equals(java.lang.Object):boolean");
    }

    public byte[] f() {
        int[] iArr = this.f9689g;
        byte[][] bArr = this.f9688f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f9689g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f9688f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    public String g() {
        return h().g();
    }

    public final h h() {
        return new h(f());
    }

    public int hashCode() {
        int i2 = this.f9652b;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f9688f.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f9688f[i3];
            int[] iArr = this.f9689g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.f9652b = i4;
        return i4;
    }

    public String toString() {
        return h().toString();
    }

    public h a(int i2, int i3) {
        return h().a(i2, i3);
    }

    public final int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f9689g, 0, this.f9688f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public byte a(int i2) {
        int i3;
        z.a((long) this.f9689g[this.f9688f.length - 1], (long) i2, 1);
        int b2 = b(i2);
        if (b2 == 0) {
            i3 = 0;
        } else {
            i3 = this.f9689g[b2 - 1];
        }
        int[] iArr = this.f9689g;
        byte[][] bArr = this.f9688f;
        return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
    }

    public void a(e eVar) {
        int length = this.f9688f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f9689g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            t tVar = new t(this.f9688f[i2], i4, (i4 + i5) - i3, true, false);
            t tVar2 = eVar.f9646a;
            if (tVar2 == null) {
                tVar.f9685g = tVar;
                tVar.f9684f = tVar;
                eVar.f9646a = tVar;
            } else {
                tVar2.f9685g.a(tVar);
            }
            i2++;
            i3 = i5;
        }
        eVar.f9647b += (long) i3;
    }

    public boolean a(int i2, h hVar, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > d() - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            if (b2 == 0) {
                i5 = 0;
            } else {
                i5 = this.f9689g[b2 - 1];
            }
            int min = Math.min(i4, ((this.f9689g[b2] - i5) + i5) - i2);
            int[] iArr = this.f9689g;
            byte[][] bArr = this.f9688f;
            if (!hVar.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > d() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b2 = b(i2);
        while (i4 > 0) {
            if (b2 == 0) {
                i5 = 0;
            } else {
                i5 = this.f9689g[b2 - 1];
            }
            int min = Math.min(i4, ((this.f9689g[b2] - i5) + i5) - i2);
            int[] iArr = this.f9689g;
            byte[][] bArr2 = this.f9688f;
            if (!z.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b2++;
        }
        return true;
    }
}
