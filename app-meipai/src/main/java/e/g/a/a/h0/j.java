package e.g.a.a.h0;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: DropdownMenuEndIconDelegate */
public class j implements OnFocusChangeListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ h f8185a;

    public j(h hVar) {
        this.f8185a = hVar;
    }

    public void onFocusChange(View view, boolean z) {
        this.f8185a.f8189a.setEndIconActivated(z);
        if (!z) {
            h.a(this.f8185a, false);
            this.f8185a.f8173g = false;
        }
    }
}
