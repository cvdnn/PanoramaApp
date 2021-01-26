package e.d.a.n.o;

import android.net.Uri;
import e.d.a.n.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b reason: collision with root package name */
    public static final Set<String> f7619b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a reason: collision with root package name */
    public final n<g, Data> f7620a;

    /* compiled from: UrlUriLoader */
    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f7620a = nVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        return this.f7620a.a(new g(((Uri) obj).toString()), i2, i3, hVar);
    }

    public boolean a(Object obj) {
        return f7619b.contains(((Uri) obj).getScheme());
    }
}
