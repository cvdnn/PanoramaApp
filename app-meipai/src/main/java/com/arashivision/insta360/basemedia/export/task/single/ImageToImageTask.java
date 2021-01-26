package com.arashivision.insta360.basemedia.export.task.single;

import a.a.a.a.a.f.e.a;
import a.a.a.a.c.a.c;
import a.a.a.a.e.a.e.f;
import a.a.a.a.e.a.e.g;
import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.l;
import a.a.a.a.e.a.e.p;
import a.a.a.a.e.a.l.h;
import com.arashivision.arvbmg.exporter.BMGImageExport;
import com.arashivision.arvbmg.exporter.BMGImageExport.ThumbExportCallback;
import com.arashivision.arvbmg.exporter.DashBoardImage;
import com.arashivision.arvbmg.exporter.ImageExportInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.PlaneVisibleRect;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insta360.basemedia.export.task.single.params.image.IExportImageParams;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.image.IImageParams;
import com.arashivision.insta360.basemedia.util.FileUtils;
import java.io.File;
import java.nio.ByteBuffer;

public class ImageToImageTask extends SingleExportTask {
    public static final MediaLogger Lil = MediaLogger.getLogger(ImageToImageTask.class);
    public IExportImageParams ILL;

    /* renamed from: IL丨丨l reason: contains not printable characters */
    public boolean f2ILl;

    /* renamed from: Ll丨1 reason: contains not printable characters */
    public l f3Ll1;

    /* renamed from: lIi丨I reason: contains not printable characters */
    public a f4lIiI;

    /* renamed from: 丨il reason: contains not printable characters */
    public IImageParams f5il;

    public class IL1Iii implements Runnable {
        public IL1Iii() {
        }

        public void run() {
            ImageToImageTask.this.stopExport();
        }
    }

    public class ILil implements ThumbExportCallback {
        public p I1I;
        public g IL1Iii;
        public f ILil;

        public ILil() {
            this.IL1Iii = new g(ImageToImageTask.this.f5il);
            f fVar = new f();
            this.ILil = fVar;
            fVar.a((b) ImageToImageTask.this.f5il);
            if (this.ILil.a()) {
                this.ILil.a(new BaseCameraController());
                f fVar2 = this.ILil;
                fVar2.f514c = false;
                fVar2.e();
                p pVar = new p();
                this.I1I = pVar;
                pVar.f562a = ImageToImageTask.this.f5il;
            }
        }

        public void onDecodeData(ByteBuffer byteBuffer, int i2, int i3) {
        }

        public void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
            f fVar = this.ILil;
            Transform transform = (fVar == null || !fVar.a() || this.I1I == null) ? null : ImageToImageTask.this.ILL.isUseTransform() ? ImageToImageTask.this.ILL.getTransform() : this.I1I.a();
            if (transform != null) {
                this.ILil.a(transform);
            }
        }

        public ClipRenderInfo onGetClipRenderInfo(int i2) {
            ClipRenderInfo clipRenderInfo = new ClipRenderInfo();
            ImageToImageTask imageToImageTask = ImageToImageTask.this;
            RenderModelType a2 = imageToImageTask.f3Ll1.a(imageToImageTask.ILL.getRenderModelType());
            clipRenderInfo.setModelType(a2.getType());
            if (ImageToImageTask.this.f5il.isRotateEnabled() && ImageToImageTask.this.f5il.getFileType() == FileType.UNPANORAMA) {
                clipRenderInfo.setPlaneRotationDegreee(ImageToImageTask.this.f5il.getRotateDegree());
            }
            ImageToImageTask imageToImageTask2 = ImageToImageTask.this;
            if (imageToImageTask2.f3Ll1.a(imageToImageTask2.f5il.getFileType(), a2.getType())) {
                clipRenderInfo.setColorAdjust(ImageToImageTask.this.f5il.isColorAdjustEnabled());
                if (ImageToImageTask.this.f5il.getBlendAngleRad() >= 0.0f) {
                    clipRenderInfo.setBlendAngleRad(ImageToImageTask.this.f5il.getBlendAngleRad());
                }
            }
            clipRenderInfo.setImageLayout(ImageToImageTask.this.f3Ll1.a(false));
            clipRenderInfo.setBaseCameraController(this.ILil.f513b);
            if (ImageToImageTask.this.ILL.isApplyStabilizer()) {
                BMGStabilizer stabilizer = ImageToImageTask.this.f5il.getStabilizer();
                if (stabilizer != null) {
                    clipRenderInfo.setStabilizer(stabilizer);
                    clipRenderInfo.setStabilizingType(ImageToImageTask.this.f5il.getStabilizingType());
                }
            }
            if (ImageToImageTask.this.f5il.isPowerPanoMode()) {
                clipRenderInfo.setPlaneRotateMatrix(new Quaternionf().rotateYXZ(ImageToImageTask.this.f5il.getPowerPanoRotateYaw(), 0.0f, 0.0f).get(new Matrix4f()));
                PlaneVisibleRect planeVisibleRect = new PlaneVisibleRect();
                planeVisibleRect.mRectLeft = -0.75f;
                planeVisibleRect.mRectRight = 0.75f;
                planeVisibleRect.mRectTop = 0.5f;
                planeVisibleRect.mRectBottom = -0.5f;
                clipRenderInfo.setPlaneVisibleRect(planeVisibleRect);
            }
            ImageToImageTask imageToImageTask3 = ImageToImageTask.this;
            clipRenderInfo.setDynamicStitchType(imageToImageTask3.f3Ll1.a(imageToImageTask3.f5il.isDynamicStitch(), ImageToImageTask.this.f5il.isColorAdjustEnabled(), ImageToImageTask.this.f5il.isImageFusion(), a2.getType(), ImageToImageTask.this.f5il.getStabilizer(), false));
            clipRenderInfo.setImageFusion(ImageToImageTask.this.f5il.isImageFusion());
            clipRenderInfo.setOffset(a2.getOffset());
            l lVar = ImageToImageTask.this.f3Ll1;
            clipRenderInfo.setLogoInfo(lVar.b(lVar.f533a.isLogoEnabled()));
            FilterInfo filterInfo = null;
            FilterInfo[] a3 = ImageToImageTask.this.f3Ll1.a(true, (BlendImageInfo) null);
            if (this.IL1Iii.a(ImageToImageTask.this.ILL.isApplyWatermark())) {
                filterInfo = this.IL1Iii.a(ImageToImageTask.this.getExportWidth(), ImageToImageTask.this.getExportHeight(), ImageToImageTask.this.ILL.isApplyWatermark());
            }
            clipRenderInfo.setFilterInfos(a.a.a.a.b.a.a(a3, filterInfo));
            clipRenderInfo.setSphereSlices(100);
            clipRenderInfo.setSphereStacks(50);
            return clipRenderInfo;
        }

