package e.d.a.n.o.y;

import e.d.a.n.h;
import e.d.a.n.m.j;
import e.d.a.n.o.g;
import e.d.a.n.o.m;
import e.d.a.n.o.m.b;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader */
public class a implements n<g, InputStream> {

    /* renamed from: b reason: collision with root package name */
    public static final e.d.a.n.g<Integer> f7621b = e.d.a.n.g.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));

    /* renamed from: a reason: collision with root package name */
    public final m<g, g> f7622a;

    /* renamed from: e.d.a.n.o.y.a$a reason: collision with other inner class name */
    /* compiled from: HttpGlideUrlLoader */
    public static class C0092a implements o<g, InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final m<g, g> f7623a = new m<>(500);

        public n<g, InputStream> a(r rVar) {
            return new a(this.f7623a);
        }
    }

    public a(m<g, g> mVar) {
        this.f7622a = mVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        g gVar = (g) obj;
        m<g, g> mVar = this.f7622a;
        if (mVar != null) {
            b a2 = b.a(gVar, 0, 0);
            Object a3 = mVar.f7573a.a(a2);
            a2.a();
            g gVar2 = (g) a3;
            if (gVar2 == null) {
                m<g, g> mVar2 = this.f7622a;
                if (mVar2 != null) {
                    mVar2.f7573a.b(b.a(gVar, 0, 0), gVar);
                } else {
                    throw null;
                }
            } else {
                gVar = gVar2;
            }
        }
        return new e.d.a.n.o.n.a(gVar, new j(gVar, ((Integer) hVar.a(f7621b)).intValue()));
    }

    public boolean a(Object obj) {
        g gVar = (g) obj;
        return true;
    }
}
