package e.g.a.a.u;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import com.google.android.material.button.MaterialButton;
import d.h.k.m;
import d.r.d.p;
import e.g.a.a.g;
import e.g.a.a.h;

/* compiled from: MaterialCalendar */
public final class f<S> extends s<S> {
    public static final Object l = "MONTHS_VIEW_GROUP_TAG";
    public static final Object m = "NAVIGATION_PREV_TAG";
    public static final Object n = "NAVIGATION_NEXT_TAG";
    public static final Object o = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b reason: collision with root package name */
    public int f8338b;

    /* renamed from: c reason: collision with root package name */
    public d<S> f8339c;

    /* renamed from: d reason: collision with root package name */
    public a f8340d;

    /* renamed from: e reason: collision with root package name */
    public n f8341e;

    /* renamed from: f reason: collision with root package name */
    public e f8342f;

    /* renamed from: g reason: collision with root package name */
    public c f8343g;

    /* renamed from: h reason: collision with root package name */
    public RecyclerView f8344h;

    /* renamed from: i reason: collision with root package name */
    public RecyclerView f8345i;

    /* renamed from: j reason: collision with root package name */
    public View f8346j;
    public View k;

    /* compiled from: MaterialCalendar */
    public class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f8347a;

        public a(int i2) {
            this.f8347a = i2;
        }

        public void run() {
            f.this.f8345i.smoothScrollToPosition(this.f8347a);
        }
    }

    /* compiled from: MaterialCalendar */
    public class b extends d.h.k.a {
        public b(f fVar) {
        }

        public void a(View view, d.h.k.w.b bVar) {
            this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
            bVar.a((Object) null);
        }
    }

    /* compiled from: MaterialCalendar */
    public class c extends t {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f8349a;

        public c(Context context, int i2, boolean z, int i3) {
            this.f8349a = i3;
            super(context, i2, z);
        }

        public void calculateExtraLayoutSpace(a0 a0Var, int[] iArr) {
            if (this.f8349a == 0) {
                iArr[0] = f.this.f8345i.getWidth();
                iArr[1] = f.this.f8345i.getWidth();
                return;
            }
            iArr[0] = f.this.f8345i.getHeight();
            iArr[1] = f.this.f8345i.getHeight();
        }
    }

    /* compiled from: MaterialCalendar */
    public class d implements C0113f {
        public d() {
        }
    }

    /* compiled from: MaterialCalendar */
    public enum e {
        DAY,
        YEAR
    }

    /* renamed from: e.g.a.a.u.f$f reason: collision with other inner class name */
    /* compiled from: MaterialCalendar */
    public interface C0113f {
    }

    public void a(n nVar) {
        q qVar = (q) this.f8345i.getAdapter();
        int b2 = qVar.f8380a.f8314a.b(nVar);
        int a2 = b2 - qVar.a(this.f8341e);
        boolean z = true;
        boolean z2 = Math.abs(a2) > 3;
        if (a2 <= 0) {
            z = false;
        }
        this.f8341e = nVar;
        if (z2 && z) {
            this.f8345i.scrollToPosition(b2 - 3);
            a(b2);
        } else if (z2) {
            this.f8345i.scrollToPosition(b2 + 3);
            a(b2);
        } else {
            a(b2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f8338b = bundle.getInt("THEME_RES_ID_KEY");
        this.f8339c = (d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f8340d = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f8341e = (n) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f8338b);
        this.f8343g = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        n nVar = this.f8340d.f8314a;
        if (m.a(contextThemeWrapper)) {
            i3 = h.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = h.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(e.g.a.a.f.mtrl_calendar_days_of_week);
        m.a((View) gridView, (d.h.k.a) new b(this));
        gridView.setAdapter(new e());
        gridView.setNumColumns(nVar.f8371e);
        gridView.setEnabled(false);
        this.f8345i = (RecyclerView) inflate.findViewById(e.g.a.a.f.mtrl_calendar_months);
        c cVar = new c(getContext(), i2, false, i2);
        this.f8345i.setLayoutManager(cVar);
        this.f8345i.setTag(l);
        q qVar = new q(contextThemeWrapper, this.f8339c, this.f8340d, new d());
        this.f8345i.setAdapter(qVar);
        int integer = contextThemeWrapper.getResources().getInteger(g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(e.g.a.a.f.mtrl_calendar_year_selector_frame);
        this.f8344h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f8344h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f8344h.setAdapter(new v(this));
            this.f8344h.addItemDecoration(new g(this));
        }
        if (inflate.findViewById(e.g.a.a.f.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(e.g.a.a.f.month_navigation_fragment_toggle);
            materialButton.setTag(o);
            m.a((View) materialButton, (d.h.k.a) new h(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(e.g.a.a.f.month_navigation_previous);
            materialButton2.setTag(m);
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(e.g.a.a.f.month_navigation_next);
            materialButton3.setTag(n);
            this.f8346j = inflate.findViewById(e.g.a.a.f.mtrl_calendar_year_selector_frame);
            this.k = inflate.findViewById(e.g.a.a.f.mtrl_calendar_day_selector_frame);
            a(e.DAY);
            materialButton.setText(this.f8341e.f8368b);
            this.f8345i.addOnScrollListener(new i(this, qVar, materialButton));
            materialButton.setOnClickListener(new j(this));
            materialButton3.setOnClickListener(new k(this, qVar));
            materialButton2.setOnClickListener(new l(this, qVar));
        }
        if (!m.a(contextThemeWrapper)) {
            new p().attachToRecyclerView(this.f8345i);
        }
        this.f8345i.scrollToPosition(qVar.a(this.f8341e));
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f8338b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f8339c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f8340d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f8341e);
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(e.g.a.a.d.mtrl_calendar_day_height);
    }

    public void a(e eVar) {
        this.f8342f = eVar;
        if (eVar == e.YEAR) {
            this.f8344h.getLayoutManager().scrollToPosition(((v) this.f8344h.getAdapter()).a(this.f8341e.f8370d));
            this.f8346j.setVisibility(0);
            this.k.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f8346j.setVisibility(8);
            this.k.setVisibility(0);
            a(this.f8341e);
        }
    }

    public final void a(int i2) {
        this.f8345i.post(new a(i2));
    }

    public LinearLayoutManager a() {
        return (LinearLayoutManager) this.f8345i.getLayoutManager();
    }
}
