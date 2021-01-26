package com.arashivision.onestream.math;

import com.arashivision.onestream.ArrayUtils;
import com.arashivision.onestream.math.vector.Vector3;
import com.arashivision.onestream.math.vector.Vector3.Axis;
import e.a.a.a.a;
import java.io.Serializable;

public final class Matrix4 implements Serializable {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    public static final long serialVersionUID = -4196364173818281770L;
    public double[] m;
    public float[] mFloat;
    public Matrix4 mMatrix;
    public final Quaternion mQuat;
    public double[] mTmp;
    public final Vector3 mVec1;
    public final Vector3 mVec2;
    public final Vector3 mVec3;

    public Matrix4() {
        this.m = new double[16];
        this.mTmp = new double[16];
        this.mFloat = new float[16];
        this.mQuat = new Quaternion();
        this.mVec1 = new Vector3();
        this.mVec2 = new Vector3();
        this.mVec3 = new Vector3();
        identity();
    }

    public static Matrix4 createRotationMatrix(Quaternion quaternion) {
        return new Matrix4(quaternion);
    }

    public static Matrix4 createScaleMatrix(Vector3 vector3) {
        return new Matrix4().setToScale(vector3);
    }

    public static Matrix4 createTranslationMatrix(Vector3 vector3) {
        return new Matrix4().translate(vector3);
    }

    public Matrix4 add(Matrix4 matrix4) {
        matrix4.toArray(this.mTmp);
        double[] dArr = this.m;
        double d2 = dArr[0];
        double[] dArr2 = this.mTmp;
        dArr[0] = d2 + dArr2[0];
        dArr[1] = dArr[1] + dArr2[1];
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
        dArr[4] = dArr[4] + dArr2[4];
        dArr[5] = dArr[5] + dArr2[5];
        dArr[6] = dArr[6] + dArr2[6];
        dArr[7] = dArr[7] + dArr2[7];
        dArr[8] = dArr[8] + dArr2[8];
        dArr[9] = dArr[9] + dArr2[9];
        dArr[10] = dArr[10] + dArr2[10];
        dArr[11] = dArr[11] + dArr2[11];
        dArr[12] = dArr[12] + dArr2[12];
        dArr[13] = dArr[13] + dArr2[13];
        dArr[14] = dArr[14] + dArr2[14];
        dArr[15] = dArr[15] + dArr2[15];
        return this;
    }

    public double determinant() {
        double[] dArr = this.m;
        return (dArr[0] * dArr[5] * dArr[10] * dArr[15]) + ((((((dArr[2] * dArr[4]) * dArr[9]) * dArr[15]) + ((((dArr[1] * dArr[6]) * dArr[8]) * dArr[15]) + ((((((dArr[1] * dArr[4]) * dArr[11]) * dArr[14]) + ((((dArr[0] * dArr[7]) * dArr[9]) * dArr[14]) + ((((((dArr[3] * dArr[5]) * dArr[8]) * dArr[14]) + ((((dArr[0] * dArr[6]) * dArr[11]) * dArr[13]) + ((((((dArr[3] * dArr[4]) * dArr[10]) * dArr[13]) + ((((dArr[2] * dArr[7]) * dArr[8]) * dArr[13]) + ((((((dArr[2] * dArr[5]) * dArr[11]) * dArr[12]) + ((((dArr[1] * dArr[7]) * dArr[10]) * dArr[12]) + (((((dArr[3] * dArr[6]) * dArr[9]) * dArr[12]) - (((dArr[2] * dArr[7]) * dArr[9]) * dArr[12])) - (((dArr[3] * dArr[5]) * dArr[10]) * dArr[12])))) - (((dArr[1] * dArr[6]) * dArr[11]) * dArr[12])) - (((dArr[3] * dArr[6]) * dArr[8]) * dArr[13])))) - (((dArr[0] * dArr[7]) * dArr[10]) * dArr[13])) - (((dArr[2] * dArr[4]) * dArr[11]) * dArr[13])))) - (((dArr[1] * dArr[7]) * dArr[8]) * dArr[14])) - (((dArr[3] * dArr[4]) * dArr[9]) * dArr[14])))) - (((dArr[0] * dArr[5]) * dArr[11]) * dArr[14])) - (((dArr[2] * dArr[5]) * dArr[8]) * dArr[15])))) - (((dArr[0] * dArr[6]) * dArr[9]) * dArr[15])) - (((dArr[1] * dArr[4]) * dArr[10]) * dArr[15]));
    }

