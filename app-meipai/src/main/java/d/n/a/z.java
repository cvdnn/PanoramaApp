package d.n.a;

import android.view.View;
import d.h.k.m;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionImpl */
public class z implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ArrayList f5260a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Map f5261b;

    public z(a0 a0Var, ArrayList arrayList, Map map) {
        this.f5260a = arrayList;
        this.f5261b = map;
    }

    public void run() {
        int size = this.f5260a.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f5260a.get(i2);
            view.setTransitionName((String) this.f5261b.get(m.s(view)));
        }
    }
}
