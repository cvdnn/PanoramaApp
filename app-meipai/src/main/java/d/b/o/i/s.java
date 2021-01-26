package d.b.o.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import d.h.g.a.c;

/* compiled from: SubMenuWrapperICS */
public class s extends o implements SubMenu {

    /* renamed from: e reason: collision with root package name */
    public final c f4256e;

    public s(Context context, c cVar) {
        super(context, cVar);
        this.f4256e = cVar;
    }

    public void clearHeader() {
        this.f4256e.clearHeader();
    }

    public MenuItem getItem() {
        return a(this.f4256e.getItem());
    }

    public SubMenu setHeaderIcon(int i2) {
        this.f4256e.setHeaderIcon(i2);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        this.f4256e.setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f4256e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.f4256e.setIcon(i2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f4256e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f4256e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f4256e.setIcon(drawable);
        return this;
    }
}