        public DashBoardImage onGetDashboard(int i2, double d2, double d3, double d4) {
            return null;
        }

        public BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
            return null;
        }
    }

    public ImageToImageTask(int i2, IImageParams iImageParams, IExportImageParams iExportImageParams, ISingleExportListener iSingleExportListener) {
        super(i2, iSingleExportListener);
        this.f5il = iImageParams;
        this.ILL = iExportImageParams;
    }

    public c I1I() {
        Class<ImageToImageTask> cls = ImageToImageTask.class;
        int a2 = !this.f2ILl ? h.a(this.f5il, cls.getSimpleName(), -31012) : 0;
        if (!this.f2ILl && a2 == 0 && this.ILL.isApplyStabilizer()) {
            a2 = h.a(this.f5il, (a.a.a.a.a.e.a) new a.a.a.a.c.a.d.b(this), cls.getSimpleName(), -31011, -31012);
        }
        if (!this.f2ILl && a2 == 0 && this.f5il.getOptimizationRunnableList() != null) {
            for (a.a.a.a.e.a.g.c run : this.f5il.getOptimizationRunnableList()) {
                a2 = run.run();
                if (a2 != 0) {
                    break;
                }
            }
        }
        if (this.f2ILl) {
            a2 = -31010;
        }
        if (a2 != 0) {
            return a2 == -31010 ? new c(null, new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(1, 0, null)) : new c(null, new com.arashivision.insta360.basemedia.export.IExportTask.IL1Iii(0, a2, "load extra info failed!"));
        }
        this.f3Ll1 = new l(this.f5il, null);
        ImageExportInfo imageExportInfo = new ImageExportInfo(new String[]{this.f5il.getUrlsForPlay()}, getExportWidth(), getExportHeight(), this.ILL.isUseSoftwareDecoder(), false, true, 4, true, true, new long[]{this.f5il.getExtraInfoPos()}, 1, 0);
        BMGImageExport bMGImageExport = new BMGImageExport(imageExportInfo, new ILil());
        bMGImageExport.setOutputInfo(0, this.ILL.getPath(), this.ILL.isAccurateSeek());
        return new c(bMGImageExport, null);
    }

    public void IL1Iii() {
        new IL1Iii();
        a.a.a.a.e.a.a aVar = new a.a.a.a.e.a.a();
        this.f4lIiI = aVar;
        this.f5il.addReference(aVar);
    }

    public void ILil() {
        FileUtils.fullDelete(new File(this.ILL.getPath()));
    }

    public void Ilil() {
        this.f5il.removeReference(this.f4lIiI);
    }

    /* renamed from: I丨L reason: contains not printable characters */
    public void m4IL() {
        a.a.a.a.c.a.b.a(this.ILL.getPath(), this.ILL.getExifInfo());
        if (a.a.a.a.c.a.b.a(this.f5il.getFileType(), this.f3Ll1.a(this.ILL.getRenderModelType()).getType())) {
            a.a.a.a.c.a.b.a(this.ILL.getPath(), this.ILL.getXmpInfo(), getExportWidth(), getExportHeight());
        }
    }

    public int getExportHeight() {
        return a.a.a.a.c.a.b.a(this.f5il, this.ILL.getWidth(), this.ILL.getHeight());
    }

    public int getExportWidth() {
        return a.a.a.a.c.a.b.b(this.f5il, this.ILL.getWidth(), this.ILL.getHeight());
    }

    public int getOriginalMediaHeight() {
        return this.f5il.getHeightOrigin();
    }

    public int getOriginalMediaWidth() {
        return this.f5il.getWidthOrigin();
    }

    public String logInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5il.getUrlsForPlay());
        sb.append(" ---> ");
        sb.append(this.ILL.getPath());
        return sb.toString();
    }

    public void stopExport() {
        this.f2ILl = true;
        this.f5il.cancelStabilizer();
        super.stopExport();
    }
}
