package com.arashivision.onestream.math;

import com.arashivision.onestream.WorldParameters;
import com.arashivision.onestream.math.vector.Vector3;
import com.arashivision.onestream.math.vector.Vector3.Axis;
import e.a.a.a.a;
import java.io.Serializable;

public final class Quaternion implements Serializable {
    public static final double F_EPSILON = 0.001d;
    public static final double NORMALIZATION_TOLERANCE = 1.0E-5d;
    public static final Quaternion sTmp1;
    public static final Quaternion sTmp2;
    public static final long serialVersionUID = 8251601685028088673L;
    public transient Vector3 mTmpVec1 = new Vector3();
    public transient Vector3 mTmpVec2 = new Vector3();
    public transient Vector3 mTmpVec3 = new Vector3();
    public double w;
    public double x;
    public double y;
    public double z;

    static {
        Quaternion quaternion = new Quaternion(0.0d, 0.0d, 0.0d, 0.0d);
        sTmp1 = quaternion;
        Quaternion quaternion2 = new Quaternion(0.0d, 0.0d, 0.0d, 0.0d);
        sTmp2 = quaternion2;
    }

    public Quaternion() {
        identity();
    }

    public static Quaternion createFromRotationBetween(Vector3 vector3, Vector3 vector32) {
        Quaternion quaternion = new Quaternion();
        quaternion.fromRotationBetween(vector3, vector32);
        return quaternion;
    }

    public static Quaternion getIdentity() {
        Quaternion quaternion = new Quaternion(1.0d, 0.0d, 0.0d, 0.0d);
        return quaternion;
    }

    public static Quaternion lerp(Quaternion quaternion, Quaternion quaternion2, double d2, boolean z2) {
        sTmp1.setAll(quaternion);
        sTmp2.setAll(quaternion2);
        if (sTmp1.dot(sTmp2) >= 0.0d || !z2) {
            sTmp2.subtract(sTmp1);
            sTmp2.multiply(d2);
            sTmp1.add(sTmp2);
        } else {
            sTmp2.inverse();
            sTmp2.subtract(sTmp1);
            sTmp2.multiply(d2);
            sTmp1.add(sTmp2);
        }
        return sTmp1;
    }

    public static Quaternion lookAtAndCreate(Vector3 vector3, Vector3 vector32) {
        return new Quaternion().lookAt(vector3, vector32);
    }

    public static Quaternion nlerp(Quaternion quaternion, Quaternion quaternion2, double d2, boolean z2) {
        Quaternion lerp = lerp(quaternion, quaternion2, d2, z2);
        lerp.normalize();
        return lerp;
    }

    public static Quaternion slerpAndCreate(Quaternion quaternion, Quaternion quaternion2, double d2) {
        Quaternion quaternion3 = new Quaternion();
        quaternion3.slerp(quaternion, quaternion2, d2);
        return quaternion3;
    }

    public Quaternion add(Quaternion quaternion) {
        this.w += quaternion.w;
        this.x += quaternion.x;
        this.y += quaternion.y;
        this.z += quaternion.z;
        return this;
    }

    public double angleBetween(Quaternion quaternion) {
        double acos = Math.acos(Math.max(-1.0d, Math.min(1.0d, dot(quaternion))));
        if (acos > 1.5707963267948966d) {
            return Math.abs(3.141592653589793d - acos);
        }
        return Math.abs(acos);
    }

    public Quaternion computeW() {
        double d2 = this.x;
        double d3 = 1.0d - (d2 * d2);
        double d4 = this.y;
        double d5 = d3 - (d4 * d4);
        double d6 = this.z;
        double d7 = d5 - (d6 * d6);
        if (d7 < 0.0d) {
            this.w = 0.0d;
        } else {
            this.w = -Math.sqrt(d7);
        }
        return this;
    }

    public Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public double dot(Quaternion quaternion) {
        return (this.z * quaternion.z) + (this.y * quaternion.y) + (this.x * quaternion.x) + (this.w * quaternion.w);
    }

