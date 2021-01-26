package com.arashivision.camera.stream;

import com.baidu.sapi2.utils.SapiDataEncryptor;

public class NumberUtil {
    public static final char[] hexArray = SapiDataEncryptor.f3003a.toCharArray();

    public static double bytes2Double(byte[] bArr, int i2) {
        long j2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j2 |= ((long) (bArr[i3 + i2] & 255)) << (i3 * 8);
        }
        return Double.longBitsToDouble(j2);
    }

    public static String bytesToHex(byte[] bArr, int i2, int i3) {
        if (i2 + i3 > bArr.length) {
            i3 = bArr.length - i2;
        }
        char[] cArr = new char[(i3 * 2)];
        for (int i4 = 0; i4 < i3; i4++) {
            byte b2 = bArr[i4 + i2] & 255;
            int i5 = i4 * 2;
            char[] cArr2 = hexArray;
            cArr[i5] = cArr2[b2 >>> 4];
            cArr[i5 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
