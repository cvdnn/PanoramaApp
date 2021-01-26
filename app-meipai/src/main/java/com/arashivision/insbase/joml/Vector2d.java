package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.MemUtil;
import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.text.NumberFormat;

public class Vector2d implements Externalizable, Vector2dc {
    public static final long serialVersionUID = 1;
    public double x;
    public double y;

    public Vector2d() {
    }

    public static double distanceSquared(double d2, double d3, double d4, double d5) {
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        return (d7 * d7) + (d6 * d6);
    }

    public static double lengthSquared(double d2, double d3) {
        return (d3 * d3) + (d2 * d2);
    }

    private Vector2d thisOrNew() {
        return this;
    }

    public Vector2d add(Vector2dc vector2dc) {
        return add(vector2dc, thisOrNew());
    }

    public double angle(Vector2dc vector2dc) {
        return Math.atan2((vector2dc.y() * this.x) - (vector2dc.x() * this.y), (vector2dc.y() * this.y) + (vector2dc.x() * this.x));
    }

    public Vector2d ceil() {
        return ceil(thisOrNew());
    }

    public double distance(Vector2dc vector2dc) {
        return distance(vector2dc.x(), vector2dc.y());
    }

    public double distanceSquared(Vector2dc vector2dc) {
        return distanceSquared(vector2dc.x(), vector2dc.y());
    }

