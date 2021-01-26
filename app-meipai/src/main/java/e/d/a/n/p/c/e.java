package e.d.a.n.p.c;

import android.graphics.Bitmap;
import e.c.f.n.n;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.s;
import e.d.a.n.n.w;
import e.d.a.t.j;

/* compiled from: BitmapResource */
public class e implements w<Bitmap>, s {

    /* renamed from: a reason: collision with root package name */
    public final Bitmap f7674a;

    /* renamed from: b reason: collision with root package name */
    public final d f7675b;

    public e(Bitmap bitmap, d dVar) {
        n.a(bitmap, "Bitmap must not be null");
        this.f7674a = bitmap;
        n.a(dVar, "BitmapPool must not be null");
        this.f7675b = dVar;
    }

    public static e a(Bitmap bitmap, d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, dVar);
    }

    public void b() {
        this.f7675b.a(this.f7674a);
    }

    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    public Object get() {
        return this.f7674a;
    }

    public int getSize() {
        return j.a(this.f7674a);
    }

    public void a() {
        this.f7674a.prepareToDraw();
    }
}
