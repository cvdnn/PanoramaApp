package d.b.o.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import d.b.o.i.n.a;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class f extends BaseAdapter {

    /* renamed from: a reason: collision with root package name */
    public g f4192a;

    /* renamed from: b reason: collision with root package name */
    public int f4193b = -1;

    /* renamed from: c reason: collision with root package name */
    public boolean f4194c;

    /* renamed from: d reason: collision with root package name */
    public final boolean f4195d;

    /* renamed from: e reason: collision with root package name */
    public final LayoutInflater f4196e;

    /* renamed from: f reason: collision with root package name */
    public final int f4197f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f4195d = z;
        this.f4196e = layoutInflater;
        this.f4192a = gVar;
        this.f4197f = i2;
        a();
    }

    public void a() {
        g gVar = this.f4192a;
        i iVar = gVar.w;
        if (iVar != null) {
            gVar.a();
            ArrayList<i> arrayList = gVar.f4207j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((i) arrayList.get(i2)) == iVar) {
                    this.f4193b = i2;
                    return;
                }
            }
        }
        this.f4193b = -1;
    }

    public int getCount() {
        ArrayList<i> arrayList;
        if (this.f4195d) {
            g gVar = this.f4192a;
            gVar.a();
            arrayList = gVar.f4207j;
        } else {
            arrayList = this.f4192a.d();
        }
        if (this.f4193b < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4196e.inflate(this.f4197f, viewGroup, false);
        }
        int i3 = getItem(i2).f4212b;
        int i4 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f4192a.e() && i3 != (i4 >= 0 ? getItem(i4).f4212b : i3));
        a aVar = (a) view;
        if (this.f4194c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public i getItem(int i2) {
        ArrayList<i> arrayList;
        if (this.f4195d) {
            g gVar = this.f4192a;
            gVar.a();
            arrayList = gVar.f4207j;
        } else {
            arrayList = this.f4192a.d();
        }
        int i3 = this.f4193b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (i) arrayList.get(i2);
    }
}
