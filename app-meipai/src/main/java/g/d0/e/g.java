package g.d0.e;

import g.b0;
import g.d0.f.c;
import g.d0.f.f;
import g.d0.h.b;
import g.d0.h.t;
import g.e;
import g.h;
import g.n;
import g.u;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;

/* compiled from: StreamAllocation */
public final class g {

    /* renamed from: a reason: collision with root package name */
    public final g.a f9220a;

    /* renamed from: b reason: collision with root package name */
    public g.d0.e.f.a f9221b;

    /* renamed from: c reason: collision with root package name */
    public b0 f9222c;

    /* renamed from: d reason: collision with root package name */
    public final h f9223d;

    /* renamed from: e reason: collision with root package name */
    public final e f9224e;

    /* renamed from: f reason: collision with root package name */
    public final n f9225f;

    /* renamed from: g reason: collision with root package name */
    public final Object f9226g;

    /* renamed from: h reason: collision with root package name */
    public final f f9227h;

    /* renamed from: i reason: collision with root package name */
    public int f9228i;

    /* renamed from: j reason: collision with root package name */
    public c f9229j;
    public boolean k;
    public boolean l;
    public boolean m;
    public c n;

    /* compiled from: StreamAllocation */
    public static final class a extends WeakReference<g> {

        /* renamed from: a reason: collision with root package name */
        public final Object f9230a;

        public a(g gVar, Object obj) {
            super(gVar);
            this.f9230a = obj;
        }
    }

    public g(h hVar, g.a aVar, e eVar, n nVar, Object obj) {
        this.f9223d = hVar;
        this.f9220a = aVar;
        this.f9224e = eVar;
        this.f9225f = nVar;
        if (((g.u.a) g.d0.a.f9172a) != null) {
            this.f9227h = new f(aVar, hVar.f9494e, eVar, nVar);
            this.f9226g = obj;
            return;
        }
        throw null;
    }

