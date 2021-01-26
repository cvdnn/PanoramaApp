package e.d.a.q;

import e.d.a.n.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry */
public class f {

    /* renamed from: a reason: collision with root package name */
    public final List<a<?>> f7852a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry */
    public static final class a<T> {

        /* renamed from: a reason: collision with root package name */
        public final Class<T> f7853a;

        /* renamed from: b reason: collision with root package name */
        public final k<T> f7854b;

        public a(Class<T> cls, k<T> kVar) {
            this.f7853a = cls;
            this.f7854b = kVar;
        }
    }

    public synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.f7852a.add(new a(cls, kVar));
    }

    public synchronized <Z> k<Z> a(Class<Z> cls) {
        int size = this.f7852a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.f7852a.get(i2);
            if (aVar.f7853a.isAssignableFrom(cls)) {
                return aVar.f7854b;
            }
        }
        return null;
    }
}
