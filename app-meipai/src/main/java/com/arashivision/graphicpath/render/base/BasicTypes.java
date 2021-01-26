package com.arashivision.graphicpath.render.base;

public class BasicTypes {

    public static class ColorPlusMode {
        public static final int Denoise = 3;
        public static final int HDR = 2;
        public static final int HDR_Denoise = 1;
        public static final int None = 0;
    }

    public static class ColorPlusProcessType {
        public static final int IMAGE = 1;
        public static final int UNDEFINED = 0;
        public static final int VIDEO = 2;
    }

    public static class HWAccelFlag {
        public static final int HWACCEL_ALL = 7;
        public static final int HWACCEL_CUDA = 1;
        public static final int HWACCEL_METAL = 4;
        public static final int HWACCEL_NONE = 0;
        public static final int HWACCEL_OPENCL = 2;
    }

    public static class PovMode {
        public static final int ASPECT_4x3_TO_16x9 = 1;
        public static final int NONE = 0;
    }
}
