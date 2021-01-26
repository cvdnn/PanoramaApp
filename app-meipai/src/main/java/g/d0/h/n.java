package g.d0.h;

import h.e;
import h.g;
import h.w;
import h.x;
import h.y;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Http2Stream */
public final class n {

    /* renamed from: a reason: collision with root package name */
    public long f9395a = 0;

    /* renamed from: b reason: collision with root package name */
    public long f9396b;

    /* renamed from: c reason: collision with root package name */
    public final int f9397c;

    /* renamed from: d reason: collision with root package name */
    public final g f9398d;

    /* renamed from: e reason: collision with root package name */
    public List<c> f9399e;

    /* renamed from: f reason: collision with root package name */
    public boolean f9400f;

    /* renamed from: g reason: collision with root package name */
    public final b f9401g;

    /* renamed from: h reason: collision with root package name */
    public final a f9402h;

    /* renamed from: i reason: collision with root package name */
    public final c f9403i = new c();

    /* renamed from: j reason: collision with root package name */
    public final c f9404j = new c();
    public b k = null;

    /* compiled from: Http2Stream */
    public final class a implements w {

        /* renamed from: a reason: collision with root package name */
        public final e f9405a = new e();

        /* renamed from: b reason: collision with root package name */
        public boolean f9406b;

        /* renamed from: c reason: collision with root package name */
        public boolean f9407c;

        public a() {
        }

        public void a(e eVar, long j2) throws IOException {
            this.f9405a.a(eVar, j2);
            while (this.f9405a.f9647b >= 16384) {
                a(false);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            if (r13.f9405a.f9647b <= 0) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r13.f9405a.f9647b <= 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            r0.f9398d.a(r0.f9397c, true, (h.e) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            r1 = r13.f9408d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r13.f9406b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            r13.f9408d.f9398d.q.flush();
            r13.f9408d.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
            r0 = r13.f9408d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r0.f9402h.f9407c != false) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r13 = this;
                g.d0.h.n r0 = g.d0.h.n.this
                monitor-enter(r0)
                boolean r1 = r13.f9406b     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                g.d0.h.n r0 = g.d0.h.n.this
                g.d0.h.n$a r1 = r0.f9402h
                boolean r1 = r1.f9407c
                r2 = 1
                if (r1 != 0) goto L_0x0034
                h.e r1 = r13.f9405a
                long r3 = r1.f9647b
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 <= 0) goto L_0x0029
            L_0x001d:
                h.e r0 = r13.f9405a
                long r0 = r0.f9647b
                int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x0034
                r13.a(r2)
                goto L_0x001d
            L_0x0029:
                g.d0.h.g r7 = r0.f9398d
                int r8 = r0.f9397c
                r9 = 1
                r10 = 0
                r11 = 0
                r7.a(r8, r9, r10, r11)
            L_0x0034:
                g.d0.h.n r1 = g.d0.h.n.this
                monitor-enter(r1)
                r13.f9406b = r2     // Catch:{ all -> 0x0049 }
                monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                g.d0.h.n r0 = g.d0.h.n.this
                g.d0.h.g r0 = r0.f9398d
                g.d0.h.o r0 = r0.q
                r0.flush()
                g.d0.h.n r0 = g.d0.h.n.this
                r0.a()
                return
            L_0x0049:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0049 }
                throw r0
            L_0x004c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.n.a.close():void");
        }

        public void flush() throws IOException {
            synchronized (n.this) {
                n.this.b();
            }
            while (this.f9405a.f9647b > 0) {
                a(false);
                n.this.f9398d.flush();
            }
        }

        public y timeout() {
            return n.this.f9404j;
        }