    public Matrix4 dotMultiply(Matrix4 matrix4) {
        double[] doubleValues = matrix4.getDoubleValues();
        for (int i2 = 0; i2 < 16; i2++) {
            double[] dArr = this.m;
            dArr[i2] = dArr[i2] * doubleValues[i2];
        }
        return this;
    }

    public boolean equals(Matrix4 matrix4) {
        matrix4.toArray(this.mTmp);
        double[] dArr = this.m;
        double d2 = dArr[0];
        double[] dArr2 = this.mTmp;
        return d2 == dArr2[0] && dArr[1] == dArr2[1] && dArr[2] == dArr2[2] && dArr[3] == dArr2[3] && dArr[4] == dArr2[4] && dArr[5] == dArr2[5] && dArr[6] == dArr2[6] && dArr[7] == dArr2[7] && dArr[8] == dArr2[8] && dArr[9] == dArr2[9] && dArr[10] == dArr2[10] && dArr[11] == dArr2[11] && dArr[12] == dArr2[12] && dArr[13] == dArr2[13] && dArr[14] == dArr2[14] && dArr[15] == dArr2[15];
    }

    public double[] getDoubleValues() {
        return this.m;
    }

    public float[] getFloatValues() {
        ArrayUtils.convertDoublesToFloats(this.m, this.mFloat);
        return this.mFloat;
    }

    public Vector3 getScaling() {
        double[] dArr = this.m;
        double sqrt = Math.sqrt((dArr[8] * dArr[8]) + (dArr[4] * dArr[4]) + (dArr[0] * dArr[0]));
        double[] dArr2 = this.m;
        double sqrt2 = Math.sqrt((dArr2[9] * dArr2[9]) + (dArr2[5] * dArr2[5]) + (dArr2[1] * dArr2[1]));
        double[] dArr3 = this.m;
        Vector3 vector3 = new Vector3(sqrt, sqrt2, Math.sqrt((dArr3[10] * dArr3[10]) + (dArr3[6] * dArr3[6]) + (dArr3[2] * dArr3[2])));
        return vector3;
    }

    public Vector3 getTranslation() {
        return getTranslation(new Vector3());
    }

    public Matrix4 identity() {
        double[] dArr = this.m;
        dArr[0] = 1.0d;
        dArr[1] = 0.0d;
        dArr[2] = 0.0d;
        dArr[3] = 0.0d;
        dArr[4] = 0.0d;
        dArr[5] = 1.0d;
        dArr[6] = 0.0d;
        dArr[7] = 0.0d;
        dArr[8] = 0.0d;
        dArr[9] = 0.0d;
        dArr[10] = 1.0d;
        dArr[11] = 0.0d;
        dArr[12] = 0.0d;
        dArr[13] = 0.0d;
        dArr[14] = 0.0d;
        dArr[15] = 1.0d;
        return this;
    }

    public Matrix4 inverse() {
        Matrix.invertM(this.mTmp, 0, this.m, 0);
        System.arraycopy(this.mTmp, 0, this.m, 0, 16);
        return this;
    }

    public Matrix4 leftMultiply(Matrix4 matrix4) {
        System.arraycopy(this.m, 0, this.mTmp, 0, 16);
        Matrix.multiplyMM(this.m, 0, matrix4.getDoubleValues(), 0, this.mTmp, 0);
        return this;
    }

    public Matrix4 lerp(Matrix4 matrix4, double d2) {
        matrix4.toArray(this.mTmp);
        for (int i2 = 0; i2 < 16; i2++) {
            double[] dArr = this.m;
            dArr[i2] = (this.mTmp[i2] * d2) + ((1.0d - d2) * dArr[i2]);
        }
        return this;
    }

    public Matrix4 multiply(Matrix4 matrix4) {
        System.arraycopy(this.m, 0, this.mTmp, 0, 16);
        Matrix.multiplyMM(this.m, 0, this.mTmp, 0, matrix4.getDoubleValues(), 0);
        return this;
    }

