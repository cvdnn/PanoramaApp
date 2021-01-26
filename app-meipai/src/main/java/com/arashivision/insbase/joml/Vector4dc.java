package com.arashivision.insbase.joml;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public interface Vector4dc {
    Vector4d add(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d add(Vector4dc vector4dc, Vector4d vector4d);

    Vector4d add(Vector4fc vector4fc, Vector4d vector4d);

    double angle(Vector4dc vector4dc);

    double angleCos(Vector4dc vector4dc);

    Vector4d ceil(Vector4d vector4d);

    double distance(double d2, double d3, double d4, double d5);

    double distance(Vector4dc vector4dc);

    double distanceSquared(double d2, double d3, double d4, double d5);

    double distanceSquared(Vector4dc vector4dc);

    Vector4d div(double d2, Vector4d vector4d);

    Vector4d div(Vector4dc vector4dc, Vector4d vector4d);

    double dot(double d2, double d3, double d4, double d5);

    double dot(Vector4dc vector4dc);

    boolean equals(double d2, double d3, double d4, double d5);

    boolean equals(Vector4dc vector4dc, double d2);

    Vector4d floor(Vector4d vector4d);

    Vector4d fma(double d2, Vector4dc vector4dc, Vector4d vector4d);

    Vector4d fma(Vector4dc vector4dc, Vector4dc vector4dc2, Vector4d vector4d);

    double get(int i2) throws IllegalArgumentException;

    ByteBuffer get(int i2, ByteBuffer byteBuffer);

    ByteBuffer get(ByteBuffer byteBuffer);

    DoubleBuffer get(int i2, DoubleBuffer doubleBuffer);

    DoubleBuffer get(DoubleBuffer doubleBuffer);

    Vector4d hermite(Vector4dc vector4dc, Vector4dc vector4dc2, Vector4dc vector4dc3, double d2, Vector4d vector4d);

    boolean isFinite();

    double length();

    double lengthSquared();

    Vector4d lerp(Vector4dc vector4dc, double d2, Vector4d vector4d);

    Vector4d max(Vector4dc vector4dc, Vector4d vector4d);

    int maxComponent();

    Vector4d min(Vector4dc vector4dc, Vector4d vector4d);

    int minComponent();

    Vector4d mul(double d2, Vector4d vector4d);

    Vector4d mul(Matrix4dc matrix4dc, Vector4d vector4d);

    Vector4d mul(Matrix4fc matrix4fc, Vector4d vector4d);

    Vector4d mul(Matrix4x3dc matrix4x3dc, Vector4d vector4d);

    Vector4d mul(Matrix4x3fc matrix4x3fc, Vector4d vector4d);

    Vector4d mul(Vector4dc vector4dc, Vector4d vector4d);

    Vector4d mul(Vector4fc vector4fc, Vector4d vector4d);

    Vector4d mulProject(Matrix4dc matrix4dc, Vector4d vector4d);

    Vector4d negate(Vector4d vector4d);

    Vector4d normalize(double d2, Vector4d vector4d);

    Vector4d normalize(Vector4d vector4d);

    Vector4d normalize3(Vector4d vector4d);

    Vector4d rotate(Quaterniondc quaterniondc, Vector4d vector4d);

    Vector4d rotateAxis(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d rotateX(double d2, Vector4d vector4d);

    Vector4d rotateY(double d2, Vector4d vector4d);

    Vector4d rotateZ(double d2, Vector4d vector4d);

    Vector4d round(Vector4d vector4d);

    Vector4d smoothStep(Vector4dc vector4dc, double d2, Vector4d vector4d);

    Vector4d sub(double d2, double d3, double d4, double d5, Vector4d vector4d);

    Vector4d sub(Vector4dc vector4dc, Vector4d vector4d);

    Vector4d sub(Vector4fc vector4fc, Vector4d vector4d);

    double w();

    double x();

    double y();

    double z();
}
