package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Matrix4fc {
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

    Matrix4f add(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f add4x3(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f arcball(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f arcball(float f2, Vector3fc vector3fc, float f3, float f4, Matrix4f matrix4f);

    float determinant();

    float determinant3x3();

    float determinantAffine();

    boolean equals(Matrix4fc matrix4fc, float f2);

    Matrix4f fma4x3(Matrix4fc matrix4fc, float f2, Matrix4f matrix4f);

    Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f);

    Matrix4f frustumAabb(Vector3f vector3f, Vector3f vector3f2);

    Vector3f frustumCorner(int i2, Vector3f vector3f);

    Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f);

    Planef frustumPlane(int i2, Planef planef);

    Vector4f frustumPlane(int i2, Vector4f vector4f);

    Vector3f frustumRayDir(float f2, float f3, Vector3f vector3f);

    Matrix4d get(Matrix4d matrix4d);

    Matrix4f get(Matrix4f matrix4f);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    float[] get(float[] fArr);

    float[] get(float[] fArr, int i2);

    Matrix3d get3x3(Matrix3d matrix3d);

    Matrix3f get3x3(Matrix3f matrix3f);

    Matrix4x3f get4x3(Matrix4x3f matrix4x3f);

    ByteBuffer get4x3(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x3(ByteBuffer byteBuffer);

    FloatBuffer get4x3(int i2, FloatBuffer floatBuffer);

    FloatBuffer get4x3(FloatBuffer floatBuffer);

    ByteBuffer get4x3Transposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x3Transposed(ByteBuffer byteBuffer);

    FloatBuffer get4x3Transposed(int i2, FloatBuffer floatBuffer);

    FloatBuffer get4x3Transposed(FloatBuffer floatBuffer);

    Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException;

    Vector4f getColumn(int i2, Vector4f vector4f) throws IndexOutOfBoundsException;

    Vector3f getEulerAnglesZYX(Vector3f vector3f);

    Quaterniond getNormalizedRotation(Quaterniond quaterniond);

    Quaternionf getNormalizedRotation(Quaternionf quaternionf);

    AxisAngle4d getRotation(AxisAngle4d axisAngle4d);

    AxisAngle4f getRotation(AxisAngle4f axisAngle4f);

    Vector3f getRow(int i2, Vector3f vector3f) throws IndexOutOfBoundsException;

    Vector4f getRow(int i2, Vector4f vector4f) throws IndexOutOfBoundsException;

    Vector3f getScale(Vector3f vector3f);

    Vector3f getTranslation(Vector3f vector3f);

    ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer);

    ByteBuffer getTransposed(ByteBuffer byteBuffer);

    FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer);

    FloatBuffer getTransposed(FloatBuffer floatBuffer);

    Quaterniond getUnnormalizedRotation(Quaterniond quaterniond);

    Quaternionf getUnnormalizedRotation(Quaternionf quaternionf);

    Matrix4f invert(Matrix4f matrix4f);

    Matrix4f invertAffine(Matrix4f matrix4f);

    Matrix4f invertFrustum(Matrix4f matrix4f);

    Matrix4f invertOrtho(Matrix4f matrix4f);

    Matrix4f invertPerspective(Matrix4f matrix4f);

    Matrix4f invertPerspectiveView(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f invertPerspectiveView(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f);

    boolean isAffine();

    Matrix4f lerp(Matrix4fc matrix4fc, float f2, Matrix4f matrix4f);

    Matrix4f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f);

    Matrix4f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f);

    Matrix4f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4f matrix4f);

    Matrix4f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f);

    Matrix4f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4f matrix4f);

    Matrix4f lookAtPerspective(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f);

    Matrix4f lookAtPerspectiveLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f);

    float m00();

    float m01();

    float m02();

    float m03();

    float m10();

    float m11();

    float m12();

    float m13();

    float m20();

    float m21();

    float m22();

    float m23();

    float m30();

    float m31();

    float m32();

    float m33();

    Matrix4f mul(Matrix3x2fc matrix3x2fc, Matrix4f matrix4f);

    Matrix4f mul(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mul(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f);

    Matrix4f mul4x3ComponentWise(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulAffine(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulAffineR(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulComponentWise(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulLocal(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulLocalAffine(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulOrthoAffine(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulPerspectiveAffine(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f mulPerspectiveAffine(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f);

    Matrix4f mulTranslationAffine(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix3f normal(Matrix3f matrix3f);

    Matrix4f normal(Matrix4f matrix4f);

    Matrix3f normalize3x3(Matrix3f matrix3f);

    Matrix4f normalize3x3(Matrix4f matrix4f);

    Vector3f normalizedPositiveX(Vector3f vector3f);

    Vector3f normalizedPositiveY(Vector3f vector3f);

    Vector3f normalizedPositiveZ(Vector3f vector3f);

    Matrix4f obliqueZ(float f2, float f3, Matrix4f matrix4f);

    Vector3f origin(Vector3f vector3f);

    Vector3f originAffine(Vector3f vector3f);

    Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f);

    Matrix4f ortho2D(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f ortho2DLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f orthoCrop(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f);

    Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f);

    Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f);

    Matrix4f perspective(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f perspective(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f);

    float perspectiveFar();

    float perspectiveFov();

    Matrix4f perspectiveFrustumSlice(float f2, float f3, Matrix4f matrix4f);

    Matrix4f perspectiveLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f perspectiveLH(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f);

    float perspectiveNear();

    Vector3f perspectiveOrigin(Vector3f vector3f);

    Matrix4f pick(float f2, float f3, float f4, float f5, int[] iArr, Matrix4f matrix4f);

    Vector3f positiveX(Vector3f vector3f);

    Vector3f positiveY(Vector3f vector3f);

    Vector3f positiveZ(Vector3f vector3f);

    Vector3f project(float f2, float f3, float f4, int[] iArr, Vector3f vector3f);

    Vector3f project(Vector3fc vector3fc, int[] iArr, Vector3f vector3f);

    Vector4f project(float f2, float f3, float f4, int[] iArr, Vector4f vector4f);

    Vector4f project(Vector3fc vector3fc, int[] iArr, Vector4f vector4f);

    Matrix4f projectedGridRange(Matrix4fc matrix4fc, float f2, float f3, Matrix4f matrix4f);

    int properties();

    Matrix4f reflect(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f reflect(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc, Matrix4f matrix4f);

    Matrix4f reflect(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f);

    Matrix4f rotate(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f rotate(float f2, Vector3fc vector3fc, Matrix4f matrix4f);

    Matrix4f rotate(AxisAngle4f axisAngle4f, Matrix4f matrix4f);

    Matrix4f rotate(Quaternionfc quaternionfc, Matrix4f matrix4f);

    Matrix4f rotateAffine(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f rotateAffine(Quaternionfc quaternionfc, Matrix4f matrix4f);

    Matrix4f rotateAffineXYZ(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateAffineYXZ(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateAffineZYX(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateAroundAffine(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateAroundLocal(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateLocal(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f rotateLocal(Quaternionfc quaternionfc, Matrix4f matrix4f);

    Matrix4f rotateLocalX(float f2, Matrix4f matrix4f);

    Matrix4f rotateLocalY(float f2, Matrix4f matrix4f);

    Matrix4f rotateLocalZ(float f2, Matrix4f matrix4f);

    Matrix4f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f);

    Matrix4f rotateTowardsXY(float f2, float f3, Matrix4f matrix4f);

    Matrix4f rotateTranslation(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f rotateTranslation(Quaternionfc quaternionfc, Matrix4f matrix4f);

    Matrix4f rotateX(float f2, Matrix4f matrix4f);

    Matrix4f rotateXYZ(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateY(float f2, Matrix4f matrix4f);

    Matrix4f rotateYXZ(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f rotateZ(float f2, Matrix4f matrix4f);

    Matrix4f rotateZYX(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f scale(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f scale(float f2, Matrix4f matrix4f);

    Matrix4f scale(Vector3fc vector3fc, Matrix4f matrix4f);

    Matrix4f scaleAround(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f scaleAround(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f);

    Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f scaleLocal(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f scaleLocal(float f2, Matrix4f matrix4f);

    Matrix4f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Matrix4f matrix4f);

    Matrix4f shadow(float f2, float f3, float f4, float f5, Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f shadow(Vector4f vector4f, float f2, float f3, float f4, float f5, Matrix4f matrix4f);

    Matrix4f shadow(Vector4f vector4f, Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f sub(Matrix4fc matrix4fc, Matrix4f matrix4f);

    Matrix4f sub4x3(Matrix4fc matrix4fc, Matrix4f matrix4f);

    boolean testAab(float f2, float f3, float f4, float f5, float f6, float f7);

    boolean testPoint(float f2, float f3, float f4);

    boolean testSphere(float f2, float f3, float f4, float f5);

    Vector4f transform(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f transform(Vector4f vector4f);

    Vector4f transform(Vector4fc vector4fc, Vector4f vector4f);

    Matrix4f transformAab(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f, Vector3f vector3f2);

    Matrix4f transformAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f, Vector3f vector3f2);

    Vector4f transformAffine(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f transformAffine(Vector4f vector4f);

    Vector4f transformAffine(Vector4fc vector4fc, Vector4f vector4f);

    Vector3f transformDirection(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transformDirection(Vector3f vector3f);

    Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f transformPosition(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transformPosition(Vector3f vector3f);

    Vector3f transformPosition(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f transformProject(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transformProject(Vector3f vector3f);

    Vector3f transformProject(Vector3fc vector3fc, Vector3f vector3f);

    Vector4f transformProject(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f transformProject(Vector4f vector4f);

    Vector4f transformProject(Vector4fc vector4fc, Vector4f vector4f);

    Matrix4f translate(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f translate(Vector3fc vector3fc, Matrix4f matrix4f);

    Matrix4f translateLocal(float f2, float f3, float f4, Matrix4f matrix4f);

    Matrix4f translateLocal(Vector3fc vector3fc, Matrix4f matrix4f);

    Matrix4f transpose(Matrix4f matrix4f);

    Matrix3f transpose3x3(Matrix3f matrix3f);

    Matrix4f transpose3x3(Matrix4f matrix4f);

    Vector3f unproject(float f2, float f3, float f4, int[] iArr, Vector3f vector3f);

    Vector3f unproject(Vector3fc vector3fc, int[] iArr, Vector3f vector3f);

    Vector4f unproject(float f2, float f3, float f4, int[] iArr, Vector4f vector4f);

    Vector4f unproject(Vector3fc vector3fc, int[] iArr, Vector4f vector4f);

    Vector3f unprojectInv(float f2, float f3, float f4, int[] iArr, Vector3f vector3f);

    Vector3f unprojectInv(Vector3fc vector3fc, int[] iArr, Vector3f vector3f);

    Vector4f unprojectInv(float f2, float f3, float f4, int[] iArr, Vector4f vector4f);

    Vector4f unprojectInv(Vector3fc vector3fc, int[] iArr, Vector4f vector4f);

    Matrix4f unprojectInvRay(float f2, float f3, int[] iArr, Vector3f vector3f, Vector3f vector3f2);

    Matrix4f unprojectInvRay(Vector2fc vector2fc, int[] iArr, Vector3f vector3f, Vector3f vector3f2);

    Matrix4f unprojectRay(float f2, float f3, int[] iArr, Vector3f vector3f, Vector3f vector3f2);

    Matrix4f unprojectRay(Vector2fc vector2fc, int[] iArr, Vector3f vector3f, Vector3f vector3f2);
}
