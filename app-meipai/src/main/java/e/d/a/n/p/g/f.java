package e.d.a.n.p.g;

import android.content.Context;
import android.graphics.Bitmap;
import e.c.f.n.n;
import e.d.a.b;
import e.d.a.n.l;
import e.d.a.n.n.w;
import e.d.a.n.p.c.e;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation */
public class f implements l<c> {

    /* renamed from: b reason: collision with root package name */
    public final l<Bitmap> f7769b;

    public f(l<Bitmap> lVar) {
        n.a(lVar, "Argument must not be null");
        this.f7769b = lVar;
    }

    public w<c> a(Context context, w<c> wVar, int i2, int i3) {
        c cVar = (c) wVar.get();
        e eVar = new e(cVar.b(), b.a(context).f7083a);
        w a2 = this.f7769b.a(context, eVar, i2, i3);
        if (!eVar.equals(a2)) {
            eVar.b();
        }
        Bitmap bitmap = (Bitmap) a2.get();
        cVar.f7758a.f7768a.a(this.f7769b, bitmap);
        return wVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f7769b.equals(((f) obj).f7769b);
    }

    public int hashCode() {
        return this.f7769b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        this.f7769b.a(messageDigest);
    }
}
