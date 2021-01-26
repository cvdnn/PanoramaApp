package e.d.a.n.o.y;

import android.content.Context;
import android.net.Uri;
import com.arashivision.graphicpath.insmedia.previewer2.TrackName;
import e.d.a.n.h;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import e.d.a.s.b;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader */
public class c implements n<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    public final Context f7626a;

    /* compiled from: MediaStoreImageThumbLoader */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final Context f7627a;

        public a(Context context) {
            this.f7627a = context;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f7627a);
        }
    }

    public c(Context context) {
        this.f7626a = context.getApplicationContext();
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Uri uri = (Uri) obj;
        if (!e.c.f.n.n.a(i2, i3)) {
            return null;
        }
        b bVar = new b(uri);
        Context context = this.f7626a;
        return new e.d.a.n.o.n.a(bVar, e.d.a.n.m.p.b.a(context, uri, new e.d.a.n.m.p.b.a(context.getContentResolver())));
    }

    public boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return e.c.f.n.n.a(uri) && !uri.getPathSegments().contains(TrackName.VIDEO);
    }
}
