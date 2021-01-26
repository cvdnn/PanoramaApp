package e.g.a.a.u;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MaterialCalendar */
public class k implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ q f8363a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ f f8364b;

    public k(f fVar, q qVar) {
        this.f8364b = fVar;
        this.f8363a = qVar;
    }

    public void onClick(View view) {
        int findFirstVisibleItemPosition = this.f8364b.a().findFirstVisibleItemPosition() + 1;
        if (findFirstVisibleItemPosition < this.f8364b.f8345i.getAdapter().getItemCount()) {
            this.f8364b.a(this.f8363a.a(findFirstVisibleItemPosition));
        }
    }
}
