package e.i.a.h.h;

import e.a.a.a.a;
import e.i.a.c;

/* compiled from: BreakpointRemoteCheck */
public class b {

    /* renamed from: a reason: collision with root package name */
    public boolean f8807a;

    /* renamed from: b reason: collision with root package name */
    public boolean f8808b;

    /* renamed from: c reason: collision with root package name */
    public e.i.a.h.e.b f8809c;

    /* renamed from: d reason: collision with root package name */
    public long f8810d;

    /* renamed from: e reason: collision with root package name */
    public final c f8811e;

    /* renamed from: f reason: collision with root package name */
    public final e.i.a.h.d.c f8812f;

    public b(c cVar, e.i.a.h.d.c cVar2) {
        this.f8811e = cVar;
        this.f8812f = cVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() throws java.io.IOException {
        /*
            r13 = this;
            e.i.a.e r0 = e.i.a.e.a()
            e.i.a.h.h.g r0 = r0.f8670g
            e.i.a.h.h.c r1 = new e.i.a.h.h.c
            e.i.a.c r2 = r13.f8811e
            e.i.a.h.d.c r3 = r13.f8812f
            r1.<init>(r2, r3)
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.h.g r2 = r2.f8670g
            e.i.a.c r3 = r1.f8815a
            r2.a(r3)
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.h.g r2 = r2.f8670g
            r2.a()
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.f.a$b r2 = r2.f8667d
            e.i.a.c r3 = r1.f8815a
            java.lang.String r3 = r3.f8650c
            e.i.a.h.f.a r2 = r2.a(r3)
            e.i.a.h.d.c r3 = r1.f8816b     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = r3.f8704c     // Catch:{ all -> 0x01d7 }
            boolean r3 = e.i.a.h.c.a(r3)     // Catch:{ all -> 0x01d7 }
            if (r3 != 0) goto L_0x0044
            java.lang.String r3 = "If-Match"
            e.i.a.h.d.c r4 = r1.f8816b     // Catch:{ all -> 0x01d7 }
            java.lang.String r4 = r4.f8704c     // Catch:{ all -> 0x01d7 }
            r2.a(r3, r4)     // Catch:{ all -> 0x01d7 }
        L_0x0044:
            java.lang.String r3 = "Range"
            java.lang.String r4 = "bytes=0-0"
            r2.a(r3, r4)     // Catch:{ all -> 0x01d7 }
            e.i.a.c r3 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r3.f8652e     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x0054
            e.i.a.h.c.b(r3, r2)     // Catch:{ all -> 0x01d7 }
        L_0x0054:
            e.i.a.e r3 = e.i.a.e.a()     // Catch:{ all -> 0x01d7 }
            e.i.a.h.g.a r3 = r3.f8665b     // Catch:{ all -> 0x01d7 }
            e.i.a.a r3 = r3.f8757a     // Catch:{ all -> 0x01d7 }
            java.util.Map r4 = r2.e()     // Catch:{ all -> 0x01d7 }
            e.i.a.c r5 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            r3.connectTrialStart(r5, r4)     // Catch:{ all -> 0x01d7 }
            e.i.a.h.f.a$a r4 = r2.d()     // Catch:{ all -> 0x01d7 }
            e.i.a.c r5 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = r4.a()     // Catch:{ all -> 0x01d7 }
            r5.z = r6     // Catch:{ all -> 0x01d7 }
            e.i.a.c r5 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            int r5 = r5.f8649b     // Catch:{ all -> 0x01d7 }
            e.i.a.c r5 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = r5.z     // Catch:{ all -> 0x01d7 }
            int r5 = r4.f()     // Catch:{ all -> 0x01d7 }
            r1.f8821g = r5     // Catch:{ all -> 0x01d7 }
            int r5 = r4.f()     // Catch:{ all -> 0x01d7 }
            r6 = 206(0xce, float:2.89E-43)
            r7 = 1
            if (r5 != r6) goto L_0x008a
            r5 = r7
            goto L_0x0096
        L_0x008a:
            java.lang.String r5 = "Accept-Ranges"
            java.lang.String r5 = r4.a(r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "bytes"
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x01d7 }
        L_0x0096:
            r1.f8817c = r5     // Catch:{ all -> 0x01d7 }
            long r5 = e.i.a.h.h.c.b(r4)     // Catch:{ all -> 0x01d7 }
            r1.f8818d = r5     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "Etag"
            java.lang.String r5 = r4.a(r5)     // Catch:{ all -> 0x01d7 }
            r1.f8819e = r5     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = e.i.a.h.h.c.a(r4)     // Catch:{ all -> 0x01d7 }
            r1.f8820f = r5     // Catch:{ all -> 0x01d7 }
            java.util.Map r5 = r4.c()     // Catch:{ all -> 0x01d7 }
            if (r5 != 0) goto L_0x00b7
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x01d7 }
            r5.<init>()     // Catch:{ all -> 0x01d7 }
        L_0x00b7:
            e.i.a.c r6 = r1.f8815a     // Catch:{ all -> 0x01d7 }
            int r8 = r1.f8821g     // Catch:{ all -> 0x01d7 }
            r3.connectTrialEnd(r6, r8, r5)     // Catch:{ all -> 0x01d7 }
            long r5 = r1.f8818d     // Catch:{ all -> 0x01d7 }
            r8 = -1
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            java.lang.String r5 = "Content-Length"
            r6 = 0
            if (r3 == 0) goto L_0x00ca
            goto L_0x00fe
        L_0x00ca:
            java.lang.String r3 = "Content-Range"
            java.lang.String r3 = r4.a(r3)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00d9
            int r3 = r3.length()     // Catch:{ all -> 0x01d7 }
            if (r3 <= 0) goto L_0x00d9
            goto L_0x00fe
        L_0x00d9:
            java.lang.String r3 = "Transfer-Encoding"
            java.lang.String r3 = r4.a(r3)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00eb
            java.lang.String r10 = "chunked"
            boolean r3 = r3.equals(r10)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00eb
            r3 = r7
            goto L_0x00ec
        L_0x00eb:
            r3 = r6
        L_0x00ec:
            if (r3 == 0) goto L_0x00ef
            goto L_0x00fe
        L_0x00ef:
            java.lang.String r3 = r4.a(r5)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00fe
            int r3 = r3.length()     // Catch:{ all -> 0x01d7 }
            if (r3 > 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r3 = r7
            goto L_0x00ff
        L_0x00fe:
            r3 = r6
        L_0x00ff:
            r2.release()
            if (r3 == 0) goto L_0x0155
            e.i.a.e r2 = e.i.a.e.a()
            e.i.a.h.f.a$b r2 = r2.f8667d
            e.i.a.c r3 = r1.f8815a
            java.lang.String r3 = r3.f8650c
            e.i.a.h.f.a r2 = r2.a(r3)
            e.i.a.e r3 = e.i.a.e.a()
            e.i.a.h.g.a r3 = r3.f8665b
            e.i.a.a r3 = r3.f8757a
            java.lang.String r4 = "HEAD"
            r2.b(r4)     // Catch:{ all -> 0x0150 }
            e.i.a.c r4 = r1.f8815a     // Catch:{ all -> 0x0150 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r4.f8652e     // Catch:{ all -> 0x0150 }
            if (r4 == 0) goto L_0x0128
            e.i.a.h.c.b(r4, r2)     // Catch:{ all -> 0x0150 }
        L_0x0128:
            e.i.a.c r4 = r1.f8815a     // Catch:{ all -> 0x0150 }
            java.util.Map r10 = r2.e()     // Catch:{ all -> 0x0150 }
            r3.connectTrialStart(r4, r10)     // Catch:{ all -> 0x0150 }
            e.i.a.h.f.a$a r4 = r2.d()     // Catch:{ all -> 0x0150 }
            e.i.a.c r10 = r1.f8815a     // Catch:{ all -> 0x0150 }
            int r11 = r4.f()     // Catch:{ all -> 0x0150 }
            java.util.Map r12 = r4.c()     // Catch:{ all -> 0x0150 }
            r3.connectTrialEnd(r10, r11, r12)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = r4.a(r5)     // Catch:{ all -> 0x0150 }
            long r3 = e.i.a.h.c.b(r3)     // Catch:{ all -> 0x0150 }
            r1.f8818d = r3     // Catch:{ all -> 0x0150 }
            r2.release()
            goto L_0x0155
        L_0x0150:
            r0 = move-exception
            r2.release()
            throw r0
        L_0x0155:
            boolean r2 = r1.f8817c
            long r3 = r1.f8818d
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x015f
            r3 = r7
            goto L_0x0160
        L_0x015f:
            r3 = r6
        L_0x0160:
            long r4 = r1.f8818d
            java.lang.String r8 = r1.f8819e
            java.lang.String r9 = r1.f8820f
            int r1 = r1.f8821g
            e.i.a.c r10 = r13.f8811e
            e.i.a.h.d.c r11 = r13.f8812f
            r0.a(r9, r10, r11)
            e.i.a.h.d.c r9 = r13.f8812f
            r9.f8710i = r3
            r9.f8704c = r8
            e.i.a.e r3 = e.i.a.e.a()
            e.i.a.h.g.b r3 = r3.f8664a
            e.i.a.c r9 = r13.f8811e
            boolean r3 = r3.d(r9)
            if (r3 != 0) goto L_0x01d4
            e.i.a.h.d.c r3 = r13.f8812f
            long r9 = r3.e()
            r11 = 0
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x0191
            r3 = r7
            goto L_0x0192
        L_0x0191:
            r3 = r6
        L_0x0192:
            e.i.a.h.d.c r9 = r13.f8812f
            e.i.a.h.e.b r3 = r0.a(r1, r3, r9, r8)
            if (r3 != 0) goto L_0x019c
            r8 = r7
            goto L_0x019d
        L_0x019c:
            r8 = r6
        L_0x019d:
            r13.f8808b = r8
            r13.f8809c = r3
            r13.f8810d = r4
            r13.f8807a = r2
            r2 = 416(0x1a0, float:5.83E-43)
            if (r1 != r2) goto L_0x01b1
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x01b1
            if (r8 == 0) goto L_0x01b1
            r2 = r7
            goto L_0x01b2
        L_0x01b1:
            r2 = r6
        L_0x01b2:
            if (r2 != 0) goto L_0x01d3
            e.i.a.h.d.c r2 = r13.f8812f
            long r2 = r2.e()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x01bf
            goto L_0x01c0
        L_0x01bf:
            r7 = r6
        L_0x01c0:
            boolean r0 = r0.a(r1, r7)
            if (r0 != 0) goto L_0x01c7
            goto L_0x01d3
        L_0x01c7:
            e.i.a.h.i.i r0 = new e.i.a.h.i.i
            e.i.a.h.d.c r2 = r13.f8812f
            long r2 = r2.e()
            r0.<init>(r1, r2)
            throw r0
        L_0x01d3:
            return
        L_0x01d4:
            e.i.a.h.i.b r0 = e.i.a.h.i.b.f8855a
            throw r0
        L_0x01d7:
            r0 = move-exception
            r2.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.b.a():void");
    }

    public String toString() {
        StringBuilder a2 = a.a("acceptRange[");
        a2.append(this.f8807a);
        String str = "] ";
        a2.append(str);
        a2.append("resumable[");
        a2.append(this.f8808b);
        a2.append(str);
        a2.append("failedCause[");
        a2.append(this.f8809c);
        a2.append(str);
        a2.append("instanceLength[");
        a2.append(this.f8810d);
        a2.append(str);
        a2.append(super.toString());
        return a2.toString();
    }
}
