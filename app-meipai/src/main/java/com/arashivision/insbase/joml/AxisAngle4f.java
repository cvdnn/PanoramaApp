package com.arashivision.insbase.joml;

import e.a.a.a.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AxisAngle4f implements Externalizable {
    public static final long serialVersionUID = 1;
    public float angle;
    public float x;
    public float y;
    public float z;

    public AxisAngle4f() {
        this.z = 1.0f;
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
        if (obj == null || AxisAngle4f.class != obj.getClass()) {
            return false;
        }
        AxisAngle4f axisAngle4f = (AxisAngle4f) obj;
        float f2 = this.angle;
        float f3 = (float) ((((double) f2) < 0.0d ? (((double) f2) % 6.283185307179586d) + 6.283185307179586d : (double) f2) % 6.283185307179586d);
        float f4 = axisAngle4f.angle;
        return Float.floatToIntBits(f3) == Float.floatToIntBits((float) (((((double) f4) > 0.0d ? 1 : (((double) f4) == 0.0d ? 0 : -1)) < 0 ? (((double) f4) % 6.283185307179586d) + 6.283185307179586d : (double) f4) % 6.283185307179586d)) && Float.floatToIntBits(this.x) == Float.floatToIntBits(axisAngle4f.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(axisAngle4f.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(axisAngle4f.z);
    }

    public Quaternionf get(Quaternionf quaternionf) {
        return quaternionf.set(this);
    }

    public int hashCode() {
        float f2 = this.angle;
        return Float.floatToIntBits(this.z) + a.a(this.y, a.a(this.x, a.a((float) ((((double) f2) < 0.0d ? (((double) f2) % 6.283185307179586d) + 6.283185307179586d : (double) f2) % 6.283185307179586d), 31, 31), 31), 31);
    }

    public AxisAngle4f normalize() {
        float f2 = this.x;
        float f3 = f2 * f2;
        float f4 = this.y;
        float f5 = (f4 * f4) + f3;
        float f6 = this.z;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f6 * f6) + f5)));
        this.x *= sqrt;
        this.y *= sqrt;
        this.z *= sqrt;
        return this;
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.angle = objectInput.readFloat();
        this.x = objectInput.readFloat();
        this.y = objectInput.readFloat();
        this.z = objectInput.readFloat();
    }

    public AxisAngle4f rotate(float f2) {
        float f3 = this.angle + f2;
        this.angle = f3;
        double d2 = (double) f3;
        if (((double) f3) < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = (float) (d2 % 6.283185307179586d);
        return this;
    }

    public AxisAngle4f set(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        float f2 = axisAngle4f.angle;
        this.angle = f2;
        double d2 = (double) f2;
        if (((double) f2) < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = (float) (d2 % 6.283185307179586d);
        return this;
    }

    public String toString() {
        String axisAngle4f = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < axisAngle4f.length(); i3++) {
            char charAt = axisAngle4f.charAt(i3);
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
        return transform((Vector3fc) vector3f, vector3f);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.angle);
        objectOutput.writeFloat(this.x);
        objectOutput.writeFloat(this.y);
        objectOutput.writeFloat(this.z);
    }

    public Quaterniond get(Quaterniond quaterniond) {
        return quaterniond.set(this);
    }

    public Vector3f transform(Vector3fc vector3fc, Vector3f vector3f) {
        double sin = Math.sin((double) this.angle);
        double cosFromSin = Math.cosFromSin(sin, (double) this.angle);
        float z2 = (vector3fc.z() * this.z) + (vector3fc.y() * this.y) + (vector3fc.x() * this.x);
        double z3 = (((double) ((vector3fc.z() * this.y) - (vector3fc.y() * this.z))) * sin) + (((double) vector3fc.x()) * cosFromSin);
        double d2 = (1.0d - cosFromSin) * ((double) z2);
        vector3f.set((float) ((((double) this.x) * d2) + z3), (float) ((((double) this.y) * d2) + (((double) ((vector3fc.x() * this.z) - (vector3fc.z() * this.x))) * sin) + (((double) vector3fc.y()) * cosFromSin)), (float) ((d2 * ((double) this.z)) + (sin * ((double) ((vector3fc.y() * this.x) - (vector3fc.x() * this.y)))) + (((double) vector3fc.z()) * cosFromSin)));
        return vector3f;
    }

    public AxisAngle4f(AxisAngle4f axisAngle4f) {
        this.x = axisAngle4f.x;
        this.y = axisAngle4f.y;
        this.z = axisAngle4f.z;
        float f2 = axisAngle4f.angle;
        double d2 = (double) f2;
        if (((double) f2) < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = (float) (d2 % 6.283185307179586d);
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

    public Matrix3d get(Matrix3d matrix3d) {
        return matrix3d.set(this);
    }

    public AxisAngle4f set(float f2, float f3, float f4, float f5) {
        this.x = f3;
        this.y = f4;
        this.z = f5;
        double d2 = (double) f2;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = (float) (d2 % 6.283185307179586d);
        return this;
    }

    public AxisAngle4f(Quaternionfc quaternionfc) {
        float safeAcos = (float) safeAcos((double) quaternionfc.w());
        float sqrt = (float) (1.0d / Math.sqrt(1.0d - ((double) (quaternionfc.w() * quaternionfc.w()))));
        this.x = quaternionfc.x() * sqrt;
        this.y = quaternionfc.y() * sqrt;
        this.z = quaternionfc.z() * sqrt;
        this.angle = safeAcos + safeAcos;
    }

    public Vector4f transform(Vector4f vector4f) {
        return transform((Vector4fc) vector4f, vector4f);
    }

    public AxisAngle4f set(float f2, Vector3fc vector3fc) {
        return set(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Vector4f transform(Vector4fc vector4fc, Vector4f vector4f) {
        double sin = Math.sin((double) this.angle);
        double cosFromSin = Math.cosFromSin(sin, (double) this.angle);
        float z2 = (vector4fc.z() * this.z) + (vector4fc.y() * this.y) + (vector4fc.x() * this.x);
        double z3 = (((double) ((vector4fc.z() * this.y) - (vector4fc.y() * this.z))) * sin) + (((double) vector4fc.x()) * cosFromSin);
        double d2 = (1.0d - cosFromSin) * ((double) z2);
        vector4f.set((float) ((((double) this.x) * d2) + z3), (float) ((((double) this.y) * d2) + (((double) ((vector4fc.x() * this.z) - (vector4fc.z() * this.x))) * sin) + (((double) vector4fc.y()) * cosFromSin)), (float) ((d2 * ((double) this.z)) + (sin * ((double) ((vector4fc.y() * this.x) - (vector4fc.x() * this.y)))) + (((double) vector4fc.z()) * cosFromSin)), vector4f.w);
        return vector4f;
    }

    public AxisAngle4f set(Quaternionfc quaternionfc) {
        double safeAcos = safeAcos((double) quaternionfc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - ((double) (quaternionfc.w() * quaternionfc.w())));
        this.x = (float) (((double) quaternionfc.x()) * sqrt);
        this.y = (float) (((double) quaternionfc.y()) * sqrt);
        this.z = (float) (((double) quaternionfc.z()) * sqrt);
        this.angle = (float) (safeAcos + safeAcos);
        return this;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder a2 = a.a("(");
        a2.append(numberFormat.format((double) this.x));
        a2.append(numberFormat.format((double) this.y));
        a.b(numberFormat, (double) this.z, a2, " <|");
        return a.a(numberFormat, (double) this.angle, a2, " )");
    }

    public AxisAngle4f(float f2, float f3, float f4, float f5) {
        this.x = f3;
        this.y = f4;
        this.z = f5;
        double d2 = (double) f2;
        if (d2 < 0.0d) {
            d2 = (d2 % 6.283185307179586d) + 6.283185307179586d;
        }
        this.angle = (float) (d2 % 6.283185307179586d);
    }

    public AxisAngle4f set(Quaterniondc quaterniondc) {
        double safeAcos = safeAcos(quaterniondc.w());
        double sqrt = 1.0d / Math.sqrt(1.0d - (quaterniondc.w() * quaterniondc.w()));
        this.x = (float) (quaterniondc.x() * sqrt);
        this.y = (float) (quaterniondc.y() * sqrt);
        this.z = (float) (quaterniondc.z() * sqrt);
        this.angle = (float) (safeAcos + safeAcos);
        return this;
    }

    public AxisAngle4f(float f2, Vector3fc vector3fc) {
        this(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public AxisAngle4f set(Matrix3fc matrix3fc) {
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
            this.angle = (float) safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = (float) (d14 / sqrt4);
            this.y = (float) (d15 / sqrt4);
            this.z = (float) (d16 / sqrt4);
            return this;
        }
        double d18 = d10;
        this.angle = 3.1415927f;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            float sqrt5 = (float) Math.sqrt(d19);
            this.x = sqrt5;
            this.y = (float) (d22 / ((double) sqrt5));
            this.z = (float) (d23 / ((double) sqrt5));
        } else if (d20 > d21) {
            float sqrt6 = (float) Math.sqrt(d20);
            this.y = sqrt6;
            this.x = (float) (d22 / ((double) sqrt6));
            this.z = (float) (d24 / ((double) sqrt6));
        } else {
            float sqrt7 = (float) Math.sqrt(d21);
            this.z = sqrt7;
            this.x = (float) (d23 / ((double) sqrt7));
            this.y = (float) (d24 / ((double) sqrt7));
        }
        return this;
    }

    public AxisAngle4f set(Matrix3dc matrix3dc) {
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
            this.angle = (float) safeAcos((((d2 + d6) + d10) - 1.0d) / 2.0d);
            this.x = (float) (d11 / sqrt4);
            this.y = (float) (d12 / sqrt4);
            this.z = (float) (d13 / sqrt4);
            return this;
        }
        double d15 = d7;
        this.angle = 3.1415927f;
        double d16 = (d2 + 1.0d) / 2.0d;
        double d17 = (d6 + 1.0d) / 2.0d;
        double d18 = (d10 + 1.0d) / 2.0d;
        double d19 = (d5 + d3) / 4.0d;
        double d20 = (d8 + d4) / 4.0d;
        double d21 = (d9 + d15) / 4.0d;
        if (d16 > d17 && d16 > d18) {
            float sqrt5 = (float) Math.sqrt(d16);
            this.x = sqrt5;
            this.y = (float) (d19 / ((double) sqrt5));
            this.z = (float) (d20 / ((double) sqrt5));
        } else if (d17 > d18) {
            float sqrt6 = (float) Math.sqrt(d17);
            this.y = sqrt6;
            this.x = (float) (d19 / ((double) sqrt6));
            this.z = (float) (d21 / ((double) sqrt6));
        } else {
            float sqrt7 = (float) Math.sqrt(d18);
            this.z = sqrt7;
            this.x = (float) (d20 / ((double) sqrt7));
            this.y = (float) (d21 / ((double) sqrt7));
        }
        return this;
    }

    public AxisAngle4f set(Matrix4fc matrix4fc) {
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
            this.angle = (float) safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = (float) (d14 / sqrt4);
            this.y = (float) (d15 / sqrt4);
            this.z = (float) (d16 / sqrt4);
            return this;
        }
        double d18 = d10;
        this.angle = 3.1415927f;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            float sqrt5 = (float) Math.sqrt(d19);
            this.x = sqrt5;
            this.y = (float) (d22 / ((double) sqrt5));
            this.z = (float) (d23 / ((double) sqrt5));
        } else if (d20 > d21) {
            float sqrt6 = (float) Math.sqrt(d20);
            this.y = sqrt6;
            this.x = (float) (d22 / ((double) sqrt6));
            this.z = (float) (d24 / ((double) sqrt6));
        } else {
            float sqrt7 = (float) Math.sqrt(d21);
            this.z = sqrt7;
            this.x = (float) (d23 / ((double) sqrt7));
            this.y = (float) (d24 / ((double) sqrt7));
        }
        return this;
    }

    public AxisAngle4f set(Matrix4x3fc matrix4x3fc) {
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
            this.angle = (float) safeAcos((((d5 + d9) + d13) - 1.0d) / 2.0d);
            this.x = (float) (d14 / sqrt4);
            this.y = (float) (d15 / sqrt4);
            this.z = (float) (d16 / sqrt4);
            return this;
        }
        double d18 = d10;
        this.angle = 3.1415927f;
        double d19 = (d5 + 1.0d) / 2.0d;
        double d20 = (d9 + 1.0d) / 2.0d;
        double d21 = (d13 + 1.0d) / 2.0d;
        double d22 = (d8 + d6) / 4.0d;
        double d23 = (d11 + d7) / 4.0d;
        double d24 = (d12 + d18) / 4.0d;
        if (d19 > d20 && d19 > d21) {
            float sqrt5 = (float) Math.sqrt(d19);
            this.x = sqrt5;
            this.y = (float) (d22 / ((double) sqrt5));
            this.z = (float) (d23 / ((double) sqrt5));
        } else if (d20 > d21) {
            float sqrt6 = (float) Math.sqrt(d20);
            this.y = sqrt6;
            this.x = (float) (d22 / ((double) sqrt6));
            this.z = (float) (d24 / ((double) sqrt6));
        } else {
            float sqrt7 = (float) Math.sqrt(d21);
            this.z = sqrt7;
            this.x = (float) (d23 / ((double) sqrt7));
            this.y = (float) (d24 / ((double) sqrt7));
        }
        return this;
    }

    public AxisAngle4f set(Matrix4dc matrix4dc) {
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
            this.angle = (float) safeAcos((((d2 + d6) + d10) - 1.0d) / 2.0d);
            this.x = (float) (d11 / sqrt4);
            this.y = (float) (d12 / sqrt4);
            this.z = (float) (d13 / sqrt4);
            return this;
        }
        double d15 = d7;
        this.angle = 3.1415927f;
        double d16 = (d2 + 1.0d) / 2.0d;
        double d17 = (d6 + 1.0d) / 2.0d;
        double d18 = (d10 + 1.0d) / 2.0d;
        double d19 = (d5 + d3) / 4.0d;
        double d20 = (d8 + d4) / 4.0d;
        double d21 = (d9 + d15) / 4.0d;
        if (d16 > d17 && d16 > d18) {
            float sqrt5 = (float) Math.sqrt(d16);
            this.x = sqrt5;
            this.y = (float) (d19 / ((double) sqrt5));
            this.z = (float) (d20 / ((double) sqrt5));
        } else if (d17 > d18) {
            float sqrt6 = (float) Math.sqrt(d17);
            this.y = sqrt6;
            this.x = (float) (d19 / ((double) sqrt6));
            this.z = (float) (d21 / ((double) sqrt6));
        } else {
            float sqrt7 = (float) Math.sqrt(d18);
            this.z = sqrt7;
            this.x = (float) (d20 / ((double) sqrt7));
            this.y = (float) (d21 / ((double) sqrt7));
        }
        return this;
    }
}