    public double dot(Vector2dc vector2dc) {
        return (vector2dc.y() * this.y) + (vector2dc.x() * this.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector2d.class != obj.getClass()) {
            return false;
        }
        Vector2d vector2d = (Vector2d) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(vector2d.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(vector2d.y);
    }

    public Vector2d floor() {
        return floor(thisOrNew());
    }

    public Vector2d fma(Vector2dc vector2dc, Vector2dc vector2dc2) {
        return fma(vector2dc, vector2dc2, thisOrNew());
    }

    public double get(int i2) throws IllegalArgumentException {
        if (i2 == 0) {
            return this.x;
        }
        if (i2 == 1) {
            return this.y;
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        return (i2 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    public Vector2d lerp(Vector2dc vector2dc, double d2) {
        return lerp(vector2dc, d2, thisOrNew());
    }

    public Vector2d max(Vector2dc vector2dc) {
        return max(vector2dc, thisOrNew());
    }

    public int maxComponent() {
        return Math.abs(this.x) >= Math.abs(this.y) ? 0 : 1;
    }

    public Vector2d min(Vector2dc vector2dc) {
        return min(vector2dc, thisOrNew());
    }

    public int minComponent() {
        return Math.abs(this.x) < Math.abs(this.y) ? 0 : 1;
    }

    public Vector2d mul(double d2) {
        return mul(d2, thisOrNew());
    }

    public Vector2d mulDirection(Matrix3x2dc matrix3x2dc) {
        return mulDirection(matrix3x2dc, thisOrNew());
    }

    public Vector2d mulPosition(Matrix3x2dc matrix3x2dc) {
        return mulPosition(matrix3x2dc, thisOrNew());
    }

    public Vector2d negate() {
        return negate(thisOrNew());
    }

    public Vector2d normalize() {
        return normalize(thisOrNew());
    }

    public Vector2d perpendicular() {
        return set(this.y, this.x * -1.0d);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readDouble();
        this.y = objectInput.readDouble();
    }

    public Vector2d round() {
        return round(thisOrNew());
    }

    public Vector2d set(double d2) {
        return set(d2, d2);
    }

    public Vector2d setComponent(int i2, double d2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = d2;
        } else if (i2 == 1) {
            this.y = d2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector2d sub(Vector2dc vector2dc) {
        return sub(vector2dc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.x);
        objectOutput.writeDouble(this.y);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public Vector2d zero() {
        return thisOrNew().set(0.0d, 0.0d);
    }

    public Vector2d(double d2) {
        this(d2, d2);
    }

    public static double length(double d2, double d3) {
        return Math.sqrt(lengthSquared(d2, d3));
    }

    public Vector2d add(double d2, double d3) {
        return add(d2, d3, thisOrNew());
    }

    public Vector2d ceil(Vector2d vector2d) {
        vector2d.x = Math.ceil(this.x);
        vector2d.y = Math.ceil(this.y);
        return vector2d;
    }

    public double distance(Vector2fc vector2fc) {
        return distance((double) vector2fc.x(), (double) vector2fc.y());
    }

    public double distanceSquared(Vector2fc vector2fc) {
        return distanceSquared((double) vector2fc.x(), (double) vector2fc.y());
    }

    public Vector2d floor(Vector2d vector2d) {
        vector2d.x = Math.floor(this.x);
        vector2d.y = Math.floor(this.y);
        return vector2d;
    }

    public Vector2d fma(double d2, Vector2dc vector2dc) {
        return fma(d2, vector2dc, thisOrNew());
    }

    public Vector2d lerp(Vector2dc vector2dc, double d2, Vector2d vector2d) {
        vector2d.x = a.h(vector2dc.x(), this.x, d2, this.x);
        vector2d.y = a.h(vector2dc.y(), this.y, d2, this.y);
        return vector2d;
    }

    public Vector2d max(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = this.x > vector2dc.x() ? this.x : vector2dc.x();
        vector2d.y = this.y > vector2dc.y() ? this.y : vector2dc.y();
        return vector2d;
    }

    public Vector2d min(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = this.x < vector2dc.x() ? this.x : vector2dc.x();
        vector2d.y = this.y < vector2dc.y() ? this.y : vector2dc.y();
        return vector2d;
    }

    public Vector2d mul(double d2, Vector2d vector2d) {
        vector2d.x = this.x * d2;
        vector2d.y = this.y * d2;
        return vector2d;
    }

    public Vector2d mulDirection(Matrix3x2dc matrix3x2dc, Vector2d vector2d) {
        double m10 = (matrix3x2dc.m10() * this.y) + (matrix3x2dc.m00() * this.x);
        double m11 = (matrix3x2dc.m11() * this.y) + (matrix3x2dc.m01() * this.x);
        vector2d.x = m10;
        vector2d.y = m11;
        return vector2d;
    }

    public Vector2d mulPosition(Matrix3x2dc matrix3x2dc, Vector2d vector2d) {
        double m20 = matrix3x2dc.m20() + (matrix3x2dc.m10() * this.y) + (matrix3x2dc.m00() * this.x);
        double m21 = matrix3x2dc.m21() + (matrix3x2dc.m11() * this.y) + (matrix3x2dc.m01() * this.x);
        vector2d.x = m20;
        vector2d.y = m21;
        return vector2d;
    }

    public Vector2d negate(Vector2d vector2d) {
        vector2d.x = -this.x;
        vector2d.y = -this.y;
        return vector2d;
    }

    public Vector2d normalize(Vector2d vector2d) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double e2 = a.e(d4, d4, d3, 1.0d);
        vector2d.x = this.x * e2;
        vector2d.y = this.y * e2;
        return vector2d;
    }

    public Vector2d round(Vector2d vector2d) {
        vector2d.x = (double) Math.round(this.x);
        vector2d.y = (double) Math.round(this.y);
        return vector2d;
    }

    public Vector2d set(double d2, double d3) {
        this.x = d2;
        this.y = d3;
        return this;
    }

    public Vector2d sub(double d2, double d3) {
        return sub(d2, d3, thisOrNew());
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a.b(numberFormat, this.x, a2, " ");
        return a.a(numberFormat, this.y, a2, ")");
    }

    public Vector2d(double d2, double d3) {
        this.x = d2;
        this.y = d3;
    }

    public Vector2d add(double d2, double d3, Vector2d vector2d) {
        vector2d.x = this.x + d2;
        vector2d.y = this.y + d3;
        return vector2d;
    }

    public double distance(double d2, double d3) {
        return Math.sqrt(distanceSquared(d2, d3));
    }

    public double distanceSquared(double d2, double d3) {
        double d4 = this.x - d2;
        double d5 = this.y - d3;
        return (d5 * d5) + (d4 * d4);
    }

    public Vector2d fma(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2d vector2d) {
        vector2d.x = (vector2dc2.x() * vector2dc.x()) + this.x;
        vector2d.y = (vector2dc2.y() * vector2dc.y()) + this.y;
        return vector2d;
    }

    public Vector2d sub(double d2, double d3, Vector2d vector2d) {
        vector2d.x = this.x - d2;
        vector2d.y = this.y - d3;
        return vector2d;
    }

    public static double distance(double d2, double d3, double d4, double d5) {
        return Math.sqrt(distanceSquared(d2, d3, d4, d5));
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector2d mul(double d2, double d3) {
        return mul(d2, d3, thisOrNew());
    }

    public Vector2d set(Vector2dc vector2dc) {
        return set(vector2dc.x(), vector2dc.y());
    }

    public Vector2d add(Vector2fc vector2fc) {
        return add(vector2fc, thisOrNew());
    }

    public boolean equals(Vector2dc vector2dc, double d2) {
        if (this == vector2dc) {
            return true;
        }
        return vector2dc != null && Runtime.equals(this.x, vector2dc.x(), d2) && Runtime.equals(this.y, vector2dc.y(), d2);
    }

    public Vector2d fma(double d2, Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = (vector2dc.x() * d2) + this.x;
        vector2d.y = (vector2dc.y() * d2) + this.y;
        return vector2d;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector2d mul(double d2, double d3, Vector2d vector2d) {
        vector2d.x = this.x * d2;
        vector2d.y = this.y * d3;
        return vector2d;
    }

    public Vector2d normalize(double d2) {
        return normalize(d2, thisOrNew());
    }

    public Vector2d set(Vector2fc vector2fc) {
        return set((double) vector2fc.x(), (double) vector2fc.y());
    }

    public Vector2d sub(Vector2fc vector2fc) {
        return sub(vector2fc, thisOrNew());
    }

    public Vector2d(Vector2dc vector2dc) {
        this.x = vector2dc.x();
        this.y = vector2dc.y();
    }

    public Vector2d add(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = vector2dc.x() + this.x;
        vector2d.y = vector2dc.y() + this.y;
        return vector2d;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public Vector2d normalize(double d2, Vector2d vector2d) {
        double d3 = this.x;
        double d4 = d3 * d3;
        double d5 = this.y;
        double sqrt = (1.0d / Math.sqrt((d5 * d5) + d4)) * d2;
        vector2d.x = this.x * sqrt;
        vector2d.y = this.y * sqrt;
        return vector2d;
    }

    public Vector2d set(Vector2ic vector2ic) {
        return set((double) vector2ic.x(), (double) vector2ic.y());
    }

    public Vector2d sub(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = this.x - vector2dc.x();
        vector2d.y = this.y - vector2dc.y();
        return vector2d;
    }

    public boolean equals(double d2, double d3) {
        if (Double.doubleToLongBits(this.x) == Double.doubleToLongBits(d2) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(d3)) {
            return true;
        }
        return false;
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Vector2d mul(Vector2dc vector2dc) {
        return mul(vector2dc, thisOrNew());
    }

    public Vector2d set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector2d add(Vector2fc vector2fc, Vector2d vector2d) {
        vector2d.x = this.x + ((double) vector2fc.x());
        vector2d.y = this.y + ((double) vector2fc.y());
        return vector2d;
    }

    public Vector2d mul(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.x = vector2dc.x() * this.x;
        vector2d.y = vector2dc.y() * this.y;
        return vector2d;
    }

    public Vector2d set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector2d sub(Vector2fc vector2fc, Vector2d vector2d) {
        vector2d.x = this.x + ((double) vector2fc.x());
        vector2d.y = this.y + ((double) vector2fc.y());
        return vector2d;
    }

    public Vector2d(Vector2fc vector2fc) {
        this.x = (double) vector2fc.x();
        this.y = (double) vector2fc.y();
    }

    public Vector2d set(DoubleBuffer doubleBuffer) {
        return set(doubleBuffer.position(), doubleBuffer);
    }

    public Vector2d set(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
        return this;
    }

    public Vector2d(Vector2ic vector2ic) {
        this.x = (double) vector2ic.x();
        this.y = (double) vector2ic.y();
    }

    public Vector2d(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector2d(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector2d(DoubleBuffer doubleBuffer) {
        this(doubleBuffer.position(), doubleBuffer);
    }

    public Vector2d(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
    }
}
