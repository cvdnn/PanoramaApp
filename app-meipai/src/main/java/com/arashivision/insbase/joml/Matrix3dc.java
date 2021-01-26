package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public interface Matrix3dc {
    Matrix3d add(Matrix3dc matrix3dc, Matrix3d matrix3d);

    double determinant();

    boolean equals(Matrix3dc matrix3dc, double d2);

    double get(int i2, int i3);

    Matrix3d get(Matrix3d matrix3d);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    DoubleBuffer get(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get(DoubleBuffer doubleBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    double[] get(double[] dArr);

    double[] get(double[] dArr, int i2);

    float[] get(float[] fArr);

    float[] get(float[] fArr, int i2);

    Vector3d getColumn(int i2, Vector3d vector3d) throws IndexOutOfBoundsException;

    Vector3d getEulerAnglesZYX(Vector3d vector3d);

    ByteBuffer getFloats(int i2, ByteBuffer byteBuffer);

    ByteBuffer getFloats(ByteBuffer byteBuffer);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    AxisAngle4f getRotation(AxisAngle4f axisAngle4f);

    Vector3d getRow(int i2, Vector3d vector3d) throws IndexOutOfBoundsException;

    Vector3d getScale(Vector3d vector3d);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix3d invert(Matrix3d matrix3d);

    Matrix3d lerp(Matrix3dc matrix3dc, double d2, Matrix3d matrix3d);

    Matrix3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix3d matrix3d);

    Matrix3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix3d matrix3d);

    double m00();

    double m01();

    double m02();

    double m10();

    double m11();

    double m12();

    double m20();

    double m21();

    double m22();

    Matrix3d mul(Matrix3dc matrix3dc, Matrix3d matrix3d);

    Matrix3d mul(Matrix3fc matrix3fc, Matrix3d matrix3d);

    Matrix3d mulComponentWise(Matrix3dc matrix3dc, Matrix3d matrix3d);

    Matrix3d mulLocal(Matrix3dc matrix3dc, Matrix3d matrix3d);

    Matrix3d normal(Matrix3d matrix3d);

    Vector3d normalizedPositiveX(Vector3d vector3d);

    Vector3d normalizedPositiveY(Vector3d vector3d);

    Vector3d normalizedPositiveZ(Vector3d vector3d);

    Matrix3d obliqueZ(double d2, double d3, Matrix3d matrix3d);

    Vector3d positiveX(Vector3d vector3d);

    Vector3d positiveY(Vector3d vector3d);

    Vector3d positiveZ(Vector3d vector3d);

    Matrix3d rotate(double d2, double d3, double d4, double d5, Matrix3d matrix3d);

    Matrix3d rotate(double d2, Vector3dc vector3dc, Matrix3d matrix3d);

    Matrix3d rotate(double d2, Vector3fc vector3fc, Matrix3d matrix3d);

    Matrix3d rotate(AxisAngle4d axisAngle4d, Matrix3d matrix3d);

    Matrix3d rotate(AxisAngle4f axisAngle4f, Matrix3d matrix3d);

    Matrix3d rotate(Quaterniondc quaterniondc, Matrix3d matrix3d);

    Matrix3d rotate(Quaternionfc quaternionfc, Matrix3d matrix3d);

    Matrix3d rotateLocal(double d2, double d3, double d4, double d5, Matrix3d matrix3d);

    Matrix3d rotateLocal(Quaterniondc quaterniondc, Matrix3d matrix3d);

    Matrix3d rotateLocal(Quaternionfc quaternionfc, Matrix3d matrix3d);

    Matrix3d rotateLocalX(double d2, Matrix3d matrix3d);

    Matrix3d rotateLocalY(double d2, Matrix3d matrix3d);

    Matrix3d rotateLocalZ(double d2, Matrix3d matrix3d);

    Matrix3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix3d matrix3d);

    Matrix3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix3d matrix3d);

    Matrix3d rotateX(double d2, Matrix3d matrix3d);

    Matrix3d rotateXYZ(double d2, double d3, double d4, Matrix3d matrix3d);

    Matrix3d rotateY(double d2, Matrix3d matrix3d);

    Matrix3d rotateYXZ(double d2, double d3, double d4, Matrix3d matrix3d);

    Matrix3d rotateZ(double d2, Matrix3d matrix3d);

    Matrix3d rotateZYX(double d2, double d3, double d4, Matrix3d matrix3d);

    Matrix3d scale(double d2, double d3, double d4, Matrix3d matrix3d);

    Matrix3d scale(double d2, Matrix3d matrix3d);

    Matrix3d scale(Vector3dc vector3dc, Matrix3d matrix3d);

    Matrix3d scaleLocal(double d2, double d3, double d4, Matrix3d matrix3d);

    Matrix3d sub(Matrix3dc matrix3dc, Matrix3d matrix3d);

    Vector3d transform(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transform(Vector3d vector3d);

    Vector3d transform(Vector3dc vector3dc, Vector3d vector3d);

    Vector3f transform(Vector3f vector3f);

    Vector3f transform(Vector3fc vector3fc, Vector3f vector3f);

    Vector3d transformTranspose(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transformTranspose(Vector3d vector3d);

    Vector3d transformTranspose(Vector3dc vector3dc, Vector3d vector3d);

    Matrix3d transpose(Matrix3d matrix3d);
}
