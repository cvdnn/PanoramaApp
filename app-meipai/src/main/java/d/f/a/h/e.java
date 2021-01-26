package d.f.a.h;

import d.f.a.h.c.C0033c;
import d.f.a.h.d.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer */
public class e extends n {
    public int A0 = 0;
    public int B0 = 0;
    public int C0 = 7;
    public boolean D0 = false;
    public boolean E0 = false;
    public boolean F0 = false;
    public boolean l0 = false;
    public d.f.a.e m0 = new d.f.a.e();
    public m n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0 = 0;
    public int t0 = 0;
    public b[] u0 = new b[4];
    public b[] v0 = new b[4];
    public List<f> w0 = new ArrayList();
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean z0 = false;

    public void a(int i2) {
        super.a(i2);
        int size = this.k0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((d) this.k0.get(i3)).a(i2);
        }
    }

    public boolean d(d.f.a.e eVar) {
        a(eVar);
        int size = this.k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = (d) this.k0.get(i2);
            if (dVar instanceof e) {
                a[] aVarArr = dVar.C;
                a aVar = aVarArr[0];
                a aVar2 = aVarArr[1];
                if (aVar == a.WRAP_CONTENT) {
                    dVar.a(a.FIXED);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    dVar.b(a.FIXED);
                }
                dVar.a(eVar);
                if (aVar == a.WRAP_CONTENT) {
                    dVar.a(aVar);
                }
                if (aVar2 == a.WRAP_CONTENT) {
                    dVar.b(aVar2);
                }
            } else {
                if (this.C[0] != a.WRAP_CONTENT && dVar.C[0] == a.MATCH_PARENT) {
                    int i3 = dVar.s.f4668e;
                    int h2 = h() - dVar.u.f4668e;
                    c cVar = dVar.s;
                    cVar.f4672i = eVar.a((Object) cVar);
                    c cVar2 = dVar.u;
                    cVar2.f4672i = eVar.a((Object) cVar2);
                    eVar.a(dVar.s.f4672i, i3);
                    eVar.a(dVar.u.f4672i, h2);
                    dVar.f4690a = 2;
                    dVar.a(i3, h2);
                }
                if (this.C[1] != a.WRAP_CONTENT && dVar.C[1] == a.MATCH_PARENT) {
                    int i4 = dVar.t.f4668e;
                    int c2 = c() - dVar.v.f4668e;
                    c cVar3 = dVar.t;
                    cVar3.f4672i = eVar.a((Object) cVar3);
                    c cVar4 = dVar.v;
                    cVar4.f4672i = eVar.a((Object) cVar4);
                    eVar.a(dVar.t.f4672i, i4);
                    eVar.a(dVar.v.f4672i, c2);
                    if (dVar.Q > 0 || dVar.Y == 8) {
                        c cVar5 = dVar.w;
                        cVar5.f4672i = eVar.a((Object) cVar5);
                        eVar.a(dVar.w.f4672i, dVar.Q + i4);
                    }
                    dVar.f4691b = 2;
                    dVar.c(i4, c2);
                }
                dVar.a(eVar);
            }
        }
        if (this.s0 > 0) {
            a.a.a.a.b.a.a(this, eVar, 0);
        }
        if (this.t0 > 0) {
            a.a.a.a.b.a.a(this, eVar, 1);
        }
        return true;
    }

    public boolean g(int i2) {
        return (this.C0 & i2) == i2;
    }

    public void j() {
        this.m0.f();
        this.o0 = 0;
        this.q0 = 0;
        this.p0 = 0;
        this.r0 = 0;
        this.w0.clear();
        this.D0 = false;
        super.j();
    }

    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r8v12, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r0v31 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r0v33 */
    /* JADX WARNING: type inference failed for: r0v35 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r0v37 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r0v39 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r0v40 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r0v47 */
    /* JADX WARNING: type inference failed for: r0v49 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r0v50 */
    /* JADX WARNING: type inference failed for: r0v52 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r8v47 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r18v7 */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r8v58 */
    /* JADX WARNING: type inference failed for: r0v95 */
    /* JADX WARNING: type inference failed for: r0v96 */
    /* JADX WARNING: type inference failed for: r8v85 */
    /* JADX WARNING: type inference failed for: r8v86 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r17v11 */
    /* JADX WARNING: type inference failed for: r0v97 */
    /* JADX WARNING: type inference failed for: r8v87 */
    /* JADX WARNING: type inference failed for: r9v42 */
    /* JADX WARNING: type inference failed for: r8v88 */
    /* JADX WARNING: type inference failed for: r9v43 */
    /* JADX WARNING: type inference failed for: r0v98 */
    /* JADX WARNING: type inference failed for: r8v89 */
    /* JADX WARNING: type inference failed for: r8v90 */
    /* JADX WARNING: type inference failed for: r0v99 */
    /* JADX WARNING: type inference failed for: r17v12 */
    /* JADX WARNING: type inference failed for: r0v100 */
    /* JADX WARNING: type inference failed for: r0v101 */
    /* JADX WARNING: type inference failed for: r17v13 */
    /* JADX WARNING: type inference failed for: r0v102 */
    /* JADX WARNING: type inference failed for: r0v103 */
    /* JADX WARNING: type inference failed for: r17v14 */
    /* JADX WARNING: type inference failed for: r18v9 */
    /* JADX WARNING: type inference failed for: r18v10 */
    /* JADX WARNING: type inference failed for: r18v11 */
    /* JADX WARNING: type inference failed for: r18v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v17
  assigns: []
  uses: []
  mth insns count: 552
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03b3  */
    /* JADX WARNING: Unknown variable types count: 33 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n() {
        /*
            r25 = this;
            r1 = r25
            int r2 = r1.I
            int r3 = r1.J
            int r0 = r25.h()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r25.c()
            int r6 = java.lang.Math.max(r4, r0)
            r1.E0 = r4
            r1.F0 = r4
            d.f.a.h.d r0 = r1.D
            if (r0 == 0) goto L_0x00b4
            d.f.a.h.m r0 = r1.n0
            if (r0 != 0) goto L_0x002a
            d.f.a.h.m r0 = new d.f.a.h.m
            r0.<init>(r1)
            r1.n0 = r0
        L_0x002a:
            d.f.a.h.m r0 = r1.n0
            r7 = 0
            if (r0 == 0) goto L_0x00b3
            int r8 = r1.I
            r0.f4727a = r8
            int r8 = r1.J
            r0.f4728b = r8
            int r8 = r25.h()
            r0.f4729c = r8
            int r8 = r25.c()
            r0.f4730d = r8
            java.util.ArrayList<d.f.a.h.m$a> r8 = r0.f4731e
            int r8 = r8.size()
            r9 = r4
        L_0x004a:
            if (r9 >= r8) goto L_0x0082
            java.util.ArrayList<d.f.a.h.m$a> r10 = r0.f4731e
            java.lang.Object r10 = r10.get(r9)
            d.f.a.h.m$a r10 = (d.f.a.h.m.a) r10
            d.f.a.h.c r11 = r10.f4732a
            d.f.a.h.c$c r11 = r11.f4666c
            d.f.a.h.c r11 = r1.a(r11)
            r10.f4732a = r11
            if (r11 == 0) goto L_0x0075
            d.f.a.h.c r12 = r11.f4667d
            r10.f4733b = r12
            int r11 = r11.a()
            r10.f4734c = r11
            d.f.a.h.c r11 = r10.f4732a
            d.f.a.h.c$b r12 = r11.f4670g
            r10.f4735d = r12
            int r11 = r11.f4671h
            r10.f4736e = r11
            goto L_0x007f
        L_0x0075:
            r10.f4733b = r7
            r10.f4734c = r4
            d.f.a.h.c$b r11 = d.f.a.h.c.b.STRONG
            r10.f4735d = r11
            r10.f4736e = r4
        L_0x007f:
            int r9 = r9 + 1
            goto L_0x004a
        L_0x0082:
            int r0 = r1.o0
            r1.I = r0
            int r0 = r1.p0
            r1.J = r0
            d.f.a.h.d r0 = r1.D
            if (r0 == 0) goto L_0x0094
            boolean r7 = r0 instanceof d.f.a.h.e
            if (r7 == 0) goto L_0x0094
            d.f.a.h.e r0 = (d.f.a.h.e) r0
        L_0x0094:
            java.util.ArrayList<d.f.a.h.c> r0 = r1.B
            int r0 = r0.size()
            r7 = r4
        L_0x009b:
            if (r7 >= r0) goto L_0x00ab
            java.util.ArrayList<d.f.a.h.c> r8 = r1.B
            java.lang.Object r8 = r8.get(r7)
            d.f.a.h.c r8 = (d.f.a.h.c) r8
            r8.c()
            int r7 = r7 + 1
            goto L_0x009b
        L_0x00ab:
            d.f.a.e r0 = r1.m0
            d.f.a.c r0 = r0.l
            r1.a(r0)
            goto L_0x00b8
        L_0x00b3:
            throw r7
        L_0x00b4:
            r1.I = r4
            r1.J = r4
        L_0x00b8:
            int r0 = r1.C0
            r7 = 8
            r8 = 32
            r9 = 1
            if (r0 == 0) goto L_0x00e3
            boolean r0 = r1.g(r7)
            if (r0 != 0) goto L_0x00ca
            r25.o()
        L_0x00ca:
            boolean r0 = r1.g(r8)
            if (r0 != 0) goto L_0x00de
            boolean r0 = r1.g(r7)
            if (r0 != 0) goto L_0x00db
            int r0 = r1.C0
            r1.a(r0)
        L_0x00db:
            r25.q()
        L_0x00de:
            d.f.a.e r0 = r1.m0
            r0.f4632g = r9
            goto L_0x00e7
        L_0x00e3:
            d.f.a.e r0 = r1.m0
            r0.f4632g = r4
        L_0x00e7:
            d.f.a.h.d$a[] r0 = r1.C
            r10 = r0[r9]
            r11 = r0[r4]
            r25.p()
            java.util.List<d.f.a.h.f> r0 = r1.w0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0109
            java.util.List<d.f.a.h.f> r0 = r1.w0
            r0.clear()
            java.util.List<d.f.a.h.f> r0 = r1.w0
            d.f.a.h.f r12 = new d.f.a.h.f
            java.util.ArrayList<d.f.a.h.d> r13 = r1.k0
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0109:
            java.util.List<d.f.a.h.f> r0 = r1.w0
            int r12 = r0.size()
            java.util.ArrayList<d.f.a.h.d> r13 = r1.k0
            d.f.a.h.d$a r0 = r25.d()
            d.f.a.h.d$a r14 = d.f.a.h.d.a.WRAP_CONTENT
            if (r0 == r14) goto L_0x0124
            d.f.a.h.d$a r0 = r25.g()
            d.f.a.h.d$a r14 = d.f.a.h.d.a.WRAP_CONTENT
            if (r0 != r14) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r14 = r4
            goto L_0x0125
        L_0x0124:
            r14 = r9
        L_0x0125:
            r0 = r4
            r15 = r0
        L_0x0127:
            if (r15 >= r12) goto L_0x0439
            boolean r7 = r1.D0
            if (r7 != 0) goto L_0x0439
            java.util.List<d.f.a.h.f> r7 = r1.w0
            java.lang.Object r7 = r7.get(r15)
            d.f.a.h.f r7 = (d.f.a.h.f) r7
            boolean r7 = r7.f4708d
            if (r7 == 0) goto L_0x013f
            r22 = r3
            r19 = r12
            goto L_0x042b
        L_0x013f:
            boolean r7 = r1.g(r8)
            if (r7 == 0) goto L_0x01b3
            d.f.a.h.d$a r7 = r25.d()
            d.f.a.h.d$a r8 = d.f.a.h.d.a.FIXED
            if (r7 != r8) goto L_0x01a5
            d.f.a.h.d$a r7 = r25.g()
            d.f.a.h.d$a r8 = d.f.a.h.d.a.FIXED
            if (r7 != r8) goto L_0x01a5
            java.util.List<d.f.a.h.f> r7 = r1.w0
            java.lang.Object r7 = r7.get(r15)
            d.f.a.h.f r7 = (d.f.a.h.f) r7
            java.util.List<d.f.a.h.d> r8 = r7.f4714j
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0168
            java.util.List<d.f.a.h.d> r7 = r7.f4714j
            goto L_0x01a0
        L_0x0168:
            java.util.List<d.f.a.h.d> r8 = r7.f4705a
            int r8 = r8.size()
        L_0x016e:
            if (r4 >= r8) goto L_0x018b
            java.util.List<d.f.a.h.d> r9 = r7.f4705a
            java.lang.Object r9 = r9.get(r4)
            d.f.a.h.d r9 = (d.f.a.h.d) r9
            r17 = r8
            boolean r8 = r9.b0
            if (r8 != 0) goto L_0x0185
            java.util.List<d.f.a.h.d> r8 = r7.f4714j
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            r7.a(r8, r9)
        L_0x0185:
            int r4 = r4 + 1
            r8 = r17
            r9 = 1
            goto L_0x016e
        L_0x018b:
            java.util.List<d.f.a.h.d> r4 = r7.k
            r4.clear()
            java.util.List<d.f.a.h.d> r4 = r7.k
            java.util.List<d.f.a.h.d> r8 = r7.f4705a
            r4.addAll(r8)
            java.util.List<d.f.a.h.d> r4 = r7.k
            java.util.List<d.f.a.h.d> r8 = r7.f4714j
            r4.removeAll(r8)
            java.util.List<d.f.a.h.d> r7 = r7.f4714j
        L_0x01a0:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.k0 = r7
            goto L_0x01b3
        L_0x01a5:
            java.util.List<d.f.a.h.f> r4 = r1.w0
            java.lang.Object r4 = r4.get(r15)
            d.f.a.h.f r4 = (d.f.a.h.f) r4
            java.util.List<d.f.a.h.d> r4 = r4.f4705a
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r1.k0 = r4
        L_0x01b3:
            r25.p()
            java.util.ArrayList<d.f.a.h.d> r4 = r1.k0
            int r4 = r4.size()
            r7 = 0
        L_0x01bd:
            if (r7 >= r4) goto L_0x01d3
            java.util.ArrayList<d.f.a.h.d> r8 = r1.k0
            java.lang.Object r8 = r8.get(r7)
            d.f.a.h.d r8 = (d.f.a.h.d) r8
            boolean r9 = r8 instanceof d.f.a.h.n
            if (r9 == 0) goto L_0x01d0
            d.f.a.h.n r8 = (d.f.a.h.n) r8
            r8.n()
        L_0x01d0:
            int r7 = r7 + 1
            goto L_0x01bd
        L_0x01d3:
            r7 = r0
            r0 = 0
            r8 = 1
        L_0x01d6:
            if (r8 == 0) goto L_0x0404
            r17 = r7
            r9 = 1
            int r7 = r0 + 1
            d.f.a.e r0 = r1.m0     // Catch:{ Exception -> 0x023d }
            r0.f()     // Catch:{ Exception -> 0x023d }
            r25.p()     // Catch:{ Exception -> 0x023d }
            d.f.a.e r0 = r1.m0     // Catch:{ Exception -> 0x023d }
            r1.b(r0)     // Catch:{ Exception -> 0x023d }
            r0 = 0
        L_0x01eb:
            if (r0 >= r4) goto L_0x0201
            java.util.ArrayList<d.f.a.h.d> r9 = r1.k0     // Catch:{ Exception -> 0x023d }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Exception -> 0x023d }
            d.f.a.h.d r9 = (d.f.a.h.d) r9     // Catch:{ Exception -> 0x023d }
            r18 = r8
            d.f.a.e r8 = r1.m0     // Catch:{ Exception -> 0x023b }
            r9.b(r8)     // Catch:{ Exception -> 0x023b }
            int r0 = r0 + 1
            r8 = r18
            goto L_0x01eb
        L_0x0201:
            r18 = r8
            d.f.a.e r0 = r1.m0     // Catch:{ Exception -> 0x023b }
            r1.d(r0)     // Catch:{ Exception -> 0x023b }
            d.f.a.e r0 = r1.m0     // Catch:{ Exception -> 0x0237 }
            boolean r8 = r0.f4632g     // Catch:{ Exception -> 0x0237 }
            if (r8 == 0) goto L_0x022d
            r8 = 0
        L_0x020f:
            int r9 = r0.f4635j     // Catch:{ Exception -> 0x0237 }
            if (r8 >= r9) goto L_0x0220
            d.f.a.b[] r9 = r0.f4631f     // Catch:{ Exception -> 0x0237 }
            r9 = r9[r8]     // Catch:{ Exception -> 0x0237 }
            boolean r9 = r9.f4622e     // Catch:{ Exception -> 0x0237 }
            if (r9 != 0) goto L_0x021d
            r8 = 0
            goto L_0x0221
        L_0x021d:
            int r8 = r8 + 1
            goto L_0x020f
        L_0x0220:
            r8 = 1
        L_0x0221:
            if (r8 != 0) goto L_0x0229
            d.f.a.e$a r8 = r0.f4628c     // Catch:{ Exception -> 0x0237 }
            r0.a(r8)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0232
        L_0x0229:
            r0.a()     // Catch:{ Exception -> 0x0237 }
            goto L_0x0232
        L_0x022d:
            d.f.a.e$a r8 = r0.f4628c     // Catch:{ Exception -> 0x0237 }
            r0.a(r8)     // Catch:{ Exception -> 0x0237 }
        L_0x0232:
            r19 = r12
            r18 = 1
            goto L_0x025b
        L_0x0237:
            r0 = move-exception
            r18 = 1
            goto L_0x0240
        L_0x023b:
            r0 = move-exception
            goto L_0x0240
        L_0x023d:
            r0 = move-exception
            r18 = r8
        L_0x0240:
            r0.printStackTrace()
            java.io.PrintStream r8 = java.lang.System.out
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r9.append(r12)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r8.println(r0)
        L_0x025b:
            r0 = 2
            if (r18 == 0) goto L_0x02bc
            d.f.a.e r8 = r1.m0
            boolean[] r9 = d.f.a.h.i.f4715a
            r16 = 0
            r9[r0] = r16
            r1.c(r8)
            java.util.ArrayList<d.f.a.h.d> r12 = r1.k0
            int r12 = r12.size()
            r0 = r16
        L_0x0271:
            if (r0 >= r12) goto L_0x02b9
            r20 = r12
            java.util.ArrayList<d.f.a.h.d> r12 = r1.k0
            java.lang.Object r12 = r12.get(r0)
            d.f.a.h.d r12 = (d.f.a.h.d) r12
            r12.c(r8)
            r21 = r8
            d.f.a.h.d$a[] r8 = r12.C
            r8 = r8[r16]
            r22 = r3
            d.f.a.h.d$a r3 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r8 != r3) goto L_0x0299
            int r3 = r12.h()
            int r8 = r12.T
            if (r3 >= r8) goto L_0x0299
            r3 = 2
            r8 = 1
            r9[r3] = r8
            goto L_0x029a
        L_0x0299:
            r8 = 1
        L_0x029a:
            d.f.a.h.d$a[] r3 = r12.C
            r3 = r3[r8]
            d.f.a.h.d$a r8 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x02ae
            int r3 = r12.c()
            int r8 = r12.U
            if (r3 >= r8) goto L_0x02ae
            r3 = 2
            r8 = 1
            r9[r3] = r8
        L_0x02ae:
            int r0 = r0 + 1
            r12 = r20
            r8 = r21
            r3 = r22
            r16 = 0
            goto L_0x0271
        L_0x02b9:
            r22 = r3
            goto L_0x0300
        L_0x02bc:
            r22 = r3
            d.f.a.e r0 = r1.m0
            r1.c(r0)
            r0 = 0
        L_0x02c4:
            if (r0 >= r4) goto L_0x0300
            java.util.ArrayList<d.f.a.h.d> r3 = r1.k0
            java.lang.Object r3 = r3.get(r0)
            d.f.a.h.d r3 = (d.f.a.h.d) r3
            d.f.a.h.d$a[] r8 = r3.C
            r9 = 0
            r8 = r8[r9]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r8 != r9) goto L_0x02e6
            int r8 = r3.h()
            int r9 = r3.T
            if (r8 >= r9) goto L_0x02e6
            boolean[] r0 = d.f.a.h.i.f4715a
            r3 = 2
            r8 = 1
            r0[r3] = r8
            goto L_0x0300
        L_0x02e6:
            r8 = 1
            d.f.a.h.d$a[] r9 = r3.C
            r9 = r9[r8]
            d.f.a.h.d$a r12 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r9 != r12) goto L_0x02fd
            int r9 = r3.c()
            int r3 = r3.U
            if (r9 >= r3) goto L_0x02fd
            boolean[] r0 = d.f.a.h.i.f4715a
            r3 = 2
            r0[r3] = r8
            goto L_0x0300
        L_0x02fd:
            int r0 = r0 + 1
            goto L_0x02c4
        L_0x0300:
            if (r14 == 0) goto L_0x0373
            r3 = 8
            if (r7 >= r3) goto L_0x0373
            boolean[] r0 = d.f.a.h.i.f4715a
            r8 = 2
            boolean r0 = r0[r8]
            if (r0 == 0) goto L_0x0373
            r0 = 0
            r8 = 0
            r9 = 0
        L_0x0310:
            if (r0 >= r4) goto L_0x0336
            java.util.ArrayList<d.f.a.h.d> r12 = r1.k0
            java.lang.Object r12 = r12.get(r0)
            d.f.a.h.d r12 = (d.f.a.h.d) r12
            int r3 = r12.I
            int r18 = r12.h()
            int r3 = r18 + r3
            int r8 = java.lang.Math.max(r8, r3)
            int r3 = r12.J
            int r12 = r12.c()
            int r12 = r12 + r3
            int r9 = java.lang.Math.max(r9, r12)
            int r0 = r0 + 1
            r3 = 8
            goto L_0x0310
        L_0x0336:
            int r0 = r1.R
            int r0 = java.lang.Math.max(r0, r8)
            int r3 = r1.S
            int r3 = java.lang.Math.max(r3, r9)
            d.f.a.h.d$a r8 = d.f.a.h.d.a.WRAP_CONTENT
            if (r11 != r8) goto L_0x035a
            int r8 = r25.h()
            if (r8 >= r0) goto L_0x035a
            r1.f(r0)
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r8 = d.f.a.h.d.a.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r17 = 1
            goto L_0x035b
        L_0x035a:
            r0 = 0
        L_0x035b:
            d.f.a.h.d$a r8 = d.f.a.h.d.a.WRAP_CONTENT
            if (r10 != r8) goto L_0x0374
            int r8 = r25.c()
            if (r8 >= r3) goto L_0x0374
            r1.e(r3)
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r3 = d.f.a.h.d.a.WRAP_CONTENT
            r8 = 1
            r0[r8] = r3
            r0 = 1
            r17 = 1
            goto L_0x0374
        L_0x0373:
            r0 = 0
        L_0x0374:
            int r3 = r1.R
            int r8 = r25.h()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r25.h()
            if (r3 <= r8) goto L_0x0391
            r1.f(r3)
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r3 = d.f.a.h.d.a.FIXED
            r8 = 0
            r0[r8] = r3
            r0 = 1
            r17 = 1
        L_0x0391:
            int r3 = r1.S
            int r8 = r25.c()
            int r3 = java.lang.Math.max(r3, r8)
            int r8 = r25.c()
            if (r3 <= r8) goto L_0x03ae
            r1.e(r3)
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r3 = d.f.a.h.d.a.FIXED
            r8 = 1
            r0[r8] = r3
            r0 = r8
            r9 = r0
            goto L_0x03b1
        L_0x03ae:
            r8 = 1
            r9 = r17
        L_0x03b1:
            if (r9 != 0) goto L_0x03fb
            d.f.a.h.d$a[] r3 = r1.C
            r12 = 0
            r3 = r3[r12]
            d.f.a.h.d$a r12 = d.f.a.h.d.a.WRAP_CONTENT
            if (r3 != r12) goto L_0x03d3
            if (r5 <= 0) goto L_0x03d3
            int r3 = r25.h()
            if (r3 <= r5) goto L_0x03d3
            r1.E0 = r8
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r3 = d.f.a.h.d.a.FIXED
            r9 = 0
            r0[r9] = r3
            r1.f(r5)
            r0 = r8
            r9 = r0
            goto L_0x03d8
        L_0x03d3:
            r24 = r9
            r9 = r0
            r0 = r24
        L_0x03d8:
            d.f.a.h.d$a[] r3 = r1.C
            r3 = r3[r8]
            d.f.a.h.d$a r12 = d.f.a.h.d.a.WRAP_CONTENT
            if (r3 != r12) goto L_0x03f6
            if (r6 <= 0) goto L_0x03f6
            int r3 = r25.c()
            if (r3 <= r6) goto L_0x03f6
            r1.F0 = r8
            d.f.a.h.d$a[] r0 = r1.C
            d.f.a.h.d$a r3 = d.f.a.h.d.a.FIXED
            r0[r8] = r3
            r1.e(r6)
            r8 = 1
            r9 = 1
            goto L_0x03fc
        L_0x03f6:
            r24 = r9
            r9 = r0
            r0 = r24
        L_0x03fb:
            r8 = r0
        L_0x03fc:
            r0 = r7
            r7 = r9
            r12 = r19
            r3 = r22
            goto L_0x01d6
        L_0x0404:
            r22 = r3
            r17 = r7
            r19 = r12
            java.util.List<d.f.a.h.f> r0 = r1.w0
            java.lang.Object r0 = r0.get(r15)
            d.f.a.h.f r0 = (d.f.a.h.f) r0
            java.util.List<d.f.a.h.d> r3 = r0.k
            int r3 = r3.size()
            r4 = 0
        L_0x0419:
            if (r4 >= r3) goto L_0x0429
            java.util.List<d.f.a.h.d> r7 = r0.k
            java.lang.Object r7 = r7.get(r4)
            d.f.a.h.d r7 = (d.f.a.h.d) r7
            r0.a(r7)
            int r4 = r4 + 1
            goto L_0x0419
        L_0x0429:
            r0 = r17
        L_0x042b:
            int r15 = r15 + 1
            r12 = r19
            r3 = r22
            r4 = 0
            r7 = 8
            r8 = 32
            r9 = 1
            goto L_0x0127
        L_0x0439:
            r22 = r3
            r1.k0 = r13
            d.f.a.h.d r3 = r1.D
            if (r3 == 0) goto L_0x04af
            int r2 = r1.R
            int r3 = r25.h()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.S
            int r4 = r25.c()
            int r3 = java.lang.Math.max(r3, r4)
            d.f.a.h.m r4 = r1.n0
            int r5 = r4.f4727a
            r1.I = r5
            int r5 = r4.f4728b
            r1.J = r5
            int r5 = r4.f4729c
            r1.f(r5)
            int r5 = r4.f4730d
            r1.e(r5)
            java.util.ArrayList<d.f.a.h.m$a> r5 = r4.f4731e
            int r5 = r5.size()
            r6 = 0
        L_0x0470:
            if (r6 >= r5) goto L_0x049c
            java.util.ArrayList<d.f.a.h.m$a> r7 = r4.f4731e
            java.lang.Object r7 = r7.get(r6)
            d.f.a.h.m$a r7 = (d.f.a.h.m.a) r7
            d.f.a.h.c r8 = r7.f4732a
            d.f.a.h.c$c r8 = r8.f4666c
            d.f.a.h.c r17 = r1.a(r8)
            d.f.a.h.c r8 = r7.f4733b
            int r9 = r7.f4734c
            d.f.a.h.c$b r12 = r7.f4735d
            int r7 = r7.f4736e
            r20 = -1
            r23 = 0
            r18 = r8
            r19 = r9
            r21 = r12
            r22 = r7
            r17.a(r18, r19, r20, r21, r22, r23)
            int r6 = r6 + 1
            goto L_0x0470
        L_0x049c:
            int r4 = r1.o0
            int r2 = r2 + r4
            int r4 = r1.q0
            int r2 = r2 + r4
            r1.f(r2)
            int r2 = r1.p0
            int r3 = r3 + r2
            int r2 = r1.r0
            int r3 = r3 + r2
            r1.e(r3)
            goto L_0x04b5
        L_0x04af:
            r1.I = r2
            r2 = r22
            r1.J = r2
        L_0x04b5:
            if (r0 == 0) goto L_0x04bf
            d.f.a.h.d$a[] r0 = r1.C
            r2 = 0
            r0[r2] = r11
            r2 = 1
            r0[r2] = r10
        L_0x04bf:
            d.f.a.e r0 = r1.m0
            d.f.a.c r0 = r0.l
            r1.a(r0)
            d.f.a.h.d r0 = r1.D
            r2 = r1
        L_0x04c9:
            if (r0 == 0) goto L_0x04d6
            d.f.a.h.d r3 = r0.D
            boolean r4 = r0 instanceof d.f.a.h.e
            if (r4 == 0) goto L_0x04d4
            r2 = r0
            d.f.a.h.e r2 = (d.f.a.h.e) r2
        L_0x04d4:
            r0 = r3
            goto L_0x04c9
        L_0x04d6:
            if (r1 != r2) goto L_0x04db
            r25.m()
        L_0x04db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.e.n():void");
    }

    public void o() {
        int size = this.k0.size();
        k();
        for (int i2 = 0; i2 < size; i2++) {
            ((d) this.k0.get(i2)).k();
        }
    }

    public final void p() {
        this.s0 = 0;
        this.t0 = 0;
    }

    public void q() {
        j jVar = a(C0033c.LEFT).f4664a;
        j jVar2 = a(C0033c.TOP).f4664a;
        jVar.a((j) null, 0.0f);
        jVar2.a((j) null, 0.0f);
    }

    public void a(d dVar, int i2) {
        if (i2 == 0) {
            int i3 = this.s0 + 1;
            b[] bVarArr = this.v0;
            if (i3 >= bVarArr.length) {
                this.v0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            this.v0[this.s0] = new b(dVar, 0, this.l0);
            this.s0++;
        } else if (i2 == 1) {
            int i4 = this.t0 + 1;
            b[] bVarArr2 = this.u0;
            if (i4 >= bVarArr2.length) {
                this.u0 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length * 2);
            }
            this.u0[this.t0] = new b(dVar, 1, this.l0);
            this.t0++;
        }
    }
}
