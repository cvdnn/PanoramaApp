package i.b.a;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* compiled from: EventBus */
public class c {
    public static volatile c s;
    public static final d t = new d();
    public static final Map<Class<?>, List<Class<?>>> u = new HashMap();

    /* renamed from: a reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<q>> f9724a;

    /* renamed from: b reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f9725b;

    /* renamed from: c reason: collision with root package name */
    public final Map<Class<?>, Object> f9726c;

    /* renamed from: d reason: collision with root package name */
    public final ThreadLocal<b> f9727d = new a(this);

    /* renamed from: e reason: collision with root package name */
    public final h f9728e;

    /* renamed from: f reason: collision with root package name */
    public final l f9729f;

    /* renamed from: g reason: collision with root package name */
    public final b f9730g;

    /* renamed from: h reason: collision with root package name */
    public final a f9731h;

    /* renamed from: i reason: collision with root package name */
    public final p f9732i;

    /* renamed from: j reason: collision with root package name */
    public final ExecutorService f9733j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final g r;

    /* compiled from: EventBus */
    public class a extends ThreadLocal<b> {
        public a(c cVar) {
        }

        public Object initialValue() {
            return new b();
        }
    }

    /* compiled from: EventBus */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        public final List<Object> f9734a = new ArrayList();

        /* renamed from: b reason: collision with root package name */
        public boolean f9735b;

        /* renamed from: c reason: collision with root package name */
        public boolean f9736c;

        /* renamed from: d reason: collision with root package name */
        public Object f9737d;

