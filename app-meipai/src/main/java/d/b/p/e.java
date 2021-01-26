package d.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import d.b.j;
import d.h.k.m;

/* compiled from: AppCompatBackgroundHelper */
public class e {

    /* renamed from: a reason: collision with root package name */
    public final View f4311a;

    /* renamed from: b reason: collision with root package name */
    public final j f4312b;

    /* renamed from: c reason: collision with root package name */
    public int f4313c = -1;

    /* renamed from: d reason: collision with root package name */
    public v0 f4314d;

    /* renamed from: e reason: collision with root package name */
    public v0 f4315e;

    /* renamed from: f reason: collision with root package name */
    public v0 f4316f;

    public e(View view) {
        this.f4311a = view;
        this.f4312b = j.a();
    }

    public void a(AttributeSet attributeSet, int i2) {
        x0 a2 = x0.a(this.f4311a.getContext(), attributeSet, j.ViewBackgroundHelper, i2, 0);
        try {
            if (a2.f(j.ViewBackgroundHelper_android_background)) {
                this.f4313c = a2.f(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f4312b.b(this.f4311a.getContext(), this.f4313c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.f(j.ViewBackgroundHelper_backgroundTint)) {
                m.a(this.f4311a, a2.a(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.f(j.ViewBackgroundHelper_backgroundTintMode)) {
                m.a(this.f4311a, e0.a(a2.d(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.f4485b.recycle();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.f4315e == null) {
            this.f4315e = new v0();
        }
        v0 v0Var = this.f4315e;
        v0Var.f4456a = colorStateList;
        v0Var.f4459d = true;
        a();
    }

    public Mode c() {
        v0 v0Var = this.f4315e;
        if (v0Var != null) {
            return v0Var.f4457b;
        }
        return null;
    }

    public void d() {
        this.f4313c = -1;
        a((ColorStateList) null);
        a();
    }

    public ColorStateList b() {
        v0 v0Var = this.f4315e;
        if (v0Var != null) {
            return v0Var.f4456a;
        }
        return null;
    }

    public void a(int i2) {
        this.f4313c = i2;
        j jVar = this.f4312b;
        a(jVar != null ? jVar.b(this.f4311a.getContext(), i2) : null);
        a();
    }

    public void a(Mode mode) {
        if (this.f4315e == null) {
            this.f4315e = new v0();
        }
        v0 v0Var = this.f4315e;
        v0Var.f4457b = mode;
        v0Var.f4458c = true;
        a();
    }

    public void a() {
        Drawable background = this.f4311a.getBackground();
        if (background != null) {
            boolean z = true;
            if (this.f4314d != null) {
                if (this.f4316f == null) {
                    this.f4316f = new v0();
                }
                v0 v0Var = this.f4316f;
                v0Var.f4456a = null;
                v0Var.f4459d = false;
                v0Var.f4457b = null;
                v0Var.f4458c = false;
                ColorStateList e2 = m.e(this.f4311a);
                if (e2 != null) {
                    v0Var.f4459d = true;
                    v0Var.f4456a = e2;
                }
                Mode backgroundTintMode = this.f4311a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    v0Var.f4458c = true;
                    v0Var.f4457b = backgroundTintMode;
                }
                if (v0Var.f4459d || v0Var.f4458c) {
                    j.a(background, v0Var, this.f4311a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            v0 v0Var2 = this.f4315e;
            if (v0Var2 != null) {
                j.a(background, v0Var2, this.f4311a.getDrawableState());
            } else {
                v0 v0Var3 = this.f4314d;
                if (v0Var3 != null) {
                    j.a(background, v0Var3, this.f4311a.getDrawableState());
                }
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f4314d == null) {
                this.f4314d = new v0();
            }
            v0 v0Var = this.f4314d;
            v0Var.f4456a = colorStateList;
            v0Var.f4459d = true;
        } else {
            this.f4314d = null;
        }
        a();
    }
}
