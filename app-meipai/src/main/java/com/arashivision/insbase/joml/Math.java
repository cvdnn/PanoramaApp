package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Options;
import e.a.a.a.a;

public class Math {
    public static final double PI = 3.141592653589793d;
    public static final double PI2 = 6.283185307179586d;
    public static final double PIHalf = 1.5707963267948966d;
    public static final double PI_4 = 0.7853981633974483d;
    public static final double PI_INV = 0.3183098861837907d;
    public static final double c1 = Double.longBitsToDouble(-4628199217061079772L);
    public static final double c2 = Double.longBitsToDouble(4575957461383582011L);
    public static final double c3 = Double.longBitsToDouble(-4671919876300759001L);
    public static final double c4 = Double.longBitsToDouble(4523617214285661942L);
    public static final double c5 = Double.longBitsToDouble(-4730215272828025532L);
    public static final double c6 = Double.longBitsToDouble(4460272573143870633L);
    public static final double c7 = Double.longBitsToDouble(-4797767418267846529L);
    public static final double k1 = Double.longBitsToDouble(-4628199217061079959L);
    public static final double k2 = Double.longBitsToDouble(4575957461383549981L);
    public static final double k3 = Double.longBitsToDouble(-4671919876307284301L);
    public static final double k4 = Double.longBitsToDouble(4523617213632129738L);
    public static final double k5 = Double.longBitsToDouble(-4730215344060517252L);
    public static final double k6 = Double.longBitsToDouble(4460268259291226124L);
    public static final double k7 = Double.longBitsToDouble(-4798040743777455072L);
    public static final int lookupBits;
    public static final double lookupSizeOverPi2;
    public static final int lookupTableSize;
    public static final int lookupTableSizeMinus1;
    public static final int lookupTableSizeWithMargin;
    public static final double pi2OverLookupSize;
    public static final double s1 = Double.longBitsToDouble(4607182418589157889L);
    public static final double s2 = Double.longBitsToDouble(-4628199223918090387L);
    public static final double s3 = Double.longBitsToDouble(4575957211482072852L);
    public static final double s4 = Double.longBitsToDouble(-4671934770969572232L);
    public static final double s5 = Double.longBitsToDouble(4523227044276562163L);
    public static final float[] sinTable;

    static {
        int i2 = Options.SIN_LOOKUP_BITS;
        lookupBits = i2;
        int i3 = 1 << i2;
        lookupTableSize = i3;
        lookupTableSizeMinus1 = i3 - 1;
        lookupTableSizeWithMargin = i3 + 1;
        pi2OverLookupSize = 6.283185307179586d / ((double) i3);
        lookupSizeOverPi2 = ((double) i3) / 6.283185307179586d;
        if (!Options.FASTMATH || !Options.SIN_LOOKUP) {
            sinTable = null;
        } else {
            sinTable = new float[lookupTableSizeWithMargin];
            for (int i4 = 0; i4 < lookupTableSizeWithMargin; i4++) {
                sinTable[i4] = (float) Math.sin(((double) i4) * pi2OverLookupSize);
            }
        }
    }

    public static double abs(double d2) {
        return Math.abs(d2);
    }

    public static double acos(double d2) {
        return Math.acos(d2);
    }

    public static double asin(double d2) {
        return Math.asin(d2);
    }

