package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.MemUtil;
import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix3f implements Externalizable, Matrix3fc {
    public static final Vector3f LOOKAT_UP_AXIS = new Vector3f(0.0f, 1.0f, 0.0f);
    public static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;

    public Matrix3f() {
        this.m00 = 1.0f;
        this.m11 = 1.0f;
        this.m22 = 1.0f;
    }

    private void setMatrix3fc(Matrix3fc matrix3fc) {
        this.m00 = matrix3fc.m00();
        this.m01 = matrix3fc.m01();
        this.m02 = matrix3fc.m02();
        this.m10 = matrix3fc.m10();
        this.m11 = matrix3fc.m11();
        this.m12 = matrix3fc.m12();
        this.m20 = matrix3fc.m20();
        this.m21 = matrix3fc.m21();
        this.m22 = matrix3fc.m22();
    }

    private void setMatrix4fc(Matrix4fc matrix4fc) {
        this.m00 = matrix4fc.m00();
        this.m01 = matrix4fc.m01();
        this.m02 = matrix4fc.m02();
        this.m10 = matrix4fc.m10();
        this.m11 = matrix4fc.m11();
        this.m12 = matrix4fc.m12();
        this.m20 = matrix4fc.m20();
        this.m21 = matrix4fc.m21();
        this.m22 = matrix4fc.m22();
    }

    private void setVector3fc(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        this.m00 = vector3fc.x();
        this.m01 = vector3fc.y();
        this.m02 = vector3fc.z();
        this.m10 = vector3fc2.x();
        this.m11 = vector3fc2.y();
        this.m12 = vector3fc2.z();
        this.m20 = vector3fc3.x();
        this.m21 = vector3fc3.y();
        this.m22 = vector3fc3.z();
    }

    public Matrix3f _m00(float f2) {
        this.m00 = f2;
        return this;
    }

    public Matrix3f _m01(float f2) {
        this.m01 = f2;
        return this;
    }

    public Matrix3f _m02(float f2) {
        this.m02 = f2;
        return this;
    }

    public Matrix3f _m10(float f2) {
        this.m10 = f2;
        return this;
    }

    public Matrix3f _m11(float f2) {
        this.m11 = f2;
        return this;
    }

    public Matrix3f _m12(float f2) {
        this.m12 = f2;
        return this;
    }

    public Matrix3f _m20(float f2) {
        this.m20 = f2;
        return this;
    }

    public Matrix3f _m21(float f2) {
        this.m21 = f2;
        return this;
    }

    public Matrix3f _m22(float f2) {
        this.m22 = f2;
        return this;
    }

    public Matrix3f add(Matrix3fc matrix3fc) {
        return add(matrix3fc, this);
    }

    public float determinant() {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = (f4 - (f5 * f6)) * this.m22;
        float f8 = this.m02;
        float f9 = f6 * f8;
        float f10 = this.m12;
        return (((f5 * f10) - (f8 * f3)) * this.m20) + ((f9 - (f2 * f10)) * this.m21) + f7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix3f matrix3f = (Matrix3f) obj;
        return Float.floatToIntBits(this.m00) == Float.floatToIntBits(matrix3f.m00) && Float.floatToIntBits(this.m01) == Float.floatToIntBits(matrix3f.m01) && Float.floatToIntBits(this.m02) == Float.floatToIntBits(matrix3f.m02) && Float.floatToIntBits(this.m10) == Float.floatToIntBits(matrix3f.m10) && Float.floatToIntBits(this.m11) == Float.floatToIntBits(matrix3f.m11) && Float.floatToIntBits(this.m12) == Float.floatToIntBits(matrix3f.m12) && Float.floatToIntBits(this.m20) == Float.floatToIntBits(matrix3f.m20) && Float.floatToIntBits(this.m21) == Float.floatToIntBits(matrix3f.m21) && Float.floatToIntBits(this.m22) == Float.floatToIntBits(matrix3f.m22);
    }

    public Matrix3f get(Matrix3f matrix3f) {
        return matrix3f.set((Matrix3fc) this);
    }

    public Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3f.x = this.m00;
            vector3f.y = this.m01;
            vector3f.z = this.m02;
        } else if (i2 == 1) {
            vector3f.x = this.m10;
            vector3f.y = this.m11;
            vector3f.z = this.m12;
        } else if (i2 == 2) {
            vector3f.x = this.m20;
            vector3f.y = this.m21;
            vector3f.z = this.m22;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3f;
    }

    public Vector3f getEulerAnglesZYX(Vector3f vector3f) {
        vector3f.x = (float) Math.atan2((double) this.m12, (double) this.m22);
        double d2 = (double) (-this.m02);
        float f2 = this.m12;
        float f3 = f2 * f2;
        float f4 = this.m22;
        vector3f.y = (float) Math.atan2(d2, (double) ((float) Math.sqrt((double) ((f4 * f4) + f3))));
        vector3f.z = (float) Math.atan2((double) this.m01, (double) this.m00);
        return vector3f;
    }

    public Quaternionf getNormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromNormalized((Matrix3fc) this);
    }

    public AxisAngle4f getRotation(AxisAngle4f axisAngle4f) {
        return axisAngle4f.set((Matrix3fc) this);
    }

    public Vector3f getRow(int i2, Vector3f vector3f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3f.x = this.m00;
            vector3f.y = this.m10;
            vector3f.z = this.m20;
        } else if (i2 == 1) {
            vector3f.x = this.m01;
            vector3f.y = this.m11;
            vector3f.z = this.m21;
        } else if (i2 == 2) {
            vector3f.x = this.m02;
            vector3f.y = this.m12;
            vector3f.z = this.m22;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3f;
    }

    public Vector3f getScale(Vector3f vector3f) {
        float f2 = this.m00;
        float f3 = f2 * f2;
        float f4 = this.m01;
        float f5 = (f4 * f4) + f3;
        float f6 = this.m02;
        vector3f.x = (float) Math.sqrt((double) ((f6 * f6) + f5));
        float f7 = this.m10;
        float f8 = f7 * f7;
        float f9 = this.m11;
        float f10 = (f9 * f9) + f8;
        float f11 = this.m12;
        vector3f.y = (float) Math.sqrt((double) ((f11 * f11) + f10));
        float f12 = this.m20;
        float f13 = f12 * f12;
        float f14 = this.m21;
        float f15 = (f14 * f14) + f13;
        float f16 = this.m22;
        vector3f.z = (float) Math.sqrt((double) ((f16 * f16) + f15));
        return vector3f;
    }

    public FloatBuffer getTransposed(FloatBuffer floatBuffer) {
        return getTransposed(floatBuffer.position(), floatBuffer);
    }

    public Quaternionf getUnnormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromUnnormalized((Matrix3fc) this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.m22) + a.a(this.m21, a.a(this.m20, a.a(this.m12, a.a(this.m11, a.a(this.m10, a.a(this.m02, a.a(this.m01, a.a(this.m00, 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public Matrix3f identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Matrix3f invert() {
        return invert(this);
    }

    public Matrix3f lerp(Matrix3fc matrix3fc, float f2) {
        return lerp(matrix3fc, f2, this);
    }

    public Matrix3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public float m00() {
        return this.m00;
    }

    public float m01() {
        return this.m01;
    }

    public float m02() {
        return this.m02;
    }

    public float m10() {
        return this.m10;
    }

    public float m11() {
        return this.m11;
    }

    public float m12() {
        return this.m12;
    }

    public float m20() {
        return this.m20;
    }

    public float m21() {
        return this.m21;
    }

    public float m22() {
        return this.m22;
    }

    public Matrix3f mul(Matrix3fc matrix3fc) {
        return mul(matrix3fc, this);
    }

    public Matrix3f mulComponentWise(Matrix3fc matrix3fc) {
        return mulComponentWise(matrix3fc, this);
    }

    public Matrix3f mulLocal(Matrix3fc matrix3fc) {
        return mulLocal(matrix3fc, this);
    }

    public Matrix3f normal() {
        return normal(this);
    }

    public Vector3f normalizedPositiveX(Vector3f vector3f) {
        vector3f.x = this.m00;
        vector3f.y = this.m10;
        vector3f.z = this.m20;
        return vector3f;
    }

    public Vector3f normalizedPositiveY(Vector3f vector3f) {
        vector3f.x = this.m01;
        vector3f.y = this.m11;
        vector3f.z = this.m21;
        return vector3f;
    }

    public Vector3f normalizedPositiveZ(Vector3f vector3f) {
        vector3f.x = this.m02;
        vector3f.y = this.m12;
        vector3f.z = this.m22;
        return vector3f;
    }

    public Matrix3f obliqueZ(float f2, float f3) {
        this.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        this.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        this.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        return this;
    }

    public Vector3f positiveX(Vector3f vector3f) {
        float f2 = this.m11;
        float f3 = this.m22;
        float f4 = f2 * f3;
        float f5 = this.m12;
        float f6 = this.m21;
        vector3f.x = f4 - (f5 * f6);
        float f7 = this.m02;
        float f8 = f6 * f7;
        float f9 = this.m01;
        vector3f.y = f8 - (f3 * f9);
        vector3f.z = (f9 * f5) - (f7 * f2);
        return vector3f.normalize(vector3f);
    }

    public Vector3f positiveY(Vector3f vector3f) {
        float f2 = this.m12;
        float f3 = this.m20;
        float f4 = f2 * f3;
        float f5 = this.m10;
        float f6 = this.m22;
        vector3f.x = f4 - (f5 * f6);
        float f7 = this.m00;
        float f8 = f6 * f7;
        float f9 = this.m02;
        vector3f.y = f8 - (f3 * f9);
        vector3f.z = (f9 * f5) - (f7 * f2);
        return vector3f.normalize(vector3f);
    }

    public Vector3f positiveZ(Vector3f vector3f) {
        float f2 = this.m10;
        float f3 = this.m21;
        float f4 = f2 * f3;
        float f5 = this.m11;
        float f6 = this.m20;
        vector3f.x = f4 - (f5 * f6);
        float f7 = this.m01;
        float f8 = f6 * f7;
        float f9 = this.m00;
        vector3f.y = f8 - (f3 * f9);
        vector3f.z = (f9 * f5) - (f7 * f2);
        return vector3f.normalize(vector3f);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readFloat();
        this.m01 = objectInput.readFloat();
        this.m02 = objectInput.readFloat();
        this.m10 = objectInput.readFloat();
        this.m11 = objectInput.readFloat();
        this.m12 = objectInput.readFloat();
        this.m20 = objectInput.readFloat();
        this.m21 = objectInput.readFloat();
        this.m22 = objectInput.readFloat();
    }

    public Matrix3f rotate(float f2, float f3, float f4, float f5) {
        return rotate(f2, f3, f4, f5, this);
    }

    public Matrix3f rotateLocal(float f2, float f3, float f4, float f5, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = (f3 * f3 * f6) + cosFromSin;
        float f8 = f3 * f4 * f6;
        float f9 = f5 * sin;
        float f10 = f8 + f9;
        float f11 = f3 * f5 * f6;
        float f12 = f4 * sin;
        float f13 = f11 - f12;
        float f14 = f8 - f9;
        float f15 = (f4 * f4 * f6) + cosFromSin;
        float f16 = f4 * f5 * f6;
        float f17 = sin * f3;
        float f18 = f16 + f17;
        float f19 = f11 + f12;
        float f20 = f16 - f17;
        float f21 = (f5 * f5 * f6) + cosFromSin;
        float f22 = this.m00;
        float f23 = f7 * f22;
        float f24 = this.m01;
        float f25 = (f14 * f24) + f23;
        float f26 = this.m02;
        float f27 = (f19 * f26) + f25;
        float f28 = (f20 * f26) + (f15 * f24) + (f10 * f22);
        float f29 = f26 * f21;
        float f30 = f29 + (f24 * f18) + (f22 * f13);
        float f31 = this.m10;
        float f32 = f7 * f31;
        float f33 = f30;
        float f34 = this.m11;
        float f35 = (f14 * f34) + f32;
        float f36 = this.m12;
        float f37 = f28;
        float f38 = (f19 * f36) + f35;
        float f39 = (f20 * f36) + (f15 * f34) + (f10 * f31);
        float f40 = f36 * f21;
        float f41 = f40 + (f34 * f18) + (f31 * f13);
        float f42 = this.m20;
        float f43 = f7 * f42;
        float f44 = this.m21;
        float f45 = (f14 * f44) + f43;
        float f46 = this.m22;
        float f47 = (f19 * f46) + f45;
        float f48 = f20 * f46;
        float f49 = f48 + (f15 * f44) + (f10 * f42);
        float f50 = f21 * f46;
        float f51 = f50 + (f18 * f44) + (f13 * f42);
        matrix3f2.m00 = f27;
        matrix3f2.m01 = f37;
        matrix3f2.m02 = f33;
        matrix3f2.m10 = f38;
        matrix3f2.m11 = f39;
        matrix3f2.m12 = f41;
        matrix3f2.m20 = f47;
        matrix3f2.m21 = f49;
        matrix3f2.m22 = f51;
        return matrix3f2;
    }

    public Matrix3f rotateLocalX(float f2, Matrix3f matrix3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.m01;
        float f4 = cosFromSin * f3;
        float f5 = this.m02;
        float f6 = f4 - (sin * f5);
        float f7 = (f5 * cosFromSin) + (f3 * sin);
        float f8 = this.m11;
        float f9 = cosFromSin * f8;
        float f10 = this.m12;
        float f11 = f9 - (sin * f10);
        float f12 = (f10 * cosFromSin) + (f8 * sin);
        float f13 = this.m21;
        float f14 = cosFromSin * f13;
        float f15 = this.m22;
        float f16 = f14 - (sin * f15);
        float f17 = (cosFromSin * f15) + (sin * f13);
        matrix3f.m00 = this.m00;
        matrix3f.m01 = f6;
        matrix3f.m02 = f7;
        matrix3f.m10 = this.m10;
        matrix3f.m11 = f11;
        matrix3f.m12 = f12;
        matrix3f.m20 = this.m20;
        matrix3f.m21 = f16;
        matrix3f.m22 = f17;
        return matrix3f;
    }

    public Matrix3f rotateLocalY(float f2, Matrix3f matrix3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.m00;
        float f4 = cosFromSin * f3;
        float f5 = this.m02;
        float f6 = (sin * f5) + f4;
        float f7 = -sin;
        float f8 = (f5 * cosFromSin) + (f3 * f7);
        float f9 = this.m10;
        float f10 = cosFromSin * f9;
        float f11 = this.m12;
        float f12 = (sin * f11) + f10;
        float f13 = (f11 * cosFromSin) + (f9 * f7);
        float f14 = this.m20;
        float f15 = cosFromSin * f14;
        float f16 = this.m22;
        float f17 = (sin * f16) + f15;
        float f18 = (cosFromSin * f16) + (f7 * f14);
        matrix3f.m00 = f6;
        matrix3f.m01 = this.m01;
        matrix3f.m02 = f8;
        matrix3f.m10 = f12;
        matrix3f.m11 = this.m11;
        matrix3f.m12 = f13;
        matrix3f.m20 = f17;
        matrix3f.m21 = this.m21;
        matrix3f.m22 = f18;
        return matrix3f;
    }

    public Matrix3f rotateLocalZ(float f2, Matrix3f matrix3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.m00;
        float f4 = cosFromSin * f3;
        float f5 = this.m01;
        float f6 = f4 - (sin * f5);
        float f7 = (f5 * cosFromSin) + (f3 * sin);
        float f8 = this.m10;
        float f9 = cosFromSin * f8;
        float f10 = this.m11;
        float f11 = f9 - (sin * f10);
        float f12 = (f10 * cosFromSin) + (f8 * sin);
        float f13 = this.m20;
        float f14 = cosFromSin * f13;
        float f15 = this.m21;
        float f16 = f14 - (sin * f15);
        float f17 = (cosFromSin * f15) + (sin * f13);
        matrix3f.m00 = f6;
        matrix3f.m01 = f7;
        matrix3f.m02 = this.m02;
        matrix3f.m10 = f11;
        matrix3f.m11 = f12;
        matrix3f.m12 = this.m12;
        matrix3f.m20 = f16;
        matrix3f.m21 = f17;
        matrix3f.m22 = this.m22;
        return matrix3f;
    }

    public Matrix3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix3f matrix3f) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix3f);
    }

    public Matrix3f rotateX(float f2, Matrix3f matrix3f) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m10;
        float f7 = f6 * f4;
        float f8 = this.m20;
        float f9 = (f8 * f3) + f7;
        float f10 = this.m11;
        float f11 = f10 * f4;
        float f12 = this.m21;
        float f13 = (f12 * f3) + f11;
        float f14 = this.m12;
        float f15 = f14 * f4;
        float f16 = this.m22;
        float f17 = (f3 * f16) + f15;
        matrix3f.m20 = (f8 * f4) + (f6 * f5);
        matrix3f.m21 = (f12 * f4) + (f10 * f5);
        matrix3f.m22 = (f16 * f4) + (f14 * f5);
        matrix3f.m10 = f9;
        matrix3f.m11 = f13;
        matrix3f.m12 = f17;
        matrix3f.m00 = this.m00;
        matrix3f.m01 = this.m01;
        matrix3f.m02 = this.m02;
        return matrix3f;
    }

    public Matrix3f rotateXYZ(Vector3f vector3f) {
        return rotateXYZ(vector3f.x, vector3f.y, vector3f.z);
    }

    public Matrix3f rotateY(float f2, Matrix3f matrix3f) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m00;
        float f7 = f6 * f4;
        float f8 = this.m20;
        float f9 = (f8 * f5) + f7;
        float f10 = this.m01;
        float f11 = f10 * f4;
        float f12 = this.m21;
        float f13 = (f12 * f5) + f11;
        float f14 = this.m02;
        float f15 = f14 * f4;
        float f16 = this.m22;
        float f17 = (f5 * f16) + f15;
        matrix3f.m20 = (f8 * f4) + (f6 * f3);
        matrix3f.m21 = (f12 * f4) + (f10 * f3);
        matrix3f.m22 = (f16 * f4) + (f14 * f3);
        matrix3f.m00 = f9;
        matrix3f.m01 = f13;
        matrix3f.m02 = f17;
        matrix3f.m10 = this.m10;
        matrix3f.m11 = this.m11;
        matrix3f.m12 = this.m12;
        return matrix3f;
    }

    public Matrix3f rotateYXZ(Vector3f vector3f) {
        return rotateYXZ(vector3f.y, vector3f.x, vector3f.z);
    }

    public Matrix3f rotateZ(float f2, Matrix3f matrix3f) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m00;
        float f7 = f6 * f4;
        float f8 = this.m10;
        float f9 = (f8 * f3) + f7;
        float f10 = this.m01;
        float f11 = f10 * f4;
        float f12 = this.m11;
        float f13 = (f12 * f3) + f11;
        float f14 = this.m02;
        float f15 = f14 * f4;
        float f16 = this.m12;
        float f17 = (f3 * f16) + f15;
        matrix3f.m10 = (f8 * f4) + (f6 * f5);
        matrix3f.m11 = (f12 * f4) + (f10 * f5);
        matrix3f.m12 = (f16 * f4) + (f14 * f5);
        matrix3f.m00 = f9;
        matrix3f.m01 = f13;
        matrix3f.m02 = f17;
        matrix3f.m20 = this.m20;
        matrix3f.m21 = this.m21;
        matrix3f.m22 = this.m22;
        return matrix3f;
    }

    public Matrix3f rotateZYX(Vector3f vector3f) {
        return rotateZYX(vector3f.z, vector3f.y, vector3f.x);
    }

    public Matrix3f rotation(float f2, Vector3fc vector3fc) {
        return rotation(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix3f rotationTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotationTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix3f rotationX(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = cosFromSin;
        this.m12 = sin;
        this.m20 = 0.0f;
        this.m21 = -sin;
        this.m22 = cosFromSin;
        return this;
    }

    public Matrix3f rotationXYZ(float f2, float f3, float f4) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f3;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f4;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin;
        float f6 = -sin2;
        float f7 = -sin3;
        float f8 = f5 * f6;
        float f9 = f6 * cosFromSin;
        this.m20 = sin2;
        this.m21 = f5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (f8 * cosFromSin3);
        this.m02 = (sin3 * sin) + (f9 * cosFromSin3);
        this.m10 = cosFromSin2 * f7;
        this.m11 = (cosFromSin * cosFromSin3) + (f8 * f7);
        this.m12 = (sin * cosFromSin3) + (f9 * f7);
        return this;
    }

    public Matrix3f rotationY(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        this.m00 = cosFromSin;
        this.m01 = 0.0f;
        this.m02 = -sin;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = sin;
        this.m21 = 0.0f;
        this.m22 = cosFromSin;
        return this;
    }

    public Matrix3f rotationYXZ(float f2, float f3, float f4) {
        double d2 = (double) f3;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f2;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f4;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin2;
        float f6 = -sin;
        float f7 = -sin3;
        float f8 = sin2 * sin;
        float f9 = sin * cosFromSin2;
        this.m20 = sin2 * cosFromSin;
        this.m21 = f6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (f8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * f9) + (f5 * cosFromSin3);
        this.m10 = (f8 * cosFromSin3) + (cosFromSin2 * f7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (f9 * cosFromSin3) + (f5 * f7);
        return this;
    }

    public Matrix3f rotationZ(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        this.m00 = cosFromSin;
        this.m01 = sin;
        this.m02 = 0.0f;
        this.m10 = -sin;
        this.m11 = cosFromSin;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        return this;
    }

    public Matrix3f rotationZYX(float f2, float f3, float f4) {
        double d2 = (double) f4;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f3;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f2;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin3;
        float f6 = -sin2;
        float f7 = -sin;
        float f8 = cosFromSin3 * sin2;
        float f9 = sin2 * sin3;
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = f6;
        this.m10 = (f8 * sin) + (f5 * cosFromSin);
        this.m11 = (f9 * sin) + (cosFromSin3 * cosFromSin);
        this.m12 = sin * cosFromSin2;
        this.m20 = (f8 * cosFromSin) + (f5 * f7);
        this.m21 = (f9 * cosFromSin) + (cosFromSin3 * f7);
        this.m22 = cosFromSin2 * cosFromSin;
        return this;
    }

    public Matrix3f scale(Vector3fc vector3fc, Matrix3f matrix3f) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix3f);
    }

    public Matrix3f scaleLocal(float f2, float f3, float f4, Matrix3f matrix3f) {
        float f5 = this.m00 * f2;
        float f6 = this.m01 * f3;
        float f7 = this.m02 * f4;
        float f8 = this.m10 * f2;
        float f9 = this.m11 * f3;
        float f10 = this.m12 * f4;
        float f11 = f2 * this.m20;
        float f12 = f3 * this.m21;
        float f13 = f4 * this.m22;
        matrix3f.m00 = f5;
        matrix3f.m01 = f6;
        matrix3f.m02 = f7;
        matrix3f.m10 = f8;
        matrix3f.m11 = f9;
        matrix3f.m12 = f10;
        matrix3f.m20 = f11;
        matrix3f.m21 = f12;
        matrix3f.m22 = f13;
        return matrix3f;
    }

    public Matrix3f scaling(float f2) {
        MemUtil.INSTANCE.zero(this);
        this.m00 = f2;
        this.m11 = f2;
        this.m22 = f2;
        return this;
    }

    public Matrix3f set(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy((Matrix3f) matrix3fc, this);
        } else {
            setMatrix3fc(matrix3fc);
        }
        return this;
    }

    public Matrix3f setColumn(int i2, Vector3fc vector3fc) throws IndexOutOfBoundsException {
        return setColumn(i2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix3f setLookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return setLookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix3f setLookAtCompat(Vector3fc vector3fc) {
        Vector3f vector3f = new Vector3f(vector3fc);
        if (vector3f.lengthSquared() == 0.0f) {
            vector3f.z = 1.0f;
        }
        Vector3f normalize = vector3f.normalize();
        Vector3f cross = LOOKAT_UP_AXIS.cross(normalize, new Vector3f());
        if (cross.lengthSquared() == 0.0f) {
            if (Math.abs(LOOKAT_UP_AXIS.z) == 1.0f) {
                normalize.x = (float) (((double) normalize.x) + 1.0E-4d);
            } else {
                normalize.z = (float) (((double) normalize.z) + 1.0E-4d);
            }
            normalize.normalize();
            LOOKAT_UP_AXIS.cross(normalize, cross);
        }
        cross.normalize();
        set((Vector3fc) cross, (Vector3fc) normalize.cross(cross, new Vector3f()), (Vector3fc) normalize);
        return this;
    }

    public Matrix3f setRow(int i2, Vector3fc vector3fc) throws IndexOutOfBoundsException {
        return setRow(i2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix3f setSkewSymmetric(float f2, float f3, float f4) {
        this.m22 = 0.0f;
        this.m11 = 0.0f;
        this.m00 = 0.0f;
        this.m01 = -f2;
        this.m02 = f3;
        this.m10 = f2;
        this.m12 = -f4;
        this.m20 = -f3;
        this.m21 = f4;
        return this;
    }

    public Matrix3f sub(Matrix3fc matrix3fc) {
        return sub(matrix3fc, this);
    }

    public Matrix3f swap(Matrix3f matrix3f) {
        MemUtil.INSTANCE.swap(this, matrix3f);
        return this;
    }

    public String toString() {
        String matrix3f = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix3f.length(); i3++) {
            char charAt = matrix3f.charAt(i3);
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

    public Vector3f transform(Vector3f vector3f) {
        return vector3f.mul((Matrix3fc) this);
    }

    public Vector3f transformTranspose(Vector3f vector3f) {
        return vector3f.mulTranspose(this);
    }

    public Matrix3f transpose() {
        return transpose(this);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.m00);
        objectOutput.writeFloat(this.m01);
        objectOutput.writeFloat(this.m02);
        objectOutput.writeFloat(this.m10);
        objectOutput.writeFloat(this.m11);
        objectOutput.writeFloat(this.m12);
        objectOutput.writeFloat(this.m20);
        objectOutput.writeFloat(this.m21);
        objectOutput.writeFloat(this.m22);
    }

    public Matrix3f zero() {
        MemUtil.INSTANCE.zero(this);
        return this;
    }

    public Matrix3f add(Matrix3fc matrix3fc, Matrix3f matrix3f) {
        matrix3f.m00 = matrix3fc.m00() + this.m00;
        matrix3f.m01 = matrix3fc.m01() + this.m01;
        matrix3f.m02 = matrix3fc.m02() + this.m02;
        matrix3f.m10 = matrix3fc.m10() + this.m10;
        matrix3f.m11 = matrix3fc.m11() + this.m11;
        matrix3f.m12 = matrix3fc.m12() + this.m12;
        matrix3f.m20 = matrix3fc.m20() + this.m20;
        matrix3f.m21 = matrix3fc.m21() + this.m21;
        matrix3f.m22 = matrix3fc.m22() + this.m22;
        return matrix3f;
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set((Matrix3fc) this);
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix3fc) this);
    }

    public FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix3fc) this);
    }

    public Matrix3f invert(Matrix3f matrix3f) {
        float determinant = 1.0f / determinant();
        float f2 = this.m11;
        float f3 = this.m22;
        float f4 = f2 * f3;
        float f5 = this.m21;
        float f6 = this.m12;
        float i2 = a.i(f5, f6, f4, determinant);
        float f7 = this.m02;
        float f8 = f5 * f7;
        float f9 = this.m01;
        float i3 = a.i(f9, f3, f8, determinant);
        float i4 = a.i(f2, f7, f9 * f6, determinant);
        float f10 = this.m20;
        float f11 = f10 * f6;
        float f12 = this.m10;
        float i5 = a.i(f12, f3, f11, determinant);
        float f13 = this.m00;
        float i6 = a.i(f10, f7, f3 * f13, determinant);
        float i7 = a.i(f6, f13, f7 * f12, determinant);
        float i8 = a.i(f10, f2, f12 * f5, determinant);
        float i9 = a.i(f5, f13, f10 * f9, determinant);
        float i10 = a.i(f12, f9, f13 * f2, determinant);
        matrix3f.m00 = i2;
        matrix3f.m01 = i3;
        matrix3f.m02 = i4;
        matrix3f.m10 = i5;
        matrix3f.m11 = i6;
        matrix3f.m12 = i7;
        matrix3f.m20 = i8;
        matrix3f.m21 = i9;
        matrix3f.m22 = i10;
        return matrix3f;
    }

    public Matrix3f lerp(Matrix3fc matrix3fc, float f2, Matrix3f matrix3f) {
        matrix3f.m00 = a.e(matrix3fc.m00(), this.m00, f2, this.m00);
        matrix3f.m01 = a.e(matrix3fc.m01(), this.m01, f2, this.m01);
        matrix3f.m02 = a.e(matrix3fc.m02(), this.m02, f2, this.m02);
        matrix3f.m10 = a.e(matrix3fc.m10(), this.m10, f2, this.m10);
        matrix3f.m11 = a.e(matrix3fc.m11(), this.m11, f2, this.m11);
        matrix3f.m12 = a.e(matrix3fc.m12(), this.m12, f2, this.m12);
        matrix3f.m20 = a.e(matrix3fc.m20(), this.m20, f2, this.m20);
        matrix3f.m21 = a.e(matrix3fc.m21(), this.m21, f2, this.m21);
        matrix3f.m22 = a.e(matrix3fc.m22(), this.m22, f2, this.m22);
        return matrix3f;
    }

    public Matrix3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix3f matrix3f) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix3f);
    }

    public Matrix3f m00(float f2) {
        this.m00 = f2;
        return this;
    }

    public Matrix3f m01(float f2) {
        this.m01 = f2;
        return this;
    }

    public Matrix3f m02(float f2) {
        this.m02 = f2;
        return this;
    }

    public Matrix3f m10(float f2) {
        this.m10 = f2;
        return this;
    }

    public Matrix3f m11(float f2) {
        this.m11 = f2;
        return this;
    }

    public Matrix3f m12(float f2) {
        this.m12 = f2;
        return this;
    }

    public Matrix3f m20(float f2) {
        this.m20 = f2;
        return this;
    }

    public Matrix3f m21(float f2) {
        this.m21 = f2;
        return this;
    }

    public Matrix3f m22(float f2) {
        this.m22 = f2;
        return this;
    }

    public Matrix3f mul(Matrix3fc matrix3fc, Matrix3f matrix3f) {
        float m022 = (matrix3fc.m02() * this.m20) + (matrix3fc.m01() * this.m10) + (matrix3fc.m00() * this.m00);
        float m023 = (matrix3fc.m02() * this.m21) + (matrix3fc.m01() * this.m11) + (matrix3fc.m00() * this.m01);
        float m024 = (matrix3fc.m02() * this.m22) + (matrix3fc.m01() * this.m12) + (matrix3fc.m00() * this.m02);
        float m122 = (matrix3fc.m12() * this.m20) + (matrix3fc.m11() * this.m10) + (matrix3fc.m10() * this.m00);
        float m123 = (matrix3fc.m12() * this.m21) + (matrix3fc.m11() * this.m11) + (matrix3fc.m10() * this.m01);
        float m124 = (matrix3fc.m12() * this.m22) + (matrix3fc.m11() * this.m12) + (matrix3fc.m10() * this.m02);
        float m222 = (matrix3fc.m22() * this.m20) + (matrix3fc.m21() * this.m10) + (matrix3fc.m20() * this.m00);
        float m223 = (matrix3fc.m22() * this.m21) + (matrix3fc.m21() * this.m11) + (matrix3fc.m20() * this.m01);
        float m224 = (matrix3fc.m22() * this.m22) + (matrix3fc.m21() * this.m12) + (matrix3fc.m20() * this.m02);
        matrix3f.m00 = m022;
        matrix3f.m01 = m023;
        matrix3f.m02 = m024;
        matrix3f.m10 = m122;
        matrix3f.m11 = m123;
        matrix3f.m12 = m124;
        matrix3f.m20 = m222;
        matrix3f.m21 = m223;
        matrix3f.m22 = m224;
        return matrix3f;
    }

    public Matrix3f mulComponentWise(Matrix3fc matrix3fc, Matrix3f matrix3f) {
        matrix3f.m00 = matrix3fc.m00() * this.m00;
        matrix3f.m01 = matrix3fc.m01() * this.m01;
        matrix3f.m02 = matrix3fc.m02() * this.m02;
        matrix3f.m10 = matrix3fc.m10() * this.m10;
        matrix3f.m11 = matrix3fc.m11() * this.m11;
        matrix3f.m12 = matrix3fc.m12() * this.m12;
        matrix3f.m20 = matrix3fc.m20() * this.m20;
        matrix3f.m21 = matrix3fc.m21() * this.m21;
        matrix3f.m22 = matrix3fc.m22() * this.m22;
        return matrix3f;
    }

    public Matrix3f mulLocal(Matrix3fc matrix3fc, Matrix3f matrix3f) {
        float m202 = (matrix3fc.m20() * this.m02) + (matrix3fc.m10() * this.m01) + (matrix3fc.m00() * this.m00);
        float m203 = (matrix3fc.m20() * this.m02) + (matrix3fc.m11() * this.m01) + (matrix3fc.m01() * this.m00);
        float m204 = (matrix3fc.m20() * this.m12) + (matrix3fc.m10() * this.m11) + (matrix3fc.m00() * this.m10);
        float m205 = (matrix3fc.m20() * this.m12) + (matrix3fc.m11() * this.m11) + (matrix3fc.m01() * this.m10);
        float m206 = (matrix3fc.m20() * this.m22) + (matrix3fc.m10() * this.m21) + (matrix3fc.m00() * this.m20);
        float m212 = (matrix3fc.m21() * this.m22) + (matrix3fc.m11() * this.m21) + (matrix3fc.m01() * this.m20);
        matrix3f.m00 = m202;
        matrix3f.m01 = m203;
        matrix3f.m10 = m204;
        matrix3f.m11 = m205;
        matrix3f.m20 = m206;
        matrix3f.m21 = m212;
        return matrix3f;
    }

    public Matrix3f normal(Matrix3f matrix3f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f5 * f6;
        float f8 = this.m02;
        float f9 = f8 * f6;
        float f10 = this.m12;
        float f11 = f2 * f10;
        float f12 = f5 * f10;
        float f13 = f8 * f3;
        float f14 = f4 - f7;
        float f15 = this.m22;
        float f16 = f14 * f15;
        float f17 = f9 - f11;
        float f18 = this.m21;
        float f19 = (f17 * f18) + f16;
        float f20 = f12 - f13;
        float f21 = this.m20;
        float h2 = a.h(f20, f21, f19, 1.0f);
        float i2 = a.i(f18, f10, f3 * f15, h2);
        float i3 = a.i(f6, f15, f10 * f21, h2);
        float i4 = a.i(f3, f21, f6 * f18, h2);
        float i5 = a.i(f5, f15, f18 * f8, h2);
        float i6 = a.i(f8, f21, f15 * f2, h2);
        float i7 = a.i(f2, f18, f21 * f5, h2);
        float f22 = f20 * h2;
        float f23 = f17 * h2;
        float f24 = f14 * h2;
        matrix3f.m00 = i2;
        matrix3f.m01 = i3;
        matrix3f.m02 = i4;
        matrix3f.m10 = i5;
        matrix3f.m11 = i6;
        matrix3f.m12 = i7;
        matrix3f.m20 = f22;
        matrix3f.m21 = f23;
        matrix3f.m22 = f24;
        return matrix3f;
    }

    public Matrix3f rotate(float f2, float f3, float f4, float f5, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = (f3 * f3 * f6) + cosFromSin;
        float f8 = f3 * f4 * f6;
        float f9 = f5 * sin;
        float f10 = f8 + f9;
        float f11 = f3 * f5 * f6;
        float f12 = f4 * sin;
        float f13 = f11 - f12;
        float f14 = f8 - f9;
        float f15 = (f4 * f4 * f6) + cosFromSin;
        float f16 = f4 * f5 * f6;
        float f17 = sin * f3;
        float f18 = f16 + f17;
        float f19 = f11 + f12;
        float f20 = f16 - f17;
        float f21 = (f5 * f5 * f6) + cosFromSin;
        float f22 = this.m00;
        float f23 = f22 * f7;
        float f24 = this.m10;
        float f25 = (f24 * f10) + f23;
        float f26 = this.m20;
        float f27 = (f26 * f13) + f25;
        float f28 = this.m01;
        float f29 = f28 * f7;
        float f30 = f27;
        float f31 = this.m11;
        float f32 = (f31 * f10) + f29;
        float f33 = this.m21;
        float f34 = f21;
        float f35 = (f33 * f13) + f32;
        float f36 = this.m02;
        float f37 = f7 * f36;
        float f38 = f20;
        float f39 = this.m12;
        float f40 = (f10 * f39) + f37;
        float f41 = this.m22;
        float f42 = (f13 * f41) + f40;
        float f43 = (f26 * f18) + (f24 * f15) + (f22 * f14);
        float f44 = (f33 * f18) + (f31 * f15) + (f28 * f14);
        float f45 = f18 * f41;
        float f46 = f45 + (f15 * f39) + (f14 * f36);
        float f47 = f26 * f34;
        Matrix3f matrix3f3 = matrix3f;
        matrix3f3.m20 = f47 + (f24 * f38) + (f22 * f19);
        float f48 = f33 * f34;
        matrix3f3.m21 = f48 + (f31 * f38) + (f28 * f19);
        float f49 = f41 * f34;
        matrix3f3.m22 = f49 + (f39 * f38) + (f36 * f19);
        matrix3f3.m00 = f30;
        matrix3f3.m01 = f35;
        matrix3f3.m02 = f42;
        matrix3f3.m10 = f43;
        matrix3f3.m11 = f44;
        matrix3f3.m12 = f46;
        return matrix3f3;
    }

    public Matrix3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public Matrix3f rotateXYZ(float f2, float f3, float f4) {
        return rotateXYZ(f2, f3, f4, this);
    }

    public Matrix3f rotateYXZ(float f2, float f3, float f4) {
        return rotateYXZ(f2, f3, f4, this);
    }

    public Matrix3f rotateZYX(float f2, float f3, float f4) {
        return rotateZYX(f2, f3, f4, this);
    }

    public Matrix3f rotation(AxisAngle4f axisAngle4f) {
        return rotation(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Matrix3f rotationTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = f4 * sqrt;
        float f11 = (f6 * f10) - (f7 * f9);
        float f12 = (f7 * f8) - (f5 * f10);
        float f13 = (f5 * f9) - (f6 * f8);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt2;
        float f15 = f12 * sqrt2;
        float f16 = f13 * sqrt2;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        this.m00 = f14;
        this.m01 = f15;
        this.m02 = f16;
        this.m10 = f17;
        this.m11 = f18;
        this.m12 = f19;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        return this;
    }

    public Matrix3f scale(Vector3fc vector3fc) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), this);
    }

    public Matrix3f setColumn(int i2, float f2, float f3, float f4) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = f2;
            this.m01 = f3;
            this.m02 = f4;
        } else if (i2 == 1) {
            this.m10 = f2;
            this.m11 = f3;
            this.m12 = f4;
        } else if (i2 == 2) {
            this.m20 = f2;
            this.m21 = f3;
            this.m22 = f4;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public Matrix3f setLookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = -(1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2))))));
        float f9 = f2 * f8;
        float f10 = f3 * f8;
        float f11 = f4 * f8;
        float f12 = (f6 * f11) - (f7 * f10);
        float f13 = (f7 * f9) - (f5 * f11);
        float f14 = (f5 * f10) - (f6 * f9);
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f14 * f14) + ((f13 * f13) + (f12 * f12)))));
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = f14 * sqrt;
        float f18 = (f10 * f17) - (f11 * f16);
        float f19 = (f11 * f15) - (f9 * f17);
        float f20 = (f9 * f16) - (f10 * f15);
        this.m00 = f15;
        this.m01 = f18;
        this.m02 = f9;
        this.m10 = f16;
        this.m11 = f19;
        this.m12 = f10;
        this.m20 = f17;
        this.m21 = f20;
        this.m22 = f11;
        return this;
    }

    public Matrix3f setRow(int i2, float f2, float f3, float f4) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = f2;
            this.m01 = f3;
            this.m02 = f4;
        } else if (i2 == 1) {
            this.m10 = f2;
            this.m11 = f3;
            this.m12 = f4;
        } else if (i2 == 2) {
            this.m20 = f2;
            this.m21 = f3;
            this.m22 = f4;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public Matrix3f sub(Matrix3fc matrix3fc, Matrix3f matrix3f) {
        matrix3f.m00 = this.m00 - matrix3fc.m00();
        matrix3f.m01 = this.m01 - matrix3fc.m01();
        matrix3f.m02 = this.m02 - matrix3fc.m02();
        matrix3f.m10 = this.m10 - matrix3fc.m10();
        matrix3f.m11 = this.m11 - matrix3fc.m11();
        matrix3f.m12 = this.m12 - matrix3fc.m12();
        matrix3f.m20 = this.m20 - matrix3fc.m20();
        matrix3f.m21 = this.m21 - matrix3fc.m21();
        matrix3f.m22 = this.m22 - matrix3fc.m22();
        return matrix3f;
    }

    public Vector3f transform(Vector3fc vector3fc, Vector3f vector3f) {
        vector3fc.mul((Matrix3fc) this, vector3f);
        return vector3f;
    }

    public Vector3f transformTranspose(Vector3fc vector3fc, Vector3f vector3f) {
        vector3fc.mulTranspose(this, vector3f);
        return vector3f;
    }

    public Matrix3f transpose(Matrix3f matrix3f) {
        matrix3f.set(this.m00, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22);
        return matrix3f;
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public ByteBuffer getTransposed(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Matrix3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        float f8 = -(1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2))))));
        float f9 = f2 * f8;
        float f10 = f3 * f8;
        float f11 = f8 * f4;
        float f12 = (f6 * f11) - (f7 * f10);
        float f13 = (f7 * f9) - (f5 * f11);
        float f14 = (f5 * f10) - (f6 * f9);
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f14 * f14) + ((f13 * f13) + (f12 * f12)))));
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = f14 * sqrt;
        float f18 = (f10 * f17) - (f11 * f16);
        float f19 = (f11 * f15) - (f9 * f17);
        float f20 = (f9 * f16) - (f10 * f15);
        float f21 = this.m00;
        float f22 = f21 * f15;
        float f23 = this.m10;
        float f24 = (f23 * f18) + f22;
        float f25 = this.m20;
        float f26 = (f25 * f9) + f24;
        float f27 = this.m01;
        float f28 = f27 * f15;
        float f29 = f26;
        float f30 = this.m11;
        float f31 = (f30 * f18) + f28;
        float f32 = this.m21;
        float f33 = f11;
        float f34 = (f32 * f9) + f31;
        float f35 = this.m02;
        float f36 = f15 * f35;
        float f37 = f20;
        float f38 = this.m12;
        float f39 = (f18 * f38) + f36;
        float f40 = this.m22;
        float f41 = (f9 * f40) + f39;
        float f42 = (f25 * f10) + (f23 * f19) + (f21 * f16);
        float f43 = (f32 * f10) + (f30 * f19) + (f27 * f16);
        float f44 = f10 * f40;
        float f45 = f44 + (f19 * f38) + (f16 * f35);
        float f46 = f25 * f33;
        float f47 = f32;
        Matrix3f matrix3f3 = matrix3f;
        matrix3f3.m20 = f46 + (f23 * f37) + (f21 * f17);
        float f48 = f47 * f33;
        matrix3f3.m21 = f48 + (f30 * f37) + (f27 * f17);
        float f49 = f40 * f33;
        matrix3f3.m22 = f49 + (f38 * f37) + (f35 * f17);
        matrix3f3.m00 = f29;
        matrix3f3.m01 = f34;
        matrix3f3.m02 = f41;
        matrix3f3.m10 = f42;
        matrix3f3.m11 = f43;
        matrix3f3.m12 = f45;
        return matrix3f3;
    }

    public Matrix3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
        return rotateTowards(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix3f rotateXYZ(float f2, float f3, float f4, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f3;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f4;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin;
        float f6 = -sin2;
        float f7 = -sin3;
        float f8 = this.m10;
        float f9 = f8 * cosFromSin;
        float f10 = this.m20;
        float f11 = (f10 * sin) + f9;
        float f12 = this.m11;
        float f13 = f12 * cosFromSin;
        float f14 = f7;
        float f15 = this.m21;
        float f16 = (f15 * sin) + f13;
        float f17 = this.m12;
        float f18 = f17 * cosFromSin;
        float f19 = sin3;
        float f20 = this.m22;
        float f21 = (sin * f20) + f18;
        float f22 = (f10 * cosFromSin) + (f8 * f5);
        float f23 = (f15 * cosFromSin) + (f12 * f5);
        float f24 = (f20 * cosFromSin) + (f17 * f5);
        float f25 = this.m00;
        float f26 = (f22 * f6) + (f25 * cosFromSin2);
        float f27 = this.m01;
        float f28 = (f23 * f6) + (f27 * cosFromSin2);
        float f29 = this.m02;
        float f30 = (f6 * f24) + (f29 * cosFromSin2);
        matrix3f2.m20 = (f22 * cosFromSin2) + (f25 * sin2);
        matrix3f2.m21 = (f23 * cosFromSin2) + (f27 * sin2);
        matrix3f2.m22 = (f24 * cosFromSin2) + (f29 * sin2);
        matrix3f2.m00 = (f11 * f19) + (f26 * cosFromSin3);
        matrix3f2.m01 = (f16 * f19) + (f28 * cosFromSin3);
        matrix3f2.m02 = (f21 * f19) + (f30 * cosFromSin3);
        matrix3f2.m10 = (f11 * cosFromSin3) + (f26 * f14);
        matrix3f2.m11 = (f16 * cosFromSin3) + (f28 * f14);
        matrix3f2.m12 = (f21 * cosFromSin3) + (f30 * f14);
        return matrix3f2;
    }

    public Matrix3f rotateYXZ(float f2, float f3, float f4, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        double d2 = (double) f3;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f2;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f4;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin2;
        float f6 = -sin;
        float f7 = -sin3;
        float f8 = this.m00;
        float f9 = f8 * sin2;
        float f10 = this.m20;
        float f11 = (f10 * cosFromSin2) + f9;
        float f12 = this.m01;
        float f13 = f12 * sin2;
        float f14 = f7;
        float f15 = this.m21;
        float f16 = (f15 * cosFromSin2) + f13;
        float f17 = this.m02;
        float f18 = sin2 * f17;
        float f19 = sin3;
        float f20 = this.m22;
        float f21 = (f20 * cosFromSin2) + f18;
        float f22 = (f10 * f5) + (f8 * cosFromSin2);
        float f23 = (f15 * f5) + (f12 * cosFromSin2);
        float f24 = (f20 * f5) + (f17 * cosFromSin2);
        float f25 = this.m10;
        float f26 = (f11 * sin) + (f25 * cosFromSin);
        float f27 = this.m11;
        float f28 = (f16 * sin) + (f27 * cosFromSin);
        float f29 = this.m12;
        float f30 = (sin * f21) + (f29 * cosFromSin);
        matrix3f2.m20 = (f11 * cosFromSin) + (f25 * f6);
        matrix3f2.m21 = (f16 * cosFromSin) + (f27 * f6);
        matrix3f2.m22 = (f21 * cosFromSin) + (f29 * f6);
        matrix3f2.m00 = (f26 * f19) + (f22 * cosFromSin3);
        matrix3f2.m01 = (f28 * f19) + (f23 * cosFromSin3);
        matrix3f2.m02 = (f30 * f19) + (f24 * cosFromSin3);
        matrix3f2.m10 = (f26 * cosFromSin3) + (f22 * f14);
        matrix3f2.m11 = (f28 * cosFromSin3) + (f23 * f14);
        matrix3f2.m12 = (f30 * cosFromSin3) + (f24 * f14);
        return matrix3f2;
    }

    public Matrix3f rotateZYX(float f2, float f3, float f4, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        double d2 = (double) f4;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f3;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f2;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = -sin3;
        float f6 = -sin2;
        float f7 = -sin;
        float f8 = this.m00;
        float f9 = f8 * cosFromSin3;
        float f10 = this.m10;
        float f11 = (f10 * sin3) + f9;
        float f12 = this.m01;
        float f13 = f12 * cosFromSin3;
        float f14 = f7;
        float f15 = this.m11;
        float f16 = (f15 * sin3) + f13;
        float f17 = this.m02;
        float f18 = f17 * cosFromSin3;
        float f19 = sin;
        float f20 = this.m12;
        float f21 = (sin3 * f20) + f18;
        float f22 = (f10 * cosFromSin3) + (f8 * f5);
        float f23 = (f15 * cosFromSin3) + (f12 * f5);
        float f24 = (f20 * cosFromSin3) + (f17 * f5);
        float f25 = f11 * sin2;
        float f26 = this.m20;
        float f27 = (f26 * cosFromSin2) + f25;
        float f28 = f16 * sin2;
        float f29 = this.m21;
        float f30 = (f29 * cosFromSin2) + f28;
        float f31 = sin2 * f21;
        float f32 = this.m22;
        float f33 = (f32 * cosFromSin2) + f31;
        matrix3f2.m00 = (f26 * f6) + (f11 * cosFromSin2);
        matrix3f2.m01 = (f29 * f6) + (f16 * cosFromSin2);
        matrix3f2.m02 = (f32 * f6) + (f21 * cosFromSin2);
        matrix3f2.m10 = (f27 * f19) + (f22 * cosFromSin);
        matrix3f2.m11 = (f30 * f19) + (f23 * cosFromSin);
        matrix3f2.m12 = (f33 * f19) + (f24 * cosFromSin);
        matrix3f2.m20 = (f27 * cosFromSin) + (f22 * f14);
        matrix3f2.m21 = (f30 * cosFromSin) + (f23 * f14);
        matrix3f2.m22 = (f33 * cosFromSin) + (f24 * f14);
        return matrix3f2;
    }

    public Matrix3f rotation(float f2, float f3, float f4, float f5) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = f3 * f4;
        float f8 = f3 * f5;
        float f9 = f4 * f5;
        this.m00 = (f3 * f3 * f6) + cosFromSin;
        float f10 = f7 * f6;
        float f11 = f5 * sin;
        this.m10 = f10 - f11;
        float f12 = f8 * f6;
        float f13 = f4 * sin;
        this.m20 = f12 + f13;
        this.m01 = f10 + f11;
        this.m11 = (f4 * f4 * f6) + cosFromSin;
        float f14 = f9 * f6;
        float f15 = f3 * sin;
        this.m21 = f14 - f15;
        this.m02 = f12 - f13;
        this.m12 = f14 + f15;
        this.m22 = (f5 * f5 * f6) + cosFromSin;
        return this;
    }

    public Matrix3f scale(float f2, float f3, float f4, Matrix3f matrix3f) {
        matrix3f.m00 = this.m00 * f2;
        matrix3f.m01 = this.m01 * f2;
        matrix3f.m02 = this.m02 * f2;
        matrix3f.m10 = this.m10 * f3;
        matrix3f.m11 = this.m11 * f3;
        matrix3f.m12 = this.m12 * f3;
        matrix3f.m20 = this.m20 * f4;
        matrix3f.m21 = this.m21 * f4;
        matrix3f.m22 = this.m22 * f4;
        return matrix3f;
    }

    public Vector3f transform(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.set((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2), (this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2), (this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2));
        return vector3f;
    }

    public Vector3f transformTranspose(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.set((this.m02 * f4) + (this.m01 * f3) + (this.m00 * f2), (this.m12 * f4) + (this.m11 * f3) + (this.m10 * f2), (this.m22 * f4) + (this.m21 * f3) + (this.m20 * f2));
        return vector3f;
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix3f obliqueZ(float f2, float f3, Matrix3f matrix3f) {
        matrix3f.m00 = this.m00;
        matrix3f.m01 = this.m01;
        matrix3f.m02 = this.m02;
        matrix3f.m10 = this.m10;
        matrix3f.m11 = this.m11;
        matrix3f.m12 = this.m12;
        matrix3f.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        matrix3f.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        matrix3f.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        return matrix3f;
    }

    public Matrix3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = sqrt * f4;
        float f11 = (f6 * f10) - (f7 * f9);
        float f12 = (f7 * f8) - (f5 * f10);
        float f13 = (f5 * f9) - (f6 * f8);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt2;
        float f15 = f12 * sqrt2;
        float f16 = f13 * sqrt2;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float f20 = this.m00;
        float f21 = f20 * f14;
        float f22 = this.m10;
        float f23 = (f22 * f15) + f21;
        float f24 = this.m20;
        float f25 = (f24 * f16) + f23;
        float f26 = this.m01;
        float f27 = f26 * f14;
        float f28 = f25;
        float f29 = this.m11;
        float f30 = (f29 * f15) + f27;
        float f31 = this.m21;
        float f32 = f10;
        float f33 = (f31 * f16) + f30;
        float f34 = this.m02;
        float f35 = f14 * f34;
        float f36 = f9;
        float f37 = this.m12;
        float f38 = (f15 * f37) + f35;
        float f39 = this.m22;
        float f40 = (f16 * f39) + f38;
        float f41 = (f24 * f19) + (f22 * f18) + (f20 * f17);
        float f42 = (f31 * f19) + (f29 * f18) + (f26 * f17);
        float f43 = f19 * f39;
        float f44 = f43 + (f18 * f37) + (f17 * f34);
        float f45 = f24 * f32;
        float f46 = f31;
        Matrix3f matrix3f3 = matrix3f;
        matrix3f3.m20 = f45 + (f22 * f36) + (f20 * f8);
        float f47 = f46 * f32;
        matrix3f3.m21 = f47 + (f29 * f36) + (f26 * f8);
        float f48 = f39 * f32;
        matrix3f3.m22 = f48 + (f37 * f36) + (f34 * f8);
        matrix3f3.m00 = f28;
        matrix3f3.m01 = f33;
        matrix3f3.m02 = f40;
        matrix3f3.m10 = f41;
        matrix3f3.m11 = f42;
        matrix3f3.m12 = f44;
        return matrix3f3;
    }

    public Matrix3f set(Matrix4x3fc matrix4x3fc) {
        this.m00 = matrix4x3fc.m00();
        this.m01 = matrix4x3fc.m01();
        this.m02 = matrix4x3fc.m02();
        this.m10 = matrix4x3fc.m10();
        this.m11 = matrix4x3fc.m11();
        this.m12 = matrix4x3fc.m12();
        this.m20 = matrix4x3fc.m20();
        this.m21 = matrix4x3fc.m21();
        this.m22 = matrix4x3fc.m22();
        return this;
    }

    public Matrix3f(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy((Matrix3f) matrix3fc, this);
        } else {
            setMatrix3fc(matrix3fc);
        }
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Matrix3f scaling(float f2, float f3, float f4) {
        MemUtil.INSTANCE.zero(this);
        this.m00 = f2;
        this.m11 = f3;
        this.m22 = f4;
        return this;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public float[] get(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(this, fArr, i2);
        return fArr;
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix3f(Matrix4fc matrix4fc) {
        if (matrix4fc instanceof Matrix4f) {
            MemUtil.INSTANCE.copy((Matrix4f) matrix4fc, this);
        } else {
            setMatrix4fc(matrix4fc);
        }
    }

    public float get(int i2, int i3) {
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

    public Matrix3f scaling(Vector3fc vector3fc) {
        return scaling(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder sb = new StringBuilder();
        String str = " ";
        a.b(numberFormat, (double) this.m00, sb, str);
        a.b(numberFormat, (double) this.m10, sb, str);
        String str2 = "\n";
        a.b(numberFormat, (double) this.m20, sb, str2);
        a.b(numberFormat, (double) this.m01, sb, str);
        a.b(numberFormat, (double) this.m11, sb, str);
        a.b(numberFormat, (double) this.m21, sb, str2);
        a.b(numberFormat, (double) this.m02, sb, str);
        a.b(numberFormat, (double) this.m12, sb, str);
        return a.a(numberFormat, (double) this.m22, sb, str2);
    }

    public boolean equals(Matrix3fc matrix3fc, float f2) {
        if (this == matrix3fc) {
            return true;
        }
        return matrix3fc != null && (matrix3fc instanceof Matrix3f) && Runtime.equals(this.m00, matrix3fc.m00(), f2) && Runtime.equals(this.m01, matrix3fc.m01(), f2) && Runtime.equals(this.m02, matrix3fc.m02(), f2) && Runtime.equals(this.m10, matrix3fc.m10(), f2) && Runtime.equals(this.m11, matrix3fc.m11(), f2) && Runtime.equals(this.m12, matrix3fc.m12(), f2) && Runtime.equals(this.m20, matrix3fc.m20(), f2) && Runtime.equals(this.m21, matrix3fc.m21(), f2) && Runtime.equals(this.m22, matrix3fc.m22(), f2);
    }

    public Matrix3f scale(float f2, float f3, float f4) {
        return scale(f2, f3, f4, this);
    }

    public Matrix3f(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
    }

    public Matrix3f scale(float f2, Matrix3f matrix3f) {
        return scale(f2, f2, f2, matrix3f);
    }

    public Matrix3f set(Matrix4fc matrix4fc) {
        if (matrix4fc instanceof Matrix4f) {
            MemUtil.INSTANCE.copy((Matrix4f) matrix4fc, this);
        } else {
            setMatrix4fc(matrix4fc);
        }
        return this;
    }

    public Matrix3f rotation(Quaternionfc quaternionfc) {
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f2 = y2 + y2;
        float b2 = a.b(quaternionfc, quaternionfc.x());
        float a3 = a.a(quaternionfc, quaternionfc.y());
        float b3 = a.b(quaternionfc, quaternionfc.y());
        float a4 = a.a(quaternionfc, quaternionfc.x());
        this.m00 = a.b(w, x, z, y);
        this.m01 = f2 + a2;
        this.m02 = b2 - a3;
        this.m10 = (-a2) + f2;
        this.m11 = a.c(y, z, w, x);
        this.m12 = b3 + a4;
        this.m20 = a3 + b2;
        this.m21 = b3 - a4;
        this.m22 = a.d(z, y, x, w);
        return this;
    }

    public Matrix3f scale(float f2) {
        return scale(f2, f2, f2);
    }

    public Matrix3f rotateLocal(float f2, float f3, float f4, float f5) {
        return rotateLocal(f2, f3, f4, f5, this);
    }

    public Matrix3f rotateLocalX(float f2) {
        return rotateLocalX(f2, this);
    }

    public Matrix3f rotateLocalY(float f2) {
        return rotateLocalY(f2, this);
    }

    public Matrix3f rotateLocalZ(float f2) {
        return rotateLocalZ(f2, this);
    }

    public Matrix3f rotateX(float f2) {
        return rotateX(f2, this);
    }

    public Matrix3f rotateY(float f2) {
        return rotateY(f2, this);
    }

    public Matrix3f rotateZ(float f2) {
        return rotateZ(f2, this);
    }

    public Matrix3f rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, this);
    }

    public Matrix3f rotateLocal(Quaternionfc quaternionfc, Matrix3f matrix3f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix3f matrix3f2 = matrix3f;
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc2, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f2 = y2 + y2;
        float b2 = a.b(quaternionfc2, quaternionfc.x());
        float a3 = a.a(quaternionfc2, quaternionfc.y());
        float b3 = a.b(quaternionfc2, quaternionfc.y());
        float a4 = a.a(quaternionfc2, quaternionfc.x());
        float b4 = a.b(w, x, z, y);
        float f3 = f2 + a2;
        float f4 = b2 - a3;
        float f5 = f2 - a2;
        float c2 = a.c(y, z, w, x);
        float f6 = b3 + a4;
        float f7 = a3 + b2;
        float f8 = b3 - a4;
        float d2 = a.d(z, y, x, w);
        float f9 = this.m00;
        float f10 = b4 * f9;
        float f11 = this.m01;
        float f12 = (f5 * f11) + f10;
        float f13 = this.m02;
        float f14 = (f7 * f13) + f12;
        float f15 = (f8 * f13) + (c2 * f11) + (f3 * f9);
        float f16 = f13 * d2;
        float f17 = f16 + (f11 * f6) + (f9 * f4);
        float f18 = this.m10;
        float f19 = b4 * f18;
        float f20 = f17;
        float f21 = this.m11;
        float f22 = (f5 * f21) + f19;
        float f23 = this.m12;
        float f24 = f15;
        float f25 = (f7 * f23) + f22;
        float f26 = (f8 * f23) + (c2 * f21) + (f3 * f18);
        float f27 = f23 * d2;
        float f28 = f27 + (f21 * f6) + (f18 * f4);
        float f29 = this.m20;
        float f30 = b4 * f29;
        float f31 = this.m21;
        float f32 = (f5 * f31) + f30;
        float f33 = this.m22;
        float f34 = (f7 * f33) + f32;
        float f35 = f8 * f33;
        float f36 = f35 + (c2 * f31) + (f3 * f29);
        float f37 = d2 * f33;
        float f38 = f37 + (f6 * f31) + (f4 * f29);
        matrix3f2.m00 = f14;
        matrix3f2.m01 = f24;
        matrix3f2.m02 = f20;
        matrix3f2.m10 = f25;
        matrix3f2.m11 = f26;
        matrix3f2.m12 = f28;
        matrix3f2.m20 = f34;
        matrix3f2.m21 = f36;
        matrix3f2.m22 = f38;
        return matrix3f2;
    }

    public Matrix3f set(AxisAngle4f axisAngle4f) {
        float f2 = axisAngle4f.x;
        float f3 = axisAngle4f.y;
        float f4 = axisAngle4f.z;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f5 = f2 * sqrt;
        float f6 = f3 * sqrt;
        float f7 = f4 * sqrt;
        double d2 = (double) axisAngle4f.angle;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f8 = 1.0f - cosFromSin;
        this.m00 = (f5 * f5 * f8) + cosFromSin;
        this.m11 = (f6 * f6 * f8) + cosFromSin;
        this.m22 = (f7 * f7 * f8) + cosFromSin;
        float f9 = f5 * f6 * f8;
        float f10 = f7 * sin;
        this.m10 = f9 - f10;
        this.m01 = f9 + f10;
        float f11 = f5 * f7 * f8;
        float f12 = f6 * sin;
        this.m20 = f11 + f12;
        this.m02 = f11 - f12;
        float f13 = f6 * f7 * f8;
        float f14 = f5 * sin;
        this.m21 = f13 - f14;
        this.m12 = f13 + f14;
        return this;
    }

    public Matrix3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
        return lookAlong(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix3f rotate(Quaternionfc quaternionfc, Matrix3f matrix3f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix3f matrix3f2 = matrix3f;
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc2, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f2 = y2 + y2;
        float b2 = a.b(quaternionfc2, quaternionfc.x());
        float a3 = a.a(quaternionfc2, quaternionfc.y());
        float b3 = a.b(quaternionfc2, quaternionfc.y());
        float a4 = a.a(quaternionfc2, quaternionfc.x());
        float b4 = a.b(w, x, z, y);
        float f3 = f2 + a2;
        float f4 = b2 - a3;
        float f5 = f2 - a2;
        float c2 = a.c(y, z, w, x);
        float f6 = b3 + a4;
        float f7 = a3 + b2;
        float f8 = b3 - a4;
        float d2 = a.d(z, y, x, w);
        float f9 = this.m00;
        float f10 = f9 * b4;
        float f11 = this.m10;
        float f12 = (f11 * f3) + f10;
        float f13 = this.m20;
        float f14 = (f13 * f4) + f12;
        float f15 = this.m01;
        float f16 = f15 * b4;
        float f17 = f14;
        float f18 = this.m11;
        float f19 = (f18 * f3) + f16;
        float f20 = this.m21;
        float f21 = d2;
        float f22 = (f20 * f4) + f19;
        float f23 = this.m02;
        float f24 = b4 * f23;
        float f25 = f8;
        float f26 = this.m12;
        float f27 = (f3 * f26) + f24;
        float f28 = this.m22;
        float f29 = (f4 * f28) + f27;
        float f30 = (f13 * f6) + (f11 * c2) + (f9 * f5);
        float f31 = (f20 * f6) + (f18 * c2) + (f15 * f5);
        float f32 = f6 * f28;
        float f33 = f32 + (c2 * f26) + (f5 * f23);
        float f34 = f13 * f21;
        float f35 = f20;
        Matrix3f matrix3f3 = matrix3f;
        matrix3f3.m20 = f34 + (f11 * f25) + (f9 * f7);
        float f36 = f35 * f21;
        matrix3f3.m21 = f36 + (f18 * f25) + (f15 * f7);
        float f37 = f28 * f21;
        matrix3f3.m22 = f37 + (f26 * f25) + (f23 * f7);
        matrix3f3.m00 = f17;
        matrix3f3.m01 = f22;
        matrix3f3.m02 = f29;
        matrix3f3.m10 = f30;
        matrix3f3.m11 = f31;
        matrix3f3.m12 = f33;
        return matrix3f3;
    }

    public Matrix3f scaleLocal(float f2, float f3, float f4) {
        return scaleLocal(f2, f3, f4, this);
    }

    public Matrix3f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
    }

    public Matrix3f(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        if (!(vector3fc instanceof Vector3f) || !(vector3fc2 instanceof Vector3f) || !(vector3fc3 instanceof Vector3f)) {
            setVector3fc(vector3fc, vector3fc2, vector3fc3);
        } else {
            MemUtil.INSTANCE.set(this, (Vector3f) vector3fc, (Vector3f) vector3fc2, (Vector3f) vector3fc3);
        }
    }

    public Matrix3f set(AxisAngle4d axisAngle4d) {
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
        this.m00 = (float) a.d(d7, d7, d11, d12);
        this.m11 = (float) a.d(d8, d8, d11, d12);
        this.m22 = (float) a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        this.m10 = (float) (d13 - d14);
        this.m01 = (float) (d13 + d14);
        double d15 = d7 * d9 * d10;
        double d16 = d8 * sin;
        this.m20 = (float) (d15 + d16);
        this.m02 = (float) (d15 - d16);
        double d17 = d8 * d9 * d10;
        double d18 = d7 * sin;
        this.m21 = (float) (d17 - d18);
        this.m12 = (float) (d17 + d18);
        return this;
    }

    public Matrix3f rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, this);
    }

    public Matrix3f rotate(AxisAngle4f axisAngle4f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Matrix3f rotate(AxisAngle4f axisAngle4f, Matrix3f matrix3f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z, matrix3f);
    }

    public Matrix3f rotate(float f2, Vector3fc vector3fc) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix3f rotate(float f2, Vector3fc vector3fc, Matrix3f matrix3f) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix3f);
    }

    public Matrix3f set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix3f set(Quaterniondc quaterniondc) {
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double w2 = quaterniondc.w() * quaterniondc.z();
        double y2 = quaterniondc.y() * quaterniondc.x();
        double z2 = quaterniondc.z() * quaterniondc.x();
        double w3 = quaterniondc.w() * quaterniondc.y();
        double z3 = quaterniondc.z() * quaterniondc.y();
        double w4 = quaterniondc.w() * quaterniondc.x();
        double d2 = w2;
        this.m00 = (float) a.b(w, x, z, y);
        this.m01 = (float) a.a(y2, d2, d2, y2);
        double d3 = z2;
        double d4 = w3;
        this.m02 = (float) a.f(z2, w3, d3, d4);
        double d5 = d2;
        this.m10 = (float) ((((-d5) + y2) - d5) + y2);
        this.m11 = (float) a.f(y, z, w, x);
        double d6 = z3 + z3;
        this.m12 = (float) (d6 + w4 + w4);
        this.m20 = (float) a.a(w3, z2, d3, d4);
        this.m21 = (float) ((d6 - w4) - w4);
        this.m22 = (float) a.g(z, y, x, w);
        return this;
    }

    public Matrix3f set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        return this;
    }

    public Matrix3f set(float[] fArr) {
        MemUtil.INSTANCE.copy(fArr, 0, this);
        return this;
    }

    public Matrix3f set(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        if (!(vector3fc instanceof Vector3f) || !(vector3fc2 instanceof Vector3f) || !(vector3fc3 instanceof Vector3f)) {
            setVector3fc(vector3fc, vector3fc2, vector3fc3);
        } else {
            MemUtil.INSTANCE.set(this, (Vector3f) vector3fc, (Vector3f) vector3fc2, (Vector3f) vector3fc3);
        }
        return this;
    }

    public Matrix3f set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        return this;
    }

    public Matrix3f set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        return this;
    }

    public Matrix3f set(int i2, int i3, float f2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i3 == 0) {
                        this.m20 = f2;
                        return this;
                    } else if (i3 == 1) {
                        this.m21 = f2;
                        return this;
                    } else if (i3 == 2) {
                        this.m22 = f2;
                        return this;
                    }
                }
            } else if (i3 == 0) {
                this.m10 = f2;
                return this;
            } else if (i3 == 1) {
                this.m11 = f2;
                return this;
            } else if (i3 == 2) {
                this.m12 = f2;
                return this;
            }
        } else if (i3 == 0) {
            this.m00 = f2;
            return this;
        } else if (i3 == 1) {
            this.m01 = f2;
            return this;
        } else if (i3 == 2) {
            this.m02 = f2;
            return this;
        }
        throw new IllegalArgumentException();
    }
}
