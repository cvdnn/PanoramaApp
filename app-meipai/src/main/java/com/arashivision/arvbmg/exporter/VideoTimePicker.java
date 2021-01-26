package com.arashivision.arvbmg.exporter;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.exporter.ExporterClip.ExporterTimeScale;
import com.arashivision.arvbmg.util.ARVBMGLibsLoader;

public class VideoTimePicker {
    static {
        ARVBMGLibsLoader.load();
    }

    public static long[] calculateVideoTime(String str, long j2, long j3, ExporterTimeScale[] exporterTimeScaleArr) {
        ExporterTimeScale[] exporterTimeScaleArr2 = exporterTimeScaleArr;
        int length = exporterTimeScaleArr2 == null ? 0 : exporterTimeScaleArr2.length;
        if (length == 0) {
            Log.e(BMGConstants.TAG, " numTimeScales is 0");
        }
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = (double) exporterTimeScaleArr2[i2].startTimeMs;
            dArr2[i2] = (double) exporterTimeScaleArr2[i2].endTimeMs;
            dArr3[i2] = exporterTimeScaleArr2[i2].factor;
            dArr4[i2] = exporterTimeScaleArr2[i2].repeatToFps;
        }
        return nativeCalculateVideoTime(str, j2, j3, dArr, dArr2, dArr3, dArr4);
    }

    public static native long[] nativeCalculateVideoTime(String str, long j2, long j3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4);
}
