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
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix3x2d implements Matrix3x2dc, Externalizable {
    public static final long serialVersionUID = 1;
    public double m00;
    public double m01;
    public double m10;
    public double m11;
    public double m20;
    public double m21;

    public Matrix3x2d() {
        this.m00 = 1.0d;
        this.m11 = 1.0d;
    }

    private void setMatrix3x2dc(Matrix3x2dc matrix3x2dc) {
        this.m00 = matrix3x2dc.m00();
        this.m01 = matrix3x2dc.m01();
        this.m10 = matrix3x2dc.m10();
        this.m11 = matrix3x2dc.m11();
        this.m20 = matrix3x2dc.m20();
        this.m21 = matrix3x2dc.m21();
    }

    public Matrix3x2d _m00(double d2) {
        this.m00 = d2;
        return this;
    }

    public Matrix3x2d _m01(double d2) {
        this.m01 = d2;
        return this;
    }

    public Matrix3x2d _m10(double d2) {
        this.m10 = d2;
        return this;
    }

    public Matrix3x2d _m11(double d2) {
        this.m11 = d2;
        return this;
    }

    public Matrix3x2d _m20(double d2) {
        this.m20 = d2;
        return this;
    }

    public Matrix3x2d _m21(double d2) {
        this.m21 = d2;
        return this;
    }

    public double determinant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix3x2d matrix3x2d = (Matrix3x2d) obj;
        return Double.doubleToLongBits(this.m00) == Double.doubleToLongBits(matrix3x2d.m00) && Double.doubleToLongBits(this.m01) == Double.doubleToLongBits(matrix3x2d.m01) && Double.doubleToLongBits(this.m10) == Double.doubleToLongBits(matrix3x2d.m10) && Double.doubleToLongBits(this.m11) == Double.doubleToLongBits(matrix3x2d.m11) && Double.doubleToLongBits(this.m20) == Double.doubleToLongBits(matrix3x2d.m20) && Double.doubleToLongBits(this.m21) == Double.doubleToLongBits(matrix3x2d.m21);
    }

    public Matrix3x2d get(Matrix3x2d matrix3x2d) {
        return matrix3x2d.set((Matrix3x2dc) this);
    }

    public DoubleBuffer get3x3(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put3x3(this, 0, doubleBuffer);
        return doubleBuffer;
    }

    public DoubleBuffer get4x4(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put4x4(this, 0, doubleBuffer);
        return doubleBuffer;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.m00);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.m01);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.m10);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.m11);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.m20);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.m21);
        return (i6 * 31) + ((int) ((doubleToLongBits6 >>> 32) ^ doubleToLongBits6));
    }

    public Matrix3x2d identity() {
        MemUtil.INSTANCE.identity(this);
        return this;
    }

    public Matrix3x2d invert() {
        return invert(this);
    }

    public double m00() {
        return this.m00;
    }

    public double m01() {
        return this.m01;
    }

    public double m10() {
        return this.m10;
    }

    public double m11() {
        return this.m11;
    }

    public double m20() {
        return this.m20;
    }

    public double m21() {
        return this.m21;
    }

    public Matrix3x2d mul(Matrix3x2dc matrix3x2dc) {
        return mul(matrix3x2dc, this);
    }

    public Matrix3x2d mulLocal(Matrix3x2dc matrix3x2dc) {
        return mulLocal(matrix3x2dc, this);
    }

    public Vector2d normalizedPositiveX(Vector2d vector2d) {
        vector2d.x = this.m11;
        vector2d.y = -this.m01;
        return vector2d;
    }

    public Vector2d normalizedPositiveY(Vector2d vector2d) {
        vector2d.x = -this.m10;
        vector2d.y = this.m00;
        return vector2d;
    }

    public Vector2d origin(Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = 1.0d / (d4 - (d5 * d6));
        double d8 = this.m21;
        double d9 = d6 * d8;
        double d10 = this.m20;
        double d11 = d10;
        double d12 = d8;
        vector2d2.x = a.c(d3, d10, d9, d7);
        vector2d2.y = a.c(d2, d12, d11 * d5, d7);
        return vector2d2;
    }

    public Vector2d positiveX(Vector2d vector2d) {
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = 1.0d / (d4 - (this.m10 * d5));
        vector2d.x = d3 * d6;
        vector2d.y = (-d5) * d6;
        return vector2d.normalize(vector2d);
    }

    public Vector2d positiveY(Vector2d vector2d) {
        double d2 = this.m00;
        double d3 = this.m11 * d2;
        double d4 = this.m01;
        double d5 = this.m10;
        double d6 = 1.0d / (d3 - (d4 * d5));
        vector2d.x = (-d5) * d6;
        vector2d.y = d2 * d6;
        return vector2d.normalize(vector2d);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readDouble();
        this.m01 = objectInput.readDouble();
        this.m10 = objectInput.readDouble();
        this.m11 = objectInput.readDouble();
        this.m20 = objectInput.readDouble();
        this.m21 = objectInput.readDouble();
    }

    public Matrix3x2d rotate(double d2) {
        return rotate(d2, this);
    }

    public Matrix3x2d rotateAbout(double d2, double d3, double d4) {
        return rotateAbout(d2, d3, d4, this);
    }

    public Matrix3x2d rotateLocal(double d2, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
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
        matrix3x2d2.m00 = d6;
        matrix3x2d2.m01 = d7;
        matrix3x2d2.m10 = d17;
        matrix3x2d2.m11 = d15;
        matrix3x2d2.m20 = d18;
        matrix3x2d2.m21 = d19;
        return matrix3x2d2;
    }

    public Matrix3x2d rotateTo(Vector2dc vector2dc, Vector2dc vector2dc2, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double y = (vector2dc2.y() * vector2dc.y()) + (vector2dc2.x() * vector2dc.x());
        double y2 = (vector2dc2.y() * vector2dc.x()) - (vector2dc2.x() * vector2dc.y());
        double d2 = -y2;
        double d3 = this.m00;
        double d4 = d3 * y;
        double d5 = this.m10;
        double d6 = (d5 * y2) + d4;
        double d7 = this.m01;
        double d8 = d7 * y;
        double d9 = d6;
        double d10 = this.m11;
        double d11 = (y2 * d10) + d8;
        matrix3x2d2.m10 = (d5 * y) + (d3 * d2);
        matrix3x2d2.m11 = (d10 * y) + (d7 * d2);
        matrix3x2d2.m00 = d9;
        matrix3x2d2.m01 = d11;
        matrix3x2d2.m20 = this.m20;
        matrix3x2d2.m21 = this.m21;
        return matrix3x2d2;
    }

    public Matrix3x2d rotation(double d2) {
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        this.m00 = cos;
        this.m10 = -sin;
        this.m20 = 0.0d;
        this.m01 = sin;
        this.m11 = cos;
        this.m21 = 0.0d;
        return this;
    }

    public Matrix3x2d scale(double d2, double d3, Matrix3x2d matrix3x2d) {
        matrix3x2d.m00 = this.m00 * d2;
        matrix3x2d.m01 = this.m01 * d2;
        matrix3x2d.m10 = this.m10 * d3;
        matrix3x2d.m11 = this.m11 * d3;
        matrix3x2d.m20 = this.m20;
        matrix3x2d.m21 = this.m21;
        return matrix3x2d;
    }

    public Matrix3x2d scaleAround(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double d6 = this.m00;
        double d7 = d6 * d4;
        double d8 = this.m10;
        double d9 = (d8 * d5) + d7 + this.m20;
        double d10 = this.m01;
        double d11 = d10 * d4;
        double d12 = this.m11;
        double d13 = this.m21 + (d12 * d5) + d11;
        matrix3x2d2.m00 = d6 * d2;
        matrix3x2d2.m01 = d10 * d2;
        matrix3x2d2.m10 = d8 * d3;
        matrix3x2d2.m11 = d12 * d3;
        double d14 = d5;
        matrix3x2d2.m20 = a.m(this.m10, d14, (-this.m00) * d4, d9);
        matrix3x2d2.m21 = a.m(this.m11, d14, (-this.m01) * d4, d13);
        return matrix3x2d2;
    }

    public Matrix3x2d scaleAroundLocal(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        matrix3x2d2.m00 = this.m00 * d2;
        matrix3x2d2.m01 = this.m01 * d3;
        matrix3x2d2.m10 = this.m10 * d2;
        matrix3x2d2.m11 = this.m11 * d3;
        matrix3x2d2.m20 = a.m(d2, d4, this.m20 * d2, d4);
        matrix3x2d2.m21 = a.m(d3, d5, this.m21 * d3, d5);
        return matrix3x2d2;
    }

    public Matrix3x2d scaleLocal(double d2, double d3, Matrix3x2d matrix3x2d) {
        matrix3x2d.m00 = this.m00 * d2;
        matrix3x2d.m01 = this.m01 * d3;
        matrix3x2d.m10 = this.m10 * d2;
        matrix3x2d.m11 = this.m11 * d3;
        matrix3x2d.m20 = d2 * this.m20;
        matrix3x2d.m21 = d3 * this.m21;
        return matrix3x2d;
    }

    public Matrix3x2d scaling(double d2) {
        return scaling(d2, d2);
    }

    public Matrix3x2d set(Matrix3x2dc matrix3x2dc) {
        if (matrix3x2dc instanceof Matrix3x2d) {
            MemUtil.INSTANCE.copy((Matrix3x2d) matrix3x2dc, this);
        } else {
            setMatrix3x2dc(matrix3x2dc);
        }
        return this;
    }

    public Matrix3x2d setTranslation(double d2, double d3) {
        this.m20 = d2;
        this.m21 = d3;
        return this;
    }

    public Matrix3x2d setView(double d2, double d3, double d4, double d5) {
        this.m00 = 2.0d / (d3 - d2);
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 2.0d / (d5 - d4);
        this.m20 = (d2 + d3) / (d2 - d3);
        this.m21 = (d4 + d5) / (d4 - d5);
        return this;
    }

    public Matrix3x2d span(Vector2d vector2d, Vector2d vector2d2, Vector2d vector2d3) {
        Vector2d vector2d4 = vector2d;
        Vector2d vector2d5 = vector2d2;
        Vector2d vector2d6 = vector2d3;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = 1.0d / (d4 - (d5 * d6));
        double d8 = d3 * d7;
        double d9 = (-d5) * d7;
        double d10 = (-d6) * d7;
        double d11 = d2 * d7;
        double d12 = (-d8) - d10;
        double d13 = this.m21;
        double d14 = d6 * d13;
        double d15 = this.m20;
        double d16 = d2;
        double d17 = d9;
        double d18 = d13;
        double d19 = d8;
        double d20 = d5;
        vector2d4.x = a.a(d3, d15, d14, d7, d12);
        double d21 = d15 * d20;
        double d22 = d17;
        vector2d4.y = a.a(d16, d18, d21, d7, (-d17) - d11);
        Vector2d vector2d7 = vector2d2;
        vector2d7.x = d19 * 2.0d;
        vector2d7.y = d22 * 2.0d;
        Vector2d vector2d8 = vector2d3;
        vector2d8.x = d10 * 2.0d;
        vector2d8.y = d11 * 2.0d;
        return this;
    }

    public boolean testAar(double d2, double d3, double d4, double d5) {
        double d6 = this.m00;
        double d7 = this.m10;
        double d8 = this.m20;
        double d9 = d8 + 1.0d;
        double d10 = -d6;
        double d11 = -d7;
        double d12 = 1.0d - d8;
        double d13 = this.m01;
        double d14 = d12;
        double d15 = this.m11;
        double d16 = d11;
        double d17 = this.m21;
        double d18 = d10;
        double d19 = d17 + 1.0d;
        double d20 = -d13;
        double d21 = -d15;
        double d22 = 1.0d - d17;
        if ((d7 * (d7 < 0.0d ? d3 : d5)) + (d6 * (d6 < 0.0d ? d2 : d4)) >= (-d9)) {
            if (((d16 < 0.0d ? d3 : d5) * d16) + ((d18 < 0.0d ? d2 : d4) * d18) >= (-d14)) {
                if ((d15 * (d15 < 0.0d ? d3 : d5)) + (d13 * (d13 < 0.0d ? d2 : d4)) >= (-d19)) {
                    if ((d21 * (d21 < 0.0d ? d3 : d5)) + ((d20 < 0.0d ? d2 : d4) * d20) >= (-d22)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean testCircle(double d2, double d3, double d4) {
        double d5 = this.m00;
        double d6 = this.m10;
        double d7 = this.m20 + 1.0d;
        double e2 = a.e(d6, d6, d5 * d5, 1.0d);
        double d8 = d5 * e2;
        double d9 = d6 * e2;
        double d10 = d7 * e2;
        double d11 = -this.m00;
        double d12 = -this.m10;
        double d13 = 1.0d - this.m20;
        double e3 = a.e(d12, d12, d11 * d11, 1.0d);
        double d14 = d11 * e3;
        double d15 = d12 * e3;
        double d16 = d13 * e3;
        double d17 = this.m01;
        double d18 = this.m11;
        double d19 = this.m21 + 1.0d;
        double e4 = a.e(d18, d18, d17 * d17, 1.0d);
        double d20 = d17 * e4;
        double d21 = -this.m01;
        double d22 = d19 * e4;
        double d23 = -this.m11;
        double d24 = d18 * e4;
        double d25 = 1.0d - this.m21;
        double e5 = a.e(d23, d23, d21 * d21, 1.0d);
        double d26 = d21 * e5;
        double d27 = d23 * e5;
        double d28 = d25 * e5;
        double d29 = -d4;
        if (a.i(d9, d3, d8 * d2, d10) >= d29) {
            double d30 = d29;
            if (a.i(d15, d3, d14 * d2, d16) >= d30) {
                if (a.i(d24, d3, d20 * d2, d22) >= d30) {
                    if (a.i(d27, d3, d26 * d2, d28) >= d30) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean testPoint(double d2, double d3) {
        double d4 = this.m00;
        double d5 = this.m10;
        double d6 = this.m20;
        double d7 = d6 + 1.0d;
        double d8 = -d4;
        double d9 = -d5;
        double d10 = 1.0d - d6;
        double d11 = this.m01;
        double d12 = this.m11;
        double d13 = d9;
        double d14 = this.m21;
        double d15 = d14 + 1.0d;
        double d16 = d8;
        double d17 = -d11;
        double d18 = -d12;
        double d19 = 1.0d - d14;
        double d20 = d12;
        double d21 = d11;
        if (a.i(d5, d3, d4 * d2, d7) >= 0.0d) {
            if (a.i(d13, d3, d16 * d2, d10) >= 0.0d) {
                if (a.i(d20, d3, d21 * d2, d15) >= 0.0d) {
                    if (a.i(d18, d3, d17 * d2, d19) >= 0.0d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String matrix3x2d = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix3x2d.length(); i3++) {
            char charAt = matrix3x2d.charAt(i3);
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
        return vector3d.mul((Matrix3x2dc) this);
    }

    public Vector2d transformDirection(Vector2d vector2d) {
        double d2 = this.m00;
        double d3 = vector2d.x;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = vector2d.y;
        vector2d.set((d5 * d6) + d4, (this.m11 * d6) + (this.m01 * d3));
        return vector2d;
    }

    public Vector2d transformPosition(Vector2d vector2d) {
        double d2 = this.m00;
        double d3 = vector2d.x;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = vector2d.y;
        vector2d.set((d5 * d6) + d4 + this.m20, (this.m11 * d6) + (this.m01 * d3) + this.m21);
        return vector2d;
    }

    public Matrix3x2d translate(double d2, double d3, Matrix3x2d matrix3x2d) {
        double d4 = this.m00;
        double d5 = d4 * d2;
        double d6 = this.m10;
        matrix3x2d.m20 = (d6 * d3) + d5 + this.m20;
        double d7 = this.m01;
        double d8 = d2 * d7;
        double d9 = this.m11;
        matrix3x2d.m21 = (d3 * d9) + d8 + this.m21;
        matrix3x2d.m00 = d4;
        matrix3x2d.m01 = d7;
        matrix3x2d.m10 = d6;
        matrix3x2d.m11 = d9;
        return matrix3x2d;
    }

    public Matrix3x2d translateLocal(Vector2dc vector2dc) {
        return translateLocal(vector2dc.x(), vector2dc.y());
    }

    public Matrix3x2d translation(double d2, double d3) {
        this.m00 = 1.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 1.0d;
        this.m20 = d2;
        this.m21 = d3;
        return this;
    }

    public Vector2d unproject(double d2, double d3, int[] iArr, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d4 = this.m00;
        double d5 = this.m11;
        double d6 = d4 * d5;
        double d7 = this.m01;
        double d8 = this.m10;
        double d9 = 1.0d / (d6 - (d7 * d8));
        double d10 = d5 * d9;
        double d11 = (-d7) * d9;
        double d12 = (-d8) * d9;
        double d13 = d4 * d9;
        double d14 = this.m21;
        double d15 = d8 * d14;
        double d16 = this.m20;
        double d17 = d16;
        double d18 = d14;
        double c2 = a.c(d5, d16, d15, d9);
        double c3 = a.c(d4, d18, d17 * d7, d9);
        double d19 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d20 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        vector2d2.x = a.i(d12, d20, d10 * d19, c2);
        vector2d2.y = a.i(d13, d20, d11 * d19, c3);
        return vector2d2;
    }

    public Vector2d unprojectInv(double d2, double d3, int[] iArr, Vector2d vector2d) {
        double d4 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d5 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        vector2d.x = (this.m10 * d5) + (this.m00 * d4) + this.m20;
        vector2d.y = (this.m11 * d5) + (this.m01 * d4) + this.m21;
        return vector2d;
    }

    public Matrix3x2d view(double d2, double d3, double d4, double d5, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double d6 = 2.0d / (d3 - d2);
        double d7 = 2.0d / (d5 - d4);
        double d8 = (d2 + d3) / (d2 - d3);
        double d9 = (d4 + d5) / (d4 - d5);
        double d10 = this.m00;
        double d11 = d10 * d8;
        double d12 = this.m10;
        matrix3x2d2.m20 = (d12 * d9) + d11 + this.m20;
        double d13 = this.m01;
        double d14 = d8 * d13;
        double d15 = d7;
        double d16 = this.m11;
        matrix3x2d2.m21 = (d9 * d16) + d14 + this.m21;
        matrix3x2d2.m00 = d10 * d6;
        matrix3x2d2.m01 = d13 * d6;
        matrix3x2d2.m10 = d12 * d15;
        matrix3x2d2.m11 = d16 * d15;
        return matrix3x2d2;
    }

    public double[] viewArea(double[] dArr) {
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = 1.0d / (d4 - (d5 * d6));
        double d8 = d3 * d7;
        double d9 = (-d5) * d7;
        double d10 = (-d6) * d7;
        double d11 = d2 * d7;
        double d12 = this.m21;
        double d13 = d6 * d12;
        double d14 = d2;
        double d15 = this.m20;
        double d16 = d9;
        double d17 = d12;
        double d18 = d8;
        double c2 = a.c(d3, d15, d13, d7);
        double c3 = a.c(d14, d17, d15 * d5, d7);
        double d19 = d18;
        double d20 = -d19;
        double d21 = d20 - d10;
        double d22 = d16;
        double d23 = -d22;
        double d24 = d23 - d11;
        double d25 = d19 - d10;
        double d26 = d22 - d11;
        double d27 = d20 + d10;
        double d28 = d23 + d11;
        double d29 = d19 + d10;
        double d30 = d22 + d11;
        double d31 = d21 < d27 ? d21 : d27;
        if (d31 >= d25) {
            d31 = d25;
        }
        if (d31 >= d29) {
            d31 = d29;
        }
        double d32 = d24 < d28 ? d24 : d28;
        if (d32 >= d26) {
            d32 = d26;
        }
        if (d32 >= d30) {
            d32 = d30;
        }
        if (d21 <= d27) {
            d21 = d27;
        }
        if (d21 > d25) {
            d25 = d21;
        }
        if (d25 > d29) {
            d29 = d25;
        }
        if (d24 <= d28) {
            d24 = d28;
        }
        if (d24 > d26) {
            d26 = d24;
        }
        if (d26 > d30) {
            d30 = d26;
        }
        dArr[0] = d31 + c2;
        dArr[1] = d32 + c3;
        dArr[2] = d29 + c2;
        dArr[3] = d30 + c3;
        return dArr;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.m00);
        objectOutput.writeDouble(this.m01);
        objectOutput.writeDouble(this.m10);
        objectOutput.writeDouble(this.m11);
        objectOutput.writeDouble(this.m20);
        objectOutput.writeDouble(this.m21);
    }

    public Matrix3x2d zero() {
        MemUtil.INSTANCE.zero(this);
        return this;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public DoubleBuffer get3x3(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put3x3(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public DoubleBuffer get4x4(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Matrix3x2d invert(Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = 1.0d / (d4 - (d5 * d6));
        double d8 = d3 * d7;
        double d9 = (-d5) * d7;
        double d10 = (-d6) * d7;
        double d11 = d5;
        double d12 = d2 * d7;
        double d13 = this.m21;
        double d14 = d6 * d13;
        double d15 = d13;
        double d16 = this.m20;
        double d17 = d10;
        double d18 = d9;
        double d19 = d8;
        double c2 = a.c(d3, d16, d14, d7);
        double c3 = a.c(d2, d15, d16 * d11, d7);
        double d20 = d19;
        Matrix3x2d matrix3x2d3 = matrix3x2d;
        matrix3x2d3.m00 = d20;
        matrix3x2d3.m01 = d18;
        matrix3x2d3.m10 = d17;
        matrix3x2d3.m11 = d12;
        matrix3x2d3.m20 = c2;
        matrix3x2d3.m21 = c3;
        return matrix3x2d3;
    }

    public Matrix3x2d mul(Matrix3x2dc matrix3x2dc, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double m012 = (matrix3x2dc.m01() * this.m10) + (matrix3x2dc.m00() * this.m00);
        double m013 = (matrix3x2dc.m01() * this.m11) + (matrix3x2dc.m00() * this.m01);
        double m112 = (matrix3x2dc.m11() * this.m10) + (matrix3x2dc.m10() * this.m00);
        double m113 = (matrix3x2dc.m11() * this.m11) + (matrix3x2dc.m10() * this.m01);
        double m212 = (matrix3x2dc.m21() * this.m10) + (matrix3x2dc.m20() * this.m00) + this.m20;
        double m213 = (matrix3x2dc.m21() * this.m11) + (matrix3x2dc.m20() * this.m01) + this.m21;
        matrix3x2d2.m00 = m012;
        matrix3x2d2.m01 = m013;
        matrix3x2d2.m10 = m112;
        matrix3x2d2.m11 = m113;
        matrix3x2d2.m20 = m212;
        matrix3x2d2.m21 = m213;
        return matrix3x2d2;
    }

    public Matrix3x2d mulLocal(Matrix3x2dc matrix3x2dc, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double m102 = (matrix3x2dc.m10() * this.m01) + (matrix3x2dc.m00() * this.m00);
        double m112 = (matrix3x2dc.m11() * this.m01) + (matrix3x2dc.m01() * this.m00);
        double m103 = (matrix3x2dc.m10() * this.m11) + (matrix3x2dc.m00() * this.m10);
        double m113 = (matrix3x2dc.m11() * this.m11) + (matrix3x2dc.m01() * this.m10);
        double m202 = matrix3x2dc.m20() + (matrix3x2dc.m10() * this.m21) + (matrix3x2dc.m00() * this.m20);
        double d2 = m202;
        double m212 = matrix3x2dc.m21() + (matrix3x2dc.m11() * this.m21) + (matrix3x2dc.m01() * this.m20);
        matrix3x2d2.m00 = m102;
        matrix3x2d2.m01 = m112;
        matrix3x2d2.m10 = m103;
        matrix3x2d2.m11 = m113;
        matrix3x2d2.m20 = d2;
        matrix3x2d2.m21 = m212;
        return matrix3x2d2;
    }

    public Matrix3x2d rotate(double d2, Matrix3x2d matrix3x2d) {
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double d3 = -sin;
        double d4 = this.m00;
        double d5 = d4 * cos;
        double d6 = this.m10;
        double d7 = (d6 * sin) + d5;
        double d8 = this.m01;
        double d9 = d8 * cos;
        double d10 = d7;
        double d11 = this.m11;
        double d12 = (sin * d11) + d9;
        matrix3x2d2.m10 = (d6 * cos) + (d4 * d3);
        matrix3x2d2.m11 = (d11 * cos) + (d8 * d3);
        matrix3x2d2.m00 = d10;
        matrix3x2d2.m01 = d12;
        matrix3x2d2.m20 = this.m20;
        matrix3x2d2.m21 = this.m21;
        return matrix3x2d2;
    }

    public Matrix3x2d rotateAbout(double d2, double d3, double d4, Matrix3x2d matrix3x2d) {
        double d5 = d3;
        double d6 = d4;
        Matrix3x2d matrix3x2d2 = matrix3x2d;
        double d7 = (this.m10 * d6) + (this.m00 * d5) + this.m20;
        double d8 = (this.m11 * d6) + (this.m01 * d5) + this.m21;
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double d9 = this.m00;
        double d10 = d9 * cos;
        double d11 = this.m10;
        double d12 = (d11 * sin) + d10;
        double d13 = this.m01;
        double d14 = d13 * cos;
        double d15 = this.m11;
        double d16 = d12;
        double d17 = (d15 * sin) + d14;
        double d18 = -sin;
        double d19 = (d9 * d18) + (d11 * cos);
        matrix3x2d2.m10 = d19;
        double d20 = (d15 * cos) + (d13 * d18);
        matrix3x2d2.m11 = d20;
        double d21 = d16;
        matrix3x2d2.m00 = d21;
        matrix3x2d2.m01 = d17;
        double d22 = -d3;
        double d23 = d21 * d22;
        double d24 = -d4;
        double d25 = d17;
        matrix3x2d2.m20 = a.i(d19, d24, d23, d7);
        matrix3x2d2.m21 = a.i(d20, d24, d25 * d22, d8);
        return matrix3x2d2;
    }

    public Matrix3x2d scaling(double d2, double d3) {
        this.m00 = d2;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = d3;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        return this;
    }

    public Vector3d transform(Vector3dc vector3dc, Vector3d vector3d) {
        return vector3dc.mul((Matrix3x2dc) this, vector3d);
    }

    public Vector2d transformDirection(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.set((vector2dc.y() * this.m10) + (vector2dc.x() * this.m00), (vector2dc.y() * this.m11) + (vector2dc.x() * this.m01));
        return vector2d;
    }

    public Vector2d transformPosition(Vector2dc vector2dc, Vector2d vector2d) {
        vector2d.set((vector2dc.y() * this.m10) + (vector2dc.x() * this.m00) + this.m20, (vector2dc.y() * this.m11) + (vector2dc.x() * this.m01) + this.m21);
        return vector2d;
    }

    public Matrix3x2d translateLocal(Vector2dc vector2dc, Matrix3x2d matrix3x2d) {
        return translateLocal(vector2dc.x(), vector2dc.y(), matrix3x2d);
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public ByteBuffer get3x3(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put3x3(this, 0, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer get4x4(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x4(this, 0, byteBuffer);
        return byteBuffer;
    }

    public Matrix3x2d setTranslation(Vector2dc vector2dc) {
        return setTranslation(vector2dc.x(), vector2dc.y());
    }

    public Vector3d transform(double d2, double d3, double d4, Vector3d vector3d) {
        return vector3d.set((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2), (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2), d4);
    }

    public Matrix3x2d translateLocal(double d2, double d3, Matrix3x2d matrix3x2d) {
        matrix3x2d.m00 = this.m00;
        matrix3x2d.m01 = this.m01;
        matrix3x2d.m10 = this.m10;
        matrix3x2d.m11 = this.m11;
        matrix3x2d.m20 = this.m20 + d2;
        matrix3x2d.m21 = this.m21 + d3;
        return matrix3x2d;
    }

    public Matrix3x2d(Matrix3x2dc matrix3x2dc) {
        if (matrix3x2dc instanceof Matrix3x2d) {
            MemUtil.INSTANCE.copy((Matrix3x2d) matrix3x2dc, this);
        } else {
            setMatrix3x2dc(matrix3x2dc);
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

    public Matrix3x2d set(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.m00 = d2;
        this.m01 = d3;
        this.m10 = d4;
        this.m11 = d5;
        this.m20 = d6;
        this.m21 = d7;
        return this;
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public double[] get3x3(double[] dArr, int i2) {
        MemUtil.INSTANCE.copy3x3(this, dArr, i2);
        return dArr;
    }

    public double[] get4x4(double[] dArr, int i2) {
        MemUtil.INSTANCE.copy4x4(this, dArr, i2);
        return dArr;
    }

    public Vector2d transformDirection(double d2, double d3, Vector2d vector2d) {
        return vector2d.set((this.m10 * d3) + (this.m00 * d2), (this.m11 * d3) + (this.m01 * d2));
    }

    public Vector2d transformPosition(double d2, double d3, Vector2d vector2d) {
        return vector2d.set((this.m10 * d3) + (this.m00 * d2) + this.m20, (this.m11 * d3) + (this.m01 * d2) + this.m21);
    }

    public double[] get(double[] dArr, int i2) {
        MemUtil.INSTANCE.copy(this, dArr, i2);
        return dArr;
    }

    public double[] get3x3(double[] dArr) {
        return get3x3(dArr, 0);
    }

    public double[] get4x4(double[] dArr) {
        return get4x4(dArr, 0);
    }

    public double[] get(double[] dArr) {
        return get(dArr, 0);
    }

    public Matrix3x2d scale(double d2, double d3) {
        return scale(d2, d3, this);
    }

    public Matrix3x2d scaleAroundLocal(double d2, double d3, double d4, Matrix3x2d matrix3x2d) {
        return scaleAroundLocal(d2, d2, d3, d4, matrix3x2d);
    }

    public Matrix3x2d scaleLocal(double d2, double d3) {
        return scaleLocal(d2, d3, this);
    }

    public Matrix3x2d translate(double d2, double d3) {
        return translate(d2, d3, this);
    }

    public Matrix3x2d translation(Vector2dc vector2dc) {
        return translation(vector2dc.x(), vector2dc.y());
    }

    public Matrix3x2d view(double d2, double d3, double d4, double d5) {
        return view(d2, d3, d4, d5, this);
    }

    public Matrix3x2d(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.m00 = d2;
        this.m01 = d3;
        this.m10 = d4;
        this.m11 = d5;
        this.m20 = d6;
        this.m21 = d7;
    }

    public Matrix3x2d scale(Vector2dc vector2dc) {
        return scale(vector2dc.x(), vector2dc.y(), this);
    }

    public Matrix3x2d scaleAroundLocal(double d2, double d3, double d4, double d5, double d6, double d7) {
        return scaleAroundLocal(d2, d3, d5, d6, this);
    }

    public Matrix3x2d scaleLocal(double d2, Matrix3x2d matrix3x2d) {
        return scaleLocal(d2, d2, matrix3x2d);
    }

    public Matrix3x2d translate(Vector2dc vector2dc, Matrix3x2d matrix3x2d) {
        return translate(vector2dc.x(), vector2dc.y(), matrix3x2d);
    }

    public boolean equals(Matrix3x2dc matrix3x2dc, double d2) {
        if (this == matrix3x2dc) {
            return true;
        }
        return matrix3x2dc != null && (matrix3x2dc instanceof Matrix3x2d) && Runtime.equals(this.m00, matrix3x2dc.m00(), d2) && Runtime.equals(this.m01, matrix3x2dc.m01(), d2) && Runtime.equals(this.m10, matrix3x2dc.m10(), d2) && Runtime.equals(this.m11, matrix3x2dc.m11(), d2) && Runtime.equals(this.m20, matrix3x2dc.m20(), d2) && Runtime.equals(this.m21, matrix3x2dc.m21(), d2);
    }

    public Matrix3x2d scale(Vector2dc vector2dc, Matrix3x2d matrix3x2d) {
        return scale(vector2dc.x(), vector2dc.y(), matrix3x2d);
    }

    public Matrix3x2d scaleAround(double d2, double d3, double d4, double d5) {
        return scaleAround(d2, d3, d4, d5, this);
    }

    public Matrix3x2d scaleAroundLocal(double d2, double d3, double d4) {
        return scaleAroundLocal(d2, d2, d3, d4, this);
    }

    public Matrix3x2d scaleLocal(double d2) {
        return scaleLocal(d2, d2, this);
    }

    public Matrix3x2d translate(Vector2dc vector2dc) {
        return translate(vector2dc.x(), vector2dc.y(), this);
    }

    public Matrix3x2d translateLocal(double d2, double d3) {
        return translateLocal(d2, d3, this);
    }

    public Matrix3x2d scale(Vector2fc vector2fc) {
        return scale((double) vector2fc.x(), (double) vector2fc.y(), this);
    }

    public Matrix3x2d scaleAround(double d2, double d3, double d4, Matrix3x2d matrix3x2d) {
        return scaleAround(d2, d2, d3, d4, this);
    }

    public Matrix3x2d set(double[] dArr) {
        MemUtil.INSTANCE.copy(dArr, 0, this);
        return this;
    }

    public Matrix3x2d rotateTo(Vector2dc vector2dc, Vector2dc vector2dc2) {
        return rotateTo(vector2dc, vector2dc2, this);
    }

    public Matrix3x2d scale(Vector2fc vector2fc, Matrix3x2d matrix3x2d) {
        return scale((double) vector2fc.x(), (double) vector2fc.y(), matrix3x2d);
    }

    public Matrix3x2d scaleAround(double d2, double d3, double d4) {
        return scaleAround(d2, d2, d3, d4, this);
    }

    public Matrix3x2d set(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
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
        return a.a(numberFormat, this.m21, sb, str2);
    }

    public Matrix3x2d rotateLocal(double d2) {
        return rotateLocal(d2, this);
    }

    public Matrix3x2d scale(double d2, Matrix3x2d matrix3x2d) {
        return scale(d2, d2, matrix3x2d);
    }

    public Matrix3x2d scale(double d2) {
        return scale(d2, d2);
    }

    public Matrix3x2d set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        return this;
    }

    public Matrix3x2d(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
    }
}
