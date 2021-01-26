package e.d.a.n.n.c0;

import android.util.Log;
import e.c.f.n.n;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool */
public final class i implements b {

    /* renamed from: a reason: collision with root package name */
    public final g<a, Object> f7303a = new g<>();

    /* renamed from: b reason: collision with root package name */
    public final b f7304b = new b();

    /* renamed from: c reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f7305c = new HashMap();

    /* renamed from: d reason: collision with root package name */
    public final Map<Class<?>, a<?>> f7306d = new HashMap();

    /* renamed from: e reason: collision with root package name */
    public final int f7307e;

    /* renamed from: f reason: collision with root package name */
    public int f7308f;

    /* compiled from: LruArrayPool */
    public static final class a implements l {

        /* renamed from: a reason: collision with root package name */
        public final b f7309a;

        /* renamed from: b reason: collision with root package name */
        public int f7310b;

        /* renamed from: c reason: collision with root package name */
        public Class<?> f7311c;

        public a(b bVar) {
            this.f7309a = bVar;
        }

        public void a() {
            this.f7309a.a(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f7310b == aVar.f7310b && this.f7311c == aVar.f7311c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f7310b * 31;
            Class<?> cls = this.f7311c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("Key{size=");
            a2.append(this.f7310b);
            a2.append("array=");
            a2.append(this.f7311c);
            a2.append('}');
            return a2.toString();
        }
    }

    /* compiled from: LruArrayPool */
    public static final class b extends c<a> {
        public a a(int i2, Class<?> cls) {
            a aVar = (a) b();
            aVar.f7310b = i2;
            aVar.f7311c = cls;
            return aVar;
        }

        public l a() {
            return new a(this);
        }
    }

    public i(int i2) {
        this.f7307e = i2;
    }

    public synchronized <T> void a(T t) {
        Class cls = t.getClass();
        a a2 = a(cls);
        int a3 = a2.a(t);
        int a4 = a2.a() * a3;
        int i2 = 1;
        if (a4 <= this.f7307e / 2) {
            a a5 = this.f7304b.a(a3, cls);
            this.f7303a.a(a5, t);
            NavigableMap b2 = b(cls);
            Integer num = (Integer) b2.get(Integer.valueOf(a5.f7310b));
            Integer valueOf = Integer.valueOf(a5.f7310b);
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            b2.put(valueOf, Integer.valueOf(i2));
            this.f7308f += a4;
            b(this.f7307e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T b(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.b(r7)     // Catch:{ all -> 0x004d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch:{ all -> 0x004d }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x004d }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002c
            int r3 = r5.f7308f     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x0020
            int r4 = r5.f7307e     // Catch:{ all -> 0x004d }
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = r2
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r3 != 0) goto L_0x002d
            int r3 = r0.intValue()     // Catch:{ all -> 0x004d }
            int r4 = r6 * 8
            if (r3 > r4) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            if (r1 == 0) goto L_0x003a
            e.d.a.n.n.c0.i$b r6 = r5.f7304b     // Catch:{ all -> 0x004d }
            int r0 = r0.intValue()     // Catch:{ all -> 0x004d }
            e.d.a.n.n.c0.i$a r6 = r6.a(r0, r7)     // Catch:{ all -> 0x004d }
            goto L_0x0047
        L_0x003a:
            e.d.a.n.n.c0.i$b r0 = r5.f7304b     // Catch:{ all -> 0x004d }
            e.d.a.n.n.c0.l r0 = r0.b()     // Catch:{ all -> 0x004d }
            e.d.a.n.n.c0.i$a r0 = (e.d.a.n.n.c0.i.a) r0     // Catch:{ all -> 0x004d }
            r0.f7310b = r6     // Catch:{ all -> 0x004d }
            r0.f7311c = r7     // Catch:{ all -> 0x004d }
            r6 = r0
        L_0x0047:
            java.lang.Object r6 = r5.a(r6, r7)     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return r6
        L_0x004d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.n.c0.i.b(int, java.lang.Class):java.lang.Object");
    }

    public final void c(int i2, Class<?> cls) {
        NavigableMap b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i2));
        if (num == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(i2);
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num.intValue() == 1) {
            b2.remove(Integer.valueOf(i2));
        } else {
            b2.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void b(int i2) {
        while (this.f7308f > i2) {
            Object a2 = this.f7303a.a();
            n.a(a2, "Argument must not be null");
            a a3 = a(a2.getClass());
            this.f7308f -= a3.a() * a3.a(a2);
            c(a3.a(a2), a2.getClass());
            if (Log.isLoggable(a3.b(), 2)) {
                String b2 = a3.b();
                StringBuilder a4 = e.a.a.a.a.a("evicted: ");
                a4.append(a3.a(a2));
                Log.v(b2, a4.toString());
            }
        }
    }

    public synchronized <T> T a(int i2, Class<T> cls) {
        a aVar;
        aVar = (a) this.f7304b.b();
        aVar.f7310b = i2;
        aVar.f7311c = cls;
        return a(aVar, cls);
    }

    public final NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f7305c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f7305c.put(cls, treeMap);
        return treeMap;
    }

    public final <T> T a(a aVar, Class<T> cls) {
        a a2 = a(cls);
        T a3 = this.f7303a.a(aVar);
        if (a3 != null) {
            this.f7308f -= a2.a() * a2.a(a3);
            c(a2.a(a3), cls);
        }
        if (a3 != null) {
            return a3;
        }
        if (Log.isLoggable(a2.b(), 2)) {
            String b2 = a2.b();
            StringBuilder a4 = e.a.a.a.a.a("Allocated ");
            a4.append(aVar.f7310b);
            a4.append(" bytes");
            Log.v(b2, a4.toString());
        }
        return a2.newArray(aVar.f7310b);
    }

    public synchronized void a() {
        b(0);
    }

    public synchronized void a(int i2) {
        if (i2 >= 40) {
            try {
                a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i2 >= 20 || i2 == 15) {
            b(this.f7307e / 2);
        }
    }

    public final <T> a<T> a(Class<T> cls) {
        a<T> aVar = (a) this.f7306d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h<>();
            } else if (cls.equals(byte[].class)) {
                aVar = new f<>();
            } else {
                StringBuilder a2 = e.a.a.a.a.a("No array pool found for: ");
                a2.append(cls.getSimpleName());
                throw new IllegalArgumentException(a2.toString());
            }
            this.f7306d.put(cls, aVar);
        }
        return aVar;
    }
}
