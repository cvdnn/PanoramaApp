package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.arashivision.algorithm.StapleTrackOnline;
import com.arashivision.algorithm.StapleTrackResult;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.dollyzoom.DollyZoom;
import com.arashivision.arvbmg.dollyzoom.DollyZoom.IDollyzoomRectCallback;
import com.arashivision.arvbmg.dollyzoom.DollyZoom.IDollzoomInitCallback;
import com.arashivision.arvbmg.dollyzoom.DollyZoomInfo;
import com.arashivision.arvbmg.longtracker.LongTrackInfo;
import com.arashivision.arvbmg.longtracker.LongTracker;
import com.arashivision.arvbmg.longtracker.LongTracker.ILongTrackCallback;
import com.arashivision.arvbmg.longtracker.LongTracker.ILongTrackRectCallback;
import com.arashivision.arvbmg.longtracker.LongTracker.ITrackInitCompleteCallback;
import com.arashivision.arvbmg.previewer.BMGMediaSession.FrameOutput;
import com.arashivision.arvbmg.previewer.BMGMediaSession.SessionCallback;
import com.arashivision.arvbmg.previewer.BMGPreviewerSession.EndBehaviour;
import com.arashivision.arvbmg.previewer.BMGPreviewerSession.PlayRange;
import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.arvbmg.render.rendermodel.BMGCompositeRenderModel;
import com.arashivision.arvbmg.util.RenderModelUtil;
import com.arashivision.arvbmg.util.RenderModelUtil.FilterMode;
import com.arashivision.graphicpath.insmedia.common.MediaSampleMeta;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.MediaPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.SrcPosition;
import com.arashivision.graphicpath.render.HybridRender;
import com.arashivision.graphicpath.render.base.BaseCameraController;
import com.arashivision.graphicpath.render.rendermodel.RenderModel;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.render.source.SequenceSource;
import com.arashivision.graphicpath.render.source.SequenceSource.Listener;
import e.a.a.a.a;
import java.util.concurrent.CountDownLatch;

public final class BMGPreviewerSessionRender extends BMGSessionRender {
    public DollyZoom mDollyZoom;
    public int mLastClipIndex;
    public int mLastImageLayout;
    public double mLastMainStreamSrcTime;
    public LongTracker mLongTracker;
    public int mMainStreamImageLayout;
    public StapleTrackInfo mStapleTrackInfo;
    public StapleTrackOnline mStapleTrackOnline;
    public int mSubStreamImageLayout;
    public double mSubStreamSeekSrcTime;
    public BMGPreviewerSession mediaSession;
    public final State state;

    public static final class StapleTrackInfo {
        public BaseCameraController baseCameraController;
        public float currentFov;
        public String detectorPath;
        public float maxFov;
        public float minFov;
        public String namePath;
        public int offscreenHeight = 300;
        public int offscreenWidth = 300;
        public String roiPath;
        public String trackName = "person";

        public static final class StapleTrackName {
            public static final String CAR = "car";
            public static final String DOG = "dog";
            public static final String PERSON = "person";
        }
    }

    public static final class State {
        public boolean prepared;
        public boolean started;
        public boolean startedOnLifecyclePaused;

        public State(boolean z, boolean z2, boolean z3) {
            this.prepared = z;
            this.started = z2;
            this.startedOnLifecyclePaused = z3;
        }

        public final boolean getPrepared() {
            return this.prepared;
        }

        public final boolean getStarted() {
            return this.started;
        }

        public int hashCode() {
            return ((this.prepared ? 1 : 0) * true) + (this.started ? 1 : 0);
        }

        public boolean isStartedOnLifecyclePaused() {
            return this.startedOnLifecyclePaused;
        }

        public final void setPrepared(boolean z) {
            this.prepared = z;
        }

        public final void setStarted(boolean z) {
            this.started = z;
        }

        public void setStartedOnLifecyclePaused(boolean z) {
            this.startedOnLifecyclePaused = z;
        }

        public String toString() {
            StringBuilder a2 = a.a("State(prepared=");
            a2.append(this.prepared);
            a2.append(", started=");
            a2.append(this.started);
            a2.append(")");
            return a2.toString();
        }

        public State() {
            this(false, false, false);
        }
    }

    public BMGPreviewerSessionRender(Context context, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler) {
        this("BMGPreviewerSessionRender", context, callbacks, previewerRenderCallback, handler);
    }

    private ClipRenderInfo getClipRenderInfo(int i2) {
        return this.mSessionRenderCallbacks.onGetClipRenderInfo(i2);
    }

    /* access modifiers changed from: private */
    public int getCutscenesClipIndex(VideoSampleGroup videoSampleGroup) {
        if (videoSampleGroup.getCutscenesMetas() != null) {
            return videoSampleGroup.getCutscenesMeta().getClipIndex();
        }
        Log.e(BMGConstants.TAG, " no cutscene");
        return -1;
    }

