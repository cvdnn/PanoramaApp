package com.arashivision.arvbmg.previewer;

import android.content.Context;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.previewer.BMGMediaSession.FrameOutput;
import com.arashivision.arvbmg.previewer.BMGPreviewer.BMGPreviewerCallback;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ClipTimeScale;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.FileSourceClip;
import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ImageSourceClip;
import com.arashivision.graphicpath.base.EglContextGroup;
import com.arashivision.graphicpath.insmedia.common.MediaSampleMeta;
import com.arashivision.graphicpath.insmedia.common.VideoSampleGroup;
import com.arashivision.graphicpath.insmedia.previewer2.Options;
import com.arashivision.graphicpath.insmedia.previewer2.PlayPosition;
import com.arashivision.graphicpath.insmedia.previewer2.PlayPosition.PlayTrackPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.MediaPosition;
import com.arashivision.graphicpath.insmedia.previewer2.Previewer2.SrcPosition;
import com.arashivision.graphicpath.insmedia.previewer2.PreviewerSource;
import com.arashivision.graphicpath.insmedia.previewer2.TimeScale;
import com.arashivision.graphicpath.insmedia.previewer2.TrackName;
import e.a.a.a.a;
import java.util.HashMap;

public final class BMGPreviewerSession extends BMGMediaSession {
    public final EglContextGroup eglContextGroup;
    public EndBehaviour endBehavior;
    public InnerStatus innerStatus = new InnerStatus(false, false, 0);
    public Options mPreviewerOptions;
    public InnerStatus mSubInnerStatus;
    public BMGPreviewer mSubPreviewer;
    public Options mSubPreviewerOptions;
    public BMGPreviewerSource mSubSource;
    public PlayRange playRange = new PlayRange(0.0d, 9.223372036854776E18d);
    public BMGPreviewer previewer;
    public BMGPreviewerSource source;
    public State state = new State(false, false, 0.0d);

    public enum EndBehaviour {
        LOOP,
        PAUSE_ON_LAST_FRAME,
        PAUSE_ON_FIRST_FRAME
    }

    public static final class InnerStatus {
        public volatile boolean playbackFinish;
        public volatile boolean prepareComplete;
        public volatile int serialId;

        public InnerStatus(boolean z, boolean z2, int i2) {
            this.prepareComplete = z;
            this.playbackFinish = z2;
            this.serialId = i2;
        }

        public final InnerStatus copy(boolean z, boolean z2, int i2) {
            return new InnerStatus(z, z2, i2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof InnerStatus)) {
                    return false;
                }
                InnerStatus innerStatus = (InnerStatus) obj;
                if (!(this.prepareComplete == innerStatus.prepareComplete && this.playbackFinish == innerStatus.playbackFinish && this.serialId == innerStatus.serialId)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean getPlaybackFinish() {
            return this.playbackFinish;
        }

        public final boolean getPrepareComplete() {
            return this.prepareComplete;
        }

        public final int getSerialId() {
            return this.serialId;
        }

        public int hashCode() {
            int i2 = (this.prepareComplete ? 1 : 0) * true;
            boolean z = this.playbackFinish;
            return ((i2 + 1) * 31) + this.serialId;
        }

        public final void setPlaybackFinish(boolean z) {
            this.playbackFinish = z;
        }

        public final void setPrepareComplete(boolean z) {
            this.prepareComplete = z;
        }

        public final void setSerialId(int i2) {
            this.serialId = i2;
        }

        public String toString() {
            StringBuilder a2 = a.a("InnerStatus(prepareComplete=");
            a2.append(this.prepareComplete);
            a2.append(", playbackFinish=");
            a2.append(this.playbackFinish);
            a2.append(", serialId=");
            return a.a(a2, this.serialId, ")");
        }

        public InnerStatus() {
            this(false, false, 0);
        }
    }

    public static final class PlayRange {
        public final double endMs;
        public final double startMs;

        public PlayRange(double d2, double d3) {
            this.startMs = d2;
            this.endMs = d3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlayRange) {
                PlayRange playRange = (PlayRange) obj;
                if (this.startMs == playRange.startMs && this.endMs == playRange.endMs) {
                    return true;
                }
            }
            return false;
        }

        public final double getEndMs() {
            return this.endMs;
        }

        public final double getStartMs() {
            return this.startMs;
        }

