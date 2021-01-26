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

public class Matrix4x3f implements Externalizable, Matrix4x3fc {
    public static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;
    public float m30;
    public float m31;
    public float m32;
    public int properties;

    public Matrix4x3f() {
        this.m00 = 1.0f;
        this.m11 = 1.0f;
        this.m22 = 1.0f;
        this.properties = 28;
    }

    private Matrix4x3f invertGeneric(Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f45 = (f33 - f35) * h2;
        float f46 = f14 * h2;
        float f47 = this.m31;
        float f48 = f26 * f47;
        float f49 = f45;
        float f50 = this.m32;
        float f51 = (f29 * f50) + (f48 - (f27 * f50));
        float f52 = this.m30;
        float i2 = a.i(f31, f47, (f30 * f52) + (f51 - (f28 * f52)), h2);
        float f53 = f36 * f52;
        float i3 = a.i(f37, f47, f53 + (((f35 * f50) + ((f32 * f47) - (f33 * f50))) - (f34 * f52)), h2);
        float f54 = f21 * f50;
        float f55 = f19;
        float i4 = a.i(f55, f50, f54 + (((f25 * f47) + ((f13 * f52) - (f12 * f52))) - (f23 * f47)), h2);
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        matrix4x3f3.m00 = f38;
        matrix4x3f3.m01 = f39;
        matrix4x3f3.m02 = f40;
        matrix4x3f3.m10 = f41;
        matrix4x3f3.m11 = f42;
        matrix4x3f3.m12 = f43;
        matrix4x3f3.m20 = f44;
        matrix4x3f3.m21 = f49;
        matrix4x3f3.m22 = f46;
        matrix4x3f3.m30 = i2;
        matrix4x3f3.m31 = i3;
        matrix4x3f3.m32 = i4;
        matrix4x3f3.properties = 0;
        return matrix4x3f3;
    }

    private Matrix4x3f invertOrthonormal(Matrix4x3f matrix4x3f) {
        float f2 = this.m00;
        float f3 = this.m30;
        float f4 = f2 * f3;
        float f5 = this.m01;
        float f6 = this.m31;
        float f7 = (f5 * f6) + f4;
        float f8 = this.m02;
        float f9 = this.m32;
        float f10 = -((f8 * f9) + f7);
        float f11 = this.m10;
        float f12 = f11 * f3;
        float f13 = this.m11;
        float f14 = (f13 * f6) + f12;
        float f15 = this.m12;
        float f16 = -((f15 * f9) + f14);
        float f17 = this.m20;
        float f18 = f3 * f17;
        float f19 = this.m21;
        float f20 = (f6 * f19) + f18;
        float f21 = this.m22;
        float f22 = -((f9 * f21) + f20);
        matrix4x3f.m00 = f2;
        matrix4x3f.m01 = f11;
        matrix4x3f.m02 = f17;
        matrix4x3f.m10 = f5;
        matrix4x3f.m11 = f13;
        matrix4x3f.m12 = f19;
        matrix4x3f.m20 = f8;
        matrix4x3f.m21 = f15;
        matrix4x3f.m22 = f21;
        matrix4x3f.m30 = f10;
        matrix4x3f.m31 = f16;
        matrix4x3f.m32 = f22;
        matrix4x3f.properties = 16;
        return matrix4x3f;
    }