    public Matrix4 negTranslate(Vector3 vector3) {
        return translate(-vector3.x, -vector3.y, -vector3.z);
    }

    public Vector3 projectAndCreateVector(Vector3 vector3) {
        Vector3 vector32 = vector3;
        Vector3 vector33 = new Vector3();
        double[] dArr = this.m;
        double d2 = dArr[12];
        double d3 = vector32.x;
        double d4 = d2 * d3;
        double d5 = dArr[13];
        double d6 = vector32.y;
        double d7 = (d5 * d6) + d4;
        double d8 = dArr[14];
        double d9 = vector32.z;
        double d10 = 1.0d / (((d8 * d9) + d7) + dArr[15]);
        vector33.x = ((dArr[8] * d9) + (dArr[4] * d6) + (dArr[0] * d3) + dArr[12]) * d10;
        double d11 = dArr[1];
        double d12 = vector32.x;
        vector33.y = ((dArr[9] * d9) + (dArr[5] * d6) + (d11 * d12) + dArr[13]) * d10;
        vector33.z = ((dArr[10] * d9) + (dArr[6] * vector32.y) + (dArr[2] * d12) + dArr[14]) * d10;
        return vector33;
    }

    public Vector3 projectVector(Vector3 vector3) {
        Vector3 vector32 = vector3;
        double[] dArr = this.m;
        double d2 = dArr[12];
        double d3 = vector32.x;
        double d4 = d2 * d3;
        double d5 = dArr[13];
        double d6 = vector32.y;
        double d7 = (d5 * d6) + d4;
        double d8 = dArr[14];
        double d9 = vector32.z;
        double d10 = 1.0d / (((d8 * d9) + d7) + dArr[15]);
        double d11 = ((dArr[8] * d9) + (dArr[4] * d6) + (dArr[0] * d3) + dArr[12]) * d10;
        double d12 = ((dArr[9] * d9) + (dArr[5] * d6) + (dArr[1] * d3) + dArr[13]) * d10;
        double d13 = (dArr[6] * d6) + (dArr[2] * d3);
        return vector32.setAll(d11, d12, ((dArr[10] * d9) + d13 + dArr[14]) * d10);
    }

    public Matrix4 rotate(Quaternion quaternion) {
        Matrix4 matrix4 = this.mMatrix;
        if (matrix4 == null) {
            this.mMatrix = quaternion.toRotationMatrix();
        } else {
            quaternion.toRotationMatrix(matrix4);
        }
        return multiply(this.mMatrix);
    }

    public void rotateVector(Vector3 vector3) {
        Vector3 vector32 = vector3;
        double d2 = vector32.x;
        double[] dArr = this.m;
        double d3 = dArr[0] * d2;
        double d4 = vector32.y;
        double d5 = (dArr[4] * d4) + d3;
        double d6 = vector32.z;
        double d7 = (d4 * dArr[6]) + (d2 * dArr[2]);
        vector32.setAll(d5 + (dArr[8] * d6), (dArr[9] * d6) + (dArr[5] * d4) + (dArr[1] * d2), (d6 * dArr[10]) + d7);
    }

    public Matrix4 scale(Vector3 vector3) {
        return scale(vector3.x, vector3.y, vector3.z);
    }

    public Matrix4 setAll(Matrix4 matrix4) {
        matrix4.toArray(this.m);
        return this;
    }

    public Matrix4 setCoordinateZoom(double d2) {
        this.m[15] = d2;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32) {
        this.mVec3.setAll(vector3).normalize();
        this.mVec1.setAll(vector3).normalize();
        this.mVec1.cross(vector32).normalize();
        this.mVec2.setAll(this.mVec1).cross(this.mVec3).normalize();
        identity();
        double[] dArr = this.m;
        Vector3 vector33 = this.mVec1;
        dArr[0] = vector33.x;
        dArr[4] = vector33.y;
        dArr[8] = vector33.z;
        Vector3 vector34 = this.mVec2;
        dArr[1] = vector34.x;
        dArr[5] = vector34.y;
        dArr[9] = vector34.z;
        Vector3 vector35 = this.mVec3;
        dArr[2] = vector35.x;
        dArr[6] = vector35.y;
        dArr[10] = vector35.z;
        return this;
    }

