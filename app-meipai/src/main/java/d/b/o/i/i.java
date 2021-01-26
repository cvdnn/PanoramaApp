package d.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import d.h.g.a.b;

/* compiled from: MenuItemImpl */
public final class i implements b {
    public d.h.k.b A;
    public OnActionExpandListener B;
    public boolean C = false;
    public ContextMenuInfo D;

    /* renamed from: a reason: collision with root package name */
    public final int f4211a;

    /* renamed from: b reason: collision with root package name */
    public final int f4212b;

    /* renamed from: c reason: collision with root package name */
    public final int f4213c;

    /* renamed from: d reason: collision with root package name */
    public final int f4214d;

    /* renamed from: e reason: collision with root package name */
    public CharSequence f4215e;

    /* renamed from: f reason: collision with root package name */
    public CharSequence f4216f;

    /* renamed from: g reason: collision with root package name */
    public Intent f4217g;

    /* renamed from: h reason: collision with root package name */
    public char f4218h;

    /* renamed from: i reason: collision with root package name */
    public int f4219i = 4096;

    /* renamed from: j reason: collision with root package name */
    public char f4220j;
    public int k = 4096;
    public Drawable l;
    public int m = 0;
    public g n;
    public r o;
    public OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public ColorStateList s = null;
    public Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public int y = 0;
    public View z;

    /* compiled from: MenuItemImpl */
    public class a implements d.h.k.b.a {
        public a() {
        }
    }

