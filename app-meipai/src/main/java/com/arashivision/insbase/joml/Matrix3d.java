package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.MemUtil;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix3d implements Externalizable, Matrix3dc {
    public static final long serialVersionUID = 1;
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m22;

    public Matrix3d() {
        this.m00 = 1.0d;
        this.m11 = 1.0d;
        this.m22 = 1.0d;
    }

    public Matrix3d _m00(double d2) {
        this.m00 = d2;
        return this;
    }

    public Matrix3d _m01(double d2) {
        this.m01 = d2;
        return this;
    }

    public Matrix3d _m02(double d2) {
        this.m02 = d2;
        return this;
    }

    public Matrix3d _m10(double d2) {
        this.m10 = d2;
        return this;
    }

    public Matrix3d _m11(double d2) {
        this.m11 = d2;
        return this;
    }

    public Matrix3d _m12(double d2) {
        this.m12 = d2;
        return this;
    }

    public Matrix3d _m20(double d2) {
        this.m20 = d2;
        return this;
    }

    public Matrix3d _m21(double d2) {
        this.m21 = d2;
        return this;
    }

    public Matrix3d _m22(double d2) {
        this.m22 = d2;
        return this;
    }

    public Matrix3d add(Matrix3dc matrix3dc) {
        return add(matrix3dc, this);
    }

    public double determinant() {
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = (d4 - (d5 * d6)) * this.m22;
        double d8 = this.m02;
        double d9 = d6 * d8;
        double d10 = this.m12;
        return (((d5 * d10) - (d8 * d3)) * this.m20) + ((d9 - (d2 * d10)) * this.m21) + d7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix3d matrix3d = (Matrix3d) obj;
        return Double.doubleToLongBits(this.m00) == Double.doubleToLongBits(matrix3d.m00) && Double.doubleToLongBits(this.m01) == Double.doubleToLongBits(matrix3d.m01) && Double.doubleToLongBits(this.m02) == Double.doubleToLongBits(matrix3d.m02) && Double.doubleToLongBits(this.m10) == Double.doubleToLongBits(matrix3d.m10) && Double.doubleToLongBits(this.m11) == Double.doubleToLongBits(matrix3d.m11) && Double.doubleToLongBits(this.m12) == Double.doubleToLongBits(matrix3d.m12) && Double.doubleToLongBits(this.m20) == Double.doubleToLongBits(matrix3d.m20) && Double.doubleToLongBits(this.m21) == Double.doubleToLongBits(matrix3d.m21) && Double.doubleToLongBits(this.m22) == Double.doubleToLongBits(matrix3d.m22);
    }

    public Matrix3d get(Matrix3d matrix3d) {
        return matrix3d.set((Matrix3dc) this);
    }

    public Vector3d getColumn(int i2, Vector3d vector3d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m01;
            vector3d.z = this.m02;
        } else if (i2 == 1) {
            vector3d.x = this.m10;
            vector3d.y = this.m11;
            vector3d.z = this.m12;
        } else if (i2 == 2) {
            vector3d.x = this.m20;
            vector3d.y = this.m21;
            vector3d.z = this.m22;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3d;
    }

    public Vector3d getEulerAnglesZYX(Vector3d vector3d) {
        vector3d.x = (double) ((float) Math.atan2(this.m12, this.m22));
        double d2 = -this.m02;
        double d3 = this.m12;
        double d4 = d3 * d3;
        double d5 = this.m22;
        vector3d.y = (double) ((float) Math.atan2(d2, Math.sqrt((d5 * d5) + d4)));
        vector3d.z = (double) ((float) Math.atan2(this.m01, this.m00));
        return vector3d;
    }

    public ByteBuffer getFloats(ByteBuffer byteBuffer) {
        return getFloats(byteBuffer.position(), byteBuffer);
    }

    public Quaternionf getNormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromNormalized((Matrix3dc) this);
    }

    public AxisAngle4f getRotation(AxisAngle4f axisAngle4f) {
        return axisAngle4f.set((Matrix3dc) this);
    }

    public Vector3d getRow(int i2, Vector3d vector3d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m10;
            vector3d.z = this.m20;
        } else if (i2 == 1) {
            vector3d.x = this.m01;
            vector3d.y = this.m11;
            vector3d.z = this.m21;
        } else if (i2 == 2) {
            vector3d.x = this.m02;
            vector3d.y = this.m12;
            vector3d.z = this.m22;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3d;
    }

    public Vector3d getScale(Vector3d vector3d) {
        double d2 = this.m00;
        double d3 = d2 * d2;
        double d4 = this.m01;
        double d5 = (d4 * d4) + d3;
        double d6 = this.m02;
        vector3d.x = Math.sqrt((d6 * d6) + d5);
        double d7 = this.m10;
        double d8 = d7 * d7;
        double d9 = this.m11;
        double d10 = (d9 * d9) + d8;
        double d11 = this.m12;
        vector3d.y = Math.sqrt((d11 * d11) + d10);
        double d12 = this.m20;
        double d13 = d12 * d12;
        double d14 = this.m21;
        double d15 = (d14 * d14) + d13;
        double d16 = this.m22;
        vector3d.z = Math.sqrt((d16 * d16) + d15);
        return vector3d;
    }

    public Quaternionf getUnnormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromUnnormalized((Matrix3dc) this);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.m00);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.m01);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.m02);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.m10);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.m11);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.m12);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.m20);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.m21);
        int i9 = (i8 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.m22);
        return (i9 * 31) + ((int) ((doubleToLongBits9 >>> 32) ^ doubleToLongBits9));
    }

    public Matrix3d identity() {
        this.m00 = 1.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 1.0d;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 1.0d;
        return this;
    }

    public Matrix3d invert() {
        return invert(this);
    }

    public Matrix3d lerp(Matrix3dc matrix3dc, double d2) {
        return lerp(matrix3dc, d2, this);
    }

    public Matrix3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public double m00() {
        return this.m00;
    }

    public double m01() {
        return this.m01;
    }

    public double m02() {
        return this.m02;
    }

    public double m10() {
        return this.m10;
    }

    public double m11() {
        return this.m11;
    }

    public double m12() {
        return this.m12;
    }

    public double m20() {
        return this.m20;
    }

    public double m21() {
        return this.m21;
    }

    public double m22() {
        return this.m22;
    }

    public Matrix3d mul(Matrix3dc matrix3dc) {
        return mul(matrix3dc, this);
    }

    public Matrix3d mulComponentWise(Matrix3dc matrix3dc) {
        return mulComponentWise(matrix3dc, this);
    }

    public Matrix3d mulLocal(Matrix3dc matrix3dc) {
        return mulLocal(matrix3dc, this);
    }

    public Matrix3d normal() {
        return normal(this);
    }

    public Vector3d normalizedPositiveX(Vector3d vector3d) {
        vector3d.x = this.m00;
        vector3d.y = this.m10;
        vector3d.z = this.m20;
        return vector3d;
    }

    public Vector3d normalizedPositiveY(Vector3d vector3d) {
        vector3d.x = this.m01;
        vector3d.y = this.m11;
        vector3d.z = this.m21;
        return vector3d;
    }

    public Vector3d normalizedPositiveZ(Vector3d vector3d) {
        vector3d.x = this.m02;
        vector3d.y = this.m12;
        vector3d.z = this.m22;
        return vector3d;
    }

    public Matrix3d obliqueZ(double d2, double d3) {
        this.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        this.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        this.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        return this;
    }

    public Vector3d positiveX(Vector3d vector3d) {
        double d2 = this.m11;
        double d3 = this.m22;
        double d4 = d2 * d3;
        double d5 = this.m12;
        double d6 = this.m21;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m02;
        double d8 = d6 * d7;
        double d9 = this.m01;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public Vector3d positiveY(Vector3d vector3d) {
        double d2 = this.m12;
        double d3 = this.m20;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = this.m22;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m00;
        double d8 = d6 * d7;
        double d9 = this.m02;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public Vector3d positiveZ(Vector3d vector3d) {
        double d2 = this.m10;
        double d3 = this.m21;
        double d4 = d2 * d3;
        double d5 = this.m11;
        double d6 = this.m20;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m01;
        double d8 = d6 * d7;
        double d9 = this.m00;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readDouble();
        this.m01 = objectInput.readDouble();
        this.m02 = objectInput.readDouble();
        this.m10 = objectInput.readDouble();
        this.m11 = objectInput.readDouble();
        this.m12 = objectInput.readDouble();
        this.m20 = objectInput.readDouble();
        this.m21 = objectInput.readDouble();
        this.m22 = objectInput.readDouble();
    }

    public Matrix3d rotate(double d2, double d3, double d4, double d5) {
        return rotate(d2, d3, d4, d5, this);
    }

    public Matrix3d rotateLocal(double d2, double d3, double d4, double d5, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = (d3 * d3 * d6) + cosFromSin;
        double d8 = d3 * d4 * d6;
        double d9 = d5 * sin;
        double d10 = d8 + d9;
        double d11 = d3 * d5 * d6;
        double d12 = d4 * sin;
        double d13 = d11 - d12;
        double d14 = d8 - d9;
        double d15 = (d4 * d4 * d6) + cosFromSin;
        double d16 = d4 * d5 * d6;
        double d17 = sin * d3;
        double d18 = d16 + d17;
        double d19 = d11 + d12;
        double d20 = d16 - d17;
        double d21 = (d5 * d5 * d6) + cosFromSin;
        double d22 = this.m00;
        double d23 = d7 * d22;
        double d24 = this.m01;
        double d25 = (d14 * d24) + d23;
        double d26 = this.m02;
        double d27 = d19;
        double d28 = (d19 * d26) + d25;
        double d29 = (d20 * d26) + (d15 * d24) + (d10 * d22);
        double d30 = d26 * d21;
        double d31 = d30 + (d24 * d18) + (d22 * d13);
        double d32 = this.m10;
        double d33 = d7 * d32;
        double d34 = d31;
        double d35 = this.m11;
        double d36 = (d14 * d35) + d33;
        double d37 = this.m12;
        double d38 = d29;
        double d39 = (d27 * d37) + d36;
        double d40 = (d20 * d37) + (d15 * d35) + (d10 * d32);
        double d41 = d37 * d21;
        double d42 = d41 + (d35 * d18) + (d32 * d13);
        double d43 = this.m20;
        double d44 = d7 * d43;
        double d45 = this.m21;
        double d46 = (d14 * d45) + d44;
        double d47 = this.m22;
        double d48 = (d27 * d47) + d46;
        double d49 = d20 * d47;
        double d50 = d49 + (d15 * d45) + (d10 * d43);
        double d51 = d21 * d47;
        double d52 = d51 + (d18 * d45) + (d13 * d43);
        matrix3d2.m00 = d28;
        matrix3d2.m01 = d38;
        matrix3d2.m02 = d34;
        matrix3d2.m10 = d39;
        matrix3d2.m11 = d40;
        matrix3d2.m12 = d42;
        matrix3d2.m20 = d48;
        matrix3d2.m21 = d50;
        matrix3d2.m22 = d52;
        return matrix3d2;
    }

    public Matrix3d rotateLocalX(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.m01;
        double d4 = cosFromSin * d3;
        double d5 = this.m02;
        double d6 = d4 - (sin * d5);
        double d7 = (d5 * cosFromSin) + (d3 * sin);
        double d8 = this.m11;
        double d9 = cosFromSin * d8;
        double d10 = this.m12;
        double d11 = d9 - (sin * d10);
        double d12 = (d10 * cosFromSin) + (d8 * sin);
        double d13 = this.m21;
        double d14 = cosFromSin * d13;
        double d15 = d12;
        double d16 = this.m22;
        double d17 = d11;
        double d18 = d14 - (sin * d16);
        double d19 = (cosFromSin * d16) + (sin * d13);
        matrix3d2.m00 = this.m00;
        matrix3d2.m01 = d6;
        matrix3d2.m02 = d7;
        matrix3d2.m10 = this.m10;
        matrix3d2.m11 = d17;
        matrix3d2.m12 = d15;
        matrix3d2.m20 = this.m20;
        matrix3d2.m21 = d18;
        matrix3d2.m22 = d19;
        return matrix3d2;
    }

    public Matrix3d rotateLocalY(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.m00;
        double d4 = cosFromSin * d3;
        double d5 = this.m02;
        double d6 = (sin * d5) + d4;
        double d7 = -sin;
        double d8 = (d5 * cosFromSin) + (d3 * d7);
        double d9 = this.m10;
        double d10 = cosFromSin * d9;
        double d11 = d8;
        double d12 = this.m12;
        double d13 = (sin * d12) + d10;
        double d14 = (d12 * cosFromSin) + (d9 * d7);
        double d15 = this.m20;
        double d16 = cosFromSin * d15;
        double d17 = d14;
        double d18 = this.m22;
        double d19 = (sin * d18) + d16;
        double d20 = (cosFromSin * d18) + (d7 * d15);
        matrix3d2.m00 = d6;
        matrix3d2.m01 = this.m01;
        matrix3d2.m02 = d11;
        matrix3d2.m10 = d13;
        matrix3d2.m11 = this.m11;
        matrix3d2.m12 = d17;
        matrix3d2.m20 = d19;
        matrix3d2.m21 = this.m21;
        matrix3d2.m22 = d20;
        return matrix3d2;
    }

    public Matrix3d rotateLocalZ(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.m00;
        double d4 = cosFromSin * d3;
        double d5 = this.m01;
        double d6 = d4 - (sin * d5);
        double d7 = (d5 * cosFromSin) + (d3 * sin);
        double d8 = this.m10;
        double d9 = cosFromSin * d8;
        double d10 = this.m11;
        double d11 = d9 - (sin * d10);
        double d12 = (d10 * cosFromSin) + (d8 * sin);
        double d13 = this.m20;
        double d14 = cosFromSin * d13;
        double d15 = d12;
        double d16 = this.m21;
        double d17 = d11;
        double d18 = d14 - (sin * d16);
        double d19 = (cosFromSin * d16) + (sin * d13);
        matrix3d2.m00 = d6;
        matrix3d2.m01 = d7;
        matrix3d2.m02 = this.m02;
        matrix3d2.m10 = d17;
        matrix3d2.m11 = d15;
        matrix3d2.m12 = this.m12;
        matrix3d2.m20 = d18;
        matrix3d2.m21 = d19;
        matrix3d2.m22 = this.m22;
        return matrix3d2;
    }

    public Matrix3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix3d matrix3d) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix3d);
    }

    public Matrix3d rotateX(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = -sin;
        double d4 = this.m10;
        double d5 = d4 * cosFromSin;
        double d6 = this.m20;
        double d7 = (d6 * sin) + d5;
        double d8 = this.m11;
        double d9 = d8 * cosFromSin;
        double d10 = d7;
        double d11 = this.m21;
        double d12 = d11;
        double d13 = (d11 * sin) + d9;
        double d14 = this.m12;
        double d15 = d14 * cosFromSin;
        double d16 = d14;
        double d17 = this.m22;
        double d18 = (sin * d17) + d15;
        matrix3d2.m20 = (d6 * cosFromSin) + (d4 * d3);
        matrix3d2.m21 = (d12 * cosFromSin) + (d8 * d3);
        matrix3d2.m22 = (d17 * cosFromSin) + (d3 * d16);
        matrix3d2.m10 = d10;
        matrix3d2.m11 = d13;
        matrix3d2.m12 = d18;
        matrix3d2.m00 = this.m00;
        matrix3d2.m01 = this.m01;
        matrix3d2.m02 = this.m02;
        return matrix3d2;
    }

    public Matrix3d rotateXYZ(double d2, double d3, double d4) {
        return rotateXYZ(d2, d3, d4, this);
    }

    public Matrix3d rotateY(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = -sin;
        double d4 = this.m00;
        double d5 = d4 * cosFromSin;
        double d6 = this.m20;
        double d7 = (d6 * d3) + d5;
        double d8 = this.m01;
        double d9 = d8 * cosFromSin;
        double d10 = d7;
        double d11 = this.m21;
        double d12 = d11;
        double d13 = (d11 * d3) + d9;
        double d14 = this.m02;
        double d15 = d14 * cosFromSin;
        double d16 = d14;
        double d17 = this.m22;
        double d18 = (d3 * d17) + d15;
        matrix3d2.m20 = (d6 * cosFromSin) + (d4 * sin);
        matrix3d2.m21 = (d12 * cosFromSin) + (d8 * sin);
        matrix3d2.m22 = (d17 * cosFromSin) + (sin * d16);
        matrix3d2.m00 = d10;
        matrix3d2.m01 = d13;
        matrix3d2.m02 = d18;
        matrix3d2.m10 = this.m10;
        matrix3d2.m11 = this.m11;
        matrix3d2.m12 = this.m12;
        return matrix3d2;
    }

    public Matrix3d rotateYXZ(Vector3d vector3d) {
        return rotateYXZ(vector3d.y, vector3d.x, vector3d.z);
    }

    public Matrix3d rotateZ(double d2, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = -sin;
        double d4 = this.m00;
        double d5 = d4 * cosFromSin;
        double d6 = this.m10;
        double d7 = (d6 * sin) + d5;
        double d8 = this.m01;
        double d9 = d8 * cosFromSin;
        double d10 = d7;
        double d11 = this.m11;
        double d12 = d11;
        double d13 = (d11 * sin) + d9;
        double d14 = this.m02;
        double d15 = d14 * cosFromSin;
        double d16 = d14;
        double d17 = this.m12;
        double d18 = (sin * d17) + d15;
        matrix3d2.m10 = (d6 * cosFromSin) + (d4 * d3);
        matrix3d2.m11 = (d12 * cosFromSin) + (d8 * d3);
        matrix3d2.m12 = (d17 * cosFromSin) + (d3 * d16);
        matrix3d2.m00 = d10;
        matrix3d2.m01 = d13;
        matrix3d2.m02 = d18;
        matrix3d2.m20 = this.m20;
        matrix3d2.m21 = this.m21;
        matrix3d2.m22 = this.m22;
        return matrix3d2;
    }

    public Matrix3d rotateZYX(double d2, double d3, double d4) {
        return rotateZYX(d2, d3, d4, this);
    }

    public Matrix3d rotation(double d2, Vector3dc vector3dc) {
        return rotation(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix3d rotationTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotationTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix3d rotationX(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        this.m00 = 1.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = cosFromSin;
        this.m12 = sin;
        this.m20 = 0.0d;
        this.m21 = -sin;
        this.m22 = cosFromSin;
        return this;
    }

    public Matrix3d rotationXYZ(double d2, double d3, double d4) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d4);
        double d5 = -sin;
        double d6 = sin;
        double d7 = -sin2;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d8 = -sin3;
        double d9 = d5 * d7;
        double d10 = d7 * cosFromSin;
        this.m20 = sin2;
        this.m21 = d5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (d9 * cosFromSin3);
        this.m02 = (sin3 * d6) + (d10 * cosFromSin3);
        this.m10 = cosFromSin2 * d8;
        this.m11 = (cosFromSin * cosFromSin3) + (d9 * d8);
        this.m12 = (d6 * cosFromSin3) + (d10 * d8);
        return this;
    }

    public Matrix3d rotationY(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        this.m00 = cosFromSin;
        this.m01 = 0.0d;
        this.m02 = -sin;
        this.m10 = 0.0d;
        this.m11 = 1.0d;
        this.m12 = 0.0d;
        this.m20 = sin;
        this.m21 = 0.0d;
        this.m22 = cosFromSin;
        return this;
    }

    public Matrix3d rotationYXZ(double d2, double d3, double d4) {
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double sin2 = Math.sin(d2);
        double cosFromSin2 = Math.cosFromSin(sin2, d2);
        double sin3 = Math.sin(d4);
        double d5 = -sin2;
        double d6 = -sin;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d7 = -sin3;
        double d8 = sin2 * sin;
        double d9 = sin * cosFromSin2;
        this.m20 = sin2 * cosFromSin;
        this.m21 = d6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (d8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * d9) + (d5 * cosFromSin3);
        this.m10 = (d8 * cosFromSin3) + (cosFromSin2 * d7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (d9 * cosFromSin3) + (d5 * d7);
        return this;
    }

    public Matrix3d rotationZ(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        this.m00 = cosFromSin;
        this.m01 = sin;
        this.m02 = 0.0d;
        this.m10 = -sin;
        this.m11 = cosFromSin;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 1.0d;
        return this;
    }

    public Matrix3d rotationZYX(double d2, double d3, double d4) {
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = cosFromSin;
        double d6 = -sin2;
        double d7 = -sin3;
        double d8 = cosFromSin3 * sin2;
        double d9 = sin2 * sin3;
        double d10 = -sin;
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = d6;
        this.m10 = (d8 * sin) + (d7 * d5);
        this.m11 = (d9 * sin) + (cosFromSin3 * d5);
        this.m12 = sin * cosFromSin2;
        this.m20 = (d8 * d5) + (d7 * d10);
        this.m21 = (d9 * d5) + (cosFromSin3 * d10);
        this.m22 = cosFromSin2 * d5;
        return this;
    }

    public Matrix3d scale(Vector3dc vector3dc, Matrix3d matrix3d) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix3d);
    }

    public Matrix3d scaleLocal(double d2, double d3, double d4, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d5 = this.m00 * d2;
        double d6 = this.m01 * d3;
        double d7 = this.m02 * d4;
        double d8 = this.m10 * d2;
        double d9 = this.m11 * d3;
        double d10 = this.m12 * d4;
        double d11 = this.m20 * d2;
        double d12 = this.m21 * d3;
        double d13 = this.m22 * d4;
        matrix3d2.m00 = d5;
        matrix3d2.m01 = d6;
        matrix3d2.m02 = d7;
        matrix3d2.m10 = d8;
        matrix3d2.m11 = d9;
        matrix3d2.m12 = d10;
        matrix3d2.m20 = d11;
        matrix3d2.m21 = d12;
        matrix3d2.m22 = d13;
        return matrix3d2;
    }

    public Matrix3d scaling(double d2) {
        this.m00 = d2;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = d2;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = d2;
        return this;
    }

    public Matrix3d set(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        return this;
    }

    public Matrix3d setColumn(int i2, Vector3dc vector3dc) throws IndexOutOfBoundsException {
        return setColumn(i2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix3d setFloats(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.getf(this, byteBuffer.position(), byteBuffer);
        return this;
    }

    public Matrix3d setLookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return setLookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix3d setRow(int i2, Vector3dc vector3dc) throws IndexOutOfBoundsException {
        return setRow(i2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix3d setSkewSymmetric(double d2, double d3, double d4) {
        this.m22 = 0.0d;
        this.m11 = 0.0d;
        this.m00 = 0.0d;
        this.m01 = -d2;
        this.m02 = d3;
        this.m10 = d2;
        this.m12 = -d4;
        this.m20 = -d3;
        this.m21 = d4;
        return this;
    }

    public Matrix3d sub(Matrix3dc matrix3dc) {
        return sub(matrix3dc, this);
    }

    public Matrix3d swap(Matrix3d matrix3d) {
        double d2 = this.m00;
        this.m00 = matrix3d.m00;
        matrix3d.m00 = d2;
        double d3 = this.m01;
        this.m01 = matrix3d.m01;
        matrix3d.m01 = d3;
        double d4 = this.m02;
        this.m02 = matrix3d.m02;
        matrix3d.m02 = d4;
        double d5 = this.m10;
        this.m10 = matrix3d.m10;
        matrix3d.m10 = d5;
        double d6 = this.m11;
        this.m11 = matrix3d.m11;
        matrix3d.m11 = d6;
        double d7 = this.m12;
        this.m12 = matrix3d.m12;
        matrix3d.m12 = d7;
        double d8 = this.m20;
        this.m20 = matrix3d.m20;
        matrix3d.m20 = d8;
        double d9 = this.m21;
        this.m21 = matrix3d.m21;
        matrix3d.m21 = d9;
        double d10 = this.m22;
        this.m22 = matrix3d.m22;
        matrix3d.m22 = d10;
        return this;
    }

    public String toString() {
        String matrix3d = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix3d.length(); i3++) {
            char charAt = matrix3d.charAt(i3);
            if (charAt == 'E') {
                i2 = i3;
            } else if (charAt == ' ' && i2 == i3 - 1) {
                stringBuffer.append('+');
            } else if (Character.isDigit(charAt) && i2 == i3 - 1) {
                stringBuffer.append('+');
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public Vector3d transform(Vector3d vector3d) {
        return vector3d.mul((Matrix3dc) this);
    }

    public Vector3d transformTranspose(Vector3d vector3d) {
        return vector3d.mulTranspose((Matrix3dc) this);
    }

    public Matrix3d transpose() {
        return transpose(this);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.m00);
        objectOutput.writeDouble(this.m01);
        objectOutput.writeDouble(this.m02);
        objectOutput.writeDouble(this.m10);
        objectOutput.writeDouble(this.m11);
        objectOutput.writeDouble(this.m12);
        objectOutput.writeDouble(this.m20);
        objectOutput.writeDouble(this.m21);
        objectOutput.writeDouble(this.m22);
    }

    public Matrix3d zero() {
        this.m00 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 0.0d;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 0.0d;
        return this;
    }

    public Matrix3d add(Matrix3dc matrix3dc, Matrix3d matrix3d) {
        matrix3d.m00 = matrix3dc.m00() + this.m00;
        matrix3d.m01 = matrix3dc.m01() + this.m01;
        matrix3d.m02 = matrix3dc.m02() + this.m02;
        matrix3d.m10 = matrix3dc.m10() + this.m10;
        matrix3d.m11 = matrix3dc.m11() + this.m11;
        matrix3d.m12 = matrix3dc.m12() + this.m12;
        matrix3d.m20 = matrix3dc.m20() + this.m20;
        matrix3d.m21 = matrix3dc.m21() + this.m21;
        matrix3d.m22 = matrix3dc.m22() + this.m22;
        return matrix3d;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public ByteBuffer getFloats(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putf(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix3dc) this);
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix3dc) this);
    }

    public Matrix3d invert(Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double determinant = 1.0d / determinant();
        double d2 = this.m11;
        double d3 = this.m22;
        double d4 = d2 * d3;
        double d5 = this.m21;
        double d6 = this.m12;
        double d7 = d6;
        double d8 = d5;
        double c2 = a.c(d5, d6, d4, determinant);
        double d9 = this.m02;
        double d10 = d8 * d9;
        double d11 = this.m01;
        double d12 = d11;
        double d13 = d9;
        double d14 = c2;
        double c3 = a.c(d11, d3, d10, determinant);
        double d15 = c3;
        double c4 = a.c(d2, d13, d12 * d7, determinant);
        double d16 = this.m20;
        double d17 = d16 * d7;
        double d18 = this.m10;
        double d19 = d18;
        double d20 = d16;
        double d21 = c4;
        double c5 = a.c(d18, d3, d17, determinant);
        double d22 = this.m00;
        double d23 = d22;
        double d24 = d3 * d22;
        double d25 = c5;
        double c6 = a.c(d20, d13, d24, determinant);
        double c7 = a.c(d7, d23, d13 * d19, determinant);
        double d26 = c7;
        double c8 = a.c(d20, d2, d19 * d8, determinant);
        double d27 = c8;
        double d28 = d23 * d2;
        double c9 = a.c(d8, d23, d20 * d12, determinant);
        double c10 = a.c(d19, d12, d28, determinant);
        matrix3d2.m00 = d14;
        matrix3d2.m01 = d15;
        matrix3d2.m02 = d21;
        matrix3d2.m10 = d25;
        matrix3d2.m11 = c6;
        matrix3d2.m12 = d26;
        matrix3d2.m20 = d27;
        matrix3d2.m21 = c9;
        matrix3d2.m22 = c10;
        return matrix3d2;
    }

    public Matrix3d lerp(Matrix3dc matrix3dc, double d2, Matrix3d matrix3d) {
        matrix3d.m00 = a.h(matrix3dc.m00(), this.m00, d2, this.m00);
        double d3 = d2;
        matrix3d.m01 = a.h(matrix3dc.m01(), this.m01, d3, this.m01);
        matrix3d.m02 = a.h(matrix3dc.m02(), this.m02, d3, this.m02);
        matrix3d.m10 = a.h(matrix3dc.m10(), this.m10, d3, this.m10);
        matrix3d.m11 = a.h(matrix3dc.m11(), this.m11, d3, this.m11);
        matrix3d.m12 = a.h(matrix3dc.m12(), this.m12, d3, this.m12);
        matrix3d.m20 = a.h(matrix3dc.m20(), this.m20, d3, this.m20);
        matrix3d.m21 = a.h(matrix3dc.m21(), this.m21, d3, this.m21);
        matrix3d.m22 = a.h(matrix3dc.m22(), this.m22, d3, this.m22);
        return matrix3d;
    }

    public Matrix3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix3d matrix3d) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix3d);
    }

    public Matrix3d m00(double d2) {
        this.m00 = d2;
        return this;
    }

    public Matrix3d m01(double d2) {
        this.m01 = d2;
        return this;
    }

    public Matrix3d m02(double d2) {
        this.m02 = d2;
        return this;
    }

    public Matrix3d m10(double d2) {
        this.m10 = d2;
        return this;
    }

    public Matrix3d m11(double d2) {
        this.m11 = d2;
        return this;
    }

    public Matrix3d m12(double d2) {
        this.m12 = d2;
        return this;
    }

    public Matrix3d m20(double d2) {
        this.m20 = d2;
        return this;
    }

    public Matrix3d m21(double d2) {
        this.m21 = d2;
        return this;
    }

    public Matrix3d m22(double d2) {
        this.m22 = d2;
        return this;
    }

    public Matrix3d mul(Matrix3dc matrix3dc, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double m022 = (matrix3dc.m02() * this.m20) + (matrix3dc.m01() * this.m10) + (matrix3dc.m00() * this.m00);
        double m023 = (matrix3dc.m02() * this.m21) + (matrix3dc.m01() * this.m11) + (matrix3dc.m00() * this.m01);
        double m024 = (matrix3dc.m02() * this.m22) + (matrix3dc.m01() * this.m12) + (matrix3dc.m00() * this.m02);
        double m122 = (matrix3dc.m12() * this.m20) + (matrix3dc.m11() * this.m10) + (matrix3dc.m10() * this.m00);
        double m123 = (matrix3dc.m12() * this.m21) + (matrix3dc.m11() * this.m11) + (matrix3dc.m10() * this.m01);
        double m124 = (matrix3dc.m12() * this.m22) + (matrix3dc.m11() * this.m12) + (matrix3dc.m10() * this.m02);
        double m222 = (matrix3dc.m22() * this.m20) + (matrix3dc.m21() * this.m10) + (matrix3dc.m20() * this.m00);
        double m223 = (matrix3dc.m22() * this.m21) + (matrix3dc.m21() * this.m11) + (matrix3dc.m20() * this.m01);
        double m224 = (matrix3dc.m22() * this.m22) + (matrix3dc.m21() * this.m12) + (matrix3dc.m20() * this.m02);
        matrix3d2.m00 = m022;
        matrix3d2.m01 = m023;
        matrix3d2.m02 = m024;
        matrix3d2.m10 = m122;
        matrix3d2.m11 = m123;
        matrix3d2.m12 = m124;
        matrix3d2.m20 = m222;
        matrix3d2.m21 = m223;
        matrix3d2.m22 = m224;
        return matrix3d2;
    }

    public Matrix3d mulComponentWise(Matrix3dc matrix3dc, Matrix3d matrix3d) {
        matrix3d.m00 = matrix3dc.m00() * this.m00;
        matrix3d.m01 = matrix3dc.m01() * this.m01;
        matrix3d.m02 = matrix3dc.m02() * this.m02;
        matrix3d.m10 = matrix3dc.m10() * this.m10;
        matrix3d.m11 = matrix3dc.m11() * this.m11;
        matrix3d.m12 = matrix3dc.m12() * this.m12;
        matrix3d.m20 = matrix3dc.m20() * this.m20;
        matrix3d.m21 = matrix3dc.m21() * this.m21;
        matrix3d.m22 = matrix3dc.m22() * this.m22;
        return matrix3d;
    }

    public Matrix3d mulLocal(Matrix3dc matrix3dc, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double m202 = (matrix3dc.m20() * this.m02) + (matrix3dc.m10() * this.m01) + (matrix3dc.m00() * this.m00);
        double m203 = (matrix3dc.m20() * this.m02) + (matrix3dc.m11() * this.m01) + (matrix3dc.m01() * this.m00);
        double m204 = (matrix3dc.m20() * this.m12) + (matrix3dc.m10() * this.m11) + (matrix3dc.m00() * this.m10);
        double m205 = (matrix3dc.m20() * this.m12) + (matrix3dc.m11() * this.m11) + (matrix3dc.m01() * this.m10);
        double m206 = (matrix3dc.m20() * this.m22) + (matrix3dc.m10() * this.m21) + (matrix3dc.m00() * this.m20);
        double d2 = m206;
        double m212 = (matrix3dc.m21() * this.m22) + (matrix3dc.m11() * this.m21) + (matrix3dc.m01() * this.m20);
        matrix3d2.m00 = m202;
        matrix3d2.m01 = m203;
        matrix3d2.m10 = m204;
        matrix3d2.m11 = m205;
        matrix3d2.m20 = d2;
        matrix3d2.m21 = m212;
        return matrix3d2;
    }

    public Matrix3d normal(Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d5 * d6;
        double d8 = this.m02;
        double d9 = d8 * d6;
        double d10 = d6;
        double d11 = this.m12;
        double d12 = d2 * d11;
        double d13 = d5 * d11;
        double d14 = d8 * d3;
        double d15 = d4 - d7;
        double d16 = this.m22;
        double d17 = d15 * d16;
        double d18 = d9 - d12;
        double d19 = d2;
        double d20 = this.m21;
        double d21 = (d18 * d20) + d17;
        double d22 = d13 - d14;
        double d23 = this.m20;
        double l = a.l(d22, d23, d21, 1.0d);
        double d24 = d5;
        double c2 = a.c(d20, d11, d3 * d16, l);
        double d25 = l;
        double d26 = d23;
        double c3 = a.c(d10, d16, d11 * d23, d25);
        double d27 = d16;
        double c4 = a.c(d3, d23, d10 * d20, l);
        double d28 = d8;
        double d29 = d20;
        double d30 = c2;
        double d31 = d24;
        double c5 = a.c(d24, d27, d20 * d8, l);
        double c6 = a.c(d28, d26, d27 * d19, d25);
        double d32 = c4;
        double c7 = a.c(d19, d29, d26 * d31, l);
        double d33 = d22 * l;
        double d34 = d18 * l;
        double d35 = d15 * l;
        Matrix3d matrix3d3 = matrix3d;
        matrix3d3.m00 = d30;
        matrix3d3.m01 = c3;
        matrix3d3.m02 = d32;
        matrix3d3.m10 = c5;
        matrix3d3.m11 = c6;
        matrix3d3.m12 = c7;
        matrix3d3.m20 = d33;
        matrix3d3.m21 = d34;
        matrix3d3.m22 = d35;
        return matrix3d3;
    }

    public Matrix3d rotate(double d2, double d3, double d4, double d5, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = (d3 * d3 * d6) + cosFromSin;
        double d8 = d3 * d4 * d6;
        double d9 = d5 * sin;
        double d10 = d8 + d9;
        double d11 = d3 * d5 * d6;
        double d12 = d4 * sin;
        double d13 = d11 - d12;
        double d14 = d8 - d9;
        double d15 = (d4 * d4 * d6) + cosFromSin;
        double d16 = d4 * d5 * d6;
        double d17 = sin * d3;
        double d18 = d16 + d17;
        double d19 = d11 + d12;
        double d20 = d16 - d17;
        double d21 = (d5 * d5 * d6) + cosFromSin;
        double d22 = this.m00;
        double d23 = d22 * d7;
        double d24 = this.m10;
        double d25 = (d24 * d10) + d23;
        double d26 = this.m20;
        double d27 = d19;
        double d28 = (d26 * d13) + d25;
        double d29 = this.m01;
        double d30 = d29 * d7;
        double d31 = d29;
        double d32 = this.m11;
        double d33 = (d32 * d10) + d30;
        double d34 = d32;
        double d35 = this.m21;
        double d36 = d35;
        double d37 = (d35 * d13) + d33;
        double d38 = this.m02;
        double d39 = d7 * d38;
        double d40 = d38;
        double d41 = this.m12;
        double d42 = (d10 * d41) + d39;
        double d43 = this.m22;
        double d44 = (d13 * d43) + d42;
        double d45 = d44;
        double d46 = (d26 * d18) + (d24 * d15) + (d22 * d14);
        double d47 = d46;
        double d48 = (d36 * d18) + (d34 * d15) + (d31 * d14);
        double d49 = d18 * d43;
        double d50 = d49 + (d15 * d41) + (d14 * d40);
        double d51 = d26 * d21;
        double d52 = d51 + (d24 * d20) + (d22 * d27);
        Matrix3d matrix3d3 = matrix3d;
        double d53 = d45;
        matrix3d3.m20 = d52;
        matrix3d3.m21 = (d36 * d21) + (d34 * d20) + (d31 * d27);
        double d54 = d43 * d21;
        matrix3d3.m22 = d54 + (d41 * d20) + (d40 * d27);
        matrix3d3.m00 = d28;
        matrix3d3.m01 = d37;
        matrix3d3.m02 = d53;
        matrix3d3.m10 = d47;
        matrix3d3.m11 = d48;
        matrix3d3.m12 = d50;
        return matrix3d3;
    }

    public Matrix3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Matrix3d rotateXYZ(double d2, double d3, double d4, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d4);
        double d5 = -sin;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d6 = -sin2;
        double d7 = sin2;
        double d8 = -sin3;
        double d9 = this.m10;
        double d10 = d9 * cosFromSin;
        double d11 = sin3;
        double d12 = this.m20;
        double d13 = (d12 * sin) + d10;
        double d14 = d6;
        double d15 = this.m11;
        double d16 = d15 * cosFromSin;
        double d17 = cosFromSin2;
        double d18 = this.m21;
        double d19 = (d18 * sin) + d16;
        double d20 = d18;
        double d21 = this.m12;
        double d22 = d21 * cosFromSin;
        double d23 = d21;
        double d24 = this.m22;
        double d25 = (sin * d24) + d22;
        double d26 = (d12 * cosFromSin) + (d9 * d5);
        double d27 = (d20 * cosFromSin) + (d15 * d5);
        double d28 = (d24 * cosFromSin) + (d23 * d5);
        double d29 = this.m00;
        double d30 = (d26 * d14) + (d29 * d17);
        double d31 = this.m01;
        double d32 = (d27 * d14) + (d31 * d17);
        double d33 = d25;
        double d34 = this.m02;
        double d35 = (d14 * d28) + (d34 * d17);
        matrix3d2.m20 = (d26 * d17) + (d29 * d7);
        matrix3d2.m21 = (d27 * d17) + (d31 * d7);
        matrix3d2.m22 = (d28 * d17) + (d34 * d7);
        matrix3d2.m00 = (d13 * d11) + (d30 * cosFromSin3);
        matrix3d2.m01 = (d19 * d11) + (d32 * cosFromSin3);
        matrix3d2.m02 = (d33 * d11) + (d35 * cosFromSin3);
        matrix3d2.m10 = (d13 * cosFromSin3) + (d30 * d8);
        matrix3d2.m11 = (d19 * cosFromSin3) + (d32 * d8);
        matrix3d2.m12 = (d33 * cosFromSin3) + (d35 * d8);
        return matrix3d2;
    }

    public Matrix3d rotateYXZ(double d2, double d3, double d4) {
        return rotateYXZ(d2, d3, d4, this);
    }

    public Matrix3d rotateZYX(double d2, double d3, double d4, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = -sin3;
        double d6 = cosFromSin;
        double d7 = -sin2;
        double d8 = -sin;
        double d9 = this.m00;
        double d10 = d9 * cosFromSin3;
        double d11 = sin;
        double d12 = this.m10;
        double d13 = (d12 * sin3) + d10;
        double d14 = cosFromSin2;
        double d15 = this.m01;
        double d16 = d15 * cosFromSin3;
        double d17 = sin2;
        double d18 = this.m11;
        double d19 = (d18 * sin3) + d16;
        double d20 = d18;
        double d21 = this.m02;
        double d22 = d21 * cosFromSin3;
        double d23 = d21;
        double d24 = this.m12;
        double d25 = (sin3 * d24) + d22;
        double d26 = (d12 * cosFromSin3) + (d9 * d5);
        double d27 = (d20 * cosFromSin3) + (d15 * d5);
        double d28 = (d24 * cosFromSin3) + (d23 * d5);
        double d29 = d13 * d17;
        double d30 = this.m20;
        double d31 = (d30 * d14) + d29;
        double d32 = d19 * d17;
        double d33 = d28;
        double d34 = this.m21;
        double d35 = (d34 * d14) + d32;
        double d36 = d25 * d17;
        double d37 = d27;
        double d38 = this.m22;
        double d39 = (d38 * d14) + d36;
        matrix3d2.m00 = (d30 * d7) + (d13 * d14);
        matrix3d2.m01 = (d34 * d7) + (d19 * d14);
        matrix3d2.m02 = (d38 * d7) + (d25 * d14);
        matrix3d2.m10 = (d31 * d11) + (d26 * d6);
        matrix3d2.m11 = (d35 * d11) + (d37 * d6);
        matrix3d2.m12 = (d39 * d11) + (d33 * d6);
        matrix3d2.m20 = (d31 * d6) + (d26 * d8);
        matrix3d2.m21 = (d35 * d6) + (d37 * d8);
        matrix3d2.m22 = (d39 * d6) + (d33 * d8);
        return matrix3d2;
    }

    public Matrix3d rotation(double d2, Vector3fc vector3fc) {
        return rotation(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix3d rotationTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        double d13 = (d6 * d12) - (d7 * d11);
        double d14 = (d7 * d10) - (d5 * d12);
        double d15 = (d5 * d11) - (d6 * d10);
        double e3 = a.e(d15, d15, (d14 * d14) + (d13 * d13), 1.0d);
        double d16 = d13 * e3;
        double d17 = d14 * e3;
        double d18 = d15 * e3;
        double d19 = (d11 * d18) - (d12 * d17);
        double d20 = d12;
        double d21 = (d12 * d16) - (d10 * d18);
        double d22 = d11;
        double d23 = (d10 * d17) - (d11 * d16);
        this.m00 = d16;
        this.m01 = d17;
        this.m02 = d18;
        this.m10 = d19;
        this.m11 = d21;
        this.m12 = d23;
        this.m20 = d10;
        this.m21 = d22;
        this.m22 = d20;
        return this;
    }

    public Matrix3d scale(Vector3dc vector3dc) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), this);
    }

    public Matrix3d setColumn(int i2, double d2, double d3, double d4) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = d2;
            this.m01 = d3;
            this.m02 = d4;
        } else if (i2 == 1) {
            this.m10 = d2;
            this.m11 = d3;
            this.m12 = d4;
        } else if (i2 == 2) {
            this.m20 = d2;
            this.m21 = d3;
            this.m22 = d4;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public Matrix3d setLookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double d10 = -a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d11 = d2 * d10;
        double d12 = d3 * d10;
        double d13 = d10 * d4;
        double d14 = (d6 * d13) - (d7 * d12);
        double d15 = (d7 * d11) - (d5 * d13);
        double d16 = (d5 * d12) - (d6 * d11);
        double e2 = a.e(d16, d16, (d15 * d15) + (d14 * d14), 1.0d);
        double d17 = d14 * e2;
        double d18 = d15 * e2;
        double d19 = d16 * e2;
        double d20 = (d12 * d19) - (d13 * d18);
        double d21 = d13;
        double d22 = (d13 * d17) - (d11 * d19);
        double d23 = d19;
        double d24 = (d11 * d18) - (d12 * d17);
        this.m00 = d17;
        this.m01 = d20;
        this.m02 = d11;
        this.m10 = d18;
        this.m11 = d22;
        this.m12 = d12;
        this.m20 = d23;
        this.m21 = d24;
        this.m22 = d21;
        return this;
    }

    public Matrix3d setRow(int i2, double d2, double d3, double d4) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = d2;
            this.m01 = d3;
            this.m02 = d4;
        } else if (i2 == 1) {
            this.m10 = d2;
            this.m11 = d3;
            this.m12 = d4;
        } else if (i2 == 2) {
            this.m20 = d2;
            this.m21 = d3;
            this.m22 = d4;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public Matrix3d sub(Matrix3dc matrix3dc, Matrix3d matrix3d) {
        matrix3d.m00 = this.m00 - matrix3dc.m00();
        matrix3d.m01 = this.m01 - matrix3dc.m01();
        matrix3d.m02 = this.m02 - matrix3dc.m02();
        matrix3d.m10 = this.m10 - matrix3dc.m10();
        matrix3d.m11 = this.m11 - matrix3dc.m11();
        matrix3d.m12 = this.m12 - matrix3dc.m12();
        matrix3d.m20 = this.m20 - matrix3dc.m20();
        matrix3d.m21 = this.m21 - matrix3dc.m21();
        matrix3d.m22 = this.m22 - matrix3dc.m22();
        return matrix3d;
    }

    public Vector3d transform(Vector3dc vector3dc, Vector3d vector3d) {
        vector3dc.mul((Matrix3dc) this, vector3d);
        return vector3d;
    }

    public Vector3d transformTranspose(Vector3dc vector3dc, Vector3d vector3d) {
        vector3dc.mulTranspose((Matrix3dc) this, vector3d);
        return vector3d;
    }

    public Matrix3d transpose(Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d2 = this.m00;
        Matrix3d matrix3d3 = matrix3d2;
        double d3 = d2;
        matrix3d3.set(d3, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22);
        return matrix3d;
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Matrix3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d8 = d4;
        double d9 = d4;
        double d10 = -a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d11 = d2 * d10;
        double d12 = d3 * d10;
        double d13 = d10 * d4;
        double d14 = (d6 * d13) - (d7 * d12);
        double d15 = (d7 * d11) - (d5 * d13);
        double d16 = (d5 * d12) - (d6 * d11);
        double e2 = a.e(d16, d16, (d15 * d15) + (d14 * d14), 1.0d);
        double d17 = d14 * e2;
        double d18 = d15 * e2;
        double d19 = d16 * e2;
        double d20 = (d12 * d19) - (d13 * d18);
        double d21 = (d13 * d17) - (d11 * d19);
        double d22 = (d11 * d18) - (d12 * d17);
        double d23 = d13;
        double d24 = this.m00;
        double d25 = d24 * d17;
        double d26 = d19;
        double d27 = this.m10;
        double d28 = (d27 * d20) + d25;
        double d29 = d12;
        double d30 = this.m20;
        double d31 = d30;
        double d32 = (d30 * d11) + d28;
        double d33 = this.m01;
        double d34 = d33 * d17;
        double d35 = d33;
        double d36 = this.m11;
        double d37 = (d36 * d20) + d34;
        double d38 = d36;
        double d39 = this.m21;
        double d40 = d39;
        double d41 = (d39 * d11) + d37;
        double d42 = this.m02;
        double d43 = d17 * d42;
        double d44 = d42;
        double d45 = this.m12;
        double d46 = (d20 * d45) + d43;
        double d47 = this.m22;
        double d48 = (d11 * d47) + d46;
        double d49 = (d31 * d29) + (d27 * d21) + (d24 * d18);
        double d50 = (d40 * d29) + (d38 * d21) + (d35 * d18);
        double d51 = (d47 * d29) + (d21 * d45) + (d18 * d44);
        matrix3d2.m20 = (d31 * d23) + (d27 * d22) + (d24 * d26);
        matrix3d2.m21 = (d40 * d23) + (d38 * d22) + (d35 * d26);
        double d52 = d47 * d23;
        matrix3d2.m22 = d52 + (d45 * d22) + (d44 * d26);
        matrix3d2.m00 = d32;
        matrix3d2.m01 = d41;
        matrix3d2.m02 = d48;
        matrix3d2.m10 = d49;
        matrix3d2.m11 = d50;
        matrix3d2.m12 = d51;
        return matrix3d2;
    }

    public Matrix3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
        return rotateTowards(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix3d rotateYXZ(double d2, double d3, double d4, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double sin2 = Math.sin(d2);
        double cosFromSin2 = Math.cosFromSin(sin2, d2);
        double sin3 = Math.sin(d4);
        double d5 = -sin2;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d6 = -sin;
        double d7 = -sin3;
        double d8 = this.m00;
        double d9 = d8 * sin2;
        double d10 = sin3;
        double d11 = this.m20;
        double d12 = (d11 * cosFromSin2) + d9;
        double d13 = sin;
        double d14 = this.m01;
        double d15 = d14 * sin2;
        double d16 = cosFromSin;
        double d17 = this.m21;
        double d18 = (d17 * cosFromSin2) + d15;
        double d19 = d17;
        double d20 = this.m02;
        double d21 = sin2 * d20;
        double d22 = d20;
        double d23 = this.m22;
        double d24 = (d23 * cosFromSin2) + d21;
        double d25 = (d11 * d5) + (d8 * cosFromSin2);
        double d26 = (d19 * d5) + (d14 * cosFromSin2);
        double d27 = (d23 * d5) + (d22 * cosFromSin2);
        double d28 = this.m10;
        double d29 = (d12 * d13) + (d28 * d16);
        double d30 = this.m11;
        double d31 = (d18 * d13) + (d30 * d16);
        double d32 = this.m12;
        double d33 = (d13 * d24) + (d32 * d16);
        Matrix3d matrix3d3 = matrix3d;
        matrix3d3.m20 = (d12 * d16) + (d28 * d6);
        matrix3d3.m21 = (d18 * d16) + (d30 * d6);
        matrix3d3.m22 = (d24 * d16) + (d32 * d6);
        matrix3d3.m00 = (d29 * d10) + (d25 * cosFromSin3);
        matrix3d3.m01 = (d31 * d10) + (d26 * cosFromSin3);
        matrix3d3.m02 = (d33 * d10) + (d27 * cosFromSin3);
        matrix3d3.m10 = (d29 * cosFromSin3) + (d25 * d7);
        matrix3d3.m11 = (d31 * cosFromSin3) + (d26 * d7);
        matrix3d3.m12 = (d33 * cosFromSin3) + (d27 * d7);
        return matrix3d3;
    }

    public Matrix3d rotation(AxisAngle4f axisAngle4f) {
        return rotation((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Matrix3d scale(double d2, double d3, double d4, Matrix3d matrix3d) {
        matrix3d.m00 = this.m00 * d2;
        matrix3d.m01 = this.m01 * d2;
        matrix3d.m02 = this.m02 * d2;
        matrix3d.m10 = this.m10 * d3;
        matrix3d.m11 = this.m11 * d3;
        matrix3d.m12 = this.m12 * d3;
        matrix3d.m20 = this.m20 * d4;
        matrix3d.m21 = this.m21 * d4;
        matrix3d.m22 = this.m22 * d4;
        return matrix3d;
    }

    public Vector3f transform(Vector3f vector3f) {
        return vector3f.mul((Matrix3dc) this);
    }

    public Vector3d transformTranspose(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((this.m02 * d4) + (this.m01 * d3) + (this.m00 * d2), (this.m12 * d4) + (this.m11 * d3) + (this.m10 * d2), (this.m22 * d4) + (this.m21 * d3) + (this.m20 * d2));
        return vector3d;
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public Matrix3d obliqueZ(double d2, double d3, Matrix3d matrix3d) {
        matrix3d.m00 = this.m00;
        matrix3d.m01 = this.m01;
        matrix3d.m02 = this.m02;
        matrix3d.m10 = this.m10;
        matrix3d.m11 = this.m11;
        matrix3d.m12 = this.m12;
        matrix3d.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        matrix3d.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        matrix3d.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        return matrix3d;
    }

    public Matrix3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        double d13 = (d6 * d12) - (d7 * d11);
        double d14 = (d7 * d10) - (d5 * d12);
        double d15 = (d5 * d11) - (d6 * d10);
        double e3 = a.e(d15, d15, (d14 * d14) + (d13 * d13), 1.0d);
        double d16 = d13 * e3;
        double d17 = d14 * e3;
        double d18 = d15 * e3;
        double d19 = (d11 * d18) - (d12 * d17);
        double d20 = (d12 * d16) - (d10 * d18);
        double d21 = (d10 * d17) - (d11 * d16);
        double d22 = d12;
        double d23 = this.m00;
        double d24 = d23 * d16;
        double d25 = d11;
        double d26 = this.m10;
        double d27 = (d26 * d17) + d24;
        double d28 = d10;
        double d29 = this.m20;
        double d30 = d29;
        double d31 = (d29 * d18) + d27;
        double d32 = this.m01;
        double d33 = d32 * d16;
        double d34 = d32;
        double d35 = this.m11;
        double d36 = (d35 * d17) + d33;
        double d37 = d35;
        double d38 = this.m21;
        double d39 = d38;
        double d40 = (d38 * d18) + d36;
        double d41 = this.m02;
        double d42 = d16 * d41;
        double d43 = d41;
        double d44 = this.m12;
        double d45 = (d17 * d44) + d42;
        double d46 = this.m22;
        double d47 = (d18 * d46) + d45;
        double d48 = (d30 * d21) + (d26 * d20) + (d23 * d19);
        double d49 = (d39 * d21) + (d37 * d20) + (d34 * d19);
        double d50 = d21 * d46;
        double d51 = d50 + (d20 * d44) + (d19 * d43);
        matrix3d2.m20 = (d30 * d22) + (d26 * d25) + (d23 * d28);
        matrix3d2.m21 = (d39 * d22) + (d37 * d25) + (d34 * d28);
        double d52 = d46 * d22;
        matrix3d2.m22 = d52 + (d44 * d25) + (d43 * d28);
        matrix3d2.m00 = d31;
        matrix3d2.m01 = d40;
        matrix3d2.m02 = d47;
        matrix3d2.m10 = d48;
        matrix3d2.m11 = d49;
        matrix3d2.m12 = d51;
        return matrix3d2;
    }

    public Matrix3d rotation(AxisAngle4d axisAngle4d) {
        return rotation(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Vector3f transform(Vector3fc vector3fc, Vector3f vector3f) {
        vector3fc.mul((Matrix3dc) this, vector3f);
        return vector3f;
    }

    public Matrix3d(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putf(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Matrix3d rotation(double d2, double d3, double d4, double d5) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = d3 * d4;
        double d8 = d3 * d5;
        double d9 = d4 * d5;
        double d10 = d6;
        double d11 = cosFromSin;
        this.m00 = a.d(d3, d3, d10, d11);
        double d12 = d7 * d6;
        double d13 = d5 * sin;
        this.m10 = d12 - d13;
        double d14 = d8 * d6;
        double d15 = d4 * sin;
        this.m20 = d14 + d15;
        this.m01 = d13 + d12;
        this.m11 = a.d(d4, d4, d10, d11);
        double d16 = d9 * d6;
        double d17 = d3 * sin;
        this.m21 = d16 - d17;
        this.m02 = d14 - d15;
        this.m12 = d16 + d17;
        this.m22 = a.d(d5, d5, d10, d11);
        return this;
    }

    public Vector3d transform(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2), (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2), (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2));
        return vector3d;
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public double[] get(double[] dArr, int i2) {
        dArr[i2 + 0] = this.m00;
        dArr[i2 + 1] = this.m01;
        dArr[i2 + 2] = this.m02;
        dArr[i2 + 3] = this.m10;
        dArr[i2 + 4] = this.m11;
        dArr[i2 + 5] = this.m12;
        dArr[i2 + 6] = this.m20;
        dArr[i2 + 7] = this.m21;
        dArr[i2 + 8] = this.m22;
        return dArr;
    }

    public Matrix3d scaling(double d2, double d3, double d4) {
        this.m00 = d2;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = d3;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = d4;
        return this;
    }

    public Matrix3d set(Matrix3fc matrix3fc) {
        this.m00 = (double) matrix3fc.m00();
        this.m01 = (double) matrix3fc.m01();
        this.m02 = (double) matrix3fc.m02();
        this.m10 = (double) matrix3fc.m10();
        this.m11 = (double) matrix3fc.m11();
        this.m12 = (double) matrix3fc.m12();
        this.m20 = (double) matrix3fc.m20();
        this.m21 = (double) matrix3fc.m21();
        this.m22 = (double) matrix3fc.m22();
        return this;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder sb = new StringBuilder();
        String str = " ";
        a.b(numberFormat, this.m00, sb, str);
        a.b(numberFormat, this.m10, sb, str);
        String str2 = "\n";
        a.b(numberFormat, this.m20, sb, str2);
        a.b(numberFormat, this.m01, sb, str);
        a.b(numberFormat, this.m11, sb, str);
        a.b(numberFormat, this.m21, sb, str2);
        a.b(numberFormat, this.m02, sb, str);
        a.b(numberFormat, this.m12, sb, str);
        return a.a(numberFormat, this.m22, sb, str2);
    }

    public boolean equals(Matrix3dc matrix3dc, double d2) {
        if (this == matrix3dc) {
            return true;
        }
        return matrix3dc != null && (matrix3dc instanceof Matrix3d) && Runtime.equals(this.m00, matrix3dc.m00(), d2) && Runtime.equals(this.m01, matrix3dc.m01(), d2) && Runtime.equals(this.m02, matrix3dc.m02(), d2) && Runtime.equals(this.m10, matrix3dc.m10(), d2) && Runtime.equals(this.m11, matrix3dc.m11(), d2) && Runtime.equals(this.m12, matrix3dc.m12(), d2) && Runtime.equals(this.m20, matrix3dc.m20(), d2) && Runtime.equals(this.m21, matrix3dc.m21(), d2) && Runtime.equals(this.m22, matrix3dc.m22(), d2);
    }

    public Matrix3d scale(double d2, double d3, double d4) {
        return scale(d2, d3, d4, this);
    }

    public Matrix3d scale(double d2, Matrix3d matrix3d) {
        return scale(d2, d2, d2, matrix3d);
    }

    public Matrix3d scale(double d2) {
        return scale(d2, d2, d2);
    }

    public Matrix3d(Matrix3fc matrix3fc) {
        this.m00 = (double) matrix3fc.m00();
        this.m01 = (double) matrix3fc.m01();
        this.m02 = (double) matrix3fc.m02();
        this.m10 = (double) matrix3fc.m10();
        this.m11 = (double) matrix3fc.m11();
        this.m12 = (double) matrix3fc.m12();
        this.m20 = (double) matrix3fc.m20();
        this.m21 = (double) matrix3fc.m21();
        this.m22 = (double) matrix3fc.m22();
    }

    public Matrix3d rotateLocal(double d2, double d3, double d4, double d5) {
        return rotateLocal(d2, d3, d4, d5, this);
    }

    public Matrix3d rotateLocalX(double d2) {
        return rotateLocalX(d2, this);
    }

    public Matrix3d rotateLocalY(double d2) {
        return rotateLocalY(d2, this);
    }

    public Matrix3d rotateLocalZ(double d2) {
        return rotateLocalZ(d2, this);
    }

    public Matrix3d rotateX(double d2) {
        return rotateX(d2, this);
    }

    public Matrix3d rotateY(double d2) {
        return rotateY(d2, this);
    }

    public Matrix3d rotateZ(double d2) {
        return rotateZ(d2, this);
    }

    public Matrix3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        return lookAlong(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix3d rotate(Quaterniondc quaterniondc) {
        return rotate(quaterniondc, this);
    }

    public Matrix3d rotateLocal(Quaterniondc quaterniondc, Matrix3d matrix3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix3d matrix3d2 = matrix3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double b4 = a.b(w, x, z, y);
        double d3 = d2 + a2;
        double d4 = b2 - a3;
        double d5 = d2 - a2;
        double f2 = a.f(y, z, w, x);
        double d6 = b3 + a4;
        double d7 = a3 + b2;
        double d8 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d9 = this.m00;
        double d10 = b4 * d9;
        double d11 = this.m01;
        double d12 = (d5 * d11) + d10;
        double d13 = this.m02;
        double d14 = (d7 * d13) + d12;
        double d15 = (d8 * d13) + (f2 * d11) + (d3 * d9);
        double d16 = d13 * g2;
        double d17 = d16 + (d11 * d6) + (d9 * d4);
        double d18 = this.m10;
        double d19 = b4 * d18;
        double d20 = d17;
        double d21 = this.m11;
        double d22 = (d5 * d21) + d19;
        double d23 = this.m12;
        double d24 = d15;
        double d25 = (d7 * d23) + d22;
        double d26 = (d8 * d23) + (f2 * d21) + (d3 * d18);
        double d27 = d23 * g2;
        double d28 = d27 + (d21 * d6) + (d18 * d4);
        double d29 = this.m20;
        double d30 = b4 * d29;
        double d31 = this.m21;
        double d32 = (d5 * d31) + d30;
        double d33 = d28;
        double d34 = this.m22;
        double d35 = d8 * d34;
        double d36 = (d7 * d34) + d32;
        double d37 = d35 + (f2 * d31) + (d3 * d29);
        double d38 = g2 * d34;
        double d39 = d38 + (d6 * d31) + (d4 * d29);
        matrix3d2.m00 = d14;
        matrix3d2.m01 = d24;
        matrix3d2.m02 = d20;
        matrix3d2.m10 = d25;
        matrix3d2.m11 = d26;
        matrix3d2.m12 = d33;
        matrix3d2.m20 = d36;
        matrix3d2.m21 = d37;
        matrix3d2.m22 = d39;
        return matrix3d2;
    }

    public Matrix3d rotation(Quaterniondc quaterniondc) {
        Quaterniondc quaterniondc2 = quaterniondc;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double d3 = x;
        double d4 = a2;
        this.m00 = a.b(w, x, z, y);
        this.m01 = d2 + d4;
        this.m02 = b2 - a3;
        this.m10 = (-d4) + d2;
        this.m11 = a.f(y, z, w, d3);
        this.m12 = b3 + a4;
        this.m20 = a3 + b2;
        this.m21 = b3 - a4;
        this.m22 = a.g(z, y, d3, w);
        return this;
    }

    public double[] get(double[] dArr) {
        return get(dArr, 0);
    }

    public Matrix3d rotate(Quaterniondc quaterniondc, Matrix3d matrix3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix3d matrix3d2 = matrix3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double b4 = a.b(w, x, z, y);
        double d3 = d2 + a2;
        double d4 = b2 - a3;
        double d5 = d2 - a2;
        double f2 = a.f(y, z, w, x);
        double d6 = b3 + a4;
        double d7 = a3 + b2;
        double d8 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d9 = this.m00;
        double d10 = d9 * b4;
        double d11 = this.m10;
        double d12 = (d11 * d3) + d10;
        double d13 = this.m20;
        double d14 = (d13 * d4) + d12;
        double d15 = this.m01;
        double d16 = d15 * b4;
        double d17 = d14;
        double d18 = this.m11;
        double d19 = (d18 * d3) + d16;
        double d20 = this.m21;
        double d21 = g2;
        double d22 = (d20 * d4) + d19;
        double d23 = this.m02;
        double d24 = b4 * d23;
        double d25 = d23;
        double d26 = this.m12;
        double d27 = (d3 * d26) + d24;
        double d28 = d26;
        double d29 = this.m22;
        double d30 = d29;
        double d31 = (d4 * d29) + d27;
        double d32 = d31;
        double d33 = (d13 * d6) + (d11 * f2) + (d9 * d5);
        double d34 = (f2 * d28) + (d5 * d25);
        double d35 = (d20 * d6) + (d18 * f2) + (d15 * d5);
        double d36 = (d6 * d30) + d34;
        double d37 = d13 * d21;
        Matrix3d matrix3d3 = matrix3d;
        double d38 = d20;
        matrix3d3.m20 = d37 + (d11 * d8) + (d9 * d7);
        double d39 = d38 * d21;
        matrix3d3.m21 = d39 + (d18 * d8) + (d15 * d7);
        matrix3d3.m22 = (d30 * d21) + (d28 * d8) + (d25 * d7);
        matrix3d3.m00 = d17;
        matrix3d3.m01 = d22;
        matrix3d3.m02 = d32;
        matrix3d3.m10 = d33;
        matrix3d3.m11 = d35;
        matrix3d3.m12 = d36;
        return matrix3d3;
    }

    public float[] get(float[] fArr, int i2) {
        fArr[i2 + 0] = (float) this.m00;
        fArr[i2 + 1] = (float) this.m01;
        fArr[i2 + 2] = (float) this.m02;
        fArr[i2 + 3] = (float) this.m10;
        fArr[i2 + 4] = (float) this.m11;
        fArr[i2 + 5] = (float) this.m12;
        fArr[i2 + 6] = (float) this.m20;
        fArr[i2 + 7] = (float) this.m21;
        fArr[i2 + 8] = (float) this.m22;
        return fArr;
    }

    public Matrix3d scaleLocal(double d2, double d3, double d4) {
        return scaleLocal(d2, d3, d4, this);
    }

    public Matrix3d scaling(Vector3dc vector3dc) {
        this.m00 = vector3dc.x();
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = vector3dc.y();
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = vector3dc.z();
        return this;
    }

    public Matrix3d set(Matrix4x3dc matrix4x3dc) {
        this.m00 = matrix4x3dc.m00();
        this.m01 = matrix4x3dc.m01();
        this.m02 = matrix4x3dc.m02();
        this.m10 = matrix4x3dc.m10();
        this.m11 = matrix4x3dc.m11();
        this.m12 = matrix4x3dc.m12();
        this.m20 = matrix4x3dc.m20();
        this.m21 = matrix4x3dc.m21();
        this.m22 = matrix4x3dc.m22();
        return this;
    }

    public Matrix3d mul(Matrix3fc matrix3fc) {
        return mul(matrix3fc, this);
    }

    public Matrix3d mul(Matrix3fc matrix3fc, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double m022 = (this.m20 * ((double) matrix3fc.m02())) + (this.m10 * ((double) matrix3fc.m01())) + (this.m00 * ((double) matrix3fc.m00()));
        double m023 = (this.m21 * ((double) matrix3fc.m02())) + (this.m11 * ((double) matrix3fc.m01())) + (this.m01 * ((double) matrix3fc.m00()));
        double m024 = (this.m22 * ((double) matrix3fc.m02())) + (this.m12 * ((double) matrix3fc.m01())) + (this.m02 * ((double) matrix3fc.m00()));
        double m122 = (this.m20 * ((double) matrix3fc.m12())) + (this.m10 * ((double) matrix3fc.m11())) + (this.m00 * ((double) matrix3fc.m10()));
        double m123 = (this.m21 * ((double) matrix3fc.m12())) + (this.m11 * ((double) matrix3fc.m11())) + (this.m01 * ((double) matrix3fc.m10()));
        double d2 = m123;
        double m124 = (this.m22 * ((double) matrix3fc.m12())) + (this.m12 * ((double) matrix3fc.m11())) + (this.m02 * ((double) matrix3fc.m10()));
        double m222 = (this.m20 * ((double) matrix3fc.m22())) + (this.m10 * ((double) matrix3fc.m21())) + (this.m00 * ((double) matrix3fc.m20()));
        double m223 = (this.m21 * ((double) matrix3fc.m22())) + (this.m11 * ((double) matrix3fc.m21())) + (this.m01 * ((double) matrix3fc.m20()));
        double m224 = (this.m22 * ((double) matrix3fc.m22())) + (this.m12 * ((double) matrix3fc.m21())) + (this.m02 * ((double) matrix3fc.m20()));
        matrix3d2.m00 = m022;
        matrix3d2.m01 = m023;
        matrix3d2.m02 = m024;
        matrix3d2.m10 = m122;
        matrix3d2.m11 = d2;
        matrix3d2.m12 = m124;
        matrix3d2.m20 = m222;
        matrix3d2.m21 = m223;
        matrix3d2.m22 = m224;
        return matrix3d2;
    }

    public Matrix3d(Matrix4fc matrix4fc) {
        this.m00 = (double) matrix4fc.m00();
        this.m01 = (double) matrix4fc.m01();
        this.m02 = (double) matrix4fc.m02();
        this.m10 = (double) matrix4fc.m10();
        this.m11 = (double) matrix4fc.m11();
        this.m12 = (double) matrix4fc.m12();
        this.m20 = (double) matrix4fc.m20();
        this.m21 = (double) matrix4fc.m21();
        this.m22 = (double) matrix4fc.m22();
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public double get(int i2, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i3 == 0) {
                        return this.m20;
                    }
                    if (i3 == 1) {
                        return this.m21;
                    }
                    if (i3 == 2) {
                        return this.m22;
                    }
                }
            } else if (i3 == 0) {
                return this.m10;
            } else {
                if (i3 == 1) {
                    return this.m11;
                }
                if (i3 == 2) {
                    return this.m12;
                }
            }
        } else if (i3 == 0) {
            return this.m00;
        } else {
            if (i3 == 1) {
                return this.m01;
            }
            if (i3 == 2) {
                return this.m02;
            }
        }
        throw new IllegalArgumentException();
    }

    public Matrix3d set(Matrix4fc matrix4fc) {
        this.m00 = (double) matrix4fc.m00();
        this.m01 = (double) matrix4fc.m01();
        this.m02 = (double) matrix4fc.m02();
        this.m10 = (double) matrix4fc.m10();
        this.m11 = (double) matrix4fc.m11();
        this.m12 = (double) matrix4fc.m12();
        this.m20 = (double) matrix4fc.m20();
        this.m21 = (double) matrix4fc.m21();
        this.m22 = (double) matrix4fc.m22();
        return this;
    }

    public Matrix3d rotateLocal(Quaterniondc quaterniondc) {
        return rotateLocal(quaterniondc, this);
    }

    public Matrix3d rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, this);
    }

    public Matrix3d rotateLocal(Quaternionfc quaternionfc, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double d2 = w2 + w2;
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double d3 = y2 + y2;
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d4 = z2 + z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d5 = w3 + w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double d6 = z3 + z3;
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d7 = w4 + w4;
        double d8 = z;
        double b2 = a.b(w, x, z, y);
        double d9 = d3 + d2;
        double d10 = d4 - d5;
        double d11 = d3 - d2;
        double f2 = a.f(y, d8, w, x);
        double d12 = d6 + d7;
        double d13 = d5 + d4;
        double d14 = d6 - d7;
        double g2 = a.g(d8, y, x, w);
        double d15 = this.m00;
        double d16 = b2 * d15;
        double d17 = this.m01;
        double d18 = (d11 * d17) + d16;
        double d19 = this.m02;
        double d20 = (d13 * d19) + d18;
        double d21 = (d14 * d19) + (f2 * d17) + (d9 * d15);
        double d22 = d19 * g2;
        double d23 = d22 + (d17 * d12) + (d15 * d10);
        double d24 = this.m10;
        double d25 = b2 * d24;
        double d26 = this.m11;
        double d27 = (d11 * d26) + d25;
        double d28 = this.m12;
        double d29 = d23;
        double d30 = (d13 * d28) + d27;
        double d31 = (d14 * d28) + (f2 * d26) + (d9 * d24);
        double d32 = d28 * g2;
        double d33 = d32 + (d26 * d12) + (d24 * d10);
        double d34 = this.m20;
        double d35 = b2 * d34;
        double d36 = this.m21;
        double d37 = (d11 * d36) + d35;
        double d38 = d33;
        double d39 = this.m22;
        double d40 = d31;
        double d41 = d14 * d39;
        double d42 = (d13 * d39) + d37;
        double d43 = d41 + (f2 * d36) + (d9 * d34);
        double d44 = g2 * d39;
        double d45 = d44 + (d12 * d36) + (d10 * d34);
        matrix3d2.m00 = d20;
        matrix3d2.m01 = d21;
        matrix3d2.m02 = d29;
        matrix3d2.m10 = d30;
        matrix3d2.m11 = d40;
        matrix3d2.m12 = d38;
        matrix3d2.m20 = d42;
        matrix3d2.m21 = d43;
        matrix3d2.m22 = d45;
        return matrix3d2;
    }

    public Matrix3d(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
    }

    public Matrix3d rotate(Quaternionfc quaternionfc, Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double d2 = w2 + w2;
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double d3 = y2 + y2;
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d4 = z2 + z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d5 = w3 + w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double d6 = z3 + z3;
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d7 = w4 + w4;
        double d8 = z;
        double b2 = a.b(w, x, z, y);
        double d9 = d3 + d2;
        double d10 = d4 - d5;
        double d11 = d3 - d2;
        double f2 = a.f(y, d8, w, x);
        double d12 = d6 + d7;
        double d13 = d5 + d4;
        double d14 = d6 - d7;
        double g2 = a.g(d8, y, x, w);
        double d15 = this.m00;
        double d16 = d15 * b2;
        double d17 = this.m10;
        double d18 = (d17 * d9) + d16;
        double d19 = this.m20;
        double d20 = (d19 * d10) + d18;
        double d21 = this.m01;
        double d22 = d21 * b2;
        double d23 = d20;
        double d24 = this.m11;
        double d25 = (d24 * d9) + d22;
        double d26 = this.m21;
        double d27 = g2;
        double d28 = (d26 * d10) + d25;
        double d29 = this.m02;
        double d30 = b2 * d29;
        double d31 = d29;
        double d32 = this.m12;
        double d33 = (d9 * d32) + d30;
        double d34 = d32;
        double d35 = this.m22;
        double d36 = d35;
        double d37 = (d10 * d35) + d33;
        double d38 = (d19 * d12) + (d17 * f2) + (d15 * d11);
        double d39 = (d26 * d12) + (d24 * f2) + (d21 * d11);
        double d40 = (d36 * d12) + (f2 * d34) + (d11 * d31);
        double d41 = d19 * d27;
        double d42 = d41 + (d17 * d14) + (d15 * d13);
        Matrix3d matrix3d3 = matrix3d;
        double d43 = d28;
        matrix3d3.m20 = d42;
        double d44 = d26 * d27;
        matrix3d3.m21 = d44 + (d24 * d14) + (d21 * d13);
        matrix3d3.m22 = (d36 * d27) + (d34 * d14) + (d31 * d13);
        matrix3d3.m00 = d23;
        matrix3d3.m01 = d43;
        matrix3d3.m02 = d37;
        matrix3d3.m10 = d38;
        matrix3d3.m11 = d39;
        matrix3d3.m12 = d40;
        return matrix3d3;
    }

    public Matrix3d rotation(Quaternionfc quaternionfc) {
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double d2 = w2 + w2;
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double d3 = y2 + y2;
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d4 = z2 + z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d5 = w3 + w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double d6 = z3 + z3;
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d7 = w4 + w4;
        double d8 = x;
        double d9 = x;
        double d10 = d2;
        double d11 = z;
        this.m00 = a.b(w, d8, z, y);
        this.m01 = d3 + d10;
        this.m02 = d4 - d5;
        this.m10 = (-d10) + d3;
        this.m11 = a.f(y, d11, w, d9);
        this.m12 = d6 + d7;
        this.m20 = d5 + d4;
        this.m21 = d6 - d7;
        this.m22 = a.g(d11, y, d9, w);
        return this;
    }

    public Matrix3d set(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
        return this;
    }

    public Matrix3d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.m00 = d2;
        this.m01 = d3;
        this.m02 = d4;
        this.m10 = d5;
        this.m11 = d6;
        this.m12 = d7;
        this.m20 = d8;
        this.m21 = d9;
        this.m22 = d10;
    }

    public Matrix3d set(AxisAngle4f axisAngle4f) {
        AxisAngle4f axisAngle4f2 = axisAngle4f;
        double d2 = (double) axisAngle4f2.x;
        double d3 = (double) axisAngle4f2.y;
        double d4 = (double) axisAngle4f2.z;
        double d5 = (double) axisAngle4f2.angle;
        double d6 = d4;
        double e2 = a.e(d4, d4, (d3 * d3) + (d2 * d2), 1.0d);
        double d7 = d2 * e2;
        double d8 = d3 * e2;
        double d9 = d6 * e2;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d10 = 1.0d - cosFromSin;
        double d11 = d10;
        double d12 = cosFromSin;
        this.m00 = a.d(d7, d7, d11, d12);
        this.m11 = a.d(d8, d8, d11, d12);
        this.m22 = a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        double d15 = d8;
        this.m10 = d13 - d14;
        this.m01 = d13 + d14;
        double d16 = d7 * d9 * d10;
        double d17 = d15 * sin;
        this.m20 = d16 + d17;
        this.m02 = d16 - d17;
        double d18 = d15 * d9 * d10;
        double d19 = d7 * sin;
        this.m21 = d18 - d19;
        this.m12 = d18 + d19;
        return this;
    }

    public Matrix3d rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, this);
    }

    public Matrix3d rotate(AxisAngle4f axisAngle4f) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Matrix3d rotate(AxisAngle4f axisAngle4f, Matrix3d matrix3d) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z, matrix3d);
    }

    public Matrix3d rotate(AxisAngle4d axisAngle4d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Matrix3d(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
    }

    public Matrix3d rotate(AxisAngle4d axisAngle4d, Matrix3d matrix3d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z, matrix3d);
    }

    public Matrix3d rotate(double d2, Vector3dc vector3dc) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix3d(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        this.m00 = vector3dc.x();
        this.m01 = vector3dc.y();
        this.m02 = vector3dc.z();
        this.m10 = vector3dc2.x();
        this.m11 = vector3dc2.y();
        this.m12 = vector3dc2.z();
        this.m20 = vector3dc3.x();
        this.m21 = vector3dc3.y();
        this.m22 = vector3dc3.z();
    }

    public Matrix3d rotate(double d2, Vector3dc vector3dc, Matrix3d matrix3d) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix3d);
    }

    public Matrix3d rotate(double d2, Vector3fc vector3fc) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix3d rotate(double d2, Vector3fc vector3fc, Matrix3d matrix3d) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix3d);
    }

    public Matrix3d set(AxisAngle4d axisAngle4d) {
        AxisAngle4d axisAngle4d2 = axisAngle4d;
        double d2 = axisAngle4d2.x;
        double d3 = axisAngle4d2.y;
        double d4 = axisAngle4d2.z;
        double d5 = (d3 * d3) + (d2 * d2);
        double d6 = axisAngle4d2.angle;
        double e2 = a.e(d4, d4, d5, 1.0d);
        double d7 = d2 * e2;
        double d8 = d3 * e2;
        double d9 = d4 * e2;
        double sin = Math.sin(d6);
        double cosFromSin = Math.cosFromSin(sin, d6);
        double d10 = 1.0d - cosFromSin;
        double d11 = d10;
        double d12 = cosFromSin;
        this.m00 = a.d(d7, d7, d11, d12);
        this.m11 = a.d(d8, d8, d11, d12);
        this.m22 = a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        this.m10 = d13 - d14;
        this.m01 = d13 + d14;
        double d15 = d7 * d9 * d10;
        double d16 = d8 * sin;
        this.m20 = d15 + d16;
        this.m02 = d15 - d16;
        double d17 = d8 * d9 * d10;
        double d18 = d7 * sin;
        this.m21 = d17 - d18;
        this.m12 = d17 + d18;
        return this;
    }

    public Matrix3d set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix3d set(Quaterniondc quaterniondc) {
        return rotation(quaterniondc);
    }

    public Matrix3d set(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.m00 = d2;
        this.m01 = d3;
        this.m02 = d4;
        this.m10 = d5;
        this.m11 = d6;
        this.m12 = d7;
        this.m20 = d8;
        this.m21 = d9;
        this.m22 = d10;
        return this;
    }

    public Matrix3d set(double[] dArr) {
        this.m00 = dArr[0];
        this.m01 = dArr[1];
        this.m02 = dArr[2];
        this.m10 = dArr[3];
        this.m11 = dArr[4];
        this.m12 = dArr[5];
        this.m20 = dArr[6];
        this.m21 = dArr[7];
        this.m22 = dArr[8];
        return this;
    }

    public Matrix3d set(float[] fArr) {
        this.m00 = (double) fArr[0];
        this.m01 = (double) fArr[1];
        this.m02 = (double) fArr[2];
        this.m10 = (double) fArr[3];
        this.m11 = (double) fArr[4];
        this.m12 = (double) fArr[5];
        this.m20 = (double) fArr[6];
        this.m21 = (double) fArr[7];
        this.m22 = (double) fArr[8];
        return this;
    }

    public Matrix3d set(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
        return this;
    }

    public Matrix3d set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.getf(this, floatBuffer.position(), floatBuffer);
        return this;
    }

    public Matrix3d set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        return this;
    }

    public Matrix3d set(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        this.m00 = vector3dc.x();
        this.m01 = vector3dc.y();
        this.m02 = vector3dc.z();
        this.m10 = vector3dc2.x();
        this.m11 = vector3dc2.y();
        this.m12 = vector3dc2.z();
        this.m20 = vector3dc3.x();
        this.m21 = vector3dc3.y();
        this.m22 = vector3dc3.z();
        return this;
    }

    public Matrix3d set(int i2, int i3, double d2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i3 == 0) {
                        this.m20 = d2;
                        return this;
                    } else if (i3 == 1) {
                        this.m21 = d2;
                        return this;
                    } else if (i3 == 2) {
                        this.m22 = d2;
                        return this;
                    }
                }
            } else if (i3 == 0) {
                this.m10 = d2;
                return this;
            } else if (i3 == 1) {
                this.m11 = d2;
                return this;
            } else if (i3 == 2) {
                this.m12 = d2;
                return this;
            }
        } else if (i3 == 0) {
            this.m00 = d2;
            return this;
        } else if (i3 == 1) {
            this.m01 = d2;
            return this;
        } else if (i3 == 2) {
            this.m02 = d2;
            return this;
        }
        throw new IllegalArgumentException();
    }
}
