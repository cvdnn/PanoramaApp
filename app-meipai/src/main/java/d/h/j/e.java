package d.h.j;

/* compiled from: Pools */
public class e<T> extends d<T> {

    /* renamed from: c reason: collision with root package name */
    public final Object f4907c = new Object();

    public e(int i2) {
        super(i2);
    }

    public T a() {
        T a2;
        synchronized (this.f4907c) {
            a2 = super.a();
        }
        return a2;
    }

    public boolean a(T t) {
        boolean a2;
        synchronized (this.f4907c) {
            a2 = super.a(t);
        }
        return a2;
    }
}
