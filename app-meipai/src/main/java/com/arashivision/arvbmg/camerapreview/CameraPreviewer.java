package com.arashivision.arvbmg.camerapreview;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;

public class CameraPreviewer extends BMGNativeObjectRef {
    public PreviewerCallback mCallback;
    public EglContextGroup mEglContextGroup;
    public long mEglContextToShare;
    public Options mOptions;
    public boolean mReleased;

    public class NotifyType {
        public static final int FAIL = 1;

        public NotifyType() {
        }
    }

    public interface PreviewerCallback {
        void onFrame(CameraPreviewer cameraPreviewer, VideoSampleGroup videoSampleGroup);

        void onNotify(CameraPreviewer cameraPreviewer, int i2, int i3, int i4, String str, String str2);
    }

    public CameraPreviewer(EglContextGroup eglContextGroup, Options options, PreviewerCallback previewerCallback) {
        this(createNativeWrap(), eglContextGroup, options, previewerCallback);
    }

    public static native long createNativeWrap();

    private native void nativeSetOptions(Options options);

    private void onNotify(int i2, int i3, int i4, String str, String str2) {
        this.mCallback.onNotify(this, i2, i3, i4, str, str2);
    }

    private void onVideoFrame(long j2) {
        this.mCallback.onFrame(this, new VideoSampleGroup(j2));
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

    public native void nativeEnableDebug();

    public native void nativePutExposure(long j2, double d2);

    public native void nativePutVideo2(byte[] bArr, int i2, byte[] bArr2, long j2, int i3, int i4, int i5, boolean z);

    public native void nativePutVideo3(byte[] bArr, int i2, byte[] bArr2, long j2, int i3, int i4, int i5, boolean z, byte[] bArr3, int i6, byte[] bArr4, long j3, int i7, int i8, int i9, boolean z2);

    public native void nativeSetPreviewDeltaNs(long j2);

    public void prepareAsync() {
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
    }

    public CameraPreviewer(long j2, EglContextGroup eglContextGroup, Options options, PreviewerCallback previewerCallback) {
        super(j2, "CameraPreviewer");
        this.mEglContextGroup = eglContextGroup;
        this.mCallback = previewerCallback;
        setupCallback();
        this.mOptions = options;
        setRequireFreeManually();
    }
}
