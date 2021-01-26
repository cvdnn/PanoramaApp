package d.f.a.h;

/* compiled from: Optimizer */
public class i {

    /* renamed from: a reason: collision with root package name */
    public static boolean[] f4715a = new boolean[3];

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(d.f.a.h.d r4, int r5) {
        /*
            d.f.a.h.d$a[] r0 = r4.C
            r1 = r0[r5]
            d.f.a.h.d$a r2 = d.f.a.h.d.a.MATCH_CONSTRAINT
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            float r1 = r4.G
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L_0x001d
            if (r5 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            r4 = r0[r2]
            d.f.a.h.d$a r5 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x001c
        L_0x001c:
            return r3
        L_0x001d:
            if (r5 != 0) goto L_0x002d
            int r5 = r4.f4694e
            if (r5 == 0) goto L_0x0024
            return r3
        L_0x0024:
            int r5 = r4.f4697h
            if (r5 != 0) goto L_0x002c
            int r4 = r4.f4698i
            if (r4 == 0) goto L_0x003b
        L_0x002c:
            return r3
        L_0x002d:
            int r5 = r4.f4695f
            if (r5 == 0) goto L_0x0032
            return r3
        L_0x0032:
            int r5 = r4.k
            if (r5 != 0) goto L_0x003c
            int r4 = r4.l
            if (r4 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            return r2
        L_0x003c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.i.a(d.f.a.h.d, int):boolean");
    }

    public static void a(d dVar, int i2, int i3) {
        int i4 = i2 * 2;
        int i5 = i4 + 1;
        c[] cVarArr = dVar.A;
        cVarArr[i4].f4664a.f4719f = dVar.D.s.f4664a;
        cVarArr[i4].f4664a.f4720g = (float) i3;
        cVarArr[i4].f4664a.f4726b = 1;
        cVarArr[i5].f4664a.f4719f = cVarArr[i4].f4664a;
        cVarArr[i5].f4664a.f4720g = (float) dVar.c(i2);
        dVar.A[i5].f4664a.f4726b = 1;
    }
}
