package e.d.a.o;

import e.d.a.t.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
public class a implements h {

    /* renamed from: a reason: collision with root package name */
    public final Set<i> f7802a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b reason: collision with root package name */
    public boolean f7803b;

    /* renamed from: c reason: collision with root package name */
    public boolean f7804c;

    public void a(i iVar) {
        this.f7802a.add(iVar);
        if (this.f7804c) {
            iVar.a();
        } else if (this.f7803b) {
            iVar.onStart();
        } else {
            iVar.b();
        }
    }

    public void b(i iVar) {
        this.f7802a.remove(iVar);
    }

    public void c() {
        this.f7803b = false;
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7802a)).iterator();
        while (it.hasNext()) {
            ((i) it.next()).b();
        }
    }

    public void b() {
        this.f7803b = true;
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7802a)).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    public void a() {
        this.f7804c = true;
        Iterator it = ((ArrayList) j.a((Collection<T>) this.f7802a)).iterator();
        while (it.hasNext()) {
            ((i) it.next()).a();
        }
    }
}
