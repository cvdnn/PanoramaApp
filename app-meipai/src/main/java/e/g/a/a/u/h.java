package e.g.a.a.u;

import android.view.View;
import d.h.k.a;
import d.h.k.w.b;
import e.g.a.a.i;

/* compiled from: MaterialCalendar */
public class h extends a {

    /* renamed from: d reason: collision with root package name */
    public final /* synthetic */ f f8358d;

    public h(f fVar) {
        this.f8358d = fVar;
    }

    public void a(View view, b bVar) {
        String str;
        this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
        if (this.f8358d.k.getVisibility() == 0) {
            str = this.f8358d.getString(i.mtrl_picker_toggle_to_year_selection);
        } else {
            str = this.f8358d.getString(i.mtrl_picker_toggle_to_day_selection);
        }
        bVar.a((CharSequence) str);
    }
}
