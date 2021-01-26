package e.d.a.n.o;

import d.h.j.c;
import e.c.f.n.n;
import e.d.a.f;
import e.d.a.n.h;
import e.d.a.n.m.d;
import e.d.a.n.n.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader */
public class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a reason: collision with root package name */
    public final List<n<Model, Data>> f7585a;

    /* renamed from: b reason: collision with root package name */
    public final c<List<Throwable>> f7586b;

    /* compiled from: MultiModelLoader */
    public static class a<Data> implements d<Data>, e.d.a.n.m.d.a<Data> {

        /* renamed from: a reason: collision with root package name */
        public final List<d<Data>> f7587a;

        /* renamed from: b reason: collision with root package name */
        public final c<List<Throwable>> f7588b;

        /* renamed from: c reason: collision with root package name */
        public int f7589c;

        /* renamed from: d reason: collision with root package name */
        public f f7590d;

        /* renamed from: e reason: collision with root package name */
        public e.d.a.n.m.d.a<? super Data> f7591e;

        /* renamed from: f reason: collision with root package name */
        public List<Throwable> f7592f;

        /* renamed from: g reason: collision with root package name */
        public boolean f7593g;

        public a(List<d<Data>> list, c<List<Throwable>> cVar) {
            this.f7588b = cVar;
            if (!list.isEmpty()) {
                this.f7587a = list;
                this.f7589c = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super Data> aVar) {
            this.f7590d = fVar;
            this.f7591e = aVar;
            this.f7592f = (List) this.f7588b.a();
            ((d) this.f7587a.get(this.f7589c)).a(fVar, this);
            if (this.f7593g) {
                cancel();
            }
        }

        public void b() {
            List<Throwable> list = this.f7592f;
            if (list != null) {
                this.f7588b.a(list);
            }
            this.f7592f = null;
            for (d b2 : this.f7587a) {
                b2.b();
            }
        }

        public e.d.a.n.a c() {
            return ((d) this.f7587a.get(0)).c();
        }

        public void cancel() {
            this.f7593g = true;
            for (d cancel : this.f7587a) {
                cancel.cancel();
            }
        }

        public final void d() {
            if (!this.f7593g) {
                if (this.f7589c < this.f7587a.size() - 1) {
                    this.f7589c++;
                    a(this.f7590d, this.f7591e);
                } else {
                    n.a(this.f7592f, "Argument must not be null");
                    this.f7591e.a((Exception) new r("Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.f7592f)));
                }
            }
        }

        public Class<Data> a() {
            return ((d) this.f7587a.get(0)).a();
        }

        public void a(Data data) {
            if (data != null) {
                this.f7591e.a(data);
            } else {
                d();
            }
        }

        public void a(Exception exc) {
            List<Throwable> list = this.f7592f;
            n.a(list, "Argument must not be null");
            list.add(exc);
            d();
        }
    }

    public q(List<n<Model, Data>> list, c<List<Throwable>> cVar) {
        this.f7585a = list;
        this.f7586b = cVar;
    }

    public e.d.a.n.o.n.a<Data> a(Model model, int i2, int i3, h hVar) {
        int size = this.f7585a.size();
        ArrayList arrayList = new ArrayList(size);
        e.d.a.n.f fVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n nVar = (n) this.f7585a.get(i4);
            if (nVar.a(model)) {
                e.d.a.n.o.n.a a2 = nVar.a(model, i2, i3, hVar);
                if (a2 != null) {
                    fVar = a2.f7578a;
                    arrayList.add(a2.f7580c);
                }
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new e.d.a.n.o.n.a<>(fVar, new a(arrayList, this.f7586b));
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("MultiModelLoader{modelLoaders=");
        a2.append(Arrays.toString(this.f7585a.toArray()));
        a2.append('}');
        return a2.toString();
    }

    public boolean a(Model model) {
        for (n a2 : this.f7585a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }
}
