package e.g.c.a.a.b;

/* compiled from: OrientationEKF */
public class b {
    public d A = new d();
    public a B = new a();
    public a C = new a();
    public a D = new a();
    public a E = new a();
    public a F = new a();
    public a G = new a();
    public a H = new a();
    public d I = new d();
    public d J = new d();
    public d K = new d();
    public a L = new a();
    public a M = new a();
    public a N = new a();

    /* renamed from: a reason: collision with root package name */
    public double[] f8605a = new double[16];

    /* renamed from: b reason: collision with root package name */
    public a f8606b = new a();

    /* renamed from: c reason: collision with root package name */
    public a f8607c = new a();

    /* renamed from: d reason: collision with root package name */
    public a f8608d = new a();

    /* renamed from: e reason: collision with root package name */
    public a f8609e = new a();

    /* renamed from: f reason: collision with root package name */
    public a f8610f = new a();

    /* renamed from: g reason: collision with root package name */
    public a f8611g = new a();

    /* renamed from: h reason: collision with root package name */
    public a f8612h = new a();

    /* renamed from: i reason: collision with root package name */
    public a f8613i = new a();

    /* renamed from: j reason: collision with root package name */
    public a f8614j = new a();
    public d k = new d();
    public d l = new d();
    public d m = new d();
    public d n = new d();
    public d o = new d();
    public d p = new d();
    public d q = new d();
    public long r;
    public long s;
    public float[] t = new float[3];
    public float u;
    public boolean v = false;
    public int w;
    public boolean x = true;
    public a y = new a();
    public a z = new a();

    public b() {
        a();
    }

    public void a() {
        this.r = 0;
        this.s = 0;
        this.f8606b.a();
        this.f8607c.a();
        this.f8608d.b();
        this.f8608d.b(25.0d);
        this.f8609e.b();
        this.f8609e.b(1.0d);
        this.f8610f.b();
        this.f8610f.b(0.0625d);
        this.f8611g.b();
        this.f8611g.b(0.5625d);
        this.f8612h.b();
        this.f8613i.b();
        this.f8614j.b();
        this.k.c();
        this.l.c();
        this.m.c();
        this.n.c();
        this.o.c();
        this.p.a(0.0d, 0.0d, 9.81d);
        this.q.a(0.0d, 1.0d, 0.0d);
    }

    public synchronized void b(float[] fArr, long j2) {
        long j3 = j2;
        synchronized (this) {
            if (this.r != 0) {
                float f2 = ((float) (j3 - this.r)) * 1.0E-9f;
                if (f2 > 0.04f) {
                    f2 = this.x ? this.u : 0.01f;
                } else if (!this.v) {
                    this.u = f2;
                    this.w = 1;
                    this.v = true;
                } else {
                    this.u = (0.050000012f * f2) + (this.u * 0.95f);
                    int i2 = this.w + 1;
                    this.w = i2;
                    if (((float) i2) > 10.0f) {
                        this.x = true;
                    }
                }
                float f3 = -f2;
                this.n.a((double) (fArr[0] * f3), (double) (fArr[1] * f3), (double) (fArr[2] * f3));
                c.a(this.n, this.f8607c);
                this.B.d(this.f8606b);
                a.b(this.f8607c, this.f8606b, this.B);
                this.f8606b.d(this.B);
                b();
                this.C.d(this.f8609e);
                this.C.a((double) (f2 * f2));
                this.f8608d.c(this.C);
            }
            this.r = j3;
            this.t[0] = fArr[0];
            this.t[1] = fArr[1];
            this.t[2] = fArr[2];
        }
    }

