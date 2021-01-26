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

public class Matrix4f implements Externalizable, Matrix4fc {
    public static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m02;
    public float m03;
    public float m10;
    public float m11;
    public float m12;
    public float m13;
    public float m20;
    public float m21;
    public float m22;
    public float m23;
    public float m30;
    public float m31;
    public float m32;
    public float m33;
    public int properties;

    public Matrix4f() {
        this.m00 = 1.0f;
        this.m11 = 1.0f;
        this.m22 = 1.0f;
        this.m33 = 1.0f;
        this.properties = 30;
    }

    private Matrix4f frustumGeneric(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        float f8;
        float f9;
        float f10 = f6 + f6;
        float f11 = f3 - f2;
        float f12 = f10 / f11;
        float f13 = f5 - f4;
        float f14 = f10 / f13;
        float f15 = (f3 + f2) / f11;
        float f16 = (f5 + f4) / f13;
        float f17 = 0.0f;
        boolean z2 = true;
        boolean z3 = f7 > 0.0f && Float.isInfinite(f7);
        if (f6 <= 0.0f || !Float.isInfinite(f6)) {
            z2 = false;
        }
        float f18 = 2.0f;
        if (z3) {
            f8 = -0.999999f;
            if (z) {
                f18 = 1.0f;
            }
            f9 = (1.0E-6f - f18) * f6;
        } else if (z2) {
            if (!z) {
                f17 = 1.0f;
            }
            f8 = f17 - 1.0E-6f;
            if (z) {
                f18 = 1.0f;
            }
            f9 = (f18 - 1.0E-6f) * f7;
        } else {
            float f19 = f6 - f7;
            f8 = (z ? f7 : f7 + f6) / f19;
            if (!z) {
                f7 += f7;
            }
            f9 = (f7 * f6) / f19;
        }
        float f20 = this.m00;
        float f21 = ((this.m20 * f8) + ((this.m10 * f16) + (f20 * f15))) - this.m30;
        float f22 = ((this.m21 * f8) + ((this.m11 * f16) + (this.m01 * f15))) - this.m31;
        float f23 = ((this.m22 * f8) + ((this.m12 * f16) + (this.m02 * f15))) - this.m32;
        float f24 = ((this.m23 * f8) + ((this.m13 * f16) + (this.m03 * f15))) - this.m33;
        matrix4f._m00(f20 * f12);
        matrix4f._m01(this.m01 * f12);
        matrix4f._m02(this.m02 * f12);
        matrix4f._m03(this.m03 * f12);
        matrix4f._m10(this.m10 * f14);
        matrix4f._m11(this.m11 * f14);
        matrix4f._m12(this.m12 * f14);
        matrix4f._m13(this.m13 * f14);
        matrix4f._m30(this.m20 * f9);
        matrix4f._m31(this.m21 * f9);
        matrix4f._m32(this.m22 * f9);
        matrix4f._m33(this.m23 * f9);
        matrix4f._m20(f21);
        matrix4f._m21(f22);
        matrix4f._m22(f23);
        matrix4f._m23(f24);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    private Matrix4f frustumLHGeneric(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        float f8;
        float f9;
        float f10 = f6 + f6;
        float f11 = f3 - f2;
        float f12 = f10 / f11;
        float f13 = f5 - f4;
        float f14 = f10 / f13;
        float f15 = (f3 + f2) / f11;
        float f16 = (f5 + f4) / f13;
        float f17 = 0.0f;
        boolean z2 = true;
        boolean z3 = f7 > 0.0f && Float.isInfinite(f7);
        if (f6 <= 0.0f || !Float.isInfinite(f6)) {
            z2 = false;
        }
        float f18 = 2.0f;
        if (z3) {
            f8 = 0.999999f;
            if (z) {
                f18 = 1.0f;
            }
            f9 = (1.0E-6f - f18) * f6;
        } else if (z2) {
            if (!z) {
                f17 = 1.0f;
            }
            f8 = f17 - 1.0E-6f;
            if (z) {
                f18 = 1.0f;
            }
            f9 = (f18 - 1.0E-6f) * f7;
        } else {
            f8 = (z ? f7 : f7 + f6) / (f7 - f6);
            f9 = ((z ? f7 : f7 + f7) * f6) / (f6 - f7);
        }
        float f19 = this.m00;
        float f20 = (this.m20 * f8) + (this.m10 * f16) + (f19 * f15) + this.m30;
        float f21 = (this.m21 * f8) + (this.m11 * f16) + (this.m01 * f15) + this.m31;
        float f22 = (this.m22 * f8) + (this.m12 * f16) + (this.m02 * f15) + this.m32;
        float f23 = (this.m23 * f8) + (this.m13 * f16) + (this.m03 * f15) + this.m33;
        matrix4f._m00(f19 * f12);
        matrix4f._m01(this.m01 * f12);
        matrix4f._m02(this.m02 * f12);
        matrix4f._m03(this.m03 * f12);
        matrix4f._m10(this.m10 * f14);
        matrix4f._m11(this.m11 * f14);
        matrix4f._m12(this.m12 * f14);
        matrix4f._m13(this.m13 * f14);
        matrix4f._m30(this.m20 * f9);
        matrix4f._m31(this.m21 * f9);
        matrix4f._m32(this.m22 * f9);
        matrix4f._m33(this.m23 * f9);
        matrix4f._m20(f20);
        matrix4f._m21(f21);
        matrix4f._m22(f22);
        matrix4f._m23(f23);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    private Matrix4f invertGeneric(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f4 - (f5 * f6);
        float f8 = this.m12;
        float f9 = f2 * f8;
        float f10 = this.m02;
        float f11 = f9 - (f10 * f6);
        float f12 = this.m13;
        float f13 = f2 * f12;
        float f14 = this.m03;
        float f15 = f13 - (f14 * f6);
        float f16 = (f5 * f8) - (f10 * f3);
        float f17 = (f5 * f12) - (f14 * f3);
        float f18 = (f10 * f12) - (f14 * f8);
        float f19 = this.m20;
        float f20 = f2;
        float f21 = this.m31;
        float f22 = f19 * f21;
        float f23 = f6;
        float f24 = this.m21;
        float f25 = f14;
        float f26 = this.m30;
        float f27 = f10;
        float f28 = f22 - (f24 * f26);
        float f29 = f5;
        float f30 = this.m32;
        float f31 = f19 * f30;
        float f32 = f12;
        float f33 = this.m22;
        float f34 = f8;
        float f35 = f31 - (f33 * f26);
        float f36 = f3;
        float f37 = this.m33;
        float f38 = f19 * f37;
        float f39 = f19;
        float f40 = this.m23;
        float f41 = f38 - (f40 * f26);
        float f42 = (f24 * f30) - (f33 * f21);
        float f43 = (f24 * f37) - (f40 * f21);
        float f44 = (f33 * f37) - (f40 * f30);
        float f45 = f7;
        float f46 = f11;
        float h2 = a.h(f18, f28, ((f16 * f41) + ((f15 * f42) + ((f7 * f44) - (f11 * f43)))) - (f17 * f35), 1.0f);
        float f47 = f28;
        float f48 = f32;
        float g2 = a.g(f48, f42, (f36 * f44) - (f34 * f43), h2);
        float f49 = f29;
        float f50 = f15;
        float f51 = (f27 * f43) + ((-f49) * f44);
        float f52 = f49;
        float f53 = f25;
        float i2 = a.i(f53, f42, f51, h2);
        float g3 = a.g(f37, f16, (f21 * f18) - (f30 * f17), h2);
        float i3 = a.i(f40, f16, (f33 * f17) + ((-f24) * f18), h2);
        float f54 = f23;
        float f55 = f16;
        float i4 = a.i(f48, f35, (f34 * f41) + ((-f54) * f44), h2);
        float g4 = a.g(f53, f35, (f44 * f20) - (f27 * f41), h2);
        float f56 = (f30 * f50) + ((-f26) * f18);
        float f57 = f30;
        float f58 = f46;
        float i5 = a.i(f37, f58, f56, h2);
        float f59 = (f54 * f43) - (f36 * f41);
        float g5 = a.g(f40, f58, (f18 * f39) - (f33 * f50), h2);
        float f60 = f47;
        float g6 = a.g(f48, f60, f59, h2);
        float f61 = f20;
        float f62 = g6;
        float i6 = a.i(f53, f60, (f41 * f52) + ((-f61) * f43), h2);
        float f63 = f45;
        float g7 = a.g(f37, f63, (f26 * f17) - (f21 * f50), h2);
        float f64 = f39;
        float f65 = g7;
        float i7 = a.i(f40, f63, (f50 * f24) + ((-f64) * f17), h2);
        float i8 = a.i(f34, f60, (f36 * f35) + ((-f54) * f42), h2);
        float g8 = a.g(f27, f60, (f42 * f61) - (f35 * f52), h2);
        float i9 = a.i(f57, f63, (f21 * f58) + ((-f26) * f55), h2);
        float f66 = ((f33 * f63) + ((f64 * f55) - (f24 * f58))) * h2;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m00(g2);
        matrix4f3._m01(i2);
        matrix4f3._m02(g3);
        matrix4f3._m03(i3);
        a.a(matrix4f3, i4, g4, i5, g5);
        a.b(matrix4f3, f62, i6, f65, i7);
        a.c(matrix4f3, i8, g8, i9, f66);
        matrix4f3._properties(0);
        return matrix4f3;
    }

    private Matrix4f invertOrthonormal(Matrix4f matrix4f) {
        float f2 = this.m00;
        float f3 = this.m30;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m31;
        float f7 = (f5 * f6) + f4;
        float f8 = this.m02;
        float f9 = this.m32;
        float f10 = -((f8 * f9) + f7);
        float f11 = (this.m11 * f6) + (this.m10 * f3);
        float f12 = this.m12;
        float f13 = -((f12 * f9) + f11);
        float f14 = -((this.m22 * f9) + (this.m21 * f6) + (this.m20 * f3));
        matrix4f._m00(f2);
        matrix4f._m01(this.m10);
        matrix4f._m02(this.m20);
        matrix4f._m03(0.0f);
        matrix4f._m10(f5);
        matrix4f._m11(this.m11);
        matrix4f._m12(this.m21);
        matrix4f._m13(0.0f);
        matrix4f._m20(f8);
        matrix4f._m21(f12);
        matrix4f._m22(this.m22);
        matrix4f._m23(0.0f);
        matrix4f._m30(f10);
        matrix4f._m31(f13);
        matrix4f._m32(f14);
        matrix4f._m33(1.0f);
        matrix4f._properties(18);
        return matrix4f;
    }

    private Matrix4f invertTranslation(Matrix4f matrix4f) {
        if (matrix4f != this) {
            matrix4f.set((Matrix4fc) this);
        }
        matrix4f.m30 = -this.m30;
        matrix4f.m31 = -this.m31;
        matrix4f.m32 = -this.m32;
        matrix4f._properties(26);
        return matrix4f;
    }

    private Matrix4f lookAlongGeneric(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f36 = f35 * f15;
        float f37 = f20;
        float f38 = this.m12;
        float f39 = (f38 * f18) + f36;
        float f40 = f17;
        float f41 = this.m22;
        float f42 = f41;
        float f43 = (f41 * f9) + f39;
        float f44 = this.m03;
        float f45 = f15 * f44;
        float f46 = f44;
        float f47 = this.m13;
        float f48 = (f18 * f47) + f45;
        float f49 = this.m23;
        float f50 = (f9 * f49) + f48;
        float f51 = (f25 * f10) + (f23 * f19) + (f21 * f16);
        float f52 = f32 * f10;
        float f53 = f52 + (f30 * f19) + (f27 * f16);
        float f54 = (f42 * f10) + (f38 * f19) + (f35 * f16);
        float f55 = f49 * f10;
        float f56 = f55 + (f47 * f19) + (f16 * f46);
        float f57 = f25 * f33;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f57 + (f23 * f37) + (f21 * f40));
        matrix4f3._m21((this.m21 * f33) + (this.m11 * f37) + (this.m01 * f40));
        matrix4f3._m22((this.m22 * f33) + (this.m12 * f37) + (this.m02 * f40));
        matrix4f3._m23((this.m23 * f33) + (this.m13 * f37) + (this.m03 * f40));
        matrix4f3._m00(f29);
        matrix4f3._m01(f34);
        matrix4f3._m02(f43);
        matrix4f3._m03(f50);
        a.a(matrix4f3, f51, f53, f54, f56);
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f lookAtGeneric(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f11 = f2 - f5;
        float f12 = f3 - f6;
        float f13 = f4 - f7;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        float f26 = -((f22 * f4) + (f21 * f3) + (f20 * f2));
        float f27 = -((f25 * f4) + (f24 * f3) + (f23 * f2));
        float f28 = -((f16 * f4) + (f15 * f3) + (f14 * f2));
        matrix4f2._m30((this.m20 * f28) + (this.m10 * f27) + (this.m00 * f26) + this.m30);
        matrix4f2._m31((this.m21 * f28) + (this.m11 * f27) + (this.m01 * f26) + this.m31);
        matrix4f2._m32((this.m22 * f28) + (this.m12 * f27) + (this.m02 * f26) + this.m32);
        matrix4f2._m33((this.m23 * f28) + (this.m13 * f27) + (this.m03 * f26) + this.m33);
        float f29 = this.m00;
        float f30 = f29 * f20;
        float f31 = this.m10;
        float f32 = (f31 * f23) + f30;
        float f33 = this.m20;
        float f34 = (f33 * f14) + f32;
        float f35 = this.m01;
        float f36 = f35 * f20;
        float f37 = f34;
        float f38 = this.m11;
        float f39 = (f38 * f23) + f36;
        float f40 = this.m21;
        float f41 = f16;
        float f42 = (f40 * f14) + f39;
        float f43 = this.m02;
        float f44 = f43 * f20;
        float f45 = f25;
        float f46 = this.m12;
        float f47 = (f46 * f23) + f44;
        float f48 = f22;
        float f49 = this.m22;
        float f50 = f49;
        float f51 = (f49 * f14) + f47;
        float f52 = this.m03;
        float f53 = f20 * f52;
        float f54 = f52;
        float f55 = this.m13;
        float f56 = (f23 * f55) + f53;
        float f57 = this.m23;
        float f58 = (f14 * f57) + f56;
        float f59 = (f33 * f15) + (f31 * f24) + (f29 * f21);
        float f60 = f40 * f15;
        float f61 = f60 + (f38 * f24) + (f35 * f21);
        float f62 = (f50 * f15) + (f46 * f24) + (f43 * f21);
        float f63 = f57 * f15;
        float f64 = f63 + (f55 * f24) + (f21 * f54);
        float f65 = f33 * f41;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f65 + (f31 * f45) + (f29 * f48));
        matrix4f3._m21((this.m21 * f41) + (this.m11 * f45) + (this.m01 * f48));
        matrix4f3._m22((this.m22 * f41) + (this.m12 * f45) + (this.m02 * f48));
        matrix4f3._m23((this.m23 * f41) + (this.m13 * f45) + (this.m03 * f48));
        matrix4f3._m00(f37);
        matrix4f3._m01(f42);
        matrix4f3._m02(f51);
        matrix4f3._m03(f58);
        a.a(matrix4f3, f59, f61, f62, f64);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f lookAtLHGeneric(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float f13 = f7 - f4;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        float f26 = -((f22 * f4) + (f21 * f3) + (f20 * f2));
        float f27 = -((f25 * f4) + (f24 * f3) + (f23 * f2));
        float f28 = -((f16 * f4) + (f15 * f3) + (f14 * f2));
        matrix4f2._m30((this.m20 * f28) + (this.m10 * f27) + (this.m00 * f26) + this.m30);
        matrix4f2._m31((this.m21 * f28) + (this.m11 * f27) + (this.m01 * f26) + this.m31);
        matrix4f2._m32((this.m22 * f28) + (this.m12 * f27) + (this.m02 * f26) + this.m32);
        matrix4f2._m33((this.m23 * f28) + (this.m13 * f27) + (this.m03 * f26) + this.m33);
        float f29 = this.m00;
        float f30 = f29 * f20;
        float f31 = this.m10;
        float f32 = (f31 * f23) + f30;
        float f33 = this.m20;
        float f34 = (f33 * f14) + f32;
        float f35 = this.m01;
        float f36 = f35 * f20;
        float f37 = f34;
        float f38 = this.m11;
        float f39 = (f38 * f23) + f36;
        float f40 = this.m21;
        float f41 = f16;
        float f42 = (f40 * f14) + f39;
        float f43 = this.m02;
        float f44 = f43 * f20;
        float f45 = f25;
        float f46 = this.m12;
        float f47 = (f46 * f23) + f44;
        float f48 = f22;
        float f49 = this.m22;
        float f50 = f49;
        float f51 = (f49 * f14) + f47;
        float f52 = this.m03;
        float f53 = f20 * f52;
        float f54 = f52;
        float f55 = this.m13;
        float f56 = (f23 * f55) + f53;
        float f57 = this.m23;
        float f58 = (f14 * f57) + f56;
        float f59 = (f33 * f15) + (f31 * f24) + (f29 * f21);
        float f60 = f40 * f15;
        float f61 = f60 + (f38 * f24) + (f35 * f21);
        float f62 = (f50 * f15) + (f46 * f24) + (f43 * f21);
        float f63 = f57 * f15;
        float f64 = f63 + (f55 * f24) + (f21 * f54);
        float f65 = f33 * f41;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f65 + (f31 * f45) + (f29 * f48));
        matrix4f3._m21((this.m21 * f41) + (this.m11 * f45) + (this.m01 * f48));
        matrix4f3._m22((this.m22 * f41) + (this.m12 * f45) + (this.m02 * f48));
        matrix4f3._m23((this.m23 * f41) + (this.m13 * f45) + (this.m03 * f48));
        matrix4f3._m00(f37);
        matrix4f3._m01(f42);
        matrix4f3._m02(f51);
        matrix4f3._m03(f58);
        a.a(matrix4f3, f59, f61, f62, f64);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f mulGeneric(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m032 = (matrix4fc.m03() * this.m30) + (matrix4fc.m02() * this.m20) + (matrix4fc.m01() * this.m10) + (matrix4fc.m00() * this.m00);
        float m033 = (matrix4fc.m03() * this.m31) + (matrix4fc.m02() * this.m21) + (matrix4fc.m01() * this.m11) + (matrix4fc.m00() * this.m01);
        float m034 = (matrix4fc.m03() * this.m32) + (matrix4fc.m02() * this.m22) + (matrix4fc.m01() * this.m12) + (matrix4fc.m00() * this.m02);
        float m035 = (matrix4fc.m03() * this.m33) + (matrix4fc.m02() * this.m23) + (matrix4fc.m01() * this.m13) + (matrix4fc.m00() * this.m03);
        float m132 = (matrix4fc.m13() * this.m30) + (matrix4fc.m12() * this.m20) + (matrix4fc.m11() * this.m10) + (matrix4fc.m10() * this.m00);
        float m133 = (matrix4fc.m13() * this.m31) + (matrix4fc.m12() * this.m21) + (matrix4fc.m11() * this.m11) + (matrix4fc.m10() * this.m01);
        float m134 = (matrix4fc.m13() * this.m32) + (matrix4fc.m12() * this.m22) + (matrix4fc.m11() * this.m12) + (matrix4fc.m10() * this.m02);
        float m135 = (matrix4fc.m13() * this.m33) + (matrix4fc.m12() * this.m23) + (matrix4fc.m11() * this.m13) + (matrix4fc.m10() * this.m03);
        float m232 = (matrix4fc.m23() * this.m30) + (matrix4fc.m22() * this.m20) + (matrix4fc.m21() * this.m10) + (matrix4fc.m20() * this.m00);
        float m233 = (matrix4fc.m23() * this.m31) + (matrix4fc.m22() * this.m21) + (matrix4fc.m21() * this.m11) + (matrix4fc.m20() * this.m01);
        float m234 = (matrix4fc.m23() * this.m32) + (matrix4fc.m22() * this.m22) + (matrix4fc.m21() * this.m12) + (matrix4fc.m20() * this.m02);
        float m235 = (matrix4fc.m23() * this.m33) + (matrix4fc.m22() * this.m23) + (matrix4fc.m21() * this.m13) + (matrix4fc.m20() * this.m03);
        float m332 = (matrix4fc.m33() * this.m30) + (matrix4fc.m32() * this.m20) + (matrix4fc.m31() * this.m10) + (matrix4fc.m30() * this.m00);
        float m333 = (matrix4fc.m33() * this.m31) + (matrix4fc.m32() * this.m21) + (matrix4fc.m31() * this.m11) + (matrix4fc.m30() * this.m01);
        float m334 = (matrix4fc.m33() * this.m32) + (matrix4fc.m32() * this.m22) + (matrix4fc.m31() * this.m12) + (matrix4fc.m30() * this.m02);
        float m335 = (matrix4fc.m33() * this.m33) + (matrix4fc.m32() * this.m23) + (matrix4fc.m31() * this.m13) + (matrix4fc.m30() * this.m03);
        matrix4f2._m00(m032);
        matrix4f2._m01(m033);
        matrix4f2._m02(m034);
        matrix4f2._m03(m035);
        matrix4f2._m10(m132);
        matrix4f2._m11(m133);
        matrix4f2._m12(m134);
        matrix4f2._m13(m135);
        matrix4f2._m20(m232);
        matrix4f2._m21(m233);
        matrix4f2._m22(m234);
        matrix4f2._m23(m235);
        matrix4f2._m30(m332);
        matrix4f2._m31(m333);
        matrix4f2._m32(m334);
        matrix4f2._m33(m335);
        matrix4f2._properties(0);
        return matrix4f2;
    }

    private Matrix4f mulLocalGeneric(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m302 = (matrix4fc.m30() * this.m03) + (matrix4fc.m20() * this.m02) + (matrix4fc.m10() * this.m01) + (matrix4fc.m00() * this.m00);
        float m312 = (matrix4fc.m31() * this.m03) + (matrix4fc.m21() * this.m02) + (matrix4fc.m11() * this.m01) + (matrix4fc.m01() * this.m00);
        float m322 = (matrix4fc.m32() * this.m03) + (matrix4fc.m22() * this.m02) + (matrix4fc.m12() * this.m01) + (matrix4fc.m02() * this.m00);
        float m332 = (matrix4fc.m33() * this.m03) + (matrix4fc.m23() * this.m02) + (matrix4fc.m13() * this.m01) + (matrix4fc.m03() * this.m00);
        float m303 = (matrix4fc.m30() * this.m13) + (matrix4fc.m20() * this.m12) + (matrix4fc.m10() * this.m11) + (matrix4fc.m00() * this.m10);
        float m313 = (matrix4fc.m31() * this.m13) + (matrix4fc.m21() * this.m12) + (matrix4fc.m11() * this.m11) + (matrix4fc.m01() * this.m10);
        float m323 = (matrix4fc.m32() * this.m13) + (matrix4fc.m22() * this.m12) + (matrix4fc.m12() * this.m11) + (matrix4fc.m02() * this.m10);
        float m333 = (matrix4fc.m33() * this.m13) + (matrix4fc.m23() * this.m12) + (matrix4fc.m13() * this.m11) + (matrix4fc.m03() * this.m10);
        float m304 = (matrix4fc.m30() * this.m23) + (matrix4fc.m20() * this.m22) + (matrix4fc.m10() * this.m21) + (matrix4fc.m00() * this.m20);
        float m314 = (matrix4fc.m31() * this.m23) + (matrix4fc.m21() * this.m22) + (matrix4fc.m11() * this.m21) + (matrix4fc.m01() * this.m20);
        float m324 = (matrix4fc.m32() * this.m23) + (matrix4fc.m22() * this.m22) + (matrix4fc.m12() * this.m21) + (matrix4fc.m02() * this.m20);
        float m334 = (matrix4fc.m33() * this.m23) + (matrix4fc.m23() * this.m22) + (matrix4fc.m13() * this.m21) + (matrix4fc.m03() * this.m20);
        float f2 = m304;
        float m305 = (matrix4fc.m30() * this.m33) + (matrix4fc.m20() * this.m32) + (matrix4fc.m10() * this.m31) + (matrix4fc.m00() * this.m30);
        float f3 = m305;
        float m315 = (matrix4fc.m31() * this.m33) + (matrix4fc.m21() * this.m32) + (matrix4fc.m11() * this.m31) + (matrix4fc.m01() * this.m30);
        float f4 = m315;
        float m325 = (matrix4fc.m32() * this.m33) + (matrix4fc.m22() * this.m32) + (matrix4fc.m12() * this.m31) + (matrix4fc.m02() * this.m30);
        float f5 = m325;
        float m335 = (matrix4fc.m33() * this.m33) + (matrix4fc.m23() * this.m32) + (matrix4fc.m13() * this.m31) + (matrix4fc.m03() * this.m30);
        matrix4f2._m00(m302);
        matrix4f2._m01(m312);
        matrix4f2._m02(m322);
        matrix4f2._m03(m332);
        a.a(matrix4f2, m303, m313, m323, m333);
        a.b(matrix4f2, f2, m314, m324, m334);
        a.c(matrix4f2, f3, f4, f5, m335);
        matrix4f2._properties(0);
        return matrix4f2;
    }

    private Matrix4f normalGeneric(Matrix4f matrix4f) {
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
        matrix4f._m00(i2);
        matrix4f._m01(i3);
        matrix4f._m02(i4);
        matrix4f._m03(0.0f);
        a.a(matrix4f, i5, i6, i7, 0.0f);
        a.b(matrix4f, f22, f23, f24, 0.0f);
        a.c(matrix4f, 0.0f, 0.0f, 0.0f, 1.0f);
        matrix4f._properties(18);
        return matrix4f;
    }

    private Matrix4f normalOrthonormal(Matrix4f matrix4f) {
        if (matrix4f != this) {
            matrix4f.set((Matrix4fc) this);
        }
        matrix4f._properties(18);
        return matrix4f;
    }

    private Vector3f originGeneric(Vector3f vector3f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f4 - (f5 * f6);
        float f8 = this.m12;
        float f9 = f2 * f8;
        float f10 = this.m02;
        float f11 = f9 - (f10 * f6);
        float f12 = this.m13;
        float f13 = f2 * f12;
        float f14 = this.m03;
        float f15 = f13 - (f14 * f6);
        float f16 = (f5 * f8) - (f10 * f3);
        float f17 = (f5 * f12) - (f14 * f3);
        float f18 = (f12 * f10) - (f14 * f8);
        float f19 = this.m20;
        float f20 = this.m31;
        float f21 = f19 * f20;
        float f22 = f10;
        float f23 = this.m21;
        float f24 = f5;
        float f25 = this.m30;
        float f26 = f21 - (f23 * f25);
        float f27 = f2;
        float f28 = this.m32;
        float f29 = f19 * f28;
        float f30 = f8;
        float f31 = this.m22;
        float f32 = f29 - (f31 * f25);
        float f33 = f3;
        float f34 = this.m33;
        float f35 = f19 * f34;
        float f36 = f19;
        float f37 = this.m23;
        float f38 = (f23 * f28) - (f31 * f20);
        float f39 = f15 * f38;
        float f40 = (f35 - (f37 * f25)) * f16;
        float f41 = f18 * f26;
        float i2 = f41 + ((f40 + (f39 + (a.i(f37, f28, f34 * f31, f7) - (((f23 * f34) - (f37 * f20)) * f11)))) - (f17 * f32));
        float f42 = 1.0f / i2;
        float i3 = a.i(f30, f26, (f33 * f32) + ((-f6) * f38), f42);
        float g2 = a.g(f22, f26, (f27 * f38) - (f24 * f32), f42);
        float i4 = a.i(f28, f7, (f20 * f11) + ((-f25) * f16), f42);
        float h2 = a.h(f31, f7, (f36 * f16) - (f23 * f11), i2);
        return vector3f.set(i3 * h2, g2 * h2, i4 * h2);
    }

    private Matrix4f ortho2DGeneric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        float f6 = 2.0f / (f3 - f2);
        float f7 = 2.0f / (f5 - f4);
        float f8 = (f3 + f2) / (f2 - f3);
        float f9 = (f5 + f4) / (f4 - f5);
        matrix4f._m30((this.m10 * f9) + (this.m00 * f8) + this.m30);
        matrix4f._m31((this.m11 * f9) + (this.m01 * f8) + this.m31);
        matrix4f._m32((this.m12 * f9) + (this.m02 * f8) + this.m32);
        matrix4f._m33((this.m13 * f9) + (this.m03 * f8) + this.m33);
        matrix4f._m00(this.m00 * f6);
        matrix4f._m01(this.m01 * f6);
        matrix4f._m02(this.m02 * f6);
        matrix4f._m03(this.m03 * f6);
        matrix4f._m10(this.m10 * f7);
        matrix4f._m11(this.m11 * f7);
        matrix4f._m12(this.m12 * f7);
        matrix4f._m13(this.m13 * f7);
        matrix4f._m20(-this.m20);
        matrix4f._m21(-this.m21);
        matrix4f._m22(-this.m22);
        matrix4f._m23(-this.m23);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f ortho2DLHGeneric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        float f6 = 2.0f / (f3 - f2);
        float f7 = 2.0f / (f5 - f4);
        float f8 = (f3 + f2) / (f2 - f3);
        float f9 = (f5 + f4) / (f4 - f5);
        matrix4f._m30((this.m10 * f9) + (this.m00 * f8) + this.m30);
        matrix4f._m31((this.m11 * f9) + (this.m01 * f8) + this.m31);
        matrix4f._m32((this.m12 * f9) + (this.m02 * f8) + this.m32);
        matrix4f._m33((this.m13 * f9) + (this.m03 * f8) + this.m33);
        matrix4f._m00(this.m00 * f6);
        matrix4f._m01(this.m01 * f6);
        matrix4f._m02(this.m02 * f6);
        matrix4f._m03(this.m03 * f6);
        matrix4f._m10(this.m10 * f7);
        matrix4f._m11(this.m11 * f7);
        matrix4f._m12(this.m12 * f7);
        matrix4f._m13(this.m13 * f7);
        matrix4f._m20(this.m20);
        matrix4f._m21(this.m21);
        matrix4f._m22(this.m22);
        matrix4f._m23(this.m23);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f orthoGeneric(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        float f8 = 2.0f;
        float f9 = 2.0f / (f3 - f2);
        float f10 = 2.0f / (f5 - f4);
        if (z) {
            f8 = 1.0f;
        }
        float f11 = f6 - f7;
        float f12 = f8 / f11;
        float f13 = (f2 + f3) / (f2 - f3);
        float f14 = (f5 + f4) / (f4 - f5);
        if (!z) {
            f6 += f7;
        }
        float f15 = f6 / f11;
        matrix4f._m30((this.m20 * f15) + (this.m10 * f14) + (this.m00 * f13) + this.m30);
        matrix4f._m31((this.m21 * f15) + (this.m11 * f14) + (this.m01 * f13) + this.m31);
        matrix4f._m32((this.m22 * f15) + (this.m12 * f14) + (this.m02 * f13) + this.m32);
        matrix4f._m33((this.m23 * f15) + (this.m13 * f14) + (this.m03 * f13) + this.m33);
        matrix4f._m00(this.m00 * f9);
        matrix4f._m01(this.m01 * f9);
        matrix4f._m02(this.m02 * f9);
        matrix4f._m03(this.m03 * f9);
        matrix4f._m10(this.m10 * f10);
        matrix4f._m11(this.m11 * f10);
        matrix4f._m12(this.m12 * f10);
        matrix4f._m13(this.m13 * f10);
        matrix4f._m20(this.m20 * f12);
        matrix4f._m21(this.m21 * f12);
        matrix4f._m22(this.m22 * f12);
        matrix4f._m23(this.m23 * f12);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f orthoLHGeneric(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        float f8 = 2.0f;
        float f9 = 2.0f / (f3 - f2);
        float f10 = 2.0f / (f5 - f4);
        if (z) {
            f8 = 1.0f;
        }
        float f11 = f8 / (f7 - f6);
        float f12 = (f2 + f3) / (f2 - f3);
        float f13 = (f5 + f4) / (f4 - f5);
        float f14 = (z ? f6 : f7 + f6) / (f6 - f7);
        matrix4f._m30((this.m20 * f14) + (this.m10 * f13) + (this.m00 * f12) + this.m30);
        matrix4f._m31((this.m21 * f14) + (this.m11 * f13) + (this.m01 * f12) + this.m31);
        matrix4f._m32((this.m22 * f14) + (this.m12 * f13) + (this.m02 * f12) + this.m32);
        matrix4f._m33((this.m23 * f14) + (this.m13 * f13) + (this.m03 * f12) + this.m33);
        matrix4f._m00(this.m00 * f9);
        matrix4f._m01(this.m01 * f9);
        matrix4f._m02(this.m02 * f9);
        matrix4f._m03(this.m03 * f9);
        matrix4f._m10(this.m10 * f10);
        matrix4f._m11(this.m11 * f10);
        matrix4f._m12(this.m12 * f10);
        matrix4f._m13(this.m13 * f10);
        matrix4f._m20(this.m20 * f11);
        matrix4f._m21(this.m21 * f11);
        matrix4f._m22(this.m22 * f11);
        matrix4f._m23(this.m23 * f11);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f orthoSymmetricGeneric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        float f6 = 2.0f;
        float f7 = 2.0f / f2;
        float f8 = 2.0f / f3;
        if (z) {
            f6 = 1.0f;
        }
        float f9 = f4 - f5;
        float f10 = f6 / f9;
        if (!z) {
            f4 += f5;
        }
        float f11 = f4 / f9;
        matrix4f._m30((this.m20 * f11) + this.m30);
        matrix4f._m31((this.m21 * f11) + this.m31);
        matrix4f._m32((this.m22 * f11) + this.m32);
        matrix4f._m33((this.m23 * f11) + this.m33);
        matrix4f._m00(this.m00 * f7);
        matrix4f._m01(this.m01 * f7);
        matrix4f._m02(this.m02 * f7);
        matrix4f._m03(this.m03 * f7);
        matrix4f._m10(this.m10 * f8);
        matrix4f._m11(this.m11 * f8);
        matrix4f._m12(this.m12 * f8);
        matrix4f._m13(this.m13 * f8);
        matrix4f._m20(this.m20 * f10);
        matrix4f._m21(this.m21 * f10);
        matrix4f._m22(this.m22 * f10);
        matrix4f._m23(this.m23 * f10);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f orthoSymmetricLHGeneric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        float f6 = 2.0f;
        float f7 = 2.0f / f2;
        float f8 = 2.0f / f3;
        if (z) {
            f6 = 1.0f;
        }
        float f9 = f6 / (f5 - f4);
        float f10 = (z ? f4 : f5 + f4) / (f4 - f5);
        matrix4f._m30((this.m20 * f10) + this.m30);
        matrix4f._m31((this.m21 * f10) + this.m31);
        matrix4f._m32((this.m22 * f10) + this.m32);
        matrix4f._m33((this.m23 * f10) + this.m33);
        matrix4f._m00(this.m00 * f7);
        matrix4f._m01(this.m01 * f7);
        matrix4f._m02(this.m02 * f7);
        matrix4f._m03(this.m03 * f7);
        matrix4f._m10(this.m10 * f8);
        matrix4f._m11(this.m11 * f8);
        matrix4f._m12(this.m12 * f8);
        matrix4f._m13(this.m13 * f8);
        matrix4f._m20(this.m20 * f9);
        matrix4f._m21(this.m21 * f9);
        matrix4f._m22(this.m22 * f9);
        matrix4f._m23(this.m23 * f9);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    private Matrix4f perspectiveGeneric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        float f6;
        float f7;
        float tan = (float) Math.tan((double) (f2 * 0.5f));
        float f8 = 1.0f;
        float f9 = 1.0f / (f3 * tan);
        float f10 = 1.0f / tan;
        float f11 = 0.0f;
        boolean z2 = true;
        boolean z3 = f5 > 0.0f && Float.isInfinite(f5);
        if (f4 <= 0.0f || !Float.isInfinite(f4)) {
            z2 = false;
        }
        if (z3) {
            f6 = -0.999999f;
            if (!z) {
                f8 = 2.0f;
            }
            f7 = (1.0E-6f - f8) * f4;
        } else if (z2) {
            if (!z) {
                f11 = 1.0f;
            }
            float f12 = f11 - 1.0E-6f;
            if (!z) {
                f8 = 2.0f;
            }
            f7 = (f8 - 1.0E-6f) * f5;
            f6 = f12;
        } else {
            float f13 = f4 - f5;
            float f14 = (z ? f5 : f5 + f4) / f13;
            if (!z) {
                f5 += f5;
            }
            f7 = (f5 * f4) / f13;
            f6 = f14;
        }
        float f15 = (this.m20 * f6) - this.m30;
        float f16 = (this.m21 * f6) - this.m31;
        float f17 = (this.m22 * f6) - this.m32;
        float f18 = (this.m23 * f6) - this.m33;
        matrix4f._m00(this.m00 * f9);
        matrix4f._m01(this.m01 * f9);
        matrix4f._m02(this.m02 * f9);
        matrix4f._m03(this.m03 * f9);
        matrix4f._m10(this.m10 * f10);
        matrix4f._m11(this.m11 * f10);
        matrix4f._m12(this.m12 * f10);
        matrix4f._m13(this.m13 * f10);
        matrix4f._m30(this.m20 * f7);
        matrix4f._m31(this.m21 * f7);
        matrix4f._m32(this.m22 * f7);
        matrix4f._m33(this.m23 * f7);
        matrix4f._m20(f15);
        matrix4f._m21(f16);
        matrix4f._m22(f17);
        matrix4f._m23(f18);
        matrix4f._properties(this.properties & -31);
        return matrix4f;
    }

    private Matrix4f perspectiveLHGeneric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        float f6;
        float f7;
        float tan = (float) Math.tan((double) (f2 * 0.5f));
        float f8 = 1.0f;
        float f9 = 1.0f / (f3 * tan);
        float f10 = 1.0f / tan;
        float f11 = 0.0f;
        boolean z2 = true;
        boolean z3 = f5 > 0.0f && Float.isInfinite(f5);
        if (f4 <= 0.0f || !Float.isInfinite(f4)) {
            z2 = false;
        }
        if (z3) {
            f6 = 0.999999f;
            if (!z) {
                f8 = 2.0f;
            }
            f7 = (1.0E-6f - f8) * f4;
        } else if (z2) {
            if (!z) {
                f11 = 1.0f;
            }
            float f12 = f11 - 1.0E-6f;
            if (!z) {
                f8 = 2.0f;
            }
            f7 = (f8 - 1.0E-6f) * f5;
            f6 = f12;
        } else {
            f7 = ((z ? f5 : f5 + f5) * f4) / (f4 - f5);
            f6 = (z ? f5 : f5 + f4) / (f5 - f4);
        }
        float f13 = (this.m20 * f6) + this.m30;
        float f14 = (this.m21 * f6) + this.m31;
        float f15 = (this.m22 * f6) + this.m32;
        float f16 = (this.m23 * f6) + this.m33;
        matrix4f._m00(this.m00 * f9);
        matrix4f._m01(this.m01 * f9);
        matrix4f._m02(this.m02 * f9);
        matrix4f._m03(this.m03 * f9);
        matrix4f._m10(this.m10 * f10);
        matrix4f._m11(this.m11 * f10);
        matrix4f._m12(this.m12 * f10);
        matrix4f._m13(this.m13 * f10);
        matrix4f._m30(this.m20 * f7);
        matrix4f._m31(this.m21 * f7);
        matrix4f._m32(this.m22 * f7);
        matrix4f._m33(this.m23 * f7);
        matrix4f._m20(f13);
        matrix4f._m21(f14);
        matrix4f._m22(f15);
        matrix4f._m23(f16);
        matrix4f._properties(this.properties & -31);
        return matrix4f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00cb, code lost:
        if (r32 < 0.0f) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void projViewFromRectangle(com.arashivision.insbase.joml.Vector3f r28, com.arashivision.insbase.joml.Vector3f r29, com.arashivision.insbase.joml.Vector3f r30, com.arashivision.insbase.joml.Vector3f r31, float r32, boolean r33, com.arashivision.insbase.joml.Matrix4f r34, com.arashivision.insbase.joml.Matrix4f r35) {
        /*
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r31
            r14 = r35
            float r4 = r3.y
            float r5 = r2.z
            float r6 = r4 * r5
            float r7 = r3.z
            float r8 = r2.y
            float r9 = r7 * r8
            float r6 = r6 - r9
            float r9 = r2.x
            float r7 = r7 * r9
            float r10 = r3.x
            float r5 = r5 * r10
            float r7 = r7 - r5
            float r10 = r10 * r8
            float r4 = r4 * r9
            float r10 = r10 - r4
            float r4 = r1.x
            float r5 = r0.x
            float r4 = r4 - r5
            float r4 = r4 * r6
            float r5 = r1.y
            float r8 = r0.y
            float r4 = e.a.a.a.a.e(r5, r8, r7, r4)
            float r5 = r1.z
            float r8 = r0.z
            float r4 = e.a.a.a.a.e(r5, r8, r10, r4)
            r15 = 0
            int r5 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r5 < 0) goto L_0x003f
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0041
        L_0x003f:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0041:
            float r16 = r6 * r5
            float r17 = r7 * r5
            float r18 = r10 * r5
            float r19 = r4 * r5
            float r5 = r0.x
            float r6 = r0.y
            float r7 = r0.z
            float r8 = r5 + r16
            float r9 = r6 + r17
            float r10 = r7 + r18
            float r11 = r3.x
            float r12 = r3.y
            float r13 = r3.z
            r4 = r35
            r4.setLookAt(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            float r0 = r14.m00
            float r4 = r1.x
            float r5 = r0 * r4
            float r6 = r14.m10
            float r7 = r1.y
            float r8 = r6 * r7
            float r8 = r8 + r5
            float r5 = r14.m20
            float r1 = r1.z
            float r9 = r5 * r1
            float r9 = r9 + r8
            float r8 = r14.m30
            float r21 = r9 + r8
            float r8 = r14.m01
            float r4 = r4 * r8
            float r9 = r14.m11
            float r7 = r7 * r9
            float r7 = r7 + r4
            float r4 = r14.m21
            float r1 = r1 * r4
            float r1 = r1 + r7
            float r7 = r14.m31
            float r23 = r1 + r7
            float r1 = r2.x
            float r0 = r0 * r1
            float r1 = r2.y
            float r6 = r6 * r1
            float r6 = r6 + r0
            float r0 = r2.z
            float r5 = r5 * r0
            float r5 = r5 + r6
            float r0 = r3.x
            float r8 = r8 * r0
            float r0 = r3.y
            float r9 = r9 * r0
            float r9 = r9 + r8
            float r0 = r3.z
            float r4 = r4 * r0
            float r4 = r4 + r9
            float r16 = r16 * r16
            float r17 = r17 * r17
            float r17 = r17 + r16
            float r18 = r18 * r18
            float r0 = r18 + r17
            double r0 = (double) r0
            double r0 = com.arashivision.insbase.joml.Math.sqrt(r0)
            float r0 = (float) r0
            float r19 = r19 / r0
            boolean r0 = java.lang.Float.isInfinite(r32)
            r1 = 2139095040(0x7f800000, float:Infinity)
            if (r0 == 0) goto L_0x00bc
            int r0 = (r32 > r15 ? 1 : (r32 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x00bc
            goto L_0x00cd
        L_0x00bc:
            boolean r0 = java.lang.Float.isInfinite(r32)
            if (r0 == 0) goto L_0x00c7
            int r0 = (r32 > r15 ? 1 : (r32 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c7
            goto L_0x00d2
        L_0x00c7:
            int r0 = (r32 > r15 ? 1 : (r32 == r15 ? 0 : -1))
            float r1 = r19 + r32
            if (r0 >= 0) goto L_0x00d2
        L_0x00cd:
            r25 = r1
            r26 = r19
            goto L_0x00d6
        L_0x00d2:
            r26 = r1
            r25 = r19
        L_0x00d6:
            float r22 = r21 + r5
            float r24 = r23 + r4
            r20 = r34
            r27 = r33
            r20.setFrustum(r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Matrix4f.projViewFromRectangle(com.arashivision.insbase.joml.Vector3f, com.arashivision.insbase.joml.Vector3f, com.arashivision.insbase.joml.Vector3f, com.arashivision.insbase.joml.Vector3f, float, boolean, com.arashivision.insbase.joml.Matrix4f, com.arashivision.insbase.joml.Matrix4f):void");
    }

    private Matrix4f reflectAffine(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f6 = f2 + f2;
        float f7 = f3 + f3;
        float f8 = f4 + f4;
        float f9 = 1.0f - (f6 * f2);
        float f10 = -f6;
        float f11 = f10 * f3;
        float f12 = f10 * f4;
        float f13 = -f7;
        float f14 = f13 * f2;
        float f15 = 1.0f - (f7 * f3);
        float f16 = f13 * f4;
        float f17 = -f8;
        float f18 = f17 * f2;
        float f19 = f17 * f3;
        float f20 = 1.0f - (f8 * f4);
        float f21 = -(f5 + f5);
        float f22 = f21 * f2;
        float f23 = f21 * f3;
        float f24 = f21 * f4;
        matrix4f2._m30((this.m20 * f24) + (this.m10 * f23) + (this.m00 * f22) + this.m30);
        matrix4f2._m31((this.m21 * f24) + (this.m11 * f23) + (this.m01 * f22) + this.m31);
        matrix4f2._m32((this.m22 * f24) + (this.m12 * f23) + (this.m02 * f22) + this.m32);
        matrix4f2._m33(this.m33);
        float f25 = this.m00;
        float f26 = f25 * f9;
        float f27 = this.m10;
        float f28 = (f27 * f11) + f26;
        float f29 = this.m20;
        float f30 = (f29 * f12) + f28;
        float f31 = this.m01;
        float f32 = f31 * f9;
        float f33 = f30;
        float f34 = this.m11;
        float f35 = (f34 * f11) + f32;
        float f36 = this.m21;
        float f37 = f20;
        float f38 = (f36 * f12) + f35;
        float f39 = this.m02;
        float f40 = f9 * f39;
        float f41 = f19;
        float f42 = this.m12;
        float f43 = (f11 * f42) + f40;
        float f44 = this.m22;
        float f45 = (f12 * f44) + f43;
        float f46 = (f29 * f16) + (f27 * f15) + (f25 * f14);
        float f47 = f36 * f16;
        float f48 = f47 + (f34 * f15) + (f31 * f14);
        float f49 = f44 * f16;
        float f50 = f49 + (f42 * f15) + (f39 * f14);
        float f51 = f29 * f37;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f51 + (f27 * f41) + (f25 * f18));
        matrix4f3._m21((this.m21 * f37) + (this.m11 * f41) + (this.m01 * f18));
        matrix4f3._m22((this.m22 * f37) + (this.m12 * f41) + (this.m02 * f18));
        matrix4f3._m23(0.0f);
        matrix4f3._m00(f33);
        matrix4f3._m01(f38);
        matrix4f3._m02(f45);
        matrix4f3._m03(0.0f);
        matrix4f3._m10(f46);
        matrix4f3._m11(f48);
        matrix4f3._m12(f50);
        matrix4f3._m13(0.0f);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f reflectGeneric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f6 = f2 + f2;
        float f7 = f3 + f3;
        float f8 = f4 + f4;
        float f9 = 1.0f - (f6 * f2);
        float f10 = -f6;
        float f11 = f10 * f3;
        float f12 = f10 * f4;
        float f13 = -f7;
        float f14 = f13 * f2;
        float f15 = 1.0f - (f7 * f3);
        float f16 = f13 * f4;
        float f17 = -f8;
        float f18 = f17 * f2;
        float f19 = f17 * f3;
        float f20 = 1.0f - (f8 * f4);
        float f21 = -(f5 + f5);
        float f22 = f21 * f2;
        float f23 = f21 * f3;
        float f24 = f21 * f4;
        matrix4f2._m30((this.m20 * f24) + (this.m10 * f23) + (this.m00 * f22) + this.m30);
        matrix4f2._m31((this.m21 * f24) + (this.m11 * f23) + (this.m01 * f22) + this.m31);
        matrix4f2._m32((this.m22 * f24) + (this.m12 * f23) + (this.m02 * f22) + this.m32);
        matrix4f2._m33((this.m23 * f24) + (this.m13 * f23) + (this.m03 * f22) + this.m33);
        float f25 = this.m00;
        float f26 = f25 * f9;
        float f27 = this.m10;
        float f28 = (f27 * f11) + f26;
        float f29 = this.m20;
        float f30 = (f29 * f12) + f28;
        float f31 = this.m01;
        float f32 = f31 * f9;
        float f33 = f30;
        float f34 = this.m11;
        float f35 = (f34 * f11) + f32;
        float f36 = this.m21;
        float f37 = f20;
        float f38 = (f36 * f12) + f35;
        float f39 = this.m02;
        float f40 = f39 * f9;
        float f41 = f19;
        float f42 = this.m12;
        float f43 = (f42 * f11) + f40;
        float f44 = f18;
        float f45 = this.m22;
        float f46 = f45;
        float f47 = (f45 * f12) + f43;
        float f48 = this.m03;
        float f49 = f9 * f48;
        float f50 = f48;
        float f51 = this.m13;
        float f52 = (f11 * f51) + f49;
        float f53 = this.m23;
        float f54 = (f12 * f53) + f52;
        float f55 = (f29 * f16) + (f27 * f15) + (f25 * f14);
        float f56 = f36 * f16;
        float f57 = f56 + (f34 * f15) + (f31 * f14);
        float f58 = (f46 * f16) + (f42 * f15) + (f39 * f14);
        float f59 = f53 * f16;
        float f60 = f59 + (f51 * f15) + (f14 * f50);
        float f61 = f29 * f37;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f61 + (f27 * f41) + (f25 * f44));
        matrix4f3._m21((this.m21 * f37) + (this.m11 * f41) + (this.m01 * f44));
        matrix4f3._m22((this.m22 * f37) + (this.m12 * f41) + (this.m02 * f44));
        matrix4f3._m23((this.m23 * f37) + (this.m13 * f41) + (this.m03 * f44));
        matrix4f3._m00(f33);
        matrix4f3._m01(f38);
        matrix4f3._m02(f47);
        matrix4f3._m03(f54);
        a.a(matrix4f3, f55, f57, f58, f60);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f rotateAroundGeneric(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4f matrix4f2 = matrix4f;
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc2, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f5 = y2 + y2;
        float b2 = a.b(quaternionfc2, quaternionfc.x());
        float a3 = a.a(quaternionfc2, quaternionfc.y());
        float b3 = a.b(quaternionfc2, quaternionfc.y());
        float a4 = a.a(quaternionfc2, quaternionfc.x());
        float b4 = a.b(w, x, z, y);
        float f6 = f5 + a2;
        float f7 = b2 - a3;
        float f8 = (-a2) + f5;
        float c2 = a.c(y, z, w, x);
        float f9 = b3 + a4;
        float f10 = a3 + b2;
        float f11 = b3 - a4;
        float d2 = a.d(z, y, x, w);
        float f12 = this.m00;
        float f13 = f12 * f2;
        float f14 = this.m10;
        float f15 = (f14 * f3) + f13;
        float f16 = this.m20;
        float f17 = (f16 * f4) + f15 + this.m30;
        float f18 = this.m01;
        float f19 = f18 * f2;
        float f20 = f17;
        float f21 = this.m11;
        float f22 = (f21 * f3) + f19;
        float f23 = this.m21;
        float f24 = (f23 * f4) + f22;
        float f25 = d2;
        float f26 = f24 + this.m31;
        float f27 = this.m02;
        float f28 = f27 * f2;
        float f29 = f11;
        float f30 = this.m12;
        float f31 = (f30 * f3) + f28;
        float f32 = f10;
        float f33 = this.m22;
        float f34 = (f33 * f4) + f31;
        float f35 = f9;
        float f36 = f34 + this.m32;
        float f37 = (f16 * f7) + (f14 * f6) + (f12 * b4);
        float f38 = (f23 * f7) + (f21 * f6) + (f18 * b4);
        float f39 = f38;
        float f40 = (f33 * f7) + (f30 * f6) + (f27 * b4);
        float f41 = this.m03;
        float f42 = b4 * f41;
        float f43 = f41;
        float f44 = this.m13;
        float f45 = (f6 * f44) + f42;
        float f46 = this.m23;
        float f47 = (f7 * f46) + f45;
        float f48 = (f16 * f35) + (f14 * c2) + (f12 * f8);
        float f49 = f23 * f35;
        float f50 = f49 + (f21 * c2) + (f18 * f8);
        float f51 = f33 * f35;
        float f52 = f51 + (f30 * c2) + (f27 * f8);
        float f53 = f46 * f35;
        float f54 = f53 + (f44 * c2) + (f43 * f8);
        float f55 = f16 * f25;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f55 + (f14 * f29) + (f12 * f32));
        matrix4f3._m21((this.m21 * f25) + (this.m11 * f29) + (this.m01 * f32));
        matrix4f3._m22((this.m22 * f25) + (this.m12 * f29) + (this.m02 * f32));
        matrix4f3._m23((this.m23 * f25) + (this.m13 * f29) + (this.m03 * f32));
        float f56 = f37;
        matrix4f3._m00(f56);
        float f57 = f39;
        matrix4f3._m01(f57);
        float f58 = f40;
        matrix4f3._m02(f58);
        matrix4f3._m03(f47);
        a.a(matrix4f3, f48, f50, f52, f54);
        matrix4f3._m30(((((-f56) * f2) - (f48 * f3)) - (this.m20 * f4)) + f20);
        matrix4f3._m31(((((-f57) * f2) - (f50 * f3)) - (this.m21 * f4)) + f26);
        matrix4f3._m32(((((-f58) * f2) - (f52 * f3)) - (this.m22 * f4)) + f36);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f rotateGeneric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f37 = f36 * f7;
        float f38 = f20;
        float f39 = this.m12;
        float f40 = (f39 * f10) + f37;
        float f41 = f19;
        float f42 = this.m22;
        float f43 = f42;
        float f44 = (f42 * f13) + f40;
        float f45 = this.m03;
        float f46 = f7 * f45;
        float f47 = f45;
        float f48 = this.m13;
        float f49 = (f10 * f48) + f46;
        float f50 = this.m23;
        float f51 = (f13 * f50) + f49;
        float f52 = (f26 * f18) + (f24 * f15) + (f22 * f14);
        float f53 = f33 * f18;
        float f54 = f53 + (f31 * f15) + (f28 * f14);
        float f55 = (f43 * f18) + (f39 * f15) + (f36 * f14);
        float f56 = f50 * f18;
        float f57 = f56 + (f48 * f15) + (f14 * f47);
        float f58 = f26 * f34;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f58 + (f24 * f38) + (f22 * f41));
        matrix4f3._m21((this.m21 * f34) + (this.m11 * f38) + (this.m01 * f41));
        matrix4f3._m22((this.m22 * f34) + (this.m12 * f38) + (this.m02 * f41));
        matrix4f3._m23((this.m23 * f34) + (this.m13 * f38) + (this.m03 * f41));
        matrix4f3._m00(f30);
        matrix4f3._m01(f35);
        matrix4f3._m02(f44);
        matrix4f3._m03(f51);
        a.a(matrix4f3, f52, f54, f55, f57);
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    private Matrix4f rotateLocalGeneric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f31 = this.m03;
        float f32 = this.m10;
        float f33 = f7 * f32;
        float f34 = f31;
        float f35 = this.m11;
        float f36 = (f14 * f35) + f33;
        float f37 = f30;
        float f38 = this.m12;
        float f39 = f28;
        float f40 = (f19 * f38) + f36;
        float f41 = f40;
        float f42 = (f20 * f38) + (f15 * f35) + (f10 * f32);
        float f43 = f38 * f21;
        float f44 = f43 + (f35 * f18) + (f32 * f13);
        float f45 = this.m13;
        float f46 = this.m20;
        float f47 = f7 * f46;
        float f48 = f45;
        float f49 = this.m21;
        float f50 = (f14 * f49) + f47;
        float f51 = f44;
        float f52 = this.m22;
        float f53 = f42;
        float f54 = (f19 * f52) + f50;
        float f55 = (f20 * f52) + (f15 * f49) + (f10 * f46);
        float f56 = f52 * f21;
        float f57 = f56 + (f49 * f18) + (f46 * f13);
        float f58 = this.m23;
        float f59 = this.m30;
        float f60 = f7 * f59;
        float f61 = f58;
        float f62 = this.m31;
        float f63 = (f14 * f62) + f60;
        float f64 = this.m32;
        float f65 = (f19 * f64) + f63;
        float f66 = f20 * f64;
        float f67 = f66 + (f15 * f62) + (f10 * f59);
        float f68 = f21 * f64;
        float f69 = f68 + (f18 * f62) + (f13 * f59);
        float f70 = this.m33;
        matrix4f2._m00(f27);
        matrix4f2._m01(f39);
        matrix4f2._m02(f37);
        matrix4f2._m03(f34);
        a.a(matrix4f2, f41, f53, f51, f48);
        a.b(matrix4f2, f54, f55, f57, f61);
        a.c(matrix4f2, f65, f67, f69, f70);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    private Matrix4f scaleGeneric(float f2, float f3, float f4, Matrix4f matrix4f) {
        matrix4f._m00(this.m00 * f2);
        matrix4f._m01(this.m01 * f2);
        matrix4f._m02(this.m02 * f2);
        matrix4f._m03(this.m03 * f2);
        matrix4f._m10(this.m10 * f3);
        matrix4f._m11(this.m11 * f3);
        matrix4f._m12(this.m12 * f3);
        matrix4f._m13(this.m13 * f3);
        matrix4f._m20(this.m20 * f4);
        matrix4f._m21(this.m21 * f4);
        matrix4f._m22(this.m22 * f4);
        matrix4f._m23(this.m23 * f4);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        int i2 = 0;
        boolean z = Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4f._properties((~(i2 | 13)) & i3);
        return matrix4f;
    }

    private Matrix4f scaleLocalGeneric(float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f5 = this.m00 * f2;
        float f6 = this.m01 * f3;
        float f7 = this.m02 * f4;
        float f8 = this.m03;
        float f9 = this.m10 * f2;
        float f10 = this.m11 * f3;
        float f11 = this.m12 * f4;
        float f12 = this.m13;
        float f13 = this.m20 * f2;
        float f14 = this.m21 * f3;
        float f15 = this.m22 * f4;
        float f16 = this.m23;
        float f17 = this.m31 * f3;
        float f18 = this.m30 * f2;
        float f19 = this.m32 * f4;
        float f20 = this.m33;
        matrix4f2._m00(f5);
        matrix4f2._m01(f6);
        matrix4f2._m02(f7);
        matrix4f2._m03(f8);
        a.a(matrix4f2, f9, f10, f11, f12);
        a.b(matrix4f2, f13, f14, f15, f16);
        a.c(matrix4f2, f18, f17, f19, f20);
        int i2 = 0;
        boolean z = Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4f2._properties((~(i2 | 13)) & i3);
        return matrix4f2;
    }

    private void set3x3Matrix3fc(Matrix3fc matrix3fc) {
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

    private void set4x3Matrix4x3fc(Matrix4x3fc matrix4x3fc) {
        _m00(matrix4x3fc.m00());
        _m01(matrix4x3fc.m01());
        _m02(matrix4x3fc.m02());
        _m10(matrix4x3fc.m10());
        _m11(matrix4x3fc.m11());
        _m12(matrix4x3fc.m12());
        _m20(matrix4x3fc.m20());
        _m21(matrix4x3fc.m21());
        _m22(matrix4x3fc.m22());
        _m30(matrix4x3fc.m30());
        _m31(matrix4x3fc.m31());
        _m32(matrix4x3fc.m32());
    }

    private void setMatrix3fc(Matrix3fc matrix3fc) {
        this.m00 = matrix3fc.m00();
        this.m01 = matrix3fc.m01();
        this.m02 = matrix3fc.m02();
        this.m03 = 0.0f;
        this.m10 = matrix3fc.m10();
        this.m11 = matrix3fc.m11();
        this.m12 = matrix3fc.m12();
        this.m13 = 0.0f;
        this.m20 = matrix3fc.m20();
        this.m21 = matrix3fc.m21();
        this.m22 = matrix3fc.m22();
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }

    private void setMatrix4fc(Matrix4fc matrix4fc) {
        _m00(matrix4fc.m00());
        _m01(matrix4fc.m01());
        _m02(matrix4fc.m02());
        _m03(matrix4fc.m03());
        _m10(matrix4fc.m10());
        _m11(matrix4fc.m11());
        _m12(matrix4fc.m12());
        _m13(matrix4fc.m13());
        _m20(matrix4fc.m20());
        _m21(matrix4fc.m21());
        _m22(matrix4fc.m22());
        _m23(matrix4fc.m23());
        _m30(matrix4fc.m30());
        _m31(matrix4fc.m31());
        _m32(matrix4fc.m32());
        _m33(matrix4fc.m33());
    }

    private void setMatrix4x3fc(Matrix4x3fc matrix4x3fc) {
        _m00(matrix4x3fc.m00());
        _m01(matrix4x3fc.m01());
        _m02(matrix4x3fc.m02());
        _m03(0.0f);
        _m10(matrix4x3fc.m10());
        _m11(matrix4x3fc.m11());
        _m12(matrix4x3fc.m12());
        _m13(0.0f);
        _m20(matrix4x3fc.m20());
        _m21(matrix4x3fc.m21());
        _m22(matrix4x3fc.m22());
        _m23(0.0f);
        _m30(matrix4x3fc.m30());
        _m31(matrix4x3fc.m31());
        _m32(matrix4x3fc.m32());
        _m33(1.0f);
    }

    private void setVector4fc(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4fc vector4fc3, Vector4fc vector4fc4) {
        this.m00 = vector4fc.x();
        this.m01 = vector4fc.y();
        this.m02 = vector4fc.z();
        this.m03 = vector4fc.w();
        this.m10 = vector4fc2.x();
        this.m11 = vector4fc2.y();
        this.m12 = vector4fc2.z();
        this.m13 = vector4fc2.w();
        this.m20 = vector4fc3.x();
        this.m21 = vector4fc3.y();
        this.m22 = vector4fc3.z();
        this.m23 = vector4fc3.w();
        this.m30 = vector4fc4.x();
        this.m31 = vector4fc4.y();
        this.m32 = vector4fc4.z();
        this.m33 = vector4fc4.w();
    }

    private Matrix4f thisOrNew() {
        return this;
    }

    private Matrix4f translateGeneric(float f2, float f3, float f4, Matrix4f matrix4f) {
        MemUtil.INSTANCE.copy(this, matrix4f);
        matrix4f._m30((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30);
        matrix4f._m31((this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31);
        matrix4f._m32((this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32);
        matrix4f._m33((this.m23 * f4) + (this.m13 * f3) + (this.m03 * f2) + this.m33);
        matrix4f._properties(this.properties & -6);
        return matrix4f;
    }

    private Matrix4f translateLocalGeneric(float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f5 = this.m00;
        float f6 = this.m03;
        float f7 = (f2 * f6) + f5;
        float f8 = (f3 * f6) + this.m01;
        float f9 = (f4 * f6) + this.m02;
        float f10 = this.m10;
        float f11 = this.m13;
        float f12 = (f2 * f11) + f10;
        float f13 = (f3 * f11) + this.m11;
        float f14 = (f4 * f11) + this.m12;
        float f15 = this.m20;
        float f16 = this.m23;
        float f17 = (f2 * f16) + f15;
        float f18 = (f3 * f16) + this.m21;
        float f19 = (f4 * f16) + this.m22;
        float f20 = this.m30;
        float f21 = this.m33;
        float f22 = (f2 * f21) + f20;
        float f23 = (f3 * f21) + this.m31;
        float f24 = (f4 * f21) + this.m32;
        matrix4f2._m00(f7);
        matrix4f2._m01(f8);
        matrix4f2._m02(f9);
        matrix4f2._m03(f6);
        a.a(matrix4f2, f12, f13, f14, f11);
        a.b(matrix4f2, f17, f18, f19, f16);
        a.c(matrix4f2, f22, f23, f24, f21);
        matrix4f2._properties(this.properties & -6);
        return matrix4f2;
    }

    private Matrix4f transposeGeneric(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f2 = this.m00;
        float f3 = this.m10;
        float f4 = this.m20;
        float f5 = this.m30;
        float f6 = this.m01;
        float f7 = this.m11;
        float f8 = this.m21;
        float f9 = this.m31;
        float f10 = this.m02;
        float f11 = this.m12;
        float f12 = this.m22;
        float f13 = this.m32;
        float f14 = this.m03;
        float f15 = this.m13;
        float f16 = f14;
        float f17 = this.m23;
        float f18 = this.m33;
        matrix4f2._m00(f2);
        matrix4f2._m01(f3);
        matrix4f2._m02(f4);
        matrix4f2._m03(f5);
        a.a(matrix4f2, f6, f7, f8, f9);
        a.b(matrix4f2, f10, f11, f12, f13);
        a.c(matrix4f2, f16, f15, f17, f18);
        matrix4f2._properties(0);
        return matrix4f2;
    }

    public Matrix4f _m00(float f2) {
        this.m00 = f2;
        return this;
    }

    public Matrix4f _m01(float f2) {
        this.m01 = f2;
        return this;
    }

    public Matrix4f _m02(float f2) {
        this.m02 = f2;
        return this;
    }

    public Matrix4f _m03(float f2) {
        this.m03 = f2;
        return this;
    }

    public Matrix4f _m10(float f2) {
        this.m10 = f2;
        return this;
    }

    public Matrix4f _m11(float f2) {
        this.m11 = f2;
        return this;
    }

    public Matrix4f _m12(float f2) {
        this.m12 = f2;
        return this;
    }

    public Matrix4f _m13(float f2) {
        this.m13 = f2;
        return this;
    }

    public Matrix4f _m20(float f2) {
        this.m20 = f2;
        return this;
    }

    public Matrix4f _m21(float f2) {
        this.m21 = f2;
        return this;
    }

    public Matrix4f _m22(float f2) {
        this.m22 = f2;
        return this;
    }

    public Matrix4f _m23(float f2) {
        this.m23 = f2;
        return this;
    }

    public Matrix4f _m30(float f2) {
        this.m30 = f2;
        return this;
    }

    public Matrix4f _m31(float f2) {
        this.m31 = f2;
        return this;
    }

    public Matrix4f _m32(float f2) {
        this.m32 = f2;
        return this;
    }

    public Matrix4f _m33(float f2) {
        this.m33 = f2;
        return this;
    }

    public void _properties(int i2) {
        this.properties = i2;
    }

    public Matrix4f add(Matrix4fc matrix4fc) {
        return add(matrix4fc, thisOrNew());
    }

    public Matrix4f add4x3(Matrix4fc matrix4fc) {
        return add4x3(matrix4fc, thisOrNew());
    }

    public Matrix4f affineSpan(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        Vector3f vector3f5 = vector3f;
        Vector3f vector3f6 = vector3f2;
        Vector3f vector3f7 = vector3f3;
        Vector3f vector3f8 = vector3f4;
        float f2 = this.m10;
        float f3 = this.m22;
        float f4 = f2 * f3;
        float f5 = this.m21;
        float f6 = f2 * f5;
        float f7 = this.m02;
        float f8 = f2 * f7;
        float f9 = this.m01;
        float f10 = f2 * f9;
        float f11 = this.m11;
        float f12 = f11 * f3;
        float f13 = this.m20;
        float f14 = f11 * f13;
        float f15 = f11 * f7;
        float f16 = this.m00;
        float f17 = f11 * f16;
        float f18 = this.m12;
        float f19 = f18 * f5;
        float f20 = f18 * f13;
        float f21 = f18 * f9;
        float f22 = f18 * f16;
        float f23 = f13 * f7;
        float f24 = f13 * f9;
        float f25 = f5 * f7;
        float f26 = f5 * f16;
        float f27 = f3 * f9;
        float f28 = f17;
        float f29 = f3 * f16;
        float f30 = f9 * f18;
        float a2 = a.a(f7, f11, f30, f13, a.a(f16, f18, f2 * f7, f5, f3 * (1.0f / ((f16 * f11) - (f9 * f2)))));
        float f31 = (f12 - f19) * a2;
        float f32 = (f25 - f27) * a2;
        float f33 = (f21 - f15) * a2;
        float f34 = (f20 - f4) * a2;
        float f35 = (f29 - f23) * a2;
        float f36 = (f8 - f22) * a2;
        float f37 = (f6 - f14) * a2;
        float f38 = (f24 - f26) * a2;
        float f39 = (f28 - f10) * a2;
        float f40 = f20;
        float f41 = ((-f31) - f34) - f37;
        float f42 = f31;
        float f43 = f37;
        float f44 = f40;
        float f45 = f34;
        float f46 = f44;
        float f47 = this.m31;
        float f48 = f4 * f47;
        float f49 = f10;
        float f50 = this.m32;
        float f51 = (f14 * f50) + (f48 - (f6 * f50));
        float f52 = this.m30;
        float a3 = a.a(f46, f47, (f19 * f52) + (f51 - (f12 * f52)), a2, f41);
        Vector3f vector3f9 = vector3f;
        vector3f9.x = a3;
        float f53 = f27 * f52;
        vector3f9.y = a.a(f29, f47, f53 + (((f26 * f50) + ((f23 * f47) - (f24 * f50))) - (f25 * f52)), a2, ((-f32) - f35) - f38);
        float f54 = f49 * f50;
        float f55 = f54 + (((f22 * f47) + ((f15 * f52) - (f21 * f52))) - (f8 * f47));
        vector3f9.z = a.a(f28, f50, f55, a2, ((-f33) - f36) - f39);
        Vector3f vector3f10 = vector3f2;
        vector3f10.x = f42 * 2.0f;
        vector3f10.y = f32 * 2.0f;
        vector3f10.z = f33 * 2.0f;
        Vector3f vector3f11 = vector3f3;
        vector3f11.x = f45 * 2.0f;
        vector3f11.y = f35 * 2.0f;
        vector3f11.z = f36 * 2.0f;
        Vector3f vector3f12 = vector3f4;
        vector3f12.x = f43 * 2.0f;
        vector3f12.y = f38 * 2.0f;
        vector3f12.z = 2.0f * f39;
        return this;
    }

    public Matrix4f arcball(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f8 = -f2;
        float f9 = (this.m20 * f8) + this.m30;
        float f10 = (this.m21 * f8) + this.m31;
        float f11 = (this.m22 * f8) + this.m32;
        float f12 = (this.m23 * f8) + this.m33;
        double d2 = (double) f6;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f13 = this.m10;
        float f14 = f13 * cosFromSin;
        float f15 = this.m20;
        float f16 = (f15 * sin) + f14;
        float f17 = this.m11;
        float f18 = f17 * cosFromSin;
        float f19 = this.m21;
        float f20 = (f19 * sin) + f18;
        float f21 = this.m12;
        float f22 = f21 * cosFromSin;
        float f23 = f12;
        float f24 = this.m22;
        float f25 = (f24 * sin) + f22;
        float f26 = f11;
        float f27 = this.m13;
        float f28 = f27 * cosFromSin;
        float f29 = f25;
        float f30 = this.m23;
        float f31 = f10;
        float f32 = (f15 * cosFromSin) - (f13 * sin);
        float f33 = (f19 * cosFromSin) - (f17 * sin);
        float f34 = (f24 * cosFromSin) - (f21 * sin);
        float f35 = (f30 * cosFromSin) - (f27 * sin);
        double d3 = (double) f7;
        float f36 = (f30 * sin) + f28;
        float sin2 = (float) Math.sin(d3);
        float f37 = f36;
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        float f38 = this.m00;
        float f39 = (f38 * cosFromSin2) - (f32 * sin2);
        float f40 = this.m01;
        float f41 = (f40 * cosFromSin2) - (f33 * sin2);
        float f42 = this.m02;
        float f43 = f20;
        float f44 = (f42 * cosFromSin2) - (f34 * sin2);
        float f45 = this.m03;
        float f46 = (f45 * cosFromSin2) - (f35 * sin2);
        float f47 = (f32 * cosFromSin2) + (f38 * sin2);
        float f48 = (f33 * cosFromSin2) + (f40 * sin2);
        float f49 = (f34 * cosFromSin2) + (f42 * sin2);
        float f50 = (f35 * cosFromSin2) + (f45 * sin2);
        matrix4f2._m30(((((-f39) * f3) - (f16 * f4)) - (f47 * f5)) + f9);
        matrix4f2._m31(((((-f41) * f3) - (f43 * f4)) - (f48 * f5)) + f31);
        float f51 = f44;
        matrix4f2._m32(((((-f51) * f3) - (f29 * f4)) - (f49 * f5)) + f26);
        matrix4f2._m33(((((-f46) * f3) - (f37 * f4)) - (f50 * f5)) + f23);
        matrix4f2._m20(f47);
        matrix4f2._m21(f48);
        matrix4f2._m22(f49);
        matrix4f2._m23(f50);
        a.a(matrix4f2, f16, f43, f29, f37);
        matrix4f2._m00(f39);
        matrix4f2._m01(f41);
        matrix4f2._m02(f51);
        matrix4f2._m03(f46);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f assume(int i2) {
        _properties(i2);
        return this;
    }

    public Matrix4f billboardCylindrical(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        float x = vector3fc2.x() - vector3fc.x();
        float y = vector3fc2.y() - vector3fc.y();
        float z = vector3fc2.z() - vector3fc.z();
        float y2 = (vector3fc3.y() * z) - (vector3fc3.z() * y);
        float z2 = (vector3fc3.z() * x) - (vector3fc3.x() * z);
        float x2 = (vector3fc3.x() * y) - (vector3fc3.y() * x);
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((x2 * x2) + ((z2 * z2) + (y2 * y2)))));
        float f2 = y2 * sqrt;
        float f3 = z2 * sqrt;
        float f4 = x2 * sqrt;
        float z3 = (vector3fc3.z() * f3) - (vector3fc3.y() * f4);
        float x3 = (vector3fc3.x() * f4) - (vector3fc3.z() * f2);
        float y3 = (vector3fc3.y() * f2) - (vector3fc3.x() * f3);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((y3 * y3) + ((x3 * x3) + (z3 * z3)))));
        float f5 = z3 * sqrt2;
        float f6 = x3 * sqrt2;
        float f7 = y3 * sqrt2;
        _m00(f2);
        _m01(f3);
        _m02(f4);
        _m03(0.0f);
        _m10(vector3fc3.x());
        _m11(vector3fc3.y());
        _m12(vector3fc3.z());
        _m13(0.0f);
        _m20(f5);
        _m21(f6);
        _m22(f7);
        _m23(0.0f);
        _m30(vector3fc.x());
        _m31(vector3fc.y());
        _m32(vector3fc.z());
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f billboardSpherical(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        float x = vector3fc2.x() - vector3fc.x();
        float y = vector3fc2.y() - vector3fc.y();
        float z = vector3fc2.z() - vector3fc.z();
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((z * z) + ((y * y) + (x * x)))));
        float f2 = x * sqrt;
        float f3 = y * sqrt;
        float f4 = z * sqrt;
        float y2 = (vector3fc3.y() * f4) - (vector3fc3.z() * f3);
        float z2 = (vector3fc3.z() * f2) - (vector3fc3.x() * f4);
        float x2 = (vector3fc3.x() * f3) - (vector3fc3.y() * f2);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((x2 * x2) + ((z2 * z2) + (y2 * y2)))));
        float f5 = y2 * sqrt2;
        float f6 = z2 * sqrt2;
        float f7 = x2 * sqrt2;
        float f8 = (f3 * f7) - (f4 * f6);
        float f9 = (f4 * f5) - (f2 * f7);
        float f10 = (f2 * f6) - (f3 * f5);
        _m00(f5);
        _m01(f6);
        _m02(f7);
        _m03(0.0f);
        a.a(this, f8, f9, f10, 0.0f);
        a.b(this, f2, f3, f4, 0.0f);
        _m30(vector3fc.x());
        _m31(vector3fc.y());
        _m32(vector3fc.z());
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public float determinant() {
        if ((this.properties & 2) != 0) {
            return determinantAffine();
        }
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f4 - (f5 * f6);
        float f8 = this.m22;
        float f9 = this.m33;
        float f10 = f8 * f9;
        float f11 = this.m23;
        float f12 = this.m32;
        float i2 = a.i(f11, f12, f10, f7);
        float f13 = this.m02;
        float f14 = f13 * f6;
        float f15 = this.m12;
        float f16 = f14 - (f2 * f15);
        float f17 = this.m21;
        float f18 = f17 * f9;
        float f19 = this.m31;
        float a2 = a.a(f11, f19, f18, f16, i2);
        float f20 = this.m13;
        float f21 = f2 * f20;
        float f22 = this.m03;
        float a3 = a.a(f8, f19, f17 * f12, f21 - (f6 * f22), a2);
        float f23 = (f5 * f15) - (f13 * f3);
        float f24 = this.m20;
        float f25 = f9 * f24;
        float f26 = f17;
        float f27 = this.m30;
        float f28 = f12 * f24;
        float a4 = a.a(f8, f27, f28, (f3 * f22) - (f5 * f20), a.a(f11, f27, f25, f23, a3));
        return a.a(f27, f26, f24 * f19, (f13 * f20) - (f22 * f15), a4);
    }

    public float determinant3x3() {
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

    public float determinantAffine() {
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

    public Matrix4f determineProperties() {
        int i2;
        if (this.m03 == 0.0f && this.m13 == 0.0f) {
            if (this.m23 == 0.0f && this.m33 == 1.0f) {
                i2 = 2;
                if (this.m00 == 1.0f && this.m01 == 0.0f && this.m02 == 0.0f && this.m10 == 0.0f && this.m11 == 1.0f && this.m12 == 0.0f && this.m20 == 0.0f && this.m21 == 0.0f && this.m22 == 1.0f) {
                    i2 = 26;
                    if (this.m30 == 0.0f && this.m31 == 0.0f && this.m32 == 0.0f) {
                        i2 = 30;
                    }
                }
                this.properties = i2;
                return this;
            } else if (this.m01 == 0.0f && this.m02 == 0.0f && this.m10 == 0.0f && this.m12 == 0.0f && this.m20 == 0.0f && this.m21 == 0.0f && this.m30 == 0.0f && this.m31 == 0.0f && this.m33 == 0.0f) {
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
        if (obj == null || !(obj instanceof Matrix4f)) {
            return false;
        }
        Matrix4fc matrix4fc = (Matrix4fc) obj;
        return Float.floatToIntBits(this.m00) == Float.floatToIntBits(matrix4fc.m00()) && Float.floatToIntBits(this.m01) == Float.floatToIntBits(matrix4fc.m01()) && Float.floatToIntBits(this.m02) == Float.floatToIntBits(matrix4fc.m02()) && Float.floatToIntBits(this.m03) == Float.floatToIntBits(matrix4fc.m03()) && Float.floatToIntBits(this.m10) == Float.floatToIntBits(matrix4fc.m10()) && Float.floatToIntBits(this.m11) == Float.floatToIntBits(matrix4fc.m11()) && Float.floatToIntBits(this.m12) == Float.floatToIntBits(matrix4fc.m12()) && Float.floatToIntBits(this.m13) == Float.floatToIntBits(matrix4fc.m13()) && Float.floatToIntBits(this.m20) == Float.floatToIntBits(matrix4fc.m20()) && Float.floatToIntBits(this.m21) == Float.floatToIntBits(matrix4fc.m21()) && Float.floatToIntBits(this.m22) == Float.floatToIntBits(matrix4fc.m22()) && Float.floatToIntBits(this.m23) == Float.floatToIntBits(matrix4fc.m23()) && Float.floatToIntBits(this.m30) == Float.floatToIntBits(matrix4fc.m30()) && Float.floatToIntBits(this.m31) == Float.floatToIntBits(matrix4fc.m31()) && Float.floatToIntBits(this.m32) == Float.floatToIntBits(matrix4fc.m32()) && Float.floatToIntBits(this.m33) == Float.floatToIntBits(matrix4fc.m33());
    }

    public Matrix4f fma4x3(Matrix4fc matrix4fc, float f2) {
        return fma4x3(matrix4fc, f2, thisOrNew());
    }

    public Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setFrustum(f2, f3, f4, f5, f6, f7, z);
        }
        return frustumGeneric(f2, f3, f4, f5, f6, f7, z, matrix4f);
    }

    public Matrix4f frustumAabb(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        float f4 = Float.POSITIVE_INFINITY;
        float f5 = Float.POSITIVE_INFINITY;
        int i2 = 0;
        float f6 = Float.NEGATIVE_INFINITY;
        float f7 = Float.NEGATIVE_INFINITY;
        while (i2 < 8) {
            float f8 = ((float) ((i2 & 1) << 1)) - 1.0f;
            float f9 = ((float) (((i2 >>> 1) & 1) << 1)) - 1.0f;
            float f10 = ((float) (((i2 >>> 2) & 1) << 1)) - 1.0f;
            float f11 = 1.0f / (((this.m23 * f10) + ((this.m13 * f9) + (this.m03 * f8))) + this.m33);
            float f12 = ((this.m20 * f10) + (this.m10 * f9) + (this.m00 * f8) + this.m30) * f11;
            float f13 = ((this.m21 * f10) + (this.m11 * f9) + (this.m01 * f8) + this.m31) * f11;
            float f14 = ((this.m22 * f10) + (this.m12 * f9) + (this.m02 * f8) + this.m32) * f11;
            if (f3 >= f12) {
                f3 = f12;
            }
            if (f4 >= f13) {
                f4 = f13;
            }
            if (f5 >= f14) {
                f5 = f14;
            }
            if (f2 <= f12) {
                f2 = f12;
            }
            if (f6 <= f13) {
                f6 = f13;
            }
            if (f7 <= f14) {
                f7 = f14;
            }
            i2++;
            Vector3f vector3f5 = vector3f2;
        }
        vector3f3.x = f3;
        vector3f3.y = f4;
        vector3f3.z = f5;
        Vector3f vector3f6 = vector3f2;
        vector3f6.x = f2;
        vector3f6.y = f6;
        vector3f6.z = f7;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0192, code lost:
        r8 = r8 + r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0193, code lost:
        r14 = (r11 * r6) - (r12 * r4);
        r15 = (r12 * r2) - (r10 * r6);
        r0 = (r10 * r4) - (r11 * r2);
        r16 = (r4 * r7) - (r6 * r5);
        r6 = (r6 * r3) - (r2 * r7);
        r2 = (r2 * r5) - (r4 * r3);
        r4 = (r5 * r12) - (r7 * r11);
        r12 = (r7 * r10) - (r12 * r3);
        r11 = (r11 * r3) - (r10 * r5);
        r3 = e.a.a.a.a.h(r7, r0, (r5 * r15) + (r3 * r14), 1.0f);
        r1.x = e.a.a.a.a.i(r4, r8, ((-r14) * r9) - (r16 * r13), r3);
        r1.y = e.a.a.a.a.i(r12, r8, ((-r15) * r9) - (r6 * r13), r3);
        r1.z = e.a.a.a.a.i(r11, r8, ((-r0) * r9) - (r2 * r13), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x01e9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00cf, code lost:
        r8 = r8 - r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.arashivision.insbase.joml.Vector3f frustumCorner(int r19, com.arashivision.insbase.joml.Vector3f r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            switch(r19) {
                case 0: goto L_0x0167;
                case 1: goto L_0x0137;
                case 2: goto L_0x0103;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00a0;
                case 5: goto L_0x0074;
                case 6: goto L_0x0044;
                case 7: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "corner"
            r0.<init>(r1)
            throw r0
        L_0x000f:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r2 - r3
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r4 - r5
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r6 - r7
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r8 - r9
            float r10 = r0.m01
            float r10 = r2 - r10
            float r11 = r0.m11
            float r11 = r4 - r11
            float r12 = r0.m21
            float r12 = r6 - r12
            float r13 = r0.m31
            float r13 = r8 - r13
            float r14 = r0.m02
            float r2 = r2 - r14
            float r14 = r0.m12
            float r4 = r4 - r14
            float r14 = r0.m22
            float r6 = r6 - r14
            float r14 = r0.m32
            goto L_0x00cf
        L_0x0044:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r3 + r2
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r5 + r4
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r7 + r6
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r9 + r8
            float r10 = r0.m01
            float r10 = r2 - r10
            float r11 = r0.m11
            float r11 = r4 - r11
            float r12 = r0.m21
            float r12 = r6 - r12
            float r13 = r0.m31
            float r13 = r8 - r13
            float r14 = r0.m02
            float r2 = r2 - r14
            float r14 = r0.m12
            float r4 = r4 - r14
            float r14 = r0.m22
            float r6 = r6 - r14
            float r14 = r0.m32
            goto L_0x00cf
        L_0x0074:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r3 + r2
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r5 + r4
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r7 + r6
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r9 + r8
            float r10 = r0.m01
            float r10 = r10 + r2
            float r11 = r0.m11
            float r11 = r11 + r4
            float r12 = r0.m21
            float r12 = r12 + r6
            float r13 = r0.m31
            float r13 = r13 + r8
            float r14 = r0.m02
            float r2 = r2 - r14
            float r14 = r0.m12
            float r4 = r4 - r14
            float r14 = r0.m22
            float r6 = r6 - r14
            float r14 = r0.m32
            goto L_0x00cf
        L_0x00a0:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r2 - r3
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r4 - r5
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r6 - r7
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r8 - r9
            float r10 = r0.m01
            float r10 = r10 + r2
            float r11 = r0.m11
            float r11 = r11 + r4
            float r12 = r0.m21
            float r12 = r12 + r6
            float r13 = r0.m31
            float r13 = r13 + r8
            float r14 = r0.m02
            float r2 = r2 - r14
            float r14 = r0.m12
            float r4 = r4 - r14
            float r14 = r0.m22
            float r6 = r6 - r14
            float r14 = r0.m32
        L_0x00cf:
            float r8 = r8 - r14
            goto L_0x0193
        L_0x00d2:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r3 + r2
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r5 + r4
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r7 + r6
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r9 + r8
            float r10 = r0.m01
            float r10 = r2 - r10
            float r11 = r0.m11
            float r11 = r4 - r11
            float r12 = r0.m21
            float r12 = r6 - r12
            float r13 = r0.m31
            float r13 = r8 - r13
            float r14 = r0.m02
            float r2 = r2 + r14
            float r14 = r0.m12
            float r4 = r4 + r14
            float r14 = r0.m22
            float r6 = r6 + r14
            float r14 = r0.m32
            goto L_0x0192
        L_0x0103:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r2 - r3
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r4 - r5
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r6 - r7
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r8 - r9
            float r10 = r0.m01
            float r10 = r2 - r10
            float r11 = r0.m11
            float r11 = r4 - r11
            float r12 = r0.m21
            float r12 = r6 - r12
            float r13 = r0.m31
            float r13 = r8 - r13
            float r14 = r0.m02
            float r2 = r2 + r14
            float r14 = r0.m12
            float r4 = r4 + r14
            float r14 = r0.m22
            float r6 = r6 + r14
            float r14 = r0.m32
            goto L_0x0192
        L_0x0137:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r2 - r3
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r4 - r5
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r6 - r7
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r8 - r9
            float r10 = r0.m01
            float r10 = r10 + r2
            float r11 = r0.m11
            float r11 = r11 + r4
            float r12 = r0.m21
            float r12 = r12 + r6
            float r13 = r0.m31
            float r13 = r13 + r8
            float r14 = r0.m02
            float r2 = r2 + r14
            float r14 = r0.m12
            float r4 = r4 + r14
            float r14 = r0.m22
            float r6 = r6 + r14
            float r14 = r0.m32
            goto L_0x0192
        L_0x0167:
            float r2 = r0.m03
            float r3 = r0.m00
            float r3 = r3 + r2
            float r4 = r0.m13
            float r5 = r0.m10
            float r5 = r5 + r4
            float r6 = r0.m23
            float r7 = r0.m20
            float r7 = r7 + r6
            float r8 = r0.m33
            float r9 = r0.m30
            float r9 = r9 + r8
            float r10 = r0.m01
            float r10 = r10 + r2
            float r11 = r0.m11
            float r11 = r11 + r4
            float r12 = r0.m21
            float r12 = r12 + r6
            float r13 = r0.m31
            float r13 = r13 + r8
            float r14 = r0.m02
            float r2 = r2 + r14
            float r14 = r0.m12
            float r4 = r4 + r14
            float r14 = r0.m22
            float r6 = r6 + r14
            float r14 = r0.m32
        L_0x0192:
            float r8 = r8 + r14
        L_0x0193:
            float r14 = r11 * r6
            float r15 = r12 * r4
            float r14 = r14 - r15
            float r15 = r12 * r2
            float r16 = r10 * r6
            float r15 = r15 - r16
            float r16 = r10 * r4
            float r17 = r11 * r2
            float r0 = r16 - r17
            float r16 = r4 * r7
            float r17 = r6 * r5
            float r16 = r16 - r17
            float r6 = r6 * r3
            float r17 = r2 * r7
            float r6 = r6 - r17
            float r2 = r2 * r5
            float r4 = r4 * r3
            float r2 = r2 - r4
            float r4 = r5 * r12
            float r17 = r7 * r11
            float r4 = r4 - r17
            float r17 = r7 * r10
            float r12 = r12 * r3
            float r12 = r17 - r12
            float r11 = r11 * r3
            float r10 = r10 * r5
            float r11 = r11 - r10
            r10 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 * r14
            float r5 = r5 * r15
            float r5 = r5 + r3
            float r3 = e.a.a.a.a.h(r7, r0, r5, r10)
            float r5 = -r14
            float r5 = r5 * r9
            float r16 = r16 * r13
            float r5 = r5 - r16
            float r4 = e.a.a.a.a.i(r4, r8, r5, r3)
            r1.x = r4
            float r4 = -r15
            float r4 = r4 * r9
            float r6 = r6 * r13
            float r4 = r4 - r6
            float r4 = e.a.a.a.a.i(r12, r8, r4, r3)
            r1.y = r4
            float r0 = -r0
            float r0 = r0 * r9
            float r2 = r2 * r13
            float r0 = r0 - r2
            float r0 = e.a.a.a.a.i(r11, r8, r0, r3)
            r1.z = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Matrix4f.frustumCorner(int, com.arashivision.insbase.joml.Vector3f):com.arashivision.insbase.joml.Vector3f");
    }

    public Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setFrustumLH(f2, f3, f4, f5, f6, f7, z);
        }
        return frustumLHGeneric(f2, f3, f4, f5, f6, f7, z, matrix4f);
    }

    public Vector4f frustumPlane(int i2, Vector4f vector4f) {
        if (i2 == 0) {
            vector4f.set(this.m03 + this.m00, this.m13 + this.m10, this.m23 + this.m20, this.m33 + this.m30).normalize3(vector4f);
        } else if (i2 == 1) {
            vector4f.set(this.m03 - this.m00, this.m13 - this.m10, this.m23 - this.m20, this.m33 - this.m30).normalize3(vector4f);
        } else if (i2 == 2) {
            vector4f.set(this.m03 + this.m01, this.m13 + this.m11, this.m23 + this.m21, this.m33 + this.m31).normalize3(vector4f);
        } else if (i2 == 3) {
            vector4f.set(this.m03 - this.m01, this.m13 - this.m11, this.m23 - this.m21, this.m33 - this.m31).normalize3(vector4f);
        } else if (i2 == 4) {
            vector4f.set(this.m03 + this.m02, this.m13 + this.m12, this.m23 + this.m22, this.m33 + this.m32).normalize3(vector4f);
        } else if (i2 == 5) {
            vector4f.set(this.m03 - this.m02, this.m13 - this.m12, this.m23 - this.m22, this.m33 - this.m32).normalize3(vector4f);
        } else {
            throw new IllegalArgumentException("plane");
        }
        return vector4f;
    }

    public Vector3f frustumRayDir(float f2, float f3, Vector3f vector3f) {
        float f4 = f2;
        Vector3f vector3f2 = vector3f;
        float f5 = this.m10;
        float f6 = this.m23;
        float f7 = f5 * f6;
        float f8 = this.m13;
        float f9 = this.m21;
        float f10 = f8 * f9;
        float f11 = f5 * f9;
        float f12 = this.m11;
        float f13 = f12 * f6;
        float f14 = this.m20;
        float f15 = f8 * f14;
        float f16 = f12 * f14;
        float f17 = this.m03;
        float f18 = f17 * f14;
        float f19 = this.m01;
        float f20 = f19 * f6;
        float f21 = f14 * f19;
        float f22 = f17 * f9;
        float f23 = this.m00;
        float f24 = f6 * f23;
        float f25 = f9 * f23;
        float f26 = f23 * f8;
        float f27 = f17 * f12;
        float f28 = f23 * f12;
        float f29 = f8 * f19;
        float f30 = f17 * f5;
        float f31 = f19 * f5;
        float f32 = 1.0f - f3;
        float f33 = ((((((f7 - f10) - f11) + f13) - f15) + f16) * f3) + ((((((f13 + f15) + f16) - f7) - f10) - f11) * f32);
        float f34 = ((((((f18 - f20) - f21) + f22) - f24) + f25) * f3) + ((((((f22 + f24) + f25) - f18) - f20) - f21) * f32);
        float f35 = f34;
        float f36 = ((((((f26 - f27) - f28) + f29) - f30) + f31) * f3) + ((((((f29 + f30) + f31) - f26) - f27) - f28) * f32);
        float f37 = ((((((f18 + f20) - f21) - f22) - f24) + f25) * f3) + ((((((f20 - f21) - f22) + f24) + f25) - f18) * f32);
        float f38 = ((((((f26 + f27) - f28) - f29) - f30) + f31) * f3) + ((((((f27 - f28) - f29) + f30) + f31) - f26) * f32);
        float f39 = f2;
        float e2 = a.e(((((((f7 + f10) - f11) - f13) - f15) + f16) * f3) + ((((((f10 - f11) - f13) + f15) + f16) - f7) * f32), f33, f39, f33);
        Vector3f vector3f3 = vector3f;
        vector3f3.x = e2;
        float f40 = f35;
        vector3f3.y = a.e(f37, f40, f39, f40);
        vector3f3.z = a.e(f38, f36, f39, f36);
        return vector3f3.normalize(vector3f3);
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set((Matrix4fc) this);
    }

    public Matrix3f get3x3(Matrix3f matrix3f) {
        return matrix3f.set((Matrix4fc) this);
    }

    public Matrix4x3f get4x3(Matrix4x3f matrix4x3f) {
        return matrix4x3f.set((Matrix4fc) this);
    }

    public FloatBuffer get4x3Transposed(FloatBuffer floatBuffer) {
        return get4x3Transposed(floatBuffer.position(), floatBuffer);
    }

    public Vector4f getColumn(int i2, Vector4f vector4f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            MemUtil.INSTANCE.putColumn0(this, vector4f);
        } else if (i2 == 1) {
            MemUtil.INSTANCE.putColumn1(this, vector4f);
        } else if (i2 == 2) {
            MemUtil.INSTANCE.putColumn2(this, vector4f);
        } else if (i2 == 3) {
            MemUtil.INSTANCE.putColumn3(this, vector4f);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector4f;
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
        return quaternionf.setFromNormalized((Matrix4fc) this);
    }

    public AxisAngle4f getRotation(AxisAngle4f axisAngle4f) {
        return axisAngle4f.set((Matrix4fc) this);
    }

    public Vector4f getRow(int i2, Vector4f vector4f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector4f.x = this.m00;
            vector4f.y = this.m10;
            vector4f.z = this.m20;
            vector4f.w = this.m30;
        } else if (i2 == 1) {
            vector4f.x = this.m01;
            vector4f.y = this.m11;
            vector4f.z = this.m21;
            vector4f.w = this.m31;
        } else if (i2 == 2) {
            vector4f.x = this.m02;
            vector4f.y = this.m12;
            vector4f.z = this.m22;
            vector4f.w = this.m32;
        } else if (i2 == 3) {
            vector4f.x = this.m03;
            vector4f.y = this.m13;
            vector4f.z = this.m23;
            vector4f.w = this.m33;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector4f;
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

    public Vector3f getTranslation(Vector3f vector3f) {
        vector3f.x = this.m30;
        vector3f.y = this.m31;
        vector3f.z = this.m32;
        return vector3f;
    }

    public FloatBuffer getTransposed(FloatBuffer floatBuffer) {
        return getTransposed(floatBuffer.position(), floatBuffer);
    }

    public Quaternionf getUnnormalizedRotation(Quaternionf quaternionf) {
        return quaternionf.setFromUnnormalized((Matrix4fc) this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.m33) + a.a(this.m32, a.a(this.m31, a.a(this.m30, a.a(this.m23, a.a(this.m22, a.a(this.m21, a.a(this.m20, a.a(this.m13, a.a(this.m12, a.a(this.m11, a.a(this.m10, a.a(this.m03, a.a(this.m02, a.a(this.m01, a.a(this.m00, 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public Matrix4f identity() {
        if ((this.properties & 4) != 0) {
            return this;
        }
        MemUtil.INSTANCE.identity(this);
        _properties(30);
        return this;
    }

    public Matrix4f invert(Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.identity();
        }
        if ((i2 & 8) != 0) {
            return invertTranslation(matrix4f);
        }
        if ((i2 & 16) != 0) {
            return invertOrthonormal(matrix4f);
        }
        if ((i2 & 2) != 0) {
            return invertAffine(matrix4f);
        }
        if ((i2 & 1) != 0) {
            return invertPerspective(matrix4f);
        }
        return invertGeneric(matrix4f);
    }

    public Matrix4f invertAffine(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f19 = f4;
        float f20 = (f17 * f18) + f16;
        float f21 = f7;
        float f22 = f12 - f13;
        float f23 = f9;
        float f24 = this.m20;
        float f25 = f11;
        float h2 = a.h(f22, f24, f20, 1.0f);
        float f26 = f6 * f15;
        float f27 = f6 * f18;
        float f28 = f3 * f15;
        float f29 = f3 * f24;
        float f30 = f10 * f18;
        float f31 = f10 * f24;
        float f32 = f24 * f8;
        float f33 = f24 * f5;
        float f34 = f8 * f18;
        float f35 = f18 * f2;
        float f36 = f5 * f15;
        float f37 = f15 * f2;
        float f38 = (f28 - f30) * h2;
        float f39 = (f34 - f36) * h2;
        float f40 = f22 * h2;
        float f41 = (f31 - f26) * h2;
        float f42 = (f37 - f32) * h2;
        float f43 = f17 * h2;
        float f44 = (f27 - f29) * h2;
        float f45 = f14 * h2;
        float f46 = (f33 - f35) * h2;
        float f47 = this.m31;
        float f48 = f26 * f47;
        float f49 = f45;
        float f50 = this.m32;
        float f51 = (f29 * f50) + (f48 - (f27 * f50));
        float f52 = this.m30;
        float i2 = a.i(f31, f47, (f30 * f52) + (f51 - (f28 * f52)), h2);
        float f53 = f36 * f52;
        float i3 = a.i(f37, f47, f53 + (((f35 * f50) + ((f32 * f47) - (f33 * f50))) - (f34 * f52)), h2);
        float f54 = f25 * f47;
        float f55 = (((f21 * f50) + ((f54 + ((f13 * f52) - (f12 * f52))) - (f23 * f47))) - (f19 * f50)) * h2;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m00(f38);
        matrix4f3._m01(f39);
        matrix4f3._m02(f40);
        matrix4f3._m03(0.0f);
        a.a(matrix4f3, f41, f42, f43, 0.0f);
        a.b(matrix4f3, f44, f46, f49, 0.0f);
        a.c(matrix4f3, i2, i3, f55, 1.0f);
        matrix4f3._properties(2);
        return matrix4f3;
    }

    public Matrix4f invertFrustum(Matrix4f matrix4f) {
        float f2 = 1.0f / this.m00;
        float f3 = 1.0f / this.m11;
        float f4 = 1.0f / this.m23;
        float f5 = 1.0f / this.m32;
        matrix4f.set(f2, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5, (-this.m20) * f2 * f4, (-this.m21) * f3 * f4, f4, (-this.m22) * f4 * f5);
        return matrix4f;
    }

    public Matrix4f invertOrtho(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f2 = 1.0f / this.m00;
        float f3 = 1.0f / this.m11;
        float f4 = 1.0f / this.m22;
        matrix4f.set(f2, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, f4, 0.0f, (-this.m30) * f2, (-this.m31) * f3, (-this.m32) * f4, 1.0f);
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._properties((this.properties & 16) | 2);
        return matrix4f3;
    }

    public Matrix4f invertPerspective(Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        Matrix4f matrix4f3 = matrix4f;
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = 1.0f / (f2 * f3);
        float f5 = this.m23;
        float f6 = this.m32;
        float f7 = -1.0f / (f5 * f6);
        Matrix4f matrix4f4 = matrix4f2;
        matrix4f3.set(f3 * f4, 0.0f, 0.0f, 0.0f, 0.0f, f2 * f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (-f5) * f7, 0.0f, 0.0f, (-f6) * f7, this.m22 * f7);
        matrix4f4._properties(0);
        return matrix4f4;
    }

    public Matrix4f invertPerspectiveView(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = 1.0f / (f2 * f3);
        float f5 = this.m23;
        float f6 = this.m32;
        float f7 = -1.0f / (f5 * f6);
        float f8 = f3 * f4;
        float f9 = f2 * f4;
        float f10 = (-f5) * f7;
        float f11 = (-f6) * f7;
        float f12 = this.m22 * f7;
        float m302 = ((matrix4fc.m30() * (-matrix4fc.m00())) - (matrix4fc.m31() * matrix4fc.m01())) - (matrix4fc.m32() * matrix4fc.m02());
        float m303 = ((matrix4fc.m30() * (-matrix4fc.m10())) - (matrix4fc.m31() * matrix4fc.m11())) - (matrix4fc.m32() * matrix4fc.m12());
        float m304 = ((matrix4fc.m30() * (-matrix4fc.m20())) - (matrix4fc.m31() * matrix4fc.m21())) - (matrix4fc.m32() * matrix4fc.m22());
        float m002 = matrix4fc.m00() * f8;
        float m102 = matrix4fc.m10() * f8;
        float m202 = matrix4fc.m20() * f8;
        float m012 = matrix4fc.m01() * f9;
        float m112 = matrix4fc.m11() * f9;
        float m212 = matrix4fc.m21() * f9;
        float f13 = m302 * f10;
        float f14 = m303 * f10;
        float f15 = m304 * f10;
        float m022 = (m302 * f12) + (matrix4fc.m02() * f11);
        float m122 = (m303 * f12) + (matrix4fc.m12() * f11);
        float m222 = (m304 * f12) + (matrix4fc.m22() * f11);
        matrix4f2.m00 = m002;
        matrix4f2.m01 = m102;
        matrix4f2.m02 = m202;
        matrix4f2.m03 = 0.0f;
        matrix4f2.m10 = m012;
        matrix4f2.m11 = m112;
        matrix4f2.m12 = m212;
        matrix4f2.m13 = 0.0f;
        matrix4f2.m20 = f13;
        matrix4f2.m21 = f14;
        matrix4f2.m22 = f15;
        matrix4f2.m23 = f10;
        matrix4f2.m30 = m022;
        matrix4f2.m31 = m122;
        matrix4f2.m32 = m222;
        matrix4f2.m33 = f12;
        matrix4f2._properties(0);
        return matrix4f2;
    }

    public boolean isAffine() {
        return this.m03 == 0.0f && this.m13 == 0.0f && this.m23 == 0.0f && this.m33 == 1.0f;
    }

    public Matrix4f lerp(Matrix4fc matrix4fc, float f2) {
        return lerp(matrix4fc, f2, thisOrNew());
    }

    public Matrix4f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), thisOrNew());
    }

    public Matrix4f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4f matrix4f) {
        return lookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), matrix4f);
    }

    public Matrix4f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4f matrix4f) {
        return lookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), matrix4f);
    }

    public Matrix4f lookAtPerspective(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f11 = f2 - f5;
        float f12 = f3 - f6;
        float f13 = f4 - f7;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        float f26 = -((f22 * f4) + (f21 * f3) + (f20 * f2));
        float f27 = -((f25 * f4) + (f24 * f3) + (f23 * f2));
        float f28 = -((f16 * f4) + (f15 * f3) + (f14 * f2));
        float f29 = this.m00;
        float f30 = f20 * f29;
        float f31 = this.m11;
        float f32 = f23 * f31;
        float f33 = this.m22;
        float f34 = f33 * f14;
        float f35 = this.m23;
        float f36 = f14 * f35;
        float f37 = f24 * f31;
        float f38 = f21 * f29;
        float f39 = f33 * f15;
        float f40 = f15 * f35;
        float f41 = f25 * f31;
        float f42 = f22 * f29;
        float f43 = f33 * f16;
        float f44 = f16 * f35;
        float f45 = f29 * f26;
        float f46 = f31 * f27;
        float f47 = (f33 * f28) + this.m32;
        float f48 = f35 * f28;
        float f49 = f34;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m00(f30);
        matrix4f3._m01(f32);
        matrix4f3._m02(f49);
        matrix4f3._m03(f36);
        a.a(matrix4f3, f38, f37, f39, f40);
        a.b(matrix4f3, f42, f41, f43, f44);
        a.c(matrix4f3, f45, f46, f47, f48);
        matrix4f3._properties(0);
        return matrix4f3;
    }

    public Matrix4f lookAtPerspectiveLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float f13 = f7 - f4;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        float f26 = -((f22 * f4) + (f21 * f3) + (f20 * f2));
        float f27 = -((f25 * f4) + (f24 * f3) + (f23 * f2));
        float f28 = -((f16 * f4) + (f15 * f3) + (f14 * f2));
        float f29 = this.m00;
        float f30 = f20 * f29;
        float f31 = this.m11;
        float f32 = f23 * f31;
        float f33 = this.m22;
        float f34 = f33 * f14;
        float f35 = this.m23;
        float f36 = f14 * f35;
        float f37 = f24 * f31;
        float f38 = f21 * f29;
        float f39 = f33 * f15;
        float f40 = f15 * f35;
        float f41 = f25 * f31;
        float f42 = f22 * f29;
        float f43 = f33 * f16;
        float f44 = f16 * f35;
        float f45 = f29 * f26;
        float f46 = f31 * f27;
        float f47 = (f33 * f28) + this.m32;
        float f48 = f35 * f28;
        float f49 = f34;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m00(f30);
        matrix4f3._m01(f32);
        matrix4f3._m02(f49);
        matrix4f3._m03(f36);
        a.a(matrix4f3, f38, f37, f39, f40);
        a.b(matrix4f3, f42, f41, f43, f44);
        a.c(matrix4f3, f45, f46, f47, f48);
        matrix4f3._properties(0);
        return matrix4f3;
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

    public float m03() {
        return this.m03;
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

    public float m13() {
        return this.m13;
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

    public float m23() {
        return this.m23;
    }

    public float m30() {
        return this.m30;
    }

    public float m31() {
        return this.m31;
    }

    public float m32() {
        return this.m32;
    }

    public float m33() {
        return this.m33;
    }

    public Matrix4f mul(Matrix4fc matrix4fc) {
        return mul(matrix4fc, thisOrNew());
    }

    public Matrix4f mul4x3ComponentWise(Matrix4fc matrix4fc) {
        return mul4x3ComponentWise(matrix4fc, thisOrNew());
    }

    public Matrix4f mulAffine(Matrix4fc matrix4fc) {
        return mulAffine(matrix4fc, thisOrNew());
    }

    public Matrix4f mulAffineR(Matrix4fc matrix4fc) {
        return mulAffineR(matrix4fc, thisOrNew());
    }

    public Matrix4f mulComponentWise(Matrix4fc matrix4fc) {
        return mulComponentWise(matrix4fc, thisOrNew());
    }

    public Matrix4f mulLocal(Matrix4fc matrix4fc) {
        return mulLocal(matrix4fc, thisOrNew());
    }

    public Matrix4f mulLocalAffine(Matrix4fc matrix4fc) {
        return mulLocalAffine(matrix4fc, thisOrNew());
    }

    public Matrix4f mulOrthoAffine(Matrix4fc matrix4fc) {
        return mulOrthoAffine(matrix4fc, thisOrNew());
    }

    public Matrix4f mulPerspectiveAffine(Matrix4fc matrix4fc) {
        return mulPerspectiveAffine(matrix4fc, thisOrNew());
    }

    public Matrix4f mulTranslationAffine(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m002 = matrix4fc.m00();
        float m012 = matrix4fc.m01();
        float m022 = matrix4fc.m02();
        float f2 = this.m03;
        float m102 = matrix4fc.m10();
        float m112 = matrix4fc.m11();
        float m122 = matrix4fc.m12();
        float f3 = this.m13;
        float m202 = matrix4fc.m20();
        float m212 = matrix4fc.m21();
        float m222 = matrix4fc.m22();
        float f4 = this.m23;
        float m302 = matrix4fc.m30() + this.m30;
        float m312 = matrix4fc.m31() + this.m31;
        float m322 = matrix4fc.m32() + this.m32;
        float f5 = this.m33;
        matrix4f2._m00(m002);
        matrix4f2._m01(m012);
        matrix4f2._m02(m022);
        matrix4f2._m03(f2);
        a.a(matrix4f2, m102, m112, m122, f3);
        a.b(matrix4f2, m202, m212, m222, f4);
        a.c(matrix4f2, m302, m312, m322, f5);
        matrix4f2._properties((matrix4fc.properties() & 16) | 2);
        return matrix4f2;
    }

    public Matrix4f normal() {
        return normal(thisOrNew());
    }

    public Matrix4f normalize3x3() {
        return normalize3x3(thisOrNew());
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

    public Matrix4f obliqueZ(float f2, float f3) {
        this.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        this.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        this.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        _properties(this.properties & 2);
        return this;
    }

    public Vector3f origin(Vector3f vector3f) {
        if ((this.properties & 2) != 0) {
            return originAffine(vector3f);
        }
        return originGeneric(vector3f);
    }

    public Vector3f originAffine(Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f4 - (f5 * f6);
        float f8 = this.m12;
        float f9 = f2 * f8;
        float f10 = this.m02;
        float f11 = f9 - (f10 * f6);
        float f12 = (f5 * f8) - (f10 * f3);
        float f13 = this.m20;
        float f14 = this.m31;
        float f15 = f13 * f14;
        float f16 = this.m21;
        float f17 = this.m30;
        float f18 = f15 - (f16 * f17);
        float f19 = f7;
        float f20 = this.m32;
        float f21 = f13 * f20;
        float f22 = f11;
        float f23 = this.m22;
        float f24 = f21 - (f23 * f17);
        float f25 = (f16 * f20) - (f23 * f14);
        vector3f2.x = ((f3 * f24) + ((-f6) * f25)) - (f8 * f18);
        vector3f2.y = (f10 * f18) + ((f2 * f25) - (f5 * f24));
        vector3f2.z = ((f14 * f22) + ((-f17) * f12)) - (f20 * f19);
        return vector3f2;
    }

    public Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrtho(f2, f3, f4, f5, f6, f7, z);
        }
        return orthoGeneric(f2, f3, f4, f5, f6, f7, z, matrix4f);
    }

    public Matrix4f ortho2D(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrtho2D(f2, f3, f4, f5);
        }
        return ortho2DGeneric(f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f ortho2DLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrtho2DLH(f2, f3, f4, f5);
        }
        return ortho2DLHGeneric(f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f orthoCrop(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        float f4 = Float.NEGATIVE_INFINITY;
        float f5 = Float.NEGATIVE_INFINITY;
        float f6 = Float.POSITIVE_INFINITY;
        float f7 = Float.POSITIVE_INFINITY;
        for (int i2 = 0; i2 < 8; i2++) {
            float f8 = ((float) ((i2 & 1) << 1)) - 1.0f;
            float f9 = ((float) (((i2 >>> 1) & 1) << 1)) - 1.0f;
            float f10 = ((float) (((i2 >>> 2) & 1) << 1)) - 1.0f;
            float f11 = 1.0f / (((this.m23 * f10) + ((this.m13 * f9) + (this.m03 * f8))) + this.m33);
            float f12 = ((this.m20 * f10) + (this.m10 * f9) + (this.m00 * f8) + this.m30) * f11;
            float f13 = ((this.m21 * f10) + (this.m11 * f9) + (this.m01 * f8) + this.m31) * f11;
            float f14 = ((this.m22 * f10) + (this.m12 * f9) + (this.m02 * f8) + this.m32) * f11;
            float m332 = 1.0f / (matrix4fc.m33() + ((matrix4fc.m23() * f14) + ((matrix4fc.m13() * f13) + (matrix4fc.m03() * f12))));
            float m302 = matrix4fc.m30() + (matrix4fc.m20() * f14) + (matrix4fc.m10() * f13) + (matrix4fc.m00() * f12);
            float m312 = matrix4fc.m31() + (matrix4fc.m21() * f14) + (matrix4fc.m11() * f13) + (matrix4fc.m01() * f12);
            float m322 = (matrix4fc.m32() + (matrix4fc.m22() * f14) + (matrix4fc.m12() * f13) + (matrix4fc.m02() * f12)) * m332;
            if (f6 >= m302) {
                f6 = m302;
            }
            if (f4 <= m302) {
                f4 = m302;
            }
            if (f7 >= m312) {
                f7 = m312;
            }
            if (f5 <= m312) {
                f5 = m312;
            }
            if (f3 >= m322) {
                f3 = m322;
            }
            if (f2 <= m322) {
                f2 = m322;
            }
        }
        return matrix4f.setOrtho(f6, f4, f7, f5, -f2, -f3);
    }

    public Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrthoLH(f2, f3, f4, f5, f6, f7, z);
        }
        return orthoLHGeneric(f2, f3, f4, f5, f6, f7, z, matrix4f);
    }

    public Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrthoSymmetric(f2, f3, f4, f5, z);
        }
        return orthoSymmetricGeneric(f2, f3, f4, f5, z, matrix4f);
    }

    public Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setOrthoSymmetricLH(f2, f3, f4, f5, z);
        }
        return orthoSymmetricLHGeneric(f2, f3, f4, f5, z, matrix4f);
    }

    public Matrix4f perspective(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setPerspective(f2, f3, f4, f5, z);
        }
        return perspectiveGeneric(f2, f3, f4, f5, z, matrix4f);
    }

    public float perspectiveFar() {
        return this.m32 / (this.m22 - this.m23);
    }

    public float perspectiveFov() {
        float f2 = this.m03;
        float f3 = this.m01;
        float f4 = f2 + f3;
        float f5 = this.m13;
        float f6 = this.m11;
        float f7 = f5 + f6;
        float f8 = this.m23;
        float f9 = this.m21;
        float f10 = f8 + f9;
        float f11 = f3 - f2;
        float f12 = f6 - f5;
        float f13 = f9 - f8;
        float f14 = (f7 * f7) + (f4 * f4);
        return (float) Math.acos((double) (((f10 * f13) + ((f7 * f12) + (f4 * f11))) / (((float) Math.sqrt((double) ((f10 * f10) + f14))) * ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11))))))));
    }

    public Matrix4f perspectiveFrustumSlice(float f2, float f3, Matrix4f matrix4f) {
        float f4 = (this.m23 + this.m22) / this.m32;
        float f5 = 1.0f / (f2 - f3);
        matrix4f._m00(this.m00 * f4 * f2);
        matrix4f._m01(this.m01);
        matrix4f._m02(this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m10(this.m10);
        matrix4f._m11(this.m11 * f4 * f2);
        matrix4f._m12(this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m20(this.m20);
        matrix4f._m21(this.m21);
        matrix4f._m22((f3 + f2) * f5);
        matrix4f._m23(this.m23);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32((f3 + f3) * f2 * f5);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -29);
        return matrix4f;
    }

    public Matrix4f perspectiveLH(float f2, float f3, float f4, float f5, boolean z, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setPerspectiveLH(f2, f3, f4, f5, z);
        }
        return perspectiveLHGeneric(f2, f3, f4, f5, z, matrix4f);
    }

    public float perspectiveNear() {
        return this.m32 / (this.m23 + this.m22);
    }

    public Vector3f perspectiveOrigin(Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        float f2 = this.m03;
        float f3 = this.m00;
        float f4 = f2 + f3;
        float f5 = this.m13;
        float f6 = this.m10;
        float f7 = f5 + f6;
        float f8 = this.m23;
        float f9 = this.m20;
        float f10 = f8 + f9;
        float f11 = this.m33;
        float f12 = this.m30;
        float f13 = f11 + f12;
        float f14 = f2 - f3;
        float f15 = f5 - f6;
        float f16 = f8 - f9;
        float f17 = f11 - f12;
        float f18 = f2 - this.m01;
        float f19 = f5 - this.m11;
        float f20 = f8 - this.m21;
        float f21 = f11 - this.m31;
        float f22 = (f15 * f20) - (f16 * f19);
        float f23 = (f16 * f18) - (f14 * f20);
        float f24 = (f14 * f19) - (f15 * f18);
        float f25 = (f19 * f10) - (f20 * f7);
        float f26 = (f20 * f4) - (f18 * f10);
        float f27 = (f18 * f7) - (f19 * f4);
        float f28 = (f7 * f16) - (f10 * f15);
        float f29 = (f10 * f14) - (f16 * f4);
        float f30 = (f15 * f4) - (f14 * f7);
        float h2 = a.h(f10, f24, (f7 * f23) + (f4 * f22), 1.0f);
        vector3f2.x = a.i(f28, f21, ((-f22) * f13) - (f25 * f17), h2);
        vector3f2.y = a.i(f29, f21, ((-f23) * f13) - (f26 * f17), h2);
        vector3f2.z = a.i(f30, f21, ((-f24) * f13) - (f27 * f17), h2);
        return vector3f2;
    }

    public Matrix4f pick(float f2, float f3, float f4, float f5, int[] iArr, Matrix4f matrix4f) {
        float f6 = ((float) iArr[2]) / f4;
        float f7 = ((float) iArr[3]) / f5;
        float f8 = (((((float) iArr[0]) - f2) * 2.0f) + ((float) iArr[2])) / f4;
        float f9 = (((((float) iArr[1]) - f3) * 2.0f) + ((float) iArr[3])) / f5;
        matrix4f._m30((this.m10 * f9) + (this.m00 * f8) + this.m30);
        matrix4f._m31((this.m11 * f9) + (this.m01 * f8) + this.m31);
        matrix4f._m32((this.m12 * f9) + (this.m02 * f8) + this.m32);
        matrix4f._m33((this.m13 * f9) + (this.m03 * f8) + this.m33);
        matrix4f._m00(this.m00 * f6);
        matrix4f._m01(this.m01 * f6);
        matrix4f._m02(this.m02 * f6);
        matrix4f._m03(this.m03 * f6);
        matrix4f._m10(this.m10 * f7);
        matrix4f._m11(this.m11 * f7);
        matrix4f._m12(this.m12 * f7);
        matrix4f._m13(this.m13 * f7);
        matrix4f._properties(0);
        return matrix4f;
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

    public Vector4f project(float f2, float f3, float f4, int[] iArr, Vector4f vector4f) {
        float f5 = 1.0f / (((this.m23 * f4) + ((this.m13 * f3) + (this.m03 * f2))) + this.m33);
        float f6 = ((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30) * f5;
        float f7 = ((this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31) * f5;
        float f8 = ((this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32) * f5;
        vector4f.x = (((f6 * 0.5f) + 0.5f) * ((float) iArr[2])) + ((float) iArr[0]);
        vector4f.y = (((f7 * 0.5f) + 0.5f) * ((float) iArr[3])) + ((float) iArr[1]);
        vector4f.z = (f8 + 1.0f) * 0.5f;
        vector4f.w = 1.0f;
        return vector4f;
    }

    public Matrix4f projectedGridRange(Matrix4fc matrix4fc, float f2, float f3, Matrix4f matrix4f) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Matrix4f matrix4f2 = matrix4f;
        float f9 = Float.NEGATIVE_INFINITY;
        float f10 = Float.NEGATIVE_INFINITY;
        float f11 = Float.POSITIVE_INFINITY;
        float f12 = Float.POSITIVE_INFINITY;
        int i2 = 0;
        boolean z = false;
        while (i2 < 12) {
            float f13 = -1.0f;
            if (i2 < 4) {
                f6 = ((float) ((i2 & 1) << 1)) - 1.0f;
                f5 = ((float) (((i2 >>> 1) & 1) << 1)) - 1.0f;
                f4 = f5;
                f7 = f6;
                f8 = 1.0f;
            } else if (i2 < 8) {
                f8 = ((float) ((i2 & 1) << 1)) - 1.0f;
                f6 = -1.0f;
                f5 = ((float) (((i2 >>> 1) & 1) << 1)) - 1.0f;
                f4 = f5;
                f13 = f8;
                f7 = 1.0f;
            } else {
                f8 = ((float) ((i2 & 1) << 1)) - 1.0f;
                f7 = ((float) (((i2 >>> 1) & 1) << 1)) - 1.0f;
                f5 = -1.0f;
                f4 = 1.0f;
                f6 = f7;
                f13 = f8;
            }
            float f14 = this.m03;
            float f15 = f14 * f13;
            float f16 = this.m13;
            float f17 = (f16 * f6) + f15;
            float f18 = this.m23;
            float f19 = (f18 * f5) + f17;
            float f20 = this.m33;
            float f21 = 1.0f / (f19 + f20);
            float f22 = this.m00;
            float f23 = f22 * f13;
            float f24 = f10;
            float f25 = this.m10;
            float f26 = (f25 * f6) + f23;
            float f27 = f9;
            float f28 = this.m20;
            float f29 = (f28 * f5) + f26;
            float f30 = f11;
            float f31 = this.m30;
            float f32 = (f29 + f31) * f21;
            boolean z2 = z;
            float f33 = this.m01;
            float f34 = f33 * f13;
            int i3 = i2;
            float f35 = this.m11;
            float f36 = (f35 * f6) + f34;
            float f37 = f35;
            float f38 = this.m21;
            float f39 = (f38 * f5) + f36;
            float f40 = f38;
            float f41 = this.m31;
            float f42 = (f39 + f41) * f21;
            float f43 = f41;
            float f44 = this.m02;
            float f45 = f13 * f44;
            float f46 = f44;
            float f47 = this.m12;
            float f48 = (f6 * f47) + f45;
            float f49 = this.m22;
            float f50 = (f5 * f49) + f48;
            float f51 = this.m32;
            float f52 = (f50 + f51) * f21;
            float f53 = 1.0f / (((f18 * f4) + ((f16 * f7) + (f14 * f8))) + f20);
            float f54 = ((((f28 * f4) + ((f25 * f7) + (f22 * f8))) + f31) * f53) - f32;
            float f55 = ((((f49 * f4) + ((f47 * f7) + (f46 * f8))) + f51) * f53) - f52;
            float f56 = 1.0f / (((((f40 * f4) + ((f37 * f7) + (f33 * f8))) + f43) * f53) - f42);
            f10 = f24;
            f11 = f30;
            z = z2;
            int i4 = 0;
            while (i4 < 2) {
                float f57 = (-(f42 + (i4 == 0 ? f2 : f3))) * f56;
                if (f57 >= 0.0f && f57 <= 1.0f) {
                    float f58 = (f57 * f54) + f32;
                    float f59 = (f57 * f55) + f52;
                    float m332 = 1.0f / (matrix4fc.m33() + ((matrix4fc.m23() * f59) + (matrix4fc.m03() * f58)));
                    float m302 = (matrix4fc.m30() + (matrix4fc.m20() * f59) + (matrix4fc.m00() * f58)) * m332;
                    float m312 = (matrix4fc.m31() + (matrix4fc.m21() * f59) + (matrix4fc.m01() * f58)) * m332;
                    if (f11 >= m302) {
                        f11 = m302;
                    }
                    if (f12 >= m312) {
                        f12 = m312;
                    }
                    if (f27 <= m302) {
                        f27 = m302;
                    }
                    if (f10 <= m312) {
                        f10 = m312;
                    }
                    z = true;
                }
                i4++;
            }
            i2 = i3 + 1;
            Matrix4f matrix4f3 = matrix4f;
            f9 = f27;
        }
        float f60 = f9;
        float f61 = f10;
        float f62 = f11;
        if (!z) {
            return null;
        }
        matrix4f.set(f60 - f62, 0.0f, 0.0f, 0.0f, 0.0f, f61 - f12, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, f62, f12, 0.0f, 1.0f);
        Matrix4f matrix4f4 = matrix4f;
        matrix4f4._properties(2);
        return matrix4f4;
    }

    public int properties() {
        return this.properties;
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        _m00(objectInput.readFloat());
        _m01(objectInput.readFloat());
        _m02(objectInput.readFloat());
        _m03(objectInput.readFloat());
        _m10(objectInput.readFloat());
        _m11(objectInput.readFloat());
        _m12(objectInput.readFloat());
        _m13(objectInput.readFloat());
        _m20(objectInput.readFloat());
        _m21(objectInput.readFloat());
        _m22(objectInput.readFloat());
        _m23(objectInput.readFloat());
        _m30(objectInput.readFloat());
        _m31(objectInput.readFloat());
        _m32(objectInput.readFloat());
        _m33(objectInput.readFloat());
        _properties(0);
    }

    public Matrix4f reflect(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.reflection(f2, f3, f4, f5);
        }
        if ((i2 & 2) != 0) {
            return reflectAffine(f2, f3, f4, f5, matrix4f);
        }
        return reflectGeneric(f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f reflection(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f2;
        float f7 = f3 + f3;
        float f8 = f4 + f4;
        float f9 = f5 + f5;
        _m00(1.0f - (f6 * f2));
        float f10 = -f6;
        _m01(f10 * f3);
        _m02(f10 * f4);
        _m03(0.0f);
        float f11 = -f7;
        _m10(f11 * f2);
        _m11(1.0f - (f7 * f3));
        _m12(f11 * f4);
        _m13(0.0f);
        float f12 = -f8;
        _m20(f12 * f2);
        _m21(f12 * f3);
        _m22(1.0f - (f8 * f4));
        _m23(0.0f);
        float f13 = -f9;
        _m30(f2 * f13);
        _m31(f3 * f13);
        _m32(f13 * f4);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f rotate(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.rotation(f2, f3, f4, f5);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(f2, f3, f4, f5, matrix4f);
        }
        if ((i2 & 2) != 0) {
            return rotateAffine(f2, f3, f4, f5, matrix4f);
        }
        return rotateGeneric(f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f rotateAffine(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f44 = f33 * f18;
        float f45 = f44 + (f31 * f15) + (f28 * f14);
        float f46 = f41 * f18;
        float f47 = f46 + (f39 * f15) + (f36 * f14);
        float f48 = f26 * f34;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f48 + (f24 * f38) + (f22 * f19));
        matrix4f3._m21((this.m21 * f34) + (this.m11 * f38) + (this.m01 * f19));
        matrix4f3._m22((this.m22 * f34) + (this.m12 * f38) + (this.m02 * f19));
        matrix4f3._m23(0.0f);
        matrix4f3._m00(f30);
        matrix4f3._m01(f35);
        matrix4f3._m02(f42);
        matrix4f3._m03(0.0f);
        matrix4f3._m10(f43);
        matrix4f3._m11(f45);
        matrix4f3._m12(f47);
        matrix4f3._m13(0.0f);
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(1.0f);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f rotateAffineXYZ(float f2, float f3, float f4) {
        return rotateAffineXYZ(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateAffineYXZ(float f2, float f3, float f4) {
        return rotateAffineYXZ(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateAffineZYX(float f2, float f3, float f4) {
        return rotateAffineZYX(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4) {
        return rotateAround(quaternionfc, f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateAroundAffine(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4f matrix4f2 = matrix4f;
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc2, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f5 = y2 + y2;
        float b2 = a.b(quaternionfc2, quaternionfc.x());
        float a3 = a.a(quaternionfc2, quaternionfc.y());
        float b3 = a.b(quaternionfc2, quaternionfc.y());
        float a4 = a.a(quaternionfc2, quaternionfc.x());
        float b4 = a.b(w, x, z, y);
        float f6 = f5 + a2;
        float f7 = b2 - a3;
        float f8 = (-a2) + f5;
        float c2 = a.c(y, z, w, x);
        float f9 = b3 + a4;
        float f10 = a3 + b2;
        float f11 = b3 - a4;
        float d2 = a.d(z, y, x, w);
        float f12 = this.m00;
        float f13 = f12 * f2;
        float f14 = this.m10;
        float f15 = (f14 * f3) + f13;
        float f16 = this.m20;
        float f17 = (f16 * f4) + f15 + this.m30;
        float f18 = this.m01;
        float f19 = f18 * f2;
        float f20 = f17;
        float f21 = this.m11;
        float f22 = (f21 * f3) + f19;
        float f23 = this.m21;
        float f24 = (f23 * f4) + f22;
        float f25 = d2;
        float f26 = f24 + this.m31;
        float f27 = this.m02;
        float f28 = f27 * f2;
        float f29 = f11;
        float f30 = this.m12;
        float f31 = (f30 * f3) + f28;
        float f32 = f10;
        float f33 = this.m22;
        float f34 = (f33 * f4) + f31;
        float f35 = f9;
        float f36 = f34 + this.m32;
        float f37 = (f16 * f7) + (f14 * f6) + (f12 * b4);
        float f38 = (f23 * f7) + (f21 * f6) + (f18 * b4);
        float f39 = f7 * f33;
        float f40 = f39 + (f6 * f30) + (b4 * f27);
        float f41 = (f16 * f35) + (f14 * c2) + (f12 * f8);
        float f42 = f23 * f35;
        float f43 = f42 + (f21 * c2) + (f18 * f8);
        float f44 = f33 * f35;
        float f45 = f44 + (f30 * c2) + (f27 * f8);
        float f46 = f16 * f25;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f46 + (f14 * f29) + (f12 * f32));
        matrix4f3._m21((this.m21 * f25) + (this.m11 * f29) + (this.m01 * f32));
        matrix4f3._m22((this.m22 * f25) + (this.m12 * f29) + (this.m02 * f32));
        matrix4f3._m23(0.0f);
        float f47 = f37;
        matrix4f3._m00(f47);
        matrix4f3._m01(f38);
        matrix4f3._m02(f40);
        matrix4f3._m03(0.0f);
        matrix4f3._m10(f41);
        matrix4f3._m11(f43);
        matrix4f3._m12(f45);
        matrix4f3._m13(0.0f);
        matrix4f3._m30(((((-f47) * f2) - (f41 * f3)) - (this.m20 * f4)) + f20);
        matrix4f3._m31(((((-f38) * f2) - (f43 * f3)) - (this.m21 * f4)) + f26);
        matrix4f3._m32(((((-f40) * f2) - (f45 * f3)) - (this.m22 * f4)) + f36);
        matrix4f3._m33(1.0f);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f rotateAroundLocal(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float w2 = quaternionfc.w() * quaternionfc.z();
        float y2 = quaternionfc.y() * quaternionfc.x();
        float z2 = quaternionfc.z() * quaternionfc.x();
        float w3 = quaternionfc.w() * quaternionfc.y();
        float z3 = quaternionfc.z() * quaternionfc.y();
        float w4 = quaternionfc.w() * quaternionfc.x();
        float b2 = a.b(w, x, z, y);
        float a2 = a.a(y2, w2, w2, y2);
        float c2 = a.c(z2, w3, z2, w3);
        float f5 = (((-w2) + y2) - w2) + y2;
        float c3 = a.c(y, z, w, x);
        float f6 = z3 + z3;
        float f7 = f6 + w4 + w4;
        float a3 = a.a(w3, z2, z2, w3);
        float f8 = (f6 - w4) - w4;
        float d2 = a.d(z, y, x, w);
        float f9 = this.m00;
        float f10 = this.m03;
        float f11 = f9 - (f2 * f10);
        float f12 = this.m01 - (f3 * f10);
        float f13 = this.m02 - (f4 * f10);
        float f14 = this.m10;
        float f15 = d2;
        float f16 = this.m13;
        float f17 = f14 - (f2 * f16);
        float f18 = this.m11 - (f3 * f16);
        float f19 = this.m12 - (f16 * f4);
        float f20 = this.m20;
        float f21 = f19;
        float f22 = this.m23;
        float f23 = f20 - (f2 * f22);
        float f24 = this.m21 - (f3 * f22);
        float f25 = this.m22 - (f22 * f4);
        float f26 = this.m30;
        float f27 = f25;
        float f28 = this.m33;
        float f29 = f26 - (f2 * f28);
        float f30 = this.m31 - (f3 * f28);
        float f31 = this.m32 - (f28 * f4);
        float f32 = f10 * f2;
        matrix4f2._m00(f32 + (a3 * f13) + (f5 * f12) + (b2 * f11));
        matrix4f2._m01((this.m03 * f3) + (f8 * f13) + (c3 * f12) + (a2 * f11));
        float f33 = f13 * f15;
        matrix4f2._m02((this.m03 * f4) + f33 + (f12 * f7) + (f11 * c2));
        matrix4f2._m03(this.m03);
        matrix4f2._m10((this.m13 * f2) + (a3 * f21) + (f5 * f18) + (b2 * f17));
        matrix4f2._m11((this.m13 * f3) + (f8 * f21) + (c3 * f18) + (a2 * f17));
        matrix4f2._m12((this.m13 * f4) + (f15 * f21) + (f7 * f18) + (c2 * f17));
        matrix4f2._m13(this.m13);
        matrix4f2._m20((this.m23 * f2) + (a3 * f27) + (f5 * f24) + (b2 * f23));
        matrix4f2._m21((this.m23 * f3) + (f8 * f27) + (c3 * f24) + (a2 * f23));
        matrix4f2._m22((this.m23 * f4) + (f15 * f27) + (f7 * f24) + (c2 * f23));
        matrix4f2._m23(this.m23);
        float f34 = a3 * f31;
        matrix4f2._m30((this.m33 * f2) + f34 + (f5 * f30) + (b2 * f29));
        float f35 = f8 * f31;
        matrix4f2._m31((this.m33 * f3) + f35 + (c3 * f30) + (a2 * f29));
        float f36 = f15 * f31;
        matrix4f2._m32((this.m33 * f4) + f36 + (f7 * f30) + (c2 * f29));
        matrix4f2._m33(this.m33);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateLocal(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.rotation(f2, f3, f4, f5);
        }
        return rotateLocalGeneric(f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f rotateLocalX(float f2, Matrix4f matrix4f) {
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
        float f17 = (f15 * cosFromSin) + (f13 * sin);
        float f18 = this.m31;
        float f19 = cosFromSin * f18;
        float f20 = this.m32;
        float f21 = f19 - (sin * f20);
        float f22 = (cosFromSin * f20) + (sin * f18);
        matrix4f._m00(this.m00);
        matrix4f._m01(f6);
        matrix4f._m02(f7);
        matrix4f._m03(this.m03);
        matrix4f._m10(this.m10);
        matrix4f._m11(f11);
        matrix4f._m12(f12);
        matrix4f._m13(this.m13);
        matrix4f._m20(this.m20);
        matrix4f._m21(f16);
        matrix4f._m22(f17);
        matrix4f._m23(this.m23);
        matrix4f._m30(this.m30);
        matrix4f._m31(f21);
        matrix4f._m32(f22);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateLocalY(float f2, Matrix4f matrix4f) {
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
        float f18 = (f16 * cosFromSin) + (f14 * f7);
        float f19 = this.m30;
        float f20 = cosFromSin * f19;
        float f21 = this.m32;
        float f22 = (sin * f21) + f20;
        float f23 = (cosFromSin * f21) + (f7 * f19);
        matrix4f._m00(f6);
        matrix4f._m01(this.m01);
        matrix4f._m02(f8);
        matrix4f._m03(this.m03);
        matrix4f._m10(f12);
        matrix4f._m11(this.m11);
        matrix4f._m12(f13);
        matrix4f._m13(this.m13);
        matrix4f._m20(f17);
        matrix4f._m21(this.m21);
        matrix4f._m22(f18);
        matrix4f._m23(this.m23);
        matrix4f._m30(f22);
        matrix4f._m31(this.m31);
        matrix4f._m32(f23);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateLocalZ(float f2, Matrix4f matrix4f) {
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
        float f17 = (f15 * cosFromSin) + (f13 * sin);
        float f18 = this.m30;
        float f19 = cosFromSin * f18;
        float f20 = this.m31;
        float f21 = f19 - (sin * f20);
        float f22 = (cosFromSin * f20) + (sin * f18);
        matrix4f._m00(f6);
        matrix4f._m01(f7);
        matrix4f._m02(this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m10(f11);
        matrix4f._m11(f12);
        matrix4f._m12(this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m20(f16);
        matrix4f._m21(f17);
        matrix4f._m22(this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30(f21);
        matrix4f._m31(f22);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4f);
    }

    public Matrix4f rotateTowardsXY(float f2, float f3) {
        return rotateTowardsXY(f2, f3, thisOrNew());
    }

    public Matrix4f rotateTranslation(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f19 = f16 - f17;
        float f20 = (f5 * f5 * f6) + cosFromSin;
        matrix4f2._m20(f11 + f12);
        matrix4f2._m21(f19);
        matrix4f2._m22(f20);
        matrix4f2._m00(f7);
        matrix4f2._m01(f10);
        matrix4f2._m02(f13);
        matrix4f2._m03(0.0f);
        matrix4f2._m10(f14);
        matrix4f2._m11(f15);
        matrix4f2._m12(f18);
        matrix4f2._m13(0.0f);
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(1.0f);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateX(float f2, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.rotationX(f2);
        }
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = -sin;
        float f4 = this.m10;
        float f5 = f4 * cosFromSin;
        float f6 = this.m20;
        float f7 = (f6 * sin) + f5;
        float f8 = (this.m21 * sin) + (this.m11 * cosFromSin);
        float f9 = (this.m22 * sin) + (this.m12 * cosFromSin);
        float f10 = (this.m23 * sin) + (this.m13 * cosFromSin);
        matrix4f._m20((f6 * cosFromSin) + (f4 * f3));
        matrix4f._m21((this.m21 * cosFromSin) + (this.m11 * f3));
        matrix4f._m22((this.m22 * cosFromSin) + (this.m12 * f3));
        matrix4f._m23((this.m23 * cosFromSin) + (this.m13 * f3));
        matrix4f._m10(f7);
        matrix4f._m11(f8);
        matrix4f._m12(f9);
        matrix4f._m13(f10);
        matrix4f._m00(this.m00);
        matrix4f._m01(this.m01);
        matrix4f._m02(this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateXYZ(Vector3f vector3f) {
        return rotateXYZ(vector3f.x, vector3f.y, vector3f.z);
    }

    public Matrix4f rotateY(float f2, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.rotationY(f2);
        }
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f3 = -sin;
        float f4 = this.m00;
        float f5 = f4 * cosFromSin;
        float f6 = this.m20;
        float f7 = (f6 * f3) + f5;
        float f8 = (this.m21 * f3) + (this.m01 * cosFromSin);
        float f9 = (this.m22 * f3) + (this.m02 * cosFromSin);
        float f10 = (this.m23 * f3) + (this.m03 * cosFromSin);
        matrix4f._m20((f6 * cosFromSin) + (f4 * sin));
        matrix4f._m21((this.m21 * cosFromSin) + (this.m01 * sin));
        matrix4f._m22((this.m22 * cosFromSin) + (this.m02 * sin));
        matrix4f._m23((this.m23 * cosFromSin) + (this.m03 * sin));
        matrix4f._m00(f7);
        matrix4f._m01(f8);
        matrix4f._m02(f9);
        matrix4f._m03(f10);
        matrix4f._m10(this.m10);
        matrix4f._m11(this.m11);
        matrix4f._m12(this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateYXZ(Vector3f vector3f) {
        return rotateYXZ(vector3f.y, vector3f.x, vector3f.z);
    }

    public Matrix4f rotateZ(float f2, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.rotationZ(f2);
        }
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        return rotateTowardsXY(sin, (float) Math.cosFromSin((double) sin, d2), matrix4f);
    }

    public Matrix4f rotateZYX(Vector3f vector3f) {
        return rotateZYX(vector3f.z, vector3f.y, vector3f.x);
    }

    public Matrix4f rotation(float f2, Vector3fc vector3fc) {
        return rotation(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f rotationAround(Quaternionfc quaternionfc, float f2, float f3, float f4) {
        float w = quaternionfc.w() * quaternionfc.w();
        float x = quaternionfc.x() * quaternionfc.x();
        float y = quaternionfc.y() * quaternionfc.y();
        float z = quaternionfc.z() * quaternionfc.z();
        float a2 = a.a(quaternionfc, quaternionfc.z());
        float y2 = quaternionfc.y() * quaternionfc.x();
        float f5 = y2 + y2;
        float b2 = a.b(quaternionfc, quaternionfc.x());
        float a3 = a.a(quaternionfc, quaternionfc.y());
        float b3 = a.b(quaternionfc, quaternionfc.y());
        float a4 = a.a(quaternionfc, quaternionfc.x());
        _m20(a3 + b2);
        _m21(b3 - a4);
        _m22(((z - y) - x) + w);
        _m23(0.0f);
        _m00(((w + x) - z) - y);
        _m01(f5 + a2);
        _m02(b2 - a3);
        _m03(0.0f);
        _m10((-a2) + f5);
        _m11(((y - z) + w) - x);
        _m12(b3 + a4);
        _m13(0.0f);
        _m30(((((-this.m00) * f2) - (this.m10 * f3)) - (this.m20 * f4)) + f2);
        _m31(((((-this.m01) * f2) - (this.m11 * f3)) - (this.m21 * f4)) + f3);
        _m32(((((-this.m02) * f2) - (this.m12 * f3)) - (this.m22 * f4)) + f4);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f rotationTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotationTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4f rotationTowardsXY(float f2, float f3) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(f3);
        _m01(f2);
        _m10(-f2);
        _m11(f3);
        _properties(18);
        return this;
    }

    public Matrix4f rotationX(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m11(cosFromSin);
        _m12(sin);
        _m21(-sin);
        _m22(cosFromSin);
        _properties(18);
        return this;
    }

    public Matrix4f rotationXYZ(float f2, float f3, float f4) {
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
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f8 = f5 * f6;
        float f9 = f6 * cosFromSin;
        _m20(sin2);
        _m21(f5 * cosFromSin2);
        _m22(cosFromSin * cosFromSin2);
        _m00(cosFromSin2 * cosFromSin3);
        _m01((cosFromSin * sin3) + (f8 * cosFromSin3));
        _m02((sin3 * sin) + (f9 * cosFromSin3));
        _m10(cosFromSin2 * f7);
        _m11((cosFromSin * cosFromSin3) + (f8 * f7));
        _m12((sin * cosFromSin3) + (f9 * f7));
        _properties(18);
        return this;
    }

    public Matrix4f rotationY(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(cosFromSin);
        _m02(-sin);
        _m20(sin);
        _m22(cosFromSin);
        _properties(18);
        return this;
    }

    public Matrix4f rotationYXZ(float f2, float f3, float f4) {
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
        _m20(sin2 * cosFromSin);
        _m21(f6);
        _m22(cosFromSin2 * cosFromSin);
        _m23(0.0f);
        _m00((f8 * sin3) + (cosFromSin2 * cosFromSin3));
        _m01(cosFromSin * sin3);
        _m02((sin3 * f9) + (f5 * cosFromSin3));
        _m03(0.0f);
        _m10((f8 * cosFromSin3) + (cosFromSin2 * f7));
        _m11(cosFromSin * cosFromSin3);
        _m12((f9 * cosFromSin3) + (f5 * f7));
        _m13(0.0f);
        _m30(0.0f);
        _m31(0.0f);
        _m32(0.0f);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f rotationZ(float f2) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(cosFromSin);
        _m01(sin);
        _m10(-sin);
        _m11(cosFromSin);
        _properties(18);
        return this;
    }

    public Matrix4f rotationZYX(float f2, float f3, float f4) {
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
        _m00(cosFromSin3 * cosFromSin2);
        _m01(sin3 * cosFromSin2);
        _m02(f6);
        _m03(0.0f);
        _m10((f8 * sin) + (f5 * cosFromSin));
        _m11((f9 * sin) + (cosFromSin3 * cosFromSin));
        _m12(sin * cosFromSin2);
        _m13(0.0f);
        _m20((f8 * cosFromSin) + (f5 * f7));
        _m21((f9 * cosFromSin) + (cosFromSin3 * f7));
        _m22(cosFromSin2 * cosFromSin);
        _m23(0.0f);
        _m30(0.0f);
        _m31(0.0f);
        _m32(0.0f);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f scale(Vector3fc vector3fc, Matrix4f matrix4f) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4f);
    }

    public Matrix4f scaleAround(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        float f8 = this.m00;
        float f9 = (this.m20 * f7) + (this.m10 * f6) + (f8 * f5) + this.m30;
        float f10 = (this.m21 * f7) + (this.m11 * f6) + (this.m01 * f5) + this.m31;
        float f11 = (this.m22 * f7) + (this.m12 * f6) + (this.m02 * f5) + this.m32;
        float f12 = (this.m23 * f7) + (this.m13 * f6) + (this.m03 * f5) + this.m33;
        matrix4f._m00(f8 * f2);
        matrix4f._m01(this.m01 * f2);
        matrix4f._m02(this.m02 * f2);
        matrix4f._m03(this.m03 * f2);
        matrix4f._m10(this.m10 * f3);
        matrix4f._m11(this.m11 * f3);
        matrix4f._m12(this.m12 * f3);
        matrix4f._m13(this.m13 * f3);
        matrix4f._m20(this.m20 * f4);
        matrix4f._m21(this.m21 * f4);
        matrix4f._m22(this.m22 * f4);
        matrix4f._m23(this.m23 * f4);
        matrix4f._m30(((((-this.m00) * f5) - (this.m10 * f6)) - (this.m20 * f7)) + f9);
        matrix4f._m31(((((-this.m01) * f5) - (this.m11 * f6)) - (this.m21 * f7)) + f10);
        matrix4f._m32(((((-this.m02) * f5) - (this.m12 * f6)) - (this.m22 * f7)) + f11);
        matrix4f._m33(((((-this.m03) * f5) - (this.m13 * f6)) - (this.m23 * f7)) + f12);
        int i2 = 0;
        boolean z = Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4f._properties((~(i2 | 13)) & i3);
        return matrix4f;
    }

    public Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        float f8 = this.m00;
        float f9 = this.m03;
        matrix4f._m00((f9 * f5) + a.i(f5, f9, f8, f2));
        float f10 = this.m01;
        float f11 = this.m03;
        matrix4f._m01((f11 * f6) + a.i(f6, f11, f10, f3));
        float f12 = this.m02;
        float f13 = this.m03;
        matrix4f._m02((f13 * f7) + a.i(f7, f13, f12, f4));
        matrix4f._m03(this.m03);
        float f14 = this.m10;
        float f15 = this.m13;
        matrix4f._m10((f15 * f5) + a.i(f5, f15, f14, f2));
        float f16 = this.m11;
        float f17 = this.m13;
        matrix4f._m11((f17 * f6) + a.i(f6, f17, f16, f3));
        float f18 = this.m12;
        float f19 = this.m13;
        matrix4f._m12((f19 * f7) + a.i(f7, f19, f18, f4));
        matrix4f._m13(this.m13);
        float f20 = this.m20;
        float f21 = this.m23;
        matrix4f._m20((f21 * f5) + a.i(f5, f21, f20, f2));
        float f22 = this.m21;
        float f23 = this.m23;
        matrix4f._m21((f23 * f6) + a.i(f6, f23, f22, f3));
        float f24 = this.m22;
        float f25 = this.m23;
        matrix4f._m22((f25 * f7) + a.i(f7, f25, f24, f4));
        matrix4f._m23(this.m23);
        float f26 = this.m30;
        float f27 = this.m33;
        matrix4f._m30((f5 * f27) + a.i(f5, f27, f26, f2));
        float f28 = this.m31;
        float f29 = this.m33;
        matrix4f._m31((f6 * f29) + a.i(f6, f29, f28, f3));
        float f30 = this.m32;
        float f31 = this.m33;
        matrix4f._m32((f7 * f31) + a.i(f7, f31, f30, f4));
        matrix4f._m33(this.m33);
        int i2 = 0;
        boolean z = Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f;
        int i3 = this.properties;
        if (!z) {
            i2 = 16;
        }
        matrix4f._properties((~(i2 | 13)) & i3);
        return matrix4f;
    }

    public Matrix4f scaleLocal(float f2, float f3, float f4, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.scaling(f2, f3, f4);
        }
        return scaleLocalGeneric(f2, f3, f4, matrix4f);
    }

    public Matrix4f scaling(float f2) {
        return scaling(f2, f2, f2);
    }

    public Matrix4f set(Matrix4fc matrix4fc) {
        if (matrix4fc instanceof Matrix4f) {
            MemUtil.INSTANCE.copy((Matrix4f) matrix4fc, this);
        } else {
            setMatrix4fc(matrix4fc);
        }
        _properties(matrix4fc.properties());
        return this;
    }

    public Matrix4f set3x3(Matrix4f matrix4f) {
        MemUtil.INSTANCE.copy3x3(matrix4f, this);
        this.properties = matrix4f.properties & -2 & this.properties;
        return this;
    }

    public Matrix4f set4x3(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy4x3((Matrix4x3f) matrix4x3fc, this);
        } else {
            set4x3Matrix4x3fc(matrix4x3fc);
        }
        this.properties = matrix4x3fc.properties() & -2 & this.properties;
        return this;
    }

    public Matrix4f setColumn(int i2, Vector4fc vector4fc) throws IndexOutOfBoundsException {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IndexOutOfBoundsException();
                    } else if (vector4fc instanceof Vector4f) {
                        MemUtil.INSTANCE.getColumn3(this, (Vector4f) vector4fc);
                    } else {
                        _m30(vector4fc.x());
                        _m31(vector4fc.y());
                        _m32(vector4fc.z());
                        _m33(vector4fc.w());
                    }
                } else if (vector4fc instanceof Vector4f) {
                    MemUtil.INSTANCE.getColumn2(this, (Vector4f) vector4fc);
                } else {
                    _m20(vector4fc.x());
                    _m21(vector4fc.y());
                    _m22(vector4fc.z());
                    _m23(vector4fc.w());
                }
            } else if (vector4fc instanceof Vector4f) {
                MemUtil.INSTANCE.getColumn1(this, (Vector4f) vector4fc);
            } else {
                _m10(vector4fc.x());
                _m11(vector4fc.y());
                _m12(vector4fc.z());
                _m13(vector4fc.w());
            }
        } else if (vector4fc instanceof Vector4f) {
            MemUtil.INSTANCE.getColumn0(this, (Vector4f) vector4fc);
        } else {
            _m00(vector4fc.x());
            _m01(vector4fc.y());
            _m02(vector4fc.z());
            _m03(vector4fc.w());
        }
        _properties(0);
        return this;
    }

    public Matrix4f setFromIntrinsic(float f2, float f3, float f4, float f5, float f6, int i2, int i3, float f7, float f8) {
        float f9 = 2.0f / ((float) i2);
        float f10 = 2.0f / ((float) i3);
        float f11 = f7 - f8;
        float f12 = 2.0f / f11;
        this.m00 = f2 * f9;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = f4 * f9;
        this.m11 = f3 * f10;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = (f9 * f5) - 1.0f;
        this.m21 = (f10 * f6) - 1.0f;
        float f13 = f7 + f8;
        this.m22 = (f13 / f11) + ((-f13) * f12);
        this.m23 = -1.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = f12 * (-f7) * f8;
        this.m33 = 0.0f;
        this.properties = 1;
        return this;
    }

    public Matrix4f setFrustum(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f8 = f6 + f6;
        float f9 = f3 - f2;
        _m00(f8 / f9);
        float f10 = f5 - f4;
        _m11(f8 / f10);
        _m20((f3 + f2) / f9);
        _m21((f5 + f4) / f10);
        int i2 = 1;
        boolean z2 = f7 > 0.0f && Float.isInfinite(f7);
        boolean z3 = f6 > 0.0f && Float.isInfinite(f6);
        float f11 = 2.0f;
        if (z2) {
            _m22(-0.999999f);
            if (z) {
                f11 = 1.0f;
            }
            _m32((1.0E-6f - f11) * f6);
        } else if (z3) {
            _m22((z ? 0.0f : 1.0f) - 1.0E-6f);
            if (z) {
                f11 = 1.0f;
            }
            _m32((f11 - 1.0E-6f) * f7);
        } else {
            float f12 = f6 - f7;
            _m22((z ? f7 : f7 + f6) / f12);
            if (!z) {
                f7 += f7;
            }
            _m32((f7 * f6) / f12);
        }
        _m23(-1.0f);
        _m33(0.0f);
        if (!(this.m20 == 0.0f && this.m21 == 0.0f)) {
            i2 = 0;
        }
        _properties(i2);
        return this;
    }

    public Matrix4f setFrustumLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f8 = f6 + f6;
        float f9 = f3 - f2;
        _m00(f8 / f9);
        float f10 = f5 - f4;
        _m11(f8 / f10);
        _m20((f3 + f2) / f9);
        _m21((f5 + f4) / f10);
        boolean z2 = true;
        boolean z3 = f7 > 0.0f && Float.isInfinite(f7);
        if (f6 <= 0.0f || !Float.isInfinite(f6)) {
            z2 = false;
        }
        float f11 = 2.0f;
        if (z3) {
            _m22(0.999999f);
            if (z) {
                f11 = 1.0f;
            }
            _m32((1.0E-6f - f11) * f6);
        } else if (z2) {
            _m22((z ? 0.0f : 1.0f) - 1.0E-6f);
            if (z) {
                f11 = 1.0f;
            }
            _m32((f11 - 1.0E-6f) * f7);
        } else {
            _m22((z ? f7 : f7 + f6) / (f7 - f6));
            _m32(((z ? f7 : f7 + f7) * f6) / (f6 - f7));
        }
        _m23(1.0f);
        _m33(0.0f);
        _properties(0);
        return this;
    }

    public Matrix4f setLookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return setLookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4f setLookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return setLookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4f setLookAtCompat(Vector3f vector3f) {
        set((Matrix3fc) new Matrix3f().setLookAtCompat(vector3f));
        return this;
    }

    public Matrix4f setLookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return setLookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4f setOrtho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f8 = 2.0f;
        _m00(2.0f / (f3 - f2));
        _m11(2.0f / (f5 - f4));
        if (z) {
            f8 = 1.0f;
        }
        float f9 = f6 - f7;
        _m22(f8 / f9);
        _m30((f3 + f2) / (f2 - f3));
        _m31((f5 + f4) / (f4 - f5));
        if (!z) {
            f6 += f7;
        }
        _m32(f6 / f9);
        _properties(2);
        return this;
    }

    public Matrix4f setOrtho2D(float f2, float f3, float f4, float f5) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(2.0f / (f3 - f2));
        _m11(2.0f / (f5 - f4));
        _m22(-1.0f);
        _m30((f3 + f2) / (f2 - f3));
        _m31((f5 + f4) / (f4 - f5));
        _properties(2);
        return this;
    }

    public Matrix4f setOrtho2DLH(float f2, float f3, float f4, float f5) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(2.0f / (f3 - f2));
        _m11(2.0f / (f5 - f4));
        _m30((f3 + f2) / (f2 - f3));
        _m31((f5 + f4) / (f4 - f5));
        _properties(2);
        return this;
    }

    public Matrix4f setOrthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f8 = 2.0f;
        _m00(2.0f / (f3 - f2));
        _m11(2.0f / (f5 - f4));
        if (z) {
            f8 = 1.0f;
        }
        _m22(f8 / (f7 - f6));
        _m30((f3 + f2) / (f2 - f3));
        _m31((f5 + f4) / (f4 - f5));
        _m32((z ? f6 : f7 + f6) / (f6 - f7));
        _properties(2);
        return this;
    }

    public Matrix4f setOrthoSymmetric(float f2, float f3, float f4, float f5, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f6 = 2.0f;
        _m00(2.0f / f2);
        _m11(2.0f / f3);
        if (z) {
            f6 = 1.0f;
        }
        float f7 = f4 - f5;
        _m22(f6 / f7);
        if (!z) {
            f4 += f5;
        }
        _m32(f4 / f7);
        _properties(2);
        return this;
    }

    public Matrix4f setOrthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        float f6 = 2.0f;
        _m00(2.0f / f2);
        _m11(2.0f / f3);
        if (z) {
            f6 = 1.0f;
        }
        _m22(f6 / (f5 - f4));
        _m32((z ? f4 : f5 + f4) / (f4 - f5));
        _properties(2);
        return this;
    }

    public Matrix4f setPerspective(float f2, float f3, float f4, float f5, boolean z) {
        MemUtil.INSTANCE.zero(this);
        float tan = (float) Math.tan((double) (f2 * 0.5f));
        float f6 = 1.0f;
        _m00(1.0f / (f3 * tan));
        _m11(1.0f / tan);
        float f7 = 0.0f;
        boolean z2 = false;
        boolean z3 = f5 > 0.0f && Float.isInfinite(f5);
        if (f4 > 0.0f && Float.isInfinite(f4)) {
            z2 = true;
        }
        if (z3) {
            _m22(-0.999999f);
            if (!z) {
                f6 = 2.0f;
            }
            _m32((1.0E-6f - f6) * f4);
        } else if (z2) {
            if (!z) {
                f7 = 1.0f;
            }
            _m22(f7 - 1.0E-6f);
            if (!z) {
                f6 = 2.0f;
            }
            _m32((f6 - 1.0E-6f) * f5);
        } else {
            float f8 = f4 - f5;
            _m22((z ? f5 : f5 + f4) / f8);
            if (!z) {
                f5 += f5;
            }
            _m32((f5 * f4) / f8);
        }
        _m23(-1.0f);
        _properties(1);
        return this;
    }

    public Matrix4f setPerspectiveLH(float f2, float f3, float f4, float f5, boolean z) {
        MemUtil.INSTANCE.zero(this);
        float tan = (float) Math.tan((double) (f2 * 0.5f));
        _m00(1.0f / (f3 * tan));
        _m11(1.0f / tan);
        float f6 = 0.0f;
        boolean z2 = false;
        boolean z3 = f5 > 0.0f && Float.isInfinite(f5);
        if (f4 > 0.0f && Float.isInfinite(f4)) {
            z2 = true;
        }
        float f7 = 2.0f;
        if (z3) {
            _m22(0.999999f);
            if (z) {
                f7 = 1.0f;
            }
            _m32((1.0E-6f - f7) * f4);
        } else if (z2) {
            if (!z) {
                f6 = 1.0f;
            }
            _m22(f6 - 1.0E-6f);
            if (z) {
                f7 = 1.0f;
            }
            _m32((f7 - 1.0E-6f) * f5);
        } else {
            _m22((z ? f5 : f5 + f4) / (f5 - f4));
            _m32(((z ? f5 : f5 + f5) * f4) / (f4 - f5));
        }
        _m23(1.0f);
        _properties(1);
        return this;
    }

    public Matrix4f setRotationXYZ(float f2, float f3, float f4) {
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
        _m20(sin2);
        _m21(f5 * cosFromSin2);
        _m22(cosFromSin * cosFromSin2);
        _m00(cosFromSin2 * cosFromSin3);
        _m01((cosFromSin * sin3) + (f8 * cosFromSin3));
        _m02((sin3 * sin) + (f9 * cosFromSin3));
        _m10(cosFromSin2 * f7);
        _m11((cosFromSin * cosFromSin3) + (f8 * f7));
        _m12((sin * cosFromSin3) + (f9 * f7));
        this.properties &= -14;
        return this;
    }

    public Matrix4f setRotationYXZ(float f2, float f3, float f4) {
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
        _m20(sin2 * cosFromSin);
        _m21(f6);
        _m22(cosFromSin2 * cosFromSin);
        _m00((f8 * sin3) + (cosFromSin2 * cosFromSin3));
        _m01(cosFromSin * sin3);
        _m02((sin3 * f9) + (f5 * cosFromSin3));
        _m10((f8 * cosFromSin3) + (cosFromSin2 * f7));
        _m11(cosFromSin * cosFromSin3);
        _m12((f9 * cosFromSin3) + (f5 * f7));
        this.properties &= -14;
        return this;
    }

    public Matrix4f setRotationZYX(float f2, float f3, float f4) {
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
        _m00(cosFromSin3 * cosFromSin2);
        _m01(sin3 * cosFromSin2);
        _m02(f6);
        _m10((f8 * sin) + (f5 * cosFromSin));
        _m11((f9 * sin) + (cosFromSin3 * cosFromSin));
        _m12(sin * cosFromSin2);
        _m20((f8 * cosFromSin) + (f5 * f7));
        _m21((f9 * cosFromSin) + (cosFromSin3 * f7));
        _m22(cosFromSin2 * cosFromSin);
        this.properties &= -14;
        return this;
    }

    public Matrix4f setRow(int i2, Vector4fc vector4fc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            _m00(vector4fc.x());
            _m10(vector4fc.y());
            _m20(vector4fc.z());
            _m30(vector4fc.w());
        } else if (i2 == 1) {
            _m01(vector4fc.x());
            _m11(vector4fc.y());
            _m21(vector4fc.z());
            _m31(vector4fc.w());
        } else if (i2 == 2) {
            _m02(vector4fc.x());
            _m12(vector4fc.y());
            _m22(vector4fc.z());
            _m32(vector4fc.w());
        } else if (i2 == 3) {
            _m03(vector4fc.x());
            _m13(vector4fc.y());
            _m23(vector4fc.z());
            _m33(vector4fc.w());
        } else {
            throw new IndexOutOfBoundsException();
        }
        _properties(0);
        return this;
    }

    public Matrix4f setTranslation(float f2, float f3, float f4) {
        _m30(f2);
        _m31(f3);
        _m32(f4);
        this.properties &= -6;
        return this;
    }

    public Matrix4f shadow(Vector4f vector4f, float f2, float f3, float f4, float f5) {
        return shadow(vector4f.x, vector4f.y, vector4f.z, vector4f.w, f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f sub(Matrix4fc matrix4fc) {
        return sub(matrix4fc, thisOrNew());
    }

    public Matrix4f sub4x3(Matrix4f matrix4f) {
        return sub4x3(matrix4f, thisOrNew());
    }

    public Matrix4f swap(Matrix4f matrix4f) {
        MemUtil.INSTANCE.swap(this, matrix4f);
        int i2 = this.properties;
        this.properties = matrix4f.properties();
        matrix4f.properties = i2;
        return this;
    }

    public boolean testAab(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.m03;
        float f9 = this.m00;
        float f10 = f8 + f9;
        float f11 = this.m13;
        float f12 = this.m10;
        float f13 = f11 + f12;
        float f14 = this.m23;
        float f15 = this.m20;
        float f16 = f14 + f15;
        float f17 = this.m33;
        float f18 = this.m30;
        float f19 = f17 + f18;
        float f20 = f8 - f9;
        float f21 = f11 - f12;
        float f22 = f14 - f15;
        float f23 = f17 - f18;
        float f24 = this.m01;
        float f25 = f8 + f24;
        float f26 = this.m11;
        float f27 = f11 + f26;
        float f28 = f25;
        float f29 = this.m21;
        float f30 = f14 + f29;
        float f31 = f23;
        float f32 = this.m31;
        float f33 = f22;
        float f34 = f17 + f32;
        float f35 = f8 - f24;
        float f36 = f11 - f26;
        float f37 = f14 - f29;
        float f38 = f17 - f32;
        float f39 = this.m02;
        float f40 = f8 + f39;
        float f41 = f37;
        float f42 = this.m12;
        float f43 = f11 + f42;
        float f44 = f36;
        float f45 = this.m22;
        float f46 = f14 + f45;
        float f47 = f35;
        float f48 = this.m32;
        float f49 = f17 + f48;
        float f50 = f8 - f39;
        float f51 = f11 - f42;
        float f52 = f14 - f45;
        float f53 = f17 - f48;
        if ((f16 * (f16 < 0.0f ? f4 : f7)) + (f13 * (f13 < 0.0f ? f3 : f6)) + (f10 * (f10 < 0.0f ? f2 : f5)) >= (-f19)) {
            if (((f33 < 0.0f ? f4 : f7) * f33) + (f21 * (f21 < 0.0f ? f3 : f6)) + (f20 * (f20 < 0.0f ? f2 : f5)) >= (-f31)) {
                if ((f30 * (f30 < 0.0f ? f4 : f7)) + (f27 * (f27 < 0.0f ? f3 : f6)) + (f28 * (f28 < 0.0f ? f2 : f5)) >= (-f34)) {
                    if ((f41 * (f41 < 0.0f ? f4 : f7)) + (f44 * (f44 < 0.0f ? f3 : f6)) + (f47 * (f47 < 0.0f ? f2 : f5)) >= (-f38)) {
                        if ((f46 * (f46 < 0.0f ? f4 : f7)) + (f43 * (f43 < 0.0f ? f3 : f6)) + (f40 * (f40 < 0.0f ? f2 : f5)) >= (-f49)) {
                            if ((f52 * (f52 < 0.0f ? f4 : f7)) + (f51 * (f51 < 0.0f ? f3 : f6)) + (f50 * (f50 < 0.0f ? f2 : f5)) >= (-f53)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testPoint(float f2, float f3, float f4) {
        float f5 = f4;
        float f6 = this.m03;
        float f7 = this.m00;
        float f8 = f6 + f7;
        float f9 = this.m13;
        float f10 = this.m10;
        float f11 = f9 + f10;
        float f12 = this.m23;
        float f13 = this.m20;
        float f14 = f12 + f13;
        float f15 = this.m33;
        float f16 = this.m30;
        float f17 = f15 + f16;
        float f18 = f6 - f7;
        float f19 = f9 - f10;
        float f20 = f12 - f13;
        float f21 = f15 - f16;
        float f22 = this.m01;
        float f23 = f6 + f22;
        float f24 = this.m11;
        float f25 = f9 + f24;
        float f26 = f20;
        float f27 = this.m21;
        float f28 = f21;
        float f29 = f12 + f27;
        float f30 = this.m31;
        float f31 = f19;
        float f32 = f15 + f30;
        float f33 = f6 - f22;
        float f34 = f9 - f24;
        float f35 = f15 - f30;
        float f36 = f12 - f27;
        float f37 = this.m02;
        float f38 = f6 + f37;
        float f39 = f35;
        float f40 = this.m12;
        float f41 = f9 + f40;
        float f42 = f34;
        float f43 = this.m22;
        float f44 = f33;
        float f45 = f12 + f43;
        float f46 = this.m32;
        float f47 = f15 + f46;
        float f48 = f6 - f37;
        float f49 = f9 - f40;
        float f50 = f12 - f43;
        float f51 = f15 - f46;
        if (a.f(f14, f5, (f11 * f3) + (f8 * f2), f17) >= 0.0f) {
            if (a.f(f26, f5, (f31 * f3) + (f18 * f2), f28) >= 0.0f) {
                if (a.f(f29, f5, (f25 * f3) + (f23 * f2), f32) >= 0.0f) {
                    if (a.f(f36, f5, (f42 * f3) + (f44 * f2), f39) >= 0.0f) {
                        if (a.f(f45, f5, (f41 * f3) + (f38 * f2), f47) >= 0.0f) {
                            if (a.f(f50, f5, (f49 * f3) + (f48 * f2), f51) >= 0.0f) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean testSphere(float f2, float f3, float f4, float f5) {
        float f6 = f4;
        float f7 = this.m03 + this.m00;
        float f8 = this.m13 + this.m10;
        float f9 = this.m23 + this.m20;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f9 * f9) + ((f8 * f8) + (f7 * f7)))));
        float f10 = f7 * sqrt;
        float f11 = f8 * sqrt;
        float f12 = f9 * sqrt;
        float f13 = (this.m33 + this.m30) * sqrt;
        float f14 = this.m03 - this.m00;
        float f15 = this.m13 - this.m10;
        float f16 = this.m23 - this.m20;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f16 * f16) + ((f15 * f15) + (f14 * f14)))));
        float f17 = f14 * sqrt2;
        float f18 = f15 * sqrt2;
        float f19 = f16 * sqrt2;
        float f20 = (this.m33 - this.m30) * sqrt2;
        float f21 = this.m03 + this.m01;
        float f22 = this.m13 + this.m11;
        float f23 = this.m23 + this.m21;
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f23 * f23) + ((f22 * f22) + (f21 * f21)))));
        float f24 = f21 * sqrt3;
        float f25 = f22 * sqrt3;
        float f26 = f23 * sqrt3;
        float f27 = (this.m33 + this.m31) * sqrt3;
        float f28 = this.m03 - this.m01;
        float f29 = f26;
        float f30 = this.m13 - this.m11;
        float f31 = f27;
        float f32 = this.m23 - this.m21;
        float f33 = f25;
        float f34 = (f32 * f32) + (f30 * f30) + (f28 * f28);
        float f35 = f24;
        float sqrt4 = (float) (1.0d / Math.sqrt((double) f34));
        float f36 = f28 * sqrt4;
        float f37 = f30 * sqrt4;
        float f38 = f32 * sqrt4;
        float f39 = (this.m33 - this.m31) * sqrt4;
        float f40 = this.m03 + this.m02;
        float f41 = f38;
        float f42 = this.m13 + this.m12;
        float f43 = f39;
        float f44 = this.m23 + this.m22;
        float f45 = f37;
        float f46 = (f44 * f44) + (f42 * f42) + (f40 * f40);
        float f47 = f36;
        float sqrt5 = (float) (1.0d / Math.sqrt((double) f46));
        float f48 = f40 * sqrt5;
        float f49 = f42 * sqrt5;
        float f50 = f44 * sqrt5;
        float f51 = (this.m33 + this.m32) * sqrt5;
        float f52 = this.m03 - this.m02;
        float f53 = f50;
        float f54 = this.m13 - this.m12;
        float f55 = f51;
        float f56 = this.m23 - this.m22;
        float f57 = f49;
        float f58 = (f56 * f56) + (f54 * f54) + (f52 * f52);
        float f59 = f48;
        float sqrt6 = (float) (1.0d / Math.sqrt((double) f58));
        float f60 = f52 * sqrt6;
        float f61 = f54 * sqrt6;
        float f62 = f56 * sqrt6;
        float f63 = (this.m33 - this.m32) * sqrt6;
        float f64 = a.f(f12, f6, (f11 * f3) + (f10 * f2), f13);
        float f65 = -f5;
        if (f64 >= f65) {
            if (a.f(f19, f6, (f18 * f3) + (f17 * f2), f20) >= f65) {
                if (a.f(f29, f6, (f33 * f3) + (f35 * f2), f31) >= f65) {
                    if (a.f(f41, f6, (f45 * f3) + (f47 * f2), f43) >= f65) {
                        if (a.f(f53, f6, (f57 * f3) + (f59 * f2), f55) >= f65) {
                            if (a.f(f62, f6, (f61 * f3) + (f60 * f2), f63) >= f65) {
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
        String matrix4f = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix4f.length(); i3++) {
            char charAt = matrix4f.charAt(i3);
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

    public Vector4f transform(Vector4f vector4f) {
        return vector4f.mul((Matrix4fc) this);
    }

    public Matrix4f transformAab(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float f8 = this.m00;
        float f9 = f8 * f2;
        float f10 = this.m01;
        float f11 = f10 * f2;
        float f12 = this.m02;
        float f13 = f12 * f2;
        float f14 = f8 * f5;
        float f15 = f10 * f5;
        float f16 = f12 * f5;
        float f17 = this.m10;
        float f18 = f17 * f3;
        float f19 = this.m11;
        float f20 = f19 * f3;
        float f21 = this.m12;
        float f22 = f21 * f3;
        float f23 = f17 * f6;
        float f24 = f19 * f6;
        float f25 = f21 * f6;
        float f26 = this.m20;
        float f27 = f26 * f4;
        float f28 = this.m21;
        float f29 = f28 * f4;
        float f30 = this.m22;
        float f31 = f30 * f4;
        float f32 = f26 * f7;
        float f33 = f28 * f7;
        float f34 = f30 * f7;
        if (f9 >= f14) {
            float f35 = f9;
            f9 = f14;
            f14 = f35;
        }
        if (f11 >= f15) {
            float f36 = f11;
            f11 = f15;
            f15 = f36;
        }
        if (f13 >= f16) {
            float f37 = f13;
            f13 = f16;
            f16 = f37;
        }
        if (f18 >= f23) {
            float f38 = f18;
            f18 = f23;
            f23 = f38;
        }
        if (f20 >= f24) {
            float f39 = f20;
            f20 = f24;
            f24 = f39;
        }
        if (f22 >= f25) {
            float f40 = f22;
            f22 = f25;
            f25 = f40;
        }
        if (f27 >= f32) {
            float f41 = f27;
            f27 = f32;
            f32 = f41;
        }
        if (f29 >= f33) {
            float f42 = f29;
            f29 = f33;
            f33 = f42;
        }
        if (f31 >= f34) {
            float f43 = f31;
            f31 = f34;
            f34 = f43;
        }
        float f44 = f9 + f18 + f27;
        float f45 = this.m30;
        float f46 = f34;
        Vector3f vector3f5 = vector3f;
        vector3f5.x = f44 + f45;
        float f47 = f11 + f20 + f29;
        float f48 = this.m31;
        vector3f5.y = f47 + f48;
        float f49 = f13 + f22 + f31;
        float f50 = this.m32;
        vector3f5.z = f49 + f50;
        float a2 = a.a(f14, f23, f32, f45);
        Vector3f vector3f6 = vector3f2;
        vector3f6.x = a2;
        vector3f6.y = a.a(f15, f24, f33, f48);
        vector3f6.z = a.a(f16, f25, f46, f50);
        return this;
    }

    public Vector4f transformAffine(Vector4f vector4f) {
        return vector4f.mulAffine(this, vector4f);
    }

    public Vector3f transformDirection(Vector3f vector3f) {
        return transformDirection(vector3f.x, vector3f.y, vector3f.z, vector3f);
    }

    public Vector3f transformPosition(Vector3f vector3f) {
        return vector3f.mulPosition((Matrix4fc) this);
    }

    public Vector4f transformProject(Vector4f vector4f) {
        return vector4f.mulProject(this);
    }

    public Matrix4f translate(Vector3fc vector3fc) {
        return translate(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f translateLocal(Vector3fc vector3fc) {
        return translateLocal(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f translation(float f2, float f3, float f4) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m30(f2);
        _m31(f3);
        _m32(f4);
        _properties(26);
        return this;
    }

    public Matrix4f translationRotate(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f8 * f8;
        float f10 = f5 * f5;
        float f11 = f6 * f6;
        float f12 = f7 * f7;
        float f13 = f7 * f8;
        float f14 = f5 * f6;
        float f15 = f5 * f7;
        float f16 = f6 * f8;
        float f17 = f6 * f7;
        float f18 = f5 * f8;
        _m00(((f9 + f10) - f12) - f11);
        _m01(f14 + f13 + f13 + f14);
        _m02(((f15 - f16) + f15) - f16);
        _m10((((-f13) + f14) - f13) + f14);
        _m11(((f11 - f12) + f9) - f10);
        float f19 = f17 + f17;
        _m12(f19 + f18 + f18);
        _m20(f16 + f15 + f15 + f16);
        _m21((f19 - f18) - f18);
        _m22(((f12 - f11) - f10) + f9);
        _m30(f2);
        _m31(f3);
        _m32(f4);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f translationRotateScale(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = f5 + f5;
        float f13 = f6 + f6;
        float f14 = f7 + f7;
        float f15 = f12 * f5;
        float f16 = f13 * f6;
        float f17 = f14 * f7;
        float f18 = f12 * f6;
        float f19 = f12 * f7;
        float f20 = f12 * f8;
        float f21 = f13 * f7;
        float f22 = f13 * f8;
        float f23 = f14 * f8;
        _m00(f9 - ((f16 + f17) * f9));
        _m01((f18 + f23) * f9);
        _m02((f19 - f22) * f9);
        _m03(0.0f);
        _m10((f18 - f23) * f10);
        _m11(f10 - ((f17 + f15) * f10));
        _m12((f21 + f20) * f10);
        _m13(0.0f);
        _m20((f19 + f22) * f11);
        _m21((f21 - f20) * f11);
        _m22(f11 - ((f16 + f15) * f11));
        _m23(0.0f);
        _m30(f2);
        float f24 = f3;
        _m31(f3);
        float f25 = f4;
        _m32(f4);
        _m33(1.0f);
        int i2 = 0;
        if (Math.abs(f9) == 1.0f && Math.abs(f10) == 1.0f && Math.abs(f11) == 1.0f) {
            i2 = 16;
        }
        _properties(i2 | 2);
        return this;
    }

    public Matrix4f translationRotateScaleInvert(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        if (Math.abs(f9) == 1.0f && Math.abs(f10) == 1.0f && Math.abs(f11) == 1.0f) {
            return translationRotateScale(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11).invertOrthonormal(this);
        }
        float f12 = -f5;
        float f13 = -f6;
        float f14 = -f7;
        float f15 = f12 + f12;
        float f16 = f13 + f13;
        float f17 = f14 + f14;
        float f18 = f12 * f15;
        float f19 = f16 * f13;
        float f20 = f17 * f14;
        float f21 = f13 * f15;
        float f22 = f15 * f14;
        float f23 = f15 * f8;
        float f24 = f14 * f16;
        float f25 = f16 * f8;
        float f26 = f17 * f8;
        float f27 = 1.0f / f9;
        float f28 = 1.0f / f10;
        float f29 = 1.0f / f11;
        float f30 = 1.0f - f19;
        _m00((f30 - f20) * f27);
        _m01((f21 + f26) * f28);
        _m02((f22 - f25) * f29);
        _m03(0.0f);
        _m10((f21 - f26) * f27);
        _m11(((1.0f - f20) - f18) * f28);
        _m12((f24 + f23) * f29);
        _m13(0.0f);
        _m20((f22 + f25) * f27);
        _m21((f24 - f23) * f28);
        _m22((f30 - f18) * f29);
        _m23(0.0f);
        _m30((((-this.m00) * f2) - (this.m10 * f3)) - (this.m20 * f4));
        _m31((((-this.m01) * f2) - (this.m11 * f3)) - (this.m21 * f4));
        _m32((((-this.m02) * f2) - (this.m12 * f3)) - (this.m22 * f4));
        _m33(1.0f);
        _properties(2);
        return this;
    }

    public Matrix4f translationRotateScaleMulAffine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f12 = f8 * f8;
        float f13 = f5 * f5;
        float f14 = f6 * f6;
        float f15 = f7 * f7;
        float f16 = f7 * f8;
        float f17 = f5 * f6;
        float f18 = f5 * f7;
        float f19 = f6 * f8;
        float f20 = f6 * f7;
        float f21 = f5 * f8;
        float b2 = a.b(f12, f13, f15, f14);
        float a2 = a.a(f17, f16, f16, f17);
        float c2 = a.c(f18, f19, f18, f19);
        float f22 = (((-f16) + f17) - f16) + f17;
        float c3 = a.c(f14, f15, f12, f13);
        float f23 = f20 + f20;
        float f24 = f23 + f21 + f21;
        float a3 = a.a(f19, f18, f18, f19);
        float f25 = (f23 - f21) - f21;
        float d2 = a.d(f15, f14, f13, f12);
        float f26 = matrix4f2.m00;
        float f27 = b2 * f26;
        float f28 = matrix4f2.m01;
        float f29 = (f22 * f28) + f27;
        float f30 = matrix4f2.m02;
        float f31 = (a3 * f30) + f29;
        float f32 = (f25 * f30) + (c3 * f28) + (a2 * f26);
        _m02((f30 * d2) + (f28 * f24) + (f26 * c2));
        _m00(f31);
        _m01(f32);
        _m03(0.0f);
        float f33 = matrix4f2.m10;
        float f34 = b2 * f33;
        float f35 = matrix4f2.m11;
        float f36 = (f22 * f35) + f34;
        float f37 = matrix4f2.m12;
        float f38 = (a3 * f37) + f36;
        float f39 = (f25 * f37) + (c3 * f35) + (a2 * f33);
        _m12((f37 * d2) + (f35 * f24) + (f33 * c2));
        _m10(f38);
        _m11(f39);
        _m13(0.0f);
        float f40 = matrix4f2.m20;
        float f41 = b2 * f40;
        float f42 = matrix4f2.m21;
        float f43 = (f22 * f42) + f41;
        float f44 = matrix4f2.m22;
        float f45 = (a3 * f44) + f43;
        float f46 = (f25 * f44) + (c3 * f42) + (a2 * f40);
        _m22((f44 * d2) + (f42 * f24) + (f40 * c2));
        _m20(f45);
        _m21(f46);
        _m23(0.0f);
        float f47 = matrix4f2.m30;
        float f48 = b2 * f47;
        float f49 = matrix4f2.m31;
        float f50 = (f22 * f49) + f48;
        float f51 = matrix4f2.m32;
        float f52 = a.f(a3, f51, f50, f2);
        float f53 = a.f(f25, f51, (c3 * f49) + (a2 * f47), f3);
        _m32((d2 * f51) + (f24 * f49) + (c2 * f47) + f4);
        _m30(f52);
        _m31(f53);
        _m33(1.0f);
        int i2 = 0;
        if ((Math.abs(f9) == 1.0f && Math.abs(f10) == 1.0f && Math.abs(f11) == 1.0f) && (matrix4f2.properties & 16) != 0) {
            i2 = 16;
        }
        _properties(2 | i2);
        return this;
    }

    public Matrix4f translationRotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return translationRotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4f transpose(Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.identity();
        }
        return transposeGeneric(matrix4f);
    }

    public Matrix4f transpose3x3() {
        return transpose3x3(thisOrNew());
    }

    public Matrix4f trapezoidCrop(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f5;
        float f11 = f9;
        float f12 = f10 - f3;
        float f13 = f2 - f4;
        float f14 = -f12;
        float f15 = (f12 * f3) - (f13 * f2);
        float f16 = -((f13 * f3) + (f12 * f2));
        float f17 = a.f(f14, f11, f13 * f8, f15);
        float f18 = a.f(f13, f11, f12 * f8, f16);
        float f19 = (-f17) / f18;
        float f20 = (f19 * f12) + f13;
        float f21 = (f19 * f13) + f14;
        float f22 = (f19 * f16) + f15;
        float f23 = a.f(f21, f10, f20 * f4, f22);
        float f24 = a.f(f21, f7, f20 * f6, f22);
        float f25 = (f23 * f18) / (f24 - f23);
        float f26 = 2.0f / f24;
        float f27 = 1.0f / (f18 + f25);
        float f28 = ((f27 + f27) * f25) / (1.0f - (f25 * f27));
        float f29 = f12 * f27;
        float f30 = f13 * f27;
        float f31 = (f16 + f25) * f27;
        float f32 = 1.0f + f28;
        float f33 = f32 * f29;
        float f34 = f32 * f30;
        float f35 = (f32 * f31) - f28;
        set((f20 * f26) - f29, f33, 0.0f, f29, (f21 * f26) - f30, f34, 0.0f, f30, 0.0f, 0.0f, 1.0f, 0.0f, (f26 * f22) - f31, f35, 0.0f, f31);
        _properties(0);
        return this;
    }

    public Vector4f unproject(float f2, float f3, float f4, int[] iArr, Vector4f vector4f) {
        Vector4f vector4f2 = vector4f;
        float f5 = this.m00;
        float f6 = this.m11;
        float f7 = f5 * f6;
        float f8 = this.m01;
        float f9 = this.m10;
        float f10 = f7 - (f8 * f9);
        float f11 = this.m12;
        float f12 = f5 * f11;
        float f13 = this.m02;
        float f14 = f12 - (f13 * f9);
        float f15 = this.m13;
        float f16 = f5 * f15;
        float f17 = this.m03;
        float f18 = f16 - (f17 * f9);
        float f19 = (f8 * f11) - (f13 * f6);
        float f20 = (f8 * f15) - (f17 * f6);
        float f21 = (f13 * f15) - (f17 * f11);
        float f22 = this.m20;
        float f23 = f5;
        float f24 = this.m31;
        float f25 = f22 * f24;
        float f26 = f9;
        float f27 = this.m21;
        float f28 = f17;
        float f29 = this.m30;
        float f30 = f13;
        float f31 = f25 - (f27 * f29);
        float f32 = f8;
        float f33 = this.m32;
        float f34 = f22 * f33;
        float f35 = f15;
        float f36 = this.m22;
        float f37 = f11;
        float f38 = f34 - (f36 * f29);
        float f39 = f6;
        float f40 = this.m33;
        float f41 = f22 * f40;
        float f42 = f22;
        float f43 = this.m23;
        float f44 = f41 - (f43 * f29);
        float f45 = (f27 * f33) - (f36 * f24);
        float f46 = (f27 * f40) - (f43 * f24);
        float f47 = (f36 * f40) - (f43 * f33);
        float f48 = f10;
        float f49 = f14;
        float h2 = a.h(f21, f31, ((f19 * f44) + ((f18 * f45) + ((f10 * f47) - (f14 * f46)))) - (f20 * f38), 1.0f);
        float f50 = f31;
        float f51 = f35;
        float g2 = a.g(f51, f45, (f39 * f47) - (f37 * f46), h2);
        float f52 = f32;
        float f53 = f18;
        float f54 = (f30 * f46) + ((-f52) * f47);
        float f55 = f52;
        float f56 = f28;
        float i2 = a.i(f56, f45, f54, h2);
        float g3 = a.g(f40, f19, (f24 * f21) - (f33 * f20), h2);
        float i3 = a.i(f43, f19, (f36 * f20) + ((-f27) * f21), h2);
        float f57 = f26;
        float f58 = f19;
        float i4 = a.i(f51, f38, (f37 * f44) + ((-f57) * f47), h2);
        float g4 = a.g(f56, f38, (f47 * f23) - (f30 * f44), h2);
        float f59 = (f33 * f53) + ((-f29) * f21);
        float f60 = f33;
        float f61 = f49;
        float i5 = a.i(f40, f61, f59, h2);
        float f62 = (f57 * f46) - (f39 * f44);
        float g5 = a.g(f43, f61, (f21 * f42) - (f36 * f53), h2);
        float f63 = f50;
        float g6 = a.g(f51, f63, f62, h2);
        float f64 = f23;
        float f65 = g6;
        float i6 = a.i(f56, f63, (f44 * f55) + ((-f64) * f46), h2);
        float f66 = f48;
        float g7 = a.g(f40, f66, (f29 * f20) - (f24 * f53), h2);
        float f67 = f42;
        float f68 = g7;
        float i7 = a.i(f43, f66, (f53 * f27) + ((-f67) * f20), h2);
        float i8 = a.i(f37, f63, (f39 * f38) + ((-f57) * f45), h2);
        float g8 = a.g(f30, f63, (f45 * f64) - (f38 * f55), h2);
        float i9 = a.i(f60, f66, (f24 * f61) + ((-f29) * f58), h2);
        float g9 = a.g(f36, f66, (f67 * f58) - (f27 * f61), h2);
        float f69 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f70 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f71 = (f4 + f4) - 1.0f;
        float f72 = i7 * f71;
        float f73 = 1.0f / ((f72 + ((g5 * f70) + (i3 * f69))) + g9);
        float f74 = f65 * f71;
        Vector4f vector4f3 = vector4f;
        vector4f3.x = (f74 + (i4 * f70) + (g2 * f69) + i8) * f73;
        float f75 = i6 * f71;
        vector4f3.y = (f75 + (g4 * f70) + (i2 * f69) + g8) * f73;
        float f76 = f68 * f71;
        vector4f3.z = (f76 + (i5 * f70) + (g3 * f69) + i9) * f73;
        vector4f3.w = 1.0f;
        return vector4f3;
    }

    public Vector4f unprojectInv(Vector3fc vector3fc, int[] iArr, Vector4f vector4f) {
        return unprojectInv(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector4f);
    }

    public Matrix4f unprojectInvRay(Vector2fc vector2fc, int[] iArr, Vector3f vector3f, Vector3f vector3f2) {
        return unprojectInvRay(vector2fc.x(), vector2fc.y(), iArr, vector3f, vector3f2);
    }

    public Matrix4f unprojectRay(float f2, float f3, int[] iArr, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float f4 = this.m00;
        float f5 = this.m11;
        float f6 = f4 * f5;
        float f7 = this.m01;
        float f8 = this.m10;
        float f9 = f6 - (f7 * f8);
        float f10 = this.m12;
        float f11 = f4 * f10;
        float f12 = this.m02;
        float f13 = f11 - (f12 * f8);
        float f14 = this.m13;
        float f15 = f4 * f14;
        float f16 = this.m03;
        float f17 = f15 - (f16 * f8);
        float f18 = (f7 * f10) - (f12 * f5);
        float f19 = (f7 * f14) - (f16 * f5);
        float f20 = (f12 * f14) - (f16 * f10);
        float f21 = this.m20;
        float f22 = f4;
        float f23 = this.m31;
        float f24 = f21 * f23;
        float f25 = f8;
        float f26 = this.m21;
        float f27 = f16;
        float f28 = this.m30;
        float f29 = f12;
        float f30 = f24 - (f26 * f28);
        float f31 = f7;
        float f32 = this.m32;
        float f33 = f21 * f32;
        float f34 = f14;
        float f35 = this.m22;
        float f36 = f10;
        float f37 = f33 - (f35 * f28);
        float f38 = f5;
        float f39 = this.m33;
        float f40 = f21 * f39;
        float f41 = f21;
        float f42 = this.m23;
        float f43 = f40 - (f42 * f28);
        float f44 = (f26 * f32) - (f35 * f23);
        float f45 = (f26 * f39) - (f42 * f23);
        float f46 = (f35 * f39) - (f42 * f32);
        float f47 = f9;
        float f48 = f13;
        float h2 = a.h(f20, f30, ((f18 * f43) + ((f17 * f44) + ((f9 * f46) - (f13 * f45)))) - (f19 * f37), 1.0f);
        float f49 = f30;
        float f50 = f34;
        float g2 = a.g(f50, f44, (f38 * f46) - (f36 * f45), h2);
        float f51 = f31;
        float f52 = f17;
        float f53 = (f29 * f45) + ((-f51) * f46);
        float f54 = f51;
        float f55 = f27;
        float i2 = a.i(f55, f44, f53, h2);
        float g3 = a.g(f39, f18, (f23 * f20) - (f32 * f19), h2);
        float i3 = a.i(f42, f18, (f35 * f19) + ((-f26) * f20), h2);
        float f56 = f25;
        float f57 = f18;
        float i4 = a.i(f50, f37, (f36 * f43) + ((-f56) * f46), h2);
        float g4 = a.g(f55, f37, (f46 * f22) - (f29 * f43), h2);
        float f58 = (f32 * f52) + ((-f28) * f20);
        float f59 = f32;
        float f60 = f48;
        float i5 = a.i(f39, f60, f58, h2);
        float g5 = a.g(f42, f60, (f20 * f41) - (f35 * f52), h2);
        float f61 = i5;
        float f62 = f49;
        float g6 = a.g(f50, f62, (f56 * f45) - (f38 * f43), h2);
        float f63 = f22;
        float f64 = g6;
        float i6 = a.i(f55, f62, (f43 * f54) + ((-f63) * f45), h2);
        float f65 = i6;
        float f66 = f47;
        float g7 = a.g(f39, f66, (f28 * f19) - (f23 * f52), h2);
        float f67 = f41;
        float f68 = g7;
        float i7 = a.i(f42, f66, (f52 * f26) + ((-f67) * f19), h2);
        float i8 = a.i(f36, f62, (f38 * f37) + ((-f56) * f44), h2);
        float g8 = a.g(f29, f62, (f44 * f63) - (f37 * f54), h2);
        float i9 = a.i(f59, f66, (f23 * f60) + ((-f28) * f57), h2);
        float g9 = a.g(f35, f66, (f67 * f57) - (f26 * f60), h2);
        float f69 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f70 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f71 = a.f(i4, f70, g2 * f69, i8);
        float f72 = a.f(g4, f70, i2 * f69, g8);
        float f73 = a.f(f61, f70, g3 * f69, i9);
        float f74 = (g5 * f70) + (i3 * f69);
        float f75 = 1.0f / ((f74 - i7) + g9);
        float f76 = (f71 - f64) * f75;
        float f77 = (f72 - f65) * f75;
        float f78 = (f73 - f68) * f75;
        float f79 = 1.0f / ((f74 + i7) + g9);
        float f80 = (f71 + f64) * f79;
        float f81 = (f72 + f65) * f79;
        float f82 = (f73 + f68) * f79;
        Vector3f vector3f5 = vector3f;
        vector3f5.x = f76;
        vector3f5.y = f77;
        vector3f5.z = f78;
        Vector3f vector3f6 = vector3f2;
        vector3f6.x = f80 - f76;
        vector3f6.y = f81 - f77;
        vector3f6.z = f82 - f78;
        return this;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.m00);
        objectOutput.writeFloat(this.m01);
        objectOutput.writeFloat(this.m02);
        objectOutput.writeFloat(this.m03);
        objectOutput.writeFloat(this.m10);
        objectOutput.writeFloat(this.m11);
        objectOutput.writeFloat(this.m12);
        objectOutput.writeFloat(this.m13);
        objectOutput.writeFloat(this.m20);
        objectOutput.writeFloat(this.m21);
        objectOutput.writeFloat(this.m22);
        objectOutput.writeFloat(this.m23);
        objectOutput.writeFloat(this.m30);
        objectOutput.writeFloat(this.m31);
        objectOutput.writeFloat(this.m32);
        objectOutput.writeFloat(this.m33);
    }

    public Matrix4f zero() {
        Matrix4f thisOrNew = thisOrNew();
        MemUtil.INSTANCE.zero(thisOrNew);
        _properties(0);
        return thisOrNew;
    }

    public Matrix4f add(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(matrix4fc.m00() + this.m00);
        matrix4f._m01(matrix4fc.m01() + this.m01);
        matrix4f._m02(matrix4fc.m02() + this.m02);
        matrix4f._m03(matrix4fc.m03() + this.m03);
        matrix4f._m10(matrix4fc.m10() + this.m10);
        matrix4f._m11(matrix4fc.m11() + this.m11);
        matrix4f._m12(matrix4fc.m12() + this.m12);
        matrix4f._m13(matrix4fc.m13() + this.m13);
        matrix4f._m20(matrix4fc.m20() + this.m20);
        matrix4f._m21(matrix4fc.m21() + this.m21);
        matrix4f._m22(matrix4fc.m22() + this.m22);
        matrix4f._m23(matrix4fc.m23() + this.m23);
        matrix4f._m30(matrix4fc.m30() + this.m30);
        matrix4f._m31(matrix4fc.m31() + this.m31);
        matrix4f._m32(matrix4fc.m32() + this.m32);
        matrix4f._m33(matrix4fc.m33() + this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4f add4x3(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(matrix4fc.m00() + this.m00);
        matrix4f._m01(matrix4fc.m01() + this.m01);
        matrix4f._m02(matrix4fc.m02() + this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m10(matrix4fc.m10() + this.m10);
        matrix4f._m11(matrix4fc.m11() + this.m11);
        matrix4f._m12(matrix4fc.m12() + this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m20(matrix4fc.m20() + this.m20);
        matrix4f._m21(matrix4fc.m21() + this.m21);
        matrix4f._m22(matrix4fc.m22() + this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30(matrix4fc.m30() + this.m30);
        matrix4f._m31(matrix4fc.m31() + this.m31);
        matrix4f._m32(matrix4fc.m32() + this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4f fma4x3(Matrix4fc matrix4fc, float f2, Matrix4f matrix4f) {
        matrix4f._m00((matrix4fc.m00() * f2) + this.m00);
        matrix4f._m01((matrix4fc.m01() * f2) + this.m01);
        matrix4f._m02((matrix4fc.m02() * f2) + this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m10((matrix4fc.m10() * f2) + this.m10);
        matrix4f._m11((matrix4fc.m11() * f2) + this.m11);
        matrix4f._m12((matrix4fc.m12() * f2) + this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m20((matrix4fc.m20() * f2) + this.m20);
        matrix4f._m21((matrix4fc.m21() * f2) + this.m21);
        matrix4f._m22((matrix4fc.m22() * f2) + this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30((matrix4fc.m30() * f2) + this.m30);
        matrix4f._m31((matrix4fc.m31() * f2) + this.m31);
        matrix4f._m32((matrix4fc.m32() * f2) + this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set((Matrix4fc) this);
    }

    public Matrix3d get3x3(Matrix3d matrix3d) {
        return matrix3d.set((Matrix4fc) this);
    }

    public FloatBuffer get4x3(FloatBuffer floatBuffer) {
        return get4x3(floatBuffer.position(), floatBuffer);
    }

    public FloatBuffer get4x3Transposed(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix4fc) this);
    }

    public AxisAngle4d getRotation(AxisAngle4d axisAngle4d) {
        return axisAngle4d.set((Matrix4fc) this);
    }

    public FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix4fc) this);
    }

    public Matrix4f lerp(Matrix4fc matrix4fc, float f2, Matrix4f matrix4f) {
        matrix4f._m00(((matrix4fc.m00() - this.m00) * f2) + this.m00);
        matrix4f._m01(((matrix4fc.m01() - this.m01) * f2) + this.m01);
        matrix4f._m02(((matrix4fc.m02() - this.m02) * f2) + this.m02);
        matrix4f._m03(((matrix4fc.m03() - this.m03) * f2) + this.m03);
        matrix4f._m10(((matrix4fc.m10() - this.m10) * f2) + this.m10);
        matrix4f._m11(((matrix4fc.m11() - this.m11) * f2) + this.m11);
        matrix4f._m12(((matrix4fc.m12() - this.m12) * f2) + this.m12);
        matrix4f._m13(((matrix4fc.m13() - this.m13) * f2) + this.m13);
        matrix4f._m20(((matrix4fc.m20() - this.m20) * f2) + this.m20);
        matrix4f._m21(((matrix4fc.m21() - this.m21) * f2) + this.m21);
        matrix4f._m22(((matrix4fc.m22() - this.m22) * f2) + this.m22);
        matrix4f._m23(((matrix4fc.m23() - this.m23) * f2) + this.m23);
        matrix4f._m30(((matrix4fc.m30() - this.m30) * f2) + this.m30);
        matrix4f._m31(((matrix4fc.m31() - this.m31) * f2) + this.m31);
        matrix4f._m32(((matrix4fc.m32() - this.m32) * f2) + this.m32);
        matrix4f._m33(((matrix4fc.m33() - this.m33) * f2) + this.m33);
        matrix4f.properties = matrix4fc.properties() & this.properties;
        return matrix4f;
    }

    public Matrix4f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4f);
    }

    public Matrix4f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return lookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), thisOrNew());
    }

    public Matrix4f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return lookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), thisOrNew());
    }

    public Matrix4f m00(float f2) {
        this.m00 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4f m01(float f2) {
        this.m01 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m02(float f2) {
        this.m02 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m03(float f2) {
        this.m03 = f2;
        if (f2 != 0.0f) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4f m10(float f2) {
        this.m10 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m11(float f2) {
        this.m11 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4f m12(float f2) {
        this.m12 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m13(float f2) {
        this.m13 = f2;
        if (f2 != 0.0f) {
            this.properties = 0;
        }
        return this;
    }

    public Matrix4f m20(float f2) {
        this.m20 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m21(float f2) {
        this.m21 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -14;
        }
        return this;
    }

    public Matrix4f m22(float f2) {
        this.m22 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4f m23(float f2) {
        this.m23 = f2;
        if (f2 != 0.0f) {
            this.properties &= -31;
        }
        return this;
    }

    public Matrix4f m30(float f2) {
        this.m30 = f2;
        if (f2 != 0.0f) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4f m31(float f2) {
        this.m31 = f2;
        if (f2 != 0.0f) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4f m32(float f2) {
        this.m32 = f2;
        if (f2 != 0.0f) {
            this.properties &= -6;
        }
        return this;
    }

    public Matrix4f m33(float f2) {
        this.m33 = f2;
        if (f2 != 0.0f) {
            this.properties &= -2;
        }
        if (f2 != 1.0f) {
            this.properties &= -31;
        }
        return this;
    }

    public Matrix4f mul(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.set(matrix4fc);
        }
        if ((matrix4fc.properties() & 4) != 0) {
            return matrix4f.set((Matrix4fc) this);
        }
        if ((this.properties & 8) != 0 && (matrix4fc.properties() & 2) != 0) {
            return mulTranslationAffine(matrix4fc, matrix4f);
        }
        if ((this.properties & 2) != 0 && (matrix4fc.properties() & 2) != 0) {
            return mulAffine(matrix4fc, matrix4f);
        }
        if ((this.properties & 1) != 0 && (matrix4fc.properties() & 2) != 0) {
            return mulPerspectiveAffine(matrix4fc, matrix4f);
        }
        if ((matrix4fc.properties() & 2) != 0) {
            return mulAffineR(matrix4fc, matrix4f);
        }
        return mulGeneric(matrix4fc, matrix4f);
    }

    public Matrix4f mul4x3ComponentWise(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(matrix4fc.m00() * this.m00);
        matrix4f._m01(matrix4fc.m01() * this.m01);
        matrix4f._m02(matrix4fc.m02() * this.m02);
        matrix4f._m03(this.m03);
        matrix4f._m10(matrix4fc.m10() * this.m10);
        matrix4f._m11(matrix4fc.m11() * this.m11);
        matrix4f._m12(matrix4fc.m12() * this.m12);
        matrix4f._m13(this.m13);
        matrix4f._m20(matrix4fc.m20() * this.m20);
        matrix4f._m21(matrix4fc.m21() * this.m21);
        matrix4f._m22(matrix4fc.m22() * this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30(matrix4fc.m30() * this.m30);
        matrix4f._m31(matrix4fc.m31() * this.m31);
        matrix4f._m32(matrix4fc.m32() * this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4f mulAffine(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m022 = (matrix4fc.m02() * this.m20) + (matrix4fc.m01() * this.m10) + (matrix4fc.m00() * this.m00);
        float m023 = (matrix4fc.m02() * this.m21) + (matrix4fc.m01() * this.m11) + (matrix4fc.m00() * this.m01);
        float m024 = (matrix4fc.m02() * this.m22) + (matrix4fc.m01() * this.m12) + (matrix4fc.m00() * this.m02);
        float f2 = this.m03;
        float m122 = (matrix4fc.m12() * this.m20) + (matrix4fc.m11() * this.m10) + (matrix4fc.m10() * this.m00);
        float m123 = (matrix4fc.m12() * this.m21) + (matrix4fc.m11() * this.m11) + (matrix4fc.m10() * this.m01);
        float m124 = (matrix4fc.m12() * this.m22) + (matrix4fc.m11() * this.m12) + (matrix4fc.m10() * this.m02);
        float f3 = this.m13;
        float m222 = (matrix4fc.m22() * this.m20) + (matrix4fc.m21() * this.m10) + (matrix4fc.m20() * this.m00);
        float m223 = (matrix4fc.m22() * this.m21) + (matrix4fc.m21() * this.m11) + (matrix4fc.m20() * this.m01);
        float m224 = (matrix4fc.m22() * this.m22) + (matrix4fc.m21() * this.m12) + (matrix4fc.m20() * this.m02);
        float f4 = this.m23;
        float m322 = (matrix4fc.m32() * this.m20) + (matrix4fc.m31() * this.m10) + (matrix4fc.m30() * this.m00) + this.m30;
        float m323 = (matrix4fc.m32() * this.m21) + (matrix4fc.m31() * this.m11) + (matrix4fc.m30() * this.m01) + this.m31;
        float m324 = (matrix4fc.m32() * this.m22) + (matrix4fc.m31() * this.m12) + (matrix4fc.m30() * this.m02) + this.m32;
        float f5 = this.m33;
        matrix4f2._m00(m022);
        matrix4f2._m01(m023);
        matrix4f2._m02(m024);
        matrix4f2._m03(f2);
        a.a(matrix4f2, m122, m123, m124, f3);
        a.b(matrix4f2, m222, m223, m224, f4);
        a.c(matrix4f2, m322, m323, m324, f5);
        matrix4f2._properties((this.properties & matrix4fc.properties() & 16) | 2);
        return matrix4f2;
    }

    public Matrix4f mulAffineR(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m022 = (matrix4fc.m02() * this.m20) + (matrix4fc.m01() * this.m10) + (matrix4fc.m00() * this.m00);
        float m023 = (matrix4fc.m02() * this.m21) + (matrix4fc.m01() * this.m11) + (matrix4fc.m00() * this.m01);
        float m024 = (matrix4fc.m02() * this.m22) + (matrix4fc.m01() * this.m12) + (matrix4fc.m00() * this.m02);
        float m025 = (matrix4fc.m02() * this.m23) + (matrix4fc.m01() * this.m13) + (matrix4fc.m00() * this.m03);
        float m122 = (matrix4fc.m12() * this.m20) + (matrix4fc.m11() * this.m10) + (matrix4fc.m10() * this.m00);
        float m123 = (matrix4fc.m12() * this.m21) + (matrix4fc.m11() * this.m11) + (matrix4fc.m10() * this.m01);
        float m124 = (matrix4fc.m12() * this.m22) + (matrix4fc.m11() * this.m12) + (matrix4fc.m10() * this.m02);
        float m125 = (matrix4fc.m12() * this.m23) + (matrix4fc.m11() * this.m13) + (matrix4fc.m10() * this.m03);
        float m222 = (matrix4fc.m22() * this.m20) + (matrix4fc.m21() * this.m10) + (matrix4fc.m20() * this.m00);
        float m223 = (matrix4fc.m22() * this.m21) + (matrix4fc.m21() * this.m11) + (matrix4fc.m20() * this.m01);
        float m224 = (matrix4fc.m22() * this.m22) + (matrix4fc.m21() * this.m12) + (matrix4fc.m20() * this.m02);
        float m225 = (matrix4fc.m22() * this.m23) + (matrix4fc.m21() * this.m13) + (matrix4fc.m20() * this.m03);
        float m322 = (matrix4fc.m32() * this.m20) + (matrix4fc.m31() * this.m10) + (matrix4fc.m30() * this.m00) + this.m30;
        float m323 = (matrix4fc.m32() * this.m21) + (matrix4fc.m31() * this.m11) + (matrix4fc.m30() * this.m01) + this.m31;
        float m324 = (matrix4fc.m32() * this.m22) + (matrix4fc.m31() * this.m12) + (matrix4fc.m30() * this.m02) + this.m32;
        float m325 = (matrix4fc.m32() * this.m23) + (matrix4fc.m31() * this.m13) + (matrix4fc.m30() * this.m03) + this.m33;
        matrix4f2._m00(m022);
        matrix4f2._m01(m023);
        matrix4f2._m02(m024);
        matrix4f2._m03(m025);
        a.a(matrix4f2, m122, m123, m124, m125);
        a.b(matrix4f2, m222, m223, m224, m225);
        a.c(matrix4f2, m322, m323, m324, m325);
        matrix4f2._properties(this.properties & -30);
        return matrix4f2;
    }

    public Matrix4f mulComponentWise(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(matrix4fc.m00() * this.m00);
        matrix4f._m01(matrix4fc.m01() * this.m01);
        matrix4f._m02(matrix4fc.m02() * this.m02);
        matrix4f._m03(matrix4fc.m03() * this.m03);
        matrix4f._m10(matrix4fc.m10() * this.m10);
        matrix4f._m11(matrix4fc.m11() * this.m11);
        matrix4f._m12(matrix4fc.m12() * this.m12);
        matrix4f._m13(matrix4fc.m13() * this.m13);
        matrix4f._m20(matrix4fc.m20() * this.m20);
        matrix4f._m21(matrix4fc.m21() * this.m21);
        matrix4f._m22(matrix4fc.m22() * this.m22);
        matrix4f._m23(matrix4fc.m23() * this.m23);
        matrix4f._m30(matrix4fc.m30() * this.m30);
        matrix4f._m31(matrix4fc.m31() * this.m31);
        matrix4f._m32(matrix4fc.m32() * this.m32);
        matrix4f._m33(matrix4fc.m33() * this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4f mulLocal(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.set(matrix4fc);
        }
        if ((matrix4fc.properties() & 4) != 0) {
            return matrix4f.set((Matrix4fc) this);
        }
        if ((this.properties & 2) == 0 || (matrix4fc.properties() & 2) == 0) {
            return mulLocalGeneric(matrix4fc, matrix4f);
        }
        return mulLocalAffine(matrix4fc, matrix4f);
    }

    public Matrix4f mulLocalAffine(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m202 = (matrix4fc.m20() * this.m02) + (matrix4fc.m10() * this.m01) + (matrix4fc.m00() * this.m00);
        float m212 = (matrix4fc.m21() * this.m02) + (matrix4fc.m11() * this.m01) + (matrix4fc.m01() * this.m00);
        float m222 = (matrix4fc.m22() * this.m02) + (matrix4fc.m12() * this.m01) + (matrix4fc.m02() * this.m00);
        float m032 = matrix4fc.m03();
        float m203 = (matrix4fc.m20() * this.m12) + (matrix4fc.m10() * this.m11) + (matrix4fc.m00() * this.m10);
        float m213 = (matrix4fc.m21() * this.m12) + (matrix4fc.m11() * this.m11) + (matrix4fc.m01() * this.m10);
        float m223 = (matrix4fc.m22() * this.m12) + (matrix4fc.m12() * this.m11) + (matrix4fc.m02() * this.m10);
        float m132 = matrix4fc.m13();
        float m204 = (matrix4fc.m20() * this.m22) + (matrix4fc.m10() * this.m21) + (matrix4fc.m00() * this.m20);
        float m214 = (matrix4fc.m21() * this.m22) + (matrix4fc.m11() * this.m21) + (matrix4fc.m01() * this.m20);
        float m224 = (matrix4fc.m22() * this.m22) + (matrix4fc.m12() * this.m21) + (matrix4fc.m02() * this.m20);
        float m232 = matrix4fc.m23();
        float m302 = matrix4fc.m30() + (matrix4fc.m20() * this.m32) + (matrix4fc.m10() * this.m31) + (matrix4fc.m00() * this.m30);
        float f2 = m302;
        float m312 = matrix4fc.m31() + (matrix4fc.m21() * this.m32) + (matrix4fc.m11() * this.m31) + (matrix4fc.m01() * this.m30);
        float f3 = m312;
        float m322 = matrix4fc.m32() + (matrix4fc.m22() * this.m32) + (matrix4fc.m12() * this.m31) + (matrix4fc.m02() * this.m30);
        float m332 = matrix4fc.m33();
        matrix4f2._m00(m202);
        matrix4f2._m01(m212);
        matrix4f2._m02(m222);
        matrix4f2._m03(m032);
        matrix4f2._m10(m203);
        matrix4f2._m11(m213);
        matrix4f2._m12(m223);
        matrix4f2._m13(m132);
        matrix4f2._m20(m204);
        matrix4f2._m21(m214);
        matrix4f2._m22(m224);
        matrix4f2._m23(m232);
        matrix4f2._m30(f2);
        matrix4f2._m31(f3);
        matrix4f2._m32(m322);
        matrix4f2._m33(m332);
        matrix4f2._properties((properties() & matrix4fc.properties() & 16) | 2);
        return matrix4f2;
    }

    public Matrix4f mulOrthoAffine(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        float m002 = matrix4fc.m00() * this.m00;
        float m012 = matrix4fc.m01() * this.m11;
        float m022 = matrix4fc.m02() * this.m22;
        float m102 = matrix4fc.m10() * this.m00;
        float m112 = matrix4fc.m11() * this.m11;
        float m122 = matrix4fc.m12() * this.m22;
        float m202 = matrix4fc.m20() * this.m00;
        float m212 = matrix4fc.m21() * this.m11;
        float m222 = matrix4fc.m22() * this.m22;
        float m302 = (matrix4fc.m30() * this.m00) + this.m30;
        float m312 = (matrix4fc.m31() * this.m11) + this.m31;
        float m322 = (matrix4fc.m32() * this.m22) + this.m32;
        matrix4f._m00(m002);
        matrix4f._m01(m012);
        matrix4f._m02(m022);
        matrix4f._m03(0.0f);
        a.a(matrix4f, m102, m112, m122, 0.0f);
        a.b(matrix4f, m202, m212, m222, 0.0f);
        a.c(matrix4f, m302, m312, m322, 1.0f);
        matrix4f._properties(2);
        return matrix4f;
    }

    public Matrix4f mulPerspectiveAffine(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m002 = matrix4fc.m00() * this.m00;
        float m012 = matrix4fc.m01() * this.m11;
        float m022 = matrix4fc.m02() * this.m22;
        float m023 = matrix4fc.m02() * this.m23;
        float m102 = matrix4fc.m10() * this.m00;
        float m112 = matrix4fc.m11() * this.m11;
        float m122 = matrix4fc.m12() * this.m22;
        float m123 = matrix4fc.m12() * this.m23;
        float m202 = matrix4fc.m20() * this.m00;
        float m212 = matrix4fc.m21() * this.m11;
        float m222 = matrix4fc.m22() * this.m22;
        float m223 = matrix4fc.m22() * this.m23;
        float m302 = matrix4fc.m30() * this.m00;
        float m312 = this.m11 * matrix4fc.m31();
        float m322 = (matrix4fc.m32() * this.m22) + this.m32;
        float m323 = this.m23 * matrix4fc.m32();
        matrix4f2._m00(m002);
        matrix4f2._m01(m012);
        matrix4f2._m02(m022);
        matrix4f2._m03(m023);
        matrix4f2._m10(m102);
        matrix4f2._m11(m112);
        matrix4f2._m12(m122);
        matrix4f2._m13(m123);
        matrix4f2._m20(m202);
        matrix4f2._m21(m212);
        matrix4f2._m22(m222);
        matrix4f2._m23(m223);
        matrix4f2._m30(m302);
        matrix4f2._m31(m312);
        matrix4f2._m32(m322);
        matrix4f2._m33(m323);
        matrix4f2._properties(0);
        return matrix4f2;
    }

    public Matrix4f normal(Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.identity();
        }
        if ((i2 & 16) != 0) {
            return normalOrthonormal(matrix4f);
        }
        return normalGeneric(matrix4f);
    }

    public Matrix4f normalize3x3(Matrix4f matrix4f) {
        float f2 = this.m00;
        float f3 = f2 * f2;
        float f4 = this.m01;
        float f5 = (f4 * f4) + f3;
        float f6 = this.m02;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f6 * f6) + f5)));
        float f7 = this.m10;
        float f8 = f7 * f7;
        float f9 = this.m11;
        float f10 = (f9 * f9) + f8;
        float f11 = this.m12;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f11 * f11) + f10)));
        float f12 = this.m20;
        float f13 = f12 * f12;
        float f14 = this.m21;
        float f15 = (f14 * f14) + f13;
        float f16 = this.m22;
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f16 * f16) + f15)));
        matrix4f._m00(this.m00 * sqrt);
        matrix4f._m01(this.m01 * sqrt);
        matrix4f._m02(this.m02 * sqrt);
        matrix4f._m10(this.m10 * sqrt2);
        matrix4f._m11(this.m11 * sqrt2);
        matrix4f._m12(this.m12 * sqrt2);
        matrix4f._m20(this.m20 * sqrt3);
        matrix4f._m21(this.m21 * sqrt3);
        matrix4f._m22(this.m22 * sqrt3);
        matrix4f._properties(this.properties);
        return matrix4f;
    }

    public Matrix4f rotateAffineXYZ(float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f27 = (f23 * f6) + (this.m01 * cosFromSin2);
        float f28 = (f6 * f24) + (this.m02 * cosFromSin2);
        matrix4f2._m20((f22 * cosFromSin2) + (f25 * sin2));
        matrix4f2._m21((f23 * cosFromSin2) + (this.m01 * sin2));
        matrix4f2._m22((f24 * cosFromSin2) + (this.m02 * sin2));
        matrix4f2._m23(0.0f);
        matrix4f2._m00((f11 * f19) + (f26 * cosFromSin3));
        matrix4f2._m01((f16 * f19) + (f27 * cosFromSin3));
        matrix4f2._m02((f21 * f19) + (f28 * cosFromSin3));
        matrix4f2._m03(0.0f);
        matrix4f2._m10((f11 * cosFromSin3) + (f26 * f14));
        matrix4f2._m11((f16 * cosFromSin3) + (f27 * f14));
        matrix4f2._m12((f21 * cosFromSin3) + (f28 * f14));
        matrix4f2._m13(0.0f);
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(this.m33);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateAffineYXZ(float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f27 = (f16 * sin) + (this.m11 * cosFromSin);
        float f28 = (sin * f21) + (this.m12 * cosFromSin);
        matrix4f2._m20((f11 * cosFromSin) + (f25 * f6));
        matrix4f2._m21((f16 * cosFromSin) + (this.m11 * f6));
        matrix4f2._m22((f21 * cosFromSin) + (this.m12 * f6));
        matrix4f2._m23(0.0f);
        matrix4f2._m00((f26 * f19) + (f22 * cosFromSin3));
        matrix4f2._m01((f27 * f19) + (f23 * cosFromSin3));
        matrix4f2._m02((f28 * f19) + (f24 * cosFromSin3));
        matrix4f2._m03(0.0f);
        matrix4f2._m10((f26 * cosFromSin3) + (f22 * f14));
        matrix4f2._m11((f27 * cosFromSin3) + (f23 * f14));
        matrix4f2._m12((f28 * cosFromSin3) + (f24 * f14));
        matrix4f2._m13(0.0f);
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(this.m33);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateAffineZYX(float f2, float f3, float f4, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        float f28 = (this.m21 * cosFromSin2) + (f16 * sin2);
        float f29 = (this.m22 * cosFromSin2) + (sin2 * f21);
        matrix4f2._m00((f26 * f6) + (f11 * cosFromSin2));
        matrix4f2._m01((this.m21 * f6) + (f16 * cosFromSin2));
        matrix4f2._m02((this.m22 * f6) + (f21 * cosFromSin2));
        matrix4f2._m03(0.0f);
        matrix4f2._m10((f27 * f19) + (f22 * cosFromSin));
        matrix4f2._m11((f28 * f19) + (f23 * cosFromSin));
        matrix4f2._m12((f29 * f19) + (f24 * cosFromSin));
        matrix4f2._m13(0.0f);
        matrix4f2._m20((f27 * cosFromSin) + (f22 * f14));
        matrix4f2._m21((f28 * cosFromSin) + (f23 * f14));
        matrix4f2._m22((f29 * cosFromSin) + (f24 * f14));
        matrix4f2._m23(0.0f);
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(this.m33);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return rotationAround(quaternionfc, f2, f3, f4);
        }
        if ((i2 & 2) != 0) {
            return rotateAroundAffine(quaternionfc, f2, f3, f4, matrix4f);
        }
        return rotateAroundGeneric(quaternionfc, f2, f3, f4, matrix4f);
    }

    public Matrix4f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), thisOrNew());
    }

    public Matrix4f rotateTowardsXY(float f2, float f3, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.rotationTowardsXY(f2, f3);
        }
        float f4 = -f2;
        float f5 = this.m00;
        float f6 = f5 * f3;
        float f7 = this.m10;
        float f8 = (f7 * f2) + f6;
        float f9 = (this.m11 * f2) + (this.m01 * f3);
        float f10 = (this.m12 * f2) + (this.m02 * f3);
        float f11 = (this.m13 * f2) + (this.m03 * f3);
        matrix4f._m10((f7 * f3) + (f5 * f4));
        matrix4f._m11((this.m11 * f3) + (this.m01 * f4));
        matrix4f._m12((this.m12 * f3) + (this.m02 * f4));
        matrix4f._m13((this.m13 * f3) + (this.m03 * f4));
        matrix4f._m00(f8);
        matrix4f._m01(f9);
        matrix4f._m02(f10);
        matrix4f._m03(f11);
        matrix4f._m20(this.m20);
        matrix4f._m21(this.m21);
        matrix4f._m22(this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f rotateXYZ(float f2, float f3, float f4) {
        return rotateXYZ(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateYXZ(float f2, float f3, float f4) {
        return rotateYXZ(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotateZYX(float f2, float f3, float f4) {
        return rotateZYX(f2, f3, f4, thisOrNew());
    }

    public Matrix4f rotation(AxisAngle4f axisAngle4f) {
        return rotation(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Matrix4f rotationTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
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
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(f14);
        _m01(f15);
        _m02(f16);
        _m10(f17);
        _m11(f18);
        _m12(f19);
        _m20(f8);
        _m21(f9);
        _m22(f10);
        _properties(18);
        return this;
    }

    public Matrix4f scale(Vector3fc vector3fc) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), thisOrNew());
    }

    public Matrix4f scaling(float f2, float f3, float f4) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(f2);
        _m11(f3);
        _m22(f4);
        int i2 = 0;
        if (Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f) {
            i2 = 16;
        }
        _properties(i2 | 2);
        return this;
    }

    public Matrix4f setLookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
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
        _m00(f15);
        _m01(f18);
        _m02(f9);
        _m03(0.0f);
        a.a(this, f16, f19, f10, 0.0f);
        a.b(this, f17, f20, f11, 0.0f);
        a.c(this, 0.0f, 0.0f, 0.0f, 1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f setLookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f2 - f5;
        float f12 = f3 - f6;
        float f13 = f4 - f7;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        _m00(f20);
        _m01(f23);
        _m02(f14);
        _m03(0.0f);
        a.a(this, f21, f24, f15, 0.0f);
        _m20(f22);
        _m21(f25);
        _m22(f16);
        _m23(0.0f);
        float f26 = f22 * f4;
        _m30(-(f26 + (f21 * f3) + (f20 * f2)));
        float f27 = f25 * f4;
        _m31(-(f27 + (f24 * f3) + (f23 * f2)));
        float f28 = f16 * f4;
        _m32(-(f28 + (f15 * f3) + (f14 * f2)));
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f setLookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float f13 = f7 - f4;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f13 * f13) + ((f12 * f12) + (f11 * f11)))));
        float f14 = f11 * sqrt;
        float f15 = f12 * sqrt;
        float f16 = f13 * sqrt;
        float f17 = (f9 * f16) - (f10 * f15);
        float f18 = (f10 * f14) - (f8 * f16);
        float f19 = (f8 * f15) - (f9 * f14);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f19 * f19) + ((f18 * f18) + (f17 * f17)))));
        float f20 = f17 * sqrt2;
        float f21 = f18 * sqrt2;
        float f22 = f19 * sqrt2;
        float f23 = (f15 * f22) - (f16 * f21);
        float f24 = (f16 * f20) - (f14 * f22);
        float f25 = (f14 * f21) - (f15 * f20);
        _m00(f20);
        _m01(f23);
        _m02(f14);
        _m03(0.0f);
        a.a(this, f21, f24, f15, 0.0f);
        _m20(f22);
        _m21(f25);
        _m22(f16);
        _m23(0.0f);
        float f26 = f22 * f4;
        _m30(-(f26 + (f21 * f3) + (f20 * f2)));
        float f27 = f25 * f4;
        _m31(-(f27 + (f24 * f3) + (f23 * f2)));
        float f28 = f16 * f4;
        _m32(-(f28 + (f15 * f3) + (f14 * f2)));
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f shadow(Vector4f vector4f, float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        Vector4f vector4f2 = vector4f;
        return shadow(vector4f2.x, vector4f2.y, vector4f2.z, vector4f2.w, f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f sub(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(this.m00 - matrix4fc.m00());
        matrix4f._m01(this.m01 - matrix4fc.m01());
        matrix4f._m02(this.m02 - matrix4fc.m02());
        matrix4f._m03(this.m03 - matrix4fc.m03());
        matrix4f._m10(this.m10 - matrix4fc.m10());
        matrix4f._m11(this.m11 - matrix4fc.m11());
        matrix4f._m12(this.m12 - matrix4fc.m12());
        matrix4f._m13(this.m13 - matrix4fc.m13());
        matrix4f._m20(this.m20 - matrix4fc.m20());
        matrix4f._m21(this.m21 - matrix4fc.m21());
        matrix4f._m22(this.m22 - matrix4fc.m22());
        matrix4f._m23(this.m23 - matrix4fc.m23());
        matrix4f._m30(this.m30 - matrix4fc.m30());
        matrix4f._m31(this.m31 - matrix4fc.m31());
        matrix4f._m32(this.m32 - matrix4fc.m32());
        matrix4f._m33(this.m33 - matrix4fc.m33());
        matrix4f._properties(0);
        return matrix4f;
    }

    public Matrix4f sub4x3(Matrix4fc matrix4fc, Matrix4f matrix4f) {
        matrix4f._m00(this.m00 - matrix4fc.m00());
        matrix4f._m01(this.m01 - matrix4fc.m01());
        matrix4f._m02(this.m02 - matrix4fc.m02());
        matrix4f._m03(this.m03);
        matrix4f._m10(this.m10 - matrix4fc.m10());
        matrix4f._m11(this.m11 - matrix4fc.m11());
        matrix4f._m12(this.m12 - matrix4fc.m12());
        matrix4f._m13(this.m13);
        matrix4f._m20(this.m20 - matrix4fc.m20());
        matrix4f._m21(this.m21 - matrix4fc.m21());
        matrix4f._m22(this.m22 - matrix4fc.m22());
        matrix4f._m23(this.m23);
        matrix4f._m30(this.m30 - matrix4fc.m30());
        matrix4f._m31(this.m31 - matrix4fc.m31());
        matrix4f._m32(this.m32 - matrix4fc.m32());
        matrix4f._m33(this.m33);
        matrix4f._properties(0);
        return matrix4f;
    }

    public Vector4f transform(Vector4fc vector4fc, Vector4f vector4f) {
        return vector4fc.mul((Matrix4fc) this, vector4f);
    }

    public Vector4f transformAffine(Vector4fc vector4fc, Vector4f vector4f) {
        return transformAffine(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w(), vector4f);
    }

    public Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f) {
        return transformDirection(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f);
    }

    public Vector3f transformPosition(Vector3fc vector3fc, Vector3f vector3f) {
        return transformPosition(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3f);
    }

    public Vector4f transformProject(Vector4fc vector4fc, Vector4f vector4f) {
        return vector4fc.mulProject(this, vector4f);
    }

    public Matrix4f translate(Vector3fc vector3fc, Matrix4f matrix4f) {
        return translate(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4f);
    }

    public Matrix4f translateLocal(Vector3fc vector3fc, Matrix4f matrix4f) {
        return translateLocal(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4f);
    }

    public Matrix4f translationRotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f7 * f7) + ((f6 * f6) + (f5 * f5)))));
        float f11 = f5 * sqrt;
        float f12 = f6 * sqrt;
        float f13 = f7 * sqrt;
        float f14 = (f9 * f13) - (f10 * f12);
        float f15 = (f10 * f11) - (f8 * f13);
        float f16 = (f8 * f12) - (f9 * f11);
        float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f16 * f16) + ((f15 * f15) + (f14 * f14)))));
        float f17 = f14 * sqrt2;
        float f18 = f15 * sqrt2;
        float f19 = f16 * sqrt2;
        float f20 = (f12 * f19) - (f13 * f18);
        float f21 = (f13 * f17) - (f11 * f19);
        float f22 = (f11 * f18) - (f12 * f17);
        _m00(f17);
        _m01(f18);
        _m02(f19);
        _m03(0.0f);
        a.a(this, f20, f21, f22, 0.0f);
        a.b(this, f11, f12, f13, 0.0f);
        a.c(this, f2, f3, f4, 1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f transpose3x3(Matrix4f matrix4f) {
        float f2 = this.m00;
        float f3 = this.m10;
        float f4 = this.m20;
        float f5 = this.m01;
        float f6 = this.m11;
        float f7 = this.m21;
        float f8 = this.m02;
        float f9 = this.m12;
        float f10 = this.m22;
        matrix4f._m00(f2);
        matrix4f._m01(f3);
        matrix4f._m02(f4);
        matrix4f._m10(f5);
        matrix4f._m11(f6);
        matrix4f._m12(f7);
        matrix4f._m20(f8);
        matrix4f._m21(f9);
        matrix4f._m22(f10);
        matrix4f._properties(this.properties & 30);
        return matrix4f;
    }

    public Vector4f unprojectInv(float f2, float f3, float f4, int[] iArr, Vector4f vector4f) {
        float f5 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f6 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f7 = (f4 + f4) - 1.0f;
        float f8 = 1.0f / (((this.m23 * f7) + ((this.m13 * f6) + (this.m03 * f5))) + this.m33);
        vector4f.x = ((this.m20 * f7) + (this.m10 * f6) + (this.m00 * f5) + this.m30) * f8;
        vector4f.y = ((this.m21 * f7) + (this.m11 * f6) + (this.m01 * f5) + this.m31) * f8;
        vector4f.z = ((this.m22 * f7) + (this.m12 * f6) + (this.m02 * f5) + this.m32) * f8;
        vector4f.w = 1.0f;
        return vector4f;
    }

    public Matrix4f unprojectInvRay(float f2, float f3, int[] iArr, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float f4 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f5 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f6 = (this.m10 * f5) + (this.m00 * f4) + this.m30;
        float f7 = (this.m11 * f5) + (this.m01 * f4) + this.m31;
        float f8 = (this.m12 * f5) + (this.m02 * f4) + this.m32;
        float f9 = this.m03;
        float f10 = f9 * f4;
        float f11 = this.m13;
        float f12 = (f11 * f5) + f10;
        float f13 = this.m23;
        float f14 = f12 - f13;
        float f15 = this.m33;
        float f16 = 1.0f / (f14 + f15);
        float f17 = this.m20;
        float f18 = (f6 - f17) * f16;
        float f19 = this.m21;
        float f20 = (f7 - f19) * f16;
        float f21 = this.m22;
        float f22 = f16 * (f8 - f21);
        float f23 = 1.0f / ((((f11 * f5) + (f9 * f4)) + f13) + f15);
        float f24 = (f6 + f17) * f23;
        float f25 = (f7 + f19) * f23;
        float f26 = (f8 + f21) * f23;
        vector3f3.x = f18;
        float f27 = f20;
        vector3f3.y = f27;
        vector3f3.z = f22;
        Vector3f vector3f5 = vector3f2;
        float f28 = f27;
        vector3f5.x = f24 - f18;
        vector3f5.y = f25 - f28;
        vector3f5.z = f26 - f22;
        return this;
    }

    private Matrix3f normalOrthonormal(Matrix3f matrix3f) {
        matrix3f.set((Matrix4fc) this);
        return matrix3f;
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public FloatBuffer get4x3(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put4x3(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer get4x3Transposed(ByteBuffer byteBuffer) {
        return get4x3Transposed(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer getTransposed(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Matrix4f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.setLookAlong(f2, f3, f4, f5, f6, f7);
        }
        return lookAlongGeneric(f2, f3, f4, f5, f6, f7, matrix4f);
    }

    public Matrix4f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.setLookAt(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
        if ((i2 & 1) != 0) {
            return lookAtPerspective(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4f);
        }
        return lookAtGeneric(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4f);
    }

    public Matrix4f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.setLookAtLH(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
        if ((i2 & 1) != 0) {
            return lookAtPerspectiveLH(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4f);
        }
        return lookAtLHGeneric(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4f);
    }

    public Matrix4f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
        return rotateTowards(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f rotateXYZ(float f2, float f3, float f4, Matrix4f matrix4f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4f matrix4f2 = matrix4f;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f2.rotationXYZ(f5, f6, f7);
        }
        if ((i2 & 2) != 0) {
            return matrix4f2.rotateAffineXYZ(f5, f6, f7);
        }
        double d2 = (double) f5;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f6;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f7;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f8 = -sin;
        float f9 = -sin2;
        float f10 = -sin3;
        float f11 = this.m10;
        float f12 = f11 * cosFromSin;
        float f13 = this.m20;
        float f14 = (f13 * sin) + f12;
        float f15 = this.m11;
        float f16 = f15 * cosFromSin;
        float f17 = f10;
        float f18 = this.m21;
        float f19 = (f18 * sin) + f16;
        float f20 = this.m12;
        float f21 = f20 * cosFromSin;
        float f22 = sin3;
        float f23 = this.m22;
        float f24 = (f23 * sin) + f21;
        float f25 = f14;
        float f26 = this.m13;
        float f27 = f26 * cosFromSin;
        float f28 = cosFromSin3;
        float f29 = this.m23;
        float f30 = (sin * f29) + f27;
        float f31 = (f13 * cosFromSin) + (f11 * f8);
        float f32 = (f18 * cosFromSin) + (f15 * f8);
        float f33 = (f23 * cosFromSin) + (f20 * f8);
        float f34 = (f29 * cosFromSin) + (f26 * f8);
        float f35 = this.m00;
        float f36 = (f31 * f9) + (f35 * cosFromSin2);
        float f37 = (f32 * f9) + (this.m01 * cosFromSin2);
        float f38 = (f33 * f9) + (this.m02 * cosFromSin2);
        float f39 = (f9 * f34) + (this.m03 * cosFromSin2);
        matrix4f2._m20((f31 * cosFromSin2) + (f35 * sin2));
        matrix4f2._m21((f32 * cosFromSin2) + (this.m01 * sin2));
        matrix4f2._m22((f33 * cosFromSin2) + (this.m02 * sin2));
        matrix4f2._m23((f34 * cosFromSin2) + (this.m03 * sin2));
        matrix4f2._m00((f25 * f22) + (f36 * f28));
        matrix4f2._m01((f19 * f22) + (f37 * f28));
        matrix4f2._m02((f24 * f22) + (f38 * f28));
        matrix4f2._m03((f30 * f22) + (f39 * f28));
        matrix4f2._m10((f25 * f28) + (f36 * f17));
        matrix4f2._m11((f19 * f28) + (f37 * f17));
        matrix4f2._m12((f24 * f28) + (f38 * f17));
        matrix4f2._m13((f30 * f28) + (f39 * f17));
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(this.m33);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f rotateYXZ(float f2, float f3, float f4, Matrix4f matrix4f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4f matrix4f2 = matrix4f;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f2.rotationYXZ(f5, f6, f7);
        }
        if ((i2 & 2) != 0) {
            return matrix4f2.rotateAffineYXZ(f5, f6, f7);
        }
        double d2 = (double) f6;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f5;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f7;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f8 = -sin2;
        float f9 = -sin;
        float f10 = -sin3;
        float f11 = this.m00;
        float f12 = f11 * sin2;
        float f13 = this.m20;
        float f14 = (f13 * cosFromSin2) + f12;
        float f15 = this.m01;
        float f16 = f15 * sin2;
        float f17 = f10;
        float f18 = this.m21;
        float f19 = (f18 * cosFromSin2) + f16;
        float f20 = this.m02;
        float f21 = f20 * sin2;
        float f22 = sin3;
        float f23 = this.m22;
        float f24 = (f23 * cosFromSin2) + f21;
        float f25 = cosFromSin3;
        float f26 = this.m03;
        float f27 = sin2 * f26;
        float f28 = this.m23;
        float f29 = (f28 * cosFromSin2) + f27;
        float f30 = (f13 * f8) + (f11 * cosFromSin2);
        float f31 = (f18 * f8) + (f15 * cosFromSin2);
        float f32 = (f23 * f8) + (f20 * cosFromSin2);
        float f33 = (f28 * f8) + (f26 * cosFromSin2);
        float f34 = this.m10;
        float f35 = (f14 * sin) + (f34 * cosFromSin);
        float f36 = (f19 * sin) + (this.m11 * cosFromSin);
        float f37 = (f24 * sin) + (this.m12 * cosFromSin);
        float f38 = (sin * f29) + (this.m13 * cosFromSin);
        float f39 = (f14 * cosFromSin) + (f34 * f9);
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f39);
        matrix4f3._m21((f19 * cosFromSin) + (this.m11 * f9));
        matrix4f3._m22((f24 * cosFromSin) + (this.m12 * f9));
        matrix4f3._m23((f29 * cosFromSin) + (this.m13 * f9));
        matrix4f3._m00((f35 * f22) + (f30 * f25));
        matrix4f3._m01((f36 * f22) + (f31 * f25));
        matrix4f3._m02((f37 * f22) + (f32 * f25));
        matrix4f3._m03((f38 * f22) + (f33 * f25));
        matrix4f3._m10((f35 * f25) + (f30 * f17));
        matrix4f3._m11((f36 * f25) + (f31 * f17));
        matrix4f3._m12((f37 * f25) + (f32 * f17));
        matrix4f3._m13((f38 * f25) + (f33 * f17));
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f rotateZYX(float f2, float f3, float f4, Matrix4f matrix4f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4f matrix4f2 = matrix4f;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f2.rotationZYX(f5, f6, f7);
        }
        if ((i2 & 2) != 0) {
            return matrix4f2.rotateAffineZYX(f5, f6, f7);
        }
        double d2 = (double) f7;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        double d3 = (double) f6;
        float sin2 = (float) Math.sin(d3);
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        double d4 = (double) f5;
        float sin3 = (float) Math.sin(d4);
        float cosFromSin3 = (float) Math.cosFromSin((double) sin3, d4);
        float f8 = -sin3;
        float f9 = -sin2;
        float f10 = -sin;
        float f11 = this.m00;
        float f12 = f11 * cosFromSin3;
        float f13 = this.m10;
        float f14 = (f13 * sin3) + f12;
        float f15 = this.m01;
        float f16 = f15 * cosFromSin3;
        float f17 = f10;
        float f18 = this.m11;
        float f19 = (f18 * sin3) + f16;
        float f20 = this.m02;
        float f21 = f20 * cosFromSin3;
        float f22 = sin;
        float f23 = this.m12;
        float f24 = (f23 * sin3) + f21;
        float f25 = cosFromSin;
        float f26 = this.m03;
        float f27 = f26 * cosFromSin3;
        float f28 = this.m13;
        float f29 = (sin3 * f28) + f27;
        float f30 = (f13 * cosFromSin3) + (f11 * f8);
        float f31 = (f18 * cosFromSin3) + (f15 * f8);
        float f32 = (f23 * cosFromSin3) + (f20 * f8);
        float f33 = (f28 * cosFromSin3) + (f26 * f8);
        float f34 = f14 * sin2;
        float f35 = this.m20;
        float f36 = (f35 * cosFromSin2) + f34;
        float f37 = (this.m21 * cosFromSin2) + (f19 * sin2);
        float f38 = (this.m22 * cosFromSin2) + (f24 * sin2);
        float f39 = (this.m23 * cosFromSin2) + (sin2 * f29);
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m00((f35 * f9) + (f14 * cosFromSin2));
        matrix4f3._m01((this.m21 * f9) + (f19 * cosFromSin2));
        matrix4f3._m02((this.m22 * f9) + (f24 * cosFromSin2));
        matrix4f3._m03((this.m23 * f9) + (f29 * cosFromSin2));
        matrix4f3._m10((f36 * f22) + (f30 * f25));
        matrix4f3._m11((f37 * f22) + (f31 * f25));
        matrix4f3._m12((f38 * f22) + (f32 * f25));
        matrix4f3._m13((f39 * f22) + (f33 * f25));
        matrix4f3._m20((f36 * f25) + (f30 * f17));
        matrix4f3._m21((f37 * f25) + (f31 * f17));
        matrix4f3._m22((f38 * f25) + (f32 * f17));
        matrix4f3._m23((f39 * f25) + (f33 * f17));
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f rotation(float f2, float f3, float f4, float f5) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = f3 * f4;
        float f8 = f3 * f5;
        float f9 = f4 * f5;
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00((f3 * f3 * f6) + cosFromSin);
        float f10 = f7 * f6;
        float f11 = f5 * sin;
        _m10(f10 - f11);
        float f12 = f8 * f6;
        float f13 = f4 * sin;
        _m20(f12 + f13);
        _m01(f10 + f11);
        _m11((f4 * f4 * f6) + cosFromSin);
        float f14 = f9 * f6;
        float f15 = f3 * sin;
        _m21(f14 - f15);
        _m02(f12 - f13);
        _m12(f14 + f15);
        _m22((f5 * f5 * f6) + cosFromSin);
        _properties(18);
        return this;
    }

    public Matrix4f scale(float f2, Matrix4f matrix4f) {
        return scale(f2, f2, f2, matrix4f);
    }

    public Matrix4f set3x3(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy3x3((Matrix3f) matrix3fc, this);
        } else {
            set3x3Matrix3fc(matrix3fc);
        }
        this.properties &= -30;
        return this;
    }

    public Matrix4f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return shadow(f2, f3, f4, f5, f6, f7, f8, f9, thisOrNew());
    }

    public Vector4f transform(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = f2;
        vector4f.y = f3;
        vector4f.z = f4;
        vector4f.w = f5;
        return vector4f.mul((Matrix4fc) this);
    }

    public Vector4f transformAffine(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = f2;
        vector4f.y = f3;
        vector4f.z = f4;
        vector4f.w = f5;
        return vector4f.mulAffine(this, vector4f);
    }

    public Vector3f transformDirection(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = f2;
        vector3f.y = f3;
        vector3f.z = f4;
        return vector3f.mulDirection((Matrix4fc) this);
    }

    public Vector3f transformPosition(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = f2;
        vector3f.y = f3;
        vector3f.z = f4;
        return vector3f.mulPosition((Matrix4fc) this);
    }

    public Vector4f transformProject(float f2, float f3, float f4, float f5, Vector4f vector4f) {
        vector4f.x = f2;
        vector4f.y = f3;
        vector4f.z = f4;
        vector4f.w = f5;
        return vector4f.mulProject(this);
    }

    public Matrix4f translate(float f2, float f3, float f4, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.translation(f2, f3, f4);
        }
        return translateGeneric(f2, f3, f4, matrix4f);
    }

    public Matrix4f translateLocal(float f2, float f3, float f4, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.translation(f2, f3, f4);
        }
        return translateLocalGeneric(f2, f3, f4, matrix4f);
    }

    public Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        return frustum(f2, f3, f4, f5, f6, f7, false, matrix4f);
    }

    public Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return frustumLH(f2, f3, f4, f5, f6, f7, z, thisOrNew());
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer get4x3(ByteBuffer byteBuffer) {
        return get4x3(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer get4x3Transposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x3Transposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        return ortho(f2, f3, f4, f5, f6, f7, false, matrix4f);
    }

    public Matrix4f ortho2D(float f2, float f3, float f4, float f5) {
        return ortho2D(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f ortho2DLH(float f2, float f3, float f4, float f5) {
        return ortho2DLH(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        return orthoLH(f2, f3, f4, f5, f6, f7, false, matrix4f);
    }

    public Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return orthoSymmetric(f2, f3, f4, f5, false, matrix4f);
    }

    public Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return orthoSymmetricLH(f2, f3, f4, f5, false, matrix4f);
    }

    public Matrix4f perspective(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return perspective(f2, f3, f4, f5, false, matrix4f);
    }

    public Matrix4f perspectiveLH(float f2, float f3, float f4, float f5, boolean z) {
        return perspectiveLH(f2, f3, f4, f5, z, thisOrNew());
    }

    public Matrix4f rotateLocal(float f2, float f3, float f4, float f5) {
        return rotateLocal(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
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
        matrix4f2._m30(this.m30);
        matrix4f2._m31(this.m31);
        matrix4f2._m32(this.m32);
        matrix4f2._m33(this.m33);
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
        float f35 = f34 * f14;
        float f36 = f9;
        float f37 = this.m12;
        float f38 = (f37 * f15) + f35;
        float f39 = f8;
        float f40 = this.m22;
        float f41 = f40;
        float f42 = (f40 * f16) + f38;
        float f43 = this.m03;
        float f44 = f14 * f43;
        float f45 = f43;
        float f46 = this.m13;
        float f47 = (f15 * f46) + f44;
        float f48 = this.m23;
        float f49 = (f16 * f48) + f47;
        float f50 = (f24 * f19) + (f22 * f18) + (f20 * f17);
        float f51 = f31 * f19;
        float f52 = f51 + (f29 * f18) + (f26 * f17);
        float f53 = (f41 * f19) + (f37 * f18) + (f34 * f17);
        float f54 = f48 * f19;
        float f55 = f54 + (f46 * f18) + (f17 * f45);
        float f56 = f24 * f32;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f56 + (f22 * f36) + (f20 * f39));
        matrix4f3._m21((this.m21 * f32) + (this.m11 * f36) + (this.m01 * f39));
        matrix4f3._m22((this.m22 * f32) + (this.m12 * f36) + (this.m02 * f39));
        matrix4f3._m23((this.m23 * f32) + (this.m13 * f36) + (this.m03 * f39));
        matrix4f3._m00(f28);
        matrix4f3._m01(f33);
        matrix4f3._m02(f42);
        matrix4f3._m03(f49);
        a.a(matrix4f3, f50, f52, f53, f55);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f scale(float f2) {
        return scale(f2, f2, f2);
    }

    public Matrix4f scaleLocal(float f2, Matrix4f matrix4f) {
        return scaleLocal(f2, f2, f2, matrix4f);
    }

    public Matrix4f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f8 * f8) + ((f7 * f7) + (f6 * f6)))));
        float f10 = f6 * sqrt;
        float f11 = f7 * sqrt;
        float f12 = f8 * sqrt;
        float f13 = sqrt * f9;
        float f14 = f10 * f2;
        float f15 = f11 * f3;
        float f16 = f12 * f4;
        float f17 = f13 * f5;
        float f18 = f14 + f15 + f16 + f17;
        float f19 = f18 - f14;
        float f20 = -f10;
        float f21 = f20 * f3;
        float f22 = f20 * f4;
        float f23 = f20 * f5;
        float f24 = -f11;
        float f25 = f24 * f2;
        float f26 = f18 - f15;
        float f27 = f24 * f4;
        float f28 = f24 * f5;
        float f29 = -f12;
        float f30 = f29 * f2;
        float f31 = f29 * f3;
        float f32 = f18 - f16;
        float f33 = f29 * f5;
        float f34 = -f13;
        float f35 = f34 * f2;
        float f36 = f34 * f3;
        float f37 = f34 * f4;
        float f38 = f18 - f17;
        float f39 = this.m00;
        float f40 = f39 * f19;
        float f41 = this.m10;
        float f42 = (f41 * f21) + f40;
        float f43 = f38;
        float f44 = this.m20;
        float f45 = (f44 * f22) + f42;
        float f46 = f37;
        float f47 = this.m30;
        float f48 = f33;
        float f49 = (f47 * f23) + f45;
        float f50 = this.m01;
        float f51 = f50 * f19;
        float f52 = f32;
        float f53 = this.m11;
        float f54 = (f53 * f21) + f51;
        float f55 = f30;
        float f56 = this.m21;
        float f57 = (f56 * f22) + f54;
        float f58 = f56;
        float f59 = this.m31;
        float f60 = f59;
        float f61 = (f59 * f23) + f57;
        float f62 = this.m02;
        float f63 = f62 * f19;
        float f64 = f62;
        float f65 = this.m12;
        float f66 = (f65 * f21) + f63;
        float f67 = f65;
        float f68 = this.m22;
        float f69 = (f68 * f22) + f66;
        float f70 = f68;
        float f71 = this.m32;
        float f72 = f71;
        float f73 = (f71 * f23) + f69;
        float f74 = this.m03;
        float f75 = f19 * f74;
        float f76 = f74;
        float f77 = this.m13;
        float f78 = (f21 * f77) + f75;
        float f79 = this.m23;
        float f80 = (f22 * f79) + f78;
        float f81 = this.m33;
        float f82 = (f23 * f81) + f80;
        float f83 = (f47 * f28) + (f44 * f27) + (f41 * f26) + (f39 * f25);
        float f84 = (f60 * f28) + (f58 * f27) + (f53 * f26) + (f50 * f25);
        float f85 = f84;
        float f86 = (f72 * f28) + (f70 * f27) + (f67 * f26) + (f64 * f25);
        float f87 = f27 * f79;
        float f88 = f28 * f81;
        float f89 = f88 + f87 + (f26 * f77) + (f25 * f76);
        float f90 = (f47 * f48) + (f44 * f52) + (f41 * f31) + (f39 * f55);
        float f91 = f60 * f48;
        float f92 = f91 + (f58 * f52) + (f53 * f31) + (f50 * f55);
        float f93 = (f72 * f48) + (f70 * f52) + (f67 * f31) + (f64 * f55);
        float f94 = f79 * f52;
        float f95 = f81 * f48;
        float f96 = f95 + f94 + (f77 * f31) + (f76 * f55);
        float f97 = f41 * f36;
        float f98 = f47 * f43;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m30(f98 + (f44 * f46) + f97 + (f39 * f35));
        matrix4f3._m31((this.m31 * f43) + (this.m21 * f46) + (this.m11 * f36) + (this.m01 * f35));
        matrix4f3._m32((this.m32 * f43) + (this.m22 * f46) + (this.m12 * f36) + (this.m02 * f35));
        matrix4f3._m33((this.m33 * f43) + (this.m23 * f46) + (this.m13 * f36) + (this.m03 * f35));
        matrix4f3._m00(f49);
        matrix4f3._m01(f61);
        matrix4f3._m02(f73);
        matrix4f3._m03(f82);
        a.a(matrix4f3, f83, f85, f86, f89);
        a.b(matrix4f3, f90, f92, f93, f96);
        matrix4f3._properties(this.properties & -30);
        return matrix4f3;
    }

    public Matrix4f transpose() {
        return transpose(thisOrNew());
    }

    public Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return frustum(f2, f3, f4, f5, f6, f7, z, thisOrNew());
    }

    public Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        return frustumLH(f2, f3, f4, f5, f6, f7, false, matrix4f);
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public ByteBuffer get4x3(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x3(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4f invertPerspective() {
        return invertPerspective(thisOrNew());
    }

    public Matrix4f obliqueZ(float f2, float f3, Matrix4f matrix4f) {
        matrix4f.m00 = this.m00;
        matrix4f.m01 = this.m01;
        matrix4f.m02 = this.m02;
        matrix4f.m03 = this.m03;
        matrix4f.m10 = this.m10;
        matrix4f.m11 = this.m11;
        matrix4f.m12 = this.m12;
        matrix4f.m13 = this.m13;
        matrix4f.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        matrix4f.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        matrix4f.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        matrix4f.m23 = this.m23;
        matrix4f.m30 = this.m30;
        matrix4f.m31 = this.m31;
        matrix4f.m32 = this.m32;
        matrix4f.m33 = this.m33;
        matrix4f._properties(this.properties & 2);
        return matrix4f;
    }

    public Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return ortho(f2, f3, f4, f5, f6, f7, z, thisOrNew());
    }

    public Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return orthoLH(f2, f3, f4, f5, f6, f7, z, thisOrNew());
    }

    public Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z) {
        return orthoSymmetric(f2, f3, f4, f5, z, thisOrNew());
    }

    public Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z) {
        return orthoSymmetricLH(f2, f3, f4, f5, z, thisOrNew());
    }

    public Matrix4f perspective(float f2, float f3, float f4, float f5, boolean z) {
        return perspective(f2, f3, f4, f5, z, thisOrNew());
    }

    public Matrix4f perspectiveLH(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return perspectiveLH(f2, f3, f4, f5, false, matrix4f);
    }

    public Matrix4f reflect(float f2, float f3, float f4, float f5) {
        return reflect(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f rotateLocal(Quaternionfc quaternionfc, Matrix4f matrix4f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4f matrix4f2 = matrix4f;
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
        float f5 = (-a2) + f2;
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
        float f18 = this.m03;
        float f19 = this.m10;
        float f20 = b4 * f19;
        float f21 = f18;
        float f22 = this.m11;
        float f23 = (f5 * f22) + f20;
        float f24 = f17;
        float f25 = this.m12;
        float f26 = f15;
        float f27 = (f7 * f25) + f23;
        float f28 = (f8 * f25) + (c2 * f22) + (f3 * f19);
        float f29 = f25 * d2;
        float f30 = f29 + (f22 * f6) + (f19 * f4);
        float f31 = this.m13;
        float f32 = this.m20;
        float f33 = b4 * f32;
        float f34 = f31;
        float f35 = this.m21;
        float f36 = (f5 * f35) + f33;
        float f37 = f30;
        float f38 = this.m22;
        float f39 = f28;
        float f40 = (f7 * f38) + f36;
        float f41 = (f8 * f38) + (c2 * f35) + (f3 * f32);
        float f42 = f38 * d2;
        float f43 = f42 + (f35 * f6) + (f32 * f4);
        float f44 = this.m23;
        float f45 = this.m30;
        float f46 = b4 * f45;
        float f47 = f44;
        float f48 = this.m31;
        float f49 = (f5 * f48) + f46;
        float f50 = this.m32;
        float f51 = (f7 * f50) + f49;
        float f52 = f8 * f50;
        float f53 = f52 + (c2 * f48) + (f3 * f45);
        float f54 = d2 * f50;
        float f55 = f54 + (f6 * f48) + (f4 * f45);
        float f56 = this.m33;
        matrix4f2._m00(f14);
        matrix4f2._m01(f26);
        matrix4f2._m02(f24);
        matrix4f2._m03(f21);
        a.a(matrix4f2, f27, f39, f37, f34);
        a.b(matrix4f2, f40, f41, f43, f47);
        a.c(matrix4f2, f51, f53, f55, f56);
        matrix4f2._properties(this.properties & -14);
        return matrix4f2;
    }

    public Matrix4f scale(float f2, float f3, float f4, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.scaling(f2, f3, f4);
        }
        return scaleGeneric(f2, f3, f4, matrix4f);
    }

    public Matrix4f scaleLocal(float f2) {
        return scaleLocal(f2, thisOrNew());
    }

    public Matrix4f set(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy((Matrix4x3f) matrix4x3fc, this);
        } else {
            setMatrix4x3fc(matrix4x3fc);
        }
        _properties(matrix4x3fc.properties() | 2);
        return this;
    }

    public Matrix4f set4x3(Matrix4f matrix4f) {
        MemUtil.INSTANCE.copy4x3(matrix4f, this);
        this.properties = matrix4f.properties & -2 & this.properties;
        return this;
    }

    public Matrix4f setTranslation(Vector3fc vector3fc) {
        return setTranslation(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f frustum(float f2, float f3, float f4, float f5, float f6, float f7) {
        return frustum(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f frustumLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return frustumLH(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            MemUtil.INSTANCE.putColumn0(this, vector3f);
        } else if (i2 == 1) {
            MemUtil.INSTANCE.putColumn1(this, vector3f);
        } else if (i2 == 2) {
            MemUtil.INSTANCE.putColumn2(this, vector3f);
        } else if (i2 == 3) {
            MemUtil.INSTANCE.putColumn3(this, vector3f);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3f;
    }

    public Matrix4f invertFrustum() {
        return invertFrustum(thisOrNew());
    }

    public Matrix4f invertOrtho() {
        return invertOrtho(thisOrNew());
    }

    public Matrix4f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
        return lookAlong(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix3f normal(Matrix3f matrix3f) {
        if ((this.properties & 16) != 0) {
            return normalOrthonormal(matrix3f);
        }
        return normalGeneric(matrix3f);
    }

    public Matrix4f ortho(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ortho(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return orthoLH(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4f orthoSymmetric(float f2, float f3, float f4, float f5) {
        return orthoSymmetric(f2, f3, f4, f5, false, thisOrNew());
    }

    public Matrix4f orthoSymmetricLH(float f2, float f3, float f4, float f5) {
        return orthoSymmetricLH(f2, f3, f4, f5, false, thisOrNew());
    }

    public Matrix4f perspective(float f2, float f3, float f4, float f5) {
        return perspective(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f perspectiveLH(float f2, float f3, float f4, float f5) {
        return perspectiveLH(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f reflect(float f2, float f3, float f4, float f5, float f6, float f7) {
        return reflect(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f rotate(float f2, float f3, float f4, float f5) {
        return rotate(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f rotateZ(float f2) {
        return rotateZ(f2, thisOrNew());
    }

    public Matrix4f scaleLocal(float f2, float f3, float f4) {
        return scaleLocal(f2, f3, f4, thisOrNew());
    }

    public Matrix4f translate(float f2, float f3, float f4) {
        if ((this.properties & 4) != 0) {
            return translation(f2, f3, f4);
        }
        _m30((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30);
        _m31((this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31);
        _m32((this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32);
        _m33((this.m23 * f4) + (this.m13 * f3) + (this.m03 * f2) + this.m33);
        this.properties &= -6;
        return this;
    }

    public Matrix4f translateLocal(float f2, float f3, float f4) {
        return translateLocal(f2, f3, f4, thisOrNew());
    }

    public Matrix4f(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy3x3((Matrix3f) matrix3fc, this);
        } else {
            set3x3Matrix3fc(matrix3fc);
        }
        this.m33 = 1.0f;
        this.properties = 2;
    }

    public float[] get(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(this, fArr, i2);
        return fArr;
    }

    public Matrix4f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return lookAt(f2, f3, f4, f5, f6, f7, f8, f9, f10, thisOrNew());
    }

    public Matrix4f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return lookAtLH(f2, f3, f4, f5, f6, f7, f8, f9, f10, thisOrNew());
    }

    public Matrix4f reflect(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4f matrix4f) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = sqrt * f4;
        return reflect(f8, f9, f10, (((-f8) * f5) - (f6 * f9)) - (f7 * f10), matrix4f);
    }

    public Matrix4f rotate(Quaternionfc quaternionfc, Matrix4f matrix4f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4f.rotation(quaternionfc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaternionfc, matrix4f);
        }
        if ((i2 & 2) != 0) {
            return rotateAffine(quaternionfc, matrix4f);
        }
        return rotateGeneric(quaternionfc, matrix4f);
    }

    public Matrix4f translation(Vector3fc vector3fc) {
        return translation(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Planef frustumPlane(int i2, Planef planef) {
        if (i2 == 0) {
            planef.set(this.m03 + this.m00, this.m13 + this.m10, this.m23 + this.m20, this.m33 + this.m30).normalize(planef);
        } else if (i2 == 1) {
            planef.set(this.m03 - this.m00, this.m13 - this.m10, this.m23 - this.m20, this.m33 - this.m30).normalize(planef);
        } else if (i2 == 2) {
            planef.set(this.m03 + this.m01, this.m13 + this.m11, this.m23 + this.m21, this.m33 + this.m31).normalize(planef);
        } else if (i2 == 3) {
            planef.set(this.m03 - this.m01, this.m13 - this.m11, this.m23 - this.m21, this.m33 - this.m31).normalize(planef);
        } else if (i2 == 4) {
            planef.set(this.m03 + this.m02, this.m13 + this.m12, this.m23 + this.m22, this.m33 + this.m32).normalize(planef);
        } else if (i2 == 5) {
            planef.set(this.m03 - this.m02, this.m13 - this.m12, this.m23 - this.m22, this.m33 - this.m32).normalize(planef);
        } else {
            throw new IllegalArgumentException("which");
        }
        return planef;
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix4f invert() {
        return invert(thisOrNew());
    }

    public Matrix4f scale(float f2, float f3, float f4) {
        return scale(f2, f3, f4, thisOrNew());
    }

    public Matrix4f setOrthoSymmetric(float f2, float f3, float f4, float f5) {
        return setOrthoSymmetric(f2, f3, f4, f5, false);
    }

    public Matrix4f setOrthoSymmetricLH(float f2, float f3, float f4, float f5) {
        return setOrthoSymmetricLH(f2, f3, f4, f5, false);
    }

    public Vector3f transformProject(Vector3f vector3f) {
        return vector3f.mulProject(this);
    }

    public Matrix3f normalize3x3(Matrix3f matrix3f) {
        float f2 = this.m00;
        float f3 = f2 * f2;
        float f4 = this.m01;
        float f5 = (f4 * f4) + f3;
        float f6 = this.m02;
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f6 * f6) + f5)));
        float f7 = this.m10;
        float f8 = f7 * f7;
        float f9 = this.m11;
        float f10 = (f9 * f9) + f8;
        float f11 = this.m12;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((f11 * f11) + f10)));
        float f12 = this.m20;
        float f13 = f12 * f12;
        float f14 = this.m21;
        float f15 = (f14 * f14) + f13;
        float f16 = this.m22;
        float sqrt3 = (float) (1.0d / Math.sqrt((double) ((f16 * f16) + f15)));
        matrix3f.m00(this.m00 * sqrt);
        matrix3f.m01(this.m01 * sqrt);
        matrix3f.m02(this.m02 * sqrt);
        matrix3f.m10(this.m10 * sqrt2);
        matrix3f.m11(this.m11 * sqrt2);
        matrix3f.m12(this.m12 * sqrt2);
        matrix3f.m20(this.m20 * sqrt3);
        matrix3f.m21(this.m21 * sqrt3);
        matrix3f.m22(this.m22 * sqrt3);
        return matrix3f;
    }

    public Vector3f project(float f2, float f3, float f4, int[] iArr, Vector3f vector3f) {
        float f5 = 1.0f / (((this.m23 * f4) + ((this.m13 * f3) + (this.m03 * f2))) + this.m33);
        float f6 = ((this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30) * f5;
        float f7 = ((this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31) * f5;
        float f8 = ((this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32) * f5;
        vector3f.x = (((f6 * 0.5f) + 0.5f) * ((float) iArr[2])) + ((float) iArr[0]);
        vector3f.y = (((f7 * 0.5f) + 0.5f) * ((float) iArr[3])) + ((float) iArr[1]);
        vector3f.z = (f8 + 1.0f) * 0.5f;
        return vector3f;
    }

    public Matrix4f reflect(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return reflect(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4f scaling(Vector3fc vector3fc) {
        return scaling(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f set(Matrix4dc matrix4dc) {
        _m00((float) matrix4dc.m00());
        _m01((float) matrix4dc.m01());
        _m02((float) matrix4dc.m02());
        _m03((float) matrix4dc.m03());
        _m10((float) matrix4dc.m10());
        _m11((float) matrix4dc.m11());
        _m12((float) matrix4dc.m12());
        _m13((float) matrix4dc.m13());
        _m20((float) matrix4dc.m20());
        _m21((float) matrix4dc.m21());
        _m22((float) matrix4dc.m22());
        _m23((float) matrix4dc.m23());
        _m30((float) matrix4dc.m30());
        _m31((float) matrix4dc.m31());
        _m32((float) matrix4dc.m32());
        _m33((float) matrix4dc.m33());
        _properties(matrix4dc.properties());
        return this;
    }

    public Vector3f transformProject(Vector3fc vector3fc, Vector3f vector3f) {
        return vector3fc.mulProject(this, vector3f);
    }

    public Vector3f unprojectInv(Vector3fc vector3fc, int[] iArr, Vector3f vector3f) {
        return unprojectInv(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector3f);
    }

    public Matrix4f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc) {
        return reflect(quaternionfc, vector3fc, thisOrNew());
    }

    public Matrix4f setOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setOrtho(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4f setOrthoLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setOrthoLH(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4f transformAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f, Vector3f vector3f2) {
        return transformAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3f, vector3f2);
    }

    public Vector3f transformProject(float f2, float f3, float f4, Vector3f vector3f) {
        vector3f.x = f2;
        vector3f.y = f3;
        vector3f.z = f4;
        return vector3f.mulProject(this);
    }

    public Vector3f unprojectInv(float f2, float f3, float f4, int[] iArr, Vector3f vector3f) {
        float f5 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f6 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f7 = (f4 + f4) - 1.0f;
        float f8 = 1.0f / (((this.m23 * f7) + ((this.m13 * f6) + (this.m03 * f5))) + this.m33);
        vector3f.x = ((this.m20 * f7) + (this.m10 * f6) + (this.m00 * f5) + this.m30) * f8;
        vector3f.y = ((this.m21 * f7) + (this.m11 * f6) + (this.m01 * f5) + this.m31) * f8;
        vector3f.z = ((this.m22 * f7) + (this.m12 * f6) + (this.m02 * f5) + this.m32) * f8;
        return vector3f;
    }

    public Matrix4f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc, Matrix4f matrix4f) {
        double x = (double) (quaternionfc.x() + quaternionfc.x());
        double y = (double) (quaternionfc.y() + quaternionfc.y());
        double z = (double) (quaternionfc.z() + quaternionfc.z());
        return reflect((float) ((((double) quaternionfc.w()) * y) + (((double) quaternionfc.x()) * z)), (float) ((((double) quaternionfc.y()) * z) - (((double) quaternionfc.w()) * x)), (float) a.j((double) quaternionfc.y(), y, ((double) quaternionfc.x()) * x, 1.0d), vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4f);
    }

    public String toString(NumberFormat numberFormat) {
        StringBuilder sb = new StringBuilder();
        String str = " ";
        a.b(numberFormat, (double) this.m00, sb, str);
        a.b(numberFormat, (double) this.m10, sb, str);
        a.b(numberFormat, (double) this.m20, sb, str);
        String str2 = "\n";
        a.b(numberFormat, (double) this.m30, sb, str2);
        a.b(numberFormat, (double) this.m01, sb, str);
        a.b(numberFormat, (double) this.m11, sb, str);
        a.b(numberFormat, (double) this.m21, sb, str);
        a.b(numberFormat, (double) this.m31, sb, str2);
        a.b(numberFormat, (double) this.m02, sb, str);
        a.b(numberFormat, (double) this.m12, sb, str);
        a.b(numberFormat, (double) this.m22, sb, str);
        a.b(numberFormat, (double) this.m32, sb, str2);
        a.b(numberFormat, (double) this.m03, sb, str);
        a.b(numberFormat, (double) this.m13, sb, str);
        a.b(numberFormat, (double) this.m23, sb, str);
        return a.a(numberFormat, (double) this.m33, sb, str2);
    }

    public Matrix4f unprojectRay(Vector2fc vector2fc, int[] iArr, Vector3f vector3f, Vector3f vector3f2) {
        return unprojectRay(vector2fc.x(), vector2fc.y(), iArr, vector3f, vector3f2);
    }

    public Matrix4f rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, thisOrNew());
    }

    public Matrix4f(Matrix4fc matrix4fc) {
        if (matrix4fc instanceof Matrix4f) {
            MemUtil.INSTANCE.copy((Matrix4f) matrix4fc, this);
        } else {
            setMatrix4fc(matrix4fc);
        }
        this.properties = matrix4fc.properties();
    }

    public Matrix4f invertAffine() {
        return invertAffine(thisOrNew());
    }

    public Matrix4f rotate(AxisAngle4f axisAngle4f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Vector3f unproject(float f2, float f3, float f4, int[] iArr, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        float f5 = this.m00;
        float f6 = this.m11;
        float f7 = f5 * f6;
        float f8 = this.m01;
        float f9 = this.m10;
        float f10 = f7 - (f8 * f9);
        float f11 = this.m12;
        float f12 = f5 * f11;
        float f13 = this.m02;
        float f14 = f12 - (f13 * f9);
        float f15 = this.m13;
        float f16 = f5 * f15;
        float f17 = this.m03;
        float f18 = f16 - (f17 * f9);
        float f19 = (f8 * f11) - (f13 * f6);
        float f20 = (f8 * f15) - (f17 * f6);
        float f21 = (f13 * f15) - (f17 * f11);
        float f22 = this.m20;
        float f23 = f5;
        float f24 = this.m31;
        float f25 = f22 * f24;
        float f26 = f9;
        float f27 = this.m21;
        float f28 = f17;
        float f29 = this.m30;
        float f30 = f13;
        float f31 = f25 - (f27 * f29);
        float f32 = f8;
        float f33 = this.m32;
        float f34 = f22 * f33;
        float f35 = f15;
        float f36 = this.m22;
        float f37 = f11;
        float f38 = f34 - (f36 * f29);
        float f39 = f6;
        float f40 = this.m33;
        float f41 = f22 * f40;
        float f42 = f22;
        float f43 = this.m23;
        float f44 = f41 - (f43 * f29);
        float f45 = (f27 * f33) - (f36 * f24);
        float f46 = (f27 * f40) - (f43 * f24);
        float f47 = (f36 * f40) - (f43 * f33);
        float f48 = f10;
        float f49 = f14;
        float h2 = a.h(f21, f31, ((f19 * f44) + ((f18 * f45) + ((f10 * f47) - (f14 * f46)))) - (f20 * f38), 1.0f);
        float f50 = f31;
        float f51 = f35;
        float g2 = a.g(f51, f45, (f39 * f47) - (f37 * f46), h2);
        float f52 = f32;
        float f53 = f18;
        float f54 = (f30 * f46) + ((-f52) * f47);
        float f55 = f52;
        float f56 = f28;
        float i2 = a.i(f56, f45, f54, h2);
        float g3 = a.g(f40, f19, (f24 * f21) - (f33 * f20), h2);
        float i3 = a.i(f43, f19, (f36 * f20) + ((-f27) * f21), h2);
        float f57 = f26;
        float f58 = f19;
        float i4 = a.i(f51, f38, (f37 * f44) + ((-f57) * f47), h2);
        float g4 = a.g(f56, f38, (f47 * f23) - (f30 * f44), h2);
        float f59 = (f33 * f53) + ((-f29) * f21);
        float f60 = f33;
        float f61 = f49;
        float i5 = a.i(f40, f61, f59, h2);
        float f62 = (f57 * f46) - (f39 * f44);
        float g5 = a.g(f43, f61, (f21 * f42) - (f36 * f53), h2);
        float f63 = f50;
        float g6 = a.g(f51, f63, f62, h2);
        float f64 = f23;
        float f65 = g6;
        float i6 = a.i(f56, f63, (f44 * f55) + ((-f64) * f46), h2);
        float f66 = f48;
        float g7 = a.g(f40, f66, (f29 * f20) - (f24 * f53), h2);
        float f67 = f42;
        float f68 = g7;
        float i7 = a.i(f43, f66, (f53 * f27) + ((-f67) * f20), h2);
        float i8 = a.i(f37, f63, (f39 * f38) + ((-f57) * f45), h2);
        float g8 = a.g(f30, f63, (f45 * f64) - (f38 * f55), h2);
        float i9 = a.i(f60, f66, (f24 * f61) + ((-f29) * f58), h2);
        float g9 = a.g(f36, f66, (f67 * f58) - (f27 * f61), h2);
        float f69 = (((f2 - ((float) iArr[0])) / ((float) iArr[2])) * 2.0f) - 1.0f;
        float f70 = (((f3 - ((float) iArr[1])) / ((float) iArr[3])) * 2.0f) - 1.0f;
        float f71 = (f4 + f4) - 1.0f;
        float f72 = i7 * f71;
        float f73 = 1.0f / ((f72 + ((g5 * f70) + (i3 * f69))) + g9);
        float f74 = f65 * f71;
        Vector3f vector3f3 = vector3f;
        vector3f3.x = (f74 + (i4 * f70) + (g2 * f69) + i8) * f73;
        float f75 = i6 * f71;
        vector3f3.y = (f75 + (g4 * f70) + (i2 * f69) + g8) * f73;
        float f76 = f68 * f71;
        vector3f3.z = (f76 + (i5 * f70) + (g3 * f69) + i9) * f73;
        return vector3f3;
    }

    private Matrix3f normalGeneric(Matrix3f matrix3f) {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m10;
        float f7 = f5 * f6;
        float f8 = this.m02;
        float f9 = f6 * f8;
        float f10 = this.m12;
        float f11 = f2 * f10;
        float f12 = f5 * f10;
        float f13 = f8 * f3;
        float f14 = f4 - f7;
        float f15 = this.m22;
        float f16 = f14 * f15;
        float f17 = f9 - f11;
        float f18 = this.m21;
        float f19 = f12 - f13;
        float h2 = a.h(this.m20, f19, (f17 * f18) + f16, 1.0f);
        matrix3f.m00(((f3 * f15) - (f18 * f10)) * h2);
        matrix3f.m01(((this.m20 * this.m12) - (this.m10 * this.m22)) * h2);
        matrix3f.m02(((this.m10 * this.m21) - (this.m20 * this.m11)) * h2);
        matrix3f.m10(((this.m21 * this.m02) - (this.m01 * this.m22)) * h2);
        matrix3f.m11(((this.m00 * this.m22) - (this.m20 * this.m02)) * h2);
        matrix3f.m12(((this.m20 * this.m01) - (this.m00 * this.m21)) * h2);
        matrix3f.m20(f19 * h2);
        matrix3f.m21(f17 * h2);
        matrix3f.m22(f14 * h2);
        return matrix3f;
    }

    public Matrix4f rotate(AxisAngle4f axisAngle4f, Matrix4f matrix4f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z, matrix4f);
    }

    public Matrix4f mul(Matrix4x3fc matrix4x3fc) {
        return mul(matrix4x3fc, thisOrNew());
    }

    public Matrix4f rotate(float f2, Vector3fc vector3fc) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f setPerspective(float f2, float f3, float f4, float f5) {
        return setPerspective(f2, f3, f4, f5, false);
    }

    public Matrix4f setPerspectiveLH(float f2, float f3, float f4, float f5) {
        return setPerspectiveLH(f2, f3, f4, f5, false);
    }

    public Matrix4f translationRotate(float f2, float f3, float f4, Quaternionfc quaternionfc) {
        return translationRotate(f2, f3, f4, quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w());
    }

    public Matrix4f mul(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f) {
        if ((this.properties & 4) != 0) {
            return matrix4f.set(matrix4x3fc);
        }
        if ((matrix4x3fc.properties() & 4) != 0) {
            return matrix4f.set((Matrix4fc) this);
        }
        if ((this.properties & 1) == 0 || (matrix4x3fc.properties() & 2) == 0) {
            return mulGeneric(matrix4x3fc, matrix4f);
        }
        return mulPerspectiveAffine(matrix4x3fc, matrix4f);
    }

    public Vector4f project(Vector3fc vector3fc, int[] iArr, Vector4f vector4f) {
        return project(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector4f);
    }

    public Matrix4f rotate(float f2, Vector3fc vector3fc, Matrix4f matrix4f) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4f);
    }

    public Vector3f project(Vector3fc vector3fc, int[] iArr, Vector3f vector3f) {
        return project(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector3f);
    }

    public Matrix4f rotation(Quaternionfc quaternionfc) {
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
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        _m00(((w + x) - z) - y);
        _m01(f2 + a2);
        _m02(b2 - a3);
        _m10((-a2) + f2);
        _m11(((y - z) + w) - x);
        _m12(b3 + a4);
        _m20(a3 + b2);
        _m21(b3 - a4);
        _m22(((z - y) - x) + w);
        _properties(18);
        return this;
    }

    public Matrix4f(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy4x3((Matrix4x3f) matrix4x3fc, this);
        } else {
            set4x3Matrix4x3fc(matrix4x3fc);
        }
        this.m33 = 1.0f;
        this.properties = matrix4x3fc.properties() | 2;
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
        } else if (i2 == 3) {
            vector3f.x = this.m03;
            vector3f.y = this.m13;
            vector3f.z = this.m23;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3f;
    }

    public Matrix4f pick(float f2, float f3, float f4, float f5, int[] iArr) {
        return pick(f2, f3, f4, f5, iArr, thisOrNew());
    }

    public Matrix4f reflect(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4f matrix4f) {
        return reflect(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4f);
    }

    public Matrix4f reflection(float f2, float f3, float f4, float f5, float f6, float f7) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = f4 * sqrt;
        return reflection(f8, f9, f10, (((-f8) * f5) - (f6 * f9)) - (f7 * f10));
    }

    public Matrix4f setFrustum(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setFrustum(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4f setFrustumLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setFrustumLH(f2, f3, f4, f5, f6, f7, false);
    }

    public boolean equals(Matrix4fc matrix4fc, float f2) {
        if (this == matrix4fc) {
            return true;
        }
        return matrix4fc != null && (matrix4fc instanceof Matrix4f) && Runtime.equals(this.m00, matrix4fc.m00(), f2) && Runtime.equals(this.m01, matrix4fc.m01(), f2) && Runtime.equals(this.m02, matrix4fc.m02(), f2) && Runtime.equals(this.m03, matrix4fc.m03(), f2) && Runtime.equals(this.m10, matrix4fc.m10(), f2) && Runtime.equals(this.m11, matrix4fc.m11(), f2) && Runtime.equals(this.m12, matrix4fc.m12(), f2) && Runtime.equals(this.m13, matrix4fc.m13(), f2) && Runtime.equals(this.m20, matrix4fc.m20(), f2) && Runtime.equals(this.m21, matrix4fc.m21(), f2) && Runtime.equals(this.m22, matrix4fc.m22(), f2) && Runtime.equals(this.m23, matrix4fc.m23(), f2) && Runtime.equals(this.m30, matrix4fc.m30(), f2) && Runtime.equals(this.m31, matrix4fc.m31(), f2) && Runtime.equals(this.m32, matrix4fc.m32(), f2) && Runtime.equals(this.m33, matrix4fc.m33(), f2);
    }

    public Matrix4f rotateTranslation(Quaternionfc quaternionfc, Matrix4f matrix4f) {
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
        float b4 = a.b(w, x, z, y);
        float f3 = f2 + a2;
        float f4 = b2 - a3;
        float f5 = (-a2) + f2;
        float c2 = a.c(y, z, w, x);
        float f6 = b3 + a4;
        float f7 = b3 - a4;
        float f8 = ((z - y) - x) + w;
        matrix4f._m20(a3 + b2);
        matrix4f._m21(f7);
        matrix4f._m22(f8);
        matrix4f._m23(0.0f);
        matrix4f._m00(b4);
        matrix4f._m01(f3);
        matrix4f._m02(f4);
        matrix4f._m03(0.0f);
        matrix4f._m10(f5);
        matrix4f._m11(c2);
        matrix4f._m12(f6);
        matrix4f._m13(0.0f);
        matrix4f._m30(this.m30);
        matrix4f._m31(this.m31);
        matrix4f._m32(this.m32);
        matrix4f._m33(this.m33);
        matrix4f._properties(this.properties & -14);
        return matrix4f;
    }

    public Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5, float f6, float f7) {
        return scaleAroundLocal(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScale(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4f billboardSpherical(Vector3fc vector3fc, Vector3fc vector3fc2) {
        float x = vector3fc2.x() - vector3fc.x();
        float y = vector3fc2.y() - vector3fc.y();
        float z = vector3fc2.z() - vector3fc.z();
        float f2 = -y;
        float f3 = x * x;
        float sqrt = ((float) Math.sqrt((double) ((z * z) + (y * y) + f3))) + z;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((sqrt * sqrt) + ((f2 * f2) + f3))));
        float f4 = f2 * sqrt2;
        float f5 = x * sqrt2;
        float f6 = sqrt * sqrt2;
        float f7 = f4 + f4;
        float f8 = f4 * f7;
        float f9 = f5 + f5;
        float f10 = f9 * f5;
        float f11 = f5 * f7;
        float f12 = f7 * f6;
        float f13 = f9 * f6;
        float f14 = 1.0f - f10;
        _m00(f14);
        _m01(f11);
        _m02(-f13);
        _m03(0.0f);
        _m10(f11);
        _m11(1.0f - f8);
        _m12(f12);
        _m13(0.0f);
        _m20(f13);
        _m21(-f12);
        _m22(f14 - f8);
        _m23(0.0f);
        _m30(vector3fc.x());
        _m31(vector3fc.y());
        _m32(vector3fc.z());
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f reflection(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return reflection(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5) {
        return scaleAroundLocal(f2, f2, f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f shadow(Vector4f vector4f, Matrix4fc matrix4fc, Matrix4f matrix4f) {
        float m102 = matrix4fc.m10();
        float m112 = matrix4fc.m11();
        float m122 = matrix4fc.m12();
        return shadow(vector4f.x, vector4f.y, vector4f.z, vector4f.w, m102, m112, m122, ((matrix4fc.m30() * (-m102)) - (matrix4fc.m31() * m112)) - (matrix4fc.m32() * m122), matrix4f);
    }

    public Matrix4f translationRotateScale(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return translationRotateScale(f2, f3, f4, f5, f6, f7, f8, f9, f9, f9);
    }

    public Matrix4f translationRotateScaleInvert(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScaleInvert(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    private Matrix4f rotateGeneric(Quaternionfc quaternionfc, Matrix4f matrix4f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4f matrix4f2 = matrix4f;
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
        float f5 = (-a2) + f2;
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
        float f24 = f23 * b4;
        float f25 = f8;
        float f26 = this.m12;
        float f27 = (f26 * f3) + f24;
        float f28 = f7;
        float f29 = this.m22;
        float f30 = f29;
        float f31 = (f29 * f4) + f27;
        float f32 = this.m03;
        float f33 = b4 * f32;
        float f34 = f32;
        float f35 = this.m13;
        float f36 = (f3 * f35) + f33;
        float f37 = this.m23;
        float f38 = (f4 * f37) + f36;
        float f39 = (f13 * f6) + (f11 * c2) + (f9 * f5);
        float f40 = f20 * f6;
        float f41 = f40 + (f18 * c2) + (f15 * f5);
        float f42 = (f30 * f6) + (f26 * c2) + (f23 * f5);
        float f43 = f37 * f6;
        float f44 = f43 + (f35 * c2) + (f5 * f34);
        float f45 = f13 * f21;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f45 + (f11 * f25) + (f9 * f28));
        matrix4f3._m21((this.m21 * f21) + (this.m11 * f25) + (this.m01 * f28));
        matrix4f3._m22((this.m22 * f21) + (this.m12 * f25) + (this.m02 * f28));
        matrix4f3._m23((this.m23 * f21) + (this.m13 * f25) + (this.m03 * f28));
        matrix4f3._m00(f17);
        matrix4f3._m01(f22);
        matrix4f3._m02(f31);
        matrix4f3._m03(f38);
        a.a(matrix4f3, f39, f41, f42, f44);
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f reflection(Quaternionfc quaternionfc, Vector3fc vector3fc) {
        double x = (double) (quaternionfc.x() + quaternionfc.x());
        double y = (double) (quaternionfc.y() + quaternionfc.y());
        double z = (double) (quaternionfc.z() + quaternionfc.z());
        return reflection((float) ((((double) quaternionfc.w()) * y) + (((double) quaternionfc.x()) * z)), (float) ((((double) quaternionfc.y()) * z) - (((double) quaternionfc.w()) * x)), (float) a.j((double) quaternionfc.y(), y, ((double) quaternionfc.x()) * x, 1.0d), vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4f scaleAroundLocal(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return scaleAroundLocal(f2, f2, f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, float f2) {
        return translationRotateScale(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), f2, f2, f2);
    }

    public Matrix4f translationRotateScaleInvert(Vector3fc vector3fc, Quaternionfc quaternionfc, float f2) {
        return translationRotateScaleInvert(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), f2, f2, f2);
    }

    public Matrix3f transpose3x3(Matrix3f matrix3f) {
        matrix3f.m00(this.m00);
        matrix3f.m01(this.m10);
        matrix3f.m02(this.m20);
        matrix3f.m10(this.m01);
        matrix3f.m11(this.m11);
        matrix3f.m12(this.m21);
        matrix3f.m20(this.m02);
        matrix3f.m21(this.m12);
        matrix3f.m22(this.m22);
        return matrix3f;
    }

    public Matrix4f mul(Matrix3x2fc matrix3x2fc) {
        return mul(matrix3x2fc, thisOrNew());
    }

    public Matrix4f rotateAffine(float f2, float f3, float f4, float f5) {
        return rotateAffine(f2, f3, f4, f5, thisOrNew());
    }

    public Matrix4f scaleAround(float f2, float f3, float f4, float f5, float f6, float f7) {
        return scaleAround(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f translationRotateScaleMulAffine(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2, Matrix4f matrix4f) {
        return translationRotateScaleMulAffine(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4f);
    }

    public Matrix4f(Matrix4dc matrix4dc) {
        this.m00 = (float) matrix4dc.m00();
        this.m01 = (float) matrix4dc.m01();
        this.m02 = (float) matrix4dc.m02();
        this.m03 = (float) matrix4dc.m03();
        this.m10 = (float) matrix4dc.m10();
        this.m11 = (float) matrix4dc.m11();
        this.m12 = (float) matrix4dc.m12();
        this.m13 = (float) matrix4dc.m13();
        this.m20 = (float) matrix4dc.m20();
        this.m21 = (float) matrix4dc.m21();
        this.m22 = (float) matrix4dc.m22();
        this.m23 = (float) matrix4dc.m23();
        this.m30 = (float) matrix4dc.m30();
        this.m31 = (float) matrix4dc.m31();
        this.m32 = (float) matrix4dc.m32();
        this.m33 = (float) matrix4dc.m33();
        this.properties = matrix4dc.properties();
    }

    public Matrix4f mul(Matrix3x2fc matrix3x2fc, Matrix4f matrix4f) {
        float m012 = (matrix3x2fc.m01() * this.m10) + (matrix3x2fc.m00() * this.m00);
        float m013 = (matrix3x2fc.m01() * this.m11) + (matrix3x2fc.m00() * this.m01);
        float m014 = (matrix3x2fc.m01() * this.m12) + (matrix3x2fc.m00() * this.m02);
        float m015 = (matrix3x2fc.m01() * this.m13) + (matrix3x2fc.m00() * this.m03);
        float m112 = (matrix3x2fc.m11() * this.m10) + (matrix3x2fc.m10() * this.m00);
        float m113 = (matrix3x2fc.m11() * this.m11) + (matrix3x2fc.m10() * this.m01);
        float m114 = (matrix3x2fc.m11() * this.m12) + (matrix3x2fc.m10() * this.m02);
        float m115 = (matrix3x2fc.m11() * this.m13) + (matrix3x2fc.m10() * this.m03);
        float m212 = (matrix3x2fc.m21() * this.m10) + (matrix3x2fc.m20() * this.m00) + this.m30;
        float m213 = (matrix3x2fc.m21() * this.m11) + (matrix3x2fc.m20() * this.m01) + this.m31;
        float m214 = (matrix3x2fc.m21() * this.m12) + (matrix3x2fc.m20() * this.m02) + this.m32;
        float m215 = (matrix3x2fc.m21() * this.m13) + (matrix3x2fc.m20() * this.m03) + this.m33;
        matrix4f._m00(m012);
        matrix4f._m01(m013);
        matrix4f._m02(m014);
        matrix4f._m03(m015);
        a.a(matrix4f, m112, m113, m114, m115);
        matrix4f._m20(this.m20);
        matrix4f._m21(this.m21);
        matrix4f._m22(this.m22);
        matrix4f._m23(this.m23);
        matrix4f._m30(m212);
        matrix4f._m31(m213);
        matrix4f._m32(m214);
        matrix4f._m33(m215);
        matrix4f._properties(this.properties & -30);
        return matrix4f;
    }

    public Matrix4f rotateAffine(Quaternionfc quaternionfc, Matrix4f matrix4f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4f matrix4f2 = matrix4f;
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
        float f5 = (-a2) + f2;
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
        float f31 = f20 * f6;
        float f32 = f31 + (f18 * c2) + (f15 * f5);
        float f33 = f28 * f6;
        float f34 = f33 + (f26 * c2) + (f23 * f5);
        float f35 = f13 * f21;
        Matrix4f matrix4f3 = matrix4f;
        matrix4f3._m20(f35 + (f11 * f25) + (f9 * f7));
        matrix4f3._m21((this.m21 * f21) + (this.m11 * f25) + (this.m01 * f7));
        matrix4f3._m22((this.m22 * f21) + (this.m12 * f25) + (this.m02 * f7));
        matrix4f3._m23(0.0f);
        matrix4f3._m00(f17);
        matrix4f3._m01(f22);
        matrix4f3._m02(f29);
        matrix4f3._m03(0.0f);
        matrix4f3._m10(f30);
        matrix4f3._m11(f32);
        matrix4f3._m12(f34);
        matrix4f3._m13(0.0f);
        matrix4f3._m30(this.m30);
        matrix4f3._m31(this.m31);
        matrix4f3._m32(this.m32);
        matrix4f3._m33(this.m33);
        matrix4f3._properties(this.properties & -14);
        return matrix4f3;
    }

    public Matrix4f rotateLocalX(float f2) {
        return rotateLocalX(f2, thisOrNew());
    }

    public Matrix4f rotateLocalY(float f2) {
        return rotateLocalY(f2, thisOrNew());
    }

    public Matrix4f rotateLocalZ(float f2) {
        return rotateLocalZ(f2, thisOrNew());
    }

    public Matrix4f scaleAround(float f2, float f3, float f4, float f5) {
        return scaleAround(f2, f2, f2, f3, f4, f5, thisOrNew());
    }

    public Vector4f unproject(Vector3fc vector3fc, int[] iArr, Vector4f vector4f) {
        return unproject(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector4f);
    }

    public Matrix4f scaleAround(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return scaleAround(f2, f2, f2, f3, f4, f5, matrix4f);
    }

    public Matrix4f shadow(Vector4f vector4f, Matrix4f matrix4f) {
        return shadow(vector4f, matrix4f, thisOrNew());
    }

    public Vector3f unproject(Vector3fc vector3fc, int[] iArr, Vector3f vector3f) {
        return unproject(vector3fc.x(), vector3fc.y(), vector3fc.z(), iArr, vector3f);
    }

    public Matrix4f rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, thisOrNew());
    }

    public Matrix4f rotateX(float f2) {
        return rotateX(f2, thisOrNew());
    }

    public Matrix4f rotateY(float f2) {
        return rotateY(f2, thisOrNew());
    }

    public Matrix4f set(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy((Matrix3f) matrix3fc, this);
        } else {
            setMatrix3fc(matrix3fc);
        }
        _properties(2);
        return this;
    }

    public Matrix4f shadow(float f2, float f3, float f4, float f5, Matrix4fc matrix4fc, Matrix4f matrix4f) {
        float m102 = matrix4fc.m10();
        float m112 = matrix4fc.m11();
        float m122 = matrix4fc.m12();
        return shadow(f2, f3, f4, f5, m102, m112, m122, ((matrix4fc.m30() * (-m102)) - (matrix4fc.m31() * m112)) - (matrix4fc.m32() * m122), matrix4f);
    }

    public Matrix4f invertPerspectiveView(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = 1.0f / (f2 * f3);
        float f5 = this.m23;
        float f6 = this.m32;
        float f7 = -1.0f / (f5 * f6);
        float f8 = f3 * f4;
        float f9 = f2 * f4;
        float f10 = (-f5) * f7;
        float f11 = (-f6) * f7;
        float f12 = this.m22 * f7;
        float m302 = ((matrix4x3fc.m30() * (-matrix4x3fc.m00())) - (matrix4x3fc.m31() * matrix4x3fc.m01())) - (matrix4x3fc.m32() * matrix4x3fc.m02());
        float m303 = ((matrix4x3fc.m30() * (-matrix4x3fc.m10())) - (matrix4x3fc.m31() * matrix4x3fc.m11())) - (matrix4x3fc.m32() * matrix4x3fc.m12());
        float m304 = ((matrix4x3fc.m30() * (-matrix4x3fc.m20())) - (matrix4x3fc.m31() * matrix4x3fc.m21())) - (matrix4x3fc.m32() * matrix4x3fc.m22());
        float m002 = matrix4x3fc.m00() * f8;
        float m102 = matrix4x3fc.m10() * f8;
        float m202 = matrix4x3fc.m20() * f8;
        float m012 = matrix4x3fc.m01() * f9;
        float m112 = matrix4x3fc.m11() * f9;
        float m212 = matrix4x3fc.m21() * f9;
        float f13 = m302 * f10;
        float f14 = m303 * f10;
        float f15 = m304 * f10;
        float m022 = (m302 * f12) + (matrix4x3fc.m02() * f11);
        float m122 = (m303 * f12) + (matrix4x3fc.m12() * f11);
        float m222 = (m304 * f12) + (matrix4x3fc.m22() * f11);
        matrix4f2.m00 = m002;
        matrix4f2.m01 = m102;
        matrix4f2.m02 = m202;
        matrix4f2.m03 = 0.0f;
        matrix4f2.m10 = m012;
        matrix4f2.m11 = m112;
        matrix4f2.m12 = m212;
        matrix4f2.m13 = 0.0f;
        matrix4f2.m20 = f13;
        matrix4f2.m21 = f14;
        matrix4f2.m22 = f15;
        matrix4f2.m23 = f10;
        matrix4f2.m30 = m022;
        matrix4f2.m31 = m122;
        matrix4f2.m32 = m222;
        matrix4f2.m33 = f12;
        matrix4f2._properties(0);
        return matrix4f2;
    }

    public Matrix4f set(AxisAngle4f axisAngle4f) {
        float f2 = axisAngle4f.x;
        float f3 = axisAngle4f.y;
        float f4 = axisAngle4f.z;
        double d2 = (double) axisAngle4f.angle;
        double sqrt = 1.0d / Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2))));
        float f5 = (float) (((double) f2) * sqrt);
        float f6 = (float) (((double) f3) * sqrt);
        float f7 = (float) (((double) f4) * sqrt);
        double sin = Math.sin(d2);
        double cosFromSin = Math.cosFromSin(sin, d2);
        double d3 = 1.0d - cosFromSin;
        _m00((float) ((((double) (f5 * f5)) * d3) + cosFromSin));
        _m11((float) ((((double) (f6 * f6)) * d3) + cosFromSin));
        _m22((float) ((((double) (f7 * f7)) * d3) + cosFromSin));
        double d4 = ((double) (f5 * f6)) * d3;
        double d5 = ((double) f7) * sin;
        _m10((float) (d4 - d5));
        _m01((float) (d4 + d5));
        double d6 = ((double) (f5 * f7)) * d3;
        double d7 = ((double) f6) * sin;
        _m20((float) (d6 + d7));
        _m02((float) (d6 - d7));
        double d8 = ((double) (f6 * f7)) * d3;
        double d9 = ((double) f5) * sin;
        _m21((float) (d8 - d9));
        _m12((float) (d8 + d9));
        _m03(0.0f);
        _m13(0.0f);
        _m23(0.0f);
        a.c(this, 0.0f, 0.0f, 0.0f, 1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f arcball(float f2, Vector3fc vector3fc, float f3, float f4, Matrix4f matrix4f) {
        return arcball(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), f3, f4, matrix4f);
    }

    public Matrix4f shadow(float f2, float f3, float f4, float f5, Matrix4f matrix4f) {
        return shadow(f2, f3, f4, f5, (Matrix4fc) matrix4f, thisOrNew());
    }

    public Matrix4f arcball(float f2, float f3, float f4, float f5, float f6, float f7) {
        return arcball(f2, f3, f4, f5, f6, f7, thisOrNew());
    }

    public Matrix4f arcball(float f2, Vector3fc vector3fc, float f3, float f4) {
        return arcball(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), f3, f4, thisOrNew());
    }

    private Matrix4f mulGeneric(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m022 = (matrix4x3fc.m02() * this.m20) + (matrix4x3fc.m01() * this.m10) + (matrix4x3fc.m00() * this.m00);
        float m023 = (matrix4x3fc.m02() * this.m21) + (matrix4x3fc.m01() * this.m11) + (matrix4x3fc.m00() * this.m01);
        float m024 = (matrix4x3fc.m02() * this.m22) + (matrix4x3fc.m01() * this.m12) + (matrix4x3fc.m00() * this.m02);
        float m025 = (matrix4x3fc.m02() * this.m23) + (matrix4x3fc.m01() * this.m13) + (matrix4x3fc.m00() * this.m03);
        float m122 = (matrix4x3fc.m12() * this.m20) + (matrix4x3fc.m11() * this.m10) + (matrix4x3fc.m10() * this.m00);
        float m123 = (matrix4x3fc.m12() * this.m21) + (matrix4x3fc.m11() * this.m11) + (matrix4x3fc.m10() * this.m01);
        float m124 = (matrix4x3fc.m12() * this.m22) + (matrix4x3fc.m11() * this.m12) + (matrix4x3fc.m10() * this.m02);
        float m125 = (matrix4x3fc.m12() * this.m23) + (matrix4x3fc.m11() * this.m13) + (matrix4x3fc.m10() * this.m03);
        float m222 = (matrix4x3fc.m22() * this.m20) + (matrix4x3fc.m21() * this.m10) + (matrix4x3fc.m20() * this.m00);
        float m223 = (matrix4x3fc.m22() * this.m21) + (matrix4x3fc.m21() * this.m11) + (matrix4x3fc.m20() * this.m01);
        float m224 = (matrix4x3fc.m22() * this.m22) + (matrix4x3fc.m21() * this.m12) + (matrix4x3fc.m20() * this.m02);
        float m225 = (matrix4x3fc.m22() * this.m23) + (matrix4x3fc.m21() * this.m13) + (matrix4x3fc.m20() * this.m03);
        float m322 = (matrix4x3fc.m32() * this.m20) + (matrix4x3fc.m31() * this.m10) + (matrix4x3fc.m30() * this.m00) + this.m30;
        float m323 = (matrix4x3fc.m32() * this.m21) + (matrix4x3fc.m31() * this.m11) + (matrix4x3fc.m30() * this.m01) + this.m31;
        float m324 = (matrix4x3fc.m32() * this.m22) + (matrix4x3fc.m31() * this.m12) + (matrix4x3fc.m30() * this.m02) + this.m32;
        float m325 = (matrix4x3fc.m32() * this.m23) + (matrix4x3fc.m31() * this.m13) + (matrix4x3fc.m30() * this.m03) + this.m33;
        matrix4f2._m00(m022);
        matrix4f2._m01(m023);
        matrix4f2._m02(m024);
        matrix4f2._m03(m025);
        a.a(matrix4f2, m122, m123, m124, m125);
        a.b(matrix4f2, m222, m223, m224, m225);
        a.c(matrix4f2, m322, m323, m324, m325);
        matrix4f2._properties(this.properties & -30);
        return matrix4f2;
    }

    public Matrix4f mulPerspectiveAffine(Matrix4x3fc matrix4x3fc) {
        return mulPerspectiveAffine(matrix4x3fc, thisOrNew());
    }

    public Matrix4f mulPerspectiveAffine(Matrix4x3fc matrix4x3fc, Matrix4f matrix4f) {
        Matrix4f matrix4f2 = matrix4f;
        float m002 = matrix4x3fc.m00() * this.m00;
        float m012 = matrix4x3fc.m01() * this.m11;
        float m022 = matrix4x3fc.m02() * this.m22;
        float m023 = matrix4x3fc.m02() * this.m23;
        float m102 = matrix4x3fc.m10() * this.m00;
        float m112 = matrix4x3fc.m11() * this.m11;
        float m122 = matrix4x3fc.m12() * this.m22;
        float m123 = matrix4x3fc.m12() * this.m23;
        float m202 = matrix4x3fc.m20() * this.m00;
        float m212 = matrix4x3fc.m21() * this.m11;
        float m222 = matrix4x3fc.m22() * this.m22;
        float m223 = matrix4x3fc.m22() * this.m23;
        float m302 = matrix4x3fc.m30() * this.m00;
        float m312 = this.m11 * matrix4x3fc.m31();
        float m322 = (matrix4x3fc.m32() * this.m22) + this.m32;
        float m323 = this.m23 * matrix4x3fc.m32();
        matrix4f2._m00(m002);
        matrix4f2._m01(m012);
        matrix4f2._m02(m022);
        matrix4f2._m03(m023);
        matrix4f2._m10(m102);
        matrix4f2._m11(m112);
        matrix4f2._m12(m122);
        matrix4f2._m13(m123);
        matrix4f2._m20(m202);
        matrix4f2._m21(m212);
        matrix4f2._m22(m222);
        matrix4f2._m23(m223);
        matrix4f2._m30(m302);
        matrix4f2._m31(m312);
        matrix4f2._m32(m322);
        matrix4f2._m33(m323);
        matrix4f2._properties(0);
        return matrix4f2;
    }

    public Matrix4f rotateAroundLocal(Quaternionfc quaternionfc, float f2, float f3, float f4) {
        return rotateAroundLocal(quaternionfc, f2, f3, f4, thisOrNew());
    }

    public Matrix4f(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        _m00(f2);
        float f18 = f3;
        _m01(f3);
        float f19 = f4;
        _m02(f4);
        float f20 = f5;
        _m03(f5);
        float f21 = f6;
        float f22 = f7;
        float f23 = f8;
        float f24 = f9;
        a.a(this, f6, f7, f8, f9);
        float f25 = f10;
        float f26 = f11;
        a.b(this, f10, f11, f12, f13);
        _m30(f14);
        _m31(f15);
        _m32(f16);
        _m33(f17);
        determineProperties();
    }

    public Matrix4f rotateAffine(Quaternionfc quaternionfc) {
        return rotateAffine(quaternionfc, thisOrNew());
    }

    public Matrix4f set(AxisAngle4d axisAngle4d) {
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
        _m00((float) a.d(d7, d7, d10, cosFromSin));
        _m11((float) ((d8 * d8 * d10) + cosFromSin));
        _m22((float) ((d9 * d9 * d10) + cosFromSin));
        double d11 = d7 * d8 * d10;
        double d12 = d9 * sin;
        _m10((float) (d11 - d12));
        _m01((float) (d11 + d12));
        double d13 = d7 * d9 * d10;
        double d14 = d8 * sin;
        _m20((float) (d13 + d14));
        _m02((float) (d13 - d14));
        double d15 = d8 * d9 * d10;
        double d16 = d7 * sin;
        _m21((float) (d15 - d16));
        _m12((float) (d15 + d16));
        _m03(0.0f);
        _m13(0.0f);
        _m23(0.0f);
        a.c(this, 0.0f, 0.0f, 0.0f, 1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        determineProperties();
    }

    public Matrix4f(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4fc vector4fc3, Vector4fc vector4fc4) {
        if (!(vector4fc instanceof Vector4f) || !(vector4fc2 instanceof Vector4f) || !(vector4fc3 instanceof Vector4f) || !(vector4fc4 instanceof Vector4f)) {
            setVector4fc(vector4fc, vector4fc2, vector4fc3, vector4fc4);
        } else {
            MemUtil.INSTANCE.set(this, (Vector4f) vector4fc, (Vector4f) vector4fc2, (Vector4f) vector4fc3, (Vector4f) vector4fc4);
        }
        determineProperties();
    }

    public Matrix4f set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix4f set(Quaterniondc quaterniondc) {
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
        double d2 = x;
        double d3 = w2;
        _m00((float) a.b(w, x, z, y));
        _m01((float) (y2 + d3 + d3 + y2));
        _m02((float) (((z2 - w3) + z2) - w3));
        _m03(0.0f);
        _m10((float) ((((-d3) + y2) - d3) + y2));
        _m11((float) (((y - z) + w) - d2));
        double d4 = z3 + z3;
        _m12((float) (d4 + w4 + w4));
        _m13(0.0f);
        _m20((float) (w3 + z2 + z2 + w3));
        _m21((float) ((d4 - w4) - w4));
        _m22((float) (((z - y) - d2) + w));
        _m30(0.0f);
        _m31(0.0f);
        _m32(0.0f);
        _m33(1.0f);
        _properties(18);
        return this;
    }

    public Matrix4f set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        _m00(f2);
        float f18 = f6;
        _m10(f6);
        float f19 = f10;
        _m20(f10);
        float f20 = f14;
        _m30(f14);
        float f21 = f3;
        _m01(f3);
        float f22 = f7;
        _m11(f7);
        float f23 = f11;
        _m21(f11);
        _m31(f15);
        float f24 = f4;
        _m02(f4);
        float f25 = f8;
        _m12(f8);
        float f26 = f12;
        _m22(f12);
        _m32(f16);
        float f27 = f5;
        _m03(f5);
        float f28 = f9;
        _m13(f9);
        float f29 = f13;
        _m23(f13);
        _m33(f17);
        _properties(0);
        return this;
    }

    public Matrix4f set(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(fArr, i2, this);
        _properties(0);
        return this;
    }

    public Matrix4f set(float[] fArr) {
        return set(fArr, 0);
    }

    public Matrix4f set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        _properties(0);
        return this;
    }

    public Matrix4f set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        _properties(0);
        return this;
    }

    public Matrix4f set(Vector4fc vector4fc, Vector4fc vector4fc2, Vector4fc vector4fc3, Vector4fc vector4fc4) {
        if (!(vector4fc instanceof Vector4f) || !(vector4fc2 instanceof Vector4f) || !(vector4fc3 instanceof Vector4f) || !(vector4fc4 instanceof Vector4f)) {
            setVector4fc(vector4fc, vector4fc2, vector4fc3, vector4fc4);
        } else {
            MemUtil.INSTANCE.set(this, (Vector4f) vector4fc, (Vector4f) vector4fc2, (Vector4f) vector4fc3, (Vector4f) vector4fc4);
        }
        _properties(0);
        return this;
    }
}
