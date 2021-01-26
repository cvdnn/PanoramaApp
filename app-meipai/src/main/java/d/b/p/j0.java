package d.b.p;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ListPopupWindow */
public class j0 implements OnItemSelectedListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ k0 f4376a;

    public j0(k0 k0Var) {
        this.f4376a = k0Var;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (i2 != -1) {
            f0 f0Var = this.f4376a.f4382c;
            if (f0Var != null) {
                f0Var.setListSelectionHidden(false);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
