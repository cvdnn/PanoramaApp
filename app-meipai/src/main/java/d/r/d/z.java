package d.r.d;

import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.l;
import d.e.e;
import d.e.h;
import d.h.j.c;
import d.h.j.d;

/* compiled from: ViewInfoStore */
public class z {

    /* renamed from: a reason: collision with root package name */
    public final h<d0, a> f5418a = new h<>();

    /* renamed from: b reason: collision with root package name */
    public final e<d0> f5419b = new e<>(10);

    /* compiled from: ViewInfoStore */
    public static class a {

        /* renamed from: d reason: collision with root package name */
        public static c<a> f5420d = new d(20);

        /* renamed from: a reason: collision with root package name */
        public int f5421a;

        /* renamed from: b reason: collision with root package name */
        public l.c f5422b;

        /* renamed from: c reason: collision with root package name */
        public l.c f5423c;

        public static a a() {
            a aVar = (a) f5420d.a();
            return aVar == null ? new a() : aVar;
        }

        public static void a(a aVar) {
            aVar.f5421a = 0;
            aVar.f5422b = null;
            aVar.f5423c = null;
            f5420d.a(aVar);
        }
    }

    /* compiled from: ViewInfoStore */
    public interface b {
    }

    public final l.c a(d0 d0Var, int i2) {
        l.c cVar;
        int a2 = this.f5418a.a((Object) d0Var);
        if (a2 < 0) {
            return null;
        }
        a aVar = (a) this.f5418a.e(a2);
        if (aVar != null) {
            int i3 = aVar.f5421a;
            if ((i3 & i2) != 0) {
                aVar.f5421a = (~i2) & i3;
                if (i2 == 4) {
                    cVar = aVar.f5422b;
                } else if (i2 == 8) {
                    cVar = aVar.f5423c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.f5421a & 12) == 0) {
                    this.f5418a.d(a2);
                    a.a(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    public void b(d0 d0Var, l.c cVar) {
        a aVar = (a) this.f5418a.getOrDefault(d0Var, null);
        if (aVar == null) {
            aVar = a.a();
            this.f5418a.put(d0Var, aVar);
        }
        aVar.f5422b = cVar;
        aVar.f5421a |= 4;
    }

    public void c(d0 d0Var) {
        a aVar = (a) this.f5418a.getOrDefault(d0Var, null);
        if (aVar != null) {
            aVar.f5421a &= -2;
        }
    }

    public void d(d0 d0Var) {
        int e2 = this.f5419b.e() - 1;
        while (true) {
            if (e2 < 0) {
                break;
            } else if (d0Var == this.f5419b.b(e2)) {
                e<d0> eVar = this.f5419b;
                Object[] objArr = eVar.f4572c;
                Object obj = objArr[e2];
                Object obj2 = e.f4569e;
                if (obj != obj2) {
                    objArr[e2] = obj2;
                    eVar.f4570a = true;
                }
            } else {
                e2--;
            }
        }
        a aVar = (a) this.f5418a.remove(d0Var);
        if (aVar != null) {
            a.a(aVar);
        }
    }

    public boolean b(d0 d0Var) {
        a aVar = (a) this.f5418a.getOrDefault(d0Var, null);
        if (aVar == null || (aVar.f5421a & 1) == 0) {
            return false;
        }
        return true;
    }

    public void a(d0 d0Var, l.c cVar) {
        a aVar = (a) this.f5418a.getOrDefault(d0Var, null);
        if (aVar == null) {
            aVar = a.a();
            this.f5418a.put(d0Var, aVar);
        }
        aVar.f5423c = cVar;
        aVar.f5421a |= 8;
    }

    public void a(d0 d0Var) {
        a aVar = (a) this.f5418a.getOrDefault(d0Var, null);
        if (aVar == null) {
            aVar = a.a();
            this.f5418a.put(d0Var, aVar);
        }
        aVar.f5421a |= 1;
    }
}
