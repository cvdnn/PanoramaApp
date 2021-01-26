package e.d.a.n.n.c0;

import e.d.a.n.n.c0.l;
import e.d.a.t.j;
import java.util.Queue;

/* compiled from: BaseKeyPool */
public abstract class c<T extends l> {

    /* renamed from: a reason: collision with root package name */
    public final Queue<T> f7296a = j.a(20);

    public abstract T a();

    public void a(T t) {
        if (this.f7296a.size() < 20) {
            this.f7296a.offer(t);
        }
    }

    public T b() {
        T t = (l) this.f7296a.poll();
        return t == null ? a() : t;
    }
}
