package d.b.p;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.appcompat.widget.ActionMenuView;
import d.b.o.i.g;
import d.b.o.i.i;
import d.b.o.i.k;
import d.b.o.i.l;
import d.b.o.i.n;
import d.b.o.i.p;
import d.b.o.i.r;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter */
public class c extends d.b.o.i.b {

    /* renamed from: i reason: collision with root package name */
    public d f4299i;

    /* renamed from: j reason: collision with root package name */
    public Drawable f4300j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public final SparseBooleanArray s = new SparseBooleanArray();
    public e t;
    public a u;
    public C0029c v;
    public b w;
    public final f x = new f();
    public int y;

    /* compiled from: ActionMenuPresenter */
    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, d.b.a.actionOverflowMenuStyle, 0);
            if (!rVar.B.d()) {
                View view2 = c.this.f4299i;
                if (view2 == null) {
                    view2 = (View) c.this.f4158h;
                }
                this.f4238f = view2;
            }
            a(c.this.x);
        }

        public void c() {
            c cVar = c.this;
            cVar.u = null;
            cVar.y = 0;
            super.c();
        }
    }

    /* compiled from: ActionMenuPresenter */
    public class b extends androidx.appcompat.view.menu.ActionMenuItemView.b {
        public b() {
        }
    }

    /* renamed from: d.b.p.c$c reason: collision with other inner class name */
    /* compiled from: ActionMenuPresenter */
    public class C0029c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public e f4302a;

        public C0029c(e eVar) {
            this.f4302a = eVar;
        }

        public void run() {
            g gVar = c.this.f4153c;
            if (gVar != null) {
                d.b.o.i.g.a aVar = gVar.f4202e;
                if (aVar != null) {
                    aVar.a(gVar);
                }
            }
            View view = (View) c.this.f4158h;
            if (!(view == null || view.getWindowToken() == null || !this.f4302a.d())) {
                c.this.t = this.f4302a;
            }
            c.this.v = null;
        }
    }

    /* compiled from: ActionMenuPresenter */
    public class d extends n implements androidx.appcompat.widget.ActionMenuView.a {

        /* compiled from: ActionMenuPresenter */
        public class a extends h0 {
            public a(View view, c cVar) {
                super(view);
            }

            public p b() {
                e eVar = c.this.t;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            public boolean c() {
                c.this.f();
                return true;
            }

            public boolean d() {
                c cVar = c.this;
                if (cVar.v != null) {
                    return false;
                }
                cVar.c();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, d.b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            a.a.a.a.b.a.a((View) this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.f();
            return true;
        }

        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter */
    public class e extends l {
        public e(Context context, g gVar, View view, boolean z) {
            super(context, gVar, view, z, d.b.a.actionOverflowMenuStyle, 0);
            a(c.this.x);
        }

        public void c() {
            g gVar = c.this.f4153c;
            if (gVar != null) {
                gVar.a(true);
            }
            c.this.t = null;
            super.c();
        }
    }

    /* compiled from: ActionMenuPresenter */
    public class f implements d.b.o.i.m.a {
        public f() {
        }

        public boolean a(g gVar) {
            boolean z = false;
            if (gVar == null) {
                return false;
            }
            c.this.y = ((r) gVar).B.getItemId();
            d.b.o.i.m.a aVar = c.this.f4155e;
            if (aVar != null) {
                z = aVar.a(gVar);
            }
            return z;
        }

        public void a(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.c().a(false);
            }
            d.b.o.i.m.a aVar = c.this.f4155e;
            if (aVar != null) {
                aVar.a(gVar, z);
            }
        }
    }

    public c(Context context) {
        super(context, d.b.g.abc_action_menu_layout, d.b.g.abc_action_menu_item_layout);
    }

    public void a(Context context, g gVar) {
        this.f4152b = context;
        LayoutInflater.from(context);
        this.f4153c = gVar;
        Resources resources = context.getResources();
        if (!this.m) {
            this.l = true;
        }
        int i2 = 2;
        this.n = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
            i2 = 5;
        } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
            i2 = 4;
        } else if (i3 >= 360) {
            i2 = 3;
        }
        this.p = i2;
        int i5 = this.n;
        if (this.l) {
            if (this.f4299i == null) {
                d dVar = new d(this.f4151a);
                this.f4299i = dVar;
                if (this.k) {
                    dVar.setImageDrawable(this.f4300j);
                    this.f4300j = null;
                    this.k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f4299i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f4299i.getMeasuredWidth();
        } else {
            this.f4299i = null;
        }
        this.o = i5;
        this.r = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean b() {
        int i2;
        ArrayList arrayList;
        int i3;
        boolean z;
        g gVar = this.f4153c;
        View view = null;
        if (gVar != null) {
            arrayList = gVar.d();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i4 = this.p;
        int i5 = this.o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f4158h;
        int i6 = 0;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z = true;
            if (i6 >= i2) {
                break;
            }
            i iVar = (i) arrayList.get(i6);
            if ((iVar.y & 2) == 2) {
                i8++;
            } else {
                if ((iVar.y & 1) == 1) {
                    i7++;
                } else {
                    z2 = true;
                }
            }
            if (this.q && iVar.C) {
                i4 = 0;
            }
            i6++;
        }
        if (this.l && (z2 || i7 + i8 > i4)) {
            i4--;
        }
        int i9 = i4 - i8;
        SparseBooleanArray sparseBooleanArray = this.s;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i2) {
            i iVar2 = (i) arrayList.get(i10);
            if ((iVar2.y & i3) == i3 ? z : false) {
                View a2 = a(iVar2, view, viewGroup);
                a2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a2.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int i12 = iVar2.f4212b;
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                iVar2.b(z);
            } else {
                if ((iVar2.y & z) == z ? z : false) {
                    int i13 = iVar2.f4212b;
                    boolean z3 = sparseBooleanArray.get(i13);
                    boolean z4 = ((i9 > 0 || z3) && i5 > 0) ? z : false;
                    if (z4) {
                        View a3 = a(iVar2, view, viewGroup);
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                        int measuredWidth2 = a3.getMeasuredWidth();
                        i5 -= measuredWidth2;
                        if (i11 == 0) {
                            i11 = measuredWidth2;
                        }
                        z4 &= i5 + i11 > 0 ? z : false;
                    }
                    boolean z5 = z4;
                    if (z5 && i13 != 0) {
                        sparseBooleanArray.put(i13, z);
                    } else if (z3) {
                        sparseBooleanArray.put(i13, false);
                        for (int i14 = 0; i14 < i10; i14++) {
                            i iVar3 = (i) arrayList.get(i14);
                            if (iVar3.f4212b == i13) {
                                if (iVar3.d()) {
                                    i9++;
                                }
                                iVar3.b(false);
                            }
                        }
                    }
                    if (z5) {
                        i9--;
                    }
                    iVar2.b(z5);
                } else {
                    iVar2.b(false);
                    i10++;
                    view = null;
                    i3 = 2;
                    z = true;
                }
            }
            i10++;
            view = null;
            i3 = 2;
            z = true;
        }
        return z;
    }

    public boolean c() {
        C0029c cVar = this.v;
        if (cVar != null) {
            n nVar = this.f4158h;
            if (nVar != null) {
                ((View) nVar).removeCallbacks(cVar);
                this.v = null;
                return true;
            }
        }
        e eVar = this.t;
        if (eVar == null) {
            return false;
        }
        if (eVar.b()) {
            eVar.f4242j.dismiss();
        }
        return true;
    }

    public boolean d() {
        a aVar = this.u;
        if (aVar == null) {
            return false;
        }
        if (aVar.b()) {
            aVar.f4242j.dismiss();
        }
        return true;
    }

    public boolean e() {
        e eVar = this.t;
        return eVar != null && eVar.b();
    }

    public boolean f() {
        if (this.l && !e()) {
            g gVar = this.f4153c;
            if (!(gVar == null || this.f4158h == null || this.v != null)) {
                gVar.a();
                if (!gVar.f4207j.isEmpty()) {
                    e eVar = new e(this.f4152b, this.f4153c, this.f4299i, true);
                    C0029c cVar = new C0029c(eVar);
                    this.v = cVar;
                    ((View) this.f4158h).post(cVar);
                    super.a((r) null);
                    return true;
                }
            }
        }
        return false;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.c()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.C ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (actionMenuView != null) {
            if (!(layoutParams instanceof androidx.appcompat.widget.ActionMenuView.c)) {
                actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
            }
            return actionView;
        }
        throw null;
    }

    public void a(boolean z) {
        ArrayList<i> arrayList;
        super.a(z);
        ((View) this.f4158h).requestLayout();
        g gVar = this.f4153c;
        boolean z2 = false;
        if (gVar != null) {
            gVar.a();
            ArrayList<i> arrayList2 = gVar.f4206i;
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.h.k.b bVar = ((i) arrayList2.get(i2)).A;
            }
        }
        g gVar2 = this.f4153c;
        if (gVar2 != null) {
            gVar2.a();
            arrayList = gVar2.f4207j;
        } else {
            arrayList = null;
        }
        if (this.l && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !((i) arrayList.get(0)).C;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f4299i == null) {
                this.f4299i = new d(this.f4151a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f4299i.getParent();
            if (viewGroup != this.f4158h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f4299i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f4158h;
                d dVar = this.f4299i;
                androidx.appcompat.widget.ActionMenuView.c generateDefaultLayoutParams = actionMenuView.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f753c = true;
                actionMenuView.addView(dVar, generateDefaultLayoutParams);
            }
        } else {
            d dVar2 = this.f4299i;
            if (dVar2 != null) {
                ViewParent parent = dVar2.getParent();
                n nVar = this.f4158h;
                if (parent == nVar) {
                    ((ViewGroup) nVar).removeView(this.f4299i);
                }
            }
        }
        ((ActionMenuView) this.f4158h).setOverflowReserved(this.l);
    }

    public boolean a(r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (true) {
            g gVar = rVar2.A;
            if (gVar == this.f4153c) {
                break;
            }
            rVar2 = (r) gVar;
        }
        i iVar = rVar2.B;
        ViewGroup viewGroup = (ViewGroup) this.f4158h;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof d.b.o.i.n.a) && ((d.b.o.i.n.a) childAt).getItemData() == iVar) {
                    view = childAt;
                    break;
                }
                i2++;
            }
        }
        if (view == null) {
            return false;
        }
        rVar.B.getItemId();
        int size = rVar.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i3++;
        }
        a aVar = new a(this.f4152b, rVar, view);
        this.u = aVar;
        aVar.f4240h = z;
        k kVar = aVar.f4242j;
        if (kVar != null) {
            kVar.b(z);
        }
        if (this.u.d()) {
            d.b.o.i.m.a aVar2 = this.f4155e;
            if (aVar2 != null) {
                aVar2.a(rVar);
            }
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean a() {
        return c() | d();
    }

    public void a(g gVar, boolean z) {
        a();
        d.b.o.i.m.a aVar = this.f4155e;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }
}
