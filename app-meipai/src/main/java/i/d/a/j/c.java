package i.d.a.j;

/* compiled from: UnrecognizedExtraField */
public class c implements d {

    /* renamed from: a reason: collision with root package name */
    public f f9908a;

    /* renamed from: b reason: collision with root package name */
    public byte[] f9909b;

    public f a() {
        return this.f9908a;
    }

    public f b() {
        return new f(this.f9909b.length);
    }

    public byte[] c() {
        byte[] bArr = this.f9909b;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public void a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr2, 0, bArr3, 0, i3);
        this.f9909b = bArr3;
    }
}
