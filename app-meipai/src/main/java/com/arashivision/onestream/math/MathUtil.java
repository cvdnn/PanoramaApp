package com.arashivision.onestream.math;

public class MathUtil {
    public static final double HALF_PI = 1.5707963267948966d;
    public static final double PI = 3.141592653589793d;
    public static final int PRECISION = 131072;
    public static final double PRECISION_DIV_2PI = 20860.756700940907d;
    public static final int PRECISION_S = 131071;
    public static final double PRE_180_DIV_PI = 57.29577951308232d;
    public static final double PRE_PI_DIV_180 = 0.017453292519943295d;
    public static final double RAD_SLICE = 4.7936899621426287E-5d;
    public static final double TWO_PI = 6.283185307179586d;
    public static boolean isInitialized = initialize();
    public static double[] sinTable = new double[131072];
    public static double[] tanTable = new double[131072];

    public static double clamp(double d2, double d3, double d4) {
        return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
    }

    public static int clamp(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static short clamp(short s, short s2, short s3) {
        return s < s2 ? s2 : s > s3 ? s3 : s;
    }

    public static double cos(double d2) {
        return sinTable[radToIndex(1.5707963267948966d - d2)];
    }

    public static double degreesToRadians(double d2) {
        return d2 * 0.017453292519943295d;
    }

    public static int getClosestPowerOfTwo(int i2) {
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >> 1);
        int i5 = i4 | (i4 >> 2);
        int i6 = i5 | (i5 >> 4);
        int i7 = i6 | (i6 >> 8);
        return (i7 | (i7 >> 16)) + 1;
    }

    public static boolean initialize() {
        for (int i2 = 0; i2 < 131072; i2++) {
            double d2 = ((double) i2) * 4.7936899621426287E-5d;
            sinTable[i2] = Math.sin(d2);
            tanTable[i2] = Math.tan(d2);
        }
        return true;
    }

    public static int radToIndex(double d2) {
        return ((int) (d2 * 20860.756700940907d)) & PRECISION_S;
    }

    public static double radiansToDegrees(double d2) {
        return d2 * 57.29577951308232d;
    }

    public static boolean realEqual(double d2, double d3, double d4) {
        return Math.abs(d3 - d2) <= d4;
    }

    public static double sin(double d2) {
        return sinTable[radToIndex(d2)];
    }

    public static double tan(double d2) {
        return tanTable[radToIndex(d2)];
    }
}
