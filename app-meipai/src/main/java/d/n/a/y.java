package d.n.a;

import android.view.View;
import d.h.k.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: FragmentTransitionImpl */
public class y implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ArrayList f5258a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Map f5259b;

    public y(a0 a0Var, ArrayList arrayList, Map map) {
        this.f5258a = arrayList;
        this.f5259b = map;
    }

    public void run() {
        String str;
        int size = this.f5258a.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f5258a.get(i2);
            String s = m.s(view);
            if (s != null) {
                Iterator it = this.f5259b.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    if (s.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