        /* JADX INFO: finally extract failed */
        public final void a(boolean z) throws IOException {
            long min;
            synchronized (n.this) {
                n.this.f9404j.f();
                while (n.this.f9396b <= 0 && !this.f9407c && !this.f9406b && n.this.k == null) {
                    try {
                        n.this.h();
                    } catch (Throwable th) {
                        n.this.f9404j.j();
                        throw th;
                    }
                }
                n.this.f9404j.j();
                n.this.b();
                min = Math.min(n.this.f9396b, this.f9405a.f9647b);
                n.this.f9396b -= min;
            }
            n.this.f9404j.f();
            try {
                n.this.f9398d.a(n.this.f9397c, z && min == this.f9405a.f9647b, this.f9405a, min);
            } finally {
                n.this.f9404j.j();
            }
        }
    }

    /* compiled from: Http2Stream */
    public final class b implements x {

        /* renamed from: a reason: collision with root package name */
        public final e f9409a = new e();

        /* renamed from: b reason: collision with root package name */
        public final e f9410b = new e();

        /* renamed from: c reason: collision with root package name */
        public final long f9411c;

        /* renamed from: d reason: collision with root package name */
        public boolean f9412d;

        /* renamed from: e reason: collision with root package name */
        public boolean f9413e;

        public b(long j2) {
            this.f9411c = j2;
        }

        public final void a() throws IOException {
            n.this.f9403i.f();
            while (this.f9410b.f9647b == 0 && !this.f9413e && !this.f9412d && n.this.k == null) {
                try {
                    n.this.h();
                } finally {
                    n.this.f9403i.j();
                }
            }
        }

        public void close() throws IOException {
            synchronized (n.this) {
                this.f9412d = true;
                this.f9410b.a();
                n.this.notifyAll();
            }
            n.this.a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
            r10 = r7.f9414f.f9398d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r7.f9414f.f9398d.k += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
            if (r7.f9414f.f9398d.k < ((long) (r7.f9414f.f9398d.m.a() / 2))) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
            r7.f9414f.f9398d.a(0, r7.f9414f.f9398d.k);
            r7.f9414f.f9398d.k = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(h.e r8, long r9) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00b3
                g.d0.h.n r2 = g.d0.h.n.this
                monitor-enter(r2)
                r7.a()     // Catch:{ all -> 0x00b0 }
                boolean r3 = r7.f9412d     // Catch:{ all -> 0x00b0 }
                if (r3 != 0) goto L_0x00a8
                g.d0.h.n r3 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                g.d0.h.b r3 = r3.k     // Catch:{ all -> 0x00b0 }
                if (r3 != 0) goto L_0x009e
                h.e r3 = r7.f9410b     // Catch:{ all -> 0x00b0 }
                long r3 = r3.f9647b     // Catch:{ all -> 0x00b0 }
                int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r3 != 0) goto L_0x0022
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00b0 }
                return r8
            L_0x0022:
                h.e r3 = r7.f9410b     // Catch:{ all -> 0x00b0 }
                h.e r4 = r7.f9410b     // Catch:{ all -> 0x00b0 }
                long r4 = r4.f9647b     // Catch:{ all -> 0x00b0 }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x00b0 }
                long r8 = r3.read(r8, r9)     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r10 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                long r3 = r10.f9395a     // Catch:{ all -> 0x00b0 }
                long r3 = r3 + r8
                r10.f9395a = r3     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r10 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                long r3 = r10.f9395a     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r10 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                g.d0.h.g r10 = r10.f9398d     // Catch:{ all -> 0x00b0 }
                g.d0.h.s r10 = r10.m     // Catch:{ all -> 0x00b0 }
                int r10 = r10.a()     // Catch:{ all -> 0x00b0 }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x00b0 }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x005f
                g.d0.h.n r10 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                g.d0.h.g r10 = r10.f9398d     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r3 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                int r3 = r3.f9397c     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r4 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                long r4 = r4.f9395a     // Catch:{ all -> 0x00b0 }
                r10.a(r3, r4)     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r10 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                r10.f9395a = r0     // Catch:{ all -> 0x00b0 }
            L_0x005f:
                monitor-exit(r2)     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r10 = g.d0.h.n.this
                g.d0.h.g r10 = r10.f9398d
                monitor-enter(r10)
                g.d0.h.n r2 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r2 = r2.f9398d     // Catch:{ all -> 0x009b }
                long r3 = r2.k     // Catch:{ all -> 0x009b }
                long r3 = r3 + r8
                r2.k = r3     // Catch:{ all -> 0x009b }
                g.d0.h.n r2 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r2 = r2.f9398d     // Catch:{ all -> 0x009b }
                long r2 = r2.k     // Catch:{ all -> 0x009b }
                g.d0.h.n r4 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r4 = r4.f9398d     // Catch:{ all -> 0x009b }
                g.d0.h.s r4 = r4.m     // Catch:{ all -> 0x009b }
                int r4 = r4.a()     // Catch:{ all -> 0x009b }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x009b }
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x0099
                g.d0.h.n r2 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r2 = r2.f9398d     // Catch:{ all -> 0x009b }
                r3 = 0
                g.d0.h.n r4 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r4 = r4.f9398d     // Catch:{ all -> 0x009b }
                long r4 = r4.k     // Catch:{ all -> 0x009b }
                r2.a(r3, r4)     // Catch:{ all -> 0x009b }
                g.d0.h.n r2 = g.d0.h.n.this     // Catch:{ all -> 0x009b }
                g.d0.h.g r2 = r2.f9398d     // Catch:{ all -> 0x009b }
                r2.k = r0     // Catch:{ all -> 0x009b }
            L_0x0099:
                monitor-exit(r10)     // Catch:{ all -> 0x009b }
                return r8
            L_0x009b:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x009b }
                throw r8
            L_0x009e:
                g.d0.h.t r8 = new g.d0.h.t     // Catch:{ all -> 0x00b0 }
                g.d0.h.n r9 = g.d0.h.n.this     // Catch:{ all -> 0x00b0 }
                g.d0.h.b r9 = r9.k     // Catch:{ all -> 0x00b0 }
                r8.<init>(r9)     // Catch:{ all -> 0x00b0 }
                throw r8     // Catch:{ all -> 0x00b0 }
            L_0x00a8:
                java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00b0 }
                java.lang.String r9 = "stream closed"
                r8.<init>(r9)     // Catch:{ all -> 0x00b0 }
                throw r8     // Catch:{ all -> 0x00b0 }
            L_0x00b0:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00b0 }
                throw r8
            L_0x00b3:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.n.b.read(h.e, long):long");
        }

        public y timeout() {
            return n.this.f9403i;
        }

        public void a(g gVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j2 > 0) {
                synchronized (n.this) {
                    z = this.f9413e;
                    z2 = true;
                    z3 = this.f9410b.f9647b + j2 > this.f9411c;
                }
                if (z3) {
                    gVar.skip(j2);
                    n.this.c(b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    gVar.skip(j2);
                    return;
                } else {
                    long read = gVar.read(this.f9409a, j2);
                    if (read != -1) {
                        j2 -= read;
                        synchronized (n.this) {
                            if (this.f9410b.f9647b != 0) {
                                z2 = false;
                            }
                            this.f9410b.a((x) this.f9409a);
                            if (z2) {
                                n.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }
    }

    /* compiled from: Http2Stream */
    public class c extends h.c {
        public c() {
        }

        public IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void h() {
            n.this.c(b.CANCEL);
        }

        public void j() throws IOException {
            if (g()) {
                throw a(null);
            }
        }
    }

    public n(int i2, g gVar, boolean z, boolean z2, List<c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f9397c = i2;
            this.f9398d = gVar;
            this.f9396b = (long) gVar.n.a();
            this.f9401g = new b((long) gVar.m.a());
            a aVar = new a();
            this.f9402h = aVar;
            this.f9401g.f9413e = z2;
            aVar.f9407c = z;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    public void a(b bVar) throws IOException {
        if (b(bVar)) {
            g gVar = this.f9398d;
            gVar.q.a(this.f9397c, bVar);
        }
    }

    public final boolean b(b bVar) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.f9401g.f9413e && this.f9402h.f9407c) {
                return false;
            }
            this.k = bVar;
            notifyAll();
            this.f9398d.d(this.f9397c);
            return true;
        }
    }

    public w c() {
        synchronized (this) {
            if (!this.f9400f) {
                if (!d()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f9402h;
    }

    public boolean d() {
        if (this.f9398d.f9333a == ((this.f9397c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean e() {
        if (this.k != null) {
            return false;
        }
        if ((this.f9401g.f9413e || this.f9401g.f9412d) && ((this.f9402h.f9407c || this.f9402h.f9406b) && this.f9400f)) {
            return false;
        }
        return true;
    }

    public void f() {
        boolean e2;
        synchronized (this) {
            this.f9401g.f9413e = true;
            e2 = e();
            notifyAll();
        }
        if (!e2) {
            this.f9398d.d(this.f9397c);
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized List<c> g() throws IOException {
        List<c> list;
        if (d()) {
            this.f9403i.f();
            while (this.f9399e == null && this.k == null) {
                try {
                    h();
                } catch (Throwable th) {
                    this.f9403i.j();
                    throw th;
                }
            }
            this.f9403i.j();
            list = this.f9399e;
            if (list != null) {
                this.f9399e = null;
            } else {
                throw new t(this.k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public void h() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public synchronized void d(b bVar) {
        if (this.k == null) {
            this.k = bVar;
            notifyAll();
        }
    }

    public void a(List<c> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.f9400f = true;
            if (this.f9399e == null) {
                this.f9399e = list;
                z = e();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f9399e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f9399e = arrayList;
            }
        }
        if (!z) {
            this.f9398d.d(this.f9397c);
        }
    }

    public void c(b bVar) {
        if (b(bVar)) {
            this.f9398d.a(this.f9397c, bVar);
        }
    }

    public void b() throws IOException {
        a aVar = this.f9402h;
        if (aVar.f9406b) {
            throw new IOException("stream closed");
        } else if (aVar.f9407c) {
            throw new IOException("stream finished");
        } else if (this.k != null) {
            throw new t(this.k);
        }
    }

    public void a() throws IOException {
        boolean z;
        boolean e2;
        synchronized (this) {
            z = !this.f9401g.f9413e && this.f9401g.f9412d && (this.f9402h.f9407c || this.f9402h.f9406b);
            e2 = e();
        }
        if (z) {
            a(b.CANCEL);
        } else if (!e2) {
            this.f9398d.d(this.f9397c);
        }
    }
}
