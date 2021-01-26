package com.arashivision.insbase.joml;

public class GeometryUtils {
    public static void bitangent(Vector3fc vector3fc, Vector2fc vector2fc, Vector3fc vector3fc2, Vector2fc vector2fc2, Vector3fc vector3fc3, Vector2fc vector2fc3, Vector3f vector3f) {
        float x = vector2fc2.x() - vector2fc.x();
        float x2 = vector2fc3.x() - vector2fc.x();
        float y = 1.0f / (((vector2fc3.y() - vector2fc.y()) * x) - ((vector2fc2.y() - vector2fc.y()) * x2));
        float f2 = -x2;
        vector3f.x = (((vector3fc2.x() - vector3fc.x()) * f2) - ((vector3fc3.x() - vector3fc.x()) * x)) * y;
        vector3f.y = (((vector3fc2.y() - vector3fc.y()) * f2) - ((vector3fc3.y() - vector3fc.y()) * x)) * y;
        vector3f.z = (((vector3fc2.z() - vector3fc.z()) * f2) - ((vector3fc3.z() - vector3fc.z()) * x)) * y;
        vector3f.normalize();
    }

    public static void normal(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3f vector3f) {
        normal(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3f);
    }

    public static void perpendicular(float f2, float f3, float f4, Vector3f vector3f, Vector3f vector3f2) {
        float f5 = f4 * f4;
        float f6 = f3 * f3;
        float f7 = f5 + f6;
        float f8 = f2 * f2;
        float f9 = f5 + f8;
        float f10 = f6 + f8;
        if (f7 > f9 && f7 > f10) {
            vector3f.x = 0.0f;
            vector3f.y = f4;
            vector3f.z = -f3;
        } else if (f9 > f10) {
            vector3f.x = f4;
            vector3f.y = 0.0f;
            vector3f.z = f2;
            f7 = f9;
        } else {
            vector3f.x = f3;
            vector3f.y = -f2;
            vector3f.z = 0.0f;
            f7 = f10;
        }
        float sqrt = 1.0f / ((float) Math.sqrt((double) f7));
        vector3f.x *= sqrt;
        float f11 = vector3f.y * sqrt;
        vector3f.y = f11;
        float f12 = vector3f.z * sqrt;
        vector3f.z = f12;
        vector3f2.x = (f3 * f12) - (f11 * f4);
        float f13 = vector3f.x;
        vector3f2.y = (f4 * f13) - (f12 * f2);
        vector3f2.z = (f2 * vector3f.y) - (f3 * f13);
    }

    public static void tangent(Vector3fc vector3fc, Vector2fc vector2fc, Vector3fc vector3fc2, Vector2fc vector2fc2, Vector3fc vector3fc3, Vector2fc vector2fc3, Vector3f vector3f) {
        float y = vector2fc2.y() - vector2fc.y();
        float y2 = vector2fc3.y() - vector2fc.y();
        float x = 1.0f / (((vector2fc2.x() - vector2fc.x()) * y2) - ((vector2fc3.x() - vector2fc.x()) * y));
        vector3f.x = (((vector3fc2.x() - vector3fc.x()) * y2) - ((vector3fc3.x() - vector3fc.x()) * y)) * x;
        vector3f.y = (((vector3fc2.y() - vector3fc.y()) * y2) - ((vector3fc3.y() - vector3fc.y()) * y)) * x;
        vector3f.z = (((vector3fc2.z() - vector3fc.z()) * y2) - ((vector3fc3.z() - vector3fc.z()) * y)) * x;
        vector3f.normalize();
    }

    public static void tangentBitangent(Vector3fc vector3fc, Vector2fc vector2fc, Vector3fc vector3fc2, Vector2fc vector2fc2, Vector3fc vector3fc3, Vector2fc vector2fc3, Vector3f vector3f, Vector3f vector3f2) {
        float y = vector2fc2.y() - vector2fc.y();
        float y2 = vector2fc3.y() - vector2fc.y();
        float x = vector2fc2.x() - vector2fc.x();
        float x2 = vector2fc3.x() - vector2fc.x();
        float f2 = 1.0f / ((x * y2) - (x2 * y));
        vector3f.x = (((vector3fc2.x() - vector3fc.x()) * y2) - ((vector3fc3.x() - vector3fc.x()) * y)) * f2;
        vector3f.y = (((vector3fc2.y() - vector3fc.y()) * y2) - ((vector3fc3.y() - vector3fc.y()) * y)) * f2;
        vector3f.z = (((vector3fc2.z() - vector3fc.z()) * y2) - ((vector3fc3.z() - vector3fc.z()) * y)) * f2;
        vector3f.normalize();
        float f3 = -x2;
        vector3f2.x = (((vector3fc2.x() - vector3fc.x()) * f3) - ((vector3fc3.x() - vector3fc.x()) * x)) * f2;
        vector3f2.y = (((vector3fc2.y() - vector3fc.y()) * f3) - ((vector3fc3.y() - vector3fc.y()) * x)) * f2;
        vector3f2.z = (((vector3fc2.z() - vector3fc.z()) * f3) - ((vector3fc3.z() - vector3fc.z()) * x)) * f2;
        vector3f2.normalize();
    }

    public static void normal(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector3f vector3f) {
        float f11 = f6 - f3;
        float f12 = f10 - f4;
        float f13 = f7 - f4;
        float f14 = f9 - f3;
        vector3f.x = (f11 * f12) - (f13 * f14);
        float f15 = f8 - f2;
        float f16 = f5 - f2;
        vector3f.y = (f13 * f15) - (f12 * f16);
        vector3f.z = (f16 * f14) - (f11 * f15);
        vector3f.normalize();
    }

    public static void perpendicular(Vector3fc vector3fc, Vector3f vector3f, Vector3f vector3f2) {
        perpendicular(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f, vector3f2);
    }
}
