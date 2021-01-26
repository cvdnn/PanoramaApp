package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.shandowclone.ShandowClone;
import com.arashivision.arvbmg.util.RenderModelUtil;

public class BMGSequentialExporter extends OneExport {
    public SequentialExportCallback mSequenceExportCallback;

    public interface SequentialExportCallback {
        SequentialFrameInfo onFrameRender(int i2);

        ClipRenderInfo onGetFrameRenderModel(int i2);

        ShandowClone onGetShadowClone();
    }

    public BMGSequentialExporter(ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo, long j2, SequentialExportCallback sequentialExportCallback) {
        super(createNativeWrap(exporterAudioClip, bMGExportInfo, j2), "BMGSequentialExporter");
        nativeSetupCallback(bMGExportInfo);
        this.mSequenceExportCallback = sequentialExportCallback;
    }

    public static native long createNativeWrap(ExporterAudioClip exporterAudioClip, BMGExportInfo bMGExportInfo, long j2);

    private native void nativeSetupCallback(BMGExportInfo bMGExportInfo);

    private SequentialFrameInfo onFrameRender(int i2) {
        return this.mSequenceExportCallback.onFrameRender(i2);
    }

    private RenderExportClipInfo onGetFrameRenderModel(int i2) {
        ClipRenderInfo onGetFrameRenderModel = this.mSequenceExportCallback.onGetFrameRenderModel(i2);
        RenderExportClipInfo renderExportClipInfo = new RenderExportClipInfo(RenderModelUtil.createRootRenderModel(onGetFrameRenderModel, null), onGetFrameRenderModel.getMaxMotionBlurNum(), onGetFrameRenderModel.isEnableDenoise(), onGetFrameRenderModel.isEnableHDR(), onGetFrameRenderModel.getHdrStrength(), onGetFrameRenderModel.getDenoiseLevel(), onGetFrameRenderModel.isEnableSuperNight(), onGetFrameRenderModel.getSuperNightNoiseLevel(), onGetFrameRenderModel.getHdrLevel(), onGetFrameRenderModel.isEnableTimeScaleCopySameFrame());
        return renderExportClipInfo;
    }

    private ShandowClone onShadowClone() {
        return this.mSequenceExportCallback.onGetShadowClone();
    }
}
