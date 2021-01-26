package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public interface Vector2ic {
    Vector2i add(int i2, int i3, Vector2i vector2i);

    Vector2i add(Vector2ic vector2ic, Vector2i vector2i);

    double distance(int i2, int i3);

    double distance(Vector2ic vector2ic);

    long distanceSquared(int i2, int i3);

    long distanceSquared(Vector2ic vector2ic);

    boolean equals(int i2, int i3);

    int get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    IntBuffer get(int i2, IntBuffer intBuffer);

    IntBuffer get(IntBuffer intBuffer);

    long gridDistance(int i2, int i3);

    long gridDistance(Vector2ic vector2ic);

    double length();

    long lengthSquared();

    Vector2i max(Vector2ic vector2ic, Vector2i vector2i);

    int maxComponent();

    Vector2i min(Vector2ic vector2ic, Vector2i vector2i);

    int minComponent();

    Vector2i mul(int i2, int i3, Vector2i vector2i);

    Vector2i mul(int i2, Vector2i vector2i);

    Vector2i mul(Vector2ic vector2ic, Vector2i vector2i);

    Vector2i negate(Vector2i vector2i);

    Vector2i sub(int i2, int i3, Vector2i vector2i);

    Vector2i sub(Vector2ic vector2ic, Vector2i vector2i);

    int x();

    int y();
}
