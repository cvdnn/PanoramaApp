package d.f.a;

import java.util.Arrays;

/* compiled from: ArrayLinkedVariables */
public class a {

    /* renamed from: a reason: collision with root package name */
    public int f4608a = 0;

    /* renamed from: b reason: collision with root package name */
    public final b f4609b;

    /* renamed from: c reason: collision with root package name */
    public final c f4610c;

    /* renamed from: d reason: collision with root package name */
    public int f4611d = 8;

    /* renamed from: e reason: collision with root package name */
    public g f4612e = null;

    /* renamed from: f reason: collision with root package name */
    public int[] f4613f = new int[8];

    /* renamed from: g reason: collision with root package name */
    public int[] f4614g = new int[8];

    /* renamed from: h reason: collision with root package name */
    public float[] f4615h = new float[8];

    /* renamed from: i reason: collision with root package name */
    public int f4616i = -1;

    /* renamed from: j reason: collision with root package name */
    public int f4617j = -1;
    public boolean k = false;

    public a(b bVar, c cVar) {
        this.f4609b = bVar;
        this.f4610c = cVar;
    }

    public final void a(g gVar, float f2) {
        if (f2 == 0.0f) {
            a(gVar, true);
            return;
        }
        int i2 = this.f4616i;
        if (i2 == -1) {
            this.f4616i = 0;
            this.f4615h[0] = f2;
            this.f4613f[0] = gVar.f4639b;
            this.f4614g[0] = -1;
            gVar.f4647j++;
            gVar.a(this.f4609b);
            this.f4608a++;
            if (!this.k) {
                int i3 = this.f4617j + 1;
                this.f4617j = i3;
                int[] iArr = this.f4613f;
                if (i3 >= iArr.length) {
                    this.k = true;
                    this.f4617j = iArr.length - 1;
                }
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f4608a) {
            int[] iArr2 = this.f4613f;
            int i6 = iArr2[i2];
            int i7 = gVar.f4639b;
            if (i6 == i7) {
                this.f4615h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i5 = i2;
            }
            i2 = this.f4614g[i2];
            i4++;
        }
        int i8 = this.f4617j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f4613f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f4613f;
        if (i8 >= iArr4.length && this.f4608a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f4613f;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f4613f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f4611d * 2;
            this.f4611d = i11;
            this.k = false;
            this.f4617j = i8 - 1;
            this.f4615h = Arrays.copyOf(this.f4615h, i11);
            this.f4613f = Arrays.copyOf(this.f4613f, this.f4611d);
            this.f4614g = Arrays.copyOf(this.f4614g, this.f4611d);
        }
        this.f4613f[i8] = gVar.f4639b;
        this.f4615h[i8] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.f4614g;
            iArr7[i8] = iArr7[i5];
            iArr7[i5] = i8;
        } else {
            this.f4614g[i8] = this.f4616i;
            this.f4616i = i8;
        }
        gVar.f4647j++;
        gVar.a(this.f4609b);
        this.f4608a++;
        if (!this.k) {
            this.f4617j++;
        }
        if (this.f4608a >= this.f4613f.length) {
            this.k = true;
        }
        int i12 = this.f4617j;
        int[] iArr8 = this.f4613f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.f4617j = iArr8.length - 1;
        }
    }

    public final boolean b(g gVar) {
        return gVar.f4647j <= 1;
    }

    public String toString() {
        int i2 = this.f4616i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f4608a) {
            StringBuilder a2 = e.a.a.a.a.a(e.a.a.a.a.a(str, " -> "));
            a2.append(this.f4615h[i2]);
            a2.append(" : ");
            StringBuilder a3 = e.a.a.a.a.a(a2.toString());
            a3.append(this.f4610c.f4625c[this.f4613f[i2]]);
            str = a3.toString();
            i2 = this.f4614g[i2];
            i3++;
        }
        return str;
    }

    public final float b(int i2) {
        int i3 = this.f4616i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f4608a) {
            if (i4 == i2) {
                return this.f4615h[i3];
            }
            i3 = this.f4614g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final void a(g gVar, float f2, boolean z) {
        if (f2 != 0.0f) {
            int i2 = this.f4616i;
            if (i2 == -1) {
                this.f4616i = 0;
                this.f4615h[0] = f2;
                this.f4613f[0] = gVar.f4639b;
                this.f4614g[0] = -1;
                gVar.f4647j++;
                gVar.a(this.f4609b);
                this.f4608a++;
                if (!this.k) {
                    int i3 = this.f4617j + 1;
                    this.f4617j = i3;
                    int[] iArr = this.f4613f;
                    if (i3 >= iArr.length) {
                        this.k = true;
                        this.f4617j = iArr.length - 1;
                    }
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f4608a) {
                int[] iArr2 = this.f4613f;
                int i6 = iArr2[i2];
                int i7 = gVar.f4639b;
                if (i6 == i7) {
                    float[] fArr = this.f4615h;
                    fArr[i2] = fArr[i2] + f2;
                    if (fArr[i2] == 0.0f) {
                        if (i2 == this.f4616i) {
                            this.f4616i = this.f4614g[i2];
                        } else {
                            int[] iArr3 = this.f4614g;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            gVar.b(this.f4609b);
                        }
                        if (this.k) {
                            this.f4617j = i2;
                        }
                        gVar.f4647j--;
                        this.f4608a--;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i5 = i2;
                }
                i2 = this.f4614g[i2];
                i4++;
            }
            int i8 = this.f4617j;
            int i9 = i8 + 1;
            if (this.k) {
                int[] iArr4 = this.f4613f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f4613f;
            if (i8 >= iArr5.length && this.f4608a < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f4613f;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.f4613f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f4611d * 2;
                this.f4611d = i11;
                this.k = false;
                this.f4617j = i8 - 1;
                this.f4615h = Arrays.copyOf(this.f4615h, i11);
                this.f4613f = Arrays.copyOf(this.f4613f, this.f4611d);
                this.f4614g = Arrays.copyOf(this.f4614g, this.f4611d);
            }
            this.f4613f[i8] = gVar.f4639b;
            this.f4615h[i8] = f2;
            if (i5 != -1) {
                int[] iArr8 = this.f4614g;
                iArr8[i8] = iArr8[i5];
                iArr8[i5] = i8;
            } else {
                this.f4614g[i8] = this.f4616i;
                this.f4616i = i8;
            }
            gVar.f4647j++;
            gVar.a(this.f4609b);
            this.f4608a++;
            if (!this.k) {
                this.f4617j++;
            }
            int i12 = this.f4617j;
            int[] iArr9 = this.f4613f;
            if (i12 >= iArr9.length) {
                this.k = true;
                this.f4617j = iArr9.length - 1;
            }
        }
    }

    public final float a(g gVar, boolean z) {
        if (this.f4612e == gVar) {
            this.f4612e = null;
        }
        int i2 = this.f4616i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f4608a) {
            if (this.f4613f[i2] == gVar.f4639b) {
                if (i2 == this.f4616i) {
                    this.f4616i = this.f4614g[i2];
                } else {
                    int[] iArr = this.f4614g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    gVar.b(this.f4609b);
                }
                gVar.f4647j--;
                this.f4608a--;
                this.f4613f[i2] = -1;
                if (this.k) {
                    this.f4617j = i2;
                }
                return this.f4615h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f4614g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.f4616i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f4608a) {
            g gVar = this.f4610c.f4625c[this.f4613f[i2]];
            if (gVar != null) {
                gVar.b(this.f4609b);
            }
            i2 = this.f4614g[i2];
            i3++;
        }
        this.f4616i = -1;
        this.f4617j = -1;
        this.k = false;
        this.f4608a = 0;
    }

    public g a(boolean[] zArr, g gVar) {
        int i2 = this.f4616i;
        int i3 = 0;
        g gVar2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f4608a) {
            if (this.f4615h[i2] < 0.0f) {
                g gVar3 = this.f4610c.f4625c[this.f4613f[i2]];
                if ((zArr == null || !zArr[gVar3.f4639b]) && gVar3 != gVar) {
                    d.f.a.g.a aVar = gVar3.f4644g;
                    if (aVar == d.f.a.g.a.SLACK || aVar == d.f.a.g.a.ERROR) {
                        float f3 = this.f4615h[i2];
                        if (f3 < f2) {
                            gVar2 = gVar3;
                            f2 = f3;
                        }
                    }
                }
            }
            i2 = this.f4614g[i2];
            i3++;
        }
        return gVar2;
    }

    public final g a(int i2) {
        int i3 = this.f4616i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f4608a) {
            if (i4 == i2) {
                return this.f4610c.f4625c[this.f4613f[i3]];
            }
            i3 = this.f4614g[i3];
            i4++;
        }
        return null;
    }

    public final float a(g gVar) {
        int i2 = this.f4616i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f4608a) {
            if (this.f4613f[i2] == gVar.f4639b) {
                return this.f4615h[i2];
            }
            i2 = this.f4614g[i2];
            i3++;
        }
        return 0.0f;
    }
}
