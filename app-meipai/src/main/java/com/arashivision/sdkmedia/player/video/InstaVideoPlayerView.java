package com.arashivision.sdkmedia.player.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener.IL1Iii;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.video.IPlayVideoParams;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.ui.player.video.SimplePlayVideoParams;
import com.arashivision.insta360.basemedia.ui.player.video.SimpleVideoParams;
import com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView;
import com.arashivision.sdkmedia.player.listener.PlayerGestureListener;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import com.arashivision.sdkmedia.player.listener.VideoStatusListener;
import com.arashivision.sdkmedia.work.WorkWrapper;
import e.b.c.b.b.a.c.c;
import e.b.e.b.d.a;
import e.b.e.b.d.b;
import e.b.e.b.d.d;
import e.b.e.b.d.e;
import e.b.e.b.d.f;
import e.b.e.b.d.g;

public class InstaVideoPlayerView extends FrameLayout {

    /* renamed from: 〇oO reason: contains not printable characters */
    public static final MediaLogger f338oO = MediaLogger.getLogger(InstaVideoPlayerView.class);

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final Constraint f339O8oO888;

    /* renamed from: 〇O8 reason: contains not printable characters */
    public final Constraint f340O8;

    /* renamed from: 〇Ooo reason: contains not printable characters */
    public final Constraint f341Ooo;

    /* renamed from: 〇o0〇o0 reason: contains not printable characters */
    public VideoPlayerView f342o0o0;

    /* renamed from: com.arashivision.sdkmedia.player.video.InstaVideoPlayerView$O8〇oO8〇88 reason: invalid class name */
    public class O8oO888 implements IBasePlayerViewListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerViewListener f343O8oO888;

        public O8oO888(PlayerViewListener playerViewListener) {
            this.f343O8oO888 = playerViewListener;
        }

        /* access modifiers changed from: private */
        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public /* synthetic */ void m65O8oO888(PlayerViewListener playerViewListener) {
            playerViewListener.onLoadingStatusChanged(InstaVideoPlayerView.this.f342o0o0.isLoading());
        }

        public void onFail(int i2, String str, String str2) {
            InstaVideoPlayerView.this.post(new e(this.f343O8oO888, str2));
        }

        public void onLoadingFinish() {
            InstaVideoPlayerView instaVideoPlayerView = InstaVideoPlayerView.this;
            PlayerViewListener playerViewListener = this.f343O8oO888;
            playerViewListener.getClass();
            instaVideoPlayerView.post(new g(playerViewListener));
        }

        public void onLoadingStatusChanged() {
            InstaVideoPlayerView.this.post(new a(this, this.f343O8oO888));
        }

