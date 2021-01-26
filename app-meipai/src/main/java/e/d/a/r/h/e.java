package e.d.a.r.h;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import e.d.a.r.i.b;

/* compiled from: ImageViewTarget */
public abstract class e<Z> extends i<ImageView, Z> {

    /* renamed from: d reason: collision with root package name */
    public Animatable f7885d;

    public e(ImageView imageView) {
        super(imageView);
    }

    public void a(Drawable drawable) {
        b((Z) null);
        ((ImageView) this.f7887a).setImageDrawable(drawable);
    }

    public abstract void a(Z z);

    public void b(Drawable drawable) {
        b((Z) null);
        ((ImageView) this.f7887a).setImageDrawable(drawable);
    }

    public void c(Drawable drawable) {
        this.f7888b.a();
        Animatable animatable = this.f7885d;
        if (animatable != null) {
            animatable.stop();
        }
        b((Z) null);
        ((ImageView) this.f7887a).setImageDrawable(drawable);
    }

    public void onStart() {
        Animatable animatable = this.f7885d;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void a(Z z, b<? super Z> bVar) {
        b(z);
    }

    public void b() {
        Animatable animatable = this.f7885d;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void b(Z z) {
        a(z);
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f7885d = animatable;
            animatable.start();
            return;
        }
        this.f7885d = null;
    }
}
