package com.arashivision.arvbmg.bigboom.passby;

import com.arashivision.arvbmg.bigboom.TrackerDatas;
import com.arashivision.arvbmg.common.TrackerSequence;
import com.arashivision.arvbmg.exporter.FrameExporterSample;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class PassBy extends BMGNativeObjectRef {
    public IPassByFinishCallback mPassByFinishCallback;

    public interface IPassByFinishCallback {
        void onPassByFinishTrack(TrackerDatas trackerDatas);
    }

    public PassBy() {
        this(nativeCreateObj());
    }

    private void getTracker(Object obj) {
        IPassByFinishCallback iPassByFinishCallback = this.mPassByFinishCallback;
        if (iPassByFinishCallback != null) {
            iPassByFinishCallback.onPassByFinishTrack((TrackerDatas) obj);
        }
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    private native boolean nativeAppalyDirect(TrackerSequence trackerSequence);

    private native boolean nativeConfig(String[] strArr, PassByConfig passByConfig);

    public static native long nativeCreateObj();

    private native void nativeEnableDebug();

    private native void nativeFinish(OvertakingEventCfg overtakingEventCfg, boolean z);

    public static native String nativeGetVersion();

    private native void nativeProcessFrame(FrameExporterSample frameExporterSample);

    private native void nativeRelease();

    private native void nativeSetCallback();

    public boolean appalyDirect(TrackerSequence trackerSequence) {
        return nativeAppalyDirect(trackerSequence);
    }

    public boolean config(String[] strArr, PassByConfig passByConfig) {
        return nativeConfig(strArr, passByConfig);
    }

    public void enableDebug() {
        nativeEnableDebug();
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public void finish(OvertakingEventCfg overtakingEventCfg, boolean z) {
        nativeFinish(overtakingEventCfg, z);
    }

    public void processFrame(FrameExporterSample frameExporterSample) {
        nativeProcessFrame(frameExporterSample);
    }

    public void release() {
        nativeRelease();
    }

    public void setPassByFinishCallback(IPassByFinishCallback iPassByFinishCallback) {
        this.mPassByFinishCallback = iPassByFinishCallback;
    }

    public PassBy(long j2) {
        super(j2, "PassBy");
        nativeSetCallback();
    }
}
