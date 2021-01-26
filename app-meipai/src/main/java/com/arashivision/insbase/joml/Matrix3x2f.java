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

public class Matrix3x2f implements Matrix3x2fc, Externalizable {
    public static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m10;
    public float m11;
    public float m20;
    public float m21;

    public Matrix3x2f() {
        this.m00 = 1.0f;
        this.m11 = 1.0f;
    }

    private void setMatrix3x2fc(Matrix3x2fc matrix3x2fc) {
        this.m00 = matrix3x2fc.m00();
        this.m01 = matrix3x2fc.m01();
        this.m10 = matrix3x2fc.m10();
        this.m11 = matrix3x2fc.m11();
        this.m20 = matrix3x2fc.m20();
        this.m21 = matrix3x2fc.m21();
    }

    public Matrix3x2f _m00(float f2) {
        this.m00 = f2;
        return this;
    }

    public Matrix3x2f _m01(float f2) {
        this.m01 = f2;
        return this;
    }

    public Matrix3x2f _m10(float f2) {
        this.m10 = f2;
        return this;
    }

    public Matrix3x2f _m11(float f2) {
        this.m11 = f2;
        return this;
    }

    public Matrix3x2f _m20(float f2) {
        this.m20 = f2;
        return this;
    }

    public Matrix3x2f _m21(float f2) {
        this.m21 = f2;
        return this;
    }

