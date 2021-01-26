package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Matrix3fc {
    Matrix3f add(Matrix3fc matrix3fc, Matrix3f matrix3f);

    float determinant();

    boolean equals(Matrix3fc matrix3fc, float f2);

    float get(int i2, int i3);

    Matrix3f get(Matrix3f matrix3f);

    Matrix4f get(Matrix4f matrix4f);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    float[] get(float[] fArr);

    float[] get(float[] fArr, int i2);

    Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException;

    Vector3f getEulerAnglesZYX(Vector3f vector3f);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    AxisAngle4f getRotation(AxisAngle4f axisAngle4f);

    Vector3f getRow(int i2, Vector3f vector3f) throws IndexOutOfBoundsException;

    Vector3f getScale(Vector3f vector3f);

    ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposed(ByteBuffer byteBuffer);

    FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer);

    FloatBuffer getTransposed(FloatBuffer floatBuffer);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix3f invert(Matrix3f matrix3f);

    Matrix3f lerp(Matrix3fc matrix3fc, float f2, Matrix3f matrix3f);

    Matrix3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix3f matrix3f);

    Matrix3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix3f matrix3f);

    float m00();

    float m01();

    float m02();

    float m10();

    float m11();

    float m12();

    float m20();

    float m21();

    float m22();

    Matrix3f mul(Matrix3fc matrix3fc, Matrix3f matrix3f);

    Matrix3f mulComponentWise(Matrix3fc matrix3fc, Matrix3f matrix3f);

    Matrix3f mulLocal(Matrix3fc matrix3fc, Matrix3f matrix3f);

    Matrix3f normal(Matrix3f matrix3f);

    Vector3f normalizedPositiveX(Vector3f vector3f);

    Vector3f normalizedPositiveY(Vector3f vector3f);

    Vector3f normalizedPositiveZ(Vector3f vector3f);

    Matrix3f obliqueZ(float f2, float f3, Matrix3f matrix3f);

    Vector3f positiveX(Vector3f vector3f);

    Vector3f positiveY(Vector3f vector3f);

    Vector3f positiveZ(Vector3f vector3f);

    Matrix3f rotate(float f2, float f3, float f4, float f5, Matrix3f matrix3f);

    Matrix3f rotate(float f2, Vector3fc vector3fc, Matrix3f matrix3f);

    Matrix3f rotate(AxisAngle4f axisAngle4f, Matrix3f matrix3f);

    Matrix3f rotate(Quaternionfc quaternionfc, Matrix3f matrix3f);

    Matrix3f rotateLocal(float f2, float f3, float f4, float f5, Matrix3f matrix3f);

    Matrix3f rotateLocal(Quaternionfc quaternionfc, Matrix3f matrix3f);

    Matrix3f rotateLocalX(float f2, Matrix3f matrix3f);

    Matrix3f rotateLocalY(float f2, Matrix3f matrix3f);

    Matrix3f rotateLocalZ(float f2, Matrix3f matrix3f);

    Matrix3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix3f matrix3f);

    Matrix3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix3f matrix3f);

    Matrix3f rotateX(float f2, Matrix3f matrix3f);

    Matrix3f rotateXYZ(float f2, float f3, float f4, Matrix3f matrix3f);

    Matrix3f rotateY(float f2, Matrix3f matrix3f);

    Matrix3f rotateYXZ(float f2, float f3, float f4, Matrix3f matrix3f);

    Matrix3f rotateZ(float f2, Matrix3f matrix3f);

    Matrix3f rotateZYX(float f2, float f3, float f4, Matrix3f matrix3f);

    Matrix3f scale(float f2, float f3, float f4, Matrix3f matrix3f);

    Matrix3f scale(float f2, Matrix3f matrix3f);

    Matrix3f scale(Vector3fc vector3fc, Matrix3f matrix3f);

    Matrix3f scaleLocal(float f2, float f3, float f4, Matrix3f matrix3f);

    Matrix3f sub(Matrix3fc matrix3fc, Matrix3f matrix3f);

    Vector3f transform(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transform(Vector3f vector3f);

    Vector3f transform(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f transformTranspose(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transformTranspose(Vector3f vector3f);

    Vector3f transformTranspose(Vector3fc vector3fc, Vector3f vector3f);

    Matrix3f transpose(Matrix3f matrix3f);
}
