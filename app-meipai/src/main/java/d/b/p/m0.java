package d.b.p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import d.b.o.i.f;
import d.b.o.i.g;
import d.b.o.i.i;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow */
public class m0 extends k0 implements l0 {
    public static Method G;
    public l0 F;

    /* compiled from: MenuPopupWindow */
    public static class a extends f0 {
        public final int o;
        public final int p;
        public l0 q;
        public MenuItem r;

        public a(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.o = 21;
                this.p = 22;
                return;
            }
            this.o = 22;
            this.p = 21;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            f fVar;
            if (this.q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    fVar = (f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                    fVar = (f) adapter;
                }
                i iVar = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        int i3 = pointToPosition - i2;
                        if (i3 >= 0 && i3 < fVar.getCount()) {
                            iVar = fVar.getItem(i3);
                        }
                    }
                }
                MenuItem menuItem = this.r;
                if (menuItem != iVar) {
                    g gVar = fVar.f4192a;
                    if (menuItem != null) {
                        this.q.b(gVar, menuItem);
                    }
                    this.r = iVar;
                    if (iVar != null) {
                        this.q.a(gVar, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.p) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((f) getAdapter()).f4192a.a(false);
                return true;
            }
        }

        public void setHoverListener(l0 l0Var) {
            this.q = l0Var;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (VERSION.SDK_INT <= 28) {
                G = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public m0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public f0 a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void b(g gVar, MenuItem menuItem) {
        l0 l0Var = this.F;
        if (l0Var != null) {
            l0Var.b(gVar, menuItem);
        }
    }

    public void a(g gVar, MenuItem menuItem) {
        l0 l0Var = this.F;
        if (l0Var != null) {
            l0Var.a(gVar, menuItem);
        }
    }
}
