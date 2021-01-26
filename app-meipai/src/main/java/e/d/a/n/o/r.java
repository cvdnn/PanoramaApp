package e.d.a.n.o;

import e.c.f.n.n;
import e.d.a.n.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory */
public class r {

    /* renamed from: e reason: collision with root package name */
    public static final c f7594e = new c();

    /* renamed from: f reason: collision with root package name */
    public static final n<Object, Object> f7595f = new a();

    /* renamed from: a reason: collision with root package name */
    public final List<b<?, ?>> f7596a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public final c f7597b;

    /* renamed from: c reason: collision with root package name */
    public final Set<b<?, ?>> f7598c = new HashSet();

    /* renamed from: d reason: collision with root package name */
    public final d.h.j.c<List<Throwable>> f7599d;

    /* compiled from: MultiModelLoaderFactory */
    public static class a implements n<Object, Object> {
        public e.d.a.n.o.n.a<Object> a(Object obj, int i2, int i3, h hVar) {
            return null;
        }

        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    public static class b<Model, Data> {

        /* renamed from: a reason: collision with root package name */
        public final Class<Model> f7600a;

        /* renamed from: b reason: collision with root package name */
        public final Class<Data> f7601b;

        /* renamed from: c reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f7602c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f7600a = cls;
            this.f7601b = cls2;
            this.f7602c = oVar;
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    public static class c {
    }

    public r(d.h.j.c<List<Throwable>> cVar) {
        c cVar2 = f7594e;
        this.f7599d = cVar;
        this.f7597b = cVar2;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        b bVar = new b(cls, cls2, oVar);
        List<b<?, ?>> list = this.f7596a;
        list.add(list.size(), bVar);
    }

    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f7596a) {
            if (!arrayList.contains(bVar.f7601b) && bVar.f7600a.isAssignableFrom(cls)) {
                arrayList.add(bVar.f7601b);
            }
        }
        return arrayList;
    }

    public synchronized <Model> List<n<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f7596a) {
                if (!this.f7598c.contains(bVar)) {
                    if (bVar.f7600a.isAssignableFrom(cls)) {
                        this.f7598c.add(bVar);
                        n a2 = bVar.f7602c.a(this);
                        n.a(a2, "Argument must not be null");
                        arrayList.add(a2);
                        this.f7598c.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.f7598c.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized <Model, Data> n<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.f7596a) {
                if (this.f7598c.contains(bVar)) {
                    z = true;
                } else {
                    if (bVar.f7600a.isAssignableFrom(cls) && bVar.f7601b.isAssignableFrom(cls2)) {
                        this.f7598c.add(bVar);
                        arrayList.add(a(bVar));
                        this.f7598c.remove(bVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f7597b;
                d.h.j.c<List<Throwable>> cVar2 = this.f7599d;
                if (cVar != null) {
                    return new q(arrayList, cVar2);
                }
                throw null;
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f7595f;
            } else {
                throw new e.d.a.h.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.f7598c.clear();
            throw th;
        }
    }

    public final <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        n<Model, Data> a2 = bVar.f7602c.a(this);
        n.a(a2, "Argument must not be null");
        return a2;
    }
}
