package e.c.d.l.a;

import g.u;

/* compiled from: SimpleDownloader */
public class b {

    /* renamed from: b reason: collision with root package name */
    public static volatile b f6370b;

    /* renamed from: a reason: collision with root package name */
    public u f6371a;

    /* compiled from: SimpleDownloader */
    public interface a {
    }

    public static b a() {
        if (f6370b == null) {
            synchronized (b.class) {
                if (f6370b == null) {
                    f6370b = new b();
                }
            }
        }
        return f6370b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e A[LOOP:0: B:1:0x0008->B:28:0x008e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(java.util.List r9, java.lang.String r10, e.c.d.l.a.b.a r11) {
        /*
            r8 = this;
            int r0 = r9.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = 0
            r2 = r1
        L_0x0008:
            int r3 = r9.size()
            if (r2 >= r3) goto L_0x0092
            java.lang.Object r3 = r9.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = e.c.d.n.e.e(r3)
            java.lang.String r5 = "/"
            java.lang.String r4 = e.a.a.a.a.a(r10, r5, r4)
            r0[r2] = r4
            g.u r5 = r8.f6371a
            if (r5 != 0) goto L_0x0035
            g.u r5 = new g.u
            r5.<init>()
            g.u$b r6 = new g.u$b
            r6.<init>(r5)
            g.u r5 = new g.u
            r5.<init>(r6)
            r8.f6371a = r5
        L_0x0035:
            g.x$a r5 = new g.x$a
            r5.<init>()
            r5.a(r3)
            r5.b()
            g.x r3 = r5.a()
            r5 = -1
            g.u r6 = r8.f6371a     // Catch:{ Exception -> 0x0080 }
            g.e r3 = r6.a(r3)     // Catch:{ Exception -> 0x0080 }
            g.z r3 = r3.d()     // Catch:{ Exception -> 0x0080 }
            g.a0 r6 = r3.f9620g     // Catch:{ Exception -> 0x0080 }
            int r3 = r3.f9616c     // Catch:{ Exception -> 0x0080 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r3 != r7) goto L_0x0084
            if (r6 == 0) goto L_0x0084
            java.io.InputStream r3 = r6.byteStream()     // Catch:{ Exception -> 0x0080 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007b }
            r6.<init>(r4)     // Catch:{ IOException -> 0x007b }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x007b }
        L_0x0066:
            int r7 = r3.read(r4)     // Catch:{ IOException -> 0x007b }
            if (r7 == r5) goto L_0x0070
            r6.write(r4, r1, r7)     // Catch:{ IOException -> 0x007b }
            goto L_0x0066
        L_0x0070:
            r6.flush()     // Catch:{ IOException -> 0x007b }
            r3.close()     // Catch:{ IOException -> 0x007b }
            r6.close()     // Catch:{ IOException -> 0x007b }
            r3 = 1
            goto L_0x0085
        L_0x007b:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0084:
            r3 = r1
        L_0x0085:
            if (r3 != 0) goto L_0x008e
            r9 = 0
            e.c.d.m.d.a.s0 r11 = (e.c.d.m.d.a.s0) r11
            r11.a(r9, r5)
            return
        L_0x008e:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0092:
            e.c.d.m.d.a.s0 r11 = (e.c.d.m.d.a.s0) r11
            r11.a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.l.a.b.a(java.util.List, java.lang.String, e.c.d.l.a.b$a):void");
    }
}
