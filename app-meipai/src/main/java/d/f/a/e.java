package d.f.a;

import d.f.a.h.c;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem */
public class e {
    public static int p = 1000;

    /* renamed from: a reason: collision with root package name */
    public int f4626a;

    /* renamed from: b reason: collision with root package name */
    public HashMap<String, g> f4627b;

    /* renamed from: c reason: collision with root package name */
    public a f4628c;

    /* renamed from: d reason: collision with root package name */
    public int f4629d;

    /* renamed from: e reason: collision with root package name */
    public int f4630e;

    /* renamed from: f reason: collision with root package name */
    public b[] f4631f;

    /* renamed from: g reason: collision with root package name */
    public boolean f4632g;

    /* renamed from: h reason: collision with root package name */
    public boolean[] f4633h;

    /* renamed from: i reason: collision with root package name */
    public int f4634i;

    /* renamed from: j reason: collision with root package name */
    public int f4635j;
    public int k;
    public final c l;
    public g[] m;
    public int n;
    public final a o;

    /* compiled from: LinearSystem */
    public interface a {
        void a(g gVar);
    }

    public e() {
        this.f4626a = 0;
        this.f4627b = null;
        this.f4629d = 32;
        this.f4630e = 32;
        this.f4631f = null;
        this.f4632g = false;
        this.f4633h = new boolean[32];
        this.f4634i = 1;
        this.f4635j = 0;
        this.k = 32;
        this.m = new g[p];
        this.n = 0;
        this.f4631f = new b[32];
        e();
        c cVar = new c();
        this.l = cVar;
        this.f4628c = new d(cVar);
        this.o = new b(this.l);
    }

