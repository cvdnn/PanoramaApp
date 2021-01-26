package com.arashivision.onestream.math;

import e.a.a.a.a;

public class Matrix {
    public static final double[] sTemp = new double[32];

    public static void frustumM(double[] dArr, int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
        if (d2 == d3) {
            throw new IllegalArgumentException("left == right");
        } else if (d5 == d4) {
            throw new IllegalArgumentException("top == bottom");
        } else if (d6 == d7) {
            throw new IllegalArgumentException("near == far");
        } else if (d6 <= 0.0d) {
            throw new IllegalArgumentException("near <= 0.0");
        } else if (d7 > 0.0d) {
            double d8 = 1.0d / (d3 - d2);
            double d9 = 1.0d / (d5 - d4);
            double d10 = 1.0d / (d6 - d7);
            double d11 = d6 * d9 * 2.0d;
            double d12 = (d3 + d2) * d8;
            double d13 = (d5 + d4) * d9;
            double d14 = (d7 + d6) * d10;
            double d15 = d7 * d6 * d10 * 2.0d;
            dArr[i2 + 0] = d6 * d8 * 2.0d;
            dArr[i2 + 5] = d11;
            dArr[i2 + 8] = d12;
            dArr[i2 + 9] = d13;
            dArr[i2 + 10] = d14;
            dArr[i2 + 14] = d15;
            dArr[i2 + 11] = -1.0d;
            dArr[i2 + 1] = 0.0d;
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 3] = 0.0d;
            dArr[i2 + 4] = 0.0d;
            dArr[i2 + 6] = 0.0d;
            dArr[i2 + 7] = 0.0d;
            dArr[i2 + 12] = 0.0d;
            dArr[i2 + 13] = 0.0d;
            dArr[i2 + 15] = 0.0d;
        } else {
            throw new IllegalArgumentException("far <= 0.0");
        }
    }

    public static boolean invertM(double[] dArr, int i2, double[] dArr2, int i3) {
        double d2 = dArr2[i3 + 0];
        double d3 = dArr2[i3 + 1];
        double d4 = dArr2[i3 + 2];
        double d5 = dArr2[i3 + 3];
        double d6 = dArr2[i3 + 4];
        double d7 = dArr2[i3 + 5];
        double d8 = dArr2[i3 + 6];
        double d9 = dArr2[i3 + 7];
        double d10 = dArr2[i3 + 8];
        double d11 = dArr2[i3 + 9];
        double d12 = dArr2[i3 + 10];
        double d13 = dArr2[i3 + 11];
        double d14 = dArr2[i3 + 12];
        double d15 = dArr2[i3 + 13];
        double d16 = dArr2[i3 + 14];
        double d17 = dArr2[i3 + 15];
        double d18 = d12 * d17;
        double d19 = d16 * d13;
        double d20 = d8 * d17;
        double d21 = d16 * d9;
        double d22 = d8 * d13;
        double d23 = d12 * d9;
        double d24 = d4 * d17;
        double d25 = d16 * d5;
        double d26 = d4 * d13;
        double d27 = d12 * d5;
        double d28 = d4 * d9;
        double d29 = d8 * d5;
        double d30 = (d22 * d15) + (d21 * d11) + (d18 * d7);
        double j2 = a.j(d23, d15, (d20 * d11) + (d19 * d7), d30);
        double d31 = (d27 * d15) + (d24 * d11) + (d19 * d3);
        double j3 = a.j(d26, d15, (d25 * d11) + (d18 * d3), d31);
        double d32 = (d28 * d15) + (d25 * d7) + (d20 * d3);
        double j4 = a.j(d29, d15, (d24 * d7) + (d21 * d3), d32);
        double d33 = (d29 * d11) + (d26 * d7) + (d23 * d3);
        double j5 = a.j(d28, d11, (d27 * d7) + (d22 * d3), d33);
        double d34 = (d23 * d14) + (d20 * d10) + (d19 * d6);
        double j6 = a.j(d22, d14, (d21 * d10) + (d18 * d6), d34);
        double d35 = d26 * d14;
        double d36 = d35 + (d25 * d10) + (d18 * d2);
        double d37 = d14;
        double j7 = a.j(d27, d37, (d24 * d10) + (d19 * d2), d36);
        double d38 = d29 * d14;
        double d39 = d28;
        double j8 = a.j(d39, d37, (d25 * d6) + (d20 * d2), d38 + (d24 * d6) + (d21 * d2));
        double d40 = d28 * d10;
        double d41 = (d26 * d6) + (d23 * d2);
        double d42 = d29;
        double d43 = d10;
        double j9 = a.j(d42, d43, d41, d40 + (d27 * d6) + (d22 * d2));
        double d44 = d10 * d15;
        double d45 = d14 * d11;
        double d46 = d6 * d15;
        double d47 = d14 * d7;
        double d48 = d6 * d11;
        double d49 = d10 * d7;
        double d50 = d15 * d2;
        double d51 = d14 * d3;
        double d52 = d11 * d2;
        double d53 = d10 * d3;
        double d54 = d7 * d2;
        double d55 = d3 * d6;
        double d56 = d49;
        double d57 = d17;
        double j10 = a.j(d56, d57, (d46 * d13) + (d45 * d9), (d48 * d17) + (d47 * d13) + (d44 * d9));
        double d58 = d52;
        double j11 = a.j(d58, d57, (d51 * d13) + (d44 * d5), (d53 * d17) + (d50 * d13) + (d45 * d5));
        double d59 = d17;
        double d60 = d55;
        double j12 = a.j(d59, d60, (d50 * d9) + (d47 * d5), (d54 * d17) + (d51 * d9) + (d46 * d5));
        double d61 = (d9 * d53) + (d5 * d48);
        double d62 = d13;
        double d63 = d54;
        double j13 = a.j(d62, d63, d61, (d55 * d13) + (d52 * d9) + (d49 * d5));
        double d64 = d47;
        double d65 = d12;
        double j14 = a.j(d64, d65, (d44 * d8) + (d48 * d16), (d45 * d8) + (d49 * d16) + (d46 * d12));
        double d66 = d45;
        double d67 = d4;
        double j15 = a.j(d66, d67, (d53 * d16) + (d50 * d12), (d51 * d12) + (d44 * d4) + (d52 * d16));
        double d68 = d47 * d4;
        double d69 = (d46 * d4) + (d16 * d54);
        double d70 = d51;
        double d71 = d8;
        double j16 = a.j(d70, d71, d69, d68 + (d55 * d16) + (d50 * d8));
        double d72 = d53 * d8;
        double d73 = (d55 * d12) + (d52 * d8);
        double d74 = d49;
        double j17 = a.j(d74, d67, d73, d72 + (d48 * d4) + (d54 * d12));
        double d75 = d10 * j4;
        double d76 = d14 * j5;
        double d77 = d76 + d75 + (d6 * j3) + (d2 * j2);
        if (d77 == 0.0d) {
            return false;
        }
        double d78 = 1.0d / d77;
        dArr[i2] = j2 * d78;
        dArr[i2 + 1] = j3 * d78;
        dArr[i2 + 2] = j4 * d78;
        dArr[i2 + 3] = j5 * d78;
        dArr[i2 + 4] = j6 * d78;
        dArr[i2 + 5] = j7 * d78;
        dArr[i2 + 6] = j8 * d78;
        dArr[i2 + 7] = j9 * d78;
        dArr[i2 + 8] = j10 * d78;
        dArr[i2 + 9] = j11 * d78;
        dArr[i2 + 10] = j12 * d78;
        dArr[i2 + 11] = j13 * d78;
        dArr[i2 + 12] = j14 * d78;
        dArr[i2 + 13] = j15 * d78;
        dArr[i2 + 14] = j16 * d78;
        dArr[i2 + 15] = j17 * d78;
        return true;
    }

    public static double length(double d2, double d3, double d4) {
        return Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
    }

    public static void multiplyMM(double[] dArr, int i2, double[] dArr2, int i3, double[] dArr3, int i4) {
        double[] dArr4 = dArr;
        double[] dArr5 = dArr2;
        double[] dArr6 = dArr3;
        String str = dArr4 == null ? "Result matrix can not be null." : dArr5 == null ? "Left hand side matrix can not be null." : dArr6 == null ? "Right hand side matrix can not be null." : i2 + 16 > dArr4.length ? "Specified result offset would overflow the passed result matrix." : i3 + 16 > dArr5.length ? "Specified left hand side offset would overflow the passed lhs matrix." : i4 + 16 > dArr6.length ? "Specified right hand side offset would overflow the passed rhs matrix." : null;
        if (str == null) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    double d2 = 0.0d;
                    for (int i7 = 0; i7 < 4; i7++) {
                        d2 += dArr5[(i7 * 4) + i5 + i3] * dArr6[(i6 * 4) + i7 + i4];
                    }
                    dArr4[(i6 * 4) + i5 + i2] = d2;
                }
            }
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void multiplyMV(double[] dArr, int i2, double[] dArr2, int i3, double[] dArr3, int i4) {
        String str = dArr == null ? "Result vector can not be null." : dArr2 == null ? "Left hand side matrix can not be null." : dArr3 == null ? "Right hand side vector can not be null." : i2 + 4 > dArr.length ? "Specified result offset would overflow the passed result vector." : i3 + 16 > dArr2.length ? "Specified left hand side offset would overflow the passed lhs matrix." : i4 + 4 > dArr3.length ? "Specified right hand side offset would overflow the passed rhs vector." : null;
        if (str == null) {
            for (int i5 = 0; i5 < 4; i5++) {
                double d2 = 0.0d;
                for (int i6 = 0; i6 < 4; i6++) {
                    d2 += dArr2[(i6 * 4) + i5 + i3] * dArr3[i6 + i4];
                }
                dArr[i5 + i2] = d2;
            }
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void orthoM(double[] dArr, int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
        if (d2 == d3) {
            throw new IllegalArgumentException("left == right");
        } else if (d4 == d5) {
            throw new IllegalArgumentException("bottom == top");
        } else if (d6 != d7) {
            double d8 = 1.0d / (d3 - d2);
            double d9 = 1.0d / (d5 - d4);
            double d10 = 1.0d / (d7 - d6);
            double d11 = d8 * 2.0d;
            double d12 = 2.0d * d9;
            double d13 = -2.0d * d10;
            double d14 = (-(d3 + d2)) * d8;
            double d15 = (-(d5 + d4)) * d9;
            double d16 = (-(d7 + d6)) * d10;
            dArr[i2 + 0] = d11;
            dArr[i2 + 5] = d12;
            dArr[i2 + 10] = d13;
            dArr[i2 + 12] = d14;
            dArr[i2 + 13] = d15;
            dArr[i2 + 14] = d16;
            dArr[i2 + 15] = 1.0d;
            dArr[i2 + 1] = 0.0d;
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 3] = 0.0d;
            dArr[i2 + 4] = 0.0d;
            dArr[i2 + 6] = 0.0d;
            dArr[i2 + 7] = 0.0d;
            dArr[i2 + 8] = 0.0d;
            dArr[i2 + 9] = 0.0d;
            dArr[i2 + 11] = 0.0d;
        } else {
            throw new IllegalArgumentException("near == far");
        }
    }

    public static void perspectiveM(double[] dArr, int i2, double d2, double d3, double d4, double d5) {
        double tan = 1.0d / Math.tan(d2 * 0.008726646259971648d);
        double d6 = 1.0d / (d4 - d5);
        dArr[i2 + 0] = tan / d3;
        dArr[i2 + 1] = 0.0d;
        dArr[i2 + 2] = 0.0d;
        dArr[i2 + 3] = 0.0d;
        dArr[i2 + 4] = 0.0d;
        dArr[i2 + 5] = tan;
        dArr[i2 + 6] = 0.0d;
        dArr[i2 + 7] = 0.0d;
        dArr[i2 + 8] = 0.0d;
        dArr[i2 + 9] = 0.0d;
        dArr[i2 + 10] = (d5 + d4) * d6;
        dArr[i2 + 11] = -1.0d;
        dArr[i2 + 12] = 0.0d;
        dArr[i2 + 13] = 0.0d;
        dArr[i2 + 14] = d5 * 2.0d * d4 * d6;
        dArr[i2 + 15] = 0.0d;
    }

    public static void rotateM(double[] dArr, int i2, double[] dArr2, int i3, double d2, double d3, double d4, double d5) {
        synchronized (sTemp) {
            setRotateM(sTemp, 0, d2, d3, d4, d5);
            multiplyMM(dArr, i2, dArr2, i3, sTemp, 0);
        }
    }

    public static void scaleM(double[] dArr, int i2, double[] dArr2, int i3, double d2, double d3, double d4) {
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i2 + i4;
            int i6 = i3 + i4;
            dArr[i5] = dArr2[i6] * d2;
            dArr[i5 + 4] = dArr2[i6 + 4] * d3;
            dArr[i5 + 8] = dArr2[i6 + 8] * d4;
            dArr[i5 + 12] = dArr2[i6 + 12];
        }
    }

    public static void setIdentityM(double[] dArr, int i2) {
        for (int i3 = 0; i3 < 16; i3++) {
            dArr[i2 + i3] = 0.0d;
        }
        for (int i4 = 0; i4 < 16; i4 += 5) {
            dArr[i2 + i4] = 1.0d;
        }
    }

    public static void setLookAtM(double[] dArr, int i2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d2;
        double d12 = d3;
        double d13 = d4;
        double d14 = d5 - d11;
        double d15 = d6 - d12;
        double d16 = d7 - d13;
        double length = 1.0d / length(d14, d15, d16);
        double d17 = d14 * length;
        double d18 = d15 * length;
        double d19 = d16 * length;
        double d20 = (d18 * d10) - (d19 * d9);
        double d21 = (d19 * d8) - (d17 * d10);
        double d22 = (d17 * d9) - (d18 * d8);
        double length2 = 1.0d / length(d20, d21, d22);
        double d23 = d20 * length2;
        double d24 = d21 * length2;
        double d25 = d22 * length2;
        double d26 = (d24 * d19) - (d25 * d18);
        double d27 = (d25 * d17) - (d23 * d19);
        double d28 = (d23 * d18) - (d24 * d17);
        dArr[i2 + 0] = d23;
        dArr[i2 + 1] = d26;
        dArr[i2 + 2] = -d17;
        dArr[i2 + 3] = 0.0d;
        dArr[i2 + 4] = d24;
        dArr[i2 + 5] = d27;
        dArr[i2 + 6] = -d18;
        dArr[i2 + 7] = 0.0d;
        dArr[i2 + 8] = d25;
        dArr[i2 + 9] = d28;
        dArr[i2 + 10] = -d19;
        dArr[i2 + 11] = 0.0d;
        dArr[i2 + 12] = 0.0d;
        dArr[i2 + 13] = 0.0d;
        dArr[i2 + 14] = 0.0d;
        dArr[i2 + 15] = 1.0d;
        translateM(dArr, i2, -d11, -d12, -d13);
    }

    public static void setRotateEulerM(double[] dArr, int i2, double d2, double d3, double d4) {
        double d5 = d2 * 0.017453292519943295d;
        double d6 = d3 * 0.017453292519943295d;
        double d7 = 0.017453292519943295d * d4;
        double cos = Math.cos(d5);
        double sin = Math.sin(d5);
        double cos2 = Math.cos(d6);
        double sin2 = Math.sin(d6);
        double cos3 = Math.cos(d7);
        double sin3 = Math.sin(d7);
        double d8 = cos * sin2;
        double d9 = sin * sin2;
        dArr[i2 + 0] = cos2 * cos3;
        double d10 = d9;
        dArr[i2 + 1] = (-cos2) * sin3;
        dArr[i2 + 2] = sin2;
        dArr[i2 + 3] = 0.0d;
        dArr[i2 + 4] = (cos * sin3) + (d8 * cos3);
        dArr[i2 + 5] = (cos * cos3) + ((-d8) * sin3);
        dArr[i2 + 6] = (-sin) * cos2;
        dArr[i2 + 7] = 0.0d;
        double d11 = d10;
        dArr[i2 + 8] = (sin * sin3) + ((-d11) * cos3);
        dArr[i2 + 9] = (sin * cos3) + (d11 * sin3);
        dArr[i2 + 10] = cos * cos2;
        dArr[i2 + 11] = 0.0d;
        dArr[i2 + 12] = 0.0d;
        dArr[i2 + 13] = 0.0d;
        dArr[i2 + 14] = 0.0d;
        dArr[i2 + 15] = 1.0d;
    }

    public static void setRotateM(double[] dArr, int i2, double d2, double d3, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        dArr[i2 + 3] = 0.0d;
        dArr[i2 + 7] = 0.0d;
        dArr[i2 + 11] = 0.0d;
        dArr[i2 + 12] = 0.0d;
        dArr[i2 + 13] = 0.0d;
        dArr[i2 + 14] = 0.0d;
        dArr[i2 + 15] = 1.0d;
        double d9 = 0.017453292519943295d * d2;
        double sin = Math.sin(d9);
        double cos = Math.cos(d9);
        if (1.0d == d3 && 0.0d == d4 && 0.0d == d5) {
            dArr[i2 + 5] = cos;
            dArr[i2 + 10] = cos;
            dArr[i2 + 6] = sin;
            dArr[i2 + 9] = -sin;
            dArr[i2 + 1] = 0.0d;
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 4] = 0.0d;
            dArr[i2 + 8] = 0.0d;
            dArr[i2 + 0] = 1.0d;
            return;
        }
        int i3 = (0.0d > d3 ? 1 : (0.0d == d3 ? 0 : -1));
        if (i3 == 0 && 1.0d == d4 && 0.0d == d5) {
            dArr[i2 + 0] = cos;
            dArr[i2 + 10] = cos;
            dArr[i2 + 8] = sin;
            dArr[i2 + 2] = -sin;
            dArr[i2 + 1] = 0.0d;
            dArr[i2 + 4] = 0.0d;
            dArr[i2 + 6] = 0.0d;
            dArr[i2 + 9] = 0.0d;
            dArr[i2 + 5] = 1.0d;
        } else if (i3 == 0 && 0.0d == d4 && 1.0d == d5) {
            dArr[i2 + 0] = cos;
            dArr[i2 + 5] = cos;
            dArr[i2 + 1] = sin;
            dArr[i2 + 4] = -sin;
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 6] = 0.0d;
            dArr[i2 + 8] = 0.0d;
            dArr[i2 + 9] = 0.0d;
            dArr[i2 + 10] = 1.0d;
        } else {
            double length = length(d3, d4, d5);
            if (1.0d != length) {
                double d10 = 1.0d / length;
                d7 = d3 * d10;
                d6 = d4 * d10;
                d8 = d10 * d5;
            } else {
                d7 = d3;
                d6 = d4;
                d8 = d5;
            }
            double d11 = 1.0d - cos;
            double d12 = d7 * d6;
            double d13 = d6 * d8;
            double d14 = d8 * d7;
            double d15 = d7 * sin;
            double d16 = d6 * sin;
            double d17 = sin * d8;
            double d18 = d11;
            double d19 = cos;
            dArr[i2 + 0] = a.d(d7, d7, d18, d19);
            double d20 = d12 * d11;
            dArr[i2 + 4] = d20 - d17;
            double d21 = d14 * d11;
            dArr[i2 + 8] = d21 + d16;
            dArr[i2 + 1] = d20 + d17;
            dArr[i2 + 5] = a.d(d6, d6, d18, d19);
            double d22 = d13 * d11;
            dArr[i2 + 9] = d22 - d15;
            dArr[i2 + 2] = d21 - d16;
            dArr[i2 + 6] = d22 + d15;
            dArr[i2 + 10] = a.d(d8, d8, d11, cos);
        }
    }

    public static void translateM(double[] dArr, int i2, double[] dArr2, int i3, double d2, double d3, double d4) {
        for (int i4 = 0; i4 < 12; i4++) {
            dArr[i2 + i4] = dArr2[i3 + i4];
        }
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = i3 + i5;
            dArr[i2 + i5 + 12] = (dArr2[i6 + 8] * d4) + (dArr2[i6 + 4] * d3) + (dArr2[i6] * d2) + dArr2[i6 + 12];
        }
    }

    public static void transposeM(double[] dArr, int i2, double[] dArr2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = (i4 * 4) + i3;
            dArr[i4 + i2] = dArr2[i5];
            dArr[i4 + 4 + i2] = dArr2[i5 + 1];
            dArr[i4 + 8 + i2] = dArr2[i5 + 2];
            dArr[i4 + 12 + i2] = dArr2[i5 + 3];
        }
    }

    public static void translateM(double[] dArr, int i2, double d2, double d3, double d4) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i2 + i3;
            int i5 = i4 + 12;
            double d5 = (dArr[i4 + 4] * d3) + (dArr[i4] * d2);
            dArr[i5] = a.i(dArr[i4 + 8], d4, d5, dArr[i5]);
        }
    }

    public static void rotateM(double[] dArr, int i2, double d2, double d3, double d4, double d5) {
        synchronized (sTemp) {
            setRotateM(sTemp, 0, d2, d3, d4, d5);
            multiplyMM(sTemp, 16, dArr, i2, sTemp, 0);
            double[] dArr2 = dArr;
            int i3 = i2;
            System.arraycopy(sTemp, 16, dArr, i2, 16);
        }
    }

    public static void scaleM(double[] dArr, int i2, double d2, double d3, double d4) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i2 + i3;
            dArr[i4] = dArr[i4] * d2;
            int i5 = i4 + 4;
            dArr[i5] = dArr[i5] * d3;
            int i6 = i4 + 8;
            dArr[i6] = dArr[i6] * d4;
        }
    }
}
