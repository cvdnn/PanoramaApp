package e.d.a.n.n.d0;

import e.d.a.n.f;
import e.d.a.n.n.d0.i.a;
import e.d.a.n.n.l;
import e.d.a.n.n.w;
import e.d.a.t.g;

/* compiled from: LruResourceCache */
public class h extends g<f, w<?>> implements i {

    /* renamed from: d reason: collision with root package name */
    public a f7357d;

    public h(long j2) {
        super(j2);
    }

    public void a(Object obj, Object obj2) {
        f fVar = (f) obj;
        w wVar = (w) obj2;
        a aVar = this.f7357d;
        if (aVar != null && wVar != null) {
            ((l) aVar).f7443e.a(wVar, true);
        }
    }

    public int b(Object obj) {
        w wVar = (w) obj;
        if (wVar == null) {
            return 1;
        }
        return wVar.getSize();
    }

    public /* bridge */ /* synthetic */ w a(f fVar, w wVar) {
        return (w) super.b(fVar, wVar);
    }

    public /* bridge */ /* synthetic */ w a(f fVar) {
        return (w) super.c(fVar);
    }
}
