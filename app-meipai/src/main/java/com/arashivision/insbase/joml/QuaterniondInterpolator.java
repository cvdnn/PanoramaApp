package com.arashivision.insbase.joml;

import e.a.a.a.a;

public class QuaterniondInterpolator {
    public final double[] m = new double[9];
    public final SvdDecomposition3d svdDecomposition3d = new SvdDecomposition3d();
    public final Matrix3d u = new Matrix3d();
    public final Matrix3d v = new Matrix3d();

    public static class SvdDecomposition3d {
        public final double[] rv1 = new double[3];
        public final double[] v = new double[9];
        public final double[] w = new double[3];

        public static double PYTHAG(double d2, double d3) {
            double abs = Math.abs(d2);
            double abs2 = Math.abs(d3);
            if (abs > abs2) {
                double d4 = abs2 / abs;
                return Math.sqrt((d4 * d4) + 1.0d) * abs;
            } else if (abs2 <= 0.0d) {
                return 0.0d;
            } else {
                double d5 = abs / abs2;
                return Math.sqrt((d5 * d5) + 1.0d) * abs2;
            }
        }

        private double SIGN(double d2, double d3) {
            int i2 = (d3 > 0.0d ? 1 : (d3 == 0.0d ? 0 : -1));
            double abs = Math.abs(d2);
            return i2 >= 0 ? abs : -abs;
        }