    public double[] a(double d2) {
        d dVar = this.A;
        float[] fArr = this.t;
        double d3 = -d2;
        dVar.a(((double) fArr[0]) * d3, ((double) fArr[1]) * d3, ((double) fArr[2]) * d3);
        a aVar = this.y;
        c.a(dVar, aVar);
        a aVar2 = this.z;
        a.b(aVar, this.f8606b, aVar2);
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.f8605a[(i3 * 4) + i2] = aVar2.a(i2, i3);
            }
        }
        double[] dArr = this.f8605a;
        dArr[11] = 0.0d;
        dArr[7] = 0.0d;
        dArr[3] = 0.0d;
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[15] = 1.0d;
        return dArr;
    }

    public final void b() {
        this.f8607c.e(this.L);
        a.b(this.f8608d, this.L, this.M);
        a.b(this.f8607c, this.M, this.f8608d);
        this.f8607c.a();
    }

    public synchronized void a(float[] fArr, long j2) {
        synchronized (this) {
            this.l.a((double) fArr[0], (double) fArr[1], (double) fArr[2]);
            if (this.s != 0) {
                a(this.f8606b, this.k);
                for (int i2 = 0; i2 < 3; i2++) {
                    d dVar = this.K;
                    dVar.c();
                    if (i2 == 0) {
                        dVar.f8624a = 1.0E-7d;
                    } else if (i2 == 1) {
                        dVar.f8625b = 1.0E-7d;
                    } else {
                        dVar.f8626c = 1.0E-7d;
                    }
                    c.a(dVar, this.D);
                    a.b(this.D, this.f8606b, this.E);
                    a(this.E, this.I);
                    d dVar2 = this.I;
                    d dVar3 = this.k;
                    this.J.a(dVar3.f8624a - dVar2.f8624a, dVar3.f8625b - dVar2.f8625b, dVar3.f8626c - dVar2.f8626c);
                    this.J.a(1.0E7d);
                    this.f8613i.a(i2, this.J);
                }
                this.f8613i.e(this.F);
                a.b(this.f8608d, this.F, this.G);
                a.b(this.f8613i, this.G, this.H);
                a.a(this.H, this.f8611g, this.f8612h);
                this.f8612h.a(this.F);
                this.f8613i.e(this.G);
                a.b(this.G, this.F, this.H);
                a.b(this.f8608d, this.H, this.f8614j);
                a.a(this.f8614j, this.k, this.o);
                a.b(this.f8614j, this.f8613i, this.F);
                this.G.a();
                this.G.b(this.F);
                a.b(this.G, this.f8608d, this.F);
                this.f8608d.d(this.F);
                c.a(this.o, this.f8607c);
                a.b(this.f8607c, this.f8606b, this.f8606b);
                b();
            } else {
                c.a(this.p, this.l, this.f8606b);
            }
            this.s = j2;
        }
    }

    public final void a(a aVar, d dVar) {
        d dVar2 = dVar;
        a.a(aVar, this.p, this.m);
        c.a(this.m, this.l, this.N);
        a aVar2 = this.N;
        double a2 = ((aVar2.a(2, 2) + (aVar2.a(1, 1) + aVar2.a(0, 0))) - 1.0d) * 0.5d;
        dVar.a((aVar2.a(2, 1) - aVar2.a(1, 2)) / 2.0d, (aVar2.a(0, 2) - aVar2.a(2, 0)) / 2.0d, (aVar2.a(1, 0) - aVar2.a(0, 1)) / 2.0d);
        double a3 = dVar.a();
        if (a2 > 0.7071067811865476d) {
            if (a3 > 0.0d) {
                dVar2.a(Math.asin(a3) / a3);
            }
        } else if (a2 > -0.7071067811865476d) {
            dVar2.a(Math.acos(a2) / a3);
        } else {
            double asin = 3.141592653589793d - Math.asin(a3);
            double a4 = aVar2.a(0, 0) - a2;
            double a5 = aVar2.a(1, 1) - a2;
            double a6 = aVar2.a(2, 2) - a2;
            d dVar3 = c.f8622h;
            double d2 = a4 * a4;
            double d3 = a5 * a5;
            if (d2 > d3 && d2 > a6 * a6) {
                d dVar4 = dVar3;
                dVar4.a(a4, (aVar2.a(0, 1) + aVar2.a(1, 0)) / 2.0d, (aVar2.a(2, 0) + aVar2.a(0, 2)) / 2.0d);
            } else if (d3 > a6 * a6) {
                d dVar5 = dVar3;
                dVar5.a((aVar2.a(0, 1) + aVar2.a(1, 0)) / 2.0d, a5, (aVar2.a(1, 2) + aVar2.a(2, 1)) / 2.0d);
            } else {
                d dVar6 = dVar3;
                dVar6.a((aVar2.a(2, 0) + aVar2.a(0, 2)) / 2.0d, (aVar2.a(1, 2) + aVar2.a(2, 1)) / 2.0d, a6);
            }
            if (d.a(dVar3, dVar2) < 0.0d) {
                dVar3.a(-1.0d);
            }
            dVar3.b();
            dVar3.a(asin);
            dVar2.a(dVar3);
        }
    }
}
