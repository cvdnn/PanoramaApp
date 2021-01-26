package d.b.o.i;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import d.b.g;
import d.b.p.l0;
import d.b.p.m0;
import d.h.k.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
public final class d extends k implements m, OnKeyListener, OnDismissListener {
    public static final int B = g.abc_cascading_menu_item_layout;
    public boolean A;

    /* renamed from: b reason: collision with root package name */
    public final Context f4162b;

    /* renamed from: c reason: collision with root package name */
    public final int f4163c;

    /* renamed from: d reason: collision with root package name */
    public final int f4164d;

    /* renamed from: e reason: collision with root package name */
    public final int f4165e;

    /* renamed from: f reason: collision with root package name */
    public final boolean f4166f;

    /* renamed from: g reason: collision with root package name */
    public final Handler f4167g;

    /* renamed from: h reason: collision with root package name */
    public final List<g> f4168h = new ArrayList();

    /* renamed from: i reason: collision with root package name */
    public final List<C0027d> f4169i = new ArrayList();

    /* renamed from: j reason: collision with root package name */
    public final OnGlobalLayoutListener f4170j = new a();
    public final OnAttachStateChangeListener k = new b();
    public final l0 l = new c();
    public int m;
    public int n;
    public View o;
    public View p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public d.b.o.i.m.a x;
    public ViewTreeObserver y;
    public OnDismissListener z;

