package d.p;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling */
public class k {

    /* renamed from: a reason: collision with root package name */
    public static Map<Class, Integer> f5289a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public static Map<Class, List<Constructor<? extends c>>> f5290b = new HashMap();

    public static f a(Object obj) {
        boolean z = obj instanceof f;
        boolean z2 = obj instanceof b;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((b) obj, (f) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((b) obj, null);
        }
        if (z) {
            return (f) obj;
        }
        Class cls = obj.getClass();
        if (a(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f5290b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        c[] cVarArr = new c[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            cVarArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    public static c a(Constructor<? extends c> constructor, Object obj) {
        try {
            return (c) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static int a(Class<?> cls) {
        Constructor constructor;
        boolean z;
        Integer num = (Integer) f5289a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        Class<g> cls2 = g.class;
        int i2 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package packageR = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = packageR != null ? packageR.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String a2 = a(canonicalName);
                if (!name.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(".");
                    sb.append(a2);
                    a2 = sb.toString();
                }
                constructor = Class.forName(a2).getDeclaredConstructor(new Class[]{cls});
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
            if (constructor != null) {
                f5290b.put(cls, Collections.singletonList(constructor));
            } else {
                a aVar = a.f5267c;
                Boolean bool = (Boolean) aVar.f5269b.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                aVar.f5269b.put(cls, Boolean.valueOf(false));
                                z = false;
                                break;
                            } else if (((o) declaredMethods[i3].getAnnotation(o.class)) != null) {
                                aVar.a(cls, declaredMethods);
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    } catch (NoClassDefFoundError e3) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && cls2.isAssignableFrom(superclass)) {
                        if (a(superclass) != 1) {
                            arrayList = new ArrayList((Collection) f5290b.get(superclass));
                        }
                    }
                    Class[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            Class cls3 = interfaces[i4];
                            if (cls3 != null && cls2.isAssignableFrom(cls3)) {
                                if (a(cls3) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll((Collection) f5290b.get(cls3));
                            }
                            i4++;
                        } else if (arrayList != null) {
                            f5290b.put(cls, arrayList);
                        }
                    }
                }
            }
            i2 = 2;
        }
        f5289a.put(cls, Integer.valueOf(i2));
        return i2;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace(".", "_"));
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }
}
