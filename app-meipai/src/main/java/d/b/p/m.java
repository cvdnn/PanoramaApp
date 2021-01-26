package d.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import d.b.j;
import d.b.l.a.a;

/* compiled from: AppCompatImageHelper */
public class m {

    /* renamed from: a reason: collision with root package name */
    public final ImageView f4397a;

    /* renamed from: b reason: collision with root package name */
    public v0 f4398b;

    public m(ImageView imageView) {
        this.f4397a = imageView;
    }

    public void a(AttributeSet attributeSet, int i2) {
        x0 a2 = x0.a(this.f4397a.getContext(), attributeSet, j.AppCompatImageView, i2, 0);
        try {
            Drawable drawable = this.f4397a.getDrawable();
            if (drawable == null) {
                int f2 = a2.f(j.AppCompatImageView_srcCompat, -1);
                if (f2 != -1) {
                    drawable = a.b(this.f4397a.getContext(), f2);
                    if (drawable != null) {
                        this.f4397a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            if (a2.f(j.AppCompatImageView_tint)) {
                this.f4397a.setImageTintList(a2.a(j.AppCompatImageView_tint));
            }
            if (a2.f(j.AppCompatImageView_tintMode)) {
                this.f4397a.setImageTintMode(e0.a(a2.d(j.AppCompatImageView_tintMode, -1), null));
            }
            a2.f4485b.recycle();
        } catch (Throwable th) {
            a2.f4485b.recycle();
            throw th;
        }
    }

    public void a(int i2) {
        if (i2 != 0) {
            Drawable b2 = a.b(this.f4397a.getContext(), i2);
            if (b2 != null) {
                e0.b(b2);
            }
            this.f4397a.setImageDrawable(b2);
        } else {
            this.f4397a.setImageDrawable(null);
        }
        a();
    }

    public void a(ColorStateList colorStateList) {
        if (this.f4398b == null) {
            this.f4398b = new v0();
        }
        v0 v0Var = this.f4398b;
        v0Var.f4456a = colorStateList;
        v0Var.f4459d = true;
        a();
    }

    public void a(Mode mode) {
        if (this.f4398b == null) {
            this.f4398b = new v0();
        }
        v0 v0Var = this.f4398b;
        v0Var.f4457b = mode;
        v0Var.f4458c = true;
        a();
    }

    public void a() {
        Drawable drawable = this.f4397a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            v0 v0Var = this.f4398b;
            if (v0Var != null) {
                j.a(drawable, v0Var, this.f4397a.getDrawableState());
            }
        }
    }
}
