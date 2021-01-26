package d.e;

import java.util.Map;

/* compiled from: ArraySet */
public class b extends g<E, E> {

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ c f4555d;

    public b(c cVar) {
        this.f4555d = cVar;
    }

    public Object a(int i2, int i3) {
        return this.f4555d.f4563b[i2];
    }

    public int b(Object obj) {
        return this.f4555d.indexOf(obj);
    }

    public int c() {
        return this.f4555d.f4564c;
    }

    public int a(Object obj) {
        return this.f4555d.indexOf(obj);
    }

    public Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    public void a(E e2, E e3) {
        this.f4555d.add(e2);
    }

    public E a(int i2, E e2) {
        throw new UnsupportedOperationException("not a map");
    }

    public void a(int i2) {
        this.f4555d.b(i2);
    }

    public void a() {
        this.f4555d.clear();
    }
}
