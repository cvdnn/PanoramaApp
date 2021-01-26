package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.base.BaseCameraController;

public class BMGSmartTrack extends BMGNativeObjectRef {
    public boolean mReleased;
    public SmartTrackCallback mSmartTrackCallback;

    public static class NotifyType {
        public static final int ERROR = 1;
        public static final int UPDATE_ROTATE = 2;
    }

    public interface SmartTrackCallback {
        void onNotify(BMGSmartTrack bMGSmartTrack, int i2, int i3, int i4, String str, String str2, Object obj);
    }

    public BMGSmartTrack() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    private void emptyCallbacks() {
        this.mSmartTrackCallback = new SmartTrackCallback() {
            public void onNotify(BMGSmartTrack bMGSmartTrack, int i2, int i3, int i4, String str, String str2, Object obj) {
            }
        };
    }

    private native void nativeEnableDebug();

    private native void nativeRelease();

    private native void nativeSetupCallback();

    private native void nativeStartTrack(double d2, double d3, HybridRender hybridRender, int i2, int i3, int i4, int i5, BaseCameraController baseCameraController, boolean z);

    private native void nativeStopTrack(HybridRender hybridRender);

    private native void nativeUpdate(HybridRender hybridRender);

    private void onNotify(int i2, int i3, int i4, String str, String str2, Object obj) {
        this.mSmartTrackCallback.onNotify(this, i2, i3, i4, str, str2, obj);
    }

    public void enableDebug() {
        nativeEnableDebug();
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

    public void setCallback(SmartTrackCallback smartTrackCallback) {
        if (smartTrackCallback != null) {
            this.mSmartTrackCallback = smartTrackCallback;
        } else {
            emptyCallbacks();
        }
    }

    public void startTrack(double d2, double d3, HybridRender hybridRender, int i2, int i3, int i4, int i5, BaseCameraController baseCameraController, boolean z) {
        nativeStartTrack(d2, d3, hybridRender, i2, i3, i4, i5, baseCameraController, z);
    }

    public void stopTrack(HybridRender hybridRender) {
        nativeStopTrack(hybridRender);
    }

    public void update(HybridRender hybridRender) {
        nativeUpdate(hybridRender);
    }

    public BMGSmartTrack(long j2) {
        super(j2, "BMGSmartTrack");
        emptyCallbacks();
        nativeSetupCallback();
    }
}
