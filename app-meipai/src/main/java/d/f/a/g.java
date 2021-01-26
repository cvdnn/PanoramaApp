package d.f.a;

import java.util.Arrays;

/* compiled from: SolverVariable */
public class g {
    public static int k = 1;

    /* renamed from: a reason: collision with root package name */
    public String f4638a;

    /* renamed from: b reason: collision with root package name */
    public int f4639b = -1;

    /* renamed from: c reason: collision with root package name */
    public int f4640c = -1;

    /* renamed from: d reason: collision with root package name */
    public int f4641d = 0;

    /* renamed from: e reason: collision with root package name */
    public float f4642e;

    /* renamed from: f reason: collision with root package name */
    public float[] f4643f = new float[7];

    /* renamed from: g reason: collision with root package name */
    public a f4644g;

    /* renamed from: h reason: collision with root package name */
    public b[] f4645h = new b[8];

    /* renamed from: i reason: collision with root package name */
    public int f4646i = 0;

    /* renamed from: j reason: collision with root package name */
    public int f4647j = 0;

    /* compiled from: SolverVariable */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.f4644g = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.f4646i;
            if (i2 >= i3) {
                b[] bVarArr = this.f4645h;
                if (i3 >= bVarArr.length) {
                    this.f4645h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f4645h;
                int i4 = this.f4646i;
                bVarArr2[i4] = bVar;
                this.f4646i = i4 + 1;
                return;
            } else if (this.f4645h[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.f4646i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f4645h[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.f4645h;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.f4646i--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.f4646i;
        for (int i3 = 0; i3 < i2; i3++) {
            b[] bVarArr = this.f4645h;
            a aVar = bVarArr[i3].f4621d;
            b bVar2 = bVarArr[i3];
            int i4 = aVar.f4616i;
            while (true) {
                int i5 = 0;
                while (i4 != -1 && i5 < aVar.f4608a) {
                    int i6 = aVar.f4613f[i4];
                    g gVar = bVar.f4618a;
                    if (i6 == gVar.f4639b) {
                        float f2 = aVar.f4615h[i4];
                        aVar.a(gVar, false);
                        a aVar2 = bVar.f4621d;
                        int i7 = aVar2.f4616i;
                        int i8 = 0;
                        while (i7 != -1 && i8 < aVar2.f4608a) {
                            aVar.a(aVar.f4610c.f4625c[aVar2.f4613f[i7]], aVar2.f4615h[i7] * f2, false);
                            i7 = aVar2.f4614g[i7];
                            i8++;
                        }
                        bVar2.f4619b = (bVar.f4619b * f2) + bVar2.f4619b;
                        i4 = aVar.f4616i;
                    } else {
                        i4 = aVar.f4614g[i4];
                        i5++;
                    }
                }
            }
        }
        this.f4646i = 0;
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("");
        a2.append(this.f4638a);
        return a2.toString();
    }

    public void a() {
        this.f4638a = null;
        this.f4644g = a.UNKNOWN;
        this.f4641d = 0;
        this.f4639b = -1;
        this.f4640c = -1;
        this.f4642e = 0.0f;
        this.f4646i = 0;
        this.f4647j = 0;
    }
}
