package d.c.a.b;

import d.c.a.b.b.c;
import java.util.HashMap;

/* compiled from: FastSafeIterableMap */
public class a<K, V> extends b<K, V> {

    /* renamed from: e reason: collision with root package name */
    public HashMap<K, c<K, V>> f4527e = new HashMap<>();

    public c<K, V> a(K k) {
        return (c) this.f4527e.get(k);
    }

    public V b(K k, V v) {
        c cVar = (c) this.f4527e.get(k);
        if (cVar != null) {
            return cVar.f4533b;
        }
        this.f4527e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f4527e.containsKey(k);
    }

    public V remove(K k) {
        V remove = super.remove(k);
        this.f4527e.remove(k);
        return remove;
    }
}
