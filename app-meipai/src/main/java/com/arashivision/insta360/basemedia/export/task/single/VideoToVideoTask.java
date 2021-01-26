package com.arashivision.insta360.basemedia.export.task.single;

import a.a.a.a.a.f.e.a;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.g;
import a.a.a.a.e.a.e.h;
import a.a.a.a.e.a.e.i;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.d;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.e.n;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.i.e;
import com.arashivision.arvbmg.exporter.DashBoardImage;
import com.arashivision.arvbmg.exporter.OneRenderExport.RenderExportCallback;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.MultiViewInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo.ImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.util.FileUtils;
import java.io.File;
import java.util.Arrays;

public class VideoToVideoTask extends SingleExportTask {
    public static final MediaLogger LlLI1 = MediaLogger.getLogger(VideoToVideoTask.class);
    public IExportVideoParams ILL;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public a f17ILl;
    public boolean Lil;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public g f18Ll1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public l f19lIiI;

    /* renamed from: 丨il reason: contains not printable characters */
    public IVideoParams f20il;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        public void run() {
            VideoToVideoTask.this.stopExport();
        }
    }

    public class ILil implements RenderExportCallback {
        public i I1I;
        public f IL1Iii;
        public p ILil;
        public h Ilil;

        /* renamed from: I丨L reason: contains not printable characters */
        public n f21IL;

        public ILil() {
            f fVar = new f();
            this.IL1Iii = fVar;
            fVar.a((b) VideoToVideoTask.this.f20il);
            if (this.IL1Iii.a()) {
                this.IL1Iii.a(new BaseCameraController());
                f fVar2 = this.IL1Iii;
                fVar2.f514c = false;
                fVar2.e();
                p pVar = new p();
                this.ILil = pVar;
                pVar.f562a = VideoToVideoTask.this.f20il;
                this.ILil.a((d) VideoToVideoTask.this.f20il);
            }
            i iVar = new i();
            this.I1I = iVar;
            iVar.f524a = VideoToVideoTask.this.f20il;
            this.I1I.a((a.a.a.a.e.a.d) VideoToVideoTask.this.f20il, (a.a.a.a.e.a.g.d) null, true);
            if (VideoToVideoTask.this.ILL.isApplyFlash()) {
                h hVar = new h();
                this.Ilil = hVar;
                hVar.f521a = VideoToVideoTask.this.f20il;
                h hVar2 = this.Ilil;
                e flashEffect = hVar2.f521a.getFlashEffect();
                hVar2.f522b = flashEffect;
                if (flashEffect != null) {
                    flashEffect.a();
                }
            }
            n nVar = new n();
            this.f21IL = nVar;
            nVar.a(VideoToVideoTask.this.f20il, VideoToVideoTask.this.f20il);
            if (this.f21IL.b()) {
                n nVar2 = this.f21IL;
                nVar2.f539d.a(new BaseCameraController());
                nVar2.f539d.e();
            }
        }

        public final FilterInfo[] IL1Iii(boolean z) {
            BlendImageInfo blendImageInfo;
            FilterInfo filterInfo = null;
            if (VideoToVideoTask.this.ILL.isApplyFlash()) {
                blendImageInfo = new BlendImageInfo();
                blendImageInfo.setImageInfo(new ImageInfo());
            } else {
                blendImageInfo = null;
            }
            FilterInfo[] a2 = VideoToVideoTask.this.f19lIiI.a(true, blendImageInfo);
            VideoToVideoTask videoToVideoTask = VideoToVideoTask.this;
            if (videoToVideoTask.f18Ll1.a(videoToVideoTask.ILL.isApplyWatermark()) && !z) {
                VideoToVideoTask videoToVideoTask2 = VideoToVideoTask.this;
                filterInfo = videoToVideoTask2.f18Ll1.a(videoToVideoTask2.getExportWidth(), VideoToVideoTask.this.getExportHeight(), VideoToVideoTask.this.ILL.isApplyWatermark());
            }
            return a.a.a.a.b.a.a(a2, filterInfo);
        }

        public void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9) {
        }

        public void onFrameRender(int i2, double d2, double d3, double d4, double d5, boolean z) {
            float f2;
            f fVar = this.IL1Iii;
            if (fVar != null && fVar.a()) {
                p pVar = this.ILil;
                if (pVar != null) {
                    d dVar = pVar.f563b;
                    if ((dVar == null || dVar.getFileType() == FileType.UNPANORAMA) ? false : true) {
                        double IL1Iii2 = IL1Iii(d3);
                        Transform a2 = this.ILil.a(IL1Iii2, true);
                        if (z) {
                            float fov = a2.getFov();
                            int[] a3 = a.a.a.a.c.a.b.a(VideoToVideoTask.this.getExportWidth(), VideoToVideoTask.this.getExportHeight());
                            boolean a4 = a.a.a.a.e.a.l.d.a(VideoToVideoTask.this.f20il.isRotateEnabled(), VideoToVideoTask.this.f20il.getRotateDegree());
                            int exportWidth = VideoToVideoTask.this.getExportWidth();
                            int i3 = a3[0];
                            int exportHeight = VideoToVideoTask.this.getExportHeight();
                            int i4 = a3[1];
                            float fov2 = a2.getFov();
                            if (a4) {
                                float f3 = (float) exportWidth;
                                f2 = (((((float) i3) * 2.0f) + f3) * 1.0f) / f3;
                            } else {
                                float f4 = (float) exportHeight;
                                f2 = (((((float) i4) * 2.0f) + f4) * 1.0f) / f4;
                            }
                            a2.setFov((float) (Math.atan(Math.tan((double) (fov2 / 2.0f)) * ((double) f2)) * 2.0d));
                            float fov3 = a2.getFov();
                            MediaLogger mediaLogger = VideoToVideoTask.LlLI1;
                            StringBuilder sb = new StringBuilder();
                            sb.append("frame interpolation detected, fov is changed from ");
                            sb.append(fov);
                            sb.append(" to ");
                            sb.append(fov3);
                            mediaLogger.d(sb.toString());
                        }
                        this.IL1Iii.a(a2);
                        if (this.f21IL.a(IL1Iii2)) {
                            this.f21IL.b(IL1Iii2);
                            throw null;
                        }
                    }
                }
            }
        }

        public ClipRenderInfo onGetClipRenderInfo(int i2) {
            ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
            VideoToVideoTask videoToVideoTask = VideoToVideoTask.this;
            RenderModelType a2 = videoToVideoTask.f19lIiI.a(videoToVideoTask.ILL.getRenderModelType());
            clipRenderInfo.setModelType(a2.getType());
            if (this.IL1Iii.a(a2.getType())) {
                clipRenderInfo.setCameraFacing(VideoToVideoTask.this.f20il.getCameraFacing());
            }
            if (VideoToVideoTask.this.f20il.isRotateEnabled() && VideoToVideoTask.this.f20il.getFileType() == FileType.UNPANORAMA) {
                clipRenderInfo.setPlaneRotationDegreee(VideoToVideoTask.this.f20il.getRotateDegree());
            }
            VideoToVideoTask videoToVideoTask2 = VideoToVideoTask.this;
            if (videoToVideoTask2.f19lIiI.a(videoToVideoTask2.f20il.getFileType(), a2.getType())) {
                clipRenderInfo.setColorAdjust(VideoToVideoTask.this.f20il.isColorAdjustEnabled());
                if (VideoToVideoTask.this.f20il.getBlendAngleRad() >= 0.0f) {
                    clipRenderInfo.setBlendAngleRad(VideoToVideoTask.this.f20il.getBlendAngleRad());
                }
            }
            clipRenderInfo.setContentMode(VideoToVideoTask.this.f19lIiI.a());
            clipRenderInfo.setImageLayout(VideoToVideoTask.this.f19lIiI.a(false));
            clipRenderInfo.setBaseCameraController(this.IL1Iii.f513b);
            BMGStabilizer stabilizer = VideoToVideoTask.this.f20il.getStabilizer();
            if (stabilizer != null) {
                clipRenderInfo.setStabilizer(stabilizer);
                clipRenderInfo.setStabilizingType(VideoToVideoTask.this.f20il.getStabilizingType());
            }
            VideoToVideoTask videoToVideoTask3 = VideoToVideoTask.this;
            clipRenderInfo.setDynamicStitchType(videoToVideoTask3.f19lIiI.a(videoToVideoTask3.f20il.isDynamicStitch(), VideoToVideoTask.this.f20il.isColorAdjustEnabled(), VideoToVideoTask.this.f20il.isImageFusion(), a2.getType(), VideoToVideoTask.this.f20il.getStabilizer(), true));
            clipRenderInfo.setPovMode(VideoToVideoTask.this.f20il.getConstraint() != null ? VideoToVideoTask.this.f20il.getConstraint().getPovMode() : 0);
            clipRenderInfo.setImageFusion(VideoToVideoTask.this.f20il.isImageFusion());
            clipRenderInfo.setOffset(a2.getOffset());
            l lVar = VideoToVideoTask.this.f19lIiI;
            clipRenderInfo.setLogoInfo(lVar.b(lVar.f533a.isLogoEnabled()));
            clipRenderInfo.setFilterInfos(IL1Iii(false));
            clipRenderInfo.setMaxMotionBlurNum(a.a.a.a.c.a.b.a(VideoToVideoTask.this.f20il));
            clipRenderInfo.setEnableTimeScaleCopySameFrame(VideoToVideoTask.this.f20il.isSpeedSectionCopySameFrame());
            clipRenderInfo.setSphereSlices(100);
            clipRenderInfo.setSphereStacks(50);
            clipRenderInfo.setEnableSuperNight(VideoToVideoTask.this.f20il.isSuperNight());
            if (VideoToVideoTask.this.f20il.isSuperNight()) {
                clipRenderInfo.setSuperNightNoiseLevel(VideoToVideoTask.this.f20il.getSuperNightDenoiseLevel());
            }
            clipRenderInfo.setEnableDenoise(VideoToVideoTask.this.f20il.isDenoise());
            clipRenderInfo.setDenoiseLevel((float) VideoToVideoTask.this.f20il.getDenoiseLevel());
            clipRenderInfo.setEnableHDR(VideoToVideoTask.this.f20il.isHDREnabled());
            clipRenderInfo.setHdrStrength(VideoToVideoTask.this.f20il.getHDRStrength());
            clipRenderInfo.setHdrLevel(VideoToVideoTask.this.f20il.getHDREffectLevel());
            if (!this.f21IL.b() || VideoToVideoTask.this.ILL.isApplyFlash()) {
                clipRenderInfo.setMultiViewInfo(null);
                return clipRenderInfo;
            }
            MultiViewInfo multiViewInfo = new MultiViewInfo();
            ClipRenderInfo clipRenderInfo2 = new ClipRenderInfo();
            VideoToVideoTask videoToVideoTask4 = VideoToVideoTask.this;
            RenderModelType a3 = videoToVideoTask4.f19lIiI.a(videoToVideoTask4.ILL.getRenderModelType());
            clipRenderInfo2.setModelType(a3.getType());
            if (this.IL1Iii.a(a3.getType())) {
                clipRenderInfo2.setCameraFacing(VideoToVideoTask.this.f20il.getCameraFacing());
            }
            if (VideoToVideoTask.this.f20il.isRotateEnabled() && VideoToVideoTask.this.f20il.getFileType() == FileType.UNPANORAMA) {
                clipRenderInfo2.setPlaneRotationDegreee(VideoToVideoTask.this.f20il.getRotateDegree());
            }
            VideoToVideoTask videoToVideoTask5 = VideoToVideoTask.this;
            if (videoToVideoTask5.f19lIiI.a(videoToVideoTask5.f20il.getFileType(), a3.getType())) {
                clipRenderInfo2.setColorAdjust(VideoToVideoTask.this.f20il.isColorAdjustEnabled());
                if (VideoToVideoTask.this.f20il.getBlendAngleRad() >= 0.0f) {
                    clipRenderInfo2.setBlendAngleRad(VideoToVideoTask.this.f20il.getBlendAngleRad());
                }
            }
            clipRenderInfo2.setContentMode(VideoToVideoTask.this.f19lIiI.a());
            clipRenderInfo2.setImageLayout(VideoToVideoTask.this.f19lIiI.a(false));
            clipRenderInfo2.setBaseCameraController(this.f21IL.f539d.f513b);
            BMGStabilizer stabilizer2 = VideoToVideoTask.this.f20il.getStabilizer();
            if (stabilizer2 != null) {
                clipRenderInfo2.setStabilizer(stabilizer2);
                clipRenderInfo2.setStabilizingType(VideoToVideoTask.this.f20il.getStabilizingType());
            }
            VideoToVideoTask videoToVideoTask6 = VideoToVideoTask.this;
            clipRenderInfo2.setDynamicStitchType(videoToVideoTask6.f19lIiI.a(videoToVideoTask6.f20il.isDynamicStitch(), VideoToVideoTask.this.f20il.isColorAdjustEnabled(), VideoToVideoTask.this.f20il.isImageFusion(), a3.getType(), VideoToVideoTask.this.f20il.getStabilizer(), true));
            clipRenderInfo2.setImageFusion(VideoToVideoTask.this.f20il.isImageFusion());
            clipRenderInfo2.setOffset(a3.getOffset());
            clipRenderInfo2.setFilterInfos(IL1Iii(true));
            clipRenderInfo2.setMaxMotionBlurNum(a.a.a.a.c.a.b.a(VideoToVideoTask.this.f20il));
            clipRenderInfo2.setEnableTimeScaleCopySameFrame(VideoToVideoTask.this.f20il.isSpeedSectionCopySameFrame());
            clipRenderInfo2.setSphereSlices(100);
            clipRenderInfo2.setSphereStacks(50);
            clipRenderInfo2.setEnableSuperNight(VideoToVideoTask.this.f20il.isSuperNight());
            if (VideoToVideoTask.this.f20il.isSuperNight()) {
                clipRenderInfo2.setSuperNightNoiseLevel(VideoToVideoTask.this.f20il.getSuperNightDenoiseLevel());
            }
            clipRenderInfo2.setEnableDenoise(VideoToVideoTask.this.f20il.isDenoise());
            clipRenderInfo2.setDenoiseLevel((float) VideoToVideoTask.this.f20il.getDenoiseLevel());
            clipRenderInfo2.setEnableHDR(VideoToVideoTask.this.f20il.isHDREnabled());
            clipRenderInfo2.setHdrStrength(VideoToVideoTask.this.f20il.getHDRStrength());
            clipRenderInfo2.setHdrLevel(VideoToVideoTask.this.f20il.getHDREffectLevel());
            multiViewInfo.mClipRenderInfo = clipRenderInfo2;
            n nVar = this.f21IL;
            nVar.f536a.getMultiViewConfig().a(nVar.f536a.getScreenRatio());
            throw null;
        }

        public DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4) {
            return this.I1I.a(IL1Iii(d2), VideoToVideoTask.this.getExportWidth(), VideoToVideoTask.this.getExportHeight());
        }

        public LottieSetupInfo onLottieSetup(int i2, int i3, double d2) {
            return null;
        }

        public LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2, double d3, double d4) {
            return null;
        }

        public boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5) {
            return this.f21IL.a(IL1Iii(d2));
        }

        public BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
            if (this.Ilil != null) {
                a.a.a.a.e.a.i.a.b bVar = new a.a.a.a.e.a.i.a.b();
                VideoToVideoTask.this.f20il.getScreenRatio();
                this.IL1Iii.b();
                this.Ilil.a(d4, d2, bVar);
            }
            return null;
        }

        public MultiViewRectInfo onUpdateMultiviewInfo(int i2, double d2, double d3, double d4, double d5) {
            return null;
        }

        public final double IL1Iii(double d2) {
            return p.a(d2, VideoToVideoTask.this.f20il.getTrimStart(), VideoToVideoTask.this.f20il.getTrimEnd());
        }
    }

    public VideoToVideoTask(int i2, IVideoParams iVideoParams, IExportVideoParams iExportVideoParams, ISingleExportListener iSingleExportListener) {
        super(i2, iSingleExportListener);
        this.f20il = iVideoParams;
        this.ILL = iExportVideoParams;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.a.a.c.a.c I1I() {
        /*
            r39 = this;
            r0 = r39
            java.lang.Class<com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask> r1 = com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask.class
            boolean r2 = r0.Lil
            r3 = -31012(0xffffffffffff86dc, float:NaN)
            r4 = 0
            if (r2 != 0) goto L_0x0016
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r2 = r0.f20il
            java.lang.String r5 = r1.getSimpleName()
            int r2 = a.a.a.a.e.a.l.h.a(r2, r5, r3)
            goto L_0x0017
        L_0x0016:
            r2 = r4
        L_0x0017:
            boolean r5 = r0.Lil
            if (r5 != 0) goto L_0x002e
            if (r2 != 0) goto L_0x002e
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r2 = r0.f20il
            a.a.a.a.c.a.d.a r5 = new a.a.a.a.c.a.d.a
            r5.<init>(r0)
            java.lang.String r6 = r1.getSimpleName()
            r7 = -31011(0xffffffffffff86dd, float:NaN)
            int r2 = a.a.a.a.e.a.l.h.a(r2, r5, r6, r7, r3)
        L_0x002e:
            boolean r5 = r0.Lil
            if (r5 != 0) goto L_0x0039
            if (r2 != 0) goto L_0x0039
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r5 = r0.f20il
            r5.updateStabilizerByFrameTimestampInMsForExport()
        L_0x0039:
            boolean r5 = r0.Lil
            if (r5 != 0) goto L_0x0049
            if (r2 != 0) goto L_0x0049
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r2 = r0.f20il
            java.lang.String r5 = r1.getSimpleName()
            int r2 = a.a.a.a.e.a.l.h.d(r2, r5, r3)
        L_0x0049:
            boolean r5 = r0.Lil
            if (r5 != 0) goto L_0x0059
            if (r2 != 0) goto L_0x0059
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r2 = r0.f20il
            java.lang.String r5 = r1.getSimpleName()
            int r2 = a.a.a.a.e.a.l.h.b(r2, r5, r3)
        L_0x0059:
            boolean r5 = r0.Lil
            if (r5 != 0) goto L_0x0069
            if (r2 != 0) goto L_0x0069
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r2 = r0.f20il
            java.lang.String r1 = r1.getSimpleName()
            int r2 = a.a.a.a.e.a.l.h.c(r2, r1, r3)
        L_0x0069:
            boolean r1 = r0.Lil
            if (r1 != 0) goto L_0x0093
            if (r2 != 0) goto L_0x0093
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r1 = r0.f20il
            java.util.List r1 = r1.getOptimizationRunnableList()
            if (r1 == 0) goto L_0x0093
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r1 = r0.f20il
            java.util.List r1 = r1.getOptimizationRunnableList()
            java.util.Iterator r1 = r1.iterator()
        L_0x0081:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0093
            java.lang.Object r2 = r1.next()
            a.a.a.a.e.a.g.c r2 = (a.a.a.a.e.a.g.c) r2
            int r2 = r2.run()
            if (r2 == 0) goto L_0x0081
        L_0x0093:
            boolean r1 = r0.Lil
            r3 = -31010(0xffffffffffff86de, float:NaN)
            if (r1 == 0) goto L_0x009a
            r2 = r3
        L_0x009a:
            r1 = 0
            r5 = 1
            if (r2 == 0) goto L_0x00b8
            if (r2 != r3) goto L_0x00ab
            a.a.a.a.c.a.c r2 = new a.a.a.a.c.a.c
            com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii r3 = new com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii
            r3.<init>(r5, r4, r1)
            r2.<init>(r1, r3)
            return r2
        L_0x00ab:
            a.a.a.a.c.a.c r3 = new a.a.a.a.c.a.c
            com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii r5 = new com.arashivision.insta360.basemedia.export.IExportTask$IL1Iii
            java.lang.String r6 = "load extra info failed!"
            r5.<init>(r4, r2, r6)
            r3.<init>(r1, r5)
            return r3
        L_0x00b8:
            a.a.a.a.e.a.e.g r2 = new a.a.a.a.e.a.e.g
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r3 = r0.f20il
            r2.<init>(r3)
            r0.f18Ll1 = r2
            a.a.a.a.e.a.e.l r2 = new a.a.a.a.e.a.e.l
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r3 = r0.f20il
            r2.<init>(r3, r3)
            r0.f19lIiI = r2
            com.arashivision.arvbmg.exporter.OneRenderExport r2 = new com.arashivision.arvbmg.exporter.OneRenderExport
            com.arashivision.arvbmg.exporter.ExporterClip[] r3 = new com.arashivision.arvbmg.exporter.ExporterClip[r5]
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            java.lang.String[] r7 = r6.getUrlsForPlay()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            boolean r6 = r6.isVideo()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r8 = r0.f20il
            double r16 = r8.getDurationInMs()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r8 = r0.f20il
            boolean r20 = r8.hasAudio()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r8 = r0.f20il
            float r8 = r8.getSourceVolume()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            java.util.List r18 = r9.getSpeedSectionList()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            double r21 = r9.getSpeedFactor()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            double r23 = r9.getTrimStart()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            double r25 = r9.getTrimEnd()
            r27 = 0
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            long[] r29 = r9.getExtraInfoPos()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r9 = r0.f20il
            int r30 = r9.getFrameCount()
            r19 = 1
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r9 = r0.ILL
            int r9 = r9.getFps()
            float r15 = (float) r9
            r31 = 1
            r9 = r16
            r11 = r23
            r13 = r25
            r32 = r15
            r15 = r31
            double[] r31 = a.a.a.a.b.a.a(r9, r11, r13, r15)
            if (r6 == 0) goto L_0x0181
            a.a.a.a.e.a.l.c r6 = new a.a.a.a.e.a.l.c
            r6.<init>()
            r9 = r16
            r11 = r18
            r12 = r21
            r14 = r23
            r16 = r25
            r18 = r19
            r19 = r6
            java.util.List r6 = a.a.a.a.b.a.a(r9, r11, r12, r14, r16, r18, r19)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r9 = r6.size()
            com.arashivision.arvbmg.exporter.ExporterClip$ExporterTimeScale[] r12 = new com.arashivision.arvbmg.exporter.ExporterClip.ExporterTimeScale[r9]
            r9 = r4
        L_0x014d:
            int r10 = r6.size()
            if (r9 >= r10) goto L_0x015e
            java.lang.Object r10 = r6.get(r9)
            com.arashivision.arvbmg.exporter.ExporterClip$ExporterTimeScale r10 = (com.arashivision.arvbmg.exporter.ExporterClip.ExporterTimeScale) r10
            r12[r9] = r10
            int r9 = r9 + 1
            goto L_0x014d
        L_0x015e:
            r9 = r31[r4]
            long r9 = (long) r9
            r6 = r8
            r8 = r9
            r10 = r31[r5]
            long r10 = (long) r10
            r15 = r20 ^ 1
            r18 = r29[r4]
            r16 = 1
            r20 = 0
            r21 = 0
            r22 = 0
            r13 = r27
            r17 = r30
            r23 = r32
            com.arashivision.arvbmg.exporter.ExporterClip r7 = com.arashivision.arvbmg.exporter.ExporterClip.createExporterVideoClip(r7, r8, r10, r12, r13, r15, r16, r17, r18, r20, r21, r22, r23)
            double r8 = (double) r6
            r7.setAudioVolume(r8)
            goto L_0x018e
        L_0x0181:
            r10 = r7[r4]
            r6 = r31[r5]
            long r11 = (long) r6
            r13 = 0
            r15 = r30
            com.arashivision.arvbmg.exporter.ExporterClip r7 = com.arashivision.arvbmg.exporter.ExporterClip.createExporterImageClip(r10, r11, r13, r15)
        L_0x018e:
            r3[r4] = r7
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            boolean r6 = r6.containsBgmData()
            if (r6 == 0) goto L_0x01cf
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r1 = r0.f20il
            java.lang.String r7 = r1.getBgmUrl()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r1 = r0.f20il
            float r1 = r1.getBgmWeight()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            long r11 = r6.getBgmOffset()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            long[] r6 = r6.getBgmRange()
            r10 = 1
            r8 = r6[r4]
            r13 = 0
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x01bb
            r15 = r13
            goto L_0x01bc
        L_0x01bb:
            r15 = r8
        L_0x01bc:
            r8 = r6[r5]
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 != 0) goto L_0x01c3
            goto L_0x01c7
        L_0x01c3:
            r5 = r6[r5]
            long r5 = r5 - r15
            r13 = r5
        L_0x01c7:
            com.arashivision.arvbmg.exporter.ExporterAudioClip r5 = new com.arashivision.arvbmg.exporter.ExporterAudioClip
            double r8 = (double) r1
            r6 = r5
            r6.<init>(r7, r8, r10, r11, r13, r15)
            r1 = r5
        L_0x01cf:
            com.arashivision.arvbmg.exporter.BMGExportInfo r15 = new com.arashivision.arvbmg.exporter.BMGExportInfo
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            java.lang.String r6 = r5.getPath()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r5 = r0.f20il
            java.lang.String r7 = r5.getCacheCutSceneVideoPath()
            int r8 = r39.getExportWidth()
            int r9 = r39.getExportHeight()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            int r10 = r5.getBitrate()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            int r11 = r5.getFps()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            boolean r12 = r5.isTurnBack()
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r5 = r0.f20il
            com.arashivision.insta360.basemedia.model.FileType r5 = r5.getFileType()
            a.a.a.a.e.a.e.l r13 = r0.f19lIiI
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r14 = r0.ILL
            int r14 = r14.getRenderModelType()
            com.arashivision.graphicpath.render.rendermodel.RenderModelType r13 = r13.a(r14)
            int r13 = r13.getType()
            boolean r13 = a.a.a.a.c.a.b.a(r5, r13)
            r14 = 0
            r16 = 0
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            int r17 = r5.getMp4Type()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            java.lang.String r18 = r5.getMetaDataMake()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            java.lang.String r19 = r5.getMetaDataModel()
            r20 = 0
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            int r21 = r5.getPriorityFpsNum()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            int r22 = r5.getPriorityFpsDen()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            boolean r23 = r5.isUseSoftwareDecoder()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            boolean r25 = r5.isUseSoftwareEncoder()
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            boolean r5 = r5.isUseSoftwareEncoder()
            if (r5 == 0) goto L_0x024b
            java.lang.String r5 = "baseline"
            goto L_0x024d
        L_0x024b:
            java.lang.String r5 = ""
        L_0x024d:
            r37 = r5
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r5 = r0.ILL
            float r34 = r5.getStarrySkyK()
            r27 = 1
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 1
            r32 = 1
            r33 = 0
            r35 = -1
            r36 = 0
            java.lang.String r24 = "veryfast"
            java.lang.String r26 = "zerolatency"
            r5 = r15
            r38 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r23 = r25
            r25 = r37
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r5 = r0.f20il
            java.util.List r5 = r5.getSpeedSectionList()
            if (r5 == 0) goto L_0x02ab
            java.util.Iterator r5 = r5.iterator()
        L_0x0291:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02ab
            java.lang.Object r6 = r5.next()
            a.a.a.a.e.a.i.g r6 = (a.a.a.a.e.a.i.g) r6
            double r6 = r6.f612c
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r8 = r0.f20il
            double r8 = r8.getSpeedFactor()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0291
            r5 = 1
            goto L_0x02ac
        L_0x02ab:
            r5 = r4
        L_0x02ac:
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            com.arashivision.insta360.basemedia.model.FileType r6 = r6.getFileType()
            com.arashivision.insta360.basemedia.model.FileType r7 = com.arashivision.insta360.basemedia.model.FileType.VR360
            r8 = 3
            r9 = 2
            if (r6 == r7) goto L_0x02c6
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            com.arashivision.insta360.basemedia.model.FileType r6 = r6.getFileType()
            com.arashivision.insta360.basemedia.model.FileType r7 = com.arashivision.insta360.basemedia.model.FileType.FISH_EYE
            if (r6 != r7) goto L_0x02c3
            goto L_0x02c6
        L_0x02c3:
            r13 = r38
            goto L_0x0315
        L_0x02c6:
            a.a.a.a.e.a.e.l r6 = r0.f19lIiI
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r7 = r0.ILL
            int r7 = r7.getRenderModelType()
            com.arashivision.graphicpath.render.rendermodel.RenderModelType r6 = r6.a(r7)
            int r6 = r6.getType()
            if (r6 == r9) goto L_0x02e0
            if (r6 == r8) goto L_0x02e0
            r7 = 4
            if (r6 != r7) goto L_0x02de
            goto L_0x02e0
        L_0x02de:
            r6 = r4
            goto L_0x02e1
        L_0x02e0:
            r6 = 1
        L_0x02e1:
            if (r6 == 0) goto L_0x02c3
            if (r5 == 0) goto L_0x02c3
            int r5 = r39.getExportWidth()
            int r6 = r39.getExportHeight()
            int[] r5 = a.a.a.a.c.a.b.a(r5, r6)
            com.arashivision.insta360.basemedia.log.MediaLogger r6 = LlLI1
            java.lang.String r7 = "setEdgeInfo: "
            java.lang.StringBuilder r7 = e.a.a.a.a.a(r7)
            java.lang.String r10 = java.util.Arrays.toString(r5)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r6.d(r7)
            r6 = r5[r4]
            r7 = 1
            r7 = r5[r7]
            r10 = r5[r9]
            r5 = r5[r8]
            r13 = r38
            r13.setEdgeInfo(r6, r7, r10, r5)
        L_0x0315:
            a.a.a.a.e.a.e.g r5 = r0.f18Ll1
            com.arashivision.insta360.basemedia.export.task.single.params.video.IExportVideoParams r6 = r0.ILL
            boolean r6 = r6.isApplyWatermark()
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto L_0x0368
            com.arashivision.graphicpath.render.source.ImageAsset r5 = new com.arashivision.graphicpath.render.source.ImageAsset
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r6 = r0.f20il
            java.lang.String r6 = r6.getWatermarkResourcesPath()
            r5.<init>(r6)
            r6 = 256(0x100, float:3.59E-43)
            r5.parse(r6)
            a.a.a.a.e.a.e.g r14 = r0.f18Ll1
            int r15 = r39.getExportWidth()
            int r16 = r39.getExportHeight()
            int r17 = r5.getWidth()
            int r18 = r5.getHeight()
            r19 = 1
            float[] r5 = r14.a(r15, r16, r17, r18, r19)
            r6 = r5[r4]
            int r6 = (int) r6
            r7 = 1
            r7 = r5[r7]
            int r7 = (int) r7
            r9 = r5[r9]
            int r9 = (int) r9
            r5 = r5[r8]
            int r10 = (int) r5
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r5 = r0.f20il
            java.lang.String r11 = r5.getWatermarkResourcesPath()
            r14 = 0
            r5 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r14
            r5.setWaterMark(r6, r7, r8, r9, r10, r11)
        L_0x0368:
            com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask$ILil r5 = new com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask$ILil
            r5.<init>()
            r2.<init>(r3, r1, r13, r5)
            com.arashivision.insta360.basemedia.ui.player.video.IVideoParams r1 = r0.f20il
            java.util.List r1 = r1.getAudioEffectList()
            if (r1 == 0) goto L_0x0381
            int r3 = r1.size()
            if (r3 > 0) goto L_0x0381
            r1 = 0
            r3 = 0
            goto L_0x039c
        L_0x0381:
            int r3 = r1.size()
            com.arashivision.arvbmg.exporter.ExporterAudioClip[] r3 = new com.arashivision.arvbmg.exporter.ExporterAudioClip[r3]
            int r5 = r1.size()
            if (r5 <= 0) goto L_0x039b
            java.lang.Object r1 = r1.get(r4)
            a.a.a.a.e.a.i.b r1 = (a.a.a.a.e.a.i.b) r1
            com.arashivision.arvbmg.exporter.ExporterAudioClip r2 = new com.arashivision.arvbmg.exporter.ExporterAudioClip
            if (r1 == 0) goto L_0x0399
            r1 = 0
            throw r1
        L_0x0399:
            r1 = 0
            throw r1
        L_0x039b:
            r1 = 0
        L_0x039c:
            r2.setAudioEffectClips(r3)
            a.a.a.a.c.a.c r3 = new a.a.a.a.c.a.c
            r3.<init>(r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask.I1I():a.a.a.a.c.a.c");
    }

    public void IL1Iii() {
        new IL1Iii();
        a.a.a.a.e.a.a aVar = new a.a.a.a.e.a.a();
        this.f17ILl = aVar;
        this.f20il.addReference(aVar);
    }

    public void ILil() {
        FileUtils.fullDelete(new File(this.ILL.getPath()));
    }

    public void Ilil() {
        this.f20il.removeReference(this.f17ILl);
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public void m7IL() {
    }

    public int getExportHeight() {
        int a2 = a.a.a.a.c.a.b.a(this.f20il, this.ILL.getWidth(), this.ILL.getHeight());
        int height = this.f20il.getHeight();
        if (height > 0 && height == a2) {
            return a2;
        }
        int i2 = (a2 / 4) * 4;
        if (a2 != i2) {
            MediaLogger mediaLogger = a.a.a.a.c.a.b.f430a;
            StringBuilder sb = new StringBuilder();
            sb.append("export height is not 4x, formatted from ");
            sb.append(a2);
            sb.append(" to ");
            sb.append(i2);
            mediaLogger.e(sb.toString());
        }
        return i2;
    }

    public int getExportWidth() {
        int b2 = a.a.a.a.c.a.b.b(this.f20il, this.ILL.getWidth(), this.ILL.getHeight());
        int width = this.f20il.getWidth();
        if (width > 0 && width == b2) {
            return b2;
        }
        int i2 = (b2 / 4) * 4;
        if (b2 != i2) {
            MediaLogger mediaLogger = a.a.a.a.c.a.b.f430a;
            StringBuilder sb = new StringBuilder();
            sb.append("export width is not 4x, formatted from ");
            sb.append(b2);
            sb.append(" to ");
            sb.append(i2);
            mediaLogger.e(sb.toString());
        }
        return i2;
    }

    public int getOriginalMediaHeight() {
        return this.f20il.getHeightOrigin();
    }

    public int getOriginalMediaWidth() {
        return this.f20il.getWidthOrigin();
    }

    public String logInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(this.f20il.getUrlsForPlay()));
        sb.append(" ---> ");
        sb.append(this.ILL.getPath());
        return sb.toString();
    }

    public com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii startExport() {
        com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii startExport = super.startExport();
        if (startExport.ILil == 2 || !a.a.a.a.c.a.b.a(startExport.Ilil)) {
            return startExport;
        }
        ILil();
        LlLI1.w("open hardware encoder failed, use software encoder instead!");
        this.ILL.setUseSoftwareEncoder(true);
        LlLI1.w("retry export");
        return startExport();
    }

    public void stopExport() {
        this.Lil = true;
        this.f20il.cancelStabilizer();
        super.stopExport();
    }
}
