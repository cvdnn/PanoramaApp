package d.t;

import android.view.View;
import android.view.ViewGroup;
import d.t.i.d;

/* compiled from: Visibility */
public class c0 extends l {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5457a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ View f5458b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ View f5459c;

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ d0 f5460d;

    public c0(d0 d0Var, ViewGroup viewGroup, View view, View view2) {
        this.f5460d = d0Var;
        this.f5457a = viewGroup;
        this.f5458b = view;
        this.f5459c = view2;
    }

    public void b(i iVar) {
        this.f5457a.getOverlay().remove(this.f5458b);
    }

    public void c(i iVar) {
        this.f5459c.setTag(f.save_overlay_view, null);
        this.f5457a.getOverlay().remove(this.f5458b);
        iVar.b((d) this);
    }

    public void e(i iVar) {
        if (this.f5458b.getParent() == null) {
            this.f5457a.getOverlay().add(this.f5458b);
        } else {
            this.f5460d.cancel();
        }
    }
}
