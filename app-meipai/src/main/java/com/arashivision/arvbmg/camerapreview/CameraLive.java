package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class CameraLive extends BMGNativeObjectRef {
    public CameraLiveCallback mCallback;

    public interface CameraLiveCallback {
        void onNotify(CameraLive cameraLive, int i2, int i3, int i4, String str, String str2);
    }

    public CameraLive(CameraLiveCallback cameraLiveCallback) {
        this(createNativeWrap(), cameraLiveCallback);
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    private void onNotify(int i2, int i3, int i4, String str, String str2) {
        this.mCallback.onNotify(this, i2, i3, i4, str, str2);
    }

    private native void setupCallback();

    public native void nativeSetDebug(boolean z);

    public native void nativeSetOptions(CameraLiveOptions cameraLiveOptions);

    public native void putAudio(long j2, byte[] bArr);

    public native void putSample(VideoSampleGroup videoSampleGroup);

    public native void start();

    public native void stop();

    public CameraLive(long j2, CameraLiveCallback cameraLiveCallback) {
        super(j2, "CameraLive");
        this.mCallback = cameraLiveCallback;
        setupCallback();
    }
}
