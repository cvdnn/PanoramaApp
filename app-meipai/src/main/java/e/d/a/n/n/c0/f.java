package e.d.a.n.n.c0;

/* compiled from: ByteArrayAdapter */
public final class f implements a<byte[]> {
    public int a() {
        return 1;
    }

    public int a(Object obj) {
        return ((byte[]) obj).length;
    }

    public String b() {
        return "ByteArrayPool";
    }

    public Object newArray(int i2) {
        return new byte[i2];
    }
}
