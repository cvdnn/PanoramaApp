package d.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import d.b.j;
import d.b.o.a.C0026a;
import d.b.o.f;
import d.b.o.g;
import d.b.p.d0;
import d.b.p.q0;
import d.h.k.m;
import d.h.k.r;
import d.h.k.s;
import d.h.k.t;
import d.h.k.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class o extends a implements androidx.appcompat.widget.ActionBarOverlayLayout.d {
    public static final Interpolator C = new AccelerateInterpolator();
    public static final Interpolator D = new DecelerateInterpolator();
    public final s A = new b();
    public final u B = new c();

    /* renamed from: a reason: collision with root package name */
    public Context f4043a;

    /* renamed from: b reason: collision with root package name */
    public Context f4044b;

    /* renamed from: c reason: collision with root package name */
    public Activity f4045c;

    /* renamed from: d reason: collision with root package name */
    public Dialog f4046d;

    /* renamed from: e reason: collision with root package name */
    public ActionBarOverlayLayout f4047e;

    /* renamed from: f reason: collision with root package name */
    public ActionBarContainer f4048f;

    /* renamed from: g reason: collision with root package name */
    public d0 f4049g;

    /* renamed from: h reason: collision with root package name */
    public ActionBarContextView f4050h;

    /* renamed from: i reason: collision with root package name */
    public View f4051i;

    /* renamed from: j reason: collision with root package name */
    public boolean f4052j;
    public d k;
    public d.b.o.a l;
    public C0026a m;
    public boolean n;
    public ArrayList<d.b.k.a.b> o = new ArrayList<>();
    public boolean p;
    public int q = 0;
    public boolean r = true;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v = true;
    public g w;
    public boolean x;
    public boolean y;
    public final s z = new a();

    /* compiled from: WindowDecorActionBar */
    public class a extends t {
        public a() {
        }

        public void b(View view) {
            o oVar = o.this;
            if (oVar.r) {
                View view2 = oVar.f4051i;
                if (view2 != null) {
                    view2.setTranslationY(0.0f);
                    o.this.f4048f.setTranslationY(0.0f);
                }
            }
            o.this.f4048f.setVisibility(8);
            o.this.f4048f.setTransitioning(false);
            o oVar2 = o.this;
            oVar2.w = null;
            C0026a aVar = oVar2.m;
            if (aVar != null) {
                aVar.a(oVar2.l);
                oVar2.l = null;
                oVar2.m = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = o.this.f4047e;
            if (actionBarOverlayLayout != null) {
                m.E(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class b extends t {
        public b() {
        }

        public void b(View view) {
            o oVar = o.this;
            oVar.w = null;
            oVar.f4048f.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class c implements u {
        public c() {
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class d extends d.b.o.a implements d.b.o.i.g.a {

        /* renamed from: c reason: collision with root package name */
        public final Context f4056c;

        /* renamed from: d reason: collision with root package name */
        public final d.b.o.i.g f4057d;

        /* renamed from: e reason: collision with root package name */
        public C0026a f4058e;

        /* renamed from: f reason: collision with root package name */
        public WeakReference<View> f4059f;

        public d(Context context, C0026a aVar) {
            this.f4056c = context;
            this.f4058e = aVar;
            d.b.o.i.g gVar = new d.b.o.i.g(context);
            this.f4057d = gVar;
            gVar.f4202e = this;
        }

        public void a(boolean z) {
            this.f4095b = z;
            o.this.f4050h.setTitleOptional(z);
        }

        public void b(CharSequence charSequence) {
            o.this.f4050h.setTitle(charSequence);
        }

        public Menu c() {
            return this.f4057d;
        }

        public MenuInflater d() {
            return new f(this.f4056c);
        }

        public CharSequence e() {
            return o.this.f4050h.getSubtitle();
        }

        public CharSequence f() {
            return o.this.f4050h.getTitle();
        }

        public void g() {
            if (o.this.k == this) {
                this.f4057d.j();
                try {
                    this.f4058e.b(this, this.f4057d);
                } finally {
                    this.f4057d.i();
                }
            }
        }

        public boolean h() {
            return o.this.f4050h.r;
        }

        public void b(int i2) {
            o.this.f4050h.setTitle(o.this.f4043a.getResources().getString(i2));
        }

        public void a() {
            o oVar = o.this;
            if (oVar.k == this) {
                boolean z = oVar.s;
                boolean z2 = oVar.t;
                boolean z3 = true;
                if (z || z2) {
                    z3 = false;
                }
                if (!z3) {
                    o oVar2 = o.this;
                    oVar2.l = this;
                    oVar2.m = this.f4058e;
                } else {
                    this.f4058e.a(this);
                }
                this.f4058e = null;
                o.this.d(false);
                ActionBarContextView actionBarContextView = o.this.f4050h;
                if (actionBarContextView.k == null) {
                    actionBarContextView.b();
                }
                o.this.f4049g.j().sendAccessibilityEvent(32);
                o oVar3 = o.this;
                oVar3.f4047e.setHideOnContentScrollEnabled(oVar3.y);
                o.this.k = null;
            }
        }

        public View b() {
            WeakReference<View> weakReference = this.f4059f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public void a(View view) {
            o.this.f4050h.setCustomView(view);
            this.f4059f = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            o.this.f4050h.setSubtitle(charSequence);
        }

        public void a(int i2) {
            o.this.f4050h.setSubtitle(o.this.f4043a.getResources().getString(i2));
        }

        public boolean a(d.b.o.i.g gVar, MenuItem menuItem) {
            C0026a aVar = this.f4058e;
            if (aVar != null) {
                return aVar.a((d.b.o.a) this, menuItem);
            }
            return false;
        }

        public void a(d.b.o.i.g gVar) {
            if (this.f4058e != null) {
                g();
                d.b.p.c cVar = o.this.f4050h.f4260d;
                if (cVar != null) {
                    cVar.f();
                }
            }
        }
    }

    public o(Activity activity, boolean z2) {
        new ArrayList();
        this.f4045c = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f4051i = decorView.findViewById(16908290);
        }
    }

    public final void a(View view) {
        d0 d0Var;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(d.b.f.decor_content_parent);
        this.f4047e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(d.b.f.action_bar);
        if (findViewById instanceof d0) {
            d0Var = (d0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            d0Var = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Can't make a decor toolbar out of ");
            a2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(a2.toString());
        }
        this.f4049g = d0Var;
        this.f4050h = (ActionBarContextView) view.findViewById(d.b.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(d.b.f.action_bar_container);
        this.f4048f = actionBarContainer;
        d0 d0Var2 = this.f4049g;
        if (d0Var2 == null || this.f4050h == null || actionBarContainer == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(o.class.getSimpleName());
            sb.append(" can only be used with a compatible window decor layout");
            throw new IllegalStateException(sb.toString());
        }
        this.f4043a = d0Var2.getContext();
        boolean z2 = (this.f4049g.k() & 4) != 0;
        if (z2) {
            this.f4052j = true;
        }
        Context context = this.f4043a;
        this.f4049g.a((context.getApplicationInfo().targetSdkVersion < 14) || z2);
        e(context.getResources().getBoolean(d.b.b.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f4043a.obtainStyledAttributes(null, j.ActionBar, d.b.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4047e;
            if (actionBarOverlayLayout2.f747h) {
                this.y = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m.a((View) this.f4048f, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public int b() {
        return this.f4049g.k();
    }

    public void c(boolean z2) {
        this.x = z2;
        if (!z2) {
            g gVar = this.w;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    public void d(boolean z2) {
        r rVar;
        r rVar2;
        if (z2) {
            if (!this.u) {
                this.u = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4047e;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (this.u) {
            this.u = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4047e;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        if (m.z(this.f4048f)) {
            if (z2) {
                rVar = this.f4049g.a(4, 100);
                rVar2 = this.f4050h.a(0, 200);
            } else {
                rVar2 = this.f4049g.a(0, 200);
                rVar = this.f4050h.a(8, 100);
            }
            g gVar = new g();
            gVar.f4131a.add(rVar);
            View view = (View) rVar.f4940a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = (View) rVar2.f4940a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.f4131a.add(rVar2);
            gVar.b();
        } else if (z2) {
            this.f4049g.c(4);
            this.f4050h.setVisibility(0);
        } else {
            this.f4049g.c(0);
            this.f4050h.setVisibility(8);
        }
    }

    public final void e(boolean z2) {
        this.p = z2;
        if (!z2) {
            this.f4049g.a((q0) null);
            this.f4048f.setTabContainer(null);
        } else {
            this.f4048f.setTabContainer(null);
            this.f4049g.a((q0) null);
        }
        boolean z3 = true;
        boolean z4 = this.f4049g.i() == 2;
        this.f4049g.b(!this.p && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4047e;
        if (this.p || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    public final void f(boolean z2) {
        if (this.u || !this.t) {
            if (!this.v) {
                this.v = true;
                g gVar = this.w;
                if (gVar != null) {
                    gVar.a();
                }
                this.f4048f.setVisibility(0);
                if (this.q != 0 || (!this.x && !z2)) {
                    this.f4048f.setAlpha(1.0f);
                    this.f4048f.setTranslationY(0.0f);
                    if (this.r) {
                        View view = this.f4051i;
                        if (view != null) {
                            view.setTranslationY(0.0f);
                        }
                    }
                    this.A.b(null);
                } else {
                    this.f4048f.setTranslationY(0.0f);
                    float f2 = (float) (-this.f4048f.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.f4048f.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f4048f.setTranslationY(f2);
                    g gVar2 = new g();
                    r a2 = m.a(this.f4048f);
                    a2.b(0.0f);
                    a2.a(this.B);
                    if (!gVar2.f4135e) {
                        gVar2.f4131a.add(a2);
                    }
                    if (this.r) {
                        View view2 = this.f4051i;
                        if (view2 != null) {
                            view2.setTranslationY(f2);
                            r a3 = m.a(this.f4051i);
                            a3.b(0.0f);
                            if (!gVar2.f4135e) {
                                gVar2.f4131a.add(a3);
                            }
                        }
                    }
                    Interpolator interpolator = D;
                    if (!gVar2.f4135e) {
                        gVar2.f4133c = interpolator;
                    }
                    if (!gVar2.f4135e) {
                        gVar2.f4132b = 250;
                    }
                    s sVar = this.A;
                    if (!gVar2.f4135e) {
                        gVar2.f4134d = sVar;
                    }
                    this.w = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4047e;
                if (actionBarOverlayLayout != null) {
                    m.E(actionBarOverlayLayout);
                }
            }
        } else if (this.v) {
            this.v = false;
            g gVar3 = this.w;
            if (gVar3 != null) {
                gVar3.a();
            }
            if (this.q != 0 || (!this.x && !z2)) {
                this.z.b(null);
                return;
            }
            this.f4048f.setAlpha(1.0f);
            this.f4048f.setTransitioning(true);
            g gVar4 = new g();
            float f3 = (float) (-this.f4048f.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f4048f.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            r a4 = m.a(this.f4048f);
            a4.b(f3);
            a4.a(this.B);
            if (!gVar4.f4135e) {
                gVar4.f4131a.add(a4);
            }
            if (this.r) {
                View view3 = this.f4051i;
                if (view3 != null) {
                    r a5 = m.a(view3);
                    a5.b(f3);
                    if (!gVar4.f4135e) {
                        gVar4.f4131a.add(a5);
                    }
                }
            }
            Interpolator interpolator2 = C;
            if (!gVar4.f4135e) {
                gVar4.f4133c = interpolator2;
            }
            if (!gVar4.f4135e) {
                gVar4.f4132b = 250;
            }
            s sVar2 = this.z;
            if (!gVar4.f4135e) {
                gVar4.f4134d = sVar2;
            }
            this.w = gVar4;
            gVar4.b();
        }
    }

    public void b(boolean z2) {
        if (!this.f4052j) {
            int i2 = z2 ? 4 : 0;
            int k2 = this.f4049g.k();
            this.f4052j = true;
            this.f4049g.a((i2 & 4) | (k2 & -5));
        }
    }

    public Context c() {
        if (this.f4044b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4043a.getTheme().resolveAttribute(d.b.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f4044b = new ContextThemeWrapper(this.f4043a, i2);
            } else {
                this.f4044b = this.f4043a;
            }
        }
        return this.f4044b;
    }

    public o(Dialog dialog) {
        new ArrayList();
        this.f4046d = dialog;
        a(dialog.getWindow().getDecorView());
    }

    public void a(Configuration configuration) {
        e(this.f4043a.getResources().getBoolean(d.b.b.abc_action_bar_embed_tabs));
    }

    public void a(boolean z2) {
        if (z2 != this.n) {
            this.n = z2;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((d.b.k.a.b) this.o.get(i2)).a(z2);
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.f4049g.setWindowTitle(charSequence);
    }

    public d.b.o.a a(C0026a aVar) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.a();
        }
        this.f4047e.setHideOnContentScrollEnabled(false);
        this.f4050h.b();
        d dVar2 = new d(this.f4050h.getContext(), aVar);
        dVar2.f4057d.j();
        try {
            if (!dVar2.f4058e.a((d.b.o.a) dVar2, (Menu) dVar2.f4057d)) {
                return null;
            }
            this.k = dVar2;
            dVar2.g();
            this.f4050h.a(dVar2);
            d(true);
            this.f4050h.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.f4057d.i();
        }
    }

    public boolean a() {
        d0 d0Var = this.f4049g;
        if (d0Var == null || !d0Var.h()) {
            return false;
        }
        this.f4049g.collapseActionView();
        return true;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        d dVar = this.k;
        if (dVar == null) {
            return false;
        }
        d.b.o.i.g gVar = dVar.f4057d;
        if (gVar == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        gVar.setQwertyMode(z2);
        return gVar.performShortcut(i2, keyEvent, 0);
    }
}
