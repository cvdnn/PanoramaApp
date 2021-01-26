package d.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import d.h.g.a.b;

/* compiled from: ActionMenuItem */
public class a implements b {

    /* renamed from: a reason: collision with root package name */
    public final int f4141a;

    /* renamed from: b reason: collision with root package name */
    public final int f4142b;

    /* renamed from: c reason: collision with root package name */
    public final int f4143c;

    /* renamed from: d reason: collision with root package name */
    public CharSequence f4144d;

    /* renamed from: e reason: collision with root package name */
    public CharSequence f4145e;

    /* renamed from: f reason: collision with root package name */
    public Intent f4146f;

    /* renamed from: g reason: collision with root package name */
    public char f4147g;

    /* renamed from: h reason: collision with root package name */
    public int f4148h = 4096;

    /* renamed from: i reason: collision with root package name */
    public char f4149i;

    /* renamed from: j reason: collision with root package name */
    public int f4150j = 4096;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;
    public ColorStateList o = null;
    public Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.l = context;
        this.f4141a = i3;
        this.f4142b = i2;
        this.f4143c = i5;
        this.f4144d = charSequence;
    }

    public b a(d.h.k.b bVar) {
        throw new UnsupportedOperationException();
    }

    public d.h.k.b a() {
        return null;
    }

    public final void b() {
        if (this.k == null) {
            return;
        }
        if (this.q || this.r) {
            Drawable drawable = this.k;
            this.k = drawable;
            Drawable mutate = drawable.mutate();
            this.k = mutate;
            if (this.q) {
                mutate.setTintList(this.o);
            }
            if (this.r) {
                this.k.setTintMode(this.p);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f4150j;
    }

    public char getAlphabeticShortcut() {
        return this.f4149i;
    }

    public CharSequence getContentDescription() {
        return this.m;
    }

    public int getGroupId() {
        return this.f4142b;
    }

    public Drawable getIcon() {
        return this.k;
    }

    public ColorStateList getIconTintList() {
        return this.o;
    }

    public Mode getIconTintMode() {
        return this.p;
    }

    public Intent getIntent() {
        return this.f4146f;
    }

    public int getItemId() {
        return this.f4141a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f4148h;
    }

    public char getNumericShortcut() {
        return this.f4147g;
    }

    public int getOrder() {
        return this.f4143c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f4144d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4145e;
        return charSequence != null ? charSequence : this.f4144d;
    }

    public CharSequence getTooltipText() {
        return this.n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f4149i = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.s = z | (this.s & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & -3);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        b();
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.p = mode;
        this.r = true;
        b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4146f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f4147g = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f4147g = c2;
        this.f4149i = Character.toLowerCase(c3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4144d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4145e = charSequence;
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.s & 8;
        if (z) {
            i2 = 0;
        }
        this.s = i3 | i2;
        return this;
    }

    public MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f4149i = Character.toLowerCase(c2);
        this.f4150j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    /* renamed from: setContentDescription reason: collision with other method in class */
    public b m73setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f4147g = c2;
        this.f4148h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f4144d = this.l.getResources().getString(i2);
        return this;
    }

    /* renamed from: setTooltipText reason: collision with other method in class */
    public b m74setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.k = d.h.e.a.b(this.l, i2);
        b();
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f4147g = c2;
        this.f4148h = KeyEvent.normalizeMetaState(i2);
        this.f4149i = Character.toLowerCase(c3);
        this.f4150j = KeyEvent.normalizeMetaState(i3);
        return this;
    }
}
