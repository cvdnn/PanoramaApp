package e.g.a.a.u;

import android.view.View;
import android.view.View.OnClickListener;
import e.c.f.n.n;
import e.g.a.a.u.f.e;
import java.util.Calendar;

/* compiled from: YearGridAdapter */
public class u implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ int f8387a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ v f8388b;

    public u(v vVar, int i2) {
        this.f8388b = vVar;
        this.f8387a = i2;
    }

    public void onClick(View view) {
        int i2 = this.f8387a;
        int i3 = this.f8388b.f8389a.f8341e.f8369c;
        Calendar e2 = n.e();
        e2.set(1, i2);
        e2.set(2, i3);
        this.f8388b.f8389a.a(new n(e2));
        this.f8388b.f8389a.a(e.DAY);
    }
}
