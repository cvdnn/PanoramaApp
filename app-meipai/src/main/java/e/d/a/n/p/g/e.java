package e.d.a.n.p.g;

import android.graphics.Bitmap;
import e.d.a.n.n.s;
import e.d.a.n.p.e.b;
import e.d.a.n.p.g.g.a;
import e.d.a.r.h.h;

/* compiled from: GifDrawableResource */
public class e extends b<c> implements s {
    public e(c cVar) {
        super(cVar);
    }

    public void a() {
        ((c) this.f7745a).b().prepareToDraw();
    }

    public void b() {
        ((c) this.f7745a).stop();
        c cVar = (c) this.f7745a;
        cVar.f7761d = true;
        g gVar = cVar.f7758a.f7768a;
        gVar.f7772c.clear();
        Bitmap bitmap = gVar.m;
        if (bitmap != null) {
            gVar.f7774e.a(bitmap);
            gVar.m = null;
        }
        gVar.f7775f = false;
        a aVar = gVar.f7779j;
        if (aVar != null) {
            gVar.f7773d.a((h<?>) aVar);
            gVar.f7779j = null;
        }
        a aVar2 = gVar.l;
        if (aVar2 != null) {
            gVar.f7773d.a((h<?>) aVar2);
            gVar.l = null;
        }
        a aVar3 = gVar.n;
        if (aVar3 != null) {
            gVar.f7773d.a((h<?>) aVar3);
            gVar.n = null;
        }
        gVar.f7770a.clear();
        gVar.k = true;
    }

    public Class<c> c() {
        return c.class;
    }

    public int getSize() {
        g gVar = ((c) this.f7745a).f7758a.f7768a;
        return gVar.f7770a.g() + gVar.o;
    }
}
