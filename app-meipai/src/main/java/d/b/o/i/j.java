package d.b.o.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
public class j extends c implements MenuItem {

    /* renamed from: d reason: collision with root package name */
    public final d.h.g.a.b f4222d;

    /* renamed from: e reason: collision with root package name */
    public Method f4223e;

    /* compiled from: MenuItemWrapperICS */
    public class a extends d.h.k.b {

        /* renamed from: b reason: collision with root package name */
        public final ActionProvider f4224b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f4224b = actionProvider;
        }
    }

    /* compiled from: MenuItemWrapperICS */
    public class b extends a implements VisibilityListener {

        /* renamed from: d reason: collision with root package name */
        public d.h.k.b.a f4226d;

        public b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.f4224b.onCreateActionView(menuItem);
        }

        public boolean b() {
            return this.f4224b.overridesItemVisibility();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            d.h.k.b.a aVar = this.f4226d;
            if (aVar != null) {
                g gVar = i.this.n;
                gVar.f4205h = true;
                gVar.b(true);
            }
        }

        public boolean a() {
            return this.f4224b.isVisible();
        }

        public void a(d.h.k.b.a aVar) {
            this.f4226d = aVar;
            this.f4224b.setVisibilityListener(aVar != null ? this : null);
        }
    }

    /* compiled from: MenuItemWrapperICS */
    public static class c extends FrameLayout implements d.b.o.b {

        /* renamed from: a reason: collision with root package name */
        public final CollapsibleActionView f4227a;

        public c(View view) {
            super(view.getContext());
            this.f4227a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.f4227a.onActionViewExpanded();
        }

        public void b() {
            this.f4227a.onActionViewCollapsed();
        }
    }

    /* compiled from: MenuItemWrapperICS */
    public class d implements OnActionExpandListener {

        /* renamed from: a reason: collision with root package name */
        public final OnActionExpandListener f4228a;

        public d(OnActionExpandListener onActionExpandListener) {
            this.f4228a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4228a.onMenuItemActionCollapse(j.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4228a.onMenuItemActionExpand(j.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    public class e implements OnMenuItemClickListener {

        /* renamed from: a reason: collision with root package name */
        public final OnMenuItemClickListener f4230a;

        public e(OnMenuItemClickListener onMenuItemClickListener) {
            this.f4230a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f4230a.onMenuItemClick(j.this.a(menuItem));
        }
    }

    public j(Context context, d.h.g.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f4222d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f4222d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f4222d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        d.h.k.b a2 = this.f4222d.a();
        if (a2 instanceof a) {
            return ((a) a2).f4224b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f4222d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).f4227a : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f4222d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f4222d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f4222d.getContentDescription();
    }

    public int getGroupId() {
        return this.f4222d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f4222d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f4222d.getIconTintList();
    }

    public Mode getIconTintMode() {
        return this.f4222d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f4222d.getIntent();
    }

    public int getItemId() {
        return this.f4222d.getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f4222d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f4222d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f4222d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f4222d.getOrder();
    }

    public SubMenu getSubMenu() {
        return a(this.f4222d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f4222d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f4222d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f4222d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f4222d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f4222d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f4222d.isCheckable();
    }

    public boolean isChecked() {
        return this.f4222d.isChecked();
    }

    public boolean isEnabled() {
        return this.f4222d.isEnabled();
    }

    public boolean isVisible() {
        return this.f4222d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.f4159a, actionProvider);
        d.h.g.a.b bVar2 = this.f4222d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f4222d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f4222d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f4222d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f4222d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f4222d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f4222d.setEnabled(z);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f4222d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4222d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f4222d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4222d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f4222d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f4222d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f4222d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f4222d.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.f4222d.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.f4222d.setShowAsActionFlags(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4222d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4222d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f4222d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f4222d.setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f4222d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.f4222d.setIcon(i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f4222d.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f4222d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f4222d.setTitle(i2);
        return this;
    }

    public MenuItem setActionView(int i2) {
        this.f4222d.setActionView(i2);
        View actionView = this.f4222d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f4222d.setActionView((View) new c(actionView));
        }
        return this;
    }
}
