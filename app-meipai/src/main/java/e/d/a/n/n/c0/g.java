package e.d.a.n.n.c0;

import e.d.a.n.n.c0.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap */
public class g<K extends l, V> {

    /* renamed from: a reason: collision with root package name */
    public final a<K, V> f7297a = new a<>(null);

    /* renamed from: b reason: collision with root package name */
    public final Map<K, a<K, V>> f7298b = new HashMap();

    /* compiled from: GroupedLinkedMap */
    public static class a<K, V> {

        /* renamed from: a reason: collision with root package name */
        public final K f7299a;

        /* renamed from: b reason: collision with root package name */
        public List<V> f7300b;

        /* renamed from: c reason: collision with root package name */
        public a<K, V> f7301c;

        /* renamed from: d reason: collision with root package name */
        public a<K, V> f7302d;

        public a() {
            this(null);
        }

        public V a() {
            List<V> list = this.f7300b;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.f7300b.remove(size - 1);
            }
            return null;
        }

        public a(K k) {
            this.f7302d = this;
            this.f7301c = this;
            this.f7299a = k;
        }
    }

    public void a(K k, V v) {
        a<K, V> aVar = (a) this.f7298b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            a<K, V> aVar2 = aVar.f7302d;
            aVar2.f7301c = aVar.f7301c;
            aVar.f7301c.f7302d = aVar2;
            a<K, V> aVar3 = this.f7297a;
            aVar.f7302d = aVar3.f7302d;
            aVar.f7301c = aVar3;
            aVar3.f7302d = aVar;
            aVar.f7302d.f7301c = aVar;
            this.f7298b.put(k, aVar);
        } else {
            k.a();
        }
        if (aVar.f7300b == null) {
            aVar.f7300b = new ArrayList();
        }
        aVar.f7300b.add(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f7297a.f7301c; !aVar.equals(this.f7297a); aVar = aVar.f7301c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f7299a);
            sb.append(':');
            List<V> list = aVar.f7300b;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = (a) this.f7298b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f7298b.put(k, aVar);
        } else {
            k.a();
        }
        a<K, V> aVar2 = aVar.f7302d;
        aVar2.f7301c = aVar.f7301c;
        aVar.f7301c.f7302d = aVar2;
        a<K, V> aVar3 = this.f7297a;
        aVar.f7302d = aVar3;
        a<K, V> aVar4 = aVar3.f7301c;
        aVar.f7301c = aVar4;
        aVar4.f7302d = aVar;
        aVar.f7302d.f7301c = aVar;
        return aVar.a();
    }

    public V a() {
        for (a<K, V> aVar = this.f7297a.f7302d; !aVar.equals(this.f7297a); aVar = aVar.f7302d) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            a<K, V> aVar2 = aVar.f7302d;
            aVar2.f7301c = aVar.f7301c;
            aVar.f7301c.f7302d = aVar2;
            this.f7298b.remove(aVar.f7299a);
            ((l) aVar.f7299a).a();
        }
        return null;
    }
}