    public Matrix4 setToNormalMatrix() {
        double[] dArr = this.m;
        dArr[12] = 0.0d;
        dArr[13] = 0.0d;
        dArr[14] = 0.0d;
        return inverse().transpose();
    }

    public Matrix4 setToOrthographic(double d2, double d3, double d4, double d5, double d6, double d7) {
        Matrix.orthoM(this.m, 0, d2, d3, d4, d5, d6, d7);
        return this;
    }

    public Matrix4 setToOrthographic2D(double d2, double d3, double d4, double d5) {
        return setToOrthographic(d2, d2 + d4, d3, d3 + d5, 0.0d, 1.0d);
    }

    public Matrix4 setToPerspective(double d2, double d3, double d4, double d5) {
        identity();
        Matrix.perspectiveM(this.m, 0, d4, d5, d2, d3);
        return this;
    }

    public Matrix4 setToRotation(Vector3 vector3, double d2) {
        return d2 == 0.0d ? identity() : setAll(this.mQuat.fromAngleAxis(vector3, d2));
    }

    public Matrix4 setToScale(Vector3 vector3) {
        identity();
        double[] dArr = this.m;
        dArr[0] = vector3.x;
        dArr[5] = vector3.y;
        dArr[10] = vector3.z;
        return this;
    }

