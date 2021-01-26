package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class BMGExportInfo extends BMGNativeObjectRef {

    public static class CONVERT_TYPE {
        public static final int RGBA = 0;
        public static final int YUV420 = 1;
    }

    public static class DENOISE_TYPE {
        public static final int BGR24 = 2;
        public static final int RGBA = 0;
        public static final int YUV420 = 1;
    }

    public static class VideoType {
        public static final int FRAGMENT_MP4 = 1;
        public static final int NORMAL_MP4 = 0;
    }

    public BMGExportInfo(String str, String str2, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, String str3, String str4, String str5, int i7, int i8, boolean z5, boolean z6, String str6, String str7, String str8, int i9, int i10, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, float f2, int i11, boolean z12) {
        this(createNativeWrap(str, str2, i2, i3, i4, i5, z, z2, z3, z4, i6, str3, str4, str5, i7, i8, z5, z6, str6, str7, str8, i9, i10, z7, z8, z9, z10, z11, f2, i11, z12));
    }

    public static native long createNativeWrap(String str, String str2, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, String str3, String str4, String str5, int i7, int i8, boolean z5, boolean z6, String str6, String str7, String str8, int i9, int i10, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, float f2, int i11, boolean z12);

    private native void nativeSetEdgeInfo(int i2, int i3, int i4, int i5);

    private native void nativeSetExportQueueNum(int i2, int i3);

    private native void nativeSetFrameInterpolationScale(double d2);

    private native void nativeSetOutputAudioAfadeOutDuration(double d2);

    private native void nativeSetWaterMark2(int i2, int i3, int i4, int i5, String str, long j2);

    public void setEdgeInfo(int i2, int i3, int i4, int i5) {
        nativeSetEdgeInfo(i2, i3, i4, i5);
    }

    public void setExportQueueNum(int i2, int i3) {
        nativeSetExportQueueNum(i2, i3);
    }

    public void setFrameInterpolationScale(double d2) {
        nativeSetFrameInterpolationScale(d2);
    }

    public void setOutputAudioAfadeOutDuration(double d2) {
        nativeSetOutputAudioAfadeOutDuration(d2);
    }

    public void setWaterMark(int i2, int i3, int i4, int i5, String str, long j2) {
        nativeSetWaterMark2(i2, i3, i4, i5, str, j2);
    }

    public BMGExportInfo(long j2) {
        super(j2, "BMGExportInfo");
    }
}