    public i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.n = gVar;
        this.f4211a = i3;
        this.f4212b = i2;
        this.f4213c = i4;
        this.f4214d = i5;
        this.f4215e = charSequence;
        this.y = i6;
    }

    public static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    public char b() {
        return this.n.f() ? this.f4220j : this.f4218h;
    }

    public boolean c(boolean z2) {
        int i2 = this.x;
        int i3 = (z2 ? 0 : 8) | (i2 & -9);
        this.x = i3;
        if (i2 != i3) {
            return true;
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    public boolean d() {
        return (this.x & 32) == 32;
    }

    public boolean e() {
        return (this.x & 4) != 0;
    }

    public boolean expandActionView() {
        if (!c()) {
            return false;
        }
        OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.b(this);
        }
        return false;
    }

    public boolean f() {
        return this.n.g() && b() != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        d.h.k.b bVar = this.A;
        if (bVar == null) {
            return null;
        }
        View a2 = bVar.a((MenuItem) this);
        this.z = a2;
        return a2;
    }

    public int getAlphabeticModifiers() {
        return this.k;
    }

    public char getAlphabeticShortcut() {
        return this.f4220j;
    }

    public CharSequence getContentDescription() {
        return this.q;
    }

    public int getGroupId() {
        return this.f4212b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        int i2 = this.m;
        if (i2 == 0) {
            return null;
        }
        Drawable b2 = d.b.l.a.a.b(this.n.f4198a, i2);
        this.m = 0;
        this.l = b2;
        return a(b2);
    }

    public ColorStateList getIconTintList() {
        return this.s;
    }

    public Mode getIconTintMode() {
        return this.t;
    }

    public Intent getIntent() {
        return this.f4217g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f4211a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    public int getNumericModifiers() {
        return this.f4219i;
    }

    public char getNumericShortcut() {
        return this.f4218h;
    }

    public int getOrder() {
        return this.f4213c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f4215e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4216f;
        return charSequence != null ? charSequence : this.f4215e;
    }

    public CharSequence getTooltipText() {
        return this.r;
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public boolean isActionViewExpanded() {
        return this.C;
    }

    public boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    public boolean isChecked() {
        return (this.x & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    public boolean isVisible() {
        d.h.k.b bVar = this.A;
        boolean z2 = true;
        if (bVar == null || !bVar.b()) {
            if ((this.x & 8) != 0) {
                z2 = false;
            }
            return z2;
        }
        if ((this.x & 8) != 0 || !this.A.a()) {
            z2 = false;
        }
        return z2;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f4220j == c2) {
            return this;
        }
        this.f4220j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.x;
        boolean z3 = z2 | (i2 & true);
        this.x = z3 ? 1 : 0;
        if (i2 != z3) {
            this.n.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.x & 4) != 0) {
            g gVar = this.n;
            if (gVar != null) {
                int groupId = getGroupId();
                int size = gVar.f4203f.size();
                gVar.j();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = (i) gVar.f4203f.get(i2);
                    if (iVar.f4212b == groupId && iVar.e() && iVar.isCheckable()) {
                        iVar.a(iVar == this);
                    }
                }
                gVar.i();
            } else {
                throw null;
            }
        } else {
            a(z2);
        }
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.b(false);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.x |= 16;
        } else {
            this.x &= -17;
        }
        this.n.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.w = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.u = true;
        this.w = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.t = mode;
        this.v = true;
        this.w = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4217g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.f4218h == c2) {
            return this;
        }
        this.f4218h = c2;
        this.n.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f4218h = c2;
        this.f4220j = Character.toLowerCase(c3);
        this.n.b(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.y = i2;
            this.n.h();
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4215e = charSequence;
        this.n.b(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4216f = charSequence;
        this.n.b(false);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (c(z2)) {
            g gVar = this.n;
            gVar.f4205h = true;
            gVar.b(true);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f4215e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final Drawable a(Drawable drawable) {
        if (drawable != null && this.w && (this.u || this.v)) {
            drawable = drawable.mutate();
            if (this.u) {
                drawable.setTintList(this.s);
            }
            if (this.v) {
                drawable.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable;
    }

    public void b(boolean z2) {
        if (z2) {
            this.x |= 32;
        } else {
            this.x &= -33;
        }
    }

    public b setActionView(View view) {
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1) {
            int i2 = this.f4211a;
            if (i2 > 0) {
                view.setId(i2);
            }
        }
        this.n.h();
        return this;
    }

    public boolean c() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            d.h.k.b bVar = this.A;
            if (bVar != null) {
                this.z = bVar.a((MenuItem) this);
            }
        }
        if (this.z != null) {
            return true;
        }
        return false;
    }

    /* renamed from: setContentDescription reason: collision with other method in class */
    public b m75setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.b(false);
        return this;
    }

    /* renamed from: setTooltipText reason: collision with other method in class */
    public b m76setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f4220j == c2 && this.k == i2) {
            return this;
        }
        this.f4220j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f4218h == c2 && this.f4219i == i2) {
            return this;
        }
        this.f4218h = c2;
        this.f4219i = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f4218h = c2;
        this.f4219i = KeyEvent.normalizeMetaState(i2);
        this.f4220j = Character.toLowerCase(c3);
        this.k = KeyEvent.normalizeMetaState(i3);
        this.n.b(false);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.l = null;
        this.m = i2;
        this.w = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setTitle(int i2) {
        setTitle((CharSequence) this.n.f4198a.getString(i2));
        return this;
    }

    public MenuItem setActionView(int i2) {
        Context context = this.n.f4198a;
        setActionView(LayoutInflater.from(context).inflate(i2, new LinearLayout(context), false));
        return this;
    }

    public void a(boolean z2) {
        int i2 = this.x;
        int i3 = (z2 ? 2 : 0) | (i2 & -3);
        this.x = i3;
        if (i2 != i3) {
            this.n.b(false);
        }
    }

    public d.h.k.b a() {
        return this.A;
    }

    public b a(d.h.k.b bVar) {
        d.h.k.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.f4912a = null;
        }
        this.z = null;
        this.A = bVar;
        this.n.b(true);
        d.h.k.b bVar3 = this.A;
        if (bVar3 != null) {
            bVar3.a((d.h.k.b.a) new a());
        }
        return this;
    }
}
