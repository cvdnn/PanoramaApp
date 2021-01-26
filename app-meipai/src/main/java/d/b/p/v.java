package d.b.p;

import android.annotation.SuppressLint;
import android.view.View;
import d.b.o.i.p;
import d.b.p.w.d;

/* compiled from: AppCompatSpinner */
public class v extends h0 {

    /* renamed from: j reason: collision with root package name */
    public final /* synthetic */ d f4455j;
    public final /* synthetic */ w k;

    public v(w wVar, View view, d dVar) {
        this.k = wVar;
        this.f4455j = dVar;
        super(view);
    }

    public p b() {
        return this.f4455j;
    }

    @SuppressLint({"SyntheticAccessor"})
    public boolean c() {
        if (!this.k.getInternalPopup().a()) {
            this.k.a();
        }
        return true;
    }
}
