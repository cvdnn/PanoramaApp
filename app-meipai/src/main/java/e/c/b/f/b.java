package e.c.b.f;

import java.util.Iterator;
import java.util.LinkedList;

public final class b<E> extends LinkedList<E> {

    /* renamed from: a reason: collision with root package name */
    public final int f5921a;

    public b(int i2) {
        this.f5921a = i2;
    }

    public final void add(int i2, E e2) {
        if (size() == this.f5921a) {
            removeFirst();
        }
        super.add(i2, e2);
    }

    public final boolean add(E e2) {
        if (size() == this.f5921a) {
            removeFirst();
        }
        return super.add(e2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
