package com.arashivision.graphicpath.insmedia.previewer2;

import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.PlayPosition.PlayTrackPosition;
import com.arashivision.insbase.nativeref.NativeObjectRef;
import java.util.HashMap;

public class Previewer2 extends NativeObjectRef {
    public EglContextGroup mEglContextGroup;
    public long mEglContextToShare;
    public Notifier mNotifier;
    public Options mOptions;
    public boolean mReleased;
    public VideoRender mVideoRender;

    public static class MediaPosition {
        public double mediaTimeMs;
    }

    public interface Notifier {
        void onNotify(Previewer2 previewer2, int i2, int i3, int i4, String str, String str2);
    }

    public class NotifyType {
        public static final int COMPLETE = 2;
        public static final int FAIL = 4;
        public static final int PREPARE = 1;
        public static final int REBUFFER = 5;
        public static final int SEEK = 3;
        public static final int VIDEO_DECODER_HWACCEL_REPORT = 6;

        public NotifyType() {
        }
    }

    public static class SrcPosition {
        public int clipIndex;
        public double clipSrcProgressTimeMs;
        public double clipSrcTimeMs;
        public double repeatMediaTimeOffsetMs;
    }

    public interface VideoRender {
        void onFrame(Previewer2 previewer2, VideoSampleGroup videoSampleGroup);
    }

    static {
        InsMediaLibsLoader.load();
    }

    public Previewer2(EglContextGroup eglContextGroup) {
        this(createNativeWrap(), eglContextGroup);
    }

    public static native long createNativeWrap();

    private native boolean nativeMapMediaTimeToSrcTime(double d2, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3);

    private native boolean nativeMapSrcTimeToMediaTime(int i2, double d2, double[] dArr);

    private native void nativeSetOptions(Options options);

    private native void nativeSetSource(PreviewerSource previewerSource);

    private void onNotify(int i2, int i3, int i4, String str, String str2) {
        Notifier notifier = this.mNotifier;
        if (notifier != null) {
            notifier.onNotify(this, i2, i3, i4, str, str2);
        }
    }

    private void onVideoFrame(long j2) {
        VideoSampleGroup videoSampleGroup = new VideoSampleGroup(j2);
        VideoRender videoRender = this.mVideoRender;
        if (videoRender != null) {
            videoRender.onFrame(this, videoSampleGroup);
        } else {
            videoSampleGroup.free();
        }
    }

    private native void release();

    private native void setupCallback();

    public void free() {
        if (!this.mReleased) {
            release();
            super.free();
            EglContextGroup eglContextGroup = this.mEglContextGroup;
            if (eglContextGroup != null) {
                eglContextGroup.releaseEglContext(this, this.mEglContextToShare);
                this.mEglContextToShare = 0;
                this.mEglContextGroup = null;
            }
            this.mReleased = true;
        }
    }

    public native double getClipEndTimeMsExcludeEndCutscenes(int i2);

    public native double getDuration();

    public PlayPosition getPlayPosition() {
        int[] iArr = new int[1];
        String[] strArr = new String[10];
        int[] iArr2 = new int[10];
        double[] dArr = new double[10];
        double[] dArr2 = new double[10];
        double[] dArr3 = new double[10];
        PlayPosition playPosition = new PlayPosition(nativeGetPlayPosition(iArr, strArr, iArr2, dArr, dArr2, dArr3));
        for (int i2 = 0; i2 < iArr[0]; i2++) {
            HashMap<String, PlayTrackPosition> hashMap = playPosition.trackPositions;
            String str = strArr[i2];
            PlayTrackPosition playTrackPosition = new PlayTrackPosition(strArr[i2], iArr2[i2], dArr[i2], dArr2[i2], dArr3[i2]);
            hashMap.put(str, playTrackPosition);
        }
        return playPosition;
    }

    public native int getRequestSerial();

    public native int getUniqueId();

    public native double getVolume();

    public native boolean isPlaying();

    public native boolean isSeeking();

    public SrcPosition mapMediaTimeToSrcTime(double d2) {
        int[] iArr = new int[1];
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        double[] dArr3 = new double[1];
        if (!nativeMapMediaTimeToSrcTime(d2, iArr, dArr, dArr2, dArr3)) {
            return null;
        }
        SrcPosition srcPosition = new SrcPosition();
        srcPosition.clipIndex = iArr[0];
        srcPosition.clipSrcTimeMs = dArr[0];
        srcPosition.clipSrcProgressTimeMs = dArr2[0];
        srcPosition.repeatMediaTimeOffsetMs = dArr3[0];
        return srcPosition;
    }

    public MediaPosition mapSrcTimeToMediaTime(int i2, double d2) {
        double[] dArr = new double[1];
        if (!nativeMapSrcTimeToMediaTime(i2, d2, dArr)) {
            return null;
        }
        MediaPosition mediaPosition = new MediaPosition();
        mediaPosition.mediaTimeMs = dArr[0];
        return mediaPosition;
    }

    public native double nativeGetPlayPosition(int[] iArr, String[] strArr, int[] iArr2, double[] dArr, double[] dArr2, double[] dArr3);

    public native void nativePrepareAsync(double d2);

    public native void pause();

    public native void play();

    public void prepareAsync(double d2) {
        if (this.mOptions == null && this.mEglContextGroup != null) {
            this.mOptions = new Options();
        }
        EglContextGroup eglContextGroup = this.mEglContextGroup;
        if (eglContextGroup != null) {
            long acquireEglContext = eglContextGroup.acquireEglContext(this);
            this.mEglContextToShare = acquireEglContext;
            this.mOptions.setVoidPtr(20, acquireEglContext);
            this.mOptions.setInt(21, this.mEglContextGroup.getGlVersion());
        }
        Options options = this.mOptions;
        if (options != null) {
            nativeSetOptions(options);
        }
        nativePrepareAsync(d2);
    }

    public native int seek(double d2);

    public native void setBgmWeight(double d2);

    public native void setCacheDirectory(String str);

    public native void setForceVideoKeyFrameOnly(boolean z);

    public void setNotifier(Notifier notifier) {
        this.mNotifier = notifier;
    }

    public void setOptions(Options options) {
        this.mOptions = options;
    }

    public native void setPlayRate(double d2);

    public void setSource(PreviewerSource previewerSource) {
        nativeSetSource(previewerSource);
    }

    public void setVideoRender(VideoRender videoRender) {
        this.mVideoRender = videoRender;
    }

    public native void setVolume(double d2);

    public Previewer2(long j2, EglContextGroup eglContextGroup) {
        super(j2, "Previewer2");
        this.mEglContextGroup = eglContextGroup;
        setupCallback();
    }
}
