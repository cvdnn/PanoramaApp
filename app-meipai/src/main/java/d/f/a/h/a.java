package d.f.a.h;

import java.util.ArrayList;

/* compiled from: Barrier */
public class a extends h {
    public int m0 = 0;
    public ArrayList<j> n0 = new ArrayList<>(4);
    public boolean o0 = true;

    public void a(int i2) {
        j jVar;
        l lVar;
        d dVar = this.D;
        if (dVar != null && ((e) dVar).g(2)) {
            int i3 = this.m0;
            if (i3 == 0) {
                jVar = this.s.f4664a;
            } else if (i3 == 1) {
                jVar = this.u.f4664a;
            } else if (i3 == 2) {
                jVar = this.t.f4664a;
            } else if (i3 == 3) {
                jVar = this.v.f4664a;
            } else {
                return;
            }
            jVar.f4721h = 5;
            int i4 = this.m0;
            if (i4 == 0 || i4 == 1) {
                this.t.f4664a.a((j) null, 0.0f);
                this.v.f4664a.a((j) null, 0.0f);
            } else {
                this.s.f4664a.a((j) null, 0.0f);
                this.u.f4664a.a((j) null, 0.0f);
            }
            this.n0.clear();
            for (int i5 = 0; i5 < this.l0; i5++) {
                d dVar2 = this.k0[i5];
                if (this.o0 || dVar2.a()) {
                    int i6 = this.m0;
                    if (i6 == 0) {
                        lVar = dVar2.s.f4664a;
                    } else if (i6 == 1) {
                        lVar = dVar2.u.f4664a;
                    } else if (i6 == 2) {
                        lVar = dVar2.t.f4664a;
                    } else if (i6 != 3) {
                        lVar = null;
                    } else {
                        lVar = dVar2.v.f4664a;
                    }
                    if (lVar != null) {
                        this.n0.add(lVar);
                        lVar.f4725a.add(jVar);
                    }
                }
            }
        }
    }

    public boolean a() {
        return true;
    }

    public void k() {
        super.k();
        this.n0.clear();
    }

