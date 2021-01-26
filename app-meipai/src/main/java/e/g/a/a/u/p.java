package e.g.a.a.u;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import e.g.a.a.u.f.C0113f;
import e.g.a.a.u.f.d;
import java.util.Iterator;

/* compiled from: MonthsPagerAdapter */
public class p implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f8378a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ q f8379b;

    public p(q qVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f8379b = qVar;
        this.f8378a = materialCalendarGridView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        o adapter = this.f8378a.getAdapter();
        if (i2 >= adapter.a() && i2 <= adapter.b()) {
            C0113f fVar = this.f8379b.f8382c;
            long longValue = this.f8378a.getAdapter().getItem(i2).longValue();
            d dVar = (d) fVar;
            if (f.this.f8340d.f8317d.a(longValue)) {
                f.this.f8339c.b(longValue);
                Iterator it = f.this.f8386a.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).a(f.this.f8339c.m());
                }
                f.this.f8345i.getAdapter().notifyDataSetChanged();
                RecyclerView recyclerView = f.this.f8344h;
                if (recyclerView != null) {
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
