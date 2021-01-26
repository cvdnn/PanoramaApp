package e.d.a.n.n.c0;

/* compiled from: IntegerArrayAdapter */
public final class h implements a<int[]> {
    public int a() {
        return 4;
    }

    public int a(Object obj) {
        return ((int[]) obj).length;
    }

    public String b() {
        return "IntegerArrayPool";
    }

    public Object newArray(int i2) {
        return new int[i2];
    }
}
