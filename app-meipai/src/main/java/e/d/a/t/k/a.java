package e.d.a.t.k;

import android.util.Log;
import java.util.List;

/* compiled from: FactoryPools */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final e<Object> f7924a = new C0101a();

    /* renamed from: e.d.a.t.k.a$a reason: collision with other inner class name */
    /* compiled from: FactoryPools */
    public class C0101a implements e<Object> {
        public void a(Object obj) {
        }
    }

    /* compiled from: FactoryPools */
    public interface b<T> {
        T create();
    }

    /* compiled from: FactoryPools */
    public static final class c<T> implements d.h.j.c<T> {

        /* renamed from: a reason: collision with root package name */
        public final b<T> f7925a;

        /* renamed from: b reason: collision with root package name */
        public final e<T> f7926b;

        /* renamed from: c reason: collision with root package name */
        public final d.h.j.c<T> f7927c;

        public c(d.h.j.c<T> cVar, b<T> bVar, e<T> eVar) {
            this.f7927c = cVar;
            this.f7925a = bVar;
            this.f7926b = eVar;
        }

        public T a() {
            T a2 = this.f7927c.a();
            if (a2 == null) {
                a2 = this.f7925a.create();
                String str = "FactoryPools";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder a3 = e.a.a.a.a.a("Created new ");
                    a3.append(a2.getClass());
                    Log.v(str, a3.toString());
                }
            }
            if (a2 instanceof d) {
                ((e.d.a.t.k.d.b) ((d) a2).a()).f7928a = false;
            }
            return a2;
        }

        public boolean a(T t) {
            if (t instanceof d) {
                ((e.d.a.t.k.d.b) ((d) t).a()).f7928a = true;
            }
            this.f7926b.a(t);
            return this.f7927c.a(t);
        }
    }

    /* compiled from: FactoryPools */
    public interface d {
        d a();
    }

    /* compiled from: FactoryPools */
    public interface e<T> {
        void a(T t);
    }

    public static <T extends d> d.h.j.c<T> a(int i2, b<T> bVar) {
        return new c(new d.h.j.e(i2), bVar, f7924a);
    }

    public static <T> d.h.j.c<List<T>> a() {
        return new c(new d.h.j.e(20), new b(), new c());
    }
}