    /* access modifiers changed from: private */
    public void initStapleTrack() {
        if (this.mStapleTrackInfo == null) {
            throw new IllegalStateException(" initStapleTrack but mStapleTrackInfo null");
        } else if (this.mStapleTrackOnline == null) {
            String str = BMGConstants.TAG;
            Log.i(str, " initStapleTrack ");
            this.mStapleTrackOnline = new StapleTrackOnline();
            if (isDebug()) {
                this.mStapleTrackOnline.enableDebug();
            }
            StapleTrackOnline stapleTrackOnline = this.mStapleTrackOnline;
            HybridRender hybridRender = this.render;
            StapleTrackInfo stapleTrackInfo = this.mStapleTrackInfo;
            int init = stapleTrackOnline.init(hybridRender, stapleTrackInfo.detectorPath, stapleTrackInfo.namePath, stapleTrackInfo.roiPath, stapleTrackInfo.offscreenWidth, stapleTrackInfo.offscreenHeight, stapleTrackInfo.minFov, stapleTrackInfo.maxFov, stapleTrackInfo.currentFov, stapleTrackInfo.trackName);
            if (init != 0) {
                a.c("staple track init error ", init, str);
                this.mSessionRenderCallbacks.onStapleTrackError(init);
            } else {
                StapleTrackResult stapleTrackResult = new StapleTrackResult();
                int initTrack = this.mStapleTrackOnline.initTrack(this.render, stapleTrackResult);
                if (initTrack == 0) {
                    this.mSessionRenderCallbacks.onStapleTrackResult(stapleTrackResult);
                } else {
                    a.c("staple track initTrack error ", initTrack, str);
                    this.mSessionRenderCallbacks.onStapleTrackError(initTrack);
                }
            }
            this.mStapleTrackInfo = null;
        } else {
            throw new IllegalStateException(" initStapleTrack but mStapleTrackOnline not null");
        }
    }

    /* access modifiers changed from: private */
    public void onPreviewerSetupCutsceneRenderModel(LottieSetupInfo lottieSetupInfo, VideoSampleGroup videoSampleGroup) {
        ClipRenderInfo[] clipRenderInfoArr = lottieSetupInfo.mClipRenderInfos;
        if (clipRenderInfoArr.length == 2) {
            LottieSetupInfo lottieSetupInfo2 = lottieSetupInfo;
            VideoSampleGroup videoSampleGroup2 = videoSampleGroup;
            setRootRenderModel(RenderModelUtil.createCompositeRenderModel(lottieSetupInfo2, RenderModelUtil.createRootRenderModel(clipRenderInfoArr[0], null, FilterMode.FILTER_MODE_DISCARD_WATERMARK), RenderModelUtil.createRootRenderModel(clipRenderInfoArr[1], null, FilterMode.FILTER_MODE_DISCARD_WATERMARK), videoSampleGroup2, this.render.getRenderLifecycle(), false), false);
            return;
        }
        StringBuilder a2 = a.a("createCompositeRenderModel error setup.mClipRenderInfos.length ");
        a2.append(lottieSetupInfo.mClipRenderInfos.length);
        throw new IllegalArgumentException(a2.toString());
    }

    /* access modifiers changed from: private */
    public void onPreviewerSetupRenderModel(int i2) {
        ClipRenderInfo clipRenderInfo = getClipRenderInfo(i2);
        if (clipRenderInfo != null) {
            int imageLayout = clipRenderInfo.getImageLayout();
            this.mMainStreamImageLayout = imageLayout;
            if (imageLayout >= 0) {
                this.mSubStreamImageLayout = clipRenderInfo.getSubStreamImageLayout();
                this.mLastImageLayout = this.mMainStreamImageLayout;
                this.mLastClipIndex = i2;
                StringBuilder a2 = a.a(" mMainStreamImageLayout ");
                a2.append(this.mMainStreamImageLayout);
                a2.append(" mSubStreamImageLayout ");
                a2.append(this.mSubStreamImageLayout);
                a2.append(" mLastClipIndex ");
                a2.append(this.mLastClipIndex);
                Log.i(BMGConstants.TAG, a2.toString());
                onPreviewerSourceClipStart(clipRenderInfo);
                return;
            }
            StringBuilder a3 = a.a("bad main stream layout ");
            a3.append(this.mMainStreamImageLayout);
            throw new IllegalArgumentException(a3.toString());
        }
        throw new IllegalArgumentException("onPreviewerSetupRenderModel but clip render info null ");
    }

    /* access modifiers changed from: private */
    public void onSubStreamFrameRender(MediaSampleMeta mediaSampleMeta) {
        if (mediaSampleMeta != null) {
            this.mSessionRenderCallbacks.onSubStreamFrameRender(mediaSampleMeta.getClipIndex(), mediaSampleMeta.getSrcTsMs(), mediaSampleMeta.getSrcProgressTimeMs(), mediaSampleMeta.getMediaTimeMs(), mediaSampleMeta.getRepeatMediaTimeOffsetMs());
        } else {
            Log.i(BMGConstants.TAG, "sub stream no meta");
        }
    }

