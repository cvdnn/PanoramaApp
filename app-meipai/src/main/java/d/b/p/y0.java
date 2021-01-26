package d.b.p;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;
import d.b.o.i.a;

/* compiled from: ToolbarWidgetWrapper */
public class y0 implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final a f4502a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ z0 f4503b;

    public y0(z0 z0Var) {
        this.f4503b = z0Var;
        a aVar = new a(this.f4503b.f4508a.getContext(), 0, 16908332, 0, 0, this.f4503b.f4516i);
        this.f4502a = aVar;
    }

    public void onClick(View view) {
        z0 z0Var = this.f4503b;
        Callback callback = z0Var.l;
        if (callback != null && z0Var.m) {
            callback.onMenuItemSelected(0, this.f4502a);
        }
    }
}
