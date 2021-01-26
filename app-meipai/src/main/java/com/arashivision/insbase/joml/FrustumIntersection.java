package com.arashivision.insbase.joml;

public class FrustumIntersection {
    public static final int INSIDE = -2;
    public static final int INTERSECT = -1;
    public static final int OUTSIDE = -3;
    public static final int PLANE_MASK_NX = 1;
    public static final int PLANE_MASK_NY = 4;
    public static final int PLANE_MASK_NZ = 16;
    public static final int PLANE_MASK_PX = 2;
    public static final int PLANE_MASK_PY = 8;
    public static final int PLANE_MASK_PZ = 32;
    public static final int PLANE_NX = 0;
    public static final int PLANE_NY = 2;
    public static final int PLANE_NZ = 4;
    public static final int PLANE_PX = 1;
    public static final int PLANE_PY = 3;
    public static final int PLANE_PZ = 5;
    public float nxW;
    public float nxX;
    public float nxY;
    public float nxZ;
    public float nyW;
    public float nyX;
    public float nyY;
    public float nyZ;
    public float nzW;
    public float nzX;
    public float nzY;
    public float nzZ;
    public final Vector4f[] planes = new Vector4f[6];
    public float pxW;
    public float pxX;
    public float pxY;
    public float pxZ;
    public float pyW;
    public float pyX;
    public float pyY;
    public float pyZ;
    public float pzW;
    public float pzX;
    public float pzY;
    public float pzZ;

