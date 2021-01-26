package com.arashivision.insbase.joml;

public interface Quaterniondc {
    Quaterniond add(double d2, double d3, double d4, double d5, Quaterniond quaterniond);

    Quaterniond add(Quaterniondc quaterniondc, Quaterniond quaterniond);

    double angle();

    Quaterniond conjugate(Quaterniond quaterniond);

    Quaterniond difference(Quaterniondc quaterniondc, Quaterniond quaterniond);

    Quaterniond div(Quaterniondc quaterniondc, Quaterniond quaterniond);

    double dot(Quaterniondc quaterniondc);

    Matrix3d get(Matrix3d matrix3d);

    Matrix3f get(Matrix3f matrix3f);

    Matrix4d get(Matrix4d matrix4d);

    Matrix4f get(Matrix4f matrix4f);

    Quaterniond get(Quaterniond quaterniond);

    Vector3d getEulerAnglesXYZ(Vector3d vector3d);

    Quaterniond integrate(double d2, double d3, double d4, double d5, Quaterniond quaterniond);

    Quaterniond invert(Quaterniond quaterniond);

    double lengthSquared();

    Quaterniond lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Quaterniond quaterniond);

    Quaterniond lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniond quaterniond);

    Quaterniond mul(double d2, double d3, double d4, double d5, Quaterniond quaterniond);

    Quaterniond mul(Quaterniondc quaterniondc, Quaterniond quaterniond);

    Quaterniond nlerp(Quaterniondc quaterniondc, double d2, Quaterniond quaterniond);

    Quaterniond nlerpIterative(Quaterniondc quaterniondc, double d2, double d3, Quaterniond quaterniond);

    Quaterniond normalize(Quaterniond quaterniond);

    Vector3d normalizedPositiveX(Vector3d vector3d);

    Vector3d normalizedPositiveY(Vector3d vector3d);

    Vector3d normalizedPositiveZ(Vector3d vector3d);

    Vector3d positiveX(Vector3d vector3d);

    Vector3d positiveY(Vector3d vector3d);

    Vector3d positiveZ(Vector3d vector3d);

    Quaterniond premul(double d2, double d3, double d4, double d5, Quaterniond quaterniond);

    Quaterniond premul(Quaterniondc quaterniondc, Quaterniond quaterniond);

    Quaterniond rotateAxis(double d2, double d3, double d4, double d5, Quaterniond quaterniond);

    Quaterniond rotateAxis(double d2, Vector3dc vector3dc, Quaterniond quaterniond);

    Quaterniond rotateLocalX(double d2, Quaterniond quaterniond);

    Quaterniond rotateLocalY(double d2, Quaterniond quaterniond);

    Quaterniond rotateLocalZ(double d2, Quaterniond quaterniond);

    Quaterniond rotateTo(double d2, double d3, double d4, double d5, double d6, double d7, Quaterniond quaterniond);

    Quaterniond rotateTo(Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniond quaterniond);

    Quaterniond rotateX(double d2, Quaterniond quaterniond);

    Quaterniond rotateXYZ(double d2, double d3, double d4, Quaterniond quaterniond);

    Quaterniond rotateY(double d2, Quaterniond quaterniond);

    Quaterniond rotateYXZ(double d2, double d3, double d4, Quaterniond quaterniond);

    Quaterniond rotateZ(double d2, Quaterniond quaterniond);

    Quaterniond rotateZYX(double d2, double d3, double d4, Quaterniond quaterniond);

    Quaterniond scale(double d2, Quaterniond quaterniond);

    Quaterniond slerp(Quaterniondc quaterniondc, double d2, Quaterniond quaterniond);

    Vector3d transform(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transform(Vector3d vector3d);

    Vector3d transform(Vector3dc vector3dc, Vector3d vector3d);

    Vector4d transform(double d2, double d3, double d4, Vector4d vector4d);

    Vector4d transform(Vector4d vector4d);

    Vector4d transform(Vector4dc vector4dc, Vector4d vector4d);

    Vector3d transformPositiveX(Vector3d vector3d);

    Vector4d transformPositiveX(Vector4d vector4d);

    Vector3d transformPositiveY(Vector3d vector3d);

    Vector4d transformPositiveY(Vector4d vector4d);

    Vector3d transformPositiveZ(Vector3d vector3d);

    Vector4d transformPositiveZ(Vector4d vector4d);

    Vector3d transformUnitPositiveX(Vector3d vector3d);

    Vector4d transformUnitPositiveX(Vector4d vector4d);

    Vector3d transformUnitPositiveY(Vector3d vector3d);

    Vector4d transformUnitPositiveY(Vector4d vector4d);

    Vector3d transformUnitPositiveZ(Vector3d vector3d);

    Vector4d transformUnitPositiveZ(Vector4d vector4d);

    double w();

    double x();

    double y();

    double z();
}
