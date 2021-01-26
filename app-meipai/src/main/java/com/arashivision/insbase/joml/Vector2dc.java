package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public interface Vector2dc {
    Vector2d add(double d2, double d3, Vector2d vector2d);

    Vector2d add(Vector2dc vector2dc, Vector2d vector2d);

    Vector2d add(Vector2fc vector2fc, Vector2d vector2d);

    double angle(Vector2dc vector2dc);

    Vector2d ceil(Vector2d vector2d);

    double distance(double d2, double d3);

    double distance(Vector2dc vector2dc);

    double distance(Vector2fc vector2fc);

    double distanceSquared(double d2, double d3);

    double distanceSquared(Vector2dc vector2dc);

    double distanceSquared(Vector2fc vector2fc);

    double dot(Vector2dc vector2dc);

    boolean equals(double d2, double d3);

    boolean equals(Vector2dc vector2dc, double d2);

    Vector2d floor(Vector2d vector2d);

    Vector2d fma(double d2, Vector2dc vector2dc, Vector2d vector2d);

    Vector2d fma(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2d vector2d);

    double get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    DoubleBuffer get(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get(DoubleBuffer doubleBuffer);

    boolean isFinite();

    double length();

    double lengthSquared();

    Vector2d lerp(Vector2dc vector2dc, double d2, Vector2d vector2d);

    Vector2d max(Vector2dc vector2dc, Vector2d vector2d);

    int maxComponent();

    Vector2d min(Vector2dc vector2dc, Vector2d vector2d);

    int minComponent();

    Vector2d mul(double d2, double d3, Vector2d vector2d);

    Vector2d mul(double d2, Vector2d vector2d);

    Vector2d mul(Vector2dc vector2dc, Vector2d vector2d);

    Vector2d mulDirection(Matrix3x2dc matrix3x2dc, Vector2d vector2d);

    Vector2d mulPosition(Matrix3x2dc matrix3x2dc, Vector2d vector2d);

    Vector2d negate(Vector2d vector2d);

    Vector2d normalize(double d2, Vector2d vector2d);

    Vector2d normalize(Vector2d vector2d);

    Vector2d round(Vector2d vector2d);

    Vector2d sub(double d2, double d3, Vector2d vector2d);

    Vector2d sub(Vector2dc vector2dc, Vector2d vector2d);

    Vector2d sub(Vector2fc vector2fc, Vector2d vector2d);

    double x();

    double y();
}
