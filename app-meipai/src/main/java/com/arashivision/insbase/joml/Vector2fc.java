package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Vector2fc {
    Vector2f add(float f2, float f3, Vector2f vector2f);

    Vector2f add(Vector2fc vector2fc, Vector2f vector2f);

    float angle(Vector2fc vector2fc);

    Vector2f ceil(Vector2f vector2f);

    float distance(float f2, float f3);

    float distance(Vector2fc vector2fc);

    float distanceSquared(float f2, float f3);

    float distanceSquared(Vector2fc vector2fc);

    float dot(Vector2fc vector2fc);

    boolean equals(float f2, float f3);

    boolean equals(Vector2fc vector2fc, float f2);

    Vector2f floor(Vector2f vector2f);

    Vector2f fma(float f2, Vector2fc vector2fc, Vector2f vector2f);

    Vector2f fma(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2f vector2f);

    float get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    boolean isFinite();

    float length();

    float lengthSquared();

    Vector2f lerp(Vector2fc vector2fc, float f2, Vector2f vector2f);

    Vector2f max(Vector2fc vector2fc, Vector2f vector2f);

    int maxComponent();

    Vector2f min(Vector2fc vector2fc, Vector2f vector2f);

    int minComponent();

    Vector2f mul(float f2, float f3, Vector2f vector2f);

    Vector2f mul(float f2, Vector2f vector2f);

    Vector2f mul(Vector2fc vector2fc, Vector2f vector2f);

    Vector2f mulDirection(Matrix3x2fc matrix3x2fc, Vector2f vector2f);

    Vector2f mulPosition(Matrix3x2fc matrix3x2fc, Vector2f vector2f);

    Vector2f negate(Vector2f vector2f);

    Vector2f normalize(float f2, Vector2f vector2f);

    Vector2f normalize(Vector2f vector2f);

    Vector2f round(Vector2f vector2f);

    Vector2f sub(float f2, float f3, Vector2f vector2f);

    Vector2f sub(Vector2fc vector2fc, Vector2f vector2f);

    float x();

    float y();
}
