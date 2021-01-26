package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class CameraPreviewTrack extends BMGNativeObjectRef {
    public CameraPreviewTrack(boolean z) {
        this(createNativeWrap(z));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(boolean z);

    public native void nativeDeinit();

    public native void nativeInit(HybridRender hybridRender, int i2, int i3, int i4, RenderModel renderModel, boolean z);

    public native long nativeRender(HybridRender hybridRender);

    public native long nativeRender2(VideoSampleGroup videoSampleGroup);

    public native void nativeTrack(HybridRender hybridRender);

    public CameraPreviewTrack(long j2) {
        super(j2, "CameraLiveRender");
    }
}
