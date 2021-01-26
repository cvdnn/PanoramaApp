package e.g.a.a.u;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import e.c.f.n.n;
import e.g.a.a.h;
import e.g.a.a.i;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: YearGridAdapter */
public class v extends g<a> {

    /* renamed from: a reason: collision with root package name */
    public final f<?> f8389a;

    /* compiled from: YearGridAdapter */
    public static class a extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final TextView f8390a;

        public a(TextView textView) {
            super(textView);
            this.f8390a = textView;
        }
    }

    public v(f<?> fVar) {
        this.f8389a = fVar;
    }

    public int a(int i2) {
        return i2 - this.f8389a.f8340d.f8314a.f8370d;
    }

    public int getItemCount() {
        return this.f8389a.f8340d.f8318e;
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        a aVar = (a) d0Var;
        int i3 = this.f8389a.f8340d.f8314a.f8370d + i2;
        String string = aVar.f8390a.getContext().getString(i.mtrl_picker_navigate_to_year_description);
        aVar.f8390a.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i3)}));
        aVar.f8390a.setContentDescription(String.format(string, new Object[]{Integer.valueOf(i3)}));
        c cVar = this.f8389a.f8343g;
        Calendar d2 = n.d();
        b bVar = d2.get(1) == i3 ? cVar.f8331f : cVar.f8329d;
        for (Long longValue : this.f8389a.f8339c.l()) {
            d2.setTimeInMillis(longValue.longValue());
            if (d2.get(1) == i3) {
                bVar = cVar.f8330e;
            }
        }
        bVar.a(aVar.f8390a);
        aVar.f8390a.setOnClickListener(new u(this, i3));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_year, viewGroup, false));
    }
}
