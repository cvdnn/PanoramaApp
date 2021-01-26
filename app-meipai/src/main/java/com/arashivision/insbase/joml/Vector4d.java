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

public class Vector4d implements Externalizable, Vector4dc {
    public static final long serialVersionUID = 1;
    public double w;
    public double x;
    public double y;
    public double z;

    public Vector4d() {
        this.w = 1.0d;
    }

    public static double distanceSquared(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d2 - d6;
        double d11 = d3 - d7;
        double d12 = d4 - d8;
        double d13 = d5 - d9;
        return (d13 * d13) + (d12 * d12) + (d11 * d11) + (d10 * d10);
    }

    public static double lengthSquared(double d2, double d3, double d4, double d5) {
        return (d5 * d5) + (d4 * d4) + (d3 * d3) + (d2 * d2);
    }

    private Vector4d mulGeneric(Matrix4dc matrix4dc, Vector4d vector4d) {
        double m30 = (matrix4dc.m30() * this.w) + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x);
        double m31 = (matrix4dc.m31() * this.w) + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x);
        double m32 = (matrix4dc.m32() * this.w) + (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x);
        double m33 = (matrix4dc.m33() * this.w) + (matrix4dc.m23() * this.z) + (matrix4dc.m13() * this.y) + (matrix4dc.m03() * this.x);
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = m32;
        vector4d.w = m33;
        return vector4d;
    }

    private Vector4d thisOrNew() {
        return this;
    }

    public Vector4d add(Vector4dc vector4dc) {
        return add(vector4dc, thisOrNew());
    }

    public double angle(Vector4dc vector4dc) {
        double angleCos = angleCos(vector4dc);
        if (angleCos >= 1.0d) {
            angleCos = 1.0d;
        }
        if (angleCos <= -1.0d) {
            angleCos = -1.0d;
        }
        return Math.acos(angleCos);
    }

    public double angleCos(Vector4dc vector4dc) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double d9 = (d8 * d8) + d7;
        double w2 = (vector4dc.w() * vector4dc.w()) + (vector4dc.z() * vector4dc.z()) + (vector4dc.y() * vector4dc.y()) + (vector4dc.x() * vector4dc.x());
        return ((vector4dc.w() * this.w) + ((vector4dc.z() * this.z) + ((vector4dc.y() * this.y) + (vector4dc.x() * this.x)))) / Math.sqrt(d9 * w2);
    }

    public Vector4d ceil() {
        return ceil(thisOrNew());
    }

    public double distance(Vector4dc vector4dc) {
        return distance(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w());
    }

    public double distanceSquared(Vector4dc vector4dc) {
        return distanceSquared(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w());
    }

    public Vector4d div(Vector4dc vector4dc) {
        return div(vector4dc, thisOrNew());
    }

    public double dot(Vector4dc vector4dc) {
        return dot(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector4d.class != obj.getClass()) {
            return false;
        }
        Vector4d vector4d = (Vector4d) obj;
        return Double.doubleToLongBits(this.w) == Double.doubleToLongBits(vector4d.w) && Double.doubleToLongBits(this.x) == Double.doubleToLongBits(vector4d.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(vector4d.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(vector4d.z);
    }

    public Vector4d floor() {
        return floor(thisOrNew());
    }

    public Vector4d fma(Vector4dc vector4dc, Vector4dc vector4dc2) {
        return fma(vector4dc, vector4dc2, thisOrNew());
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.w);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.x);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.y);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.z);
        return (i4 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public Vector4d hermite(Vector4dc vector4dc, Vector4dc vector4dc2, Vector4dc vector4dc3, double d2, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double d5 = this.x;
        double x2 = ((((((vector4dc2.x() * 3.0d) - (this.x * 3.0d)) - vector4dc.x()) - vector4dc.x()) - vector4dc3.x()) * d3) + ((vector4dc.x() + vector4dc3.x() + (((d5 + d5) - vector4dc2.x()) - vector4dc2.x())) * d4);
        double d6 = this.x;
        vector4d2.x = a.i(d6, d2, x2, d6);
        double d7 = this.y;
        double y2 = ((((((vector4dc2.y() * 3.0d) - (this.y * 3.0d)) - vector4dc.y()) - vector4dc.y()) - vector4dc3.y()) * d3) + ((vector4dc.y() + vector4dc3.y() + (((d7 + d7) - vector4dc2.y()) - vector4dc2.y())) * d4);
        double d8 = this.y;
        vector4d2.y = a.i(d8, d2, y2, d8);
        double d9 = this.z;
        double z2 = ((((((vector4dc2.z() * 3.0d) - (this.z * 3.0d)) - vector4dc.z()) - vector4dc.z()) - vector4dc3.z()) * d3) + ((vector4dc.z() + vector4dc3.z() + (((d9 + d9) - vector4dc2.z()) - vector4dc2.z())) * d4);
        double d10 = this.z;
        vector4d2.z = a.i(d10, d2, z2, d10);
        double d11 = this.w;
        double w2 = ((((((vector4dc2.w() * 3.0d) - (this.w * 3.0d)) - vector4dc.w()) - vector4dc.w()) - vector4dc3.w()) * d3) + ((vector4dc.w() + vector4dc3.w() + (((d11 + d11) - vector4dc2.w()) - vector4dc2.w())) * d4);
        double d12 = this.w;
        vector4d2.w = a.i(d12, d2, w2, d12);
        return vector4d2;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z) && Math.isFinite(this.w);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return lengthSquared(this.x, this.y, this.z, this.w);
    }

    public Vector4d lerp(Vector4dc vector4dc, double d2) {
        return lerp(vector4dc, d2, thisOrNew());
    }

    public Vector4d max(Vector4dc vector4dc) {
        return max(vector4dc, thisOrNew());
    }

    public int maxComponent() {
        double abs = Math.abs(this.x);
        double abs2 = Math.abs(this.y);
        double abs3 = Math.abs(this.z);
        double abs4 = Math.abs(this.w);
        if (abs >= abs2 && abs >= abs3 && abs >= abs4) {
            return 0;
        }
        if (abs2 < abs3 || abs2 < abs4) {
            return abs3 >= abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4d min(Vector4dc vector4dc) {
        return min(vector4dc, thisOrNew());
    }

    public int minComponent() {
        double abs = Math.abs(this.x);
        double abs2 = Math.abs(this.y);
        double abs3 = Math.abs(this.z);
        double abs4 = Math.abs(this.w);
        if (abs < abs2 && abs < abs3 && abs < abs4) {
            return 0;
        }
        if (abs2 >= abs3 || abs2 >= abs4) {
            return abs3 < abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4d mul(Vector4dc vector4dc) {
        return mul(vector4dc, thisOrNew());
    }

    public Vector4d mulAffine(Matrix4dc matrix4dc, Vector4d vector4d) {
        double m30 = (matrix4dc.m30() * this.w) + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x);
        double m31 = (matrix4dc.m31() * this.w) + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x);
        double m22 = (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x);
        double m32 = matrix4dc.m32();
        double d2 = this.w;
        double d3 = (m32 * d2) + m22;
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = d3;
        vector4d.w = d2;
        return vector4d;
    }

    public Vector4d mulProject(Matrix4dc matrix4dc, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double l = a.l(matrix4dc.m33(), this.w, (matrix4dc.m23() * this.z) + (matrix4dc.m13() * this.y) + (matrix4dc.m03() * this.x), 1.0d);
        double m30 = (matrix4dc.m30() + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x)) * l;
        double m31 = (matrix4dc.m31() + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x)) * l;
        double m32 = (matrix4dc.m32() + (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x)) * l;
        vector4d2.x = m30;
        vector4d2.y = m31;
        vector4d2.z = m32;
        vector4d2.w = 1.0d;
        return vector4d2;
    }

    public Vector4d negate() {
        return negate(thisOrNew());
    }

    public Vector4d normalize() {
        return normalize(thisOrNew());
    }

    public Vector4d normalize3() {
        return normalize3(thisOrNew());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readDouble();
        this.y = objectInput.readDouble();
        this.z = objectInput.readDouble();
        this.w = objectInput.readDouble();
    }

    public Vector4d rotate(Quaterniondc quaterniondc) {
        return rotate(quaterniondc, thisOrNew());
    }

    public Vector4d rotateAxis(double d2, double d3, double d4, double d5) {
        return rotateAxis(d2, d3, d4, d5, thisOrNew());
    }

    public Vector4d rotateX(double d2) {
        return rotateX(d2, thisOrNew());
    }

    public Vector4d rotateY(double d2) {
        return rotateY(d2, thisOrNew());
    }

    public Vector4d rotateZ(double d2) {
        return rotateZ(d2, thisOrNew());
    }

    public Vector4d round() {
        return round(thisOrNew());
    }

    public Vector4d set(Vector4dc vector4dc) {
        return set(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w());
    }

    public Vector4d setComponent(int i2, double d2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = d2;
        } else if (i2 == 1) {
            this.y = d2;
        } else if (i2 == 2) {
            this.z = d2;
        } else if (i2 == 3) {
            this.w = d2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector4d smoothStep(Vector4dc vector4dc, double d2, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double d5 = this.x;
        double x2 = (((d5 + d5) - vector4dc.x()) - vector4dc.x()) * d4;
        double x3 = vector4dc.x() * 3.0d;
        double d6 = this.x;
        double d7 = d3;
        vector4d2.x = a.i(d6, d2, a.a(d6, 3.0d, x3, d7, x2), d6);
        double d8 = this.y;
        double y2 = (((d8 + d8) - vector4dc.y()) - vector4dc.y()) * d4;
        double y3 = vector4dc.y() * 3.0d;
        double d9 = this.y;
        vector4d2.y = a.i(d9, d2, a.a(d9, 3.0d, y3, d7, y2), d9);
        double d10 = this.z;
        double z2 = (((d10 + d10) - vector4dc.z()) - vector4dc.z()) * d4;
        double z3 = vector4dc.z() * 3.0d;
        double d11 = this.z;
        vector4d2.z = a.i(d11, d2, a.a(d11, 3.0d, z3, d7, z2), d11);
        double d12 = this.w;
        double w2 = (((d12 + d12) - vector4dc.w()) - vector4dc.w()) * d4;
        double w3 = vector4dc.w() * 3.0d;
        double d13 = this.w;
        vector4d2.w = a.i(d13, d2, a.a(d13, 3.0d, w3, d7, w2), d13);
        return vector4d2;
    }

    public Vector4d sub(Vector4dc vector4dc) {
        return sub(vector4dc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public double w() {
        return this.w;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.x);
        objectOutput.writeDouble(this.y);
        objectOutput.writeDouble(this.z);
        objectOutput.writeDouble(this.w);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public Vector4d zero() {
        return thisOrNew().set(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public static double length(double d2, double d3, double d4, double d5) {
        return Math.sqrt(lengthSquared(d2, d3, d4, d5));
    }

    public Vector4d add(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = vector4dc.x() + this.x;
        vector4d.y = vector4dc.y() + this.y;
        vector4d.z = vector4dc.z() + this.z;
        vector4d.w = vector4dc.w() + this.w;
        return vector4d;
    }

    public Vector4d ceil(Vector4d vector4d) {
        vector4d.x = Math.ceil(this.x);
        vector4d.y = Math.ceil(this.y);
        vector4d.z = Math.ceil(this.z);
        vector4d.w = Math.ceil(this.w);
        return vector4d;
    }

    public double distance(double d2, double d3, double d4, double d5) {
        return (double) ((float) Math.sqrt(distanceSquared(d2, d3, d4, d5)));
    }

    public double distanceSquared(double d2, double d3, double d4, double d5) {
        double d6 = this.x - d2;
        double d7 = this.y - d3;
        double d8 = this.z - d4;
        double d9 = this.w - d5;
        return (d9 * d9) + (d8 * d8) + (d7 * d7) + (d6 * d6);
    }

    public Vector4d div(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = this.x / vector4dc.x();
        vector4d.y = this.y / vector4dc.y();
        vector4d.z = this.z / vector4dc.z();
        vector4d.w = this.w / vector4dc.w();
        return vector4d;
    }

    public double dot(double d2, double d3, double d4, double d5) {
        return (this.w * d5) + (this.z * d4) + (this.y * d3) + (this.x * d2);
    }

    public Vector4d floor(Vector4d vector4d) {
        vector4d.x = Math.floor(this.x);
        vector4d.y = Math.floor(this.y);
        vector4d.z = Math.floor(this.z);
        vector4d.w = Math.floor(this.w);
        return vector4d;
    }

    public Vector4d fma(double d2, Vector4dc vector4dc) {
        return fma(d2, vector4dc, thisOrNew());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector4d lerp(Vector4dc vector4dc, double d2, Vector4d vector4d) {
        vector4d.x = a.h(vector4dc.x(), this.x, d2, this.x);
        double d3 = d2;
        vector4d.y = a.h(vector4dc.y(), this.y, d3, this.y);
        vector4d.z = a.h(vector4dc.z(), this.z, d3, this.z);
        vector4d.w = a.h(vector4dc.w(), this.w, d3, this.w);
        return vector4d;
    }

    public Vector4d max(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = this.x > vector4dc.x() ? this.x : vector4dc.x();
        vector4d.y = this.y > vector4dc.y() ? this.y : vector4dc.y();
        vector4d.z = this.z > vector4dc.z() ? this.z : vector4dc.z();
        vector4d.w = this.w > vector4dc.w() ? this.w : vector4dc.w();
        return vector4d;
    }

    public Vector4d min(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = this.x < vector4dc.x() ? this.x : vector4dc.x();
        vector4d.y = this.y < vector4dc.y() ? this.y : vector4dc.y();
        vector4d.z = this.z < vector4dc.z() ? this.z : vector4dc.z();
        vector4d.w = this.w < vector4dc.w() ? this.w : vector4dc.w();
        return vector4d;
    }

    public Vector4d mul(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = vector4dc.x() * this.x;
        vector4d.y = vector4dc.y() * this.y;
        vector4d.z = vector4dc.z() * this.z;
        vector4d.w = vector4dc.w() * this.w;
        return vector4d;
    }

    public Vector4d negate(Vector4d vector4d) {
        vector4d.x = -this.x;
        vector4d.y = -this.y;
        vector4d.z = -this.z;
        vector4d.w = -this.w;
        return vector4d;
    }

    public Vector4d normalize(Vector4d vector4d) {
        double length = 1.0d / length();
        vector4d.x = this.x * length;
        vector4d.y = this.y * length;
        vector4d.z = this.z * length;
        vector4d.w = this.w * length;
        return vector4d;
    }

    public Vector4d normalize3(Vector4d vector4d) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double e2 = a.e(d6, d6, d5, 1.0d);
        vector4d.x = this.x * e2;
        vector4d.y = this.y * e2;
        vector4d.z = this.z * e2;
        vector4d.w = this.w * e2;
        return vector4d;
    }

    public Vector4d rotate(Quaterniondc quaterniondc, Vector4d vector4d) {
        quaterniondc.transform((Vector4dc) this, vector4d);
        return vector4d;
    }

    public Vector4d rotateAxis(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d6 = 0.5d * d2;
        double sin = Math.sin(d6);
        double d7 = d3 * sin;
        double d8 = d4 * sin;
        double d9 = d5 * sin;
        double cosFromSin = Math.cosFromSin(sin, d6);
        double d10 = cosFromSin * cosFromSin;
        double d11 = d7 * d7;
        double d12 = d8 * d8;
        double d13 = d9 * d9;
        double d14 = d9 * cosFromSin;
        double d15 = d7 * d8;
        double d16 = d7 * d9;
        double d17 = d8 * cosFromSin;
        double d18 = d8 * d9;
        double d19 = d7 * cosFromSin;
        double b2 = a.b(d10, d11, d13, d12);
        double d20 = d14;
        double d21 = d19;
        double d22 = this.x;
        double d23 = b2 * d22;
        double d24 = d18;
        double d25 = (((-d20) + d15) - d20) + d15;
        double d26 = d11;
        double d27 = this.y;
        double d28 = (d25 * d27) + d23;
        double a2 = a.a(d17, d16, d16, d17);
        double d29 = d27;
        double d30 = this.z;
        double d31 = (a2 * d30) + d28;
        double d32 = d24 + d24;
        double d33 = (((d32 - d21) - d21) * d30) + ((((d12 - d13) + d10) - d26) * d29) + ((d15 + d20 + d20 + d15) * d22);
        double d34 = (((d13 - d12) - d26) + d10) * d30;
        double d35 = d34 + ((d32 + d21 + d21) * d29) + ((((d16 - d17) + d16) - d17) * d22);
        Vector4d vector4d3 = vector4d;
        vector4d3.x = d31;
        vector4d3.y = d33;
        vector4d3.z = d35;
        return vector4d3;
    }

    public Vector4d rotateX(double d2, Vector4d vector4d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.y;
        double d4 = d3 * cosFromSin;
        double d5 = this.z;
        double d6 = d4 - (d5 * sin);
        double d7 = (d5 * cosFromSin) + (d3 * sin);
        vector4d.x = this.x;
        vector4d.y = d6;
        vector4d.z = d7;
        vector4d.w = this.w;
        return vector4d;
    }

    public Vector4d rotateY(double d2, Vector4d vector4d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.x;
        double d4 = d3 * cosFromSin;
        double d5 = this.z;
        double d6 = (d5 * cosFromSin) + ((-d3) * sin);
        vector4d.x = (d5 * sin) + d4;
        vector4d.y = this.y;
        vector4d.z = d6;
        vector4d.w = this.w;
        return vector4d;
    }

    public Vector4d rotateZ(double d2, Vector4d vector4d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.x;
        double d4 = d3 * cosFromSin;
        double d5 = this.y;
        double d6 = (d5 * cosFromSin) + (d3 * sin);
        vector4d.x = d4 - (d5 * sin);
        vector4d.y = d6;
        vector4d.z = this.z;
        vector4d.w = this.w;
        return vector4d;
    }

    public Vector4d round(Vector4d vector4d) {
        vector4d.x = (double) Math.round(this.x);
        vector4d.y = (double) Math.round(this.y);
        vector4d.z = (double) Math.round(this.z);
        vector4d.w = (double) Math.round(this.w);
        return vector4d;
    }

    public Vector4d set(Vector4fc vector4fc) {
        return set((double) vector4fc.x(), (double) vector4fc.y(), (double) vector4fc.z(), (double) vector4fc.w());
    }

    public Vector4d sub(Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = this.x - vector4dc.x();
        vector4d.y = this.y - vector4dc.y();
        vector4d.z = this.z - vector4dc.z();
        vector4d.w = this.w - vector4dc.w();
        return vector4d;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.x, a2, str);
        a.b(numberFormat, this.y, a2, str);
        a.b(numberFormat, this.z, a2, str);
        return a.a(numberFormat, this.w, a2, ")");
    }

    public Vector4d(Vector4dc vector4dc) {
        this(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w());
    }

    public static double distance(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return Math.sqrt(distanceSquared(d2, d3, d4, d5, d6, d7, d8, d9));
    }

    public Vector4d fma(Vector4dc vector4dc, Vector4dc vector4dc2, Vector4d vector4d) {
        vector4d.x = (vector4dc2.x() * vector4dc.x()) + this.x;
        vector4d.y = (vector4dc2.y() * vector4dc.y()) + this.y;
        vector4d.z = (vector4dc2.z() * vector4dc.z()) + this.z;
        vector4d.w = (vector4dc2.w() * vector4dc.w()) + this.w;
        return vector4d;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public Vector4d set(Vector4ic vector4ic) {
        return set((double) vector4ic.x(), (double) vector4ic.y(), (double) vector4ic.z(), (double) vector4ic.w());
    }

    public Vector4d(Vector4ic vector4ic) {
        this((double) vector4ic.x(), (double) vector4ic.y(), (double) vector4ic.z(), (double) vector4ic.w());
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Vector4d set(Vector3dc vector3dc, double d2) {
        return set(vector3dc.x(), vector3dc.y(), vector3dc.z(), d2);
    }

    public Vector4d(Vector3dc vector3dc, double d2) {
        this(vector3dc.x(), vector3dc.y(), vector3dc.z(), d2);
    }

    public double get(int i2) throws IllegalArgumentException {
        if (i2 == 0) {
            return this.x;
        }
        if (i2 == 1) {
            return this.y;
        }
        if (i2 == 2) {
            return this.z;
        }
        if (i2 == 3) {
            return this.w;
        }
        throw new IllegalArgumentException();
    }

    public Vector4d set(Vector3ic vector3ic, double d2) {
        return set((double) vector3ic.x(), (double) vector3ic.y(), (double) vector3ic.z(), d2);
    }

    public Vector4d(Vector3ic vector3ic, double d2) {
        this((double) vector3ic.x(), (double) vector3ic.y(), (double) vector3ic.z(), d2);
    }

    public Vector4d add(Vector4fc vector4fc, Vector4d vector4d) {
        vector4d.x = this.x + ((double) vector4fc.x());
        vector4d.y = this.y + ((double) vector4fc.y());
        vector4d.z = this.z + ((double) vector4fc.z());
        vector4d.w = this.w + ((double) vector4fc.w());
        return vector4d;
    }

    public Vector4d div(double d2) {
        return div(d2, thisOrNew());
    }

    public Vector4d mul(Vector4fc vector4fc) {
        return mul(vector4fc, thisOrNew());
    }

    public Vector4d set(Vector3fc vector3fc, double d2) {
        return set((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), d2);
    }

    public Vector4d sub(Vector4fc vector4fc) {
        return sub(vector4fc, thisOrNew());
    }

    public Vector4d(Vector2dc vector2dc, double d2, double d3) {
        this(vector2dc.x(), vector2dc.y(), d2, d3);
    }

    public Vector4d div(double d2, Vector4d vector4d) {
        double d3 = 1.0d / d2;
        vector4d.x = this.x * d3;
        vector4d.y = this.y * d3;
        vector4d.z = this.z * d3;
        vector4d.w = this.w * d3;
        return vector4d;
    }

    public boolean equals(Vector4dc vector4dc, double d2) {
        if (this == vector4dc) {
            return true;
        }
        return vector4dc != null && Runtime.equals(this.x, vector4dc.x(), d2) && Runtime.equals(this.y, vector4dc.y(), d2) && Runtime.equals(this.z, vector4dc.z(), d2) && Runtime.equals(this.w, vector4dc.w(), d2);
    }

    public Vector4d fma(double d2, Vector4dc vector4dc, Vector4d vector4d) {
        vector4d.x = (vector4dc.x() * d2) + this.x;
        vector4d.y = (vector4dc.y() * d2) + this.y;
        vector4d.z = (vector4dc.z() * d2) + this.z;
        vector4d.w = (vector4dc.w() * d2) + this.w;
        return vector4d;
    }

    public Vector4d mul(Vector4fc vector4fc, Vector4d vector4d) {
        vector4d.x = this.x * ((double) vector4fc.x());
        vector4d.y = this.y * ((double) vector4fc.y());
        vector4d.z = this.z * ((double) vector4fc.z());
        vector4d.w = this.w * ((double) vector4fc.w());
        return vector4d;
    }

    public Vector4d normalize(double d2) {
        return normalize(d2, thisOrNew());
    }

    public Vector4d set(Vector2dc vector2dc, double d2, double d3) {
        return set(vector2dc.x(), vector2dc.y(), d2, d3);
    }

    public Vector4d sub(Vector4fc vector4fc, Vector4d vector4d) {
        vector4d.x = this.x - ((double) vector4fc.x());
        vector4d.y = this.y - ((double) vector4fc.y());
        vector4d.z = this.z - ((double) vector4fc.z());
        vector4d.w = this.w - ((double) vector4fc.w());
        return vector4d;
    }

    public Vector4d(Vector2ic vector2ic, double d2, double d3) {
        this((double) vector2ic.x(), (double) vector2ic.y(), d2, d3);
    }

    private Vector4d mulAffine(Matrix4fc matrix4fc, Vector4d vector4d) {
        double m30 = (((double) matrix4fc.m30()) * this.w) + (((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x);
        double m31 = (((double) matrix4fc.m31()) * this.w) + (((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x);
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x);
        double m32 = (double) matrix4fc.m32();
        double d2 = this.w;
        double d3 = (m32 * d2) + m22;
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = d3;
        vector4d.w = d2;
        return vector4d;
    }

    public Vector4d normalize(double d2, Vector4d vector4d) {
        double length = (1.0d / length()) * d2;
        vector4d.x = this.x * length;
        vector4d.y = this.y * length;
        vector4d.z = this.z * length;
        vector4d.w = this.w * length;
        return vector4d;
    }

    public Vector4d set(Vector2ic vector2ic, double d2, double d3) {
        return set((double) vector2ic.x(), (double) vector2ic.y(), d2, d3);
    }

    public Vector4d(double d2) {
        this(d2, d2, d2, d2);
    }

    private Vector4d mulGeneric(Matrix4fc matrix4fc, Vector4d vector4d) {
        double m30 = (((double) matrix4fc.m30()) * this.w) + (((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x);
        double m31 = (((double) matrix4fc.m31()) * this.w) + (((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x);
        double m32 = (((double) matrix4fc.m32()) * this.w) + (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x);
        double m33 = (((double) matrix4fc.m33()) * this.w) + (((double) matrix4fc.m23()) * this.z) + (((double) matrix4fc.m13()) * this.y) + (((double) matrix4fc.m03()) * this.x);
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = m32;
        vector4d.w = m33;
        return vector4d;
    }

    public Vector4d mulProject(Matrix4dc matrix4dc) {
        return mulProject(matrix4dc, thisOrNew());
    }

    public Vector4d set(double d2) {
        return set(d2, d2, d2, d2);
    }

    public Vector4d(Vector4fc vector4fc) {
        this((double) vector4fc.x(), (double) vector4fc.y(), (double) vector4fc.z(), (double) vector4fc.w());
    }

    public Vector4d add(double d2, double d3, double d4, double d5) {
        return add(d2, d3, d4, d5, thisOrNew());
    }

    public Vector4d set(Vector2fc vector2fc, double d2, double d3) {
        return set((double) vector2fc.x(), (double) vector2fc.y(), d2, d3);
    }

    public Vector4d(Vector3fc vector3fc, double d2) {
        this((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), d2);
    }

    public Vector4d add(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        vector4d.x = this.x + d2;
        vector4d.y = this.y + d3;
        vector4d.z = this.z + d4;
        vector4d.w = this.w + d5;
        return vector4d;
    }

    public boolean equals(double d2, double d3, double d4, double d5) {
        if (Double.doubleToLongBits(this.x) == Double.doubleToLongBits(d2) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(d3) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(d4) && Double.doubleToLongBits(this.w) == Double.doubleToLongBits(d5)) {
            return true;
        }
        return false;
    }

    public Vector4d mul(Matrix4dc matrix4dc) {
        return mul(matrix4dc, thisOrNew());
    }

    public Vector4d set(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        this.w = d5;
        return this;
    }

    public Vector4d sub(double d2, double d3, double d4, double d5) {
        return sub(d2, d3, d4, d5, thisOrNew());
    }

    public Vector4d(Vector2fc vector2fc, double d2, double d3) {
        this((double) vector2fc.x(), (double) vector2fc.y(), d2, d3);
    }

    public Vector4d mul(Matrix4dc matrix4dc, Vector4d vector4d) {
        if ((matrix4dc.properties() & 2) != 0) {
            return mulAffine(matrix4dc, vector4d);
        }
        return mulGeneric(matrix4dc, vector4d);
    }

    public Vector4d sub(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        vector4d.x = this.x - d2;
        vector4d.y = this.y - d3;
        vector4d.z = this.z - d4;
        vector4d.w = this.w - d5;
        return vector4d;
    }

    public Vector4d(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        this.w = d5;
    }

    public Vector4d add(Vector4fc vector4fc) {
        return add(vector4fc, thisOrNew());
    }

    public Vector4d mul(Matrix4x3dc matrix4x3dc) {
        return mul(matrix4x3dc, thisOrNew());
    }

    public Vector4d set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector4d mul(Matrix4x3dc matrix4x3dc, Vector4d vector4d) {
        double m30 = (matrix4x3dc.m30() * this.w) + (matrix4x3dc.m20() * this.z) + (matrix4x3dc.m10() * this.y) + (matrix4x3dc.m00() * this.x);
        double m31 = (matrix4x3dc.m31() * this.w) + (matrix4x3dc.m21() * this.z) + (matrix4x3dc.m11() * this.y) + (matrix4x3dc.m01() * this.x);
        double m22 = (matrix4x3dc.m22() * this.z) + (matrix4x3dc.m12() * this.y) + (matrix4x3dc.m02() * this.x);
        double m32 = matrix4x3dc.m32();
        double d2 = this.w;
        double d3 = (m32 * d2) + m22;
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = d3;
        vector4d.w = d2;
        return vector4d;
    }

    public Vector4d set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector4d set(DoubleBuffer doubleBuffer) {
        return set(doubleBuffer.position(), doubleBuffer);
    }

    public Vector4d(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector4d set(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
        return this;
    }

    public Vector4d(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector4d(DoubleBuffer doubleBuffer) {
        this(doubleBuffer.position(), doubleBuffer);
    }

    public Vector4d(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
    }

    public Vector4d mul(Matrix4x3fc matrix4x3fc) {
        return mul(matrix4x3fc, thisOrNew());
    }

    public Vector4d mul(Matrix4x3fc matrix4x3fc, Vector4d vector4d) {
        double m30 = (((double) matrix4x3fc.m30()) * this.w) + (((double) matrix4x3fc.m20()) * this.z) + (((double) matrix4x3fc.m10()) * this.y) + (((double) matrix4x3fc.m00()) * this.x);
        double m31 = (((double) matrix4x3fc.m31()) * this.w) + (((double) matrix4x3fc.m21()) * this.z) + (((double) matrix4x3fc.m11()) * this.y) + (((double) matrix4x3fc.m01()) * this.x);
        double m22 = (((double) matrix4x3fc.m22()) * this.z) + (((double) matrix4x3fc.m12()) * this.y) + (((double) matrix4x3fc.m02()) * this.x);
        double m32 = (double) matrix4x3fc.m32();
        double d2 = this.w;
        double d3 = (m32 * d2) + m22;
        vector4d.x = m30;
        vector4d.y = m31;
        vector4d.z = d3;
        vector4d.w = d2;
        return vector4d;
    }

    public Vector4d mul(Matrix4fc matrix4fc) {
        return mul(matrix4fc, thisOrNew());
    }

    public Vector4d mul(Matrix4fc matrix4fc, Vector4d vector4d) {
        if ((matrix4fc.properties() & 2) != 0) {
            return mulAffine(matrix4fc, vector4d);
        }
        return mulGeneric(matrix4fc, vector4d);
    }

    public Vector4d mul(double d2) {
        return mul(d2, thisOrNew());
    }

    public Vector4d mul(double d2, Vector4d vector4d) {
        vector4d.x = this.x * d2;
        vector4d.y = this.y * d2;
        vector4d.z = this.z * d2;
        vector4d.w = this.w * d2;
        return vector4d;
    }
}
