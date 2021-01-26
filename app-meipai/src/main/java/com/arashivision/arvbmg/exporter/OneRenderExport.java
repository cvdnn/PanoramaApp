package com.arashivision.arvbmg.exporter;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;

public class OneRenderExport extends OneExport {
    public RenderExportCallback mRenderExportCallback;

    public interface RenderExportCallback {
        void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9);

        void onFrameRender(int i2, double d2, double d3, double d4, double d5, boolean z);

        ClipRenderInfo onGetClipRenderInfo(int i2);

        DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4);

        LottieSetupInfo onLottieSetup(int i2, int i3, double d2);

        LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2, double d3, double d4);

        boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5);

        BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4);

        MultiViewRectInfo onUpdateMultiviewInfo(int i2, double d2, double d3, double d4, double d5);
    }

    public OneRenderExport(ExporterClip[] exporterClipArr, ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo, RenderExportCallback renderExportCallback) {
        super(createNativeWrap(exporterClipArr, exporterAudioClip, bMGExportInfo), "OneRenderExport");
        nativeSetupCallback(bMGExportInfo);
        this.mRenderExportCallback = renderExportCallback;
    }

    public static native long createNativeWrap(ExporterClip[] exporterClipArr, ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo);

    private native void nativeSetAudioEffectClips(ExporterAudioClip[] exporterAudioClipArr);

    private native void nativeSetupCallback(BMGExportInfo bMGExportInfo);

    private void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9) {
        int i4 = i2;
        this.mRenderExportCallback.onCutSceneFrameRender(i2, d2, d3, d4, d5, i3, d6, d7, d8, d9);
    }

    private void onFrameRender(int i2, double d2, double d3, double d4, double d5, boolean z) {
        this.mRenderExportCallback.onFrameRender(i2, d2, d3, d5, d4, z);
    }

    private RenderExportClipInfo onGetClipRenderModel(int i2) {
        RenderModel renderModel;
        ClipRenderInfo onGetClipRenderInfo = this.mRenderExportCallback.onGetClipRenderInfo(i2);
        if (onGetClipRenderInfo.getMultiViewInfo() != null) {
            Log.i(BMGConstants.TAG, " export in multiview ");
            renderModel = RenderModelUtil.createMultiViewRenderModel(onGetClipRenderInfo, null);
        } else {
            renderModel = RenderModelUtil.createRootRenderModel(onGetClipRenderInfo, null);
        }
        RenderExportClipInfo renderExportClipInfo = new RenderExportClipInfo(renderModel, onGetClipRenderInfo.getMaxMotionBlurNum(), onGetClipRenderInfo.isEnableDenoise(), onGetClipRenderInfo.isEnableHDR(), onGetClipRenderInfo.getHdrStrength(), onGetClipRenderInfo.getDenoiseLevel(), onGetClipRenderInfo.isEnableSuperNight(), onGetClipRenderInfo.getSuperNightNoiseLevel(), onGetClipRenderInfo.getHdrLevel(), onGetClipRenderInfo.isEnableTimeScaleCopySameFrame());
        return renderExportClipInfo;
    }

    private DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4) {
        return this.mRenderExportCallback.onGetDashboard(i2, d2, d3, d4);
    }

    private RenderModel onLottieSetup(int i2, int i3, double d2) {
        return RenderModelUtil.createCompositeRenderModel(this.mRenderExportCallback.onLottieSetup(i2, i3, d2));
    }

    private LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2, double d3, double d4) {
        return this.mRenderExportCallback.onLottieUpdate(i2, i3, d2, d3, d4);
    }

    private boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5) {
        return this.mRenderExportCallback.onMultiviewFrameRender(i2, d2, d3, d4, d5);
    }

    private BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
        return this.mRenderExportCallback.onTrackFlash(i2, d2, d3, d4);
    }

    private MultiViewRectInfo onUpdateMultiViewInfo(int i2, double d2, double d3, double d4, double d5) {
        return this.mRenderExportCallback.onUpdateMultiviewInfo(i2, d2, d3, d4, d5);
    }

    public void setAudioEffectClips(ExporterAudioClip[] exporterAudioClipArr) {
        nativeSetAudioEffectClips(exporterAudioClipArr);
    }
}
