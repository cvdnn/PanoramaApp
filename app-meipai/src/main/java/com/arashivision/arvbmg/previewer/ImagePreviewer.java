package com.arashivision.arvbmg.previewer;

import android.util.Log;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class ImagePreviewer extends BMGNativeObjectRef {
    public static final String TAG = "ImagePreviewer";
    public BMGPreviewerCallback mCallback;

    public interface BMGPreviewerCallback {
        void onFrame(ImagePreviewer imagePreviewer, VideoSampleGroup videoSampleGroup);

        void onNotify(ImagePreviewer imagePreviewer, int i2, int i3, int i4, String str, String str2);
    }

    public static class NotifyType {
        public static final int PLAY = 1;
    }

    public ImagePreviewer() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    private void emptyCallbacks() {
        this.mCallback = new BMGPreviewerCallback() {
            public void onFrame(ImagePreviewer imagePreviewer, VideoSampleGroup videoSampleGroup) {
                Log.e(ImagePreviewer.TAG, " empty onFrame");
                videoSampleGroup.free();
            }

            public void onNotify(ImagePreviewer imagePreviewer, int i2, int i3, int i4, String str, String str2) {
                Log.e(ImagePreviewer.TAG, " empty onNotify");
            }
        };
    }

    private native void nativePlay();

    private native void nativeRelease();

    private native void nativeSetSource(ImagePreviewerSource imagePreviewerSource);

    private void onNotify(int i2, int i3, int i4, String str, String str2) {
        this.mCallback.onNotify(this, i2, i3, i4, str, str2);
    }

    private void onVideoFrame(long j2) {
        this.mCallback.onFrame(this, new VideoSampleGroup(j2));
    }

    private native void setupCallback();

    public void free() {
        nativeRelease();
        emptyCallbacks();
    }

    public void play() {
        nativePlay();
    }

    public void setCallback(BMGPreviewerCallback bMGPreviewerCallback) {
        if (bMGPreviewerCallback != null) {
            this.mCallback = bMGPreviewerCallback;
        } else {
            emptyCallbacks();
        }
    }

    public void setSource(ImagePreviewerSource imagePreviewerSource) {
        nativeSetSource(imagePreviewerSource);
    }

    public ImagePreviewer(long j2) {
        super(j2, TAG);
        emptyCallbacks();
        setupCallback();
    }
}
