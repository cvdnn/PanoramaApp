package e.g.c.a.a.b;

/* compiled from: Matrix3x3d */
public class a {

    /* renamed from: a reason: collision with root package name */
    public double[] f8604a = new double[9];

    public void a(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double[] dArr = this.f8604a;
        dArr[0] = d2;
        dArr[1] = d3;
        dArr[2] = d4;
        dArr[3] = d5;
        dArr[4] = d6;
        dArr[5] = d7;
        dArr[6] = d8;
        dArr[7] = d9;
        dArr[8] = d10;
    }

    public void b() {
        double[] dArr = this.f8604a;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[5] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[0] = 0.0d;
    }

    public void c(a aVar) {
        double[] dArr = this.f8604a;
        double d2 = dArr[0];
        double[] dArr2 = aVar.f8604a;
        dArr[0] = d2 + dArr2[0];
        dArr[1] = dArr[1] + dArr2[1];
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
        dArr[4] = dArr[4] + dArr2[4];
        dArr[5] = dArr[5] + dArr2[5];
        dArr[6] = dArr[6] + dArr2[6];
        dArr[7] = dArr[7] + dArr2[7];
        dArr[8] = dArr[8] + dArr2[8];
    }

    public void d(a aVar) {
        double[] dArr = this.f8604a;
        double[] dArr2 = aVar.f8604a;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
    }

    public void e(a aVar) {
        double[] dArr = this.f8604a;
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[5];
        double[] dArr2 = aVar.f8604a;
        dArr2[0] = dArr[0];
        dArr2[1] = dArr[3];
        dArr2[2] = dArr[6];
        dArr2[3] = d2;
        dArr2[4] = dArr[4];
        dArr2[5] = dArr[7];
        dArr2[6] = d3;
        dArr2[7] = d4;
        dArr2[8] = dArr[8];
    }

    public void b(double d2) {
        double[] dArr = this.f8604a;
        dArr[8] = d2;
        dArr[4] = d2;
        dArr[0] = d2;
    }

    public void b(a aVar) {
        double[] dArr = this.f8604a;
        double d2 = dArr[0];
        double[] dArr2 = aVar.f8604a;
        dArr[0] = d2 - dArr2[0];
        dArr[1] = dArr[1] - dArr2[1];
        dArr[2] = dArr[2] - dArr2[2];
        dArr[3] = dArr[3] - dArr2[3];
        dArr[4] = dArr[4] - dArr2[4];
        dArr[5] = dArr[5] - dArr2[5];
        dArr[6] = dArr[6] - dArr2[6];
        dArr[7] = dArr[7] - dArr2[7];
        dArr[8] = dArr[8] - dArr2[8];
    }