        public /* synthetic */ void setCallback(IL1Iii iL1Iii) {
            e.b.c.b.b.a.c.a.$default$setCallback(this, iL1Iii);
        }
    }

    /* renamed from: com.arashivision.sdkmedia.player.video.InstaVideoPlayerView$〇O8 reason: invalid class name */
    public class O8 implements IGestureListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ PlayerGestureListener f345O8oO888;

        public O8(InstaVideoPlayerView instaVideoPlayerView, PlayerGestureListener playerGestureListener) {
            this.f345O8oO888 = playerGestureListener;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return this.f345O8oO888.onDown(motionEvent);
        }

        public void onFlingAnimation() {
            this.f345O8oO888.onFlingAnimation();
        }

        public void onFlingAnimationEnd() {
            this.f345O8oO888.onFlingAnimationEnd();
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f345O8oO888.onLongPress(motionEvent);
        }

        public void onScroll() {
            this.f345O8oO888.onScroll();
        }

        public boolean onTap(MotionEvent motionEvent) {
            return this.f345O8oO888.onTap(motionEvent);
        }

        public void onUp() {
            this.f345O8oO888.onUp();
        }

        public void onZoom() {
            this.f345O8oO888.onZoom();
        }

        public void onZoomAnimation() {
            this.f345O8oO888.onZoomAnimation();
        }

        public void onZoomAnimationEnd() {
            this.f345O8oO888.onZoomAnimationEnd();
        }
    }

    /* renamed from: com.arashivision.sdkmedia.player.video.InstaVideoPlayerView$〇Ooo reason: invalid class name */
    public class Ooo implements IVideoPlayerViewListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ VideoStatusListener f346O8oO888;

        public Ooo(VideoStatusListener videoStatusListener) {
            this.f346O8oO888 = videoStatusListener;
        }

        public /* synthetic */ void onCalculateAntiShakeDataProgress(int i2, float f2) {
            c.$default$onCalculateAntiShakeDataProgress(this, i2, f2);
        }

        public void onCompletion() {
            InstaVideoPlayerView instaVideoPlayerView = InstaVideoPlayerView.this;
            VideoStatusListener videoStatusListener = this.f346O8oO888;
            videoStatusListener.getClass();
            instaVideoPlayerView.post(new f(videoStatusListener));
        }

        public /* synthetic */ void onDecodeReport(int i2, int i3) {
            c.$default$onDecodeReport(this, i2, i3);
        }

        public /* synthetic */ void onFpsNotify(double d2) {
            c.$default$onFpsNotify(this, d2);
        }

        public /* synthetic */ void onFrameUpdate(long j2) {
            c.$default$onFrameUpdate(this, j2);
        }

        public /* synthetic */ void onGenerateProxyFileProgress(int i2, float f2) {
            c.$default$onGenerateProxyFileProgress(this, i2, f2);
        }

        public /* synthetic */ void onPlayClip(int i2) {
            c.$default$onPlayClip(this, i2);
        }

        public /* synthetic */ void onPlayCutScene(int i2, int i3) {
            c.$default$onPlayCutScene(this, i2, i3);
        }

        public void onPlayStateChanged() {
            InstaVideoPlayerView.this.post(new b(this, this.f346O8oO888));
        }

        public void onProgressChanged(double d2, double d3) {
            InstaVideoPlayerView instaVideoPlayerView = InstaVideoPlayerView.this;
            d dVar = new d(this.f346O8oO888, d2, d3);
            instaVideoPlayerView.post(dVar);
        }

        public /* synthetic */ void onReBuffer(int i2, int i3) {
            c.$default$onReBuffer(this, i2, i3);
        }

        public void onSeekComplete() {
            InstaVideoPlayerView instaVideoPlayerView = InstaVideoPlayerView.this;
            VideoStatusListener videoStatusListener = this.f346O8oO888;
            videoStatusListener.getClass();
            instaVideoPlayerView.post(new e.b.e.b.d.c(videoStatusListener));
        }

        public /* synthetic */ void onSeekError(int i2) {
            c.$default$onSeekError(this, i2);
        }

        public /* synthetic */ void setCallback(IVideoPlayerViewListener.IL1Iii iL1Iii) {
            c.$default$setCallback(this, iL1Iii);
        }

        /* access modifiers changed from: private */
        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public /* synthetic */ void m67O8oO888(VideoStatusListener videoStatusListener) {
            videoStatusListener.onPlayStateChanged(InstaVideoPlayerView.this.f342o0o0.isPlaying());
        }
    }

    public InstaVideoPlayerView(Context context) {
        super(context);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f339O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f341Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f340O8 = constraint3;
        m64O8oO888(context);
    }

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public final void m64O8oO888(Context context) {
        VideoPlayerView videoPlayerView = new VideoPlayerView(context);
        this.f342o0o0 = videoPlayerView;
        addView(videoPlayerView);
    }

    public void destroy() {
        this.f342o0o0.destroyResources(true);
    }

    public float getDistance() {
        Transform cameraTransform = this.f342o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getDistance();
        }
        return 0.0f;
    }

    public float getFov() {
        Transform cameraTransform = this.f342o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getFov();
        }
        return 0.0f;
    }

    public float getPitch() {
        Transform cameraTransform = this.f342o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getPitch();
        }
        return 0.0f;
    }

    public float getRoll() {
        Transform cameraTransform = this.f342o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getRoll();
        }
        return 0.0f;
    }

    public synchronized long getVideoCurrentPosition() {
        return (long) this.f342o0o0.getVideoCurrentPosition();
    }

    public synchronized long getVideoTotalDuration() {
        return (long) this.f342o0o0.getVideoTotalDuration();
    }

    public float getYaw() {
        Transform cameraTransform = this.f342o0o0.getCameraTransform();
        if (cameraTransform != null) {
            return cameraTransform.getYaw();
        }
        return 0.0f;
    }

    public boolean isGestureEnabled() {
        return this.f342o0o0.isGestureEnabled();
    }

    public boolean isGestureHorizontalEnabled() {
        return this.f342o0o0.isGestureHorizontalEnabled();
    }

    public boolean isGestureVerticalEnabled() {
        return this.f342o0o0.isGestureVerticalEnabled();
    }

    public boolean isGestureZoomEnabled() {
        return this.f342o0o0.isGestureZoomEnabled();
    }

    public boolean isLoading() {
        return this.f342o0o0.isLoading();
    }

    public boolean isLooping() {
        return this.f342o0o0.isLooping();
    }

    public boolean isPlaying() {
        return this.f342o0o0.isPlaying();
    }

    public boolean isSeeking() {
        return this.f342o0o0.isSeeking();
    }

    public void pause() {
        this.f342o0o0.pause();
    }

    public void play() {
        this.f342o0o0.play();
    }

    public void prepare(WorkWrapper workWrapper, VideoParamsBuilder videoParamsBuilder) {
        MediaLogger mediaLogger = f338oO;
        StringBuilder a2 = e.a.a.a.a.a("Video Prepare. work: ");
        a2.append(workWrapper.toString());
        a2.append(", param: ");
        a2.append(videoParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        VideoPlayerView videoPlayerView = this.f342o0o0;
        b.a.a.a.g a3 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimpleVideoParams simpleVideoParams = new SimpleVideoParams(workWrapper.f358O8oO888);
        simpleVideoParams.setCacheWorkThumbnailRootPath(videoParamsBuilder.getCacheWorkThumbnailRootPath());
        simpleVideoParams.setCacheCutSceneVideoPath(videoParamsBuilder.getCacheCutSceneRootPath());
        simpleVideoParams.setScreenRatio(videoParamsBuilder.getScreenRatio());
        simpleVideoParams.setFitMode(a3.f());
        if (!videoParamsBuilder.isStabEnabled()) {
            simpleVideoParams.setStabType(-1);
        }
        b.a.a.a.g a4 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimplePlayVideoParams simplePlayVideoParams = new SimplePlayVideoParams();
        simplePlayVideoParams.setRenderModelType(a4.d() ? 20 : videoParamsBuilder.getRenderModelType());
        simplePlayVideoParams.setLoadingImageResId(videoParamsBuilder.getLoadingImageResId());
        simplePlayVideoParams.setLoadingBackgroundColor(videoParamsBuilder.getLoadingBackgroundColor());
        simplePlayVideoParams.setAutoPlayAfterPrepared(videoParamsBuilder.isAutoPlayAfterPrepared());
        simplePlayVideoParams.setLooping(videoParamsBuilder.isLooping());
        simplePlayVideoParams.setGestureEnabled(videoParamsBuilder.isGestureEnabled());
        simplePlayVideoParams.setGestureHorizontalEnabled(videoParamsBuilder.isGestureEnabled());
        simplePlayVideoParams.setGestureVerticalEnabled(videoParamsBuilder.isGestureEnabled());
        simplePlayVideoParams.setGestureZoomEnabled(videoParamsBuilder.isGestureEnabled());
        videoPlayerView.setParams((IVideoParams) simpleVideoParams, (IPlayVideoParams) simplePlayVideoParams);
    }

    public void resume() {
        this.f342o0o0.resume();
    }

    public void seekTo(long j2) {
        this.f342o0o0.seekTo((double) j2);
    }

    public void setConstraint(float f2, float f3, float f4, float f5, float f6, float f7) {
        setConstraint("", -1, -1, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    public void setGestureEnabled(boolean z) {
        this.f342o0o0.setGestureEnabled(z);
    }

    public void setGestureHorizontalEnabled(boolean z) {
        this.f342o0o0.setGestureHorizontalEnabled(z);
    }

    public void setGestureListener(PlayerGestureListener playerGestureListener) {
        if (playerGestureListener == null) {
            this.f342o0o0.setGestureListener(null);
        } else {
            this.f342o0o0.setGestureListener(new O8(this, playerGestureListener));
        }
    }

    public void setGestureVerticalEnabled(boolean z) {
        this.f342o0o0.setGestureVerticalEnabled(z);
    }

    public void setGestureZoomEnabled(boolean z) {
        this.f342o0o0.setGestureZoomEnabled(z);
    }

    public void setLifecycle(d.p.e eVar) {
        MediaLogger mediaLogger = f338oO;
        StringBuilder sb = new StringBuilder();
        sb.append("Video Lifecycle ");
        sb.append(eVar);
        mediaLogger.i(sb.toString());
        this.f342o0o0.setLifecycle(eVar);
    }

    public void setLooping(boolean z) {
        this.f342o0o0.setLooping(z);
    }

    public void setPlayerViewListener(PlayerViewListener playerViewListener) {
        if (playerViewListener == null) {
            this.f342o0o0.setBasePlayerViewListener(null);
        } else {
            this.f342o0o0.setBasePlayerViewListener(new O8oO888(playerViewListener));
        }
    }

    public void setVideoStatusListener(VideoStatusListener videoStatusListener) {
        if (videoStatusListener == null) {
            this.f342o0o0.clearVideoPlayerViewListener();
        } else {
            this.f342o0o0.addVideoPlayerViewListener(new Ooo(videoStatusListener));
        }
    }

    public void setVolume(float f2) {
        this.f342o0o0.setVolume(f2);
    }

    public void switchFisheyeMode() {
        this.f342o0o0.setConstraint(this.f341Ooo);
    }

    public void switchNormalMode() {
        this.f342o0o0.setConstraint(this.f339O8oO888);
    }

    public void switchPerspectiveMode() {
        this.f342o0o0.setConstraint(this.f340O8);
    }

    public void setConstraint(String str, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Constraint constraint = new Constraint(str, i2, i3, f2, f3, f4, f5, f6, f7, f8);
        this.f342o0o0.setConstraint(constraint);
    }

    public InstaVideoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f339O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f341Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f340O8 = constraint3;
        m64O8oO888(context);
    }

    public InstaVideoPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f339O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f341Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f340O8 = constraint3;
        m64O8oO888(context);
    }

    @TargetApi(21)
    public InstaVideoPlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Constraint constraint = new Constraint(-1, -1, 37.6f, 121.0f, 47.0f, 790.0f, 790.0f, 790.0f);
        this.f339O8oO888 = constraint;
        Constraint constraint2 = new Constraint(9, 16, 0.0f, 100.0f, 100.0f, 650.0f, 1588.0f, 650.0f);
        this.f341Ooo = constraint2;
        Constraint constraint3 = new Constraint(9, 16, 80.0f, 140.0f, 120.0f, 0.0f, 0.0f, 0.0f);
        this.f340O8 = constraint3;
        m64O8oO888(context);
    }
}