        public void svd(double[] dArr, int i2, Matrix3d matrix3d, Matrix3d matrix3d2) {
            double d2;
            double[] dArr2;
            int i3;
            double d3;
            boolean z;
            double d4;
            int i4;
            double d5;
            int i5;
            double[] dArr3 = dArr;
            int i6 = i2;
            double d6 = 0.0d;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            int i7 = 0;
            int i8 = 0;
            while (i7 < 3) {
                int i9 = i7 + 1;
                this.rv1[i7] = d7 * d8;
                double d10 = d6;
                for (int i10 = i7; i10 < 3; i10++) {
                    d10 += Math.abs(dArr3[(i7 * 3) + i10]);
                }
                if (d10 != d6) {
                    double d11 = d6;
                    for (int i11 = i7; i11 < 3; i11++) {
                        int i12 = (i7 * 3) + i11;
                        dArr3[i12] = dArr3[i12] / d10;
                        d11 = (dArr3[i12] * dArr3[i12]) + d11;
                    }
                    int i13 = i7 * 3;
                    int i14 = i7 + i13;
                    double d12 = dArr3[i14];
                    double d13 = -SIGN(Math.sqrt(d11), d12);
                    double d14 = (d12 * d13) - d11;
                    dArr3[i14] = d12 - d13;
                    if (i7 != 2) {
                        int i15 = i9;
                        while (true) {
                            if (i15 >= 3) {
                                break;
                            }
                            double d15 = d13;
                            double d16 = 0.0d;
                            int i16 = i7;
                            for (int i17 = 3; i16 < i17; i17 = 3) {
                                d16 = (dArr3[i16 + i13] * dArr3[(i15 * 3) + i16]) + d16;
                                i16++;
                            }
                            double d17 = d16 / d14;
                            for (int i18 = i7; i18 < 3; i18++) {
                                int i19 = (i15 * 3) + i18;
                                dArr3[i19] = (dArr3[i18 + i13] * d17) + dArr3[i19];
                            }
                            i15++;
                            d13 = d15;
                        }
                    }
                    d5 = d13;
                    for (int i20 = i7; i20 < 3; i20++) {
                        int i21 = i20 + i13;
                        dArr3[i21] = dArr3[i21] * d10;
                    }
                } else {
                    d5 = 0.0d;
                }
                this.w[i7] = d10 * d5;
                if (i7 >= 3 || i7 == 2) {
                    i5 = i9;
                    d7 = 0.0d;
                } else {
                    int i22 = i9;
                    double d18 = 0.0d;
                    for (int i23 = 3; i22 < i23; i23 = 3) {
                        d18 += Math.abs(dArr3[(i22 * 3) + i7]);
                        i22++;
                    }
                    if (d18 != 0.0d) {
                        double d19 = 0.0d;
                        for (int i24 = i9; i24 < 3; i24++) {
                            int i25 = (i24 * 3) + i7;
                            dArr3[i25] = dArr3[i25] / d18;
                            d19 += dArr3[i25] * dArr3[i25];
                        }
                        int i26 = (i9 * 3) + i7;
                        double d20 = dArr3[i26];
                        double d21 = -SIGN(Math.sqrt(d19), d20);
                        double d22 = (d20 * d21) - d19;
                        dArr3[i26] = d20 - d21;
                        for (int i27 = i9; i27 < 3; i27++) {
                            this.rv1[i27] = dArr3[(i27 * 3) + i7] / d22;
                        }
                        if (i7 != 2) {
                            int i28 = i9;
                            while (true) {
                                int i29 = 3;
                                if (i28 >= 3) {
                                    break;
                                }
                                int i30 = i9;
                                double d23 = 0.0d;
                                while (i30 < i29) {
                                    int i31 = i30 * 3;
                                    d23 = (dArr3[i28 + i31] * dArr3[i31 + i7]) + d23;
                                    i30++;
                                    i29 = 3;
                                }
                                int i32 = i9;
                                for (int i33 = i29; i32 < i33; i33 = 3) {
                                    int i34 = (i32 * 3) + i28;
                                    int i35 = i9;
                                    dArr3[i34] = (this.rv1[i32] * d23) + dArr3[i34];
                                    i32++;
                                    i9 = i35;
                                }
                                int i36 = i9;
                                i28++;
                            }
                        }
                        i5 = i9;
                        for (int i37 = i5; i37 < 3; i37++) {
                            int i38 = (i37 * 3) + i7;
                            dArr3[i38] = dArr3[i38] * d18;
                        }
                        d7 = d18;
                        d8 = d21;
                        d9 = Math.max(d9, Math.abs(this.rv1[i7]) + Math.abs(this.w[i7]));
                        i7 = i5;
                        i8 = i7;
                        d6 = 0.0d;
                    } else {
                        i5 = i9;
                        d7 = d18;
                    }
                }
                d8 = 0.0d;
                d9 = Math.max(d9, Math.abs(this.rv1[i7]) + Math.abs(this.w[i7]));
                i7 = i5;
                i8 = i7;
                d6 = 0.0d;
            }
            int i39 = i8;
            int i40 = 2;
            while (true) {
                d2 = 1.0d;
                if (i40 < 0) {
                    break;
                }
                if (i40 < 2) {
                    if (d8 != 0.0d) {
                        int i41 = i39;
                        while (true) {
                            i4 = 3;
                            if (i41 >= 3) {
                                break;
                            }
                            this.v[(i40 * 3) + i41] = (dArr3[(i41 * 3) + i40] / dArr3[(i39 * 3) + i40]) / d8;
                            i41++;
                        }
                        int i42 = i39;
                        while (i42 < i4) {
                            int i43 = i39;
                            double d24 = 0.0d;
                            while (i43 < i4) {
                                d24 += dArr3[(i43 * 3) + i40] * this.v[(i42 * 3) + i43];
                                i43++;
                                i4 = 3;
                            }
                            int i44 = i39;
                            for (int i45 = i4; i44 < i45; i45 = 3) {
                                double[] dArr4 = this.v;
                                int i46 = (i42 * 3) + i44;
                                dArr4[i46] = (dArr4[(i40 * 3) + i44] * d24) + dArr4[i46];
                                i44++;
                            }
                            i42++;
                            i4 = 3;
                        }
                    }
                    while (i39 < 3) {
                        double[] dArr5 = this.v;
                        int i47 = (i39 * 3) + i40;
                        dArr5[(i40 * 3) + i39] = 0.0d;
                        dArr5[i47] = 0.0d;
                        i39++;
                    }
                }
                this.v[(i40 * 3) + i40] = 1.0d;
                d8 = this.rv1[i40];
                int i48 = i40;
                i40--;
                i39 = i48;
            }
            int i49 = 2;
            while (i49 >= 0) {
                int i50 = i49 + 1;
                double d25 = this.w[i49];
                if (i49 < 2) {
                    for (int i51 = i50; i51 < 3; i51++) {
                        dArr3[(i51 * 3) + i49] = 0.0d;
                    }
                }
                if (d25 != 0.0d) {
                    double d26 = d2 / d25;
                    if (i49 != 2) {
                        int i52 = i50;
                        while (true) {
                            if (i52 >= 3) {
                                break;
                            }
                            int i53 = i50;
                            double d27 = 0.0d;
                            for (int i54 = 3; i53 < i54; i54 = 3) {
                                d27 = (dArr3[(i49 * 3) + i53] * dArr3[(i52 * 3) + i53]) + d27;
                                i53++;
                            }
                            int i55 = i49 * 3;
                            double d28 = (d27 / dArr3[i49 + i55]) * d26;
                            for (int i56 = i49; i56 < 3; i56++) {
                                int i57 = (i52 * 3) + i56;
                                dArr3[i57] = (dArr3[i56 + i55] * d28) + dArr3[i57];
                            }
                            i52++;
                        }
                    }
                    for (int i58 = i49; i58 < 3; i58++) {
                        int i59 = (i49 * 3) + i58;
                        dArr3[i59] = dArr3[i59] * d26;
                    }
                } else {
                    for (int i60 = i49; i60 < 3; i60++) {
                        dArr3[(i49 * 3) + i60] = 0.0d;
                    }
                }
                int i61 = (i49 * 3) + i49;
                dArr3[i61] = dArr3[i61] + 1.0d;
                i49--;
                d2 = 1.0d;
            }
            int i62 = 0;
            int i63 = 2;
            while (i63 >= 0) {
                int i64 = 0;
                while (true) {
                    if (i64 >= i6) {
                        dArr2 = dArr3;
                        i3 = i6;
                        d3 = d9;
                        break;
                    }
                    int i65 = i63;
                    while (true) {
                        z = true;
                        if (i65 < 0) {
                            break;
                        }
                        i62 = i65 - 1;
                        if (Math.abs(this.rv1[i65]) + d9 == d9) {
                            z = false;
                            break;
                        } else if (Math.abs(this.w[i62]) + d9 == d9) {
                            break;
                        } else {
                            i65--;
                        }
                    }
                    if (z) {
                        int i66 = i65;
                        double d29 = 1.0d;
                        while (i66 <= i63) {
                            double d30 = this.rv1[i66] * d29;
                            if (Math.abs(d30) + d9 != d9) {
                                d4 = d9;
                                double d31 = this.w[i66];
                                double PYTHAG = PYTHAG(d30, d31);
                                this.w[i66] = PYTHAG;
                                double d32 = 1.0d / PYTHAG;
                                double d33 = d31 * d32;
                                double d34 = (-d30) * d32;
                                for (int i67 = 0; i67 < 3; i67++) {
                                    int i68 = (i62 * 3) + i67;
                                    double d35 = dArr3[i68];
                                    int i69 = (i66 * 3) + i67;
                                    double d36 = dArr3[i69];
                                    dArr3[i68] = (d36 * d34) + (d35 * d33);
                                    dArr3[i69] = (d36 * d33) - (d35 * d34);
                                }
                                d29 = d34;
                            } else {
                                d4 = d9;
                            }
                            i66++;
                            d9 = d4;
                        }
                    }
                    d3 = d9;
                    double[] dArr6 = this.w;
                    double d37 = dArr6[i63];
                    if (i65 == i63) {
                        if (d37 < 0.0d) {
                            dArr6[i63] = -d37;
                            for (int i70 = 0; i70 < 3; i70++) {
                                double[] dArr7 = this.v;
                                int i71 = (i63 * 3) + i70;
                                dArr7[i71] = -dArr7[i71];
                            }
                        }
                        dArr2 = dArr3;
                        i3 = i6;
                    } else if (i64 != i6 - 1) {
                        double d38 = dArr6[i65];
                        i62 = i63 - 1;
                        double d39 = dArr6[i62];
                        double[] dArr8 = this.rv1;
                        double d40 = dArr8[i62];
                        double d41 = dArr8[i63];
                        int i72 = i63;
                        double d42 = (((d40 + d41) * (d40 - d41)) + ((d39 + d37) * (d39 - d37))) / ((2.0d * d41) * d39);
                        int i73 = i64;
                        int i74 = i65;
                        double SIGN = ((((d39 / (d42 + SIGN(PYTHAG(d42, 1.0d), d42))) - d41) * d41) + ((d37 + d38) * (d38 - d37))) / d38;
                        int i75 = i74;
                        double d43 = 1.0d;
                        double d44 = 1.0d;
                        while (i75 <= i62) {
                            int i76 = i75 + 1;
                            double d45 = this.rv1[i76];
                            double d46 = this.w[i76];
                            double d47 = d44 * d45;
                            double d48 = d43 * d45;
                            double PYTHAG2 = PYTHAG(SIGN, d47);
                            int i77 = i62;
                            this.rv1[i75] = PYTHAG2;
                            double d49 = SIGN / PYTHAG2;
                            d44 = d47 / PYTHAG2;
                            double d50 = (d48 * d44) + (d38 * d49);
                            double d51 = (d48 * d49) - (d38 * d44);
                            double d52 = d46 * d44;
                            double d53 = d46 * d49;
                            int i78 = i73;
                            for (int i79 = 0; i79 < 3; i79++) {
                                double[] dArr9 = this.v;
                                int i80 = (i75 * 3) + i79;
                                double d54 = dArr9[i80];
                                int i81 = (i76 * 3) + i79;
                                double d55 = dArr9[i81];
                                dArr9[i80] = (d55 * d44) + (d54 * d49);
                                dArr9[i81] = (d55 * d49) - (d54 * d44);
                            }
                            double PYTHAG3 = PYTHAG(d50, d52);
                            this.w[i75] = PYTHAG3;
                            if (PYTHAG3 != 0.0d) {
                                double d56 = 1.0d / PYTHAG3;
                                double d57 = d50 * d56;
                                d44 = d52 * d56;
                                d49 = d57;
                            }
                            double d58 = (d49 * d51) + (d44 * d53);
                            double d59 = (d53 * d49) - (d51 * d44);
                            for (int i82 = 0; i82 < 3; i82++) {
                                int i83 = (i75 * 3) + i82;
                                double[] dArr10 = dArr;
                                double d60 = dArr10[i83];
                                int i84 = (i76 * 3) + i82;
                                double d61 = dArr10[i84];
                                dArr10[i83] = (d61 * d44) + (d60 * d49);
                                dArr10[i84] = (d61 * d49) - (d60 * d44);
                            }
                            Object obj = dArr;
                            i75 = i76;
                            i62 = i77;
                            i73 = i78;
                            double d62 = d59;
                            d43 = d49;
                            SIGN = d58;
                            d38 = d62;
                        }
                        int i85 = i62;
                        int i86 = i73;
                        double[] dArr11 = dArr;
                        double[] dArr12 = this.rv1;
                        dArr12[i74] = 0.0d;
                        dArr12[i72] = SIGN;
                        this.w[i72] = d38;
                        i6 = i2;
                        i64 = i86 + 1;
                        i63 = i72;
                        dArr3 = dArr11;
                        d9 = d3;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No convergence after ");
                        sb.append(i2);
                        sb.append(" iterations");
                        throw new RuntimeException(sb.toString());
                    }
                }
                i63--;
                i6 = i3;
                dArr3 = dArr2;
                d9 = d3;
            }
            matrix3d.set(dArr3);
            matrix3d2.set(this.v);
        }
    }

