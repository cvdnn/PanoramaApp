package e.d.a.n.o.y;

import android.content.Context;
import android.net.Uri;
import com.arashivision.graphicpath.insmedia.previewer2.TrackName;
import e.d.a.n.h;
import e.d.a.n.m.p.b.C0080b;
import e.d.a.n.o.n;
import e.d.a.n.o.o;
import e.d.a.n.o.r;
import e.d.a.n.p.c.b0;
import e.d.a.s.b;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader */
public class d implements n<Uri, InputStream> {

    /* renamed from: a reason: collision with root package name */
    public final Context f7628a;

    /* compiled from: MediaStoreVideoThumbLoader */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final Context f7629a;

        public a(Context context) {
            this.f7629a = context;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new d(this.f7629a);
        }
    }

    public d(Context context) {
        this.f7628a = context.getApplicationContext();
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Uri uri = (Uri) obj;
        if (e.c.f.n.n.a(i2, i3)) {
            Long l = (Long) hVar.a(b0.f7661d);
            if (l != null && l.longValue() == -1) {
                b bVar = new b(uri);
                Context context = this.f7628a;
                return new e.d.a.n.o.n.a(bVar, e.d.a.n.m.p.b.a(context, uri, new C0080b(context.getContentResolver())));
            }
        }
        return null;
    }

    public boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return e.c.f.n.n.a(uri) && uri.getPathSegments().contains(TrackName.VIDEO);
    }
}
