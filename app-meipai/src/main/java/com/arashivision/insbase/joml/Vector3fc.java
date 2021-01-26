package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Vector3fc {
    Vector3f absolute(Vector3f vector3f);

    Vector3f add(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f add(Vector3fc vector3fc, Vector3f vector3f);

    float angle(Vector3fc vector3fc);

    float angleCos(Vector3fc vector3fc);

    Vector3f ceil(Vector3f vector3f);

    Vector3f cross(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f cross(Vector3fc vector3fc, Vector3f vector3f);

    float distance(float f2, float f3, float f4);

    float distance(Vector3fc vector3fc);

    float distanceSquared(float f2, float f3, float f4);

    float distanceSquared(Vector3fc vector3fc);

    Vector3f div(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f div(float f2, Vector3f vector3f);

    Vector3f div(Vector3fc vector3fc, Vector3f vector3f);

    float dot(float f2, float f3, float f4);

    float dot(Vector3fc vector3fc);

    boolean equals(float f2, float f3, float f4);

    boolean equals(Vector3fc vector3fc, float f2);

    Vector3f floor(Vector3f vector3f);

    Vector3f fma(float f2, Vector3fc vector3fc, Vector3f vector3f);

    Vector3f fma(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f);

    float get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    Vector3f half(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f half(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f hermite(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2, Vector3f vector3f);

    boolean isFinite();

    float length();

    float lengthSquared();

    Vector3f lerp(Vector3fc vector3fc, float f2, Vector3f vector3f);

    Vector3f max(Vector3fc vector3fc, Vector3f vector3f);

    int maxComponent();

    Vector3f min(Vector3fc vector3fc, Vector3f vector3f);

    int minComponent();

    Vector3f mul(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f mul(float f2, Vector3f vector3f);

    Vector3f mul(Matrix3dc matrix3dc, Vector3f vector3f);

    Vector3f mul(Matrix3fc matrix3fc, Vector3f vector3f);

    Vector3f mul(Matrix3x2fc matrix3x2fc, Vector3f vector3f);

    Vector3f mul(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f mulDirection(Matrix4dc matrix4dc, Vector3f vector3f);

    Vector3f mulDirection(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f mulDirection(Matrix4x3fc matrix4x3fc, Vector3f vector3f);

    Vector3f mulPosition(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f mulPosition(Matrix4x3fc matrix4x3fc, Vector3f vector3f);

    float mulPositionW(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f mulProject(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f mulTranspose(Matrix3fc matrix3fc, Vector3f vector3f);

    Vector3f mulTransposeDirection(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f mulTransposePosition(Matrix4fc matrix4fc, Vector3f vector3f);

    Vector3f negate(Vector3f vector3f);

    Vector3f normalize(float f2, Vector3f vector3f);

    Vector3f normalize(Vector3f vector3f);

    Vector3f orthogonalize(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f orthogonalizeUnit(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f reflect(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f reflect(Vector3fc vector3fc, Vector3f vector3f);

    Vector3f rotate(Quaternionfc quaternionfc, Vector3f vector3f);

    Vector3f rotateAxis(float f2, float f3, float f4, float f5, Vector3f vector3f);

    Vector3f rotateX(float f2, Vector3f vector3f);

    Vector3f rotateY(float f2, Vector3f vector3f);

    Vector3f rotateZ(float f2, Vector3f vector3f);

    Quaternionf rotationTo(float f2, float f3, float f4, Quaternionf quaternionf);

    Quaternionf rotationTo(Vector3fc vector3fc, Quaternionf quaternionf);

    Vector3f round(Vector3f vector3f);

    Vector3f smoothStep(Vector3fc vector3fc, float f2, Vector3f vector3f);

    Vector3f sub(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f sub(Vector3fc vector3fc, Vector3f vector3f);

    float x();

    float y();

    float z();
}
