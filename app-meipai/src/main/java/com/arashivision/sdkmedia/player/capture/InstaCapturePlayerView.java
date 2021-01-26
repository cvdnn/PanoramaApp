package com.arashivision.sdkmedia.player.capture;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import b.a.a.a.g;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.capture.CameraRenderSurfaceInfo;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;
import com.arashivision.insta360.basemedia.ui.player.capture.ICaptureParams;
import com.arashivision.insta360.basemedia.ui.player.capture.SimpleCaptureParams;
import com.arashivision.insta360.basemedia.ui.player.capture.SimplePlayCaptureParams;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener.IL1Iii;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.sdkmedia.player.listener.PlayerGestureListener;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import d.p.e;
import e.b.e.b.a.a;
import e.b.e.b.a.b;
import e.b.e.b.a.c;

public class InstaCapturePlayerView extends FrameLayout {
    public static final int LIVE_TYPE_PANORAMA = 0;
    public static final int LIVE_TYPE_RECORDING = 10;
    public static final MediaLogger Oo0 = MediaLogger.getLogger(InstaCapturePlayerView.class);

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final Constraint f314O8oO888;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public final Constraint f315O8;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public final Constraint f316Ooo;

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public final Constraint f317o0o0;

    /* renamed from: 〇oO reason: contains not printable characters */
    public CapturePlayerView f318oO;

    /* renamed from: com.arashivision.sdkmedia.player.capture.InstaCapturePlayerView$O8〇oO8〇88 reason: invalid class name */
    public class O8oO888 implements IBasePlayerViewListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerViewListener f319O8oO888;

        public O8oO888(PlayerViewListener playerViewListener) {
            this.f319O8oO888 = playerViewListener;
        }

        /* access modifiers changed from: private */
        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public /* synthetic */ void m59O8oO888(PlayerViewListener playerViewListener) {
            playerViewListener.onLoadingStatusChanged(InstaCapturePlayerView.this.f318oO.isLoading());
        }

        public void onFail(int i2, String str, String str2) {
            InstaCapturePlayerView.this.post(new b(this.f319O8oO888, str2));
        }

        public void onLoadingFinish() {
            InstaCapturePlayerView instaCapturePlayerView = InstaCapturePlayerView.this;
            PlayerViewListener playerViewListener = this.f319O8oO888;
            playerViewListener.getClass();
            instaCapturePlayerView.post(new c(playerViewListener));
        }

        public void onLoadingStatusChanged() {
            InstaCapturePlayerView.this.post(new a(this, this.f319O8oO888));
        }

