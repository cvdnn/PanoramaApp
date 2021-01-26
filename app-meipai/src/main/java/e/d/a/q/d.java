package e.d.a.q;

import d.e.a;
import e.d.a.t.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache */
public class d {

    /* renamed from: a reason: collision with root package name */
    public final AtomicReference<i> f7845a = new AtomicReference<>();

    /* renamed from: b reason: collision with root package name */
    public final a<i, List<Class<?>>> f7846b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i iVar = (i) this.f7845a.getAndSet(null);
        if (iVar == null) {
            iVar = new i(cls, cls2, cls3);
        } else {
            iVar.f7918a = cls;
            iVar.f7919b = cls2;
            iVar.f7920c = cls3;
        }
        synchronized (this.f7846b) {
            list = (List) this.f7846b.getOrDefault(iVar, null);
        }
        this.f7845a.set(iVar);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f7846b) {
            this.f7846b.put(new i(cls, cls2, cls3), list);
        }
    }
}
