package d.p;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ClassesInfoCache */
public class a {

    /* renamed from: c reason: collision with root package name */
    public static a f5267c = new a();

    /* renamed from: a reason: collision with root package name */
    public final Map<Class, C0051a> f5268a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public final Map<Class, Boolean> f5269b = new HashMap();

    /* renamed from: d.p.a$a reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    public static class C0051a {

        /* renamed from: a reason: collision with root package name */
        public final Map<d.p.e.a, List<b>> f5270a = new HashMap();

        /* renamed from: b reason: collision with root package name */
        public final Map<b, d.p.e.a> f5271b;

        public C0051a(Map<b, d.p.e.a> map) {
            this.f5271b = map;
            for (Entry entry : map.entrySet()) {
                d.p.e.a aVar = (d.p.e.a) entry.getValue();
                List list = (List) this.f5270a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f5270a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void a(List<b> list, h hVar, d.p.e.a aVar, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    b bVar = (b) list.get(size);
                    if (bVar != null) {
                        try {
                            int i2 = bVar.f5272a;
                            if (i2 == 0) {
                                bVar.f5273b.invoke(obj, new Object[0]);
                            } else if (i2 == 1) {
                                bVar.f5273b.invoke(obj, new Object[]{hVar});
                            } else if (i2 == 2) {
                                bVar.f5273b.invoke(obj, new Object[]{hVar, aVar});
                            }
                            size--;
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException("Failed to call observer method", e2.getCause());
                        } catch (IllegalAccessException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final int f5272a;

        /* renamed from: b reason: collision with root package name */
        public final Method f5273b;

        public b(int i2, Method method) {
            this.f5272a = i2;
            this.f5273b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f5272a != bVar.f5272a || !this.f5273b.getName().equals(bVar.f5273b.getName())) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f5273b.getName().hashCode() + (this.f5272a * 31);
        }
    }

    public C0051a a(Class cls) {
        C0051a aVar = (C0051a) this.f5268a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, null);
    }

    public final void a(Map<b, d.p.e.a> map, b bVar, d.p.e.a aVar, Class cls) {
        d.p.e.a aVar2 = (d.p.e.a) map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f5273b;
            StringBuilder a2 = e.a.a.a.a.a("Method ");
            a2.append(method.getName());
            a2.append(" in ");
            a2.append(cls.getName());
            a2.append(" already declared with different @OnLifecycleEvent value: previous value ");
            a2.append(aVar2);
            a2.append(", new value ");
            a2.append(aVar);
            throw new IllegalArgumentException(a2.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    public final C0051a a(Class cls, Method[] methodArr) {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            C0051a a2 = a(superclass);
            if (a2 != null) {
                hashMap.putAll(a2.f5271b);
            }
        }
        for (Class a3 : cls.getInterfaces()) {
            for (Entry entry : a(a3).f5271b.entrySet()) {
                a(hashMap, (b) entry.getKey(), (d.p.e.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            o oVar = (o) method.getAnnotation(o.class);
            if (oVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(h.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                d.p.e.a value = oVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.p.e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == d.p.e.a.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0051a aVar = new C0051a(hashMap);
        this.f5268a.put(cls, aVar);
        this.f5269b.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
