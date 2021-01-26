package g.d0.h;

import com.arashivision.graphicpath.render.source.AssetInfo.SubMediaType;
import h.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Connection */
public final class g implements Closeable {
    public static final ExecutorService t;

    /* renamed from: a reason: collision with root package name */
    public final boolean f9333a;

    /* renamed from: b reason: collision with root package name */
    public final e f9334b;

    /* renamed from: c reason: collision with root package name */
    public final Map<Integer, n> f9335c = new LinkedHashMap();

    /* renamed from: d reason: collision with root package name */
    public final String f9336d;

    /* renamed from: e reason: collision with root package name */
    public int f9337e;

    /* renamed from: f reason: collision with root package name */
    public int f9338f;

    /* renamed from: g reason: collision with root package name */
    public boolean f9339g;

    /* renamed from: h reason: collision with root package name */
    public final ExecutorService f9340h;

    /* renamed from: i reason: collision with root package name */
    public Map<Integer, q> f9341i;

    /* renamed from: j reason: collision with root package name */
    public final r f9342j;
    public long k = 0;
    public long l;
    public s m = new s();
    public final s n = new s();
    public boolean o = false;
    public final Socket p;
    public final o q;
    public final f r;
    public final Set<Integer> s = new LinkedHashSet();

    /* compiled from: Http2Connection */
    public class a extends g.d0.b {

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f9343b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ b f9344c;

        public a(String str, Object[] objArr, int i2, b bVar) {
            this.f9343b = i2;
            this.f9344c = bVar;
            super(str, objArr);
        }

