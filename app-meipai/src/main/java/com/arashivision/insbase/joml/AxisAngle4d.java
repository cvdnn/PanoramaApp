package com.arashivision.insbase.joml;

import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AxisAngle4d implements Externalizable {
    public static final long serialVersionUID = 1;
    public double angle;
    public double x;
    public double y;
    public double z;

    public AxisAngle4d() {
        this.z = 1.0d;
    }

    public static double safeAcos(double d2) {
        if (d2 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d2 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AxisAngle4d.class != obj.getClass()) {
            return false;
        }
        AxisAngle4d axisAngle4d = (AxisAngle4d) obj;
        double d2 = this.angle;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        long doubleToLongBits = Double.doubleToLongBits(d2 % 6.283185307179586d);
        double d3 = axisAngle4d.angle;
        if (d3 < 0.0d) {
            d3 = (d3 % 6.283185307179586d) + 6.283185307179586d;
        }
        return doubleToLongBits == Double.doubleToLongBits(d3 % 6.283185307179586d) && Double.doubleToLongBits(this.x) == Double.doubleToLongBits(axisAngle4d.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(axisAngle4d.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(axisAngle4d.z);
    }

    public Quaternionf get(Quaternionf quaternionf) {
        return quaternionf.set(this);
    }

    public int hashCode() {
        double d2 = this.angle;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        long doubleToLongBits = Double.doubleToLongBits(d2 % 6.283185307179586d);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.x);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.y);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.z);
        return (i4 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public AxisAngle4d normalize() {
        double d2 = this.x;
        double d3 = d2 * d2;
        double d4 = this.y;
        double d5 = (d4 * d4) + d3;
        double d6 = this.z;
        double e2 = a.e(d6, d6, d5, 1.0d);
        this.x *= e2;
        this.y *= e2;
        this.z *= e2;
        return this;
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.angle = objectInput.readDouble();
        this.x = objectInput.readDouble();
        this.y = objectInput.readDouble();
        this.z = objectInput.readDouble();
    }

    public AxisAngle4d rotate(double d2) {
        double d3 = this.angle + d2;
        this.angle = d3;
        if (d3 < 0.0d) {
            d3 = (d3 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d3 % 6.283185307179586d;
        return this;
    }

    public AxisAngle4d set(AxisAngle4d axisAngle4d) {
        this.x = axisAngle4d.x;
        this.y = axisAngle4d.y;
        this.z = axisAngle4d.z;
        double d2 = axisAngle4d.angle;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
        return this;
    }

    public String toString() {
        String axisAngle4d = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < axisAngle4d.length(); i3++) {
            char charAt = axisAngle4d.charAt(i3);
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
        return transform((Vector3dc) vector3d, vector3d);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.angle);
        objectOutput.writeDouble(this.x);
        objectOutput.writeDouble(this.y);
        objectOutput.writeDouble(this.z);
    }

    public Quaterniond get(Quaterniond quaterniond) {
        return quaterniond.set(this);
    }

    public Vector3d transform(Vector3dc vector3dc, Vector3d vector3d) {
        double sin = Math.sin(this.angle);
        double cosFromSin = Math.cosFromSin(sin, this.angle);
        double z2 = (vector3dc.z() * this.z) + (vector3dc.y() * this.y) + (vector3dc.x() * this.x);
        double z3 = (((vector3dc.z() * this.y) - (vector3dc.y() * this.z)) * sin) + (vector3dc.x() * cosFromSin);
        double d2 = (1.0d - cosFromSin) * z2;
        Vector3d vector3d2 = vector3d;
        vector3d2.set((this.x * d2) + z3, (this.y * d2) + (((vector3dc.x() * this.z) - (vector3dc.z() * this.x)) * sin) + (vector3dc.y() * cosFromSin), (d2 * this.z) + (((vector3dc.y() * this.x) - (vector3dc.x() * this.y)) * sin) + (vector3dc.z() * cosFromSin));
        return vector3d;
    }

    public AxisAngle4d(AxisAngle4d axisAngle4d) {
        this.x = axisAngle4d.x;
        this.y = axisAngle4d.y;
        this.z = axisAngle4d.z;
        double d2 = axisAngle4d.angle;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set(this);
    }

    public Matrix3f get(Matrix3f matrix3f) {
        return matrix3f.set(this);
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set(this);
    }

    public AxisAngle4d set(AxisAngle4f axisAngle4f) {
        this.x = (double) axisAngle4f.x;
        this.y = (double) axisAngle4f.y;
        this.z = (double) axisAngle4f.z;
        float f2 = axisAngle4f.angle;
        double d2 = (double) f2;
        if (((double) f2) < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
        return this;
    }

    public Matrix3d get(Matrix3d matrix3d) {
        return matrix3d.set(this);
    }

    public AxisAngle4d(AxisAngle4f axisAngle4f) {
        this.x = (double) axisAngle4f.x;
        this.y = (double) axisAngle4f.y;
        this.z = (double) axisAngle4f.z;
        float f2 = axisAngle4f.angle;
        double d2 = (double) f2;
        if (((double) f2) < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
    }

    public AxisAngle4d set(double d2, double d3, double d4, double d5) {
        this.x = d3;
        this.y = d4;
        this.z = d5;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
        return this;
    }

    public Vector3f transform(Vector3f vector3f) {
        return transform((Vector3fc) vector3f, vector3f);
    }

    public Vector3f transform(Vector3fc vector3fc, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        double sin = Math.sin(this.angle);
        double cosFromSin = Math.cosFromSin(sin, this.angle);
        double z2 = (this.z * ((double) vector3fc.z())) + (this.y * ((double) vector3fc.y())) + (this.x * ((double) vector3fc.x()));
        double z3 = this.y * ((double) vector3fc.z());
        double d2 = sin;
        double d3 = z2 * (1.0d - cosFromSin);
        double x2 = this.z * ((double) vector3fc.x());
        float a2 = (float) ((this.x * d3) + a.a(this.z, (double) vector3fc.y(), z3, d2, ((double) vector3fc.x()) * cosFromSin));
        double y2 = this.x * ((double) vector3fc.y());
        float f2 = a2;
        Vector3f vector3f3 = vector3f;
        vector3f3.set(f2, (float) ((this.y * d3) + a.a(this.x, (double) vector3fc.z(), x2, d2, ((double) vector3fc.y()) * cosFromSin)), (float) ((d3 * this.z) + a.a(this.y, (double) vector3fc.x(), y2, d2, ((double) vector3fc.z()) * cosFromSin)));
        return vector3f3;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a2.append(numberFormat.format(this.x));
        a2.append(numberFormat.format(this.y));
        a.b(numberFormat, this.z, a2, " <|");
        return a.a(numberFormat, this.angle, a2, " )");
    }

    public AxisAngle4d(Quaternionfc quaternionfc) {
        double safeAcos = safeAcos((double) quaternionfc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - ((double) (quaternionfc.w() * quaternionfc.w())));
        this.x = ((double) quaternionfc.x()) * sqrt;
        this.y = ((double) quaternionfc.y()) * sqrt;
        this.z = ((double) quaternionfc.z()) * sqrt;
        this.angle = safeAcos + safeAcos;
    }

    public AxisAngle4d set(double d2, Vector3dc vector3dc) {
        return set(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public AxisAngle4d set(double d2, Vector3f vector3f) {
        return set(d2, (double) vector3f.x, (double) vector3f.y, (double) vector3f.z);
    }

    public AxisAngle4d set(Quaternionfc quaternionfc) {
        double safeAcos = safeAcos((double) quaternionfc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - ((double) (quaternionfc.w() * quaternionfc.w())));
        this.x = ((double) quaternionfc.x()) * sqrt;
        this.y = ((double) quaternionfc.y()) * sqrt;
        this.z = ((double) quaternionfc.z()) * sqrt;
        this.angle = safeAcos + safeAcos;
        return this;
    }

    public Vector4d transform(Vector4d vector4d) {
        return transform((Vector4dc) vector4d, vector4d);
    }

    public Vector4d transform(Vector4dc vector4dc, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double sin = Math.sin(this.angle);
        double cosFromSin = Math.cosFromSin(sin, this.angle);
        double z2 = (vector4dc.z() * this.z) + (vector4dc.y() * this.y) + (vector4dc.x() * this.x);
        double z3 = (((vector4dc.z() * this.y) - (vector4dc.y() * this.z)) * sin) + (vector4dc.x() * cosFromSin);
        double d2 = (1.0d - cosFromSin) * z2;
        vector4d.set((this.x * d2) + z3, (this.y * d2) + (((vector4dc.x() * this.z) - (vector4dc.z() * this.x)) * sin) + (vector4dc.y() * cosFromSin), (d2 * this.z) + (((vector4dc.y() * this.x) - (vector4dc.x() * this.y)) * sin) + (vector4dc.z() * cosFromSin), vector4d2.w);
        return vector4d2;
    }

    public AxisAngle4d(Quaterniondc quaterniondc) {
        double safeAcos = safeAcos(quaterniondc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - (quaterniondc.w() * quaterniondc.w()));
        this.x = quaterniondc.x() * sqrt;
        this.y = quaterniondc.y() * sqrt;
        this.z = quaterniondc.z() * sqrt;
        this.angle = safeAcos + safeAcos;
    }

    public AxisAngle4d set(Quaterniondc quaterniondc) {
        double safeAcos = safeAcos(quaterniondc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - (quaterniondc.w() * quaterniondc.w()));
        this.x = quaterniondc.x() * sqrt;
        this.y = quaterniondc.y() * sqrt;
        this.z = quaterniondc.z() * sqrt;
        this.angle = safeAcos + safeAcos;
        return this;
    }

    public AxisAngle4d(double d2, double d3, double d4, double d5) {
        this.x = d3;
        this.y = d4;
        this.z = d5;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = d2 % 6.283185307179586d;
    }

    public AxisAngle4d set(Matrix3fc matrix3fc) {
        double m00 = (double) matrix3fc.m00();
        double m01 = (double) matrix3fc.m01();
        double m02 = (double) matrix3fc.m02();
        double m10 = (double) matrix3fc.m10();
        double m11 = (double) matrix3fc.m11();
        double m12 = (double) matrix3fc.m12();
        double m20 = (double) matrix3fc.m20();
        double m21 = (double) matrix3fc.m21();
        double m22 = (double) matrix3fc.m22();
        double d2 = m22;
        double sqrt = 1.0d / Math.sqrt((double) ((matrix3fc.m02() * matrix3fc.m02()) + ((matrix3fc.m01() * matrix3fc.m01()) + (matrix3fc.m00() * matrix3fc.m00()))));
        double d3 = m12;
        double sqrt2 = 1.0d / Math.sqrt((double) ((matrix3fc.m12() * matrix3fc.m12()) + ((matrix3fc.m11() * matrix3fc.m11()) + (matrix3fc.m10() * matrix3fc.m10()))));
        double d4 = m11;
        double sqrt3 = 1.0d / Math.sqrt((double) ((matrix3fc.m22() * matrix3fc.m22()) + ((matrix3fc.m21() * matrix3fc.m21()) + (matrix3fc.m20() * matrix3fc.m20()))));
        double d5 = m00 * sqrt;
        double d6 = m01 * sqrt;
        double d7 = m02 * sqrt;
        double d8 = m10 * sqrt2;
        double d9 = d4 * sqrt2;
        double d10 = sqrt2 * d3;
        double d11 = m20 * sqrt3;
        double d12 = m21 * sqrt3;
        double d13 = sqrt3 * d2;
        if (Math.abs(d8 - d6) >= 1.0E-4d || Math.abs(d11 - d7) >= 1.0E-4d || Math.abs(d12 - d10) >= 1.0E-4d) {
            double d14 = d10 - d12;
            double d15 = d11 - d7;
            double d16 = d6 - d8;
            double d17 = d16 * d16;
            double sqrt4 = Math.sqrt(d17 + (d15 * d15) + (d14 * d14));
            this.angle = safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = d14 / sqrt4;
            this.y = d15 / sqrt4;
            this.z = d16 / sqrt4;
            return this;
        }
        double d18 = d10;
        this.angle = 3.141592653589793d;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            double sqrt5 = Math.sqrt(d19);
            this.x = sqrt5;
            this.y = d22 / sqrt5;
            this.z = d23 / sqrt5;
        } else if (d20 > d21) {
            double sqrt6 = Math.sqrt(d20);
            this.y = sqrt6;
            this.x = d22 / sqrt6;
            this.z = d24 / sqrt6;
        } else {
            double sqrt7 = Math.sqrt(d21);
            this.z = sqrt7;
            this.x = d23 / sqrt7;
            this.y = d24 / sqrt7;
        }
        return this;
    }

    public AxisAngle4d(double d2, Vector3dc vector3dc) {
        this(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public AxisAngle4d(double d2, Vector3f vector3f) {
        this(d2, (double) vector3f.x, (double) vector3f.y, (double) vector3f.z);
    }

    public AxisAngle4d set(Matrix3dc matrix3dc) {
        double m00 = matrix3dc.m00();
        double m01 = matrix3dc.m01();
        double m02 = matrix3dc.m02();
        double m10 = matrix3dc.m10();
        double m11 = matrix3dc.m11();
        double m12 = matrix3dc.m12();
        double m20 = matrix3dc.m20();
        double m21 = matrix3dc.m21();
        double m22 = matrix3dc.m22();
        double sqrt = 1.0d / Math.sqrt((matrix3dc.m02() * matrix3dc.m02()) + ((matrix3dc.m01() * matrix3dc.m01()) + (matrix3dc.m00() * matrix3dc.m00())));
        double sqrt2 = 1.0d / Math.sqrt((matrix3dc.m12() * matrix3dc.m12()) + ((matrix3dc.m11() * matrix3dc.m11()) + (matrix3dc.m10() * matrix3dc.m10())));
        double sqrt3 = 1.0d / Math.sqrt((matrix3dc.m22() * matrix3dc.m22()) + ((matrix3dc.m21() * matrix3dc.m21()) + (matrix3dc.m20() * matrix3dc.m20())));
        double d2 = m00 * sqrt;
        double d3 = m01 * sqrt;
        double d4 = m02 * sqrt;
        double d5 = m10 * sqrt2;
        double d6 = m11 * sqrt2;
        double d7 = m12 * sqrt2;
        double d8 = m20 * sqrt3;
        double d9 = m21 * sqrt3;
        double d10 = m22 * sqrt3;
        if (Math.abs(d5 - d3) >= 1.0E-4d || Math.abs(d8 - d4) >= 1.0E-4d || Math.abs(d9 - d7) >= 1.0E-4d) {
            double d11 = d7 - d9;
            double d12 = d8 - d4;
            double d13 = d3 - d5;
            double d14 = d13 * d13;
            double sqrt4 = Math.sqrt(d14 + (d12 * d12) + (d11 * d11));
            this.angle = safeAcos((((d2 + d6) + d10) - 1.0d) / 2.0d);
            this.x = d11 / sqrt4;
            this.y = d12 / sqrt4;
            this.z = d13 / sqrt4;
            return this;
        }
        double d15 = d7;
        this.angle = 3.141592653589793d;
        double d16 = (d2 + 1.0d) / 2.0d;
        double d17 = (d6 + 1.0d) / 2.0d;
        double d18 = (d10 + 1.0d) / 2.0d;
        double d19 = (d5 + d3) / 4.0d;
        double d20 = (d8 + d4) / 4.0d;
        double d21 = (d9 + d15) / 4.0d;
        if (d16 > d17 && d16 > d18) {
            double sqrt5 = Math.sqrt(d16);
            this.x = sqrt5;
            this.y = d19 / sqrt5;
            this.z = d20 / sqrt5;
        } else if (d17 > d18) {
            double sqrt6 = Math.sqrt(d17);
            this.y = sqrt6;
            this.x = d19 / sqrt6;
            this.z = d21 / sqrt6;
        } else {
            double sqrt7 = Math.sqrt(d18);
            this.z = sqrt7;
            this.x = d20 / sqrt7;
            this.y = d21 / sqrt7;
        }
        return this;
    }

    public AxisAngle4d set(Matrix4fc matrix4fc) {
        double m00 = (double) matrix4fc.m00();
        double m01 = (double) matrix4fc.m01();
        double m02 = (double) matrix4fc.m02();
        double m10 = (double) matrix4fc.m10();
        double m11 = (double) matrix4fc.m11();
        double m12 = (double) matrix4fc.m12();
        double m20 = (double) matrix4fc.m20();
        double m21 = (double) matrix4fc.m21();
        double m22 = (double) matrix4fc.m22();
        double d2 = m22;
        double sqrt = 1.0d / Math.sqrt((double) ((matrix4fc.m02() * matrix4fc.m02()) + ((matrix4fc.m01() * matrix4fc.m01()) + (matrix4fc.m00() * matrix4fc.m00()))));
        double d3 = m12;
        double sqrt2 = 1.0d / Math.sqrt((double) ((matrix4fc.m12() * matrix4fc.m12()) + ((matrix4fc.m11() * matrix4fc.m11()) + (matrix4fc.m10() * matrix4fc.m10()))));
        double d4 = m11;
        double sqrt3 = 1.0d / Math.sqrt((double) ((matrix4fc.m22() * matrix4fc.m22()) + ((matrix4fc.m21() * matrix4fc.m21()) + (matrix4fc.m20() * matrix4fc.m20()))));
        double d5 = m00 * sqrt;
        double d6 = m01 * sqrt;
        double d7 = m02 * sqrt;
        double d8 = m10 * sqrt2;
        double d9 = d4 * sqrt2;
        double d10 = sqrt2 * d3;
        double d11 = m20 * sqrt3;
        double d12 = m21 * sqrt3;
        double d13 = sqrt3 * d2;
        if (Math.abs(d8 - d6) >= 1.0E-4d || Math.abs(d11 - d7) >= 1.0E-4d || Math.abs(d12 - d10) >= 1.0E-4d) {
            double d14 = d10 - d12;
            double d15 = d11 - d7;
            double d16 = d6 - d8;
            double d17 = d16 * d16;
            double sqrt4 = Math.sqrt(d17 + (d15 * d15) + (d14 * d14));
            this.angle = safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = d14 / sqrt4;
            this.y = d15 / sqrt4;
            this.z = d16 / sqrt4;
            return this;
        }
        double d18 = d10;
        this.angle = 3.141592653589793d;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            double sqrt5 = Math.sqrt(d19);
            this.x = sqrt5;
            this.y = d22 / sqrt5;
            this.z = d23 / sqrt5;
        } else if (d20 > d21) {
            double sqrt6 = Math.sqrt(d20);
            this.y = sqrt6;
            this.x = d22 / sqrt6;
            this.z = d24 / sqrt6;
        } else {
            double sqrt7 = Math.sqrt(d21);
            this.z = sqrt7;
            this.x = d23 / sqrt7;
            this.y = d24 / sqrt7;
        }
        return this;
    }

    public AxisAngle4d set(Matrix4x3fc matrix4x3fc) {
        double m00 = (double) matrix4x3fc.m00();
        double m01 = (double) matrix4x3fc.m01();
        double m02 = (double) matrix4x3fc.m02();
        double m10 = (double) matrix4x3fc.m10();
        double m11 = (double) matrix4x3fc.m11();
        double m12 = (double) matrix4x3fc.m12();
        double m20 = (double) matrix4x3fc.m20();
        double m21 = (double) matrix4x3fc.m21();
        double m22 = (double) matrix4x3fc.m22();
        double d2 = m22;
        double sqrt = 1.0d / Math.sqrt((double) ((matrix4x3fc.m02() * matrix4x3fc.m02()) + ((matrix4x3fc.m01() * matrix4x3fc.m01()) + (matrix4x3fc.m00() * matrix4x3fc.m00()))));
        double d3 = m12;
        double sqrt2 = 1.0d / Math.sqrt((double) ((matrix4x3fc.m12() * matrix4x3fc.m12()) + ((matrix4x3fc.m11() * matrix4x3fc.m11()) + (matrix4x3fc.m10() * matrix4x3fc.m10()))));
        double d4 = m11;
        double sqrt3 = 1.0d / Math.sqrt((double) ((matrix4x3fc.m22() * matrix4x3fc.m22()) + ((matrix4x3fc.m21() * matrix4x3fc.m21()) + (matrix4x3fc.m20() * matrix4x3fc.m20()))));
        double d5 = m00 * sqrt;
        double d6 = m01 * sqrt;
        double d7 = m02 * sqrt;
        double d8 = m10 * sqrt2;
        double d9 = d4 * sqrt2;
        double d10 = sqrt2 * d3;
        double d11 = m20 * sqrt3;
        double d12 = m21 * sqrt3;
        double d13 = sqrt3 * d2;
        if (Math.abs(d8 - d6) >= 1.0E-4d || Math.abs(d11 - d7) >= 1.0E-4d || Math.abs(d12 - d10) >= 1.0E-4d) {
            double d14 = d10 - d12;
            double d15 = d11 - d7;
            double d16 = d6 - d8;
            double d17 = d16 * d16;
            double sqrt4 = Math.sqrt(d17 + (d15 * d15) + (d14 * d14));
            this.angle = safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = d14 / sqrt4;
            this.y = d15 / sqrt4;
            this.z = d16 / sqrt4;
            return this;
        }
        double d18 = d10;
        this.angle = 3.141592653589793d;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            double sqrt5 = Math.sqrt(d19);
            this.x = sqrt5;
            this.y = d22 / sqrt5;
            this.z = d23 / sqrt5;
        } else if (d20 > d21) {
            double sqrt6 = Math.sqrt(d20);
            this.y = sqrt6;
            this.x = d22 / sqrt6;
            this.z = d24 / sqrt6;
        } else {
            double sqrt7 = Math.sqrt(d21);
            this.z = sqrt7;
            this.x = d23 / sqrt7;
            this.y = d24 / sqrt7;
        }
        return this;
    }

    public AxisAngle4d set(Matrix4dc matrix4dc) {
        double m00 = matrix4dc.m00();
        double m01 = matrix4dc.m01();
        double m02 = matrix4dc.m02();
        double m10 = matrix4dc.m10();
        double m11 = matrix4dc.m11();
        double m12 = matrix4dc.m12();
        double m20 = matrix4dc.m20();
        double m21 = matrix4dc.m21();
        double m22 = matrix4dc.m22();
        double sqrt = 1.0d / Math.sqrt((matrix4dc.m02() * matrix4dc.m02()) + ((matrix4dc.m01() * matrix4dc.m01()) + (matrix4dc.m00() * matrix4dc.m00())));
        double sqrt2 = 1.0d / Math.sqrt((matrix4dc.m12() * matrix4dc.m12()) + ((matrix4dc.m11() * matrix4dc.m11()) + (matrix4dc.m10() * matrix4dc.m10())));
        double sqrt3 = 1.0d / Math.sqrt((matrix4dc.m22() * matrix4dc.m22()) + ((matrix4dc.m21() * matrix4dc.m21()) + (matrix4dc.m20() * matrix4dc.m20())));
        double d2 = m00 * sqrt;
        double d3 = m01 * sqrt;
        double d4 = m02 * sqrt;
        double d5 = m10 * sqrt2;
        double d6 = m11 * sqrt2;
        double d7 = m12 * sqrt2;
        double d8 = m20 * sqrt3;
        double d9 = m21 * sqrt3;
        double d10 = m22 * sqrt3;
        if (Math.abs(d5 - d3) >= 1.0E-4d || Math.abs(d8 - d4) >= 1.0E-4d || Math.abs(d9 - d7) >= 1.0E-4d) {
            double d11 = d7 - d9;
            double d12 = d8 - d4;
            double d13 = d3 - d5;
            double d14 = d13 * d13;
            double sqrt4 = Math.sqrt(d14 + (d12 * d12) + (d11 * d11));
            this.angle = safeAcos((((d2 + d6) + d10) - 1.0d) / 2.0d);
            this.x = d11 / sqrt4;
            this.y = d12 / sqrt4;
            this.z = d13 / sqrt4;
            return this;
        }
        double d15 = d7;
        this.angle = 3.141592653589793d;
        double d16 = (d2 + 1.0d) / 2.0d;
        double d17 = (d6 + 1.0d) / 2.0d;
        double d18 = (d10 + 1.0d) / 2.0d;
        double d19 = (d5 + d3) / 4.0d;
        double d20 = (d8 + d4) / 4.0d;
        double d21 = (d9 + d15) / 4.0d;
        if (d16 > d17 && d16 > d18) {
            double sqrt5 = Math.sqrt(d16);
            this.x = sqrt5;
            this.y = d19 / sqrt5;
            this.z = d20 / sqrt5;
        } else if (d17 > d18) {
            double sqrt6 = Math.sqrt(d17);
            this.y = sqrt6;
            this.x = d19 / sqrt6;
            this.z = d21 / sqrt6;
        } else {
            double sqrt7 = Math.sqrt(d18);
            this.z = sqrt7;
            this.x = d20 / sqrt7;
            this.y = d21 / sqrt7;
        }
        return this;
    }
}
