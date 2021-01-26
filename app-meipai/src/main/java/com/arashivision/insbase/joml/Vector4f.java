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

public class Vector4f implements Externalizable, Vector4fc {
    public static final long serialVersionUID = 1;
    public float w;
    public float x;
    public float y;
    public float z;

    public Vector4f() {
        this.w = 1.0f;
    }

    public static float distanceSquared(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f2 - f6;
        float f11 = f3 - f7;
        float f12 = f4 - f8;
        float f13 = f5 - f9;
        return (f13 * f13) + (f12 * f12) + (f11 * f11) + (f10 * f10);
    }

    public static float lengthSquared(float f2, float f3, float f4, float f5) {
        return (f5 * f5) + (f4 * f4) + (f3 * f3) + (f2 * f2);
    }

    public static float lengthSquared(int i2, int i3, int i4, int i5) {
        return (float) ((i5 * i5) + (i4 * i4) + (i3 * i3) + (i2 * i2));
    }

    private Vector4f mulGeneric(Matrix4fc matrix4fc, Vector4f vector4f) {
        float m30 = (matrix4fc.m30() * this.w) + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x);
        float m31 = (matrix4fc.m31() * this.w) + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x);
        float m32 = (matrix4fc.m32() * this.w) + (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x);
        float m33 = (matrix4fc.m33() * this.w) + (matrix4fc.m23() * this.z) + (matrix4fc.m13() * this.y) + (matrix4fc.m03() * this.x);
        vector4f.x = m30;
        vector4f.y = m31;
        vector4f.z = m32;
        vector4f.w = m33;
        return vector4f;
    }

    private Vector4f thisOrNew() {
        return this;
    }

    public Vector4f add(Vector4fc vector4fc) {
        return add(vector4fc, thisOrNew());
    }

    public float angle(Vector4fc vector4fc) {
        float angleCos = angleCos(vector4fc);
        if (angleCos >= 1.0f) {
            angleCos = 1.0f;
        }
        if (angleCos <= -1.0f) {
            angleCos = -1.0f;
        }
        return (float) Math.acos((double) angleCos);
    }

    public float angleCos(Vector4fc vector4fc) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        double d2 = (double) ((f8 * f8) + f7);
        double w2 = (double) ((vector4fc.w() * vector4fc.w()) + (vector4fc.z() * vector4fc.z()) + (vector4fc.y() * vector4fc.y()) + (vector4fc.x() * vector4fc.x()));
        return (float) (((double) ((vector4fc.w() * this.w) + ((vector4fc.z() * this.z) + ((vector4fc.y() * this.y) + (vector4fc.x() * this.x))))) / Math.sqrt(d2 * w2));
    }

    public Vector4f ceil() {
        return ceil(thisOrNew());
    }

    public float distance(Vector4fc vector4fc) {
        return distance(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w());
    }

    public float distanceSquared(Vector4fc vector4fc) {
        return distanceSquared(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w());
    }

    public Vector4f div(Vector4fc vector4fc) {
        return div(vector4fc, thisOrNew());
    }

    public float dot(Vector4fc vector4fc) {
        return (vector4fc.w() * this.w) + (vector4fc.z() * this.z) + (vector4fc.y() * this.y) + (vector4fc.x() * this.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector4f.class != obj.getClass()) {
            return false;
        }
        Vector4f vector4f = (Vector4f) obj;
        return Float.floatToIntBits(this.w) == Float.floatToIntBits(vector4f.w) && Float.floatToIntBits(this.x) == Float.floatToIntBits(vector4f.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(vector4f.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(vector4f.z);
    }

    public Vector4f floor() {
        return floor(thisOrNew());
    }

    public Vector4f fma(Vector4fc vector4fc, Vector4fc vector4fc2) {
        return fma(vector4fc, vector4fc2, thisOrNew());
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.z) + a.a(this.y, a.a(this.x, a.a(this.w, 31, 31), 31), 31);
    }

    public Vector4f hermite(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4fc vector4fc3, float f2, Vector4f vector4f) {
        float f3 = f2 * f2;
        float f4 = f3 * f2;
        float f5 = this.x;
        float x2 = ((((((vector4fc2.x() * 3.0f) - (this.x * 3.0f)) - vector4fc.x()) - vector4fc.x()) - vector4fc3.x()) * f3) + ((vector4fc.x() + vector4fc3.x() + (((f5 + f5) - vector4fc2.x()) - vector4fc2.x())) * f4);
        float f6 = this.x;
        vector4f.x = a.f(f6, f2, x2, f6);
        float f7 = this.y;
        float y2 = ((((((vector4fc2.y() * 3.0f) - (this.y * 3.0f)) - vector4fc.y()) - vector4fc.y()) - vector4fc3.y()) * f3) + ((vector4fc.y() + vector4fc3.y() + (((f7 + f7) - vector4fc2.y()) - vector4fc2.y())) * f4);
        float f8 = this.y;
        vector4f.y = a.f(f8, f2, y2, f8);
        float f9 = this.z;
        float z2 = ((((((vector4fc2.z() * 3.0f) - (this.z * 3.0f)) - vector4fc.z()) - vector4fc.z()) - vector4fc3.z()) * f3) + ((vector4fc.z() + vector4fc3.z() + (((f9 + f9) - vector4fc2.z()) - vector4fc2.z())) * f4);
        float f10 = this.z;
        vector4f.z = a.f(f10, f2, z2, f10);
        float f11 = this.w;
        float w2 = ((((((vector4fc2.w() * 3.0f) - (this.w * 3.0f)) - vector4fc.w()) - vector4fc.w()) - vector4fc3.w()) * f3) + ((vector4fc.w() + vector4fc3.w() + (((f11 + f11) - vector4fc2.w()) - vector4fc2.w())) * f4);
        float f12 = this.w;
        vector4f.w = a.f(f2, f12, w2, f12);
        return vector4f;
    }

    public boolean isFinite() {
        return Math.isFinite(this.x) && Math.isFinite(this.y) && Math.isFinite(this.z) && Math.isFinite(this.w);
    }

    public float length() {
        return (float) Math.sqrt((double) lengthSquared());
    }

    public float lengthSquared() {
        return lengthSquared(this.x, this.y, this.z, this.w);
    }

    public Vector4f lerp(Vector4fc vector4fc, float f2) {
        return lerp(vector4fc, f2, thisOrNew());
    }

    public Vector4f max(Vector4fc vector4fc) {
        return max(vector4fc, thisOrNew());
    }

    public int maxComponent() {
        float abs = Math.abs(this.x);
        float abs2 = Math.abs(this.y);
        float abs3 = Math.abs(this.z);
        float abs4 = Math.abs(this.w);
        if (abs >= abs2 && abs >= abs3 && abs >= abs4) {
            return 0;
        }
        if (abs2 < abs3 || abs2 < abs4) {
            return abs3 >= abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4f min(Vector4fc vector4fc) {
        return min(vector4fc, thisOrNew());
    }

    public int minComponent() {
        float abs = Math.abs(this.x);
        float abs2 = Math.abs(this.y);
        float abs3 = Math.abs(this.z);
        float abs4 = Math.abs(this.w);
        if (abs < abs2 && abs < abs3 && abs < abs4) {
            return 0;
        }
        if (abs2 >= abs3 || abs2 >= abs4) {
            return abs3 < abs4 ? 2 : 3;
        }
        return 1;
    }

    public Vector4f mul(Vector4fc vector4fc) {
        return mul(vector4fc, thisOrNew());
    }

    public Vector4f mulAffine(Matrix4fc matrix4fc, Vector4f vector4f) {
        float m30 = (matrix4fc.m30() * this.w) + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x);
        float m31 = (matrix4fc.m31() * this.w) + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x);
        float m22 = (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x);
        float m32 = matrix4fc.m32();
        float f2 = this.w;
        float f3 = (m32 * f2) + m22;
        vector4f.x = m30;
        vector4f.y = m31;
        vector4f.z = f3;
        vector4f.w = f2;
        return vector4f;
    }

    public Vector4f mulProject(Matrix4fc matrix4fc, Vector4f vector4f) {
        float h2 = a.h(matrix4fc.m33(), this.w, (matrix4fc.m23() * this.z) + (matrix4fc.m13() * this.y) + (matrix4fc.m03() * this.x), 1.0f);
        float m30 = (matrix4fc.m30() + (matrix4fc.m20() * this.z) + (matrix4fc.m10() * this.y) + (matrix4fc.m00() * this.x)) * h2;
        float m31 = (matrix4fc.m31() + (matrix4fc.m21() * this.z) + (matrix4fc.m11() * this.y) + (matrix4fc.m01() * this.x)) * h2;
        float m32 = (matrix4fc.m32() + (matrix4fc.m22() * this.z) + (matrix4fc.m12() * this.y) + (matrix4fc.m02() * this.x)) * h2;
        vector4f.x = m30;
        vector4f.y = m31;
        vector4f.z = m32;
        vector4f.w = 1.0f;
        return vector4f;
    }

    public Vector4f negate() {
        return negate(thisOrNew());
    }

    public Vector4f normalize() {
        return normalize(thisOrNew());
    }

    public Vector4f normalize3() {
        return normalize3(thisOrNew());
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readFloat();
        this.y = objectInput.readFloat();
        this.z = objectInput.readFloat();
        this.w = objectInput.readFloat();
    }

    public Vector4f rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, thisOrNew());
    }

    public Vector4f rotateAbout(float f2, float f3, float f4, float f5) {
        return rotateAxis(f2, f3, f4, f5, thisOrNew());
    }

    public Vector4f rotateAxis(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        Vector4f vector4f2 = vector4f;
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
        Vector4f vector4f3 = vector4f;
        vector4f3.x = f25;
        vector4f3.y = f28;
        vector4f3.z = f30;
        return vector4f3;
    }

    public Vector4f rotateX(float f2) {
        return rotateX(f2, thisOrNew());
    }

    public Vector4f rotateY(float f2) {
        return rotateY(f2, thisOrNew());
    }

    public Vector4f rotateZ(float f2) {
        return rotateZ(f2, thisOrNew());
    }

    public Vector4f round() {
        return round(thisOrNew());
    }

    public Vector4f set(Vector4fc vector4fc) {
        if (vector4fc instanceof Vector4f) {
            MemUtil.INSTANCE.copy((Vector4f) vector4fc, this);
        } else {
            this.x = vector4fc.x();
            this.y = vector4fc.y();
            this.z = vector4fc.z();
            this.w = vector4fc.w();
        }
        return this;
    }

    public Vector4f setComponent(int i2, float f2) throws IllegalArgumentException {
        if (i2 == 0) {
            this.x = f2;
        } else if (i2 == 1) {
            this.y = f2;
        } else if (i2 == 2) {
            this.z = f2;
        } else if (i2 == 3) {
            this.w = f2;
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Vector4f smoothStep(Vector4fc vector4fc, float f2, Vector4f vector4f) {
        float f3 = f2 * f2;
        float f4 = f3 * f2;
        float f5 = this.x;
        float x2 = (((f5 + f5) - vector4fc.x()) - vector4fc.x()) * f4;
        float x3 = vector4fc.x() * 3.0f;
        float f6 = this.x;
        vector4f.x = a.f(f6, f2, a.a(f6, 3.0f, x3, f3, x2), f6);
        float f7 = this.y;
        float y2 = (((f7 + f7) - vector4fc.y()) - vector4fc.y()) * f4;
        float y3 = vector4fc.y() * 3.0f;
        float f8 = this.y;
        vector4f.y = a.f(f8, f2, a.a(f8, 3.0f, y3, f3, y2), f8);
        float f9 = this.z;
        float z2 = (((f9 + f9) - vector4fc.z()) - vector4fc.z()) * f4;
        float z3 = vector4fc.z() * 3.0f;
        float f10 = this.z;
        vector4f.z = a.f(f10, f2, a.a(f10, 3.0f, z3, f3, z2), f10);
        float f11 = this.w;
        float w2 = (((f11 + f11) - vector4fc.w()) - vector4fc.w()) * f4;
        float w3 = vector4fc.w() * 3.0f;
        float f12 = this.w;
        vector4f.w = a.f(f2, f12, a.a(f12, 3.0f, w3, f3, w2), f12);
        return vector4f;
    }

    public Vector4f sub(Vector4fc vector4fc) {
        return sub(vector4fc, thisOrNew());
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public float w() {
        return this.w;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.x);
        objectOutput.writeFloat(this.y);
        objectOutput.writeFloat(this.z);
        objectOutput.writeFloat(this.w);
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

    public Vector4f zero() {
        Vector4f thisOrNew = thisOrNew();
        MemUtil.INSTANCE.zero(thisOrNew);
        return thisOrNew;
    }

    public static float length(float f2, float f3, float f4, float f5) {
        return (float) Math.sqrt((double) ((f5 * f5) + (f4 * f4) + (f3 * f3) + (f2 * f2)));
    }

    public Vector4f add(Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = vector4fc.x() + this.x;
        vector4f.y = vector4fc.y() + this.y;
        vector4f.z = vector4fc.z() + this.z;
        vector4f.w = vector4fc.w() + this.w;
        return vector4f;
    }

    public Vector4f ceil(Vector4f vector4f) {
        vector4f.x = Math.ceil(this.x);
        vector4f.y = Math.ceil(this.y);
        vector4f.z = Math.ceil(this.z);
        vector4f.w = Math.ceil(this.w);
        return vector4f;
    }

    public float distance(float f2, float f3, float f4, float f5) {
        return (float) Math.sqrt((double) distanceSquared(f2, f3, f4, f5));
    }

    public float distanceSquared(float f2, float f3, float f4, float f5) {
        float f6 = this.x - f2;
        float f7 = this.y - f3;
        float f8 = this.z - f4;
        float f9 = this.w - f5;
        return (f9 * f9) + (f8 * f8) + (f7 * f7) + (f6 * f6);
    }

    public Vector4f div(Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = this.x / vector4fc.x();
        vector4f.y = this.y / vector4fc.y();
        vector4f.z = this.z / vector4fc.z();
        vector4f.w = this.w / vector4fc.w();
        return vector4f;
    }

    public float dot(float f2, float f3, float f4, float f5) {
        return (this.w * f5) + (this.z * f4) + (this.y * f3) + (this.x * f2);
    }

    public Vector4f floor(Vector4f vector4f) {
        vector4f.x = Math.floor(this.x);
        vector4f.y = Math.floor(this.y);
        vector4f.z = Math.floor(this.z);
        vector4f.w = Math.floor(this.w);
        return vector4f;
    }

    public Vector4f fma(float f2, Vector4fc vector4fc) {
        return fma(f2, vector4fc, thisOrNew());
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Vector4f lerp(Vector4fc vector4fc, float f2, Vector4f vector4f) {
        vector4f.x = a.e(vector4fc.x(), this.x, f2, this.x);
        vector4f.y = a.e(vector4fc.y(), this.y, f2, this.y);
        vector4f.z = a.e(vector4fc.z(), this.z, f2, this.z);
        vector4f.w = a.e(vector4fc.w(), this.w, f2, this.w);
        return vector4f;
    }

    public Vector4f max(Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = this.x > vector4fc.x() ? this.x : vector4fc.x();
        vector4f.y = this.y > vector4fc.y() ? this.y : vector4fc.y();
        vector4f.z = this.z > vector4fc.z() ? this.z : vector4fc.z();
        vector4f.w = this.w > vector4fc.w() ? this.w : vector4fc.w();
        return vector4f;
    }

    public Vector4f min(Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = this.x < vector4fc.x() ? this.x : vector4fc.x();
        vector4f.y = this.y < vector4fc.y() ? this.y : vector4fc.y();
        vector4f.z = this.z < vector4fc.z() ? this.z : vector4fc.z();
        vector4f.w = this.w < vector4fc.w() ? this.w : vector4fc.w();
        return vector4f;
    }

    public Vector4f mul(Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = vector4fc.x() * this.x;
        vector4f.y = vector4fc.y() * this.y;
        vector4f.z = vector4fc.z() * this.z;
        vector4f.w = vector4fc.w() * this.w;
        return vector4f;
    }

    public Vector4f negate(Vector4f vector4f) {
        vector4f.x = -this.x;
        vector4f.y = -this.y;
        vector4f.z = -this.z;
        vector4f.w = -this.w;
        return vector4f;
    }

    public Vector4f normalize(Vector4f vector4f) {
        float length = 1.0f / length();
        vector4f.x = this.x * length;
        vector4f.y = this.y * length;
        vector4f.z = this.z * length;
        vector4f.w = this.w * length;
        return vector4f;
    }

    public Vector4f normalize3(Vector4f vector4f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f6 * f6) + f5)));
        vector4f.x = this.x * sqrt;
        vector4f.y = this.y * sqrt;
        vector4f.z = this.z * sqrt;
        vector4f.w = this.w * sqrt;
        return vector4f;
    }

    public Vector4f rotate(Quaternionfc quaternionfc, Vector4f vector4f) {
        return quaternionfc.transform((Vector4fc) this, vector4f);
    }

    public Vector4f rotateX(float f2, Vector4f vector4f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.y;
        float f4 = f3 * cosFromSin;
        float f5 = this.z;
        float f6 = f4 - (f5 * sin);
        float f7 = (f5 * cosFromSin) + (f3 * sin);
        vector4f.x = this.x;
        vector4f.y = f6;
        vector4f.z = f7;
        vector4f.w = this.w;
        return vector4f;
    }

    public Vector4f rotateY(float f2, Vector4f vector4f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.z;
        float f6 = (f5 * cosFromSin) + ((-f3) * sin);
        vector4f.x = (f5 * sin) + f4;
        vector4f.y = this.y;
        vector4f.z = f6;
        vector4f.w = this.w;
        return vector4f;
    }

    public Vector4f rotateZ(float f2, Vector4f vector4f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.y;
        float f6 = (f5 * cosFromSin) + (f3 * sin);
        vector4f.x = f4 - (f5 * sin);
        vector4f.y = f6;
        vector4f.z = this.z;
        vector4f.w = this.w;
        return vector4f;
    }

    public Vector4f round(Vector4f vector4f) {
        vector4f.x = (float) Math.round(this.x);
        vector4f.y = (float) Math.round(this.y);
        vector4f.z = (float) Math.round(this.z);
        vector4f.w = (float) Math.round(this.w);
        return vector4f;
    }

    public Vector4f sub(float f2, float f3, float f4, float f5) {
        return sub(f2, f3, f4, f5, thisOrNew());
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.x, a2, str);
        a.b(numberFormat, (double) this.y, a2, str);
        a.b(numberFormat, (double) this.z, a2, str);
        return a.a(numberFormat, (double) this.w, a2, ")");
    }

    public Vector4f(Vector4fc vector4fc) {
        if (vector4fc instanceof Vector4f) {
            MemUtil.INSTANCE.copy((Vector4f) vector4fc, this);
            return;
        }
        this.x = vector4fc.x();
        this.y = vector4fc.y();
        this.z = vector4fc.z();
        this.w = vector4fc.w();
    }

    public static float distance(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return (float) Math.sqrt((double) distanceSquared(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public Vector4f fma(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4f vector4f) {
        vector4f.x = (vector4fc2.x() * vector4fc.x()) + this.x;
        vector4f.y = (vector4fc2.y() * vector4fc.y()) + this.y;
        vector4f.z = (vector4fc2.z() * vector4fc.z()) + this.z;
        vector4f.w = (vector4fc2.w() * vector4fc.w()) + this.w;
        return vector4f;
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Vector4f sub(Vector4fc vector4fc, Vector4f vector4f) {
        return sub(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w(), vector4f);
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector4f sub(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = this.x - f2;
        vector4f.y = this.y - f3;
        vector4f.z = this.z - f4;
        vector4f.w = this.w - f5;
        return vector4f;
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
        if (i2 == 3) {
            return this.w;
        }
        throw new IllegalArgumentException();
    }

    public Vector4f add(float f2, float f3, float f4, float f5) {
        return add(f2, f3, f4, f5, thisOrNew());
    }

    public Vector4f div(float f2) {
        return div(f2, thisOrNew());
    }

    public Vector4f mul(Matrix4fc matrix4fc) {
        return mul(matrix4fc, thisOrNew());
    }

    public Vector4f add(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = this.x + f2;
        vector4f.y = this.y + f3;
        vector4f.z = this.z + f4;
        vector4f.w = this.w + f5;
        return vector4f;
    }

    public Vector4f div(float f2, Vector4f vector4f) {
        float f3 = 1.0f / f2;
        vector4f.x = this.x * f3;
        vector4f.y = this.y * f3;
        vector4f.z = this.z * f3;
        vector4f.w = this.w * f3;
        return vector4f;
    }

    public boolean equals(Vector4fc vector4fc, float f2) {
        if (this == vector4fc) {
            return true;
        }
        return vector4fc != null && Runtime.equals(this.x, vector4fc.x(), f2) && Runtime.equals(this.y, vector4fc.y(), f2) && Runtime.equals(this.z, vector4fc.z(), f2) && Runtime.equals(this.w, vector4fc.w(), f2);
    }

    public Vector4f fma(float f2, Vector4fc vector4fc, Vector4f vector4f) {
        vector4f.x = (vector4fc.x() * f2) + this.x;
        vector4f.y = (vector4fc.y() * f2) + this.y;
        vector4f.z = (vector4fc.z() * f2) + this.z;
        vector4f.w = (vector4fc.w() * f2) + this.w;
        return vector4f;
    }

    public Vector4f mul(Matrix4fc matrix4fc, Vector4f vector4f) {
        if ((matrix4fc.properties() & 2) != 0) {
            return mulAffine(matrix4fc, vector4f);
        }
        return mulGeneric(matrix4fc, vector4f);
    }

    public Vector4f normalize(float f2) {
        return normalize(f2, thisOrNew());
    }

    public Vector4f set(Vector4ic vector4ic) {
        return set((float) vector4ic.x(), (float) vector4ic.y(), (float) vector4ic.z(), (float) vector4ic.w());
    }

    public Vector4f normalize(float f2, Vector4f vector4f) {
        float length = (1.0f / length()) * f2;
        vector4f.x = this.x * length;
        vector4f.y = this.y * length;
        vector4f.z = this.z * length;
        vector4f.w = this.w * length;
        return vector4f;
    }

    public Vector4f set(Vector4dc vector4dc) {
        return set((float) vector4dc.x(), (float) vector4dc.y(), (float) vector4dc.z(), (float) vector4dc.w());
    }

    public Vector4f mulProject(Matrix4fc matrix4fc) {
        return mulProject(matrix4fc, thisOrNew());
    }

    public Vector4f set(Vector3fc vector3fc, float f2) {
        return set(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2);
    }

    public Vector4f(Vector4ic vector4ic) {
        this((float) vector4ic.x(), (float) vector4ic.y(), (float) vector4ic.z(), (float) vector4ic.w());
    }

    public Vector4f mul(Matrix4x3fc matrix4x3fc) {
        return mul(matrix4x3fc, thisOrNew());
    }

    public Vector4f set(Vector3ic vector3ic, float f2) {
        return set((float) vector3ic.x(), (float) vector3ic.y(), (float) vector3ic.z(), f2);
    }

    public Vector4f(Vector3fc vector3fc, float f2) {
        this(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2);
    }

    public Vector4f div(float f2, float f3, float f4, float f5) {
        return div(f2, f3, f4, f5, thisOrNew());
    }

    public boolean equals(float f2, float f3, float f4, float f5) {
        if (Float.floatToIntBits(this.x) == Float.floatToIntBits(f2) && Float.floatToIntBits(this.y) == Float.floatToIntBits(f3) && Float.floatToIntBits(this.z) == Float.floatToIntBits(f4) && Float.floatToIntBits(this.w) == Float.floatToIntBits(f5)) {
            return true;
        }
        return false;
    }

    public Vector4f mul(Matrix4x3fc matrix4x3fc, Vector4f vector4f) {
        float m30 = (matrix4x3fc.m30() * this.w) + (matrix4x3fc.m20() * this.z) + (matrix4x3fc.m10() * this.y) + (matrix4x3fc.m00() * this.x);
        float m31 = (matrix4x3fc.m31() * this.w) + (matrix4x3fc.m21() * this.z) + (matrix4x3fc.m11() * this.y) + (matrix4x3fc.m01() * this.x);
        float m22 = (matrix4x3fc.m22() * this.z) + (matrix4x3fc.m12() * this.y) + (matrix4x3fc.m02() * this.x);
        float m32 = matrix4x3fc.m32();
        float f2 = this.w;
        float f3 = (m32 * f2) + m22;
        vector4f.x = m30;
        vector4f.y = m31;
        vector4f.z = f3;
        vector4f.w = f2;
        return vector4f;
    }

    public Vector4f set(Vector2fc vector2fc, float f2, float f3) {
        return set(vector2fc.x(), vector2fc.y(), f2, f3);
    }

    public Vector4f(Vector3ic vector3ic, float f2) {
        this((float) vector3ic.x(), (float) vector3ic.y(), (float) vector3ic.z(), f2);
    }

    public Vector4f div(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = this.x / f2;
        vector4f.y = this.y / f3;
        vector4f.z = this.z / f4;
        vector4f.w = this.w / f5;
        return vector4f;
    }

    public Vector4f set(Vector2ic vector2ic, float f2, float f3) {
        return set((float) vector2ic.x(), (float) vector2ic.y(), f2, f3);
    }

    public Vector4f(Vector2fc vector2fc, float f2, float f3) {
        this(vector2fc.x(), vector2fc.y(), f2, f3);
    }

    public Vector4f set(float f2) {
        MemUtil.INSTANCE.broadcast(f2, this);
        return this;
    }

    public Vector4f(Vector2ic vector2ic, float f2, float f3) {
        this((float) vector2ic.x(), (float) vector2ic.y(), f2, f3);
    }

    public Vector4f set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Vector4f(float f2) {
        MemUtil.INSTANCE.broadcast(f2, this);
    }

    public Vector4f(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
    }

    public Vector4f mul(float f2) {
        return mul(f2, thisOrNew());
    }

    public Vector4f set(ByteBuffer byteBuffer) {
        return set(byteBuffer.position(), byteBuffer);
    }

    public Vector4f mul(float f2, Vector4f vector4f) {
        vector4f.x = this.x * f2;
        vector4f.y = this.y * f2;
        vector4f.z = this.z * f2;
        vector4f.w = this.w * f2;
        return vector4f;
    }

    public Vector4f set(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
        return this;
    }

    public Vector4f set(FloatBuffer floatBuffer) {
        return set(floatBuffer.position(), floatBuffer);
    }

    public Vector4f set(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
        return this;
    }

    public Vector4f(ByteBuffer byteBuffer) {
        this(byteBuffer.position(), byteBuffer);
    }

    public Vector4f(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, i2, byteBuffer);
    }

    public Vector4f mul(float f2, float f3, float f4, float f5) {
        return mul(f2, f3, f4, f5, thisOrNew());
    }

    public Vector4f mul(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = this.x * f2;
        vector4f.y = this.y * f3;
        vector4f.z = this.z * f4;
        vector4f.w = this.w * f5;
        return vector4f;
    }

    public Vector4f(FloatBuffer floatBuffer) {
        this(floatBuffer.position(), floatBuffer);
    }

    public Vector4f(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, i2, floatBuffer);
    }
}
