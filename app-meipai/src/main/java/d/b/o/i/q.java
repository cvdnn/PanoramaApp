package d.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import d.b.d;
import d.b.g;
import d.b.p.f0;
import d.b.p.m0;

/* compiled from: StandardMenuPopup */
public final class q extends k implements OnDismissListener, OnItemClickListener, m, OnKeyListener {
    public static final int v = g.abc_popup_menu_item_layout;

    /* renamed from: b reason: collision with root package name */
    public final Context f4245b;

    /* renamed from: c reason: collision with root package name */
    public final g f4246c;

    /* renamed from: d reason: collision with root package name */
    public final f f4247d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f4248e;

    /* renamed from: f reason: collision with root package name */
    public final int f4249f;

    /* renamed from: g reason: collision with root package name */
    public final int f4250g;

    /* renamed from: h reason: collision with root package name */
    public final int f4251h;

    /* renamed from: i reason: collision with root package name */
    public final m0 f4252i;

    /* renamed from: j reason: collision with root package name */
    public final OnGlobalLayoutListener f4253j = new a();
    public final OnAttachStateChangeListener k = new b();
    public OnDismissListener l;
    public View m;
    public View n;
    public d.b.o.i.m.a o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int s;
    public int t = 0;
    public boolean u;

    /* compiled from: StandardMenuPopup */
    public class a implements OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (q.this.a()) {
                q qVar = q.this;
                if (!qVar.f4252i.A) {
                    View view = qVar.n;
                    if (view == null || !view.isShown()) {
                        q.this.dismiss();
                    } else {
                        q.this.f4252i.d();
                    }
                }
            }
        }
    }

    /* compiled from: StandardMenuPopup */
    public class b implements OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.p = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.p.removeGlobalOnLayoutListener(qVar.f4253j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f4245b = context;
        this.f4246c = gVar;
        this.f4248e = z;
        this.f4247d = new f(gVar, LayoutInflater.from(context), this.f4248e, v);
        this.f4250g = i2;
        this.f4251h = i3;
        Resources resources = context.getResources();
        this.f4249f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.m = view;
        this.f4252i = new m0(this.f4245b, null, this.f4250g, this.f4251h);
        gVar.a((m) this, context);
    }

    public void a(int i2) {
        this.t = i2;
    }

    public void a(g gVar) {
    }

    public void b(boolean z) {
        this.f4247d.f4194c = z;
    }

    public boolean b() {
        return false;
    }

    public void c(int i2) {
        m0 m0Var = this.f4252i;
        m0Var.f4386g = i2;
        m0Var.f4388i = true;
    }

    public void d() {
        boolean z = true;
        if (!a()) {
            if (!this.q) {
                View view = this.m;
                if (view != null) {
                    this.n = view;
                    this.f4252i.B.setOnDismissListener(this);
                    m0 m0Var = this.f4252i;
                    m0Var.s = this;
                    m0Var.a(true);
                    View view2 = this.n;
                    boolean z2 = this.p == null;
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    this.p = viewTreeObserver;
                    if (z2) {
                        viewTreeObserver.addOnGlobalLayoutListener(this.f4253j);
                    }
                    view2.addOnAttachStateChangeListener(this.k);
                    m0 m0Var2 = this.f4252i;
                    m0Var2.r = view2;
                    m0Var2.l = this.t;
                    if (!this.r) {
                        this.s = k.a(this.f4247d, null, this.f4245b, this.f4249f);
                        this.r = true;
                    }
                    this.f4252i.d(this.s);
                    this.f4252i.B.setInputMethodMode(2);
                    m0 m0Var3 = this.f4252i;
                    Rect rect = this.f4232a;
                    if (m0Var3 != null) {
                        m0Var3.z = rect != null ? new Rect(rect) : null;
                        this.f4252i.d();
                        f0 f0Var = this.f4252i.f4382c;
                        f0Var.setOnKeyListener(this);
                        if (this.u && this.f4246c.m != null) {
                            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f4245b).inflate(g.abc_popup_menu_header_item_layout, f0Var, false);
                            TextView textView = (TextView) frameLayout.findViewById(16908310);
                            if (textView != null) {
                                textView.setText(this.f4246c.m);
                            }
                            frameLayout.setEnabled(false);
                            f0Var.addHeaderView(frameLayout, null, false);
                        }
                        this.f4252i.a((ListAdapter) this.f4247d);
                        this.f4252i.d();
                    } else {
                        throw null;
                    }
                }
            }
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void dismiss() {
        if (a()) {
            this.f4252i.dismiss();
        }
    }

    public ListView f() {
        return this.f4252i.f4382c;
    }

    public void onDismiss() {
        this.q = true;
        this.f4246c.a(true);
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.f4253j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean a() {
        return !this.q && this.f4252i.a();
    }

    public void a(boolean z) {
        this.r = false;
        f fVar = this.f4247d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void b(int i2) {
        this.f4252i.f4385f = i2;
    }

    public void c(boolean z) {
        this.u = z;
    }

    public void a(d.b.o.i.m.a aVar) {
        this.o = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(d.b.o.i.r r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            d.b.o.i.l r0 = new d.b.o.i.l
            android.content.Context r3 = r9.f4245b
            android.view.View r5 = r9.n
            boolean r6 = r9.f4248e
            int r7 = r9.f4250g
            int r8 = r9.f4251h
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            d.b.o.i.m$a r2 = r9.o
            r0.a(r2)
            boolean r2 = d.b.o.i.k.b(r10)
            r0.f4240h = r2
            d.b.o.i.k r3 = r0.f4242j
            if (r3 == 0) goto L_0x002a
            r3.b(r2)
        L_0x002a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.l
            r0.k = r2
            r2 = 0
            r9.l = r2
            d.b.o.i.g r2 = r9.f4246c
            r2.a(r1)
            d.b.p.m0 r2 = r9.f4252i
            int r3 = r2.f4385f
            boolean r4 = r2.f4388i
            if (r4 != 0) goto L_0x0040
            r2 = r1
            goto L_0x0042
        L_0x0040:
            int r2 = r2.f4386g
        L_0x0042:
            int r4 = r9.t
            android.view.View r5 = r9.m
            int r5 = d.h.k.m.m(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x005a
            android.view.View r4 = r9.m
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L_0x005a:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L_0x0062
            goto L_0x006b
        L_0x0062:
            android.view.View r4 = r0.f4238f
            if (r4 != 0) goto L_0x0068
            r0 = r1
            goto L_0x006c
        L_0x0068:
            r0.a(r3, r2, r5, r5)
        L_0x006b:
            r0 = r5
        L_0x006c:
            if (r0 == 0) goto L_0x0076
            d.b.o.i.m$a r0 = r9.o
            if (r0 == 0) goto L_0x0075
            r0.a(r10)
        L_0x0075:
            return r5
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.o.i.q.a(d.b.o.i.r):boolean");
    }

    public void a(g gVar, boolean z) {
        if (gVar == this.f4246c) {
            dismiss();
            d.b.o.i.m.a aVar = this.o;
            if (aVar != null) {
                aVar.a(gVar, z);
            }
        }
    }

    public void a(View view) {
        this.m = view;
    }

    public void a(OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }
}
