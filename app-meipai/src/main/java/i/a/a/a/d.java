package i.a.a.a;

import java.util.List;

/* compiled from: GnuParser */
public class d implements c {

    /* renamed from: a reason: collision with root package name */
    public b f9697a;

    /* renamed from: b reason: collision with root package name */
    public k f9698b;

    /* renamed from: c reason: collision with root package name */
    public List f9699c;

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0206, code lost:
        if (r14 != false) goto L_0x0208;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020b A[LOOP:5: B:105:0x020b->B:133:0x020b, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x00ed A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i.a.a.a.b a(i.a.a.a.k r12, java.lang.String[] r13, boolean r14) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0238
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Map r2 = r12.f9715a
            java.util.Collection r2 = r2.values()
            r1.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0024
            java.lang.Object r2 = r1.next()
            i.a.a.a.i r2 = (i.a.a.a.i) r2
            java.util.List r2 = r2.f9712f
            r2.clear()
            goto L_0x0012
        L_0x0024:
            r11.f9698b = r12
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List r12 = r12.f9717c
            r1.<init>(r12)
            r11.f9699c = r1
            i.a.a.a.b r12 = new i.a.a.a.b
            r12.<init>()
            r11.f9697a = r12
            r12 = 0
            if (r13 != 0) goto L_0x003b
            java.lang.String[] r13 = new java.lang.String[r12]
        L_0x003b:
            i.a.a.a.k r1 = r11.f9698b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = r12
            r4 = r3
        L_0x0044:
            int r5 = r13.length
            r6 = -1
            java.lang.String r7 = "--"
            java.lang.String r8 = "-"
            r9 = 1
            if (r3 >= r5) goto L_0x00d8
            r5 = r13[r3]
            boolean r10 = r7.equals(r5)
            if (r10 == 0) goto L_0x005b
            r2.add(r7)
            r4 = r9
            goto L_0x00c9
        L_0x005b:
            boolean r7 = r8.equals(r5)
            if (r7 == 0) goto L_0x0065
            r2.add(r8)
            goto L_0x00c9
        L_0x0065:
            boolean r7 = r5.startsWith(r8)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r7 = e.c.f.n.n.d(r5)
            boolean r8 = r1.b(r7)
            if (r8 == 0) goto L_0x0079
            r2.add(r5)
            goto L_0x00c9
        L_0x0079:
            r8 = 61
            int r10 = r7.indexOf(r8)
            if (r10 == r6) goto L_0x00a7
            int r6 = r7.indexOf(r8)
            java.lang.String r6 = r7.substring(r12, r6)
            boolean r6 = r1.b(r6)
            if (r6 == 0) goto L_0x00a7
            int r6 = r5.indexOf(r8)
            java.lang.String r6 = r5.substring(r12, r6)
            r2.add(r6)
            int r6 = r5.indexOf(r8)
            int r6 = r6 + r9
            java.lang.String r5 = r5.substring(r6)
            r2.add(r5)
            goto L_0x00c9
        L_0x00a7:
            r6 = 2
            java.lang.String r7 = r5.substring(r12, r6)
            boolean r7 = r1.b(r7)
            if (r7 == 0) goto L_0x00c1
            java.lang.String r7 = r5.substring(r12, r6)
            r2.add(r7)
            java.lang.String r5 = r5.substring(r6)
            r2.add(r5)
            goto L_0x00c9
        L_0x00c1:
            r2.add(r5)
            r4 = r14
            goto L_0x00c9
        L_0x00c6:
            r2.add(r5)
        L_0x00c9:
            if (r4 == 0) goto L_0x00d5
        L_0x00cb:
            int r3 = r3 + r9
            int r5 = r13.length
            if (r3 >= r5) goto L_0x00d5
            r5 = r13[r3]
            r2.add(r5)
            goto L_0x00cb
        L_0x00d5:
            int r3 = r3 + r9
            goto L_0x0044
        L_0x00d8:
            int r13 = r2.size()
            java.lang.String[] r13 = new java.lang.String[r13]
            java.lang.Object[] r13 = r2.toArray(r13)
            java.lang.String[] r13 = (java.lang.String[]) r13
            java.util.List r13 = java.util.Arrays.asList(r13)
            java.util.ListIterator r13 = r13.listIterator()
            r1 = r12
        L_0x00ed:
            boolean r2 = r13.hasNext()
            java.lang.String r3 = "NO_ARGS_ALLOWED"
            if (r2 == 0) goto L_0x0225
            java.lang.Object r2 = r13.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = r7.equals(r2)
            if (r4 == 0) goto L_0x0103
            goto L_0x0208
        L_0x0103:
            boolean r4 = r8.equals(r2)
            if (r4 == 0) goto L_0x0116
            if (r14 == 0) goto L_0x010d
            goto L_0x0208
        L_0x010d:
            i.a.a.a.b r3 = r11.f9697a
            java.util.List r3 = r3.f9695a
            r3.add(r2)
            goto L_0x0209
        L_0x0116:
            boolean r4 = r2.startsWith(r8)
            if (r4 == 0) goto L_0x01ff
            if (r14 == 0) goto L_0x012f
            i.a.a.a.k r4 = r11.f9698b
            boolean r4 = r4.b(r2)
            if (r4 != 0) goto L_0x012f
            i.a.a.a.b r1 = r11.f9697a
            java.util.List r1 = r1.f9695a
            r1.add(r2)
            goto L_0x0208
        L_0x012f:
            i.a.a.a.k r4 = r11.f9698b
            boolean r4 = r4.b(r2)
            if (r4 == 0) goto L_0x01e8
            i.a.a.a.k r4 = r11.f9698b
            i.a.a.a.i r2 = r4.a(r2)
            java.lang.Object r2 = r2.clone()
            i.a.a.a.i r2 = (i.a.a.a.i) r2
            if (r2 == 0) goto L_0x01e7
            i.a.a.a.k r4 = r11.f9698b
            java.util.Map r4 = r4.f9718d
            java.lang.String r5 = r2.a()
            java.lang.Object r4 = r4.get(r5)
            i.a.a.a.j r4 = (i.a.a.a.j) r4
            if (r4 == 0) goto L_0x017e
            i.a.a.a.k r4 = r11.f9698b
            java.util.Map r4 = r4.f9718d
            java.lang.String r5 = r2.a()
            java.lang.Object r4 = r4.get(r5)
            i.a.a.a.j r4 = (i.a.a.a.j) r4
            if (r4 == 0) goto L_0x017d
            java.lang.String r5 = r4.f9714b
            if (r5 == 0) goto L_0x0178
            java.lang.String r10 = r2.f9707a
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x0172
            goto L_0x0178
        L_0x0172:
            i.a.a.a.a r12 = new i.a.a.a.a
            r12.<init>(r4, r2)
            throw r12
        L_0x0178:
            java.lang.String r5 = r2.f9707a
            r4.f9714b = r5
            goto L_0x017e
        L_0x017d:
            throw r0
        L_0x017e:
            boolean r4 = r2.c()
            if (r4 == 0) goto L_0x01df
        L_0x0184:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x01d2
            java.lang.Object r4 = r13.next()
            java.lang.String r4 = (java.lang.String) r4
            i.a.a.a.k r5 = r11.f9698b
            boolean r5 = r5.b(r4)
            if (r5 == 0) goto L_0x01a2
            boolean r5 = r4.startsWith(r8)
            if (r5 == 0) goto L_0x01a2
            r13.previous()
            goto L_0x01d2
        L_0x01a2:
            java.lang.String r5 = "\""
            boolean r10 = r4.startsWith(r5)     // Catch:{ RuntimeException -> 0x01cf }
            if (r10 == 0) goto L_0x01b2
            int r10 = r4.length()     // Catch:{ RuntimeException -> 0x01cf }
            java.lang.String r4 = r4.substring(r9, r10)     // Catch:{ RuntimeException -> 0x01cf }
        L_0x01b2:
            boolean r5 = r4.endsWith(r5)     // Catch:{ RuntimeException -> 0x01cf }
            if (r5 == 0) goto L_0x01c1
            int r5 = r4.length()     // Catch:{ RuntimeException -> 0x01cf }
            int r5 = r5 - r9
            java.lang.String r4 = r4.substring(r12, r5)     // Catch:{ RuntimeException -> 0x01cf }
        L_0x01c1:
            int r5 = r2.f9711e     // Catch:{ RuntimeException -> 0x01cf }
            if (r5 == r6) goto L_0x01c9
            r2.a(r4)     // Catch:{ RuntimeException -> 0x01cf }
            goto L_0x0184
        L_0x01c9:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ RuntimeException -> 0x01cf }
            r4.<init>(r3)     // Catch:{ RuntimeException -> 0x01cf }
            throw r4     // Catch:{ RuntimeException -> 0x01cf }
        L_0x01cf:
            r13.previous()
        L_0x01d2:
            java.lang.String[] r3 = r2.b()
            if (r3 == 0) goto L_0x01d9
            goto L_0x01df
        L_0x01d9:
            i.a.a.a.g r12 = new i.a.a.a.g
            r12.<init>(r2)
            throw r12
        L_0x01df:
            i.a.a.a.b r3 = r11.f9697a
            java.util.List r3 = r3.f9696b
            r3.add(r2)
            goto L_0x0209
        L_0x01e7:
            throw r0
        L_0x01e8:
            i.a.a.a.m r12 = new i.a.a.a.m
            java.lang.StringBuffer r13 = new java.lang.StringBuffer
            r13.<init>()
            java.lang.String r14 = "Unrecognized option: "
            r13.append(r14)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13, r2)
            throw r12
        L_0x01ff:
            i.a.a.a.b r3 = r11.f9697a
            java.util.List r3 = r3.f9695a
            r3.add(r2)
            if (r14 == 0) goto L_0x0209
        L_0x0208:
            r1 = r9
        L_0x0209:
            if (r1 == 0) goto L_0x00ed
        L_0x020b:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r13.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r7.equals(r2)
            if (r3 != 0) goto L_0x020b
            i.a.a.a.b r3 = r11.f9697a
            java.util.List r3 = r3.f9695a
            r3.add(r2)
            goto L_0x020b
        L_0x0225:
            java.util.List r12 = r11.f9699c
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0230
            i.a.a.a.b r12 = r11.f9697a
            return r12
        L_0x0230:
            i.a.a.a.h r12 = new i.a.a.a.h
            java.util.List r13 = r11.f9699c
            r12.<init>(r13)
            throw r12
        L_0x0238:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.a.a.d.a(i.a.a.a.k, java.lang.String[], boolean):i.a.a.a.b");
    }
}
