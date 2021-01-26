package e.d.a.q;

import e.d.a.n.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry */
public class e {

    /* renamed from: a reason: collision with root package name */
    public final List<String> f7847a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f7848b = new HashMap();

    /* compiled from: ResourceDecoderRegistry */
    public static class a<T, R> {

        /* renamed from: a reason: collision with root package name */
        public final Class<T> f7849a;

        /* renamed from: b reason: collision with root package name */
        public final Class<R> f7850b;

        /* renamed from: c reason: collision with root package name */
        public final j<T, R> f7851c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.f7849a = cls;
            this.f7850b = cls2;
            this.f7851c = jVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f7849a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f7850b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList arrayList = new ArrayList(this.f7847a);
        this.f7847a.clear();
        for (String add : list) {
            this.f7847a.add(add);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!list.contains(str)) {
                this.f7847a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f7847a) {
            List<a> list = (List) this.f7848b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f7850b)) {
                        arrayList.add(aVar.f7850b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<j<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f7847a) {
            List<a> list = (List) this.f7848b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f7851c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, jVar));
    }

    public final synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f7847a.contains(str)) {
            this.f7847a.add(str);
        }
        list = (List) this.f7848b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f7848b.put(str, list);
        }
        return list;
    }
}
