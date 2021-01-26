package com.arashivision.graphicpath.render.source;

import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class SequenceSource extends Source {
    public Listener mListener;
    public long mNativeListener;

    public interface Listener {
        void onSequenceSourceUpdate(SequenceSource sequenceSource, VideoSampleGroup videoSampleGroup, VideoSampleGroup videoSampleGroup2);
    }

    public static class QueueMode {
        public static final int FIFO = 1;
        public static final int MAILBOX = 0;
    }

    public SequenceSource(boolean z) {
        this(createNativeWrap(z));
    }

    public static native long createNativeWrap(boolean z);

    private native void nativeDestroy();

    private native void nativeSetup();

    private void onSourceUpdate(long j2, long j3) {
        VideoSampleGroup videoSampleGroup = null;
        VideoSampleGroup videoSampleGroup2 = j2 != 0 ? new VideoSampleGroup(j2) : null;
        if (j3 != 0) {
            videoSampleGroup = new VideoSampleGroup(j3);
        }
        if (videoSampleGroup2 != null) {
            videoSampleGroup2.setRequireFreeManually(false);
        }
        if (videoSampleGroup != null) {
            videoSampleGroup.setRequireFreeManually(false);
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onSequenceSourceUpdate(this, videoSampleGroup2, videoSampleGroup);
            return;
        }
        if (videoSampleGroup2 != null) {
            videoSampleGroup2.free();
        }
        if (videoSampleGroup != null) {
            videoSampleGroup.free();
        }
    }

    public native void abortQueue();

    public void free() {
        super.free();
        nativeDestroy();
    }

    public native void putSample(VideoSampleGroup videoSampleGroup);

    public native void putSample2(VideoSampleGroup videoSampleGroup);

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public native void setVideoQueueMode(int i2);

    public SequenceSource(long j2) {
        super(j2);
        nativeSetup();
    }
}
