package e.d.a.t;

import d.e.a;
import d.e.h;

/* compiled from: CachedHashCodeArrayMap */
public final class b<K, V> extends a<K, V> {

    /* renamed from: i reason: collision with root package name */
    public int f7904i;

    public V a(int i2, V v) {
        this.f7904i = 0;
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f4601b;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public void clear() {
        this.f7904i = 0;
        super.clear();
    }

    public V d(int i2) {
        this.f7904i = 0;
        return super.d(i2);
    }

    public int hashCode() {
        if (this.f7904i == 0) {
            this.f7904i = super.hashCode();
        }
        return this.f7904i;
    }

    public V put(K k, V v) {
        this.f7904i = 0;
        return super.put(k, v);
    }

    public void a(h<? extends K, ? extends V> hVar) {
        this.f7904i = 0;
        super.a(hVar);
    }
}
