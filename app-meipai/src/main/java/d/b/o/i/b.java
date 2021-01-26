package d.b.o.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import d.b.o.i.m.a;
import d.b.p.c;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter */
public abstract class b implements m {

    /* renamed from: a reason: collision with root package name */
    public Context f4151a;

    /* renamed from: b reason: collision with root package name */
    public Context f4152b;

    /* renamed from: c reason: collision with root package name */
    public g f4153c;

    /* renamed from: d reason: collision with root package name */
    public LayoutInflater f4154d;

    /* renamed from: e reason: collision with root package name */
    public a f4155e;

    /* renamed from: f reason: collision with root package name */
    public int f4156f;

    /* renamed from: g reason: collision with root package name */
    public int f4157g;

    /* renamed from: h reason: collision with root package name */
    public n f4158h;

    public b(Context context, int i2, int i3) {
        this.f4151a = context;
        this.f4154d = LayoutInflater.from(context);
        this.f4156f = i2;
        this.f4157g = i3;
    }

    public void a(boolean z) {
        int i2;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.f4158h;
        if (viewGroup != null) {
            g gVar = this.f4153c;
            if (gVar != null) {
                gVar.a();
                ArrayList d2 = this.f4153c.d();
                int size = d2.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = (i) d2.get(i3);
                    if (iVar.d()) {
                        View childAt = viewGroup.getChildAt(i2);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a2 = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.f4158h).addView(a2, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i2) == ((c) this).f4299i) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i2);
                    z2 = true;
                }
                if (!z2) {
                    i2++;
                }
            }
        }
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public void a(a aVar) {
        this.f4155e = aVar;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = (n.a) this.f4154d.inflate(this.f4157g, viewGroup, false);
        }
        c cVar = (c) this;
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) cVar.f4158h);
        if (cVar.w == null) {
            cVar.w = new d.b.p.c.b();
        }
        actionMenuItemView.setPopupCallback(cVar.w);
        return (View) aVar;
    }

    public boolean a(r rVar) {
        a aVar = this.f4155e;
        if (aVar != null) {
            return aVar.a(rVar);
        }
        return false;
    }
}
