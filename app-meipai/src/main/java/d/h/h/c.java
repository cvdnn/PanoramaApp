package d.h.h;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final Object f4853a = new Object();

    /* renamed from: b reason: collision with root package name */
    public HandlerThread f4854b;

    /* renamed from: c reason: collision with root package name */
    public Handler f4855c;

    /* renamed from: d reason: collision with root package name */
    public int f4856d;

    /* renamed from: e reason: collision with root package name */
    public Callback f4857e = new a();

    /* renamed from: f reason: collision with root package name */
    public final int f4858f;

    /* renamed from: g reason: collision with root package name */
    public final int f4859g;

    /* renamed from: h reason: collision with root package name */
    public final String f4860h;

    /* compiled from: SelfDestructiveThread */
    public class a implements Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c.this.a();
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                c.this.a((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread */
    public class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ AtomicReference f4862a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ Callable f4863b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f4864c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4865d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ Condition f4866e;

        public b(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f4862a = atomicReference;
            this.f4863b = callable;
            this.f4864c = reentrantLock;
            this.f4865d = atomicBoolean;
            this.f4866e = condition;
        }

        public void run() {
            try {
                this.f4862a.set(this.f4863b.call());
            } catch (Exception unused) {
            }
            this.f4864c.lock();
            try {
                this.f4865d.set(false);
                this.f4866e.signal();
            } finally {
                this.f4864c.unlock();
            }
        }
    }

    /* renamed from: d.h.h.c$c reason: collision with other inner class name */
    /* compiled from: SelfDestructiveThread */
    public interface C0037c<T> {
        void a(T t);
    }

    public c(String str, int i2, int i3) {
        this.f4860h = str;
        this.f4859g = i2;
        this.f4858f = i3;
        this.f4856d = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            d.h.h.c$b r11 = new d.h.h.c$b
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r12.b(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.h.c.a(java.util.concurrent.Callable, int):java.lang.Object");
    }

    public final void b(Runnable runnable) {
        synchronized (this.f4853a) {
            if (this.f4854b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f4860h, this.f4859g);
                this.f4854b = handlerThread;
                handlerThread.start();
                this.f4855c = new Handler(this.f4854b.getLooper(), this.f4857e);
                this.f4856d++;
            }
            this.f4855c.removeMessages(0);
            this.f4855c.sendMessage(this.f4855c.obtainMessage(1, runnable));
        }
    }

    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f4853a) {
            this.f4855c.removeMessages(0);
            this.f4855c.sendMessageDelayed(this.f4855c.obtainMessage(0), (long) this.f4858f);
        }
    }

    public void a() {
        synchronized (this.f4853a) {
            if (!this.f4855c.hasMessages(1)) {
                this.f4854b.quit();
                this.f4854b = null;
                this.f4855c = null;
            }
        }
    }
}
