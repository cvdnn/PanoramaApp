package d.f.a.h;

import d.f.a.h.c.b;
import java.util.ArrayList;

/* compiled from: Snapshot */
public class m {

    /* renamed from: a reason: collision with root package name */
    public int f4727a;

    /* renamed from: b reason: collision with root package name */
    public int f4728b;

    /* renamed from: c reason: collision with root package name */
    public int f4729c;

    /* renamed from: d reason: collision with root package name */
    public int f4730d;

    /* renamed from: e reason: collision with root package name */
    public ArrayList<a> f4731e = new ArrayList<>();

    /* compiled from: Snapshot */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public c f4732a;

        /* renamed from: b reason: collision with root package name */
        public c f4733b;

        /* renamed from: c reason: collision with root package name */
        public int f4734c;

        /* renamed from: d reason: collision with root package name */
        public b f4735d;

        /* renamed from: e reason: collision with root package name */
        public int f4736e;

        public a(c cVar) {
            this.f4732a = cVar;
            this.f4733b = cVar.f4667d;
            this.f4734c = cVar.a();
            this.f4735d = cVar.f4670g;
            this.f4736e = cVar.f4671h;
        }
    }

    public m(d dVar) {
        this.f4727a = dVar.I;
        this.f4728b = dVar.J;
        this.f4729c = dVar.h();
        this.f4730d = dVar.c();
        ArrayList b2 = dVar.b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4731e.add(new a((c) b2.get(i2)));
        }
    }
}
