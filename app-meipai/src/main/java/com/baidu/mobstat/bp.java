package com.baidu.mobstat;

import com.facebook.stetho.dumpapp.Framer;
import java.io.UnsupportedEncodingException;

public final class bp {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f1761a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    public static String b(byte[] bArr) throws UnsupportedEncodingException {
        return a(bArr, "utf-8");
    }

    public static byte[] a(byte[] bArr, int i2) {
        byte b2;
        int i3;
        int i4 = (i2 / 4) * 3;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i4];
        int i5 = i2;
        int i6 = 0;
        while (true) {
            byte b3 = bArr[i5 - 1];
            b2 = 10;
            if (!(b3 == 10 || b3 == 13 || b3 == 32 || b3 == 9)) {
                if (b3 != 61) {
                    break;
                }
                i6++;
            }
            i5--;
        }
        int i7 = 0;
        byte b4 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i5) {
            byte b5 = bArr[i7];
            if (!(b5 == b2 || b5 == 13 || b5 == 32 || b5 == 9)) {
                if (b5 >= 65 && b5 <= 90) {
                    i3 = b5 - 65;
                } else if (b5 >= 97 && b5 <= 122) {
                    i3 = b5 - 71;
                } else if (b5 >= 48 && b5 <= 57) {
                    i3 = b5 + 4;
                } else if (b5 == 43) {
                    i3 = 62;
                } else if (b5 != 47) {
                    return null;
                } else {
                    i3 = 63;
                }
                b4 = ((byte) i3) | (b4 << 6);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr2[i8] = (byte) ((16711680 & b4) >> 16);
                    int i11 = i10 + 1;
                    bArr2[i10] = (byte) ((65280 & b4) >> 8);
                    int i12 = i11 + 1;
                    bArr2[i11] = (byte) (b4 & 255);
                    i8 = i12;
                }
                i9++;
            }
            i7++;
            b2 = 10;
        }
        if (i6 > 0) {
            int i13 = b4 << (i6 * 6);
            int i14 = i8 + 1;
            bArr2[i8] = (byte) ((i13 & 16711680) >> 16);
            if (i6 == 1) {
                i8 = i14 + 1;
                bArr2[i14] = (byte) ((i13 & 65280) >> 8);
            } else {
                i8 = i14;
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[((length / 76) + 3 + length)];
        int length2 = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4 += 3) {
            int i5 = i2 + 1;
            byte[] bArr3 = f1761a;
            bArr2[i2] = bArr3[(bArr[i4] & 255) >> 2];
            int i6 = i5 + 1;
            int i7 = i4 + 1;
            bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
            int i8 = i6 + 1;
            int i9 = i4 + 2;
            bArr2[i6] = bArr3[((bArr[i7] & 15) << 2) | ((bArr[i9] & 255) >> 6)];
            i2 = i8 + 1;
            bArr2[i8] = bArr3[bArr[i9] & 63];
            if ((i2 - i3) % 76 == 0 && i2 != 0) {
                i3++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i10 = i2 + 1;
            byte[] bArr4 = f1761a;
            bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
            int i11 = i10 + 1;
            bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
            int i12 = i11 + 1;
            bArr2[i11] = 61;
            i2 = i12 + 1;
            bArr2[i12] = 61;
        } else if (length3 == 2) {
            int i13 = i2 + 1;
            byte[] bArr5 = f1761a;
            bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
            int i14 = i13 + 1;
            int i15 = (bArr[length2] & 3) << 4;
            int i16 = length2 + 1;
            bArr2[i13] = bArr5[((bArr[i16] & 255) >> 4) | i15];
            int i17 = i14 + 1;
            bArr2[i14] = bArr5[(bArr[i16] & 15) << 2];
            i2 = i17 + 1;
            bArr2[i17] = 61;
        }
        return new String(bArr2, 0, i2, str);
    }
}
