package com.arashivision.insbase.joml;

import com.facebook.stetho.dumpapp.Framer;

public class SimplexNoise {
    public static final float F2 = 0.36602542f;
    public static final float F3 = 0.33333334f;
    public static final float F4 = 0.309017f;
    public static final float G2 = 0.21132487f;
    public static final float G3 = 0.16666667f;
    public static final float G4 = 0.1381966f;
    public static final Vector3b[] grad3 = {new Vector3b(1, 1, 0), new Vector3b(-1, 1, 0), new Vector3b(1, -1, 0), new Vector3b(-1, -1, 0), new Vector3b(1, 0, 1), new Vector3b(-1, 0, 1), new Vector3b(1, 0, -1), new Vector3b(-1, 0, -1), new Vector3b(0, 1, 1), new Vector3b(0, -1, 1), new Vector3b(0, 1, -1), new Vector3b(0, -1, -1)};
    public static final Vector4b[] grad4 = {new Vector4b(0, 1, 1, 1), new Vector4b(0, 1, 1, -1), new Vector4b(0, 1, -1, 1), new Vector4b(0, 1, -1, -1), new Vector4b(0, -1, 1, 1), new Vector4b(0, -1, 1, -1), new Vector4b(0, -1, -1, 1), new Vector4b(0, -1, -1, -1), new Vector4b(1, 0, 1, 1), new Vector4b(1, 0, 1, -1), new Vector4b(1, 0, -1, 1), new Vector4b(1, 0, -1, -1), new Vector4b(-1, 0, 1, 1), new Vector4b(-1, 0, 1, -1), new Vector4b(-1, 0, -1, 1), new Vector4b(-1, 0, -1, -1), new Vector4b(1, 1, 0, 1), new Vector4b(1, 1, 0, -1), new Vector4b(1, -1, 0, 1), new Vector4b(1, -1, 0, -1), new Vector4b(-1, 1, 0, 1), new Vector4b(-1, 1, 0, -1), new Vector4b(-1, -1, 0, 1), new Vector4b(-1, -1, 0, -1), new Vector4b(1, 1, 1, 0), new Vector4b(1, 1, -1, 0), new Vector4b(1, -1, 1, 0), new Vector4b(1, -1, -1, 0), new Vector4b(-1, 1, 1, 0), new Vector4b(-1, 1, -1, 0), new Vector4b(-1, -1, 1, 0), new Vector4b(-1, -1, -1, 0)};
    public static final byte[] p = {-105, -96, -119, 91, 90, 15, -125, 13, -55, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 53, -62, -23, 7, -31, -116, 36, 103, 30, 69, -114, 8, 99, 37, -16, 21, 10, 23, -66, 6, -108, -9, Framer.EXIT_FRAME_PREFIX, -22, 75, 0, 26, -59, 62, 94, -4, -37, -53, 117, 35, 11, 32, 57, -79, Framer.ENTER_FRAME_PREFIX, 88, -19, -107, 56, 87, -82, 20, 125, -120, -85, -88, 68, -81, 74, -91, 71, -122, -117, 48, 27, -90, 77, -110, -98, -25, 83, 111, -27, 122, 60, -45, -123, -26, -36, 105, 92, 41, 55, 46, -11, 40, -12, 102, -113, 54, 65, 25, 63, -95, 1, -40, 80, 73, -47, 76, -124, -69, -48, 89, 18, -87, -56, -60, -121, -126, 116, -68, -97, 86, -92, 100, 109, -58, -83, -70, 3, 64, 52, -39, -30, -6, 124, 123, 5, -54, 38, -109, 118, 126, -1, 82, 85, -44, -49, -50, 59, -29, 47, 16, 58, 17, -74, -67, 28, 42, -33, -73, -86, -43, 119, -8, -104, 2, 44, -102, -93, 70, -35, -103, 101, -101, -89, 43, -84, 9, -127, 22, 39, -3, 19, 98, 108, 110, 79, 113, -32, -24, -78, -71, 112, 104, -38, -10, 97, -28, -5, 34, -14, -63, -18, -46, -112, 12, -65, -77, -94, -15, 81, 51, -111, -21, -7, 14, -17, 107, Framer.STDOUT_FRAME_PREFIX, -64, -42, 31, -75, -57, 106, -99, -72, 84, -52, -80, 115, 121, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Byte.MAX_VALUE, 4, -106, -2, -118, -20, -51, 93, -34, 114, 67, 29, 24, 72, -13, -115, Byte.MIN_VALUE, -61, 78, 66, -41, 61, -100, -76};
    public static final byte[] perm = new byte[512];
    public static final byte[] permMod12 = new byte[512];

