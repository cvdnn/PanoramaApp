package com.arashivision.insbase.joml.sampling;

public class Math {
    public static final double PI = 3.141592653589793d;
    public static final double PI2 = 6.283185307179586d;
    public static final double PIHalf = 1.5707963267948966d;
    public static final double PI_INV = 0.3183098861837907d;
    public static final double s1 = Double.longBitsToDouble(4607182418589157889L);
    public static final double s2 = Double.longBitsToDouble(-4628199223918090387L);
    public static final double s3 = Double.longBitsToDouble(4575957211482072852L);
    public static final double s4 = Double.longBitsToDouble(-4671934770969572232L);
    public static final double s5 = Double.longBitsToDouble(4523227044276562163L);

    public static float abs(float f2) {
        return Math.abs(f2);
    }

    public static double acos(double d2) {
        return ((((-0.6981317007977321d * d2) * d2) - 0.8726646259971648d) * d2) + 1.5707963267948966d;
    }

    public static float max(float f2, float f3) {
        return f2 > f3 ? f2 : f3;
    }

    public static int max(int i2, int i3) {
        return i2 > i3 ? i2 : i3;
    }

    public static float min(float f2, float f3) {
        return f2 < f3 ? f2 : f3;
    }

    public static int min(int i2, int i3) {
        return i2 < i3 ? i2 : i3;
    }

    public static double sin_roquen_9(double d2) {
        double rint = Math.rint(0.3183098861837907d * d2);
        double d3 = d2 - (3.141592653589793d * rint);
        double d4 = d3 * d3;
        return ((((((((s5 * d4) + s4) * d4) + s3) * d4) + s2) * d4) + s1) * ((double) (1 - ((((int) rint) & 1) * 2))) * d3;
    }

    public static double sqrt(double d2) {
        return Math.sqrt(d2);
    }
}
