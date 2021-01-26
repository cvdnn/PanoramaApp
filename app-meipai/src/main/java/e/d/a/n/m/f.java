package e.d.a.n.m;

import e.c.f.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry */
public class f {

    /* renamed from: b reason: collision with root package name */
    public static final e.d.a.n.m.e.a<?> f7242b = new a();

    /* renamed from: a reason: collision with root package name */
    public final Map<Class<?>, e.d.a.n.m.e.a<?>> f7243a = new HashMap();

    /* compiled from: DataRewinderRegistry */
    public class a implements e.d.a.n.m.e.a<Object> {
        public e<Object> a(Object obj) {
            return new b(obj);
        }

        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: DataRewinderRegistry */
    public static final class b implements e<Object> {

        /* renamed from: a reason: collision with root package name */
        public final Object f7244a;

        public b(Object obj) {
            this.f7244a = obj;
        }

        public Object a() {
            return this.f7244a;
        }

        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t) {
        e.d.a.n.m.e.a aVar;
        n.a(t, "Argument must not be null");
        aVar = (e.d.a.n.m.e.a) this.f7243a.get(t.getClass());
        if (aVar == null) {
            Iterator it = this.f7243a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.d.a.n.m.e.a aVar2 = (e.d.a.n.m.e.a) it.next();
                if (aVar2.a().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f7242b;
        }
        return aVar.a(t);
    }

    public synchronized void a(e.d.a.n.m.e.a<?> aVar) {
        this.f7243a.put(aVar.a(), aVar);
    }
}
