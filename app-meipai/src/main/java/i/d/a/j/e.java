package i.d.a.j;

import e.a.a.a.a;

/* compiled from: ZipLong */
public final class e implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public final long f9910a;

    static {
        new e(33639248);
        new e(67324752);
        new e(134695760);
        new e(4294967295L);
    }

    public e(long j2) {
        this.f9910a = j2;
    }

    public static long a(byte[] bArr, int i2) {
        return (((long) (bArr[i2 + 3] << 24)) & 4278190080L) + ((long) ((bArr[i2 + 2] << 16) & 16711680)) + ((long) ((bArr[i2 + 1] << 8) & 65280)) + ((long) (bArr[i2] & 255));
    }

    public static byte[] a(long j2) {
        return new byte[]{(byte) ((int) (255 & j2)), (byte) ((int) ((65280 & j2) >> 8)), (byte) ((int) ((16711680 & j2) >> 16)), (byte) ((int) ((j2 & 4278190080L) >> 24))};
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof e) || this.f9910a != ((e) obj).f9910a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) this.f9910a;
    }

    public String toString() {
        StringBuilder a2 = a.a("ZipLong value: ");
        a2.append(this.f9910a);
        return a2.toString();
    }
}
