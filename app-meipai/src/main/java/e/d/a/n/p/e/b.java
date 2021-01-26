package e.d.a.n.p.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import e.c.f.n.n;
import e.d.a.n.n.s;
import e.d.a.n.n.w;
import e.d.a.n.p.g.c;

/* compiled from: DrawableResource */
public abstract class b<T extends Drawable> implements w<T>, s {

    /* renamed from: a reason: collision with root package name */
    public final T f7745a;

    public b(T t) {
        n.a(t, "Argument must not be null");
        this.f7745a = t;
    }

    public void a() {
        T t = this.f7745a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).b().prepareToDraw();
        }
    }

    public Object get() {
        ConstantState constantState = this.f7745a.getConstantState();
        if (constantState == null) {
            return this.f7745a;
        }
        return constantState.newDrawable();
    }
}
