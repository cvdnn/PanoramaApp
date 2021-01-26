package e.d.a.n.p.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import e.c.f.n.n;
import e.d.a.n.n.s;
import e.d.a.n.n.w;

/* compiled from: LazyBitmapDrawableResource */
public final class u implements w<BitmapDrawable>, s {

    /* renamed from: a reason: collision with root package name */
    public final Resources f7723a;

    /* renamed from: b reason: collision with root package name */
    public final w<Bitmap> f7724b;

    public u(Resources resources, w<Bitmap> wVar) {
        String str = "Argument must not be null";
        n.a(resources, str);
        this.f7723a = resources;
        n.a(wVar, str);
        this.f7724b = wVar;
    }

    public static w<BitmapDrawable> a(Resources resources, w<Bitmap> wVar) {
        if (wVar == null) {
            return null;
        }
        return new u(resources, wVar);
    }

    public void b() {
        this.f7724b.b();
    }

    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public Object get() {
        return new BitmapDrawable(this.f7723a, (Bitmap) this.f7724b.get());
    }

    public int getSize() {
        return this.f7724b.getSize();
    }

    public void a() {
        w<Bitmap> wVar = this.f7724b;
        if (wVar instanceof s) {
            ((s) wVar).a();
        }
    }
}
