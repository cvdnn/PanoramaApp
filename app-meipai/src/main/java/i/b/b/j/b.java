package i.b.b.j;

import i.b.b.j.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: AbstractQueryData */
public abstract class b<T, Q extends a<T>> {

    /* renamed from: a reason: collision with root package name */
    public final String f9844a;

    /* renamed from: b reason: collision with root package name */
    public final i.b.b.a<T, ?> f9845b;

    /* renamed from: c reason: collision with root package name */
    public final String[] f9846c;

    /* renamed from: d reason: collision with root package name */
    public final Map<Long, WeakReference<Q>> f9847d = new HashMap();

    public b(i.b.b.a<T, ?> aVar, String str, String[] strArr) {
        this.f9845b = aVar;
        this.f9844a = str;
        this.f9846c = strArr;
    }

    public Q a() {
        Q q;
        long id = Thread.currentThread().getId();
        synchronized (this.f9847d) {
            WeakReference weakReference = (WeakReference) this.f9847d.get(Long.valueOf(id));
            q = weakReference != null ? (a) weakReference.get() : null;
            if (q == null) {
                b();
                i.b.b.j.e.b bVar = (i.b.b.j.e.b) this;
                q = new e(bVar, bVar.f9845b, bVar.f9844a, (String[]) bVar.f9846c.clone(), bVar.f9854e, bVar.f9855f, null);
                this.f9847d.put(Long.valueOf(id), new WeakReference(q));
            } else {
                System.arraycopy(this.f9846c, 0, q.f9842d, 0, this.f9846c.length);
            }
        }
        return q;
    }

    public void b() {
        synchronized (this.f9847d) {
            Iterator it = this.f9847d.entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) ((Entry) it.next()).getValue()).get() == null) {
                    it.remove();
                }
            }
        }
    }
}
