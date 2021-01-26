package e.i.a.h.l.c;

import android.util.SparseArray;
import e.i.a.h.l.c.c.a;

/* compiled from: ListenerModelHandler */
public class c<T extends a> {

    /* renamed from: a reason: collision with root package name */
    public volatile T f8898a;

    /* renamed from: b reason: collision with root package name */
    public final SparseArray<T> f8899b = new SparseArray<>();

    /* renamed from: c reason: collision with root package name */
    public Boolean f8900c;

    /* renamed from: d reason: collision with root package name */
    public final b<T> f8901d;

    /* compiled from: ListenerModelHandler */
    public interface a {
        int a();

        void a(e.i.a.h.d.c cVar);
    }

    /* compiled from: ListenerModelHandler */
    public interface b<T extends a> {
        T a(int i2);
    }

    public c(b<T> bVar) {
        this.f8901d = bVar;
    }

    public T a(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
        T a2 = this.f8901d.a(cVar.f8649b);
        synchronized (this) {
            if (this.f8898a == null) {
                this.f8898a = a2;
            } else {
                this.f8899b.put(cVar.f8649b, a2);
            }
            if (cVar2 != null) {
                a2.a(cVar2);
            }
        }
        return a2;
    }

    public T b(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
        T t;
        int i2 = cVar.f8649b;
        synchronized (this) {
            t = (this.f8898a == null || this.f8898a.a() != i2) ? null : this.f8898a;
        }
        if (t == null) {
            t = (a) this.f8899b.get(i2);
        }
        if (t == null) {
            Boolean bool = this.f8900c;
            if (bool != null && bool.booleanValue()) {
                return a(cVar, cVar2);
            }
        }
        return t;
    }

    public T c(e.i.a.c cVar, e.i.a.h.d.c cVar2) {
        T t;
        int i2 = cVar.f8649b;
        synchronized (this) {
            if (this.f8898a == null || this.f8898a.a() != i2) {
                t = (a) this.f8899b.get(i2);
                this.f8899b.remove(i2);
            } else {
                t = this.f8898a;
                this.f8898a = null;
            }
        }
        if (t == null) {
            t = this.f8901d.a(i2);
            if (cVar2 != null) {
                t.a(cVar2);
            }
        }
        return t;
    }
}
