package d.f.a;

/* compiled from: Pools */
public class f<T> {

    /* renamed from: a reason: collision with root package name */
    public final Object[] f4636a;

    /* renamed from: b reason: collision with root package name */
    public int f4637b;

    public f(int i2) {
        if (i2 > 0) {
            this.f4636a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i2 = this.f4637b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f4636a;
        T t = tArr[i3];
        tArr[i3] = null;
        this.f4637b = i2 - 1;
        return t;
    }

    public boolean a(T t) {
        int i2 = this.f4637b;
        Object[] objArr = this.f4636a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f4637b = i2 + 1;
        return true;
    }
}
