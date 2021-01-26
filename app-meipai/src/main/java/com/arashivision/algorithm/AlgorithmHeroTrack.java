package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.common.TrackerSequence;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class AlgorithmHeroTrack extends BMGNativeObjectRef {
    public static final String TAG = "AlgorithmHeroTrack";
    public boolean mReleased;

    public AlgorithmHeroTrack() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    private native void nativeEnableDebug();

    private native TrackerSequence nativeFinishProcess();

    private native int nativeInit(String str, String str2, int i2, int i3);

    private native boolean nativeInputUrls(String[] strArr, int i2, float f2);

    private native int nativeProcessFrame(FrameExporterSample frameExporterSample, float[] fArr);

    private native int nativeProcessFrame2(String str, float[] fArr);

    private native int nativeProcessFrame3(VideoSampleGroup videoSampleGroup, float[] fArr);

    private native boolean nativeProcessFrame4(FrameExporterSample frameExporterSample);

    private native void nativeRelease();

    public void enableDebug() {
        nativeEnableDebug();
    }

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

    public TrackerSequence finish() {
        return nativeFinishProcess();
    }

    public int init(String str, String str2, int i2, int i3) {
        return nativeInit(str, str2, i2, i3);
    }

    public boolean inputUrls(String[] strArr, int i2, float f2) {
        return nativeInputUrls(strArr, i2, f2);
    }

    public int processFrame(FrameExporterSample frameExporterSample, float[] fArr) {
        return nativeProcessFrame(frameExporterSample, fArr);
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

    public int processFrame(String str, float[] fArr) {
        return nativeProcessFrame2(str, fArr);
    }

    public AlgorithmHeroTrack(long j2) {
        super(j2, TAG);
    }

    public int processFrame(VideoSampleGroup videoSampleGroup, float[] fArr) {
        return nativeProcessFrame3(videoSampleGroup, fArr);
    }

    public boolean processFrame(FrameExporterSample frameExporterSample) {
        return nativeProcessFrame4(frameExporterSample);
    }
}
