package e.d.a.n.o;

import e.d.a.f;
import e.d.a.n.h;
import e.d.a.n.m.d;

/* compiled from: UnitModelLoader */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a reason: collision with root package name */
    public static final v<?> f7611a = new v<>();

    /* compiled from: UnitModelLoader */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a reason: collision with root package name */
        public static final a<?> f7612a = new a<>();

        public n<Model, Model> a(r rVar) {
            return v.f7611a;
        }
    }

    /* compiled from: UnitModelLoader */
    public static class b<Model> implements d<Model> {

        /* renamed from: a reason: collision with root package name */
        public final Model f7613a;

        public b(Model model) {
            this.f7613a = model;
        }

        public void a(f fVar, e.d.a.n.m.d.a<? super Model> aVar) {
            aVar.a(this.f7613a);
        }

        public void b() {
        }

        public e.d.a.n.a c() {
            return e.d.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public Class<Model> a() {
            return this.f7613a.getClass();
        }
    }

    public e.d.a.n.o.n.a<Model> a(Model model, int i2, int i3, h hVar) {
        return new e.d.a.n.o.n.a<>(new e.d.a.s.b(model), new b(model));
    }

    public boolean a(Model model) {
        return true;
    }
}
