package d.h.f;

import a.a.a.a.b.a;
import android.graphics.Path;
import android.util.Log;

/* compiled from: PathParser */
public class b {

    /* renamed from: a reason: collision with root package name */
    public char f4808a;

    /* renamed from: b reason: collision with root package name */
    public float[] f4809b;

    public b(char c2, float[] fArr) {
        this.f4808a = c2;
        this.f4809b = fArr;
    }

    public static void a(b[] bVarArr, Path path) {
        int i2;
        float f2;
        float f3;
        int i3;
        int i4;
        float[] fArr;
        char c2;
        int i5;
        float[] fArr2;
        char c3;
        int i6;
        float f4;
        float f5;
        float f6;
        float f7;
        int i7;
        float f8;
        float f9;
        int i8;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        b[] bVarArr2 = bVarArr;
        Path path2 = path;
        int i9 = 6;
        float[] fArr3 = new float[6];
        char c4 = 'm';
        int i10 = 0;
        char c5 = 'm';
        int i11 = 0;
        while (i11 < bVarArr2.length) {
            char c6 = bVarArr2[i11].f4808a;
            float[] fArr4 = bVarArr2[i11].f4809b;
            float f25 = fArr3[i10];
            float f26 = fArr3[1];
            float f27 = fArr3[2];
            float f28 = fArr3[3];
            float f29 = fArr3[4];
            float f30 = fArr3[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = i9;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f29, f30);
                    f25 = f29;
                    f27 = f25;
                    f26 = f30;
                    f28 = f26;
                    break;
            }
            i2 = 2;
            float f31 = f29;
            float f32 = f30;
            float f33 = f25;
            float f34 = f26;
            int i12 = i10;
            while (i12 < fArr4.length) {
                if (c6 != 'A') {
                    if (c6 != 'C') {
                        if (c6 == 'H') {
                            i3 = i12;
                            fArr = fArr4;
                            c2 = c6;
                            i4 = i11;
                            int i13 = i3 + 0;
                            path2.lineTo(fArr[i13], f34);
                            f33 = fArr[i13];
                        } else if (c6 == 'Q') {
                            i7 = i12;
                            fArr = fArr4;
                            c2 = c6;
                            i4 = i11;
                            int i14 = i7 + 0;
                            int i15 = i7 + 1;
                            int i16 = i7 + 2;
                            int i17 = i7 + 3;
                            path2.quadTo(fArr[i14], fArr[i15], fArr[i16], fArr[i17]);
                            f7 = fArr[i14];
                            f6 = fArr[i15];
                            f33 = fArr[i16];
                            f34 = fArr[i17];
                        } else if (c6 == 'V') {
                            i3 = i12;
                            fArr = fArr4;
                            c2 = c6;
                            i4 = i11;
                            int i18 = i3 + 0;
                            path2.lineTo(f33, fArr[i18]);
                            f34 = fArr[i18];
                        } else if (c6 != 'a') {
                            if (c6 != 'c') {
                                if (c6 == 'h') {
                                    i3 = i12;
                                    float f35 = f34;
                                    float f36 = f33;
                                    int i19 = i3 + 0;
                                    path2.rLineTo(fArr4[i19], 0.0f);
                                    f33 = f36 + fArr4[i19];
                                } else if (c6 != 'q') {
                                    if (c6 == 'v') {
                                        i3 = i12;
                                        f15 = f34;
                                        float f37 = f33;
                                        int i20 = i3 + 0;
                                        path2.rLineTo(0.0f, fArr4[i20]);
                                        f16 = fArr4[i20];
                                    } else if (c6 != 'L') {
                                        if (c6 == 'M') {
                                            i3 = i12;
                                            int i21 = i3 + 0;
                                            float f38 = fArr4[i21];
                                            int i22 = i3 + 1;
                                            float f39 = fArr4[i22];
                                            if (i3 > 0) {
                                                path2.lineTo(fArr4[i21], fArr4[i22]);
                                                f33 = f38;
                                                f34 = f39;
                                            } else {
                                                path2.moveTo(fArr4[i21], fArr4[i22]);
                                                f33 = f38;
                                                f34 = f39;
                                            }
                                        } else if (c6 == 'S') {
                                            i8 = i12;
                                            float f40 = f34;
                                            float f41 = f33;
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f17 = (f40 * 2.0f) - f2;
                                                f18 = (f41 * 2.0f) - f3;
                                            } else {
                                                f18 = f41;
                                                f17 = f40;
                                            }
                                            int i23 = i8 + 0;
                                            int i24 = i8 + 1;
                                            int i25 = i8 + 2;
                                            int i26 = i8 + 3;
                                            path.cubicTo(f18, f17, fArr4[i23], fArr4[i24], fArr4[i25], fArr4[i26]);
                                            float f42 = fArr4[i23];
                                            float f43 = fArr4[i24];
                                            f9 = fArr4[i25];
                                            f8 = fArr4[i26];
                                            f3 = f42;
                                            f2 = f43;
                                            f33 = f9;
                                            f34 = f8;
                                        } else if (c6 == 'T') {
                                            i3 = i12;
                                            float f44 = f34;
                                            float f45 = f33;
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f19 = (f45 * 2.0f) - f3;
                                                f20 = (f44 * 2.0f) - f2;
                                            } else {
                                                f19 = f45;
                                                f20 = f44;
                                            }
                                            int i27 = i3 + 0;
                                            int i28 = i3 + 1;
                                            path2.quadTo(f19, f20, fArr4[i27], fArr4[i28]);
                                            f2 = f20;
                                            f3 = f19;
                                            fArr = fArr4;
                                            c2 = c6;
                                            i4 = i11;
                                            f33 = fArr4[i27];
                                            f34 = fArr4[i28];
                                        } else if (c6 == 'l') {
                                            i3 = i12;
                                            f15 = f34;
                                            float f46 = f33;
                                            int i29 = i3 + 0;
                                            int i30 = i3 + 1;
                                            path2.rLineTo(fArr4[i29], fArr4[i30]);
                                            f33 = f46 + fArr4[i29];
                                            f16 = fArr4[i30];
                                        } else if (c6 == c4) {
                                            i3 = i12;
                                            int i31 = i3 + 0;
                                            f33 += fArr4[i31];
                                            int i32 = i3 + 1;
                                            f34 += fArr4[i32];
                                            if (i3 > 0) {
                                                path2.rLineTo(fArr4[i31], fArr4[i32]);
                                            } else {
                                                path2.rMoveTo(fArr4[i31], fArr4[i32]);
                                            }
                                        } else if (c6 != 's') {
                                            if (c6 == 't') {
                                                if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                    f23 = f33 - f3;
                                                    f24 = f34 - f2;
                                                } else {
                                                    f24 = 0.0f;
                                                    f23 = 0.0f;
                                                }
                                                int i33 = i12 + 0;
                                                int i34 = i12 + 1;
                                                path2.rQuadTo(f23, f24, fArr4[i33], fArr4[i34]);
                                                f3 = f23 + f33;
                                                float f47 = f24 + f34;
                                                f33 += fArr4[i33];
                                                f34 += fArr4[i34];
                                                f2 = f47;
                                            }
                                            i3 = i12;
                                        } else {
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f21 = f34 - f2;
                                                f22 = f33 - f3;
                                            } else {
                                                f22 = 0.0f;
                                                f21 = 0.0f;
                                            }
                                            int i35 = i12 + 0;
                                            int i36 = i12 + 1;
                                            int i37 = i12 + 2;
                                            int i38 = i12 + 3;
                                            i8 = i12;
                                            f10 = f34;
                                            float f48 = f33;
                                            path.rCubicTo(f22, f21, fArr4[i35], fArr4[i36], fArr4[i37], fArr4[i38]);
                                            f13 = fArr4[i35] + f48;
                                            f12 = fArr4[i36] + f10;
                                            f11 = f48 + fArr4[i37];
                                            f14 = fArr4[i38];
                                        }
                                        f32 = f34;
                                        f31 = f33;
                                    } else {
                                        i3 = i12;
                                        int i39 = i3 + 0;
                                        int i40 = i3 + 1;
                                        path2.lineTo(fArr4[i39], fArr4[i40]);
                                        f33 = fArr4[i39];
                                        f34 = fArr4[i40];
                                    }
                                    f34 = f15 + f16;
                                } else {
                                    i8 = i12;
                                    f10 = f34;
                                    float f49 = f33;
                                    int i41 = i8 + 0;
                                    int i42 = i8 + 1;
                                    int i43 = i8 + 2;
                                    int i44 = i8 + 3;
                                    path2.rQuadTo(fArr4[i41], fArr4[i42], fArr4[i43], fArr4[i44]);
                                    f13 = fArr4[i41] + f49;
                                    f12 = fArr4[i42] + f10;
                                    float f50 = f49 + fArr4[i43];
                                    float f51 = fArr4[i44];
                                    f11 = f50;
                                    f14 = f51;
                                }
                                fArr = fArr4;
                                c2 = c6;
                                i4 = i11;
                            } else {
                                i8 = i12;
                                f10 = f34;
                                float f52 = f33;
                                int i45 = i8 + 2;
                                int i46 = i8 + 3;
                                int i47 = i8 + 4;
                                int i48 = i8 + 5;
                                path.rCubicTo(fArr4[i8 + 0], fArr4[i8 + 1], fArr4[i45], fArr4[i46], fArr4[i47], fArr4[i48]);
                                f13 = fArr4[i45] + f52;
                                f12 = fArr4[i46] + f10;
                                f11 = f52 + fArr4[i47];
                                f14 = fArr4[i48];
                            }
                            f8 = f10 + f14;
                            f3 = f13;
                            f2 = f12;
                            f9 = f11;
                            f33 = f9;
                            f34 = f8;
                            fArr = fArr4;
                            c2 = c6;
                            i4 = i11;
                        } else {
                            i5 = i12;
                            float f53 = f34;
                            float f54 = f33;
                            int i49 = i5 + 5;
                            float f55 = fArr4[i49] + f54;
                            int i50 = i5 + 6;
                            float f56 = fArr4[i50] + f53;
                            float f57 = fArr4[i5 + 0];
                            float f58 = fArr4[i5 + 1];
                            float f59 = fArr4[i5 + 2];
                            boolean z = fArr4[i5 + 3] != 0.0f;
                            boolean z2 = fArr4[i5 + 4] != 0.0f;
                            fArr2 = fArr4;
                            float f60 = f59;
                            c3 = c6;
                            i6 = i11;
                            a(path, f54, f53, f55, f56, f57, f58, f60, z, z2);
                            f4 = f54 + fArr2[i49];
                            f5 = f53 + fArr2[i50];
                        }
                        i12 = i3 + i2;
                        c4 = 'm';
                        i10 = 0;
                        b[] bVarArr3 = bVarArr;
                        c5 = c2;
                        c6 = c5;
                        fArr4 = fArr;
                        i11 = i4;
                    } else {
                        i7 = i12;
                        fArr = fArr4;
                        c2 = c6;
                        i4 = i11;
                        int i51 = i7 + 2;
                        int i52 = i7 + 3;
                        int i53 = i7 + 4;
                        int i54 = i7 + 5;
                        path.cubicTo(fArr[i7 + 0], fArr[i7 + 1], fArr[i51], fArr[i52], fArr[i53], fArr[i54]);
                        f33 = fArr[i53];
                        f34 = fArr[i54];
                        f7 = fArr[i51];
                        f6 = fArr[i52];
                    }
                    f3 = f7;
                    f2 = f6;
                    i12 = i3 + i2;
                    c4 = 'm';
                    i10 = 0;
                    b[] bVarArr32 = bVarArr;
                    c5 = c2;
                    c6 = c5;
                    fArr4 = fArr;
                    i11 = i4;
                } else {
                    i5 = i12;
                    fArr2 = fArr4;
                    c3 = c6;
                    i6 = i11;
                    int i55 = i5 + 5;
                    int i56 = i5 + 6;
                    a(path, f33, f34, fArr2[i55], fArr2[i56], fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                    f4 = fArr2[i55];
                    f5 = fArr2[i56];
                }
                f2 = f34;
                f3 = f33;
                i12 = i3 + i2;
                c4 = 'm';
                i10 = 0;
                b[] bVarArr322 = bVarArr;
                c5 = c2;
                c6 = c5;
                fArr4 = fArr;
                i11 = i4;
            }
            float f61 = f34;
            int i57 = i11;
            int i58 = i10;
            fArr3[i58] = f33;
            fArr3[1] = f61;
            fArr3[2] = f3;
            fArr3[3] = f2;
            fArr3[4] = f31;
            fArr3[5] = f32;
            i11 = i57 + 1;
            i9 = 6;
            c4 = 'm';
            i10 = i58;
            c5 = bVarArr[i57].f4808a;
            bVarArr2 = bVarArr;
        }
    }

    public b(b bVar) {
        this.f4808a = bVar.f4808a;
        float[] fArr = bVar.f4809b;
        this.f4809b = a.a(fArr, 0, fArr.length);
    }

    public static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
        double d2;
        double d3;
        float f9 = f2;
        float f10 = f4;
        float f11 = f6;
        float f12 = f7;
        boolean z3 = z2;
        double radians = Math.toRadians((double) f8);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d4 = (double) f9;
        double d5 = (double) f3;
        double d6 = (d5 * sin) + (d4 * cos);
        double d7 = d4;
        double d8 = (double) f11;
        double d9 = d6 / d8;
        double d10 = radians;
        double d11 = (double) f12;
        double d12 = ((d5 * cos) + (((double) (-f9)) * sin)) / d11;
        double d13 = d5;
        double d14 = (double) f5;
        double d15 = ((d14 * sin) + (((double) f10) * cos)) / d8;
        double d16 = ((d14 * cos) + (((double) (-f10)) * sin)) / d11;
        double d17 = d9 - d15;
        double d18 = d12 - d16;
        double d19 = (d9 + d15) / 2.0d;
        double d20 = (d12 + d16) / 2.0d;
        double d21 = sin;
        double d22 = (d18 * d18) + (d17 * d17);
        String str = "PathParser";
        if (d22 == 0.0d) {
            Log.w(str, " Points are coincident");
            return;
        }
        double d23 = (1.0d / d22) - 0.25d;
        if (d23 < 0.0d) {
            StringBuilder sb = new StringBuilder();
            sb.append("Points are too far apart ");
            sb.append(d22);
            Log.w(str, sb.toString());
            float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
            a(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d23);
        double d24 = d17 * sqrt2;
        double d25 = sqrt2 * d18;
        if (z == z3) {
            d3 = d19 - d25;
            d2 = d20 + d24;
        } else {
            d3 = d19 + d25;
            d2 = d20 - d24;
        }
        double atan2 = Math.atan2(d12 - d2, d9 - d3);
        double atan22 = Math.atan2(d16 - d2, d15 - d3) - atan2;
        int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
        if (z3 != (i2 >= 0)) {
            atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d26 = d3 * d8;
        double d27 = d2 * d11;
        double d28 = (d26 * cos) - (d27 * d21);
        double d29 = (d27 * cos) + (d26 * d21);
        int ceil = (int) Math.ceil(Math.abs((4.0d * atan22) / 3.141592653589793d));
        double cos2 = Math.cos(d10);
        double sin2 = Math.sin(d10);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d30 = atan2;
        double d31 = -d8;
        double d32 = d31 * cos2;
        double d33 = d11 * sin2;
        double d34 = d31 * sin2;
        double d35 = d11 * cos2;
        double d36 = (cos3 * d35) + (sin3 * d34);
        double d37 = d34;
        double d38 = atan22 / ((double) ceil);
        int i3 = 0;
        double d39 = (d32 * sin3) - (d33 * cos3);
        double d40 = d36;
        double d41 = d7;
        double d42 = d30;
        while (i3 < ceil) {
            double d43 = d42 + d38;
            double sin4 = Math.sin(d43);
            double cos4 = Math.cos(d43);
            double d44 = d8;
            double d45 = cos4;
            double d46 = d38;
            double d47 = e.a.a.a.a.d(d44, cos2, d45, d28) - (d33 * sin4);
            double d48 = e.a.a.a.a.d(d44, sin2, d45, d29);
            double d49 = d28;
            double d50 = (d35 * sin4) + d48;
            double d51 = (d32 * sin4) - (d33 * cos4);
            double d52 = (cos4 * d35) + (sin4 * d37);
            double d53 = d43 - d42;
            double tan = Math.tan(d53 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d53)) / 3.0d;
            double d54 = d35;
            double d55 = (d39 * sqrt3) + d41;
            double d56 = (d40 * sqrt3) + d13;
            double d57 = cos2;
            double d58 = d47 - (sqrt3 * d51);
            double d59 = sin2;
            double d60 = d50 - (sqrt3 * d52);
            int i4 = ceil;
            double d61 = d8;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) d55, (float) d56, (float) d58, (float) d60, (float) d47, (float) d50);
            i3++;
            d35 = d54;
            cos2 = d57;
            sin2 = d59;
            ceil = i4;
            d41 = d47;
            d13 = d50;
            d8 = d61;
            d42 = d43;
            d40 = d52;
            d39 = d51;
            d38 = d46;
            d28 = d49;
        }
    }
}
