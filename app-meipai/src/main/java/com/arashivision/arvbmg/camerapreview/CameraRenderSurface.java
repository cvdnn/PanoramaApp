package com.arashivision.arvbmg.camerapreview;

import android.view.Surface;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class CameraRenderSurface extends BMGNativeObjectRef {
    public CameraRenderSurface() {
        this(createNativeWrap());
        setRequireFreeManually();
    }

    public static native long createNativeWrap();

    public native void nativeDeinit();

    public native void nativeInit(HybridRender hybridRender, Surface surface, int i2, int i3, RenderModel renderModel, boolean z);

    public native long nativeRender(HybridRender hybridRender);

    public CameraRenderSurface(long j2) {
        super(j2, "CameraLiveRender");
    }
}