    public FrustumIntersection() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.planes[i2] = new Vector4f();
        }
    }

    public int intersectAab(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return intersectAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public int intersectSphere(Vector3fc vector3fc, float f2) {
        return intersectSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2);
    }

    public FrustumIntersection set(Matrix4fc matrix4fc) {
        return set(matrix4fc, true);
    }

    public boolean testAab(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return testAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public boolean testPlaneXY(Vector2fc vector2fc, Vector2fc vector2fc2) {
        return testPlaneXY(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y());
    }

    public boolean testPlaneXZ(float f2, float f3, float f4, float f5) {
        float f6 = this.nxX;
        float f7 = f6 * (f6 < 0.0f ? f2 : f4);
        float f8 = this.nxZ;
        if ((f8 * (f8 < 0.0f ? f3 : f5)) + f7 >= (-this.nxW)) {
            float f9 = this.pxX;
            float f10 = f9 * (f9 < 0.0f ? f2 : f4);
            float f11 = this.pxZ;
            if ((f11 * (f11 < 0.0f ? f3 : f5)) + f10 >= (-this.pxW)) {
                float f12 = this.nyX;
                float f13 = f12 * (f12 < 0.0f ? f2 : f4);
                float f14 = this.nyZ;
                if ((f14 * (f14 < 0.0f ? f3 : f5)) + f13 >= (-this.nyW)) {
                    float f15 = this.pyX;
                    float f16 = f15 * (f15 < 0.0f ? f2 : f4);
                    float f17 = this.pyZ;
                    if ((f17 * (f17 < 0.0f ? f3 : f5)) + f16 >= (-this.pyW)) {
                        float f18 = this.nzX;
                        float f19 = f18 * (f18 < 0.0f ? f2 : f4);
                        float f20 = this.nzZ;
                        if ((f20 * (f20 < 0.0f ? f3 : f5)) + f19 >= (-this.nzW)) {
                            float f21 = this.pzX;
                            if (f21 >= 0.0f) {
                                f2 = f4;
                            }
                            float f22 = f21 * f2;
                            float f23 = this.pzZ;
                            if (f23 >= 0.0f) {
                                f3 = f5;
                            }
                            if ((f23 * f3) + f22 >= (-this.pzW)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testPoint(Vector3fc vector3fc) {
        return testPoint(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public boolean testSphere(Vector3fc vector3fc, float f2) {
        return testSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2);
    }

    public int intersectAab(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.nxX;
        float f9 = f8 * (f8 < 0.0f ? f2 : f5);
        float f10 = this.nxY;
        float f11 = (f10 * (f10 < 0.0f ? f3 : f6)) + f9;
        float f12 = this.nxZ;
        int i2 = (((f12 * (f12 < 0.0f ? f4 : f7)) + f11) > (-this.nxW) ? 1 : (((f12 * (f12 < 0.0f ? f4 : f7)) + f11) == (-this.nxW) ? 0 : -1));
        int i3 = 0;
        if (i2 >= 0) {
            float f13 = this.nxX;
            float f14 = f13 * (f13 < 0.0f ? f5 : f2);
            float f15 = this.nxY;
            float f16 = (f15 * (f15 < 0.0f ? f6 : f3)) + f14;
            float f17 = this.nxZ;
            int i4 = ((f17 * ((f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) < 0 ? f7 : f4)) + f16 >= (-this.nxW) ? 1 : 0) & 1;
            float f18 = this.pxX;
            float f19 = f18 * (f18 < 0.0f ? f2 : f5);
            float f20 = this.pxY;
            float f21 = (f20 * (f20 < 0.0f ? f3 : f6)) + f19;
            float f22 = this.pxZ;
            if ((f22 * (f22 < 0.0f ? f4 : f7)) + f21 >= (-this.pxW)) {
                int i5 = 2;
                float f23 = this.pxX;
                float f24 = f23 * (f23 < 0.0f ? f5 : f2);
                float f25 = this.pxY;
                float f26 = (f25 * (f25 < 0.0f ? f6 : f3)) + f24;
                float f27 = this.pxZ;
                int i6 = i4 & ((f27 * ((f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1)) < 0 ? f7 : f4)) + f26 >= (-this.pxW) ? 1 : 0);
                float f28 = this.nyX;
                float f29 = f28 * (f28 < 0.0f ? f2 : f5);
                float f30 = this.nyY;
                float f31 = (f30 * (f30 < 0.0f ? f3 : f6)) + f29;
                float f32 = this.nyZ;
                if ((f32 * (f32 < 0.0f ? f4 : f7)) + f31 >= (-this.nyW)) {
                    i5 = 3;
                    float f33 = this.nyX;
                    float f34 = f33 * (f33 < 0.0f ? f5 : f2);
                    float f35 = this.nyY;
                    float f36 = (f35 * (f35 < 0.0f ? f6 : f3)) + f34;
                    float f37 = this.nyZ;
                    int i7 = i6 & ((f37 * ((f37 > 0.0f ? 1 : (f37 == 0.0f ? 0 : -1)) < 0 ? f7 : f4)) + f36 >= (-this.nyW) ? 1 : 0);
                    float f38 = this.pyX;
                    float f39 = f38 * (f38 < 0.0f ? f2 : f5);
                    float f40 = this.pyY;
                    float f41 = (f40 * (f40 < 0.0f ? f3 : f6)) + f39;
                    float f42 = this.pyZ;
                    if ((f42 * (f42 < 0.0f ? f4 : f7)) + f41 >= (-this.pyW)) {
                        i5 = 4;
                        float f43 = this.pyX;
                        float f44 = f43 * (f43 < 0.0f ? f5 : f2);
                        float f45 = this.pyY;
                        float f46 = (f45 * (f45 < 0.0f ? f6 : f3)) + f44;
                        float f47 = this.pyZ;
                        int i8 = i7 & ((f47 * ((f47 > 0.0f ? 1 : (f47 == 0.0f ? 0 : -1)) < 0 ? f7 : f4)) + f46 >= (-this.pyW) ? 1 : 0);
                        float f48 = this.nzX;
                        float f49 = f48 * (f48 < 0.0f ? f2 : f5);
                        float f50 = this.nzY;
                        float f51 = (f50 * (f50 < 0.0f ? f3 : f6)) + f49;
                        float f52 = this.nzZ;
                        if ((f52 * (f52 < 0.0f ? f4 : f7)) + f51 >= (-this.nzW)) {
                            i5 = 5;
                            float f53 = this.nzX;
                            float f54 = f53 * (f53 < 0.0f ? f5 : f2);
                            float f55 = this.nzY;
                            float f56 = (f55 * (f55 < 0.0f ? f6 : f3)) + f54;
                            float f57 = this.nzZ;
                            int i9 = i8 & ((f57 * ((f57 > 0.0f ? 1 : (f57 == 0.0f ? 0 : -1)) < 0 ? f7 : f4)) + f56 >= (-this.nzW) ? 1 : 0);
                            float f58 = this.pzX;
                            float f59 = f58 * (f58 < 0.0f ? f2 : f5);
                            float f60 = this.pzY;
                            float f61 = (f60 * (f60 < 0.0f ? f3 : f6)) + f59;
                            float f62 = this.pzZ;
                            if ((f62 * (f62 < 0.0f ? f4 : f7)) + f61 >= (-this.pzW)) {
                                float f63 = this.pzX;
                                if (f63 < 0.0f) {
                                    f2 = f5;
                                }
                                float f64 = f63 * f2;
                                float f65 = this.pzY;
                                if (f65 < 0.0f) {
                                    f3 = f6;
                                }
                                float f66 = (f65 * f3) + f64;
                                float f67 = this.pzZ;
                                if (f67 < 0.0f) {
                                    f4 = f7;
                                }
                                if ((f67 * f4) + f66 >= (-this.pzW)) {
                                    i3 = 1;
                                }
                                return (i9 & i3) != 0 ? -2 : -1;
                            }
                        }
                    }
                }
                i3 = i5;
            } else {
                i3 = 1;
            }
        }
        return i3;
    }

    public int intersectSphere(float f2, float f3, float f4, float f5) {
        float f6 = (this.nxZ * f4) + (this.nxY * f3) + (this.nxX * f2) + this.nxW;
        float f7 = -f5;
        if (f6 >= f7) {
            boolean z = false;
            boolean z2 = (f6 >= f5) & true;
            float f8 = (this.pxZ * f4) + (this.pxY * f3) + (this.pxX * f2) + this.pxW;
            if (f8 >= f7) {
                boolean z3 = z2 & (f8 >= f5);
                float f9 = (this.nyZ * f4) + (this.nyY * f3) + (this.nyX * f2) + this.nyW;
                if (f9 >= f7) {
                    boolean z4 = z3 & (f9 >= f5);
                    float f10 = (this.pyZ * f4) + (this.pyY * f3) + (this.pyX * f2) + this.pyW;
                    if (f10 >= f7) {
                        boolean z5 = z4 & (f10 >= f5);
                        float f11 = (this.nzZ * f4) + (this.nzY * f3) + (this.nzX * f2) + this.nzW;
                        if (f11 >= f7) {
                            boolean z6 = z5 & (f11 >= f5);
                            float f12 = (this.pzZ * f4) + (this.pzY * f3) + (this.pzX * f2) + this.pzW;
                            if (f12 >= f7) {
                                if (f12 >= f5) {
                                    z = true;
                                }
                                return z6 & z ? -2 : -1;
                            }
                        }
                    }
                }
            }
        }
        return -3;
    }

    public FrustumIntersection set(Matrix4fc matrix4fc, boolean z) {
        this.nxX = matrix4fc.m00() + matrix4fc.m03();
        this.nxY = matrix4fc.m10() + matrix4fc.m13();
        this.nxZ = matrix4fc.m20() + matrix4fc.m23();
        this.nxW = matrix4fc.m30() + matrix4fc.m33();
        if (z) {
            float f2 = this.nxX;
            float f3 = f2 * f2;
            float f4 = this.nxY;
            float f5 = (f4 * f4) + f3;
            float f6 = this.nxZ;
            float sqrt = (float) (1.0d / Math.sqrt((double) ((f6 * f6) + f5)));
            this.nxX *= sqrt;
            this.nxY *= sqrt;
            this.nxZ *= sqrt;
            this.nxW *= sqrt;
        }
        this.planes[0].set(this.nxX, this.nxY, this.nxZ, this.nxW);
        this.pxX = matrix4fc.m03() - matrix4fc.m00();
        this.pxY = matrix4fc.m13() - matrix4fc.m10();
        this.pxZ = matrix4fc.m23() - matrix4fc.m20();
        this.pxW = matrix4fc.m33() - matrix4fc.m30();
        if (z) {
            float f7 = this.pxX;
            float f8 = f7 * f7;
            float f9 = this.pxY;
            float f10 = (f9 * f9) + f8;
            float f11 = this.pxZ;
            float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f11 * f11) + f10)));
            this.pxX *= sqrt2;
            this.pxY *= sqrt2;
            this.pxZ *= sqrt2;
            this.pxW *= sqrt2;
        }
        this.planes[1].set(this.pxX, this.pxY, this.pxZ, this.pxW);
        this.nyX = matrix4fc.m01() + matrix4fc.m03();
        this.nyY = matrix4fc.m11() + matrix4fc.m13();
        this.nyZ = matrix4fc.m21() + matrix4fc.m23();
        this.nyW = matrix4fc.m31() + matrix4fc.m33();
        if (z) {
            float f12 = this.nyX;
            float f13 = f12 * f12;
            float f14 = this.nyY;
            float f15 = (f14 * f14) + f13;
            float f16 = this.nyZ;
            float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f16 * f16) + f15)));
            this.nyX *= sqrt3;
            this.nyY *= sqrt3;
            this.nyZ *= sqrt3;
            this.nyW *= sqrt3;
        }
        this.planes[2].set(this.nyX, this.nyY, this.nyZ, this.nyW);
        this.pyX = matrix4fc.m03() - matrix4fc.m01();
        this.pyY = matrix4fc.m13() - matrix4fc.m11();
        this.pyZ = matrix4fc.m23() - matrix4fc.m21();
        this.pyW = matrix4fc.m33() - matrix4fc.m31();
        if (z) {
            float f17 = this.pyX;
            float f18 = f17 * f17;
            float f19 = this.pyY;
            float f20 = (f19 * f19) + f18;
            float f21 = this.pyZ;
            float sqrt4 = (float) (1.0d / Math.sqrt((double) ((f21 * f21) + f20)));
            this.pyX *= sqrt4;
            this.pyY *= sqrt4;
            this.pyZ *= sqrt4;
            this.pyW *= sqrt4;
        }
        this.planes[3].set(this.pyX, this.pyY, this.pyZ, this.pyW);
        this.nzX = matrix4fc.m02() + matrix4fc.m03();
        this.nzY = matrix4fc.m12() + matrix4fc.m13();
        this.nzZ = matrix4fc.m22() + matrix4fc.m23();
        this.nzW = matrix4fc.m32() + matrix4fc.m33();
        if (z) {
            float f22 = this.nzX;
            float f23 = f22 * f22;
            float f24 = this.nzY;
            float f25 = (f24 * f24) + f23;
            float f26 = this.nzZ;
            float sqrt5 = (float) (1.0d / Math.sqrt((double) ((f26 * f26) + f25)));
            this.nzX *= sqrt5;
            this.nzY *= sqrt5;
            this.nzZ *= sqrt5;
            this.nzW *= sqrt5;
        }
        this.planes[4].set(this.nzX, this.nzY, this.nzZ, this.nzW);
        this.pzX = matrix4fc.m03() - matrix4fc.m02();
        this.pzY = matrix4fc.m13() - matrix4fc.m12();
        this.pzZ = matrix4fc.m23() - matrix4fc.m22();
        this.pzW = matrix4fc.m33() - matrix4fc.m32();
        if (z) {
            float f27 = this.pzX;
            float f28 = f27 * f27;
            float f29 = this.pzY;
            float f30 = (f29 * f29) + f28;
            float f31 = this.pzZ;
            float sqrt6 = (float) (1.0d / Math.sqrt((double) ((f31 * f31) + f30)));
            this.pzX *= sqrt6;
            this.pzY *= sqrt6;
            this.pzZ *= sqrt6;
            this.pzW *= sqrt6;
        }
        this.planes[5].set(this.pzX, this.pzY, this.pzZ, this.pzW);
        return this;
    }

    public boolean testAab(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.nxX;
        float f9 = f8 * (f8 < 0.0f ? f2 : f5);
        float f10 = this.nxY;
        float f11 = (f10 * (f10 < 0.0f ? f3 : f6)) + f9;
        float f12 = this.nxZ;
        if ((f12 * (f12 < 0.0f ? f4 : f7)) + f11 >= (-this.nxW)) {
            float f13 = this.pxX;
            float f14 = f13 * (f13 < 0.0f ? f2 : f5);
            float f15 = this.pxY;
            float f16 = (f15 * (f15 < 0.0f ? f3 : f6)) + f14;
            float f17 = this.pxZ;
            if ((f17 * (f17 < 0.0f ? f4 : f7)) + f16 >= (-this.pxW)) {
                float f18 = this.nyX;
                float f19 = f18 * (f18 < 0.0f ? f2 : f5);
                float f20 = this.nyY;
                float f21 = (f20 * (f20 < 0.0f ? f3 : f6)) + f19;
                float f22 = this.nyZ;
                if ((f22 * (f22 < 0.0f ? f4 : f7)) + f21 >= (-this.nyW)) {
                    float f23 = this.pyX;
                    float f24 = f23 * (f23 < 0.0f ? f2 : f5);
                    float f25 = this.pyY;
                    float f26 = (f25 * (f25 < 0.0f ? f3 : f6)) + f24;
                    float f27 = this.pyZ;
                    if ((f27 * (f27 < 0.0f ? f4 : f7)) + f26 >= (-this.pyW)) {
                        float f28 = this.nzX;
                        float f29 = f28 * (f28 < 0.0f ? f2 : f5);
                        float f30 = this.nzY;
                        float f31 = (f30 * (f30 < 0.0f ? f3 : f6)) + f29;
                        float f32 = this.nzZ;
                        if ((f32 * (f32 < 0.0f ? f4 : f7)) + f31 >= (-this.nzW)) {
                            float f33 = this.pzX;
                            if (f33 >= 0.0f) {
                                f2 = f5;
                            }
                            float f34 = f33 * f2;
                            float f35 = this.pzY;
                            if (f35 >= 0.0f) {
                                f3 = f6;
                            }
                            float f36 = (f35 * f3) + f34;
                            float f37 = this.pzZ;
                            if (f37 >= 0.0f) {
                                f4 = f7;
                            }
                            if ((f37 * f4) + f36 >= (-this.pzW)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testPlaneXY(float f2, float f3, float f4, float f5) {
        float f6 = this.nxX;
        float f7 = f6 * (f6 < 0.0f ? f2 : f4);
        float f8 = this.nxY;
        if ((f8 * (f8 < 0.0f ? f3 : f5)) + f7 >= (-this.nxW)) {
            float f9 = this.pxX;
            float f10 = f9 * (f9 < 0.0f ? f2 : f4);
            float f11 = this.pxY;
            if ((f11 * (f11 < 0.0f ? f3 : f5)) + f10 >= (-this.pxW)) {
                float f12 = this.nyX;
                float f13 = f12 * (f12 < 0.0f ? f2 : f4);
                float f14 = this.nyY;
                if ((f14 * (f14 < 0.0f ? f3 : f5)) + f13 >= (-this.nyW)) {
                    float f15 = this.pyX;
                    float f16 = f15 * (f15 < 0.0f ? f2 : f4);
                    float f17 = this.pyY;
                    if ((f17 * (f17 < 0.0f ? f3 : f5)) + f16 >= (-this.pyW)) {
                        float f18 = this.nzX;
                        float f19 = f18 * (f18 < 0.0f ? f2 : f4);
                        float f20 = this.nzY;
                        if ((f20 * (f20 < 0.0f ? f3 : f5)) + f19 >= (-this.nzW)) {
                            float f21 = this.pzX;
                            if (f21 >= 0.0f) {
                                f2 = f4;
                            }
                            float f22 = f21 * f2;
                            float f23 = this.pzY;
                            if (f23 >= 0.0f) {
                                f3 = f5;
                            }
                            if ((f23 * f3) + f22 >= (-this.pzW)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testPoint(float f2, float f3, float f4) {
        if ((this.nxZ * f4) + (this.nxY * f3) + (this.nxX * f2) + this.nxW >= 0.0f) {
            if ((this.pxZ * f4) + (this.pxY * f3) + (this.pxX * f2) + this.pxW >= 0.0f) {
                if ((this.nyZ * f4) + (this.nyY * f3) + (this.nyX * f2) + this.nyW >= 0.0f) {
                    if ((this.pyZ * f4) + (this.pyY * f3) + (this.pyX * f2) + this.pyW >= 0.0f) {
                        if ((this.nzZ * f4) + (this.nzY * f3) + (this.nzX * f2) + this.nzW >= 0.0f) {
                            if ((this.pzZ * f4) + (this.pzY * f3) + (this.pzX * f2) + this.pzW >= 0.0f) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testSphere(float f2, float f3, float f4, float f5) {
        float f6 = -f5;
        if ((this.nxZ * f4) + (this.nxY * f3) + (this.nxX * f2) + this.nxW >= f6) {
            if ((this.pxZ * f4) + (this.pxY * f3) + (this.pxX * f2) + this.pxW >= f6) {
                if ((this.nyZ * f4) + (this.nyY * f3) + (this.nyX * f2) + this.nyW >= f6) {
                    if ((this.pyZ * f4) + (this.pyY * f3) + (this.pyX * f2) + this.pyW >= f6) {
                        if ((this.nzZ * f4) + (this.nzY * f3) + (this.nzX * f2) + this.nzW >= f6) {
                            if ((this.pzZ * f4) + (this.pzY * f3) + (this.pzX * f2) + this.pzW >= f6) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public FrustumIntersection(Matrix4fc matrix4fc) {
        for (int i2 = 0; i2 < 6; i2++) {
            this.planes[i2] = new Vector4f();
        }
        set(matrix4fc, true);
    }

    public FrustumIntersection(Matrix4fc matrix4fc, boolean z) {
        for (int i2 = 0; i2 < 6; i2++) {
            this.planes[i2] = new Vector4f();
        }
        set(matrix4fc, z);
    }

    public int intersectAab(Vector3fc vector3fc, Vector3fc vector3fc2, int i2) {
        return intersectAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0137, code lost:
        if (((r5 * (r5 < 0.0f ? r11 : r14)) + r6) >= (-r8.pyW)) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x013a, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (((r0 * (r0 < 0.0f ? r11 : r14)) + r4) >= (-r8.nxW)) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x01ec, code lost:
        if (((r15 * (r15 < 0.0f ? r11 : r14)) + r5) >= (-r8.pzW)) goto L_0x01f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intersectAab(float r9, float r10, float r11, float r12, float r13, float r14, int r15) {
        /*
            r8 = this;
            r0 = r15 & 1
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x002e
            float r0 = r8.nxX
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x000f
            r4 = r9
            goto L_0x0010
        L_0x000f:
            r4 = r12
        L_0x0010:
            float r0 = r0 * r4
            float r4 = r8.nxY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0019
            r5 = r10
            goto L_0x001a
        L_0x0019:
            r5 = r13
        L_0x001a:
            float r4 = r4 * r5
            float r4 = r4 + r0
            float r0 = r8.nxZ
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0024
            r5 = r11
            goto L_0x0025
        L_0x0024:
            r5 = r14
        L_0x0025:
            float r0 = r0 * r5
            float r0 = r0 + r4
            float r4 = r8.nxW
            float r4 = -r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x01ef
        L_0x002e:
            float r0 = r8.nxX
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0036
            r4 = r12
            goto L_0x0037
        L_0x0036:
            r4 = r9
        L_0x0037:
            float r0 = r0 * r4
            float r4 = r8.nxY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0040
            r5 = r13
            goto L_0x0041
        L_0x0040:
            r5 = r10
        L_0x0041:
            float r4 = r4 * r5
            float r4 = r4 + r0
            float r0 = r8.nxZ
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x004b
            r5 = r14
            goto L_0x004c
        L_0x004b:
            r5 = r11
        L_0x004c:
            float r0 = r0 * r5
            float r0 = r0 + r4
            float r4 = r8.nxW
            float r4 = -r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0057
            r0 = r2
            goto L_0x0058
        L_0x0057:
            r0 = r1
        L_0x0058:
            r0 = r0 & r2
            r4 = r15 & 2
            if (r4 == 0) goto L_0x0088
            float r4 = r8.pxX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0065
            r5 = r9
            goto L_0x0066
        L_0x0065:
            r5 = r12
        L_0x0066:
            float r4 = r4 * r5
            float r5 = r8.pxY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x006f
            r6 = r10
            goto L_0x0070
        L_0x006f:
            r6 = r13
        L_0x0070:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r8.pxZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x007a
            r6 = r11
            goto L_0x007b
        L_0x007a:
            r6 = r14
        L_0x007b:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r8.pxW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0085
            goto L_0x0088
        L_0x0085:
            r1 = r2
            goto L_0x01ef
        L_0x0088:
            float r4 = r8.pxX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0090
            r5 = r12
            goto L_0x0091
        L_0x0090:
            r5 = r9
        L_0x0091:
            float r4 = r4 * r5
            float r5 = r8.pxY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x009a
            r6 = r13
            goto L_0x009b
        L_0x009a:
            r6 = r10
        L_0x009b:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r8.pxZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a5
            r6 = r14
            goto L_0x00a6
        L_0x00a5:
            r6 = r11
        L_0x00a6:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r8.pxW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x00b1
            r4 = r2
            goto L_0x00b2
        L_0x00b1:
            r4 = r1
        L_0x00b2:
            r0 = r0 & r4
            r4 = r15 & 4
            if (r4 == 0) goto L_0x00e2
            float r4 = r8.nyX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00bf
            r5 = r9
            goto L_0x00c0
        L_0x00bf:
            r5 = r12
        L_0x00c0:
            float r4 = r4 * r5
            float r5 = r8.nyY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x00c9
            r6 = r10
            goto L_0x00ca
        L_0x00c9:
            r6 = r13
        L_0x00ca:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r8.nyZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d4
            r6 = r11
            goto L_0x00d5
        L_0x00d4:
            r6 = r14
        L_0x00d5:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r8.nyW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x00df
            goto L_0x00e2
        L_0x00df:
            r1 = 2
            goto L_0x01ef
        L_0x00e2:
            r4 = 3
            float r5 = r8.nyX
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x00eb
            r6 = r12
            goto L_0x00ec
        L_0x00eb:
            r6 = r9
        L_0x00ec:
            float r5 = r5 * r6
            float r6 = r8.nyY
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f5
            r7 = r13
            goto L_0x00f6
        L_0x00f5:
            r7 = r10
        L_0x00f6:
            float r6 = r6 * r7
            float r6 = r6 + r5
            float r5 = r8.nyZ
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0100
            r7 = r14
            goto L_0x0101
        L_0x0100:
            r7 = r11
        L_0x0101:
            float r5 = r5 * r7
            float r5 = r5 + r6
            float r6 = r8.nyW
            float r6 = -r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x010c
            r5 = r2
            goto L_0x010d
        L_0x010c:
            r5 = r1
        L_0x010d:
            r0 = r0 & r5
            r5 = r15 & 8
            if (r5 == 0) goto L_0x013d
            float r5 = r8.pyX
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x011a
            r6 = r9
            goto L_0x011b
        L_0x011a:
            r6 = r12
        L_0x011b:
            float r5 = r5 * r6
            float r6 = r8.pyY
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0124
            r7 = r10
            goto L_0x0125
        L_0x0124:
            r7 = r13
        L_0x0125:
            float r6 = r6 * r7
            float r6 = r6 + r5
            float r5 = r8.pyZ
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x012f
            r7 = r11
            goto L_0x0130
        L_0x012f:
            r7 = r14
        L_0x0130:
            float r5 = r5 * r7
            float r5 = r5 + r6
            float r6 = r8.pyW
            float r6 = -r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x013a
            goto L_0x013d
        L_0x013a:
            r1 = r4
            goto L_0x01ef
        L_0x013d:
            float r4 = r8.pyX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0145
            r5 = r12
            goto L_0x0146
        L_0x0145:
            r5 = r9
        L_0x0146:
            float r4 = r4 * r5
            float r5 = r8.pyY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x014f
            r6 = r13
            goto L_0x0150
        L_0x014f:
            r6 = r10
        L_0x0150:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r8.pyZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x015a
            r6 = r14
            goto L_0x015b
        L_0x015a:
            r6 = r11
        L_0x015b:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r8.pyW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0166
            r4 = r2
            goto L_0x0167
        L_0x0166:
            r4 = r1
        L_0x0167:
            r0 = r0 & r4
            r4 = r15 & 16
            if (r4 == 0) goto L_0x0197
            float r4 = r8.nzX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0174
            r5 = r9
            goto L_0x0175
        L_0x0174:
            r5 = r12
        L_0x0175:
            float r4 = r4 * r5
            float r5 = r8.nzY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x017e
            r6 = r10
            goto L_0x017f
        L_0x017e:
            r6 = r13
        L_0x017f:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r8.nzZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0189
            r6 = r11
            goto L_0x018a
        L_0x0189:
            r6 = r14
        L_0x018a:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r8.nzW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0194
            goto L_0x0197
        L_0x0194:
            r1 = 4
            goto L_0x01ef
        L_0x0197:
            r4 = 5
            float r5 = r8.nzX
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01a0
            r6 = r12
            goto L_0x01a1
        L_0x01a0:
            r6 = r9
        L_0x01a1:
            float r5 = r5 * r6
            float r6 = r8.nzY
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x01aa
            r7 = r13
            goto L_0x01ab
        L_0x01aa:
            r7 = r10
        L_0x01ab:
            float r6 = r6 * r7
            float r6 = r6 + r5
            float r5 = r8.nzZ
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x01b5
            r7 = r14
            goto L_0x01b6
        L_0x01b5:
            r7 = r11
        L_0x01b6:
            float r5 = r5 * r7
            float r5 = r5 + r6
            float r6 = r8.nzW
            float r6 = -r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x01c1
            r5 = r2
            goto L_0x01c2
        L_0x01c1:
            r5 = r1
        L_0x01c2:
            r0 = r0 & r5
            r15 = r15 & 32
            if (r15 == 0) goto L_0x01f0
            float r15 = r8.pzX
            int r5 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x01cf
            r5 = r9
            goto L_0x01d0
        L_0x01cf:
            r5 = r12
        L_0x01d0:
            float r15 = r15 * r5
            float r5 = r8.pzY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01d9
            r6 = r10
            goto L_0x01da
        L_0x01d9:
            r6 = r13
        L_0x01da:
            float r5 = r5 * r6
            float r5 = r5 + r15
            float r15 = r8.pzZ
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01e4
            r6 = r11
            goto L_0x01e5
        L_0x01e4:
            r6 = r14
        L_0x01e5:
            float r15 = r15 * r6
            float r15 = r15 + r5
            float r5 = r8.pzW
            float r5 = -r5
            int r15 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r15 < 0) goto L_0x013a
            goto L_0x01f0
        L_0x01ef:
            return r1
        L_0x01f0:
            float r15 = r8.pzX
            int r4 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f7
            r9 = r12
        L_0x01f7:
            float r15 = r15 * r9
            float r9 = r8.pzY
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x01ff
            r10 = r13
        L_0x01ff:
            float r9 = r9 * r10
            float r9 = r9 + r15
            float r10 = r8.pzZ
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0208
            r11 = r14
        L_0x0208:
            float r10 = r10 * r11
            float r10 = r10 + r9
            float r9 = r8.pzW
            float r9 = -r9
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x0212
            r1 = r2
        L_0x0212:
            r9 = r0 & r1
            if (r9 == 0) goto L_0x0218
            r9 = -2
            goto L_0x0219
        L_0x0218:
            r9 = -1
        L_0x0219:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.FrustumIntersection.intersectAab(float, float, float, float, float, float, int):int");
    }

    public int intersectAab(Vector3fc vector3fc, Vector3fc vector3fc2, int i2, int i3) {
        return intersectAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0168, code lost:
        if (((r4 * (r4 < 0.0f ? r10 : r13)) + r5) >= (-r7.pyW)) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x016b, code lost:
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x021d, code lost:
        if (((r14 * (r14 < 0.0f ? r10 : r13)) + r4) >= (-r7.pzW)) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        if (((r0 * (r0 < 0.0f ? r10 : r13)) + r2) >= (-r7.nxW)) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intersectAab(float r8, float r9, float r10, float r11, float r12, float r13, int r14, int r15) {
        /*
            r7 = this;
            com.arashivision.insbase.joml.Vector4f[] r0 = r7.planes
            r0 = r0[r15]
            r1 = 1
            int r2 = r1 << r15
            r2 = r2 & r14
            r3 = 0
            if (r2 == 0) goto L_0x0033
            float r2 = r0.x
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0013
            r4 = r8
            goto L_0x0014
        L_0x0013:
            r4 = r11
        L_0x0014:
            float r2 = r2 * r4
            float r4 = r0.y
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            r5 = r9
            goto L_0x001e
        L_0x001d:
            r5 = r12
        L_0x001e:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r0.z
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0028
            r5 = r10
            goto L_0x0029
        L_0x0028:
            r5 = r13
        L_0x0029:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r0 = r0.w
            float r0 = -r0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0033
            return r15
        L_0x0033:
            r0 = r14 & 1
            if (r0 == 0) goto L_0x005e
            float r0 = r7.nxX
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x003f
            r2 = r8
            goto L_0x0040
        L_0x003f:
            r2 = r11
        L_0x0040:
            float r0 = r0 * r2
            float r2 = r7.nxY
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0049
            r4 = r9
            goto L_0x004a
        L_0x0049:
            r4 = r12
        L_0x004a:
            float r2 = r2 * r4
            float r2 = r2 + r0
            float r0 = r7.nxZ
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0054
            r4 = r10
            goto L_0x0055
        L_0x0054:
            r4 = r13
        L_0x0055:
            float r0 = r0 * r4
            float r0 = r0 + r2
            float r2 = r7.nxW
            float r2 = -r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0220
        L_0x005e:
            float r15 = r7.nxX
            int r0 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0066
            r0 = r11
            goto L_0x0067
        L_0x0066:
            r0 = r8
        L_0x0067:
            float r15 = r15 * r0
            float r0 = r7.nxY
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0070
            r2 = r12
            goto L_0x0071
        L_0x0070:
            r2 = r9
        L_0x0071:
            float r0 = r0 * r2
            float r0 = r0 + r15
            float r15 = r7.nxZ
            int r2 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x007b
            r2 = r13
            goto L_0x007c
        L_0x007b:
            r2 = r10
        L_0x007c:
            float r15 = r15 * r2
            float r15 = r15 + r0
            float r0 = r7.nxW
            float r0 = -r0
            int r15 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            r0 = 0
            if (r15 < 0) goto L_0x0088
            r15 = r1
            goto L_0x0089
        L_0x0088:
            r15 = r0
        L_0x0089:
            r15 = r15 & r1
            r2 = r14 & 2
            if (r2 == 0) goto L_0x00b9
            float r2 = r7.pxX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0096
            r4 = r8
            goto L_0x0097
        L_0x0096:
            r4 = r11
        L_0x0097:
            float r2 = r2 * r4
            float r4 = r7.pxY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a0
            r5 = r9
            goto L_0x00a1
        L_0x00a0:
            r5 = r12
        L_0x00a1:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r7.pxZ
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00ab
            r5 = r10
            goto L_0x00ac
        L_0x00ab:
            r5 = r13
        L_0x00ac:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r4 = r7.pxW
            float r4 = -r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00b6
            goto L_0x00b9
        L_0x00b6:
            r15 = r1
            goto L_0x0220
        L_0x00b9:
            float r2 = r7.pxX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x00c1
            r4 = r11
            goto L_0x00c2
        L_0x00c1:
            r4 = r8
        L_0x00c2:
            float r2 = r2 * r4
            float r4 = r7.pxY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00cb
            r5 = r12
            goto L_0x00cc
        L_0x00cb:
            r5 = r9
        L_0x00cc:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r7.pxZ
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00d6
            r5 = r13
            goto L_0x00d7
        L_0x00d6:
            r5 = r10
        L_0x00d7:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r4 = r7.pxW
            float r4 = -r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00e2
            r2 = r1
            goto L_0x00e3
        L_0x00e2:
            r2 = r0
        L_0x00e3:
            r15 = r15 & r2
            r2 = r14 & 4
            if (r2 == 0) goto L_0x0113
            float r2 = r7.nyX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f0
            r4 = r8
            goto L_0x00f1
        L_0x00f0:
            r4 = r11
        L_0x00f1:
            float r2 = r2 * r4
            float r4 = r7.nyY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00fa
            r5 = r9
            goto L_0x00fb
        L_0x00fa:
            r5 = r12
        L_0x00fb:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r7.nyZ
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0105
            r5 = r10
            goto L_0x0106
        L_0x0105:
            r5 = r13
        L_0x0106:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r4 = r7.nyW
            float r4 = -r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0110
            goto L_0x0113
        L_0x0110:
            r15 = 2
            goto L_0x0220
        L_0x0113:
            r2 = 3
            float r4 = r7.nyX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x011c
            r5 = r11
            goto L_0x011d
        L_0x011c:
            r5 = r8
        L_0x011d:
            float r4 = r4 * r5
            float r5 = r7.nyY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0126
            r6 = r12
            goto L_0x0127
        L_0x0126:
            r6 = r9
        L_0x0127:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r7.nyZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0131
            r6 = r13
            goto L_0x0132
        L_0x0131:
            r6 = r10
        L_0x0132:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r7.nyW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x013d
            r4 = r1
            goto L_0x013e
        L_0x013d:
            r4 = r0
        L_0x013e:
            r15 = r15 & r4
            r4 = r14 & 8
            if (r4 == 0) goto L_0x016e
            float r4 = r7.pyX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x014b
            r5 = r8
            goto L_0x014c
        L_0x014b:
            r5 = r11
        L_0x014c:
            float r4 = r4 * r5
            float r5 = r7.pyY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0155
            r6 = r9
            goto L_0x0156
        L_0x0155:
            r6 = r12
        L_0x0156:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r7.pyZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0160
            r6 = r10
            goto L_0x0161
        L_0x0160:
            r6 = r13
        L_0x0161:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r7.pyW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x016b
            goto L_0x016e
        L_0x016b:
            r15 = r2
            goto L_0x0220
        L_0x016e:
            float r2 = r7.pyX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0176
            r4 = r11
            goto L_0x0177
        L_0x0176:
            r4 = r8
        L_0x0177:
            float r2 = r2 * r4
            float r4 = r7.pyY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0180
            r5 = r12
            goto L_0x0181
        L_0x0180:
            r5 = r9
        L_0x0181:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r7.pyZ
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x018b
            r5 = r13
            goto L_0x018c
        L_0x018b:
            r5 = r10
        L_0x018c:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r4 = r7.pyW
            float r4 = -r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0197
            r2 = r1
            goto L_0x0198
        L_0x0197:
            r2 = r0
        L_0x0198:
            r15 = r15 & r2
            r2 = r14 & 16
            if (r2 == 0) goto L_0x01c8
            float r2 = r7.nzX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x01a5
            r4 = r8
            goto L_0x01a6
        L_0x01a5:
            r4 = r11
        L_0x01a6:
            float r2 = r2 * r4
            float r4 = r7.nzY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x01af
            r5 = r9
            goto L_0x01b0
        L_0x01af:
            r5 = r12
        L_0x01b0:
            float r4 = r4 * r5
            float r4 = r4 + r2
            float r2 = r7.nzZ
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x01ba
            r5 = r10
            goto L_0x01bb
        L_0x01ba:
            r5 = r13
        L_0x01bb:
            float r2 = r2 * r5
            float r2 = r2 + r4
            float r4 = r7.nzW
            float r4 = -r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x01c5
            goto L_0x01c8
        L_0x01c5:
            r15 = 4
            goto L_0x0220
        L_0x01c8:
            r2 = 5
            float r4 = r7.nzX
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x01d1
            r5 = r11
            goto L_0x01d2
        L_0x01d1:
            r5 = r8
        L_0x01d2:
            float r4 = r4 * r5
            float r5 = r7.nzY
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01db
            r6 = r12
            goto L_0x01dc
        L_0x01db:
            r6 = r9
        L_0x01dc:
            float r5 = r5 * r6
            float r5 = r5 + r4
            float r4 = r7.nzZ
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x01e6
            r6 = r13
            goto L_0x01e7
        L_0x01e6:
            r6 = r10
        L_0x01e7:
            float r4 = r4 * r6
            float r4 = r4 + r5
            float r5 = r7.nzW
            float r5 = -r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x01f2
            r4 = r1
            goto L_0x01f3
        L_0x01f2:
            r4 = r0
        L_0x01f3:
            r15 = r15 & r4
            r14 = r14 & 32
            if (r14 == 0) goto L_0x0221
            float r14 = r7.pzX
            int r4 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0200
            r4 = r8
            goto L_0x0201
        L_0x0200:
            r4 = r11
        L_0x0201:
            float r14 = r14 * r4
            float r4 = r7.pzY
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x020a
            r5 = r9
            goto L_0x020b
        L_0x020a:
            r5 = r12
        L_0x020b:
            float r4 = r4 * r5
            float r4 = r4 + r14
            float r14 = r7.pzZ
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0215
            r5 = r10
            goto L_0x0216
        L_0x0215:
            r5 = r13
        L_0x0216:
            float r14 = r14 * r5
            float r14 = r14 + r4
            float r4 = r7.pzW
            float r4 = -r4
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x016b
            goto L_0x0221
        L_0x0220:
            return r15
        L_0x0221:
            float r14 = r7.pzX
            int r2 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0228
            r8 = r11
        L_0x0228:
            float r14 = r14 * r8
            float r8 = r7.pzY
            int r11 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0230
            r9 = r12
        L_0x0230:
            float r8 = r8 * r9
            float r8 = r8 + r14
            float r9 = r7.pzZ
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0239
            r10 = r13
        L_0x0239:
            float r9 = r9 * r10
            float r9 = r9 + r8
            float r8 = r7.pzW
            float r8 = -r8
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x0243
            goto L_0x0244
        L_0x0243:
            r1 = r0
        L_0x0244:
            r8 = r15 & r1
            if (r8 == 0) goto L_0x024a
            r8 = -2
            goto L_0x024b
        L_0x024a:
            r8 = -1
        L_0x024b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.FrustumIntersection.intersectAab(float, float, float, float, float, float, int, int):int");
    }
}