    public float determinant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix3x2f matrix3x2f = (Matrix3x2f) obj;
        return Float.floatToIntBits(this.m00) == Float.floatToIntBits(matrix3x2f.m00) && Float.floatToIntBits(this.m01) == Float.floatToIntBits(matrix3x2f.m01) && Float.floatToIntBits(this.m10) == Float.floatToIntBits(matrix3x2f.m10) && Float.floatToIntBits(this.m11) == Float.floatToIntBits(matrix3x2f.m11) && Float.floatToIntBits(this.m20) == Float.floatToIntBits(matrix3x2f.m20) && Float.floatToIntBits(this.m21) == Float.floatToIntBits(matrix3x2f.m21);
    }

    public Matrix3x2f get(Matrix3x2f matrix3x2f) {
        return matrix3x2f.set((Matrix3x2fc) this);
    }

    public FloatBuffer get3x3(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put3x3(this, 0, floatBuffer);
        return floatBuffer;
    }

    public FloatBuffer get4x4(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put4x4(this, 0, floatBuffer);
        return floatBuffer;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.m21) + a.a(this.m20, a.a(this.m11, a.a(this.m10, a.a(this.m01, a.a(this.m00, 31, 31), 31), 31), 31), 31);
    }

    public Matrix3x2f identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Matrix3x2f invert() {
        return invert(this);
    }

    public float m00() {
        return this.m00;
    }

    public float m01() {
        return this.m01;
    }

    public float m10() {
        return this.m10;
    }

    public float m11() {
        return this.m11;
    }

    public float m20() {
        return this.m20;
    }

    public float m21() {
        return this.m21;
    }

    public Matrix3x2f mul(Matrix3x2fc matrix3x2fc) {
        return mul(matrix3x2fc, this);
    }

    public Matrix3x2f mulLocal(Matrix3x2fc matrix3x2fc) {
        return mulLocal(matrix3x2fc, this);
    }

    public Vector2f normalizedPositiveX(Vector2f vector2f) {
        vector2f.x = this.m11;
        vector2f.y = -this.m01;
        return vector2f;
    }

    public Vector2f normalizedPositiveY(Vector2f vector2f) {
        vector2f.x = -this.m10;
        vector2f.y = this.m00;
        return vector2f;
    }

    public Vector2f origin(Vector2f vector2f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = 1.0f / (f4 - (f5 * f6));
        float f8 = this.m21;
        float f9 = f6 * f8;
        float f10 = this.m20;
        vector2f.x = a.i(f3, f10, f9, f7);
        vector2f.y = a.i(f2, f8, f10 * f5, f7);
        return vector2f;
    }

    public Vector2f positiveX(Vector2f vector2f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = 1.0f / (f4 - (this.m10 * f5));
        vector2f.x = f3 * f6;
        vector2f.y = (-f5) * f6;
        return vector2f.normalize(vector2f);
    }

    public Vector2f positiveY(Vector2f vector2f) {
        float f2 = this.m00;
        float f3 = this.m11 * f2;
        float f4 = this.m01;
        float f5 = this.m10;
        float f6 = 1.0f / (f3 - (f4 * f5));
        vector2f.x = (-f5) * f6;
        vector2f.y = f2 * f6;
        return vector2f.normalize(vector2f);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readFloat();
        this.m01 = objectInput.readFloat();
        this.m10 = objectInput.readFloat();
        this.m11 = objectInput.readFloat();
        this.m20 = objectInput.readFloat();
        this.m21 = objectInput.readFloat();
    }

    public Matrix3x2f rotate(float f2) {
        return rotate(f2, this);
    }

    public Matrix3x2f rotateAbout(float f2, float f3, float f4) {
        return rotateAbout(f2, f3, f4, this);
    }

    public Matrix3x2f rotateLocal(float f2, Matrix3x2f matrix3x2f) {
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
        matrix3x2f.m00 = f6;
        matrix3x2f.m01 = f7;
        matrix3x2f.m10 = f11;
        matrix3x2f.m11 = f12;
        matrix3x2f.m20 = f16;
        matrix3x2f.m21 = f17;
        return matrix3x2f;
    }

    public Matrix3x2f rotateTo(Vector2fc vector2fc, Vector2fc vector2fc2, Matrix3x2f matrix3x2f) {
        float y = (vector2fc2.y() * vector2fc.y()) + (vector2fc2.x() * vector2fc.x());
        float y2 = (vector2fc2.y() * vector2fc.x()) - (vector2fc2.x() * vector2fc.y());
        float f2 = -y2;
        float f3 = this.m00;
        float f4 = f3 * y;
        float f5 = this.m10;
        float f6 = (f5 * y2) + f4;
        float f7 = this.m01;
        float f8 = f7 * y;
        float f9 = this.m11;
        float f10 = (y2 * f9) + f8;
        matrix3x2f.m10 = (f5 * y) + (f3 * f2);
        matrix3x2f.m11 = (f9 * y) + (f7 * f2);
        matrix3x2f.m00 = f6;
        matrix3x2f.m01 = f10;
        matrix3x2f.m20 = this.m20;
        matrix3x2f.m21 = this.m21;
        return matrix3x2f;
    }

    public Matrix3x2f rotation(float f2) {
        double d2 = (double) f2;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        this.m00 = cos;
        this.m10 = -sin;
        this.m20 = 0.0f;
        this.m01 = sin;
        this.m11 = cos;
        this.m21 = 0.0f;
        return this;
    }

    public Matrix3x2f scale(float f2, float f3, Matrix3x2f matrix3x2f) {
        matrix3x2f.m00 = this.m00 * f2;
        matrix3x2f.m01 = this.m01 * f2;
        matrix3x2f.m10 = this.m10 * f3;
        matrix3x2f.m11 = this.m11 * f3;
        matrix3x2f.m20 = this.m20;
        matrix3x2f.m21 = this.m21;
        return matrix3x2f;
    }

    public Matrix3x2f scaleAround(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f) {
        float f6 = this.m00;
        float f7 = f6 * f4;
        float f8 = this.m10;
        float f9 = (f8 * f5) + f7 + this.m20;
        float f10 = this.m01;
        float f11 = f10 * f4;
        float f12 = this.m11;
        float f13 = (f12 * f5) + f11 + this.m21;
        matrix3x2f.m00 = f6 * f2;
        matrix3x2f.m01 = f10 * f2;
        matrix3x2f.m10 = f8 * f3;
        matrix3x2f.m11 = f12 * f3;
        matrix3x2f.m20 = (((-this.m00) * f4) - (this.m10 * f5)) + f9;
        matrix3x2f.m21 = (((-this.m01) * f4) - (this.m11 * f5)) + f13;
        return matrix3x2f;
    }

    public Matrix3x2f scaleAroundLocal(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f) {
        matrix3x2f.m00 = this.m00 * f2;
        matrix3x2f.m01 = this.m01 * f3;
        matrix3x2f.m10 = this.m10 * f2;
        matrix3x2f.m11 = this.m11 * f3;
        matrix3x2f.m20 = ((this.m20 * f2) - (f2 * f4)) + f4;
        matrix3x2f.m21 = ((this.m21 * f3) - (f3 * f5)) + f5;
        return matrix3x2f;
    }

    public Matrix3x2f scaleLocal(float f2, float f3, Matrix3x2f matrix3x2f) {
        matrix3x2f.m00 = this.m00 * f2;
        matrix3x2f.m01 = this.m01 * f3;
        matrix3x2f.m10 = this.m10 * f2;
        matrix3x2f.m11 = this.m11 * f3;
        matrix3x2f.m20 = f2 * this.m20;
        matrix3x2f.m21 = f3 * this.m21;
        return matrix3x2f;
    }

    public Matrix3x2f scaling(float f2) {
        return scaling(f2, f2);
    }

    public Matrix3x2f set(Matrix3x2fc matrix3x2fc) {
        if (matrix3x2fc instanceof Matrix3x2f) {
            MemUtil.INSTANCE.copy((Matrix3x2f) matrix3x2fc, this);
        } else {
            setMatrix3x2fc(matrix3x2fc);
        }
        return this;
    }

    public Matrix3x2f setTranslation(float f2, float f3) {
        this.m20 = f2;
        this.m21 = f3;
        return this;
    }

    public Matrix3x2f setView(float f2, float f3, float f4, float f5) {
        this.m00 = 2.0f / (f3 - f2);
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 2.0f / (f5 - f4);
        this.m20 = (f2 + f3) / (f2 - f3);
        this.m21 = (f4 + f5) / (f4 - f5);
        return this;
    }

    public Matrix3x2f shearX(float f2) {
        return shearX(f2, this);
    }

    public Matrix3x2f shearY(float f2) {
        return shearY(f2, this);
    }

    public Matrix3x2f span(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = 1.0f / (f4 - (f5 * f6));
        float f8 = f3 * f7;
        float f9 = (-f5) * f7;
        float f10 = (-f6) * f7;
        float f11 = f2 * f7;
        float f12 = (-f8) - f10;
        float f13 = this.m21;
        float f14 = f6 * f13;
        float f15 = this.m20;
        vector2f.x = a.a(f3, f15, f14, f7, f12);
        vector2f.y = a.a(f2, f13, f15 * f5, f7, (-f9) - f11);
        vector2f2.x = f8 * 2.0f;
        vector2f2.y = f9 * 2.0f;
        vector2f3.x = f10 * 2.0f;
        vector2f3.y = f11 * 2.0f;
        return this;
    }

    public boolean testAar(float f2, float f3, float f4, float f5) {
        float f6 = this.m00;
        float f7 = this.m10;
        float f8 = this.m20;
        float f9 = f8 + 1.0f;
        float f10 = -f6;
        float f11 = -f7;
        float f12 = 1.0f - f8;
        float f13 = this.m01;
        float f14 = this.m11;
        float f15 = this.m21;
        float f16 = f15 + 1.0f;
        float f17 = -f13;
        float f18 = -f14;
        float f19 = 1.0f - f15;
        if ((f7 * (f7 < 0.0f ? f3 : f5)) + (f6 * (f6 < 0.0f ? f2 : f4)) >= (-f9)) {
            if ((f11 * (f11 < 0.0f ? f3 : f5)) + (f10 * (f10 < 0.0f ? f2 : f4)) >= (-f12)) {
                if ((f14 * (f14 < 0.0f ? f3 : f5)) + (f13 * (f13 < 0.0f ? f2 : f4)) >= (-f16)) {
                    if ((f18 * (f18 < 0.0f ? f3 : f5)) + (f17 * (f17 < 0.0f ? f2 : f4)) >= (-f19)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean testCircle(float f2, float f3, float f4) {
        float f5 = f3;
        float f6 = this.m00;
        float f7 = this.m10;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f7 * f7) + (f6 * f6))));
        float f8 = f6 * sqrt;
        float f9 = f7 * sqrt;
        float f10 = (this.m20 + 1.0f) * sqrt;
        float f11 = -this.m00;
        float f12 = -this.m10;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f12 * f12) + (f11 * f11))));
        float f13 = f11 * sqrt2;
        float f14 = f12 * sqrt2;
        float f15 = (1.0f - this.m20) * sqrt2;
        float f16 = this.m01;
        float f17 = this.m11;
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f17 * f17) + (f16 * f16))));
        float f18 = f16 * sqrt3;
        float f19 = f17 * sqrt3;
        float f20 = (this.m21 + 1.0f) * sqrt3;
        float f21 = -this.m01;
        float f22 = -this.m11;
        float sqrt4 = (float) (1.0d / Math.sqrt((double) ((f22 * f22) + (f21 * f21))));
        float f23 = f21 * sqrt4;
        float f24 = f22 * sqrt4;
        float f25 = (1.0f - this.m21) * sqrt4;
        float f26 = a.f(f9, f5, f8 * f2, f10);
        float f27 = -f4;
        return f26 >= f27 && a.f(f14, f5, f13 * f2, f15) >= f27 && a.f(f19, f5, f18 * f2, f20) >= f27 && a.f(f24, f5, f23 * f2, f25) >= f27;
    }

    public boolean testPoint(float f2, float f3) {
        float f4 = this.m00;
        float f5 = this.m10;
        float f6 = this.m20;
        float f7 = f6 + 1.0f;
        float f8 = -f4;
        float f9 = -f5;
        float f10 = 1.0f - f6;
        float f11 = this.m01;
        float f12 = this.m11;
        float f13 = this.m21;
        return a.f(f5, f3, f4 * f2, f7) >= 0.0f && a.f(f9, f3, f8 * f2, f10) >= 0.0f && a.f(f12, f3, f11 * f2, f13 + 1.0f) >= 0.0f && a.f(-f12, f3, (-f11) * f2, 1.0f - f13) >= 0.0f;
    }

    public String toString() {
        String matrix3x2f = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix3x2f.length(); i3++) {
            char charAt = matrix3x2f.charAt(i3);
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
        return vector3f.mul((Matrix3x2fc) this);
    }

    public Vector2f transformDirection(Vector2f vector2f) {
        float f2 = this.m00;
        float f3 = vector2f.x;
        float f4 = f2 * f3;
        float f5 = this.m10;
        float f6 = vector2f.y;
        vector2f.set((f5 * f6) + f4, (this.m11 * f6) + (this.m01 * f3));
        return vector2f;
    }

    public Vector2f transformPosition(Vector2f vector2f) {
        float f2 = this.m00;
        float f3 = vector2f.x;
        float f4 = f2 * f3;
        float f5 = this.m10;
        float f6 = vector2f.y;
        vector2f.set((f5 * f6) + f4 + this.m20, (this.m11 * f6) + (this.m01 * f3) + this.m21);
        return vector2f;
    }

    public Matrix3x2f translate(float f2, float f3, Matrix3x2f matrix3x2f) {
        float f4 = this.m00;
        float f5 = f4 * f2;
        float f6 = this.m10;
        matrix3x2f.m20 = (f6 * f3) + f5 + this.m20;
        float f7 = this.m01;
        float f8 = f2 * f7;
        float f9 = this.m11;
        matrix3x2f.m21 = (f3 * f9) + f8 + this.m21;
        matrix3x2f.m00 = f4;
        matrix3x2f.m01 = f7;
        matrix3x2f.m10 = f6;
        matrix3x2f.m11 = f9;
        return matrix3x2f;
    }

    public Matrix3x2f translateLocal(Vector2fc vector2fc) {
        return translateLocal(vector2fc.x(), vector2fc.y());
    }

    public Matrix3x2f translation(float f2, float f3) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m20 = f2;
        this.m21 = f3;
        return this;
    }

    public Vector2f unproject(float f2, float f3, int[] iArr, Vector2f vector2f) {
        Vector2f vector2f2 = vector2f;
        float f4 = this.m00;
        float f5 = this.m11;
        float f6 = f4 * f5;
        float f7 = this.m01;
        float f8 = this.m10;
        float f9 = 1.0f / (f6 - (f7 * f8));
        float f10 = f5 * f9;
        float f11 = (-f7) * f9;
        float f12 = (-f8) * f9;
        float f13 = f4 * f9;
        float f14 = this.m21;
        float f15 = f8 * f14;
        float f16 = this.m20;
        float i2 = a.i(f5, f16, f15, f9);
        float i3 = a.i(f4, f14, f16 * f7, f9);
        float f17 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f18 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        vector2f2.x = a.f(f12, f18, f10 * f17, i2);
        vector2f2.y = a.f(f13, f18, f11 * f17, i3);
        return vector2f2;
    }

    public Vector2f unprojectInv(float f2, float f3, int[] iArr, Vector2f vector2f) {
        float f4 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f5 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        vector2f.x = (this.m10 * f5) + (this.m00 * f4) + this.m20;
        vector2f.y = (this.m11 * f5) + (this.m01 * f4) + this.m21;
        return vector2f;
    }

    public Matrix3x2f view(float f2, float f3, float f4, float f5, Matrix3x2f matrix3x2f) {
        float f6 = 2.0f / (f3 - f2);
        float f7 = 2.0f / (f5 - f4);
        float f8 = (f2 + f3) / (f2 - f3);
        float f9 = (f4 + f5) / (f4 - f5);
        float f10 = this.m00;
        float f11 = f10 * f8;
        float f12 = this.m10;
        matrix3x2f.m20 = (f12 * f9) + f11 + this.m20;
        float f13 = this.m01;
        float f14 = f8 * f13;
        float f15 = this.m11;
        matrix3x2f.m21 = (f9 * f15) + f14 + this.m21;
        matrix3x2f.m00 = f10 * f6;
        matrix3x2f.m01 = f13 * f6;
        matrix3x2f.m10 = f12 * f7;
        matrix3x2f.m11 = f15 * f7;
        return matrix3x2f;
    }

    public float[] viewArea(float[] fArr) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = 1.0f / (f4 - (f5 * f6));
        float f8 = f3 * f7;
        float f9 = (-f5) * f7;
        float f10 = (-f6) * f7;
        float f11 = f2 * f7;
        float f12 = this.m21;
        float f13 = f6 * f12;
        float f14 = this.m20;
        float i2 = a.i(f3, f14, f13, f7);
        float i3 = a.i(f2, f12, f14 * f5, f7);
        float f15 = -f8;
        float f16 = f15 - f10;
        float f17 = -f9;
        float f18 = f17 - f11;
        float f19 = f8 - f10;
        float f20 = f9 - f11;
        float f21 = f15 + f10;
        float f22 = f17 + f11;
        float f23 = f8 + f10;
        float f24 = f9 + f11;
        float f25 = f16 < f21 ? f16 : f21;
        if (f25 >= f19) {
            f25 = f19;
        }
        if (f25 >= f23) {
            f25 = f23;
        }
        float f26 = f18 < f22 ? f18 : f22;
        if (f26 >= f20) {
            f26 = f20;
        }
        if (f26 >= f24) {
            f26 = f24;
        }
        if (f16 <= f21) {
            f16 = f21;
        }
        if (f16 > f19) {
            f19 = f16;
        }
        if (f19 > f23) {
            f23 = f19;
        }
        if (f18 <= f22) {
            f18 = f22;
        }
        if (f18 > f20) {
            f20 = f18;
        }
        if (f20 > f24) {
            f24 = f20;
        }
        fArr[0] = f25 + i2;
        fArr[1] = f26 + i3;
        fArr[2] = f23 + i2;
        fArr[3] = f24 + i3;
        return fArr;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.m00);
        objectOutput.writeFloat(this.m01);
        objectOutput.writeFloat(this.m10);
        objectOutput.writeFloat(this.m11);
        objectOutput.writeFloat(this.m20);
        objectOutput.writeFloat(this.m21);
    }

    public Matrix3x2f zero() {
        MemUtil.INSTANCE.zero(this);
        return this;
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public FloatBuffer get3x3(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put3x3(this, i2, floatBuffer);
        return floatBuffer;
    }

    public FloatBuffer get4x4(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Matrix3x2f invert(Matrix3x2f matrix3x2f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = 1.0f / (f4 - (f5 * f6));
        float f8 = f3 * f7;
        float f9 = (-f5) * f7;
        float f10 = (-f6) * f7;
        float f11 = f2 * f7;
        float f12 = this.m21;
        float f13 = f6 * f12;
        float f14 = this.m20;
        float i2 = a.i(f3, f14, f13, f7);
        float i3 = a.i(f2, f12, f14 * f5, f7);
        matrix3x2f.m00 = f8;
        matrix3x2f.m01 = f9;
        matrix3x2f.m10 = f10;
        matrix3x2f.m11 = f11;
        matrix3x2f.m20 = i2;
        matrix3x2f.m21 = i3;
        return matrix3x2f;
    }

    public Matrix3x2f mul(Matrix3x2fc matrix3x2fc, Matrix3x2f matrix3x2f) {
        float m012 = (matrix3x2fc.m01() * this.m10) + (matrix3x2fc.m00() * this.m00);
        float m013 = (matrix3x2fc.m01() * this.m11) + (matrix3x2fc.m00() * this.m01);
        float m112 = (matrix3x2fc.m11() * this.m10) + (matrix3x2fc.m10() * this.m00);
        float m113 = (matrix3x2fc.m11() * this.m11) + (matrix3x2fc.m10() * this.m01);
        float m212 = (matrix3x2fc.m21() * this.m10) + (matrix3x2fc.m20() * this.m00) + this.m20;
        float m213 = (matrix3x2fc.m21() * this.m11) + (matrix3x2fc.m20() * this.m01) + this.m21;
        matrix3x2f.m00 = m012;
        matrix3x2f.m01 = m013;
        matrix3x2f.m10 = m112;
        matrix3x2f.m11 = m113;
        matrix3x2f.m20 = m212;
        matrix3x2f.m21 = m213;
        return matrix3x2f;
    }

    public Matrix3x2f mulLocal(Matrix3x2fc matrix3x2fc, Matrix3x2f matrix3x2f) {
        float m102 = (matrix3x2fc.m10() * this.m01) + (matrix3x2fc.m00() * this.m00);
        float m112 = (matrix3x2fc.m11() * this.m01) + (matrix3x2fc.m01() * this.m00);
        float m103 = (matrix3x2fc.m10() * this.m11) + (matrix3x2fc.m00() * this.m10);
        float m113 = (matrix3x2fc.m11() * this.m11) + (matrix3x2fc.m01() * this.m10);
        float m202 = matrix3x2fc.m20() + (matrix3x2fc.m10() * this.m21) + (matrix3x2fc.m00() * this.m20);
        float m212 = matrix3x2fc.m21() + (matrix3x2fc.m11() * this.m21) + (matrix3x2fc.m01() * this.m20);
        matrix3x2f.m00 = m102;
        matrix3x2f.m01 = m112;
        matrix3x2f.m10 = m103;
        matrix3x2f.m11 = m113;
        matrix3x2f.m20 = m202;
        matrix3x2f.m21 = m212;
        return matrix3x2f;
    }

    public Matrix3x2f rotate(float f2, Matrix3x2f matrix3x2f) {
        double d2 = (double) f2;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f3 = -sin;
        float f4 = this.m00;
        float f5 = f4 * cos;
        float f6 = this.m10;
        float f7 = (f6 * sin) + f5;
        float f8 = this.m01;
        float f9 = f8 * cos;
        float f10 = this.m11;
        float f11 = (sin * f10) + f9;
        matrix3x2f.m10 = (f6 * cos) + (f4 * f3);
        matrix3x2f.m11 = (f10 * cos) + (f8 * f3);
        matrix3x2f.m00 = f7;
        matrix3x2f.m01 = f11;
        matrix3x2f.m20 = this.m20;
        matrix3x2f.m21 = this.m21;
        return matrix3x2f;
    }

    public Matrix3x2f rotateAbout(float f2, float f3, float f4, Matrix3x2f matrix3x2f) {
        float f5 = (this.m10 * f4) + (this.m00 * f3) + this.m20;
        float f6 = (this.m11 * f4) + (this.m01 * f3) + this.m21;
        double d2 = (double) f2;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        float f7 = this.m00;
        float f8 = f7 * cos;
        float f9 = this.m10;
        float f10 = (f9 * sin) + f8;
        float f11 = this.m01;
        float f12 = f11 * cos;
        float f13 = this.m11;
        float f14 = (f13 * sin) + f12;
        float f15 = -sin;
        float f16 = (f9 * cos) + (f7 * f15);
        matrix3x2f.m10 = f16;
        float f17 = (f13 * cos) + (f11 * f15);
        matrix3x2f.m11 = f17;
        matrix3x2f.m00 = f10;
        matrix3x2f.m01 = f14;
        float f18 = -f3;
        float f19 = -f4;
        matrix3x2f.m20 = a.f(f16, f19, f10 * f18, f5);
        matrix3x2f.m21 = a.f(f17, f19, f14 * f18, f6);
        return matrix3x2f;
    }

    public Matrix3x2f scaling(float f2, float f3) {
        this.m00 = f2;
        this.m01 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f3;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        return this;
    }

    public Matrix3x2f shearX(float f2, Matrix3x2f matrix3x2f) {
        float f3 = this.m00;
        float f4 = (f3 * f2) + this.m10;
        float f5 = this.m01;
        float f6 = (f2 * f5) + this.m11;
        matrix3x2f.m00 = f3;
        matrix3x2f.m01 = f5;
        matrix3x2f.m10 = f4;
        matrix3x2f.m11 = f6;
        matrix3x2f.m20 = this.m20;
        matrix3x2f.m21 = this.m21;
        return matrix3x2f;
    }

    public Matrix3x2f shearY(float f2, Matrix3x2f matrix3x2f) {
        float f3 = this.m00;
        float f4 = this.m10;
        float f5 = (f4 * f2) + f3;
        float f6 = this.m01;
        float f7 = this.m11;
        float f8 = (f2 * f7) + f6;
        matrix3x2f.m00 = f5;
        matrix3x2f.m01 = f8;
        matrix3x2f.m10 = f4;
        matrix3x2f.m11 = f7;
        matrix3x2f.m20 = this.m20;
        matrix3x2f.m21 = this.m21;
        return matrix3x2f;
    }

    public Vector3f transform(Vector3f vector3f, Vector3f vector3f2) {
        return vector3f.mul((Matrix3x2fc) this, vector3f2);
    }

    public Vector2f transformDirection(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.set((vector2fc.y() * this.m10) + (vector2fc.x() * this.m00), (vector2fc.y() * this.m11) + (vector2fc.x() * this.m01));
        return vector2f;
    }

    public Vector2f transformPosition(Vector2fc vector2fc, Vector2f vector2f) {
        vector2f.set((vector2fc.y() * this.m10) + (vector2fc.x() * this.m00) + this.m20, (vector2fc.y() * this.m11) + (vector2fc.x() * this.m01) + this.m21);
        return vector2f;
    }

    public Matrix3x2f translateLocal(Vector2fc vector2fc, Matrix3x2f matrix3x2f) {
        return translateLocal(vector2fc.x(), vector2fc.y(), matrix3x2f);
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer get3x3(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put3x3(this, 0, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer get4x4(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x4(this, 0, byteBuffer);
        return byteBuffer;
    }

    public Matrix3x2f setTranslation(Vector2f vector2f) {
        return setTranslation(vector2f.x, vector2f.y);
    }

    public Vector3f transform(float f2, float f3, float f4, Vector3f vector3f) {
        return vector3f.set((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2), (this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2), f4);
    }

    public Matrix3x2f translateLocal(float f2, float f3, Matrix3x2f matrix3x2f) {
        matrix3x2f.m00 = this.m00;
        matrix3x2f.m01 = this.m01;
        matrix3x2f.m10 = this.m10;
        matrix3x2f.m11 = this.m11;
        matrix3x2f.m20 = this.m20 + f2;
        matrix3x2f.m21 = this.m21 + f3;
        return matrix3x2f;
    }

    public Matrix3x2f(Matrix3x2fc matrix3x2fc) {
        if (matrix3x2fc instanceof Matrix3x2f) {
            MemUtil.INSTANCE.copy((Matrix3x2f) matrix3x2fc, this);
        } else {
            setMatrix3x2fc(matrix3x2fc);
        }
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer get3x3(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put3x3(this, i2, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer get4x4(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix3x2f set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.m00 = f2;
        this.m01 = f3;
        this.m10 = f4;
        this.m11 = f5;
        this.m20 = f6;
        this.m21 = f7;
        return this;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public float[] get3x3(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy3x3(this, fArr, i2);
        return fArr;
    }

    public float[] get4x4(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy4x4(this, fArr, i2);
        return fArr;
    }

    public Vector2f transformDirection(float f2, float f3, Vector2f vector2f) {
        return vector2f.set((this.m10 * f3) + (this.m00 * f2), (this.m11 * f3) + (this.m01 * f2));
    }

    public Vector2f transformPosition(float f2, float f3, Vector2f vector2f) {
        return vector2f.set((this.m10 * f3) + (this.m00 * f2) + this.m20, (this.m11 * f3) + (this.m01 * f2) + this.m21);
    }

    public float[] get(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(this, fArr, i2);
        return fArr;
    }

    public float[] get3x3(float[] fArr) {
        return get3x3(fArr, 0);
    }

    public float[] get4x4(float[] fArr) {
        return get4x4(fArr, 0);
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix3x2f scale(float f2, float f3) {
        return scale(f2, f3, this);
    }

    public Matrix3x2f scaleAroundLocal(float f2, float f3, float f4, Matrix3x2f matrix3x2f) {
        return scaleAroundLocal(f2, f2, f3, f4, matrix3x2f);
    }

    public Matrix3x2f scaleLocal(float f2, float f3) {
        return scaleLocal(f2, f3, this);
    }

    public Matrix3x2f translate(float f2, float f3) {
        return translate(f2, f3, this);
    }

    public Matrix3x2f translation(Vector2fc vector2fc) {
        return translation(vector2fc.x(), vector2fc.y());
    }

    public Matrix3x2f view(float f2, float f3, float f4, float f5) {
        return view(f2, f3, f4, f5, this);
    }

    public Matrix3x2f(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.m00 = f2;
        this.m01 = f3;
        this.m10 = f4;
        this.m11 = f5;
        this.m20 = f6;
        this.m21 = f7;
    }

    public Matrix3x2f scale(Vector2fc vector2fc) {
        return scale(vector2fc.x(), vector2fc.y(), this);
    }

    public Matrix3x2f scaleAroundLocal(float f2, float f3, float f4, float f5, float f6, float f7) {
        return scaleAroundLocal(f2, f3, f5, f6, this);
    }

    public Matrix3x2f scaleLocal(float f2, Matrix3x2f matrix3x2f) {
        return scaleLocal(f2, f2, matrix3x2f);
    }

    public Matrix3x2f translate(Vector2fc vector2fc, Matrix3x2f matrix3x2f) {
        return translate(vector2fc.x(), vector2fc.y(), matrix3x2f);
    }

    public boolean equals(Matrix3x2fc matrix3x2fc, float f2) {
        if (this == matrix3x2fc) {
            return true;
        }
        return matrix3x2fc != null && (matrix3x2fc instanceof Matrix3x2f) && Runtime.equals(this.m00, matrix3x2fc.m00(), f2) && Runtime.equals(this.m01, matrix3x2fc.m01(), f2) && Runtime.equals(this.m10, matrix3x2fc.m10(), f2) && Runtime.equals(this.m11, matrix3x2fc.m11(), f2) && Runtime.equals(this.m20, matrix3x2fc.m20(), f2) && Runtime.equals(this.m21, matrix3x2fc.m21(), f2);
    }

    public Matrix3x2f scale(Vector2fc vector2fc, Matrix3x2f matrix3x2f) {
        return scale(vector2fc.x(), vector2fc.y(), matrix3x2f);
    }

    public Matrix3x2f scaleAround(float f2, float f3, float f4, float f5) {
        return scaleAround(f2, f3, f4, f5, this);
    }

    public Matrix3x2f scaleAroundLocal(float f2, float f3, float f4) {
        return scaleAroundLocal(f2, f2, f3, f4, this);
    }

    public Matrix3x2f scaleLocal(float f2) {
        return scaleLocal(f2, f2, this);
    }

    public Matrix3x2f translate(Vector2fc vector2fc) {
        return translate(vector2fc.x(), vector2fc.y(), this);
    }

    public Matrix3x2f translateLocal(float f2, float f3) {
        return translateLocal(f2, f3, this);
    }

    public Matrix3x2f scale(float f2, Matrix3x2f matrix3x2f) {
        return scale(f2, f2, matrix3x2f);
    }

    public Matrix3x2f scaleAround(float f2, float f3, float f4, Matrix3x2f matrix3x2f) {
        return scaleAround(f2, f2, f3, f4, this);
    }

    public Matrix3x2f set(float[] fArr) {
        MemUtil.INSTANCE.copy(fArr, 0, this);
        return this;
    }

    public Matrix3x2f rotateTo(Vector2fc vector2fc, Vector2fc vector2fc2) {
        return rotateTo(vector2fc, vector2fc2, this);
    }

    public Matrix3x2f scale(float f2) {
        return scale(f2, f2);
    }

    public Matrix3x2f scaleAround(float f2, float f3, float f4) {
        return scaleAround(f2, f2, f3, f4, this);
    }

    public Matrix3x2f set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        return this;
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
        return a.a(numberFormat, (double) this.m21, sb, str2);
    }

    public Matrix3x2f rotateLocal(float f2) {
        return rotateLocal(f2, this);
    }

    public Matrix3x2f set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        return this;
    }

    public Matrix3x2f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
    }
}
