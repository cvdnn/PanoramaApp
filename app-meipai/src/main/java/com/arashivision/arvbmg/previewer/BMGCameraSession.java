package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.camerapreview.CameraPreviewer;
import com.arashivision.arvbmg.camerapreview.CameraPreviewer.PreviewerCallback;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.onestream.ImageData;
import e.a.a.a.a;

public class BMGCameraSession extends BMGMediaSession {
    public final EglContextGroup eglContextGroup;
    public Options mOptions;
    public long mPreviewDeltaNs;
    public CameraPreviewer previewer;

    public BMGCameraSession(Context context, Options options, EglContextGroup eglContextGroup2, long j2) {
        super(context);
        this.mOptions = options;
        this.eglContextGroup = eglContextGroup2;
        this.mPreviewDeltaNs = j2;
    }

    private final CameraPreviewer createPreviewer() {
        return new CameraPreviewer(this.eglContextGroup, this.mOptions, new PreviewerCallback() {
            public void onFrame(CameraPreviewer cameraPreviewer, VideoSampleGroup videoSampleGroup) {
                String str = BMGConstants.TAG;
                if (videoSampleGroup == null) {
                    Log.e(str, " videoSampleGroup null");
                }
                BMGCameraSession bMGCameraSession = BMGCameraSession.this;
                if (bMGCameraSession.previewer != cameraPreviewer) {
                    Log.e(str, " error camera previewer when onFrame");
                    videoSampleGroup.free();
                    return;
                }
                bMGCameraSession.frameOutput.onFrame(videoSampleGroup);
            }

            public void onNotify(CameraPreviewer cameraPreviewer, int i2, int i3, int i4, String str, String str2) {
                BMGCameraSession bMGCameraSession = BMGCameraSession.this;
                if (i2 == 1) {
                    bMGCameraSession.onFail(i3, str, str2);
                }
            }
        });
    }

    public final void clearPreviewer() {
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.free();
            this.previewer = null;
        }
    }

    public void enableDebug() {
        super.enableDebug();
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.nativeEnableDebug();
        }
    }

    public void putExposure(long j2, double d2) {
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.nativePutExposure(j2, d2);
        } else {
            Log.e(BMGConstants.TAG, "putExposureGyro but previewer null");
        }
    }

    public void putVideo(ImageData imageData) {
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.nativePutVideo2(imageData.data, imageData.flags, imageData.csd, imageData.timestampNs, imageData.width, imageData.height, imageData.fps, imageData.mH265);
        } else {
            Log.e(BMGConstants.TAG, "putVideo2 but previewer null");
        }
    }

    public void setPreviewDeltaNs(long j2) {
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.nativeSetPreviewDeltaNs(j2);
        } else {
            Log.e(BMGConstants.TAG, "setPreviewDeltaNs but previewer null");
        }
    }

    public final void setupPreviewer() {
        if (this.frameOutput != null && this.previewer == null) {
            CameraPreviewer createPreviewer = createPreviewer();
            this.previewer = createPreviewer;
            createPreviewer.prepareAsync();
            this.previewer.nativeSetPreviewDeltaNs(this.mPreviewDeltaNs);
            if (isDebug()) {
                this.previewer.nativeEnableDebug();
            }
        }
    }

    public void putVideo(ImageData imageData, ImageData imageData2) {
        ImageData imageData3 = imageData;
        ImageData imageData4 = imageData2;
        CameraPreviewer cameraPreviewer = this.previewer;
        if (cameraPreviewer != null) {
            cameraPreviewer.nativePutVideo3(imageData3.data, imageData3.flags, imageData3.csd, imageData3.timestampNs, imageData3.width, imageData3.height, imageData3.fps, imageData3.mH265, imageData4.data, imageData4.flags, imageData4.csd, imageData4.timestampNs, imageData4.width, imageData4.height, imageData4.fps, imageData4.mH265);
        } else {
            Log.e(BMGConstants.TAG, "putVideo3 but previewer null");
        }
    }

    public void putVideo(ImageData[] imageDataArr) {
        if (this.previewer == null) {
            StringBuilder a2 = a.a("putVideo but previewer null ");
            a2.append(imageDataArr[0].timestampNs);
            Log.e(BMGConstants.TAG, a2.toString());
        } else if (imageDataArr.length == 2) {
            putVideo(imageDataArr[0], imageDataArr[1]);
        } else {
            putVideo(imageDataArr[0]);
        }
    }
}
