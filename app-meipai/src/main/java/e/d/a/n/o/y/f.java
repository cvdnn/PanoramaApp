package e.d.a.n.o.y;

import e.d.a.n.h;
import e.d.a.n.o.g;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader */
public class f implements n<URL, InputStream> {

    /* renamed from: a reason: collision with root package name */
    public final n<g, InputStream> f7646a;

    /* compiled from: UrlLoader */
    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> a(r rVar) {
            return new f(rVar.a(g.class, InputStream.class));
        }
    }

    public f(n<g, InputStream> nVar) {
        this.f7646a = nVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        return this.f7646a.a(new g((URL) obj), i2, i3, hVar);
    }

    public boolean a(Object obj) {
        URL url = (URL) obj;
        return true;
    }
}
