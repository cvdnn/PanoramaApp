package e.g.b.c0;

import e.g.b.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor */
public final class g {

    /* renamed from: a reason: collision with root package name */
    public final Map<Type, k<?>> f8488a;

    /* renamed from: b reason: collision with root package name */
    public final e.g.b.c0.a0.b f8489b = e.g.b.c0.a0.b.f8481a;

    /* compiled from: ConstructorConstructor */
    public class a implements s<T> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ k f8490a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Type f8491b;

        public a(g gVar, k kVar, Type type) {
            this.f8490a = kVar;
            this.f8491b = type;
        }

        public T a() {
            return this.f8490a.a(this.f8491b);
        }
    }

    /* compiled from: ConstructorConstructor */
    public class b implements s<T> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ k f8492a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Type f8493b;

        public b(g gVar, k kVar, Type type) {
            this.f8492a = kVar;
            this.f8493b = type;
        }

        public T a() {
            return this.f8492a.a(this.f8493b);
        }
    }

    public g(Map<Type, k<?>> map) {
        this.f8488a = map;
    }

    public <T> s<T> a(e.g.b.d0.a<T> aVar) {
        s<T> sVar;
        Type type = aVar.getType();
        Class rawType = aVar.getRawType();
        k kVar = (k) this.f8488a.get(type);
        if (kVar != null) {
            return new a(this, kVar, type);
        }
        k kVar2 = (k) this.f8488a.get(rawType);
        if (kVar2 != null) {
            return new b(this, kVar2, type);
        }
        s<T> sVar2 = null;
        try {
            Constructor declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f8489b.a(declaredConstructor);
            }
            sVar = new h<>(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            sVar = null;
        }
        if (sVar != null) {
            return sVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                sVar2 = new i<>(this);
            } else if (EnumSet.class.isAssignableFrom(rawType)) {
                sVar2 = new j<>(this, type);
            } else if (Set.class.isAssignableFrom(rawType)) {
                sVar2 = new k<>(this);
            } else if (Queue.class.isAssignableFrom(rawType)) {
                sVar2 = new l<>(this);
            } else {
                sVar2 = new m<>(this);
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                sVar2 = new n<>(this);
            } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                sVar2 = new b<>(this);
            } else if (SortedMap.class.isAssignableFrom(rawType)) {
                sVar2 = new c<>(this);
            } else if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(e.g.b.d0.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                sVar2 = new e<>(this);
            } else {
                sVar2 = new d<>(this);
            }
        }
        if (sVar2 != null) {
            return sVar2;
        }
        return new f(this, rawType, type);
    }

    public String toString() {
        return this.f8488a.toString();
    }
}
