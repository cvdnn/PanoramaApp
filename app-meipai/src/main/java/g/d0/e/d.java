package g.d0.e;

import g.b0;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public final Set<b0> f9207a = new LinkedHashSet();

    public synchronized void a(b0 b0Var) {
        this.f9207a.remove(b0Var);
    }

    public synchronized void b(b0 b0Var) {
        this.f9207a.add(b0Var);
    }

    public synchronized boolean c(b0 b0Var) {
        return this.f9207a.contains(b0Var);
    }
}
