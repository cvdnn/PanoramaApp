package e.g.a.a.u;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.n;
import d.h.j.b;
import java.util.Calendar;

/* compiled from: MaterialCalendar */
public class g extends n {

    /* renamed from: a reason: collision with root package name */
    public final Calendar f8355a = e.c.f.n.n.e();

    /* renamed from: b reason: collision with root package name */
    public final Calendar f8356b = e.c.f.n.n.e();

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ f f8357c;

    public g(f fVar) {
        this.f8357c = fVar;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
        int i2;
        int i3;
        if ((recyclerView.getAdapter() instanceof v) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            v vVar = (v) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (b bVar : this.f8357c.f8339c.e()) {
                F f2 = bVar.f4903a;
                if (!(f2 == null || bVar.f4904b == null)) {
                    this.f8355a.setTimeInMillis(((Long) f2).longValue());
                    this.f8356b.setTimeInMillis(((Long) bVar.f4904b).longValue());
                    int a2 = vVar.a(this.f8355a.get(1));
                    int a3 = vVar.a(this.f8356b.get(1));
                    View findViewByPosition = gridLayoutManager.findViewByPosition(a2);
                    View findViewByPosition2 = gridLayoutManager.findViewByPosition(a3);
                    int i4 = gridLayoutManager.f974b;
                    int i5 = a2 / i4;
                    int i6 = a3 / i4;
                    for (int i7 = i5; i7 <= i6; i7++) {
                        View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.f974b * i7);
                        if (findViewByPosition3 != null) {
                            int top = findViewByPosition3.getTop() + this.f8357c.f8343g.f8329d.f8320a.top;
                            int bottom = findViewByPosition3.getBottom() - this.f8357c.f8343g.f8329d.f8320a.bottom;
                            if (i7 == i5) {
                                i2 = (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft();
                            } else {
                                i2 = 0;
                            }
                            if (i7 == i6) {
                                i3 = (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft();
                            } else {
                                i3 = recyclerView.getWidth();
                            }
                            Canvas canvas2 = canvas;
                            canvas2.drawRect((float) i2, (float) top, (float) i3, (float) bottom, this.f8357c.f8343g.f8333h);
                        }
                    }
                }
            }
        }
    }
}
