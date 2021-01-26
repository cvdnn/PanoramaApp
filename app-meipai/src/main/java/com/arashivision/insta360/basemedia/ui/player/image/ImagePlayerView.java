package com.arashivision.insta360.basemedia.ui.player.image;

import a.a.a.a.a.f.e.a;
import a.a.a.a.e.a.b;
import a.a.a.a.e.a.e.d;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.g.c;
import a.a.a.a.e.a.k.e;
import a.a.a.a.e.a.l.h;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.arashivision.arvbmg.previewer.BMGImagePreviewerSource;
import com.arashivision.arvbmg.previewer.BMGImageSessionRender;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.PlaneVisibleRect;
import com.arashivision.arvbmg.render.camera.GestureController;
import com.arashivision.arvbmg.render.camera.GestureController.OnGestureChangeListener;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.ui.GraphicView;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IGestureListener;
import com.arashivision.insta360.basemedia.util.EventIdUtils;
import com.baidubce.auth.NTLMEngineImpl;
import d.p.g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImagePlayerView extends FrameLayout implements g {

    /* renamed from: 丨丨LLlI1 reason: contains not printable characters */
    public static final MediaLogger f96LLlI1 = MediaLogger.getLogger(ImagePlayerView.class);
    public GraphicView I11L;
    public ConcurrentLinkedQueue<Runnable> I11li1;
    public a.a.a.a.e.a.e.g I1I;
    public IImageParams IL1Iii;
    public float ILL;
    public IPlayImageParams ILil;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public int f97ILl;
    public f Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public l f98IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public GestureController f99IiL;

    /* renamed from: L11丨丨丨1 reason: contains not printable characters */
    public e f100L111 = new e(new IL());
    public IGestureListener LL1IL;
    public volatile int Lil;
    public int LlLI1;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public float f101Ll1;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public HeadTrackerController f102L11I;

    /* renamed from: L丨lLLL reason: contains not printable characters */
    public TextView f103LlLLL;
    public long iIi1;
    public boolean iIlLiL;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public d f104iILLL1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public ValueAnimator f105lIiI;

    /* renamed from: lI丨II reason: contains not printable characters */
    public IBasePlayerViewListener f106lIII;

    /* renamed from: lI丨lii reason: contains not printable characters */
    public boolean f107lIlii;
    public View llliI;

    /* renamed from: ll丨L1ii reason: contains not printable characters */
    public boolean f108llL1ii;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public p f109lLi1LL;

    /* renamed from: 丨il reason: contains not printable characters */
    public boolean f110il;

    /* renamed from: 丨lL reason: contains not printable characters */
    public d.p.e f111lL;

    /* renamed from: 丨l丨 reason: contains not printable characters */
    public BMGImageSessionRender f112l;

    /* renamed from: 丨丨丨1丨 reason: contains not printable characters */
    public a f1131;

    public class I1I implements OnGestureChangeListener {
        public I1I() {
        }

        public void onActionUp() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onUp();
            }
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (ImagePlayerView.this.IL1Iii()) {
                ImagePlayerView imagePlayerView = ImagePlayerView.this;
                imagePlayerView.Ilil.a(imagePlayerView.f99IiL);
                double a2 = (double) a.a.a.a.e.a.l.d.a(ImagePlayerView.this.Ilil.f513b.getPitch(), 0.0f);
                ImagePlayerView.this.f110il = a2 <= -1.5707963267948966d || a2 > 1.5707963267948966d;
            }
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                return iGestureListener.onDown(motionEvent);
            }
            return false;
        }

        public void onFlingAnimation() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimation();
            }
        }

        public void onFlingAnimationEnd() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onFlingAnimationEnd();
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onLongPress(motionEvent);
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onScroll();
            }
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                return iGestureListener.onTap(motionEvent);
            }
            return false;
        }

        public void onZoom() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onZoom();
            }
        }

        public void onZoomAnimation() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimation();
            }
        }

        public void onZoomAnimationEnd() {
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onZoomAnimationEnd();
            }
        }
    }

    public class IL1Iii implements b.a {
        public IL1Iii(ImagePlayerView imagePlayerView) {
        }
    }

    public class ILil implements Runnable {
        public final /* synthetic */ int IL1Iii;
        public final /* synthetic */ IImageParams ILil;

        public class IL1Iii implements a.a.a.a.a.e.a {
            public IL1Iii() {
            }

            public void IL1Iii(long j2, long j3) {
                MediaLogger mediaLogger = ImagePlayerView.f96LLlI1;
                StringBuilder sb = new StringBuilder();
                sb.append(ILil.this.ILil.getUrlsForPlay());
                sb.append(" onStabilizerLoadProgress: ");
                sb.append(j2);
                sb.append(" / ");
                sb.append(j3);
                mediaLogger.d(sb.toString());
            }
        }

        public ILil(int i2, IImageParams iImageParams) {
            this.IL1Iii = i2;
            this.ILil = iImageParams;
        }

        public final boolean IL1Iii(int i2) {
            return ImagePlayerView.this.Lil < 0 || i2 != ImagePlayerView.this.Lil;
        }

        public void run() {
            int[] iArr = {0};
            if (!IL1Iii(this.IL1Iii) && iArr[0] == 0) {
                IImageParams iImageParams = this.ILil;
                StringBuilder sb = new StringBuilder();
                sb.append(ILil.class.getSimpleName());
                sb.append(ImagePlayerView.this.f97ILl);
                iArr[0] = h.a(iImageParams, sb.toString(), -10001);
            }
            if (!IL1Iii(this.IL1Iii) && iArr[0] == 0) {
                IImageParams iImageParams2 = this.ILil;
                IL1Iii iL1Iii = new IL1Iii();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ILil.class.getSimpleName());
                sb2.append(ImagePlayerView.this.f97ILl);
                iArr[0] = h.a(iImageParams2, (a.a.a.a.a.e.a) iL1Iii, sb2.toString(), -10000, -10001);
            }
            if (!IL1Iii(this.IL1Iii) && iArr[0] == 0 && this.ILil.getOptimizationRunnableList() != null) {
                for (c run : this.ILil.getOptimizationRunnableList()) {
                    iArr[0] = run.run();
                    if (iArr[0] != 0) {
                        break;
                    }
                }
            }
            new Handler(Looper.getMainLooper()).post(new e.b.c.b.b.a.b.b(this, this.IL1Iii, iArr));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void IL1Iii(int i2, int[] iArr) {
            if (IL1Iii(i2)) {
                ImagePlayerView.f96LLlI1.w("playId is not matched, maybe player is destroyed?");
                ImagePlayerView.this.setLoading(false);
            } else if (iArr[0] != 0) {
                String str = "load info failed!";
                ImagePlayerView.f96LLlI1.e(str);
                ImagePlayerView.this.setLoading(false);
                IBasePlayerViewListener iBasePlayerViewListener = ImagePlayerView.this.f106lIII;
                if (iBasePlayerViewListener != null) {
                    iBasePlayerViewListener.onFail(iArr[0], ImagePlayerView.class.getSimpleName(), str);
                }
            } else {
                ImagePlayerView imagePlayerView = ImagePlayerView.this;
                if (!imagePlayerView.f107lIlii) {
                    ImagePlayerView.ILil(imagePlayerView);
                }
                ImagePlayerView imagePlayerView2 = ImagePlayerView.this;
                if (imagePlayerView2 != null) {
                    ImagePlayerView.f96LLlI1.d("bindResources");
                    imagePlayerView2.LlLI1 = i2;
                    if (imagePlayerView2.IL1Iii()) {
                        imagePlayerView2.Ilil.a(new BaseCameraController());
                        f fVar = imagePlayerView2.Ilil;
                        fVar.f514c = true;
                        imagePlayerView2.f99IiL.setCameraController(fVar.f513b);
                        imagePlayerView2.f99IiL.setFovDistanceCalculateMinMax(imagePlayerView2.IL1Iii.getConstraint().getMinFov(), imagePlayerView2.IL1Iii.getConstraint().getMaxFov(), imagePlayerView2.IL1Iii.getConstraint().getMinDistance(), imagePlayerView2.IL1Iii.getConstraint().getMaxDistance());
                        imagePlayerView2.f99IiL.setFovDistanceConstraint(imagePlayerView2.IL1Iii.getConstraint().getMinFov(), imagePlayerView2.IL1Iii.getConstraint().getMaxFov(), imagePlayerView2.IL1Iii.getConstraint().getMinDistance(), imagePlayerView2.IL1Iii.getConstraint().getMaxDistance());
                        Transform restoreCameraTransform = imagePlayerView2.ILil.getRestoreCameraTransform() != null ? imagePlayerView2.ILil.getRestoreCameraTransform() : imagePlayerView2.f109lLi1LL.a();
                        imagePlayerView2.f99IiL.setFov(restoreCameraTransform.getFov());
                        imagePlayerView2.f99IiL.setDistance(restoreCameraTransform.getDistance());
                        imagePlayerView2.Ilil.a(imagePlayerView2.f99IiL.getFov(), imagePlayerView2.f99IiL.getDistance());
                        imagePlayerView2.Ilil.a(imagePlayerView2.f99IiL.getRotate()[0], imagePlayerView2.f99IiL.getRotate()[1], imagePlayerView2.f110il);
                        imagePlayerView2.Ilil.a(restoreCameraTransform.getYaw(), restoreCameraTransform.getPitch(), restoreCameraTransform.getRoll());
                        imagePlayerView2.Ilil.e();
                    }
                    ImagePlayerView.I1I(ImagePlayerView.this);
                    return;
                }
                throw null;
            }
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView$Ilil reason: case insensitive filesystem */
    public class C0162Ilil implements com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener.IL1Iii {
        public C0162Ilil(ImagePlayerView imagePlayerView) {
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView$I丨L reason: invalid class name */
    public class IL implements e.a {
        public IL() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void IL1Iii(float f2, float f3, ValueAnimator valueAnimator) {
            float f4 = f2 - 1.0f;
            ImagePlayerView.this.I11L.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * f4) + 1.0f);
            ImagePlayerView.this.I11L.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * f4) + 1.0f);
            ImagePlayerView.this.I11L.setX(((Float) valueAnimator.getAnimatedValue()).floatValue() * f3);
        }

        public void IL1Iii() {
            ImagePlayerView.f96LLlI1.d("onActionUp() called");
            if (ImagePlayerView.this.I11L.getScaleX() < 1.0f) {
                ValueAnimator valueAnimator = ImagePlayerView.this.f105lIiI;
                if (valueAnimator != null) {
                    valueAnimator.pause();
                }
                float scaleX = ImagePlayerView.this.I11L.getScaleX();
                float x = ImagePlayerView.this.I11L.getX();
                ImagePlayerView.this.f105lIiI = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                ImagePlayerView.this.f105lIiI.setDuration(200);
                ImagePlayerView.this.f105lIiI.addUpdateListener(new e.b.c.b.b.a.b.c(this, scaleX, x));
                ImagePlayerView.this.f105lIiI.start();
            }
            IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
            if (iGestureListener != null) {
                iGestureListener.onUp();
            }
        }
    }

    /* renamed from: com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView$l丨Li1LL reason: invalid class name */
    public class lLi1LL implements Runnable {

        /* renamed from: com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView$l丨Li1LL$IL1Iii */
        public class IL1Iii implements a.a.a.a.a.e.a {
            public IL1Iii(lLi1LL r1) {
            }

            public void IL1Iii(long j2, long j3) {
            }
        }

        public lLi1LL() {
        }

        public void run() {
            IImageParams iImageParams = ImagePlayerView.this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.resetStabilizer();
                IImageParams iImageParams2 = ImagePlayerView.this.IL1Iii;
                IL1Iii iL1Iii = new IL1Iii(this);
                StringBuilder sb = new StringBuilder();
                sb.append(lLi1LL.class.getSimpleName());
                sb.append(ImagePlayerView.this.f97ILl);
                h.a(iImageParams2, (a.a.a.a.a.e.a) iL1Iii, sb.toString(), -1, -1);
            }
            ImagePlayerView.this.m21iILLL1();
        }
    }

    public ImagePlayerView(Context context) {
        super(context);
        m19IL();
    }

    public ImagePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19IL();
    }

    public ImagePlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m19IL();
    }

    @TargetApi(21)
    public ImagePlayerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        m19IL();
    }

    public static /* synthetic */ void I1I(ImagePlayerView imagePlayerView) {
        if (imagePlayerView.IL1Iii.getTransform() != null) {
            Transform transform = imagePlayerView.IL1Iii.getTransform();
            imagePlayerView.f99IiL.setFov(transform.getFov());
            imagePlayerView.f99IiL.setDistance(transform.getDistance());
            imagePlayerView.Ilil.a(imagePlayerView.f99IiL.getFov(), imagePlayerView.f99IiL.getDistance());
            imagePlayerView.Ilil.a(transform.getYaw(), transform.getPitch(), transform.getRoll());
        }
        imagePlayerView.f112l.rebuildRenderWithSource(imagePlayerView.getSource());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean IL1Iii(View view, MotionEvent motionEvent) {
        if (this.IL1Iii.isPowerPanoMode()) {
            return false;
        }
        this.f99IiL.onUpdate(motionEvent);
        return true;
    }

    public static /* synthetic */ void ILil(ImagePlayerView imagePlayerView) {
        if (imagePlayerView != null) {
            f96LLlI1.d("createResources");
            imagePlayerView.I1I();
            imagePlayerView.ILil();
            Class<ImagePlayerView> cls = ImagePlayerView.class;
            a.a.a.a.e.a.a aVar = new a.a.a.a.e.a.a();
            imagePlayerView.f1131 = aVar;
            imagePlayerView.IL1Iii.addReference(aVar);
            BMGImageSessionRender bMGImageSessionRender = new BMGImageSessionRender(imagePlayerView.getContext().getApplicationContext(), new a.a.a.a.e.a.k.c(imagePlayerView), new a.a.a.a.e.a.k.b(imagePlayerView), new Handler(Looper.getMainLooper()));
            imagePlayerView.f112l = bMGImageSessionRender;
            bMGImageSessionRender.setFps(30.0d);
            imagePlayerView.f112l.bindView(imagePlayerView.I11L);
            GestureController gestureController = new GestureController(imagePlayerView.getContext());
            imagePlayerView.f99IiL = gestureController;
            gestureController.setEnabled(imagePlayerView.isGestureEnabled());
            if (!imagePlayerView.IL1Iii() && (imagePlayerView.isGestureHorizontalEnabled() || imagePlayerView.isGestureVerticalEnabled() || imagePlayerView.isGestureZoomEnabled())) {
                f96LLlI1.e("camera is not supported, but gesture horizontal/vertical/zoom is enabled, ignored!");
            }
            imagePlayerView.f99IiL.setHorizontalEnabled(imagePlayerView.IL1Iii() && imagePlayerView.isGestureHorizontalEnabled());
            imagePlayerView.f99IiL.setVerticalEnabled(imagePlayerView.IL1Iii() && imagePlayerView.isGestureVerticalEnabled());
            imagePlayerView.f99IiL.setZoomEnabled(imagePlayerView.IL1Iii() && imagePlayerView.isGestureZoomEnabled());
            imagePlayerView.f99IiL.setOnGestureChangeListener(imagePlayerView.getOnGestureChangeListener());
            HeadTrackerController headTrackerController = new HeadTrackerController(imagePlayerView.getContext(), 0);
            imagePlayerView.f102L11I = headTrackerController;
            headTrackerController.setAnimationFrequency(0);
            imagePlayerView.f107lIlii = true;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public /* synthetic */ void m17L11I() {
        BMGImageSessionRender bMGImageSessionRender = this.f112l;
        if (bMGImageSessionRender != null) {
            bMGImageSessionRender.onClipRenderInfoChange(getClipRenderInfo());
        }
    }

    private FilterInfo[] getClipFilterInfos() {
        LayoutParams layoutParams = this.I11L.getLayoutParams();
        return IL1Iii(layoutParams != null ? layoutParams.width : this.I11L.getMeasuredWidth(), layoutParams != null ? layoutParams.height : this.I11L.getMeasuredHeight());
    }

    /* access modifiers changed from: private */
    public ClipRenderInfo getClipRenderInfo() {
        ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
        RenderModelType a2 = this.f98IL.a(this.ILil.getRenderModelType());
        clipRenderInfo.setModelType(a2.getType());
        clipRenderInfo.setVRMode(this.IL1Iii.getVRMode());
        if (this.IL1Iii.isRotateEnabled() && this.IL1Iii.getFileType() == FileType.UNPANORAMA) {
            clipRenderInfo.setPlaneRotationDegreee(this.IL1Iii.getRotateDegree());
        }
        if (this.f98IL.a(this.IL1Iii.getFileType(), a2.getType())) {
            clipRenderInfo.setColorAdjust(this.IL1Iii.isColorAdjustEnabled());
            if (this.IL1Iii.getBlendAngleRad() >= 0.0f) {
                clipRenderInfo.setBlendAngleRad(this.IL1Iii.getBlendAngleRad());
            }
        }
        if (this.IL1Iii.isPowerPanoMode()) {
            clipRenderInfo.setPlaneRotateMatrix(new Quaternionf().rotateYXZ(this.IL1Iii.getPowerPanoRotateYaw(), 0.0f, 0.0f).get(new Matrix4f()));
            PlaneVisibleRect planeVisibleRect = new PlaneVisibleRect();
            planeVisibleRect.mRectLeft = -0.75f;
            planeVisibleRect.mRectRight = 0.75f;
            planeVisibleRect.mRectTop = 0.5f;
            planeVisibleRect.mRectBottom = -0.5f;
            clipRenderInfo.setPlaneVisibleRect(planeVisibleRect);
        }
        clipRenderInfo.setImageFusion(this.IL1Iii.isImageFusion());
        clipRenderInfo.setImageLayout(this.f98IL.a(false));
        clipRenderInfo.setBaseCameraController(this.Ilil.f513b);
        BMGStabilizer stabilizer = this.IL1Iii.getStabilizer();
        if (stabilizer != null) {
            clipRenderInfo.setStabilizer(stabilizer);
            clipRenderInfo.setStabilizingType(this.IL1Iii.getStabilizingType());
        }
        clipRenderInfo.setDynamicStitchType(this.f98IL.a(this.IL1Iii.isDynamicStitch(), this.IL1Iii.isColorAdjustEnabled(), this.IL1Iii.isImageFusion(), a2.getType(), this.IL1Iii.getStabilizer(), false));
        clipRenderInfo.setOffset(a2.getOffset());
        clipRenderInfo.setLogoInfo(this.f98IL.b(isLogoEnabled()));
        clipRenderInfo.setFilterInfos(getClipFilterInfos());
        clipRenderInfo.setSphereSlices(100);
        clipRenderInfo.setSphereStacks(50);
        return clipRenderInfo;
    }

    private boolean getDynamicStitch() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.isDynamicStitch();
        }
        return false;
    }

    private int getGraphicViewBackgroundColor() {
        return Color.parseColor("#000000");
    }

    private FrameLayout.LayoutParams getGraphicViewLayoutParams() {
        int[] iArr;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            iArr = a.a.a.a.e.a.l.d.a(iImageParams.getScreenRatio(), this.IL1Iii.isRotateScreenRatioEnabled() && a.a.a.a.e.a.l.d.a(this.IL1Iii.isRotateEnabled(), this.IL1Iii.getRotateDegree()));
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

    private boolean getImageFusion() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.isImageFusion();
        }
        return false;
    }

    private OnGestureChangeListener getOnGestureChangeListener() {
        return new I1I();
    }

    private int getRenderBackgroundColor() {
        return 0;
    }

    private BMGImagePreviewerSource getSource() {
        this.IL1Iii.loadExtraData();
        return new BMGImagePreviewerSource(this.IL1Iii.getUrlsForPlay());
    }

    private void setDynamicStitch(boolean z) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setDynamicStitch(z);
            }
            m21iILLL1();
        }
    }

    private void setImageFusion(boolean z) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setImageFusion(z);
            }
            m21iILLL1();
        }
    }

    /* access modifiers changed from: private */
    public void setLoading(boolean z) {
        MediaLogger mediaLogger = f96LLlI1;
        StringBuilder sb = new StringBuilder();
        sb.append("setLoading ");
        sb.append(z);
        mediaLogger.d(sb.toString());
        this.f108llL1ii = z;
        IBasePlayerViewListener iBasePlayerViewListener = this.f106lIII;
        if (iBasePlayerViewListener != null) {
            iBasePlayerViewListener.onLoadingStatusChanged();
        }
    }

    public final void I1I() {
        GraphicView graphicView = new GraphicView(getContext());
        this.I11L = graphicView;
        graphicView.setBackgroundColor(getGraphicViewBackgroundColor());
        this.I11L.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.I11L.setOnTouchListener(new e.b.c.b.b.a.b.f(this));
        addView(this.I11L, 0);
        if (this.IL1Iii.isPowerPanoMode()) {
            View view = new View(getContext());
            this.llliI = view;
            view.setVisibility(0);
            this.llliI.setBackgroundColor(0);
            this.llliI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.llliI.setOnTouchListener(new e.b.c.b.b.a.b.e(this));
            addView(this.llliI);
        }
        TextView textView = new TextView(getContext());
        this.f103LlLLL = textView;
        textView.setTextSize(10.0f);
        this.f103LlLLL.setTextColor(Color.parseColor("#FFFFFF"));
        this.f103LlLLL.setLayoutParams(new FrameLayout.LayoutParams(a.a.a.a.b.a.a(120.0f), a.a.a.a.b.a.a(200.0f), 19));
        addView(this.f103LlLLL);
    }

    public final boolean IL1Iii() {
        f fVar = this.Ilil;
        return fVar != null && fVar.a();
    }

    public final FilterInfo[] IL1Iii(int i2, int i3) {
        FilterInfo filterInfo = null;
        FilterInfo[] a2 = this.f98IL.a(false, (BlendImageInfo) null);
        if (this.I1I.a(this.ILil.isApplyWatermark())) {
            filterInfo = this.I1I.a(i2, i3, this.ILil.isApplyWatermark());
        }
        return a.a.a.a.b.a.a(a2, filterInfo);
    }

    public final void ILil() {
        GraphicView graphicView = this.I11L;
        if (graphicView != null) {
            graphicView.setLayoutParams(getGraphicViewLayoutParams());
            LayoutParams layoutParams = this.I11L.getLayoutParams();
            BMGImageSessionRender bMGImageSessionRender = this.f112l;
            if (bMGImageSessionRender != null) {
                bMGImageSessionRender.onFilterChanged(IL1Iii(layoutParams.width, layoutParams.height));
            }
        }
    }

    public final boolean Ilil() {
        boolean z = this.Lil >= 0 && this.LlLI1 == this.Lil;
        if (!z) {
            f96LLlI1.w("playId is not matched, maybe player is destroyed?");
        }
        return z;
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public final void m19IL() {
        this.f97ILl = EventIdUtils.getEventId();
        Context context = getContext();
        if (context instanceof b) {
            ((b) context).a(new IL1Iii(this));
        }
        m22lLi1LL();
    }

    /* renamed from: I丨iL reason: contains not printable characters */
    public final void m20IiL() {
        if (IL1Iii() && this.Ilil.f513b != null && !this.IL1Iii.isPowerPanoMode()) {
            float a2 = this.f104iILLL1.a();
            if (a2 >= 0.0f) {
                synchronized (this) {
                    Transform a3 = this.f104iILLL1.a(a2);
                    MediaLogger mediaLogger = f96LLlI1;
                    StringBuilder sb = new StringBuilder();
                    sb.append("animating: ");
                    sb.append(a3.getDistance());
                    mediaLogger.d(sb.toString());
                    this.f99IiL.setFovDistanceConstraint(a3.getFov(), a3.getFov(), a3.getDistance(), a3.getDistance());
                    this.f99IiL.setFov(a3.getFov());
                    this.f99IiL.setDistance(a3.getDistance());
                    this.Ilil.a(this.f99IiL.getFov(), this.f99IiL.getDistance());
                    this.Ilil.a(a3.getYaw(), a3.getPitch(), a3.getRoll());
                    if (a2 >= 1.0f) {
                        Constraint constraint = this.IL1Iii.getConstraint();
                        if (constraint != null) {
                            this.f99IiL.setFovDistanceConstraint(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
                        }
                    }
                }
            } else if (IL1Iii()) {
                this.Ilil.a(this.f99IiL.getFov(), this.f99IiL.getDistance());
                this.Ilil.a(this.f99IiL.getRotate()[0], this.f99IiL.getRotate()[1], this.f110il);
            }
        }
    }

    public void attachSticker(int i2) {
    }

    public void attachStickerByFace(List<Integer> list) {
    }

    public void destroyResources() {
        destroyResources(false);
    }

    public void destroyResources(boolean z) {
        MediaLogger mediaLogger = f96LLlI1;
        StringBuilder a2 = e.a.a.a.a.a("destroyResources, thread name: ");
        a2.append(Thread.currentThread().getName());
        a2.append(", thread id: ");
        a2.append(Thread.currentThread().getId());
        mediaLogger.d(a2.toString());
        if (this.iIi1 >= 0 && Thread.currentThread().getId() == this.iIi1) {
            f96LLlI1.e("destroyResources() called from RenderThread");
        }
        this.LlLI1 = -1;
        synchronized (this) {
            if (this.f112l != null) {
                this.f112l.terminate();
                this.f112l = null;
            }
        }
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            a aVar = this.f1131;
            if (aVar != null) {
                iImageParams.removeReference(aVar);
            }
            this.f1131 = null;
        }
        GraphicView graphicView = this.I11L;
        if (graphicView != null) {
            removeView(graphicView);
            this.I11L.destroy();
            this.I11L = null;
        }
        View view = this.llliI;
        if (view != null) {
            removeView(view);
            this.llliI = null;
        }
        TextView textView = this.f103LlLLL;
        if (textView != null) {
            removeView(textView);
            this.f103LlLLL = null;
        }
        GestureController gestureController = this.f99IiL;
        if (gestureController != null) {
            gestureController.destroy();
            this.f99IiL = null;
        }
        HeadTrackerController headTrackerController = this.f102L11I;
        if (headTrackerController != null) {
            headTrackerController.destroy();
            this.f102L11I = null;
        }
        if (this.I1I != null) {
            this.I1I = null;
        }
        if (this.f98IL != null) {
            this.f98IL = null;
        }
        f fVar = this.Ilil;
        if (fVar != null) {
            fVar.c();
            this.Ilil = null;
        }
        p pVar = this.f109lLi1LL;
        if (pVar != null) {
            pVar.f564c.a();
            pVar.f563b = null;
            pVar.f562a = null;
            this.f109lLi1LL = null;
        }
        if (this.f104iILLL1 != null) {
            this.f104iILLL1 = null;
        }
        IImageParams iImageParams2 = this.IL1Iii;
        if (iImageParams2 != null) {
            iImageParams2.cancelStabilizer();
        }
        m22lLi1LL();
        if (z) {
            this.IL1Iii = null;
            this.ILil = null;
        }
    }

    public int getBeautyFilterLevel() {
        l lVar = this.f98IL;
        if (lVar != null) {
            return lVar.f533a.getBeautyFilterLevel();
        }
        return 0;
    }

    public float getBlendAngleRad() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.getBlendAngleRad();
        }
        return -1.0f;
    }

    public Transform getCameraTransform() {
        f fVar = this.Ilil;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    public double getCurrentStickerAngle() {
        return 0.0d;
    }

    public float getCurrentStickerCenterX() {
        return 0.0f;
    }

    public float getCurrentStickerCenterY() {
        return 0.0f;
    }

    public int getCurrentStickerHeight() {
        return 100;
    }

    public float getCurrentStickerRotation() {
        return 0.0f;
    }

    public int getCurrentStickerWidth() {
        return 100;
    }

    public Pair<Integer, Integer> getGraphSize() {
        return new Pair<>(Integer.valueOf(this.I11L.getWidth()), Integer.valueOf(this.I11L.getHeight()));
    }

    public IImageParams getImageParams() {
        return this.IL1Iii;
    }

    public String getOffset() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.getOffsetForPlay();
        }
        return null;
    }

    public int getStabType() {
        return this.IL1Iii.getStabType();
    }

    public int getStickerNumber() {
        return 0;
    }

    public a.a.a.a.a.g.a getStyleFilter() {
        l lVar = this.f98IL;
        if (lVar != null) {
            return lVar.f533a.getStyleFilter();
        }
        return a.a.a.a.a.g.b.b();
    }

    public float getStyleFilterIntensity() {
        l lVar = this.f98IL;
        if (lVar != null) {
            return lVar.f533a.getStyleFilterIntensity();
        }
        return 1.0f;
    }

    public Transform getViewAngle() {
        if (IL1Iii()) {
            return this.f109lLi1LL.a();
        }
        return null;
    }

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public final void m21iILLL1() {
        this.I11li1.offer(new e.b.c.b.b.a.b.d(this));
    }

    public boolean isColorAdjustEnabled() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.isColorAdjustEnabled();
        }
        return false;
    }

    public boolean isFaceDetecting() {
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

    public boolean isHasCurrentSticker() {
        return false;
    }

    public boolean isHasSticker() {
        return false;
    }

    public boolean isHeadTrackerEnabled() {
        return this.f102L11I.isEnabled();
    }

    public boolean isLoading() {
        return this.f108llL1ii;
    }

    public boolean isLogoEnabled() {
        l lVar = this.f98IL;
        if (lVar != null) {
            return lVar.f533a.isLogoEnabled();
        }
        return false;
    }

    public boolean isPrepared() {
        return this.iIlLiL;
    }

    public boolean isSelfie() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            return iImageParams.isSelfie();
        }
        return false;
    }

    public boolean isStabEnabled() {
        return this.IL1Iii.getStabType() != -1;
    }

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public final void m22lLi1LL() {
        this.Lil = -1;
        this.LlLI1 = -1;
        this.f108llL1ii = false;
        this.iIlLiL = false;
        this.f107lIlii = false;
        this.iIi1 = -1;
        this.f110il = false;
        ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue = this.I11li1;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
            this.I11li1 = null;
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.f107lIlii) {
            ILil();
            measure(MeasureSpec.makeMeasureSpec(i2, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH), MeasureSpec.makeMeasureSpec(i3, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH));
        }
    }

    public void play() {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams == null) {
            f96LLlI1.e("play, but imageParams is null!");
        } else if (this.ILil == null) {
            f96LLlI1.e("play, but playImageParams is null!");
        } else if (this.f107lIlii) {
            f96LLlI1.e("play, but resources already created!");
        } else if (!a.a.a.a.b.a.a(iImageParams.getWidthOrigin(), this.IL1Iii.getHeightOrigin())) {
            f96LLlI1.e("play, but GPU texture not support!");
            IBasePlayerViewListener iBasePlayerViewListener = this.f106lIII;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onFail(-10003, ImagePlayerView.class.getSimpleName(), "GPU texture not support");
            }
        } else if (!isLoading()) {
            setLoading(true);
            this.Lil = EventIdUtils.getEventId();
            IImageParams iImageParams2 = this.IL1Iii;
            int i2 = this.Lil;
            this.I11li1 = new ConcurrentLinkedQueue<>();
            this.I1I = new a.a.a.a.e.a.e.g(this.IL1Iii);
            this.f98IL = new l(this.IL1Iii, null);
            f fVar = new f();
            this.Ilil = fVar;
            fVar.a((a.a.a.a.e.a.e.k.b) this.IL1Iii);
            if (IL1Iii()) {
                p pVar = new p();
                this.f109lLi1LL = pVar;
                pVar.f562a = this.IL1Iii;
            }
            this.f104iILLL1 = new d();
            Thread thread = new Thread(new ILil(i2, iImageParams2));
            thread.setPriority(10);
            thread.start();
        }
    }

    public void removeSticker() {
    }

    public void replaceSticker(int i2) {
    }

    public void resetViewAngle() {
        if (IL1Iii()) {
            Transform viewAngle = getViewAngle();
            if (viewAngle != null) {
                GestureController gestureController = this.f99IiL;
                if (gestureController != null) {
                    gestureController.setFov(viewAngle.getFov());
                    this.f99IiL.setDistance(viewAngle.getDistance());
                }
                f fVar = this.Ilil;
                if (fVar != null) {
                    GestureController gestureController2 = this.f99IiL;
                    if (gestureController2 != null) {
                        fVar.a(gestureController2.getFov(), this.f99IiL.getDistance());
                        this.Ilil.a(viewAngle.getYaw(), viewAngle.getPitch(), viewAngle.getRoll());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        f96LLlI1.w("resetViewAngle, but camera is not supported");
    }

    public void setBasePlayerViewListener(IBasePlayerViewListener iBasePlayerViewListener) {
        this.f106lIII = iBasePlayerViewListener;
        if (iBasePlayerViewListener != null) {
            iBasePlayerViewListener.setCallback(new C0162Ilil(this));
        }
    }

    public void setBeautyFilterLevel(int i2) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setBeautyFilterLevel(i2);
            }
            this.f112l.onFilterChanged(getClipFilterInfos());
        }
    }

    public void setBlendAngleRad(float f2) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setBlendAngleRad(f2);
            }
            m21iILLL1();
        }
    }

    public void setCameraTransform(Transform transform) {
        if (this.Ilil != null && transform != null) {
            this.f99IiL.setFov(transform.getFov());
            this.f99IiL.setDistance(transform.getDistance());
            this.Ilil.a(this.f99IiL.getFov(), this.f99IiL.getDistance());
            this.Ilil.a(transform.getYaw(), transform.getPitch(), transform.getRoll());
        }
    }

    public void setColorAdjustEnabled(boolean z) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setColorAdjustEnabled(z);
            }
            m21iILLL1();
        }
    }

    public void setConstraint(Constraint constraint) {
        MediaLogger mediaLogger;
        String str;
        if (!this.iIlLiL) {
            mediaLogger = f96LLlI1;
            str = "setConstraint, but player is not prepared!";
        } else if (!IL1Iii()) {
            mediaLogger = f96LLlI1;
            str = "setConstraint, but camera is not supported";
        } else {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setConstraint(constraint);
                this.IL1Iii.updateStabilizerByFovAndDistanceIfNeeded();
                this.Ilil.d();
            }
            if (this.ILil.isWithSwitchingAnimation()) {
                this.Ilil.a(this.f99IiL);
                Transform cameraTransform = getCameraTransform();
                synchronized (this) {
                    d dVar = this.f104iILLL1;
                    Transform transform = new Transform(this.Ilil.b().getYaw(), constraint.getDefaultPitch(), constraint.getDefaultDistance(), constraint.getDefaultFov());
                    DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (dVar != null) {
                        dVar.f505a = System.currentTimeMillis();
                        dVar.f506b = cameraTransform;
                        dVar.f507c = transform;
                        dVar.f508d = decelerateInterpolator;
                    } else {
                        throw null;
                    }
                }
            } else {
                this.f99IiL.setFovDistanceCalculateMinMax(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
                this.f99IiL.setFovDistanceConstraint(constraint.getMinFov(), constraint.getMaxFov(), constraint.getMinDistance(), constraint.getMaxDistance());
                p pVar = this.f109lLi1LL;
                a.a.a.a.e.a.e.k.d dVar2 = pVar.f563b;
                if (dVar2 != null) {
                    dVar2.setConstraint(constraint);
                    pVar.f564c.a(pVar.c());
                }
                resetViewAngle();
            }
            return;
        }
        mediaLogger.w(str);
    }

    public void setGestureEnabled(boolean z) {
        IPlayImageParams iPlayImageParams = this.ILil;
        if (iPlayImageParams != null) {
            iPlayImageParams.setGestureEnabled(z);
        }
        GestureController gestureController = this.f99IiL;
        if (gestureController != null) {
            gestureController.setEnabled(z);
        }
    }

    public void setGestureHorizontalEnabled(boolean z) {
        if (!IL1Iii()) {
            f96LLlI1.e("setGestureHorizontalEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayImageParams iPlayImageParams = this.ILil;
        if (iPlayImageParams != null) {
            iPlayImageParams.setGestureHorizontalEnabled(z);
        }
        GestureController gestureController = this.f99IiL;
        if (gestureController != null) {
            gestureController.setHorizontalEnabled(z);
        }
    }

    public void setGestureListener(IGestureListener iGestureListener) {
        this.LL1IL = iGestureListener;
    }

    public void setGestureVerticalEnabled(boolean z) {
        if (!IL1Iii()) {
            f96LLlI1.e("setGestureVerticalEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayImageParams iPlayImageParams = this.ILil;
        if (iPlayImageParams != null) {
            iPlayImageParams.setGestureVerticalEnabled(z);
        }
        GestureController gestureController = this.f99IiL;
        if (gestureController != null) {
            gestureController.setVerticalEnabled(z);
        }
    }

    public void setGestureZoomEnabled(boolean z) {
        if (!IL1Iii()) {
            f96LLlI1.e("setGestureZoomEnabled, but camera is not supported, ignored!");
            return;
        }
        IPlayImageParams iPlayImageParams = this.ILil;
        if (iPlayImageParams != null) {
            iPlayImageParams.setGestureZoomEnabled(z);
        }
        GestureController gestureController = this.f99IiL;
        if (gestureController != null) {
            gestureController.setZoomEnabled(z);
        }
    }

    public void setHeadTrackerEnabled(boolean z) {
        this.f102L11I.setEnabled(z);
    }

    public void setLifecycle(d.p.e eVar) {
        this.f111lL = eVar;
        eVar.a(this);
    }

    public void setLogoAlpha(float f2) {
    }

    public void setLogoAngle(int i2) {
    }

    public void setLogoEnabled(boolean z) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setLogoEnabled(z);
            }
            this.f112l.updateLogo(this.f98IL.b(z));
        }
    }

    public void setLogoRotation(int i2) {
    }

    public void setOffset(String str) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setOffsetForPlay(str);
            }
            m21iILLL1();
        }
    }

    public void setParams(IImageParams iImageParams, IPlayImageParams iPlayImageParams) {
        destroyResources(true);
        this.IL1Iii = iImageParams;
        this.ILil = iPlayImageParams;
    }

    public void setScreenRatio(int[] iArr) {
        IImageParams iImageParams = this.IL1Iii;
        if (iImageParams != null) {
            iImageParams.setScreenRatio(iArr);
            f fVar = this.Ilil;
            if (fVar != null) {
                fVar.e();
            }
            this.IL1Iii.updateStabilizerByFovAndDistanceIfNeeded();
        }
        ILil();
    }

    public void setSelfie(boolean z) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setSelfie(z);
            }
            new Thread(new lLi1LL()).start();
        }
    }

    public void setStabType(int i2) {
        if (this.f112l != null && this.IL1Iii.getStabilizer() != null) {
            this.IL1Iii.setStabType(i2);
            this.IL1Iii.updateStabilizer(i2);
        }
    }

    public void setStickerAngle(int i2) {
    }

    public void setStickerHorizontalMirror() {
    }

    public void setStickerListener(a.a.a.a.e.a.g.a aVar) {
    }

    public void setStickerRotation(int i2) {
    }

    public void setStyleFilter(a.a.a.a.a.g.a aVar) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setStyleFilter(aVar);
            }
            this.f112l.onFilterChanged(getClipFilterInfos());
        }
    }

    public void setStyleFilterIntensity(float f2) {
        if (this.f112l != null) {
            IImageParams iImageParams = this.IL1Iii;
            if (iImageParams != null) {
                iImageParams.setStyleFilterIntensity(f2);
            }
            this.f112l.updateLutStyleFilterIntensity(f2);
        }
    }

    public void tryFaceDetect() {
    }

    public void updateLogo() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean ILil(View view, MotionEvent motionEvent) {
        float f2;
        e eVar = this.f100L111;
        if (eVar != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                eVar.f649h = true;
                eVar.f648g = System.currentTimeMillis();
                eVar.f643b.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                eVar.a(motionEvent);
                IGestureListener iGestureListener = ImagePlayerView.this.LL1IL;
                if (iGestureListener != null) {
                    iGestureListener.onDown(motionEvent);
                }
            } else if (action == 1) {
                eVar.f643b.clear();
                eVar.f645d = false;
                if (eVar.f649h && System.currentTimeMillis() - eVar.f648g < 300) {
                    IGestureListener iGestureListener2 = ImagePlayerView.this.LL1IL;
                    if (iGestureListener2 != null) {
                        iGestureListener2.onTap(motionEvent);
                    }
                }
                ((IL) eVar.f642a).IL1Iii();
            } else if (action != 2) {
                if (action == 5) {
                    eVar.f643b.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                } else if (action == 6) {
                    eVar.f643b.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                }
                eVar.a(motionEvent);
            } else {
                String str = "]";
                if (eVar.f643b.size() == 1) {
                    int findPointerIndex = motionEvent.findPointerIndex(((Integer) eVar.f643b.get(0)).intValue());
                    float x = motionEvent.getX(findPointerIndex) - eVar.f644c[0];
                    float y = motionEvent.getY(findPointerIndex) - eVar.f644c[1];
                    if (eVar.f645d || Math.abs(x) >= 10.0f || Math.abs(y) >= 10.0f) {
                        eVar.f645d = true;
                        eVar.f649h = false;
                        eVar.f644c[0] = motionEvent.getX(findPointerIndex);
                        eVar.f644c[1] = motionEvent.getY(findPointerIndex);
                        IL r12 = (IL) eVar.f642a;
                        if (r12 != null) {
                            MediaLogger mediaLogger = f96LLlI1;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onScroll() called with: distanceX = [");
                            sb.append(x);
                            sb.append("], distanceY = [");
                            sb.append(y);
                            sb.append(str);
                            mediaLogger.d(sb.toString());
                            ImagePlayerView imagePlayerView = ImagePlayerView.this;
                            if (imagePlayerView.f112l != null) {
                                if (x < 0.0f) {
                                    f2 = Math.min(Math.max(-(ImagePlayerView.this.I11L.getX() + (((ImagePlayerView.this.I11L.getScaleX() - 1.0f) * ((float) imagePlayerView.I11L.getWidth())) / 2.0f)), x), 0.0f);
                                } else {
                                    f2 = Math.max(Math.min((((ImagePlayerView.this.I11L.getScaleX() - 1.0f) * ((float) imagePlayerView.I11L.getWidth())) / 2.0f) - ImagePlayerView.this.I11L.getX(), x), 0.0f);
                                }
                                float f3 = x - f2;
                                GraphicView graphicView = ImagePlayerView.this.I11L;
                                graphicView.setX(graphicView.getX() + f2);
                                float width = (float) ((((double) ((((-f3) / ((float) ImagePlayerView.this.I11L.getWidth())) / ImagePlayerView.this.I11L.getScaleX()) * 2.0f)) * 3.141592653589793d) + ((double) ImagePlayerView.this.IL1Iii.getPowerPanoRotateYaw()));
                                ImagePlayerView.this.f112l.onUpdatePlaneSphereRotation(new Quaternionf().rotateYXZ(width, 0.0f, 0.0f).get(new Matrix4f()));
                                ImagePlayerView.this.IL1Iii.setPowerPanoRotateYaw(width);
                            }
                            IGestureListener iGestureListener3 = ImagePlayerView.this.LL1IL;
                            if (iGestureListener3 != null) {
                                iGestureListener3.onScroll();
                            }
                        } else {
                            throw null;
                        }
                    }
                } else if (eVar.f643b.size() == 2) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(((Integer) eVar.f643b.get(0)).intValue());
                    int findPointerIndex3 = motionEvent.findPointerIndex(((Integer) eVar.f643b.get(1)).intValue());
                    float abs = Math.abs(motionEvent.getX(findPointerIndex2) - motionEvent.getX(findPointerIndex3));
                    float abs2 = Math.abs(motionEvent.getY(findPointerIndex2) - motionEvent.getY(findPointerIndex3));
                    if (eVar.f647f || Math.abs(abs - eVar.f646e[0]) >= 10.0f || Math.abs(abs2 - eVar.f646e[1]) >= 10.0f) {
                        if (!eVar.f647f) {
                            eVar.f647f = true;
                            eVar.f649h = false;
                            IL r1 = (IL) eVar.f642a;
                            if (r1 != null) {
                                f96LLlI1.d("onZoomStart() called");
                                ImagePlayerView imagePlayerView2 = ImagePlayerView.this;
                                imagePlayerView2.ILL = imagePlayerView2.I11L.getScaleX();
                                ImagePlayerView imagePlayerView3 = ImagePlayerView.this;
                                imagePlayerView3.f101Ll1 = imagePlayerView3.I11L.getX();
                            } else {
                                throw null;
                            }
                        }
                        e.a aVar = eVar.f642a;
                        float[] fArr = eVar.f646e;
                        float f4 = fArr[0];
                        float f5 = fArr[1];
                        IL r13 = (IL) aVar;
                        if (r13 != null) {
                            MediaLogger mediaLogger2 = f96LLlI1;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("onZoom() called with: downSpaceX = [");
                            sb2.append(f4);
                            sb2.append("], downSpaceY = [");
                            sb2.append(f5);
                            sb2.append("], nowSpaceX = [");
                            sb2.append(abs);
                            sb2.append("], nowSpaceY = [");
                            sb2.append(abs2);
                            sb2.append(str);
                            mediaLogger2.d(sb2.toString());
                            float sqrt = (float) (Math.sqrt((double) ((abs2 * abs2) + (abs * abs))) / Math.sqrt((double) ((f5 * f5) + (f4 * f4))));
                            ImagePlayerView imagePlayerView4 = ImagePlayerView.this;
                            imagePlayerView4.I11L.setScaleX(imagePlayerView4.ILL * sqrt);
                            ImagePlayerView imagePlayerView5 = ImagePlayerView.this;
                            imagePlayerView5.I11L.setScaleY(imagePlayerView5.ILL * sqrt);
                            ImagePlayerView imagePlayerView6 = ImagePlayerView.this;
                            float f6 = imagePlayerView6.ILL;
                            if (f6 != 1.0f) {
                                imagePlayerView6.I11L.setX((((sqrt * f6) - 1.0f) / (f6 - 1.0f)) * imagePlayerView6.f101Ll1);
                            } else {
                                imagePlayerView6.I11L.setX(0.0f);
                            }
                            IGestureListener iGestureListener4 = ImagePlayerView.this.LL1IL;
                            if (iGestureListener4 != null) {
                                iGestureListener4.onZoom();
                            }
                        } else {
                            throw null;
                        }
                    }
                }
            }
            return true;
        }
        throw null;
    }
}
