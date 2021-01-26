package d.f.a.h;

import d.f.a.c;
import d.f.a.e;
import d.f.a.h.c.C0033c;
import d.f.a.h.c.b;
import java.util.ArrayList;

/* compiled from: ConstraintWidget */
public class d {
    public static float j0 = 0.5f;
    public c[] A;
    public ArrayList<c> B;
    public a[] C;
    public d D;
    public int E;
    public int F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public float V;
    public float W;
    public Object X;
    public int Y;
    public String Z;

    /* renamed from: a reason: collision with root package name */
    public int f4690a = -1;
    public String a0;

    /* renamed from: b reason: collision with root package name */
    public int f4691b = -1;
    public boolean b0;

    /* renamed from: c reason: collision with root package name */
    public k f4692c;
    public boolean c0;

    /* renamed from: d reason: collision with root package name */
    public k f4693d;
    public boolean d0;

    /* renamed from: e reason: collision with root package name */
    public int f4694e = 0;
    public int e0;

    /* renamed from: f reason: collision with root package name */
    public int f4695f = 0;
    public int f0;

    /* renamed from: g reason: collision with root package name */
    public int[] f4696g = new int[2];
    public float[] g0;

    /* renamed from: h reason: collision with root package name */
    public int f4697h = 0;
    public d[] h0;

    /* renamed from: i reason: collision with root package name */
    public int f4698i = 0;
    public d[] i0;

    /* renamed from: j reason: collision with root package name */
    public float f4699j = 1.0f;
    public int k = 0;
    public int l = 0;
    public float m = 1.0f;
    public int n = -1;
    public float o = 1.0f;
    public f p = null;
    public int[] q = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float r = 0.0f;
    public c s = new c(this, C0033c.LEFT);
    public c t = new c(this, C0033c.TOP);
    public c u = new c(this, C0033c.RIGHT);
    public c v = new c(this, C0033c.BOTTOM);
    public c w = new c(this, C0033c.BASELINE);
    public c x = new c(this, C0033c.CENTER_X);
    public c y = new c(this, C0033c.CENTER_Y);
    public c z;

