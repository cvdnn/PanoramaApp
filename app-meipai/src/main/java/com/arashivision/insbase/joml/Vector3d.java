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

public class Vector3d implements Externalizable, Vector3dc {
    public static final long serialVersionUID = 1;
    public double x;
    public double y;
    public double z;

    public Vector3d() {
    }

    public static double distanceSquared(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d4 - d7;
        return (d10 * d10) + (d9 * d9) + (d8 * d8);
    }

    public static double lengthSquared(double d2, double d3, double d4) {
        return (d4 * d4) + (d3 * d3) + (d2 * d2);
    }

    private Vector3d thisOrNew() {
        return this;
    }

    public Vector3d absolute() {
        return absolute(thisOrNew());
    }

    public Vector3d add(Vector3dc vector3dc) {
        return add(vector3dc, thisOrNew());
    }

    public double angle(Vector3dc vector3dc) {
        double angleCos = angleCos(vector3dc);
        if (angleCos >= 1.0d) {
            angleCos = 1.0d;
        }
        if (angleCos <= -1.0d) {
            angleCos = -1.0d;
        }
        return Math.acos(angleCos);
    }

    public double angleCos(Vector3dc vector3dc) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double z2 = (vector3dc.z() * vector3dc.z()) + (vector3dc.y() * vector3dc.y()) + (vector3dc.x() * vector3dc.x());
        return ((vector3dc.z() * this.z) + ((vector3dc.y() * this.y) + (vector3dc.x() * this.x))) / Math.sqrt(d7 * z2);
    }

    public Vector3d ceil() {
        return ceil(thisOrNew());
    }

    public Vector3d cross(Vector3dc vector3dc) {
        return cross(vector3dc, thisOrNew());
    }

    public double distance(Vector3dc vector3dc) {
        return distance(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public double distanceSquared(Vector3dc vector3dc) {
        return distanceSquared(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3d div(Vector3d vector3d) {
        return div((Vector3dc) vector3d, thisOrNew());
    }

    public double dot(Vector3dc vector3dc) {
        return dot(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector3d.class != obj.getClass()) {
            return false;
        }
        Vector3d vector3d = (Vector3d) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(vector3d.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(vector3d.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(vector3d.z);
    }

    public Vector3d floor() {
        return floor(thisOrNew());
    }

    public Vector3d fma(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return fma(vector3dc, vector3dc2, thisOrNew());
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector3d half(Vector3dc vector3dc) {
        return half(vector3dc, thisOrNew());
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.z);
        return (i3 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public Vector3d hermite(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double d5 = this.x;
        double x2 = ((((((vector3dc2.x() * 3.0d) - (this.x * 3.0d)) - vector3dc.x()) - vector3dc.x()) - vector3dc3.x()) * d3) + ((vector3dc.x() + vector3dc3.x() + (((d5 + d5) - vector3dc2.x()) - vector3dc2.x())) * d4);
        double d6 = this.x;
        vector3d2.x = a.i(d6, d2, x2, d6);
        double d7 = this.y;
        double y2 = ((((((vector3dc2.y() * 3.0d) - (this.y * 3.0d)) - vector3dc.y()) - vector3dc.y()) - vector3dc3.y()) * d3) + ((vector3dc.y() + vector3dc3.y() + (((d7 + d7) - vector3dc2.y()) - vector3dc2.y())) * d4);
        double d8 = this.y;
        vector3d2.y = a.i(d8, d2, y2, d8);
        double d9 = this.z;
        double z2 = ((((((vector3dc2.z() * 3.0d) - (this.z * 3.0d)) - vector3dc.z()) - vector3dc.z()) - vector3dc3.z()) * d3) + ((vector3dc.z() + vector3dc3.z() + (((d9 + d9) - vector3dc2.z()) - vector3dc2.z())) * d4);
        double d10 = this.z;
        vector3d2.z = a.i(d10, d2, z2, d10);
        return vector3d2;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return lengthSquared(this.x, this.y, this.z);
    }

    public Vector3d lerp(Vector3dc vector3dc, double d2) {
        return lerp(vector3dc, d2, thisOrNew());
    }

    public Vector3d max(Vector3dc vector3dc) {
        return max(vector3dc, thisOrNew());
    }

    public int maxComponent() {
        double abs = Math.abs(this.x);
        double abs2 = Math.abs(this.y);
        double abs3 = Math.abs(this.z);
        if (abs < abs2 || abs < abs3) {
            return abs2 >= abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3d min(Vector3dc vector3dc) {
        return min(vector3dc, thisOrNew());
    }

    public int minComponent() {
        double abs = Math.abs(this.x);
        double abs2 = Math.abs(this.y);
        double abs3 = Math.abs(this.z);
        if (abs >= abs2 || abs >= abs3) {
            return abs2 < abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3d mul(Vector3dc vector3dc) {
        return mul(vector3dc, thisOrNew());
    }

    public Vector3d mulDirection(Matrix4fc matrix4fc) {
        return mulDirection(matrix4fc, thisOrNew());
    }

    public Vector3d mulPosition(Matrix4fc matrix4fc) {
        return mulPosition(matrix4fc, thisOrNew());
    }

    public double mulPositionW(Matrix4fc matrix4fc) {
        return mulPositionW(matrix4fc, thisOrNew());
    }

    public Vector3d mulProject(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m33 = 1.0d / (matrix4dc.m33() + ((matrix4dc.m23() * this.z) + ((matrix4dc.m13() * this.y) + (matrix4dc.m03() * this.x))));
        double m30 = (matrix4dc.m30() + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x)) * m33;
        double m31 = (matrix4dc.m31() + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x)) * m33;
        double m32 = (matrix4dc.m32() + (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x)) * m33;
        vector3d.x = m30;
        vector3d.y = m31;
        vector3d.z = m32;
        return vector3d;
    }

    public Vector3d mulTranspose(Matrix3dc matrix3dc) {
        return mulTranspose(matrix3dc, thisOrNew());
    }

    public Vector3d mulTransposeDirection(Matrix4dc matrix4dc) {
        return mulTransposeDirection(matrix4dc, thisOrNew());
    }

    public Vector3d mulTransposePosition(Matrix4dc matrix4dc) {
        return mulTransposePosition(matrix4dc, thisOrNew());
    }

    public Vector3d negate() {
        return negate(thisOrNew());
    }

    public Vector3d normalize() {
        return normalize(thisOrNew());
    }

    public Vector3d orthogonalize(Vector3dc vector3dc, Vector3d vector3d) {
        double d2;
        double d3;
        Vector3d vector3d2 = vector3d;
        double d4 = 0.0d;
        if (Math.abs(vector3dc.x()) > Math.abs(vector3dc.z())) {
            double d5 = -vector3dc.y();
            d3 = vector3dc.x();
            d2 = 0.0d;
            d4 = d5;
        } else {
            d3 = -vector3dc.z();
            d2 = vector3dc.y();
        }
        double d6 = d3;
        double e2 = a.e(d2, d2, (d6 * d6) + (d4 * d4), 1.0d);
        vector3d2.x = d4 * e2;
        vector3d2.y = d6 * e2;
        vector3d2.z = d2 * e2;
        return vector3d2;
    }

    public Vector3d orthogonalizeUnit(Vector3dc vector3dc, Vector3d vector3d) {
        return orthogonalize(vector3dc, vector3d);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readDouble();
        this.y = objectInput.readDouble();
        this.z = objectInput.readDouble();
    }

    public Vector3d reflect(Vector3dc vector3dc) {
        return reflect(vector3dc, thisOrNew());
    }

    public Vector3d rotate(Quaterniondc quaterniondc) {
        return quaterniondc.transform((Vector3dc) this, thisOrNew());
    }

    public Vector3d rotateAxis(double d2, double d3, double d4, double d5) {
        return rotateAxis(d2, d3, d4, d5, thisOrNew());
    }

    public Vector3d rotateX(double d2) {
        return rotateX(d2, thisOrNew());
    }

    public Vector3d rotateY(double d2) {
        return rotateY(d2, thisOrNew());
    }

    public Vector3d rotateZ(double d2) {
        return rotateZ(d2, thisOrNew());
    }

    public Quaterniond rotationTo(Vector3dc vector3dc, Quaterniond quaterniond) {
        return quaterniond.rotationTo(this, vector3dc);
    }

    public Vector3d round() {
        return round(thisOrNew());
    }

    public Vector3d set(Vector3dc vector3dc) {
        return set(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3d setComponent(int i2, double d2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = d2;
        } else if (i2 == 1) {
            this.y = d2;
        } else if (i2 == 2) {
            this.z = d2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector3d smoothStep(Vector3dc vector3dc, double d2, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d3 = d2 * d2;
        double d4 = d3 * d2;
        double d5 = this.x;
        double x2 = (((d5 + d5) - vector3dc.x()) - vector3dc.x()) * d4;
        double x3 = vector3dc.x() * 3.0d;
        double d6 = this.x;
        double d7 = d3;
        vector3d2.x = a.i(d6, d2, a.a(d6, 3.0d, x3, d7, x2), d6);
        double d8 = this.y;
        double y2 = (((d8 + d8) - vector3dc.y()) - vector3dc.y()) * d4;
        double y3 = vector3dc.y() * 3.0d;
        double d9 = this.y;
        vector3d2.y = a.i(d9, d2, a.a(d9, 3.0d, y3, d7, y2), d9);
        double d10 = this.z;
        double z2 = (((d10 + d10) - vector3dc.z()) - vector3dc.z()) * d4;
        double z3 = vector3dc.z() * 3.0d;
        double d11 = this.z;
        vector3d2.z = a.i(d11, d2, a.a(d11, 3.0d, z3, d7, z2), d11);
        return vector3d2;
    }

    public Vector3d sub(Vector3dc vector3dc) {
        return sub(vector3dc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.x);
        objectOutput.writeDouble(this.y);
        objectOutput.writeDouble(this.z);
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

    public Vector3d zero() {
        return thisOrNew().set(0.0d, 0.0d, 0.0d);
    }

    public Vector3d(double d2) {
        this(d2, d2, d2);
    }

    public static double length(double d2, double d3, double d4) {
        return Math.sqrt(lengthSquared(d2, d3, d4));
    }

    public Vector3d absolute(Vector3d vector3d) {
        vector3d.x = Math.abs(this.x);
        vector3d.y = Math.abs(this.y);
        vector3d.z = Math.abs(this.z);
        return vector3d;
    }

    public Vector3d add(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = vector3dc.x() + this.x;
        vector3d.y = vector3dc.y() + this.y;
        vector3d.z = vector3dc.z() + this.z;
        return vector3d;
    }

    public Vector3d ceil(Vector3d vector3d) {
        vector3d.x = Math.ceil(this.x);
        vector3d.y = Math.ceil(this.y);
        vector3d.z = Math.ceil(this.z);
        return vector3d;
    }

    public Vector3d cross(double d2, double d3, double d4) {
        return cross(d2, d3, d4, thisOrNew());
    }

    public double distance(double d2, double d3, double d4) {
        return Math.sqrt(distanceSquared(d2, d3, d4));
    }

    public double distanceSquared(double d2, double d3, double d4) {
        double d5 = this.x - d2;
        double d6 = this.y - d3;
        double d7 = this.z - d4;
        return (d7 * d7) + (d6 * d6) + (d5 * d5);
    }

    public Vector3d div(Vector3fc vector3fc) {
        return div(vector3fc, thisOrNew());
    }

    public double dot(double d2, double d3, double d4) {
        return (this.z * d4) + (this.y * d3) + (this.x * d2);
    }

    public Vector3d floor(Vector3d vector3d) {
        vector3d.x = Math.floor(this.x);
        vector3d.y = Math.floor(this.y);
        vector3d.z = Math.floor(this.z);
        return vector3d;
    }

    public Vector3d fma(double d2, Vector3dc vector3dc) {
        return fma(d2, vector3dc, thisOrNew());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector3d half(double d2, double d3, double d4) {
        return half(d2, d3, d4, thisOrNew());
    }

    public Vector3d lerp(Vector3dc vector3dc, double d2, Vector3d vector3d) {
        vector3d.x = a.h(vector3dc.x(), this.x, d2, this.x);
        double d3 = d2;
        vector3d.y = a.h(vector3dc.y(), this.y, d3, this.y);
        vector3d.z = a.h(vector3dc.z(), this.z, d3, this.z);
        return vector3d;
    }

    public Vector3d max(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = this.x > vector3dc.x() ? this.x : vector3dc.x();
        vector3d.y = this.y > vector3dc.y() ? this.y : vector3dc.y();
        vector3d.z = this.z > vector3dc.z() ? this.z : vector3dc.z();
        return vector3d;
    }

    public Vector3d min(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = this.x < vector3dc.x() ? this.x : vector3dc.x();
        vector3d.y = this.y < vector3dc.y() ? this.y : vector3dc.y();
        vector3d.z = this.z < vector3dc.z() ? this.z : vector3dc.z();
        return vector3d;
    }

    public Vector3d mul(Vector3fc vector3fc) {
        return mul(vector3fc, thisOrNew());
    }

    public Vector3d mulDirection(Matrix4dc matrix4dc) {
        return mulDirection(matrix4dc, thisOrNew());
    }

    public Vector3d mulPosition(Matrix4dc matrix4dc) {
        return mulPosition(matrix4dc, thisOrNew());
    }

    public double mulPositionW(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m23 = (((double) matrix4fc.m23()) * this.z) + (((double) matrix4fc.m13()) * this.y) + (((double) matrix4fc.m03()) * this.x) + ((double) matrix4fc.m33());
        double m20 = (((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x) + ((double) matrix4fc.m30());
        double m21 = (((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x) + ((double) matrix4fc.m31());
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x) + ((double) matrix4fc.m32());
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return m23;
    }

    public Vector3d mulTranspose(Matrix3dc matrix3dc, Vector3d vector3d) {
        double m02 = (matrix3dc.m02() * this.z) + (matrix3dc.m01() * this.y) + (matrix3dc.m00() * this.x);
        double m12 = (matrix3dc.m12() * this.z) + (matrix3dc.m11() * this.y) + (matrix3dc.m10() * this.x);
        double m22 = (matrix3dc.m22() * this.z) + (matrix3dc.m21() * this.y) + (matrix3dc.m20() * this.x);
        vector3d.x = m02;
        vector3d.y = m12;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulTransposeDirection(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m02 = (matrix4dc.m02() * this.z) + (matrix4dc.m01() * this.y) + (matrix4dc.m00() * this.x);
        double m12 = (matrix4dc.m12() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m10() * this.x);
        double m22 = (matrix4dc.m22() * this.z) + (matrix4dc.m21() * this.y) + (matrix4dc.m20() * this.x);
        vector3d.x = m02;
        vector3d.y = m12;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulTransposePosition(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m03 = matrix4dc.m03() + (matrix4dc.m02() * this.z) + (matrix4dc.m01() * this.y) + (matrix4dc.m00() * this.x);
        double m13 = matrix4dc.m13() + (matrix4dc.m12() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m10() * this.x);
        double m23 = matrix4dc.m23() + (matrix4dc.m22() * this.z) + (matrix4dc.m21() * this.y) + (matrix4dc.m20() * this.x);
        vector3d.x = m03;
        vector3d.y = m13;
        vector3d.z = m23;
        return vector3d;
    }

    public Vector3d negate(Vector3d vector3d) {
        vector3d.x = -this.x;
        vector3d.y = -this.y;
        vector3d.z = -this.z;
        return vector3d;
    }

    public Vector3d normalize(Vector3d vector3d) {
        double length = 1.0d / length();
        vector3d.x = this.x * length;
        vector3d.y = this.y * length;
        vector3d.z = this.z * length;
        return vector3d;
    }

    public Vector3d orthogonalizeUnit(Vector3dc vector3dc) {
        return orthogonalizeUnit(vector3dc, thisOrNew());
    }

    public Vector3d reflect(double d2, double d3, double d4) {
        return reflect(d2, d3, d4, thisOrNew());
    }

    public Vector3d rotate(Quaterniondc quaterniondc, Vector3d vector3d) {
        return quaterniondc.transform((Vector3dc) this, vector3d);
    }

    public Vector3d rotateAxis(double d2, double d3, double d4, double d5, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
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
        Vector3d vector3d3 = vector3d;
        vector3d3.x = d31;
        vector3d3.y = d33;
        vector3d3.z = d35;
        return vector3d3;
    }

    public Vector3d rotateX(double d2, Vector3d vector3d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.y;
        double d4 = d3 * cosFromSin;
        double d5 = this.z;
        double d6 = d4 - (d5 * sin);
        double d7 = (d5 * cosFromSin) + (d3 * sin);
        vector3d.x = this.x;
        vector3d.y = d6;
        vector3d.z = d7;
        return vector3d;
    }

    public Vector3d rotateY(double d2, Vector3d vector3d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.x;
        double d4 = d3 * cosFromSin;
        double d5 = this.z;
        double d6 = (d5 * cosFromSin) + ((-d3) * sin);
        vector3d.x = (d5 * sin) + d4;
        vector3d.y = this.y;
        vector3d.z = d6;
        return vector3d;
    }

    public Vector3d rotateZ(double d2, Vector3d vector3d) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.x;
        double d4 = d3 * cosFromSin;
        double d5 = this.y;
        double d6 = (d5 * cosFromSin) + (d3 * sin);
        vector3d.x = d4 - (d5 * sin);
        vector3d.y = d6;
        vector3d.z = this.z;
        return vector3d;
    }

    public Quaterniond rotationTo(double d2, double d3, double d4, Quaterniond quaterniond) {
        return quaterniond.rotationTo(this.x, this.y, this.z, d2, d3, d4);
    }

    public Vector3d round(Vector3d vector3d) {
        vector3d.x = (double) Math.round(this.x);
        vector3d.y = (double) Math.round(this.y);
        vector3d.z = (double) Math.round(this.z);
        return vector3d;
    }

    public Vector3d set(Vector3ic vector3ic) {
        return set((double) vector3ic.x(), (double) vector3ic.y(), (double) vector3ic.z());
    }

    public Vector3d sub(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = this.x - vector3dc.x();
        vector3d.y = this.y - vector3dc.y();
        vector3d.z = this.z - vector3dc.z();
        return vector3d;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.x, a2, str);
        a.b(numberFormat, this.y, a2, str);
        return a.a(numberFormat, this.z, a2, ")");
    }

    public Vector3d(double d2, double d3, double d4) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
    }

    public static double distance(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.sqrt(distanceSquared(d2, d3, d4, d5, d6, d7));
    }

    public Vector3d cross(Vector3dc vector3dc, Vector3d vector3d) {
        double z2 = (vector3dc.z() * this.y) - (vector3dc.y() * this.z);
        double x2 = (vector3dc.x() * this.z) - (vector3dc.z() * this.x);
        double y2 = (vector3dc.y() * this.x) - (vector3dc.x() * this.y);
        vector3d.x = z2;
        vector3d.y = x2;
        vector3d.z = y2;
        return vector3d;
    }

    public Vector3d div(Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = this.x / ((double) vector3fc.x());
        vector3d.y = this.y / ((double) vector3fc.y());
        vector3d.z = this.z / ((double) vector3fc.z());
        return vector3d;
    }

    public Vector3d fma(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return fma(vector3fc, vector3fc2, thisOrNew());
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public Vector3d half(Vector3dc vector3dc, Vector3d vector3d) {
        return half(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3d);
    }

    public Vector3d mul(Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = this.x * ((double) vector3fc.x());
        vector3d.y = this.y * ((double) vector3fc.y());
        vector3d.z = this.z * ((double) vector3fc.z());
        return vector3d;
    }

    public Vector3d mulDirection(Matrix4x3dc matrix4x3dc) {
        return mulDirection(matrix4x3dc, thisOrNew());
    }

    public Vector3d mulPosition(Matrix4x3dc matrix4x3dc) {
        return mulPosition(matrix4x3dc, thisOrNew());
    }

    public Vector3d reflect(Vector3dc vector3dc, Vector3d vector3d) {
        return reflect(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3d);
    }

    public Vector3d set(Vector2dc vector2dc, double d2) {
        return set(vector2dc.x(), vector2dc.y(), d2);
    }

    public Vector3d fma(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3d vector3d) {
        vector3d.x = this.x + ((double) (vector3fc2.x() * vector3fc.x()));
        vector3d.y = this.y + ((double) (vector3fc2.y() * vector3fc.y()));
        vector3d.z = this.z + ((double) (vector3fc2.z() * vector3fc.z()));
        return vector3d;
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Vector3d half(double d2, double d3, double d4, Vector3d vector3d) {
        return vector3d.set((Vector3dc) this).add(d2, d3, d4).normalize();
    }

    public Vector3d mulDirection(Matrix4x3fc matrix4x3fc) {
        return mulDirection(matrix4x3fc, thisOrNew());
    }

    public Vector3d mulPosition(Matrix4x3fc matrix4x3fc) {
        return mulPosition(matrix4x3fc, thisOrNew());
    }

    public Vector3d reflect(double d2, double d3, double d4, Vector3d vector3d) {
        double dot = dot(d2, d3, d4);
        double d5 = dot + dot;
        vector3d.x = this.x - (d2 * d5);
        vector3d.y = this.y - (d3 * d5);
        vector3d.z = this.z - (d5 * d4);
        return vector3d;
    }

    public Vector3d set(Vector2ic vector2ic, double d2) {
        return set((double) vector2ic.x(), (double) vector2ic.y(), d2);
    }

    public Vector3d add(Vector3fc vector3fc) {
        return add(vector3fc, thisOrNew());
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
        throw new IllegalArgumentException();
    }

    public Vector3d mulDirection(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m20 = (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x);
        double m21 = (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x);
        double m22 = (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulPosition(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m30 = matrix4dc.m30() + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x);
        double m31 = matrix4dc.m31() + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x);
        double m32 = matrix4dc.m32() + (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x);
        vector3d.x = m30;
        vector3d.y = m31;
        vector3d.z = m32;
        return vector3d;
    }

    public Vector3d set(Vector3fc vector3fc) {
        return set((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Vector3d sub(Vector3fc vector3fc) {
        return sub(vector3fc, thisOrNew());
    }

    public Vector3d add(Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = this.x + ((double) vector3fc.x());
        vector3d.y = this.y + ((double) vector3fc.y());
        vector3d.z = this.z + ((double) vector3fc.z());
        return vector3d;
    }

    public Vector3d div(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = this.x / vector3dc.x();
        vector3d.y = this.y / vector3dc.y();
        vector3d.z = this.z / vector3dc.z();
        return vector3d;
    }

    public boolean equals(Vector3dc vector3dc, double d2) {
        if (this == vector3dc) {
            return true;
        }
        return vector3dc != null && Runtime.equals(this.x, vector3dc.x(), d2) && Runtime.equals(this.y, vector3dc.y(), d2) && Runtime.equals(this.z, vector3dc.z(), d2);
    }

    public Vector3d mul(Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = vector3dc.x() * this.x;
        vector3d.y = vector3dc.y() * this.y;
        vector3d.z = vector3dc.z() * this.z;
        return vector3d;
    }

    public Vector3d normalize(double d2) {
        return normalize(d2, thisOrNew());
    }

    public Vector3d set(Vector2fc vector2fc, double d2) {
        return set((double) vector2fc.x(), (double) vector2fc.y(), d2);
    }

    public Vector3d sub(Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = this.x - ((double) vector3fc.x());
        vector3d.y = this.y - ((double) vector3fc.y());
        vector3d.z = this.z - ((double) vector3fc.z());
        return vector3d;
    }

    public Vector3d(Vector3fc vector3fc) {
        this((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Vector3d fma(double d2, Vector3fc vector3fc) {
        return fma(d2, vector3fc, thisOrNew());
    }

    public Vector3d normalize(double d2, Vector3d vector3d) {
        double length = (1.0d / length()) * d2;
        vector3d.x = this.x * length;
        vector3d.y = this.y * length;
        vector3d.z = this.z * length;
        return vector3d;
    }

    public Vector3d set(double d2) {
        return set(d2, d2, d2);
    }

    public Vector3d(Vector3ic vector3ic) {
        this((double) vector3ic.x(), (double) vector3ic.y(), (double) vector3ic.z());
    }

    public Vector3d fma(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d) {
        vector3d.x = (vector3dc2.x() * vector3dc.x()) + this.x;
        vector3d.y = (vector3dc2.y() * vector3dc.y()) + this.y;
        vector3d.z = (vector3dc2.z() * vector3dc.z()) + this.z;
        return vector3d;
    }

    public Vector3d mulProject(Matrix4dc matrix4dc) {
        return mulProject(matrix4dc, thisOrNew());
    }

    public Vector3d mulTranspose(Matrix3fc matrix3fc) {
        return mulTranspose(matrix3fc, thisOrNew());
    }

    public Vector3d mulTransposeDirection(Matrix4fc matrix4fc) {
        return mulTransposeDirection(matrix4fc, thisOrNew());
    }

    public Vector3d mulTransposePosition(Matrix4fc matrix4fc) {
        return mulTransposePosition(matrix4fc, thisOrNew());
    }

    public Vector3d set(double d2, double d3, double d4) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        return this;
    }

    public Vector3d(Vector2fc vector2fc, double d2) {
        this((double) vector2fc.x(), (double) vector2fc.y(), d2);
    }

    public Vector3d add(double d2, double d3, double d4) {
        return add(d2, d3, d4, thisOrNew());
    }

    public Vector3d cross(double d2, double d3, double d4, Vector3d vector3d) {
        double d5 = this.y;
        double d6 = d5 * d4;
        double d7 = this.z;
        double d8 = d6 - (d7 * d3);
        double d9 = d7 * d2;
        double d10 = this.x;
        double d11 = d9 - (d4 * d10);
        double d12 = (d10 * d3) - (d5 * d2);
        vector3d.x = d8;
        vector3d.y = d11;
        vector3d.z = d12;
        return vector3d;
    }

    public Vector3d div(double d2) {
        return div(d2, thisOrNew());
    }

    public boolean equals(double d2, double d3, double d4) {
        if (Double.doubleToLongBits(this.x) == Double.doubleToLongBits(d2) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(d3) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(d4)) {
            return true;
        }
        return false;
    }

    public Vector3d mul(Matrix3fc matrix3fc) {
        return mul(matrix3fc, thisOrNew());
    }

    public double mulPositionW(Matrix4dc matrix4dc) {
        return mulPositionW(matrix4dc, thisOrNew());
    }

    public Vector3d mulProject(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m23 = 1.0d / (((((double) matrix4fc.m23()) * this.z) + ((((double) matrix4fc.m13()) * this.y) + (((double) matrix4fc.m03()) * this.x))) + ((double) matrix4fc.m33()));
        double m20 = ((((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x) + ((double) matrix4fc.m30())) * m23;
        double m21 = ((((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x) + ((double) matrix4fc.m31())) * m23;
        double m22 = ((((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x) + ((double) matrix4fc.m32())) * m23;
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulTranspose(Matrix3fc matrix3fc, Vector3d vector3d) {
        double m02 = (((double) matrix3fc.m02()) * this.z) + (((double) matrix3fc.m01()) * this.y) + (((double) matrix3fc.m00()) * this.x);
        double m12 = (((double) matrix3fc.m12()) * this.z) + (((double) matrix3fc.m11()) * this.y) + (((double) matrix3fc.m10()) * this.x);
        double m22 = (((double) matrix3fc.m22()) * this.z) + (((double) matrix3fc.m21()) * this.y) + (((double) matrix3fc.m20()) * this.x);
        vector3d.x = m02;
        vector3d.y = m12;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulTransposeDirection(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m02 = (((double) matrix4fc.m02()) * this.z) + (((double) matrix4fc.m01()) * this.y) + (((double) matrix4fc.m00()) * this.x);
        double m12 = (((double) matrix4fc.m12()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m10()) * this.x);
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m21()) * this.y) + (((double) matrix4fc.m20()) * this.x);
        vector3d.x = m02;
        vector3d.y = m12;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulTransposePosition(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m02 = (((double) matrix4fc.m02()) * this.z) + (((double) matrix4fc.m01()) * this.y) + (((double) matrix4fc.m00()) * this.x) + ((double) matrix4fc.m03());
        double m12 = (((double) matrix4fc.m12()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m10()) * this.x) + ((double) matrix4fc.m13());
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m21()) * this.y) + (((double) matrix4fc.m20()) * this.x) + ((double) matrix4fc.m23());
        vector3d.x = m02;
        vector3d.y = m12;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d orthogonalize(Vector3dc vector3dc) {
        return orthogonalize(vector3dc, thisOrNew());
    }

    public Vector3d sub(double d2, double d3, double d4) {
        return sub(d2, d3, d4, thisOrNew());
    }

    public Vector3d(Vector2ic vector2ic, double d2) {
        this((double) vector2ic.x(), (double) vector2ic.y(), d2);
    }

    public Vector3d add(double d2, double d3, double d4, Vector3d vector3d) {
        vector3d.x = this.x + d2;
        vector3d.y = this.y + d3;
        vector3d.z = this.z + d4;
        return vector3d;
    }

    public Vector3d div(double d2, Vector3d vector3d) {
        double d3 = 1.0d / d2;
        vector3d.x = this.x * d3;
        vector3d.y = this.y * d3;
        vector3d.z = this.z * d3;
        return vector3d;
    }

    public Vector3d mul(Matrix3dc matrix3dc) {
        return mul(matrix3dc, thisOrNew());
    }

    public double mulPositionW(Matrix4dc matrix4dc, Vector3d vector3d) {
        double m33 = matrix4dc.m33() + (matrix4dc.m23() * this.z) + (matrix4dc.m13() * this.y) + (matrix4dc.m03() * this.x);
        double m30 = matrix4dc.m30() + (matrix4dc.m20() * this.z) + (matrix4dc.m10() * this.y) + (matrix4dc.m00() * this.x);
        double m31 = matrix4dc.m31() + (matrix4dc.m21() * this.z) + (matrix4dc.m11() * this.y) + (matrix4dc.m01() * this.x);
        double m32 = matrix4dc.m32() + (matrix4dc.m22() * this.z) + (matrix4dc.m12() * this.y) + (matrix4dc.m02() * this.x);
        vector3d.x = m30;
        vector3d.y = m31;
        vector3d.z = m32;
        return m33;
    }

    public Vector3d sub(double d2, double d3, double d4, Vector3d vector3d) {
        vector3d.x = this.x - d2;
        vector3d.y = this.y - d3;
        vector3d.z = this.z - d4;
        return vector3d;
    }

    public Vector3d(Vector3dc vector3dc) {
        this(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3d fma(double d2, Vector3dc vector3dc, Vector3d vector3d) {
        vector3d.x = (vector3dc.x() * d2) + this.x;
        vector3d.y = (vector3dc.y() * d2) + this.y;
        vector3d.z = (vector3dc.z() * d2) + this.z;
        return vector3d;
    }

    public Vector3d mul(Matrix3dc matrix3dc, Vector3d vector3d) {
        double m20 = (matrix3dc.m20() * this.z) + (matrix3dc.m10() * this.y) + (matrix3dc.m00() * this.x);
        double m21 = (matrix3dc.m21() * this.z) + (matrix3dc.m11() * this.y) + (matrix3dc.m01() * this.x);
        double m22 = (matrix3dc.m22() * this.z) + (matrix3dc.m12() * this.y) + (matrix3dc.m02() * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulDirection(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m20 = (((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x);
        double m21 = (((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x);
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulPosition(Matrix4fc matrix4fc, Vector3d vector3d) {
        double m20 = (((double) matrix4fc.m20()) * this.z) + (((double) matrix4fc.m10()) * this.y) + (((double) matrix4fc.m00()) * this.x) + ((double) matrix4fc.m30());
        double m21 = (((double) matrix4fc.m21()) * this.z) + (((double) matrix4fc.m11()) * this.y) + (((double) matrix4fc.m01()) * this.x) + ((double) matrix4fc.m31());
        double m22 = (((double) matrix4fc.m22()) * this.z) + (((double) matrix4fc.m12()) * this.y) + (((double) matrix4fc.m02()) * this.x) + ((double) matrix4fc.m32());
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector3d(Vector2dc vector2dc, double d2) {
        this(vector2dc.x(), vector2dc.y(), d2);
    }

    public Vector3d set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector3d(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector3d div(double d2, double d3, double d4) {
        return div(d2, d3, d4, thisOrNew());
    }

    public Vector3d set(DoubleBuffer doubleBuffer) {
        return set(doubleBuffer.position(), doubleBuffer);
    }

    public Vector3d(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector3d div(double d2, double d3, double d4, Vector3d vector3d) {
        vector3d.x = this.x / d2;
        vector3d.y = this.y / d3;
        vector3d.z = this.z / d4;
        return vector3d;
    }

    public Vector3d fma(Vector3dc vector3dc, Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = (vector3dc.x() * ((double) vector3fc.x())) + this.x;
        vector3d.y = (vector3dc.y() * ((double) vector3fc.y())) + this.y;
        vector3d.z = (vector3dc.z() * ((double) vector3fc.z())) + this.z;
        return vector3d;
    }

    public Vector3d set(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
        return this;
    }

    public Vector3d(DoubleBuffer doubleBuffer) {
        this(doubleBuffer.position(), doubleBuffer);
    }

    public Vector3d mulProject(Matrix4fc matrix4fc) {
        return mulProject(matrix4fc, thisOrNew());
    }

    public Vector3d(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, i2, doubleBuffer);
    }

    public Vector3d fma(double d2, Vector3fc vector3fc, Vector3d vector3d) {
        vector3d.x = (((double) vector3fc.x()) * d2) + this.x;
        vector3d.y = (((double) vector3fc.y()) * d2) + this.y;
        vector3d.z = (d2 * ((double) vector3fc.z())) + this.z;
        return vector3d;
    }

    public Vector3f mul(Matrix3dc matrix3dc, Vector3f vector3f) {
        double m20 = (matrix3dc.m20() * this.z) + (matrix3dc.m10() * this.y) + (matrix3dc.m00() * this.x);
        double m21 = (matrix3dc.m21() * this.z) + (matrix3dc.m11() * this.y) + (matrix3dc.m01() * this.x);
        double m22 = (matrix3dc.m22() * this.z) + (matrix3dc.m12() * this.y) + (matrix3dc.m02() * this.x);
        vector3f.x = (float) m20;
        vector3f.y = (float) m21;
        vector3f.z = (float) m22;
        return vector3f;
    }

    public Vector3d mulDirection(Matrix4x3dc matrix4x3dc, Vector3d vector3d) {
        double m20 = (matrix4x3dc.m20() * this.z) + (matrix4x3dc.m10() * this.y) + (matrix4x3dc.m00() * this.x);
        double m21 = (matrix4x3dc.m21() * this.z) + (matrix4x3dc.m11() * this.y) + (matrix4x3dc.m01() * this.x);
        double m22 = (matrix4x3dc.m22() * this.z) + (matrix4x3dc.m12() * this.y) + (matrix4x3dc.m02() * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulPosition(Matrix4x3dc matrix4x3dc, Vector3d vector3d) {
        double m30 = matrix4x3dc.m30() + (matrix4x3dc.m20() * this.z) + (matrix4x3dc.m10() * this.y) + (matrix4x3dc.m00() * this.x);
        double m31 = matrix4x3dc.m31() + (matrix4x3dc.m21() * this.z) + (matrix4x3dc.m11() * this.y) + (matrix4x3dc.m01() * this.x);
        double m32 = matrix4x3dc.m32() + (matrix4x3dc.m22() * this.z) + (matrix4x3dc.m12() * this.y) + (matrix4x3dc.m02() * this.x);
        vector3d.x = m30;
        vector3d.y = m31;
        vector3d.z = m32;
        return vector3d;
    }

    public Vector3d mul(Matrix3fc matrix3fc, Vector3d vector3d) {
        double m20 = (((double) matrix3fc.m20()) * this.z) + (((double) matrix3fc.m10()) * this.y) + (((double) matrix3fc.m00()) * this.x);
        double m21 = (((double) matrix3fc.m21()) * this.z) + (((double) matrix3fc.m11()) * this.y) + (((double) matrix3fc.m01()) * this.x);
        double m22 = (((double) matrix3fc.m22()) * this.z) + (((double) matrix3fc.m12()) * this.y) + (((double) matrix3fc.m02()) * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulDirection(Matrix4x3fc matrix4x3fc, Vector3d vector3d) {
        double m20 = (((double) matrix4x3fc.m20()) * this.z) + (((double) matrix4x3fc.m10()) * this.y) + (((double) matrix4x3fc.m00()) * this.x);
        double m21 = (((double) matrix4x3fc.m21()) * this.z) + (((double) matrix4x3fc.m11()) * this.y) + (((double) matrix4x3fc.m01()) * this.x);
        double m22 = (((double) matrix4x3fc.m22()) * this.z) + (((double) matrix4x3fc.m12()) * this.y) + (((double) matrix4x3fc.m02()) * this.x);
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mulPosition(Matrix4x3fc matrix4x3fc, Vector3d vector3d) {
        double m20 = (((double) matrix4x3fc.m20()) * this.z) + (((double) matrix4x3fc.m10()) * this.y) + (((double) matrix4x3fc.m00()) * this.x) + ((double) matrix4x3fc.m30());
        double m21 = (((double) matrix4x3fc.m21()) * this.z) + (((double) matrix4x3fc.m11()) * this.y) + (((double) matrix4x3fc.m01()) * this.x) + ((double) matrix4x3fc.m31());
        double m22 = (((double) matrix4x3fc.m22()) * this.z) + (((double) matrix4x3fc.m12()) * this.y) + (((double) matrix4x3fc.m02()) * this.x) + ((double) matrix4x3fc.m32());
        vector3d.x = m20;
        vector3d.y = m21;
        vector3d.z = m22;
        return vector3d;
    }

    public Vector3d mul(Matrix3x2dc matrix3x2dc) {
        return mul(matrix3x2dc, thisOrNew());
    }

    public Vector3d mul(Matrix3x2dc matrix3x2dc, Vector3d vector3d) {
        double m20 = (matrix3x2dc.m20() * this.z) + (matrix3x2dc.m10() * this.y) + (matrix3x2dc.m00() * this.x);
        double m11 = (matrix3x2dc.m11() * this.y) + (matrix3x2dc.m01() * this.x);
        double m21 = matrix3x2dc.m21();
        double d2 = this.z;
        double d3 = (m21 * d2) + m11;
        vector3d.x = m20;
        vector3d.y = d3;
        vector3d.z = d2;
        return vector3d;
    }

    public Vector3d mul(Matrix3x2fc matrix3x2fc) {
        return mul(matrix3x2fc, thisOrNew());
    }

    public Vector3d mul(Matrix3x2fc matrix3x2fc, Vector3d vector3d) {
        double m20 = (((double) matrix3x2fc.m20()) * this.z) + (((double) matrix3x2fc.m10()) * this.y) + (((double) matrix3x2fc.m00()) * this.x);
        double m11 = (((double) matrix3x2fc.m11()) * this.y) + (((double) matrix3x2fc.m01()) * this.x);
        double m21 = (double) matrix3x2fc.m21();
        double d2 = this.z;
        double d3 = (m21 * d2) + m11;
        vector3d.x = m20;
        vector3d.y = d3;
        vector3d.z = d2;
        return vector3d;
    }

    public Vector3d mul(double d2) {
        return mul(d2, thisOrNew());
    }

    public Vector3d mul(double d2, Vector3d vector3d) {
        vector3d.x = this.x * d2;
        vector3d.y = this.y * d2;
        vector3d.z = this.z * d2;
        return vector3d;
    }

    public Vector3d mul(double d2, double d3, double d4) {
        return mul(d2, d3, d4, thisOrNew());
    }

    public Vector3d mul(double d2, double d3, double d4, Vector3d vector3d) {
        vector3d.x = this.x * d2;
        vector3d.y = this.y * d3;
        vector3d.z = this.z * d4;
        return vector3d;
    }
}
