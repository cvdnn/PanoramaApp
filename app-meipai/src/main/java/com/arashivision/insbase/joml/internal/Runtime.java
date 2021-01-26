package com.arashivision.insbase.joml.internal;

public final class Runtime {
    public static final boolean HAS_doubleToRawLongBits = hasDoubleToRawLongBits();
    public static final boolean HAS_floatToRawIntBits = hasFloatToRawIntBits();

    public static int compare(float f2, float f3) {
        int i2 = -1;
        if (f2 < f3) {
            return -1;
        }
        if (f2 > f3) {
            return 1;
        }
        int floatToIntBits = Float.floatToIntBits(f2);
        int floatToIntBits2 = Float.floatToIntBits(f3);
        if (floatToIntBits == floatToIntBits2) {
            i2 = 0;
        } else if (floatToIntBits >= floatToIntBits2) {
            i2 = 1;
        }
        return i2;
    }

    public static long doubleToLongBits(double d2) {
        if (HAS_doubleToRawLongBits) {
            return doubleToLongBits1_3(d2);
        }
        return doubleToLongBits1_2(d2);
    }

    public static long doubleToLongBits1_2(double d2) {
        return Double.doubleToLongBits(d2);
    }

    public static long doubleToLongBits1_3(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    public static boolean equals(float f2, float f3, float f4) {
        if (compare(f2, f3) != 0 && Math.abs(f2 - f3) > f4) {
            return false;
        }
        return true;
    }

    public static int floatToIntBits(float f2) {
        if (HAS_floatToRawIntBits) {
            return floatToIntBits1_3(f2);
        }
        return floatToIntBits1_2(f2);
    }

    public static int floatToIntBits1_2(float f2) {
        return Float.floatToIntBits(f2);
    }

    public static int floatToIntBits1_3(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    public static String formatNumbers(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == 'E') {
                i2 = i3;
            } else if (charAt == ' ' && i2 == i3 - 1) {
                stringBuffer.append('+');
            } else if (Character.isDigit(charAt) && i2 == i3 - 1) {
                stringBuffer.append('+');
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static boolean hasDoubleToRawLongBits() {
        try {
            Double.class.getDeclaredMethod("doubleToRawLongBits", new Class[]{Double.TYPE});
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean hasFloatToRawIntBits() {
        try {
            Float.class.getDeclaredMethod("floatToRawIntBits", new Class[]{Float.TYPE});
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static int compare(double d2, double d3) {
        int i2 = -1;
        if (d2 < d3) {
            return -1;
        }
        if (d2 > d3) {
            return 1;
        }
        int i3 = (Double.doubleToLongBits(d2) > Double.doubleToLongBits(d3) ? 1 : (Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3) ? 0 : -1));
        if (i3 == 0) {
            i2 = 0;
        } else if (i3 >= 0) {
            i2 = 1;
        }
        return i2;
    }

    public static boolean equals(double d2, double d3, double d4) {
        if (compare(d2, d3) != 0 && Math.abs(d2 - d3) > d4) {
            return false;
        }
        return true;
    }
}
