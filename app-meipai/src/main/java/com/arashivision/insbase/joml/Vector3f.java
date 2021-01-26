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
import java.nio.FloatBuffer;
import java.text.NumberFormat;

public class Vector3f implements Externalizable, Vector3fc {
    public static final long serialVersionUID = 1;
    public float x;
    public float y;
    public float z;

    public Vector3f() {
    }

    public static float distanceSquared(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f2 - f5;
        float f9 = f3 - f6;
        float f10 = f4 - f7;
        return (f10 * f10) + (f9 * f9) + (f8 * f8);
    }

    public static float lengthSquared(float f2, float f3, float f4) {
        return (f4 * f4) + (f3 * f3) + (f2 * f2);
    }

    private Vector3f thisOrNew() {
        return this;
    }

    public Vector3f absolute() {
        return absolute(thisOrNew());
    }

    public Vector3f add(Vector3fc vector3fc) {
        return add(vector3fc, thisOrNew());
    }

    public float angle(Vector3fc vector3fc) {
        float angleCos = angleCos(vector3fc);
        if (angleCos >= 1.0f) {
            angleCos = 1.0f;
        }
        if (angleCos <= -1.0f) {
            angleCos = -1.0f;
        }
        return (float) Math.acos((double) angleCos);
    }

    public float angleCos(Vector3fc vector3fc) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        double d2 = (double) ((f6 * f6) + f5);
        double z2 = (double) ((vector3fc.z() * vector3fc.z()) + (vector3fc.y() * vector3fc.y()) + (vector3fc.x() * vector3fc.x()));
        return (float) (((double) ((vector3fc.z() * this.z) + ((vector3fc.y() * this.y) + (vector3fc.x() * this.x)))) / Math.sqrt(d2 * z2));
    }

    public Vector3f ceil() {
        return ceil(thisOrNew());
    }

    public Vector3f cross(Vector3fc vector3fc) {
        return cross(vector3fc, thisOrNew());
    }

    public float distance(Vector3fc vector3fc) {
        return distance(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public float distanceSquared(Vector3fc vector3fc) {
        return distanceSquared(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Vector3f div(Vector3fc vector3fc) {
        return div(vector3fc.x(), vector3fc.y(), vector3fc.z(), thisOrNew());
    }

    public float dot(Vector3fc vector3fc) {
        return dot(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector3f.class != obj.getClass()) {
            return false;
        }
        Vector3f vector3f = (Vector3f) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(vector3f.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(vector3f.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(vector3f.z);
    }

    public Vector3f floor() {
        return floor(thisOrNew());
    }

    public Vector3f fma(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return fma(vector3fc, vector3fc2, thisOrNew());
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public Vector3f half(Vector3fc vector3fc) {
        return half(vector3fc, thisOrNew());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.z) + a.a(this.y, a.a(this.x, 31, 31), 31);
    }

    public Vector3f hermite(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2, Vector3f vector3f) {
        float f3 = f2 * f2;
        float f4 = f3 * f2;
        float f5 = this.x;
        float x2 = ((((((vector3fc2.x() * 3.0f) - (this.x * 3.0f)) - vector3fc.x()) - vector3fc.x()) - vector3fc3.x()) * f3) + ((vector3fc.x() + vector3fc3.x() + (((f5 + f5) - vector3fc2.x()) - vector3fc2.x())) * f4);
        float f6 = this.x;
        vector3f.x = a.f(f6, f2, x2, f6);
        float f7 = this.y;
        float y2 = ((((((vector3fc2.y() * 3.0f) - (this.y * 3.0f)) - vector3fc.y()) - vector3fc.y()) - vector3fc3.y()) * f3) + ((vector3fc.y() + vector3fc3.y() + (((f7 + f7) - vector3fc2.y()) - vector3fc2.y())) * f4);
        float f8 = this.y;
        vector3f.y = a.f(f8, f2, y2, f8);
        float f9 = this.z;
        float z2 = ((((((vector3fc2.z() * 3.0f) - (this.z * 3.0f)) - vector3fc.z()) - vector3fc.z()) - vector3fc3.z()) * f3) + ((vector3fc.z() + vector3fc3.z() + (((f9 + f9) - vector3fc2.z()) - vector3fc2.z())) * f4);
        float f10 = this.z;
        vector3f.z = a.f(f2, f10, z2, f10);
        return vector3f;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z);
    }

    public float length() {
        return (float) Math.sqrt((double) lengthSquared());
    }

    public float lengthSquared() {
        return lengthSquared(this.x, this.y, this.z);
    }

    public Vector3f lerp(Vector3fc vector3fc, float f2) {
        return lerp(vector3fc, f2, thisOrNew());
    }

    public Vector3f max(Vector3fc vector3fc) {
        return max(vector3fc, thisOrNew());
    }

    public int maxComponent() {
        float abs = Math.abs(this.x);
        float abs2 = Math.abs(this.y);
        float abs3 = Math.abs(this.z);
        if (abs < abs2 || abs < abs3) {
            return abs2 >= abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3f min(Vector3fc vector3fc) {
        return min(vector3fc, thisOrNew());
    }

    public int minComponent() {
        float abs = Math.abs(this.x);
        float abs2 = Math.abs(this.y);
        float abs3 = Math.abs(this.z);
        if (abs >= abs2 || abs >= abs3) {
            return abs2 < abs3 ? 1 : 2;
        }
        return 0;
    }

    public Vector3f mul(Vector3fc vector3fc) {
        return mul(vector3fc, thisOrNew());
    }

    public Vector3f mulDirection(Matrix4dc matrix4dc) {
        return mulDirection(matrix4dc, thisOrNew());
    }

    public Vector3f mulPosition(Matrix4fc matrix4fc) {
        return mulPosition(matrix4fc, thisOrNew());
    }

    public float mulPositionW(Matrix4fc matrix4fc) {
        return mulPositionW(matrix4fc, thisOrNew());
    }

    public Vector3f mulProject(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m33 = 1.0f / (matrix4fc.m33() + ((matrix4fc.m23() * this.z) + ((matrix4fc.m13() * this.y) + (matrix4fc.m03() * this.x))));
        float m30 = (matrix4fc.m30() + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x)) * m33;
        float m31 = (matrix4fc.m31() + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x)) * m33;
        float m32 = (matrix4fc.m32() + (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x)) * m33;
        vector3f.x = m30;
        vector3f.y = m31;
        vector3f.z = m32;
        return vector3f;
    }

    public Vector3f mulTranspose(Matrix3fc matrix3fc) {
        return mulTranspose(matrix3fc, thisOrNew());
    }

    public Vector3f mulTransposeDirection(Matrix4fc matrix4fc) {
        return mulTransposeDirection(matrix4fc, thisOrNew());
    }

    public Vector3f mulTransposePosition(Matrix4fc matrix4fc) {
        return mulTransposePosition(matrix4fc, thisOrNew());
    }

    public Vector3f negate() {
        return negate(thisOrNew());
    }

    public Vector3f normalize() {
        return normalize(thisOrNew());
    }

    public Vector3f orthogonalize(Vector3fc vector3fc, Vector3f vector3f) {
        float f2;
        float f3;
        float f4 = 0.0f;
        if (Math.abs(vector3fc.x()) > Math.abs(vector3fc.z())) {
            float f5 = -vector3fc.y();
            f2 = vector3fc.x();
            f4 = f5;
            f3 = 0.0f;
        } else {
            float f6 = -vector3fc.z();
            f3 = vector3fc.y();
            f2 = f6;
        }
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f3 * f3) + ((f2 * f2) + (f4 * f4)))));
        vector3f.x = f4 * sqrt;
        vector3f.y = f2 * sqrt;
        vector3f.z = f3 * sqrt;
        return vector3f;
    }

    public Vector3f orthogonalizeUnit(Vector3fc vector3fc, Vector3f vector3f) {
        return orthogonalize(vector3fc, vector3f);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readFloat();
        this.y = objectInput.readFloat();
        this.z = objectInput.readFloat();
    }

    public Vector3f reflect(Vector3fc vector3fc) {
        return reflect(vector3fc, thisOrNew());
    }

    public Vector3f rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, thisOrNew());
    }

    public Vector3f rotateAxis(float f2, float f3, float f4, float f5) {
        return rotateAxis(f2, f3, f4, f5, thisOrNew());
    }

    public Vector3f rotateX(float f2) {
        return rotateX(f2, thisOrNew());
    }

    public Vector3f rotateY(float f2) {
        return rotateY(f2, thisOrNew());
    }

    public Vector3f rotateZ(float f2) {
        return rotateZ(f2, thisOrNew());
    }

    public Quaternionf rotationTo(Vector3fc vector3fc, Quaternionf quaternionf) {
        return quaternionf.rotationTo(this, vector3fc);
    }

    public Vector3f round() {
        return round(thisOrNew());
    }

    public Vector3f set(Vector3fc vector3fc) {
        return set(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Vector3f setComponent(int i2, float f2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = f2;
        } else if (i2 == 1) {
            this.y = f2;
        } else if (i2 == 2) {
            this.z = f2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector3f smoothStep(Vector3fc vector3fc, float f2, Vector3f vector3f) {
        float f3 = f2 * f2;
        float f4 = f3 * f2;
        float f5 = this.x;
        float x2 = (((f5 + f5) - vector3fc.x()) - vector3fc.x()) * f4;
        float x3 = vector3fc.x() * 3.0f;
        float f6 = this.x;
        vector3f.x = a.f(f6, f2, a.a(f6, 3.0f, x3, f3, x2), f6);
        float f7 = this.y;
        float y2 = (((f7 + f7) - vector3fc.y()) - vector3fc.y()) * f4;
        float y3 = vector3fc.y() * 3.0f;
        float f8 = this.y;
        vector3f.y = a.f(f8, f2, a.a(f8, 3.0f, y3, f3, y2), f8);
        float f9 = this.z;
        float z2 = (((f9 + f9) - vector3fc.z()) - vector3fc.z()) * f4;
        float z3 = vector3fc.z() * 3.0f;
        float f10 = this.z;
        vector3f.z = a.f(f2, f10, a.a(f10, 3.0f, z3, f3, z2), f10);
        return vector3f;
    }

    public Vector3f sub(Vector3fc vector3fc) {
        return sub(vector3fc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.x);
        objectOutput.writeFloat(this.y);
        objectOutput.writeFloat(this.z);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float z() {
        return this.z;
    }

    public Vector3f zero() {
        return thisOrNew().set(0.0f, 0.0f, 0.0f);
    }

    public Vector3f(float f2) {
        this(f2, f2, f2);
    }

    public static float length(float f2, float f3, float f4) {
        return (float) Math.sqrt((double) lengthSquared(f2, f3, f4));
    }

    public Vector3f absolute(Vector3f vector3f) {
        vector3f.x = Math.abs(this.x);
        vector3f.y = Math.abs(this.y);
        vector3f.z = Math.abs(this.z);
        return vector3f;
    }

    public Vector3f add(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = vector3fc.x() + this.x;
        vector3f.y = vector3fc.y() + this.y;
        vector3f.z = vector3fc.z() + this.z;
        return vector3f;
    }

    public Vector3f ceil(Vector3f vector3f) {
        vector3f.x = Math.ceil(this.x);
        vector3f.y = Math.ceil(this.y);
        vector3f.z = Math.ceil(this.z);
        return vector3f;
    }

    public Vector3f cross(float f2, float f3, float f4) {
        return cross(f2, f3, f4, thisOrNew());
    }

    public float distance(float f2, float f3, float f4) {
        float f5 = this.x - f2;
        float f6 = this.y - f3;
        float f7 = this.z - f4;
        return (float) Math.sqrt((double) ((f7 * f7) + (f6 * f6) + (f5 * f5)));
    }

    public float distanceSquared(float f2, float f3, float f4) {
        float f5 = this.x - f2;
        float f6 = this.y - f3;
        float f7 = this.z - f4;
        return (f7 * f7) + (f6 * f6) + (f5 * f5);
    }

    public Vector3f div(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = this.x / vector3fc.x();
        vector3f.y = this.y / vector3fc.y();
        vector3f.z = this.z / vector3fc.z();
        return vector3f;
    }

    public float dot(float f2, float f3, float f4) {
        return (this.z * f4) + (this.y * f3) + (this.x * f2);
    }

    public Vector3f floor(Vector3f vector3f) {
        vector3f.x = Math.floor(this.x);
        vector3f.y = Math.floor(this.y);
        vector3f.z = Math.floor(this.z);
        return vector3f;
    }

    public Vector3f fma(float f2, Vector3fc vector3fc) {
        return fma(f2, vector3fc, thisOrNew());
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Vector3f half(float f2, float f3, float f4) {
        return half(f2, f3, f4, thisOrNew());
    }

    public Vector3f lerp(Vector3fc vector3fc, float f2, Vector3f vector3f) {
        vector3f.x = a.e(vector3fc.x(), this.x, f2, this.x);
        vector3f.y = a.e(vector3fc.y(), this.y, f2, this.y);
        vector3f.z = a.e(vector3fc.z(), this.z, f2, this.z);
        return vector3f;
    }

    public Vector3f max(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = this.x > vector3fc.x() ? this.x : vector3fc.x();
        vector3f.y = this.y > vector3fc.y() ? this.y : vector3fc.y();
        vector3f.z = this.z > vector3fc.z() ? this.z : vector3fc.z();
        return vector3f;
    }

    public Vector3f min(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = this.x < vector3fc.x() ? this.x : vector3fc.x();
        vector3f.y = this.y < vector3fc.y() ? this.y : vector3fc.y();
        vector3f.z = this.z < vector3fc.z() ? this.z : vector3fc.z();
        return vector3f;
    }

    public Vector3f mul(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = vector3fc.x() * this.x;
        vector3f.y = vector3fc.y() * this.y;
        vector3f.z = vector3fc.z() * this.z;
        return vector3f;
    }

    public Vector3f mulDirection(Matrix4fc matrix4fc) {
        return mulDirection(matrix4fc, thisOrNew());
    }

    public Vector3f mulPosition(Matrix4x3fc matrix4x3fc) {
        return mulPosition(matrix4x3fc, thisOrNew());
    }

    public float mulPositionW(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m33 = matrix4fc.m33() + (matrix4fc.m23() * this.z) + (matrix4fc.m13() * this.y) + (matrix4fc.m03() * this.x);
        float m30 = matrix4fc.m30() + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x);
        float m31 = matrix4fc.m31() + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x);
        float m32 = matrix4fc.m32() + (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x);
        vector3f.x = m30;
        vector3f.y = m31;
        vector3f.z = m32;
        return m33;
    }

    public Vector3f mulTranspose(Matrix3fc matrix3fc, Vector3f vector3f) {
        float m02 = (matrix3fc.m02() * this.z) + (matrix3fc.m01() * this.y) + (matrix3fc.m00() * this.x);
        float m12 = (matrix3fc.m12() * this.z) + (matrix3fc.m11() * this.y) + (matrix3fc.m10() * this.x);
        float m22 = (matrix3fc.m22() * this.z) + (matrix3fc.m21() * this.y) + (matrix3fc.m20() * this.x);
        vector3f.x = m02;
        vector3f.y = m12;
        vector3f.z = m22;
        return vector3f;
    }

    public Vector3f mulTransposeDirection(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m02 = (matrix4fc.m02() * this.z) + (matrix4fc.m01() * this.y) + (matrix4fc.m00() * this.x);
        float m12 = (matrix4fc.m12() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m10() * this.x);
        float m22 = (matrix4fc.m22() * this.z) + (matrix4fc.m21() * this.y) + (matrix4fc.m20() * this.x);
        vector3f.x = m02;
        vector3f.y = m12;
        vector3f.z = m22;
        return vector3f;
    }

    public Vector3f mulTransposePosition(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m03 = matrix4fc.m03() + (matrix4fc.m02() * this.z) + (matrix4fc.m01() * this.y) + (matrix4fc.m00() * this.x);
        float m13 = matrix4fc.m13() + (matrix4fc.m12() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m10() * this.x);
        float m23 = matrix4fc.m23() + (matrix4fc.m22() * this.z) + (matrix4fc.m21() * this.y) + (matrix4fc.m20() * this.x);
        vector3f.x = m03;
        vector3f.y = m13;
        vector3f.z = m23;
        return vector3f;
    }

    public Vector3f negate(Vector3f vector3f) {
        vector3f.x = -this.x;
        vector3f.y = -this.y;
        vector3f.z = -this.z;
        return vector3f;
    }

    public Vector3f normalize(Vector3f vector3f) {
        float length = 1.0f / length();
        vector3f.x = this.x * length;
        vector3f.y = this.y * length;
        vector3f.z = this.z * length;
        return vector3f;
    }

    public Vector3f orthogonalizeUnit(Vector3fc vector3fc) {
        return orthogonalizeUnit(vector3fc, thisOrNew());
    }

    public Vector3f reflect(float f2, float f3, float f4) {
        return reflect(f2, f3, f4, thisOrNew());
    }

    public Vector3f rotate(Quaternionfc quaternionfc, Vector3f vector3f) {
        return quaternionfc.transform((Vector3fc) this, vector3f);
    }

    public Vector3f rotateAxis(float f2, float f3, float f4, float f5, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        double d2 = (double) (0.5f * f2);
        float sin = (float) Math.sin(d2);
        float f6 = f3 * sin;
        float f7 = f4 * sin;
        float f8 = f5 * sin;
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f9 = cosFromSin * cosFromSin;
        float f10 = f6 * f6;
        float f11 = f7 * f7;
        float f12 = f8 * f8;
        float f13 = f8 * cosFromSin;
        float f14 = f6 * f7;
        float f15 = f6 * f8;
        float f16 = f7 * cosFromSin;
        float f17 = f7 * f8;
        float f18 = f6 * cosFromSin;
        float b2 = a.b(f9, f10, f12, f11);
        float f19 = this.x;
        float f20 = b2 * f19;
        float f21 = (((-f13) + f14) - f13) + f14;
        float f22 = this.y;
        float f23 = (f21 * f22) + f20;
        float a2 = a.a(f16, f15, f15, f16);
        float f24 = this.z;
        float f25 = (a2 * f24) + f23;
        float f26 = f17 + f17;
        float f27 = ((f26 - f18) - f18) * f24;
        float f28 = f27 + ((((f11 - f12) + f9) - f10) * f22) + ((f14 + f13 + f13 + f14) * f19);
        float f29 = (((f12 - f11) - f10) + f9) * f24;
        float f30 = f29 + ((f26 + f18 + f18) * f22) + ((((f15 - f16) + f15) - f16) * f19);
        Vector3f vector3f3 = vector3f;
        vector3f3.x = f25;
        vector3f3.y = f28;
        vector3f3.z = f30;
        return vector3f3;
    }

    public Vector3f rotateX(float f2, Vector3f vector3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.y;
        float f4 = f3 * cosFromSin;
        float f5 = this.z;
        float f6 = f4 - (f5 * sin);
        float f7 = (f5 * cosFromSin) + (f3 * sin);
        vector3f.x = this.x;
        vector3f.y = f6;
        vector3f.z = f7;
        return vector3f;
    }

    public Vector3f rotateY(float f2, Vector3f vector3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.z;
        float f6 = (f5 * cosFromSin) + ((-f3) * sin);
        vector3f.x = (f5 * sin) + f4;
        vector3f.y = this.y;
        vector3f.z = f6;
        return vector3f;
    }

    public Vector3f rotateZ(float f2, Vector3f vector3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.y;
        float f6 = (f5 * cosFromSin) + (f3 * sin);
        vector3f.x = f4 - (f5 * sin);
        vector3f.y = f6;
        vector3f.z = this.z;
        return vector3f;
    }

    public Quaternionf rotationTo(float f2, float f3, float f4, Quaternionf quaternionf) {
        return quaternionf.rotationTo(this.x, this.y, this.z, f2, f3, f4);
    }

    public Vector3f round(Vector3f vector3f) {
        vector3f.x = (float) Math.round(this.x);
        vector3f.y = (float) Math.round(this.y);
        vector3f.z = (float) Math.round(this.z);
        return vector3f;
    }

    public Vector3f set(Vector3dc vector3dc) {
        return set((float) vector3dc.x(), (float) vector3dc.y(), (float) vector3dc.z());
    }

    public Vector3f sub(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = this.x - vector3fc.x();
        vector3f.y = this.y - vector3fc.y();
        vector3f.z = this.z - vector3fc.z();
        return vector3f;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.x, a2, str);
        a.b(numberFormat, (double) this.y, a2, str);
        return a.a(numberFormat, (double) this.z, a2, ")");
    }

    public Vector3f(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    public Vector3f cross(Vector3fc vector3fc, Vector3f vector3f) {
        float z2 = (vector3fc.z() * this.y) - (vector3fc.y() * this.z);
        float x2 = (vector3fc.x() * this.z) - (vector3fc.z() * this.x);
        float y2 = (vector3fc.y() * this.x) - (vector3fc.x() * this.y);
        vector3f.x = z2;
        vector3f.y = x2;
        vector3f.z = y2;
        return vector3f;
    }

    public Vector3f fma(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f) {
        vector3f.x = (vector3fc2.x() * vector3fc.x()) + this.x;
        vector3f.y = (vector3fc2.y() * vector3fc.y()) + this.y;
        vector3f.z = (vector3fc2.z() * vector3fc.z()) + this.z;
        return vector3f;
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector3f half(Vector3fc vector3fc, Vector3f vector3f) {
        return half(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f);
    }

    public Vector3f mulDirection(Matrix4x3fc matrix4x3fc) {
        return mulDirection(matrix4x3fc, thisOrNew());
    }

    public Vector3f mulPosition(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m30 = matrix4fc.m30() + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x);
        float m31 = matrix4fc.m31() + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x);
        float m32 = matrix4fc.m32() + (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x);
        vector3f.x = m30;
        vector3f.y = m31;
        vector3f.z = m32;
        return vector3f;
    }

    public Vector3f reflect(Vector3fc vector3fc, Vector3f vector3f) {
        return reflect(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f);
    }

    public Vector3f set(Vector3ic vector3ic) {
        return set((float) vector3ic.x(), (float) vector3ic.y(), (float) vector3ic.z());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector3f half(float f2, float f3, float f4, Vector3f vector3f) {
        return vector3f.set((Vector3fc) this).add(f2, f3, f4).normalize();
    }

    public Vector3f mulDirection(Matrix4dc matrix4dc, Vector3f vector3f) {
        double m20 = (matrix4dc.m20() * ((double) this.z)) + (matrix4dc.m10() * ((double) this.y)) + (matrix4dc.m00() * ((double) this.x));
        double m21 = (matrix4dc.m21() * ((double) this.z)) + (matrix4dc.m11() * ((double) this.y)) + (matrix4dc.m01() * ((double) this.x));
        double m22 = (matrix4dc.m22() * ((double) this.z)) + (matrix4dc.m12() * ((double) this.y)) + (matrix4dc.m02() * ((double) this.x));
        vector3f.x = (float) m20;
        vector3f.y = (float) m21;
        vector3f.z = (float) m22;
        return vector3f;
    }

    public Vector3f reflect(float f2, float f3, float f4, Vector3f vector3f) {
        float dot = dot(f2, f3, f4);
        float f5 = dot + dot;
        vector3f.x = this.x - (f2 * f5);
        vector3f.y = this.y - (f3 * f5);
        vector3f.z = this.z - (f5 * f4);
        return vector3f;
    }

    public Vector3f set(Vector2fc vector2fc, float f2) {
        return set(vector2fc.x(), vector2fc.y(), f2);
    }

    public Vector3f add(float f2, float f3, float f4) {
        return add(f2, f3, f4, thisOrNew());
    }

    public Vector3f div(float f2) {
        return div(f2, thisOrNew());
    }

    public float get(int i2) throws IllegalArgumentException {
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

    public Vector3f mul(Matrix3fc matrix3fc) {
        return mul(matrix3fc, thisOrNew());
    }

    public Vector3f set(Vector2ic vector2ic, float f2) {
        return set((float) vector2ic.x(), (float) vector2ic.y(), f2);
    }

    public Vector3f sub(float f2, float f3, float f4) {
        return sub(f2, f3, f4, thisOrNew());
    }

    public static float distance(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (float) Math.sqrt((double) distanceSquared(f2, f3, f4, f5, f6, f7));
    }

    public Vector3f add(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = this.x + f2;
        vector3f.y = this.y + f3;
        vector3f.z = this.z + f4;
        return vector3f;
    }

    public Vector3f div(float f2, Vector3f vector3f) {
        float f3 = 1.0f / f2;
        vector3f.x = this.x * f3;
        vector3f.y = this.y * f3;
        vector3f.z = this.z * f3;
        return vector3f;
    }

    public boolean equals(Vector3fc vector3fc, float f2) {
        if (this == vector3fc) {
            return true;
        }
        return vector3fc != null && Runtime.equals(this.x, vector3fc.x(), f2) && Runtime.equals(this.y, vector3fc.y(), f2) && Runtime.equals(this.z, vector3fc.z(), f2);
    }

    public Vector3f fma(float f2, Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.x = (vector3fc.x() * f2) + this.x;
        vector3f.y = (vector3fc.y() * f2) + this.y;
        vector3f.z = (vector3fc.z() * f2) + this.z;
        return vector3f;
    }

    public Vector3f mul(Matrix3fc matrix3fc, Vector3f vector3f) {
        float m20 = (matrix3fc.m20() * this.z) + (matrix3fc.m10() * this.y) + (matrix3fc.m00() * this.x);
        float m21 = (matrix3fc.m21() * this.z) + (matrix3fc.m11() * this.y) + (matrix3fc.m01() * this.x);
        float m22 = (matrix3fc.m22() * this.z) + (matrix3fc.m12() * this.y) + (matrix3fc.m02() * this.x);
        vector3f.x = m20;
        vector3f.y = m21;
        vector3f.z = m22;
        return vector3f;
    }

    public Vector3f normalize(float f2) {
        return normalize(f2, thisOrNew());
    }

    public Vector3f set(float f2) {
        return set(f2, f2, f2);
    }

    public Vector3f sub(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = this.x - f2;
        vector3f.y = this.y - f3;
        vector3f.z = this.z - f4;
        return vector3f;
    }

    public Vector3f(Vector3fc vector3fc) {
        this(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Vector3f normalize(float f2, Vector3f vector3f) {
        float length = (1.0f / length()) * f2;
        vector3f.x = this.x * length;
        vector3f.y = this.y * length;
        vector3f.z = this.z * length;
        return vector3f;
    }

    public Vector3f set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        return this;
    }

    public Vector3f(Vector3ic vector3ic) {
        this((float) vector3ic.x(), (float) vector3ic.y(), (float) vector3ic.z());
    }

    public Vector3f mulProject(Matrix4fc matrix4fc) {
        return mulProject(matrix4fc, thisOrNew());
    }

    public Vector3f(Vector2fc vector2fc, float f2) {
        this(vector2fc.x(), vector2fc.y(), f2);
    }

    public Vector3f cross(float f2, float f3, float f4, Vector3f vector3f) {
        float f5 = this.y;
        float f6 = f5 * f4;
        float f7 = this.z;
        float f8 = f6 - (f7 * f3);
        float f9 = f7 * f2;
        float f10 = this.x;
        float f11 = f9 - (f4 * f10);
        float f12 = (f10 * f3) - (f5 * f2);
        vector3f.x = f8;
        vector3f.y = f11;
        vector3f.z = f12;
        return vector3f;
    }

    public Vector3f div(float f2, float f3, float f4) {
        return div(f2, f3, f4, thisOrNew());
    }

    public boolean equals(float f2, float f3, float f4) {
        if (Float.floatToIntBits(this.x) == Float.floatToIntBits(f2) && Float.floatToIntBits(this.y) == Float.floatToIntBits(f3) && Float.floatToIntBits(this.z) == Float.floatToIntBits(f4)) {
            return true;
        }
        return false;
    }

    public Vector3f mulPosition(Matrix4x3fc matrix4x3fc, Vector3f vector3f) {
        float m30 = matrix4x3fc.m30() + (matrix4x3fc.m20() * this.z) + (matrix4x3fc.m10() * this.y) + (matrix4x3fc.m00() * this.x);
        float m31 = matrix4x3fc.m31() + (matrix4x3fc.m21() * this.z) + (matrix4x3fc.m11() * this.y) + (matrix4x3fc.m01() * this.x);
        float m32 = matrix4x3fc.m32() + (matrix4x3fc.m22() * this.z) + (matrix4x3fc.m12() * this.y) + (matrix4x3fc.m02() * this.x);
        vector3f.x = m30;
        vector3f.y = m31;
        vector3f.z = m32;
        return vector3f;
    }

    public Vector3f(Vector2ic vector2ic, float f2) {
        this((float) vector2ic.x(), (float) vector2ic.y(), f2);
    }

    public Vector3f div(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = this.x / f2;
        vector3f.y = this.y / f3;
        vector3f.z = this.z / f4;
        return vector3f;
    }

    public Vector3f mulDirection(Matrix4fc matrix4fc, Vector3f vector3f) {
        float m20 = (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x);
        float m21 = (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x);
        float m22 = (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x);
        vector3f.x = m20;
        vector3f.y = m21;
        vector3f.z = m22;
        return vector3f;
    }

    public Vector3f orthogonalize(Vector3fc vector3fc) {
        return orthogonalize(vector3fc, thisOrNew());
    }

    public Vector3f set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector3f(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector3f set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector3f(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector3f mul(Matrix3dc matrix3dc) {
        return mul(matrix3dc, thisOrNew());
    }

    public Vector3f set(FloatBuffer floatBuffer) {
        return set(floatBuffer.position(), floatBuffer);
    }

    public Vector3f mul(Matrix3dc matrix3dc, Vector3f vector3f) {
        double m20 = (matrix3dc.m20() * ((double) this.z)) + (matrix3dc.m10() * ((double) this.y)) + (matrix3dc.m00() * ((double) this.x));
        double m21 = (matrix3dc.m21() * ((double) this.z)) + (matrix3dc.m11() * ((double) this.y)) + (matrix3dc.m01() * ((double) this.x));
        double m22 = (matrix3dc.m22() * ((double) this.z)) + (matrix3dc.m12() * ((double) this.y)) + (matrix3dc.m02() * ((double) this.x));
        vector3f.x = (float) m20;
        vector3f.y = (float) m21;
        vector3f.z = (float) m22;
        return vector3f;
    }

    public Vector3f set(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
        return this;
    }

    public Vector3f(FloatBuffer floatBuffer) {
        this(floatBuffer.position(), floatBuffer);
    }

    public Vector3f(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
    }

    public Vector3f mulDirection(Matrix4x3fc matrix4x3fc, Vector3f vector3f) {
        float m20 = (matrix4x3fc.m20() * this.z) + (matrix4x3fc.m10() * this.y) + (matrix4x3fc.m00() * this.x);
        float m21 = (matrix4x3fc.m21() * this.z) + (matrix4x3fc.m11() * this.y) + (matrix4x3fc.m01() * this.x);
        float m22 = (matrix4x3fc.m22() * this.z) + (matrix4x3fc.m12() * this.y) + (matrix4x3fc.m02() * this.x);
        vector3f.x = m20;
        vector3f.y = m21;
        vector3f.z = m22;
        return vector3f;
    }

    public Vector3f mul(Matrix3x2fc matrix3x2fc) {
        return mul(matrix3x2fc, thisOrNew());
    }

    public Vector3f mul(Matrix3x2fc matrix3x2fc, Vector3f vector3f) {
        float m20 = (matrix3x2fc.m20() * this.z) + (matrix3x2fc.m10() * this.y) + (matrix3x2fc.m00() * this.x);
        float m11 = (matrix3x2fc.m11() * this.y) + (matrix3x2fc.m01() * this.x);
        float m21 = matrix3x2fc.m21();
        float f2 = this.z;
        float f3 = (m21 * f2) + m11;
        vector3f.x = m20;
        vector3f.y = f3;
        vector3f.z = f2;
        return vector3f;
    }

    public Vector3f mul(float f2) {
        return mul(f2, thisOrNew());
    }

    public Vector3f mul(float f2, Vector3f vector3f) {
        vector3f.x = this.x * f2;
        vector3f.y = this.y * f2;
        vector3f.z = this.z * f2;
        return vector3f;
    }

    public Vector3f mul(float f2, float f3, float f4) {
        return mul(f2, f3, f4, thisOrNew());
    }

    public Vector3f mul(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = this.x * f2;
        vector3f.y = this.y * f3;
        vector3f.z = this.z * f4;
        return vector3f;
    }
}
