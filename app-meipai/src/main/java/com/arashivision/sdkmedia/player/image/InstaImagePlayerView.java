package com.arashivision.sdkmedia.player.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import b.a.a.a.g;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView;
import com.arashivision.insta360.basemedia.ui.player.image.SimpleImageParams;
import com.arashivision.insta360.basemedia.ui.player.image.SimplePlayImageParams;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener.IL1Iii;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.sdkmedia.player.listener.PlayerGestureListener;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import com.arashivision.sdkmedia.work.WorkWrapper;
import d.p.e;
import e.b.e.b.b.a;
import e.b.e.b.b.b;
import e.b.e.b.b.c;

public class InstaImagePlayerView extends FrameLayout {

    /* renamed from: 〇oO reason: contains not printable characters */
    public static final MediaLogger f330oO = MediaLogger.getLogger(InstaImagePlayerView.class);

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final Constraint f331O8oO888;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public final Constraint f332O8;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public final Constraint f333Ooo;

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public ImagePlayerView f334o0o0;

    /* renamed from: com.arashivision.sdkmedia.player.image.InstaImagePlayerView$O8〇oO8〇88 reason: invalid class name */
    public class O8oO888 implements IBasePlayerViewListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerViewListener f335O8oO888;

        public O8oO888(PlayerViewListener playerViewListener) {
            this.f335O8oO888 = playerViewListener;
        }

        /* access modifiers changed from: private */
        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public /* synthetic */ void m62O8oO888(PlayerViewListener playerViewListener) {
            playerViewListener.onLoadingStatusChanged(InstaImagePlayerView.this.f334o0o0.isLoading());
        }

        public void onFail(int i2, String str, String str2) {
            InstaImagePlayerView.this.post(new b(this.f335O8oO888, str2));
        }

        public void onLoadingFinish() {
            InstaImagePlayerView instaImagePlayerView = InstaImagePlayerView.this;
            PlayerViewListener playerViewListener = this.f335O8oO888;
            playerViewListener.getClass();
            instaImagePlayerView.post(new c(playerViewListener));
        }

        public void onLoadingStatusChanged() {
            InstaImagePlayerView.this.post(new a(this, this.f335O8oO888));
        }

