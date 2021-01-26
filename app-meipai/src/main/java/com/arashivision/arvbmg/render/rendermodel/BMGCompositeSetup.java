package com.arashivision.arvbmg.render.rendermodel;

import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo.RenderRect;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class BMGCompositeSetup extends BMGNativeObjectRef {

    public static class CompositeStrategy {
        public static final int FILTER_MERGE = 1;
        public static final int LOTTIE_MERGE = 2;
        public static final int PLANE_COMPOSITE = 0;
    }

    public BMGCompositeSetup(RenderModel renderModel, RenderModel renderModel2, int i2) {
        this(createNativeWrap(renderModel, renderModel2, i2));
        setRequireFreeManually();
    }

    public static native long createNativeWrap(RenderModel renderModel, RenderModel renderModel2, int i2);

    public static native long createNativeWrap2(RenderModel renderModel, RenderModel renderModel2, VideoSampleGroup videoSampleGroup, boolean z);

    public static native long createNativeWrap3(RenderModel renderModel, RenderModel renderModel2, MultiViewRectInfo multiViewRectInfo, boolean z);

    private native void nativeSetRenderRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11);

    public void setRenderRect(RenderRect renderRect) {
        nativeSetRenderRect(renderRect.renderWidth, renderRect.renderHeight, renderRect.contentInMinX, renderRect.contentInMaxX, renderRect.contentInMinY, renderRect.contentInMaxY, renderRect.contentOutMinX, renderRect.contentOutMaxX, renderRect.contentOutMinY, renderRect.contentOutMaxY);
    }

    public BMGCompositeSetup(RenderModel renderModel, RenderModel renderModel2, VideoSampleGroup videoSampleGroup, boolean z) {
        this(createNativeWrap2(renderModel, renderModel2, videoSampleGroup, z));
        setRequireFreeManually();
    }

    public BMGCompositeSetup(RenderModel renderModel, RenderModel renderModel2, MultiViewRectInfo multiViewRectInfo, boolean z) {
        this(createNativeWrap3(renderModel, renderModel2, multiViewRectInfo, z));
        setRequireFreeManually();
    }

    public BMGCompositeSetup(long j2) {
        super(j2, "BMGCompositeSetup");
    }
}
