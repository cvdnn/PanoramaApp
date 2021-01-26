package d.b.o.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import d.h.g.a.a;
import d.h.g.a.b;
import d.h.g.a.c;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MenuWrapperICS */
public class o extends c implements Menu {

    /* renamed from: d reason: collision with root package name */
    public final a f4244d;

    public o(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f4244d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return a(this.f4244d.add(charSequence));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f4244d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr2[i6] = a(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.f4244d.addSubMenu(charSequence));
    }

    public void clear() {
        Map<b, MenuItem> map = this.f4160b;
        if (map != null) {
            map.clear();
        }
        Map<c, SubMenu> map2 = this.f4161c;
        if (map2 != null) {
            map2.clear();
        }
        this.f4244d.clear();
    }

    public void close() {
        this.f4244d.close();
    }

    public MenuItem findItem(int i2) {
        return a(this.f4244d.findItem(i2));
    }

    public MenuItem getItem(int i2) {
        return a(this.f4244d.getItem(i2));
    }

    public boolean hasVisibleItems() {
        return this.f4244d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f4244d.isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return this.f4244d.performIdentifierAction(i2, i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f4244d.performShortcut(i2, keyEvent, i3);
    }

    public void removeGroup(int i2) {
        Map<b, MenuItem> map = this.f4160b;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i2 == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        this.f4244d.removeGroup(i2);
    }

    public void removeItem(int i2) {
        Map<b, MenuItem> map = this.f4160b;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (i2 == ((MenuItem) it.next()).getItemId()) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.f4244d.removeItem(i2);
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        this.f4244d.setGroupCheckable(i2, z, z2);
    }

    public void setGroupEnabled(int i2, boolean z) {
        this.f4244d.setGroupEnabled(i2, z);
    }

    public void setGroupVisible(int i2, boolean z) {
        this.f4244d.setGroupVisible(i2, z);
    }

    public void setQwertyMode(boolean z) {
        this.f4244d.setQwertyMode(z);
    }

    public int size() {
        return this.f4244d.size();
    }

    public MenuItem add(int i2) {
        return a(this.f4244d.add(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return a(this.f4244d.addSubMenu(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f4244d.add(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return a(this.f4244d.addSubMenu(i2, i3, i4, charSequence));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(this.f4244d.add(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return a(this.f4244d.addSubMenu(i2, i3, i4, i5));
    }
}
