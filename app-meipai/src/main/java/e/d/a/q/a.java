package e.d.a.q;

import e.d.a.n.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final List<C0097a<?>> f7838a = new ArrayList();

    /* renamed from: e.d.a.q.a$a reason: collision with other inner class name */
    /* compiled from: EncoderRegistry */
    public static final class C0097a<T> {

        /* renamed from: a reason: collision with root package name */
        public final Class<T> f7839a;

        /* renamed from: b reason: collision with root package name */
        public final d<T> f7840b;

        public C0097a(Class<T> cls, d<T> dVar) {
            this.f7839a = cls;
            this.f7840b = dVar;
        }
    }

    public synchronized <T> d<T> a(Class<T> cls) {
        for (C0097a aVar : this.f7838a) {
            if (aVar.f7839a.isAssignableFrom(cls)) {
                return aVar.f7840b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f7838a.add(new C0097a(cls, dVar));
    }
}