    public boolean equals(Object obj) {
        boolean z2 = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quaternion)) {
            return false;
        }
        Quaternion quaternion = (Quaternion) obj;
        if (!(this.x == quaternion.x && this.y == quaternion.y && this.z == quaternion.z && this.w == quaternion.w)) {
            z2 = false;
        }
        return z2;
    }

    public Quaternion exp() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double sqrt = Math.sqrt((d6 * d6) + d5);
        double sin = Math.sin(sqrt);
        this.w = Math.cos(sqrt);
        if (Math.abs(sin) >= 0.001d) {
            double d7 = sin / sqrt;
            this.x *= d7;
            this.y *= d7;
            this.z = d7 * this.z;
        }
        return this;
    }

    public Quaternion expAndCreate() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double sqrt = Math.sqrt((d6 * d6) + d5);
        double sin = Math.sin(sqrt);
        Quaternion quaternion = new Quaternion();
        quaternion.w = Math.cos(sqrt);
        if (Math.abs(sin) >= 0.001d) {
            double d7 = sin / sqrt;
            quaternion.x = this.x * d7;
            quaternion.y = this.y * d7;
            quaternion.z = d7 * this.z;
        } else {
            quaternion.x = this.x;
            quaternion.y = this.y;
            quaternion.z = this.z;
        }
        return quaternion;
    }

    public Quaternion fromAngleAxis(Axis axis, double d2) {
        fromAngleAxis(Vector3.getAxisVector(axis), d2);
        return this;
    }

    public Quaternion fromAxes(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Vector3 vector34 = vector3;
        Vector3 vector35 = vector32;
        Vector3 vector36 = vector33;
        return fromAxes(vector34.x, vector34.y, vector34.z, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z);
    }

    public Quaternion fromEuler(double d2, double d3, double d4) {
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        double radians3 = Math.toRadians(d4) * 0.5d;
        double sin = Math.sin(radians3);
        double cos = Math.cos(radians3);
        double d5 = radians2 * 0.5d;
        double sin2 = Math.sin(d5);
        double cos2 = Math.cos(d5);
        double d6 = radians * 0.5d;
        double sin3 = Math.sin(d6);
        double cos3 = Math.cos(d6);
        double d7 = cos3 * sin2;
        double d8 = sin3 * cos2;
        double d9 = cos3 * cos2;
        double d10 = sin3 * sin2;
        this.x = (d8 * sin) + (d7 * cos);
        this.y = (d8 * cos) - (d7 * sin);
        this.z = (d9 * sin) - (d10 * cos);
        this.w = (d10 * sin) + (d9 * cos);
        return this;
    }

    public Quaternion fromMatrix(Matrix4 matrix4) {
        double[] dArr = new double[16];
        matrix4.toArray(dArr);
        fromAxes(dArr[0], dArr[4], dArr[8], dArr[1], dArr[5], dArr[9], dArr[2], dArr[6], dArr[10]);
        return this;
    }

    public Quaternion fromRotationBetween(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        double clamp = MathUtil.clamp(vector3.dot(vector32), -1.0d, 1.0d);
        if (1.0d - Math.abs(clamp) > 1.0E-6d) {
            double degrees = Math.toDegrees(Math.acos(clamp));
            double d2 = vector33.y;
            double d3 = vector34.z;
            double d4 = d2 * d3;
            double d5 = vector33.z;
            double d6 = vector34.y;
            double d7 = d4 - (d5 * d6);
            double d8 = degrees;
            double d9 = vector34.x;
            double d10 = d5 * d9;
            double d11 = vector33.x;
            return fromAngleAxis(d7, d10 - (d3 * d11), (d11 * d6) - (d2 * d9), d8);
        } else if (clamp >= 0.0d) {
            return identity();
        } else {
            this.mTmpVec3.crossAndSet(WorldParameters.RIGHT_AXIS, vector33);
            if (this.mTmpVec3.length() < 1.0E-6d) {
                this.mTmpVec3.crossAndSet(WorldParameters.UP_AXIS, vector33);
            }
            this.mTmpVec3.normalize();
            return fromAngleAxis(this.mTmpVec3, 180.0d);
        }
    }

    @Deprecated
    public Quaternion fromRotationMatrix(double[] dArr) {
        double d2 = dArr[0] + dArr[5] + dArr[10];
        if (d2 > 0.0d) {
            double sqrt = Math.sqrt(d2 + 1.0d);
            this.w = sqrt * 0.5d;
            double d3 = 0.5d / sqrt;
            this.x = (dArr[9] - dArr[6]) * d3;
            this.y = (dArr[2] - dArr[8]) * d3;
            this.z = (dArr[4] - dArr[1]) * d3;
        } else {
            int[] iArr = {1, 2, 0};
            int i2 = dArr[5] > dArr[0] ? 1 : 0;
            if (dArr[10] > dArr[(i2 * 4) + i2]) {
                i2 = 2;
            }
            int i3 = iArr[i2];
            int i4 = iArr[i3];
            int i5 = i2 * 4;
            int i6 = i3 * 4;
            int i7 = i4 * 4;
            double sqrt2 = Math.sqrt(((dArr[i5 + i2] - dArr[i6 + i3]) - dArr[i7 + i4]) + 1.0d);
            double[] dArr2 = {this.x, this.y, this.z};
            dArr2[i2] = sqrt2 * 0.5d;
            double d4 = 0.5d / sqrt2;
            this.w = (dArr[i7 + i3] - dArr[i6 + i4]) * d4;
            dArr2[i3] = (dArr[i6 + i2] + dArr[i5 + i3]) * d4;
            dArr2[i4] = (dArr[i7 + i2] + dArr[i5 + i4]) * d4;
            this.x = dArr2[0];
            this.y = dArr2[1];
            this.z = dArr2[2];
        }
        return this;
    }

    public Vector3 getAxis(Axis axis) {
        if (axis == Axis.X) {
            return getXAxis();
        }
        if (axis == Axis.Y) {
            return getYAxis();
        }
        return getZAxis();
    }

    public int getGimbalPole() {
        double d2 = (this.z * this.w) + (this.y * this.x);
        if (d2 > 0.499d) {
            return 1;
        }
        return d2 < -0.499d ? -1 : 0;
    }

    public double getPitch() {
        normalize();
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? Math.asin(MathUtil.clamp(((this.w * this.x) - (this.z * this.y)) * 2.0d, -1.0d, 1.0d)) : ((double) gimbalPole) * 3.141592653589793d * 0.5d;
    }

    public double getRoll() {
        normalize();
        int gimbalPole = getGimbalPole();
        if (gimbalPole != 0) {
            return ((double) gimbalPole) * 2.0d * Math.atan2(this.y, this.w);
        }
        double d2 = this.w;
        double d3 = this.z;
        double d4 = d2 * d3;
        double d5 = this.y;
        double d6 = this.x;
        return Math.atan2(a.k(d5, d6, d4, 2.0d), 1.0d - (((d3 * d3) + (d6 * d6)) * 2.0d));
    }

    public Vector3 getXAxis() {
        double d2 = this.y;
        double d3 = d2 * 2.0d;
        double d4 = this.z;
        double d5 = 2.0d * d4;
        double d6 = this.w;
        double d7 = d3 * d6;
        double d8 = d6 * d5;
        double d9 = this.x;
        Vector3 vector3 = new Vector3(1.0d - ((d3 * d2) + (d5 * d4)), (d3 * d9) + d8, (d9 * d5) - d7);
        return vector3;
    }

    public Vector3 getYAxis() {
        double d2 = this.x;
        double d3 = d2 * 2.0d;
        double d4 = this.y;
        double d5 = d4 * 2.0d;
        double d6 = this.z;
        double d7 = 2.0d * d6;
        double d8 = this.w;
        double d9 = d3 * d8;
        Vector3 vector3 = new Vector3((d5 * d2) - (d8 * d7), 1.0d - ((d3 * d2) + (d7 * d6)), (d4 * d7) + d9);
        return vector3;
    }

    public double getYaw() {
        normalize();
        if (getGimbalPole() != 0) {
            return 0.0d;
        }
        double d2 = this.y;
        double d3 = this.w * d2;
        double d4 = this.x;
        return Math.atan2(a.k(this.z, d4, d3, 2.0d), 1.0d - (((d4 * d4) + (d2 * d2)) * 2.0d));
    }

    public Vector3 getZAxis() {
        double d2 = this.x;
        double d3 = d2 * 2.0d;
        double d4 = this.y;
        double d5 = d4 * 2.0d;
        double d6 = this.z * 2.0d;
        double d7 = this.w;
        double d8 = d3 * d7;
        double d9 = d3 * d2;
        double d10 = d2 * d6;
        Vector3 vector3 = new Vector3(d10 + (d7 * d5), (d6 * d4) - d8, 1.0d - (d9 + (d5 * d4)));
        return vector3;
    }

    public Quaternion identity() {
        this.w = 1.0d;
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
        return this;
    }

    public Quaternion inverse() {
        double length2 = length2();
        if (length2 > 0.0d) {
            double d2 = 1.0d / length2;
            setAll(this.w * d2, (-this.x) * d2, (-this.y) * d2, (-this.z) * d2);
        }
        return this;
    }

    public Quaternion invertAndCreate() {
        double length2 = length2();
        if (length2 <= 0.0d) {
            return null;
        }
        double d2 = 1.0d / length2;
        Quaternion quaternion = new Quaternion(this.w * d2, (-this.x) * d2, (-this.y) * d2, (-this.z) * d2);
        return quaternion;
    }

    public double length() {
        return Math.sqrt(length2());
    }

    public double length2() {
        double d2 = this.w;
        double d3 = d2 * d2;
        double d4 = this.x;
        double d5 = (d4 * d4) + d3;
        double d6 = this.y;
        double d7 = (d6 * d6) + d5;
        double d8 = this.z;
        return (d8 * d8) + d7;
    }

    public Quaternion log() {
        if (Math.abs(this.w) < 1.0d) {
            double acos = Math.acos(this.w);
            double sin = Math.sin(acos);
            if (Math.abs(sin) >= 0.001d) {
                double d2 = acos / sin;
                this.x *= d2;
                this.y *= d2;
                this.z = d2 * this.z;
            }
        }
        this.w = 0.0d;
        return this;
    }

    public Quaternion logAndCreate() {
        Quaternion quaternion = new Quaternion();
        quaternion.w = 0.0d;
        if (Math.abs(this.w) < 1.0d) {
            double acos = Math.acos(this.w);
            double sin = Math.sin(acos);
            if (Math.abs(sin) >= 0.001d) {
                double d2 = acos / sin;
                quaternion.x = this.x * d2;
                quaternion.y = this.y * d2;
                quaternion.z = d2 * this.z;
                return quaternion;
            }
        }
        quaternion.x = this.x;
        quaternion.y = this.y;
        quaternion.z = this.z;
        return quaternion;
    }

    public Quaternion lookAt(Vector3 vector3, Vector3 vector32) {
        this.mTmpVec1.setAll(vector3);
        this.mTmpVec2.setAll(vector32);
        double dot = Vector3.dot(vector3, vector32);
        if (Math.abs(Math.abs(dot) - (vector32.length() * vector3.length())) <= 1.0E-6d) {
            this.mTmpVec2.normalize();
            if (dot < 0.0d) {
                this.mTmpVec1.inverse();
            }
            fromRotationBetween(WorldParameters.FORWARD_AXIS, this.mTmpVec1);
            return this;
        }
        Vector3.orthoNormalize(this.mTmpVec1, this.mTmpVec2);
        this.mTmpVec3.crossAndSet(this.mTmpVec1, this.mTmpVec2);
        fromAxes(this.mTmpVec3, this.mTmpVec2, this.mTmpVec1);
        return this;
    }

    public Quaternion multiply(double d2) {
        this.w *= d2;
        this.x *= d2;
        this.y *= d2;
        this.z *= d2;
        return this;
    }

    public Quaternion multiplyLeft(Quaternion quaternion) {
        Quaternion quaternion2 = quaternion;
        double d2 = quaternion2.w;
        double d3 = this.x;
        double d4 = d2 * d3;
        double d5 = quaternion2.x;
        double d6 = this.w;
        double d7 = (d5 * d6) + d4;
        double d8 = quaternion2.y;
        double d9 = this.z;
        double d10 = (d8 * d9) + d7;
        double d11 = quaternion2.z;
        double d12 = d5;
        double d13 = this.y;
        return setAll(((d8 * d13) + ((d2 * d6) - (d3 * d12))) - (d11 * d9), d10 - (d11 * d13), ((d11 * d3) + ((d8 * d6) + (d2 * d13))) - (d12 * d9), ((d12 * d13) + ((d11 * d6) + (d2 * d9))) - (d8 * d3));
    }

    public double normalize() {
        double length2 = length2();
        if (length2 != 0.0d && Math.abs(length2 - 1.0d) > 1.0E-5d) {
            multiply(1.0d / Math.sqrt(length2));
        }
        return length2;
    }

    public Quaternion setAll(double d2, double d3, double d4, double d5) {
        this.w = d2;
        this.x = d3;
        this.y = d4;
        this.z = d5;
        return this;
    }

    public Quaternion slerp(Quaternion quaternion, double d2) {
        double dot = dot(quaternion);
        int i2 = (dot > 0.0d ? 1 : (dot == 0.0d ? 0 : -1));
        if (i2 < 0) {
            dot = -dot;
        }
        double d3 = 1.0d - d2;
        if (1.0d - dot > 0.1d) {
            double acos = Math.acos(dot);
            double sin = 1.0d / Math.sin(acos);
            d3 = Math.sin(d3 * acos) * sin;
            d2 = Math.sin(d2 * acos * sin);
        }
        if (i2 < 0) {
            d2 = -d2;
        }
        this.x = (quaternion.x * d2) + (this.x * d3);
        this.y = (quaternion.y * d2) + (this.y * d3);
        this.z = (quaternion.z * d2) + (this.z * d3);
        this.w = (d2 * quaternion.w) + (d3 * this.w);
        return this;
    }

    public Quaternion subtract(Quaternion quaternion) {
        this.w -= quaternion.w;
        this.x -= quaternion.x;
        this.y -= quaternion.y;
        this.z -= quaternion.z;
        return this;
    }

    public double toAngleAxis(Vector3 vector3) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double d7 = (d6 * d6) + d5;
        double d8 = 0.0d;
        if (d7 != 0.0d) {
            d8 = 2.0d * Math.acos(this.w);
            if (vector3 != null) {
                double sqrt = 1.0d / Math.sqrt(d7);
                vector3.x = this.x * sqrt;
                vector3.y = this.y * sqrt;
                vector3.z = this.z * sqrt;
            }
        } else if (vector3 != null) {
            vector3.x = 1.0d;
            vector3.y = 0.0d;
            vector3.z = 0.0d;
        }
        return d8;
    }

    public Matrix4 toRotationMatrix() {
        Matrix4 matrix4 = new Matrix4();
        toRotationMatrix(matrix4);
        return matrix4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Quaternion <w, x, y, z>: <");
        stringBuffer.append(this.w);
        String str = ", ";
        stringBuffer.append(str);
        stringBuffer.append(this.x);
        stringBuffer.append(str);
        stringBuffer.append(this.y);
        stringBuffer.append(str);
        stringBuffer.append(this.z);
        stringBuffer.append(">");
        return stringBuffer.toString();
    }

    public Quaternion clone() {
        Quaternion quaternion = new Quaternion(this.w, this.x, this.y, this.z);
        return quaternion;
    }

    public Quaternion fromAngleAxis(Vector3 vector3, double d2) {
        if (!vector3.isUnit()) {
            vector3.normalize();
        }
        double radians = Math.toRadians(d2) * 0.5d;
        double sin = Math.sin(radians);
        this.w = Math.cos(radians);
        this.x = vector3.x * sin;
        this.y = vector3.y * sin;
        this.z = sin * vector3.z;
        return this;
    }

    public Quaternion fromAxes(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17 = d2 + d6 + d10;
        if (d17 >= 0.0d) {
            double sqrt = Math.sqrt(d17 + 1.0d);
            d13 = sqrt * 0.5d;
            double d18 = 0.5d / sqrt;
            d14 = (d9 - d7) * d18;
            d12 = (d4 - d8) * d18;
            d11 = (d5 - d3) * d18;
        } else if (d2 <= d6 || d2 <= d10) {
            if (d6 > d10) {
                double sqrt2 = Math.sqrt(((d6 + 1.0d) - d2) - d10);
                d12 = sqrt2 * 0.5d;
                d15 = 0.5d / sqrt2;
                d14 = (d5 + d3) * d15;
                d11 = (d9 + d7) * d15;
                d16 = d4 - d8;
            } else {
                double sqrt3 = Math.sqrt(((d10 + 1.0d) - d2) - d6);
                d11 = sqrt3 * 0.5d;
                d15 = 0.5d / sqrt3;
                d14 = (d4 + d8) * d15;
                d12 = (d9 + d7) * d15;
                d16 = d5 - d3;
            }
            d13 = d16 * d15;
        } else {
            double sqrt4 = Math.sqrt(((d2 + 1.0d) - d6) - d10);
            double d19 = 0.5d / sqrt4;
            d12 = (d5 + d3) * d19;
            d11 = (d4 + d8) * d19;
            d14 = sqrt4 * 0.5d;
            d13 = (d9 - d7) * d19;
        }
        return setAll(d13, d14, d12, d11);
    }

    public void toRotationMatrix(Matrix4 matrix4) {
        toRotationMatrix(matrix4.getDoubleValues());
    }

    public boolean equals(Quaternion quaternion, double d2) {
        double dot = dot(quaternion);
        boolean z2 = true;
        if (dot > 1.0d && dot - 1.0d < d2) {
            return true;
        }
        double acos = Math.acos(dot);
        if (Math.abs(acos) > d2 && !MathUtil.realEqual(acos, 3.141592653589793d, d2)) {
            z2 = false;
        }
        return z2;
    }

    public void toRotationMatrix(double[] dArr) {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = d4 * d4;
        double d6 = this.z;
        double d7 = d6 * d6;
        double d8 = d2 * d4;
        double d9 = d2 * d6;
        double d10 = d4 * d6;
        double d11 = d3;
        double d12 = this.w;
        double d13 = d2 * d12;
        double d14 = d4 * d12;
        double d15 = d12 * d6;
        dArr[0] = 1.0d - ((d5 + d7) * 2.0d);
        dArr[1] = (d8 - d15) * 2.0d;
        dArr[2] = (d9 + d14) * 2.0d;
        dArr[3] = 0.0d;
        dArr[4] = (d8 + d15) * 2.0d;
        dArr[5] = 1.0d - ((d11 + d7) * 2.0d);
        dArr[6] = (d10 - d13) * 2.0d;
        dArr[7] = 0.0d;
        dArr[8] = (d9 - d14) * 2.0d;
        dArr[9] = (d10 + d13) * 2.0d;
        dArr[10] = 1.0d - ((d11 + d5) * 2.0d);
        dArr[11] = 0.0d;
        dArr[12] = 0.0d;
        dArr[13] = 0.0d;
        dArr[14] = 0.0d;
        dArr[15] = 1.0d;
    }

    public Quaternion multiply(Quaternion quaternion) {
        Quaternion quaternion2 = quaternion;
        double d2 = this.w;
        double d3 = this.x;
        double d4 = this.y;
        double d5 = this.z;
        double d6 = quaternion2.w * d2;
        double d7 = quaternion2.x;
        double d8 = d6 - (d3 * d7);
        double d9 = quaternion2.y;
        double d10 = d8 - (d4 * d9);
        double d11 = d9;
        double d12 = quaternion2.z;
        this.w = d10 - (d5 * d12);
        double d13 = d7 * d2;
        double d14 = quaternion2.w;
        this.x = ((d4 * d12) + ((d3 * d14) + d13)) - (d5 * d11);
        double d15 = (d4 * d14) + (d2 * d11);
        double d16 = quaternion2.x;
        double d17 = d4;
        this.y = ((d5 * d16) + d15) - (d3 * d12);
        this.z = ((d3 * quaternion2.y) + ((d5 * d14) + (d2 * d12))) - (d17 * d16);
        return this;
    }

    public Quaternion setAll(Quaternion quaternion) {
        return setAll(quaternion.w, quaternion.x, quaternion.y, quaternion.z);
    }

    public Quaternion(double d2, double d3, double d4, double d5) {
        setAll(d2, d3, d4, d5);
    }

    public Quaternion fromAngleAxis(double d2, double d3, double d4, double d5) {
        double length = Vector3.length(d2, d3, d4);
        if (length == 0.0d) {
            return identity();
        }
        double d6 = 1.0d / length;
        double radians = Math.toRadians(d5);
        double d7 = (radians < 0.0d ? 6.283185307179586d - ((-radians) % 6.283185307179586d) : radians % 6.283185307179586d) * 0.5d;
        double sin = Math.sin(d7);
        return setAll(Math.cos(d7), d6 * d2 * sin, d6 * d3 * sin, d6 * d4 * sin);
    }

    public Quaternion slerp(Quaternion quaternion, Quaternion quaternion2, double d2) {
        double d3;
        Quaternion quaternion3 = quaternion;
        Quaternion quaternion4 = quaternion2;
        if (quaternion3.x == quaternion4.x && quaternion3.y == quaternion4.y && quaternion3.z == quaternion4.z && quaternion3.w == quaternion4.w) {
            setAll(quaternion);
            return this;
        }
        double d4 = quaternion3.x;
        double d5 = quaternion4.x;
        double d6 = d4 * d5;
        double d7 = quaternion3.y;
        double d8 = quaternion4.y;
        double d9 = (d7 * d8) + d6;
        double d10 = quaternion3.z;
        double d11 = quaternion4.z;
        double d12 = (d10 * d11) + d9;
        double d13 = quaternion3.w;
        double d14 = quaternion4.w;
        double d15 = (d13 * d14) + d12;
        if (d15 < 0.0d) {
            quaternion4.x = -d5;
            quaternion4.y = -d8;
            quaternion4.z = -d11;
            quaternion4.w = -d14;
            d15 = -d15;
        }
        double d16 = 1.0d - d2;
        if (1.0d - d15 > 0.1d) {
            double acos = Math.acos(d15);
            double sin = 1.0d / Math.sin(acos);
            d16 = Math.sin(d16 * acos) * sin;
            d3 = sin * Math.sin(acos * d2);
        } else {
            d3 = d2;
        }
        this.x = (quaternion4.x * d3) + (quaternion3.x * d16);
        this.y = (quaternion4.y * d3) + (quaternion3.y * d16);
        this.z = (quaternion4.z * d3) + (quaternion3.z * d16);
        this.w = (d3 * quaternion4.w) + (d16 * quaternion3.w);
        return this;
    }

    public Quaternion(Quaternion quaternion) {
        setAll(quaternion);
    }

    public Quaternion fromRotationBetween(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.mTmpVec1.setAll(d2, d3, d4).normalize();
        this.mTmpVec2.setAll(d5, d6, d7).normalize();
        return fromRotationBetween(this.mTmpVec1, this.mTmpVec2);
    }

    public Vector3 multiply(Vector3 vector3) {
        this.mTmpVec3.setAll(this.x, this.y, this.z);
        this.mTmpVec1.crossAndSet(this.mTmpVec3, vector3);
        this.mTmpVec2.crossAndSet(this.mTmpVec3, this.mTmpVec1);
        this.mTmpVec1.multiply(this.w * 2.0d);
        this.mTmpVec2.multiply(2.0d);
        this.mTmpVec1.add(this.mTmpVec2);
        this.mTmpVec1.add(vector3);
        return this.mTmpVec1;
    }

    public Quaternion(Vector3 vector3, double d2) {
        fromAngleAxis(vector3, d2);
    }
}
