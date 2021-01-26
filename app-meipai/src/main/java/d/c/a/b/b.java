package d.c.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Entry<K, V>> {

    /* renamed from: a reason: collision with root package name */
    public c<K, V> f4528a;

    /* renamed from: b reason: collision with root package name */
    public c<K, V> f4529b;

    /* renamed from: c reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f4530c = new WeakHashMap<>();

    /* renamed from: d reason: collision with root package name */
    public int f4531d = 0;

    /* compiled from: SafeIterableMap */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public c<K, V> b(c<K, V> cVar) {
            return cVar.f4535d;
        }

        public c<K, V> c(c<K, V> cVar) {
            return cVar.f4534c;
        }
    }

    /* renamed from: d.c.a.b.b$b reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    public static class C0031b<K, V> extends e<K, V> {
        public C0031b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public c<K, V> b(c<K, V> cVar) {
            return cVar.f4534c;
        }

        public c<K, V> c(c<K, V> cVar) {
            return cVar.f4535d;
        }
    }

    /* compiled from: SafeIterableMap */
    public static class c<K, V> implements Entry<K, V> {

        /* renamed from: a reason: collision with root package name */
        public final K f4532a;

        /* renamed from: b reason: collision with root package name */
        public final V f4533b;

        /* renamed from: c reason: collision with root package name */
        public c<K, V> f4534c;

        /* renamed from: d reason: collision with root package name */
        public c<K, V> f4535d;

        public c(K k, V v) {
            this.f4532a = k;
            this.f4533b = v;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f4532a.equals(cVar.f4532a) || !this.f4533b.equals(cVar.f4533b)) {
                z = false;
            }
            return z;
        }

        public K getKey() {
            return this.f4532a;
        }

        public V getValue() {
            return this.f4533b;
        }

        public int hashCode() {
            return this.f4532a.hashCode() ^ this.f4533b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4532a);
            sb.append("=");
            sb.append(this.f4533b);
            return sb.toString();
        }
    }

    /* compiled from: SafeIterableMap */
    public class d implements Iterator<Entry<K, V>>, f<K, V> {

        /* renamed from: a reason: collision with root package name */
        public c<K, V> f4536a;

        /* renamed from: b reason: collision with root package name */
        public boolean f4537b = true;

        public d() {
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4536a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f4535d;
                this.f4536a = cVar3;
                this.f4537b = cVar3 == null;
            }
        }

        public boolean hasNext() {
            boolean z = true;
            if (this.f4537b) {
                if (b.this.f4528a == null) {
                    z = false;
                }
                return z;
            }
            c<K, V> cVar = this.f4536a;
            if (cVar == null || cVar.f4534c == null) {
                z = false;
            }
            return z;
        }

        public Object next() {
            if (this.f4537b) {
                this.f4537b = false;
                this.f4536a = b.this.f4528a;
            } else {
                c<K, V> cVar = this.f4536a;
                this.f4536a = cVar != null ? cVar.f4534c : null;
            }
            return this.f4536a;
        }
    }

    /* compiled from: SafeIterableMap */
    public static abstract class e<K, V> implements Iterator<Entry<K, V>>, f<K, V> {

        /* renamed from: a reason: collision with root package name */
        public c<K, V> f4539a;

        /* renamed from: b reason: collision with root package name */
        public c<K, V> f4540b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f4539a = cVar2;
            this.f4540b = cVar;
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f4539a == cVar && cVar == this.f4540b) {
                this.f4540b = null;
                this.f4539a = null;
            }
            c<K, V> cVar3 = this.f4539a;
            if (cVar3 == cVar) {
                this.f4539a = b(cVar3);
            }
            c<K, V> cVar4 = this.f4540b;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f4539a;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.f4540b = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f4540b != null;
        }

        public Object next() {
            c<K, V> cVar = this.f4540b;
            c<K, V> cVar2 = this.f4539a;
            this.f4540b = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f4528a;
        while (cVar != null && !cVar.f4532a.equals(k)) {
            cVar = cVar.f4534c;
        }
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((d.c.a.b.b.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof d.c.a.b.b
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            d.c.a.b.b r7 = (d.c.a.b.b) r7
            int r1 = r6.f4531d
            int r3 = r7.f4531d
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x001b:
            r3 = r1
            d.c.a.b.b$e r3 = (d.c.a.b.b.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            r4 = r7
            d.c.a.b.b$e r4 = (d.c.a.b.b.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0044
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L_0x003b
            if (r4 != 0) goto L_0x0043
        L_0x003b:
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x0053
            d.c.a.b.b$e r7 = (d.c.a.b.b.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.a.b.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Iterator it = iterator();
        int i2 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i2;
            }
            i2 += ((Entry) eVar.next()).hashCode();
        }
    }

    public Iterator<Entry<K, V>> iterator() {
        a aVar = new a(this.f4528a, this.f4529b);
        this.f4530c.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    public V remove(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f4531d--;
        if (!this.f4530c.isEmpty()) {
            for (f a3 : this.f4530c.keySet()) {
                a3.a(a2);
            }
        }
        c<K, V> cVar = a2.f4535d;
        if (cVar != null) {
            cVar.f4534c = a2.f4534c;
        } else {
            this.f4528a = a2.f4534c;
        }
        c<K, V> cVar2 = a2.f4534c;
        if (cVar2 != null) {
            cVar2.f4535d = a2.f4535d;
        } else {
            this.f4529b = a2.f4535d;
        }
        a2.f4534c = null;
        a2.f4535d = null;
        return a2.f4533b;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                a2.append(((Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    a2.append(", ");
                }
            } else {
                a2.append("]");
                return a2.toString();
            }
        }
    }

    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f4531d++;
        c<K, V> cVar2 = this.f4529b;
        if (cVar2 == null) {
            this.f4528a = cVar;
            this.f4529b = cVar;
            return cVar;
        }
        cVar2.f4534c = cVar;
        cVar.f4535d = cVar2;
        this.f4529b = cVar;
        return cVar;
    }

    public d a() {
        d dVar = new d<>();
        this.f4530c.put(dVar, Boolean.valueOf(false));
        return dVar;
    }
}
