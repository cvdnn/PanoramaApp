package d.f.a;

import d.f.a.e.a;

/* compiled from: ArrayRow */
public class b implements a {

    /* renamed from: a reason: collision with root package name */
    public g f4618a = null;

    /* renamed from: b reason: collision with root package name */
    public float f4619b = 0.0f;

    /* renamed from: c reason: collision with root package name */
    public boolean f4620c;

    /* renamed from: d reason: collision with root package name */
    public final a f4621d;

    /* renamed from: e reason: collision with root package name */
    public boolean f4622e = false;

    public b(c cVar) {
        this.f4621d = new a(this, cVar);
    }

    public b a(g gVar, g gVar2, g gVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f4619b = (float) i2;
        }
        if (!z) {
            this.f4621d.a(gVar, -1.0f);
            this.f4621d.a(gVar2, 1.0f);
            this.f4621d.a(gVar3, 1.0f);
        } else {
            this.f4621d.a(gVar, 1.0f);
            this.f4621d.a(gVar2, -1.0f);
            this.f4621d.a(gVar3, -1.0f);
        }
        return this;
    }

    public b b(g gVar, g gVar2, g gVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f4619b = (float) i2;
        }
        if (!z) {
            this.f4621d.a(gVar, -1.0f);
            this.f4621d.a(gVar2, 1.0f);
            this.f4621d.a(gVar3, -1.0f);
        } else {
            this.f4621d.a(gVar, 1.0f);
            this.f4621d.a(gVar2, -1.0f);
            this.f4621d.a(gVar3, 1.0f);
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            d.f.a.g r0 = r10.f4618a
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "0"
            goto L_0x0016
        L_0x0007:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            d.f.a.g r1 = r10.f4618a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0016:
            java.lang.String r1 = " = "
            java.lang.String r0 = e.a.a.a.a.a(r0, r1)
            float r1 = r10.f4619b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0034
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            float r1 = r10.f4619b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L_0x0035
        L_0x0034:
            r1 = r3
        L_0x0035:
            d.f.a.a r5 = r10.f4621d
            int r5 = r5.f4608a
        L_0x0039:
            if (r3 >= r5) goto L_0x0098
            d.f.a.a r6 = r10.f4621d
            d.f.a.g r6 = r6.a(r3)
            if (r6 != 0) goto L_0x0044
            goto L_0x0095
        L_0x0044:
            d.f.a.a r7 = r10.f4621d
            float r7 = r7.b(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x004f
            goto L_0x0095
        L_0x004f:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0062
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0072
            java.lang.String r1 = "- "
            java.lang.String r0 = e.a.a.a.a.a(r0, r1)
            goto L_0x0071
        L_0x0062:
            if (r8 <= 0) goto L_0x006b
            java.lang.String r1 = " + "
            java.lang.String r0 = e.a.a.a.a.a(r0, r1)
            goto L_0x0072
        L_0x006b:
            java.lang.String r1 = " - "
            java.lang.String r0 = e.a.a.a.a.a(r0, r1)
        L_0x0071:
            float r7 = r7 * r9
        L_0x0072:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x007d
            java.lang.String r0 = e.a.a.a.a.a(r0, r6)
            goto L_0x0094
        L_0x007d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x0094:
            r1 = r4
        L_0x0095:
            int r3 = r3 + 1
            goto L_0x0039
        L_0x0098:
            if (r1 != 0) goto L_0x00a0
            java.lang.String r1 = "0.0"
            java.lang.String r0 = e.a.a.a.a.a(r0, r1)
        L_0x00a0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.b.toString():java.lang.String");
    }

    public b a(e eVar, int i2) {
        this.f4621d.a(eVar.a(i2, "ep"), 1.0f);
        this.f4621d.a(eVar.a(i2, "em"), -1.0f);
        return this;
    }

    public b b(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f4621d.a(gVar3, 0.5f);
        this.f4621d.a(gVar4, 0.5f);
        this.f4621d.a(gVar, -0.5f);
        this.f4621d.a(gVar2, -0.5f);
        this.f4619b = -f2;
        return this;
    }

    public b a(g gVar, g gVar2, g gVar3, g gVar4, float f2) {
        this.f4621d.a(gVar, -1.0f);
        this.f4621d.a(gVar2, 1.0f);
        this.f4621d.a(gVar3, f2);
        this.f4621d.a(gVar4, -f2);
        return this;
    }

    public void b(g gVar) {
        g gVar2 = this.f4618a;
        if (gVar2 != null) {
            this.f4621d.a(gVar2, -1.0f);
            this.f4618a = null;
        }
        float a2 = this.f4621d.a(gVar, true) * -1.0f;
        this.f4618a = gVar;
        if (a2 != 1.0f) {
            this.f4619b /= a2;
            a aVar = this.f4621d;
            int i2 = aVar.f4616i;
            int i3 = 0;
            while (i2 != -1 && i3 < aVar.f4608a) {
                float[] fArr = aVar.f4615h;
                fArr[i2] = fArr[i2] / a2;
                i2 = aVar.f4614g[i2];
                i3++;
            }
        }
    }

    public void a(g gVar) {
        int i2 = gVar.f4641d;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f4621d.a(gVar, f2);
    }
}
