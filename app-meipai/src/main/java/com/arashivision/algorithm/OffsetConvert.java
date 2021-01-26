package com.arashivision.algorithm;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class OffsetConvert extends BMGNativeObjectRef {

    public static class ConvertType {
        public static final int EVO_1504_1520 = 17;
        public static final int EVO_1520_1504 = 16;
        public static final int EVO_2880_3040 = 19;
        public static final int EVO_3040_2880 = 18;
        public static final int EVO_BGR_2_RAW = 20;
        public static final int EVO_RAW_2_BGR = 21;
        public static final int NANOS_BGR_2_RAW = 14;
        public static final int NANOS_RAW_2_BGR = 15;
        public static final int ONER_FISHEYE577_2_DIVING = 22;
        public static final int ONER_FISHEYE577_2_DIVING_WATER = 24;
        public static final int ONER_FISHEYE577_2_PROTECT = 23;
        public static final int ONER_FISHEYE577_BGR_2_RAW = 25;
        public static final int ONER_FISHEYE577_RAW_2_BGR = 26;
        public static final int ONEX_1504_1520 = 9;
        public static final int ONEX_1520_1504 = 8;
        public static final int ONEX_2880_3040 = 11;
        public static final int ONEX_2_DIVING_AIR = 7;
        public static final int ONEX_2_DIVING_WATER = 6;
        public static final int ONEX_2_WATERPROOF = 5;
        public static final int ONEX_3040_2880 = 10;
        public static final int ONEX_BGR_2_RAW = 12;
        public static final int ONEX_RAW_2_BGR = 13;
        public static final int ONE_120FPS_2_NORMAL = 1;
        public static final int ONE_2_WATERPROOF = 4;
        public static final int ONE_BGR_2_RAW = 2;
        public static final int ONE_NORMAL_2_120FPS = 0;
        public static final int ONE_RAW_2_BGR = 3;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public OffsetConvert() {
        this(-1, "OffsetConvert");
    }

    public static String alignOffsetForAKikoFishEye(String str, float f2, int i2) {
        return nativeAlignOffsetForAKikoFishEye(str, f2, i2);
    }

    public static String convertOffset2(String str, int i2) {
        return nativeConvertOffset2(str, i2);
    }

    public static native String nativeAlignOffsetForAKikoFishEye(String str, float f2, int i2);

    private native String nativeConvertOffset(String str, int i2);

    public static native String nativeConvertOffset2(String str, int i2);

    public String convertOffset(String str, int i2) {
        return nativeConvertOffset(str, i2);
    }

    public OffsetConvert(long j2, String str) {
        super(j2, str);
    }
}
