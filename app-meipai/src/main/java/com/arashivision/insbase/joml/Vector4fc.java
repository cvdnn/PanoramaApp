package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Vector4fc {
    Vector4f add(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f add(Vector4fc vector4fc, Vector4f vector4f);

    float angle(Vector4fc vector4fc);

    float angleCos(Vector4fc vector4fc);

    Vector4f ceil(Vector4f vector4f);

    float distance(float f2, float f3, float f4, float f5);

    float distance(Vector4fc vector4fc);

    float distanceSquared(float f2, float f3, float f4, float f5);

    float distanceSquared(Vector4fc vector4fc);

    Vector4f div(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f div(float f2, Vector4f vector4f);

    Vector4f div(Vector4fc vector4fc, Vector4f vector4f);

    float dot(float f2, float f3, float f4, float f5);

    float dot(Vector4fc vector4fc);

    boolean equals(float f2, float f3, float f4, float f5);

    boolean equals(Vector4fc vector4fc, float f2);

    Vector4f floor(Vector4f vector4f);

    Vector4f fma(float f2, Vector4fc vector4fc, Vector4f vector4f);

    Vector4f fma(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4f vector4f);

    float get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    Vector4f hermite(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4fc vector4fc3, float f2, Vector4f vector4f);

    boolean isFinite();

    float length();

    float lengthSquared();

    Vector4f lerp(Vector4fc vector4fc, float f2, Vector4f vector4f);

    Vector4f max(Vector4fc vector4fc, Vector4f vector4f);

    int maxComponent();

    Vector4f min(Vector4fc vector4fc, Vector4f vector4f);

    int minComponent();

    Vector4f mul(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f mul(float f2, Vector4f vector4f);

    Vector4f mul(Matrix4fc matrix4fc, Vector4f vector4f);

    Vector4f mul(Matrix4x3fc matrix4x3fc, Vector4f vector4f);

    Vector4f mul(Vector4fc vector4fc, Vector4f vector4f);

    Vector4f mulAffine(Matrix4fc matrix4fc, Vector4f vector4f);

    Vector4f mulProject(Matrix4fc matrix4fc, Vector4f vector4f);

    Vector4f negate(Vector4f vector4f);

    Vector4f normalize(float f2, Vector4f vector4f);

    Vector4f normalize(Vector4f vector4f);

    Vector4f rotate(Quaternionfc quaternionfc, Vector4f vector4f);

    Vector4f rotateAxis(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f rotateX(float f2, Vector4f vector4f);

    Vector4f rotateY(float f2, Vector4f vector4f);

    Vector4f rotateZ(float f2, Vector4f vector4f);

    Vector4f round(Vector4f vector4f);

    Vector4f smoothStep(Vector4fc vector4fc, float f2, Vector4f vector4f);

    Vector4f sub(float f2, float f3, float f4, float f5, Vector4f vector4f);

    Vector4f sub(Vector4fc vector4fc, Vector4f vector4f);

    float w();

    float x();

    float y();

    float z();
}
