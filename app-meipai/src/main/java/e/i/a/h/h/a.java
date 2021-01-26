package e.i.a.h.h;

import e.i.a.c;
import e.i.a.h.e.b;

/* compiled from: BreakpointLocalCheck */
public class a {

    /* renamed from: a reason: collision with root package name */
    public boolean f8800a;

    /* renamed from: b reason: collision with root package name */
    public boolean f8801b;

    /* renamed from: c reason: collision with root package name */
    public boolean f8802c;

    /* renamed from: d reason: collision with root package name */
    public boolean f8803d;

    /* renamed from: e reason: collision with root package name */
    public final c f8804e;

    /* renamed from: f reason: collision with root package name */
    public final e.i.a.h.d.c f8805f;

    /* renamed from: g reason: collision with root package name */
    public final long f8806g;

    public a(c cVar, e.i.a.h.d.c cVar2, long j2) {
        this.f8804e = cVar;
        this.f8805f = cVar2;
        this.f8806g = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (e.i.a.h.c.a(r0) > 0) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r0.exists() != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            e.i.a.c r0 = r10.f8804e
            android.net.Uri r0 = r0.f8651d
            boolean r1 = e.i.a.h.c.b(r0)
            r2 = 0
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x001a
            long r0 = e.i.a.h.c.a(r0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0018
        L_0x0016:
            r0 = r5
            goto L_0x0029
        L_0x0018:
            r0 = r4
            goto L_0x0029
        L_0x001a:
            e.i.a.c r0 = r10.f8804e
            java.io.File r0 = r0.g()
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0018
            goto L_0x0016
        L_0x0029:
            r10.f8801b = r0
            e.i.a.h.d.c r0 = r10.f8805f
            int r0 = r0.b()
            if (r0 > 0) goto L_0x0035
        L_0x0033:
            r0 = r4
            goto L_0x0092
        L_0x0035:
            e.i.a.h.d.c r1 = r10.f8805f
            boolean r6 = r1.f8710i
            if (r6 == 0) goto L_0x003c
            goto L_0x0033
        L_0x003c:
            java.io.File r1 = r1.c()
            if (r1 != 0) goto L_0x0043
            goto L_0x0033
        L_0x0043:
            e.i.a.c r1 = r10.f8804e
            java.io.File r1 = r1.g()
            e.i.a.h.d.c r6 = r10.f8805f
            java.io.File r6 = r6.c()
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0056
            goto L_0x0033
        L_0x0056:
            e.i.a.h.d.c r1 = r10.f8805f
            java.io.File r1 = r1.c()
            long r6 = r1.length()
            e.i.a.h.d.c r1 = r10.f8805f
            long r8 = r1.d()
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x006b
            goto L_0x0033
        L_0x006b:
            long r6 = r10.f8806g
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x007e
            e.i.a.h.d.c r1 = r10.f8805f
            long r6 = r1.d()
            long r8 = r10.f8806g
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x007e
            goto L_0x0033
        L_0x007e:
            r1 = r4
        L_0x007f:
            if (r1 >= r0) goto L_0x0091
            e.i.a.h.d.c r6 = r10.f8805f
            e.i.a.h.d.a r6 = r6.a(r1)
            long r6 = r6.f8696b
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x008e
            goto L_0x0033
        L_0x008e:
            int r1 = r1 + 1
            goto L_0x007f
        L_0x0091:
            r0 = r5
        L_0x0092:
            r10.f8802c = r0
            e.i.a.e r0 = e.i.a.e.a()
            e.i.a.h.j.a$a r0 = r0.f8668e
            e.i.a.h.j.b$a r0 = (e.i.a.h.j.b.a) r0
            if (r0 == 0) goto L_0x00ae
            r10.f8803d = r5
            boolean r0 = r10.f8802c
            if (r0 == 0) goto L_0x00aa
            boolean r0 = r10.f8801b
            if (r0 == 0) goto L_0x00aa
            if (r5 != 0) goto L_0x00ab
        L_0x00aa:
            r4 = r5
        L_0x00ab:
            r10.f8800a = r4
            return
        L_0x00ae:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.h.h.a.a():void");
    }

    public b b() {
        if (!this.f8802c) {
            return b.INFO_DIRTY;
        }
        if (!this.f8801b) {
            return b.FILE_NOT_EXIST;
        }
        if (!this.f8803d) {
            return b.OUTPUT_STREAM_NOT_SUPPORT;
        }
        StringBuilder a2 = e.a.a.a.a.a("No cause find with dirty: ");
        a2.append(this.f8800a);
        throw new IllegalStateException(a2.toString());
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("fileExist[");
        a2.append(this.f8801b);
        String str = "] ";
        a2.append(str);
        a2.append("infoRight[");
        a2.append(this.f8802c);
        a2.append(str);
        a2.append("outputStreamSupport[");
        a2.append(this.f8803d);
        a2.append(str);
        a2.append(super.toString());
        return a2.toString();
    }
}
