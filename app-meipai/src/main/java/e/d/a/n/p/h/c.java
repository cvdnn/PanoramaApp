package e.d.a.n.p.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import e.d.a.n.h;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.w;
import e.d.a.n.p.c.e;

/* compiled from: DrawableBytesTranscoder */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a reason: collision with root package name */
    public final d f7794a;

    /* renamed from: b reason: collision with root package name */
    public final e<Bitmap, byte[]> f7795b;

    /* renamed from: c reason: collision with root package name */
    public final e<e.d.a.n.p.g.c, byte[]> f7796c;

    public c(d dVar, e<Bitmap, byte[]> eVar, e<e.d.a.n.p.g.c, byte[]> eVar2) {
        this.f7794a = dVar;
        this.f7795b = eVar;
        this.f7796c = eVar2;
    }

    public w<byte[]> a(w<Drawable> wVar, h hVar) {
        Drawable drawable = (Drawable) wVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f7795b.a(e.a(((BitmapDrawable) drawable).getBitmap(), this.f7794a), hVar);
        }
        if (drawable instanceof e.d.a.n.p.g.c) {
            return this.f7796c.a(wVar, hVar);
        }
        return null;
    }
}
