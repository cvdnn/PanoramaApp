package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.insmedia.previewer2.PlayPosition;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;

public class BMGPreviewerImpl extends BMGNativeObjectRef {
    public static final String TAG = "BMGPreviewerImpl";
    public EglContextGroup mEglContextGroup;
    public long mEglContextToShare;
    public Notifier mNotifier;
    public Options mOptions;
    public boolean mReleased;
    public VideoRender mVideoRender;

    public interface Notifier {
        void onNotify(BMGPreviewerImpl bMGPreviewerImpl, int i2, int i3, int i4, String str, String str2);
    }

    public class NotifyType {
        public static final int COMPLETE = 2;
        public static final int FAIL = 4;
        public static final int PREPARE = 1;
        public static final int SEEK = 3;

        public NotifyType() {
        }
    }

    public interface VideoRender {
        void onFrame(BMGPreviewerImpl bMGPreviewerImpl, VideoSampleGroup videoSampleGroup);
    }

    public BMGPreviewerImpl(EglContextGroup eglContextGroup) {
        this(createNativeWrap(), eglContextGroup);
    }

    public static native long createNativeWrap();

    private native void nativeSetOptions(Options options);

    private native void nativeSetSource(Object[] objArr);

    private void onNotify(int i2, int i3, int i4, String str, String str2) {
        this.mNotifier.onNotify(this, i2, i3, i4, str, str2);
    }

    private void onVideoFrame(long j2) {
        this.mVideoRender.onFrame(this, new VideoSampleGroup(j2));
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

    public native long getDuration();

    public PlayPosition getPlayPosition() {
        return new PlayPosition((double) nativeGetPlayPosition(new int[1], new String[10], new int[10], new long[10]));
    }

    public native double getVolume();

    public native boolean isPlaying();

    public native long nativeGetPlayPosition(int[] iArr, String[] strArr, int[] iArr2, long[] jArr);

    public native void nativePrepareAsync(long j2);

    public native void pause();

    public native void play();

    public void prepareAsync(long j2) {
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
        nativePrepareAsync(j2);
    }

    public native void seek(long j2);

    public native void setCacheDirectory(String str);

    public void setNotifier(Notifier notifier) {
        this.mNotifier = notifier;
    }

    public void setOptions(Options options) {
        this.mOptions = options;
    }

    public native void setPlayRate(double d2);

    public void setSource(PreviewerSource previewerSource) {
    }

    public void setVideoRender(VideoRender videoRender) {
        this.mVideoRender = videoRender;
    }

    public native void setVolume(double d2);

    public BMGPreviewerImpl(long j2, EglContextGroup eglContextGroup) {
        super(j2, TAG);
        this.mEglContextGroup = eglContextGroup;
        setupCallback();
    }
}
