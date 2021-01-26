package com.arashivision.algorithm;

import android.util.Log;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class StapleTrackOffline extends BMGNativeObjectRef {
    public static final String TAG = "StapleTrackOnline";
    public boolean mReleased;
    public StapleTrackOfflineRenderCallback mStapleTrackOfflineRenderCallback;

    public interface StapleTrackOfflineRenderCallback {
        ClipRenderInfo onGetClipRenderInfo();
    }

    public StapleTrackOffline(StapleTrackOfflineRenderCallback stapleTrackOfflineRenderCallback) {
        this(createNativeWrap());
        setRequireFreeManually();
        this.mStapleTrackOfflineRenderCallback = stapleTrackOfflineRenderCallback;
    }

    public static native long createNativeWrap();

    private native void nativeDeinit();

    private native void nativeEnableDebug();

    private native int nativeFinish(BaseCameraController baseCameraController, float f2, float f3);

    private native int nativeGetTrackResult(double d2, float[] fArr);

    private native int nativeInit(String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, String str4);

    private native int nativeInitTrack(FrameExporterSample frameExporterSample, StapleTrackResult stapleTrackResult);

    private native int nativeTrack(FrameExporterSample frameExporterSample, StapleTrackResult stapleTrackResult);

    private RenderModel onGetClipRenderModel() {
        return RenderModelUtil.createRootRenderModel(this.mStapleTrackOfflineRenderCallback.onGetClipRenderInfo(), null);
    }

    public void enableDebug() {
        nativeEnableDebug();
    }

    public void finalize() throws Throwable {
        if (this.mReleased) {
            super.finalize();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" not release before finalize ");
        throw new IllegalStateException(sb.toString());
    }

    public int finish(BaseCameraController baseCameraController, float f2, float f3) {
        return nativeFinish(baseCameraController, f2, f3);
    }

    public int getTrackResult(double d2, float[] fArr) {
        return nativeGetTrackResult(d2, fArr);
    }

    public int init(String str, String str2, String str3, int i2, int i3, float f2, float f3, float f4, String str4) {
        return nativeInit(str, str2, str3, i2, i3, f2, f3, f4, str4);
    }

    public int initTrack(FrameExporterSample frameExporterSample, StapleTrackResult stapleTrackResult) {
        return nativeInitTrack(frameExporterSample, stapleTrackResult);
    }

    public void release() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" release");
        Log.i("StapleTrackOnline", sb.toString());
        if (!this.mReleased) {
            nativeDeinit();
            free();
            this.mReleased = true;
        }
    }

    public int track(FrameExporterSample frameExporterSample, StapleTrackResult stapleTrackResult) {
        return nativeTrack(frameExporterSample, stapleTrackResult);
    }

    public StapleTrackOffline(long j2) {
        super(j2, "StapleTrackOnline");
    }
}
