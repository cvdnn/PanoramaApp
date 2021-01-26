package com.arashivision.arvbmg.hdr;

import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class Hdr {

    public static final class HDRData {
        public byte[] mByteData;
        public int mHeight;
        public int mWidth;

        public byte[] getByteData() {
            return this.mByteData;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public void setByteData(byte[] bArr) {
            this.mByteData = bArr;
        }

        public void setHeight(int i2) {
            this.mHeight = i2;
        }

        public void setWidth(int i2) {
            this.mWidth = i2;
        }
    }

    public static final class HDRDataType {
        public static final int TYPE_RGB = 1;
    }

    public static final class HDR_RESULT {
        public static final int HDR_ERROR_TOO_MOVE = 10;
        public static final int HDR_ERROR_TOO_SHAKE = 11;
        public static final int HDR_OK = 0;
        public static final int HDR_RESIZE_OK = 1;
        public static final int HDR_WRITE_FILE_ERROR = 12;
    }

    public static class HdrEffectLevel {
        public static final int NORMAL = 0;
        public static final int SOFT = 1;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public static int doHdr(String[] strArr, String str, String str2) {
        return nativeHdr(strArr, str, str2);
    }

    public static boolean doSingleHdr(String str, String str2, float f2, int i2) {
        return nativeSingleHdr(str, str2, f2, i2);
    }

    public static boolean hdrDenoise(String[] strArr, String str) {
        return nativeHdrDenoise(strArr, str);
    }

    public static native int nativeHdr(String[] strArr, String str, String str2);

    public static native HDRData nativeHdr2(String[] strArr, int i2);

    public static native boolean nativeHdrDenoise(String[] strArr, String str);

    public static native boolean nativeSingleHdr(String str, String str2, float f2, int i2);

    public static HDRData doHdr(String[] strArr, int i2) {
        return nativeHdr2(strArr, i2);
    }
}
