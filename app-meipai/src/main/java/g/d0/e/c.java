package g.d0.e;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidubce.http.Headers;
import com.facebook.stetho.websocket.WebSocketHandler;
import e.a.a.a.a;
import g.b0;
import g.d0.h.b;
import g.d0.h.g;
import g.d0.h.g.e;
import g.h;
import g.n;
import g.p;
import g.u;
import g.v;
import g.x;
import g.z;
import h.f;
import h.o;
import h.r;
import h.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: RealConnection */
public final class c extends e {

    /* renamed from: b reason: collision with root package name */
    public final h f9198b;

    /* renamed from: c reason: collision with root package name */
    public final b0 f9199c;

    /* renamed from: d reason: collision with root package name */
    public Socket f9200d;

    /* renamed from: e reason: collision with root package name */
    public Socket f9201e;

    /* renamed from: f reason: collision with root package name */
    public p f9202f;

    /* renamed from: g reason: collision with root package name */
    public v f9203g;

    /* renamed from: h reason: collision with root package name */
    public g f9204h;

    /* renamed from: i reason: collision with root package name */
    public h.g f9205i;

    /* renamed from: j reason: collision with root package name */
    public f f9206j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = RecyclerView.FOREVER_NS;

    public c(h hVar, b0 b0Var) {
        this.f9198b = hVar;
        this.f9199c = b0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x010c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x010c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x010c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x010c, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r10, int r11, int r12, boolean r13, g.e r14, g.n r15) {
        /*
            r9 = this;
            g.v r0 = r9.f9203g
            if (r0 != 0) goto L_0x0112
            g.b0 r0 = r9.f9199c
            g.a r0 = r0.f9144a
            java.util.List<g.i> r0 = r0.f9131f
            g.d0.e.b r1 = new g.d0.e.b
            r1.<init>(r0)
            g.b0 r2 = r9.f9199c
            g.a r2 = r2.f9144a
            javax.net.ssl.SSLSocketFactory r2 = r2.f9134i
            if (r2 != 0) goto L_0x0050
            g.i r2 = g.i.f9499g
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0043
            g.b0 r0 = r9.f9199c
            g.a r0 = r0.f9144a
            g.r r0 = r0.f9126a
            java.lang.String r0 = r0.f9538d
            g.d0.i.e r2 = g.d0.i.e.f9461a
            boolean r2 = r2.b(r0)
            if (r2 == 0) goto L_0x0030
            goto L_0x0050
        L_0x0030:
            g.d0.e.e r10 = new g.d0.e.e
            java.net.UnknownServiceException r11 = new java.net.UnknownServiceException
            java.lang.String r12 = "CLEARTEXT communication to "
            java.lang.String r13 = " not permitted by network security policy"
            java.lang.String r12 = e.a.a.a.a.a(r12, r0, r13)
            r11.<init>(r12)
            r10.<init>(r11)
            throw r10
        L_0x0043:
            g.d0.e.e r10 = new g.d0.e.e
            java.net.UnknownServiceException r11 = new java.net.UnknownServiceException
            java.lang.String r12 = "CLEARTEXT communication not enabled for client"
            r11.<init>(r12)
            r10.<init>(r11)
            throw r10
        L_0x0050:
            r0 = 0
            r2 = r0
        L_0x0052:
            g.b0 r3 = r9.f9199c     // Catch:{ IOException -> 0x00a8 }
            boolean r3 = r3.a()     // Catch:{ IOException -> 0x00a8 }
            if (r3 == 0) goto L_0x0068
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            r8 = r15
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ IOException -> 0x00a8 }
            java.net.Socket r3 = r9.f9200d     // Catch:{ IOException -> 0x00a8 }
            if (r3 != 0) goto L_0x006b
            goto L_0x0078
        L_0x0068:
            r9.a(r10, r11, r14, r15)     // Catch:{ IOException -> 0x00a8 }
        L_0x006b:
            r9.a(r1, r14, r15)     // Catch:{ IOException -> 0x00a8 }
            g.b0 r3 = r9.f9199c     // Catch:{ IOException -> 0x00a8 }
            java.net.InetSocketAddress r3 = r3.f9146c     // Catch:{ IOException -> 0x00a8 }
            g.b0 r3 = r9.f9199c     // Catch:{ IOException -> 0x00a8 }
            java.net.Proxy r3 = r3.f9145b     // Catch:{ IOException -> 0x00a8 }
            if (r15 == 0) goto L_0x00a7
        L_0x0078:
            g.b0 r10 = r9.f9199c
            boolean r10 = r10.a()
            if (r10 == 0) goto L_0x0092
            java.net.Socket r10 = r9.f9200d
            if (r10 == 0) goto L_0x0085
            goto L_0x0092
        L_0x0085:
            java.net.ProtocolException r10 = new java.net.ProtocolException
            java.lang.String r11 = "Too many tunnel connections attempted: 21"
            r10.<init>(r11)
            g.d0.e.e r11 = new g.d0.e.e
            r11.<init>(r10)
            throw r11
        L_0x0092:
            g.d0.h.g r10 = r9.f9204h
            if (r10 == 0) goto L_0x00a6
            g.h r10 = r9.f9198b
            monitor-enter(r10)
            g.d0.h.g r11 = r9.f9204h     // Catch:{ all -> 0x00a3 }
            int r11 = r11.b()     // Catch:{ all -> 0x00a3 }
            r9.m = r11     // Catch:{ all -> 0x00a3 }
            monitor-exit(r10)     // Catch:{ all -> 0x00a3 }
            goto L_0x00a6
        L_0x00a3:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00a3 }
            throw r11
        L_0x00a6:
            return
        L_0x00a7:
            throw r0     // Catch:{ IOException -> 0x00a8 }
        L_0x00a8:
            r3 = move-exception
            java.net.Socket r4 = r9.f9201e
            g.d0.c.a(r4)
            java.net.Socket r4 = r9.f9200d
            g.d0.c.a(r4)
            r9.f9201e = r0
            r9.f9200d = r0
            r9.f9205i = r0
            r9.f9206j = r0
            r9.f9202f = r0
            r9.f9203g = r0
            r9.f9204h = r0
            g.b0 r4 = r9.f9199c
            java.net.InetSocketAddress r4 = r4.f9146c
            if (r15 == 0) goto L_0x0111
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x00d1
            g.d0.e.e r2 = new g.d0.e.e
            r2.<init>(r3)
            goto L_0x00e0
        L_0x00d1:
            java.io.IOException r6 = r2.f9209a
            java.lang.reflect.Method r7 = g.d0.e.e.f9208b
            if (r7 == 0) goto L_0x00de
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00de }
            r8[r4] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00de }
            r7.invoke(r3, r8)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x00de }
        L_0x00de:
            r2.f9209a = r3
        L_0x00e0:
            if (r13 == 0) goto L_0x0110
            r1.f9197d = r5
            boolean r6 = r1.f9196c
            if (r6 != 0) goto L_0x00e9
            goto L_0x010c
        L_0x00e9:
            boolean r6 = r3 instanceof java.net.ProtocolException
            if (r6 == 0) goto L_0x00ee
            goto L_0x010c
        L_0x00ee:
            boolean r6 = r3 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L_0x00f3
            goto L_0x010c
        L_0x00f3:
            boolean r6 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L_0x0100
            java.lang.Throwable r7 = r3.getCause()
            boolean r7 = r7 instanceof java.security.cert.CertificateException
            if (r7 == 0) goto L_0x0100
            goto L_0x010c
        L_0x0100:
            boolean r7 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r7 == 0) goto L_0x0105
            goto L_0x010c
        L_0x0105:
            if (r6 != 0) goto L_0x010b
            boolean r3 = r3 instanceof javax.net.ssl.SSLProtocolException
            if (r3 == 0) goto L_0x010c
        L_0x010b:
            r4 = r5
        L_0x010c:
            if (r4 == 0) goto L_0x0110
            goto L_0x0052
        L_0x0110:
            throw r2
        L_0x0111:
            throw r0
        L_0x0112:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "already connected"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.e.c.a(int, int, int, boolean, g.e, g.n):void");
    }

    public String toString() {
        StringBuilder a2 = a.a("Connection{");
        a2.append(this.f9199c.f9144a.f9126a.f9538d);
        a2.append(Config.TRACE_TODAY_VISIT_SPLIT);
        a2.append(this.f9199c.f9144a.f9126a.f9539e);
        a2.append(", proxy=");
        a2.append(this.f9199c.f9145b);
        a2.append(" hostAddress=");
        a2.append(this.f9199c.f9146c);
        a2.append(" cipherSuite=");
        p pVar = this.f9202f;
        a2.append(pVar != null ? pVar.f9529b : "none");
        a2.append(" protocol=");
        a2.append(this.f9203g);
        a2.append('}');
        return a2.toString();
    }

    public final void a(int i2, int i3, g.e eVar, n nVar) throws IOException {
        Socket socket;
        b0 b0Var = this.f9199c;
        Proxy proxy = b0Var.f9145b;
        g.a aVar = b0Var.f9144a;
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) {
            socket = aVar.f9128c.createSocket();
        } else {
            socket = new Socket(proxy);
        }
        this.f9200d = socket;
        InetSocketAddress inetSocketAddress = this.f9199c.f9146c;
        if (nVar != null) {
            socket.setSoTimeout(i3);
            try {
                g.d0.i.e.f9461a.a(this.f9200d, this.f9199c.f9146c, i2);
                try {
                    this.f9205i = new s(o.b(this.f9200d));
                    this.f9206j = new r(o.a(this.f9200d));
                } catch (NullPointerException e2) {
                    if ("throw with null exception".equals(e2.getMessage())) {
                        throw new IOException(e2);
                    }
                }
            } catch (ConnectException e3) {
                StringBuilder a2 = a.a("Failed to connect to ");
                a2.append(this.f9199c.f9146c);
                ConnectException connectException = new ConnectException(a2.toString());
                connectException.initCause(e3);
                throw connectException;
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0146 A[Catch:{ all -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014c A[Catch:{ all -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0150  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(g.d0.e.b r7, g.e r8, g.n r9) throws java.io.IOException {
        /*
            r6 = this;
            g.b0 r8 = r6.f9199c
            g.a r8 = r8.f9144a
            javax.net.ssl.SSLSocketFactory r0 = r8.f9134i
            if (r0 != 0) goto L_0x0011
            g.v r7 = g.v.HTTP_1_1
            r6.f9203g = r7
            java.net.Socket r7 = r6.f9200d
            r6.f9201e = r7
            return
        L_0x0011:
            r1 = 0
            if (r9 == 0) goto L_0x0159
            java.net.Socket r9 = r6.f9200d     // Catch:{ AssertionError -> 0x013f }
            g.r r2 = r8.f9126a     // Catch:{ AssertionError -> 0x013f }
            java.lang.String r2 = r2.f9538d     // Catch:{ AssertionError -> 0x013f }
            g.r r3 = r8.f9126a     // Catch:{ AssertionError -> 0x013f }
            int r3 = r3.f9539e     // Catch:{ AssertionError -> 0x013f }
            r4 = 1
            java.net.Socket r9 = r0.createSocket(r9, r2, r3, r4)     // Catch:{ AssertionError -> 0x013f }
            javax.net.ssl.SSLSocket r9 = (javax.net.ssl.SSLSocket) r9     // Catch:{ AssertionError -> 0x013f }
            g.i r7 = r7.a(r9)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            boolean r0 = r7.f9501b     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            if (r0 == 0) goto L_0x0038
            g.d0.i.e r0 = g.d0.i.e.f9461a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.r r2 = r8.f9126a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r2 = r2.f9538d     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.util.List<g.v> r3 = r8.f9130e     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r0.a(r9, r2, r3)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
        L_0x0038:
            r9.startHandshake()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            javax.net.ssl.SSLSession r0 = r9.getSession()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.p r0 = g.p.a(r0)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            javax.net.ssl.HostnameVerifier r2 = r8.f9135j     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.r r3 = r8.f9126a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r3 = r3.f9538d     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            javax.net.ssl.SSLSession r5 = r9.getSession()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            boolean r2 = r2.verify(r3, r5)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r3 = 0
            if (r2 == 0) goto L_0x00ed
            g.f r2 = r8.k     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.r r8 = r8.f9126a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = r8.f9538d     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.util.List<java.security.cert.Certificate> r5 = r0.f9530c     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r2.a(r8, r5)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            boolean r7 = r7.f9501b     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            if (r7 == 0) goto L_0x0069
            g.d0.i.e r7 = g.d0.i.e.f9461a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r1 = r7.b(r9)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
        L_0x0069:
            r6.f9201e = r9     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            h.x r7 = h.o.b(r9)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            h.s r8 = new h.s     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r8.<init>(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r6.f9205i = r8     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.net.Socket r7 = r6.f9201e     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            h.w r7 = h.o.a(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            h.r r8 = new h.r     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r8.<init>(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r6.f9206j = r8     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r6.f9202f = r0     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            if (r1 == 0) goto L_0x008c
            g.v r7 = g.v.a(r1)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            goto L_0x008e
        L_0x008c:
            g.v r7 = g.v.HTTP_1_1     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
        L_0x008e:
            r6.f9203g = r7     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.d0.i.e r7 = g.d0.i.e.f9461a
            r7.a(r9)
            g.v r7 = r6.f9203g
            g.v r8 = g.v.HTTP_2
            if (r7 != r8) goto L_0x00ec
            java.net.Socket r7 = r6.f9201e
            r7.setSoTimeout(r3)
            g.d0.h.g$d r7 = new g.d0.h.g$d
            r7.<init>(r4)
            java.net.Socket r8 = r6.f9201e
            g.b0 r9 = r6.f9199c
            g.a r9 = r9.f9144a
            g.r r9 = r9.f9126a
            java.lang.String r9 = r9.f9538d
            h.g r0 = r6.f9205i
            h.f r1 = r6.f9206j
            r7.f9352a = r8
            r7.f9353b = r9
            r7.f9354c = r0
            r7.f9355d = r1
            r7.f9356e = r6
            g.d0.h.g r8 = new g.d0.h.g
            r8.<init>(r7)
            r6.f9204h = r8
            g.d0.h.o r7 = r8.q
            r7.a()
            g.d0.h.o r7 = r8.q
            g.d0.h.s r9 = r8.m
            r7.b(r9)
            g.d0.h.s r7 = r8.m
            int r7 = r7.a()
            r9 = 65535(0xffff, float:9.1834E-41)
            if (r7 == r9) goto L_0x00e2
            g.d0.h.o r0 = r8.q
            int r7 = r7 - r9
            long r1 = (long) r7
            r0.a(r3, r1)
        L_0x00e2:
            java.lang.Thread r7 = new java.lang.Thread
            g.d0.h.g$f r8 = r8.r
            r7.<init>(r8)
            r7.start()
        L_0x00ec:
            return
        L_0x00ed:
            java.util.List<java.security.cert.Certificate> r7 = r0.f9530c     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.Object r7 = r7.get(r3)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            javax.net.ssl.SSLPeerUnverifiedException r0 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r1.<init>()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r2 = "Hostname "
            r1.append(r2)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            g.r r8 = r8.f9126a     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = r8.f9538d     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = " not verified:\n    certificate: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = g.f.a(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = "\n    DN: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.security.Principal r8 = r7.getSubjectDN()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = r8.getName()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r8 = "\n    subjectAltNames: "
            r1.append(r8)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.util.List r7 = g.d0.j.e.a(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r1.append(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            java.lang.String r7 = r1.toString()     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            r0.<init>(r7)     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
            throw r0     // Catch:{ AssertionError -> 0x013a, all -> 0x0138 }
        L_0x0138:
            r7 = move-exception
            goto L_0x014e
        L_0x013a:
            r7 = move-exception
            r1 = r9
            goto L_0x0140
        L_0x013d:
            r7 = move-exception
            goto L_0x014d
        L_0x013f:
            r7 = move-exception
        L_0x0140:
            boolean r8 = g.d0.c.a(r7)     // Catch:{ all -> 0x013d }
            if (r8 == 0) goto L_0x014c
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x013d }
            r8.<init>(r7)     // Catch:{ all -> 0x013d }
            throw r8     // Catch:{ all -> 0x013d }
        L_0x014c:
            throw r7     // Catch:{ all -> 0x013d }
        L_0x014d:
            r9 = r1
        L_0x014e:
            if (r9 == 0) goto L_0x0155
            g.d0.i.e r8 = g.d0.i.e.f9461a
            r8.a(r9)
        L_0x0155:
            g.d0.c.a(r9)
            throw r7
        L_0x0159:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.e.c.a(g.d0.e.b, g.e, g.n):void");
    }

    public final void a(int i2, int i3, int i4, g.e eVar, n nVar) throws IOException {
        x.a aVar = new x.a();
        aVar.a(this.f9199c.f9144a.f9126a);
        boolean z = true;
        aVar.b(Headers.HOST, g.d0.c.a(this.f9199c.f9144a.f9126a, true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b("User-Agent", "okhttp/3.9.0");
        x a2 = aVar.a();
        g.r rVar = a2.f9595a;
        int i5 = 0;
        while (i5 < 21) {
            a(i2, i3, eVar, nVar);
            StringBuilder sb = new StringBuilder();
            sb.append("CONNECT ");
            sb.append(g.d0.c.a(rVar, z));
            sb.append(" HTTP/1.1");
            String sb2 = sb.toString();
            while (true) {
                g.d0.g.a aVar2 = new g.d0.g.a(null, null, this.f9205i, this.f9206j);
                this.f9205i.timeout().a((long) i3, TimeUnit.MILLISECONDS);
                this.f9206j.timeout().a((long) i4, TimeUnit.MILLISECONDS);
                aVar2.a(a2.f9597c, sb2);
                aVar2.f9261d.flush();
                z.a a3 = aVar2.a(false);
                a3.f9624a = a2;
                z a4 = a3.a();
                long a5 = g.d0.f.e.a(a4);
                if (a5 == -1) {
                    a5 = 0;
                }
                h.x a6 = aVar2.a(a5);
                g.d0.c.b(a6, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                ((g.d0.g.a.f) a6).close();
                int i6 = a4.f9616c;
                if (i6 != 200) {
                    if (i6 == 407) {
                        b0 b0Var = this.f9199c;
                        x authenticate = b0Var.f9144a.f9129d.authenticate(b0Var, a4);
                        if (authenticate != null) {
                            String a7 = a4.f9619f.a(WebSocketHandler.HEADER_CONNECTION);
                            if (a7 == null) {
                                a7 = null;
                            }
                            if (LivenessStat.TYPE_VOICE_CLOSE.equalsIgnoreCase(a7)) {
                                a2 = authenticate;
                                break;
                            }
                            a2 = authenticate;
                        } else {
                            throw new IOException("Failed to authenticate with proxy");
                        }
                    } else {
                        StringBuilder a8 = a.a("Unexpected response code for CONNECT: ");
                        a8.append(a4.f9616c);
                        throw new IOException(a8.toString());
                    }
                } else if (!this.f9205i.c().g() || !this.f9206j.c().g()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                } else {
                    a2 = null;
                }
            }
            if (a2 != null) {
                g.d0.c.a(this.f9200d);
                this.f9200d = null;
                this.f9206j = null;
                this.f9205i = null;
                InetSocketAddress inetSocketAddress = this.f9199c.f9146c;
                i5++;
                z = true;
            } else {
                return;
            }
        }
    }

    public boolean a(g.a aVar, b0 b0Var) {
        if (this.n.size() >= this.m || this.k) {
            return false;
        }
        g.d0.a aVar2 = g.d0.a.f9172a;
        g.a aVar3 = this.f9199c.f9144a;
        if (((u.a) aVar2) == null) {
            throw null;
        } else if (!aVar3.a(aVar)) {
            return false;
        } else {
            if (aVar.f9126a.f9538d.equals(this.f9199c.f9144a.f9126a.f9538d)) {
                return true;
            }
            if (this.f9204h == null || b0Var == null || b0Var.f9145b.type() != Type.DIRECT || this.f9199c.f9145b.type() != Type.DIRECT || !this.f9199c.f9146c.equals(b0Var.f9146c) || b0Var.f9144a.f9135j != g.d0.j.e.f9472a || !a(aVar.f9126a)) {
                return false;
            }
            try {
                aVar.k.a(aVar.f9126a.f9538d, this.f9202f.f9530c);
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public g.d0.f.c a(u uVar, g.s.a aVar, g gVar) throws SocketException {
        if (this.f9204h != null) {
            return new g.d0.h.f(uVar, aVar, gVar, this.f9204h);
        }
        g.d0.f.f fVar = (g.d0.f.f) aVar;
        this.f9201e.setSoTimeout(fVar.f9246j);
        this.f9205i.timeout().a((long) fVar.f9246j, TimeUnit.MILLISECONDS);
        this.f9206j.timeout().a((long) fVar.k, TimeUnit.MILLISECONDS);
        return new g.d0.g.a(uVar, gVar, this.f9205i, this.f9206j);
    }

    public boolean a(g.r rVar) {
        int i2 = rVar.f9539e;
        g.r rVar2 = this.f9199c.f9144a.f9126a;
        boolean z = false;
        if (i2 != rVar2.f9539e) {
            return false;
        }
        if (rVar.f9538d.equals(rVar2.f9538d)) {
            return true;
        }
        p pVar = this.f9202f;
        if (pVar != null && g.d0.j.e.f9472a.a(rVar.f9538d, (X509Certificate) pVar.f9530c.get(0))) {
            z = true;
        }
        return z;
    }

    public void a(g.d0.h.n nVar) throws IOException {
        nVar.a(b.REFUSED_STREAM);
    }

    public void a(g gVar) {
        synchronized (this.f9198b) {
            this.m = gVar.b();
        }
    }

    public boolean a() {
        return this.f9204h != null;
    }
}
