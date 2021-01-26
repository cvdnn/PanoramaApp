package e.d.a.n.n.d0;

import e.c.f.n.n;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public final Map<String, a> f7343a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public final b f7344b = new b();

    /* compiled from: DiskCacheWriteLocker */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public final Lock f7345a = new ReentrantLock();

        /* renamed from: b reason: collision with root package name */
        public int f7346b;
    }

    /* compiled from: DiskCacheWriteLocker */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final Queue<a> f7347a = new ArrayDeque();

        public a a() {
            a aVar;
            synchronized (this.f7347a) {
                aVar = (a) this.f7347a.poll();
            }
            return aVar == null ? new a() : aVar;
        }

        public void a(a aVar) {
            synchronized (this.f7347a) {
                if (this.f7347a.size() < 10) {
                    this.f7347a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) this.f7343a.get(str);
            if (aVar == null) {
                aVar = this.f7344b.a();
                this.f7343a.put(str, aVar);
            }
            aVar.f7346b++;
        }
        aVar.f7345a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            Object obj = this.f7343a.get(str);
            n.a(obj, "Argument must not be null");
            aVar = (a) obj;
            if (aVar.f7346b >= 1) {
                int i2 = aVar.f7346b - 1;
                aVar.f7346b = i2;
                if (i2 == 0) {
                    a aVar2 = (a) this.f7343a.remove(str);
                    if (aVar2.equals(aVar)) {
                        this.f7344b.a(aVar2);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(aVar);
                        sb.append(", but actually removed: ");
                        sb.append(aVar2);
                        sb.append(", safeKey: ");
                        sb.append(str);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, safeKey: ");
                sb2.append(str);
                sb2.append(", interestedThreads: ");
                sb2.append(aVar.f7346b);
                throw new IllegalStateException(sb2.toString());
            }
        }
        aVar.f7345a.unlock();
    }
}
