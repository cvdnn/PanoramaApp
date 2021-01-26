package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class CompositeRenderModelSetup extends NativeObjectRef {
    public CompositeRenderModelSetup(RenderModel renderModel, RenderModel renderModel2, VideoSampleGroup videoSampleGroup, boolean z) {
        this(createNativeWrap2(renderModel, renderModel2, videoSampleGroup, z));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(RenderModel renderModel, RenderModel renderModel2);

    public static native long createNativeWrap2(RenderModel renderModel, RenderModel renderModel2, VideoSampleGroup videoSampleGroup, boolean z);

    private native void nativeSetRenderRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11);

    public void setRenderRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        nativeSetRenderRect(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    public CompositeRenderModelSetup(RenderModel renderModel, RenderModel renderModel2) {
        this(createNativeWrap(renderModel, renderModel2));
    }

    public CompositeRenderModelSetup(long j2) {
        this(j2, "CompositeRenderModelSetup");
    }

    public CompositeRenderModelSetup(long j2, String str) {
        super(j2, str);
    }
}
