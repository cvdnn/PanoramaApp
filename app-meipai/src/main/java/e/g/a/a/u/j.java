package e.g.a.a.u;

import android.view.View;
import android.view.View.OnClickListener;
import e.g.a.a.u.f.e;

/* compiled from: MaterialCalendar */
public class j implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ f f8362a;

    public j(f fVar) {
        this.f8362a = fVar;
    }

    public void onClick(View view) {
        f fVar = this.f8362a;
        e eVar = fVar.f8342f;
        if (eVar == e.YEAR) {
            fVar.a(e.DAY);
        } else if (eVar == e.DAY) {
            fVar.a(e.YEAR);
        }
    }
}