        public String toString() {
            StringBuilder a2 = a.a("PlayRange(startMs=");
            a2.append(this.startMs);
            a2.append(", endMs=");
            a2.append(this.endMs);
            a2.append(")");
            return a2.toString();
        }
    }

    public static final class State {
        public boolean prepared;
        public double restorePosition;
        public boolean resumed;

        public State(boolean z, boolean z2, double d2) {
            this.prepared = z;
            this.resumed = z2;
            this.restorePosition = d2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof State)) {
                    return false;
                }
                State state = (State) obj;
                if (!(this.prepared == state.prepared && this.resumed == state.resumed && this.restorePosition == state.restorePosition)) {
                    return false;
                }
            }
            return true;
        }

        public final double getRestorePosition() {
            return this.restorePosition;
        }

        public final boolean getResumed() {
            return this.resumed;
        }

        public final void setRestorePosition(double d2) {
            this.restorePosition = d2;
        }

        public final void setResumed(boolean z) {
            this.resumed = z;
        }

        public String toString() {
            StringBuilder a2 = a.a("State(prepared=");
            a2.append(this.prepared);
            a2.append(", resumed=");
            a2.append(this.resumed);
            a2.append(", restorePosition=");
            a2.append(this.restorePosition);
            a2.append(")");
            return a2.toString();
        }

        public State() {
            this(false, false, 0.0d);
        }
    }

    public static final class SubStreamInfo {
        public BMGPreviewer mPreviewer;
        public Options mPreviewerOptions;
        public BMGPreviewerSource mSource;
    }

    public BMGPreviewerSession(Context context, EglContextGroup eglContextGroup2) {
        super(context);
        this.eglContextGroup = eglContextGroup2;
    }

    private final BMGPreviewer createPreviewer(EglContextGroup eglContextGroup2, BMGPreviewerSource bMGPreviewerSource) {
        PreviewerSource previewerSource;
        BMGSourceClip[] bMGSourceClipArr;
        int i2;
        PreviewerSource previewerSource2 = new PreviewerSource();
        previewerSource2.setOriginAudioDisable(bMGPreviewerSource.getDisableAllAudioInClips());
        if (bMGPreviewerSource.getBgm() != null) {
            previewerSource2.setBgm(bMGPreviewerSource.getBgm().getUrl(), bMGPreviewerSource.getBgm().getSrcDuration(), bMGPreviewerSource.getBgm().getOffsetMsFirstTimePlaying(), bMGPreviewerSource.getBgmAudioWeight(), bMGPreviewerSource.getBgm().getVolume(), bMGPreviewerSource.getBgm().getAfadeInDurationMs(), bMGPreviewerSource.getBgm().getAfadeOutDurationMs());
        }
        BMGSourceClip[] clips = bMGPreviewerSource.getClips();
        int i3 = 0;
        while (i3 < clips.length) {
            if (clips[i3] instanceof FileSourceClip) {
                FileSourceClip fileSourceClip = (FileSourceClip) clips[i3];
                ClipTimeScale[] timeScales = fileSourceClip.getTimeScales();
                TimeScale[] timeScaleArr = null;
                if (timeScales != null && timeScales.length > 0) {
                    timeScaleArr = new TimeScale[timeScales.length];
                    for (int i4 = 0; i4 < timeScales.length; i4++) {
                        ClipTimeScale clipTimeScale = timeScales[i4];
                        TimeScale timeScale = new TimeScale(clipTimeScale.getStartTimeInSrc(), clipTimeScale.getEndTimeInSrc(), clipTimeScale.getScale(), clipTimeScale.getRepeatToFps(), clipTimeScale.isVideoKeyframeOnly());
                        timeScaleArr[i4] = timeScale;
                    }
                }
                previewerSource = previewerSource2;
                int i5 = i3;
                bMGSourceClipArr = clips;
                previewerSource.addFileClip((String[]) fileSourceClip.getUrls().toArray(), fileSourceClip.isHasAudio(), fileSourceClip.getStartTimeInSrc(), fileSourceClip.getEndTimeInSrc(), fileSourceClip.getSrcTotalDuration(), fileSourceClip.getEndCutscenesDurationMs(), timeScaleArr, fileSourceClip.getMuteBgmForRangeTimeScaleLessThan(), fileSourceClip.getAudioVolume(), fileSourceClip.getAfadeInDurationMs(), fileSourceClip.getAfadeOutDurationMs(), fileSourceClip.getMediaPartSizes(), fileSourceClip.getAmbientSoundWeight(), fileSourceClip.getVoiceWeight(), fileSourceClip.getVideoFramerate());
                i2 = i5;
            } else {
                i2 = i3;
                bMGSourceClipArr = clips;
                previewerSource = previewerSource2;
                if (bMGSourceClipArr[i2] instanceof ImageSourceClip) {
                    ImageSourceClip imageSourceClip = (ImageSourceClip) bMGSourceClipArr[i2];
                    previewerSource.addImage(imageSourceClip.getUrl(), imageSourceClip.getDuration(), imageSourceClip.getEndCutscenesDurationMs(), imageSourceClip.getFps(), imageSourceClip.getMediaPartSize());
                } else {
                    a.c(" other souceClip index ", i2, BMGConstants.TAG);
                }
            }
            i3 = i2 + 1;
            previewerSource2 = previewerSource;
            clips = bMGSourceClipArr;
        }
        PreviewerSource previewerSource3 = previewerSource2;
        BMGPreviewer bMGPreviewer = new BMGPreviewer(eglContextGroup2);
        bMGPreviewer.setSource(previewerSource3);
        bMGPreviewer.setCallback(new BMGPreviewerCallback() {
            public void onFrame(BMGPreviewer bMGPreviewer, VideoSampleGroup videoSampleGroup) {
                BMGPreviewerSession bMGPreviewerSession = BMGPreviewerSession.this;
                MediaSampleMeta meta = videoSampleGroup.getMeta();
                boolean isDebug = BMGPreviewerSession.this.isDebug();
                String str = BMGConstants.TAG;
                if (isDebug) {
                    String str2 = bMGPreviewer == bMGPreviewerSession.previewer ? "main" : bMGPreviewer == bMGPreviewerSession.mSubPreviewer ? "sub stream" : "others?";
                    StringBuilder b2 = a.b(str2, " src time ");
                    b2.append(meta.getSrcTsMs());
                    b2.append(" srcProgress ");
                    b2.append(meta.getSrcProgressTimeMs());
                    b2.append(" meta.getMediaTimeMs() ");
                    b2.append(meta.getMediaTimeMs());
                    b2.append(" session.getMaxEndPos() ");
                    b2.append(bMGPreviewerSession.getMaxEndPos());
                    Log.i(str, b2.toString());
                }
                if (meta.getMediaTimeMs() > bMGPreviewerSession.getMaxEndPos()) {
                    if (bMGPreviewer == bMGPreviewerSession.previewer) {
                        if (meta.getSrcSerialId() == bMGPreviewerSession.innerStatus.getSerialId() && !bMGPreviewerSession.innerStatus.getPlaybackFinish()) {
                            StringBuilder a2 = a.a("sample time reached end time: ");
                            a2.append(meta.getSrcSerialId());
                            Log.i(str, a2.toString());
                            bMGPreviewerSession.innerStatus.setPlaybackFinish(true);
                            bMGPreviewerSession.onComplete(meta.getSrcSerialId());
                        }
                    } else if (bMGPreviewer == bMGPreviewerSession.mSubPreviewer) {
                        Log.w(str, "sub stream seek exceed end but do nothing");
                    }
                    videoSampleGroup.free();
                    return;
                }
                if (bMGPreviewer == bMGPreviewerSession.previewer) {
                    BMGPreviewerSession.this.notifyFps(30);
                }
                bMGPreviewerSession.frameOutput.onFrame(videoSampleGroup);
            }

            public void onNotify(BMGPreviewer bMGPreviewer, int i2, int i3, int i4, String str, String str2) {
                BMGPreviewerSession bMGPreviewerSession = BMGPreviewerSession.this;
                if (bMGPreviewer == bMGPreviewerSession.previewer) {
                    switch (i2) {
                        case 1:
                            if (i3 != 0) {
                                bMGPreviewerSession.onFail(i3, str, str2);
                                return;
                            } else {
                                bMGPreviewerSession.onPrepareComplete();
                                return;
                            }
                        case 2:
                            bMGPreviewerSession.onComplete(i4);
                            return;
                        case 3:
                            bMGPreviewerSession.onSeek(i3, i4, str, str2);
                            return;
                        case 4:
                            bMGPreviewerSession.onFail(i3, str, str2);
                            return;
                        case 5:
                            bMGPreviewerSession.onReBuffer(i3, i4);
                            return;
                        case 6:
                            bMGPreviewerSession.onDecodeReport(i3, i4);
                            return;
                        default:
                            return;
                    }
                } else if (bMGPreviewer == bMGPreviewerSession.mSubPreviewer) {
                    switch (i2) {
                        case 1:
                            if (i3 != 0) {
                                bMGPreviewerSession.onSubStreamFail(i3, str, str2);
                                return;
                            } else {
                                bMGPreviewerSession.onSubStreamPrepareComplete();
                                return;
                            }
                        case 2:
                            Log.e(BMGConstants.TAG, "sub stream complete?");
                            return;
                        case 3:
                            bMGPreviewerSession.onSubStreamSeek(i3, i4, str, str2);
                            return;
                        case 4:
                            bMGPreviewerSession.onSubStreamFail(i3, str, str2);
                            return;
                        case 5:
                            bMGPreviewerSession.onSubStreamReBuffer(i3, i4);
                            return;
                        case 6:
                            bMGPreviewerSession.onSubStreamDecodeReport(i3, i4);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        return bMGPreviewer;
    }

    /* access modifiers changed from: private */
    public final double getMaxEndPos() {
        return this.playRange.getEndMs();
    }

    private final double getStartPos() {
        return this.playRange.getStartMs();
    }

    private boolean isPreviewerPrepared() {
        InnerStatus innerStatus2 = this.innerStatus;
        return innerStatus2 != null && innerStatus2.getPrepareComplete();
    }

    private boolean isSubPreviewerPrepared() {
        InnerStatus innerStatus2 = this.mSubInnerStatus;
        return innerStatus2 != null && innerStatus2.getPrepareComplete();
    }

    /* access modifiers changed from: private */
    public final void onPrepareComplete() {
        this.innerStatus.setPrepareComplete(true);
        this.mSessionCallback.onPrepared();
    }

    /* access modifiers changed from: private */
    public final void onSeek(int i2, int i3, String str, String str2) {
        this.mSessionCallback.onSeek(i2, i3, str, str2);
    }

    /* access modifiers changed from: private */
    public final void onSubStreamPrepareComplete() {
        this.mSubInnerStatus.setPrepareComplete(true);
        this.mSessionCallback.onSubStreamPrepared();
    }

    private final void savePosition() {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null && this.innerStatus.getPrepareComplete()) {
            this.state.setRestorePosition(bMGPreviewer.getPlayPosition().mediaTimeMs);
        }
    }

    private void updatePreviwerId(int i2) {
        this.innerStatus.setSerialId(i2);
    }

    private void updateSubPreviwerId(int i2) {
        this.mSubInnerStatus.setSerialId(i2);
    }

    public final void clearPreviewer() {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            bMGPreviewer.free();
            this.previewer = null;
        }
        BMGPreviewer bMGPreviewer2 = this.mSubPreviewer;
        if (bMGPreviewer2 != null) {
            bMGPreviewer2.free();
            this.mSubPreviewer = null;
        }
        this.innerStatus = new InnerStatus(false, false, 0);
        this.mSubInnerStatus = new InnerStatus(false, false, 0);
    }

    public final BMGPreviewerSource currentSource() {
        return this.source;
    }

    public double getClipEndTimeMsExcludeEndCutscenes(int i2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        String str = BMGConstants.TAG;
        if (bMGPreviewer != null) {
            if (!isPreviewerPrepared()) {
                Log.e(str, "getClipEndTimeMsExcludeEndCutscenes before prepared ");
            }
            return this.previewer.getClipEndTimeMsExcludeEndCutscenes(i2);
        }
        Log.e(str, " getClipEndTimeMsExcludeEndCutscenes before previewer create");
        return -1.0d;
    }

    public double getDuration() {
        if (!isPreviewerPrepared()) {
            Log.e(BMGConstants.TAG, "getDuration before prepared ");
        }
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            return bMGPreviewer.getDuration();
        }
        return 0.0d;
    }

    public final EglContextGroup getEglContextGroup() {
        return this.eglContextGroup;
    }

    public final EndBehaviour getEndBehaviour() {
        return this.endBehavior;
    }

    public final PlayRange getPlayRange() {
        return this.playRange;
    }

    public PlaybackProgress getPlaybackProgress() {
        if (this.previewer != null) {
            if (!isPreviewerPrepared()) {
                Log.e(BMGConstants.TAG, "getPlaybackProgress before prepared ");
            }
            PlayPosition playPosition = this.previewer.getPlayPosition();
            if (playPosition != null) {
                HashMap<String, PlayTrackPosition> hashMap = playPosition.trackPositions;
                if (hashMap != null) {
                    String str = TrackName.VIDEO;
                    if (hashMap.containsKey(str)) {
                        Object obj = playPosition.trackPositions.get(str);
                        if (obj != null) {
                            PlayTrackPosition playTrackPosition = (PlayTrackPosition) obj;
                            PlaybackProgress playbackProgress = new PlaybackProgress(playPosition.mediaTimeMs, playTrackPosition.clipIndex, playTrackPosition.timeMs);
                            return playbackProgress;
                        }
                        throw new IllegalArgumentException("trackPosition get video error");
                    }
                }
                return new PlaybackProgress(playPosition.mediaTimeMs);
            }
        }
        return new PlaybackProgress(0.0d);
    }

    public int getSubPreviewerUniqueId() {
        BMGPreviewer bMGPreviewer = this.mSubPreviewer;
        if (bMGPreviewer != null) {
            return bMGPreviewer.getSubPreviewerUniqueId();
        }
        return -1000;
    }

    public boolean isPlaying() {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            return bMGPreviewer.isPlaying();
        }
        return false;
    }

    public boolean isSeeking() {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            return bMGPreviewer.isSeeking();
        }
        return false;
    }

    public SrcPosition mapMediaTimeToSrcTime(double d2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        String str = BMGConstants.TAG;
        if (bMGPreviewer != null) {
            if (!isPreviewerPrepared()) {
                Log.e(str, "mapMediaTimeToSrcTime before prepared ");
            }
            return this.previewer.mapMediaTimeToSrcTime(d2);
        }
        Log.e(str, " mapSrcTimeToMediaTime before previewer create");
        return null;
    }

    public MediaPosition mapSrcTimeToMediaTime(int i2, double d2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        String str = BMGConstants.TAG;
        if (bMGPreviewer != null) {
            if (!isPreviewerPrepared()) {
                Log.e(str, "mapSrcTimeToMediaTime before prepared ");
            }
            return this.previewer.mapSrcTimeToMediaTime(i2, d2);
        }
        Log.e(str, " mapSrcTimeToMediaTime before previewer create");
        return null;
    }

    public final void onComplete(int i2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (!(bMGPreviewer == null || this.endBehavior == null)) {
            if (bMGPreviewer.getRequestSerial() != i2) {
                StringBuilder a2 = a.a("onComplete mismatch (");
                a2.append(this.previewer.getRequestSerial());
                a2.append(",");
                a2.append(i2);
                a2.append(")");
                Log.e(BMGConstants.TAG, a2.toString());
            } else if (this.endBehavior.equals(EndBehaviour.LOOP)) {
                if (!isSeeking()) {
                    seek(getStartPos());
                }
            } else if (this.endBehavior.equals(EndBehaviour.PAUSE_ON_FIRST_FRAME)) {
                pause();
                seek(getStartPos());
            } else {
                this.innerStatus.setPlaybackFinish(true);
                pause();
            }
        }
        super.onComplete(i2);
    }

    public void pause() {
        this.state.setResumed(false);
        setupPreviewer();
    }

    public void resume() {
        this.state.setResumed(true);
        setupPreviewer();
    }

    public int seek(int i2, double d2) {
        if (!isPreviewerPrepared()) {
            StringBuilder sb = new StringBuilder();
            sb.append("seek before prepared[ ");
            sb.append(i2);
            sb.append("] src time ");
            sb.append(d2);
            Log.e(BMGConstants.TAG, sb.toString());
        }
        MediaPosition mapSrcTimeToMediaTime = mapSrcTimeToMediaTime(i2, d2);
        if (mapSrcTimeToMediaTime != null) {
            return seek(mapSrcTimeToMediaTime.mediaTimeMs);
        }
        return -1;
    }

    public int seekSubStream(int i2, double d2) {
        MediaPosition mapSrcTimeToMediaTime = mapSrcTimeToMediaTime(i2, d2);
        if (mapSrcTimeToMediaTime != null) {
            return seekSubStream(mapSrcTimeToMediaTime.mediaTimeMs);
        }
        return -1;
    }

    public void setBgmWeight(double d2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            bMGPreviewer.setBgmWeight(d2);
        } else {
            Log.e(BMGConstants.TAG, " setBgmWeight when previewer null");
        }
    }

    public final void setEndBehaviour(EndBehaviour endBehaviour) {
        this.endBehavior = endBehaviour;
    }

    public void setForceVideoKeyFrameOnly(boolean z) {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            bMGPreviewer.setForceVideoKeyFrameOnly(z);
            BMGPreviewer bMGPreviewer2 = this.mSubPreviewer;
            if (bMGPreviewer2 != null) {
                bMGPreviewer2.setForceVideoKeyFrameOnly(z);
                return;
            }
            return;
        }
        Log.e(BMGConstants.TAG, " setForceVideoKeyFrameOnly when previewer null");
    }

    public void setFrameOutput(FrameOutput frameOutput) {
        if (frameOutput != this.frameOutput) {
            savePosition();
            this.frameOutput = frameOutput;
            if (frameOutput == null) {
                clearPreviewer();
            } else {
                setupPreviewer();
            }
        }
    }

    public final int setPlayRange(PlayRange playRange2) {
        int i2;
        this.playRange = playRange2;
        BMGPreviewer bMGPreviewer = this.previewer;
        String str = BMGConstants.TAG;
        if (bMGPreviewer == null || !bMGPreviewer.isPrepareActioned() || !isPreviewerPrepared()) {
            StringBuilder a2 = a.a(" set play range before");
            a2.append(this.previewer == null ? "preview null" : "prepared");
            Log.i(str, a2.toString());
            this.state.setRestorePosition(this.playRange.startMs);
        } else {
            if (this.previewer.getPlayPosition().mediaTimeMs < this.playRange.startMs) {
                StringBuilder a3 = a.a(" setPlayRange seek to start ");
                a3.append(this.playRange.startMs);
                Log.i(str, a3.toString());
                i2 = seek(this.playRange.startMs);
            } else if (this.previewer.getPlayPosition().mediaTimeMs > this.playRange.endMs) {
                StringBuilder a4 = a.a(" setPlayRange seek to end ");
                a4.append(this.playRange.endMs);
                Log.i(str, a4.toString());
                i2 = seek(this.playRange.endMs);
            }
            this.innerStatus.setPlaybackFinish(false);
            return i2;
        }
        i2 = -1;
        this.innerStatus.setPlaybackFinish(false);
        return i2;
    }

    public void setPlayRate(double d2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            bMGPreviewer.setPlayRate(d2);
            BMGPreviewer bMGPreviewer2 = this.mSubPreviewer;
            if (bMGPreviewer2 != null) {
                bMGPreviewer2.setPlayRate(d2);
                return;
            }
            return;
        }
        Log.e(BMGConstants.TAG, " setPlayRate when previewer null");
    }

    public void setVolume(double d2) {
        BMGPreviewer bMGPreviewer = this.previewer;
        if (bMGPreviewer != null) {
            bMGPreviewer.setVolume(d2);
            BMGPreviewer bMGPreviewer2 = this.mSubPreviewer;
            if (bMGPreviewer2 != null) {
                bMGPreviewer2.setVolume(d2);
                return;
            }
            return;
        }
        Log.e(BMGConstants.TAG, " setVolume when previewer null");
    }

    public final void setupPreviewer() {
        BMGPreviewerSource bMGPreviewerSource = this.source;
        if (bMGPreviewerSource != null && this.frameOutput != null) {
            if (this.previewer == null) {
                BMGPreviewer createPreviewer = createPreviewer(this.eglContextGroup, bMGPreviewerSource);
                this.previewer = createPreviewer;
                createPreviewer.setCacheDirectory(this.source.getCutSceneDir());
            }
            boolean isPrepareActioned = this.previewer.isPrepareActioned();
            String str = BMGConstants.TAG;
            if (!isPrepareActioned) {
                this.previewer.prepareAsync(this.state.getRestorePosition(), this.mPreviewerOptions);
                updatePreviwerId(this.previewer.getRequestSerial());
                StringBuilder a2 = a.a("preview prepare from ");
                a2.append(this.state.getRestorePosition());
                Log.i(str, a2.toString());
            }
            if (this.mSubSource != null) {
                if (this.mSubPreviewer == null) {
                    Log.i(str, " create sub previewer");
                    BMGPreviewer createPreviewer2 = createPreviewer(null, this.mSubSource);
                    this.mSubPreviewer = createPreviewer2;
                    createPreviewer2.setCacheDirectory(this.mSubSource.getCutSceneDir());
                }
                if (!this.mSubPreviewer.isPrepareActioned()) {
                    this.mSubPreviewer.prepareAsync(this.state.getRestorePosition(), this.mSubPreviewerOptions);
                    updateSubPreviwerId(this.mSubPreviewer.getRequestSerial());
                    StringBuilder a3 = a.a("preview sub prepare from ");
                    a3.append(this.state.getRestorePosition());
                    Log.i(str, a3.toString());
                }
            }
            if (!this.state.getResumed()) {
                savePosition();
                this.previewer.pause();
            } else if (!this.innerStatus.getPlaybackFinish()) {
                this.previewer.play();
            }
        }
    }

    public void terminate() {
        super.terminate();
        this.source = null;
    }

    public final void updateSource(BMGPreviewerSource bMGPreviewerSource, Options options, double d2, BMGPreviewerSource bMGPreviewerSource2, Options options2) {
        this.mPreviewerOptions = options;
        this.mSubPreviewerOptions = options2;
        updateSource(bMGPreviewerSource, false, d2, bMGPreviewerSource2);
    }

    public int seekSubStream(double d2) {
        boolean isSubPreviewerPrepared = isSubPreviewerPrepared();
        String str = BMGConstants.TAG;
        if (!isSubPreviewerPrepared) {
            StringBuilder sb = new StringBuilder();
            sb.append("seek sub stream before prepared media ms ");
            sb.append(d2);
            Log.e(str, sb.toString());
        }
        if (this.mSubPreviewer == null) {
            return -1;
        }
        this.mSubInnerStatus.setPlaybackFinish(false);
        int seek = this.mSubPreviewer.seek(d2);
        if (d2 > getMaxEndPos()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" seek sub exceed (");
            sb2.append(d2);
            sb2.append(">");
            sb2.append(getMaxEndPos());
            sb2.append(")");
            Log.e(str, sb2.toString());
        }
        updateSubPreviwerId(seek);
        if (!isDebug()) {
            return seek;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" seek sub id ");
        sb3.append(seek);
        sb3.append(" mediaTimeMs ");
        sb3.append(d2);
        Log.i(str, sb3.toString());
        return seek;
    }

    private final void updateSource(BMGPreviewerSource bMGPreviewerSource, boolean z, double d2, BMGPreviewerSource bMGPreviewerSource2) {
        BMGPreviewerSource bMGPreviewerSource3 = this.source;
        String str = BMGConstants.TAG;
        if (bMGPreviewerSource3 != bMGPreviewerSource) {
            if (z) {
                savePosition();
            } else if (d2 >= 0.0d) {
                StringBuilder sb = new StringBuilder();
                sb.append("previewer start from resumePosition ");
                sb.append(d2);
                Log.i(str, sb.toString());
                this.state.setRestorePosition(d2);
            } else {
                this.state.setRestorePosition(getStartPos());
            }
            this.source = bMGPreviewerSource;
            this.mSubSource = bMGPreviewerSource2;
            if (bMGPreviewerSource2 == null) {
                Log.i(str, " no sub stream");
            }
            clearPreviewer();
            setupPreviewer();
            return;
        }
        Log.e(str, " same BMGPreviewerSource");
        if (this.mSubSource != bMGPreviewerSource2) {
            Log.e(str, " sub source not same");
        } else {
            Log.e(str, " sub source same");
        }
    }

    public int seek(double d2) {
        boolean isPreviewerPrepared = isPreviewerPrepared();
        String str = BMGConstants.TAG;
        if (!isPreviewerPrepared) {
            StringBuilder sb = new StringBuilder();
            sb.append("seek before prepared media ms ");
            sb.append(d2);
            Log.e(str, sb.toString());
        }
        if (this.previewer == null) {
            return -1;
        }
        this.innerStatus.setPlaybackFinish(false);
        int seek = this.previewer.seek(d2);
        if (d2 > getMaxEndPos()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" seek exceed (");
            sb2.append(d2);
            sb2.append(">");
            sb2.append(getMaxEndPos());
            sb2.append(")");
            Log.e(str, sb2.toString());
        }
        updatePreviwerId(seek);
        if (!isDebug()) {
            return seek;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" seek id ");
        sb3.append(seek);
        sb3.append(" mediaTimeMs ");
        sb3.append(d2);
        Log.i(str, sb3.toString());
        return seek;
    }
}