        public /* synthetic */ void setCallback(IL1Iii iL1Iii) {
            e.b.c.b.b.a.c.a.$default$setCallback(this, iL1Iii);
        }
    }

    /* renamed from: com.arashivision.sdkmedia.player.capture.InstaCapturePlayerView$〇Ooo reason: invalid class name */
    public class Ooo implements IGestureListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerGestureListener f321O8oO888;

        public Ooo(InstaCapturePlayerView instaCapturePlayerView, PlayerGestureListener playerGestureListener) {
            this.f321O8oO888 = playerGestureListener;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.f321O8oO888.onDown(motionEvent);
        }

        public void onFlingAnimation() {
            this.f321O8oO888.onFlingAnimation();
        }

        public void onFlingAnimationEnd() {
            this.f321O8oO888.onFlingAnimationEnd();
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f321O8oO888.onLongPress(motionEvent);
        }

        public void onScroll() {
            this.f321O8oO888.onScroll();
        }

        public boolean onTap(MotionEvent motionEvent) {
            return this.f321O8oO888.onTap(motionEvent);
        }

        public void onUp() {
            this.f321O8oO888.onUp();
        }

        public void onZoom() {
            this.f321O8oO888.onZoom();
        }

        public void onZoomAnimation() {
            this.f321O8oO888.onZoomAnimation();
        }

        public void onZoomAnimationEnd() {
            this.f321O8oO888.onZoomAnimationEnd();
        }
    }

    public InstaCapturePlayerView(Context context) {
        super(context);
        Constraint constraint = new Constraint(9, 16, 20.0f, 120.0f, 54.0f, 100.0f, 800.0f, 800.0f);
        this.f314O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f316Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f315O8 = constraint3;
        Constraint constraint4 = new Constraint(16, 9, 20.0f, 150.0f, 51.0f, 0.0f, 800.0f, 800.0f);
        this.f317o0o0 = constraint4;
        m58O8oO888(context);
    }

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final void m58O8oO888(Context context) {
        CapturePlayerView capturePlayerView = new CapturePlayerView(context);
        this.f318oO = capturePlayerView;
        addView(capturePlayerView);
    }

    public void destroy() {
        this.f318oO.destroyResources(true);
    }

    public Object getPipeline() {
        return this.f318oO.getPipeline();
    }

    public void hideFrame() {
        this.f318oO.setGraphicViewVisibility(8);
    }

    public boolean isGestureEnabled() {
        return this.f318oO.isGestureEnabled();
    }

    public boolean isGestureHorizontalEnabled() {
        return this.f318oO.isGestureHorizontalEnabled();
    }

    public boolean isGestureVerticalEnabled() {
        return this.f318oO.isGestureVerticalEnabled();
    }

    public boolean isGestureZoomEnabled() {
        return this.f318oO.isGestureZoomEnabled();
    }

    public boolean isLoading() {
        return this.f318oO.isLoading();
    }

    public void play() {
        this.f318oO.play();
    }

    public void prepare(CaptureParamsBuilder captureParamsBuilder) {
        MediaLogger mediaLogger = Oo0;
        StringBuilder a2 = e.a.a.a.a.a("Capture Prepare. param: ");
        a2.append(captureParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        CapturePlayerView capturePlayerView = this.f318oO;
        g a3 = a.a.a.a.b.a.a(captureParamsBuilder.getCameraType(), captureParamsBuilder.getMediaOffset());
        SimpleCaptureParams simpleCaptureParams = new SimpleCaptureParams();
        simpleCaptureParams.setCameraType(captureParamsBuilder.getCameraType());
        simpleCaptureParams.setOffsetForPlay(captureParamsBuilder.getMediaOffset());
        boolean z = false;
        simpleCaptureParams.setDualStream(false);
        simpleCaptureParams.setInstaMedia(true);
        simpleCaptureParams.setAssetInfo(a3.a(captureParamsBuilder.getMediaOffset(), captureParamsBuilder.isCameraSelfie(), captureParamsBuilder.getWidth(), captureParamsBuilder.getHeight(), captureParamsBuilder.getFps()));
        simpleCaptureParams.setScreenRatio(captureParamsBuilder.getScreenRatio());
        simpleCaptureParams.setConstraint((!a3.d() || !captureParamsBuilder.isLive()) ? this.f314O8oO888 : this.f317o0o0);
        simpleCaptureParams.setFileType(a3.b());
        simpleCaptureParams.setGyroType(a3.a(captureParamsBuilder.isCameraSelfie()));
        simpleCaptureParams.setStabType(captureParamsBuilder.isStabEnabled() ? a3.c() : -1);
        simpleCaptureParams.setFitMode(a3.f());
        simpleCaptureParams.setPreviewDelayNs(a3.a());
        simpleCaptureParams.setFps(captureParamsBuilder.getFps());
        simpleCaptureParams.setScreenRatio((!a3.d() || !captureParamsBuilder.isLive()) ? captureParamsBuilder.getScreenRatio() : new int[]{16, 9});
        simpleCaptureParams.setRotateEnabled(a3.d());
        simpleCaptureParams.setRotateScreenRatioEnabled(a3.d());
        g a4 = a.a.a.a.b.a.a(captureParamsBuilder.getCameraType(), captureParamsBuilder.getMediaOffset());
        SimplePlayCaptureParams simplePlayCaptureParams = new SimplePlayCaptureParams();
        simplePlayCaptureParams.setRenderModelType((!a4.d() || captureParamsBuilder.isLive()) ? captureParamsBuilder.getRenderModelType() : 20);
        if (a4.d()) {
            simplePlayCaptureParams.setLiveRenderModelType(20);
        } else {
            simplePlayCaptureParams.setLiveRenderModelType(11);
        }
        simplePlayCaptureParams.setStabilizeEnabled(a4.e() && captureParamsBuilder.isStabEnabled());
        simplePlayCaptureParams.setAutoRotateEnable(a4.d());
        if (!a4.d() && captureParamsBuilder.isGestureEnabled()) {
            z = true;
        }
        simplePlayCaptureParams.setGestureEnabled(z);
        simplePlayCaptureParams.setGestureHorizontalEnabled(z);
        simplePlayCaptureParams.setGestureVerticalEnabled(z);
        simplePlayCaptureParams.setGestureZoomEnabled(z);
        simplePlayCaptureParams.setCopyVideoHwaccel(captureParamsBuilder.isCopyVideoHwaccel());
        simplePlayCaptureParams.setOnlyStitchSurfaceRender(captureParamsBuilder.isOnlyStitchSurfaceRender());
        if (captureParamsBuilder.getCameraRenderSurface() != null) {
            CameraRenderSurfaceInfo cameraRenderSurfaceInfo = new CameraRenderSurfaceInfo();
            cameraRenderSurfaceInfo.mSurface = captureParamsBuilder.getCameraRenderSurface();
            cameraRenderSurfaceInfo.renderWidth = captureParamsBuilder.getCameraRenderSurfaceWidth();
            cameraRenderSurfaceInfo.renderHeight = captureParamsBuilder.getCameraRenderSurfaceHeight();
            simplePlayCaptureParams.setCameraRenderSurfaceInfo(cameraRenderSurfaceInfo);
        }
        capturePlayerView.setParams(simpleCaptureParams, simplePlayCaptureParams);
    }

    public void setConstraint(float f2, float f3, float f4, float f5, float f6, float f7) {
        setConstraint("", -1, -1, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    public void setGestureEnabled(boolean z) {
        this.f318oO.setGestureEnabled(z);
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.f318oO.setGestureHorizontalEnabled(z);
    }

    public void setGestureListener(PlayerGestureListener playerGestureListener) {
        if (playerGestureListener == null) {
            this.f318oO.setGestureListener(null);
        } else {
            this.f318oO.setGestureListener(new Ooo(this, playerGestureListener));
        }
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.f318oO.setGestureVerticalEnabled(z);
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f318oO.setGestureZoomEnabled(z);
    }

    public void setLifecycle(e eVar) {
        MediaLogger mediaLogger = Oo0;
        StringBuilder sb = new StringBuilder();
        sb.append("Capture Lifecycle ");
        sb.append(eVar);
        mediaLogger.i(sb.toString());
        this.f318oO.setLifecycle(eVar);
    }

    public void setLiveType(int i2) {
        ICaptureParams captureParams = this.f318oO.getCaptureParams();
        if (captureParams == null) {
            return;
        }
        if (a.a.a.a.b.a.a(captureParams.getCameraType(), captureParams.getOffsetForPlay()).d()) {
            this.f318oO.setLiveRenderModelType(20);
        } else if (i2 == 0) {
            this.f318oO.setLiveRenderModelType(11);
        } else if (i2 == 10) {
            this.f318oO.setLiveRenderModelType(0);
        }
    }

    public void setPlayerViewListener(PlayerViewListener playerViewListener) {
        if (playerViewListener == null) {
            this.f318oO.setBasePlayerViewListener(null);
        } else {
            this.f318oO.setBasePlayerViewListener(new O8oO888(playerViewListener));
        }
    }

    public void showFrame() {
        this.f318oO.setGraphicViewVisibility(0);
    }

    public void switchFisheyeMode() {
        this.f318oO.setConstraint(this.f316Ooo);
    }

    public void switchNormalMode() {
        this.f318oO.setConstraint(this.f314O8oO888);
    }

    public void switchPerspectiveMode() {
        this.f318oO.setConstraint(this.f315O8);
    }

    public void setConstraint(String str, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Constraint constraint = new Constraint(str, i2, i3, f2, f3, f4, f5, f6, f7, f8);
        this.f318oO.setConstraint(constraint);
    }

    public InstaCapturePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Constraint constraint = new Constraint(9, 16, 20.0f, 120.0f, 54.0f, 100.0f, 800.0f, 800.0f);
        this.f314O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f316Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f315O8 = constraint3;
        Constraint constraint4 = new Constraint(16, 9, 20.0f, 150.0f, 51.0f, 0.0f, 800.0f, 800.0f);
        this.f317o0o0 = constraint4;
        m58O8oO888(context);
    }

    public InstaCapturePlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Constraint constraint = new Constraint(9, 16, 20.0f, 120.0f, 54.0f, 100.0f, 800.0f, 800.0f);
        this.f314O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f316Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f315O8 = constraint3;
        Constraint constraint4 = new Constraint(16, 9, 20.0f, 150.0f, 51.0f, 0.0f, 800.0f, 800.0f);
        this.f317o0o0 = constraint4;
        m58O8oO888(context);
    }

    @TargetApi(21)
    public InstaCapturePlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Constraint constraint = new Constraint(9, 16, 20.0f, 120.0f, 54.0f, 100.0f, 800.0f, 800.0f);
        this.f314O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f316Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f315O8 = constraint3;
        Constraint constraint4 = new Constraint(16, 9, 20.0f, 150.0f, 51.0f, 0.0f, 800.0f, 800.0f);
        this.f317o0o0 = constraint4;
        m58O8oO888(context);
    }
}