    /* compiled from: CascadingMenuPopup */
    public class a implements OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (d.this.a() && d.this.f4169i.size() > 0 && !((C0027d) d.this.f4169i.get(0)).f4178a.A) {
                View view = d.this.p;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0027d dVar : d.this.f4169i) {
                    dVar.f4178a.d();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    public class b implements OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.y.removeGlobalOnLayoutListener(dVar.f4170j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup */
    public class c implements l0 {

        /* compiled from: CascadingMenuPopup */
        public class a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ C0027d f4174a;

            /* renamed from: b reason: collision with root package name */
            public final /* synthetic */ MenuItem f4175b;

            /* renamed from: c reason: collision with root package name */
            public final /* synthetic */ g f4176c;

            public a(C0027d dVar, MenuItem menuItem, g gVar) {
                this.f4174a = dVar;
                this.f4175b = menuItem;
                this.f4176c = gVar;
            }

            public void run() {
                C0027d dVar = this.f4174a;
                if (dVar != null) {
                    d.this.A = true;
                    dVar.f4179b.a(false);
                    d.this.A = false;
                }
                if (this.f4175b.isEnabled() && this.f4175b.hasSubMenu()) {
                    this.f4176c.a(this.f4175b, 4);
                }
            }
        }

        public c() {
        }

        public void a(g gVar, MenuItem menuItem) {
            C0027d dVar = null;
            d.this.f4167g.removeCallbacksAndMessages(null);
            int size = d.this.f4169i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == ((C0027d) d.this.f4169i.get(i2)).f4179b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f4169i.size()) {
                    dVar = (C0027d) d.this.f4169i.get(i3);
                }
                d.this.f4167g.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void b(g gVar, MenuItem menuItem) {
            d.this.f4167g.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: d.b.o.i.d$d reason: collision with other inner class name */
    /* compiled from: CascadingMenuPopup */
    public static class C0027d {

        /* renamed from: a reason: collision with root package name */
        public final m0 f4178a;

        /* renamed from: b reason: collision with root package name */
        public final g f4179b;

        /* renamed from: c reason: collision with root package name */
        public final int f4180c;

        public C0027d(m0 m0Var, g gVar, int i2) {
            this.f4178a = m0Var;
            this.f4179b = gVar;
            this.f4180c = i2;
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        int i4 = 0;
        this.m = 0;
        this.n = 0;
        this.f4162b = context;
        this.o = view;
        this.f4164d = i2;
        this.f4165e = i3;
        this.f4166f = z2;
        this.v = false;
        if (m.m(view) != 1) {
            i4 = 1;
        }
        this.q = i4;
        Resources resources = context.getResources();
        this.f4163c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.b.d.abc_config_prefDialogWidth));
        this.f4167g = new Handler();
    }

    public void a(g gVar) {
        gVar.a((m) this, this.f4162b);
        if (a()) {
            c(gVar);
        } else {
            this.f4168h.add(gVar);
        }
    }

    public void b(boolean z2) {
        this.v = z2;
    }

    public boolean b() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0143, code lost:
        if (((r9.getWidth() + r11[0]) + r4) > r10.right) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0149, code lost:
        if ((r11[0] - r4) < 0) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014d, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(d.b.o.i.g r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.content.Context r2 = r0.f4162b
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            d.b.o.i.f r3 = new d.b.o.i.f
            boolean r4 = r0.f4166f
            int r5 = B
            r3.<init>(r1, r2, r4, r5)
            boolean r4 = r16.a()
            r5 = 1
            if (r4 != 0) goto L_0x0021
            boolean r4 = r0.v
            if (r4 == 0) goto L_0x0021
            r3.f4194c = r5
            goto L_0x002d
        L_0x0021:
            boolean r4 = r16.a()
            if (r4 == 0) goto L_0x002d
            boolean r4 = d.b.o.i.k.b(r17)
            r3.f4194c = r4
        L_0x002d:
            android.content.Context r4 = r0.f4162b
            int r6 = r0.f4163c
            r7 = 0
            int r4 = d.b.o.i.k.a(r3, r7, r4, r6)
            d.b.p.m0 r6 = new d.b.p.m0
            android.content.Context r8 = r0.f4162b
            int r9 = r0.f4164d
            int r10 = r0.f4165e
            r6.<init>(r8, r7, r9, r10)
            d.b.p.l0 r8 = r0.l
            r6.F = r8
            r6.s = r0
            android.widget.PopupWindow r8 = r6.B
            r8.setOnDismissListener(r0)
            android.view.View r8 = r0.o
            r6.r = r8
            int r8 = r0.n
            r6.l = r8
            r6.a(r5)
            android.widget.PopupWindow r8 = r6.B
            r9 = 2
            r8.setInputMethodMode(r9)
            r6.a(r3)
            r6.d(r4)
            int r3 = r0.n
            r6.l = r3
            java.util.List<d.b.o.i.d$d> r3 = r0.f4169i
            int r3 = r3.size()
            r8 = 0
            if (r3 <= 0) goto L_0x00e5
            java.util.List<d.b.o.i.d$d> r3 = r0.f4169i
            int r10 = r3.size()
            int r10 = r10 - r5
            java.lang.Object r3 = r3.get(r10)
            d.b.o.i.d$d r3 = (d.b.o.i.d.C0027d) r3
            d.b.o.i.g r10 = r3.f4179b
            int r11 = r10.size()
            r12 = r8
        L_0x0084:
            if (r12 >= r11) goto L_0x009a
            android.view.MenuItem r13 = r10.getItem(r12)
            boolean r14 = r13.hasSubMenu()
            if (r14 == 0) goto L_0x0097
            android.view.SubMenu r14 = r13.getSubMenu()
            if (r1 != r14) goto L_0x0097
            goto L_0x009b
        L_0x0097:
            int r12 = r12 + 1
            goto L_0x0084
        L_0x009a:
            r13 = r7
        L_0x009b:
            if (r13 != 0) goto L_0x009e
            goto L_0x00e7
        L_0x009e:
            d.b.p.m0 r10 = r3.f4178a
            d.b.p.f0 r10 = r10.f4382c
            android.widget.ListAdapter r11 = r10.getAdapter()
            boolean r12 = r11 instanceof android.widget.HeaderViewListAdapter
            if (r12 == 0) goto L_0x00b7
            android.widget.HeaderViewListAdapter r11 = (android.widget.HeaderViewListAdapter) r11
            int r12 = r11.getHeadersCount()
            android.widget.ListAdapter r11 = r11.getWrappedAdapter()
            d.b.o.i.f r11 = (d.b.o.i.f) r11
            goto L_0x00ba
        L_0x00b7:
            d.b.o.i.f r11 = (d.b.o.i.f) r11
            r12 = r8
        L_0x00ba:
            int r14 = r11.getCount()
            r15 = r8
        L_0x00bf:
            r9 = -1
            if (r15 >= r14) goto L_0x00cd
            d.b.o.i.i r7 = r11.getItem(r15)
            if (r13 != r7) goto L_0x00c9
            goto L_0x00ce
        L_0x00c9:
            int r15 = r15 + 1
            r7 = 0
            goto L_0x00bf
        L_0x00cd:
            r15 = r9
        L_0x00ce:
            if (r15 != r9) goto L_0x00d1
            goto L_0x00e6
        L_0x00d1:
            int r15 = r15 + r12
            int r7 = r10.getFirstVisiblePosition()
            int r15 = r15 - r7
            if (r15 < 0) goto L_0x00e6
            int r7 = r10.getChildCount()
            if (r15 < r7) goto L_0x00e0
            goto L_0x00e6
        L_0x00e0:
            android.view.View r7 = r10.getChildAt(r15)
            goto L_0x00e7
        L_0x00e5:
            r3 = 0
        L_0x00e6:
            r7 = 0
        L_0x00e7:
            if (r7 == 0) goto L_0x01b2
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r9 > r10) goto L_0x0109
            java.lang.reflect.Method r9 = d.b.p.m0.G
            if (r9 == 0) goto L_0x010e
            android.widget.PopupWindow r10 = r6.B     // Catch:{ Exception -> 0x0101 }
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0101 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x0101 }
            r11[r8] = r12     // Catch:{ Exception -> 0x0101 }
            r9.invoke(r10, r11)     // Catch:{ Exception -> 0x0101 }
            goto L_0x010e
        L_0x0101:
            java.lang.String r9 = "MenuPopupWindow"
            java.lang.String r10 = "Could not invoke setTouchModal() on PopupWindow. Oh well."
            android.util.Log.i(r9, r10)
            goto L_0x010e
        L_0x0109:
            android.widget.PopupWindow r9 = r6.B
            r9.setTouchModal(r8)
        L_0x010e:
            android.widget.PopupWindow r9 = r6.B
            r10 = 0
            r9.setEnterTransition(r10)
            java.util.List<d.b.o.i.d$d> r9 = r0.f4169i
            int r10 = r9.size()
            int r10 = r10 - r5
            java.lang.Object r9 = r9.get(r10)
            d.b.o.i.d$d r9 = (d.b.o.i.d.C0027d) r9
            d.b.p.m0 r9 = r9.f4178a
            d.b.p.f0 r9 = r9.f4382c
            r10 = 2
            int[] r11 = new int[r10]
            r9.getLocationOnScreen(r11)
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.view.View r12 = r0.p
            r12.getWindowVisibleDisplayFrame(r10)
            int r12 = r0.q
            if (r12 != r5) goto L_0x0146
            r11 = r11[r8]
            int r9 = r9.getWidth()
            int r9 = r9 + r11
            int r9 = r9 + r4
            int r10 = r10.right
            if (r9 <= r10) goto L_0x014b
            goto L_0x014d
        L_0x0146:
            r9 = r11[r8]
            int r9 = r9 - r4
            if (r9 >= 0) goto L_0x014d
        L_0x014b:
            r9 = r5
            goto L_0x014e
        L_0x014d:
            r9 = r8
        L_0x014e:
            if (r9 != r5) goto L_0x0152
            r10 = r5
            goto L_0x0153
        L_0x0152:
            r10 = r8
        L_0x0153:
            r0.q = r9
            int r9 = android.os.Build.VERSION.SDK_INT
            r11 = 26
            r12 = 5
            if (r9 < r11) goto L_0x0161
            r6.r = r7
            r9 = r8
            r13 = r9
            goto L_0x0192
        L_0x0161:
            r9 = 2
            int[] r11 = new int[r9]
            android.view.View r13 = r0.o
            r13.getLocationOnScreen(r11)
            int[] r9 = new int[r9]
            r7.getLocationOnScreen(r9)
            int r13 = r0.n
            r13 = r13 & 7
            if (r13 != r12) goto L_0x0188
            r13 = r11[r8]
            android.view.View r14 = r0.o
            int r14 = r14.getWidth()
            int r14 = r14 + r13
            r11[r8] = r14
            r13 = r9[r8]
            int r14 = r7.getWidth()
            int r14 = r14 + r13
            r9[r8] = r14
        L_0x0188:
            r13 = r9[r8]
            r14 = r11[r8]
            int r13 = r13 - r14
            r9 = r9[r5]
            r11 = r11[r5]
            int r9 = r9 - r11
        L_0x0192:
            int r11 = r0.n
            r11 = r11 & r12
            if (r11 != r12) goto L_0x019f
            if (r10 == 0) goto L_0x019a
            goto L_0x01a5
        L_0x019a:
            int r4 = r7.getWidth()
            goto L_0x01a7
        L_0x019f:
            if (r10 == 0) goto L_0x01a7
            int r4 = r7.getWidth()
        L_0x01a5:
            int r13 = r13 + r4
            goto L_0x01a8
        L_0x01a7:
            int r13 = r13 - r4
        L_0x01a8:
            r6.f4385f = r13
            r6.k = r5
            r6.f4389j = r5
            r6.b(r9)
            goto L_0x01d0
        L_0x01b2:
            boolean r4 = r0.r
            if (r4 == 0) goto L_0x01ba
            int r4 = r0.t
            r6.f4385f = r4
        L_0x01ba:
            boolean r4 = r0.s
            if (r4 == 0) goto L_0x01c3
            int r4 = r0.u
            r6.b(r4)
        L_0x01c3:
            android.graphics.Rect r4 = r0.f4232a
            if (r4 == 0) goto L_0x01cd
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>(r4)
            goto L_0x01ce
        L_0x01cd:
            r10 = 0
        L_0x01ce:
            r6.z = r10
        L_0x01d0:
            d.b.o.i.d$d r4 = new d.b.o.i.d$d
            int r5 = r0.q
            r4.<init>(r6, r1, r5)
            java.util.List<d.b.o.i.d$d> r5 = r0.f4169i
            r5.add(r4)
            r6.d()
            d.b.p.f0 r4 = r6.f4382c
            r4.setOnKeyListener(r0)
            if (r3 != 0) goto L_0x020e
            boolean r3 = r0.w
            if (r3 == 0) goto L_0x020e
            java.lang.CharSequence r3 = r1.m
            if (r3 == 0) goto L_0x020e
            int r3 = d.b.g.abc_popup_menu_header_item_layout
            android.view.View r2 = r2.inflate(r3, r4, r8)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            r3 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r3 = r2.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.setEnabled(r8)
            java.lang.CharSequence r1 = r1.m
            r3.setText(r1)
            r1 = 0
            r4.addHeaderView(r2, r1, r8)
            r6.d()
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.o.i.d.c(d.b.o.i.g):void");
    }

