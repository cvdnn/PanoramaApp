package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public interface Matrix3x2fc {
    float determinant();

    boolean equals(Matrix3x2fc matrix3x2fc, float f2);

    Matrix3x2f get(Matrix3x2f matrix3x2f);

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    FloatBuffer get(int i2, FloatBuffer floatBuffer);

    FloatBuffer get(FloatBuffer floatBuffer);

    float[] get(float[] fArr);

    float[] get(float[] fArr, int i2);

    ByteBuffer get3x3(int i2, ByteBuffer byteBuffer);

    ByteBuffer get3x3(ByteBuffer byteBuffer);

    FloatBuffer get3x3(int i2, FloatBuffer floatBuffer);

    FloatBuffer get3x3(FloatBuffer floatBuffer);

    float[] get3x3(float[] fArr);

    float[] get3x3(float[] fArr, int i2);

    ByteBuffer get4x4(int i2, ByteBuffer byteBuffer);

    ByteBuffer get4x4(ByteBuffer byteBuffer);

    FloatBuffer get4x4(int i2, FloatBuffer floatBuffer);

    FloatBuffer get4x4(FloatBuffer floatBuffer);

    float[] get4x4(float[] fArr);

    float[] get4x4(float[] fArr, int i2);

    Matrix3x2f invert(Matrix3x2f matrix3x2f);

    float m00();

    float m01();

    float m10();

    float m11();

    float m20();

    float m21();

    Matrix3x2f mul(Matrix3x2fc matrix3x2fc, Matrix3x2f matrix3x2f);

    Matrix3x2f mulLocal(Matrix3x2fc matrix3x2fc, Matrix3x2f matrix3x2f);

    Vector2f normalizedPositiveX(Vector2f vector2f);

    Vector2f normalizedPositiveY(Vector2f vector2f);

    Vector2f origin(Vector2f vector2f);

    Vector2f positiveX(Vector2f vector2f);

    Vector2f positiveY(Vector2f vector2f);

    Matrix3x2f rotate(float f2, Matrix3x2f matrix3x2f);

    Matrix3x2f rotateAbout(float f2, float f3, float f4, Matrix3x2f matrix3x2f);

    Matrix3x2f rotateLocal(float f2, Matrix3x2f matrix3x2f);

    Matrix3x2f rotateTo(Vector2fc vector2fc, Vector2fc vector2fc2, Matrix3x2f matrix3x2f);

    Matrix3x2f scale(float f2, float f3, Matrix3x2f matrix3x2f);

    Matrix3x2f scale(float f2, Matrix3x2f matrix3x2f);

    Matrix3x2f scale(Vector2fc vector2fc, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleAround(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleAround(float f2, float f3, float f4, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleAroundLocal(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleAroundLocal(float f2, float f3, float f4, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleLocal(float f2, float f3, Matrix3x2f matrix3x2f);

    Matrix3x2f scaleLocal(float f2, Matrix3x2f matrix3x2f);

    boolean testAar(float f2, float f3, float f4, float f5);

    boolean testCircle(float f2, float f3, float f4);

    boolean testPoint(float f2, float f3);

    Vector3f transform(float f2, float f3, float f4, Vector3f vector3f);

    Vector3f transform(Vector3f vector3f);

    Vector3f transform(Vector3f vector3f, Vector3f vector3f2);

    Vector2f transformDirection(float f2, float f3, Vector2f vector2f);

    Vector2f transformDirection(Vector2f vector2f);

    Vector2f transformDirection(Vector2fc vector2fc, Vector2f vector2f);

    Vector2f transformPosition(float f2, float f3, Vector2f vector2f);

    Vector2f transformPosition(Vector2f vector2f);

    Vector2f transformPosition(Vector2fc vector2fc, Vector2f vector2f);

    Matrix3x2f translate(float f2, float f3, Matrix3x2f matrix3x2f);

    Matrix3x2f translate(Vector2fc vector2fc, Matrix3x2f matrix3x2f);

    Matrix3x2f translateLocal(float f2, float f3, Matrix3x2f matrix3x2f);

    Matrix3x2f translateLocal(Vector2fc vector2fc, Matrix3x2f matrix3x2f);

    Vector2f unproject(float f2, float f3, int[] iArr, Vector2f vector2f);

    Vector2f unprojectInv(float f2, float f3, int[] iArr, Vector2f vector2f);

    Matrix3x2f view(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f);

    float[] viewArea(float[] fArr);
}
