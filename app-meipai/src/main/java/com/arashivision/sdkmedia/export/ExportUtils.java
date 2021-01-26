package com.arashivision.sdkmedia.export;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.a.a.g;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.export.ExportManager;
import com.arashivision.insta360.basemedia.export.task.single.ISingleExportListener;
import com.arashivision.insta360.basemedia.export.task.single.ImageToImageTask;
import com.arashivision.insta360.basemedia.export.task.single.VideoToImageTask;
import com.arashivision.insta360.basemedia.export.task.single.VideoToVideoTask;
import com.arashivision.insta360.basemedia.export.task.single.params.image.IExportImageParams;
import com.arashivision.insta360.basemedia.export.task.single.params.image.SimpleExportImageParams;
import com.arashivision.insta360.basemedia.export.task.single.params.video.SimpleExportVideoParams;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.image.SimpleImageParams;
import com.arashivision.insta360.basemedia.ui.player.video.SimpleVideoParams;
import com.arashivision.insta360.basemedia.util.EventIdUtils;
import com.arashivision.sdkmedia.work.WorkWrapper;
import e.a.a.a.a;
import e.b.c.b.a.b.a.b;
import e.b.e.a.c;
import e.b.e.a.d;

public class ExportUtils {

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public static final MediaLogger f287O8oO888 = MediaLogger.getLogger(ExportUtils.class);

    public enum ExportMode {
        PANORAMA,
        SPHERE
    }

    /* renamed from: com.arashivision.sdkmedia.export.ExportUtils$O8〇oO8〇88 reason: invalid class name */
    public static class O8oO888 implements ISingleExportListener {

        /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
        public final /* synthetic */ Handler f288O8oO888;

        /* renamed from: 〇Ooo reason: contains not printable characters */
        public final /* synthetic */ IExportCallback f289Ooo;

        public O8oO888(Handler handler, IExportCallback iExportCallback) {
            this.f288O8oO888 = handler;
            this.f289Ooo = iExportCallback;
        }

        public void onCancel(int i2) {
            MediaLogger mediaLogger = ExportUtils.f287O8oO888;
            StringBuilder sb = new StringBuilder();
            sb.append("Export cancel. eventId: ");
            sb.append(i2);
            mediaLogger.i(sb.toString());
            Handler handler = this.f288O8oO888;
            IExportCallback iExportCallback = this.f289Ooo;
            iExportCallback.getClass();
            handler.post(new c(iExportCallback));
        }

        public void onComplete(int i2) {
            MediaLogger mediaLogger = ExportUtils.f287O8oO888;
            StringBuilder sb = new StringBuilder();
            sb.append("Export success. eventId: ");
            sb.append(i2);
            mediaLogger.i(sb.toString());
            Handler handler = this.f288O8oO888;
            IExportCallback iExportCallback = this.f289Ooo;
            iExportCallback.getClass();
            handler.post(new d(iExportCallback));
        }

        public void onError(int i2, int i3, String str) {
            MediaLogger mediaLogger = ExportUtils.f287O8oO888;
            StringBuilder a2 = a.a("Export error. eventId: ", i2, ", errorCode: ", i3, ", errorMsg: ");
            a2.append(str);
            mediaLogger.i(a2.toString());
            Handler handler = this.f288O8oO888;
            IExportCallback iExportCallback = this.f289Ooo;
            iExportCallback.getClass();
            handler.post(new e.b.e.a.a(iExportCallback));
        }

        public void onFileSizeChanged(int i2, String str, long j2) {
            MediaLogger mediaLogger = ExportUtils.f287O8oO888;
            StringBuilder sb = new StringBuilder();
            sb.append("Export FileSizeChanged. eventId: ");
            sb.append(i2);
            sb.append(", path: ");
            sb.append(str);
            sb.append(", fileSize: ");
            sb.append(j2);
            mediaLogger.i(sb.toString());
        }

        public /* synthetic */ void onNotify(int i2) {
            b.$default$onNotify(this, i2);
        }

        public void onProgress(int i2, float f2) {
            MediaLogger mediaLogger = ExportUtils.f287O8oO888;
            StringBuilder sb = new StringBuilder();
            sb.append("Exporting. eventId: ");
            sb.append(i2);
            sb.append(", progress: ");
            sb.append(f2);
            mediaLogger.i(sb.toString());
            this.f288O8oO888.post(new e.b.e.a.b(this.f289Ooo, f2));
        }
    }

    /* renamed from: O8〇oO8〇88 reason: contains not printable characters */
    public static ISingleExportListener m56O8oO888(IExportCallback iExportCallback) {
        if (iExportCallback == null) {
            return null;
        }
        return new O8oO888(new Handler(Looper.getMainLooper()), iExportCallback);
    }

