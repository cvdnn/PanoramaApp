package d.b.o.i;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController.b;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ExpandedMenuView;
import d.b.g;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class e implements m, OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    public Context f4181a;

    /* renamed from: b reason: collision with root package name */
    public LayoutInflater f4182b;

    /* renamed from: c reason: collision with root package name */
    public g f4183c;

    /* renamed from: d reason: collision with root package name */
    public ExpandedMenuView f4184d;

    /* renamed from: e reason: collision with root package name */
    public int f4185e;

    /* renamed from: f reason: collision with root package name */
    public int f4186f = 0;

    /* renamed from: g reason: collision with root package name */
    public int f4187g;

    /* renamed from: h reason: collision with root package name */
    public d.b.o.i.m.a f4188h;

    /* renamed from: i reason: collision with root package name */
    public a f4189i;

    /* compiled from: ListMenuPresenter */
    public class a extends BaseAdapter {

        /* renamed from: a reason: collision with root package name */
        public int f4190a = -1;

        public a() {
            a();
        }

        public void a() {
            g gVar = e.this.f4183c;
            i iVar = gVar.w;
            if (iVar != null) {
                gVar.a();
                ArrayList<i> arrayList = gVar.f4207j;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((i) arrayList.get(i2)) == iVar) {
                        this.f4190a = i2;
                        return;
                    }
                }
            }
            this.f4190a = -1;
        }

        public int getCount() {
            g gVar = e.this.f4183c;
            gVar.a();
            int size = gVar.f4207j.size() - e.this.f4185e;
            return this.f4190a < 0 ? size : size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f4182b.inflate(eVar.f4187g, viewGroup, false);
            }
            ((d.b.o.i.n.a) view).a(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        public i getItem(int i2) {
            g gVar = e.this.f4183c;
            gVar.a();
            ArrayList<i> arrayList = gVar.f4207j;
            int i3 = i2 + e.this.f4185e;
            int i4 = this.f4190a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return (i) arrayList.get(i3);
        }
    }

    public e(Context context, int i2) {
        this.f4187g = i2;
        this.f4181a = context;
        this.f4182b = LayoutInflater.from(context);
    }

    public void a(Context context, g gVar) {
        if (this.f4186f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f4186f);
            this.f4181a = contextThemeWrapper;
            this.f4182b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f4181a != null) {
            this.f4181a = context;
            if (this.f4182b == null) {
                this.f4182b = LayoutInflater.from(context);
            }
        }
        this.f4183c = gVar;
        a aVar = this.f4189i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f4183c.a((MenuItem) this.f4189i.getItem(i2), (m) this, 0);
    }

    public ListAdapter a() {
        if (this.f4189i == null) {
            this.f4189i = new a();
        }
        return this.f4189i;
    }

    public void a(boolean z) {
        a aVar = this.f4189i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(d.b.o.i.m.a aVar) {
        this.f4188h = aVar;
    }

    public boolean a(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        h hVar = new h(rVar);
        g gVar = hVar.f4208a;
        androidx.appcompat.app.AlertDialog.a aVar = new androidx.appcompat.app.AlertDialog.a(gVar.f4198a);
        e eVar = new e(aVar.f698a.f686a, g.abc_list_menu_item_layout);
        hVar.f4210c = eVar;
        eVar.f4188h = hVar;
        g gVar2 = hVar.f4208a;
        gVar2.a((m) eVar, gVar2.f4198a);
        ListAdapter a2 = hVar.f4210c.a();
        b bVar = aVar.f698a;
        bVar.l = a2;
        bVar.m = hVar;
        View view = gVar.o;
        if (view != null) {
            bVar.f692g = view;
        } else {
            bVar.f689d = gVar.n;
            bVar.f691f = gVar.m;
        }
        aVar.f698a.k = hVar;
        AlertDialog a3 = aVar.a();
        hVar.f4209b = a3;
        a3.setOnDismissListener(hVar);
        LayoutParams attributes = hVar.f4209b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        hVar.f4209b.show();
        d.b.o.i.m.a aVar2 = this.f4188h;
        if (aVar2 != null) {
            aVar2.a(rVar);
        }
        return true;
    }

    public void a(g gVar, boolean z) {
        d.b.o.i.m.a aVar = this.f4188h;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }
}