    public g a(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f4634i + 1 >= this.f4630e) {
            d();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            gVar = cVar.f4672i;
            if (gVar == null) {
                cVar.d();
                gVar = cVar.f4672i;
            }
            int i2 = gVar.f4639b;
            if (i2 == -1 || i2 > this.f4626a || this.l.f4625c[i2] == null) {
                if (gVar.f4639b != -1) {
                    gVar.a();
                }
                int i3 = this.f4626a + 1;
                this.f4626a = i3;
                this.f4634i++;
                gVar.f4639b = i3;
                gVar.f4644g = d.f.a.g.a.UNRESTRICTED;
                this.l.f4625c[i3] = gVar;
            }
        }
        return gVar;
    }

    public b b() {
        b bVar = (b) this.l.f4623a.a();
        if (bVar == null) {
            bVar = new b(this.l);
        } else {
            bVar.f4618a = null;
            bVar.f4621d.a();
            bVar.f4619b = 0.0f;
            bVar.f4622e = false;
        }
        g.k++;
        return bVar;
    }

    public g c() {
        if (this.f4634i + 1 >= this.f4630e) {
            d();
        }
        g a2 = a(d.f.a.g.a.SLACK, (String) null);
        int i2 = this.f4626a + 1;
        this.f4626a = i2;
        this.f4634i++;
        a2.f4639b = i2;
        this.l.f4625c[i2] = a2;
        return a2;
    }

    public final void d() {
        int i2 = this.f4629d * 2;
        this.f4629d = i2;
        this.f4631f = (b[]) Arrays.copyOf(this.f4631f, i2);
        c cVar = this.l;
        cVar.f4625c = (g[]) Arrays.copyOf(cVar.f4625c, this.f4629d);
        int i3 = this.f4629d;
        this.f4633h = new boolean[i3];
        this.f4630e = i3;
        this.k = i3;
    }

    public final void e() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f4631f;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.l.f4623a.a(bVar);
                }
                this.f4631f[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public void f() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.l;
            g[] gVarArr = cVar.f4625c;
            if (i2 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i2];
            if (gVar != null) {
                gVar.a();
            }
            i2++;
        }
        f<g> fVar = cVar.f4624b;
        g[] gVarArr2 = this.m;
        int i3 = this.n;
        if (fVar != null) {
            if (i3 > gVarArr2.length) {
                i3 = gVarArr2.length;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                g gVar2 = gVarArr2[i4];
                int i5 = fVar.f4637b;
                Object[] objArr = fVar.f4636a;
                if (i5 < objArr.length) {
                    objArr[i5] = gVar2;
                    fVar.f4637b = i5 + 1;
                }
            }
            this.n = 0;
            Arrays.fill(this.l.f4625c, null);
            HashMap<String, g> hashMap = this.f4627b;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.f4626a = 0;
            b bVar = (b) this.f4628c;
            bVar.f4621d.a();
            bVar.f4618a = null;
            bVar.f4619b = 0.0f;
            this.f4634i = 1;
            for (int i6 = 0; i6 < this.f4635j; i6++) {
                this.f4631f[i6].f4620c = false;
            }
            e();
            this.f4635j = 0;
            return;
        }
        throw null;
    }

    public int b(Object obj) {
        g gVar = ((c) obj).f4672i;
        if (gVar != null) {
            return (int) (gVar.f4642e + 0.5f);
        }
        return 0;
    }

    public final void c(b bVar) {
        if (this.f4635j > 0) {
            a aVar = bVar.f4621d;
            b[] bVarArr = this.f4631f;
            int i2 = aVar.f4616i;
            loop0:
            while (true) {
                int i3 = 0;
                while (i2 != -1 && i3 < aVar.f4608a) {
                    g gVar = aVar.f4610c.f4625c[aVar.f4613f[i2]];
                    if (gVar.f4640c != -1) {
                        float f2 = aVar.f4615h[i2];
                        aVar.a(gVar, true);
                        b bVar2 = bVarArr[gVar.f4640c];
                        if (!bVar2.f4622e) {
                            a aVar2 = bVar2.f4621d;
                            int i4 = aVar2.f4616i;
                            int i5 = 0;
                            while (i4 != -1 && i5 < aVar2.f4608a) {
                                aVar.a(aVar.f4610c.f4625c[aVar2.f4613f[i4]], aVar2.f4615h[i4] * f2, true);
                                i4 = aVar2.f4614g[i4];
                                i5++;
                            }
                        }
                        bVar.f4619b = (bVar2.f4619b * f2) + bVar.f4619b;
                        bVar2.f4618a.b(bVar);
                        i2 = aVar.f4616i;
                    } else {
                        i2 = aVar.f4614g[i2];
                        i3++;
                    }
                }
            }
            if (bVar.f4621d.f4608a == 0) {
                bVar.f4622e = true;
            }
        }
    }

    public final void b(b bVar) {
        b[] bVarArr = this.f4631f;
        int i2 = this.f4635j;
        if (bVarArr[i2] != null) {
            this.l.f4623a.a(bVarArr[i2]);
        }
        b[] bVarArr2 = this.f4631f;
        int i3 = this.f4635j;
        bVarArr2[i3] = bVar;
        g gVar = bVar.f4618a;
        gVar.f4640c = i3;
        this.f4635j = i3 + 1;
        gVar.c(bVar);
    }

    public g a(int i2, String str) {
        if (this.f4634i + 1 >= this.f4630e) {
            d();
        }
        g a2 = a(d.f.a.g.a.ERROR, str);
        int i3 = this.f4626a + 1;
        this.f4626a = i3;
        this.f4634i++;
        a2.f4639b = i3;
        a2.f4641d = i2;
        this.l.f4625c[i3] = a2;
        this.f4628c.a(a2);
        return a2;
    }

    public final int b(a aVar) {
        boolean z;
        for (int i2 = 0; i2 < this.f4634i; i2++) {
            this.f4633h[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            i3++;
            if (i3 >= this.f4634i * 2) {
                return i3;
            }
            b bVar = (b) aVar;
            g gVar = bVar.f4618a;
            if (gVar != null) {
                this.f4633h[gVar.f4639b] = true;
            }
            g a2 = bVar.f4621d.a(this.f4633h, (g) null);
            if (a2 != null) {
                boolean[] zArr = this.f4633h;
                int i4 = a2.f4639b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f4635j; i6++) {
                    b bVar2 = this.f4631f[i6];
                    if (bVar2.f4618a.f4644g != d.f.a.g.a.UNRESTRICTED && !bVar2.f4622e) {
                        a aVar2 = bVar2.f4621d;
                        int i7 = aVar2.f4616i;
                        if (i7 != -1) {
                            int i8 = 0;
                            while (true) {
                                if (i7 == -1 || i8 >= aVar2.f4608a) {
                                    break;
                                } else if (aVar2.f4613f[i7] == a2.f4639b) {
                                    z = true;
                                    break;
                                } else {
                                    i7 = aVar2.f4614g[i7];
                                    i8++;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            float a3 = bVar2.f4621d.a(a2);
                            if (a3 < 0.0f) {
                                float f3 = (-bVar2.f4619b) / a3;
                                if (f3 < f2) {
                                    i5 = i6;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar3 = this.f4631f[i5];
                    bVar3.f4618a.f4640c = -1;
                    bVar3.b(a2);
                    g gVar2 = bVar3.f4618a;
                    gVar2.f4640c = i5;
                    gVar2.c(bVar3);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public final g a(d.f.a.g.a aVar, String str) {
        g gVar = (g) this.l.f4624b.a();
        if (gVar == null) {
            gVar = new g(aVar);
            gVar.f4644g = aVar;
        } else {
            gVar.a();
            gVar.f4644g = aVar;
        }
        int i2 = this.n;
        int i3 = p;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            p = i4;
            this.m = (g[]) Arrays.copyOf(this.m, i4);
        }
        g[] gVarArr = this.m;
        int i5 = this.n;
        this.n = i5 + 1;
        gVarArr[i5] = gVar;
        return gVar;
    }

    public void c(g gVar, g gVar2, int i2, int i3) {
        b b2 = b();
        g c2 = c();
        c2.f4641d = 0;
        b2.b(gVar, gVar2, c2, i2);
        if (i3 != 6) {
            int a2 = (int) (b2.f4621d.a(c2) * -1.0f);
            b2.f4621d.a(a(i3, (String) null), (float) a2);
        }
        a(b2);
    }

    public void a(a aVar) throws Exception {
        float f2;
        boolean z;
        c((b) aVar);
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.f4635j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f4631f;
            if (bVarArr[i2].f4618a.f4644g != d.f.a.g.a.UNRESTRICTED && bVarArr[i2].f4619b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3++;
                float f3 = Float.MAX_VALUE;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                int i7 = 0;
                while (i6 < this.f4635j) {
                    b bVar = this.f4631f[i6];
                    if (bVar.f4618a.f4644g != d.f.a.g.a.UNRESTRICTED && !bVar.f4622e && bVar.f4619b < f2) {
                        int i8 = 1;
                        while (i8 < this.f4634i) {
                            g gVar = this.l.f4625c[i8];
                            float a2 = bVar.f4621d.a(gVar);
                            if (a2 > f2) {
                                for (int i9 = 0; i9 < 7; i9++) {
                                    float f4 = gVar.f4643f[i9] / a2;
                                    if ((f4 < f3 && i9 == i7) || i9 > i7) {
                                        i7 = i9;
                                        f3 = f4;
                                        i4 = i6;
                                        i5 = i8;
                                    }
                                }
                            }
                            i8++;
                            f2 = 0.0f;
                        }
                    }
                    i6++;
                    f2 = 0.0f;
                }
                if (i4 != -1) {
                    b bVar2 = this.f4631f[i4];
                    bVar2.f4618a.f4640c = -1;
                    bVar2.b(this.l.f4625c[i5]);
                    g gVar2 = bVar2.f4618a;
                    gVar2.f4640c = i4;
                    gVar2.c(bVar2);
                } else {
                    z2 = true;
                }
                if (i3 > this.f4634i / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
            }
        }
        b(aVar);
        a();
    }

    public void b(g gVar, g gVar2, int i2, int i3) {
        b b2 = b();
        g c2 = c();
        c2.f4641d = 0;
        b2.a(gVar, gVar2, c2, i2);
        if (i3 != 6) {
            int a2 = (int) (b2.f4621d.a(c2) * -1.0f);
            b2.f4621d.a(a(i3, (String) null), (float) a2);
        }
        a(b2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x00e9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(d.f.a.b r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            int r2 = r0.f4635j
            r3 = 1
            int r2 = r2 + r3
            int r4 = r0.k
            if (r2 >= r4) goto L_0x0016
            int r2 = r0.f4634i
            int r2 = r2 + r3
            int r4 = r0.f4630e
            if (r2 < r4) goto L_0x0019
        L_0x0016:
            r18.d()
        L_0x0019:
            boolean r2 = r1.f4622e
            if (r2 != 0) goto L_0x019a
            r18.c(r19)
            d.f.a.g r2 = r1.f4618a
            r5 = 0
            if (r2 != 0) goto L_0x0033
            float r2 = r1.f4619b
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0033
            d.f.a.a r2 = r1.f4621d
            int r2 = r2.f4608a
            if (r2 != 0) goto L_0x0033
            r2 = r3
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            if (r2 == 0) goto L_0x0037
            return
        L_0x0037:
            float r2 = r1.f4619b
            int r6 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            r7 = -1
            if (r6 >= 0) goto L_0x005c
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 * r6
            r1.f4619b = r2
            d.f.a.a r2 = r1.f4621d
            int r8 = r2.f4616i
            r9 = 0
        L_0x0048:
            if (r8 == r7) goto L_0x005c
            int r10 = r2.f4608a
            if (r9 >= r10) goto L_0x005c
            float[] r10 = r2.f4615h
            r11 = r10[r8]
            float r11 = r11 * r6
            r10[r8] = r11
            int[] r10 = r2.f4614g
            r8 = r10[r8]
            int r9 = r9 + 1
            goto L_0x0048
        L_0x005c:
            d.f.a.a r2 = r1.f4621d
            int r6 = r2.f4616i
            r12 = r5
            r14 = r12
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r15 = 0
        L_0x0067:
            if (r6 == r7) goto L_0x00f2
            int r4 = r2.f4608a
            if (r9 >= r4) goto L_0x00f2
            float[] r4 = r2.f4615h
            r16 = r4[r6]
            r17 = 981668463(0x3a83126f, float:0.001)
            d.f.a.c r7 = r2.f4610c
            d.f.a.g[] r7 = r7.f4625c
            int[] r8 = r2.f4613f
            r8 = r8[r6]
            r7 = r7[r8]
            int r8 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0091
            r8 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r8 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x009e
            r4[r6] = r5
            d.f.a.b r4 = r2.f4609b
            r7.b(r4)
            goto L_0x009c
        L_0x0091:
            int r8 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r8 >= 0) goto L_0x009e
            r4[r6] = r5
            d.f.a.b r4 = r2.f4609b
            r7.b(r4)
        L_0x009c:
            r16 = r5
        L_0x009e:
            int r4 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x00e9
            d.f.a.g$a r4 = r7.f4644g
            d.f.a.g$a r8 = d.f.a.g.a.UNRESTRICTED
            if (r4 != r8) goto L_0x00c6
            if (r11 != 0) goto L_0x00af
            boolean r4 = r2.b(r7)
            goto L_0x00b7
        L_0x00af:
            int r4 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
            boolean r4 = r2.b(r7)
        L_0x00b7:
            r13 = r4
            goto L_0x00c2
        L_0x00b9:
            if (r13 != 0) goto L_0x00e9
            boolean r4 = r2.b(r7)
            if (r4 == 0) goto L_0x00e9
            r13 = r3
        L_0x00c2:
            r11 = r7
            r12 = r16
            goto L_0x00e9
        L_0x00c6:
            if (r11 != 0) goto L_0x00e9
            int r4 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x00e9
            if (r10 != 0) goto L_0x00d3
            boolean r4 = r2.b(r7)
            goto L_0x00db
        L_0x00d3:
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x00dd
            boolean r4 = r2.b(r7)
        L_0x00db:
            r15 = r4
            goto L_0x00e6
        L_0x00dd:
            if (r15 != 0) goto L_0x00e9
            boolean r4 = r2.b(r7)
            if (r4 == 0) goto L_0x00e9
            r15 = r3
        L_0x00e6:
            r10 = r7
            r14 = r16
        L_0x00e9:
            int[] r4 = r2.f4614g
            r6 = r4[r6]
            int r9 = r9 + 1
            r7 = -1
            goto L_0x0067
        L_0x00f2:
            if (r11 == 0) goto L_0x00f5
            r10 = r11
        L_0x00f5:
            if (r10 != 0) goto L_0x00f9
            r2 = r3
            goto L_0x00fd
        L_0x00f9:
            r1.b(r10)
            r2 = 0
        L_0x00fd:
            d.f.a.a r4 = r1.f4621d
            int r4 = r4.f4608a
            if (r4 != 0) goto L_0x0105
            r1.f4622e = r3
        L_0x0105:
            if (r2 == 0) goto L_0x0182
            int r2 = r0.f4634i
            int r2 = r2 + r3
            int r4 = r0.f4630e
            if (r2 < r4) goto L_0x0111
            r18.d()
        L_0x0111:
            d.f.a.g$a r2 = d.f.a.g.a.SLACK
            r4 = 0
            d.f.a.g r2 = r0.a(r2, r4)
            int r4 = r0.f4626a
            int r4 = r4 + r3
            r0.f4626a = r4
            int r6 = r0.f4634i
            int r6 = r6 + r3
            r0.f4634i = r6
            r2.f4639b = r4
            d.f.a.c r6 = r0.l
            d.f.a.g[] r6 = r6.f4625c
            r6[r4] = r2
            r1.f4618a = r2
            r18.b(r19)
            d.f.a.e$a r4 = r0.o
            d.f.a.b r4 = (d.f.a.b) r4
            if (r4 == 0) goto L_0x0180
            r6 = 0
            r4.f4618a = r6
            d.f.a.a r6 = r4.f4621d
            r6.a()
            r6 = 0
        L_0x013e:
            d.f.a.a r7 = r1.f4621d
            int r8 = r7.f4608a
            if (r6 >= r8) goto L_0x0156
            d.f.a.g r7 = r7.a(r6)
            d.f.a.a r8 = r1.f4621d
            float r8 = r8.b(r6)
            d.f.a.a r9 = r4.f4621d
            r9.a(r7, r8, r3)
            int r6 = r6 + 1
            goto L_0x013e
        L_0x0156:
            d.f.a.e$a r4 = r0.o
            r0.b(r4)
            int r4 = r2.f4640c
            r6 = -1
            if (r4 != r6) goto L_0x017e
            d.f.a.g r4 = r1.f4618a
            if (r4 != r2) goto L_0x0170
            d.f.a.a r4 = r1.f4621d
            r6 = 0
            d.f.a.g r2 = r4.a(r6, r2)
            if (r2 == 0) goto L_0x0170
            r1.b(r2)
        L_0x0170:
            boolean r2 = r1.f4622e
            if (r2 != 0) goto L_0x0179
            d.f.a.g r2 = r1.f4618a
            r2.c(r1)
        L_0x0179:
            int r2 = r0.f4635j
            int r2 = r2 - r3
            r0.f4635j = r2
        L_0x017e:
            r2 = r3
            goto L_0x0183
        L_0x0180:
            r2 = 0
            throw r2
        L_0x0182:
            r2 = 0
        L_0x0183:
            d.f.a.g r4 = r1.f4618a
            if (r4 == 0) goto L_0x0194
            d.f.a.g$a r4 = r4.f4644g
            d.f.a.g$a r6 = d.f.a.g.a.UNRESTRICTED
            if (r4 == r6) goto L_0x0195
            float r4 = r1.f4619b
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0194
            goto L_0x0195
        L_0x0194:
            r3 = 0
        L_0x0195:
            if (r3 != 0) goto L_0x0198
            return
        L_0x0198:
            r4 = r2
            goto L_0x019b
        L_0x019a:
            r4 = 0
        L_0x019b:
            if (r4 != 0) goto L_0x01a0
            r18.b(r19)
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.e.a(d.f.a.b):void");
    }

    public final void a() {
        for (int i2 = 0; i2 < this.f4635j; i2++) {
            b bVar = this.f4631f[i2];
            bVar.f4618a.f4642e = bVar.f4619b;
        }
    }

    public void a(g gVar, g gVar2, int i2, float f2, g gVar3, g gVar4, int i3, int i4) {
        b b2 = b();
        if (gVar2 == gVar3) {
            b2.f4621d.a(gVar, 1.0f);
            b2.f4621d.a(gVar4, 1.0f);
            b2.f4621d.a(gVar2, -2.0f);
        } else if (f2 == 0.5f) {
            b2.f4621d.a(gVar, 1.0f);
            b2.f4621d.a(gVar2, -1.0f);
            b2.f4621d.a(gVar3, -1.0f);
            b2.f4621d.a(gVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                b2.f4619b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            b2.f4621d.a(gVar, -1.0f);
            b2.f4621d.a(gVar2, 1.0f);
            b2.f4619b = (float) i2;
        } else if (f2 >= 1.0f) {
            b2.f4621d.a(gVar3, -1.0f);
            b2.f4621d.a(gVar4, 1.0f);
            b2.f4619b = (float) i3;
        } else {
            float f3 = 1.0f - f2;
            b2.f4621d.a(gVar, f3 * 1.0f);
            b2.f4621d.a(gVar2, f3 * -1.0f);
            b2.f4621d.a(gVar3, -1.0f * f2);
            b2.f4621d.a(gVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                b2.f4619b = (((float) i3) * f2) + (((float) (-i2)) * f3);
            }
        }
        if (i4 != 6) {
            b2.a(this, i4);
        }
        a(b2);
    }

    public void a(g gVar, g gVar2, g gVar3, g gVar4, float f2, int i2) {
        b b2 = b();
        b2.a(gVar, gVar2, gVar3, gVar4, f2);
        if (i2 != 6) {
            b2.a(this, i2);
        }
        a(b2);
    }

    public b a(g gVar, g gVar2, int i2, int i3) {
        b b2 = b();
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            b2.f4619b = (float) i2;
        }
        if (!z) {
            b2.f4621d.a(gVar, -1.0f);
            b2.f4621d.a(gVar2, 1.0f);
        } else {
            b2.f4621d.a(gVar, 1.0f);
            b2.f4621d.a(gVar2, -1.0f);
        }
        if (i3 != 6) {
            b2.a(this, i3);
        }
        a(b2);
        return b2;
    }

    public void a(g gVar, int i2) {
        int i3 = gVar.f4640c;
        if (i3 != -1) {
            b bVar = this.f4631f[i3];
            if (bVar.f4622e) {
                bVar.f4619b = (float) i2;
            } else if (bVar.f4621d.f4608a == 0) {
                bVar.f4622e = true;
                bVar.f4619b = (float) i2;
            } else {
                b b2 = b();
                if (i2 < 0) {
                    b2.f4619b = (float) (i2 * -1);
                    b2.f4621d.a(gVar, 1.0f);
                } else {
                    b2.f4619b = (float) i2;
                    b2.f4621d.a(gVar, -1.0f);
                }
                a(b2);
            }
        } else {
            b b3 = b();
            b3.f4618a = gVar;
            float f2 = (float) i2;
            gVar.f4642e = f2;
            b3.f4619b = f2;
            b3.f4622e = true;
            a(b3);
        }
    }
}
