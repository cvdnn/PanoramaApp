package com.arashivision.arvbmg.util;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo.RenderRect;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.PlaneVisibleRect;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.rendermodel.BMGCompositeRenderModel;
import com.arashivision.arvbmg.render.rendermodel.BMGCompositeSetup;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.render.engine.OrthographicCamera;
import com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel;
import com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;
import com.arashivision.graphicpath.render.rendermodel.SphereRenderModel;
import com.arashivision.insbase.joml.Matrix4f;
import e.a.a.a.a;

public class RenderModelUtil {

    public enum FilterMode {
        FILTER_MODE_SET_ALL,
        FILTER_MODE_DISCARD_WATERMARK,
        FILTER_MODE_ONLY_WATERMARK
    }

    public static BMGCompositeRenderModel createCompositeRenderModel(LottieSetupInfo lottieSetupInfo) {
        return createCompositeRenderModel(lottieSetupInfo, (RenderModel) new PlaneRenderModel(null), (RenderModel) new PlaneRenderModel(null), (VideoSampleGroup) null, (RenderLifecycle) null, false);
    }

    public static final RenderModel createMultiViewRenderModel(ClipRenderInfo clipRenderInfo, RenderLifecycle renderLifecycle) {
        if (clipRenderInfo.getMultiViewInfo() != null) {
            return createCompositeRenderModel(createRootRenderModel(clipRenderInfo, null, FilterMode.FILTER_MODE_DISCARD_WATERMARK), createRootRenderModel(clipRenderInfo.getMultiViewInfo().mClipRenderInfo, null), renderLifecycle, clipRenderInfo.getMultiViewInfo().mMultiViewRectInfo, clipRenderInfo.getFilterInfos(), false);
        }
        throw new IllegalArgumentException("createMultiViewRenderModel but multiview info null");
    }

    public static final RenderModel createRootRenderModel(ClipRenderInfo clipRenderInfo, RenderLifecycle renderLifecycle) {
        return createRootRenderModel(clipRenderInfo, renderLifecycle, FilterMode.FILTER_MODE_SET_ALL);
    }

    public static final void setPlaneDisplayRectInternal(PlaneStitchingRenderModel planeStitchingRenderModel, PlaneVisibleRect planeVisibleRect) {
        planeVisibleRect.printInfo();
        OrthographicCamera orthographicCamera = planeStitchingRenderModel.getOrthographicCamera();
        orthographicCamera.setLeft(planeVisibleRect.mRectLeft);
        orthographicCamera.setTop(planeVisibleRect.mRectTop);
        orthographicCamera.setRight(planeVisibleRect.mRectRight);
        orthographicCamera.setBottom(planeVisibleRect.mRectBottom);
    }

