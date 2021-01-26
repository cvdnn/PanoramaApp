package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.os.Handler;
import com.arashivision.arvbmg.previewer.BMGMediaSession.FrameOutput;
import com.arashivision.arvbmg.previewer.BMGMediaSession.SessionCallback;
import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.source.SequenceSource;
import com.arashivision.graphicpath.render.source.SequenceSource.Listener;

public class BMGImageSessionRender extends BMGSessionRender {
    public BMGImageSession mediaSession;

    public BMGImageSessionRender(Context context, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler) {
        this("BMGImageSessionRender", context, callbacks, previewerRenderCallback, handler);
    }

    public boolean isSampleFromSubStream(VideoSampleGroup videoSampleGroup) {
        return false;
    }

    public void onClearRenderBefore() {
    }

    public void onRenderPrepare(HybridRender hybridRender) {
    }

    public final void rebuildRenderWithSource(BMGImagePreviewerSource bMGImagePreviewerSource) {
        this.mediaSession.updateSource(bMGImagePreviewerSource);
    }

    public final void setFrameOutput(FrameOutput frameOutput) {
        this.mediaSession.setFrameOutput(frameOutput);
    }

    public final void setSessionCallback() {
        this.mediaSession.setSessionCallback(new SessionCallback() {
            public void onComplete(final int i2) {
                BMGImageSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGImageSessionRender.this.mSessionCallbacks.onComplete(i2);
                    }
                });
            }

            public void onDecodeReport(int i2, int i3) {
            }

            public void onFail(final int i2, final String str, final String str2) {
                BMGImageSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGImageSessionRender.this.mSessionCallbacks.onFail(i2, str, str2);
                    }
                });
            }

            public void onFpsNotify(double d2) {
            }

            public void onPrepared() {
            }

            public void onReBuffer(int i2, int i3) {
            }

            public void onSeek(int i2, int i3, String str, String str2) {
            }

            public void onSubStreamDecodeReport(int i2, int i3) {
            }

            public void onSubStreamFail(int i2, String str, String str2) {
            }

            public void onSubStreamPrepared() {
            }

            public void onSubStreamReBuffer(int i2, int i3) {
            }

            public void onSubStreamSeek(int i2, int i3, String str, String str2) {
            }
        });
    }

    public void terminateSession() {
        this.mediaSession.terminate();
    }

    public void updateMediaSessionState() {
    }

    public BMGImageSessionRender(String str, Context context, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler) {
        super(str, context, callbacks, previewerRenderCallback, handler);
        setSequenceSourceListener(new Listener() {
            public void onSequenceSourceUpdate(SequenceSource sequenceSource, VideoSampleGroup videoSampleGroup, VideoSampleGroup videoSampleGroup2) {
                if (videoSampleGroup2 != null) {
                    if (videoSampleGroup == null || !BMGImageSessionRender.this.isSameClip(videoSampleGroup, videoSampleGroup2)) {
                        BMGImageSessionRender bMGImageSessionRender = BMGImageSessionRender.this;
                        BMGImageSessionRender.this.onPreviewerSourceClipStart(bMGImageSessionRender.mSessionRenderCallbacks.onGetClipRenderInfo(bMGImageSessionRender.getClipIndex(videoSampleGroup2)));
                    }
                    BMGImageSessionRender.this.onFrameRender(videoSampleGroup2.getMeta());
                }
            }
        });
        this.mediaSession = new BMGImageSession(context);
    }
}
