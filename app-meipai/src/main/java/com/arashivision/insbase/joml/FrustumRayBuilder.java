package com.arashivision.insbase.joml;

import e.a.a.a.a;

public class FrustumRayBuilder {
    public float cx;
    public float cy;
    public float cz;
    public float nxnyX;
    public float nxnyY;
    public float nxnyZ;
    public float nxpyX;
    public float nxpyY;
    public float nxpyZ;
    public float pxnyX;
    public float pxnyY;
    public float pxnyZ;
    public float pxpyX;
    public float pxpyY;
    public float pxpyZ;

    public FrustumRayBuilder() {
    }

    public Vector3fc dir(float f2, float f3, Vector3f vector3f) {
        float f4 = this.nxnyX;
        float e2 = a.e(this.nxpyX, f4, f3, f4);
        float f5 = this.nxnyY;
        float e3 = a.e(this.nxpyY, f5, f3, f5);
        float f6 = this.nxnyZ;
        float e4 = a.e(this.nxpyZ, f6, f3, f6);
        float f7 = this.pxnyX;
        float e5 = a.e(this.pxpyX, f7, f3, f7);
        float f8 = this.pxnyY;
        float e6 = a.e(this.pxpyY, f8, f3, f8);
        float f9 = this.pxnyZ;
        float e7 = a.e(this.pxpyZ, f9, f3, f9);
        float e8 = a.e(e5, e2, f2, e2);
        float e9 = a.e(e6, e3, f2, e3);
        float e10 = a.e(e7, e4, f2, e4);
        float sqrt = (float) (1.0d / Math.sqrt((double) ((e10 * e10) + ((e9 * e9) + (e8 * e8)))));
        vector3f.x = e8 * sqrt;
        vector3f.y = e9 * sqrt;
        vector3f.z = e10 * sqrt;
        return vector3f;
    }

    public Vector3fc origin(Vector3f vector3f) {
        vector3f.x = this.cx;
        vector3f.y = this.cy;
        vector3f.z = this.cz;
        return vector3f;
    }

    public FrustumRayBuilder set(Matrix4fc matrix4fc) {
        float m00 = matrix4fc.m00() + matrix4fc.m03();
        float m10 = matrix4fc.m10() + matrix4fc.m13();
        float m20 = matrix4fc.m20() + matrix4fc.m23();
        float m30 = matrix4fc.m30() + matrix4fc.m33();
        float m03 = matrix4fc.m03() - matrix4fc.m00();
        float m13 = matrix4fc.m13() - matrix4fc.m10();
        float m23 = matrix4fc.m23() - matrix4fc.m20();
        float m33 = matrix4fc.m33() - matrix4fc.m30();
        float m01 = matrix4fc.m01() + matrix4fc.m03();
        float m11 = matrix4fc.m11() + matrix4fc.m13();
        float m21 = matrix4fc.m21() + matrix4fc.m23();
        float m032 = matrix4fc.m03() - matrix4fc.m01();
        float m132 = matrix4fc.m13() - matrix4fc.m11();
        float m232 = matrix4fc.m23() - matrix4fc.m21();
        float m332 = matrix4fc.m33() - matrix4fc.m31();
        this.nxnyX = (m11 * m20) - (m21 * m10);
        this.nxnyY = (m21 * m00) - (m01 * m20);
        this.nxnyZ = (m01 * m10) - (m11 * m00);
        this.pxnyX = (m13 * m21) - (m23 * m11);
        this.pxnyY = (m23 * m01) - (m21 * m03);
        this.pxnyZ = (m11 * m03) - (m01 * m13);
        float f2 = (m10 * m232) - (m20 * m132);
        this.nxpyX = f2;
        float f3 = (m20 * m032) - (m00 * m232);
        this.nxpyY = f3;
        float f4 = (m00 * m132) - (m10 * m032);
        this.nxpyZ = f4;
        float f5 = (m132 * m23) - (m232 * m13);
        this.pxpyX = f5;
        float f6 = (m232 * m03) - (m032 * m23);
        this.pxpyY = f6;
        float f7 = (m032 * m13) - (m132 * m03);
        this.pxpyZ = f7;
        float f8 = (m13 * m20) - (m23 * m10);
        float f9 = (m23 * m00) - (m03 * m20);
        float f10 = (m03 * m10) - (m13 * m00);
        float h2 = a.h(m20, f7, (m10 * f6) + (m00 * f5), 1.0f);
        float f11 = m332;
        this.cx = a.i(f8, f11, ((-f5) * m30) - (f2 * m33), h2);
        this.cy = a.i(f9, f11, ((-f6) * m30) - (f3 * m33), h2);
        this.cz = a.i(f10, f11, ((-f7) * m30) - (f4 * m33), h2);
        return this;
    }

    public FrustumRayBuilder(Matrix4fc matrix4fc) {
        set(matrix4fc);
    }
}
