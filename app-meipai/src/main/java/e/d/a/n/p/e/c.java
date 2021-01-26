package e.d.a.n.p.e;

import android.graphics.drawable.Drawable;

/* compiled from: NonOwnedDrawableResource */
public final class c extends b<Drawable> {
    public c(Drawable drawable) {
        super(drawable);
    }

    public void b() {
    }

    public Class<Drawable> c() {
        return this.f7745a.getClass();
    }

    public int getSize() {
        return Math.max(1, this.f7745a.getIntrinsicHeight() * this.f7745a.getIntrinsicWidth() * 4);
    }
}