        /* renamed from: e reason: collision with root package name */
        public boolean f9738e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[SYNTHETIC, Splitter:B:13:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c() {
        /*
            r5 = this;
            i.b.a.d r0 = t
            r5.<init>()
            i.b.a.c$a r1 = new i.b.a.c$a
            r1.<init>(r5)
            r5.f9727d = r1
            r1 = 0
            if (r0 == 0) goto L_0x00a6
            boolean r2 = i.b.a.r.a.f9785b
            if (r2 == 0) goto L_0x0023
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            if (r2 == 0) goto L_0x0023
            i.b.a.r.a r2 = new i.b.a.r.a
            java.lang.String r3 = "EventBus"
            r2.<init>(r3)
            goto L_0x0028
        L_0x0023:
            i.b.a.g$a r2 = new i.b.a.g$a
            r2.<init>()
        L_0x0028:
            r5.r = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5.f9724a = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5.f9725b = r2
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            r5.f9726c = r2
            boolean r2 = i.b.a.r.a.f9785b
            if (r2 == 0) goto L_0x0052
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x0048 }
            goto L_0x0049
        L_0x0048:
            r2 = r1
        L_0x0049:
            if (r2 != 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            i.b.a.h$a r3 = new i.b.a.h$a
            r3.<init>(r2)
            goto L_0x0053
        L_0x0052:
            r3 = r1
        L_0x0053:
            r5.f9728e = r3
            if (r3 == 0) goto L_0x0060
            i.b.a.f r1 = new i.b.a.f
            android.os.Looper r2 = r3.f9753a
            r3 = 10
            r1.<init>(r5, r2, r3)
        L_0x0060:
            r5.f9729f = r1
            i.b.a.b r1 = new i.b.a.b
            r1.<init>(r5)
            r5.f9730g = r1
            i.b.a.a r1 = new i.b.a.a
            r1.<init>(r5)
            r5.f9731h = r1
            java.util.List<i.b.a.s.b> r1 = r0.f9748j
            if (r1 == 0) goto L_0x0079
            int r1 = r1.size()
            goto L_0x007a
        L_0x0079:
            r1 = 0
        L_0x007a:
            r5.q = r1
            i.b.a.p r1 = new i.b.a.p
            java.util.List<i.b.a.s.b> r2 = r0.f9748j
            boolean r3 = r0.f9746h
            boolean r4 = r0.f9745g
            r1.<init>(r2, r3, r4)
            r5.f9732i = r1
            boolean r1 = r0.f9739a
            r5.l = r1
            boolean r1 = r0.f9740b
            r5.m = r1
            boolean r1 = r0.f9741c
            r5.n = r1
            boolean r1 = r0.f9742d
            r5.o = r1
            boolean r1 = r0.f9743e
            r5.k = r1
            boolean r1 = r0.f9744f
            r5.p = r1
            java.util.concurrent.ExecutorService r0 = r0.f9747i
            r5.f9733j = r0
            return
        L_0x00a6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.a.c.<init>():void");
    }

    public static c b() {
        c cVar = s;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = s;
                if (cVar == null) {
                    cVar = new c();
                    s = cVar;
                }
            }
        }
        return cVar;
    }

    public final void a(Object obj, o oVar) {
        Class<?> cls = oVar.f9766c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9724a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f9724a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            StringBuilder a2 = e.a.a.a.a.a("Subscriber ");
            a2.append(obj.getClass());
            a2.append(" already registered to event ");
            a2.append(cls);
            throw new e(a2.toString());
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || oVar.f9767d > ((q) copyOnWriteArrayList.get(i2)).f9783b.f9767d) {
                copyOnWriteArrayList.add(i2, qVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, qVar);
        List list = (List) this.f9725b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f9725b.put(obj, list);
        }
        list.add(cls);
        if (!oVar.f9768e) {
            return;
        }
        if (this.p) {
            for (Entry entry : this.f9726c.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    Object value = entry.getValue();
                    if (value != null) {
                        a(qVar, value, a());
                    }
                }
            }
            return;
        }
        Object obj2 = this.f9726c.get(cls);
        if (obj2 != null) {
            a(qVar, obj2, a());
        }
    }

    public synchronized void c(Object obj) {
        List<Class> list = (List) this.f9725b.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = (List) this.f9724a.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        q qVar = (q) list2.get(i2);
                        if (qVar.f9782a == obj) {
                            qVar.f9784c = false;
                            list2.remove(i2);
                            i2--;
                            size--;
                        }
                        i2++;
                    }
                }
            }
            this.f9725b.remove(obj);
        } else {
            g gVar = this.r;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Subscriber to unregister was not registered before: ");
            sb.append(obj.getClass());
            gVar.a(level, sb.toString());
        }
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("EventBus[indexCount=");
        a2.append(this.q);
        a2.append(", eventInheritance=");
        a2.append(this.p);
        a2.append("]");
        return a2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r3.f9779e == r5.c()) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Class r0 = r12.getClass()
            i.b.a.p r1 = r11.f9732i
            r2 = 0
            if (r1 == 0) goto L_0x00e8
            java.util.Map<java.lang.Class<?>, java.util.List<i.b.a.o>> r3 = i.b.a.p.f9770d
            java.lang.Object r3 = r3.get(r0)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0015
            goto L_0x00b2
        L_0x0015:
            boolean r3 = r1.f9774c
            r4 = 0
            if (r3 == 0) goto L_0x0035
            i.b.a.p$a r3 = r1.a()
            r3.f9779e = r0
            r3.f9780f = r4
            r3.f9781g = r2
        L_0x0024:
            java.lang.Class<?> r2 = r3.f9779e
            if (r2 == 0) goto L_0x002f
            r1.a(r3)
            r3.a()
            goto L_0x0024
        L_0x002f:
            java.util.List r1 = r1.b(r3)
            goto L_0x00a6
        L_0x0035:
            i.b.a.p$a r3 = r1.a()
            r3.f9779e = r0
            r3.f9780f = r4
            r3.f9781g = r2
        L_0x003f:
            java.lang.Class<?> r5 = r3.f9779e
            if (r5 == 0) goto L_0x00a2
            i.b.a.s.a r5 = r3.f9781g
            if (r5 == 0) goto L_0x005c
            i.b.a.s.a r5 = r5.b()
            if (r5 == 0) goto L_0x005c
            i.b.a.s.a r5 = r3.f9781g
            i.b.a.s.a r5 = r5.b()
            java.lang.Class<?> r6 = r3.f9779e
            java.lang.Class r7 = r5.c()
            if (r6 != r7) goto L_0x005c
            goto L_0x007b
        L_0x005c:
            java.util.List<i.b.a.s.b> r5 = r1.f9772a
            if (r5 == 0) goto L_0x007a
            java.util.Iterator r5 = r5.iterator()
        L_0x0064:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r5.next()
            i.b.a.s.b r6 = (i.b.a.s.b) r6
            java.lang.Class<?> r7 = r3.f9779e
            i.b.a.s.a r6 = r6.a(r7)
            if (r6 == 0) goto L_0x0064
            r5 = r6
            goto L_0x007b
        L_0x007a:
            r5 = r2
        L_0x007b:
            r3.f9781g = r5
            if (r5 == 0) goto L_0x009b
            i.b.a.o[] r5 = r5.a()
            int r6 = r5.length
            r7 = r4
        L_0x0085:
            if (r7 >= r6) goto L_0x009e
            r8 = r5[r7]
            java.lang.reflect.Method r9 = r8.f9764a
            java.lang.Class<?> r10 = r8.f9766c
            boolean r9 = r3.a(r9, r10)
            if (r9 == 0) goto L_0x0098
            java.util.List<i.b.a.o> r9 = r3.f9775a
            r9.add(r8)
        L_0x0098:
            int r7 = r7 + 1
            goto L_0x0085
        L_0x009b:
            r1.a(r3)
        L_0x009e:
            r3.a()
            goto L_0x003f
        L_0x00a2:
            java.util.List r1 = r1.b(r3)
        L_0x00a6:
            r3 = r1
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x00cc
            java.util.Map<java.lang.Class<?>, java.util.List<i.b.a.o>> r1 = i.b.a.p.f9770d
            r1.put(r0, r3)
        L_0x00b2:
            monitor-enter(r11)
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x00c9 }
        L_0x00b7:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00c7
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00c9 }
            i.b.a.o r1 = (i.b.a.o) r1     // Catch:{ all -> 0x00c9 }
            r11.a(r12, r1)     // Catch:{ all -> 0x00c9 }
            goto L_0x00b7
        L_0x00c7:
            monitor-exit(r11)     // Catch:{ all -> 0x00c9 }
            return
        L_0x00c9:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00c9 }
            throw r12
        L_0x00cc:
            i.b.a.e r12 = new i.b.a.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Subscriber "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " and its super classes have no public methods with the @Subscribe annotation"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r12.<init>(r0)
            throw r12
        L_0x00e8:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.a.c.b(java.lang.Object):void");
    }

    public final boolean a() {
        h hVar = this.f9728e;
        if (hVar != null) {
            if (!(((i.b.a.h.a) hVar).f9753a == Looper.myLooper())) {
                return false;
            }
        }
        return true;
    }

    public void a(Object obj) {
        b bVar = (b) this.f9727d.get();
        List<Object> list = bVar.f9734a;
        list.add(obj);
        if (!bVar.f9735b) {
            bVar.f9736c = a();
            bVar.f9735b = true;
            if (!bVar.f9738e) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), bVar);
                    } finally {
                        bVar.f9735b = false;
                        bVar.f9736c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    public final void a(Object obj, b bVar) throws Error {
        boolean z;
        Class<n> cls = obj.getClass();
        if (this.p) {
            List a2 = a(cls);
            z = false;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                z |= a(obj, bVar, (Class) a2.get(i2));
            }
        } else {
            z = a(obj, bVar, cls);
        }
        if (!z) {
            if (this.m) {
                g gVar = this.r;
                Level level = Level.FINE;
                StringBuilder sb = new StringBuilder();
                sb.append("No subscribers registered for event ");
                sb.append(cls);
                gVar.a(level, sb.toString());
            }
            if (this.o && cls != i.class && cls != n.class) {
                a((Object) new i(this, obj));
            }
        }
    }

    public final boolean a(Object obj, b bVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9724a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            bVar.f9737d = obj;
            try {
                a(qVar, obj, bVar.f9736c);
                if (bVar.f9738e) {
                    break;
                }
            } finally {
                bVar.f9738e = false;
            }
        }
        return true;
    }

    public final void a(q qVar, Object obj, boolean z) {
        int ordinal = qVar.f9783b.f9765b.ordinal();
        if (ordinal == 0) {
            a(qVar, obj);
        } else if (ordinal != 1) {
            if (ordinal == 2) {
                l lVar = this.f9729f;
                if (lVar != null) {
                    lVar.a(qVar, obj);
                } else {
                    a(qVar, obj);
                }
            } else if (ordinal != 3) {
                if (ordinal == 4) {
                    this.f9731h.a(qVar, obj);
                    return;
                }
                StringBuilder a2 = e.a.a.a.a.a("Unknown thread mode: ");
                a2.append(qVar.f9783b.f9765b);
                throw new IllegalStateException(a2.toString());
            } else if (z) {
                this.f9730g.a(qVar, obj);
            } else {
                a(qVar, obj);
            }
        } else if (z) {
            a(qVar, obj);
        } else {
            this.f9729f.a(qVar, obj);
        }
    }

    public static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (u) {
            list = (List) u.get(cls);
            if (list == 0) {
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    arrayList.add(cls2);
                    a((List<Class<?>>) arrayList, (Class<?>[]) cls2.getInterfaces());
                }
                u.put(cls, arrayList);
                list = arrayList;
            }
        }
        return list;
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    public void a(j jVar) {
        Object obj = jVar.f9756a;
        q qVar = jVar.f9757b;
        j.a(jVar);
        if (qVar.f9784c) {
            a(qVar, obj);
        }
    }

    public void a(q qVar, Object obj) {
        try {
            qVar.f9783b.f9764a.invoke(qVar.f9782a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof n) {
                if (this.l) {
                    g gVar = this.r;
                    Level level = Level.SEVERE;
                    StringBuilder a2 = e.a.a.a.a.a("SubscriberExceptionEvent subscriber ");
                    a2.append(qVar.f9782a.getClass());
                    a2.append(" threw an exception");
                    gVar.a(level, a2.toString(), cause);
                    n nVar = (n) obj;
                    g gVar2 = this.r;
                    Level level2 = Level.SEVERE;
                    StringBuilder a3 = e.a.a.a.a.a("Initial event ");
                    a3.append(nVar.f9762b);
                    a3.append(" caused exception in ");
                    a3.append(nVar.f9763c);
                    gVar2.a(level2, a3.toString(), nVar.f9761a);
                }
            } else if (!this.k) {
                if (this.l) {
                    g gVar3 = this.r;
                    Level level3 = Level.SEVERE;
                    StringBuilder a4 = e.a.a.a.a.a("Could not dispatch event: ");
                    a4.append(obj.getClass());
                    a4.append(" to subscribing class ");
                    a4.append(qVar.f9782a.getClass());
                    gVar3.a(level3, a4.toString(), cause);
                }
                if (this.n) {
                    a((Object) new n(this, cause, obj, qVar.f9782a));
                }
            } else {
                throw new e("Invoking subscriber failed", cause);
            }
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }
}
