package d.f.a.h;

import d.f.a.b;
import d.f.a.e;
import d.f.a.h.c.C0033c;
import d.f.a.h.d.a;
import java.util.ArrayList;

/* compiled from: Guideline */
public class g extends d {
    public float k0 = -1.0f;
    public int l0 = -1;
    public int m0 = -1;
    public c n0 = this.t;
    public int o0;
    public boolean p0;

    public g() {
        this.o0 = 0;
        this.p0 = false;
        this.B.clear();
        this.B.add(this.n0);
        int length = this.A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.A[i2] = this.n0;
        }
    }

    public c a(C0033c cVar) {
        switch (cVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.o0 == 1) {
                    return this.n0;
                }
                break;
            case 2:
            case 4:
                if (this.o0 == 0) {
                    return this.n0;
                }
                break;
        }
        throw new AssertionError(cVar.name());
    }

    public boolean a() {
        return true;
    }

    public ArrayList<c> b() {
        return this.B;
    }

    public void c(e eVar) {
        if (this.D != null) {
            int b2 = eVar.b((Object) this.n0);
            if (this.o0 == 1) {
                this.I = b2;
                this.J = 0;
                e(this.D.c());
                f(0);
            } else {
                this.I = 0;
                this.J = b2;
                f(this.D.h());
                e(0);
            }
        }
    }

    public void g(int i2) {
        if (this.o0 != i2) {
            this.o0 = i2;
            this.B.clear();
            if (this.o0 == 1) {
                this.n0 = this.s;
            } else {
                this.n0 = this.t;
            }
            this.B.add(this.n0);
            int length = this.A.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.A[i3] = this.n0;
            }
        }
    }

    public void a(e eVar) {
        e eVar2 = (e) this.D;
        if (eVar2 != null) {
            c a2 = eVar2.a(C0033c.LEFT);
            c a3 = eVar2.a(C0033c.RIGHT);
            d dVar = this.D;
            boolean z = true;
            boolean z2 = dVar != null && dVar.C[0] == a.WRAP_CONTENT;
            if (this.o0 == 0) {
                a2 = eVar2.a(C0033c.TOP);
                a3 = eVar2.a(C0033c.BOTTOM);
                d dVar2 = this.D;
                if (dVar2 == null || dVar2.C[1] != a.WRAP_CONTENT) {
                    z = false;
                }
                z2 = z;
            }
            if (this.l0 != -1) {
                d.f.a.g a4 = eVar.a((Object) this.n0);
                eVar.a(a4, eVar.a((Object) a2), this.l0, 6);
                if (z2) {
                    eVar.b(eVar.a((Object) a3), a4, 0, 5);
                }
            } else if (this.m0 != -1) {
                d.f.a.g a5 = eVar.a((Object) this.n0);
                d.f.a.g a6 = eVar.a((Object) a3);
                eVar.a(a5, a6, -this.m0, 6);
                if (z2) {
                    eVar.b(a5, eVar.a((Object) a2), 0, 5);
                    eVar.b(a6, a5, 0, 5);
                }
            } else if (this.k0 != -1.0f) {
                d.f.a.g a7 = eVar.a((Object) this.n0);
                d.f.a.g a8 = eVar.a((Object) a2);
                d.f.a.g a9 = eVar.a((Object) a3);
                float f2 = this.k0;
                boolean z3 = this.p0;
                b b2 = eVar.b();
                if (z3) {
                    b2.a(eVar, 0);
                }
                b2.f4621d.a(a7, -1.0f);
                b2.f4621d.a(a8, 1.0f - f2);
                b2.f4621d.a(a9, f2);
                eVar.a(b2);
            }
        }
    }

    public void a(int i2) {
        d dVar = this.D;
        if (dVar != null) {
            if (this.o0 == 1) {
                this.t.f4664a.a(1, dVar.t.f4664a, 0);
                this.v.f4664a.a(1, dVar.t.f4664a, 0);
                int i3 = this.l0;
                if (i3 != -1) {
                    this.s.f4664a.a(1, dVar.s.f4664a, i3);
                    this.u.f4664a.a(1, dVar.s.f4664a, this.l0);
                } else {
                    int i4 = this.m0;
                    if (i4 != -1) {
                        this.s.f4664a.a(1, dVar.u.f4664a, -i4);
                        this.u.f4664a.a(1, dVar.u.f4664a, -this.m0);
                    } else if (this.k0 != -1.0f && dVar.d() == a.FIXED) {
                        int i5 = (int) (((float) dVar.E) * this.k0);
                        this.s.f4664a.a(1, dVar.s.f4664a, i5);
                        this.u.f4664a.a(1, dVar.s.f4664a, i5);
                    }
                }
            } else {
                this.s.f4664a.a(1, dVar.s.f4664a, 0);
                this.u.f4664a.a(1, dVar.s.f4664a, 0);
                int i6 = this.l0;
                if (i6 != -1) {
                    this.t.f4664a.a(1, dVar.t.f4664a, i6);
                    this.v.f4664a.a(1, dVar.t.f4664a, this.l0);
                } else {
                    int i7 = this.m0;
                    if (i7 != -1) {
                        this.t.f4664a.a(1, dVar.v.f4664a, -i7);
                        this.v.f4664a.a(1, dVar.v.f4664a, -this.m0);
                    } else if (this.k0 != -1.0f && dVar.g() == a.FIXED) {
                        int i8 = (int) (((float) dVar.F) * this.k0);
                        this.t.f4664a.a(1, dVar.t.f4664a, i8);
                        this.v.f4664a.a(1, dVar.t.f4664a, i8);
                    }
                }
            }
        }
    }
}
