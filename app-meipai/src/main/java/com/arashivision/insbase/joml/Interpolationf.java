package com.arashivision.insbase.joml;

import e.a.a.a.a;

public class Interpolationf {
    public static Vector2f dFdxLinear(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector2f vector2f) {
        float f14 = f7 - f11;
        float f15 = f3 - f11;
        float e2 = a.e(f10, f6, f15, (f2 - f10) * f14);
        float f16 = (e2 - f14) + f15;
        float f17 = 1.0f / e2;
        vector2f.x = (((f16 * f12) + ((f4 * f14) - (f8 * f15))) * f17) - f12;
        vector2f.y = (((f16 * f13) + ((f14 * f5) - (f15 * f9))) * f17) - f13;
        return vector2f;
    }

    public static Vector2f dFdyLinear(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector2f vector2f) {
        float f14 = f10 - f6;
        float f15 = f2 - f10;
        float e2 = a.e(f3, f11, f14, (f7 - f11) * f15);
        float f16 = (e2 - f14) - f15;
        float f17 = 1.0f / e2;
        float f18 = f16 * f12;
        vector2f.x = ((f18 + ((f8 * f15) + (f4 * f14))) * f17) - f12;
        float f19 = f16 * f13;
        vector2f.y = ((f19 + ((f15 * f9) + (f14 * f5))) * f17) - f13;
        return vector2f;
    }

    public static float interpolateTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        float f13 = f6 - f9;
        float f14 = f8 - f5;
        float f15 = f2 - f8;
        float f16 = f12 - f9;
        float f17 = f11 - f8;
        float f18 = f3 - f9;
        float h2 = a.h(f14, f18, f13 * f15, 1.0f);
        float g2 = a.g(f14, f16, f13 * f17, h2);
        float i2 = a.i(f18, f17, f15 * f16, h2);
        return (((1.0f - g2) - i2) * f10) + (f7 * i2) + (f4 * g2);
    }

    public static Vector2f interpolateTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, Vector2f vector2f) {
        float f16 = f7 - f11;
        float f17 = f10 - f6;
        float f18 = f2 - f10;
        float f19 = f15 - f11;
        float f20 = f14 - f10;
        float f21 = f3 - f11;
        float h2 = a.h(f17, f21, f16 * f18, 1.0f);
        float g2 = a.g(f17, f19, f16 * f20, h2);
        float i2 = a.i(f21, f20, f18 * f19, h2);
        float f22 = (1.0f - g2) - i2;
        float f23 = f12 * f22;
        vector2f.x = f23 + (f8 * i2) + (f4 * g2);
        float f24 = f22 * f13;
        vector2f.y = f24 + (i2 * f9) + (g2 * f5);
        return vector2f;
    }

    public static Vector3f interpolationFactorsTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector3f vector3f) {
        float f10 = f5 - f7;
        float f11 = f6 - f4;
        float f12 = f2 - f6;
        float f13 = f9 - f7;
        float f14 = f8 - f6;
        float f15 = f3 - f7;
        float h2 = a.h(f11, f15, f10 * f12, 1.0f);
        float g2 = a.g(f11, f13, f10 * f14, h2);
        vector3f.x = g2;
        float i2 = a.i(f15, f14, f12 * f13, h2);
        vector3f.y = i2;
        vector3f.z = (1.0f - g2) - i2;
        return vector3f;
    }

    public static Vector3f interpolateTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        interpolationFactorsTriangle(f2, f3, f7, f8, f12, f13, f17, f18, vector3f);
        float f19 = vector3f2.x;
        float f20 = f19 * f4;
        float f21 = vector3f2.y;
        float f22 = (f21 * f9) + f20;
        float f23 = vector3f2.z;
        return vector3f2.set((f23 * f14) + f22, (f23 * f15) + (f21 * f10) + (f19 * f5), (f23 * f16) + (f21 * f11) + (f19 * f6));
    }
}