    public static double atan2(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    public static double ceil(double d2) {
        return Math.ceil(d2);
    }

    public static double cos(double d2) {
        if (Options.FASTMATH) {
            return sin(d2 + 1.5707963267948966d);
        }
        return Math.cos(d2);
    }

    public static double cosFromSin(double d2, double d3) {
        if (Options.FASTMATH) {
            return sin(d3 + 1.5707963267948966d);
        }
        double sqrt = sqrt(1.0d - (d2 * d2));
        double d4 = d3 + 1.5707963267948966d;
        double d5 = d4 - (((double) ((int) (d4 / 6.283185307179586d))) * 6.283185307179586d);
        if (d5 < 0.0d) {
            d5 += 6.283185307179586d;
        }
        if (d5 >= 3.141592653589793d) {
            sqrt = -sqrt;
        }
        return sqrt;
    }

    public static double exp(double d2) {
        return Math.exp(d2);
    }

    public static double floor(double d2) {
        return Math.floor(d2);
    }

    public static boolean isFinite(double d2) {
        return abs(d2) <= Double.MAX_VALUE;
    }

    public static double max(double d2, double d3) {
        return d2 > d3 ? d2 : d3;
    }

    public static float max(float f2, float f3) {
        return f2 > f3 ? f2 : f3;
    }

    public static int max(int i2, int i3) {
        return Math.max(i2, i3);
    }

    public static double min(double d2, double d3) {
        return d2 < d3 ? d2 : d3;
    }

    public static float min(float f2, float f3) {
        return f2 < f3 ? f2 : f3;
    }

    public static int min(int i2, int i3) {
        return Math.min(i2, i3);
    }

    public static long round(double d2) {
        return Math.round(d2);
    }

    public static double sin(double d2) {
        if (!Options.FASTMATH) {
            return Math.sin(d2);
        }
        if (Options.SIN_LOOKUP) {
            return sin_theagentd_lookup(d2);
        }
        return sin_roquen_newk(d2);
    }

    public static double sin_roquen_9(double d2) {
        double rint = Math.rint(0.3183098861837907d * d2);
        double d3 = d2 - (3.141592653589793d * rint);
        double d4 = d3 * d3;
        return ((((((((s5 * d4) + s4) * d4) + s3) * d4) + s2) * d4) + s1) * ((double) (1 - ((((int) rint) & 1) * 2))) * d3;
    }

    public static double sin_roquen_arith(double d2) {
        double floor = floor((0.7853981633974483d + d2) * 0.3183098861837907d);
        double d3 = d2 - (3.141592653589793d * floor);
        double d4 = d3 * d3;
        double d5 = ((double) (((((int) floor) & 1) * -2) + 1)) * d3;
        return a.d(d4, d5, (((((((((((c7 * d4) + c6) * d4) + c5) * d4) + c4) * d4) + c3) * d4) + c2) * d4) + c1, d5);
    }

    public static double sin_roquen_newk(double d2) {
        double rint = Math.rint(0.3183098861837907d * d2);
        double d3 = d2 - (3.141592653589793d * rint);
        double d4 = d3 * d3;
        double d5 = ((double) (1 - ((((int) rint) & 1) * 2))) * d3;
        return a.d(d4, d5, (((((((((((k7 * d4) + k6) * d4) + k5) * d4) + k4) * d4) + k3) * d4) + k2) * d4) + k1, d5);
    }

    public static double sin_theagentd_arith(double d2) {
        double floor = floor((0.7853981633974483d + d2) * 0.3183098861837907d);
        double d3 = d2 - (3.141592653589793d * floor);
        double d4 = (double) (((((int) floor) & 1) * -2) + 1);
        double d5 = d3 * d3;
        double d6 = d3 * d5;
        double d7 = (c1 * d6) + d3;
        double d8 = d6 * d5;
        double d9 = (c2 * d8) + d7;
        double d10 = d8 * d5;
        double d11 = (c3 * d10) + d9;
        double d12 = d10 * d5;
        double d13 = (c4 * d12) + d11;
        double d14 = d12 * d5;
        double d15 = (c5 * d14) + d13;
        double d16 = d14 * d5;
        return a.k(d16 * d5, c7, (c6 * d16) + d15, d4);
    }

    public static double sin_theagentd_lookup(double d2) {
        float f2 = (float) (d2 * lookupSizeOverPi2);
        int floor = (int) Math.floor((double) f2);
        float f3 = f2 - ((float) floor);
        int i2 = floor & lookupTableSizeMinus1;
        float[] fArr = sinTable;
        float f4 = fArr[i2];
        return (double) a.e(fArr[i2 + 1], f4, f3, f4);
    }

    public static double sqrt(double d2) {
        return Math.sqrt(d2);
    }

    public static double tan(double d2) {
        return Math.tan(d2);
    }

    public static double toDegrees(double d2) {
        return Math.toDegrees(d2);
    }

    public static double toRadians(double d2) {
        return Math.toRadians(d2);
    }

    public static float abs(float f2) {
        return Math.abs(f2);
    }

    public static float ceil(float f2) {
        return (float) Math.ceil((double) f2);
    }

    public static float floor(float f2) {
        return (float) Math.floor((double) f2);
    }

    public static boolean isFinite(float f2) {
        return abs(f2) <= Float.MAX_VALUE;
    }

    public static int round(float f2) {
        return Math.round(f2);
    }

    public static int abs(int i2) {
        return Math.abs(i2);
    }
}
