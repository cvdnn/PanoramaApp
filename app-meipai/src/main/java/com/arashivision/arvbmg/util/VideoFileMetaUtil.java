package com.arashivision.arvbmg.util;

public class VideoFileMetaUtil {

    public static class RemuxCode {
        public static final int NEXT_PAKCET_NULL_WITH_NO_ERROR = -5002;
        public static final int NO_VIDEO_TRACKS = -5001;
        public static final int REMUX_OK = 0;
    }

    static {
        ARVBMGLibsLoader.load();
    }

    public static native int nativeRemuxPanoInfo(String str, String str2);

    public static native boolean nativeWritePanoInfo(String str, String str2);

    public static int remuxPanoInfo(String str, String str2) {
        return nativeRemuxPanoInfo(str, str2);
    }

    public static boolean writePanoInfo(String str, String str2) {
        return nativeWritePanoInfo(str, str2);
    }
}
