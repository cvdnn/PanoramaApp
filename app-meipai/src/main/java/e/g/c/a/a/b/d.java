package e.g.c.a.a.b;

/* compiled from: Vector3d */
public class d {

    /* renamed from: a reason: collision with root package name */
    public double f8624a;

    /* renamed from: b reason: collision with root package name */
    public double f8625b;

    /* renamed from: c reason: collision with root package name */
    public double f8626c;

    public void a(double d2, double d3, double d4) {
        this.f8624a = d2;
        this.f8625b = d3;
        this.f8626c = d4;
    }

    public void b() {
        double a2 = a();
        if (a2 != 0.0d) {
            a(1.0d / a2);
        }
    }

    public void c() {
        this.f8626c = 0.0d;
        this.f8625b = 0.0d;
        this.f8624a = 0.0d;
    }

    public void a(d dVar) {
        this.f8624a = dVar.f8624a;
        this.f8625b = dVar.f8625b;
        this.f8626c = dVar.f8626c;
    }

    public void a(double d2) {
        this.f8624a *= d2;
        this.f8625b *= d2;
        this.f8626c *= d2;
    }

    public static double a(d dVar, d dVar2) {
        return (dVar.f8626c * dVar2.f8626c) + (dVar.f8625b * dVar2.f8625b) + (dVar.f8624a * dVar2.f8624a);
    }

    public double a() {
        double d2 = this.f8624a;
        double d3 = d2 * d2;
        double d4 = this.f8625b;
        double d5 = (d4 * d4) + d3;
        double d6 = this.f8626c;
        return Math.sqrt((d6 * d6) + d5);
    }

    public static void a(d dVar, d dVar2, d dVar3) {
        d dVar4 = dVar;
        d dVar5 = dVar2;
        double d2 = dVar4.f8625b;
        double d3 = dVar5.f8626c;
        double d4 = d2 * d3;
        double d5 = dVar4.f8626c;
        double d6 = dVar5.f8625b;
        double d7 = d4 - (d5 * d6);
        double d8 = dVar5.f8624a;
        double d9 = d5 * d8;
        double d10 = dVar4.f8624a;
        dVar3.a(d7, d9 - (d3 * d10), (d10 * d6) - (d2 * d8));
    }
}
