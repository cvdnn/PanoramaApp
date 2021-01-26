package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class AlgorithmAutoDetect extends BMGNativeObjectRef {
    public static final String TAG = "AutoDetectSystem";
    public boolean mReleased;

    public AlgorithmAutoDetect(BMGSequenceStabilizer bMGSequenceStabilizer, String str, int i2, int i3) {
        this(createNativeWrap(bMGSequenceStabilizer, str, i2, i3));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(BMGSequenceStabilizer bMGSequenceStabilizer, String str, int i2, int i3);

    private native void nativeProcessFrame(FrameExporterSample frameExporterSample);

    private native void nativeRelease();

    public void finalize() throws Throwable {
        if (this.mReleased) {
            release();
            super.finalize();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" not release before finalize ");
        throw new IllegalStateException(sb.toString());
    }

    public void processFrame(FrameExporterSample frameExporterSample) {
        nativeProcessFrame(frameExporterSample);
    }

    public void release() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" release");
        Log.i(TAG, sb.toString());
        if (!this.mReleased) {
            nativeRelease();
            free();
            this.mReleased = true;
        }
    }

    public AlgorithmAutoDetect(long j2) {
        super(j2, "AlgorithmHDRPlus");
    }
}
