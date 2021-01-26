package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public interface Vector3ic {
    Vector3i add(int i2, int i3, int i4, Vector3i vector3i);

    Vector3i add(Vector3ic vector3ic, Vector3i vector3i);

    double distance(int i2, int i3, int i4);

    double distance(Vector3ic vector3ic);

    long distanceSquared(int i2, int i3, int i4);

    long distanceSquared(Vector3ic vector3ic);

    boolean equals(int i2, int i3, int i4);

    int get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    IntBuffer get(int i2, IntBuffer intBuffer);

    IntBuffer get(IntBuffer intBuffer);

    long gridDistance(int i2, int i3, int i4);

    long gridDistance(Vector3ic vector3ic);

    double length();

    long lengthSquared();

    Vector3i max(Vector3ic vector3ic, Vector3i vector3i);

    int maxComponent();

    Vector3i min(Vector3ic vector3ic, Vector3i vector3i);

    int minComponent();

    Vector3i mul(int i2, int i3, int i4, Vector3i vector3i);

    Vector3i mul(int i2, Vector3i vector3i);

    Vector3i mul(Vector3ic vector3ic, Vector3i vector3i);

    Vector3i negate(Vector3i vector3i);

    Vector3i sub(int i2, int i3, int i4, Vector3i vector3i);

    Vector3i sub(Vector3ic vector3ic, Vector3i vector3i);

    int x();

    int y();

    int z();
}
