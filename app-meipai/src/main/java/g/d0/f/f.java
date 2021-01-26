package g.d0.f;

import g.d0.e.c;
import g.d0.e.g;
import g.e;
import g.n;
import g.s;
import g.s.a;
import g.x;
import g.z;
import java.io.IOException;
import java.util.List;

/* compiled from: RealInterceptorChain */
public final class f implements a {

    /* renamed from: a reason: collision with root package name */
    public final List<s> f9237a;

    /* renamed from: b reason: collision with root package name */
    public final g f9238b;

    /* renamed from: c reason: collision with root package name */
    public final c f9239c;

    /* renamed from: d reason: collision with root package name */
    public final c f9240d;

    /* renamed from: e reason: collision with root package name */
    public final int f9241e;

    /* renamed from: f reason: collision with root package name */
    public final x f9242f;

    /* renamed from: g reason: collision with root package name */
    public final e f9243g;

    /* renamed from: h reason: collision with root package name */
    public final n f9244h;

    /* renamed from: i reason: collision with root package name */
    public final int f9245i;

    /* renamed from: j reason: collision with root package name */
    public final int f9246j;
    public final int k;
    public int l;

    public f(List<s> list, g gVar, c cVar, c cVar2, int i2, x xVar, e eVar, n nVar, int i3, int i4, int i5) {
        this.f9237a = list;
        this.f9240d = cVar2;
        this.f9238b = gVar;
        this.f9239c = cVar;
        this.f9241e = i2;
        this.f9242f = xVar;
        this.f9243g = eVar;
        this.f9244h = nVar;
        this.f9245i = i3;
        this.f9246j = i4;
        this.k = i5;
    }

    public z a(x xVar) throws IOException {
        return a(xVar, this.f9238b, this.f9239c, this.f9240d);
    }

    public z a(x xVar, g gVar, c cVar, c cVar2) throws IOException {
        if (this.f9241e < this.f9237a.size()) {
            this.l++;
            String str = "network interceptor ";
            if (this.f9239c == null) {
                x xVar2 = xVar;
            } else if (!this.f9240d.a(xVar.f9595a)) {
                StringBuilder a2 = e.a.a.a.a.a(str);
                a2.append(this.f9237a.get(this.f9241e - 1));
                a2.append(" must retain the same host and port");
                throw new IllegalStateException(a2.toString());
            }
            String str2 = " must call proceed() exactly once";
            if (this.f9239c == null || this.l <= 1) {
                String str3 = str2;
                f fVar = new f(this.f9237a, gVar, cVar, cVar2, this.f9241e + 1, xVar, this.f9243g, this.f9244h, this.f9245i, this.f9246j, this.k);
                s sVar = (s) this.f9237a.get(this.f9241e);
                z intercept = sVar.intercept(fVar);
                if (cVar == null || this.f9241e + 1 >= this.f9237a.size() || fVar.l == 1) {
                    String str4 = "interceptor ";
                    if (intercept == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append(sVar);
                        sb.append(" returned null");
                        throw new NullPointerException(sb.toString());
                    } else if (intercept.f9620g != null) {
                        return intercept;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append(sVar);
                        sb2.append(" returned a response with no body");
                        throw new IllegalStateException(sb2.toString());
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(sVar);
                    sb3.append(str3);
                    throw new IllegalStateException(sb3.toString());
                }
            } else {
                StringBuilder a3 = e.a.a.a.a.a(str);
                a3.append(this.f9237a.get(this.f9241e - 1));
                a3.append(str2);
                throw new IllegalStateException(a3.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
