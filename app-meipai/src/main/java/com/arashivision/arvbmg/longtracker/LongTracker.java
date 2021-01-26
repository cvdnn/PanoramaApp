package com.arashivision.arvbmg.longtracker;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.base.BaseCameraController;

public class LongTracker extends BMGNativeObjectRef {
    public ITrackInitCompleteCallback mInitCompleteCallback;
    public ILongTrackCallback mLongTrackCallback;
    public ILongTrackRectCallback mLongTrackRectCallback;
    public boolean mReleased;

    public interface ILongTrackCallback {
        void onNotify(LongTracker longTracker, int i2, int i3, long j2, long j3, float f2, String str, String str2, Object obj, Object obj2, Object obj3);

        void onStartCallback(String str, boolean z);

        void onStopCallback(long j2);
    }

    public interface ILongTrackRectCallback {
        void onTrackRect(int i2, Object obj);
    }

    public interface ITrackInitCompleteCallback {
        void onInitComplete(boolean z);
    }

    public LongTracker() {
        this(nativeCreateObj());
    }

    private void checkUrls(String[] strArr, long j2) {
        if (strArr == null) {
            throw new RuntimeException("urls should not null for offline tracker");
        } else if (j2 == -1) {
            throw new RuntimeException("offstarttime is -1, should set for offline tracker");
        }
    }

    private native void nativeConfigModel(String str, String str2, String str3, String str4);

    public static native long nativeCreateObj();

    private native void nativeRelease();

    private native void nativeSetDebug(boolean z);

    private native void nativeSetupCallback();

    private native void nativeStartAiTrack(LongTrackInfo longTrackInfo, String[] strArr, HybridRender hybridRender, BaseCameraController baseCameraController);

    private native void nativeStopOffTrack();

    private native void nativeStopTrack(HybridRender hybridRender);

    private native void nativeUpdateTrack(HybridRender hybridRender);

    private native void nativeUpdateTrackFrame(long j2);

    private void onInitFinish(boolean z) {
        ITrackInitCompleteCallback iTrackInitCompleteCallback = this.mInitCompleteCallback;
        if (iTrackInitCompleteCallback != null) {
            iTrackInitCompleteCallback.onInitComplete(z);
        }
    }

    private void onNotify(int i2, int i3, long j2, long j3, float f2, String str, String str2, Object obj, Object obj2, Object obj3) {
        ILongTrackCallback iLongTrackCallback = this.mLongTrackCallback;
        if (iLongTrackCallback != null) {
            iLongTrackCallback.onNotify(this, i2, i3, j2, j3, f2, str, str2, obj, obj2, obj3);
        }
    }

    private void onStartNotify(String str, boolean z) {
        ILongTrackCallback iLongTrackCallback = this.mLongTrackCallback;
        if (iLongTrackCallback != null) {
            iLongTrackCallback.onStartCallback(str, z);
        }
    }

    private void onStopTrack(long j2) {
        ILongTrackCallback iLongTrackCallback = this.mLongTrackCallback;
        if (iLongTrackCallback != null) {
            iLongTrackCallback.onStopCallback(j2);
        }
    }

    private void onTrackRectf(int i2, Object obj) {
        ILongTrackRectCallback iLongTrackRectCallback = this.mLongTrackRectCallback;
        if (iLongTrackRectCallback != null) {
            iLongTrackRectCallback.onTrackRect(i2, obj);
        }
    }

    public void configModel(String str, String str2, String str3, String str4) {
        nativeConfigModel(str, str2, str3, str4);
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void release() {
        if (!this.mReleased) {
            nativeRelease();
            this.mReleased = true;
        }
    }

    public void setDebug(boolean z) {
        nativeSetDebug(z);
    }

    public void setInitCompleteCallback(ITrackInitCompleteCallback iTrackInitCompleteCallback) {
        this.mInitCompleteCallback = iTrackInitCompleteCallback;
    }

    public void setLongTrackCallback(ILongTrackCallback iLongTrackCallback) {
        this.mLongTrackCallback = iLongTrackCallback;
    }

    public void setLongTrackRectCallback(ILongTrackRectCallback iLongTrackRectCallback) {
        this.mLongTrackRectCallback = iLongTrackRectCallback;
    }

    public void startAiTrack(LongTrackInfo longTrackInfo, HybridRender hybridRender, BaseCameraController baseCameraController) {
        nativeStartAiTrack(longTrackInfo, longTrackInfo.urls, hybridRender, baseCameraController);
    }

    public void startOffTrack(LongTrackInfo longTrackInfo) {
        if (longTrackInfo.useOffRenderOnly) {
            checkUrls(longTrackInfo.urls, longTrackInfo.offStartTime);
            configModel(longTrackInfo.mnnPath, longTrackInfo.namePath, longTrackInfo.skeletonMnnPath, longTrackInfo.roiPath);
        }
        nativeStartAiTrack(longTrackInfo, longTrackInfo.urls, null, null);
    }

    public void stopOffTrack() {
        nativeStopOffTrack();
    }

    public void stopTrack(HybridRender hybridRender) {
        nativeStopTrack(hybridRender);
    }

    public void updateOffTrack(long j2) {
        nativeUpdateTrackFrame(j2);
    }

    public void updateTrack(HybridRender hybridRender) {
        nativeUpdateTrack(hybridRender);
    }

    public LongTracker(long j2) {
        super(j2, "LongTracker");
        nativeSetupCallback();
    }
}
