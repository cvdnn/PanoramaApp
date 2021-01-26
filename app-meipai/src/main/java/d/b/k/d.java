package d.b.k;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import d.b.k.g.C0023g;
import d.b.o.a;
import d.b.o.a.C0026a;
import d.b.p.c1;
import d.b.p.j;
import d.h.d.f;
import java.util.ArrayList;

/* compiled from: AppCompatActivity */
public class d extends d.n.a.d implements e, f {
    public f p;
    public Resources q;

    public a a(C0026a aVar) {
        return null;
    }

    public void a(a aVar) {
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        d0().a(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        g gVar = (g) d0();
        gVar.a(false);
        gVar.I = true;
    }

    public void b(a aVar) {
    }

    public void c0() {
        d0().b();
    }

    public void closeOptionsMenu() {
        a e0 = e0();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    public f d0() {
        if (this.p == null) {
            this.p = f.a((Activity) this, (e) this);
        }
        return this.p;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a e0 = e0();
        return super.dispatchKeyEvent(keyEvent);
    }

    public a e0() {
        g gVar = (g) d0();
        gVar.j();
        return gVar.f3998h;
    }

    public <T extends View> T findViewById(int i2) {
        g gVar = (g) d0();
        gVar.f();
        return gVar.f3995e.findViewById(i2);
    }

    public MenuInflater getMenuInflater() {
        g gVar = (g) d0();
        if (gVar.f3999i == null) {
            gVar.j();
            a aVar = gVar.f3998h;
            gVar.f3999i = new d.b.o.f(aVar != null ? aVar.c() : gVar.f3994d);
        }
        return gVar.f3999i;
    }

    public Resources getResources() {
        if (this.q == null) {
            c1.a();
        }
        Resources resources = this.q;
        return resources == null ? super.getResources() : resources;
    }

    public void invalidateOptionsMenu() {
        d0().b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.q != null) {
            this.q.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        g gVar = (g) d0();
        if (gVar.z && gVar.t) {
            gVar.j();
            a aVar = gVar.f3998h;
            if (aVar != null) {
                aVar.a(configuration);
            }
        }
        j.a().a(gVar.f3994d);
        gVar.a(false);
    }

    public void onContentChanged() {
    }

    public void onCreate(Bundle bundle) {
        f d0 = d0();
        d0.a();
        d0.a(bundle);
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        g gVar = (g) d0();
        if (gVar != null) {
            f.b((f) gVar);
            if (gVar.S) {
                gVar.f3995e.getDecorView().removeCallbacks(gVar.U);
            }
            gVar.K = false;
            gVar.L = true;
            a aVar = gVar.f3998h;
            C0023g gVar2 = gVar.Q;
            if (gVar2 != null) {
                gVar2.a();
            }
            C0023g gVar3 = gVar.R;
            if (gVar3 != null) {
                gVar3.a();
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            r2 = 1
            if (r0 >= r1) goto L_0x003f
            boolean r0 = r5.isCtrlPressed()
            if (r0 != 0) goto L_0x003f
            int r0 = r5.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003f
            int r0 = r5.getRepeatCount()
            if (r0 != 0) goto L_0x003f
            int r0 = r5.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003f
            android.view.Window r0 = r3.getWindow()
            if (r0 == 0) goto L_0x003f
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003f
            android.view.View r0 = r0.getDecorView()
            boolean r0 = r0.dispatchKeyShortcutEvent(r5)
            if (r0 == 0) goto L_0x003f
            r0 = r2
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0043
            return r2
        L_0x0043:
            boolean r4 = super.onKeyDown(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.k.d.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        boolean z = true;
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a e0 = e0();
        if (menuItem.getItemId() != 16908332 || e0 == null || (e0.b() & 4) == 0) {
            return false;
        }
        Intent a2 = a.a.a.a.b.a.a((Activity) this);
        if (a2 == null) {
            z = false;
        } else if (shouldUpRecreateTask(a2)) {
            ArrayList arrayList = new ArrayList();
            Intent z2 = z();
            if (z2 == null) {
                z2 = a.a.a.a.b.a.a((Activity) this);
            }
            if (z2 != null) {
                ComponentName component = z2.getComponent();
                if (component == null) {
                    component = z2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent a3 = a.a.a.a.b.a.a((Context) this, component);
                    while (a3 != null) {
                        arrayList.add(size, a3);
                        a3 = a.a.a.a.b.a.a((Context) this, a3.getComponent());
                    }
                    arrayList.add(z2);
                } catch (NameNotFoundException e2) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e2);
                }
            }
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                d.h.e.a.a(this, intentArr, null);
                try {
                    d.h.d.a.a(this);
                } catch (IllegalStateException unused) {
                    finish();
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            navigateUpTo(a2);
        }
        return z;
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((g) d0()).f();
    }

    public void onPostResume() {
        super.onPostResume();
        g gVar = (g) d0();
        gVar.j();
        a aVar = gVar.f3998h;
        if (aVar != null) {
            aVar.c(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        g gVar = (g) d0();
        if (gVar.M != -100) {
            g.Z.put(gVar.f3993c.getClass(), Integer.valueOf(gVar.M));
        }
    }

    public void onStart() {
        super.onStart();
        g gVar = (g) d0();
        gVar.K = true;
        gVar.d();
        f.a((f) gVar);
    }

    public void onStop() {
        super.onStop();
        d0().c();
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        d0().a(charSequence);
    }

    public void openOptionsMenu() {
        a e0 = e0();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i2) {
        d0().b(i2);
    }

    public void setTheme(int i2) {
        super.setTheme(i2);
        ((g) d0()).N = i2;
    }

    public Intent z() {
        return a.a.a.a.b.a.a((Activity) this);
    }

    public void setContentView(View view) {
        d0().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        d0().b(view, layoutParams);
    }
}
