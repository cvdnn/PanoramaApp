package com.arashivision.arvbmg.previewer;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.insmedia.previewer2.PlayPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.MediaPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.Notifier;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.SrcPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.VideoRender;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;

public class BMGPreviewer {
    public boolean isPrepareActioned;
    public BMGPreviewerCallback mCallback;
    public Previewer2 mPreviewer2;

    public interface BMGPreviewerCallback {
        void onFrame(BMGPreviewer bMGPreviewer, VideoSampleGroup videoSampleGroup);

        void onNotify(BMGPreviewer bMGPreviewer, int i2, int i3, int i4, String str, String str2);
    }

    public static class NotifyType {
        public static final int COMPLETE = 2;
        public static final int FAIL = 4;
        public static final int PREPARE = 1;
        public static final int REBUFFER = 5;
        public static final int SEEK = 3;
        public static final int VIDEO_DECODER_HWACCEL_REPORT = 6;
    }

    public BMGPreviewer(EglContextGroup eglContextGroup) {
        this.mPreviewer2 = new Previewer2(eglContextGroup);
        emptyCallbacks();
        setupCallbacks();
    }

    private void emptyCallbacks() {
        this.mCallback = new BMGPreviewerCallback() {
            public void onFrame(BMGPreviewer bMGPreviewer, VideoSampleGroup videoSampleGroup) {
                Log.e(BMGConstants.TAG, " empty onFrame");
                videoSampleGroup.free();
            }

            public void onNotify(BMGPreviewer bMGPreviewer, int i2, int i3, int i4, String str, String str2) {
                Log.e(BMGConstants.TAG, " empty onNotify");
            }
        };
    }

    private void setupCallbacks() {
        this.mPreviewer2.setNotifier(new Notifier() {
            public void onNotify(Previewer2 previewer2, int i2, int i3, int i4, String str, String str2) {
                if (previewer2 != BMGPreviewer.this.mPreviewer2) {
                    Log.e(BMGConstants.TAG, "previewer2 onNotify mismatch");
                }
                BMGPreviewer.this.mCallback.onNotify(BMGPreviewer.this, i2, i3, i4, str, str2);
            }
        });
        this.mPreviewer2.setVideoRender(new VideoRender() {
            public void onFrame(Previewer2 previewer2, VideoSampleGroup videoSampleGroup) {
                if (previewer2 != BMGPreviewer.this.mPreviewer2) {
                    Log.e(BMGConstants.TAG, "previewer2 onFrame mismatch");
                }
                BMGPreviewer.this.mCallback.onFrame(BMGPreviewer.this, videoSampleGroup);
            }
        });
    }

    public void free() {
        Previewer2 previewer2 = this.mPreviewer2;
        if (previewer2 != null) {
            previewer2.free();
            this.mPreviewer2 = null;
            emptyCallbacks();
            return;
        }
        throw new IllegalArgumentException("arvbmg free twice?");
    }

    public double getClipEndTimeMsExcludeEndCutscenes(int i2) {
        return this.mPreviewer2.getClipEndTimeMsExcludeEndCutscenes(i2);
    }

    public double getDuration() {
        return this.mPreviewer2.getDuration();
    }

    public PlayPosition getPlayPosition() {
        return this.mPreviewer2.getPlayPosition();
    }

    public final int getRequestSerial() {
        return this.mPreviewer2.getRequestSerial();
    }

    public int getSubPreviewerUniqueId() {
        Previewer2 previewer2 = this.mPreviewer2;
        if (previewer2 != null) {
            return previewer2.getUniqueId();
        }
        return -1000;
    }

    public double getVolume() {
        return this.mPreviewer2.getVolume();
    }

    public boolean isPlaying() {
        return this.mPreviewer2.isPlaying();
    }

    public boolean isPrepareActioned() {
        return this.isPrepareActioned;
    }

    public final boolean isSeeking() {
        return this.mPreviewer2.isSeeking();
    }

    public SrcPosition mapMediaTimeToSrcTime(double d2) {
        SrcPosition mapMediaTimeToSrcTime = this.mPreviewer2.mapMediaTimeToSrcTime(d2);
        if (mapMediaTimeToSrcTime == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" mapMediaTimeToSrcTime mediaTimeMs ");
            sb.append(d2);
            Log.e(BMGConstants.TAG, sb.toString());
        }
        return mapMediaTimeToSrcTime;
    }

    public MediaPosition mapSrcTimeToMediaTime(int i2, double d2) {
        MediaPosition mapSrcTimeToMediaTime = this.mPreviewer2.mapSrcTimeToMediaTime(i2, d2);
        if (mapSrcTimeToMediaTime == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" mapSrcTimeToMediaTime clipIndex ");
            sb.append(i2);
            sb.append(" clipSrcTimeMs ");
            sb.append(d2);
            Log.e(BMGConstants.TAG, sb.toString());
        }
        return mapSrcTimeToMediaTime;
    }

    public void pause() {
        this.mPreviewer2.pause();
    }

    public void play() {
        this.mPreviewer2.play();
    }

    public void prepareAsync(double d2, Options options) {
        this.isPrepareActioned = true;
        this.mPreviewer2.setOptions(options);
        this.mPreviewer2.prepareAsync(d2);
    }

    public int seek(int i2, double d2) {
        MediaPosition mapSrcTimeToMediaTime = mapSrcTimeToMediaTime(i2, d2);
        if (mapSrcTimeToMediaTime == null) {
            return -1;
        }
        return seek(mapSrcTimeToMediaTime.mediaTimeMs);
    }

    public void setBgmWeight(double d2) {
        this.mPreviewer2.setBgmWeight(d2);
    }

    public void setCacheDirectory(String str) {
        this.mPreviewer2.setCacheDirectory(str);
    }

    public void setCallback(BMGPreviewerCallback bMGPreviewerCallback) {
        if (bMGPreviewerCallback != null) {
            this.mCallback = bMGPreviewerCallback;
        } else {
            emptyCallbacks();
        }
    }

    public void setForceVideoKeyFrameOnly(boolean z) {
        this.mPreviewer2.setForceVideoKeyFrameOnly(z);
    }

    public void setPlayRate(double d2) {
        this.mPreviewer2.setPlayRate(d2);
    }

    public void setSource(PreviewerSource previewerSource) {
        this.mPreviewer2.setSource(previewerSource);
    }

    public void setVolume(double d2) {
        this.mPreviewer2.setVolume(d2);
    }

    public int seek(double d2) {
        return this.mPreviewer2.seek(d2);
    }
}
