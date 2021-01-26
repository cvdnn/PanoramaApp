package d.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
public class e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ArrayList f5319a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ k f5320b;

    public e(k kVar, ArrayList arrayList) {
        this.f5320b = kVar;
        this.f5319a = arrayList;
    }

    public void run() {
        Iterator it = this.f5319a.iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            k kVar = this.f5320b;
            if (kVar != null) {
                View view = d0Var.itemView;
                ViewPropertyAnimator animate = view.animate();
                kVar.o.add(d0Var);
                animate.alpha(1.0f).setDuration(kVar.f1035c).setListener(new g(kVar, d0Var, view, animate)).start();
            } else {
                throw null;
            }
        }
        this.f5319a.clear();
        this.f5320b.l.remove(this.f5319a);
    }
}
