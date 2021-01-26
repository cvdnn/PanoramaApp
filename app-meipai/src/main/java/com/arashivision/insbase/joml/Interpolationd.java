package com.arashivision.insbase.joml;

import e.a.a.a.a;

public class Interpolationd {
    public static Vector2d dFdxLinear(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d14 = d7 - d11;
        double d15 = d3 - d11;
        double h2 = a.h(d10, d6, d15, (d2 - d10) * d14);
        double d16 = (h2 - d14) + d15;
        double d17 = 1.0d / h2;
        vector2d2.x = (((d16 * d12) + ((d14 * d4) - (d15 * d8))) * d17) - d12;
        vector2d2.y = (((d16 * d13) + ((d14 * d5) - (d15 * d9))) * d17) - d13;
        return vector2d2;
    }

    public static Vector2d dFdyLinear(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d14 = d10 - d6;
        double d15 = d2 - d10;
        double h2 = a.h(d3, d11, d14, (d7 - d11) * d15);
        double d16 = (h2 - d14) - d15;
        double d17 = 1.0d / h2;
        vector2d2.x = (((d16 * d12) + ((d15 * d8) + (d14 * d4))) * d17) - d12;
        double d18 = d16 * d13;
        vector2d2.y = ((d18 + ((d15 * d9) + (d14 * d5))) * d17) - d13;
        return vector2d2;
    }

    public static double interpolateTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double d13 = d6 - d9;
        double d14 = d2 - d8;
        double d15 = d12 - d9;
        double d16 = d11 - d8;
        double d17 = d3 - d9;
        double d18 = d8 - d5;
        double l = a.l(d18, d17, d13 * d14, 1.0d);
        double d19 = l;
        double k = a.k(d18, d15, d13 * d16, d19);
        double c2 = a.c(d17, d16, d14 * d15, d19);
        return (((1.0d - k) - c2) * d10) + (c2 * d7) + (k * d4);
    }

    public static Vector2d interpolateTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d16 = d7 - d11;
        double d17 = d2 - d10;
        double d18 = d15 - d11;
        double d19 = d14 - d10;
        double d20 = d3 - d11;
        double d21 = d10 - d6;
        double l = a.l(d21, d20, d16 * d17, 1.0d);
        double d22 = l;
        double k = a.k(d21, d18, d16 * d19, d22);
        double c2 = a.c(d20, d19, d17 * d18, d22);
        double d23 = (1.0d - k) - c2;
        vector2d2.x = (d23 * d12) + (c2 * d8) + (k * d4);
        double d24 = d23 * d13;
        vector2d2.y = d24 + (c2 * d9) + (k * d5);
        return vector2d2;
    }

    public static Vector3d interpolationFactorsTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d10 = d5 - d7;
        double d11 = d2 - d6;
        double d12 = d9 - d7;
        double d13 = d8 - d6;
        double d14 = d3 - d7;
        double d15 = d6 - d4;
        double l = a.l(d15, d14, d10 * d11, 1.0d);
        double k = a.k(d15, d12, d10 * d13, l);
        vector3d2.x = k;
        double c2 = a.c(d14, d13, d11 * d12, l);
        vector3d2.y = c2;
        vector3d2.z = (1.0d - k) - c2;
        return vector3d2;
    }

    public static Vector3d interpolateTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        interpolationFactorsTriangle(d2, d3, d7, d8, d12, d13, d17, d18, vector3d);
        Vector3d vector3d3 = vector3d;
        double d19 = vector3d3.x;
        double d20 = d19 * d4;
        double d21 = vector3d3.y;
        double d22 = (d21 * d9) + d20;
        double d23 = vector3d3.z;
        return vector3d.set(d22 + (d23 * d14), (d23 * d15) + (d21 * d10) + (d19 * d5), (d23 * d16) + (d21 * d11) + (d19 * d6));
    }
}
