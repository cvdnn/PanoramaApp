package h;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout */
public class c extends y {

    /* renamed from: h reason: collision with root package name */
    public static final long f9638h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i reason: collision with root package name */
    public static final long f9639i = TimeUnit.MILLISECONDS.toNanos(f9638h);

    /* renamed from: j reason: collision with root package name */
    public static c f9640j;

    /* renamed from: e reason: collision with root package name */
    public boolean f9641e;

    /* renamed from: f reason: collision with root package name */
    public c f9642f;

    /* renamed from: g reason: collision with root package name */
    public long f9643g;

    /* compiled from: AsyncTimeout */
    public static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.h();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<h.c> r0 = h.c.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                h.c r1 = h.c.i()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                h.c r2 = h.c.f9640j     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                h.c.f9640j = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.h()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.a.run():void");
        }
    }

    public static synchronized void a(c cVar, long j2, boolean z) {
        Class<c> cls = c.class;
        synchronized (cls) {
            if (f9640j == null) {
                f9640j = new c();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 != 0 && z) {
                cVar.f9643g = Math.min(j2, cVar.c() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                cVar.f9643g = j2 + nanoTime;
            } else if (z) {
                cVar.f9643g = cVar.c();
            } else {
                throw new AssertionError();
            }
            long j3 = cVar.f9643g - nanoTime;
            c cVar2 = f9640j;
            while (true) {
                if (cVar2.f9642f == null) {
                    break;
                } else if (j3 < cVar2.f9642f.f9643g - nanoTime) {
                    break;
                } else {
                    cVar2 = cVar2.f9642f;
                }
            }
            cVar.f9642f = cVar2.f9642f;
            cVar2.f9642f = cVar;
            if (cVar2 == f9640j) {
                cls.notify();
            }
        }
    }

    public static c i() throws InterruptedException {
        Class<c> cls = c.class;
        c cVar = f9640j.f9642f;
        c cVar2 = null;
        if (cVar == null) {
            long nanoTime = System.nanoTime();
            cls.wait(f9638h);
            if (f9640j.f9642f == null && System.nanoTime() - nanoTime >= f9639i) {
                cVar2 = f9640j;
            }
            return cVar2;
        }
        long nanoTime2 = cVar.f9643g - System.nanoTime();
        if (nanoTime2 > 0) {
            long j2 = nanoTime2 / 1000000;
            cls.wait(j2, (int) (nanoTime2 - (1000000 * j2)));
            return null;
        }
        f9640j.f9642f = cVar.f9642f;
        cVar.f9642f = null;
        return cVar;
    }

    public final void f() {
        if (!this.f9641e) {
            long j2 = this.f9693c;
            boolean z = this.f9691a;
            if (j2 != 0 || z) {
                this.f9641e = true;
                a(this, j2, z);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean g() {
        if (!this.f9641e) {
            return false;
        }
        this.f9641e = false;
        return a(this);
    }

    public void h() {
    }

    public static synchronized boolean a(c cVar) {
        synchronized (c.class) {
            for (c cVar2 = f9640j; cVar2 != null; cVar2 = cVar2.f9642f) {
                if (cVar2.f9642f == cVar) {
                    cVar2.f9642f = cVar.f9642f;
                    cVar.f9642f = null;
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(boolean z) throws IOException {
        if (g() && z) {
            throw a((IOException) null);
        }
    }

    public IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
