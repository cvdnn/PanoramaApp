package com.arashivision.onecamera.util;

public class SPSPPSParser {
    public static native int nativeParse(byte[] bArr, int[] iArr, int[] iArr2, float[] fArr);

    public static native int nativeParseH265(byte[] bArr, int[] iArr, int[] iArr2, float[] fArr);

    public static int parse(byte[] bArr, int[] iArr, int[] iArr2, float[] fArr) {
        return nativeParse(bArr, iArr, iArr2, fArr);
    }
}
