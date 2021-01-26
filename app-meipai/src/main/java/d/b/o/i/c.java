package d.b.o.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import d.e.a;
import d.h.g.a.b;
import java.util.Map;

/* compiled from: BaseMenuWrapper */
public abstract class c {

    /* renamed from: a reason: collision with root package name */
    public final Context f4159a;

    /* renamed from: b reason: collision with root package name */
    public Map<b, MenuItem> f4160b;

    /* renamed from: c reason: collision with root package name */
    public Map<d.h.g.a.c, SubMenu> f4161c;

    public c(Context context) {
        this.f4159a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f4160b == null) {
            this.f4160b = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.f4160b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f4159a, bVar);
        this.f4160b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof d.h.g.a.c)) {
            return subMenu;
        }
        d.h.g.a.c cVar = (d.h.g.a.c) subMenu;
        if (this.f4161c == null) {
            this.f4161c = new a();
        }
        SubMenu subMenu2 = (SubMenu) this.f4161c.get(cVar);
        if (subMenu2 == null) {
            subMenu2 = new s(this.f4159a, cVar);
            this.f4161c.put(cVar, subMenu2);
        }
        return subMenu2;
    }
}
