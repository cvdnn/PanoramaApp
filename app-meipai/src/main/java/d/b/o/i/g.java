package d.b.o.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import d.h.k.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder */
public class g implements d.h.g.a.a {
    public static final int[] z = {1, 4, 5, 3, 2, 0};

    /* renamed from: a reason: collision with root package name */
    public final Context f4198a;

    /* renamed from: b reason: collision with root package name */
    public final Resources f4199b;

    /* renamed from: c reason: collision with root package name */
    public boolean f4200c;

    /* renamed from: d reason: collision with root package name */
    public boolean f4201d;

    /* renamed from: e reason: collision with root package name */
    public a f4202e;

    /* renamed from: f reason: collision with root package name */
    public ArrayList<i> f4203f;

    /* renamed from: g reason: collision with root package name */
    public ArrayList<i> f4204g;

    /* renamed from: h reason: collision with root package name */
    public boolean f4205h;

    /* renamed from: i reason: collision with root package name */
    public ArrayList<i> f4206i;

    /* renamed from: j reason: collision with root package name */
    public ArrayList<i> f4207j;
    public boolean k;
    public int l = 1;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public ArrayList<i> u = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> v = new CopyOnWriteArrayList<>();
    public i w;
    public boolean x = false;
    public boolean y;

    /* compiled from: MenuBuilder */
    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder */
    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        boolean z2 = false;
        this.f4198a = context;
        this.f4199b = context.getResources();
        this.f4203f = new ArrayList<>();
        this.f4204g = new ArrayList<>();
        this.f4205h = true;
        this.f4206i = new ArrayList<>();
        this.f4207j = new ArrayList<>();
        this.k = true;
        if (this.f4199b.getConfiguration().keyboard != 1 && q.c(ViewConfiguration.get(this.f4198a), this.f4198a)) {
            z2 = true;
        }
        this.f4201d = z2;
    }

    public void a(m mVar, Context context) {
        this.v.add(new WeakReference(mVar));
        mVar.a(context, this);
        this.k = true;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f4198a.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = a(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null) {
                int i8 = resolveInfo.specificIndex;
                if (i8 >= 0) {
                    menuItemArr[i8] = intent3;
                }
            }
        }
        return size;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public String b() {
        return "android:menu:actionviewstates";
    }

    public void b(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).b(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(b(), sparseArray);
        }
    }

    public g c() {
        return this;
    }

    public void clear() {
        i iVar = this.w;
        if (iVar != null) {
            a(iVar);
        }
        this.f4203f.clear();
        b(true);
    }

    public void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    public ArrayList<i> d() {
        if (!this.f4205h) {
            return this.f4204g;
        }
        this.f4204g.clear();
        int size = this.f4203f.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.f4203f.get(i2);
            if (iVar.isVisible()) {
                this.f4204g.add(iVar);
            }
        }
        this.f4205h = false;
        this.k = true;
        return this.f4204g;
    }

    public boolean e() {
        return this.x;
    }

    public boolean f() {
        return this.f4200c;
    }

    public MenuItem findItem(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f4203f.get(i3);
            if (iVar.f4211a == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu()) {
                MenuItem findItem = iVar.o.findItem(i2);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public boolean g() {
        return this.f4201d;
    }

    public MenuItem getItem(int i2) {
        return (MenuItem) this.f4203f.get(i2);
    }

    public void h() {
        this.k = true;
        b(true);
    }

    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((i) this.f4203f.get(i2)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        this.p = false;
        if (this.q) {
            this.q = false;
            b(this.r);
        }
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public void j() {
        if (!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a((MenuItem) a2, (m) null, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public void removeGroup(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((i) this.f4203f.get(i3)).f4212b == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.f4203f.size() - i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size2 || ((i) this.f4203f.get(i3)).f4212b != i2) {
                    b(true);
                } else {
                    a(i3, false);
                    i4 = i5;
                }
            }
            b(true);
        }
    }

    public void removeItem(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((i) this.f4203f.get(i3)).f4211a == i2) {
                break;
            } else {
                i3++;
            }
        }
        a(i3, true);
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f4203f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f4203f.get(i3);
            if (iVar.f4212b == i2) {
                iVar.x = (iVar.x & -5) | (z3 ? 4 : 0);
                iVar.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.x = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f4203f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f4203f.get(i3);
            if (iVar.f4212b == i2) {
                iVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f4203f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) this.f4203f.get(i3);
            if (iVar.f4212b == i2 && iVar.c(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f4200c = z2;
        b(false);
    }

    public int size() {
        return this.f4203f.size();
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f4199b.getString(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f4199b.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f4198a, this, iVar);
        iVar.o = rVar;
        rVar.setHeaderTitle(iVar.f4215e);
        return rVar;
    }

    public void a(m mVar) {
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            m mVar2 = (m) weakReference.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.v.remove(weakReference);
            }
        }
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f4199b.getString(i5));
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(b());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).a(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0) {
                MenuItem findItem = findItem(i3);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
        }
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f4199b.getString(i5));
    }

    public void b(boolean z2) {
        if (!this.p) {
            if (z2) {
                this.f4205h = true;
                this.k = true;
            }
            if (!this.v.isEmpty()) {
                j();
                Iterator it = this.v.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    m mVar = (m) weakReference.get();
                    if (mVar == null) {
                        this.v.remove(weakReference);
                    } else {
                        mVar.a(z2);
                    }
                }
                i();
                return;
            }
            return;
        }
        this.q = true;
        if (z2) {
            this.r = true;
        }
    }

    public final void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f4203f.size()) {
            this.f4203f.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = (-65536 & i4) >> 16;
        if (i6 >= 0) {
            int[] iArr = z;
            if (i6 < iArr.length) {
                int i7 = (iArr[i6] << 16) | (65535 & i4);
                i iVar = new i(this, i2, i3, i4, i7, charSequence, this.l);
                ArrayList<i> arrayList = this.f4203f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (((i) arrayList.get(size)).f4214d <= i7) {
                            i5 = size + 1;
                            break;
                        }
                    } else {
                        i5 = 0;
                        break;
                    }
                }
                arrayList.add(i5, iVar);
                b(true);
                return iVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public boolean b(i iVar) {
        boolean z2 = false;
        if (this.v.isEmpty()) {
            return false;
        }
        j();
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            m mVar = (m) weakReference.get();
            if (mVar == null) {
                this.v.remove(weakReference);
            } else {
                z2 = mVar.b(this, iVar);
                if (z2) {
                    break;
                }
            }
        }
        i();
        if (z2) {
            this.w = iVar;
        }
        return z2;
    }

    public final void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.f4199b;
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (i2 > 0) {
                this.m = resources.getText(i2);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i3 > 0) {
                this.n = d.h.e.a.b(this.f4198a, i3);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        b(false);
    }

    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.f4202e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public void a(List<i> list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean f2 = f();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f4203f.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = (i) this.f4203f.get(i4);
                if (iVar.hasSubMenu()) {
                    iVar.o.a(list, i2, keyEvent);
                }
                if (f2) {
                    c2 = iVar.f4220j;
                } else {
                    c2 = iVar.f4218h;
                }
                if (f2) {
                    i3 = iVar.k;
                } else {
                    i3 = iVar.f4219i;
                }
                if (((modifiers & 69647) == (i3 & 69647)) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (f2 && c2 == 8 && i2 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public i a(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<i> arrayList = this.u;
        arrayList.clear();
        a((List<i>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (i) arrayList.get(0);
        }
        boolean f2 = f();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = (i) arrayList.get(i3);
            if (f2) {
                c2 = iVar.f4220j;
            } else {
                c2 = iVar.f4218h;
            }
            if ((c2 == keyData.meta[0] && (metaState & 2) == 0) || ((c2 == keyData.meta[2] && (metaState & 2) != 0) || (f2 && c2 == 8 && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (m) null, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MenuItem r7, d.b.o.i.m r8, int r9) {
        /*
            r6 = this;
            d.b.o.i.i r7 = (d.b.o.i.i) r7
            r0 = 0
            if (r7 == 0) goto L_0x00e5
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000d
            goto L_0x00e5
        L_0x000d:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.p
            r2 = 1
            if (r1 == 0) goto L_0x0019
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L_0x0019
            goto L_0x0044
        L_0x0019:
            d.b.o.i.g r1 = r7.n
            boolean r1 = r1.a(r1, r7)
            if (r1 == 0) goto L_0x0022
            goto L_0x0044
        L_0x0022:
            android.content.Intent r1 = r7.f4217g
            if (r1 == 0) goto L_0x0036
            d.b.o.i.g r3 = r7.n     // Catch:{ ActivityNotFoundException -> 0x002e }
            android.content.Context r3 = r3.f4198a     // Catch:{ ActivityNotFoundException -> 0x002e }
            r3.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x002e }
            goto L_0x0044
        L_0x002e:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L_0x0036:
            d.h.k.b r1 = r7.A
            if (r1 == 0) goto L_0x0046
            d.b.o.i.j$a r1 = (d.b.o.i.j.a) r1
            android.view.ActionProvider r1 = r1.f4224b
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L_0x0046
        L_0x0044:
            r1 = r2
            goto L_0x0047
        L_0x0046:
            r1 = r0
        L_0x0047:
            d.h.k.b r3 = r7.A
            if (r3 == 0) goto L_0x0058
            r4 = r3
            d.b.o.i.j$a r4 = (d.b.o.i.j.a) r4
            android.view.ActionProvider r4 = r4.f4224b
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L_0x0058
            r4 = r2
            goto L_0x0059
        L_0x0058:
            r4 = r0
        L_0x0059:
            boolean r5 = r7.c()
            if (r5 == 0) goto L_0x006b
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x00e4
            r6.a(r2)
            goto L_0x00e4
        L_0x006b:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x007c
            if (r4 == 0) goto L_0x0074
            goto L_0x007c
        L_0x0074:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x00e4
            r6.a(r2)
            goto L_0x00e4
        L_0x007c:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0083
            r6.a(r0)
        L_0x0083:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0097
            d.b.o.i.r r9 = new d.b.o.i.r
            android.content.Context r5 = r6.f4198a
            r9.<init>(r5, r6, r7)
            r7.o = r9
            java.lang.CharSequence r5 = r7.f4215e
            r9.setHeaderTitle(r5)
        L_0x0097:
            d.b.o.i.r r7 = r7.o
            if (r4 == 0) goto L_0x00a8
            d.b.o.i.j$a r3 = (d.b.o.i.j.a) r3
            android.view.ActionProvider r9 = r3.f4224b
            d.b.o.i.j r3 = d.b.o.i.j.this
            android.view.SubMenu r3 = r3.a(r7)
            r9.onPrepareSubMenu(r3)
        L_0x00a8:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<d.b.o.i.m>> r9 = r6.v
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x00b1
            goto L_0x00de
        L_0x00b1:
            if (r8 == 0) goto L_0x00b7
            boolean r0 = r8.a(r7)
        L_0x00b7:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<d.b.o.i.m>> r8 = r6.v
            java.util.Iterator r8 = r8.iterator()
        L_0x00bd:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00de
            java.lang.Object r9 = r8.next()
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            java.lang.Object r3 = r9.get()
            d.b.o.i.m r3 = (d.b.o.i.m) r3
            if (r3 != 0) goto L_0x00d7
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<d.b.o.i.m>> r3 = r6.v
            r3.remove(r9)
            goto L_0x00bd
        L_0x00d7:
            if (r0 != 0) goto L_0x00bd
            boolean r0 = r3.a(r7)
            goto L_0x00bd
        L_0x00de:
            r1 = r1 | r0
            if (r1 != 0) goto L_0x00e4
            r6.a(r2)
        L_0x00e4:
            return r1
        L_0x00e5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.o.i.g.a(android.view.MenuItem, d.b.o.i.m, int):boolean");
    }

    public final void a(boolean z2) {
        if (!this.t) {
            this.t = true;
            Iterator it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.v.remove(weakReference);
                } else {
                    mVar.a(this, z2);
                }
            }
            this.t = false;
        }
    }

    public void a() {
        ArrayList d2 = d();
        if (this.k) {
            Iterator it = this.v.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.v.remove(weakReference);
                } else {
                    z2 |= mVar.b();
                }
            }
            if (z2) {
                this.f4206i.clear();
                this.f4207j.clear();
                int size = d2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = (i) d2.get(i2);
                    if (iVar.d()) {
                        this.f4206i.add(iVar);
                    } else {
                        this.f4207j.add(iVar);
                    }
                }
            } else {
                this.f4206i.clear();
                this.f4207j.clear();
                this.f4207j.addAll(d());
            }
            this.k = false;
        }
    }

    public boolean a(i iVar) {
        boolean z2 = false;
        if (!this.v.isEmpty() && this.w == iVar) {
            j();
            Iterator it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                m mVar = (m) weakReference.get();
                if (mVar == null) {
                    this.v.remove(weakReference);
                } else {
                    z2 = mVar.a(this, iVar);
                    if (z2) {
                        break;
                    }
                }
            }
            i();
            if (z2) {
                this.w = null;
            }
        }
        return z2;
    }
}
