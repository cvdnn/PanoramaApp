package i.b.b.h;

import i.b.b.i.c;
import i.b.b.i.c.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: IdentityScopeLong */
public class b<T> implements a<Long, T> {

    /* renamed from: a reason: collision with root package name */
    public final c<Reference<T>> f9805a = new c<>();

    /* renamed from: b reason: collision with root package name */
    public final ReentrantLock f9806b = new ReentrantLock();

    public Object a(Object obj) {
        Reference reference = (Reference) this.f9805a.a(((Long) obj).longValue());
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public Object get(Object obj) {
        return a(((Long) obj).longValue());
    }

    public void lock() {
        this.f9806b.lock();
    }

    public void put(Object obj, Object obj2) {
        a(((Long) obj).longValue(), (T) obj2);
    }

    public void remove(Object obj) {
        Long l = (Long) obj;
        this.f9806b.lock();
        try {
            c<Reference<T>> cVar = this.f9805a;
            long longValue = l.longValue();
            int i2 = ((((int) (longValue >>> 32)) ^ ((int) longValue)) & Integer.MAX_VALUE) % cVar.f9826b;
            a<T> aVar = cVar.f9825a[i2];
            a<T> aVar2 = null;
            while (true) {
                if (aVar == null) {
                    break;
                }
                a<T> aVar3 = aVar.f9831c;
                if (aVar.f9829a == longValue) {
                    if (aVar2 == null) {
                        cVar.f9825a[i2] = aVar3;
                    } else {
                        aVar2.f9831c = aVar3;
                    }
                    cVar.f9828d--;
                } else {
                    aVar2 = aVar;
                    aVar = aVar3;
                }
            }
        } finally {
            this.f9806b.unlock();
        }
    }

    public void unlock() {
        this.f9806b.unlock();
    }

    public void a(Object obj, Object obj2) {
        this.f9805a.a(((Long) obj).longValue(), new WeakReference(obj2));
    }

    public T a(long j2) {
        this.f9806b.lock();
        try {
            Reference reference = (Reference) this.f9805a.a(j2);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f9806b.unlock();
        }
    }

    public void a(long j2, T t) {
        this.f9806b.lock();
        try {
            this.f9805a.a(j2, new WeakReference(t));
        } finally {
            this.f9806b.unlock();
        }
    }

    public void a(int i2) {
        c<Reference<T>> cVar = this.f9805a;
        if (cVar != null) {
            cVar.a((i2 * 5) / 3);
            return;
        }
        throw null;
    }
}
