package com.arashivision.insbase.joml;

import e.a.a.a.a;

public class QuaternionfInterpolator {
    public final float[] m = new float[9];
    public final SvdDecomposition3f svdDecomposition3f = new SvdDecomposition3f();
    public final Matrix3f u = new Matrix3f();
    public final Matrix3f v = new Matrix3f();

    public static class SvdDecomposition3f {
        public final float[] rv1 = new float[3];
        public final float[] v = new float[9];
        public final float[] w = new float[3];

        public static float PYTHAG(float f2, float f3) {
            float abs = Math.abs(f2);
            float abs2 = Math.abs(f3);
            if (abs > abs2) {
                float f4 = abs2 / abs;
                return abs * ((float) Math.sqrt(((double) (f4 * f4)) + 1.0d));
            } else if (abs2 <= 0.0f) {
                return 0.0f;
            } else {
                float f5 = abs / abs2;
                return abs2 * ((float) Math.sqrt(((double) (f5 * f5)) + 1.0d));
            }
        }

        private float SIGN(float f2, float f3) {
            int i2 = (((double) f3) > 0.0d ? 1 : (((double) f3) == 0.0d ? 0 : -1));
            float abs = Math.abs(f2);
            return i2 >= 0 ? abs : -abs;
        }

        public void svd(float[] fArr, int i2, Matrix3f matrix3f, Matrix3f matrix3f2) {
            int i3;
            int i4;
            float f2;
            boolean z;
            float f3;
            float[] fArr2 = fArr;
            int i5 = i2;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i3 = 2;
                i4 = 3;
                if (i6 >= 3) {
                    break;
                }
                i7 = i6 + 1;
                this.rv1[i6] = f5 * f6;
                float f8 = f4;
                for (int i8 = i6; i8 < 3; i8++) {
                    f8 += Math.abs(fArr2[(i6 * 3) + i8]);
                }
                if (f8 != f4) {
                    float f9 = f4;
                    for (int i9 = i6; i9 < 3; i9++) {
                        int i10 = (i6 * 3) + i9;
                        fArr2[i10] = fArr2[i10] / f8;
                        f9 += fArr2[i10] * fArr2[i10];
                    }
                    int i11 = i6 * 3;
                    int i12 = i6 + i11;
                    float f10 = fArr2[i12];
                    f3 = -SIGN((float) Math.sqrt((double) f9), f10);
                    float f11 = (f10 * f3) - f9;
                    fArr2[i12] = f10 - f3;
                    if (i6 != 2) {
                        for (int i13 = i7; i13 < 3; i13++) {
                            float f12 = 0.0f;
                            for (int i14 = i6; i14 < 3; i14++) {
                                f12 = (fArr2[i14 + i11] * fArr2[(i13 * 3) + i14]) + f12;
                            }
                            float f13 = f12 / f11;
                            for (int i15 = i6; i15 < 3; i15++) {
                                int i16 = (i13 * 3) + i15;
                                fArr2[i16] = (fArr2[i15 + i11] * f13) + fArr2[i16];
                            }
                        }
                    }
                    for (int i17 = i6; i17 < 3; i17++) {
                        int i18 = i17 + i11;
                        fArr2[i18] = fArr2[i18] * f8;
                    }
                } else {
                    f3 = 0.0f;
                }
                this.w[i6] = f8 * f3;
                if (i6 >= 3 || i6 == 2) {
                    f5 = 0.0f;
                } else {
                    float f14 = 0.0f;
                    for (int i19 = i7; i19 < 3; i19++) {
                        f14 += Math.abs(fArr2[(i19 * 3) + i6]);
                    }
                    if (f14 != 0.0f) {
                        float f15 = 0.0f;
                        for (int i20 = i7; i20 < 3; i20++) {
                            int i21 = (i20 * 3) + i6;
                            fArr2[i21] = fArr2[i21] / f14;
                            f15 += fArr2[i21] * fArr2[i21];
                        }
                        int i22 = (i7 * 3) + i6;
                        float f16 = fArr2[i22];
                        float f17 = -SIGN((float) Math.sqrt((double) f15), f16);
                        float f18 = (f16 * f17) - f15;
                        fArr2[i22] = f16 - f17;
                        for (int i23 = i7; i23 < 3; i23++) {
                            this.rv1[i23] = fArr2[(i23 * 3) + i6] / f18;
                        }
                        if (i6 != 2) {
                            for (int i24 = i7; i24 < 3; i24++) {
                                float f19 = 0.0f;
                                for (int i25 = i7; i25 < 3; i25++) {
                                    int i26 = i25 * 3;
                                    f19 += fArr2[i24 + i26] * fArr2[i26 + i6];
                                }
                                for (int i27 = i7; i27 < 3; i27++) {
                                    int i28 = (i27 * 3) + i24;
                                    fArr2[i28] = (this.rv1[i27] * f19) + fArr2[i28];
                                }
                            }
                        }
                        for (int i29 = i7; i29 < 3; i29++) {
                            int i30 = (i29 * 3) + i6;
                            fArr2[i30] = fArr2[i30] * f14;
                        }
                        f5 = f14;
                        f6 = f17;
                        f7 = Math.max(f7, Math.abs(this.rv1[i6]) + Math.abs(this.w[i6]));
                        i6 = i7;
                        f4 = 0.0f;
                    } else {
                        f5 = f14;
                    }
                }
                f6 = 0.0f;
                f7 = Math.max(f7, Math.abs(this.rv1[i6]) + Math.abs(this.w[i6]));
                i6 = i7;
                f4 = 0.0f;
            }
            int i31 = i7;
            int i32 = 2;
            while (true) {
                f2 = 1.0f;
                if (i32 < 0) {
                    break;
                }
                if (i32 < 2) {
                    if (f6 != 0.0f) {
                        for (int i33 = i31; i33 < 3; i33++) {
                            this.v[(i32 * 3) + i33] = (fArr2[(i33 * 3) + i32] / fArr2[(i31 * 3) + i32]) / f6;
                        }
                        for (int i34 = i31; i34 < 3; i34++) {
                            float f20 = 0.0f;
                            for (int i35 = i31; i35 < 3; i35++) {
                                f20 += fArr2[(i35 * 3) + i32] * this.v[(i34 * 3) + i35];
                            }
                            for (int i36 = i31; i36 < 3; i36++) {
                                float[] fArr3 = this.v;
                                int i37 = (i34 * 3) + i36;
                                fArr3[i37] = (fArr3[(i32 * 3) + i36] * f20) + fArr3[i37];
                            }
                        }
                    }
                    while (i31 < 3) {
                        float[] fArr4 = this.v;
                        int i38 = (i31 * 3) + i32;
                        fArr4[(i32 * 3) + i31] = 0.0f;
                        fArr4[i38] = 0.0f;
                        i31++;
                    }
                }
                this.v[(i32 * 3) + i32] = 1.0f;
                f6 = this.rv1[i32];
                int i39 = i32;
                i32--;
                i31 = i39;
            }
            for (int i40 = 2; i40 >= 0; i40--) {
                int i41 = i40 + 1;
                float f21 = this.w[i40];
                if (i40 < 2) {
                    for (int i42 = i41; i42 < 3; i42++) {
                        fArr2[(i42 * 3) + i40] = 0.0f;
                    }
                }
                if (f21 != 0.0f) {
                    float f22 = 1.0f / f21;
                    if (i40 != 2) {
                        for (int i43 = i41; i43 < 3; i43++) {
                            float f23 = 0.0f;
                            for (int i44 = i41; i44 < 3; i44++) {
                                f23 += fArr2[(i40 * 3) + i44] * fArr2[(i43 * 3) + i44];
                            }
                            int i45 = i40 * 3;
                            float f24 = (f23 / fArr2[i40 + i45]) * f22;
                            for (int i46 = i40; i46 < 3; i46++) {
                                int i47 = (i43 * 3) + i46;
                                fArr2[i47] = (fArr2[i46 + i45] * f24) + fArr2[i47];
                            }
                        }
                    }
                    for (int i48 = i40; i48 < 3; i48++) {
                        int i49 = (i40 * 3) + i48;
                        fArr2[i49] = fArr2[i49] * f22;
                    }
                } else {
                    for (int i50 = i40; i50 < 3; i50++) {
                        fArr2[(i40 * 3) + i50] = 0.0f;
                    }
                }
                int i51 = (i40 * 3) + i40;
                fArr2[i51] = fArr2[i51] + 1.0f;
            }
            int i52 = 0;
            while (i3 >= 0) {
                int i53 = 0;
                while (true) {
                    if (i53 >= i5) {
                        break;
                    }
                    int i54 = i3;
                    while (true) {
                        z = true;
                        if (i54 < 0) {
                            break;
                        }
                        i52 = i54 - 1;
                        if (Math.abs(this.rv1[i54]) + f7 == f7) {
                            z = false;
                            break;
                        } else if (Math.abs(this.w[i52]) + f7 == f7) {
                            break;
                        } else {
                            i54--;
                        }
                    }
                    if (z) {
                        float f25 = f2;
                        for (int i55 = i54; i55 <= i3; i55++) {
                            float f26 = this.rv1[i55] * f25;
                            if (Math.abs(f26) + f7 != f7) {
                                float f27 = this.w[i55];
                                float PYTHAG = PYTHAG(f26, f27);
                                this.w[i55] = PYTHAG;
                                float f28 = f2 / PYTHAG;
                                float f29 = f27 * f28;
                                float f30 = (-f26) * f28;
                                for (int i56 = 0; i56 < i4; i56++) {
                                    int i57 = (i52 * 3) + i56;
                                    float f31 = fArr2[i57];
                                    int i58 = (i55 * 3) + i56;
                                    float f32 = fArr2[i58];
                                    fArr2[i57] = (f32 * f30) + (f31 * f29);
                                    fArr2[i58] = (f32 * f29) - (f31 * f30);
                                }
                                f25 = f30;
                            }
                        }
                    }
                    float[] fArr5 = this.w;
                    float f33 = fArr5[i3];
                    if (i54 == i3) {
                        if (f33 < 0.0f) {
                            fArr5[i3] = -f33;
                            for (int i59 = 0; i59 < i4; i59++) {
                                float[] fArr6 = this.v;
                                int i60 = (i3 * 3) + i59;
                                fArr6[i60] = -fArr6[i60];
                            }
                        }
                    } else if (i53 != i5 - 1) {
                        float f34 = fArr5[i54];
                        int i61 = i3 - 1;
                        float f35 = fArr5[i61];
                        float[] fArr7 = this.rv1;
                        float f36 = fArr7[i61];
                        float f37 = fArr7[i3];
                        float f38 = (((f36 + f37) * (f36 - f37)) + ((f35 + f33) * (f35 - f33))) / ((2.0f * f37) * f35);
                        float SIGN = ((((f35 / (f38 + SIGN(PYTHAG(f38, f2), f38))) - f37) * f37) + ((f33 + f34) * (f34 - f33))) / f34;
                        float f39 = f2;
                        float f40 = f39;
                        int i62 = i54;
                        while (i62 <= i61) {
                            int i63 = i62 + 1;
                            float f41 = this.rv1[i63];
                            float f42 = this.w[i63];
                            float f43 = f39 * f41;
                            float f44 = f40 * f41;
                            float PYTHAG2 = PYTHAG(SIGN, f43);
                            float f45 = f7;
                            this.rv1[i62] = PYTHAG2;
                            float f46 = SIGN / PYTHAG2;
                            f39 = f43 / PYTHAG2;
                            float f47 = (f44 * f39) + (f34 * f46);
                            float f48 = (f44 * f46) - (f34 * f39);
                            float f49 = f42 * f39;
                            float f50 = f42 * f46;
                            int i64 = i61;
                            for (int i65 = 0; i65 < 3; i65++) {
                                float[] fArr8 = this.v;
                                int i66 = (i62 * 3) + i65;
                                float f51 = fArr8[i66];
                                int i67 = (i63 * 3) + i65;
                                float f52 = fArr8[i67];
                                fArr8[i66] = (f52 * f39) + (f51 * f46);
                                fArr8[i67] = (f52 * f46) - (f51 * f39);
                            }
                            float PYTHAG3 = PYTHAG(f47, f49);
                            this.w[i62] = PYTHAG3;
                            if (PYTHAG3 != 0.0f) {
                                float f53 = 1.0f / PYTHAG3;
                                f39 = f49 * f53;
                                f46 = f47 * f53;
                            }
                            float f54 = (f46 * f48) + (f39 * f50);
                            float f55 = (f50 * f46) - (f48 * f39);
                            i4 = 3;
                            for (int i68 = 0; i68 < 3; i68++) {
                                int i69 = (i62 * 3) + i68;
                                float f56 = fArr2[i69];
                                int i70 = (i63 * 3) + i68;
                                float f57 = fArr2[i70];
                                fArr2[i69] = (f57 * f39) + (f56 * f46);
                                fArr2[i70] = (f57 * f46) - (f56 * f39);
                            }
                            f40 = f46;
                            i62 = i63;
                            f7 = f45;
                            SIGN = f54;
                            f34 = f55;
                            f2 = 1065353216;
                            i61 = i64;
                        }
                        float f58 = f7;
                        int i71 = i61;
                        float f59 = f2;
                        float[] fArr9 = this.rv1;
                        fArr9[i54] = 0.0f;
                        fArr9[i3] = SIGN;
                        this.w[i3] = f34;
                        i53++;
                        f2 = f59;
                        i52 = i71;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No convergence after ");
                        sb.append(i5);
                        sb.append(" iterations");
                        throw new RuntimeException(sb.toString());
                    }
                }
                i3--;
                f2 = f2;
                f7 = f7;
            }
            matrix3f.set(fArr2);
            matrix3f2.set(this.v);
        }
    }

    public Quaternionf computeWeightedAverage(Quaternionfc[] quaternionfcArr, float[] fArr, int i2, Quaternionf quaternionf) {
        QuaternionfInterpolator quaternionfInterpolator = this;
        Quaternionfc[] quaternionfcArr2 = quaternionfcArr;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        int i3 = 0;
        while (i3 < quaternionfcArr2.length) {
            Quaternionfc quaternionfc = quaternionfcArr2[i3];
            float x = quaternionfc.x() + quaternionfc.x();
            float y = quaternionfc.y() + quaternionfc.y();
            float z = quaternionfc.z() + quaternionfc.z();
            float x2 = quaternionfc.x() * x;
            float y2 = quaternionfc.y() * y;
            float z2 = quaternionfc.z() * z;
            float y3 = quaternionfc.y() * x;
            float z3 = quaternionfc.z() * x;
            float w = x * quaternionfc.w();
            float f11 = f10;
            float z4 = quaternionfc.z() * y;
            float f12 = f9;
            float w2 = quaternionfc.w() * y;
            float w3 = quaternionfc.w() * z;
            float f13 = f8;
            float f14 = f7;
            float f15 = 1.0f - y2;
            f2 = a.e(f15, z2, fArr[i3], f2);
            f3 = ((y3 + w3) * fArr[i3]) + f3;
            f4 = a.e(z3, w2, fArr[i3], f4);
            f5 = a.e(y3, w3, fArr[i3], f5);
            f6 = (((1.0f - z2) - x2) * fArr[i3]) + f6;
            float f16 = ((z4 + w) * fArr[i3]) + f14;
            f8 = ((z3 + w2) * fArr[i3]) + f13;
            f9 = a.e(z4, w, fArr[i3], f12);
            f10 = a.e(f15, x2, fArr[i3], f11);
            i3++;
            quaternionfInterpolator = this;
            f7 = f16;
            quaternionfcArr2 = quaternionfcArr;
        }
        float f17 = f7;
        float f18 = f8;
        float f19 = f9;
        float[] fArr2 = quaternionfInterpolator.m;
        fArr2[0] = f2;
        fArr2[1] = f3;
        fArr2[2] = f4;
        fArr2[3] = f5;
        fArr2[4] = f6;
        fArr2[5] = f17;
        fArr2[6] = f18;
        fArr2[7] = f19;
        fArr2[8] = f10;
        quaternionfInterpolator.svdDecomposition3f.svd(fArr2, i2, quaternionfInterpolator.u, quaternionfInterpolator.v);
        quaternionfInterpolator.u.mul(quaternionfInterpolator.v.transpose());
        return quaternionf.setFromNormalized((Matrix3fc) quaternionfInterpolator.u).normalize();
    }
}