    public boolean c() {
        return false;
    }

    public void d() {
        if (!a()) {
            for (g c2 : this.f4168h) {
                c(c2);
            }
            this.f4168h.clear();
            View view = this.o;
            this.p = view;
            if (view != null) {
                boolean z2 = this.y == null;
                ViewTreeObserver viewTreeObserver = this.p.getViewTreeObserver();
                this.y = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f4170j);
                }
                this.p.addOnAttachStateChangeListener(this.k);
            }
        }
    }

    public void dismiss() {
        int size = this.f4169i.size();
        if (size > 0) {
            C0027d[] dVarArr = (C0027d[]) this.f4169i.toArray(new C0027d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0027d dVar = dVarArr[i2];
                if (dVar.f4178a.a()) {
                    dVar.f4178a.dismiss();
                }
            }
        }
    }

    public ListView f() {
        if (this.f4169i.isEmpty()) {
            return null;
        }
        List<C0027d> list = this.f4169i;
        return ((C0027d) list.get(list.size() - 1)).f4178a.f4382c;
    }

    public void onDismiss() {
        C0027d dVar;
        int size = this.f4169i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = (C0027d) this.f4169i.get(i2);
            if (!dVar.f4178a.a()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f4179b.a(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void b(int i2) {
        this.r = true;
        this.t = i2;
    }

    public boolean a() {
        return this.f4169i.size() > 0 && ((C0027d) this.f4169i.get(0)).f4178a.a();
    }

    public void a(boolean z2) {
        for (C0027d dVar : this.f4169i) {
            ListAdapter adapter = dVar.f4178a.f4382c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    public void a(d.b.o.i.m.a aVar) {
        this.x = aVar;
    }

    public boolean a(r rVar) {
        for (C0027d dVar : this.f4169i) {
            if (rVar == dVar.f4179b) {
                dVar.f4178a.f4382c.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        rVar.a((m) this, this.f4162b);
        if (a()) {
            c((g) rVar);
        } else {
            this.f4168h.add(rVar);
        }
        d.b.o.i.m.a aVar = this.x;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    public void a(g gVar, boolean z2) {
        int size = this.f4169i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (gVar == ((C0027d) this.f4169i.get(i2)).f4179b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < this.f4169i.size()) {
                ((C0027d) this.f4169i.get(i3)).f4179b.a(false);
            }
            C0027d dVar = (C0027d) this.f4169i.remove(i2);
            dVar.f4179b.a((m) this);
            if (this.A) {
                dVar.f4178a.B.setExitTransition(null);
                dVar.f4178a.B.setAnimationStyle(0);
            }
            dVar.f4178a.dismiss();
            int size2 = this.f4169i.size();
            if (size2 > 0) {
                this.q = ((C0027d) this.f4169i.get(size2 - 1)).f4180c;
            } else {
                this.q = m.m(this.o) == 1 ? 0 : 1;
            }
            if (size2 == 0) {
                dismiss();
                d.b.o.i.m.a aVar = this.x;
                if (aVar != null) {
                    aVar.a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.y.removeGlobalOnLayoutListener(this.f4170j);
                    }
                    this.y = null;
                }
                this.p.removeOnAttachStateChangeListener(this.k);
                this.z.onDismiss();
            } else if (z2) {
                ((C0027d) this.f4169i.get(0)).f4179b.a(false);
            }
        }
    }

    public void a(int i2) {
        if (this.m != i2) {
            this.m = i2;
            this.n = Gravity.getAbsoluteGravity(i2, m.m(this.o));
        }
    }

    public void a(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = Gravity.getAbsoluteGravity(this.m, m.m(view));
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void c(int i2) {
        this.s = true;
        this.u = i2;
    }

    public void c(boolean z2) {
        this.w = z2;
    }
}