    public Matrix4 setToTranslation(Vector3 vector3) {
        identity();
        double[] dArr = this.m;
        dArr[12] = vector3.x;
        dArr[13] = vector3.y;
        dArr[14] = vector3.z;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(Vector3 vector3, Vector3 vector32) {
        identity();
        double[] dArr = this.m;
        dArr[12] = vector3.x;
        dArr[13] = vector3.y;
        dArr[14] = vector3.z;
        dArr[0] = vector32.x;
        dArr[5] = vector32.y;
        dArr[10] = vector32.z;
        return this;
    }

    public Matrix4 setToWorld(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        this.mVec1.setAll(vector32).normalize();
        this.mVec2.setAll(this.mVec1).cross(vector33).normalize();
        this.mVec3.setAll(this.mVec2).cross(this.mVec1).normalize();
        return setAll(this.mVec2, this.mVec3, this.mVec1, vector3);
    }

    public Matrix4 setTranslation(Vector3 vector3) {
        double[] dArr = this.m;
        dArr[12] = vector3.x;
        dArr[13] = vector3.y;
        dArr[14] = vector3.z;
        return this;
    }

    public Matrix4 subtract(Matrix4 matrix4) {
        matrix4.toArray(this.mTmp);
        double[] dArr = this.m;
        double d2 = dArr[0];
        double[] dArr2 = this.mTmp;
        dArr[0] = d2 - dArr2[0];
        dArr[1] = dArr[1] - dArr2[1];
        dArr[2] = dArr[2] - dArr2[2];
        dArr[3] = dArr[3] - dArr2[3];
        dArr[4] = dArr[4] - dArr2[4];
        dArr[5] = dArr[5] - dArr2[5];
        dArr[6] = dArr[6] - dArr2[6];
        dArr[7] = dArr[7] - dArr2[7];
        dArr[8] = dArr[8] - dArr2[8];
        dArr[9] = dArr[9] - dArr2[9];
        dArr[10] = dArr[10] - dArr2[10];
        dArr[11] = dArr[11] - dArr2[11];
        dArr[12] = dArr[12] - dArr2[12];
        dArr[13] = dArr[13] - dArr2[13];
        dArr[14] = dArr[14] - dArr2[14];
        dArr[15] = dArr[15] - dArr2[15];
        return this;
    }

    public void toArray(double[] dArr) {
        System.arraycopy(this.m, 0, dArr, 0, 16);
    }

    public void toFloatArray(float[] fArr) {
        double[] dArr = this.m;
        fArr[0] = (float) dArr[0];
        fArr[1] = (float) dArr[1];
        fArr[2] = (float) dArr[2];
        fArr[3] = (float) dArr[3];
        fArr[4] = (float) dArr[4];
        fArr[5] = (float) dArr[5];
        fArr[6] = (float) dArr[6];
        fArr[7] = (float) dArr[7];
        fArr[8] = (float) dArr[8];
        fArr[9] = (float) dArr[9];
        fArr[10] = (float) dArr[10];
        fArr[11] = (float) dArr[11];
        fArr[12] = (float) dArr[12];
        fArr[13] = (float) dArr[13];
        fArr[14] = (float) dArr[14];
        fArr[15] = (float) dArr[15];
    }

    public String toString() {
        StringBuilder a2 = a.a("[");
        a2.append(this.m[0]);
        String str = "|";
        a2.append(str);
        a2.append(this.m[4]);
        a2.append(str);
        a2.append(this.m[8]);
        a2.append(str);
        a2.append(this.m[12]);
        String str2 = "]\n[";
        a2.append(str2);
        a2.append(this.m[1]);
        a2.append(str);
        a2.append(this.m[5]);
        a2.append(str);
        a2.append(this.m[9]);
        a2.append(str);
        a2.append(this.m[13]);
        a2.append(str2);
        a2.append(this.m[2]);
        a2.append(str);
        a2.append(this.m[6]);
        a2.append(str);
        a2.append(this.m[10]);
        a2.append(str);
        a2.append(this.m[14]);
        a2.append(str2);
        a2.append(this.m[3]);
        a2.append(str);
        a2.append(this.m[7]);
        a2.append(str);
        a2.append(this.m[11]);
        a2.append(str);
        a2.append(this.m[15]);
        a2.append("]\n");
        return a2.toString();
    }

    public Matrix4 translate(Vector3 vector3) {
        double[] dArr = this.m;
        dArr[12] = dArr[12] + vector3.x;
        dArr[13] = dArr[13] + vector3.y;
        dArr[14] = dArr[14] + vector3.z;
        return this;
    }

    public Matrix4 transpose() {
        Matrix.transposeM(this.mTmp, 0, this.m, 0);
        System.arraycopy(this.mTmp, 0, this.m, 0, 16);
        return this;
    }

    public Matrix4 zero() {
        for (int i2 = 0; i2 < 16; i2++) {
            this.m[i2] = 0.0d;
        }
        return this;
    }

    public static Matrix4 createRotationMatrix(Vector3 vector3, double d2) {
        return new Matrix4().setToRotation(vector3, d2);
    }

    public static Matrix4 createScaleMatrix(double d2, double d3, double d4) {
        return new Matrix4().setToScale(d2, d3, d4);
    }

    public static Matrix4 createTranslationMatrix(double d2, double d3, double d4) {
        return new Matrix4().translate(d2, d3, d4);
    }

    public Matrix4 clone() {
        return new Matrix4(this);
    }

    public Vector3 getTranslation(Vector3 vector3) {
        double[] dArr = this.m;
        return vector3.setAll(dArr[12], dArr[13], dArr[14]);
    }

    public Matrix4 scale(double d2, double d3, double d4) {
        Matrix.scaleM(this.m, 0, d2, d3, d4);
        return this;
    }

    public Matrix4 setAll(double[] dArr) {
        System.arraycopy(dArr, 0, this.m, 0, 16);
        return this;
    }

    public Matrix4 setToOrthographic2D(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setToOrthographic(d2, d2 + d4, d3, d3 + d5, d6, d7);
    }

    public Matrix4 setToRotation(Axis axis, double d2) {
        return d2 == 0.0d ? identity() : setAll(this.mQuat.fromAngleAxis(axis, d2));
    }

    public static Matrix4 createRotationMatrix(Axis axis, double d2) {
        return new Matrix4().setToRotation(axis, d2);
    }

    public Matrix4 multiply(double d2) {
        int i2 = 0;
        while (true) {
            double[] dArr = this.m;
            if (i2 >= dArr.length) {
                return this;
            }
            dArr[i2] = dArr[i2] * d2;
            i2++;
        }
    }

    public Matrix4 scale(double d2) {
        return scale(d2, d2, d2);
    }

    public Matrix4 setAll(float[] fArr) {
        double[] dArr = this.m;
        dArr[0] = (double) fArr[0];
        dArr[1] = (double) fArr[1];
        dArr[2] = (double) fArr[2];
        dArr[3] = (double) fArr[3];
        dArr[4] = (double) fArr[4];
        dArr[5] = (double) fArr[5];
        dArr[6] = (double) fArr[6];
        dArr[7] = (double) fArr[7];
        dArr[8] = (double) fArr[8];
        dArr[9] = (double) fArr[9];
        dArr[10] = (double) fArr[10];
        dArr[11] = (double) fArr[11];
        dArr[12] = (double) fArr[12];
        dArr[13] = (double) fArr[13];
        dArr[14] = (double) fArr[14];
        dArr[15] = (double) fArr[15];
        return this;
    }

    public Matrix4 setToRotation(double d2, double d3, double d4, double d5) {
        return d5 == 0.0d ? identity() : setAll(this.mQuat.fromAngleAxis(d2, d3, d4, d5));
    }

    public static Matrix4 createRotationMatrix(double d2, double d3, double d4, double d5) {
        return new Matrix4().setToRotation(d2, d3, d4, d5);
    }

    public Matrix4 setToRotation(Vector3 vector3, Vector3 vector32) {
        return setAll(this.mQuat.fromRotationBetween(vector3, vector32));
    }

    public Matrix4 setTranslation(double d2, double d3, double d4) {
        double[] dArr = this.m;
        dArr[12] = d2;
        dArr[13] = d3;
        dArr[14] = d4;
        return this;
    }

    public Matrix4 translate(double d2, double d3, double d4) {
        double[] dArr = this.m;
        dArr[12] = dArr[12] + d2;
        dArr[13] = dArr[13] + d3;
        dArr[14] = dArr[14] + d4;
        return this;
    }

    public static Matrix4 createRotationMatrix(double d2, double d3, double d4) {
        return new Matrix4().setToRotation(d2, d3, d4);
    }

    public Vector3 getScaling(Vector3 vector3) {
        double[] dArr = this.m;
        double sqrt = Math.sqrt((dArr[8] * dArr[8]) + (dArr[4] * dArr[4]) + (dArr[0] * dArr[0]));
        double[] dArr2 = this.m;
        double sqrt2 = Math.sqrt((dArr2[9] * dArr2[9]) + (dArr2[5] * dArr2[5]) + (dArr2[1] * dArr2[1]));
        double[] dArr3 = this.m;
        return vector3.setAll(sqrt, sqrt2, Math.sqrt((dArr3[10] * dArr3[10]) + (dArr3[6] * dArr3[6]) + (dArr3[2] * dArr3[2])));
    }

    public Matrix4 rotate(Vector3 vector3, double d2) {
        return d2 == 0.0d ? this : rotate(this.mQuat.fromAngleAxis(vector3, d2));
    }

    public Matrix4 setToRotation(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setAll(this.mQuat.fromRotationBetween(d2, d3, d4, d5, d6, d7));
    }

    public Matrix4 setToScale(double d2, double d3, double d4) {
        identity();
        double[] dArr = this.m;
        dArr[0] = d2;
        dArr[5] = d3;
        dArr[10] = d4;
        return this;
    }

    public Matrix4 setToTranslation(double d2, double d3, double d4) {
        identity();
        double[] dArr = this.m;
        dArr[12] = d2;
        dArr[13] = d3;
        dArr[14] = d4;
        return this;
    }

    public Matrix4 rotate(Axis axis, double d2) {
        return d2 == 0.0d ? this : rotate(this.mQuat.fromAngleAxis(axis, d2));
    }

    public Matrix4 setToRotation(double d2, double d3, double d4) {
        return setAll(this.mQuat.fromEuler(d2, d3, d4));
    }

    public Matrix4 rotate(double d2, double d3, double d4, double d5) {
        return d5 == 0.0d ? this : rotate(this.mQuat.fromAngleAxis(d2, d3, d4, d5));
    }

    public Matrix4 setAll(Quaternion quaternion) {
        quaternion.toRotationMatrix(this.m);
        return this;
    }

    public Matrix4 rotate(Vector3 vector3, Vector3 vector32) {
        return rotate(this.mQuat.fromRotationBetween(vector3, vector32));
    }

    public Matrix4 setAll(double d2, double d3, double d4, double d5) {
        return setAll(this.mQuat.setAll(d2, d3, d4, d5));
    }

    public Matrix4 setToTranslationAndScaling(double d2, double d3, double d4, double d5, double d6, double d7) {
        identity();
        double[] dArr = this.m;
        dArr[12] = d2;
        dArr[13] = d3;
        dArr[14] = d4;
        dArr[0] = d5;
        dArr[5] = d6;
        dArr[10] = d7;
        return this;
    }

    public Matrix4 setAll(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        double[] dArr = this.m;
        dArr[0] = vector3.x;
        dArr[4] = vector32.x;
        dArr[8] = vector33.x;
        dArr[12] = vector34.x;
        dArr[1] = vector3.y;
        dArr[5] = vector32.y;
        dArr[9] = vector33.y;
        dArr[13] = vector34.y;
        dArr[2] = vector3.z;
        dArr[6] = vector32.z;
        dArr[10] = vector33.z;
        dArr[14] = vector34.z;
        dArr[3] = 0.0d;
        dArr[7] = 0.0d;
        dArr[11] = 0.0d;
        dArr[15] = 1.0d;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Vector3 vector34 = vector3;
        Vector3 vector35 = vector32;
        Vector3 vector36 = vector33;
        Matrix.setLookAtM(this.m, 0, vector34.x, vector34.y, vector34.z, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z);
        return this;
    }

    public Matrix4(Matrix4 matrix4) {
        this.m = new double[16];
        this.mTmp = new double[16];
        this.mFloat = new float[16];
        this.mQuat = new Quaternion();
        this.mVec1 = new Vector3();
        this.mVec2 = new Vector3();
        this.mVec3 = new Vector3();
        setAll(matrix4);
    }

    public Matrix4 setAll(Vector3 vector3, Vector3 vector32, Quaternion quaternion) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        Quaternion quaternion2 = quaternion;
        double d2 = quaternion2.x;
        double d3 = d2 * d2;
        double d4 = quaternion2.y;
        double d5 = d4 * d4;
        double d6 = quaternion2.z;
        double d7 = d6 * d6;
        double d8 = d2 * d4;
        double d9 = d2 * d6;
        double d10 = d4 * d6;
        double d11 = d3;
        double d12 = quaternion2.w;
        double d13 = d2 * d12;
        double d14 = d4 * d12;
        double d15 = d12 * d6;
        double[] dArr = this.m;
        double d16 = vector34.x;
        dArr[0] = (1.0d - ((d5 + d7) * 2.0d)) * d16;
        double d17 = vector34.y;
        dArr[1] = (d8 - d15) * d17 * 2.0d;
        double d18 = d5;
        double d19 = vector34.z;
        dArr[2] = (d9 + d14) * d19 * 2.0d;
        dArr[3] = 0.0d;
        dArr[4] = (d8 + d15) * d16 * 2.0d;
        dArr[5] = (1.0d - ((d11 + d7) * 2.0d)) * d17;
        dArr[6] = (d10 - d13) * d19 * 2.0d;
        dArr[7] = 0.0d;
        dArr[8] = (d9 - d14) * d16 * 2.0d;
        dArr[9] = (d10 + d13) * d17 * 2.0d;
        dArr[10] = (1.0d - ((d11 + d18) * 2.0d)) * d19;
        dArr[11] = 0.0d;
        Vector3 vector35 = vector3;
        dArr[12] = vector35.x;
        dArr[13] = vector35.y;
        dArr[14] = vector35.z;
        dArr[15] = 1.0d;
        return this;
    }

    public Matrix4(double[] dArr) {
        this.m = new double[16];
        this.mTmp = new double[16];
        this.mFloat = new float[16];
        this.mQuat = new Quaternion();
        this.mVec1 = new Vector3();
        this.mVec2 = new Vector3();
        this.mVec3 = new Vector3();
        setAll(dArr);
    }

    public Matrix4(float[] fArr) {
        this(ArrayUtils.convertFloatsToDoubles(fArr));
    }

    public Matrix4(Quaternion quaternion) {
        this.m = new double[16];
        this.mTmp = new double[16];
        this.mFloat = new float[16];
        this.mQuat = new Quaternion();
        this.mVec1 = new Vector3();
        this.mVec2 = new Vector3();
        this.mVec3 = new Vector3();
        setAll(quaternion);
    }
}