    public static int exportImage(WorkWrapper workWrapper, ExportImageParamsBuilder exportImageParamsBuilder, IExportCallback iExportCallback) {
        MediaLogger mediaLogger = f287O8oO888;
        StringBuilder a2 = a.a("Export Image. work: ");
        a2.append(workWrapper.toString());
        a2.append(", param: ");
        a2.append(exportImageParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        g a3 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimpleExportImageParams simpleExportImageParams = new SimpleExportImageParams();
        simpleExportImageParams.setPath(exportImageParamsBuilder.getTargetPath());
        simpleExportImageParams.setWidth(exportImageParamsBuilder.getWidth() >= 0 ? exportImageParamsBuilder.getWidth() : workWrapper.getWidth());
        simpleExportImageParams.setHeight(exportImageParamsBuilder.getHeight() >= 0 ? exportImageParamsBuilder.getHeight() : workWrapper.getHeight());
        simpleExportImageParams.setApplyWatermark(false);
        if (a3.d()) {
            simpleExportImageParams.setRenderModelType(exportImageParamsBuilder.getExportMode() == ExportMode.PANORAMA ? 20 : 1);
        } else {
            simpleExportImageParams.setRenderModelType(exportImageParamsBuilder.getExportMode() == ExportMode.PANORAMA ? 10 : 1);
        }
        simpleExportImageParams.addXmpInfo(IExportImageParams.KEY_XMP_CAPTURE_SOFTWARE, workWrapper.f358O8oO888.getCameraType());
        simpleExportImageParams.addXmpInfo(IExportImageParams.KEY_XMP_STITCHING_SOFTWARE, workWrapper.f358O8oO888.getCameraType());
        if (exportImageParamsBuilder.getFov() <= 0.0f || exportImageParamsBuilder.getDistance() <= 0.0f) {
            simpleExportImageParams.setUseTransform(false);
        } else {
            Transform transform = new Transform();
            transform.setFov(exportImageParamsBuilder.getFov());
            transform.setDistance(exportImageParamsBuilder.getDistance());
            transform.setYaw(exportImageParamsBuilder.getYaw());
            transform.setPitch(exportImageParamsBuilder.getPitch());
            simpleExportImageParams.setTransform(transform);
            simpleExportImageParams.setUseTransform(true);
        }
        SimpleImageParams simpleImageParams = new SimpleImageParams(workWrapper.f358O8oO888);
        simpleImageParams.setCacheWorkThumbnailRootPath(exportImageParamsBuilder.getCacheWorkThumbnailRootPath());
        simpleImageParams.setStabilizerCacheRootPath(exportImageParamsBuilder.getStabilizerCacheRootPath());
        simpleImageParams.setCacheCutSceneImagePath(exportImageParamsBuilder.getCacheCutSceneRootPath());
        if (!exportImageParamsBuilder.isStabEnabled()) {
            simpleImageParams.setStabType(-1);
        }
        simpleImageParams.setDynamicStitch(exportImageParamsBuilder.isDynamicStitch());
        if (!TextUtils.isEmpty(exportImageParamsBuilder.getUrlForExport())) {
            simpleImageParams.setUrlsForPlay(exportImageParamsBuilder.getUrlForExport());
        }
        ImageToImageTask imageToImageTask = new ImageToImageTask(EventIdUtils.getEventId(), simpleImageParams, simpleExportImageParams, m56O8oO888(iExportCallback));
        ExportManager.getInstance().startExport(imageToImageTask);
        return imageToImageTask.getEventId();
    }

    public static int exportVideo(WorkWrapper workWrapper, ExportVideoParamsBuilder exportVideoParamsBuilder, IExportCallback iExportCallback) {
        MediaLogger mediaLogger = f287O8oO888;
        StringBuilder a2 = a.a("Export Video. work: ");
        a2.append(workWrapper.toString());
        a2.append(", param: ");
        a2.append(exportVideoParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        g a3 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimpleExportVideoParams simpleExportVideoParams = new SimpleExportVideoParams();
        simpleExportVideoParams.setPath(exportVideoParamsBuilder.getTargetPath());
        simpleExportVideoParams.setWidth(exportVideoParamsBuilder.getWidth() >= 0 ? exportVideoParamsBuilder.getWidth() : workWrapper.getWidth());
        simpleExportVideoParams.setHeight(exportVideoParamsBuilder.getHeight() >= 0 ? exportVideoParamsBuilder.getHeight() : workWrapper.getHeight());
        simpleExportVideoParams.setBitrate(exportVideoParamsBuilder.getBitrate() >= 0 ? exportVideoParamsBuilder.getBitrate() : workWrapper.getBitrate());
        simpleExportVideoParams.setFps(exportVideoParamsBuilder.getFps() >= 0 ? exportVideoParamsBuilder.getFps() : (int) (workWrapper.getFps() + 0.5d));
        int i2 = 1;
        if (a3.d()) {
            if (exportVideoParamsBuilder.getExportMode() == ExportMode.PANORAMA) {
                i2 = 20;
            }
            simpleExportVideoParams.setRenderModelType(i2);
        } else {
            if (exportVideoParamsBuilder.getExportMode() == ExportMode.PANORAMA) {
                i2 = 10;
            }
            simpleExportVideoParams.setRenderModelType(i2);
        }
        simpleExportVideoParams.setApplyWatermark(false);
        SimpleVideoParams simpleVideoParams = new SimpleVideoParams(workWrapper.f358O8oO888);
        simpleVideoParams.setCacheWorkThumbnailRootPath(exportVideoParamsBuilder.getCacheWorkThumbnailRootPath());
        simpleVideoParams.setCacheCutSceneVideoPath(exportVideoParamsBuilder.getCacheCutSceneRootPath());
        simpleVideoParams.setDynamicStitch(exportVideoParamsBuilder.isDynamicStitch());
        if (!exportVideoParamsBuilder.isStabEnabled()) {
            simpleVideoParams.setStabType(-1);
        }
        VideoToVideoTask videoToVideoTask = new VideoToVideoTask(EventIdUtils.getEventId(), simpleVideoParams, simpleExportVideoParams, m56O8oO888(iExportCallback));
        ExportManager.getInstance().startExport(videoToVideoTask);
        return videoToVideoTask.getEventId();
    }

    public static int exportVideoToImage(WorkWrapper workWrapper, ExportImageParamsBuilder exportImageParamsBuilder, IExportCallback iExportCallback) {
        MediaLogger mediaLogger = f287O8oO888;
        StringBuilder a2 = a.a("Export Video to Image. work: ");
        a2.append(workWrapper.toString());
        a2.append(", param: ");
        a2.append(exportImageParamsBuilder.toString());
        mediaLogger.i(a2.toString());
        g a3 = a.a.a.a.b.a.a(workWrapper.f358O8oO888.getCameraType(), workWrapper.f358O8oO888.getMediaOffset());
        SimpleExportImageParams simpleExportImageParams = new SimpleExportImageParams();
        simpleExportImageParams.setPath(exportImageParamsBuilder.getTargetPath());
        simpleExportImageParams.setWidth(exportImageParamsBuilder.getWidth() >= 0 ? exportImageParamsBuilder.getWidth() : workWrapper.getWidth());
        simpleExportImageParams.setHeight(exportImageParamsBuilder.getHeight() >= 0 ? exportImageParamsBuilder.getHeight() : workWrapper.getHeight());
        simpleExportImageParams.setApplyWatermark(false);
        if (a3.d()) {
            simpleExportImageParams.setRenderModelType(exportImageParamsBuilder.getExportMode() == ExportMode.PANORAMA ? 20 : 1);
        } else {
            simpleExportImageParams.setRenderModelType(exportImageParamsBuilder.getExportMode() == ExportMode.PANORAMA ? 10 : 1);
        }
        simpleExportImageParams.addXmpInfo(IExportImageParams.KEY_XMP_CAPTURE_SOFTWARE, workWrapper.f358O8oO888.getCameraType());
        simpleExportImageParams.addXmpInfo(IExportImageParams.KEY_XMP_STITCHING_SOFTWARE, workWrapper.f358O8oO888.getCameraType());
        if (exportImageParamsBuilder.getFov() <= 0.0f || exportImageParamsBuilder.getDistance() <= 0.0f) {
            simpleExportImageParams.setUseTransform(false);
        } else {
            Transform transform = new Transform();
            transform.setFov(exportImageParamsBuilder.getFov());
            transform.setDistance(exportImageParamsBuilder.getDistance());
            transform.setYaw(exportImageParamsBuilder.getYaw());
            transform.setPitch(exportImageParamsBuilder.getPitch());
            simpleExportImageParams.setTransform(transform);
            simpleExportImageParams.setUseTransform(true);
        }
        SimpleVideoParams simpleVideoParams = new SimpleVideoParams(workWrapper.f358O8oO888);
        simpleVideoParams.setCacheWorkThumbnailRootPath(exportImageParamsBuilder.getCacheWorkThumbnailRootPath());
        simpleVideoParams.setCacheCutSceneVideoPath(exportImageParamsBuilder.getCacheCutSceneRootPath());
        simpleVideoParams.setDynamicStitch(exportImageParamsBuilder.isDynamicStitch());
        if (!exportImageParamsBuilder.isStabEnabled()) {
            simpleVideoParams.setStabType(-1);
        }
        VideoToImageTask videoToImageTask = new VideoToImageTask(EventIdUtils.getEventId(), simpleVideoParams, simpleExportImageParams, m56O8oO888(iExportCallback));
        ExportManager.getInstance().startExport(videoToImageTask);
        return videoToImageTask.getEventId();
    }

    public static void stopExport(int i2) {
        ExportManager.getInstance().stopExport(i2);
    }
}
