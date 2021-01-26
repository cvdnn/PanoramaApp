package d.f.a.h;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ResolutionNode */
public class l {

    /* renamed from: a reason: collision with root package name */
    public HashSet<l> f4725a = new HashSet<>(2);

    /* renamed from: b reason: collision with root package name */
    public int f4726b = 0;

    public void a() {
        this.f4726b = 1;
        Iterator it = this.f4725a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).d();
        }
    }

    public void b() {
        this.f4726b = 0;
        Iterator it = this.f4725a.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b();
        }
    }

    public boolean c() {
        return this.f4726b == 1;
    }

    public void d() {
    }
}
