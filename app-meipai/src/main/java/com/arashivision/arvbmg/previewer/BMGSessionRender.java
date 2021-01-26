package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.arashivision.algorithm.StapleTrackResult;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.BMGMediaSession.FrameOutput;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.MultiViewInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.PlaneVisibleRect;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.render.filter.BMGFilterObject;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.filter.ImageBlendFilter;
import com.arashivision.arvbmg.render.filter.LutStyleFilter;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.arvbmg.render.rendermodel.BMGCompositeRenderModel;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.arvbmg.util.TimeCost;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.MediaSampleMeta;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.HybridRender.Notify;
import com.arashivision.graphicpath.render.HybridRender.RenderCallback;
import com.arashivision.graphicpath.render.filter.ColorControlFilter;
import com.arashivision.graphicpath.render.filter.FilterObject;
import com.arashivision.graphicpath.render.filter.SharpnessFilter;
import com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;
import com.arashivision.graphicpath.render.rendermodel.feature.StickerFeatureState.StickerSetup;
import com.arashivision.graphicpath.render.source.SequenceSource;
import com.arashivision.graphicpath.render.source.SequenceSource.Listener;
import com.arashivision.graphicpath.ui.GraphicView;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Vector2f;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public abstract class BMGSessionRender {
    public float[] clearColor;
    public final EglContextGroup eglContextGroup;
    public boolean mDebug;
    public ArrayList<FilterObject> mFilters;
    public boolean mFirstSubStream = true;
    public double mFps = 0.0d;
    public boolean mLastUsePreRenderModel;
    public RenderModel mNextRenderModel;
    public ArrayList<FilterObject> mOtherFilters;
    public StabilizingType mOtherStabilizingType;
    public RenderModel mPrevRenderModel;
    public boolean mRenderLoading;
    public RenderModel mRootRenderModel;
    public Listener mSequenceSourceListener;
    public int mSequenceSourceQueueMode = -1;
    public final Handler mSessionCallbackHandler;
    public final Callbacks mSessionCallbacks;
    public final PreviewerRenderCallback mSessionRenderCallbacks;
    public StabilizingType mStabilizingType;
    public HybridRender render;
    public final String renderName;
    public final Queue<RenderTask> renderTaskList = new LinkedList();
    public long renderThreadId = -1;
    public SequenceSource sequenceSource;
    public WeakReference<GraphicView> view;

    public interface Callbacks {
        void onComplete(int i2);

        void onDecodeReport(int i2, int i3);

        void onFail(int i2, String str, String str2);

        void onFpsNotify(double d2);

        void onPrepared();

        void onReBuffer(int i2, int i3);

        void onSeek(int i2, int i3, String str, String str2);

        void onStartLoading();

        void onStopLoading();

        void onSubStreamDecodeReport(int i2, int i3);

        void onSubStreamFail(int i2, String str, String str2);

        void onSubStreamPrepared();

        void onSubStreamReBuffer(int i2, int i3);

        void onSubStreamSeek(int i2, int i3, String str, String str2);
    }

    public static class CompositeStrategyInfo {
        public double endCutSceneMs;
        public ClipRenderInfo[] mClipRenderInfos;
        public int mStrategy;
    }

    public static class LottieName {
        public static final String BLUR_MOVE = "blur_move";
        public static final String BLUR_ROTATE = "blur_rotate";
        public static final String BLUR_SLIDE_LEFT = "blur_slide_left";
        public static final String BLUR_SLIDE_TOP = "blur_slide_top";
        public static final String BLUR_SLIDE_WIGGLE_LEFT = "blur_slide_wiggle_left";
        public static final String BLUR_SLIDE_WIGGLE_TOP = "blur_slide_wiggle_top";
        public static final String BLUR_ZOOM_IN = "blur_zoom_in";
        public static final String BLUR_ZOOM_OUT = "blur_zoom_out";
        public static final String FADE_IN_FADE_OUT = "fade_in_fade_out";
        public static final String GLITCH = "glitch";
        public static final String MASK_SLICE_FOUR_BLOCKS = "mask_slice-four-blocks";
        public static final String PANO_TRANSFORM_FADE_IN_OUT_ANIMATION = "pano_transform_fade_in_out_animation";
        public static final String SLOT_MACHINE = "slot_machine";
        public static final String TAIL_ANIMATION = "tail_animation";
    }

    public static class LottieSetupInfo {
        public ClipRenderInfo[] mClipRenderInfos;
        public FilterInfo[] mFilterInfos;
        public RenderRect mRenderRect;

        public static class RenderRect {
            public float contentInMaxX;
            public float contentInMaxY;
            public float contentInMinX;
            public float contentInMinY;
            public float contentOutMaxX;
            public float contentOutMaxY;
            public float contentOutMinX;
            public float contentOutMinY;
            public float renderHeight;
            public float renderWidth;
        }
    }

    public static class LottieTransform {
        public float mInBlurGaussionDirection;
        public float mInBlurRadialType;
        public float mLottieType;
        public MaskPointInfo[] mMaskPoints;
        public float mOutBlurGaussionDirection;
        public float mOutBlurRadialType;
        public TransformEffect mTransformEffectInEnd;
        public TransformEffect mTransformEffectInStart;
        public TransformEffect mTransformEffectOutEnd;
        public TransformEffect mTransformEffectOutStart;
        public TransformInfo transformInEnd;
        public TransformInfo transformInStart;
        public TransformInfo transformOutEnd;
        public TransformInfo transformOutStart;

        public static class MaskPoint {
            public float x;
            public float y;

            public MaskPoint(float f2, float f3) {
                this.x = f2;
                this.y = f3;
            }
        }

        public static class MaskPointInfo {
            public MaskPoint[] end;
            public MaskPoint[] start;
        }
    }

    public static class LottieType {
        public static final float LOTTIE_TYPE_BASIC = 0.0f;
        public static final float LOTTIE_TYPE_GLITCH = 3.0f;
        public static final float LOTTIE_TYPE_SLOT_MACHINE = 2.0f;
        public static final float LOTTIE_TYPE_TAIL_ANIMATION = 1.0f;
    }

    public static class MultiviewUpdateInfo {
        public MultiViewRectInfo mMultiViewRectInfo;
        public boolean mState;
    }

    public interface PreviewerRenderCallback {
        void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9);

        void onFrameRender(int i2, double d2, double d3, double d4, double d5);

        ClipRenderInfo onGetClipRenderInfo(int i2);

        LottieSetupInfo onLottieSetup(int i2, int i3, double d2);

        LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2);

        boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5);

        void onRenderBefore();

        void onRenderNotify(int i2, int i3, int i4);

        void onStapleTrackError(int i2);

        void onStapleTrackResult(StapleTrackResult stapleTrackResult);

        void onStapleTrackStop();

        void onStopTrack(long j2);

        void onSubStreamFrameRender(int i2, double d2, double d3, double d4, double d5);

        BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4);

        void onTrackStart(String str, boolean z);

        void onTrackUpdate(int i2, long j2, float f2, float[] fArr, float[] fArr2, float[] fArr3);

        MultiViewRectInfo onUpdateMultiviewInfo(int i2, double d2, double d3, double d4, double d5);
    }

    public static final class RebufferNotifyType {
        public static final int BUFFERING_END = 502;
        public static final int BUFFERING_START = 500;
        public static final int BUFFERING_UPDATE = 501;
    }

    public static class TransformEffect {
        public float blur_gaussian_blurriness;
        public float blur_radial_amount;
        public float blur_radial_centerX;
        public float blur_radial_centerY;
    }

    public static class TransformInfo {
        public float opacity;
        public float rotation;
        public float scaleX;
        public float scaleY;
        public float trPositionX;
        public float trPositionY;
    }

    public BMGSessionRender(String str, Context context, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler) {
        this.renderName = str;
        this.mSessionCallbacks = callbacks;
        this.mSessionRenderCallbacks = previewerRenderCallback;
        this.eglContextGroup = new EglContextGroup();
        this.mSessionCallbackHandler = handler;
    }

    private final void clearRender() {
        discardAllFilters();
        discardAllOtherFilters();
        if (this.render != null) {
            onClearRenderBefore();
        }
        setFrameOutput(null);
        removeRender();
        HybridRender hybridRender = this.render;
        if (hybridRender != null) {
            hybridRender.free();
            this.render = null;
        }
        synchronized (this.renderTaskList) {
            if (this.renderTaskList.size() != 0) {
                String str = BMGConstants.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(" clear render but render task ");
                sb.append(this.renderTaskList.size());
                Log.e(str, sb.toString());
            }
            this.renderTaskList.clear();
        }
        if (this.sequenceSource != null) {
            Log.i(BMGConstants.TAG, " sequenceSource free");
            this.sequenceSource.free();
            this.sequenceSource = null;
        }
    }

    private final void discardAllFilters() {
        ArrayList<FilterObject> arrayList = this.mFilters;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = this.mFilters.iterator();
            while (it.hasNext()) {
                ((FilterObject) it.next()).discard();
            }
            this.mFilters = null;
        }
    }

    private final void discardAllOtherFilters() {
        ArrayList<FilterObject> arrayList = this.mOtherFilters;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = this.mOtherFilters.iterator();
            while (it.hasNext()) {
                ((FilterObject) it.next()).discard();
            }
            this.mOtherFilters = null;
        }
    }

    /* access modifiers changed from: private */
    public long getCurrentTreadId() {
        return Thread.currentThread().getId();
    }

    private void internalOfferTask(RenderTask renderTask) {
        if (!this.renderTaskList.offer(renderTask)) {
            Log.e(BMGConstants.TAG, "internalOfferTask offer error");
        }
    }

    private void performRenderTasks() {
        RenderTask renderTask;
        while (true) {
            synchronized (this.renderTaskList) {
                renderTask = (RenderTask) this.renderTaskList.poll();
            }
            if (renderTask != null) {
                renderTask.run();
                synchronized (this.renderTaskList) {
                    if (this.mRenderLoading && this.renderTaskList.isEmpty()) {
                        runOnSessionHandler(new Runnable() {
                            public void run() {
                                BMGSessionRender.this.mSessionCallbacks.onStopLoading();
                            }
                        });
                        this.mRenderLoading = false;
                    }
                }
            } else {
                return;
            }
        }
        while (true) {
        }
    }

    private void removeRender() {
        WeakReference<GraphicView> weakReference = this.view;
        if (weakReference != null && weakReference.get() != null) {
            ((GraphicView) this.view.get()).removeRender();
        }
    }

    public static void setAssetDirectory(String str) {
        BMGFilterObject.setFilterAssetDirectory(str);
    }

    /* access modifiers changed from: private */
    public void setClearColorInternal() {
        HybridRender hybridRender = this.render;
        if (hybridRender != null) {
            float[] fArr = this.clearColor;
            if (fArr != null) {
                hybridRender.setClearColor(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setFpsInternal() {
        if (this.render != null && this.mFps > 0.0d) {
            StringBuilder a2 = a.a("set render fps ");
            a2.append(this.mFps);
            Log.i(BMGConstants.TAG, a2.toString());
            this.render.setFps(this.mFps);
        }
    }

    /* access modifiers changed from: private */
    public void setPlaneDisplayRectInternal(PlaneStitchingRenderModel planeStitchingRenderModel, PlaneVisibleRect planeVisibleRect) {
        RenderModelUtil.setPlaneDisplayRectInternal(planeStitchingRenderModel, planeVisibleRect);
    }

    /* access modifiers changed from: private */
    public void setPlaneSphereRotationInternal(PlaneStitchingRenderModel planeStitchingRenderModel, Matrix4f matrix4f) {
        RenderModelUtil.setPlaneSphereRotationInternal(planeStitchingRenderModel, matrix4f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0284 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupFilter(com.arashivision.graphicpath.render.rendermodel.RenderModel r12, com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo[] r13, boolean r14) {
        /*
            r11 = this;
            if (r14 == 0) goto L_0x0006
            r11.discardAllFilters()
            goto L_0x0009
        L_0x0006:
            r11.discardAllOtherFilters()
        L_0x0009:
            r0 = 0
            if (r13 == 0) goto L_0x029d
            int r1 = r13.length
            if (r1 <= 0) goto L_0x029d
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r13.length
            r3 = 0
            r4 = r0
            r5 = r4
        L_0x0018:
            if (r3 >= r2) goto L_0x0288
            r6 = r13[r3]
            java.lang.String r7 = r6.getFilterName()
            java.util.Map r6 = r6.getFilterParams()
            if (r7 == 0) goto L_0x027e
            java.lang.String r8 = "beautify"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0050
            java.lang.String r7 = "level"
            java.lang.Object r8 = r6.get(r7)
            if (r8 == 0) goto L_0x0041
            java.lang.Object r6 = r6.get(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x0043
        L_0x0041:
            int r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.BeautyParam.LEVEL_MAX
        L_0x0043:
            com.arashivision.graphicpath.render.filter.BeautifyFilter r7 = new com.arashivision.graphicpath.render.filter.BeautifyFilter
            com.arashivision.graphicpath.render.HybridRender r8 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r8 = r8.getRenderLifecycle()
            r7.<init>(r6, r8)
            goto L_0x027f
        L_0x0050:
            java.lang.String r8 = "alpha blend"
            boolean r9 = r7.equals(r8)
            java.lang.String r10 = "arvbmg"
            if (r9 == 0) goto L_0x0090
            java.lang.Object r7 = r6.get(r8)
            if (r7 == 0) goto L_0x006b
            java.lang.Object r7 = r6.get(r8)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            goto L_0x006d
        L_0x006b:
            float r7 = com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.AlphaBlendParam.ALPHA_MAX
        L_0x006d:
            java.lang.String r8 = "backgroundImage"
            java.lang.Object r6 = r6.get(r8)
            com.arashivision.graphicpath.render.source.ImageAsset r6 = (com.arashivision.graphicpath.render.source.ImageAsset) r6
            if (r6 != 0) goto L_0x007c
            java.lang.String r8 = "bgImgAsset not set, can't apply alpha_blend filter"
            android.util.Log.e(r10, r8)
        L_0x007c:
            com.arashivision.graphicpath.render.filter.AlphaBlendFilter r8 = new com.arashivision.graphicpath.render.filter.AlphaBlendFilter
            com.arashivision.graphicpath.render.HybridRender r9 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r9 = r9.getRenderLifecycle()
            r8.<init>(r9)
            r8.setAlpha(r7)
            r8.setInputBackgroundImage(r6)
            r7 = r8
            goto L_0x027f
        L_0x0090:
            java.lang.String r8 = "lut_filter"
            boolean r9 = r7.equals(r8)
            if (r9 == 0) goto L_0x00b9
            java.lang.String r7 = "lut_dimension"
            java.lang.Object r7 = r6.get(r7)
            float[] r7 = (float[]) r7
            java.lang.String r9 = "lut_data"
            java.lang.Object r6 = r6.get(r9)
            byte[] r6 = (byte[]) r6
            com.arashivision.arvbmg.render.filter.LutFilter r9 = new com.arashivision.arvbmg.render.filter.LutFilter
            com.arashivision.graphicpath.render.HybridRender r10 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r10 = r10.getRenderLifecycle()
            r9.<init>(r10, r8)
            r9.setLut(r7, r6)
        L_0x00b6:
            r7 = r9
            goto L_0x027f
        L_0x00b9:
            java.lang.String r8 = "lut_style_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x00ef
            java.lang.String r7 = "lut_style_dimension"
            java.lang.Object r7 = r6.get(r7)
            float[] r7 = (float[]) r7
            java.lang.String r8 = "lut_style_data"
            java.lang.Object r8 = r6.get(r8)
            byte[] r8 = (byte[]) r8
            java.lang.String r9 = "lut_style_intensity"
            java.lang.Object r6 = r6.get(r9)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            com.arashivision.arvbmg.render.filter.LutStyleFilter r9 = new com.arashivision.arvbmg.render.filter.LutStyleFilter
            com.arashivision.graphicpath.render.HybridRender r10 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r10 = r10.getRenderLifecycle()
            r9.<init>(r10)
            r9.setLut(r7, r8)
            r9.setIntensity(r6)
            goto L_0x00b6
        L_0x00ef:
            java.lang.String r8 = "sketch_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0104
            com.arashivision.arvbmg.render.filter.SketchFilter r7 = new com.arashivision.arvbmg.render.filter.SketchFilter
            com.arashivision.graphicpath.render.HybridRender r6 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r6 = r6.getRenderLifecycle()
            r7.<init>(r6)
            goto L_0x027f
        L_0x0104:
            java.lang.String r8 = "watermark_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0135
            com.arashivision.arvbmg.render.filter.WaterMarkFilter r7 = new com.arashivision.arvbmg.render.filter.WaterMarkFilter
            com.arashivision.graphicpath.render.HybridRender r8 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r8 = r8.getRenderLifecycle()
            r7.<init>(r8)
            java.lang.String r8 = "watermark_imageasset"
            java.lang.Object r8 = r6.get(r8)
            com.arashivision.graphicpath.render.source.ImageAsset r8 = (com.arashivision.graphicpath.render.source.ImageAsset) r8
            if (r8 != 0) goto L_0x0128
            java.lang.String r6 = "watermarkImageAsset not set, can't apply watermark filter"
            android.util.Log.e(r10, r6)
            goto L_0x027f
        L_0x0128:
            java.lang.String r9 = "watermark_rect"
            java.lang.Object r6 = r6.get(r9)
            float[] r6 = (float[]) r6
            r7.setWaterMark(r8, r6)
            goto L_0x027f
        L_0x0135:
            java.lang.String r8 = "image_blend_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0170
            com.arashivision.arvbmg.render.filter.ImageBlendFilter r7 = new com.arashivision.arvbmg.render.filter.ImageBlendFilter
            com.arashivision.graphicpath.render.HybridRender r8 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r8 = r8.getRenderLifecycle()
            r7.<init>(r8)
            int r8 = r6.size()
            if (r8 == 0) goto L_0x0169
            java.lang.String r8 = "imageblend_info"
            java.lang.Object r6 = r6.get(r8)
            com.arashivision.arvbmg.render.filter.BlendImageInfo r6 = (com.arashivision.arvbmg.render.filter.BlendImageInfo) r6
            if (r6 != 0) goto L_0x015f
            java.lang.String r6 = "setupFilter when blendImageInfo null"
            android.util.Log.i(r10, r6)
            goto L_0x027f
        L_0x015f:
            java.lang.String r8 = "setupFilter with blendImageInfo"
            android.util.Log.e(r10, r8)
            r7.setBlendImageInfo(r6)
            goto L_0x027f
        L_0x0169:
            java.lang.String r6 = " ImageBlendFilter init without param"
            android.util.Log.i(r10, r6)
            goto L_0x027f
        L_0x0170:
            java.lang.String r8 = "overlay_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x01a5
            com.arashivision.arvbmg.render.filter.OverlayFilter r7 = new com.arashivision.arvbmg.render.filter.OverlayFilter
            com.arashivision.graphicpath.render.HybridRender r8 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r8 = r8.getRenderLifecycle()
            r7.<init>(r8)
            java.lang.String r8 = "overlay_data"
            java.lang.Object r6 = r6.get(r8)
            com.arashivision.arvbmg.exporter.DashBoardImage r6 = (com.arashivision.arvbmg.exporter.DashBoardImage) r6
            if (r6 != 0) goto L_0x0194
            java.lang.String r6 = "dashBoardImage not set, can't apply overlay filter"
            android.util.Log.e(r10, r6)
            goto L_0x027f
        L_0x0194:
            byte[] r8 = r6.getData()
            int r9 = r6.getWidth()
            int r6 = r6.getHeight()
            r7.setOverlayData(r8, r9, r6)
            goto L_0x027f
        L_0x01a5:
            java.lang.String r8 = "color_control_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0234
            com.arashivision.graphicpath.render.filter.ColorControlFilter r4 = new com.arashivision.graphicpath.render.filter.ColorControlFilter
            com.arashivision.graphicpath.render.HybridRender r7 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r7 = r7.getRenderLifecycle()
            r4.<init>(r7)
            java.lang.String r7 = "brightness"
            java.lang.Object r8 = r6.get(r7)
            if (r8 == 0) goto L_0x01e1
            java.lang.Object r7 = r6.get(r7)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r4.setBrightness(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "brightness "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.i(r10, r7)
        L_0x01e1:
            java.lang.String r7 = "contrast"
            java.lang.Object r8 = r6.get(r7)
            if (r8 == 0) goto L_0x020a
            java.lang.Object r7 = r6.get(r7)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "contrast "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r10, r8)
            r4.setContrast(r7)
        L_0x020a:
            java.lang.String r7 = "saturation"
            java.lang.Object r8 = r6.get(r7)
            if (r8 == 0) goto L_0x027e
            java.lang.Object r6 = r6.get(r7)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "saturation "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            android.util.Log.i(r10, r7)
            r4.setSaturation(r6)
            goto L_0x027e
        L_0x0234:
            java.lang.String r8 = "sharpness_filter"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0271
            com.arashivision.graphicpath.render.filter.SharpnessFilter r5 = new com.arashivision.graphicpath.render.filter.SharpnessFilter
            com.arashivision.graphicpath.render.HybridRender r7 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r7 = r7.getRenderLifecycle()
            r5.<init>(r7)
            java.lang.String r7 = "sharpness"
            java.lang.Object r8 = r6.get(r7)
            if (r8 == 0) goto L_0x027e
            java.lang.Object r6 = r6.get(r7)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = " sharpness "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            android.util.Log.i(r10, r7)
            r5.setSharpness(r6)
            goto L_0x027e
        L_0x0271:
            com.arashivision.arvbmg.render.filter.MeituFilter r6 = new com.arashivision.arvbmg.render.filter.MeituFilter
            com.arashivision.graphicpath.render.HybridRender r8 = r11.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r8 = r8.getRenderLifecycle()
            r6.<init>(r7, r8)
            r7 = r6
            goto L_0x027f
        L_0x027e:
            r7 = r0
        L_0x027f:
            if (r7 == 0) goto L_0x0284
            r1.add(r7)
        L_0x0284:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x0288:
            if (r4 == 0) goto L_0x028d
            r1.add(r4)
        L_0x028d:
            if (r5 == 0) goto L_0x0292
            r1.add(r5)
        L_0x0292:
            r12.setPostFilters(r1)
            if (r14 == 0) goto L_0x029a
            r11.mFilters = r1
            goto L_0x02a0
        L_0x029a:
            r11.mOtherFilters = r1
            goto L_0x02a0
        L_0x029d:
            r12.setPostFilter(r0)
        L_0x02a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.previewer.BMGSessionRender.setupFilter(com.arashivision.graphicpath.render.rendermodel.RenderModel, com.arashivision.arvbmg.previewer.ClipRenderInfo$FilterInfo[], boolean):void");
    }

    private void setupLogo(RenderModel renderModel, LogoInfo logoInfo) {
        if (!renderModel.hasLogoFeature()) {
            return;
        }
        if (logoInfo != null) {
            renderModel.updateLogoImage(logoInfo.getLogoAsset());
            renderModel.setLogoSize(logoInfo.getLogoSize().floatValue());
            renderModel.setLogoPosition(logoInfo.getLogoPosition());
            renderModel.enableLogoFeature(true);
            return;
        }
        renderModel.enableLogoFeature(false);
    }

    /* access modifiers changed from: private */
    public final void updateCameraFacing(int i2) {
        RenderModel rootRenderModel = getRootRenderModel();
        if (rootRenderModel == null) {
            return;
        }
        if (rootRenderModel instanceof BMGCompositeRenderModel) {
            RenderModel prevRenderModel = getPrevRenderModel();
            String str = BMGConstants.TAG;
            if (prevRenderModel != null) {
                updateCameraFacingInternal(getPrevRenderModel(), i2);
            } else {
                Log.e(str, "setupFilter but prev render model null");
            }
            if (getNextRenderModel() != null) {
                updateCameraFacingInternal(getNextRenderModel(), i2);
            } else {
                Log.e(str, "setupFilter but next render model null");
            }
        } else {
            updateCameraFacingInternal(rootRenderModel, i2);
        }
    }

    private void updateCameraFacingInternal(RenderModel renderModel, int i2) {
        RenderModelUtil.updateCameraFacingInternal(renderModel, i2);
    }

    /* access modifiers changed from: private */
    public void updateColorControlInternal(Map<String, Object> map) {
        ArrayList<FilterObject> arrayList = this.mFilters;
        boolean z = true;
        String str = "saturation";
        String str2 = "contrast";
        String str3 = "brightness";
        String str4 = BMGConstants.TAG;
        boolean z2 = false;
        if (arrayList == null || arrayList.size() <= 0) {
            Log.e(str4, " updateColorControlInternal when no filter");
        } else {
            Iterator it = this.mFilters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FilterObject filterObject = (FilterObject) it.next();
                if (filterObject instanceof ColorControlFilter) {
                    ColorControlFilter colorControlFilter = (ColorControlFilter) filterObject;
                    if (map.get(str3) != null) {
                        float floatValue = ((Float) map.get(str3)).floatValue();
                        colorControlFilter.setBrightness(floatValue);
                        StringBuilder sb = new StringBuilder();
                        sb.append("update brightness ");
                        sb.append(floatValue);
                        Log.i(str4, sb.toString());
                    }
                    if (map.get(str2) != null) {
                        float floatValue2 = ((Float) map.get(str2)).floatValue();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("update contrast ");
                        sb2.append(floatValue2);
                        Log.i(str4, sb2.toString());
                        colorControlFilter.setContrast(floatValue2);
                    }
                    if (map.get(str) != null) {
                        float floatValue3 = ((Float) map.get(str)).floatValue();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("update saturation ");
                        sb3.append(floatValue3);
                        Log.i(str4, sb3.toString());
                        colorControlFilter.setSaturation(floatValue3);
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                Log.e(str4, " no color control filter found");
            }
        }
        ArrayList<FilterObject> arrayList2 = this.mOtherFilters;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it2 = this.mOtherFilters.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = z2;
                    break;
                }
                FilterObject filterObject2 = (FilterObject) it2.next();
                if (filterObject2 instanceof ColorControlFilter) {
                    ColorControlFilter colorControlFilter2 = (ColorControlFilter) filterObject2;
                    if (map.get(str3) != null) {
                        float floatValue4 = ((Float) map.get(str3)).floatValue();
                        colorControlFilter2.setBrightness(floatValue4);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("multiview/vr update brightness ");
                        sb4.append(floatValue4);
                        Log.i(str4, sb4.toString());
                    }
                    if (map.get(str2) != null) {
                        float floatValue5 = ((Float) map.get(str2)).floatValue();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("multiview/vr update contrast ");
                        sb5.append(floatValue5);
                        Log.i(str4, sb5.toString());
                        colorControlFilter2.setContrast(floatValue5);
                    }
                    if (map.get(str) != null) {
                        float floatValue6 = ((Float) map.get(str)).floatValue();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("multiview/vr update saturation ");
                        sb6.append(floatValue6);
                        Log.i(str4, sb6.toString());
                        colorControlFilter2.setSaturation(floatValue6);
                    }
                }
            }
            if (!z) {
                Log.e(str4, " no multiview/vr color control filter found");
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateLutStyleFilterIntensityInternal(float f2) {
        ArrayList<FilterObject> arrayList = this.mFilters;
        boolean z = true;
        String str = BMGConstants.TAG;
        boolean z2 = false;
        if (arrayList == null || arrayList.size() <= 0) {
            Log.e(str, " updateLutStyleFilterIntensityInternal when no filter");
        } else {
            Iterator it = this.mFilters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FilterObject filterObject = (FilterObject) it.next();
                if (filterObject instanceof LutStyleFilter) {
                    ((LutStyleFilter) filterObject).setIntensity(f2);
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                Log.e(str, " no lut_style_filter found");
            }
        }
        ArrayList<FilterObject> arrayList2 = this.mOtherFilters;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it2 = this.mOtherFilters.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = z2;
                    break;
                }
                FilterObject filterObject2 = (FilterObject) it2.next();
                if (filterObject2 instanceof LutStyleFilter) {
                    Log.e(str, " updateLutStyleFilterIntensityInternal multiview/vr lut_style_filter found");
                    ((LutStyleFilter) filterObject2).setIntensity(f2);
                    break;
                }
            }
            if (!z) {
                Log.e(str, " no multiview/vr lut_style_filter found");
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateMultiViewFrameRender(boolean z) {
        RenderModel rootRenderModel = getRootRenderModel();
        String str = BMGConstants.TAG;
        if (rootRenderModel == null || !(rootRenderModel instanceof BMGCompositeRenderModel)) {
            Log.e(str, " updateMultiViewFrameRender but not BMGCompositeRenderModel when update multi view state");
            return;
        }
        BMGCompositeRenderModel bMGCompositeRenderModel = (BMGCompositeRenderModel) rootRenderModel;
        StringBuilder sb = new StringBuilder();
        sb.append(" updateMultiViewFrameRender display ");
        sb.append(z);
        Log.i(str, sb.toString());
        bMGCompositeRenderModel.updateMultiViewState(z);
    }

    /* access modifiers changed from: private */
    public final void updateMultiviewInfo(MultiViewRectInfo multiViewRectInfo) {
        RenderModel rootRenderModel = getRootRenderModel();
        if (rootRenderModel == null) {
            return;
        }
        if (rootRenderModel instanceof BMGCompositeRenderModel) {
            ((BMGCompositeRenderModel) rootRenderModel).updateMultiViewInfo(multiViewRectInfo);
        } else {
            Log.e(BMGConstants.TAG, "updateMultiviewInfo but not bmg composite render model");
        }
    }

    /* access modifiers changed from: private */
    public void updateSharpnessInternal(Map<String, Object> map) {
        ArrayList<FilterObject> arrayList = this.mFilters;
        boolean z = true;
        String str = "sharpness";
        String str2 = BMGConstants.TAG;
        boolean z2 = false;
        if (arrayList == null || arrayList.size() <= 0) {
            Log.e(str2, " updateSharpnessInternal when no filter");
        } else {
            Iterator it = this.mFilters.iterator();
            if (it.hasNext()) {
                FilterObject filterObject = (FilterObject) it.next();
                if (filterObject instanceof SharpnessFilter) {
                    SharpnessFilter sharpnessFilter = (SharpnessFilter) filterObject;
                    if (map.get(str) != null) {
                        float floatValue = ((Float) map.get(str)).floatValue();
                        StringBuilder sb = new StringBuilder();
                        sb.append("update sharpness ");
                        sb.append(floatValue);
                        Log.i(str2, sb.toString());
                        sharpnessFilter.setSharpness(floatValue);
                    }
                }
                z2 = true;
            }
            if (!z2) {
                Log.e(str2, " no sharpness filter found");
            }
        }
        ArrayList<FilterObject> arrayList2 = this.mOtherFilters;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it2 = this.mOtherFilters.iterator();
            if (it2.hasNext()) {
                FilterObject filterObject2 = (FilterObject) it2.next();
                if (filterObject2 instanceof SharpnessFilter) {
                    SharpnessFilter sharpnessFilter2 = (SharpnessFilter) filterObject2;
                    if (map.get(str) != null) {
                        float floatValue2 = ((Float) map.get(str)).floatValue();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("multiview/vr update sharpness ");
                        sb2.append(floatValue2);
                        Log.i(str2, sb2.toString());
                        sharpnessFilter2.setSharpness(floatValue2);
                    }
                }
            } else {
                z = z2;
            }
            if (!z) {
                Log.e(str2, "multiview/vr no sharpness filter found");
            }
        }
    }

    public final void addRenderTask(RenderTask renderTask) {
        synchronized (this.renderTaskList) {
            if (!this.renderTaskList.isEmpty()) {
                this.mRenderLoading = true;
                runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGSessionRender.this.mSessionCallbacks.onStartLoading();
                    }
                });
            }
            internalOfferTask(renderTask);
        }
    }

    public final void bindView(GraphicView graphicView) {
        this.view = new WeakReference<>(graphicView);
        setupRender();
    }

    public RenderModel createMultiViewRenderModel(ClipRenderInfo clipRenderInfo) {
        if (clipRenderInfo.getMultiViewInfo() != null) {
            RenderModel createRenderModel = createRenderModel(clipRenderInfo, true);
            RenderModel createRenderModel2 = createRenderModel(clipRenderInfo.getMultiViewInfo().mClipRenderInfo, false);
            BMGCompositeRenderModel createCompositeRenderModel = RenderModelUtil.createCompositeRenderModel(createRenderModel, createRenderModel2, this.render.getRenderLifecycle(), clipRenderInfo.getMultiViewInfo().mMultiViewRectInfo, (FilterInfo[]) null, true);
            setPrevRenderModel(createRenderModel);
            setNextRenderModel(createRenderModel2);
            return createCompositeRenderModel;
        }
        throw new IllegalArgumentException("createMultiViewRenderModel but multiview info null");
    }

    public RenderModel createRenderModel(ClipRenderInfo clipRenderInfo) {
        return createRenderModel(clipRenderInfo, true);
    }

    public RenderModel createVRRenderModel(ClipRenderInfo clipRenderInfo) {
        if (clipRenderInfo.getVRMode() != 0) {
            RenderModel createRenderModel = createRenderModel(clipRenderInfo, true);
            RenderModel createRenderModel2 = createRenderModel(clipRenderInfo, false);
            BMGCompositeRenderModel createCompositeRenderModel = RenderModelUtil.createCompositeRenderModel(createRenderModel, createRenderModel2, this.render.getRenderLifecycle(), clipRenderInfo.getVRMode());
            setPrevRenderModel(createRenderModel);
            setNextRenderModel(createRenderModel2);
            return createCompositeRenderModel;
        }
        throw new IllegalArgumentException("createVRRenderModel but vr off");
    }

    public void debugSampleTime(String str, VideoSampleGroup videoSampleGroup) {
        if (isDebug()) {
            boolean hasCutScene = hasCutScene(videoSampleGroup);
            String str2 = " meta progress ";
            String str3 = " meta src ";
            String str4 = " meta ms ";
            String str5 = BMGConstants.TAG;
            if (hasCutScene) {
                StringBuilder b2 = a.b(str, str4);
                b2.append(Double.toString(videoSampleGroup.getMeta().getMediaTimeMs()));
                b2.append(str3);
                b2.append(Double.toString(videoSampleGroup.getMeta().getSrcTsMs()));
                b2.append(str2);
                b2.append(Double.toString(videoSampleGroup.getMeta().getSrcProgressTimeMs()));
                String str6 = " cut ms ";
                b2.append(str6);
                b2.append(Double.toString(videoSampleGroup.getCutscenesMeta().getMediaTimeMs()));
                b2.append(" cut src ");
                b2.append(Double.toString(videoSampleGroup.getCutscenesMeta().getSrcTsMs()));
                b2.append(str6);
                b2.append(Double.toString(videoSampleGroup.getCutscenesMeta().getMediaTimeMs()));
                Log.i(str5, b2.toString());
                return;
            }
            StringBuilder b3 = a.b(str, str4);
            b3.append(Double.toString(videoSampleGroup.getMeta().getMediaTimeMs()));
            b3.append(str3);
            b3.append(Double.toString(videoSampleGroup.getMeta().getSrcTsMs()));
            b3.append(str2);
            b3.append(Double.toString(videoSampleGroup.getMeta().getSrcProgressTimeMs()));
            Log.i(str5, b3.toString());
        }
    }

    public void enableDebug() {
        this.mDebug = true;
    }

    public int getClipIndex(VideoSampleGroup videoSampleGroup) {
        return videoSampleGroup.getMeta().getClipIndex();
    }

    public RenderModel getNextRenderModel() {
        return this.mNextRenderModel;
    }

    public RenderModel getPrevRenderModel() {
        return this.mPrevRenderModel;
    }

    public final String getRenderName() {
        return this.renderName;
    }

    public RenderModel getRootRenderModel() {
        return this.mRootRenderModel;
    }

    public int getSerialId(VideoSampleGroup videoSampleGroup) {
        return videoSampleGroup.getMeta().getSrcSerialId();
    }

    public boolean hasCutScene(VideoSampleGroup videoSampleGroup) {
        return videoSampleGroup.getCutscenesMeta() != null;
    }

    public final StickerSetup hitTest(final Vector2f vector2f) {
        final StickerSetup[] stickerSetupArr = new StickerSetup[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        addRenderTask(new RenderTask() {
            public void doTask() {
                RenderModel rootRenderModel = BMGSessionRender.this.getRootRenderModel();
                if (rootRenderModel == null) {
                    stickerSetupArr[0] = null;
                } else if (rootRenderModel.hasStickerFeature()) {
                    stickerSetupArr[0] = rootRenderModel.hitTest(vector2f);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            StringBuilder a2 = a.a("hitTest(");
            a2.append(vector2f.x);
            a2.append(",");
            a2.append(vector2f.y);
            a2.append(") error");
            Log.e(BMGConstants.TAG, a2.toString());
            stickerSetupArr[0] = null;
            e2.printStackTrace();
        }
        return stickerSetupArr[0];
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isRenderTread() {
        long j2 = this.renderThreadId;
        boolean z = true;
        if (j2 == -1) {
            Log.e(BMGConstants.TAG, "renderThreadId -1 ");
            return true;
        }
        if (j2 != getCurrentTreadId()) {
            z = false;
        }
        return z;
    }

    public boolean isSameClip(VideoSampleGroup videoSampleGroup, VideoSampleGroup videoSampleGroup2) {
        return getClipIndex(videoSampleGroup) == getClipIndex(videoSampleGroup2) && getSerialId(videoSampleGroup) == getSerialId(videoSampleGroup2);
    }

    public abstract boolean isSampleFromSubStream(VideoSampleGroup videoSampleGroup);

    public final void onCameraFacingChanged(final int i2) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                a.c(a.a("onCameraFacingChanged cameraFacing  "), i2, BMGConstants.TAG);
                BMGSessionRender.this.updateCameraFacing(i2);
            }
        });
    }

    public abstract void onClearRenderBefore();

    public final void onClipRenderInfoChange(ClipRenderInfo clipRenderInfo) {
        onClipRenderInfoChange(clipRenderInfo, false);
    }

    public void onClipRenderInfoChangeInternal(ClipRenderInfo clipRenderInfo, boolean z) {
        onPreviewerSourceClipStart(clipRenderInfo);
        if (clipRenderInfo.getMultiViewInfo() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" onClipRenderInfoChange multiviewDisplay ");
            sb.append(z);
            Log.i(BMGConstants.TAG, sb.toString());
            updateMultiViewFrameRender(z);
        }
    }

    public void onCutSceneFrameRender(MediaSampleMeta mediaSampleMeta, MediaSampleMeta mediaSampleMeta2) {
        if (mediaSampleMeta2 != null) {
            this.mSessionRenderCallbacks.onCutSceneFrameRender(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getRepeatMediaTimeOffsetMs(), mediaSampleMeta.getMediaTimeMs(), mediaSampleMeta2.getClipIndex(), mediaSampleMeta2.getSrcTsMs(), mediaSampleMeta2.getSrcProgressTimeMs(), mediaSampleMeta2.getMediaTimeMs(), mediaSampleMeta2.getRepeatMediaTimeOffsetMs());
        }
    }

    public final void onFilterChanged(final FilterInfo[] filterInfoArr) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.setupFilter(filterInfoArr);
            }
        });
    }

    public void onFrameRender(MediaSampleMeta mediaSampleMeta) {
        if (mediaSampleMeta != null) {
            this.mSessionRenderCallbacks.onFrameRender(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getMediaTimeMs(), mediaSampleMeta.getRepeatMediaTimeOffsetMs());
        }
    }

    public boolean onMultiViewFrameRender(MediaSampleMeta mediaSampleMeta) {
        if (mediaSampleMeta != null) {
            return this.mSessionRenderCallbacks.onMultiviewFrameRender(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getMediaTimeMs(), mediaSampleMeta.getRepeatMediaTimeOffsetMs());
        }
        Log.e(BMGConstants.TAG, "onMultiViewFrameRender but sampleMeta null");
        return false;
    }

    public void onPreviewerSourceClipStart(ClipRenderInfo clipRenderInfo) {
        RenderModel renderModel;
        if (clipRenderInfo != null) {
            MultiViewInfo multiViewInfo = clipRenderInfo.getMultiViewInfo();
            String str = BMGConstants.TAG;
            if (multiViewInfo != null) {
                Log.i(str, " clip render in multiview ");
                renderModel = createMultiViewRenderModel(clipRenderInfo);
            } else if (clipRenderInfo.getVRMode() != 0) {
                Log.i(str, " clip render in vrmode ");
                renderModel = createVRRenderModel(clipRenderInfo);
            } else {
                renderModel = createRenderModel(clipRenderInfo);
            }
            setRootRenderModel(renderModel);
        }
    }

    public void onRender() {
        performRenderTasks();
        this.mSessionRenderCallbacks.onRenderBefore();
    }

    public abstract void onRenderPrepare(HybridRender hybridRender);

    public void onUpdateImageBlendFilter(MediaSampleMeta mediaSampleMeta) {
        if (isRenderTread()) {
            BlendImageInfo blendImageInfo = null;
            ArrayList<FilterObject> arrayList = this.mFilters;
            String str = BMGConstants.TAG;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = this.mFilters.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FilterObject filterObject = (FilterObject) it.next();
                    if (filterObject instanceof ImageBlendFilter) {
                        ImageBlendFilter imageBlendFilter = (ImageBlendFilter) filterObject;
                        TimeCost newInstance = TimeCost.newInstance("onUpdateImageBlendFilter");
                        BlendImageInfo onTrackFlash = this.mSessionRenderCallbacks.onTrackFlash(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getMediaTimeMs());
                        if (onTrackFlash == null) {
                            Log.w(str, "blendImageInfo null");
                        }
                        imageBlendFilter.setBlendImageInfo(onTrackFlash);
                        if (isDebug()) {
                            newInstance.cost();
                        }
                        blendImageInfo = onTrackFlash;
                    }
                }
            }
            ArrayList<FilterObject> arrayList2 = this.mOtherFilters;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it2 = this.mOtherFilters.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    FilterObject filterObject2 = (FilterObject) it2.next();
                    if (filterObject2 instanceof ImageBlendFilter) {
                        ImageBlendFilter imageBlendFilter2 = (ImageBlendFilter) filterObject2;
                        TimeCost newInstance2 = TimeCost.newInstance("multiview/vr onUpdateImageBlendFilter");
                        if (blendImageInfo == null) {
                            Log.w(str, "multiview/vr blendImageInfo null");
                        }
                        imageBlendFilter2.setBlendImageInfo(blendImageInfo);
                        if (isDebug()) {
                            newInstance2.cost();
                        }
                    }
                }
            }
            if (blendImageInfo != null) {
                blendImageInfo.free();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("onUpdateImageBlendFilter but not render thread");
    }

    public MultiViewRectInfo onUpdateMultiViewInfo(MediaSampleMeta mediaSampleMeta) {
        if (mediaSampleMeta != null) {
            return this.mSessionRenderCallbacks.onUpdateMultiviewInfo(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getMediaTimeMs(), mediaSampleMeta.getRepeatMediaTimeOffsetMs());
        }
        Log.e(BMGConstants.TAG, "onUpdateMultiViewInfo but sampleMeta null");
        return null;
    }

    public final void onUpdateMultiviewInfo(final MultiViewRectInfo multiViewRectInfo) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.updateMultiviewInfo(multiViewRectInfo);
            }
        });
    }

    public final void onUpdateMutltiViewFrameRender(final boolean z) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                StringBuilder a2 = a.a(" onUpdateMutltiViewFrameRender display ");
                a2.append(z);
                Log.i(BMGConstants.TAG, a2.toString());
                BMGSessionRender.this.updateMultiViewFrameRender(z);
            }
        });
    }

    public void onUpdatePlaneSphereRotation(final Matrix4f matrix4f) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                RenderModel rootRenderModel = BMGSessionRender.this.getRootRenderModel();
                if (rootRenderModel != null) {
                    boolean z = rootRenderModel instanceof PlaneStitchingRenderModel;
                    String str = BMGConstants.TAG;
                    if (z) {
                        Log.i(str, "onUpdatePlaneSphereRotation");
                        BMGSessionRender.this.setPlaneSphereRotationInternal((PlaneStitchingRenderModel) rootRenderModel, matrix4f);
                        return;
                    }
                    Log.e(str, "setPlaneDisplayRect but not play stitch render model");
                }
            }
        });
    }

    public void onUpdatetPlaneDisplayRect(final PlaneVisibleRect planeVisibleRect) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                RenderModel rootRenderModel = BMGSessionRender.this.getRootRenderModel();
                if (rootRenderModel != null) {
                    boolean z = rootRenderModel instanceof PlaneStitchingRenderModel;
                    String str = BMGConstants.TAG;
                    if (z) {
                        Log.i(str, "onUpdatetPlaneDisplayRect");
                        BMGSessionRender.this.setPlaneDisplayRectInternal((PlaneStitchingRenderModel) rootRenderModel, planeVisibleRect);
                        return;
                    }
                    Log.e(str, "setPlaneDisplayRect but not play stitch render model");
                }
            }
        });
    }

    public void putSourceSample(VideoSampleGroup videoSampleGroup) {
        this.sequenceSource.putSample(videoSampleGroup);
    }

    public void runOnSessionHandler(Runnable runnable) {
        if (Looper.myLooper() != this.mSessionCallbackHandler.getLooper()) {
            this.mSessionCallbackHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void setClearColor(float f2, float f3, float f4, float f5) {
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        final float f9 = f5;
        AnonymousClass1 r0 = new RenderTask() {
            public void doTask() {
                if (BMGSessionRender.this.clearColor == null) {
                    BMGSessionRender.this.clearColor = new float[4];
                }
                BMGSessionRender.this.clearColor[0] = f6;
                BMGSessionRender.this.clearColor[1] = f7;
                BMGSessionRender.this.clearColor[2] = f8;
                BMGSessionRender.this.clearColor[3] = f9;
                BMGSessionRender.this.setClearColorInternal();
            }
        };
        addRenderTask(r0);
    }

    public void setFps(final double d2) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.mFps = d2;
                BMGSessionRender.this.setFpsInternal();
                StringBuilder sb = new StringBuilder();
                sb.append("save app render fps ");
                sb.append(BMGSessionRender.this.mFps);
                Log.i(BMGConstants.TAG, sb.toString());
            }
        });
    }

    public abstract void setFrameOutput(FrameOutput frameOutput);

    public void setNextRenderModel(RenderModel renderModel) {
        RenderModel renderModel2 = this.mNextRenderModel;
        if (renderModel2 != null && (renderModel2 != renderModel || !renderModel2.hasSameNativeObject(renderModel))) {
            this.mNextRenderModel.discard();
            this.mNextRenderModel = null;
        }
        this.mNextRenderModel = renderModel;
        renderModel.enable();
    }

    public void setPrevRenderModel(RenderModel renderModel) {
        RenderModel renderModel2 = this.mPrevRenderModel;
        if (renderModel2 != null && (renderModel2 != renderModel || !renderModel2.hasSameNativeObject(renderModel))) {
            this.mPrevRenderModel.discard();
            this.mPrevRenderModel = null;
        }
        this.mPrevRenderModel = renderModel;
        renderModel.enable();
    }

    public void setRootRenderModel(RenderModel renderModel) {
        setRootRenderModel(renderModel, false);
    }

    public void setSequenceSourceListener(Listener listener) {
        this.mSequenceSourceListener = listener;
    }

    public abstract void setSessionCallback();

    public void setupRender() {
        if (this.render == null) {
            WeakReference<GraphicView> weakReference = this.view;
            if (weakReference != null && weakReference.get() != null) {
                GraphicView graphicView = (GraphicView) this.view.get();
                SequenceSource sequenceSource2 = new SequenceSource(true);
                int i2 = this.mSequenceSourceQueueMode;
                if (i2 == 1 || i2 == 0) {
                    sequenceSource2.setVideoQueueMode(this.mSequenceSourceQueueMode);
                }
                sequenceSource2.setListener(this.mSequenceSourceListener);
                HybridRender hybridRender = new HybridRender(this.eglContextGroup, this.renderName);
                this.render = hybridRender;
                hybridRender.setRenderCallback(new RenderCallback() {
                    public final void onRender(HybridRender hybridRender) {
                        BMGSessionRender.this.onRender();
                    }
                });
                this.render.setNotify(new Notify() {
                    public void onRenderNotify(HybridRender hybridRender, int i2, int i3, int i4) {
                        if (BMGSessionRender.this.renderThreadId != BMGSessionRender.this.getCurrentTreadId()) {
                            StringBuilder a2 = a.a("onRenderNotify notifyType ", i2, " tid ");
                            a2.append(BMGSessionRender.this.getCurrentTreadId());
                            Log.i(BMGConstants.TAG, a2.toString());
                            BMGSessionRender bMGSessionRender = BMGSessionRender.this;
                            bMGSessionRender.renderThreadId = bMGSessionRender.getCurrentTreadId();
                        }
                        BMGSessionRender.this.mSessionRenderCallbacks.onRenderNotify(i2, i3, i4);
                    }
                });
                this.render.setSource(sequenceSource2);
                onRenderPrepare(this.render);
                this.render.resume();
                graphicView.setRender(this.render);
                this.sequenceSource = sequenceSource2;
                setClearColorInternal();
                setFpsInternal();
                setSessionCallback();
                setFrameOutput(new FrameOutput() {
                    public void onFrame(VideoSampleGroup videoSampleGroup) {
                        if (videoSampleGroup == null) {
                            return;
                        }
                        if (!BMGSessionRender.this.isSampleFromSubStream(videoSampleGroup) || !BMGSessionRender.this.mFirstSubStream) {
                            BMGSessionRender.this.debugSampleTime("BMGSessionRender onFrame", videoSampleGroup);
                            BMGSessionRender.this.putSourceSample(videoSampleGroup);
                            return;
                        }
                        Log.i(BMGConstants.TAG, "skip first sub stream");
                        BMGSessionRender.this.debugSampleTime("BMGSessionRender subStream onFrame", videoSampleGroup);
                        BMGSessionRender.this.mFirstSubStream = false;
                        videoSampleGroup.free();
                    }
                });
            } else {
                return;
            }
        }
        updateMediaSessionState();
    }

    public final void terminate() {
        Log.i(BMGConstants.TAG, " terminate session render");
        terminateSession();
        clearRender();
    }

    public abstract void terminateSession();

    public final void updateColorControl(final Map<String, Object> map) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.updateColorControlInternal(map);
            }
        });
    }

    public final void updateLogo(final LogoInfo logoInfo) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.setupLogo(logoInfo);
            }
        });
    }

    public final void updateLutStyleFilterIntensity(final float f2) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.updateLutStyleFilterIntensityInternal(f2);
            }
        });
    }

    public abstract void updateMediaSessionState();

    public final void updateSharpness(final Map<String, Object> map) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGSessionRender.this.updateSharpnessInternal(map);
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v22, types: [com.arashivision.graphicpath.render.rendermodel.SphereRenderModel] */
    /* JADX WARNING: type inference failed for: r2v28, types: [com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.arashivision.graphicpath.render.rendermodel.RenderModel createRenderModel(com.arashivision.arvbmg.previewer.ClipRenderInfo r11, boolean r12) {
        /*
            r10 = this;
            com.arashivision.graphicpath.render.rendermodel.RenderModelType r0 = new com.arashivision.graphicpath.render.rendermodel.RenderModelType
            int r1 = r11.getModelType()
            java.lang.String r2 = r11.getOffset()
            r0.<init>(r1, r2)
            int r1 = r11.getImageLayout()
            r0.setImageLayoutValue(r1)
            int r1 = r11.getPlaneRotationDegreee()
            r0.setPlaneRotationDegree(r1)
            int r1 = r11.getSphereSlices()
            if (r1 <= 0) goto L_0x0028
            int r1 = r11.getSphereSlices()
            r0.setSphereSlices(r1)
        L_0x0028:
            int r1 = r11.getSphereStacks()
            if (r1 <= 0) goto L_0x0035
            int r1 = r11.getSphereStacks()
            r0.setSphereStacks(r1)
        L_0x0035:
            r1 = 0
            com.arashivision.graphicpath.render.util.Stabilizer r2 = r11.getStabilizer()
            r3 = 1
            r4 = 0
            java.lang.String r5 = "arvbmg"
            if (r2 == 0) goto L_0x0065
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r1 = r11.getStabilizingType()
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r2 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.DYNAMIC_VERTEX
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0055
            java.lang.String r2 = "prefer dynamic true"
            android.util.Log.i(r5, r2)
            r0.setPreferDynamic(r3)
            goto L_0x005d
        L_0x0055:
            java.lang.String r2 = "prefer dynamic false"
            android.util.Log.i(r5, r2)
            r0.setPreferDynamic(r4)
        L_0x005d:
            if (r12 == 0) goto L_0x0062
            r10.mStabilizingType = r1
            goto L_0x0073
        L_0x0062:
            r10.mOtherStabilizingType = r1
            goto L_0x0073
        L_0x0065:
            r0.setPreferDynamic(r4)
            if (r12 == 0) goto L_0x006f
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r2 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.NO
            r10.mStabilizingType = r2
            goto L_0x0073
        L_0x006f:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r2 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.NO
            r10.mOtherStabilizingType = r2
        L_0x0073:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r2 = r11.getDynamicStitchType()
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.OFF
            boolean r6 = r2.equals(r6)
            r7 = 3
            r8 = 2
            if (r6 == 0) goto L_0x008a
            java.lang.String r2 = "dynamic stitch undefined"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r4)
            goto L_0x00bc
        L_0x008a:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.IMAGE
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x009b
            java.lang.String r2 = "dynamic stitch image"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r3)
            goto L_0x00bc
        L_0x009b:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.VIDEO
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x00ac
            java.lang.String r2 = "dynamic stitch video"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r8)
            goto L_0x00bc
        L_0x00ac:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.TEMPLATE
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x00bc
            java.lang.String r2 = "dynamic stitch template"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r7)
        L_0x00bc:
            int r2 = r11.getContentMode()
            r6 = -1
            if (r2 == r6) goto L_0x00de
            java.lang.String r2 = "BMGSessionRender set content mode "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            int r9 = r11.getContentMode()
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r5, r2)
            int r2 = r11.getContentMode()
            r0.setContentMode(r2)
        L_0x00de:
            boolean r2 = r11.isImageFusion()
            r0.setImageFusionEnable(r2)
            float r2 = r11.getBlendAngleRad()
            r9 = 0
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f5
            float r2 = r11.getBlendAngleRad()
            r0.setBlendAngleRad(r2)
        L_0x00f5:
            int r2 = r11.getDynamicStitchAccuracyLevel()
            if (r2 == r6) goto L_0x0102
            int r2 = r11.getDynamicStitchAccuracyLevel()
            r0.setDynamicStitchAccuracyLevel(r2)
        L_0x0102:
            int r2 = r11.getPovMode()
            if (r2 == r6) goto L_0x010f
            int r2 = r11.getPovMode()
            r0.setPovMode(r2)
        L_0x010f:
            int r2 = r11.getHwAccelFlags()
            if (r2 == r6) goto L_0x011c
            int r2 = r11.getHwAccelFlags()
            r0.setHwAccelFlags(r2)
        L_0x011c:
            int r2 = r11.getStitchInterval()
            if (r2 == r6) goto L_0x0129
            int r2 = r11.getStitchInterval()
            r0.setStitchInterval(r2)
        L_0x0129:
            boolean r2 = r11.isAsyncStitch()
            r0.setAsyncStitch(r2)
            boolean r2 = r11.isColorAdjust()
            r0.setColorAdjustEnable(r2)
            int r2 = r0.getType()
            r6 = 20
            if (r2 != r6) goto L_0x014c
            com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel
            com.arashivision.graphicpath.render.HybridRender r6 = r10.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r6 = r6.getRenderLifecycle()
            r2.<init>(r0, r6)
            goto L_0x01e9
        L_0x014c:
            int r2 = r0.getType()
            r6 = 11
            if (r2 == r6) goto L_0x01af
            int r2 = r0.getType()
            r6 = 13
            if (r2 != r6) goto L_0x015d
            goto L_0x01af
        L_0x015d:
            int r2 = r0.getType()
            r6 = 4
            if (r2 == r8) goto L_0x0188
            int r2 = r0.getType()
            if (r2 == r7) goto L_0x0188
            int r2 = r0.getType()
            if (r6 != r2) goto L_0x0171
            goto L_0x0188
        L_0x0171:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "no render model for type "
            java.lang.StringBuilder r12 = e.a.a.a.a.a(r12)
            int r0 = r0.getType()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0188:
            java.lang.String r2 = r11.getOffset()
            if (r2 != 0) goto L_0x019f
            int r2 = r0.getType()
            if (r2 == r8) goto L_0x019a
            int r2 = r0.getType()
            if (r6 != r2) goto L_0x019f
        L_0x019a:
            java.lang.String r2 = " no offset for sphere stitch"
            android.util.Log.e(r5, r2)
        L_0x019f:
            com.arashivision.graphicpath.render.rendermodel.SphereRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.SphereRenderModel
            com.arashivision.graphicpath.render.base.BaseCameraController r6 = r11.getBaseCameraController()
            com.arashivision.graphicpath.render.HybridRender r7 = r10.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r7 = r7.getRenderLifecycle()
            r2.<init>(r0, r6, r3, r7)
            goto L_0x01e9
        L_0x01af:
            java.lang.String r2 = r11.getOffset()
            if (r2 != 0) goto L_0x01ba
            java.lang.String r2 = " no offset for plane stitch"
            android.util.Log.e(r5, r2)
        L_0x01ba:
            com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel
            com.arashivision.graphicpath.render.HybridRender r6 = r10.render
            com.arashivision.graphicpath.lifecycle.RenderLifecycle r6 = r6.getRenderLifecycle()
            r2.<init>(r0, r6)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$PlaneVisibleRect r6 = r11.getPlaneVisibleRect()
            if (r6 == 0) goto L_0x01d7
            java.lang.String r6 = "setPlaneDisplayRectInternal when init "
            android.util.Log.i(r5, r6)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$PlaneVisibleRect r6 = r11.getPlaneVisibleRect()
            r10.setPlaneDisplayRectInternal(r2, r6)
        L_0x01d7:
            com.arashivision.insbase.joml.Matrix4f r6 = r11.getPlaneRotateMatrix()
            if (r6 == 0) goto L_0x01e9
            java.lang.String r6 = "setPlaneSphereRotationInternal when init "
            android.util.Log.i(r5, r6)
            com.arashivision.insbase.joml.Matrix4f r6 = r11.getPlaneRotateMatrix()
            r10.setPlaneSphereRotationInternal(r2, r6)
        L_0x01e9:
            boolean r6 = r2.hasStabilizerFeature()
            if (r6 == 0) goto L_0x023d
            com.arashivision.graphicpath.render.util.Stabilizer r6 = r11.getStabilizer()
            r2.setStabilizer(r6)
            com.arashivision.graphicpath.render.util.Stabilizer r6 = r11.getStabilizer()
            if (r6 != 0) goto L_0x0200
            r2.enableStabilizerFeature(r4)
            goto L_0x023d
        L_0x0200:
            if (r1 == 0) goto L_0x0226
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.NO
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x020e
            r2.enableStabilizerFeature(r4)
            goto L_0x023d
        L_0x020e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "create enable stabilizer, type: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.i(r5, r1)
            r2.enableStabilizerFeature(r3)
            goto L_0x023d
        L_0x0226:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "stabilizingType null renderModelType "
            java.lang.StringBuilder r12 = e.a.a.a.a.a(r12)
            java.lang.String r0 = r0.toString()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x023d:
            int r1 = r11.getCameraFacing()
            r10.updateCameraFacingInternal(r2, r1)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$LogoInfo r1 = r11.getLogoInfo()
            r10.setupLogo(r2, r1)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$FilterInfo[] r11 = r11.getFilterInfos()
            r10.setupFilter(r2, r11, r12)
            java.lang.String r11 = " set render model "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11)
            java.lang.String r12 = r0.toString()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.i(r5, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.previewer.BMGSessionRender.createRenderModel(com.arashivision.arvbmg.previewer.ClipRenderInfo, boolean):com.arashivision.graphicpath.render.rendermodel.RenderModel");
    }

    public final void onClipRenderInfoChange(final ClipRenderInfo clipRenderInfo, final boolean z) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                Log.i(BMGConstants.TAG, " onClipRenderInfoChange ");
                BMGSessionRender.this.onClipRenderInfoChangeInternal(clipRenderInfo, z);
            }
        });
    }

    public void setRootRenderModel(RenderModel renderModel, boolean z) {
        if (z) {
            Log.e(BMGConstants.TAG, "pre-init renderModel happen?");
        }
        this.render.setRootRenderModel(renderModel);
        if (!this.mLastUsePreRenderModel) {
            RenderModel renderModel2 = this.mRootRenderModel;
            if (renderModel2 != null && (renderModel2 != renderModel || !renderModel2.hasSameNativeObject(renderModel))) {
                this.mRootRenderModel.discard();
                this.mRootRenderModel = null;
            }
        }
        this.mRootRenderModel = renderModel;
        this.mLastUsePreRenderModel = z;
    }

    /* access modifiers changed from: private */
    public final void setupLogo(LogoInfo logoInfo) {
        RenderModel rootRenderModel = getRootRenderModel();
        if (rootRenderModel == null) {
            return;
        }
        if (rootRenderModel instanceof BMGCompositeRenderModel) {
            RenderModel prevRenderModel = getPrevRenderModel();
            String str = BMGConstants.TAG;
            if (prevRenderModel != null) {
                setupLogo(getPrevRenderModel(), logoInfo);
            } else {
                Log.e(str, "setupLogo but prev render model null");
            }
            if (getNextRenderModel() != null) {
                setupLogo(getNextRenderModel(), logoInfo);
            } else {
                Log.e(str, "setupLogo but next render model null");
            }
        } else {
            setupLogo(rootRenderModel, logoInfo);
        }
    }

    /* access modifiers changed from: private */
    public final void setupFilter(FilterInfo[] filterInfoArr) {
        RenderModel rootRenderModel = getRootRenderModel();
        if (rootRenderModel == null) {
            return;
        }
        if (rootRenderModel instanceof BMGCompositeRenderModel) {
            RenderModel prevRenderModel = getPrevRenderModel();
            String str = BMGConstants.TAG;
            if (prevRenderModel != null) {
                setupFilter(getPrevRenderModel(), filterInfoArr, true);
            } else {
                Log.e(str, "setupFilter but prev render model null");
            }
            if (getNextRenderModel() != null) {
                setupFilter(getNextRenderModel(), filterInfoArr, false);
            } else {
                Log.e(str, "setupFilter but next render model null");
            }
        } else {
            setupFilter(rootRenderModel, filterInfoArr, true);
        }
    }
}
