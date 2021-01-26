package d.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;
import d.r.d.k.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
public class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ArrayList f5315a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ k f5316b;

    public c(k kVar, ArrayList arrayList) {
        this.f5316b = kVar;
        this.f5315a = arrayList;
    }

    public void run() {
        Iterator it = this.f5315a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            k kVar = this.f5316b;
            d0 d0Var = bVar.f5352a;
            int i2 = bVar.f5353b;
            int i3 = bVar.f5354c;
            int i4 = bVar.f5355d;
            int i5 = bVar.f5356e;
            if (kVar != null) {
                View view = d0Var.itemView;
                int i6 = i4 - i2;
                int i7 = i5 - i3;
                if (i6 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i7 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                kVar.p.add(d0Var);
                ViewPropertyAnimator duration = animate.setDuration(kVar.f1037e);
                h hVar = new h(kVar, d0Var, i6, view, i7, animate);
                duration.setListener(hVar).start();
            } else {
                throw null;
            }
        }
        this.f5315a.clear();
        this.f5316b.m.remove(this.f5315a);
    }
}