        public void a() {
            try {
                g gVar = g.this;
                gVar.q.a(this.f9343b, this.f9344c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection */
    public class b extends g.d0.b {

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f9346b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ long f9347c;

        public b(String str, Object[] objArr, int i2, long j2) {
            this.f9346b = i2;
            this.f9347c = j2;
            super(str, objArr);
        }

        public void a() {
            try {
                g.this.q.a(this.f9346b, this.f9347c);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection */
    public class c extends g.d0.b {

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f9349b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ List f9350c;

        public c(String str, Object[] objArr, int i2, List list) {
            this.f9349b = i2;
            this.f9350c = list;
            super(str, objArr);
        }

        public void a() {
            g gVar = g.this;
            r rVar = gVar.f9342j;
            int i2 = this.f9349b;
            if (((g.d0.h.r.a) rVar) != null) {
                try {
                    gVar.q.a(i2, b.CANCEL);
                    synchronized (g.this) {
                        g.this.s.remove(Integer.valueOf(this.f9349b));
                    }
                } catch (IOException unused) {
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: Http2Connection */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public Socket f9352a;

        /* renamed from: b reason: collision with root package name */
        public String f9353b;

        /* renamed from: c reason: collision with root package name */
        public h.g f9354c;

        /* renamed from: d reason: collision with root package name */
        public h.f f9355d;

        /* renamed from: e reason: collision with root package name */
        public e f9356e = e.f9359a;

        /* renamed from: f reason: collision with root package name */
        public r f9357f = r.f9432a;

        /* renamed from: g reason: collision with root package name */
        public boolean f9358g;

        public d(boolean z) {
            this.f9358g = z;
        }
    }

    /* compiled from: Http2Connection */
    public static abstract class e {

        /* renamed from: a reason: collision with root package name */
        public static final e f9359a = new a();

        /* compiled from: Http2Connection */
        public class a extends e {
            public void a(n nVar) throws IOException {
                nVar.a(b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(n nVar) throws IOException;
    }

    /* compiled from: Http2Connection */
    public class f extends g.d0.b implements g.d0.h.m.b {

        /* renamed from: b reason: collision with root package name */
        public final m f9360b;

        /* compiled from: Http2Connection */
        public class a extends g.d0.b {

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ n f9362b;

            public a(String str, Object[] objArr, n nVar) {
                this.f9362b = nVar;
                super(str, objArr);
            }

            public void a() {
                try {
                    g.this.f9334b.a(this.f9362b);
                } catch (IOException e2) {
                    g.d0.i.e eVar = g.d0.i.e.f9461a;
                    StringBuilder a2 = e.a.a.a.a.a("Http2Connection.Listener failure for ");
                    a2.append(g.this.f9336d);
                    eVar.a(4, a2.toString(), (Throwable) e2);
                    try {
                        this.f9362b.a(b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection */
        public class b extends g.d0.b {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            public void a() {
                g gVar = g.this;
                gVar.f9334b.a(gVar);
            }
        }

        public f(m mVar) {
            super("OkHttp %s", g.this.f9336d);
            this.f9360b = mVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1 = g.d0.h.b.PROTOCOL_ERROR;
            r0 = g.d0.h.b.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.f9361c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                g.d0.h.b r0 = g.d0.h.b.INTERNAL_ERROR
                g.d0.h.m r1 = r4.f9360b     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r1.a(r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            L_0x0007:
                g.d0.h.m r1 = r4.f9360b     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r2 = 0
                boolean r1 = r1.a(r2, r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                g.d0.h.b r1 = g.d0.h.b.NO_ERROR     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                g.d0.h.b r0 = g.d0.h.b.CANCEL     // Catch:{ IOException -> 0x001c }
                g.d0.h.g r2 = g.d0.h.g.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x0018:
                r2 = move-exception
                r1 = r0
                goto L_0x002c
            L_0x001b:
                r1 = r0
            L_0x001c:
                g.d0.h.b r1 = g.d0.h.b.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                g.d0.h.b r0 = g.d0.h.b.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                g.d0.h.g r2 = g.d0.h.g.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.a(r1, r0)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                g.d0.h.m r0 = r4.f9360b
                g.d0.c.a(r0)
                return
            L_0x002b:
                r2 = move-exception
            L_0x002c:
                g.d0.h.g r3 = g.d0.h.g.this     // Catch:{ IOException -> 0x0031 }
                r3.a(r1, r0)     // Catch:{ IOException -> 0x0031 }
            L_0x0031:
                g.d0.h.m r0 = r4.f9360b
                g.d0.c.a(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.g.f.a():void");
        }

        /* JADX INFO: used method not loaded: g.d0.h.n.a(java.util.List):null, types can be incorrect */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
            r3.a((java.util.List) r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
            if (r12 == false) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
            r3.f();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r12, int r13, int r14, java.util.List<g.d0.h.c> r15) {
            /*
                r11 = this;
                g.d0.h.g r14 = g.d0.h.g.this
                boolean r14 = r14.b(r13)
                r0 = 1
                r1 = 0
                r2 = 2
                if (r14 == 0) goto L_0x002a
                g.d0.h.g r4 = g.d0.h.g.this
                java.util.concurrent.ExecutorService r14 = r4.f9340h
                g.d0.h.i r10 = new g.d0.h.i
                java.lang.Object[] r6 = new java.lang.Object[r2]
                java.lang.String r2 = r4.f9336d
                r6[r1] = r2
                java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
                r6[r0] = r1
                java.lang.String r5 = "OkHttp %s Push Headers[%s]"
                r3 = r10
                r7 = r13
                r8 = r15
                r9 = r12
                r3.<init>(r4, r5, r6, r7, r8, r9)
                r14.execute(r10)
                return
            L_0x002a:
                g.d0.h.g r14 = g.d0.h.g.this
                monitor-enter(r14)
                g.d0.h.g r3 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                g.d0.h.n r3 = r3.a(r13)     // Catch:{ all -> 0x0091 }
                if (r3 != 0) goto L_0x0087
                g.d0.h.g r3 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                boolean r3 = r3.f9339g     // Catch:{ all -> 0x0091 }
                if (r3 == 0) goto L_0x003d
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                return
            L_0x003d:
                g.d0.h.g r3 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                int r3 = r3.f9337e     // Catch:{ all -> 0x0091 }
                if (r13 > r3) goto L_0x0045
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                return
            L_0x0045:
                int r3 = r13 % 2
                g.d0.h.g r4 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                int r4 = r4.f9338f     // Catch:{ all -> 0x0091 }
                int r4 = r4 % r2
                if (r3 != r4) goto L_0x0050
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                return
            L_0x0050:
                g.d0.h.n r9 = new g.d0.h.n     // Catch:{ all -> 0x0091 }
                g.d0.h.g r5 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                r6 = 0
                r3 = r9
                r4 = r13
                r7 = r12
                r8 = r15
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0091 }
                g.d0.h.g r12 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                r12.f9337e = r13     // Catch:{ all -> 0x0091 }
                g.d0.h.g r12 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                java.util.Map<java.lang.Integer, g.d0.h.n> r12 = r12.f9335c     // Catch:{ all -> 0x0091 }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0091 }
                r12.put(r15, r9)     // Catch:{ all -> 0x0091 }
                java.util.concurrent.ExecutorService r12 = g.d0.h.g.t     // Catch:{ all -> 0x0091 }
                g.d0.h.g$f$a r15 = new g.d0.h.g$f$a     // Catch:{ all -> 0x0091 }
                java.lang.String r3 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0091 }
                g.d0.h.g r4 = g.d0.h.g.this     // Catch:{ all -> 0x0091 }
                java.lang.String r4 = r4.f9336d     // Catch:{ all -> 0x0091 }
                r2[r1] = r4     // Catch:{ all -> 0x0091 }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0091 }
                r2[r0] = r13     // Catch:{ all -> 0x0091 }
                r15.<init>(r3, r2, r9)     // Catch:{ all -> 0x0091 }
                r12.execute(r15)     // Catch:{ all -> 0x0091 }
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                return
            L_0x0087:
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                r3.a(r15)
                if (r12 == 0) goto L_0x0090
                r3.f()
            L_0x0090:
                return
            L_0x0091:
                r12 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x0091 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: g.d0.h.g.f.a(boolean, int, int, java.util.List):void");
        }

        public void a(boolean z, s sVar) {
            int i2;
            n[] nVarArr;
            long j2;
            synchronized (g.this) {
                int a2 = g.this.n.a();
                if (z) {
                    s sVar2 = g.this.n;
                    sVar2.f9433a = 0;
                    Arrays.fill(sVar2.f9434b, 0);
                }
                s sVar3 = g.this.n;
                nVarArr = null;
                if (sVar3 != null) {
                    int i3 = 0;
                    while (true) {
                        boolean z2 = true;
                        if (i3 >= 10) {
                            break;
                        }
                        if (((1 << i3) & sVar.f9433a) == 0) {
                            z2 = false;
                        }
                        if (z2) {
                            sVar3.a(i3, sVar.f9434b[i3]);
                        }
                        i3++;
                    }
                    g.t.execute(new l(this, "OkHttp %s ACK Settings", new Object[]{g.this.f9336d}, sVar));
                    int a3 = g.this.n.a();
                    if (a3 == -1 || a3 == a2) {
                        j2 = 0;
                    } else {
                        j2 = (long) (a3 - a2);
                        if (!g.this.o) {
                            g gVar = g.this;
                            gVar.l += j2;
                            if (j2 > 0) {
                                gVar.notifyAll();
                            }
                            g.this.o = true;
                        }
                        if (!g.this.f9335c.isEmpty()) {
                            nVarArr = (n[]) g.this.f9335c.values().toArray(new n[g.this.f9335c.size()]);
                        }
                    }
                    g.t.execute(new b("OkHttp %s settings", g.this.f9336d));
                } else {
                    throw null;
                }
            }
            if (nVarArr != null) {
                int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i4 != 0) {
                    int length = nVarArr.length;
                    for (i2 = 0; i2 < length; i2++) {
                        n nVar = nVarArr[i2];
                        synchronized (nVar) {
                            nVar.f9396b += j2;
                            if (i4 > 0) {
                                nVar.notifyAll();
                            }
                        }
                    }
                }
            }
        }

        public void a(int i2, b bVar, h hVar) {
            n[] nVarArr;
            hVar.d();
            synchronized (g.this) {
                nVarArr = (n[]) g.this.f9335c.values().toArray(new n[g.this.f9335c.size()]);
                g.this.f9339g = true;
            }
            for (n nVar : nVarArr) {
                if (nVar.f9397c > i2 && nVar.d()) {
                    nVar.d(b.REFUSED_STREAM);
                    g.this.d(nVar.f9397c);
                }
            }
        }

        public void a(int i2, long j2) {
            if (i2 == 0) {
                synchronized (g.this) {
                    g.this.l += j2;
                    g.this.notifyAll();
                }
                return;
            }
            n a2 = g.this.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.f9396b += j2;
                    if (j2 > 0) {
                        a2.notifyAll();
                    }
                }
            }
        }
    }

    static {
        Class<g> cls = g.class;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), g.d0.c.a("OkHttp Http2Connection", true));
        t = threadPoolExecutor;
    }

    public g(d dVar) {
        this.f9342j = dVar.f9357f;
        boolean z = dVar.f9358g;
        this.f9333a = z;
        this.f9334b = dVar.f9356e;
        int i2 = z ? 1 : 2;
        this.f9338f = i2;
        if (dVar.f9358g) {
            this.f9338f = i2 + 2;
        }
        boolean z2 = dVar.f9358g;
        if (dVar.f9358g) {
            this.m.a(7, 16777216);
        }
        this.f9336d = dVar.f9353b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g.d0.c.b(g.d0.c.a("OkHttp %s Push Observer", this.f9336d), true));
        this.f9340h = threadPoolExecutor;
        this.n.a(7, SubMediaType.UNDEFINED);
        this.n.a(5, 16384);
        this.l = (long) this.n.a();
        this.p = dVar.f9352a;
        this.q = new o(dVar.f9355d, this.f9333a);
        this.r = new f(new m(dVar.f9354c, this.f9333a));
    }

    public synchronized n a(int i2) {
        return (n) this.f9335c.get(Integer.valueOf(i2));
    }

    public synchronized int b() {
        int i2;
        s sVar = this.n;
        i2 = Integer.MAX_VALUE;
        if ((sVar.f9433a & 16) != 0) {
            i2 = sVar.f9434b[4];
        }
        return i2;
    }

    public boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public synchronized q c(int i2) {
        return this.f9341i != null ? (q) this.f9341i.remove(Integer.valueOf(i2)) : null;
    }

    public void close() throws IOException {
        a(b.NO_ERROR, b.CANCEL);
    }

    public synchronized n d(int i2) {
        n nVar;
        nVar = (n) this.f9335c.remove(Integer.valueOf(i2));
        notifyAll();
        return nVar;
    }

    public void flush() throws IOException {
        this.q.flush();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g.d0.h.n a(int r11, java.util.List<g.d0.h.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            g.d0.h.o r7 = r10.q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x006c }
            boolean r0 = r10.f9339g     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0063
            int r8 = r10.f9338f     // Catch:{ all -> 0x0069 }
            int r0 = r10.f9338f     // Catch:{ all -> 0x0069 }
            int r0 = r0 + 2
            r10.f9338f = r0     // Catch:{ all -> 0x0069 }
            g.d0.h.n r9 = new g.d0.h.n     // Catch:{ all -> 0x0069 }
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0069 }
            if (r13 == 0) goto L_0x0030
            long r0 = r10.l     // Catch:{ all -> 0x0069 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0030
            long r0 = r9.f9396b     // Catch:{ all -> 0x0069 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r13 = 0
            goto L_0x0031
        L_0x0030:
            r13 = 1
        L_0x0031:
            boolean r0 = r9.e()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0040
            java.util.Map<java.lang.Integer, g.d0.h.n> r0 = r10.f9335c     // Catch:{ all -> 0x0069 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0069 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0069 }
        L_0x0040:
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            if (r11 != 0) goto L_0x0049
            g.d0.h.o r11 = r10.q     // Catch:{ all -> 0x006c }
            r11.b(r6, r8, r12)     // Catch:{ all -> 0x006c }
            goto L_0x0052
        L_0x0049:
            boolean r0 = r10.f9333a     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x005b
            g.d0.h.o r0 = r10.q     // Catch:{ all -> 0x006c }
            r0.a(r11, r8, r12)     // Catch:{ all -> 0x006c }
        L_0x0052:
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            if (r13 == 0) goto L_0x005a
            g.d0.h.o r11 = r10.q
            r11.flush()
        L_0x005a:
            return r9
        L_0x005b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006c }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x006c }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x0063:
            g.d0.h.a r11 = new g.d0.h.a     // Catch:{ all -> 0x0069 }
            r11.<init>()     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x006c:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.h.g.a(int, java.util.List, boolean):g.d0.h.n");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.l), r8.q.f9419d);
        r6 = (long) r2;
        r8.l -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r9, boolean r10, h.e r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            g.d0.h.o r12 = r8.q
            r12.a(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0060
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.l     // Catch:{ InterruptedException -> 0x0058 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, g.d0.h.n> r2 = r8.f9335c     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r2 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r4 = r8.l     // Catch:{ all -> 0x0056 }
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0056 }
            int r2 = (int) r4     // Catch:{ all -> 0x0056 }
            g.d0.h.o r4 = r8.q     // Catch:{ all -> 0x0056 }
            int r4 = r4.f9419d     // Catch:{ all -> 0x0056 }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0056 }
            long r4 = r8.l     // Catch:{ all -> 0x0056 }
            long r6 = (long) r2     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.l = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            g.d0.h.o r4 = r8.q
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = r3
        L_0x0052:
            r4.a(r5, r9, r11, r2)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x005e
        L_0x0058:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x005e:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.h.g.a(int, boolean, h.e, long):void");
    }

    public void a(int i2, b bVar) {
        ExecutorService executorService = t;
        a aVar = new a("OkHttp %s stream %d", new Object[]{this.f9336d, Integer.valueOf(i2)}, i2, bVar);
        executorService.execute(aVar);
    }

    public void a(int i2, long j2) {
        ExecutorService executorService = t;
        b bVar = new b("OkHttp Window Update %s stream %d", new Object[]{this.f9336d, Integer.valueOf(i2)}, i2, j2);
        executorService.execute(bVar);
    }

    public void a(boolean z, int i2, int i3, q qVar) throws IOException {
        synchronized (this.q) {
            if (qVar != null) {
                if (qVar.f9430b == -1) {
                    qVar.f9430b = System.nanoTime();
                } else {
                    throw new IllegalStateException();
                }
            }
            this.q.a(z, i2, i3);
        }
    }

    public void a(b bVar) throws IOException {
        synchronized (this.q) {
            synchronized (this) {
                if (!this.f9339g) {
                    this.f9339g = true;
                    int i2 = this.f9337e;
                    this.q.a(i2, bVar, g.d0.c.f9174a);
                }
            }
        }
    }

    public void a(b bVar, b bVar2) throws IOException {
        n[] nVarArr;
        q[] qVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.f9335c.isEmpty()) {
                nVarArr = (n[]) this.f9335c.values().toArray(new n[this.f9335c.size()]);
                this.f9335c.clear();
            } else {
                nVarArr = null;
            }
            if (this.f9341i != null) {
                q[] qVarArr2 = (q[]) this.f9341i.values().toArray(new q[this.f9341i.size()]);
                this.f9341i = null;
                qVarArr = qVarArr2;
            }
        }
        int i2 = 0;
        if (nVarArr != null) {
            for (n a2 : nVarArr) {
                try {
                    a2.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        if (qVarArr != null) {
            int length = qVarArr.length;
            while (i2 < length) {
                q qVar = qVarArr[i2];
                if (qVar.f9431c == -1) {
                    long j2 = qVar.f9430b;
                    if (j2 != -1) {
                        qVar.f9431c = j2 - 1;
                        qVar.f9429a.countDown();
                        i2++;
                    }
                }
                throw new IllegalStateException();
            }
        }
        try {
            this.q.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.p.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    public synchronized boolean a() {
        return this.f9339g;
    }

    public void a(int i2, List<c> list) {
        synchronized (this) {
            if (this.s.contains(Integer.valueOf(i2))) {
                a(i2, b.PROTOCOL_ERROR);
                return;
            }
            this.s.add(Integer.valueOf(i2));
            ExecutorService executorService = this.f9340h;
            c cVar = new c("OkHttp %s Push Request[%s]", new Object[]{this.f9336d, Integer.valueOf(i2)}, i2, list);
            executorService.execute(cVar);
        }
    }
}