    private Matrix4x3f lookAtGeneric(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f30 = f29 * f26;
        float f31 = f16;
        float f32 = this.m10;
        float f33 = (f32 * f27) + f30;
        float f34 = this.m20;
        float f35 = f25;
        matrix4x3f2.m30 = (f34 * f28) + f33 + this.m30;
        float f36 = this.m01;
        float f37 = f36 * f26;
        float f38 = f22;
        float f39 = this.m11;
        float f40 = (f39 * f27) + f37;
        float f41 = f15;
        float f42 = this.m21;
        float f43 = f24;
        matrix4x3f2.m31 = (f42 * f28) + f40 + this.m31;
        float f44 = this.m02;
        float f45 = f26 * f44;
        float f46 = f21;
        float f47 = this.m12;
        float f48 = (f27 * f47) + f45;
        float f49 = this.m22;
        matrix4x3f2.m32 = (f28 * f49) + f48 + this.m32;
        float f50 = (f34 * f14) + (f32 * f23) + (f29 * f20);
        float f51 = (f42 * f14) + (f39 * f23) + (f36 * f20);
        float f52 = f14 * f49;
        float f53 = f52 + (f23 * f47) + (f20 * f44);
        float f54 = (f34 * f41) + (f32 * f43) + (f29 * f46);
        float f55 = (f42 * f41) + (f39 * f43) + (f36 * f46);
        float f56 = f41 * f49;
        float f57 = f56 + (f47 * f43) + (f44 * f46);
        float f58 = f34 * f31;
        matrix4x3f2.m20 = f58 + (f32 * f35) + (f29 * f38);
        float f59 = f42 * f31;
        matrix4x3f2.m21 = f59 + (f39 * f35) + (f36 * f38);
        float f60 = f49 * f31;
        matrix4x3f2.m22 = f60 + (f47 * f35) + (f44 * f38);
        matrix4x3f2.m00 = f50;
        matrix4x3f2.m01 = f51;
        matrix4x3f2.m02 = f53;
        matrix4x3f2.m10 = f54;
        matrix4x3f2.m11 = f55;
        matrix4x3f2.m12 = f57;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    private Matrix4x3f lookAtLHGeneric(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f30 = f29 * f26;
        float f31 = f16;
        float f32 = this.m10;
        float f33 = (f32 * f27) + f30;
        float f34 = this.m20;
        float f35 = f25;
        matrix4x3f2.m30 = (f34 * f28) + f33 + this.m30;
        float f36 = this.m01;
        float f37 = f36 * f26;
        float f38 = f22;
        float f39 = this.m11;
        float f40 = (f39 * f27) + f37;
        float f41 = f15;
        float f42 = this.m21;
        float f43 = f24;
        matrix4x3f2.m31 = (f42 * f28) + f40 + this.m31;
        float f44 = this.m02;
        float f45 = f26 * f44;
        float f46 = f21;
        float f47 = this.m12;
        float f48 = (f27 * f47) + f45;
        float f49 = this.m22;
        matrix4x3f2.m32 = (f28 * f49) + f48 + this.m32;
        float f50 = (f34 * f14) + (f32 * f23) + (f29 * f20);
        float f51 = (f42 * f14) + (f39 * f23) + (f36 * f20);
        float f52 = f14 * f49;
        float f53 = f52 + (f23 * f47) + (f20 * f44);
        float f54 = (f34 * f41) + (f32 * f43) + (f29 * f46);
        float f55 = (f42 * f41) + (f39 * f43) + (f36 * f46);
        float f56 = f41 * f49;
        float f57 = f56 + (f47 * f43) + (f44 * f46);
        float f58 = f34 * f31;
        matrix4x3f2.m20 = f58 + (f32 * f35) + (f29 * f38);
        float f59 = f42 * f31;
        matrix4x3f2.m21 = f59 + (f39 * f35) + (f36 * f38);
        float f60 = f49 * f31;
        matrix4x3f2.m22 = f60 + (f47 * f35) + (f44 * f38);
        matrix4x3f2.m00 = f50;
        matrix4x3f2.m01 = f51;
        matrix4x3f2.m02 = f53;
        matrix4x3f2.m10 = f54;
        matrix4x3f2.m11 = f55;
        matrix4x3f2.m12 = f57;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    private Matrix4x3f mulGeneric(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        float m022 = (matrix4x3fc.m02() * this.m20) + (matrix4x3fc.m01() * this.m10) + (matrix4x3fc.m00() * this.m00);
        float m023 = (matrix4x3fc.m02() * this.m21) + (matrix4x3fc.m01() * this.m11) + (matrix4x3fc.m00() * this.m01);
        float m024 = (matrix4x3fc.m02() * this.m22) + (matrix4x3fc.m01() * this.m12) + (matrix4x3fc.m00() * this.m02);
        float m122 = (matrix4x3fc.m12() * this.m20) + (matrix4x3fc.m11() * this.m10) + (matrix4x3fc.m10() * this.m00);
        float m123 = (matrix4x3fc.m12() * this.m21) + (matrix4x3fc.m11() * this.m11) + (matrix4x3fc.m10() * this.m01);
        float m124 = (matrix4x3fc.m12() * this.m22) + (matrix4x3fc.m11() * this.m12) + (matrix4x3fc.m10() * this.m02);
        float m222 = (matrix4x3fc.m22() * this.m20) + (matrix4x3fc.m21() * this.m10) + (matrix4x3fc.m20() * this.m00);
        float m223 = (matrix4x3fc.m22() * this.m21) + (matrix4x3fc.m21() * this.m11) + (matrix4x3fc.m20() * this.m01);
        float m224 = (matrix4x3fc.m22() * this.m22) + (matrix4x3fc.m21() * this.m12) + (matrix4x3fc.m20() * this.m02);
        float m322 = (matrix4x3fc.m32() * this.m20) + (matrix4x3fc.m31() * this.m10) + (matrix4x3fc.m30() * this.m00) + this.m30;
        float m323 = (matrix4x3fc.m32() * this.m21) + (matrix4x3fc.m31() * this.m11) + (matrix4x3fc.m30() * this.m01) + this.m31;
        float m324 = (matrix4x3fc.m32() * this.m22) + (matrix4x3fc.m31() * this.m12) + (matrix4x3fc.m30() * this.m02) + this.m32;
        matrix4x3f2.m00 = m022;
        matrix4x3f2.m01 = m023;
        matrix4x3f2.m02 = m024;
        matrix4x3f2.m10 = m122;
        matrix4x3f2.m11 = m123;
        matrix4x3f2.m12 = m124;
        matrix4x3f2.m20 = m222;
        matrix4x3f2.m21 = m223;
        matrix4x3f2.m22 = m224;
        matrix4x3f2.m30 = m322;
        matrix4x3f2.m31 = m323;
        matrix4x3f2.m32 = m324;
        matrix4x3f2.properties = this.properties & matrix4x3fc.properties() & 16;
        return matrix4x3f2;
    }

    private Matrix4x3f normalGeneric(Matrix4x3f matrix4x3f) {
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
        matrix4x3f.m00 = i2;
        matrix4x3f.m01 = i3;
        matrix4x3f.m02 = i4;
        matrix4x3f.m10 = i5;
        matrix4x3f.m11 = i6;
        matrix4x3f.m12 = i7;
        matrix4x3f.m20 = f22;
        matrix4x3f.m21 = f23;
        matrix4x3f.m22 = f24;
        matrix4x3f.m30 = 0.0f;
        matrix4x3f.m31 = 0.0f;
        matrix4x3f.m32 = 0.0f;
        matrix4x3f.properties = 16;
        return matrix4x3f;
    }

    private Matrix4x3f normalOrthonormal(Matrix4x3f matrix4x3f) {
        if (matrix4x3f != this) {
            matrix4x3f.set((Matrix4x3fc) this);
        }
        matrix4x3f.properties = 16;
        return matrix4x3f;
    }

    private Matrix4x3f rotateAroundAffine(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f8 = f5 - a2;
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
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        matrix4x3f3._m20(f46 + (f14 * f29) + (f12 * f32));
        matrix4x3f3._m21((this.m21 * f25) + (this.m11 * f29) + (this.m01 * f32));
        matrix4x3f3._m22((this.m22 * f25) + (this.m12 * f29) + (this.m02 * f32));
        float f47 = f37;
        matrix4x3f3._m00(f47);
        matrix4x3f3._m01(f38);
        matrix4x3f3._m02(f40);
        matrix4x3f3._m10(f41);
        matrix4x3f3._m11(f43);
        matrix4x3f3._m12(f45);
        matrix4x3f3._m30(((((-f47) * f2) - (f41 * f3)) - (this.m20 * f4)) + f20);
        matrix4x3f3._m31(((((-f38) * f2) - (f43 * f3)) - (this.m21 * f4)) + f26);
        matrix4x3f3._m32(((((-f40) * f2) - (f45 * f3)) - (this.m22 * f4)) + f36);
        matrix4x3f3.properties = this.properties & -13;
        return matrix4x3f3;
    }

    private Matrix4x3f rotateGeneric(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f44 = f33;
        float f45 = (f33 * f18) + (f31 * f15) + (f28 * f14);
        float f46 = f18 * f41;
        float f47 = f46 + (f15 * f39) + (f14 * f36);
        float f48 = f26 * f34;
        float f49 = f48 + (f24 * f38) + (f22 * f19);
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        float f50 = f44;
        matrix4x3f3.m20 = f49;
        float f51 = f50 * f34;
        matrix4x3f3.m21 = f51 + (f31 * f38) + (f28 * f19);
        float f52 = f41 * f34;
        matrix4x3f3.m22 = f52 + (f39 * f38) + (f36 * f19);
        matrix4x3f3.m00 = f30;
        matrix4x3f3.m01 = f35;
        matrix4x3f3.m02 = f42;
        matrix4x3f3.m10 = f43;
        matrix4x3f3.m11 = f45;
        matrix4x3f3.m12 = f47;
        matrix4x3f3.m30 = this.m30;
        matrix4x3f3.m31 = this.m31;
        matrix4x3f3.m32 = this.m32;
        matrix4x3f3.properties = this.properties & -13;
        return matrix4x3f3;
    }

    private Matrix4x3f scaleGeneric(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = this.m00 * f2;
        matrix4x3f.m01 = this.m01 * f2;
        matrix4x3f.m02 = this.m02 * f2;
        matrix4x3f.m10 = this.m10 * f3;
        matrix4x3f.m11 = this.m11 * f3;
        matrix4x3f.m12 = this.m12 * f3;
        matrix4x3f.m20 = this.m20 * f4;
        matrix4x3f.m21 = this.m21 * f4;
        matrix4x3f.m22 = this.m22 * f4;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
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

    private void set3x3Matrix4x3fc(Matrix4x3fc matrix4x3fc) {
        this.m00 = matrix4x3fc.m00();
        this.m01 = matrix4x3fc.m01();
        this.m02 = matrix4x3fc.m02();
        this.m10 = matrix4x3fc.m10();
        this.m11 = matrix4x3fc.m11();
        this.m12 = matrix4x3fc.m12();
        this.m20 = matrix4x3fc.m20();
        this.m21 = matrix4x3fc.m21();
        this.m22 = matrix4x3fc.m22();
    }

    private void setMatrix3fc(Matrix3fc matrix3fc) {
        this.m00 = matrix3fc.m00();
        this.m01 = matrix3fc.m01();
        this.m02 = matrix3fc.m02();
        this.m10 = matrix3fc.m10();
        this.m11 = matrix3fc.m11();
        this.m12 = matrix3fc.m12();
        this.m20 = matrix3fc.m20();
        this.m21 = matrix3fc.m21();
        this.m22 = matrix3fc.m22();
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
    }

    private void setMatrix4fc(Matrix4fc matrix4fc) {
        this.m00 = matrix4fc.m00();
        this.m01 = matrix4fc.m01();
        this.m02 = matrix4fc.m02();
        this.m10 = matrix4fc.m10();
        this.m11 = matrix4fc.m11();
        this.m12 = matrix4fc.m12();
        this.m20 = matrix4fc.m20();
        this.m21 = matrix4fc.m21();
        this.m22 = matrix4fc.m22();
        this.m30 = matrix4fc.m30();
        this.m31 = matrix4fc.m31();
        this.m32 = matrix4fc.m32();
    }

    private void setMatrix4x3fc(Matrix4x3fc matrix4x3fc) {
        this.m00 = matrix4x3fc.m00();
        this.m01 = matrix4x3fc.m01();
        this.m02 = matrix4x3fc.m02();
        this.m10 = matrix4x3fc.m10();
        this.m11 = matrix4x3fc.m11();
        this.m12 = matrix4x3fc.m12();
        this.m20 = matrix4x3fc.m20();
        this.m21 = matrix4x3fc.m21();
        this.m22 = matrix4x3fc.m22();
        this.m30 = matrix4x3fc.m30();
        this.m31 = matrix4x3fc.m31();
        this.m32 = matrix4x3fc.m32();
    }

    private void setVector3fc(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4) {
        this.m00 = vector3fc.x();
        this.m01 = vector3fc.y();
        this.m02 = vector3fc.z();
        this.m10 = vector3fc2.x();
        this.m11 = vector3fc2.y();
        this.m12 = vector3fc2.z();
        this.m20 = vector3fc3.x();
        this.m21 = vector3fc3.y();
        this.m22 = vector3fc3.z();
        this.m30 = vector3fc4.x();
        this.m31 = vector3fc4.y();
        this.m32 = vector3fc4.z();
    }

    private Matrix4x3f translateGeneric(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        MemUtil.INSTANCE.copy(this, matrix4x3f);
        matrix4x3f.m30 = (this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30;
        matrix4x3f.m31 = (this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31;
        matrix4x3f.m32 = (this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32;
        matrix4x3f.properties = this.properties & -5;
        return matrix4x3f;
    }

    public Matrix4x3f _m00(float f2) {
        this.m00 = f2;
        return this;
    }

    public Matrix4x3f _m01(float f2) {
        this.m01 = f2;
        return this;
    }

    public Matrix4x3f _m02(float f2) {
        this.m02 = f2;
        return this;
    }

    public Matrix4x3f _m10(float f2) {
        this.m10 = f2;
        return this;
    }

    public Matrix4x3f _m11(float f2) {
        this.m11 = f2;
        return this;
    }

    public Matrix4x3f _m12(float f2) {
        this.m12 = f2;
        return this;
    }

    public Matrix4x3f _m20(float f2) {
        this.m20 = f2;
        return this;
    }

    public Matrix4x3f _m21(float f2) {
        this.m21 = f2;
        return this;
    }

    public Matrix4x3f _m22(float f2) {
        this.m22 = f2;
        return this;
    }

    public Matrix4x3f _m30(float f2) {
        this.m30 = f2;
        return this;
    }

    public Matrix4x3f _m31(float f2) {
        this.m31 = f2;
        return this;
    }

    public Matrix4x3f _m32(float f2) {
        this.m32 = f2;
        return this;
    }

    public Matrix4x3f add(Matrix4x3fc matrix4x3fc) {
        return add(matrix4x3fc, this);
    }

    public Matrix4x3f arcball(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        float f8 = -f2;
        float f9 = (this.m20 * f8) + this.m30;
        float f10 = (this.m21 * f8) + this.m31;
        float f11 = (this.m22 * f8) + this.m32;
        double d2 = (double) f6;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f12 = this.m10;
        float f13 = f12 * cosFromSin;
        float f14 = this.m20;
        float f15 = (f14 * sin) + f13;
        float f16 = this.m11;
        float f17 = f16 * cosFromSin;
        float f18 = this.m21;
        float f19 = (f18 * sin) + f17;
        float f20 = this.m12;
        float f21 = f20 * cosFromSin;
        float f22 = this.m22;
        float f23 = (f22 * sin) + f21;
        float f24 = (f14 * cosFromSin) - (f12 * sin);
        float f25 = (f18 * cosFromSin) - (f16 * sin);
        float f26 = (f22 * cosFromSin) - (f20 * sin);
        double d3 = (double) f7;
        float f27 = f10;
        float sin2 = (float) Math.sin(d3);
        float f28 = f11;
        float cosFromSin2 = (float) Math.cosFromSin((double) sin2, d3);
        float f29 = this.m00;
        float f30 = (f29 * cosFromSin2) - (f24 * sin2);
        float f31 = this.m01;
        float f32 = (f31 * cosFromSin2) - (f25 * sin2);
        float f33 = f28;
        float f34 = this.m02;
        float f35 = (f34 * cosFromSin2) - (f26 * sin2);
        float f36 = (f24 * cosFromSin2) + (f29 * sin2);
        float f37 = (f25 * cosFromSin2) + (f31 * sin2);
        float f38 = (f26 * cosFromSin2) + (f34 * sin2);
        matrix4x3f2.m30 = ((((-f30) * f3) - (f15 * f4)) - (f36 * f5)) + f9;
        matrix4x3f2.m31 = ((((-f32) * f3) - (f19 * f4)) - (f37 * f5)) + f27;
        matrix4x3f2.m32 = ((((-f35) * f3) - (f23 * f4)) - (f38 * f5)) + f33;
        matrix4x3f2.m20 = f36;
        matrix4x3f2.m21 = f37;
        matrix4x3f2.m22 = f38;
        matrix4x3f2.m10 = f15;
        matrix4x3f2.m11 = f19;
        matrix4x3f2.m12 = f23;
        matrix4x3f2.m00 = f30;
        matrix4x3f2.m01 = f32;
        matrix4x3f2.m02 = f35;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f assume(int i2) {
        this.properties = i2;
        return this;
    }

    public Matrix4x3f billboardCylindrical(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
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
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = vector3fc3.x();
        this.m11 = vector3fc3.y();
        this.m12 = vector3fc3.z();
        this.m20 = f5;
        this.m21 = f6;
        this.m22 = f7;
        this.m30 = vector3fc.x();
        this.m31 = vector3fc.y();
        this.m32 = vector3fc.z();
        this.properties = 16;
        return this;
    }

    public Matrix4x3f billboardSpherical(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
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
        this.m00 = f5;
        this.m01 = f6;
        this.m02 = f7;
        this.m10 = f8;
        this.m11 = f9;
        this.m12 = f10;
        this.m20 = f2;
        this.m21 = f3;
        this.m22 = f4;
        this.m30 = vector3fc.x();
        this.m31 = vector3fc.y();
        this.m32 = vector3fc.z();
        this.properties = 16;
        return this;
    }

    public float determinant() {
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

    public Matrix4x3f determineProperties() {
        int i2;
        if (this.m00 == 1.0f && this.m01 == 0.0f && this.m02 == 0.0f && this.m10 == 0.0f && this.m11 == 1.0f && this.m12 == 0.0f && this.m20 == 0.0f && this.m21 == 0.0f && this.m22 == 1.0f) {
            i2 = 24;
            if (this.m30 == 0.0f && this.m31 == 0.0f && this.m32 == 0.0f) {
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
        if (obj == null || !(obj instanceof Matrix4x3f)) {
            return false;
        }
        Matrix4x3f matrix4x3f = (Matrix4x3f) obj;
        return Float.floatToIntBits(this.m00) == Float.floatToIntBits(matrix4x3f.m00) && Float.floatToIntBits(this.m01) == Float.floatToIntBits(matrix4x3f.m01) && Float.floatToIntBits(this.m02) == Float.floatToIntBits(matrix4x3f.m02) && Float.floatToIntBits(this.m10) == Float.floatToIntBits(matrix4x3f.m10) && Float.floatToIntBits(this.m11) == Float.floatToIntBits(matrix4x3f.m11) && Float.floatToIntBits(this.m12) == Float.floatToIntBits(matrix4x3f.m12) && Float.floatToIntBits(this.m20) == Float.floatToIntBits(matrix4x3f.m20) && Float.floatToIntBits(this.m21) == Float.floatToIntBits(matrix4x3f.m21) && Float.floatToIntBits(this.m22) == Float.floatToIntBits(matrix4x3f.m22) && Float.floatToIntBits(this.m30) == Float.floatToIntBits(matrix4x3f.m30) && Float.floatToIntBits(this.m31) == Float.floatToIntBits(matrix4x3f.m31) && Float.floatToIntBits(this.m32) == Float.floatToIntBits(matrix4x3f.m32);
    }

    public Matrix4x3f fma(Matrix4x3fc matrix4x3fc, float f2) {
        return fma(matrix4x3fc, f2, this);
    }

    public Planef frustumPlane(int i2, Planef planef) {
        if (i2 == 0) {
            planef.set(this.m00, this.m10, this.m20, this.m30 + 1.0f).normalize(planef);
        } else if (i2 == 1) {
            planef.set(-this.m00, -this.m10, -this.m20, 1.0f - this.m30).normalize(planef);
        } else if (i2 == 2) {
            planef.set(this.m01, this.m11, this.m21, this.m31 + 1.0f).normalize(planef);
        } else if (i2 == 3) {
            planef.set(-this.m01, -this.m11, -this.m21, 1.0f - this.m31).normalize(planef);
        } else if (i2 == 4) {
            planef.set(this.m02, this.m12, this.m22, this.m32 + 1.0f).normalize(planef);
        } else if (i2 == 5) {
            planef.set(-this.m02, -this.m12, -this.m22, 1.0f - this.m32).normalize(planef);
        } else {
            throw new IllegalArgumentException("which");
        }
        return planef;
    }

    public Matrix4f get(Matrix4f matrix4f) {
        return matrix4f.set4x3((Matrix4x3fc) this);
    }

    public float[] get4x4(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy4x4(this, fArr, i2);
        return fArr;
    }

    public Vector3f getColumn(int i2, Vector3f vector3f) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            vector3f.x = this.m00;
            vector3f.y = this.m01;
            vector3f.z = this.m02;
        } else if (i2 == 1) {
            vector3f.x = this.m10;
            vector3f.y = this.m11;
            vector3f.z = this.m12;
        } else if (i2 == 2) {
            vector3f.x = this.m20;
            vector3f.y = this.m21;
            vector3f.z = this.m22;
        } else if (i2 == 3) {
            vector3f.x = this.m30;
            vector3f.y = this.m31;
            vector3f.z = this.m32;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return vector3f;
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
        return quaternionf.setFromNormalized((Matrix4x3fc) this);
    }

    public AxisAngle4f getRotation(AxisAngle4f axisAngle4f) {
        return axisAngle4f.set((Matrix4x3fc) this);
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
        return quaternionf.setFromUnnormalized((Matrix4x3fc) this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.m32) + a.a(this.m31, a.a(this.m30, a.a(this.m22, a.a(this.m21, a.a(this.m20, a.a(this.m12, a.a(this.m11, a.a(this.m10, a.a(this.m02, a.a(this.m01, a.a(this.m00, 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public Matrix4x3f identity() {
        if ((this.properties & 4) != 0) {
            return this;
        }
        MemUtil.INSTANCE.identity(this);
        this.properties = 28;
        return this;
    }

    public Matrix4x3f invert(Matrix4x3f matrix4x3f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f.identity();
        }
        if ((i2 & 16) != 0) {
            return invertOrthonormal(matrix4x3f);
        }
        return invertGeneric(matrix4x3f);
    }

    public Matrix4x3f invertOrtho(Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        float f2 = 1.0f / this.m00;
        float f3 = 1.0f / this.m11;
        float f4 = 1.0f / this.m22;
        matrix4x3f.set(f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, f4, (-this.m30) * f2, (-this.m31) * f3, (-this.m32) * f4);
        matrix4x3f2.properties = 0;
        return matrix4x3f2;
    }

    public Matrix4x3f lerp(Matrix4x3fc matrix4x3fc, float f2) {
        return lerp(matrix4x3fc, f2, this);
    }

    public Matrix4x3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public Matrix4x3f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4x3f matrix4x3f) {
        return lookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), matrix4x3f);
    }

    public Matrix4x3f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Matrix4x3f matrix4x3f) {
        return lookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), matrix4x3f);
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

    public float m10() {
        return this.m10;
    }

    public float m11() {
        return this.m11;
    }

    public float m12() {
        return this.m12;
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

    public float m30() {
        return this.m30;
    }

    public float m31() {
        return this.m31;
    }

    public float m32() {
        return this.m32;
    }

    public Matrix4x3f mul(Matrix4x3fc matrix4x3fc) {
        return mul(matrix4x3fc, this);
    }

    public Matrix4x3f mulComponentWise(Matrix4x3fc matrix4x3fc) {
        return mulComponentWise(matrix4x3fc, this);
    }

    public Matrix4x3f mulOrtho(Matrix4x3fc matrix4x3fc) {
        return mulOrtho(matrix4x3fc, this);
    }

    public Matrix4x3f mulTranslation(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        float m002 = matrix4x3fc.m00();
        float m012 = matrix4x3fc.m01();
        float m022 = matrix4x3fc.m02();
        float m102 = matrix4x3fc.m10();
        float m112 = matrix4x3fc.m11();
        float m122 = matrix4x3fc.m12();
        float m202 = matrix4x3fc.m20();
        float m212 = matrix4x3fc.m21();
        float m222 = matrix4x3fc.m22();
        float m302 = matrix4x3fc.m30() + this.m30;
        float m312 = matrix4x3fc.m31() + this.m31;
        float m322 = matrix4x3fc.m32() + this.m32;
        matrix4x3f.m00 = m002;
        matrix4x3f.m01 = m012;
        matrix4x3f.m02 = m022;
        matrix4x3f.m10 = m102;
        matrix4x3f.m11 = m112;
        matrix4x3f.m12 = m122;
        matrix4x3f.m20 = m202;
        matrix4x3f.m21 = m212;
        matrix4x3f.m22 = m222;
        matrix4x3f.m30 = m302;
        matrix4x3f.m31 = m312;
        matrix4x3f.m32 = m322;
        matrix4x3f.properties = matrix4x3fc.properties() & 16;
        return matrix4x3f;
    }

    public Matrix4x3f normal() {
        return normal(this);
    }

    public Matrix4x3f normalize3x3() {
        return normalize3x3(this);
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

    public Matrix4x3f obliqueZ(float f2, float f3) {
        this.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        this.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        this.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        this.properties = 0;
        return this;
    }

    public Vector3f origin(Vector3f vector3f) {
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

    public Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4x3f matrix4x3f) {
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
        float f16 = this.m00;
        float f17 = f16 * f13;
        float f18 = this.m10;
        float f19 = (f18 * f14) + f17;
        float f20 = this.m20;
        matrix4x3f.m30 = (f20 * f15) + f19 + this.m30;
        float f21 = this.m01;
        float f22 = f21 * f13;
        float f23 = this.m11;
        float f24 = (f23 * f14) + f22;
        float f25 = this.m21;
        matrix4x3f.m31 = (f25 * f15) + f24 + this.m31;
        float f26 = this.m02;
        float f27 = f13 * f26;
        float f28 = this.m12;
        float f29 = (f14 * f28) + f27;
        float f30 = this.m22;
        matrix4x3f.m32 = (f15 * f30) + f29 + this.m32;
        matrix4x3f.m00 = f16 * f9;
        matrix4x3f.m01 = f21 * f9;
        matrix4x3f.m02 = f26 * f9;
        matrix4x3f.m10 = f18 * f10;
        matrix4x3f.m11 = f23 * f10;
        matrix4x3f.m12 = f28 * f10;
        matrix4x3f.m20 = f20 * f12;
        matrix4x3f.m21 = f25 * f12;
        matrix4x3f.m22 = f30 * f12;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f ortho2D(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        float f6 = f3 - f2;
        float f7 = 2.0f / f6;
        float f8 = f5 - f4;
        float f9 = 2.0f / f8;
        float f10 = (-(f3 + f2)) / f6;
        float f11 = (-(f5 + f4)) / f8;
        float f12 = this.m00;
        float f13 = f12 * f10;
        float f14 = this.m10;
        matrix4x3f.m30 = (f14 * f11) + f13 + this.m30;
        float f15 = this.m01;
        float f16 = f15 * f10;
        float f17 = this.m11;
        matrix4x3f.m31 = (f17 * f11) + f16 + this.m31;
        float f18 = this.m02;
        float f19 = f10 * f18;
        float f20 = this.m12;
        matrix4x3f.m32 = (f11 * f20) + f19 + this.m32;
        matrix4x3f.m00 = f12 * f7;
        matrix4x3f.m01 = f15 * f7;
        matrix4x3f.m02 = f18 * f7;
        matrix4x3f.m10 = f14 * f9;
        matrix4x3f.m11 = f17 * f9;
        matrix4x3f.m12 = f20 * f9;
        matrix4x3f.m20 = -this.m20;
        matrix4x3f.m21 = -this.m21;
        matrix4x3f.m22 = -this.m22;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f ortho2DLH(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        float f6 = f3 - f2;
        float f7 = 2.0f / f6;
        float f8 = f5 - f4;
        float f9 = 2.0f / f8;
        float f10 = (-(f3 + f2)) / f6;
        float f11 = (-(f5 + f4)) / f8;
        float f12 = this.m00;
        float f13 = f12 * f10;
        float f14 = this.m10;
        matrix4x3f.m30 = (f14 * f11) + f13 + this.m30;
        float f15 = this.m01;
        float f16 = f15 * f10;
        float f17 = this.m11;
        matrix4x3f.m31 = (f17 * f11) + f16 + this.m31;
        float f18 = this.m02;
        float f19 = f10 * f18;
        float f20 = this.m12;
        matrix4x3f.m32 = (f11 * f20) + f19 + this.m32;
        matrix4x3f.m00 = f12 * f7;
        matrix4x3f.m01 = f15 * f7;
        matrix4x3f.m02 = f18 * f7;
        matrix4x3f.m10 = f14 * f9;
        matrix4x3f.m11 = f17 * f9;
        matrix4x3f.m12 = f20 * f9;
        matrix4x3f.m20 = this.m20;
        matrix4x3f.m21 = this.m21;
        matrix4x3f.m22 = this.m22;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z, Matrix4x3f matrix4x3f) {
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
        float f15 = this.m00;
        float f16 = f15 * f12;
        float f17 = this.m10;
        float f18 = (f17 * f13) + f16;
        float f19 = this.m20;
        matrix4x3f.m30 = (f19 * f14) + f18 + this.m30;
        float f20 = this.m01;
        float f21 = f20 * f12;
        float f22 = this.m11;
        float f23 = (f22 * f13) + f21;
        float f24 = this.m21;
        matrix4x3f.m31 = (f24 * f14) + f23 + this.m31;
        float f25 = this.m02;
        float f26 = f12 * f25;
        float f27 = this.m12;
        float f28 = (f13 * f27) + f26;
        float f29 = this.m22;
        matrix4x3f.m32 = (f14 * f29) + f28 + this.m32;
        matrix4x3f.m00 = f15 * f9;
        matrix4x3f.m01 = f20 * f9;
        matrix4x3f.m02 = f25 * f9;
        matrix4x3f.m10 = f17 * f10;
        matrix4x3f.m11 = f22 * f10;
        matrix4x3f.m12 = f27 * f10;
        matrix4x3f.m20 = f19 * f11;
        matrix4x3f.m21 = f24 * f11;
        matrix4x3f.m22 = f29 * f11;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z, Matrix4x3f matrix4x3f) {
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
        float f12 = this.m20;
        matrix4x3f.m30 = (f12 * f11) + this.m30;
        float f13 = this.m21;
        matrix4x3f.m31 = (f13 * f11) + this.m31;
        float f14 = this.m22;
        matrix4x3f.m32 = (f11 * f14) + this.m32;
        matrix4x3f.m00 = this.m00 * f7;
        matrix4x3f.m01 = this.m01 * f7;
        matrix4x3f.m02 = this.m02 * f7;
        matrix4x3f.m10 = this.m10 * f8;
        matrix4x3f.m11 = this.m11 * f8;
        matrix4x3f.m12 = this.m12 * f8;
        matrix4x3f.m20 = f12 * f10;
        matrix4x3f.m21 = f13 * f10;
        matrix4x3f.m22 = f14 * f10;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z, Matrix4x3f matrix4x3f) {
        float f6 = 2.0f;
        float f7 = 2.0f / f2;
        float f8 = 2.0f / f3;
        if (z) {
            f6 = 1.0f;
        }
        float f9 = f6 / (f5 - f4);
        float f10 = (z ? f4 : f5 + f4) / (f4 - f5);
        float f11 = this.m20;
        matrix4x3f.m30 = (f11 * f10) + this.m30;
        float f12 = this.m21;
        matrix4x3f.m31 = (f12 * f10) + this.m31;
        float f13 = this.m22;
        matrix4x3f.m32 = (f10 * f13) + this.m32;
        matrix4x3f.m00 = this.m00 * f7;
        matrix4x3f.m01 = this.m01 * f7;
        matrix4x3f.m02 = this.m02 * f7;
        matrix4x3f.m10 = this.m10 * f8;
        matrix4x3f.m11 = this.m11 * f8;
        matrix4x3f.m12 = this.m12 * f8;
        matrix4x3f.m20 = f11 * f9;
        matrix4x3f.m21 = f12 * f9;
        matrix4x3f.m22 = f13 * f9;
        matrix4x3f.properties = this.properties & -29;
        return matrix4x3f;
    }

    public Matrix4x3f pick(float f2, float f3, float f4, float f5, int[] iArr, Matrix4x3f matrix4x3f) {
        float f6 = ((float) iArr[2]) / f4;
        float f7 = ((float) iArr[3]) / f5;
        float f8 = (((((float) iArr[0]) - f2) * 2.0f) + ((float) iArr[2])) / f4;
        float f9 = (((((float) iArr[1]) - f3) * 2.0f) + ((float) iArr[3])) / f5;
        float f10 = this.m00;
        float f11 = f10 * f8;
        float f12 = this.m10;
        matrix4x3f.m30 = (f12 * f9) + f11 + this.m30;
        float f13 = this.m01;
        float f14 = f13 * f8;
        float f15 = this.m11;
        matrix4x3f.m31 = (f15 * f9) + f14 + this.m31;
        float f16 = this.m02;
        float f17 = f8 * f16;
        float f18 = this.m12;
        matrix4x3f.m32 = (f9 * f18) + f17 + this.m32;
        matrix4x3f.m00 = f10 * f6;
        matrix4x3f.m01 = f13 * f6;
        matrix4x3f.m02 = f16 * f6;
        matrix4x3f.m10 = f12 * f7;
        matrix4x3f.m11 = f15 * f7;
        matrix4x3f.m12 = f18 * f7;
        matrix4x3f.properties = 0;
        return matrix4x3f;
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

    public int properties() {
        return this.properties;
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.m00 = objectInput.readFloat();
        this.m01 = objectInput.readFloat();
        this.m02 = objectInput.readFloat();
        this.m10 = objectInput.readFloat();
        this.m11 = objectInput.readFloat();
        this.m12 = objectInput.readFloat();
        this.m20 = objectInput.readFloat();
        this.m21 = objectInput.readFloat();
        this.m22 = objectInput.readFloat();
        this.m30 = objectInput.readFloat();
        this.m31 = objectInput.readFloat();
        this.m32 = objectInput.readFloat();
        this.properties = 0;
    }

    public Matrix4x3f reflect(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        float f9 = f5;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f2.reflection(f6, f7, f8, f9);
        }
        float f10 = f6 + f6;
        float f11 = f7 + f7;
        float f12 = f8 + f8;
        float f13 = 1.0f - (f10 * f6);
        float f14 = -f10;
        float f15 = f14 * f7;
        float f16 = f14 * f8;
        float f17 = -f11;
        float f18 = f17 * f6;
        float f19 = 1.0f - (f11 * f7);
        float f20 = f17 * f8;
        float f21 = -f12;
        float f22 = f21 * f6;
        float f23 = f21 * f7;
        float f24 = 1.0f - (f12 * f8);
        float f25 = -(f9 + f9);
        float f26 = f6 * f25;
        float f27 = f7 * f25;
        float f28 = f25 * f8;
        float f29 = this.m00;
        float f30 = f29 * f26;
        int i3 = i2;
        float f31 = this.m10;
        float f32 = (f31 * f27) + f30;
        float f33 = this.m20;
        float f34 = f24;
        matrix4x3f2.m30 = (f33 * f28) + f32 + this.m30;
        float f35 = this.m01;
        float f36 = f35 * f26;
        float f37 = f23;
        float f38 = this.m11;
        float f39 = (f38 * f27) + f36;
        float f40 = f20;
        float f41 = this.m21;
        float f42 = (f41 * f28) + f39;
        float f43 = f19;
        matrix4x3f2.m31 = f42 + this.m31;
        float f44 = this.m02;
        float f45 = f26 * f44;
        float f46 = f18;
        float f47 = this.m12;
        float f48 = (f27 * f47) + f45;
        float f49 = this.m22;
        matrix4x3f2.m32 = (f28 * f49) + f48 + this.m32;
        float f50 = (f33 * f16) + (f31 * f15) + (f29 * f13);
        float f51 = (f41 * f16) + (f38 * f15) + (f35 * f13);
        float f52 = f16 * f49;
        float f53 = f52 + (f15 * f47) + (f13 * f44);
        float f54 = (f33 * f40) + (f31 * f43) + (f29 * f46);
        float f55 = (f41 * f40) + (f38 * f43) + (f35 * f46);
        float f56 = f40 * f49;
        float f57 = f56 + (f43 * f47) + (f46 * f44);
        float f58 = f33 * f34;
        matrix4x3f2.m20 = f58 + (f31 * f37) + (f29 * f22);
        float f59 = f41 * f34;
        matrix4x3f2.m21 = f59 + (f38 * f37) + (f35 * f22);
        float f60 = f49 * f34;
        matrix4x3f2.m22 = f60 + (f47 * f37) + (f44 * f22);
        matrix4x3f2.m00 = f50;
        matrix4x3f2.m01 = f51;
        matrix4x3f2.m02 = f53;
        matrix4x3f2.m10 = f54;
        matrix4x3f2.m11 = f55;
        matrix4x3f2.m12 = f57;
        matrix4x3f2.properties = i3 & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f reflection(float f2, float f3, float f4, float f5) {
        float f6 = f2 + f2;
        float f7 = f3 + f3;
        float f8 = f4 + f4;
        float f9 = f5 + f5;
        this.m00 = 1.0f - (f6 * f2);
        float f10 = -f6;
        this.m01 = f10 * f3;
        this.m02 = f10 * f4;
        float f11 = -f7;
        this.m10 = f11 * f2;
        this.m11 = 1.0f - (f7 * f3);
        this.m12 = f11 * f4;
        float f12 = -f8;
        this.m20 = f12 * f2;
        this.m21 = f12 * f3;
        this.m22 = 1.0f - (f8 * f4);
        float f13 = -f9;
        this.m30 = f2 * f13;
        this.m31 = f3 * f13;
        this.m32 = f13 * f4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotate(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f.rotation(f2, f3, f4, f5);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(f2, f3, f4, f5, matrix4x3f);
        }
        return rotateGeneric(f2, f3, f4, f5, matrix4x3f);
    }

    public Matrix4x3f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4) {
        return rotateAround(quaternionfc, f2, f3, f4, this);
    }

    public Matrix4x3f rotateLocal(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f31 = this.m10;
        float f32 = f7 * f31;
        float f33 = f30;
        float f34 = this.m11;
        float f35 = (f14 * f34) + f32;
        float f36 = this.m12;
        float f37 = f28;
        float f38 = (f19 * f36) + f35;
        float f39 = (f20 * f36) + (f15 * f34) + (f10 * f31);
        float f40 = f36 * f21;
        float f41 = f40 + (f34 * f18) + (f31 * f13);
        float f42 = this.m20;
        float f43 = f7 * f42;
        float f44 = f41;
        float f45 = this.m21;
        float f46 = (f14 * f45) + f43;
        float f47 = this.m22;
        float f48 = f39;
        float f49 = (f19 * f47) + f46;
        float f50 = (f20 * f47) + (f15 * f45) + (f10 * f42);
        float f51 = f47 * f21;
        float f52 = f51 + (f45 * f18) + (f42 * f13);
        float f53 = this.m30;
        float f54 = f7 * f53;
        float f55 = this.m31;
        float f56 = (f14 * f55) + f54;
        float f57 = this.m32;
        float f58 = (f19 * f57) + f56;
        float f59 = f20 * f57;
        float f60 = f59 + (f15 * f55) + (f10 * f53);
        float f61 = f21 * f57;
        float f62 = f61 + (f18 * f55) + (f13 * f53);
        matrix4x3f2.m00 = f27;
        matrix4x3f2.m01 = f37;
        matrix4x3f2.m02 = f33;
        matrix4x3f2.m10 = f38;
        matrix4x3f2.m11 = f48;
        matrix4x3f2.m12 = f44;
        matrix4x3f2.m20 = f49;
        matrix4x3f2.m21 = f50;
        matrix4x3f2.m22 = f52;
        matrix4x3f2.m30 = f58;
        matrix4x3f2.m31 = f60;
        matrix4x3f2.m32 = f62;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f rotateLocalX(float f2, Matrix4x3f matrix4x3f) {
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
        matrix4x3f._m00(this.m00);
        matrix4x3f._m01(f6);
        matrix4x3f._m02(f7);
        matrix4x3f._m10(this.m10);
        matrix4x3f._m11(f11);
        matrix4x3f._m12(f12);
        matrix4x3f._m20(this.m20);
        matrix4x3f._m21(f16);
        matrix4x3f._m22(f17);
        matrix4x3f._m30(this.m30);
        matrix4x3f._m31(f21);
        matrix4x3f._m32(f22);
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateLocalY(float f2, Matrix4x3f matrix4x3f) {
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
        matrix4x3f._m00(f6);
        matrix4x3f._m01(this.m01);
        matrix4x3f._m02(f8);
        matrix4x3f._m10(f12);
        matrix4x3f._m11(this.m11);
        matrix4x3f._m12(f13);
        matrix4x3f._m20(f17);
        matrix4x3f._m21(this.m21);
        matrix4x3f._m22(f18);
        matrix4x3f._m30(f22);
        matrix4x3f._m31(this.m31);
        matrix4x3f._m32(f23);
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateLocalZ(float f2, Matrix4x3f matrix4x3f) {
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
        matrix4x3f._m00(f6);
        matrix4x3f._m01(f7);
        matrix4x3f._m02(this.m02);
        matrix4x3f._m10(f11);
        matrix4x3f._m11(f12);
        matrix4x3f._m12(this.m12);
        matrix4x3f._m20(f16);
        matrix4x3f._m21(f17);
        matrix4x3f._m22(this.m22);
        matrix4x3f._m30(f21);
        matrix4x3f._m31(f22);
        matrix4x3f._m32(this.m32);
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4x3f);
    }

    public Matrix4x3f rotateTranslation(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = f3 * f5;
        float f8 = f4 * f4;
        float f9 = f4 * f5;
        float f10 = f5 * f5;
        float f11 = (f3 * f3 * f6) + cosFromSin;
        float f12 = f3 * f4 * f6;
        float f13 = f5 * sin;
        float f14 = f12 + f13;
        float f15 = f7 * f6;
        float f16 = f4 * sin;
        float f17 = f15 - f16;
        float f18 = f12 - f13;
        float f19 = (f8 * f6) + cosFromSin;
        float f20 = f9 * f6;
        float f21 = f3 * sin;
        float f22 = f20 + f21;
        float f23 = f20 - f21;
        float f24 = (f10 * f6) + cosFromSin;
        matrix4x3f.m20 = f15 + f16;
        matrix4x3f.m21 = f23;
        matrix4x3f.m22 = f24;
        matrix4x3f.m00 = f11;
        matrix4x3f.m01 = f14;
        matrix4x3f.m02 = f17;
        matrix4x3f.m10 = f18;
        matrix4x3f.m11 = f19;
        matrix4x3f.m12 = f22;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateX(float f2, Matrix4x3f matrix4x3f) {
        float f3;
        if ((this.properties & 4) != 0) {
            return matrix4x3f.rotationX(f2);
        }
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m10;
        float f7 = f6 * f4;
        float f8 = this.m20;
        float f9 = (f8 * f3) + f7;
        float f10 = this.m11;
        float f11 = f10 * f4;
        float f12 = this.m21;
        float f13 = (f12 * f3) + f11;
        float f14 = this.m12;
        float f15 = f14 * f4;
        float f16 = this.m22;
        float f17 = (f3 * f16) + f15;
        matrix4x3f.m20 = (f8 * f4) + (f6 * f5);
        matrix4x3f.m21 = (f12 * f4) + (f10 * f5);
        matrix4x3f.m22 = (f16 * f4) + (f14 * f5);
        matrix4x3f.m10 = f9;
        matrix4x3f.m11 = f13;
        matrix4x3f.m12 = f17;
        matrix4x3f.m00 = this.m00;
        matrix4x3f.m01 = this.m01;
        matrix4x3f.m02 = this.m02;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateXYZ(Vector3f vector3f) {
        return rotateXYZ(vector3f.x, vector3f.y, vector3f.z);
    }

    public Matrix4x3f rotateY(float f2, Matrix4x3f matrix4x3f) {
        float f3;
        if ((this.properties & 4) != 0) {
            return matrix4x3f.rotationY(f2);
        }
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m00;
        float f7 = f6 * f4;
        float f8 = this.m20;
        float f9 = (f8 * f5) + f7;
        float f10 = this.m01;
        float f11 = f10 * f4;
        float f12 = this.m21;
        float f13 = (f12 * f5) + f11;
        float f14 = this.m02;
        float f15 = f14 * f4;
        float f16 = this.m22;
        float f17 = (f5 * f16) + f15;
        matrix4x3f.m20 = (f8 * f4) + (f6 * f3);
        matrix4x3f.m21 = (f12 * f4) + (f10 * f3);
        matrix4x3f.m22 = (f16 * f4) + (f14 * f3);
        matrix4x3f.m00 = f9;
        matrix4x3f.m01 = f13;
        matrix4x3f.m02 = f17;
        matrix4x3f.m10 = this.m10;
        matrix4x3f.m11 = this.m11;
        matrix4x3f.m12 = this.m12;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateYXZ(Vector3f vector3f) {
        return rotateYXZ(vector3f.y, vector3f.x, vector3f.z);
    }

    public Matrix4x3f rotateZ(float f2, Matrix4x3f matrix4x3f) {
        float f3;
        if ((this.properties & 4) != 0) {
            return matrix4x3f.rotationZ(f2);
        }
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f4 = 1.0f;
            } else if (!(f2 == -1.5707964f || f2 == 4.712389f)) {
                double d2 = (double) f2;
                f3 = (float) Math.sin(d2);
                f4 = (float) Math.cosFromSin((double) f3, d2);
            }
            f3 = f4;
            f4 = 0.0f;
        }
        float f5 = -f3;
        float f6 = this.m00;
        float f7 = f6 * f4;
        float f8 = this.m10;
        float f9 = (f8 * f3) + f7;
        float f10 = this.m01;
        float f11 = f10 * f4;
        float f12 = this.m11;
        float f13 = (f12 * f3) + f11;
        float f14 = this.m02;
        float f15 = f14 * f4;
        float f16 = this.m12;
        float f17 = (f3 * f16) + f15;
        matrix4x3f.m10 = (f8 * f4) + (f6 * f5);
        matrix4x3f.m11 = (f12 * f4) + (f10 * f5);
        matrix4x3f.m12 = (f16 * f4) + (f14 * f5);
        matrix4x3f.m00 = f9;
        matrix4x3f.m01 = f13;
        matrix4x3f.m02 = f17;
        matrix4x3f.m20 = this.m20;
        matrix4x3f.m21 = this.m21;
        matrix4x3f.m22 = this.m22;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f rotateZYX(Vector3f vector3f) {
        return rotateZYX(vector3f.z, vector3f.y, vector3f.x);
    }

    public Matrix4x3f rotation(float f2, Vector3fc vector3fc) {
        return rotation(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f rotationAround(Quaternionfc quaternionfc, float f2, float f3, float f4) {
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
        _m00(((w + x) - z) - y);
        _m01(f5 + a2);
        _m02(b2 - a3);
        _m10(f5 - a2);
        _m11(((y - z) + w) - x);
        _m12(b3 + a4);
        _m30(((((-this.m00) * f2) - (this.m10 * f3)) - (this.m20 * f4)) + f2);
        _m31(((((-this.m01) * f2) - (this.m11 * f3)) - (this.m21 * f4)) + f3);
        _m32(((((-this.m02) * f2) - (this.m12 * f3)) - (this.m22 * f4)) + f4);
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotationTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4x3f rotationX(float f2) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f3 = 1.0f;
            } else if (f2 == -1.5707964f || f2 == 4.712389f) {
                f3 = -1.0f;
            } else {
                double d2 = (double) f2;
                float sin = (float) Math.sin(d2);
                float f5 = sin;
                f4 = (float) Math.cosFromSin((double) sin, d2);
                f3 = f5;
            }
            f4 = 0.0f;
        }
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = f4;
        this.m12 = f3;
        this.m20 = 0.0f;
        this.m21 = -f3;
        this.m22 = f4;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationXYZ(float f2, float f3, float f4) {
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
        this.m20 = sin2;
        this.m21 = f5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (f8 * cosFromSin3);
        this.m02 = (sin3 * sin) + (f9 * cosFromSin3);
        this.m10 = cosFromSin2 * f7;
        this.m11 = (cosFromSin * cosFromSin3) + (f8 * f7);
        this.m12 = (sin * cosFromSin3) + (f9 * f7);
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationY(float f2) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f3 = 1.0f;
            } else if (f2 == -1.5707964f || f2 == 4.712389f) {
                f3 = -1.0f;
            } else {
                double d2 = (double) f2;
                float sin = (float) Math.sin(d2);
                float f5 = sin;
                f4 = (float) Math.cosFromSin((double) sin, d2);
                f3 = f5;
            }
            f4 = 0.0f;
        }
        this.m00 = f4;
        this.m01 = 0.0f;
        this.m02 = -f3;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = f3;
        this.m21 = 0.0f;
        this.m22 = f4;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationYXZ(float f2, float f3, float f4) {
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
        this.m20 = sin2 * cosFromSin;
        this.m21 = f6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (f8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * f9) + (f5 * cosFromSin3);
        this.m10 = (f8 * cosFromSin3) + (cosFromSin2 * f7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (f9 * cosFromSin3) + (f5 * f7);
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationZ(float f2) {
        float f3;
        float f4 = -1.0f;
        if (f2 == 3.1415927f || f2 == -3.1415927f) {
            f3 = 0.0f;
        } else {
            if (f2 == 1.5707964f || f2 == -4.712389f) {
                f3 = 1.0f;
            } else if (f2 == -1.5707964f || f2 == 4.712389f) {
                f3 = -1.0f;
            } else {
                double d2 = (double) f2;
                float sin = (float) Math.sin(d2);
                float f5 = sin;
                f4 = (float) Math.cosFromSin((double) sin, d2);
                f3 = f5;
            }
            f4 = 0.0f;
        }
        this.m00 = f4;
        this.m01 = f3;
        this.m02 = 0.0f;
        this.m10 = -f3;
        this.m11 = f4;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotationZYX(float f2, float f3, float f4) {
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
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = f6;
        this.m10 = (f8 * sin) + (f5 * cosFromSin);
        this.m11 = (f9 * sin) + (cosFromSin3 * cosFromSin);
        this.m12 = sin * cosFromSin2;
        this.m20 = (f8 * cosFromSin) + (f5 * f7);
        this.m21 = (f9 * cosFromSin) + (cosFromSin3 * f7);
        this.m22 = cosFromSin2 * cosFromSin;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f scale(Vector3fc vector3fc, Matrix4x3f matrix4x3f) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4x3f);
    }

    public Matrix4x3f scaleLocal(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f.scaling(f2, f3, f4);
        }
        float f5 = this.m00 * f2;
        float f6 = this.m01 * f3;
        float f7 = this.m02 * f4;
        float f8 = this.m10 * f2;
        float f9 = this.m11 * f3;
        float f10 = this.m12 * f4;
        float f11 = this.m20 * f2;
        float f12 = this.m21 * f3;
        float f13 = this.m22 * f4;
        float f14 = f2 * this.m30;
        float f15 = f3 * this.m31;
        float f16 = f4 * this.m32;
        matrix4x3f.m00 = f5;
        matrix4x3f.m01 = f6;
        matrix4x3f.m02 = f7;
        matrix4x3f.m10 = f8;
        matrix4x3f.m11 = f9;
        matrix4x3f.m12 = f10;
        matrix4x3f.m20 = f11;
        matrix4x3f.m21 = f12;
        matrix4x3f.m22 = f13;
        matrix4x3f.m30 = f14;
        matrix4x3f.m31 = f15;
        matrix4x3f.m32 = f16;
        matrix4x3f.properties = i2 & -29;
        return matrix4x3f;
    }

    public Matrix4x3f scaling(float f2) {
        return scaling(f2, f2, f2);
    }

    public Matrix4x3f set(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy((Matrix4x3f) matrix4x3fc, this);
        } else {
            setMatrix4x3fc(matrix4x3fc);
        }
        this.properties = matrix4x3fc.properties();
        return this;
    }

    public Matrix4x3f set3x3(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy3x3((Matrix4x3f) matrix4x3fc, this);
        } else {
            set3x3Matrix4x3fc(matrix4x3fc);
        }
        this.properties = matrix4x3fc.properties() & this.properties;
        return this;
    }

    public Matrix4x3f setColumn(int i2, Vector3fc vector3fc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = vector3fc.x();
            this.m01 = vector3fc.y();
            this.m02 = vector3fc.z();
        } else if (i2 == 1) {
            this.m10 = vector3fc.x();
            this.m11 = vector3fc.y();
            this.m12 = vector3fc.z();
        } else if (i2 == 2) {
            this.m20 = vector3fc.x();
            this.m21 = vector3fc.y();
            this.m22 = vector3fc.z();
        } else if (i2 == 3) {
            this.m30 = vector3fc.x();
            this.m31 = vector3fc.y();
            this.m32 = vector3fc.z();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setLookAlong(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return setLookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4x3f setLookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return setLookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4x3f setLookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return setLookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4x3f setOrtho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        MemUtil.INSTANCE.identity(this);
        float f8 = 2.0f;
        this.m00 = 2.0f / (f3 - f2);
        this.m11 = 2.0f / (f5 - f4);
        if (z) {
            f8 = 1.0f;
        }
        float f9 = f6 - f7;
        this.m22 = f8 / f9;
        this.m30 = (f3 + f2) / (f2 - f3);
        this.m31 = (f5 + f4) / (f4 - f5);
        if (!z) {
            f6 += f7;
        }
        this.m32 = f6 / f9;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrtho2D(float f2, float f3, float f4, float f5) {
        MemUtil.INSTANCE.identity(this);
        float f6 = f3 - f2;
        this.m00 = 2.0f / f6;
        float f7 = f5 - f4;
        this.m11 = 2.0f / f7;
        this.m22 = -1.0f;
        this.m30 = (-(f3 + f2)) / f6;
        this.m31 = (-(f5 + f4)) / f7;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrtho2DLH(float f2, float f3, float f4, float f5) {
        MemUtil.INSTANCE.identity(this);
        float f6 = f3 - f2;
        this.m00 = 2.0f / f6;
        float f7 = f5 - f4;
        this.m11 = 2.0f / f7;
        this.m22 = 1.0f;
        this.m30 = (-(f3 + f2)) / f6;
        this.m31 = (-(f5 + f4)) / f7;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        MemUtil.INSTANCE.identity(this);
        float f8 = 2.0f;
        this.m00 = 2.0f / (f3 - f2);
        this.m11 = 2.0f / (f5 - f4);
        if (z) {
            f8 = 1.0f;
        }
        this.m22 = f8 / (f7 - f6);
        this.m30 = (f3 + f2) / (f2 - f3);
        this.m31 = (f5 + f4) / (f4 - f5);
        this.m32 = (z ? f6 : f7 + f6) / (f6 - f7);
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrthoSymmetric(float f2, float f3, float f4, float f5, boolean z) {
        MemUtil.INSTANCE.identity(this);
        float f6 = 2.0f;
        this.m00 = 2.0f / f2;
        this.m11 = 2.0f / f3;
        if (z) {
            f6 = 1.0f;
        }
        float f7 = f4 - f5;
        this.m22 = f6 / f7;
        if (!z) {
            f4 += f5;
        }
        this.m32 = f4 / f7;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z) {
        MemUtil.INSTANCE.identity(this);
        float f6 = 2.0f;
        this.m00 = 2.0f / f2;
        this.m11 = 2.0f / f3;
        if (z) {
            f6 = 1.0f;
        }
        this.m22 = f6 / (f5 - f4);
        this.m32 = (z ? f4 : f5 + f4) / (f4 - f5);
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setRotationXYZ(float f2, float f3, float f4) {
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
        this.m20 = sin2;
        this.m21 = f5 * cosFromSin2;
        this.m22 = cosFromSin * cosFromSin2;
        this.m00 = cosFromSin2 * cosFromSin3;
        this.m01 = (cosFromSin * sin3) + (f8 * cosFromSin3);
        this.m02 = (sin3 * sin) + (f9 * cosFromSin3);
        this.m10 = cosFromSin2 * f7;
        this.m11 = (cosFromSin * cosFromSin3) + (f8 * f7);
        this.m12 = (sin * cosFromSin3) + (f9 * f7);
        this.properties &= -13;
        return this;
    }

    public Matrix4x3f setRotationYXZ(float f2, float f3, float f4) {
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
        this.m20 = sin2 * cosFromSin;
        this.m21 = f6;
        this.m22 = cosFromSin2 * cosFromSin;
        this.m00 = (f8 * sin3) + (cosFromSin2 * cosFromSin3);
        this.m01 = cosFromSin * sin3;
        this.m02 = (sin3 * f9) + (f5 * cosFromSin3);
        this.m10 = (f8 * cosFromSin3) + (cosFromSin2 * f7);
        this.m11 = cosFromSin * cosFromSin3;
        this.m12 = (f9 * cosFromSin3) + (f5 * f7);
        this.properties &= -13;
        return this;
    }

    public Matrix4x3f setRotationZYX(float f2, float f3, float f4) {
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
        this.m00 = cosFromSin3 * cosFromSin2;
        this.m01 = sin3 * cosFromSin2;
        this.m02 = f6;
        this.m10 = (f8 * sin) + (f5 * cosFromSin);
        this.m11 = (f9 * sin) + (cosFromSin3 * cosFromSin);
        this.m12 = sin * cosFromSin2;
        this.m20 = (f8 * cosFromSin) + (f5 * f7);
        this.m21 = (f9 * cosFromSin) + (cosFromSin3 * f7);
        this.m22 = cosFromSin2 * cosFromSin;
        this.properties &= -13;
        return this;
    }

    public Matrix4x3f setRow(int i2, Vector4fc vector4fc) throws IndexOutOfBoundsException {
        if (i2 == 0) {
            this.m00 = vector4fc.x();
            this.m10 = vector4fc.y();
            this.m20 = vector4fc.z();
            this.m30 = vector4fc.w();
        } else if (i2 == 1) {
            this.m01 = vector4fc.x();
            this.m11 = vector4fc.y();
            this.m21 = vector4fc.z();
            this.m31 = vector4fc.w();
        } else if (i2 == 2) {
            this.m02 = vector4fc.x();
            this.m12 = vector4fc.y();
            this.m22 = vector4fc.z();
            this.m32 = vector4fc.w();
        } else {
            throw new IndexOutOfBoundsException();
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setTranslation(float f2, float f3, float f4) {
        this.m30 = f2;
        this.m31 = f3;
        this.m32 = f4;
        this.properties &= -5;
        return this;
    }

    public Matrix4x3f shadow(Vector4fc vector4fc, float f2, float f3, float f4, float f5) {
        return shadow(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w(), f2, f3, f4, f5, this);
    }

    public Matrix4x3f sub(Matrix4x3fc matrix4x3fc) {
        return sub(matrix4x3fc, this);
    }

    public Matrix4x3f swap(Matrix4x3f matrix4x3f) {
        MemUtil.INSTANCE.swap(this, matrix4x3f);
        int i2 = this.properties;
        this.properties = matrix4x3f.properties;
        matrix4x3f.properties = i2;
        return this;
    }

    public String toString() {
        String matrix4x3f = toString(new DecimalFormat(" 0.000E0;-"));
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < matrix4x3f.length(); i3++) {
            char charAt = matrix4x3f.charAt(i3);
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
        return vector4f.mul((Matrix4x3fc) this);
    }

    public Matrix4x3f transformAab(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f, Vector3f vector3f2) {
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

    public Vector3f transformDirection(Vector3f vector3f) {
        float f2 = this.m00;
        float f3 = vector3f.x;
        float f4 = f2 * f3;
        float f5 = this.m10;
        float f6 = vector3f.y;
        float f7 = (f5 * f6) + f4;
        float f8 = this.m20;
        float f9 = vector3f.z;
        vector3f.set((f8 * f9) + f7, (this.m21 * f9) + (this.m11 * f6) + (this.m01 * f3), (this.m22 * f9) + (this.m12 * f6) + (this.m02 * f3));
        return vector3f;
    }

    public Vector3f transformPosition(Vector3f vector3f) {
        float f2 = this.m00;
        float f3 = vector3f.x;
        float f4 = f2 * f3;
        float f5 = this.m10;
        float f6 = vector3f.y;
        float f7 = (f5 * f6) + f4;
        float f8 = this.m20;
        float f9 = vector3f.z;
        vector3f.set((f8 * f9) + f7 + this.m30, (this.m21 * f9) + (this.m11 * f6) + (this.m01 * f3) + this.m31, (this.m22 * f9) + (this.m12 * f6) + (this.m02 * f3) + this.m32);
        return vector3f;
    }

    public Matrix4x3f translate(Vector3fc vector3fc) {
        return translate(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f translateLocal(Vector3fc vector3fc) {
        return translateLocal(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f translation(float f2, float f3, float f4) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this.m30 = f2;
        this.m31 = f3;
        this.m32 = f4;
        this.properties = 24;
        return this;
    }

    public Matrix4x3f translationRotate(float f2, float f3, float f4, Quaternionfc quaternionfc) {
        float x = quaternionfc.x() + quaternionfc.x();
        float y = quaternionfc.y() + quaternionfc.y();
        float z = quaternionfc.z() + quaternionfc.z();
        float x2 = quaternionfc.x() * x;
        float y2 = quaternionfc.y() * y;
        float z2 = quaternionfc.z() * z;
        float y3 = quaternionfc.y() * x;
        float z3 = quaternionfc.z() * x;
        float w = quaternionfc.w() * x;
        float z4 = quaternionfc.z() * y;
        float w2 = quaternionfc.w() * y;
        float w3 = quaternionfc.w() * z;
        this.m00 = 1.0f - (y2 + z2);
        this.m01 = y3 + w3;
        this.m02 = z3 - w2;
        this.m10 = y3 - w3;
        this.m11 = 1.0f - (z2 + x2);
        this.m12 = z4 + w;
        this.m20 = z3 + w2;
        this.m21 = z4 - w;
        this.m22 = 1.0f - (y2 + x2);
        this.m30 = f2;
        this.m31 = f3;
        this.m32 = f4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f translationRotateMul(float f2, float f3, float f4, Quaternionfc quaternionfc, Matrix4x3fc matrix4x3fc) {
        return translationRotateMul(f2, f3, f4, quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), matrix4x3fc);
    }

    public Matrix4x3f translationRotateScale(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
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
        this.m00 = f9 - ((f16 + f17) * f9);
        this.m01 = (f18 + f23) * f9;
        this.m02 = (f19 - f22) * f9;
        this.m10 = (f18 - f23) * f10;
        this.m11 = f10 - ((f17 + f15) * f10);
        this.m12 = (f21 + f20) * f10;
        this.m20 = (f19 + f22) * f11;
        this.m21 = (f21 - f20) * f11;
        this.m22 = f11 - ((f16 + f15) * f11);
        this.m30 = f2;
        this.m31 = f3;
        this.m32 = f4;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f translationRotateScaleMul(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f24 = f9 - ((f16 + f17) * f9);
        float f25 = (f18 + f23) * f9;
        float f26 = (f19 - f22) * f9;
        float f27 = (f18 - f23) * f10;
        float f28 = f10 - ((f17 + f15) * f10);
        float f29 = (f21 + f20) * f10;
        float f30 = (f19 + f22) * f11;
        float f31 = (f21 - f20) * f11;
        float f32 = f11 - ((f16 + f15) * f11);
        float f33 = matrix4x3f2.m00;
        float f34 = f24 * f33;
        float f35 = matrix4x3f2.m01;
        float f36 = (f27 * f35) + f34;
        float f37 = matrix4x3f2.m02;
        float f38 = (f30 * f37) + f36;
        float f39 = (f31 * f37) + (f28 * f35) + (f25 * f33);
        float f40 = f37 * f32;
        this.m02 = f40 + (f35 * f29) + (f33 * f26);
        this.m00 = f38;
        this.m01 = f39;
        float f41 = matrix4x3f2.m10;
        float f42 = f24 * f41;
        float f43 = matrix4x3f2.m11;
        float f44 = (f27 * f43) + f42;
        float f45 = matrix4x3f2.m12;
        float f46 = (f30 * f45) + f44;
        float f47 = (f31 * f45) + (f28 * f43) + (f25 * f41);
        float f48 = f45 * f32;
        this.m12 = f48 + (f43 * f29) + (f41 * f26);
        this.m10 = f46;
        this.m11 = f47;
        float f49 = matrix4x3f2.m20;
        float f50 = f24 * f49;
        float f51 = matrix4x3f2.m21;
        float f52 = (f27 * f51) + f50;
        float f53 = matrix4x3f2.m22;
        float f54 = (f30 * f53) + f52;
        float f55 = (f31 * f53) + (f28 * f51) + (f25 * f49);
        float f56 = f53 * f32;
        this.m22 = f56 + (f51 * f29) + (f49 * f26);
        this.m20 = f54;
        this.m21 = f55;
        float f57 = matrix4x3f2.m30;
        float f58 = f24 * f57;
        float f59 = matrix4x3f2.m31;
        float f60 = (f27 * f59) + f58;
        float f61 = matrix4x3f2.m32;
        float f62 = a.f(f30, f61, f60, f2);
        float f63 = a.f(f31, f61, (f28 * f59) + (f25 * f57), f3);
        this.m32 = a.f(f32, f61, (f29 * f59) + (f26 * f57), f4);
        this.m30 = f62;
        this.m31 = f63;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f translationRotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return translationRotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z());
    }

    public Matrix4x3f transpose3x3() {
        return transpose3x3(this);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.m00);
        objectOutput.writeFloat(this.m01);
        objectOutput.writeFloat(this.m02);
        objectOutput.writeFloat(this.m10);
        objectOutput.writeFloat(this.m11);
        objectOutput.writeFloat(this.m12);
        objectOutput.writeFloat(this.m20);
        objectOutput.writeFloat(this.m21);
        objectOutput.writeFloat(this.m22);
        objectOutput.writeFloat(this.m30);
        objectOutput.writeFloat(this.m31);
        objectOutput.writeFloat(this.m32);
    }

    public Matrix4x3f zero() {
        MemUtil.INSTANCE.zero(this);
        this.properties = 0;
        return this;
    }

    public Matrix4x3f add(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = matrix4x3fc.m00() + this.m00;
        matrix4x3f.m01 = matrix4x3fc.m01() + this.m01;
        matrix4x3f.m02 = matrix4x3fc.m02() + this.m02;
        matrix4x3f.m10 = matrix4x3fc.m10() + this.m10;
        matrix4x3f.m11 = matrix4x3fc.m11() + this.m11;
        matrix4x3f.m12 = matrix4x3fc.m12() + this.m12;
        matrix4x3f.m20 = matrix4x3fc.m20() + this.m20;
        matrix4x3f.m21 = matrix4x3fc.m21() + this.m21;
        matrix4x3f.m22 = matrix4x3fc.m22() + this.m22;
        matrix4x3f.m30 = matrix4x3fc.m30() + this.m30;
        matrix4x3f.m31 = matrix4x3fc.m31() + this.m31;
        matrix4x3f.m32 = matrix4x3fc.m32() + this.m32;
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Matrix4x3f fma(Matrix4x3fc matrix4x3fc, float f2, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = (matrix4x3fc.m00() * f2) + this.m00;
        matrix4x3f.m01 = (matrix4x3fc.m01() * f2) + this.m01;
        matrix4x3f.m02 = (matrix4x3fc.m02() * f2) + this.m02;
        matrix4x3f.m10 = (matrix4x3fc.m10() * f2) + this.m10;
        matrix4x3f.m11 = (matrix4x3fc.m11() * f2) + this.m11;
        matrix4x3f.m12 = (matrix4x3fc.m12() * f2) + this.m12;
        matrix4x3f.m20 = (matrix4x3fc.m20() * f2) + this.m20;
        matrix4x3f.m21 = (matrix4x3fc.m21() * f2) + this.m21;
        matrix4x3f.m22 = (matrix4x3fc.m22() * f2) + this.m22;
        matrix4x3f.m30 = (matrix4x3fc.m30() * f2) + this.m30;
        matrix4x3f.m31 = (matrix4x3fc.m31() * f2) + this.m31;
        matrix4x3f.m32 = (matrix4x3fc.m32() * f2) + this.m32;
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Matrix4d get(Matrix4d matrix4d) {
        return matrix4d.set4x3((Matrix4x3fc) this);
    }

    public float[] get4x4(float[] fArr) {
        return get4x4(fArr, 0);
    }

    public Quaterniond getNormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromNormalized((Matrix4x3fc) this);
    }

    public AxisAngle4d getRotation(AxisAngle4d axisAngle4d) {
        return axisAngle4d.set((Matrix4x3fc) this);
    }

    public FloatBuffer getTransposed(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, floatBuffer);
        return floatBuffer;
    }

    public Quaterniond getUnnormalizedRotation(Quaterniond quaterniond) {
        return quaterniond.setFromUnnormalized((Matrix4x3fc) this);
    }

    public Matrix4x3f lerp(Matrix4x3fc matrix4x3fc, float f2, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = a.e(matrix4x3fc.m00(), this.m00, f2, this.m00);
        matrix4x3f.m01 = a.e(matrix4x3fc.m01(), this.m01, f2, this.m01);
        matrix4x3f.m02 = a.e(matrix4x3fc.m02(), this.m02, f2, this.m02);
        matrix4x3f.m10 = a.e(matrix4x3fc.m10(), this.m10, f2, this.m10);
        matrix4x3f.m11 = a.e(matrix4x3fc.m11(), this.m11, f2, this.m11);
        matrix4x3f.m12 = a.e(matrix4x3fc.m12(), this.m12, f2, this.m12);
        matrix4x3f.m20 = a.e(matrix4x3fc.m20(), this.m20, f2, this.m20);
        matrix4x3f.m21 = a.e(matrix4x3fc.m21(), this.m21, f2, this.m21);
        matrix4x3f.m22 = a.e(matrix4x3fc.m22(), this.m22, f2, this.m22);
        matrix4x3f.m30 = a.e(matrix4x3fc.m30(), this.m30, f2, this.m30);
        matrix4x3f.m31 = a.e(matrix4x3fc.m31(), this.m31, f2, this.m31);
        matrix4x3f.m32 = a.e(matrix4x3fc.m32(), this.m32, f2, this.m32);
        matrix4x3f.properties = matrix4x3fc.properties() & this.properties;
        return matrix4x3f;
    }

    public Matrix4x3f lookAlong(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f) {
        return lookAlong(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4x3f);
    }

    public Matrix4x3f lookAt(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return lookAt(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), this);
    }

    public Matrix4x3f lookAtLH(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3) {
        return lookAtLH(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), this);
    }

    public Matrix4x3f m00(float f2) {
        this.m00 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m01(float f2) {
        this.m01 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m02(float f2) {
        this.m02 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m10(float f2) {
        this.m10 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m11(float f2) {
        this.m11 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m12(float f2) {
        this.m12 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m20(float f2) {
        this.m20 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m21(float f2) {
        this.m21 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 0.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m22(float f2) {
        this.m22 = f2;
        int i2 = this.properties & -17;
        this.properties = i2;
        if (f2 != 1.0f) {
            this.properties = i2 & -13;
        }
        return this;
    }

    public Matrix4x3f m30(float f2) {
        this.m30 = f2;
        if (f2 != 0.0f) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3f m31(float f2) {
        this.m31 = f2;
        if (f2 != 0.0f) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3f m32(float f2) {
        this.m32 = f2;
        if (f2 != 0.0f) {
            this.properties &= -5;
        }
        return this;
    }

    public Matrix4x3f mul(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return matrix4x3f.set(matrix4x3fc);
        }
        if ((matrix4x3fc.properties() & 4) != 0) {
            return matrix4x3f.set((Matrix4x3fc) this);
        }
        if ((this.properties & 8) != 0) {
            return mulTranslation(matrix4x3fc, matrix4x3f);
        }
        return mulGeneric(matrix4x3fc, matrix4x3f);
    }

    public Matrix4x3f mulComponentWise(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = matrix4x3fc.m00() * this.m00;
        matrix4x3f.m01 = matrix4x3fc.m01() * this.m01;
        matrix4x3f.m02 = matrix4x3fc.m02() * this.m02;
        matrix4x3f.m10 = matrix4x3fc.m10() * this.m10;
        matrix4x3f.m11 = matrix4x3fc.m11() * this.m11;
        matrix4x3f.m12 = matrix4x3fc.m12() * this.m12;
        matrix4x3f.m20 = matrix4x3fc.m20() * this.m20;
        matrix4x3f.m21 = matrix4x3fc.m21() * this.m21;
        matrix4x3f.m22 = matrix4x3fc.m22() * this.m22;
        matrix4x3f.m30 = matrix4x3fc.m30() * this.m30;
        matrix4x3f.m31 = matrix4x3fc.m31() * this.m31;
        matrix4x3f.m32 = matrix4x3fc.m32() * this.m32;
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Matrix4x3f mulOrtho(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        float m002 = matrix4x3fc.m00() * this.m00;
        float m012 = matrix4x3fc.m01() * this.m11;
        float m022 = matrix4x3fc.m02() * this.m22;
        float m102 = matrix4x3fc.m10() * this.m00;
        float m112 = matrix4x3fc.m11() * this.m11;
        float m122 = matrix4x3fc.m12() * this.m22;
        float m202 = matrix4x3fc.m20() * this.m00;
        float m212 = matrix4x3fc.m21() * this.m11;
        float m222 = matrix4x3fc.m22() * this.m22;
        float m302 = (matrix4x3fc.m30() * this.m00) + this.m30;
        float m312 = (matrix4x3fc.m31() * this.m11) + this.m31;
        float m322 = (matrix4x3fc.m32() * this.m22) + this.m32;
        matrix4x3f.m00 = m002;
        matrix4x3f.m01 = m012;
        matrix4x3f.m02 = m022;
        matrix4x3f.m10 = m102;
        matrix4x3f.m11 = m112;
        matrix4x3f.m12 = m122;
        matrix4x3f.m20 = m202;
        matrix4x3f.m21 = m212;
        matrix4x3f.m22 = m222;
        matrix4x3f.m30 = m302;
        matrix4x3f.m31 = m312;
        matrix4x3f.m32 = m322;
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Matrix4x3f normal(Matrix4x3f matrix4x3f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f.identity();
        }
        if ((i2 & 16) != 0) {
            return normalOrthonormal(matrix4x3f);
        }
        return normalGeneric(matrix4x3f);
    }

    public Matrix4x3f normalize3x3(Matrix4x3f matrix4x3f) {
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
        matrix4x3f.m00 = this.m00 * sqrt;
        matrix4x3f.m01 = this.m01 * sqrt;
        matrix4x3f.m02 = this.m02 * sqrt;
        matrix4x3f.m10 = this.m10 * sqrt2;
        matrix4x3f.m11 = this.m11 * sqrt2;
        matrix4x3f.m12 = this.m12 * sqrt2;
        matrix4x3f.m20 = this.m20 * sqrt3;
        matrix4x3f.m21 = this.m21 * sqrt3;
        matrix4x3f.m22 = this.m22 * sqrt3;
        matrix4x3f.properties = this.properties;
        return matrix4x3f;
    }

    public Matrix4x3f rotateAround(Quaternionfc quaternionfc, float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return rotationAround(quaternionfc, f2, f3, f4);
        }
        return rotateAroundAffine(quaternionfc, f2, f3, f4, matrix4x3f);
    }

    public Matrix4x3f rotateTowards(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return rotateTowards(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), this);
    }

    public Matrix4x3f rotateXYZ(float f2, float f3, float f4) {
        return rotateXYZ(f2, f3, f4, this);
    }

    public Matrix4x3f rotateYXZ(float f2, float f3, float f4) {
        return rotateYXZ(f2, f3, f4, this);
    }

    public Matrix4x3f rotateZYX(float f2, float f3, float f4) {
        return rotateZYX(f2, f3, f4, this);
    }

    public Matrix4x3f rotation(AxisAngle4f axisAngle4f) {
        return rotation(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
    }

    public Matrix4x3f rotationTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
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
        this.m00 = f14;
        this.m01 = f15;
        this.m02 = f16;
        this.m10 = f17;
        this.m11 = f18;
        this.m12 = f19;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f scale(Vector3fc vector3fc) {
        return scale(vector3fc.x(), vector3fc.y(), vector3fc.z(), this);
    }

    public Matrix4x3f scaling(float f2, float f3, float f4) {
        if ((this.properties & 4) == 0) {
            MemUtil.INSTANCE.identity(this);
        }
        this.m00 = f2;
        this.m11 = f3;
        this.m22 = f4;
        int i2 = 0;
        if (Math.abs(f2) == 1.0f && Math.abs(f3) == 1.0f && Math.abs(f4) == 1.0f) {
            i2 = 16;
        }
        this.properties = i2;
        return this;
    }

    public Matrix4x3f setLookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
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
        this.m00 = f15;
        this.m01 = f18;
        this.m02 = f9;
        this.m10 = f16;
        this.m11 = f19;
        this.m12 = f10;
        this.m20 = f17;
        this.m21 = f20;
        this.m22 = f11;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f setLookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        this.m00 = f20;
        this.m01 = f23;
        this.m02 = f14;
        this.m10 = f21;
        this.m11 = f24;
        this.m12 = f15;
        this.m20 = f22;
        this.m21 = f25;
        this.m22 = f16;
        float f26 = f22 * f4;
        this.m30 = -(f26 + (f21 * f3) + (f20 * f2));
        float f27 = f25 * f4;
        this.m31 = -(f27 + (f24 * f3) + (f23 * f2));
        float f28 = f16 * f4;
        this.m32 = -(f28 + (f15 * f3) + (f14 * f2));
        this.properties = 16;
        return this;
    }

    public Matrix4x3f setLookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        this.m00 = f20;
        this.m01 = f23;
        this.m02 = f14;
        this.m10 = f21;
        this.m11 = f24;
        this.m12 = f15;
        this.m20 = f22;
        this.m21 = f25;
        this.m22 = f16;
        float f26 = f22 * f4;
        this.m30 = -(f26 + (f21 * f3) + (f20 * f2));
        float f27 = f25 * f4;
        this.m31 = -(f27 + (f24 * f3) + (f23 * f2));
        float f28 = f16 * f4;
        this.m32 = -(f28 + (f15 * f3) + (f14 * f2));
        this.properties = 16;
        return this;
    }

    public Matrix4x3f shadow(Vector4fc vector4fc, float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        return shadow(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w(), f2, f3, f4, f5, matrix4x3f);
    }

    public Matrix4x3f sub(Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = this.m00 - matrix4x3fc.m00();
        matrix4x3f.m01 = this.m01 - matrix4x3fc.m01();
        matrix4x3f.m02 = this.m02 - matrix4x3fc.m02();
        matrix4x3f.m10 = this.m10 - matrix4x3fc.m10();
        matrix4x3f.m11 = this.m11 - matrix4x3fc.m11();
        matrix4x3f.m12 = this.m12 - matrix4x3fc.m12();
        matrix4x3f.m20 = this.m20 - matrix4x3fc.m20();
        matrix4x3f.m21 = this.m21 - matrix4x3fc.m21();
        matrix4x3f.m22 = this.m22 - matrix4x3fc.m22();
        matrix4x3f.m30 = this.m30 - matrix4x3fc.m30();
        matrix4x3f.m31 = this.m31 - matrix4x3fc.m31();
        matrix4x3f.m32 = this.m32 - matrix4x3fc.m32();
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Vector4f transform(Vector4fc vector4fc, Vector4f vector4f) {
        return vector4fc.mul((Matrix4x3fc) this, vector4f);
    }

    public Vector3f transformDirection(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.set((vector3fc.z() * this.m20) + (vector3fc.y() * this.m10) + (vector3fc.x() * this.m00), (vector3fc.z() * this.m21) + (vector3fc.y() * this.m11) + (vector3fc.x() * this.m01), (vector3fc.z() * this.m22) + (vector3fc.y() * this.m12) + (vector3fc.x() * this.m02));
        return vector3f;
    }

    public Vector3f transformPosition(Vector3fc vector3fc, Vector3f vector3f) {
        vector3f.set((vector3fc.z() * this.m20) + (vector3fc.y() * this.m10) + (vector3fc.x() * this.m00) + this.m30, (vector3fc.z() * this.m21) + (vector3fc.y() * this.m11) + (vector3fc.x() * this.m01) + this.m31, (vector3fc.z() * this.m22) + (vector3fc.y() * this.m12) + (vector3fc.x() * this.m02) + this.m32);
        return vector3f;
    }

    public Matrix4x3f translate(Vector3fc vector3fc, Matrix4x3f matrix4x3f) {
        return translate(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4x3f);
    }

    public Matrix4x3f translateLocal(Vector3fc vector3fc, Matrix4x3f matrix4x3f) {
        return translateLocal(vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4x3f);
    }

    public Matrix4x3f translationRotateMul(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix4x3fc matrix4x3fc) {
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
        float b2 = a.b(f9, f10, f12, f11);
        float a2 = a.a(f14, f13, f13, f14);
        float c2 = a.c(f15, f16, f15, f16);
        float f19 = (((-f13) + f14) - f13) + f14;
        float c3 = a.c(f11, f12, f9, f10);
        float f20 = f17 + f17;
        float f21 = f20 + f18 + f18;
        float a3 = a.a(f16, f15, f15, f16);
        float f22 = (f20 - f18) - f18;
        float d2 = a.d(f12, f11, f10, f9);
        this.m00 = (matrix4x3fc.m02() * a3) + (matrix4x3fc.m01() * f19) + (matrix4x3fc.m00() * b2);
        this.m01 = (matrix4x3fc.m02() * f22) + (matrix4x3fc.m01() * c3) + (matrix4x3fc.m00() * a2);
        this.m02 = (matrix4x3fc.m02() * d2) + (matrix4x3fc.m01() * f21) + (matrix4x3fc.m00() * c2);
        this.m10 = (matrix4x3fc.m12() * a3) + (matrix4x3fc.m11() * f19) + (matrix4x3fc.m10() * b2);
        this.m11 = (matrix4x3fc.m12() * f22) + (matrix4x3fc.m11() * c3) + (matrix4x3fc.m10() * a2);
        this.m12 = (matrix4x3fc.m12() * d2) + (matrix4x3fc.m11() * f21) + (matrix4x3fc.m10() * c2);
        this.m20 = (matrix4x3fc.m22() * a3) + (matrix4x3fc.m21() * f19) + (matrix4x3fc.m20() * b2);
        this.m21 = (matrix4x3fc.m22() * f22) + (matrix4x3fc.m21() * c3) + (matrix4x3fc.m20() * a2);
        this.m22 = (matrix4x3fc.m22() * d2) + (matrix4x3fc.m21() * f21) + (matrix4x3fc.m20() * c2);
        this.m30 = (matrix4x3fc.m32() * a3) + (matrix4x3fc.m31() * f19) + (matrix4x3fc.m30() * b2) + f2;
        this.m31 = (matrix4x3fc.m32() * f22) + (matrix4x3fc.m31() * c3) + (matrix4x3fc.m30() * a2) + f3;
        this.m32 = (matrix4x3fc.m32() * d2) + (matrix4x3fc.m31() * f21) + (matrix4x3fc.m30() * c2) + f4;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f translationRotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
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
        this.m00 = f17;
        this.m01 = f18;
        this.m02 = f19;
        this.m10 = f20;
        this.m11 = f21;
        this.m12 = f22;
        this.m20 = f11;
        this.m21 = f12;
        this.m22 = f13;
        this.m30 = f2;
        this.m31 = f3;
        this.m32 = f4;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f transpose3x3(Matrix4x3f matrix4x3f) {
        float f2 = this.m00;
        float f3 = this.m10;
        float f4 = this.m20;
        float f5 = this.m01;
        float f6 = this.m11;
        float f7 = this.m21;
        float f8 = this.m02;
        float f9 = this.m12;
        float f10 = this.m22;
        matrix4x3f.m00 = f2;
        matrix4x3f.m01 = f3;
        matrix4x3f.m02 = f4;
        matrix4x3f.m10 = f5;
        matrix4x3f.m11 = f6;
        matrix4x3f.m12 = f7;
        matrix4x3f.m20 = f8;
        matrix4x3f.m21 = f9;
        matrix4x3f.m22 = f10;
        matrix4x3f.properties = this.properties;
        return matrix4x3f;
    }

    private Matrix3f normalOrthonormal(Matrix3f matrix3f) {
        matrix3f.set((Matrix4x3fc) this);
        return matrix3f;
    }

    public Matrix4x3f get(Matrix4x3f matrix4x3f) {
        return matrix4x3f.set((Matrix4x3fc) this);
    }

    public FloatBuffer get4x4(FloatBuffer floatBuffer) {
        return get4x4(floatBuffer.position(), floatBuffer);
    }

    public ByteBuffer getTransposed(ByteBuffer byteBuffer) {
        return getTransposed(byteBuffer.position(), byteBuffer);
    }

    public Matrix4x3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        if ((this.properties & 4) != 0) {
            return setLookAlong(f2, f3, f4, f5, f6, f7);
        }
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
        float f36 = f15 * f35;
        float f37 = f20;
        float f38 = this.m12;
        float f39 = (f18 * f38) + f36;
        float f40 = this.m22;
        float f41 = (f9 * f40) + f39;
        float f42 = (f25 * f10) + (f23 * f19) + (f21 * f16);
        float f43 = f32;
        float f44 = (f32 * f10) + (f30 * f19) + (f27 * f16);
        float f45 = f10 * f40;
        float f46 = f45 + (f19 * f38) + (f16 * f35);
        float f47 = f25 * f33;
        float f48 = f43;
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        matrix4x3f3.m20 = f47 + (f23 * f37) + (f21 * f17);
        float f49 = f48 * f33;
        matrix4x3f3.m21 = f49 + (f30 * f37) + (f27 * f17);
        float f50 = f40 * f33;
        matrix4x3f3.m22 = f50 + (f38 * f37) + (f35 * f17);
        matrix4x3f3.m00 = f29;
        matrix4x3f3.m01 = f34;
        matrix4x3f3.m02 = f41;
        matrix4x3f3.m10 = f42;
        matrix4x3f3.m11 = f44;
        matrix4x3f3.m12 = f46;
        matrix4x3f3.m30 = this.m30;
        matrix4x3f3.m31 = this.m31;
        matrix4x3f3.m32 = this.m32;
        matrix4x3f3.properties = this.properties & -13;
        return matrix4x3f3;
    }

    public Matrix4x3f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return matrix4x3f.setLookAt(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
        return lookAtGeneric(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4x3f);
    }

    public Matrix4x3f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return matrix4x3f.setLookAtLH(f2, f3, f4, f5, f6, f7, f8, f9, f10);
        }
        return lookAtLHGeneric(f2, f3, f4, f5, f6, f7, f8, f9, f10, matrix4x3f);
    }

    public Matrix4x3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7) {
        return rotateTowards(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix4x3f rotateXYZ(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        if ((this.properties & 4) != 0) {
            return matrix4x3f2.rotationXYZ(f5, f6, f7);
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
        float f24 = (sin * f23) + f21;
        float f25 = (f13 * cosFromSin) + (f11 * f8);
        float f26 = (f18 * cosFromSin) + (f15 * f8);
        float f27 = (f23 * cosFromSin) + (f20 * f8);
        float f28 = this.m00;
        float f29 = (f25 * f9) + (f28 * cosFromSin2);
        float f30 = this.m01;
        float f31 = (f26 * f9) + (f30 * cosFromSin2);
        float f32 = this.m02;
        float f33 = (f9 * f27) + (f32 * cosFromSin2);
        matrix4x3f2.m20 = (f25 * cosFromSin2) + (f28 * sin2);
        matrix4x3f2.m21 = (f26 * cosFromSin2) + (f30 * sin2);
        matrix4x3f2.m22 = (f27 * cosFromSin2) + (f32 * sin2);
        matrix4x3f2.m00 = (f14 * f22) + (f29 * cosFromSin3);
        matrix4x3f2.m01 = (f19 * f22) + (f31 * cosFromSin3);
        matrix4x3f2.m02 = (f24 * f22) + (f33 * cosFromSin3);
        matrix4x3f2.m10 = (f14 * cosFromSin3) + (f29 * f17);
        matrix4x3f2.m11 = (f19 * cosFromSin3) + (f31 * f17);
        matrix4x3f2.m12 = (f24 * cosFromSin3) + (f33 * f17);
        matrix4x3f2.m30 = this.m30;
        matrix4x3f2.m31 = this.m31;
        matrix4x3f2.m32 = this.m32;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f rotateYXZ(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        if ((this.properties & 4) != 0) {
            return matrix4x3f2.rotationYXZ(f5, f6, f7);
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
        float f21 = sin2 * f20;
        float f22 = sin3;
        float f23 = this.m22;
        float f24 = (f23 * cosFromSin2) + f21;
        float f25 = (f13 * f8) + (f11 * cosFromSin2);
        float f26 = (f18 * f8) + (f15 * cosFromSin2);
        float f27 = (f23 * f8) + (f20 * cosFromSin2);
        float f28 = this.m10;
        float f29 = (f14 * sin) + (f28 * cosFromSin);
        float f30 = this.m11;
        float f31 = (f19 * sin) + (f30 * cosFromSin);
        float f32 = this.m12;
        float f33 = (sin * f24) + (f32 * cosFromSin);
        matrix4x3f2.m20 = (f14 * cosFromSin) + (f28 * f9);
        matrix4x3f2.m21 = (f19 * cosFromSin) + (f30 * f9);
        matrix4x3f2.m22 = (f24 * cosFromSin) + (f32 * f9);
        matrix4x3f2.m00 = (f29 * f22) + (f25 * cosFromSin3);
        matrix4x3f2.m01 = (f31 * f22) + (f26 * cosFromSin3);
        matrix4x3f2.m02 = (f33 * f22) + (f27 * cosFromSin3);
        matrix4x3f2.m10 = (f29 * cosFromSin3) + (f25 * f17);
        matrix4x3f2.m11 = (f31 * cosFromSin3) + (f26 * f17);
        matrix4x3f2.m12 = (f33 * cosFromSin3) + (f27 * f17);
        matrix4x3f2.m30 = this.m30;
        matrix4x3f2.m31 = this.m31;
        matrix4x3f2.m32 = this.m32;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f rotateZYX(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
        if ((this.properties & 4) != 0) {
            return matrix4x3f2.rotationZYX(f5, f6, f7);
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
        float f24 = (sin3 * f23) + f21;
        float f25 = (f13 * cosFromSin3) + (f11 * f8);
        float f26 = (f18 * cosFromSin3) + (f15 * f8);
        float f27 = (f23 * cosFromSin3) + (f20 * f8);
        float f28 = f14 * sin2;
        float f29 = this.m20;
        float f30 = (f29 * cosFromSin2) + f28;
        float f31 = f19 * sin2;
        float f32 = this.m21;
        float f33 = (f32 * cosFromSin2) + f31;
        float f34 = sin2 * f24;
        float f35 = this.m22;
        float f36 = (f35 * cosFromSin2) + f34;
        matrix4x3f2.m00 = (f29 * f9) + (f14 * cosFromSin2);
        matrix4x3f2.m01 = (f32 * f9) + (f19 * cosFromSin2);
        matrix4x3f2.m02 = (f35 * f9) + (f24 * cosFromSin2);
        matrix4x3f2.m10 = (f30 * f22) + (f25 * cosFromSin);
        matrix4x3f2.m11 = (f33 * f22) + (f26 * cosFromSin);
        matrix4x3f2.m12 = (f36 * f22) + (f27 * cosFromSin);
        matrix4x3f2.m20 = (f30 * cosFromSin) + (f25 * f17);
        matrix4x3f2.m21 = (f33 * cosFromSin) + (f26 * f17);
        matrix4x3f2.m22 = (f36 * cosFromSin) + (f27 * f17);
        matrix4x3f2.m30 = this.m30;
        matrix4x3f2.m31 = this.m31;
        matrix4x3f2.m32 = this.m32;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f rotation(float f2, float f3, float f4, float f5) {
        double d2 = (double) f2;
        float sin = (float) Math.sin(d2);
        float cosFromSin = (float) Math.cosFromSin((double) sin, d2);
        float f6 = 1.0f - cosFromSin;
        float f7 = f3 * f4;
        float f8 = f3 * f5;
        float f9 = f4 * f5;
        this.m00 = (f3 * f3 * f6) + cosFromSin;
        float f10 = f7 * f6;
        float f11 = f5 * sin;
        this.m01 = f10 + f11;
        float f12 = f8 * f6;
        float f13 = f4 * sin;
        this.m02 = f12 - f13;
        this.m10 = f10 - f11;
        this.m11 = (f4 * f4 * f6) + cosFromSin;
        float f14 = f9 * f6;
        float f15 = f3 * sin;
        this.m12 = f14 + f15;
        this.m20 = f12 + f13;
        this.m21 = f14 - f15;
        this.m22 = (f5 * f5 * f6) + cosFromSin;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f scale(float f2, Matrix4x3f matrix4x3f) {
        return scale(f2, f2, f2, matrix4x3f);
    }

    public Matrix4x3f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return shadow(f2, f3, f4, f5, f6, f7, f8, f9, this);
    }

    public Matrix4x3f translate(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return matrix4x3f.translation(f2, f3, f4);
        }
        return translateGeneric(f2, f3, f4, matrix4x3f);
    }

    public Matrix4x3f translateLocal(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = this.m00;
        matrix4x3f.m01 = this.m01;
        matrix4x3f.m02 = this.m02;
        matrix4x3f.m10 = this.m10;
        matrix4x3f.m11 = this.m11;
        matrix4x3f.m12 = this.m12;
        matrix4x3f.m20 = this.m20;
        matrix4x3f.m21 = this.m21;
        matrix4x3f.m22 = this.m22;
        matrix4x3f.m30 = this.m30 + f2;
        matrix4x3f.m31 = this.m31 + f3;
        matrix4x3f.m32 = this.m32 + f4;
        matrix4x3f.properties = this.properties & -5;
        return matrix4x3f;
    }

    public Matrix4x3d get(Matrix4x3d matrix4x3d) {
        return matrix4x3d.set((Matrix4x3fc) this);
    }

    public FloatBuffer get4x4(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer getTransposed(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.putTransposed(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4x3f rotateTowards(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        matrix4x3f2.m30 = this.m30;
        matrix4x3f2.m31 = this.m31;
        matrix4x3f2.m32 = this.m32;
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
        float f35 = f14 * f34;
        float f36 = f9;
        float f37 = this.m12;
        float f38 = (f15 * f37) + f35;
        float f39 = this.m22;
        float f40 = (f16 * f39) + f38;
        float f41 = (f24 * f19) + (f22 * f18) + (f20 * f17);
        float f42 = f31;
        float f43 = (f31 * f19) + (f29 * f18) + (f26 * f17);
        float f44 = f19 * f39;
        float f45 = f44 + (f18 * f37) + (f17 * f34);
        float f46 = f24 * f32;
        float f47 = f42;
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        matrix4x3f3.m20 = f46 + (f22 * f36) + (f20 * f8);
        float f48 = f47 * f32;
        matrix4x3f3.m21 = f48 + (f29 * f36) + (f26 * f8);
        float f49 = f39 * f32;
        matrix4x3f3.m22 = f49 + (f37 * f36) + (f34 * f8);
        matrix4x3f3.m00 = f28;
        matrix4x3f3.m01 = f33;
        matrix4x3f3.m02 = f40;
        matrix4x3f3.m10 = f41;
        matrix4x3f3.m11 = f43;
        matrix4x3f3.m12 = f45;
        matrix4x3f3.properties = this.properties & -13;
        return matrix4x3f3;
    }

    public Matrix4x3f scale(float f2) {
        return scale(f2, f2, f2);
    }

    public Matrix4x3f shadow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f63 = f19 * f62;
        float f64 = f62;
        float f65 = this.m12;
        float f66 = (f21 * f65) + f63;
        float f67 = this.m22;
        float f68 = (f22 * f67) + f66;
        float f69 = this.m32;
        float f70 = (f23 * f69) + f68;
        float f71 = (f47 * f28) + (f44 * f27) + (f41 * f26) + (f39 * f25);
        float f72 = (f60 * f28) + (f58 * f27) + (f53 * f26) + (f50 * f25);
        float f73 = f27 * f67;
        float f74 = f28 * f69;
        float f75 = f74 + f73 + (f26 * f65) + (f25 * f64);
        float f76 = (f47 * f48) + (f44 * f52) + (f41 * f31) + (f39 * f55);
        float f77 = (f60 * f48) + (f58 * f52) + (f53 * f31) + (f50 * f55);
        float f78 = (f69 * f48) + (f67 * f52) + (f31 * f65) + (f64 * f55);
        float f79 = f41 * f36;
        float f80 = f47 * f43;
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        matrix4x3f3.m30 = f80 + (f44 * f46) + f79 + (f39 * f35);
        float f81 = f58 * f46;
        float f82 = f60 * f43;
        matrix4x3f3.m31 = f82 + f81 + (f53 * f36) + (f50 * f35);
        float f83 = f67 * f46;
        float f84 = f69 * f43;
        matrix4x3f3.m32 = f84 + f83 + (f65 * f36) + (f64 * f35);
        matrix4x3f3.m00 = f49;
        matrix4x3f3.m01 = f61;
        matrix4x3f3.m02 = f70;
        matrix4x3f3.m10 = f71;
        matrix4x3f3.m11 = f72;
        matrix4x3f3.m12 = f75;
        matrix4x3f3.m20 = f76;
        matrix4x3f3.m21 = f77;
        matrix4x3f3.m22 = f78;
        matrix4x3f3.properties = this.properties & -29;
        return matrix4x3f3;
    }

    public FloatBuffer get(FloatBuffer floatBuffer) {
        return get(floatBuffer.position(), floatBuffer);
    }

    public ByteBuffer get4x4(ByteBuffer byteBuffer) {
        return get4x4(byteBuffer.position(), byteBuffer);
    }

    public float[] getTransposed(float[] fArr, int i2) {
        fArr[i2 + 0] = this.m00;
        fArr[i2 + 1] = this.m10;
        fArr[i2 + 2] = this.m20;
        fArr[i2 + 3] = this.m30;
        fArr[i2 + 4] = this.m01;
        fArr[i2 + 5] = this.m11;
        fArr[i2 + 6] = this.m21;
        fArr[i2 + 7] = this.m31;
        fArr[i2 + 8] = this.m02;
        fArr[i2 + 9] = this.m12;
        fArr[i2 + 10] = this.m22;
        fArr[i2 + 11] = this.m32;
        return fArr;
    }

    public Matrix4x3f invert() {
        return invert(this);
    }

    public Matrix4x3f obliqueZ(float f2, float f3, Matrix4x3f matrix4x3f) {
        matrix4x3f.m00 = this.m00;
        matrix4x3f.m01 = this.m01;
        matrix4x3f.m02 = this.m02;
        matrix4x3f.m10 = this.m10;
        matrix4x3f.m11 = this.m11;
        matrix4x3f.m12 = this.m12;
        matrix4x3f.m20 = (this.m10 * f3) + (this.m00 * f2) + this.m20;
        matrix4x3f.m21 = (this.m11 * f3) + (this.m01 * f2) + this.m21;
        matrix4x3f.m22 = (this.m12 * f3) + (this.m02 * f2) + this.m22;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = 0;
        return matrix4x3f;
    }

    public Matrix4x3f rotate(float f2, float f3, float f4, float f5) {
        return rotate(f2, f3, f4, f5, this);
    }

    public Matrix4x3f scale(float f2, float f3, float f4, Matrix4x3f matrix4x3f) {
        if ((this.properties & 4) != 0) {
            return matrix4x3f.scaling(f2, f3, f4);
        }
        return scaleGeneric(f2, f3, f4, matrix4x3f);
    }

    public Matrix4x3f set(Matrix4fc matrix4fc) {
        if (matrix4fc instanceof Matrix4f) {
            MemUtil.INSTANCE.copy((Matrix4f) matrix4fc, this);
        } else {
            setMatrix4fc(matrix4fc);
        }
        this.properties = matrix4fc.properties() & 28;
        return this;
    }

    public Matrix4x3f set3x3(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy3x3((Matrix3f) matrix3fc, this);
        } else {
            set3x3Matrix3fc(matrix3fc);
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setTranslation(Vector3fc vector3fc) {
        return setTranslation(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy((Matrix3f) matrix3fc, this);
        } else {
            set3x3Matrix3fc(matrix3fc);
        }
        determineProperties();
    }

    public FloatBuffer get(int i2, FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.put(this, i2, floatBuffer);
        return floatBuffer;
    }

    public ByteBuffer get4x4(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put4x4(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4x3f invertOrtho() {
        return invertOrtho(this);
    }

    public Matrix4x3f lookAt(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return lookAt(f2, f3, f4, f5, f6, f7, f8, f9, f10, this);
    }

    public Matrix4x3f lookAtLH(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        return lookAtLH(f2, f3, f4, f5, f6, f7, f8, f9, f10, this);
    }

    public Matrix3f normal(Matrix3f matrix3f) {
        if ((this.properties & 16) != 0) {
            return normalOrthonormal(matrix3f);
        }
        return normalGeneric(matrix3f);
    }

    public Matrix4x3f rotate(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return matrix4x3f.rotation(quaternionfc);
        }
        if ((i2 & 8) != 0) {
            return rotateTranslation(quaternionfc, matrix4x3f);
        }
        return rotateGeneric(quaternionfc, matrix4x3f);
    }

    public Matrix4x3f translate(float f2, float f3, float f4) {
        int i2 = this.properties;
        if ((i2 & 4) != 0) {
            return translation(f2, f3, f4);
        }
        this.m30 = (this.m20 * f4) + (this.m10 * f3) + (this.m00 * f2) + this.m30;
        this.m31 = (this.m21 * f4) + (this.m11 * f3) + (this.m01 * f2) + this.m31;
        this.m32 = (this.m22 * f4) + (this.m12 * f3) + (this.m02 * f2) + this.m32;
        this.properties = i2 & -5;
        return this;
    }

    public ByteBuffer get(ByteBuffer byteBuffer) {
        return get(byteBuffer.position(), byteBuffer);
    }

    public Matrix4x3f setOrthoSymmetric(float f2, float f3, float f4, float f5) {
        return setOrthoSymmetric(f2, f3, f4, f5, false);
    }

    public Matrix4x3f setOrthoSymmetricLH(float f2, float f3, float f4, float f5) {
        return setOrthoSymmetricLH(f2, f3, f4, f5, false);
    }

    public Matrix4x3f translation(Vector3fc vector3fc) {
        return translation(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public ByteBuffer get(int i2, ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.put(this, i2, byteBuffer);
        return byteBuffer;
    }

    public Matrix4x3f scale(float f2, float f3, float f4) {
        return scale(f2, f3, f4, this);
    }

    public float[] get(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(this, fArr, i2);
        return fArr;
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

    public Matrix4x3f scaling(Vector3fc vector3fc) {
        return scaling(vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f set(Matrix3fc matrix3fc) {
        if (matrix3fc instanceof Matrix3f) {
            MemUtil.INSTANCE.copy((Matrix3f) matrix3fc, this);
        } else {
            setMatrix3fc(matrix3fc);
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3f setOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setOrtho(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4x3f setOrthoLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return setOrthoLH(f2, f3, f4, f5, f6, f7, false);
    }

    public float[] get(float[] fArr) {
        return get(fArr, 0);
    }

    public Matrix4x3f rotate(Quaternionfc quaternionfc) {
        return rotate(quaternionfc, this);
    }

    public Matrix4x3f transformAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3f vector3f, Vector3f vector3f2) {
        return transformAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3f, vector3f2);
    }

    public Matrix4x3f(Matrix4x3fc matrix4x3fc) {
        if (matrix4x3fc instanceof Matrix4x3f) {
            MemUtil.INSTANCE.copy((Matrix4x3f) matrix4x3fc, this);
        } else {
            setMatrix4x3fc(matrix4x3fc);
        }
        this.properties = matrix4x3fc.properties();
    }

    public Matrix4x3f rotate(AxisAngle4f axisAngle4f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z);
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
        return a.a(numberFormat, (double) this.m32, sb, str2);
    }

    public Matrix4x3f rotate(AxisAngle4f axisAngle4f, Matrix4x3f matrix4x3f) {
        return rotate(axisAngle4f.angle, axisAngle4f.x, axisAngle4f.y, axisAngle4f.z, matrix4x3f);
    }

    public Matrix4x3f rotate(float f2, Vector3fc vector3fc) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f set(AxisAngle4f axisAngle4f) {
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
        this.m00 = (float) ((((double) (f5 * f5)) * d3) + cosFromSin);
        this.m11 = (float) ((((double) (f6 * f6)) * d3) + cosFromSin);
        this.m22 = (float) ((((double) (f7 * f7)) * d3) + cosFromSin);
        double d4 = ((double) (f5 * f6)) * d3;
        double d5 = ((double) f7) * sin;
        this.m10 = (float) (d4 - d5);
        this.m01 = (float) (d4 + d5);
        double d6 = ((double) (f5 * f7)) * d3;
        double d7 = ((double) f6) * sin;
        this.m20 = (float) (d6 + d7);
        this.m02 = (float) (d6 - d7);
        double d8 = ((double) (f6 * f7)) * d3;
        double d9 = ((double) f5) * sin;
        this.m21 = (float) (d8 - d9);
        this.m12 = (float) (d8 + d9);
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        return ortho(f2, f3, f4, f5, f6, f7, false, matrix4x3f);
    }

    public Matrix4x3f ortho2D(float f2, float f3, float f4, float f5) {
        return ortho2D(f2, f3, f4, f5, this);
    }

    public Matrix4x3f ortho2DLH(float f2, float f3, float f4, float f5) {
        return ortho2DLH(f2, f3, f4, f5, this);
    }

    public Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        return orthoLH(f2, f3, f4, f5, f6, f7, false, matrix4x3f);
    }

    public Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        return orthoSymmetric(f2, f3, f4, f5, false, matrix4x3f);
    }

    public Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        return orthoSymmetricLH(f2, f3, f4, f5, false, matrix4x3f);
    }

    public Matrix4x3f reflection(float f2, float f3, float f4, float f5, float f6, float f7) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = f4 * sqrt;
        return reflection(f8, f9, f10, (((-f8) * f5) - (f6 * f9)) - (f7 * f10));
    }

    public Matrix4x3f rotate(float f2, Vector3fc vector3fc, Matrix4x3f matrix4x3f) {
        return rotate(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4x3f);
    }

    public Matrix4x3f translationRotateScale(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2) {
        return translationRotateScale(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public boolean equals(Matrix4x3fc matrix4x3fc, float f2) {
        if (this == matrix4x3fc) {
            return true;
        }
        return matrix4x3fc != null && (matrix4x3fc instanceof Matrix4x3f) && Runtime.equals(this.m00, matrix4x3fc.m00(), f2) && Runtime.equals(this.m01, matrix4x3fc.m01(), f2) && Runtime.equals(this.m02, matrix4x3fc.m02(), f2) && Runtime.equals(this.m10, matrix4x3fc.m10(), f2) && Runtime.equals(this.m11, matrix4x3fc.m11(), f2) && Runtime.equals(this.m12, matrix4x3fc.m12(), f2) && Runtime.equals(this.m20, matrix4x3fc.m20(), f2) && Runtime.equals(this.m21, matrix4x3fc.m21(), f2) && Runtime.equals(this.m22, matrix4x3fc.m22(), f2) && Runtime.equals(this.m30, matrix4x3fc.m30(), f2) && Runtime.equals(this.m31, matrix4x3fc.m31(), f2) && Runtime.equals(this.m32, matrix4x3fc.m32(), f2);
    }

    public Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return ortho(f2, f3, f4, f5, f6, f7, z, this);
    }

    public Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        return orthoLH(f2, f3, f4, f5, f6, f7, z, this);
    }

    public Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5, boolean z) {
        return orthoSymmetric(f2, f3, f4, f5, z, this);
    }

    public Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5, boolean z) {
        return orthoSymmetricLH(f2, f3, f4, f5, z, this);
    }

    public Matrix4x3f pick(float f2, float f3, float f4, float f5, int[] iArr) {
        return pick(f2, f3, f4, f5, iArr, this);
    }

    public Matrix4x3f(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        this.m30 = f11;
        this.m31 = f12;
        this.m32 = f13;
        determineProperties();
    }

    public Matrix4x3f ortho(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ortho(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4x3f orthoLH(float f2, float f3, float f4, float f5, float f6, float f7) {
        return orthoLH(f2, f3, f4, f5, f6, f7, false);
    }

    public Matrix4x3f orthoSymmetric(float f2, float f3, float f4, float f5) {
        return orthoSymmetric(f2, f3, f4, f5, false, this);
    }

    public Matrix4x3f orthoSymmetricLH(float f2, float f3, float f4, float f5) {
        return orthoSymmetricLH(f2, f3, f4, f5, false, this);
    }

    public Matrix4x3f reflect(float f2, float f3, float f4, float f5) {
        return reflect(f2, f3, f4, f5, this);
    }

    public Matrix4x3f reflection(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return reflection(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4x3f rotateTranslation(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f) {
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
        float f5 = f2 - a2;
        float c2 = a.c(y, z, w, x);
        float f6 = b3 + a4;
        float f7 = a3 + b2;
        float f8 = b3 - a4;
        float d2 = a.d(z, y, x, w);
        matrix4x3f.m20 = f7;
        matrix4x3f.m21 = f8;
        matrix4x3f.m22 = d2;
        matrix4x3f.m00 = b4;
        matrix4x3f.m01 = f3;
        matrix4x3f.m02 = f4;
        matrix4x3f.m10 = f5;
        matrix4x3f.m11 = c2;
        matrix4x3f.m12 = f6;
        matrix4x3f.m30 = this.m30;
        matrix4x3f.m31 = this.m31;
        matrix4x3f.m32 = this.m32;
        matrix4x3f.properties = this.properties & -13;
        return matrix4x3f;
    }

    public Matrix4x3f translateLocal(float f2, float f3, float f4) {
        return translateLocal(f2, f3, f4, this);
    }

    public float[] getTransposed(float[] fArr) {
        return getTransposed(fArr, 0);
    }

    public Matrix4x3f reflect(float f2, float f3, float f4, float f5, float f6, float f7) {
        return reflect(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix4x3f reflection(Quaternionfc quaternionfc, Vector3fc vector3fc) {
        double x = (double) (quaternionfc.x() + quaternionfc.x());
        double y = (double) (quaternionfc.y() + quaternionfc.y());
        double z = (double) (quaternionfc.z() + quaternionfc.z());
        return reflection((float) ((((double) quaternionfc.w()) * y) + (((double) quaternionfc.x()) * z)), (float) ((((double) quaternionfc.y()) * z) - (((double) quaternionfc.w()) * x)), (float) a.j((double) quaternionfc.y(), y, ((double) quaternionfc.x()) * x, 1.0d), vector3fc.x(), vector3fc.y(), vector3fc.z());
    }

    public Matrix4x3f reflect(float f2, float f3, float f4, float f5, float f6, float f7, Matrix4x3f matrix4x3f) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f8 = f2 * sqrt;
        float f9 = f3 * sqrt;
        float f10 = sqrt * f4;
        return reflect(f8, f9, f10, (((-f8) * f5) - (f6 * f9)) - (f7 * f10), matrix4x3f);
    }

    public Matrix4x3f rotation(Quaternionfc quaternionfc) {
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
        _m00(((w + x) - z) - y);
        _m01(f2 + a2);
        _m02(b2 - a3);
        _m10(f2 - a2);
        _m11(((y - z) + w) - x);
        _m12(b3 + a4);
        _m20(a3 + b2);
        _m21(b3 - a4);
        _m22(((z - y) - x) + w);
        _m30(0.0f);
        _m31(0.0f);
        _m32(0.0f);
        this.properties = 16;
        return this;
    }

    public Matrix4x3f translationRotateScaleMul(Vector3fc vector3fc, Quaternionfc quaternionfc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f) {
        return translationRotateScaleMul(vector3fc.x(), vector3fc.y(), vector3fc.z(), quaternionfc.x(), quaternionfc.y(), quaternionfc.z(), quaternionfc.w(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4x3f);
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

    private Matrix4x3f rotateGeneric(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f) {
        Quaternionfc quaternionfc2 = quaternionfc;
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f5 = f2 - a2;
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
        float f31 = f20;
        float f32 = (f20 * f6) + (f18 * c2) + (f15 * f5);
        float f33 = f6 * f28;
        float f34 = f33 + (c2 * f26) + (f5 * f23);
        float f35 = f13 * f21;
        Matrix4x3f matrix4x3f3 = matrix4x3f;
        float f36 = f31;
        matrix4x3f3.m20 = f35 + (f11 * f25) + (f9 * f7);
        float f37 = f36 * f21;
        matrix4x3f3.m21 = f37 + (f18 * f25) + (f15 * f7);
        float f38 = f28 * f21;
        matrix4x3f3.m22 = f38 + (f26 * f25) + (f23 * f7);
        matrix4x3f3.m00 = f17;
        matrix4x3f3.m01 = f22;
        matrix4x3f3.m02 = f29;
        matrix4x3f3.m10 = f30;
        matrix4x3f3.m11 = f32;
        matrix4x3f3.m12 = f34;
        matrix4x3f3.m30 = this.m30;
        matrix4x3f3.m31 = this.m31;
        matrix4x3f3.m32 = this.m32;
        matrix4x3f3.properties = this.properties & -13;
        return matrix4x3f3;
    }

    public Matrix4x3f reflect(Vector3fc vector3fc, Vector3fc vector3fc2) {
        return reflect(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z());
    }

    public Matrix4x3f rotateLocal(float f2, float f3, float f4, float f5) {
        return rotateLocal(f2, f3, f4, f5, this);
    }

    public Matrix4x3f rotateLocalX(float f2) {
        return rotateLocalX(f2, this);
    }

    public Matrix4x3f rotateLocalY(float f2) {
        return rotateLocalY(f2, this);
    }

    public Matrix4x3f rotateLocalZ(float f2) {
        return rotateLocalZ(f2, this);
    }

    public Matrix4x3f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc) {
        return reflect(quaternionfc, vector3fc, this);
    }

    public Matrix4x3f rotateLocal(Quaternionfc quaternionfc, Matrix4x3f matrix4x3f) {
        Matrix4x3f matrix4x3f2 = matrix4x3f;
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
        float f2 = (((-w2) + y2) - w2) + y2;
        float c3 = a.c(y, z, w, x);
        float f3 = z3 + z3;
        float f4 = f3 + w4 + w4;
        float a3 = a.a(w3, z2, z2, w3);
        float f5 = (f3 - w4) - w4;
        float d2 = a.d(z, y, x, w);
        float f6 = this.m00;
        float f7 = b2 * f6;
        float f8 = this.m01;
        float f9 = (f2 * f8) + f7;
        float f10 = this.m02;
        float f11 = (a3 * f10) + f9;
        float f12 = (f5 * f10) + (c3 * f8) + (a2 * f6);
        float f13 = f10 * d2;
        float f14 = f13 + (f8 * f4) + (f6 * c2);
        float f15 = this.m10;
        float f16 = b2 * f15;
        float f17 = f14;
        float f18 = this.m11;
        float f19 = (f2 * f18) + f16;
        float f20 = this.m12;
        float f21 = f12;
        float f22 = (a3 * f20) + f19;
        float f23 = (f5 * f20) + (c3 * f18) + (a2 * f15);
        float f24 = f20 * d2;
        float f25 = f24 + (f18 * f4) + (f15 * c2);
        float f26 = this.m20;
        float f27 = b2 * f26;
        float f28 = f25;
        float f29 = this.m21;
        float f30 = (f2 * f29) + f27;
        float f31 = this.m22;
        float f32 = f23;
        float f33 = (a3 * f31) + f30;
        float f34 = (f5 * f31) + (c3 * f29) + (a2 * f26);
        float f35 = f31 * d2;
        float f36 = f35 + (f29 * f4) + (f26 * c2);
        float f37 = this.m30;
        float f38 = b2 * f37;
        float f39 = this.m31;
        float f40 = (f2 * f39) + f38;
        float f41 = this.m32;
        float f42 = (a3 * f41) + f40;
        float f43 = f5 * f41;
        float f44 = f43 + (c3 * f39) + (a2 * f37);
        float f45 = d2 * f41;
        float f46 = f45 + (f4 * f39) + (c2 * f37);
        matrix4x3f2.m00 = f11;
        matrix4x3f2.m01 = f21;
        matrix4x3f2.m02 = f17;
        matrix4x3f2.m10 = f22;
        matrix4x3f2.m11 = f32;
        matrix4x3f2.m12 = f28;
        matrix4x3f2.m20 = f33;
        matrix4x3f2.m21 = f34;
        matrix4x3f2.m22 = f36;
        matrix4x3f2.m30 = f42;
        matrix4x3f2.m31 = f44;
        matrix4x3f2.m32 = f46;
        matrix4x3f2.properties = this.properties & -13;
        return matrix4x3f2;
    }

    public Matrix4x3f rotateX(float f2) {
        return rotateX(f2, this);
    }

    public Matrix4x3f rotateY(float f2) {
        return rotateY(f2, this);
    }

    public Matrix4x3f rotateZ(float f2) {
        return rotateZ(f2, this);
    }

    public Matrix4x3f shadow(Vector4fc vector4fc, Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        float m102 = matrix4x3fc.m10();
        float m112 = matrix4x3fc.m11();
        float m122 = matrix4x3fc.m12();
        return shadow(vector4fc.x(), vector4fc.y(), vector4fc.z(), vector4fc.w(), m102, m112, m122, ((matrix4x3fc.m30() * (-m102)) - (matrix4x3fc.m31() * m112)) - (matrix4x3fc.m32() * m122), matrix4x3f);
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

    public Matrix4x3f billboardSpherical(Vector3fc vector3fc, Vector3fc vector3fc2) {
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
        this.m00 = f14;
        this.m01 = f11;
        this.m02 = -f13;
        this.m10 = f11;
        this.m11 = 1.0f - f8;
        this.m12 = f12;
        this.m20 = f13;
        this.m21 = -f12;
        this.m22 = f14 - f8;
        this.m30 = vector3fc.x();
        this.m31 = vector3fc.y();
        this.m32 = vector3fc.z();
        this.properties = 16;
        return this;
    }

    public Matrix4x3f reflect(Quaternionfc quaternionfc, Vector3fc vector3fc, Matrix4x3f matrix4x3f) {
        double x = (double) (quaternionfc.x() + quaternionfc.x());
        double y = (double) (quaternionfc.y() + quaternionfc.y());
        double z = (double) (quaternionfc.z() + quaternionfc.z());
        return reflect((float) ((((double) quaternionfc.w()) * y) + (((double) quaternionfc.x()) * z)), (float) ((((double) quaternionfc.y()) * z) - (((double) quaternionfc.w()) * x)), (float) a.j((double) quaternionfc.y(), y, ((double) quaternionfc.x()) * x, 1.0d), vector3fc.x(), vector3fc.y(), vector3fc.z(), matrix4x3f);
    }

    public Matrix4x3f lookAlong(float f2, float f3, float f4, float f5, float f6, float f7) {
        return lookAlong(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix4x3f shadow(Vector4fc vector4fc, Matrix4x3fc matrix4x3fc) {
        return shadow(vector4fc, matrix4x3fc, this);
    }

    public Matrix4x3f arcball(float f2, Vector3fc vector3fc, float f3, float f4, Matrix4x3f matrix4x3f) {
        return arcball(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), f3, f4, matrix4x3f);
    }

    public Matrix4x3f shadow(float f2, float f3, float f4, float f5, Matrix4x3fc matrix4x3fc, Matrix4x3f matrix4x3f) {
        float m102 = matrix4x3fc.m10();
        float m112 = matrix4x3fc.m11();
        float m122 = matrix4x3fc.m12();
        return shadow(f2, f3, f4, f5, m102, m112, m122, ((matrix4x3fc.m30() * (-m102)) - (matrix4x3fc.m31() * m112)) - (matrix4x3fc.m32() * m122), matrix4x3f);
    }

    public Matrix4x3f arcball(float f2, float f3, float f4, float f5, float f6, float f7) {
        return arcball(f2, f3, f4, f5, f6, f7, this);
    }

    public Matrix4x3f scaleLocal(float f2, float f3, float f4) {
        return scaleLocal(f2, f3, f4, this);
    }

    public Matrix4x3f arcball(float f2, Vector3fc vector3fc, float f3, float f4) {
        return arcball(f2, vector3fc.x(), vector3fc.y(), vector3fc.z(), f3, f4, this);
    }

    public Matrix4x3f reflect(Vector3fc vector3fc, Vector3fc vector3fc2, Matrix4x3f matrix4x3f) {
        return reflect(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), matrix4x3f);
    }

    public Matrix4x3f(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        determineProperties();
    }

    public Matrix4x3f shadow(float f2, float f3, float f4, float f5, Matrix4x3f matrix4x3f) {
        return shadow(f2, f3, f4, f5, (Matrix4x3fc) matrix4x3f, this);
    }

    public Matrix4x3f(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4) {
        if (!(vector3fc instanceof Vector3f) || !(vector3fc2 instanceof Vector3f) || !(vector3fc3 instanceof Vector3f) || !(vector3fc4 instanceof Vector3f)) {
            setVector3fc(vector3fc, vector3fc2, vector3fc3, vector3fc4);
        } else {
            MemUtil.INSTANCE.set(this, (Vector3f) vector3fc, (Vector3f) vector3fc2, (Vector3f) vector3fc3, (Vector3f) vector3fc4);
        }
        determineProperties();
    }

    public Matrix4x3f set(AxisAngle4d axisAngle4d) {
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
        this.m00 = (float) a.d(d7, d7, d11, d12);
        this.m11 = (float) a.d(d8, d8, d11, d12);
        this.m22 = (float) a.d(d9, d9, d11, d12);
        double d13 = d7 * d8 * d10;
        double d14 = d9 * sin;
        this.m10 = (float) (d13 - d14);
        this.m01 = (float) (d13 + d14);
        double d15 = d7 * d9 * d10;
        double d16 = d8 * sin;
        this.m20 = (float) (d15 + d16);
        this.m02 = (float) (d15 - d16);
        double d17 = d8 * d9 * d10;
        double d18 = d7 * sin;
        this.m21 = (float) (d17 - d18);
        this.m12 = (float) (d17 + d18);
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.properties = 16;
        return this;
    }

    public Matrix4x3f rotateLocal(Quaternionfc quaternionfc) {
        return rotateLocal(quaternionfc, this);
    }

    public Matrix4x3f set(Quaternionfc quaternionfc) {
        return rotation(quaternionfc);
    }

    public Matrix4x3f set(Quaterniondc quaterniondc) {
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
        double d2 = w2;
        this.m00 = (float) a.b(w, x, z, y);
        this.m01 = (float) a.a(y2, d2, d2, y2);
        double d3 = z2;
        double d4 = w3;
        this.m02 = (float) a.f(z2, w3, d3, d4);
        double d5 = d2;
        this.m10 = (float) ((((-d5) + y2) - d5) + y2);
        this.m11 = (float) a.f(y, z, w, x);
        double d6 = z3 + z3;
        this.m12 = (float) (d6 + w4 + w4);
        this.m20 = (float) a.a(w3, z2, d3, d4);
        this.m21 = (float) ((d6 - w4) - w4);
        this.m22 = (float) a.g(z, y, x, w);
        this.properties = 16;
        return this;
    }

    public Matrix4x3f set(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4) {
        if (!(vector3fc instanceof Vector3f) || !(vector3fc2 instanceof Vector3f) || !(vector3fc3 instanceof Vector3f) || !(vector3fc4 instanceof Vector3f)) {
            setVector3fc(vector3fc, vector3fc2, vector3fc3, vector3fc4);
        } else {
            MemUtil.INSTANCE.set(this, (Vector3f) vector3fc, (Vector3f) vector3fc2, (Vector3f) vector3fc3, (Vector3f) vector3fc4);
        }
        this.properties = 0;
        return this;
    }

    public Matrix4x3f set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.m00 = f2;
        this.m01 = f3;
        this.m02 = f4;
        this.m10 = f5;
        this.m11 = f6;
        this.m12 = f7;
        this.m20 = f8;
        this.m21 = f9;
        this.m22 = f10;
        this.m30 = f11;
        this.m31 = f12;
        this.m32 = f13;
        this.properties = 0;
        return this;
    }

    public Matrix4x3f set(float[] fArr, int i2) {
        MemUtil.INSTANCE.copy(fArr, i2, this);
        this.properties = 0;
        return this;
    }

    public Matrix4x3f set(float[] fArr) {
        return set(fArr, 0);
    }

    public Matrix4x3f set(FloatBuffer floatBuffer) {
        MemUtil.INSTANCE.get(this, floatBuffer.position(), floatBuffer);
        this.properties = 0;
        return this;
    }

    public Matrix4x3f set(ByteBuffer byteBuffer) {
        MemUtil.INSTANCE.get(this, byteBuffer.position(), byteBuffer);
        this.properties = 0;
        return this;
    }
}
