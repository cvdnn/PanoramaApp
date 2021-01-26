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

public class Matrix4d implements Externalizable, Matrix4dc {
    public static final long serialVersionUID = 1;
    public double m00;
    public double m01;
    public double m02;
    public double m03;
    public double m10;
    public double m11;
    public double m12;
    public double m13;
    public double m20;
    public double m21;
    public double m22;
    public double m23;
    public double m30;
    public double m31;
    public double m32;
    public double m33;
    public int properties;

    public Matrix4d() {
        this.m00 = 1.0d;
        this.m11 = 1.0d;
        this.m22 = 1.0d;
        this.m33 = 1.0d;
        this.properties = 30;
    }

    private void _identity() {
        this.m00 = 1.0d;
        this.m10 = 0.0d;
        this.m20 = 0.0d;
        this.m30 = 0.0d;
        this.m01 = 0.0d;
        this.m11 = 1.0d;
        this.m21 = 0.0d;
        this.m31 = 0.0d;
        this.m02 = 0.0d;
        this.m12 = 0.0d;
        this.m22 = 1.0d;
        this.m32 = 0.0d;
        this.m03 = 0.0d;
        this.m13 = 0.0d;
        this.m23 = 0.0d;
        this.m33 = 1.0d;
    }

    private Matrix4d frustumGeneric(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        double d8;
        double d9;
        Matrix4d matrix4d2 = matrix4d;
        double d10 = d6 + d6;
        double d11 = d3 - d2;
        double d12 = d10 / d11;
        double d13 = d5 - d4;
        double d14 = d10 / d13;
        double d15 = (d3 + d2) / d11;
        double d16 = (d5 + d4) / d13;
        double d17 = 0.0d;
        boolean z2 = true;
        boolean z3 = d7 > 0.0d && Double.isInfinite(d7);
        if (d6 <= 0.0d || !Double.isInfinite(d6)) {
            z2 = false;
        }
        double d18 = 2.0d;
        if (z3) {
            d9 = -0.999999d;
            if (z) {
                d18 = 1.0d;
            }
            d8 = (1.0E-6d - d18) * d6;
        } else if (z2) {
            if (!z) {
                d17 = 1.0d;
            }
            d9 = d17 - 1.0E-6d;
            if (z) {
                d18 = 1.0d;
            }
            d8 = (d18 - 1.0E-6d) * d7;
        } else {
            double d19 = d6 - d7;
            d9 = (z ? d7 : d7 + d6) / d19;
            d8 = ((z ? d7 : d7 + d7) * d6) / d19;
        }
        double d20 = this.m00;
        double d21 = d20 * d15;
        double d22 = d14;
        double d23 = this.m10;
        double d24 = (d23 * d16) + d21;
        double d25 = this.m20;
        double d26 = (d25 * d9) + d24;
        double d27 = d25;
        double d28 = d26 - this.m30;
        double d29 = this.m01;
        double d30 = d29 * d15;
        double d31 = d23;
        double d32 = this.m11;
        double d33 = (d32 * d16) + d30;
        double d34 = d32;
        double d35 = this.m21;
        double d36 = (d35 * d9) + d33;
        double d37 = d35;
        double d38 = d36 - this.m31;
        double d39 = this.m02;
        double d40 = d39 * d15;
        double d41 = d39;
        double d42 = this.m12;
        double d43 = (d42 * d16) + d40;
        double d44 = d42;
        double d45 = this.m22;
        double d46 = (d45 * d9) + d43;
        double d47 = d45;
        double d48 = d46 - this.m32;
        double d49 = this.m03;
        double d50 = d15 * d49;
        double d51 = d49;
        double d52 = this.m13;
        double d53 = (d16 * d52) + d50;
        double d54 = this.m23;
        double d55 = ((d9 * d54) + d53) - this.m33;
        matrix4d2.m00 = d20 * d12;
        matrix4d2.m01 = d29 * d12;
        matrix4d2.m02 = d41 * d12;
        matrix4d2.m03 = d51 * d12;
        matrix4d2.m10 = d31 * d22;
        matrix4d2.m11 = d34 * d22;
        matrix4d2.m12 = d44 * d22;
        matrix4d2.m13 = d52 * d22;
        matrix4d2.m30 = d27 * d8;
        matrix4d2.m31 = d37 * d8;
        matrix4d2.m32 = d47 * d8;
        matrix4d2.m33 = d54 * d8;
        matrix4d2.m20 = d28;
        matrix4d2.m21 = d38;
        matrix4d2.m22 = d48;
        matrix4d2.m23 = d55;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    private Matrix4d frustumLHGeneric(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        double d8;
        double d9;
        Matrix4d matrix4d2 = matrix4d;
        double d10 = d6 + d6;
        double d11 = d3 - d2;
        double d12 = d10 / d11;
        double d13 = d5 - d4;
        double d14 = d10 / d13;
        double d15 = (d3 + d2) / d11;
        double d16 = (d5 + d4) / d13;
        double d17 = 0.0d;
        boolean z2 = true;
        boolean z3 = d7 > 0.0d && Double.isInfinite(d7);
        if (d6 <= 0.0d || !Double.isInfinite(d6)) {
            z2 = false;
        }
        double d18 = 2.0d;
        if (z3) {
            d9 = 0.999999d;
            if (z) {
                d18 = 1.0d;
            }
            d8 = (1.0E-6d - d18) * d6;
        } else if (z2) {
            if (!z) {
                d17 = 1.0d;
            }
            d9 = d17 - 1.0E-6d;
            if (z) {
                d18 = 1.0d;
            }
            d8 = (d18 - 1.0E-6d) * d7;
        } else {
            d9 = (z ? d7 : d7 + d6) / (d7 - d6);
            d8 = ((z ? d7 : d7 + d7) * d6) / (d6 - d7);
        }
        double d19 = this.m00;
        double d20 = d19 * d15;
        double d21 = d14;
        double d22 = this.m10;
        double d23 = (d22 * d16) + d20;
        double d24 = this.m20;
        double d25 = (d24 * d9) + d23;
        double d26 = d24;
        double d27 = d25 + this.m30;
        double d28 = this.m01;
        double d29 = d28 * d15;
        double d30 = d22;
        double d31 = this.m11;
        double d32 = (d31 * d16) + d29;
        double d33 = d31;
        double d34 = this.m21;
        double d35 = (d34 * d9) + d32;
        double d36 = d34;
        double d37 = d35 + this.m31;
        double d38 = this.m02;
        double d39 = d38 * d15;
        double d40 = d38;
        double d41 = this.m12;
        double d42 = (d41 * d16) + d39;
        double d43 = d41;
        double d44 = this.m22;
        double d45 = (d44 * d9) + d42;
        double d46 = d44;
        double d47 = d45 + this.m32;
        double d48 = this.m03;
        double d49 = d15 * d48;
        double d50 = d48;
        double d51 = this.m13;
        double d52 = (d16 * d51) + d49;
        double d53 = this.m23;
        double d54 = (d9 * d53) + d52 + this.m33;
        matrix4d2.m00 = d19 * d12;
        matrix4d2.m01 = d28 * d12;
        matrix4d2.m02 = d40 * d12;
        matrix4d2.m03 = d50 * d12;
        matrix4d2.m10 = d30 * d21;
        matrix4d2.m11 = d33 * d21;
        matrix4d2.m12 = d43 * d21;
        matrix4d2.m13 = d51 * d21;
        matrix4d2.m30 = d26 * d8;
        matrix4d2.m31 = d36 * d8;
        matrix4d2.m32 = d46 * d8;
        matrix4d2.m33 = d53 * d8;
        matrix4d2.m20 = d27;
        matrix4d2.m21 = d37;
        matrix4d2.m22 = d47;
        matrix4d2.m23 = d54;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    private Matrix4d invertGeneric(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d12 = d9 - (d11 * d6);
        double d13 = this.m13;
        double d14 = d2 * d13;
        double d15 = d2;
        double d16 = this.m03;
        double d17 = d14 - (d16 * d6);
        double d18 = (d5 * d8) - (d11 * d3);
        double d19 = (d5 * d13) - (d16 * d3);
        double d20 = (d11 * d13) - (d16 * d8);
        double d21 = d6;
        double d22 = this.m20;
        double d23 = d16;
        double d24 = this.m31;
        double d25 = d22 * d24;
        double d26 = d11;
        double d27 = this.m21;
        double d28 = d5;
        double d29 = this.m30;
        double d30 = d25 - (d27 * d29);
        double d31 = d13;
        double d32 = this.m32;
        double d33 = d22 * d32;
        double d34 = d8;
        double d35 = this.m22;
        double d36 = d33 - (d35 * d29);
        double d37 = d3;
        double d38 = this.m33;
        double d39 = d22 * d38;
        double d40 = d22;
        double d41 = this.m23;
        double d42 = d39 - (d41 * d29);
        double d43 = (d27 * d32) - (d35 * d24);
        double d44 = (d27 * d38) - (d41 * d24);
        double d45 = (d35 * d38) - (d41 * d32);
        double d46 = d20;
        double d47 = d30;
        double l = a.l(d46, d47, ((d18 * d42) + ((d17 * d43) + ((d10 * d45) - (d12 * d44)))) - (d19 * d36), 1.0d);
        double d48 = d32;
        double d49 = d31;
        double d50 = d29;
        double k = a.k(d49, d43, (d37 * d45) - (d34 * d44), l);
        double d51 = d28;
        double d52 = d23;
        double d53 = d43;
        double d54 = l;
        double c2 = a.c(d52, d53, (d26 * d44) + ((-d51) * d45), d54);
        double d55 = d18;
        double d56 = d24;
        double k2 = a.k(d38, d55, (d24 * d20) - (d48 * d19), d54);
        double d57 = c2;
        double d58 = d41;
        double d59 = k2;
        double c3 = a.c(d58, d55, (d35 * d19) + ((-d27) * d20), d54);
        double d60 = d21;
        double d61 = k;
        double d62 = d57;
        double d63 = c3;
        double c4 = a.c(d49, d36, (d34 * d42) + ((-d60) * d45), l);
        double d64 = d27;
        double k3 = a.k(d23, d36, (d45 * d15) - (d26 * d42), d54);
        double d65 = c4;
        double d66 = d50;
        double d67 = d38;
        double d68 = d12;
        double c5 = a.c(d67, d68, (d48 * d17) + ((-d66) * d20), d54);
        double d69 = (d20 * d40) - (d35 * d17);
        double d70 = d35;
        double d71 = c5;
        double d72 = d65;
        double k4 = a.k(d41, d68, d69, d54);
        double k5 = a.k(d49, d30, (d60 * d44) - (d37 * d42), l);
        double d73 = d23;
        double d74 = d30;
        double d75 = (d66 * d19) - (d56 * d17);
        double c6 = a.c(d73, d74, (d42 * d51) + ((-d15) * d44), d54);
        double d76 = k5;
        double d77 = d10;
        double d78 = l;
        double k6 = a.k(d38, d77, d75, d78);
        double d79 = d40;
        double d80 = d79;
        double d81 = d41;
        double c7 = a.c(d81, d77, (d17 * d64) + ((-d79) * d19), d78);
        double d82 = (d37 * d36) + ((-d60) * d43);
        double d83 = d15;
        double d84 = d70;
        double d85 = c7;
        double d86 = k4;
        double c8 = a.c(d34, d30, d82, l);
        double k7 = a.k(d26, d30, (d83 * d43) - (d51 * d36), l);
        double d87 = d48;
        double d88 = d10;
        double d89 = l;
        double c9 = a.c(d87, d88, (d56 * d12) + ((-d66) * d18), d89);
        double k8 = a.k(d84, d88, (d80 * d18) - (d64 * d12), d89);
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = d61;
        matrix4d3.m01 = d62;
        matrix4d3.m02 = d59;
        matrix4d3.m03 = d63;
        matrix4d3.m10 = d72;
        matrix4d3.m11 = k3;
        matrix4d3.m12 = d71;
        matrix4d3.m13 = d86;
        matrix4d3.m20 = d76;
        matrix4d3.m21 = c6;
        matrix4d3.m22 = k6;
        matrix4d3.m23 = d85;
        matrix4d3.m30 = c8;
        matrix4d3.m31 = k7;
        matrix4d3.m32 = c9;
        matrix4d3.m33 = k8;
        matrix4d3.properties = 0;
        return matrix4d3;
    }

    private Matrix4d invertOrthonormal(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = d2;
        matrix4d2.m01 = d11;
        matrix4d2.m02 = d20;
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = d22;
        matrix4d2.m11 = d16;
        matrix4d2.m12 = d23;
        matrix4d2.m13 = 0.0d;
        matrix4d2.m20 = d13;
        matrix4d2.m21 = d18;
        matrix4d2.m22 = d25;
        matrix4d2.m23 = 0.0d;
        matrix4d2.m30 = d10;
        matrix4d2.m31 = d19;
        matrix4d2.m32 = d26;
        matrix4d2.m33 = 1.0d;
        matrix4d2.properties = 18;
        return matrix4d2;
    }

    private Matrix4d invertTranslation(Matrix4d matrix4d) {
        if (matrix4d != this) {
            matrix4d.set((Matrix4dc) this);
        }
        matrix4d.m30 = -this.m30;
        matrix4d.m31 = -this.m31;
        matrix4d.m32 = -this.m32;
        matrix4d.properties = 26;
        return matrix4d;
    }

    private Matrix4d lookAlongGeneric(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d43 = d42 * d17;
        double d44 = d42;
        double d45 = this.m12;
        double d46 = (d45 * d20) + d43;
        double d47 = d45;
        double d48 = this.m22;
        double d49 = d48;
        double d50 = (d48 * d11) + d46;
        double d51 = this.m03;
        double d52 = d17 * d51;
        double d53 = d51;
        double d54 = this.m13;
        double d55 = (d20 * d54) + d52;
        double d56 = this.m23;
        double d57 = (d11 * d56) + d55;
        double d58 = (d31 * d29) + (d27 * d21) + (d24 * d18);
        double d59 = (d40 * d29) + (d38 * d21) + (d35 * d18);
        double d60 = d59;
        double d61 = (d49 * d29) + (d47 * d21) + (d44 * d18);
        double d62 = (d56 * d29) + (d21 * d54) + (d18 * d53);
        matrix4d2.m20 = (d31 * d23) + (d27 * d22) + (d24 * d26);
        matrix4d2.m21 = (d40 * d23) + (d38 * d22) + (d35 * d26);
        matrix4d2.m22 = (d49 * d23) + (d47 * d22) + (d44 * d26);
        double d63 = d56 * d23;
        matrix4d2.m23 = d63 + (d54 * d22) + (d53 * d26);
        matrix4d2.m00 = d32;
        matrix4d2.m01 = d41;
        matrix4d2.m02 = d50;
        matrix4d2.m03 = d57;
        matrix4d2.m10 = d58;
        matrix4d2.m11 = d60;
        matrix4d2.m12 = d61;
        matrix4d2.m13 = d62;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d lookAtGeneric(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = d40 + this.m30;
        double d42 = this.m01;
        double d43 = d42 * d27;
        double d44 = d42;
        double d45 = this.m11;
        double d46 = (d45 * d29) + d43;
        double d47 = d45;
        double d48 = this.m21;
        double d49 = (d48 * d31) + d46;
        double d50 = d48;
        matrix4d2.m31 = d49 + this.m31;
        double d51 = this.m02;
        double d52 = d51 * d27;
        double d53 = d51;
        double d54 = this.m12;
        double d55 = (d54 * d29) + d52;
        double d56 = d54;
        double d57 = this.m22;
        double d58 = (d57 * d31) + d55;
        double d59 = d57;
        matrix4d2.m32 = d58 + this.m32;
        double d60 = this.m03;
        double d61 = d27 * d60;
        double d62 = d60;
        double d63 = this.m13;
        double d64 = (d29 * d63) + d61;
        double d65 = this.m23;
        matrix4d2.m33 = (d31 * d65) + d64 + this.m33;
        double d66 = (d41 * d35) + (d38 * d23) + (d33 * d20);
        double d67 = (d50 * d35) + (d47 * d23) + (d44 * d20);
        double d68 = (d59 * d35) + (d56 * d23) + (d53 * d20);
        double d69 = (d65 * d35) + (d23 * d63) + (d20 * d62);
        double d70 = (d41 * d32) + (d38 * d24) + (d33 * d28);
        double d71 = (d50 * d32) + (d47 * d24) + (d44 * d28);
        double d72 = d71;
        double d73 = (d59 * d32) + (d56 * d24) + (d53 * d28);
        double d74 = d32 * d65;
        double d75 = d73;
        double d76 = d74 + (d24 * d63) + (d62 * d28);
        matrix4d2.m20 = (d41 * d30) + (d38 * d25) + (d33 * d26);
        matrix4d2.m21 = (d50 * d30) + (d47 * d25) + (d44 * d26);
        matrix4d2.m22 = (d59 * d30) + (d56 * d25) + (d53 * d26);
        double d77 = d65 * d30;
        matrix4d2.m23 = d77 + (d63 * d25) + (d62 * d26);
        matrix4d2.m00 = d66;
        matrix4d2.m01 = d67;
        matrix4d2.m02 = d68;
        matrix4d2.m03 = d69;
        matrix4d2.m10 = d70;
        matrix4d2.m11 = d72;
        matrix4d2.m12 = d75;
        matrix4d2.m13 = d76;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d lookAtLHGeneric(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = d40 + this.m30;
        double d42 = this.m01;
        double d43 = d42 * d27;
        double d44 = d42;
        double d45 = this.m11;
        double d46 = (d45 * d29) + d43;
        double d47 = d45;
        double d48 = this.m21;
        double d49 = (d48 * d31) + d46;
        double d50 = d48;
        matrix4d2.m31 = d49 + this.m31;
        double d51 = this.m02;
        double d52 = d51 * d27;
        double d53 = d51;
        double d54 = this.m12;
        double d55 = (d54 * d29) + d52;
        double d56 = d54;
        double d57 = this.m22;
        double d58 = (d57 * d31) + d55;
        double d59 = d57;
        matrix4d2.m32 = d58 + this.m32;
        double d60 = this.m03;
        double d61 = d27 * d60;
        double d62 = d60;
        double d63 = this.m13;
        double d64 = (d29 * d63) + d61;
        double d65 = this.m23;
        matrix4d2.m33 = (d31 * d65) + d64 + this.m33;
        double d66 = (d41 * d35) + (d38 * d23) + (d33 * d20);
        double d67 = (d50 * d35) + (d47 * d23) + (d44 * d20);
        double d68 = (d59 * d35) + (d56 * d23) + (d53 * d20);
        double d69 = (d65 * d35) + (d23 * d63) + (d20 * d62);
        double d70 = (d41 * d32) + (d38 * d24) + (d33 * d28);
        double d71 = (d50 * d32) + (d47 * d24) + (d44 * d28);
        double d72 = d71;
        double d73 = (d59 * d32) + (d56 * d24) + (d53 * d28);
        double d74 = d32 * d65;
        double d75 = d73;
        double d76 = d74 + (d24 * d63) + (d62 * d28);
        matrix4d2.m20 = (d41 * d30) + (d38 * d25) + (d33 * d26);
        matrix4d2.m21 = (d50 * d30) + (d47 * d25) + (d44 * d26);
        matrix4d2.m22 = (d59 * d30) + (d56 * d25) + (d53 * d26);
        double d77 = d65 * d30;
        matrix4d2.m23 = d77 + (d63 * d25) + (d62 * d26);
        matrix4d2.m00 = d66;
        matrix4d2.m01 = d67;
        matrix4d2.m02 = d68;
        matrix4d2.m03 = d69;
        matrix4d2.m10 = d70;
        matrix4d2.m11 = d72;
        matrix4d2.m12 = d75;
        matrix4d2.m13 = d76;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d mulGeneric(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m032 = (matrix4dc.m03() * this.m30) + (matrix4dc.m02() * this.m20) + (matrix4dc.m01() * this.m10) + (matrix4dc.m00() * this.m00);
        double m033 = (matrix4dc.m03() * this.m31) + (matrix4dc.m02() * this.m21) + (matrix4dc.m01() * this.m11) + (matrix4dc.m00() * this.m01);
        double m034 = (matrix4dc.m03() * this.m32) + (matrix4dc.m02() * this.m22) + (matrix4dc.m01() * this.m12) + (matrix4dc.m00() * this.m02);
        double m035 = (matrix4dc.m03() * this.m33) + (matrix4dc.m02() * this.m23) + (matrix4dc.m01() * this.m13) + (matrix4dc.m00() * this.m03);
        double m132 = (matrix4dc.m13() * this.m30) + (matrix4dc.m12() * this.m20) + (matrix4dc.m11() * this.m10) + (matrix4dc.m10() * this.m00);
        double m133 = (matrix4dc.m13() * this.m31) + (matrix4dc.m12() * this.m21) + (matrix4dc.m11() * this.m11) + (matrix4dc.m10() * this.m01);
        double m134 = (matrix4dc.m13() * this.m32) + (matrix4dc.m12() * this.m22) + (matrix4dc.m11() * this.m12) + (matrix4dc.m10() * this.m02);
        double m135 = (matrix4dc.m13() * this.m33) + (matrix4dc.m12() * this.m23) + (matrix4dc.m11() * this.m13) + (matrix4dc.m10() * this.m03);
        double m232 = (matrix4dc.m23() * this.m30) + (matrix4dc.m22() * this.m20) + (matrix4dc.m21() * this.m10) + (matrix4dc.m20() * this.m00);
        double m233 = (matrix4dc.m23() * this.m31) + (matrix4dc.m22() * this.m21) + (matrix4dc.m21() * this.m11) + (matrix4dc.m20() * this.m01);
        double m234 = (matrix4dc.m23() * this.m32) + (matrix4dc.m22() * this.m22) + (matrix4dc.m21() * this.m12) + (matrix4dc.m20() * this.m02);
        double m235 = (matrix4dc.m23() * this.m33) + (matrix4dc.m22() * this.m23) + (matrix4dc.m21() * this.m13) + (matrix4dc.m20() * this.m03);
        double m332 = (matrix4dc.m33() * this.m30) + (matrix4dc.m32() * this.m20) + (matrix4dc.m31() * this.m10) + (matrix4dc.m30() * this.m00);
        double m333 = (matrix4dc.m33() * this.m31) + (matrix4dc.m32() * this.m21) + (matrix4dc.m31() * this.m11) + (matrix4dc.m30() * this.m01);
        double m334 = (matrix4dc.m33() * this.m32) + (matrix4dc.m32() * this.m22) + (matrix4dc.m31() * this.m12) + (matrix4dc.m30() * this.m02);
        double m335 = (matrix4dc.m33() * this.m33) + (matrix4dc.m32() * this.m23) + (matrix4dc.m31() * this.m13) + (matrix4dc.m30() * this.m03);
        matrix4d2.m00 = m032;
        matrix4d2.m01 = m033;
        matrix4d2.m02 = m034;
        matrix4d2.m03 = m035;
        matrix4d2.m10 = m132;
        matrix4d2.m11 = m133;
        matrix4d2.m12 = m134;
        matrix4d2.m13 = m135;
        matrix4d2.m20 = m232;
        matrix4d2.m21 = m233;
        matrix4d2.m22 = m234;
        matrix4d2.m23 = m235;
        matrix4d2.m30 = m332;
        matrix4d2.m31 = m333;
        matrix4d2.m32 = m334;
        matrix4d2.m33 = m335;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    private Matrix4d mulLocalGeneric(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m302 = (matrix4dc.m30() * this.m03) + (matrix4dc.m20() * this.m02) + (matrix4dc.m10() * this.m01) + (matrix4dc.m00() * this.m00);
        double m312 = (matrix4dc.m31() * this.m03) + (matrix4dc.m21() * this.m02) + (matrix4dc.m11() * this.m01) + (matrix4dc.m01() * this.m00);
        double m322 = (matrix4dc.m32() * this.m03) + (matrix4dc.m22() * this.m02) + (matrix4dc.m12() * this.m01) + (matrix4dc.m02() * this.m00);
        double m332 = (matrix4dc.m33() * this.m03) + (matrix4dc.m23() * this.m02) + (matrix4dc.m13() * this.m01) + (matrix4dc.m03() * this.m00);
        double m303 = (matrix4dc.m30() * this.m13) + (matrix4dc.m20() * this.m12) + (matrix4dc.m10() * this.m11) + (matrix4dc.m00() * this.m10);
        double d2 = m303;
        double m313 = (matrix4dc.m31() * this.m13) + (matrix4dc.m21() * this.m12) + (matrix4dc.m11() * this.m11) + (matrix4dc.m01() * this.m10);
        double d3 = m313;
        double m323 = (matrix4dc.m32() * this.m13) + (matrix4dc.m22() * this.m12) + (matrix4dc.m12() * this.m11) + (matrix4dc.m02() * this.m10);
        double d4 = m323;
        double m333 = (matrix4dc.m33() * this.m13) + (matrix4dc.m23() * this.m12) + (matrix4dc.m13() * this.m11) + (matrix4dc.m03() * this.m10);
        double d5 = m333;
        double m304 = (matrix4dc.m30() * this.m23) + (matrix4dc.m20() * this.m22) + (matrix4dc.m10() * this.m21) + (matrix4dc.m00() * this.m20);
        double d6 = m304;
        double m314 = (matrix4dc.m31() * this.m23) + (matrix4dc.m21() * this.m22) + (matrix4dc.m11() * this.m21) + (matrix4dc.m01() * this.m20);
        double d7 = m314;
        double m324 = (matrix4dc.m32() * this.m23) + (matrix4dc.m22() * this.m22) + (matrix4dc.m12() * this.m21) + (matrix4dc.m02() * this.m20);
        double d8 = m324;
        double m334 = (matrix4dc.m33() * this.m23) + (matrix4dc.m23() * this.m22) + (matrix4dc.m13() * this.m21) + (matrix4dc.m03() * this.m20);
        double d9 = m334;
        double m305 = (matrix4dc.m30() * this.m33) + (matrix4dc.m20() * this.m32) + (matrix4dc.m10() * this.m31) + (matrix4dc.m00() * this.m30);
        double d10 = m305;
        double m315 = (matrix4dc.m31() * this.m33) + (matrix4dc.m21() * this.m32) + (matrix4dc.m11() * this.m31) + (matrix4dc.m01() * this.m30);
        double d11 = m315;
        double m325 = (matrix4dc.m32() * this.m33) + (matrix4dc.m22() * this.m32) + (matrix4dc.m12() * this.m31) + (matrix4dc.m02() * this.m30);
        double d12 = m325;
        double m335 = (matrix4dc.m33() * this.m33) + (matrix4dc.m23() * this.m32) + (matrix4dc.m13() * this.m31) + (matrix4dc.m03() * this.m30);
        matrix4d2.m00 = m302;
        matrix4d2.m01 = m312;
        matrix4d2.m02 = m322;
        matrix4d2.m03 = m332;
        matrix4d2.m10 = d2;
        matrix4d2.m11 = d3;
        matrix4d2.m12 = d4;
        matrix4d2.m13 = d5;
        matrix4d2.m20 = d6;
        matrix4d2.m21 = d7;
        matrix4d2.m22 = d8;
        matrix4d2.m23 = d9;
        matrix4d2.m30 = d10;
        matrix4d2.m31 = d11;
        matrix4d2.m32 = d12;
        matrix4d2.m33 = m335;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    private Matrix4d normalGeneric(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = d30;
        matrix4d3.m01 = c3;
        matrix4d3.m02 = d32;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = c5;
        matrix4d3.m11 = c6;
        matrix4d3.m12 = c7;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m20 = d33;
        matrix4d3.m21 = d34;
        matrix4d3.m22 = d35;
        matrix4d3.m23 = 0.0d;
        matrix4d3.m30 = 0.0d;
        matrix4d3.m31 = 0.0d;
        matrix4d3.m32 = 0.0d;
        matrix4d3.m33 = 1.0d;
        matrix4d3.properties = 18;
        return matrix4d3;
    }

    private Matrix4d normalOrthonormal(Matrix4d matrix4d) {
        if (matrix4d != this) {
            matrix4d.set((Matrix4dc) this);
        }
        matrix4d.properties = 18;
        return matrix4d;
    }

    private Vector3d originGeneric(Vector3d vector3d) {
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
        double d12 = d9 - (d11 * d6);
        double d13 = this.m13;
        double d14 = d2 * d13;
        double d15 = d2;
        double d16 = this.m03;
        double d17 = d14 - (d16 * d6);
        double d18 = (d5 * d8) - (d11 * d3);
        double d19 = (d5 * d13) - (d16 * d3);
        double d20 = (d13 * d11) - (d16 * d8);
        double d21 = this.m20;
        double d22 = d11;
        double d23 = this.m31;
        double d24 = d21 * d23;
        double d25 = d5;
        double d26 = this.m21;
        double d27 = d8;
        double d28 = this.m30;
        double d29 = d24 - (d26 * d28);
        double d30 = d3;
        double d31 = this.m32;
        double d32 = d21 * d31;
        double d33 = d6;
        double d34 = this.m22;
        double d35 = d32 - (d34 * d28);
        double d36 = d20;
        double d37 = this.m33;
        double d38 = d21 * d37;
        double d39 = d21;
        double d40 = this.m23;
        double d41 = (d26 * d31) - (d34 * d23);
        double d42 = (d26 * d37) - (d40 * d23);
        double d43 = d39;
        double d44 = (d38 - (d40 * d28)) * d18;
        double d45 = d36 * d29;
        double c2 = d45 + ((d44 + ((d17 * d41) + (a.c(d40, d31, d37 * d34, d10) - (d42 * d12)))) - (d19 * d35));
        double d46 = 1.0d / c2;
        double d47 = c2;
        double d48 = d28;
        double c3 = a.c(d27, d29, (d30 * d35) + ((-d33) * d41), d46);
        double k = a.k(d22, d29, (d15 * d41) - (d25 * d35), d46);
        double d49 = d31;
        double d50 = d10;
        double c4 = a.c(d49, d50, (d23 * d12) + ((-d48) * d18), d46);
        double l = a.l(d34, d50, (d43 * d18) - (d26 * d12), d47);
        return vector3d.set(c3 * l, k * l, c4 * l);
    }

    private Matrix4d ortho2DGeneric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d6 = 2.0d / (d3 - d2);
        double d7 = 2.0d / (d5 - d4);
        double d8 = (d3 + d2) / (d2 - d3);
        double d9 = (d5 + d4) / (d4 - d5);
        double d10 = this.m00;
        double d11 = d10 * d8;
        double d12 = this.m10;
        matrix4d2.m30 = (d12 * d9) + d11 + this.m30;
        double d13 = this.m01;
        double d14 = d13 * d8;
        double d15 = d7;
        double d16 = this.m11;
        double d17 = (d16 * d9) + d14;
        double d18 = d16;
        matrix4d2.m31 = d17 + this.m31;
        double d19 = this.m02;
        double d20 = d19 * d8;
        double d21 = d12;
        double d22 = this.m12;
        double d23 = (d22 * d9) + d20;
        double d24 = d22;
        matrix4d2.m32 = d23 + this.m32;
        double d25 = this.m03;
        double d26 = d8 * d25;
        double d27 = d25;
        double d28 = this.m13;
        matrix4d2.m33 = (d9 * d28) + d26 + this.m33;
        matrix4d2.m00 = d10 * d6;
        matrix4d2.m01 = d13 * d6;
        matrix4d2.m02 = d19 * d6;
        matrix4d2.m03 = d6 * d27;
        matrix4d2.m10 = d21 * d15;
        matrix4d2.m11 = d18 * d15;
        matrix4d2.m12 = d24 * d15;
        matrix4d2.m13 = d28 * d15;
        matrix4d2.m20 = -this.m20;
        matrix4d2.m21 = -this.m21;
        matrix4d2.m22 = -this.m22;
        matrix4d2.m23 = -this.m23;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d ortho2DLHGeneric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d6 = 2.0d / (d3 - d2);
        double d7 = 2.0d / (d5 - d4);
        double d8 = (d3 + d2) / (d2 - d3);
        double d9 = (d5 + d4) / (d4 - d5);
        double d10 = this.m00;
        double d11 = d10 * d8;
        double d12 = this.m10;
        matrix4d2.m30 = (d12 * d9) + d11 + this.m30;
        double d13 = this.m01;
        double d14 = d13 * d8;
        double d15 = d7;
        double d16 = this.m11;
        double d17 = (d16 * d9) + d14;
        double d18 = d16;
        matrix4d2.m31 = d17 + this.m31;
        double d19 = this.m02;
        double d20 = d19 * d8;
        double d21 = d12;
        double d22 = this.m12;
        double d23 = (d22 * d9) + d20;
        double d24 = d22;
        matrix4d2.m32 = d23 + this.m32;
        double d25 = this.m03;
        double d26 = d8 * d25;
        double d27 = d25;
        double d28 = this.m13;
        matrix4d2.m33 = (d9 * d28) + d26 + this.m33;
        matrix4d2.m00 = d10 * d6;
        matrix4d2.m01 = d13 * d6;
        matrix4d2.m02 = d19 * d6;
        matrix4d2.m03 = d6 * d27;
        matrix4d2.m10 = d21 * d15;
        matrix4d2.m11 = d18 * d15;
        matrix4d2.m12 = d24 * d15;
        matrix4d2.m13 = d28 * d15;
        matrix4d2.m20 = this.m20;
        matrix4d2.m21 = this.m21;
        matrix4d2.m22 = this.m22;
        matrix4d2.m23 = this.m23;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d orthoGeneric(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = d23 + this.m30;
        double d25 = this.m01;
        double d26 = d25 * d13;
        double d27 = d10;
        double d28 = this.m11;
        double d29 = (d28 * d14) + d26;
        double d30 = d28;
        double d31 = this.m21;
        double d32 = (d31 * d15) + d29;
        double d33 = d31;
        matrix4d2.m31 = d32 + this.m31;
        double d34 = this.m02;
        double d35 = d34 * d13;
        double d36 = d34;
        double d37 = this.m12;
        double d38 = (d37 * d14) + d35;
        double d39 = d37;
        double d40 = this.m22;
        double d41 = (d40 * d15) + d38;
        double d42 = d40;
        matrix4d2.m32 = d41 + this.m32;
        double d43 = this.m03;
        double d44 = d13 * d43;
        double d45 = d43;
        double d46 = this.m13;
        double d47 = (d14 * d46) + d44;
        double d48 = this.m23;
        matrix4d2.m33 = (d15 * d48) + d47 + this.m33;
        matrix4d2.m00 = d16 * d9;
        matrix4d2.m01 = d25 * d9;
        matrix4d2.m02 = d36 * d9;
        matrix4d2.m03 = d9 * d45;
        matrix4d2.m10 = d21 * d27;
        matrix4d2.m11 = d30 * d27;
        matrix4d2.m12 = d39 * d27;
        matrix4d2.m13 = d46 * d27;
        matrix4d2.m20 = d24 * d18;
        matrix4d2.m21 = d33 * d18;
        matrix4d2.m22 = d42 * d18;
        matrix4d2.m23 = d48 * d18;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d orthoLHGeneric(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = d22 + this.m30;
        double d24 = this.m01;
        double d25 = d24 * d12;
        double d26 = d10;
        double d27 = this.m11;
        double d28 = (d27 * d13) + d25;
        double d29 = d27;
        double d30 = this.m21;
        double d31 = (d30 * d14) + d28;
        double d32 = d30;
        matrix4d2.m31 = d31 + this.m31;
        double d33 = this.m02;
        double d34 = d33 * d12;
        double d35 = d33;
        double d36 = this.m12;
        double d37 = (d36 * d13) + d34;
        double d38 = d36;
        double d39 = this.m22;
        double d40 = (d39 * d14) + d37;
        double d41 = d39;
        matrix4d2.m32 = d40 + this.m32;
        double d42 = this.m03;
        double d43 = d12 * d42;
        double d44 = d42;
        double d45 = this.m13;
        double d46 = (d13 * d45) + d43;
        double d47 = this.m23;
        matrix4d2.m33 = (d14 * d47) + d46 + this.m33;
        matrix4d2.m00 = d15 * d9;
        matrix4d2.m01 = d24 * d9;
        matrix4d2.m02 = d35 * d9;
        matrix4d2.m03 = d9 * d44;
        matrix4d2.m10 = d20 * d26;
        matrix4d2.m11 = d29 * d26;
        matrix4d2.m12 = d38 * d26;
        matrix4d2.m13 = d45 * d26;
        matrix4d2.m20 = d23 * d17;
        matrix4d2.m21 = d32 * d17;
        matrix4d2.m22 = d41 * d17;
        matrix4d2.m23 = d47 * d17;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d orthoSymmetricGeneric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = (d12 * d11) + this.m30;
        double d13 = this.m21;
        double d14 = d13;
        matrix4d2.m31 = (d13 * d11) + this.m31;
        double d15 = this.m22;
        double d16 = d15;
        matrix4d2.m32 = (d15 * d11) + this.m32;
        double d17 = this.m23;
        matrix4d2.m33 = (d11 * d17) + this.m33;
        matrix4d2.m00 = this.m00 * d7;
        matrix4d2.m01 = this.m01 * d7;
        matrix4d2.m02 = this.m02 * d7;
        matrix4d2.m03 = this.m03 * d7;
        matrix4d2.m10 = this.m10 * d8;
        matrix4d2.m11 = this.m11 * d8;
        matrix4d2.m12 = this.m12 * d8;
        matrix4d2.m13 = this.m13 * d8;
        matrix4d2.m20 = d12 * d10;
        matrix4d2.m21 = d14 * d10;
        matrix4d2.m22 = d16 * d10;
        matrix4d2.m23 = d17 * d10;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d orthoSymmetricLHGeneric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d6 = 2.0d;
        double d7 = 2.0d / d2;
        double d8 = 2.0d / d3;
        if (z) {
            d6 = 1.0d;
        }
        double d9 = d6 / (d5 - d4);
        double d10 = (z ? d4 : d5 + d4) / (d4 - d5);
        double d11 = this.m20;
        matrix4d2.m30 = (d11 * d10) + this.m30;
        double d12 = this.m21;
        double d13 = d12;
        matrix4d2.m31 = (d12 * d10) + this.m31;
        double d14 = this.m22;
        double d15 = d14;
        matrix4d2.m32 = (d14 * d10) + this.m32;
        double d16 = this.m23;
        matrix4d2.m33 = (d10 * d16) + this.m33;
        matrix4d2.m00 = this.m00 * d7;
        matrix4d2.m01 = this.m01 * d7;
        matrix4d2.m02 = this.m02 * d7;
        matrix4d2.m03 = this.m03 * d7;
        matrix4d2.m10 = this.m10 * d8;
        matrix4d2.m11 = this.m11 * d8;
        matrix4d2.m12 = this.m12 * d8;
        matrix4d2.m13 = this.m13 * d8;
        matrix4d2.m20 = d11 * d9;
        matrix4d2.m21 = d13 * d9;
        matrix4d2.m22 = d15 * d9;
        matrix4d2.m23 = d16 * d9;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    private Matrix4d perspectiveGeneric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        double d6;
        double d7;
        Matrix4d matrix4d2 = matrix4d;
        double tan = Math.tan(0.5d * d2);
        double d8 = 1.0d;
        double d9 = 1.0d / (tan * d3);
        double d10 = 1.0d / tan;
        double d11 = 0.0d;
        boolean z2 = true;
        boolean z3 = d5 > 0.0d && Double.isInfinite(d5);
        if (d4 <= 0.0d || !Double.isInfinite(d4)) {
            z2 = false;
        }
        if (z3) {
            d7 = -0.999999d;
            if (!z) {
                d8 = 2.0d;
            }
            d6 = (1.0E-6d - d8) * d4;
        } else if (z2) {
            if (!z) {
                d11 = 1.0d;
            }
            d7 = d11 - 1.0E-6d;
            if (!z) {
                d8 = 2.0d;
            }
            d6 = (d8 - 1.0E-6d) * d5;
        } else {
            double d12 = d4 - d5;
            d6 = ((z ? d5 : d5 + d5) * d4) / d12;
            d7 = (z ? d5 : d5 + d4) / d12;
        }
        double d13 = this.m20;
        double d14 = (d13 * d7) - this.m30;
        double d15 = this.m21;
        double d16 = d14;
        double d17 = (d15 * d7) - this.m31;
        double d18 = this.m22;
        double d19 = d18;
        double d20 = (d18 * d7) - this.m32;
        double d21 = this.m23;
        double d22 = d21;
        double d23 = (d7 * d21) - this.m33;
        matrix4d2.m00 = this.m00 * d9;
        matrix4d2.m01 = this.m01 * d9;
        matrix4d2.m02 = this.m02 * d9;
        matrix4d2.m03 = this.m03 * d9;
        matrix4d2.m10 = this.m10 * d10;
        matrix4d2.m11 = this.m11 * d10;
        matrix4d2.m12 = this.m12 * d10;
        matrix4d2.m13 = this.m13 * d10;
        matrix4d2.m30 = d13 * d6;
        matrix4d2.m31 = d15 * d6;
        matrix4d2.m32 = d19 * d6;
        matrix4d2.m33 = d22 * d6;
        matrix4d2.m20 = d16;
        matrix4d2.m21 = d17;
        matrix4d2.m22 = d20;
        matrix4d2.m23 = d23;
        matrix4d2.properties = this.properties & -31;
        return matrix4d2;
    }

    private Matrix4d perspectiveLHGeneric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        double d6;
        double d7;
        Matrix4d matrix4d2 = matrix4d;
        double tan = Math.tan(0.5d * d2);
        double d8 = 1.0d;
        double d9 = 1.0d / (tan * d3);
        double d10 = 1.0d / tan;
        double d11 = 0.0d;
        boolean z2 = true;
        boolean z3 = d5 > 0.0d && Double.isInfinite(d5);
        if (d4 <= 0.0d || !Double.isInfinite(d4)) {
            z2 = false;
        }
        if (z3) {
            d7 = 0.999999d;
            if (!z) {
                d8 = 2.0d;
            }
            d6 = (1.0E-6d - d8) * d4;
        } else if (z2) {
            if (!z) {
                d11 = 1.0d;
            }
            d7 = d11 - 1.0E-6d;
            if (!z) {
                d8 = 2.0d;
            }
            d6 = (d8 - 1.0E-6d) * d5;
        } else {
            d7 = (z ? d5 : d5 + d4) / (d5 - d4);
            d6 = ((z ? d5 : d5 + d5) * d4) / (d4 - d5);
        }
        double d12 = this.m20;
        double d13 = (d12 * d7) + this.m30;
        double d14 = this.m21;
        double d15 = d13;
        double d16 = (d14 * d7) + this.m31;
        double d17 = this.m22;
        double d18 = d17;
        double d19 = (d17 * d7) + this.m32;
        double d20 = this.m23;
        double d21 = d20;
        double d22 = (d7 * d20) + this.m33;
        matrix4d2.m00 = this.m00 * d9;
        matrix4d2.m01 = this.m01 * d9;
        matrix4d2.m02 = this.m02 * d9;
        matrix4d2.m03 = this.m03 * d9;
        matrix4d2.m10 = this.m10 * d10;
        matrix4d2.m11 = this.m11 * d10;
        matrix4d2.m12 = this.m12 * d10;
        matrix4d2.m13 = this.m13 * d10;
        matrix4d2.m30 = d12 * d6;
        matrix4d2.m31 = d14 * d6;
        matrix4d2.m32 = d18 * d6;
        matrix4d2.m33 = d21 * d6;
        matrix4d2.m20 = d15;
        matrix4d2.m21 = d16;
        matrix4d2.m22 = d19;
        matrix4d2.m23 = d22;
        matrix4d2.properties = this.properties & -31;
        return matrix4d2;
    }

    public static void projViewFromRectangle(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector3d vector3d4, double d2, boolean z, Matrix4d matrix4d, Matrix4d matrix4d2) {
        double d3;
        double d4;
        Vector3d vector3d5 = vector3d;
        Vector3d vector3d6 = vector3d2;
        Vector3d vector3d7 = vector3d3;
        Vector3d vector3d8 = vector3d4;
        Matrix4d matrix4d3 = matrix4d2;
        double d5 = vector3d8.y;
        double d6 = vector3d7.z;
        double d7 = d5 * d6;
        double d8 = vector3d8.z;
        double d9 = vector3d7.y;
        double d10 = d7 - (d8 * d9);
        double d11 = vector3d7.x;
        double d12 = d8 * d11;
        double d13 = vector3d8.x;
        double d14 = d12 - (d6 * d13);
        double d15 = (d13 * d9) - (d5 * d11);
        Vector3d vector3d9 = vector3d2;
        Vector3d vector3d10 = vector3d;
        double h2 = a.h(vector3d9.z, vector3d10.z, d15, a.h(vector3d9.y, vector3d10.y, d14, (vector3d9.x - vector3d10.x) * d10));
        double d16 = h2 >= 0.0d ? 1.0d : -1.0d;
        double d17 = d10 * d16;
        double d18 = d14 * d16;
        double d19 = d15 * d16;
        double d20 = h2 * d16;
        double d21 = vector3d10.x;
        double d22 = d21;
        double d23 = vector3d10.y;
        double d24 = d23;
        double d25 = vector3d10.z;
        Vector3d vector3d11 = vector3d9;
        double d26 = d19;
        Matrix4d matrix4d4 = matrix4d3;
        matrix4d2.setLookAt(d22, d24, d25, d21 + d17, d23 + d18, d25 + d19, vector3d8.x, vector3d8.y, vector3d8.z);
        double d27 = matrix4d4.m00;
        double d28 = vector3d11.x;
        double d29 = d27 * d28;
        double d30 = matrix4d4.m10;
        double d31 = vector3d11.y;
        double d32 = (d30 * d31) + d29;
        double d33 = matrix4d4.m20;
        double d34 = vector3d11.z;
        double d35 = (d33 * d34) + d32 + matrix4d4.m30;
        double d36 = matrix4d4.m01;
        double d37 = d28 * d36;
        double d38 = d36;
        double d39 = matrix4d4.m11;
        double d40 = (d31 * d39) + d37;
        double d41 = matrix4d4.m21;
        double d42 = (d34 * d41) + d40 + matrix4d4.m31;
        Vector3d vector3d12 = vector3d3;
        double d43 = (d33 * vector3d12.z) + (d30 * vector3d12.y) + (d27 * vector3d12.x);
        double d44 = (d41 * vector3d8.z) + (d39 * vector3d8.y) + (vector3d8.x * d38);
        double e2 = a.e(d26, d26, (d18 * d18) + (d17 * d17), d20);
        if (Double.isInfinite(d2) && d2 < 0.0d) {
            d3 = e2;
            d4 = Double.POSITIVE_INFINITY;
        } else if (Double.isInfinite(d2) && d2 > 0.0d) {
            d4 = e2;
            d3 = Double.POSITIVE_INFINITY;
        } else if (d2 < 0.0d) {
            d3 = e2;
            d4 = e2 + d2;
        } else {
            d4 = e2;
            d3 = e2 + d2;
        }
        matrix4d.setFrustum(d35, d35 + d43, d42, d42 + d44, d4, d3, z);
    }

    private Matrix4d reflectAffine(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d34 = d13;
        matrix4d2.m30 = d33 + this.m30;
        double d35 = this.m01;
        double d36 = d35 * d22;
        double d37 = d35;
        double d38 = this.m11;
        double d39 = (d38 * d23) + d36;
        double d40 = d38;
        double d41 = this.m21;
        double d42 = (d41 * d24) + d39;
        double d43 = d41;
        matrix4d2.m31 = d42 + this.m31;
        double d44 = this.m02;
        double d45 = d22 * d44;
        double d46 = d44;
        double d47 = this.m12;
        double d48 = (d23 * d47) + d45;
        double d49 = d47;
        double d50 = this.m22;
        double d51 = (d24 * d50) + d48;
        double d52 = d50;
        matrix4d2.m32 = d51 + this.m32;
        matrix4d2.m33 = this.m33;
        double d53 = (d32 * d34) + (d29 * d12) + (d26 * d10);
        double d54 = (d43 * d34) + (d40 * d12) + (d37 * d10);
        double d55 = (d52 * d34) + (d12 * d49) + (d10 * d46);
        double d56 = (d32 * d17) + (d29 * d31) + (d26 * d15);
        double d57 = (d43 * d17) + (d40 * d31) + (d37 * d15);
        double d58 = (d52 * d17) + (d31 * d49) + (d15 * d46);
        double d59 = d32 * d25;
        matrix4d2.m20 = d59 + (d29 * d28) + (d26 * d19);
        matrix4d2.m21 = (d43 * d25) + (d40 * d28) + (d37 * d19);
        matrix4d2.m22 = (d52 * d25) + (d49 * d28) + (d46 * d19);
        matrix4d2.m23 = 0.0d;
        matrix4d2.m00 = d53;
        matrix4d2.m01 = d54;
        matrix4d2.m02 = d55;
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = d56;
        matrix4d2.m11 = d57;
        matrix4d2.m12 = d58;
        matrix4d2.m13 = 0.0d;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d reflectGeneric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d34 = d13;
        matrix4d2.m30 = d33 + this.m30;
        double d35 = this.m01;
        double d36 = d35 * d22;
        double d37 = d35;
        double d38 = this.m11;
        double d39 = (d38 * d23) + d36;
        double d40 = d38;
        double d41 = this.m21;
        double d42 = (d41 * d24) + d39;
        double d43 = d41;
        matrix4d2.m31 = d42 + this.m31;
        double d44 = this.m02;
        double d45 = d44 * d22;
        double d46 = d44;
        double d47 = this.m12;
        double d48 = (d47 * d23) + d45;
        double d49 = d47;
        double d50 = this.m22;
        double d51 = (d50 * d24) + d48;
        double d52 = d50;
        matrix4d2.m32 = d51 + this.m32;
        double d53 = this.m03;
        double d54 = d22 * d53;
        double d55 = d53;
        double d56 = this.m13;
        double d57 = (d23 * d56) + d54;
        double d58 = d56;
        double d59 = this.m23;
        double d60 = (d24 * d59) + d57;
        double d61 = d59;
        matrix4d2.m33 = d60 + this.m33;
        double d62 = (d32 * d34) + (d29 * d12) + (d26 * d10);
        double d63 = (d43 * d34) + (d40 * d12) + (d37 * d10);
        double d64 = (d52 * d34) + (d49 * d12) + (d46 * d10);
        double d65 = (d61 * d34) + (d12 * d58) + (d10 * d55);
        double d66 = (d32 * d17) + (d29 * d31) + (d26 * d15);
        double d67 = (d43 * d17) + (d40 * d31) + (d37 * d15);
        double d68 = (d49 * d31) + (d46 * d15);
        double d69 = d67;
        double d70 = (d31 * d58) + (d15 * d55);
        double d71 = d61 * d17;
        double d72 = (d52 * d17) + d68;
        double d73 = d71 + d70;
        double d74 = d32 * d25;
        matrix4d2.m20 = d74 + (d29 * d28) + (d26 * d19);
        matrix4d2.m21 = (d43 * d25) + (d40 * d28) + (d37 * d19);
        matrix4d2.m22 = (d52 * d25) + (d49 * d28) + (d46 * d19);
        matrix4d2.m23 = (d61 * d25) + (d58 * d28) + (d55 * d19);
        matrix4d2.m00 = d62;
        matrix4d2.m01 = d63;
        matrix4d2.m02 = d64;
        matrix4d2.m03 = d65;
        matrix4d2.m10 = d66;
        matrix4d2.m11 = d69;
        matrix4d2.m12 = d72;
        matrix4d2.m13 = d73;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d rotateAroundGeneric(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d6 = a2;
        double b4 = a.b(w, x, z, y);
        double d7 = d5 + d6;
        double d8 = b2 - a3;
        double d9 = (-d6) + d5;
        double f2 = a.f(y, z, w, x);
        double d10 = b3 + a4;
        double d11 = a3 + b2;
        double d12 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d13 = this.m00;
        double d14 = d13 * d2;
        double d15 = this.m10;
        double d16 = (d15 * d3) + d14;
        double d17 = this.m20;
        double d18 = (d17 * d4) + d16 + this.m30;
        double d19 = this.m01;
        double d20 = d19 * d2;
        double d21 = d18;
        double d22 = this.m11;
        double d23 = (d22 * d3) + d20;
        double d24 = g2;
        double d25 = this.m21;
        double d26 = (d25 * d4) + d23;
        double d27 = d9;
        double d28 = d26 + this.m31;
        double d29 = this.m02;
        double d30 = d29 * d2;
        double d31 = d29;
        double d32 = this.m12;
        double d33 = (d32 * d3) + d30;
        double d34 = d32;
        double d35 = this.m22;
        double d36 = (d35 * d4) + d33;
        double d37 = d35;
        double d38 = d36 + this.m32;
        double d39 = (d17 * d8) + (d15 * d7) + (d13 * b4);
        double d40 = (d25 * d8) + (d22 * d7) + (d19 * b4);
        double d41 = d40;
        double d42 = (d37 * d8) + (d34 * d7) + (d31 * b4);
        double d43 = this.m03;
        double d44 = b4 * d43;
        double d45 = d43;
        double d46 = this.m13;
        double d47 = (d7 * d46) + d44;
        double d48 = d46;
        double d49 = this.m23;
        double d50 = (d8 * d49) + d47;
        double d51 = d50;
        double d52 = (d17 * d10) + (d15 * f2) + (d13 * d27);
        double d53 = d25 * d10;
        double d54 = d53 + (d22 * f2) + (d19 * d27);
        double d55 = (d37 * d10) + (d34 * f2) + (d31 * d27);
        double d56 = (d49 * d10) + (f2 * d48) + (d45 * d27);
        double d57 = d17 * d24;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3._m20(d57 + (d15 * d12) + (d13 * d11));
        double d58 = d51;
        double d59 = d56;
        matrix4d3._m21((this.m21 * d24) + (this.m11 * d12) + (this.m01 * d11));
        matrix4d3._m22((this.m22 * d24) + (this.m12 * d12) + (this.m02 * d11));
        matrix4d3._m23((this.m23 * d24) + (this.m13 * d12) + (this.m03 * d11));
        double d60 = d39;
        matrix4d3._m00(d60);
        matrix4d3._m01(d41);
        double d61 = d42;
        matrix4d3._m02(d61);
        matrix4d3._m03(d58);
        matrix4d3._m10(d52);
        matrix4d3._m11(d54);
        matrix4d3._m12(d55);
        matrix4d3._m13(d59);
        matrix4d3._m30(((((-d60) * d2) - (d52 * d3)) - (this.m20 * d4)) + d21);
        matrix4d3._m31(((((-d41) * d2) - (d54 * d3)) - (this.m21 * d4)) + d28);
        matrix4d3._m32(((((-d61) * d2) - (d55 * d3)) - (this.m22 * d4)) + d38);
        matrix4d3._m33(this.m33);
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    private Matrix4d rotateGeneric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d39 = d38 * d7;
        double d40 = d38;
        double d41 = this.m12;
        double d42 = (d41 * d10) + d39;
        double d43 = d41;
        double d44 = this.m22;
        double d45 = d44;
        double d46 = (d44 * d13) + d42;
        double d47 = this.m03;
        double d48 = d7 * d47;
        double d49 = d47;
        double d50 = this.m13;
        double d51 = (d10 * d50) + d48;
        double d52 = this.m23;
        double d53 = (d13 * d52) + d51;
        double d54 = d53;
        double d55 = (d26 * d18) + (d24 * d15) + (d22 * d14);
        double d56 = d55;
        double d57 = (d36 * d18) + (d34 * d15) + (d31 * d14);
        double d58 = d57;
        double d59 = (d45 * d18) + (d43 * d15) + (d40 * d14);
        double d60 = d18 * d52;
        double d61 = d60 + (d15 * d50) + (d14 * d49);
        double d62 = d26 * d21;
        double d63 = d62 + (d24 * d20) + (d22 * d27);
        Matrix4d matrix4d3 = matrix4d;
        double d64 = d54;
        matrix4d3.m20 = d63;
        matrix4d3.m21 = (d36 * d21) + (d34 * d20) + (d31 * d27);
        matrix4d3.m22 = (d45 * d21) + (d43 * d20) + (d40 * d27);
        double d65 = d52 * d21;
        matrix4d3.m23 = d65 + (d50 * d20) + (d49 * d27);
        matrix4d3.m00 = d28;
        matrix4d3.m01 = d37;
        matrix4d3.m02 = d46;
        matrix4d3.m03 = d64;
        matrix4d3.m10 = d56;
        matrix4d3.m11 = d58;
        matrix4d3.m12 = d59;
        matrix4d3.m13 = d61;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    private Matrix4d rotateLocalGeneric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d32 = this.m03;
        double d33 = this.m10;
        double d34 = d7 * d33;
        double d35 = d32;
        double d36 = this.m11;
        double d37 = (d14 * d36) + d34;
        double d38 = d31;
        double d39 = this.m12;
        double d40 = d29;
        double d41 = (d27 * d39) + d37;
        double d42 = d41;
        double d43 = (d20 * d39) + (d15 * d36) + (d10 * d33);
        double d44 = d39 * d21;
        double d45 = d44 + (d36 * d18) + (d33 * d13);
        double d46 = this.m13;
        double d47 = this.m20;
        double d48 = d7 * d47;
        double d49 = d46;
        double d50 = this.m21;
        double d51 = (d14 * d50) + d48;
        double d52 = d45;
        double d53 = this.m22;
        double d54 = d43;
        double d55 = (d27 * d53) + d51;
        double d56 = (d20 * d53) + (d15 * d50) + (d10 * d47);
        double d57 = d53 * d21;
        double d58 = d57 + (d50 * d18) + (d47 * d13);
        double d59 = this.m23;
        double d60 = this.m30;
        double d61 = d7 * d60;
        double d62 = d59;
        double d63 = this.m31;
        double d64 = (d14 * d63) + d61;
        double d65 = this.m32;
        double d66 = (d27 * d65) + d64;
        double d67 = d20 * d65;
        double d68 = d67 + (d15 * d63) + (d10 * d60);
        double d69 = d21 * d65;
        double d70 = d69 + (d18 * d63) + (d13 * d60);
        double d71 = this.m33;
        matrix4d2.m00 = d28;
        matrix4d2.m01 = d40;
        matrix4d2.m02 = d38;
        matrix4d2.m03 = d35;
        matrix4d2.m10 = d42;
        matrix4d2.m11 = d54;
        matrix4d2.m12 = d52;
        matrix4d2.m13 = d49;
        matrix4d2.m20 = d55;
        matrix4d2.m21 = d56;
        matrix4d2.m22 = d58;
        matrix4d2.m23 = d62;
        matrix4d2.m30 = d66;
        matrix4d2.m31 = d68;
        matrix4d2.m32 = d70;
        matrix4d2.m33 = d71;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    private Matrix4d scaleGeneric(double d2, double d3, double d4, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00 * d2;
        matrix4d.m01 = this.m01 * d2;
        matrix4d.m02 = this.m02 * d2;
        matrix4d.m03 = this.m03 * d2;
        matrix4d.m10 = this.m10 * d3;
        matrix4d.m11 = this.m11 * d3;
        matrix4d.m12 = this.m12 * d3;
        matrix4d.m13 = this.m13 * d3;
        matrix4d.m20 = this.m20 * d4;
        matrix4d.m21 = this.m21 * d4;
        matrix4d.m22 = this.m22 * d4;
        matrix4d.m23 = this.m23 * d4;
        matrix4d.m30 = this.m30;
        matrix4d.m31 = this.m31;
        matrix4d.m32 = this.m32;
        matrix4d.m33 = this.m33;
        int i2 = 0;
        boolean z = Math.abs(d2) == 1.0d && Math.abs(d3) == 1.0d && Math.abs(d4) == 1.0d;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4d.properties = (~(i2 | 13)) & i3;
        return matrix4d;
    }

    private Matrix4d scaleLocalGeneric(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d5 = this.m00 * d2;
        double d6 = this.m01 * d3;
        double d7 = this.m02 * d4;
        double d8 = this.m03;
        double d9 = this.m10 * d2;
        double d10 = this.m11 * d3;
        double d11 = this.m12 * d4;
        double d12 = this.m13;
        double d13 = this.m20 * d2;
        double d14 = this.m21 * d3;
        double d15 = this.m22 * d4;
        double d16 = this.m23;
        double d17 = this.m30 * d2;
        double d18 = this.m31 * d3;
        double d19 = this.m32 * d4;
        double d20 = this.m33;
        matrix4d2.m00 = d5;
        matrix4d2.m01 = d6;
        matrix4d2.m02 = d7;
        matrix4d2.m03 = d8;
        matrix4d2.m10 = d9;
        matrix4d2.m11 = d10;
        matrix4d2.m12 = d11;
        matrix4d2.m13 = d12;
        matrix4d2.m20 = d13;
        matrix4d2.m21 = d14;
        matrix4d2.m22 = d15;
        matrix4d2.m23 = d16;
        matrix4d2.m30 = d17;
        matrix4d2.m31 = d18;
        matrix4d2.m32 = d19;
        matrix4d2.m33 = d20;
        int i2 = 0;
        boolean z = Math.abs(d2) == 1.0d && Math.abs(d3) == 1.0d && Math.abs(d4) == 1.0d;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4d2.properties = (~(i2 | 13)) & i3;
        return matrix4d2;
    }

    private Matrix4d translateGeneric(double d2, double d3, double d4, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00;
        matrix4d.m01 = this.m01;
        matrix4d.m02 = this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = this.m10;
        matrix4d.m11 = this.m11;
        matrix4d.m12 = this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = this.m20;
        matrix4d.m21 = this.m21;
        matrix4d.m22 = this.m22;
        matrix4d.m23 = this.m23;
        matrix4d.m30 = (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30;
        matrix4d.m31 = (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31;
        matrix4d.m32 = (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32;
        matrix4d.m33 = (this.m23 * d4) + (this.m13 * d3) + (this.m03 * d2) + this.m33;
        matrix4d.properties = this.properties & -6;
        return matrix4d;
    }

    private Matrix4d translateLocalGeneric(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d5 = this.m00;
        double d6 = this.m03;
        double d7 = (d2 * d6) + d5;
        double d8 = (d3 * d6) + this.m01;
        double d9 = (d4 * d6) + this.m02;
        double d10 = this.m10;
        double d11 = this.m13;
        double d12 = (d2 * d11) + d10;
        double d13 = (d3 * d11) + this.m11;
        double d14 = (d4 * d11) + this.m12;
        double d15 = d11;
        double d16 = this.m20;
        double d17 = d14;
        double d18 = this.m23;
        double d19 = (d2 * d18) + d16;
        double d20 = (d3 * d18) + this.m21;
        double d21 = (d4 * d18) + this.m22;
        double d22 = d18;
        double d23 = this.m30;
        double d24 = d21;
        double d25 = this.m33;
        double d26 = (d2 * d25) + d23;
        double d27 = (d3 * d25) + this.m31;
        double d28 = (d4 * d25) + this.m32;
        matrix4d2.m00 = d7;
        matrix4d2.m01 = d8;
        matrix4d2.m02 = d9;
        matrix4d2.m03 = d6;
        matrix4d2.m10 = d12;
        matrix4d2.m11 = d13;
        matrix4d2.m12 = d17;
        matrix4d2.m13 = d15;
        matrix4d2.m20 = d19;
        matrix4d2.m21 = d20;
        matrix4d2.m22 = d24;
        matrix4d2.m23 = d22;
        matrix4d2.m30 = d26;
        matrix4d2.m31 = d27;
        matrix4d2.m32 = d28;
        matrix4d2.m33 = d25;
        matrix4d2.properties = this.properties & -6;
        return matrix4d2;
    }

    private Matrix4d transposeGeneric(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = this.m00;
        double d3 = this.m10;
        double d4 = this.m20;
        double d5 = this.m30;
        double d6 = this.m01;
        double d7 = this.m11;
        double d8 = this.m21;
        double d9 = this.m31;
        double d10 = this.m02;
        double d11 = this.m12;
        double d12 = this.m22;
        double d13 = this.m32;
        double d14 = this.m03;
        double d15 = this.m13;
        double d16 = this.m23;
        double d17 = this.m33;
        matrix4d2.m00 = d2;
        matrix4d2.m01 = d3;
        matrix4d2.m02 = d4;
        matrix4d2.m03 = d5;
        matrix4d2.m10 = d6;
        matrix4d2.m11 = d7;
        matrix4d2.m12 = d8;
        matrix4d2.m13 = d9;
        matrix4d2.m20 = d10;
        matrix4d2.m21 = d11;
        matrix4d2.m22 = d12;
        matrix4d2.m23 = d13;
        matrix4d2.m30 = d14;
        matrix4d2.m31 = d15;
        matrix4d2.m32 = d16;
        matrix4d2.m33 = d17;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    public Matrix4d _m00(double d2) {
        this.m00 = d2;
        return this;
    }

    public Matrix4d _m01(double d2) {
        this.m01 = d2;
        return this;
    }

    public Matrix4d _m02(double d2) {
        this.m02 = d2;
        return this;
    }

    public Matrix4d _m03(double d2) {
        this.m03 = d2;
        return this;
    }

    public Matrix4d _m10(double d2) {
        this.m10 = d2;
        return this;
    }

    public Matrix4d _m11(double d2) {
        this.m11 = d2;
        return this;
    }

    public Matrix4d _m12(double d2) {
        this.m12 = d2;
        return this;
    }

    public Matrix4d _m13(double d2) {
        this.m13 = d2;
        return this;
    }

    public Matrix4d _m20(double d2) {
        this.m20 = d2;
        return this;
    }

    public Matrix4d _m21(double d2) {
        this.m21 = d2;
        return this;
    }

    public Matrix4d _m22(double d2) {
        this.m22 = d2;
        return this;
    }

    public Matrix4d _m23(double d2) {
        this.m23 = d2;
        return this;
    }

    public Matrix4d _m30(double d2) {
        this.m30 = d2;
        return this;
    }

    public Matrix4d _m31(double d2) {
        this.m31 = d2;
        return this;
    }

    public Matrix4d _m32(double d2) {
        this.m32 = d2;
        return this;
    }

    public Matrix4d _m33(double d2) {
        this.m33 = d2;
        return this;
    }

    public Matrix4d add(Matrix4dc matrix4dc) {
        return add(matrix4dc, this);
    }

    public Matrix4d add4x3(Matrix4dc matrix4dc) {
        return add4x3(matrix4dc, this);
    }

    public Matrix4d affineSpan(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector3d vector3d4) {
        Vector3d vector3d5 = vector3d;
        Vector3d vector3d6 = vector3d2;
        Vector3d vector3d7 = vector3d3;
        Vector3d vector3d8 = vector3d4;
        double d2 = this.m10;
        double d3 = this.m22;
        double d4 = d2 * d3;
        double d5 = this.m21;
        double d6 = d2 * d5;
        double d7 = this.m02;
        double d8 = d2 * d7;
        double d9 = this.m01;
        double d10 = d2 * d9;
        double d11 = this.m11;
        double d12 = d11 * d3;
        double d13 = d4;
        double d14 = this.m20;
        double d15 = d11 * d14;
        double d16 = d11 * d7;
        double d17 = d2;
        double d18 = this.m00;
        double d19 = d11 * d18;
        double d20 = d11;
        double d21 = this.m12;
        double d22 = d21 * d5;
        double d23 = d21 * d14;
        double d24 = d21 * d9;
        double d25 = d21 * d18;
        double d26 = d14 * d7;
        double d27 = d14 * d9;
        double d28 = d5 * d7;
        double d29 = d5 * d18;
        double d30 = d3 * d9;
        double d31 = d3 * d18;
        double d32 = (1.0d / ((d18 * d20) - (d9 * d17))) * d3;
        double d33 = d17 * d7;
        double d34 = d7;
        double d35 = d9 * d21;
        double d36 = d34;
        double d37 = d14;
        double a2 = a.a(d36, d20, d35, d37, a.a(d18, d21, d33, d5, d32));
        double d38 = (d12 - d22) * a2;
        double d39 = (d28 - d30) * a2;
        double d40 = (d24 - d16) * a2;
        double d41 = (d23 - d13) * a2;
        double d42 = (d31 - d26) * a2;
        double d43 = (d6 - d15) * a2;
        double d44 = (d27 - d29) * a2;
        double d45 = (d19 - d10) * a2;
        double d46 = (d8 - d25) * a2;
        double d47 = ((-d38) - d41) - d43;
        double d48 = this.m31;
        double d49 = d13 * d48;
        double d50 = d43;
        double d51 = this.m32;
        double d52 = (d15 * d51) + (d49 - (d6 * d51));
        double d53 = d41;
        double d54 = this.m30;
        double d55 = d48;
        double d56 = d38;
        Vector3d vector3d9 = vector3d;
        vector3d9.x = a.a(d23, d55, (d22 * d54) + (d52 - (d12 * d54)), a2, d47);
        double d57 = d30 * d54;
        double d58 = d48;
        vector3d9.y = a.a(d31, d58, d57 + (((d29 * d51) + ((d26 * d48) - (d27 * d51))) - (d28 * d54)), a2, ((-d39) - d42) - d44);
        double d59 = d10 * d51;
        double d60 = d19;
        double d61 = d51;
        vector3d9.z = a.a(d60, d61, d59 + (((d25 * d48) + ((d16 * d54) - (d24 * d54))) - (d8 * d48)), a2, ((-d40) - d46) - d45);
        Vector3d vector3d10 = vector3d2;
        vector3d10.x = d56 * 2.0d;
        vector3d10.y = d39 * 2.0d;
        vector3d10.z = d40 * 2.0d;
        Vector3d vector3d11 = vector3d3;
        vector3d11.x = d53 * 2.0d;
        vector3d11.y = d42 * 2.0d;
        vector3d11.z = d46 * 2.0d;
        Vector3d vector3d12 = vector3d4;
        vector3d12.x = d50 * 2.0d;
        vector3d12.y = d44 * 2.0d;
        vector3d12.z = 2.0d * d45;
        return this;
    }

    public Matrix4d arcball(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d8 = -d2;
        double d9 = (this.m20 * d8) + this.m30;
        double d10 = (this.m21 * d8) + this.m31;
        double d11 = (this.m22 * d8) + this.m32;
        double d12 = (this.m23 * d8) + this.m33;
        double sin = Math.sin(d6);
        double cosFromSin = Math.cosFromSin(sin, d6);
        double d13 = this.m10;
        double d14 = d13 * cosFromSin;
        double d15 = this.m20;
        double d16 = (d15 * sin) + d14;
        double d17 = d12;
        double d18 = this.m11;
        double d19 = d18 * cosFromSin;
        double d20 = d9;
        double d21 = this.m21;
        double d22 = d16;
        double d23 = (d21 * sin) + d19;
        double d24 = this.m12;
        double d25 = d24 * cosFromSin;
        double d26 = d24;
        double d27 = this.m22;
        double d28 = d27;
        double d29 = (d27 * sin) + d25;
        double d30 = this.m13;
        double d31 = d30 * cosFromSin;
        double d32 = d30;
        double d33 = this.m23;
        double d34 = (d33 * sin) + d31;
        double d35 = (d15 * cosFromSin) - (d13 * sin);
        double d36 = (d21 * cosFromSin) - (d18 * sin);
        double d37 = (d28 * cosFromSin) - (d26 * sin);
        double d38 = (cosFromSin * d33) - (d32 * sin);
        double sin2 = Math.sin(d7);
        double cosFromSin2 = Math.cosFromSin(sin2, d7);
        double d39 = d34;
        double d40 = this.m00;
        double d41 = d35;
        double d42 = (d40 * cosFromSin2) - (d35 * sin2);
        double d43 = this.m01;
        double d44 = d36;
        double d45 = (d43 * cosFromSin2) - (d36 * sin2);
        double d46 = this.m02;
        double d47 = d37;
        double d48 = (d46 * cosFromSin2) - (d37 * sin2);
        double d49 = this.m03;
        double d50 = d38;
        double d51 = (d49 * cosFromSin2) - (d38 * sin2);
        double d52 = (d41 * cosFromSin2) + (d40 * sin2);
        double d53 = (d44 * cosFromSin2) + (d43 * sin2);
        double d54 = (d47 * cosFromSin2) + (d46 * sin2);
        double d55 = (d50 * cosFromSin2) + (d49 * sin2);
        double d56 = d42;
        double d57 = d52;
        double d58 = d23;
        double d59 = d29;
        double d60 = d39;
        double d61 = d55;
        double d62 = d53;
        double d63 = d56;
        double d64 = d60;
        double d65 = d54;
        double d66 = d45;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m30 = a.m(d52, d5, ((-d56) * d3) - (d22 * d4), d20);
        matrix4d3.m31 = a.m(d62, d5, ((-d66) * d3) - (d58 * d4), d10);
        double d67 = d48;
        matrix4d3.m32 = a.m(d65, d5, ((-d67) * d3) - (d59 * d4), d11);
        double d68 = d51;
        double d69 = d67;
        matrix4d3.m33 = a.m(d61, d5, ((-d51) * d3) - (d64 * d4), d17);
        matrix4d3.m20 = d57;
        matrix4d3.m21 = d62;
        matrix4d3.m22 = d65;
        matrix4d3.m23 = d61;
        matrix4d3.m10 = d22;
        matrix4d3.m11 = d58;
        matrix4d3.m12 = d59;
        matrix4d3.m13 = d64;
        matrix4d3.m00 = d63;
        matrix4d3.m01 = d66;
        matrix4d3.m02 = d69;
        matrix4d3.m03 = d68;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d assume(int i2) {
        this.properties = (byte) i2;
        return this;
    }

    public Matrix4d billboardCylindrical(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
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
        double e3 = a.e(y3, y3, (x3 * x3) + (z3 * z3), 1.0d);
        double d7 = z3 * e3;
        double d8 = x3 * e3;
        double d9 = y3 * e3;
        this.m00 = d4;
        this.m01 = d5;
        this.m02 = d6;
        this.m03 = 0.0d;
        this.m10 = vector3dc3.x();
        this.m11 = vector3dc3.y();
        this.m12 = vector3dc3.z();
        this.m13 = 0.0d;
        this.m20 = d7;
        this.m21 = d8;
        this.m22 = d9;
        this.m23 = 0.0d;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d billboardSpherical(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
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
        this.m03 = 0.0d;
        this.m10 = d8;
        this.m11 = d10;
        this.m12 = d12;
        this.m13 = 0.0d;
        this.m20 = d2;
        this.m21 = d11;
        this.m22 = d9;
        this.m23 = 0.0d;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public double determinant() {
        if ((this.properties & 2) != 0) {
            return determinantAffine();
        }
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = d2 * d3;
        double d5 = this.m01;
        double d6 = this.m10;
        double d7 = d4 - (d5 * d6);
        double d8 = this.m22;
        double d9 = this.m33;
        double d10 = d8 * d9;
        double d11 = this.m23;
        double d12 = d3;
        double d13 = this.m32;
        double d14 = d11;
        double c2 = a.c(d11, d13, d10, d7);
        double d15 = this.m02;
        double d16 = d15 * d6;
        double d17 = d15;
        double d18 = this.m12;
        double d19 = d16 - (d2 * d18);
        double d20 = d5;
        double d21 = this.m21;
        double d22 = d21 * d9;
        double d23 = d9;
        double d24 = this.m31;
        double d25 = d24;
        double a2 = a.a(d14, d25, d22, d19, c2);
        double d26 = d18;
        double d27 = this.m13;
        double d28 = d2 * d27;
        double d29 = d27;
        double d30 = this.m03;
        double d31 = d8;
        double a3 = a.a(d31, d25, d21 * d13, d28 - (d6 * d30), a2);
        double d32 = (d20 * d26) - (d17 * d12);
        double d33 = this.m20;
        double d34 = d23 * d33;
        double d35 = this.m30;
        double d36 = d35;
        double a4 = a.a(d14, d36, d34, d32, a3);
        double d37 = (d17 * d29) - (d30 * d26);
        return a.a(d21, d35, d33 * d24, d37, a.a(d8, d36, d13 * d33, (d30 * d12) - (d20 * d29), a4));
    }

    public double determinant3x3() {
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

    public double determinantAffine() {
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

    public Matrix4d determineProperties() {
        int i2;
        if (this.m03 == 0.0d && this.m13 == 0.0d) {
            if (this.m23 == 0.0d && this.m33 == 1.0d) {
                i2 = 2;
                if (this.m00 == 1.0d && this.m01 == 0.0d && this.m02 == 0.0d && this.m10 == 0.0d && this.m11 == 1.0d && this.m12 == 0.0d && this.m20 == 0.0d && this.m21 == 0.0d && this.m22 == 1.0d) {
                    i2 = 26;
                    if (this.m30 == 0.0d && this.m31 == 0.0d && this.m32 == 0.0d) {
                        i2 = 30;
                    }
                }
                this.properties = i2;
                return this;
            } else if (this.m01 == 0.0d && this.m02 == 0.0d && this.m10 == 0.0d && this.m12 == 0.0d && this.m20 == 0.0d && this.m21 == 0.0d && this.m30 == 0.0d && this.m31 == 0.0d && this.m33 == 0.0d) {
                i2 = 1;
                this.properties = i2;
                return this;
            }
        }
        i2 = 0;
        this.properties = i2;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Matrix4d)) {
            return false;
        }
        Matrix4d matrix4d = (Matrix4d) obj;
        return Double.doubleToLongBits(this.m00) == Double.doubleToLongBits(matrix4d.m00) && Double.doubleToLongBits(this.m01) == Double.doubleToLongBits(matrix4d.m01) && Double.doubleToLongBits(this.m02) == Double.doubleToLongBits(matrix4d.m02) && Double.doubleToLongBits(this.m03) == Double.doubleToLongBits(matrix4d.m03) && Double.doubleToLongBits(this.m10) == Double.doubleToLongBits(matrix4d.m10) && Double.doubleToLongBits(this.m11) == Double.doubleToLongBits(matrix4d.m11) && Double.doubleToLongBits(this.m12) == Double.doubleToLongBits(matrix4d.m12) && Double.doubleToLongBits(this.m13) == Double.doubleToLongBits(matrix4d.m13) && Double.doubleToLongBits(this.m20) == Double.doubleToLongBits(matrix4d.m20) && Double.doubleToLongBits(this.m21) == Double.doubleToLongBits(matrix4d.m21) && Double.doubleToLongBits(this.m22) == Double.doubleToLongBits(matrix4d.m22) && Double.doubleToLongBits(this.m23) == Double.doubleToLongBits(matrix4d.m23) && Double.doubleToLongBits(this.m30) == Double.doubleToLongBits(matrix4d.m30) && Double.doubleToLongBits(this.m31) == Double.doubleToLongBits(matrix4d.m31) && Double.doubleToLongBits(this.m32) == Double.doubleToLongBits(matrix4d.m32) && Double.doubleToLongBits(this.m33) == Double.doubleToLongBits(matrix4d.m33);
    }

    public Matrix4d fma4x3(Matrix4dc matrix4dc, double d2) {
        return fma4x3(matrix4dc, d2, this);
    }

    public Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setFrustum(d2, d3, d4, d5, d6, d7, z);
        }
        return frustumGeneric(d2, d3, d4, d5, d6, d7, z, matrix4d);
    }

    public Matrix4d frustumAabb(Vector3d vector3d, Vector3d vector3d2) {
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d2 = Double.NEGATIVE_INFINITY;
        double d3 = Double.POSITIVE_INFINITY;
        double d4 = Double.POSITIVE_INFINITY;
        double d5 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        double d6 = Double.NEGATIVE_INFINITY;
        double d7 = Double.NEGATIVE_INFINITY;
        while (i2 < 8) {
            double d8 = ((double) ((i2 & 1) << 1)) - 1.0d;
            double d9 = d7;
            double d10 = ((double) (((i2 >>> 1) & 1) << 1)) - 1.0d;
            int i3 = i2;
            double d11 = d6;
            double d12 = ((double) (((i2 >>> 2) & 1) << 1)) - 1.0d;
            double d13 = d2;
            double d14 = d5;
            double d15 = 1.0d / (((this.m23 * d12) + ((this.m13 * d10) + (this.m03 * d8))) + this.m33);
            d2 = ((this.m20 * d12) + (this.m10 * d10) + (this.m00 * d8) + this.m30) * d15;
            double d16 = d4;
            double d17 = ((this.m21 * d12) + (this.m11 * d10) + (this.m01 * d8) + this.m31) * d15;
            d7 = ((this.m22 * d12) + (this.m12 * d10) + (this.m02 * d8) + this.m32) * d15;
            if (d3 >= d2) {
                d3 = d2;
            }
            d4 = d16 < d17 ? d16 : d17;
            if (d14 >= d7) {
                d14 = d7;
            }
            if (d13 > d2) {
                d2 = d13;
            }
            d6 = d11 > d17 ? d11 : d17;
            if (d9 > d7) {
                d7 = d9;
            }
            i2 = i3 + 1;
            vector3d3 = vector3d;
            d5 = d14;
        }
        double d18 = d2;
        double d19 = d6;
        double d20 = d7;
        double d21 = d4;
        double d22 = d5;
        vector3d3.x = d3;
        vector3d3.y = d21;
        vector3d3.z = d22;
        Vector3d vector3d5 = vector3d2;
        vector3d5.x = d2;
        vector3d5.y = d19;
        vector3d5.z = d20;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x01f4, code lost:
        r14 = r14 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x01f5, code lost:
        r4 = r14;
        r14 = r22;
        r22 = r18;
        r0 = (r14 * r10) - (r24 * r6);
        r30 = r4;
        r32 = (r24 * r2) - (r20 * r10);
        r4 = (r20 * r6) - (r14 * r2);
        r28 = (r6 * r12) - (r10 * r8);
        r10 = (r10 * r16) - (r2 * r12);
        r2 = (r2 * r8) - (r6 * r16);
        r6 = (r8 * r24) - (r12 * r14);
        r24 = (r12 * r20) - (r24 * r16);
        r34 = (r14 * r16) - (r20 * r8);
        r14 = r4;
        r8 = e.a.a.a.a.l(r12, r14, (r8 * r32) + (r16 * r0), 1.0d);
        r14 = r6;
        r16 = r30;
        r20 = r8;
        r6 = r38;
        r6.x = e.a.a.a.a.c(r14, r16, ((-r0) * r22) - (r28 * r26), r20);
        r6.y = e.a.a.a.a.c(r24, r16, ((-r32) * r22) - (r10 * r26), r20);
        r6.z = e.a.a.a.a.c(r34, r16, ((-r4) * r22) - (r2 * r26), r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0273, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0100, code lost:
        r14 = r14 - r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.arashivision.insbase.joml.Vector3d frustumCorner(int r37, com.arashivision.insbase.joml.Vector3d r38) {
        /*
            r36 = this;
            r0 = r36
            r1 = r38
            switch(r37) {
                case 0: goto L_0x01bd;
                case 1: goto L_0x0181;
                case 2: goto L_0x0140;
                case 3: goto L_0x0103;
                case 4: goto L_0x00c5;
                case 5: goto L_0x008d;
                case 6: goto L_0x0050;
                case 7: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "corner"
            r0.<init>(r1)
            throw r0
        L_0x000f:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r2 - r4
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r6 - r8
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r10 - r12
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r14 - r4
            r18 = r4
            double r4 = r0.m01
            double r4 = r2 - r4
            r20 = r4
            double r4 = r0.m11
            double r4 = r6 - r4
            r22 = r4
            double r4 = r0.m21
            double r4 = r10 - r4
            r24 = r4
            double r4 = r0.m31
            double r4 = r14 - r4
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 - r4
            double r4 = r0.m12
            double r6 = r6 - r4
            double r4 = r0.m22
            double r10 = r10 - r4
            double r4 = r0.m32
            goto L_0x0100
        L_0x0050:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r4 + r2
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r8 + r6
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r12 + r10
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r4 + r14
            r18 = r4
            double r4 = r0.m01
            double r4 = r2 - r4
            r20 = r4
            double r4 = r0.m11
            double r4 = r6 - r4
            r22 = r4
            double r4 = r0.m21
            double r4 = r10 - r4
            r24 = r4
            double r4 = r0.m31
            double r4 = r14 - r4
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 - r4
            double r4 = r0.m12
            double r6 = r6 - r4
            double r4 = r0.m22
            double r10 = r10 - r4
            double r4 = r0.m32
            goto L_0x0100
        L_0x008d:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r4 + r2
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r8 + r6
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r12 + r10
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r4 + r14
            r18 = r4
            double r4 = r0.m01
            double r4 = r4 + r2
            r20 = r4
            double r4 = r0.m11
            double r4 = r4 + r6
            r22 = r4
            double r4 = r0.m21
            double r4 = r4 + r10
            r24 = r4
            double r4 = r0.m31
            double r4 = r4 + r14
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 - r4
            double r4 = r0.m12
            double r6 = r6 - r4
            double r4 = r0.m22
            double r10 = r10 - r4
            double r4 = r0.m32
            goto L_0x0100
        L_0x00c5:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r2 - r4
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r6 - r8
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r10 - r12
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r14 - r4
            r18 = r4
            double r4 = r0.m01
            double r4 = r4 + r2
            r20 = r4
            double r4 = r0.m11
            double r4 = r4 + r6
            r22 = r4
            double r4 = r0.m21
            double r4 = r4 + r10
            r24 = r4
            double r4 = r0.m31
            double r4 = r4 + r14
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 - r4
            double r4 = r0.m12
            double r6 = r6 - r4
            double r4 = r0.m22
            double r10 = r10 - r4
            double r4 = r0.m32
        L_0x0100:
            double r14 = r14 - r4
            goto L_0x01f5
        L_0x0103:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r4 + r2
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r8 + r6
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r12 + r10
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r4 + r14
            r18 = r4
            double r4 = r0.m01
            double r4 = r2 - r4
            r20 = r4
            double r4 = r0.m11
            double r4 = r6 - r4
            r22 = r4
            double r4 = r0.m21
            double r4 = r10 - r4
            r24 = r4
            double r4 = r0.m31
            double r4 = r14 - r4
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 + r4
            double r4 = r0.m12
            double r6 = r6 + r4
            double r4 = r0.m22
            double r10 = r10 + r4
            double r4 = r0.m32
            goto L_0x01f4
        L_0x0140:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r2 - r4
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r6 - r8
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r10 - r12
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r14 - r4
            r18 = r4
            double r4 = r0.m01
            double r4 = r2 - r4
            r20 = r4
            double r4 = r0.m11
            double r4 = r6 - r4
            r22 = r4
            double r4 = r0.m21
            double r4 = r10 - r4
            r24 = r4
            double r4 = r0.m31
            double r4 = r14 - r4
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 + r4
            double r4 = r0.m12
            double r6 = r6 + r4
            double r4 = r0.m22
            double r10 = r10 + r4
            double r4 = r0.m32
            goto L_0x01f4
        L_0x0181:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r2 - r4
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r6 - r8
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r10 - r12
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r14 - r4
            r18 = r4
            double r4 = r0.m01
            double r4 = r4 + r2
            r20 = r4
            double r4 = r0.m11
            double r4 = r4 + r6
            r22 = r4
            double r4 = r0.m21
            double r4 = r4 + r10
            r24 = r4
            double r4 = r0.m31
            double r4 = r4 + r14
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 + r4
            double r4 = r0.m12
            double r6 = r6 + r4
            double r4 = r0.m22
            double r10 = r10 + r4
            double r4 = r0.m32
            goto L_0x01f4
        L_0x01bd:
            double r2 = r0.m03
            double r4 = r0.m00
            double r4 = r4 + r2
            double r6 = r0.m13
            double r8 = r0.m10
            double r8 = r8 + r6
            double r10 = r0.m23
            double r12 = r0.m20
            double r12 = r12 + r10
            double r14 = r0.m33
            r16 = r4
            double r4 = r0.m30
            double r4 = r4 + r14
            r18 = r4
            double r4 = r0.m01
            double r4 = r4 + r2
            r20 = r4
            double r4 = r0.m11
            double r4 = r4 + r6
            r22 = r4
            double r4 = r0.m21
            double r4 = r4 + r10
            r24 = r4
            double r4 = r0.m31
            double r4 = r4 + r14
            r26 = r4
            double r4 = r0.m02
            double r2 = r2 + r4
            double r4 = r0.m12
            double r6 = r6 + r4
            double r4 = r0.m22
            double r10 = r10 + r4
            double r4 = r0.m32
        L_0x01f4:
            double r14 = r14 + r4
        L_0x01f5:
            r4 = r14
            r14 = r22
            r22 = r18
            double r18 = r14 * r10
            double r28 = r24 * r6
            double r0 = r18 - r28
            double r18 = r24 * r2
            double r28 = r20 * r10
            r30 = r4
            double r4 = r18 - r28
            double r18 = r20 * r6
            double r28 = r14 * r2
            r32 = r4
            double r4 = r18 - r28
            double r18 = r6 * r12
            double r28 = r10 * r8
            double r28 = r18 - r28
            double r10 = r10 * r16
            double r18 = r2 * r12
            double r10 = r10 - r18
            double r2 = r2 * r8
            double r6 = r6 * r16
            double r2 = r2 - r6
            double r6 = r8 * r24
            double r18 = r12 * r14
            double r6 = r6 - r18
            double r18 = r12 * r20
            double r24 = r24 * r16
            double r24 = r18 - r24
            double r14 = r14 * r16
            double r20 = r20 * r8
            double r34 = r14 - r20
            r18 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r16 = r16 * r0
            double r8 = r8 * r32
            double r16 = r8 + r16
            r14 = r4
            double r8 = e.a.a.a.a.l(r12, r14, r16, r18)
            double r0 = -r0
            double r0 = r0 * r22
            double r28 = r28 * r26
            double r18 = r0 - r28
            r14 = r6
            r16 = r30
            r20 = r8
            double r0 = e.a.a.a.a.c(r14, r16, r18, r20)
            r6 = r38
            r6.x = r0
            r0 = r32
            double r0 = -r0
            double r0 = r0 * r22
            double r10 = r10 * r26
            double r18 = r0 - r10
            r14 = r24
            double r0 = e.a.a.a.a.c(r14, r16, r18, r20)
            r6.y = r0
            double r0 = -r4
            double r0 = r0 * r22
            double r2 = r2 * r26
            double r18 = r0 - r2
            r14 = r34
            double r0 = e.a.a.a.a.c(r14, r16, r18, r20)
            r6.z = r0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Matrix4d.frustumCorner(int, com.arashivision.insbase.joml.Vector3d):com.arashivision.insbase.joml.Vector3d");
    }

    public Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setFrustumLH(d2, d3, d4, d5, d6, d7, z);
        }
        return frustumLHGeneric(d2, d3, d4, d5, d6, d7, z, matrix4d);
    }

    public Vector4d frustumPlane(int i2, Vector4d vector4d) {
        if (i2 == 0) {
            vector4d.set(this.m03 + this.m00, this.m13 + this.m10, this.m23 + this.m20, this.m33 + this.m30).normalize3(vector4d);
        } else if (i2 == 1) {
            vector4d.set(this.m03 - this.m00, this.m13 - this.m10, this.m23 - this.m20, this.m33 - this.m30).normalize3(vector4d);
        } else if (i2 == 2) {
            vector4d.set(this.m03 + this.m01, this.m13 + this.m11, this.m23 + this.m21, this.m33 + this.m31).normalize3(vector4d);
        } else if (i2 == 3) {
            vector4d.set(this.m03 - this.m01, this.m13 - this.m11, this.m23 - this.m21, this.m33 - this.m31).normalize3(vector4d);
        } else if (i2 == 4) {
            vector4d.set(this.m03 + this.m02, this.m13 + this.m12, this.m23 + this.m22, this.m33 + this.m32).normalize3(vector4d);
        } else if (i2 == 5) {
            vector4d.set(this.m03 - this.m02, this.m13 - this.m12, this.m23 - this.m22, this.m33 - this.m32).normalize3(vector4d);
        } else {
            throw new IllegalArgumentException("plane");
        }
        return vector4d;
    }

    public Vector3d frustumRayDir(double d2, double d3, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d4 = this.m10;
        double d5 = this.m23;
        double d6 = d4 * d5;
        double d7 = this.m13;
        double d8 = this.m21;
        double d9 = d7 * d8;
        double d10 = d4 * d8;
        double d11 = this.m11;
        double d12 = d11 * d5;
        double d13 = d9;
        double d14 = this.m20;
        double d15 = d7 * d14;
        double d16 = d11 * d14;
        double d17 = d6;
        double d18 = this.m03;
        double d19 = d18 * d14;
        double d20 = d4;
        double d21 = this.m01;
        double d22 = d21 * d5;
        double d23 = d18 * d8;
        double d24 = d14 * d21;
        double d25 = this.m00;
        double d26 = d5 * d25;
        double d27 = d8 * d25;
        double d28 = d25 * d7;
        double d29 = d18 * d11;
        double d30 = d25 * d11;
        double d31 = d7 * d21;
        double d32 = d18 * d20;
        double d33 = d21 * d20;
        double d34 = 1.0d - d3;
        double d35 = ((((((d17 - d13) - d10) + d12) - d15) + d16) * d3) + ((((((d12 + d15) + d16) - d17) - d13) - d10) * d34);
        double d36 = ((((((d19 - d22) - d24) + d23) - d26) + d27) * d3) + ((((((d23 + d26) + d27) - d19) - d22) - d24) * d34);
        double d37 = ((((((d28 - d29) - d30) + d31) - d32) + d33) * d3) + ((((((d31 + d32) + d33) - d28) - d29) - d30) * d34);
        double d38 = ((((((d19 + d22) - d24) - d23) - d26) + d27) * d3) + ((((((d22 - d24) - d23) + d26) + d27) - d19) * d34);
        double d39 = ((((((d28 + d29) - d30) - d31) - d32) + d33) * d3) + ((((((d29 - d30) - d31) + d32) + d33) - d28) * d34);
        double d40 = 1.0d - d2;
        Vector3d vector3d3 = vector3d;
        vector3d3.x = ((((((((d17 + d13) - d10) - d12) - d15) + d16) * d3) + ((((((d13 - d10) - d12) + d15) + d16) - d17) * d34)) * d2) + (d35 * d40);
        vector3d3.y = (d38 * d2) + (d36 * d40);
        vector3d3.z = (d39 * d2) + (d37 * d40);
        return vector3d3.normalize(vector3d3);
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set((Matrix4dc) this);
    }

    public Matrix3d get3x3(Matrix3d matrix3d) {
        return matrix3d.set((Matrix4dc) this);
    }

    public Matrix4x3d get4x3(Matrix4x3d matrix4x3d) {
        return matrix4x3d.set((Matrix4dc) this);
    }

    public DoubleBuffer get4x3Transposed(DoubleBuffer doubleBuffer) {
        return get4x3Transposed(doubleBuffer.position(), doubleBuffer);
    }

    public Vector4d getColumn(int i2, Vector4d vector4d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector4d.x = this.m00;
            vector4d.y = this.m01;
            vector4d.z = this.m02;
            vector4d.w = this.m03;
        } else if (i2 == 1) {
            vector4d.x = this.m10;
            vector4d.y = this.m11;
            vector4d.z = this.m12;
            vector4d.w = this.m13;
        } else if (i2 == 2) {
            vector4d.x = this.m20;
            vector4d.y = this.m21;
            vector4d.z = this.m22;
            vector4d.w = this.m23;
        } else if (i2 == 3) {
            vector4d.x = this.m30;
            vector4d.y = this.m31;
            vector4d.z = this.m32;
            vector4d.w = this.m33;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector4d;
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
        return quaternionf.setFromNormalized((Matrix4dc) this);
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
        } else if (i2 == 3) {
            vector4d.x = this.m03;
            vector4d.y = this.m13;
            vector4d.z = this.m23;
            vector4d.w = this.m33;
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

    public Quaternionf getUnnormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromUnnormalized((Matrix4dc) this);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.m00);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.m01);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.m02);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.m03);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.m10);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.m11);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.m12);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.m13);
        int i9 = (i8 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.m20);
        int i10 = (i9 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
        long doubleToLongBits10 = Double.doubleToLongBits(this.m21);
        int i11 = (i10 * 31) + ((int) (doubleToLongBits10 ^ (doubleToLongBits10 >>> 32)));
        long doubleToLongBits11 = Double.doubleToLongBits(this.m22);
        int i12 = (i11 * 31) + ((int) (doubleToLongBits11 ^ (doubleToLongBits11 >>> 32)));
        long doubleToLongBits12 = Double.doubleToLongBits(this.m23);
        int i13 = (i12 * 31) + ((int) (doubleToLongBits12 ^ (doubleToLongBits12 >>> 32)));
        long doubleToLongBits13 = Double.doubleToLongBits(this.m30);
        int i14 = (i13 * 31) + ((int) (doubleToLongBits13 ^ (doubleToLongBits13 >>> 32)));
        long doubleToLongBits14 = Double.doubleToLongBits(this.m31);
        int i15 = (i14 * 31) + ((int) (doubleToLongBits14 ^ (doubleToLongBits14 >>> 32)));
        long doubleToLongBits15 = Double.doubleToLongBits(this.m32);
        int i16 = (i15 * 31) + ((int) (doubleToLongBits15 ^ (doubleToLongBits15 >>> 32)));
        long doubleToLongBits16 = Double.doubleToLongBits(this.m33);
        return (i16 * 31) + ((int) ((doubleToLongBits16 >>> 32) ^ doubleToLongBits16));
    }

    public Matrix4d identity() {
        if ((this.properties & 4) != 0) {
            return this;
        }
        _identity();
        this.properties = 30;
        return this;
    }

    public Matrix4d invert() {
        return invert(this);
    }

    public Matrix4d invertAffine(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = d46;
        matrix4d3.m01 = d47;
        matrix4d3.m02 = d39;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = d40;
        matrix4d3.m11 = d41;
        matrix4d3.m12 = d42;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m20 = d43;
        matrix4d3.m21 = d44;
        matrix4d3.m22 = d45;
        matrix4d3.m23 = 0.0d;
        matrix4d3.m30 = c2;
        matrix4d3.m31 = c3;
        matrix4d3.m32 = c4;
        matrix4d3.m33 = 1.0d;
        matrix4d3.properties = 2;
        return matrix4d3;
    }

    public Matrix4d invertFrustum(Matrix4d matrix4d) {
        double d2 = 1.0d / this.m00;
        double d3 = 1.0d / this.m11;
        double d4 = 1.0d / this.m23;
        double d5 = 1.0d / this.m32;
        matrix4d.set(d2, 0.0d, 0.0d, 0.0d, 0.0d, d3, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, d5, (-this.m20) * d2 * d4, (-this.m21) * d3 * d4, d4, (-this.m22) * d4 * d5);
        return matrix4d;
    }

    public Matrix4d invertOrtho(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = 1.0d / this.m00;
        double d3 = 1.0d / this.m11;
        double d4 = 1.0d / this.m22;
        matrix4d.set(d2, 0.0d, 0.0d, 0.0d, 0.0d, d3, 0.0d, 0.0d, 0.0d, 0.0d, d4, 0.0d, (-this.m30) * d2, (-this.m31) * d3, (-this.m32) * d4, 1.0d);
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.properties = (this.properties & 16) | 2;
        return matrix4d3;
    }

    public Matrix4d invertPerspective(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = 1.0d / (d2 * d3);
        double d5 = this.m23;
        double d6 = this.m32;
        double d7 = -1.0d / (d5 * d6);
        matrix4d2.set(d3 * d4, 0.0d, 0.0d, 0.0d, 0.0d, d2 * d4, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, (-d5) * d7, 0.0d, 0.0d, (-d6) * d7, this.m22 * d7);
        return matrix4d;
    }

    public Matrix4d invertPerspectiveView(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = 1.0d / (d2 * d3);
        double d5 = this.m23;
        double d6 = this.m32;
        double d7 = -1.0d / (d5 * d6);
        double d8 = d3 * d4;
        double d9 = d2 * d4;
        double d10 = (-d5) * d7;
        double d11 = (-d6) * d7;
        double d12 = this.m22 * d7;
        double m302 = ((matrix4dc.m30() * (-matrix4dc.m00())) - (matrix4dc.m31() * matrix4dc.m01())) - (matrix4dc.m32() * matrix4dc.m02());
        double m303 = ((matrix4dc.m30() * (-matrix4dc.m10())) - (matrix4dc.m31() * matrix4dc.m11())) - (matrix4dc.m32() * matrix4dc.m12());
        double m304 = ((matrix4dc.m30() * (-matrix4dc.m20())) - (matrix4dc.m31() * matrix4dc.m21())) - (matrix4dc.m32() * matrix4dc.m22());
        double m002 = matrix4dc.m00() * d8;
        double m102 = matrix4dc.m10() * d8;
        double m202 = d8 * matrix4dc.m20();
        double d13 = m102;
        double m012 = matrix4dc.m01() * d9;
        double m112 = matrix4dc.m11() * d9;
        double m212 = d9 * matrix4dc.m21();
        double d14 = m302 * d10;
        double d15 = m303 * d10;
        double d16 = m304 * d10;
        double m022 = (m302 * d12) + (matrix4dc.m02() * d11);
        double m122 = (m303 * d12) + (matrix4dc.m12() * d11);
        double m222 = (m304 * d12) + (matrix4dc.m22() * d11);
        double d17 = d12;
        double d18 = d13;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = m002;
        matrix4d3.m01 = d18;
        matrix4d3.m02 = m202;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = m012;
        matrix4d3.m11 = m112;
        matrix4d3.m12 = m212;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m20 = d14;
        matrix4d3.m21 = d15;
        matrix4d3.m22 = d16;
        matrix4d3.m23 = d10;
        matrix4d3.m30 = m022;
        matrix4d3.m31 = m122;
        matrix4d3.m32 = m222;
        matrix4d3.m33 = d17;
        matrix4d3.properties = 0;
        return matrix4d3;
    }

    public boolean isAffine() {
        return this.m03 == 0.0d && this.m13 == 0.0d && this.m23 == 0.0d && this.m33 == 1.0d;
    }

    public Matrix4d lerp(Matrix4dc matrix4dc, double d2) {
        return lerp(matrix4dc, d2, this);
    }

    public Matrix4d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Matrix4d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4d matrix4d) {
        return lookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), matrix4d);
    }

    public Matrix4d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Matrix4d matrix4d) {
        return lookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), matrix4d);
    }

    public Matrix4d lookAtPerspective(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d26 = (d21 * d3) + (d20 * d2);
        double d27 = d22;
        double d28 = (d24 * d3) + (d23 * d2);
        double d29 = -((d22 * d4) + d26);
        double d30 = -((d25 * d4) + d28);
        double d31 = -((d16 * d4) + (d15 * d3) + (d14 * d2));
        double d32 = this.m00;
        double d33 = d20 * d32;
        double d34 = this.m11;
        double d35 = d23 * d34;
        double d36 = this.m22;
        double d37 = d16;
        double d38 = d36 * d14;
        double d39 = this.m23;
        double d40 = d14 * d39;
        double d41 = d21 * d32;
        double d42 = d34 * d24;
        double d43 = d36 * d15;
        double d44 = d15 * d39;
        double d45 = d32 * d27;
        double d46 = d34 * d25;
        double d47 = d36 * d37;
        double d48 = d39 * d37;
        double d49 = d32 * d29;
        double d50 = d34 * d30;
        double d51 = (d36 * d31) + this.m32;
        double d52 = d39 * d31;
        matrix4d2.m00 = d33;
        matrix4d2.m01 = d35;
        matrix4d2.m02 = d38;
        matrix4d2.m03 = d40;
        matrix4d2.m10 = d41;
        matrix4d2.m11 = d42;
        matrix4d2.m12 = d43;
        matrix4d2.m13 = d44;
        matrix4d2.m20 = d45;
        matrix4d2.m21 = d46;
        matrix4d2.m22 = d47;
        matrix4d2.m23 = d48;
        matrix4d2.m30 = d49;
        matrix4d2.m31 = d50;
        matrix4d2.m32 = d51;
        matrix4d2.m33 = d52;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    public Matrix4d lookAtPerspectiveLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d26 = (d21 * d3) + (d20 * d2);
        double d27 = d22;
        double d28 = (d24 * d3) + (d23 * d2);
        double d29 = -((d22 * d4) + d26);
        double d30 = -((d25 * d4) + d28);
        double d31 = -((d16 * d4) + (d15 * d3) + (d14 * d2));
        double d32 = this.m00;
        double d33 = d20 * d32;
        double d34 = this.m11;
        double d35 = d23 * d34;
        double d36 = this.m22;
        double d37 = d16;
        double d38 = d36 * d14;
        double d39 = this.m23;
        double d40 = d14 * d39;
        double d41 = d21 * d32;
        double d42 = d34 * d24;
        double d43 = d36 * d15;
        double d44 = d15 * d39;
        double d45 = d32 * d27;
        double d46 = d34 * d25;
        double d47 = d36 * d37;
        double d48 = d39 * d37;
        double d49 = d32 * d29;
        double d50 = d34 * d30;
        double d51 = (d36 * d31) + this.m32;
        double d52 = d39 * d31;
        matrix4d2.m00 = d33;
        matrix4d2.m01 = d35;
        matrix4d2.m02 = d38;
        matrix4d2.m03 = d40;
        matrix4d2.m10 = d41;
        matrix4d2.m11 = d42;
        matrix4d2.m12 = d43;
        matrix4d2.m13 = d44;
        matrix4d2.m20 = d45;
        matrix4d2.m21 = d46;
        matrix4d2.m22 = d47;
        matrix4d2.m23 = d48;
        matrix4d2.m30 = d49;
        matrix4d2.m31 = d50;
        matrix4d2.m32 = d51;
        matrix4d2.m33 = d52;
        matrix4d2.properties = 0;
        return matrix4d2;
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

    public double m03() {
        return this.m03;
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

    public double m13() {
        return this.m13;
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

    public double m23() {
        return this.m23;
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

    public double m33() {
        return this.m33;
    }

    public Matrix4d mul(Matrix4dc matrix4dc) {
        return mul(matrix4dc, this);
    }

    public Matrix4d mul4x3ComponentWise(Matrix4dc matrix4dc) {
        return mul4x3ComponentWise(matrix4dc, this);
    }

    public Matrix4d mulAffine(Matrix4dc matrix4dc) {
        return mulAffine(matrix4dc, this);
    }

    public Matrix4d mulAffineR(Matrix4dc matrix4dc) {
        return mulAffineR(matrix4dc, this);
    }

    public Matrix4d mulComponentWise(Matrix4dc matrix4dc) {
        return mulComponentWise(matrix4dc, this);
    }

    public Matrix4d mulLocal(Matrix4dc matrix4dc) {
        return mulLocal(matrix4dc, this);
    }

    public Matrix4d mulLocalAffine(Matrix4dc matrix4dc) {
        return mulLocalAffine(matrix4dc, this);
    }

    public Matrix4d mulOrthoAffine(Matrix4dc matrix4dc) {
        return mulOrthoAffine(matrix4dc, this);
    }

    public Matrix4d mulPerspectiveAffine(Matrix4dc matrix4dc) {
        return mulPerspectiveAffine(matrix4dc, this);
    }

    public Matrix4d mulTranslationAffine(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m002 = matrix4dc.m00();
        double m012 = matrix4dc.m01();
        double m022 = matrix4dc.m02();
        double d2 = this.m03;
        double m102 = matrix4dc.m10();
        double m112 = matrix4dc.m11();
        double m122 = matrix4dc.m12();
        double d3 = this.m13;
        double m202 = matrix4dc.m20();
        double m212 = matrix4dc.m21();
        double m222 = matrix4dc.m22();
        double d4 = this.m23;
        double m302 = matrix4dc.m30() + this.m30;
        double m312 = matrix4dc.m31() + this.m31;
        double m322 = matrix4dc.m32() + this.m32;
        double d5 = this.m33;
        matrix4d2.m00 = m002;
        matrix4d2.m01 = m012;
        matrix4d2.m02 = m022;
        matrix4d2.m03 = d2;
        matrix4d2.m10 = m102;
        matrix4d2.m11 = m112;
        matrix4d2.m12 = m122;
        matrix4d2.m13 = d3;
        matrix4d2.m20 = m202;
        matrix4d2.m21 = m212;
        matrix4d2.m22 = m222;
        matrix4d2.m23 = d4;
        matrix4d2.m30 = m302;
        matrix4d2.m31 = m312;
        matrix4d2.m32 = m322;
        matrix4d2.m33 = d5;
        matrix4d2.properties = (matrix4dc.properties() & 16) | 2;
        return matrix4d2;
    }

    public Matrix4d normal() {
        return normal(this);
    }

    public Matrix4d normalize3x3() {
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

    public Matrix4d obliqueZ(double d2, double d3) {
        this.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        this.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        this.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        this.properties &= 2;
        return this;
    }

    public Vector3d origin(Vector3d vector3d) {
        if ((this.properties & 2) != 0) {
            return originAffine(vector3d);
        }
        return originGeneric(vector3d);
    }

    public Vector3d originAffine(Vector3d vector3d) {
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

    public Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrtho(d2, d3, d4, d5, d6, d7, z);
        }
        return orthoGeneric(d2, d3, d4, d5, d6, d7, z, matrix4d);
    }

    public Matrix4d ortho2D(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrtho2D(d2, d3, d4, d5);
        }
        return ortho2DGeneric(d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d ortho2DLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrtho2DLH(d2, d3, d4, d5);
        }
        return ortho2DLHGeneric(d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d orthoCrop(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        double d2 = Double.NEGATIVE_INFINITY;
        double d3 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        double d4 = Double.NEGATIVE_INFINITY;
        double d5 = Double.NEGATIVE_INFINITY;
        double d6 = Double.POSITIVE_INFINITY;
        double d7 = Double.POSITIVE_INFINITY;
        while (i2 < 8) {
            double d8 = d2;
            double d9 = ((double) ((i2 & 1) << 1)) - 1.0d;
            double d10 = d3;
            double d11 = ((double) (((i2 >>> 1) & 1) << 1)) - 1.0d;
            int i3 = i2;
            double d12 = ((double) (((i2 >>> 2) & 1) << 1)) - 1.0d;
            double d13 = d5;
            double d14 = d7;
            double d15 = 1.0d / (((this.m23 * d12) + ((this.m13 * d11) + (this.m03 * d9))) + this.m33);
            double d16 = d4;
            double d17 = ((this.m20 * d12) + (this.m10 * d11) + (this.m00 * d9) + this.m30) * d15;
            double d18 = d6;
            double d19 = ((this.m21 * d12) + (this.m11 * d11) + (this.m01 * d9) + this.m31) * d15;
            double d20 = ((this.m22 * d12) + (this.m12 * d11) + (this.m02 * d9) + this.m32) * d15;
            double m302 = matrix4dc.m30() + (matrix4dc.m20() * d20) + (matrix4dc.m10() * d19) + (matrix4dc.m00() * d17);
            double m312 = matrix4dc.m31() + (matrix4dc.m21() * d20) + (matrix4dc.m11() * d19) + (matrix4dc.m01() * d17);
            double m322 = (matrix4dc.m32() + (matrix4dc.m22() * d20) + (matrix4dc.m12() * d19) + (matrix4dc.m02() * d17)) * (1.0d / (matrix4dc.m33() + ((matrix4dc.m23() * d20) + ((matrix4dc.m13() * d19) + (matrix4dc.m03() * d17)))));
            if (d18 >= m302) {
                d18 = m302;
            }
            d4 = d16 > m302 ? d16 : m302;
            d7 = d14 < m312 ? d14 : m312;
            d5 = d13 > m312 ? d13 : m312;
            if (d10 >= m322) {
                d10 = m322;
            }
            d2 = d8 > m322 ? d8 : m322;
            i2 = i3 + 1;
            d3 = d10;
            d6 = d18;
        }
        double d21 = d3;
        double d22 = d6;
        double d23 = d4;
        double d24 = d7;
        double d25 = d5;
        return matrix4d.setOrtho(d6, d4, d7, d5, -d2, -d3);
    }

    public Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrthoLH(d2, d3, d4, d5, d6, d7, z);
        }
        return orthoLHGeneric(d2, d3, d4, d5, d6, d7, z, matrix4d);
    }

    public Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrthoSymmetric(d2, d3, d4, d5, z);
        }
        return orthoSymmetricGeneric(d2, d3, d4, d5, z, matrix4d);
    }

    public Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setOrthoSymmetricLH(d2, d3, d4, d5, z);
        }
        return orthoSymmetricLHGeneric(d2, d3, d4, d5, z, matrix4d);
    }

    public Matrix4d perspective(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setPerspective(d2, d3, d4, d5, z);
        }
        return perspectiveGeneric(d2, d3, d4, d5, z, matrix4d);
    }

    public double perspectiveFar() {
        return this.m32 / (this.m22 - this.m23);
    }

    public double perspectiveFov() {
        double d2 = this.m03;
        double d3 = this.m01;
        double d4 = d2 + d3;
        double d5 = this.m13;
        double d6 = this.m11;
        double d7 = d5 + d6;
        double d8 = this.m23;
        double d9 = d7;
        double d10 = this.m21;
        double d11 = d8 + d10;
        double d12 = d3 - d2;
        double d13 = d6 - d5;
        double d14 = d10 - d8;
        double d15 = (d9 * d9) + (d4 * d4);
        return Math.acos(((d11 * d14) + ((d9 * d13) + (d4 * d12))) / (Math.sqrt((d11 * d11) + d15) * Math.sqrt((d14 * d14) + ((d13 * d13) + (d12 * d12)))));
    }

    public Matrix4d perspectiveFrustumSlice(double d2, double d3, Matrix4d matrix4d) {
        double d4 = this.m23;
        double d5 = (this.m22 + d4) / this.m32;
        double d6 = 1.0d / (d2 - d3);
        matrix4d.m00 = this.m00 * d5 * d2;
        matrix4d.m01 = this.m01;
        matrix4d.m02 = this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = this.m10;
        matrix4d.m11 = this.m11 * d5 * d2;
        matrix4d.m12 = this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = this.m20;
        matrix4d.m21 = this.m21;
        matrix4d.m22 = (d3 + d2) * d6;
        matrix4d.m23 = d4;
        matrix4d.m30 = this.m30;
        matrix4d.m31 = this.m31;
        matrix4d.m32 = (d3 + d3) * d2 * d6;
        matrix4d.m33 = this.m33;
        matrix4d.properties = this.properties & -29;
        return matrix4d;
    }

    public Matrix4d perspectiveLH(double d2, double d3, double d4, double d5, boolean z, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setPerspectiveLH(d2, d3, d4, d5, z);
        }
        return perspectiveLHGeneric(d2, d3, d4, d5, z, matrix4d);
    }

    public double perspectiveNear() {
        return this.m32 / (this.m23 + this.m22);
    }

    public Vector3d perspectiveOrigin(Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d2 = this.m03;
        double d3 = this.m00;
        double d4 = d2 + d3;
        double d5 = this.m13;
        double d6 = this.m10;
        double d7 = d5 + d6;
        double d8 = this.m23;
        double d9 = d4;
        double d10 = this.m20;
        double d11 = d8 + d10;
        double d12 = d7;
        double d13 = this.m33;
        double d14 = d10;
        double d15 = this.m30;
        double d16 = d13 + d15;
        double d17 = d2 - d3;
        double d18 = d5 - d6;
        double d19 = d8 - d14;
        double d20 = d13 - d15;
        double d21 = d2 - this.m01;
        double d22 = d5 - this.m11;
        double d23 = d8 - this.m21;
        double d24 = d13 - this.m31;
        double d25 = (d18 * d23) - (d19 * d22);
        double d26 = (d19 * d21) - (d17 * d23);
        double d27 = d24;
        double d28 = (d17 * d22) - (d18 * d21);
        double d29 = (d22 * d11) - (d23 * d12);
        double d30 = (d23 * d9) - (d21 * d11);
        double d31 = (d21 * d12) - (d22 * d9);
        double d32 = (d12 * d19) - (d11 * d18);
        double d33 = (d11 * d17) - (d19 * d9);
        double d34 = (d18 * d9) - (d17 * d12);
        double d35 = d28;
        double d36 = ((-d25) * d16) - (d29 * d20);
        double d37 = d27;
        double l = a.l(d11, d35, (d12 * d26) + (d9 * d25), 1.0d);
        double d38 = d26;
        Vector3d vector3d3 = vector3d;
        vector3d3.x = a.c(d32, d37, d36, l);
        vector3d3.y = a.c(d33, d37, ((-d38) * d16) - (d30 * d20), l);
        vector3d3.z = a.c(d34, d37, ((-d28) * d16) - (d31 * d20), l);
        return vector3d3;
    }

    public Matrix4d pick(double d2, double d3, double d4, double d5, int[] iArr, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d6 = ((double) iArr[2]) / d4;
        double d7 = ((double) iArr[3]) / d5;
        double d8 = (((((double) iArr[0]) - d2) * 2.0d) + ((double) iArr[2])) / d4;
        double d9 = (((((double) iArr[1]) - d3) * 2.0d) + ((double) iArr[3])) / d5;
        double d10 = this.m00;
        double d11 = d10 * d8;
        double d12 = d6;
        double d13 = this.m10;
        matrix4d2.m30 = (d13 * d9) + d11 + this.m30;
        double d14 = this.m01;
        double d15 = d14 * d8;
        double d16 = this.m11;
        double d17 = (d16 * d9) + d15;
        double d18 = d16;
        matrix4d2.m31 = d17 + this.m31;
        double d19 = this.m02;
        double d20 = d19 * d8;
        double d21 = d13;
        double d22 = this.m12;
        double d23 = (d22 * d9) + d20;
        double d24 = d22;
        matrix4d2.m32 = d23 + this.m32;
        double d25 = this.m03;
        double d26 = d8 * d25;
        double d27 = d7;
        double d28 = this.m13;
        matrix4d2.m33 = (d9 * d28) + d26 + this.m33;
        matrix4d2.m00 = d10 * d12;
        matrix4d2.m01 = d14 * d12;
        matrix4d2.m02 = d19 * d12;
        matrix4d2.m03 = d25 * d12;
        matrix4d2.m10 = d21 * d27;
        matrix4d2.m11 = d18 * d27;
        matrix4d2.m12 = d24 * d27;
        matrix4d2.m13 = d28 * d27;
        matrix4d2.properties = 0;
        return matrix4d2;
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

    public Vector4d project(double d2, double d3, double d4, int[] iArr, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d5 = 1.0d / (((this.m23 * d4) + ((this.m13 * d3) + (this.m03 * d2))) + this.m33);
        double d6 = ((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30) * d5;
        double d7 = ((this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31) * d5;
        double d8 = ((this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32) * d5;
        vector4d2.x = (((d6 * 0.5d) + 0.5d) * ((double) iArr[2])) + ((double) iArr[0]);
        vector4d2.y = (((d7 * 0.5d) + 0.5d) * ((double) iArr[3])) + ((double) iArr[1]);
        vector4d2.z = (d8 + 1.0d) * 0.5d;
        vector4d2.w = 1.0d;
        return vector4d2;
    }

    public Matrix4d projectedGridRange(Matrix4dc matrix4dc, double d2, double d3, Matrix4d matrix4d) {
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        Matrix4d matrix4d2 = matrix4d;
        double d10 = Double.NEGATIVE_INFINITY;
        double d11 = Double.NEGATIVE_INFINITY;
        double d12 = Double.POSITIVE_INFINITY;
        double d13 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        boolean z = false;
        while (i2 < 12) {
            if (i2 < 4) {
                d6 = ((double) ((i2 & 1) << 1)) - 1.0d;
                d5 = ((double) (((i2 >>> 1) & 1) << 1)) - 1.0d;
                d4 = d5;
                d7 = -1.0d;
                d8 = d6;
                d9 = 1.0d;
            } else if (i2 < 8) {
                d9 = ((double) ((i2 & 1) << 1)) - 1.0d;
                d7 = d9;
                d5 = ((double) (((i2 >>> 1) & 1) << 1)) - 1.0d;
                d4 = d5;
                d8 = 1.0d;
                d6 = -1.0d;
            } else {
                d9 = ((double) ((i2 & 1) << 1)) - 1.0d;
                d8 = ((double) (((i2 >>> 1) & 1) << 1)) - 1.0d;
                d7 = d9;
                d6 = d8;
                d4 = 1.0d;
                d5 = -1.0d;
            }
            double d14 = this.m03;
            double d15 = d14 * d7;
            double d16 = this.m13;
            double d17 = (d16 * d6) + d15;
            double d18 = d11;
            double d19 = this.m23;
            double d20 = (d19 * d5) + d17;
            double d21 = d10;
            double d22 = this.m33;
            double d23 = 1.0d / (d20 + d22);
            int i3 = i2;
            double d24 = this.m00;
            double d25 = d24 * d7;
            double d26 = d24;
            double d27 = this.m10;
            double d28 = (d27 * d6) + d25;
            double d29 = d27;
            double d30 = this.m20;
            double d31 = (d30 * d5) + d28;
            double d32 = d30;
            double d33 = this.m30;
            double d34 = (d31 + d33) * d23;
            double d35 = d33;
            double d36 = this.m01;
            double d37 = d36 * d7;
            double d38 = d36;
            double d39 = this.m11;
            double d40 = (d39 * d6) + d37;
            double d41 = d39;
            double d42 = this.m21;
            double d43 = (d42 * d5) + d40;
            double d44 = d42;
            double d45 = this.m31;
            double d46 = (d43 + d45) * d23;
            double d47 = d45;
            double d48 = this.m02;
            double d49 = d7 * d48;
            double d50 = d48;
            double d51 = this.m12;
            double d52 = (d6 * d51) + d49;
            double d53 = d51;
            double d54 = this.m22;
            double d55 = (d5 * d54) + d52;
            double d56 = d54;
            double d57 = this.m32;
            double d58 = (d55 + d57) * d23;
            double d59 = 1.0d / (((d19 * d4) + ((d16 * d8) + (d14 * d9))) + d22);
            double d60 = (d41 * d8) + (d38 * d9);
            double d61 = ((((d32 * d4) + ((d29 * d8) + (d26 * d9))) + d35) * d59) - d34;
            double d62 = ((((d56 * d4) + ((d8 * d53) + (d9 * d50))) + d57) * d59) - d58;
            double d63 = 1.0d / (((((d44 * d4) + d60) + d47) * d59) - d46);
            d11 = d18;
            int i4 = 0;
            while (i4 < 2) {
                double d64 = (-(d46 + (i4 == 0 ? d2 : d3))) * d63;
                if (d64 >= 0.0d && d64 <= 1.0d) {
                    double d65 = (d64 * d61) + d34;
                    double d66 = (d64 * d62) + d58;
                    double m332 = 1.0d / (matrix4dc.m33() + ((matrix4dc.m23() * d66) + (matrix4dc.m03() * d65)));
                    double m302 = (matrix4dc.m30() + (matrix4dc.m20() * d66) + (matrix4dc.m00() * d65)) * m332;
                    double m312 = (matrix4dc.m31() + (matrix4dc.m21() * d66) + (matrix4dc.m01() * d65)) * m332;
                    if (d12 >= m302) {
                        d12 = m302;
                    }
                    if (d13 >= m312) {
                        d13 = m312;
                    }
                    if (d21 <= m302) {
                        d21 = m302;
                    }
                    if (d11 <= m312) {
                        d11 = m312;
                    }
                    z = true;
                }
                i4++;
            }
            i2 = i3 + 1;
            Matrix4d matrix4d3 = matrix4d;
            d10 = d21;
        }
        double d67 = d10;
        double d68 = d11;
        if (!z) {
            return null;
        }
        Matrix4d matrix4d4 = matrix4d;
        matrix4d4.set(d67 - d12, 0.0d, 0.0d, 0.0d, 0.0d, d68 - d13, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, d12, d13, 0.0d, 1.0d);
        matrix4d4.properties = 2;
        return matrix4d4;
    }

    public int properties() {
        return this.properties;
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readDouble();
        this.m01 = objectInput.readDouble();
        this.m02 = objectInput.readDouble();
        this.m03 = objectInput.readDouble();
        this.m10 = objectInput.readDouble();
        this.m11 = objectInput.readDouble();
        this.m12 = objectInput.readDouble();
        this.m13 = objectInput.readDouble();
        this.m20 = objectInput.readDouble();
        this.m21 = objectInput.readDouble();
        this.m22 = objectInput.readDouble();
        this.m23 = objectInput.readDouble();
        this.m30 = objectInput.readDouble();
        this.m31 = objectInput.readDouble();
        this.m32 = objectInput.readDouble();
        this.m33 = objectInput.readDouble();
        this.properties = 0;
    }

    public Matrix4d reflect(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.reflection(d2, d3, d4, d5);
        }
        if ((i2 & 4) != 0) {
            return matrix4d.reflection(d2, d3, d4, d5);
        }
        if ((i2 & 2) != 0) {
            return reflectAffine(d2, d3, d4, d5, matrix4d);
        }
        return reflectGeneric(d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d reflection(double d2, double d3, double d4, double d5) {
        double d6 = d2 + d2;
        double d7 = d3 + d3;
        double d8 = d4 + d4;
        double d9 = d5 + d5;
        this.m00 = 1.0d - (d6 * d2);
        double d10 = -d6;
        this.m01 = d10 * d3;
        this.m02 = d10 * d4;
        this.m03 = 0.0d;
        double d11 = -d7;
        this.m10 = d11 * d2;
        this.m11 = 1.0d - (d7 * d3);
        this.m12 = d11 * d4;
        this.m13 = 0.0d;
        double d12 = -d8;
        this.m20 = d12 * d2;
        this.m21 = d12 * d3;
        this.m22 = 1.0d - (d8 * d4);
        this.m23 = 0.0d;
        double d13 = -d9;
        this.m30 = d13 * d2;
        this.m31 = d13 * d3;
        this.m32 = d13 * d4;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotate(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotation(d2, d3, d4, d5);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(d2, d3, d4, d5, matrix4d);
        }
        if ((i2 & 2) != 0) {
            return rotateAffine(d2, d3, d4, d5, matrix4d);
        }
        return rotateGeneric(d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d rotateAffine(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        double d53 = d45;
        matrix4d3.m20 = d52;
        matrix4d3.m21 = (d36 * d21) + (d34 * d20) + (d31 * d27);
        double d54 = d43 * d21;
        matrix4d3.m22 = d54 + (d41 * d20) + (d40 * d27);
        matrix4d3.m23 = 0.0d;
        matrix4d3.m00 = d28;
        matrix4d3.m01 = d37;
        matrix4d3.m02 = d53;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = d47;
        matrix4d3.m11 = d48;
        matrix4d3.m12 = d50;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateAffineXYZ(double d2, double d3, double d4) {
        return rotateAffineXYZ(d2, d3, d4, this);
    }

    public Matrix4d rotateAffineYXZ(double d2, double d3, double d4) {
        return rotateAffineYXZ(d2, d3, d4, this);
    }

    public Matrix4d rotateAffineZYX(double d2, double d3, double d4) {
        return rotateAffineZYX(d2, d3, d4, this);
    }

    public Matrix4d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4) {
        return rotateAround(quaterniondc, d2, d3, d4, this);
    }

    public Matrix4d rotateAroundAffine(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d6 = a2;
        double b4 = a.b(w, x, z, y);
        double d7 = d5 + d6;
        double d8 = b2 - a3;
        double d9 = (-d6) + d5;
        double f2 = a.f(y, z, w, x);
        double d10 = b3 + a4;
        double d11 = a3 + b2;
        double d12 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d13 = this.m00;
        double d14 = d13 * d2;
        double d15 = this.m10;
        double d16 = (d15 * d3) + d14;
        double d17 = this.m20;
        double d18 = (d17 * d4) + d16 + this.m30;
        double d19 = this.m01;
        double d20 = d19 * d2;
        double d21 = d18;
        double d22 = this.m11;
        double d23 = (d22 * d3) + d20;
        double d24 = g2;
        double d25 = this.m21;
        double d26 = (d25 * d4) + d23;
        double d27 = d9;
        double d28 = d26 + this.m31;
        double d29 = this.m02;
        double d30 = d29 * d2;
        double d31 = d29;
        double d32 = this.m12;
        double d33 = (d32 * d3) + d30;
        double d34 = d32;
        double d35 = this.m22;
        double d36 = (d35 * d4) + d33;
        double d37 = d35;
        double d38 = d36 + this.m32;
        double d39 = (d22 * d7) + (d19 * b4);
        double d40 = (d17 * d8) + (d15 * d7) + (d13 * b4);
        double d41 = (d7 * d34) + (b4 * d31);
        double d42 = d37 * d8;
        double d43 = (d25 * d8) + d39;
        double d44 = d42 + d41;
        double d45 = d44;
        double d46 = (d17 * d10) + (d15 * f2) + (d13 * d27);
        double d47 = d25 * d10;
        double d48 = d47 + (d22 * f2) + (d19 * d27);
        double d49 = (d37 * d10) + (d34 * f2) + (d31 * d27);
        double d50 = d17 * d24;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3._m20(d50 + (d15 * d12) + (d13 * d11));
        matrix4d3._m21((this.m21 * d24) + (this.m11 * d12) + (this.m01 * d11));
        matrix4d3._m22((this.m22 * d24) + (this.m12 * d12) + (this.m02 * d11));
        matrix4d3._m23(0.0d);
        double d51 = d40;
        matrix4d3._m00(d51);
        matrix4d3._m01(d43);
        double d52 = d45;
        matrix4d3._m02(d52);
        matrix4d3._m03(0.0d);
        matrix4d3._m10(d46);
        matrix4d3._m11(d48);
        matrix4d3._m12(d49);
        matrix4d3._m13(0.0d);
        matrix4d3._m30(((((-d51) * d2) - (d46 * d3)) - (this.m20 * d4)) + d21);
        matrix4d3._m31(((((-d43) * d2) - (d48 * d3)) - (this.m21 * d4)) + d28);
        matrix4d3._m32(((((-d52) * d2) - (d49 * d3)) - (this.m22 * d4)) + d38);
        matrix4d3._m33(1.0d);
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateAroundLocal(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d5 = w2;
        double b2 = a.b(w, x, z, y);
        double a2 = a.a(y2, d5, d5, y2);
        double d6 = z2;
        double d7 = w3;
        double f2 = a.f(z2, w3, d6, d7);
        double d8 = d5;
        double d9 = (((-d8) + y2) - d8) + y2;
        double f3 = a.f(y, z, w, x);
        double d10 = z3 + z3;
        double d11 = d10 + w4 + w4;
        double a3 = a.a(w3, z2, d6, d7);
        double d12 = (d10 - w4) - w4;
        double g2 = a.g(z, y, x, w);
        double d13 = this.m00;
        double d14 = this.m03;
        double d15 = d13 - (d2 * d14);
        double d16 = this.m01 - (d3 * d14);
        double d17 = this.m02 - (d4 * d14);
        double d18 = this.m10;
        double d19 = this.m13;
        double d20 = d18 - (d2 * d19);
        double d21 = this.m11 - (d3 * d19);
        double d22 = this.m12 - (d4 * d19);
        double d23 = d19;
        double d24 = this.m20;
        double d25 = d22;
        double d26 = this.m23;
        double d27 = d24 - (d2 * d26);
        double d28 = this.m21 - (d3 * d26);
        double d29 = this.m22 - (d4 * d26);
        double d30 = d26;
        double d31 = this.m30;
        double d32 = d29;
        double d33 = this.m33;
        double d34 = d31 - (d2 * d33);
        double d35 = this.m31 - (d3 * d33);
        double d36 = this.m32 - (d4 * d33);
        double d37 = d33;
        matrix4d2.m00 = (d2 * d14) + (a3 * d17) + (d9 * d16) + (b2 * d15);
        matrix4d2.m01 = (d3 * d14) + (d12 * d17) + (f3 * d16) + (a2 * d15);
        double d38 = d17 * g2;
        double d39 = d4 * d14;
        matrix4d2.m02 = d39 + d38 + (d16 * d11) + (d15 * f2);
        matrix4d2.m03 = d14;
        matrix4d2.m10 = (d2 * d23) + (a3 * d25) + (d9 * d21) + (b2 * d20);
        matrix4d2.m11 = (d3 * d23) + (d12 * d25) + (f3 * d21) + (a2 * d20);
        matrix4d2.m12 = (d4 * d23) + (g2 * d25) + (d11 * d21) + (f2 * d20);
        matrix4d2.m13 = d23;
        matrix4d2.m20 = (d2 * d30) + (a3 * d32) + (d9 * d28) + (b2 * d27);
        matrix4d2.m21 = (d3 * d30) + (d12 * d32) + (f3 * d28) + (a2 * d27);
        matrix4d2.m22 = (d4 * d30) + (g2 * d32) + (d11 * d28) + (f2 * d27);
        matrix4d2.m23 = d30;
        double d40 = a3 * d36;
        double d41 = d2 * d37;
        matrix4d2.m30 = d41 + d40 + (d9 * d35) + (b2 * d34);
        double d42 = d12 * d36;
        double d43 = d3 * d37;
        matrix4d2.m31 = d43 + d42 + (f3 * d35) + (a2 * d34);
        double d44 = g2 * d36;
        double d45 = d4 * d37;
        matrix4d2.m32 = d45 + d44 + (d11 * d35) + (f2 * d34);
        matrix4d2.m33 = d37;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateLocal(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.rotation(d2, d3, d4, d5);
        }
        return rotateLocalGeneric(d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d rotateLocalX(double d2, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = this.m00;
        matrix4d2.m01 = d6;
        matrix4d2.m02 = d7;
        matrix4d2.m03 = this.m03;
        matrix4d2.m10 = this.m10;
        matrix4d2.m11 = d17;
        matrix4d2.m12 = d15;
        matrix4d2.m13 = this.m13;
        matrix4d2.m20 = this.m20;
        matrix4d2.m21 = d24;
        matrix4d2.m22 = d22;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = d25;
        matrix4d2.m32 = d26;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateLocalY(double d2, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = d6;
        matrix4d2.m01 = this.m01;
        matrix4d2.m02 = d11;
        matrix4d2.m03 = this.m03;
        matrix4d2.m10 = d19;
        matrix4d2.m11 = this.m11;
        matrix4d2.m12 = d17;
        matrix4d2.m13 = this.m13;
        matrix4d2.m20 = d20;
        matrix4d2.m21 = this.m21;
        matrix4d2.m22 = d24;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = d26;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = d27;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateLocalZ(double d2, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = d6;
        matrix4d2.m01 = d7;
        matrix4d2.m02 = this.m02;
        matrix4d2.m03 = this.m03;
        matrix4d2.m10 = d17;
        matrix4d2.m11 = d15;
        matrix4d2.m12 = this.m12;
        matrix4d2.m13 = this.m13;
        matrix4d2.m20 = d24;
        matrix4d2.m21 = d22;
        matrix4d2.m22 = this.m22;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = d25;
        matrix4d2.m31 = d26;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4d);
    }

    public Matrix4d rotateTowardsXY(double d2, double d3) {
        return rotateTowardsXY(d2, d3, this);
    }

    public Matrix4d rotateTranslation(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m20 = d12 + d13;
        matrix4d2.m21 = d21;
        matrix4d2.m22 = d22;
        matrix4d2.m00 = d11;
        matrix4d2.m01 = d14;
        matrix4d2.m02 = d15;
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = d16;
        matrix4d2.m11 = d19;
        matrix4d2.m12 = d20;
        matrix4d2.m13 = 0.0d;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateX(double d2, Matrix4d matrix4d) {
        double d3 = d2;
        Matrix4d matrix4d2 = matrix4d;
        if ((this.properties & 4) != 0) {
            return matrix4d2.rotationX(d3);
        }
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = -sin;
        double d5 = this.m10;
        double d6 = d5 * cosFromSin;
        double d7 = this.m20;
        double d8 = (d7 * sin) + d6;
        double d9 = this.m11;
        double d10 = d9 * cosFromSin;
        double d11 = d8;
        double d12 = this.m21;
        double d13 = d12;
        double d14 = (d12 * sin) + d10;
        double d15 = this.m12;
        double d16 = d15 * cosFromSin;
        double d17 = d15;
        double d18 = this.m22;
        double d19 = d18;
        double d20 = (d18 * sin) + d16;
        double d21 = this.m13;
        double d22 = d21 * cosFromSin;
        double d23 = d21;
        double d24 = this.m23;
        double d25 = (sin * d24) + d22;
        matrix4d2.m20 = (d7 * cosFromSin) + (d5 * d4);
        matrix4d2.m21 = (d13 * cosFromSin) + (d9 * d4);
        matrix4d2.m22 = (d19 * cosFromSin) + (d17 * d4);
        matrix4d2.m23 = (d24 * cosFromSin) + (d4 * d23);
        matrix4d2.m10 = d11;
        matrix4d2.m11 = d14;
        matrix4d2.m12 = d20;
        matrix4d2.m13 = d25;
        matrix4d2.m00 = this.m00;
        matrix4d2.m01 = this.m01;
        matrix4d2.m02 = this.m02;
        matrix4d2.m03 = this.m03;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateXYZ(Vector3d vector3d) {
        return rotateXYZ(vector3d.x, vector3d.y, vector3d.z);
    }

    public Matrix4d rotateY(double d2, Matrix4d matrix4d) {
        double d3 = d2;
        Matrix4d matrix4d2 = matrix4d;
        if ((this.properties & 4) != 0) {
            return matrix4d2.rotationY(d3);
        }
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d3);
        double d4 = -sin;
        double d5 = this.m00;
        double d6 = d5 * cosFromSin;
        double d7 = this.m20;
        double d8 = (d7 * d4) + d6;
        double d9 = this.m01;
        double d10 = d9 * cosFromSin;
        double d11 = d8;
        double d12 = this.m21;
        double d13 = d12;
        double d14 = (d12 * d4) + d10;
        double d15 = this.m02;
        double d16 = d15 * cosFromSin;
        double d17 = d15;
        double d18 = this.m22;
        double d19 = d18;
        double d20 = (d18 * d4) + d16;
        double d21 = this.m03;
        double d22 = d21 * cosFromSin;
        double d23 = d21;
        double d24 = this.m23;
        double d25 = (d4 * d24) + d22;
        matrix4d2.m20 = (d7 * cosFromSin) + (d5 * sin);
        matrix4d2.m21 = (d13 * cosFromSin) + (d9 * sin);
        matrix4d2.m22 = (d19 * cosFromSin) + (d17 * sin);
        matrix4d2.m23 = (d24 * cosFromSin) + (sin * d23);
        matrix4d2.m00 = d11;
        matrix4d2.m01 = d14;
        matrix4d2.m02 = d20;
        matrix4d2.m03 = d25;
        matrix4d2.m10 = this.m10;
        matrix4d2.m11 = this.m11;
        matrix4d2.m12 = this.m12;
        matrix4d2.m13 = this.m13;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateYXZ(Vector3d vector3d) {
        return rotateYXZ(vector3d.y, vector3d.x, vector3d.z);
    }

    public Matrix4d rotateZ(double d2, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.rotationZ(d2);
        }
        double sin = Math.sin(d2);
        return rotateTowardsXY(sin, Math.cosFromSin(sin, d2), matrix4d);
    }

    public Matrix4d rotateZYX(Vector3d vector3d) {
        return rotateZYX(vector3d.z, vector3d.y, vector3d.x);
    }

    public Matrix4d rotation(double d2, double d3, double d4, double d5) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d6 = 1.0d - cosFromSin;
        double d7 = d3 * d4;
        double d8 = d3 * d5;
        double d9 = d4 * d5;
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d10 = d6;
        double d11 = cosFromSin;
        this.m00 = a.d(d3, d3, d10, d11);
        double d12 = d7 * d6;
        double d13 = d5 * sin;
        this.m10 = d12 - d13;
        double d14 = d8 * d6;
        double d15 = d4 * sin;
        this.m20 = d14 + d15;
        this.m01 = d13 + d12;
        this.m11 = a.d(d4, d4, d10, d11);
        double d16 = d9 * d6;
        double d17 = d3 * sin;
        this.m21 = d16 - d17;
        this.m02 = d14 - d15;
        this.m12 = d16 + d17;
        this.m22 = a.d(d5, d5, d10, d11);
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationAround(Quaterniondc quaterniondc, double d2, double d3, double d4) {
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
        _m23(0.0d);
        _m00(((d8 + d9) - z) - y);
        _m01(d7 + d6);
        _m02(b2 - a3);
        _m03(0.0d);
        _m10((-d6) + d7);
        _m11(((y - z) + d8) - d9);
        _m12(b3 + a4);
        _m13(0.0d);
        _m30(((((-this.m00) * d2) - (this.m10 * d3)) - (this.m20 * d4)) + d2);
        _m31(((((-this.m01) * d2) - (this.m11 * d3)) - (this.m21 * d4)) + d3);
        _m32(((((-this.m02) * d2) - (this.m12 * d3)) - (this.m22 * d4)) + d4);
        _m33(1.0d);
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotationTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d rotationTowardsXY(double d2, double d3) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = d3;
        this.m01 = d2;
        this.m10 = -d2;
        this.m11 = d3;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationX(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m11 = cosFromSin;
        this.m12 = sin;
        this.m21 = -sin;
        this.m22 = cosFromSin;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationXYZ(double d2, double d3, double d4) {
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
        if ((this.properties & 4) == 0) {
            _identity();
        }
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
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationY(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = cosFromSin;
        this.m02 = -sin;
        this.m20 = sin;
        this.m22 = cosFromSin;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationYXZ(double d2, double d3, double d4) {
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
        this.m23 = 0.0d;
        this.m00 = (d8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * d9) + (d5 * cosFromSin3);
        this.m03 = 0.0d;
        this.m10 = (cosFromSin2 * d7) + (d8 * cosFromSin3);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (d9 * cosFromSin3) + (d5 * d7);
        this.m13 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationZ(double d2) {
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = cosFromSin;
        this.m01 = sin;
        this.m10 = -sin;
        this.m11 = cosFromSin;
        this.properties = 18;
        return this;
    }

    public Matrix4d rotationZYX(double d2, double d3, double d4) {
        double sin = Math.sin(d4);
        double cosFromSin = Math.cosFromSin(sin, d4);
        double sin2 = Math.sin(d3);
        double cosFromSin2 = Math.cosFromSin(sin2, d3);
        double sin3 = Math.sin(d2);
        double cosFromSin3 = Math.cosFromSin(sin3, d2);
        double d5 = cosFromSin;
        double d6 = -sin2;
        double d7 = -sin3;
        double d8 = -sin;
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d9 = cosFromSin3 * sin2;
        double d10 = sin2 * sin3;
        double d11 = d8;
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = d6;
        this.m10 = (d9 * sin) + (d7 * d5);
        this.m11 = (d10 * sin) + (cosFromSin3 * d5);
        this.m12 = sin * cosFromSin2;
        this.m20 = (d9 * d5) + (d7 * d11);
        this.m21 = (d10 * d5) + (cosFromSin3 * d11);
        this.m22 = cosFromSin2 * d5;
        this.properties = 18;
        return this;
    }

    public Matrix4d scale(Vector3dc vector3dc, Matrix4d matrix4d) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4d);
    }

    public Matrix4d scaleAround(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d8 = this.m00;
        double d9 = d8 * d5;
        double d10 = this.m10;
        double d11 = (d10 * d6) + d9;
        double d12 = this.m20;
        double d13 = this.m30 + (d12 * d7) + d11;
        double d14 = this.m01;
        double d15 = d14 * d5;
        double d16 = this.m11;
        double d17 = (d16 * d6) + d15;
        double d18 = this.m21;
        double d19 = (d18 * d7) + d17;
        double d20 = d13;
        double d21 = d19 + this.m31;
        double d22 = this.m02;
        double d23 = d22 * d5;
        double d24 = d18;
        double d25 = this.m12;
        double d26 = (d25 * d6) + d23;
        double d27 = d12;
        double d28 = this.m22;
        double d29 = (d28 * d7) + d26;
        double d30 = d28;
        double d31 = d29 + this.m32;
        double d32 = this.m03;
        double d33 = d32 * d5;
        double d34 = d25;
        double d35 = this.m13;
        double d36 = (d35 * d6) + d33;
        double d37 = d35;
        double d38 = this.m23;
        double d39 = (d38 * d7) + d36;
        double d40 = d38;
        double d41 = d39 + this.m33;
        matrix4d2.m00 = d8 * d2;
        matrix4d2.m01 = d14 * d2;
        matrix4d2.m02 = d22 * d2;
        matrix4d2.m03 = d32 * d2;
        matrix4d2.m10 = d10 * d3;
        matrix4d2.m11 = d16 * d3;
        matrix4d2.m12 = d34 * d3;
        matrix4d2.m13 = d37 * d3;
        matrix4d2.m20 = d27 * d4;
        matrix4d2.m21 = d24 * d4;
        matrix4d2.m22 = d30 * d4;
        matrix4d2.m23 = d40 * d4;
        matrix4d2.m30 = a.m(this.m20, d7, ((-this.m00) * d5) - (this.m10 * d6), d20);
        matrix4d2.m31 = a.m(this.m21, d7, ((-this.m01) * d5) - (this.m11 * d6), d21);
        matrix4d2.m32 = a.m(this.m22, d7, ((-this.m02) * d5) - (this.m12 * d6), d31);
        matrix4d2.m33 = a.m(this.m23, d7, ((-this.m03) * d5) - (this.m13 * d6), d41);
        int i2 = 0;
        boolean z = Math.abs(d2) == 1.0d && Math.abs(d3) == 1.0d && Math.abs(d4) == 1.0d;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4d2.properties = (~(i2 | 13)) & i3;
        return matrix4d2;
    }

    public Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d8 = this.m00;
        double d9 = this.m03;
        matrix4d2.m00 = (d5 * d9) + a.c(d5, d9, d8, d2);
        matrix4d2.m01 = (d6 * d9) + a.c(d6, d9, this.m01, d3);
        matrix4d2.m02 = (d7 * d9) + a.c(d7, d9, this.m02, d4);
        matrix4d2.m03 = d9;
        double d10 = this.m10;
        double d11 = this.m13;
        matrix4d2.m10 = (d5 * d11) + a.c(d5, d11, d10, d2);
        matrix4d2.m11 = (d6 * d11) + a.c(d6, d11, this.m11, d3);
        matrix4d2.m12 = (d7 * d11) + a.c(d7, d11, this.m12, d4);
        matrix4d2.m13 = d11;
        double d12 = this.m20;
        double d13 = this.m23;
        matrix4d2.m20 = (d5 * d13) + a.c(d5, d13, d12, d2);
        matrix4d2.m21 = (d6 * d13) + a.c(d6, d13, this.m21, d3);
        matrix4d2.m22 = (d7 * d13) + a.c(d7, d13, this.m22, d4);
        matrix4d2.m23 = d13;
        double d14 = this.m30;
        double d15 = this.m33;
        matrix4d2.m30 = (d5 * d15) + a.c(d5, d15, d14, d2);
        matrix4d2.m31 = (d6 * d15) + a.c(d6, d15, this.m31, d3);
        matrix4d2.m32 = (d7 * d15) + a.c(d7, d15, this.m32, d4);
        matrix4d2.m33 = d15;
        int i2 = 0;
        boolean z = Math.abs(d2) == 1.0d && Math.abs(d3) == 1.0d && Math.abs(d4) == 1.0d;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4d2.properties = (~(i2 | 13)) & i3;
        return matrix4d2;
    }

    public Matrix4d scaleLocal(double d2, double d3, double d4, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.scaling(d2, d3, d4);
        }
        return scaleLocalGeneric(d2, d3, d4, matrix4d);
    }

    public Matrix4d scaling(double d2) {
        return scaling(d2, d2, d2);
    }

    public Matrix4d set(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m03 = matrix4dc.m03();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m13 = matrix4dc.m13();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
        this.m23 = matrix4dc.m23();
        this.m30 = matrix4dc.m30();
        this.m31 = matrix4dc.m31();
        this.m32 = matrix4dc.m32();
        this.m33 = matrix4dc.m33();
        this.properties = matrix4dc.properties();
        return this;
    }

    public Matrix4d set3x3(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
        this.properties = matrix4dc.properties() & -2 & this.properties;
        return this;
    }

    public Matrix4d set4x3(Matrix4x3dc matrix4x3dc) {
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
        this.properties = matrix4x3dc.properties() & -2 & this.properties;
        return this;
    }

    public Matrix4d setColumn(int i2, Vector4dc vector4dc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = vector4dc.x();
            this.m01 = vector4dc.y();
            this.m02 = vector4dc.z();
            this.m03 = vector4dc.w();
        } else if (i2 == 1) {
            this.m10 = vector4dc.x();
            this.m11 = vector4dc.y();
            this.m12 = vector4dc.z();
            this.m13 = vector4dc.w();
        } else if (i2 == 2) {
            this.m20 = vector4dc.x();
            this.m21 = vector4dc.y();
            this.m22 = vector4dc.z();
            this.m23 = vector4dc.w();
        } else if (i2 == 3) {
            this.m30 = vector4dc.x();
            this.m31 = vector4dc.y();
            this.m32 = vector4dc.z();
            this.m33 = vector4dc.w();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4d setFloats(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.getf(this, byteBuffer.position(), byteBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4d setFromIntrinsic(double d2, double d3, double d4, double d5, double d6, int i2, int i3, double d7, double d8) {
        double d9 = d7;
        double d10 = 2.0d / ((double) i2);
        double d11 = 2.0d / ((double) i3);
        double d12 = d9 - d8;
        double d13 = 2.0d / d12;
        this.m00 = d10 * d2;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m03 = 0.0d;
        this.m10 = d10 * d4;
        this.m11 = d11 * d3;
        this.m12 = 0.0d;
        this.m13 = 0.0d;
        this.m20 = (d10 * d5) - 1.0d;
        this.m21 = (d11 * d6) - 1.0d;
        double d14 = d9 + d8;
        this.m22 = (d14 / d12) + ((-d14) * d13);
        this.m23 = -1.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = d13 * (-d9) * d8;
        this.m33 = 0.0d;
        this.properties = 1;
        return this;
    }

    public Matrix4d setFrustum(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d8 = d6 + d6;
        double d9 = d3 - d2;
        this.m00 = d8 / d9;
        double d10 = d5 - d4;
        this.m11 = d8 / d10;
        this.m20 = (d3 + d2) / d9;
        this.m21 = (d5 + d4) / d10;
        int i2 = 1;
        boolean z2 = d7 > 0.0d && Double.isInfinite(d7);
        boolean z3 = d6 > 0.0d && Double.isInfinite(d6);
        double d11 = 2.0d;
        if (z2) {
            this.m22 = -0.999999d;
            if (z) {
                d11 = 1.0d;
            }
            this.m32 = (1.0E-6d - d11) * d6;
        } else if (z3) {
            this.m22 = (z ? 0.0d : 1.0d) - 1.0E-6d;
            if (z) {
                d11 = 1.0d;
            }
            this.m32 = (d11 - 1.0E-6d) * d7;
        } else {
            double d12 = d6 - d7;
            this.m22 = (z ? d7 : d7 + d6) / d12;
            this.m32 = ((z ? d7 : d7 + d7) * d6) / d12;
        }
        this.m23 = -1.0d;
        this.m33 = 0.0d;
        if (!(this.m20 == 0.0d && this.m21 == 0.0d)) {
            i2 = 0;
        }
        this.properties = i2;
        return this;
    }

    public Matrix4d setFrustumLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d8 = d6 + d6;
        double d9 = d3 - d2;
        this.m00 = d8 / d9;
        double d10 = d5 - d4;
        this.m11 = d8 / d10;
        this.m20 = (d3 + d2) / d9;
        this.m21 = (d5 + d4) / d10;
        int i2 = 1;
        boolean z2 = d7 > 0.0d && Double.isInfinite(d7);
        boolean z3 = d6 > 0.0d && Double.isInfinite(d6);
        double d11 = 2.0d;
        if (z2) {
            this.m22 = 0.999999d;
            if (z) {
                d11 = 1.0d;
            }
            this.m32 = (1.0E-6d - d11) * d6;
        } else if (z3) {
            this.m22 = (z ? 0.0d : 1.0d) - 1.0E-6d;
            if (z) {
                d11 = 1.0d;
            }
            this.m32 = (d11 - 1.0E-6d) * d7;
        } else {
            this.m22 = (z ? d7 : d7 + d6) / (d7 - d6);
            this.m32 = ((z ? d7 : d7 + d7) * d6) / (d6 - d7);
        }
        this.m23 = 1.0d;
        this.m33 = 0.0d;
        if (!(this.m20 == 0.0d && this.m21 == 0.0d)) {
            i2 = 0;
        }
        this.properties = i2;
        return this;
    }

    public Matrix4d setLookAlong(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return setLookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d setLookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return setLookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4d setLookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return setLookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4d setOrtho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d8 = 2.0d;
        this.m00 = 2.0d / (d3 - d2);
        this.m11 = 2.0d / (d5 - d4);
        if (z) {
            d8 = 1.0d;
        }
        double d9 = d6 - d7;
        this.m22 = d8 / d9;
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.m32 = (z ? d6 : d7 + d6) / d9;
        this.properties = 2;
        return this;
    }

    public Matrix4d setOrtho2D(double d2, double d3, double d4, double d5) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = 2.0d / (d3 - d2);
        this.m11 = 2.0d / (d5 - d4);
        this.m22 = -1.0d;
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.properties = 2;
        return this;
    }

    public Matrix4d setOrtho2DLH(double d2, double d3, double d4, double d5) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = 2.0d / (d3 - d2);
        this.m11 = 2.0d / (d5 - d4);
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.properties = 2;
        return this;
    }

    public Matrix4d setOrthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d8 = 2.0d;
        this.m00 = 2.0d / (d3 - d2);
        this.m11 = 2.0d / (d5 - d4);
        if (z) {
            d8 = 1.0d;
        }
        this.m22 = d8 / (d7 - d6);
        this.m30 = (d3 + d2) / (d2 - d3);
        this.m31 = (d5 + d4) / (d4 - d5);
        this.m32 = (z ? d6 : d7 + d6) / (d6 - d7);
        this.properties = 2;
        return this;
    }

    public Matrix4d setOrthoSymmetric(double d2, double d3, double d4, double d5, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d6 = 2.0d;
        this.m00 = 2.0d / d2;
        this.m11 = 2.0d / d3;
        if (z) {
            d6 = 1.0d;
        }
        double d7 = d4 - d5;
        this.m22 = d6 / d7;
        if (!z) {
            d4 += d5;
        }
        this.m32 = d4 / d7;
        this.properties = 2;
        return this;
    }

    public Matrix4d setOrthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d6 = 2.0d;
        this.m00 = 2.0d / d2;
        this.m11 = 2.0d / d3;
        if (z) {
            d6 = 1.0d;
        }
        this.m22 = d6 / (d5 - d4);
        this.m32 = (z ? d4 : d5 + d4) / (d4 - d5);
        this.properties = 2;
        return this;
    }

    public Matrix4d setPerspective(double d2, double d3, double d4, double d5, boolean z) {
        double tan = Math.tan(0.5d * d2);
        double d6 = 1.0d;
        this.m00 = 1.0d / (tan * d3);
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m03 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 1.0d / tan;
        this.m12 = 0.0d;
        this.m13 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        boolean z2 = false;
        boolean z3 = d5 > 0.0d && Double.isInfinite(d5);
        if (d4 > 0.0d && Double.isInfinite(d4)) {
            z2 = true;
        }
        if (z3) {
            this.m22 = -0.999999d;
            if (!z) {
                d6 = 2.0d;
            }
            this.m32 = (1.0E-6d - d6) * d4;
        } else if (z2) {
            this.m22 = (z ? 0.0d : 1.0d) - 1.0E-6d;
            if (!z) {
                d6 = 2.0d;
            }
            this.m32 = (d6 - 1.0E-6d) * d5;
        } else {
            double d7 = d4 - d5;
            this.m22 = (z ? d5 : d5 + d4) / d7;
            this.m32 = ((z ? d5 : d5 + d5) * d4) / d7;
        }
        this.m23 = -1.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m33 = 0.0d;
        this.properties = 1;
        return this;
    }

    public Matrix4d setPerspectiveLH(double d2, double d3, double d4, double d5, boolean z) {
        double tan = Math.tan(0.5d * d2);
        this.m00 = 1.0d / (tan * d3);
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m03 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 1.0d / tan;
        this.m12 = 0.0d;
        this.m13 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        boolean z2 = false;
        boolean z3 = d5 > 0.0d && Double.isInfinite(d5);
        if (d4 > 0.0d && Double.isInfinite(d4)) {
            z2 = true;
        }
        double d6 = 2.0d;
        if (z3) {
            this.m22 = 0.999999d;
            if (z) {
                d6 = 1.0d;
            }
            this.m32 = (1.0E-6d - d6) * d4;
        } else if (z2) {
            this.m22 = (z ? 0.0d : 1.0d) - 1.0E-6d;
            if (z) {
                d6 = 1.0d;
            }
            this.m32 = (d6 - 1.0E-6d) * d5;
        } else {
            this.m22 = (z ? d5 : d5 + d4) / (d5 - d4);
            this.m32 = ((z ? d5 : d5 + d5) * d4) / (d4 - d5);
        }
        this.m23 = 1.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m33 = 0.0d;
        this.properties = 1;
        return this;
    }

    public Matrix4d setRotationXYZ(double d2, double d3, double d4) {
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
        this.properties &= -14;
        return this;
    }

    public Matrix4d setRotationYXZ(double d2, double d3, double d4) {
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
        this.properties &= -14;
        return this;
    }

    public Matrix4d setRotationZYX(double d2, double d3, double d4) {
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
        this.properties &= -14;
        return this;
    }

    public Matrix4d setRow(int i2, Vector4dc vector4dc) throws IndexOutOfBoundsException {
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
        } else if (i2 == 3) {
            this.m03 = vector4dc.x();
            this.m13 = vector4dc.y();
            this.m23 = vector4dc.z();
            this.m33 = vector4dc.w();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4d setTranslation(double d2, double d3, double d4) {
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.properties &= -6;
        return this;
    }

    public Matrix4d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5) {
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, d4, d5, this);
    }

    public Matrix4d sub(Matrix4dc matrix4dc) {
        return sub(matrix4dc, this);
    }

    public Matrix4d sub4x3(Matrix4dc matrix4dc) {
        return sub4x3(matrix4dc, this);
    }

    public Matrix4d swap(Matrix4d matrix4d) {
        double d2 = this.m00;
        this.m00 = matrix4d.m00;
        matrix4d.m00 = d2;
        double d3 = this.m01;
        this.m01 = matrix4d.m01;
        matrix4d.m01 = d3;
        double d4 = this.m02;
        this.m02 = matrix4d.m02;
        matrix4d.m02 = d4;
        double d5 = this.m03;
        this.m03 = matrix4d.m03;
        matrix4d.m03 = d5;
        double d6 = this.m10;
        this.m10 = matrix4d.m10;
        matrix4d.m10 = d6;
        double d7 = this.m11;
        this.m11 = matrix4d.m11;
        matrix4d.m11 = d7;
        double d8 = this.m12;
        this.m12 = matrix4d.m12;
        matrix4d.m12 = d8;
        double d9 = this.m13;
        this.m13 = matrix4d.m13;
        matrix4d.m13 = d9;
        double d10 = this.m20;
        this.m20 = matrix4d.m20;
        matrix4d.m20 = d10;
        double d11 = this.m21;
        this.m21 = matrix4d.m21;
        matrix4d.m21 = d11;
        double d12 = this.m22;
        this.m22 = matrix4d.m22;
        matrix4d.m22 = d12;
        double d13 = this.m23;
        this.m23 = matrix4d.m23;
        matrix4d.m23 = d13;
        double d14 = this.m30;
        this.m30 = matrix4d.m30;
        matrix4d.m30 = d14;
        double d15 = this.m31;
        this.m31 = matrix4d.m31;
        matrix4d.m31 = d15;
        double d16 = this.m32;
        this.m32 = matrix4d.m32;
        matrix4d.m32 = d16;
        double d17 = this.m33;
        this.m33 = matrix4d.m33;
        matrix4d.m33 = d17;
        int i2 = this.properties;
        this.properties = matrix4d.properties;
        matrix4d.properties = i2;
        return this;
    }

    public boolean testAab(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = this.m03;
        double d9 = this.m00;
        double d10 = d8 + d9;
        double d11 = this.m13;
        double d12 = this.m10;
        double d13 = d11 + d12;
        double d14 = this.m23;
        double d15 = d13;
        double d16 = this.m20;
        double d17 = d14 + d16;
        double d18 = d10;
        double d19 = this.m33;
        double d20 = d16;
        double d21 = this.m30;
        double d22 = d14;
        double d23 = d19 + d21;
        double d24 = d8 - d9;
        double d25 = d11 - d12;
        double d26 = d22 - d20;
        double d27 = d19 - d21;
        double d28 = this.m01;
        double d29 = d8 + d28;
        double d30 = d25;
        double d31 = this.m11;
        double d32 = d11 + d31;
        double d33 = d24;
        double d34 = this.m21;
        double d35 = d22 + d34;
        double d36 = d23;
        double d37 = this.m31;
        double d38 = d34;
        double d39 = d19 + d37;
        double d40 = d8 - d28;
        double d41 = d11 - d31;
        double d42 = d22 - d38;
        double d43 = d19 - d37;
        double d44 = this.m02;
        double d45 = d8 + d44;
        double d46 = d41;
        double d47 = this.m12;
        double d48 = d11 + d47;
        double d49 = d40;
        double d50 = this.m22;
        double d51 = d22 + d50;
        double d52 = d39;
        double d53 = this.m32;
        double d54 = d50;
        double d55 = d19 + d53;
        double d56 = d8 - d44;
        double d57 = d11 - d47;
        double d58 = d22 - d54;
        double d59 = d19 - d53;
        if ((d17 * (d17 < 0.0d ? d4 : d7)) + (d15 * (d15 < 0.0d ? d3 : d6)) + ((d18 < 0.0d ? d2 : d5) * d18) >= (-d36)) {
            if ((d26 * (d26 < 0.0d ? d4 : d7)) + ((d30 < 0.0d ? d3 : d6) * d30) + ((d33 < 0.0d ? d2 : d5) * d33) >= (-d27)) {
                if ((d35 * (d35 < 0.0d ? d4 : d7)) + (d32 * (d32 < 0.0d ? d3 : d6)) + (d29 * (d29 < 0.0d ? d2 : d5)) >= (-d52)) {
                    if ((d42 * (d42 < 0.0d ? d4 : d7)) + ((d46 < 0.0d ? d3 : d6) * d46) + ((d49 < 0.0d ? d2 : d5) * d49) >= (-d43)) {
                        if ((d51 * (d51 < 0.0d ? d4 : d7)) + (d48 * (d48 < 0.0d ? d3 : d6)) + (d45 * (d45 < 0.0d ? d2 : d5)) >= (-d55)) {
                            if ((d58 * (d58 < 0.0d ? d4 : d7)) + (d57 * (d57 < 0.0d ? d3 : d6)) + (d56 * (d56 < 0.0d ? d2 : d5)) >= (-d59)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testPoint(double d2, double d3, double d4) {
        double d5 = this.m03;
        double d6 = this.m00;
        double d7 = d5 + d6;
        double d8 = this.m13;
        double d9 = this.m10;
        double d10 = d8 + d9;
        double d11 = this.m23;
        double d12 = d10;
        double d13 = this.m20;
        double d14 = d11 + d13;
        double d15 = d7;
        double d16 = this.m33;
        double d17 = d13;
        double d18 = this.m30;
        double d19 = d16 + d18;
        double d20 = d5 - d6;
        double d21 = d8 - d9;
        double d22 = d11 - d17;
        double d23 = d16 - d18;
        double d24 = this.m01;
        double d25 = d5 + d24;
        double d26 = d21;
        double d27 = this.m11;
        double d28 = d8 + d27;
        double d29 = d20;
        double d30 = this.m21;
        double d31 = d11 + d30;
        double d32 = d30;
        double d33 = this.m31;
        double d34 = d16 + d33;
        double d35 = d5 - d24;
        double d36 = d8 - d27;
        double d37 = d11 - d32;
        double d38 = d16 - d33;
        double d39 = this.m02;
        double d40 = d5 + d39;
        double d41 = d36;
        double d42 = this.m12;
        double d43 = d8 + d42;
        double d44 = d35;
        double d45 = this.m22;
        double d46 = d11 + d45;
        double d47 = d45;
        double d48 = this.m32;
        double d49 = d16 + d48;
        double d50 = d5 - d39;
        double d51 = d8 - d42;
        double d52 = d11 - d47;
        double d53 = d16 - d48;
        if (a.i(d14, d4, (d12 * d3) + (d15 * d2), d19) >= 0.0d) {
            double d54 = d26 * d3;
            if (a.i(d22, d4, d54 + (d29 * d2), d23) >= 0.0d) {
                if (a.i(d31, d4, (d28 * d3) + (d25 * d2), d34) >= 0.0d) {
                    double d55 = d41 * d3;
                    if (a.i(d37, d4, d55 + (d44 * d2), d38) >= 0.0d) {
                        if (a.i(d46, d4, (d43 * d3) + (d40 * d2), d49) >= 0.0d) {
                            if (a.i(d52, d4, (d51 * d3) + (d50 * d2), d53) >= 0.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testSphere(double d2, double d3, double d4, double d5) {
        double d6 = this.m03 + this.m00;
        double d7 = this.m13 + this.m10;
        double d8 = this.m23 + this.m20;
        double d9 = this.m33 + this.m30;
        double e2 = a.e(d8, d8, (d7 * d7) + (d6 * d6), 1.0d);
        double d10 = d6 * e2;
        double d11 = d7 * e2;
        double d12 = d8 * e2;
        double d13 = d9 * e2;
        double d14 = this.m03 - this.m00;
        double d15 = this.m13 - this.m10;
        double d16 = this.m23 - this.m20;
        double d17 = d12;
        double d18 = this.m33 - this.m30;
        double e3 = a.e(d16, d16, (d15 * d15) + (d14 * d14), 1.0d);
        double d19 = d14 * e3;
        double d20 = d15 * e3;
        double d21 = d16 * e3;
        double d22 = d18 * e3;
        double d23 = this.m03 + this.m01;
        double d24 = this.m13 + this.m11;
        double d25 = d20;
        double d26 = this.m23 + this.m21;
        double d27 = d19;
        double d28 = this.m33 + this.m31;
        double e4 = a.e(d26, d26, (d24 * d24) + (d23 * d23), 1.0d);
        double d29 = d23 * e4;
        double d30 = d24 * e4;
        double d31 = d26 * e4;
        double d32 = d28 * e4;
        double d33 = this.m03 - this.m01;
        double d34 = this.m13 - this.m11;
        double d35 = this.m23 - this.m21;
        double d36 = d29;
        double d37 = this.m33 - this.m31;
        double d38 = d35;
        double d39 = d35;
        double e5 = a.e(d38, d39, (d34 * d34) + (d33 * d33), 1.0d);
        double d40 = d33 * e5;
        double d41 = d34 * e5;
        double d42 = d35 * e5;
        double d43 = d37 * e5;
        double d44 = this.m03 + this.m02;
        double d45 = this.m13 + this.m12;
        double d46 = d41;
        double d47 = this.m23 + this.m22;
        double d48 = d40;
        double d49 = this.m33 + this.m32;
        double d50 = d47;
        double d51 = d47;
        double e6 = a.e(d50, d51, (d45 * d45) + (d44 * d44), 1.0d);
        double d52 = d44 * e6;
        double d53 = d45 * e6;
        double d54 = d47 * e6;
        double d55 = d49 * e6;
        double d56 = this.m03 - this.m02;
        double d57 = this.m13 - this.m12;
        double d58 = this.m23 - this.m22;
        double d59 = d52;
        double d60 = this.m33 - this.m32;
        double d61 = d58;
        double d62 = d58;
        double e7 = a.e(d61, d62, (d57 * d57) + (d56 * d56), 1.0d);
        double d63 = d56 * e7;
        double d64 = d57 * e7;
        double d65 = d58 * e7;
        double d66 = d60 * e7;
        double d67 = -d5;
        if (a.i(d17, d4, (d10 * d2) + (d11 * d3), d13) >= d67) {
            double d68 = d25 * d3;
            if (a.i(d21, d4, d68 + (d27 * d2), d22) >= d67) {
                if (a.i(d31, d4, (d30 * d3) + (d36 * d2), d32) >= d67) {
                    double d69 = d46 * d3;
                    if (a.i(d42, d4, d69 + (d48 * d2), d43) >= d67) {
                        if (a.i(d54, d4, (d53 * d3) + (d59 * d2), d55) >= d67) {
                            if (a.i(d65, d4, (d64 * d3) + (d63 * d2), d66) >= d67) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        String matrix4d = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix4d.length(); i3++) {
            char charAt = matrix4d.charAt(i3);
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
        return vector4d.mul((Matrix4dc) this);
    }

    public Matrix4d transformAab(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d, Vector3d vector3d2) {
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

    public Vector4d transformAffine(Vector4d vector4d) {
        return vector4d.mulAffine((Matrix4dc) this, vector4d);
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

    public Vector4d transformProject(Vector4d vector4d) {
        return vector4d.mulProject(this);
    }

    public Matrix4d translate(Vector3dc vector3dc) {
        return translate(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4d translateLocal(Vector3fc vector3fc) {
        return translateLocal((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4d translation(double d2, double d3, double d4) {
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.m33 = 1.0d;
        this.properties = 26;
        return this;
    }

    public Matrix4d translationRotate(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
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
        double d19 = d10;
        this.m00 = a.b(d9, d10, d12, d11);
        this.m01 = a.a(d14, d13, d13, d14);
        this.m02 = a.f(d15, d16, d15, d16);
        this.m10 = (((-d13) + d14) - d13) + d14;
        this.m11 = a.f(d11, d12, d9, d19);
        double d20 = d17 + d17;
        this.m12 = d20 + d18 + d18;
        this.m20 = a.a(d16, d15, d15, d16);
        this.m21 = (d20 - d18) - d18;
        this.m22 = a.g(d12, d11, d19, d9);
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d translationRotateScale(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
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
        this.m03 = 0.0d;
        this.m10 = (d18 - d23) * d10;
        this.m11 = d10 - ((d17 + d15) * d10);
        this.m12 = (d21 + d20) * d10;
        this.m13 = 0.0d;
        this.m20 = (d19 + d22) * d11;
        this.m21 = (d21 - d20) * d11;
        this.m22 = d11 - ((d24 + d15) * d11);
        this.m23 = 0.0d;
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.m33 = 1.0d;
        int i2 = 0;
        if (Math.abs(d9) == 1.0d && Math.abs(d10) == 1.0d && Math.abs(d11) == 1.0d) {
            i2 = 16;
        }
        this.properties = i2 | 2;
        return this;
    }

    public Matrix4d translationRotateScaleInvert(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        if (Math.abs(d9) == 1.0d && Math.abs(d10) == 1.0d && Math.abs(d11) == 1.0d) {
            return translationRotateScale(d2, d3, d4, d5, d6, d7, d8, d9, d10, d11).invertOrthonormal(this);
        }
        double d12 = -d5;
        double d13 = -d6;
        double d14 = -d7;
        double d15 = d12 + d12;
        double d16 = d13 + d13;
        double d17 = d14 + d14;
        double d18 = d12 * d15;
        double d19 = d16 * d13;
        double d20 = d17 * d14;
        double d21 = d13 * d15;
        double d22 = d15 * d14;
        double d23 = d15 * d8;
        double d24 = d14 * d16;
        double d25 = d16 * d8;
        double d26 = d17 * d8;
        double d27 = 1.0d / d9;
        double d28 = 1.0d / d10;
        double d29 = 1.0d / d11;
        double d30 = 1.0d - d19;
        double d31 = (d30 - d20) * d27;
        this.m00 = d31;
        double d32 = d31;
        double d33 = (d21 + d26) * d28;
        this.m01 = d33;
        double d34 = d33;
        double d35 = (d22 - d25) * d29;
        this.m02 = d35;
        double d36 = d35;
        this.m03 = 0.0d;
        double d37 = (d21 - d26) * d27;
        this.m10 = d37;
        double d38 = ((1.0d - d20) - d18) * d28;
        this.m11 = d38;
        double d39 = d38;
        double d40 = (d24 + d23) * d29;
        this.m12 = d40;
        this.m13 = 0.0d;
        double d41 = (d22 + d25) * d27;
        this.m20 = d41;
        double d42 = (d24 - d23) * d28;
        this.m21 = d42;
        double d43 = (d30 - d18) * d29;
        this.m22 = d43;
        this.m23 = 0.0d;
        this.m30 = (((-d32) * d2) - (d37 * d3)) - (d41 * d4);
        this.m31 = (((-d34) * d2) - (d39 * d3)) - (d42 * d4);
        this.m32 = (((-d36) * d2) - (d40 * d3)) - (d43 * d4);
        this.m33 = 1.0d;
        this.properties = 2;
        return this;
    }

    public Matrix4d translationRotateScaleMulAffine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d12 = d8 * d8;
        double d13 = d5 * d5;
        double d14 = d6 * d6;
        double d15 = d7 * d7;
        double d16 = d7 * d8;
        double d17 = d5 * d6;
        double d18 = d5 * d7;
        double d19 = d6 * d8;
        double d20 = d6 * d7;
        double d21 = d5 * d8;
        double b2 = a.b(d12, d13, d15, d14);
        double a2 = a.a(d17, d16, d16, d17);
        double f2 = a.f(d18, d19, d18, d19);
        double d22 = (((-d16) + d17) - d16) + d17;
        double f3 = a.f(d14, d15, d12, d13);
        double d23 = d20 + d20;
        double d24 = d23 + d21 + d21;
        double a3 = a.a(d19, d18, d18, d19);
        double d25 = (d23 - d21) - d21;
        double g2 = a.g(d15, d14, d13, d12);
        Matrix4d matrix4d3 = matrix4d;
        double d26 = matrix4d3.m00;
        double d27 = b2 * d26;
        double d28 = g2;
        double d29 = matrix4d3.m01;
        double d30 = (d22 * d29) + d27;
        double d31 = matrix4d3.m02;
        double d32 = a3;
        double d33 = (a3 * d31) + d30;
        double d34 = f3;
        double d35 = (d25 * d31) + (f3 * d29) + (a2 * d26);
        double d36 = (d31 * d28) + (d29 * d24) + (d26 * f2);
        this.m02 = d36;
        this.m00 = d33;
        this.m01 = d35;
        this.m03 = 0.0d;
        double d37 = matrix4d3.m10;
        double d38 = b2 * d37;
        double d39 = matrix4d3.m11;
        double d40 = (d22 * d39) + d38;
        double d41 = matrix4d3.m12;
        double d42 = (d32 * d41) + d40;
        double d43 = d22;
        double d44 = (d25 * d41) + (d34 * d39) + (a2 * d37);
        this.m12 = (d41 * d28) + (d39 * d24) + (d37 * f2);
        this.m10 = d42;
        this.m11 = d44;
        this.m13 = 0.0d;
        double d45 = matrix4d3.m20;
        double d46 = b2 * d45;
        double d47 = matrix4d3.m21;
        double d48 = (d43 * d47) + d46;
        double d49 = matrix4d3.m22;
        double d50 = (d32 * d49) + d48;
        double d51 = (d25 * d49) + (d34 * d47) + (a2 * d45);
        this.m22 = (d49 * d28) + (d47 * d24) + (d45 * f2);
        this.m20 = d50;
        this.m21 = d51;
        this.m23 = 0.0d;
        double d52 = matrix4d3.m30;
        double d53 = b2 * d52;
        double d54 = matrix4d3.m31;
        double d55 = (d43 * d54) + d53;
        double d56 = matrix4d3.m32;
        double i2 = a.i(d32, d56, d55, d2);
        double i3 = a.i(d25, d56, (d34 * d54) + (a2 * d52), d3);
        this.m32 = a.i(d28, d56, (d24 * d54) + (f2 * d52), d4);
        this.m30 = i2;
        this.m31 = i3;
        this.m33 = 1.0d;
        int i4 = 0;
        if ((Math.abs(d9) == 1.0d && Math.abs(d10) == 1.0d && Math.abs(d11) == 1.0d) && (matrix4d3.properties & 16) != 0) {
            i4 = 16;
        }
        this.properties = 2 | i4;
        return this;
    }

    public Matrix4d translationRotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return translationRotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z());
    }

    public Matrix4d transpose() {
        return transpose(this);
    }

    public Matrix4d transpose3x3() {
        return transpose3x3(this);
    }

    public Matrix4d trapezoidCrop(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 - d3;
        double d11 = d2 - d4;
        double d12 = -d10;
        double d13 = (d10 * d3) - (d11 * d2);
        double d14 = -((d11 * d3) + (d10 * d2));
        double d15 = d9;
        double d16 = d14;
        double i2 = a.i(d12, d15, d11 * d8, d13);
        double d17 = d12;
        double d18 = i2;
        double i3 = a.i(d11, d15, d10 * d8, d16);
        double d19 = (-d18) / i3;
        double d20 = (d19 * d10) + d11;
        double d21 = (d19 * d11) + d17;
        double d22 = (d19 * d16) + d13;
        double i4 = a.i(d21, d5, d20 * d4, d22);
        double i5 = a.i(d21, d7, d20 * d6, d22);
        double d23 = (i4 * i3) / (i5 - i4);
        double d24 = d16 + d23;
        double d25 = 2.0d / i5;
        double d26 = 1.0d / (i3 + d23);
        double d27 = ((d26 + d26) * d23) / (1.0d - (d23 * d26));
        double d28 = d10 * d26;
        double d29 = d11 * d26;
        double d30 = d26 * d24;
        double d31 = d27 + 1.0d;
        double d32 = d31 * d28;
        double d33 = d31 * d29;
        double d34 = (d31 * d30) - d27;
        set((d20 * d25) - d28, d32, 0.0d, d28, (d21 * d25) - d29, d33, 0.0d, d29, 0.0d, 0.0d, 1.0d, 0.0d, (d25 * d22) - d30, d34, 0.0d, d30);
        this.properties = 0;
        return this;
    }

    public Vector4d unproject(double d2, double d3, double d4, int[] iArr, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d5 = this.m00;
        double d6 = this.m11;
        double d7 = d5 * d6;
        double d8 = this.m01;
        double d9 = this.m10;
        double d10 = d7 - (d8 * d9);
        double d11 = this.m12;
        double d12 = d5 * d11;
        double d13 = d10;
        double d14 = this.m02;
        double d15 = d12 - (d14 * d9);
        double d16 = this.m13;
        double d17 = d5 * d16;
        double d18 = d5;
        double d19 = this.m03;
        double d20 = d17 - (d19 * d9);
        double d21 = (d8 * d11) - (d14 * d6);
        double d22 = (d8 * d16) - (d19 * d6);
        double d23 = (d14 * d16) - (d19 * d11);
        double d24 = d9;
        double d25 = this.m20;
        double d26 = d19;
        double d27 = this.m31;
        double d28 = d25 * d27;
        double d29 = d14;
        double d30 = this.m21;
        double d31 = d8;
        double d32 = this.m30;
        double d33 = d28 - (d30 * d32);
        double d34 = d16;
        double d35 = this.m32;
        double d36 = d25 * d35;
        double d37 = d11;
        double d38 = this.m22;
        double d39 = d36 - (d38 * d32);
        double d40 = d6;
        double d41 = this.m33;
        double d42 = d25 * d41;
        double d43 = d25;
        double d44 = this.m23;
        double d45 = d42 - (d44 * d32);
        double d46 = (d30 * d35) - (d38 * d27);
        double d47 = (d30 * d41) - (d44 * d27);
        double d48 = (d38 * d41) - (d44 * d35);
        double d49 = d23;
        double d50 = d33;
        double l = a.l(d49, d50, ((d21 * d45) + ((d20 * d46) + ((d13 * d48) - (d15 * d47)))) - (d22 * d39), 1.0d);
        double d51 = d35;
        double d52 = d34;
        double d53 = l;
        double k = a.k(d52, d46, (d40 * d48) - (d37 * d47), d53);
        double d54 = d31;
        double d55 = d32;
        double d56 = d26;
        double d57 = d46;
        double d58 = l;
        double c2 = a.c(d56, d57, (d29 * d47) + ((-d54) * d48), d58);
        double d59 = d21;
        double k2 = a.k(d41, d59, (d27 * d23) - (d51 * d22), d58);
        double d60 = d54;
        double d61 = d44;
        double c3 = a.c(d61, d59, (d38 * d22) + ((-d30) * d23), d58);
        double d62 = d24;
        double d63 = c2;
        double d64 = d30;
        double d65 = d62;
        double d66 = d60;
        double c4 = a.c(d52, d39, (d37 * d45) + ((-d62) * d48), d53);
        double k3 = a.k(d26, d39, (d18 * d48) - (d29 * d45), d58);
        double d67 = d55;
        double d68 = d27;
        double d69 = d41;
        double d70 = d15;
        double c5 = a.c(d69, d70, (d51 * d20) + ((-d67) * d23), d58);
        double k4 = a.k(d44, d70, (d43 * d23) - (d38 * d20), d58);
        double d71 = c5;
        double d72 = d67;
        double k5 = a.k(d52, d33, (d65 * d47) - (d40 * d45), d53);
        double d73 = d18;
        double d74 = d38;
        double d75 = d26;
        double d76 = d33;
        double c6 = a.c(d75, d76, (d45 * d66) + ((-d73) * d47), d58);
        double d77 = d73;
        double d78 = d13;
        double k6 = a.k(d41, d78, (d72 * d22) - (d68 * d20), d53);
        double d79 = d43;
        double c7 = a.c(d44, d78, (d20 * d64) + ((-d79) * d22), d53);
        double d80 = (d40 * d39) + ((-d65) * d46);
        double d81 = d79;
        double d82 = d74;
        double c8 = a.c(d37, d33, d80, l);
        double k7 = a.k(d29, d33, (d77 * d46) - (d66 * d39), l);
        double d83 = d13;
        double d84 = l;
        double c9 = a.c(d51, d83, (d68 * d15) + ((-d72) * d21), d84);
        double k8 = a.k(d82, d83, (d81 * d21) - (d64 * d15), d84);
        double d85 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d86 = c9;
        double d87 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double d88 = (d4 + d4) - 1.0d;
        double d89 = c7 * d88;
        double d90 = 1.0d / ((d89 + ((k4 * d87) + (c3 * d85))) + k8);
        double d91 = k5 * d88;
        Vector4d vector4d3 = vector4d;
        vector4d3.x = (d91 + (c4 * d87) + (k * d85) + c8) * d90;
        double d92 = c6 * d88;
        vector4d3.y = (d92 + (k3 * d87) + (d63 * d85) + k7) * d90;
        double d93 = k6 * d88;
        vector4d3.z = (d93 + (d71 * d87) + (k2 * d85) + d86) * d90;
        vector4d3.w = 1.0d;
        return vector4d3;
    }

    public Vector4d unprojectInv(Vector3dc vector3dc, int[] iArr, Vector4d vector4d) {
        return unprojectInv(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector4d);
    }

    public Matrix4d unprojectInvRay(Vector2dc vector2dc, int[] iArr, Vector3d vector3d, Vector3d vector3d2) {
        return unprojectInvRay(vector2dc.x(), vector2dc.y(), iArr, vector3d, vector3d2);
    }

    public Matrix4d unprojectRay(double d2, double d3, int[] iArr, Vector3d vector3d, Vector3d vector3d2) {
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d4 = this.m00;
        double d5 = this.m11;
        double d6 = d4 * d5;
        double d7 = this.m01;
        double d8 = this.m10;
        double d9 = d6 - (d7 * d8);
        double d10 = this.m12;
        double d11 = d4 * d10;
        double d12 = this.m02;
        double d13 = d11 - (d12 * d8);
        double d14 = d9;
        double d15 = this.m13;
        double d16 = d4 * d15;
        double d17 = d4;
        double d18 = this.m03;
        double d19 = d16 - (d18 * d8);
        double d20 = (d7 * d10) - (d12 * d5);
        double d21 = (d7 * d15) - (d18 * d5);
        double d22 = (d12 * d15) - (d18 * d10);
        double d23 = d8;
        double d24 = this.m20;
        double d25 = d18;
        double d26 = this.m31;
        double d27 = d24 * d26;
        double d28 = d12;
        double d29 = this.m21;
        double d30 = d7;
        double d31 = this.m30;
        double d32 = d27 - (d29 * d31);
        double d33 = d15;
        double d34 = this.m32;
        double d35 = d24 * d34;
        double d36 = d10;
        double d37 = this.m22;
        double d38 = d35 - (d37 * d31);
        double d39 = d5;
        double d40 = this.m33;
        double d41 = d24 * d40;
        double d42 = d24;
        double d43 = this.m23;
        double d44 = d41 - (d43 * d31);
        double d45 = (d29 * d34) - (d37 * d26);
        double d46 = (d29 * d40) - (d43 * d26);
        double d47 = (d37 * d40) - (d43 * d34);
        double d48 = d22;
        double d49 = d32;
        double l = a.l(d48, d49, ((d20 * d44) + ((d19 * d45) + ((d14 * d47) - (d13 * d46)))) - (d21 * d38), 1.0d);
        double k = a.k(d33, d45, (d39 * d47) - (d36 * d46), l);
        double d50 = d31;
        double d51 = d30;
        double d52 = d43;
        double d53 = d25;
        double d54 = d45;
        double c2 = a.c(d53, d54, (d28 * d46) + ((-d51) * d47), l);
        double d55 = d20;
        double d56 = l;
        double k2 = a.k(d40, d55, (d26 * d22) - (d34 * d21), d56);
        double d57 = c2;
        double d58 = d52;
        double c3 = a.c(d58, d55, (d37 * d21) + ((-d29) * d22), d56);
        double d59 = d23;
        double d60 = d29;
        double c4 = a.c(d33, d38, (d36 * d44) + ((-d59) * d47), l);
        double k3 = a.k(d25, d38, (d17 * d47) - (d28 * d44), l);
        double d61 = d50;
        double d62 = d26;
        double d63 = d40;
        double d64 = d13;
        double c5 = a.c(d63, d64, (d34 * d19) + ((-d61) * d22), d56);
        double k4 = a.k(d52, d64, (d42 * d22) - (d37 * d19), d56);
        double k5 = a.k(d33, d32, (d59 * d46) - (d39 * d44), l);
        double d65 = c5;
        double d66 = d17;
        double d67 = d37;
        double d68 = d25;
        double d69 = d32;
        double d70 = l;
        double c6 = a.c(d68, d69, (d44 * d51) + ((-d66) * d46), d70);
        double d71 = d14;
        double d72 = l;
        double d73 = d42;
        double k6 = a.k(d40, d71, (d61 * d21) - (d62 * d19), d72);
        double d74 = d52;
        double c7 = a.c(d74, d71, (d19 * d60) + ((-d73) * d21), d72);
        double d75 = (d39 * d38) + ((-d59) * d45);
        double d76 = d73;
        double c8 = a.c(d36, d32, d75, l);
        double k7 = a.k(d28, d32, (d66 * d45) - (d51 * d38), d70);
        double d77 = d34;
        double d78 = d14;
        double d79 = l;
        double c9 = a.c(d77, d78, (d62 * d13) + ((-d61) * d20), d79);
        double k8 = a.k(d67, d78, (d76 * d20) - (d60 * d13), d79);
        double d80 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d81 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double i2 = a.i(c4, d81, k * d80, c8);
        double i3 = a.i(k3, d81, d57 * d80, k7);
        double i4 = a.i(d65, d81, k2 * d80, c9);
        double d82 = (k4 * d81) + (d80 * c3);
        double d83 = 1.0d / ((d82 - c7) + k8);
        double d84 = (i2 - k5) * d83;
        double d85 = (i3 - c6) * d83;
        double d86 = d83 * (i4 - k6);
        double d87 = 1.0d / ((d82 + c7) + k8);
        double d88 = (i2 + k5) * d87;
        double d89 = (i3 + c6) * d87;
        double d90 = (i4 + k6) * d87;
        Vector3d vector3d5 = vector3d;
        vector3d5.x = d84;
        vector3d5.y = d85;
        vector3d5.z = d86;
        Vector3d vector3d6 = vector3d2;
        vector3d6.x = d88 - d84;
        vector3d6.y = d89 - d85;
        vector3d6.z = d90 - d86;
        return this;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeDouble(this.m00);
        objectOutput.writeDouble(this.m01);
        objectOutput.writeDouble(this.m02);
        objectOutput.writeDouble(this.m03);
        objectOutput.writeDouble(this.m10);
        objectOutput.writeDouble(this.m11);
        objectOutput.writeDouble(this.m12);
        objectOutput.writeDouble(this.m13);
        objectOutput.writeDouble(this.m20);
        objectOutput.writeDouble(this.m21);
        objectOutput.writeDouble(this.m22);
        objectOutput.writeDouble(this.m23);
        objectOutput.writeDouble(this.m30);
        objectOutput.writeDouble(this.m31);
        objectOutput.writeDouble(this.m32);
        objectOutput.writeDouble(this.m33);
    }

    public Matrix4d zero() {
        this.m00 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = 0.0d;
        this.m03 = 0.0d;
        this.m10 = 0.0d;
        this.m11 = 0.0d;
        this.m12 = 0.0d;
        this.m13 = 0.0d;
        this.m20 = 0.0d;
        this.m21 = 0.0d;
        this.m22 = 0.0d;
        this.m23 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 0.0d;
        this.properties = 0;
        return this;
    }

    public Matrix4d add(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = matrix4dc.m00() + this.m00;
        matrix4d.m01 = matrix4dc.m01() + this.m01;
        matrix4d.m02 = matrix4dc.m02() + this.m02;
        matrix4d.m03 = matrix4dc.m03() + this.m03;
        matrix4d.m10 = matrix4dc.m10() + this.m10;
        matrix4d.m11 = matrix4dc.m11() + this.m11;
        matrix4d.m12 = matrix4dc.m12() + this.m12;
        matrix4d.m13 = matrix4dc.m13() + this.m13;
        matrix4d.m20 = matrix4dc.m20() + this.m20;
        matrix4d.m21 = matrix4dc.m21() + this.m21;
        matrix4d.m22 = matrix4dc.m22() + this.m22;
        matrix4d.m23 = matrix4dc.m23() + this.m23;
        matrix4d.m30 = matrix4dc.m30() + this.m30;
        matrix4d.m31 = matrix4dc.m31() + this.m31;
        matrix4d.m32 = matrix4dc.m32() + this.m32;
        matrix4d.m33 = matrix4dc.m33() + this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d add4x3(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = matrix4dc.m00() + this.m00;
        matrix4d.m01 = matrix4dc.m01() + this.m01;
        matrix4d.m02 = matrix4dc.m02() + this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = matrix4dc.m10() + this.m10;
        matrix4d.m11 = matrix4dc.m11() + this.m11;
        matrix4d.m12 = matrix4dc.m12() + this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = matrix4dc.m20() + this.m20;
        matrix4d.m21 = matrix4dc.m21() + this.m21;
        matrix4d.m22 = matrix4dc.m22() + this.m22;
        matrix4d.m23 = this.m23;
        matrix4d.m30 = matrix4dc.m30() + this.m30;
        matrix4d.m31 = matrix4dc.m31() + this.m31;
        matrix4d.m32 = matrix4dc.m32() + this.m32;
        matrix4d.m33 = this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d fma4x3(Matrix4dc matrix4dc, double d2, Matrix4d matrix4d) {
        matrix4d.m00 = (matrix4dc.m00() * d2) + this.m00;
        matrix4d.m01 = (matrix4dc.m01() * d2) + this.m01;
        matrix4d.m02 = (matrix4dc.m02() * d2) + this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = (matrix4dc.m10() * d2) + this.m10;
        matrix4d.m11 = (matrix4dc.m11() * d2) + this.m11;
        matrix4d.m12 = (matrix4dc.m12() * d2) + this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = (matrix4dc.m20() * d2) + this.m20;
        matrix4d.m21 = (matrix4dc.m21() * d2) + this.m21;
        matrix4d.m22 = (matrix4dc.m22() * d2) + this.m22;
        matrix4d.m23 = this.m23;
        matrix4d.m30 = (matrix4dc.m30() * d2) + this.m30;
        matrix4d.m31 = (matrix4dc.m31() * d2) + this.m31;
        matrix4d.m32 = (matrix4dc.m32() * d2) + this.m32;
        matrix4d.m33 = this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public DoubleBuffer get(DoubleBuffer doubleBuffer) {
        return get(doubleBuffer.position(), doubleBuffer);
    }

    public DoubleBuffer get4x3Transposed(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public ByteBuffer getFloats(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putf(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix4dc) this);
    }

    public DoubleBuffer getTransposed(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix4dc) this);
    }

    public Matrix4d invert(Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.identity();
        }
        if ((i2 & 8) != 0) {
            return invertTranslation(matrix4d);
        }
        if ((i2 & 16) != 0) {
            return invertOrthonormal(matrix4d);
        }
        if ((i2 & 2) != 0) {
            return invertAffine(matrix4d);
        }
        if ((i2 & 1) != 0) {
            return invertPerspective(matrix4d);
        }
        return invertGeneric(matrix4d);
    }

    public Matrix4d lerp(Matrix4dc matrix4dc, double d2, Matrix4d matrix4d) {
        matrix4d.m00 = a.h(matrix4dc.m00(), this.m00, d2, this.m00);
        double d3 = d2;
        matrix4d.m01 = a.h(matrix4dc.m01(), this.m01, d3, this.m01);
        matrix4d.m02 = a.h(matrix4dc.m02(), this.m02, d3, this.m02);
        matrix4d.m03 = a.h(matrix4dc.m03(), this.m03, d3, this.m03);
        matrix4d.m10 = a.h(matrix4dc.m10(), this.m10, d3, this.m10);
        matrix4d.m11 = a.h(matrix4dc.m11(), this.m11, d3, this.m11);
        matrix4d.m12 = a.h(matrix4dc.m12(), this.m12, d3, this.m12);
        matrix4d.m13 = a.h(matrix4dc.m13(), this.m13, d3, this.m13);
        matrix4d.m20 = a.h(matrix4dc.m20(), this.m20, d3, this.m20);
        matrix4d.m21 = a.h(matrix4dc.m21(), this.m21, d3, this.m21);
        matrix4d.m22 = a.h(matrix4dc.m22(), this.m22, d3, this.m22);
        matrix4d.m23 = a.h(matrix4dc.m23(), this.m23, d3, this.m23);
        matrix4d.m30 = a.h(matrix4dc.m30(), this.m30, d3, this.m30);
        matrix4d.m31 = a.h(matrix4dc.m31(), this.m31, d3, this.m31);
        matrix4d.m32 = a.h(matrix4dc.m32(), this.m32, d3, this.m32);
        matrix4d.m33 = a.h(matrix4dc.m33(), this.m33, d3, this.m33);
        matrix4d.properties = matrix4dc.properties() & this.properties;
        return matrix4d;
    }

    public Matrix4d lookAlong(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d) {
        return lookAlong(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4d);
    }

    public Matrix4d lookAt(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return lookAt(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), this);
    }

    public Matrix4d lookAtLH(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        return lookAtLH(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), this);
    }

    public Matrix4d m00(double d2) {
        this.m00 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4d m01(double d2) {
        this.m01 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m02(double d2) {
        this.m02 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m03(double d2) {
        this.m03 = d2;
        if (d2 != 0.0d) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4d m10(double d2) {
        this.m10 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m11(double d2) {
        this.m11 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4d m12(double d2) {
        this.m12 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m13(double d2) {
        this.m13 = d2;
        if (this.m03 != 0.0d) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4d m20(double d2) {
        this.m20 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m21(double d2) {
        this.m21 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 0.0d) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4d m22(double d2) {
        this.m22 = d2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (d2 != 1.0d) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4d m23(double d2) {
        this.m23 = d2;
        if (d2 != 0.0d) {
            this.properties &= -31;
        }
        return this;
    }

    public Matrix4d m30(double d2) {
        this.m30 = d2;
        if (d2 != 0.0d) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4d m31(double d2) {
        this.m31 = d2;
        if (d2 != 0.0d) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4d m32(double d2) {
        this.m32 = d2;
        if (d2 != 0.0d) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4d m33(double d2) {
        this.m33 = d2;
        if (d2 != 0.0d) {
            this.properties &= -2;
        }
        if (d2 != 1.0d) {
            this.properties &= -31;
        }
        return this;
    }

    public Matrix4d mul(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.set(matrix4dc);
        }
        if ((matrix4dc.properties() & 4) != 0) {
            return matrix4d.set((Matrix4dc) this);
        }
        if ((this.properties & 8) != 0 && (matrix4dc.properties() & 2) != 0) {
            return mulTranslationAffine(matrix4dc, matrix4d);
        }
        if ((this.properties & 2) != 0 && (matrix4dc.properties() & 2) != 0) {
            return mulAffine(matrix4dc, matrix4d);
        }
        if ((this.properties & 1) != 0 && (matrix4dc.properties() & 2) != 0) {
            return mulPerspectiveAffine(matrix4dc, matrix4d);
        }
        if ((matrix4dc.properties() & 2) != 0) {
            return mulAffineR(matrix4dc, matrix4d);
        }
        return mulGeneric(matrix4dc, matrix4d);
    }

    public Matrix4d mul4x3ComponentWise(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = matrix4dc.m00() * this.m00;
        matrix4d.m01 = matrix4dc.m01() * this.m01;
        matrix4d.m02 = matrix4dc.m02() * this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = matrix4dc.m10() * this.m10;
        matrix4d.m11 = matrix4dc.m11() * this.m11;
        matrix4d.m12 = matrix4dc.m12() * this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = matrix4dc.m20() * this.m20;
        matrix4d.m21 = matrix4dc.m21() * this.m21;
        matrix4d.m22 = matrix4dc.m22() * this.m22;
        matrix4d.m23 = this.m23;
        matrix4d.m30 = matrix4dc.m30() * this.m30;
        matrix4d.m31 = matrix4dc.m31() * this.m31;
        matrix4d.m32 = matrix4dc.m32() * this.m32;
        matrix4d.m33 = this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d mulAffine(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m022 = (matrix4dc.m02() * this.m20) + (matrix4dc.m01() * this.m10) + (matrix4dc.m00() * this.m00);
        double m023 = (matrix4dc.m02() * this.m21) + (matrix4dc.m01() * this.m11) + (matrix4dc.m00() * this.m01);
        double m024 = (matrix4dc.m02() * this.m22) + (matrix4dc.m01() * this.m12) + (matrix4dc.m00() * this.m02);
        double d2 = this.m03;
        double m122 = (matrix4dc.m12() * this.m20) + (matrix4dc.m11() * this.m10) + (matrix4dc.m10() * this.m00);
        double m123 = (matrix4dc.m12() * this.m21) + (matrix4dc.m11() * this.m11) + (matrix4dc.m10() * this.m01);
        double m124 = (matrix4dc.m12() * this.m22) + (matrix4dc.m11() * this.m12) + (matrix4dc.m10() * this.m02);
        double d3 = this.m13;
        double m222 = (matrix4dc.m22() * this.m20) + (matrix4dc.m21() * this.m10) + (matrix4dc.m20() * this.m00);
        double m223 = (matrix4dc.m22() * this.m21) + (matrix4dc.m21() * this.m11) + (matrix4dc.m20() * this.m01);
        double m224 = (matrix4dc.m22() * this.m22) + (matrix4dc.m21() * this.m12) + (matrix4dc.m20() * this.m02);
        double d4 = this.m23;
        double m322 = (matrix4dc.m32() * this.m20) + (matrix4dc.m31() * this.m10) + (matrix4dc.m30() * this.m00) + this.m30;
        double m323 = (matrix4dc.m32() * this.m21) + (matrix4dc.m31() * this.m11) + (matrix4dc.m30() * this.m01) + this.m31;
        double m324 = (matrix4dc.m32() * this.m22) + (matrix4dc.m31() * this.m12) + (matrix4dc.m30() * this.m02) + this.m32;
        double d5 = this.m33;
        matrix4d2.m00 = m022;
        matrix4d2.m01 = m023;
        matrix4d2.m02 = m024;
        matrix4d2.m03 = d2;
        matrix4d2.m10 = m122;
        matrix4d2.m11 = m123;
        matrix4d2.m12 = m124;
        matrix4d2.m13 = d3;
        matrix4d2.m20 = m222;
        matrix4d2.m21 = m223;
        matrix4d2.m22 = m224;
        matrix4d2.m23 = d4;
        matrix4d2.m30 = m322;
        matrix4d2.m31 = m323;
        matrix4d2.m32 = m324;
        matrix4d2.m33 = d5;
        matrix4d2.properties = (this.properties & matrix4dc.properties() & 16) | 2;
        return matrix4d2;
    }

    public Matrix4d mulAffineR(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m022 = (matrix4dc.m02() * this.m20) + (matrix4dc.m01() * this.m10) + (matrix4dc.m00() * this.m00);
        double m023 = (matrix4dc.m02() * this.m21) + (matrix4dc.m01() * this.m11) + (matrix4dc.m00() * this.m01);
        double m024 = (matrix4dc.m02() * this.m22) + (matrix4dc.m01() * this.m12) + (matrix4dc.m00() * this.m02);
        double m025 = (matrix4dc.m02() * this.m23) + (matrix4dc.m01() * this.m13) + (matrix4dc.m00() * this.m03);
        double m122 = (matrix4dc.m12() * this.m20) + (matrix4dc.m11() * this.m10) + (matrix4dc.m10() * this.m00);
        double m123 = (matrix4dc.m12() * this.m21) + (matrix4dc.m11() * this.m11) + (matrix4dc.m10() * this.m01);
        double m124 = (matrix4dc.m12() * this.m22) + (matrix4dc.m11() * this.m12) + (matrix4dc.m10() * this.m02);
        double m125 = (matrix4dc.m12() * this.m23) + (matrix4dc.m11() * this.m13) + (matrix4dc.m10() * this.m03);
        double m222 = (matrix4dc.m22() * this.m20) + (matrix4dc.m21() * this.m10) + (matrix4dc.m20() * this.m00);
        double m223 = (matrix4dc.m22() * this.m21) + (matrix4dc.m21() * this.m11) + (matrix4dc.m20() * this.m01);
        double m224 = (matrix4dc.m22() * this.m22) + (matrix4dc.m21() * this.m12) + (matrix4dc.m20() * this.m02);
        double m225 = (matrix4dc.m22() * this.m23) + (matrix4dc.m21() * this.m13) + (matrix4dc.m20() * this.m03);
        double m322 = (matrix4dc.m32() * this.m20) + (matrix4dc.m31() * this.m10) + (matrix4dc.m30() * this.m00) + this.m30;
        double m323 = (matrix4dc.m32() * this.m21) + (matrix4dc.m31() * this.m11) + (matrix4dc.m30() * this.m01) + this.m31;
        double m324 = (matrix4dc.m32() * this.m22) + (matrix4dc.m31() * this.m12) + (matrix4dc.m30() * this.m02) + this.m32;
        double m325 = (matrix4dc.m32() * this.m23) + (matrix4dc.m31() * this.m13) + (matrix4dc.m30() * this.m03) + this.m33;
        matrix4d2.m00 = m022;
        matrix4d2.m01 = m023;
        matrix4d2.m02 = m024;
        matrix4d2.m03 = m025;
        matrix4d2.m10 = m122;
        matrix4d2.m11 = m123;
        matrix4d2.m12 = m124;
        matrix4d2.m13 = m125;
        matrix4d2.m20 = m222;
        matrix4d2.m21 = m223;
        matrix4d2.m22 = m224;
        matrix4d2.m23 = m225;
        matrix4d2.m30 = m322;
        matrix4d2.m31 = m323;
        matrix4d2.m32 = m324;
        matrix4d2.m33 = m325;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    public Matrix4d mulComponentWise(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = matrix4dc.m00() * this.m00;
        matrix4d.m01 = matrix4dc.m01() * this.m01;
        matrix4d.m02 = matrix4dc.m02() * this.m02;
        matrix4d.m03 = matrix4dc.m03() * this.m03;
        matrix4d.m10 = matrix4dc.m10() * this.m10;
        matrix4d.m11 = matrix4dc.m11() * this.m11;
        matrix4d.m12 = matrix4dc.m12() * this.m12;
        matrix4d.m13 = matrix4dc.m13() * this.m13;
        matrix4d.m20 = matrix4dc.m20() * this.m20;
        matrix4d.m21 = matrix4dc.m21() * this.m21;
        matrix4d.m22 = matrix4dc.m22() * this.m22;
        matrix4d.m23 = matrix4dc.m23() * this.m23;
        matrix4d.m30 = matrix4dc.m30() * this.m30;
        matrix4d.m31 = matrix4dc.m31() * this.m31;
        matrix4d.m32 = matrix4dc.m32() * this.m32;
        matrix4d.m33 = matrix4dc.m33() * this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d mulLocal(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.set(matrix4dc);
        }
        if ((matrix4dc.properties() & 4) != 0) {
            return matrix4d.set((Matrix4dc) this);
        }
        if ((this.properties & 2) == 0 || (matrix4dc.properties() & 2) == 0) {
            return mulLocalGeneric(matrix4dc, matrix4d);
        }
        return mulLocalAffine(matrix4dc, matrix4d);
    }

    public Matrix4d mulLocalAffine(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m202 = (matrix4dc.m20() * this.m02) + (matrix4dc.m10() * this.m01) + (matrix4dc.m00() * this.m00);
        double m212 = (matrix4dc.m21() * this.m02) + (matrix4dc.m11() * this.m01) + (matrix4dc.m01() * this.m00);
        double m222 = (matrix4dc.m22() * this.m02) + (matrix4dc.m12() * this.m01) + (matrix4dc.m02() * this.m00);
        double m032 = matrix4dc.m03();
        double m203 = (matrix4dc.m20() * this.m12) + (matrix4dc.m10() * this.m11) + (matrix4dc.m00() * this.m10);
        double d2 = m203;
        double m213 = (matrix4dc.m21() * this.m12) + (matrix4dc.m11() * this.m11) + (matrix4dc.m01() * this.m10);
        double m223 = (matrix4dc.m22() * this.m12) + (matrix4dc.m12() * this.m11) + (matrix4dc.m02() * this.m10);
        double m132 = matrix4dc.m13();
        double d3 = m223;
        double m204 = (matrix4dc.m20() * this.m22) + (matrix4dc.m10() * this.m21) + (matrix4dc.m00() * this.m20);
        double d4 = m204;
        double m214 = (matrix4dc.m21() * this.m22) + (matrix4dc.m11() * this.m21) + (matrix4dc.m01() * this.m20);
        double m224 = (matrix4dc.m22() * this.m22) + (matrix4dc.m12() * this.m21) + (matrix4dc.m02() * this.m20);
        double m232 = matrix4dc.m23();
        double d5 = m224;
        double m302 = matrix4dc.m30() + (matrix4dc.m20() * this.m32) + (matrix4dc.m10() * this.m31) + (matrix4dc.m00() * this.m30);
        double d6 = m302;
        double m312 = matrix4dc.m31() + (matrix4dc.m21() * this.m32) + (matrix4dc.m11() * this.m31) + (matrix4dc.m01() * this.m30);
        double d7 = m312;
        double m322 = matrix4dc.m32() + (matrix4dc.m22() * this.m32) + (matrix4dc.m12() * this.m31) + (matrix4dc.m02() * this.m30);
        double m332 = matrix4dc.m33();
        matrix4d2.m00 = m202;
        matrix4d2.m01 = m212;
        matrix4d2.m02 = m222;
        matrix4d2.m03 = m032;
        matrix4d2.m10 = d2;
        matrix4d2.m11 = m213;
        matrix4d2.m12 = d3;
        matrix4d2.m13 = m132;
        matrix4d2.m20 = d4;
        matrix4d2.m21 = m214;
        matrix4d2.m22 = d5;
        matrix4d2.m23 = m232;
        matrix4d2.m30 = d6;
        matrix4d2.m31 = d7;
        matrix4d2.m32 = m322;
        matrix4d2.m33 = m332;
        matrix4d2.properties = 2;
        return matrix4d2;
    }

    public Matrix4d mulOrthoAffine(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m002 = matrix4dc.m00() * this.m00;
        double m012 = matrix4dc.m01() * this.m11;
        double m022 = matrix4dc.m02() * this.m22;
        double m102 = matrix4dc.m10() * this.m00;
        double m112 = matrix4dc.m11() * this.m11;
        double m122 = matrix4dc.m12() * this.m22;
        double m202 = this.m00 * matrix4dc.m20();
        double m212 = this.m11 * matrix4dc.m21();
        double m222 = this.m22 * matrix4dc.m22();
        double m302 = (matrix4dc.m30() * this.m00) + this.m30;
        double m312 = (matrix4dc.m31() * this.m11) + this.m31;
        double m322 = (matrix4dc.m32() * this.m22) + this.m32;
        matrix4d2.m00 = m002;
        matrix4d2.m01 = m012;
        matrix4d2.m02 = m022;
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = m102;
        matrix4d2.m11 = m112;
        matrix4d2.m12 = m122;
        matrix4d2.m13 = 0.0d;
        matrix4d2.m20 = m202;
        matrix4d2.m21 = m212;
        matrix4d2.m22 = m222;
        matrix4d2.m23 = 0.0d;
        matrix4d2.m30 = m302;
        matrix4d2.m31 = m312;
        matrix4d2.m32 = m322;
        matrix4d2.m33 = 1.0d;
        matrix4d2.properties = 2;
        return matrix4d2;
    }

    public Matrix4d mulPerspectiveAffine(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m002 = matrix4dc.m00() * this.m00;
        double m012 = matrix4dc.m01() * this.m11;
        double m022 = matrix4dc.m02() * this.m22;
        double m023 = matrix4dc.m02() * this.m23;
        double m102 = matrix4dc.m10() * this.m00;
        double m112 = matrix4dc.m11() * this.m11;
        double m122 = this.m22 * matrix4dc.m12();
        double m123 = this.m23 * matrix4dc.m12();
        double m202 = this.m00 * matrix4dc.m20();
        double m212 = this.m11 * matrix4dc.m21();
        double m222 = this.m22 * matrix4dc.m22();
        double m223 = this.m23 * matrix4dc.m22();
        double m302 = this.m00 * matrix4dc.m30();
        double m312 = this.m11 * matrix4dc.m31();
        double m322 = (matrix4dc.m32() * this.m22) + this.m32;
        double m323 = this.m23 * matrix4dc.m32();
        matrix4d2.m00 = m002;
        matrix4d2.m01 = m012;
        matrix4d2.m02 = m022;
        matrix4d2.m03 = m023;
        matrix4d2.m10 = m102;
        matrix4d2.m11 = m112;
        matrix4d2.m12 = m122;
        matrix4d2.m13 = m123;
        matrix4d2.m20 = m202;
        matrix4d2.m21 = m212;
        matrix4d2.m22 = m222;
        matrix4d2.m23 = m223;
        matrix4d2.m30 = m302;
        matrix4d2.m31 = m312;
        matrix4d2.m32 = m322;
        matrix4d2.m33 = m323;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    public Matrix4d normal(Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.identity();
        }
        if ((i2 & 16) != 0) {
            return normalOrthonormal(matrix4d);
        }
        return normalGeneric(matrix4d);
    }

    public Matrix4d normalize3x3(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = this.m00 * e2;
        matrix4d2.m01 = this.m01 * e2;
        matrix4d2.m02 = this.m02 * e2;
        matrix4d2.m10 = this.m10 * e3;
        matrix4d2.m11 = this.m11 * e3;
        matrix4d2.m12 = this.m12 * e3;
        matrix4d2.m20 = this.m20 * e4;
        matrix4d2.m21 = this.m21 * e4;
        matrix4d2.m22 = this.m22 * e4;
        return matrix4d2;
    }

    public Matrix4d rotateAffineXYZ(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m20 = (d26 * d17) + (d29 * d7);
        matrix4d2.m21 = (d27 * d17) + (d31 * d7);
        matrix4d2.m22 = (d28 * d17) + (d34 * d7);
        matrix4d2.m23 = 0.0d;
        matrix4d2.m00 = (d13 * d11) + (d30 * cosFromSin3);
        matrix4d2.m01 = (d19 * d11) + (d32 * cosFromSin3);
        matrix4d2.m02 = (d33 * d11) + (d35 * cosFromSin3);
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = (d13 * cosFromSin3) + (d30 * d8);
        matrix4d2.m11 = (d19 * cosFromSin3) + (d32 * d8);
        matrix4d2.m12 = (d33 * cosFromSin3) + (d35 * d8);
        matrix4d2.m13 = 0.0d;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateAffineYXZ(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m20 = (d12 * d16) + (d28 * d6);
        matrix4d3.m21 = (d18 * d16) + (d30 * d6);
        matrix4d3.m22 = (d24 * d16) + (d32 * d6);
        matrix4d3.m23 = 0.0d;
        matrix4d3.m00 = (d29 * d10) + (d25 * cosFromSin3);
        matrix4d3.m01 = (d31 * d10) + (d26 * cosFromSin3);
        matrix4d3.m02 = (d33 * d10) + (d27 * cosFromSin3);
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = (d29 * cosFromSin3) + (d25 * d7);
        matrix4d3.m11 = (d31 * cosFromSin3) + (d26 * d7);
        matrix4d3.m12 = (d33 * cosFromSin3) + (d27 * d7);
        matrix4d3.m13 = 0.0d;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateAffineZYX(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m00 = (d30 * d7) + (d13 * d14);
        matrix4d2.m01 = (d34 * d7) + (d19 * d14);
        matrix4d2.m02 = (d38 * d7) + (d25 * d14);
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = (d31 * d11) + (d26 * d6);
        matrix4d2.m11 = (d35 * d11) + (d37 * d6);
        matrix4d2.m12 = (d39 * d11) + (d33 * d6);
        matrix4d2.m13 = 0.0d;
        matrix4d2.m20 = (d31 * d6) + (d26 * d8);
        matrix4d2.m21 = (d35 * d6) + (d37 * d8);
        matrix4d2.m22 = (d39 * d6) + (d33 * d8);
        matrix4d2.m23 = 0.0d;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateAround(Quaterniondc quaterniondc, double d2, double d3, double d4, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return rotationAround(quaterniondc, d2, d3, d4);
        }
        if ((i2 & 2) != 0) {
            return rotateAroundAffine(quaterniondc, d2, d3, d4, this);
        }
        return rotateAroundGeneric(quaterniondc, d2, d3, d4, this);
    }

    public Matrix4d rotateTowards(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return rotateTowards(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), this);
    }

    public Matrix4d rotateTowardsXY(double d2, double d3, Matrix4d matrix4d) {
        double d4 = d2;
        double d5 = d3;
        Matrix4d matrix4d2 = matrix4d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d2.rotationTowardsXY(d4, d5);
        }
        double d6 = -d4;
        double d7 = this.m00;
        double d8 = d7 * d5;
        double d9 = this.m10;
        double d10 = d8 + (d9 * d4);
        double d11 = this.m01;
        double d12 = d11 * d5;
        double d13 = d11;
        double d14 = this.m11;
        double d15 = d14;
        double d16 = (d14 * d4) + d12;
        double d17 = this.m02;
        double d18 = d17 * d5;
        double d19 = d17;
        double d20 = this.m12;
        double d21 = d20;
        double d22 = (d20 * d4) + d18;
        double d23 = this.m03;
        double d24 = d23 * d5;
        double d25 = d23;
        double d26 = this.m13;
        double d27 = (d4 * d26) + d24;
        matrix4d2.m10 = (d9 * d5) + (d7 * d6);
        matrix4d2.m11 = (d15 * d5) + (d13 * d6);
        matrix4d2.m12 = (d21 * d5) + (d19 * d6);
        matrix4d2.m13 = (d26 * d5) + (d6 * d25);
        matrix4d2.m00 = d10;
        matrix4d2.m01 = d16;
        matrix4d2.m02 = d22;
        matrix4d2.m03 = d27;
        matrix4d2.m20 = this.m20;
        matrix4d2.m21 = this.m21;
        matrix4d2.m22 = this.m22;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = i2 & -14;
        return matrix4d2;
    }

    public Matrix4d rotateXYZ(double d2, double d3, double d4) {
        return rotateXYZ(d2, d3, d4, this);
    }

    public Matrix4d rotateYXZ(double d2, double d3, double d4) {
        return rotateYXZ(d2, d3, d4, this);
    }

    public Matrix4d rotateZYX(double d2, double d3, double d4) {
        return rotateZYX(d2, d3, d4, this);
    }

    public Matrix4d rotationTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
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
        if ((this.properties & 4) == 0) {
            _identity();
        }
        this.m00 = d16;
        this.m01 = d17;
        this.m02 = d18;
        this.m10 = d19;
        this.m11 = d21;
        this.m12 = d23;
        this.m20 = d10;
        this.m21 = d22;
        this.m22 = d20;
        this.properties = 18;
        return this;
    }

    public Matrix4d scale(Vector3dc vector3dc) {
        return scale(vector3dc.x(), vector3dc.y(), vector3dc.z(), this);
    }

    public Matrix4d scaling(double d2, double d3, double d4) {
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
        this.properties = i2 | 2;
        return this;
    }

    public Matrix4d setLookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
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
        this.m03 = 0.0d;
        this.m10 = d18;
        this.m11 = d22;
        this.m12 = d12;
        this.m13 = 0.0d;
        this.m20 = d23;
        this.m21 = d24;
        this.m22 = d21;
        this.m23 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d setLookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
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
        double d28 = d14;
        this.m03 = 0.0d;
        this.m10 = d21;
        this.m11 = d25;
        this.m12 = d15;
        this.m13 = 0.0d;
        double d29 = d26;
        this.m20 = d29;
        this.m21 = d27;
        double d30 = d15;
        this.m22 = d24;
        this.m23 = 0.0d;
        double d31 = d29 * d4;
        this.m30 = -(d31 + (d21 * d3) + (d20 * d2));
        double d32 = d27 * d4;
        this.m31 = -(d32 + (d25 * d3) + (d23 * d2));
        double d33 = d24 * d4;
        this.m32 = -(d33 + (d30 * d3) + (d28 * d2));
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d setLookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
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
        double d28 = d14;
        this.m03 = 0.0d;
        this.m10 = d21;
        this.m11 = d25;
        this.m12 = d15;
        this.m13 = 0.0d;
        double d29 = d26;
        this.m20 = d29;
        this.m21 = d27;
        double d30 = d15;
        this.m22 = d24;
        this.m23 = 0.0d;
        double d31 = d29 * d4;
        this.m30 = -(d31 + (d21 * d3) + (d20 * d2));
        double d32 = d27 * d4;
        this.m31 = -(d32 + (d25 * d3) + (d23 * d2));
        double d33 = d24 * d4;
        this.m32 = -(d33 + (d30 * d3) + (d28 * d2));
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d shadow(Vector4dc vector4dc, double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d sub(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00 - matrix4dc.m00();
        matrix4d.m01 = this.m01 - matrix4dc.m01();
        matrix4d.m02 = this.m02 - matrix4dc.m02();
        matrix4d.m03 = this.m03 - matrix4dc.m03();
        matrix4d.m10 = this.m10 - matrix4dc.m10();
        matrix4d.m11 = this.m11 - matrix4dc.m11();
        matrix4d.m12 = this.m12 - matrix4dc.m12();
        matrix4d.m13 = this.m13 - matrix4dc.m13();
        matrix4d.m20 = this.m20 - matrix4dc.m20();
        matrix4d.m21 = this.m21 - matrix4dc.m21();
        matrix4d.m22 = this.m22 - matrix4dc.m22();
        matrix4d.m23 = this.m23 - matrix4dc.m23();
        matrix4d.m30 = this.m30 - matrix4dc.m30();
        matrix4d.m31 = this.m31 - matrix4dc.m31();
        matrix4d.m32 = this.m32 - matrix4dc.m32();
        matrix4d.m33 = this.m33 - matrix4dc.m33();
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d sub4x3(Matrix4dc matrix4dc, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00 - matrix4dc.m00();
        matrix4d.m01 = this.m01 - matrix4dc.m01();
        matrix4d.m02 = this.m02 - matrix4dc.m02();
        matrix4d.m03 = this.m03;
        matrix4d.m10 = this.m10 - matrix4dc.m10();
        matrix4d.m11 = this.m11 - matrix4dc.m11();
        matrix4d.m12 = this.m12 - matrix4dc.m12();
        matrix4d.m13 = this.m13;
        matrix4d.m20 = this.m20 - matrix4dc.m20();
        matrix4d.m21 = this.m21 - matrix4dc.m21();
        matrix4d.m22 = this.m22 - matrix4dc.m22();
        matrix4d.m23 = this.m23;
        matrix4d.m30 = this.m30 - matrix4dc.m30();
        matrix4d.m31 = this.m31 - matrix4dc.m31();
        matrix4d.m32 = this.m32 - matrix4dc.m32();
        matrix4d.m33 = this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Vector4d transform(Vector4dc vector4dc, Vector4d vector4d) {
        return vector4dc.mul((Matrix4dc) this, vector4d);
    }

    public Vector4d transformAffine(Vector4dc vector4dc, Vector4d vector4d) {
        return transformAffine(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), vector4d);
    }

    public Vector3d transformDirection(Vector3dc vector3dc, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((vector3dc.z() * this.m20) + (vector3dc.y() * this.m10) + (vector3dc.x() * this.m00), (vector3dc.z() * this.m21) + (vector3dc.y() * this.m11) + (vector3dc.x() * this.m01), (vector3dc.z() * this.m22) + (vector3dc.y() * this.m12) + (vector3dc.x() * this.m02));
        return vector3d;
    }

    public Vector3d transformPosition(Vector3dc vector3dc, Vector3d vector3d) {
        return transformPosition(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3d);
    }

    public Vector4d transformProject(Vector4dc vector4dc, Vector4d vector4d) {
        return vector4dc.mulProject(this, vector4d);
    }

    public Matrix4d translate(Vector3dc vector3dc, Matrix4d matrix4d) {
        return translate(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4d);
    }

    public Matrix4d translateLocal(Vector3fc vector3fc, Matrix4d matrix4d) {
        return translateLocal((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4d);
    }

    public Matrix4d translationRotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
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
        this.m03 = 0.0d;
        this.m10 = d22;
        this.m11 = d24;
        this.m12 = d26;
        this.m13 = 0.0d;
        this.m20 = d13;
        this.m21 = d25;
        this.m22 = d23;
        this.m23 = 0.0d;
        this.m30 = d2;
        this.m31 = d3;
        this.m32 = d4;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d transpose(Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.identity();
        }
        return transposeGeneric(matrix4d);
    }

    public Matrix4d transpose3x3(Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = this.m00;
        double d3 = this.m10;
        double d4 = this.m20;
        double d5 = this.m01;
        double d6 = this.m11;
        double d7 = this.m21;
        double d8 = this.m02;
        double d9 = this.m12;
        double d10 = this.m22;
        matrix4d2.m00 = d2;
        matrix4d2.m01 = d3;
        matrix4d2.m02 = d4;
        matrix4d2.m10 = d5;
        matrix4d2.m11 = d6;
        matrix4d2.m12 = d7;
        matrix4d2.m20 = d8;
        matrix4d2.m21 = d9;
        matrix4d2.m22 = d10;
        matrix4d2.properties = this.properties & 30;
        return matrix4d2;
    }

    public Vector4d unprojectInv(double d2, double d3, double d4, int[] iArr, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d5 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d6 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double d7 = (d4 + d4) - 1.0d;
        double d8 = 1.0d / (((this.m23 * d7) + ((this.m13 * d6) + (this.m03 * d5))) + this.m33);
        vector4d2.x = ((this.m20 * d7) + (this.m10 * d6) + (this.m00 * d5) + this.m30) * d8;
        vector4d2.y = ((this.m21 * d7) + (this.m11 * d6) + (this.m01 * d5) + this.m31) * d8;
        vector4d2.z = ((this.m22 * d7) + (this.m12 * d6) + (this.m02 * d5) + this.m32) * d8;
        vector4d2.w = 1.0d;
        return vector4d2;
    }

    public Matrix4d unprojectInvRay(double d2, double d3, int[] iArr, Vector3d vector3d, Vector3d vector3d2) {
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d4 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d5 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double d6 = (this.m10 * d5) + (this.m00 * d4) + this.m30;
        double d7 = (this.m11 * d5) + (this.m01 * d4) + this.m31;
        double d8 = (this.m12 * d5) + (this.m02 * d4) + this.m32;
        double d9 = this.m03;
        double d10 = d9 * d4;
        double d11 = this.m13;
        double d12 = (d11 * d5) + d10;
        double d13 = d11;
        double d14 = this.m23;
        double d15 = d12 - d14;
        double d16 = d14;
        double d17 = this.m33;
        double d18 = 1.0d / (d15 + d17);
        double d19 = d17;
        double d20 = this.m20;
        double d21 = d20;
        double d22 = (d6 - d20) * d18;
        double d23 = this.m21;
        double d24 = d23;
        double d25 = (d7 - d23) * d18;
        double d26 = this.m22;
        double d27 = (d8 - d26) * d18;
        double d28 = 1.0d / ((((d13 * d5) + (d9 * d4)) + d16) + d19);
        double d29 = (d6 + d21) * d28;
        double d30 = (d7 + d24) * d28;
        double d31 = (d8 + d26) * d28;
        Vector3d vector3d5 = vector3d;
        double d32 = d22;
        vector3d5.x = d32;
        double d33 = d25;
        vector3d5.y = d33;
        vector3d5.z = d27;
        Vector3d vector3d6 = vector3d2;
        vector3d6.x = d29 - d32;
        vector3d6.y = d30 - d33;
        vector3d6.z = d31 - d27;
        return this;
    }

    private Matrix3d normalOrthonormal(Matrix3d matrix3d) {
        matrix3d.set((Matrix4dc) this);
        return matrix3d;
    }

    public DoubleBuffer get(int i2, DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.put(this, i2, doubleBuffer);
        return doubleBuffer;
    }

    public ByteBuffer get4x3Transposed(ByteBuffer byteBuffer) {
        return get4x3Transposed(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer getTransposed(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Matrix4d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.setLookAlong(d2, d3, d4, d5, d6, d7);
        }
        return lookAlongGeneric(d2, d3, d4, d5, d6, d7, matrix4d);
    }

    public Matrix4d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.setLookAt(d2, d3, d4, d5, d6, d7, d8, d9, d10);
        }
        if ((i2 & 1) != 0) {
            return lookAtPerspective(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4d);
        }
        return lookAtGeneric(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4d);
    }

    public Matrix4d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.setLookAtLH(d2, d3, d4, d5, d6, d7, d8, d9, d10);
        }
        if ((i2 & 1) != 0) {
            return lookAtPerspectiveLH(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4d);
        }
        return lookAtLHGeneric(d2, d3, d4, d5, d6, d7, d8, d9, d10, matrix4d);
    }

    public Matrix4d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7) {
        return rotateTowards(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d rotateXYZ(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotationXYZ(d2, d3, d4);
        }
        if ((i2 & 2) != 0) {
            return matrix4d.rotateAffineXYZ(d2, d3, d4);
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
        double d25 = (d24 * sin) + d22;
        double d26 = d24;
        double d27 = this.m13;
        double d28 = d27 * cosFromSin;
        double d29 = d27;
        double d30 = this.m23;
        double d31 = (sin * d30) + d28;
        double d32 = (d12 * cosFromSin) + (d9 * d5);
        double d33 = (d20 * cosFromSin) + (d15 * d5);
        double d34 = (d26 * cosFromSin) + (d23 * d5);
        double d35 = (d30 * cosFromSin) + (d29 * d5);
        double d36 = this.m00;
        double d37 = (d32 * d14) + (d36 * d17);
        double d38 = this.m01;
        double d39 = (d33 * d14) + (d38 * d17);
        double d40 = d31;
        double d41 = this.m02;
        double d42 = (d34 * d14) + (d41 * d17);
        double d43 = d37;
        double d44 = this.m03;
        double d45 = (d14 * d35) + (d44 * d17);
        matrix4d2.m20 = (d32 * d17) + (d36 * d7);
        matrix4d2.m21 = (d33 * d17) + (d38 * d7);
        matrix4d2.m22 = (d34 * d17) + (d41 * d7);
        matrix4d2.m23 = (d35 * d17) + (d44 * d7);
        matrix4d2.m00 = (d13 * d11) + (d43 * cosFromSin3);
        matrix4d2.m01 = (d19 * d11) + (d39 * cosFromSin3);
        matrix4d2.m02 = (d25 * d11) + (d42 * cosFromSin3);
        matrix4d2.m03 = (d40 * d11) + (d45 * cosFromSin3);
        matrix4d2.m10 = (d13 * cosFromSin3) + (d43 * d8);
        matrix4d2.m11 = (d19 * cosFromSin3) + (d39 * d8);
        matrix4d2.m12 = (d25 * cosFromSin3) + (d42 * d8);
        matrix4d2.m13 = (d40 * cosFromSin3) + (d45 * d8);
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotateYXZ(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotationYXZ(d2, d3, d4);
        }
        if ((i2 & 2) != 0) {
            return matrix4d.rotateAffineYXZ(d2, d3, d4);
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
        double d21 = d20 * sin2;
        double d22 = d20;
        double d23 = this.m22;
        double d24 = (d23 * cosFromSin2) + d21;
        double d25 = d23;
        double d26 = this.m03;
        double d27 = sin2 * d26;
        double d28 = d26;
        double d29 = this.m23;
        double d30 = (d29 * cosFromSin2) + d27;
        double d31 = (d11 * d5) + (d8 * cosFromSin2);
        double d32 = (d19 * d5) + (d14 * cosFromSin2);
        double d33 = (d25 * d5) + (d22 * cosFromSin2);
        double d34 = (d29 * d5) + (d28 * cosFromSin2);
        double d35 = this.m10;
        double d36 = (d12 * d13) + (d35 * d16);
        double d37 = this.m11;
        double d38 = (d18 * d13) + (d37 * d16);
        double d39 = d34;
        double d40 = this.m12;
        double d41 = (d24 * d13) + (d40 * d16);
        double d42 = d33;
        double d43 = this.m13;
        double d44 = (d13 * d30) + (d43 * d16);
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m20 = (d12 * d16) + (d35 * d6);
        matrix4d3.m21 = (d18 * d16) + (d37 * d6);
        matrix4d3.m22 = (d24 * d16) + (d40 * d6);
        matrix4d3.m23 = (d30 * d16) + (d43 * d6);
        matrix4d3.m00 = (d36 * d10) + (d31 * cosFromSin3);
        matrix4d3.m01 = (d38 * d10) + (d32 * cosFromSin3);
        matrix4d3.m02 = (d41 * d10) + (d42 * cosFromSin3);
        matrix4d3.m03 = (d44 * d10) + (d39 * cosFromSin3);
        matrix4d3.m10 = (d36 * cosFromSin3) + (d31 * d7);
        matrix4d3.m11 = (d38 * cosFromSin3) + (d32 * d7);
        matrix4d3.m12 = (d41 * cosFromSin3) + (d42 * d7);
        matrix4d3.m13 = (d44 * cosFromSin3) + (d39 * d7);
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateZYX(double d2, double d3, double d4, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotationZYX(d2, d3, d4);
        }
        if ((i2 & 2) != 0) {
            return matrix4d.rotateAffineZYX(d2, d3, d4);
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
        double d25 = (d24 * sin3) + d22;
        double d26 = d24;
        double d27 = this.m03;
        double d28 = d27 * cosFromSin3;
        double d29 = d27;
        double d30 = this.m13;
        double d31 = (sin3 * d30) + d28;
        double d32 = (d12 * cosFromSin3) + (d9 * d5);
        double d33 = (d20 * cosFromSin3) + (d15 * d5);
        double d34 = (d26 * cosFromSin3) + (d23 * d5);
        double d35 = (d30 * cosFromSin3) + (d29 * d5);
        double d36 = d13 * d17;
        double d37 = this.m20;
        double d38 = (d37 * d14) + d36;
        double d39 = d19 * d17;
        double d40 = d35;
        double d41 = this.m21;
        double d42 = (d41 * d14) + d39;
        double d43 = d25 * d17;
        double d44 = d33;
        double d45 = this.m22;
        double d46 = (d45 * d14) + d43;
        double d47 = d31 * d17;
        double d48 = d38;
        double d49 = this.m23;
        double d50 = (d49 * d14) + d47;
        matrix4d2.m00 = (d37 * d7) + (d13 * d14);
        matrix4d2.m01 = (d41 * d7) + (d19 * d14);
        matrix4d2.m02 = (d45 * d7) + (d25 * d14);
        matrix4d2.m03 = (d49 * d7) + (d31 * d14);
        matrix4d2.m10 = (d48 * d11) + (d32 * d6);
        matrix4d2.m11 = (d42 * d11) + (d44 * d6);
        matrix4d2.m12 = (d46 * d11) + (d34 * d6);
        matrix4d2.m13 = (d50 * d11) + (d40 * d6);
        matrix4d2.m20 = (d48 * d6) + (d32 * d8);
        matrix4d2.m21 = (d42 * d6) + (d44 * d8);
        matrix4d2.m22 = (d46 * d6) + (d34 * d8);
        matrix4d2.m23 = (d50 * d6) + (d40 * d8);
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d scale(double d2, double d3, double d4, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.scaling(d2, d3, d4);
        }
        return scaleGeneric(d2, d3, d4, matrix4d);
    }

    public Matrix4d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return shadow(d2, d3, d4, d5, d6, d7, d8, d9, this);
    }

    public Vector4d transform(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        vector4d2.set((this.m30 * d5) + (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2), (this.m31 * d5) + (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2), (this.m32 * d5) + (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2), (this.m33 * d5) + (this.m23 * d4) + (this.m13 * d3) + (this.m03 * d2));
        return vector4d;
    }

    public Vector4d transformAffine(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        double d6 = (this.m30 * d5) + (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2);
        double d7 = (this.m31 * d5) + (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2);
        double d8 = (this.m32 * d5) + (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2);
        vector4d.x = d6;
        vector4d.y = d7;
        vector4d.z = d8;
        vector4d.w = d5;
        return vector4d;
    }

    public Vector3d transformPosition(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30, (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31, (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32);
        return vector3d;
    }

    public Vector4d transformProject(double d2, double d3, double d4, double d5, Vector4d vector4d) {
        double d6 = d5;
        double l = a.l(this.m33, d5, (this.m23 * d4) + (this.m13 * d3) + (this.m03 * d2), 1.0d);
        Vector4d vector4d2 = vector4d;
        vector4d2.set(a.k(this.m30, d6, (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2), l), a.k(this.m31, d6, (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2), l), a.k(this.m32, d6, (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2), l), 1.0d);
        return vector4d;
    }

    public Matrix4d translate(Vector3fc vector3fc) {
        return translate((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4d translateLocal(Vector3dc vector3dc) {
        return translateLocal(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        return frustum(d2, d3, d4, d5, d6, d7, false, matrix4d);
    }

    public Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return frustumLH(d2, d3, d4, d5, d6, d7, z, this);
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public ByteBuffer get4x3Transposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4d invertPerspective() {
        return invertPerspective(this);
    }

    public Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        return ortho(d2, d3, d4, d5, d6, d7, false, matrix4d);
    }

    public Matrix4d ortho2D(double d2, double d3, double d4, double d5) {
        return ortho2D(d2, d3, d4, d5, this);
    }

    public Matrix4d ortho2DLH(double d2, double d3, double d4, double d5) {
        return ortho2DLH(d2, d3, d4, d5, this);
    }

    public Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        return orthoLH(d2, d3, d4, d5, d6, d7, false, matrix4d);
    }

    public Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return orthoSymmetric(d2, d3, d4, d5, false, matrix4d);
    }

    public Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return orthoSymmetricLH(d2, d3, d4, d5, false, matrix4d);
    }

    public Matrix4d perspective(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return perspective(d2, d3, d4, d5, false, matrix4d);
    }

    public Matrix4d perspectiveLH(double d2, double d3, double d4, double d5, boolean z) {
        return perspectiveLH(d2, d3, d4, d5, z, this);
    }

    public Matrix4d rotateLocal(double d2, double d3, double d4, double d5) {
        return rotateLocal(d2, d3, d4, d5, this);
    }

    public Matrix4d rotateTowards(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = this.m33;
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
        double d42 = d41 * d16;
        double d43 = d41;
        double d44 = this.m12;
        double d45 = (d44 * d17) + d42;
        double d46 = d44;
        double d47 = this.m22;
        double d48 = d47;
        double d49 = (d47 * d18) + d45;
        double d50 = this.m03;
        double d51 = d16 * d50;
        double d52 = d50;
        double d53 = this.m13;
        double d54 = (d17 * d53) + d51;
        double d55 = this.m23;
        double d56 = (d18 * d55) + d54;
        double d57 = (d30 * d21) + (d26 * d20) + (d23 * d19);
        double d58 = (d39 * d21) + (d37 * d20) + (d34 * d19);
        double d59 = d58;
        double d60 = (d48 * d21) + (d46 * d20) + (d43 * d19);
        double d61 = d21 * d55;
        double d62 = d61 + (d20 * d53) + (d19 * d52);
        matrix4d2.m20 = (d30 * d22) + (d26 * d25) + (d23 * d28);
        matrix4d2.m21 = (d39 * d22) + (d37 * d25) + (d34 * d28);
        matrix4d2.m22 = (d48 * d22) + (d46 * d25) + (d43 * d28);
        double d63 = d55 * d22;
        matrix4d2.m23 = d63 + (d53 * d25) + (d52 * d28);
        matrix4d2.m00 = d31;
        matrix4d2.m01 = d40;
        matrix4d2.m02 = d49;
        matrix4d2.m03 = d56;
        matrix4d2.m10 = d57;
        matrix4d2.m11 = d59;
        matrix4d2.m12 = d60;
        matrix4d2.m13 = d62;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d scaleLocal(double d2, Matrix4d matrix4d) {
        return scaleLocal(d2, d2, d2, matrix4d);
    }

    public Matrix4d shadow(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d66 = d65 * d21;
        double d67 = d65;
        double d68 = this.m12;
        double d69 = (d68 * d23) + d66;
        double d70 = d68;
        double d71 = this.m22;
        double d72 = (d71 * d24) + d69;
        double d73 = d71;
        double d74 = this.m32;
        double d75 = d74;
        double d76 = (d74 * d25) + d72;
        double d77 = this.m03;
        double d78 = d21 * d77;
        double d79 = d77;
        double d80 = this.m13;
        double d81 = (d23 * d80) + d78;
        double d82 = this.m23;
        double d83 = (d24 * d82) + d81;
        double d84 = d82;
        double d85 = this.m33;
        double d86 = (d25 * d85) + d83;
        double d87 = d86;
        double d88 = (d51 * d49) + (d47 * d29) + (d44 * d28) + (d41 * d27);
        double d89 = d88;
        double d90 = (d63 * d49) + (d61 * d29) + (d58 * d28) + (d55 * d27);
        double d91 = d90;
        double d92 = (d75 * d49) + (d73 * d29) + (d70 * d28) + (d67 * d27);
        double d93 = (d85 * d49) + (d84 * d29) + (d28 * d80) + (d79 * d27);
        double d94 = d93;
        double d95 = (d51 * d46) + (d47 * d34) + (d44 * d33) + (d41 * d32);
        double d96 = d95;
        double d97 = (d63 * d46) + (d61 * d34) + (d58 * d33) + (d55 * d32);
        double d98 = d97;
        double d99 = (d75 * d46) + (d73 * d34) + (d70 * d33) + (d67 * d32);
        double d100 = d34 * d84;
        double d101 = d85 * d46;
        double d102 = d99;
        double d103 = d101 + d100 + (d33 * d80) + (d79 * d32);
        double d104 = d47 * d43;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m30 = (d51 * d40) + d104 + (d44 * d38) + (d41 * d37);
        matrix4d3.m31 = (d63 * d40) + (d61 * d43) + (d58 * d38) + (d55 * d37);
        matrix4d3.m32 = (d75 * d40) + (d73 * d43) + (d70 * d38) + (d67 * d37);
        double d105 = d85 * d40;
        matrix4d3.m33 = d105 + (d84 * d43) + (d80 * d38) + (d79 * d37);
        matrix4d3.m00 = d52;
        matrix4d3.m01 = d64;
        matrix4d3.m02 = d76;
        matrix4d3.m03 = d87;
        matrix4d3.m10 = d89;
        matrix4d3.m11 = d91;
        matrix4d3.m12 = d92;
        matrix4d3.m13 = d94;
        matrix4d3.m20 = d96;
        matrix4d3.m21 = d98;
        matrix4d3.m22 = d102;
        matrix4d3.m23 = d103;
        matrix4d3.properties = this.properties & -30;
        return matrix4d3;
    }

    public Matrix4d translate(Vector3fc vector3fc, Matrix4d matrix4d) {
        return translate((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4d);
    }

    public Matrix4d translateLocal(Vector3dc vector3dc, Matrix4d matrix4d) {
        return translateLocal(vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4d);
    }

    public Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return frustum(d2, d3, d4, d5, d6, d7, z, this);
    }

    public Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        return frustumLH(d2, d3, d4, d5, d6, d7, false, matrix4d);
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putf(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Matrix4d obliqueZ(double d2, double d3, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00;
        matrix4d.m01 = this.m01;
        matrix4d.m02 = this.m02;
        matrix4d.m03 = this.m03;
        matrix4d.m10 = this.m10;
        matrix4d.m11 = this.m11;
        matrix4d.m12 = this.m12;
        matrix4d.m13 = this.m13;
        matrix4d.m20 = (this.m10 * d3) + (this.m00 * d2) + this.m20;
        matrix4d.m21 = (this.m11 * d3) + (this.m01 * d2) + this.m21;
        matrix4d.m22 = (this.m12 * d3) + (this.m02 * d2) + this.m22;
        matrix4d.m23 = this.m23;
        matrix4d.m30 = this.m30;
        matrix4d.m31 = this.m31;
        matrix4d.m32 = this.m32;
        matrix4d.m33 = this.m33;
        matrix4d.properties &= 2;
        return matrix4d;
    }

    public Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return ortho(d2, d3, d4, d5, d6, d7, z, this);
    }

    public Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7, boolean z) {
        return orthoLH(d2, d3, d4, d5, d6, d7, z, this);
    }

    public Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5, boolean z) {
        return orthoSymmetric(d2, d3, d4, d5, z, this);
    }

    public Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5, boolean z) {
        return orthoSymmetricLH(d2, d3, d4, d5, z, this);
    }

    public Matrix4d perspective(double d2, double d3, double d4, double d5, boolean z) {
        return perspective(d2, d3, d4, d5, z, this);
    }

    public Matrix4d perspectiveLH(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return perspectiveLH(d2, d3, d4, d5, false, matrix4d);
    }

    public Matrix4d rotateLocal(Quaterniondc quaterniondc, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d3 = a2;
        double b4 = a.b(w, x, z, y);
        double d4 = d2 + d3;
        double d5 = b2 - a3;
        double d6 = (-d3) + d2;
        double f2 = a.f(y, z, w, x);
        double d7 = b3 + a4;
        double d8 = a3 + b2;
        double d9 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d10 = this.m00;
        double d11 = b4 * d10;
        double d12 = this.m01;
        double d13 = (d6 * d12) + d11;
        double d14 = this.m02;
        double d15 = (d8 * d14) + d13;
        double d16 = (d9 * d14) + (f2 * d12) + (d4 * d10);
        double d17 = d14 * g2;
        double d18 = d17 + (d12 * d7) + (d10 * d5);
        double d19 = this.m03;
        double d20 = this.m10;
        double d21 = b4 * d20;
        double d22 = d19;
        double d23 = this.m11;
        double d24 = (d6 * d23) + d21;
        double d25 = d18;
        double d26 = this.m12;
        double d27 = d16;
        double d28 = (d8 * d26) + d24;
        double d29 = (d9 * d26) + (f2 * d23) + (d4 * d20);
        double d30 = d26 * g2;
        double d31 = d30 + (d23 * d7) + (d20 * d5);
        double d32 = this.m13;
        double d33 = this.m20;
        double d34 = b4 * d33;
        double d35 = d32;
        double d36 = this.m21;
        double d37 = (d6 * d36) + d34;
        double d38 = d31;
        double d39 = this.m22;
        double d40 = d29;
        double d41 = (d8 * d39) + d37;
        double d42 = (d9 * d39) + (f2 * d36) + (d4 * d33);
        double d43 = d39 * g2;
        double d44 = d43 + (d36 * d7) + (d33 * d5);
        double d45 = this.m23;
        double d46 = this.m30;
        double d47 = b4 * d46;
        double d48 = d45;
        double d49 = this.m31;
        double d50 = (d6 * d49) + d47;
        double d51 = d44;
        double d52 = this.m32;
        double d53 = d9 * d52;
        double d54 = (d8 * d52) + d50;
        double d55 = d53 + (f2 * d49) + (d4 * d46);
        double d56 = g2 * d52;
        double d57 = d56 + (d7 * d49) + (d5 * d46);
        double d58 = this.m33;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = d15;
        matrix4d3.m01 = d27;
        matrix4d3.m02 = d25;
        matrix4d3.m03 = d22;
        matrix4d3.m10 = d28;
        matrix4d3.m11 = d40;
        matrix4d3.m12 = d38;
        matrix4d3.m13 = d35;
        matrix4d3.m20 = d41;
        matrix4d3.m21 = d42;
        matrix4d3.m22 = d51;
        matrix4d3.m23 = d48;
        matrix4d3.m30 = d54;
        matrix4d3.m31 = d55;
        matrix4d3.m32 = d57;
        matrix4d3.m33 = d58;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d scaleLocal(double d2) {
        return scaleLocal(d2, this);
    }

    public Matrix4d setTranslation(Vector3dc vector3dc) {
        return setTranslation(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3d transformProject(Vector3d vector3d) {
        return vector3d.mulProject((Matrix4dc) this);
    }

    public Matrix4d translate(double d2, double d3, double d4, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.translation(d2, d3, d4);
        }
        return translateGeneric(d2, d3, d4, matrix4d);
    }

    public Matrix4d translateLocal(double d2, double d3, double d4, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.translation(d2, d3, d4);
        }
        return translateLocalGeneric(d2, d3, d4, matrix4d);
    }

    public Matrix4d frustum(double d2, double d3, double d4, double d5, double d6, double d7) {
        return frustum(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d frustumLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return frustumLH(d2, d3, d4, d5, d6, d7, this);
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Matrix4d invertFrustum() {
        return invertFrustum(this);
    }

    public Matrix4d invertOrtho() {
        return invertOrtho(this);
    }

    public Matrix4d lookAlong(double d2, double d3, double d4, double d5, double d6, double d7) {
        return lookAlong(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix3d normal(Matrix3d matrix3d) {
        if ((this.properties & 16) != 0) {
            return normalOrthonormal(matrix3d);
        }
        return normalGeneric(matrix3d);
    }

    public Matrix4d ortho(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ortho(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d orthoLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return orthoLH(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d orthoSymmetric(double d2, double d3, double d4, double d5) {
        return orthoSymmetric(d2, d3, d4, d5, false, this);
    }

    public Matrix4d orthoSymmetricLH(double d2, double d3, double d4, double d5) {
        return orthoSymmetricLH(d2, d3, d4, d5, false, this);
    }

    public Matrix4d perspective(double d2, double d3, double d4, double d5) {
        return perspective(d2, d3, d4, d5, this);
    }

    public Matrix4d perspectiveLH(double d2, double d3, double d4, double d5) {
        return perspectiveLH(d2, d3, d4, d5, this);
    }

    public Matrix4d reflect(double d2, double d3, double d4, double d5) {
        return reflect(d2, d3, d4, d5, this);
    }

    public Matrix4d rotate(double d2, double d3, double d4, double d5) {
        return rotate(d2, d3, d4, d5, this);
    }

    public Matrix4d rotateZ(double d2) {
        return rotateZ(d2, this);
    }

    public Matrix4d scale(double d2, double d3, double d4) {
        return scale(d2, d3, d4, this);
    }

    public Matrix4d scaleLocal(double d2, double d3, double d4) {
        return scaleLocal(d2, d3, d4, this);
    }

    public Vector3d transformDirection(double d2, double d3, double d4, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        vector3d2.set((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2), (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2), (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2));
        return vector3d;
    }

    public Vector3d transformProject(Vector3dc vector3dc, Vector3d vector3d) {
        return vector3dc.mulProject((Matrix4dc) this, vector3d);
    }

    public Matrix4d(Matrix4dc matrix4dc) {
        this.m00 = matrix4dc.m00();
        this.m01 = matrix4dc.m01();
        this.m02 = matrix4dc.m02();
        this.m03 = matrix4dc.m03();
        this.m10 = matrix4dc.m10();
        this.m11 = matrix4dc.m11();
        this.m12 = matrix4dc.m12();
        this.m13 = matrix4dc.m13();
        this.m20 = matrix4dc.m20();
        this.m21 = matrix4dc.m21();
        this.m22 = matrix4dc.m22();
        this.m23 = matrix4dc.m23();
        this.m30 = matrix4dc.m30();
        this.m31 = matrix4dc.m31();
        this.m32 = matrix4dc.m32();
        this.m33 = matrix4dc.m33();
        this.properties = matrix4dc.properties();
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4d lookAt(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return lookAt(d2, d3, d4, d5, d6, d7, d8, d9, d10, this);
    }

    public Matrix4d lookAtLH(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        return lookAtLH(d2, d3, d4, d5, d6, d7, d8, d9, d10, this);
    }

    public Matrix4d reflect(double d2, double d3, double d4, double d5, double d6, double d7) {
        return reflect(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d rotate(Quaterniondc quaterniondc, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotation(quaterniondc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaterniondc, matrix4d);
        }
        if ((i2 & 2) != 0) {
            return rotateAffine(quaterniondc, matrix4d);
        }
        return rotateGeneric(quaterniondc, matrix4d);
    }

    public Matrix4d scale(double d2, Matrix4d matrix4d) {
        return scale(d2, d2, d2, matrix4d);
    }

    public Vector3f transformDirection(Vector3f vector3f) {
        return vector3f.mulDirection((Matrix4dc) this);
    }

    public Vector3d transformProject(double d2, double d3, double d4, Vector3d vector3d) {
        double d5 = 1.0d / (((this.m23 * d4) + ((this.m13 * d3) + (this.m03 * d2))) + this.m33);
        Vector3d vector3d2 = vector3d;
        vector3d2.set(((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30) * d5, ((this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31) * d5, ((this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32) * d5);
        return vector3d;
    }

    public Planed frustumPlane(int i2, Planed planed) {
        if (i2 == 0) {
            planed.set(this.m03 + this.m00, this.m13 + this.m10, this.m23 + this.m20, this.m33 + this.m30).normalize(planed);
        } else if (i2 == 1) {
            planed.set(this.m03 - this.m00, this.m13 - this.m10, this.m23 - this.m20, this.m33 - this.m30).normalize(planed);
        } else if (i2 == 2) {
            planed.set(this.m03 + this.m01, this.m13 + this.m11, this.m23 + this.m21, this.m33 + this.m31).normalize(planed);
        } else if (i2 == 3) {
            planed.set(this.m03 - this.m01, this.m13 - this.m11, this.m23 - this.m21, this.m33 - this.m31).normalize(planed);
        } else if (i2 == 4) {
            planed.set(this.m03 + this.m02, this.m13 + this.m12, this.m23 + this.m22, this.m33 + this.m32).normalize(planed);
        } else if (i2 == 5) {
            planed.set(this.m03 - this.m02, this.m13 - this.m12, this.m23 - this.m22, this.m33 - this.m32).normalize(planed);
        } else {
            throw new IllegalArgumentException("which");
        }
        return planed;
    }

    public double[] get(double[] dArr, int i2) {
        dArr[i2 + 0] = this.m00;
        dArr[i2 + 1] = this.m01;
        dArr[i2 + 2] = this.m02;
        dArr[i2 + 3] = this.m03;
        dArr[i2 + 4] = this.m10;
        dArr[i2 + 5] = this.m11;
        dArr[i2 + 6] = this.m12;
        dArr[i2 + 7] = this.m13;
        dArr[i2 + 8] = this.m20;
        dArr[i2 + 9] = this.m21;
        dArr[i2 + 10] = this.m22;
        dArr[i2 + 11] = this.m23;
        dArr[i2 + 12] = this.m30;
        dArr[i2 + 13] = this.m31;
        dArr[i2 + 14] = this.m32;
        dArr[i2 + 15] = this.m33;
        return dArr;
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

    public Matrix4d reflect(double d2, double d3, double d4, double d5, double d6, double d7, Matrix4d matrix4d) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        return reflect(d10, d11, d12, (((-d10) * d5) - (d11 * d6)) - (d12 * d7), matrix4d);
    }

    public Matrix4d scale(double d2) {
        return scale(d2, d2, d2);
    }

    public Matrix4d setOrthoSymmetric(double d2, double d3, double d4, double d5) {
        return setOrthoSymmetric(d2, d3, d4, d5, false);
    }

    public Matrix4d setOrthoSymmetricLH(double d2, double d3, double d4, double d5) {
        return setOrthoSymmetricLH(d2, d3, d4, d5, false);
    }

    public Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f) {
        return vector3fc.mulDirection((Matrix4dc) this, vector3f);
    }

    public Matrix4d translate(double d2, double d3, double d4) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return translation(d2, d3, d4);
        }
        this.m30 = (this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30;
        this.m31 = (this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31;
        this.m32 = (this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32;
        this.m33 = (this.m23 * d4) + (this.m13 * d3) + (this.m03 * d2) + this.m33;
        this.properties = i2 & -6;
        return this;
    }

    public Matrix4d translateLocal(double d2, double d3, double d4) {
        return translateLocal(d2, d3, d4, this);
    }

    public Matrix4d translation(Vector3fc vector3fc) {
        return translation((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Vector3d project(double d2, double d3, double d4, int[] iArr, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d5 = 1.0d / (((this.m23 * d4) + ((this.m13 * d3) + (this.m03 * d2))) + this.m33);
        double d6 = ((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2) + this.m30) * d5;
        double d7 = ((this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2) + this.m31) * d5;
        double d8 = ((this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2) + this.m32) * d5;
        vector3d2.x = (((d6 * 0.5d) + 0.5d) * ((double) iArr[2])) + ((double) iArr[0]);
        vector3d2.y = (((d7 * 0.5d) + 0.5d) * ((double) iArr[3])) + ((double) iArr[1]);
        vector3d2.z = (d8 + 1.0d) * 0.5d;
        return vector3d2;
    }

    public Matrix4d reflect(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return reflect(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d scaling(Vector3dc vector3dc) {
        return scaling(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3f transformDirection(double d2, double d3, double d4, Vector3f vector3f) {
        float f2 = (float) ((this.m20 * d4) + (this.m10 * d3) + (this.m00 * d2));
        float f3 = (float) ((this.m21 * d4) + (this.m11 * d3) + (this.m01 * d2));
        float f4 = (float) ((this.m22 * d4) + (this.m12 * d3) + (this.m02 * d2));
        vector3f.x = f2;
        vector3f.y = f3;
        vector3f.z = f4;
        return vector3f;
    }

    public Matrix4d translation(Vector3dc vector3dc) {
        return translation(vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Vector3d unprojectInv(Vector3dc vector3dc, int[] iArr, Vector3d vector3d) {
        return unprojectInv(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector3d);
    }

    public Matrix4d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc) {
        return reflect(quaterniondc, vector3dc, this);
    }

    public Matrix4d setOrtho(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setOrtho(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d setOrthoLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setOrthoLH(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d transformAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d, Vector3d vector3d2) {
        return transformAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3d, vector3d2);
    }

    public Vector3d unprojectInv(double d2, double d3, double d4, int[] iArr, Vector3d vector3d) {
        double d5 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d6 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double d7 = (d4 + d4) - 1.0d;
        double d8 = 1.0d / (((this.m23 * d7) + ((this.m13 * d6) + (this.m03 * d5))) + this.m33);
        vector3d.x = ((this.m20 * d7) + (this.m10 * d6) + (this.m00 * d5) + this.m30) * d8;
        vector3d.y = ((this.m21 * d7) + (this.m11 * d6) + (this.m01 * d5) + this.m31) * d8;
        vector3d.z = ((this.m22 * d7) + (this.m12 * d6) + (this.m02 * d5) + this.m32) * d8;
        return vector3d;
    }

    public Matrix4d reflect(Quaterniondc quaterniondc, Vector3dc vector3dc, Matrix4d matrix4d) {
        double x = quaterniondc.x() + quaterniondc.x();
        double y = quaterniondc.y() + quaterniondc.y();
        double z = quaterniondc.z() + quaterniondc.z();
        return reflect((quaterniondc.w() * y) + (quaterniondc.x() * z), (quaterniondc.y() * z) - (quaterniondc.w() * x), 1.0d - ((quaterniondc.y() * y) + (quaterniondc.x() * x)), vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4d);
    }

    public Matrix4d set3x3(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        this.properties &= -30;
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
        a.b(numberFormat, this.m32, sb, str2);
        a.b(numberFormat, this.m03, sb, str);
        a.b(numberFormat, this.m13, sb, str);
        a.b(numberFormat, this.m23, sb, str);
        return a.a(numberFormat, this.m33, sb, str2);
    }

    public Matrix4d unprojectRay(Vector2dc vector2dc, int[] iArr, Vector3d vector3d, Vector3d vector3d2) {
        return unprojectRay(vector2dc.x(), vector2dc.y(), iArr, vector3d, vector3d2);
    }

    public Matrix4d rotate(Quaternionfc quaternionfc, Matrix4d matrix4d) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4d.rotation(quaternionfc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaternionfc, matrix4d);
        }
        if ((i2 & 2) != 0) {
            return rotateAffine(quaternionfc, matrix4d);
        }
        return rotateGeneric(quaternionfc, matrix4d);
    }

    public Vector3d unproject(double d2, double d3, double d4, int[] iArr, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d5 = this.m00;
        double d6 = this.m11;
        double d7 = d5 * d6;
        double d8 = this.m01;
        double d9 = this.m10;
        double d10 = d7 - (d8 * d9);
        double d11 = this.m12;
        double d12 = d5 * d11;
        double d13 = d10;
        double d14 = this.m02;
        double d15 = d12 - (d14 * d9);
        double d16 = this.m13;
        double d17 = d5 * d16;
        double d18 = d5;
        double d19 = this.m03;
        double d20 = d17 - (d19 * d9);
        double d21 = (d8 * d11) - (d14 * d6);
        double d22 = (d8 * d16) - (d19 * d6);
        double d23 = (d14 * d16) - (d19 * d11);
        double d24 = d9;
        double d25 = this.m20;
        double d26 = d19;
        double d27 = this.m31;
        double d28 = d25 * d27;
        double d29 = d14;
        double d30 = this.m21;
        double d31 = d8;
        double d32 = this.m30;
        double d33 = d28 - (d30 * d32);
        double d34 = d16;
        double d35 = this.m32;
        double d36 = d25 * d35;
        double d37 = d11;
        double d38 = this.m22;
        double d39 = d36 - (d38 * d32);
        double d40 = d6;
        double d41 = this.m33;
        double d42 = d25 * d41;
        double d43 = d25;
        double d44 = this.m23;
        double d45 = d42 - (d44 * d32);
        double d46 = (d30 * d35) - (d38 * d27);
        double d47 = (d30 * d41) - (d44 * d27);
        double d48 = (d38 * d41) - (d44 * d35);
        double d49 = d23;
        double d50 = d33;
        double l = a.l(d49, d50, ((d21 * d45) + ((d20 * d46) + ((d13 * d48) - (d15 * d47)))) - (d22 * d39), 1.0d);
        double d51 = d35;
        double d52 = d34;
        double d53 = l;
        double k = a.k(d52, d46, (d40 * d48) - (d37 * d47), d53);
        double d54 = d31;
        double d55 = d32;
        double d56 = d26;
        double d57 = d46;
        double d58 = l;
        double c2 = a.c(d56, d57, (d29 * d47) + ((-d54) * d48), d58);
        double d59 = d21;
        double k2 = a.k(d41, d59, (d27 * d23) - (d51 * d22), d58);
        double d60 = d54;
        double d61 = d44;
        double c3 = a.c(d61, d59, (d38 * d22) + ((-d30) * d23), d58);
        double d62 = d24;
        double d63 = c2;
        double d64 = d30;
        double d65 = d62;
        double d66 = d60;
        double c4 = a.c(d52, d39, (d37 * d45) + ((-d62) * d48), d53);
        double k3 = a.k(d26, d39, (d18 * d48) - (d29 * d45), d58);
        double d67 = d55;
        double d68 = d27;
        double d69 = d41;
        double d70 = d15;
        double c5 = a.c(d69, d70, (d51 * d20) + ((-d67) * d23), d58);
        double k4 = a.k(d44, d70, (d43 * d23) - (d38 * d20), d58);
        double d71 = c5;
        double d72 = d67;
        double k5 = a.k(d52, d33, (d65 * d47) - (d40 * d45), d53);
        double d73 = d18;
        double d74 = d38;
        double d75 = d26;
        double d76 = d33;
        double c6 = a.c(d75, d76, (d45 * d66) + ((-d73) * d47), d58);
        double d77 = d73;
        double d78 = d13;
        double k6 = a.k(d41, d78, (d72 * d22) - (d68 * d20), d53);
        double d79 = d43;
        double c7 = a.c(d44, d78, (d20 * d64) + ((-d79) * d22), d53);
        double d80 = (d40 * d39) + ((-d65) * d46);
        double d81 = d79;
        double d82 = d74;
        double c8 = a.c(d37, d33, d80, l);
        double k7 = a.k(d29, d33, (d77 * d46) - (d66 * d39), l);
        double d83 = d13;
        double d84 = l;
        double c9 = a.c(d51, d83, (d68 * d15) + ((-d72) * d21), d84);
        double k8 = a.k(d82, d83, (d81 * d21) - (d64 * d15), d84);
        double d85 = (((d2 - ((double) iArr[0])) / ((double) iArr[2])) * 2.0d) - 1.0d;
        double d86 = c9;
        double d87 = (((d3 - ((double) iArr[1])) / ((double) iArr[3])) * 2.0d) - 1.0d;
        double d88 = (d4 + d4) - 1.0d;
        double d89 = c7 * d88;
        double d90 = 1.0d / ((d89 + ((k4 * d87) + (c3 * d85))) + k8);
        double d91 = k5 * d88;
        Vector3d vector3d3 = vector3d;
        vector3d3.x = (d91 + (c4 * d87) + (k * d85) + c8) * d90;
        double d92 = c6 * d88;
        vector3d3.y = (d92 + (k3 * d87) + (d63 * d85) + k7) * d90;
        double d93 = k6 * d88;
        vector3d3.z = (d93 + (d71 * d87) + (k2 * d85) + d86) * d90;
        return vector3d3;
    }

    public Matrix4d set4x3(Matrix4x3fc matrix4x3fc) {
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
        this.properties = matrix4x3fc.properties() & -2 & this.properties;
        return this;
    }

    public Matrix4d mul(Matrix4x3dc matrix4x3dc) {
        return mul(matrix4x3dc, this);
    }

    public Matrix4d rotation(double d2, Vector3dc vector3dc) {
        return rotation(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4d translationRotate(double d2, double d3, double d4, Quaterniondc quaterniondc) {
        return translationRotate(d2, d3, d4, quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w());
    }

    public Matrix4d mul(Matrix4x3dc matrix4x3dc, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.set(matrix4x3dc);
        }
        if ((matrix4x3dc.properties() & 4) != 0) {
            return matrix4d.set((Matrix4dc) this);
        }
        return mulGeneric(matrix4x3dc, matrix4d);
    }

    public Vector4d project(Vector3dc vector3dc, int[] iArr, Vector4d vector4d) {
        return project(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector4d);
    }

    public Matrix4d rotation(double d2, Vector3fc vector3fc) {
        return rotation(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Vector3d project(Vector3dc vector3dc, int[] iArr, Vector3d vector3d) {
        return project(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector3d);
    }

    public Matrix4d rotate(Quaterniondc quaterniondc) {
        return rotate(quaterniondc, this);
    }

    public Matrix4d rotation(AxisAngle4f axisAngle4f) {
        return rotation((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
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

    public Vector3d getRow(int i2, Vector3d vector3d) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3d.x = this.m00;
            vector3d.y = this.m10;
            vector3d.z = this.m20;
        } else if (i2 == 1) {
            vector3d.x = this.m01;
            vector3d.y = this.m11;
            vector3d.z = this.m21;
        } else if (i2 == 2) {
            vector3d.x = this.m02;
            vector3d.y = this.m12;
            vector3d.z = this.m22;
        } else if (i2 == 3) {
            vector3d.x = this.m03;
            vector3d.y = this.m13;
            vector3d.z = this.m23;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3d;
    }

    public Matrix4d pick(double d2, double d3, double d4, double d5, int[] iArr) {
        return pick(d2, d3, d4, d5, iArr, this);
    }

    public Matrix4d reflect(Vector3dc vector3dc, Vector3dc vector3dc2, Matrix4d matrix4d) {
        return reflect(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), matrix4d);
    }

    public Matrix4d reflection(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d4;
        double d9 = d4;
        double e2 = a.e(d8, d9, (d3 * d3) + (d2 * d2), 1.0d);
        double d10 = d2 * e2;
        double d11 = d3 * e2;
        double d12 = e2 * d4;
        return reflection(d10, d11, d12, (((-d10) * d5) - (d11 * d6)) - (d12 * d7));
    }

    public Matrix4d rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, this);
    }

    public Matrix4d rotation(AxisAngle4d axisAngle4d) {
        return rotation(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Matrix4d set(Matrix4fc matrix4fc) {
        this.m00 = (double) matrix4fc.m00();
        this.m01 = (double) matrix4fc.m01();
        this.m02 = (double) matrix4fc.m02();
        this.m03 = (double) matrix4fc.m03();
        this.m10 = (double) matrix4fc.m10();
        this.m11 = (double) matrix4fc.m11();
        this.m12 = (double) matrix4fc.m12();
        this.m13 = (double) matrix4fc.m13();
        this.m20 = (double) matrix4fc.m20();
        this.m21 = (double) matrix4fc.m21();
        this.m22 = (double) matrix4fc.m22();
        this.m23 = (double) matrix4fc.m23();
        this.m30 = (double) matrix4fc.m30();
        this.m31 = (double) matrix4fc.m31();
        this.m32 = (double) matrix4fc.m32();
        this.m33 = (double) matrix4fc.m33();
        this.properties = matrix4fc.properties();
        return this;
    }

    public Matrix4d setFrustum(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setFrustum(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d setFrustumLH(double d2, double d3, double d4, double d5, double d6, double d7) {
        return setFrustumLH(d2, d3, d4, d5, d6, d7, false);
    }

    public Matrix4d add4x3(Matrix4fc matrix4fc) {
        return add4x3(matrix4fc, this);
    }

    public boolean equals(Matrix4dc matrix4dc, double d2) {
        if (this == matrix4dc) {
            return true;
        }
        return matrix4dc != null && (matrix4dc instanceof Matrix4d) && Runtime.equals(this.m00, matrix4dc.m00(), d2) && Runtime.equals(this.m01, matrix4dc.m01(), d2) && Runtime.equals(this.m02, matrix4dc.m02(), d2) && Runtime.equals(this.m03, matrix4dc.m03(), d2) && Runtime.equals(this.m10, matrix4dc.m10(), d2) && Runtime.equals(this.m11, matrix4dc.m11(), d2) && Runtime.equals(this.m12, matrix4dc.m12(), d2) && Runtime.equals(this.m13, matrix4dc.m13(), d2) && Runtime.equals(this.m20, matrix4dc.m20(), d2) && Runtime.equals(this.m21, matrix4dc.m21(), d2) && Runtime.equals(this.m22, matrix4dc.m22(), d2) && Runtime.equals(this.m23, matrix4dc.m23(), d2) && Runtime.equals(this.m30, matrix4dc.m30(), d2) && Runtime.equals(this.m31, matrix4dc.m31(), d2) && Runtime.equals(this.m32, matrix4dc.m32(), d2) && Runtime.equals(this.m33, matrix4dc.m33(), d2);
    }

    public Matrix4d reflection(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return reflection(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d rotate(AxisAngle4f axisAngle4f) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z);
    }

    public Matrix4d rotateTranslation(Quaterniondc quaterniondc, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d3 = a2;
        double d4 = d2 + d3;
        double d5 = (-d3) + d2;
        double d6 = b2 - a3;
        double d7 = d4;
        double b4 = a.b(w, x, z, y);
        double f2 = a.f(y, z, w, x);
        double d8 = a3 + b2;
        double d9 = b4;
        double d10 = z;
        double d11 = b3 - a4;
        double d12 = d8;
        double d13 = b3 + a4;
        double d14 = x;
        double d15 = f2;
        double g2 = a.g(d10, y, d14, w);
        matrix4d2.m20 = d12;
        matrix4d2.m21 = d11;
        matrix4d2.m22 = g2;
        matrix4d2.m23 = 0.0d;
        matrix4d2.m00 = d9;
        matrix4d2.m01 = d7;
        matrix4d2.m02 = d6;
        matrix4d2.m03 = 0.0d;
        matrix4d2.m10 = d5;
        matrix4d2.m11 = d15;
        matrix4d2.m12 = d13;
        matrix4d2.m13 = 0.0d;
        matrix4d2.m30 = this.m30;
        matrix4d2.m31 = this.m31;
        matrix4d2.m32 = this.m32;
        matrix4d2.m33 = 1.0d;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d rotation(Quaterniondc quaterniondc) {
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
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d3 = a4;
        _m00(((w + x) - z) - y);
        _m01(d2 + a2);
        _m02(b2 - a3);
        _m10((-a2) + d2);
        _m11(((y - z) + w) - x);
        _m12(b3 + d3);
        _m20(a3 + b2);
        _m21(b3 - d3);
        _m22(((z - y) - x) + w);
        this.properties = 18;
        return this;
    }

    public Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5, double d6, double d7) {
        return scaleAroundLocal(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScale((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), (double) vector3fc2.x(), (double) vector3fc2.y(), (double) vector3fc2.z());
    }

    public Matrix4d add4x3(Matrix4fc matrix4fc, Matrix4d matrix4d) {
        matrix4d.m00 = this.m00 + ((double) matrix4fc.m00());
        matrix4d.m01 = this.m01 + ((double) matrix4fc.m01());
        matrix4d.m02 = this.m02 + ((double) matrix4fc.m02());
        matrix4d.m03 = this.m03;
        matrix4d.m10 = this.m10 + ((double) matrix4fc.m10());
        matrix4d.m11 = this.m11 + ((double) matrix4fc.m11());
        matrix4d.m12 = this.m12 + ((double) matrix4fc.m12());
        matrix4d.m13 = this.m13;
        matrix4d.m20 = this.m20 + ((double) matrix4fc.m20());
        matrix4d.m21 = this.m21 + ((double) matrix4fc.m21());
        matrix4d.m22 = this.m22 + ((double) matrix4fc.m22());
        matrix4d.m23 = this.m23;
        matrix4d.m30 = this.m30 + ((double) matrix4fc.m30());
        matrix4d.m31 = this.m31 + ((double) matrix4fc.m31());
        matrix4d.m32 = this.m32 + ((double) matrix4fc.m32());
        matrix4d.m33 = this.m33;
        matrix4d.properties = 0;
        return matrix4d;
    }

    public Matrix4d reflection(Quaterniondc quaterniondc, Vector3dc vector3dc) {
        double x = quaterniondc.x() + quaterniondc.x();
        double y = quaterniondc.y() + quaterniondc.y();
        double z = quaterniondc.z() + quaterniondc.z();
        return reflection((quaterniondc.w() * y) + (quaterniondc.x() * z), (quaterniondc.y() * z) - (quaterniondc.w() * x), 1.0d - ((quaterniondc.y() * y) + (quaterniondc.x() * x)), vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4d rotate(AxisAngle4f axisAngle4f, Matrix4d matrix4d) {
        return rotate((double) axisAngle4f.angle, (double) axisAngle4f.x, (double) axisAngle4f.y, (double) axisAngle4f.z, matrix4d);
    }

    public Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5) {
        return scaleAroundLocal(d2, d2, d2, d3, d4, d5, this);
    }

    public Matrix4d translationRotateScale(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2) {
        return translationRotateScale(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d translationRotateScaleInvert(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2) {
        return translationRotateScaleInvert(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
    }

    public Matrix4d mul(Matrix4x3fc matrix4x3fc, Matrix4d matrix4d) {
        if ((this.properties & 4) != 0) {
            return matrix4d.set(matrix4x3fc);
        }
        if ((matrix4x3fc.properties() & 4) != 0) {
            return matrix4d.set((Matrix4dc) this);
        }
        return mulGeneric(matrix4x3fc, matrix4d);
    }

    public Matrix4d rotate(AxisAngle4d axisAngle4d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z);
    }

    public Matrix4d scaleAroundLocal(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return scaleAroundLocal(d2, d2, d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d translationRotateScale(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return translationRotateScale(d2, d3, d4, d5, d6, d7, d8, d9, d9, d9);
    }

    public Matrix4d translationRotateScaleInvert(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScaleInvert((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), (double) vector3fc2.x(), (double) vector3fc2.y(), (double) vector3fc2.z());
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

    public Matrix4d invertAffine() {
        return invertAffine(this);
    }

    public Matrix4d rotate(AxisAngle4d axisAngle4d, Matrix4d matrix4d) {
        return rotate(axisAngle4d.angle, axisAngle4d.x, axisAngle4d.y, axisAngle4d.z, matrix4d);
    }

    public Matrix4d translationRotateScale(Vector3dc vector3dc, Quaterniondc quaterniondc, double d2) {
        return translationRotateScale(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), d2, d2, d2);
    }

    public Matrix4d translationRotateScaleInvert(Vector3dc vector3dc, Quaterniondc quaterniondc, double d2) {
        return translationRotateScaleInvert(vector3dc.x(), vector3dc.y(), vector3dc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), d2, d2, d2);
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

    public Matrix4d rotate(double d2, Vector3dc vector3dc) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    public Matrix4d rotateAffine(double d2, double d3, double d4, double d5) {
        return rotateAffine(d2, d3, d4, d5, this);
    }

    public Matrix4d scaleAround(double d2, double d3, double d4, double d5, double d6, double d7) {
        return scaleAround(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, double d2) {
        return translationRotateScale((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), d2, d2, d2);
    }

    public Matrix4d translationRotateScaleInvert(Vector3fc vector3fc, Quaternionfc quaternionfc, double d2) {
        return translationRotateScaleInvert((double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), (double) quaternionfc.x(), (double) quaternionfc.y(), (double) quaternionfc.z(), (double) quaternionfc.w(), d2, d2, d2);
    }

    public Matrix4d translationRotateScaleMulAffine(Vector3fc vector3fc, Quaterniondc quaterniondc, Vector3fc vector3fc2, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double x = (double) vector3fc.x();
        return translationRotateScaleMulAffine(x, (double) vector3fc.y(), (double) vector3fc.z(), quaterniondc.x(), quaterniondc.y(), quaterniondc.z(), quaterniondc.w(), (double) vector3fc2.x(), (double) vector3fc2.y(), (double) vector3fc2.z(), matrix4d2);
    }

    private Matrix4d rotateGeneric(Quaterniondc quaterniondc, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d3 = a2;
        double b4 = a.b(w, x, z, y);
        double d4 = d2 + d3;
        double d5 = b2 - a3;
        double d6 = (-d3) + d2;
        double f2 = a.f(y, z, w, x);
        double d7 = b3 + a4;
        double d8 = a3 + b2;
        double d9 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d10 = this.m00;
        double d11 = d10 * b4;
        double d12 = this.m10;
        double d13 = (d12 * d4) + d11;
        double d14 = this.m20;
        double d15 = (d14 * d5) + d13;
        double d16 = this.m01;
        double d17 = d16 * b4;
        double d18 = d15;
        double d19 = this.m11;
        double d20 = (d19 * d4) + d17;
        double d21 = g2;
        double d22 = this.m21;
        double d23 = d22;
        double d24 = (d22 * d5) + d20;
        double d25 = this.m02;
        double d26 = d25 * b4;
        double d27 = d25;
        double d28 = this.m12;
        double d29 = (d28 * d4) + d26;
        double d30 = d28;
        double d31 = this.m22;
        double d32 = d31;
        double d33 = (d31 * d5) + d29;
        double d34 = this.m03;
        double d35 = b4 * d34;
        double d36 = d34;
        double d37 = this.m13;
        double d38 = (d4 * d37) + d35;
        double d39 = d37;
        double d40 = this.m23;
        double d41 = d40;
        double d42 = (d5 * d40) + d38;
        double d43 = d42;
        double d44 = (d14 * d7) + (d12 * f2) + (d10 * d6);
        double d45 = d44;
        double d46 = (d23 * d7) + (d19 * f2) + (d16 * d6);
        double d47 = d46;
        double d48 = (d32 * d7) + (d30 * f2) + (d27 * d6);
        double d49 = d7 * d41;
        double d50 = d49 + (f2 * d39) + (d6 * d36);
        double d51 = d14 * d21;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m20 = d51 + (d12 * d9) + (d10 * d8);
        double d52 = d23 * d21;
        matrix4d3.m21 = d52 + (d19 * d9) + (d16 * d8);
        matrix4d3.m22 = (d32 * d21) + (d30 * d9) + (d27 * d8);
        matrix4d3.m23 = (d41 * d21) + (d39 * d9) + (d36 * d8);
        matrix4d3.m00 = d18;
        matrix4d3.m01 = d24;
        matrix4d3.m02 = d33;
        matrix4d3.m03 = d43;
        matrix4d3.m10 = d45;
        matrix4d3.m11 = d47;
        matrix4d3.m12 = d48;
        matrix4d3.m13 = d50;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d billboardSpherical(Vector3dc vector3dc, Vector3dc vector3dc2) {
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
        this.m03 = 0.0d;
        this.m10 = d11;
        this.m11 = 1.0d - d8;
        this.m12 = d12;
        this.m13 = 0.0d;
        this.m20 = d13;
        this.m21 = -d12;
        this.m22 = d14 - d8;
        this.m23 = 0.0d;
        this.m30 = vector3dc.x();
        this.m31 = vector3dc.y();
        this.m32 = vector3dc.z();
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public double[] get(double[] dArr) {
        return get(dArr, 0);
    }

    public Matrix4d rotate(double d2, Vector3dc vector3dc, Matrix4d matrix4d) {
        return rotate(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), matrix4d);
    }

    public Matrix4d rotateAffine(Quaterniondc quaterniondc, Matrix4d matrix4d) {
        Quaterniondc quaterniondc2 = quaterniondc;
        Matrix4d matrix4d2 = matrix4d;
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
        double d3 = a2;
        double b4 = a.b(w, x, z, y);
        double d4 = d2 + d3;
        double d5 = b2 - a3;
        double d6 = (-d3) + d2;
        double f2 = a.f(y, z, w, x);
        double d7 = b3 + a4;
        double d8 = a3 + b2;
        double d9 = b3 - a4;
        double g2 = a.g(z, y, x, w);
        double d10 = this.m00;
        double d11 = d10 * b4;
        double d12 = this.m10;
        double d13 = (d12 * d4) + d11;
        double d14 = this.m20;
        double d15 = (d14 * d5) + d13;
        double d16 = this.m01;
        double d17 = d16 * b4;
        double d18 = d15;
        double d19 = this.m11;
        double d20 = (d19 * d4) + d17;
        double d21 = g2;
        double d22 = this.m21;
        double d23 = d22;
        double d24 = (d22 * d5) + d20;
        double d25 = this.m02;
        double d26 = b4 * d25;
        double d27 = d25;
        double d28 = this.m12;
        double d29 = (d4 * d28) + d26;
        double d30 = d28;
        double d31 = this.m22;
        double d32 = d31;
        double d33 = (d5 * d31) + d29;
        double d34 = d33;
        double d35 = (d14 * d7) + (d12 * f2) + (d10 * d6);
        double d36 = d35;
        double d37 = (d23 * d7) + (d19 * f2) + (d16 * d6);
        double d38 = d7 * d32;
        double d39 = d38 + (f2 * d30) + (d6 * d27);
        double d40 = d14 * d21;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m20 = d40 + (d12 * d9) + (d10 * d8);
        double d41 = d23 * d21;
        matrix4d3.m21 = d41 + (d19 * d9) + (d16 * d8);
        matrix4d3.m22 = (d32 * d21) + (d30 * d9) + (d27 * d8);
        matrix4d3.m23 = 0.0d;
        matrix4d3.m00 = d18;
        matrix4d3.m01 = d24;
        matrix4d3.m02 = d34;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = d36;
        matrix4d3.m11 = d37;
        matrix4d3.m12 = d39;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateLocalX(double d2) {
        return rotateLocalX(d2, this);
    }

    public Matrix4d rotateLocalY(double d2) {
        return rotateLocalY(d2, this);
    }

    public Matrix4d rotateLocalZ(double d2) {
        return rotateLocalZ(d2, this);
    }

    public Matrix4d scaleAround(double d2, double d3, double d4, double d5) {
        return scaleAround(d2, d2, d2, d3, d4, d5, this);
    }

    public Vector4d unproject(Vector3dc vector3dc, int[] iArr, Vector4d vector4d) {
        return unproject(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector4d);
    }

    public Matrix4d(Matrix4fc matrix4fc) {
        this.m00 = (double) matrix4fc.m00();
        this.m01 = (double) matrix4fc.m01();
        this.m02 = (double) matrix4fc.m02();
        this.m03 = (double) matrix4fc.m03();
        this.m10 = (double) matrix4fc.m10();
        this.m11 = (double) matrix4fc.m11();
        this.m12 = (double) matrix4fc.m12();
        this.m13 = (double) matrix4fc.m13();
        this.m20 = (double) matrix4fc.m20();
        this.m21 = (double) matrix4fc.m21();
        this.m22 = (double) matrix4fc.m22();
        this.m23 = (double) matrix4fc.m23();
        this.m30 = (double) matrix4fc.m30();
        this.m31 = (double) matrix4fc.m31();
        this.m32 = (double) matrix4fc.m32();
        this.m33 = (double) matrix4fc.m33();
        this.properties = matrix4fc.properties();
    }

    public float[] get(float[] fArr, int i2) {
        fArr[i2 + 0] = (float) this.m00;
        fArr[i2 + 1] = (float) this.m01;
        fArr[i2 + 2] = (float) this.m02;
        fArr[i2 + 3] = (float) this.m03;
        fArr[i2 + 4] = (float) this.m10;
        fArr[i2 + 5] = (float) this.m11;
        fArr[i2 + 6] = (float) this.m12;
        fArr[i2 + 7] = (float) this.m13;
        fArr[i2 + 8] = (float) this.m20;
        fArr[i2 + 9] = (float) this.m21;
        fArr[i2 + 10] = (float) this.m22;
        fArr[i2 + 11] = (float) this.m23;
        fArr[i2 + 12] = (float) this.m30;
        fArr[i2 + 13] = (float) this.m31;
        fArr[i2 + 14] = (float) this.m32;
        fArr[i2 + 15] = (float) this.m33;
        return fArr;
    }

    public Matrix4d rotate(double d2, Vector3fc vector3fc) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z());
    }

    public Matrix4d scaleAround(double d2, double d3, double d4, double d5, Matrix4d matrix4d) {
        return scaleAround(d2, d2, d2, d3, d4, d5, matrix4d);
    }

    public Matrix4d setPerspective(double d2, double d3, double d4, double d5) {
        return setPerspective(d2, d3, d4, d5, false);
    }

    public Matrix4d setPerspectiveLH(double d2, double d3, double d4, double d5) {
        return setPerspectiveLH(d2, d3, d4, d5, false);
    }

    public Matrix4d shadow(Vector4dc vector4dc, Matrix4dc matrix4dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m102 = matrix4dc.m10();
        double d2 = m102;
        double m112 = matrix4dc.m11();
        double d3 = m112;
        double m122 = matrix4dc.m12();
        return shadow(vector4dc.x(), vector4dc.y(), vector4dc.z(), vector4dc.w(), d2, d3, m122, ((matrix4dc.m30() * (-m102)) - (matrix4dc.m31() * m112)) - (matrix4dc.m32() * m122), matrix4d2);
    }

    public Vector3d unproject(Vector3dc vector3dc, int[] iArr, Vector3d vector3d) {
        return unproject(vector3dc.x(), vector3dc.y(), vector3dc.z(), iArr, vector3d);
    }

    public Matrix4d mul(Matrix3x2dc matrix3x2dc) {
        return mul(matrix3x2dc, this);
    }

    public Matrix4d rotate(double d2, Vector3fc vector3fc, Matrix4d matrix4d) {
        return rotate(d2, (double) vector3fc.x(), (double) vector3fc.y(), (double) vector3fc.z(), matrix4d);
    }

    public Matrix4d rotateX(double d2) {
        return rotateX(d2, this);
    }

    public Matrix4d rotateY(double d2) {
        return rotateY(d2, this);
    }

    public Matrix4d mul(Matrix3x2dc matrix3x2dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m012 = (matrix3x2dc.m01() * this.m10) + (matrix3x2dc.m00() * this.m00);
        double m013 = (matrix3x2dc.m01() * this.m11) + (matrix3x2dc.m00() * this.m01);
        double m014 = (matrix3x2dc.m01() * this.m12) + (matrix3x2dc.m00() * this.m02);
        double m015 = (matrix3x2dc.m01() * this.m13) + (matrix3x2dc.m00() * this.m03);
        double m112 = (matrix3x2dc.m11() * this.m10) + (matrix3x2dc.m10() * this.m00);
        double m113 = (matrix3x2dc.m11() * this.m11) + (matrix3x2dc.m10() * this.m01);
        double m114 = (matrix3x2dc.m11() * this.m12) + (matrix3x2dc.m10() * this.m02);
        double m115 = (matrix3x2dc.m11() * this.m13) + (matrix3x2dc.m10() * this.m03);
        double m212 = (matrix3x2dc.m21() * this.m10) + (matrix3x2dc.m20() * this.m00) + this.m30;
        double m213 = (matrix3x2dc.m21() * this.m11) + (matrix3x2dc.m20() * this.m01) + this.m31;
        double m214 = (matrix3x2dc.m21() * this.m12) + (matrix3x2dc.m20() * this.m02) + this.m32;
        double m215 = (matrix3x2dc.m21() * this.m13) + (matrix3x2dc.m20() * this.m03) + this.m33;
        matrix4d2.m00 = m012;
        matrix4d2.m01 = m013;
        matrix4d2.m02 = m014;
        matrix4d2.m03 = m015;
        matrix4d2.m10 = m112;
        matrix4d2.m11 = m113;
        matrix4d2.m12 = m114;
        matrix4d2.m13 = m115;
        matrix4d2.m20 = this.m20;
        matrix4d2.m21 = this.m21;
        matrix4d2.m22 = this.m22;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = m212;
        matrix4d2.m31 = m213;
        matrix4d2.m32 = m214;
        matrix4d2.m33 = m215;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    public Matrix4d set4x3(Matrix4dc matrix4dc) {
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
        this.properties = matrix4dc.properties() & -2 & this.properties;
        return this;
    }

    public Matrix4d invertPerspectiveView(Matrix4x3dc matrix4x3dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double d2 = this.m00;
        double d3 = this.m11;
        double d4 = 1.0d / (d2 * d3);
        double d5 = this.m23;
        double d6 = this.m32;
        double d7 = -1.0d / (d5 * d6);
        double d8 = d3 * d4;
        double d9 = d2 * d4;
        double d10 = (-d5) * d7;
        double d11 = (-d6) * d7;
        double d12 = this.m22 * d7;
        double m302 = ((matrix4x3dc.m30() * (-matrix4x3dc.m00())) - (matrix4x3dc.m31() * matrix4x3dc.m01())) - (matrix4x3dc.m32() * matrix4x3dc.m02());
        double m303 = ((matrix4x3dc.m30() * (-matrix4x3dc.m10())) - (matrix4x3dc.m31() * matrix4x3dc.m11())) - (matrix4x3dc.m32() * matrix4x3dc.m12());
        double m304 = ((matrix4x3dc.m30() * (-matrix4x3dc.m20())) - (matrix4x3dc.m31() * matrix4x3dc.m21())) - (matrix4x3dc.m32() * matrix4x3dc.m22());
        double m002 = matrix4x3dc.m00() * d8;
        double m102 = matrix4x3dc.m10() * d8;
        double m202 = d8 * matrix4x3dc.m20();
        double d13 = m102;
        double m012 = matrix4x3dc.m01() * d9;
        double m112 = matrix4x3dc.m11() * d9;
        double m212 = d9 * matrix4x3dc.m21();
        double d14 = m302 * d10;
        double d15 = m303 * d10;
        double d16 = m304 * d10;
        double m022 = (m302 * d12) + (matrix4x3dc.m02() * d11);
        double m122 = (m303 * d12) + (matrix4x3dc.m12() * d11);
        double m222 = (m304 * d12) + (matrix4x3dc.m22() * d11);
        double d17 = d12;
        double d18 = d13;
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m00 = m002;
        matrix4d3.m01 = d18;
        matrix4d3.m02 = m202;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = m012;
        matrix4d3.m11 = m112;
        matrix4d3.m12 = m212;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m20 = d14;
        matrix4d3.m21 = d15;
        matrix4d3.m22 = d16;
        matrix4d3.m23 = d10;
        matrix4d3.m30 = m022;
        matrix4d3.m31 = m122;
        matrix4d3.m32 = m222;
        matrix4d3.m33 = d17;
        matrix4d3.properties = 0;
        return matrix4d3;
    }

    public Matrix4d shadow(Vector4d vector4d, Matrix4d matrix4d) {
        return shadow(vector4d, matrix4d, this);
    }

    public Matrix4d shadow(double d2, double d3, double d4, double d5, Matrix4dc matrix4dc, Matrix4d matrix4d) {
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        double d9 = d5;
        Matrix4d matrix4d2 = matrix4d;
        double m102 = matrix4dc.m10();
        double d10 = m102;
        double m112 = matrix4dc.m11();
        double d11 = m112;
        double m122 = matrix4dc.m12();
        double d12 = m102;
        double m302 = ((matrix4dc.m30() * (-d12)) - (matrix4dc.m31() * m112)) - (matrix4dc.m32() * m122);
        return shadow(d2, d7, d8, d9, d10, d11, m122, m302, matrix4d2);
    }

    private Matrix4d mulGeneric(Matrix4x3dc matrix4x3dc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m022 = (matrix4x3dc.m02() * this.m20) + (matrix4x3dc.m01() * this.m10) + (matrix4x3dc.m00() * this.m00);
        double m023 = (matrix4x3dc.m02() * this.m21) + (matrix4x3dc.m01() * this.m11) + (matrix4x3dc.m00() * this.m01);
        double m024 = (matrix4x3dc.m02() * this.m22) + (matrix4x3dc.m01() * this.m12) + (matrix4x3dc.m00() * this.m02);
        double m025 = (matrix4x3dc.m02() * this.m23) + (matrix4x3dc.m01() * this.m13) + (matrix4x3dc.m00() * this.m03);
        double m122 = (matrix4x3dc.m12() * this.m20) + (matrix4x3dc.m11() * this.m10) + (matrix4x3dc.m10() * this.m00);
        double m123 = (matrix4x3dc.m12() * this.m21) + (matrix4x3dc.m11() * this.m11) + (matrix4x3dc.m10() * this.m01);
        double m124 = (matrix4x3dc.m12() * this.m22) + (matrix4x3dc.m11() * this.m12) + (matrix4x3dc.m10() * this.m02);
        double m125 = (matrix4x3dc.m12() * this.m23) + (matrix4x3dc.m11() * this.m13) + (matrix4x3dc.m10() * this.m03);
        double m222 = (matrix4x3dc.m22() * this.m20) + (matrix4x3dc.m21() * this.m10) + (matrix4x3dc.m20() * this.m00);
        double m223 = (matrix4x3dc.m22() * this.m21) + (matrix4x3dc.m21() * this.m11) + (matrix4x3dc.m20() * this.m01);
        double m224 = (matrix4x3dc.m22() * this.m22) + (matrix4x3dc.m21() * this.m12) + (matrix4x3dc.m20() * this.m02);
        double m225 = (matrix4x3dc.m22() * this.m23) + (matrix4x3dc.m21() * this.m13) + (matrix4x3dc.m20() * this.m03);
        double m322 = (matrix4x3dc.m32() * this.m20) + (matrix4x3dc.m31() * this.m10) + (matrix4x3dc.m30() * this.m00) + this.m30;
        double m323 = (matrix4x3dc.m32() * this.m21) + (matrix4x3dc.m31() * this.m11) + (matrix4x3dc.m30() * this.m01) + this.m31;
        double m324 = (matrix4x3dc.m32() * this.m22) + (matrix4x3dc.m31() * this.m12) + (matrix4x3dc.m30() * this.m02) + this.m32;
        double m325 = (matrix4x3dc.m32() * this.m23) + (matrix4x3dc.m31() * this.m13) + (matrix4x3dc.m30() * this.m03) + this.m33;
        matrix4d2.m00 = m022;
        matrix4d2.m01 = m023;
        matrix4d2.m02 = m024;
        matrix4d2.m03 = m025;
        matrix4d2.m10 = m122;
        matrix4d2.m11 = m123;
        matrix4d2.m12 = m124;
        matrix4d2.m13 = m125;
        matrix4d2.m20 = m222;
        matrix4d2.m21 = m223;
        matrix4d2.m22 = m224;
        matrix4d2.m23 = m225;
        matrix4d2.m30 = m322;
        matrix4d2.m31 = m323;
        matrix4d2.m32 = m324;
        matrix4d2.m33 = m325;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    public Matrix4d arcball(double d2, Vector3dc vector3dc, double d3, double d4, Matrix4d matrix4d) {
        return arcball(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), d3, d4, matrix4d);
    }

    public Matrix4d arcball(double d2, double d3, double d4, double d5, double d6, double d7) {
        return arcball(d2, d3, d4, d5, d6, d7, this);
    }

    public Matrix4d rotateLocal(Quaterniondc quaterniondc) {
        return rotateLocal(quaterniondc, this);
    }

    public Matrix4d set(Matrix4x3dc matrix4x3dc) {
        this.m00 = matrix4x3dc.m00();
        this.m01 = matrix4x3dc.m01();
        this.m02 = matrix4x3dc.m02();
        this.m03 = 0.0d;
        this.m10 = matrix4x3dc.m10();
        this.m11 = matrix4x3dc.m11();
        this.m12 = matrix4x3dc.m12();
        this.m13 = 0.0d;
        this.m20 = matrix4x3dc.m20();
        this.m21 = matrix4x3dc.m21();
        this.m22 = matrix4x3dc.m22();
        this.m23 = 0.0d;
        this.m30 = matrix4x3dc.m30();
        this.m31 = matrix4x3dc.m31();
        this.m32 = matrix4x3dc.m32();
        this.m33 = 1.0d;
        this.properties = matrix4x3dc.properties() | 2;
        return this;
    }

    public Matrix4d arcball(double d2, Vector3dc vector3dc, double d3, double d4) {
        return arcball(d2, vector3dc.x(), vector3dc.y(), vector3dc.z(), d3, d4, this);
    }

    public Matrix4d rotateLocal(Quaternionfc quaternionfc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d18 = b2 * d17;
        double d19 = this.m01;
        double d20 = (d13 * d19) + d18;
        double d21 = this.m02;
        double d22 = (a3 * d21) + d20;
        double d23 = (d16 * d21) + (f3 * d19) + (a2 * d17);
        double d24 = d21 * g2;
        double d25 = d24 + (d19 * d15) + (d17 * f2);
        double d26 = this.m03;
        double d27 = this.m10;
        double d28 = b2 * d27;
        double d29 = d26;
        double d30 = this.m11;
        double d31 = (d13 * d30) + d28;
        double d32 = this.m12;
        double d33 = d25;
        double d34 = (a3 * d32) + d31;
        double d35 = (d16 * d32) + (f3 * d30) + (a2 * d27);
        double d36 = d32 * g2;
        double d37 = d36 + (d30 * d15) + (d27 * f2);
        double d38 = this.m13;
        double d39 = this.m20;
        double d40 = b2 * d39;
        double d41 = d38;
        double d42 = this.m21;
        double d43 = (d13 * d42) + d40;
        double d44 = d37;
        double d45 = this.m22;
        double d46 = d35;
        double d47 = (a3 * d45) + d43;
        double d48 = (d16 * d45) + (f3 * d42) + (a2 * d39);
        double d49 = d45 * g2;
        double d50 = d49 + (d42 * d15) + (d39 * f2);
        double d51 = this.m23;
        double d52 = this.m30;
        double d53 = b2 * d52;
        double d54 = d51;
        double d55 = this.m31;
        double d56 = (d13 * d55) + d53;
        double d57 = d50;
        double d58 = this.m32;
        double d59 = d48;
        double d60 = d16 * d58;
        double d61 = (a3 * d58) + d56;
        double d62 = d60 + (f3 * d55) + (a2 * d52);
        double d63 = g2 * d58;
        double d64 = d63 + (d15 * d55) + (f2 * d52);
        double d65 = this.m33;
        matrix4d2.m00 = d22;
        matrix4d2.m01 = d23;
        matrix4d2.m02 = d33;
        matrix4d2.m03 = d29;
        matrix4d2.m10 = d34;
        matrix4d2.m11 = d46;
        matrix4d2.m12 = d44;
        matrix4d2.m13 = d41;
        matrix4d2.m20 = d47;
        matrix4d2.m21 = d59;
        matrix4d2.m22 = d57;
        matrix4d2.m23 = d54;
        matrix4d2.m30 = d61;
        matrix4d2.m31 = d62;
        matrix4d2.m32 = d64;
        matrix4d2.m33 = d65;
        matrix4d2.properties = this.properties & -14;
        return matrix4d2;
    }

    public Matrix4d shadow(double d2, double d3, double d4, double d5, Matrix4dc matrix4dc) {
        return shadow(d2, d3, d4, d5, matrix4dc, this);
    }

    public Matrix4d rotateAroundLocal(Quaterniondc quaterniondc, double d2, double d3, double d4) {
        return rotateAroundLocal(quaterniondc, d2, d3, d4, this);
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix4d rotateTranslation(Quaternionfc quaternionfc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        matrix4d3.m20 = d23;
        matrix4d3.m21 = d18;
        matrix4d3.m22 = g2;
        matrix4d3.m23 = 0.0d;
        matrix4d3.m00 = d15;
        matrix4d3.m01 = d14;
        matrix4d3.m02 = f2;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = d13;
        matrix4d3.m11 = d22;
        matrix4d3.m12 = d20;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = 1.0d;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotation(Quaternionfc quaternionfc) {
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
        if ((this.properties & 4) == 0) {
            _identity();
        }
        double d8 = d7;
        _m00(((w + x) - z) - y);
        _m01(d3 + d2);
        _m02(d4 - d5);
        _m10((-d2) + d3);
        _m11(((y - z) + w) - x);
        _m12(d6 + d8);
        _m20(d5 + d4);
        _m21(d6 - d8);
        _m22(((z - y) - x) + w);
        this.properties = 18;
        return this;
    }

    public Matrix4d(Matrix4x3dc matrix4x3dc) {
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
        this.m33 = 1.0d;
        this.properties = matrix4x3dc.properties() | 2;
    }

    public Matrix4d rotateAffine(Quaterniondc quaterniondc) {
        return rotateAffine(quaterniondc, this);
    }

    private Matrix4d rotateGeneric(Quaternionfc quaternionfc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        double d32 = d31 * b2;
        double d33 = d31;
        double d34 = this.m12;
        double d35 = (d34 * a2) + d32;
        double d36 = d34;
        double d37 = this.m22;
        double d38 = d37;
        double d39 = (d37 * f2) + d35;
        double d40 = this.m03;
        double d41 = b2 * d40;
        double d42 = d40;
        double d43 = this.m13;
        double d44 = (a2 * d43) + d41;
        double d45 = d43;
        double d46 = this.m23;
        double d47 = d46;
        double d48 = (f2 * d46) + d44;
        double d49 = (d21 * d15) + (d19 * f3) + (d17 * d13);
        double d50 = (d28 * d15) + (d26 * f3) + (d23 * d13);
        double d51 = d50;
        double d52 = (f3 * d45) + (d13 * d42);
        double d53 = (d38 * d15) + (d36 * f3) + (d33 * d13);
        double d54 = (d15 * d47) + d52;
        double d55 = d21 * d29;
        double d56 = d55 + (d19 * d16) + (d17 * a3);
        Matrix4d matrix4d3 = matrix4d;
        double d57 = d30;
        matrix4d3.m20 = d56;
        double d58 = d28 * d29;
        matrix4d3.m21 = d58 + (d26 * d16) + (d23 * a3);
        matrix4d3.m22 = (d38 * d29) + (d36 * d16) + (d33 * a3);
        matrix4d3.m23 = (d47 * d29) + (d45 * d16) + (d42 * a3);
        matrix4d3.m00 = d25;
        matrix4d3.m01 = d57;
        matrix4d3.m02 = d39;
        matrix4d3.m03 = d48;
        matrix4d3.m10 = d49;
        matrix4d3.m11 = d51;
        matrix4d3.m12 = d53;
        matrix4d3.m13 = d54;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d rotateAffine(Quaternionfc quaternionfc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
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
        Matrix4d matrix4d3 = matrix4d;
        double d46 = d30;
        matrix4d3.m20 = d45;
        double d47 = d28 * d29;
        matrix4d3.m21 = d47 + (d26 * d16) + (d23 * a3);
        matrix4d3.m22 = (d38 * d29) + (d36 * d16) + (d33 * a3);
        matrix4d3.m23 = 0.0d;
        matrix4d3.m00 = d25;
        matrix4d3.m01 = d46;
        matrix4d3.m02 = d39;
        matrix4d3.m03 = 0.0d;
        matrix4d3.m10 = d40;
        matrix4d3.m11 = d42;
        matrix4d3.m12 = d43;
        matrix4d3.m13 = 0.0d;
        matrix4d3.m30 = this.m30;
        matrix4d3.m31 = this.m31;
        matrix4d3.m32 = this.m32;
        matrix4d3.m33 = this.m33;
        matrix4d3.properties = this.properties & -14;
        return matrix4d3;
    }

    public Matrix4d set(Matrix4x3fc matrix4x3fc) {
        this.m00 = (double) matrix4x3fc.m00();
        this.m01 = (double) matrix4x3fc.m01();
        this.m02 = (double) matrix4x3fc.m02();
        this.m03 = 0.0d;
        this.m10 = (double) matrix4x3fc.m10();
        this.m11 = (double) matrix4x3fc.m11();
        this.m12 = (double) matrix4x3fc.m12();
        this.m13 = 0.0d;
        this.m20 = (double) matrix4x3fc.m20();
        this.m21 = (double) matrix4x3fc.m21();
        this.m22 = (double) matrix4x3fc.m22();
        this.m23 = 0.0d;
        this.m30 = (double) matrix4x3fc.m30();
        this.m31 = (double) matrix4x3fc.m31();
        this.m32 = (double) matrix4x3fc.m32();
        this.m33 = 1.0d;
        this.properties = matrix4x3fc.properties() | 2;
        return this;
    }

    public Matrix4d mul(Matrix3x2fc matrix3x2fc) {
        return mul(matrix3x2fc, this);
    }

    public Matrix4d mul(Matrix3x2fc matrix3x2fc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m012 = (this.m10 * ((double) matrix3x2fc.m01())) + (this.m00 * ((double) matrix3x2fc.m00()));
        double m013 = (this.m11 * ((double) matrix3x2fc.m01())) + (this.m01 * ((double) matrix3x2fc.m00()));
        double m014 = (this.m12 * ((double) matrix3x2fc.m01())) + (this.m02 * ((double) matrix3x2fc.m00()));
        double m015 = (this.m13 * ((double) matrix3x2fc.m01())) + (this.m03 * ((double) matrix3x2fc.m00()));
        double m112 = (this.m10 * ((double) matrix3x2fc.m11())) + (this.m00 * ((double) matrix3x2fc.m10()));
        double d2 = m112;
        double m113 = (this.m11 * ((double) matrix3x2fc.m11())) + (this.m01 * ((double) matrix3x2fc.m10()));
        double d3 = m113;
        double m114 = (this.m12 * ((double) matrix3x2fc.m11())) + (this.m02 * ((double) matrix3x2fc.m10()));
        double d4 = m114;
        double m115 = (this.m13 * ((double) matrix3x2fc.m11())) + (this.m03 * ((double) matrix3x2fc.m10()));
        double d5 = m115;
        double m212 = (this.m10 * ((double) matrix3x2fc.m21())) + (this.m00 * ((double) matrix3x2fc.m20())) + this.m30;
        double d6 = m212;
        double m213 = (this.m11 * ((double) matrix3x2fc.m21())) + (this.m01 * ((double) matrix3x2fc.m20())) + this.m31;
        double d7 = m213;
        double m214 = (this.m12 * ((double) matrix3x2fc.m21())) + (this.m02 * ((double) matrix3x2fc.m20())) + this.m32;
        double d8 = m214;
        double m215 = (this.m13 * ((double) matrix3x2fc.m21())) + (this.m03 * ((double) matrix3x2fc.m20())) + this.m33;
        matrix4d2.m00 = m012;
        matrix4d2.m01 = m013;
        matrix4d2.m02 = m014;
        matrix4d2.m03 = m015;
        matrix4d2.m10 = d2;
        matrix4d2.m11 = d3;
        matrix4d2.m12 = d4;
        matrix4d2.m13 = d5;
        matrix4d2.m20 = this.m20;
        matrix4d2.m21 = this.m21;
        matrix4d2.m22 = this.m22;
        matrix4d2.m23 = this.m23;
        matrix4d2.m30 = d6;
        matrix4d2.m31 = d7;
        matrix4d2.m32 = d8;
        matrix4d2.m33 = m215;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    public Matrix4d(Matrix4x3fc matrix4x3fc) {
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
        this.m33 = 1.0d;
        this.properties = matrix4x3fc.properties() | 2;
    }

    private Matrix4d mulGeneric(Matrix4x3fc matrix4x3fc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        double m022 = (this.m20 * ((double) matrix4x3fc.m02())) + (this.m10 * ((double) matrix4x3fc.m01())) + (this.m00 * ((double) matrix4x3fc.m00()));
        double m023 = (this.m21 * ((double) matrix4x3fc.m02())) + (this.m11 * ((double) matrix4x3fc.m01())) + (this.m01 * ((double) matrix4x3fc.m00()));
        double m024 = (this.m22 * ((double) matrix4x3fc.m02())) + (this.m12 * ((double) matrix4x3fc.m01())) + (this.m02 * ((double) matrix4x3fc.m00()));
        double m025 = (this.m23 * ((double) matrix4x3fc.m02())) + (this.m13 * ((double) matrix4x3fc.m01())) + (this.m03 * ((double) matrix4x3fc.m00()));
        double m122 = (this.m20 * ((double) matrix4x3fc.m12())) + (this.m10 * ((double) matrix4x3fc.m11())) + (this.m00 * ((double) matrix4x3fc.m10()));
        double d2 = m122;
        double m123 = (this.m21 * ((double) matrix4x3fc.m12())) + (this.m11 * ((double) matrix4x3fc.m11())) + (this.m01 * ((double) matrix4x3fc.m10()));
        double m124 = (this.m22 * ((double) matrix4x3fc.m12())) + (this.m12 * ((double) matrix4x3fc.m11())) + (this.m02 * ((double) matrix4x3fc.m10()));
        double m125 = (this.m23 * ((double) matrix4x3fc.m12())) + (this.m13 * ((double) matrix4x3fc.m11())) + (this.m03 * ((double) matrix4x3fc.m10()));
        double m222 = (this.m20 * ((double) matrix4x3fc.m22())) + (this.m10 * ((double) matrix4x3fc.m21())) + (this.m00 * ((double) matrix4x3fc.m20()));
        double m223 = (this.m21 * ((double) matrix4x3fc.m22())) + (this.m11 * ((double) matrix4x3fc.m21())) + (this.m01 * ((double) matrix4x3fc.m20()));
        double m224 = (this.m22 * ((double) matrix4x3fc.m22())) + (this.m12 * ((double) matrix4x3fc.m21())) + (this.m02 * ((double) matrix4x3fc.m20()));
        double m225 = (this.m23 * ((double) matrix4x3fc.m22())) + (this.m13 * ((double) matrix4x3fc.m21())) + (this.m03 * ((double) matrix4x3fc.m20()));
        double m322 = (this.m20 * ((double) matrix4x3fc.m32())) + (this.m10 * ((double) matrix4x3fc.m31())) + (this.m00 * ((double) matrix4x3fc.m30())) + this.m30;
        double m323 = (this.m21 * ((double) matrix4x3fc.m32())) + (this.m11 * ((double) matrix4x3fc.m31())) + (this.m01 * ((double) matrix4x3fc.m30())) + this.m31;
        double m324 = (this.m22 * ((double) matrix4x3fc.m32())) + (this.m12 * ((double) matrix4x3fc.m31())) + (this.m02 * ((double) matrix4x3fc.m30())) + this.m32;
        double m325 = (this.m23 * ((double) matrix4x3fc.m32())) + (this.m13 * ((double) matrix4x3fc.m31())) + (this.m03 * ((double) matrix4x3fc.m30())) + this.m33;
        matrix4d2.m00 = m022;
        matrix4d2.m01 = m023;
        matrix4d2.m02 = m024;
        matrix4d2.m03 = m025;
        matrix4d2.m10 = d2;
        matrix4d2.m11 = m123;
        matrix4d2.m12 = m124;
        matrix4d2.m13 = m125;
        matrix4d2.m20 = m222;
        matrix4d2.m21 = m223;
        matrix4d2.m22 = m224;
        matrix4d2.m23 = m225;
        matrix4d2.m30 = m322;
        matrix4d2.m31 = m323;
        matrix4d2.m32 = m324;
        matrix4d2.m33 = m325;
        matrix4d2.properties = this.properties & -30;
        return matrix4d2;
    }

    public Matrix4d set(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m03 = 0.0d;
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m13 = 0.0d;
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        this.m23 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 1.0d;
        this.properties = 2;
        return this;
    }

    public Matrix4d rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, this);
    }

    public Matrix4d(Matrix3dc matrix3dc) {
        this.m00 = matrix3dc.m00();
        this.m01 = matrix3dc.m01();
        this.m02 = matrix3dc.m02();
        this.m10 = matrix3dc.m10();
        this.m11 = matrix3dc.m11();
        this.m12 = matrix3dc.m12();
        this.m20 = matrix3dc.m20();
        this.m21 = matrix3dc.m21();
        this.m22 = matrix3dc.m22();
        this.m33 = 1.0d;
        this.properties = 2;
    }

    public Matrix4d rotateAffine(Quaternionfc quaternionfc) {
        return rotateAffine(quaternionfc, this);
    }

    public Matrix4d(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        this.m00 = d2;
        this.m01 = d3;
        this.m02 = d4;
        this.m03 = d5;
        this.m10 = d6;
        this.m11 = d7;
        this.m12 = d8;
        this.m13 = d9;
        this.m20 = d10;
        this.m21 = d11;
        this.m22 = d12;
        this.m23 = d13;
        this.m30 = d14;
        this.m31 = d15;
        this.m32 = d16;
        this.m33 = d17;
        determineProperties();
    }

    public Matrix4d mul(Matrix4f matrix4f) {
        return mul((Matrix4fc) matrix4f, this);
    }

    public Matrix4d set(AxisAngle4f axisAngle4f) {
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
        this.m03 = 0.0d;
        this.m13 = 0.0d;
        this.m23 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d mul(Matrix4fc matrix4fc, Matrix4d matrix4d) {
        Matrix4d matrix4d2 = matrix4d;
        if ((this.properties & 4) != 0) {
            return matrix4d2.set(matrix4fc);
        }
        Matrix4fc matrix4fc2 = matrix4fc;
        if ((matrix4fc.properties() & 4) != 0) {
            return matrix4d2.set((Matrix4dc) this);
        }
        double m032 = (this.m30 * ((double) matrix4fc.m03())) + (this.m20 * ((double) matrix4fc.m02())) + (this.m10 * ((double) matrix4fc.m01())) + (this.m00 * ((double) matrix4fc.m00()));
        double m033 = (this.m31 * ((double) matrix4fc.m03())) + (this.m21 * ((double) matrix4fc.m02())) + (this.m11 * ((double) matrix4fc.m01())) + (this.m01 * ((double) matrix4fc.m00()));
        double m034 = (this.m32 * ((double) matrix4fc.m03())) + (this.m22 * ((double) matrix4fc.m02())) + (this.m12 * ((double) matrix4fc.m01())) + (this.m02 * ((double) matrix4fc.m00()));
        double m035 = (this.m33 * ((double) matrix4fc.m03())) + (this.m23 * ((double) matrix4fc.m02())) + (this.m13 * ((double) matrix4fc.m01())) + (this.m03 * ((double) matrix4fc.m00()));
        double d2 = m035;
        double m132 = (this.m30 * ((double) matrix4fc.m13())) + (this.m20 * ((double) matrix4fc.m12())) + (this.m10 * ((double) matrix4fc.m11())) + (this.m00 * ((double) matrix4fc.m10()));
        double d3 = m132;
        double m133 = (this.m31 * ((double) matrix4fc.m13())) + (this.m21 * ((double) matrix4fc.m12())) + (this.m11 * ((double) matrix4fc.m11())) + (this.m01 * ((double) matrix4fc.m10()));
        double d4 = m133;
        double m134 = (this.m32 * ((double) matrix4fc.m13())) + (this.m22 * ((double) matrix4fc.m12())) + (this.m12 * ((double) matrix4fc.m11())) + (this.m02 * ((double) matrix4fc.m10()));
        double d5 = m134;
        double m135 = (this.m33 * ((double) matrix4fc.m13())) + (this.m23 * ((double) matrix4fc.m12())) + (this.m13 * ((double) matrix4fc.m11())) + (this.m03 * ((double) matrix4fc.m10()));
        double d6 = m135;
        double m232 = (this.m30 * ((double) matrix4fc.m23())) + (this.m20 * ((double) matrix4fc.m22())) + (this.m10 * ((double) matrix4fc.m21())) + (this.m00 * ((double) matrix4fc.m20()));
        double d7 = m232;
        double m233 = (this.m31 * ((double) matrix4fc.m23())) + (this.m21 * ((double) matrix4fc.m22())) + (this.m11 * ((double) matrix4fc.m21())) + (this.m01 * ((double) matrix4fc.m20()));
        double d8 = m233;
        double m234 = (this.m32 * ((double) matrix4fc.m23())) + (this.m22 * ((double) matrix4fc.m22())) + (this.m12 * ((double) matrix4fc.m21())) + (this.m02 * ((double) matrix4fc.m20()));
        double d9 = m234;
        double m235 = (this.m33 * ((double) matrix4fc.m23())) + (this.m23 * ((double) matrix4fc.m22())) + (this.m13 * ((double) matrix4fc.m21())) + (this.m03 * ((double) matrix4fc.m20()));
        double d10 = m235;
        double m332 = (this.m30 * ((double) matrix4fc.m33())) + (this.m20 * ((double) matrix4fc.m32())) + (this.m10 * ((double) matrix4fc.m31())) + (this.m00 * ((double) matrix4fc.m30()));
        double d11 = m332;
        double m333 = (this.m31 * ((double) matrix4fc.m33())) + (this.m21 * ((double) matrix4fc.m32())) + (this.m11 * ((double) matrix4fc.m31())) + (this.m01 * ((double) matrix4fc.m30()));
        double d12 = m333;
        double m334 = (this.m32 * ((double) matrix4fc.m33())) + (this.m22 * ((double) matrix4fc.m32())) + (this.m12 * ((double) matrix4fc.m31())) + (this.m02 * ((double) matrix4fc.m30()));
        double d13 = m334;
        double m335 = (this.m33 * ((double) matrix4fc.m33())) + (this.m23 * ((double) matrix4fc.m32())) + (this.m13 * ((double) matrix4fc.m31())) + (this.m03 * ((double) matrix4fc.m30()));
        matrix4d2.m00 = m032;
        matrix4d2.m01 = m033;
        matrix4d2.m02 = m034;
        matrix4d2.m03 = d2;
        matrix4d2.m10 = d3;
        matrix4d2.m11 = d4;
        matrix4d2.m12 = d5;
        matrix4d2.m13 = d6;
        matrix4d2.m20 = d7;
        matrix4d2.m21 = d8;
        matrix4d2.m22 = d9;
        matrix4d2.m23 = d10;
        matrix4d2.m30 = d11;
        matrix4d2.m31 = d12;
        matrix4d2.m32 = d13;
        matrix4d2.m33 = m335;
        matrix4d2.properties = 0;
        return matrix4d2;
    }

    public Matrix4d(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
        determineProperties();
    }

    public Matrix4d(Vector4d vector4d, Vector4d vector4d2, Vector4d vector4d3, Vector4d vector4d4) {
        this.m00 = vector4d.x;
        this.m01 = vector4d.y;
        this.m02 = vector4d.z;
        this.m03 = vector4d.w;
        this.m10 = vector4d2.x;
        this.m11 = vector4d2.y;
        this.m12 = vector4d2.z;
        this.m13 = vector4d2.w;
        this.m20 = vector4d3.x;
        this.m21 = vector4d3.y;
        this.m22 = vector4d3.z;
        this.m23 = vector4d3.w;
        this.m30 = vector4d4.x;
        this.m31 = vector4d4.y;
        this.m32 = vector4d4.z;
        this.m33 = vector4d4.w;
        determineProperties();
    }

    public Matrix4d set(AxisAngle4d axisAngle4d) {
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
        this.m03 = 0.0d;
        this.m13 = 0.0d;
        this.m23 = 0.0d;
        this.m30 = 0.0d;
        this.m31 = 0.0d;
        this.m32 = 0.0d;
        this.m33 = 1.0d;
        this.properties = 18;
        return this;
    }

    public Matrix4d set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix4d set(Quaterniondc quaterniondc) {
        return rotation(quaterniondc);
    }

    public Matrix4d set(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        this.m00 = d2;
        this.m10 = d6;
        this.m20 = d10;
        this.m30 = d14;
        this.m01 = d3;
        this.m11 = d7;
        this.m21 = d11;
        this.m31 = d15;
        this.m02 = d4;
        this.m12 = d8;
        this.m22 = d12;
        this.m32 = d16;
        this.m03 = d5;
        this.m13 = d9;
        this.m23 = d13;
        this.m33 = d17;
        this.properties = 0;
        return this;
    }

    public Matrix4d set(double[] dArr, int i2) {
        this.m00 = dArr[i2 + 0];
        this.m01 = dArr[i2 + 1];
        this.m02 = dArr[i2 + 2];
        this.m03 = dArr[i2 + 3];
        this.m10 = dArr[i2 + 4];
        this.m11 = dArr[i2 + 5];
        this.m12 = dArr[i2 + 6];
        this.m13 = dArr[i2 + 7];
        this.m20 = dArr[i2 + 8];
        this.m21 = dArr[i2 + 9];
        this.m22 = dArr[i2 + 10];
        this.m23 = dArr[i2 + 11];
        this.m30 = dArr[i2 + 12];
        this.m31 = dArr[i2 + 13];
        this.m32 = dArr[i2 + 14];
        this.m33 = dArr[i2 + 15];
        this.properties = 0;
        return this;
    }

    public Matrix4d set(double[] dArr) {
        return set(dArr, 0);
    }

    public Matrix4d set(float[] fArr, int i2) {
        this.m00 = (double) fArr[i2 + 0];
        this.m01 = (double) fArr[i2 + 1];
        this.m02 = (double) fArr[i2 + 2];
        this.m03 = (double) fArr[i2 + 3];
        this.m10 = (double) fArr[i2 + 4];
        this.m11 = (double) fArr[i2 + 5];
        this.m12 = (double) fArr[i2 + 6];
        this.m13 = (double) fArr[i2 + 7];
        this.m20 = (double) fArr[i2 + 8];
        this.m21 = (double) fArr[i2 + 9];
        this.m22 = (double) fArr[i2 + 10];
        this.m23 = (double) fArr[i2 + 11];
        this.m30 = (double) fArr[i2 + 12];
        this.m31 = (double) fArr[i2 + 13];
        this.m32 = (double) fArr[i2 + 14];
        this.m33 = (double) fArr[i2 + 15];
        this.properties = 0;
        return this;
    }

    public Matrix4d set(float[] fArr) {
        return set(fArr, 0);
    }

    public Matrix4d set(DoubleBuffer doubleBuffer) {
        MemUtil.INSTANCE.get(this, doubleBuffer.position(), doubleBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4d set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.getf(this, floatBuffer.position(), floatBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4d set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4d set(Vector4d vector4d, Vector4d vector4d2, Vector4d vector4d3, Vector4d vector4d4) {
        this.m00 = vector4d.x;
        this.m01 = vector4d.y;
        this.m02 = vector4d.z;
        this.m03 = vector4d.w;
        this.m10 = vector4d2.x;
        this.m11 = vector4d2.y;
        this.m12 = vector4d2.z;
        this.m13 = vector4d2.w;
        this.m20 = vector4d3.x;
        this.m21 = vector4d3.y;
        this.m22 = vector4d3.z;
        this.m23 = vector4d3.w;
        this.m30 = vector4d4.x;
        this.m31 = vector4d4.y;
        this.m32 = vector4d4.z;
        this.m33 = vector4d4.w;
        this.properties = 0;
        return this;
    }
}