    public void l() {
        j jVar;
        float f2;
        j jVar2;
        int i2 = this.m0;
        float f3 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                jVar = this.u.f4664a;
            } else if (i2 == 2) {
                jVar = this.t.f4664a;
            } else if (i2 == 3) {
                jVar = this.v.f4664a;
            } else {
                return;
            }
            f3 = 0.0f;
        } else {
            jVar = this.s.f4664a;
        }
        int size = this.n0.size();
        j jVar3 = null;
        int i3 = 0;
        while (i3 < size) {
            j jVar4 = (j) this.n0.get(i3);
            if (jVar4.f4726b == 1) {
                int i4 = this.m0;
                if (i4 == 0 || i4 == 2) {
                    f2 = jVar4.f4720g;
                    if (f2 < f3) {
                        jVar2 = jVar4.f4719f;
                    } else {
                        i3++;
                    }
                } else {
                    f2 = jVar4.f4720g;
                    if (f2 > f3) {
                        jVar2 = jVar4.f4719f;
                    } else {
                        i3++;
                    }
                }
                jVar3 = jVar2;
                f3 = f2;
                i3++;
            } else {
                return;
            }
        }
        jVar.f4719f = jVar3;
        jVar.f4720g = f3;
        jVar.a();
        int i5 = this.m0;
        if (i5 == 0) {
            this.u.f4664a.a(jVar3, f3);
        } else if (i5 == 1) {
            this.s.f4664a.a(jVar3, f3);
        } else if (i5 == 2) {
            this.v.f4664a.a(jVar3, f3);
        } else if (i5 == 3) {
            this.t.f4664a.a(jVar3, f3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(d.f.a.e r14) {
        /*
            r13 = this;
            d.f.a.h.c[] r0 = r13.A
            d.f.a.h.c r1 = r13.s
            r2 = 0
            r0[r2] = r1
            d.f.a.h.c r1 = r13.t
            r3 = 2
            r0[r3] = r1
            d.f.a.h.c r1 = r13.u
            r4 = 1
            r0[r4] = r1
            d.f.a.h.c r1 = r13.v
            r5 = 3
            r0[r5] = r1
            r0 = r2
        L_0x0017:
            d.f.a.h.c[] r1 = r13.A
            int r6 = r1.length
            if (r0 >= r6) goto L_0x0029
            r6 = r1[r0]
            r1 = r1[r0]
            d.f.a.g r1 = r14.a(r1)
            r6.f4672i = r1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0029:
            int r0 = r13.m0
            if (r0 < 0) goto L_0x017b
            r6 = 4
            if (r0 >= r6) goto L_0x017b
            r0 = r1[r0]
            r1 = r2
        L_0x0033:
            int r6 = r13.l0
            if (r1 >= r6) goto L_0x0068
            d.f.a.h.d[] r6 = r13.k0
            r6 = r6[r1]
            boolean r7 = r13.o0
            if (r7 != 0) goto L_0x0046
            boolean r7 = r6.a()
            if (r7 != 0) goto L_0x0046
            goto L_0x0065
        L_0x0046:
            int r7 = r13.m0
            if (r7 == 0) goto L_0x004c
            if (r7 != r4) goto L_0x0056
        L_0x004c:
            d.f.a.h.d$a r7 = r6.d()
            d.f.a.h.d$a r8 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r7 != r8) goto L_0x0056
        L_0x0054:
            r1 = r4
            goto L_0x0069
        L_0x0056:
            int r7 = r13.m0
            if (r7 == r3) goto L_0x005c
            if (r7 != r5) goto L_0x0065
        L_0x005c:
            d.f.a.h.d$a r6 = r6.g()
            d.f.a.h.d$a r7 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0065
            goto L_0x0054
        L_0x0065:
            int r1 = r1 + 1
            goto L_0x0033
        L_0x0068:
            r1 = r2
        L_0x0069:
            int r6 = r13.m0
            if (r6 == 0) goto L_0x007b
            if (r6 != r4) goto L_0x0070
            goto L_0x007b
        L_0x0070:
            d.f.a.h.d r6 = r13.D
            d.f.a.h.d$a r6 = r6.g()
            d.f.a.h.d$a r7 = d.f.a.h.d.a.WRAP_CONTENT
            if (r6 != r7) goto L_0x0086
            goto L_0x0085
        L_0x007b:
            d.f.a.h.d r6 = r13.D
            d.f.a.h.d$a r6 = r6.d()
            d.f.a.h.d$a r7 = d.f.a.h.d.a.WRAP_CONTENT
            if (r6 != r7) goto L_0x0086
        L_0x0085:
            r1 = r2
        L_0x0086:
            r6 = r2
        L_0x0087:
            int r7 = r13.l0
            if (r6 >= r7) goto L_0x0104
            d.f.a.h.d[] r7 = r13.k0
            r7 = r7[r6]
            boolean r8 = r13.o0
            if (r8 != 0) goto L_0x009a
            boolean r8 = r7.a()
            if (r8 != 0) goto L_0x009a
            goto L_0x0101
        L_0x009a:
            d.f.a.h.c[] r8 = r7.A
            int r9 = r13.m0
            r8 = r8[r9]
            d.f.a.g r8 = r14.a(r8)
            d.f.a.h.c[] r7 = r7.A
            int r9 = r13.m0
            r7 = r7[r9]
            r7.f4672i = r8
            r7 = 0
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r9 == 0) goto L_0x00db
            if (r9 != r3) goto L_0x00b4
            goto L_0x00db
        L_0x00b4:
            d.f.a.g r9 = r0.f4672i
            d.f.a.b r11 = r14.b()
            d.f.a.g r12 = r14.c()
            r12.f4641d = r2
            r11.a(r9, r8, r12, r2)
            if (r1 == 0) goto L_0x00d7
            d.f.a.a r8 = r11.f4621d
            float r8 = r8.a(r12)
            float r8 = r8 * r10
            int r8 = (int) r8
            d.f.a.g r7 = r14.a(r4, r7)
            d.f.a.a r9 = r11.f4621d
            float r8 = (float) r8
            r9.a(r7, r8)
        L_0x00d7:
            r14.a(r11)
            goto L_0x0101
        L_0x00db:
            d.f.a.g r9 = r0.f4672i
            d.f.a.b r11 = r14.b()
            d.f.a.g r12 = r14.c()
            r12.f4641d = r2
            r11.b(r9, r8, r12, r2)
            if (r1 == 0) goto L_0x00fe
            d.f.a.a r8 = r11.f4621d
            float r8 = r8.a(r12)
            float r8 = r8 * r10
            int r8 = (int) r8
            d.f.a.g r7 = r14.a(r4, r7)
            d.f.a.a r9 = r11.f4621d
            float r8 = (float) r8
            r9.a(r7, r8)
        L_0x00fe:
            r14.a(r11)
        L_0x0101:
            int r6 = r6 + 1
            goto L_0x0087
        L_0x0104:
            int r0 = r13.m0
            r6 = 5
            r7 = 6
            if (r0 != 0) goto L_0x0125
            d.f.a.h.c r0 = r13.u
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.c r3 = r13.s
            d.f.a.g r3 = r3.f4672i
            r14.a(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x017b
            d.f.a.h.c r0 = r13.s
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.d r1 = r13.D
            d.f.a.h.c r1 = r1.u
            d.f.a.g r1 = r1.f4672i
            r14.a(r0, r1, r2, r6)
            goto L_0x017b
        L_0x0125:
            if (r0 != r4) goto L_0x0142
            d.f.a.h.c r0 = r13.s
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.c r3 = r13.u
            d.f.a.g r3 = r3.f4672i
            r14.a(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x017b
            d.f.a.h.c r0 = r13.s
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.d r1 = r13.D
            d.f.a.h.c r1 = r1.s
            d.f.a.g r1 = r1.f4672i
            r14.a(r0, r1, r2, r6)
            goto L_0x017b
        L_0x0142:
            if (r0 != r3) goto L_0x015f
            d.f.a.h.c r0 = r13.v
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.c r3 = r13.t
            d.f.a.g r3 = r3.f4672i
            r14.a(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x017b
            d.f.a.h.c r0 = r13.t
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.d r1 = r13.D
            d.f.a.h.c r1 = r1.v
            d.f.a.g r1 = r1.f4672i
            r14.a(r0, r1, r2, r6)
            goto L_0x017b
        L_0x015f:
            if (r0 != r5) goto L_0x017b
            d.f.a.h.c r0 = r13.t
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.c r3 = r13.v
            d.f.a.g r3 = r3.f4672i
            r14.a(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x017b
            d.f.a.h.c r0 = r13.t
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.d r1 = r13.D
            d.f.a.h.c r1 = r1.t
            d.f.a.g r1 = r1.f4672i
            r14.a(r0, r1, r2, r6)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.a.a(d.f.a.e):void");
    }
}
