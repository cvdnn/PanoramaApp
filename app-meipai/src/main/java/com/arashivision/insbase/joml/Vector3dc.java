package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public interface Vector3dc {
    Vector3d absolute(Vector3d vector3d);

    Vector3d add(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d add(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d add(Vector3fc vector3fc, Vector3d vector3d);

    double angle(Vector3dc vector3dc);

    double angleCos(Vector3dc vector3dc);

    Vector3d ceil(Vector3d vector3d);

    Vector3d cross(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d cross(Vector3dc vector3dc, Vector3d vector3d);

    double distance(double d2, double d3, double d4);

    double distance(Vector3dc vector3dc);

    double distanceSquared(double d2, double d3, double d4);

    double distanceSquared(Vector3dc vector3dc);

    Vector3d div(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d div(double d2, Vector3d vector3d);

    Vector3d div(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d div(Vector3fc vector3fc, Vector3d vector3d);

    double dot(double d2, double d3, double d4);

    double dot(Vector3dc vector3dc);

    boolean equals(double d2, double d3, double d4);

    boolean equals(Vector3dc vector3dc, double d2);

    Vector3d floor(Vector3d vector3d);

    Vector3d fma(double d2, Vector3dc vector3dc, Vector3d vector3d);

    Vector3d fma(double d2, Vector3fc vector3fc, Vector3d vector3d);

    Vector3d fma(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d);

    Vector3d fma(Vector3dc vector3dc, Vector3fc vector3fc, Vector3d vector3d);

    Vector3d fma(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3d vector3d);

    double get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    DoubleBuffer get(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get(DoubleBuffer doubleBuffer);

    Vector3d half(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d half(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d hermite(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2, Vector3d vector3d);

    boolean isFinite();

    double length();

    double lengthSquared();

    Vector3d lerp(Vector3dc vector3dc, double d2, Vector3d vector3d);

    Vector3d max(Vector3dc vector3dc, Vector3d vector3d);

    int maxComponent();

    Vector3d min(Vector3dc vector3dc, Vector3d vector3d);

    int minComponent();

    Vector3d mul(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d mul(double d2, Vector3d vector3d);

    Vector3d mul(Matrix3dc matrix3dc, Vector3d vector3d);

    Vector3d mul(Matrix3fc matrix3fc, Vector3d vector3d);

    Vector3d mul(Matrix3x2dc matrix3x2dc, Vector3d vector3d);

    Vector3d mul(Matrix3x2fc matrix3x2fc, Vector3d vector3d);

    Vector3d mul(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d mul(Vector3fc vector3fc, Vector3d vector3d);

    Vector3d mulDirection(Matrix4dc matrix4dc, Vector3d vector3d);

    Vector3d mulDirection(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d mulDirection(Matrix4x3dc matrix4x3dc, Vector3d vector3d);

    Vector3d mulDirection(Matrix4x3fc matrix4x3fc, Vector3d vector3d);

    Vector3d mulPosition(Matrix4dc matrix4dc, Vector3d vector3d);

    Vector3d mulPosition(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d mulPosition(Matrix4x3dc matrix4x3dc, Vector3d vector3d);

    Vector3d mulPosition(Matrix4x3fc matrix4x3fc, Vector3d vector3d);

    double mulPositionW(Matrix4dc matrix4dc, Vector3d vector3d);

    double mulPositionW(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d mulProject(Matrix4dc matrix4dc, Vector3d vector3d);

    Vector3d mulProject(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d mulTranspose(Matrix3dc matrix3dc, Vector3d vector3d);

    Vector3d mulTranspose(Matrix3fc matrix3fc, Vector3d vector3d);

    Vector3d mulTransposeDirection(Matrix4dc matrix4dc, Vector3d vector3d);

    Vector3d mulTransposeDirection(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d mulTransposePosition(Matrix4dc matrix4dc, Vector3d vector3d);

    Vector3d mulTransposePosition(Matrix4fc matrix4fc, Vector3d vector3d);

    Vector3d negate(Vector3d vector3d);

    Vector3d normalize(double d2, Vector3d vector3d);

    Vector3d normalize(Vector3d vector3d);

    Vector3d orthogonalize(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d orthogonalizeUnit(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d reflect(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d reflect(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d rotate(Quaterniondc quaterniondc, Vector3d vector3d);

    Vector3d rotateAxis(double d2, double d3, double d4, double d5, Vector3d vector3d);

    Vector3d rotateX(double d2, Vector3d vector3d);

    Vector3d rotateY(double d2, Vector3d vector3d);

    Vector3d rotateZ(double d2, Vector3d vector3d);

    Quaterniond rotationTo(double d2, double d3, double d4, Quaterniond quaterniond);

    Quaterniond rotationTo(Vector3dc vector3dc, Quaterniond quaterniond);

    Vector3d round(Vector3d vector3d);

    Vector3d smoothStep(Vector3dc vector3dc, double d2, Vector3d vector3d);

    Vector3d sub(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d sub(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d sub(Vector3fc vector3fc, Vector3d vector3d);

    double x();

    double y();

    double z();
}
