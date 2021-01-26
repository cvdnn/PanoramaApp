package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public interface Matrix3x2dc {
    double determinant();

    boolean equals(Matrix3x2dc matrix3x2dc, double d2);

    Matrix3x2d get(Matrix3x2d matrix3x2d);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    DoubleBuffer get(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get(DoubleBuffer doubleBuffer);

    double[] get(double[] dArr);

    double[] get(double[] dArr, int i2);

    ByteBuffer get3x3(int i2, ByteBuffer byteBuffer);

    ByteBuffer get3x3(ByteBuffer byteBuffer);

    DoubleBuffer get3x3(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get3x3(DoubleBuffer doubleBuffer);

    double[] get3x3(double[] dArr);

    double[] get3x3(double[] dArr, int i2);

    ByteBuffer get4x4(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x4(ByteBuffer byteBuffer);

    DoubleBuffer get4x4(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get4x4(DoubleBuffer doubleBuffer);

    double[] get4x4(double[] dArr);

    double[] get4x4(double[] dArr, int i2);

    Matrix3x2d invert(Matrix3x2d matrix3x2d);

    double m00();

    double m01();

    double m10();

    double m11();

    double m20();

    double m21();

    Matrix3x2d mul(Matrix3x2dc matrix3x2dc, Matrix3x2d matrix3x2d);

    Matrix3x2d mulLocal(Matrix3x2dc matrix3x2dc, Matrix3x2d matrix3x2d);

    Vector2d normalizedPositiveX(Vector2d vector2d);

    Vector2d normalizedPositiveY(Vector2d vector2d);

    Vector2d origin(Vector2d vector2d);

    Vector2d positiveX(Vector2d vector2d);

    Vector2d positiveY(Vector2d vector2d);

    Matrix3x2d rotate(double d2, Matrix3x2d matrix3x2d);

    Matrix3x2d rotateAbout(double d2, double d3, double d4, Matrix3x2d matrix3x2d);

    Matrix3x2d rotateLocal(double d2, Matrix3x2d matrix3x2d);

    Matrix3x2d rotateTo(Vector2dc vector2dc, Vector2dc vector2dc2, Matrix3x2d matrix3x2d);

    Matrix3x2d scale(double d2, double d3, Matrix3x2d matrix3x2d);

    Matrix3x2d scale(double d2, Matrix3x2d matrix3x2d);

    Matrix3x2d scale(Vector2dc vector2dc, Matrix3x2d matrix3x2d);

    Matrix3x2d scale(Vector2fc vector2fc, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleAround(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleAround(double d2, double d3, double d4, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleAroundLocal(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleAroundLocal(double d2, double d3, double d4, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleLocal(double d2, double d3, Matrix3x2d matrix3x2d);

    Matrix3x2d scaleLocal(double d2, Matrix3x2d matrix3x2d);

    boolean testAar(double d2, double d3, double d4, double d5);

    boolean testCircle(double d2, double d3, double d4);

    boolean testPoint(double d2, double d3);

    Vector3d transform(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transform(Vector3d vector3d);

    Vector3d transform(Vector3dc vector3dc, Vector3d vector3d);

    Vector2d transformDirection(double d2, double d3, Vector2d vector2d);

    Vector2d transformDirection(Vector2d vector2d);

    Vector2d transformDirection(Vector2dc vector2dc, Vector2d vector2d);

    Vector2d transformPosition(double d2, double d3, Vector2d vector2d);

    Vector2d transformPosition(Vector2d vector2d);

    Vector2d transformPosition(Vector2dc vector2dc, Vector2d vector2d);

    Matrix3x2d translate(double d2, double d3, Matrix3x2d matrix3x2d);

    Matrix3x2d translate(Vector2dc vector2dc, Matrix3x2d matrix3x2d);

    Matrix3x2d translateLocal(double d2, double d3, Matrix3x2d matrix3x2d);

    Matrix3x2d translateLocal(Vector2dc vector2dc, Matrix3x2d matrix3x2d);

    Vector2d unproject(double d2, double d3, int[] iArr, Vector2d vector2d);

    Vector2d unprojectInv(double d2, double d3, int[] iArr, Vector2d vector2d);

    Matrix3x2d view(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d);

    double[] viewArea(double[] dArr);
}
