package g.d0.f;

import g.s;
import h.e;
import h.i;
import h.w;
import java.io.IOException;

/* compiled from: CallServerInterceptor */
public final class b implements s {

    /* renamed from: a reason: collision with root package name */
    public final boolean f9232a;

    /* compiled from: CallServerInterceptor */
    public static final class a extends i {

        /* renamed from: b reason: collision with root package name */
        public long f9233b;

        public a(w wVar) {
            super(wVar);
        }

        public void a(e eVar, long j2) throws IOException {
            this.f9654a.a(eVar, j2);
            this.f9233b += j2;
        }
    }

    public b(boolean z) {
        this.f9232a = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ea, code lost:
        if (r4.equalsIgnoreCase(r7) != false) goto L_0x00ec;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g.z intercept(g.s.a r11) throws java.io.IOException {
        /*
            r10 = this;
            g.d0.f.f r11 = (g.d0.f.f) r11
            g.d0.f.c r0 = r11.f9239c
            g.d0.e.g r1 = r11.f9238b
            g.d0.e.c r2 = r11.f9240d
            g.x r3 = r11.f9242f
            long r4 = java.lang.System.currentTimeMillis()
            g.n r6 = r11.f9244h
            r7 = 0
            if (r6 == 0) goto L_0x0121
            r0.a(r3)
            g.n r6 = r11.f9244h
            if (r6 == 0) goto L_0x0120
            java.lang.String r6 = r3.f9596b
            boolean r6 = e.c.f.n.n.b(r6)
            if (r6 == 0) goto L_0x0079
            g.y r6 = r3.f9598d
            if (r6 == 0) goto L_0x0079
            g.q r6 = r3.f9597c
            java.lang.String r8 = "Expect"
            java.lang.String r6 = r6.a(r8)
            java.lang.String r8 = "100-continue"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0044
            r0.b()
            g.n r6 = r11.f9244h
            if (r6 == 0) goto L_0x0043
            r6 = 1
            g.z$a r6 = r0.a(r6)
            goto L_0x0045
        L_0x0043:
            throw r7
        L_0x0044:
            r6 = r7
        L_0x0045:
            if (r6 != 0) goto L_0x006f
            g.n r2 = r11.f9244h
            if (r2 == 0) goto L_0x006e
            g.y r2 = r3.f9598d
            long r8 = r2.contentLength()
            g.d0.f.b$a r2 = new g.d0.f.b$a
            h.w r8 = r0.a(r3, r8)
            r2.<init>(r8)
            h.f r2 = h.o.a(r2)
            g.y r8 = r3.f9598d
            r8.writeTo(r2)
            h.r r2 = (h.r) r2
            r2.close()
            g.n r2 = r11.f9244h
            if (r2 == 0) goto L_0x006d
            goto L_0x007a
        L_0x006d:
            throw r7
        L_0x006e:
            throw r7
        L_0x006f:
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x007a
            r1.d()
            goto L_0x007a
        L_0x0079:
            r6 = r7
        L_0x007a:
            r0.a()
            if (r6 != 0) goto L_0x008a
            g.n r2 = r11.f9244h
            if (r2 == 0) goto L_0x0089
            r2 = 0
            g.z$a r6 = r0.a(r2)
            goto L_0x008a
        L_0x0089:
            throw r7
        L_0x008a:
            r6.f9624a = r3
            g.d0.e.c r2 = r1.c()
            g.p r2 = r2.f9202f
            r6.f9628e = r2
            r6.k = r4
            long r2 = java.lang.System.currentTimeMillis()
            r6.l = r2
            g.z r2 = r6.a()
            g.n r11 = r11.f9244h
            if (r11 == 0) goto L_0x011f
            int r11 = r2.f9616c
            boolean r3 = r10.f9232a
            if (r3 == 0) goto L_0x00bc
            r3 = 101(0x65, float:1.42E-43)
            if (r11 != r3) goto L_0x00bc
            g.z$a r0 = new g.z$a
            r0.<init>(r2)
            g.a0 r2 = g.d0.c.f9176c
            r0.f9630g = r2
            g.z r0 = r0.a()
            goto L_0x00cb
        L_0x00bc:
            g.z$a r3 = new g.z$a
            r3.<init>(r2)
            g.a0 r0 = r0.a(r2)
            r3.f9630g = r0
            g.z r0 = r3.a()
        L_0x00cb:
            g.x r2 = r0.f9614a
            g.q r2 = r2.f9597c
            java.lang.String r3 = "Connection"
            java.lang.String r2 = r2.a(r3)
            java.lang.String r4 = "close"
            boolean r2 = r4.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x00ec
            g.q r2 = r0.f9619f
            java.lang.String r2 = r2.a(r3)
            if (r2 == 0) goto L_0x00e6
            r7 = r2
        L_0x00e6:
            boolean r2 = r4.equalsIgnoreCase(r7)
            if (r2 == 0) goto L_0x00ef
        L_0x00ec:
            r1.d()
        L_0x00ef:
            r1 = 204(0xcc, float:2.86E-43)
            if (r11 == r1) goto L_0x00f7
            r1 = 205(0xcd, float:2.87E-43)
            if (r11 != r1) goto L_0x0103
        L_0x00f7:
            g.a0 r1 = r0.f9620g
            long r1 = r1.contentLength()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0104
        L_0x0103:
            return r0
        L_0x0104:
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "HTTP "
            java.lang.String r3 = " had non-zero Content-Length: "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r2, r11, r3)
            g.a0 r0 = r0.f9620g
            long r2 = r0.contentLength()
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            r1.<init>(r11)
            throw r1
        L_0x011f:
            throw r7
        L_0x0120:
            throw r7
        L_0x0121:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.f.b.intercept(g.s$a):g.z");
    }
}