    public c a(u uVar, g.s.a aVar, boolean z) {
        f fVar = (f) aVar;
        try {
            c a2 = a(((f) aVar).f9245i, fVar.f9246j, fVar.k, uVar.w, z).a(uVar, aVar, this);
            synchronized (this.f9223d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public c b() {
        c cVar;
        synchronized (this.f9223d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.f9229j;
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.f9223d) {
            cVar = this.f9229j;
            a2 = a(true, false, false);
            if (this.f9229j != null) {
                cVar = null;
            }
        }
        g.d0.c.a(a2);
        if (cVar != null && this.f9225f == null) {
            throw null;
        }
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f9223d) {
            cVar = this.f9229j;
            a2 = a(false, true, false);
            if (this.f9229j != null) {
                cVar = null;
            }
        }
        g.d0.c.a(a2);
        if (cVar != null && this.f9225f == null) {
            throw null;
        }
    }

    public String toString() {
        c c2 = c();
        return c2 != null ? c2.toString() : this.f9220a.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0.f9201e.isInputShutdown() != false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r0.f9201e.isOutputShutdown() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r1 = r0.f9204h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r2 = !r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r11 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = r0.f9201e.getSoTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.f9201e.setSoTimeout(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0.f9205i.g() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.f9201e.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        r0.f9201e.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        r0.f9201e.setSoTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r0.f9201e.isClosed() != false) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f A[LOOP:0: B:0:0x0000->B:33:0x005f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0063 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g.d0.e.c a(int r7, int r8, int r9, boolean r10, boolean r11) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            g.d0.e.c r0 = r6.a(r7, r8, r9, r10)
            g.h r1 = r6.f9223d
            monitor-enter(r1)
            int r2 = r0.l     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            java.net.Socket r1 = r0.f9201e
            boolean r1 = r1.isClosed()
            r2 = 0
            if (r1 != 0) goto L_0x005d
            java.net.Socket r1 = r0.f9201e
            boolean r1 = r1.isInputShutdown()
            if (r1 != 0) goto L_0x005d
            java.net.Socket r1 = r0.f9201e
            boolean r1 = r1.isOutputShutdown()
            if (r1 == 0) goto L_0x0028
            goto L_0x005d
        L_0x0028:
            g.d0.h.g r1 = r0.f9204h
            r3 = 1
            if (r1 == 0) goto L_0x0034
            boolean r1 = r1.a()
            r2 = r1 ^ 1
            goto L_0x005d
        L_0x0034:
            if (r11 == 0) goto L_0x005c
            java.net.Socket r1 = r0.f9201e     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            int r1 = r1.getSoTimeout()     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            java.net.Socket r4 = r0.f9201e     // Catch:{ all -> 0x0055 }
            r4.setSoTimeout(r3)     // Catch:{ all -> 0x0055 }
            h.g r4 = r0.f9205i     // Catch:{ all -> 0x0055 }
            boolean r4 = r4.g()     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x004f
            java.net.Socket r4 = r0.f9201e     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r4.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            goto L_0x005d
        L_0x004f:
            java.net.Socket r4 = r0.f9201e     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r4.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            goto L_0x005c
        L_0x0055:
            r4 = move-exception
            java.net.Socket r5 = r0.f9201e     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            r5.setSoTimeout(r1)     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
            throw r4     // Catch:{ SocketTimeoutException -> 0x005c, IOException -> 0x005d }
        L_0x005c:
            r2 = r3
        L_0x005d:
            if (r2 != 0) goto L_0x0063
            r6.d()
            goto L_0x0000
        L_0x0063:
            return r0
        L_0x0064:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0064 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.e.g.a(int, int, int, boolean, boolean):g.d0.e.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0206 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0274  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g.d0.e.c a(int r18, int r19, int r20, boolean r21) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            g.h r2 = r1.f9223d
            monitor-enter(r2)
            boolean r0 = r1.l     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x02f5
            g.d0.f.c r0 = r1.n     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x02ed
            boolean r0 = r1.m     // Catch:{ all -> 0x02fd }
            if (r0 != 0) goto L_0x02e5
            g.d0.e.c r0 = r1.f9229j     // Catch:{ all -> 0x02fd }
            g.d0.e.c r3 = r1.f9229j     // Catch:{ all -> 0x02fd }
            r4 = 0
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0023
            boolean r3 = r3.k     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x0023
            java.net.Socket r3 = r1.a(r4, r4, r6)     // Catch:{ all -> 0x02fd }
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            g.d0.e.c r7 = r1.f9229j     // Catch:{ all -> 0x02fd }
            if (r7 == 0) goto L_0x002c
            g.d0.e.c r0 = r1.f9229j     // Catch:{ all -> 0x02fd }
            r7 = r5
            goto L_0x002e
        L_0x002c:
            r7 = r0
            r0 = r5
        L_0x002e:
            boolean r8 = r1.k     // Catch:{ all -> 0x02fd }
            if (r8 != 0) goto L_0x0033
            r7 = r5
        L_0x0033:
            if (r0 != 0) goto L_0x004b
            g.d0.a r8 = g.d0.a.f9172a     // Catch:{ all -> 0x02fd }
            g.h r9 = r1.f9223d     // Catch:{ all -> 0x02fd }
            g.a r10 = r1.f9220a     // Catch:{ all -> 0x02fd }
            r8.a(r9, r10, r1, r5)     // Catch:{ all -> 0x02fd }
            g.d0.e.c r8 = r1.f9229j     // Catch:{ all -> 0x02fd }
            if (r8 == 0) goto L_0x0046
            g.d0.e.c r0 = r1.f9229j     // Catch:{ all -> 0x02fd }
            r8 = r6
            goto L_0x004c
        L_0x0046:
            g.b0 r8 = r1.f9222c     // Catch:{ all -> 0x02fd }
            r9 = r8
            r8 = r4
            goto L_0x004d
        L_0x004b:
            r8 = r4
        L_0x004c:
            r9 = r5
        L_0x004d:
            monitor-exit(r2)     // Catch:{ all -> 0x02fd }
            g.d0.c.a(r3)
            if (r7 == 0) goto L_0x0059
            g.n r2 = r1.f9225f
            if (r2 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            throw r5
        L_0x0059:
            if (r8 == 0) goto L_0x0061
            g.n r2 = r1.f9225f
            if (r2 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            throw r5
        L_0x0061:
            if (r0 == 0) goto L_0x0064
            return r0
        L_0x0064:
            if (r9 != 0) goto L_0x0202
            g.d0.e.f$a r2 = r1.f9221b
            if (r2 == 0) goto L_0x0070
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x0202
        L_0x0070:
            g.d0.e.f r2 = r1.f9227h
            boolean r3 = r2.a()
            if (r3 == 0) goto L_0x01fc
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x007d:
            boolean r7 = r2.b()
            if (r7 == 0) goto L_0x01e3
            boolean r7 = r2.b()
            java.lang.String r10 = "No route to "
            if (r7 == 0) goto L_0x01c2
            java.util.List<java.net.Proxy> r7 = r2.f9214e
            int r11 = r2.f9215f
            int r12 = r11 + 1
            r2.f9215f = r12
            java.lang.Object r7 = r7.get(r11)
            java.net.Proxy r7 = (java.net.Proxy) r7
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r2.f9216g = r11
            java.net.Proxy$Type r11 = r7.type()
            java.net.Proxy$Type r12 = java.net.Proxy.Type.DIRECT
            if (r11 == r12) goto L_0x00e6
            java.net.Proxy$Type r11 = r7.type()
            java.net.Proxy$Type r12 = java.net.Proxy.Type.SOCKS
            if (r11 != r12) goto L_0x00b1
            goto L_0x00e6
        L_0x00b1:
            java.net.SocketAddress r11 = r7.address()
            boolean r12 = r11 instanceof java.net.InetSocketAddress
            if (r12 == 0) goto L_0x00cf
            java.net.InetSocketAddress r11 = (java.net.InetSocketAddress) r11
            java.net.InetAddress r12 = r11.getAddress()
            if (r12 != 0) goto L_0x00c6
            java.lang.String r12 = r11.getHostName()
            goto L_0x00ca
        L_0x00c6:
            java.lang.String r12 = r12.getHostAddress()
        L_0x00ca:
            int r11 = r11.getPort()
            goto L_0x00ee
        L_0x00cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Proxy.address() is not an InetSocketAddress: "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            java.lang.Class r3 = r11.getClass()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00e6:
            g.a r11 = r2.f9210a
            g.r r11 = r11.f9126a
            java.lang.String r12 = r11.f9538d
            int r11 = r11.f9539e
        L_0x00ee:
            if (r11 < r6) goto L_0x01a0
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r11 > r6) goto L_0x01a0
            java.net.Proxy$Type r6 = r7.type()
            java.net.Proxy$Type r10 = java.net.Proxy.Type.SOCKS
            if (r6 != r10) goto L_0x0107
            java.util.List<java.net.InetSocketAddress> r6 = r2.f9216g
            java.net.InetSocketAddress r10 = java.net.InetSocketAddress.createUnresolved(r12, r11)
            r6.add(r10)
            goto L_0x0141
        L_0x0107:
            g.n r6 = r2.f9213d
            if (r6 == 0) goto L_0x019f
            g.a r6 = r2.f9210a
            g.m r6 = r6.f9127b
            g.m$a r6 = (g.m.a) r6
            if (r6 == 0) goto L_0x019e
            if (r12 == 0) goto L_0x0196
            java.net.InetAddress[] r6 = java.net.InetAddress.getAllByName(r12)
            java.util.List r6 = java.util.Arrays.asList(r6)
            boolean r10 = r6.isEmpty()
            if (r10 != 0) goto L_0x0178
            g.n r10 = r2.f9213d
            if (r10 == 0) goto L_0x0177
            int r10 = r6.size()
            r12 = r4
        L_0x012c:
            if (r12 >= r10) goto L_0x0141
            java.lang.Object r13 = r6.get(r12)
            java.net.InetAddress r13 = (java.net.InetAddress) r13
            java.util.List<java.net.InetSocketAddress> r14 = r2.f9216g
            java.net.InetSocketAddress r15 = new java.net.InetSocketAddress
            r15.<init>(r13, r11)
            r14.add(r15)
            int r12 = r12 + 1
            goto L_0x012c
        L_0x0141:
            java.util.List<java.net.InetSocketAddress> r6 = r2.f9216g
            int r6 = r6.size()
            r10 = r4
        L_0x0148:
            if (r10 >= r6) goto L_0x016d
            g.b0 r11 = new g.b0
            g.a r12 = r2.f9210a
            java.util.List<java.net.InetSocketAddress> r13 = r2.f9216g
            java.lang.Object r13 = r13.get(r10)
            java.net.InetSocketAddress r13 = (java.net.InetSocketAddress) r13
            r11.<init>(r12, r7, r13)
            g.d0.e.d r12 = r2.f9211b
            boolean r12 = r12.c(r11)
            if (r12 == 0) goto L_0x0167
            java.util.List<g.b0> r12 = r2.f9217h
            r12.add(r11)
            goto L_0x016a
        L_0x0167:
            r3.add(r11)
        L_0x016a:
            int r10 = r10 + 1
            goto L_0x0148
        L_0x016d:
            boolean r6 = r3.isEmpty()
            if (r6 != 0) goto L_0x0174
            goto L_0x01e3
        L_0x0174:
            r6 = 1
            goto L_0x007d
        L_0x0177:
            throw r5
        L_0x0178:
            java.net.UnknownHostException r0 = new java.net.UnknownHostException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            g.a r2 = r2.f9210a
            g.m r2 = r2.f9127b
            r3.append(r2)
            java.lang.String r2 = " returned no addresses for "
            r3.append(r2)
            r3.append(r12)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0196:
            java.net.UnknownHostException r0 = new java.net.UnknownHostException
            java.lang.String r2 = "hostname == null"
            r0.<init>(r2)
            throw r0
        L_0x019e:
            throw r5
        L_0x019f:
            throw r5
        L_0x01a0:
            java.net.SocketException r0 = new java.net.SocketException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r12)
            java.lang.String r3 = ":"
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = "; port is out of range"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01c2:
            java.net.SocketException r0 = new java.net.SocketException
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r10)
            g.a r4 = r2.f9210a
            g.r r4 = r4.f9126a
            java.lang.String r4 = r4.f9538d
            r3.append(r4)
            java.lang.String r4 = "; exhausted proxy configurations: "
            r3.append(r4)
            java.util.List<java.net.Proxy> r2 = r2.f9214e
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x01e3:
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x01f3
            java.util.List<g.b0> r6 = r2.f9217h
            r3.addAll(r6)
            java.util.List<g.b0> r2 = r2.f9217h
            r2.clear()
        L_0x01f3:
            g.d0.e.f$a r2 = new g.d0.e.f$a
            r2.<init>(r3)
            r1.f9221b = r2
            r2 = 1
            goto L_0x0203
        L_0x01fc:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        L_0x0202:
            r2 = r4
        L_0x0203:
            g.h r3 = r1.f9223d
            monitor-enter(r3)
            boolean r6 = r1.m     // Catch:{ all -> 0x02e2 }
            if (r6 != 0) goto L_0x02da
            if (r2 == 0) goto L_0x023b
            g.d0.e.f$a r2 = r1.f9221b     // Catch:{ all -> 0x02e2 }
            if (r2 == 0) goto L_0x023a
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x02e2 }
            java.util.List<g.b0> r2 = r2.f9218a     // Catch:{ all -> 0x02e2 }
            r6.<init>(r2)     // Catch:{ all -> 0x02e2 }
            int r2 = r6.size()     // Catch:{ all -> 0x02e2 }
            r7 = r4
        L_0x021c:
            if (r7 >= r2) goto L_0x023b
            java.lang.Object r10 = r6.get(r7)     // Catch:{ all -> 0x02e2 }
            g.b0 r10 = (g.b0) r10     // Catch:{ all -> 0x02e2 }
            g.d0.a r11 = g.d0.a.f9172a     // Catch:{ all -> 0x02e2 }
            g.h r12 = r1.f9223d     // Catch:{ all -> 0x02e2 }
            g.a r13 = r1.f9220a     // Catch:{ all -> 0x02e2 }
            r11.a(r12, r13, r1, r10)     // Catch:{ all -> 0x02e2 }
            g.d0.e.c r11 = r1.f9229j     // Catch:{ all -> 0x02e2 }
            if (r11 == 0) goto L_0x0237
            g.d0.e.c r0 = r1.f9229j     // Catch:{ all -> 0x02e2 }
            r1.f9222c = r10     // Catch:{ all -> 0x02e2 }
            r8 = 1
            goto L_0x023b
        L_0x0237:
            int r7 = r7 + 1
            goto L_0x021c
        L_0x023a:
            throw r5     // Catch:{ all -> 0x02e2 }
        L_0x023b:
            if (r8 != 0) goto L_0x026b
            if (r9 != 0) goto L_0x025d
            g.d0.e.f$a r0 = r1.f9221b     // Catch:{ all -> 0x02e2 }
            boolean r2 = r0.a()     // Catch:{ all -> 0x02e2 }
            if (r2 == 0) goto L_0x0257
            java.util.List<g.b0> r2 = r0.f9218a     // Catch:{ all -> 0x02e2 }
            int r6 = r0.f9219b     // Catch:{ all -> 0x02e2 }
            int r7 = r6 + 1
            r0.f9219b = r7     // Catch:{ all -> 0x02e2 }
            java.lang.Object r0 = r2.get(r6)     // Catch:{ all -> 0x02e2 }
            r9 = r0
            g.b0 r9 = (g.b0) r9     // Catch:{ all -> 0x02e2 }
            goto L_0x025d
        L_0x0257:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ all -> 0x02e2 }
            r0.<init>()     // Catch:{ all -> 0x02e2 }
            throw r0     // Catch:{ all -> 0x02e2 }
        L_0x025d:
            r1.f9222c = r9     // Catch:{ all -> 0x02e2 }
            r1.f9228i = r4     // Catch:{ all -> 0x02e2 }
            g.d0.e.c r0 = new g.d0.e.c     // Catch:{ all -> 0x02e2 }
            g.h r2 = r1.f9223d     // Catch:{ all -> 0x02e2 }
            r0.<init>(r2, r9)     // Catch:{ all -> 0x02e2 }
            r1.a(r0, r4)     // Catch:{ all -> 0x02e2 }
        L_0x026b:
            monitor-exit(r3)     // Catch:{ all -> 0x02e2 }
            if (r8 == 0) goto L_0x0274
            g.n r2 = r1.f9225f
            if (r2 == 0) goto L_0x0273
            return r0
        L_0x0273:
            throw r5
        L_0x0274:
            g.e r15 = r1.f9224e
            g.n r2 = r1.f9225f
            r10 = r0
            r11 = r18
            r12 = r19
            r13 = r20
            r14 = r21
            r16 = r2
            r10.a(r11, r12, r13, r14, r15, r16)
            g.d0.a r2 = g.d0.a.f9172a
            g.h r3 = r1.f9223d
            g.u$a r2 = (g.u.a) r2
            if (r2 == 0) goto L_0x02d9
            g.d0.e.d r2 = r3.f9494e
            g.b0 r3 = r0.f9199c
            r2.a(r3)
            g.h r2 = r1.f9223d
            monitor-enter(r2)
            r3 = 1
            r1.k = r3     // Catch:{ all -> 0x02d6 }
            g.d0.a r3 = g.d0.a.f9172a     // Catch:{ all -> 0x02d6 }
            g.h r4 = r1.f9223d     // Catch:{ all -> 0x02d6 }
            g.u$a r3 = (g.u.a) r3     // Catch:{ all -> 0x02d6 }
            if (r3 == 0) goto L_0x02d5
            boolean r3 = r4.f9495f     // Catch:{ all -> 0x02d6 }
            if (r3 != 0) goto L_0x02b1
            r3 = 1
            r4.f9495f = r3     // Catch:{ all -> 0x02d6 }
            java.util.concurrent.Executor r3 = g.h.f9489g     // Catch:{ all -> 0x02d6 }
            java.lang.Runnable r6 = r4.f9492c     // Catch:{ all -> 0x02d6 }
            r3.execute(r6)     // Catch:{ all -> 0x02d6 }
        L_0x02b1:
            java.util.Deque<g.d0.e.c> r3 = r4.f9493d     // Catch:{ all -> 0x02d6 }
            r3.add(r0)     // Catch:{ all -> 0x02d6 }
            boolean r3 = r0.a()     // Catch:{ all -> 0x02d6 }
            if (r3 == 0) goto L_0x02c9
            g.d0.a r0 = g.d0.a.f9172a     // Catch:{ all -> 0x02d6 }
            g.h r3 = r1.f9223d     // Catch:{ all -> 0x02d6 }
            g.a r4 = r1.f9220a     // Catch:{ all -> 0x02d6 }
            java.net.Socket r0 = r0.a(r3, r4, r1)     // Catch:{ all -> 0x02d6 }
            g.d0.e.c r3 = r1.f9229j     // Catch:{ all -> 0x02d6 }
            goto L_0x02cb
        L_0x02c9:
            r3 = r0
            r0 = r5
        L_0x02cb:
            monitor-exit(r2)     // Catch:{ all -> 0x02d6 }
            g.d0.c.a(r0)
            g.n r0 = r1.f9225f
            if (r0 == 0) goto L_0x02d4
            return r3
        L_0x02d4:
            throw r5
        L_0x02d5:
            throw r5     // Catch:{ all -> 0x02d6 }
        L_0x02d6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x02d6 }
            throw r0
        L_0x02d9:
            throw r5
        L_0x02da:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02e2 }
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch:{ all -> 0x02e2 }
            throw r0     // Catch:{ all -> 0x02e2 }
        L_0x02e2:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x02e2 }
            throw r0
        L_0x02e5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "Canceled"
            r0.<init>(r3)     // Catch:{ all -> 0x02fd }
            throw r0     // Catch:{ all -> 0x02fd }
        L_0x02ed:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "codec != null"
            r0.<init>(r3)     // Catch:{ all -> 0x02fd }
            throw r0     // Catch:{ all -> 0x02fd }
        L_0x02f5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "released"
            r0.<init>(r3)     // Catch:{ all -> 0x02fd }
            throw r0     // Catch:{ all -> 0x02fd }
        L_0x02fd:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x02fd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.e.g.a(int, int, int, boolean):g.d0.e.c");
    }

    public void a(boolean z, c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        if (this.f9225f != null) {
            synchronized (this.f9223d) {
                if (cVar != null) {
                    if (cVar == this.n) {
                        if (!z) {
                            this.f9229j.l++;
                        }
                        cVar2 = this.f9229j;
                        a2 = a(z, false, true);
                        if (this.f9229j != null) {
                            cVar2 = null;
                        }
                        z2 = this.l;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.n);
                sb.append(" but was ");
                sb.append(cVar);
                throw new IllegalStateException(sb.toString());
            }
            g.d0.c.a(a2);
            if (cVar2 != null && this.f9225f == null) {
                throw null;
            } else if (iOException != null) {
                if (this.f9225f == null) {
                    throw null;
                }
            } else if (z2 && this.f9225f == null) {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public final Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.n = null;
        }
        boolean z4 = true;
        if (z2) {
            this.l = true;
        }
        c cVar = this.f9229j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.k = true;
        }
        if (this.n != null) {
            return null;
        }
        if (!this.l && !this.f9229j.k) {
            return null;
        }
        c cVar2 = this.f9229j;
        int size = cVar2.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((Reference) cVar2.n.get(i2)).get() == this) {
                cVar2.n.remove(i2);
                if (this.f9229j.n.isEmpty()) {
                    this.f9229j.o = System.nanoTime();
                    g.d0.a aVar = g.d0.a.f9172a;
                    h hVar = this.f9223d;
                    c cVar3 = this.f9229j;
                    if (((g.u.a) aVar) == null) {
                        throw null;
                    } else if (hVar != null) {
                        if (cVar3.k || hVar.f9490a == 0) {
                            hVar.f9493d.remove(cVar3);
                        } else {
                            hVar.notifyAll();
                            z4 = false;
                        }
                        if (z4) {
                            socket = this.f9229j.f9201e;
                            this.f9229j = null;
                            return socket;
                        }
                    } else {
                        throw null;
                    }
                }
                socket = null;
                this.f9229j = null;
                return socket;
            }
        }
        throw new IllegalStateException();
    }

    public void a() {
        c cVar;
        c cVar2;
        synchronized (this.f9223d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.f9229j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            g.d0.c.a(cVar2.f9200d);
        }
    }

    public void a(IOException iOException) {
        boolean z;
        c cVar;
        Socket a2;
        synchronized (this.f9223d) {
            if (iOException instanceof t) {
                t tVar = (t) iOException;
                if (tVar.f9435a == b.REFUSED_STREAM) {
                    this.f9228i++;
                }
                if (tVar.f9435a != b.REFUSED_STREAM || this.f9228i > 1) {
                    this.f9222c = null;
                }
                z = false;
                cVar = this.f9229j;
                a2 = a(z, false, true);
                if (this.f9229j != null || !this.k) {
                    cVar = null;
                }
            } else {
                if (this.f9229j != null && (!this.f9229j.a() || (iOException instanceof g.d0.h.a))) {
                    if (this.f9229j.l == 0) {
                        if (!(this.f9222c == null || iOException == null)) {
                            f fVar = this.f9227h;
                            b0 b0Var = this.f9222c;
                            if (fVar != null) {
                                if (b0Var.f9145b.type() != Type.DIRECT) {
                                    g.a aVar = fVar.f9210a;
                                    ProxySelector proxySelector = aVar.f9132g;
                                    if (proxySelector != null) {
                                        proxySelector.connectFailed(aVar.f9126a.f(), b0Var.f9145b.address(), iOException);
                                    }
                                }
                                fVar.f9211b.b(b0Var);
                            } else {
                                throw null;
                            }
                        }
                        this.f9222c = null;
                    }
                }
                z = false;
                cVar = this.f9229j;
                a2 = a(z, false, true);
                cVar = null;
            }
            z = true;
            cVar = this.f9229j;
            a2 = a(z, false, true);
            cVar = null;
        }
        g.d0.c.a(a2);
        if (cVar != null && this.f9225f == null) {
            throw null;
        }
    }

    public void a(c cVar, boolean z) {
        if (this.f9229j == null) {
            this.f9229j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.f9226g));
            return;
        }
        throw new IllegalStateException();
    }
}
