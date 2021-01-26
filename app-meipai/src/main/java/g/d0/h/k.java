package g.d0.h;

import g.d0.b;
import g.d0.h.r.a;

/* compiled from: Http2Connection */
public class k extends b {

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ int f9379b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ b f9380c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ g f9381d;

    public k(g gVar, String str, Object[] objArr, int i2, b bVar) {
        this.f9381d = gVar;
        this.f9379b = i2;
        this.f9380c = bVar;
        super(str, objArr);
    }

    public void a() {
        g gVar = this.f9381d;
        if (((a) gVar.f9342j) != null) {
            synchronized (gVar) {
                this.f9381d.s.remove(Integer.valueOf(this.f9379b));
            }
            return;
        }
        throw null;
    }
}
