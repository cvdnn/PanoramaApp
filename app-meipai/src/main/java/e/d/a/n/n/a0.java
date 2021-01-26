package e.d.a.n.n;

import e.d.a.n.f;
import e.d.a.n.m.d;
import e.d.a.n.m.d.a;
import e.d.a.n.o.n;

/* compiled from: SourceGenerator */
public class a0 implements a<Object> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ n.a f7286a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ b0 f7287b;

    public a0(b0 b0Var, n.a aVar) {
        this.f7287b = b0Var;
        this.f7286a = aVar;
    }

    public void a(Object obj) {
        b0 b0Var = this.f7287b;
        n.a<?> aVar = this.f7286a;
        n.a<?> aVar2 = b0Var.f7294f;
        if (aVar2 != null && aVar2 == aVar) {
            b0 b0Var2 = this.f7287b;
            n.a aVar3 = this.f7286a;
            k kVar = b0Var2.f7289a.p;
            if (obj == null || !kVar.a(aVar3.f7580c.c())) {
                g.a aVar4 = b0Var2.f7290b;
                f fVar = aVar3.f7578a;
                d<Data> dVar = aVar3.f7580c;
                aVar4.a(fVar, obj, dVar, dVar.c(), b0Var2.f7295g);
                return;
            }
            b0Var2.f7293e = obj;
            b0Var2.f7290b.b();
        }
    }

    public void a(Exception exc) {
        b0 b0Var = this.f7287b;
        n.a<?> aVar = this.f7286a;
        n.a<?> aVar2 = b0Var.f7294f;
        if (aVar2 != null && aVar2 == aVar) {
            b0 b0Var2 = this.f7287b;
            n.a aVar3 = this.f7286a;
            g.a aVar4 = b0Var2.f7290b;
            e eVar = b0Var2.f7295g;
            d<Data> dVar = aVar3.f7580c;
            aVar4.a(eVar, exc, dVar, dVar.c());
        }
    }
}
