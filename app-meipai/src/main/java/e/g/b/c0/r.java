package e.g.b.c0;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedTreeMap */
public final class r<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: h reason: collision with root package name */
    public static final Comparator<Comparable> f8499h = new a();

    /* renamed from: a reason: collision with root package name */
    public Comparator<? super K> f8500a;

    /* renamed from: b reason: collision with root package name */
    public e<K, V> f8501b;

    /* renamed from: c reason: collision with root package name */
    public int f8502c = 0;

    /* renamed from: d reason: collision with root package name */
    public int f8503d = 0;

    /* renamed from: e reason: collision with root package name */
    public final e<K, V> f8504e = new e<>();

    /* renamed from: f reason: collision with root package name */
    public b f8505f;

    /* renamed from: g reason: collision with root package name */
    public c f8506g;

    /* compiled from: LinkedTreeMap */
    public static class a implements Comparator<Comparable> {
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    /* compiled from: LinkedTreeMap */
    public class b extends AbstractSet<Entry<K, V>> {

        /* compiled from: LinkedTreeMap */
        public class a extends d<Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            public Object next() {
                return a();
            }
        }

        public b() {
        }

        public void clear() {
            r.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && r.this.a((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            e a2 = r.this.a((Entry) obj);
            if (a2 == null) {
                return false;
            }
            r.this.b(a2, true);
            return true;
        }

        public int size() {
            return r.this.f8502c;
        }
    }

    /* compiled from: LinkedTreeMap */
    public final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap */
        public class a extends d<K> {
            public a(c cVar) {
                super();
            }

            public K next() {
                return a().f8518f;
            }
        }

        public c() {
        }

        public void clear() {
            r.this.clear();
        }

        public boolean contains(Object obj) {
            return r.this.a(obj) != null;
        }

        public Iterator<K> iterator() {
            return new a(this);
        }

        public boolean remove(Object obj) {
            r rVar = r.this;
            e a2 = rVar.a(obj);
            if (a2 != null) {
                rVar.b(a2, true);
            }
            if (a2 != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return r.this.f8502c;
        }
    }

    /* compiled from: LinkedTreeMap */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a reason: collision with root package name */
        public e<K, V> f8509a;

        /* renamed from: b reason: collision with root package name */
        public e<K, V> f8510b = null;

        /* renamed from: c reason: collision with root package name */
        public int f8511c;

        public d() {
            r rVar = r.this;
            this.f8509a = rVar.f8504e.f8516d;
            this.f8511c = rVar.f8503d;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f8509a;
            r rVar = r.this;
            if (eVar == rVar.f8504e) {
                throw new NoSuchElementException();
            } else if (rVar.f8503d == this.f8511c) {
                this.f8509a = eVar.f8516d;
                this.f8510b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f8509a != r.this.f8504e;
        }

        public final void remove() {
            e<K, V> eVar = this.f8510b;
            if (eVar != null) {
                r.this.b(eVar, true);
                this.f8510b = null;
                this.f8511c = r.this.f8503d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: LinkedTreeMap */
    public static final class e<K, V> implements Entry<K, V> {

        /* renamed from: a reason: collision with root package name */
        public e<K, V> f8513a;

        /* renamed from: b reason: collision with root package name */
        public e<K, V> f8514b;

        /* renamed from: c reason: collision with root package name */
        public e<K, V> f8515c;

        /* renamed from: d reason: collision with root package name */
        public e<K, V> f8516d;

        /* renamed from: e reason: collision with root package name */
        public e<K, V> f8517e;

        /* renamed from: f reason: collision with root package name */
        public final K f8518f;

        /* renamed from: g reason: collision with root package name */
        public V f8519g;

        /* renamed from: h reason: collision with root package name */
        public int f8520h;

        public e() {
            this.f8518f = null;
            this.f8517e = this;
            this.f8516d = this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            K k = this.f8518f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f8519g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f8518f;
        }

        public V getValue() {
            return this.f8519g;
        }

        public int hashCode() {
            K k = this.f8518f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f8519g;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            V v2 = this.f8519g;
            this.f8519g = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8518f);
            sb.append("=");
            sb.append(this.f8519g);
            return sb.toString();
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f8513a = eVar;
            this.f8518f = k;
            this.f8520h = 1;
            this.f8516d = eVar2;
            this.f8517e = eVar3;
            eVar3.f8516d = this;
            eVar2.f8517e = this;
        }
    }

    static {
        Class<r> cls = r.class;
    }

    public r() {
        Comparator<Comparable> comparator = f8499h;
        if (comparator == null) {
            comparator = f8499h;
        }
        this.f8500a = comparator;
    }

    public e<K, V> a(K k, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f8500a;
        e<K, V> eVar2 = this.f8501b;
        if (eVar2 != null) {
            Comparable comparable = comparator == f8499h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f8518f);
                } else {
                    i2 = comparator.compare(k, eVar2.f8518f);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f8514b : eVar2.f8515c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.f8504e;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.f8517e);
            if (i2 < 0) {
                eVar2.f8514b = eVar;
            } else {
                eVar2.f8515c = eVar;
            }
            a(eVar2, true);
        } else if (comparator != f8499h || (k instanceof Comparable)) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.f8517e);
            this.f8501b = eVar;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(k.getClass().getName());
            sb.append(" is not Comparable");
            throw new ClassCastException(sb.toString());
        }
        this.f8502c++;
        this.f8503d++;
        return eVar;
    }

    public void b(e<K, V> eVar, boolean z) {
        e<K, V> eVar2;
        int i2;
        e<K, V> eVar3;
        if (z) {
            e<K, V> eVar4 = eVar.f8517e;
            eVar4.f8516d = eVar.f8516d;
            eVar.f8516d.f8517e = eVar4;
        }
        e<K, V> eVar5 = eVar.f8514b;
        e<K, V> eVar6 = eVar.f8515c;
        e<K, V> eVar7 = eVar.f8513a;
        int i3 = 0;
        if (eVar5 == null || eVar6 == null) {
            if (eVar5 != null) {
                a(eVar, eVar5);
                eVar.f8514b = null;
            } else if (eVar6 != null) {
                a(eVar, eVar6);
                eVar.f8515c = null;
            } else {
                a(eVar, null);
            }
            a(eVar7, false);
            this.f8502c--;
            this.f8503d++;
            return;
        }
        if (eVar5.f8520h > eVar6.f8520h) {
            e<K, V> eVar8 = eVar5.f8515c;
            while (true) {
                e<K, V> eVar9 = eVar8;
                eVar2 = eVar5;
                eVar5 = eVar9;
                if (eVar5 == null) {
                    break;
                }
                eVar8 = eVar5.f8515c;
            }
        } else {
            e<K, V> eVar10 = eVar6.f8514b;
            while (true) {
                e<K, V> eVar11 = eVar6;
                eVar6 = eVar10;
                eVar3 = eVar11;
                if (eVar6 == null) {
                    break;
                }
                eVar10 = eVar6.f8514b;
            }
            eVar2 = eVar3;
        }
        b(eVar2, false);
        e<K, V> eVar12 = eVar.f8514b;
        if (eVar12 != null) {
            i2 = eVar12.f8520h;
            eVar2.f8514b = eVar12;
            eVar12.f8513a = eVar2;
            eVar.f8514b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar13 = eVar.f8515c;
        if (eVar13 != null) {
            i3 = eVar13.f8520h;
            eVar2.f8515c = eVar13;
            eVar13.f8513a = eVar2;
            eVar.f8515c = null;
        }
        eVar2.f8520h = Math.max(i2, i3) + 1;
        a(eVar, eVar2);
    }

    public void clear() {
        this.f8501b = null;
        this.f8502c = 0;
        this.f8503d++;
        e<K, V> eVar = this.f8504e;
        eVar.f8517e = eVar;
        eVar.f8516d = eVar;
    }

    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        b bVar = this.f8505f;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b<>();
        this.f8505f = bVar2;
        return bVar2;
    }

    public V get(Object obj) {
        e a2 = a(obj);
        if (a2 != null) {
            return a2.f8519g;
        }
        return null;
    }

    public Set<K> keySet() {
        c cVar = this.f8506g;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c<>();
        this.f8506g = cVar2;
        return cVar2;
    }

    public V put(K k, V v) {
        if (k != null) {
            e a2 = a(k, true);
            V v2 = a2.f8519g;
            a2.f8519g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        e a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        if (a2 != null) {
            return a2.f8519g;
        }
        return null;
    }

    public int size() {
        return this.f8502c;
    }

    public e<K, V> a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return a((K) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.g.b.c0.r.e<K, V> a(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            e.g.b.c0.r$e r0 = r4.a(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            V r3 = r0.f8519g
            java.lang.Object r5 = r5.getValue()
            if (r3 == r5) goto L_0x001f
            if (r3 == 0) goto L_0x001d
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r1
        L_0x0020:
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.b.c0.r.a(java.util.Map$Entry):e.g.b.c0.r$e");
    }

    public final void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f8513a;
        eVar.f8513a = null;
        if (eVar2 != null) {
            eVar2.f8513a = eVar3;
        }
        if (eVar3 == null) {
            this.f8501b = eVar2;
        } else if (eVar3.f8514b == eVar) {
            eVar3.f8514b = eVar2;
        } else {
            eVar3.f8515c = eVar2;
        }
    }

    public final void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f8514b;
            e<K, V> eVar3 = eVar.f8515c;
            int i2 = 0;
            int i3 = eVar2 != null ? eVar2.f8520h : 0;
            int i4 = eVar3 != null ? eVar3.f8520h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                e<K, V> eVar4 = eVar3.f8514b;
                e<K, V> eVar5 = eVar3.f8515c;
                int i6 = eVar5 != null ? eVar5.f8520h : 0;
                if (eVar4 != null) {
                    i2 = eVar4.f8520h;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    a(eVar);
                } else {
                    b(eVar3);
                    a(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                e<K, V> eVar6 = eVar2.f8514b;
                e<K, V> eVar7 = eVar2.f8515c;
                int i8 = eVar7 != null ? eVar7.f8520h : 0;
                if (eVar6 != null) {
                    i2 = eVar6.f8520h;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    b(eVar);
                } else {
                    a(eVar2);
                    b(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                eVar.f8520h = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f8520h = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f8513a;
        }
    }

    public final void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8514b;
        e<K, V> eVar3 = eVar.f8515c;
        e<K, V> eVar4 = eVar2.f8514b;
        e<K, V> eVar5 = eVar2.f8515c;
        eVar.f8514b = eVar5;
        if (eVar5 != null) {
            eVar5.f8513a = eVar;
        }
        a(eVar, eVar2);
        eVar2.f8515c = eVar;
        eVar.f8513a = eVar2;
        int i2 = 0;
        int max = Math.max(eVar3 != null ? eVar3.f8520h : 0, eVar5 != null ? eVar5.f8520h : 0) + 1;
        eVar.f8520h = max;
        if (eVar4 != null) {
            i2 = eVar4.f8520h;
        }
        eVar2.f8520h = Math.max(max, i2) + 1;
    }

    public final void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f8514b;
        e<K, V> eVar3 = eVar.f8515c;
        e<K, V> eVar4 = eVar3.f8514b;
        e<K, V> eVar5 = eVar3.f8515c;
        eVar.f8515c = eVar4;
        if (eVar4 != null) {
            eVar4.f8513a = eVar;
        }
        a(eVar, eVar3);
        eVar3.f8514b = eVar;
        eVar.f8513a = eVar3;
        int i2 = 0;
        int max = Math.max(eVar2 != null ? eVar2.f8520h : 0, eVar4 != null ? eVar4.f8520h : 0) + 1;
        eVar.f8520h = max;
        if (eVar5 != null) {
            i2 = eVar5.f8520h;
        }
        eVar3.f8520h = Math.max(max, i2) + 1;
    }
}
