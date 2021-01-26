package d.g.d;

import d.e.h;
import d.h.j.c;
import d.h.j.d;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: DirectedAcyclicGraph */
public final class a<T> {

    /* renamed from: a reason: collision with root package name */
    public final c<ArrayList<T>> f4763a = new d(10);

    /* renamed from: b reason: collision with root package name */
    public final h<T, ArrayList<T>> f4764b = new h<>();

    /* renamed from: c reason: collision with root package name */
    public final ArrayList<T> f4765c = new ArrayList<>();

    /* renamed from: d reason: collision with root package name */
    public final HashSet<T> f4766d = new HashSet<>();

    public void a(T t) {
        if (!(this.f4764b.a((Object) t) >= 0)) {
            this.f4764b.put(t, null);
        }
    }

    public final void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = (ArrayList) this.f4764b.getOrDefault(t, null);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a(arrayList2.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
