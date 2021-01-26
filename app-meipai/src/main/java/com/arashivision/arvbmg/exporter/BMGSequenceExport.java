package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.util.RenderModelUtil;

public class BMGSequenceExport extends OneExport {
    public SequenceExportCallback mSequenceExportCallback;

    public interface SequenceExportCallback {
        String onFrameRender(int i2, int i3);

        ClipRenderInfo onGetFrameRenderModel(int i2);
    }

    public BMGSequenceExport(int i2, ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo, SequenceExportCallback sequenceExportCallback) {
        super(createNativeWrap(i2, exporterAudioClip, bMGExportInfo), "BMGSequenceExport");
        nativeSetupCallback(bMGExportInfo);
        this.mSequenceExportCallback = sequenceExportCallback;
    }

    public static native long createNativeWrap(int i2, ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo);

    private native void nativeSetupCallback(BMGExportInfo bMGExportInfo);

    private String onFrameRender(int i2, int i3) {
        return this.mSequenceExportCallback.onFrameRender(i2, i3);
    }

    private RenderExportClipInfo onGetFrameRenderModel(int i2) {
        ClipRenderInfo onGetFrameRenderModel = this.mSequenceExportCallback.onGetFrameRenderModel(i2);
        RenderExportClipInfo renderExportClipInfo = new RenderExportClipInfo(RenderModelUtil.createRootRenderModel(onGetFrameRenderModel, null), onGetFrameRenderModel.getMaxMotionBlurNum(), onGetFrameRenderModel.isEnableDenoise(), onGetFrameRenderModel.isEnableHDR(), onGetFrameRenderModel.getHdrStrength(), onGetFrameRenderModel.getDenoiseLevel(), onGetFrameRenderModel.isEnableSuperNight(), onGetFrameRenderModel.getSuperNightNoiseLevel(), onGetFrameRenderModel.getHdrLevel(), onGetFrameRenderModel.isEnableTimeScaleCopySameFrame());
        return renderExportClipInfo;
    }
}
