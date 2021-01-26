package e.g.a.a.u;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MaterialCalendar */
public class l implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ q f8365a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f8366b;

    public l(f fVar, q qVar) {
        this.f8366b = fVar;
        this.f8365a = qVar;
    }

    public void onClick(View view) {
        int findLastVisibleItemPosition = this.f8366b.a().findLastVisibleItemPosition() - 1;
        if (findLastVisibleItemPosition >= 0) {
            this.f8366b.a(this.f8365a.a(findLastVisibleItemPosition));
        }
    }
}
