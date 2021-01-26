package e.d.a.o;

import e.d.a.r.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class n {

    /* renamed from: a reason: collision with root package name */
    public final Set<b> f7827a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    public final List<b> f7828b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public boolean f7829c;

    public boolean a(b bVar) {
        boolean z = true;
        if (bVar == null) {
            return true;
        }
        boolean remove = this.f7827a.remove(bVar);
        if (!this.f7828b.remove(bVar) && !remove) {
            z = false;
        }
        if (z) {
            bVar.clear();
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.f7827a.size());
        sb.append(", isPaused=");
        sb.append(this.f7829c);
        sb.append("}");
        return sb.toString();
    }
}
