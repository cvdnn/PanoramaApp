package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public interface Matrix4x3dc {
    public static final int PLANE_NX = 0;
    public static final int PLANE_NY = 2;
    public static final int PLANE_NZ = 4;
    public static final int PLANE_PX = 1;
    public static final int PLANE_PY = 3;
    public static final int PLANE_PZ = 5;
    public static final byte PROPERTY_IDENTITY = 4;
    public static final byte PROPERTY_ORTHONORMAL = 16;
    public static final byte PROPERTY_TRANSLATION = 8;

    Matrix4x3d add(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d add(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d);

    Matrix4x3d arcball(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d arcball(double d2, Vector3dc vector3dc, double d3, double d4, Matrix4x3d matrix4x3d);

    double determinant();

    boolean equals(Matrix4x3dc matrix4x3dc, double d2);

    Matrix4x3d fma(Matrix4x3dc matrix4x3dc, double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d fma(Matrix4x3fc matrix4x3fc, double d2, Matrix4x3d matrix4x3d);

    Planed frustumPlane(int i2, Planed planed);

    Matrix4d get(Matrix4d matrix4d);

    Matrix4x3d get(Matrix4x3d matrix4x3d);

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

    ByteBuffer get4x4(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x4(ByteBuffer byteBuffer);

    DoubleBuffer get4x4(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get4x4(DoubleBuffer doubleBuffer);

    double[] get4x4(double[] dArr);

    double[] get4x4(double[] dArr, int i2);

    float[] get4x4(float[] fArr);

    float[] get4x4(float[] fArr, int i2);

    Vector3d getColumn(int i2, Vector3d vector3d) throws IndexOutOfBoundsException;

    Vector3d getEulerAnglesZYX(Vector3d vector3d);

    ByteBuffer getFloats(int i2, ByteBuffer byteBuffer);

    ByteBuffer getFloats(ByteBuffer byteBuffer);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    Vector4d getRow(int i2, Vector4d vector4d) throws IndexOutOfBoundsException;

    Vector3d getScale(Vector3d vector3d);

    Vector3d getTranslation(Vector3d vector3d);

    ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposed(ByteBuffer byteBuffer);

    DoubleBuffer getTransposed(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer getTransposed(DoubleBuffer doubleBuffer);

    FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer);

    FloatBuffer getTransposed(FloatBuffer floatBuffer);

    double[] getTransposed(double[] dArr);

    double[] getTransposed(double[] dArr, int i2);

    ByteBuffer getTransposedFloats(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposedFloats(ByteBuffer byteBuffer);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix4x3d invert(Matrix4x3d matrix4x3d);

    Matrix4x3d invertOrtho(Matrix4x3d matrix4x3d);

    Matrix4x3d lerp(Matrix4x3dc matrix4x3dc, double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d);

    Matrix4x3d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4x3d matrix4x3d);

    double m00();

    double m01();

    double m02();

    double m10();

    double m11();

    double m12();

    double m20();

    double m21();

    double m22();

    double m30();

    double m31();

    double m32();

    Matrix4x3d mul(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d mul(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d);

    Matrix4x3d mulComponentWise(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d mulOrtho(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d mulTranslation(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d mulTranslation(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d);

    Matrix3d normal(Matrix3d matrix3d);

    Matrix4x3d normal(Matrix4x3d matrix4x3d);

    Matrix3d normalize3x3(Matrix3d matrix3d);

    Matrix4x3d normalize3x3(Matrix4x3d matrix4x3d);

    Vector3d normalizedPositiveX(Vector3d vector3d);

    Vector3d normalizedPositiveY(Vector3d vector3d);

    Vector3d normalizedPositiveZ(Vector3d vector3d);

    Matrix4x3d obliqueZ(double d2, double d3, Matrix4x3d matrix4x3d);

    Vector3d origin(Vector3d vector3d);

    Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4x3d matrix4x3d);

    Matrix4x3d ortho2D(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d ortho2DLH(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z, Matrix4x3d matrix4x3d);

    Matrix4x3d pick(double d2, double d3, double d4, double d5, int[] iArr, Matrix4x3d matrix4x3d);

    Vector3d positiveX(Vector3d vector3d);

    Vector3d positiveY(Vector3d vector3d);

    Vector3d positiveZ(Vector3d vector3d);

    int properties();

    Matrix4x3d reflect(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d reflect(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d reflect(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(double d2, Vector3dc vector3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(double d2, Vector3fc vector3fc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(AxisAngle4d axisAngle4d, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(AxisAngle4f axisAngle4f, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotate(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateLocal(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateLocal(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateLocal(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateTranslation(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateTranslation(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateTranslation(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateX(double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateXYZ(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateY(double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateYXZ(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateZ(double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d rotateZYX(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d scale(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d scale(double d2, Matrix4x3d matrix4x3d);

    Matrix4x3d scale(Vector3dc vector3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d scaleLocal(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Matrix4x3d matrix4x3d);

    Matrix4x3d shadow(double d2, double d3, double d4, double d5, Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d);

    Matrix4x3d shadow(Vector4dc vector4dc, Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d sub(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d sub(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d);

    Vector4d transform(Vector4d vector4d);

    Vector4d transform(Vector4dc vector4dc, Vector4d vector4d);

    Matrix4x3d transformAab(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d, Vector3d vector3d2);

    Matrix4x3d transformAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d, Vector3d vector3d2);

    Vector3d transformDirection(Vector3d vector3d);

    Vector3d transformDirection(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d transformPosition(Vector3d vector3d);

    Vector3d transformPosition(Vector3dc vector3dc, Vector3d vector3d);

    Matrix4x3d translate(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d translate(Vector3dc vector3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d translate(Vector3fc vector3fc, Matrix4x3d matrix4x3d);

    Matrix4x3d translateLocal(double d2, double d3, double d4, Matrix4x3d matrix4x3d);

    Matrix4x3d translateLocal(Vector3dc vector3dc, Matrix4x3d matrix4x3d);

    Matrix4x3d translateLocal(Vector3fc vector3fc, Matrix4x3d matrix4x3d);

    Matrix3d transpose3x3(Matrix3d matrix3d);

    Matrix4x3d transpose3x3(Matrix4x3d matrix4x3d);
}
