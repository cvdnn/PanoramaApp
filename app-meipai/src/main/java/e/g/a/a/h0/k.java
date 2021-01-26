package e.g.a.a.h0;

import android.widget.AutoCompleteTextView.OnDismissListener;

/* compiled from: DropdownMenuEndIconDelegate */
public class k implements OnDismissListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ h f8186a;

    public k(h hVar) {
        this.f8186a = hVar;
    }

    public void onDismiss() {
        h hVar = this.f8186a;
        hVar.f8173g = true;
        hVar.f8175i = System.currentTimeMillis();
        h.a(this.f8186a, false);
    }
}