    /* compiled from: ConstraintWidget */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, C0033c.CENTER);
        this.z = cVar;
        this.A = new c[]{this.s, this.u, this.t, this.v, this.w, cVar};
        ArrayList<c> arrayList = new ArrayList<>();
        this.B = arrayList;
        a aVar = a.FIXED;
        this.C = new a[]{aVar, aVar};
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        float f2 = j0;
        this.V = f2;
        this.W = f2;
        this.Y = 0;
        this.Z = null;
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new d[]{null, null};
        this.i0 = new d[]{null, null};
        arrayList.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public void a(int i2) {
        for (int i3 = 0; i3 < 6; i3++) {
            j jVar = this.A[i3].f4664a;
            c cVar = jVar.f4716c;
            c cVar2 = cVar.f4667d;
            if (cVar2 != null) {
                if (cVar2.f4667d == cVar) {
                    jVar.f4721h = 4;
                    cVar2.f4664a.f4721h = 4;
                }
                int a2 = jVar.f4716c.a();
                C0033c cVar3 = jVar.f4716c.f4666c;
                if (cVar3 == C0033c.RIGHT || cVar3 == C0033c.BOTTOM) {
                    a2 = -a2;
                }
                jVar.a(cVar2.f4664a, a2);
            }
        }
        j jVar2 = this.s.f4664a;
        j jVar3 = this.t.f4664a;
        j jVar4 = this.u.f4664a;
        j jVar5 = this.v.f4664a;
        boolean z2 = (i2 & 8) == 8;
        boolean z3 = this.C[0] == a.MATCH_CONSTRAINT && i.a(this, 0);
        if (!(jVar2.f4721h == 4 || jVar4.f4721h == 4)) {
            if (this.C[0] == a.FIXED || (z3 && this.Y == 8)) {
                if (this.s.f4667d == null && this.u.f4667d == null) {
                    jVar2.f4721h = 1;
                    jVar4.f4721h = 1;
                    if (z2) {
                        jVar4.a(jVar2, 1, f());
                    } else {
                        int h2 = h();
                        jVar4.f4717d = jVar2;
                        jVar4.f4718e = (float) h2;
                        jVar2.f4725a.add(jVar4);
                    }
                } else if (this.s.f4667d != null && this.u.f4667d == null) {
                    jVar2.f4721h = 1;
                    jVar4.f4721h = 1;
                    if (z2) {
                        jVar4.a(jVar2, 1, f());
                    } else {
                        int h3 = h();
                        jVar4.f4717d = jVar2;
                        jVar4.f4718e = (float) h3;
                        jVar2.f4725a.add(jVar4);
                    }
                } else if (this.s.f4667d == null && this.u.f4667d != null) {
                    jVar2.f4721h = 1;
                    jVar4.f4721h = 1;
                    int i4 = -h();
                    jVar2.f4717d = jVar4;
                    jVar2.f4718e = (float) i4;
                    jVar4.f4725a.add(jVar2);
                    if (z2) {
                        jVar2.a(jVar4, -1, f());
                    } else {
                        int i5 = -h();
                        jVar2.f4717d = jVar4;
                        jVar2.f4718e = (float) i5;
                        jVar4.f4725a.add(jVar2);
                    }
                } else if (!(this.s.f4667d == null || this.u.f4667d == null)) {
                    jVar2.f4721h = 2;
                    jVar4.f4721h = 2;
                    if (z2) {
                        f().f4725a.add(jVar2);
                        f().f4725a.add(jVar4);
                        k f2 = f();
                        jVar2.f4722i = jVar4;
                        jVar2.l = f2;
                        jVar2.m = -1;
                        k f3 = f();
                        jVar4.f4722i = jVar2;
                        jVar4.l = f3;
                        jVar4.m = 1;
                    } else {
                        jVar2.f4722i = jVar4;
                        jVar4.f4722i = jVar2;
                    }
                }
            } else if (z3) {
                int h4 = h();
                jVar2.f4721h = 1;
                jVar4.f4721h = 1;
                if (this.s.f4667d == null && this.u.f4667d == null) {
                    if (z2) {
                        jVar4.a(jVar2, 1, f());
                    } else {
                        jVar4.f4717d = jVar2;
                        jVar4.f4718e = (float) h4;
                        jVar2.f4725a.add(jVar4);
                    }
                } else if (this.s.f4667d == null || this.u.f4667d != null) {
                    if (this.s.f4667d != null || this.u.f4667d == null) {
                        if (!(this.s.f4667d == null || this.u.f4667d == null)) {
                            if (z2) {
                                f().f4725a.add(jVar2);
                                f().f4725a.add(jVar4);
                            }
                            if (this.G == 0.0f) {
                                jVar2.f4721h = 3;
                                jVar4.f4721h = 3;
                                jVar2.f4722i = jVar4;
                                jVar4.f4722i = jVar2;
                            } else {
                                jVar2.f4721h = 2;
                                jVar4.f4721h = 2;
                                jVar2.f4722i = jVar4;
                                jVar4.f4722i = jVar2;
                                f(h4);
                            }
                        }
                    } else if (z2) {
                        jVar2.a(jVar4, -1, f());
                    } else {
                        int i6 = -h4;
                        jVar2.f4717d = jVar4;
                        jVar2.f4718e = (float) i6;
                        jVar4.f4725a.add(jVar2);
                    }
                } else if (z2) {
                    jVar4.a(jVar2, 1, f());
                } else {
                    jVar4.f4717d = jVar2;
                    jVar4.f4718e = (float) h4;
                    jVar2.f4725a.add(jVar4);
                }
            }
        }
        boolean z4 = this.C[1] == a.MATCH_CONSTRAINT && i.a(this, 1);
        if (jVar3.f4721h != 4 && jVar5.f4721h != 4) {
            if (this.C[1] == a.FIXED || (z4 && this.Y == 8)) {
                if (this.t.f4667d == null && this.v.f4667d == null) {
                    jVar3.f4721h = 1;
                    jVar5.f4721h = 1;
                    if (z2) {
                        jVar5.a(jVar3, 1, e());
                    } else {
                        int c2 = c();
                        jVar5.f4717d = jVar3;
                        jVar5.f4718e = (float) c2;
                        jVar3.f4725a.add(jVar5);
                    }
                    c cVar4 = this.w;
                    if (cVar4.f4667d != null) {
                        j jVar6 = cVar4.f4664a;
                        jVar6.f4721h = 1;
                        jVar3.a(1, jVar6, -this.Q);
                    }
                } else if (this.t.f4667d != null && this.v.f4667d == null) {
                    jVar3.f4721h = 1;
                    jVar5.f4721h = 1;
                    if (z2) {
                        jVar5.a(jVar3, 1, e());
                    } else {
                        int c3 = c();
                        jVar5.f4717d = jVar3;
                        jVar5.f4718e = (float) c3;
                        jVar3.f4725a.add(jVar5);
                    }
                    int i7 = this.Q;
                    if (i7 > 0) {
                        this.w.f4664a.a(1, jVar3, i7);
                    }
                } else if (this.t.f4667d == null && this.v.f4667d != null) {
                    jVar3.f4721h = 1;
                    jVar5.f4721h = 1;
                    if (z2) {
                        jVar3.a(jVar5, -1, e());
                    } else {
                        int i8 = -c();
                        jVar3.f4717d = jVar5;
                        jVar3.f4718e = (float) i8;
                        jVar5.f4725a.add(jVar3);
                    }
                    int i9 = this.Q;
                    if (i9 > 0) {
                        this.w.f4664a.a(1, jVar3, i9);
                    }
                } else if (this.t.f4667d != null && this.v.f4667d != null) {
                    jVar3.f4721h = 2;
                    jVar5.f4721h = 2;
                    if (z2) {
                        k e2 = e();
                        jVar3.f4722i = jVar5;
                        jVar3.l = e2;
                        jVar3.m = -1;
                        k e3 = e();
                        jVar5.f4722i = jVar3;
                        jVar5.l = e3;
                        jVar5.m = 1;
                        e().f4725a.add(jVar3);
                        f().f4725a.add(jVar5);
                    } else {
                        jVar3.f4722i = jVar5;
                        jVar5.f4722i = jVar3;
                    }
                    int i10 = this.Q;
                    if (i10 > 0) {
                        this.w.f4664a.a(1, jVar3, i10);
                    }
                }
            } else if (z4) {
                int c4 = c();
                jVar3.f4721h = 1;
                jVar5.f4721h = 1;
                if (this.t.f4667d == null && this.v.f4667d == null) {
                    if (z2) {
                        jVar5.a(jVar3, 1, e());
                        return;
                    }
                    jVar5.f4717d = jVar3;
                    jVar5.f4718e = (float) c4;
                    jVar3.f4725a.add(jVar5);
                } else if (this.t.f4667d == null || this.v.f4667d != null) {
                    if (this.t.f4667d != null || this.v.f4667d == null) {
                        if (this.t.f4667d != null && this.v.f4667d != null) {
                            if (z2) {
                                e().f4725a.add(jVar3);
                                f().f4725a.add(jVar5);
                            }
                            if (this.G == 0.0f) {
                                jVar3.f4721h = 3;
                                jVar5.f4721h = 3;
                                jVar3.f4722i = jVar5;
                                jVar5.f4722i = jVar3;
                                return;
                            }
                            jVar3.f4721h = 2;
                            jVar5.f4721h = 2;
                            jVar3.f4722i = jVar5;
                            jVar5.f4722i = jVar3;
                            e(c4);
                            int i11 = this.Q;
                            if (i11 > 0) {
                                this.w.f4664a.a(1, jVar3, i11);
                            }
                        }
                    } else if (z2) {
                        jVar3.a(jVar5, -1, e());
                    } else {
                        int i12 = -c4;
                        jVar3.f4717d = jVar5;
                        jVar3.f4718e = (float) i12;
                        jVar5.f4725a.add(jVar3);
                    }
                } else if (z2) {
                    jVar5.a(jVar3, 1, e());
                } else {
                    jVar5.f4717d = jVar3;
                    jVar5.f4718e = (float) c4;
                    jVar3.f4725a.add(jVar5);
                }
            }
        }
    }

    public void b(e eVar) {
        eVar.a((Object) this.s);
        eVar.a((Object) this.t);
        eVar.a((Object) this.u);
        eVar.a((Object) this.v);
        if (this.Q > 0) {
            eVar.a((Object) this.w);
        }
    }

    public int c() {
        if (this.Y == 8) {
            return 0;
        }
        return this.F;
    }

    public a d() {
        return this.C[0];
    }

    public k e() {
        if (this.f4693d == null) {
            this.f4693d = new k();
        }
        return this.f4693d;
    }

    public k f() {
        if (this.f4692c == null) {
            this.f4692c = new k();
        }
        return this.f4692c;
    }

    public a g() {
        return this.C[1];
    }

    public int h() {
        if (this.Y == 8) {
            return 0;
        }
        return this.E;
    }

    public boolean i() {
        if (this.s.f4664a.f4726b == 1 && this.u.f4664a.f4726b == 1 && this.t.f4664a.f4726b == 1 && this.v.f4664a.f4726b == 1) {
            return true;
        }
        return false;
    }

    public void j() {
        this.s.c();
        this.t.c();
        this.u.c();
        this.v.c();
        this.w.c();
        this.x.c();
        this.y.c();
        this.z.c();
        this.D = null;
        this.r = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f2 = j0;
        this.V = f2;
        this.W = f2;
        a[] aVarArr = this.C;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.X = null;
        this.Y = 0;
        this.a0 = null;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f4690a = -1;
        this.f4691b = -1;
        int[] iArr = this.q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f4694e = 0;
        this.f4695f = 0;
        this.f4699j = 1.0f;
        this.m = 1.0f;
        this.f4698i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.f4697h = 0;
        this.k = 0;
        this.n = -1;
        this.o = 1.0f;
        k kVar = this.f4692c;
        if (kVar != null) {
            kVar.f4726b = 0;
            kVar.f4725a.clear();
            kVar.f4724c = 0.0f;
        }
        k kVar2 = this.f4693d;
        if (kVar2 != null) {
            kVar2.f4726b = 0;
            kVar2.f4725a.clear();
            kVar2.f4724c = 0.0f;
        }
        this.p = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
    }

    public void k() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].f4664a.e();
        }
    }

    public void l() {
    }

    public void m() {
        int i2 = this.I;
        int i3 = this.J;
        this.M = i2;
        this.N = i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = " ";
        String str2 = "";
        sb.append(this.a0 != null ? e.a.a.a.a.a(e.a.a.a.a.a("type: "), this.a0, str) : str2);
        if (this.Z != null) {
            str2 = e.a.a.a.a.a(e.a.a.a.a.a("id: "), this.Z, str);
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        String str3 = " x ";
        sb.append(str3);
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.T);
        sb.append(str3);
        return e.a.a.a.a.a(sb, this.U, ")");
    }

    public final boolean d(int i2) {
        int i3 = i2 * 2;
        c[] cVarArr = this.A;
        if (!(cVarArr[i3].f4667d == null || cVarArr[i3].f4667d.f4667d == cVarArr[i3])) {
            int i4 = i3 + 1;
            if (cVarArr[i4].f4667d != null && cVarArr[i4].f4667d.f4667d == cVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    public int c(int i2) {
        if (i2 == 0) {
            return h();
        }
        if (i2 == 1) {
            return c();
        }
        return 0;
    }

    public void e(int i2) {
        this.F = i2;
        int i3 = this.S;
        if (i2 < i3) {
            this.F = i3;
        }
    }

    public void f(int i2) {
        this.E = i2;
        int i3 = this.R;
        if (i2 < i3) {
            this.E = i3;
        }
    }

    public void c(int i2, int i3) {
        this.J = i2;
        int i4 = i3 - i2;
        this.F = i4;
        int i5 = this.S;
        if (i4 < i5) {
            this.F = i5;
        }
    }

    public ArrayList<c> b() {
        return this.B;
    }

    public void b(int i2, int i3) {
        this.O = i2;
        this.P = i3;
    }

    public void c(e eVar) {
        int b2 = eVar.b((Object) this.s);
        int b3 = eVar.b((Object) this.t);
        int b4 = eVar.b((Object) this.u);
        int b5 = eVar.b((Object) this.v);
        int i2 = b5 - b3;
        if (b4 - b2 < 0 || i2 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        int i3 = b4 - b2;
        int i4 = b5 - b3;
        this.I = b2;
        this.J = b3;
        if (this.Y == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] == a.FIXED) {
            int i5 = this.E;
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (this.C[1] == a.FIXED) {
            int i6 = this.F;
            if (i4 < i6) {
                i4 = i6;
            }
        }
        this.E = i3;
        this.F = i4;
        int i7 = this.S;
        if (i4 < i7) {
            this.F = i7;
        }
        int i8 = this.E;
        int i9 = this.R;
        if (i8 < i9) {
            this.E = i9;
        }
        this.c0 = true;
    }

    public a b(int i2) {
        if (i2 == 0) {
            return d();
        }
        if (i2 == 1) {
            return g();
        }
        return null;
    }

    public void b(a aVar) {
        this.C[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            e(this.U);
        }
    }

    public void a(c cVar) {
        this.s.d();
        this.t.d();
        this.u.d();
        this.v.d();
        this.w.d();
        this.z.d();
        this.x.d();
        this.y.d();
    }

    public void a(int i2, int i3, int i4) {
        if (i4 == 0) {
            this.I = i2;
            int i5 = i3 - i2;
            this.E = i5;
            int i6 = this.R;
            if (i5 < i6) {
                this.E = i6;
            }
        } else if (i4 == 1) {
            this.J = i2;
            int i7 = i3 - i2;
            this.F = i7;
            int i8 = this.S;
            if (i7 < i8) {
                this.F = i8;
            }
        }
        this.c0 = true;
    }

    public void a(int i2, int i3) {
        this.I = i2;
        int i4 = i3 - i2;
        this.E = i4;
        int i5 = this.R;
        if (i4 < i5) {
            this.E = i5;
        }
    }

    public boolean a() {
        return this.Y != 8;
    }

    public void a(C0033c cVar, d dVar, C0033c cVar2, int i2, int i3) {
        a(cVar).a(dVar.a(cVar2), i2, i3, b.STRONG, 0, true);
    }

    public c a(C0033c cVar) {
        switch (cVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public void a(a aVar) {
        this.C[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            f(this.T);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:182:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x034d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(d.f.a.e r39) {
        /*
            r38 = this;
            r15 = r38
            r14 = r39
            d.f.a.h.c r0 = r15.s
            d.f.a.g r21 = r14.a(r0)
            d.f.a.h.c r0 = r15.u
            d.f.a.g r10 = r14.a(r0)
            d.f.a.h.c r0 = r15.t
            d.f.a.g r6 = r14.a(r0)
            d.f.a.h.c r0 = r15.v
            d.f.a.g r4 = r14.a(r0)
            d.f.a.h.c r0 = r15.w
            d.f.a.g r3 = r14.a(r0)
            d.f.a.h.d r0 = r15.D
            r1 = 8
            r2 = 1
            r13 = 0
            if (r0 == 0) goto L_0x00d7
            if (r0 == 0) goto L_0x0036
            d.f.a.h.d$a[] r0 = r0.C
            r0 = r0[r13]
            d.f.a.h.d$a r5 = d.f.a.h.d.a.WRAP_CONTENT
            if (r0 != r5) goto L_0x0036
            r0 = r2
            goto L_0x0037
        L_0x0036:
            r0 = r13
        L_0x0037:
            d.f.a.h.d r5 = r15.D
            if (r5 == 0) goto L_0x0045
            d.f.a.h.d$a[] r5 = r5.C
            r5 = r5[r2]
            d.f.a.h.d$a r7 = d.f.a.h.d.a.WRAP_CONTENT
            if (r5 != r7) goto L_0x0045
            r5 = r2
            goto L_0x0046
        L_0x0045:
            r5 = r13
        L_0x0046:
            boolean r7 = r15.d(r13)
            if (r7 == 0) goto L_0x0055
            d.f.a.h.d r7 = r15.D
            d.f.a.h.e r7 = (d.f.a.h.e) r7
            r7.a(r15, r13)
        L_0x0053:
            r7 = r2
            goto L_0x006b
        L_0x0055:
            d.f.a.h.c r7 = r15.s
            d.f.a.h.c r8 = r7.f4667d
            if (r8 == 0) goto L_0x005f
            d.f.a.h.c r8 = r8.f4667d
            if (r8 == r7) goto L_0x0053
        L_0x005f:
            d.f.a.h.c r7 = r15.u
            d.f.a.h.c r8 = r7.f4667d
            if (r8 == 0) goto L_0x006a
            d.f.a.h.c r8 = r8.f4667d
            if (r8 != r7) goto L_0x006a
            goto L_0x0053
        L_0x006a:
            r7 = r13
        L_0x006b:
            boolean r8 = r15.d(r2)
            if (r8 == 0) goto L_0x007a
            d.f.a.h.d r8 = r15.D
            d.f.a.h.e r8 = (d.f.a.h.e) r8
            r8.a(r15, r2)
        L_0x0078:
            r8 = r2
            goto L_0x0090
        L_0x007a:
            d.f.a.h.c r8 = r15.t
            d.f.a.h.c r9 = r8.f4667d
            if (r9 == 0) goto L_0x0084
            d.f.a.h.c r9 = r9.f4667d
            if (r9 == r8) goto L_0x0078
        L_0x0084:
            d.f.a.h.c r8 = r15.v
            d.f.a.h.c r9 = r8.f4667d
            if (r9 == 0) goto L_0x008f
            d.f.a.h.c r9 = r9.f4667d
            if (r9 != r8) goto L_0x008f
            goto L_0x0078
        L_0x008f:
            r8 = r13
        L_0x0090:
            if (r0 == 0) goto L_0x00ad
            int r9 = r15.Y
            if (r9 == r1) goto L_0x00ad
            d.f.a.h.c r9 = r15.s
            d.f.a.h.c r9 = r9.f4667d
            if (r9 != 0) goto L_0x00ad
            d.f.a.h.c r9 = r15.u
            d.f.a.h.c r9 = r9.f4667d
            if (r9 != 0) goto L_0x00ad
            d.f.a.h.d r9 = r15.D
            d.f.a.h.c r9 = r9.u
            d.f.a.g r9 = r14.a(r9)
            r14.b(r9, r10, r13, r2)
        L_0x00ad:
            if (r5 == 0) goto L_0x00ce
            int r9 = r15.Y
            if (r9 == r1) goto L_0x00ce
            d.f.a.h.c r9 = r15.t
            d.f.a.h.c r9 = r9.f4667d
            if (r9 != 0) goto L_0x00ce
            d.f.a.h.c r9 = r15.v
            d.f.a.h.c r9 = r9.f4667d
            if (r9 != 0) goto L_0x00ce
            d.f.a.h.c r9 = r15.w
            if (r9 != 0) goto L_0x00ce
            d.f.a.h.d r9 = r15.D
            d.f.a.h.c r9 = r9.v
            d.f.a.g r9 = r14.a(r9)
            r14.b(r9, r4, r13, r2)
        L_0x00ce:
            r16 = r0
            r22 = r5
            r20 = r7
            r23 = r8
            goto L_0x00df
        L_0x00d7:
            r16 = r13
            r20 = r16
            r22 = r20
            r23 = r22
        L_0x00df:
            int r0 = r15.E
            int r5 = r15.R
            if (r0 >= r5) goto L_0x00e6
            r0 = r5
        L_0x00e6:
            int r5 = r15.F
            int r7 = r15.S
            if (r5 >= r7) goto L_0x00ed
            r5 = r7
        L_0x00ed:
            d.f.a.h.d$a[] r7 = r15.C
            r7 = r7[r13]
            d.f.a.h.d$a r8 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r7 == r8) goto L_0x00f7
            r7 = r2
            goto L_0x00f8
        L_0x00f7:
            r7 = r13
        L_0x00f8:
            d.f.a.h.d$a[] r8 = r15.C
            r8 = r8[r2]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r8 == r9) goto L_0x0102
            r8 = r2
            goto L_0x0103
        L_0x0102:
            r8 = r13
        L_0x0103:
            int r9 = r15.H
            r15.n = r9
            float r9 = r15.G
            r15.o = r9
            int r11 = r15.f4694e
            int r12 = r15.f4695f
            r17 = 0
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            r17 = 4
            if (r9 <= 0) goto L_0x029a
            int r9 = r15.Y
            if (r9 == r1) goto L_0x029a
            d.f.a.h.d$a[] r1 = r15.C
            r1 = r1[r13]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            r2 = 3
            if (r1 != r9) goto L_0x0127
            if (r11 != 0) goto L_0x0127
            r11 = r2
        L_0x0127:
            d.f.a.h.d$a[] r1 = r15.C
            r9 = 1
            r1 = r1[r9]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r1 != r9) goto L_0x0133
            if (r12 != 0) goto L_0x0133
            r12 = r2
        L_0x0133:
            d.f.a.h.d$a[] r1 = r15.C
            r9 = r1[r13]
            d.f.a.h.d$a r13 = d.f.a.h.d.a.MATCH_CONSTRAINT
            r19 = 1065353216(0x3f800000, float:1.0)
            if (r9 != r13) goto L_0x0235
            r9 = 1
            r1 = r1[r9]
            if (r1 != r13) goto L_0x0235
            if (r11 != r2) goto L_0x0235
            if (r12 != r2) goto L_0x0235
            int r1 = r15.n
            r2 = -1
            if (r1 != r2) goto L_0x0164
            if (r7 == 0) goto L_0x0153
            if (r8 != 0) goto L_0x0153
            r1 = 0
            r15.n = r1
            goto L_0x0164
        L_0x0153:
            if (r7 != 0) goto L_0x0164
            if (r8 == 0) goto L_0x0164
            r1 = 1
            r15.n = r1
            int r1 = r15.H
            if (r1 != r2) goto L_0x0164
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
        L_0x0164:
            int r1 = r15.n
            if (r1 != 0) goto L_0x017c
            d.f.a.h.c r1 = r15.t
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0178
            d.f.a.h.c r1 = r15.v
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x017c
        L_0x0178:
            r1 = 1
            r15.n = r1
            goto L_0x0194
        L_0x017c:
            r1 = 1
            int r2 = r15.n
            if (r2 != r1) goto L_0x0194
            d.f.a.h.c r1 = r15.s
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0191
            d.f.a.h.c r1 = r15.u
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0194
        L_0x0191:
            r1 = 0
            r15.n = r1
        L_0x0194:
            int r1 = r15.n
            r2 = -1
            if (r1 != r2) goto L_0x01e6
            d.f.a.h.c r1 = r15.t
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01b9
            d.f.a.h.c r1 = r15.v
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01b9
            d.f.a.h.c r1 = r15.s
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01b9
            d.f.a.h.c r1 = r15.u
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x01e6
        L_0x01b9:
            d.f.a.h.c r1 = r15.t
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01cd
            d.f.a.h.c r1 = r15.v
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01cd
            r1 = 0
            r15.n = r1
            goto L_0x01e6
        L_0x01cd:
            d.f.a.h.c r1 = r15.s
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01e6
            d.f.a.h.c r1 = r15.u
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x01e6
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
            r1 = 1
            r15.n = r1
        L_0x01e6:
            int r1 = r15.n
            r2 = -1
            if (r1 != r2) goto L_0x0200
            if (r16 == 0) goto L_0x01f3
            if (r22 != 0) goto L_0x01f3
            r1 = 0
            r15.n = r1
            goto L_0x0200
        L_0x01f3:
            if (r16 != 0) goto L_0x0200
            if (r22 == 0) goto L_0x0200
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
            r1 = 1
            r15.n = r1
        L_0x0200:
            int r1 = r15.n
            r2 = -1
            if (r1 != r2) goto L_0x0222
            int r1 = r15.f4697h
            if (r1 <= 0) goto L_0x0211
            int r1 = r15.k
            if (r1 != 0) goto L_0x0211
            r1 = 0
            r15.n = r1
            goto L_0x0222
        L_0x0211:
            int r1 = r15.f4697h
            if (r1 != 0) goto L_0x0222
            int r1 = r15.k
            if (r1 <= 0) goto L_0x0222
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
            r1 = 1
            r15.n = r1
        L_0x0222:
            int r1 = r15.n
            r2 = -1
            if (r1 != r2) goto L_0x028f
            if (r16 == 0) goto L_0x028f
            if (r22 == 0) goto L_0x028f
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
            r1 = 1
            r15.n = r1
            goto L_0x028f
        L_0x0235:
            d.f.a.h.d$a[] r1 = r15.C
            r7 = 0
            r8 = r1[r7]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r8 != r9) goto L_0x025e
            if (r11 != r2) goto L_0x025e
            r15.n = r7
            float r0 = r15.o
            int r2 = r15.F
            float r2 = (float) r2
            float r0 = r0 * r2
            int r0 = (int) r0
            r7 = 1
            r1 = r1[r7]
            r27 = r0
            r28 = r5
            if (r1 == r9) goto L_0x0257
            r30 = r12
            r29 = r17
            goto L_0x02a2
        L_0x0257:
            r26 = r7
            r29 = r11
            r30 = r12
            goto L_0x02a4
        L_0x025e:
            r7 = 1
            d.f.a.h.d$a[] r1 = r15.C
            r1 = r1[r7]
            d.f.a.h.d$a r8 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x028f
            if (r12 != r2) goto L_0x028f
            r15.n = r7
            int r1 = r15.H
            r2 = -1
            if (r1 != r2) goto L_0x0276
            float r1 = r15.o
            float r1 = r19 / r1
            r15.o = r1
        L_0x0276:
            float r1 = r15.o
            int r2 = r15.E
            float r2 = (float) r2
            float r1 = r1 * r2
            int r1 = (int) r1
            d.f.a.h.d$a[] r2 = r15.C
            r5 = 0
            r2 = r2[r5]
            d.f.a.h.d$a r5 = d.f.a.h.d.a.MATCH_CONSTRAINT
            r27 = r0
            r28 = r1
            r29 = r11
            if (r2 == r5) goto L_0x0295
            r30 = r17
            goto L_0x02a2
        L_0x028f:
            r27 = r0
            r28 = r5
            r29 = r11
        L_0x0295:
            r30 = r12
            r26 = 1
            goto L_0x02a4
        L_0x029a:
            r27 = r0
            r28 = r5
            r29 = r11
            r30 = r12
        L_0x02a2:
            r26 = 0
        L_0x02a4:
            int[] r0 = r15.f4696g
            r1 = 0
            r0[r1] = r29
            r1 = 1
            r0[r1] = r30
            if (r26 == 0) goto L_0x02b8
            int r0 = r15.n
            r2 = -1
            if (r0 == 0) goto L_0x02b5
            if (r0 != r2) goto L_0x02b9
        L_0x02b5:
            r25 = 1
            goto L_0x02bb
        L_0x02b8:
            r2 = -1
        L_0x02b9:
            r25 = 0
        L_0x02bb:
            d.f.a.h.d$a[] r0 = r15.C
            r1 = 0
            r0 = r0[r1]
            d.f.a.h.d$a r1 = d.f.a.h.d.a.WRAP_CONTENT
            if (r0 != r1) goto L_0x02cb
            boolean r0 = r15 instanceof d.f.a.h.e
            if (r0 == 0) goto L_0x02cb
            r31 = 1
            goto L_0x02cd
        L_0x02cb:
            r31 = 0
        L_0x02cd:
            d.f.a.h.c r0 = r15.z
            boolean r0 = r0.b()
            r24 = 1
            r32 = r0 ^ 1
            int r0 = r15.f4690a
            r1 = 2
            r33 = 0
            if (r0 == r1) goto L_0x033e
            d.f.a.h.d r0 = r15.D
            if (r0 == 0) goto L_0x02eb
            d.f.a.h.c r0 = r0.u
            d.f.a.g r0 = r14.a(r0)
            r34 = r0
            goto L_0x02ed
        L_0x02eb:
            r34 = r33
        L_0x02ed:
            d.f.a.h.d r0 = r15.D
            if (r0 == 0) goto L_0x02fa
            d.f.a.h.c r0 = r0.s
            d.f.a.g r0 = r14.a(r0)
            r35 = r0
            goto L_0x02fc
        L_0x02fa:
            r35 = r33
        L_0x02fc:
            d.f.a.h.d$a[] r0 = r15.C
            r13 = 0
            r5 = r0[r13]
            d.f.a.h.c r7 = r15.s
            d.f.a.h.c r8 = r15.u
            int r9 = r15.I
            int r11 = r15.R
            int[] r0 = r15.q
            r12 = r0[r13]
            float r0 = r15.V
            r13 = r0
            int r0 = r15.f4697h
            r17 = r0
            int r0 = r15.f4698i
            r18 = r0
            float r0 = r15.f4699j
            r19 = r0
            r0 = r38
            r1 = r39
            r2 = r16
            r36 = r3
            r3 = r35
            r24 = r4
            r4 = r34
            r37 = r6
            r6 = r31
            r31 = r10
            r10 = r27
            r14 = r25
            r15 = r20
            r16 = r29
            r20 = r32
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0346
        L_0x033e:
            r36 = r3
            r24 = r4
            r37 = r6
            r31 = r10
        L_0x0346:
            r15 = r38
            int r0 = r15.f4691b
            r1 = 2
            if (r0 != r1) goto L_0x034e
            return
        L_0x034e:
            d.f.a.h.d$a[] r0 = r15.C
            r14 = 1
            r0 = r0[r14]
            d.f.a.h.d$a r1 = d.f.a.h.d.a.WRAP_CONTENT
            if (r0 != r1) goto L_0x035d
            boolean r0 = r15 instanceof d.f.a.h.e
            if (r0 == 0) goto L_0x035d
            r6 = r14
            goto L_0x035e
        L_0x035d:
            r6 = 0
        L_0x035e:
            if (r26 == 0) goto L_0x036a
            int r0 = r15.n
            if (r0 == r14) goto L_0x0367
            r1 = -1
            if (r0 != r1) goto L_0x036a
        L_0x0367:
            r16 = r14
            goto L_0x036c
        L_0x036a:
            r16 = 0
        L_0x036c:
            int r0 = r15.Q
            if (r0 <= 0) goto L_0x0399
            d.f.a.h.c r1 = r15.w
            d.f.a.h.j r1 = r1.f4664a
            int r2 = r1.f4726b
            if (r2 != r14) goto L_0x037e
            r10 = r39
            r1.a(r10)
            goto L_0x039b
        L_0x037e:
            r10 = r39
            r1 = 6
            r2 = r36
            r4 = r37
            r10.a(r2, r4, r0, r1)
            d.f.a.h.c r0 = r15.w
            d.f.a.h.c r0 = r0.f4667d
            if (r0 == 0) goto L_0x039d
            d.f.a.g r0 = r10.a(r0)
            r3 = 0
            r10.a(r2, r0, r3, r1)
            r20 = r3
            goto L_0x039f
        L_0x0399:
            r10 = r39
        L_0x039b:
            r4 = r37
        L_0x039d:
            r20 = r32
        L_0x039f:
            d.f.a.h.d r0 = r15.D
            if (r0 == 0) goto L_0x03ac
            d.f.a.h.c r0 = r0.v
            d.f.a.g r0 = r10.a(r0)
            r25 = r0
            goto L_0x03ae
        L_0x03ac:
            r25 = r33
        L_0x03ae:
            d.f.a.h.d r0 = r15.D
            if (r0 == 0) goto L_0x03ba
            d.f.a.h.c r0 = r0.t
            d.f.a.g r0 = r10.a(r0)
            r3 = r0
            goto L_0x03bc
        L_0x03ba:
            r3 = r33
        L_0x03bc:
            d.f.a.h.d$a[] r0 = r15.C
            r5 = r0[r14]
            d.f.a.h.c r7 = r15.t
            d.f.a.h.c r8 = r15.v
            int r9 = r15.J
            int r11 = r15.S
            int[] r0 = r15.q
            r12 = r0[r14]
            float r13 = r15.W
            int r0 = r15.k
            r17 = r0
            int r0 = r15.l
            r18 = r0
            float r0 = r15.m
            r19 = r0
            r0 = r38
            r1 = r39
            r2 = r22
            r22 = r4
            r4 = r25
            r10 = r28
            r14 = r16
            r15 = r23
            r16 = r30
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r26 == 0) goto L_0x041a
            r6 = 6
            r7 = r38
            int r0 = r7.n
            r1 = 1
            if (r0 != r1) goto L_0x0409
            float r5 = r7.o
            r0 = r39
            r1 = r24
            r2 = r22
            r3 = r31
            r4 = r21
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x041c
        L_0x0409:
            float r5 = r7.o
            r6 = 6
            r0 = r39
            r1 = r31
            r2 = r21
            r3 = r24
            r4 = r22
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x041c
        L_0x041a:
            r7 = r38
        L_0x041c:
            d.f.a.h.c r0 = r7.z
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x04bb
            d.f.a.h.c r0 = r7.z
            d.f.a.h.c r0 = r0.f4667d
            d.f.a.h.d r0 = r0.f4665b
            float r1 = r7.r
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            d.f.a.h.c r2 = r7.z
            int r2 = r2.a()
            d.f.a.h.c$c r3 = d.f.a.h.c.C0033c.LEFT
            d.f.a.h.c r3 = r7.a(r3)
            r4 = r39
            d.f.a.g r9 = r4.a(r3)
            d.f.a.h.c$c r3 = d.f.a.h.c.C0033c.TOP
            d.f.a.h.c r3 = r7.a(r3)
            d.f.a.g r11 = r4.a(r3)
            d.f.a.h.c$c r3 = d.f.a.h.c.C0033c.RIGHT
            d.f.a.h.c r3 = r7.a(r3)
            d.f.a.g r3 = r4.a(r3)
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.BOTTOM
            d.f.a.h.c r5 = r7.a(r5)
            d.f.a.g r12 = r4.a(r5)
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.LEFT
            d.f.a.h.c r5 = r0.a(r5)
            d.f.a.g r5 = r4.a(r5)
            d.f.a.h.c$c r6 = d.f.a.h.c.C0033c.TOP
            d.f.a.h.c r6 = r0.a(r6)
            d.f.a.g r13 = r4.a(r6)
            d.f.a.h.c$c r6 = d.f.a.h.c.C0033c.RIGHT
            d.f.a.h.c r6 = r0.a(r6)
            d.f.a.g r6 = r4.a(r6)
            d.f.a.h.c$c r8 = d.f.a.h.c.C0033c.BOTTOM
            d.f.a.h.c r0 = r0.a(r8)
            d.f.a.g r14 = r4.a(r0)
            d.f.a.b r0 = r39.b()
            double r7 = (double) r1
            double r15 = java.lang.Math.sin(r7)
            double r1 = (double) r2
            r17 = r5
            r18 = r6
            double r5 = r15 * r1
            float r15 = (float) r5
            r10 = r0
            r10.b(r11, r12, r13, r14, r15)
            r4.a(r0)
            d.f.a.b r0 = r39.b()
            double r5 = java.lang.Math.cos(r7)
            double r5 = r5 * r1
            float r13 = (float) r5
            r8 = r0
            r10 = r3
            r11 = r17
            r12 = r18
            r8.b(r9, r10, r11, r12, r13)
            r4.a(r0)
        L_0x04bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.d.a(d.f.a.e):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d5 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(d.f.a.e r29, boolean r30, d.f.a.g r31, d.f.a.g r32, d.f.a.h.d.a r33, boolean r34, d.f.a.h.c r35, d.f.a.h.c r36, int r37, int r38, int r39, int r40, float r41, boolean r42, boolean r43, int r44, int r45, int r46, float r47, boolean r48) {
        /*
            r28 = this;
            r0 = r28
            r10 = r29
            r11 = r31
            r12 = r32
            r13 = r35
            r14 = r36
            r1 = r39
            r2 = r40
            d.f.a.g r15 = r10.a(r13)
            d.f.a.g r9 = r10.a(r14)
            d.f.a.h.c r3 = r13.f4667d
            d.f.a.g r8 = r10.a(r3)
            d.f.a.h.c r3 = r14.f4667d
            d.f.a.g r7 = r10.a(r3)
            boolean r3 = r10.f4632g
            r6 = 1
            r5 = 6
            if (r3 == 0) goto L_0x0047
            d.f.a.h.j r3 = r13.f4664a
            int r4 = r3.f4726b
            if (r4 != r6) goto L_0x0047
            d.f.a.h.j r4 = r14.f4664a
            int r4 = r4.f4726b
            if (r4 != r6) goto L_0x0047
            r3.a(r10)
            d.f.a.h.j r1 = r14.f4664a
            r1.a(r10)
            if (r43 != 0) goto L_0x0046
            if (r30 == 0) goto L_0x0046
            r1 = 0
            r10.b(r12, r9, r1, r5)
        L_0x0046:
            return
        L_0x0047:
            boolean r16 = r35.b()
            boolean r17 = r36.b()
            d.f.a.h.c r3 = r0.z
            boolean r18 = r3.b()
            if (r16 == 0) goto L_0x0059
            r3 = r6
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            if (r17 == 0) goto L_0x005e
            int r3 = r3 + 1
        L_0x005e:
            if (r18 == 0) goto L_0x0062
            int r3 = r3 + 1
        L_0x0062:
            r4 = r3
            if (r42 == 0) goto L_0x0067
            r5 = 3
            goto L_0x0069
        L_0x0067:
            r5 = r44
        L_0x0069:
            int r3 = r33.ordinal()
            r6 = 2
            if (r3 == 0) goto L_0x0080
            r22 = r4
            r4 = 1
            if (r3 == r4) goto L_0x0078
            if (r3 == r6) goto L_0x007a
            r4 = 3
        L_0x0078:
            r3 = 0
            goto L_0x0083
        L_0x007a:
            r3 = 4
            if (r5 != r3) goto L_0x007e
            goto L_0x0078
        L_0x007e:
            r3 = 1
            goto L_0x0083
        L_0x0080:
            r22 = r4
            goto L_0x0078
        L_0x0083:
            int r4 = r0.Y
            r6 = 8
            if (r4 != r6) goto L_0x008c
            r3 = 0
            r4 = 0
            goto L_0x008f
        L_0x008c:
            r4 = r3
            r3 = r38
        L_0x008f:
            if (r48 == 0) goto L_0x00ac
            if (r16 != 0) goto L_0x009d
            if (r17 != 0) goto L_0x009d
            if (r18 != 0) goto L_0x009d
            r6 = r37
            r10.a(r15, r6)
            goto L_0x00ac
        L_0x009d:
            if (r16 == 0) goto L_0x00ac
            if (r17 != 0) goto L_0x00ac
            int r6 = r35.a()
            r23 = r7
            r7 = 6
            r10.a(r15, r8, r6, r7)
            goto L_0x00af
        L_0x00ac:
            r23 = r7
            r7 = 6
        L_0x00af:
            if (r4 != 0) goto L_0x00df
            if (r34 == 0) goto L_0x00c8
            r6 = 3
            r7 = 0
            r10.a(r9, r15, r7, r6)
            r3 = 6
            if (r1 <= 0) goto L_0x00be
            r10.b(r9, r15, r1, r3)
        L_0x00be:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r6) goto L_0x00c6
            r10.c(r9, r15, r2, r3)
        L_0x00c6:
            r6 = r3
            goto L_0x00cd
        L_0x00c8:
            r6 = r7
            r7 = 0
            r10.a(r9, r15, r3, r6)
        L_0x00cd:
            r3 = r45
            r13 = r4
            r25 = r5
            r0 = r22
            r26 = r23
            r1 = 2
            r21 = 4
            r22 = r8
            r8 = r46
            goto L_0x01d3
        L_0x00df:
            r6 = r7
            r7 = 0
            r2 = -2
            r7 = r45
            r6 = r46
            if (r7 != r2) goto L_0x00e9
            r7 = r3
        L_0x00e9:
            if (r6 != r2) goto L_0x00ec
            r6 = r3
        L_0x00ec:
            r2 = 6
            if (r7 <= 0) goto L_0x00f6
            r10.b(r9, r15, r7, r2)
            int r3 = java.lang.Math.max(r3, r7)
        L_0x00f6:
            if (r6 <= 0) goto L_0x00ff
            r10.c(r9, r15, r6, r2)
            int r3 = java.lang.Math.min(r3, r6)
        L_0x00ff:
            r2 = 1
            if (r5 != r2) goto L_0x0138
            if (r30 == 0) goto L_0x0119
            r2 = 6
            r10.a(r9, r15, r3, r2)
            r14 = r3
            r25 = r5
            r27 = r7
            r0 = r22
            r26 = r23
            r1 = 2
            r21 = 4
            r22 = r8
            r8 = r6
            goto L_0x01b8
        L_0x0119:
            r2 = 6
            if (r43 == 0) goto L_0x0123
            r34 = r6
            r6 = 4
            r10.a(r9, r15, r3, r6)
            goto L_0x012a
        L_0x0123:
            r34 = r6
            r2 = 1
            r6 = 4
            r10.a(r9, r15, r3, r2)
        L_0x012a:
            r14 = r3
            r25 = r5
            r21 = r6
            r27 = r7
            r0 = r22
            r26 = r23
            r1 = 2
            goto L_0x01b4
        L_0x0138:
            r34 = r6
            r6 = 2
            if (r5 != r6) goto L_0x01a8
            d.f.a.h.c$c r4 = r13.f4666c
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.TOP
            if (r4 == r2) goto L_0x0161
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.BOTTOM
            if (r4 != r2) goto L_0x0148
            goto L_0x0161
        L_0x0148:
            d.f.a.h.d r2 = r0.D
            d.f.a.h.c$c r4 = d.f.a.h.c.C0033c.LEFT
            d.f.a.h.c r2 = r2.a(r4)
            d.f.a.g r2 = r10.a(r2)
            d.f.a.h.d r4 = r0.D
            d.f.a.h.c$c r6 = d.f.a.h.c.C0033c.RIGHT
            d.f.a.h.c r4 = r4.a(r6)
            d.f.a.g r4 = r10.a(r4)
            goto L_0x0179
        L_0x0161:
            d.f.a.h.d r2 = r0.D
            d.f.a.h.c$c r4 = d.f.a.h.c.C0033c.TOP
            d.f.a.h.c r2 = r2.a(r4)
            d.f.a.g r2 = r10.a(r2)
            d.f.a.h.d r4 = r0.D
            d.f.a.h.c$c r6 = d.f.a.h.c.C0033c.BOTTOM
            d.f.a.h.c r4 = r4.a(r6)
            d.f.a.g r4 = r10.a(r4)
        L_0x0179:
            r24 = r2
            r6 = r4
            d.f.a.b r4 = r29.b()
            r19 = 1
            r21 = 6
            r2 = r4
            r14 = r3
            r13 = 3
            r3 = r9
            r13 = r4
            r0 = r22
            r4 = r15
            r25 = r5
            r22 = r8
            r8 = r21
            r5 = r6
            r8 = r34
            r1 = 2
            r21 = 4
            r6 = r24
            r27 = r7
            r26 = r23
            r7 = r47
            r2.a(r3, r4, r5, r6, r7)
            r10.a(r13)
            r4 = 0
            goto L_0x01b8
        L_0x01a8:
            r14 = r3
            r25 = r5
            r1 = r6
            r27 = r7
            r0 = r22
            r26 = r23
            r21 = 4
        L_0x01b4:
            r22 = r8
            r8 = r34
        L_0x01b8:
            if (r4 == 0) goto L_0x01d0
            if (r0 == r1) goto L_0x01d0
            if (r42 != 0) goto L_0x01d0
            r3 = r27
            int r2 = java.lang.Math.max(r3, r14)
            if (r8 <= 0) goto L_0x01ca
            int r2 = java.lang.Math.min(r8, r2)
        L_0x01ca:
            r4 = 6
            r10.a(r9, r15, r2, r4)
            r13 = 0
            goto L_0x01d3
        L_0x01d0:
            r3 = r27
            r13 = r4
        L_0x01d3:
            if (r48 == 0) goto L_0x0318
            if (r43 == 0) goto L_0x01d9
            goto L_0x0318
        L_0x01d9:
            r0 = 5
            if (r16 != 0) goto L_0x01ed
            if (r17 != 0) goto L_0x01ed
            if (r18 != 0) goto L_0x01ed
            if (r30 == 0) goto L_0x01e8
            r1 = 0
            r10.b(r12, r9, r1, r0)
            goto L_0x030d
        L_0x01e8:
            r12 = r9
            r0 = 6
            r1 = 0
            goto L_0x030f
        L_0x01ed:
            r1 = 0
            if (r16 == 0) goto L_0x01f9
            if (r17 != 0) goto L_0x01f9
            if (r30 == 0) goto L_0x030d
            r10.b(r12, r9, r1, r0)
            goto L_0x030d
        L_0x01f9:
            if (r16 != 0) goto L_0x020f
            if (r17 == 0) goto L_0x020f
            int r2 = r36.a()
            int r2 = -r2
            r14 = r26
            r3 = 6
            r10.a(r9, r14, r2, r3)
            if (r30 == 0) goto L_0x030d
            r10.b(r15, r11, r1, r0)
            goto L_0x030d
        L_0x020f:
            r14 = r26
            if (r16 == 0) goto L_0x030d
            if (r17 == 0) goto L_0x030d
            if (r13 == 0) goto L_0x0289
            if (r30 == 0) goto L_0x0220
            if (r39 != 0) goto L_0x0220
            r7 = 6
            r10.b(r9, r15, r1, r7)
            goto L_0x0221
        L_0x0220:
            r7 = 6
        L_0x0221:
            r1 = r25
            if (r1 != 0) goto L_0x0251
            if (r8 > 0) goto L_0x022d
            if (r3 <= 0) goto L_0x022a
            goto L_0x022d
        L_0x022a:
            r5 = r7
            r6 = 0
            goto L_0x0230
        L_0x022d:
            r5 = r21
            r6 = 1
        L_0x0230:
            int r1 = r35.a()
            r4 = r22
            r10.a(r15, r4, r1, r5)
            int r1 = r36.a()
            int r1 = -r1
            r10.a(r9, r14, r1, r5)
            if (r8 > 0) goto L_0x0248
            if (r3 <= 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r1 = 0
            goto L_0x0249
        L_0x0248:
            r1 = 1
        L_0x0249:
            r5 = r28
            r17 = r0
            r16 = r6
            r6 = 1
            goto L_0x0294
        L_0x0251:
            r4 = r22
            r6 = 1
            if (r1 != r6) goto L_0x025e
            r5 = r28
            r1 = r6
            r16 = r1
            r17 = r7
            goto L_0x0294
        L_0x025e:
            r2 = 3
            r5 = r28
            if (r1 != r2) goto L_0x0285
            if (r42 != 0) goto L_0x026e
            int r1 = r5.n
            r2 = -1
            if (r1 == r2) goto L_0x026e
            if (r8 > 0) goto L_0x026e
            r1 = r7
            goto L_0x0270
        L_0x026e:
            r1 = r21
        L_0x0270:
            int r2 = r35.a()
            r10.a(r15, r4, r2, r1)
            int r2 = r36.a()
            int r2 = -r2
            r10.a(r9, r14, r2, r1)
            r17 = r0
            r1 = r6
            r16 = r1
            goto L_0x0294
        L_0x0285:
            r17 = r0
            r1 = 0
            goto L_0x0292
        L_0x0289:
            r4 = r22
            r6 = 1
            r7 = 6
            r5 = r28
            r17 = r0
            r1 = r6
        L_0x0292:
            r16 = 0
        L_0x0294:
            if (r1 == 0) goto L_0x02da
            int r8 = r35.a()
            int r18 = r36.a()
            r1 = r29
            r2 = r15
            r3 = r4
            r19 = r4
            r4 = r8
            r5 = r41
            r20 = r6
            r6 = r14
            r8 = r7
            r7 = r9
            r12 = r8
            r0 = r19
            r8 = r18
            r12 = r9
            r9 = r17
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r35
            d.f.a.h.c r2 = r1.f4667d
            d.f.a.h.d r2 = r2.f4665b
            boolean r2 = r2 instanceof d.f.a.h.a
            r3 = r36
            d.f.a.h.c r4 = r3.f4667d
            d.f.a.h.d r4 = r4.f4665b
            boolean r4 = r4 instanceof d.f.a.h.a
            if (r2 == 0) goto L_0x02cf
            if (r4 != 0) goto L_0x02cf
            r6 = r30
            r2 = 6
            goto L_0x02e5
        L_0x02cf:
            if (r2 != 0) goto L_0x02e0
            if (r4 == 0) goto L_0x02e0
            r6 = r20
            r2 = 5
            r5 = 6
            r20 = r30
            goto L_0x02e6
        L_0x02da:
            r1 = r35
            r3 = r36
            r0 = r4
            r12 = r9
        L_0x02e0:
            r6 = r30
            r20 = r6
            r2 = 5
        L_0x02e5:
            r5 = 5
        L_0x02e6:
            if (r16 == 0) goto L_0x02ea
            r2 = 6
            r5 = 6
        L_0x02ea:
            if (r13 != 0) goto L_0x02ee
            if (r6 != 0) goto L_0x02f0
        L_0x02ee:
            if (r16 == 0) goto L_0x02f7
        L_0x02f0:
            int r1 = r35.a()
            r10.b(r15, r0, r1, r5)
        L_0x02f7:
            if (r13 != 0) goto L_0x02fb
            if (r20 != 0) goto L_0x02fd
        L_0x02fb:
            if (r16 == 0) goto L_0x0305
        L_0x02fd:
            int r0 = r36.a()
            int r0 = -r0
            r10.c(r12, r14, r0, r2)
        L_0x0305:
            r0 = 6
            r1 = 0
            if (r30 == 0) goto L_0x030f
            r10.b(r15, r11, r1, r0)
            goto L_0x030f
        L_0x030d:
            r12 = r9
            r0 = 6
        L_0x030f:
            if (r30 == 0) goto L_0x0317
            r2 = r0
            r0 = r32
            r10.b(r0, r12, r1, r2)
        L_0x0317:
            return
        L_0x0318:
            r3 = r0
            r4 = r1
            r0 = r12
            r1 = 0
            r2 = 6
            r12 = r9
            if (r3 >= r4) goto L_0x0328
            if (r30 == 0) goto L_0x0328
            r10.b(r15, r11, r1, r2)
            r10.b(r0, r12, r1, r2)
        L_0x0328:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.d.a(d.f.a.e, boolean, d.f.a.g, d.f.a.g, d.f.a.h.d$a, boolean, d.f.a.h.c, d.f.a.h.c, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }
}
