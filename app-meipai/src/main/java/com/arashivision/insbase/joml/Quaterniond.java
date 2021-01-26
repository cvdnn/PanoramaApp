package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.NumberFormat;

public class Quaterniond implements Externalizable, Quaterniondc {
    public static final long serialVersionUID = 1;
    public double w;
    public double x;
    public double y;
    public double z;

    public Quaterniond() {
        this.w = 1.0d;
    }

    private void setFromNormalized(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d2 + d6;
        double d12 = d11 + d10;
        if (d12 >= 0.0d) {
            double sqrt = Math.sqrt(d12 + 1.0d);
            this.w = sqrt * 0.5d;
            double d13 = 0.5d / sqrt;
            this.x = (d7 - d9) * d13;
            this.y = (d8 - d4) * d13;
            this.z = (d3 - d5) * d13;
        } else if (d2 >= d6 && d2 >= d10) {
            double sqrt2 = Math.sqrt((d2 - (d6 + d10)) + 1.0d);
            this.x = sqrt2 * 0.5d;
            double d14 = 0.5d / sqrt2;
            this.y = (d5 + d3) * d14;
            this.z = (d4 + d8) * d14;
            this.w = (d7 - d9) * d14;
        } else if (d6 > d10) {
            double sqrt3 = Math.sqrt((d6 - (d10 + d2)) + 1.0d);
            this.y = sqrt3 * 0.5d;
            double d15 = 0.5d / sqrt3;
            this.z = (d9 + d7) * d15;
            this.x = (d5 + d3) * d15;
            this.w = (d8 - d4) * d15;
        } else {
            double sqrt4 = Math.sqrt((d10 - d11) + 1.0d);
            this.z = sqrt4 * 0.5d;
            double d16 = 0.5d / sqrt4;
            this.x = (d4 + d8) * d16;
            this.y = (d9 + d7) * d16;
            this.w = (d3 - d5) * d16;
        }
    }

    private void setFromUnnormalized(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d4;
        double d12 = d4;
        double e2 = a.e(d11, d12, (d3 * d3) + (d2 * d2), 1.0d);
        double e3 = a.e(d7, d7, (d6 * d6) + (d5 * d5), 1.0d);
        double e4 = a.e(d10, d10, (d9 * d9) + (d8 * d8), 1.0d);
        setFromNormalized(d2 * e2, d3 * e2, e2 * d4, d5 * e3, d6 * e3, e3 * d7, d8 * e4, d9 * e4, e4 * d10);
    }

    public Quaterniond add(double d2, double d3, double d4, double d5) {
        return add(d2, d3, d4, d5, this);
    }

    public double angle() {
        double acos = Math.acos(this.w) * 2.0d;
        return acos <= 3.141592653589793d ? acos : 6.283185307179586d - acos;
    }

    public Quaterniond conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Quaterniond difference(Quaterniondc quaterniondc) {
        return difference(quaterniondc, this);
    }

