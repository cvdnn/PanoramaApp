package g;

import g.d0.c;
import g.w.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher */
public final class l {

    /* renamed from: a reason: collision with root package name */
    public int f9519a = 64;

    /* renamed from: b reason: collision with root package name */
    public int f9520b = 5;

    /* renamed from: c reason: collision with root package name */
    public ExecutorService f9521c;

    /* renamed from: d reason: collision with root package name */
    public final Deque<a> f9522d = new ArrayDeque();

    /* renamed from: e reason: collision with root package name */
    public final Deque<a> f9523e = new ArrayDeque();

    /* renamed from: f reason: collision with root package name */
    public final Deque<w> f9524f = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f9521c == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
            this.f9521c = threadPoolExecutor;
        }
        return this.f9521c;
    }

    public final void b() {
        if (this.f9523e.size() < this.f9519a && !this.f9522d.isEmpty()) {
            Iterator it = this.f9522d.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (b(aVar) < this.f9520b) {
                    it.remove();
                    this.f9523e.add(aVar);
                    a().execute(aVar);
                }
                if (this.f9523e.size() >= this.f9519a) {
                    break;
                }
            }
        }
    }

    public synchronized int c() {
        return this.f9523e.size() + this.f9524f.size();
    }

    public synchronized void a(int i2) {
        if (i2 >= 1) {
            this.f9519a = i2;
            b();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("max < 1: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public synchronized void a(a aVar) {
        if (this.f9523e.size() >= this.f9519a || b(aVar) >= this.f9520b) {
            this.f9522d.add(aVar);
        } else {
            this.f9523e.add(aVar);
            a().execute(aVar);
        }
    }

    public final int b(a aVar) {
        int i2 = 0;
        for (a aVar2 : this.f9523e) {
            if (w.this.f9590d.f9595a.f9538d.equals(w.this.f9590d.f9595a.f9538d)) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized void a(w wVar) {
        this.f9524f.add(wVar);
    }

    public final <T> void a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    b();
                }
                int c2 = c();
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
    }
}
