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
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix4x3d implements Externalizable, Matrix4x3dc {
    public static final long serialVersionUID = 1;
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;
    public double m20;
    public double m21;
    public double m22;
    public double m30;
    public double m31;
    public double m32;
    public int properties;

    public Matrix4x3d() {
        this.m00 = 1.0d;
        this.m11 = 1.0d;
        this.m22 = 1.0d;
        this.properties = 28;
    }

    private Matrix4x3d invertGeneric(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d5 * d6;
        double d8 = this.m02;
        double d9 = d8 * d6;
        double d10 = d6;
        double d11 = this.m12;
        double d12 = d2 * d11;
        double d13 = d5 * d11;
        double d14 = d8 * d3;
        double d15 = d4 - d7;
        double d16 = d4;
        double d17 = this.m22;
        double d18 = d15 * d17;
        double d19 = d9 - d12;
        double d20 = d7;
        double d21 = this.m21;
        double d22 = (d19 * d21) + d18;
        double d23 = d13 - d14;
        double d24 = d2;
        double d25 = this.m20;
        double l = a.l(d23, d25, d22, 1.0d);
        double d26 = d10 * d17;
        double d27 = d10 * d21;
        double d28 = d3 * d17;
        double d29 = d3 * d25;
        double d30 = d11 * d21;
        double d31 = d11 * d25;
        double d32 = d25 * d8;
        double d33 = d25 * d5;
        double d34 = d8 * d21;
        double d35 = d21 * d24;
        double d36 = d5 * d17;
        double d37 = d17 * d24;
        double d38 = d33;
        double d39 = d23 * l;
        double d40 = (d31 - d26) * l;
        double d41 = (d37 - d32) * l;
        double d42 = d19 * l;
        double d43 = (d27 - d29) * l;
        double d44 = (d38 - d35) * l;
        double d45 = d15 * l;
        double d46 = (d28 - d30) * l;
        double d47 = (d34 - d36) * l;
        double d48 = this.m31;
        double d49 = d26 * d48;
        double d50 = d37;
        double d51 = this.m32;
        double d52 = (d29 * d51) + (d49 - (d27 * d51));
        double d53 = d36;
        double d54 = this.m30;
        double d55 = d48;
        double d56 = l;
        double c2 = a.c(d31, d55, (d30 * d54) + (d52 - (d28 * d54)), d56);
        double d57 = d53 * d54;
        double d58 = d50;
        double c3 = a.c(d58, d55, d57 + (((d35 * d51) + ((d32 * d48) - (d38 * d51))) - (d34 * d54)), d56);
        double d59 = d20 * d51;
        double d60 = d51;
        double d61 = d16;
        double c4 = a.c(d60, d61, d59 + (((d12 * d48) + ((d14 * d54) - (d13 * d54))) - (d9 * d48)), l);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m00 = d46;
        matrix4x3d3.m01 = d47;
        matrix4x3d3.m02 = d39;
        matrix4x3d3.m10 = d40;
        matrix4x3d3.m11 = d41;
        matrix4x3d3.m12 = d42;
        matrix4x3d3.m20 = d43;
        matrix4x3d3.m21 = d44;
        matrix4x3d3.m22 = d45;
        matrix4x3d3.m30 = c2;
        matrix4x3d3.m31 = c3;
        matrix4x3d3.m32 = c4;
        matrix4x3d3.properties = 0;
        return matrix4x3d3;
    }

    private Matrix4x3d invertOrthonormal(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = this.m00;
        double d3 = this.m30;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m31;
        double d7 = (d5 * d6) + d4;
        double d8 = this.m02;
        double d9 = this.m32;
        double d10 = -((d8 * d9) + d7);
        double d11 = this.m10;
        double d12 = d11 * d3;
        double d13 = d8;
        double d14 = this.m11;
        double d15 = (d14 * d6) + d12;
        double d16 = d14;
        double d17 = this.m12;
        double d18 = d17;
        double d19 = -((d17 * d9) + d15);
        double d20 = this.m20;
        double d21 = d3 * d20;
        double d22 = d5;
        double d23 = this.m21;
        double d24 = (d6 * d23) + d21;
        double d25 = this.m22;
        double d26 = -((d9 * d25) + d24);
        matrix4x3d2.m00 = d2;
        matrix4x3d2.m01 = d11;
        matrix4x3d2.m02 = d20;
        matrix4x3d2.m10 = d22;
        matrix4x3d2.m11 = d16;
        matrix4x3d2.m12 = d23;
        matrix4x3d2.m20 = d13;
        matrix4x3d2.m21 = d18;
        matrix4x3d2.m22 = d25;
        matrix4x3d2.m30 = d10;
        matrix4x3d2.m31 = d19;
        matrix4x3d2.m32 = d26;
        matrix4x3d2.properties = 16;
        return matrix4x3d2;
    }

    private Matrix4x3d lookAtGeneric(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d11 = d2 - d5;
        double d12 = d3 - d6;
        double d13 = d4 - d7;
        double e2 = a.e(d13, d13, (d12 * d12) + (d11 * d11), 1.0d);
        double d14 = d11 * e2;
        double d15 = d12 * e2;
        double d16 = d13 * e2;
        double d17 = (d9 * d16) - (d10 * d15);
        double d18 = (d10 * d14) - (d8 * d16);
        double d19 = (d8 * d15) - (d9 * d14);
        double e3 = a.e(d19, d19, (d18 * d18) + (d17 * d17), 1.0d);
        double d20 = d17 * e3;
        double d21 = d18 * e3;
        double d22 = d19 * e3;
        double d23 = (d15 * d22) - (d16 * d21);
        double d24 = (d16 * d20) - (d14 * d22);
        double d25 = (d14 * d21) - (d15 * d20);
        double d26 = d22;
        double d27 = -((d22 * d4) + (d21 * d3) + (d20 * d2));
        double d28 = d21;
        double d29 = -((d25 * d4) + (d24 * d3) + (d23 * d2));
        double d30 = d16;
        double d31 = -((d16 * d4) + (d15 * d3) + (d14 * d2));
        double d32 = d15;
        double d33 = this.m00;
        double d34 = d33 * d27;
        double d35 = d14;
        double d36 = this.m10;
        double d37 = (d36 * d29) + d34;
        double d38 = d36;
        double d39 = this.m20;
        double d40 = (d39 * d31) + d37;
        double d41 = d39;
        matrix4x3d2.m30 = d40 + this.m30;
        double d42 = this.m01;
        double d43 = d42 * d27;
        double d44 = d42;
        double d45 = this.m11;
        double d46 = (d45 * d29) + d43;
        double d47 = d45;
        double d48 = this.m21;
        double d49 = (d48 * d31) + d46;
        double d50 = d48;
        matrix4x3d2.m31 = d49 + this.m31;
        double d51 = this.m02;
        double d52 = d27 * d51;
        double d53 = d51;
        double d54 = this.m12;
        double d55 = (d29 * d54) + d52;
        double d56 = this.m22;
        matrix4x3d2.m32 = (d31 * d56) + d55 + this.m32;
        double d57 = (d41 * d35) + (d38 * d23) + (d33 * d20);
        double d58 = (d50 * d35) + (d47 * d23) + (d44 * d20);
        double d59 = (d56 * d35) + (d23 * d54) + (d20 * d53);
        double d60 = (d41 * d32) + (d38 * d24) + (d33 * d28);
        double d61 = (d50 * d32) + (d47 * d24) + (d44 * d28);
        double d62 = d32 * d56;
        double d63 = d61;
        double d64 = d62 + (d24 * d54) + (d53 * d28);
        matrix4x3d2.m20 = (d41 * d30) + (d38 * d25) + (d33 * d26);
        matrix4x3d2.m21 = (d50 * d30) + (d47 * d25) + (d44 * d26);
        double d65 = d56 * d30;
        matrix4x3d2.m22 = d65 + (d54 * d25) + (d53 * d26);
        matrix4x3d2.m00 = d57;
        matrix4x3d2.m01 = d58;
        matrix4x3d2.m02 = d59;
        matrix4x3d2.m10 = d60;
        matrix4x3d2.m11 = d63;
        matrix4x3d2.m12 = d64;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    private Matrix4x3d lookAtLHGeneric(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d11 = d5 - d2;
        double d12 = d6 - d3;
        double d13 = d7 - d4;
        double e2 = a.e(d13, d13, (d12 * d12) + (d11 * d11), 1.0d);
        double d14 = d11 * e2;
        double d15 = d12 * e2;
        double d16 = d13 * e2;
        double d17 = (d9 * d16) - (d10 * d15);
        double d18 = (d10 * d14) - (d8 * d16);
        double d19 = (d8 * d15) - (d9 * d14);
        double e3 = a.e(d19, d19, (d18 * d18) + (d17 * d17), 1.0d);
        double d20 = d17 * e3;
        double d21 = d18 * e3;
        double d22 = d19 * e3;
        double d23 = (d15 * d22) - (d16 * d21);
        double d24 = (d16 * d20) - (d14 * d22);
        double d25 = (d14 * d21) - (d15 * d20);
        double d26 = d22;
        double d27 = -((d22 * d4) + (d21 * d3) + (d20 * d2));
        double d28 = d21;
        double d29 = -((d25 * d4) + (d24 * d3) + (d23 * d2));
        double d30 = d16;
        double d31 = -((d16 * d4) + (d15 * d3) + (d14 * d2));
        double d32 = d15;
        double d33 = this.m00;
        double d34 = d33 * d27;
        double d35 = d14;
        double d36 = this.m10;
        double d37 = (d36 * d29) + d34;
        double d38 = d36;
        double d39 = this.m20;
        double d40 = (d39 * d31) + d37;
        double d41 = d39;
        matrix4x3d2.m30 = d40 + this.m30;
        double d42 = this.m01;
        double d43 = d42 * d27;
        double d44 = d42;
        double d45 = this.m11;
        double d46 = (d45 * d29) + d43;
        double d47 = d45;
        double d48 = this.m21;
        double d49 = (d48 * d31) + d46;
        double d50 = d48;
        matrix4x3d2.m31 = d49 + this.m31;
        double d51 = this.m02;
        double d52 = d27 * d51;
        double d53 = d51;
        double d54 = this.m12;
        double d55 = (d29 * d54) + d52;
        double d56 = this.m22;
        matrix4x3d2.m32 = (d31 * d56) + d55 + this.m32;
        double d57 = (d41 * d35) + (d38 * d23) + (d33 * d20);
        double d58 = (d50 * d35) + (d47 * d23) + (d44 * d20);
        double d59 = (d56 * d35) + (d23 * d54) + (d20 * d53);
        double d60 = (d41 * d32) + (d38 * d24) + (d33 * d28);
        double d61 = (d50 * d32) + (d47 * d24) + (d44 * d28);
        double d62 = d32 * d56;
        double d63 = d61;
        double d64 = d62 + (d24 * d54) + (d53 * d28);
        matrix4x3d2.m20 = (d41 * d30) + (d38 * d25) + (d33 * d26);
        matrix4x3d2.m21 = (d50 * d30) + (d47 * d25) + (d44 * d26);
        double d65 = d56 * d30;
        matrix4x3d2.m22 = d65 + (d54 * d25) + (d53 * d26);
        matrix4x3d2.m00 = d57;
        matrix4x3d2.m01 = d58;
        matrix4x3d2.m02 = d59;
        matrix4x3d2.m10 = d60;
        matrix4x3d2.m11 = d63;
        matrix4x3d2.m12 = d64;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    private Matrix4x3d mulGeneric(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m022 = (matrix4x3dc.m02() * this.m20) + (matrix4x3dc.m01() * this.m10) + (matrix4x3dc.m00() * this.m00);
        double m023 = (matrix4x3dc.m02() * this.m21) + (matrix4x3dc.m01() * this.m11) + (matrix4x3dc.m00() * this.m01);
        double m024 = (matrix4x3dc.m02() * this.m22) + (matrix4x3dc.m01() * this.m12) + (matrix4x3dc.m00() * this.m02);
        double m122 = (matrix4x3dc.m12() * this.m20) + (matrix4x3dc.m11() * this.m10) + (matrix4x3dc.m10() * this.m00);
        double m123 = (matrix4x3dc.m12() * this.m21) + (matrix4x3dc.m11() * this.m11) + (matrix4x3dc.m10() * this.m01);
        double m124 = (matrix4x3dc.m12() * this.m22) + (matrix4x3dc.m11() * this.m12) + (matrix4x3dc.m10() * this.m02);
        double m222 = (matrix4x3dc.m22() * this.m20) + (matrix4x3dc.m21() * this.m10) + (matrix4x3dc.m20() * this.m00);
        double m223 = (matrix4x3dc.m22() * this.m21) + (matrix4x3dc.m21() * this.m11) + (matrix4x3dc.m20() * this.m01);
        double m224 = (matrix4x3dc.m22() * this.m22) + (matrix4x3dc.m21() * this.m12) + (matrix4x3dc.m20() * this.m02);
        double m322 = (matrix4x3dc.m32() * this.m20) + (matrix4x3dc.m31() * this.m10) + (matrix4x3dc.m30() * this.m00) + this.m30;
        double m323 = (matrix4x3dc.m32() * this.m21) + (matrix4x3dc.m31() * this.m11) + (matrix4x3dc.m30() * this.m01) + this.m31;
        double m324 = (matrix4x3dc.m32() * this.m22) + (matrix4x3dc.m31() * this.m12) + (matrix4x3dc.m30() * this.m02) + this.m32;
        matrix4x3d2.m00 = m022;
        matrix4x3d2.m01 = m023;
        matrix4x3d2.m02 = m024;
        matrix4x3d2.m10 = m122;
        matrix4x3d2.m11 = m123;
        matrix4x3d2.m12 = m124;
        matrix4x3d2.m20 = m222;
        matrix4x3d2.m21 = m223;
        matrix4x3d2.m22 = m224;
        matrix4x3d2.m30 = m322;
        matrix4x3d2.m31 = m323;
        matrix4x3d2.m32 = m324;
        matrix4x3d2.properties = this.properties & matrix4x3dc.properties() & 16;
        return matrix4x3d2;
    }

    private Matrix4x3d normalGeneric(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d5 * d6;
        double d8 = this.m02;
        double d9 = d8 * d6;
        double d10 = d6;
        double d11 = this.m12;
        double d12 = d2 * d11;
        double d13 = d5 * d11;
        double d14 = d8 * d3;
        double d15 = d4 - d7;
        double d16 = this.m22;
        double d17 = d15 * d16;
        double d18 = d9 - d12;
        double d19 = d2;
        double d20 = this.m21;
        double d21 = (d18 * d20) + d17;
        double d22 = d13 - d14;
        double d23 = this.m20;
        double l = a.l(d22, d23, d21, 1.0d);
        double d24 = d5;
        double c2 = a.c(d20, d11, d3 * d16, l);
        double d25 = l;
        double d26 = d23;
        double c3 = a.c(d10, d16, d11 * d23, d25);
        double d27 = d16;
        double c4 = a.c(d3, d23, d10 * d20, l);
        double d28 = d8;
        double d29 = d20;
        double d30 = c2;
        double d31 = d24;
        double c5 = a.c(d24, d27, d20 * d8, l);
        double c6 = a.c(d28, d26, d27 * d19, d25);
        double d32 = c4;
        double c7 = a.c(d19, d29, d26 * d31, l);
        double d33 = d22 * l;
        double d34 = d18 * l;
        double d35 = d15 * l;
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m00 = d30;
        matrix4x3d3.m01 = c3;
        matrix4x3d3.m02 = d32;
        matrix4x3d3.m10 = c5;
        matrix4x3d3.m11 = c6;
        matrix4x3d3.m12 = c7;
        matrix4x3d3.m20 = d33;
        matrix4x3d3.m21 = d34;
        matrix4x3d3.m22 = d35;
        matrix4x3d3.m30 = 0.0d;
        matrix4x3d3.m31 = 0.0d;
        matrix4x3d3.m32 = 0.0d;
        matrix4x3d3.properties = 16;
        return matrix4x3d3;
    }

    private Matrix4x3d normalOrthonormal(Matrix4x3d matrix4x3d) {
        if (matrix4x3d != this) {
            matrix4x3d.set((Matrix4x3dc) this);
        }
        matrix4x3d.properties = 16;
        return matrix4x3d;
    }

    private Matrix4x3d rotateAroundAffine(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d5 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double b4 = a.b(w, x, z, y);
        double d6 = d5 + a2;
        double d7 = b2 - a3;
        double d8 = d5 - a2;
        double f2 = a.f(y, z, w, x);
        double d9 = b3 + a4;
        double d10 = a3 + b2;
        double d11 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d12 = this.m00;
        double d13 = d12 * d2;
        double d14 = this.m10;
        double d15 = (d14 * d3) + d13;
        double d16 = this.m20;
        double d17 = (d16 * d4) + d15 + this.m30;
        double d18 = this.m01;
        double d19 = d18 * d2;
        double d20 = d17;
        double d21 = this.m11;
        double d22 = (d21 * d3) + d19;
        double d23 = this.m21;
        double d24 = (d23 * d4) + d22;
        double d25 = g2;
        double d26 = d24 + this.m31;
        double d27 = this.m02;
        double d28 = d27 * d2;
        double d29 = d27;
        double d30 = this.m12;
        double d31 = (d30 * d3) + d28;
        double d32 = d30;
        double d33 = this.m22;
        double d34 = (d33 * d4) + d31;
        double d35 = d33;
        double d36 = d34 + this.m32;
        double d37 = (d21 * d6) + (d18 * b4);
        double d38 = (d16 * d7) + (d14 * d6) + (d12 * b4);
        double d39 = (d6 * d32) + (b4 * d29);
        double d40 = d35 * d7;
        double d41 = (d23 * d7) + d37;
        double d42 = d40 + d39;
        double d43 = d42;
        double d44 = (d16 * d9) + (d14 * f2) + (d12 * d8);
        double d45 = d23 * d9;
        double d46 = d45 + (d21 * f2) + (d18 * d8);
        double d47 = (d35 * d9) + (d32 * f2) + (d29 * d8);
        double d48 = d16 * d25;
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3._m20(d48 + (d14 * d11) + (d12 * d10));
        matrix4x3d3._m21((this.m21 * d25) + (this.m11 * d11) + (this.m01 * d10));
        matrix4x3d3._m22((this.m22 * d25) + (this.m12 * d11) + (this.m02 * d10));
        double d49 = d38;
        matrix4x3d3._m00(d49);
        double d50 = d41;
        matrix4x3d3._m01(d50);
        double d51 = d43;
        matrix4x3d3._m02(d51);
        matrix4x3d3._m10(d44);
        matrix4x3d3._m11(d46);
        matrix4x3d3._m12(d47);
        matrix4x3d3._m30(((((-d49) * d2) - (d44 * d3)) - (this.m20 * d4)) + d20);
        matrix4x3d3._m31(((((-d50) * d2) - (d46 * d3)) - (this.m21 * d4)) + d26);
        matrix4x3d3._m32(((((-d51) * d2) - (d47 * d3)) - (this.m22 * d4)) + d36);
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    private Matrix4x3d rotateGeneric(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = (d3 * d3 * d6) + cosFromSin;
        double d8 = d3 * d4 * d6;
        double d9 = d5 * sin;
        double d10 = d8 + d9;
        double d11 = d3 * d5 * d6;
        double d12 = d4 * sin;
        double d13 = d11 - d12;
        double d14 = d8 - d9;
        double d15 = (d4 * d4 * d6) + cosFromSin;
        double d16 = d4 * d5 * d6;
        double d17 = sin * d3;
        double d18 = d16 + d17;
        double d19 = d11 + d12;
        double d20 = d16 - d17;
        double d21 = (d5 * d5 * d6) + cosFromSin;
        double d22 = this.m00;
        double d23 = d22 * d7;
        double d24 = this.m10;
        double d25 = (d24 * d10) + d23;
        double d26 = this.m20;
        double d27 = d19;
        double d28 = (d26 * d13) + d25;
        double d29 = this.m01;
        double d30 = d29 * d7;
        double d31 = d29;
        double d32 = this.m11;
        double d33 = (d32 * d10) + d30;
        double d34 = d32;
        double d35 = this.m21;
        double d36 = d35;
        double d37 = (d35 * d13) + d33;
        double d38 = this.m02;
        double d39 = d7 * d38;
        double d40 = d38;
        double d41 = this.m12;
        double d42 = (d10 * d41) + d39;
        double d43 = this.m22;
        double d44 = (d13 * d43) + d42;
        double d45 = d44;
        double d46 = (d26 * d18) + (d24 * d15) + (d22 * d14);
        double d47 = d46;
        double d48 = (d36 * d18) + (d34 * d15) + (d31 * d14);
        double d49 = d18 * d43;
        double d50 = d49 + (d15 * d41) + (d14 * d40);
        double d51 = d26 * d21;
        double d52 = d51 + (d24 * d20) + (d22 * d27);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        double d53 = d45;
        matrix4x3d3.m20 = d52;
        matrix4x3d3.m21 = (d36 * d21) + (d34 * d20) + (d31 * d27);
        double d54 = d43 * d21;
        matrix4x3d3.m22 = d54 + (d41 * d20) + (d40 * d27);
        matrix4x3d3.m00 = d28;
        matrix4x3d3.m01 = d37;
        matrix4x3d3.m02 = d53;
        matrix4x3d3.m10 = d47;
        matrix4x3d3.m11 = d48;
        matrix4x3d3.m12 = d50;
        matrix4x3d3.m30 = this.m30;
        matrix4x3d3.m31 = this.m31;
        matrix4x3d3.m32 = this.m32;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    private Matrix4x3d scaleGeneric(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00 * d2;
        matrix4x3d.m01 = this.m01 * d2;
        matrix4x3d.m02 = this.m02 * d2;
        matrix4x3d.m10 = this.m10 * d3;
        matrix4x3d.m11 = this.m11 * d3;
        matrix4x3d.m12 = this.m12 * d3;
        matrix4x3d.m20 = this.m20 * d4;
        matrix4x3d.m21 = this.m21 * d4;
        matrix4x3d.m22 = this.m22 * d4;
        matrix4x3d.m30 = this.m30;
        matrix4x3d.m31 = this.m31;
        matrix4x3d.m32 = this.m32;
        matrix4x3d.properties = this.properties & -29;
        return matrix4x3d;
    }

    private Matrix4x3d translateGeneric(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00;
        matrix4x3d.m01 = this.m01;
        matrix4x3d.m02 = this.m02;
        matrix4x3d.m10 = this.m10;
        matrix4x3d.m11 = this.m11;
        matrix4x3d.m12 = this.m12;
        matrix4x3d.m20 = this.m20;
        matrix4x3d.m21 = this.m21;
        matrix4x3d.m22 = this.m22;
        matrix4x3d.m30 = (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30;
        matrix4x3d.m31 = (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31;
        matrix4x3d.m32 = (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32;
        matrix4x3d.properties = this.properties & -5;
        return matrix4x3d;
    }

    public Matrix4x3d _m00(double d2) {
        this.m00 = d2;
        return this;
    }

    public Matrix4x3d _m01(double d2) {
        this.m01 = d2;
        return this;
    }

    public Matrix4x3d _m02(double d2) {
        this.m02 = d2;
        return this;
    }

    public Matrix4x3d _m10(double d2) {
        this.m10 = d2;
        return this;
    }

    public Matrix4x3d _m11(double d2) {
        this.m11 = d2;
        return this;
    }

    public Matrix4x3d _m12(double d2) {
        this.m12 = d2;
        return this;
    }

    public Matrix4x3d _m20(double d2) {
        this.m20 = d2;
        return this;
    }

    public Matrix4x3d _m21(double d2) {
        this.m21 = d2;
        return this;
    }

    public Matrix4x3d _m22(double d2) {
        this.m22 = d2;
        return this;
    }

    public Matrix4x3d _m30(double d2) {
        this.m30 = d2;
        return this;
    }

    public Matrix4x3d _m31(double d2) {
        this.m31 = d2;
        return this;
    }

    public Matrix4x3d _m32(double d2) {
        this.m32 = d2;
        return this;
    }

    public Matrix4x3d add(Matrix4x3dc matrix4x3dc) {
        return add(matrix4x3dc, this);
    }

    public Matrix4x3d arcball(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d8 = -d2;
        double d9 = (this.m20 * d8) + this.m30;
        double d10 = (this.m21 * d8) + this.m31;
        double d11 = (this.m22 * d8) + this.m32;
        double sin = Math.sin(d6);
        double cosFromSin = Math.cosFromSin(sin, d6);
        double d12 = this.m10;
        double d13 = d12 * cosFromSin;
        double d14 = this.m20;
        double d15 = (d14 * sin) + d13;
        double d16 = d11;
        double d17 = this.m11;
        double d18 = d17 * cosFromSin;
        double d19 = d9;
        double d20 = this.m21;
        double d21 = d15;
        double d22 = (d20 * sin) + d18;
        double d23 = this.m12;
        double d24 = d23 * cosFromSin;
        double d25 = d23;
        double d26 = this.m22;
        double d27 = (d26 * sin) + d24;
        double d28 = (d14 * cosFromSin) - (d12 * sin);
        double d29 = (d20 * cosFromSin) - (d17 * sin);
        double d30 = (d26 * cosFromSin) - (d25 * sin);
        double sin2 = Math.sin(d7);
        double cosFromSin2 = Math.cosFromSin(sin2, d7);
        double d31 = d27;
        double d32 = this.m00;
        double d33 = d31;
        double d34 = (d32 * cosFromSin2) - (d28 * sin2);
        double d35 = this.m01;
        double d36 = d29;
        double d37 = (d35 * cosFromSin2) - (d29 * sin2);
        double d38 = this.m02;
        double d39 = (d38 * cosFromSin2) - (d30 * sin2);
        double d40 = (d28 * cosFromSin2) + (d32 * sin2);
        double d41 = (d35 * sin2) + (d36 * cosFromSin2);
        double d42 = (d30 * cosFromSin2) + (d38 * sin2);
        double d43 = d22;
        double d44 = d40;
        double d45 = d42;
        double d46 = d37;
        double m = a.m(d40, d5, ((-d34) * d3) - (d21 * d4), d19);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m30 = m;
        matrix4x3d3.m31 = a.m(d41, d5, ((-d46) * d3) - (d43 * d4), d10);
        double d47 = ((-d39) * d3) - (d33 * d4);
        double d48 = d33;
        double d49 = d39;
        double d50 = d41;
        double d51 = d46;
        double d52 = d34;
        double d53 = d48;
        matrix4x3d3.m32 = a.m(d45, d5, d47, d16);
        matrix4x3d3.m20 = d44;
        matrix4x3d3.m21 = d50;
        matrix4x3d3.m22 = d45;
        matrix4x3d3.m10 = d21;
        matrix4x3d3.m11 = d43;
        matrix4x3d3.m12 = d53;
        matrix4x3d3.m00 = d52;
        matrix4x3d3.m01 = d51;
        matrix4x3d3.m02 = d49;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    public Matrix4x3d assume(int i2) {
        this.properties = i2;
        return this;
    }

    public Matrix4x3d billboardCylindrical(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        double x = vector3dc2.x() - vector3dc.x();
        double y = vector3dc2.y() - vector3dc.y();
        double z = vector3dc2.z() - vector3dc.z();
        double y2 = (vector3dc3.y() * z) - (vector3dc3.z() * y);
        double z2 = (vector3dc3.z() * x) - (vector3dc3.x() * z);
        double x2 = (vector3dc3.x() * y) - (vector3dc3.y() * x);
        double d2 = x2;
        double d3 = x2;
        double e2 = a.e(d2, d3, (z2 * z2) + (y2 * y2), 1.0d);
        double d4 = y2 * e2;
        double d5 = z2 * e2;
        double d6 = x2 * e2;
        double z3 = (vector3dc3.z() * d5) - (vector3dc3.y() * d6);
        double x3 = (vector3dc3.x() * d6) - (vector3dc3.z() * d4);
        double y3 = (vector3dc3.y() * d4) - (vector3dc3.x() * d5);
        double d7 = y3;
        double d8 = y3;
        double e3 = a.e(d7, d8, (x3 * x3) + (z3 * z3), 1.0d);
        double d9 = z3 * e3;
        double d10 = x3 * e3;
        double d11 = y3 * e3;
        this.m00 = d4;
        this.m01 = d5;
        this.m02 = d6;
        this.m10 = vector3dc3.x();
        this.m11 = vector3dc3.y();
        this.m12 = vector3dc3.z();
        this.m20 = d9;
        this.m21 = d10;
        this.m22 = d11;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.properties = 16;
        return this;
    }

    public Matrix4x3d billboardSpherical(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        double x = vector3dc2.x() - vector3dc.x();
        double y = vector3dc2.y() - vector3dc.y();
        double z = vector3dc2.z() - vector3dc.z();
        double e2 = a.e(z, z, (y * y) + (x * x), 1.0d);
        double d2 = x * e2;
        double d3 = y * e2;
        double d4 = z * e2;
        double y2 = (vector3dc3.y() * d4) - (vector3dc3.z() * d3);
        double z2 = (vector3dc3.z() * d2) - (vector3dc3.x() * d4);
        double x2 = (vector3dc3.x() * d3) - (vector3dc3.y() * d2);
        double e3 = a.e(x2, x2, (z2 * z2) + (y2 * y2), 1.0d);
        double d5 = y2 * e3;
        double d6 = z2 * e3;
        double d7 = x2 * e3;
        double d8 = (d3 * d7) - (d4 * d6);
        double d9 = d4;
        double d10 = (d4 * d5) - (d2 * d7);
        double d11 = d3;
        double d12 = (d2 * d6) - (d3 * d5);
        this.m00 = d5;
        this.m01 = d6;
        this.m02 = d7;
        this.m10 = d8;
        this.m11 = d10;
        this.m12 = d12;
        this.m20 = d2;
        this.m21 = d11;
        this.m22 = d9;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.properties = 16;
        return this;
    }

    public double determinant() {
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = (d4 - (d5 * d6)) * this.m22;
        double d8 = this.m02;
        double d9 = d6 * d8;
        double d10 = this.m12;
        return (((d5 * d10) - (d8 * d3)) * this.m20) + ((d9 - (d2 * d10)) * this.m21) + d7;
    }

    public Matrix4x3d determineProperties() {
        int i2;
        if (this.m00 == 1.0d && this.m01 == 0.0d && this.m02 == 0.0d && this.m10 == 0.0d && this.m11 == 1.0d && this.m12 == 0.0d && this.m20 == 0.0d && this.m21 == 0.0d && this.m22 == 1.0d) {
            i2 = 24;
            if (this.m30 == 0.0d && this.m31 == 0.0d && this.m32 == 0.0d) {
                i2 = 28;
            }
        } else {
            i2 = 0;
        }
        this.properties = i2;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Matrix4x3d)) {
            return false;
        }
        Matrix4x3d matrix4x3d = (Matrix4x3d) obj;
        return Double.doubleToLongBits(this.m00) == Double.doubleToLongBits(matrix4x3d.m00) && Double.doubleToLongBits(this.m01) == Double.doubleToLongBits(matrix4x3d.m01) && Double.doubleToLongBits(this.m02) == Double.doubleToLongBits(matrix4x3d.m02) && Double.doubleToLongBits(this.m10) == Double.doubleToLongBits(matrix4x3d.m10) && Double.doubleToLongBits(this.m11) == Double.doubleToLongBits(matrix4x3d.m11) && Double.doubleToLongBits(this.m12) == Double.doubleToLongBits(matrix4x3d.m12) && Double.doubleToLongBits(this.m20) == Double.doubleToLongBits(matrix4x3d.m20) && Double.doubleToLongBits(this.m21) == Double.doubleToLongBits(matrix4x3d.m21) && Double.doubleToLongBits(this.m22) == Double.doubleToLongBits(matrix4x3d.m22) && Double.doubleToLongBits(this.m30) == Double.doubleToLongBits(matrix4x3d.m30) && Double.doubleToLongBits(this.m31) == Double.doubleToLongBits(matrix4x3d.m31) && Double.doubleToLongBits(this.m32) == Double.doubleToLongBits(matrix4x3d.m32);
    }

    public Matrix4x3d fma(Matrix4x3dc matrix4x3dc, double d2) {
        return fma(matrix4x3dc, d2, this);
    }

    public Planed frustumPlane(int i2, Planed planed) {
        if (i2 == 0) {
            planed.set(this.m00, this.m10, this.m20, this.m30 + 1.0d).normalize(planed);
        } else if (i2 == 1) {
            planed.set(-this.m00, -this.m10, -this.m20, 1.0d - this.m30).normalize(planed);
        } else if (i2 == 2) {
            planed.set(this.m01, this.m11, this.m21, this.m31 + 1.0d).normalize(planed);
        } else if (i2 == 3) {
            planed.set(-this.m01, -this.m11, -this.m21, 1.0d - this.m31).normalize(planed);
        } else if (i2 == 4) {
            planed.set(this.m02, this.m12, this.m22, this.m32 + 1.0d).normalize(planed);
        } else if (i2 == 5) {
            planed.set(-this.m02, -this.m12, -this.m22, 1.0d - this.m32).normalize(planed);
        } else {
            throw new IllegalArgumentException("which");
        }
        return planed;
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set4x3((Matrix4x3dc) this);
    }

    public float[] get4x4(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy4x4(this, fArr, i2);
        return fArr;
    }

    public Vector3d getColumn(int i2, Vector3d vector3d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m01;
            vector3d.z = this.m02;
        } else if (i2 == 1) {
            vector3d.x = this.m10;
            vector3d.y = this.m11;
            vector3d.z = this.m12;
        } else if (i2 == 2) {
            vector3d.x = this.m20;
            vector3d.y = this.m21;
            vector3d.z = this.m22;
        } else if (i2 == 3) {
            vector3d.x = this.m30;
            vector3d.y = this.m31;
            vector3d.z = this.m32;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3d;
    }

    public Vector3d getEulerAnglesZYX(Vector3d vector3d) {
        vector3d.x = Math.atan2(this.m12, this.m22);
        double d2 = -this.m02;
        double d3 = this.m12;
        double d4 = d3 * d3;
        double d5 = this.m22;
        vector3d.y = Math.atan2(d2, Math.sqrt((d5 * d5) + d4));
        vector3d.z = Math.atan2(this.m01, this.m00);
        return vector3d;
    }

    public ByteBuffer getFloats(ByteBuffer byteBuffer) {
        return getFloats(byteBuffer.position(), byteBuffer);
    }

    public Quaternionf getNormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromNormalized((Matrix4x3dc) this);
    }

    public Vector4d getRow(int i2, Vector4d vector4d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector4d.x = this.m00;
            vector4d.y = this.m10;
            vector4d.z = this.m20;
            vector4d.w = this.m30;
        } else if (i2 == 1) {
            vector4d.x = this.m01;
            vector4d.y = this.m11;
            vector4d.z = this.m21;
            vector4d.w = this.m31;
        } else if (i2 == 2) {
            vector4d.x = this.m02;
            vector4d.y = this.m12;
            vector4d.z = this.m22;
            vector4d.w = this.m32;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector4d;
    }

    public Vector3d getScale(Vector3d vector3d) {
        double d2 = this.m00;
        double d3 = d2 * d2;
        double d4 = this.m01;
        double d5 = (d4 * d4) + d3;
        double d6 = this.m02;
        vector3d.x = Math.sqrt((d6 * d6) + d5);
        double d7 = this.m10;
        double d8 = d7 * d7;
        double d9 = this.m11;
        double d10 = (d9 * d9) + d8;
        double d11 = this.m12;
        vector3d.y = Math.sqrt((d11 * d11) + d10);
        double d12 = this.m20;
        double d13 = d12 * d12;
        double d14 = this.m21;
        double d15 = (d14 * d14) + d13;
        double d16 = this.m22;
        vector3d.z = Math.sqrt((d16 * d16) + d15);
        return vector3d;
    }

    public Vector3d getTranslation(Vector3d vector3d) {
        vector3d.x = this.m30;
        vector3d.y = this.m31;
        vector3d.z = this.m32;
        return vector3d;
    }

    public DoubleBuffer getTransposed(DoubleBuffer doubleBuffer) {
        return getTransposed(doubleBuffer.position(), doubleBuffer);
    }

    public ByteBuffer getTransposedFloats(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Quaternionf getUnnormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromUnnormalized((Matrix4x3dc) this);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.m00);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.m01);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.m02);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.m10);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.m11);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.m12);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.m20);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.m21);
        int i9 = (i8 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.m22);
        int i10 = (i9 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
        long doubleToLongBits10 = Double.doubleToLongBits(this.m30);
        int i11 = (i10 * 31) + ((int) (doubleToLongBits10 ^ (doubleToLongBits10 >>> 32)));
        long doubleToLongBits11 = Double.doubleToLongBits(this.m31);
        int i12 = (i11 * 31) + ((int) (doubleToLongBits11 ^ (doubleToLongBits11 >>> 32)));
        long doubleToLongBits12 = Double.doubleToLongBits(this.m32);
        return (i12 * 31) + ((int) ((doubleToLongBits12 >>> 32) ^ doubleToLongBits12));
    }

    public Matrix4x3d identity() {
        if ((this.properties & 4) != 0) {
            return this;
        }
        this.m00 = 1.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 1.0d;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 1.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 28;
        return this;
    }

    public Matrix4x3d invert() {
        return invert(this);
    }

    public Matrix4x3d invertOrtho(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = 1.0d / this.m00;
        double d3 = 1.0d / this.m11;
        double d4 = 1.0d / this.m22;
        matrix4x3d.set(d2, 0.0d, 0.0d, 0.0d, d3, 0.0d, 0.0d, 0.0d, d4, (-this.m30) * d2, (-this.m31) * d3, (-this.m32) * d4);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.properties = 0;
        return matrix4x3d3;
    }

    public Matrix4x3d lerp(Matrix4x3dc matrix4x3dc, double d2) {
        return lerp(matrix4x3dc, d2, this);
    }

    public Matrix4x3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Matrix4x3d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4x3d matrix4x3d) {
        return lookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), matrix4x3d);
    }

    public Matrix4x3d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4x3d matrix4x3d) {
        return lookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), matrix4x3d);
    }

    public double m00() {
        return this.m00;
    }

    public double m01() {
        return this.m01;
    }

    public double m02() {
        return this.m02;
    }

    public double m10() {
        return this.m10;
    }

    public double m11() {
        return this.m11;
    }

    public double m12() {
        return this.m12;
    }

    public double m20() {
        return this.m20;
    }

    public double m21() {
        return this.m21;
    }

    public double m22() {
        return this.m22;
    }

    public double m30() {
        return this.m30;
    }

    public double m31() {
        return this.m31;
    }

    public double m32() {
        return this.m32;
    }

    public Matrix4x3d mul(Matrix4x3dc matrix4x3dc) {
        return mul(matrix4x3dc, this);
    }

    public Matrix4x3d mulComponentWise(Matrix4x3dc matrix4x3dc) {
        return mulComponentWise(matrix4x3dc, this);
    }

    public Matrix4x3d mulOrtho(Matrix4x3dc matrix4x3dc) {
        return mulOrtho(matrix4x3dc, this);
    }

    public Matrix4x3d mulTranslation(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m002 = matrix4x3dc.m00();
        double m012 = matrix4x3dc.m01();
        double m022 = matrix4x3dc.m02();
        double m102 = matrix4x3dc.m10();
        double m112 = matrix4x3dc.m11();
        double m122 = matrix4x3dc.m12();
        double m202 = matrix4x3dc.m20();
        double m212 = matrix4x3dc.m21();
        double m222 = matrix4x3dc.m22();
        double m302 = matrix4x3dc.m30() + this.m30;
        double m312 = matrix4x3dc.m31() + this.m31;
        double m322 = matrix4x3dc.m32() + this.m32;
        matrix4x3d2.m00 = m002;
        matrix4x3d2.m01 = m012;
        matrix4x3d2.m02 = m022;
        matrix4x3d2.m10 = m102;
        matrix4x3d2.m11 = m112;
        matrix4x3d2.m12 = m122;
        matrix4x3d2.m20 = m202;
        matrix4x3d2.m21 = m212;
        matrix4x3d2.m22 = m222;
        matrix4x3d2.m30 = m302;
        matrix4x3d2.m31 = m312;
        matrix4x3d2.m32 = m322;
        matrix4x3d2.properties = matrix4x3dc.properties() & 16;
        return matrix4x3d2;
    }

    public Matrix4x3d normal() {
        return normal(this);
    }

    public Matrix4x3d normalize3x3() {
        return normalize3x3(this);
    }

    public Vector3d normalizedPositiveX(Vector3d vector3d) {
        vector3d.x = this.m00;
        vector3d.y = this.m10;
        vector3d.z = this.m20;
        return vector3d;
    }

    public Vector3d normalizedPositiveY(Vector3d vector3d) {
        vector3d.x = this.m01;
        vector3d.y = this.m11;
        vector3d.z = this.m21;
        return vector3d;
    }

    public Vector3d normalizedPositiveZ(Vector3d vector3d) {
        vector3d.x = this.m02;
        vector3d.y = this.m12;
        vector3d.z = this.m22;
        return vector3d;
    }

    public Matrix4x3d obliqueZ(double d2, double d3) {
        this.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        this.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        this.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        this.properties = 0;
        return this;
    }

    public Vector3d origin(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d4 - (d5 * d6);
        double d8 = this.m12;
        double d9 = d2 * d8;
        double d10 = d7;
        double d11 = this.m02;
        double d12 = (d5 * d8) - (d11 * d3);
        double d13 = d9 - (d11 * d6);
        double d14 = this.m20;
        double d15 = d11;
        double d16 = this.m31;
        double d17 = d14 * d16;
        double d18 = d5;
        double d19 = this.m21;
        double d20 = d2;
        double d21 = this.m30;
        double d22 = d17 - (d19 * d21);
        double d23 = d8;
        double d24 = this.m32;
        double d25 = d14 * d24;
        double d26 = d3;
        double d27 = this.m22;
        double d28 = d25 - (d27 * d21);
        double d29 = (d19 * d24) - (d27 * d16);
        vector3d2.x = ((d26 * d28) + ((-d6) * d29)) - (d23 * d22);
        vector3d2.y = (d15 * d22) + ((d20 * d29) - (d18 * d28));
        vector3d2.z = ((d16 * d13) + ((-d21) * d12)) - (d24 * d10);
        return vector3d2;
    }

    public Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d8 = 2.0d;
        double d9 = 2.0d / (d3 - d2);
        double d10 = 2.0d / (d5 - d4);
        if (z) {
            d8 = 1.0d;
        }
        double d11 = d6 - d7;
        double d12 = d8 / d11;
        double d13 = (d2 + d3) / (d2 - d3);
        double d14 = (d5 + d4) / (d4 - d5);
        double d15 = (z ? d6 : d7 + d6) / d11;
        double d16 = this.m00;
        double d17 = d16 * d13;
        double d18 = d12;
        double d19 = this.m10;
        double d20 = (d19 * d14) + d17;
        double d21 = d19;
        double d22 = this.m20;
        double d23 = (d22 * d15) + d20;
        double d24 = d22;
        matrix4x3d2.m30 = d23 + this.m30;
        double d25 = this.m01;
        double d26 = d25 * d13;
        double d27 = d10;
        double d28 = this.m11;
        double d29 = (d28 * d14) + d26;
        double d30 = d28;
        double d31 = this.m21;
        double d32 = (d31 * d15) + d29;
        double d33 = d31;
        matrix4x3d2.m31 = d32 + this.m31;
        double d34 = this.m02;
        double d35 = d13 * d34;
        double d36 = d34;
        double d37 = this.m12;
        double d38 = (d14 * d37) + d35;
        double d39 = this.m22;
        matrix4x3d2.m32 = (d15 * d39) + d38 + this.m32;
        matrix4x3d2.m00 = d16 * d9;
        matrix4x3d2.m01 = d25 * d9;
        matrix4x3d2.m02 = d9 * d36;
        matrix4x3d2.m10 = d21 * d27;
        matrix4x3d2.m11 = d30 * d27;
        matrix4x3d2.m12 = d37 * d27;
        matrix4x3d2.m20 = d24 * d18;
        matrix4x3d2.m21 = d33 * d18;
        matrix4x3d2.m22 = d39 * d18;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d ortho2D(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d6 = d3 - d2;
        double d7 = 2.0d / d6;
        double d8 = d5 - d4;
        double d9 = 2.0d / d8;
        double d10 = (-(d3 + d2)) / d6;
        double d11 = (-(d5 + d4)) / d8;
        double d12 = this.m00;
        double d13 = d12 * d10;
        double d14 = this.m10;
        matrix4x3d2.m30 = (d14 * d11) + d13 + this.m30;
        double d15 = this.m01;
        double d16 = d15 * d10;
        double d17 = d9;
        double d18 = this.m11;
        double d19 = (d18 * d11) + d16;
        double d20 = d18;
        matrix4x3d2.m31 = d19 + this.m31;
        double d21 = this.m02;
        double d22 = d10 * d21;
        double d23 = d14;
        double d24 = this.m12;
        matrix4x3d2.m32 = (d11 * d24) + d22 + this.m32;
        matrix4x3d2.m00 = d12 * d7;
        matrix4x3d2.m01 = d15 * d7;
        matrix4x3d2.m02 = d21 * d7;
        matrix4x3d2.m10 = d23 * d17;
        matrix4x3d2.m11 = d20 * d17;
        matrix4x3d2.m12 = d24 * d17;
        matrix4x3d2.m20 = -this.m20;
        matrix4x3d2.m21 = -this.m21;
        matrix4x3d2.m22 = -this.m22;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d ortho2DLH(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d6 = d3 - d2;
        double d7 = 2.0d / d6;
        double d8 = d5 - d4;
        double d9 = 2.0d / d8;
        double d10 = (-(d3 + d2)) / d6;
        double d11 = (-(d5 + d4)) / d8;
        double d12 = this.m00;
        double d13 = d12 * d10;
        double d14 = this.m10;
        matrix4x3d2.m30 = (d14 * d11) + d13 + this.m30;
        double d15 = this.m01;
        double d16 = d15 * d10;
        double d17 = d9;
        double d18 = this.m11;
        double d19 = (d18 * d11) + d16;
        double d20 = d18;
        matrix4x3d2.m31 = d19 + this.m31;
        double d21 = this.m02;
        double d22 = d10 * d21;
        double d23 = d14;
        double d24 = this.m12;
        matrix4x3d2.m32 = (d11 * d24) + d22 + this.m32;
        matrix4x3d2.m00 = d12 * d7;
        matrix4x3d2.m01 = d15 * d7;
        matrix4x3d2.m02 = d21 * d7;
        matrix4x3d2.m10 = d23 * d17;
        matrix4x3d2.m11 = d20 * d17;
        matrix4x3d2.m12 = d24 * d17;
        matrix4x3d2.m20 = this.m20;
        matrix4x3d2.m21 = this.m21;
        matrix4x3d2.m22 = this.m22;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d8 = 2.0d;
        double d9 = 2.0d / (d3 - d2);
        double d10 = 2.0d / (d5 - d4);
        if (z) {
            d8 = 1.0d;
        }
        double d11 = d8 / (d7 - d6);
        double d12 = (d2 + d3) / (d2 - d3);
        double d13 = (d5 + d4) / (d4 - d5);
        double d14 = (z ? d6 : d7 + d6) / (d6 - d7);
        double d15 = this.m00;
        double d16 = d15 * d12;
        double d17 = d11;
        double d18 = this.m10;
        double d19 = (d18 * d13) + d16;
        double d20 = d18;
        double d21 = this.m20;
        double d22 = (d21 * d14) + d19;
        double d23 = d21;
        matrix4x3d2.m30 = d22 + this.m30;
        double d24 = this.m01;
        double d25 = d24 * d12;
        double d26 = d10;
        double d27 = this.m11;
        double d28 = (d27 * d13) + d25;
        double d29 = d27;
        double d30 = this.m21;
        double d31 = (d30 * d14) + d28;
        double d32 = d30;
        matrix4x3d2.m31 = d31 + this.m31;
        double d33 = this.m02;
        double d34 = d12 * d33;
        double d35 = d33;
        double d36 = this.m12;
        double d37 = (d13 * d36) + d34;
        double d38 = this.m22;
        matrix4x3d2.m32 = (d14 * d38) + d37 + this.m32;
        matrix4x3d2.m00 = d15 * d9;
        matrix4x3d2.m01 = d24 * d9;
        matrix4x3d2.m02 = d9 * d35;
        matrix4x3d2.m10 = d20 * d26;
        matrix4x3d2.m11 = d29 * d26;
        matrix4x3d2.m12 = d36 * d26;
        matrix4x3d2.m20 = d23 * d17;
        matrix4x3d2.m21 = d32 * d17;
        matrix4x3d2.m22 = d38 * d17;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d6 = 2.0d;
        double d7 = 2.0d / d2;
        double d8 = 2.0d / d3;
        if (z) {
            d6 = 1.0d;
        }
        double d9 = d4 - d5;
        double d10 = d6 / d9;
        double d11 = (z ? d4 : d5 + d4) / d9;
        double d12 = this.m20;
        matrix4x3d2.m30 = (d12 * d11) + this.m30;
        double d13 = this.m21;
        double d14 = d13;
        matrix4x3d2.m31 = (d13 * d11) + this.m31;
        double d15 = this.m22;
        matrix4x3d2.m32 = (d11 * d15) + this.m32;
        matrix4x3d2.m00 = this.m00 * d7;
        matrix4x3d2.m01 = this.m01 * d7;
        matrix4x3d2.m02 = this.m02 * d7;
        matrix4x3d2.m10 = this.m10 * d8;
        matrix4x3d2.m11 = this.m11 * d8;
        matrix4x3d2.m12 = this.m12 * d8;
        matrix4x3d2.m20 = d12 * d10;
        matrix4x3d2.m21 = d14 * d10;
        matrix4x3d2.m22 = d15 * d10;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d6 = 2.0d;
        double d7 = 2.0d / d2;
        double d8 = 2.0d / d3;
        if (z) {
            d6 = 1.0d;
        }
        double d9 = d6 / (d5 - d4);
        double d10 = (z ? d4 : d5 + d4) / (d4 - d5);
        double d11 = this.m20;
        matrix4x3d2.m30 = (d11 * d10) + this.m30;
        double d12 = this.m21;
        double d13 = d12;
        matrix4x3d2.m31 = (d12 * d10) + this.m31;
        double d14 = this.m22;
        matrix4x3d2.m32 = (d10 * d14) + this.m32;
        matrix4x3d2.m00 = this.m00 * d7;
        matrix4x3d2.m01 = this.m01 * d7;
        matrix4x3d2.m02 = this.m02 * d7;
        matrix4x3d2.m10 = this.m10 * d8;
        matrix4x3d2.m11 = this.m11 * d8;
        matrix4x3d2.m12 = this.m12 * d8;
        matrix4x3d2.m20 = d11 * d9;
        matrix4x3d2.m21 = d13 * d9;
        matrix4x3d2.m22 = d14 * d9;
        matrix4x3d2.properties = this.properties & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d pick(double d2, double d3, double d4, double d5, int[] iArr, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d6 = ((double) iArr[2]) / d4;
        double d7 = ((double) iArr[3]) / d5;
        double d8 = (((((double) iArr[0]) - d2) * 2.0d) + ((double) iArr[2])) / d4;
        double d9 = (((((double) iArr[1]) - d3) * 2.0d) + ((double) iArr[3])) / d5;
        double d10 = this.m00;
        double d11 = d10 * d8;
        double d12 = d6;
        double d13 = this.m10;
        matrix4x3d2.m30 = (d13 * d9) + d11 + this.m30;
        double d14 = this.m01;
        double d15 = d14 * d8;
        double d16 = this.m11;
        double d17 = (d16 * d9) + d15;
        double d18 = d16;
        matrix4x3d2.m31 = d17 + this.m31;
        double d19 = this.m02;
        double d20 = d8 * d19;
        double d21 = d13;
        double d22 = this.m12;
        matrix4x3d2.m32 = (d9 * d22) + d20 + this.m32;
        matrix4x3d2.m00 = d10 * d12;
        matrix4x3d2.m01 = d14 * d12;
        matrix4x3d2.m02 = d19 * d12;
        matrix4x3d2.m10 = d21 * d7;
        matrix4x3d2.m11 = d18 * d7;
        matrix4x3d2.m12 = d22 * d7;
        matrix4x3d2.properties = 0;
        return matrix4x3d2;
    }

    public Vector3d positiveX(Vector3d vector3d) {
        double d2 = this.m11;
        double d3 = this.m22;
        double d4 = d2 * d3;
        double d5 = this.m12;
        double d6 = this.m21;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m02;
        double d8 = d6 * d7;
        double d9 = this.m01;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public Vector3d positiveY(Vector3d vector3d) {
        double d2 = this.m12;
        double d3 = this.m20;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = this.m22;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m00;
        double d8 = d6 * d7;
        double d9 = this.m02;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public Vector3d positiveZ(Vector3d vector3d) {
        double d2 = this.m10;
        double d3 = this.m21;
        double d4 = d2 * d3;
        double d5 = this.m11;
        double d6 = this.m20;
        vector3d.x = d4 - (d5 * d6);
        double d7 = this.m01;
        double d8 = d6 * d7;
        double d9 = this.m00;
        vector3d.y = d8 - (d3 * d9);
        vector3d.z = (d9 * d5) - (d7 * d2);
        return vector3d.normalize(vector3d);
    }

    public int properties() {
        return this.properties;
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readDouble();
        this.m01 = objectInput.readDouble();
        this.m02 = objectInput.readDouble();
        this.m10 = objectInput.readDouble();
        this.m11 = objectInput.readDouble();
        this.m12 = objectInput.readDouble();
        this.m20 = objectInput.readDouble();
        this.m21 = objectInput.readDouble();
        this.m22 = objectInput.readDouble();
        this.m30 = objectInput.readDouble();
        this.m31 = objectInput.readDouble();
        this.m32 = objectInput.readDouble();
        this.properties = 0;
    }

    public Matrix4x3d reflect(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.reflection(d2, d3, d4, d5);
        }
        double d6 = d2 + d2;
        double d7 = d3 + d3;
        double d8 = d4 + d4;
        double d9 = d5 + d5;
        double d10 = 1.0d - (d6 * d2);
        double d11 = -d6;
        double d12 = d11 * d3;
        double d13 = d11 * d4;
        double d14 = -d7;
        double d15 = d14 * d2;
        double d16 = 1.0d - (d7 * d3);
        double d17 = d14 * d4;
        double d18 = -d8;
        double d19 = d18 * d2;
        double d20 = d18 * d3;
        double d21 = -d9;
        double d22 = d21 * d2;
        double d23 = d21 * d3;
        double d24 = d21 * d4;
        double d25 = 1.0d - (d8 * d4);
        double d26 = this.m00;
        double d27 = d26 * d22;
        double d28 = d20;
        double d29 = this.m10;
        double d30 = (d29 * d23) + d27;
        double d31 = d16;
        double d32 = this.m20;
        double d33 = (d32 * d24) + d30;
        int i3 = i2;
        double d34 = d13;
        matrix4x3d2.m30 = d33 + this.m30;
        double d35 = this.m01;
        double d36 = d35 * d22;
        double d37 = d35;
        double d38 = this.m11;
        double d39 = (d38 * d23) + d36;
        double d40 = d38;
        double d41 = this.m21;
        double d42 = (d41 * d24) + d39;
        double d43 = d41;
        matrix4x3d2.m31 = d42 + this.m31;
        double d44 = this.m02;
        double d45 = d22 * d44;
        double d46 = d44;
        double d47 = this.m12;
        double d48 = (d23 * d47) + d45;
        double d49 = d47;
        double d50 = this.m22;
        double d51 = (d24 * d50) + d48;
        double d52 = d50;
        matrix4x3d2.m32 = d51 + this.m32;
        double d53 = d32 * d34;
        double d54 = d53 + (d29 * d12) + (d26 * d10);
        double d55 = (d43 * d34) + (d40 * d12) + (d37 * d10);
        double d56 = (d52 * d34) + (d12 * d49) + (d10 * d46);
        double d57 = (d32 * d17) + (d29 * d31) + (d26 * d15);
        double d58 = d57;
        double d59 = (d49 * d31) + (d46 * d15);
        double d60 = d52 * d17;
        double d61 = (d43 * d17) + (d40 * d31) + (d37 * d15);
        double d62 = d60 + d59;
        double d63 = d32 * d25;
        matrix4x3d2.m20 = d63 + (d29 * d28) + (d26 * d19);
        matrix4x3d2.m21 = (d43 * d25) + (d40 * d28) + (d37 * d19);
        matrix4x3d2.m22 = (d52 * d25) + (d49 * d28) + (d46 * d19);
        matrix4x3d2.m00 = d54;
        matrix4x3d2.m01 = d55;
        matrix4x3d2.m02 = d56;
        matrix4x3d2.m10 = d58;
        matrix4x3d2.m11 = d61;
        matrix4x3d2.m12 = d62;
        matrix4x3d2.properties = i3 & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d reflection(double d2, double d3, double d4, double d5) {
        double d6 = d2 + d2;
        double d7 = d3 + d3;
        double d8 = d4 + d4;
        double d9 = d5 + d5;
        this.m00 = 1.0d - (d6 * d2);
        double d10 = -d6;
        this.m01 = d10 * d3;
        this.m02 = d10 * d4;
        double d11 = -d7;
        this.m10 = d11 * d2;
        this.m11 = 1.0d - (d7 * d3);
        this.m12 = d11 * d4;
        double d12 = -d8;
        this.m20 = d12 * d2;
        this.m21 = d12 * d3;
        this.m22 = 1.0d - (d8 * d4);
        double d13 = -d9;
        this.m30 = d13 * d2;
        this.m31 = d13 * d3;
        this.m32 = d13 * d4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotate(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.rotation(d2, d3, d4, d5);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(d2, d3, d4, d5, matrix4x3d);
        }
        return rotateGeneric(d2, d3, d4, d5, matrix4x3d);
    }

    public Matrix4x3d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4) {
        return rotateAround(quaterniondc, d2, d3, d4, this);
    }

    public Matrix4x3d rotateLocal(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = (d3 * d3 * d6) + cosFromSin;
        double d8 = d3 * d4 * d6;
        double d9 = d5 * sin;
        double d10 = d8 + d9;
        double d11 = d3 * d5 * d6;
        double d12 = d4 * sin;
        double d13 = d11 - d12;
        double d14 = d8 - d9;
        double d15 = (d4 * d4 * d6) + cosFromSin;
        double d16 = d4 * d5 * d6;
        double d17 = sin * d3;
        double d18 = d16 + d17;
        double d19 = d11 + d12;
        double d20 = d16 - d17;
        double d21 = (d5 * d5 * d6) + cosFromSin;
        double d22 = this.m00;
        double d23 = d7 * d22;
        double d24 = this.m01;
        double d25 = (d14 * d24) + d23;
        double d26 = this.m02;
        double d27 = d19;
        double d28 = (d19 * d26) + d25;
        double d29 = (d20 * d26) + (d15 * d24) + (d10 * d22);
        double d30 = d26 * d21;
        double d31 = d30 + (d24 * d18) + (d22 * d13);
        double d32 = this.m10;
        double d33 = d7 * d32;
        double d34 = d31;
        double d35 = this.m11;
        double d36 = (d14 * d35) + d33;
        double d37 = this.m12;
        double d38 = d29;
        double d39 = (d27 * d37) + d36;
        double d40 = (d20 * d37) + (d15 * d35) + (d10 * d32);
        double d41 = d37 * d21;
        double d42 = d41 + (d35 * d18) + (d32 * d13);
        double d43 = this.m20;
        double d44 = d7 * d43;
        double d45 = d42;
        double d46 = this.m21;
        double d47 = (d14 * d46) + d44;
        double d48 = this.m22;
        double d49 = d40;
        double d50 = (d27 * d48) + d47;
        double d51 = (d20 * d48) + (d15 * d46) + (d10 * d43);
        double d52 = d48 * d21;
        double d53 = d52 + (d46 * d18) + (d43 * d13);
        double d54 = this.m30;
        double d55 = d7 * d54;
        double d56 = this.m31;
        double d57 = (d14 * d56) + d55;
        double d58 = this.m32;
        double d59 = (d27 * d58) + d57;
        double d60 = d20 * d58;
        double d61 = d60 + (d15 * d56) + (d10 * d54);
        double d62 = d21 * d58;
        double d63 = d62 + (d18 * d56) + (d13 * d54);
        matrix4x3d2.m00 = d28;
        matrix4x3d2.m01 = d38;
        matrix4x3d2.m02 = d34;
        matrix4x3d2.m10 = d39;
        matrix4x3d2.m11 = d49;
        matrix4x3d2.m12 = d45;
        matrix4x3d2.m20 = d50;
        matrix4x3d2.m21 = d51;
        matrix4x3d2.m22 = d53;
        matrix4x3d2.m30 = d59;
        matrix4x3d2.m31 = d61;
        matrix4x3d2.m32 = d63;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateLocalX(double d2, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.m01;
        double d4 = cosFromSin * d3;
        double d5 = this.m02;
        double d6 = d4 - (sin * d5);
        double d7 = (d5 * cosFromSin) + (d3 * sin);
        double d8 = this.m11;
        double d9 = cosFromSin * d8;
        double d10 = this.m12;
        double d11 = d9 - (sin * d10);
        double d12 = (d10 * cosFromSin) + (d8 * sin);
        double d13 = this.m21;
        double d14 = cosFromSin * d13;
        double d15 = d12;
        double d16 = this.m22;
        double d17 = d11;
        double d18 = d14 - (sin * d16);
        double d19 = (d16 * cosFromSin) + (d13 * sin);
        double d20 = this.m31;
        double d21 = cosFromSin * d20;
        double d22 = d19;
        double d23 = this.m32;
        double d24 = d18;
        double d25 = d21 - (sin * d23);
        double d26 = (cosFromSin * d23) + (sin * d20);
        matrix4x3d2.m00 = this.m00;
        matrix4x3d2.m01 = d6;
        matrix4x3d2.m02 = d7;
        matrix4x3d2.m10 = this.m10;
        matrix4x3d2.m11 = d17;
        matrix4x3d2.m12 = d15;
        matrix4x3d2.m20 = this.m20;
        matrix4x3d2.m21 = d24;
        matrix4x3d2.m22 = d22;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = d25;
        matrix4x3d2.m32 = d26;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateLocalY(double d2, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = this.m00;
        double d4 = cosFromSin * d3;
        double d5 = this.m02;
        double d6 = (sin * d5) + d4;
        double d7 = -sin;
        double d8 = (d5 * cosFromSin) + (d3 * d7);
        double d9 = this.m10;
        double d10 = cosFromSin * d9;
        double d11 = d8;
        double d12 = this.m12;
        double d13 = (sin * d12) + d10;
        double d14 = (d12 * cosFromSin) + (d9 * d7);
        double d15 = this.m20;
        double d16 = cosFromSin * d15;
        double d17 = d14;
        double d18 = this.m22;
        double d19 = d13;
        double d20 = (sin * d18) + d16;
        double d21 = (d18 * cosFromSin) + (d15 * d7);
        double d22 = this.m30;
        double d23 = cosFromSin * d22;
        double d24 = d21;
        double d25 = this.m32;
        double d26 = (sin * d25) + d23;
        double d27 = (cosFromSin * d25) + (d7 * d22);
        matrix4x3d2.m00 = d6;
        matrix4x3d2.m01 = this.m01;
        matrix4x3d2.m02 = d11;
        matrix4x3d2.m10 = d19;
        matrix4x3d2.m11 = this.m11;
        matrix4x3d2.m12 = d17;
        matrix4x3d2.m20 = d20;
        matrix4x3d2.m21 = this.m21;
        matrix4x3d2.m22 = d24;
        matrix4x3d2.m30 = d26;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = d27;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateLocalZ(double d2, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
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
        double d19 = (d16 * cosFromSin) + (d13 * sin);
        double d20 = this.m30;
        double d21 = cosFromSin * d20;
        double d22 = d19;
        double d23 = this.m31;
        double d24 = d18;
        double d25 = d21 - (sin * d23);
        double d26 = (cosFromSin * d23) + (sin * d20);
        matrix4x3d2.m00 = d6;
        matrix4x3d2.m01 = d7;
        matrix4x3d2.m02 = this.m02;
        matrix4x3d2.m10 = d17;
        matrix4x3d2.m11 = d15;
        matrix4x3d2.m12 = this.m12;
        matrix4x3d2.m20 = d24;
        matrix4x3d2.m21 = d22;
        matrix4x3d2.m22 = this.m22;
        matrix4x3d2.m30 = d25;
        matrix4x3d2.m31 = d26;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4x3d);
    }

    public Matrix4x3d rotateTranslation(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = d4 * d5;
        double d8 = d5 * d5;
        double d9 = d3 * d4 * d6;
        double d10 = d5 * sin;
        double d11 = (d3 * d3 * d6) + cosFromSin;
        double d12 = d3 * d5 * d6;
        double d13 = d4 * sin;
        double d14 = d9 + d10;
        double d15 = d12 - d13;
        double d16 = d9 - d10;
        double d17 = d7 * d6;
        double d18 = sin * d3;
        double d19 = (d4 * d4 * d6) + cosFromSin;
        double d20 = d17 + d18;
        double d21 = d17 - d18;
        double d22 = (d8 * d6) + cosFromSin;
        matrix4x3d2.m20 = d12 + d13;
        matrix4x3d2.m21 = d21;
        matrix4x3d2.m22 = d22;
        matrix4x3d2.m00 = d11;
        matrix4x3d2.m01 = d14;
        matrix4x3d2.m02 = d15;
        matrix4x3d2.m10 = d16;
        matrix4x3d2.m11 = d19;
        matrix4x3d2.m12 = d20;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateX(double d2, Matrix4x3d matrix4x3d) {
        double d3 = d2;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d2.rotationX(d3);
        }
        double d4 = -1.0d;
        double d5 = 0.0d;
        if (!(d3 == 3.141592653589793d || d3 == -3.141592653589793d)) {
            if (d3 == 1.5707963267948966d || d3 == -4.71238898038469d) {
                d4 = 1.0d;
            } else if (!(d3 == -1.5707963267948966d || d3 == 4.71238898038469d)) {
                double sin = Math.sin(d2);
                d5 = sin;
                d4 = Math.cosFromSin(sin, d3);
            }
            double d6 = d4;
            d4 = 0.0d;
            d5 = d6;
        }
        double d7 = -d5;
        double d8 = this.m10;
        double d9 = d8 * d4;
        double d10 = this.m20;
        double d11 = d9 + (d10 * d5);
        double d12 = this.m11;
        double d13 = d12 * d4;
        double d14 = d12;
        double d15 = this.m21;
        double d16 = d15;
        double d17 = (d15 * d5) + d13;
        double d18 = this.m12;
        double d19 = d18 * d4;
        double d20 = d18;
        double d21 = this.m22;
        double d22 = (d5 * d21) + d19;
        matrix4x3d2.m20 = (d10 * d4) + (d8 * d7);
        matrix4x3d2.m21 = (d16 * d4) + (d14 * d7);
        matrix4x3d2.m22 = (d21 * d4) + (d7 * d20);
        matrix4x3d2.m10 = d11;
        matrix4x3d2.m11 = d17;
        matrix4x3d2.m12 = d22;
        matrix4x3d2.m00 = this.m00;
        matrix4x3d2.m01 = this.m01;
        matrix4x3d2.m02 = this.m02;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateXYZ(Vector3d vector3d) {
        return rotateXYZ(vector3d.x, vector3d.y, vector3d.z);
    }

    public Matrix4x3d rotateY(double d2, Matrix4x3d matrix4x3d) {
        double d3 = d2;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d2.rotationY(d3);
        }
        double d4 = -1.0d;
        double d5 = 0.0d;
        if (!(d3 == 3.141592653589793d || d3 == -3.141592653589793d)) {
            if (d3 == 1.5707963267948966d || d3 == -4.71238898038469d) {
                d4 = 1.0d;
            } else if (!(d3 == -1.5707963267948966d || d3 == 4.71238898038469d)) {
                double sin = Math.sin(d2);
                d5 = sin;
                d4 = Math.cosFromSin(sin, d3);
            }
            double d6 = d4;
            d4 = 0.0d;
            d5 = d6;
        }
        double d7 = -d5;
        double d8 = this.m00;
        double d9 = d8 * d4;
        double d10 = this.m20;
        double d11 = d9 + (d10 * d7);
        double d12 = this.m01;
        double d13 = d12 * d4;
        double d14 = d12;
        double d15 = this.m21;
        double d16 = d15;
        double d17 = (d15 * d7) + d13;
        double d18 = this.m02;
        double d19 = d18 * d4;
        double d20 = d18;
        double d21 = this.m22;
        double d22 = (d7 * d21) + d19;
        matrix4x3d2.m20 = (d10 * d4) + (d8 * d5);
        matrix4x3d2.m21 = (d16 * d4) + (d14 * d5);
        matrix4x3d2.m22 = (d21 * d4) + (d5 * d20);
        matrix4x3d2.m00 = d11;
        matrix4x3d2.m01 = d17;
        matrix4x3d2.m02 = d22;
        matrix4x3d2.m10 = this.m10;
        matrix4x3d2.m11 = this.m11;
        matrix4x3d2.m12 = this.m12;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateYXZ(Vector3d vector3d) {
        return rotateYXZ(vector3d.y, vector3d.x, vector3d.z);
    }

    public Matrix4x3d rotateZ(double d2, Matrix4x3d matrix4x3d) {
        double d3 = d2;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d2.rotationZ(d3);
        }
        double d4 = -1.0d;
        double d5 = 0.0d;
        if (!(d3 == 3.141592653589793d || d3 == -3.141592653589793d)) {
            if (d3 == 1.5707963267948966d || d3 == -4.71238898038469d) {
                d4 = 1.0d;
            } else if (!(d3 == -1.5707963267948966d || d3 == 4.71238898038469d)) {
                double sin = Math.sin(d2);
                d5 = sin;
                d4 = Math.cosFromSin(sin, d3);
            }
            double d6 = d4;
            d4 = 0.0d;
            d5 = d6;
        }
        double d7 = -d5;
        double d8 = this.m00;
        double d9 = d8 * d4;
        double d10 = this.m10;
        double d11 = d9 + (d10 * d5);
        double d12 = this.m01;
        double d13 = d12 * d4;
        double d14 = d12;
        double d15 = this.m11;
        double d16 = d15;
        double d17 = (d15 * d5) + d13;
        double d18 = this.m02;
        double d19 = d18 * d4;
        double d20 = d18;
        double d21 = this.m12;
        double d22 = (d5 * d21) + d19;
        matrix4x3d2.m10 = (d10 * d4) + (d8 * d7);
        matrix4x3d2.m11 = (d16 * d4) + (d14 * d7);
        matrix4x3d2.m12 = (d21 * d4) + (d7 * d20);
        matrix4x3d2.m00 = d11;
        matrix4x3d2.m01 = d17;
        matrix4x3d2.m02 = d22;
        matrix4x3d2.m20 = this.m20;
        matrix4x3d2.m21 = this.m21;
        matrix4x3d2.m22 = this.m22;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateZYX(Vector3d vector3d) {
        return rotateZYX(vector3d.z, vector3d.y, vector3d.x);
    }

    public Matrix4x3d rotation(double d2, double d3, double d4, double d5) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = d3 * d4;
        double d8 = d3 * d5;
        double d9 = d4 * d5;
        double d10 = d6;
        double d11 = cosFromSin;
        this.m00 = a.d(d3, d3, d10, d11);
        double d12 = d7 * d6;
        double d13 = d5 * sin;
        this.m01 = d12 + d13;
        double d14 = d8 * d6;
        double d15 = d4 * sin;
        this.m02 = d14 - d15;
        this.m10 = d12 - d13;
        this.m11 = a.d(d4, d4, d10, d11);
        double d16 = d9 * d6;
        double d17 = d3 * sin;
        this.m12 = d16 + d17;
        this.m20 = d14 + d15;
        this.m21 = d16 - d17;
        this.m22 = a.d(d5, d5, d10, d11);
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationAround(Quaterniondc quaterniondc, double d2, double d3, double d4) {
        Quaterniondc quaterniondc2 = quaterniondc;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d5 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double d6 = a2;
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double d7 = d5;
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double d8 = w;
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double d9 = x;
        _m20(a3 + b2);
        _m21(b3 - a4);
        _m22(((z - y) - d9) + d8);
        _m00(((d8 + d9) - z) - y);
        _m01(d7 + d6);
        _m02(b2 - a3);
        _m10(d7 - d6);
        _m11(((y - z) + d8) - d9);
        _m12(b3 + a4);
        _m30(((((-this.m00) * d2) - (this.m10 * d3)) - (this.m20 * d4)) + d2);
        _m31(((((-this.m01) * d2) - (this.m11 * d3)) - (this.m21 * d4)) + d3);
        _m32(((((-this.m02) * d2) - (this.m12 * d3)) - (this.m22 * d4)) + d4);
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotationTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4x3d rotationX(double d2) {
        double d3;
        double d4 = -1.0d;
        if (d2 == 3.141592653589793d || d2 == -3.141592653589793d) {
            d3 = 0.0d;
        } else {
            if (d2 == 1.5707963267948966d || d2 == -4.71238898038469d) {
                d3 = 1.0d;
            } else if (d2 == -1.5707963267948966d || d2 == 4.71238898038469d) {
                d3 = -1.0d;
            } else {
                double sin = Math.sin(d2);
                double cosFromSin = Math.cosFromSin(sin, d2);
                d3 = sin;
                d4 = cosFromSin;
            }
            d4 = 0.0d;
        }
        this.m00 = 1.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = d4;
        this.m12 = d3;
        this.m20 = 0.0d;
        this.m21 = -d3;
        this.m22 = d4;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationXYZ(double d2, double d3, double d4) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d4);
        double d5 = -sin;
        double d6 = sin;
        double d7 = -sin2;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d8 = -sin3;
        double d9 = d5 * d7;
        double d10 = d7 * cosFromSin;
        this.m20 = sin2;
        this.m21 = d5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (d9 * cosFromSin3);
        this.m02 = (sin3 * d6) + (d10 * cosFromSin3);
        this.m10 = cosFromSin2 * d8;
        this.m11 = (cosFromSin * cosFromSin3) + (d9 * d8);
        this.m12 = (d6 * cosFromSin3) + (d10 * d8);
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationY(double d2) {
        double d3;
        double d4 = -1.0d;
        if (d2 == 3.141592653589793d || d2 == -3.141592653589793d) {
            d3 = 0.0d;
        } else {
            if (d2 == 1.5707963267948966d || d2 == -4.71238898038469d) {
                d3 = 1.0d;
            } else if (d2 == -1.5707963267948966d || d2 == 4.71238898038469d) {
                d3 = -1.0d;
            } else {
                double sin = Math.sin(d2);
                double cosFromSin = Math.cosFromSin(sin, d2);
                d3 = sin;
                d4 = cosFromSin;
            }
            d4 = 0.0d;
        }
        this.m00 = d4;
        this.m01 = 0.0d;
        this.m02 = -d3;
        this.m10 = 0.0d;
        this.m11 = 1.0d;
        this.m12 = 0.0d;
        this.m20 = d3;
        this.m21 = 0.0d;
        this.m22 = d4;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationYXZ(double d2, double d3, double d4) {
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double sin2 = Math.sin(d2);
        double cosFromSin2 = Math.cosFromSin(sin2, d2);
        double sin3 = Math.sin(d4);
        double d5 = -sin2;
        double d6 = -sin;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d7 = -sin3;
        double d8 = sin2 * sin;
        double d9 = sin * cosFromSin2;
        this.m20 = sin2 * cosFromSin;
        this.m21 = d6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (d8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * d9) + (d5 * cosFromSin3);
        this.m10 = (d8 * cosFromSin3) + (cosFromSin2 * d7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (d9 * cosFromSin3) + (d5 * d7);
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationZ(double d2) {
        double d3;
        double d4 = -1.0d;
        if (d2 == 3.141592653589793d || d2 == -3.141592653589793d) {
            d3 = 0.0d;
        } else {
            if (d2 == 1.5707963267948966d || d2 == -4.71238898038469d) {
                d3 = 1.0d;
            } else if (d2 == -1.5707963267948966d || d2 == 4.71238898038469d) {
                d3 = -1.0d;
            } else {
                double sin = Math.sin(d2);
                double cosFromSin = Math.cosFromSin(sin, d2);
                d3 = sin;
                d4 = cosFromSin;
            }
            d4 = 0.0d;
        }
        this.m00 = d4;
        this.m01 = d3;
        this.m02 = 0.0d;
        this.m10 = -d3;
        this.m11 = d4;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 1.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotationZYX(double d2, double d3, double d4) {
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = cosFromSin;
        double d6 = -sin2;
        double d7 = -sin3;
        double d8 = cosFromSin3 * sin2;
        double d9 = sin2 * sin3;
        double d10 = -sin;
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = d6;
        this.m10 = (d8 * sin) + (d7 * d5);
        this.m11 = (d9 * sin) + (cosFromSin3 * d5);
        this.m12 = sin * cosFromSin2;
        this.m20 = (d8 * d5) + (d7 * d10);
        this.m21 = (d9 * d5) + (cosFromSin3 * d10);
        this.m22 = cosFromSin2 * d5;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d scale(Vector3dc vector3dc, Matrix4x3d matrix4x3d) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4x3d);
    }

    public Matrix4x3d scaleLocal(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.scaling(d2, d3, d4);
        }
        double d5 = this.m00 * d2;
        double d6 = this.m01 * d3;
        double d7 = this.m02 * d4;
        double d8 = this.m10 * d2;
        double d9 = this.m11 * d3;
        double d10 = this.m12 * d4;
        double d11 = this.m20 * d2;
        double d12 = this.m21 * d3;
        double d13 = this.m22 * d4;
        double d14 = this.m30 * d2;
        double d15 = this.m31 * d3;
        double d16 = this.m32 * d4;
        matrix4x3d2.m00 = d5;
        matrix4x3d2.m01 = d6;
        matrix4x3d2.m02 = d7;
        matrix4x3d2.m10 = d8;
        matrix4x3d2.m11 = d9;
        matrix4x3d2.m12 = d10;
        matrix4x3d2.m20 = d11;
        matrix4x3d2.m21 = d12;
        matrix4x3d2.m22 = d13;
        matrix4x3d2.m30 = d14;
        matrix4x3d2.m31 = d15;
        matrix4x3d2.m32 = d16;
        matrix4x3d2.properties = i2 & -29;
        return matrix4x3d2;
    }

    public Matrix4x3d scaling(double d2) {
        return scaling(d2, d2, d2);
    }

    public Matrix4x3d set(Matrix4x3dc matrix4x3dc) {
        this.m00 = matrix4x3dc.m00();
        this.m01 = matrix4x3dc.m01();
        this.m02 = matrix4x3dc.m02();
        this.m10 = matrix4x3dc.m10();
        this.m11 = matrix4x3dc.m11();
        this.m12 = matrix4x3dc.m12();
        this.m20 = matrix4x3dc.m20();
        this.m21 = matrix4x3dc.m21();
        this.m22 = matrix4x3dc.m22();
        this.m30 = matrix4x3dc.m30();
        this.m31 = matrix4x3dc.m31();
        this.m32 = matrix4x3dc.m32();
        this.properties = matrix4x3dc.properties();
        return this;
    }

    public Matrix4x3d set3x3(Matrix4x3dc matrix4x3dc) {
        this.m00 = matrix4x3dc.m00();
        this.m01 = matrix4x3dc.m01();
        this.m02 = matrix4x3dc.m02();
        this.m10 = matrix4x3dc.m10();
        this.m11 = matrix4x3dc.m11();
        this.m12 = matrix4x3dc.m12();
        this.m20 = matrix4x3dc.m20();
        this.m21 = matrix4x3dc.m21();
        this.m22 = matrix4x3dc.m22();
        this.properties = matrix4x3dc.properties() & this.properties;
        return this;
    }

    public Matrix4x3d setColumn(int i2, Vector3dc vector3dc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = vector3dc.x();
            this.m01 = vector3dc.y();
            this.m02 = vector3dc.z();
        } else if (i2 == 1) {
            this.m10 = vector3dc.x();
            this.m11 = vector3dc.y();
            this.m12 = vector3dc.z();
        } else if (i2 == 2) {
            this.m20 = vector3dc.x();
            this.m21 = vector3dc.y();
            this.m22 = vector3dc.z();
        } else if (i2 == 3) {
            this.m30 = vector3dc.x();
            this.m31 = vector3dc.y();
            this.m32 = vector3dc.z();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setFloats(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.getf(this, byteBuffer.position(), byteBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setLookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return setLookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4x3d setLookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return setLookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4x3d setLookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return setLookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4x3d setOrtho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        double d8 = 2.0d;
        this.m00 = 2.0d / (d3 - d2);
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 2.0d / (d5 - d4);
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        if (z) {
            d8 = 1.0d;
        }
        double d9 = d6 - d7;
        this.m22 = d8 / d9;
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.m32 = (z ? d6 : d7 + d6) / d9;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setOrtho2D(double d2, double d3, double d4, double d5) {
        double d6 = d3 - d2;
        this.m00 = 2.0d / d6;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        double d7 = d5 - d4;
        this.m11 = 2.0d / d7;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = -1.0d;
        this.m30 = (-(d3 + d2)) / d6;
        this.m31 = (-(d5 + d4)) / d7;
        this.m32 = 0.0d;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setOrtho2DLH(double d2, double d3, double d4, double d5) {
        double d6 = d3 - d2;
        this.m00 = 2.0d / d6;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        double d7 = d5 - d4;
        this.m11 = 2.0d / d7;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 1.0d;
        this.m30 = (-(d3 + d2)) / d6;
        this.m31 = (-(d5 + d4)) / d7;
        this.m32 = 0.0d;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setOrthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        double d8 = 2.0d;
        this.m00 = 2.0d / (d3 - d2);
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 2.0d / (d5 - d4);
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        if (z) {
            d8 = 1.0d;
        }
        this.m22 = d8 / (d7 - d6);
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.m32 = (z ? d6 : d7 + d6) / (d6 - d7);
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setOrthoSymmetric(double d2, double d3, double d4, double d5, boolean z) {
        double d6 = 2.0d;
        this.m00 = 2.0d / d2;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 2.0d / d3;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        if (z) {
            d6 = 1.0d;
        }
        double d7 = d4 - d5;
        this.m22 = d6 / d7;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        if (!z) {
            d4 += d5;
        }
        this.m32 = d4 / d7;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setOrthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z) {
        double d6 = 2.0d;
        this.m00 = 2.0d / d2;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 2.0d / d3;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        if (z) {
            d6 = 1.0d;
        }
        this.m22 = d6 / (d5 - d4);
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = (z ? d4 : d5 + d4) / (d4 - d5);
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setRotationXYZ(double d2, double d3, double d4) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d4);
        double d5 = -sin;
        double d6 = sin;
        double d7 = -sin2;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d8 = -sin3;
        double d9 = d5 * d7;
        double d10 = d7 * cosFromSin;
        this.m20 = sin2;
        this.m21 = d5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (d9 * cosFromSin3);
        this.m02 = (sin3 * d6) + (d10 * cosFromSin3);
        this.m10 = cosFromSin2 * d8;
        this.m11 = (cosFromSin * cosFromSin3) + (d9 * d8);
        this.m12 = (d6 * cosFromSin3) + (d10 * d8);
        this.properties &= -13;
        return this;
    }

    public Matrix4x3d setRotationYXZ(double d2, double d3, double d4) {
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double sin2 = Math.sin(d2);
        double cosFromSin2 = Math.cosFromSin(sin2, d2);
        double sin3 = Math.sin(d4);
        double d5 = -sin2;
        double d6 = -sin;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d7 = -sin3;
        double d8 = sin2 * sin;
        double d9 = sin * cosFromSin2;
        this.m20 = sin2 * cosFromSin;
        this.m21 = d6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (d8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * d9) + (d5 * cosFromSin3);
        this.m10 = (d8 * cosFromSin3) + (cosFromSin2 * d7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (d9 * cosFromSin3) + (d5 * d7);
        this.properties &= -13;
        return this;
    }

    public Matrix4x3d setRotationZYX(double d2, double d3, double d4) {
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = cosFromSin;
        double d6 = -sin2;
        double d7 = -sin3;
        double d8 = cosFromSin3 * sin2;
        double d9 = sin2 * sin3;
        double d10 = -sin;
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = d6;
        this.m10 = (d8 * sin) + (d7 * d5);
        this.m11 = (d9 * sin) + (cosFromSin3 * d5);
        this.m12 = sin * cosFromSin2;
        this.m20 = (d8 * d5) + (d7 * d10);
        this.m21 = (d9 * d5) + (cosFromSin3 * d10);
        this.m22 = cosFromSin2 * d5;
        this.properties &= -13;
        return this;
    }

    public Matrix4x3d setRow(int i2, Vector4dc vector4dc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = vector4dc.x();
            this.m10 = vector4dc.y();
            this.m20 = vector4dc.z();
            this.m30 = vector4dc.w();
        } else if (i2 == 1) {
            this.m01 = vector4dc.x();
            this.m11 = vector4dc.y();
            this.m21 = vector4dc.z();
            this.m31 = vector4dc.w();
        } else if (i2 == 2) {
            this.m02 = vector4dc.x();
            this.m12 = vector4dc.y();
            this.m22 = vector4dc.z();
            this.m32 = vector4dc.w();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3d setTranslation(double d2, double d3, double d4) {
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties &= -5;
        return this;
    }

    public Matrix4x3d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5) {
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, d4, d5, this);
    }

    public Matrix4x3d sub(Matrix4x3dc matrix4x3dc) {
        return sub(matrix4x3dc, this);
    }

    public Matrix4x3d swap(Matrix4x3d matrix4x3d) {
        double d2 = this.m00;
        this.m00 = matrix4x3d.m00;
        matrix4x3d.m00 = d2;
        double d3 = this.m01;
        this.m01 = matrix4x3d.m01;
        matrix4x3d.m01 = d3;
        double d4 = this.m02;
        this.m02 = matrix4x3d.m02;
        matrix4x3d.m02 = d4;
        double d5 = this.m10;
        this.m10 = matrix4x3d.m10;
        matrix4x3d.m10 = d5;
        double d6 = this.m11;
        this.m11 = matrix4x3d.m11;
        matrix4x3d.m11 = d6;
        double d7 = this.m12;
        this.m12 = matrix4x3d.m12;
        matrix4x3d.m12 = d7;
        double d8 = this.m20;
        this.m20 = matrix4x3d.m20;
        matrix4x3d.m20 = d8;
        double d9 = this.m21;
        this.m21 = matrix4x3d.m21;
        matrix4x3d.m21 = d9;
        double d10 = this.m22;
        this.m22 = matrix4x3d.m22;
        matrix4x3d.m22 = d10;
        double d11 = this.m30;
        this.m30 = matrix4x3d.m30;
        matrix4x3d.m30 = d11;
        double d12 = this.m31;
        this.m31 = matrix4x3d.m31;
        matrix4x3d.m31 = d12;
        double d13 = this.m32;
        this.m32 = matrix4x3d.m32;
        matrix4x3d.m32 = d13;
        int i2 = this.properties;
        this.properties = matrix4x3d.properties;
        matrix4x3d.properties = i2;
        return this;
    }

    public String toString() {
        String matrix4x3d = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix4x3d.length(); i3++) {
            char charAt = matrix4x3d.charAt(i3);
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

    public Vector4d transform(Vector4d vector4d) {
        return vector4d.mul((Matrix4x3dc) this);
    }

    public Matrix4x3d transformAab(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d, Vector3d vector3d2) {
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d14 = this.m00;
        double d15 = d14 * d2;
        double d16 = this.m01;
        double d17 = d16 * d2;
        double d18 = this.m02;
        double d19 = d18 * d2;
        double d20 = d14 * d5;
        double d21 = d16 * d5;
        double d22 = d18 * d5;
        double d23 = this.m10;
        double d24 = d23 * d3;
        double d25 = d22;
        double d26 = this.m11;
        double d27 = d26 * d3;
        double d28 = d19;
        double d29 = this.m12;
        double d30 = d29 * d3;
        double d31 = d23 * d6;
        double d32 = d26 * d6;
        double d33 = d29 * d6;
        double d34 = this.m20;
        double d35 = d34 * d4;
        double d36 = d32;
        double d37 = this.m21;
        double d38 = d37 * d4;
        double d39 = d31;
        double d40 = this.m22;
        double d41 = d40 * d4;
        double d42 = d34 * d7;
        double d43 = d37 * d7;
        double d44 = d40 * d7;
        if (d15 < d20) {
            d8 = d20;
        } else {
            d8 = d15;
            d15 = d20;
        }
        if (d17 >= d21) {
            double d45 = d21;
            d21 = d17;
            d17 = d45;
        }
        if (d28 < d25) {
            d9 = d25;
        } else {
            d9 = d28;
            d28 = d25;
        }
        if (d24 < d39) {
            d10 = d39;
        } else {
            d10 = d24;
            d24 = d39;
        }
        if (d27 < d36) {
            d11 = d36;
        } else {
            d11 = d27;
            d27 = d36;
        }
        if (d30 < d33) {
            d12 = d33;
        } else {
            d12 = d30;
            d30 = d33;
        }
        if (d35 < d42) {
            d13 = d42;
        } else {
            d13 = d35;
            d35 = d42;
        }
        if (d38 >= d43) {
            double d46 = d43;
            d43 = d38;
            d38 = d46;
        }
        if (d41 >= d44) {
            double d47 = d44;
            d44 = d41;
            d41 = d47;
        }
        double d48 = d15 + d24 + d35;
        double d49 = this.m30;
        Vector3d vector3d5 = vector3d;
        vector3d5.x = d48 + d49;
        double d50 = d17 + d27 + d38;
        double d51 = this.m31;
        vector3d5.y = d50 + d51;
        double d52 = d28 + d30 + d41;
        double d53 = this.m32;
        double d54 = d44;
        vector3d5.z = d52 + d53;
        Vector3d vector3d6 = vector3d2;
        vector3d6.x = a.a(d8, d10, d13, d49);
        vector3d6.y = a.a(d21, d11, d43, d51);
        vector3d6.z = a.a(d9, d12, d54, d53);
        return this;
    }

    public Vector3d transformDirection(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.m00;
        double d3 = vector3d2.x;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = vector3d2.y;
        double d7 = (d5 * d6) + d4;
        double d8 = this.m20;
        double d9 = vector3d2.z;
        vector3d.set(d7 + (d8 * d9), (this.m11 * d6) + (this.m01 * d3) + (this.m21 * d9), (this.m22 * d9) + (this.m12 * d6) + (this.m02 * d3));
        return vector3d2;
    }

    public Vector3d transformPosition(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.m00;
        double d3 = vector3d2.x;
        double d4 = d2 * d3;
        double d5 = this.m10;
        double d6 = vector3d2.y;
        double d7 = (d5 * d6) + d4;
        double d8 = this.m20;
        double d9 = vector3d2.z;
        vector3d.set(this.m30 + (d8 * d9) + d7, this.m31 + (this.m21 * d9) + (this.m11 * d6) + (this.m01 * d3), (this.m22 * d9) + (this.m12 * d6) + (this.m02 * d3) + this.m32);
        return vector3d2;
    }

    public Matrix4x3d translate(Vector3dc vector3dc) {
        return translate(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d translateLocal(Vector3fc vector3fc) {
        return translateLocal((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4x3d translation(double d2, double d3, double d4) {
        if ((this.properties & 4) == 0) {
            identity();
        }
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties = 24;
        return this;
    }

    public Matrix4x3d translationRotate(double d2, double d3, double d4, Quaterniondc quaterniondc) {
        double x = quaterniondc.x() + quaterniondc.x();
        double y = quaterniondc.y() + quaterniondc.y();
        double z = quaterniondc.z() + quaterniondc.z();
        double x2 = quaterniondc.x() * x;
        double y2 = quaterniondc.y() * y;
        double z2 = quaterniondc.z() * z;
        double y3 = quaterniondc.y() * x;
        double z3 = quaterniondc.z() * x;
        double w = quaterniondc.w() * x;
        double z4 = quaterniondc.z() * y;
        double w2 = quaterniondc.w() * y;
        double w3 = quaterniondc.w() * z;
        this.m00 = 1.0d - (y2 + z2);
        this.m01 = y3 + w3;
        this.m02 = z3 - w2;
        this.m10 = y3 - w3;
        this.m11 = 1.0d - (z2 + x2);
        this.m12 = z4 + w;
        this.m20 = z3 + w2;
        this.m21 = z4 - w;
        this.m22 = 1.0d - (y2 + x2);
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d translationRotateMul(double d2, double d3, double d4, Quaternionfc quaternionfc, Matrix4x3dc matrix4x3dc) {
        return translationRotateMul(d2, d3, d4, (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), matrix4x3dc);
    }

    public Matrix4x3d translationRotateScale(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = d5 + d5;
        double d13 = d6 + d6;
        double d14 = d7 + d7;
        double d15 = d12 * d5;
        double d16 = d13 * d6;
        double d17 = d14 * d7;
        double d18 = d12 * d6;
        double d19 = d12 * d7;
        double d20 = d12 * d8;
        double d21 = d13 * d7;
        double d22 = d13 * d8;
        double d23 = d14 * d8;
        double d24 = d16;
        this.m00 = d9 - ((d16 + d17) * d9);
        this.m01 = (d18 + d23) * d9;
        this.m02 = (d19 - d22) * d9;
        this.m10 = (d18 - d23) * d10;
        this.m11 = d10 - ((d17 + d15) * d10);
        this.m12 = (d21 + d20) * d10;
        this.m20 = (d19 + d22) * d11;
        this.m21 = (d21 - d20) * d11;
        this.m22 = d11 - ((d24 + d15) * d11);
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d translationRotateScaleMul(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, Matrix4x3dc matrix4x3dc) {
        double d12 = d5 + d5;
        double d13 = d6 + d6;
        double d14 = d7 + d7;
        double d15 = d12 * d5;
        double d16 = d13 * d6;
        double d17 = d14 * d7;
        double d18 = d12 * d6;
        double d19 = d12 * d7;
        double d20 = d12 * d8;
        double d21 = d13 * d7;
        double d22 = d13 * d8;
        double d23 = d14 * d8;
        double d24 = d9 - ((d16 + d17) * d9);
        double d25 = (d18 + d23) * d9;
        double d26 = (d19 - d22) * d9;
        double d27 = (d18 - d23) * d10;
        double d28 = d10 - ((d17 + d15) * d10);
        double d29 = (d21 + d20) * d10;
        double d30 = (d19 + d22) * d11;
        double d31 = (d21 - d20) * d11;
        double d32 = d11 - ((d16 + d15) * d11);
        double m022 = (matrix4x3dc.m02() * d30) + (matrix4x3dc.m01() * d27) + (matrix4x3dc.m00() * d24);
        double m023 = (matrix4x3dc.m02() * d31) + (matrix4x3dc.m01() * d28) + (matrix4x3dc.m00() * d25);
        this.m02 = (matrix4x3dc.m02() * d32) + (matrix4x3dc.m01() * d29) + (matrix4x3dc.m00() * d26);
        this.m00 = m022;
        this.m01 = m023;
        double m122 = (matrix4x3dc.m12() * d30) + (matrix4x3dc.m11() * d27) + (matrix4x3dc.m10() * d24);
        double m123 = (matrix4x3dc.m12() * d31) + (matrix4x3dc.m11() * d28) + (matrix4x3dc.m10() * d25);
        this.m12 = (matrix4x3dc.m12() * d32) + (matrix4x3dc.m11() * d29) + (matrix4x3dc.m10() * d26);
        this.m10 = m122;
        this.m11 = m123;
        double m222 = (matrix4x3dc.m22() * d30) + (matrix4x3dc.m21() * d27) + (matrix4x3dc.m20() * d24);
        double m223 = (matrix4x3dc.m22() * d31) + (matrix4x3dc.m21() * d28) + (matrix4x3dc.m20() * d25);
        this.m22 = (matrix4x3dc.m22() * d32) + (matrix4x3dc.m21() * d29) + (matrix4x3dc.m20() * d26);
        this.m20 = m222;
        this.m21 = m223;
        double m322 = (matrix4x3dc.m32() * d30) + (matrix4x3dc.m31() * d27) + (matrix4x3dc.m30() * d24) + d2;
        double m323 = (matrix4x3dc.m32() * d31) + (matrix4x3dc.m31() * d28) + (matrix4x3dc.m30() * d25) + d3;
        this.m32 = (matrix4x3dc.m32() * d32) + (matrix4x3dc.m31() * d29) + (matrix4x3dc.m30() * d26) + d4;
        this.m30 = m322;
        this.m31 = m323;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d translationRotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return translationRotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4x3d transpose3x3() {
        return transpose3x3(this);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.m00);
        objectOutput.writeDouble(this.m01);
        objectOutput.writeDouble(this.m02);
        objectOutput.writeDouble(this.m10);
        objectOutput.writeDouble(this.m11);
        objectOutput.writeDouble(this.m12);
        objectOutput.writeDouble(this.m20);
        objectOutput.writeDouble(this.m21);
        objectOutput.writeDouble(this.m22);
        objectOutput.writeDouble(this.m30);
        objectOutput.writeDouble(this.m31);
        objectOutput.writeDouble(this.m32);
    }

    public Matrix4x3d zero() {
        this.m00 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 0.0d;
        this.m12 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d add(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = matrix4x3dc.m00() + this.m00;
        matrix4x3d.m01 = matrix4x3dc.m01() + this.m01;
        matrix4x3d.m02 = matrix4x3dc.m02() + this.m02;
        matrix4x3d.m10 = matrix4x3dc.m10() + this.m10;
        matrix4x3d.m11 = matrix4x3dc.m11() + this.m11;
        matrix4x3d.m12 = matrix4x3dc.m12() + this.m12;
        matrix4x3d.m20 = matrix4x3dc.m20() + this.m20;
        matrix4x3d.m21 = matrix4x3dc.m21() + this.m21;
        matrix4x3d.m22 = matrix4x3dc.m22() + this.m22;
        matrix4x3d.m30 = matrix4x3dc.m30() + this.m30;
        matrix4x3d.m31 = matrix4x3dc.m31() + this.m31;
        matrix4x3d.m32 = matrix4x3dc.m32() + this.m32;
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d fma(Matrix4x3dc matrix4x3dc, double d2, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = (matrix4x3dc.m00() * d2) + this.m00;
        matrix4x3d.m01 = (matrix4x3dc.m01() * d2) + this.m01;
        matrix4x3d.m02 = (matrix4x3dc.m02() * d2) + this.m02;
        matrix4x3d.m10 = (matrix4x3dc.m10() * d2) + this.m10;
        matrix4x3d.m11 = (matrix4x3dc.m11() * d2) + this.m11;
        matrix4x3d.m12 = (matrix4x3dc.m12() * d2) + this.m12;
        matrix4x3d.m20 = (matrix4x3dc.m20() * d2) + this.m20;
        matrix4x3d.m21 = (matrix4x3dc.m21() * d2) + this.m21;
        matrix4x3d.m22 = (matrix4x3dc.m22() * d2) + this.m22;
        matrix4x3d.m30 = (matrix4x3dc.m30() * d2) + this.m30;
        matrix4x3d.m31 = (matrix4x3dc.m31() * d2) + this.m31;
        matrix4x3d.m32 = (matrix4x3dc.m32() * d2) + this.m32;
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d get(Matrix4x3d matrix4x3d) {
        return matrix4x3d.set((Matrix4x3dc) this);
    }

    public float[] get4x4(float[] fArr) {
        return get4x4(fArr, 0);
    }

    public ByteBuffer getFloats(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putf(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix4x3dc) this);
    }

    public DoubleBuffer getTransposed(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public ByteBuffer getTransposedFloats(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putfTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix4x3dc) this);
    }

    public Matrix4x3d invert(Matrix4x3d matrix4x3d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.identity();
        }
        if ((i2 & 16) != 0) {
            return invertOrthonormal(matrix4x3d);
        }
        return invertGeneric(matrix4x3d);
    }

    public Matrix4x3d lerp(Matrix4x3dc matrix4x3dc, double d2, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = a.h(matrix4x3dc.m00(), this.m00, d2, this.m00);
        double d3 = d2;
        matrix4x3d.m01 = a.h(matrix4x3dc.m01(), this.m01, d3, this.m01);
        matrix4x3d.m02 = a.h(matrix4x3dc.m02(), this.m02, d3, this.m02);
        matrix4x3d.m10 = a.h(matrix4x3dc.m10(), this.m10, d3, this.m10);
        matrix4x3d.m11 = a.h(matrix4x3dc.m11(), this.m11, d3, this.m11);
        matrix4x3d.m12 = a.h(matrix4x3dc.m12(), this.m12, d3, this.m12);
        matrix4x3d.m20 = a.h(matrix4x3dc.m20(), this.m20, d3, this.m20);
        matrix4x3d.m21 = a.h(matrix4x3dc.m21(), this.m21, d3, this.m21);
        matrix4x3d.m22 = a.h(matrix4x3dc.m22(), this.m22, d3, this.m22);
        matrix4x3d.m30 = a.h(matrix4x3dc.m30(), this.m30, d3, this.m30);
        matrix4x3d.m31 = a.h(matrix4x3dc.m31(), this.m31, d3, this.m31);
        matrix4x3d.m32 = a.h(matrix4x3dc.m32(), this.m32, d3, this.m32);
        matrix4x3d.properties = matrix4x3dc.properties() & this.properties;
        return matrix4x3d;
    }

    public Matrix4x3d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4x3d);
    }

    public Matrix4x3d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return lookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), this);
    }

    public Matrix4x3d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return lookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), this);
    }

    public Matrix4x3d m00(double d2) {
        this.m00 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m01(double d2) {
        this.m01 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m02(double d2) {
        this.m02 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m10(double d2) {
        this.m10 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m11(double d2) {
        this.m11 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m12(double d2) {
        this.m12 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m20(double d2) {
        this.m20 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m21(double d2) {
        this.m21 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m22(double d2) {
        this.m22 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3d m30(double d2) {
        this.m30 = d2;
        if (d2 != 0.0d) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3d m31(double d2) {
        this.m31 = d2;
        if (d2 != 0.0d) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3d m32(double d2) {
        this.m32 = d2;
        if (d2 != 0.0d) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3d mul(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.set(matrix4x3dc);
        }
        if ((matrix4x3dc.properties() & 4) != 0) {
            return matrix4x3d.set((Matrix4x3dc) this);
        }
        if ((this.properties & 8) != 0) {
            return mulTranslation(matrix4x3dc, matrix4x3d);
        }
        return mulGeneric(matrix4x3dc, matrix4x3d);
    }

    public Matrix4x3d mulComponentWise(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = matrix4x3dc.m00() * this.m00;
        matrix4x3d.m01 = matrix4x3dc.m01() * this.m01;
        matrix4x3d.m02 = matrix4x3dc.m02() * this.m02;
        matrix4x3d.m10 = matrix4x3dc.m10() * this.m10;
        matrix4x3d.m11 = matrix4x3dc.m11() * this.m11;
        matrix4x3d.m12 = matrix4x3dc.m12() * this.m12;
        matrix4x3d.m20 = matrix4x3dc.m20() * this.m20;
        matrix4x3d.m21 = matrix4x3dc.m21() * this.m21;
        matrix4x3d.m22 = matrix4x3dc.m22() * this.m22;
        matrix4x3d.m30 = matrix4x3dc.m30() * this.m30;
        matrix4x3d.m31 = matrix4x3dc.m31() * this.m31;
        matrix4x3d.m32 = matrix4x3dc.m32() * this.m32;
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d mulOrtho(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m002 = matrix4x3dc.m00() * this.m00;
        double m012 = matrix4x3dc.m01() * this.m11;
        double m022 = matrix4x3dc.m02() * this.m22;
        double m102 = matrix4x3dc.m10() * this.m00;
        double m112 = matrix4x3dc.m11() * this.m11;
        double m122 = matrix4x3dc.m12() * this.m22;
        double m202 = this.m00 * matrix4x3dc.m20();
        double m212 = this.m11 * matrix4x3dc.m21();
        double m222 = this.m22 * matrix4x3dc.m22();
        double m302 = (matrix4x3dc.m30() * this.m00) + this.m30;
        double m312 = (matrix4x3dc.m31() * this.m11) + this.m31;
        double m322 = (matrix4x3dc.m32() * this.m22) + this.m32;
        matrix4x3d2.m00 = m002;
        matrix4x3d2.m01 = m012;
        matrix4x3d2.m02 = m022;
        matrix4x3d2.m10 = m102;
        matrix4x3d2.m11 = m112;
        matrix4x3d2.m12 = m122;
        matrix4x3d2.m20 = m202;
        matrix4x3d2.m21 = m212;
        matrix4x3d2.m22 = m222;
        matrix4x3d2.m30 = m302;
        matrix4x3d2.m31 = m312;
        matrix4x3d2.m32 = m322;
        matrix4x3d2.properties = 0;
        return matrix4x3d2;
    }

    public Matrix4x3d normal(Matrix4x3d matrix4x3d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.identity();
        }
        if ((i2 & 16) != 0) {
            return normalOrthonormal(matrix4x3d);
        }
        return normalGeneric(matrix4x3d);
    }

    public Matrix4x3d normalize3x3(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = this.m00;
        double d3 = d2 * d2;
        double d4 = this.m01;
        double d5 = (d4 * d4) + d3;
        double d6 = this.m02;
        double e2 = a.e(d6, d6, d5, 1.0d);
        double d7 = this.m10;
        double d8 = d7 * d7;
        double d9 = this.m11;
        double d10 = (d9 * d9) + d8;
        double d11 = this.m12;
        double e3 = a.e(d11, d11, d10, 1.0d);
        double d12 = this.m20;
        double d13 = d12 * d12;
        double d14 = this.m21;
        double d15 = (d14 * d14) + d13;
        double d16 = this.m22;
        double e4 = a.e(d16, d16, d15, 1.0d);
        matrix4x3d2.m00 = this.m00 * e2;
        matrix4x3d2.m01 = this.m01 * e2;
        matrix4x3d2.m02 = this.m02 * e2;
        matrix4x3d2.m10 = this.m10 * e3;
        matrix4x3d2.m11 = this.m11 * e3;
        matrix4x3d2.m12 = this.m12 * e3;
        matrix4x3d2.m20 = this.m20 * e4;
        matrix4x3d2.m21 = this.m21 * e4;
        matrix4x3d2.m22 = this.m22 * e4;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return rotationAround(quaterniondc, d2, d3, d4);
        }
        return rotateAroundAffine(quaterniondc, d2, d3, d4, matrix4x3d);
    }

    public Matrix4x3d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Matrix4x3d rotateXYZ(double d2, double d3, double d4) {
        return rotateXYZ(d2, d3, d4, this);
    }

    public Matrix4x3d rotateYXZ(double d2, double d3, double d4) {
        return rotateYXZ(d2, d3, d4, this);
    }

    public Matrix4x3d rotateZYX(double d2, double d3, double d4) {
        return rotateZYX(d2, d3, d4, this);
    }

    public Matrix4x3d rotationTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        double d13 = (d6 * d12) - (d7 * d11);
        double d14 = (d7 * d10) - (d5 * d12);
        double d15 = (d5 * d11) - (d6 * d10);
        double e3 = a.e(d15, d15, (d14 * d14) + (d13 * d13), 1.0d);
        double d16 = d13 * e3;
        double d17 = d14 * e3;
        double d18 = d15 * e3;
        double d19 = (d11 * d18) - (d12 * d17);
        double d20 = d12;
        double d21 = (d12 * d16) - (d10 * d18);
        double d22 = d11;
        double d23 = (d10 * d17) - (d11 * d16);
        this.m00 = d16;
        this.m01 = d17;
        this.m02 = d18;
        this.m10 = d19;
        this.m11 = d21;
        this.m12 = d23;
        this.m20 = d10;
        this.m21 = d22;
        this.m22 = d20;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d scale(Vector3dc vector3dc) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), this);
    }

    public Matrix4x3d scaling(double d2, double d3, double d4) {
        if ((this.properties & 4) == 0) {
            identity();
        }
        this.m00 = d2;
        this.m11 = d3;
        this.m22 = d4;
        int i2 = 0;
        if (Math.abs(d2) == 1.0d && Math.abs(d3) == 1.0d && Math.abs(d4) == 1.0d) {
            i2 = 16;
        }
        this.properties = i2;
        return this;
    }

    public Matrix4x3d setLookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double d10 = -a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d11 = d2 * d10;
        double d12 = d3 * d10;
        double d13 = d10 * d4;
        double d14 = (d6 * d13) - (d7 * d12);
        double d15 = (d7 * d11) - (d5 * d13);
        double d16 = (d5 * d12) - (d6 * d11);
        double e2 = a.e(d16, d16, (d15 * d15) + (d14 * d14), 1.0d);
        double d17 = d14 * e2;
        double d18 = d15 * e2;
        double d19 = d16 * e2;
        double d20 = (d12 * d19) - (d13 * d18);
        double d21 = d13;
        double d22 = (d13 * d17) - (d11 * d19);
        double d23 = d19;
        double d24 = (d11 * d18) - (d12 * d17);
        this.m00 = d17;
        this.m01 = d20;
        this.m02 = d11;
        this.m10 = d18;
        this.m11 = d22;
        this.m12 = d12;
        this.m20 = d23;
        this.m21 = d24;
        this.m22 = d21;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d setLookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d2 - d5;
        double d12 = d3 - d6;
        double d13 = d4 - d7;
        double e2 = a.e(d13, d13, (d12 * d12) + (d11 * d11), 1.0d);
        double d14 = d11 * e2;
        double d15 = d12 * e2;
        double d16 = d13 * e2;
        double d17 = (d9 * d16) - (d10 * d15);
        double d18 = (d10 * d14) - (d8 * d16);
        double d19 = (d8 * d15) - (d9 * d14);
        double e3 = a.e(d19, d19, (d18 * d18) + (d17 * d17), 1.0d);
        double d20 = d17 * e3;
        double d21 = d18 * e3;
        double d22 = d19 * e3;
        double d23 = (d15 * d22) - (d16 * d21);
        double d24 = d16;
        double d25 = (d16 * d20) - (d14 * d22);
        double d26 = d22;
        double d27 = (d14 * d21) - (d15 * d20);
        this.m00 = d20;
        this.m01 = d23;
        this.m02 = d14;
        this.m10 = d21;
        this.m11 = d25;
        this.m12 = d15;
        double d28 = d15;
        double d29 = d26;
        this.m20 = d29;
        this.m21 = d27;
        double d30 = d14;
        double d31 = d24;
        this.m22 = d31;
        double d32 = d29 * d4;
        this.m30 = -(d32 + (d21 * d3) + (d20 * d2));
        double d33 = d27 * d4;
        this.m31 = -(d33 + (d25 * d3) + (d23 * d2));
        double d34 = d31 * d4;
        this.m32 = -(d34 + (d28 * d3) + (d30 * d2));
        this.properties = 16;
        return this;
    }

    public Matrix4x3d setLookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d5 - d2;
        double d12 = d6 - d3;
        double d13 = d7 - d4;
        double e2 = a.e(d13, d13, (d12 * d12) + (d11 * d11), 1.0d);
        double d14 = d11 * e2;
        double d15 = d12 * e2;
        double d16 = d13 * e2;
        double d17 = (d9 * d16) - (d10 * d15);
        double d18 = (d10 * d14) - (d8 * d16);
        double d19 = (d8 * d15) - (d9 * d14);
        double e3 = a.e(d19, d19, (d18 * d18) + (d17 * d17), 1.0d);
        double d20 = d17 * e3;
        double d21 = d18 * e3;
        double d22 = d19 * e3;
        double d23 = (d15 * d22) - (d16 * d21);
        double d24 = d16;
        double d25 = (d16 * d20) - (d14 * d22);
        double d26 = d22;
        double d27 = (d14 * d21) - (d15 * d20);
        this.m00 = d20;
        this.m01 = d23;
        this.m02 = d14;
        this.m10 = d21;
        this.m11 = d25;
        this.m12 = d15;
        double d28 = d15;
        double d29 = d26;
        this.m20 = d29;
        this.m21 = d27;
        double d30 = d14;
        double d31 = d24;
        this.m22 = d31;
        double d32 = d29 * d4;
        this.m30 = -(d32 + (d21 * d3) + (d20 * d2));
        double d33 = d27 * d4;
        this.m31 = -(d33 + (d25 * d3) + (d23 * d2));
        double d34 = d31 * d4;
        this.m32 = -(d34 + (d28 * d3) + (d30 * d2));
        this.properties = 16;
        return this;
    }

    public Matrix4x3d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, d4, d5, matrix4x3d);
    }

    public Matrix4x3d sub(Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00 - matrix4x3dc.m00();
        matrix4x3d.m01 = this.m01 - matrix4x3dc.m01();
        matrix4x3d.m02 = this.m02 - matrix4x3dc.m02();
        matrix4x3d.m10 = this.m10 - matrix4x3dc.m10();
        matrix4x3d.m11 = this.m11 - matrix4x3dc.m11();
        matrix4x3d.m12 = this.m12 - matrix4x3dc.m12();
        matrix4x3d.m20 = this.m20 - matrix4x3dc.m20();
        matrix4x3d.m21 = this.m21 - matrix4x3dc.m21();
        matrix4x3d.m22 = this.m22 - matrix4x3dc.m22();
        matrix4x3d.m30 = this.m30 - matrix4x3dc.m30();
        matrix4x3d.m31 = this.m31 - matrix4x3dc.m31();
        matrix4x3d.m32 = this.m32 - matrix4x3dc.m32();
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Vector4d transform(Vector4dc vector4dc, Vector4d vector4d) {
        return vector4dc.mul((Matrix4x3dc) this, vector4d);
    }

    public Vector3d transformDirection(Vector3dc vector3dc, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((vector3dc.z() * this.m20) + (vector3dc.y() * this.m10) + (vector3dc.x() * this.m00), (vector3dc.z() * this.m21) + (vector3dc.y() * this.m11) + (vector3dc.x() * this.m01), (vector3dc.z() * this.m22) + (vector3dc.y() * this.m12) + (vector3dc.x() * this.m02));
        return vector3d;
    }

    public Vector3d transformPosition(Vector3dc vector3dc, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((vector3dc.z() * this.m20) + (vector3dc.y() * this.m10) + (vector3dc.x() * this.m00) + this.m30, (vector3dc.z() * this.m21) + (vector3dc.y() * this.m11) + (vector3dc.x() * this.m01) + this.m31, (vector3dc.z() * this.m22) + (vector3dc.y() * this.m12) + (vector3dc.x() * this.m02) + this.m32);
        return vector3d;
    }

    public Matrix4x3d translate(Vector3dc vector3dc, Matrix4x3d matrix4x3d) {
        return translate(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4x3d);
    }

    public Matrix4x3d translateLocal(Vector3fc vector3fc, Matrix4x3d matrix4x3d) {
        return translateLocal((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4x3d);
    }

    public Matrix4x3d translationRotateMul(double d2, double d3, double d4, double d5, double d6, double d7, double d8, Matrix4x3dc matrix4x3dc) {
        double d9 = d8 * d8;
        double d10 = d5 * d5;
        double d11 = d6 * d6;
        double d12 = d7 * d7;
        double d13 = d7 * d8;
        double d14 = d5 * d6;
        double d15 = d5 * d7;
        double d16 = d6 * d8;
        double d17 = d6 * d7;
        double d18 = d5 * d8;
        double b2 = a.b(d9, d10, d12, d11);
        double a2 = a.a(d14, d13, d13, d14);
        double f2 = a.f(d15, d16, d15, d16);
        double d19 = d15;
        double d20 = (((-d13) + d14) - d13) + d14;
        double f3 = a.f(d11, d12, d9, d10);
        double d21 = d17 + d17;
        double d22 = d21 + d18 + d18;
        double a3 = a.a(d16, d19, d19, d16);
        double d23 = (d21 - d18) - d18;
        double g2 = a.g(d12, d11, d10, d9);
        this.m00 = (matrix4x3dc.m02() * a3) + (matrix4x3dc.m01() * d20) + (matrix4x3dc.m00() * b2);
        this.m01 = (matrix4x3dc.m02() * d23) + (matrix4x3dc.m01() * f3) + (matrix4x3dc.m00() * a2);
        this.m02 = (matrix4x3dc.m02() * g2) + (matrix4x3dc.m01() * d22) + (matrix4x3dc.m00() * f2);
        this.m10 = (matrix4x3dc.m12() * a3) + (matrix4x3dc.m11() * d20) + (matrix4x3dc.m10() * b2);
        this.m11 = (matrix4x3dc.m12() * d23) + (matrix4x3dc.m11() * f3) + (matrix4x3dc.m10() * a2);
        this.m12 = (matrix4x3dc.m12() * g2) + (matrix4x3dc.m11() * d22) + (matrix4x3dc.m10() * f2);
        this.m20 = (matrix4x3dc.m22() * a3) + (matrix4x3dc.m21() * d20) + (matrix4x3dc.m20() * b2);
        this.m21 = (matrix4x3dc.m22() * d23) + (matrix4x3dc.m21() * f3) + (matrix4x3dc.m20() * a2);
        this.m22 = (matrix4x3dc.m22() * g2) + (matrix4x3dc.m21() * d22) + (matrix4x3dc.m20() * f2);
        this.m30 = (matrix4x3dc.m32() * a3) + (matrix4x3dc.m31() * d20) + (matrix4x3dc.m30() * b2) + d2;
        this.m31 = (matrix4x3dc.m32() * d23) + (matrix4x3dc.m31() * f3) + (matrix4x3dc.m30() * a2) + d3;
        this.m32 = (matrix4x3dc.m32() * g2) + (matrix4x3dc.m31() * d22) + (matrix4x3dc.m30() * f2) + d4;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d translationRotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d7;
        double d12 = d7;
        double e2 = a.e(d11, d12, (d6 * d6) + (d5 * d5), 1.0d);
        double d13 = d5 * e2;
        double d14 = d6 * e2;
        double d15 = e2 * d7;
        double d16 = (d9 * d15) - (d10 * d14);
        double d17 = (d10 * d13) - (d8 * d15);
        double d18 = (d8 * d14) - (d9 * d13);
        double e3 = a.e(d18, d18, (d17 * d17) + (d16 * d16), 1.0d);
        double d19 = d16 * e3;
        double d20 = d17 * e3;
        double d21 = d18 * e3;
        double d22 = (d14 * d21) - (d15 * d20);
        double d23 = d15;
        double d24 = (d15 * d19) - (d13 * d21);
        double d25 = d14;
        double d26 = (d13 * d20) - (d14 * d19);
        this.m00 = d19;
        this.m01 = d20;
        this.m02 = d21;
        this.m10 = d22;
        this.m11 = d24;
        this.m12 = d26;
        this.m20 = d13;
        this.m21 = d25;
        this.m22 = d23;
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d transpose3x3(Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d2 = this.m00;
        double d3 = this.m10;
        double d4 = this.m20;
        double d5 = this.m01;
        double d6 = this.m11;
        double d7 = this.m21;
        double d8 = this.m02;
        double d9 = this.m12;
        double d10 = this.m22;
        matrix4x3d2.m00 = d2;
        matrix4x3d2.m01 = d3;
        matrix4x3d2.m02 = d4;
        matrix4x3d2.m10 = d5;
        matrix4x3d2.m11 = d6;
        matrix4x3d2.m12 = d7;
        matrix4x3d2.m20 = d8;
        matrix4x3d2.m21 = d9;
        matrix4x3d2.m22 = d10;
        matrix4x3d2.properties = this.properties;
        return matrix4x3d2;
    }

    private Matrix3d normalOrthonormal(Matrix3d matrix3d) {
        matrix3d.set((Matrix4x3dc) this);
        return matrix3d;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public double[] get4x4(double[] dArr, int i2) {
        MemUtil.INSTANCE.copy4x4(this, dArr, i2);
        return dArr;
    }

    public ByteBuffer getTransposed(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Matrix4x3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return setLookAlong(d2, d3, d4, d5, d6, d7);
        }
        double d8 = d4;
        double d9 = d4;
        double d10 = -a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d11 = d2 * d10;
        double d12 = d3 * d10;
        double d13 = d10 * d4;
        double d14 = (d6 * d13) - (d7 * d12);
        double d15 = (d7 * d11) - (d5 * d13);
        double d16 = (d5 * d12) - (d6 * d11);
        double e2 = a.e(d16, d16, (d15 * d15) + (d14 * d14), 1.0d);
        double d17 = d14 * e2;
        double d18 = d15 * e2;
        double d19 = d16 * e2;
        double d20 = (d12 * d19) - (d13 * d18);
        double d21 = (d13 * d17) - (d11 * d19);
        double d22 = (d11 * d18) - (d12 * d17);
        double d23 = d13;
        double d24 = this.m00;
        double d25 = d24 * d17;
        double d26 = d19;
        double d27 = this.m10;
        double d28 = (d27 * d20) + d25;
        double d29 = d12;
        double d30 = this.m20;
        double d31 = d30;
        double d32 = (d30 * d11) + d28;
        double d33 = this.m01;
        double d34 = d33 * d17;
        double d35 = d33;
        double d36 = this.m11;
        double d37 = (d36 * d20) + d34;
        double d38 = d36;
        double d39 = this.m21;
        double d40 = d39;
        double d41 = (d39 * d11) + d37;
        double d42 = this.m02;
        double d43 = d17 * d42;
        double d44 = d42;
        double d45 = this.m12;
        double d46 = (d20 * d45) + d43;
        double d47 = this.m22;
        double d48 = (d11 * d47) + d46;
        double d49 = (d31 * d29) + (d27 * d21) + (d24 * d18);
        double d50 = (d40 * d29) + (d38 * d21) + (d35 * d18);
        double d51 = (d47 * d29) + (d21 * d45) + (d18 * d44);
        matrix4x3d2.m20 = (d31 * d23) + (d27 * d22) + (d24 * d26);
        matrix4x3d2.m21 = (d40 * d23) + (d38 * d22) + (d35 * d26);
        double d52 = d47 * d23;
        matrix4x3d2.m22 = d52 + (d45 * d22) + (d44 * d26);
        matrix4x3d2.m00 = d32;
        matrix4x3d2.m01 = d41;
        matrix4x3d2.m02 = d48;
        matrix4x3d2.m10 = d49;
        matrix4x3d2.m11 = d50;
        matrix4x3d2.m12 = d51;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.setLookAt(d2, d3, d4, d5, d6, d7, d8, d9, d10);
        }
        return lookAtGeneric(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4x3d);
    }

    public Matrix4x3d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.setLookAtLH(d2, d3, d4, d5, d6, d7, d8, d9, d10);
        }
        return lookAtLHGeneric(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4x3d);
    }

    public Matrix4x3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
        return rotateTowards(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4x3d rotateXYZ(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d.rotationXYZ(d2, d3, d4);
        }
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d4);
        double d5 = -sin;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d6 = -sin2;
        double d7 = sin2;
        double d8 = -sin3;
        double d9 = this.m10;
        double d10 = d9 * cosFromSin;
        double d11 = sin3;
        double d12 = this.m20;
        double d13 = (d12 * sin) + d10;
        double d14 = d6;
        double d15 = this.m11;
        double d16 = d15 * cosFromSin;
        double d17 = cosFromSin2;
        double d18 = this.m21;
        double d19 = (d18 * sin) + d16;
        double d20 = d18;
        double d21 = this.m12;
        double d22 = d21 * cosFromSin;
        double d23 = d21;
        double d24 = this.m22;
        double d25 = (sin * d24) + d22;
        double d26 = (d12 * cosFromSin) + (d9 * d5);
        double d27 = (d20 * cosFromSin) + (d15 * d5);
        double d28 = (d24 * cosFromSin) + (d23 * d5);
        double d29 = this.m00;
        double d30 = (d26 * d14) + (d29 * d17);
        double d31 = this.m01;
        double d32 = (d27 * d14) + (d31 * d17);
        double d33 = d25;
        double d34 = this.m02;
        double d35 = (d14 * d28) + (d34 * d17);
        matrix4x3d2.m20 = (d26 * d17) + (d29 * d7);
        matrix4x3d2.m21 = (d27 * d17) + (d31 * d7);
        matrix4x3d2.m22 = (d28 * d17) + (d34 * d7);
        matrix4x3d2.m00 = (d13 * d11) + (d30 * cosFromSin3);
        matrix4x3d2.m01 = (d19 * d11) + (d32 * cosFromSin3);
        matrix4x3d2.m02 = (d33 * d11) + (d35 * cosFromSin3);
        matrix4x3d2.m10 = (d13 * cosFromSin3) + (d30 * d8);
        matrix4x3d2.m11 = (d19 * cosFromSin3) + (d32 * d8);
        matrix4x3d2.m12 = (d33 * cosFromSin3) + (d35 * d8);
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateYXZ(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d.rotationYXZ(d2, d3, d4);
        }
        double sin = Math.sin(d3);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double sin2 = Math.sin(d2);
        double cosFromSin2 = Math.cosFromSin(sin2, d2);
        double sin3 = Math.sin(d4);
        double d5 = -sin2;
        double cosFromSin3 = Math.cosFromSin(sin3, d4);
        double d6 = -sin;
        double d7 = -sin3;
        double d8 = this.m00;
        double d9 = d8 * sin2;
        double d10 = sin3;
        double d11 = this.m20;
        double d12 = (d11 * cosFromSin2) + d9;
        double d13 = sin;
        double d14 = this.m01;
        double d15 = d14 * sin2;
        double d16 = cosFromSin;
        double d17 = this.m21;
        double d18 = (d17 * cosFromSin2) + d15;
        double d19 = d17;
        double d20 = this.m02;
        double d21 = sin2 * d20;
        double d22 = d20;
        double d23 = this.m22;
        double d24 = (d23 * cosFromSin2) + d21;
        double d25 = (d11 * d5) + (d8 * cosFromSin2);
        double d26 = (d19 * d5) + (d14 * cosFromSin2);
        double d27 = (d23 * d5) + (d22 * cosFromSin2);
        double d28 = this.m10;
        double d29 = (d12 * d13) + (d28 * d16);
        double d30 = this.m11;
        double d31 = (d18 * d13) + (d30 * d16);
        double d32 = this.m12;
        double d33 = (d13 * d24) + (d32 * d16);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m20 = (d12 * d16) + (d28 * d6);
        matrix4x3d3.m21 = (d18 * d16) + (d30 * d6);
        matrix4x3d3.m22 = (d24 * d16) + (d32 * d6);
        matrix4x3d3.m00 = (d29 * d10) + (d25 * cosFromSin3);
        matrix4x3d3.m01 = (d31 * d10) + (d26 * cosFromSin3);
        matrix4x3d3.m02 = (d33 * d10) + (d27 * cosFromSin3);
        matrix4x3d3.m10 = (d29 * cosFromSin3) + (d25 * d7);
        matrix4x3d3.m11 = (d31 * cosFromSin3) + (d26 * d7);
        matrix4x3d3.m12 = (d33 * cosFromSin3) + (d27 * d7);
        matrix4x3d3.m30 = this.m30;
        matrix4x3d3.m31 = this.m31;
        matrix4x3d3.m32 = this.m32;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    public Matrix4x3d rotateZYX(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        if ((this.properties & 4) != 0) {
            return matrix4x3d.rotationZYX(d2, d3, d4);
        }
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = -sin3;
        double d6 = cosFromSin;
        double d7 = -sin2;
        double d8 = -sin;
        double d9 = this.m00;
        double d10 = d9 * cosFromSin3;
        double d11 = sin;
        double d12 = this.m10;
        double d13 = (d12 * sin3) + d10;
        double d14 = cosFromSin2;
        double d15 = this.m01;
        double d16 = d15 * cosFromSin3;
        double d17 = sin2;
        double d18 = this.m11;
        double d19 = (d18 * sin3) + d16;
        double d20 = d18;
        double d21 = this.m02;
        double d22 = d21 * cosFromSin3;
        double d23 = d21;
        double d24 = this.m12;
        double d25 = (sin3 * d24) + d22;
        double d26 = (d12 * cosFromSin3) + (d9 * d5);
        double d27 = (d20 * cosFromSin3) + (d15 * d5);
        double d28 = (d24 * cosFromSin3) + (d23 * d5);
        double d29 = d13 * d17;
        double d30 = this.m20;
        double d31 = (d30 * d14) + d29;
        double d32 = d19 * d17;
        double d33 = d28;
        double d34 = this.m21;
        double d35 = (d34 * d14) + d32;
        double d36 = d25 * d17;
        double d37 = d27;
        double d38 = this.m22;
        double d39 = (d38 * d14) + d36;
        matrix4x3d2.m00 = (d30 * d7) + (d13 * d14);
        matrix4x3d2.m01 = (d34 * d7) + (d19 * d14);
        matrix4x3d2.m02 = (d38 * d7) + (d25 * d14);
        matrix4x3d2.m10 = (d31 * d11) + (d26 * d6);
        matrix4x3d2.m11 = (d35 * d11) + (d37 * d6);
        matrix4x3d2.m12 = (d39 * d11) + (d33 * d6);
        matrix4x3d2.m20 = (d31 * d6) + (d26 * d8);
        matrix4x3d2.m21 = (d35 * d6) + (d37 * d8);
        matrix4x3d2.m22 = (d39 * d6) + (d33 * d8);
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d scale(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.scaling(d2, d3, d4);
        }
        return scaleGeneric(d2, d3, d4, matrix4x3d);
    }

    public Matrix4x3d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return shadow(d2, d3, d4, d5, d6, d7, d8, d9, this);
    }

    public Matrix4x3d translate(Vector3fc vector3fc) {
        return translate((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4x3d translateLocal(Vector3dc vector3dc) {
        return translateLocal(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public double[] get4x4(double[] dArr) {
        return get4x4(dArr, 0);
    }

    public ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4x3d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        double d13 = (d6 * d12) - (d7 * d11);
        double d14 = (d7 * d10) - (d5 * d12);
        double d15 = (d5 * d11) - (d6 * d10);
        double e3 = a.e(d15, d15, (d14 * d14) + (d13 * d13), 1.0d);
        double d16 = d13 * e3;
        double d17 = d14 * e3;
        double d18 = d15 * e3;
        double d19 = (d11 * d18) - (d12 * d17);
        double d20 = (d12 * d16) - (d10 * d18);
        double d21 = (d10 * d17) - (d11 * d16);
        double d22 = d12;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        double d23 = this.m00;
        double d24 = d23 * d16;
        double d25 = d11;
        double d26 = this.m10;
        double d27 = (d26 * d17) + d24;
        double d28 = d10;
        double d29 = this.m20;
        double d30 = d29;
        double d31 = (d29 * d18) + d27;
        double d32 = this.m01;
        double d33 = d32 * d16;
        double d34 = d32;
        double d35 = this.m11;
        double d36 = (d35 * d17) + d33;
        double d37 = d35;
        double d38 = this.m21;
        double d39 = d38;
        double d40 = (d38 * d18) + d36;
        double d41 = this.m02;
        double d42 = d16 * d41;
        double d43 = d41;
        double d44 = this.m12;
        double d45 = (d17 * d44) + d42;
        double d46 = this.m22;
        double d47 = (d18 * d46) + d45;
        double d48 = (d30 * d21) + (d26 * d20) + (d23 * d19);
        double d49 = (d39 * d21) + (d37 * d20) + (d34 * d19);
        double d50 = d21 * d46;
        double d51 = d50 + (d20 * d44) + (d19 * d43);
        matrix4x3d2.m20 = (d30 * d22) + (d26 * d25) + (d23 * d28);
        matrix4x3d2.m21 = (d39 * d22) + (d37 * d25) + (d34 * d28);
        double d52 = d46 * d22;
        matrix4x3d2.m22 = d52 + (d44 * d25) + (d43 * d28);
        matrix4x3d2.m00 = d31;
        matrix4x3d2.m01 = d40;
        matrix4x3d2.m02 = d47;
        matrix4x3d2.m10 = d48;
        matrix4x3d2.m11 = d49;
        matrix4x3d2.m12 = d51;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double d10 = d8;
        double d11 = d8;
        double e2 = a.e(d10, d11, (d7 * d7) + (d6 * d6), 1.0d);
        double d12 = d6 * e2;
        double d13 = d7 * e2;
        double d14 = d8 * e2;
        double d15 = e2 * d9;
        double d16 = d12 * d2;
        double d17 = d13 * d3;
        double d18 = d14 * d4;
        double d19 = d15 * d5;
        double d20 = d16 + d17 + d18 + d19;
        double d21 = d20 - d16;
        double d22 = -d12;
        double d23 = d22 * d3;
        double d24 = d22 * d4;
        double d25 = d22 * d5;
        double d26 = -d13;
        double d27 = d26 * d2;
        double d28 = d20 - d17;
        double d29 = d26 * d4;
        double d30 = d26 * d5;
        double d31 = -d14;
        double d32 = d31 * d2;
        double d33 = d31 * d3;
        double d34 = d20 - d18;
        double d35 = d31 * d5;
        double d36 = -d15;
        double d37 = d36 * d2;
        double d38 = d36 * d3;
        double d39 = d36 * d4;
        double d40 = d20 - d19;
        double d41 = this.m00;
        double d42 = d41 * d21;
        double d43 = d39;
        double d44 = this.m10;
        double d45 = (d44 * d23) + d42;
        double d46 = d35;
        double d47 = this.m20;
        double d48 = (d47 * d24) + d45;
        double d49 = d30;
        double d50 = this.m30;
        double d51 = d50;
        double d52 = (d50 * d25) + d48;
        double d53 = this.m01;
        double d54 = d53 * d21;
        double d55 = d53;
        double d56 = this.m11;
        double d57 = (d56 * d23) + d54;
        double d58 = d56;
        double d59 = this.m21;
        double d60 = (d59 * d24) + d57;
        double d61 = d59;
        double d62 = this.m31;
        double d63 = d62;
        double d64 = (d62 * d25) + d60;
        double d65 = this.m02;
        double d66 = d21 * d65;
        double d67 = d65;
        double d68 = this.m12;
        double d69 = (d23 * d68) + d66;
        double d70 = this.m22;
        double d71 = (d24 * d70) + d69;
        double d72 = d70;
        double d73 = this.m32;
        double d74 = (d25 * d73) + d71;
        double d75 = d74;
        double d76 = (d51 * d49) + (d47 * d29) + (d44 * d28) + (d41 * d27);
        double d77 = d76;
        double d78 = (d63 * d49) + (d61 * d29) + (d58 * d28) + (d55 * d27);
        double d79 = (d73 * d49) + (d72 * d29) + (d28 * d68) + (d67 * d27);
        double d80 = d79;
        double d81 = (d51 * d46) + (d47 * d34) + (d44 * d33) + (d41 * d32);
        double d82 = d81;
        double d83 = (d63 * d46) + (d61 * d34) + (d58 * d33) + (d55 * d32);
        double d84 = d34 * d72;
        double d85 = d73 * d46;
        double d86 = d83;
        double d87 = d85 + d84 + (d33 * d68) + (d67 * d32);
        double d88 = d47 * d43;
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m30 = (d51 * d40) + d88 + (d44 * d38) + (d41 * d37);
        matrix4x3d3.m31 = (d63 * d40) + (d61 * d43) + (d58 * d38) + (d55 * d37);
        double d89 = d73 * d40;
        matrix4x3d3.m32 = d89 + (d72 * d43) + (d68 * d38) + (d67 * d37);
        matrix4x3d3.m00 = d52;
        matrix4x3d3.m01 = d64;
        matrix4x3d3.m02 = d75;
        matrix4x3d3.m10 = d77;
        matrix4x3d3.m11 = d78;
        matrix4x3d3.m12 = d80;
        matrix4x3d3.m20 = d82;
        matrix4x3d3.m21 = d86;
        matrix4x3d3.m22 = d87;
        matrix4x3d3.properties = this.properties & -29;
        return matrix4x3d3;
    }

    public Matrix4x3d translate(Vector3fc vector3fc, Matrix4x3d matrix4x3d) {
        return translate((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4x3d);
    }

    public Matrix4x3d translateLocal(Vector3dc vector3dc, Matrix4x3d matrix4x3d) {
        return translateLocal(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4x3d);
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public DoubleBuffer get4x4(DoubleBuffer doubleBuffer) {
        return get4x4(doubleBuffer.position(), doubleBuffer);
    }

    public FloatBuffer getTransposed(FloatBuffer floatBuffer) {
        return getTransposed(floatBuffer.position(), floatBuffer);
    }

    public Matrix4x3d obliqueZ(double d2, double d3, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00;
        matrix4x3d.m01 = this.m01;
        matrix4x3d.m02 = this.m02;
        matrix4x3d.m10 = this.m10;
        matrix4x3d.m11 = this.m11;
        matrix4x3d.m12 = this.m12;
        matrix4x3d.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        matrix4x3d.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        matrix4x3d.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        matrix4x3d.m30 = this.m30;
        matrix4x3d.m31 = this.m31;
        matrix4x3d.m32 = this.m32;
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d rotate(double d2, double d3, double d4, double d5) {
        return rotate(d2, d3, d4, d5, this);
    }

    public Matrix4x3d setTranslation(Vector3dc vector3dc) {
        return setTranslation(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d translate(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.translation(d2, d3, d4);
        }
        return translateGeneric(d2, d3, d4, matrix4x3d);
    }

    public Matrix4x3d translateLocal(double d2, double d3, double d4, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00;
        matrix4x3d.m01 = this.m01;
        matrix4x3d.m02 = this.m02;
        matrix4x3d.m10 = this.m10;
        matrix4x3d.m11 = this.m11;
        matrix4x3d.m12 = this.m12;
        matrix4x3d.m20 = this.m20;
        matrix4x3d.m21 = this.m21;
        matrix4x3d.m22 = this.m22;
        matrix4x3d.m30 = this.m30 + d2;
        matrix4x3d.m31 = this.m31 + d3;
        matrix4x3d.m32 = this.m32 + d4;
        matrix4x3d.properties = this.properties & -5;
        return matrix4x3d;
    }

    public Matrix4x3d(Matrix4x3dc matrix4x3dc) {
        this.m00 = matrix4x3dc.m00();
        this.m01 = matrix4x3dc.m01();
        this.m02 = matrix4x3dc.m02();
        this.m10 = matrix4x3dc.m10();
        this.m11 = matrix4x3dc.m11();
        this.m12 = matrix4x3dc.m12();
        this.m20 = matrix4x3dc.m20();
        this.m21 = matrix4x3dc.m21();
        this.m22 = matrix4x3dc.m22();
        this.m30 = matrix4x3dc.m30();
        this.m31 = matrix4x3dc.m31();
        this.m32 = matrix4x3dc.m32();
        this.properties = matrix4x3dc.properties();
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putf(this, i2, floatBuffer);
        return floatBuffer;
    }

    public DoubleBuffer get4x4(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putfTransposed(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Matrix4x3d invertOrtho() {
        return invertOrtho(this);
    }

    public Matrix4x3d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return lookAt(d2, d3, d4, d5, d6, d7, d8, d9, d10, this);
    }

    public Matrix4x3d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return lookAtLH(d2, d3, d4, d5, d6, d7, d8, d9, d10, this);
    }

    public Matrix3d normal(Matrix3d matrix3d) {
        if ((this.properties & 16) != 0) {
            return normalOrthonormal(matrix3d);
        }
        return normalGeneric(matrix3d);
    }

    public Matrix4x3d rotate(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.rotation(quaterniondc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaterniondc, matrix4x3d);
        }
        return rotateGeneric(quaterniondc, matrix4x3d);
    }

    public Matrix4x3d scale(double d2, double d3, double d4) {
        return scale(d2, d3, d4, this);
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer get4x4(ByteBuffer byteBuffer) {
        return get4x4(byteBuffer.position(), byteBuffer);
    }

    public double[] getTransposed(double[] dArr, int i2) {
        dArr[i2 + 0] = this.m00;
        dArr[i2 + 1] = this.m10;
        dArr[i2 + 2] = this.m20;
        dArr[i2 + 3] = this.m30;
        dArr[i2 + 4] = this.m01;
        dArr[i2 + 5] = this.m11;
        dArr[i2 + 6] = this.m21;
        dArr[i2 + 7] = this.m31;
        dArr[i2 + 8] = this.m02;
        dArr[i2 + 9] = this.m12;
        dArr[i2 + 10] = this.m22;
        dArr[i2 + 11] = this.m32;
        return dArr;
    }

    public Matrix4x3d scale(double d2, Matrix4x3d matrix4x3d) {
        return scale(d2, d2, d2, matrix4x3d);
    }

    public Matrix4x3d translation(Vector3fc vector3fc) {
        return translation((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer get4x4(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix3d normalize3x3(Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d2 = this.m00;
        double d3 = d2 * d2;
        double d4 = this.m01;
        double d5 = (d4 * d4) + d3;
        double d6 = this.m02;
        double e2 = a.e(d6, d6, d5, 1.0d);
        double d7 = this.m10;
        double d8 = d7 * d7;
        double d9 = this.m11;
        double d10 = (d9 * d9) + d8;
        double d11 = this.m12;
        double e3 = a.e(d11, d11, d10, 1.0d);
        double d12 = this.m20;
        double d13 = d12 * d12;
        double d14 = this.m21;
        double d15 = (d14 * d14) + d13;
        double d16 = this.m22;
        double e4 = a.e(d16, d16, d15, 1.0d);
        matrix3d2.m00(this.m00 * e2);
        matrix3d2.m01(this.m01 * e2);
        matrix3d2.m02(this.m02 * e2);
        matrix3d2.m10(this.m10 * e3);
        matrix3d2.m11(this.m11 * e3);
        matrix3d2.m12(this.m12 * e3);
        matrix3d2.m20(this.m20 * e4);
        matrix3d2.m21(this.m21 * e4);
        matrix3d2.m22(this.m22 * e4);
        return matrix3d2;
    }

    public Matrix4x3d scale(double d2) {
        return scale(d2, d2, d2);
    }

    public Matrix4x3d translate(double d2, double d3, double d4) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return translation(d2, d3, d4);
        }
        this.m30 = (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30;
        this.m31 = (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31;
        this.m32 = (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32;
        this.properties = i2 & -5;
        return this;
    }

    public Matrix4x3d translation(Vector3dc vector3dc) {
        return translation(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public double[] get(double[] dArr, int i2) {
        dArr[i2 + 0] = this.m00;
        dArr[i2 + 1] = this.m01;
        dArr[i2 + 2] = this.m02;
        dArr[i2 + 3] = this.m10;
        dArr[i2 + 4] = this.m11;
        dArr[i2 + 5] = this.m12;
        dArr[i2 + 6] = this.m20;
        dArr[i2 + 7] = this.m21;
        dArr[i2 + 8] = this.m22;
        dArr[i2 + 9] = this.m30;
        dArr[i2 + 10] = this.m31;
        dArr[i2 + 11] = this.m32;
        return dArr;
    }

    public Matrix4x3d mul(Matrix4x3fc matrix4x3fc) {
        return mul(matrix4x3fc, this);
    }

    public Matrix4x3d scaling(Vector3dc vector3dc) {
        return scaling(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d mul(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d) {
        if ((this.properties & 4) != 0) {
            return matrix4x3d.set(matrix4x3fc);
        }
        if ((matrix4x3fc.properties() & 4) != 0) {
            return matrix4x3d.set((Matrix4x3dc) this);
        }
        if ((this.properties & 8) != 0) {
            return mulTranslation(matrix4x3fc, matrix4x3d);
        }
        return mulGeneric(matrix4x3fc, matrix4x3d);
    }

    public Matrix4x3d rotate(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3d.rotation(quaternionfc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaternionfc, matrix4x3d);
        }
        return rotateGeneric(quaternionfc, matrix4x3d);
    }

    public Matrix4x3d transformAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d, Vector3d vector3d2) {
        return transformAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3d, vector3d2);
    }

    public Matrix4x3d set3x3(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        this.properties = 0;
        return this;
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder sb = new StringBuilder();
        String str = " ";
        a.b(numberFormat, this.m00, sb, str);
        a.b(numberFormat, this.m10, sb, str);
        a.b(numberFormat, this.m20, sb, str);
        String str2 = "\n";
        a.b(numberFormat, this.m30, sb, str2);
        a.b(numberFormat, this.m01, sb, str);
        a.b(numberFormat, this.m11, sb, str);
        a.b(numberFormat, this.m21, sb, str);
        a.b(numberFormat, this.m31, sb, str2);
        a.b(numberFormat, this.m02, sb, str);
        a.b(numberFormat, this.m12, sb, str);
        a.b(numberFormat, this.m22, sb, str);
        return a.a(numberFormat, this.m32, sb, str2);
    }

    public Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        return ortho(d2, d3, d4, d5, d6, d7, false, matrix4x3d);
    }

    public Matrix4x3d ortho2D(double d2, double d3, double d4, double d5) {
        return ortho2D(d2, d3, d4, d5, this);
    }

    public Matrix4x3d ortho2DLH(double d2, double d3, double d4, double d5) {
        return ortho2DLH(d2, d3, d4, d5, this);
    }

    public Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        return orthoLH(d2, d3, d4, d5, d6, d7, false, matrix4x3d);
    }

    public Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        return orthoSymmetric(d2, d3, d4, d5, false, matrix4x3d);
    }

    public Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5, Matrix4x3d matrix4x3d) {
        return orthoSymmetricLH(d2, d3, d4, d5, false, matrix4x3d);
    }

    public Matrix4x3d reflection(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        return reflection(d10, d11, d12, (((-d10) * d5) - (d11 * d6)) - (d12 * d7));
    }

    public Matrix4x3d rotate(Quaterniondc quaterniondc) {
        return rotate(quaterniondc, this);
    }

    public Matrix4x3d set(Matrix4x3fc matrix4x3fc) {
        this.m00 = (double) matrix4x3fc.m00();
        this.m01 = (double) matrix4x3fc.m01();
        this.m02 = (double) matrix4x3fc.m02();
        this.m10 = (double) matrix4x3fc.m10();
        this.m11 = (double) matrix4x3fc.m11();
        this.m12 = (double) matrix4x3fc.m12();
        this.m20 = (double) matrix4x3fc.m20();
        this.m21 = (double) matrix4x3fc.m21();
        this.m22 = (double) matrix4x3fc.m22();
        this.m30 = (double) matrix4x3fc.m30();
        this.m31 = (double) matrix4x3fc.m31();
        this.m32 = (double) matrix4x3fc.m32();
        this.properties = matrix4x3fc.properties();
        return this;
    }

    public Matrix4x3d setOrtho(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setOrtho(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4x3d setOrthoLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setOrthoLH(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4x3d setOrthoSymmetric(double d2, double d3, double d4, double d5) {
        return setOrthoSymmetric(d2, d3, d4, d5, false);
    }

    public Matrix4x3d setOrthoSymmetricLH(double d2, double d3, double d4, double d5) {
        return setOrthoSymmetricLH(d2, d3, d4, d5, false);
    }

    public Matrix4x3d translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScale((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), (double) vector3fc2.x(), (double) vector3fc2.y(), (double) vector3fc2.z());
    }

    public Matrix4x3d add(Matrix4x3fc matrix4x3fc) {
        return add(matrix4x3fc, this);
    }

    public boolean equals(Matrix4x3dc matrix4x3dc, double d2) {
        if (this == matrix4x3dc) {
            return true;
        }
        return matrix4x3dc != null && (matrix4x3dc instanceof Matrix4x3d) && Runtime.equals(this.m00, matrix4x3dc.m00(), d2) && Runtime.equals(this.m01, matrix4x3dc.m01(), d2) && Runtime.equals(this.m02, matrix4x3dc.m02(), d2) && Runtime.equals(this.m10, matrix4x3dc.m10(), d2) && Runtime.equals(this.m11, matrix4x3dc.m11(), d2) && Runtime.equals(this.m12, matrix4x3dc.m12(), d2) && Runtime.equals(this.m20, matrix4x3dc.m20(), d2) && Runtime.equals(this.m21, matrix4x3dc.m21(), d2) && Runtime.equals(this.m22, matrix4x3dc.m22(), d2) && Runtime.equals(this.m30, matrix4x3dc.m30(), d2) && Runtime.equals(this.m31, matrix4x3dc.m31(), d2) && Runtime.equals(this.m32, matrix4x3dc.m32(), d2);
    }

    public Matrix4x3d fma(Matrix4x3fc matrix4x3fc, double d2) {
        return fma(matrix4x3fc, d2, this);
    }

    public Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return ortho(d2, d3, d4, d5, d6, d7, z, this);
    }

    public Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return orthoLH(d2, d3, d4, d5, d6, d7, z, this);
    }

    public Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z) {
        return orthoSymmetric(d2, d3, d4, d5, z, this);
    }

    public Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z) {
        return orthoSymmetricLH(d2, d3, d4, d5, z, this);
    }

    public Matrix4x3d pick(double d2, double d3, double d4, double d5, int[] iArr) {
        return pick(d2, d3, d4, d5, iArr, this);
    }

    public Matrix4x3d reflection(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return reflection(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4x3d rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, this);
    }

    public Matrix4x3d sub(Matrix4x3fc matrix4x3fc) {
        return sub(matrix4x3fc, this);
    }

    public Matrix4x3d translationRotateScale(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2) {
        return translationRotateScale(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4x3d add(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00 + ((double) matrix4x3fc.m00());
        matrix4x3d.m01 = this.m01 + ((double) matrix4x3fc.m01());
        matrix4x3d.m02 = this.m02 + ((double) matrix4x3fc.m02());
        matrix4x3d.m10 = this.m10 + ((double) matrix4x3fc.m10());
        matrix4x3d.m11 = this.m11 + ((double) matrix4x3fc.m11());
        matrix4x3d.m12 = this.m12 + ((double) matrix4x3fc.m12());
        matrix4x3d.m20 = this.m20 + ((double) matrix4x3fc.m20());
        matrix4x3d.m21 = this.m21 + ((double) matrix4x3fc.m21());
        matrix4x3d.m22 = this.m22 + ((double) matrix4x3fc.m22());
        matrix4x3d.m30 = this.m30 + ((double) matrix4x3fc.m30());
        matrix4x3d.m31 = this.m31 + ((double) matrix4x3fc.m31());
        matrix4x3d.m32 = this.m32 + ((double) matrix4x3fc.m32());
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d fma(Matrix4x3fc matrix4x3fc, double d2, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = (((double) matrix4x3fc.m00()) * d2) + this.m00;
        matrix4x3d.m01 = (((double) matrix4x3fc.m01()) * d2) + this.m01;
        matrix4x3d.m02 = (((double) matrix4x3fc.m02()) * d2) + this.m02;
        matrix4x3d.m10 = (((double) matrix4x3fc.m10()) * d2) + this.m10;
        matrix4x3d.m11 = (((double) matrix4x3fc.m11()) * d2) + this.m11;
        matrix4x3d.m12 = (((double) matrix4x3fc.m12()) * d2) + this.m12;
        matrix4x3d.m20 = (((double) matrix4x3fc.m20()) * d2) + this.m20;
        matrix4x3d.m21 = (((double) matrix4x3fc.m21()) * d2) + this.m21;
        matrix4x3d.m22 = (((double) matrix4x3fc.m22()) * d2) + this.m22;
        matrix4x3d.m30 = (((double) matrix4x3fc.m30()) * d2) + this.m30;
        matrix4x3d.m31 = (((double) matrix4x3fc.m31()) * d2) + this.m31;
        matrix4x3d.m32 = (((double) matrix4x3fc.m32()) * d2) + this.m32;
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d ortho(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ortho(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4x3d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return orthoLH(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4x3d orthoSymmetric(double d2, double d3, double d4, double d5) {
        return orthoSymmetric(d2, d3, d4, d5, false, this);
    }

    public Matrix4x3d orthoSymmetricLH(double d2, double d3, double d4, double d5) {
        return orthoSymmetricLH(d2, d3, d4, d5, false, this);
    }

    public Matrix4x3d reflect(double d2, double d3, double d4, double d5) {
        return reflect(d2, d3, d4, d5, this);
    }

    public Matrix4x3d reflection(Quaterniondc quaterniondc, Vector3dc vector3dc) {
        double x = quaterniondc.x() + quaterniondc.x();
        double y = quaterniondc.y() + quaterniondc.y();
        double z = quaterniondc.z() + quaterniondc.z();
        return reflection((quaterniondc.w() * y) + (quaterniondc.x() * z), (quaterniondc.y() * z) - (quaterniondc.w() * x), 1.0d - ((quaterniondc.y() * y) + (quaterniondc.x() * x)), vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d rotate(AxisAngle4f axisAngle4f) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Matrix4x3d rotateTranslation(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double d3 = d2 + a2;
        double d4 = d2 - a2;
        double d5 = b2 - a3;
        double d6 = d3;
        double b4 = a.b(w, x, z, y);
        double f2 = a.f(y, z, w, x);
        double d7 = a3 + b2;
        double d8 = b4;
        double d9 = z;
        double d10 = b3 - a4;
        double d11 = d7;
        double d12 = b3 + a4;
        double d13 = x;
        double d14 = f2;
        double g2 = a.g(d9, y, d13, w);
        matrix4x3d2.m20 = d11;
        matrix4x3d2.m21 = d10;
        matrix4x3d2.m22 = g2;
        matrix4x3d2.m00 = d8;
        matrix4x3d2.m01 = d6;
        matrix4x3d2.m02 = d5;
        matrix4x3d2.m10 = d4;
        matrix4x3d2.m11 = d14;
        matrix4x3d2.m12 = d12;
        matrix4x3d2.m30 = this.m30;
        matrix4x3d2.m31 = this.m31;
        matrix4x3d2.m32 = this.m32;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotation(double d2, Vector3dc vector3dc) {
        return rotation(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d sub(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d) {
        matrix4x3d.m00 = this.m00 - ((double) matrix4x3fc.m00());
        matrix4x3d.m01 = this.m01 - ((double) matrix4x3fc.m01());
        matrix4x3d.m02 = this.m02 - ((double) matrix4x3fc.m02());
        matrix4x3d.m10 = this.m10 - ((double) matrix4x3fc.m10());
        matrix4x3d.m11 = this.m11 - ((double) matrix4x3fc.m11());
        matrix4x3d.m12 = this.m12 - ((double) matrix4x3fc.m12());
        matrix4x3d.m20 = this.m20 - ((double) matrix4x3fc.m20());
        matrix4x3d.m21 = this.m21 - ((double) matrix4x3fc.m21());
        matrix4x3d.m22 = this.m22 - ((double) matrix4x3fc.m22());
        matrix4x3d.m30 = this.m30 - ((double) matrix4x3fc.m30());
        matrix4x3d.m31 = this.m31 - ((double) matrix4x3fc.m31());
        matrix4x3d.m32 = this.m32 - ((double) matrix4x3fc.m32());
        matrix4x3d.properties = 0;
        return matrix4x3d;
    }

    public Matrix4x3d reflect(double d2, double d3, double d4, double d5, double d6, double d7) {
        return reflect(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4x3d rotate(AxisAngle4f axisAngle4f, Matrix4x3d matrix4x3d) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z, matrix4x3d);
    }

    public Matrix4x3d rotation(double d2, Vector3fc vector3fc) {
        return rotation(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4x3d reflect(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4x3d matrix4x3d) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        return reflect(d10, d11, d12, (((-d10) * d5) - (d11 * d6)) - (d12 * d7), matrix4x3d);
    }

    public Matrix4x3d rotate(AxisAngle4d axisAngle4d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Matrix4x3d rotation(AxisAngle4f axisAngle4f) {
        return rotation((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Matrix4x3d translateLocal(double d2, double d3, double d4) {
        return translateLocal(d2, d3, d4, this);
    }

    private Matrix3d normalGeneric(Matrix3d matrix3d) {
        Matrix3d matrix3d2 = matrix3d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d5 * d6;
        double d8 = this.m02;
        double d9 = d6 * d8;
        double d10 = this.m12;
        double d11 = d2 * d10;
        double d12 = d5 * d10;
        double d13 = d8 * d3;
        double d14 = d4 - d7;
        double d15 = this.m22;
        double d16 = d14 * d15;
        double d17 = d9 - d11;
        double d18 = d14;
        double d19 = this.m21;
        double d20 = d12 - d13;
        double l = a.l(this.m20, d20, (d17 * d19) + d16, 1.0d);
        matrix3d2.m00(((d3 * d15) - (d19 * d10)) * l);
        matrix3d2.m01(((this.m20 * this.m12) - (this.m10 * this.m22)) * l);
        matrix3d2.m02(((this.m10 * this.m21) - (this.m20 * this.m11)) * l);
        matrix3d2.m10(((this.m21 * this.m02) - (this.m01 * this.m22)) * l);
        matrix3d2.m11(((this.m00 * this.m22) - (this.m20 * this.m02)) * l);
        matrix3d2.m12(((this.m20 * this.m01) - (this.m00 * this.m21)) * l);
        matrix3d2.m20(d20 * l);
        matrix3d2.m21(d17 * l);
        matrix3d2.m22(d18 * l);
        return matrix3d2;
    }

    private Matrix4x3d rotateGeneric(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double b4 = a.b(w, x, z, y);
        double d3 = d2 + a2;
        double d4 = b2 - a3;
        double d5 = d2 - a2;
        double f2 = a.f(y, z, w, x);
        double d6 = b3 + a4;
        double d7 = a3 + b2;
        double d8 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d9 = this.m00;
        double d10 = d9 * b4;
        double d11 = this.m10;
        double d12 = (d11 * d3) + d10;
        double d13 = this.m20;
        double d14 = (d13 * d4) + d12;
        double d15 = this.m01;
        double d16 = d15 * b4;
        double d17 = d14;
        double d18 = this.m11;
        double d19 = (d18 * d3) + d16;
        double d20 = this.m21;
        double d21 = g2;
        double d22 = (d20 * d4) + d19;
        double d23 = this.m02;
        double d24 = b4 * d23;
        double d25 = d23;
        double d26 = this.m12;
        double d27 = (d3 * d26) + d24;
        double d28 = d26;
        double d29 = this.m22;
        double d30 = d29;
        double d31 = (d4 * d29) + d27;
        double d32 = d31;
        double d33 = (d13 * d6) + (d11 * f2) + (d9 * d5);
        double d34 = (f2 * d28) + (d5 * d25);
        double d35 = (d20 * d6) + (d18 * f2) + (d15 * d5);
        double d36 = (d6 * d30) + d34;
        double d37 = d13 * d21;
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        double d38 = d20;
        matrix4x3d3.m20 = d37 + (d11 * d8) + (d9 * d7);
        double d39 = d38 * d21;
        matrix4x3d3.m21 = d39 + (d18 * d8) + (d15 * d7);
        matrix4x3d3.m22 = (d30 * d21) + (d28 * d8) + (d25 * d7);
        matrix4x3d3.m00 = d17;
        matrix4x3d3.m01 = d22;
        matrix4x3d3.m02 = d32;
        matrix4x3d3.m10 = d33;
        matrix4x3d3.m11 = d35;
        matrix4x3d3.m12 = d36;
        matrix4x3d3.m30 = this.m30;
        matrix4x3d3.m31 = this.m31;
        matrix4x3d3.m32 = this.m32;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    public double[] getTransposed(double[] dArr) {
        return getTransposed(dArr, 0);
    }

    public Matrix4x3d reflect(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return reflect(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4x3d rotate(AxisAngle4d axisAngle4d, Matrix4x3d matrix4x3d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z, matrix4x3d);
    }

    public Matrix4x3d rotation(AxisAngle4d axisAngle4d) {
        return rotation(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Matrix4x3d(Matrix4x3fc matrix4x3fc) {
        this.m00 = (double) matrix4x3fc.m00();
        this.m01 = (double) matrix4x3fc.m01();
        this.m02 = (double) matrix4x3fc.m02();
        this.m10 = (double) matrix4x3fc.m10();
        this.m11 = (double) matrix4x3fc.m11();
        this.m12 = (double) matrix4x3fc.m12();
        this.m20 = (double) matrix4x3fc.m20();
        this.m21 = (double) matrix4x3fc.m21();
        this.m22 = (double) matrix4x3fc.m22();
        this.m30 = (double) matrix4x3fc.m30();
        this.m31 = (double) matrix4x3fc.m31();
        this.m32 = (double) matrix4x3fc.m32();
        this.properties = matrix4x3fc.properties();
    }

    public Matrix4x3d billboardSpherical(Vector3dc vector3dc, Vector3dc vector3dc2) {
        double x = vector3dc2.x() - vector3dc.x();
        double y = vector3dc2.y() - vector3dc.y();
        double z = vector3dc2.z() - vector3dc.z();
        double d2 = -y;
        double d3 = x * x;
        double sqrt = Math.sqrt((z * z) + (y * y) + d3) + z;
        double e2 = a.e(sqrt, sqrt, (d2 * d2) + d3, 1.0d);
        double d4 = d2 * e2;
        double d5 = x * e2;
        double d6 = sqrt * e2;
        double d7 = d4 + d4;
        double d8 = d4 * d7;
        double d9 = d5 + d5;
        double d10 = d9 * d5;
        double d11 = d5 * d7;
        double d12 = d7 * d6;
        double d13 = d9 * d6;
        double d14 = 1.0d - d10;
        this.m00 = d14;
        this.m01 = d11;
        this.m02 = -d13;
        this.m10 = d11;
        this.m11 = 1.0d - d8;
        this.m12 = d12;
        this.m20 = d13;
        this.m21 = -d12;
        this.m22 = d14 - d8;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.properties = 16;
        return this;
    }

    public Matrix4x3d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc) {
        return reflect(quaterniondc, vector3dc, this);
    }

    public Matrix4x3d rotate(double d2, Vector3dc vector3dc) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4x3d rotateLocal(double d2, double d3, double d4, double d5) {
        return rotateLocal(d2, d3, d4, d5, this);
    }

    public Matrix4x3d rotateLocalX(double d2) {
        return rotateLocalX(d2, this);
    }

    public Matrix4x3d rotateLocalY(double d2) {
        return rotateLocalY(d2, this);
    }

    public Matrix4x3d rotateLocalZ(double d2) {
        return rotateLocalZ(d2, this);
    }

    public Matrix4x3d rotation(Quaterniondc quaterniondc) {
        Quaterniondc quaterniondc2 = quaterniondc;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        _m00(((w + x) - z) - y);
        _m01(d2 + a2);
        _m02(b2 - a3);
        _m10(d2 - a2);
        _m11(((y - z) + w) - x);
        _m12(b3 + a4);
        _m20(a3 + b2);
        _m21(b3 - a4);
        _m22(((z - y) - x) + w);
        _m30(0.0d);
        _m31(0.0d);
        _m32(0.0d);
        this.properties = 16;
        return this;
    }

    public Matrix4x3d shadow(Vector4dc vector4dc, Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m102 = matrix4x3dc.m10();
        double d2 = m102;
        double m112 = matrix4x3dc.m11();
        double d3 = m112;
        double m122 = matrix4x3dc.m12();
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, m122, ((matrix4x3dc.m30() * (-m102)) - (matrix4x3dc.m31() * m112)) - (matrix4x3dc.m32() * m122), matrix4x3d2);
    }

    public double[] get(double[] dArr) {
        return get(dArr, 0);
    }

    public Matrix4x3d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc, Matrix4x3d matrix4x3d) {
        double x = quaterniondc.x() + quaterniondc.x();
        double y = quaterniondc.y() + quaterniondc.y();
        double z = quaterniondc.z() + quaterniondc.z();
        return reflect((quaterniondc.w() * y) + (quaterniondc.x() * z), (quaterniondc.y() * z) - (quaterniondc.w() * x), 1.0d - ((quaterniondc.y() * y) + (quaterniondc.x() * x)), vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4x3d);
    }

    public Matrix4x3d rotate(double d2, Vector3dc vector3dc, Matrix4x3d matrix4x3d) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4x3d);
    }

    public Matrix4x3d rotateLocal(Quaterniondc quaterniondc, Matrix4x3d matrix4x3d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = quaterniondc.w() * quaterniondc.w();
        double x = quaterniondc.x() * quaterniondc.x();
        double y = quaterniondc.y() * quaterniondc.y();
        double z = quaterniondc.z() * quaterniondc.z();
        double a2 = a.a(quaterniondc2, quaterniondc.z());
        double y2 = quaterniondc.y() * quaterniondc.x();
        double d2 = y2 + y2;
        double b2 = a.b(quaterniondc2, quaterniondc.x());
        double a3 = a.a(quaterniondc2, quaterniondc.y());
        double b3 = a.b(quaterniondc2, quaterniondc.y());
        double a4 = a.a(quaterniondc2, quaterniondc.x());
        double b4 = a.b(w, x, z, y);
        double d3 = d2 + a2;
        double d4 = b2 - a3;
        double d5 = d2 - a2;
        double f2 = a.f(y, z, w, x);
        double d6 = b3 + a4;
        double d7 = a3 + b2;
        double d8 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d9 = this.m00;
        double d10 = b4 * d9;
        double d11 = this.m01;
        double d12 = (d5 * d11) + d10;
        double d13 = this.m02;
        double d14 = (d7 * d13) + d12;
        double d15 = (d8 * d13) + (f2 * d11) + (d3 * d9);
        double d16 = d13 * g2;
        double d17 = d16 + (d11 * d6) + (d9 * d4);
        double d18 = this.m10;
        double d19 = b4 * d18;
        double d20 = d17;
        double d21 = this.m11;
        double d22 = (d5 * d21) + d19;
        double d23 = this.m12;
        double d24 = d15;
        double d25 = (d7 * d23) + d22;
        double d26 = (d8 * d23) + (f2 * d21) + (d3 * d18);
        double d27 = d23 * g2;
        double d28 = d27 + (d21 * d6) + (d18 * d4);
        double d29 = this.m20;
        double d30 = b4 * d29;
        double d31 = d28;
        double d32 = this.m21;
        double d33 = (d5 * d32) + d30;
        double d34 = this.m22;
        double d35 = d26;
        double d36 = (d7 * d34) + d33;
        double d37 = (d8 * d34) + (f2 * d32) + (d3 * d29);
        double d38 = d34 * g2;
        double d39 = d38 + (d32 * d6) + (d29 * d4);
        double d40 = this.m30;
        double d41 = b4 * d40;
        double d42 = this.m31;
        double d43 = (d5 * d42) + d41;
        double d44 = d39;
        double d45 = this.m32;
        double d46 = d8 * d45;
        double d47 = (d7 * d45) + d43;
        double d48 = d46 + (f2 * d42) + (d3 * d40);
        double d49 = g2 * d45;
        double d50 = d49 + (d6 * d42) + (d4 * d40);
        matrix4x3d2.m00 = d14;
        matrix4x3d2.m01 = d24;
        matrix4x3d2.m02 = d20;
        matrix4x3d2.m10 = d25;
        matrix4x3d2.m11 = d35;
        matrix4x3d2.m12 = d31;
        matrix4x3d2.m20 = d36;
        matrix4x3d2.m21 = d37;
        matrix4x3d2.m22 = d44;
        matrix4x3d2.m30 = d47;
        matrix4x3d2.m31 = d48;
        matrix4x3d2.m32 = d50;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d rotateX(double d2) {
        return rotateX(d2, this);
    }

    public Matrix4x3d rotateY(double d2) {
        return rotateY(d2, this);
    }

    public Matrix4x3d rotateZ(double d2) {
        return rotateZ(d2, this);
    }

    public Matrix4x3d set3x3(Matrix3fc matrix3fc) {
        this.m00 = (double) matrix3fc.m00();
        this.m01 = (double) matrix3fc.m01();
        this.m02 = (double) matrix3fc.m02();
        this.m10 = (double) matrix3fc.m10();
        this.m11 = (double) matrix3fc.m11();
        this.m12 = (double) matrix3fc.m12();
        this.m20 = (double) matrix3fc.m20();
        this.m21 = (double) matrix3fc.m21();
        this.m22 = (double) matrix3fc.m22();
        this.properties = 0;
        return this;
    }

    public Matrix3d transpose3x3(Matrix3d matrix3d) {
        matrix3d.m00(this.m00);
        matrix3d.m01(this.m10);
        matrix3d.m02(this.m20);
        matrix3d.m10(this.m01);
        matrix3d.m11(this.m11);
        matrix3d.m12(this.m21);
        matrix3d.m20(this.m02);
        matrix3d.m21(this.m12);
        matrix3d.m22(this.m22);
        return matrix3d;
    }

    public float[] get(float[] fArr, int i2) {
        fArr[i2 + 0] = (float) this.m00;
        fArr[i2 + 1] = (float) this.m01;
        fArr[i2 + 2] = (float) this.m02;
        fArr[i2 + 3] = (float) this.m10;
        fArr[i2 + 4] = (float) this.m11;
        fArr[i2 + 5] = (float) this.m12;
        fArr[i2 + 6] = (float) this.m20;
        fArr[i2 + 7] = (float) this.m21;
        fArr[i2 + 8] = (float) this.m22;
        fArr[i2 + 9] = (float) this.m30;
        fArr[i2 + 10] = (float) this.m31;
        fArr[i2 + 11] = (float) this.m32;
        return fArr;
    }

    public Matrix4x3d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        return lookAlong(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4x3d rotate(double d2, Vector3fc vector3fc) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4x3d translationRotateScaleMul(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Matrix4x3dc matrix4x3dc) {
        return translationRotateScaleMul(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4x3dc);
    }

    public Matrix4x3d rotate(double d2, Vector3fc vector3fc, Matrix4x3d matrix4x3d) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4x3d);
    }

    public Matrix4x3d shadow(Vector4dc vector4dc, Matrix4x3dc matrix4x3dc) {
        return shadow(vector4dc, matrix4x3dc, this);
    }

    private Matrix4x3d mulGeneric(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m022 = (this.m20 * ((double) matrix4x3fc.m02())) + (this.m10 * ((double) matrix4x3fc.m01())) + (this.m00 * ((double) matrix4x3fc.m00()));
        double m023 = (this.m21 * ((double) matrix4x3fc.m02())) + (this.m11 * ((double) matrix4x3fc.m01())) + (this.m01 * ((double) matrix4x3fc.m00()));
        double m024 = (this.m22 * ((double) matrix4x3fc.m02())) + (this.m12 * ((double) matrix4x3fc.m01())) + (this.m02 * ((double) matrix4x3fc.m00()));
        double m122 = (this.m20 * ((double) matrix4x3fc.m12())) + (this.m10 * ((double) matrix4x3fc.m11())) + (this.m00 * ((double) matrix4x3fc.m10()));
        double m123 = (this.m21 * ((double) matrix4x3fc.m12())) + (this.m11 * ((double) matrix4x3fc.m11())) + (this.m01 * ((double) matrix4x3fc.m10()));
        double d2 = m123;
        double m124 = (this.m22 * ((double) matrix4x3fc.m12())) + (this.m12 * ((double) matrix4x3fc.m11())) + (this.m02 * ((double) matrix4x3fc.m10()));
        double m222 = (this.m20 * ((double) matrix4x3fc.m22())) + (this.m10 * ((double) matrix4x3fc.m21())) + (this.m00 * ((double) matrix4x3fc.m20()));
        double m223 = (this.m21 * ((double) matrix4x3fc.m22())) + (this.m11 * ((double) matrix4x3fc.m21())) + (this.m01 * ((double) matrix4x3fc.m20()));
        double m224 = (this.m22 * ((double) matrix4x3fc.m22())) + (this.m12 * ((double) matrix4x3fc.m21())) + (this.m02 * ((double) matrix4x3fc.m20()));
        double m322 = (this.m20 * ((double) matrix4x3fc.m32())) + (this.m10 * ((double) matrix4x3fc.m31())) + (this.m00 * ((double) matrix4x3fc.m30())) + this.m30;
        double m323 = (this.m21 * ((double) matrix4x3fc.m32())) + (this.m11 * ((double) matrix4x3fc.m31())) + (this.m01 * ((double) matrix4x3fc.m30())) + this.m31;
        double m324 = (this.m22 * ((double) matrix4x3fc.m32())) + (this.m12 * ((double) matrix4x3fc.m31())) + (this.m02 * ((double) matrix4x3fc.m30())) + this.m32;
        matrix4x3d2.m00 = m022;
        matrix4x3d2.m01 = m023;
        matrix4x3d2.m02 = m024;
        matrix4x3d2.m10 = m122;
        matrix4x3d2.m11 = d2;
        matrix4x3d2.m12 = m124;
        matrix4x3d2.m20 = m222;
        matrix4x3d2.m21 = m223;
        matrix4x3d2.m22 = m224;
        matrix4x3d2.m30 = m322;
        matrix4x3d2.m31 = m323;
        matrix4x3d2.m32 = m324;
        matrix4x3d2.properties = this.properties & matrix4x3fc.properties() & 16;
        return matrix4x3d2;
    }

    public Matrix4x3d mulTranslation(Matrix4x3fc matrix4x3fc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m012 = (double) matrix4x3fc.m01();
        double m022 = (double) matrix4x3fc.m02();
        double m102 = (double) matrix4x3fc.m10();
        double m112 = (double) matrix4x3fc.m11();
        double m202 = (double) matrix4x3fc.m20();
        double m212 = (double) matrix4x3fc.m21();
        double m222 = (double) matrix4x3fc.m22();
        double m122 = (double) matrix4x3fc.m12();
        double m302 = ((double) matrix4x3fc.m30()) + this.m30;
        double m312 = ((double) matrix4x3fc.m31()) + this.m31;
        double m322 = ((double) matrix4x3fc.m32()) + this.m32;
        matrix4x3d2.m00 = (double) matrix4x3fc.m00();
        matrix4x3d2.m01 = m012;
        matrix4x3d2.m02 = m022;
        matrix4x3d2.m10 = m102;
        matrix4x3d2.m11 = m112;
        matrix4x3d2.m12 = m122;
        matrix4x3d2.m20 = m202;
        matrix4x3d2.m21 = m212;
        matrix4x3d2.m22 = m222;
        matrix4x3d2.m30 = m302;
        matrix4x3d2.m31 = m312;
        matrix4x3d2.m32 = m322;
        matrix4x3d2.properties = matrix4x3fc.properties() & 16;
        return matrix4x3d2;
    }

    public Matrix4x3d shadow(double d2, double d3, double d4, double d5, Matrix4x3dc matrix4x3dc, Matrix4x3d matrix4x3d) {
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        double d9 = d5;
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double m102 = matrix4x3dc.m10();
        double d10 = m102;
        double m112 = matrix4x3dc.m11();
        double d11 = m112;
        double m122 = matrix4x3dc.m12();
        double d12 = m102;
        double m302 = ((matrix4x3dc.m30() * (-d12)) - (matrix4x3dc.m31() * m112)) - (matrix4x3dc.m32() * m122);
        return shadow(d2, d7, d8, d9, d10, d11, m122, m302, matrix4x3d2);
    }

    public Matrix4x3d arcball(double d2, Vector3dc vector3dc, double d3, double d4, Matrix4x3d matrix4x3d) {
        return arcball(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), d3, d4, matrix4x3d);
    }

    public Matrix4x3d set(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
        this.m30 = matrix4dc.m30();
        this.m31 = matrix4dc.m31();
        this.m32 = matrix4dc.m32();
        this.properties = matrix4dc.properties() & 28;
        return this;
    }

    public Matrix4x3d arcball(double d2, double d3, double d4, double d5, double d6, double d7) {
        return arcball(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4x3d reflect(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4x3d matrix4x3d) {
        return reflect(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4x3d);
    }

    public Matrix4x3d scaleLocal(double d2, double d3, double d4) {
        return scaleLocal(d2, d3, d4, this);
    }

    public Matrix4x3d arcball(double d2, Vector3dc vector3dc, double d3, double d4) {
        return arcball(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), d3, d4, this);
    }

    public Matrix4x3d shadow(double d2, double d3, double d4, double d5, Matrix4x3dc matrix4x3dc) {
        return shadow(d2, d3, d4, d5, matrix4x3dc, this);
    }

    public Matrix4x3d(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        determineProperties();
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix4x3d rotateTranslation(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d2 = z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d3 = w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d4 = d2;
        double d5 = d3;
        double d6 = z3;
        double d7 = y2;
        double d8 = w2;
        double d9 = z;
        double b2 = a.b(w, x, z, y);
        double a2 = a.a(d7, d8, d8, d7);
        double d10 = d4;
        double d11 = d5;
        double d12 = d8;
        double d13 = (((-d12) + d7) - d12) + d7;
        double f2 = a.f(d4, d5, d10, d11);
        double d14 = a2;
        double d15 = b2;
        double f3 = a.f(y, d9, w, x);
        double d16 = d6 + d6;
        double d17 = d16 + w4 + w4;
        double d18 = (d16 - w4) - w4;
        double a3 = a.a(d5, d4, d10, d11);
        double d19 = y;
        double d20 = d17;
        double d21 = x;
        double d22 = f3;
        double g2 = a.g(d9, d19, d21, w);
        double d23 = a3;
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        matrix4x3d3.m20 = d23;
        matrix4x3d3.m21 = d18;
        matrix4x3d3.m22 = g2;
        matrix4x3d3.m00 = d15;
        matrix4x3d3.m01 = d14;
        matrix4x3d3.m02 = f2;
        matrix4x3d3.m10 = d13;
        matrix4x3d3.m11 = d22;
        matrix4x3d3.m12 = d20;
        matrix4x3d3.m30 = this.m30;
        matrix4x3d3.m31 = this.m31;
        matrix4x3d3.m32 = this.m32;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    private Matrix4x3d rotateGeneric(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d2 = z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d3 = w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d4 = d2;
        double d5 = d3;
        double d6 = z3;
        double d7 = y2;
        double d8 = w2;
        double d9 = z;
        double b2 = a.b(w, x, z, y);
        double a2 = a.a(d7, d8, d8, d7);
        double d10 = d4;
        double d11 = d5;
        double f2 = a.f(d4, d5, d10, d11);
        double d12 = d8;
        double d13 = (((-d12) + d7) - d12) + d7;
        double f3 = a.f(y, d9, w, x);
        double d14 = d6 + d6;
        double d15 = d14 + w4 + w4;
        double a3 = a.a(d5, d4, d10, d11);
        double d16 = (d14 - w4) - w4;
        double g2 = a.g(d9, y, x, w);
        double d17 = this.m00;
        double d18 = d17 * b2;
        double d19 = this.m10;
        double d20 = (d19 * a2) + d18;
        double d21 = this.m20;
        double d22 = (d21 * f2) + d20;
        double d23 = this.m01;
        double d24 = d23 * b2;
        double d25 = d22;
        double d26 = this.m11;
        double d27 = (d26 * a2) + d24;
        double d28 = this.m21;
        double d29 = g2;
        double d30 = (d28 * f2) + d27;
        double d31 = this.m02;
        double d32 = b2 * d31;
        double d33 = d31;
        double d34 = this.m12;
        double d35 = (a2 * d34) + d32;
        double d36 = d34;
        double d37 = this.m22;
        double d38 = d37;
        double d39 = (f2 * d37) + d35;
        double d40 = (d21 * d15) + (d19 * f3) + (d17 * d13);
        double d41 = (f3 * d36) + (d13 * d33);
        double d42 = (d28 * d15) + (d26 * f3) + (d23 * d13);
        double d43 = (d15 * d38) + d41;
        double d44 = d21 * d29;
        double d45 = d44 + (d19 * d16) + (d17 * a3);
        Matrix4x3d matrix4x3d3 = matrix4x3d;
        double d46 = d30;
        matrix4x3d3.m20 = d45;
        double d47 = d28 * d29;
        matrix4x3d3.m21 = d47 + (d26 * d16) + (d23 * a3);
        matrix4x3d3.m22 = (d38 * d29) + (d36 * d16) + (d33 * a3);
        matrix4x3d3.m00 = d25;
        matrix4x3d3.m01 = d46;
        matrix4x3d3.m02 = d39;
        matrix4x3d3.m10 = d40;
        matrix4x3d3.m11 = d42;
        matrix4x3d3.m12 = d43;
        matrix4x3d3.m30 = this.m30;
        matrix4x3d3.m31 = this.m31;
        matrix4x3d3.m32 = this.m32;
        matrix4x3d3.properties = this.properties & -13;
        return matrix4x3d3;
    }

    public Matrix4x3d set(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d rotateLocal(Quaterniondc quaterniondc) {
        return rotateLocal(quaterniondc, this);
    }

    public Matrix4x3d rotation(Quaternionfc quaternionfc) {
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double d2 = w2 + w2;
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double d3 = y2 + y2;
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d4 = z2 + z2;
        double y3 = (double) (quaternionfc.y() * quaternionfc.w());
        double d5 = y3 + y3;
        double y4 = (double) (quaternionfc.y() * quaternionfc.z());
        double d6 = y4 + y4;
        double x2 = (double) (quaternionfc.x() * quaternionfc.w());
        double d7 = x2 + x2;
        _m00(((w + x) - z) - y);
        _m01(d3 + d2);
        _m02(d4 - d5);
        _m10(d3 - d2);
        _m11(((y - z) + w) - x);
        _m12(d6 + d7);
        _m20(d5 + d4);
        _m21(d6 - d7);
        _m22(((z - y) - x) + w);
        _m30(0.0d);
        _m31(0.0d);
        _m32(0.0d);
        this.properties = 16;
        return this;
    }

    public Matrix4x3d rotateLocal(Quaternionfc quaternionfc, Matrix4x3d matrix4x3d) {
        Matrix4x3d matrix4x3d2 = matrix4x3d;
        double w = (double) (quaternionfc.w() * quaternionfc.w());
        double x = (double) (quaternionfc.x() * quaternionfc.x());
        double y = (double) (quaternionfc.y() * quaternionfc.y());
        double z = (double) (quaternionfc.z() * quaternionfc.z());
        double w2 = (double) (quaternionfc.w() * quaternionfc.z());
        double d2 = w2 + w2;
        double y2 = (double) (quaternionfc.y() * quaternionfc.x());
        double d3 = y2 + y2;
        double z2 = (double) (quaternionfc.z() * quaternionfc.x());
        double d4 = z2 + z2;
        double w3 = (double) (quaternionfc.w() * quaternionfc.y());
        double d5 = w3 + w3;
        double z3 = (double) (quaternionfc.z() * quaternionfc.y());
        double d6 = z3 + z3;
        double w4 = (double) (quaternionfc.w() * quaternionfc.x());
        double d7 = w4 + w4;
        double d8 = z;
        double b2 = a.b(w, x, z, y);
        double d9 = d3 + d2;
        double d10 = d4 - d5;
        double d11 = d3 - d2;
        double f2 = a.f(y, d8, w, x);
        double d12 = d6 + d7;
        double d13 = d5 + d4;
        double d14 = d6 - d7;
        double g2 = a.g(d8, y, x, w);
        double d15 = this.m00;
        double d16 = b2 * d15;
        double d17 = this.m01;
        double d18 = (d11 * d17) + d16;
        double d19 = this.m02;
        double d20 = (d13 * d19) + d18;
        double d21 = (d14 * d19) + (f2 * d17) + (d9 * d15);
        double d22 = d19 * g2;
        double d23 = d22 + (d17 * d12) + (d15 * d10);
        double d24 = this.m10;
        double d25 = b2 * d24;
        double d26 = this.m11;
        double d27 = (d11 * d26) + d25;
        double d28 = this.m12;
        double d29 = d23;
        double d30 = (d13 * d28) + d27;
        double d31 = (d14 * d28) + (f2 * d26) + (d9 * d24);
        double d32 = d28 * g2;
        double d33 = d32 + (d26 * d12) + (d24 * d10);
        double d34 = this.m20;
        double d35 = b2 * d34;
        double d36 = d33;
        double d37 = this.m21;
        double d38 = (d11 * d37) + d35;
        double d39 = this.m22;
        double d40 = d31;
        double d41 = (d13 * d39) + d38;
        double d42 = (d14 * d39) + (f2 * d37) + (d9 * d34);
        double d43 = d39 * g2;
        double d44 = d43 + (d37 * d12) + (d34 * d10);
        double d45 = this.m30;
        double d46 = b2 * d45;
        double d47 = this.m31;
        double d48 = (d11 * d47) + d46;
        double d49 = d44;
        double d50 = this.m32;
        double d51 = d42;
        double d52 = d14 * d50;
        double d53 = (d13 * d50) + d48;
        double d54 = d52 + (f2 * d47) + (d9 * d45);
        double d55 = g2 * d50;
        double d56 = d55 + (d12 * d47) + (d10 * d45);
        matrix4x3d2.m00 = d20;
        matrix4x3d2.m01 = d21;
        matrix4x3d2.m02 = d29;
        matrix4x3d2.m10 = d30;
        matrix4x3d2.m11 = d40;
        matrix4x3d2.m12 = d36;
        matrix4x3d2.m20 = d41;
        matrix4x3d2.m21 = d51;
        matrix4x3d2.m22 = d49;
        matrix4x3d2.m30 = d53;
        matrix4x3d2.m31 = d54;
        matrix4x3d2.m32 = d56;
        matrix4x3d2.properties = this.properties & -13;
        return matrix4x3d2;
    }

    public Matrix4x3d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        this.m00 = d2;
        this.m01 = d3;
        this.m02 = d4;
        this.m10 = d5;
        this.m11 = d6;
        this.m12 = d7;
        this.m20 = d8;
        this.m21 = d9;
        this.m22 = d10;
        this.m30 = d11;
        this.m31 = d12;
        this.m32 = d13;
        determineProperties();
    }

    public Matrix4x3d set(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4) {
        this.m00 = vector3dc.x();
        this.m01 = vector3dc.y();
        this.m02 = vector3dc.z();
        this.m10 = vector3dc2.x();
        this.m11 = vector3dc2.y();
        this.m12 = vector3dc2.z();
        this.m20 = vector3dc3.x();
        this.m21 = vector3dc3.y();
        this.m22 = vector3dc3.z();
        this.m30 = vector3dc4.x();
        this.m31 = vector3dc4.y();
        this.m32 = vector3dc4.z();
        this.properties = 0;
        return this;
    }

    public Matrix4x3d(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
        determineProperties();
    }

    public Matrix4x3d rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, this);
    }

    public Matrix4x3d set(AxisAngle4f axisAngle4f) {
        AxisAngle4f axisAngle4f2 = axisAngle4f;
        double d2 = (double) axisAngle4f2.x;
        double d3 = (double) axisAngle4f2.y;
        double d4 = (double) axisAngle4f2.z;
        double d5 = (double) axisAngle4f2.angle;
        double d6 = d4;
        double e2 = a.e(d4, d4, (d3 * d3) + (d2 * d2), 1.0d);
        double d7 = d2 * e2;
        double d8 = d3 * e2;
        double d9 = d6 * e2;
        double sin = Math.sin(d5);
        double cosFromSin = Math.cosFromSin(sin, d5);
        double d10 = 1.0d - cosFromSin;
        double d11 = d10;
        double d12 = cosFromSin;
        this.m00 = a.d(d7, d7, d11, d12);
        this.m11 = a.d(d8, d8, d11, d12);
        this.m22 = a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        double d15 = d8;
        this.m10 = d13 - d14;
        this.m01 = d13 + d14;
        double d16 = d7 * d9 * d10;
        double d17 = d15 * sin;
        this.m20 = d16 + d17;
        this.m02 = d16 - d17;
        double d18 = d15 * d9 * d10;
        double d19 = d7 * sin;
        this.m21 = d18 - d19;
        this.m12 = d18 + d19;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d set(AxisAngle4d axisAngle4d) {
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
        this.m00 = a.d(d7, d7, d11, d12);
        this.m11 = a.d(d8, d8, d11, d12);
        this.m22 = a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        this.m10 = d13 - d14;
        this.m01 = d13 + d14;
        double d15 = d7 * d9 * d10;
        double d16 = d8 * sin;
        this.m20 = d15 + d16;
        this.m02 = d15 - d16;
        double d17 = d8 * d9 * d10;
        double d18 = d7 * sin;
        this.m21 = d17 - d18;
        this.m12 = d17 + d18;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.properties = 16;
        return this;
    }

    public Matrix4x3d set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix4x3d set(Quaterniondc quaterniondc) {
        return rotation(quaterniondc);
    }

    public Matrix4x3d set(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        this.m00 = d2;
        this.m10 = d5;
        this.m20 = d8;
        this.m30 = d11;
        this.m01 = d3;
        this.m11 = d6;
        this.m21 = d9;
        this.m31 = d12;
        this.m02 = d4;
        this.m12 = d7;
        this.m22 = d10;
        this.m32 = d13;
        this.properties = 0;
        return this;
    }

    public Matrix4x3d set(double[] dArr, int i2) {
        this.m00 = dArr[i2 + 0];
        this.m01 = dArr[i2 + 1];
        this.m02 = dArr[i2 + 2];
        this.m10 = dArr[i2 + 3];
        this.m11 = dArr[i2 + 4];
        this.m12 = dArr[i2 + 5];
        this.m20 = dArr[i2 + 6];
        this.m21 = dArr[i2 + 7];
        this.m22 = dArr[i2 + 8];
        this.m30 = dArr[i2 + 9];
        this.m31 = dArr[i2 + 10];
        this.m32 = dArr[i2 + 11];
        this.properties = 0;
        return this;
    }

    public Matrix4x3d set(double[] dArr) {
        return set(dArr, 0);
    }

    public Matrix4x3d set(float[] fArr, int i2) {
        this.m00 = (double) fArr[i2 + 0];
        this.m01 = (double) fArr[i2 + 1];
        this.m02 = (double) fArr[i2 + 2];
        this.m10 = (double) fArr[i2 + 3];
        this.m11 = (double) fArr[i2 + 4];
        this.m12 = (double) fArr[i2 + 5];
        this.m20 = (double) fArr[i2 + 6];
        this.m21 = (double) fArr[i2 + 7];
        this.m22 = (double) fArr[i2 + 8];
        this.m30 = (double) fArr[i2 + 9];
        this.m31 = (double) fArr[i2 + 10];
        this.m32 = (double) fArr[i2 + 11];
        this.properties = 0;
        return this;
    }

    public Matrix4x3d set(float[] fArr) {
        return set(fArr, 0);
    }

    public Matrix4x3d set(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4x3d set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.getf(this, floatBuffer.position(), floatBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4x3d set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        this.properties = 0;
        return this;
    }
}
