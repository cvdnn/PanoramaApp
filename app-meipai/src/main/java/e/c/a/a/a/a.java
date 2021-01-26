package e.c.a.a.a;

import com.facebook.stetho.dumpapp.Framer;
import java.io.UnsupportedEncodingException;

public final class a {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f5858a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        byte b2;
        int i2;
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        int i3 = (length / 4) * 3;
        int i4 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[i3];
        int i5 = 0;
        while (true) {
            int i6 = length - 1;
            byte b3 = bArr2[i6];
            b2 = 10;
            if (!(b3 == 10 || b3 == 13 || b3 == 32 || b3 == 9)) {
                if (b3 != 61) {
                    break;
                }
                i5++;
            }
            i4 = i4;
            length = i6;
        }
        int i7 = i4;
        byte b4 = i7;
        int i8 = b4;
        int i9 = i8;
        while (i7 < length) {
            byte b5 = bArr2[i7];
            if (!(b5 == b2 || b5 == 13 || b5 == 32 || b5 == 9)) {
                if (b5 >= 65 && b5 <= 90) {
                    i2 = b5 - 65;
                } else if (b5 >= 97 && b5 <= 122) {
                    i2 = b5 - 71;
                } else if (b5 >= 48 && b5 <= 57) {
                    i2 = b5 + 4;
                } else if (b5 == 43) {
                    i2 = 62;
                } else if (b5 != 47) {
                    return null;
                } else {
                    i2 = 63;
                }
                b4 = (b4 << 6) | ((byte) i2);
                if (i9 % 4 == 3) {
                    int i10 = i8 + 1;
                    bArr3[i8] = (byte) ((16711680 & b4) >> 16);
                    int i11 = i10 + 1;
                    bArr3[i10] = (byte) ((65280 & b4) >> 8);
                    int i12 = i11 + 1;
                    bArr3[i11] = (byte) (b4 & 255);
                    i8 = i12;
                }
                i9++;
            }
            i7++;
            b2 = 10;
        }
        if (i5 > 0) {
            int i13 = b4 << (i5 * 6);
            int i14 = i8 + 1;
            bArr3[i8] = (byte) ((i13 & 16711680) >> 16);
            if (i5 == 1) {
                i8 = i14 + 1;
                bArr3[i14] = (byte) ((i13 & 65280) >> 8);
            } else {
                i8 = i14;
            }
        }
        byte[] bArr4 = new byte[i8];
        System.arraycopy(bArr3, 0, bArr4, 0, i8);
        return bArr4;
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[((length / 76) + 3 + length)];
        int length2 = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4 += 3) {
            int i5 = i2 + 1;
            byte[] bArr3 = f5858a;
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
                int i10 = i2 + 1;
                bArr2[i2] = 10;
                i3++;
                i2 = i10;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i11 = i2 + 1;
            byte[] bArr4 = f5858a;
            bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
            int i12 = i11 + 1;
            bArr2[i11] = bArr4[(bArr[length2] & 3) << 4];
            int i13 = i12 + 1;
            bArr2[i12] = 61;
            i2 = i13 + 1;
            bArr2[i13] = 61;
        } else if (length3 == 2) {
            int i14 = i2 + 1;
            byte[] bArr5 = f5858a;
            bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
            int i15 = i14 + 1;
            int i16 = (bArr[length2] & 3) << 4;
            int i17 = length2 + 1;
            bArr2[i14] = bArr5[((bArr[i17] & 255) >> 4) | i16];
            int i18 = i15 + 1;
            bArr2[i15] = bArr5[(bArr[i17] & 15) << 2];
            i2 = i18 + 1;
            bArr2[i18] = 61;
        }
        return new String(bArr2, 0, i2, str);
    }
}
