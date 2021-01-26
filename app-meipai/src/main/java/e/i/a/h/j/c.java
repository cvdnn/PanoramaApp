package e.i.a.h.j;

import e.a.a.a.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* compiled from: FileLock */
public class c {

    /* renamed from: c reason: collision with root package name */
    public static final long f8861c = TimeUnit.MILLISECONDS.toNanos(100);

    /* renamed from: a reason: collision with root package name */
    public final Map<String, AtomicInteger> f8862a;

    /* renamed from: b reason: collision with root package name */
    public final Map<String, Thread> f8863b;

    public c() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.f8862a = hashMap;
        this.f8863b = hashMap2;
    }

    public void a(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.f8862a) {
            atomicInteger = (AtomicInteger) this.f8862a.get(str);
        }
        if (atomicInteger != null && atomicInteger.decrementAndGet() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("decreaseLock decrease lock-count to 0 ");
            sb.append(str);
            e.i.a.h.c.a("FileLock", sb.toString());
            synchronized (this.f8863b) {
                thread = (Thread) this.f8863b.get(str);
                if (thread != null) {
                    this.f8863b.remove(str);
                }
            }
            if (thread != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("decreaseLock ");
                sb2.append(str);
                sb2.append(" unpark locked thread ");
                sb2.append(atomicInteger);
                sb2.toString();
                LockSupport.unpark(thread);
            }
            synchronized (this.f8862a) {
                this.f8862a.remove(str);
            }
        }
    }

    public void b(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f8862a) {
            atomicInteger = (AtomicInteger) this.f8862a.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.f8862a) {
                this.f8862a.put(str, atomicInteger);
            }
        }
        StringBuilder a2 = a.a("increaseLock increase lock-count to ");
        a2.append(atomicInteger.incrementAndGet());
        a2.append(str);
        e.i.a.h.c.a("FileLock", a2.toString());
    }

    public void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f8862a) {
            atomicInteger = (AtomicInteger) this.f8862a.get(str);
        }
        if (atomicInteger != null && atomicInteger.get() > 0) {
            synchronized (this.f8863b) {
                this.f8863b.put(str, Thread.currentThread());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("waitForRelease start ");
            sb.append(str);
            e.i.a.h.c.a("FileLock", sb.toString());
            while (true) {
                if (!(atomicInteger.get() <= 0)) {
                    LockSupport.park(Long.valueOf(f8861c));
                } else {
                    return;
                }
            }
        }
    }
}
