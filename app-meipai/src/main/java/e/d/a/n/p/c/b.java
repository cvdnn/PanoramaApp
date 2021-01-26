package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import e.d.a.n.c;
import e.d.a.n.h;
import e.d.a.n.k;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.w;
import java.io.File;

/* compiled from: BitmapDrawableEncoder */
public class b implements k<BitmapDrawable> {

    /* renamed from: a reason: collision with root package name */
    public final d f7659a;

    /* renamed from: b reason: collision with root package name */
    public final k<Bitmap> f7660b;

    public b(d dVar, k<Bitmap> kVar) {
        this.f7659a = dVar;
        this.f7660b = kVar;
    }

    public boolean a(Object obj, File file, h hVar) {
        return this.f7660b.a(new e(((BitmapDrawable) ((w) obj).get()).getBitmap(), this.f7659a), file, hVar);
    }

    public c a(h hVar) {
        return this.f7660b.a(hVar);
    }
}
