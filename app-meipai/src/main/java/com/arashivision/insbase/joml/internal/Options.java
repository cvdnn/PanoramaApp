package com.arashivision.insbase.joml.internal;

import com.tencent.connect.common.Constants;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class Options {
    public static final boolean DEBUG;
    public static final boolean FASTMATH;
    public static final boolean NO_UNSAFE;
    public static final NumberFormat NUMBER_FORMAT = decimalFormat();
    public static final boolean SIN_LOOKUP;
    public static final int SIN_LOOKUP_BITS = Integer.parseInt(System.getProperty("joml.sinLookup.bits", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
    public static final int numberFormatDecimals = Integer.parseInt(System.getProperty("joml.format.decimals", "3"));
    public static final boolean useNumberFormat = false;

    static {
        String str = "false";
        DEBUG = hasOption(System.getProperty("joml.debug", str));
        NO_UNSAFE = hasOption(System.getProperty("joml.nounsafe", str));
        FASTMATH = hasOption(System.getProperty("joml.fastmath", str));
        SIN_LOOKUP = hasOption(System.getProperty("joml.sinLookup", str));
    }

    public static NumberFormat decimalFormat() {
        return new DecimalFormat("0.##########");
    }

    public static boolean hasOption(String str) {
        if (str == null) {
            return false;
        }
        if (str.trim().length() == 0) {
            return true;
        }
        return Boolean.valueOf(str).booleanValue();
    }
}