    public Quaterniond div(Quaterniondc quaterniondc, Quaterniond quaterniond) {
        double w2 = 1.0d / ((quaterniondc.w() * quaterniondc.w()) + ((quaterniondc.z() * quaterniondc.z()) + ((quaterniondc.y() * quaterniondc.y()) + (quaterniondc.x() * quaterniondc.x()))));
        double d2 = (-quaterniondc.x()) * w2;
        double d3 = (-quaterniondc.y()) * w2;
        double d4 = (-quaterniondc.z()) * w2;
        double w3 = quaterniondc.w() * w2;
        double d5 = this.w;
        double d6 = d5 * d2;
        double d7 = this.x;
        double d8 = (d7 * w3) + d6;
        double d9 = this.y;
        double d10 = (d9 * d4) + d8;
        double d11 = d2;
        double d12 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d10 - (d12 * d3), (d12 * d11) + (d9 * w3) + ((d5 * d3) - (d7 * d4)), (d12 * w3) + (((d7 * d3) + (d5 * d4)) - (d9 * d11)), (((d5 * w3) - (d7 * d11)) - (d9 * d3)) - (d12 * d4));
        return quaterniond;
    }

    public double dot(Quaterniondc quaterniondc) {
        return (quaterniondc.w() * this.w) + (quaterniondc.z() * this.z) + (quaterniondc.y() * this.y) + (quaterniondc.x() * this.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Quaterniond.class != obj.getClass()) {
            return false;
        }
        Quaterniond quaterniond = (Quaterniond) obj;
        return Double.doubleToLongBits(this.w) == Double.doubleToLongBits(quaterniond.w) && Double.doubleToLongBits(this.x) == Double.doubleToLongBits(quaterniond.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(quaterniond.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(quaterniond.z);
    }

    public Quaterniond fromAxisAngleDeg(Vector3dc vector3dc, double d2) {
        return fromAxisAngleRad(vector3dc.x(), vector3dc.y(), vector3dc.z(), Math.toRadians(d2));
    }

    public Quaterniond fromAxisAngleRad(Vector3dc vector3dc, double d2) {
        return fromAxisAngleRad(vector3dc.x(), vector3dc.y(), vector3dc.z(), d2);
    }

    public Matrix3d get(Matrix3d matrix3d) {
        return matrix3d.set((Quaterniondc) this);
    }

    public Vector3d getEulerAnglesXYZ(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = this.w * d2;
        double d4 = this.y;
        vector3d2.x = Math.atan2(a.c(this.z, d4, d3, 2.0d), 1.0d - (((d4 * d4) + (d2 * d2)) * 2.0d));
        vector3d2.y = Math.asin(((this.y * this.w) + (this.x * this.z)) * 2.0d);
        double d5 = this.z;
        double d6 = this.w * d5;
        double d7 = this.x;
        double d8 = this.y;
        vector3d2.z = Math.atan2(a.c(d7, d8, d6, 2.0d), 1.0d - (((d5 * d5) + (d8 * d8)) * 2.0d));
        return vector3d2;
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

    public Quaterniond identity() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
        this.w = 1.0d;
        return this;
    }

    public Quaterniond integrate(double d2, double d3, double d4, double d5) {
        return integrate(d2, d3, d4, d5, this);
    }

    public Quaterniond invert(Quaterniond quaterniond) {
        Quaterniond quaterniond2 = quaterniond;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double l = a.l(d8, d8, d7, 1.0d);
        quaterniond2.x = (-d2) * l;
        quaterniond2.y = (-d4) * l;
        quaterniond2.z = (-d6) * l;
        quaterniond2.w = d8 * l;
        return quaterniond2;
    }

    public double lengthSquared() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        return (d8 * d8) + d7;
    }

    public Quaterniond lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Quaterniond mul(Quaterniondc quaterniondc) {
        return mul(quaterniondc, this);
    }

    public Quaterniond nlerp(Quaterniondc quaterniondc, double d2) {
        return nlerp(quaterniondc, d2, this);
    }

    public Quaterniond nlerpIterative(Quaterniondc quaterniondc, double d2, double d3, Quaterniond quaterniond) {
        Quaterniond quaterniond2 = quaterniond;
        double d4 = this.x;
        double d5 = this.y;
        double d6 = this.z;
        double d7 = this.w;
        double x2 = quaterniondc.x();
        double y2 = quaterniondc.y();
        double z2 = quaterniondc.z();
        double w2 = quaterniondc.w();
        double d8 = (d7 * w2) + (d6 * z2) + (d5 * y2) + (d4 * x2);
        double abs = Math.abs(d8);
        if (0.999999d < abs) {
            return quaterniond2.set((Quaterniondc) this);
        }
        double d9 = d8;
        double d10 = abs;
        double d11 = w2;
        double d12 = z2;
        double d13 = y2;
        double d14 = x2;
        double d15 = d7;
        double d16 = d6;
        double d17 = d5;
        double d18 = d4;
        double d19 = d2;
        while (d10 < d3) {
            double d20 = d9 >= 0.0d ? 0.5d : -0.5d;
            if (d19 < 0.5d) {
                double d21 = (d20 * d18) + (d14 * 0.5d);
                double d22 = (d20 * d17) + (d13 * 0.5d);
                double d23 = (d20 * d16) + (d12 * 0.5d);
                double d24 = (d20 * d15) + (d11 * 0.5d);
                double e2 = a.e(d24, d24, (d23 * d23) + (d22 * d22) + (d21 * d21), 1.0d);
                d14 = d21 * e2;
                d13 = d22 * e2;
                d12 = d23 * e2;
                d19 += d19;
                d11 = d24 * e2;
            } else {
                double d25 = (d20 * d14) + (d18 * 0.5d);
                double d26 = (d20 * d13) + (d17 * 0.5d);
                double d27 = (d20 * d12) + (d16 * 0.5d);
                double d28 = (d20 * d11) + (d15 * 0.5d);
                double e3 = a.e(d28, d28, (d27 * d27) + (d26 * d26) + (d25 * d25), 1.0d);
                d18 = d25 * e3;
                d17 = d26 * e3;
                d16 = d27 * e3;
                d19 = (d19 + d19) - 1.0d;
                d15 = d28 * e3;
            }
            d9 = (d15 * d11) + (d16 * d12) + (d17 * d13) + (d18 * d14);
            d10 = Math.abs(d9);
        }
        double d29 = 1.0d - d19;
        if (d9 < 0.0d) {
            d19 = -d19;
        }
        double d30 = (d14 * d19) + (d18 * d29);
        double d31 = (d13 * d19) + (d17 * d29);
        double d32 = (d12 * d19) + (d16 * d29);
        double d33 = (d19 * d11) + (d29 * d15);
        double d34 = d33;
        double e4 = a.e(d34, d33, (d32 * d32) + (d31 * d31) + (d30 * d30), 1.0d);
        quaterniond2.x *= e4;
        quaterniond2.y *= e4;
        quaterniond2.z *= e4;
        quaterniond2.w *= e4;
        return quaterniond2;
    }

    public Quaterniond normalize() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double e2 = a.e(d8, d8, d7, 1.0d);
        this.x *= e2;
        this.y *= e2;
        this.z *= e2;
        this.w *= e2;
        return this;
    }

    public Vector3d normalizedPositiveX(Vector3d vector3d) {
        double d2 = this.y;
        double d3 = d2 + d2;
        double d4 = this.z;
        double d5 = d4 + d4;
        vector3d.x = a.m(d4, d5, (-d2) * d3, 1.0d);
        double d6 = this.x;
        double d7 = d6 * d3;
        double d8 = this.w;
        vector3d.y = d7 - (d8 * d5);
        vector3d.z = (d8 * d3) + (d6 * d5);
        return vector3d;
    }

    public Vector3d normalizedPositiveY(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 + d2;
        double d4 = this.y;
        double d5 = d4 + d4;
        double d6 = this.z;
        double d7 = d6 + d6;
        double d8 = d5 * d2;
        double d9 = this.w;
        vector3d2.x = (d9 * d7) + d8;
        double d10 = d9;
        vector3d2.y = a.m(d6, d7, (-d2) * d3, 1.0d);
        vector3d2.z = (d4 * d7) - (d10 * d3);
        return vector3d2;
    }

    public Vector3d normalizedPositiveZ(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 + d2;
        double d4 = this.y;
        double d5 = d4 + d4;
        double d6 = this.z;
        double d7 = d6 + d6;
        double d8 = d2 * d7;
        double d9 = this.w;
        vector3d2.x = d8 - (d9 * d5);
        vector3d2.y = (d9 * d3) + (d7 * d4);
        vector3d2.z = a.m(d4, d5, (-d2) * d3, 1.0d);
        return vector3d2;
    }

    public Vector3d positiveX(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double l = a.l(d8, d8, d7, 1.0d);
        double d9 = (-d2) * l;
        double d10 = (-d4) * l;
        double d11 = (-d6) * l;
        double d12 = d8 * l;
        double d13 = d10 + d10;
        double d14 = d11 + d11;
        vector3d2.x = a.m(d11, d14, (-d10) * d13, 1.0d);
        vector3d2.y = (d12 * d14) + (d9 * d13);
        vector3d2.z = (d9 * d14) - (d12 * d13);
        return vector3d2;
    }

    public Vector3d positiveY(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double l = a.l(d8, d8, d7, 1.0d);
        double d9 = (-d2) * l;
        double d10 = (-d4) * l;
        double d11 = (-d6) * l;
        double d12 = d8 * l;
        double d13 = d9 + d9;
        double d14 = d11 + d11;
        vector3d2.x = ((d10 + d10) * d9) - (d12 * d14);
        vector3d2.y = a.m(d11, d14, (-d9) * d13, 1.0d);
        vector3d2.z = (d12 * d13) + (d10 * d14);
        return vector3d2;
    }

    public Vector3d positiveZ(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double l = a.l(d8, d8, d7, 1.0d);
        double d9 = (-d2) * l;
        double d10 = (-d4) * l;
        double d11 = (-d6) * l;
        double d12 = d8 * l;
        double d13 = d9 + d9;
        double d14 = d10 + d10;
        double d15 = d11 + d11;
        vector3d2.x = (d12 * d14) + (d9 * d15);
        vector3d2.y = (d15 * d10) - (d12 * d13);
        vector3d2.z = a.m(d10, d14, (-d9) * d13, 1.0d);
        return vector3d2;
    }

    public Quaterniond premul(Quaterniondc quaterniondc) {
        return premul(quaterniondc, this);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readDouble();
        this.y = objectInput.readDouble();
        this.z = objectInput.readDouble();
        this.w = objectInput.readDouble();
    }

    public Quaterniond rotateAxis(double d2, double d3, double d4, double d5, Quaterniond quaterniond) {
        double d6 = d2 / 2.0d;
        double sin = Math.sin(d6);
        double d7 = d5;
        double d8 = d5;
        double e2 = a.e(d7, d8, (d4 * d4) + (d3 * d3), 1.0d);
        double d9 = d3 * e2 * sin;
        double d10 = d4 * e2 * sin;
        double d11 = e2 * d5 * sin;
        double cosFromSin = Math.cosFromSin(sin, d6);
        double d12 = this.w;
        double d13 = d12 * d9;
        double d14 = this.x;
        double d15 = (d14 * cosFromSin) + d13;
        double d16 = this.y;
        double d17 = (d16 * d11) + d15;
        double d18 = d9;
        double d19 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d17 - (d19 * d10), (d19 * d18) + (d16 * cosFromSin) + ((d12 * d10) - (d14 * d11)), (d19 * cosFromSin) + (((d14 * d10) + (d12 * d11)) - (d16 * d18)), (((d12 * cosFromSin) - (d14 * d18)) - (d16 * d10)) - (d19 * d11));
        return quaterniond;
    }

    public Quaterniond rotateLocalX(double d2) {
        return rotateLocalX(d2, this);
    }

    public Quaterniond rotateLocalY(double d2) {
        return rotateLocalY(d2, this);
    }

    public Quaterniond rotateLocalZ(double d2) {
        return rotateLocalZ(d2, this);
    }

    public Quaterniond rotateTo(double d2, double d3, double d4, double d5, double d6, double d7, Quaterniond quaterniond) {
        double d8 = d5;
        double d9 = d6;
        double d10 = (d3 * d7) - (d4 * d9);
        double d11 = (d4 * d8) - (d2 * d7);
        double d12 = (d2 * d9) - (d3 * d8);
        double d13 = d9 * d9;
        double d14 = d7 * d7;
        double d15 = (d3 * d9) + (d2 * d8);
        double i2 = a.i(d4, d7, d15, Math.sqrt(((d8 * d8) + d13 + d14) * ((d4 * d4) + (d3 * d3) + (d2 * d2))));
        double d16 = i2;
        double d17 = i2;
        double e2 = a.e(d16, d17, (d12 * d12) + (d11 * d11) + (d10 * d10), 1.0d);
        double d18 = 0.0d;
        if (Double.isInfinite(e2)) {
            double d19 = -d8;
            e2 = (double) ((float) a.e(d19, d19, d13, 1.0d));
            if (Double.isInfinite(e2)) {
                double d20 = -d9;
                e2 = (double) ((float) a.e(d20, d20, d14, 1.0d));
                d11 = d7;
                d12 = d20;
                i2 = 0.0d;
            } else {
                d11 = d19;
                i2 = 0.0d;
                d12 = 0.0d;
                d18 = d9;
            }
        } else {
            d18 = d10;
        }
        double d21 = d18 * e2;
        double d22 = d11 * e2;
        double d23 = d12 * e2;
        double d24 = i2 * e2;
        double d25 = this.w;
        double d26 = d25 * d21;
        double d27 = this.x;
        double d28 = (d27 * d24) + d26;
        double d29 = this.y;
        double d30 = (d29 * d23) + d28;
        double d31 = this.z;
        quaterniond.set(d30 - (d31 * d22), (d31 * d21) + (d29 * d24) + ((d25 * d22) - (d27 * d23)), (d31 * d24) + (((d27 * d22) + (d25 * d23)) - (d29 * d21)), (((d25 * d24) - (d27 * d21)) - (d29 * d22)) - (d31 * d23));
        return quaterniond;
    }

    public Quaterniond rotateX(double d2) {
        return rotateX(d2, this);
    }

    public Quaterniond rotateXYZ(double d2, double d3, double d4) {
        return rotateXYZ(d2, d3, d4, this);
    }

    public Quaterniond rotateY(double d2) {
        return rotateY(d2, this);
    }

    public Quaterniond rotateYXZ(double d2, double d3, double d4) {
        return rotateYXZ(d2, d3, d4, this);
    }

    public Quaterniond rotateZ(double d2) {
        return rotateZ(d2, this);
    }

    public Quaterniond rotateZYX(double d2, double d3, double d4) {
        return rotateZYX(d2, d3, d4, this);
    }

    public Quaterniond rotationAxis(AxisAngle4f axisAngle4f) {
        return rotationAxis((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Quaterniond rotationTo(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d5;
        double d9 = d6;
        double d10 = d7;
        this.x = (d3 * d10) - (d4 * d9);
        this.y = (d4 * d8) - (d2 * d10);
        this.z = (d2 * d9) - (d3 * d8);
        double sqrt = Math.sqrt(((d10 * d10) + (d9 * d9) + (d8 * d8)) * ((d4 * d4) + (d3 * d3) + (d2 * d2)));
        double i2 = a.i(d4, d7, (d3 * d9) + (d2 * d8), sqrt);
        this.w = i2;
        double d11 = this.x;
        double d12 = d11 * d11;
        double d13 = this.y;
        double d14 = (d13 * d13) + d12;
        double d15 = this.z;
        double e2 = a.e(i2, i2, (d15 * d15) + d14, 1.0d);
        if (Double.isInfinite(e2)) {
            this.x = d9;
            double d16 = -d8;
            this.y = d16;
            this.z = 0.0d;
            this.w = 0.0d;
            e2 = (double) ((float) a.e(d16, d16, d9 * d9, 1.0d));
            if (Double.isInfinite(e2)) {
                this.x = 0.0d;
                this.y = d10;
                double d17 = -d9;
                this.z = d17;
                this.w = 0.0d;
                e2 = (double) ((float) a.e(d17, d17, d10 * d10, 1.0d));
            }
        }
        this.x *= e2;
        this.y *= e2;
        this.z *= e2;
        this.w *= e2;
        return this;
    }

    public Quaterniond rotationX(double d2) {
        double d3 = d2 * 0.5d;
        double sin = Math.sin(d3);
        this.w = Math.cosFromSin(sin, d3);
        this.x = sin;
        this.y = 0.0d;
        this.z = 0.0d;
        return this;
    }

    public Quaterniond rotationXYZ(double d2, double d3, double d4) {
        double d5 = d2 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d3 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d4;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * cosFromSin3;
        double d9 = sin2 * sin3;
        double d10 = sin2 * cosFromSin3;
        double d11 = cosFromSin2 * sin3;
        this.w = (cosFromSin * d8) - (sin * d9);
        this.x = (d9 * cosFromSin) + (d8 * sin);
        this.y = (cosFromSin * d10) - (sin * d11);
        this.z = (sin * d10) + (cosFromSin * d11);
        return this;
    }

    public Quaterniond rotationY(double d2) {
        double d3 = d2 * 0.5d;
        double sin = Math.sin(d3);
        this.w = Math.cosFromSin(sin, d3);
        this.x = 0.0d;
        this.y = sin;
        this.z = 0.0d;
        return this;
    }

    public Quaterniond rotationYXZ(double d2, double d3, double d4) {
        double d5 = d3 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d2 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d4;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * sin;
        double d9 = sin2 * cosFromSin;
        double d10 = sin2 * sin;
        double d11 = cosFromSin2 * cosFromSin;
        this.x = (d9 * sin3) + (d8 * cosFromSin3);
        this.y = (d9 * cosFromSin3) - (d8 * sin3);
        this.z = (d11 * sin3) - (d10 * cosFromSin3);
        this.w = (d10 * sin3) + (d11 * cosFromSin3);
        return this;
    }

    public Quaterniond rotationZ(double d2) {
        double d3 = d2 * 0.5d;
        double sin = Math.sin(d3);
        this.w = Math.cosFromSin(sin, d3);
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = sin;
        return this;
    }

    public Quaterniond rotationZYX(double d2, double d3, double d4) {
        double d5 = d4 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d3 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d2;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * cosFromSin3;
        double d9 = sin2 * sin3;
        double d10 = sin2 * cosFromSin3;
        double d11 = cosFromSin2 * sin3;
        this.w = (sin * d9) + (cosFromSin * d8);
        this.x = (d8 * sin) - (d9 * cosFromSin);
        this.y = (sin * d11) + (cosFromSin * d10);
        this.z = (cosFromSin * d11) - (sin * d10);
        return this;
    }

    public Quaterniond scale(double d2) {
        return scale(d2, this);
    }

    public Quaterniond scaling(double d2) {
        double sqrt = Math.sqrt(d2);
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
        this.w = sqrt;
        return this;
    }

    public Quaterniond set(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        this.w = d5;
        return this;
    }

    public Quaterniond setAngleAxis(double d2, double d3, double d4, double d5) {
        double d6 = d2 * 0.5d;
        double sin = Math.sin(d6);
        this.x = d3 * sin;
        this.y = d4 * sin;
        this.z = d5 * sin;
        this.w = Math.cosFromSin(sin, d6);
        return this;
    }

    public Quaterniond slerp(Quaterniondc quaterniondc, double d2) {
        return slerp(quaterniondc, d2, this);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Vector3d transform(Vector3d vector3d) {
        return transform(vector3d.x, vector3d.y, vector3d.z, vector3d);
    }

    public Vector3d transformPositiveX(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d2;
        double d10 = d4 * d6;
        double d11 = d4 * d8;
        double d12 = d6 * d2;
        vector3d2.x = a.b(d3, d5, d8 * d8, d7);
        vector3d2.y = a.a(d10, d9, d9, d10);
        vector3d2.z = a.f(d11, d12, d11, d12);
        return vector3d2;
    }

    public Vector3d transformPositiveY(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d8;
        double d10 = d5;
        double d11 = d8 * d2;
        double d12 = d4 * d6;
        double d13 = d6 * d8;
        double d14 = d4 * d2;
        vector3d2.x = (((-d11) + d12) - d11) + d12;
        vector3d2.y = a.f(d7, d9, d3, d10);
        vector3d2.z = a.a(d13, d13, d14, d14);
        return vector3d2;
    }

    public Vector3d transformPositiveZ(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d8;
        double d10 = d4 * d8;
        double d11 = d6 * d2;
        double d12 = d6 * d8;
        double d13 = d4 * d2;
        vector3d2.x = a.a(d11, d10, d10, d11);
        vector3d2.y = a.b(d12, d12, d13, d13);
        vector3d2.z = a.g(d9, d7, d5, d3);
        return vector3d2;
    }

    public Vector3d transformUnitPositiveX(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.y;
        double d3 = d2 * d2;
        double d4 = this.z;
        double d5 = d4 * d4;
        double d6 = this.x;
        double d7 = d6 * d2;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector3d2.x = (((1.0d - d3) - d3) - d5) - d5;
        vector3d2.y = a.a(d7, d11, d7, d11);
        vector3d2.z = a.f(d8, d10, d8, d10);
        return vector3d2;
    }

    public Vector4d transformUnitPositiveY(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.z;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d2 * d6;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector4d2.x = a.f(d7, d11, d7, d11);
        vector4d2.y = (((1.0d - d3) - d3) - d5) - d5;
        vector4d2.z = a.a(d8, d8, d10, d10);
        return vector4d2;
    }

    public Vector4d transformUnitPositiveZ(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = d4 * d4;
        double d6 = this.z;
        double d7 = d2 * d6;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector4d2.x = a.a(d7, d11, d7, d11);
        vector4d2.y = a.b(d8, d8, d10, d10);
        vector4d2.z = (((1.0d - d3) - d3) - d5) - d5;
        return vector4d2;
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

    public Quaterniond add(double d2, double d3, double d4, double d5, Quaterniond quaterniond) {
        quaterniond.x = this.x + d2;
        quaterniond.y = this.y + d3;
        quaterniond.z = this.z + d4;
        quaterniond.w = this.w + d5;
        return quaterniond;
    }

    public Quaterniond difference(Quaterniondc quaterniondc, Quaterniond quaterniond) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double l = a.l(d8, d8, d7, 1.0d);
        double d9 = (-d2) * l;
        double d10 = (-d4) * l;
        double d11 = (-d6) * l;
        double d12 = d8 * l;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(((quaterniondc.z() * d10) + ((quaterniondc.w() * d9) + (quaterniondc.x() * d12))) - (quaterniondc.y() * d11), (quaterniondc.x() * d11) + (quaterniondc.w() * d10) + ((quaterniondc.y() * d12) - (quaterniondc.z() * d9)), (quaterniondc.w() * d11) + (((quaterniondc.y() * d9) + (quaterniondc.z() * d12)) - (quaterniondc.x() * d10)), (((quaterniondc.w() * d12) - (quaterniondc.x() * d9)) - (quaterniondc.y() * d10)) - (quaterniondc.z() * d11));
        return quaterniond;
    }

    public Quaterniond fromAxisAngleDeg(double d2, double d3, double d4, double d5) {
        return fromAxisAngleRad(d2, d3, d4, Math.toRadians(d5));
    }

    public Quaterniond fromAxisAngleRad(double d2, double d3, double d4, double d5) {
        double d6 = d5 / 2.0d;
        double sin = Math.sin(d6);
        double sqrt = Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
        this.x = (d2 / sqrt) * sin;
        this.y = (d3 / sqrt) * sin;
        this.z = (d4 / sqrt) * sin;
        this.w = Math.cosFromSin(sin, d6);
        return this;
    }

    public Matrix3f get(Matrix3f matrix3f) {
        return matrix3f.set((Quaterniondc) this);
    }

    public Quaterniond integrate(double d2, double d3, double d4, double d5, Quaterniond quaterniond) {
        double d6;
        double d7;
        double d8 = d2 * d3 * 0.5d;
        double d9 = d2 * d4 * 0.5d;
        double d10 = d2 * d5 * 0.5d;
        double d11 = (d10 * d10) + (d9 * d9) + (d8 * d8);
        if ((d11 * d11) / 24.0d < 1.0E-8d) {
            d7 = 1.0d - (0.5d * d11);
            d6 = 1.0d - (d11 / 6.0d);
        } else {
            double sqrt = Math.sqrt(d11);
            double sin = Math.sin(sqrt);
            d6 = sin / sqrt;
            d7 = Math.cosFromSin(sin, sqrt);
        }
        double d12 = d8 * d6;
        double d13 = d9 * d6;
        double d14 = d10 * d6;
        double d15 = this.x;
        double d16 = d7 * d15;
        double d17 = this.w;
        double d18 = (d12 * d17) + d16;
        double d19 = this.z;
        double d20 = (d13 * d19) + d18;
        double d21 = d15;
        double d22 = this.y;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d20 - (d14 * d22), (d14 * d21) + (d13 * d17) + ((d7 * d22) - (d12 * d19)), (d14 * d17) + (((d12 * d22) + (d7 * d19)) - (d13 * d21)), (((d7 * d17) - (d12 * d21)) - (d13 * d22)) - (d14 * d19));
        return quaterniond;
    }

    public Quaterniond lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniond quaterniond) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), quaterniond);
    }

    public Quaterniond mul(Quaterniondc quaterniondc, Quaterniond quaterniond) {
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(((quaterniondc.z() * this.y) + ((quaterniondc.w() * this.x) + (quaterniondc.x() * this.w))) - (quaterniondc.y() * this.z), (quaterniondc.x() * this.z) + (quaterniondc.w() * this.y) + ((quaterniondc.y() * this.w) - (quaterniondc.z() * this.x)), (quaterniondc.w() * this.z) + (((quaterniondc.y() * this.x) + (quaterniondc.z() * this.w)) - (quaterniondc.x() * this.y)), (((quaterniondc.w() * this.w) - (quaterniondc.x() * this.x)) - (quaterniondc.y() * this.y)) - (quaterniondc.z() * this.z));
        return quaterniond;
    }

    public Quaterniond nlerp(Quaterniondc quaterniondc, double d2, Quaterniond quaterniond) {
        double d3 = d2;
        Quaterniond quaterniond2 = quaterniond;
        double d4 = 1.0d - d3;
        if ((quaterniondc.w() * this.w) + (quaterniondc.z() * this.z) + (quaterniondc.y() * this.y) + (quaterniondc.x() * this.x) < 0.0d) {
            d3 = -d3;
        }
        quaterniond2.x = (quaterniondc.x() * d3) + (this.x * d4);
        quaterniond2.y = (quaterniondc.y() * d3) + (this.y * d4);
        quaterniond2.z = (quaterniondc.z() * d3) + (this.z * d4);
        double w2 = (quaterniondc.w() * d3) + (d4 * this.w);
        quaterniond2.w = w2;
        double d5 = quaterniond2.x;
        double d6 = d5 * d5;
        double d7 = quaterniond2.y;
        double d8 = (d7 * d7) + d6;
        double d9 = quaterniond2.z;
        double e2 = a.e(w2, w2, (d9 * d9) + d8, 1.0d);
        quaterniond2.x *= e2;
        quaterniond2.y *= e2;
        quaterniond2.z *= e2;
        quaterniond2.w *= e2;
        return quaterniond2;
    }

    public Quaterniond premul(Quaterniondc quaterniondc, Quaterniond quaterniond) {
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(((quaterniondc.y() * this.z) + ((quaterniondc.x() * this.w) + (quaterniondc.w() * this.x))) - (quaterniondc.z() * this.y), (quaterniondc.z() * this.x) + (quaterniondc.y() * this.w) + ((quaterniondc.w() * this.y) - (quaterniondc.x() * this.z)), (quaterniondc.z() * this.w) + (((quaterniondc.x() * this.y) + (quaterniondc.w() * this.z)) - (quaterniondc.y() * this.x)), (((quaterniondc.w() * this.w) - (quaterniondc.x() * this.x)) - (quaterniondc.y() * this.y)) - (quaterniondc.z() * this.z));
        return quaterniond;
    }

    public Quaterniond rotateLocalX(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.x;
        double d5 = cosFromSin * d4;
        double d6 = this.w;
        double d7 = (sin * d6) + d5;
        double d8 = this.y;
        double d9 = cosFromSin * d8;
        double d10 = d7;
        double d11 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        double d12 = d10;
        quaterniond2.set(d12, d9 - (sin * d11), (d8 * sin) + (d11 * cosFromSin), (cosFromSin * d6) - (sin * d4));
        return quaterniond;
    }

    public Quaterniond rotateLocalY(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.x;
        double d5 = cosFromSin * d4;
        double d6 = this.z;
        double d7 = (sin * d6) + d5;
        double d8 = this.y;
        double d9 = cosFromSin * d8;
        double d10 = d7;
        double d11 = this.w;
        quaterniond.set(d10, (sin * d11) + d9, (d6 * cosFromSin) - (d4 * sin), (cosFromSin * d11) - (sin * d8));
        return quaterniond;
    }

    public Quaterniond rotateLocalZ(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.x;
        double d5 = cosFromSin * d4;
        double d6 = this.y;
        double d7 = d5 - (sin * d6);
        double d8 = (d4 * sin) + (d6 * cosFromSin);
        double d9 = this.z;
        double d10 = cosFromSin * d9;
        double d11 = this.w;
        quaterniond.set(d7, d8, (sin * d11) + d10, (cosFromSin * d11) - (sin * d9));
        return quaterniond;
    }

    public Quaterniond rotateX(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.w;
        double d5 = d4 * sin;
        double d6 = this.x;
        double d7 = (d6 * cosFromSin) + d5;
        double d8 = this.y;
        double d9 = d8 * cosFromSin;
        double d10 = d7;
        double d11 = this.z;
        quaterniond.set(d10, (d11 * sin) + d9, (d11 * cosFromSin) - (d8 * sin), (d4 * cosFromSin) - (d6 * sin));
        return quaterniond;
    }

    public Quaterniond rotateXYZ(double d2, double d3, double d4, Quaterniond quaterniond) {
        double d5 = d2 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d3 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d4;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * cosFromSin3;
        double d9 = sin2 * sin3;
        double d10 = sin2 * cosFromSin3;
        double d11 = cosFromSin2 * sin3;
        double d12 = (cosFromSin * d8) - (sin * d9);
        double d13 = (d9 * cosFromSin) + (d8 * sin);
        double d14 = (cosFromSin * d10) - (sin * d11);
        double d15 = (sin * d10) + (cosFromSin * d11);
        double d16 = this.w;
        double d17 = d16 * d13;
        double d18 = this.x;
        double d19 = (d18 * d12) + d17;
        double d20 = this.y;
        double d21 = (d20 * d15) + d19;
        double d22 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d21 - (d22 * d14), (d22 * d13) + (d20 * d12) + ((d16 * d14) - (d18 * d15)), (d22 * d12) + (((d18 * d14) + (d16 * d15)) - (d20 * d13)), (((d16 * d12) - (d18 * d13)) - (d20 * d14)) - (d22 * d15));
        return quaterniond;
    }

    public Quaterniond rotateY(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.x;
        double d5 = d4 * cosFromSin;
        double d6 = this.z;
        double d7 = d5 - (d6 * sin);
        double d8 = this.w;
        double d9 = d8 * sin;
        double d10 = d7;
        double d11 = this.y;
        double d12 = (d8 * cosFromSin) - (d11 * sin);
        Quaterniond quaterniond2 = quaterniond;
        double d13 = d10;
        quaterniond2.set(d13, (d11 * cosFromSin) + d9, (d6 * cosFromSin) + (d4 * sin), d12);
        return quaterniond;
    }

    public Quaterniond rotateYXZ(double d2, double d3, double d4, Quaterniond quaterniond) {
        double d5 = d3 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d2 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d4;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * sin;
        double d9 = sin2 * cosFromSin;
        double d10 = sin2 * sin;
        double d11 = cosFromSin2 * cosFromSin;
        double d12 = (d9 * sin3) + (d8 * cosFromSin3);
        double d13 = (d9 * cosFromSin3) - (d8 * sin3);
        double d14 = (d11 * sin3) - (d10 * cosFromSin3);
        double d15 = (d10 * sin3) + (d11 * cosFromSin3);
        double d16 = this.w;
        double d17 = d16 * d12;
        double d18 = this.x;
        double d19 = (d18 * d15) + d17;
        double d20 = this.y;
        double d21 = (d20 * d14) + d19;
        double d22 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d21 - (d22 * d13), (d22 * d12) + (d20 * d15) + ((d16 * d13) - (d18 * d14)), (d22 * d15) + (((d18 * d13) + (d16 * d14)) - (d20 * d12)), (((d16 * d15) - (d18 * d12)) - (d20 * d13)) - (d22 * d14));
        return quaterniond;
    }

    public Quaterniond rotateZ(double d2, Quaterniond quaterniond) {
        double d3 = 0.5d * d2;
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = this.x;
        double d5 = d4 * cosFromSin;
        double d6 = this.y;
        double d7 = (d6 * sin) + d5;
        double d8 = (d6 * cosFromSin) - (d4 * sin);
        double d9 = this.w;
        double d10 = d9 * sin;
        double d11 = this.z;
        quaterniond.set(d7, d8, (d11 * cosFromSin) + d10, (d9 * cosFromSin) - (d11 * sin));
        return quaterniond;
    }

    public Quaterniond rotateZYX(double d2, double d3, double d4, Quaterniond quaterniond) {
        double d5 = d4 * 0.5d;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d6 = d3 * 0.5d;
        double sin2 = Math.sin(d6);
        double cosFromSin2 = Math.cosFromSin(sin2, d6);
        double d7 = 0.5d * d2;
        double sin3 = Math.sin(d7);
        double cosFromSin3 = Math.cosFromSin(sin3, d7);
        double d8 = cosFromSin2 * cosFromSin3;
        double d9 = sin2 * sin3;
        double d10 = sin2 * cosFromSin3;
        double d11 = cosFromSin2 * sin3;
        double d12 = (sin * d9) + (cosFromSin * d8);
        double d13 = (d8 * sin) - (d9 * cosFromSin);
        double d14 = (sin * d11) + (cosFromSin * d10);
        double d15 = (cosFromSin * d11) - (sin * d10);
        double d16 = this.w;
        double d17 = d16 * d13;
        double d18 = this.x;
        double d19 = (d18 * d12) + d17;
        double d20 = this.y;
        double d21 = (d20 * d15) + d19;
        double d22 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d21 - (d22 * d14), (d22 * d13) + (d20 * d12) + ((d16 * d14) - (d18 * d15)), (d22 * d12) + (((d18 * d14) + (d16 * d15)) - (d20 * d13)), (((d16 * d12) - (d18 * d13)) - (d20 * d14)) - (d22 * d15));
        return quaterniond;
    }

    public Quaterniond rotationAxis(double d2, double d3, double d4, double d5) {
        double d6 = d2 / 2.0d;
        double sin = Math.sin(d6);
        double d7 = d5;
        double d8 = d5;
        double e2 = a.e(d7, d8, (d4 * d4) + (d3 * d3), 1.0d);
        this.x = d3 * e2 * sin;
        this.y = d4 * e2 * sin;
        this.z = e2 * d5 * sin;
        this.w = (double) ((float) Math.cosFromSin(sin, d6));
        return this;
    }

    public Quaterniond scale(double d2, Quaterniond quaterniond) {
        double sqrt = Math.sqrt(d2);
        quaterniond.x = this.x * sqrt;
        quaterniond.y = this.y * sqrt;
        quaterniond.z = this.z * sqrt;
        quaterniond.w = sqrt * this.w;
        return quaterniond;
    }

    public Quaterniond slerp(Quaterniondc quaterniondc, double d2, Quaterniond quaterniond) {
        double d3;
        double w2 = (quaterniondc.w() * this.w) + (quaterniondc.z() * this.z) + (quaterniondc.y() * this.y) + (quaterniondc.x() * this.x);
        double abs = Math.abs(w2);
        if (1.0d - abs > 1.0E-6d) {
            double d4 = 1.0d - (abs * abs);
            double sqrt = 1.0d / Math.sqrt(d4);
            double atan2 = Math.atan2(d4 * sqrt, abs);
            d3 = Math.sin((1.0d - d2) * atan2) * sqrt;
            d2 = Math.sin(d2 * atan2) * sqrt;
        } else {
            d3 = 1.0d - d2;
        }
        if (w2 < 0.0d) {
            d2 = -d2;
        }
        quaterniond.x = (quaterniondc.x() * d2) + (this.x * d3);
        quaterniond.y = (quaterniondc.y() * d2) + (this.y * d3);
        quaterniond.z = (quaterniondc.z() * d2) + (this.z * d3);
        quaterniond.w = (quaterniondc.w() * d2) + (d3 * this.w);
        return quaterniond;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, this.x, a2, str);
        a.b(numberFormat, this.y, a2, str);
        a.b(numberFormat, this.z, a2, str);
        return a.a(numberFormat, this.w, a2, ")");
    }

    public Vector4d transform(Vector4d vector4d) {
        return transform((Vector4dc) vector4d, vector4d);
    }

    public Quaterniond(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        this.w = d5;
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set((Quaterniondc) this);
    }

    public Quaterniond lookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        return lookAlong(d2, d3, d4, d5, d6, d7, this);
    }

    public Vector3d transform(Vector3dc vector3dc, Vector3d vector3d) {
        return transform(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3d);
    }

    public Quaterniond conjugate(Quaterniond quaterniond) {
        quaterniond.x = -this.x;
        quaterniond.y = -this.y;
        quaterniond.z = -this.z;
        quaterniond.w = this.w;
        return quaterniond;
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set((Quaterniondc) this);
    }

    public Quaterniond lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Quaterniond quaterniond) {
        double d8;
        double d9;
        double d10;
        double d11;
        double d12 = d2;
        double d13 = d3;
        double d14 = d4;
        double d15 = d4;
        double e2 = a.e(d14, d15, (d13 * d13) + (d12 * d12), 1.0d);
        double d16 = (-d12) * e2;
        double d17 = (-d13) * e2;
        double d18 = (-d14) * e2;
        double d19 = (d6 * d18) - (d7 * d17);
        double d20 = (d7 * d16) - (d5 * d18);
        double d21 = (d5 * d17) - (d6 * d16);
        double e3 = a.e(d21, d21, (d20 * d20) + (d19 * d19), 1.0d);
        double d22 = d19 * e3;
        double d23 = d20 * e3;
        double d24 = d21 * e3;
        double d25 = (d17 * d24) - (d18 * d23);
        double d26 = (d18 * d22) - (d16 * d24);
        double d27 = (d16 * d23) - (d17 * d22);
        double d28 = d22 + d26 + d18;
        if (d28 >= 0.0d) {
            double sqrt = Math.sqrt(d28 + 1.0d);
            d10 = sqrt * 0.5d;
            double d29 = 0.5d / sqrt;
            d11 = (d17 - d27) * d29;
            d9 = (d24 - d16) * d29;
            d8 = (d25 - d23) * d29;
        } else if (d22 > d26 && d22 > d18) {
            double sqrt2 = Math.sqrt(((d22 + 1.0d) - d26) - d18);
            double d30 = 0.5d / sqrt2;
            d8 = (d16 + d24) * d30;
            d9 = (d23 + d25) * d30;
            double d31 = (d17 - d27) * d30;
            d11 = sqrt2 * 0.5d;
            d10 = d31;
        } else if (d26 > d18) {
            double sqrt3 = Math.sqrt(((d26 + 1.0d) - d22) - d18);
            double d32 = 0.5d / sqrt3;
            d11 = (d23 + d25) * d32;
            d8 = (d27 + d17) * d32;
            d10 = (d24 - d16) * d32;
            d9 = sqrt3 * 0.5d;
        } else {
            double sqrt4 = Math.sqrt(((d18 + 1.0d) - d22) - d26);
            double d33 = 0.5d / sqrt4;
            d9 = (d27 + d17) * d33;
            double d34 = (d25 - d23) * d33;
            d8 = sqrt4 * 0.5d;
            d10 = d34;
            d11 = (d16 + d24) * d33;
        }
        double d35 = this.w;
        double d36 = d35 * d11;
        double d37 = this.x;
        double d38 = (d37 * d10) + d36;
        double d39 = this.y;
        double d40 = (d39 * d8) + d38;
        double d41 = this.z;
        quaterniond.set(d40 - (d41 * d9), (d41 * d11) + (d39 * d10) + ((d35 * d9) - (d37 * d8)), (d41 * d10) + (((d37 * d9) + (d35 * d8)) - (d39 * d11)), (((d35 * d10) - (d37 * d11)) - (d39 * d9)) - (d41 * d8));
        return quaterniond;
    }

    public Quaterniond rotateAxis(double d2, Vector3dc vector3dc, Quaterniond quaterniond) {
        return rotateAxis(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniond);
    }

    public Quaterniond setFromUnnormalized(Matrix4fc matrix4fc) {
        double m00 = (double) matrix4fc.m00();
        setFromUnnormalized(m00, (double) matrix4fc.m01(), (double) matrix4fc.m02(), (double) matrix4fc.m10(), (double) matrix4fc.m11(), (double) matrix4fc.m12(), (double) matrix4fc.m20(), (double) matrix4fc.m21(), (double) matrix4fc.m22());
        return this;
    }

    public Vector3d transform(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d5 = this.w;
        double d6 = d5 * d5;
        double d7 = this.x;
        double d8 = d7 * d7;
        double d9 = this.y;
        double d10 = d9 * d9;
        double d11 = this.z;
        double d12 = d11 * d11;
        double d13 = d11 * d5;
        double d14 = d13 + d13;
        double d15 = d7 * d9;
        double d16 = d15 + d15;
        double d17 = d7 * d11;
        double d18 = d17 + d17;
        double d19 = d9 * d5;
        double d20 = d19 + d19;
        double d21 = d9 * d11;
        double d22 = d21 + d21;
        double d23 = d7 * d5;
        double d24 = d23 + d23;
        double b2 = a.b(d6, d8, d12, d10);
        double d25 = d16 + d14;
        double d26 = d18 - d20;
        double d27 = d16 - d14;
        double f2 = a.f(d10, d12, d6, d8);
        double d28 = d22 + d24;
        double d29 = d20 + d18;
        double d30 = d22 - d24;
        double g2 = a.g(d12, d10, d8, d6);
        double d31 = d29 * d4;
        vector3d2.x = d31 + (d27 * d3) + (b2 * d2);
        double d32 = d30 * d4;
        vector3d2.y = d32 + (f2 * d3) + (d25 * d2);
        double d33 = g2 * d4;
        vector3d2.z = d33 + (d28 * d3) + (d26 * d2);
        return vector3d2;
    }

    public Quaterniond get(Quaterniond quaterniond) {
        return quaterniond.set((Quaterniondc) this);
    }

    public Quaterniond rotateAxis(double d2, Vector3dc vector3dc) {
        return rotateAxis(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), this);
    }

    public Quaterniond rotateTo(double d2, double d3, double d4, double d5, double d6, double d7) {
        return rotateTo(d2, d3, d4, d5, d6, d7, this);
    }

    public Quaterniond set(Quaterniondc quaterniondc) {
        this.x = quaterniondc.x();
        this.y = quaterniondc.y();
        this.z = quaterniondc.z();
        this.w = quaterniondc.w();
        return this;
    }

    public Quaterniond setFromUnnormalized(Matrix4x3fc matrix4x3fc) {
        double m00 = (double) matrix4x3fc.m00();
        setFromUnnormalized(m00, (double) matrix4x3fc.m01(), (double) matrix4x3fc.m02(), (double) matrix4x3fc.m10(), (double) matrix4x3fc.m11(), (double) matrix4x3fc.m12(), (double) matrix4x3fc.m20(), (double) matrix4x3fc.m21(), (double) matrix4x3fc.m22());
        return this;
    }

    public Quaterniond add(Quaterniondc quaterniondc) {
        this.x = quaterniondc.x() + this.x;
        this.y = quaterniondc.y() + this.y;
        this.z = quaterniondc.z() + this.z;
        this.w = quaterniondc.w() + this.w;
        return this;
    }

    public Quaterniond invert() {
        return invert(this);
    }

    public Quaterniond normalize(Quaterniond quaterniond) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = this.w;
        double e2 = a.e(d8, d8, d7, 1.0d);
        quaterniond.x = this.x * e2;
        quaterniond.y = this.y * e2;
        quaterniond.z = this.z * e2;
        quaterniond.w = this.w * e2;
        return quaterniond;
    }

    public Quaterniond rotateAxis(double d2, double d3, double d4, double d5) {
        return rotateAxis(d2, d3, d4, d5, this);
    }

    public Quaterniond rotateTo(Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniond quaterniond) {
        return rotateTo(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), quaterniond);
    }

    public Quaterniond setAngleAxis(double d2, Vector3dc vector3dc) {
        return setAngleAxis(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Quaterniond setFromUnnormalized(Matrix4x3dc matrix4x3dc) {
        setFromUnnormalized(matrix4x3dc.m00(), matrix4x3dc.m01(), matrix4x3dc.m02(), matrix4x3dc.m10(), matrix4x3dc.m11(), matrix4x3dc.m12(), matrix4x3dc.m20(), matrix4x3dc.m21(), matrix4x3dc.m22());
        return this;
    }

    public Quaterniond div(Quaterniondc quaterniondc) {
        return div(quaterniondc, this);
    }

    public Quaterniond mul(double d2, double d3, double d4, double d5) {
        double d6 = this.w;
        double d7 = d6 * d2;
        double d8 = this.x;
        double d9 = (d8 * d5) + d7;
        double d10 = this.y;
        double d11 = (d10 * d4) + d9;
        double d12 = this.z;
        double d13 = (((d6 * d5) - (d8 * d2)) - (d10 * d3)) - (d12 * d4);
        set(d11 - (d12 * d3), (d12 * d2) + (d10 * d5) + ((d6 * d3) - (d8 * d4)), (d12 * d5) + (((d8 * d3) + (d6 * d4)) - (d10 * d2)), d13);
        return this;
    }

    public Quaterniond premul(double d2, double d3, double d4, double d5) {
        return premul(d2, d3, d4, d5, this);
    }

    public Quaterniond rotateTo(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotateTo(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Quaterniond setFromUnnormalized(Matrix4dc matrix4dc) {
        setFromUnnormalized(matrix4dc.m00(), matrix4dc.m01(), matrix4dc.m02(), matrix4dc.m10(), matrix4dc.m11(), matrix4dc.m12(), matrix4dc.m20(), matrix4dc.m21(), matrix4dc.m22());
        return this;
    }

    public Quaterniond(Quaterniondc quaterniondc) {
        this.x = quaterniondc.x();
        this.y = quaterniondc.y();
        this.z = quaterniondc.z();
        this.w = quaterniondc.w();
    }

    public Quaterniond mul(double d2, double d3, double d4, double d5, Quaterniond quaterniond) {
        double d6 = this.w;
        double d7 = d6 * d2;
        double d8 = this.x;
        double d9 = (d8 * d5) + d7;
        double d10 = this.y;
        double d11 = (d10 * d4) + d9;
        double d12 = this.z;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d11 - (d12 * d3), (d12 * d2) + (d10 * d5) + ((d6 * d3) - (d8 * d4)), (d12 * d5) + (((d8 * d3) + (d6 * d4)) - (d10 * d2)), (((d6 * d5) - (d8 * d2)) - (d10 * d3)) - (d12 * d4));
        return quaterniond;
    }

    public Quaterniond premul(double d2, double d3, double d4, double d5, Quaterniond quaterniond) {
        double d6 = this.x;
        double d7 = d5 * d6;
        double d8 = this.w;
        double d9 = (d2 * d8) + d7;
        double d10 = this.z;
        double d11 = (d3 * d10) + d9;
        double d12 = this.y;
        Quaterniond quaterniond2 = quaterniond;
        quaterniond2.set(d11 - (d4 * d12), (d4 * d6) + (d3 * d8) + ((d5 * d12) - (d2 * d10)), (d4 * d8) + (((d2 * d12) + (d5 * d10)) - (d3 * d6)), (((d8 * d5) - (d6 * d2)) - (d3 * d12)) - (d4 * d10));
        return quaterniond;
    }

    public Quaterniond setFromUnnormalized(Matrix3fc matrix3fc) {
        double m00 = (double) matrix3fc.m00();
        setFromUnnormalized(m00, (double) matrix3fc.m01(), (double) matrix3fc.m02(), (double) matrix3fc.m10(), (double) matrix3fc.m11(), (double) matrix3fc.m12(), (double) matrix3fc.m20(), (double) matrix3fc.m21(), (double) matrix3fc.m22());
        return this;
    }

    public Vector4d transformPositiveX(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d2;
        double d10 = d4 * d6;
        double d11 = d4 * d8;
        double d12 = d6 * d2;
        vector4d2.x = a.b(d3, d5, d8 * d8, d7);
        vector4d2.y = a.a(d10, d9, d9, d10);
        vector4d2.z = a.f(d11, d12, d11, d12);
        return vector4d2;
    }

    public Vector4d transformPositiveY(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d8;
        double d10 = d5;
        double d11 = d8 * d2;
        double d12 = d4 * d6;
        double d13 = d6 * d8;
        double d14 = d4 * d2;
        vector4d2.x = (((-d11) + d12) - d11) + d12;
        vector4d2.y = a.f(d7, d9, d3, d10);
        vector4d2.z = a.a(d13, d13, d14, d14);
        return vector4d2;
    }

    public Vector4d transformPositiveZ(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d6 * d6;
        double d8 = this.z;
        double d9 = d8 * d8;
        double d10 = d4 * d8;
        double d11 = d6 * d2;
        double d12 = d6 * d8;
        double d13 = d4 * d2;
        vector4d2.x = a.a(d11, d10, d10, d11);
        vector4d2.y = a.b(d12, d12, d13, d13);
        vector4d2.z = a.g(d9, d7, d5, d3);
        return vector4d2;
    }

    public Vector4d transformUnitPositiveX(Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d2 = this.y;
        double d3 = d2 * d2;
        double d4 = this.z;
        double d5 = d4 * d4;
        double d6 = this.x;
        double d7 = d6 * d2;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector4d2.x = (((1.0d - d3) - d3) - d5) - d5;
        vector4d2.y = a.a(d7, d11, d7, d11);
        vector4d2.z = a.f(d8, d10, d8, d10);
        return vector4d2;
    }

    public Vector3d transformUnitPositiveY(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.z;
        double d5 = d4 * d4;
        double d6 = this.y;
        double d7 = d2 * d6;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector3d2.x = a.f(d7, d11, d7, d11);
        vector3d2.y = (((1.0d - d3) - d3) - d5) - d5;
        vector3d2.z = a.a(d8, d8, d10, d10);
        return vector3d2;
    }

    public Vector3d transformUnitPositiveZ(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = d4 * d4;
        double d6 = this.z;
        double d7 = d2 * d6;
        double d8 = d6 * d4;
        double d9 = this.w;
        double d10 = d2 * d9;
        double d11 = d4 * d9;
        vector3d2.x = a.a(d7, d11, d7, d11);
        vector3d2.y = a.b(d8, d8, d10, d10);
        vector3d2.z = (((1.0d - d3) - d3) - d5) - d5;
        return vector3d2;
    }

    public Quaterniond set(Quaternionfc quaternionfc) {
        this.x = (double) quaternionfc.x();
        this.y = (double) quaternionfc.y();
        this.z = (double) quaternionfc.z();
        this.w = (double) quaternionfc.w();
        return this;
    }

    public Quaterniond setFromUnnormalized(Matrix3dc matrix3dc) {
        setFromUnnormalized(matrix3dc.m00(), matrix3dc.m01(), matrix3dc.m02(), matrix3dc.m10(), matrix3dc.m11(), matrix3dc.m12(), matrix3dc.m20(), matrix3dc.m21(), matrix3dc.m22());
        return this;
    }

    public Quaterniond add(Quaterniondc quaterniondc, Quaterniond quaterniond) {
        quaterniond.x = quaterniondc.x() + this.x;
        quaterniond.y = quaterniondc.y() + this.y;
        quaterniond.z = quaterniondc.z() + this.z;
        quaterniond.w = quaterniondc.w() + this.w;
        return quaterniond;
    }

    public Quaterniond nlerpIterative(Quaterniondc quaterniondc, double d2, double d3) {
        return nlerpIterative(quaterniondc, d2, d3, this);
    }

    public Vector4d transform(Vector4dc vector4dc, Vector4d vector4d) {
        return transform(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4d);
    }

    public static Quaterniondc nlerp(Quaterniond[] quaterniondArr, double[] dArr, Quaterniond quaterniond) {
        quaterniond.set((Quaterniondc) quaterniondArr[0]);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < quaterniondArr.length; i2++) {
            double d3 = dArr[i2];
            d2 += d3;
            quaterniond.nlerp(quaterniondArr[i2], d3 / d2);
        }
        return quaterniond;
    }

    public static Quaterniond nlerpIterative(Quaterniondc[] quaterniondcArr, double[] dArr, double d2, Quaterniond quaterniond) {
        quaterniond.set(quaterniondcArr[0]);
        double d3 = dArr[0];
        for (int i2 = 1; i2 < quaterniondcArr.length; i2++) {
            double d4 = dArr[i2];
            d3 += d4;
            Quaterniond quaterniond2 = quaterniond;
            quaterniond2.nlerpIterative(quaterniondcArr[i2], d4 / d3, d2);
        }
        return quaterniond;
    }

    public static Quaterniondc slerp(Quaterniond[] quaterniondArr, double[] dArr, Quaterniond quaterniond) {
        quaterniond.set((Quaterniondc) quaterniondArr[0]);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < quaterniondArr.length; i2++) {
            double d3 = dArr[i2];
            d2 += d3;
            quaterniond.slerp(quaterniondArr[i2], d3 / d2);
        }
        return quaterniond;
    }

    public Vector4d transform(double d2, double d3, double d4, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d5 = this.w;
        double d6 = d5 * d5;
        double d7 = this.x;
        double d8 = d7 * d7;
        double d9 = this.y;
        double d10 = d9 * d9;
        double d11 = this.z;
        double d12 = d11 * d11;
        double d13 = d11 * d5;
        double d14 = d13 + d13;
        double d15 = d7 * d9;
        double d16 = d15 + d15;
        double d17 = d7 * d11;
        double d18 = d17 + d17;
        double d19 = d9 * d5;
        double d20 = d19 + d19;
        double d21 = d9 * d11;
        double d22 = d21 + d21;
        double d23 = d7 * d5;
        double d24 = d23 + d23;
        double b2 = a.b(d6, d8, d12, d10);
        double d25 = d16 + d14;
        double d26 = d18 - d20;
        double d27 = d16 - d14;
        double f2 = a.f(d10, d12, d6, d8);
        double d28 = d22 + d24;
        double d29 = d20 + d18;
        double d30 = d22 - d24;
        double g2 = a.g(d12, d10, d8, d6);
        double d31 = d29 * d4;
        vector4d2.x = d31 + (d27 * d3) + (b2 * d2);
        double d32 = d30 * d4;
        vector4d2.y = d32 + (f2 * d3) + (d25 * d2);
        double d33 = g2 * d4;
        vector4d2.z = d33 + (d28 * d3) + (d26 * d2);
        return vector4d2;
    }

    public Quaterniond(Quaternionfc quaternionfc) {
        this.x = (double) quaternionfc.x();
        this.y = (double) quaternionfc.y();
        this.z = (double) quaternionfc.z();
        this.w = (double) quaternionfc.w();
    }

    public Quaterniond set(AxisAngle4f axisAngle4f) {
        return setAngleAxis((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Quaterniond rotationTo(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotationTo(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Quaterniond set(AxisAngle4d axisAngle4d) {
        return setAngleAxis(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Quaterniond(AxisAngle4f axisAngle4f) {
        double sin = Math.sin(((double) axisAngle4f.angle) * 0.5d);
        this.x = ((double) axisAngle4f.x) * sin;
        this.y = ((double) axisAngle4f.y) * sin;
        this.z = ((double) axisAngle4f.z) * sin;
        this.w = Math.cosFromSin(sin, ((double) axisAngle4f.angle) * 0.5d);
    }

    public Quaterniond setFromNormalized(Matrix4fc matrix4fc) {
        double m00 = (double) matrix4fc.m00();
        setFromNormalized(m00, (double) matrix4fc.m01(), (double) matrix4fc.m02(), (double) matrix4fc.m10(), (double) matrix4fc.m11(), (double) matrix4fc.m12(), (double) matrix4fc.m20(), (double) matrix4fc.m21(), (double) matrix4fc.m22());
        return this;
    }

    public Quaterniond setFromNormalized(Matrix4x3fc matrix4x3fc) {
        double m00 = (double) matrix4x3fc.m00();
        setFromNormalized(m00, (double) matrix4x3fc.m01(), (double) matrix4x3fc.m02(), (double) matrix4x3fc.m10(), (double) matrix4x3fc.m11(), (double) matrix4x3fc.m12(), (double) matrix4x3fc.m20(), (double) matrix4x3fc.m21(), (double) matrix4x3fc.m22());
        return this;
    }

    public Quaterniond setFromNormalized(Matrix4x3dc matrix4x3dc) {
        setFromNormalized(matrix4x3dc.m00(), matrix4x3dc.m01(), matrix4x3dc.m02(), matrix4x3dc.m10(), matrix4x3dc.m11(), matrix4x3dc.m12(), matrix4x3dc.m20(), matrix4x3dc.m21(), matrix4x3dc.m22());
        return this;
    }

    public Quaterniond(AxisAngle4d axisAngle4d) {
        double sin = Math.sin(axisAngle4d.angle * 0.5d);
        this.x = axisAngle4d.x * sin;
        this.y = axisAngle4d.y * sin;
        this.z = axisAngle4d.z * sin;
        this.w = Math.cosFromSin(sin, axisAngle4d.angle * 0.5d);
    }

    public Quaterniond setFromNormalized(Matrix4dc matrix4dc) {
        setFromNormalized(matrix4dc.m00(), matrix4dc.m01(), matrix4dc.m02(), matrix4dc.m10(), matrix4dc.m11(), matrix4dc.m12(), matrix4dc.m20(), matrix4dc.m21(), matrix4dc.m22());
        return this;
    }

    public Quaterniond setFromNormalized(Matrix3fc matrix3fc) {
        double m00 = (double) matrix3fc.m00();
        setFromNormalized(m00, (double) matrix3fc.m01(), (double) matrix3fc.m02(), (double) matrix3fc.m10(), (double) matrix3fc.m11(), (double) matrix3fc.m12(), (double) matrix3fc.m20(), (double) matrix3fc.m21(), (double) matrix3fc.m22());
        return this;
    }

    public Quaterniond setFromNormalized(Matrix3dc matrix3dc) {
        setFromNormalized(matrix3dc.m00(), matrix3dc.m01(), matrix3dc.m02(), matrix3dc.m10(), matrix3dc.m11(), matrix3dc.m12(), matrix3dc.m20(), matrix3dc.m21(), matrix3dc.m22());
        return this;
    }
}