    public static final void setPlaneSphereRotationInternal(PlaneStitchingRenderModel planeStitchingRenderModel, Matrix4f matrix4f) {
        planeStitchingRenderModel.setSphereRotation(matrix4f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0259 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0256  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setupFilter(com.arashivision.graphicpath.render.rendermodel.RenderModel r12, com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo[] r13, com.arashivision.graphicpath.lifecycle.RenderLifecycle r14, com.arashivision.arvbmg.util.RenderModelUtil.FilterMode r15) {
        /*
            r0 = 0
            if (r13 == 0) goto L_0x02a3
            int r1 = r13.length
            if (r1 <= 0) goto L_0x02a3
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r13.length
            r3 = 0
            r4 = r0
            r5 = r4
        L_0x000f:
            java.lang.String r6 = "arvbmg"
            if (r3 >= r2) goto L_0x025d
            r7 = r13[r3]
            java.lang.String r8 = r7.getFilterName()
            java.util.Map r7 = r7.getFilterParams()
            if (r8 == 0) goto L_0x0253
            com.arashivision.arvbmg.util.RenderModelUtil$FilterMode r9 = com.arashivision.arvbmg.util.RenderModelUtil.FilterMode.FILTER_MODE_DISCARD_WATERMARK
            java.lang.String r10 = "watermark_filter"
            if (r15 != r9) goto L_0x0032
            boolean r9 = r8.equals(r10)
            if (r9 == 0) goto L_0x0032
            java.lang.String r7 = "discard watermark filters , lottie?"
            android.util.Log.e(r6, r7)
            goto L_0x0259
        L_0x0032:
            com.arashivision.arvbmg.util.RenderModelUtil$FilterMode r9 = com.arashivision.arvbmg.util.RenderModelUtil.FilterMode.FILTER_MODE_ONLY_WATERMARK
            if (r15 != r9) goto L_0x0057
            boolean r9 = r8.equals(r10)
            if (r9 != 0) goto L_0x0057
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "discard filter name "
            r7.append(r9)
            r7.append(r8)
            java.lang.String r8 = " when only watermark mode"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r6, r7)
            goto L_0x0259
        L_0x0057:
            java.lang.String r9 = "beautify"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x007b
            java.lang.String r6 = "level"
            java.lang.Object r8 = r7.get(r6)
            if (r8 == 0) goto L_0x0072
            java.lang.Object r6 = r7.get(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            goto L_0x0074
        L_0x0072:
            int r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.BeautyParam.LEVEL_MAX
        L_0x0074:
            com.arashivision.graphicpath.render.filter.BeautifyFilter r7 = new com.arashivision.graphicpath.render.filter.BeautifyFilter
            r7.<init>(r6, r14)
            goto L_0x0254
        L_0x007b:
            java.lang.String r9 = "alpha blend"
            boolean r11 = r8.equals(r9)
            if (r11 == 0) goto L_0x00b3
            java.lang.Object r8 = r7.get(r9)
            if (r8 == 0) goto L_0x0094
            java.lang.Object r8 = r7.get(r9)
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L_0x0096
        L_0x0094:
            float r8 = com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.AlphaBlendParam.ALPHA_MAX
        L_0x0096:
            java.lang.String r9 = "backgroundImage"
            java.lang.Object r7 = r7.get(r9)
            com.arashivision.graphicpath.render.source.ImageAsset r7 = (com.arashivision.graphicpath.render.source.ImageAsset) r7
            if (r7 != 0) goto L_0x00a5
            java.lang.String r9 = "bgImgAsset not set, can't apply alpha_blend filter"
            android.util.Log.e(r6, r9)
        L_0x00a5:
            com.arashivision.graphicpath.render.filter.AlphaBlendFilter r6 = new com.arashivision.graphicpath.render.filter.AlphaBlendFilter
            r6.<init>(r14)
            r6.setAlpha(r8)
            r6.setInputBackgroundImage(r7)
            r7 = r6
            goto L_0x0254
        L_0x00b3:
            java.lang.String r9 = "lut_filter"
            boolean r11 = r8.equals(r9)
            if (r11 == 0) goto L_0x00d6
            java.lang.String r6 = "lut_dimension"
            java.lang.Object r6 = r7.get(r6)
            float[] r6 = (float[]) r6
            java.lang.String r8 = "lut_data"
            java.lang.Object r7 = r7.get(r8)
            byte[] r7 = (byte[]) r7
            com.arashivision.arvbmg.render.filter.LutFilter r8 = new com.arashivision.arvbmg.render.filter.LutFilter
            r8.<init>(r14, r9)
            r8.setLut(r6, r7)
        L_0x00d3:
            r7 = r8
            goto L_0x0254
        L_0x00d6:
            java.lang.String r9 = "lut_style_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0108
            java.lang.String r6 = "lut_style_dimension"
            java.lang.Object r6 = r7.get(r6)
            float[] r6 = (float[]) r6
            java.lang.String r8 = "lut_style_data"
            java.lang.Object r8 = r7.get(r8)
            byte[] r8 = (byte[]) r8
            java.lang.String r9 = "lut_style_intensity"
            java.lang.Object r7 = r7.get(r9)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            com.arashivision.arvbmg.render.filter.LutStyleFilter r9 = new com.arashivision.arvbmg.render.filter.LutStyleFilter
            r9.<init>(r14)
            r9.setLut(r6, r8)
            r9.setIntensity(r7)
            r7 = r9
            goto L_0x0254
        L_0x0108:
            java.lang.String r9 = "sketch_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0117
            com.arashivision.arvbmg.render.filter.SketchFilter r7 = new com.arashivision.arvbmg.render.filter.SketchFilter
            r7.<init>(r14)
            goto L_0x0254
        L_0x0117:
            boolean r9 = r8.equals(r10)
            if (r9 == 0) goto L_0x013d
            com.arashivision.arvbmg.render.filter.WaterMarkFilter r8 = new com.arashivision.arvbmg.render.filter.WaterMarkFilter
            r8.<init>(r14)
            java.lang.String r9 = "watermark_imageasset"
            java.lang.Object r9 = r7.get(r9)
            com.arashivision.graphicpath.render.source.ImageAsset r9 = (com.arashivision.graphicpath.render.source.ImageAsset) r9
            if (r9 != 0) goto L_0x0131
            java.lang.String r10 = "render util watermarkImageAsset not set, can't apply watermark filter"
            android.util.Log.e(r6, r10)
        L_0x0131:
            java.lang.String r6 = "watermark_rect"
            java.lang.Object r6 = r7.get(r6)
            float[] r6 = (float[]) r6
            r8.setWaterMark(r9, r6)
            goto L_0x00d3
        L_0x013d:
            java.lang.String r9 = "image_blend_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x015e
            com.arashivision.arvbmg.render.filter.ImageBlendFilter r8 = new com.arashivision.arvbmg.render.filter.ImageBlendFilter
            r8.<init>(r14)
            int r7 = r7.size()
            if (r7 == 0) goto L_0x0157
            java.lang.String r7 = "rendermodelutil ImageBlendFilter but param size not 0"
            android.util.Log.e(r6, r7)
            goto L_0x00d3
        L_0x0157:
            java.lang.String r7 = "rendermodelutil ImageBlendFilter init without param"
            android.util.Log.i(r6, r7)
            goto L_0x00d3
        L_0x015e:
            java.lang.String r9 = "overlay_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x018d
            com.arashivision.arvbmg.render.filter.OverlayFilter r8 = new com.arashivision.arvbmg.render.filter.OverlayFilter
            r8.<init>(r14)
            java.lang.String r9 = "overlay_data"
            java.lang.Object r7 = r7.get(r9)
            com.arashivision.arvbmg.exporter.DashBoardImage r7 = (com.arashivision.arvbmg.exporter.DashBoardImage) r7
            if (r7 != 0) goto L_0x017c
            java.lang.String r7 = "rendermodelutil dashBoardImage not set, can't apply alpha_blend filter"
            android.util.Log.e(r6, r7)
            goto L_0x00d3
        L_0x017c:
            byte[] r6 = r7.getData()
            int r9 = r7.getWidth()
            int r7 = r7.getHeight()
            r8.setOverlayData(r6, r9, r7)
            goto L_0x00d3
        L_0x018d:
            java.lang.String r9 = "color_control_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0216
            com.arashivision.graphicpath.render.filter.ColorControlFilter r4 = new com.arashivision.graphicpath.render.filter.ColorControlFilter
            r4.<init>(r14)
            java.lang.String r8 = "brightness"
            java.lang.Object r9 = r7.get(r8)
            if (r9 == 0) goto L_0x01c3
            java.lang.Object r8 = r7.get(r8)
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r4.setBrightness(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "rendermodelutil brightness "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.i(r6, r8)
        L_0x01c3:
            java.lang.String r8 = "contrast"
            java.lang.Object r9 = r7.get(r8)
            if (r9 == 0) goto L_0x01ec
            java.lang.Object r8 = r7.get(r8)
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "rendermodelutil contrast "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            android.util.Log.i(r6, r9)
            r4.setContrast(r8)
        L_0x01ec:
            java.lang.String r8 = "saturation"
            java.lang.Object r9 = r7.get(r8)
            if (r9 == 0) goto L_0x0253
            java.lang.Object r7 = r7.get(r8)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "rendermodelutil saturation "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r6, r8)
            r4.setSaturation(r7)
            goto L_0x0253
        L_0x0216:
            java.lang.String r9 = "sharpness_filter"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x024d
            com.arashivision.graphicpath.render.filter.SharpnessFilter r5 = new com.arashivision.graphicpath.render.filter.SharpnessFilter
            r5.<init>(r14)
            java.lang.String r8 = "sharpness"
            java.lang.Object r9 = r7.get(r8)
            if (r9 == 0) goto L_0x0253
            java.lang.Object r7 = r7.get(r8)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "rendermodelutil sharpness "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r6, r8)
            r5.setSharpness(r7)
            goto L_0x0253
        L_0x024d:
            com.arashivision.arvbmg.render.filter.MeituFilter r7 = new com.arashivision.arvbmg.render.filter.MeituFilter
            r7.<init>(r8, r14)
            goto L_0x0254
        L_0x0253:
            r7 = r0
        L_0x0254:
            if (r7 == 0) goto L_0x0259
            r1.add(r7)
        L_0x0259:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x025d:
            if (r4 == 0) goto L_0x0262
            r1.add(r4)
        L_0x0262:
            if (r5 == 0) goto L_0x0267
            r1.add(r5)
        L_0x0267:
            r12.setPostFilters(r1)
            boolean r12 = r1.isEmpty()
            if (r12 != 0) goto L_0x0298
            java.util.Iterator r12 = r1.iterator()
        L_0x0274:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0298
            java.lang.Object r13 = r12.next()
            com.arashivision.graphicpath.render.filter.FilterObject r13 = (com.arashivision.graphicpath.render.filter.FilterObject) r13
            java.lang.String r14 = "free oldFilter name "
            java.lang.StringBuilder r14 = e.a.a.a.a.a(r14)
            java.lang.String r15 = r13.getName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            android.util.Log.i(r6, r14)
            r13.free()
            goto L_0x0274
        L_0x0298:
            if (r4 == 0) goto L_0x029d
            r4.free()
        L_0x029d:
            if (r5 == 0) goto L_0x02a6
            r5.free()
            goto L_0x02a6
        L_0x02a3:
            r12.setPostFilter(r0)
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.util.RenderModelUtil.setupFilter(com.arashivision.graphicpath.render.rendermodel.RenderModel, com.arashivision.arvbmg.previewer.ClipRenderInfo$FilterInfo[], com.arashivision.graphicpath.lifecycle.RenderLifecycle, com.arashivision.arvbmg.util.RenderModelUtil$FilterMode):void");
    }

    public static final void setupLogo(RenderModel renderModel, LogoInfo logoInfo, RenderLifecycle renderLifecycle) {
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

    public static final void updateCameraFacingInternal(RenderModel renderModel, int i2) {
        if (i2 != -1) {
            boolean z = renderModel instanceof PlaneStitchingRenderModel;
            String str = BMGConstants.TAG;
            if (!z && !(renderModel instanceof SphereRenderModel)) {
                StringBuilder a2 = a.a("RenderModelUtil update camera facing not support:");
                a2.append(renderModel.toString());
                Log.i(str, a2.toString());
            } else if (i2 == 0 || i2 == 1) {
                renderModel.updateDefaultFacing(i2);
            } else {
                a.c("RenderModelUtil update camera facing error cameraFacing:", i2, str);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v22, types: [com.arashivision.graphicpath.render.rendermodel.SphereRenderModel] */
    /* JADX WARNING: type inference failed for: r2v28, types: [com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.arashivision.graphicpath.render.rendermodel.RenderModel createRootRenderModel(com.arashivision.arvbmg.previewer.ClipRenderInfo r10, com.arashivision.graphicpath.lifecycle.RenderLifecycle r11, com.arashivision.arvbmg.util.RenderModelUtil.FilterMode r12) {
        /*
            com.arashivision.graphicpath.render.rendermodel.RenderModelType r0 = new com.arashivision.graphicpath.render.rendermodel.RenderModelType
            int r1 = r10.getModelType()
            java.lang.String r2 = r10.getOffset()
            r0.<init>(r1, r2)
            int r1 = r10.getImageLayout()
            r0.setImageLayoutValue(r1)
            int r1 = r10.getPlaneRotationDegreee()
            r0.setPlaneRotationDegree(r1)
            int r1 = r10.getSphereSlices()
            if (r1 <= 0) goto L_0x0028
            int r1 = r10.getSphereSlices()
            r0.setSphereSlices(r1)
        L_0x0028:
            int r1 = r10.getSphereStacks()
            if (r1 <= 0) goto L_0x0035
            int r1 = r10.getSphereStacks()
            r0.setSphereStacks(r1)
        L_0x0035:
            r1 = 0
            com.arashivision.graphicpath.render.util.Stabilizer r2 = r10.getStabilizer()
            r3 = 1
            r4 = 0
            java.lang.String r5 = "arvbmg"
            if (r2 == 0) goto L_0x005e
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r1 = r10.getStabilizingType()
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r2 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.DYNAMIC_VERTEX
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0055
            java.lang.String r2 = "RenderModelUtil prefer dynamic true"
            android.util.Log.i(r5, r2)
            r0.setPreferDynamic(r3)
            goto L_0x0061
        L_0x0055:
            java.lang.String r2 = "RenderModelUtil prefer dynamic false"
            android.util.Log.i(r5, r2)
            r0.setPreferDynamic(r4)
            goto L_0x0061
        L_0x005e:
            r0.setPreferDynamic(r4)
        L_0x0061:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r2 = r10.getDynamicStitchType()
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.OFF
            boolean r6 = r2.equals(r6)
            r7 = 3
            r8 = 2
            if (r6 == 0) goto L_0x0078
            java.lang.String r2 = "RenderModelUtil dynamic stitch undefined"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r4)
            goto L_0x00aa
        L_0x0078:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.IMAGE
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0089
            java.lang.String r2 = "RenderModelUtil dynamic stitch image"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r3)
            goto L_0x00aa
        L_0x0089:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.VIDEO
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x009a
            java.lang.String r2 = "RenderModelUtil dynamic stitch video"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r8)
            goto L_0x00aa
        L_0x009a:
            com.arashivision.arvbmg.previewer.ClipRenderInfo$DynamicStitchType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType.TEMPLATE
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "RenderModelUtil dynamic stitch template"
            android.util.Log.i(r5, r2)
            r0.setDynamicStitchType(r7)
        L_0x00aa:
            int r2 = r10.getContentMode()
            r6 = -1
            if (r2 == r6) goto L_0x00cc
            java.lang.String r2 = " RenderModelUtil set content mode "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            int r9 = r10.getContentMode()
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r5, r2)
            int r2 = r10.getContentMode()
            r0.setContentMode(r2)
        L_0x00cc:
            boolean r2 = r10.isImageFusion()
            r0.setImageFusionEnable(r2)
            float r2 = r10.getBlendAngleRad()
            r9 = 0
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00e3
            float r2 = r10.getBlendAngleRad()
            r0.setBlendAngleRad(r2)
        L_0x00e3:
            int r2 = r10.getDynamicStitchAccuracyLevel()
            if (r2 == r6) goto L_0x00f0
            int r2 = r10.getDynamicStitchAccuracyLevel()
            r0.setDynamicStitchAccuracyLevel(r2)
        L_0x00f0:
            int r2 = r10.getPovMode()
            if (r2 == r6) goto L_0x00fd
            int r2 = r10.getPovMode()
            r0.setPovMode(r2)
        L_0x00fd:
            int r2 = r10.getHwAccelFlags()
            if (r2 == r6) goto L_0x010a
            int r2 = r10.getHwAccelFlags()
            r0.setHwAccelFlags(r2)
        L_0x010a:
            int r2 = r10.getStitchInterval()
            if (r2 == r6) goto L_0x0117
            int r2 = r10.getStitchInterval()
            r0.setStitchInterval(r2)
        L_0x0117:
            boolean r2 = r10.isAsyncStitch()
            r0.setAsyncStitch(r2)
            boolean r2 = r10.isColorAdjust()
            r0.setColorAdjustEnable(r2)
            int r2 = r0.getType()
            r6 = 20
            if (r2 != r6) goto L_0x0134
            com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.PlaneRenderModel
            r2.<init>(r0, r11)
            goto L_0x01c5
        L_0x0134:
            int r2 = r0.getType()
            r6 = 11
            if (r2 == r6) goto L_0x0191
            int r2 = r0.getType()
            r6 = 13
            if (r2 != r6) goto L_0x0145
            goto L_0x0191
        L_0x0145:
            int r2 = r0.getType()
            r6 = 4
            if (r2 == r8) goto L_0x0170
            int r2 = r0.getType()
            if (r2 == r7) goto L_0x0170
            int r2 = r0.getType()
            if (r6 != r2) goto L_0x0159
            goto L_0x0170
        L_0x0159:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "renderModelUtil no render model for type "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11)
            int r12 = r0.getType()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0170:
            java.lang.String r2 = r10.getOffset()
            if (r2 != 0) goto L_0x0187
            int r2 = r0.getType()
            if (r2 == r8) goto L_0x0182
            int r2 = r0.getType()
            if (r6 != r2) goto L_0x0187
        L_0x0182:
            java.lang.String r2 = "RenderModelUtil no offset for sphere stitch"
            android.util.Log.e(r5, r2)
        L_0x0187:
            com.arashivision.graphicpath.render.rendermodel.SphereRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.SphereRenderModel
            com.arashivision.graphicpath.render.base.BaseCameraController r6 = r10.getBaseCameraController()
            r2.<init>(r0, r6, r3, r11)
            goto L_0x01c5
        L_0x0191:
            java.lang.String r2 = r10.getOffset()
            if (r2 != 0) goto L_0x019c
            java.lang.String r2 = " RenderModelUtil no offset for plane stitch"
            android.util.Log.e(r5, r2)
        L_0x019c:
            com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel r2 = new com.arashivision.graphicpath.render.rendermodel.PlaneStitchingRenderModel
            r2.<init>(r0, r11)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$PlaneVisibleRect r6 = r10.getPlaneVisibleRect()
            if (r6 == 0) goto L_0x01b3
            java.lang.String r6 = "RenderModelUtil setPlaneDisplayRectInternal when init "
            android.util.Log.i(r5, r6)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$PlaneVisibleRect r6 = r10.getPlaneVisibleRect()
            setPlaneDisplayRectInternal(r2, r6)
        L_0x01b3:
            com.arashivision.insbase.joml.Matrix4f r6 = r10.getPlaneRotateMatrix()
            if (r6 == 0) goto L_0x01c5
            java.lang.String r6 = "setPlaneSphereRotationInternal when init "
            android.util.Log.i(r5, r6)
            com.arashivision.insbase.joml.Matrix4f r6 = r10.getPlaneRotateMatrix()
            setPlaneSphereRotationInternal(r2, r6)
        L_0x01c5:
            boolean r6 = r2.hasStabilizerFeature()
            if (r6 == 0) goto L_0x0219
            com.arashivision.graphicpath.render.util.Stabilizer r6 = r10.getStabilizer()
            r2.setStabilizer(r6)
            com.arashivision.graphicpath.render.util.Stabilizer r6 = r10.getStabilizer()
            if (r6 != 0) goto L_0x01dc
            r2.enableStabilizerFeature(r4)
            goto L_0x0219
        L_0x01dc:
            if (r1 == 0) goto L_0x0202
            com.arashivision.arvbmg.previewer.ClipRenderInfo$StabilizingType r6 = com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType.NO
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x01ea
            r2.enableStabilizerFeature(r4)
            goto L_0x0219
        L_0x01ea:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "RenderModelUtil enable stabilizer, type: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.i(r5, r1)
            r2.enableStabilizerFeature(r3)
            goto L_0x0219
        L_0x0202:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "stabilizingType null renderModelType "
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11)
            java.lang.String r12 = r0.toString()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0219:
            java.lang.String r1 = "RenderModelUtil set render model "
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.i(r5, r0)
            int r0 = r10.getCameraFacing()
            updateCameraFacingInternal(r2, r0)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$LogoInfo r0 = r10.getLogoInfo()
            setupLogo(r2, r0, r11)
            com.arashivision.arvbmg.previewer.ClipRenderInfo$FilterInfo[] r10 = r10.getFilterInfos()
            setupFilter(r2, r10, r11, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.arvbmg.util.RenderModelUtil.createRootRenderModel(com.arashivision.arvbmg.previewer.ClipRenderInfo, com.arashivision.graphicpath.lifecycle.RenderLifecycle, com.arashivision.arvbmg.util.RenderModelUtil$FilterMode):com.arashivision.graphicpath.render.rendermodel.RenderModel");
    }

    public static BMGCompositeRenderModel createCompositeRenderModel(LottieSetupInfo lottieSetupInfo, RenderModel renderModel, RenderModel renderModel2, VideoSampleGroup videoSampleGroup, RenderLifecycle renderLifecycle, boolean z) {
        BMGCompositeSetup bMGCompositeSetup = new BMGCompositeSetup(renderModel, renderModel2, videoSampleGroup, z);
        RenderRect renderRect = lottieSetupInfo.mRenderRect;
        if (renderRect != null) {
            bMGCompositeSetup.setRenderRect(renderRect);
            BMGCompositeRenderModel bMGCompositeRenderModel = new BMGCompositeRenderModel(bMGCompositeSetup, renderLifecycle);
            setupFilter(bMGCompositeRenderModel, lottieSetupInfo.mFilterInfos, renderLifecycle, FilterMode.FILTER_MODE_ONLY_WATERMARK);
            return bMGCompositeRenderModel;
        }
        throw new IllegalArgumentException("lottieSetupInfo.mRenderRect null");
    }

    public static BMGCompositeRenderModel createCompositeRenderModel(RenderModel renderModel, RenderModel renderModel2, RenderLifecycle renderLifecycle, int i2) {
        return new BMGCompositeRenderModel(new BMGCompositeSetup(renderModel, renderModel2, i2), renderLifecycle);
    }

    public static BMGCompositeRenderModel createCompositeRenderModel(RenderModel renderModel, RenderModel renderModel2, RenderLifecycle renderLifecycle, MultiViewRectInfo multiViewRectInfo, FilterInfo[] filterInfoArr, boolean z) {
        BMGCompositeRenderModel bMGCompositeRenderModel = new BMGCompositeRenderModel(new BMGCompositeSetup(renderModel, renderModel2, multiViewRectInfo, z), renderLifecycle);
        if (filterInfoArr != null) {
            Log.i(BMGConstants.TAG, "createCompositeRenderModel for multiview export?");
        }
        setupFilter(bMGCompositeRenderModel, filterInfoArr, renderLifecycle, FilterMode.FILTER_MODE_ONLY_WATERMARK);
        return bMGCompositeRenderModel;
    }
}
