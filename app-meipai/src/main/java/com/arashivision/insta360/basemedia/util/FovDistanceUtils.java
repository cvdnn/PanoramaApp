package com.arashivision.insta360.basemedia.util;

public class FovDistanceUtils {
    public static float convertBmgDistanceToRajawaliDistance(float f2) {
        return f2 * 800.0f;
    }

    public static float convertRajawaliDistanceToBmgDistance(float f2) {
        return f2 / 800.0f;
    }

    public static float convertXFovToYFov(double d2, int i2, int i3) {
        return (float) (((Math.atan(Math.tan(((d2 / 2.0d) * 3.141592653589793d) / 180.0d) / ((((double) i2) * 1.0d) / ((double) i3))) * 180.0d) / 3.141592653589793d) * 2.0d);
    }

    public static double convertYFovToXFov(double d2, int i2, int i3) {
        return (double) ((float) (((Math.atan(((((double) i2) * 1.0d) / ((double) i3)) * Math.tan(((d2 / 2.0d) * 3.141592653589793d) / 180.0d)) * 180.0d) / 3.141592653589793d) * 2.0d));
    }
}
