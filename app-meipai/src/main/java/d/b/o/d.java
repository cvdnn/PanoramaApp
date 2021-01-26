package d.b.o;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import d.b.o.a.C0026a;
import d.b.o.i.g;
import d.b.o.i.g.a;
import d.b.p.c;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class d extends a implements a {

    /* renamed from: c reason: collision with root package name */
    public Context f4100c;

    /* renamed from: d reason: collision with root package name */
    public ActionBarContextView f4101d;

    /* renamed from: e reason: collision with root package name */
    public C0026a f4102e;

    /* renamed from: f reason: collision with root package name */
    public WeakReference<View> f4103f;

    /* renamed from: g reason: collision with root package name */
    public boolean f4104g;

    /* renamed from: h reason: collision with root package name */
    public g f4105h;

    public d(Context context, ActionBarContextView actionBarContextView, C0026a aVar, boolean z) {
        this.f4100c = context;
        this.f4101d = actionBarContextView;
        this.f4102e = aVar;
        g gVar = new g(actionBarContextView.getContext());
        this.f4105h = gVar;
        gVar.f4202e = this;
    }

    public void a(CharSequence charSequence) {
        this.f4101d.setSubtitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f4101d.setTitle(charSequence);
    }

    public Menu c() {
        return this.f4105h;
    }

    public MenuInflater d() {
        return new f(this.f4101d.getContext());
    }

    public CharSequence e() {
        return this.f4101d.getSubtitle();
    }

    public CharSequence f() {
        return this.f4101d.getTitle();
    }

    public void g() {
        this.f4102e.b(this, this.f4105h);
    }

    public boolean h() {
        return this.f4101d.r;
    }

    public void a(int i2) {
        this.f4101d.setSubtitle(this.f4100c.getString(i2));
    }

    public void b(int i2) {
        this.f4101d.setTitle(this.f4100c.getString(i2));
    }

    public void a(View view) {
        this.f4101d.setCustomView(view);
        this.f4103f = view != null ? new WeakReference<>(view) : null;
    }

    public View b() {
        WeakReference<View> weakReference = this.f4103f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public void a() {
        if (!this.f4104g) {
            this.f4104g = true;
            this.f4101d.sendAccessibilityEvent(32);
            this.f4102e.a(this);
        }
    }

    public void a(boolean z) {
        this.f4095b = z;
        this.f4101d.setTitleOptional(z);
    }

    public boolean a(g gVar, MenuItem menuItem) {
        return this.f4102e.a((a) this, menuItem);
    }

    public void a(g gVar) {
        g();
        c cVar = this.f4101d.f4260d;
        if (cVar != null) {
            cVar.f();
        }
    }
}
