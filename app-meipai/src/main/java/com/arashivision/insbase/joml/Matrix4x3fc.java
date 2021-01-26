package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Matrix4x3fc {
    public static final int PLANE_NX = 0;
    public static final int PLANE_NY = 2;
    public static final int PLANE_NZ = 4;
    public static final int PLANE_PX = 1;
    public static final int PLANE_PY = 3;
    public static final int PLANE_PZ = 5;
    public static final byte PROPERTY_IDENTITY = 4;
    public static final byte PROPERTY_ORTHONORMAL = 16;
    public static final byte PROPERTY_TRANSLATION = 8;

    Matrix4x3f add(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f arcball(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f arcball(float f2, Vector3fc vector3fc, float f3, float f4, Matrix4x3f matrix4x3f);

    float determinant();

    boolean equals(Matrix4x3fc matrix4x3fc, float f2);

    Matrix4x3f fma(Matrix4x3fc matrix4x3fc, float f2, Matrix4x3f matrix4x3f);

    Planef frustumPlane(int i2, Planef planef);

    Matrix4d get(Matrix4d matrix4d);

    Matrix4f get(Matrix4f matrix4f);

    Matrix4x3d get(Matrix4x3d matrix4x3d);

    Matrix4x3f get(Matrix4x3f matrix4x3f);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    float[] get(float[] fArr);

    float[] get(float[] fArr, int i2);

    ByteBuffer get4x4(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x4(ByteBuffer byteBuffer);

    FloatBuffer get4x4(int i2, FloatBuffer floatBuffer);

    FloatBuffer get4x4(FloatBuffer floatBuffer);

    float[] get4x4(float[] fArr);

    float[] get4x4(float[] fArr, int i2);

    Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException;

    Vector3f getEulerAnglesZYX(Vector3f vector3f);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    AxisAngle4d getRotation(AxisAngle4d axisAngle4d);

    AxisAngle4f getRotation(AxisAngle4f axisAngle4f);

    Vector4f getRow(int i2, Vector4f vector4f) throws IndexOutOfBoundsException;

    Vector3f getScale(Vector3f vector3f);

    Vector3f getTranslation(Vector3f vector3f);

    ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposed(ByteBuffer byteBuffer);

    FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer);

    FloatBuffer getTransposed(FloatBuffer floatBuffer);

    float[] getTransposed(float[] fArr);

    float[] getTransposed(float[] fArr, int i2);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix4x3f invert(Matrix4x3f matrix4x3f);

    Matrix4x3f invertOrtho(Matrix4x3f matrix4x3f);

    Matrix4x3f lerp(Matrix4x3fc matrix4x3fc, float f2, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f);

    Matrix4x3f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4x3f matrix4x3f);

    float m00();

    float m01();

    float m02();

    float m10();

    float m11();

    float m12();

    float m20();

    float m21();

    float m22();

    float m30();

    float m31();

    float m32();

    Matrix4x3f mul(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f mulComponentWise(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f mulOrtho(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f mulTranslation(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix3f normal(Matrix3f matrix3f);

    Matrix4x3f normal(Matrix4x3f matrix4x3f);

    Matrix3f normalize3x3(Matrix3f matrix3f);

    Matrix4x3f normalize3x3(Matrix4x3f matrix4x3f);

    Vector3f normalizedPositiveX(Vector3f vector3f);

    Vector3f normalizedPositiveY(Vector3f vector3f);

    Vector3f normalizedPositiveZ(Vector3f vector3f);

    Matrix4x3f obliqueZ(float f2, float f3, Matrix4x3f matrix4x3f);

    Vector3f origin(Vector3f vector3f);

    Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4x3f matrix4x3f);

    Matrix4x3f ortho2D(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f ortho2DLH(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z, Matrix4x3f matrix4x3f);

    Matrix4x3f pick(float f2, float f3, float f4, float f5, int[] iArr, Matrix4x3f matrix4x3f);

    Vector3f positiveX(Vector3f vector3f);

    Vector3f positiveY(Vector3f vector3f);

    Vector3f positiveZ(Vector3f vector3f);

    int properties();

    Matrix4x3f reflect(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f reflect(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f reflect(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f);

    Matrix4x3f rotate(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f rotate(float f2, Vector3fc vector3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f rotate(AxisAngle4f axisAngle4f, Matrix4x3f matrix4x3f);

    Matrix4x3f rotate(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateLocal(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateLocal(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateTranslation(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateTranslation(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateX(float f2, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateXYZ(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateY(float f2, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateYXZ(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateZ(float f2, Matrix4x3f matrix4x3f);

    Matrix4x3f rotateZYX(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f scale(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f scale(float f2, Matrix4x3f matrix4x3f);

    Matrix4x3f scale(Vector3fc vector3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f scaleLocal(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Matrix4x3f matrix4x3f);

    Matrix4x3f shadow(float f2, float f3, float f4, float f5, Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f shadow(Vector4fc vector4fc, float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f);

    Matrix4x3f shadow(Vector4fc vector4fc, Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f sub(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f);

    Vector4f transform(Vector4f vector4f);

    Vector4f transform(Vector4fc vector4fc, Vector4f vector4f);

    Matrix4x3f transformAab(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f, Vector3f vector3f2);

    Matrix4x3f transformAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f, Vector3f vector3f2);

    Vector3f transformDirection(Vector3f vector3f);

    Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f transformPosition(Vector3f vector3f);

    Vector3f transformPosition(Vector3fc vector3fc, Vector3f vector3f);

    Matrix4x3f translate(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f translate(Vector3fc vector3fc, Matrix4x3f matrix4x3f);

    Matrix4x3f translateLocal(float f2, float f3, float f4, Matrix4x3f matrix4x3f);

    Matrix4x3f translateLocal(Vector3fc vector3fc, Matrix4x3f matrix4x3f);

    Matrix3f transpose3x3(Matrix3f matrix3f);

    Matrix4x3f transpose3x3(Matrix4x3f matrix4x3f);
}
