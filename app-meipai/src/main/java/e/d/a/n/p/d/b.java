package e.d.a.n.p.d;

import e.c.f.n.n;
import e.d.a.n.n.w;

/* compiled from: BytesResource */
public class b implements w<byte[]> {

    /* renamed from: a reason: collision with root package name */
    public final byte[] f7743a;

    public b(byte[] bArr) {
        n.a(bArr, "Argument must not be null");
        this.f7743a = bArr;
    }

    public void b() {
    }

    public Class<byte[]> c() {
        return byte[].class;
    }

    public Object get() {
        return this.f7743a;
    }

    public int getSize() {
        return this.f7743a.length;
    }
}