        public /* synthetic */ void setCallback(IL1Iii iL1Iii) {
            e.b.c.b.b.a.c.a.$default$setCallback(this, iL1Iii);
        }
    }

    /* renamed from: com.arashivision.sdkmedia.player.image.InstaImagePlayerView$〇Ooo reason: invalid class name */
    public class Ooo implements IGestureListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerGestureListener f337O8oO888;

        public Ooo(InstaImagePlayerView instaImagePlayerView, PlayerGestureListener playerGestureListener) {
            this.f337O8oO888 = playerGestureListener;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.f337O8oO888.onDown(motionEvent);
        }

        public void onFlingAnimation() {
            this.f337O8oO888.onFlingAnimation();
        }

        public void onFlingAnimationEnd() {
            this.f337O8oO888.onFlingAnimationEnd();
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f337O8oO888.onLongPress(motionEvent);
        }

        public void onScroll() {
            this.f337O8oO888.onScroll();
        }

        public boolean onTap(MotionEvent motionEvent) {
            return this.f337O8oO888.onTap(motionEvent);
        }

        public void onUp() {
            this.f337O8oO888.onUp();
        }

        public void onZoom() {
            this.f337O8oO888.onZoom();
        }

        public void onZoomAnimation() {
            this.f337O8oO888.onZoomAnimation();
        }

        public void onZoomAnimationEnd() {
            this.f337O8oO888.onZoomAnimationEnd();
        }
    }

    public InstaImagePlayerView(Context context) {
        super(context);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f331O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f333Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f332O8 = constraint3;
        m61O8oO888(context);
    }

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final void m61O8oO888(Context context) {
        ImagePlayerView imagePlayerView = new ImagePlayerView(context);
        this.f334o0o0 = imagePlayerView;
        addView(imagePlayerView);
    }

    public void destroy() {
        this.f334o0o0.destroyResources(true);
    }

    public float getDistance() {
        Transform cameraTransform = this.f334o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getDistance();
        }
        return 0.0f;
    }

    public float getFov() {
        Transform cameraTransform = this.f334o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getFov();
        }
        return 0.0f;
    }

    public float getPitch() {
        Transform cameraTransform = this.f334o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getPitch();
        }
        return 0.0f;
    }

    public float getRoll() {
        Transform cameraTransform = this.f334o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getRoll();
        }
        return 0.0f;
    }

    public float getYaw() {
        Transform cameraTransform = this.f334o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getYaw();
        }
        return 0.0f;
    }

    public boolean isGestureEnabled() {
        return this.f334o0o0.isGestureEnabled();
    }

    public boolean isGestureHorizontalEnabled() {
        return this.f334o0o0.isGestureHorizontalEnabled();
    }

    public boolean isGestureVerticalEnabled() {
        return this.f334o0o0.isGestureVerticalEnabled();
    }

    public boolean isGestureZoomEnabled() {
        return this.f334o0o0.isGestureZoomEnabled();
    }

    public boolean isLoading() {
        return this.f334o0o0.isLoading();
    }

    public void play() {
        this.f334o0o0.play();
    }

    public void prepare(WorkWrapper workWrapper, ImageParamsBuilder imageParamsBuilder) {
        MediaLogger mediaLogger = f330oO;
        StringBuilder a2 = e.a.a.a.a.a("Image Prepare. work: ");
        a2.append(workWrapper.toString());
        a2.append(", param: ");
        a2.append(imageParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        ImagePlayerView imagePlayerView = this.f334o0o0;
        g a3 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimpleImageParams simpleImageParams = new SimpleImageParams(workWrapper.f358O8oO888);
        simpleImageParams.setCacheWorkThumbnailRootPath(imageParamsBuilder.getCacheWorkThumbnailRootPath());
        simpleImageParams.setStabilizerCacheRootPath(imageParamsBuilder.getStabilizerCacheRootPath());
        simpleImageParams.setCacheCutSceneImagePath(imageParamsBuilder.getCacheCutSceneRootPath());
        if (!TextUtils.isEmpty(imageParamsBuilder.getUrlForPlay())) {
            simpleImageParams.setUrlsForPlay(imageParamsBuilder.getUrlForPlay());
        }
        simpleImageParams.setDynamicStitch(imageParamsBuilder.isDynamicStitch());
        simpleImageParams.setScreenRatio(imageParamsBuilder.getScreenRatio());
        simpleImageParams.setConstraint(this.f331O8oO888);
        simpleImageParams.setFitMode(a3.f());
        if (!imageParamsBuilder.isStabEnabled()) {
            simpleImageParams.setStabType(-1);
        }
        g a4 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimplePlayImageParams simplePlayImageParams = new SimplePlayImageParams();
        simplePlayImageParams.setRenderModelType(a4.d() ? 20 : imageParamsBuilder.getRenderModelType());
        simplePlayImageParams.setGestureEnabled(imageParamsBuilder.isGestureEnabled());
        simplePlayImageParams.setGestureHorizontalEnabled(imageParamsBuilder.isGestureEnabled());
        simplePlayImageParams.setGestureVerticalEnabled(imageParamsBuilder.isGestureEnabled());
        simplePlayImageParams.setGestureZoomEnabled(imageParamsBuilder.isGestureEnabled());
        imagePlayerView.setParams(simpleImageParams, simplePlayImageParams);
    }

    public void setConstraint(float f2, float f3, float f4, float f5, float f6, float f7) {
        setConstraint("", -1, -1, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    public void setGestureEnabled(boolean z) {
        this.f334o0o0.setGestureEnabled(z);
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.f334o0o0.setGestureHorizontalEnabled(z);
    }

    public void setGestureListener(PlayerGestureListener playerGestureListener) {
        if (playerGestureListener == null) {
            this.f334o0o0.setGestureListener(null);
        } else {
            this.f334o0o0.setGestureListener(new Ooo(this, playerGestureListener));
        }
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.f334o0o0.setGestureVerticalEnabled(z);
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f334o0o0.setGestureZoomEnabled(z);
    }

    public void setLifecycle(e eVar) {
        MediaLogger mediaLogger = f330oO;
        StringBuilder sb = new StringBuilder();
        sb.append("Image Lifecycle ");
        sb.append(eVar);
        mediaLogger.i(sb.toString());
        this.f334o0o0.setLifecycle(eVar);
    }

    public void setPlayerViewListener(PlayerViewListener playerViewListener) {
        if (playerViewListener == null) {
            this.f334o0o0.setBasePlayerViewListener(null);
        } else {
            this.f334o0o0.setBasePlayerViewListener(new O8oO888(playerViewListener));
        }
    }

    public void switchFisheyeMode() {
        this.f334o0o0.setConstraint(this.f333Ooo);
    }

    public void switchNormalMode() {
        this.f334o0o0.setConstraint(this.f331O8oO888);
    }

    public void switchPerspectiveMode() {
        this.f334o0o0.setConstraint(this.f332O8);
    }

    public void setConstraint(String str, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Constraint constraint = new Constraint(str, i2, i3, f2, f3, f4, f5, f6, f7, f8);
        this.f334o0o0.setConstraint(constraint);
    }

    public InstaImagePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f331O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f333Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f332O8 = constraint3;
        m61O8oO888(context);
    }

    public InstaImagePlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f331O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f333Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f332O8 = constraint3;
        m61O8oO888(context);
    }

    @TargetApi(21)
    public InstaImagePlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f331O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f333Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f332O8 = constraint3;
        m61O8oO888(context);
    }
}
