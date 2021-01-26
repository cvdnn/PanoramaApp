package e.d.a.n.o.y;

import android.net.Uri;
import e.d.a.n.h;
import e.d.a.n.o.g;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: HttpUriLoader */
public class b implements n<Uri, InputStream> {

    /* renamed from: b reason: collision with root package name */
    public static final Set<String> f7624b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a reason: collision with root package name */
    public final n<g, InputStream> f7625a;

    /* compiled from: HttpUriLoader */
    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> a(r rVar) {
            return new b(rVar.a(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f7625a = nVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        return this.f7625a.a(new g(((Uri) obj).toString()), i2, i3, hVar);
    }

    public boolean a(Object obj) {
        return f7624b.contains(((Uri) obj).getScheme());
    }
}
