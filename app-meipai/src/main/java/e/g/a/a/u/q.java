package e.g.a.a.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import androidx.recyclerview.widget.RecyclerView.o;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import d.h.k.m;
import e.g.a.a.d;
import e.g.a.a.f;
import e.g.a.a.h;
import e.g.a.a.u.f.C0113f;

/* compiled from: MonthsPagerAdapter */
public class q extends g<a> {

    /* renamed from: a reason: collision with root package name */
    public final a f8380a;

    /* renamed from: b reason: collision with root package name */
    public final d<?> f8381b;

    /* renamed from: c reason: collision with root package name */
    public final C0113f f8382c;

    /* renamed from: d reason: collision with root package name */
    public final int f8383d;

    /* compiled from: MonthsPagerAdapter */
    public static class a extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final TextView f8384a;

        /* renamed from: b reason: collision with root package name */
        public final MaterialCalendarGridView f8385b;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(f.month_title);
            this.f8384a = textView;
            m.a((View) textView, true);
            this.f8385b = (MaterialCalendarGridView) linearLayout.findViewById(f.month_grid);
            if (!z) {
                this.f8384a.setVisibility(8);
            }
        }
    }

    public q(Context context, d<?> dVar, a aVar, C0113f fVar) {
        n nVar = aVar.f8314a;
        n nVar2 = aVar.f8315b;
        n nVar3 = aVar.f8316c;
        if (nVar.compareTo(nVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (nVar3.compareTo(nVar2) <= 0) {
            this.f8383d = (f.a(context) * o.f8373e) + (m.a(context) ? context.getResources().getDimensionPixelSize(d.mtrl_calendar_day_height) : 0);
            this.f8380a = aVar;
            this.f8381b = dVar;
            this.f8382c = fVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public n a(int i2) {
        return this.f8380a.f8314a.a(i2);
    }

    public int getItemCount() {
        return this.f8380a.f8319f;
    }

    public long getItemId(int i2) {
        return this.f8380a.f8314a.a(i2).f8367a.getTimeInMillis();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        a aVar = (a) d0Var;
        n a2 = this.f8380a.f8314a.a(i2);
        aVar.f8384a.setText(a2.f8368b);
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.f8385b.findViewById(f.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !a2.equals(materialCalendarGridView.getAdapter().f8374a)) {
            o oVar = new o(a2, this.f8381b, this.f8380a);
            materialCalendarGridView.setNumColumns(a2.f8371e);
            materialCalendarGridView.setAdapter((ListAdapter) oVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new p(this, materialCalendarGridView));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_month_labeled, viewGroup, false);
        if (!m.a(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new o(-1, this.f8383d));
        return new a(linearLayout, true);
    }

    public int a(n nVar) {
        return this.f8380a.f8314a.b(nVar);
    }
}
