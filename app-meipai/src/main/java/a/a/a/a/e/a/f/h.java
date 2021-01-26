package a.a.a.a.e.a.f;

import a.a.a.a.e.a.g.b;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.CameraPipelineCallback;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;
import java.util.Arrays;

public class h implements CameraPipelineCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CapturePlayerView f577a;

    public h(CapturePlayerView capturePlayerView) {
        this.f577a = capturePlayerView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        CapturePlayerView capturePlayerView = this.f577a;
        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = capturePlayerView.I11L;
        if (bMGCameraPreviewerSessionRender != null) {
            bMGCameraPreviewerSessionRender.onClipRenderInfoChange(capturePlayerView.getClipRenderInfo(), this.f577a.ILil.isApplyMultiView());
        }
    }

    public void onCameraMultiviewTrackError(int i2, int i3, double d2) {
        MediaLogger mediaLogger = CapturePlayerView.LL1IL;
        StringBuilder sb = new StringBuilder();
        sb.append("onCameraMultiviewTrackError() called with: type = [");
        sb.append(i2);
        sb.append("], errorCode = [");
        sb.append(i3);
        sb.append("]");
        mediaLogger.d(sb.toString());
    }

    public void onCameraMultiviewTrackInfo(float[] fArr, double d2) {
        MediaLogger mediaLogger = CapturePlayerView.LL1IL;
        StringBuilder a2 = a.a("onCameraMultiviewTrackInfo() called with: quaternion = [");
        a2.append(Arrays.toString(fArr));
        a2.append("]");
        mediaLogger.d(a2.toString());
        this.f577a.Lil = fArr;
    }

    public void onCameraRotation(int i2) {
        boolean z;
        if (this.f577a.ILil.isAutoRotateEnable()) {
            if (this.f577a.IL1Iii.getAssetInfo().isSelfie.booleanValue() && i2 != -1) {
                i2 += HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                if (i2 >= 360) {
                    i2 -= 360;
                }
            }
            if (i2 == this.f577a.IL1Iii.getRotateDegree() || i2 == -1) {
                z = false;
            } else {
                z = true;
                this.f577a.IL1Iii.setRotateDegree(i2);
                this.f577a.f70lLi1LL.e();
                CapturePlayerView capturePlayerView = this.f577a;
                if (capturePlayerView != null) {
                    if (capturePlayerView.IL1Iii.isRotateEnabled() && this.f577a.IL1Iii.getFileType() == FileType.UNPANORAMA) {
                        this.f577a.iIlLiL.offer(new c(this));
                    }
                    b bVar = this.f577a.f64LlLLL;
                    if (bVar != null) {
                        bVar.a(i2);
                    }
                } else {
                    throw null;
                }
            }
            this.f577a.post(new b(this, z));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreateCameraPipeline(com.arashivision.onestream.pipeline.ICameraPreviewPipeline r20) {
        /*
            r19 = this;
            r0 = r19
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView.LL1IL
            java.lang.String r2 = "onCreateCameraPipeline"
            r1.d(r2)
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r1 = r0.f577a
            r2 = r20
            r1.f73l = r2
            com.arashivision.insta360.basemedia.ui.player.capture.ICaptureParams r1 = r1.IL1Iii
            com.arashivision.insta360.basemedia.model.FileType r1 = r1.getFileType()
            com.arashivision.insta360.basemedia.model.FileType r2 = com.arashivision.insta360.basemedia.model.FileType.FISH_EYE
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0059
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r1 = r0.f577a
            com.arashivision.insta360.basemedia.ui.player.capture.ICaptureParams r1 = r1.IL1Iii
            com.arashivision.insta360.basemedia.model.viewconstraint.Constraint r1 = r1.getConstraint()
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r2 = r0.f577a
            com.arashivision.insta360.basemedia.ui.player.capture.ICaptureParams r2 = r2.IL1Iii
            int[] r2 = r2.getConstraintRatio()
            if (r1 == 0) goto L_0x0059
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r5 = r0.f577a
            com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender r6 = r5.I11L
            float r5 = r1.getDefaultDistance()
            double r9 = (double) r5
            float r5 = r1.getDefaultFov()
            double r11 = (double) r5
            r5 = r2[r3]
            float r5 = (float) r5
            r2 = r2[r4]
            float r2 = (float) r2
            float r5 = r5 / r2
            double r13 = (double) r5
            float r2 = r1.getXScale()
            double r7 = (double) r2
            float r1 = r1.getYScale()
            double r1 = (double) r1
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r17 = r7
            r7 = r15
            r15 = r17
            r17 = r1
            r6.setGyroStabilizerFovDistance2(r7, r9, r11, r13, r15, r17)
        L_0x0059:
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r1 = r0.f577a
            r1.setLoading(r4)
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r1 = r0.f577a
            if (r1 == 0) goto L_0x00cf
            com.arashivision.insta360.basemedia.ui.player.capture.IPlayCaptureParams r2 = r1.ILil
            if (r2 == 0) goto L_0x006d
            com.arashivision.insta360.basemedia.ui.player.capture.CameraRenderSurfaceInfo r2 = r2.getCameraRenderSurfaceInfo()
            if (r2 == 0) goto L_0x006d
            r4 = r3
        L_0x006d:
            if (r4 != 0) goto L_0x0077
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView.LL1IL
            java.lang.String r2 = "startCameraRenderSurface return. Custom surface is null"
        L_0x0073:
            r1.e(r2)
            goto L_0x00c5
        L_0x0077:
            com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender r2 = r1.I11L
            if (r2 != 0) goto L_0x0080
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView.LL1IL
            java.lang.String r2 = "startCameraRenderSurface return. Render is null"
            goto L_0x0073
        L_0x0080:
            boolean r2 = r1.llliI
            if (r2 == 0) goto L_0x0089
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView.LL1IL
            java.lang.String r2 = "startCameraRenderSurface return. Already render surface"
            goto L_0x0073
        L_0x0089:
            com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender$CameraRenderSurfaceInfo r2 = new com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender$CameraRenderSurfaceInfo
            r2.<init>()
            com.arashivision.insta360.basemedia.ui.player.capture.IPlayCaptureParams r4 = r1.ILil
            com.arashivision.insta360.basemedia.ui.player.capture.CameraRenderSurfaceInfo r4 = r4.getCameraRenderSurfaceInfo()
            int r4 = r4.renderWidth
            r2.renderWidth = r4
            com.arashivision.insta360.basemedia.ui.player.capture.IPlayCaptureParams r4 = r1.ILil
            com.arashivision.insta360.basemedia.ui.player.capture.CameraRenderSurfaceInfo r4 = r4.getCameraRenderSurfaceInfo()
            int r4 = r4.renderHeight
            r2.renderHeight = r4
            a.a.a.a.e.a.e.l r4 = r1.f60IL
            com.arashivision.insta360.basemedia.ui.player.capture.IPlayCaptureParams r5 = r1.ILil
            int r5 = r5.getRenderModelType()
            com.arashivision.graphicpath.render.rendermodel.RenderModelType r4 = r4.a(r5)
            int r4 = r4.getType()
            r2.renderModeType = r4
            com.arashivision.insta360.basemedia.ui.player.capture.IPlayCaptureParams r4 = r1.ILil
            com.arashivision.insta360.basemedia.ui.player.capture.CameraRenderSurfaceInfo r4 = r4.getCameraRenderSurfaceInfo()
            android.view.Surface r4 = r4.mSurface
            r2.mSurface = r4
            com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender r4 = r1.I11L
            r4.startCameraRenderSurface(r2)
            r1.llliI = r3
        L_0x00c5:
            com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView r1 = r0.f577a
            com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener r1 = r1.f741
            if (r1 == 0) goto L_0x00ce
            r1.onLoadingFinish()
        L_0x00ce:
            return
        L_0x00cf:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.f.h.onCreateCameraPipeline(com.arashivision.onestream.pipeline.ICameraPreviewPipeline):void");
    }

    public void onReleaseCameraPipeline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        CapturePlayerView.LL1IL.d("onReleaseCameraPipeline");
        CapturePlayerView capturePlayerView = this.f577a;
        if (capturePlayerView.f73l == iCameraPreviewPipeline) {
            capturePlayerView.f73l = null;
        }
    }

    public void onUpdateHistogram(int[] iArr) {
        b bVar = this.f577a.f64LlLLL;
        if (bVar != null) {
            bVar.onUpdateHistogram(iArr);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            this.f577a.ILil();
        }
        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.f577a.I11L;
        if (bMGCameraPreviewerSessionRender != null) {
            bMGCameraPreviewerSessionRender.setGyroCountForRotation(100);
        }
    }
}
