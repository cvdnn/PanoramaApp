package d.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.d;
import androidx.appcompat.widget.Toolbar.e;
import d.b.h;
import d.b.j;
import d.b.o.i.g;
import d.b.o.i.i;
import d.b.o.i.m;
import d.h.k.r;
import d.h.k.t;

/* compiled from: ToolbarWidgetWrapper */
public class z0 implements d0 {

    /* renamed from: a reason: collision with root package name */
    public Toolbar f4508a;

    /* renamed from: b reason: collision with root package name */
    public int f4509b;

    /* renamed from: c reason: collision with root package name */
    public View f4510c;

    /* renamed from: d reason: collision with root package name */
    public View f4511d;

    /* renamed from: e reason: collision with root package name */
    public Drawable f4512e;

    /* renamed from: f reason: collision with root package name */
    public Drawable f4513f;

    /* renamed from: g reason: collision with root package name */
    public Drawable f4514g;

    /* renamed from: h reason: collision with root package name */
    public boolean f4515h;

    /* renamed from: i reason: collision with root package name */
    public CharSequence f4516i;

    /* renamed from: j reason: collision with root package name */
    public CharSequence f4517j;
    public CharSequence k;
    public Callback l;
    public boolean m;
    public c n;
    public int o = 0;
    public int p = 0;
    public Drawable q;

    /* compiled from: ToolbarWidgetWrapper */
    public class a extends t {

        /* renamed from: a reason: collision with root package name */
        public boolean f4518a = false;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ int f4519b;

        public a(int i2) {
            this.f4519b = i2;
        }

        public void a(View view) {
            this.f4518a = true;
        }

        public void b(View view) {
            if (!this.f4518a) {
                z0.this.f4508a.setVisibility(this.f4519b);
            }
        }

        public void c(View view) {
            z0.this.f4508a.setVisibility(0);
        }
    }

    public z0(Toolbar toolbar, boolean z) {
        int i2;
        int i3 = h.abc_action_bar_up_description;
        this.f4508a = toolbar;
        this.f4516i = toolbar.getTitle();
        this.f4517j = toolbar.getSubtitle();
        this.f4515h = this.f4516i != null;
        this.f4514g = toolbar.getNavigationIcon();
        String str = null;
        x0 a2 = x0.a(toolbar.getContext(), null, j.ActionBar, d.b.a.actionBarStyle, 0);
        this.q = a2.b(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(j.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                this.f4515h = true;
                this.f4516i = e2;
                if ((this.f4509b & 8) != 0) {
                    this.f4508a.setTitle(e2);
                }
            }
            CharSequence e3 = a2.e(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                this.f4517j = e3;
                if ((this.f4509b & 8) != 0) {
                    this.f4508a.setSubtitle(e3);
                }
            }
            Drawable b2 = a2.b(j.ActionBar_logo);
            if (b2 != null) {
                this.f4513f = b2;
                p();
            }
            Drawable b3 = a2.b(j.ActionBar_icon);
            if (b3 != null) {
                this.f4512e = b3;
                p();
            }
            if (this.f4514g == null) {
                Drawable drawable = this.q;
                if (drawable != null) {
                    this.f4514g = drawable;
                    o();
                }
            }
            a(a2.d(j.ActionBar_displayOptions, 0));
            int f2 = a2.f(j.ActionBar_customNavigationLayout, 0);
            if (f2 != 0) {
                View inflate = LayoutInflater.from(this.f4508a.getContext()).inflate(f2, this.f4508a, false);
                View view = this.f4511d;
                if (!(view == null || (this.f4509b & 16) == 0)) {
                    this.f4508a.removeView(view);
                }
                this.f4511d = inflate;
                if (!(inflate == null || (this.f4509b & 16) == 0)) {
                    this.f4508a.addView(inflate);
                }
                a(this.f4509b | 16);
            }
            int e4 = a2.e(j.ActionBar_height, 0);
            if (e4 > 0) {
                LayoutParams layoutParams = this.f4508a.getLayoutParams();
                layoutParams.height = e4;
                this.f4508a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(j.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(j.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                Toolbar toolbar2 = this.f4508a;
                int max = Math.max(b4, 0);
                int max2 = Math.max(b5, 0);
                toolbar2.b();
                toolbar2.t.a(max, max2);
            }
            int f3 = a2.f(j.ActionBar_titleTextStyle, 0);
            if (f3 != 0) {
                Toolbar toolbar3 = this.f4508a;
                Context context = toolbar3.getContext();
                toolbar3.l = f3;
                TextView textView = toolbar3.f800b;
                if (textView != null) {
                    textView.setTextAppearance(context, f3);
                }
            }
            int f4 = a2.f(j.ActionBar_subtitleTextStyle, 0);
            if (f4 != 0) {
                Toolbar toolbar4 = this.f4508a;
                Context context2 = toolbar4.getContext();
                toolbar4.m = f4;
                TextView textView2 = toolbar4.f801c;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, f4);
                }
            }
            int f5 = a2.f(j.ActionBar_popupTheme, 0);
            if (f5 != 0) {
                this.f4508a.setPopupTheme(f5);
            }
        } else {
            if (this.f4508a.getNavigationIcon() != null) {
                i2 = 15;
                this.q = this.f4508a.getNavigationIcon();
            } else {
                i2 = 11;
            }
            this.f4509b = i2;
        }
        a2.f4485b.recycle();
        if (i3 != this.p) {
            this.p = i3;
            if (TextUtils.isEmpty(this.f4508a.getNavigationContentDescription())) {
                int i4 = this.p;
                if (i4 != 0) {
                    str = getContext().getString(i4);
                }
                this.k = str;
                n();
            }
        }
        this.k = this.f4508a.getNavigationContentDescription();
        this.f4508a.setNavigationOnClickListener(new y0(this));
    }

