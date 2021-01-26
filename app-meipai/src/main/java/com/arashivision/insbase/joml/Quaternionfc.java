package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Quaternionfc {
    Quaternionf add(float f2, float f3, float f4, float f5, Quaternionf quaternionf);

    Quaternionf add(Quaternionfc quaternionfc, Quaternionf quaternionf);

    float angle();

    Quaternionf conjugate(Quaternionf quaternionf);

    Quaternionf difference(Quaternionf quaternionf, Quaternionf quaternionf2);

    Quaternionf div(Quaternionfc quaternionfc, Quaternionf quaternionf);

    AxisAngle4f get(AxisAngle4f axisAngle4f);

    Matrix3d get(Matrix3d matrix3d);

    Matrix3f get(Matrix3f matrix3f);

    Matrix4d get(Matrix4d matrix4d);

    Matrix4f get(Matrix4f matrix4f);

    Matrix4x3d get(Matrix4x3d matrix4x3d);

    Matrix4x3f get(Matrix4x3f matrix4x3f);

    Quaterniond get(Quaterniond quaterniond);

    Quaternionf get(Quaternionf quaternionf);

    ByteBuffer getAsMatrix3f(ByteBuffer byteBuffer);

    FloatBuffer getAsMatrix3f(FloatBuffer floatBuffer);

    ByteBuffer getAsMatrix4f(ByteBuffer byteBuffer);

    FloatBuffer getAsMatrix4f(FloatBuffer floatBuffer);

    ByteBuffer getAsMatrix4x3f(ByteBuffer byteBuffer);

    FloatBuffer getAsMatrix4x3f(FloatBuffer floatBuffer);

    Vector3f getEulerAnglesXYZ(Vector3f vector3f);

    Quaternionf integrate(float f2, float f3, float f4, float f5, Quaternionf quaternionf);

    Quaternionf invert(Quaternionf quaternionf);

    float lengthSquared();

    Quaternionf lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Quaternionf quaternionf);

    Quaternionf lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Quaternionf quaternionf);

    Quaternionf mul(float f2, float f3, float f4, float f5, Quaternionf quaternionf);

    Quaternionf mul(Quaternionfc quaternionfc, Quaternionf quaternionf);

    Quaternionf nlerp(Quaternionfc quaternionfc, float f2, Quaternionf quaternionf);

    Quaternionf nlerpIterative(Quaternionfc quaternionfc, float f2, float f3, Quaternionf quaternionf);

    Quaternionf normalize(Quaternionf quaternionf);

    Vector3f normalizedPositiveX(Vector3f vector3f);

    Vector3f normalizedPositiveY(Vector3f vector3f);

    Vector3f normalizedPositiveZ(Vector3f vector3f);

    Vector3f positiveX(Vector3f vector3f);

    Vector3f positiveY(Vector3f vector3f);

    Vector3f positiveZ(Vector3f vector3f);

    Quaternionf premul(float f2, float f3, float f4, float f5, Quaternionf quaternionf);

    Quaternionf premul(Quaternionfc quaternionfc, Quaternionf quaternionf);

    Quaternionf rotateAxis(float f2, float f3, float f4, float f5, Quaternionf quaternionf);

    Quaternionf rotateAxis(float f2, Vector3fc vector3fc, Quaternionf quaternionf);

    Quaternionf rotateLocalX(float f2, Quaternionf quaternionf);

    Quaternionf rotateLocalY(float f2, Quaternionf quaternionf);

    Quaternionf rotateLocalZ(float f2, Quaternionf quaternionf);

    Quaternionf rotateTo(float f2, float f3, float f4, float f5, float f6, float f7, Quaternionf quaternionf);

    Quaternionf rotateTo(Vector3fc vector3fc, Vector3fc vector3fc2, Quaternionf quaternionf);

    Quaternionf rotateX(float f2, Quaternionf quaternionf);

    Quaternionf rotateXYZ(float f2, float f3, float f4, Quaternionf quaternionf);

    Quaternionf rotateY(float f2, Quaternionf quaternionf);

    Quaternionf rotateYXZ(float f2, float f3, float f4, Quaternionf quaternionf);

    Quaternionf rotateZ(float f2, Quaternionf quaternionf);

    Quaternionf rotateZYX(float f2, float f3, float f4, Quaternionf quaternionf);

    Quaternionf scale(float f2, Quaternionf quaternionf);

    Quaternionf slerp(Quaternionfc quaternionfc, float f2, Quaternionf quaternionf);

    Vector3f transform(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transform(Vector3f vector3f);

    Vector3f transform(Vector3fc vector3fc, Vector3f vector3f);

    Vector4f transform(float f2, float f3, float f4, Vector4f vector4f);

    Vector4f transform(Vector4f vector4f);

    Vector4f transform(Vector4fc vector4fc, Vector4f vector4f);

    Vector3f transformPositiveX(Vector3f vector3f);

    Vector4f transformPositiveX(Vector4f vector4f);

    Vector3f transformPositiveY(Vector3f vector3f);

    Vector4f transformPositiveY(Vector4f vector4f);

    Vector3f transformPositiveZ(Vector3f vector3f);

    Vector4f transformPositiveZ(Vector4f vector4f);

    Vector3f transformUnitPositiveX(Vector3f vector3f);

    Vector4f transformUnitPositiveX(Vector4f vector4f);

    Vector3f transformUnitPositiveY(Vector3f vector3f);

    Vector4f transformUnitPositiveY(Vector4f vector4f);

    Vector3f transformUnitPositiveZ(Vector3f vector3f);

    Vector4f transformUnitPositiveZ(Vector4f vector4f);

    float w();

    float x();

    float y();

    float z();
}
