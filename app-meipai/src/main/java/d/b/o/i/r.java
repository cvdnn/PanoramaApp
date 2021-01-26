package d.b.o.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.baidu.mobstat.Config;

/* compiled from: SubMenuBuilder */
public class r extends g implements SubMenu {
    public g A;
    public i B;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.A = gVar;
        this.B = iVar;
    }

    public boolean a(g gVar, MenuItem menuItem) {
        return super.a(gVar, menuItem) || this.A.a(gVar, menuItem);
    }

    public boolean b(i iVar) {
        return this.A.b(iVar);
    }

    public g c() {
        return this.A.c();
    }

    public boolean e() {
        return this.A.e();
    }

    public boolean f() {
        return this.A.f();
    }

    public boolean g() {
        return this.A.g();
    }

    public MenuItem getItem() {
        return this.B;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.A.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.B.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.A.setQwertyMode(z);
    }

    public String b() {
        i iVar = this.B;
        int i2 = iVar != null ? iVar.f4211a : 0;
        if (i2 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("android:menu:actionviewstates");
        sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
        sb.append(i2);
        return sb.toString();
    }

    public SubMenu setHeaderIcon(int i2) {
        a(0, null, i2, null, null);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        a(i2, null, 0, null, null);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.B.setIcon(i2);
        return this;
    }

    public boolean a(i iVar) {
        return this.A.a(iVar);
    }
}
