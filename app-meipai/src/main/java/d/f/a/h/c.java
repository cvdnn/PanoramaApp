package d.f.a.h;

import com.baidu.mobstat.Config;
import d.f.a.g;

/* compiled from: ConstraintAnchor */
public class c {

    /* renamed from: a reason: collision with root package name */
    public j f4664a = new j(this);

    /* renamed from: b reason: collision with root package name */
    public final d f4665b;

    /* renamed from: c reason: collision with root package name */
    public final C0033c f4666c;

    /* renamed from: d reason: collision with root package name */
    public c f4667d;

    /* renamed from: e reason: collision with root package name */
    public int f4668e = 0;

    /* renamed from: f reason: collision with root package name */
    public int f4669f = -1;

    /* renamed from: g reason: collision with root package name */
    public b f4670g = b.NONE;

    /* renamed from: h reason: collision with root package name */
    public int f4671h;

    /* renamed from: i reason: collision with root package name */
    public g f4672i;

    /* compiled from: ConstraintAnchor */
    public enum a {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor */
    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    /* renamed from: d.f.a.h.c$c reason: collision with other inner class name */
    /* compiled from: ConstraintAnchor */
    public enum C0033c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public c(d dVar, C0033c cVar) {
        a aVar = a.RELAXED;
        this.f4671h = 0;
        this.f4665b = dVar;
        this.f4666c = cVar;
    }

    public int a() {
        if (this.f4665b.Y == 8) {
            return 0;
        }
        int i2 = this.f4669f;
        if (i2 > -1) {
            c cVar = this.f4667d;
            if (cVar != null && cVar.f4665b.Y == 8) {
                return i2;
            }
        }
        return this.f4668e;
    }

    public boolean b() {
        return this.f4667d != null;
    }

    public void c() {
        this.f4667d = null;
        this.f4668e = 0;
        this.f4669f = -1;
        this.f4670g = b.STRONG;
        this.f4671h = 0;
        a aVar = a.RELAXED;
        this.f4664a.e();
    }

    public void d() {
        g gVar = this.f4672i;
        if (gVar == null) {
            this.f4672i = new g(d.f.a.g.a.UNRESTRICTED);
        } else {
            gVar.a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4665b.Z);
        sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
        sb.append(this.f4666c.toString());
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if ((r4.f4665b.Q > 0) == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        if (r10 != d.f.a.h.c.C0033c.f4688i) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0070, code lost:
        if (r10 != d.f.a.h.c.C0033c.f4688i) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008b, code lost:
        if (r10 != d.f.a.h.c.C0033c.f4687h) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0090 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(d.f.a.h.c r5, int r6, int r7, d.f.a.h.c.b r8, int r9, boolean r10) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0014
            r5 = 0
            r4.f4667d = r5
            r4.f4668e = r1
            r5 = -1
            r4.f4669f = r5
            d.f.a.h.c$b r5 = d.f.a.h.c.b.NONE
            r4.f4670g = r5
            r5 = 2
            r4.f4671h = r5
            return r0
        L_0x0014:
            if (r10 != 0) goto L_0x0091
            d.f.a.h.c$c r10 = r5.f4666c
            d.f.a.h.c$c r2 = r4.f4666c
            if (r10 != r2) goto L_0x0037
            d.f.a.h.c$c r10 = d.f.a.h.c.C0033c.BASELINE
            if (r2 != r10) goto L_0x0056
            d.f.a.h.d r10 = r5.f4665b
            int r10 = r10.Q
            if (r10 <= 0) goto L_0x0028
            r10 = r0
            goto L_0x0029
        L_0x0028:
            r10 = r1
        L_0x0029:
            if (r10 == 0) goto L_0x0058
            d.f.a.h.d r10 = r4.f4665b
            int r10 = r10.Q
            if (r10 <= 0) goto L_0x0033
            r10 = r0
            goto L_0x0034
        L_0x0033:
            r10 = r1
        L_0x0034:
            if (r10 != 0) goto L_0x0056
            goto L_0x0058
        L_0x0037:
            int r2 = r2.ordinal()
            switch(r2) {
                case 0: goto L_0x0058;
                case 1: goto L_0x0075;
                case 2: goto L_0x005a;
                case 3: goto L_0x0075;
                case 4: goto L_0x005a;
                case 5: goto L_0x0058;
                case 6: goto L_0x004a;
                case 7: goto L_0x0058;
                case 8: goto L_0x0058;
                default: goto L_0x003e;
            }
        L_0x003e:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            d.f.a.h.c$c r6 = r4.f4666c
            java.lang.String r6 = r6.name()
            r5.<init>(r6)
            throw r5
        L_0x004a:
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.BASELINE
            if (r10 == r2) goto L_0x0058
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.CENTER_X
            if (r10 == r2) goto L_0x0058
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.CENTER_Y
            if (r10 == r2) goto L_0x0058
        L_0x0056:
            r10 = r0
            goto L_0x008e
        L_0x0058:
            r10 = r1
            goto L_0x008e
        L_0x005a:
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.TOP
            if (r10 == r2) goto L_0x0065
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.BOTTOM
            if (r10 != r2) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r2 = r1
            goto L_0x0066
        L_0x0065:
            r2 = r0
        L_0x0066:
            d.f.a.h.d r3 = r5.f4665b
            boolean r3 = r3 instanceof d.f.a.h.g
            if (r3 == 0) goto L_0x0073
            if (r2 != 0) goto L_0x0056
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.CENTER_Y
            if (r10 != r2) goto L_0x0058
            goto L_0x0056
        L_0x0073:
            r10 = r2
            goto L_0x008e
        L_0x0075:
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.LEFT
            if (r10 == r2) goto L_0x0080
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.RIGHT
            if (r10 != r2) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r2 = r1
            goto L_0x0081
        L_0x0080:
            r2 = r0
        L_0x0081:
            d.f.a.h.d r3 = r5.f4665b
            boolean r3 = r3 instanceof d.f.a.h.g
            if (r3 == 0) goto L_0x0073
            if (r2 != 0) goto L_0x0056
            d.f.a.h.c$c r2 = d.f.a.h.c.C0033c.CENTER_X
            if (r10 != r2) goto L_0x0058
            goto L_0x0056
        L_0x008e:
            if (r10 != 0) goto L_0x0091
            return r1
        L_0x0091:
            r4.f4667d = r5
            if (r6 <= 0) goto L_0x0098
            r4.f4668e = r6
            goto L_0x009a
        L_0x0098:
            r4.f4668e = r1
        L_0x009a:
            r4.f4669f = r7
            r4.f4670g = r8
            r4.f4671h = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.h.c.a(d.f.a.h.c, int, int, d.f.a.h.c$b, int, boolean):boolean");
    }
}
