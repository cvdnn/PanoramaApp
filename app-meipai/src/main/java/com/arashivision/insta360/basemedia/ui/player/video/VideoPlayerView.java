package com.arashivision.insta360.basemedia.ui.player.video;

import a.a.a.a.a.f.e.a;
import a.a.a.a.e.a.b;
import a.a.a.a.e.a.c.h;
import a.a.a.a.e.a.c.j;
import a.a.a.a.e.a.c.m;
import a.a.a.a.e.a.e.c;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.i;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.e.n;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.e.q;
import a.a.a.a.e.a.g.d;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.arashivision.arvbmg.dollyzoom.DollyZoom.IDollyzoomRectCallback;
import com.arashivision.arvbmg.dollyzoom.DollyZoom.IDollzoomInitCallback;
import com.arashivision.arvbmg.dollyzoom.DollyZoomInfo;
import com.arashivision.arvbmg.longtracker.LongTrackInfo;
import com.arashivision.arvbmg.previewer.BMGPreviewerSession.EndBehaviour;
import com.arashivision.arvbmg.previewer.BMGPreviewerSession.PlayRange;
import com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender;
import com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender.StapleTrackInfo;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.MultiViewInfo;
import com.arashivision.arvbmg.render.camera.GestureController;
import com.arashivision.arvbmg.render.camera.GestureController.OnGestureChangeListener;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo.ImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.arvbmg.transition.TransitionProcessor;
import com.arashivision.arvbmg.util.PreviewerUtil;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.MediaPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.SrcPosition;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.ui.GraphicView;
import com.arashivision.insbase.joml.Vector2f;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insta360.basemedia.R;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener;
import com.arashivision.insta360.basemedia.util.EventIdUtils;
import com.baidubce.auth.NTLMEngineImpl;
import d.p.e;
import d.p.g;
import e.b.c.b.b.a.d.k;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoPlayerView extends FrameLayout implements g, d {
    public static final MediaLogger l1Lll = MediaLogger.getLogger(VideoPlayerView.class);
    public IBasePlayerViewListener I1;
    public boolean I11L;
    public int I11li1;
    public a.a.a.a.e.a.e.g I1I;

    /* renamed from: I1L丨11L reason: contains not printable characters */
    public boolean f212I1L11L;

    /* renamed from: IIi丨丨I reason: contains not printable characters */
    public int f213IIiI = -1;
    public h IL1Iii;
    public List<a.a.a.a.e.a.e.h> ILL;

    /* renamed from: ILL丨Ii reason: contains not printable characters */
    public boolean f214ILLIi;
    public IPlayVideoParams ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public GestureController f215ILl;
    public List<l> Ilil;

    /* renamed from: I丨 reason: contains not printable characters */
    public BMGPreviewerSessionRender f216I;

    /* renamed from: I丨Ii reason: contains not printable characters */
    public int f217IIi;

    /* renamed from: I丨L reason: contains not printable characters */
    public List<q> f218IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public List<i> f219IiL;

    /* renamed from: L11丨 reason: contains not printable characters */
    public boolean f220L11;

    /* renamed from: L11丨丨丨1 reason: contains not printable characters */
    public boolean f221L111;
    public IGestureListener L1iI1;

    /* renamed from: LI丨l reason: contains not printable characters */
    public ImageView f222LIl;

    /* renamed from: LI丨丨l丨l reason: contains not printable characters */
    public IiL f223LIll = new IiL(this, null);
    public double LL1IL;
    public Double LLL;
    public HeadTrackerController Lil;

    /* renamed from: LlIl丨 reason: contains not printable characters */
    public Runnable f224LlIl;
    public List<Integer> LlLI1;

    /* renamed from: LlLiL丨L丨 reason: contains not printable characters */
    public TextView[] f225LlLiLL;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public a.a.a.a.e.a.e.d f226Ll1;

    /* renamed from: L丨1l reason: contains not printable characters */
    public Transform f227L1l;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public List<n> f228L11I;

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public int f229LlLLL;
    public e i1;
    public ImageView iI;

    /* renamed from: iI1i丨I reason: contains not printable characters */
    public long f230iI1iI;
    public int iIi1;
    public ConcurrentLinkedQueue<Runnable> iIilII1;
    public volatile int iIlLiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public List<p> f231iILLL1;

    /* renamed from: iI丨Li丨lI reason: contains not printable characters */
    public Previewer2 f232iILilI;

    /* renamed from: iiIIi丨11 reason: contains not printable characters */
    public List<a> f233iiIIi11;

    /* renamed from: ili丨11 reason: contains not printable characters */
    public GraphicView f234ili11;

    /* renamed from: il丨l丨 reason: contains not printable characters */
    public boolean f235ill;

    /* renamed from: l1IIi1丨 reason: contains not printable characters */
    public double f236l1IIi1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public a.a.a.a.e.a.e.e f237lIiI;

    /* renamed from: lI丨II reason: contains not printable characters */
    public int f238lIII;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public List<Double> f239lIlii;
    public a.a.a.a.e.a.g.e lL;
    public boolean llI;
    public boolean llliI;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public List<Double> f240llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public List<f> f241lLi1LL;

    /* renamed from: l丨liiI1 reason: contains not printable characters */
    public int f242lliiI1;

    /* renamed from: l丨丨i11 reason: contains not printable characters */
    public a.a.a.a.e.a.c.i f243li11;

    /* renamed from: 丨i1丨1i reason: contains not printable characters */
    public List<IVideoPlayerViewListener> f244i11i;

    /* renamed from: 丨iI丨丨LLl reason: contains not printable characters */
    public boolean f245iILLl;

    /* renamed from: 丨il reason: contains not printable characters */
    public List<c> f246il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public boolean f247lL;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public String f248l;

    /* renamed from: 丨丨 reason: contains not printable characters */
    public boolean f249;

    /* renamed from: 丨丨LLlI1 reason: contains not printable characters */
    public int f250LLlI1;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public boolean f2511;

    /* renamed from: 丨丨丨丨 reason: contains not printable characters */
    public float f252;

    public class I1I implements Runnable {
        public final /* synthetic */ IPlayVideoParams I1I;
        public final /* synthetic */ h IL1Iii;
        public final /* synthetic */ int ILil;

        public class IL1Iii implements a.a.a.a.a.e.a {
            public final /* synthetic */ IVideoParams IL1Iii;
            public final /* synthetic */ int ILil;

            public IL1Iii(IVideoParams iVideoParams, int i2) {
                this.IL1Iii = iVideoParams;
                this.ILil = i2;
            }

            public void IL1Iii(long j2, long j3) {
                MediaLogger mediaLogger = VideoPlayerView.l1Lll;
                StringBuilder sb = new StringBuilder();
                sb.append(Arrays.toString(this.IL1Iii.getUrlsForPlay()));
                sb.append(" onStabilizerLoadProgress: ");
                sb.append(j2);
                sb.append(" / ");
                sb.append(j3);
                mediaLogger.d(sb.toString());
                float f2 = (((float) j2) * 1.0f) / ((float) j3);
                for (IVideoPlayerViewListener onCalculateAntiShakeDataProgress : VideoPlayerView.this.f244i11i) {
                    onCalculateAntiShakeDataProgress.onCalculateAntiShakeDataProgress(this.ILil, f2);
                }
            }
        }

        public I1I(h hVar, int i2, IPlayVideoParams iPlayVideoParams) {
            this.IL1Iii = hVar;
            this.ILil = i2;
            this.I1I = iPlayVideoParams;
        }

        public final boolean IL1Iii(int i2) {
            return VideoPlayerView.this.iIlLiL < 0 || i2 != VideoPlayerView.this.iIlLiL;
        }

        public void run() {
            int[] iArr = {0};
            for (int i2 = 0; i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size(); i2++) {
                IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
                if (!IL1Iii(this.ILil) && iArr[0] == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(I1I.class.getSimpleName());
                    sb.append(VideoPlayerView.this.iIi1);
                    iArr[0] = a.a.a.a.e.a.l.h.a(iVideoParams, sb.toString(), -10001);
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0) {
                    IL1Iii iL1Iii = new IL1Iii(iVideoParams, i2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(I1I.class.getSimpleName());
                    sb2.append(VideoPlayerView.this.iIi1);
                    iArr[0] = a.a.a.a.e.a.l.h.a(iVideoParams, (a.a.a.a.a.e.a) iL1Iii, sb2.toString(), -10000, -10001);
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0) {
                    iVideoParams.updateStabilizerByFrameTimestampInMsForPreview(BMGPreviewerSource.create(VideoPlayerView.this.IL1Iii(this.IL1Iii, true)), i2);
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0 && this.I1I.isNeedLoadGpsInfo()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(I1I.class.getSimpleName());
                    sb3.append(VideoPlayerView.this.iIi1);
                    iArr[0] = a.a.a.a.e.a.l.h.d(iVideoParams, sb3.toString(), -10001);
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0 && this.I1I.isApplyProxy()) {
                    q qVar = (q) VideoPlayerView.this.f218IL.get(i2);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(I1I.class.getSimpleName());
                    sb4.append(VideoPlayerView.this.iIi1);
                    iArr[0] = a.a.a.a.e.a.l.h.a(iVideoParams, qVar, sb4.toString(), -10001);
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0 && iVideoParams.getOptimizationRunnableList() != null) {
                    for (a.a.a.a.e.a.g.c run : iVideoParams.getOptimizationRunnableList()) {
                        iArr[0] = run.run();
                        if (iArr[0] != 0) {
                            break;
                        }
                    }
                }
                if (!IL1Iii(this.ILil) && iArr[0] == 0 && this.I1I.isApplyFlash()) {
                    for (a.a.a.a.e.a.e.h hVar : VideoPlayerView.this.ILL) {
                        a.a.a.a.e.a.i.e flashEffect = hVar.f521a.getFlashEffect();
                        hVar.f522b = flashEffect;
                        if (flashEffect != null) {
                            flashEffect.a();
                        }
                    }
                }
            }
            new Handler(Looper.getMainLooper()).post(new e.b.c.b.b.a.d.h(this, this.ILil, iArr));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void IL1Iii(int i2, int[] iArr) {
            if (IL1Iii(i2)) {
                VideoPlayerView.l1Lll.w("playId is not matched, maybe player is destroyed?");
                VideoPlayerView.this.setLoading(false);
            } else if (iArr[0] != 0) {
                String str = "load info failed!";
                VideoPlayerView.l1Lll.e(str);
                VideoPlayerView.this.setLoading(false);
                IBasePlayerViewListener iBasePlayerViewListener = VideoPlayerView.this.I1;
                if (iBasePlayerViewListener != null) {
                    iBasePlayerViewListener.onFail(iArr[0], VideoPlayerView.class.getSimpleName(), str);
                }
            } else {
                VideoPlayerView videoPlayerView = VideoPlayerView.this;
                if (!videoPlayerView.I11L) {
                    VideoPlayerView.m25IiL(videoPlayerView);
                }
                VideoPlayerView videoPlayerView2 = VideoPlayerView.this;
                if (videoPlayerView2 != null) {
                    VideoPlayerView.l1Lll.d("bindResources");
                    videoPlayerView2.ILil();
                    videoPlayerView2.I11li1 = i2;
                    for (int i3 = 0; i3 < ((a.a.a.a.e.a.c.g) videoPlayerView2.IL1Iii).f463a.size(); i3++) {
                        if (videoPlayerView2.IL1Iii(i3)) {
                            f fVar = (f) videoPlayerView2.f241lLi1LL.get(i3);
                            p pVar = (p) videoPlayerView2.f231iILLL1.get(i3);
                            n nVar = (n) videoPlayerView2.f228L11I.get(i3);
                            fVar.a(new BaseCameraController());
                            videoPlayerView2.ILil(i3, false);
                            nVar.f539d.a(new BaseCameraController());
                            nVar.f539d.e();
                            if (videoPlayerView2.IL1Iii()) {
                                Transform restoreCameraTransform = videoPlayerView2.ILil.getRestoreCameraTransform();
                                if (restoreCameraTransform != null) {
                                    videoPlayerView2.f215ILl.setFov(restoreCameraTransform.getFov());
                                    videoPlayerView2.f215ILl.setDistance(restoreCameraTransform.getDistance());
                                    fVar.a(videoPlayerView2.f215ILl.getFov(), videoPlayerView2.f215ILl.getDistance());
                                    fVar.a(restoreCameraTransform.getYaw(), restoreCameraTransform.getPitch(), restoreCameraTransform.getRoll());
                                    videoPlayerView2.f227L1l = restoreCameraTransform;
                                } else {
                                    Transform a2 = pVar.a(videoPlayerView2.getCurrentFrameTime(), true);
                                    videoPlayerView2.f215ILl.setFov(a2.getFov());
                                    videoPlayerView2.f215ILl.setDistance(a2.getDistance());
                                    fVar.a(videoPlayerView2.f215ILl.getFov(), videoPlayerView2.f215ILl.getDistance());
                                    fVar.a(a2.getYaw(), a2.getPitch(), a2.getRoll());
                                }
                            } else {
                                fVar.a(pVar.a(videoPlayerView2.getCurrentFrameTime(), true));
                            }
                            fVar.e();
                        }
                    }
                    videoPlayerView2.ILL();
                    VideoPlayerView videoPlayerView3 = VideoPlayerView.this;
                    videoPlayerView3.f216I.rebuildRenderWithSource(videoPlayerView3.IL1Iii(videoPlayerView3.IL1Iii, true), videoPlayerView3.getOptions(true), videoPlayerView3.ILil.getRestorePlayPosition(), videoPlayerView3.IL1Iii(videoPlayerView3.IL1Iii, false), videoPlayerView3.getOptions(false));
                    return;
                }
                throw null;
            }
        }
    }

    public class IL1Iii implements com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener.IL1Iii {
        public IL1Iii(VideoPlayerView videoPlayerView) {
        }
    }

    public class ILil implements b.a {
        public ILil(VideoPlayerView videoPlayerView) {
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView$Ilil reason: case insensitive filesystem */
    public class C0163Ilil implements d {
        public C0163Ilil(VideoPlayerView videoPlayerView, int i2, IVideoParams iVideoParams) {
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView$I丨L reason: invalid class name */
    public class IL implements q.b {
        public final /* synthetic */ int IL1Iii;

        public IL(int i2) {
            this.IL1Iii = i2;
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView$I丨iL reason: invalid class name */
    public static class IiL extends Handler {
        public WeakReference<VideoPlayerView> IL1Iii;

        public IiL(VideoPlayerView videoPlayerView) {
            this.IL1Iii = new WeakReference<>(videoPlayerView);
        }

        public /* synthetic */ IiL(VideoPlayerView videoPlayerView, ILil iLil) {
            this(videoPlayerView);
        }

        public void handleMessage(Message message) {
            VideoPlayerView videoPlayerView = (VideoPlayerView) this.IL1Iii.get();
            if (videoPlayerView != null) {
                int i2 = message.what;
                if (i2 == 1000) {
                    videoPlayerView.llI = false;
                    videoPlayerView.f236l1IIi1 = -1.0d;
                    if (videoPlayerView.LlLI1.size() == 1) {
                        f fVar = (f) videoPlayerView.f241lLi1LL.get(((Integer) videoPlayerView.LlLI1.get(0)).intValue());
                        videoPlayerView.f227L1l = fVar.b();
                        if (videoPlayerView.f235ill) {
                            videoPlayerView.f252 += videoPlayerView.f215ILl.getRotate()[0];
                            videoPlayerView.f215ILl.setRotate(new float[]{0.0f, 0.0f});
                            return;
                        }
                        fVar.a(videoPlayerView.f215ILl);
                    }
                } else if (i2 == 1001 && !videoPlayerView.f235ill) {
                    videoPlayerView.setApplyCameraConstraint(false);
                }
            }
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView$iI丨LLL1 reason: invalid class name */
    public class iILLL1 implements com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener.IL1Iii {
        public iILLL1(VideoPlayerView videoPlayerView) {
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView$l丨Li1LL reason: invalid class name */
    public class lLi1LL implements OnGestureChangeListener {
        public lLi1LL() {
        }

        public final void IL1Iii() {
            IiL r0 = VideoPlayerView.this.f223LIll;
            if (r0 != null) {
                r0.removeMessages(1000);
                VideoPlayerView.this.f223LIll.sendEmptyMessageDelayed(1000, 100);
            }
        }

        public final void ILil() {
            VideoPlayerView videoPlayerView = VideoPlayerView.this;
            if (!videoPlayerView.llI) {
                videoPlayerView.llI = true;
            }
            IiL r0 = VideoPlayerView.this.f223LIll;
            if (r0 != null) {
                r0.removeMessages(1000);
            }
        }

        public void onActionUp() {
            if (VideoPlayerView.this.LlLI1.size() == 1) {
                int intValue = ((Integer) VideoPlayerView.this.LlLI1.get(0)).intValue();
                if (VideoPlayerView.this.IL1Iii() && VideoPlayerView.this.IL1Iii(intValue)) {
                    IL1Iii();
                }
            }
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onUp();
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            boolean z = true;
            if (VideoPlayerView.this.LlLI1.size() == 1) {
                int intValue = ((Integer) VideoPlayerView.this.LlLI1.get(0)).intValue();
                if (VideoPlayerView.this.IL1Iii() && VideoPlayerView.this.IL1Iii(intValue)) {
                    f fVar = (f) VideoPlayerView.this.f241lLi1LL.get(intValue);
                    VideoPlayerView videoPlayerView = VideoPlayerView.this;
                    if (videoPlayerView.f235ill) {
                        videoPlayerView.f252 += videoPlayerView.f215ILl.getRotate()[0];
                        VideoPlayerView.this.f215ILl.setRotate(new float[]{0.0f, 0.0f});
                    } else {
                        fVar.a(videoPlayerView.f215ILl);
                        VideoPlayerView.this.setApplyCameraConstraint(true);
                    }
                    float a2 = a.a.a.a.e.a.l.d.a(fVar.f513b.getPitch(), 0.0f);
                    VideoPlayerView videoPlayerView2 = VideoPlayerView.this;
                    double d2 = (double) a2;
                    if (d2 > -1.5707963267948966d && d2 <= 1.5707963267948966d) {
                        z = false;
                    }
                    videoPlayerView2.f245iILLl = z;
                }
            }
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                return iGestureListener.onDown(motionEvent);
            }
            return false;
        }

        public void onFlingAnimation() {
            ILil();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimation();
            }
        }

        public void onFlingAnimationEnd() {
            IL1Iii();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimationEnd();
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onLongPress(motionEvent);
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            ILil();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onScroll();
            }
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                return iGestureListener.onTap(motionEvent);
            }
            return false;
        }

        public void onZoom() {
            ILil();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onZoom();
            }
        }

        public void onZoomAnimation() {
            ILil();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimation();
            }
        }

        public void onZoomAnimationEnd() {
            IL1Iii();
            IGestureListener iGestureListener = VideoPlayerView.this.L1iI1;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimationEnd();
            }
        }
    }

    public VideoPlayerView(Context context) {
        super(context);
        m40iILLL1();
    }

    public VideoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m40iILLL1();
    }

    public VideoPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m40iILLL1();
    }

    @TargetApi(21)
    public VideoPlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        m40iILLL1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I11L() {
        ImageView imageView = this.iI;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I11li1() {
        synchronized (this) {
            m42lIlii();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(int i2, Object obj) {
        if (this.f220L11) {
            ImageView imageView = this.iI;
            if (imageView != null) {
                if (i2 == 2) {
                    imageView.setVisibility(4);
                    return;
                }
                float[] fArr = (float[]) obj;
                imageView.setVisibility(0);
                LayoutParams layoutParams = this.iI.getLayoutParams();
                layoutParams.width = (int) (((fArr[2] - fArr[0]) * ((float) this.f234ili11.getWidth())) + ((float) a.a.a.a.b.a.a(10.0f)));
                layoutParams.height = (int) (((fArr[3] - fArr[1]) * ((float) this.f234ili11.getHeight())) + ((float) a.a.a.a.b.a.a(10.0f)));
                this.iI.setLayoutParams(layoutParams);
                this.iI.setX((this.f234ili11.getX() + (fArr[0] * ((float) this.f234ili11.getWidth()))) - ((float) a.a.a.a.b.a.a(5.0f)));
                this.iI.setY((this.f234ili11.getY() + (fArr[1] * ((float) this.f234ili11.getHeight()))) - ((float) a.a.a.a.b.a.a(5.0f)));
            }
        }
    }

    public static /* synthetic */ void IL1Iii(VideoPlayerView videoPlayerView) {
        if (videoPlayerView.f212I1L11L) {
            double videoCurrentPosition = videoPlayerView.getVideoCurrentPosition();
            double videoTotalDuration = videoPlayerView.getVideoTotalDuration();
            for (IVideoPlayerViewListener onProgressChanged : videoPlayerView.f244i11i) {
                onProgressChanged.onProgressChanged(videoCurrentPosition, videoTotalDuration);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(String str, String str2, String str3, String str4) {
        IL1Iii(str, str2, str4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void IL1Iii(boolean z) {
        if (z) {
            resume();
            return;
        }
        m41lIiI();
        a.a.a.a.e.a.g.e eVar = this.lL;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ILil(int i2, Object obj) {
        post(new e.b.c.b.b.a.d.d(this, i2, obj));
    }

    /* renamed from: I丨iL reason: contains not printable characters */
    public static /* synthetic */ void m25IiL(VideoPlayerView videoPlayerView) {
        if (videoPlayerView != null) {
            l1Lll.d("createResources");
            videoPlayerView.m44lLi1LL();
            videoPlayerView.I1I();
            videoPlayerView.f233iiIIi11 = new ArrayList();
            for (IVideoParams iVideoParams : ((a.a.a.a.e.a.c.g) videoPlayerView.IL1Iii).f463a) {
                Class<VideoPlayerView> cls = VideoPlayerView.class;
                a.a.a.a.e.a.a aVar = new a.a.a.a.e.a.a();
                iVideoParams.addReference(aVar);
                videoPlayerView.f233iiIIi11.add(aVar);
            }
            BMGPreviewerSessionRender bMGPreviewerSessionRender = new BMGPreviewerSessionRender(videoPlayerView.getContext().getApplicationContext(), new m(videoPlayerView), new a.a.a.a.e.a.c.l(videoPlayerView), new Handler(Looper.getMainLooper()));
            videoPlayerView.f216I = bMGPreviewerSessionRender;
            bMGPreviewerSessionRender.setFps((double) videoPlayerView.ILil.getRenderFps());
            Integer renderBackgroundColor = videoPlayerView.ILil.getRenderBackgroundColor();
            if (renderBackgroundColor != null) {
                videoPlayerView.f216I.setClearColor((float) Color.red(renderBackgroundColor.intValue()), (float) Color.green(renderBackgroundColor.intValue()), (float) Color.blue(renderBackgroundColor.intValue()), (float) Color.alpha(renderBackgroundColor.intValue()));
            }
            videoPlayerView.f216I.setEndBehaviour(videoPlayerView.ILil.isLooping() ? EndBehaviour.LOOP : EndBehaviour.PAUSE_ON_LAST_FRAME);
            videoPlayerView.f216I.setPreviewQueueMode(videoPlayerView.ILil.getQueueMode());
            videoPlayerView.f216I.setForceVideoKeyFrameOnly(videoPlayerView.ILil.isForceVideoKeyFrameOnly());
            videoPlayerView.f216I.bindView(videoPlayerView.f234ili11);
            videoPlayerView.f215ILl = new GestureController(videoPlayerView.getContext());
            videoPlayerView.IL1Iii((Boolean) null);
            if (!videoPlayerView.IL1Iii() && (videoPlayerView.isGestureHorizontalEnabled() || videoPlayerView.isGestureVerticalEnabled() || videoPlayerView.isGestureZoomEnabled())) {
                l1Lll.e("camera is not supported, but gesture horizontal/vertical/zoom is enabled, ignored!");
            }
            videoPlayerView.f215ILl.setOnGestureChangeListener(videoPlayerView.getOnGestureChangeListener());
            HeadTrackerController headTrackerController = new HeadTrackerController(videoPlayerView.getContext(), 0);
            videoPlayerView.Lil = headTrackerController;
            headTrackerController.setAnimationFrequency(0);
            videoPlayerView.I11L = true;
            return;
        }
        throw null;
    }

    private double[] getCurrentPlayRangeMedia() {
        double[] customizedPlayRange = this.ILil.getCustomizedPlayRange();
        if (this.ILil.isPlayRangeEnabled() && !Arrays.equals(customizedPlayRange, new double[]{-1.0d, -1.0d})) {
            return customizedPlayRange;
        }
        return new double[]{0.0d, this.f232iILilI.getDuration()};
    }

    /* access modifiers changed from: private */
    public j[] getCurrentPlayRangeSrc() {
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size() - 1);
        return new j[]{new j(0, 0.0d), convertMediaTimeToSrcPosition(this.f232iILilI.getDuration())};
    }

    /* access modifiers changed from: private */
    public FilterInfo[] getCutSceneFilterInfos() {
        FilterInfo a2 = this.I1I.a(this.ILil.isApplyWatermark()) ? this.I1I.a(this.f234ili11.getMeasuredWidth(), this.f234ili11.getMeasuredHeight(), this.ILil.isApplyWatermark()) : null;
        if (a2 == null) {
            return null;
        }
        return new FilterInfo[]{a2};
    }

    private int getGraphicViewBackgroundColor() {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        return (iPlayVideoParams == null || iPlayVideoParams.getRenderBackgroundColor() == null) ? Color.parseColor("#000000") : this.ILil.getRenderBackgroundColor().intValue();
    }

    private FrameLayout.LayoutParams getGraphicViewLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        h hVar = this.IL1Iii;
        int[] iArr = hVar != null ? ((a.a.a.a.e.a.c.g) hVar).f468f : null;
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

    private OnGestureChangeListener getOnGestureChangeListener() {
        return new lLi1LL();
    }

    private int getRenderBackgroundColor() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public /* synthetic */ void m27iILLL1(int i2) {
        ((f) this.f241lLi1LL.get(i2)).e();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (I1I(r0) == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r6.f216I.onClipRenderInfoChange(Ilil(r0), ((a.a.a.a.e.a.e.n) r6.f228L11I.get(r0)).a(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r6.f216I.onClipRenderInfoChange(Ilil(r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void llliI() {
        /*
            r6 = this;
            com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender r0 = r6.f216I
            if (r0 == 0) goto L_0x005a
            monitor-enter(r6)
            java.util.List<java.lang.Integer> r0 = r6.LlLI1     // Catch:{ all -> 0x0057 }
            int r0 = r0.size()     // Catch:{ all -> 0x0057 }
            r1 = 1
            if (r0 == r1) goto L_0x0017
            com.arashivision.insta360.basemedia.log.MediaLogger r0 = l1Lll     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = "only mClipIndexList.size() = 1 support updateClipRenderInfo()"
            r0.w(r1)     // Catch:{ all -> 0x0057 }
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            return
        L_0x0017:
            java.util.List<java.lang.Integer> r0 = r6.LlLI1     // Catch:{ all -> 0x0057 }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0057 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0057 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0057 }
            java.util.List<java.lang.Double> r2 = r6.f240llL1ii     // Catch:{ all -> 0x0057 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0057 }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ all -> 0x0057 }
            double r1 = r1.doubleValue()     // Catch:{ all -> 0x0057 }
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            boolean r3 = r6.I1I(r0)
            if (r3 == 0) goto L_0x004d
            com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender r3 = r6.f216I
            com.arashivision.arvbmg.previewer.ClipRenderInfo r4 = r6.Ilil(r0)
            java.util.List<a.a.a.a.e.a.e.n> r5 = r6.f228L11I
            java.lang.Object r0 = r5.get(r0)
            a.a.a.a.e.a.e.n r0 = (a.a.a.a.e.a.e.n) r0
            boolean r0 = r0.a(r1)
            r3.onClipRenderInfoChange(r4, r0)
            goto L_0x005a
        L_0x004d:
            com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender r1 = r6.f216I
            com.arashivision.arvbmg.previewer.ClipRenderInfo r0 = r6.Ilil(r0)
            r1.onClipRenderInfoChange(r0)
            goto L_0x005a
        L_0x0057:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0057 }
            throw r0
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.llliI():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public /* synthetic */ void m30lLi1LL(int i2) {
        ((f) this.f241lLi1LL.get(i2)).e();
        ((f) this.f241lLi1LL.get(i2)).d();
    }

    /* access modifiers changed from: private */
    public void setApplyCameraConstraint(boolean z) {
        ILil(((Integer) this.LlLI1.get(0)).intValue(), z);
    }

    /* access modifiers changed from: private */
    public void setLoading(boolean z) {
        int i2;
        ImageView imageView;
        MediaLogger mediaLogger = l1Lll;
        StringBuilder sb = new StringBuilder();
        sb.append("setLoading ");
        sb.append(z);
        mediaLogger.d(sb.toString());
        if (z) {
            if (this.ILil.getLoadingImageResId() != -1) {
                this.f222LIl.setImageResource(this.ILil.getLoadingImageResId());
            }
            this.f222LIl.setBackgroundColor(this.ILil.getLoadingBackgroundColor());
            imageView = this.f222LIl;
            i2 = 0;
        } else {
            imageView = this.f222LIl;
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.f247lL = z;
        IBasePlayerViewListener iBasePlayerViewListener = this.I1;
        if (iBasePlayerViewListener != null) {
            iBasePlayerViewListener.onLoadingStatusChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: 丨lL reason: contains not printable characters */
    public /* synthetic */ void m33lL() {
        ImageView imageView = this.iI;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void I1I() {
        GraphicView graphicView = this.f234ili11;
        if (graphicView != null) {
            graphicView.setLayoutParams(getGraphicViewLayoutParams());
            LayoutParams layoutParams = this.f234ili11.getLayoutParams();
            if (this.f216I != null) {
                List<Integer> list = this.LlLI1;
                if (list != null && list.size() > 0) {
                    this.f216I.onFilterChanged(IL1Iii(((Integer) this.LlLI1.get(0)).intValue(), false, layoutParams.width, layoutParams.height));
                }
            }
        }
    }

    public final boolean I1I(int i2) {
        return this.f228L11I.get(i2) != null && ((n) this.f228L11I.get(i2)).c();
    }

    public final void IL1Iii(Boolean bool) {
        this.f215ILl.setEnabled(bool == null ? isGestureEnabled() : bool.booleanValue());
        GestureController gestureController = this.f215ILl;
        boolean z = true;
        boolean z2 = bool == null ? IL1Iii() && isGestureHorizontalEnabled() : bool.booleanValue();
        gestureController.setHorizontalEnabled(z2);
        GestureController gestureController2 = this.f215ILl;
        boolean z3 = bool == null ? IL1Iii() && isGestureVerticalEnabled() : bool.booleanValue();
        gestureController2.setVerticalEnabled(z3);
        GestureController gestureController3 = this.f215ILl;
        boolean z4 = bool == null ? IL1Iii() && isGestureZoomEnabled() : bool.booleanValue();
        gestureController3.setZoomEnabled(z4);
        GestureController gestureController4 = this.f215ILl;
        boolean z5 = bool == null ? IL1Iii() && isGestureFovChangeEnabled() : bool.booleanValue();
        gestureController4.setFovChangeEnabled(z5);
        GestureController gestureController5 = this.f215ILl;
        if (bool != null) {
            z = bool.booleanValue();
        } else if (!IL1Iii() || !isGestureDistanceChangeEnabled()) {
            z = false;
        }
        gestureController5.setDistanceChangeEnabled(z);
    }

    public final boolean IL1Iii(int i2) {
        List<f> list = this.f241lLi1LL;
        return (list == null || list.get(i2) == null || !((f) this.f241lLi1LL.get(i2)).a()) ? false : true;
    }

    public final FilterInfo[] IL1Iii(int i2, boolean z) {
        LayoutParams layoutParams = this.f234ili11.getLayoutParams();
        return IL1Iii(i2, z, layoutParams != null ? layoutParams.width : this.f234ili11.getMeasuredWidth(), layoutParams != null ? layoutParams.height : this.f234ili11.getMeasuredHeight());
    }

    public final FilterInfo[] IL1Iii(int i2, boolean z, int i3, int i4) {
        BlendImageInfo blendImageInfo;
        FilterInfo filterInfo = null;
        if (this.ILil.isApplyFlash()) {
            a.a.a.a.e.a.i.a.b bVar = new a.a.a.a.e.a.i.a.b();
            getScreenRatio();
            getCameraTransform();
            ((a.a.a.a.e.a.e.h) this.ILL.get(i2)).a(getVideoCurrentPosition(), convertMediaTimeToSrcPosition(getVideoCurrentPosition()).f481b, bVar);
            blendImageInfo = new BlendImageInfo();
            blendImageInfo.setImageInfo(new ImageInfo());
        } else {
            blendImageInfo = null;
        }
        boolean z2 = false;
        FilterInfo[] a2 = ((l) this.Ilil.get(i2)).a(false, blendImageInfo);
        a.a.a.a.e.a.e.g gVar = this.I1I;
        if (this.ILil.isApplyWatermark() && !z) {
            z2 = true;
        }
        if (gVar.a(z2)) {
            filterInfo = this.I1I.a(i3, i4, this.ILil.isApplyWatermark());
        }
        return a.a.a.a.b.a.a(a2, filterInfo);
    }

    public final void ILL() {
        int i2 = 0;
        while (i2 < this.f246il.size() && i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size() - 1) {
            c cVar = (c) this.f246il.get(i2);
            if (!cVar.f496a.f582a.f593c) {
                cVar.a((Transform[]) null, (int[]) null);
            } else if (((f) this.f241lLi1LL.get(i2)).a() && ((f) this.f241lLi1LL.get(i2 + 1)).a()) {
                double clipEndTimeMsExcludeEndCutscenes = this.f216I.getClipEndTimeMsExcludeEndCutscenes(i2);
                j convertMediaTimeToSrcPosition = convertMediaTimeToSrcPosition(clipEndTimeMsExcludeEndCutscenes - 1.0d);
                Transform a2 = ((p) this.f231iILLL1.get(convertMediaTimeToSrcPosition.f480a)).a(convertMediaTimeToSrcPosition.f481b, true);
                j convertMediaTimeToSrcPosition2 = convertMediaTimeToSrcPosition(clipEndTimeMsExcludeEndCutscenes + ((double) c.a(cVar.f496a)));
                cVar.a(new Transform[]{a2, ((p) this.f231iILLL1.get(convertMediaTimeToSrcPosition2.f480a)).a(convertMediaTimeToSrcPosition2.f481b, true)}, ((a.a.a.a.e.a.c.g) this.IL1Iii).f468f);
            }
            i2++;
        }
    }

    public final boolean ILil(int i2) {
        List<p> list = this.f231iILLL1;
        if (!(list == null || list.get(i2) == null)) {
            a.a.a.a.e.a.e.k.d dVar = ((p) this.f231iILLL1.get(i2)).f563b;
            if ((dVar == null || dVar.getFileType() == FileType.UNPANORAMA) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public final void m34ILl() {
        this.f220L11 = false;
        this.LLL = null;
        this.f242lliiI1 = 0;
        removeCallbacks(this.f224LlIl);
        this.f224LlIl = null;
    }

    public final void Ilil() {
        this.iIilII1 = new ConcurrentLinkedQueue<>();
        this.LlLI1 = new ArrayList();
        this.f240llL1ii = new ArrayList();
        this.f239lIlii = new ArrayList();
        synchronized (this) {
            this.I1I = new a.a.a.a.e.a.e.g(this.IL1Iii);
            this.f218IL = new ArrayList();
            this.Ilil = new ArrayList();
            this.f241lLi1LL = new ArrayList();
            this.f231iILLL1 = new ArrayList();
            this.f219IiL = new ArrayList();
            this.f228L11I = new ArrayList();
            this.ILL = new ArrayList();
            List<IVideoParams> list = ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a;
            for (int i2 = 0; i2 < list.size(); i2++) {
                IVideoParams iVideoParams = (IVideoParams) list.get(i2);
                q qVar = new q();
                qVar.f567b = new IL(i2);
                qVar.f566a = iVideoParams;
                this.f218IL.add(qVar);
                this.Ilil.add(new l(iVideoParams, iVideoParams));
                f fVar = new f();
                fVar.a((a.a.a.a.e.a.e.k.b) iVideoParams);
                this.f241lLi1LL.add(fVar);
                if (IL1Iii(i2)) {
                    p pVar = new p();
                    pVar.f562a = iVideoParams;
                    pVar.a((a.a.a.a.e.a.e.k.d) iVideoParams);
                    this.f231iILLL1.add(pVar);
                } else {
                    this.f231iILLL1.add(null);
                }
                i iVar = new i();
                iVar.f524a = iVideoParams;
                iVar.a((a.a.a.a.e.a.d) iVideoParams, (d) new C0163Ilil(this, i2, iVideoParams), false);
                this.f219IiL.add(iVar);
                n nVar = new n();
                nVar.a(iVideoParams, iVideoParams);
                this.f228L11I.add(nVar);
                if (this.ILil.isApplyFlash()) {
                    a.a.a.a.e.a.e.h hVar = new a.a.a.a.e.a.e.h();
                    hVar.f521a = iVideoParams;
                    this.ILL.add(hVar);
                }
            }
            this.f246il = new ArrayList();
            List<a.a.a.a.e.a.i.c> list2 = ((a.a.a.a.e.a.c.g) this.IL1Iii).f464b;
            for (int i3 = 0; i3 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size() - 1; i3++) {
                c cVar = new c();
                if (i3 < list2.size()) {
                    cVar.f496a = (a.a.a.a.e.a.i.c) list2.get(i3);
                } else {
                    cVar.f496a = new a.a.a.a.e.a.i.c(a.a.a.a.e.a.i.c.a.NONE, 0);
                }
                this.f246il.add(cVar);
            }
            this.f226Ll1 = new a.a.a.a.e.a.e.d();
            this.f237lIiI = new a.a.a.a.e.a.e.e();
        }
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public final void m35IL() {
        ImageView imageView = this.f222LIl;
        if (imageView != null) {
            imageView.setLayoutParams(getGraphicViewLayoutParams());
        }
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public final boolean m36IL(int i2) {
        boolean z;
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null && iPlayVideoParams.isApplyProxy()) {
            List<q> list = this.f218IL;
            if (!(list == null || list.get(i2) == null)) {
                q qVar = (q) this.f218IL.get(i2);
                String[] a2 = qVar.a();
                if (a2.length != 0) {
                    int length = a2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            String str = a2[i3];
                            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                                break;
                            }
                            i3++;
                        } else if (qVar.f566a.isVideo() && qVar.d()) {
                            z = true;
                        }
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void Lil() {
        if (IL1Iii()) {
            if (this.LlLI1.size() == 1) {
                ((f) this.f241lLi1LL.get(((Integer) this.LlLI1.get(0)).intValue())).a(this.f215ILl);
            }
            this.f236l1IIi1 = -1.0d;
            this.llI = false;
            this.f227L1l = null;
            this.f223LIll.removeMessages(1000);
        }
    }

    public final void LlLI1() {
        this.iIilII1.offer(new e.b.c.b.b.a.d.b(this));
    }

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public final synchronized void m38Ll1() {
        this.iIlLiL = -1;
        this.I11li1 = -1;
        this.f247lL = false;
        this.f212I1L11L = false;
        this.f214ILLIi = false;
        ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = this.iIilII1;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
            this.iIilII1 = null;
        }
        this.I11L = false;
        this.llliI = false;
        this.f229LlLLL = -1;
        this.f238lIII = -1;
        this.LL1IL = -1.0d;
        this.f221L111 = false;
        this.f250LLlI1 = -1;
        this.f217IIi = -1;
        this.f242lliiI1 = 0;
        this.f230iI1iI = -1;
        this.f2511 = false;
        this.f245iILLl = false;
        this.f220L11 = false;
        this.llI = false;
        this.f236l1IIi1 = -1.0d;
        this.f227L1l = null;
        this.f223LIll.removeMessages(1000);
        this.f217IIi = -2;
        this.f235ill = false;
        this.f252 = 0.0f;
        this.f220L11 = false;
        this.f242lliiI1 = 0;
        this.f230iI1iI = -1;
        this.f2511 = false;
        List<Integer> list = this.LlLI1;
        if (list != null) {
            list.clear();
            this.LlLI1 = null;
        }
        List<Double> list2 = this.f240llL1ii;
        if (list2 != null) {
            list2.clear();
            this.f240llL1ii = null;
        }
        List<Double> list3 = this.f239lIlii;
        if (list3 != null) {
            list3.clear();
            this.f239lIlii = null;
        }
    }

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public final boolean m39L11I() {
        boolean z = this.iIlLiL >= 0 && this.I11li1 == this.iIlLiL;
        if (!z) {
            l1Lll.w("playId is not matched, maybe player is destroyed?");
        }
        return z;
    }

    public void addVideoPlayerViewListener(IVideoPlayerViewListener iVideoPlayerViewListener) {
        if (iVideoPlayerViewListener == null) {
            l1Lll.w("addVideoPlayerViewListener, but videoPlayerViewListener is null, ignored!");
            return;
        }
        iVideoPlayerViewListener.setCallback(new IL1Iii(this));
        if (this.f244i11i == null) {
            this.f244i11i = new ArrayList();
        }
        if (!this.f244i11i.contains(iVideoPlayerViewListener)) {
            this.f244i11i.add(iVideoPlayerViewListener);
        }
    }

    public void clearVideoPlayerViewListener() {
        List<IVideoPlayerViewListener> list = this.f244i11i;
        if (list != null) {
            list.clear();
        }
    }

    public j convertMediaTimeToSrcPosition(double d2) {
        Previewer2 previewer2 = this.f232iILilI;
        String str = "convertMediaTimeToSrcPosition called before setParams or after destroyResources(true)";
        if (previewer2 == null) {
            l1Lll.e(str);
            return new j(0, 0.0d);
        }
        SrcPosition mapMediaTimeToSrcTime = previewer2.mapMediaTimeToSrcTime(d2);
        if (mapMediaTimeToSrcTime != null) {
            return new j(mapMediaTimeToSrcTime.clipIndex, mapMediaTimeToSrcTime.clipSrcProgressTimeMs);
        }
        l1Lll.e(str);
        return new j(0, 0.0d);
    }

    public double convertMediaTimeToSrcTime(double d2) {
        return convertMediaTimeToSrcPosition(d2).f481b;
    }

    public double convertSrcPositionToMediaTime(j jVar) {
        Previewer2 previewer2 = this.f232iILilI;
        String str = "convertSrcPositionToMediaTime called before setParams or after destroyResources(true)";
        if (previewer2 != null) {
            MediaPosition mapSrcTimeToMediaTime = previewer2.mapSrcTimeToMediaTime(jVar.f480a, jVar.f481b);
            if (mapSrcTimeToMediaTime != null) {
                return mapSrcTimeToMediaTime.mediaTimeMs;
            }
        }
        l1Lll.e(str);
        return 0.0d;
    }

    public double convertSrcTimeToMediaTime(double d2) {
        return convertSrcPositionToMediaTime(new j(0, d2));
    }

    public void deInitDollyZoom() {
        this.f216I.deInitDollyZoom();
    }

    public void destroyResources() {
        destroyResources(false);
    }

    public void destroyResources(boolean z) {
        MediaLogger mediaLogger = l1Lll;
        StringBuilder a2 = e.a.a.a.a.a("destroyResources, thread name: ");
        a2.append(Thread.currentThread().getName());
        a2.append(", thread id: ");
        a2.append(Thread.currentThread().getId());
        mediaLogger.d(a2.toString());
        if (this.f230iI1iI >= 0 && Thread.currentThread().getId() == this.f230iI1iI) {
            l1Lll.e("destroyResources() called from RenderThread");
        }
        this.I11li1 = -1;
        synchronized (this) {
            if (this.f216I != null) {
                this.f216I.terminate();
                this.f216I = null;
            }
        }
        IiL r0 = this.f223LIll;
        if (r0 != null) {
            r0.removeCallbacksAndMessages(null);
        }
        h hVar = this.IL1Iii;
        int i2 = 0;
        if (!(hVar == null || ((a.a.a.a.e.a.c.g) hVar).f463a == null)) {
            for (int i3 = 0; i3 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size(); i3++) {
                List<a> list = this.f233iiIIi11;
                if (!(list == null || list.get(i3) == null)) {
                    ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i3)).removeReference((a) this.f233iiIIi11.get(i3));
                }
            }
            this.f233iiIIi11 = null;
        }
        GraphicView graphicView = this.f234ili11;
        if (graphicView != null) {
            removeView(graphicView);
            this.f234ili11.destroy();
            this.f234ili11 = null;
        }
        ImageView imageView = this.iI;
        if (imageView != null) {
            removeView(imageView);
            this.iI = null;
        }
        if (this.f225LlLiLL != null) {
            while (true) {
                TextView[] textViewArr = this.f225LlLiLL;
                if (i2 >= textViewArr.length) {
                    break;
                }
                if (textViewArr[i2] != null) {
                    removeView(textViewArr[i2]);
                    this.f225LlLiLL[i2] = null;
                }
                i2++;
            }
        }
        GestureController gestureController = this.f215ILl;
        if (gestureController != null) {
            gestureController.destroy();
            this.f215ILl = null;
        }
        HeadTrackerController headTrackerController = this.Lil;
        if (headTrackerController != null) {
            headTrackerController.destroy();
            this.Lil = null;
        }
        h hVar2 = this.IL1Iii;
        if (hVar2 != null) {
            for (IVideoParams cancelStabilizer : ((a.a.a.a.e.a.c.g) hVar2).f463a) {
                cancelStabilizer.cancelStabilizer();
            }
        }
        if (this.I1I != null) {
            this.I1I = null;
        }
        List<q> list2 = this.f218IL;
        if (list2 != null) {
            for (q qVar : list2) {
                if (qVar != null) {
                    qVar.b();
                    qVar.f567b = null;
                    qVar.f568c.f544d = true;
                    qVar.b();
                }
            }
            this.f218IL.clear();
            this.f218IL = null;
        }
        List<l> list3 = this.Ilil;
        if (list3 != null) {
            list3.clear();
            this.Ilil = null;
        }
        List<f> list4 = this.f241lLi1LL;
        if (list4 != null) {
            for (f fVar : list4) {
                if (fVar != null) {
                    fVar.c();
                }
            }
            this.f241lLi1LL.clear();
            this.f241lLi1LL = null;
        }
        List<p> list5 = this.f231iILLL1;
        if (list5 != null) {
            for (p pVar : list5) {
                if (pVar != null) {
                    pVar.f564c.a();
                    pVar.f563b = null;
                    pVar.f562a = null;
                }
            }
            this.f231iILLL1.clear();
            this.f231iILLL1 = null;
        }
        List<i> list6 = this.f219IiL;
        if (list6 != null) {
            for (i a3 : list6) {
                a3.a();
            }
            this.f219IiL.clear();
            this.f219IiL = null;
        }
        if (this.f226Ll1 != null) {
            this.f226Ll1 = null;
        }
        a.a.a.a.e.a.e.e eVar = this.f237lIiI;
        if (eVar != null) {
            FrameLayout frameLayout = eVar.f509a;
            if (frameLayout != null) {
                ((ViewGroup) frameLayout.getParent()).removeView(eVar.f509a);
                eVar.f509a = null;
                eVar.f510b = null;
            }
            this.f237lIiI = null;
        }
        List<n> list7 = this.f228L11I;
        if (list7 != null) {
            list7.clear();
            this.f228L11I = null;
        }
        List<c> list8 = this.f246il;
        if (list8 != null) {
            list8.clear();
            this.f246il = null;
        }
        List<a.a.a.a.e.a.e.h> list9 = this.ILL;
        if (list9 != null) {
            for (a.a.a.a.e.a.e.h hVar3 : list9) {
                a.a.a.a.e.a.i.e eVar2 = hVar3.f522b;
                if (eVar2 != null) {
                    eVar2.b();
                }
            }
            this.ILL.clear();
            this.ILL = null;
        }
        a.a.a.a.e.a.c.i iVar = this.f243li11;
        if (iVar != null) {
            iVar.a();
            this.f243li11 = null;
        }
        m38Ll1();
        if (z) {
            this.IL1Iii = null;
            this.ILil = null;
            Previewer2 previewer2 = this.f232iILilI;
            if (previewer2 != null) {
                previewer2.free();
                this.f232iILilI = null;
            }
        }
    }

    public void enterViewFinder() {
        this.f235ill = true;
        this.f252 = 0.0f;
        setHeadTrackerEnabled(true);
        setGestureVerticalEnabled(false);
        this.Lil.lockRoll(0.0d);
        this.Lil.unlockPitchRoll();
        setApplyCameraConstraint(true);
    }

    public void enterViewFinderLittleStarMode(double d2, double d3) {
        this.Lil.lockPitchRoll(d2, d3);
    }

    public int getBeautyFilterLevel() {
        return getBeautyFilterLevel(0);
    }

    public int getBeautyFilterLevel(int i2) {
        if (this.Ilil.get(i2) != null) {
            return ((l) this.Ilil.get(i2)).f533a.getBeautyFilterLevel();
        }
        return 0;
    }

    public float getBlendAngleRad() {
        return getBlendAngleRad(0);
    }

    public float getBlendAngleRad(int i2) {
        if (((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2) != null) {
            return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getBlendAngleRad();
        }
        return -1.0f;
    }

    public Transform getCameraTransform() {
        return getCameraTransform(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.arashivision.graphicpath.render.engine.Transform getCameraTransform(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List<a.a.a.a.e.a.e.f> r0 = r2.f241lLi1LL     // Catch:{ all -> 0x0016 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0016 }
            a.a.a.a.e.a.e.f r3 = (a.a.a.a.e.a.e.f) r3     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x0012
            com.arashivision.graphicpath.render.engine.Transform r1 = r3.b()     // Catch:{ all -> 0x0016 }
        L_0x0012:
            monitor-exit(r2)
            return r1
        L_0x0014:
            monitor-exit(r2)
            return r1
        L_0x0016:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.getCameraTransform(int):com.arashivision.graphicpath.render.engine.Transform");
    }

    public double[] getClipPositionRange(int i2) {
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
        return new double[]{convertSrcPositionToMediaTime(new j(i2, iVideoParams.getTrimStart())), convertSrcPositionToMediaTime(new j(i2, iVideoParams.getTrimEnd()))};
    }

    public Constraint getConstraint() {
        return getConstraint(0);
    }

    public Constraint getConstraint(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getConstraint();
    }

    public int[] getConstraintRatio() {
        return getConstraintRatio(0);
    }

    public int[] getConstraintRatio(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getConstraintRatio();
    }

    public synchronized j[] getCurrentFrameSrcTime() {
        if (this.LlLI1 == null) {
            return null;
        }
        List<Double> list = this.f240llL1ii;
        if (list != null) {
            if (!list.isEmpty()) {
                int size = this.LlLI1.size();
                j[] jVarArr = new j[size];
                for (int i2 = 0; i2 < size; i2++) {
                    jVarArr[i2] = new j(((Integer) this.LlLI1.get(i2)).intValue(), ((Double) this.f240llL1ii.get(i2)).doubleValue());
                }
                return jVarArr;
            }
        }
        j convertMediaTimeToSrcPosition = convertMediaTimeToSrcPosition(this.ILil.getRestorePlayPosition());
        if (convertMediaTimeToSrcPosition == null) {
            return null;
        }
        return new j[]{convertMediaTimeToSrcPosition};
    }

    public synchronized double getCurrentFrameTime() {
        j[] currentFrameSrcTime = getCurrentFrameSrcTime();
        if (currentFrameSrcTime != null) {
            if (currentFrameSrcTime.length != 0) {
                return currentFrameSrcTime[0].f481b;
            }
        }
        return -1.0d;
    }

    public double[] getCutScenePositionRange(int i2) {
        double d2;
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender != null) {
            d2 = bMGPreviewerSessionRender.getClipEndTimeMsExcludeEndCutscenes(i2);
        } else {
            Previewer2 previewer2 = this.f232iILilI;
            d2 = previewer2 != null ? previewer2.getClipEndTimeMsExcludeEndCutscenes(i2) : -1.0d;
        }
        if (d2 <= 0.0d) {
            return new double[]{0.0d, 0.0d};
        }
        a.a.a.a.e.a.i.c cVar = null;
        if (i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f464b.size()) {
            cVar = (a.a.a.a.e.a.i.c) ((a.a.a.a.e.a.c.g) this.IL1Iii).f464b.get(i2);
        }
        if (cVar != null) {
            return new double[]{d2, d2 + ((double) cVar.f583b)};
        }
        l1Lll.w("getClipCutScenePositionRange, but no cutScene!");
        return new double[]{d2, d2};
    }

    public List<a.a.a.a.e.a.h.a> getExtraViewControllerList(int i2) {
        List<i> list = this.f219IiL;
        if (list != null) {
            return ((i) list.get(i2)).f530g;
        }
        return new ArrayList();
    }

    public int getFitMode() {
        return getFitMode(0);
    }

    public int getFitMode(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getFitMode();
    }

    public Pair<Integer, Integer> getGraphSize() {
        return new Pair<>(Integer.valueOf(this.f234ili11.getWidth()), Integer.valueOf(this.f234ili11.getHeight()));
    }

    public double getHeadTrackerPitch() {
        return this.Lil.getCurrentPitchOfHeadTrackerOrientation();
    }

    public double getHeadTrackerRoll() {
        return this.Lil.getCurrentRollOfHeadTrackerOrientation();
    }

    public a.a.a.a.a.d.a getLutFilter() {
        return getLutFilter(0);
    }

    public a.a.a.a.a.d.a getLutFilter(int i2) {
        a.a.a.a.a.d.a aVar;
        if (this.Ilil.get(i2) == null) {
            return a.a.a.a.a.d.b.a();
        }
        a.a.a.a.e.a.e.k.g gVar = ((l) this.Ilil.get(i2)).f534b;
        if (gVar == null) {
            l.f532c.w("getLutFilter, but mVideoRenderOptionParams is null, maybe a image?");
            aVar = null;
        } else {
            aVar = gVar.getLutFilter();
        }
        return aVar;
    }

    public String getOffset() {
        return getOffset(0);
    }

    public String getOffset(int i2) {
        if (((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2) != null) {
            return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getOffsetForPlay();
        }
        return null;
    }

    public Options getOptions(boolean z) {
        if (!z && !iIlLiL()) {
            return null;
        }
        boolean z2 = false;
        for (IVideoParams isLocal : ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a) {
            z2 |= !isLocal.isLocal();
        }
        Options options = new Options();
        options.setBool(7, z2);
        options.setBool(8, true);
        options.setBool(24, true);
        options.setBool(9, !this.ILil.isImageAutoScaleEnabled());
        if (a.a.a.a.b.a.b()) {
            options.setBool(2, false);
        } else {
            options.setBool(2, true);
        }
        if (this.ILil.getNetId() != null) {
            options.setInt64(10, this.ILil.getNetId().longValue());
        }
        return options;
    }

    public IPlayVideoParams getPlayVideoParams() {
        return this.ILil;
    }

    public h getProjectParams() {
        return this.IL1Iii;
    }

    public a.a.a.a.e.a.e.e getRectSelectorDelegate() {
        return this.f237lIiI;
    }

    public float[] getRenderRect(float[] fArr) {
        return this.f216I.getFaceRect(fArr);
    }

    public int[] getScreenRatio() {
        h hVar = this.IL1Iii;
        return hVar != null ? ((a.a.a.a.e.a.c.g) hVar).f468f : new int[]{-1, -1};
    }

    public int getStabType() {
        return getStabType(0);
    }

    public int getStabType(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getStabType();
    }

    public a.a.a.a.a.g.a getStyleFilter() {
        return getStyleFilter(0);
    }

    public a.a.a.a.a.g.a getStyleFilter(int i2) {
        if (this.Ilil.get(i2) != null) {
            return ((l) this.Ilil.get(i2)).f533a.getStyleFilter();
        }
        return a.a.a.a.a.g.b.b();
    }

    public float getStyleFilterIntensity() {
        return getStyleFilterIntensity(0);
    }

    public float getStyleFilterIntensity(int i2) {
        if (this.Ilil.get(i2) != null) {
            return ((l) this.Ilil.get(i2)).f533a.getStyleFilterIntensity();
        }
        return 1.0f;
    }

    public synchronized double getVideoCurrentPosition() {
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender == null) {
            return 0.0d;
        }
        return bMGPreviewerSessionRender.getPlaybackProgress().getClockTime();
    }

    public IVideoParams getVideoParams() {
        h hVar = this.IL1Iii;
        if (hVar == null || ((a.a.a.a.e.a.c.g) hVar).f463a.isEmpty()) {
            return null;
        }
        return (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(0);
    }

    public List<IVideoParams> getVideoParamsPlaying() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            if (this.LlLI1 != null) {
                for (Integer intValue : this.LlLI1) {
                    arrayList.add(((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(intValue.intValue()));
                }
            }
        }
        return arrayList;
    }

    public synchronized double getVideoTotalDuration() {
        return getVideoTotalDuration(false);
    }

    public synchronized double getVideoTotalDuration(boolean z) {
        Previewer2 previewer2 = this.f232iILilI;
        if (previewer2 != null) {
            double duration = previewer2.getDuration();
            if (!z) {
                return duration;
            }
            getCurrentPlayRangeMedia();
        }
        return 0.0d;
    }

    public Transform getViewAngle() {
        return getViewAngle(0);
    }

    public Transform getViewAngle(int i2) {
        if (IL1Iii(i2)) {
            return ILil(i2) ? ((p) this.f231iILLL1.get(i2)).a(((Double) this.f239lIlii.get(this.LlLI1.indexOf(Integer.valueOf(i2)))).doubleValue(), true) : ((p) this.f231iILLL1.get(i2)).a();
        }
        return null;
    }

    public final void iIi1() {
        if (this.f216I != null) {
            double[] currentPlayRangeMedia = getCurrentPlayRangeMedia();
            this.f216I.setPlayRange(new PlayRange(currentPlayRangeMedia[0], currentPlayRangeMedia[1]));
        }
    }

    public final boolean iIlLiL() {
        for (int i2 = 0; i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size(); i2++) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (m36IL(i2) || iVideoParams.getLrvUrlsForPlay() == null || iVideoParams.getLrvUrlsForPlay().length == 0 || iVideoParams.isLocal()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public final void m40iILLL1() {
        this.iIi1 = EventIdUtils.getEventId();
        Context context = getContext();
        if (context instanceof b) {
            ((b) context).a(new ILil(this));
        }
        ImageView imageView = new ImageView(getContext());
        this.f222LIl = imageView;
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        this.f222LIl.setVisibility(8);
        addView(this.f222LIl);
        m38Ll1();
    }

    public void initDollyZoom(DollyZoomInfo dollyZoomInfo, IDollzoomInitCallback iDollzoomInitCallback) {
        this.f216I.initDollyZoom(dollyZoomInfo, iDollzoomInitCallback);
    }

    public boolean isColorAdjustEnabled() {
        return isColorAdjustEnabled(0);
    }

    public boolean isColorAdjustEnabled(int i2) {
        if (((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2) != null) {
            return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).isColorAdjustEnabled();
        }
        return false;
    }

    public boolean isForceVideoKeyFrameOnly() {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            return iPlayVideoParams.isForceVideoKeyFrameOnly();
        }
        return false;
    }

    public boolean isGestureDistanceChangeEnabled() {
        return IL1Iii() && this.ILil.isGestureDistanceChangeEnabled();
    }

    public boolean isGestureEnabled() {
        return this.ILil.isGestureEnabled();
    }

    public boolean isGestureFovChangeEnabled() {
        return IL1Iii() && this.ILil.isGestureFovChangeEnabled();
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

    public boolean isHeadTrackerEnabled() {
        return this.Lil.isEnabled();
    }

    public boolean isLoading() {
        return this.f247lL;
    }

    public boolean isLogoEnabled(int i2) {
        if (this.Ilil.get(i2) != null) {
            return ((l) this.Ilil.get(i2)).f533a.isLogoEnabled();
        }
        return false;
    }

    public boolean isLooping() {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            return iPlayVideoParams.isLooping();
        }
        return false;
    }

    public boolean isMotionBlur(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).isMotionBlur();
    }

    public boolean isPlaying() {
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender != null) {
            return bMGPreviewerSessionRender.isPlaying();
        }
        return false;
    }

    public boolean isPrepared() {
        return this.f212I1L11L;
    }

    public boolean isSeeking() {
        return this.f229LlLLL >= 0 || this.f238lIII >= 0;
    }

    public boolean isStabEnabled(int i2) {
        return ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getStabType() != -1;
    }

    /* renamed from: lIi丨I reason: contains not printable characters */
    public final void m41lIiI() {
        this.f216I.stopTrack();
        this.f220L11 = false;
        this.f213IIiI = -1;
        this.f242lliiI1 = 0;
        removeCallbacks(this.f224LlIl);
        this.f224LlIl = null;
    }

    /* renamed from: lI丨lii reason: contains not printable characters */
    public final void m42lIlii() {
        List<Integer> list = this.LlLI1;
        if (list != null && this.f239lIlii != null && list.size() == this.f239lIlii.size()) {
            if (this.f239lIlii.size() == 1) {
                int intValue = ((Integer) this.LlLI1.get(0)).intValue();
                double doubleValue = ((Double) this.f239lIlii.get(0)).doubleValue();
                for (int i2 = 0; i2 < this.f219IiL.size(); i2++) {
                    i iVar = (i) this.f219IiL.get(i2);
                    if (i2 == intValue) {
                        FrameLayout frameLayout = iVar.f529f;
                        if (frameLayout != null) {
                            frameLayout.setVisibility(0);
                        }
                        iVar.a(doubleValue, isPlaying());
                    } else {
                        FrameLayout frameLayout2 = iVar.f529f;
                        if (frameLayout2 != null) {
                            frameLayout2.setVisibility(8);
                        }
                    }
                }
                return;
            }
            for (i iVar2 : this.f219IiL) {
                FrameLayout frameLayout3 = iVar2.f529f;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
            }
        }
    }

    public void leaveViewFinder() {
        setApplyCameraConstraint(false);
        this.Lil.unlockPitchRoll();
        setGestureVerticalEnabled(true);
        setHeadTrackerEnabled(false);
        this.f252 = 0.0f;
        this.f235ill = false;
    }

    public void leaveViewFinderLittleStarMode() {
        this.Lil.unlockPitchRoll();
    }

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public final void m43llL1ii() {
        Transform transform;
        float f2;
        float f3;
        List<Integer> list = this.LlLI1;
        if (!(list == null || this.f239lIlii == null)) {
            if (list.size() != this.f239lIlii.size()) {
                l1Lll.e("onRenderBefore, but clip size does not equals with frame src time stamp size!");
                return;
            }
            boolean z = false;
            if (IL1Iii()) {
                if (this.LlLI1.size() == 1) {
                    int intValue = ((Integer) this.LlLI1.get(0)).intValue();
                    double doubleValue = ((Double) this.f239lIlii.get(0)).doubleValue();
                    f fVar = (f) this.f241lLi1LL.get(intValue);
                    if (fVar.a()) {
                        if (((n) this.f228L11I.get(intValue)).a(doubleValue)) {
                            ((n) this.f228L11I.get(intValue)).b(doubleValue);
                            throw null;
                        } else if (!this.f220L11) {
                            if (this.f235ill) {
                                float[] rotate = this.f215ILl.getRotate();
                                Vector3f eulerAnglesYXZ = this.Lil.getQuaternion().getEulerAnglesYXZ(new Vector3f());
                                fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                fVar.a(eulerAnglesYXZ.y(), eulerAnglesYXZ.x(), 0.0f);
                                fVar.a(a.a.a.a.e.a.l.d.a(this.f252 + rotate[0], 0.0f), 0.0f, this.f245iILLl);
                                return;
                            }
                            float a2 = this.f226Ll1.a();
                            if (a2 >= 0.0f) {
                                synchronized (this) {
                                    MediaLogger mediaLogger = l1Lll;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("animating: ");
                                    sb.append(a2);
                                    mediaLogger.d(sb.toString());
                                    Transform a3 = this.f226Ll1.a(a2);
                                    this.f215ILl.setFovDistanceConstraint(a3.getFov(), a3.getFov(), a3.getDistance(), a3.getDistance());
                                    this.f215ILl.setFov(a3.getFov());
                                    this.f215ILl.setDistance(a3.getDistance());
                                    fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                    fVar.a(a3.getYaw(), a3.getPitch(), a3.getRoll());
                                    if (a2 >= 1.0f) {
                                        Constraint constraint = ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(intValue)).getConstraint();
                                        if (constraint != null) {
                                            this.f215ILl.setFovDistanceConstraint(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
                                            p pVar = (p) this.f231iILLL1.get(intValue);
                                            a.a.a.a.e.a.e.k.d dVar = pVar.f563b;
                                            if (dVar != null) {
                                                dVar.setConstraint(constraint);
                                                pVar.f564c.a(pVar.c());
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            if (!IL1Iii() || !ILil(intValue)) {
                                fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                f3 = this.f215ILl.getRotate()[0];
                                f2 = this.f215ILl.getRotate()[1];
                            } else {
                                p pVar2 = (p) this.f231iILLL1.get(intValue);
                                if (this.llI) {
                                    fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                    f3 = this.f215ILl.getRotate()[0];
                                    f2 = this.f215ILl.getRotate()[1];
                                } else if (this.f227L1l == null) {
                                    Transform a4 = pVar2.a(doubleValue, false);
                                    if (a4 != null) {
                                        this.f215ILl.setFov(a4.getFov());
                                        this.f215ILl.setDistance(a4.getDistance());
                                        fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                        fVar.a(a4.getYaw(), a4.getPitch(), a4.getRoll());
                                        this.f217IIi = pVar2.f564c.a(doubleValue, true, false);
                                    } else {
                                        int a5 = pVar2.f564c.a(doubleValue, true, false);
                                        int i2 = this.f217IIi;
                                        if (i2 != a5 && (i2 == -2 || a5 >= 0)) {
                                            this.f217IIi = a5;
                                            z = true;
                                        }
                                        if (z) {
                                            Transform a6 = pVar2.a(doubleValue, true);
                                            this.f215ILl.setFov(a6.getFov());
                                            this.f215ILl.setDistance(a6.getDistance());
                                            fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                            fVar.a(a6.getYaw(), a6.getPitch(), a6.getRoll());
                                        }
                                    }
                                } else if (pVar2.a(doubleValue, false) != null) {
                                    if (this.f236l1IIi1 < 0.0d) {
                                        this.f236l1IIi1 = doubleValue;
                                    }
                                    double min = Math.min(convertSrcPositionToMediaTime(new j(intValue, this.f236l1IIi1)) + 300.0d, this.f216I.getClipEndTimeMsExcludeEndCutscenes(intValue));
                                    double d2 = this.f236l1IIi1;
                                    double d3 = convertMediaTimeToSrcPosition(min).f481b;
                                    Transform a7 = pVar2.a(d3, true);
                                    if (doubleValue < d2 || doubleValue > d3) {
                                        this.f215ILl.setFov(a7.getFov());
                                        this.f215ILl.setDistance(a7.getDistance());
                                        fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                        fVar.a(a7.getYaw(), a7.getPitch(), a7.getRoll());
                                        Lil();
                                    } else if (this.f227L1l != null) {
                                        float convertSrcPositionToMediaTime = (float) (((convertSrcPositionToMediaTime(new j(intValue, doubleValue)) - convertSrcPositionToMediaTime(new j(intValue, this.f236l1IIi1))) * 1.0d) / 300.0d);
                                        Transform transform2 = this.f227L1l;
                                        transform2.setYaw(a.a.a.a.e.a.l.d.a(transform2.getYaw(), a7.getYaw()));
                                        Transform transform3 = this.f227L1l;
                                        transform3.setPitch(a.a.a.a.e.a.l.d.a(transform3.getPitch(), a7.getPitch()));
                                        float f4 = 1.0f - convertSrcPositionToMediaTime;
                                        this.f215ILl.setFov((this.f227L1l.getFov() * f4) + (a7.getFov() * convertSrcPositionToMediaTime));
                                        this.f215ILl.setDistance((this.f227L1l.getDistance() * f4) + (a7.getDistance() * convertSrcPositionToMediaTime));
                                        fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                                        fVar.a((this.f227L1l.getYaw() * f4) + (a7.getYaw() * convertSrcPositionToMediaTime), (this.f227L1l.getPitch() * f4) + (a7.getPitch() * convertSrcPositionToMediaTime), (this.f227L1l.getRoll() * f4) + (a7.getRoll() * convertSrcPositionToMediaTime));
                                    }
                                }
                            }
                            fVar.a(f3, f2, this.f245iILLl);
                        }
                    }
                }
            } else if (this.LlLI1.size() == 2) {
                int intValue2 = ((Integer) this.LlLI1.get(0)).intValue();
                int intValue3 = ((Integer) this.LlLI1.get(1)).intValue();
                c cVar = (c) this.f246il.get(intValue2);
                f fVar2 = (f) this.f241lLi1LL.get(intValue2);
                f fVar3 = (f) this.f241lLi1LL.get(intValue3);
                if (cVar.f496a.f582a.f593c) {
                    double clockTime = this.f216I.getPlaybackProgress().getClockTime();
                    double clipEndTimeMsExcludeEndCutscenes = this.f216I.getClipEndTimeMsExcludeEndCutscenes(intValue2);
                    if (fVar2.a() && fVar3.a()) {
                        Transform[] transformArr = new Transform[2];
                        if (clockTime >= clipEndTimeMsExcludeEndCutscenes && clockTime <= clipEndTimeMsExcludeEndCutscenes + 500.0d) {
                            float max = Math.max(0.0f, Math.min(1.0f, (float) ((clockTime - clipEndTimeMsExcludeEndCutscenes) / 500.0d)));
                            MediaLogger mediaLogger2 = c.f495g;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("getCameraTransform preClipPrepare, factor: ");
                            sb2.append(max);
                            mediaLogger2.d(sb2.toString());
                            transformArr[0] = cVar.a(cVar.f499d[0], cVar.a(cVar.f498c[0].getTransitionState(1), cVar.f500e), max);
                            transformArr[1] = cVar.a(cVar.f498c[1].getTransitionState(1), cVar.f500e);
                        } else if (clockTime < (((double) c.a(cVar.f496a)) + clipEndTimeMsExcludeEndCutscenes) - 500.0d || clockTime > ((double) c.a(cVar.f496a)) + clipEndTimeMsExcludeEndCutscenes) {
                            double d4 = clockTime - (clipEndTimeMsExcludeEndCutscenes + 500.0d);
                            MediaLogger mediaLogger3 = c.f495g;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("getCameraTransform, cutScenePosition: ");
                            sb3.append(d4);
                            mediaLogger3.d(sb3.toString());
                            if (d4 < 0.0d) {
                                MediaLogger mediaLogger4 = c.f495g;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("cutScenePosition(");
                                sb4.append(d4);
                                sb4.append(") < 0");
                                mediaLogger4.e(sb4.toString());
                            }
                            if (d4 > ((double) cVar.f496a.f583b)) {
                                MediaLogger mediaLogger5 = c.f495g;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("cutScenePosition(");
                                sb5.append(d4);
                                sb5.append(") > duration(");
                                sb5.append(cVar.f496a.f583b);
                                sb5.append(")");
                                mediaLogger5.e(sb5.toString());
                            }
                            if (cVar.f498c != null) {
                                int i3 = 0;
                                while (true) {
                                    TransitionProcessor[] transitionProcessorArr = cVar.f498c;
                                    if (i3 >= transitionProcessorArr.length) {
                                        break;
                                    }
                                    transformArr[i3] = cVar.a(transitionProcessorArr[i3].getTransitionState((long) d4), cVar.f500e);
                                    i3++;
                                }
                            }
                        } else {
                            float max2 = Math.max(0.0f, Math.min(1.0f, (float) ((clockTime - ((clipEndTimeMsExcludeEndCutscenes + ((double) c.a(cVar.f496a))) - 500.0d)) / 500.0d)));
                            MediaLogger mediaLogger6 = c.f495g;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("getCameraTransform nextClipPrepare, factor: ");
                            sb6.append(max2);
                            mediaLogger6.d(sb6.toString());
                            transformArr[1] = cVar.a(cVar.a(cVar.f498c[1].getTransitionState((long) (cVar.f496a.f583b - 1)), cVar.f500e), cVar.f499d[1], max2);
                            transformArr[0] = cVar.a(cVar.f498c[0].getTransitionState((long) (cVar.f496a.f583b - 1)), cVar.f500e);
                        }
                        if (fVar2.a()) {
                            fVar2.a(transformArr[0]);
                        }
                        if (fVar3.a()) {
                            transform = transformArr[1];
                        }
                    }
                } else {
                    if (fVar2.a()) {
                        fVar2.a(((p) this.f231iILLL1.get(intValue2)).a(((Double) this.f239lIlii.get(0)).doubleValue(), true));
                    }
                    if (fVar3.a()) {
                        transform = ((p) this.f231iILLL1.get(intValue3)).a(((Double) this.f239lIlii.get(0)).doubleValue(), true);
                    }
                }
                fVar3.a(transform);
            } else if (this.LlLI1.size() == 1) {
                int intValue4 = ((Integer) this.LlLI1.get(0)).intValue();
                double doubleValue2 = ((Double) this.f239lIlii.get(0)).doubleValue();
                f fVar4 = (f) this.f241lLi1LL.get(intValue4);
                p pVar3 = (p) this.f231iILLL1.get(intValue4);
                if (fVar4.a()) {
                    if (!((n) this.f228L11I.get(intValue4)).a(doubleValue2)) {
                        fVar4.a(pVar3.a(doubleValue2, true));
                    } else {
                        ((n) this.f228L11I.get(intValue4)).b(doubleValue2);
                        throw null;
                    }
                }
            }
        }
    }

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public final void m44lLi1LL() {
        GraphicView graphicView = new GraphicView(getContext(), this.ILil.isUseTextureView());
        this.f234ili11 = graphicView;
        graphicView.setBackgroundColor(getGraphicViewBackgroundColor());
        this.f234ili11.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f234ili11.setOnTouchListener(new e.b.c.b.b.a.d.n(this));
        int i2 = 0;
        addView(this.f234ili11, 0);
        if (this.f234ili11.getChildCount() > 0 && (this.f234ili11.getChildAt(0) instanceof TextureView)) {
            ((TextureView) this.f234ili11.getChildAt(0)).setOpaque(false);
        }
        for (i a2 : this.f219IiL) {
            a2.a((FrameLayout) this);
        }
        a.a.a.a.e.a.e.e eVar = this.f237lIiI;
        if (eVar != null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            eVar.f509a = frameLayout;
            frameLayout.setVisibility(4);
            addView(eVar.f509a);
            ImageView imageView = new ImageView(getContext());
            eVar.f510b = imageView;
            imageView.setImageResource(R.drawable.view_player_rect_selector);
            eVar.f509a.addView(eVar.f510b);
            ImageView imageView2 = new ImageView(getContext());
            this.iI = imageView2;
            addView(imageView2);
            this.iI.setImageResource(R.drawable.ic_smart_track_cover);
            this.iI.setScaleType(ScaleType.FIT_XY);
            this.iI.setVisibility(8);
            this.f225LlLiLL = new TextView[2];
            while (true) {
                TextView[] textViewArr = this.f225LlLiLL;
                if (i2 < textViewArr.length) {
                    textViewArr[i2] = new TextView(getContext());
                    this.f225LlLiLL[i2].setTextSize(8.0f);
                    this.f225LlLiLL[i2].setTextColor(Color.parseColor("#FFFFFF"));
                    this.f225LlLiLL[i2].setLayoutParams(new FrameLayout.LayoutParams(a.a.a.a.b.a.a(120.0f), a.a.a.a.b.a.a(200.0f), (i2 == 0 ? 3 : 5) | 16));
                    addView(this.f225LlLiLL[i2]);
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            throw null;
        }
    }

    public void onFakeTouchEvent(MotionEvent motionEvent) {
        GestureController gestureController = this.f215ILl;
        if (gestureController != null) {
            gestureController.onUpdate(motionEvent);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        MediaLogger mediaLogger = l1Lll;
        String str = " to ";
        StringBuilder a2 = e.a.a.a.a.a("onSizeChanged, width: ", i4, str, i2, ", height: ");
        a2.append(i5);
        a2.append(str);
        a2.append(i3);
        mediaLogger.d(a2.toString());
        m35IL();
        if (this.I11L) {
            I1I();
            ILil();
            measure(MeasureSpec.makeMeasureSpec(i2, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec(i3, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
        }
    }

    public void pause() {
        l1Lll.i("pause");
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender != null && bMGPreviewerSessionRender.isPlaying()) {
            this.f216I.pause();
            m45il();
        }
    }

    public void play() {
        h hVar = this.IL1Iii;
        if (hVar != null) {
            List<IVideoParams> list = ((a.a.a.a.e.a.c.g) hVar).f463a;
            if (!(list == null || list.size() == 0)) {
                if (this.ILil == null) {
                    l1Lll.e("play, but playVideoParams is null!");
                    return;
                } else if (this.I11L) {
                    l1Lll.e("play, but resources already created!");
                    return;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (IVideoParams iVideoParams : ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a) {
                        if (iVideoParams.getWidthOrigin() > i3) {
                            i3 = iVideoParams.getWidthOrigin();
                        }
                    }
                    for (IVideoParams iVideoParams2 : ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a) {
                        if (iVideoParams2.getHeightOrigin() > i2) {
                            i2 = iVideoParams2.getHeightOrigin();
                        }
                    }
                    if (!a.a.a.a.b.a.a(i3, i2)) {
                        l1Lll.e("play, but GPU texture not support!");
                        IBasePlayerViewListener iBasePlayerViewListener = this.I1;
                        if (iBasePlayerViewListener != null) {
                            iBasePlayerViewListener.onFail(-10003, VideoPlayerView.class.getSimpleName(), "GPU texture not support");
                        }
                        return;
                    } else if (!isLoading()) {
                        setLoading(true);
                        m35IL();
                        this.iIlLiL = EventIdUtils.getEventId();
                        h hVar2 = this.IL1Iii;
                        IPlayVideoParams iPlayVideoParams = this.ILil;
                        int i4 = this.iIlLiL;
                        Ilil();
                        Thread thread = new Thread(new I1I(hVar2, i4, iPlayVideoParams));
                        thread.setPriority(10);
                        thread.start();
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        l1Lll.e("play, but projectParams is null or videoParamsList is empty!");
    }

    public void removeVideoPlayerViewListener(IVideoPlayerViewListener iVideoPlayerViewListener) {
        if (iVideoPlayerViewListener == null) {
            l1Lll.w("removeVideoPlayerViewListener, but videoPlayerViewListener is null, ignored!");
            return;
        }
        List<IVideoPlayerViewListener> list = this.f244i11i;
        if (list != null) {
            list.remove(iVideoPlayerViewListener);
        }
    }

    public void resetViewAngle() {
        resetViewAngle(0);
    }

    public void resetViewAngle(int i2) {
        if (!IL1Iii(i2) || this.f231iILLL1.get(i2) == null) {
            l1Lll.w("resetViewAngle, but free capture is not supported");
        } else {
            int size = this.LlLI1.size();
            int size2 = this.f239lIlii.size();
            if (size != size2) {
                MediaLogger mediaLogger = l1Lll;
                StringBuilder sb = new StringBuilder();
                sb.append("resetViewAngle, but clip list size is ");
                sb.append(size);
                sb.append(", frameSrcTimestamp list size is ");
                sb.append(size2);
                sb.append("(not equals)");
                mediaLogger.w(sb.toString());
                return;
            } else if (this.LlLI1.indexOf(Integer.valueOf(i2)) != -1) {
                Transform viewAngle = getViewAngle(i2);
                if (viewAngle != null) {
                    GestureController gestureController = this.f215ILl;
                    if (gestureController != null) {
                        gestureController.setFov(viewAngle.getFov());
                        this.f215ILl.setDistance(viewAngle.getDistance());
                    }
                    f fVar = (f) this.f241lLi1LL.get(i2);
                    if (fVar != null) {
                        fVar.a(this.f215ILl.getFov(), this.f215ILl.getDistance());
                        fVar.a(viewAngle.getYaw(), viewAngle.getPitch(), viewAngle.getRoll());
                    }
                }
            }
        }
        Lil();
    }

    public void resume() {
        l1Lll.i("resume");
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender == null) {
            return;
        }
        if (this.llliI) {
            seekTo(0.0d);
            this.f250LLlI1 = this.f229LlLLL;
            return;
        }
        bMGPreviewerSessionRender.start();
        m45il();
    }

    public double[] screenPointToSpherePoint(double[] dArr) {
        double[] dArr2;
        if (this.LlLI1.size() != 1) {
            l1Lll.e("screenPointToSpherePoint, but mClipIndexList.size() is not 1");
            return new double[]{0.0d, 0.0d, 0.0d};
        }
        f fVar = (f) this.f241lLi1LL.get(((Integer) this.LlLI1.get(0)).intValue());
        if (fVar.f513b != null) {
            Vector3f vector3f = new Vector3f();
            fVar.f513b.screenToSpherePoint(new Vector2f((float) dArr[0], (float) dArr[1]), vector3f);
            dArr2 = new double[]{(double) vector3f.x, (double) vector3f.y, (double) vector3f.z};
        } else {
            f.f511h.e("screenPointToSpherePoint, but camera is not supported");
            dArr2 = new double[]{0.0d, 0.0d, 0.0d};
        }
        return dArr2;
    }

    public void seekTo(double d2) {
        int i2;
        StringBuilder sb;
        MediaLogger mediaLogger;
        if (this.f216I != null) {
            double[] currentPlayRangeMedia = getCurrentPlayRangeMedia();
            String str = "seek position(";
            if (d2 < currentPlayRangeMedia[0]) {
                MediaLogger mediaLogger2 = l1Lll;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(d2);
                sb2.append(") < minSeekPosition(");
                sb2.append(currentPlayRangeMedia[0]);
                sb2.append("), format it to minSeekPosition");
                mediaLogger2.e(sb2.toString());
                d2 = currentPlayRangeMedia[0];
            }
            if (d2 > currentPlayRangeMedia[1]) {
                MediaLogger mediaLogger3 = l1Lll;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(d2);
                sb3.append(") > maxSeekPosition(");
                sb3.append(currentPlayRangeMedia[1]);
                sb3.append("), format it to maxSeekPosition");
                mediaLogger3.e(sb3.toString());
                d2 = currentPlayRangeMedia[1];
            }
            IL1Iii(Boolean.valueOf(false));
            String str2 = ", seekId is ";
            String str3 = "seekTo ";
            if (!iIlLiL() || !this.f214ILLIi) {
                this.f229LlLLL = this.f216I.seek(d2);
                mediaLogger = l1Lll;
                sb = new StringBuilder();
                sb.append(str3);
                sb.append(d2);
                sb.append(str2);
                i2 = this.f229LlLLL;
            } else {
                if (this.f238lIII < 0) {
                    this.f221L111 = isPlaying();
                    pause();
                }
                this.f238lIII = this.f216I.seekSubStream(d2);
                this.LL1IL = d2;
                mediaLogger = l1Lll;
                sb = new StringBuilder();
                sb.append("subStreamSeekTo ");
                sb.append(d2);
                sb.append(", subStreamSeekId is ");
                i2 = this.f238lIII;
            }
            sb.append(i2);
            mediaLogger.d(sb.toString());
            MediaLogger mediaLogger4 = l1Lll;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(d2);
            sb4.append(str2);
            sb4.append(this.f229LlLLL);
            mediaLogger4.d(sb4.toString());
        }
    }

    public void setBasePlayerViewListener(IBasePlayerViewListener iBasePlayerViewListener) {
        this.I1 = iBasePlayerViewListener;
        if (iBasePlayerViewListener != null) {
            iBasePlayerViewListener.setCallback(new iILLL1(this));
        }
    }

    public void setBeautyFilterLevel(int i2) {
        setBeautyFilterLevel(0, i2);
    }

    public void setBeautyFilterLevel(int i2, int i3) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setBeautyFilterLevel(i3);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                this.f216I.onFilterChanged(IL1Iii(i2, false));
            } else {
                l1Lll.d("setBeautyFilterLevel, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setBlendAngleRad(float f2) {
        setBlendAngleRad(0, f2);
    }

    public void setBlendAngleRad(int i2, float f2) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setBlendAngleRad(f2);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                LlLI1();
            } else {
                l1Lll.d("setBlendAngleRad, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setColorAdjustEnabled(int i2, boolean z) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setColorAdjustEnabled(z);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                LlLI1();
            } else {
                l1Lll.d("setColorAdjustEnabled, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setColorAdjustEnabled(boolean z) {
        setColorAdjustEnabled(0, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fe, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setConstraint(int r7, com.arashivision.insta360.basemedia.model.viewconstraint.Constraint r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.IL1Iii(r7)     // Catch:{ all -> 0x00ff }
            if (r0 != 0) goto L_0x0010
            com.arashivision.insta360.basemedia.log.MediaLogger r7 = l1Lll     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = "setConstraint, but camera is not supported"
            r7.w(r8)     // Catch:{ all -> 0x00ff }
            monitor-exit(r6)
            return
        L_0x0010:
            a.a.a.a.e.a.c.h r0 = r6.IL1Iii     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.c.g r0 = (a.a.a.a.e.a.c.g) r0     // Catch:{ all -> 0x00ff }
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r0 = r0.f463a     // Catch:{ all -> 0x00ff }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x00ff }
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r0 = (com.arashivision.insta360.basemedia.ui.player.video.IVideoParams) r0     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x0031
            r0.setConstraint(r8)     // Catch:{ all -> 0x00ff }
            r0.updateStabilizerByFovAndDistanceIfNeeded()     // Catch:{ all -> 0x00ff }
            r6.LlLI1()     // Catch:{ all -> 0x00ff }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r6.iIilII1     // Catch:{ all -> 0x00ff }
            e.b.c.b.b.a.d.l r1 = new e.b.c.b.b.a.d.l     // Catch:{ all -> 0x00ff }
            r1.<init>(r6, r7)     // Catch:{ all -> 0x00ff }
            r0.offer(r1)     // Catch:{ all -> 0x00ff }
        L_0x0031:
            java.util.List<java.lang.Integer> r0 = r6.LlLI1     // Catch:{ all -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00ff }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x00ff }
            r1 = -2
            if (r0 == 0) goto L_0x00db
            boolean r0 = r6.m37IiL()     // Catch:{ all -> 0x00ff }
            if (r0 != 0) goto L_0x00db
            com.arashivision.insta360.basemedia.ui.player.video.IPlayVideoParams r0 = r6.ILil     // Catch:{ all -> 0x00ff }
            boolean r0 = r0.isWithSwitchingAnimation()     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x0093
            java.util.List<a.a.a.a.e.a.e.f> r0 = r6.f241lLi1LL     // Catch:{ all -> 0x00ff }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.f r7 = (a.a.a.a.e.a.e.f) r7     // Catch:{ all -> 0x00ff }
            com.arashivision.arvbmg.render.camera.GestureController r0 = r6.f215ILl     // Catch:{ all -> 0x00ff }
            r7.a(r0)     // Catch:{ all -> 0x00ff }
            com.arashivision.graphicpath.render.engine.Transform r0 = r6.getCameraTransform()     // Catch:{ all -> 0x00ff }
            monitor-enter(r6)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.d r1 = r6.f226Ll1     // Catch:{ all -> 0x0090 }
            com.arashivision.graphicpath.render.engine.Transform r2 = new com.arashivision.graphicpath.render.engine.Transform     // Catch:{ all -> 0x0090 }
            com.arashivision.graphicpath.render.engine.Transform r7 = r7.b()     // Catch:{ all -> 0x0090 }
            float r7 = r7.getYaw()     // Catch:{ all -> 0x0090 }
            float r3 = r8.getDefaultPitch()     // Catch:{ all -> 0x0090 }
            float r4 = r8.getDefaultDistance()     // Catch:{ all -> 0x0090 }
            float r5 = r8.getDefaultFov()     // Catch:{ all -> 0x0090 }
            r2.<init>(r7, r3, r4, r5)     // Catch:{ all -> 0x0090 }
            android.view.animation.DecelerateInterpolator r7 = new android.view.animation.DecelerateInterpolator     // Catch:{ all -> 0x0090 }
            r7.<init>()     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008e
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0090 }
            r1.f505a = r3     // Catch:{ all -> 0x0090 }
            r1.f506b = r0     // Catch:{ all -> 0x0090 }
            r1.f507c = r2     // Catch:{ all -> 0x0090 }
            r1.f508d = r7     // Catch:{ all -> 0x0090 }
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            goto L_0x00c5
        L_0x008e:
            r7 = 0
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x00ff }
        L_0x0093:
            com.arashivision.arvbmg.render.camera.GestureController r0 = r6.f215ILl     // Catch:{ all -> 0x00ff }
            float r2 = r8.getMinFov()     // Catch:{ all -> 0x00ff }
            float r3 = r8.getMaxFov()     // Catch:{ all -> 0x00ff }
            float r4 = r8.getMinDistance()     // Catch:{ all -> 0x00ff }
            float r5 = r8.getMaxDistance()     // Catch:{ all -> 0x00ff }
            r0.setFovDistanceCalculateMinMax(r2, r3, r4, r5)     // Catch:{ all -> 0x00ff }
            java.util.List<a.a.a.a.e.a.e.p> r0 = r6.f231iILLL1     // Catch:{ all -> 0x00ff }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.p r7 = (a.a.a.a.e.a.e.p) r7     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.k.d r0 = r7.f563b     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x00c0
            r0.setConstraint(r8)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.i.f.d r0 = r7.f564c     // Catch:{ all -> 0x00ff }
            java.util.List r7 = r7.c()     // Catch:{ all -> 0x00ff }
            r0.a(r7)     // Catch:{ all -> 0x00ff }
        L_0x00c0:
            r6.resetViewAngle()     // Catch:{ all -> 0x00ff }
            r6.f217IIi = r1     // Catch:{ all -> 0x00ff }
        L_0x00c5:
            com.arashivision.arvbmg.render.camera.GestureController r7 = r6.f215ILl     // Catch:{ all -> 0x00ff }
            float r0 = r8.getMinFov()     // Catch:{ all -> 0x00ff }
            float r1 = r8.getMaxFov()     // Catch:{ all -> 0x00ff }
            float r2 = r8.getMinDistance()     // Catch:{ all -> 0x00ff }
            float r8 = r8.getMaxDistance()     // Catch:{ all -> 0x00ff }
            r7.setFovDistanceCalculateMinMax(r0, r1, r2, r8)     // Catch:{ all -> 0x00ff }
            goto L_0x00fd
        L_0x00db:
            boolean r0 = r6.f249     // Catch:{ all -> 0x00ff }
            r6.ILil(r7, r0)     // Catch:{ all -> 0x00ff }
            java.util.List<a.a.a.a.e.a.e.p> r0 = r6.f231iILLL1     // Catch:{ all -> 0x00ff }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.p r0 = (a.a.a.a.e.a.e.p) r0     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.e.k.d r2 = r0.f563b     // Catch:{ all -> 0x00ff }
            if (r2 == 0) goto L_0x00f8
            r2.setConstraint(r8)     // Catch:{ all -> 0x00ff }
            a.a.a.a.e.a.i.f.d r8 = r0.f564c     // Catch:{ all -> 0x00ff }
            java.util.List r0 = r0.c()     // Catch:{ all -> 0x00ff }
            r8.a(r0)     // Catch:{ all -> 0x00ff }
        L_0x00f8:
            r6.resetViewAngle(r7)     // Catch:{ all -> 0x00ff }
            r6.f217IIi = r1     // Catch:{ all -> 0x00ff }
        L_0x00fd:
            monitor-exit(r6)
            return
        L_0x00ff:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.setConstraint(int, com.arashivision.insta360.basemedia.model.viewconstraint.Constraint):void");
    }

    public synchronized void setConstraint(Constraint constraint) {
        setConstraint(0, constraint);
    }

    public void setConstraintRatio(int i2, int[] iArr) {
        if (!IL1Iii(i2)) {
            l1Lll.w("setConstraintRatio, but camera is not supported");
            return;
        }
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
        if (iVideoParams != null) {
            iVideoParams.setConstraintRatio(iArr);
            ((f) this.f241lLi1LL.get(i2)).e();
        }
        this.f217IIi = -2;
    }

    public void setConstraintRatio(int[] iArr) {
        setConstraintRatio(0, iArr);
    }

    public void setCustomizedPlayRange(double[] dArr) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setCustomizedPlayRange(dArr);
            iIi1();
        }
    }

    public void setFitMode(int i2) {
        setFitMode(0, i2);
    }

    public void setFitMode(int i2, int i3) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setFitMode(i3);
                ILil();
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                LlLI1();
                this.iIilII1.offer(new e.b.c.b.b.a.d.e(this, i2));
                this.f217IIi = -2;
            } else {
                l1Lll.d("setFitMode, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setFlashDataList(int i2, List<a.a.a.a.e.a.i.a> list) {
        if (!isPrepared()) {
            l1Lll.w("setFlashDataList, but is not prepared!");
        } else {
            ((a.a.a.a.e.a.e.h) this.ILL.get(i2)).f521a.setFlashDataList(list);
        }
    }

    public void setFlashDataList(List<a.a.a.a.e.a.i.a> list) {
        setFlashDataList(0, list);
    }

    public void setForceVideoKeyFrameOnly(boolean z) {
        if (this.f216I != null) {
            this.ILil.setForceVideoKeyFrameOnly(z);
            this.f216I.setForceVideoKeyFrameOnly(z);
        }
    }

    public void setGestureDistance(double d2) {
        this.f215ILl.setDistance((float) d2);
    }

    public void setGestureDistanceChangeEnabled(boolean z) {
        if (!this.f212I1L11L) {
            l1Lll.w("setGestureDistanceChangeEnabled, but is not prepared!");
        } else if (!IL1Iii()) {
            l1Lll.e("setGestureDistanceChangeEnabled, but camera is not supported, ignored!");
        } else {
            IPlayVideoParams iPlayVideoParams = this.ILil;
            if (iPlayVideoParams != null) {
                iPlayVideoParams.setGestureDistanceChangeEnabled(z);
            }
            GestureController gestureController = this.f215ILl;
            if (gestureController != null) {
                gestureController.setDistanceChangeEnabled(z);
            }
        }
    }

    public void setGestureEnabled(boolean z) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setGestureEnabled(z);
        }
        GestureController gestureController = this.f215ILl;
        if (gestureController != null) {
            gestureController.setEnabled(z);
        }
    }

    public void setGestureFov(double d2) {
        this.f215ILl.setFov((float) d2);
    }

    public void setGestureFovChangeEnabled(boolean z) {
        if (!this.f212I1L11L) {
            l1Lll.w("setGestureFovChangeEnabled, but is not prepared!");
        } else if (!IL1Iii()) {
            l1Lll.e("setGestureFovChangeEnabled, but camera is not supported, ignored!");
        } else {
            IPlayVideoParams iPlayVideoParams = this.ILil;
            if (iPlayVideoParams != null) {
                iPlayVideoParams.setGestureFovChangeEnabled(z);
            }
            GestureController gestureController = this.f215ILl;
            if (gestureController != null) {
                gestureController.setFovChangeEnabled(z);
            }
        }
    }

    public void setGestureHorizontalEnabled(boolean z) {
        if (!this.f212I1L11L) {
            l1Lll.w("setGestureHorizontalEnabled, but is not prepared!");
        } else if (!IL1Iii()) {
            l1Lll.e("setGestureHorizontalEnabled, but camera is not supported, ignored!");
        } else {
            IPlayVideoParams iPlayVideoParams = this.ILil;
            if (iPlayVideoParams != null) {
                iPlayVideoParams.setGestureHorizontalEnabled(z);
            }
            GestureController gestureController = this.f215ILl;
            if (gestureController != null) {
                gestureController.setHorizontalEnabled(z);
            }
        }
    }

    public void setGestureListener(IGestureListener iGestureListener) {
        this.L1iI1 = iGestureListener;
    }

    public void setGestureVerticalEnabled(boolean z) {
        if (!this.f212I1L11L) {
            l1Lll.w("setGestureVerticalEnabled, but is not prepared!");
        } else if (!IL1Iii()) {
            l1Lll.e("setGestureVerticalEnabled, but camera is not supported, ignored!");
        } else {
            IPlayVideoParams iPlayVideoParams = this.ILil;
            if (iPlayVideoParams != null) {
                iPlayVideoParams.setGestureVerticalEnabled(z);
            }
            GestureController gestureController = this.f215ILl;
            if (gestureController != null) {
                gestureController.setVerticalEnabled(z);
            }
        }
    }

    public void setGestureZoomEnabled(boolean z) {
        if (!this.f212I1L11L) {
            l1Lll.w("setGestureZoomEnabled, but is not prepared!");
        } else if (!IL1Iii()) {
            l1Lll.e("setGestureZoomEnabled, but camera is not supported, ignored!");
        } else {
            IPlayVideoParams iPlayVideoParams = this.ILil;
            if (iPlayVideoParams != null) {
                iPlayVideoParams.setGestureZoomEnabled(z);
            }
            GestureController gestureController = this.f215ILl;
            if (gestureController != null) {
                gestureController.setZoomEnabled(z);
            }
        }
    }

    public void setHeadTrackerEnabled(boolean z) {
        this.Lil.setEnabled(z);
    }

    public void setLifecycle(e eVar) {
        this.i1 = eVar;
        eVar.a(this);
    }

    public void setLoadingBackgroundColor(int i2) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setLoadingBackgroundColor(i2);
        }
    }

    public void setLoadingImageResId(int i2) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setLoadingImageResId(i2);
        }
    }

    public void setLogoEnabled(int i2, boolean z) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setLogoEnabled(z);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                this.f216I.updateLogo(((l) this.Ilil.get(i2)).b(z));
            } else {
                l1Lll.d("setLogoEnabled, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setLooping(boolean z) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setLooping(z);
            BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
            if (bMGPreviewerSessionRender != null) {
                bMGPreviewerSessionRender.setEndBehaviour(this.ILil.isLooping() ? EndBehaviour.LOOP : EndBehaviour.PAUSE_ON_LAST_FRAME);
            }
        }
    }

    public void setLutFilter(int i2, a.a.a.a.a.d.a aVar) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setLutFilter(aVar);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                this.f216I.onFilterChanged(IL1Iii(i2, false));
            } else {
                l1Lll.d("setLutFilter, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setLutFilter(a.a.a.a.a.d.a aVar) {
        setLutFilter(0, aVar);
    }

    public void setMotionBlur(int i2, boolean z) {
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
        if (iVideoParams != null) {
            iVideoParams.setMotionBlur(z);
        }
    }

    public void setMultiViewClipList(int i2, List<a.a.a.a.e.a.i.d> list) {
        n nVar = (n) this.f228L11I.get(i2);
        if (nVar != null) {
            if (nVar.f536a != null && nVar.c()) {
                nVar.f536a.setMultiViewClipList(list);
                nVar.a();
            }
            if (this.LlLI1.size() == 1 && ((Integer) this.LlLI1.get(0)).intValue() == i2) {
                LlLI1();
            }
        }
    }

    public void setMultiViewClipList(List<a.a.a.a.e.a.i.d> list) {
        setMultiViewClipList(0, list);
    }

    public void setOffset(int i2, String str) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setOffsetForPlay(str);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                LlLI1();
            } else {
                l1Lll.d("setOffset, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setOffset(String str) {
        setOffset(0, str);
    }

    public void setParams(h hVar, IPlayVideoParams iPlayVideoParams) {
        destroyResources(true);
        this.IL1Iii = hVar;
        this.ILil = iPlayVideoParams;
        Previewer2 previewer2 = new Previewer2(null);
        this.f232iILilI = previewer2;
        previewer2.setSource(PreviewerUtil.getPreviewerSource(IL1Iii(this.IL1Iii, true)));
    }

    public void setPivotMode(boolean z) {
        GestureController gestureController = this.f215ILl;
        if (gestureController != null) {
            gestureController.setPivotMode(z);
        }
    }

    public void setPlayRangeEnabled(boolean z) {
        IPlayVideoParams iPlayVideoParams = this.ILil;
        if (iPlayVideoParams != null) {
            iPlayVideoParams.setPlayRangeEnable(z);
            iIi1();
        }
    }

    public void setPlayRate(double d2) {
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender != null) {
            bMGPreviewerSessionRender.setPlayRate(d2);
        }
    }

    public void setRecordList(int i2, List<a.a.a.a.e.a.i.h> list) {
        if (isPrepared()) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setRecordList(list);
            }
            if (IL1Iii(i2)) {
                p pVar = (p) this.f231iILLL1.get(i2);
                a.a.a.a.e.a.e.k.d dVar = pVar.f563b;
                if (dVar != null) {
                    dVar.setRecordList(list);
                    pVar.f564c.a(pVar.c());
                }
                resetViewAngle(i2);
            }
            ILL();
        }
    }

    public void setRecordList(List<a.a.a.a.e.a.i.h> list) {
        setRecordList(0, list);
    }

    public void setScreenRatio(int[] iArr) {
        ((a.a.a.a.e.a.c.g) this.IL1Iii).f468f = iArr;
        for (int i2 = 0; i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size(); i2++) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setScreenRatio(iArr);
                List<f> list = this.f241lLi1LL;
                if (!(list == null || i2 >= list.size() || this.f241lLi1LL.get(i2) == null)) {
                    ((f) this.f241lLi1LL.get(i2)).e();
                }
                iVideoParams.updateStabilizerByFovAndDistanceIfNeeded();
            }
            p pVar = (p) this.f231iILLL1.get(i2);
            if (pVar != null) {
                a.a.a.a.e.a.e.k.d dVar = pVar.f563b;
                if (dVar != null) {
                    dVar.setScreenRatio(iArr);
                    pVar.f564c.a(pVar.c());
                }
            }
            n nVar = (n) this.f228L11I.get(i2);
            if (nVar != null) {
                nVar.f536a.setScreenRatio(iArr);
                if (!nVar.c()) {
                    nVar.f539d.e();
                    if (this.LlLI1.size() == 1 && this.LlLI1.contains(Integer.valueOf(i2))) {
                        LlLI1();
                    }
                } else {
                    nVar.f536a.getMultiViewConfig().a(nVar.f536a.getScreenRatio());
                    throw null;
                }
            }
        }
        m35IL();
        I1I();
        ILil();
        this.f217IIi = -2;
    }

    public void setStabType(int i2) {
        setStabType(0, i2);
    }

    public void setStabType(int i2, int i3) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams.getStabilizer() != null) {
                iVideoParams.setStabType(i3);
                iVideoParams.updateStabilizer(i3);
            }
        }
    }

    public void setStyleFilter(int i2, a.a.a.a.a.g.a aVar) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setStyleFilter(aVar);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                this.f216I.onFilterChanged(IL1Iii(i2, false));
            } else {
                l1Lll.d("setStyleFilter, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setStyleFilter(a.a.a.a.a.g.a aVar) {
        setStyleFilter(0, aVar);
    }

    public void setStyleFilterIntensity(float f2) {
        setStyleFilterIntensity(0, f2);
    }

    public void setStyleFilterIntensity(int i2, float f2) {
        if (this.f216I != null) {
            IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2);
            if (iVideoParams != null) {
                iVideoParams.setStyleFilterIntensity(f2);
            }
            if (this.LlLI1.contains(Integer.valueOf(i2))) {
                this.f216I.updateLutStyleFilterIntensity(f2);
            } else {
                l1Lll.d("setStyleFilterIntensity, but not current playing clip, so do not update Render");
            }
        }
    }

    public void setTrackImageListener(a.a.a.a.e.a.g.e eVar) {
        this.lL = eVar;
    }

    public void setVolume(float f2) {
        BMGPreviewerSessionRender bMGPreviewerSessionRender = this.f216I;
        if (bMGPreviewerSessionRender != null) {
            bMGPreviewerSessionRender.setVolume((double) f2);
        }
    }

    public double[] spherePointToScreenPoint(double[] dArr) {
        double[] dArr2;
        if (this.LlLI1.size() != 1) {
            l1Lll.e("spherePointToScreenPoint, but mClipIndexList.size() is not 1");
            return new double[]{0.0d, 0.0d};
        }
        f fVar = (f) this.f241lLi1LL.get(((Integer) this.LlLI1.get(0)).intValue());
        if (fVar.f513b != null) {
            Vector2f vector2f = new Vector2f();
            fVar.f513b.sphereToScreenPoint(new Vector3f((float) dArr[0], (float) dArr[1], (float) dArr[2]), vector2f);
            dArr2 = new double[]{(double) vector2f.x, (double) vector2f.y};
        } else {
            f.f511h.e("spherePointToScreenPoint, but camera is not supported");
            dArr2 = new double[]{0.0d, 0.0d};
        }
        return dArr2;
    }

    public void startDollyZoom(float f2, float[] fArr, IDollyzoomRectCallback iDollyzoomRectCallback) {
        this.f216I.startDollyZoom(f2, fArr, iDollyzoomRectCallback);
        resume();
    }

    public void startOffscreenTrack(float[] fArr, String str, String str2, String str3, String str4, float f2, boolean z, String str5, int i2, float f3, int i3) {
        if (this.LlLI1.size() != 1) {
            l1Lll.e("startOffscreenTrack, but clipIndexList.size() is not 1");
            return;
        }
        if (this.f243li11 == null) {
            this.f243li11 = new a.a.a.a.e.a.c.i();
        }
        int[] iArr = new int[2];
        if (getScreenRatio()[0] < getScreenRatio()[1]) {
            iArr[0] = (((getScreenRatio()[0] * 400) / getScreenRatio()[1]) / 8) * 8;
            iArr[1] = 400;
        } else {
            iArr[0] = 400;
            iArr[1] = (((getScreenRatio()[1] * 400) / getScreenRatio()[0]) / 8) * 8;
        }
        this.f243li11.f478e = this.lL;
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(((Integer) this.LlLI1.get(0)).intValue());
        this.f243li11.a(iVideoParams.getUrlsForPlay(), getCameraTransform(), (long) getCurrentFrameTime(), fArr, iArr, i3, str, str2, str4, f2, i2, f3, iVideoParams.getFps(), (long) iVideoParams.getDurationInMs());
    }

    public void startSmartTrack(Transform transform, float[] fArr, String str, String str2, String str3, String str4, float f2, boolean z, String str5, int i2, float f3, boolean z2) {
        MediaLogger mediaLogger;
        String str6;
        Transform transform2 = transform;
        if (!this.I11L) {
            mediaLogger = l1Lll;
            str6 = "startSmartTrack(), but player is destroyed!";
        } else {
            List<Integer> list = this.LlLI1;
            boolean z3 = true;
            if (list == null || list.size() <= 1) {
                pause();
                List<Integer> list2 = this.LlLI1;
                this.f213IIiI = (list2 == null || list2.isEmpty()) ? convertMediaTimeToSrcPosition(this.ILil.getRestorePlayPosition()).f480a : ((Integer) this.LlLI1.get(0)).intValue();
                this.f220L11 = true;
                if (transform2 != null) {
                    ((f) this.f241lLi1LL.get(this.f213IIiI)).a(transform2);
                }
                List<Integer> list3 = this.LlLI1;
                if (list3 != null && !list3.isEmpty() && transform2 == null && !I1I(0)) {
                    z3 = false;
                }
                if (I1I(this.f213IIiI)) {
                    LlLI1();
                }
                if (z3) {
                    this.f242lliiI1 = 2;
                    e.b.c.b.b.a.d.i iVar = new e.b.c.b.b.a.d.i(this, fArr, str, str2, str3, str4, f2, z, str5, i2, f3, z2);
                    this.f224LlIl = iVar;
                } else {
                    ILil(fArr, str, str2, str3, str4, f2, z, str5, i2, f3, z2);
                }
                return;
            }
            mediaLogger = l1Lll;
            str6 = "startSmartTrack(), but mClipIndexList.size() > 1!";
        }
        mediaLogger.e(str6);
    }

    public void startStapleTrack(String str, String str2, String str3, String str4) {
        MediaLogger mediaLogger;
        String str5;
        if (!this.I11L) {
            mediaLogger = l1Lll;
            str5 = "startStapleTrack(), but player is destroyed!";
        } else {
            List<Integer> list = this.LlLI1;
            boolean z = true;
            if (list == null || list.size() <= 1) {
                pause();
                List<Integer> list2 = this.LlLI1;
                this.f213IIiI = (list2 == null || list2.isEmpty()) ? convertMediaTimeToSrcPosition(this.ILil.getRestorePlayPosition()).f480a : ((Integer) this.LlLI1.get(0)).intValue();
                this.f220L11 = true;
                List<Integer> list3 = this.LlLI1;
                if (list3 != null && !list3.isEmpty() && !I1I(0)) {
                    z = false;
                }
                if (I1I(0)) {
                    LlLI1();
                }
                if (z) {
                    this.f242lliiI1 = 2;
                    e.b.c.b.b.a.d.c cVar = new e.b.c.b.b.a.d.c(this, str, str2, str3, str4);
                    this.f224LlIl = cVar;
                } else {
                    IL1Iii(str, str2, str4);
                }
                return;
            }
            mediaLogger = l1Lll;
            str5 = "startStapleTrack(), but mClipIndexList.size() > 1!";
        }
        mediaLogger.e(str5);
    }

    public void stopDollyZoom() {
        pause();
        this.f216I.stopDollyZoom();
    }

    public void stopOffscreenTrack() {
        a.a.a.a.e.a.c.i iVar = this.f243li11;
        if (iVar != null) {
            iVar.a();
        }
    }

    public void stopSmartTrack() {
        pause();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ImageView imageView = this.iI;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            post(new e.b.c.b.b.a.d.j(this));
        }
        m41lIiI();
        LlLI1();
    }

    public void stopStapleTrack() {
        if (this.f216I != null) {
            m34ILl();
            this.f216I.stopStapleTrack();
            pause();
            post(new k(this));
        }
    }

    /* renamed from: 丨il reason: contains not printable characters */
    public final void m45il() {
        for (IVideoPlayerViewListener onPlayStateChanged : this.f244i11i) {
            onPlayStateChanged.onPlayStateChanged();
        }
        post(new e.b.c.b.b.a.d.m(this));
    }

    public final boolean IL1Iii() {
        if (this.IL1Iii == null || m37IiL()) {
            return false;
        }
        for (int i2 = 0; i2 < ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.size(); i2++) {
            if (!IL1Iii(i2)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void ILil() {
        List<Integer> list = this.LlLI1;
        if (list != null) {
            for (Integer intValue : list) {
                i iVar = (i) this.f219IiL.get(intValue.intValue());
                if (iVar != null) {
                    iVar.a(getGraphicViewLayoutParams());
                }
            }
        }
        a.a.a.a.e.a.e.e eVar = this.f237lIiI;
        if (eVar != null) {
            FrameLayout.LayoutParams graphicViewLayoutParams = getGraphicViewLayoutParams();
            FrameLayout frameLayout = eVar.f509a;
            if (frameLayout != null) {
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(graphicViewLayoutParams));
            }
        }
    }

    public final void ILil(int i2, boolean z) {
        boolean z2;
        this.f249 = z;
        f fVar = (f) this.f241lLi1LL.get(i2);
        if (z) {
            Constraint constraint = ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i2)).getConstraint();
            if (IL1Iii()) {
                GestureController gestureController = this.f215ILl;
                if (gestureController != null) {
                    gestureController.setFovDistanceConstraint(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
                }
            }
            z2 = true;
        } else {
            if (IL1Iii()) {
                GestureController gestureController2 = this.f215ILl;
                if (gestureController2 != null) {
                    gestureController2.setFovDistanceConstraint(0.0f, 3.1415927f, 0.0f, 2000.0f);
                }
            }
            z2 = false;
        }
        fVar.f514c = z2;
    }

    public void setParams(IVideoParams iVideoParams, IPlayVideoParams iPlayVideoParams) {
        a.a.a.a.e.a.c.g gVar = new a.a.a.a.e.a.c.g();
        gVar.k = iVideoParams.getCacheCutSceneVideoPath();
        gVar.f463a = Collections.singletonList(iVideoParams);
        boolean z = false;
        gVar.f464b = Collections.singletonList(new a.a.a.a.e.a.i.c(a.a.a.a.e.a.i.c.a.NONE, 0));
        int[] screenRatio = iVideoParams.getScreenRatio();
        if (iVideoParams.isRotateScreenRatioEnabled() && a.a.a.a.e.a.l.d.a(iVideoParams.isRotateScreenRatioEnabled(), iVideoParams.getRotateDegree())) {
            z = true;
        }
        gVar.f468f = a.a.a.a.e.a.l.d.a(screenRatio, z);
        gVar.f469g = iVideoParams.getBgmUrl();
        gVar.f472j = iVideoParams.getBgmWeight();
        iVideoParams.getBgmRange();
        gVar.f471i = iVideoParams.getBgmOffset();
        gVar.f470h = iVideoParams.getBgmDuration();
        gVar.f467e = iVideoParams.getWatermarkResourcesPath();
        gVar.f466d = iVideoParams.getWatermarkRectCalculator();
        gVar.f465c = iVideoParams.isWatermarkEnabled();
        setParams((h) gVar, iPlayVideoParams);
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [com.arashivision.arvbmg.previewer.BMGSourceClip[]] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r14v2, types: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip] */
    /* JADX WARNING: type inference failed for: r14v6, types: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip] */
    /* JADX WARNING: type inference failed for: r14v12, types: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip] */
    /* JADX WARNING: type inference failed for: r14v13, types: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r14v12, types: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip]
  assigns: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip, com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip]
  uses: [com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip, ?[OBJECT, ARRAY], com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip]
  mth insns count: 190
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.arashivision.arvbmg.previewer.BMGPreviewerSource IL1Iii(a.a.a.a.e.a.c.h r45, boolean r46) {
        /*
            r44 = this;
            r1 = r44
            monitor-enter(r44)
            r0 = 0
            if (r46 != 0) goto L_0x0011
            boolean r2 = r44.iIlLiL()     // Catch:{ all -> 0x000e }
            if (r2 != 0) goto L_0x0011
            monitor-exit(r44)
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x01cf
        L_0x0011:
            r3 = 0
        L_0x0012:
            r4 = r45
            a.a.a.a.e.a.c.g r4 = (a.a.a.a.e.a.c.g) r4     // Catch:{ all -> 0x000e }
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r4 = r4.f463a     // Catch:{ all -> 0x000e }
            int r4 = r4.size()     // Catch:{ all -> 0x000e }
            if (r3 >= r4) goto L_0x0030
            r4 = r45
            a.a.a.a.e.a.c.g r4 = (a.a.a.a.e.a.c.g) r4     // Catch:{ all -> 0x000e }
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r4 = r4.f463a     // Catch:{ all -> 0x000e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x000e }
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r4 = (com.arashivision.insta360.basemedia.ui.player.video.IVideoParams) r4     // Catch:{ all -> 0x000e }
            r4.loadExtraData()     // Catch:{ all -> 0x000e }
            int r3 = r3 + 1
            goto L_0x0012
        L_0x0030:
            r3 = r45
            a.a.a.a.e.a.c.g r3 = (a.a.a.a.e.a.c.g) r3     // Catch:{ all -> 0x000e }
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r4 = r3.f463a     // Catch:{ all -> 0x000e }
            int r4 = r4.size()     // Catch:{ all -> 0x000e }
            com.arashivision.arvbmg.previewer.BMGSourceClip[] r4 = new com.arashivision.arvbmg.previewer.BMGSourceClip[r4]     // Catch:{ all -> 0x000e }
            r5 = 0
        L_0x003d:
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r6 = r3.f463a     // Catch:{ all -> 0x000e }
            int r6 = r6.size()     // Catch:{ all -> 0x000e }
            r7 = 0
            if (r5 >= r6) goto L_0x01a5
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r6 = r3.f463a     // Catch:{ all -> 0x000e }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x000e }
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = (com.arashivision.insta360.basemedia.ui.player.video.IVideoParams) r6     // Catch:{ all -> 0x000e }
            boolean r9 = r1.m36IL(r5)     // Catch:{ all -> 0x000e }
            if (r9 == 0) goto L_0x0062
            java.util.List<a.a.a.a.e.a.e.q> r10 = r1.f218IL     // Catch:{ all -> 0x000e }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.e.q r10 = (a.a.a.a.e.a.e.q) r10     // Catch:{ all -> 0x000e }
            java.lang.String[] r10 = r10.a()     // Catch:{ all -> 0x000e }
            goto L_0x006d
        L_0x0062:
            if (r46 == 0) goto L_0x0069
            java.lang.String[] r10 = r6.getUrlsForPlay()     // Catch:{ all -> 0x000e }
            goto L_0x006d
        L_0x0069:
            java.lang.String[] r10 = r6.getLrvUrlsForPlay()     // Catch:{ all -> 0x000e }
        L_0x006d:
            boolean r11 = r6.isVideo()     // Catch:{ all -> 0x000e }
            if (r9 == 0) goto L_0x0081
            java.util.List<a.a.a.a.e.a.e.q> r12 = r1.f218IL     // Catch:{ all -> 0x000e }
            java.lang.Object r12 = r12.get(r5)     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.e.q r12 = (a.a.a.a.e.a.e.q) r12     // Catch:{ all -> 0x000e }
            int r12 = r12.c()     // Catch:{ all -> 0x000e }
            double r12 = (double) r12     // Catch:{ all -> 0x000e }
            goto L_0x0085
        L_0x0081:
            double r12 = r6.getFps()     // Catch:{ all -> 0x000e }
        L_0x0085:
            if (r9 == 0) goto L_0x00a8
            java.util.List<a.a.a.a.e.a.e.q> r9 = r1.f218IL     // Catch:{ all -> 0x000e }
            java.lang.Object r9 = r9.get(r5)     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.e.q r9 = (a.a.a.a.e.a.e.q) r9     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.e.k.h r14 = r9.f566a     // Catch:{ all -> 0x000e }
            if (r14 == 0) goto L_0x00ac
            double r7 = r14.getTrimEnd()     // Catch:{ all -> 0x000e }
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r7 = r7 + r14
            a.a.a.a.e.a.e.k.h r9 = r9.f566a     // Catch:{ all -> 0x000e }
            double r14 = r9.getDurationInMs()     // Catch:{ all -> 0x000e }
            double r7 = java.lang.Math.min(r7, r14)     // Catch:{ all -> 0x000e }
            goto L_0x00ac
        L_0x00a8:
            double r7 = r6.getDurationInMs()     // Catch:{ all -> 0x000e }
        L_0x00ac:
            boolean r9 = r6.hasAudio()     // Catch:{ all -> 0x000e }
            float r14 = r6.getSourceVolume()     // Catch:{ all -> 0x000e }
            java.util.List r15 = r6.getSpeedSectionList()     // Catch:{ all -> 0x000e }
            double r21 = r6.getSpeedFactor()     // Catch:{ all -> 0x000e }
            double r23 = r6.getTrimStart()     // Catch:{ all -> 0x000e }
            double r25 = r6.getTrimEnd()     // Catch:{ all -> 0x000e }
            java.util.List<com.arashivision.insta360.basemedia.ui.player.video.IVideoParams> r0 = r3.f463a     // Catch:{ all -> 0x000e }
            int r0 = r0.size()     // Catch:{ all -> 0x000e }
            r2 = 1
            int r0 = r0 - r2
            if (r5 >= r0) goto L_0x00e3
            java.util.List<a.a.a.a.e.a.i.c> r0 = r3.f464b     // Catch:{ all -> 0x000e }
            int r0 = r0.size()     // Catch:{ all -> 0x000e }
            if (r5 >= r0) goto L_0x00e3
            java.util.List<a.a.a.a.e.a.i.c> r0 = r3.f464b     // Catch:{ all -> 0x000e }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.i.c r0 = (a.a.a.a.e.a.i.c) r0     // Catch:{ all -> 0x000e }
            long r16 = a.a.a.a.e.a.e.c.a(r0)     // Catch:{ all -> 0x000e }
            goto L_0x00e5
        L_0x00e3:
            r16 = 0
        L_0x00e5:
            r41 = r16
            if (r46 == 0) goto L_0x00f0
            com.arashivision.insta360.basemedia.ui.player.video.IPlayVideoParams r0 = r1.ILil     // Catch:{ all -> 0x000e }
            float r0 = r0.getMuteBgmWhenSpeedMoreThan()     // Catch:{ all -> 0x000e }
            goto L_0x00f1
        L_0x00f0:
            r0 = 0
        L_0x00f1:
            if (r46 == 0) goto L_0x00fa
            long[] r6 = r6.getExtraInfoPos()     // Catch:{ all -> 0x000e }
            r45 = r14
            goto L_0x0109
        L_0x00fa:
            r45 = r14
            long[] r14 = new long[r2]     // Catch:{ all -> 0x000e }
            long[] r6 = r6.getExtraInfoPos()     // Catch:{ all -> 0x000e }
            r16 = 0
            r17 = r6[r16]     // Catch:{ all -> 0x000e }
            r14[r16] = r17     // Catch:{ all -> 0x000e }
            r6 = r14
        L_0x0109:
            r27 = 1
            r20 = 1
            r43 = r45
            r2 = r15
            r14 = r7
            r16 = r23
            r18 = r25
            double[] r28 = a.a.a.a.b.a.a(r14, r16, r18, r20)     // Catch:{ all -> 0x000e }
            if (r11 == 0) goto L_0x0187
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x000e }
            r11.<init>(r2)     // Catch:{ all -> 0x000e }
            a.a.a.a.e.a.l.b r2 = new a.a.a.a.e.a.l.b     // Catch:{ all -> 0x000e }
            r2.<init>()     // Catch:{ all -> 0x000e }
            r14 = r7
            r16 = r11
            r17 = r21
            r19 = r23
            r21 = r25
            r23 = r27
            r24 = r2
            java.util.List r2 = a.a.a.a.b.a.a(r14, r16, r17, r19, r21, r23, r24)     // Catch:{ all -> 0x000e }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x000e }
            int r11 = r2.size()     // Catch:{ all -> 0x000e }
            com.arashivision.arvbmg.previewer.BMGPreviewerSource$ClipTimeScale[] r11 = new com.arashivision.arvbmg.previewer.BMGPreviewerSource.ClipTimeScale[r11]     // Catch:{ all -> 0x000e }
            r14 = 0
        L_0x013f:
            int r15 = r2.size()     // Catch:{ all -> 0x000e }
            if (r14 >= r15) goto L_0x0150
            java.lang.Object r15 = r2.get(r14)     // Catch:{ all -> 0x000e }
            com.arashivision.arvbmg.previewer.BMGPreviewerSource$ClipTimeScale r15 = (com.arashivision.arvbmg.previewer.BMGPreviewerSource.ClipTimeScale) r15     // Catch:{ all -> 0x000e }
            r11[r14] = r15     // Catch:{ all -> 0x000e }
            int r14 = r14 + 1
            goto L_0x013f
        L_0x0150:
            com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip r2 = new com.arashivision.arvbmg.previewer.BMGPreviewerSource$FileSourceClip     // Catch:{ all -> 0x000e }
            java.util.List r15 = java.util.Arrays.asList(r10)     // Catch:{ all -> 0x000e }
            r10 = 0
            r16 = r28[r10]     // Catch:{ all -> 0x000e }
            r10 = 1
            r18 = r28[r10]     // Catch:{ all -> 0x000e }
            r10 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 / r0
            double r0 = (double) r10     // Catch:{ all -> 0x000e }
            r22 = r0
            r0 = r41
            double r0 = (double) r0     // Catch:{ all -> 0x000e }
            r26 = r0
            r0 = r43
            double r0 = (double) r0     // Catch:{ all -> 0x000e }
            r30 = r0
            r28 = 0
            r32 = 0
            r34 = 0
            r37 = 1061997773(0x3f4ccccd, float:0.8)
            r38 = 1073741824(0x40000000, float:2.0)
            r14 = r2
            r20 = r7
            r24 = r9
            r25 = r11
            r36 = r6
            r39 = r12
            r14.<init>(r15, r16, r18, r20, r22, r24, r25, r26, r28, r30, r32, r34, r36, r37, r38, r39)     // Catch:{ all -> 0x000e }
            r7 = 0
            goto L_0x019c
        L_0x0187:
            r0 = r41
            com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip r2 = new com.arashivision.arvbmg.previewer.BMGPreviewerSource$ImageSourceClip     // Catch:{ all -> 0x000e }
            r7 = 0
            r15 = r10[r7]     // Catch:{ all -> 0x000e }
            r8 = 1
            r16 = r28[r8]     // Catch:{ all -> 0x000e }
            double r0 = (double) r0     // Catch:{ all -> 0x000e }
            r14 = r2
            r18 = r12
            r20 = r0
            r22 = r6
            r14.<init>(r15, r16, r18, r20, r22)     // Catch:{ all -> 0x000e }
        L_0x019c:
            r4[r5] = r2     // Catch:{ all -> 0x000e }
            int r5 = r5 + 1
            r0 = 0
            r1 = r44
            goto L_0x003d
        L_0x01a5:
            boolean r0 = r3.containsBgmData()     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x01bd
            java.lang.String r10 = r3.f469g     // Catch:{ all -> 0x000e }
            long r0 = r3.f470h     // Catch:{ all -> 0x000e }
            long r5 = r3.f471i     // Catch:{ all -> 0x000e }
            double r11 = (double) r5     // Catch:{ all -> 0x000e }
            com.arashivision.arvbmg.previewer.BMGPreviewerSource$EntireBgmSourceClip r2 = new com.arashivision.arvbmg.previewer.BMGPreviewerSource$EntireBgmSourceClip     // Catch:{ all -> 0x000e }
            double r0 = (double) r0     // Catch:{ all -> 0x000e }
            r9 = r2
            r13 = r0
            r15 = r0
            r9.<init>(r10, r11, r13, r15)     // Catch:{ all -> 0x000e }
            r0 = r2
            goto L_0x01be
        L_0x01bd:
            r0 = 0
        L_0x01be:
            boolean r1 = r3.containsBgmData()     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x01c7
            float r1 = r3.f472j     // Catch:{ all -> 0x000e }
            double r7 = (double) r1     // Catch:{ all -> 0x000e }
        L_0x01c7:
            java.lang.String r1 = r3.k     // Catch:{ all -> 0x000e }
            com.arashivision.arvbmg.previewer.BMGPreviewerSource r0 = com.arashivision.arvbmg.previewer.BMGPreviewerSourceBuilder.buildPreviwerSouce(r4, r0, r7, r1)     // Catch:{ all -> 0x000e }
            monitor-exit(r44)
            return r0
        L_0x01cf:
            monitor-exit(r44)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.IL1Iii(a.a.a.a.e.a.c.h, boolean):com.arashivision.arvbmg.previewer.BMGPreviewerSource");
    }

    /* renamed from: I丨iL reason: contains not printable characters */
    public final boolean m37IiL() {
        for (a.a.a.a.e.a.i.c cVar : ((a.a.a.a.e.a.c.g) this.IL1Iii).f464b) {
            if (cVar != null && cVar.f582a != a.a.a.a.e.a.i.c.a.NONE) {
                return true;
            }
        }
        return false;
    }

    public final ClipRenderInfo Ilil(int i2) {
        int i3 = i2;
        l lVar = (l) this.Ilil.get(i3);
        f fVar = (f) this.f241lLi1LL.get(i3);
        IVideoParams iVideoParams = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i3);
        ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = lVar.a(this.ILil.getRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        if (fVar.a(a2.getType())) {
            clipRenderInfo.setCameraFacing(iVideoParams.getCameraFacing());
        }
        if (iVideoParams.isRotateEnabled() && iVideoParams.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(iVideoParams.getRotateDegree());
        }
        if (lVar.a(iVideoParams.getFileType(), a2.getType())) {
            clipRenderInfo.setColorAdjust(iVideoParams.isColorAdjustEnabled());
            if (iVideoParams.getBlendAngleRad() >= 0.0f) {
                clipRenderInfo.setBlendAngleRad(iVideoParams.getBlendAngleRad());
            }
        }
        clipRenderInfo.setImageFusion(false);
        clipRenderInfo.setContentMode(lVar.a());
        clipRenderInfo.setImageLayout(lVar.a(false));
        clipRenderInfo.setSubStreamImageLayout(lVar.b());
        clipRenderInfo.setBaseCameraController(fVar.f513b);
        BMGStabilizer stabilizer = iVideoParams.getStabilizer();
        if (stabilizer != null) {
            clipRenderInfo.setStabilizer(stabilizer);
            clipRenderInfo.setStabilizingType(iVideoParams.getStabilizingType());
        }
        clipRenderInfo.setDynamicStitchType(lVar.a(false, iVideoParams.isColorAdjustEnabled(), false, a2.getType(), iVideoParams.getStabilizer(), true));
        clipRenderInfo.setPovMode(iVideoParams.getConstraint() != null ? iVideoParams.getConstraint().getPovMode() : 0);
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setLogoInfo(lVar.b(lVar.f533a.isLogoEnabled()));
        clipRenderInfo.setFilterInfos(IL1Iii(i3, false));
        clipRenderInfo.setSphereSlices(100);
        clipRenderInfo.setSphereStacks(50);
        n nVar = (n) this.f228L11I.get(i3);
        if (!nVar.b() || this.f220L11) {
            clipRenderInfo.setMultiViewInfo(null);
            return clipRenderInfo;
        }
        l lVar2 = (l) this.Ilil.get(i3);
        f fVar2 = (f) this.f241lLi1LL.get(i3);
        IVideoParams iVideoParams2 = (IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(i3);
        MultiViewInfo multiViewInfo = new MultiViewInfo();
        ClipRenderInfo clipRenderInfo2 = new ClipRenderInfo();
        RenderModelType a3 = lVar2.a(this.ILil.getRenderModelType());
        clipRenderInfo2.setModelType(a3.getType());
        clipRenderInfo2.setVRMode(iVideoParams2.getVRMode());
        if (fVar2.a(a3.getType())) {
            clipRenderInfo2.setCameraFacing(iVideoParams2.getCameraFacing());
        }
        if (iVideoParams2.isRotateEnabled() && iVideoParams2.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo2.setPlaneRotationDegreee(iVideoParams2.getRotateDegree());
        }
        if (lVar2.a(iVideoParams2.getFileType(), a3.getType())) {
            clipRenderInfo2.setColorAdjust(iVideoParams2.isColorAdjustEnabled());
            if (iVideoParams2.getBlendAngleRad() >= 0.0f) {
                clipRenderInfo2.setBlendAngleRad(iVideoParams2.getBlendAngleRad());
            }
        }
        clipRenderInfo2.setImageFusion(false);
        clipRenderInfo2.setContentMode(lVar2.a());
        clipRenderInfo2.setImageLayout(lVar2.a(false));
        clipRenderInfo2.setSubStreamImageLayout(lVar2.b());
        clipRenderInfo2.setBaseCameraController(nVar.f539d.f513b);
        BMGStabilizer stabilizer2 = iVideoParams2.getStabilizer();
        if (stabilizer2 != null) {
            clipRenderInfo2.setStabilizer(stabilizer2);
            clipRenderInfo2.setStabilizingType(iVideoParams2.getStabilizingType());
        }
        clipRenderInfo2.setDynamicStitchType(lVar2.a(false, iVideoParams2.isColorAdjustEnabled(), false, a3.getType(), iVideoParams2.getStabilizer(), true));
        clipRenderInfo2.setOffset(a3.getOffset());
        clipRenderInfo2.setFilterInfos(IL1Iii(i3, true));
        clipRenderInfo2.setSphereSlices(100);
        clipRenderInfo2.setSphereStacks(50);
        multiViewInfo.mClipRenderInfo = clipRenderInfo2;
        n nVar2 = (n) this.f228L11I.get(i3);
        nVar2.f536a.getMultiViewConfig().a(nVar2.f536a.getScreenRatio());
        throw null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean IL1Iii(View view, MotionEvent motionEvent) {
        a.a.a.a.e.a.e.e eVar = this.f237lIiI;
        this.f215ILl.onUpdate(motionEvent);
        return true;
    }

    /* renamed from: IL1Iii */
    public final void ILil(float[] fArr, String str, String str2, String str3, String str4, float f2, boolean z, String str5, int i2, float f3, boolean z2) {
        boolean z3 = z;
        this.f224LlIl = null;
        List<Integer> list = this.LlLI1;
        if (list == null || list.size() != 1) {
            l1Lll.e("startSmartTrackInner(), but mClipIndexList.size() is not 1!");
        } else if (((Integer) this.LlLI1.get(0)).intValue() != this.f213IIiI) {
            l1Lll.e("startSmartTrackInner(), but clipIndex is not match!");
        } else {
            Transform cameraTransform = getCameraTransform();
            LongTrackInfo longTrackInfo = new LongTrackInfo();
            longTrackInfo.screenX = (double) fArr[0];
            longTrackInfo.screenY = (double) fArr[1];
            longTrackInfo.minFov = (float) Math.toRadians(0.0d);
            longTrackInfo.maxFov = (float) Math.toRadians(150.0d);
            longTrackInfo.smoothFactor = 2.0f;
            longTrackInfo.curentFov = cameraTransform.getFov();
            longTrackInfo.mnnPath = str;
            longTrackInfo.namePath = str2;
            longTrackInfo.roiPath = str4;
            longTrackInfo.headThreshold = f2;
            longTrackInfo.detectSkeleton = z3;
            longTrackInfo.objectName = i2;
            longTrackInfo.objectRatio = f3;
            longTrackInfo.detectAround = z2;
            if (z3) {
                longTrackInfo.headThreshold = 0.5f;
                longTrackInfo.minFov = Math.max((float) Math.toRadians(35.0d), cameraTransform.getFov());
                longTrackInfo.maxFov = Math.min((float) Math.toRadians(70.0d), cameraTransform.getFov());
                longTrackInfo.skeletonMnnPath = str3;
                longTrackInfo.skeletonCachePath = str5;
            }
            this.f216I.startTrack(longTrackInfo, ((f) this.f241lLi1LL.get(this.f213IIiI)).f513b, new e.b.c.b.b.a.d.g(this), new e.b.c.b.b.a.d.f(this));
        }
    }

    public final void IL1Iii(String str, String str2, String str3) {
        this.f224LlIl = null;
        if (this.f216I != null) {
            List<Integer> list = this.LlLI1;
            if (list == null || list.size() != 1) {
                l1Lll.e("startStapleTrackInner(), but mClipIndexList.size() is not 1!");
            } else if (((Integer) this.LlLI1.get(0)).intValue() != this.f213IIiI) {
                l1Lll.e("startStapleTrackInner(), but clipIndex is not match!");
            } else {
                StapleTrackInfo stapleTrackInfo = new StapleTrackInfo();
                stapleTrackInfo.currentFov = (float) Math.toDegrees((double) getCameraTransform().getFov());
                stapleTrackInfo.maxFov = 150.0f;
                stapleTrackInfo.minFov = 0.0f;
                stapleTrackInfo.detectorPath = str;
                stapleTrackInfo.namePath = str2;
                stapleTrackInfo.roiPath = str3;
                int[] constraintRatio = ((IVideoParams) ((a.a.a.a.e.a.c.g) this.IL1Iii).f463a.get(this.f213IIiI)).getConstraintRatio();
                if (constraintRatio[0] < constraintRatio[1]) {
                    stapleTrackInfo.offscreenHeight = 300;
                    stapleTrackInfo.offscreenWidth = (constraintRatio[0] * 300) / constraintRatio[1];
                } else {
                    stapleTrackInfo.offscreenWidth = 300;
                    stapleTrackInfo.offscreenHeight = (constraintRatio[1] * 300) / constraintRatio[0];
                }
                stapleTrackInfo.baseCameraController = ((f) this.f241lLi1LL.get(this.f213IIiI)).f513b;
                this.f216I.setStapleTrack(stapleTrackInfo, false);
                resume();
            }
        }
    }
}
