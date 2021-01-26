package d.b.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import d.b.o.a.C0026a;
import d.b.o.i.j;
import d.b.o.i.o;
import d.e.h;
import d.h.g.a.b;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public class e extends ActionMode {

    /* renamed from: a reason: collision with root package name */
    public final Context f4106a;

    /* renamed from: b reason: collision with root package name */
    public final a f4107b;

    /* compiled from: SupportActionModeWrapper */
    public static class a implements C0026a {

        /* renamed from: a reason: collision with root package name */
        public final Callback f4108a;

        /* renamed from: b reason: collision with root package name */
        public final Context f4109b;

        /* renamed from: c reason: collision with root package name */
        public final ArrayList<e> f4110c = new ArrayList<>();

        /* renamed from: d reason: collision with root package name */
        public final h<Menu, Menu> f4111d = new h<>();

        public a(Context context, Callback callback) {
            this.f4109b = context;
            this.f4108a = callback;
        }

        public boolean a(a aVar, Menu menu) {
            return this.f4108a.onCreateActionMode(b(aVar), a(menu));
        }

        public boolean b(a aVar, Menu menu) {
            return this.f4108a.onPrepareActionMode(b(aVar), a(menu));
        }

        public boolean a(a aVar, MenuItem menuItem) {
            return this.f4108a.onActionItemClicked(b(aVar), new j(this.f4109b, (b) menuItem));
        }

        public ActionMode b(a aVar) {
            int size = this.f4110c.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.f4110c.get(i2);
                if (eVar != null && eVar.f4107b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f4109b, aVar);
            this.f4110c.add(eVar2);
            return eVar2;
        }

        public void a(a aVar) {
            this.f4108a.onDestroyActionMode(b(aVar));
        }

        public final Menu a(Menu menu) {
            Menu menu2 = (Menu) this.f4111d.getOrDefault(menu, null);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f4109b, (d.h.g.a.a) menu);
            this.f4111d.put(menu, oVar);
            return oVar;
        }
    }

    public e(Context context, a aVar) {
        this.f4106a = context;
        this.f4107b = aVar;
    }

    public void finish() {
        this.f4107b.a();
    }

    public View getCustomView() {
        return this.f4107b.b();
    }

    public Menu getMenu() {
        return new o(this.f4106a, (d.h.g.a.a) this.f4107b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f4107b.d();
    }

    public CharSequence getSubtitle() {
        return this.f4107b.e();
    }

    public Object getTag() {
        return this.f4107b.f4094a;
    }

    public CharSequence getTitle() {
        return this.f4107b.f();
    }

    public boolean getTitleOptionalHint() {
        return this.f4107b.f4095b;
    }

    public void invalidate() {
        this.f4107b.g();
    }

    public boolean isTitleOptional() {
        return this.f4107b.h();
    }

    public void setCustomView(View view) {
        this.f4107b.a(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4107b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.f4107b.f4094a = obj;
    }

    public void setTitle(CharSequence charSequence) {
        this.f4107b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f4107b.a(z);
    }

    public void setSubtitle(int i2) {
        this.f4107b.a(i2);
    }

    public void setTitle(int i2) {
        this.f4107b.b(i2);
    }
}
