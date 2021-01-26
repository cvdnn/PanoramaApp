package com.arashivision.insta360.basemedia.ui.player.capture;

import a.a.a.a.b.a;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.i;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.f.h;
import a.a.a.a.e.a.g.b;
import a.a.a.a.e.a.l.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.GyroSlideInfo;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.MultiviewTrackInfo;
import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.OnlineStabilizerInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.MultiViewInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.StabilizingType;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo.Rect;
import com.arashivision.arvbmg.render.camera.GestureController;
import com.arashivision.arvbmg.render.camera.GestureController.OnGestureChangeListener;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.ui.GraphicView;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.insta360.basemedia.util.EventIdUtils;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidubce.auth.NTLMEngineImpl;
import d.p.e;
import d.p.g;
import e.b.c.b.b.a.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CapturePlayerView extends FrameLayout implements g {
    public static final MediaLogger LL1IL = MediaLogger.getLogger(CapturePlayerView.class);
    public BMGCameraPreviewerSessionRender I11L;
    public e I11li1;
    public a.a.a.a.e.a.e.g I1I;
    public ICaptureParams IL1Iii;
    public int ILL;
    public IPlayCaptureParams ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f59ILl;
    public i Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public l f60IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public GestureController f61IiL;
    public float[] Lil;
    public float[] LlLI1 = {0.67f, 0.117f, 0.267f, 0.195f};

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public boolean f62Ll1;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public boolean f63L11I;

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public b f64LlLLL;
    public float[] iIi1;
    public ConcurrentLinkedQueue<Runnable> iIlLiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public f f65iILLL1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public boolean f66lIiI;

    /* renamed from: lI丨II reason: contains not printable characters */
    public IGestureListener f67lIII;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public float[] f68lIlii;
    public boolean llliI;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public boolean f69llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public f f70lLi1LL;

    /* renamed from: 丨il reason: contains not printable characters */
    public volatile int f71il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public GraphicView f72lL;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public ICameraPreviewPipeline f73l;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public IBasePlayerViewListener f741;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        public void run() {
            BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = CapturePlayerView.this.I11L;
            if (bMGCameraPreviewerSessionRender != null) {
                bMGCameraPreviewerSessionRender.updateHistorgram();
            }
            CapturePlayerView.this.postDelayed(this, 500);
        }
    }

    public class ILil implements OnGestureChangeListener {
        public ILil() {
        }

        public void onActionUp() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onUp();
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (CapturePlayerView.this.IL1Iii()) {
                CapturePlayerView capturePlayerView = CapturePlayerView.this;
                capturePlayerView.f70lLi1LL.a(capturePlayerView.f61IiL);
                double a2 = (double) d.a(CapturePlayerView.this.f70lLi1LL.f513b.getPitch(), 0.0f);
                CapturePlayerView.this.f63L11I = a2 <= -1.5707963267948966d || a2 > 1.5707963267948966d;
            }
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                return iGestureListener.onDown(motionEvent);
            }
            return false;
        }

        public void onFlingAnimation() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimation();
            }
        }

        public void onFlingAnimationEnd() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimationEnd();
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onLongPress(motionEvent);
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onScroll();
            }
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                return iGestureListener.onTap(motionEvent);
            }
            return false;
        }

        public void onZoom() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onZoom();
            }
        }

        public void onZoomAnimation() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimation();
            }
        }

        public void onZoomAnimationEnd() {
            IGestureListener iGestureListener = CapturePlayerView.this.f67lIII;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimationEnd();
            }
        }
    }

    public CapturePlayerView(Context context) {
        super(context);
        new IL1Iii();
        m14IL();
    }

    public CapturePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new IL1Iii();
        m14IL();
    }

    public CapturePlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new IL1Iii();
        m14IL();
    }

    @TargetApi(21)
    public CapturePlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        new IL1Iii();
        m14IL();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean IL1Iii(View view, MotionEvent motionEvent) {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams == null || this.f61IiL == null || (iPlayCaptureParams.isApplyMultiView() && IL1Iii(motionEvent))) {
            return true;
        }
        this.f61IiL.onUpdate(motionEvent);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: I丨iL reason: contains not printable characters */
    public /* synthetic */ void m9IiL() {
        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.I11L;
        if (bMGCameraPreviewerSessionRender != null) {
            bMGCameraPreviewerSessionRender.onClipRenderInfoChange(getClipRenderInfo(), this.ILil.isApplyMultiView());
        }
    }

    /* access modifiers changed from: private */
    public ClipRenderInfo getCameraMultViewTrackClipRenderInfo() {
        ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = this.f60IL.a(this.ILil.getRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setImageLayout(this.f60IL.a(false));
        clipRenderInfo.setBaseCameraController(this.f70lLi1LL.f513b);
        clipRenderInfo.setContentMode(this.f60IL.a());
        if (this.ILil.isStabilizeEnabled()) {
            clipRenderInfo.setStabilizingType(StabilizingType.NORMAL);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
            clipRenderInfo.setStabType(this.IL1Iii.getStabType());
        } else {
            clipRenderInfo.setStabilizingType(StabilizingType.NO);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
        }
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(-this.IL1Iii.getRotateDegree());
        }
        clipRenderInfo.setDynamicStitchType(DynamicStitchType.OFF);
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setSphereSlices(50);
        clipRenderInfo.setSphereStacks(25);
        return clipRenderInfo;
    }

    private FilterInfo[] getClipFilterInfos() {
        LayoutParams layoutParams = this.f72lL.getLayoutParams();
        return IL1Iii(layoutParams != null ? layoutParams.width : this.f72lL.getMeasuredWidth(), layoutParams != null ? layoutParams.height : this.f72lL.getMeasuredHeight());
    }

    /* access modifiers changed from: private */
    public synchronized ClipRenderInfo getClipRenderInfo() {
        ClipRenderInfo clipRenderInfo;
        clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = this.f60IL.a(getClipRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setPlaneRotationDegreee(0);
        clipRenderInfo.setImageLayout(this.f60IL.a(false));
        clipRenderInfo.setBaseCameraController(this.f70lLi1LL.f513b);
        clipRenderInfo.setContentMode(this.f60IL.a());
        if (this.ILil.isStabilizeEnabled()) {
            clipRenderInfo.setStabilizingType(StabilizingType.NORMAL);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
            clipRenderInfo.setStabType(this.IL1Iii.getStabType());
        } else {
            clipRenderInfo.setStabilizingType(StabilizingType.NO);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
        }
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(-this.IL1Iii.getRotateDegree());
        }
        clipRenderInfo.setDynamicStitchType(DynamicStitchType.OFF);
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setLogoInfo(this.f60IL.b(isLogoEnabled()));
        clipRenderInfo.setFilterInfos(getClipFilterInfos());
        clipRenderInfo.setSphereSlices(50);
        clipRenderInfo.setSphereStacks(25);
        clipRenderInfo.setMultiViewInfo(getMultiViewInfo());
        return clipRenderInfo;
    }

    private int getClipRenderModelType() {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        boolean z = false;
        if (iPlayCaptureParams == null) {
            LL1IL.e("playCaptureParams is null! Use RenderModelType.Type.AUTO");
            return 0;
        }
        if (iPlayCaptureParams.getCameraRenderSurfaceInfo() != null) {
            z = true;
        }
        if (!z || !this.ILil.isOnlyStitchSurfaceRender()) {
            return this.ILil.getRenderModelType();
        }
        LL1IL.e("ApplyCameraRenderSurface && OnlyStitchSurfaceRender! Use RenderModelType.Type.PLANE");
        return 20;
    }

    private int getGraphicViewBackgroundColor() {
        return Color.parseColor("#000000");
    }

    /* access modifiers changed from: private */
    public ClipRenderInfo getHistogramClipRenderInfo() {
        int i2;
        l lVar;
        ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
        int ordinal = this.IL1Iii.getFileType().ordinal();
        if (ordinal == 2) {
            lVar = this.f60IL;
            i2 = 10;
        } else if (ordinal != 3) {
            lVar = this.f60IL;
            i2 = 20;
        } else {
            lVar = this.f60IL;
            i2 = 1;
        }
        RenderModelType a2 = lVar.a(i2);
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setImageLayout(this.f60IL.a(false));
        if (this.ILil.isStabilizeEnabled()) {
            clipRenderInfo.setStabilizingType(StabilizingType.NORMAL);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
            clipRenderInfo.setStabType(this.IL1Iii.getStabType());
        } else {
            clipRenderInfo.setStabilizingType(StabilizingType.NO);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
        }
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(-this.IL1Iii.getRotateDegree());
        }
        clipRenderInfo.setBaseCameraController(this.f70lLi1LL.f513b);
        clipRenderInfo.setSphereSlices(50);
        clipRenderInfo.setSphereStacks(25);
        return clipRenderInfo;
    }

    /* access modifiers changed from: private */
    public synchronized ClipRenderInfo getLiveClipRenderInfo() {
        ClipRenderInfo clipRenderInfo;
        clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = this.f60IL.a(this.ILil.getLiveRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setPlaneRotationDegreee(0);
        clipRenderInfo.setImageLayout(this.f60IL.a(false));
        clipRenderInfo.setBaseCameraController(this.f70lLi1LL.f513b);
        clipRenderInfo.setContentMode(this.f60IL.a());
        if (this.ILil.isStabilizeEnabled()) {
            clipRenderInfo.setStabilizingType(StabilizingType.NORMAL);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
            clipRenderInfo.setStabType(this.IL1Iii.getStabType());
        } else {
            clipRenderInfo.setStabilizingType(StabilizingType.NO);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
        }
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(-this.IL1Iii.getRotateDegree());
        }
        clipRenderInfo.setDynamicStitchType(DynamicStitchType.OFF);
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setLogoInfo(this.f60IL.b(isLogoEnabled()));
        clipRenderInfo.setFilterInfos(getClipFilterInfos());
        clipRenderInfo.setSphereSlices(50);
        clipRenderInfo.setSphereStacks(25);
        clipRenderInfo.setMultiViewInfo(getMultiViewInfo());
        return clipRenderInfo;
    }

    private MultiViewInfo getMultiViewInfo() {
        if (!this.ILil.isNeedInitMultiView()) {
            return null;
        }
        MultiViewInfo multiViewInfo = new MultiViewInfo();
        ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = this.f60IL.a(getClipRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setPlaneRotationDegreee(0);
        clipRenderInfo.setImageLayout(this.f60IL.a(false));
        clipRenderInfo.setBaseCameraController(this.f65iILLL1.f513b);
        clipRenderInfo.setContentMode(this.f60IL.a());
        if (this.ILil.isStabilizeEnabled()) {
            clipRenderInfo.setStabilizingType(StabilizingType.NORMAL);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
            clipRenderInfo.setStabType(this.IL1Iii.getStabType());
        } else {
            clipRenderInfo.setStabilizingType(StabilizingType.NO);
            clipRenderInfo.setGyroType(this.IL1Iii.getGyroType());
        }
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(-this.IL1Iii.getRotateDegree());
        }
        clipRenderInfo.setDynamicStitchType(DynamicStitchType.OFF);
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setLogoInfo(this.f60IL.b(isLogoEnabled()));
        clipRenderInfo.setSphereSlices(50);
        clipRenderInfo.setSphereStacks(25);
        multiViewInfo.mClipRenderInfo = clipRenderInfo;
        multiViewInfo.mMultiViewRectInfo = getMultiViewRectInfo();
        return multiViewInfo;
    }

    /* access modifiers changed from: private */
    public MultiViewRectInfo getMultiViewRectInfo() {
        Rect rect = new Rect();
        float[] fArr = this.LlLI1;
        rect.mX = fArr[0];
        rect.mY = fArr[1];
        rect.mWidth = fArr[2];
        rect.mHeight = fArr[3];
        return new MultiViewRectInfo(rect, new Rect(), 1, false);
    }

    private OnGestureChangeListener getOnGestureChangeListener() {
        return new ILil();
    }

    private int getRenderBackgroundColor() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public /* synthetic */ void m12iILLL1() {
        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.I11L;
        if (bMGCameraPreviewerSessionRender != null) {
            bMGCameraPreviewerSessionRender.onUpdateMultiviewInfo(getMultiViewRectInfo());
        }
    }

    /* access modifiers changed from: private */
    public void setLoading(boolean z) {
        MediaLogger mediaLogger = LL1IL;
        StringBuilder sb = new StringBuilder();
        sb.append("setLoading ");
        sb.append(z);
        mediaLogger.d(sb.toString());
        this.f62Ll1 = z;
        IBasePlayerViewListener iBasePlayerViewListener = this.f741;
        if (iBasePlayerViewListener != null) {
            iBasePlayerViewListener.onLoadingStatusChanged();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void I1I() {
        c cVar = new c(this);
        setOnTouchListener(cVar);
        GraphicView graphicView = new GraphicView(getContext());
        this.f72lL = graphicView;
        graphicView.setBackgroundColor(getGraphicViewBackgroundColor());
        this.f72lL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f72lL.setOnTouchListener(cVar);
        addView(this.f72lL, 0);
        this.Ilil.a((FrameLayout) this);
    }

    public final boolean IL1Iii() {
        f fVar = this.f70lLi1LL;
        return fVar != null && fVar.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0026, code lost:
        if (r9 != 3) goto L_0x00db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean IL1Iii(android.view.MotionEvent r9) {
        /*
            r8 = this;
            float r0 = r9.getX()
            com.arashivision.graphicpath.ui.GraphicView r1 = r8.f72lL
            int r1 = r1.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
            float r1 = r9.getY()
            com.arashivision.graphicpath.ui.GraphicView r2 = r8.f72lL
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r9 = r9.getAction()
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r9 == 0) goto L_0x00a9
            if (r9 == r5) goto L_0x00a2
            if (r9 == r3) goto L_0x002a
            if (r9 == r2) goto L_0x00a2
            goto L_0x00db
        L_0x002a:
            boolean r9 = r8.f69llL1ii
            if (r9 == 0) goto L_0x00db
            monitor-enter(r8)
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            float[] r6 = r8.iIi1     // Catch:{ all -> 0x009f }
            r6 = r6[r4]     // Catch:{ all -> 0x009f }
            float r0 = r0 - r6
            float[] r6 = r8.f68lIlii     // Catch:{ all -> 0x009f }
            r6 = r6[r4]     // Catch:{ all -> 0x009f }
            float r0 = r0 + r6
            r9[r4] = r0     // Catch:{ all -> 0x009f }
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            float[] r0 = r8.iIi1     // Catch:{ all -> 0x009f }
            r0 = r0[r5]     // Catch:{ all -> 0x009f }
            float r1 = r1 - r0
            float[] r0 = r8.f68lIlii     // Catch:{ all -> 0x009f }
            r0 = r0[r5]     // Catch:{ all -> 0x009f }
            float r1 = r1 + r0
            r9[r5] = r1     // Catch:{ all -> 0x009f }
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9 = r9[r4]     // Catch:{ all -> 0x009f }
            r0 = 0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x0058
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9[r4] = r0     // Catch:{ all -> 0x009f }
        L_0x0058:
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9 = r9[r4]     // Catch:{ all -> 0x009f }
            float[] r1 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r1 = r1[r3]     // Catch:{ all -> 0x009f }
            float r9 = r9 + r1
            r1 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 <= 0) goto L_0x0071
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            float[] r6 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r3 = r6[r3]     // Catch:{ all -> 0x009f }
            float r3 = r1 - r3
            r9[r4] = r3     // Catch:{ all -> 0x009f }
        L_0x0071:
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9 = r9[r5]     // Catch:{ all -> 0x009f }
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x007d
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9[r5] = r0     // Catch:{ all -> 0x009f }
        L_0x007d:
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r9 = r9[r5]     // Catch:{ all -> 0x009f }
            float[] r0 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r0 = r0[r2]     // Catch:{ all -> 0x009f }
            float r9 = r9 + r0
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 <= 0) goto L_0x0093
            float[] r9 = r8.LlLI1     // Catch:{ all -> 0x009f }
            float[] r0 = r8.LlLI1     // Catch:{ all -> 0x009f }
            r0 = r0[r2]     // Catch:{ all -> 0x009f }
            float r1 = r1 - r0
            r9[r5] = r1     // Catch:{ all -> 0x009f }
        L_0x0093:
            monitor-exit(r8)     // Catch:{ all -> 0x009f }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r9 = r8.iIlLiL
            e.b.c.b.b.a.a.a r0 = new e.b.c.b.b.a.a.a
            r0.<init>(r8)
            r9.offer(r0)
            return r5
        L_0x009f:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x009f }
            throw r9
        L_0x00a2:
            boolean r9 = r8.f69llL1ii
            if (r9 == 0) goto L_0x00db
            r8.f69llL1ii = r4
            return r5
        L_0x00a9:
            float[] r9 = r8.LlLI1
            r6 = r9[r4]
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00db
            r6 = r9[r4]
            r7 = r9[r3]
            float r6 = r6 + r7
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x00db
            r6 = r9[r5]
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00db
            r6 = r9[r5]
            r2 = r9[r2]
            float r6 = r6 + r2
            int r2 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00db
            r8.f69llL1ii = r5
            int r2 = r9.length
            float[] r9 = java.util.Arrays.copyOf(r9, r2)
            r8.f68lIlii = r9
            float[] r9 = new float[r3]
            r9[r4] = r0
            r9[r5] = r1
            r8.iIi1 = r9
            return r5
        L_0x00db:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView.IL1Iii(android.view.MotionEvent):boolean");
    }

    public final FilterInfo[] IL1Iii(int i2, int i3) {
        FilterInfo filterInfo = null;
        FilterInfo[] a2 = this.f60IL.a(false, (BlendImageInfo) null);
        if (this.I1I.a(this.ILil.isApplyWatermark())) {
            filterInfo = this.I1I.a(i2, i3, this.ILil.isApplyWatermark());
        }
        return a.a(a2, filterInfo);
    }

    public final void ILil() {
        GraphicView graphicView = this.f72lL;
        if (graphicView != null) {
            graphicView.setLayoutParams(getGraphicViewLayoutParams());
            LayoutParams layoutParams = this.f72lL.getLayoutParams();
            BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.I11L;
            if (bMGCameraPreviewerSessionRender != null) {
                bMGCameraPreviewerSessionRender.onFilterChanged(IL1Iii(layoutParams.width, layoutParams.height));
            }
        }
        i iVar = this.Ilil;
        if (iVar != null) {
            iVar.a(getGraphicViewLayoutParams());
        }
    }

    public final boolean Ilil() {
        boolean z = this.f71il >= 0 && this.ILL == this.f71il;
        if (!z) {
            LL1IL.w("playId is not matched, maybe player is destroyed?");
        }
        return z;
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public final void m14IL() {
        m15lLi1LL();
    }

    public void destroyResources() {
        destroyResources(false);
    }

    public void destroyResources(boolean z) {
        LL1IL.d("destroyResources");
        BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.I11L;
        if (bMGCameraPreviewerSessionRender != null) {
            if (this.llliI) {
                bMGCameraPreviewerSessionRender.stopCameraRenderSurface();
            }
            this.llliI = false;
            this.I11L.terminate();
            this.I11L = null;
        }
        this.f73l = null;
        GraphicView graphicView = this.f72lL;
        if (graphicView != null) {
            removeView(graphicView);
            this.f72lL.destroy();
            this.f72lL = null;
        }
        i iVar = this.Ilil;
        if (iVar != null) {
            iVar.a();
            this.Ilil = null;
        }
        GestureController gestureController = this.f61IiL;
        if (gestureController != null) {
            gestureController.destroy();
            this.f61IiL = null;
        }
        if (this.I1I != null) {
            this.I1I = null;
        }
        if (this.f60IL != null) {
            this.f60IL = null;
        }
        f fVar = this.f70lLi1LL;
        if (fVar != null) {
            fVar.c();
            this.f70lLi1LL = null;
        }
        f fVar2 = this.f65iILLL1;
        if (fVar2 != null) {
            fVar2.c();
            this.f65iILLL1 = null;
        }
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams != null) {
            iCaptureParams.cancelStabilizer();
        }
        m15lLi1LL();
        if (z) {
            this.IL1Iii = null;
            this.ILil = null;
        }
    }

    public int getBeautyFilterLevel() {
        l lVar = this.f60IL;
        if (lVar != null) {
            return lVar.f533a.getBeautyFilterLevel();
        }
        return 0;
    }

    public Transform getCameraTransform() {
        f fVar = this.f70lLi1LL;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    public ICaptureParams getCaptureParams() {
        return this.IL1Iii;
    }

    public List<a.a.a.a.e.a.h.a> getExtraViewControllerList() {
        return this.Ilil != null ? new ArrayList(this.Ilil.f530g) : new ArrayList();
    }

    public FrameLayout.LayoutParams getGraphicViewLayoutParams() {
        int[] iArr;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams != null) {
            iArr = d.a(iCaptureParams.getScreenRatio(), this.IL1Iii.isRotateScreenRatioEnabled() && d.a(this.IL1Iii.isRotateEnabled(), this.IL1Iii.getRotateDegree()));
        } else {
            iArr = null;
        }
        if (iArr == null || Arrays.equals(iArr, new int[]{-1, -1})) {
            layoutParams.width = getMeasuredWidth();
            layoutParams.height = getMeasuredHeight();
        } else {
            int width = getWidth();
            int height = getHeight();
            if ((width / iArr[0]) * iArr[1] > height) {
                layoutParams.width = (iArr[0] * height) / iArr[1];
                layoutParams.height = height;
            } else {
                layoutParams.width = width;
                layoutParams.height = (width * iArr[1]) / iArr[0];
            }
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public String getOffset() {
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams != null) {
            return iCaptureParams.getOffsetForPlay();
        }
        return null;
    }

    public ICameraPreviewPipeline getPipeline() {
        return this.f73l;
    }

    public int getStabType() {
        return this.IL1Iii.getStabType();
    }

    public a.a.a.a.a.g.a getStyleFilter() {
        l lVar = this.f60IL;
        if (lVar != null) {
            return lVar.f533a.getStyleFilter();
        }
        return a.a.a.a.a.g.b.b();
    }

    public float getStyleFilterIntensity() {
        l lVar = this.f60IL;
        if (lVar != null) {
            return lVar.f533a.getStyleFilterIntensity();
        }
        return 1.0f;
    }

    public Transform getViewAngle() {
        if (!IL1Iii()) {
            return null;
        }
        Constraint constraint = this.IL1Iii.getConstraint();
        Vector3f eulerAnglesYXZ = new Quaternionf().getEulerAnglesYXZ(new Vector3f());
        Transform transform = new Transform(eulerAnglesYXZ.y, eulerAnglesYXZ.x, 0.0f, constraint.getDefaultDistance(), constraint.getDefaultFov());
        return transform;
    }

    public boolean isApplyMultiView() {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        return iPlayCaptureParams != null && iPlayCaptureParams.isNeedInitMultiView() && this.ILil.isApplyMultiView();
    }

    public boolean isAutoRotateEnable() {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            return iPlayCaptureParams.isAutoRotateEnable();
        }
        return false;
    }

    public boolean isGestureEnabled() {
        return this.ILil.isGestureEnabled();
    }

    public boolean isGestureHorizontalEnabled() {
        return IL1Iii() && this.ILil.isGestureHorizontalEnabled();
    }

    public boolean isGestureVerticalEnabled() {
        return IL1Iii() && this.ILil.isGestureVerticalEnabled();
    }

    public boolean isGestureZoomEnabled() {
        return IL1Iii() && this.ILil.isGestureZoomEnabled();
    }

    public boolean isLoading() {
        return this.f62Ll1;
    }

    public boolean isLogoEnabled() {
        l lVar = this.f60IL;
        if (lVar != null) {
            return lVar.f533a.isLogoEnabled();
        }
        return false;
    }

    public boolean isStabEnabled() {
        return this.IL1Iii.getStabType() != -1;
    }

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public final void m15lLi1LL() {
        this.f71il = -1;
        this.ILL = -1;
        this.f62Ll1 = false;
        this.f66lIiI = false;
        this.f63L11I = false;
        this.f59ILl = false;
        this.f69llL1ii = false;
        ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = this.iIlLiL;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
            this.iIlLiL = null;
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.f66lIiI) {
            ILil();
            measure(MeasureSpec.makeMeasureSpec(i2, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec(i3, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
        }
    }

    public void play() {
        MediaLogger mediaLogger;
        String str;
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams == null) {
            mediaLogger = LL1IL;
            str = "play, but captureParams is null!";
        } else if (this.ILil == null) {
            mediaLogger = LL1IL;
            str = "play, but playCaptureParams is null!";
        } else if (!a.a(iCaptureParams.getWidth(), this.IL1Iii.getHeight())) {
            LL1IL.e("play, but GPU texture not support!");
            IBasePlayerViewListener iBasePlayerViewListener = this.f741;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onFail(-10003, CapturePlayerView.class.getSimpleName(), "GPU texture not support");
            }
            return;
        } else if (!isLoading()) {
            setLoading(true);
            this.f71il = EventIdUtils.getEventId();
            int i2 = this.f71il;
            this.iIlLiL = new ConcurrentLinkedQueue<>();
            this.I1I = new a.a.a.a.e.a.e.g(this.IL1Iii);
            ICaptureParams iCaptureParams2 = this.IL1Iii;
            this.f60IL = new l(iCaptureParams2, iCaptureParams2);
            f fVar = new f();
            this.f70lLi1LL = fVar;
            fVar.a((a.a.a.a.e.a.e.k.b) this.IL1Iii);
            this.f70lLi1LL.a(new BaseCameraController());
            this.f70lLi1LL.f514c = true;
            this.f65iILLL1 = new f();
            this.f65iILLL1.a((a.a.a.a.e.a.e.k.b) this.IL1Iii.clone());
            this.f65iILLL1.a(new BaseCameraController());
            i iVar = new i();
            this.Ilil = iVar;
            ICaptureParams iCaptureParams3 = this.IL1Iii;
            iVar.f524a = iCaptureParams3;
            MultiviewTrackInfo multiviewTrackInfo = null;
            boolean z = false;
            iVar.a((a.a.a.a.e.a.d) iCaptureParams3, (a.a.a.a.e.a.g.d) null, false);
            if (!this.f66lIiI) {
                LL1IL.d("createResources");
                I1I();
                ILil();
                Options options = new Options();
                if (a.b()) {
                    options.setBool(2, this.ILil.isCopyVideoHwaccel());
                } else {
                    options.setBool(2, true);
                }
                OnlineStabilizerInfo onlineStabilizerInfo = new OnlineStabilizerInfo();
                GyroSlideInfo gyroSlideInfo = new GyroSlideInfo();
                gyroSlideInfo.frameCount = 3;
                gyroSlideInfo.frameDurationInMS = 1000 / this.IL1Iii.getFps();
                gyroSlideInfo.fps = (double) this.IL1Iii.getFps();
                onlineStabilizerInfo.mGyroSlideInfo = gyroSlideInfo;
                onlineStabilizerInfo.mPreviewDeltaNs = this.IL1Iii.getPreviewDelayNs();
                onlineStabilizerInfo.mFilterType = 6;
                if (this.IL1Iii.getFileType() == FileType.VR360) {
                    onlineStabilizerInfo.mFilterInstanceType = 6;
                } else {
                    onlineStabilizerInfo.mFilterInstanceType = 1;
                }
                if (this.ILil.isNeedInitMultiView()) {
                    multiviewTrackInfo = new MultiviewTrackInfo();
                    multiviewTrackInfo.mTrackWidth = 1280;
                    multiviewTrackInfo.mTrackHeight = CameraInterface.DEFAULT_PREVIEW_WIDTH;
                    multiviewTrackInfo.mModelPath = this.ILil.getMultiViewTrackModelPaths()[0];
                    multiviewTrackInfo.mClxTxtPath = this.ILil.getMultiViewTrackModelPaths()[1];
                    multiviewTrackInfo.mTrackFpsInterval = 6;
                    multiviewTrackInfo.mMultiviewTrackCallback = new a.a.a.a.e.a.f.e(this);
                }
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = new BMGCameraPreviewerSessionRender(getContext().getApplicationContext(), options, new a.a.a.a.e.a.f.f(this), new a.a.a.a.e.a.f.d(this), new Handler(Looper.getMainLooper()), getClipRenderInfo(), new h(this), onlineStabilizerInfo, multiviewTrackInfo, new a.a.a.a.e.a.f.g(this));
                this.I11L = bMGCameraPreviewerSessionRender;
                bMGCameraPreviewerSessionRender.setFps(30.0d);
                this.I11L.setStabilizerQueueBufferSize(RecyclerView.MAX_SCROLL_DURATION);
                this.I11L.bindView(this.f72lL);
                GestureController gestureController = new GestureController(getContext());
                this.f61IiL = gestureController;
                gestureController.setEnabled(isGestureEnabled());
                if (!IL1Iii() && (isGestureHorizontalEnabled() || isGestureVerticalEnabled() || isGestureZoomEnabled())) {
                    LL1IL.e("camera is not supported, but gesture horizontal/vertical/zoom is enabled, ignored!");
                }
                this.f61IiL.setHorizontalEnabled(IL1Iii() && isGestureHorizontalEnabled());
                this.f61IiL.setVerticalEnabled(IL1Iii() && isGestureVerticalEnabled());
                GestureController gestureController2 = this.f61IiL;
                if (IL1Iii() && isGestureZoomEnabled()) {
                    z = true;
                }
                gestureController2.setZoomEnabled(z);
                this.f61IiL.setOnGestureChangeListener(getOnGestureChangeListener());
                this.f66lIiI = true;
            }
            LL1IL.d("bindResources");
            this.ILL = i2;
            if (IL1Iii()) {
                this.f61IiL.setCameraController(this.f70lLi1LL.f513b);
                this.f61IiL.setFovDistanceCalculateMinMax(this.IL1Iii.getConstraint().getMinFov(), this.IL1Iii.getConstraint().getMaxFov(), this.IL1Iii.getConstraint().getMinDistance(), this.IL1Iii.getConstraint().getMaxDistance());
                this.f61IiL.setFovDistanceConstraint(this.IL1Iii.getConstraint().getMinFov(), this.IL1Iii.getConstraint().getMaxFov(), this.IL1Iii.getConstraint().getMinDistance(), this.IL1Iii.getConstraint().getMaxDistance());
                this.f70lLi1LL.e();
            }
            return;
        } else {
            return;
        }
        mediaLogger.e(str);
    }

    public void resetViewAngle() {
        if (IL1Iii()) {
            Transform viewAngle = getViewAngle();
            if (viewAngle != null) {
                this.f61IiL.setFov(viewAngle.getFov());
                this.f61IiL.setDistance(viewAngle.getDistance());
                this.f70lLi1LL.a(this.f61IiL.getFov(), this.f61IiL.getDistance());
                this.f70lLi1LL.a(viewAngle.getYaw(), viewAngle.getPitch(), viewAngle.getRoll());
                return;
            }
            return;
        }
        LL1IL.w("resetViewAngle, but camera is not supported");
    }

    public void setApplyMultiView(boolean z) {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setApplyMultiView(z);
        }
    }

    public void setAutoRotateEnable(boolean z) {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setAutoRotateEnable(z);
            if (z) {
                BMGCameraPreviewerSessionRender bMGCameraPreviewerSessionRender = this.I11L;
                if (bMGCameraPreviewerSessionRender != null) {
                    bMGCameraPreviewerSessionRender.setGyroCountForRotation(100);
                }
            }
        }
    }

    public void setBasePlayerViewListener(IBasePlayerViewListener iBasePlayerViewListener) {
        this.f741 = iBasePlayerViewListener;
    }

    public void setBeautyFilterLevel(int i2) {
        if (this.I11L != null) {
            ICaptureParams iCaptureParams = this.IL1Iii;
            if (iCaptureParams != null) {
                iCaptureParams.setBeautyFilterLevel(i2);
            }
            this.I11L.onFilterChanged(getClipFilterInfos());
        }
    }

    public void setCapturePlayerViewListener(b bVar) {
        this.f64LlLLL = bVar;
    }

    public void setConstraint(Constraint constraint) {
        if (!IL1Iii()) {
            LL1IL.w("setConstraint, but camera is not supported");
            return;
        }
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams != null) {
            iCaptureParams.setConstraint(constraint);
            if (this.I11L != null && this.IL1Iii.getFileType() == FileType.FISH_EYE) {
                int[] constraintRatio = this.IL1Iii.getConstraintRatio();
                this.I11L.setGyroStabilizerFovDistance2(1.0d, (double) constraint.getDefaultDistance(), (double) constraint.getDefaultFov(), (double) (((float) constraintRatio[1]) / ((float) constraintRatio[0])), (double) constraint.getXScale(), (double) constraint.getYScale());
            }
            f fVar = this.f70lLi1LL;
            if (fVar != null) {
                fVar.e();
            }
        }
        this.f61IiL.setFovDistanceCalculateMinMax(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
        this.f61IiL.setFovDistanceConstraint(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
        this.f61IiL.setFov(constraint.getDefaultFov());
        this.f61IiL.setDistance(constraint.getDefaultDistance());
    }

    public void setGestureEnabled(boolean z) {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setGestureEnabled(z);
        }
        GestureController gestureController = this.f61IiL;
        if (gestureController != null) {
            gestureController.setEnabled(z);
        }
    }

    public void setGestureHorizontalEnabled(boolean z) {
        if (!IL1Iii()) {
            LL1IL.e("setGestureHorizontalEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setGestureHorizontalEnabled(z);
        }
        GestureController gestureController = this.f61IiL;
        if (gestureController != null) {
            gestureController.setHorizontalEnabled(z);
        }
    }

    public void setGestureListener(IGestureListener iGestureListener) {
        this.f67lIII = iGestureListener;
    }

    public void setGestureVerticalEnabled(boolean z) {
        if (!IL1Iii()) {
            LL1IL.e("setGestureVerticalEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setGestureVerticalEnabled(z);
        }
        GestureController gestureController = this.f61IiL;
        if (gestureController != null) {
            gestureController.setVerticalEnabled(z);
        }
    }

    public void setGestureZoomEnabled(boolean z) {
        if (!IL1Iii()) {
            LL1IL.e("setGestureZoomEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setGestureZoomEnabled(z);
        }
        GestureController gestureController = this.f61IiL;
        if (gestureController != null) {
            gestureController.setZoomEnabled(z);
        }
    }

    public void setGraphicViewVisibility(int i2) {
        GraphicView graphicView = this.f72lL;
        if (graphicView != null) {
            graphicView.setVisibility(i2);
        }
    }

    public void setLifecycle(e eVar) {
        this.I11li1 = eVar;
        eVar.a(this);
    }

    public void setLiveRenderModelType(int i2) {
        IPlayCaptureParams iPlayCaptureParams = this.ILil;
        if (iPlayCaptureParams != null) {
            iPlayCaptureParams.setLiveRenderModelType(i2);
        }
    }

    public void setLogoEnabled(boolean z) {
        if (this.I11L != null) {
            ICaptureParams iCaptureParams = this.IL1Iii;
            if (iCaptureParams != null) {
                iCaptureParams.setLogoEnabled(z);
            }
            this.I11L.updateLogo(this.f60IL.b(z));
        }
    }

    public void setOffset(String str) {
        if (this.I11L != null) {
            ICaptureParams iCaptureParams = this.IL1Iii;
            if (iCaptureParams != null) {
                iCaptureParams.setOffsetForPlay(str);
            }
            this.iIlLiL.offer(new e.b.c.b.b.a.a.b(this));
        }
    }

    public void setParams(ICaptureParams iCaptureParams, IPlayCaptureParams iPlayCaptureParams) {
        destroyResources(true);
        this.IL1Iii = iCaptureParams;
        this.ILil = iPlayCaptureParams;
    }

    public void setScreenRatio(int[] iArr) {
        ICaptureParams iCaptureParams = this.IL1Iii;
        if (iCaptureParams != null) {
            iCaptureParams.setScreenRatio(iArr);
            f fVar = this.f70lLi1LL;
            if (fVar != null) {
                fVar.e();
            }
        }
        ILil();
    }

    public void setStabType(int i2) {
        if (this.I11L != null && this.IL1Iii.getStabilizer() != null) {
            this.IL1Iii.setStabType(i2);
            this.IL1Iii.updateStabilizer(i2);
        }
    }

    public void setStyleFilter(a.a.a.a.a.g.a aVar) {
        if (this.I11L != null) {
            ICaptureParams iCaptureParams = this.IL1Iii;
            if (iCaptureParams != null) {
                iCaptureParams.setStyleFilter(aVar);
            }
            this.I11L.onFilterChanged(getClipFilterInfos());
        }
    }

    public void setStyleFilterIntensity(float f2) {
        if (this.I11L != null) {
            ICaptureParams iCaptureParams = this.IL1Iii;
            if (iCaptureParams != null) {
                iCaptureParams.setStyleFilterIntensity(f2);
            }
            this.I11L.updateLutStyleFilterIntensity(f2);
        }
    }
}
