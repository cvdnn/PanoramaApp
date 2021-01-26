package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class ImageExportInfo extends BMGNativeObjectRef {

    public static class InputType {
        public static final int INPUT_H2645 = 2;
        public static final int INPUT_IMAGE = 1;
        public static final int INPUT_VIDEO = 0;
    }

    public static class OutputType {
        public static final int OUTPUT_BYTEBUFFER = 1;
        public static final int OUTPUT_IMAGE_FILE = 0;
        public static final int OUTPUT_ORIGIN_BYTEBUFFER = 2;
        public static final int OUTPUT_ORIGIN_IMAGE_FILE = 2;
    }

    public ImageExportInfo(String[] strArr, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, boolean z4, boolean z5, long[] jArr, int i5, int i6) {
        super(createNativeWrap(strArr, i2, i3, z, z2, z3, i4, z4, z5, jArr, i5, i6), "ImageExportInfo");
    }

    public static native long createNativeWrap(String[] strArr, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, boolean z4, boolean z5, long[] jArr, int i5, int i6);
}
