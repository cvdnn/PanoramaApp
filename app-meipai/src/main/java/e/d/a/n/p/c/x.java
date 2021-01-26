package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.n.p.e.d;
import java.io.IOException;

/* compiled from: ResourceBitmapDecoder */
public class x implements j<Uri, Bitmap> {

    /* renamed from: a reason: collision with root package name */
    public final d f7732a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.n.n.c0.d f7733b;

    public x(d dVar, e.d.a.n.n.c0.d dVar2) {
        this.f7732a = dVar;
        this.f7733b = dVar2;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        w a2 = this.f7732a.a((Uri) obj);
        if (a2 == null) {
            return null;
        }
        return n.a(this.f7733b, (Drawable) a2.get(), i2, i3);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        return "android.resource".equals(((Uri) obj).getScheme());
    }
}
