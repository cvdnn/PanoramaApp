package d.h.j;

/* compiled from: Pools */
public class d<T> implements c<T> {

    /* renamed from: a reason: collision with root package name */
    public final Object[] f4905a;

    /* renamed from: b reason: collision with root package name */
    public int f4906b;

    public d(int i2) {
        if (i2 > 0) {
            this.f4905a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i2 = this.f4906b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f4905a;
        T t = tArr[i3];
        tArr[i3] = null;
        this.f4906b = i2 - 1;
        return t;
    }

    public boolean a(T t) {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f4906b) {
                z = false;
                break;
            } else if (this.f4905a[i2] == t) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            int i3 = this.f4906b;
            Object[] objArr = this.f4905a;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = t;
            this.f4906b = i3 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
