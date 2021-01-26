package d.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.d0;
import d.r.d.k.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DefaultItemAnimator */
public class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ArrayList f5317a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ k f5318b;

    public d(k kVar, ArrayList arrayList) {
        this.f5318b = kVar;
        this.f5317a = arrayList;
    }

    public void run() {
        View view;
        Iterator it = this.f5317a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            k kVar = this.f5318b;
            View view2 = null;
            if (kVar != null) {
                d0 d0Var = aVar.f5346a;
                if (d0Var == null) {
                    view = null;
                } else {
                    view = d0Var.itemView;
                }
                d0 d0Var2 = aVar.f5347b;
                if (d0Var2 != null) {
                    view2 = d0Var2.itemView;
                }
                if (view != null) {
                    ViewPropertyAnimator duration = view.animate().setDuration(kVar.f1038f);
                    kVar.r.add(aVar.f5346a);
                    duration.translationX((float) (aVar.f5350e - aVar.f5348c));
                    duration.translationY((float) (aVar.f5351f - aVar.f5349d));
                    duration.alpha(0.0f).setListener(new i(kVar, aVar, duration, view)).start();
                }
                if (view2 != null) {
                    ViewPropertyAnimator animate = view2.animate();
                    kVar.r.add(aVar.f5347b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(kVar.f1038f).alpha(1.0f).setListener(new j(kVar, aVar, animate, view2)).start();
                }
            } else {
                throw null;
            }
        }
        this.f5317a.clear();
        this.f5318b.n.remove(this.f5317a);
    }
}
