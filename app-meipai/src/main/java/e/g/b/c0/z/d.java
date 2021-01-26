package e.g.b.c0.z;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import e.g.b.e0.a;
import e.g.b.e0.c;
import e.g.b.j;
import e.g.b.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
public final class d<T> extends z<T> {

    /* renamed from: a reason: collision with root package name */
    public final j f8533a;

    /* renamed from: b reason: collision with root package name */
    public final z<T> f8534b;

    /* renamed from: c reason: collision with root package name */
    public final Type f8535c;

    public d(j jVar, z<T> zVar, Type type) {
        this.f8533a = jVar;
        this.f8534b = zVar;
        this.f8535c = type;
    }

    public T a(a aVar) throws IOException {
        return this.f8534b.a(aVar);
    }

    public void a(c cVar, T t) throws IOException {
        z<T> zVar = this.f8534b;
        Type type = this.f8535c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f8535c) {
            zVar = this.f8533a.a(e.g.b.d0.a.get(type));
            if (zVar instanceof ReflectiveTypeAdapterFactory.a) {
                z<T> zVar2 = this.f8534b;
                if (!(zVar2 instanceof ReflectiveTypeAdapterFactory.a)) {
                    zVar = zVar2;
                }
            }
        }
        zVar.a(cVar, t);
    }
}
