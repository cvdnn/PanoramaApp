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

public class Quaternionf implements Externalizable, Quaternionfc {
    public static final long serialVersionUID = 1;
    public float w;
    public float x;
    public float y;
    public float z;

    public Quaternionf() {
        this.w = 1.0f;
    }

    public static double clamp(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }

    private int getGimbalPole() {
        double d2 = (double) ((this.z * this.w) + (this.x * this.y));
        if (d2 > 0.49999d) {
            return 1;
        }
        return d2 < -0.49999d ? -1 : 0;
    }

    private void setFromNormalized(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f2 + f6;
        float f12 = f11 + f10;
        if (f12 >= 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f12 + 1.0f));
            this.w = sqrt * 0.5f;
            float f13 = 0.5f / sqrt;
            this.x = (f7 - f9) * f13;
            this.y = (f8 - f4) * f13;
            this.z = (f3 - f5) * f13;
        } else if (f2 >= f6 && f2 >= f10) {
            float sqrt2 = (float) Math.sqrt(((double) (f2 - (f6 + f10))) + 1.0d);
            this.x = sqrt2 * 0.5f;
            float f14 = 0.5f / sqrt2;
            this.y = (f5 + f3) * f14;
            this.z = (f4 + f8) * f14;
            this.w = (f7 - f9) * f14;
        } else if (f6 > f10) {
            float sqrt3 = (float) Math.sqrt(((double) (f6 - (f10 + f2))) + 1.0d);
            this.y = sqrt3 * 0.5f;
            float f15 = 0.5f / sqrt3;
            this.z = (f9 + f7) * f15;
            this.x = (f5 + f3) * f15;
            this.w = (f8 - f4) * f15;
        } else {
            float sqrt4 = (float) Math.sqrt(((double) (f10 - f11)) + 1.0d);
            this.z = sqrt4 * 0.5f;
            float f16 = 0.5f / sqrt4;
            this.x = (f4 + f8) * f16;
            this.y = (f9 + f7) * f16;
            this.w = (f3 - f5) * f16;
        }
    }

    private void setFromUnnormalized(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f7 * f7) + ((f6 * f6) + (f5 * f5)))));
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f10 * f10) + ((f9 * f9) + (f8 * f8)))));
        setFromNormalized(f2 * sqrt, f3 * sqrt, f4 * sqrt, f5 * sqrt2, f6 * sqrt2, f7 * sqrt2, f8 * sqrt3, f9 * sqrt3, f10 * sqrt3);
    }

    public Quaternionf add(float f2, float f3, float f4, float f5) {
        return add(f2, f3, f4, f5, this);
    }

    public float angle() {
        double acos = (double) ((float) (Math.acos((double) this.w) * 2.0d));
        if (acos > 3.141592653589793d) {
            acos = 6.283185307179586d - acos;
        }
        return (float) acos;
    }

    public Quaternionf conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Quaternionf difference(Quaternionf quaternionf) {
        return difference(quaternionf, this);
    }

    public Quaternionf div(Quaternionfc quaternionfc, Quaternionf quaternionf) {
        float w2 = 1.0f / ((quaternionfc.w() * quaternionfc.w()) + ((quaternionfc.z() * quaternionfc.z()) + ((quaternionfc.y() * quaternionfc.y()) + (quaternionfc.x() * quaternionfc.x()))));
        float f2 = (-quaternionfc.x()) * w2;
        float f3 = (-quaternionfc.y()) * w2;
        float f4 = (-quaternionfc.z()) * w2;
        float w3 = quaternionfc.w() * w2;
        float f5 = this.w;
        float f6 = f5 * f2;
        float f7 = this.x;
        float f8 = (f7 * w3) + f6;
        float f9 = this.y;
        float f10 = (f9 * f4) + f8;
        float f11 = this.z;
        quaternionf.set(f10 - (f11 * f3), (f11 * f2) + (f9 * w3) + ((f5 * f3) - (f7 * f4)), (f11 * w3) + (((f7 * f3) + (f5 * f4)) - (f9 * f2)), (((f5 * w3) - (f7 * f2)) - (f9 * f3)) - (f11 * f4));
        return quaternionf;
    }

    public float dot(Quaternionf quaternionf) {
        return (this.w * quaternionf.w) + (this.z * quaternionf.z) + (this.y * quaternionf.y) + (this.x * quaternionf.x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Quaternionf.class != obj.getClass()) {
            return false;
        }
        Quaternionf quaternionf = (Quaternionf) obj;
        return Float.floatToIntBits(this.w) == Float.floatToIntBits(quaternionf.w) && Float.floatToIntBits(this.x) == Float.floatToIntBits(quaternionf.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(quaternionf.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(quaternionf.z);
    }

    public Quaternionf fromAxisAngleDeg(Vector3fc vector3fc, float f2) {
        return fromAxisAngleRad(vector3fc.x(), vector3fc.y(), vector3fc.z(), (float) Math.toRadians((double) f2));
    }

    public Quaternionf fromAxisAngleRad(Vector3fc vector3fc, float f2) {
        return fromAxisAngleRad(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2);
    }

    public Matrix3f get(Matrix3f matrix3f) {
        return matrix3f.set((Quaternionfc) this);
    }

    public ByteBuffer getAsMatrix3f(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putMatrix3f(this, byteBuffer.position(), byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer getAsMatrix4f(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putMatrix4f(this, byteBuffer.position(), byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer getAsMatrix4x3f(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putMatrix4x3f(this, byteBuffer.position(), byteBuffer);
        return byteBuffer;
    }

    public Vector3f getEulerAnglesXYZ(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = this.w * f2;
        float f4 = this.y;
        vector3f.x = (float) Math.atan2(((double) (f3 - (this.z * f4))) * 2.0d, 1.0d - (((double) ((f4 * f4) + (f2 * f2))) * 2.0d));
        vector3f.y = (float) Math.asin(((double) ((this.y * this.w) + (this.x * this.z))) * 2.0d);
        float f5 = this.z;
        float f6 = this.w * f5;
        float f7 = this.x;
        float f8 = this.y;
        vector3f.z = (float) Math.atan2(((double) (f6 - (f7 * f8))) * 2.0d, 1.0d - (((double) ((f5 * f5) + (f8 * f8))) * 2.0d));
        return vector3f;
    }

    public Vector3f getEulerAnglesYXZ(Vector3f vector3f) {
        double d2;
        double d3;
        int gimbalPole = getGimbalPole();
        if (gimbalPole == 0) {
            float f2 = this.y;
            float f3 = this.w * f2;
            float f4 = this.x;
            d2 = Math.atan2(((double) ((this.z * f4) + f3)) * 2.0d, 1.0d - (((double) ((f4 * f4) + (f2 * f2))) * 2.0d));
        } else {
            d2 = 0.0d;
        }
        vector3f.y = (float) d2;
        vector3f.x = (float) (gimbalPole == 0 ? Math.asin(clamp(((double) ((this.w * this.x) - (this.z * this.y))) * 2.0d, -1.0d, 1.0d)) : ((double) gimbalPole) * 2.0d * Math.atan2((double) this.y, (double) this.w));
        if (gimbalPole == 0) {
            float f5 = this.w;
            float f6 = this.z;
            float f7 = f5 * f6;
            float f8 = this.y;
            float f9 = this.x;
            d3 = Math.atan2(((double) ((f8 * f9) + f7)) * 2.0d, 1.0d - (((double) ((f6 * f6) + (f9 * f9))) * 2.0d));
        } else {
            d3 = ((double) gimbalPole) * 1.5707963267948966d;
        }
        vector3f.z = (float) d3;
        return vector3f;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.z) + a.a(this.y, a.a(this.x, a.a(this.w, 31, 31), 31), 31);
    }

    public Quaternionf identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Quaternionf integrate(float f2, float f3, float f4, float f5) {
        return integrate(f2, f3, f4, f5, this);
    }

    public Quaternionf invert(Quaternionf quaternionf) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float h2 = a.h(f8, f8, f7, 1.0f);
        quaternionf.x = (-f2) * h2;
        quaternionf.y = (-f4) * h2;
        quaternionf.z = (-f6) * h2;
        quaternionf.w = f8 * h2;
        return quaternionf;
    }

    public float lengthSquared() {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        return (f8 * f8) + f7;
    }

    public Quaternionf lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public Quaternionf mul(Quaternionfc quaternionfc) {
        return mul(quaternionfc, this);
    }

    public Quaternionf nlerp(Quaternionfc quaternionfc, float f2) {
        return nlerp(quaternionfc, f2, this);
    }

    public Quaternionf nlerpIterative(Quaternionfc quaternionfc, float f2, float f3, Quaternionf quaternionf) {
        Quaternionf quaternionf2 = quaternionf;
        float f4 = this.x;
        float f5 = this.y;
        float f6 = this.z;
        float f7 = this.w;
        float x2 = quaternionfc.x();
        float y2 = quaternionfc.y();
        float z2 = quaternionfc.z();
        float w2 = quaternionfc.w();
        float f8 = (f7 * w2) + (f6 * z2) + (f5 * y2) + (f4 * x2);
        float abs = Math.abs(f8);
        if (0.999999f < abs) {
            return quaternionf2.set((Quaternionfc) this);
        }
        float f9 = f8;
        float f10 = abs;
        float f11 = w2;
        float f12 = z2;
        float f13 = y2;
        float f14 = x2;
        float f15 = f7;
        float f16 = f6;
        float f17 = f5;
        float f18 = f4;
        float f19 = f2;
        while (f10 < f3) {
            float f20 = f9 >= 0.0f ? 0.5f : -0.5f;
            if (f19 < 0.5f) {
                float f21 = (f20 * f18) + (f14 * 0.5f);
                float f22 = (f20 * f17) + (f13 * 0.5f);
                float f23 = (f20 * f16) + (f12 * 0.5f);
                float f24 = (f20 * f15) + (f11 * 0.5f);
                float sqrt = (float) (1.0d / Math.sqrt((double) ((f24 * f24) + ((f23 * f23) + ((f22 * f22) + (f21 * f21))))));
                float f25 = f21 * sqrt;
                float f26 = f22 * sqrt;
                float f27 = f24 * sqrt;
                f19 += f19;
                f12 = f23 * sqrt;
                f11 = f27;
                f13 = f26;
                f14 = f25;
            } else {
                float f28 = (f20 * f14) + (f18 * 0.5f);
                float f29 = (f20 * f13) + (f17 * 0.5f);
                float f30 = (f20 * f12) + (f16 * 0.5f);
                float f31 = (f20 * f11) + (f15 * 0.5f);
                float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f31 * f31) + ((f30 * f30) + ((f29 * f29) + (f28 * f28))))));
                float f32 = f28 * sqrt2;
                float f33 = f29 * sqrt2;
                float f34 = f31 * sqrt2;
                f19 = (f19 + f19) - 1.0f;
                f16 = f30 * sqrt2;
                f15 = f34;
                f17 = f33;
                f18 = f32;
            }
            f9 = (f15 * f11) + (f16 * f12) + (f17 * f13) + (f18 * f14);
            f10 = Math.abs(f9);
        }
        float f35 = 1.0f - f19;
        if (f9 < 0.0f) {
            f19 = -f19;
        }
        float f36 = (f14 * f19) + (f18 * f35);
        float f37 = (f13 * f19) + (f17 * f35);
        float f38 = (f12 * f19) + (f16 * f35);
        float f39 = (f19 * f11) + (f35 * f15);
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f39 * f39) + ((f38 * f38) + ((f37 * f37) + (f36 * f36))))));
        quaternionf2.x = f36 * sqrt3;
        quaternionf2.y = f37 * sqrt3;
        quaternionf2.z = f38 * sqrt3;
        quaternionf2.w = f39 * sqrt3;
        return quaternionf2;
    }

    public Quaternionf normalize() {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f8 * f8) + f7)));
        this.x *= sqrt;
        this.y *= sqrt;
        this.z *= sqrt;
        this.w *= sqrt;
        return this;
    }

    public Vector3f normalizedPositiveX(Vector3f vector3f) {
        float f2 = this.y;
        float f3 = f2 + f2;
        float f4 = this.z;
        float f5 = f4 + f4;
        vector3f.x = (((-f2) * f3) - (f4 * f5)) + 1.0f;
        float f6 = this.x;
        float f7 = f6 * f3;
        float f8 = this.w;
        vector3f.y = f7 - (f8 * f5);
        vector3f.z = (f8 * f3) + (f6 * f5);
        return vector3f;
    }

    public Vector3f normalizedPositiveY(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 + f2;
        float f4 = this.y;
        float f5 = f4 + f4;
        float f6 = this.z;
        float f7 = f6 + f6;
        float f8 = f5 * f2;
        float f9 = this.w;
        vector3f.x = (f9 * f7) + f8;
        vector3f.y = (((-f2) * f3) - (f6 * f7)) + 1.0f;
        vector3f.z = (f4 * f7) - (f9 * f3);
        return vector3f;
    }

    public Vector3f normalizedPositiveZ(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 + f2;
        float f4 = this.y;
        float f5 = f4 + f4;
        float f6 = this.z;
        float f7 = f6 + f6;
        float f8 = f2 * f7;
        float f9 = this.w;
        vector3f.x = f8 - (f9 * f5);
        vector3f.y = (f9 * f3) + (f7 * f4);
        vector3f.z = (((-f2) * f3) - (f4 * f5)) + 1.0f;
        return vector3f;
    }

    public Vector3f positiveX(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float h2 = a.h(f8, f8, f7, 1.0f);
        float f9 = (-f2) * h2;
        float f10 = (-f4) * h2;
        float f11 = (-f6) * h2;
        float f12 = f8 * h2;
        float f13 = f10 + f10;
        float f14 = f11 + f11;
        vector3f.x = (((-f10) * f13) - (f11 * f14)) + 1.0f;
        vector3f.y = (f12 * f14) + (f9 * f13);
        vector3f.z = (f9 * f14) - (f12 * f13);
        return vector3f;
    }

    public Vector3f positiveY(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float h2 = a.h(f8, f8, f7, 1.0f);
        float f9 = (-f2) * h2;
        float f10 = (-f4) * h2;
        float f11 = (-f6) * h2;
        float f12 = f8 * h2;
        float f13 = f9 + f9;
        float f14 = f11 + f11;
        vector3f.x = ((f10 + f10) * f9) - (f12 * f14);
        vector3f.y = (((-f9) * f13) - (f11 * f14)) + 1.0f;
        vector3f.z = (f12 * f13) + (f10 * f14);
        return vector3f;
    }

    public Vector3f positiveZ(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float h2 = a.h(f8, f8, f7, 1.0f);
        float f9 = (-f2) * h2;
        float f10 = (-f4) * h2;
        float f11 = (-f6) * h2;
        float f12 = f8 * h2;
        float f13 = f9 + f9;
        float f14 = f10 + f10;
        float f15 = f11 + f11;
        vector3f.x = (f12 * f14) + (f9 * f15);
        vector3f.y = (f15 * f10) - (f12 * f13);
        vector3f.z = (((-f9) * f13) - (f10 * f14)) + 1.0f;
        return vector3f;
    }

    public Quaternionf premul(Quaternionfc quaternionfc) {
        return premul(quaternionfc, this);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.x = objectInput.readFloat();
        this.y = objectInput.readFloat();
        this.z = objectInput.readFloat();
        this.w = objectInput.readFloat();
    }

    public Quaternionf rotateAxis(float f2, float f3, float f4, float f5, Quaternionf quaternionf) {
        float f6 = f3;
        float f7 = f4;
        float f8 = f5;
        Quaternionf quaternionf2 = quaternionf;
        double d2 = ((double) f2) / 2.0d;
        double sin = Math.sin(d2);
        double sqrt = 1.0d / Math.sqrt((double) ((f8 * f8) + ((f7 * f7) + (f6 * f6))));
        double d3 = ((double) f6) * sqrt * sin;
        double d4 = ((double) f7) * sqrt * sin;
        double d5 = ((double) f8) * sqrt * sin;
        double cosFromSin = Math.cosFromSin(sin, d2);
        float f9 = this.w;
        double d6 = ((double) f9) * d3;
        float f10 = this.x;
        double d7 = (((double) f10) * cosFromSin) + d6;
        float f11 = this.y;
        double d8 = d3;
        double d9 = (((double) f11) * d5) + d7;
        float f12 = this.z;
        float f13 = (float) (d9 - (((double) f12) * d4));
        float f14 = (float) ((((double) f12) * d8) + (((double) f11) * cosFromSin) + ((((double) f9) * d4) - (((double) f10) * d5)));
        double d10 = ((((double) f10) * d4) + (((double) f9) * d5)) - (((double) f11) * d8);
        quaternionf2.set(f13, f14, (float) ((((double) f12) * cosFromSin) + d10), (float) ((((((double) f9) * cosFromSin) - (((double) f10) * d8)) - (((double) f11) * d4)) - (((double) f12) * d5)));
        return quaternionf2;
    }

    public Quaternionf rotateLocalX(float f2) {
        return rotateLocalX(f2, this);
    }

    public Quaternionf rotateLocalY(float f2) {
        return rotateLocalY(f2, this);
    }

    public Quaternionf rotateLocalZ(float f2) {
        return rotateLocalZ(f2, this);
    }

    public Quaternionf rotateTo(float f2, float f3, float f4, float f5, float f6, float f7, Quaternionf quaternionf) {
        float f8 = (f3 * f7) - (f4 * f6);
        float f9 = (f4 * f5) - (f2 * f7);
        float f10 = (f2 * f6) - (f3 * f5);
        float f11 = f6 * f6;
        float f12 = f7 * f7;
        float f13 = (f3 * f6) + (f2 * f5);
        float f14 = a.f(f4, f7, f13, (float) Math.sqrt((double) (((f5 * f5) + f11 + f12) * ((f4 * f4) + (f3 * f3) + (f2 * f2)))));
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f14 * f14) + ((f10 * f10) + ((f9 * f9) + (f8 * f8))))));
        if (Float.isInfinite(sqrt)) {
            float f15 = -f5;
            sqrt = (float) (1.0d / Math.sqrt((double) ((f15 * f15) + f11)));
            if (Float.isInfinite(sqrt)) {
                f10 = -f6;
                sqrt = (float) (1.0d / Math.sqrt((double) ((f10 * f10) + f12)));
                f14 = 0.0f;
                f6 = 0.0f;
            } else {
                f7 = f15;
                f14 = 0.0f;
                f10 = 0.0f;
            }
        } else {
            f6 = f8;
            f7 = f9;
        }
        float f16 = f6 * sqrt;
        float f17 = f7 * sqrt;
        float f18 = f10 * sqrt;
        float f19 = f14 * sqrt;
        float f20 = this.w;
        float f21 = f20 * f16;
        float f22 = this.x;
        float f23 = (f22 * f19) + f21;
        float f24 = this.y;
        float f25 = (f24 * f18) + f23;
        float f26 = this.z;
        quaternionf.set(f25 - (f26 * f17), (f26 * f16) + (f24 * f19) + ((f20 * f17) - (f22 * f18)), (f26 * f19) + (((f22 * f17) + (f20 * f18)) - (f24 * f16)), (((f20 * f19) - (f22 * f16)) - (f24 * f17)) - (f26 * f18));
        return quaternionf;
    }

    public Quaternionf rotateX(float f2) {
        return rotateX(f2, this);
    }

    public Quaternionf rotateXYZ(float f2, float f3, float f4) {
        return rotateXYZ(f2, f3, f4, this);
    }

    public Quaternionf rotateY(float f2) {
        return rotateY(f2, this);
    }

    public Quaternionf rotateYXZ(float f2, float f3, float f4) {
        return rotateYXZ(f2, f3, f4, this);
    }

    public Quaternionf rotateZ(float f2) {
        return rotateZ(f2, this);
    }

    public Quaternionf rotateZYX(float f2, float f3, float f4) {
        return rotateZYX(f2, f3, f4, this);
    }

    public Quaternionf rotationAxis(AxisAngle4f axisAngle4f) {
        return rotationAxis(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Quaternionf rotationTo(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.x = (f3 * f7) - (f4 * f6);
        this.y = (f4 * f5) - (f2 * f7);
        this.z = (f2 * f6) - (f3 * f5);
        float f8 = (f3 * f6) + (f2 * f5);
        float f9 = a.f(f4, f7, f8, (float) Math.sqrt((double) a.g(f7, f7, (f6 * f6) + (f5 * f5), (f4 * f4) + (f3 * f3) + (f2 * f2))));
        this.w = f9;
        float f10 = this.x;
        float f11 = f10 * f10;
        float f12 = this.y;
        float f13 = (f12 * f12) + f11;
        float f14 = this.z;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f9 * f9) + ((f14 * f14) + f13))));
        if (Float.isInfinite(sqrt)) {
            this.x = f6;
            float f15 = -f5;
            this.y = f15;
            this.z = 0.0f;
            this.w = 0.0f;
            sqrt = (float) (1.0d / Math.sqrt((double) ((f15 * f15) + (f6 * f6))));
            if (Float.isInfinite(sqrt)) {
                this.x = 0.0f;
                this.y = f7;
                float f16 = -f6;
                this.z = f16;
                this.w = 0.0f;
                sqrt = (float) (1.0d / Math.sqrt((double) ((f16 * f16) + (f7 * f7))));
            }
        }
        this.x *= sqrt;
        this.y *= sqrt;
        this.z *= sqrt;
        this.w *= sqrt;
        return this;
    }

    public Quaternionf rotationX(float f2) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        this.w = (float) Math.cosFromSin((double) sin, d2);
        this.x = sin;
        this.y = 0.0f;
        this.z = 0.0f;
        return this;
    }

    public Quaternionf rotationXYZ(float f2, float f3, float f4) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f3) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f4) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * cosFromSin3;
        float f6 = sin2 * sin3;
        float f7 = sin2 * cosFromSin3;
        float f8 = cosFromSin2 * sin3;
        this.w = (cosFromSin * f5) - (sin * f6);
        this.x = (f6 * cosFromSin) + (f5 * sin);
        this.y = (cosFromSin * f7) - (sin * f8);
        this.z = (sin * f7) + (cosFromSin * f8);
        return this;
    }

    public Quaternionf rotationY(float f2) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        this.w = (float) Math.cosFromSin((double) sin, d2);
        this.x = 0.0f;
        this.y = sin;
        this.z = 0.0f;
        return this;
    }

    public Quaternionf rotationYXZ(float f2, float f3, float f4) {
        double d2 = ((double) f3) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f2) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f4) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * sin;
        float f6 = sin2 * cosFromSin;
        float f7 = sin2 * sin;
        float f8 = cosFromSin2 * cosFromSin;
        this.x = (f6 * sin3) + (f5 * cosFromSin3);
        this.y = (f6 * cosFromSin3) - (f5 * sin3);
        this.z = (f8 * sin3) - (f7 * cosFromSin3);
        this.w = (f7 * sin3) + (f8 * cosFromSin3);
        return this;
    }

    public Quaternionf rotationZ(float f2) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        this.w = (float) Math.cosFromSin((double) sin, d2);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = sin;
        return this;
    }

    public Quaternionf rotationZYX(float f2, float f3, float f4) {
        double d2 = ((double) f4) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f3) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f2) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * cosFromSin3;
        float f6 = sin2 * sin3;
        float f7 = sin2 * cosFromSin3;
        float f8 = cosFromSin2 * sin3;
        this.w = (sin * f6) + (cosFromSin * f5);
        this.x = (f5 * sin) - (f6 * cosFromSin);
        this.y = (sin * f8) + (cosFromSin * f7);
        this.z = (cosFromSin * f8) - (sin * f7);
        return this;
    }

    public Quaternionf scale(float f2) {
        return scale(f2, this);
    }

    public Quaternionf scaling(float f2) {
        float sqrt = (float) Math.sqrt((double) f2);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = sqrt;
        return this;
    }

    public Quaternionf set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Quaternionf setAngleAxis(float f2, float f3, float f4, float f5) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        this.x = f3 * sin;
        this.y = f4 * sin;
        this.z = f5 * sin;
        this.w = (float) Math.cosFromSin((double) sin, d2);
        return this;
    }

    public Quaternionf setLookAtCompat(Vector3fc vector3fc) {
        setFromNormalized((Matrix3fc) new Matrix3f().setLookAtCompat(vector3fc));
        return this;
    }

    public Quaternionf slerp(Quaternionfc quaternionfc, float f2) {
        return slerp(quaternionfc, f2, this);
    }

    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    public Vector3f transform(Vector3f vector3f) {
        return transform(vector3f.x, vector3f.y, vector3f.z, vector3f);
    }

    public Vector3f transformPositiveX(Vector3f vector3f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f2;
        float f10 = f4 * f6;
        float f11 = f4 * f8;
        float f12 = f6 * f2;
        vector3f.x = a.b(f3, f5, f8 * f8, f7);
        vector3f.y = a.a(f10, f9, f9, f10);
        vector3f.z = a.c(f11, f12, f11, f12);
        return vector3f;
    }

    public Vector3f transformPositiveY(Vector3f vector3f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f8;
        float f10 = f8 * f2;
        float f11 = f4 * f6;
        float f12 = f6 * f8;
        float f13 = f4 * f2;
        vector3f.x = (((-f10) + f11) - f10) + f11;
        vector3f.y = a.c(f7, f9, f3, f5);
        vector3f.z = a.a(f12, f12, f13, f13);
        return vector3f;
    }

    public Vector3f transformPositiveZ(Vector3f vector3f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f8;
        float f10 = f4 * f8;
        float f11 = f6 * f2;
        float f12 = f6 * f8;
        float f13 = f4 * f2;
        vector3f.x = a.a(f11, f10, f10, f11);
        vector3f.y = a.b(f12, f12, f13, f13);
        vector3f.z = a.d(f9, f7, f5, f3);
        return vector3f;
    }

    public Vector3f transformUnitPositiveX(Vector3f vector3f) {
        float f2 = this.y;
        float f3 = f2 * f2;
        float f4 = this.z;
        float f5 = f4 * f4;
        float f6 = this.x;
        float f7 = f6 * f2;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector3f.x = (((1.0f - f3) - f3) - f5) - f5;
        vector3f.y = a.a(f7, f11, f7, f11);
        vector3f.z = a.c(f8, f10, f8, f10);
        return vector3f;
    }

    public Vector4f transformUnitPositiveY(Vector4f vector4f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.z;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f2 * f6;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector4f.x = a.c(f7, f11, f7, f11);
        vector4f.y = (((1.0f - f3) - f3) - f5) - f5;
        vector4f.z = a.a(f8, f8, f10, f10);
        return vector4f;
    }

    public Vector4f transformUnitPositiveZ(Vector4f vector4f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = f4 * f4;
        float f6 = this.z;
        float f7 = f2 * f6;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector4f.x = a.a(f7, f11, f7, f11);
        vector4f.y = a.b(f8, f8, f10, f10);
        vector4f.z = (((1.0f - f3) - f3) - f5) - f5;
        return vector4f;
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

    public Quaternionf add(float f2, float f3, float f4, float f5, Quaternionf quaternionf) {
        quaternionf.x = this.x + f2;
        quaternionf.y = this.y + f3;
        quaternionf.z = this.z + f4;
        quaternionf.w = this.w + f5;
        return quaternionf;
    }

    public Quaternionf difference(Quaternionf quaternionf, Quaternionf quaternionf2) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float h2 = a.h(f8, f8, f7, 1.0f);
        float f9 = (-f2) * h2;
        float f10 = (-f4) * h2;
        float f11 = (-f6) * h2;
        float f12 = f8 * h2;
        float f13 = quaternionf.x;
        float f14 = f12 * f13;
        float f15 = quaternionf.w;
        float f16 = (f9 * f15) + f14;
        float f17 = quaternionf.z;
        float f18 = (f10 * f17) + f16;
        float f19 = quaternionf.y;
        quaternionf2.set(f18 - (f11 * f19), (f11 * f13) + (f10 * f15) + ((f12 * f19) - (f9 * f17)), (f11 * f15) + (((f9 * f19) + (f12 * f17)) - (f10 * f13)), (((f12 * f15) - (f9 * f13)) - (f10 * f19)) - (f11 * f17));
        return quaternionf2;
    }

    public Quaternionf fromAxisAngleDeg(float f2, float f3, float f4, float f5) {
        return fromAxisAngleRad(f2, f3, f4, (float) Math.toRadians((double) f5));
    }

    public Quaternionf fromAxisAngleRad(float f2, float f3, float f4, float f5) {
        double d2 = (double) (f5 / 2.0f);
        float sin = (float) Math.sin(d2);
        float sqrt = (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3) + (f2 * f2)));
        this.x = (f2 / sqrt) * sin;
        this.y = (f3 / sqrt) * sin;
        this.z = (f4 / sqrt) * sin;
        this.w = (float) Math.cosFromSin((double) sin, d2);
        return this;
    }

    public Matrix3d get(Matrix3d matrix3d) {
        return matrix3d.set((Quaternionfc) this);
    }

    public FloatBuffer getAsMatrix3f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putMatrix3f(this, floatBuffer.position(), floatBuffer);
        return floatBuffer;
    }

    public FloatBuffer getAsMatrix4f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putMatrix4f(this, floatBuffer.position(), floatBuffer);
        return floatBuffer;
    }

    public FloatBuffer getAsMatrix4x3f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putMatrix4x3f(this, floatBuffer.position(), floatBuffer);
        return floatBuffer;
    }

    public Quaternionf integrate(float f2, float f3, float f4, float f5, Quaternionf quaternionf) {
        float f6;
        float f7;
        float f8 = f3 * f2 * 0.5f;
        float f9 = f4 * f2 * 0.5f;
        float f10 = f2 * f5 * 0.5f;
        float f11 = (f10 * f10) + (f9 * f9) + (f8 * f8);
        if ((f11 * f11) / 24.0f < 1.0E-8f) {
            f7 = 1.0f - (0.5f * f11);
            f6 = 1.0f - (f11 / 6.0f);
        } else {
            float sqrt = (float) Math.sqrt((double) f11);
            double d2 = (double) sqrt;
            float sin = (float) Math.sin(d2);
            f7 = (float) Math.cosFromSin((double) sin, d2);
            f6 = sin / sqrt;
        }
        float f12 = f8 * f6;
        float f13 = f9 * f6;
        float f14 = f10 * f6;
        float f15 = this.x;
        float f16 = f7 * f15;
        float f17 = this.w;
        float f18 = (f12 * f17) + f16;
        float f19 = this.z;
        float f20 = (f13 * f19) + f18;
        float f21 = this.y;
        quaternionf.set(f20 - (f14 * f21), (f14 * f15) + (f13 * f17) + ((f7 * f21) - (f12 * f19)), (f14 * f17) + (((f12 * f21) + (f7 * f19)) - (f13 * f15)), (((f7 * f17) - (f12 * f15)) - (f13 * f21)) - (f14 * f19));
        return quaternionf;
    }

    public Quaternionf lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Quaternionf quaternionf) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), quaternionf);
    }

    public Quaternionf mul(Quaternionfc quaternionfc, Quaternionf quaternionf) {
        quaternionf.set(((quaternionfc.z() * this.y) + ((quaternionfc.w() * this.x) + (quaternionfc.x() * this.w))) - (quaternionfc.y() * this.z), (quaternionfc.x() * this.z) + (quaternionfc.w() * this.y) + ((quaternionfc.y() * this.w) - (quaternionfc.z() * this.x)), (quaternionfc.w() * this.z) + (((quaternionfc.y() * this.x) + (quaternionfc.z() * this.w)) - (quaternionfc.x() * this.y)), (((quaternionfc.w() * this.w) - (quaternionfc.x() * this.x)) - (quaternionfc.y() * this.y)) - (quaternionfc.z() * this.z));
        return quaternionf;
    }

    public Quaternionf nlerp(Quaternionfc quaternionfc, float f2, Quaternionf quaternionf) {
        float f3 = 1.0f - f2;
        if ((quaternionfc.w() * this.w) + (quaternionfc.z() * this.z) + (quaternionfc.y() * this.y) + (quaternionfc.x() * this.x) < 0.0f) {
            f2 = -f2;
        }
        quaternionf.x = (quaternionfc.x() * f2) + (this.x * f3);
        quaternionf.y = (quaternionfc.y() * f2) + (this.y * f3);
        quaternionf.z = (quaternionfc.z() * f2) + (this.z * f3);
        float w2 = (quaternionfc.w() * f2) + (f3 * this.w);
        quaternionf.w = w2;
        float f4 = quaternionf.x;
        float f5 = f4 * f4;
        float f6 = quaternionf.y;
        float f7 = (f6 * f6) + f5;
        float f8 = quaternionf.z;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((w2 * w2) + ((f8 * f8) + f7))));
        quaternionf.x *= sqrt;
        quaternionf.y *= sqrt;
        quaternionf.z *= sqrt;
        quaternionf.w *= sqrt;
        return quaternionf;
    }

    public Quaternionf premul(Quaternionfc quaternionfc, Quaternionf quaternionf) {
        quaternionf.set(((quaternionfc.y() * this.z) + ((quaternionfc.x() * this.w) + (quaternionfc.w() * this.x))) - (quaternionfc.z() * this.y), (quaternionfc.z() * this.x) + (quaternionfc.y() * this.w) + ((quaternionfc.w() * this.y) - (quaternionfc.x() * this.z)), (quaternionfc.z() * this.w) + (((quaternionfc.x() * this.y) + (quaternionfc.w() * this.z)) - (quaternionfc.y() * this.x)), (((quaternionfc.w() * this.w) - (quaternionfc.x() * this.x)) - (quaternionfc.y() * this.y)) - (quaternionfc.z() * this.z));
        return quaternionf;
    }

    public Quaternionf rotateLocalX(float f2, Quaternionf quaternionf) {
        double d2 = (double) (f2 * 0.5f);
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = cosFromSin * f3;
        float f5 = this.w;
        float f6 = (sin * f5) + f4;
        float f7 = this.y;
        float f8 = cosFromSin * f7;
        float f9 = this.z;
        quaternionf.set(f6, f8 - (sin * f9), (f7 * sin) + (f9 * cosFromSin), (cosFromSin * f5) - (sin * f3));
        return quaternionf;
    }

    public Quaternionf rotateLocalY(float f2, Quaternionf quaternionf) {
        double d2 = (double) (f2 * 0.5f);
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = cosFromSin * f3;
        float f5 = this.z;
        float f6 = (sin * f5) + f4;
        float f7 = this.y;
        float f8 = cosFromSin * f7;
        float f9 = this.w;
        quaternionf.set(f6, (sin * f9) + f8, (f5 * cosFromSin) - (f3 * sin), (cosFromSin * f9) - (sin * f7));
        return quaternionf;
    }

    public Quaternionf rotateLocalZ(float f2, Quaternionf quaternionf) {
        double d2 = (double) (f2 * 0.5f);
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = cosFromSin * f3;
        float f5 = this.y;
        float f6 = f4 - (sin * f5);
        float f7 = (f3 * sin) + (f5 * cosFromSin);
        float f8 = this.z;
        float f9 = cosFromSin * f8;
        float f10 = this.w;
        quaternionf.set(f6, f7, (sin * f10) + f9, (cosFromSin * f10) - (sin * f8));
        return quaternionf;
    }

    public Quaternionf rotateX(float f2, Quaternionf quaternionf) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.w;
        float f4 = f3 * sin;
        float f5 = this.x;
        float f6 = (f5 * cosFromSin) + f4;
        float f7 = this.y;
        float f8 = f7 * cosFromSin;
        float f9 = this.z;
        quaternionf.set(f6, (f9 * sin) + f8, (f9 * cosFromSin) - (f7 * sin), (f3 * cosFromSin) - (f5 * sin));
        return quaternionf;
    }

    public Quaternionf rotateXYZ(float f2, float f3, float f4, Quaternionf quaternionf) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f3) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f4) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * cosFromSin3;
        float f6 = sin2 * sin3;
        float f7 = sin2 * cosFromSin3;
        float f8 = cosFromSin2 * sin3;
        float f9 = (cosFromSin * f5) - (sin * f6);
        float f10 = (f6 * cosFromSin) + (f5 * sin);
        float f11 = (cosFromSin * f7) - (sin * f8);
        float f12 = (sin * f7) + (cosFromSin * f8);
        float f13 = this.w;
        float f14 = f13 * f10;
        float f15 = this.x;
        float f16 = (f15 * f9) + f14;
        float f17 = this.y;
        float f18 = (f17 * f12) + f16;
        float f19 = this.z;
        quaternionf.set(f18 - (f19 * f11), (f19 * f10) + (f17 * f9) + ((f13 * f11) - (f15 * f12)), (f19 * f9) + (((f15 * f11) + (f13 * f12)) - (f17 * f10)), (((f13 * f9) - (f15 * f10)) - (f17 * f11)) - (f19 * f12));
        return quaternionf;
    }

    public Quaternionf rotateY(float f2, Quaternionf quaternionf) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.z;
        float f6 = f4 - (f5 * sin);
        float f7 = this.w;
        float f8 = f7 * sin;
        float f9 = this.y;
        quaternionf.set(f6, (f9 * cosFromSin) + f8, (f5 * cosFromSin) + (f3 * sin), (f7 * cosFromSin) - (f9 * sin));
        return quaternionf;
    }

    public Quaternionf rotateYXZ(float f2, float f3, float f4, Quaternionf quaternionf) {
        double d2 = ((double) f3) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f2) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f4) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * sin;
        float f6 = sin2 * cosFromSin;
        float f7 = sin2 * sin;
        float f8 = cosFromSin2 * cosFromSin;
        float f9 = (f6 * sin3) + (f5 * cosFromSin3);
        float f10 = (f6 * cosFromSin3) - (f5 * sin3);
        float f11 = (f8 * sin3) - (f7 * cosFromSin3);
        float f12 = (f7 * sin3) + (f8 * cosFromSin3);
        float f13 = this.w;
        float f14 = f13 * f9;
        float f15 = this.x;
        float f16 = (f15 * f12) + f14;
        float f17 = this.y;
        float f18 = (f17 * f11) + f16;
        float f19 = this.z;
        quaternionf.set(f18 - (f19 * f10), (f19 * f9) + (f17 * f12) + ((f13 * f10) - (f15 * f11)), (f19 * f12) + (((f15 * f10) + (f13 * f11)) - (f17 * f9)), (((f13 * f12) - (f15 * f9)) - (f17 * f10)) - (f19 * f11));
        return quaternionf;
    }

    public Quaternionf rotateZ(float f2, Quaternionf quaternionf) {
        double d2 = ((double) f2) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = this.x;
        float f4 = f3 * cosFromSin;
        float f5 = this.y;
        float f6 = (f5 * sin) + f4;
        float f7 = (f5 * cosFromSin) - (f3 * sin);
        float f8 = this.w;
        float f9 = f8 * sin;
        float f10 = this.z;
        quaternionf.set(f6, f7, (f10 * cosFromSin) + f9, (f8 * cosFromSin) - (f10 * sin));
        return quaternionf;
    }

    public Quaternionf rotateZYX(float f2, float f3, float f4, Quaternionf quaternionf) {
        double d2 = ((double) f4) * 0.5d;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = ((double) f3) * 0.5d;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = ((double) f2) * 0.5d;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f5 = cosFromSin2 * cosFromSin3;
        float f6 = sin2 * sin3;
        float f7 = sin2 * cosFromSin3;
        float f8 = cosFromSin2 * sin3;
        float f9 = (sin * f6) + (cosFromSin * f5);
        float f10 = (f5 * sin) - (f6 * cosFromSin);
        float f11 = (sin * f8) + (cosFromSin * f7);
        float f12 = (cosFromSin * f8) - (sin * f7);
        float f13 = this.w;
        float f14 = f13 * f10;
        float f15 = this.x;
        float f16 = (f15 * f9) + f14;
        float f17 = this.y;
        float f18 = (f17 * f12) + f16;
        float f19 = this.z;
        quaternionf.set(f18 - (f19 * f11), (f19 * f10) + (f17 * f9) + ((f13 * f11) - (f15 * f12)), (f19 * f9) + (((f15 * f11) + (f13 * f12)) - (f17 * f10)), (((f13 * f9) - (f15 * f10)) - (f17 * f11)) - (f19 * f12));
        return quaternionf;
    }

    public Quaternionf rotationAxis(float f2, float f3, float f4, float f5) {
        double d2 = (double) (f2 / 2.0f);
        float sin = (float) Math.sin(d2);
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f5 * f5) + ((f4 * f4) + (f3 * f3)))));
        this.x = f3 * sqrt * sin;
        this.y = f4 * sqrt * sin;
        this.z = f5 * sqrt * sin;
        this.w = (float) Math.cosFromSin((double) sin, d2);
        return this;
    }

    public Quaternionf scale(float f2, Quaternionf quaternionf) {
        float sqrt = (float) Math.sqrt((double) f2);
        quaternionf.x = this.x * sqrt;
        quaternionf.y = this.y * sqrt;
        quaternionf.z = this.z * sqrt;
        quaternionf.w = sqrt * this.w;
        return quaternionf;
    }

    public Quaternionf slerp(Quaternionfc quaternionfc, float f2, Quaternionf quaternionf) {
        float f3;
        float w2 = (quaternionfc.w() * this.w) + (quaternionfc.z() * this.z) + (quaternionfc.y() * this.y) + (quaternionfc.x() * this.x);
        float abs = Math.abs(w2);
        if (1.0f - abs > 1.0E-6f) {
            float f4 = 1.0f - (abs * abs);
            float sqrt = (float) (1.0d / Math.sqrt((double) f4));
            float atan2 = (float) Math.atan2((double) (f4 * sqrt), (double) abs);
            double d2 = (double) sqrt;
            f3 = (float) (Math.sin((1.0d - ((double) f2)) * ((double) atan2)) * d2);
            f2 = (float) (Math.sin((double) (f2 * atan2)) * d2);
        } else {
            f3 = 1.0f - f2;
        }
        if (w2 < 0.0f) {
            f2 = -f2;
        }
        quaternionf.x = (quaternionfc.x() * f2) + (this.x * f3);
        quaternionf.y = (quaternionfc.y() * f2) + (this.y * f3);
        quaternionf.z = (quaternionfc.z() * f2) + (this.z * f3);
        quaternionf.w = (quaternionfc.w() * f2) + (f3 * this.w);
        return quaternionf;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        String str = " ";
        a.b(numberFormat, (double) this.x, a2, str);
        a.b(numberFormat, (double) this.y, a2, str);
        a.b(numberFormat, (double) this.z, a2, str);
        return a.a(numberFormat, (double) this.w, a2, ")");
    }

    public Vector4f transform(Vector4f vector4f) {
        return transform((Vector4fc) vector4f, vector4f);
    }

    public Quaternionf(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set((Quaternionfc) this);
    }

    public Quaternionf lookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
        return lookAlong(f2, f3, f4, f5, f6, f7, this);
    }

    public Vector3f transform(Vector3fc vector3fc, Vector3f vector3f) {
        return transform(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f);
    }

    public Quaternionf conjugate(Quaternionf quaternionf) {
        quaternionf.x = -this.x;
        quaternionf.y = -this.y;
        quaternionf.z = -this.z;
        quaternionf.w = this.w;
        return quaternionf;
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set((Quaternionfc) this);
    }

    public Quaternionf lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Quaternionf quaternionf) {
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = f2;
        float f14 = f3;
        float f15 = f4;
        Quaternionf quaternionf2 = quaternionf;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f15 * f15) + ((f14 * f14) + (f13 * f13)))));
        float f16 = (-f13) * sqrt;
        float f17 = (-f14) * sqrt;
        float f18 = (-f15) * sqrt;
        float f19 = (f6 * f18) - (f7 * f17);
        float f20 = (f7 * f16) - (f5 * f18);
        float f21 = (f5 * f17) - (f6 * f16);
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f21 * f21) + ((f20 * f20) + (f19 * f19)))));
        float f22 = f19 * sqrt2;
        float f23 = f20 * sqrt2;
        float f24 = f21 * sqrt2;
        float f25 = (f17 * f24) - (f18 * f23);
        float f26 = (f18 * f22) - (f16 * f24);
        float f27 = (f16 * f23) - (f17 * f22);
        double d2 = (double) (f22 + f26 + f18);
        if (d2 >= 0.0d) {
            double sqrt3 = Math.sqrt(d2 + 1.0d);
            f9 = (float) (sqrt3 * 0.5d);
            double d3 = 0.5d / sqrt3;
            f10 = (float) (((double) (f17 - f27)) * d3);
            f11 = (float) (((double) (f24 - f16)) * d3);
            f8 = (float) (((double) (f25 - f23)) * d3);
        } else {
            if (f22 > f26 && f22 > f18) {
                double sqrt4 = Math.sqrt(((((double) f22) + 1.0d) - ((double) f26)) - ((double) f18));
                double d4 = 0.5d / sqrt4;
                f8 = (float) (((double) (f16 + f24)) * d4);
                f11 = (float) (((double) (f23 + f25)) * d4);
                f12 = (float) (sqrt4 * 0.5d);
                f9 = (float) (((double) (f17 - f27)) * d4);
            } else if (f26 > f18) {
                double sqrt5 = Math.sqrt(((((double) f26) + 1.0d) - ((double) f22)) - ((double) f18));
                double d5 = 0.5d / sqrt5;
                f9 = (float) (((double) (f24 - f16)) * d5);
                f11 = (float) (sqrt5 * 0.5d);
                f12 = (float) (((double) (f23 + f25)) * d5);
                f8 = (float) (((double) (f27 + f17)) * d5);
            } else {
                double sqrt6 = Math.sqrt(((((double) f18) + 1.0d) - ((double) f22)) - ((double) f26));
                f8 = (float) (sqrt6 * 0.5d);
                double d6 = 0.5d / sqrt6;
                f9 = (float) (((double) (f25 - f23)) * d6);
                float f28 = (float) (((double) (f27 + f17)) * d6);
                f10 = (float) (((double) (f16 + f24)) * d6);
                f11 = f28;
            }
            f10 = f12;
        }
        float f29 = this.w;
        float f30 = f29 * f10;
        float f31 = this.x;
        float f32 = (f31 * f9) + f30;
        float f33 = this.y;
        float f34 = (f33 * f8) + f32;
        float f35 = this.z;
        quaternionf2.set(f34 - (f35 * f11), (f35 * f10) + (f33 * f9) + ((f29 * f11) - (f31 * f8)), (f35 * f9) + (((f31 * f11) + (f29 * f8)) - (f33 * f10)), (((f29 * f9) - (f31 * f10)) - (f33 * f11)) - (f35 * f8));
        return quaternionf2;
    }

    public Vector3d transform(Vector3dc vector3dc, Vector3d vector3d) {
        return transform(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3d);
    }

    private void setFromUnnormalized(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d4;
        double d12 = d4;
        double e2 = a.e(d11, d12, (d3 * d3) + (d2 * d2), 1.0d);
        double e3 = a.e(d7, d7, (d6 * d6) + (d5 * d5), 1.0d);
        double e4 = a.e(d10, d10, (d9 * d9) + (d8 * d8), 1.0d);
        setFromNormalized(d2 * e2, d3 * e2, e2 * d4, d5 * e3, d6 * e3, e3 * d7, d8 * e4, d9 * e4, e4 * d10);
    }

    public Matrix4x3f get(Matrix4x3f matrix4x3f) {
        return matrix4x3f.set((Quaternionfc) this);
    }

    public Quaternionf rotateAxis(float f2, Vector3fc vector3fc, Quaternionf quaternionf) {
        return rotateAxis(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionf);
    }

    public Quaternionf set(Quaternionfc quaternionfc) {
        if (quaternionfc instanceof Quaternionf) {
            MemUtil.INSTANCE.copy((Quaternionf) quaternionfc, this);
        } else {
            this.x = quaternionfc.x();
            this.y = quaternionfc.y();
            this.z = quaternionfc.z();
            this.w = quaternionfc.w();
        }
        return this;
    }

    public Vector3f transform(float f2, float f3, float f4, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        float f5 = this.w;
        float f6 = f5 * f5;
        float f7 = this.x;
        float f8 = f7 * f7;
        float f9 = this.y;
        float f10 = f9 * f9;
        float f11 = this.z;
        float f12 = f11 * f11;
        float f13 = f11 * f5;
        float f14 = f13 + f13;
        float f15 = f7 * f9;
        float f16 = f15 + f15;
        float f17 = f7 * f11;
        float f18 = f17 + f17;
        float f19 = f9 * f5;
        float f20 = f19 + f19;
        float f21 = f9 * f11;
        float f22 = f21 + f21;
        float f23 = f7 * f5;
        float f24 = f23 + f23;
        float b2 = a.b(f6, f8, f12, f10);
        float f25 = f16 + f14;
        float f26 = f18 - f20;
        float f27 = f16 - f14;
        float c2 = a.c(f10, f12, f6, f8);
        float f28 = f22 + f24;
        float f29 = f20 + f18;
        float f30 = f22 - f24;
        float d2 = a.d(f12, f10, f8, f6);
        float f31 = f29 * f4;
        vector3f2.x = f31 + (f27 * f3) + (b2 * f2);
        float f32 = f30 * f4;
        vector3f2.y = f32 + (c2 * f3) + (f25 * f2);
        float f33 = d2 * f4;
        vector3f2.z = f33 + (f28 * f3) + (f26 * f2);
        return vector3f2;
    }

    public Quaternionf add(Quaternionfc quaternionfc) {
        this.x = quaternionfc.x() + this.x;
        this.y = quaternionfc.y() + this.y;
        this.z = quaternionfc.z() + this.z;
        this.w = quaternionfc.w() + this.w;
        return this;
    }

    public Matrix4x3d get(Matrix4x3d matrix4x3d) {
        return matrix4x3d.set((Quaternionfc) this);
    }

    public Quaternionf invert() {
        return invert(this);
    }

    public Quaternionf normalize(Quaternionf quaternionf) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float f7 = (f6 * f6) + f5;
        float f8 = this.w;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f8 * f8) + f7)));
        quaternionf.x = this.x * sqrt;
        quaternionf.y = this.y * sqrt;
        quaternionf.z = this.z * sqrt;
        quaternionf.w = this.w * sqrt;
        return quaternionf;
    }

    public Quaternionf rotateAxis(float f2, Vector3fc vector3fc) {
        return rotateAxis(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), this);
    }

    public Quaternionf setAngleAxis(double d2, double d3, double d4, double d5) {
        double d6 = d2 * 0.5d;
        double sin = Math.sin(d6);
        this.x = (float) (d3 * sin);
        this.y = (float) (d4 * sin);
        this.z = (float) (d5 * sin);
        this.w = (float) Math.cosFromSin(sin, d6);
        return this;
    }

    public Quaternionf div(Quaternionfc quaternionfc) {
        return div(quaternionfc, this);
    }

    public AxisAngle4f get(AxisAngle4f axisAngle4f) {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.z;
        float f5 = this.w;
        if (f5 > 1.0f) {
            float sqrt = (float) (1.0d / Math.sqrt((double) ((f5 * f5) + ((f4 * f4) + ((f3 * f3) + (f2 * f2))))));
            f2 *= sqrt;
            f3 *= sqrt;
            f4 *= sqrt;
            f5 *= sqrt;
        }
        axisAngle4f.angle = (float) (Math.acos((double) f5) * 2.0d);
        float sqrt2 = (float) Math.sqrt(1.0d - ((double) (f5 * f5)));
        if (sqrt2 < 0.001f) {
            axisAngle4f.x = f2;
            axisAngle4f.y = f3;
            axisAngle4f.z = f4;
        } else {
            float f6 = 1.0f / sqrt2;
            axisAngle4f.x = f2 * f6;
            axisAngle4f.y = f3 * f6;
            axisAngle4f.z = f4 * f6;
        }
        return axisAngle4f;
    }

    public Quaternionf mul(float f2, float f3, float f4, float f5) {
        float f6 = this.w;
        float f7 = f6 * f2;
        float f8 = this.x;
        float f9 = (f8 * f5) + f7;
        float f10 = this.y;
        float f11 = (f10 * f4) + f9;
        float f12 = this.z;
        set(f11 - (f12 * f3), (f12 * f2) + (f10 * f5) + ((f6 * f3) - (f8 * f4)), (f12 * f5) + (((f8 * f3) + (f6 * f4)) - (f10 * f2)), (((f6 * f5) - (f8 * f2)) - (f10 * f3)) - (f12 * f4));
        return this;
    }

    public Quaternionf premul(float f2, float f3, float f4, float f5) {
        return premul(f2, f3, f4, f5, this);
    }

    public Quaternionf rotateAxis(float f2, float f3, float f4, float f5) {
        return rotateAxis(f2, f3, f4, f5, this);
    }

    public Quaternionf(Quaternionf quaternionf) {
        MemUtil.INSTANCE.copy(quaternionf, this);
    }

    public Quaternionf mul(float f2, float f3, float f4, float f5, Quaternionf quaternionf) {
        float f6 = this.w;
        float f7 = f6 * f2;
        float f8 = this.x;
        float f9 = (f8 * f5) + f7;
        float f10 = this.y;
        float f11 = (f10 * f4) + f9;
        float f12 = this.z;
        quaternionf.set(f11 - (f12 * f3), (f12 * f2) + (f10 * f5) + ((f6 * f3) - (f8 * f4)), (f12 * f5) + (((f8 * f3) + (f6 * f4)) - (f10 * f2)), (((f6 * f5) - (f8 * f2)) - (f10 * f3)) - (f12 * f4));
        return quaternionf;
    }

    public Quaternionf premul(float f2, float f3, float f4, float f5, Quaternionf quaternionf) {
        float f6 = this.x;
        float f7 = f5 * f6;
        float f8 = this.w;
        float f9 = (f2 * f8) + f7;
        float f10 = this.z;
        float f11 = (f3 * f10) + f9;
        float f12 = this.y;
        quaternionf.set(f11 - (f4 * f12), (f4 * f6) + (f3 * f8) + ((f5 * f12) - (f2 * f10)), (f4 * f8) + (((f2 * f12) + (f5 * f10)) - (f3 * f6)), (((f5 * f8) - (f2 * f6)) - (f3 * f12)) - (f4 * f10));
        return quaternionf;
    }

    public Quaternionf rotateTo(float f2, float f3, float f4, float f5, float f6, float f7) {
        return rotateTo(f2, f3, f4, f5, f6, f7, this);
    }

    public Quaternionf rotationAxis(float f2, Vector3fc vector3fc) {
        return rotationAxis(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Quaternionf setFromUnnormalized(Matrix4fc matrix4fc) {
        setFromUnnormalized(matrix4fc.m00(), matrix4fc.m01(), matrix4fc.m02(), matrix4fc.m10(), matrix4fc.m11(), matrix4fc.m12(), matrix4fc.m20(), matrix4fc.m21(), matrix4fc.m22());
        return this;
    }

    public Vector4f transformPositiveX(Vector4f vector4f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f2;
        float f10 = f4 * f6;
        float f11 = f4 * f8;
        float f12 = f6 * f2;
        vector4f.x = a.b(f3, f5, f8 * f8, f7);
        vector4f.y = a.a(f10, f9, f9, f10);
        vector4f.z = a.c(f11, f12, f11, f12);
        return vector4f;
    }

    public Vector4f transformPositiveY(Vector4f vector4f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f8;
        float f10 = f8 * f2;
        float f11 = f4 * f6;
        float f12 = f6 * f8;
        float f13 = f4 * f2;
        vector4f.x = (((-f10) + f11) - f10) + f11;
        vector4f.y = a.c(f7, f9, f3, f5);
        vector4f.z = a.a(f12, f12, f13, f13);
        return vector4f;
    }

    public Vector4f transformPositiveZ(Vector4f vector4f) {
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f8;
        float f10 = f4 * f8;
        float f11 = f6 * f2;
        float f12 = f6 * f8;
        float f13 = f4 * f2;
        vector4f.x = a.a(f11, f10, f10, f11);
        vector4f.y = a.b(f12, f12, f13, f13);
        vector4f.z = a.d(f9, f7, f5, f3);
        return vector4f;
    }

    public Vector4f transformUnitPositiveX(Vector4f vector4f) {
        float f2 = this.y;
        float f3 = f2 * f2;
        float f4 = this.z;
        float f5 = f4 * f4;
        float f6 = this.x;
        float f7 = f6 * f2;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector4f.x = (((1.0f - f3) - f3) - f5) - f5;
        vector4f.y = a.a(f7, f11, f7, f11);
        vector4f.z = a.c(f8, f10, f8, f10);
        return vector4f;
    }

    public Vector3f transformUnitPositiveY(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.z;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f2 * f6;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector3f.x = a.c(f7, f11, f7, f11);
        vector3f.y = (((1.0f - f3) - f3) - f5) - f5;
        vector3f.z = a.a(f8, f8, f10, f10);
        return vector3f;
    }

    public Vector3f transformUnitPositiveZ(Vector3f vector3f) {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = f4 * f4;
        float f6 = this.z;
        float f7 = f2 * f6;
        float f8 = f6 * f4;
        float f9 = this.w;
        float f10 = f2 * f9;
        float f11 = f4 * f9;
        vector3f.x = a.a(f7, f11, f7, f11);
        vector3f.y = a.b(f8, f8, f10, f10);
        vector3f.z = (((1.0f - f3) - f3) - f5) - f5;
        return vector3f;
    }

    public Quaternionf rotateTo(Vector3fc vector3fc, Vector3fc vector3fc2, Quaternionf quaternionf) {
        return rotateTo(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), quaternionf);
    }

    public Quaternionf setFromUnnormalized(Matrix4x3fc matrix4x3fc) {
        setFromUnnormalized(matrix4x3fc.m00(), matrix4x3fc.m01(), matrix4x3fc.m02(), matrix4x3fc.m10(), matrix4x3fc.m11(), matrix4x3fc.m12(), matrix4x3fc.m20(), matrix4x3fc.m21(), matrix4x3fc.m22());
        return this;
    }

    public Quaternionf(AxisAngle4f axisAngle4f) {
        float sin = (float) Math.sin(((double) axisAngle4f.angle) * 0.5d);
        float cosFromSin = (float) Math.cosFromSin((double) sin, ((double) axisAngle4f.angle) * 0.5d);
        this.x = axisAngle4f.x * sin;
        this.y = axisAngle4f.y * sin;
        this.z = axisAngle4f.z * sin;
        this.w = cosFromSin;
    }

    public Quaternionf add(Quaternionfc quaternionfc, Quaternionf quaternionf) {
        quaternionf.x = quaternionfc.x() + this.x;
        quaternionf.y = quaternionfc.y() + this.y;
        quaternionf.z = quaternionfc.z() + this.z;
        quaternionf.w = quaternionfc.w() + this.w;
        return quaternionf;
    }

    public Quaternionf rotateTo(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotateTo(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public Quaternionf setFromUnnormalized(Matrix4x3dc matrix4x3dc) {
        setFromUnnormalized(matrix4x3dc.m00(), matrix4x3dc.m01(), matrix4x3dc.m02(), matrix4x3dc.m10(), matrix4x3dc.m11(), matrix4x3dc.m12(), matrix4x3dc.m20(), matrix4x3dc.m21(), matrix4x3dc.m22());
        return this;
    }

    public Quaternionf set(AxisAngle4f axisAngle4f) {
        return setAngleAxis(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Quaternionf setFromUnnormalized(Matrix4dc matrix4dc) {
        setFromUnnormalized(matrix4dc.m00(), matrix4dc.m01(), matrix4dc.m02(), matrix4dc.m10(), matrix4dc.m11(), matrix4dc.m12(), matrix4dc.m20(), matrix4dc.m21(), matrix4dc.m22());
        return this;
    }

    public static Quaternionfc nlerp(Quaternionfc[] quaternionfcArr, float[] fArr, Quaternionf quaternionf) {
        quaternionf.set(quaternionfcArr[0]);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < quaternionfcArr.length; i2++) {
            float f3 = fArr[i2];
            f2 += f3;
            quaternionf.nlerp(quaternionfcArr[i2], f3 / f2);
        }
        return quaternionf;
    }

    public static Quaternionfc slerp(Quaternionf[] quaternionfArr, float[] fArr, Quaternionf quaternionf) {
        quaternionf.set((Quaternionfc) quaternionfArr[0]);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < quaternionfArr.length; i2++) {
            float f3 = fArr[i2];
            f2 += f3;
            quaternionf.slerp(quaternionfArr[i2], f3 / f2);
        }
        return quaternionf;
    }

    public Quaternionf set(AxisAngle4d axisAngle4d) {
        return setAngleAxis(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Quaternionf setFromUnnormalized(Matrix3fc matrix3fc) {
        setFromUnnormalized(matrix3fc.m00(), matrix3fc.m01(), matrix3fc.m02(), matrix3fc.m10(), matrix3fc.m11(), matrix3fc.m12(), matrix3fc.m20(), matrix3fc.m21(), matrix3fc.m22());
        return this;
    }

    public Vector3d transform(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        float f2 = this.w;
        float f3 = f2 * f2;
        float f4 = this.x;
        float f5 = f4 * f4;
        float f6 = this.y;
        float f7 = f6 * f6;
        float f8 = this.z;
        float f9 = f8 * f8;
        float f10 = f8 * f2;
        float f11 = f10 + f10;
        float f12 = f4 * f6;
        float f13 = f12 + f12;
        float f14 = f4 * f8;
        float f15 = f14 + f14;
        float f16 = f6 * f2;
        float f17 = f16 + f16;
        float f18 = f6 * f8;
        float f19 = f18 + f18;
        float f20 = f4 * f2;
        float f21 = f20 + f20;
        float b2 = a.b(f3, f5, f9, f7);
        float f22 = f13 + f11;
        float f23 = f15 - f17;
        float f24 = f13 - f11;
        float c2 = a.c(f7, f9, f3, f5);
        float f25 = f19 + f21;
        float f26 = f17 + f15;
        float f27 = f19 - f21;
        float d5 = a.d(f9, f7, f5, f3);
        vector3d2.x = (((double) f26) * d4) + (((double) f24) * d3) + (((double) b2) * d2);
        vector3d2.y = (((double) f27) * d4) + (((double) c2) * d3) + (((double) f22) * d2);
        double d6 = ((double) d5) * d4;
        vector3d2.z = d6 + (((double) f25) * d3) + (((double) f23) * d2);
        return vector3d2;
    }

    public Quaternionf nlerpIterative(Quaternionfc quaternionfc, float f2, float f3) {
        return nlerpIterative(quaternionfc, f2, f3, this);
    }

    public Quaternionf setFromUnnormalized(Matrix3dc matrix3dc) {
        setFromUnnormalized(matrix3dc.m00(), matrix3dc.m01(), matrix3dc.m02(), matrix3dc.m10(), matrix3dc.m11(), matrix3dc.m12(), matrix3dc.m20(), matrix3dc.m21(), matrix3dc.m22());
        return this;
    }

    public static Quaternionfc nlerpIterative(Quaternionf[] quaternionfArr, float[] fArr, float f2, Quaternionf quaternionf) {
        quaternionf.set((Quaternionfc) quaternionfArr[0]);
        float f3 = fArr[0];
        for (int i2 = 1; i2 < quaternionfArr.length; i2++) {
            float f4 = fArr[i2];
            f3 += f4;
            quaternionf.nlerpIterative(quaternionfArr[i2], f4 / f3, f2);
        }
        return quaternionf;
    }

    public Quaternionf rotationTo(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotationTo(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Vector4f transform(Vector4fc vector4fc, Vector4f vector4f) {
        return transform(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4f);
    }

    public Quaterniond get(Quaterniond quaterniond) {
        return quaterniond.set((Quaternionfc) this);
    }

    public Vector4f transform(float f2, float f3, float f4, Vector4f vector4f) {
        Vector4f vector4f2 = vector4f;
        float f5 = this.w;
        float f6 = f5 * f5;
        float f7 = this.x;
        float f8 = f7 * f7;
        float f9 = this.y;
        float f10 = f9 * f9;
        float f11 = this.z;
        float f12 = f11 * f11;
        float f13 = f11 * f5;
        float f14 = f13 + f13;
        float f15 = f7 * f9;
        float f16 = f15 + f15;
        float f17 = f7 * f11;
        float f18 = f17 + f17;
        float f19 = f9 * f5;
        float f20 = f19 + f19;
        float f21 = f9 * f11;
        float f22 = f21 + f21;
        float f23 = f7 * f5;
        float f24 = f23 + f23;
        float b2 = a.b(f6, f8, f12, f10);
        float f25 = f16 + f14;
        float f26 = f18 - f20;
        float f27 = f16 - f14;
        float c2 = a.c(f10, f12, f6, f8);
        float f28 = f22 + f24;
        float f29 = f20 + f18;
        float f30 = f22 - f24;
        float d2 = a.d(f12, f10, f8, f6);
        float f31 = f29 * f4;
        vector4f2.x = f31 + (f27 * f3) + (b2 * f2);
        float f32 = f30 * f4;
        vector4f2.y = f32 + (c2 * f3) + (f25 * f2);
        float f33 = d2 * f4;
        vector4f2.z = f33 + (f28 * f3) + (f26 * f2);
        return vector4f2;
    }

    private void setFromNormalized(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d2 + d6;
        double d12 = d11 + d10;
        if (d12 >= 0.0d) {
            double sqrt = Math.sqrt(d12 + 1.0d);
            this.w = (float) (sqrt * 0.5d);
            double d13 = 0.5d / sqrt;
            this.x = (float) ((d7 - d9) * d13);
            this.y = (float) ((d8 - d4) * d13);
            this.z = (float) ((d3 - d5) * d13);
        } else if (d2 >= d6 && d2 >= d10) {
            double sqrt2 = Math.sqrt((d2 - (d6 + d10)) + 1.0d);
            this.x = (float) (sqrt2 * 0.5d);
            double d14 = 0.5d / sqrt2;
            this.y = (float) ((d5 + d3) * d14);
            this.z = (float) ((d4 + d8) * d14);
            this.w = (float) ((d7 - d9) * d14);
        } else if (d6 > d10) {
            double sqrt3 = (double) ((float) Math.sqrt((d6 - (d10 + d2)) + 1.0d));
            this.y = (float) (sqrt3 * 0.5d);
            double d15 = 0.5d / sqrt3;
            this.z = (float) ((d9 + d7) * d15);
            this.x = (float) ((d5 + d3) * d15);
            this.w = (float) ((d8 - d4) * d15);
        } else {
            double sqrt4 = (double) ((float) Math.sqrt((d10 - d11) + 1.0d));
            this.z = (float) (sqrt4 * 0.5d);
            double d16 = 0.5d / sqrt4;
            this.x = (float) ((d4 + d8) * d16);
            this.y = (float) ((d9 + d7) * d16);
            this.w = (float) ((d3 - d5) * d16);
        }
    }

    public Quaternionf get(Quaternionf quaternionf) {
        return quaternionf.set((Quaternionfc) this);
    }

    public Quaternionf setFromNormalized(Matrix4fc matrix4fc) {
        setFromNormalized(matrix4fc.m00(), matrix4fc.m01(), matrix4fc.m02(), matrix4fc.m10(), matrix4fc.m11(), matrix4fc.m12(), matrix4fc.m20(), matrix4fc.m21(), matrix4fc.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4x3fc matrix4x3fc) {
        setFromNormalized(matrix4x3fc.m00(), matrix4x3fc.m01(), matrix4x3fc.m02(), matrix4x3fc.m10(), matrix4x3fc.m11(), matrix4x3fc.m12(), matrix4x3fc.m20(), matrix4x3fc.m21(), matrix4x3fc.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4x3dc matrix4x3dc) {
        setFromNormalized(matrix4x3dc.m00(), matrix4x3dc.m01(), matrix4x3dc.m02(), matrix4x3dc.m10(), matrix4x3dc.m11(), matrix4x3dc.m12(), matrix4x3dc.m20(), matrix4x3dc.m21(), matrix4x3dc.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix4dc matrix4dc) {
        setFromNormalized(matrix4dc.m00(), matrix4dc.m01(), matrix4dc.m02(), matrix4dc.m10(), matrix4dc.m11(), matrix4dc.m12(), matrix4dc.m20(), matrix4dc.m21(), matrix4dc.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix3fc matrix3fc) {
        setFromNormalized(matrix3fc.m00(), matrix3fc.m01(), matrix3fc.m02(), matrix3fc.m10(), matrix3fc.m11(), matrix3fc.m12(), matrix3fc.m20(), matrix3fc.m21(), matrix3fc.m22());
        return this;
    }

    public Quaternionf setFromNormalized(Matrix3dc matrix3dc) {
        setFromNormalized(matrix3dc.m00(), matrix3dc.m01(), matrix3dc.m02(), matrix3dc.m10(), matrix3dc.m11(), matrix3dc.m12(), matrix3dc.m20(), matrix3dc.m21(), matrix3dc.m22());
        return this;
    }
}
