package e.d.a.t;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class g<T, Y> {

    /* renamed from: a reason: collision with root package name */
    public final Map<T, Y> f7914a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b reason: collision with root package name */
    public long f7915b;

    /* renamed from: c reason: collision with root package name */
    public long f7916c;

    public g(long j2) {
        this.f7915b = j2;
    }

    public synchronized long a() {
        return this.f7915b;
    }

    public void a(T t, Y y) {
    }

    public int b(Y y) {
        return 1;
    }

    public synchronized Y b(T t, Y y) {
        long b2 = (long) b(y);
        if (b2 >= this.f7915b) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f7916c += b2;
        }
        Y put = this.f7914a.put(t, y);
        if (put != null) {
            this.f7916c -= (long) b(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        a(this.f7915b);
        return put;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f7914a.remove(t);
        if (remove != null) {
            this.f7916c -= (long) b(remove);
        }
        return remove;
    }

    public synchronized Y a(T t) {
        return this.f7914a.get(t);
    }

    public synchronized void a(long j2) {
        while (this.f7916c > j2) {
            Iterator it = this.f7914a.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.f7916c -= (long) b(value);
            Object key = entry.getKey();
            it.remove();
            a(key, value);
        }
    }
}
