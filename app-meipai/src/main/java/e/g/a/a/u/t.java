package e.g.a.a.u;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import d.r.d.o;

/* compiled from: SmoothCalendarLayoutManager */
public class t extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager */
    public class a extends o {
        public a(t tVar, Context context) {
            super(context);
        }

        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public t(Context context, int i2, boolean z) {
        super(context, i2, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, a0 a0Var, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.setTargetPosition(i2);
        startSmoothScroll(aVar);
    }
}
