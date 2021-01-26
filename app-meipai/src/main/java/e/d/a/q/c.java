package e.d.a.q;

import d.e.a;
import e.d.a.n.n.j;
import e.d.a.n.n.u;
import e.d.a.n.p.h.g;
import e.d.a.t.i;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache */
public class c {

    /* renamed from: c reason: collision with root package name */
    public static final u<?, ?, ?> f7842c;

    /* renamed from: a reason: collision with root package name */
    public final a<i, u<?, ?, ?>> f7843a = new a<>();

    /* renamed from: b reason: collision with root package name */
    public final AtomicReference<i> f7844b = new AtomicReference<>();

    static {
        j jVar = new j(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null);
        u uVar = new u(Object.class, Object.class, Object.class, Collections.singletonList(jVar), null);
        f7842c = uVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, u<?, ?, ?> uVar) {
        synchronized (this.f7843a) {
            a<i, u<?, ?, ?>> aVar = this.f7843a;
            i iVar = new i(cls, cls2, cls3);
            if (uVar == null) {
                uVar = f7842c;
            }
            aVar.put(iVar, uVar);
        }
    }

    public <Data, TResource, Transcode> u<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        u<Data, TResource, Transcode> uVar;
        i iVar = (i) this.f7844b.getAndSet(null);
        if (iVar == null) {
            iVar = new i();
        }
        iVar.f7918a = cls;
        iVar.f7919b = cls2;
        iVar.f7920c = cls3;
        synchronized (this.f7843a) {
            uVar = (u) this.f7843a.getOrDefault(iVar, null);
        }
        this.f7844b.set(iVar);
        return uVar;
    }
}
