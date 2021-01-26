package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.util.RenderModelUtil;
import java.nio.ByteBuffer;

public class BMGImageExport extends OneExport {
    public ThumbExportCallback mThumbExportCallback;

    public static class ErrorCode {
        public static final int EXPORT_EOF = -4002;
        public static final int NEXT_KEY_FRAME = -4003;
        public static final int RENDER_MEDIA_SAMPLE = -4005;
        public static final int SEEK = -4001;
        public static final int SINK_IMAGE = -4006;
        public static final int SINK_ORG_IMAGE = -4007;
        public static final int SINK_ORG_SCALE_IMAGE = -4008;
        public static final int UPDATE_UNIT = -4004;
    }

    public static class FrameType {
        public static final int ANY_FRAME = 0;
        public static final int IFRAME = 1;
    }

    public interface ThumbExportCallback {
        void onDecodeData(ByteBuffer byteBuffer, int i2, int i3);

        void onFrameRender(int i2, double d2, double d3, double d4, double d5);

        ClipRenderInfo onGetClipRenderInfo(int i2);

        DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4);

        BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4);
    }

    public BMGImageExport(ImageExportInfo imageExportInfo, ThumbExportCallback thumbExportCallback) {
        super(createNativeWrap(imageExportInfo), "BMGImageExport");
        nativeSetupCallback(imageExportInfo);
        this.mThumbExportCallback = thumbExportCallback;
    }

    public static native long createNativeWrap(ImageExportInfo imageExportInfo);

    private native void nativeNextFrame(long j2, int i2, String str, boolean z, int i3);

    private native void nativeSetOutputInfo(long j2, String str, boolean z);

    private native void nativeSetupCallback(ImageExportInfo imageExportInfo);

    private native void nativeUpdateImageExportInfo(ImageExportInfo imageExportInfo);

    private void onDecodeData(ByteBuffer byteBuffer, int i2, int i3) {
        this.mThumbExportCallback.onDecodeData(byteBuffer, i2, i3);
    }

    private void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
        this.mThumbExportCallback.onFrameRender(i2, d2, d3, d4, d5);
    }

    private RenderExportClipInfo onGetClipRenderModel(int i2) {
        ClipRenderInfo onGetClipRenderInfo = this.mThumbExportCallback.onGetClipRenderInfo(i2);
        RenderExportClipInfo renderExportClipInfo = new RenderExportClipInfo(RenderModelUtil.createRootRenderModel(onGetClipRenderInfo, null), onGetClipRenderInfo.getMaxMotionBlurNum(), onGetClipRenderInfo.isEnableDenoise(), onGetClipRenderInfo.isEnableHDR(), onGetClipRenderInfo.getHdrStrength(), onGetClipRenderInfo.getDenoiseLevel(), onGetClipRenderInfo.isEnableSuperNight(), onGetClipRenderInfo.getSuperNightNoiseLevel(), onGetClipRenderInfo.getHdrLevel(), onGetClipRenderInfo.isEnableTimeScaleCopySameFrame());
        return renderExportClipInfo;
    }

    private DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4) {
        return this.mThumbExportCallback.onGetDashboard(i2, d2, d3, d4);
    }

    private BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
        return this.mThumbExportCallback.onTrackFlash(i2, d2, d3, d4);
    }

    public void nextFrame(long j2, int i2, String str, boolean z) {
        nativeNextFrame(j2, i2, str, z, 0);
    }

    public void setOutputInfo(String str) {
        setOutputInfo(0, str);
    }

    public void updateImageExportInfo(ImageExportInfo imageExportInfo) {
        nativeUpdateImageExportInfo(imageExportInfo);
    }

    public void nextFrame(long j2, int i2, String str, boolean z, int i3) {
        nativeNextFrame(j2, i2, str, z, i3);
    }

    public void setOutputInfo(long j2, String str) {
        setOutputInfo(j2, str, false);
    }

    public void setOutputInfo(long j2, String str, boolean z) {
        nativeSetOutputInfo(j2, str, z);
    }
}
