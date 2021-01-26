package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public interface Vector4ic {
    Vector4i add(int i2, int i3, int i4, int i5, Vector4i vector4i);

    Vector4i add(Vector4ic vector4ic, Vector4i vector4i);

    double distance(int i2, int i3, int i4, int i5);

    double distance(Vector4ic vector4ic);

    int distanceSquared(int i2, int i3, int i4, int i5);

    int distanceSquared(Vector4ic vector4ic);

    Vector4i div(float f2, Vector4i vector4i);

    Vector4i div(Vector4ic vector4ic, Vector4i vector4i);

    int dot(Vector4ic vector4ic);

    boolean equals(int i2, int i3, int i4, int i5);

    int get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    IntBuffer get(int i2, IntBuffer intBuffer);

    IntBuffer get(IntBuffer intBuffer);

    long gridDistance(int i2, int i3, int i4, int i5);

    long gridDistance(Vector4ic vector4ic);

    double length();

    long lengthSquared();

    Vector4i max(Vector4ic vector4ic, Vector4i vector4i);

    int maxComponent();

    Vector4i min(Vector4ic vector4ic, Vector4i vector4i);

    int minComponent();

    Vector4i mul(int i2, Vector4i vector4i);

    Vector4i mul(Vector4ic vector4ic, Vector4i vector4i);

    Vector4i negate(Vector4i vector4i);

    Vector4i sub(int i2, int i3, int i4, int i5, Vector4i vector4i);

    Vector4i sub(Vector4ic vector4ic, Vector4i vector4i);

    int w();

    int x();

    int y();

    int z();
}
