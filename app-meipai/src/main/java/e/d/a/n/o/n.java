package e.d.a.n.o;

import e.d.a.n.f;
import e.d.a.n.h;
import e.d.a.n.m.d;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader */
public interface n<Model, Data> {

    /* compiled from: ModelLoader */
    public static class a<Data> {

        /* renamed from: a reason: collision with root package name */
        public final f f7578a;

        /* renamed from: b reason: collision with root package name */
        public final List<f> f7579b;

        /* renamed from: c reason: collision with root package name */
        public final d<Data> f7580c;

        public a(f fVar, d<Data> dVar) {
            List<f> emptyList = Collections.emptyList();
            String str = "Argument must not be null";
            e.c.f.n.n.a(fVar, str);
            this.f7578a = fVar;
            e.c.f.n.n.a(emptyList, str);
            this.f7579b = emptyList;
            e.c.f.n.n.a(dVar, str);
            this.f7580c = dVar;
        }
    }

    a<Data> a(Model model, int i2, int i3, h hVar);

    boolean a(Model model);
}
