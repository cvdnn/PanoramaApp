package g.d0.f;

import g.a;
import g.d0.e.g;
import g.f;
import g.r;
import g.s;
import g.u;
import g.z;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RetryAndFollowUpInterceptor */
public final class h implements s {

    /* renamed from: a reason: collision with root package name */
    public final u f9250a;

    /* renamed from: b reason: collision with root package name */
    public final boolean f9251b;

    /* renamed from: c reason: collision with root package name */
    public g f9252c;

    /* renamed from: d reason: collision with root package name */
    public Object f9253d;

    /* renamed from: e reason: collision with root package name */
    public volatile boolean f9254e;

    public h(u uVar, boolean z) {
        this.f9250a = uVar;
        this.f9251b = z;
    }

    public final boolean a(z zVar, r rVar) {
        r rVar2 = zVar.f9614a.f9595a;
        return rVar2.f9538d.equals(rVar.f9538d) && rVar2.f9539e == rVar.f9539e && rVar2.f9535a.equals(rVar.f9535a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d3, code lost:
        if (r5.equals("HEAD") == false) goto L_0x0120;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x017b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g.z intercept(g.s.a r15) throws java.io.IOException {
        /*
            r14 = this;
            g.d0.f.f r15 = (g.d0.f.f) r15
            g.x r0 = r15.f9242f
            g.e r7 = r15.f9243g
            g.n r8 = r15.f9244h
            g.d0.e.g r9 = new g.d0.e.g
            g.u r1 = r14.f9250a
            g.h r2 = r1.s
            g.r r1 = r0.f9595a
            g.a r3 = r14.a(r1)
            java.lang.Object r6 = r14.f9253d
            r1 = r9
            r4 = r7
            r5 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r14.f9252c = r9
            r9 = 0
            r10 = 0
            r2 = r9
            r1 = r10
        L_0x0022:
            boolean r3 = r14.f9254e
            if (r3 != 0) goto L_0x0221
            r3 = 1
            g.d0.e.g r4 = r14.f9252c     // Catch:{ e -> 0x0208, IOException -> 0x01f8 }
            g.z r0 = r15.a(r0, r4, r10, r10)     // Catch:{ e -> 0x0208, IOException -> 0x01f8 }
            if (r1 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0054
            g.z$a r4 = new g.z$a
            r4.<init>(r0)
            g.z$a r0 = new g.z$a
            r0.<init>(r1)
            r0.f9630g = r10
            g.z r0 = r0.a()
            g.a0 r1 = r0.f9620g
            if (r1 != 0) goto L_0x004c
            r4.f9633j = r0
            g.z r0 = r4.a()
            goto L_0x0055
        L_0x004c:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "priorResponse.body != null"
            r15.<init>(r0)
            throw r15
        L_0x0054:
            throw r10
        L_0x0055:
            if (r0 == 0) goto L_0x01f0
            g.d0.e.g r1 = r14.f9252c
            g.d0.e.c r1 = r1.c()
            if (r1 == 0) goto L_0x0062
            g.b0 r1 = r1.f9199c
            goto L_0x0063
        L_0x0062:
            r1 = r10
        L_0x0063:
            int r4 = r0.f9616c
            g.x r5 = r0.f9614a
            java.lang.String r5 = r5.f9596b
            r6 = 307(0x133, float:4.3E-43)
            java.lang.String r11 = "GET"
            if (r4 == r6) goto L_0x00c7
            r6 = 308(0x134, float:4.32E-43)
            if (r4 == r6) goto L_0x00c7
            r6 = 401(0x191, float:5.62E-43)
            if (r4 == r6) goto L_0x00bd
            r6 = 407(0x197, float:5.7E-43)
            if (r4 == r6) goto L_0x009a
            r1 = 408(0x198, float:5.72E-43)
            if (r4 == r1) goto L_0x0084
            switch(r4) {
                case 300: goto L_0x00d6;
                case 301: goto L_0x00d6;
                case 302: goto L_0x00d6;
                case 303: goto L_0x00d6;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x0120
        L_0x0084:
            g.u r3 = r14.f9250a
            boolean r3 = r3.w
            if (r3 != 0) goto L_0x008c
            goto L_0x0120
        L_0x008c:
            g.z r3 = r0.f9623j
            if (r3 == 0) goto L_0x0096
            int r3 = r3.f9616c
            if (r3 != r1) goto L_0x0096
            goto L_0x0120
        L_0x0096:
            g.x r1 = r0.f9614a
            goto L_0x0178
        L_0x009a:
            if (r1 == 0) goto L_0x009f
            java.net.Proxy r3 = r1.f9145b
            goto L_0x00a3
        L_0x009f:
            g.u r3 = r14.f9250a
            java.net.Proxy r3 = r3.f9562b
        L_0x00a3:
            java.net.Proxy$Type r3 = r3.type()
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP
            if (r3 != r4) goto L_0x00b5
            g.u r3 = r14.f9250a
            g.b r3 = r3.q
            g.x r1 = r3.authenticate(r1, r0)
            goto L_0x0178
        L_0x00b5:
            java.net.ProtocolException r15 = new java.net.ProtocolException
            java.lang.String r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r15.<init>(r0)
            throw r15
        L_0x00bd:
            g.u r3 = r14.f9250a
            g.b r3 = r3.r
            g.x r1 = r3.authenticate(r1, r0)
            goto L_0x0178
        L_0x00c7:
            boolean r1 = r5.equals(r11)
            if (r1 != 0) goto L_0x00d6
            java.lang.String r1 = "HEAD"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x00d6
            goto L_0x0120
        L_0x00d6:
            g.u r1 = r14.f9250a
            boolean r1 = r1.v
            if (r1 != 0) goto L_0x00dd
            goto L_0x0120
        L_0x00dd:
            g.q r1 = r0.f9619f
            java.lang.String r4 = "Location"
            java.lang.String r1 = r1.a(r4)
            if (r1 == 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r1 = r10
        L_0x00e9:
            if (r1 != 0) goto L_0x00ec
            goto L_0x0120
        L_0x00ec:
            g.x r4 = r0.f9614a
            g.r r4 = r4.f9595a
            if (r4 == 0) goto L_0x01ef
            g.r$a r6 = new g.r$a
            r6.<init>()
            g.r$a$a r1 = r6.a(r4, r1)
            g.r$a$a r4 = g.r.a.C0141a.SUCCESS
            if (r1 != r4) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r6 = r10
        L_0x0101:
            if (r6 == 0) goto L_0x0108
            g.r r1 = r6.a()
            goto L_0x0109
        L_0x0108:
            r1 = r10
        L_0x0109:
            if (r1 != 0) goto L_0x010c
            goto L_0x0120
        L_0x010c:
            java.lang.String r4 = r1.f9535a
            g.x r6 = r0.f9614a
            g.r r6 = r6.f9595a
            java.lang.String r6 = r6.f9535a
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0122
            g.u r4 = r14.f9250a
            boolean r4 = r4.u
            if (r4 != 0) goto L_0x0122
        L_0x0120:
            r11 = r10
            goto L_0x0179
        L_0x0122:
            g.x r4 = r0.f9614a
            if (r4 == 0) goto L_0x01ee
            g.x$a r6 = new g.x$a
            r6.<init>(r4)
            boolean r4 = e.c.f.n.n.b(r5)
            if (r4 == 0) goto L_0x0164
            java.lang.String r4 = "PROPFIND"
            boolean r12 = r5.equals(r4)
            boolean r4 = r5.equals(r4)
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0142
            r6.a(r11, r10)
            goto L_0x014d
        L_0x0142:
            if (r12 == 0) goto L_0x0149
            g.x r3 = r0.f9614a
            g.y r3 = r3.f9598d
            goto L_0x014a
        L_0x0149:
            r3 = r10
        L_0x014a:
            r6.a(r5, r3)
        L_0x014d:
            if (r12 != 0) goto L_0x0164
            g.q$a r3 = r6.f9603c
            java.lang.String r4 = "Transfer-Encoding"
            r3.a(r4)
            g.q$a r3 = r6.f9603c
            java.lang.String r4 = "Content-Length"
            r3.a(r4)
            g.q$a r3 = r6.f9603c
            java.lang.String r4 = "Content-Type"
            r3.a(r4)
        L_0x0164:
            boolean r3 = r14.a(r0, r1)
            if (r3 != 0) goto L_0x0171
            g.q$a r3 = r6.f9603c
            java.lang.String r4 = "Authorization"
            r3.a(r4)
        L_0x0171:
            r6.a(r1)
            g.x r1 = r6.a()
        L_0x0178:
            r11 = r1
        L_0x0179:
            if (r11 != 0) goto L_0x0185
            boolean r15 = r14.f9251b
            if (r15 != 0) goto L_0x0184
            g.d0.e.g r15 = r14.f9252c
            r15.e()
        L_0x0184:
            return r0
        L_0x0185:
            g.a0 r1 = r0.f9620g
            g.d0.c.a(r1)
            int r12 = r2 + 1
            r1 = 20
            if (r12 > r1) goto L_0x01dd
            g.r r1 = r11.f9595a
            boolean r1 = r14.a(r0, r1)
            if (r1 != 0) goto L_0x01b4
            g.d0.e.g r1 = r14.f9252c
            r1.e()
            g.d0.e.g r13 = new g.d0.e.g
            g.u r1 = r14.f9250a
            g.h r2 = r1.s
            g.r r1 = r11.f9595a
            g.a r3 = r14.a(r1)
            java.lang.Object r6 = r14.f9253d
            r1 = r13
            r4 = r7
            r5 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r14.f9252c = r13
            goto L_0x01bc
        L_0x01b4:
            g.d0.e.g r1 = r14.f9252c
            g.d0.f.c r1 = r1.b()
            if (r1 != 0) goto L_0x01c1
        L_0x01bc:
            r1 = r0
            r0 = r11
            r2 = r12
            goto L_0x0022
        L_0x01c1:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Closing the body of "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " didn't close its backing stream. Bad interceptor?"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r15.<init>(r0)
            throw r15
        L_0x01dd:
            g.d0.e.g r15 = r14.f9252c
            r15.e()
            java.net.ProtocolException r15 = new java.net.ProtocolException
            java.lang.String r0 = "Too many follow-up requests: "
            java.lang.String r0 = e.a.a.a.a.a(r0, r12)
            r15.<init>(r0)
            throw r15
        L_0x01ee:
            throw r10
        L_0x01ef:
            throw r10
        L_0x01f0:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>()
            throw r15
        L_0x01f6:
            r15 = move-exception
            goto L_0x0216
        L_0x01f8:
            r4 = move-exception
            boolean r5 = r4 instanceof g.d0.h.a     // Catch:{ all -> 0x01f6 }
            if (r5 != 0) goto L_0x01fe
            goto L_0x01ff
        L_0x01fe:
            r3 = r9
        L_0x01ff:
            boolean r3 = r14.a(r4, r3, r0)     // Catch:{ all -> 0x01f6 }
            if (r3 == 0) goto L_0x0207
            goto L_0x0022
        L_0x0207:
            throw r4     // Catch:{ all -> 0x01f6 }
        L_0x0208:
            r3 = move-exception
            java.io.IOException r4 = r3.f9209a     // Catch:{ all -> 0x01f6 }
            boolean r4 = r14.a(r4, r9, r0)     // Catch:{ all -> 0x01f6 }
            if (r4 == 0) goto L_0x0213
            goto L_0x0022
        L_0x0213:
            java.io.IOException r15 = r3.f9209a     // Catch:{ all -> 0x01f6 }
            throw r15     // Catch:{ all -> 0x01f6 }
        L_0x0216:
            g.d0.e.g r0 = r14.f9252c
            r0.a(r10)
            g.d0.e.g r0 = r14.f9252c
            r0.e()
            throw r15
        L_0x0221:
            g.d0.e.g r15 = r14.f9252c
            r15.e()
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.f.h.intercept(g.s$a):g.z");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.IOException r3, boolean r4, g.x r5) {
        /*
            r2 = this;
            g.d0.e.g r0 = r2.f9252c
            r0.a(r3)
            g.u r0 = r2.f9250a
            boolean r0 = r0.w
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            if (r4 == 0) goto L_0x0011
            g.y r5 = r5.f9598d
        L_0x0011:
            boolean r5 = r3 instanceof java.net.ProtocolException
            r0 = 1
            if (r5 == 0) goto L_0x0017
            goto L_0x0023
        L_0x0017:
            boolean r5 = r3 instanceof java.io.InterruptedIOException
            if (r5 == 0) goto L_0x0025
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x0023
            if (r4 != 0) goto L_0x0023
        L_0x0021:
            r3 = r0
            goto L_0x0037
        L_0x0023:
            r3 = r1
            goto L_0x0037
        L_0x0025:
            boolean r4 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r4 == 0) goto L_0x0032
            java.lang.Throwable r4 = r3.getCause()
            boolean r4 = r4 instanceof java.security.cert.CertificateException
            if (r4 == 0) goto L_0x0032
            goto L_0x0023
        L_0x0032:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0037:
            if (r3 != 0) goto L_0x003a
            return r1
        L_0x003a:
            g.d0.e.g r3 = r2.f9252c
            g.b0 r4 = r3.f9222c
            if (r4 != 0) goto L_0x0055
            g.d0.e.f$a r4 = r3.f9221b
            if (r4 == 0) goto L_0x004a
            boolean r4 = r4.a()
            if (r4 != 0) goto L_0x0055
        L_0x004a:
            g.d0.e.f r3 = r3.f9227h
            boolean r3 = r3.a()
            if (r3 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r3 = r1
            goto L_0x0056
        L_0x0055:
            r3 = r0
        L_0x0056:
            if (r3 != 0) goto L_0x0059
            return r1
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.f.h.a(java.io.IOException, boolean, g.x):boolean");
    }

    public final a a(r rVar) {
        f fVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        r rVar2 = rVar;
        if (rVar2.f9535a.equals("https")) {
            u uVar = this.f9250a;
            SSLSocketFactory sSLSocketFactory2 = uVar.m;
            HostnameVerifier hostnameVerifier2 = uVar.o;
            fVar = uVar.p;
            sSLSocketFactory = sSLSocketFactory2;
            hostnameVerifier = hostnameVerifier2;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            fVar = null;
        }
        String str = rVar2.f9538d;
        int i2 = rVar2.f9539e;
        u uVar2 = this.f9250a;
        a aVar = new a(str, i2, uVar2.t, uVar2.l, sSLSocketFactory, hostnameVerifier, fVar, uVar2.q, uVar2.f9562b, uVar2.f9563c, uVar2.f9564d, uVar2.f9568h);
        return aVar;
    }
}
