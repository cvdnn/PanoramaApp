package d.f.a.h;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: ConstraintWidgetGroup */
public class f {

    /* renamed from: a reason: collision with root package name */
    public List<d> f4705a;

    /* renamed from: b reason: collision with root package name */
    public int f4706b = -1;

    /* renamed from: c reason: collision with root package name */
    public int f4707c = -1;

    /* renamed from: d reason: collision with root package name */
    public boolean f4708d = false;

    /* renamed from: e reason: collision with root package name */
    public final int[] f4709e = {-1, -1};

    /* renamed from: f reason: collision with root package name */
    public List<d> f4710f = new ArrayList();

    /* renamed from: g reason: collision with root package name */
    public List<d> f4711g = new ArrayList();

    /* renamed from: h reason: collision with root package name */
    public HashSet<d> f4712h = new HashSet<>();

    /* renamed from: i reason: collision with root package name */
    public HashSet<d> f4713i = new HashSet<>();

    /* renamed from: j reason: collision with root package name */
    public List<d> f4714j = new ArrayList();
    public List<d> k = new ArrayList();

    public f(List<d> list) {
        this.f4705a = list;
    }

    public void a(d dVar, int i2) {
        if (i2 == 0) {
            this.f4712h.add(dVar);
        } else if (i2 == 1) {
            this.f4713i.add(dVar);
        }
    }

    public final void a(ArrayList<d> arrayList, d dVar) {
        if (!dVar.d0) {
            arrayList.add(dVar);
            dVar.d0 = true;
            if (!dVar.i()) {
                if (dVar instanceof h) {
                    h hVar = (h) dVar;
                    int i2 = hVar.l0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        a(arrayList, hVar.k0[i3]);
                    }
                }
                for (c cVar : dVar.A) {
                    c cVar2 = cVar.f4667d;
                    if (cVar2 != null) {
                        d dVar2 = cVar2.f4665b;
                        if (dVar2 != dVar.D) {
                            a(arrayList, dVar2);
                        }
                    }
                }
            }
        }
    }

    public f(List<d> list, boolean z) {
        this.f4705a = list;
        this.f4708d = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(d.f.a.h.d r7) {
        /*
            r6 = this;
            boolean r0 = r7.b0
            if (r0 == 0) goto L_0x00dd
            boolean r0 = r7.i()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            d.f.a.h.c r0 = r7.u
            d.f.a.h.c r0 = r0.f4667d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001d
            d.f.a.h.c r3 = r7.u
            d.f.a.h.c r3 = r3.f4667d
            goto L_0x0021
        L_0x001d:
            d.f.a.h.c r3 = r7.s
            d.f.a.h.c r3 = r3.f4667d
        L_0x0021:
            if (r3 == 0) goto L_0x0045
            d.f.a.h.d r4 = r3.f4665b
            boolean r5 = r4.c0
            if (r5 != 0) goto L_0x002c
            r6.a(r4)
        L_0x002c:
            d.f.a.h.c$c r4 = r3.f4666c
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.RIGHT
            if (r4 != r5) goto L_0x003c
            d.f.a.h.d r3 = r3.f4665b
            int r4 = r3.I
            int r3 = r3.h()
            int r3 = r3 + r4
            goto L_0x0046
        L_0x003c:
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.LEFT
            if (r4 != r5) goto L_0x0045
            d.f.a.h.d r3 = r3.f4665b
            int r3 = r3.I
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            if (r0 == 0) goto L_0x0050
            d.f.a.h.c r0 = r7.u
            int r0 = r0.a()
            int r3 = r3 - r0
            goto L_0x005c
        L_0x0050:
            d.f.a.h.c r0 = r7.s
            int r0 = r0.a()
            int r4 = r7.h()
            int r4 = r4 + r0
            int r3 = r3 + r4
        L_0x005c:
            int r0 = r7.h()
            int r0 = r3 - r0
            r7.a(r0, r3)
            d.f.a.h.c r0 = r7.w
            d.f.a.h.c r0 = r0.f4667d
            if (r0 == 0) goto L_0x0087
            d.f.a.h.d r1 = r0.f4665b
            boolean r3 = r1.c0
            if (r3 != 0) goto L_0x0074
            r6.a(r1)
        L_0x0074:
            d.f.a.h.d r0 = r0.f4665b
            int r1 = r0.J
            int r0 = r0.Q
            int r1 = r1 + r0
            int r0 = r7.Q
            int r1 = r1 - r0
            int r0 = r7.F
            int r0 = r0 + r1
            r7.c(r1, r0)
            r7.c0 = r2
            return
        L_0x0087:
            d.f.a.h.c r0 = r7.v
            d.f.a.h.c r0 = r0.f4667d
            if (r0 == 0) goto L_0x008e
            r1 = r2
        L_0x008e:
            if (r1 == 0) goto L_0x0095
            d.f.a.h.c r0 = r7.v
            d.f.a.h.c r0 = r0.f4667d
            goto L_0x0099
        L_0x0095:
            d.f.a.h.c r0 = r7.t
            d.f.a.h.c r0 = r0.f4667d
        L_0x0099:
            if (r0 == 0) goto L_0x00bc
            d.f.a.h.d r4 = r0.f4665b
            boolean r5 = r4.c0
            if (r5 != 0) goto L_0x00a4
            r6.a(r4)
        L_0x00a4:
            d.f.a.h.c$c r4 = r0.f4666c
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.BOTTOM
            if (r4 != r5) goto L_0x00b4
            d.f.a.h.d r0 = r0.f4665b
            int r3 = r0.J
            int r0 = r0.c()
            int r3 = r3 + r0
            goto L_0x00bc
        L_0x00b4:
            d.f.a.h.c$c r5 = d.f.a.h.c.C0033c.TOP
            if (r4 != r5) goto L_0x00bc
            d.f.a.h.d r0 = r0.f4665b
            int r3 = r0.J
        L_0x00bc:
            if (r1 == 0) goto L_0x00c6
            d.f.a.h.c r0 = r7.v
            int r0 = r0.a()
            int r3 = r3 - r0
            goto L_0x00d2
        L_0x00c6:
            d.f.a.h.c r0 = r7.t
            int r0 = r0.a()
            int r1 = r7.c()
            int r1 = r1 + r0
            int r3 = r3 + r1
        L_0x00d2:
            int r0 = r7.c()
            int r0 = r3 - r0
            r7.c(r0, r3)
            r7.c0 = r2
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.f.a(d.f.a.h.d):void");
    }
}
