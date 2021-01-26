package i.b.a;

import i.b.a.s.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SubscriberMethodFinder */
public class p {

    /* renamed from: d reason: collision with root package name */
    public static final Map<Class<?>, List<o>> f9770d = new ConcurrentHashMap();

    /* renamed from: e reason: collision with root package name */
    public static final a[] f9771e = new a[4];

    /* renamed from: a reason: collision with root package name */
    public List<b> f9772a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f9773b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f9774c;

    /* compiled from: SubscriberMethodFinder */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public final List<o> f9775a = new ArrayList();

        /* renamed from: b reason: collision with root package name */
        public final Map<Class, Object> f9776b = new HashMap();

        /* renamed from: c reason: collision with root package name */
        public final Map<String, Class> f9777c = new HashMap();

        /* renamed from: d reason: collision with root package name */
        public final StringBuilder f9778d = new StringBuilder(128);

        /* renamed from: e reason: collision with root package name */
        public Class<?> f9779e;

        /* renamed from: f reason: collision with root package name */
        public boolean f9780f;

        /* renamed from: g reason: collision with root package name */
        public i.b.a.s.a f9781g;

        public boolean a(Method method, Class<?> cls) {
            Object put = this.f9776b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f9776b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.f9778d.setLength(0);
            this.f9778d.append(method.getName());
            StringBuilder sb = this.f9778d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f9778d.toString();
            Class declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.f9777c.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f9777c.put(sb2, cls2);
            return false;
        }

        public void a() {
            if (this.f9780f) {
                this.f9779e = null;
                return;
            }
            Class<?> superclass = this.f9779e.getSuperclass();
            this.f9779e = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f9779e = null;
            }
        }
    }

    public p(List<b> list, boolean z, boolean z2) {
        this.f9772a = list;
        this.f9773b = z;
        this.f9774c = z2;
    }

    public final a a() {
        synchronized (f9771e) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f9771e[i2];
                if (aVar != null) {
                    f9771e[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    public final List<o> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f9775a);
        aVar.f9775a.clear();
        aVar.f9776b.clear();
        aVar.f9777c.clear();
        int i2 = 0;
        aVar.f9778d.setLength(0);
        aVar.f9779e = null;
        aVar.f9780f = false;
        aVar.f9781g = null;
        synchronized (f9771e) {
            while (true) {
                if (i2 >= 4) {
                    break;
                } else if (f9771e[i2] == null) {
                    f9771e[i2] = aVar;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r1 = e.a.a.a.a.a("Could not inspect methods of ");
        r1.append(r15.f9779e.getName());
        r15 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f8, code lost:
        if (r14.f9774c != false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fa, code lost:
        r15 = e.a.a.a.a.a(r15, ". Please consider using EventBus annotation processor to avoid reflection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0101, code lost:
        r15 = e.a.a.a.a.a(r15, ". Please make this class visible to EventBus annotation processor to avoid reflection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010c, code lost:
        throw new i.b.a.e(r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.f9779e.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.f9780f = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(i.b.a.p.a r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class<?> r1 = r15.f9779e     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class<?> r1 = r15.f9779e     // Catch:{ LinkageError -> 0x00e2 }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00e2 }
            r15.f9780f = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x0013:
            if (r4 >= r2) goto L_0x00e1
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            if (r7 == 0) goto L_0x00a6
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x00a6
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.Class<i.b.a.m> r7 = i.b.a.m.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)
            i.b.a.m r7 = (i.b.a.m) r7
            if (r7 == 0) goto L_0x00dd
            r8 = r5[r3]
            boolean r5 = r15.a(r6, r8)
            if (r5 == 0) goto L_0x00dd
            org.greenrobot.eventbus.ThreadMode r9 = r7.threadMode()
            java.util.List<i.b.a.o> r11 = r15.f9775a
            i.b.a.o r12 = new i.b.a.o
            int r10 = r7.priority()
            boolean r13 = r7.sticky()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00dd
        L_0x005b:
            boolean r7 = r14.f9773b
            if (r7 == 0) goto L_0x00dd
            java.lang.Class<i.b.a.m> r7 = i.b.a.m.class
            boolean r7 = r6.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x0068
            goto L_0x00dd
        L_0x0068:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            i.b.a.e r0 = new i.b.a.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "@Subscribe method "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r15 = "must have exactly 1 parameter but has "
            r1.append(r15)
            int r15 = r5.length
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x00a6:
            boolean r5 = r14.f9773b
            if (r5 == 0) goto L_0x00dd
            java.lang.Class<i.b.a.m> r5 = i.b.a.m.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x00b3
            goto L_0x00dd
        L_0x00b3:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            i.b.a.e r0 = new i.b.a.e
            java.lang.String r1 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            java.lang.String r15 = e.a.a.a.a.a(r15, r1)
            r0.<init>(r15)
            throw r0
        L_0x00dd:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00e1:
            return
        L_0x00e2:
            r0 = move-exception
            java.lang.String r1 = "Could not inspect methods of "
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            java.lang.Class<?> r15 = r15.f9779e
            java.lang.String r15 = r15.getName()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            boolean r1 = r14.f9774c
            if (r1 == 0) goto L_0x0101
            java.lang.String r1 = ". Please consider using EventBus annotation processor to avoid reflection."
            java.lang.String r15 = e.a.a.a.a.a(r15, r1)
            goto L_0x0107
        L_0x0101:
            java.lang.String r1 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
            java.lang.String r15 = e.a.a.a.a.a(r15, r1)
        L_0x0107:
            i.b.a.e r1 = new i.b.a.e
            r1.<init>(r15, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.b.a.p.a(i.b.a.p$a):void");
    }
}
