package e.d.a.n.p.h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry */
public class f {

    /* renamed from: a reason: collision with root package name */
    public final List<a<?, ?>> f7797a = new ArrayList();

    /* compiled from: TranscoderRegistry */
    public static final class a<Z, R> {

        /* renamed from: a reason: collision with root package name */
        public final Class<Z> f7798a;

        /* renamed from: b reason: collision with root package name */
        public final Class<R> f7799b;

        /* renamed from: c reason: collision with root package name */
        public final e<Z, R> f7800c;

        public a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f7798a = cls;
            this.f7799b = cls2;
            this.f7800c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f7798a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f7799b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f7797a.add(new a(cls, cls2, eVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a a2 : this.f7797a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.f7801a;
        }
        for (a aVar : this.f7797a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f7800c;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No transcoder registered to transcode from ");
        sb.append(cls);
        sb.append(" to ");
        sb.append(cls2);
        throw new IllegalArgumentException(sb.toString());
    }
}
