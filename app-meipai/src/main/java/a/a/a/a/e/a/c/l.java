package a.a.a.a.e.a.c;

import a.a.a.a.e.a.e.c;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.h;
import a.a.a.a.e.a.e.n;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.g.e;
import a.a.a.a.e.a.i.a.b;
import android.os.SystemClock;
import android.view.ViewGroup.LayoutParams;
import com.arashivision.algorithm.StapleTrackResult;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo.RenderRect;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.lottie.data.CompositionData;
import com.arashivision.arvbmg.render.lottie.data.FloatBezierData;
import com.arashivision.arvbmg.render.lottie.data.IntBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PointBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.ScaleBezierData;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo.LottieMaskData;
import com.arashivision.arvbmg.render.lottie.utils.MaskPathUtils;
import com.arashivision.arvbmg.render.rendermodel.TransitionEffect;
import com.arashivision.arvbmg.render.rendermodel.TransitionTransform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView;
import e.a.a.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class l implements PreviewerRenderCallback {

    /* renamed from: a reason: collision with root package name */
    public int f485a = 0;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ VideoPlayerView f486b;

    public l(VideoPlayerView videoPlayerView) {
        this.f486b = videoPlayerView;
        new DecimalFormat("#.##");
        new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        synchronized (this.f486b) {
            this.f486b.m42lIlii();
        }
    }

    public final double[] a(int i2, j[] jVarArr) {
        double trimStart = ((IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i2)).getTrimStart();
        double trimEnd = ((IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i2)).getTrimEnd();
        if (i2 == jVarArr[0].f480a) {
            trimStart = Math.max(trimStart, jVarArr[0].f481b);
        }
        if (i2 == jVarArr[1].f480a) {
            trimEnd = Math.min(trimEnd, jVarArr[1].f481b);
        }
        return new double[]{trimStart, trimEnd};
    }

    public void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9) {
        if (this.f486b.m39L11I()) {
            int size = this.f486b.f239lIlii.size();
            if (size == 0 || size == 1) {
                VideoPlayerView.l1Lll.d("onFrameRender, single clip to cut scene");
            }
            synchronized (this.f486b) {
                this.f486b.f240llL1ii.clear();
                this.f486b.f240llL1ii.add(Double.valueOf(a(i2, d2, d3)));
                this.f486b.f240llL1ii.add(Double.valueOf(a(i3, d6, d7)));
                j[] I1I = this.f486b.getCurrentPlayRangeSrc();
                int i4 = i2;
                double[] a2 = a(i2, I1I);
                double[] a3 = a(i3, I1I);
                this.f486b.f239lIlii.clear();
                List<Double> list = this.f486b.f239lIlii;
                double d10 = a2[0];
                list.add(Double.valueOf(Math.min(Math.max(d3, d10), a2[1])));
                List<Double> list2 = this.f486b.f239lIlii;
                double d11 = a3[0];
                list2.add(Double.valueOf(Math.min(Math.max(d7, d11), a3[1])));
            }
            VideoPlayerView.IL1Iii(this.f486b);
        }
    }

    public void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
        if (this.f486b.m39L11I()) {
            int size = this.f486b.f239lIlii.size();
            if (size == 0 || size == 2) {
                VideoPlayerView.l1Lll.d("onFrameRender, cut scene to single clip");
            }
            b(i2, d2, d3);
            a();
            VideoPlayerView.IL1Iii(this.f486b);
        }
    }

    public ClipRenderInfo onGetClipRenderInfo(int i2) {
        if (!this.f486b.m39L11I()) {
            ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
            clipRenderInfo.setModelType(20);
            return clipRenderInfo;
        }
        MediaLogger mediaLogger = VideoPlayerView.l1Lll;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetClipRenderInfo, clipIndex: ");
        sb.append(i2);
        mediaLogger.d(sb.toString());
        synchronized (this.f486b) {
            this.f486b.LlLI1.clear();
            this.f486b.LlLI1.add(Integer.valueOf(i2));
        }
        if (this.f486b.IL1Iii()) {
            VideoPlayerView videoPlayerView = this.f486b;
            videoPlayerView.f215ILl.setCameraController(((f) videoPlayerView.f241lLi1LL.get(i2)).f513b);
            Constraint constraint = ((IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i2)).getConstraint();
            this.f486b.Lil();
            this.f486b.f215ILl.setFovDistanceCalculateMinMax(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
        }
        if (this.f486b.IL1Iii(i2)) {
            VideoPlayerView videoPlayerView2 = this.f486b;
            videoPlayerView2.ILil(i2, videoPlayerView2.f249);
        }
        VideoPlayerView videoPlayerView3 = this.f486b;
        if (videoPlayerView3.f220L11 && videoPlayerView3.f213IIiI != i2) {
            videoPlayerView3.stopSmartTrack();
        }
        VideoPlayerView videoPlayerView4 = this.f486b;
        videoPlayerView4.f217IIi = -2;
        for (IVideoPlayerViewListener onPlayClip : videoPlayerView4.f244i11i) {
            onPlayClip.onPlayClip(i2);
        }
        this.f486b.post(new d(this));
        return this.f486b.Ilil(i2);
    }

    public LottieSetupInfo onLottieSetup(int i2, int i3, double d2) {
        if (!this.f486b.m39L11I()) {
            return new LottieSetupInfo();
        }
        for (IVideoPlayerViewListener onPlayCutScene : this.f486b.f244i11i) {
            onPlayCutScene.onPlayCutScene(i2, i3);
        }
        MediaLogger mediaLogger = VideoPlayerView.l1Lll;
        StringBuilder a2 = a.a("onLottieSetup, prevClipIndex: ", i2, ", nextClipIndex: ", i3, ", frameMediaTime: ");
        a2.append(d2);
        mediaLogger.d(a2.toString());
        synchronized (this.f486b) {
            this.f486b.LlLI1.clear();
            this.f486b.LlLI1.add(Integer.valueOf(i2));
            this.f486b.LlLI1.add(Integer.valueOf(i3));
        }
        c cVar = (c) this.f486b.f246il.get(i2);
        IVideoParams iVideoParams = (IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i2);
        IVideoParams iVideoParams2 = (IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i3);
        int measuredWidth = this.f486b.f234ili11.getMeasuredWidth();
        int measuredHeight = this.f486b.f234ili11.getMeasuredHeight();
        cVar.f501f = -1.0d;
        LottieSetupInfo lottieSetupInfo = new LottieSetupInfo();
        RenderRect renderRect = new RenderRect();
        lottieSetupInfo.mRenderRect = renderRect;
        renderRect.renderWidth = (float) measuredWidth;
        renderRect.renderHeight = (float) measuredHeight;
        Float[] a3 = cVar.a(iVideoParams, measuredWidth, measuredHeight);
        Float[] a4 = cVar.a(iVideoParams2, measuredWidth, measuredHeight);
        lottieSetupInfo.mRenderRect.contentOutMinX = a3[0].floatValue();
        lottieSetupInfo.mRenderRect.contentOutMaxX = a3[1].floatValue();
        lottieSetupInfo.mRenderRect.contentOutMinY = a3[2].floatValue();
        lottieSetupInfo.mRenderRect.contentOutMaxY = a3[3].floatValue();
        lottieSetupInfo.mRenderRect.contentInMinX = a4[0].floatValue();
        lottieSetupInfo.mRenderRect.contentInMaxX = a4[1].floatValue();
        lottieSetupInfo.mRenderRect.contentInMinY = a4[2].floatValue();
        lottieSetupInfo.mRenderRect.contentInMaxY = a4[3].floatValue();
        lottieSetupInfo.mClipRenderInfos = new ClipRenderInfo[]{this.f486b.Ilil(i2), this.f486b.Ilil(i3)};
        lottieSetupInfo.mFilterInfos = this.f486b.getCutSceneFilterInfos();
        return lottieSetupInfo;
    }

    public LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2) {
        LottieUpdateInfo lottieUpdateInfo;
        TransitionTransform transitionTransform;
        TransitionEffect transitionEffect;
        LottieMaskData lottieMaskData;
        int i4 = i2;
        if (!this.f486b.m39L11I()) {
            LottieUpdateInfo lottieUpdateInfo2 = new LottieUpdateInfo(0.0f, 0.0f, null, null, null);
            return lottieUpdateInfo2;
        }
        c cVar = (c) this.f486b.f246il.get(i4);
        double clipEndTimeMsExcludeEndCutscenes = this.f486b.f216I.getClipEndTimeMsExcludeEndCutscenes(i4);
        if (cVar.f497b != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (cVar.f496a.f582a.f593c) {
                clipEndTimeMsExcludeEndCutscenes += 500.0d;
            }
            double d3 = d2 - clipEndTimeMsExcludeEndCutscenes;
            MediaLogger mediaLogger = c.f495g;
            StringBuilder sb = new StringBuilder();
            sb.append("getLottieUpdateInfo, cutScenePosition: ");
            sb.append(d3);
            mediaLogger.d(sb.toString());
            String str = "cutScenePosition(";
            if (d3 < 0.0d) {
                MediaLogger mediaLogger2 = c.f495g;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(d3);
                sb2.append(") < 0");
                mediaLogger2.e(sb2.toString());
            }
            if (d3 > ((double) cVar.f496a.f583b)) {
                MediaLogger mediaLogger3 = c.f495g;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(d3);
                sb3.append(") > duration(");
                sb3.append(cVar.f496a.f583b);
                sb3.append(")");
                mediaLogger3.e(sb3.toString());
            }
            double d4 = cVar.f501f;
            String str2 = "ms";
            if (d4 >= 0.0d) {
                String str3 = "ms, current position: ";
                if (d3 - d4 > 50.0d) {
                    MediaLogger mediaLogger4 = c.f495g;
                    StringBuilder a2 = a.a("cut scene frame maybe skipped, last position: ");
                    a2.append(cVar.f501f);
                    a2.append(str3);
                    a2.append(d3);
                    a2.append(str2);
                    mediaLogger4.e(a2.toString());
                }
                if (d3 <= cVar.f501f) {
                    MediaLogger mediaLogger5 = c.f495g;
                    StringBuilder a3 = a.a("cut scene frame equal or back, last position: ");
                    a3.append(cVar.f501f);
                    a3.append(str3);
                    a3.append(d3);
                    a3.append(str2);
                    mediaLogger5.e(a3.toString());
                }
            }
            cVar.f501f = d3;
            c.a aVar = cVar.f497b;
            long j2 = aVar.f502a;
            float f2 = (float) (((d3 - ((double) j2)) * 1.0d) / ((double) (aVar.f503b - j2)));
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f3 = 1.0f;
            float f4 = f2 > 1.0f ? 1.0f : f2;
            CompositionData compositionData = cVar.f497b.f504c;
            if (!compositionData.containsTransformData()) {
                transitionTransform = null;
            } else {
                FloatBezierData transformOpacityByProgress = compositionData.getTransformOpacityByProgress(0, f4);
                PointBezierData transformPositionByProgress = compositionData.getTransformPositionByProgress(0, f4);
                ScaleBezierData transformScaleByProgress = compositionData.getTransformScaleByProgress(0, f4);
                FloatBezierData transformRotationByProgress = compositionData.getTransformRotationByProgress(0, f4);
                FloatBezierData transformOpacityByProgress2 = compositionData.getTransformOpacityByProgress(1, f4);
                PointBezierData transformPositionByProgress2 = compositionData.getTransformPositionByProgress(1, f4);
                ScaleBezierData transformScaleByProgress2 = compositionData.getTransformScaleByProgress(1, f4);
                FloatBezierData transformRotationByProgress2 = compositionData.getTransformRotationByProgress(1, f4);
                float f5 = transformOpacityByProgress != null ? transformOpacityByProgress.getValue() / 100.0f >= 1.0f ? 0.9999f : transformOpacityByProgress.getValue() / 100.0f : 1.0f;
                float f6 = transformPositionByProgress != null ? transformPositionByProgress.getPoint()[0] : 0.0f;
                float f7 = transformPositionByProgress != null ? transformPositionByProgress.getPoint()[1] : 0.0f;
                float xScale = transformScaleByProgress != null ? transformScaleByProgress.getXScale() : 1.0f;
                float yScale = transformScaleByProgress != null ? transformScaleByProgress.getYScale() : 1.0f;
                float radians = (float) Math.toRadians(transformRotationByProgress != null ? (double) transformRotationByProgress.getValue() : 0.0d);
                float f8 = transformOpacityByProgress2 != null ? transformOpacityByProgress2.getValue() / 100.0f >= 1.0f ? 0.9999f : transformOpacityByProgress2.getValue() / 100.0f : 1.0f;
                float f9 = transformPositionByProgress2 != null ? transformPositionByProgress2.getPoint()[0] : 0.0f;
                float f10 = transformPositionByProgress2 != null ? transformPositionByProgress2.getPoint()[1] : 0.0f;
                float xScale2 = transformScaleByProgress2 != null ? transformScaleByProgress2.getXScale() : 1.0f;
                if (transformScaleByProgress2 != null) {
                    f3 = transformScaleByProgress2.getYScale();
                }
                TransitionTransform transitionTransform2 = new TransitionTransform(f5, f6, f7, 0.0f, 0.0f, xScale, yScale, radians, f8, f9, f10, 0.0f, 0.0f, xScale2, f3, (float) Math.toRadians(transformRotationByProgress2 != null ? (double) transformRotationByProgress2.getValue() : 0.0d));
                transitionTransform = transitionTransform2;
            }
            CompositionData compositionData2 = cVar.f497b.f504c;
            if (!compositionData2.containsEffectData()) {
                transitionEffect = null;
            } else {
                FloatBezierData effectGaussianBlurriness = compositionData2.getEffectGaussianBlurriness(0, f4);
                IntBezierData effectGaussianDimensions = compositionData2.getEffectGaussianDimensions(0, f4);
                FloatBezierData effectRadialAmount = compositionData2.getEffectRadialAmount(0, f4);
                PointBezierData effectRadialCenter = compositionData2.getEffectRadialCenter(0, f4);
                IntBezierData effectRadialType = compositionData2.getEffectRadialType(0, f4);
                FloatBezierData effectGaussianBlurriness2 = compositionData2.getEffectGaussianBlurriness(1, f4);
                IntBezierData effectGaussianDimensions2 = compositionData2.getEffectGaussianDimensions(1, f4);
                FloatBezierData effectRadialAmount2 = compositionData2.getEffectRadialAmount(1, f4);
                PointBezierData effectRadialCenter2 = compositionData2.getEffectRadialCenter(1, f4);
                IntBezierData effectRadialType2 = compositionData2.getEffectRadialType(1, f4);
                transitionEffect = new TransitionEffect(effectGaussianBlurriness != null ? effectGaussianBlurriness.getValue() : 0.0f, effectGaussianDimensions != null ? (float) effectGaussianDimensions.getValue() : 0.0f, effectRadialAmount != null ? effectRadialAmount.getValue() : 0.0f, effectRadialCenter != null ? effectRadialCenter.getPoint()[0] : 0.0f, effectRadialCenter != null ? effectRadialCenter.getPoint()[1] : 0.0f, effectRadialType != null ? (float) effectRadialType.getValue() : 0.0f, effectGaussianBlurriness2 != null ? effectGaussianBlurriness2.getValue() : 0.0f, effectGaussianDimensions2 != null ? (float) effectGaussianDimensions2.getValue() : 0.0f, effectRadialAmount2 != null ? effectRadialAmount2.getValue() : 0.0f, effectRadialCenter2 != null ? effectRadialCenter2.getPoint()[0] : 0.0f, effectRadialCenter2 != null ? effectRadialCenter2.getPoint()[1] : 0.0f, effectRadialType2 != null ? (float) effectRadialType2.getValue() : 0.0f);
            }
            CompositionData compositionData3 = cVar.f497b.f504c;
            if (!compositionData3.containsMaskData()) {
                lottieMaskData = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                lottieMaskData = MaskPathUtils.getLottieMaskData(compositionData3.getMaskShape(1, f4), compositionData3.getMaskOpacity(1, f4), 500, 500);
                long uptimeMillis3 = SystemClock.uptimeMillis();
                MediaLogger mediaLogger6 = c.f495g;
                StringBuilder a4 = a.a("generate lottie mask cost: ");
                a4.append(uptimeMillis3 - uptimeMillis2);
                a4.append(str2);
                mediaLogger6.d(a4.toString());
            }
            lottieUpdateInfo = new LottieUpdateInfo(0.0f, f4, transitionTransform, transitionEffect, lottieMaskData);
            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis4 >= 3) {
                MediaLogger mediaLogger7 = c.f495g;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("getLottieUpdateInfo cost: ");
                sb4.append(uptimeMillis4);
                sb4.append("ms (more than 2ms)");
                mediaLogger7.e(sb4.toString());
            }
        } else {
            lottieUpdateInfo = null;
        }
        return lottieUpdateInfo;
    }

    public boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5) {
        if (!this.f486b.m39L11I()) {
            return false;
        }
        n nVar = (n) this.f486b.f228L11I.get(i2);
        double[] a2 = a(i2, this.f486b.getCurrentPlayRangeSrc());
        return nVar.a(p.a(d3, a2[0], a2[1]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRenderBefore() {
        /*
            r5 = this;
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            boolean r0 = r0.m39L11I()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            long r1 = r0.f230iI1iI
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            long r1 = r1.getId()
            r0.f230iI1iI = r1
        L_0x001d:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b     // Catch:{ Exception -> 0x002d }
            r0.m43llL1ii()     // Catch:{ Exception -> 0x002d }
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b     // Catch:{ Exception -> 0x002d }
            a.a.a.a.e.a.c.b r1 = new a.a.a.a.e.a.c.b     // Catch:{ Exception -> 0x002d }
            r1.<init>(r5)     // Catch:{ Exception -> 0x002d }
            r0.post(r1)     // Catch:{ Exception -> 0x002d }
            goto L_0x0044
        L_0x002d:
            r0 = move-exception
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            int r1 = r0.length
            r2 = 0
        L_0x0034:
            if (r2 >= r1) goto L_0x0044
            r3 = r0[r2]
            com.arashivision.insta360.basemedia.log.MediaLogger r4 = com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.l1Lll
            java.lang.String r3 = r3.toString()
            r4.e(r3)
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0044:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            boolean r0 = r0.isSeeking()
            if (r0 == 0) goto L_0x0051
            r0 = 30
        L_0x004e:
            r5.f485a = r0
            goto L_0x0058
        L_0x0051:
            int r0 = r5.f485a
            if (r0 <= 0) goto L_0x0058
            int r0 = r0 + -1
            goto L_0x004e
        L_0x0058:
            int r0 = r5.f485a
            if (r0 > 0) goto L_0x0072
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r0.iIilII1
            java.lang.Object r0 = r0.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            if (r0 == 0) goto L_0x0072
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.l1Lll
            java.lang.String r2 = "execute a setting runnable~"
            r1.d(r2)
            r0.run()
        L_0x0072:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            int r1 = r0.f242lliiI1
            if (r1 <= 0) goto L_0x009a
            double r0 = r0.getCurrentFrameTime()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x009a
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            int r1 = r0.f242lliiI1
            int r1 = r1 + -1
            r0.f242lliiI1 = r1
            if (r1 > 0) goto L_0x009a
            com.arashivision.insta360.basemedia.log.MediaLogger r0 = com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.l1Lll
            java.lang.String r1 = "StartSmartTrack which is waiting for OnRenderBeforeFrameCount"
            r0.d(r1)
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r5.f486b
            java.lang.Runnable r1 = r0.f224LlIl
            r0.post(r1)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.c.l.onRenderBefore():void");
    }

    public void onRenderNotify(int i2, int i3, int i4) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r5 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r5 != null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStapleTrackError(int r5) {
        /*
            r4 = this;
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r0 = r4.f486b
            boolean r0 = r0.m39L11I()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            r0 = 1
            if (r5 == r0) goto L_0x0013
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            a.a.a.a.e.a.g.e r5 = r5.lL
            if (r5 == 0) goto L_0x0040
            goto L_0x003d
        L_0x0013:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            double r0 = r5.getCurrentFrameTime()
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            java.lang.Double r2 = r5.LLL
            if (r2 != 0) goto L_0x0025
            java.lang.Double r2 = java.lang.Double.valueOf(r0)
            r5.LLL = r2
        L_0x0025:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            java.lang.Double r5 = r5.LLL
            double r2 = r5.doubleValue()
            double r0 = r0 - r2
            r2 = 4656510908468559872(0x409f400000000000, double:2000.0)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0045
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            a.a.a.a.e.a.g.e r5 = r5.lL
            if (r5 == 0) goto L_0x0040
        L_0x003d:
            r5.a()
        L_0x0040:
            com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView r5 = r4.f486b
            r5.stopStapleTrack()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.c.l.onStapleTrackError(int):void");
    }

    public void onStapleTrackResult(StapleTrackResult stapleTrackResult) {
        MediaLogger mediaLogger = VideoPlayerView.l1Lll;
        StringBuilder sb = new StringBuilder();
        sb.append("onStapleTrackResult() called with: stapleTrackResult = [");
        sb.append(stapleTrackResult);
        sb.append("]");
        mediaLogger.d(sb.toString());
        if (this.f486b.m39L11I()) {
            e eVar = this.f486b.lL;
            if (eVar != null) {
                stapleTrackResult.getFov();
                stapleTrackResult.getSmoothQuat();
                stapleTrackResult.getUnsmoothQuat();
                stapleTrackResult.getRect();
                stapleTrackResult.getSrcTime();
                stapleTrackResult.getUnsmoothBottonMiddlePosition();
                eVar.a();
            }
            this.f486b.post(new c(this, stapleTrackResult.getRect()));
        }
    }

    public void onStapleTrackStop() {
        if (this.f486b.m39L11I()) {
            this.f486b.m34ILl();
            e eVar = this.f486b.lL;
            if (eVar != null) {
                eVar.onStopTrack(0);
            }
        }
    }

    public void onStopTrack(long j2) {
        if (this.f486b.m39L11I()) {
            e eVar = this.f486b.lL;
            if (eVar != null) {
                eVar.onStopTrack(j2);
            }
        }
    }

    public void onSubStreamFrameRender(int i2, double d2, double d3, double d4, double d5) {
        if (this.f486b.m39L11I()) {
            VideoPlayerView.l1Lll.d("onSubStreamFrameRender");
            a();
            b(i2, d2, d3);
        }
    }

    public BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
        if (this.f486b.m39L11I() && this.f486b.ILil.isApplyFlash() && this.f486b.ILL.get(i2) != null) {
            b bVar = new b();
            this.f486b.getScreenRatio();
            this.f486b.getCameraTransform();
            ((h) this.f486b.ILL.get(i2)).a(d4, d2, bVar);
        }
        return null;
    }

    public void onTrackStart(String str, boolean z) {
        if (this.f486b.m39L11I()) {
            MediaLogger mediaLogger = VideoPlayerView.l1Lll;
            StringBuilder sb = new StringBuilder();
            sb.append("onTrackStart() called with: object = [");
            sb.append(str);
            sb.append("]");
            mediaLogger.d(sb.toString());
            e eVar = this.f486b.lL;
            if (eVar != null) {
                eVar.onTrackStart(str, z);
            }
        }
    }

    public void onTrackUpdate(int i2, long j2, float f2, float[] fArr, float[] fArr2, float[] fArr3) {
        if (this.f486b.m39L11I()) {
            VideoPlayerView videoPlayerView = this.f486b;
            e eVar = videoPlayerView.lL;
            if (eVar != null) {
                videoPlayerView.getCurrentFrameTime();
                eVar.a();
            }
        }
    }

    public MultiViewRectInfo onUpdateMultiviewInfo(int i2, double d2, double d3, double d4, double d5) {
        boolean Ilil = this.f486b.m39L11I();
        return null;
    }

    public final void b(int i2, double d2, double d3) {
        synchronized (this.f486b) {
            this.f486b.f240llL1ii.clear();
            this.f486b.f240llL1ii.add(Double.valueOf(a(i2, d2, d3)));
            this.f486b.f239lIlii.clear();
            List<Double> list = this.f486b.f239lIlii;
            double[] a2 = a(i2, this.f486b.getCurrentPlayRangeSrc());
            double d4 = a2[0];
            list.add(Double.valueOf(Math.min(Math.max(d3, d4), a2[1])));
        }
    }

    public final double a(int i2, double d2, double d3) {
        double[] a2 = a(i2, this.f486b.getCurrentPlayRangeSrc());
        return p.a(((IVideoParams) ((g) this.f486b.IL1Iii).f463a.get(i2)).isVideo() ? d2 : d3, a2[0], a2[1]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(float[] fArr) {
        VideoPlayerView videoPlayerView = this.f486b;
        if (videoPlayerView.f220L11) {
            videoPlayerView.iI.setVisibility(0);
            LayoutParams layoutParams = this.f486b.iI.getLayoutParams();
            layoutParams.width = (int) (((fArr[2] - fArr[0]) * ((float) this.f486b.f234ili11.getWidth())) + ((float) a.a.a.a.b.a.a(10.0f)));
            layoutParams.height = (int) (((fArr[3] - fArr[1]) * ((float) this.f486b.f234ili11.getHeight())) + ((float) a.a.a.a.b.a.a(10.0f)));
            this.f486b.iI.setLayoutParams(layoutParams);
            VideoPlayerView videoPlayerView2 = this.f486b;
            videoPlayerView2.iI.setX((this.f486b.f234ili11.getX() + (fArr[0] * ((float) videoPlayerView2.f234ili11.getWidth()))) - ((float) a.a.a.a.b.a.a(5.0f)));
            VideoPlayerView videoPlayerView3 = this.f486b;
            videoPlayerView3.iI.setY((this.f486b.f234ili11.getY() + (fArr[1] * ((float) videoPlayerView3.f234ili11.getHeight()))) - ((float) a.a.a.a.b.a.a(5.0f)));
        }
    }

    public final void a() {
        VideoPlayerView videoPlayerView = this.f486b;
        if (videoPlayerView.f2511) {
            if (videoPlayerView.f217IIi >= 0) {
                videoPlayerView.f217IIi = -2;
            }
            this.f486b.f2511 = false;
        }
    }
}