    public void a() {
        double[] dArr = this.f8604a;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[5] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[8] = 1.0d;
        dArr[4] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static void b(a aVar, a aVar2, a aVar3) {
        a aVar4 = aVar3;
        double[] dArr = aVar.f8604a;
        double d2 = dArr[0];
        double[] dArr2 = aVar2.f8604a;
        double[] dArr3 = dArr2;
        double[] dArr4 = dArr;
        aVar4.a((dArr[2] * dArr2[6]) + (dArr[1] * dArr2[3]) + (d2 * dArr2[0]), (dArr[2] * dArr2[7]) + (dArr[1] * dArr2[4]) + (dArr[0] * dArr2[1]), (dArr[2] * dArr2[8]) + (dArr[1] * dArr2[5]) + (dArr[0] * dArr2[2]), (dArr[5] * dArr2[6]) + (dArr[4] * dArr2[3]) + (dArr[3] * dArr2[0]), (dArr[5] * dArr2[7]) + (dArr[4] * dArr2[4]) + (dArr[3] * dArr2[1]), (dArr[5] * dArr2[8]) + (dArr[4] * dArr2[5]) + (dArr[3] * dArr2[2]), (dArr[8] * dArr2[6]) + (dArr[7] * dArr2[3]) + (dArr[6] * dArr2[0]), (dArr[8] * dArr3[7]) + (dArr[7] * dArr3[4]) + (dArr[6] * dArr3[1]), (dArr4[8] * dArr3[8]) + (dArr4[7] * dArr3[5]) + (dArr4[6] * dArr3[2]));
    }

    public double a(int i2, int i3) {
        return this.f8604a[(i2 * 3) + i3];
    }

    public void a(int i2, int i3, double d2) {
        this.f8604a[(i2 * 3) + i3] = d2;
    }

    public void a(int i2, d dVar) {
        double[] dArr = this.f8604a;
        dArr[i2] = dVar.f8624a;
        dArr[i2 + 3] = dVar.f8625b;
        dArr[i2 + 6] = dVar.f8626c;
    }

    public void a(double d2) {
        double[] dArr = this.f8604a;
        dArr[0] = dArr[0] * d2;
        dArr[1] = dArr[1] * d2;
        dArr[2] = dArr[2] * d2;
        dArr[3] = dArr[3] * d2;
        dArr[4] = dArr[4] * d2;
        dArr[5] = dArr[5] * d2;
        dArr[6] = dArr[6] * d2;
        dArr[7] = dArr[7] * d2;
        dArr[8] = dArr[8] * d2;
    }

    public static void a(a aVar, a aVar2, a aVar3) {
        double[] dArr = aVar3.f8604a;
        double[] dArr2 = aVar.f8604a;
        double d2 = dArr2[0];
        double[] dArr3 = aVar2.f8604a;
        dArr[0] = d2 + dArr3[0];
        dArr[1] = dArr2[1] + dArr3[1];
        dArr[2] = dArr2[2] + dArr3[2];
        dArr[3] = dArr2[3] + dArr3[3];
        dArr[4] = dArr2[4] + dArr3[4];
        dArr[5] = dArr2[5] + dArr3[5];
        dArr[6] = dArr2[6] + dArr3[6];
        dArr[7] = dArr2[7] + dArr3[7];
        dArr[8] = dArr2[8] + dArr3[8];
    }

    public static void a(a aVar, d dVar, d dVar2) {
        double[] dArr = aVar.f8604a;
        double d2 = dArr[0];
        double d3 = dVar.f8624a;
        double d4 = d2 * d3;
        double d5 = dArr[1];
        double d6 = dVar.f8625b;
        double d7 = (d5 * d6) + d4;
        double d8 = dArr[2];
        double d9 = dVar.f8626c;
        double d10 = (d8 * d9) + d7;
        double d11 = (dArr[5] * d9) + (dArr[4] * d6) + (dArr[3] * d3);
        double d12 = (dArr[8] * d9) + (dArr[7] * d6) + (dArr[6] * d3);
        dVar2.f8624a = d10;
        dVar2.f8625b = d11;
        dVar2.f8626c = d12;
    }

    public boolean a(a aVar) {
        double a2 = (((a(2, 1) * a(1, 0)) - (a(2, 0) * a(1, 1))) * a(0, 2)) + ((((a(2, 2) * a(1, 1)) - (a(1, 2) * a(2, 1))) * a(0, 0)) - (((a(2, 2) * a(1, 0)) - (a(2, 0) * a(1, 2))) * a(0, 1)));
        if (a2 == 0.0d) {
            return false;
        }
        double d2 = 1.0d / a2;
        double[] dArr = this.f8604a;
        double d3 = d2;
        a aVar2 = aVar;
        aVar2.a(e.a.a.a.a.c(dArr[7], dArr[5], dArr[4] * dArr[8], d3), (-((dArr[1] * dArr[8]) - (dArr[2] * dArr[7]))) * d2, e.a.a.a.a.c(dArr[2], dArr[4], dArr[1] * dArr[5], d3), (-((dArr[3] * dArr[8]) - (dArr[5] * dArr[6]))) * d2, e.a.a.a.a.c(dArr[2], dArr[6], dArr[0] * dArr[8], d3), (-((dArr[0] * dArr[5]) - (dArr[3] * dArr[2]))) * d2, e.a.a.a.a.c(dArr[6], dArr[4], dArr[3] * dArr[7], d3), (-((dArr[0] * dArr[7]) - (dArr[6] * dArr[1]))) * d2, e.a.a.a.a.c(dArr[3], dArr[1], dArr[0] * dArr[4], d3));
        return true;
    }
}
