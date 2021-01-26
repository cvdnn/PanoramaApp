package com.arashivision.insta360.basemedia.export.task.single;

import a.a.a.a.a.f.e.a;
import a.a.a.a.c.a.c;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.g;
import a.a.a.a.e.a.e.i;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.d;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.l.h;
import com.arashivision.arvbmg.exporter.BMGImageExport;
import com.arashivision.arvbmg.exporter.BMGImageExport.ThumbExportCallback;
import com.arashivision.arvbmg.exporter.DashBoardImage;
import com.arashivision.arvbmg.exporter.ImageExportInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.insta360.basemedia.export.task.single.params.image.IExportImageParams;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import com.arashivision.insta360.basemedia.util.FileUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class VideoToImageTask extends SingleExportTask {
    public static final MediaLogger Lil = MediaLogger.getLogger(VideoToImageTask.class);
    public IExportImageParams ILL;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f12ILl;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public l f13Ll1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public a f14lIiI;

    /* renamed from: 丨il reason: contains not printable characters */
    public IVideoParams f15il;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        public void run() {
            VideoToImageTask.this.stopExport();
        }
    }

    public class ILil implements ThumbExportCallback {
        public p I1I;
        public g IL1Iii;
        public f ILil;

        /* renamed from: I丨L reason: contains not printable characters */
        public i f16IL;

        public ILil() {
            this.IL1Iii = new g(VideoToImageTask.this.f15il);
            f fVar = new f();
            this.ILil = fVar;
            fVar.a((b) VideoToImageTask.this.f15il);
            if (this.ILil.a()) {
                this.ILil.a(new BaseCameraController());
                f fVar2 = this.ILil;
                fVar2.f514c = false;
                fVar2.e();
                p pVar = new p();
                this.I1I = pVar;
                pVar.f562a = VideoToImageTask.this.f15il;
                this.I1I.a((d) VideoToImageTask.this.f15il);
            }
            i iVar = new i();
            this.f16IL = iVar;
            iVar.f524a = VideoToImageTask.this.f15il;
            this.f16IL.a((a.a.a.a.e.a.d) VideoToImageTask.this.f15il, (a.a.a.a.e.a.g.d) null, true);
        }

        public void onDecodeData(ByteBuffer byteBuffer, int i2, int i3) {
        }

        public void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
            Transform transform = VideoToImageTask.this.ILL.isUseTransform() ? VideoToImageTask.this.ILL.getTransform() : this.ILil.a() ? this.I1I.a((double) ((long) d2), true) : null;
            if (transform != null) {
                this.ILil.a(transform);
            }
        }

        public ClipRenderInfo onGetClipRenderInfo(int i2) {
            ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
            VideoToImageTask videoToImageTask = VideoToImageTask.this;
            RenderModelType a2 = videoToImageTask.f13Ll1.a(videoToImageTask.ILL.getRenderModelType());
            clipRenderInfo.setModelType(a2.getType());
            if (this.ILil.a(a2.getType())) {
                clipRenderInfo.setCameraFacing(VideoToImageTask.this.f15il.getCameraFacing());
            }
            if (VideoToImageTask.this.f15il.isRotateEnabled() && VideoToImageTask.this.f15il.getFileType() == FileType.UNPANORAMA) {
                clipRenderInfo.setPlaneRotationDegreee(VideoToImageTask.this.f15il.getRotateDegree());
            }
            VideoToImageTask videoToImageTask2 = VideoToImageTask.this;
            if (videoToImageTask2.f13Ll1.a(videoToImageTask2.f15il.getFileType(), a2.getType())) {
                clipRenderInfo.setColorAdjust(VideoToImageTask.this.f15il.isColorAdjustEnabled());
                if (VideoToImageTask.this.f15il.getBlendAngleRad() >= 0.0f) {
                    clipRenderInfo.setBlendAngleRad(VideoToImageTask.this.f15il.getBlendAngleRad());
                }
            }
            clipRenderInfo.setContentMode(VideoToImageTask.this.f13Ll1.a());
            int i3 = 0;
            clipRenderInfo.setImageLayout(VideoToImageTask.this.f13Ll1.a(false));
            clipRenderInfo.setBaseCameraController(this.ILil.f513b);
            if (VideoToImageTask.this.ILL.isApplyStabilizer()) {
                BMGStabilizer stabilizer = VideoToImageTask.this.f15il.getStabilizer();
                if (stabilizer != null) {
                    clipRenderInfo.setStabilizer(stabilizer);
                    clipRenderInfo.setStabilizingType(VideoToImageTask.this.f15il.getStabilizingType());
                }
            }
            VideoToImageTask videoToImageTask3 = VideoToImageTask.this;
            clipRenderInfo.setDynamicStitchType(videoToImageTask3.f13Ll1.a(videoToImageTask3.f15il.isDynamicStitch(), VideoToImageTask.this.f15il.isColorAdjustEnabled(), VideoToImageTask.this.f15il.isImageFusion(), a2.getType(), VideoToImageTask.this.f15il.getStabilizer(), false));
            if (VideoToImageTask.this.f15il.getConstraint() != null) {
                i3 = VideoToImageTask.this.f15il.getConstraint().getPovMode();
            }
            clipRenderInfo.setPovMode(i3);
            clipRenderInfo.setImageFusion(VideoToImageTask.this.f15il.isImageFusion());
            clipRenderInfo.setOffset(a2.getOffset());
            l lVar = VideoToImageTask.this.f13Ll1;
            clipRenderInfo.setLogoInfo(lVar.b(lVar.f533a.isLogoEnabled()));
            FilterInfo filterInfo = null;
            FilterInfo[] a3 = VideoToImageTask.this.f13Ll1.a(true, (BlendImageInfo) null);
            if (this.IL1Iii.a(VideoToImageTask.this.ILL.isApplyWatermark())) {
                filterInfo = this.IL1Iii.a(VideoToImageTask.this.getExportWidth(), VideoToImageTask.this.getExportHeight(), VideoToImageTask.this.ILL.isApplyWatermark());
            }
            clipRenderInfo.setFilterInfos(a.a.a.a.b.a.a(a3, filterInfo));
            clipRenderInfo.setSphereSlices(100);
            clipRenderInfo.setSphereStacks(50);
            return clipRenderInfo;
        }

        public DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4) {
            return this.f16IL.a((double) ((long) d2), VideoToImageTask.this.getExportWidth(), VideoToImageTask.this.getExportHeight());
        }

        public BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
            return null;
        }
    }

    public VideoToImageTask(int i2, IVideoParams iVideoParams, IExportImageParams iExportImageParams, ISingleExportListener iSingleExportListener) {
        super(i2, iSingleExportListener);
        this.f15il = iVideoParams;
        this.ILL = iExportImageParams;
    }

    public c I1I() {
        Class<VideoToImageTask> cls = VideoToImageTask.class;
        int i2 = 0;
        int a2 = !this.f12ILl ? h.a(this.f15il, cls.getSimpleName(), -31012) : 0;
        if (!this.f12ILl && a2 == 0 && this.ILL.isApplyStabilizer()) {
            a2 = h.a(this.f15il, (a.a.a.a.a.e.a) new a.a.a.a.c.a.d.c(this), cls.getSimpleName(), -31011, -31012);
        }
        if (!this.f12ILl && a2 == 0) {
            this.f15il.updateStabilizerByFrameTimestampInMsForExport();
        }
        if (!this.f12ILl && a2 == 0 && this.f15il.getOptimizationRunnableList() != null) {
            for (a.a.a.a.e.a.g.c run : this.f15il.getOptimizationRunnableList()) {
                a2 = run.run();
                if (a2 != 0) {
                    break;
                }
            }
        }
        if (this.f12ILl) {
            a2 = -31010;
        }
        if (a2 != 0) {
            return a2 == -31010 ? new c(null, new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(1, 0, null)) : new c(null, new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(0, a2, "load extra info failed!"));
        }
        IVideoParams iVideoParams = this.f15il;
        this.f13Ll1 = new l(iVideoParams, iVideoParams);
        String[] urlsForPlay = this.f15il.getUrlsForPlay();
        int exportWidth = getExportWidth();
        int exportHeight = getExportHeight();
        boolean isUseSoftwareDecoder = this.ILL.isUseSoftwareDecoder();
        long[] extraInfoPos = this.f15il.getExtraInfoPos();
        boolean z = !this.f15il.isVideo();
        if (this.ILL.isUseOriginalOutput()) {
            i2 = 2;
        }
        ImageExportInfo imageExportInfo = new ImageExportInfo(urlsForPlay, exportWidth, exportHeight, isUseSoftwareDecoder, false, true, 4, true, true, extraInfoPos, z ? 1 : 0, i2);
        BMGImageExport bMGImageExport = new BMGImageExport(imageExportInfo, new ILil());
        bMGImageExport.setOutputInfo((long) (this.ILL.getExportTimestamp() >= 0 ? (double) this.ILL.getExportTimestamp() : this.f15il.getTrimStart()), this.ILL.getPath(), this.ILL.isAccurateSeek());
        return new c(bMGImageExport, null);
    }

    public void IL1Iii() {
        new IL1Iii();
        a.a.a.a.e.a.a aVar = new a.a.a.a.e.a.a();
        this.f14lIiI = aVar;
        this.f15il.addReference(aVar);
    }

    public void ILil() {
        FileUtils.fullDelete(new File(this.ILL.getPath()));
    }

    public void Ilil() {
        this.f15il.removeReference(this.f14lIiI);
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public void m6IL() {
        a.a.a.a.c.a.b.a(this.ILL.getPath(), this.ILL.getExifInfo());
        if (a.a.a.a.c.a.b.a(this.f15il.getFileType(), this.f13Ll1.a(this.ILL.getRenderModelType()).getType())) {
            a.a.a.a.c.a.b.a(this.ILL.getPath(), this.ILL.getXmpInfo(), getExportWidth(), getExportHeight());
        }
    }

    public int getExportHeight() {
        return a.a.a.a.c.a.b.a(this.f15il, this.ILL.getWidth(), this.ILL.getHeight());
    }

    public int getExportWidth() {
        return a.a.a.a.c.a.b.b(this.f15il, this.ILL.getWidth(), this.ILL.getHeight());
    }

    public int getOriginalMediaHeight() {
        return this.f15il.getHeightOrigin();
    }

    public int getOriginalMediaWidth() {
        return this.f15il.getWidthOrigin();
    }

    public String logInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(this.f15il.getUrlsForPlay()));
        sb.append(" ---> ");
        sb.append(this.ILL.getPath());
        return sb.toString();
    }

    public void stopExport() {
        this.f12ILl = true;
        this.f15il.cancelStabilizer();
        super.stopExport();
    }
}
