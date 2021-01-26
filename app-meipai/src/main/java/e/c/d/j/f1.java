package e.c.d.j;

import e.c.d.l.c.h;
import e.c.d.l.c.h.c;
import e.c.d.l.c.h.d;
import e.c.d.n.e;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BaseTaskManager */
public class f1 {

    /* renamed from: a reason: collision with root package name */
    public ExecutorService f6254a = Executors.newSingleThreadExecutor();

    /* renamed from: b reason: collision with root package name */
    public boolean f6255b = true;

    /* renamed from: c reason: collision with root package name */
    public c f6256c = new a(this);

    public /* synthetic */ void a(d dVar) {
        this.f6254a.execute(new b(this, dVar));
    }

    public /* synthetic */ void b(d dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[BaseTaskManager][netChange]type:");
        sb.append(dVar);
        sb.toString();
        if (dVar != d.NONE) {
            if (this.f6255b) {
                this.f6255b = false;
                d();
                return;
            }
            c();
        }
    }

    public void c() {
        throw null;
    }

    public void d() {
        throw null;
    }

    public void a() {
        this.f6255b = true;
        h c2 = h.c();
        c cVar = this.f6256c;
        if (!c2.f6389d.contains(cVar)) {
            c2.f6389d.registerObserver(cVar);
            cVar.a(c2.f6391f);
        }
    }

    public boolean b() {
        if (h.c().f6391f == d.NONE) {
            return false;
        }
        if (h.c().f6391f != d.CELLULAR) {
            return true;
        }
        return e.a("is_allow_cellular", false, true);
    }
}
