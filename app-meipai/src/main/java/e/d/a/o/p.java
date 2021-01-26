package e.d.a.o;

import e.d.a.r.h.h;
import e.d.a.t.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker */
public final class p implements i {

    /* renamed from: a reason: collision with root package name */
    public final Set<h<?>> f7837a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7837a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).a();
        }
    }

    public void b() {
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7837a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).b();
        }
    }

    public void onStart() {
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7837a)).iterator();
        while (it.hasNext()) {
            ((h) it.next()).onStart();
        }
    }
}
