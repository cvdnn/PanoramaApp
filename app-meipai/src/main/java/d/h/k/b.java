package d.h.k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionProvider */
public abstract class b {

    /* renamed from: a reason: collision with root package name */
    public a f4912a;

    /* compiled from: ActionProvider */
    public interface a {
    }

    public b(Context context) {
    }

    public View a(MenuItem menuItem) {
        return ((d.b.o.i.j.a) this).f4224b.onCreateActionView();
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void a(a aVar) {
        if (!(this.f4912a == null || aVar == null)) {
            StringBuilder a2 = e.a.a.a.a.a("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            a2.append(getClass().getSimpleName());
            a2.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", a2.toString());
        }
        this.f4912a = aVar;
    }
}
