package com.arashivision.insbase.joml.internal;

import com.arashivision.insbase.joml.Matrix3d;
import com.arashivision.insbase.joml.Matrix3f;
import com.arashivision.insbase.joml.Matrix3x2d;
import com.arashivision.insbase.joml.Matrix3x2f;
import com.arashivision.insbase.joml.Matrix4d;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Matrix4x3d;
import com.arashivision.insbase.joml.Matrix4x3f;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector2d;
import com.arashivision.insbase.joml.Vector2f;
import com.arashivision.insbase.joml.Vector2i;
import com.arashivision.insbase.joml.Vector3d;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insbase.joml.Vector3i;
import com.arashivision.insbase.joml.Vector4d;
import com.arashivision.insbase.joml.Vector4f;
import com.arashivision.insbase.joml.Vector4i;
import e.a.a.a.a;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public abstract class MemUtil {
    public static final MemUtil INSTANCE = createInstance();

    public static class MemUtilNIO extends MemUtil {
        public void broadcast(float f2, Vector4f vector4f) {
            vector4f.x = f2;
            vector4f.y = f2;
            vector4f.z = f2;
            vector4f.w = f2;
        }

        public void copy(Matrix4f matrix4f, Matrix4f matrix4f2) {
            matrix4f2._m00(matrix4f.m00());
            matrix4f2._m01(matrix4f.m01());
            matrix4f2._m02(matrix4f.m02());
            matrix4f2._m03(matrix4f.m03());
            matrix4f2._m10(matrix4f.m10());
            matrix4f2._m11(matrix4f.m11());
            matrix4f2._m12(matrix4f.m12());
            matrix4f2._m13(matrix4f.m13());
            matrix4f2._m20(matrix4f.m20());
            matrix4f2._m21(matrix4f.m21());
            matrix4f2._m22(matrix4f.m22());
            matrix4f2._m23(matrix4f.m23());
            matrix4f2._m30(matrix4f.m30());
            matrix4f2._m31(matrix4f.m31());
            matrix4f2._m32(matrix4f.m32());
            matrix4f2._m33(matrix4f.m33());
        }

        public void copy3x3(Matrix4f matrix4f, Matrix4f matrix4f2) {
            matrix4f2._m00(matrix4f.m00());
            matrix4f2._m01(matrix4f.m01());
            matrix4f2._m02(matrix4f.m02());
            matrix4f2._m10(matrix4f.m10());
            matrix4f2._m11(matrix4f.m11());
            matrix4f2._m12(matrix4f.m12());
            matrix4f2._m20(matrix4f.m20());
            matrix4f2._m21(matrix4f.m21());
            matrix4f2._m22(matrix4f.m22());
        }

        public void copy4x3(Matrix4x3f matrix4x3f, Matrix4f matrix4f) {
            matrix4f._m00(matrix4x3f.m00());
            matrix4f._m01(matrix4x3f.m01());
            matrix4f._m02(matrix4x3f.m02());
            matrix4f._m10(matrix4x3f.m10());
            matrix4f._m11(matrix4x3f.m11());
            matrix4f._m12(matrix4x3f.m12());
            matrix4f._m20(matrix4x3f.m20());
            matrix4f._m21(matrix4x3f.m21());
            matrix4f._m22(matrix4x3f.m22());
            matrix4f._m30(matrix4x3f.m30());
            matrix4f._m31(matrix4x3f.m31());
            matrix4f._m32(matrix4x3f.m32());
        }

        public void copy4x4(Matrix4x3f matrix4x3f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix4x3f.m00();
            fArr[i2 + 1] = matrix4x3f.m01();
            fArr[i2 + 2] = matrix4x3f.m02();
            fArr[i2 + 3] = 0.0f;
            fArr[i2 + 4] = matrix4x3f.m10();
            fArr[i2 + 5] = matrix4x3f.m11();
            fArr[i2 + 6] = matrix4x3f.m12();
            fArr[i2 + 7] = 0.0f;
            fArr[i2 + 8] = matrix4x3f.m20();
            fArr[i2 + 9] = matrix4x3f.m21();
            fArr[i2 + 10] = matrix4x3f.m22();
            fArr[i2 + 11] = 0.0f;
            fArr[i2 + 12] = matrix4x3f.m30();
            fArr[i2 + 13] = matrix4x3f.m31();
            fArr[i2 + 14] = matrix4x3f.m32();
            fArr[i2 + 15] = 1.0f;
        }

        public void get(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            matrix4f._m00(floatBuffer.get(i2));
            matrix4f._m01(floatBuffer.get(i2 + 1));
            matrix4f._m02(floatBuffer.get(i2 + 2));
            matrix4f._m03(floatBuffer.get(i2 + 3));
            matrix4f._m10(floatBuffer.get(i2 + 4));
            matrix4f._m11(floatBuffer.get(i2 + 5));
            matrix4f._m12(floatBuffer.get(i2 + 6));
            matrix4f._m13(floatBuffer.get(i2 + 7));
            matrix4f._m20(floatBuffer.get(i2 + 8));
            matrix4f._m21(floatBuffer.get(i2 + 9));
            matrix4f._m22(floatBuffer.get(i2 + 10));
            matrix4f._m23(floatBuffer.get(i2 + 11));
            matrix4f._m30(floatBuffer.get(i2 + 12));
            matrix4f._m31(floatBuffer.get(i2 + 13));
            matrix4f._m32(floatBuffer.get(i2 + 14));
            matrix4f._m33(floatBuffer.get(i2 + 15));
        }

        public void getColumn0(Matrix4f matrix4f, Vector4f vector4f) {
            matrix4f._m00(vector4f.x);
            matrix4f._m01(vector4f.y);
            matrix4f._m02(vector4f.z);
            matrix4f._m03(vector4f.w);
        }

        public void getColumn1(Matrix4f matrix4f, Vector4f vector4f) {
            matrix4f._m10(vector4f.x);
            matrix4f._m11(vector4f.y);
            matrix4f._m12(vector4f.z);
            matrix4f._m13(vector4f.w);
        }

        public void getColumn2(Matrix4f matrix4f, Vector4f vector4f) {
            matrix4f._m20(vector4f.x);
            matrix4f._m21(vector4f.y);
            matrix4f._m22(vector4f.z);
            matrix4f._m23(vector4f.w);
        }

        public void getColumn3(Matrix4f matrix4f, Vector4f vector4f) {
            matrix4f._m30(vector4f.x);
            matrix4f._m31(vector4f.y);
            matrix4f._m32(vector4f.z);
            matrix4f._m33(vector4f.w);
        }

        public void getf(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer) {
            matrix4d._m00((double) floatBuffer.get(i2));
            matrix4d._m01((double) floatBuffer.get(i2 + 1));
            matrix4d._m02((double) floatBuffer.get(i2 + 2));
            matrix4d._m03((double) floatBuffer.get(i2 + 3));
            matrix4d._m10((double) floatBuffer.get(i2 + 4));
            matrix4d._m11((double) floatBuffer.get(i2 + 5));
            matrix4d._m12((double) floatBuffer.get(i2 + 6));
            matrix4d._m13((double) floatBuffer.get(i2 + 7));
            matrix4d._m20((double) floatBuffer.get(i2 + 8));
            matrix4d._m21((double) floatBuffer.get(i2 + 9));
            matrix4d._m22((double) floatBuffer.get(i2 + 10));
            matrix4d._m23((double) floatBuffer.get(i2 + 11));
            matrix4d._m30((double) floatBuffer.get(i2 + 12));
            matrix4d._m31((double) floatBuffer.get(i2 + 13));
            matrix4d._m32((double) floatBuffer.get(i2 + 14));
            matrix4d._m33((double) floatBuffer.get(i2 + 15));
        }

        public void identity(Matrix4f matrix4f) {
            matrix4f._m00(1.0f);
            matrix4f._m01(0.0f);
            matrix4f._m02(0.0f);
            matrix4f._m03(0.0f);
            a.a(matrix4f, 0.0f, 1.0f, 0.0f, 0.0f);
            a.b(matrix4f, 0.0f, 0.0f, 1.0f, 0.0f);
            a.c(matrix4f, 0.0f, 0.0f, 0.0f, 1.0f);
        }

        public void put(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            if (i2 == 0) {
                put0(matrix4f, floatBuffer);
            } else {
                putN(matrix4f, i2, floatBuffer);
            }
        }

        public void put0(Matrix4f matrix4f, FloatBuffer floatBuffer) {
            floatBuffer.put(0, matrix4f.m00());
            floatBuffer.put(1, matrix4f.m01());
            floatBuffer.put(2, matrix4f.m02());
            floatBuffer.put(3, matrix4f.m03());
            floatBuffer.put(4, matrix4f.m10());
            floatBuffer.put(5, matrix4f.m11());
            floatBuffer.put(6, matrix4f.m12());
            floatBuffer.put(7, matrix4f.m13());
            floatBuffer.put(8, matrix4f.m20());
            floatBuffer.put(9, matrix4f.m21());
            floatBuffer.put(10, matrix4f.m22());
            floatBuffer.put(11, matrix4f.m23());
            floatBuffer.put(12, matrix4f.m30());
            floatBuffer.put(13, matrix4f.m31());
            floatBuffer.put(14, matrix4f.m32());
            floatBuffer.put(15, matrix4f.m33());
        }

        public void put3x3(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix3x2f.m00());
            floatBuffer.put(i2 + 1, matrix3x2f.m01());
            floatBuffer.put(i2 + 2, 0.0f);
            floatBuffer.put(i2 + 3, matrix3x2f.m10());
            floatBuffer.put(i2 + 4, matrix3x2f.m11());
            floatBuffer.put(i2 + 5, 0.0f);
            floatBuffer.put(i2 + 6, matrix3x2f.m20());
            floatBuffer.put(i2 + 7, matrix3x2f.m21());
            floatBuffer.put(i2 + 8, 1.0f);
        }

        public void put4x3(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            if (i2 == 0) {
                put4x3_0(matrix4f, floatBuffer);
            } else {
                put4x3_N(matrix4f, i2, floatBuffer);
            }
        }

        public void put4x3Transposed(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4f.m00());
            floatBuffer.put(i2 + 1, matrix4f.m10());
            floatBuffer.put(i2 + 2, matrix4f.m20());
            floatBuffer.put(i2 + 3, matrix4f.m30());
            floatBuffer.put(i2 + 4, matrix4f.m01());
            floatBuffer.put(i2 + 5, matrix4f.m11());
            floatBuffer.put(i2 + 6, matrix4f.m21());
            floatBuffer.put(i2 + 7, matrix4f.m31());
            floatBuffer.put(i2 + 8, matrix4f.m02());
            floatBuffer.put(i2 + 9, matrix4f.m12());
            floatBuffer.put(i2 + 10, matrix4f.m22());
            floatBuffer.put(i2 + 11, matrix4f.m32());
        }

        public void put4x3_0(Matrix4f matrix4f, FloatBuffer floatBuffer) {
            floatBuffer.put(0, matrix4f.m00());
            floatBuffer.put(1, matrix4f.m01());
            floatBuffer.put(2, matrix4f.m02());
            floatBuffer.put(3, matrix4f.m10());
            floatBuffer.put(4, matrix4f.m11());
            floatBuffer.put(5, matrix4f.m12());
            floatBuffer.put(6, matrix4f.m20());
            floatBuffer.put(7, matrix4f.m21());
            floatBuffer.put(8, matrix4f.m22());
            floatBuffer.put(9, matrix4f.m30());
            floatBuffer.put(10, matrix4f.m31());
            floatBuffer.put(11, matrix4f.m32());
        }

        public void put4x3_N(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4f.m00());
            floatBuffer.put(i2 + 1, matrix4f.m01());
            floatBuffer.put(i2 + 2, matrix4f.m02());
            floatBuffer.put(i2 + 3, matrix4f.m10());
            floatBuffer.put(i2 + 4, matrix4f.m11());
            floatBuffer.put(i2 + 5, matrix4f.m12());
            floatBuffer.put(i2 + 6, matrix4f.m20());
            floatBuffer.put(i2 + 7, matrix4f.m21());
            floatBuffer.put(i2 + 8, matrix4f.m22());
            floatBuffer.put(i2 + 9, matrix4f.m30());
            floatBuffer.put(i2 + 10, matrix4f.m31());
            floatBuffer.put(i2 + 11, matrix4f.m32());
        }

        public void put4x4(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4x3f.m00());
            floatBuffer.put(i2 + 1, matrix4x3f.m01());
            floatBuffer.put(i2 + 2, matrix4x3f.m02());
            floatBuffer.put(i2 + 3, 0.0f);
            floatBuffer.put(i2 + 4, matrix4x3f.m10());
            floatBuffer.put(i2 + 5, matrix4x3f.m11());
            floatBuffer.put(i2 + 6, matrix4x3f.m12());
            floatBuffer.put(i2 + 7, 0.0f);
            floatBuffer.put(i2 + 8, matrix4x3f.m20());
            floatBuffer.put(i2 + 9, matrix4x3f.m21());
            floatBuffer.put(i2 + 10, matrix4x3f.m22());
            floatBuffer.put(i2 + 11, 0.0f);
            floatBuffer.put(i2 + 12, matrix4x3f.m30());
            floatBuffer.put(i2 + 13, matrix4x3f.m31());
            floatBuffer.put(i2 + 14, matrix4x3f.m32());
            floatBuffer.put(i2 + 15, 1.0f);
        }

        public void putColumn0(Matrix4f matrix4f, Vector4f vector4f) {
            vector4f.x = matrix4f.m00();
            vector4f.y = matrix4f.m01();
            vector4f.z = matrix4f.m02();
            vector4f.w = matrix4f.m03();
        }

        public void putColumn1(Matrix4f matrix4f, Vector4f vector4f) {
            vector4f.x = matrix4f.m10();
            vector4f.y = matrix4f.m11();
            vector4f.z = matrix4f.m12();
            vector4f.w = matrix4f.m13();
        }

        public void putColumn2(Matrix4f matrix4f, Vector4f vector4f) {
            vector4f.x = matrix4f.m20();
            vector4f.y = matrix4f.m21();
            vector4f.z = matrix4f.m22();
            vector4f.w = matrix4f.m23();
        }

        public void putColumn3(Matrix4f matrix4f, Vector4f vector4f) {
            vector4f.x = matrix4f.m30();
            vector4f.y = matrix4f.m31();
            vector4f.z = matrix4f.m32();
            vector4f.w = matrix4f.m33();
        }

        public void putMatrix3f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            byteBuffer.putFloat(i2, ((f3 + f5) - f9) - f7);
            byteBuffer.putFloat(i2 + 4, f11 + f10 + f10 + f11);
            byteBuffer.putFloat(i2 + 8, ((f12 - f13) + f12) - f13);
            byteBuffer.putFloat(i2 + 12, (((-f10) + f11) - f10) + f11);
            byteBuffer.putFloat(i2 + 16, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            byteBuffer.putFloat(i2 + 20, f16 + f15 + f15);
            byteBuffer.putFloat(i2 + 24, f13 + f12 + f12 + f13);
            byteBuffer.putFloat(i2 + 28, (f16 - f15) - f15);
            byteBuffer.putFloat(i2 + 32, ((f9 - f7) - f5) + f3);
        }

        public void putMatrix4f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            byteBuffer.putFloat(i2, ((f3 + f5) - f9) - f7);
            byteBuffer.putFloat(i2 + 4, f11 + f10 + f10 + f11);
            byteBuffer.putFloat(i2 + 8, ((f12 - f13) + f12) - f13);
            byteBuffer.putFloat(i2 + 12, 0.0f);
            byteBuffer.putFloat(i2 + 16, (((-f10) + f11) - f10) + f11);
            byteBuffer.putFloat(i2 + 20, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            byteBuffer.putFloat(i2 + 24, f16 + f15 + f15);
            byteBuffer.putFloat(i2 + 28, 0.0f);
            byteBuffer.putFloat(i2 + 32, f13 + f12 + f12 + f13);
            byteBuffer.putFloat(i2 + 36, (f16 - f15) - f15);
            byteBuffer.putFloat(i2 + 40, ((f9 - f7) - f5) + f3);
            byteBuffer.putFloat(i2 + 44, 0.0f);
            byteBuffer.putLong(i2 + 48, 0);
            byteBuffer.putLong(i2 + 56, 4575657221408423936L);
        }

        public void putMatrix4x3f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            byteBuffer.putFloat(i2, ((f3 + f5) - f9) - f7);
            byteBuffer.putFloat(i2 + 4, f11 + f10 + f10 + f11);
            byteBuffer.putFloat(i2 + 8, ((f12 - f13) + f12) - f13);
            byteBuffer.putFloat(i2 + 12, (((-f10) + f11) - f10) + f11);
            byteBuffer.putFloat(i2 + 16, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            byteBuffer.putFloat(i2 + 20, f16 + f15 + f15);
            byteBuffer.putFloat(i2 + 24, f13 + f12 + f12 + f13);
            byteBuffer.putFloat(i2 + 28, (f16 - f15) - f15);
            byteBuffer.putFloat(i2 + 32, ((f9 - f7) - f5) + f3);
            byteBuffer.putLong(i2 + 36, 0);
            byteBuffer.putFloat(i2 + 44, 0.0f);
        }

        public void putN(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4f.m00());
            floatBuffer.put(i2 + 1, matrix4f.m01());
            floatBuffer.put(i2 + 2, matrix4f.m02());
            floatBuffer.put(i2 + 3, matrix4f.m03());
            floatBuffer.put(i2 + 4, matrix4f.m10());
            floatBuffer.put(i2 + 5, matrix4f.m11());
            floatBuffer.put(i2 + 6, matrix4f.m12());
            floatBuffer.put(i2 + 7, matrix4f.m13());
            floatBuffer.put(i2 + 8, matrix4f.m20());
            floatBuffer.put(i2 + 9, matrix4f.m21());
            floatBuffer.put(i2 + 10, matrix4f.m22());
            floatBuffer.put(i2 + 11, matrix4f.m23());
            floatBuffer.put(i2 + 12, matrix4f.m30());
            floatBuffer.put(i2 + 13, matrix4f.m31());
            floatBuffer.put(i2 + 14, matrix4f.m32());
            floatBuffer.put(i2 + 15, matrix4f.m33());
        }

        public void putTransposed(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4f.m00());
            floatBuffer.put(i2 + 1, matrix4f.m10());
            floatBuffer.put(i2 + 2, matrix4f.m20());
            floatBuffer.put(i2 + 3, matrix4f.m30());
            floatBuffer.put(i2 + 4, matrix4f.m01());
            floatBuffer.put(i2 + 5, matrix4f.m11());
            floatBuffer.put(i2 + 6, matrix4f.m21());
            floatBuffer.put(i2 + 7, matrix4f.m31());
            floatBuffer.put(i2 + 8, matrix4f.m02());
            floatBuffer.put(i2 + 9, matrix4f.m12());
            floatBuffer.put(i2 + 10, matrix4f.m22());
            floatBuffer.put(i2 + 11, matrix4f.m32());
            floatBuffer.put(i2 + 12, matrix4f.m03());
            floatBuffer.put(i2 + 13, matrix4f.m13());
            floatBuffer.put(i2 + 14, matrix4f.m23());
            floatBuffer.put(i2 + 15, matrix4f.m33());
        }

        public void putf(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, (float) matrix4d.m00());
            floatBuffer.put(i2 + 1, (float) matrix4d.m01());
            floatBuffer.put(i2 + 2, (float) matrix4d.m02());
            floatBuffer.put(i2 + 3, (float) matrix4d.m03());
            floatBuffer.put(i2 + 4, (float) matrix4d.m10());
            floatBuffer.put(i2 + 5, (float) matrix4d.m11());
            floatBuffer.put(i2 + 6, (float) matrix4d.m12());
            floatBuffer.put(i2 + 7, (float) matrix4d.m13());
            floatBuffer.put(i2 + 8, (float) matrix4d.m20());
            floatBuffer.put(i2 + 9, (float) matrix4d.m21());
            floatBuffer.put(i2 + 10, (float) matrix4d.m22());
            floatBuffer.put(i2 + 11, (float) matrix4d.m23());
            floatBuffer.put(i2 + 12, (float) matrix4d.m30());
            floatBuffer.put(i2 + 13, (float) matrix4d.m31());
            floatBuffer.put(i2 + 14, (float) matrix4d.m32());
            floatBuffer.put(i2 + 15, (float) matrix4d.m33());
        }

        public void putfTransposed(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, (float) matrix4x3d.m00());
            floatBuffer.put(i2 + 1, (float) matrix4x3d.m10());
            floatBuffer.put(i2 + 2, (float) matrix4x3d.m20());
            floatBuffer.put(i2 + 3, (float) matrix4x3d.m30());
            floatBuffer.put(i2 + 4, (float) matrix4x3d.m01());
            floatBuffer.put(i2 + 5, (float) matrix4x3d.m11());
            floatBuffer.put(i2 + 6, (float) matrix4x3d.m21());
            floatBuffer.put(i2 + 7, (float) matrix4x3d.m31());
            floatBuffer.put(i2 + 8, (float) matrix4x3d.m02());
            floatBuffer.put(i2 + 9, (float) matrix4x3d.m12());
            floatBuffer.put(i2 + 10, (float) matrix4x3d.m22());
            floatBuffer.put(i2 + 11, (float) matrix4x3d.m32());
        }

        public void set(Matrix4f matrix4f, Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3, Vector4f vector4f4) {
            matrix4f._m00(vector4f.x);
            matrix4f._m01(vector4f.y);
            matrix4f._m02(vector4f.z);
            matrix4f._m03(vector4f.w);
            matrix4f._m10(vector4f2.x);
            matrix4f._m11(vector4f2.y);
            matrix4f._m12(vector4f2.z);
            matrix4f._m13(vector4f2.w);
            matrix4f._m20(vector4f3.x);
            matrix4f._m21(vector4f3.y);
            matrix4f._m22(vector4f3.z);
            matrix4f._m23(vector4f3.w);
            matrix4f._m30(vector4f4.x);
            matrix4f._m31(vector4f4.y);
            matrix4f._m32(vector4f4.z);
            matrix4f._m33(vector4f4.w);
        }

        public void swap(Matrix4f matrix4f, Matrix4f matrix4f2) {
            float m00 = matrix4f.m00();
            matrix4f._m00(matrix4f2.m00());
            matrix4f2._m00(m00);
            float m01 = matrix4f.m01();
            matrix4f._m01(matrix4f2.m01());
            matrix4f2._m01(m01);
            float m02 = matrix4f.m02();
            matrix4f._m02(matrix4f2.m02());
            matrix4f2._m02(m02);
            float m03 = matrix4f.m03();
            matrix4f._m03(matrix4f2.m03());
            matrix4f2._m03(m03);
            float m10 = matrix4f.m10();
            matrix4f._m10(matrix4f2.m10());
            matrix4f2._m10(m10);
            float m11 = matrix4f.m11();
            matrix4f._m11(matrix4f2.m11());
            matrix4f2._m11(m11);
            float m12 = matrix4f.m12();
            matrix4f._m12(matrix4f2.m12());
            matrix4f2._m12(m12);
            float m13 = matrix4f.m13();
            matrix4f._m13(matrix4f2.m13());
            matrix4f2._m13(m13);
            float m20 = matrix4f.m20();
            matrix4f._m20(matrix4f2.m20());
            matrix4f2._m20(m20);
            float m21 = matrix4f.m21();
            matrix4f._m21(matrix4f2.m21());
            matrix4f2._m21(m21);
            float m22 = matrix4f.m22();
            matrix4f._m22(matrix4f2.m22());
            matrix4f2._m22(m22);
            float m23 = matrix4f.m23();
            matrix4f._m23(matrix4f2.m23());
            matrix4f2._m23(m23);
            float m30 = matrix4f.m30();
            matrix4f._m30(matrix4f2.m30());
            matrix4f2._m30(m30);
            float m31 = matrix4f.m31();
            matrix4f._m31(matrix4f2.m31());
            matrix4f2._m31(m31);
            float m32 = matrix4f.m32();
            matrix4f._m32(matrix4f2.m32());
            matrix4f2._m32(m32);
            float m33 = matrix4f.m33();
            matrix4f._m33(matrix4f2.m33());
            matrix4f2._m33(m33);
        }

        public void zero(Matrix4f matrix4f) {
            matrix4f._m00(0.0f);
            matrix4f._m01(0.0f);
            matrix4f._m02(0.0f);
            matrix4f._m03(0.0f);
            a.a(matrix4f, 0.0f, 0.0f, 0.0f, 0.0f);
            a.b(matrix4f, 0.0f, 0.0f, 0.0f, 0.0f);
            a.c(matrix4f, 0.0f, 0.0f, 0.0f, 0.0f);
        }

        public void put(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            if (i2 == 0) {
                put0(matrix4f, byteBuffer);
            } else {
                putN(matrix4f, i2, byteBuffer);
            }
        }

        public void put4x3(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            if (i2 == 0) {
                put4x3_0(matrix4f, byteBuffer);
            } else {
                put4x3_N(matrix4f, i2, byteBuffer);
            }
        }

        public void broadcast(int i2, Vector4i vector4i) {
            vector4i.x = i2;
            vector4i.y = i2;
            vector4i.z = i2;
            vector4i.w = i2;
        }

        public void put(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer) {
            if (i2 == 0) {
                put0(matrix4x3f, floatBuffer);
            } else {
                putN(matrix4x3f, i2, floatBuffer);
            }
        }

        public void putColumn0(Matrix4f matrix4f, Vector3f vector3f) {
            vector3f.x = matrix4f.m00();
            vector3f.y = matrix4f.m01();
            vector3f.z = matrix4f.m02();
        }

        public void putColumn1(Matrix4f matrix4f, Vector3f vector3f) {
            vector3f.x = matrix4f.m10();
            vector3f.y = matrix4f.m11();
            vector3f.z = matrix4f.m12();
        }

        public void putColumn2(Matrix4f matrix4f, Vector3f vector3f) {
            vector3f.x = matrix4f.m20();
            vector3f.y = matrix4f.m21();
            vector3f.z = matrix4f.m22();
        }

        public void putColumn3(Matrix4f matrix4f, Vector3f vector3f) {
            vector3f.x = matrix4f.m30();
            vector3f.y = matrix4f.m31();
            vector3f.z = matrix4f.m32();
        }

        public void put(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer) {
            if (i2 == 0) {
                put0(matrix4x3f, byteBuffer);
            } else {
                putN(matrix4x3f, i2, byteBuffer);
            }
        }

        public void identity(Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(1.0f);
            matrix4x3f._m01(0.0f);
            matrix4x3f._m02(0.0f);
            matrix4x3f._m10(0.0f);
            matrix4x3f._m11(1.0f);
            matrix4x3f._m12(0.0f);
            matrix4x3f._m20(0.0f);
            matrix4x3f._m21(0.0f);
            matrix4x3f._m22(1.0f);
            matrix4x3f._m30(0.0f);
            matrix4x3f._m31(0.0f);
            matrix4x3f._m32(0.0f);
        }

        public void zero(Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(0.0f);
            matrix4x3f._m01(0.0f);
            matrix4x3f._m02(0.0f);
            matrix4x3f._m10(0.0f);
            matrix4x3f._m11(0.0f);
            matrix4x3f._m12(0.0f);
            matrix4x3f._m20(0.0f);
            matrix4x3f._m21(0.0f);
            matrix4x3f._m22(0.0f);
            matrix4x3f._m30(0.0f);
            matrix4x3f._m31(0.0f);
            matrix4x3f._m32(0.0f);
        }

        public void put(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4d.m00());
            doubleBuffer.put(i2 + 1, matrix4d.m01());
            doubleBuffer.put(i2 + 2, matrix4d.m02());
            doubleBuffer.put(i2 + 3, matrix4d.m03());
            doubleBuffer.put(i2 + 4, matrix4d.m10());
            doubleBuffer.put(i2 + 5, matrix4d.m11());
            doubleBuffer.put(i2 + 6, matrix4d.m12());
            doubleBuffer.put(i2 + 7, matrix4d.m13());
            doubleBuffer.put(i2 + 8, matrix4d.m20());
            doubleBuffer.put(i2 + 9, matrix4d.m21());
            doubleBuffer.put(i2 + 10, matrix4d.m22());
            doubleBuffer.put(i2 + 11, matrix4d.m23());
            doubleBuffer.put(i2 + 12, matrix4d.m30());
            doubleBuffer.put(i2 + 13, matrix4d.m31());
            doubleBuffer.put(i2 + 14, matrix4d.m32());
            doubleBuffer.put(i2 + 15, matrix4d.m33());
        }

        public void copy3x3(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2) {
            matrix4x3f2._m00(matrix4x3f.m00());
            matrix4x3f2._m01(matrix4x3f.m01());
            matrix4x3f2._m02(matrix4x3f.m02());
            matrix4x3f2._m10(matrix4x3f.m10());
            matrix4x3f2._m11(matrix4x3f.m11());
            matrix4x3f2._m12(matrix4x3f.m12());
            matrix4x3f2._m20(matrix4x3f.m20());
            matrix4x3f2._m21(matrix4x3f.m21());
            matrix4x3f2._m22(matrix4x3f.m22());
        }

        public void put3x3(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix3x2f.m00());
            byteBuffer.putFloat(i2 + 4, matrix3x2f.m01());
            byteBuffer.putFloat(i2 + 8, 0.0f);
            byteBuffer.putFloat(i2 + 12, matrix3x2f.m10());
            byteBuffer.putFloat(i2 + 16, matrix3x2f.m11());
            byteBuffer.putFloat(i2 + 20, 0.0f);
            byteBuffer.putFloat(i2 + 24, matrix3x2f.m20());
            byteBuffer.putFloat(i2 + 28, matrix3x2f.m21());
            byteBuffer.putFloat(i2 + 32, 1.0f);
        }

        private void put4x3_N(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4f.m01());
            byteBuffer.putFloat(i2 + 8, matrix4f.m02());
            byteBuffer.putFloat(i2 + 12, matrix4f.m10());
            byteBuffer.putFloat(i2 + 16, matrix4f.m11());
            byteBuffer.putFloat(i2 + 20, matrix4f.m12());
            byteBuffer.putFloat(i2 + 24, matrix4f.m20());
            byteBuffer.putFloat(i2 + 28, matrix4f.m21());
            byteBuffer.putFloat(i2 + 32, matrix4f.m22());
            byteBuffer.putFloat(i2 + 36, matrix4f.m30());
            byteBuffer.putFloat(i2 + 40, matrix4f.m31());
            byteBuffer.putFloat(i2 + 44, matrix4f.m32());
        }

        public void copy4x3(Matrix4f matrix4f, Matrix4f matrix4f2) {
            matrix4f2._m00(matrix4f.m00());
            matrix4f2._m01(matrix4f.m01());
            matrix4f2._m02(matrix4f.m02());
            matrix4f2._m10(matrix4f.m10());
            matrix4f2._m11(matrix4f.m11());
            matrix4f2._m12(matrix4f.m12());
            matrix4f2._m20(matrix4f.m20());
            matrix4f2._m21(matrix4f.m21());
            matrix4f2._m22(matrix4f.m22());
            matrix4f2._m30(matrix4f.m30());
            matrix4f2._m31(matrix4f.m31());
            matrix4f2._m32(matrix4f.m32());
        }

        public void put4x3Transposed(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4f.m10());
            byteBuffer.putFloat(i2 + 8, matrix4f.m20());
            byteBuffer.putFloat(i2 + 12, matrix4f.m30());
            byteBuffer.putFloat(i2 + 16, matrix4f.m01());
            byteBuffer.putFloat(i2 + 20, matrix4f.m11());
            byteBuffer.putFloat(i2 + 24, matrix4f.m21());
            byteBuffer.putFloat(i2 + 28, matrix4f.m31());
            byteBuffer.putFloat(i2 + 32, matrix4f.m02());
            byteBuffer.putFloat(i2 + 36, matrix4f.m12());
            byteBuffer.putFloat(i2 + 40, matrix4f.m22());
            byteBuffer.putFloat(i2 + 44, matrix4f.m32());
        }

        public void put4x3_0(Matrix4f matrix4f, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(0, matrix4f.m00());
            byteBuffer.putFloat(4, matrix4f.m01());
            byteBuffer.putFloat(8, matrix4f.m02());
            byteBuffer.putFloat(12, matrix4f.m10());
            byteBuffer.putFloat(16, matrix4f.m11());
            byteBuffer.putFloat(20, matrix4f.m12());
            byteBuffer.putFloat(24, matrix4f.m20());
            byteBuffer.putFloat(28, matrix4f.m21());
            byteBuffer.putFloat(32, matrix4f.m22());
            byteBuffer.putFloat(36, matrix4f.m30());
            byteBuffer.putFloat(40, matrix4f.m31());
            byteBuffer.putFloat(44, matrix4f.m32());
        }

        public void putfTransposed(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, (float) matrix4x3d.m00());
            byteBuffer.putFloat(i2 + 4, (float) matrix4x3d.m10());
            byteBuffer.putFloat(i2 + 8, (float) matrix4x3d.m20());
            byteBuffer.putFloat(i2 + 12, (float) matrix4x3d.m30());
            byteBuffer.putFloat(i2 + 16, (float) matrix4x3d.m01());
            byteBuffer.putFloat(i2 + 20, (float) matrix4x3d.m11());
            byteBuffer.putFloat(i2 + 24, (float) matrix4x3d.m21());
            byteBuffer.putFloat(i2 + 28, (float) matrix4x3d.m31());
            byteBuffer.putFloat(i2 + 32, (float) matrix4x3d.m02());
            byteBuffer.putFloat(i2 + 36, (float) matrix4x3d.m12());
            byteBuffer.putFloat(i2 + 40, (float) matrix4x3d.m22());
            byteBuffer.putFloat(i2 + 44, (float) matrix4x3d.m32());
        }

        public void putMatrix3f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            floatBuffer.put(i2, ((f3 + f5) - f9) - f7);
            floatBuffer.put(i2 + 1, f11 + f10 + f10 + f11);
            floatBuffer.put(i2 + 2, ((f12 - f13) + f12) - f13);
            floatBuffer.put(i2 + 3, (((-f10) + f11) - f10) + f11);
            floatBuffer.put(i2 + 4, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            floatBuffer.put(i2 + 5, f16 + f15 + f15);
            floatBuffer.put(i2 + 6, f13 + f12 + f12 + f13);
            floatBuffer.put(i2 + 7, (f16 - f15) - f15);
            floatBuffer.put(i2 + 8, ((f9 - f7) - f5) + f3);
        }

        public void putMatrix4x3f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            floatBuffer.put(i2, ((f3 + f5) - f9) - f7);
            floatBuffer.put(i2 + 1, f11 + f10 + f10 + f11);
            floatBuffer.put(i2 + 2, ((f12 - f13) + f12) - f13);
            floatBuffer.put(i2 + 3, (((-f10) + f11) - f10) + f11);
            floatBuffer.put(i2 + 4, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            floatBuffer.put(i2 + 5, f16 + f15 + f15);
            floatBuffer.put(i2 + 6, f13 + f12 + f12 + f13);
            floatBuffer.put(i2 + 7, (f16 - f15) - f15);
            floatBuffer.put(i2 + 8, ((f9 - f7) - f5) + f3);
            floatBuffer.put(i2 + 9, 0.0f);
            floatBuffer.put(i2 + 10, 0.0f);
            floatBuffer.put(i2 + 11, 0.0f);
        }

        private void putN(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4f.m01());
            byteBuffer.putFloat(i2 + 8, matrix4f.m02());
            byteBuffer.putFloat(i2 + 12, matrix4f.m03());
            byteBuffer.putFloat(i2 + 16, matrix4f.m10());
            byteBuffer.putFloat(i2 + 20, matrix4f.m11());
            byteBuffer.putFloat(i2 + 24, matrix4f.m12());
            byteBuffer.putFloat(i2 + 28, matrix4f.m13());
            byteBuffer.putFloat(i2 + 32, matrix4f.m20());
            byteBuffer.putFloat(i2 + 36, matrix4f.m21());
            byteBuffer.putFloat(i2 + 40, matrix4f.m22());
            byteBuffer.putFloat(i2 + 44, matrix4f.m23());
            byteBuffer.putFloat(i2 + 48, matrix4f.m30());
            byteBuffer.putFloat(i2 + 52, matrix4f.m31());
            byteBuffer.putFloat(i2 + 56, matrix4f.m32());
            byteBuffer.putFloat(i2 + 60, matrix4f.m33());
        }

        public void copy(Matrix3f matrix3f, Matrix4f matrix4f) {
            matrix4f._m00(matrix3f.m00());
            matrix4f._m01(matrix3f.m01());
            matrix4f._m02(matrix3f.m02());
            matrix4f._m03(0.0f);
            matrix4f._m10(matrix3f.m10());
            matrix4f._m11(matrix3f.m11());
            matrix4f._m12(matrix3f.m12());
            matrix4f._m13(0.0f);
            matrix4f._m20(matrix3f.m20());
            matrix4f._m21(matrix3f.m21());
            matrix4f._m22(matrix3f.m22());
            matrix4f._m23(0.0f);
            a.c(matrix4f, 0.0f, 0.0f, 0.0f, 1.0f);
        }

        public void copy4x4(Matrix4x3d matrix4x3d, float[] fArr, int i2) {
            fArr[i2 + 0] = (float) matrix4x3d.m00();
            fArr[i2 + 1] = (float) matrix4x3d.m01();
            fArr[i2 + 2] = (float) matrix4x3d.m02();
            fArr[i2 + 3] = 0.0f;
            fArr[i2 + 4] = (float) matrix4x3d.m10();
            fArr[i2 + 5] = (float) matrix4x3d.m11();
            fArr[i2 + 6] = (float) matrix4x3d.m12();
            fArr[i2 + 7] = 0.0f;
            fArr[i2 + 8] = (float) matrix4x3d.m20();
            fArr[i2 + 9] = (float) matrix4x3d.m21();
            fArr[i2 + 10] = (float) matrix4x3d.m22();
            fArr[i2 + 11] = 0.0f;
            fArr[i2 + 12] = (float) matrix4x3d.m30();
            fArr[i2 + 13] = (float) matrix4x3d.m31();
            fArr[i2 + 14] = (float) matrix4x3d.m32();
            fArr[i2 + 15] = 1.0f;
        }

        public void get(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            matrix4f._m00(byteBuffer.getFloat(i2));
            matrix4f._m01(byteBuffer.getFloat(i2 + 4));
            matrix4f._m02(byteBuffer.getFloat(i2 + 8));
            matrix4f._m03(byteBuffer.getFloat(i2 + 12));
            matrix4f._m10(byteBuffer.getFloat(i2 + 16));
            matrix4f._m11(byteBuffer.getFloat(i2 + 20));
            matrix4f._m12(byteBuffer.getFloat(i2 + 24));
            matrix4f._m13(byteBuffer.getFloat(i2 + 28));
            matrix4f._m20(byteBuffer.getFloat(i2 + 32));
            matrix4f._m21(byteBuffer.getFloat(i2 + 36));
            matrix4f._m22(byteBuffer.getFloat(i2 + 40));
            matrix4f._m23(byteBuffer.getFloat(i2 + 44));
            matrix4f._m30(byteBuffer.getFloat(i2 + 48));
            matrix4f._m31(byteBuffer.getFloat(i2 + 52));
            matrix4f._m32(byteBuffer.getFloat(i2 + 56));
            matrix4f._m33(byteBuffer.getFloat(i2 + 60));
        }

        public void getf(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            matrix4d._m00((double) byteBuffer.getFloat(i2));
            matrix4d._m01((double) byteBuffer.getFloat(i2 + 4));
            matrix4d._m02((double) byteBuffer.getFloat(i2 + 8));
            matrix4d._m03((double) byteBuffer.getFloat(i2 + 12));
            matrix4d._m10((double) byteBuffer.getFloat(i2 + 16));
            matrix4d._m11((double) byteBuffer.getFloat(i2 + 20));
            matrix4d._m12((double) byteBuffer.getFloat(i2 + 24));
            matrix4d._m13((double) byteBuffer.getFloat(i2 + 28));
            matrix4d._m20((double) byteBuffer.getFloat(i2 + 32));
            matrix4d._m21((double) byteBuffer.getFloat(i2 + 36));
            matrix4d._m22((double) byteBuffer.getFloat(i2 + 40));
            matrix4d._m23((double) byteBuffer.getFloat(i2 + 44));
            matrix4d._m30((double) byteBuffer.getFloat(i2 + 48));
            matrix4d._m31((double) byteBuffer.getFloat(i2 + 52));
            matrix4d._m32((double) byteBuffer.getFloat(i2 + 56));
            matrix4d._m33((double) byteBuffer.getFloat(i2 + 60));
        }

        public void put0(Matrix4f matrix4f, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(0, matrix4f.m00());
            byteBuffer.putFloat(4, matrix4f.m01());
            byteBuffer.putFloat(8, matrix4f.m02());
            byteBuffer.putFloat(12, matrix4f.m03());
            byteBuffer.putFloat(16, matrix4f.m10());
            byteBuffer.putFloat(20, matrix4f.m11());
            byteBuffer.putFloat(24, matrix4f.m12());
            byteBuffer.putFloat(28, matrix4f.m13());
            byteBuffer.putFloat(32, matrix4f.m20());
            byteBuffer.putFloat(36, matrix4f.m21());
            byteBuffer.putFloat(40, matrix4f.m22());
            byteBuffer.putFloat(44, matrix4f.m23());
            byteBuffer.putFloat(48, matrix4f.m30());
            byteBuffer.putFloat(52, matrix4f.m31());
            byteBuffer.putFloat(56, matrix4f.m32());
            byteBuffer.putFloat(60, matrix4f.m33());
        }

        public void put4x4(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4x3f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4x3f.m01());
            byteBuffer.putFloat(i2 + 8, matrix4x3f.m02());
            byteBuffer.putFloat(i2 + 12, 0.0f);
            byteBuffer.putFloat(i2 + 16, matrix4x3f.m10());
            byteBuffer.putFloat(i2 + 20, matrix4x3f.m11());
            byteBuffer.putFloat(i2 + 24, matrix4x3f.m12());
            byteBuffer.putFloat(i2 + 28, 0.0f);
            byteBuffer.putFloat(i2 + 32, matrix4x3f.m20());
            byteBuffer.putFloat(i2 + 36, matrix4x3f.m21());
            byteBuffer.putFloat(i2 + 40, matrix4x3f.m22());
            byteBuffer.putFloat(i2 + 44, 0.0f);
            byteBuffer.putFloat(i2 + 48, matrix4x3f.m30());
            byteBuffer.putFloat(i2 + 52, matrix4x3f.m31());
            byteBuffer.putFloat(i2 + 56, matrix4x3f.m32());
            byteBuffer.putFloat(i2 + 60, 1.0f);
        }

        public void putTransposed(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4f.m10());
            byteBuffer.putFloat(i2 + 8, matrix4f.m20());
            byteBuffer.putFloat(i2 + 12, matrix4f.m30());
            byteBuffer.putFloat(i2 + 16, matrix4f.m01());
            byteBuffer.putFloat(i2 + 20, matrix4f.m11());
            byteBuffer.putFloat(i2 + 24, matrix4f.m21());
            byteBuffer.putFloat(i2 + 28, matrix4f.m31());
            byteBuffer.putFloat(i2 + 32, matrix4f.m02());
            byteBuffer.putFloat(i2 + 36, matrix4f.m12());
            byteBuffer.putFloat(i2 + 40, matrix4f.m22());
            byteBuffer.putFloat(i2 + 44, matrix4f.m32());
            byteBuffer.putFloat(i2 + 48, matrix4f.m03());
            byteBuffer.putFloat(i2 + 52, matrix4f.m13());
            byteBuffer.putFloat(i2 + 56, matrix4f.m23());
            byteBuffer.putFloat(i2 + 60, matrix4f.m33());
        }

        public void putf(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, (float) matrix4d.m00());
            byteBuffer.putFloat(i2 + 4, (float) matrix4d.m01());
            byteBuffer.putFloat(i2 + 8, (float) matrix4d.m02());
            byteBuffer.putFloat(i2 + 12, (float) matrix4d.m03());
            byteBuffer.putFloat(i2 + 16, (float) matrix4d.m10());
            byteBuffer.putFloat(i2 + 20, (float) matrix4d.m11());
            byteBuffer.putFloat(i2 + 24, (float) matrix4d.m12());
            byteBuffer.putFloat(i2 + 28, (float) matrix4d.m13());
            byteBuffer.putFloat(i2 + 32, (float) matrix4d.m20());
            byteBuffer.putFloat(i2 + 36, (float) matrix4d.m21());
            byteBuffer.putFloat(i2 + 40, (float) matrix4d.m22());
            byteBuffer.putFloat(i2 + 44, (float) matrix4d.m23());
            byteBuffer.putFloat(i2 + 48, (float) matrix4d.m30());
            byteBuffer.putFloat(i2 + 52, (float) matrix4d.m31());
            byteBuffer.putFloat(i2 + 56, (float) matrix4d.m32());
            byteBuffer.putFloat(i2 + 60, (float) matrix4d.m33());
        }

        public void set(Matrix4x3f matrix4x3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
            matrix4x3f._m00(vector3f.x);
            matrix4x3f._m01(vector3f.y);
            matrix4x3f._m02(vector3f.z);
            matrix4x3f._m10(vector3f2.x);
            matrix4x3f._m11(vector3f2.y);
            matrix4x3f._m12(vector3f2.z);
            matrix4x3f._m20(vector3f3.x);
            matrix4x3f._m21(vector3f3.y);
            matrix4x3f._m22(vector3f3.z);
            matrix4x3f._m30(vector3f4.x);
            matrix4x3f._m31(vector3f4.y);
            matrix4x3f._m32(vector3f4.z);
        }

        public void swap(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2) {
            float m00 = matrix4x3f.m00();
            matrix4x3f._m00(matrix4x3f2.m00());
            matrix4x3f2._m00(m00);
            float m01 = matrix4x3f.m01();
            matrix4x3f._m01(matrix4x3f2.m01());
            matrix4x3f2._m01(m01);
            float m02 = matrix4x3f.m02();
            matrix4x3f._m02(matrix4x3f2.m02());
            matrix4x3f2._m02(m02);
            float m10 = matrix4x3f.m10();
            matrix4x3f._m10(matrix4x3f2.m10());
            matrix4x3f2._m10(m10);
            float m11 = matrix4x3f.m11();
            matrix4x3f._m11(matrix4x3f2.m11());
            matrix4x3f2._m11(m11);
            float m12 = matrix4x3f.m12();
            matrix4x3f._m12(matrix4x3f2.m12());
            matrix4x3f2._m12(m12);
            float m20 = matrix4x3f.m20();
            matrix4x3f._m20(matrix4x3f2.m20());
            matrix4x3f2._m20(m20);
            float m21 = matrix4x3f.m21();
            matrix4x3f._m21(matrix4x3f2.m21());
            matrix4x3f2._m21(m21);
            float m22 = matrix4x3f.m22();
            matrix4x3f._m22(matrix4x3f2.m22());
            matrix4x3f2._m22(m22);
            float m30 = matrix4x3f.m30();
            matrix4x3f._m30(matrix4x3f2.m30());
            matrix4x3f2._m30(m30);
            float m31 = matrix4x3f.m31();
            matrix4x3f._m31(matrix4x3f2.m31());
            matrix4x3f2._m31(m31);
            float m32 = matrix4x3f.m32();
            matrix4x3f._m32(matrix4x3f2.m32());
            matrix4x3f2._m32(m32);
        }

        public void copy3x3(Matrix3f matrix3f, Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(matrix3f.m00());
            matrix4x3f._m01(matrix3f.m01());
            matrix4x3f._m02(matrix3f.m02());
            matrix4x3f._m10(matrix3f.m10());
            matrix4x3f._m11(matrix3f.m11());
            matrix4x3f._m12(matrix3f.m12());
            matrix4x3f._m20(matrix3f.m20());
            matrix4x3f._m21(matrix3f.m21());
            matrix4x3f._m22(matrix3f.m22());
        }

        public void put3x3(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix3x2d.m00());
            doubleBuffer.put(i2 + 1, matrix3x2d.m01());
            doubleBuffer.put(i2 + 2, 0.0d);
            doubleBuffer.put(i2 + 3, matrix3x2d.m10());
            doubleBuffer.put(i2 + 4, matrix3x2d.m11());
            doubleBuffer.put(i2 + 5, 0.0d);
            doubleBuffer.put(i2 + 6, matrix3x2d.m20());
            doubleBuffer.put(i2 + 7, matrix3x2d.m21());
            doubleBuffer.put(i2 + 8, 1.0d);
        }

        public void putMatrix4f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer) {
            float f2 = quaternionf.w;
            float f3 = f2 * f2;
            float f4 = quaternionf.x;
            float f5 = f4 * f4;
            float f6 = quaternionf.y;
            float f7 = f6 * f6;
            float f8 = quaternionf.z;
            float f9 = f8 * f8;
            float f10 = f8 * f2;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f2;
            float f14 = f6 * f8;
            float f15 = f4 * f2;
            floatBuffer.put(i2, ((f3 + f5) - f9) - f7);
            floatBuffer.put(i2 + 1, f11 + f10 + f10 + f11);
            floatBuffer.put(i2 + 2, ((f12 - f13) + f12) - f13);
            floatBuffer.put(i2 + 3, 0.0f);
            floatBuffer.put(i2 + 4, (((-f10) + f11) - f10) + f11);
            floatBuffer.put(i2 + 5, ((f7 - f9) + f3) - f5);
            float f16 = f14 + f14;
            floatBuffer.put(i2 + 6, f16 + f15 + f15);
            floatBuffer.put(i2 + 7, 0.0f);
            floatBuffer.put(i2 + 8, f13 + f12 + f12 + f13);
            floatBuffer.put(i2 + 9, (f16 - f15) - f15);
            floatBuffer.put(i2 + 10, ((f9 - f7) - f5) + f3);
            floatBuffer.put(i2 + 11, 0.0f);
            floatBuffer.put(i2 + 12, 0.0f);
            floatBuffer.put(i2 + 13, 0.0f);
            floatBuffer.put(i2 + 14, 0.0f);
            floatBuffer.put(i2 + 15, 1.0f);
        }

        public void identity(Matrix3f matrix3f) {
            matrix3f._m00(1.0f);
            matrix3f._m01(0.0f);
            matrix3f._m02(0.0f);
            matrix3f._m10(0.0f);
            matrix3f._m11(1.0f);
            matrix3f._m12(0.0f);
            matrix3f._m20(0.0f);
            matrix3f._m21(0.0f);
            matrix3f._m22(1.0f);
        }

        public void zero(Matrix3f matrix3f) {
            matrix3f._m00(0.0f);
            matrix3f._m01(0.0f);
            matrix3f._m02(0.0f);
            matrix3f._m10(0.0f);
            matrix3f._m11(0.0f);
            matrix3f._m12(0.0f);
            matrix3f._m20(0.0f);
            matrix3f._m21(0.0f);
            matrix3f._m22(0.0f);
        }

        public void put(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4d.m00());
            byteBuffer.putDouble(i2 + 4, matrix4d.m01());
            byteBuffer.putDouble(i2 + 8, matrix4d.m02());
            byteBuffer.putDouble(i2 + 12, matrix4d.m03());
            byteBuffer.putDouble(i2 + 16, matrix4d.m10());
            byteBuffer.putDouble(i2 + 20, matrix4d.m11());
            byteBuffer.putDouble(i2 + 24, matrix4d.m12());
            byteBuffer.putDouble(i2 + 28, matrix4d.m13());
            byteBuffer.putDouble(i2 + 32, matrix4d.m20());
            byteBuffer.putDouble(i2 + 36, matrix4d.m21());
            byteBuffer.putDouble(i2 + 40, matrix4d.m22());
            byteBuffer.putDouble(i2 + 44, matrix4d.m23());
            byteBuffer.putDouble(i2 + 48, matrix4d.m30());
            byteBuffer.putDouble(i2 + 52, matrix4d.m31());
            byteBuffer.putDouble(i2 + 56, matrix4d.m32());
            byteBuffer.putDouble(i2 + 60, matrix4d.m33());
        }

        public void put4x3Transposed(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4d.m00());
            doubleBuffer.put(i2 + 1, matrix4d.m10());
            doubleBuffer.put(i2 + 2, matrix4d.m20());
            doubleBuffer.put(i2 + 3, matrix4d.m30());
            doubleBuffer.put(i2 + 4, matrix4d.m01());
            doubleBuffer.put(i2 + 5, matrix4d.m11());
            doubleBuffer.put(i2 + 6, matrix4d.m21());
            doubleBuffer.put(i2 + 7, matrix4d.m31());
            doubleBuffer.put(i2 + 8, matrix4d.m02());
            doubleBuffer.put(i2 + 9, matrix4d.m12());
            doubleBuffer.put(i2 + 10, matrix4d.m22());
            doubleBuffer.put(i2 + 11, matrix4d.m32());
        }

        public void putfTransposed(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, (float) matrix4d.m00());
            floatBuffer.put(i2 + 1, (float) matrix4d.m10());
            floatBuffer.put(i2 + 2, (float) matrix4d.m20());
            floatBuffer.put(i2 + 3, (float) matrix4d.m30());
            floatBuffer.put(i2 + 4, (float) matrix4d.m01());
            floatBuffer.put(i2 + 5, (float) matrix4d.m11());
            floatBuffer.put(i2 + 6, (float) matrix4d.m21());
            floatBuffer.put(i2 + 7, (float) matrix4d.m31());
            floatBuffer.put(i2 + 8, (float) matrix4d.m02());
            floatBuffer.put(i2 + 9, (float) matrix4d.m12());
            floatBuffer.put(i2 + 10, (float) matrix4d.m22());
            floatBuffer.put(i2 + 11, (float) matrix4d.m32());
            floatBuffer.put(i2 + 12, (float) matrix4d.m03());
            floatBuffer.put(i2 + 13, (float) matrix4d.m13());
            floatBuffer.put(i2 + 14, (float) matrix4d.m23());
            floatBuffer.put(i2 + 15, (float) matrix4d.m33());
        }

        public void copy3x3(Matrix3f matrix3f, Matrix4f matrix4f) {
            matrix4f._m00(matrix3f.m00());
            matrix4f._m01(matrix3f.m01());
            matrix4f._m02(matrix3f.m02());
            matrix4f._m10(matrix3f.m10());
            matrix4f._m11(matrix3f.m11());
            matrix4f._m12(matrix3f.m12());
            matrix4f._m20(matrix3f.m20());
            matrix4f._m21(matrix3f.m21());
            matrix4f._m22(matrix3f.m22());
        }

        public void put3x3(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix3x2d.m00());
            byteBuffer.putDouble(i2 + 8, matrix3x2d.m01());
            byteBuffer.putDouble(i2 + 16, 0.0d);
            byteBuffer.putDouble(i2 + 24, matrix3x2d.m10());
            byteBuffer.putDouble(i2 + 32, matrix3x2d.m11());
            byteBuffer.putDouble(i2 + 40, 0.0d);
            byteBuffer.putDouble(i2 + 48, matrix3x2d.m20());
            byteBuffer.putDouble(i2 + 56, matrix3x2d.m21());
            byteBuffer.putDouble(i2 + 64, 1.0d);
        }

        public void identity(Matrix3x2f matrix3x2f) {
            matrix3x2f._m00(1.0f);
            matrix3x2f._m01(0.0f);
            matrix3x2f._m10(0.0f);
            matrix3x2f._m11(1.0f);
            matrix3x2f._m20(0.0f);
            matrix3x2f._m21(0.0f);
        }

        public void set(Matrix3f matrix3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
            matrix3f._m00(vector3f.x);
            matrix3f._m01(vector3f.y);
            matrix3f._m02(vector3f.z);
            matrix3f._m10(vector3f2.x);
            matrix3f._m11(vector3f2.y);
            matrix3f._m12(vector3f2.z);
            matrix3f._m20(vector3f3.x);
            matrix3f._m21(vector3f3.y);
            matrix3f._m22(vector3f3.z);
        }

        public void swap(Matrix3f matrix3f, Matrix3f matrix3f2) {
            float m00 = matrix3f.m00();
            matrix3f._m00(matrix3f2.m00());
            matrix3f2._m00(m00);
            float m01 = matrix3f.m01();
            matrix3f._m01(matrix3f2.m01());
            matrix3f2._m01(m01);
            float m02 = matrix3f.m02();
            matrix3f._m02(matrix3f2.m02());
            matrix3f2._m02(m02);
            float m10 = matrix3f.m10();
            matrix3f._m10(matrix3f2.m10());
            matrix3f2._m10(m10);
            float m11 = matrix3f.m11();
            matrix3f._m11(matrix3f2.m11());
            matrix3f2._m11(m11);
            float m12 = matrix3f.m12();
            matrix3f._m12(matrix3f2.m12());
            matrix3f2._m12(m12);
            float m20 = matrix3f.m20();
            matrix3f._m20(matrix3f2.m20());
            matrix3f2._m20(m20);
            float m21 = matrix3f.m21();
            matrix3f._m21(matrix3f2.m21());
            matrix3f2._m21(m21);
            float m22 = matrix3f.m22();
            matrix3f._m22(matrix3f2.m22());
            matrix3f2._m22(m22);
        }

        public void zero(Matrix3x2f matrix3x2f) {
            matrix3x2f._m00(0.0f);
            matrix3x2f._m01(0.0f);
            matrix3x2f._m10(0.0f);
            matrix3x2f._m11(0.0f);
            matrix3x2f._m20(0.0f);
            matrix3x2f._m21(0.0f);
        }

        public void copy(Matrix4f matrix4f, Matrix3f matrix3f) {
            matrix3f._m00(matrix4f.m00());
            matrix3f._m01(matrix4f.m01());
            matrix3f._m02(matrix4f.m02());
            matrix3f._m10(matrix4f.m10());
            matrix3f._m11(matrix4f.m11());
            matrix3f._m12(matrix4f.m12());
            matrix3f._m20(matrix4f.m20());
            matrix3f._m21(matrix4f.m21());
            matrix3f._m22(matrix4f.m22());
        }

        public void copy4x4(Matrix4x3d matrix4x3d, double[] dArr, int i2) {
            dArr[i2 + 0] = matrix4x3d.m00();
            dArr[i2 + 1] = matrix4x3d.m01();
            dArr[i2 + 2] = matrix4x3d.m02();
            dArr[i2 + 3] = 0.0d;
            dArr[i2 + 4] = matrix4x3d.m10();
            dArr[i2 + 5] = matrix4x3d.m11();
            dArr[i2 + 6] = matrix4x3d.m12();
            dArr[i2 + 7] = 0.0d;
            dArr[i2 + 8] = matrix4x3d.m20();
            dArr[i2 + 9] = matrix4x3d.m21();
            dArr[i2 + 10] = matrix4x3d.m22();
            dArr[i2 + 11] = 0.0d;
            dArr[i2 + 12] = matrix4x3d.m30();
            dArr[i2 + 13] = matrix4x3d.m31();
            dArr[i2 + 14] = matrix4x3d.m32();
            dArr[i2 + 15] = 1.0d;
        }

        public void get(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer) {
            matrix4x3f._m00(floatBuffer.get(i2));
            matrix4x3f._m01(floatBuffer.get(i2 + 1));
            matrix4x3f._m02(floatBuffer.get(i2 + 2));
            matrix4x3f._m10(floatBuffer.get(i2 + 3));
            matrix4x3f._m11(floatBuffer.get(i2 + 4));
            matrix4x3f._m12(floatBuffer.get(i2 + 5));
            matrix4x3f._m20(floatBuffer.get(i2 + 6));
            matrix4x3f._m21(floatBuffer.get(i2 + 7));
            matrix4x3f._m22(floatBuffer.get(i2 + 8));
            matrix4x3f._m30(floatBuffer.get(i2 + 9));
            matrix4x3f._m31(floatBuffer.get(i2 + 10));
            matrix4x3f._m32(floatBuffer.get(i2 + 11));
        }

        public void getf(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer) {
            matrix4x3d._m00((double) floatBuffer.get(i2));
            matrix4x3d._m01((double) floatBuffer.get(i2 + 1));
            matrix4x3d._m02((double) floatBuffer.get(i2 + 2));
            matrix4x3d._m10((double) floatBuffer.get(i2 + 3));
            matrix4x3d._m11((double) floatBuffer.get(i2 + 4));
            matrix4x3d._m12((double) floatBuffer.get(i2 + 5));
            matrix4x3d._m20((double) floatBuffer.get(i2 + 6));
            matrix4x3d._m21((double) floatBuffer.get(i2 + 7));
            matrix4x3d._m22((double) floatBuffer.get(i2 + 8));
            matrix4x3d._m30((double) floatBuffer.get(i2 + 9));
            matrix4x3d._m31((double) floatBuffer.get(i2 + 10));
            matrix4x3d._m32((double) floatBuffer.get(i2 + 11));
        }

        public void put0(Matrix4x3f matrix4x3f, FloatBuffer floatBuffer) {
            floatBuffer.put(0, matrix4x3f.m00());
            floatBuffer.put(1, matrix4x3f.m01());
            floatBuffer.put(2, matrix4x3f.m02());
            floatBuffer.put(3, matrix4x3f.m10());
            floatBuffer.put(4, matrix4x3f.m11());
            floatBuffer.put(5, matrix4x3f.m12());
            floatBuffer.put(6, matrix4x3f.m20());
            floatBuffer.put(7, matrix4x3f.m21());
            floatBuffer.put(8, matrix4x3f.m22());
            floatBuffer.put(9, matrix4x3f.m30());
            floatBuffer.put(10, matrix4x3f.m31());
            floatBuffer.put(11, matrix4x3f.m32());
        }

        public void put4x4(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4x3d.m00());
            doubleBuffer.put(i2 + 1, matrix4x3d.m01());
            doubleBuffer.put(i2 + 2, matrix4x3d.m02());
            doubleBuffer.put(i2 + 3, 0.0d);
            doubleBuffer.put(i2 + 4, matrix4x3d.m10());
            doubleBuffer.put(i2 + 5, matrix4x3d.m11());
            doubleBuffer.put(i2 + 6, matrix4x3d.m12());
            doubleBuffer.put(i2 + 7, 0.0d);
            doubleBuffer.put(i2 + 8, matrix4x3d.m20());
            doubleBuffer.put(i2 + 9, matrix4x3d.m21());
            doubleBuffer.put(i2 + 10, matrix4x3d.m22());
            doubleBuffer.put(i2 + 11, 0.0d);
            doubleBuffer.put(i2 + 12, matrix4x3d.m30());
            doubleBuffer.put(i2 + 13, matrix4x3d.m31());
            doubleBuffer.put(i2 + 14, matrix4x3d.m32());
            doubleBuffer.put(i2 + 15, 1.0d);
        }

        public void putN(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4x3f.m00());
            floatBuffer.put(i2 + 1, matrix4x3f.m01());
            floatBuffer.put(i2 + 2, matrix4x3f.m02());
            floatBuffer.put(i2 + 3, matrix4x3f.m10());
            floatBuffer.put(i2 + 4, matrix4x3f.m11());
            floatBuffer.put(i2 + 5, matrix4x3f.m12());
            floatBuffer.put(i2 + 6, matrix4x3f.m20());
            floatBuffer.put(i2 + 7, matrix4x3f.m21());
            floatBuffer.put(i2 + 8, matrix4x3f.m22());
            floatBuffer.put(i2 + 9, matrix4x3f.m30());
            floatBuffer.put(i2 + 10, matrix4x3f.m31());
            floatBuffer.put(i2 + 11, matrix4x3f.m32());
        }

        public void putTransposed(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix4x3f.m00());
            floatBuffer.put(i2 + 1, matrix4x3f.m10());
            floatBuffer.put(i2 + 2, matrix4x3f.m20());
            floatBuffer.put(i2 + 3, matrix4x3f.m30());
            floatBuffer.put(i2 + 4, matrix4x3f.m01());
            floatBuffer.put(i2 + 5, matrix4x3f.m11());
            floatBuffer.put(i2 + 6, matrix4x3f.m21());
            floatBuffer.put(i2 + 7, matrix4x3f.m31());
            floatBuffer.put(i2 + 8, matrix4x3f.m02());
            floatBuffer.put(i2 + 9, matrix4x3f.m12());
            floatBuffer.put(i2 + 10, matrix4x3f.m22());
            floatBuffer.put(i2 + 11, matrix4x3f.m32());
        }

        public void putf(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, (float) matrix4x3d.m00());
            floatBuffer.put(i2 + 1, (float) matrix4x3d.m01());
            floatBuffer.put(i2 + 2, (float) matrix4x3d.m02());
            floatBuffer.put(i2 + 3, (float) matrix4x3d.m10());
            floatBuffer.put(i2 + 4, (float) matrix4x3d.m11());
            floatBuffer.put(i2 + 5, (float) matrix4x3d.m12());
            floatBuffer.put(i2 + 6, (float) matrix4x3d.m20());
            floatBuffer.put(i2 + 7, (float) matrix4x3d.m21());
            floatBuffer.put(i2 + 8, (float) matrix4x3d.m22());
            floatBuffer.put(i2 + 9, (float) matrix4x3d.m30());
            floatBuffer.put(i2 + 10, (float) matrix4x3d.m31());
            floatBuffer.put(i2 + 11, (float) matrix4x3d.m32());
        }

        public void identity(Matrix3x2d matrix3x2d) {
            matrix3x2d._m00(1.0d);
            matrix3x2d._m01(0.0d);
            matrix3x2d._m10(0.0d);
            matrix3x2d._m11(1.0d);
            matrix3x2d._m20(0.0d);
            matrix3x2d._m21(0.0d);
        }

        public void zero(Matrix3x2d matrix3x2d) {
            matrix3x2d._m00(0.0d);
            matrix3x2d._m01(0.0d);
            matrix3x2d._m10(0.0d);
            matrix3x2d._m11(0.0d);
            matrix3x2d._m20(0.0d);
            matrix3x2d._m21(0.0d);
        }

        public void copy3x3(Matrix3x2f matrix3x2f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix3x2f.m00();
            fArr[i2 + 1] = matrix3x2f.m01();
            fArr[i2 + 2] = 0.0f;
            fArr[i2 + 3] = matrix3x2f.m10();
            fArr[i2 + 4] = matrix3x2f.m11();
            fArr[i2 + 5] = 0.0f;
            fArr[i2 + 6] = matrix3x2f.m20();
            fArr[i2 + 7] = matrix3x2f.m21();
            fArr[i2 + 8] = 1.0f;
        }

        public void put4x3Transposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4d.m00());
            byteBuffer.putDouble(i2 + 8, matrix4d.m10());
            byteBuffer.putDouble(i2 + 16, matrix4d.m20());
            byteBuffer.putDouble(i2 + 24, matrix4d.m30());
            byteBuffer.putDouble(i2 + 32, matrix4d.m01());
            byteBuffer.putDouble(i2 + 40, matrix4d.m11());
            byteBuffer.putDouble(i2 + 48, matrix4d.m21());
            byteBuffer.putDouble(i2 + 56, matrix4d.m31());
            byteBuffer.putDouble(i2 + 64, matrix4d.m02());
            byteBuffer.putDouble(i2 + 72, matrix4d.m12());
            byteBuffer.putDouble(i2 + 80, matrix4d.m22());
            byteBuffer.putDouble(i2 + 88, matrix4d.m32());
        }

        public void copy(Matrix3f matrix3f, Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(matrix3f.m00());
            matrix4x3f._m01(matrix3f.m01());
            matrix4x3f._m02(matrix3f.m02());
            matrix4x3f._m10(matrix3f.m10());
            matrix4x3f._m11(matrix3f.m11());
            matrix4x3f._m12(matrix3f.m12());
            matrix4x3f._m20(matrix3f.m20());
            matrix4x3f._m21(matrix3f.m21());
            matrix4x3f._m22(matrix3f.m22());
            matrix4x3f._m30(0.0f);
            matrix4x3f._m31(0.0f);
            matrix4x3f._m32(0.0f);
        }

        public void identity(Quaternionf quaternionf) {
            quaternionf.x = 0.0f;
            quaternionf.y = 0.0f;
            quaternionf.z = 0.0f;
            quaternionf.w = 1.0f;
        }

        public void put(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4x3d.m00());
            doubleBuffer.put(i2 + 1, matrix4x3d.m01());
            doubleBuffer.put(i2 + 2, matrix4x3d.m02());
            doubleBuffer.put(i2 + 3, matrix4x3d.m10());
            doubleBuffer.put(i2 + 4, matrix4x3d.m11());
            doubleBuffer.put(i2 + 5, matrix4x3d.m12());
            doubleBuffer.put(i2 + 6, matrix4x3d.m20());
            doubleBuffer.put(i2 + 7, matrix4x3d.m21());
            doubleBuffer.put(i2 + 8, matrix4x3d.m22());
            doubleBuffer.put(i2 + 9, matrix4x3d.m30());
            doubleBuffer.put(i2 + 10, matrix4x3d.m31());
            doubleBuffer.put(i2 + 11, matrix4x3d.m32());
        }

        public void putfTransposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, (float) matrix4d.m00());
            byteBuffer.putFloat(i2 + 4, (float) matrix4d.m10());
            byteBuffer.putFloat(i2 + 8, (float) matrix4d.m20());
            byteBuffer.putFloat(i2 + 12, (float) matrix4d.m30());
            byteBuffer.putFloat(i2 + 16, (float) matrix4d.m01());
            byteBuffer.putFloat(i2 + 20, (float) matrix4d.m11());
            byteBuffer.putFloat(i2 + 24, (float) matrix4d.m21());
            byteBuffer.putFloat(i2 + 28, (float) matrix4d.m31());
            byteBuffer.putFloat(i2 + 32, (float) matrix4d.m02());
            byteBuffer.putFloat(i2 + 36, (float) matrix4d.m12());
            byteBuffer.putFloat(i2 + 40, (float) matrix4d.m22());
            byteBuffer.putFloat(i2 + 44, (float) matrix4d.m32());
            byteBuffer.putFloat(i2 + 48, (float) matrix4d.m03());
            byteBuffer.putFloat(i2 + 52, (float) matrix4d.m13());
            byteBuffer.putFloat(i2 + 56, (float) matrix4d.m23());
            byteBuffer.putFloat(i2 + 60, (float) matrix4d.m33());
        }

        public void zero(Vector4f vector4f) {
            vector4f.x = 0.0f;
            vector4f.y = 0.0f;
            vector4f.z = 0.0f;
            vector4f.w = 0.0f;
        }

        public void get(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer) {
            matrix4x3f._m00(byteBuffer.getFloat(i2));
            matrix4x3f._m01(byteBuffer.getFloat(i2 + 4));
            matrix4x3f._m02(byteBuffer.getFloat(i2 + 8));
            matrix4x3f._m10(byteBuffer.getFloat(i2 + 12));
            matrix4x3f._m11(byteBuffer.getFloat(i2 + 16));
            matrix4x3f._m12(byteBuffer.getFloat(i2 + 20));
            matrix4x3f._m20(byteBuffer.getFloat(i2 + 24));
            matrix4x3f._m21(byteBuffer.getFloat(i2 + 28));
            matrix4x3f._m22(byteBuffer.getFloat(i2 + 32));
            matrix4x3f._m30(byteBuffer.getFloat(i2 + 36));
            matrix4x3f._m31(byteBuffer.getFloat(i2 + 40));
            matrix4x3f._m32(byteBuffer.getFloat(i2 + 44));
        }

        public void getf(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            matrix4x3d._m00((double) byteBuffer.getFloat(i2));
            matrix4x3d._m01((double) byteBuffer.getFloat(i2 + 4));
            matrix4x3d._m02((double) byteBuffer.getFloat(i2 + 8));
            matrix4x3d._m10((double) byteBuffer.getFloat(i2 + 12));
            matrix4x3d._m11((double) byteBuffer.getFloat(i2 + 16));
            matrix4x3d._m12((double) byteBuffer.getFloat(i2 + 20));
            matrix4x3d._m20((double) byteBuffer.getFloat(i2 + 24));
            matrix4x3d._m21((double) byteBuffer.getFloat(i2 + 28));
            matrix4x3d._m22((double) byteBuffer.getFloat(i2 + 32));
            matrix4x3d._m30((double) byteBuffer.getFloat(i2 + 36));
            matrix4x3d._m31((double) byteBuffer.getFloat(i2 + 40));
            matrix4x3d._m32((double) byteBuffer.getFloat(i2 + 44));
        }

        public void put0(Matrix4x3f matrix4x3f, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(0, matrix4x3f.m00());
            byteBuffer.putFloat(4, matrix4x3f.m01());
            byteBuffer.putFloat(8, matrix4x3f.m02());
            byteBuffer.putFloat(12, matrix4x3f.m10());
            byteBuffer.putFloat(16, matrix4x3f.m11());
            byteBuffer.putFloat(20, matrix4x3f.m12());
            byteBuffer.putFloat(24, matrix4x3f.m20());
            byteBuffer.putFloat(28, matrix4x3f.m21());
            byteBuffer.putFloat(32, matrix4x3f.m22());
            byteBuffer.putFloat(36, matrix4x3f.m30());
            byteBuffer.putFloat(40, matrix4x3f.m31());
            byteBuffer.putFloat(44, matrix4x3f.m32());
        }

        public void putN(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4x3f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4x3f.m01());
            byteBuffer.putFloat(i2 + 8, matrix4x3f.m02());
            byteBuffer.putFloat(i2 + 12, matrix4x3f.m10());
            byteBuffer.putFloat(i2 + 16, matrix4x3f.m11());
            byteBuffer.putFloat(i2 + 20, matrix4x3f.m12());
            byteBuffer.putFloat(i2 + 24, matrix4x3f.m20());
            byteBuffer.putFloat(i2 + 28, matrix4x3f.m21());
            byteBuffer.putFloat(i2 + 32, matrix4x3f.m22());
            byteBuffer.putFloat(i2 + 36, matrix4x3f.m30());
            byteBuffer.putFloat(i2 + 40, matrix4x3f.m31());
            byteBuffer.putFloat(i2 + 44, matrix4x3f.m32());
        }

        public void putTransposed(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix4x3f.m00());
            byteBuffer.putFloat(i2 + 4, matrix4x3f.m10());
            byteBuffer.putFloat(i2 + 8, matrix4x3f.m20());
            byteBuffer.putFloat(i2 + 12, matrix4x3f.m30());
            byteBuffer.putFloat(i2 + 16, matrix4x3f.m01());
            byteBuffer.putFloat(i2 + 20, matrix4x3f.m11());
            byteBuffer.putFloat(i2 + 24, matrix4x3f.m21());
            byteBuffer.putFloat(i2 + 28, matrix4x3f.m31());
            byteBuffer.putFloat(i2 + 32, matrix4x3f.m02());
            byteBuffer.putFloat(i2 + 36, matrix4x3f.m12());
            byteBuffer.putFloat(i2 + 40, matrix4x3f.m22());
            byteBuffer.putFloat(i2 + 44, matrix4x3f.m32());
        }

        public void putf(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, (float) matrix4x3d.m00());
            byteBuffer.putFloat(i2 + 4, (float) matrix4x3d.m01());
            byteBuffer.putFloat(i2 + 8, (float) matrix4x3d.m02());
            byteBuffer.putFloat(i2 + 12, (float) matrix4x3d.m10());
            byteBuffer.putFloat(i2 + 16, (float) matrix4x3d.m11());
            byteBuffer.putFloat(i2 + 20, (float) matrix4x3d.m12());
            byteBuffer.putFloat(i2 + 24, (float) matrix4x3d.m20());
            byteBuffer.putFloat(i2 + 28, (float) matrix4x3d.m21());
            byteBuffer.putFloat(i2 + 32, (float) matrix4x3d.m22());
            byteBuffer.putFloat(i2 + 36, (float) matrix4x3d.m30());
            byteBuffer.putFloat(i2 + 40, (float) matrix4x3d.m31());
            byteBuffer.putFloat(i2 + 44, (float) matrix4x3d.m32());
        }

        public void zero(Vector4i vector4i) {
            vector4i.x = 0;
            vector4i.y = 0;
            vector4i.z = 0;
            vector4i.w = 0;
        }

        public void copy3x3(Matrix3x2d matrix3x2d, double[] dArr, int i2) {
            dArr[i2 + 0] = matrix3x2d.m00();
            dArr[i2 + 1] = matrix3x2d.m01();
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 3] = matrix3x2d.m10();
            dArr[i2 + 4] = matrix3x2d.m11();
            dArr[i2 + 5] = 0.0d;
            dArr[i2 + 6] = matrix3x2d.m20();
            dArr[i2 + 7] = matrix3x2d.m21();
            dArr[i2 + 8] = 1.0d;
        }

        public void copy4x4(Matrix3x2f matrix3x2f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix3x2f.m00();
            fArr[i2 + 1] = matrix3x2f.m01();
            fArr[i2 + 2] = 0.0f;
            fArr[i2 + 3] = 0.0f;
            fArr[i2 + 4] = matrix3x2f.m10();
            fArr[i2 + 5] = matrix3x2f.m11();
            fArr[i2 + 6] = 0.0f;
            fArr[i2 + 7] = 0.0f;
            fArr[i2 + 8] = 0.0f;
            fArr[i2 + 9] = 0.0f;
            fArr[i2 + 10] = 1.0f;
            fArr[i2 + 11] = 0.0f;
            fArr[i2 + 12] = matrix3x2f.m20();
            fArr[i2 + 13] = matrix3x2f.m21();
            fArr[i2 + 14] = 0.0f;
            fArr[i2 + 15] = 1.0f;
        }

        public void put4x4(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4x3d.m00());
            byteBuffer.putDouble(i2 + 4, matrix4x3d.m01());
            byteBuffer.putDouble(i2 + 8, matrix4x3d.m02());
            byteBuffer.putDouble(i2 + 12, 0.0d);
            byteBuffer.putDouble(i2 + 16, matrix4x3d.m10());
            byteBuffer.putDouble(i2 + 20, matrix4x3d.m11());
            byteBuffer.putDouble(i2 + 24, matrix4x3d.m12());
            byteBuffer.putDouble(i2 + 28, 0.0d);
            byteBuffer.putDouble(i2 + 32, matrix4x3d.m20());
            byteBuffer.putDouble(i2 + 36, matrix4x3d.m21());
            byteBuffer.putDouble(i2 + 40, matrix4x3d.m22());
            byteBuffer.putDouble(i2 + 44, 0.0d);
            byteBuffer.putDouble(i2 + 48, matrix4x3d.m30());
            byteBuffer.putDouble(i2 + 52, matrix4x3d.m31());
            byteBuffer.putDouble(i2 + 56, matrix4x3d.m32());
            byteBuffer.putDouble(i2 + 60, 1.0d);
        }

        public void copy(Matrix3x2f matrix3x2f, Matrix3x2f matrix3x2f2) {
            matrix3x2f2._m00(matrix3x2f.m00());
            matrix3x2f2._m01(matrix3x2f.m01());
            matrix3x2f2._m10(matrix3x2f.m10());
            matrix3x2f2._m11(matrix3x2f.m11());
            matrix3x2f2._m20(matrix3x2f.m20());
            matrix3x2f2._m21(matrix3x2f.m21());
        }

        public void put(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4x3d.m00());
            byteBuffer.putDouble(i2 + 4, matrix4x3d.m01());
            byteBuffer.putDouble(i2 + 8, matrix4x3d.m02());
            byteBuffer.putDouble(i2 + 12, matrix4x3d.m10());
            byteBuffer.putDouble(i2 + 16, matrix4x3d.m11());
            byteBuffer.putDouble(i2 + 20, matrix4x3d.m12());
            byteBuffer.putDouble(i2 + 24, matrix4x3d.m20());
            byteBuffer.putDouble(i2 + 28, matrix4x3d.m21());
            byteBuffer.putDouble(i2 + 32, matrix4x3d.m22());
            byteBuffer.putDouble(i2 + 36, matrix4x3d.m30());
            byteBuffer.putDouble(i2 + 40, matrix4x3d.m31());
            byteBuffer.putDouble(i2 + 44, matrix4x3d.m32());
        }

        public void copy(Matrix3x2d matrix3x2d, Matrix3x2d matrix3x2d2) {
            matrix3x2d2._m00(matrix3x2d.m00());
            matrix3x2d2._m01(matrix3x2d.m01());
            matrix3x2d2._m10(matrix3x2d.m10());
            matrix3x2d2._m11(matrix3x2d.m11());
            matrix3x2d2._m20(matrix3x2d.m20());
            matrix3x2d2._m21(matrix3x2d.m21());
        }

        public void get(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer) {
            matrix4d._m00(doubleBuffer.get(i2));
            matrix4d._m01(doubleBuffer.get(i2 + 1));
            matrix4d._m02(doubleBuffer.get(i2 + 2));
            matrix4d._m03(doubleBuffer.get(i2 + 3));
            matrix4d._m10(doubleBuffer.get(i2 + 4));
            matrix4d._m11(doubleBuffer.get(i2 + 5));
            matrix4d._m12(doubleBuffer.get(i2 + 6));
            matrix4d._m13(doubleBuffer.get(i2 + 7));
            matrix4d._m20(doubleBuffer.get(i2 + 8));
            matrix4d._m21(doubleBuffer.get(i2 + 9));
            matrix4d._m22(doubleBuffer.get(i2 + 10));
            matrix4d._m23(doubleBuffer.get(i2 + 11));
            matrix4d._m30(doubleBuffer.get(i2 + 12));
            matrix4d._m31(doubleBuffer.get(i2 + 13));
            matrix4d._m32(doubleBuffer.get(i2 + 14));
            matrix4d._m33(doubleBuffer.get(i2 + 15));
        }

        public void getf(Matrix3d matrix3d, int i2, FloatBuffer floatBuffer) {
            matrix3d._m00((double) floatBuffer.get(i2));
            matrix3d._m01((double) floatBuffer.get(i2 + 1));
            matrix3d._m02((double) floatBuffer.get(i2 + 2));
            matrix3d._m10((double) floatBuffer.get(i2 + 3));
            matrix3d._m11((double) floatBuffer.get(i2 + 4));
            matrix3d._m12((double) floatBuffer.get(i2 + 5));
            matrix3d._m20((double) floatBuffer.get(i2 + 6));
            matrix3d._m21((double) floatBuffer.get(i2 + 7));
            matrix3d._m22((double) floatBuffer.get(i2 + 8));
        }

        public void putTransposed(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix3f.m00());
            floatBuffer.put(i2 + 1, matrix3f.m10());
            floatBuffer.put(i2 + 2, matrix3f.m20());
            floatBuffer.put(i2 + 3, matrix3f.m01());
            floatBuffer.put(i2 + 4, matrix3f.m11());
            floatBuffer.put(i2 + 5, matrix3f.m21());
            floatBuffer.put(i2 + 6, matrix3f.m02());
            floatBuffer.put(i2 + 7, matrix3f.m12());
            floatBuffer.put(i2 + 8, matrix3f.m22());
        }

        public void putf(Matrix3d matrix3d, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, (float) matrix3d.m00());
            floatBuffer.put(i2 + 1, (float) matrix3d.m01());
            floatBuffer.put(i2 + 2, (float) matrix3d.m02());
            floatBuffer.put(i2 + 3, (float) matrix3d.m10());
            floatBuffer.put(i2 + 4, (float) matrix3d.m11());
            floatBuffer.put(i2 + 5, (float) matrix3d.m12());
            floatBuffer.put(i2 + 6, (float) matrix3d.m20());
            floatBuffer.put(i2 + 7, (float) matrix3d.m21());
            floatBuffer.put(i2 + 8, (float) matrix3d.m22());
        }

        public void copy(Vector4f vector4f, Vector4f vector4f2) {
            vector4f2.x = vector4f.x;
            vector4f2.y = vector4f.y;
            vector4f2.z = vector4f.z;
            vector4f2.w = vector4f.w;
        }

        public void copy4x4(Matrix3x2d matrix3x2d, double[] dArr, int i2) {
            dArr[i2 + 0] = matrix3x2d.m00();
            dArr[i2 + 1] = matrix3x2d.m01();
            dArr[i2 + 2] = 0.0d;
            dArr[i2 + 3] = 0.0d;
            dArr[i2 + 4] = matrix3x2d.m10();
            dArr[i2 + 5] = matrix3x2d.m11();
            dArr[i2 + 6] = 0.0d;
            dArr[i2 + 7] = 0.0d;
            dArr[i2 + 8] = 0.0d;
            dArr[i2 + 9] = 0.0d;
            dArr[i2 + 10] = 1.0d;
            dArr[i2 + 11] = 0.0d;
            dArr[i2 + 12] = matrix3x2d.m20();
            dArr[i2 + 13] = matrix3x2d.m21();
            dArr[i2 + 14] = 0.0d;
            dArr[i2 + 15] = 1.0d;
        }

        public void put(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix3f.m00());
            floatBuffer.put(i2 + 1, matrix3f.m01());
            floatBuffer.put(i2 + 2, matrix3f.m02());
            floatBuffer.put(i2 + 3, matrix3f.m10());
            floatBuffer.put(i2 + 4, matrix3f.m11());
            floatBuffer.put(i2 + 5, matrix3f.m12());
            floatBuffer.put(i2 + 6, matrix3f.m20());
            floatBuffer.put(i2 + 7, matrix3f.m21());
            floatBuffer.put(i2 + 8, matrix3f.m22());
        }

        public void put4x4(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix3x2f.m00());
            floatBuffer.put(i2 + 1, matrix3x2f.m01());
            floatBuffer.put(i2 + 2, 0.0f);
            floatBuffer.put(i2 + 3, 0.0f);
            floatBuffer.put(i2 + 4, matrix3x2f.m10());
            floatBuffer.put(i2 + 5, matrix3x2f.m11());
            floatBuffer.put(i2 + 6, 0.0f);
            floatBuffer.put(i2 + 7, 0.0f);
            floatBuffer.put(i2 + 8, 0.0f);
            floatBuffer.put(i2 + 9, 0.0f);
            floatBuffer.put(i2 + 10, 1.0f);
            floatBuffer.put(i2 + 11, 0.0f);
            floatBuffer.put(i2 + 12, matrix3x2f.m20());
            floatBuffer.put(i2 + 13, matrix3x2f.m21());
            floatBuffer.put(i2 + 14, 0.0f);
            floatBuffer.put(i2 + 15, 1.0f);
        }

        public void getf(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer) {
            matrix3d._m00((double) byteBuffer.getFloat(i2));
            matrix3d._m01((double) byteBuffer.getFloat(i2 + 4));
            matrix3d._m02((double) byteBuffer.getFloat(i2 + 8));
            matrix3d._m10((double) byteBuffer.getFloat(i2 + 12));
            matrix3d._m11((double) byteBuffer.getFloat(i2 + 16));
            matrix3d._m12((double) byteBuffer.getFloat(i2 + 20));
            matrix3d._m20((double) byteBuffer.getFloat(i2 + 24));
            matrix3d._m21((double) byteBuffer.getFloat(i2 + 28));
            matrix3d._m22((double) byteBuffer.getFloat(i2 + 32));
        }

        public void putTransposed(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix3f.m00());
            byteBuffer.putFloat(i2 + 4, matrix3f.m10());
            byteBuffer.putFloat(i2 + 8, matrix3f.m20());
            byteBuffer.putFloat(i2 + 12, matrix3f.m01());
            byteBuffer.putFloat(i2 + 16, matrix3f.m11());
            byteBuffer.putFloat(i2 + 20, matrix3f.m21());
            byteBuffer.putFloat(i2 + 24, matrix3f.m02());
            byteBuffer.putFloat(i2 + 28, matrix3f.m12());
            byteBuffer.putFloat(i2 + 32, matrix3f.m22());
        }

        public void putf(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, (float) matrix3d.m00());
            byteBuffer.putFloat(i2 + 4, (float) matrix3d.m01());
            byteBuffer.putFloat(i2 + 8, (float) matrix3d.m02());
            byteBuffer.putFloat(i2 + 12, (float) matrix3d.m10());
            byteBuffer.putFloat(i2 + 16, (float) matrix3d.m11());
            byteBuffer.putFloat(i2 + 20, (float) matrix3d.m12());
            byteBuffer.putFloat(i2 + 24, (float) matrix3d.m20());
            byteBuffer.putFloat(i2 + 28, (float) matrix3d.m21());
            byteBuffer.putFloat(i2 + 32, (float) matrix3d.m22());
        }

        public void copy(Vector4i vector4i, Vector4i vector4i2) {
            vector4i2.x = vector4i.x;
            vector4i2.y = vector4i.y;
            vector4i2.z = vector4i.z;
            vector4i2.w = vector4i.w;
        }

        public void copy(Quaternionf quaternionf, Quaternionf quaternionf2) {
            quaternionf2.x = quaternionf.x;
            quaternionf2.y = quaternionf.y;
            quaternionf2.z = quaternionf.z;
            quaternionf2.w = quaternionf.w;
        }

        public void get(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            matrix4d._m00(byteBuffer.getDouble(i2));
            matrix4d._m01(byteBuffer.getDouble(i2 + 8));
            matrix4d._m02(byteBuffer.getDouble(i2 + 16));
            matrix4d._m03(byteBuffer.getDouble(i2 + 24));
            matrix4d._m10(byteBuffer.getDouble(i2 + 32));
            matrix4d._m11(byteBuffer.getDouble(i2 + 40));
            matrix4d._m12(byteBuffer.getDouble(i2 + 48));
            matrix4d._m13(byteBuffer.getDouble(i2 + 56));
            matrix4d._m20(byteBuffer.getDouble(i2 + 64));
            matrix4d._m21(byteBuffer.getDouble(i2 + 72));
            matrix4d._m22(byteBuffer.getDouble(i2 + 80));
            matrix4d._m23(byteBuffer.getDouble(i2 + 88));
            matrix4d._m30(byteBuffer.getDouble(i2 + 96));
            matrix4d._m31(byteBuffer.getDouble(i2 + 104));
            matrix4d._m32(byteBuffer.getDouble(i2 + 112));
            matrix4d._m33(byteBuffer.getDouble(i2 + 120));
        }

        public void put(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix3f.m00());
            byteBuffer.putFloat(i2 + 4, matrix3f.m01());
            byteBuffer.putFloat(i2 + 8, matrix3f.m02());
            byteBuffer.putFloat(i2 + 12, matrix3f.m10());
            byteBuffer.putFloat(i2 + 16, matrix3f.m11());
            byteBuffer.putFloat(i2 + 20, matrix3f.m12());
            byteBuffer.putFloat(i2 + 24, matrix3f.m20());
            byteBuffer.putFloat(i2 + 28, matrix3f.m21());
            byteBuffer.putFloat(i2 + 32, matrix3f.m22());
        }

        public void copy(Matrix4f matrix4f, Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(matrix4f.m00());
            matrix4x3f._m01(matrix4f.m01());
            matrix4x3f._m02(matrix4f.m02());
            matrix4x3f._m10(matrix4f.m10());
            matrix4x3f._m11(matrix4f.m11());
            matrix4x3f._m12(matrix4f.m12());
            matrix4x3f._m20(matrix4f.m20());
            matrix4x3f._m21(matrix4f.m21());
            matrix4x3f._m22(matrix4f.m22());
            matrix4x3f._m30(matrix4f.m30());
            matrix4x3f._m31(matrix4f.m31());
            matrix4x3f._m32(matrix4f.m32());
        }

        public void putTransposed(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4d.m00());
            doubleBuffer.put(i2 + 1, matrix4d.m10());
            doubleBuffer.put(i2 + 2, matrix4d.m20());
            doubleBuffer.put(i2 + 3, matrix4d.m30());
            doubleBuffer.put(i2 + 4, matrix4d.m01());
            doubleBuffer.put(i2 + 5, matrix4d.m11());
            doubleBuffer.put(i2 + 6, matrix4d.m21());
            doubleBuffer.put(i2 + 7, matrix4d.m31());
            doubleBuffer.put(i2 + 8, matrix4d.m02());
            doubleBuffer.put(i2 + 9, matrix4d.m12());
            doubleBuffer.put(i2 + 10, matrix4d.m22());
            doubleBuffer.put(i2 + 11, matrix4d.m32());
            doubleBuffer.put(i2 + 12, matrix4d.m03());
            doubleBuffer.put(i2 + 13, matrix4d.m13());
            doubleBuffer.put(i2 + 14, matrix4d.m23());
            doubleBuffer.put(i2 + 15, matrix4d.m33());
        }

        public void put4x4(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix3x2f.m00());
            byteBuffer.putFloat(i2 + 4, matrix3x2f.m01());
            byteBuffer.putFloat(i2 + 8, 0.0f);
            byteBuffer.putFloat(i2 + 12, 0.0f);
            byteBuffer.putFloat(i2 + 16, matrix3x2f.m10());
            byteBuffer.putFloat(i2 + 20, matrix3x2f.m11());
            byteBuffer.putFloat(i2 + 24, 0.0f);
            byteBuffer.putFloat(i2 + 28, 0.0f);
            byteBuffer.putFloat(i2 + 32, 0.0f);
            byteBuffer.putFloat(i2 + 36, 0.0f);
            byteBuffer.putFloat(i2 + 40, 1.0f);
            byteBuffer.putFloat(i2 + 44, 0.0f);
            byteBuffer.putFloat(i2 + 48, matrix3x2f.m20());
            byteBuffer.putFloat(i2 + 52, matrix3x2f.m21());
            byteBuffer.putFloat(i2 + 56, 0.0f);
            byteBuffer.putFloat(i2 + 60, 1.0f);
        }

        public void put(Matrix3d matrix3d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix3d.m00());
            doubleBuffer.put(i2 + 1, matrix3d.m01());
            doubleBuffer.put(i2 + 2, matrix3d.m02());
            doubleBuffer.put(i2 + 3, matrix3d.m10());
            doubleBuffer.put(i2 + 4, matrix3d.m11());
            doubleBuffer.put(i2 + 5, matrix3d.m12());
            doubleBuffer.put(i2 + 6, matrix3d.m20());
            doubleBuffer.put(i2 + 7, matrix3d.m21());
            doubleBuffer.put(i2 + 8, matrix3d.m22());
        }

        public void copy(Matrix4x3f matrix4x3f, Matrix4f matrix4f) {
            matrix4f._m00(matrix4x3f.m00());
            matrix4f._m01(matrix4x3f.m01());
            matrix4f._m02(matrix4x3f.m02());
            matrix4f._m03(0.0f);
            matrix4f._m10(matrix4x3f.m10());
            matrix4f._m11(matrix4x3f.m11());
            matrix4f._m12(matrix4x3f.m12());
            matrix4f._m13(0.0f);
            matrix4f._m20(matrix4x3f.m20());
            matrix4f._m21(matrix4x3f.m21());
            matrix4f._m22(matrix4x3f.m22());
            matrix4f._m23(0.0f);
            matrix4f._m30(matrix4x3f.m30());
            matrix4f._m31(matrix4x3f.m31());
            matrix4f._m32(matrix4x3f.m32());
            matrix4f._m33(1.0f);
        }

        public void get(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer) {
            matrix4x3d._m00(doubleBuffer.get(i2));
            matrix4x3d._m01(doubleBuffer.get(i2 + 1));
            matrix4x3d._m02(doubleBuffer.get(i2 + 2));
            matrix4x3d._m10(doubleBuffer.get(i2 + 3));
            matrix4x3d._m11(doubleBuffer.get(i2 + 4));
            matrix4x3d._m12(doubleBuffer.get(i2 + 5));
            matrix4x3d._m20(doubleBuffer.get(i2 + 6));
            matrix4x3d._m21(doubleBuffer.get(i2 + 7));
            matrix4x3d._m22(doubleBuffer.get(i2 + 8));
            matrix4x3d._m30(doubleBuffer.get(i2 + 9));
            matrix4x3d._m31(doubleBuffer.get(i2 + 10));
            matrix4x3d._m32(doubleBuffer.get(i2 + 11));
        }

        public void putTransposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4d.m00());
            byteBuffer.putDouble(i2 + 8, matrix4d.m10());
            byteBuffer.putDouble(i2 + 16, matrix4d.m20());
            byteBuffer.putDouble(i2 + 24, matrix4d.m30());
            byteBuffer.putDouble(i2 + 32, matrix4d.m01());
            byteBuffer.putDouble(i2 + 40, matrix4d.m11());
            byteBuffer.putDouble(i2 + 48, matrix4d.m21());
            byteBuffer.putDouble(i2 + 56, matrix4d.m31());
            byteBuffer.putDouble(i2 + 64, matrix4d.m02());
            byteBuffer.putDouble(i2 + 72, matrix4d.m12());
            byteBuffer.putDouble(i2 + 80, matrix4d.m22());
            byteBuffer.putDouble(i2 + 88, matrix4d.m32());
            byteBuffer.putDouble(i2 + 96, matrix4d.m03());
            byteBuffer.putDouble(i2 + 104, matrix4d.m13());
            byteBuffer.putDouble(i2 + 112, matrix4d.m23());
            byteBuffer.putDouble(i2 + 120, matrix4d.m33());
        }

        public void put(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix3d.m00());
            byteBuffer.putDouble(i2 + 8, matrix3d.m01());
            byteBuffer.putDouble(i2 + 16, matrix3d.m02());
            byteBuffer.putDouble(i2 + 24, matrix3d.m10());
            byteBuffer.putDouble(i2 + 32, matrix3d.m11());
            byteBuffer.putDouble(i2 + 40, matrix3d.m12());
            byteBuffer.putDouble(i2 + 48, matrix3d.m20());
            byteBuffer.putDouble(i2 + 56, matrix3d.m21());
            byteBuffer.putDouble(i2 + 64, matrix3d.m22());
        }

        public void put4x4(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix3x2d.m00());
            doubleBuffer.put(i2 + 1, matrix3x2d.m01());
            doubleBuffer.put(i2 + 2, 0.0d);
            doubleBuffer.put(i2 + 3, 0.0d);
            doubleBuffer.put(i2 + 4, matrix3x2d.m10());
            doubleBuffer.put(i2 + 5, matrix3x2d.m11());
            doubleBuffer.put(i2 + 6, 0.0d);
            doubleBuffer.put(i2 + 7, 0.0d);
            doubleBuffer.put(i2 + 8, 0.0d);
            doubleBuffer.put(i2 + 9, 0.0d);
            doubleBuffer.put(i2 + 10, 1.0d);
            doubleBuffer.put(i2 + 11, 0.0d);
            doubleBuffer.put(i2 + 12, matrix3x2d.m20());
            doubleBuffer.put(i2 + 13, matrix3x2d.m21());
            doubleBuffer.put(i2 + 14, 0.0d);
            doubleBuffer.put(i2 + 15, 1.0d);
        }

        public void get(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            matrix4x3d._m00(byteBuffer.getDouble(i2));
            matrix4x3d._m01(byteBuffer.getDouble(i2 + 8));
            matrix4x3d._m02(byteBuffer.getDouble(i2 + 16));
            matrix4x3d._m10(byteBuffer.getDouble(i2 + 24));
            matrix4x3d._m11(byteBuffer.getDouble(i2 + 32));
            matrix4x3d._m12(byteBuffer.getDouble(i2 + 40));
            matrix4x3d._m20(byteBuffer.getDouble(i2 + 48));
            matrix4x3d._m21(byteBuffer.getDouble(i2 + 56));
            matrix4x3d._m22(byteBuffer.getDouble(i2 + 64));
            matrix4x3d._m30(byteBuffer.getDouble(i2 + 72));
            matrix4x3d._m31(byteBuffer.getDouble(i2 + 80));
            matrix4x3d._m32(byteBuffer.getDouble(i2 + 88));
        }

        public void put(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, matrix3x2f.m00());
            floatBuffer.put(i2 + 1, matrix3x2f.m01());
            floatBuffer.put(i2 + 2, matrix3x2f.m10());
            floatBuffer.put(i2 + 3, matrix3x2f.m11());
            floatBuffer.put(i2 + 4, matrix3x2f.m20());
            floatBuffer.put(i2 + 5, matrix3x2f.m21());
        }

        public void copy(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2) {
            matrix4x3f2._m00(matrix4x3f.m00());
            matrix4x3f2._m01(matrix4x3f.m01());
            matrix4x3f2._m02(matrix4x3f.m02());
            matrix4x3f2._m10(matrix4x3f.m10());
            matrix4x3f2._m11(matrix4x3f.m11());
            matrix4x3f2._m12(matrix4x3f.m12());
            matrix4x3f2._m20(matrix4x3f.m20());
            matrix4x3f2._m21(matrix4x3f.m21());
            matrix4x3f2._m22(matrix4x3f.m22());
            matrix4x3f2._m30(matrix4x3f.m30());
            matrix4x3f2._m31(matrix4x3f.m31());
            matrix4x3f2._m32(matrix4x3f.m32());
        }

        public void put(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, matrix3x2f.m00());
            byteBuffer.putFloat(i2 + 4, matrix3x2f.m01());
            byteBuffer.putFloat(i2 + 8, matrix3x2f.m10());
            byteBuffer.putFloat(i2 + 12, matrix3x2f.m11());
            byteBuffer.putFloat(i2 + 16, matrix3x2f.m20());
            byteBuffer.putFloat(i2 + 20, matrix3x2f.m21());
        }

        public void putTransposed(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix4x3d.m00());
            doubleBuffer.put(i2 + 1, matrix4x3d.m10());
            doubleBuffer.put(i2 + 2, matrix4x3d.m20());
            doubleBuffer.put(i2 + 3, matrix4x3d.m30());
            doubleBuffer.put(i2 + 4, matrix4x3d.m01());
            doubleBuffer.put(i2 + 5, matrix4x3d.m11());
            doubleBuffer.put(i2 + 6, matrix4x3d.m21());
            doubleBuffer.put(i2 + 7, matrix4x3d.m31());
            doubleBuffer.put(i2 + 8, matrix4x3d.m02());
            doubleBuffer.put(i2 + 9, matrix4x3d.m12());
            doubleBuffer.put(i2 + 10, matrix4x3d.m22());
            doubleBuffer.put(i2 + 11, matrix4x3d.m32());
        }

        public void get(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer) {
            matrix3f._m00(floatBuffer.get(i2));
            matrix3f._m01(floatBuffer.get(i2 + 1));
            matrix3f._m02(floatBuffer.get(i2 + 2));
            matrix3f._m10(floatBuffer.get(i2 + 3));
            matrix3f._m11(floatBuffer.get(i2 + 4));
            matrix3f._m12(floatBuffer.get(i2 + 5));
            matrix3f._m20(floatBuffer.get(i2 + 6));
            matrix3f._m21(floatBuffer.get(i2 + 7));
            matrix3f._m22(floatBuffer.get(i2 + 8));
        }

        public void put(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, matrix3x2d.m00());
            doubleBuffer.put(i2 + 1, matrix3x2d.m01());
            doubleBuffer.put(i2 + 2, matrix3x2d.m10());
            doubleBuffer.put(i2 + 3, matrix3x2d.m11());
            doubleBuffer.put(i2 + 4, matrix3x2d.m20());
            doubleBuffer.put(i2 + 5, matrix3x2d.m21());
        }

        public void put4x4(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix3x2d.m00());
            byteBuffer.putDouble(i2 + 8, matrix3x2d.m01());
            byteBuffer.putDouble(i2 + 16, 0.0d);
            byteBuffer.putDouble(i2 + 24, 0.0d);
            byteBuffer.putDouble(i2 + 32, matrix3x2d.m10());
            byteBuffer.putDouble(i2 + 40, matrix3x2d.m11());
            byteBuffer.putDouble(i2 + 48, 0.0d);
            byteBuffer.putDouble(i2 + 56, 0.0d);
            byteBuffer.putDouble(i2 + 64, 0.0d);
            byteBuffer.putDouble(i2 + 72, 0.0d);
            byteBuffer.putDouble(i2 + 80, 1.0d);
            byteBuffer.putDouble(i2 + 88, 0.0d);
            byteBuffer.putDouble(i2 + 96, matrix3x2d.m20());
            byteBuffer.putDouble(i2 + 104, matrix3x2d.m21());
            byteBuffer.putDouble(i2 + 112, 0.0d);
            byteBuffer.putDouble(i2 + 120, 1.0d);
        }

        public void copy(Matrix3f matrix3f, Matrix3f matrix3f2) {
            matrix3f2._m00(matrix3f.m00());
            matrix3f2._m01(matrix3f.m01());
            matrix3f2._m02(matrix3f.m02());
            matrix3f2._m10(matrix3f.m10());
            matrix3f2._m11(matrix3f.m11());
            matrix3f2._m12(matrix3f.m12());
            matrix3f2._m20(matrix3f.m20());
            matrix3f2._m21(matrix3f.m21());
            matrix3f2._m22(matrix3f.m22());
        }

        public void put(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix3x2d.m00());
            byteBuffer.putDouble(i2 + 8, matrix3x2d.m01());
            byteBuffer.putDouble(i2 + 16, matrix3x2d.m10());
            byteBuffer.putDouble(i2 + 24, matrix3x2d.m11());
            byteBuffer.putDouble(i2 + 32, matrix3x2d.m20());
            byteBuffer.putDouble(i2 + 40, matrix3x2d.m21());
        }

        public void putTransposed(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, matrix4x3d.m00());
            byteBuffer.putDouble(i2 + 4, matrix4x3d.m10());
            byteBuffer.putDouble(i2 + 8, matrix4x3d.m20());
            byteBuffer.putDouble(i2 + 12, matrix4x3d.m30());
            byteBuffer.putDouble(i2 + 16, matrix4x3d.m01());
            byteBuffer.putDouble(i2 + 20, matrix4x3d.m11());
            byteBuffer.putDouble(i2 + 24, matrix4x3d.m21());
            byteBuffer.putDouble(i2 + 28, matrix4x3d.m31());
            byteBuffer.putDouble(i2 + 32, matrix4x3d.m02());
            byteBuffer.putDouble(i2 + 36, matrix4x3d.m12());
            byteBuffer.putDouble(i2 + 40, matrix4x3d.m22());
            byteBuffer.putDouble(i2 + 44, matrix4x3d.m32());
        }

        public void get(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer) {
            matrix3f._m00(byteBuffer.getFloat(i2));
            matrix3f._m01(byteBuffer.getFloat(i2 + 4));
            matrix3f._m02(byteBuffer.getFloat(i2 + 8));
            matrix3f._m10(byteBuffer.getFloat(i2 + 12));
            matrix3f._m11(byteBuffer.getFloat(i2 + 16));
            matrix3f._m12(byteBuffer.getFloat(i2 + 20));
            matrix3f._m20(byteBuffer.getFloat(i2 + 24));
            matrix3f._m21(byteBuffer.getFloat(i2 + 28));
            matrix3f._m22(byteBuffer.getFloat(i2 + 32));
        }

        public void copy(float[] fArr, int i2, Matrix4f matrix4f) {
            matrix4f._m00(fArr[i2 + 0]);
            matrix4f._m01(fArr[i2 + 1]);
            matrix4f._m02(fArr[i2 + 2]);
            matrix4f._m03(fArr[i2 + 3]);
            matrix4f._m10(fArr[i2 + 4]);
            matrix4f._m11(fArr[i2 + 5]);
            matrix4f._m12(fArr[i2 + 6]);
            matrix4f._m13(fArr[i2 + 7]);
            matrix4f._m20(fArr[i2 + 8]);
            matrix4f._m21(fArr[i2 + 9]);
            matrix4f._m22(fArr[i2 + 10]);
            matrix4f._m23(fArr[i2 + 11]);
            matrix4f._m30(fArr[i2 + 12]);
            matrix4f._m31(fArr[i2 + 13]);
            matrix4f._m32(fArr[i2 + 14]);
            matrix4f._m33(fArr[i2 + 15]);
        }

        public void put(Vector4d vector4d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, vector4d.x);
            doubleBuffer.put(i2 + 1, vector4d.y);
            doubleBuffer.put(i2 + 2, vector4d.z);
            doubleBuffer.put(i2 + 3, vector4d.w);
        }

        public void put(Vector4d vector4d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, vector4d.x);
            byteBuffer.putDouble(i2 + 8, vector4d.y);
            byteBuffer.putDouble(i2 + 16, vector4d.z);
            byteBuffer.putDouble(i2 + 24, vector4d.w);
        }

        public void get(Matrix3d matrix3d, int i2, DoubleBuffer doubleBuffer) {
            matrix3d._m00(doubleBuffer.get(i2));
            matrix3d._m01(doubleBuffer.get(i2 + 1));
            matrix3d._m02(doubleBuffer.get(i2 + 2));
            matrix3d._m10(doubleBuffer.get(i2 + 3));
            matrix3d._m11(doubleBuffer.get(i2 + 4));
            matrix3d._m12(doubleBuffer.get(i2 + 5));
            matrix3d._m20(doubleBuffer.get(i2 + 6));
            matrix3d._m21(doubleBuffer.get(i2 + 7));
            matrix3d._m22(doubleBuffer.get(i2 + 8));
        }

        public void put(Vector4f vector4f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, vector4f.x);
            floatBuffer.put(i2 + 1, vector4f.y);
            floatBuffer.put(i2 + 2, vector4f.z);
            floatBuffer.put(i2 + 3, vector4f.w);
        }

        public void put(Vector4f vector4f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, vector4f.x);
            byteBuffer.putFloat(i2 + 4, vector4f.y);
            byteBuffer.putFloat(i2 + 8, vector4f.z);
            byteBuffer.putFloat(i2 + 12, vector4f.w);
        }

        public void copy(float[] fArr, int i2, Matrix3f matrix3f) {
            matrix3f._m00(fArr[i2 + 0]);
            matrix3f._m01(fArr[i2 + 1]);
            matrix3f._m02(fArr[i2 + 2]);
            matrix3f._m10(fArr[i2 + 3]);
            matrix3f._m11(fArr[i2 + 4]);
            matrix3f._m12(fArr[i2 + 5]);
            matrix3f._m20(fArr[i2 + 6]);
            matrix3f._m21(fArr[i2 + 7]);
            matrix3f._m22(fArr[i2 + 8]);
        }

        public void get(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer) {
            matrix3d._m00(byteBuffer.getDouble(i2));
            matrix3d._m01(byteBuffer.getDouble(i2 + 8));
            matrix3d._m02(byteBuffer.getDouble(i2 + 16));
            matrix3d._m10(byteBuffer.getDouble(i2 + 24));
            matrix3d._m11(byteBuffer.getDouble(i2 + 32));
            matrix3d._m12(byteBuffer.getDouble(i2 + 40));
            matrix3d._m20(byteBuffer.getDouble(i2 + 48));
            matrix3d._m21(byteBuffer.getDouble(i2 + 56));
            matrix3d._m22(byteBuffer.getDouble(i2 + 64));
        }

        public void put(Vector4i vector4i, int i2, IntBuffer intBuffer) {
            intBuffer.put(i2, vector4i.x);
            intBuffer.put(i2 + 1, vector4i.y);
            intBuffer.put(i2 + 2, vector4i.z);
            intBuffer.put(i2 + 3, vector4i.w);
        }

        public void put(Vector4i vector4i, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putInt(i2, vector4i.x);
            byteBuffer.putInt(i2 + 4, vector4i.y);
            byteBuffer.putInt(i2 + 8, vector4i.z);
            byteBuffer.putInt(i2 + 12, vector4i.w);
        }

        public void copy(float[] fArr, int i2, Matrix4x3f matrix4x3f) {
            matrix4x3f._m00(fArr[i2 + 0]);
            matrix4x3f._m01(fArr[i2 + 1]);
            matrix4x3f._m02(fArr[i2 + 2]);
            matrix4x3f._m10(fArr[i2 + 3]);
            matrix4x3f._m11(fArr[i2 + 4]);
            matrix4x3f._m12(fArr[i2 + 5]);
            matrix4x3f._m20(fArr[i2 + 6]);
            matrix4x3f._m21(fArr[i2 + 7]);
            matrix4x3f._m22(fArr[i2 + 8]);
            matrix4x3f._m30(fArr[i2 + 9]);
            matrix4x3f._m31(fArr[i2 + 10]);
            matrix4x3f._m32(fArr[i2 + 11]);
        }

        public void get(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer) {
            matrix3x2f._m00(floatBuffer.get(i2));
            matrix3x2f._m01(floatBuffer.get(i2 + 1));
            matrix3x2f._m10(floatBuffer.get(i2 + 2));
            matrix3x2f._m11(floatBuffer.get(i2 + 3));
            matrix3x2f._m20(floatBuffer.get(i2 + 4));
            matrix3x2f._m21(floatBuffer.get(i2 + 5));
        }

        public void put(Vector3f vector3f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, vector3f.x);
            floatBuffer.put(i2 + 1, vector3f.y);
            floatBuffer.put(i2 + 2, vector3f.z);
        }

        public void put(Vector3f vector3f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, vector3f.x);
            byteBuffer.putFloat(i2 + 4, vector3f.y);
            byteBuffer.putFloat(i2 + 8, vector3f.z);
        }

        public void get(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer) {
            matrix3x2f._m00(byteBuffer.getFloat(i2));
            matrix3x2f._m01(byteBuffer.getFloat(i2 + 4));
            matrix3x2f._m10(byteBuffer.getFloat(i2 + 8));
            matrix3x2f._m11(byteBuffer.getFloat(i2 + 12));
            matrix3x2f._m20(byteBuffer.getFloat(i2 + 16));
            matrix3x2f._m21(byteBuffer.getFloat(i2 + 20));
        }

        public void put(Vector3d vector3d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, vector3d.x);
            doubleBuffer.put(i2 + 1, vector3d.y);
            doubleBuffer.put(i2 + 2, vector3d.z);
        }

        public void put(Vector3d vector3d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, vector3d.x);
            byteBuffer.putDouble(i2 + 8, vector3d.y);
            byteBuffer.putDouble(i2 + 16, vector3d.z);
        }

        public void copy(float[] fArr, int i2, Matrix3x2f matrix3x2f) {
            matrix3x2f._m00(fArr[i2 + 0]);
            matrix3x2f._m01(fArr[i2 + 1]);
            matrix3x2f._m10(fArr[i2 + 2]);
            matrix3x2f._m11(fArr[i2 + 3]);
            matrix3x2f._m20(fArr[i2 + 4]);
            matrix3x2f._m21(fArr[i2 + 5]);
        }

        public void get(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer) {
            matrix3x2d._m00(doubleBuffer.get(i2));
            matrix3x2d._m01(doubleBuffer.get(i2 + 1));
            matrix3x2d._m10(doubleBuffer.get(i2 + 2));
            matrix3x2d._m11(doubleBuffer.get(i2 + 3));
            matrix3x2d._m20(doubleBuffer.get(i2 + 4));
            matrix3x2d._m21(doubleBuffer.get(i2 + 5));
        }

        public void put(Vector3i vector3i, int i2, IntBuffer intBuffer) {
            intBuffer.put(i2, vector3i.x);
            intBuffer.put(i2 + 1, vector3i.y);
            intBuffer.put(i2 + 2, vector3i.z);
        }

        public void put(Vector3i vector3i, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putInt(i2, vector3i.x);
            byteBuffer.putInt(i2 + 4, vector3i.y);
            byteBuffer.putInt(i2 + 8, vector3i.z);
        }

        public void copy(double[] dArr, int i2, Matrix3x2d matrix3x2d) {
            matrix3x2d._m00(dArr[i2 + 0]);
            matrix3x2d._m01(dArr[i2 + 1]);
            matrix3x2d._m10(dArr[i2 + 2]);
            matrix3x2d._m11(dArr[i2 + 3]);
            matrix3x2d._m20(dArr[i2 + 4]);
            matrix3x2d._m21(dArr[i2 + 5]);
        }

        public void get(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer) {
            matrix3x2d._m00(byteBuffer.getDouble(i2));
            matrix3x2d._m01(byteBuffer.getDouble(i2 + 8));
            matrix3x2d._m10(byteBuffer.getDouble(i2 + 16));
            matrix3x2d._m11(byteBuffer.getDouble(i2 + 24));
            matrix3x2d._m20(byteBuffer.getDouble(i2 + 32));
            matrix3x2d._m21(byteBuffer.getDouble(i2 + 40));
        }

        public void put(Vector2f vector2f, int i2, FloatBuffer floatBuffer) {
            floatBuffer.put(i2, vector2f.x);
            floatBuffer.put(i2 + 1, vector2f.y);
        }

        public void put(Vector2f vector2f, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putFloat(i2, vector2f.x);
            byteBuffer.putFloat(i2 + 4, vector2f.y);
        }

        public void put(Vector2d vector2d, int i2, DoubleBuffer doubleBuffer) {
            doubleBuffer.put(i2, vector2d.x);
            doubleBuffer.put(i2 + 1, vector2d.y);
        }

        public void copy(Matrix4f matrix4f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix4f.m00();
            fArr[i2 + 1] = matrix4f.m01();
            fArr[i2 + 2] = matrix4f.m02();
            fArr[i2 + 3] = matrix4f.m03();
            fArr[i2 + 4] = matrix4f.m10();
            fArr[i2 + 5] = matrix4f.m11();
            fArr[i2 + 6] = matrix4f.m12();
            fArr[i2 + 7] = matrix4f.m13();
            fArr[i2 + 8] = matrix4f.m20();
            fArr[i2 + 9] = matrix4f.m21();
            fArr[i2 + 10] = matrix4f.m22();
            fArr[i2 + 11] = matrix4f.m23();
            fArr[i2 + 12] = matrix4f.m30();
            fArr[i2 + 13] = matrix4f.m31();
            fArr[i2 + 14] = matrix4f.m32();
            fArr[i2 + 15] = matrix4f.m33();
        }

        public void get(Vector4d vector4d, int i2, DoubleBuffer doubleBuffer) {
            vector4d.x = doubleBuffer.get(i2);
            vector4d.y = doubleBuffer.get(i2 + 1);
            vector4d.z = doubleBuffer.get(i2 + 2);
            vector4d.w = doubleBuffer.get(i2 + 3);
        }

        public void put(Vector2d vector2d, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putDouble(i2, vector2d.x);
            byteBuffer.putDouble(i2 + 8, vector2d.y);
        }

        public void put(Vector2i vector2i, int i2, IntBuffer intBuffer) {
            intBuffer.put(i2, vector2i.x);
            intBuffer.put(i2 + 1, vector2i.y);
        }

        public void get(Vector4d vector4d, int i2, ByteBuffer byteBuffer) {
            vector4d.x = byteBuffer.getDouble(i2);
            vector4d.y = byteBuffer.getDouble(i2 + 8);
            vector4d.z = byteBuffer.getDouble(i2 + 16);
            vector4d.w = byteBuffer.getDouble(i2 + 24);
        }

        public void put(Vector2i vector2i, int i2, ByteBuffer byteBuffer) {
            byteBuffer.putInt(i2, vector2i.x);
            byteBuffer.putInt(i2 + 4, vector2i.y);
        }

        public void get(Vector4f vector4f, int i2, FloatBuffer floatBuffer) {
            vector4f.x = floatBuffer.get(i2);
            vector4f.y = floatBuffer.get(i2 + 1);
            vector4f.z = floatBuffer.get(i2 + 2);
            vector4f.w = floatBuffer.get(i2 + 3);
        }

        public void get(Vector4f vector4f, int i2, ByteBuffer byteBuffer) {
            vector4f.x = byteBuffer.getFloat(i2);
            vector4f.y = byteBuffer.getFloat(i2 + 4);
            vector4f.z = byteBuffer.getFloat(i2 + 8);
            vector4f.w = byteBuffer.getFloat(i2 + 12);
        }

        public void copy(Matrix3f matrix3f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix3f.m00();
            fArr[i2 + 1] = matrix3f.m01();
            fArr[i2 + 2] = matrix3f.m02();
            fArr[i2 + 3] = matrix3f.m10();
            fArr[i2 + 4] = matrix3f.m11();
            fArr[i2 + 5] = matrix3f.m12();
            fArr[i2 + 6] = matrix3f.m20();
            fArr[i2 + 7] = matrix3f.m21();
            fArr[i2 + 8] = matrix3f.m22();
        }

        public void get(Vector4i vector4i, int i2, IntBuffer intBuffer) {
            vector4i.x = intBuffer.get(i2);
            vector4i.y = intBuffer.get(i2 + 1);
            vector4i.z = intBuffer.get(i2 + 2);
            vector4i.w = intBuffer.get(i2 + 3);
        }

        public void get(Vector4i vector4i, int i2, ByteBuffer byteBuffer) {
            vector4i.x = byteBuffer.getInt(i2);
            vector4i.y = byteBuffer.getInt(i2 + 4);
            vector4i.z = byteBuffer.getInt(i2 + 8);
            vector4i.w = byteBuffer.getInt(i2 + 12);
        }

        public void get(Vector3f vector3f, int i2, FloatBuffer floatBuffer) {
            vector3f.x = floatBuffer.get(i2);
            vector3f.y = floatBuffer.get(i2 + 1);
            vector3f.z = floatBuffer.get(i2 + 2);
        }

        public void copy(Matrix4x3f matrix4x3f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix4x3f.m00();
            fArr[i2 + 1] = matrix4x3f.m01();
            fArr[i2 + 2] = matrix4x3f.m02();
            fArr[i2 + 3] = matrix4x3f.m10();
            fArr[i2 + 4] = matrix4x3f.m11();
            fArr[i2 + 5] = matrix4x3f.m12();
            fArr[i2 + 6] = matrix4x3f.m20();
            fArr[i2 + 7] = matrix4x3f.m21();
            fArr[i2 + 8] = matrix4x3f.m22();
            fArr[i2 + 9] = matrix4x3f.m30();
            fArr[i2 + 10] = matrix4x3f.m31();
            fArr[i2 + 11] = matrix4x3f.m32();
        }

        public void get(Vector3f vector3f, int i2, ByteBuffer byteBuffer) {
            vector3f.x = byteBuffer.getFloat(i2);
            vector3f.y = byteBuffer.getFloat(i2 + 4);
            vector3f.z = byteBuffer.getFloat(i2 + 8);
        }

        public void get(Vector3d vector3d, int i2, DoubleBuffer doubleBuffer) {
            vector3d.x = doubleBuffer.get(i2);
            vector3d.y = doubleBuffer.get(i2 + 1);
            vector3d.z = doubleBuffer.get(i2 + 2);
        }

        public void get(Vector3d vector3d, int i2, ByteBuffer byteBuffer) {
            vector3d.x = byteBuffer.getDouble(i2);
            vector3d.y = byteBuffer.getDouble(i2 + 8);
            vector3d.z = byteBuffer.getDouble(i2 + 16);
        }

        public void get(Vector3i vector3i, int i2, IntBuffer intBuffer) {
            vector3i.x = intBuffer.get(i2);
            vector3i.y = intBuffer.get(i2 + 1);
            vector3i.z = intBuffer.get(i2 + 2);
        }

        public void copy(Matrix3x2f matrix3x2f, float[] fArr, int i2) {
            fArr[i2 + 0] = matrix3x2f.m00();
            fArr[i2 + 1] = matrix3x2f.m01();
            fArr[i2 + 2] = matrix3x2f.m10();
            fArr[i2 + 3] = matrix3x2f.m11();
            fArr[i2 + 4] = matrix3x2f.m20();
            fArr[i2 + 5] = matrix3x2f.m21();
        }

        public void get(Vector3i vector3i, int i2, ByteBuffer byteBuffer) {
            vector3i.x = byteBuffer.getInt(i2);
            vector3i.y = byteBuffer.getInt(i2 + 4);
            vector3i.z = byteBuffer.getInt(i2 + 8);
        }

        public void get(Vector2f vector2f, int i2, FloatBuffer floatBuffer) {
            vector2f.x = floatBuffer.get(i2);
            vector2f.y = floatBuffer.get(i2 + 1);
        }

        public void copy(Matrix3x2d matrix3x2d, double[] dArr, int i2) {
            dArr[i2 + 0] = matrix3x2d.m00();
            dArr[i2 + 1] = matrix3x2d.m01();
            dArr[i2 + 2] = matrix3x2d.m10();
            dArr[i2 + 3] = matrix3x2d.m11();
            dArr[i2 + 4] = matrix3x2d.m20();
            dArr[i2 + 5] = matrix3x2d.m21();
        }

        public void get(Vector2f vector2f, int i2, ByteBuffer byteBuffer) {
            vector2f.x = byteBuffer.getFloat(i2);
            vector2f.y = byteBuffer.getFloat(i2 + 4);
        }

        public void get(Vector2d vector2d, int i2, DoubleBuffer doubleBuffer) {
            vector2d.x = doubleBuffer.get(i2);
            vector2d.y = doubleBuffer.get(i2 + 1);
        }

        public void get(Vector2d vector2d, int i2, ByteBuffer byteBuffer) {
            vector2d.x = byteBuffer.getDouble(i2);
            vector2d.y = byteBuffer.getDouble(i2 + 8);
        }

        public void get(Vector2i vector2i, int i2, IntBuffer intBuffer) {
            vector2i.x = intBuffer.get(i2);
            vector2i.y = intBuffer.get(i2 + 1);
        }

        public void get(Vector2i vector2i, int i2, ByteBuffer byteBuffer) {
            vector2i.x = byteBuffer.getInt(i2);
            vector2i.y = byteBuffer.getInt(i2 + 4);
        }
    }

    public static MemUtil createInstance() {
        new MemUtilNIO();
        try {
            return new MemUtilNIO();
        } catch (Throwable unused) {
            return new MemUtilNIO();
        }
    }

    public abstract void broadcast(float f2, Vector4f vector4f);

    public abstract void broadcast(int i2, Vector4i vector4i);

    public abstract void copy(Matrix3f matrix3f, Matrix3f matrix3f2);

    public abstract void copy(Matrix3f matrix3f, Matrix4f matrix4f);

    public abstract void copy(Matrix3f matrix3f, Matrix4x3f matrix4x3f);

    public abstract void copy(Matrix3f matrix3f, float[] fArr, int i2);

    public abstract void copy(Matrix3x2d matrix3x2d, Matrix3x2d matrix3x2d2);

    public abstract void copy(Matrix3x2d matrix3x2d, double[] dArr, int i2);

    public abstract void copy(Matrix3x2f matrix3x2f, Matrix3x2f matrix3x2f2);

    public abstract void copy(Matrix3x2f matrix3x2f, float[] fArr, int i2);

    public abstract void copy(Matrix4f matrix4f, Matrix3f matrix3f);

    public abstract void copy(Matrix4f matrix4f, Matrix4f matrix4f2);

    public abstract void copy(Matrix4f matrix4f, Matrix4x3f matrix4x3f);

    public abstract void copy(Matrix4f matrix4f, float[] fArr, int i2);

    public abstract void copy(Matrix4x3f matrix4x3f, Matrix4f matrix4f);

    public abstract void copy(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2);

    public abstract void copy(Matrix4x3f matrix4x3f, float[] fArr, int i2);

    public abstract void copy(Quaternionf quaternionf, Quaternionf quaternionf2);

    public abstract void copy(Vector4f vector4f, Vector4f vector4f2);

    public abstract void copy(Vector4i vector4i, Vector4i vector4i2);

    public abstract void copy(double[] dArr, int i2, Matrix3x2d matrix3x2d);

    public abstract void copy(float[] fArr, int i2, Matrix3f matrix3f);

    public abstract void copy(float[] fArr, int i2, Matrix3x2f matrix3x2f);

    public abstract void copy(float[] fArr, int i2, Matrix4f matrix4f);

    public abstract void copy(float[] fArr, int i2, Matrix4x3f matrix4x3f);

    public abstract void copy3x3(Matrix3f matrix3f, Matrix4f matrix4f);

    public abstract void copy3x3(Matrix3f matrix3f, Matrix4x3f matrix4x3f);

    public abstract void copy3x3(Matrix3x2d matrix3x2d, double[] dArr, int i2);

    public abstract void copy3x3(Matrix3x2f matrix3x2f, float[] fArr, int i2);

    public abstract void copy3x3(Matrix4f matrix4f, Matrix4f matrix4f2);

    public abstract void copy3x3(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2);

    public abstract void copy4x3(Matrix4f matrix4f, Matrix4f matrix4f2);

    public abstract void copy4x3(Matrix4x3f matrix4x3f, Matrix4f matrix4f);

    public abstract void copy4x4(Matrix3x2d matrix3x2d, double[] dArr, int i2);

    public abstract void copy4x4(Matrix3x2f matrix3x2f, float[] fArr, int i2);

    public abstract void copy4x4(Matrix4x3d matrix4x3d, double[] dArr, int i2);

    public abstract void copy4x4(Matrix4x3d matrix4x3d, float[] fArr, int i2);

    public abstract void copy4x4(Matrix4x3f matrix4x3f, float[] fArr, int i2);

    public abstract void get(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix3d matrix3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Vector2d vector2d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector2d vector2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Vector2f vector2f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector2f vector2f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Vector2i vector2i, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector2i vector2i, int i2, IntBuffer intBuffer);

    public abstract void get(Vector3d vector3d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector3d vector3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Vector3f vector3f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector3f vector3f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Vector3i vector3i, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector3i vector3i, int i2, IntBuffer intBuffer);

    public abstract void get(Vector4d vector4d, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector4d vector4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void get(Vector4f vector4f, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector4f vector4f, int i2, FloatBuffer floatBuffer);

    public abstract void get(Vector4i vector4i, int i2, ByteBuffer byteBuffer);

    public abstract void get(Vector4i vector4i, int i2, IntBuffer intBuffer);

    public abstract void getColumn0(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void getColumn1(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void getColumn2(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void getColumn3(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void getf(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer);

    public abstract void getf(Matrix3d matrix3d, int i2, FloatBuffer floatBuffer);

    public abstract void getf(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void getf(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer);

    public abstract void getf(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void getf(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer);

    public abstract void identity(Matrix3f matrix3f);

    public abstract void identity(Matrix3x2d matrix3x2d);

    public abstract void identity(Matrix3x2f matrix3x2f);

    public abstract void identity(Matrix4f matrix4f);

    public abstract void identity(Matrix4x3f matrix4x3f);

    public abstract void identity(Quaternionf quaternionf);

    public abstract void put(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix3d matrix3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Vector2d vector2d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector2d vector2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Vector2f vector2f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector2f vector2f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Vector2i vector2i, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector2i vector2i, int i2, IntBuffer intBuffer);

    public abstract void put(Vector3d vector3d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector3d vector3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Vector3f vector3f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector3f vector3f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Vector3i vector3i, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector3i vector3i, int i2, IntBuffer intBuffer);

    public abstract void put(Vector4d vector4d, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector4d vector4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put(Vector4f vector4f, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector4f vector4f, int i2, FloatBuffer floatBuffer);

    public abstract void put(Vector4i vector4i, int i2, ByteBuffer byteBuffer);

    public abstract void put(Vector4i vector4i, int i2, IntBuffer intBuffer);

    public abstract void put3x3(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer);

    public abstract void put3x3(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put3x3(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer);

    public abstract void put3x3(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer);

    public abstract void put4x3(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer);

    public abstract void put4x3(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer);

    public abstract void put4x3Transposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void put4x3Transposed(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put4x3Transposed(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer);

    public abstract void put4x3Transposed(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer);

    public abstract void put4x4(Matrix3x2d matrix3x2d, int i2, ByteBuffer byteBuffer);

    public abstract void put4x4(Matrix3x2d matrix3x2d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put4x4(Matrix3x2f matrix3x2f, int i2, ByteBuffer byteBuffer);

    public abstract void put4x4(Matrix3x2f matrix3x2f, int i2, FloatBuffer floatBuffer);

    public abstract void put4x4(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void put4x4(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void put4x4(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer);

    public abstract void put4x4(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer);

    public abstract void putColumn0(Matrix4f matrix4f, Vector3f vector3f);

    public abstract void putColumn0(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void putColumn1(Matrix4f matrix4f, Vector3f vector3f);

    public abstract void putColumn1(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void putColumn2(Matrix4f matrix4f, Vector3f vector3f);

    public abstract void putColumn2(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void putColumn3(Matrix4f matrix4f, Vector3f vector3f);

    public abstract void putColumn3(Matrix4f matrix4f, Vector4f vector4f);

    public abstract void putMatrix3f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer);

    public abstract void putMatrix3f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer);

    public abstract void putMatrix4f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer);

    public abstract void putMatrix4f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer);

    public abstract void putMatrix4x3f(Quaternionf quaternionf, int i2, ByteBuffer byteBuffer);

    public abstract void putMatrix4x3f(Quaternionf quaternionf, int i2, FloatBuffer floatBuffer);

    public abstract void putTransposed(Matrix3f matrix3f, int i2, ByteBuffer byteBuffer);

    public abstract void putTransposed(Matrix3f matrix3f, int i2, FloatBuffer floatBuffer);

    public abstract void putTransposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void putTransposed(Matrix4d matrix4d, int i2, DoubleBuffer doubleBuffer);

    public abstract void putTransposed(Matrix4f matrix4f, int i2, ByteBuffer byteBuffer);

    public abstract void putTransposed(Matrix4f matrix4f, int i2, FloatBuffer floatBuffer);

    public abstract void putTransposed(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void putTransposed(Matrix4x3d matrix4x3d, int i2, DoubleBuffer doubleBuffer);

    public abstract void putTransposed(Matrix4x3f matrix4x3f, int i2, ByteBuffer byteBuffer);

    public abstract void putTransposed(Matrix4x3f matrix4x3f, int i2, FloatBuffer floatBuffer);

    public abstract void putf(Matrix3d matrix3d, int i2, ByteBuffer byteBuffer);

    public abstract void putf(Matrix3d matrix3d, int i2, FloatBuffer floatBuffer);

    public abstract void putf(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void putf(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer);

    public abstract void putf(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void putf(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer);

    public abstract void putfTransposed(Matrix4d matrix4d, int i2, ByteBuffer byteBuffer);

    public abstract void putfTransposed(Matrix4d matrix4d, int i2, FloatBuffer floatBuffer);

    public abstract void putfTransposed(Matrix4x3d matrix4x3d, int i2, ByteBuffer byteBuffer);

    public abstract void putfTransposed(Matrix4x3d matrix4x3d, int i2, FloatBuffer floatBuffer);

    public abstract void set(Matrix3f matrix3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3);

    public abstract void set(Matrix4f matrix4f, Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3, Vector4f vector4f4);

    public abstract void set(Matrix4x3f matrix4x3f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4);

    public abstract void swap(Matrix3f matrix3f, Matrix3f matrix3f2);

    public abstract void swap(Matrix4f matrix4f, Matrix4f matrix4f2);

    public abstract void swap(Matrix4x3f matrix4x3f, Matrix4x3f matrix4x3f2);

    public abstract void zero(Matrix3f matrix3f);

    public abstract void zero(Matrix3x2d matrix3x2d);

    public abstract void zero(Matrix3x2f matrix3x2f);

    public abstract void zero(Matrix4f matrix4f);

    public abstract void zero(Matrix4x3f matrix4x3f);

    public abstract void zero(Vector4f vector4f);

    public abstract void zero(Vector4i vector4i);
}
