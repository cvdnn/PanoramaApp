package com.arashivision.graphicpath.insmedia.previewer2;

import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class PreviewerSource extends NativeObjectRef {
    static {
        RenderLibsLoader.load();
    }

    public PreviewerSource() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    private native void nativeAddFileClip(String[] strArr, boolean z, double d2, double d3, double d4, double d5, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, boolean[] zArr, double d6, double d7, double d8, double d9, long[] jArr, float f2, float f3, double d10);

    public PreviewerSource addFileClip(String[] strArr, boolean z, double d2, double d3, double d4, double d5, TimeScale[] timeScaleArr, double d6, double d7, double d8, double d9, long[] jArr, float f2, float f3, double d10) {
        TimeScale[] timeScaleArr2 = timeScaleArr;
        int length = timeScaleArr2 == null ? 0 : timeScaleArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = timeScaleArr2[i2].scaleStartTimeMs;
            dArr2[i2] = timeScaleArr2[i2].scaleEndTimeMs;
            dArr3[i2] = timeScaleArr2[i2].factor;
            dArr4[i2] = timeScaleArr2[i2].repeatToFps;
            zArr[i2] = timeScaleArr2[i2].videoKeyframeOnly;
        }
        nativeAddFileClip(strArr, z, d2, d3, d4, d5, dArr, dArr2, dArr3, dArr4, zArr, d6, d7, d8, d9, jArr, f2, f3, d10);
        return this;
    }

    public native PreviewerSource addImage(String str, double d2, double d3, double d4, long j2);

    public native PreviewerSource setBgm(String str, double d2, double d3, double d4, double d5, double d6, double d7);

    public native PreviewerSource setBgmDisable(boolean z);

    public native PreviewerSource setOriginAudioDisable(boolean z);

    public PreviewerSource(long j2) {
        super(j2, "PreviewerSource");
    }
}
