package i.d.a.j;

import e.a.a.a.a;

/* compiled from: ZipShort */
public final class f implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public final int f9911a;

    public f(int i2) {
        this.f9911a = i2;
    }

    public static byte[] a(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public byte[] a() {
        int i2 = this.f9911a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f) || this.f9911a != ((f) obj).f9911a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9911a;
    }

    public String toString() {
        StringBuilder a2 = a.a("ZipShort value: ");
        a2.append(this.f9911a);
        return a2.toString();
    }

    public static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public f(byte[] bArr, int i2) {
        this.f9911a = a(bArr, i2);
    }
}
