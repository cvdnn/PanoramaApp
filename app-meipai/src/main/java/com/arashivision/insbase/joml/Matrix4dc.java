package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public interface Matrix4dc {
    public static final int CORNER_NXNYNZ = 0;
    public static final int CORNER_NXNYPZ = 5;
    public static final int CORNER_NXPYNZ = 3;
    public static final int CORNER_NXPYPZ = 6;
    public static final int CORNER_PXNYNZ = 1;
    public static final int CORNER_PXNYPZ = 4;
    public static final int CORNER_PXPYNZ = 2;
    public static final int CORNER_PXPYPZ = 7;
    public static final int PLANE_NX = 0;
    public static final int PLANE_NY = 2;
    public static final int PLANE_NZ = 4;
    public static final int PLANE_PX = 1;
    public static final int PLANE_PY = 3;
    public static final int PLANE_PZ = 5;
    public static final byte PROPERTY_AFFINE = 2;
    public static final byte PROPERTY_IDENTITY = 4;
    public static final byte PROPERTY_ORTHONORMAL = 16;
    public static final byte PROPERTY_PERSPECTIVE = 1;
    public static final byte PROPERTY_TRANSLATION = 8;

    Matrix4d add(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d add4x3(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d add4x3(Matrix4fc matrix4fc, Matrix4d matrix4d);

    Matrix4d arcball(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d arcball(double d2, Vector3dc vector3dc, double d3, double d4, Matrix4d matrix4d);

    double determinant();

    double determinant3x3();

    double determinantAffine();

    boolean equals(Matrix4dc matrix4dc, double d2);

    Matrix4d fma4x3(Matrix4dc matrix4dc, double d2, Matrix4d matrix4d);

    Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d);

    Vector3d frustumCorner(int i2, Vector3d vector3d);

    Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d);

    Planed frustumPlane(int i2, Planed planed);

    Vector4d frustumPlane(int i2, Vector4d vector4d);

    Vector3d frustumRayDir(double d2, double d3, Vector3d vector3d);

    Matrix4d get(Matrix4d matrix4d);

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

    Matrix3d get3x3(Matrix3d matrix3d);

    Matrix4x3d get4x3(Matrix4x3d matrix4x3d);

    ByteBuffer get4x3Transposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x3Transposed(ByteBuffer byteBuffer);

    DoubleBuffer get4x3Transposed(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get4x3Transposed(DoubleBuffer doubleBuffer);

    Vector3d getColumn(int i2, Vector3d vector3d) throws IndexOutOfBoundsException;

    Vector4d getColumn(int i2, Vector4d vector4d) throws IndexOutOfBoundsException;

    Vector3d getEulerAnglesZYX(Vector3d vector3d);

    ByteBuffer getFloats(int i2, ByteBuffer byteBuffer);

    ByteBuffer getFloats(ByteBuffer byteBuffer);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    Vector3d getRow(int i2, Vector3d vector3d) throws IndexOutOfBoundsException;

    Vector4d getRow(int i2, Vector4d vector4d) throws IndexOutOfBoundsException;

    Vector3d getScale(Vector3d vector3d);

    Vector3d getTranslation(Vector3d vector3d);

    ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposed(ByteBuffer byteBuffer);

    DoubleBuffer getTransposed(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer getTransposed(DoubleBuffer doubleBuffer);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix4d invert(Matrix4d matrix4d);

    Matrix4d invertAffine(Matrix4d matrix4d);

    Matrix4d invertFrustum(Matrix4d matrix4d);

    Matrix4d invertOrtho(Matrix4d matrix4d);

    Matrix4d invertPerspective(Matrix4d matrix4d);

    Matrix4d invertPerspectiveView(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d invertPerspectiveView(Matrix4x3dc matrix4x3dc, Matrix4d matrix4d);

    boolean isAffine();

    Matrix4d lerp(Matrix4dc matrix4dc, double d2, Matrix4d matrix4d);

    Matrix4d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d);

    Matrix4d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d);

    Matrix4d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4d matrix4d);

    Matrix4d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d);

    Matrix4d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4d matrix4d);

    Matrix4d lookAtPerspective(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d);

    Matrix4d lookAtPerspectiveLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d);

    double m00();

    double m01();

    double m02();

    double m03();

    double m10();

    double m11();

    double m12();

    double m13();

    double m20();

    double m21();

    double m22();

    double m23();

    double m30();

    double m31();

    double m32();

    double m33();

    Matrix4d mul(Matrix3x2dc matrix3x2dc, Matrix4d matrix4d);

    Matrix4d mul(Matrix3x2fc matrix3x2fc, Matrix4d matrix4d);

    Matrix4d mul(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mul(Matrix4fc matrix4fc, Matrix4d matrix4d);

    Matrix4d mul(Matrix4x3dc matrix4x3dc, Matrix4d matrix4d);

    Matrix4d mul(Matrix4x3fc matrix4x3fc, Matrix4d matrix4d);

    Matrix4d mul4x3ComponentWise(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulAffine(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulAffineR(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulComponentWise(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulLocal(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulLocalAffine(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulOrthoAffine(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulPerspectiveAffine(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d mulTranslationAffine(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix3d normal(Matrix3d matrix3d);

    Matrix4d normal(Matrix4d matrix4d);

    Matrix3d normalize3x3(Matrix3d matrix3d);

    Matrix4d normalize3x3(Matrix4d matrix4d);

    Vector3d normalizedPositiveX(Vector3d vector3d);

    Vector3d normalizedPositiveY(Vector3d vector3d);

    Vector3d normalizedPositiveZ(Vector3d vector3d);

    Matrix4d obliqueZ(double d2, double d3, Matrix4d matrix4d);

    Vector3d origin(Vector3d vector3d);

    Vector3d originAffine(Vector3d vector3d);

    Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d);

    Matrix4d ortho2D(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d ortho2DLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d orthoCrop(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d);

    Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d);

    Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d);

    Matrix4d perspective(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d perspective(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d);

    double perspectiveFar();

    double perspectiveFov();

    Matrix4d perspectiveFrustumSlice(double d2, double d3, Matrix4d matrix4d);

    Matrix4d perspectiveLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d perspectiveLH(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d);

    double perspectiveNear();

    Vector3d perspectiveOrigin(Vector3d vector3d);

    Matrix4d pick(double d2, double d3, double d4, double d5, int[] iArr, Matrix4d matrix4d);

    Vector3d positiveX(Vector3d vector3d);

    Vector3d positiveY(Vector3d vector3d);

    Vector3d positiveZ(Vector3d vector3d);

    Vector3d project(double d2, double d3, double d4, int[] iArr, Vector3d vector3d);

    Vector3d project(Vector3dc vector3dc, int[] iArr, Vector3d vector3d);

    Vector4d project(double d2, double d3, double d4, int[] iArr, Vector4d vector4d);

    Vector4d project(Vector3dc vector3dc, int[] iArr, Vector4d vector4d);

    Matrix4d projectedGridRange(Matrix4dc matrix4dc, double d2, double d3, Matrix4d matrix4d);

    int properties();

    Matrix4d reflect(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d reflect(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc, Matrix4d matrix4d);

    Matrix4d reflect(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d);

    Matrix4d rotate(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d rotate(double d2, Vector3dc vector3dc, Matrix4d matrix4d);

    Matrix4d rotate(double d2, Vector3fc vector3fc, Matrix4d matrix4d);

    Matrix4d rotate(AxisAngle4d axisAngle4d, Matrix4d matrix4d);

    Matrix4d rotate(AxisAngle4f axisAngle4f, Matrix4d matrix4d);

    Matrix4d rotate(Quaterniondc quaterniondc, Matrix4d matrix4d);

    Matrix4d rotate(Quaternionfc quaternionfc, Matrix4d matrix4d);

    Matrix4d rotateAffine(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d rotateAffine(Quaterniondc quaterniondc, Matrix4d matrix4d);

    Matrix4d rotateAffine(Quaternionfc quaternionfc, Matrix4d matrix4d);

    Matrix4d rotateAffineXYZ(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateAffineYXZ(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateAffineZYX(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateAroundAffine(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateAroundLocal(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateLocal(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d rotateLocal(Quaterniondc quaterniondc, Matrix4d matrix4d);

    Matrix4d rotateLocal(Quaternionfc quaternionfc, Matrix4d matrix4d);

    Matrix4d rotateLocalX(double d2, Matrix4d matrix4d);

    Matrix4d rotateLocalY(double d2, Matrix4d matrix4d);

    Matrix4d rotateLocalZ(double d2, Matrix4d matrix4d);

    Matrix4d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d);

    Matrix4d rotateTowardsXY(double d2, double d3, Matrix4d matrix4d);

    Matrix4d rotateTranslation(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d rotateTranslation(Quaterniondc quaterniondc, Matrix4d matrix4d);

    Matrix4d rotateTranslation(Quaternionfc quaternionfc, Matrix4d matrix4d);

    Matrix4d rotateX(double d2, Matrix4d matrix4d);

    Matrix4d rotateXYZ(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateY(double d2, Matrix4d matrix4d);

    Matrix4d rotateYXZ(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d rotateZ(double d2, Matrix4d matrix4d);

    Matrix4d rotateZYX(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d scale(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d scale(double d2, Matrix4d matrix4d);

    Matrix4d scale(Vector3dc vector3dc, Matrix4d matrix4d);

    Matrix4d scaleAround(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d scaleAround(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d);

    Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d scaleLocal(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d scaleLocal(double d2, Matrix4d matrix4d);

    Matrix4d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Matrix4d matrix4d);

    Matrix4d shadow(double d2, double d3, double d4, double d5, Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5, Matrix4d matrix4d);

    Matrix4d shadow(Vector4dc vector4dc, Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d sub(Matrix4dc matrix4dc, Matrix4d matrix4d);

    Matrix4d sub4x3(Matrix4dc matrix4dc, Matrix4d matrix4d);

    boolean testAab(double d2, double d3, double d4, double d5, double d6, double d7);

    boolean testPoint(double d2, double d3, double d4);

    boolean testSphere(double d2, double d3, double d4, double d5);

    Vector4d transform(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d transform(Vector4d vector4d);

    Vector4d transform(Vector4dc vector4dc, Vector4d vector4d);

    Matrix4d transformAab(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d, Vector3d vector3d2);

    Matrix4d transformAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d, Vector3d vector3d2);

    Vector4d transformAffine(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d transformAffine(Vector4d vector4d);

    Vector4d transformAffine(Vector4dc vector4dc, Vector4d vector4d);

    Vector3d transformDirection(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transformDirection(Vector3d vector3d);

    Vector3d transformDirection(Vector3dc vector3dc, Vector3d vector3d);

    Vector3f transformDirection(Vector3f vector3f);

    Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f);

    Vector3d transformPosition(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transformPosition(Vector3d vector3d);

    Vector3d transformPosition(Vector3dc vector3dc, Vector3d vector3d);

    Vector3d transformProject(double d2, double d3, double d4, Vector3d vector3d);

    Vector3d transformProject(Vector3d vector3d);

    Vector3d transformProject(Vector3dc vector3dc, Vector3d vector3d);

    Vector4d transformProject(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d transformProject(Vector4d vector4d);

    Vector4d transformProject(Vector4dc vector4dc, Vector4d vector4d);

    Matrix4d translate(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d translate(Vector3dc vector3dc, Matrix4d matrix4d);

    Matrix4d translate(Vector3fc vector3fc, Matrix4d matrix4d);

    Matrix4d translateLocal(double d2, double d3, double d4, Matrix4d matrix4d);

    Matrix4d translateLocal(Vector3dc vector3dc, Matrix4d matrix4d);

    Matrix4d translateLocal(Vector3fc vector3fc, Matrix4d matrix4d);

    Matrix4d transpose(Matrix4d matrix4d);

    Matrix3d transpose3x3(Matrix3d matrix3d);

    Matrix4d transpose3x3(Matrix4d matrix4d);

    Vector3d unproject(double d2, double d3, double d4, int[] iArr, Vector3d vector3d);

    Vector3d unproject(Vector3dc vector3dc, int[] iArr, Vector3d vector3d);

    Vector4d unproject(double d2, double d3, double d4, int[] iArr, Vector4d vector4d);

    Vector4d unproject(Vector3dc vector3dc, int[] iArr, Vector4d vector4d);

    Vector3d unprojectInv(double d2, double d3, double d4, int[] iArr, Vector3d vector3d);

    Vector3d unprojectInv(Vector3dc vector3dc, int[] iArr, Vector3d vector3d);

    Vector4d unprojectInv(double d2, double d3, double d4, int[] iArr, Vector4d vector4d);

    Vector4d unprojectInv(Vector3dc vector3dc, int[] iArr, Vector4d vector4d);

    Matrix4d unprojectInvRay(double d2, double d3, int[] iArr, Vector3d vector3d, Vector3d vector3d2);

    Matrix4d unprojectInvRay(Vector2dc vector2dc, int[] iArr, Vector3d vector3d, Vector3d vector3d2);

    Matrix4d unprojectRay(double d2, double d3, int[] iArr, Vector3d vector3d, Vector3d vector3d2);

    Matrix4d unprojectRay(Vector2dc vector2dc, int[] iArr, Vector3d vector3d, Vector3d vector3d2);
}
