package d.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections */
public abstract class g<K, V> {

    /* renamed from: a reason: collision with root package name */
    public b f4581a;

    /* renamed from: b reason: collision with root package name */
    public c f4582b;

    /* renamed from: c reason: collision with root package name */
    public e f4583c;

    /* compiled from: MapCollections */
    public final class a<T> implements Iterator<T> {

        /* renamed from: a reason: collision with root package name */
        public final int f4584a;

        /* renamed from: b reason: collision with root package name */
        public int f4585b;

        /* renamed from: c reason: collision with root package name */
        public int f4586c;

        /* renamed from: d reason: collision with root package name */
        public boolean f4587d = false;

        public a(int i2) {
            this.f4584a = i2;
            this.f4585b = g.this.c();
        }

        public boolean hasNext() {
            return this.f4586c < this.f4585b;
        }

        public T next() {
            if (hasNext()) {
                T a2 = g.this.a(this.f4586c, this.f4584a);
                this.f4586c++;
                this.f4587d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f4587d) {
                int i2 = this.f4586c - 1;
                this.f4586c = i2;
                this.f4585b--;
                this.f4587d = false;
                g.this.a(i2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    public final class b implements Set<Entry<K, V>> {
        public b() {
        }

        public boolean add(Object obj) {
            Entry entry = (Entry) obj;
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int c2 = g.this.c();
            for (Entry entry : collection) {
                g.this.a(entry.getKey(), entry.getValue());
            }
            return c2 != g.this.c();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a2 = g.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return d.a(g.this.a(a2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return g.a((Set<T>) this, obj);
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4 = 0;
            for (int c2 = g.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = g.this.a(c2, 0);
                Object a3 = g.this.a(c2, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 == null) {
                    i3 = 0;
                } else {
                    i3 = a3.hashCode();
                }
                i4 += i2 ^ i3;
            }
            return i4;
        }

        public boolean isEmpty() {
            return g.this.c() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return g.this.c();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections */
    public final class c implements Set<K> {
        public c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            return g.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            Map b2 = g.this.b();
            for (Object containsKey : collection) {
                if (!b2.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return g.a((Set<T>) this, obj);
        }

        public int hashCode() {
            int i2;
            int i3 = 0;
            for (int c2 = g.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = g.this.a(c2, 0);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                i3 += i2;
            }
            return i3;
        }

        public boolean isEmpty() {
            return g.this.c() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a2 = g.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            g.this.a(a2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            Map b2 = g.this.b();
            int size = b2.size();
            for (Object remove : collection) {
                b2.remove(remove);
            }
            return size != b2.size();
        }

        public boolean retainAll(Collection<?> collection) {
            return g.a(g.this.b(), collection);
        }

        public int size() {
            return g.this.c();
        }

        public Object[] toArray() {
            return g.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return g.this.a(tArr, 0);
        }
    }

    /* compiled from: MapCollections */
    public final class d implements Iterator<Entry<K, V>>, Entry<K, V> {

        /* renamed from: a reason: collision with root package name */
        public int f4591a;

        /* renamed from: b reason: collision with root package name */
        public int f4592b;

        /* renamed from: c reason: collision with root package name */
        public boolean f4593c = false;

        public d() {
            this.f4591a = g.this.c() - 1;
            this.f4592b = -1;
        }

        public boolean equals(Object obj) {
            if (this.f4593c) {
                boolean z = false;
                if (!(obj instanceof Entry)) {
                    return false;
                }
                Entry entry = (Entry) obj;
                if (d.a(entry.getKey(), g.this.a(this.f4592b, 0)) && d.a(entry.getValue(), g.this.a(this.f4592b, 1))) {
                    z = true;
                }
                return z;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public K getKey() {
            if (this.f4593c) {
                return g.this.a(this.f4592b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f4593c) {
                return g.this.a(this.f4592b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f4592b < this.f4591a;
        }

        public int hashCode() {
            int i2;
            if (this.f4593c) {
                int i3 = 0;
                Object a2 = g.this.a(this.f4592b, 0);
                Object a3 = g.this.a(this.f4592b, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 != null) {
                    i3 = a3.hashCode();
                }
                return i2 ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object next() {
            if (hasNext()) {
                this.f4592b++;
                this.f4593c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f4593c) {
                g.this.a(this.f4592b);
                this.f4592b--;
                this.f4591a--;
                this.f4593c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f4593c) {
                return g.this.a(this.f4592b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append("=");
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapCollections */
    public final class e implements Collection<V> {
        public e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            g.this.a();
        }

        public boolean contains(Object obj) {
            return g.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return g.this.c() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b2 = g.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            g.this.a(b2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int c2 = g.this.c();
            int i2 = 0;
            boolean z = false;
            while (i2 < c2) {
                if (collection.contains(g.this.a(i2, 1))) {
                    g.this.a(i2);
                    i2--;
                    c2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int c2 = g.this.c();
            int i2 = 0;
            boolean z = false;
            while (i2 < c2) {
                if (!collection.contains(g.this.a(i2, 1))) {
                    g.this.a(i2);
                    i2--;
                    c2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        public int size() {
            return g.this.c();
        }

        public Object[] toArray() {
            return g.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return g.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract int a(Object obj);

    public abstract Object a(int i2, int i3);

    public abstract V a(int i2, V v);

    public abstract void a();

    public abstract void a(int i2);

    public abstract void a(K k, V v);

    public abstract int b(Object obj);

    public abstract Map<K, V> b();

    public Object[] b(int i2) {
        int c2 = c();
        Object[] objArr = new Object[c2];
        for (int i3 = 0; i3 < c2; i3++) {
            objArr[i3] = a(i3, i2);
        }
        return objArr;
    }

    public abstract int c();

    public <T> T[] a(T[] tArr, int i2) {
        int c2 = c();
        if (tArr.length < c2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c2);
        }
        for (int i3 = 0; i3 < c2; i3++) {
            tArr[i3] = a(i3, i2);
        }
        if (tArr.length > c2) {
            tArr[c2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    z = false;
                }
                return z;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
