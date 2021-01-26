package e.d.a.n.o;

import d.h.j.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry */
public class p {

    /* renamed from: a reason: collision with root package name */
    public final r f7581a;

    /* renamed from: b reason: collision with root package name */
    public final a f7582b = new a();

    /* compiled from: ModelLoaderRegistry */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public final Map<Class<?>, C0091a<?>> f7583a = new HashMap();

        /* renamed from: e.d.a.n.o.p$a$a reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        public static class C0091a<Model> {

            /* renamed from: a reason: collision with root package name */
            public final List<n<Model, ?>> f7584a;

            public C0091a(List<n<Model, ?>> list) {
                this.f7584a = list;
            }
        }
    }

    public p(c<List<Throwable>> cVar) {
        r rVar = new r(cVar);
        this.f7581a = rVar;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f7581a.a(cls, cls2, oVar);
        this.f7582b.f7583a.clear();
    }

    public final synchronized <A> List<n<A, ?>> b(Class<A> cls) {
        List<n<Model, ?>> list;
        C0091a aVar = (C0091a) this.f7582b.f7583a.get(cls);
        if (aVar == null) {
            list = null;
        } else {
            list = aVar.f7584a;
        }
        if (list == null) {
            list = Collections.unmodifiableList(this.f7581a.a(cls));
            if (((C0091a) this.f7582b.f7583a.put(cls, new C0091a(list))) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Already cached loaders for model: ");
                sb.append(cls);
                throw new IllegalStateException(sb.toString());
            }
        }
        return list;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f7581a.b(cls);
    }
}