    public static class Vector3b {
        public byte x;
        public byte y;
        public byte z;

        public Vector3b(int i2, int i3, int i4) {
            this.x = (byte) i2;
            this.y = (byte) i3;
            this.z = (byte) i4;
        }
    }

    public static class Vector4b {
        public byte w;
        public byte x;
        public byte y;
        public byte z;

        public Vector4b(int i2, int i3, int i4, int i5) {
            this.x = (byte) i2;
            this.y = (byte) i3;
            this.z = (byte) i4;
            this.w = (byte) i5;
        }
    }

    static {
        for (int i2 = 0; i2 < 512; i2++) {
            byte[] bArr = perm;
            bArr[i2] = p[i2 & 255];
            permMod12[i2] = (byte) ((bArr[i2] & 255) % 12);
        }
    }

    public static float dot(Vector3b vector3b, float f2, float f3) {
        return (((float) vector3b.y) * f3) + (((float) vector3b.x) * f2);
    }

    public static int fastfloor(float f2) {
        int i2 = (int) f2;
        return f2 < ((float) i2) ? i2 - 1 : i2;
    }

    public static float noise(float f2, float f3) {
        int i2;
        float f4;
        float f5;
        float f6 = (f2 + f3) * 0.36602542f;
        int fastfloor = fastfloor(f2 + f6);
        int fastfloor2 = fastfloor(f6 + f3);
        float f7 = ((float) (fastfloor + fastfloor2)) * 0.21132487f;
        float f8 = f2 - (((float) fastfloor) - f7);
        float f9 = f3 - (((float) fastfloor2) - f7);
        byte b2 = 0;
        if (f8 > f9) {
            i2 = 0;
            b2 = 1;
        } else {
            i2 = 1;
        }
        float f10 = (f8 - ((float) b2)) + 0.21132487f;
        float f11 = (f9 - ((float) i2)) + 0.21132487f;
        float f12 = (f8 - 1.0f) + 0.42264974f;
        float f13 = (f9 - 1.0f) + 0.42264974f;
        byte b3 = fastfloor & 255;
        int i3 = fastfloor2 & 255;
        byte[] bArr = permMod12;
        byte[] bArr2 = perm;
        byte b4 = bArr[(bArr2[i3] + b3) & 255] & 255;
        byte b5 = bArr[(b2 + b3 + bArr2[i2 + i3]) & 255] & 255;
        byte b6 = bArr[(b3 + 1 + bArr2[i3 + 1]) & 255] & 255;
        float f14 = (0.5f - (f8 * f8)) - (f9 * f9);
        float f15 = 0.0f;
        if (f14 < 0.0f) {
            f4 = 0.0f;
        } else {
            float f16 = f14 * f14;
            f4 = dot(grad3[b4], f8, f9) * f16 * f16;
        }
        float f17 = (0.5f - (f10 * f10)) - (f11 * f11);
        if (f17 < 0.0f) {
            f5 = 0.0f;
        } else {
            float f18 = f17 * f17;
            f5 = dot(grad3[b5], f10, f11) * f18 * f18;
        }
        float f19 = (0.5f - (f12 * f12)) - (f13 * f13);
        if (f19 >= 0.0f) {
            float f20 = f19 * f19;
            f15 = dot(grad3[b6], f12, f13) * f20 * f20;
        }
        return (f4 + f5 + f15) * 70.0f;
    }

    public static float dot(Vector3b vector3b, float f2, float f3, float f4) {
        return (((float) vector3b.z) * f4) + (((float) vector3b.y) * f3) + (((float) vector3b.x) * f2);
    }

