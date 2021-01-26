package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.ImagePreviewer.BMGPreviewerCallback;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;

public class BMGImageSession extends BMGMediaSession {
    public ImagePreviewer previewer;
    public BMGImagePreviewerSource source;

    public BMGImageSession(Context context) {
        super(context);
    }

    private final ImagePreviewer createPreviewer() {
        ImagePreviewer imagePreviewer = new ImagePreviewer();
        ImagePreviewerSource imagePreviewerSource = new ImagePreviewerSource();
        imagePreviewerSource.setUrl(this.source.getUrl());
        imagePreviewer.setSource(imagePreviewerSource);
        imagePreviewer.setCallback(new BMGPreviewerCallback() {
            public void onFrame(ImagePreviewer imagePreviewer, VideoSampleGroup videoSampleGroup) {
                BMGImageSession.this.frameOutput.onFrame(videoSampleGroup);
            }

            public void onNotify(ImagePreviewer imagePreviewer, int i2, int i3, int i4, String str, String str2) {
                BMGImageSession bMGImageSession = BMGImageSession.this;
                if (i2 == 1) {
                    if (i3 != 0) {
                        bMGImageSession.onFail(i3, str, str2);
                    } else {
                        bMGImageSession.onComplete(0);
                    }
                }
            }
        });
        return imagePreviewer;
    }

    public final void clearPreviewer() {
        ImagePreviewer imagePreviewer = this.previewer;
        if (imagePreviewer != null) {
            imagePreviewer.free();
            this.previewer = null;
        }
    }

    public final void setupPreviewer() {
        if (this.source != null && this.frameOutput != null) {
            if (this.previewer == null) {
                this.previewer = createPreviewer();
            }
            this.previewer.play();
        }
    }

    public final void updateSource(BMGImagePreviewerSource bMGImagePreviewerSource) {
        if (bMGImagePreviewerSource != this.source) {
            this.source = bMGImagePreviewerSource;
            if (bMGImagePreviewerSource == null) {
                clearPreviewer();
            } else {
                setupPreviewer();
            }
        } else {
            Log.e(BMGConstants.TAG, " same BMGImagePreviewerSource");
        }
    }
}