    /* access modifiers changed from: private */
    public void stapleTrackInternal() {
        StapleTrackResult stapleTrackResult = new StapleTrackResult();
        int track = this.mStapleTrackOnline.track(this.render, stapleTrackResult);
        if (track == 0) {
            if (isDebug()) {
                stapleTrackResult.printInfo();
            }
            this.mSessionRenderCallbacks.onStapleTrackResult(stapleTrackResult);
            return;
        }
        a.c("staple track track error ", track, BMGConstants.TAG);
        this.mSessionRenderCallbacks.onStapleTrackError(track);
    }

    /* access modifiers changed from: private */
    public void stopStapleTrackInternal() {
        HybridRender hybridRender = this.render;
        if (hybridRender != null) {
            StapleTrackOnline stapleTrackOnline = this.mStapleTrackOnline;
            if (stapleTrackOnline != null) {
                stapleTrackOnline.release(hybridRender);
                this.mStapleTrackOnline = null;
                this.mSessionRenderCallbacks.onStapleTrackStop();
                return;
            }
            Log.w(BMGConstants.TAG, "can't stop for staple track is null ");
            return;
        }
        throw new IllegalArgumentException("stop track met render null");
    }

    /* access modifiers changed from: private */
    public void stopTrackInternal() {
        HybridRender hybridRender = this.render;
        if (hybridRender != null) {
            LongTracker longTracker = this.mLongTracker;
            if (longTracker != null) {
                longTracker.stopTrack(hybridRender);
                this.mLongTracker = null;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("stop track met render null");
    }

    /* access modifiers changed from: private */
    public void updateRenderModelImagelayoutInternal(int i2) {
        if (i2 == -1) {
            throw new IllegalArgumentException(" newImageLayout -1");
        } else if (this.mLastImageLayout != i2) {
            RenderModel rootRenderModel = getRootRenderModel();
            String str = BMGConstants.TAG;
            if (rootRenderModel != null) {
                String str2 = " to ";
                if (rootRenderModel instanceof BMGCompositeRenderModel) {
                    int i3 = this.mLastClipIndex;
                    if (i3 >= 0) {
                        ClipRenderInfo clipRenderInfo = getClipRenderInfo(i3);
                        clipRenderInfo.setImageLayout(i2);
                        this.mLastImageLayout = i2;
                        StringBuilder a2 = a.a("multiview change image layout value from ");
                        a2.append(this.mLastImageLayout);
                        a2.append(str2);
                        a2.append(i2);
                        Log.i(str, a2.toString());
                        if (clipRenderInfo.getMultiViewInfo() != null) {
                            if (clipRenderInfo.getMultiViewInfo().mClipRenderInfo == null) {
                                Log.e(str, "multiview updateRenderModelImagelayoutInternal but multi view clipRenderInfo null");
                            } else {
                                StringBuilder a3 = a.a("multiview update layout value from ");
                                a3.append(clipRenderInfo.getMultiViewInfo().mClipRenderInfo.getImageLayout());
                                a3.append(str2);
                                a3.append(i2);
                                Log.i(str, a3.toString());
                                clipRenderInfo.getMultiViewInfo().mClipRenderInfo.setImageLayout(i2);
                            }
                        }
                        onPreviewerSourceClipStart(clipRenderInfo);
                        return;
                    }
                    StringBuilder a4 = a.a("multiview error mLastClipIndex ");
                    a4.append(this.mLastClipIndex);
                    throw new IllegalArgumentException(a4.toString());
                }
                RenderModelType renderModelType = rootRenderModel.getRenderModelType();
                String str3 = ")";
                if (renderModelType.getImageLayoutValue() != this.mLastImageLayout) {
                    StringBuilder a5 = a.a(" layout mismatch (");
                    a5.append(this.mLastImageLayout);
                    a5.append(" != ");
                    a5.append(renderModelType.getImageLayoutValue());
                    a5.append(str3);
                    Log.e(str, a5.toString());
                }
                if (renderModelType.getImageLayoutValue() != i2) {
                    int i4 = this.mLastClipIndex;
                    if (i4 >= 0) {
                        ClipRenderInfo clipRenderInfo2 = getClipRenderInfo(i4);
                        clipRenderInfo2.setImageLayout(i2);
                        this.mLastImageLayout = i2;
                        StringBuilder a6 = a.a("change image layout value from ");
                        a6.append(renderModelType.getImageLayoutValue());
                        a6.append(str2);
                        a6.append(i2);
                        Log.i(str, a6.toString());
                        if (clipRenderInfo2.getMultiViewInfo() != null) {
                            Log.e(str, "multiview info not null when none BMGCompositeRenderModel");
                        }
                        onPreviewerSourceClipStart(clipRenderInfo2);
                        return;
                    }
                    StringBuilder a7 = a.a(" error mLastClipIndex ");
                    a7.append(this.mLastClipIndex);
                    throw new IllegalArgumentException(a7.toString());
                } else if (isDebug()) {
                    StringBuilder a8 = a.a("same( ");
                    a8.append(renderModelType.getImageLayoutValue());
                    a8.append(" == ");
                    a8.append(i2);
                    a8.append(str3);
                    Log.i(str, a8.toString());
                }
            } else {
                Log.e(str, " updateRenderModelImagelayoutInternal but render model null");
            }
        }
    }

    public void deInitDollyZoom() {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                HybridRender hybridRender = bMGPreviewerSessionRender.render;
                String str = BMGConstants.TAG;
                if (hybridRender == null) {
                    Log.e(str, "start track when render null");
                } else if (bMGPreviewerSessionRender.mDollyZoom == null) {
                    Log.e(str, "dollyzoom is null");
                } else {
                    BMGPreviewerSessionRender.this.mDollyZoom.deInit();
                }
            }
        });
    }

    public void enableDebug() {
        this.mediaSession.enableDebug();
        super.enableDebug();
    }

    public final double getClipEndTimeMsExcludeEndCutscenes(int i2) {
        return this.mediaSession.getClipEndTimeMsExcludeEndCutscenes(i2);
    }

    public final double getDuration() {
        return this.mediaSession.getDuration();
    }

    public float[] getFaceRect(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return null;
        }
        return (float[]) this.mDollyZoom.getRenderFaceRect(fArr);
    }

    public final PlaybackProgress getPlaybackProgress() {
        return this.mediaSession.getPlaybackProgress();
    }

    public void initDollyZoom(final DollyZoomInfo dollyZoomInfo, final IDollzoomInitCallback iDollzoomInitCallback) {
        addRenderTask(new RenderTask() {
            public void doTask() {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                if (bMGPreviewerSessionRender.render == null) {
                    Log.e(BMGConstants.TAG, "start track when render null");
                    return;
                }
                if (bMGPreviewerSessionRender.mDollyZoom == null) {
                    BMGPreviewerSessionRender.this.mDollyZoom = new DollyZoom();
                }
                DollyZoom access$100 = BMGPreviewerSessionRender.this.mDollyZoom;
                DollyZoomInfo dollyZoomInfo = dollyZoomInfo;
                access$100.loadModel(dollyZoomInfo.mnasnetMnnPath, dollyZoomInfo.bigBoomNamesPath, dollyZoomInfo.roiMnnPath, dollyZoomInfo.headMnnPath, dollyZoomInfo.detectMnnPath, dollyZoomInfo.templateMnnPath, dollyZoomInfo.templateNeckMnnPath);
                BMGPreviewerSessionRender.this.mDollyZoom.setDollzoomInitCallback(iDollzoomInitCallback);
                BMGPreviewerSessionRender.this.mDollyZoom.init(dollyZoomInfo, BMGPreviewerSessionRender.this.render);
                if (BMGPreviewerSessionRender.this.isDebug()) {
                    BMGPreviewerSessionRender.this.mDollyZoom.setDebug(true);
                }
            }
        });
    }

    public boolean isPlaying() {
        return this.mediaSession.isPlaying();
    }

    public boolean isSampleFromSubStream(VideoSampleGroup videoSampleGroup) {
        return videoSampleGroup.getSourceUniqueId() == this.mediaSession.getSubPreviewerUniqueId();
    }

    public SrcPosition mapMediaTimeToSrcTime(double d2) {
        return this.mediaSession.mapMediaTimeToSrcTime(d2);
    }

    public MediaPosition mapSrcTimeToMediaTime(int i2, double d2) {
        return this.mediaSession.mapSrcTimeToMediaTime(i2, d2);
    }

    public void onClearRenderBefore() {
        stopTrack();
        stopStapleTrack();
    }

    public void onRenderPrepare(HybridRender hybridRender) {
    }

    public final void pause() {
        this.state.setStarted(false);
        updateMediaSessionState();
    }

    public final void rebuildRenderWithSource(BMGPreviewerSource bMGPreviewerSource, Options options, double d2, BMGPreviewerSource bMGPreviewerSource2, Options options2) {
        this.mediaSession.updateSource(bMGPreviewerSource, options, d2, bMGPreviewerSource2, options2);
    }

    public final int seek(double d2) {
        return this.mediaSession.seek(d2);
    }

    public final int seekSubStream(double d2) {
        return this.mediaSession.seekSubStream(d2);
    }

    public void setBgmWeight(double d2) {
        this.mediaSession.setBgmWeight(d2);
    }

    public final void setEndBehaviour(EndBehaviour endBehaviour) {
        this.mediaSession.setEndBehaviour(endBehaviour);
    }

    public final void setForceVideoKeyFrameOnly(boolean z) {
        this.mediaSession.setForceVideoKeyFrameOnly(z);
    }

    public void setFrameOutput(FrameOutput frameOutput) {
        this.mediaSession.setFrameOutput(frameOutput);
    }

    public final int setPlayRange(PlayRange playRange) {
        return this.mediaSession.setPlayRange(playRange);
    }

    public final void setPlayRate(double d2) {
        this.mediaSession.setPlayRate(d2);
    }

    public void setPreviewQueueMode(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(" setPreviewQueueMode ");
        sb.append(i2);
        Log.w(BMGConstants.TAG, sb.toString());
        this.mSequenceSourceQueueMode = i2;
    }

    public void setSessionCallback() {
        this.mediaSession.setSessionCallback(new SessionCallback() {
            public void onComplete(final int i2) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onComplete(i2);
                    }
                });
            }

            public void onDecodeReport(final int i2, final int i3) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onDecodeReport(i2, i3);
                    }
                });
            }

            public void onFail(final int i2, final String str, final String str2) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onFail(i2, str, str2);
                    }
                });
            }

            public void onFpsNotify(final double d2) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onFpsNotify(d2);
                    }
                });
            }

            public void onPrepared() {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onPrepared();
                    }
                });
            }

            public void onReBuffer(final int i2, final int i3) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onReBuffer(i2, i3);
                    }
                });
            }

            public void onSeek(int i2, int i3, String str, String str2) {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                final int i4 = i2;
                final int i5 = i3;
                final String str3 = str;
                final String str4 = str2;
                AnonymousClass3 r1 = new Runnable() {
                    public void run() {
                        if (BMGPreviewerSessionRender.this.isDebug()) {
                            StringBuilder a2 = a.a("seek error code ");
                            a2.append(i4);
                            a2.append(" id ");
                            a.c(a2, i5, BMGConstants.TAG);
                        }
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSeek(i4, i5, str3, str4);
                    }
                };
                bMGPreviewerSessionRender.runOnSessionHandler(r1);
            }

            public void onSubStreamDecodeReport(final int i2, final int i3) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSubStreamDecodeReport(i2, i3);
                    }
                });
            }

            public void onSubStreamFail(final int i2, final String str, final String str2) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSubStreamFail(i2, str, str2);
                    }
                });
            }

            public void onSubStreamPrepared() {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSubStreamPrepared();
                    }
                });
            }

            public void onSubStreamReBuffer(final int i2, final int i3) {
                BMGPreviewerSessionRender.this.runOnSessionHandler(new Runnable() {
                    public void run() {
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSubStreamReBuffer(i2, i3);
                    }
                });
            }

            public void onSubStreamSeek(int i2, int i3, String str, String str2) {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                final int i4 = i2;
                final int i5 = i3;
                final String str3 = str;
                final String str4 = str2;
                AnonymousClass9 r1 = new Runnable() {
                    public void run() {
                        if (BMGPreviewerSessionRender.this.isDebug()) {
                            StringBuilder a2 = a.a("seek sub stream error code ");
                            a2.append(i4);
                            a2.append(" id ");
                            a.c(a2, i5, BMGConstants.TAG);
                        }
                        BMGPreviewerSessionRender.this.mSessionCallbacks.onSubStreamSeek(i4, i5, str3, str4);
                    }
                };
                bMGPreviewerSessionRender.runOnSessionHandler(r1);
            }
        });
    }

    public void setStapleTrack(final StapleTrackInfo stapleTrackInfo, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setStapleTrack beforeFirstFrame ");
        sb.append(z);
        Log.i(BMGConstants.TAG, sb.toString());
        if (!z) {
            addRenderTask(new RenderTask() {
                public void doTask() {
                    if (BMGPreviewerSessionRender.this.mStapleTrackInfo == null) {
                        BMGPreviewerSessionRender.this.mStapleTrackInfo = stapleTrackInfo;
                        return;
                    }
                    throw new IllegalStateException("startStapleTrack but mStapleTrackInfo not null");
                }
            });
        } else if (this.mStapleTrackInfo == null) {
            this.mStapleTrackInfo = stapleTrackInfo;
        } else {
            throw new IllegalStateException("startStapleTrack but mStapleTrackInfo not null");
        }
    }

    public final void setVolume(double d2) {
        this.mediaSession.setVolume(d2);
    }

    public final void setupRender() {
        super.setupRender();
        updateMediaSessionState();
    }

    public final void start() {
        this.state.setStarted(true);
        updateMediaSessionState();
    }

    public void startDollyZoom(final float f2, final float[] fArr, final IDollyzoomRectCallback iDollyzoomRectCallback) {
        addRenderTask(new RenderTask() {
            public /* synthetic */ void a(int i2, float f2, Object obj) {
                float[] fArr = (float[]) obj;
                BMGPreviewerSessionRender.this.mSessionRenderCallbacks.onTrackUpdate(i2, 0, f2, null, fArr, fArr);
            }

            public void doTask() {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                HybridRender hybridRender = bMGPreviewerSessionRender.render;
                String str = BMGConstants.TAG;
                if (hybridRender == null) {
                    Log.e(str, "start track when render null");
                } else if (bMGPreviewerSessionRender.mDollyZoom == null) {
                    Log.e(str, "dollyzoom is null");
                } else {
                    BMGPreviewerSessionRender.this.mDollyZoom.setDollyzoomRectCallback(iDollyzoomRectCallback);
                    BMGPreviewerSessionRender.this.mDollyZoom.start(f2, fArr, BMGPreviewerSessionRender.this.render);
                    BMGPreviewerSessionRender.this.mDollyZoom.setDollyzoomCallback(new e.b.a.a.a(this));
                }
            }
        });
    }

    public void startTrack(LongTrackInfo longTrackInfo, BaseCameraController baseCameraController, ILongTrackRectCallback iLongTrackRectCallback, ITrackInitCompleteCallback iTrackInitCompleteCallback) {
        final LongTrackInfo longTrackInfo2 = longTrackInfo;
        final ITrackInitCompleteCallback iTrackInitCompleteCallback2 = iTrackInitCompleteCallback;
        final ILongTrackRectCallback iLongTrackRectCallback2 = iLongTrackRectCallback;
        final BaseCameraController baseCameraController2 = baseCameraController;
        AnonymousClass7 r0 = new RenderTask() {
            public void doTask() {
                BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                HybridRender hybridRender = bMGPreviewerSessionRender.render;
                String str = BMGConstants.TAG;
                if (hybridRender == null) {
                    Log.e(str, "start track when render null");
                    return;
                }
                if (bMGPreviewerSessionRender.mLongTracker != null) {
                    Log.e(str, " last smart track not stop");
                    BMGPreviewerSessionRender.this.stopTrackInternal();
                }
                BMGPreviewerSessionRender.this.mLongTracker = new LongTracker();
                LongTracker access$000 = BMGPreviewerSessionRender.this.mLongTracker;
                LongTrackInfo longTrackInfo = longTrackInfo2;
                access$000.configModel(longTrackInfo.mnnPath, longTrackInfo.namePath, longTrackInfo.skeletonMnnPath, longTrackInfo.roiPath);
                BMGPreviewerSessionRender.this.mLongTracker.setInitCompleteCallback(iTrackInitCompleteCallback2);
                BMGPreviewerSessionRender.this.mLongTracker.setLongTrackCallback(new ILongTrackCallback() {
                    public void onNotify(LongTracker longTracker, int i2, int i3, long j2, long j3, float f2, String str, String str2, Object obj, Object obj2, Object obj3) {
                        float[] fArr = (float[]) obj;
                        BMGPreviewerSessionRender.this.mSessionRenderCallbacks.onTrackUpdate(i2, j2, f2, fArr, (float[]) obj2, (float[]) obj3);
                    }

                    public void onStartCallback(String str, boolean z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("detect skeleton = ");
                        sb.append(z);
                        Log.d(BMGConstants.TAG, sb.toString());
                        BMGPreviewerSessionRender.this.mSessionRenderCallbacks.onTrackStart(str, z);
                    }

                    public void onStopCallback(long j2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton count = ");
                        sb.append(j2);
                        Log.d(BMGConstants.TAG, sb.toString());
                        BMGPreviewerSessionRender.this.mSessionRenderCallbacks.onStopTrack(j2);
                    }
                });
                BMGPreviewerSessionRender.this.mLongTracker.setLongTrackRectCallback(iLongTrackRectCallback2);
                BMGPreviewerSessionRender.this.mLongTracker.startAiTrack(longTrackInfo2, BMGPreviewerSessionRender.this.render, baseCameraController2);
                if (BMGPreviewerSessionRender.this.isDebug()) {
                    BMGPreviewerSessionRender.this.mLongTracker.setDebug(true);
                }
            }
        };
        addRenderTask(r0);
    }

    public void stopDollyZoom() {
        if (isRenderTread()) {
            DollyZoom dollyZoom = this.mDollyZoom;
            if (dollyZoom != null) {
                dollyZoom.stop(this.render);
                this.mDollyZoom = null;
            }
        } else if (this.render == null) {
            Log.e(BMGConstants.TAG, "stop dollyzoom render null exception");
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            addRenderTask(new RenderTask() {
                public void doTask() {
                    if (BMGPreviewerSessionRender.this.mDollyZoom != null) {
                        BMGPreviewerSessionRender.this.mDollyZoom.stop(BMGPreviewerSessionRender.this.render);
                        BMGPreviewerSessionRender.this.mDollyZoom = null;
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void stopStapleTrack() {
        String str = BMGConstants.TAG;
        Log.i(str, "stopStapleTrack");
        if (isRenderTread()) {
            stopStapleTrackInternal();
        } else if (this.render == null) {
            Log.e(str, "stopTrack render null exception");
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            addRenderTask(new RenderTask() {
                public void doTask() {
                    BMGPreviewerSessionRender.this.stopStapleTrackInternal();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void stopTrack() {
        if (isRenderTread()) {
            stopTrackInternal();
        } else if (this.render == null) {
            Log.e(BMGConstants.TAG, "stopTrack render null exception");
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            addRenderTask(new RenderTask() {
                public void doTask() {
                    BMGPreviewerSessionRender.this.stopTrackInternal();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void terminateSession() {
        this.mediaSession.terminate();
    }

    public final void updateMediaSessionState() {
        if (this.render == null) {
            StringBuilder a2 = a.a(" updateMediaSessionState when render null state start ");
            a2.append(this.state.getStarted());
            Log.e(BMGConstants.TAG, a2.toString());
        }
        if (this.state.getStarted()) {
            this.mediaSession.resume();
        } else {
            this.mediaSession.pause();
        }
    }

    public BMGPreviewerSessionRender(String str, Context context, Callbacks callbacks, PreviewerRenderCallback previewerRenderCallback, Handler handler) {
        super(str, context, callbacks, previewerRenderCallback, handler);
        this.mSubStreamSeekSrcTime = -1.0d;
        this.mLastMainStreamSrcTime = -1.0d;
        this.mMainStreamImageLayout = -1;
        this.mSubStreamImageLayout = -1;
        this.mLastImageLayout = -1;
        this.mLastClipIndex = -1;
        setSequenceSourceListener(new Listener() {
            public void onSequenceSourceUpdate(SequenceSource sequenceSource, VideoSampleGroup videoSampleGroup, VideoSampleGroup videoSampleGroup2) {
                long nanoTime = BMGPreviewerSessionRender.this.isDebug() ? System.nanoTime() : 0;
                if (videoSampleGroup2 != null) {
                    if (BMGPreviewerSessionRender.this.mLongTracker != null) {
                        BMGPreviewerSessionRender.this.mLongTracker.updateTrack(BMGPreviewerSessionRender.this.render);
                    }
                    if (BMGPreviewerSessionRender.this.mDollyZoom != null) {
                        BMGPreviewerSessionRender.this.mDollyZoom.update(BMGPreviewerSessionRender.this.render);
                    }
                    boolean z = false;
                    if (videoSampleGroup == null || BMGPreviewerSessionRender.this.hasCutScene(videoSampleGroup) != BMGPreviewerSessionRender.this.hasCutScene(videoSampleGroup2) || (!BMGPreviewerSessionRender.this.hasCutScene(videoSampleGroup2) ? BMGPreviewerSessionRender.this.getClipIndex(videoSampleGroup) != BMGPreviewerSessionRender.this.getClipIndex(videoSampleGroup2) : BMGPreviewerSessionRender.this.getCutscenesClipIndex(videoSampleGroup) != BMGPreviewerSessionRender.this.getCutscenesClipIndex(videoSampleGroup2))) {
                        z = true;
                    }
                    BMGPreviewerSessionRender.this.debugSampleTime("sourceUpdate", videoSampleGroup2);
                    String str = BMGConstants.TAG;
                    if (!z) {
                        BMGPreviewerSessionRender.this.onUpdateImageBlendFilter(videoSampleGroup2.getMeta());
                    } else if (BMGPreviewerSessionRender.this.hasCutScene(videoSampleGroup2)) {
                        StringBuilder a2 = a.a(" lottie start time ");
                        a2.append(videoSampleGroup2.getMeta().getMediaTimeMs());
                        a2.append(" previewer get ");
                        BMGPreviewerSessionRender bMGPreviewerSessionRender = BMGPreviewerSessionRender.this;
                        a2.append(bMGPreviewerSessionRender.getClipEndTimeMsExcludeEndCutscenes(bMGPreviewerSessionRender.getCutscenesClipIndex(videoSampleGroup2)));
                        Log.i(str, a2.toString());
                        double mediaTimeMs = videoSampleGroup2.getMeta().getMediaTimeMs();
                        BMGPreviewerSessionRender bMGPreviewerSessionRender2 = BMGPreviewerSessionRender.this;
                        if (mediaTimeMs != bMGPreviewerSessionRender2.getClipEndTimeMsExcludeEndCutscenes(bMGPreviewerSessionRender2.getCutscenesClipIndex(videoSampleGroup2))) {
                            Log.e(str, " lottie start time mismatch, lost frame?");
                        }
                        BMGPreviewerSessionRender bMGPreviewerSessionRender3 = BMGPreviewerSessionRender.this;
                        bMGPreviewerSessionRender3.onPreviewerSetupCutsceneRenderModel(bMGPreviewerSessionRender3.mSessionRenderCallbacks.onLottieSetup(bMGPreviewerSessionRender3.getCutscenesClipIndex(videoSampleGroup2), BMGPreviewerSessionRender.this.getClipIndex(videoSampleGroup2), videoSampleGroup2.getMeta().getMediaTimeMs()), videoSampleGroup2);
                    } else {
                        BMGPreviewerSessionRender bMGPreviewerSessionRender4 = BMGPreviewerSessionRender.this;
                        bMGPreviewerSessionRender4.onPreviewerSetupRenderModel(bMGPreviewerSessionRender4.getClipIndex(videoSampleGroup2));
                    }
                    if (BMGPreviewerSessionRender.this.mStapleTrackInfo != null) {
                        BMGPreviewerSessionRender.this.initStapleTrack();
                    } else if (BMGPreviewerSessionRender.this.mStapleTrackOnline != null) {
                        BMGPreviewerSessionRender.this.stapleTrackInternal();
                    }
                    if (BMGPreviewerSessionRender.this.hasCutScene(videoSampleGroup2)) {
                        RenderModel rootRenderModel = BMGPreviewerSessionRender.this.getRootRenderModel();
                        if (rootRenderModel == null || !(rootRenderModel instanceof BMGCompositeRenderModel)) {
                            Log.e(str, " render cutscene but not BMGCompositeRenderModel");
                        } else {
                            BMGCompositeRenderModel bMGCompositeRenderModel = (BMGCompositeRenderModel) rootRenderModel;
                            BMGPreviewerSessionRender bMGPreviewerSessionRender5 = BMGPreviewerSessionRender.this;
                            bMGCompositeRenderModel.update(bMGPreviewerSessionRender5.mSessionRenderCallbacks.onLottieUpdate(bMGPreviewerSessionRender5.getCutscenesClipIndex(videoSampleGroup2), BMGPreviewerSessionRender.this.getClipIndex(videoSampleGroup2), videoSampleGroup2.getMeta().getMediaTimeMs()));
                        }
                        BMGPreviewerSessionRender.this.onCutSceneFrameRender(videoSampleGroup2.getCutscenesMeta(), videoSampleGroup2.getMeta());
                    } else {
                        if (BMGPreviewerSessionRender.this.isSampleFromSubStream(videoSampleGroup2)) {
                            if (BMGPreviewerSessionRender.this.mSubStreamImageLayout != -1) {
                                BMGPreviewerSessionRender bMGPreviewerSessionRender6 = BMGPreviewerSessionRender.this;
                                bMGPreviewerSessionRender6.updateRenderModelImagelayoutInternal(bMGPreviewerSessionRender6.mSubStreamImageLayout);
                            } else {
                                Log.e(str, "mSubStreamImageLayout -1 ");
                            }
                            if (BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime != -1.0d) {
                                StringBuilder a3 = a.a("last sub seek mSubStreamSeekSrcTime ");
                                a3.append(BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime);
                                Log.i(str, a3.toString());
                            }
                            BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime = videoSampleGroup2.getMeta().getSrcTsMs();
                            if (BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime == BMGPreviewerSessionRender.this.mLastMainStreamSrcTime) {
                                Log.e(str, "sub seek frame after main seek ?");
                            }
                            StringBuilder a4 = a.a(" mSubStreamSeekSrcTime ");
                            a4.append(BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime);
                            Log.i(str, a4.toString());
                            BMGPreviewerSessionRender.this.onSubStreamFrameRender(videoSampleGroup2.getMeta());
                        } else {
                            BMGPreviewerSessionRender bMGPreviewerSessionRender7 = BMGPreviewerSessionRender.this;
                            bMGPreviewerSessionRender7.updateRenderModelImagelayoutInternal(bMGPreviewerSessionRender7.mMainStreamImageLayout);
                            BMGPreviewerSessionRender.this.mLastMainStreamSrcTime = videoSampleGroup2.getMeta().getSrcTsMs();
                            if (BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime != -1.0d) {
                                String str2 = ")";
                                if (BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime == BMGPreviewerSessionRender.this.mLastMainStreamSrcTime) {
                                    StringBuilder a5 = a.a("seek main/sub stream match( ");
                                    a5.append(BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime);
                                    a5.append(" == ");
                                    a5.append(BMGPreviewerSessionRender.this.mLastMainStreamSrcTime);
                                    a5.append(str2);
                                    Log.w(str, a5.toString());
                                    BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime = -1.0d;
                                } else {
                                    StringBuilder a6 = a.a("seek main/sub stream  mismatch( ");
                                    a6.append(BMGPreviewerSessionRender.this.mSubStreamSeekSrcTime);
                                    a6.append(" != ");
                                    a6.append(BMGPreviewerSessionRender.this.mLastMainStreamSrcTime);
                                    a6.append(str2);
                                    Log.e(str, a6.toString());
                                }
                            }
                            BMGPreviewerSessionRender.this.onFrameRender(videoSampleGroup2.getMeta());
                        }
                        RenderModel rootRenderModel2 = BMGPreviewerSessionRender.this.getRootRenderModel();
                        if (rootRenderModel2 != null && (rootRenderModel2 instanceof BMGCompositeRenderModel)) {
                            BMGCompositeRenderModel bMGCompositeRenderModel2 = (BMGCompositeRenderModel) rootRenderModel2;
                            boolean onMultiViewFrameRender = BMGPreviewerSessionRender.this.onMultiViewFrameRender(videoSampleGroup2.getMeta());
                            if (BMGPreviewerSessionRender.this.isDebug()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("preview onMultiViewFrameRender state ");
                                sb.append(onMultiViewFrameRender);
                                Log.i(str, sb.toString());
                            }
                            bMGCompositeRenderModel2.updateMultiViewState(onMultiViewFrameRender);
                            if (onMultiViewFrameRender) {
                                MultiViewRectInfo onUpdateMultiViewInfo = BMGPreviewerSessionRender.this.onUpdateMultiViewInfo(videoSampleGroup2.getMeta());
                                if (onUpdateMultiViewInfo != null) {
                                    bMGCompositeRenderModel2.updateMultiViewInfo(onUpdateMultiViewInfo);
                                }
                            }
                        }
                    }
                    if (BMGPreviewerSessionRender.this.isDebug()) {
                        StringBuilder a7 = a.a("sourceUpdate cost ");
                        a7.append((System.nanoTime() - nanoTime) / 1000000);
                        a7.append("ms");
                        Log.i(str, a7.toString());
                    }
                }
            }
        });
        this.mediaSession = new BMGPreviewerSession(context, this.eglContextGroup);
        this.state = new State();
    }

    public final int seek(int i2, double d2) {
        return this.mediaSession.seek(i2, d2);
    }

    public final int seekSubStream(int i2, double d2) {
        return this.mediaSession.seekSubStream(i2, d2);
    }
}