    public static float dot(Vector4b vector4b, float f2, float f3, float f4, float f5) {
        return (((float) vector4b.w) * f5) + (((float) vector4b.z) * f4) + (((float) vector4b.y) * f3) + (((float) vector4b.x) * f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float noise(float r23, float r24, float r25) {
        /*
            float r0 = r23 + r24
            float r0 = r0 + r25
            r1 = 1051372203(0x3eaaaaab, float:0.33333334)
            float r0 = r0 * r1
            float r2 = r23 + r0
            int r2 = fastfloor(r2)
            float r3 = r24 + r0
            int r3 = fastfloor(r3)
            float r0 = r25 + r0
            int r0 = fastfloor(r0)
            int r4 = r2 + r3
            int r4 = r4 + r0
            float r4 = (float) r4
            r5 = 1042983595(0x3e2aaaab, float:0.16666667)
            float r4 = r4 * r5
            float r6 = (float) r2
            float r6 = r6 - r4
            float r7 = (float) r3
            float r7 = r7 - r4
            float r8 = (float) r0
            float r8 = r8 - r4
            float r4 = r23 - r6
            float r6 = r24 - r7
            float r7 = r25 - r8
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r9 = 0
            if (r8 < 0) goto L_0x004c
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x003e
            r8 = r9
            r11 = r8
            r14 = r11
            r9 = 1
        L_0x003b:
            r12 = 1
            r13 = 1
            goto L_0x0062
        L_0x003e:
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x0047
            r8 = r9
            r11 = r8
            r13 = r11
            r9 = 1
            goto L_0x004a
        L_0x0047:
            r8 = r9
            r13 = r8
            r11 = 1
        L_0x004a:
            r12 = 1
            goto L_0x0054
        L_0x004c:
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x0056
            r8 = r9
            r12 = r8
            r11 = 1
        L_0x0053:
            r13 = 1
        L_0x0054:
            r14 = 1
            goto L_0x0062
        L_0x0056:
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x005e
            r11 = r9
            r12 = r11
            r8 = 1
            goto L_0x0053
        L_0x005e:
            r11 = r9
            r14 = r11
            r8 = 1
            goto L_0x003b
        L_0x0062:
            float r15 = (float) r9
            float r15 = r4 - r15
            float r15 = r15 + r5
            float r10 = (float) r8
            float r10 = r6 - r10
            float r10 = r10 + r5
            float r1 = (float) r11
            float r1 = r7 - r1
            float r1 = r1 + r5
            float r5 = (float) r12
            float r5 = r4 - r5
            r16 = 1051372203(0x3eaaaaab, float:0.33333334)
            float r5 = r5 + r16
            r24 = r5
            float r5 = (float) r13
            float r5 = r6 - r5
            float r5 = r5 + r16
            r25 = r5
            float r5 = (float) r14
            float r5 = r7 - r5
            float r5 = r5 + r16
            r16 = 1065353216(0x3f800000, float:1.0)
            float r17 = r4 - r16
            r18 = 1056964608(0x3f000000, float:0.5)
            r19 = r5
            float r5 = r17 + r18
            float r17 = r6 - r16
            r20 = r5
            float r5 = r17 + r18
            float r16 = r7 - r16
            r17 = r5
            float r5 = r16 + r18
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = r3 & 255(0xff, float:3.57E-43)
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte[] r16 = permMod12
            byte[] r18 = perm
            byte r21 = r18[r0]
            r22 = r5
            int r5 = r3 + r21
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r18[r5]
            int r5 = r5 + r2
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r16[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r9 = r9 + r2
            int r8 = r8 + r3
            int r11 = r11 + r0
            byte r11 = r18[r11]
            int r8 = r8 + r11
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r18[r8]
            int r9 = r9 + r8
            r8 = r9 & 255(0xff, float:3.57E-43)
            byte r8 = r16[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r12 = r12 + r2
            int r13 = r13 + r3
            int r14 = r14 + r0
            byte r9 = r18[r14]
            int r13 = r13 + r9
            r9 = r13 & 255(0xff, float:3.57E-43)
            byte r9 = r18[r9]
            int r12 = r12 + r9
            r9 = r12 & 255(0xff, float:3.57E-43)
            byte r9 = r16[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r11 = 1
            int r2 = r2 + r11
            int r3 = r3 + r11
            int r0 = r0 + r11
            byte r0 = r18[r0]
            int r3 = r3 + r0
            r0 = r3 & 255(0xff, float:3.57E-43)
            byte r0 = r18[r0]
            int r2 = r2 + r0
            r0 = r2 & 255(0xff, float:3.57E-43)
            byte r0 = r16[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            float r2 = r4 * r4
            r3 = 1058642330(0x3f19999a, float:0.6)
            float r2 = r3 - r2
            float r11 = r6 * r6
            float r2 = r2 - r11
            float r11 = r7 * r7
            float r2 = r2 - r11
            r11 = 0
            int r12 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r12 >= 0) goto L_0x00fd
            r4 = r11
            goto L_0x0108
        L_0x00fd:
            float r2 = r2 * r2
            float r2 = r2 * r2
            com.arashivision.insbase.joml.SimplexNoise$Vector3b[] r12 = grad3
            r5 = r12[r5]
            float r4 = dot(r5, r4, r6, r7)
            float r4 = r4 * r2
        L_0x0108:
            float r2 = r15 * r15
            float r2 = r3 - r2
            float r5 = r10 * r10
            float r2 = r2 - r5
            float r5 = r1 * r1
            float r2 = r2 - r5
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0118
            r1 = r11
            goto L_0x0123
        L_0x0118:
            float r2 = r2 * r2
            float r2 = r2 * r2
            com.arashivision.insbase.joml.SimplexNoise$Vector3b[] r5 = grad3
            r5 = r5[r8]
            float r1 = dot(r5, r15, r10, r1)
            float r1 = r1 * r2
        L_0x0123:
            float r5 = r24 * r24
            float r2 = r3 - r5
            float r5 = r25 * r25
            float r2 = r2 - r5
            float r5 = r19 * r19
            float r2 = r2 - r5
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0133
            r5 = r11
            goto L_0x0144
        L_0x0133:
            float r2 = r2 * r2
            float r2 = r2 * r2
            com.arashivision.insbase.joml.SimplexNoise$Vector3b[] r5 = grad3
            r5 = r5[r9]
            r6 = r24
            r7 = r25
            r8 = r19
            float r5 = dot(r5, r6, r7, r8)
            float r5 = r5 * r2
        L_0x0144:
            float r2 = r20 * r20
            float r3 = r3 - r2
            float r2 = r17 * r17
            float r3 = r3 - r2
            float r2 = r22 * r22
            float r3 = r3 - r2
            int r2 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0152
            goto L_0x0164
        L_0x0152:
            float r3 = r3 * r3
            float r3 = r3 * r3
            com.arashivision.insbase.joml.SimplexNoise$Vector3b[] r2 = grad3
            r0 = r2[r0]
            r6 = r17
            r2 = r20
            r7 = r22
            float r0 = dot(r0, r2, r6, r7)
            float r11 = r0 * r3
        L_0x0164:
            r0 = 1107296256(0x42000000, float:32.0)
            float r4 = r4 + r1
            float r4 = r4 + r5
            float r4 = r4 + r11
            float r4 = r4 * r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.SimplexNoise.noise(float, float, float):float");
    }

    public static float noise(float f2, float f3, float f4, float f5) {
        int i2;
        int i3;
        int i4;
        int i5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = (f2 + f3 + f4 + f5) * 0.309017f;
        int fastfloor = fastfloor(f2 + f10);
        int fastfloor2 = fastfloor(f3 + f10);
        int fastfloor3 = fastfloor(f4 + f10);
        int fastfloor4 = fastfloor(f5 + f10);
        float f11 = ((float) (fastfloor + fastfloor2 + fastfloor3 + fastfloor4)) * 0.1381966f;
        float f12 = ((float) fastfloor2) - f11;
        float f13 = ((float) fastfloor3) - f11;
        float f14 = ((float) fastfloor4) - f11;
        float f15 = f2 - (((float) fastfloor) - f11);
        float f16 = f3 - f12;
        float f17 = f4 - f13;
        float f18 = f5 - f14;
        if (f15 > f16) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (f15 > f17) {
            i3++;
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (f15 > f18) {
            i3++;
            i5 = 0;
        } else {
            i5 = 1;
        }
        if (f16 > f17) {
            i2++;
        } else {
            i4++;
        }
        if (f16 > f18) {
            i2++;
        } else {
            i5++;
        }
        if (f17 > f18) {
            i4++;
        } else {
            i5++;
        }
        byte b2 = i3 >= 3 ? (byte) 1 : 0;
        byte b3 = i2 >= 3 ? (byte) 1 : 0;
        byte b4 = i4 >= 3 ? (byte) 1 : 0;
        int i6 = i5 >= 3 ? 1 : 0;
        byte b5 = i3 >= 2 ? (byte) 1 : 0;
        byte b6 = i2 >= 2 ? (byte) 1 : 0;
        byte b7 = i4 >= 2 ? (byte) 1 : 0;
        int i7 = i5 >= 2 ? 1 : 0;
        byte b8 = i3 >= 1 ? (byte) 1 : 0;
        byte b9 = i2 >= 1 ? (byte) 1 : 0;
        byte b10 = i4 >= 1 ? (byte) 1 : 0;
        int i8 = i5 >= 1 ? 1 : 0;
        float f19 = (f15 - ((float) b2)) + 0.1381966f;
        byte b11 = b3;
        byte b12 = b2;
        float f20 = (f16 - ((float) b11)) + 0.1381966f;
        byte b13 = b4;
        byte b14 = b11;
        float f21 = (f17 - ((float) b13)) + 0.1381966f;
        float f22 = (f18 - ((float) i6)) + 0.1381966f;
        byte b15 = b5;
        int i9 = i6;
        float f23 = (f15 - ((float) b15)) + 0.2763932f;
        byte b16 = b6;
        byte b17 = b15;
        float f24 = (f16 - ((float) b16)) + 0.2763932f;
        byte b18 = b7;
        byte b19 = b16;
        float f25 = (f17 - ((float) b18)) + 0.2763932f;
        float f26 = (f18 - ((float) i7)) + 0.2763932f;
        float f27 = (f15 - ((float) b8)) + 0.41458982f;
        float f28 = (f16 - ((float) b9)) + 0.41458982f;
        float f29 = (f17 - ((float) b10)) + 0.41458982f;
        float f30 = (f18 - ((float) i8)) + 0.41458982f;
        float f31 = (f15 - 1.0f) + 0.5527864f;
        float f32 = (f16 - 1.0f) + 0.5527864f;
        float f33 = (f17 - 1.0f) + 0.5527864f;
        float f34 = (f18 - 1.0f) + 0.5527864f;
        byte b20 = fastfloor & 255;
        byte b21 = fastfloor2 & 255;
        byte b22 = fastfloor3 & 255;
        int i10 = fastfloor4 & 255;
        byte[] bArr = perm;
        float f35 = f34;
        int i11 = (bArr[(bArr[(bArr[(b22 + bArr[i10]) & 255] + b21) & 255] + b20) & 255] & 255) % 32;
        int i12 = (bArr[((b20 + b12) + bArr[((b21 + b14) + bArr[((b13 + b22) + bArr[i10 + i9]) & 255]) & 255]) & 255] & 255) % 32;
        int i13 = (bArr[((b20 + b17) + bArr[((b21 + b19) + bArr[((b22 + b18) + bArr[i7 + i10]) & 255]) & 255]) & 255] & 255) % 32;
        int i14 = (bArr[((b8 + b20) + bArr[((b9 + b21) + bArr[((b10 + b22) + bArr[i8 + i10]) & 255]) & 255]) & 255] & 255) % 32;
        int i15 = (bArr[((b20 + 1) + bArr[((b21 + 1) + bArr[((b22 + 1) + bArr[i10 + 1]) & 255]) & 255]) & 255] & 255) % 32;
        float f36 = (((0.6f - (f15 * f15)) - (f16 * f16)) - (f17 * f17)) - (f18 * f18);
        float f37 = 0.0f;
        if (f36 < 0.0f) {
            f6 = 0.0f;
        } else {
            float f38 = f36 * f36;
            f6 = dot(grad4[i11], f15, f16, f17, f18) * f38 * f38;
        }
        float f39 = (((0.6f - (f19 * f19)) - (f20 * f20)) - (f21 * f21)) - (f22 * f22);
        if (f39 < 0.0f) {
            f7 = 0.0f;
        } else {
            float f40 = f39 * f39;
            f7 = dot(grad4[i12], f19, f20, f21, f22) * f40 * f40;
        }
        float f41 = (((0.6f - (f23 * f23)) - (f24 * f24)) - (f25 * f25)) - (f26 * f26);
        if (f41 < 0.0f) {
            f8 = 0.0f;
        } else {
            float f42 = f41 * f41;
            f8 = dot(grad4[i13], f23, f24, f25, f26) * f42 * f42;
        }
        float f43 = (((0.6f - (f27 * f27)) - (f28 * f28)) - (f29 * f29)) - (f30 * f30);
        if (f43 < 0.0f) {
            f9 = 0.0f;
        } else {
            float f44 = f43 * f43;
            f9 = dot(grad4[i14], f27, f28, f29, f30) * f44 * f44;
        }
        float f45 = (((0.6f - (f31 * f31)) - (f32 * f32)) - (f33 * f33)) - (f35 * f35);
        if (f45 >= 0.0f) {
            float f46 = f45 * f45;
            f37 = dot(grad4[i15], f31, f32, f33, f35) * f46 * f46;
        }
        return (f6 + f7 + f8 + f9 + f37) * 27.0f;
    }
}