    public Quaterniond computeWeightedAverage(Quaterniond[] quaterniondArr, double[] dArr, int i2, Quaterniond quaterniond) {
        QuaterniondInterpolator quaterniondInterpolator = this;
        Quaterniond[] quaterniondArr2 = quaterniondArr;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        int i3 = 0;
        double d10 = 0.0d;
        while (i3 < quaterniondArr2.length) {
            Quaterniond quaterniond2 = quaterniondArr2[i3];
            double d11 = quaterniond2.x;
            double d12 = d11 + d11;
            double d13 = quaterniond2.y;
            double d14 = d13 + d13;
            double d15 = d4;
            double d16 = quaterniond2.z;
            double d17 = d16 + d16;
            double d18 = d11 * d12;
            double d19 = d14 * d13;
            double d20 = d17 * d16;
            double d21 = d13 * d12;
            double d22 = d12 * d16;
            double d23 = d2;
            double d24 = quaterniond2.w;
            double d25 = d12 * d24;
            double d26 = d16 * d14;
            double d27 = d14 * d24;
            double d28 = d24 * d17;
            double d29 = 1.0d - d19;
            d5 = a.h(d29, d20, dArr[i3], d5);
            double d30 = ((d21 + d28) * dArr[i3]) + d10;
            d6 = a.h(d22, d27, dArr[i3], d6);
            int i4 = i3;
            d3 = a.h(d21, d28, dArr[i3], d3);
            d2 = (((1.0d - d20) - d18) * dArr[i4]) + d23;
            double d31 = ((d26 + d25) * dArr[i4]) + d15;
            d7 = ((d22 + d27) * dArr[i4]) + d7;
            d8 = a.h(d26, d25, dArr[i4], d8);
            d9 = a.h(d29, d18, dArr[i4], d9);
            i3 = i4 + 1;
            d4 = d31;
            d10 = d30;
            quaterniondInterpolator = this;
            quaterniondArr2 = quaterniondArr;
        }
        double d32 = d2;
        double d33 = d4;
        double[] dArr2 = quaterniondInterpolator.m;
        dArr2[0] = d5;
        dArr2[1] = d10;
        dArr2[2] = d6;
        dArr2[3] = d3;
        dArr2[4] = d32;
        dArr2[5] = d33;
        dArr2[6] = d7;
        dArr2[7] = d8;
        dArr2[8] = d9;
        quaterniondInterpolator.svdDecomposition3d.svd(dArr2, i2, quaterniondInterpolator.u, quaterniondInterpolator.v);
        quaterniondInterpolator.u.mul((Matrix3dc) quaterniondInterpolator.v.transpose());
        return quaterniond.setFromNormalized((Matrix3dc) quaterniondInterpolator.u).normalize();
    }
}