    public void a(boolean z) {
    }

    public boolean a() {
        return this.f4508a.f();
    }

    public void b(int i2) {
        this.f4513f = i2 != 0 ? d.b.l.a.a.b(getContext(), i2) : null;
        p();
    }

    public boolean c() {
        Toolbar toolbar = this.f4508a;
        if (toolbar.getVisibility() == 0) {
            ActionMenuView actionMenuView = toolbar.f799a;
            if (actionMenuView != null && actionMenuView.s) {
                return true;
            }
        }
        return false;
    }

    public void collapseActionView() {
        d dVar = this.f4508a.K;
        i iVar = dVar == null ? null : dVar.f813b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r4 = this;
            androidx.appcompat.widget.Toolbar r0 = r4.f4508a
            androidx.appcompat.widget.ActionMenuView r0 = r0.f799a
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            d.b.p.c r0 = r0.t
            if (r0 == 0) goto L_0x001e
            d.b.p.c$c r3 = r0.v
            if (r3 != 0) goto L_0x0019
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = r2
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            if (r0 == 0) goto L_0x001e
            r0 = r1
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            if (r0 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.z0.d():boolean");
    }

    public boolean e() {
        ActionMenuView actionMenuView = this.f4508a.f799a;
        if (actionMenuView != null) {
            c cVar = actionMenuView.t;
            if (cVar != null && cVar.c()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f4508a.g();
    }

    public void g() {
        ActionMenuView actionMenuView = this.f4508a.f799a;
        if (actionMenuView != null) {
            c cVar = actionMenuView.t;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public Context getContext() {
        return this.f4508a.getContext();
    }

    public CharSequence getTitle() {
        return this.f4508a.getTitle();
    }

    public boolean h() {
        d dVar = this.f4508a.K;
        return (dVar == null || dVar.f813b == null) ? false : true;
    }

    public int i() {
        return this.o;
    }

    public ViewGroup j() {
        return this.f4508a;
    }

    public int k() {
        return this.f4509b;
    }

    public void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void n() {
        if ((this.f4509b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f4508a.setNavigationContentDescription(this.p);
        } else {
            this.f4508a.setNavigationContentDescription(this.k);
        }
    }

    public final void o() {
        if ((this.f4509b & 4) != 0) {
            Toolbar toolbar = this.f4508a;
            Drawable drawable = this.f4514g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f4508a.setNavigationIcon((Drawable) null);
    }

    public final void p() {
        Drawable drawable;
        int i2 = this.f4509b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f4513f;
            if (drawable == null) {
                drawable = this.f4512e;
            }
        } else {
            drawable = this.f4512e;
        }
        this.f4508a.setLogo(drawable);
    }

    public void setIcon(int i2) {
        this.f4512e = i2 != 0 ? d.b.l.a.a.b(getContext(), i2) : null;
        p();
    }

    public void setWindowCallback(Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f4515h) {
            this.f4516i = charSequence;
            if ((this.f4509b & 8) != 0) {
                this.f4508a.setTitle(charSequence);
            }
        }
    }

    public void a(Menu menu, d.b.o.i.m.a aVar) {
        if (this.n == null) {
            this.n = new c(this.f4508a.getContext());
        }
        c cVar = this.n;
        cVar.f4155e = aVar;
        Toolbar toolbar = this.f4508a;
        g gVar = (g) menu;
        if (gVar != null || toolbar.f799a != null) {
            toolbar.d();
            g gVar2 = toolbar.f799a.p;
            if (gVar2 != gVar) {
                if (gVar2 != null) {
                    gVar2.a((m) toolbar.J);
                    gVar2.a((m) toolbar.K);
                }
                if (toolbar.K == null) {
                    toolbar.K = new d();
                }
                cVar.q = true;
                if (gVar != null) {
                    gVar.a((m) cVar, toolbar.f808j);
                    gVar.a((m) toolbar.K, toolbar.f808j);
                } else {
                    cVar.a(toolbar.f808j, (g) null);
                    d dVar = toolbar.K;
                    g gVar3 = dVar.f812a;
                    if (gVar3 != null) {
                        i iVar = dVar.f813b;
                        if (iVar != null) {
                            gVar3.a(iVar);
                        }
                    }
                    dVar.f812a = null;
                    cVar.a(true);
                    toolbar.K.a(true);
                }
                toolbar.f799a.setPopupTheme(toolbar.k);
                toolbar.f799a.setPresenter(cVar);
                toolbar.J = cVar;
            }
        }
    }

    public void b() {
        this.m = true;
    }

    public void c(int i2) {
        this.f4508a.setVisibility(i2);
    }

    public void setIcon(Drawable drawable) {
        this.f4512e = drawable;
        p();
    }

    public void b(boolean z) {
        this.f4508a.setCollapsible(z);
    }

    public void a(int i2) {
        int i3 = this.f4509b ^ i2;
        this.f4509b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    n();
                }
                o();
            }
            if ((i3 & 3) != 0) {
                p();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f4508a.setTitle(this.f4516i);
                    this.f4508a.setSubtitle(this.f4517j);
                } else {
                    this.f4508a.setTitle((CharSequence) null);
                    this.f4508a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0) {
                View view = this.f4511d;
                if (view == null) {
                    return;
                }
                if ((i2 & 16) != 0) {
                    this.f4508a.addView(view);
                } else {
                    this.f4508a.removeView(view);
                }
            }
        }
    }

    public void a(q0 q0Var) {
        View view = this.f4510c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f4508a;
            if (parent == toolbar) {
                toolbar.removeView(this.f4510c);
            }
        }
        this.f4510c = q0Var;
        if (q0Var != null && this.o == 2) {
            this.f4508a.addView(q0Var, 0);
            e eVar = (e) this.f4510c.getLayoutParams();
            eVar.width = -2;
            eVar.height = -2;
            eVar.f3986a = 8388691;
            q0Var.setAllowCollapse(true);
        }
    }

    public r a(int i2, long j2) {
        r a2 = d.h.k.m.a(this.f4508a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j2);
        a aVar = new a(i2);
        View view = (View) a2.f4940a.get();
        if (view != null) {
            a2.a(view, aVar);
        }
        return a2;
    }
}
