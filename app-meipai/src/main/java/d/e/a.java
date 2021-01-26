package d.e;

import d.e.g.b;
import d.e.g.c;
import d.e.g.e;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class a<K, V> extends h<K, V> implements Map<K, V> {

    /* renamed from: h reason: collision with root package name */
    public g<K, V> f4553h;

    /* renamed from: d.e.a$a reason: collision with other inner class name */
    /* compiled from: ArrayMap */
    public class C0032a extends g<K, V> {
        public C0032a() {
        }

        public Object a(int i2, int i3) {
            return a.this.f4601b[(i2 << 1) + i3];
        }

        public int b(Object obj) {
            return a.this.b(obj);
        }

        public int c() {
            return a.this.f4602c;
        }

        public int a(Object obj) {
            return a.this.a(obj);
        }

        public Map<K, V> b() {
            return a.this;
        }

        public void a(K k, V v) {
            a.this.put(k, v);
        }

        public V a(int i2, V v) {
            return a.this.a(i2, v);
        }

        public void a(int i2) {
            a.this.d(i2);
        }

        public void a() {
            a.this.clear();
        }
    }

    public a() {
    }

    public final g<K, V> b() {
        if (this.f4553h == null) {
            this.f4553h = new C0032a();
        }
        return this.f4553h;
    }

    public Set<Entry<K, V>> entrySet() {
        g b2 = b();
        if (b2.f4581a == null) {
            b2.f4581a = new b<>();
        }
        return b2.f4581a;
    }

    public Set<K> keySet() {
        g b2 = b();
        if (b2.f4582b == null) {
            b2.f4582b = new c<>();
        }
        return b2.f4582b;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f4602c);
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        g b2 = b();
        if (b2.f4583c == null) {
            b2.f4583c = new e<>();
        }
        return b2.f4583c;
    }

    public a(int i2) {
        super(i2);
    }

    public a(h hVar) {
        if (hVar != null) {
            a(hVar);
        }
    }
}
