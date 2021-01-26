package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class CameraLiveRender extends BMGNativeObjectRef {
    public CameraLiveRender() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    public native void nativeDeinit();

    public native void nativeInit(HybridRender hybridRender, int i2, int i3, int i4, RenderModel renderModel, boolean z);

    public native long nativeRender2(HybridRender hybridRender, boolean z, MultiViewRectInfo multiViewRectInfo);

    public CameraLiveRender(long j2) {
        super(j2, "CameraLiveRender");
    }
}
