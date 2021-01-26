package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class CameraHistogram extends BMGNativeObjectRef {
    public CameraHistogram() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    public static native int[] nativeGetBrightness(VideoSampleGroup videoSampleGroup);

    public native void nativeDeinit();

    public native void nativeInit(HybridRender hybridRender, int i2, int i3, RenderModel renderModel, boolean z);

    public native long nativeRender(HybridRender hybridRender);

    public CameraHistogram(long j2) {
        super(j2, "CameraLiveRender");
    }
}
