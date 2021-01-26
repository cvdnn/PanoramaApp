package com.arashivision.onestream.math.vector;

import com.arashivision.onestream.math.MathUtil;
import com.arashivision.onestream.math.Matrix4;
import com.arashivision.onestream.math.Quaternion;
import e.a.a.a.a;
import java.io.Serializable;

public class Vector3 implements Serializable {
    public static final Vector3 NEG_X;
    public static final Vector3 NEG_Y;
    public static final Vector3 NEG_Z;
    public static final Vector3 ONE;
    public static final Vector3 X;
    public static final Vector3 Y;
    public static final Vector3 Z;
    public static final Vector3 ZERO;
    public static final long serialVersionUID = -6912735593989098933L;
    public Vector3 mTemp;
    public double x;
    public double y;
    public double z;

    /* renamed from: com.arashivision.onestream.math.vector.Vector3$1 reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$arashivision$onestream$math$vector$Vector3$Axis;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.arashivision.onestream.math.vector.Vector3$Axis[] r0 = com.arashivision.onestream.math.vector.Vector3.Axis.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$arashivision$onestream$math$vector$Vector3$Axis = r0
                r1 = 1
                com.arashivision.onestream.math.vector.Vector3$Axis r2 = com.arashivision.onestream.math.vector.Vector3.Axis.X     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$arashivision$onestream$math$vector$Vector3$Axis     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.arashivision.onestream.math.vector.Vector3$Axis r3 = com.arashivision.onestream.math.vector.Vector3.Axis.Y     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$com$arashivision$onestream$math$vector$Vector3$Axis     // Catch:{ NoSuchFieldError -> 0x001d }
                com.arashivision.onestream.math.vector.Vector3$Axis r2 = com.arashivision.onestream.math.vector.Vector3.Axis.Z     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arashivision.onestream.math.vector.Vector3.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Axis {
        X,
        Y,
        Z
    }

    static {
        Vector3 vector3 = new Vector3(1.0d, 0.0d, 0.0d);
        X = vector3;
        Vector3 vector32 = new Vector3(0.0d, 1.0d, 0.0d);
        Y = vector32;
        Vector3 vector33 = new Vector3(0.0d, 0.0d, 1.0d);
        Z = vector33;
        Vector3 vector34 = new Vector3(-1.0d, 0.0d, 0.0d);
        NEG_X = vector34;
        Vector3 vector35 = new Vector3(0.0d, -1.0d, 0.0d);
        NEG_Y = vector35;
        Vector3 vector36 = new Vector3(0.0d, 0.0d, -1.0d);
        NEG_Z = vector36;
        Vector3 vector37 = new Vector3(0.0d, 0.0d, 0.0d);
        ZERO = vector37;
        Vector3 vector38 = new Vector3(1.0d, 1.0d, 1.0d);
        ONE = vector38;
    }

    public Vector3() {
        this.mTemp = null;
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public static Vector3 addAndCreate(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = new Vector3(vector3.x + vector32.x, vector3.y + vector32.y, vector3.z + vector32.z);
        return vector33;
    }

    public static Vector3 crossAndCreate(Vector3 vector3, Vector3 vector32) {
        double d2 = vector32.y;
        double d3 = vector3.z;
        double d4 = d2 * d3;
        double d5 = vector32.z;
        double d6 = vector3.y;
        double d7 = d4 - (d5 * d6);
        double d8 = vector3.x;
        double d9 = d5 * d8;
        double d10 = vector32.x;
        Vector3 vector33 = new Vector3(d7, d9 - (d3 * d10), (d10 * d6) - (d2 * d8));
        return vector33;
    }

    public static double distanceTo2(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d4 - d7;
        return (d10 * d10) + (d9 * d9) + (d8 * d8);
    }

    public static double dot(double d2, double d3, double d4, double d5, double d6, double d7) {
        return (d4 * d7) + (d3 * d6) + (d2 * d5);
    }

    public static double dot(Vector3 vector3, Vector3 vector32) {
        return (vector3.z * vector32.z) + (vector3.y * vector32.y) + (vector3.x * vector32.x);
    }

    public static Vector3 getAxisVector(Axis axis) {
        int ordinal = axis.ordinal();
        if (ordinal == 0) {
            return X;
        }
        if (ordinal == 1) {
            return Y;
        }
        if (ordinal == 2) {
            return Z;
        }
        throw new IllegalArgumentException("The specified Axis is not a valid choice.");
    }

    public static double length(double d2, double d3, double d4) {
        return Math.sqrt(length2(d2, d3, d4));
    }

    public static double length2(double d2, double d3, double d4) {
        return (d4 * d4) + (d3 * d3) + (d2 * d2);
    }

    public static double length2(Vector3 vector3) {
        return length2(vector3.x, vector3.y, vector3.z);
    }

    public static Vector3 lerpAndCreate(Vector3 vector3, Vector3 vector32, double d2) {
        Vector3 vector33 = new Vector3();
        double d3 = vector3.x;
        vector33.x = a.h(vector32.x, d3, d2, d3);
        double d4 = vector3.y;
        double d5 = d2;
        vector33.y = a.h(vector32.y, d4, d5, d4);
        double d6 = vector3.z;
        vector33.z = a.h(vector32.z, d6, d5, d6);
        return vector33;
    }

    public static Vector3 multiplyAndCreate(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = new Vector3(vector3.x * vector32.x, vector3.y * vector32.y, vector3.z * vector32.z);
        return vector33;
    }

    public static void orthoNormalize(Vector3[] vector3Arr) {
        int i2 = 0;
        while (i2 < vector3Arr.length) {
            vector3Arr[i2].normalize();
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < vector3Arr.length; i4++) {
                vector3Arr[i4].subtract(projectAndCreate(vector3Arr[i4], vector3Arr[i2]));
            }
            i2 = i3;
        }
    }

    public static Vector3 projectAndCreate(Vector3 vector3, Vector3 vector32) {
        return vector32.clone().multiply(vector3.dot(vector32) / vector32.length2());
    }

    public static Vector3 scaleAndCreate(Vector3 vector3, double d2) {
        Vector3 vector32 = new Vector3(vector3.x * d2, vector3.y * d2, vector3.z * d2);
        return vector32;
    }

    public static Vector3 subtractAndCreate(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = new Vector3(vector3.x - vector32.x, vector3.y - vector32.y, vector3.z - vector32.z);
        return vector33;
    }

    public Vector3 absoluteValue() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    public Vector3 add(Vector3 vector3) {
        this.x += vector3.x;
        this.y += vector3.y;
        this.z += vector3.z;
        return this;
    }

    public Vector3 addAndSet(Vector3 vector3, Vector3 vector32) {
        this.x = vector3.x + vector32.x;
        this.y = vector3.y + vector32.y;
        this.z = vector3.z + vector32.z;
        return this;
    }

    public double angle(Vector3 vector3) {
        return Math.toDegrees(Math.acos(dot(vector3) / (vector3.length() * length())));
    }

    public Vector3 cross(Vector3 vector3) {
        if (this.mTemp == null) {
            this.mTemp = new Vector3();
        }
        this.mTemp.setAll(this);
        double d2 = vector3.y;
        Vector3 vector32 = this.mTemp;
        double d3 = vector32.z;
        double d4 = d2 * d3;
        double d5 = vector3.z;
        this.x = d4 - (vector32.y * d5);
        double d6 = vector32.x;
        double d7 = d5 * d6;
        double d8 = vector3.x;
        this.y = d7 - (d3 * d8);
        this.z = (d8 * vector32.y) - (vector3.y * d6);
        return this;
    }

    public Vector3 crossAndSet(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        double d2 = vector34.y;
        double d3 = vector33.z;
        double d4 = d2 * d3;
        double d5 = vector34.z;
        double d6 = vector33.y;
        double d7 = d4 - (d5 * d6);
        double d8 = vector33.x;
        double d9 = d5 * d8;
        double d10 = vector34.x;
        return setAll(d7, d9 - (d3 * d10), (d10 * d6) - (d2 * d8));
    }

    public double distanceTo(Vector3 vector3) {
        double d2 = this.x - vector3.x;
        double d3 = this.y - vector3.y;
        double d4 = this.z - vector3.z;
        return Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
    }

    public double distanceTo2(Vector3 vector3) {
        double d2 = this.x - vector3.x;
        double d3 = this.y - vector3.y;
        double d4 = this.z - vector3.z;
        return (d4 * d4) + (d3 * d3) + (d2 * d2);
    }

    public Vector3 divide(double d2) {
        this.x /= d2;
        this.y /= d2;
        this.z /= d2;
        return this;
    }

    public Vector3 divideAndSet(Vector3 vector3, Vector3 vector32) {
        this.x = vector3.x / vector32.x;
        this.y = vector3.y / vector32.y;
        this.z = vector3.z / vector32.z;
        return this;
    }

    public boolean equals(Vector3 vector3) {
        return vector3.x == this.x && vector3.y == this.y && vector3.z == this.z;
    }

    public Quaternion getRotationTo(Vector3 vector3) {
        Quaternion quaternion = new Quaternion();
        normalize();
        vector3.normalize();
        double dot = dot(this, vector3);
        if (dot >= 1.0d) {
            quaternion.identity();
        }
        if (dot < -0.999999d) {
            Vector3 crossAndCreate = crossAndCreate(getAxisVector(Axis.X), this);
            if (crossAndCreate.length() == 0.0d) {
                crossAndCreate = crossAndCreate(getAxisVector(Axis.Y), this);
            }
            crossAndCreate.normalize();
            quaternion.fromAngleAxis(crossAndCreate, MathUtil.radiansToDegrees(3.141592653589793d));
        } else {
            double sqrt = Math.sqrt((dot + 1.0d) * 2.0d);
            double d2 = 1.0d / sqrt;
            Vector3 crossAndCreate2 = crossAndCreate(this, vector3);
            quaternion.x = crossAndCreate2.x * d2;
            quaternion.y = crossAndCreate2.y * d2;
            quaternion.z = crossAndCreate2.z * d2;
            quaternion.w = sqrt * 0.5d;
            quaternion.normalize();
        }
        return quaternion;
    }

    public Vector3 inverse() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3 invertAndCreate() {
        Vector3 vector3 = new Vector3(-this.x, -this.y, -this.z);
        return vector3;
    }

    public boolean isUnit() {
        return isUnit(1.0E-8d);
    }

    public boolean isZero() {
        return this.x == 0.0d && this.y == 0.0d && this.z == 0.0d;
    }

    public Vector3 lerp(Vector3 vector3, double d2) {
        return multiply(1.0d - d2).add(vector3.x * d2, vector3.y * d2, vector3.z * d2);
    }

    public Vector3 lerpAndSet(Vector3 vector3, Vector3 vector32, double d2) {
        double d3 = vector3.x;
        this.x = a.h(vector32.x, d3, d2, d3);
        double d4 = vector3.y;
        double d5 = d2;
        this.y = a.h(vector32.y, d4, d5, d4);
        double d6 = vector3.z;
        this.z = a.h(vector32.z, d6, d5, d6);
        return this;
    }

    public Vector3 multiply(double d2) {
        this.x *= d2;
        this.y *= d2;
        this.z *= d2;
        return this;
    }

    public Vector3 multiplyAndSet(Vector3 vector3, Vector3 vector32) {
        this.x = vector3.x * vector32.x;
        this.y = vector3.y * vector32.y;
        this.z = vector3.z * vector32.z;
        return this;
    }

    public double normalize() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double sqrt = Math.sqrt((d6 * d6) + d5);
        if (sqrt == 0.0d || sqrt == 1.0d) {
            return sqrt;
        }
        double d7 = 1.0d / sqrt;
        this.x *= d7;
        this.y *= d7;
        this.z *= d7;
        return d7;
    }

    public Vector3 project(Vector3 vector3) {
        return multiply(dot(vector3) / length2());
    }

    public Vector3 rotateBy(Quaternion quaternion) {
        return setAll(quaternion.multiply(this));
    }

    public Vector3 rotateX(double d2) {
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        if (this.mTemp == null) {
            this.mTemp = new Vector3();
        }
        this.mTemp.setAll(this.x, this.y, this.z);
        Vector3 vector3 = this.mTemp;
        double d3 = vector3.y * cos;
        double d4 = vector3.z;
        this.y = d3 - (d4 * sin);
        this.z = (d4 * cos) + (vector3.y * sin);
        return this;
    }

    public Vector3 rotateY(double d2) {
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        if (this.mTemp == null) {
            this.mTemp = new Vector3();
        }
        this.mTemp.setAll(this.x, this.y, this.z);
        Vector3 vector3 = this.mTemp;
        double d3 = vector3.x * cos;
        double d4 = vector3.z;
        this.x = (d4 * sin) + d3;
        this.z = (d4 * cos) + (vector3.x * (-sin));
        return this;
    }

    public Vector3 rotateZ(double d2) {
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        if (this.mTemp == null) {
            this.mTemp = new Vector3();
        }
        this.mTemp.setAll(this.x, this.y, this.z);
        Vector3 vector3 = this.mTemp;
        double d3 = vector3.x * cos;
        double d4 = vector3.y;
        this.x = d3 - (d4 * sin);
        this.y = (d4 * cos) + (vector3.x * sin);
        return this;
    }

    public Vector3 scaleAndSet(Vector3 vector3, double d2) {
        this.x = vector3.x * d2;
        this.y = vector3.y * d2;
        this.z = vector3.z * d2;
        return this;
    }

    public Vector3 setAll(double d2, double d3, double d4) {
        this.x = d2;
        this.y = d3;
        this.z = d4;
        return this;
    }

    public Vector3 subtract(Vector3 vector3) {
        this.x -= vector3.x;
        this.y -= vector3.y;
        this.z -= vector3.z;
        return this;
    }

    public Vector3 subtractAndSet(Vector3 vector3, Vector3 vector32) {
        this.x = vector3.x - vector32.x;
        this.y = vector3.y - vector32.y;
        this.z = vector3.z - vector32.z;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Vector3 <x, y, z>: <");
        stringBuffer.append(this.x);
        String str = ", ";
        stringBuffer.append(str);
        stringBuffer.append(this.y);
        stringBuffer.append(str);
        stringBuffer.append(this.z);
        stringBuffer.append(">");
        return stringBuffer.toString();
    }

    public Vector3 transform(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion(quaternion);
        Quaternion quaternion3 = new Quaternion(0.0d, this.x, this.y, this.z);
        quaternion2.conjugate();
        quaternion2.multiplyLeft(quaternion3.multiplyLeft(quaternion));
        return setAll(quaternion2.x, quaternion2.y, quaternion2.z);
    }

    public static double length(Vector3 vector3) {
        return length(vector3.x, vector3.y, vector3.z);
    }

    public static Vector3 multiplyAndCreate(Vector3 vector3, double d2) {
        Vector3 vector32 = new Vector3(vector3.x * d2, vector3.y * d2, vector3.z * d2);
        return vector32;
    }

    public Vector3 clone() {
        Vector3 vector3 = new Vector3(this.x, this.y, this.z);
        return vector3;
    }

    public double dot(Vector3 vector3) {
        return (this.z * vector3.z) + (this.y * vector3.y) + (this.x * vector3.x);
    }

    public boolean equals(Vector3 vector3, double d2) {
        return Math.abs(vector3.x - this.x) <= d2 && Math.abs(vector3.y - this.y) <= d2 && Math.abs(vector3.y - this.y) <= d2;
    }

    public boolean isUnit(double d2) {
        return Math.abs(length2() - 1.0d) < d2 * d2;
    }

    public boolean isZero(double d2) {
        return length2() < d2 * d2;
    }

    public double length2() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        return (d6 * d6) + d5;
    }

    public double dot(double d2, double d3, double d4) {
        return (this.z * d4) + (this.y * d3) + (this.x * d2);
    }

    public double length() {
        return length(this);
    }

    public Vector3 add(double d2, double d3, double d4) {
        this.x += d2;
        this.y += d3;
        this.z += d4;
        return this;
    }

    public double distanceTo2(double d2, double d3, double d4) {
        double d5 = this.x - d2;
        double d6 = this.y - d3;
        double d7 = this.z - d4;
        return (d7 * d7) + (d6 * d6) + (d5 * d5);
    }

    public Vector3 divide(Vector3 vector3) {
        this.x /= vector3.x;
        this.y /= vector3.y;
        this.z /= vector3.z;
        return this;
    }

    public Vector3 multiply(Vector3 vector3) {
        this.x *= vector3.x;
        this.y *= vector3.y;
        this.z *= vector3.z;
        return this;
    }

    public Vector3 project(double[] dArr) {
        double d2 = this.x;
        double d3 = dArr[3] * d2;
        double d4 = this.y;
        double d5 = (dArr[7] * d4) + d3;
        double d6 = this.z;
        double d7 = (dArr[11] * d6) + d5 + dArr[15];
        double d8 = (((dArr[8] * d6) + ((dArr[4] * d4) + (dArr[0] * d2))) + dArr[12]) / d7;
        double d9 = (d4 * dArr[6]) + (d2 * dArr[2]);
        return setAll(d8, (((dArr[9] * d6) + ((dArr[5] * d4) + (dArr[1] * d2))) + dArr[13]) / d7, (((d6 * dArr[10]) + d9) + dArr[14]) / d7);
    }

    public Vector3 setAll(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
        return this;
    }

    public Vector3 subtract(double d2, double d3, double d4) {
        this.x -= d2;
        this.y -= d3;
        this.z -= d4;
        return this;
    }

    public static void orthoNormalize(Vector3 vector3, Vector3 vector32) {
        vector3.normalize();
        vector32.subtract(projectAndCreate(vector32, vector3));
        vector32.normalize();
    }

    public double distanceTo(double d2, double d3, double d4) {
        double d5 = this.x - d2;
        double d6 = this.y - d3;
        double d7 = this.z - d4;
        return Math.sqrt((d7 * d7) + (d6 * d6) + (d5 * d5));
    }

    public Vector3(double d2) {
        this.mTemp = null;
        this.x = d2;
        this.y = d2;
        this.z = d2;
    }

    public Vector3 cross(double d2, double d3, double d4) {
        if (this.mTemp == null) {
            this.mTemp = new Vector3();
        }
        this.mTemp.setAll(this);
        Vector3 vector3 = this.mTemp;
        double d5 = vector3.z;
        this.x = (d3 * d5) - (vector3.y * d4);
        double d6 = vector3.x;
        this.y = (d4 * d6) - (d5 * d2);
        this.z = (d2 * vector3.y) - (d3 * d6);
        return this;
    }

    public Vector3 project(Matrix4 matrix4) {
        return setAll(matrix4.projectVector(this));
    }

    public static double distanceTo2(Vector3 vector3, Vector3 vector32) {
        double d2 = vector3.x - vector32.x;
        double d3 = vector3.y - vector32.y;
        double d4 = vector3.z - vector32.z;
        return (d4 * d4) + (d3 * d3) + (d2 * d2);
    }

    public Vector3 add(double d2) {
        this.x += d2;
        this.y += d2;
        this.z += d2;
        return this;
    }

    public Vector3 multiply(double[] dArr) {
        double d2 = this.x;
        double d3 = this.y;
        double d4 = this.z;
        this.x = (dArr[8] * d4) + (dArr[4] * d3) + (dArr[0] * d2) + dArr[12];
        this.y = (dArr[9] * d4) + (dArr[5] * d3) + (dArr[1] * d2) + dArr[13];
        this.z = (d4 * dArr[10]) + (d3 * dArr[6]) + (d2 * dArr[2]) + dArr[14];
        return this;
    }

    public Vector3 setAll(Axis axis) {
        return setAll(getAxisVector(axis));
    }

    public Vector3 subtract(double d2) {
        this.x -= d2;
        this.y -= d2;
        this.z -= d2;
        return this;
    }

    public static double distanceTo(Vector3 vector3, Vector3 vector32) {
        double d2 = vector3.x - vector32.x;
        double d3 = vector3.y - vector32.y;
        double d4 = vector3.z - vector32.z;
        return Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
    }

    public Vector3(Vector3 vector3) {
        this.mTemp = null;
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
    }

    public Vector3 multiply(Matrix4 matrix4) {
        return multiply(matrix4.getDoubleValues());
    }

    public static double distanceTo(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d4 - d7;
        return Math.sqrt((d10 * d10) + (d9 * d9) + (d8 * d8));
    }

    public Vector3(String[] strArr) throws IllegalArgumentException, NumberFormatException {
        this((double) Float.parseFloat(strArr[0]), (double) Float.parseFloat(strArr[1]), (double) Float.parseFloat(strArr[2]));
    }

    public Vector3(double[] dArr) throws IllegalArgumentException {
        this.mTemp = null;
        if (dArr.length >= 3) {
            this.x = dArr[0];
            this.y = dArr[1];
            this.z = dArr[2];
            return;
        }
        throw new IllegalArgumentException("Vector3 must be initialized with an array length of at least 3.");
    }

    public Vector3(double d2, double d3, double d4) {
        this.mTemp = null;
        this.x = d2;
        this.y = d3;
        this.z = d4;
    }
}
