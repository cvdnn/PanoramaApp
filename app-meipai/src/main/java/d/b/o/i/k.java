package d.b.o.i;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: MenuPopup */
public abstract class k implements p, m, OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    public Rect f4232a;

    public static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i3 = 0;
        int i4 = 0;
        View view = null;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    public static boolean b(g gVar) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i2);

    public void a(Context context, g gVar) {
    }

    public abstract void a(View view);

    public abstract void a(OnDismissListener onDismissListener);

    public abstract void a(g gVar);

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public abstract void b(int i2);

    public abstract void b(boolean z);

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public abstract void c(int i2);

    public abstract void c(boolean z);

    public boolean c() {
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        f fVar;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            fVar = (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            fVar = (f) listAdapter;
        }
        fVar.f4192a.a((MenuItem) listAdapter.getItem(i2), (m) this, c() ? 0 : 4);
    }
}
