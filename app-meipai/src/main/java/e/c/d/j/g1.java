package e.c.d.j;

import e.c.d.d.a.p;
import e.c.d.f.d.d;

/* compiled from: PanoTaskManager */
public class g1 implements p {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ h1 f6263a;

    public g1(h1 h1Var) {
        this.f6263a = h1Var;
    }

    public void a(String str) {
        this.f6263a.f6254a.execute(new e(this, str));
    }

    public void a(String str, float f2) {
    }

    public /* synthetic */ void b(String str) {
        d dVar = (d) this.f6263a.f6269e.get(str);
    }

    public void a(String str, int i2) {
        this.f6263a.f6254a.execute(new d(this, str, i2));
    }

    public void a(String str, String str2) {
        this.f6263a.f6254a.execute(new c(this, str, str2));
    }

    public /* synthetic */ void b(String str, int i2) {
        h1 h1Var = this.f6263a;
        d dVar = (d) h1Var.f6269e.get(str);
        if (dVar != null) {
            h1Var.f6269e.remove(str);
            if (i2 == 3) {
                h1Var.a(dVar, 999);
                return;
            }
            h1Var.a(dVar, 6);
            if (i2 == 6) {
                h1Var.f6270f.observable(new u(dVar));
            } else if (i2 == 5) {
                h1Var.f6270f.observable(new m(dVar));
            } else {
                h1Var.f6270f.observable(new o(dVar));
            }
        }
    }

    public /* synthetic */ void b(String str, String str2) {
        h1 h1Var = this.f6263a;
        d dVar = (d) h1Var.f6269e.remove(str);
        if (dVar != null) {
            dVar.f6087g = str2;
            h1Var.e(dVar);
            h1Var.d(dVar);
        }
    }
}
