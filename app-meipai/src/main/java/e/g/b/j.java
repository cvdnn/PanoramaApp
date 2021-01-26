package e.g.b;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import e.g.b.c0.g;
import e.g.b.c0.t;
import e.g.b.e0.b;
import e.g.b.e0.c;
import e.g.b.e0.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class j {
    public static final e.g.b.d0.a<?> k = e.g.b.d0.a.get(Object.class);

    /* renamed from: a reason: collision with root package name */
    public final ThreadLocal<Map<e.g.b.d0.a<?>, a<?>>> f8572a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    public final Map<e.g.b.d0.a<?>, z<?>> f8573b = new ConcurrentHashMap();

    /* renamed from: c reason: collision with root package name */
    public final g f8574c;

    /* renamed from: d reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f8575d;

    /* renamed from: e reason: collision with root package name */
    public final List<a0> f8576e;

    /* renamed from: f reason: collision with root package name */
    public final boolean f8577f;

    /* renamed from: g reason: collision with root package name */
    public final boolean f8578g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f8579h;

    /* renamed from: i reason: collision with root package name */
    public final boolean f8580i;

    /* renamed from: j reason: collision with root package name */
    public final boolean f8581j;

    /* compiled from: Gson */
    public static class a<T> extends z<T> {

        /* renamed from: a reason: collision with root package name */
        public z<T> f8582a;

        public T a(e.g.b.e0.a aVar) throws IOException {
            z<T> zVar = this.f8582a;
            if (zVar != null) {
                return zVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        public void a(c cVar, T t) throws IOException {
            z<T> zVar = this.f8582a;
            if (zVar != null) {
                zVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public j() {
        z zVar;
        Excluder excluder = Excluder.f3457f;
        c cVar = c.IDENTITY;
        Map emptyMap = Collections.emptyMap();
        x xVar = x.DEFAULT;
        Collections.emptyList();
        Collections.emptyList();
        List emptyList = Collections.emptyList();
        this.f8574c = new g(emptyMap);
        this.f8577f = false;
        this.f8578g = false;
        this.f8579h = true;
        this.f8580i = false;
        this.f8581j = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.Y);
        arrayList.add(ObjectTypeAdapter.f3484b);
        arrayList.add(excluder);
        arrayList.addAll(emptyList);
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.f3513g);
        arrayList.add(TypeAdapters.f3515i);
        arrayList.add(TypeAdapters.k);
        if (xVar == x.DEFAULT) {
            zVar = TypeAdapters.t;
        } else {
            zVar = new g();
        }
        arrayList.add(new a0(Long.TYPE, Long.class, zVar) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                Class rawType = aVar.getRawType();
                if (rawType == cls15 || rawType == cls16) {
                    return zVar5;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls16.getName());
                a2.append("+");
                a2.append(cls15.getName());
                a2.append(",adapter=");
                a2.append(zVar5);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(new a0(Double.TYPE, Double.class, new e(this)) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                Class rawType = aVar.getRawType();
                if (rawType == cls15 || rawType == cls16) {
                    return zVar5;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls16.getName());
                a2.append("+");
                a2.append(cls15.getName());
                a2.append(",adapter=");
                a2.append(zVar5);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(new a0(Float.TYPE, Float.class, new f(this)) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                Class rawType = aVar.getRawType();
                if (rawType == cls15 || rawType == cls16) {
                    return zVar5;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls16.getName());
                a2.append("+");
                a2.append(cls15.getName());
                a2.append(",adapter=");
                a2.append(zVar5);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(new a0(AtomicLong.class, new y(new h(zVar))) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                if (aVar.getRawType() == cls27) {
                    return sVar;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls27.getName());
                a2.append(",adapter=");
                a2.append(sVar);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(new a0(AtomicLongArray.class, new y(new i(zVar))) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                if (aVar.getRawType() == cls27) {
                    return sVar;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls27.getName());
                a2.append(",adapter=");
                a2.append(sVar);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(new a0(BigDecimal.class, TypeAdapters.B) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                if (aVar.getRawType() == cls27) {
                    return sVar;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls27.getName());
                a2.append(",adapter=");
                a2.append(sVar);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(new a0(BigInteger.class, TypeAdapters.C) {
            public <T> e.g.b.z<T> a(e.g.b.j jVar, e.g.b.d0.a<T> aVar) {
                if (aVar.getRawType() == cls27) {
                    return sVar;
                }
                return null;
            }

            public String toString() {
                StringBuilder a2 = e.a.a.a.a.a("Factory[type=");
                a2.append(cls27.getName());
                a2.append(",adapter=");
                a2.append(sVar);
                a2.append("]");
                return a2.toString();
            }
        });
        arrayList.add(TypeAdapters.J);
        arrayList.add(TypeAdapters.L);
        arrayList.add(TypeAdapters.P);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.W);
        arrayList.add(TypeAdapters.N);
        arrayList.add(TypeAdapters.f3510d);
        arrayList.add(DateTypeAdapter.f3475b);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TimeTypeAdapter.f3498b);
        arrayList.add(SqlDateTypeAdapter.f3496b);
        arrayList.add(TypeAdapters.S);
        arrayList.add(ArrayTypeAdapter.f3469c);
        arrayList.add(TypeAdapters.f3508b);
        arrayList.add(new CollectionTypeAdapterFactory(this.f8574c));
        arrayList.add(new MapTypeAdapterFactory(this.f8574c, false));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.f8574c);
        this.f8575d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f8574c, cVar, excluder, this.f8575d));
        this.f8576e = Collections.unmodifiableList(arrayList);
    }

    public void a(o oVar, c cVar) throws p {
        boolean z = cVar.f8566f;
        cVar.f8566f = true;
        boolean z2 = cVar.f8567g;
        cVar.f8567g = this.f8579h;
        boolean z3 = cVar.f8569i;
        cVar.f8569i = this.f8577f;
        try {
            TypeAdapters.X.a(cVar, oVar);
            cVar.f8566f = z;
            cVar.f8567g = z2;
            cVar.f8569i = z3;
        } catch (IOException e2) {
            throw new p((Throwable) e2);
        } catch (AssertionError e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("AssertionError (GSON 2.8.5): ");
            sb.append(e3.getMessage());
            throw new AssertionError(sb.toString(), e3);
        } catch (Throwable th) {
            cVar.f8566f = z;
            cVar.f8567g = z2;
            cVar.f8569i = z3;
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{serializeNulls:");
        sb.append(this.f8577f);
        sb.append(",factories:");
        sb.append(this.f8576e);
        sb.append(",instanceCreators:");
        sb.append(this.f8574c);
        sb.append("}");
        return sb.toString();
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(d2);
            sb.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=e.g.b.d0.a<T>, code=e.g.b.d0.a, for r6v0, types: [e.g.b.d0.a, java.lang.Object, e.g.b.d0.a<T>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> e.g.b.z<T> a(e.g.b.d0.a r6) {
        /*
            r5 = this;
            java.util.Map<e.g.b.d0.a<?>, e.g.b.z<?>> r0 = r5.f8573b
            if (r6 != 0) goto L_0x0007
            e.g.b.d0.a<?> r1 = k
            goto L_0x0008
        L_0x0007:
            r1 = r6
        L_0x0008:
            java.lang.Object r0 = r0.get(r1)
            e.g.b.z r0 = (e.g.b.z) r0
            if (r0 == 0) goto L_0x0011
            return r0
        L_0x0011:
            java.lang.ThreadLocal<java.util.Map<e.g.b.d0.a<?>, e.g.b.j$a<?>>> r0 = r5.f8572a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<e.g.b.d0.a<?>, e.g.b.j$a<?>>> r1 = r5.f8572a
            r1.set(r0)
            r1 = 1
        L_0x0027:
            java.lang.Object r2 = r0.get(r6)
            e.g.b.j$a r2 = (e.g.b.j.a) r2
            if (r2 == 0) goto L_0x0030
            return r2
        L_0x0030:
            e.g.b.j$a r2 = new e.g.b.j$a     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            r0.put(r6, r2)     // Catch:{ all -> 0x0083 }
            java.util.List<e.g.b.a0> r3 = r5.f8576e     // Catch:{ all -> 0x0083 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0083 }
        L_0x003e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x006c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0083 }
            e.g.b.a0 r4 = (e.g.b.a0) r4     // Catch:{ all -> 0x0083 }
            e.g.b.z r4 = r4.a(r5, r6)     // Catch:{ all -> 0x0083 }
            if (r4 == 0) goto L_0x003e
            e.g.b.z<T> r3 = r2.f8582a     // Catch:{ all -> 0x0083 }
            if (r3 != 0) goto L_0x0066
            r2.f8582a = r4     // Catch:{ all -> 0x0083 }
            java.util.Map<e.g.b.d0.a<?>, e.g.b.z<?>> r2 = r5.f8573b     // Catch:{ all -> 0x0083 }
            r2.put(r6, r4)     // Catch:{ all -> 0x0083 }
            r0.remove(r6)
            if (r1 == 0) goto L_0x0065
            java.lang.ThreadLocal<java.util.Map<e.g.b.d0.a<?>, e.g.b.j$a<?>>> r6 = r5.f8572a
            r6.remove()
        L_0x0065:
            return r4
        L_0x0066:
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            throw r2     // Catch:{ all -> 0x0083 }
        L_0x006c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r3.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "GSON (2.8.5) cannot handle "
            r3.append(r4)     // Catch:{ all -> 0x0083 }
            r3.append(r6)     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0083 }
            r2.<init>(r3)     // Catch:{ all -> 0x0083 }
            throw r2     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r2 = move-exception
            r0.remove(r6)
            if (r1 == 0) goto L_0x008e
            java.lang.ThreadLocal<java.util.Map<e.g.b.d0.a<?>, e.g.b.j$a<?>>> r6 = r5.f8572a
            r6.remove()
        L_0x008e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.j.a(e.g.b.d0.a):e.g.b.z");
    }

    public <T> z<T> a(a0 a0Var, e.g.b.d0.a<T> aVar) {
        if (!this.f8576e.contains(a0Var)) {
            a0Var = this.f8575d;
        }
        boolean z = false;
        for (a0 a0Var2 : this.f8576e) {
            if (z) {
                z<T> a2 = a0Var2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (a0Var2 == a0Var) {
                z = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("GSON cannot serialize ");
        sb.append(aVar);
        throw new IllegalArgumentException(sb.toString());
    }

    public String a(Object obj) {
        if (obj == null) {
            q qVar = q.f8584a;
            StringWriter stringWriter = new StringWriter();
            try {
                a((o) qVar, a((Writer) stringWriter));
                return stringWriter.toString();
            } catch (IOException e2) {
                throw new p((Throwable) e2);
            }
        } else {
            Class cls = obj.getClass();
            StringWriter stringWriter2 = new StringWriter();
            try {
                a(obj, cls, a((Writer) stringWriter2));
                return stringWriter2.toString();
            } catch (IOException e3) {
                throw new p((Throwable) e3);
            }
        }
    }

    public void a(Object obj, Type type, c cVar) throws p {
        z a2 = a(e.g.b.d0.a.get(type));
        boolean z = cVar.f8566f;
        cVar.f8566f = true;
        boolean z2 = cVar.f8567g;
        cVar.f8567g = this.f8579h;
        boolean z3 = cVar.f8569i;
        cVar.f8569i = this.f8577f;
        try {
            a2.a(cVar, obj);
            cVar.f8566f = z;
            cVar.f8567g = z2;
            cVar.f8569i = z3;
        } catch (IOException e2) {
            throw new p((Throwable) e2);
        } catch (AssertionError e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("AssertionError (GSON 2.8.5): ");
            sb.append(e3.getMessage());
            throw new AssertionError(sb.toString(), e3);
        } catch (Throwable th) {
            cVar.f8566f = z;
            cVar.f8567g = z2;
            cVar.f8569i = z3;
            throw th;
        }
    }

    public c a(Writer writer) throws IOException {
        if (this.f8578g) {
            writer.write(")]}'\n");
        }
        c cVar = new c(writer);
        if (this.f8580i) {
            cVar.f8564d = "  ";
            cVar.f8565e = ": ";
        }
        cVar.f8569i = this.f8577f;
        return cVar;
    }

    public <T> T a(String str, Class<T> cls) throws w {
        Object a2 = a(str, (Type) cls);
        Map<Class<?>, Class<?>> map = t.f8521a;
        if (cls != null) {
            Class<T> cls2 = (Class) map.get(cls);
            if (cls2 != null) {
                cls = cls2;
            }
            return cls.cast(a2);
        }
        throw null;
    }

    public <T> T a(String str, Type type) throws w {
        T t = null;
        if (str == null) {
            return null;
        }
        e.g.b.e0.a aVar = new e.g.b.e0.a(new StringReader(str));
        boolean z = this.f8581j;
        aVar.f8541b = z;
        aVar.f8541b = true;
        try {
            aVar.A();
            t = a(e.g.b.d0.a.get(type)).a(aVar);
        } catch (EOFException e2) {
            if (1 == 0) {
                throw new w((Throwable) e2);
            }
        } catch (IllegalStateException e3) {
            throw new w((Throwable) e3);
        } catch (IOException e4) {
            throw new w((Throwable) e4);
        } catch (AssertionError e5) {
            StringBuilder sb = new StringBuilder();
            sb.append("AssertionError (GSON 2.8.5): ");
            sb.append(e5.getMessage());
            throw new AssertionError(sb.toString(), e5);
        } catch (Throwable th) {
            aVar.f8541b = z;
            throw th;
        }
        aVar.f8541b = z;
        if (t != null) {
            try {
                if (aVar.A() != b.END_DOCUMENT) {
                    throw new p("JSON document was not fully consumed.");
                }
            } catch (d e6) {
                throw new w((Throwable) e6);
            } catch (IOException e7) {
                throw new p((Throwable) e7);
            }
        }
        return t;
    }
}
