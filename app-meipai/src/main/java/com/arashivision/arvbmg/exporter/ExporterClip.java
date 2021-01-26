package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class ExporterClip extends BMGNativeObjectRef {

    public static class ClipType {
        public static final int FILE = 1;
        public static final int IMAGE = 0;
    }

    public static class ExporterTimeScale {
        public long endTimeMs;
        public double factor;
        public double repeatToFps;
        public long startTimeMs;

        public long getEndTimeMs() {
            return this.endTimeMs;
        }

        public double getFactor() {
            return this.factor;
        }

        public double getRepeatToFps() {
            return this.repeatToFps;
        }

        public long getStartTimeMs() {
            return this.startTimeMs;
        }

        public void setEndTimeMs(long j2) {
            this.endTimeMs = j2;
        }

        public void setFactor(double d2) {
            this.factor = d2;
        }

        public void setRepeatToFps(double d2) {
            this.repeatToFps = d2;
        }

        public void setStartTimeMs(long j2) {
            this.startTimeMs = j2;
        }
    }

    public ExporterClip(long j2, String str) {
        super(j2, str);
    }

    public static ExporterClip createExporterImageClip(String str, long j2, long j3, int i2) {
        return new ExporterClip(createNativeWrapImage(str, j2, j3, i2), "ExporterImageClip");
    }

    public static ExporterClip createExporterVideoClip(String[] strArr, long j2, long j3, ExporterTimeScale[] exporterTimeScaleArr, long j4, boolean z, boolean z2, int i2, long j5, boolean z3, float f2, float f3, float f4) {
        ExporterTimeScale[] exporterTimeScaleArr2 = exporterTimeScaleArr;
        int length = exporterTimeScaleArr2 == null ? 0 : exporterTimeScaleArr2.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = (double) exporterTimeScaleArr2[i3].startTimeMs;
            dArr2[i3] = (double) exporterTimeScaleArr2[i3].endTimeMs;
            dArr3[i3] = exporterTimeScaleArr2[i3].factor;
            dArr4[i3] = exporterTimeScaleArr2[i3].repeatToFps;
        }
        return new ExporterClip(createNativeWrapFile(strArr, j2, j3, dArr, dArr2, dArr3, dArr4, j4, z, z2, i2, j5, z3, f2, f3, f4), "ExporterFileClip");
    }

    public static native long createNativeWrapFile(String[] strArr, long j2, long j3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, long j4, boolean z, boolean z2, int i2, long j5, boolean z3, float f2, float f3, float f4);

    public static native long createNativeWrapImage(String str, long j2, long j3, int i2);

    private native long nativeGetDurationMs();

    private native void nativeSetAudioVolume(double d2);

    public long getDurationMs() {
        return nativeGetDurationMs();
    }

    public void setAudioVolume(double d2) {
        nativeSetAudioVolume(d2);
    }
}
