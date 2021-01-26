package e.d.a.n.p.h;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import e.c.f.n.n;
import e.d.a.n.h;
import e.d.a.n.n.w;
import e.d.a.n.p.c.u;

/* compiled from: BitmapDrawableTranscoder */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    public final Resources f7793a;

    public b(Resources resources) {
        n.a(resources, "Argument must not be null");
        this.f7793a = resources;
    }

    public w<BitmapDrawable> a(w<Bitmap> wVar, h hVar) {
        return u.a(this.f7793a, wVar);
    }
}
