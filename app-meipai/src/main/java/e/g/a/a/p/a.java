package e.g.a.a.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import e.c.f.n.n;
import e.g.a.a.b;
import e.g.a.a.e0.g;
import e.g.a.a.e0.j;

/* compiled from: MaterialButtonHelper */
public class a {

    /* renamed from: a reason: collision with root package name */
    public final MaterialButton f8285a;

    /* renamed from: b reason: collision with root package name */
    public j f8286b;

    /* renamed from: c reason: collision with root package name */
    public int f8287c;

    /* renamed from: d reason: collision with root package name */
    public int f8288d;

    /* renamed from: e reason: collision with root package name */
    public int f8289e;

    /* renamed from: f reason: collision with root package name */
    public int f8290f;

    /* renamed from: g reason: collision with root package name */
    public int f8291g;

    /* renamed from: h reason: collision with root package name */
    public int f8292h;

    /* renamed from: i reason: collision with root package name */
    public Mode f8293i;

    /* renamed from: j reason: collision with root package name */
    public ColorStateList f8294j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;

    public a(MaterialButton materialButton, j jVar) {
        this.f8285a = materialButton;
        this.f8286b = jVar;
    }

    public final g a(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(z ^ true ? 1 : 0);
    }

    public g b() {
        return a(false);
    }

    public final g c() {
        return a(true);
    }

    public final void d() {
        g b2 = b();
        g c2 = c();
        if (b2 != null) {
            b2.a((float) this.f8292h, this.k);
            if (c2 != null) {
                c2.a((float) this.f8292h, this.n ? n.a((View) this.f8285a, b.colorSurface) : 0);
            }
        }
    }

    public e.g.a.a.e0.n a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (e.g.a.a.e0.n) this.r.getDrawable(2);
        }
        return (e.g.a.a.e0.n) this.r.getDrawable(1);
    }

    public void a(j jVar) {
        this.f8286b = jVar;
        if (b() != null) {
            g b2 = b();
            b2.f8072a.f8083a = jVar;
            b2.invalidateSelf();
        }
        if (c() != null) {
            g c2 = c();
            c2.f8072a.f8083a = jVar;
            c2.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }
}
